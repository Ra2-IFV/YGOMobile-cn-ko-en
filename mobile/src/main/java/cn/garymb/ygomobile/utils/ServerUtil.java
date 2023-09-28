package cn.garymb.ygomobile.utils;

import static cn.garymb.ygomobile.Constants.ASSET_SERVER_LIST;
import static cn.garymb.ygomobile.Constants.URL_YGO233_DATAVER;
import static cn.garymb.ygomobile.utils.StringUtils.isHost;
import static cn.garymb.ygomobile.utils.StringUtils.isNumeric;
import static cn.garymb.ygomobile.utils.StringUtils.isValidIP;

import android.content.Context;
import android.text.TextUtils;

import com.file.zip.ZipEntry;
import com.file.zip.ZipFile;

import org.greenrobot.eventbus.EventBus;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import cn.garymb.ygomobile.Constants;
import cn.garymb.ygomobile.bean.ServerInfo;
import cn.garymb.ygomobile.bean.ServerList;
import cn.garymb.ygomobile.bean.events.ExCardEvent;
import cn.garymb.ygomobile.lite.BuildConfig;
import cn.garymb.ygomobile.ui.home.ServerListManager;
import cn.garymb.ygomobile.ui.plus.VUiKit;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class ServerUtil {
    private static final String TAG = ServerUtil.class.getSimpleName();

    public enum ExCardState {
        /* 已安装最新版扩展卡，扩展卡不是最新版本，无法查询到服务器版本 */
        UNCHECKED, UPDATED, NEED_UPDATE, ERROR
    }

    /* 存储了当前先行卡是否需要更新的状态，UI逻辑直接读取该变量就能获知是否已安装先行卡 */
    public volatile static ExCardState exCardState = ExCardState.UNCHECKED;//TODO 可能有并发问题
    public volatile static String serverExCardVersion = "";
    private volatile static int failCounter = 0;

    /**
     * 初始化本地先行卡版本的状态，
     * 比对服务器的先行卡版本号与本地先行卡版本号，
     * 更新全局变量exCardVersion（如删除先行卡、重新安装先行卡等）
     */
    public static void initExCardState() {
        String oldVer = SharedPreferenceUtil.getExpansionDataVer();
        LogUtil.i(TAG, "server util, old pre-card version:" + oldVer);
        OkhttpUtil.get(URL_YGO233_DATAVER, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                exCardState = ExCardState.ERROR;
                serverExCardVersion = "";
                LogUtil.e(TAG, BuildConfig.VERSION_NAME);
                LogUtil.i(TAG, "network failed, pre-card version:" + exCardState);
                if (failCounter < 10) {
                    LogUtil.i(TAG, "network failed, retry fetch pre-card version:");
                    failCounter++;
                    initExCardState();
                }
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                failCounter = 0;//充值计数器
                String newVer = response.body().string();
                serverExCardVersion = newVer;

                LogUtil.i(TAG, "ServerUtil fetch pre-card version:" + newVer);
                if (!TextUtils.isEmpty(newVer)) {

                    if (!newVer.equals(oldVer)) {//如果oldVer为null，也会触发
                        exCardState = ExCardState.NEED_UPDATE;
                    } else {
                        exCardState = ExCardState.UPDATED;
                    }
                } else {
                    exCardState = ExCardState.ERROR;
                }

                /* 通知homeFragment更新图标 */
                EventBus.getDefault().postSticky(new ExCardEvent(ExCardEvent.EventType.exCardPackageChange));
            }
        });
    }

    /**
     * 解析zip或者ypk的file下内置的txt文件里的服务器name、host、prot
     *
     * @param context
     * @param file
     */
    public static void loadServerInfoFromZipOrYpk(Context context, File file) {
        if (file.getName().endsWith(".zip") || file.getName().endsWith(".ypk")) {
            LogUtil.e("GameUriManager", "读取压缩包");
            try {
                String serverName = null, serverHost = null, serverPort = null;
                ZipFile zipFile = new ZipFile(file.getAbsoluteFile(), "GBK");
                Enumeration<ZipEntry> entris = zipFile.getEntries();
                ZipEntry entry;
                StringBuilder content = new StringBuilder();
                while (entris.hasMoreElements()) {
                    entry = entris.nextElement();
                    if (!entry.isDirectory()) {
                        if (entry.getName().endsWith(".ini")) {
                            InputStreamReader in = new InputStreamReader(zipFile.getInputStream(entry), StandardCharsets.UTF_8);
                            BufferedReader reader = new BufferedReader(in);
                            String line = null;
                            while ((line = reader.readLine()) != null) {
                                if (line.startsWith("[YGOProExpansionPack]") ||
                                        line.startsWith("FileName") ||
                                        line.startsWith("PackName") ||
                                        line.startsWith("PackAuthor") ||
                                        line.startsWith("PackHomePage") ||
                                        line.startsWith("[YGOMobileAddServer]")) {
                                    continue;
                                }
                                if (line.startsWith("ServerName")) {
                                    String[] words = line.trim().split("[\t| =]+");
                                    if (words.length >= 2) {
                                        serverName = words[1];
                                    }
                                }
                                if (line.startsWith("ServerHost")) {
                                    String[] words = line.trim().split("[\t| =]+");
                                    if (words.length >= 2) {
                                        serverHost = words[1];
                                    }
                                }
                                if (line.startsWith("ServerPort")) {
                                    String[] words = line.trim().split("[\t| =]+");
                                    if (words.length >= 2) {
                                        serverPort = words[1];
                                    }
                                }
                            }
                        }

                    }
                }
                if (serverName != null && (isHost(serverHost) || isValidIP(serverHost)) && isNumeric(serverPort)) {
                    AddServer(context, serverName, serverHost, Integer.valueOf(serverPort), "Knight of Hanoi");
                } else {
                    YGOUtil.showTextToast("can't parse ex-server properly");
                }
                LogUtil.w("seesee", serverName + isHost(serverHost) + serverHost + isNumeric(serverPort) + serverPort);
                zipFile.close();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 从资源文件serverlist.xml（或本地文件server_list.xml)解析服务器列表，并将新添加的服务器信息（name，addr，port）合并到服务器列表中。
     *
     * @param name
     * @param Addr
     * @param port
     * @param playerName
     */
    public static void AddServer(Context context, String name, String Addr, int port, String playerName) {
        File xmlFile = new File(context.getFilesDir(), Constants.SERVER_FILE);//读取文件路径下的server_list.xml
        List<ServerInfo> serverInfos = new ArrayList<>();
        ServerInfo mServerInfo = new ServerInfo();
        mServerInfo.setName(name);
        mServerInfo.setServerAddr(Addr);
        mServerInfo.setPort(port);
        mServerInfo.setPlayerName(playerName);
        VUiKit.defer().when(() -> {
            /* 读取本地文件server_list.xml和资源文件（assets）下的serverlist.xml，返回其中版本最新的 */
            ServerList assetList = ServerListManager.readList(context.getAssets().open(ASSET_SERVER_LIST));//读取serverlist.xml文件
            ServerList fileList = xmlFile.exists() ? ServerListManager.readList(new FileInputStream(xmlFile)) : null;
            if (fileList == null) {
                return assetList;
            }
            if (fileList.getVercode() < assetList.getVercode()) {
                xmlFile.delete();
                return assetList;
            }
            return fileList;
        }).done((list) -> {
            if (list != null) {
                serverInfos.clear();
                serverInfos.addAll(list.getServerInfoList());
                boolean hasServer = false;
                for (int i = 0; i < list.getServerInfoList().size(); i++) {
                    if (mServerInfo.getName() != serverInfos.get(i).getName() && mServerInfo.getServerAddr() != serverInfos.get(i).getServerAddr()) {//判断服务器名称、域名IP不同则视为不存在
                        continue;
                    } else {
                        hasServer = true;
                        break;
                    }

                }
                if (!hasServer && !serverInfos.contains(mServerInfo)) {
                    serverInfos.add(mServerInfo);
                }
                saveItems(context, xmlFile, serverInfos);
            }
        });
    }

    /**
     * 将最新的服务器列表存储到本地文件server_list.xml中
     */
    public static void saveItems(Context context, File xmlFile, List<ServerInfo> serverInfos) {
        OutputStream outputStream = null;
        try {
            outputStream = new FileOutputStream(xmlFile);
            XmlUtils.get().saveXml(new ServerList(SystemUtils.getVersion(context), serverInfos), outputStream);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            IOUtils.close(outputStream);
        }
    }

    public static boolean isPreServer(int port, String addr) {
        return (port == Constants.PORT_YGO233 && addr.equals(Constants.URL_YGO233_1)) ||
                (port == Constants.PORT_YGO233 && addr.equals(Constants.URL_YGO233_2));
    }


}
