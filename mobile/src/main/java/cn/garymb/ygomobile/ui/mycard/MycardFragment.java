package cn.garymb.ygomobile.ui.mycard;

import static android.app.Activity.RESULT_OK;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.ClipData;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.ourygo.assistant.util.Util;
import com.tencent.smtt.sdk.ValueCallback;
import com.tencent.smtt.sdk.WebChromeClient;
import com.tencent.smtt.sdk.WebSettings;
import com.tencent.smtt.sdk.WebView;

import java.text.MessageFormat;
import java.util.List;

import cn.garymb.ygomobile.YGOStarter;
import cn.garymb.ygomobile.base.BaseFragemnt;
import cn.garymb.ygomobile.lite.BuildConfig;
import cn.garymb.ygomobile.lite.R;
import cn.garymb.ygomobile.ui.mycard.base.OnJoinChatListener;
import cn.garymb.ygomobile.ui.mycard.mcchat.ChatListener;
import cn.garymb.ygomobile.ui.mycard.mcchat.ChatMessage;
import cn.garymb.ygomobile.ui.mycard.mcchat.SplashActivity;
import cn.garymb.ygomobile.ui.mycard.mcchat.management.ServiceManagement;
import cn.garymb.ygomobile.utils.glide.GlideCompat;

public class MycardFragment extends BaseFragemnt implements View.OnClickListener, MyCard.MyCardListener, OnJoinChatListener, ChatListener {
    private static final int FILECHOOSER_RESULTCODE = 10;
    private static final int TYPE_MC_LOGIN = 0;
    //头像昵称账号
    private ImageView mHeadView;
    private TextView mNameView, mStatusView;
    private TextView tv_back_mc;
    //萌卡webview
    private MyCardWebView mWebViewPlus;
    private MyCard mMyCard;
    //聊天室
    private RelativeLayout rl_chat;
    private TextView tv_message;
    private ProgressBar pb_chat_loading;
    private ServiceManagement serviceManagement;
    private ChatMessage currentMessage;

    @SuppressLint("HandlerLeak")
    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (msg.what == TYPE_MC_LOGIN) {
                String[] ss = (String[]) msg.obj;
                if (!TextUtils.isEmpty(ss[1])) {
                    GlideCompat.with(getActivity()).load(Uri.parse(ss[1])).into(mHeadView);
                }
                mNameView.setText(ss[0]);
                mStatusView.setText(ss[2]);
            }
        }
    };
    private ProgressBar mProgressBar;
    private ValueCallback<Uri> uploadMessage;
    private ValueCallback<Uri[]> mUploadCallbackAboveL;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View view;
        view = inflater.inflate(R.layout.fragment_mycard, container, false);
        initView(view);
        return view;
    }

    public void initView(View view) {
        YGOStarter.onCreated(getActivity());
        mMyCard = new MyCard(getActivity());
        mWebViewPlus = view.findViewById(R.id.webbrowser);
        mProgressBar = view.findViewById(R.id.progressBar);
        mProgressBar.setMax(100);
        tv_back_mc = view.findViewById(R.id.tv_back_mc);
        tv_back_mc.setOnClickListener(this);

        mHeadView = view.findViewById(R.id.img_head);
        mNameView = view.findViewById(R.id.tv_name);
        mStatusView = view.findViewById(R.id.tv_dp);
        //mWebViewPlus.enableHtml5();

        rl_chat = view.findViewById(R.id.rl_chat);
        rl_chat.setOnClickListener(this);
        tv_message = view.findViewById(R.id.tv_message);
        pb_chat_loading = view.findViewById(R.id.pb_chat_loading);
        serviceManagement = ServiceManagement.getDx();
        serviceManagement.addJoinRoomListener(this);
        serviceManagement.addListener(this);

        WebSettings settings = mWebViewPlus.getSettings();
        settings.setUserAgentString(settings.getUserAgentString() + MessageFormat.format(
                " YGOMobile/{0} ({1} {2,number,#})",
                BuildConfig.VERSION_NAME,
                BuildConfig.APPLICATION_ID,
                BuildConfig.VERSION_CODE
        ));

        mWebViewPlus.setWebChromeClient(new WebChromeClient() {
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                if (newProgress == 100) {
                    mProgressBar.setVisibility(View.GONE);
                    if (view.getUrl().contains(mMyCard.getMcHost()))
                        tv_back_mc.setVisibility(View.GONE);
                    else
                        tv_back_mc.setVisibility(View.VISIBLE);
                } else {
                    if (View.GONE == mProgressBar.getVisibility()) {
                        mProgressBar.setVisibility(View.VISIBLE);
                    }
                    mProgressBar.setProgress(newProgress);
                }
                super.onProgressChanged(view, newProgress);
            }

            @Override
            public void openFileChooser(ValueCallback<Uri> valueCallback, String acceptType, String capture) {
                uploadMessage = valueCallback;
                Intent i = new Intent(Intent.ACTION_GET_CONTENT);
                i.addCategory(Intent.CATEGORY_OPENABLE);
                i.setType("*/*");
                startActivityForResult(Intent.createChooser(i, "File Browser"), FILECHOOSER_RESULTCODE);

            }

            @Override
            public boolean onShowFileChooser(WebView webView, ValueCallback<Uri[]> valueCallback, FileChooserParams fileChooserParams) {
                mUploadCallbackAboveL = valueCallback;
                Intent i = new Intent(Intent.ACTION_GET_CONTENT);
                i.addCategory(Intent.CATEGORY_OPENABLE);
                i.setType("*/*");
                startActivityForResult(
                        Intent.createChooser(i, "File Browser"),
                        FILECHOOSER_RESULTCODE);

                return true;
            }
        });
        mMyCard.attachWeb(mWebViewPlus, this);
        mWebViewPlus.loadUrl(mMyCard.getHomeUrl());
    }

    @Override
    public void onResume() {
        YGOStarter.onResumed(getActivity());
        super.onResume();
    }

    @Override
    public void onDestroy() {
        mWebViewPlus.stopLoading();
        //mWebViewPlus.onDestroy();
        YGOStarter.onDestroy(getActivity());
        super.onDestroy();
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == FILECHOOSER_RESULTCODE) {
            if (null == uploadMessage && null == mUploadCallbackAboveL) return;
            Uri result = data == null || resultCode != RESULT_OK ? null : data.getData();
            if (mUploadCallbackAboveL != null) {
                onActivityResultAboveL(requestCode, resultCode, data);
            } else if (uploadMessage != null) {
                uploadMessage.onReceiveValue(result);
                uploadMessage = null;
            }
        }
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    private void onActivityResultAboveL(int requestCode, int resultCode, Intent data) {
        if (requestCode != FILECHOOSER_RESULTCODE
                || mUploadCallbackAboveL == null) {
            return;
        }
        Uri[] results = null;
        if (resultCode == RESULT_OK) {
            if (data != null) {
                String dataString = data.getDataString();
                ClipData clipData = data.getClipData();
                if (clipData != null) {
                    results = new Uri[clipData.getItemCount()];
                    for (int i = 0; i < clipData.getItemCount(); i++) {
                        ClipData.Item item = clipData.getItemAt(i);
                        results[i] = item.getUri();
                    }
                }
                if (dataString != null)
                    results = new Uri[]{Uri.parse(dataString)};
            }
        }
        mUploadCallbackAboveL.onReceiveValue(results);
        mUploadCallbackAboveL = null;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (doMenu(item.getItemId())) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private boolean doMenu(int id) {
        switch (id) {
            case R.id.action_home:
                onHome();
                break;/*
            case R.id.action_arena:
                mWebViewPlus.loadUrl(mMyCard.getArenaUrl());
                break;
            case R.id.action_bbs:
                mWebViewPlus.loadUrl(mMyCard.getBBSUrl());
                break;*/

            default:
                return false;
        }
        return true;
    }

    /**
     * 第一次fragment可见（进行初始化工作）
     */
    @Override
    public void onFirstUserVisible() {

    }

    /**
     * fragment可见（切换回来或者onResume）
     */
    @Override
    public void onUserVisible() {

    }

    /**
     * 第一次fragment不可见（不建议在此处理事件）
     */
    @Override
    public void onFirstUserInvisible() {

    }

    /**
     * fragment不可见（切换掉或者onPause）
     */
    @Override
    public void onUserInvisible() {

    }

    @Override
    public void onBackHome() {

    }

    @Override
    public void onBackPressed() {
        if (mWebViewPlus.getUrl().equals(mMyCard.getMcMainUrl())) {
            return;
        }
        if (mWebViewPlus.canGoBack()) {
            mWebViewPlus.goBack();
        } else {
        }
    }

    /**
     * Called when a view has been clicked.
     *
     * @param v The view that was clicked.
     */
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_back_mc:
                onHome();
                break;
            case R.id.rl_chat:
                startActivity(new Intent(getActivity(), SplashActivity.class));
                break;
        }
    }

    @Override
    public void onLogin(String name, String icon, String statu) {
        Message message = new Message();
        message.obj = new String[]{name, icon, statu};
        message.what = TYPE_MC_LOGIN;
        handler.sendMessage(message);
    }

    @Override
    public void backHome() {

    }

    @Override
    public void share(String text) {
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_SUBJECT, "分享");
        intent.putExtra(Intent.EXTRA_TEXT, text);
        intent.putExtra(Intent.EXTRA_TITLE, getString(R.string.app_name));
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(Intent.createChooser(intent, "请选择"));
    }

    @Override
    public void onHome() {
        mWebViewPlus.loadUrl(mMyCard.getHomeUrl());
    }

    @Override
    public void onChatLogin(String exception) {
        Log.e("MyCardFragment", "登录情况" + exception);
        pb_chat_loading.setVisibility(View.GONE);
        if (TextUtils.isEmpty(exception)) {
            if (currentMessage == null) {
                List<ChatMessage> data = serviceManagement.getData();
                if (data != null && data.size() > 0)
                    currentMessage = data.get(data.size() - 1);
            }
            if (currentMessage == null)
                tv_message.setText("聊天信息加载中");
            else
                tv_message.setText(currentMessage.getName() + "：" + currentMessage.getMessage());
        } else {
            tv_message.setText(R.string.logining_failed);
        }
    }

    @Override
    public void onChatLoginLoading() {
        Log.e("MyCardFragment", "加载中");
        pb_chat_loading.setVisibility(View.VISIBLE);
        tv_message.setText(R.string.logining_in);
    }

    @Override
    public void onJoinRoomLoading() {
        Log.e("MyCardFragment", "加入房间中");
        pb_chat_loading.setVisibility(View.VISIBLE);
        tv_message.setText(R.string.logining_in);
    }

    @Override
    public void onChatUserNull() {
        Log.e("MyCardFragment", "为空");
        pb_chat_loading.setVisibility(View.GONE);
        tv_message.setText("登录失败，请退出登录后重新登录");
    }

    @Override
    public boolean isListenerEffective() {
        return Util.isContextExisted(getActivity());
    }

    @Override
    public void addChatMessage(ChatMessage message) {
        currentMessage = message;
        if (message != null)
            tv_message.setText(message.getName() + "：" + message.getMessage());
    }

    @Override
    public void removeChatMessage(ChatMessage message) {

    }

    @Override
    public void reChatLogin(boolean state) {
        pb_chat_loading.setVisibility(View.VISIBLE);
        if (state) {
            tv_message.setText("登录成功");
        } else {
            tv_message.setText("连接断开,重新登录中……");
        }
    }

    @Override
    public void reChatJoin(boolean state) {
        pb_chat_loading.setVisibility(View.VISIBLE);
        if (state) {
            onChatLogin(null);
        } else {
            tv_message.setText("重新加入聊天室中……");
        }
    }
}
