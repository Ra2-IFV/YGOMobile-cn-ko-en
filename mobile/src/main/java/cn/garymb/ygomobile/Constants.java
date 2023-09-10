package cn.garymb.ygomobile;

import android.os.Environment;
import android.view.Gravity;

import cn.garymb.ygomobile.lite.BuildConfig;

public interface Constants {
    boolean DEBUG = BuildConfig.DEBUG;
    String PREF_START = "game_pref_";
    String PREF_LAST_DECK_PATH = "pref_last_deck_path";
    String PREF_LAST_YDK = "pref_last_ydk";
    String PREF_DEF_LAST_YDK = "new";
    String PREF_LAST_CATEGORY = "pref_last_category";
    String PREF_DEF_LAST_CATEGORY = "newcate";
    String PREF_GAME_PATH = "pref_key_game_res_path";
    String PREF_DEF_GAME_DIR = "ygocore";

    String PREF_GAME_VERSION = "game_version";

    String PREF_IMAGE_QUALITY = "pref_key_game_image_quality";
    int PREF_DEF_IMAGE_QUALITY = 1;
    String PREF_DATA_LANGUAGE = "pref_key_game_data_language";
    int PREF_DEF_DATA_LANGUAGE = -1;
    String PREF_GAME_FONT = "pref_key_game_font_name";
    String PREF_USE_EXTRA_CARD_CARDS = "settings_game_diy_card_db";
    boolean PREF_DEF_USE_EXTRA_CARD_CARDS = true;
    String PREF_FONT_ANTIALIAS = "pref_key_game_font_antialias";
    boolean PREF_DEF_FONT_ANTIALIAS = true;
    String PREF_OPENGL_VERSION = "pref_key_game_ogles_config";
    int PREF_DEF_OPENGL_VERSION = 1;
    String PREF_PENDULUM_SCALE = "pref_key_game_lab_pendulum_scale";
    boolean PREF_DEF_PENDULUM_SCALE = true;
    String PREF_START_SERVICEDUELASSISTANT = "pref_key_start_serviceduelassistant";
    boolean PREF_DEF_START_SERVICEDUELASSISTANT = true;
    String PREF_LOCK_SCREEN = "pref_key_game_screen_orientation";
    boolean PREF_DEF_LOCK_SCREEN = false;
    String PREF_IMMERSIVE_MODE = "pref_key_immersive_mode";
    boolean PREF_DEF_IMMERSIVE_MODE = false;
    String PREF_SENSOR_REFRESH = "pref_key_sensor_refresh";
    boolean PREF_DEF_SENSOR_REFRESH = true;
    String PREF_CHANGE_LOG = "pref_key_change_log";
    String PREF_CHECK_UPDATE = "pref_key_about_check_update";
    String PREF_RESET_GAME_RES = "pref_key_reset_game_res";
    String PREF_JOIN_QQ = "pref_key_join_qq";
    String PREF_DEL_EX = "pref_key_settings_delete_ex";
    String PREF_LAST_ROOM_LIST = "pref_key_lastroom_list";
    String PERF_TEST_REPLACE_KERNEL = "pref_key_test_replace_kernel";
    int LAST_ROOM_MAX = 10;
    /***
     * 卡组编辑，长按删除对话框
     */
    String PREF_DECK_DELETE_DILAOG = "pref_key_deck_delete_dialog";
    boolean PREF_DEF_DECK_DELETE_DILAOG = true;

    String SETTINGS_COVER = "settings_game_diy_card_cover";
    String SETTINGS_AVATAR = "settings_game_avatar";
    String SETTINGS_CARD_BG = "settings_game_diy_card_bg";
    String ASSETS_EN = "en/";
    String ASSETS_KOR = "kor/";
    String ASSETS_PATH = "data/";
    String ASSET_SERVER_LIST = "serverlist.xml";
    String ASSET_LIMIT_PNG = ASSETS_PATH + "textures/lim.png";
    String DEFAULT_FONT_NAME = "ygo.ttf";
    String DATABASE_NAME = "cards.cdb";
    String BOT_CONF = "bot.conf";
    String WINDBOT_PATH = "windbot";
    String WINDBOT_DECK_PATH = "Decks";
    String FONT_DIRECTORY = "fonts";
    String CORE_STRING_PATH = "strings.conf";
    String CORE_LIMIT_PATH = "lflist.conf";
    String CORE_CUSTOM_LIMIT_PATH = "expansions/lflist.conf";
    String CORE_CUSTOM_STRING_PATH = "pre-strings.conf";
    String CORE_SYSTEM_PATH = "system.conf";
    String CORE_BOT_CONF_PATH = "bot.conf";
    String CORE_SOUND_PATH = "sound";
    String CORE_SKIN_PATH = "textures";
    String CORE_SKIN_PENDULUM_PATH = CORE_SKIN_PATH + "/extra";
    String CORE_DECK_PATH = "deck";
    String CORE_PACK_PATH = "pack";
    String CORE_EXPANSIONS = "expansions";
    String CORE_SINGLE_PATH = "single";
    String CORE_IMAGE_PATH = "pics";
    String MOBILE_LOG = "log";
    String MOBILE_DECK_SHARE = "deckShare";
    String CORE_EXPANSIONS_IMAGE_PATH = "expansions/pics";
    String CORE_IMAGE_FIELD_PATH = "field";
    String CORE_SCRIPT_PATH = "script";
    String CORE_REPLAY_PATH = "replay";
    String CORE_SCRIPTS_ZIP = "scripts.zip";
    String CORE_PICS_ZIP = "pics.zip";
    String CORE_SKIN_COVER = "cover.jpg";
    String CORE_SKIN_COVER2 = "cover2.jpg";
    String CORE_SKIN_BG = "bg.jpg";
    String CORE_SKIN_BG_MENU = "bg_menu.jpg";
    String CORE_SKIN_BG_DECK = "bg_deck.jpg";
    String CORE_SKIN_AVATAR_ME = "me.jpg";
    String CORE_SKIN_AVATAR_OPPONENT = "opponent.jpg";
    String UNKNOWN_IMAGE = "unknown.jpg";
    String YDK_FILE_EX = ".ydk";
    int[] CORE_SKIN_BG_SIZE = new int[]{1920, 1080};

    int[] CORE_SKIN_CARD_MINI_SIZE = new int[]{44, 64};
    int[] CORE_SKIN_CARD_SMALL_SIZE = new int[]{177, 254};
    //原图
    int[] CORE_SKIN_CARD_MIDDLE_SIZE = new int[]{397, 578};

    int[] CORE_SKIN_CARD_COVER_SIZE = new int[]{200, 290};
    int[] CORE_SKIN_AVATAR_SIZE = new int[]{128, 128};
    boolean SUPPORT_BPG = true;
    String BPG = ".bpg";
    int CARD_MAX_COUNT = 3;
    String[] IMAGE_EX = SUPPORT_BPG ? new String[]{".bpg", ".jpg", ".png"}
            : new String[]{".jpg", ".png"};

    String[] FILE_IMAGE_EX = new String[]{".bmp", ".jpg", ".png", ".gif"};

    String PREF_FONT_SIZE = "pref_settings_font_size";
    int DEF_PREF_FONT_SIZE = 14;

    String PREF_NOTCH_HEIGHT = "pref_notch_height";
    int DEF_PREF_NOTCH_HEIGHT = 0;

    String PREF_ONLY_GAME = "pref_settings_only_game";
    boolean DEF_PREF_ONLY_GAME = false;

    String PREF_READ_EX = "pref_settings_read_ex";
    boolean DEF_PREF_READ_EX = true;

    String PREF_KEEP_SCALE = "pref_settings_keep_scale";
    boolean DEF_PREF_KEEP_SCALE = false;

    //dp单位，游戏高度减少，留空白
    String PREF_WINDOW_TOP_BOTTOM = "pref_settings_window_top_bottom";
    int DEF_PREF_WINDOW_TOP_BOTTOM = 0;

    int REQUEST_CUT_IMG = 0x1000 + 0x10;
    int REQUEST_CHOOSE_FILE = 0x1000 + 0x20;
    int REQUEST_CHOOSE_IMG = 0x1000 + 0x21;
    int REQUEST_CHOOSE_FOLDER = 0x1000 + 0x22;
    int REQUEST_SETTINGS_CODE = 0x1000 + 0x23;

    int UNSORT_TIMES = 0x80;

    int CARD_RESULT_GRAVITY = Gravity.LEFT;
    int CARD_SEARCH_GRAVITY = Gravity.RIGHT;
    int DEFAULT_CARD_COUNT = 500;
    int DECK_WIDTH_MAX_COUNT = 15;
    int DECK_WIDTH_COUNT = 10;
    int DECK_MAIN_MAX = 60;
    int DECK_EXTRA_MAX = 15;
    int DECK_SIDE_MAX = 15;
    int DECK_EXTRA_COUNT = (DECK_SIDE_MAX / DECK_WIDTH_COUNT * DECK_WIDTH_COUNT < DECK_SIDE_MAX) ? DECK_WIDTH_COUNT * 2 : DECK_WIDTH_COUNT;
    int DECK_SIDE_COUNT = DECK_EXTRA_COUNT;
    String URL_HELP = "https://www.wolai.com/hgRyrSXQuq4rzMwzXhHBqA";
    String URL_DONATE = "https://afdian.net/@ygomobile";
    String URL_MASTER_RULE_CN = "https://ocg-rule.readthedocs.io/";
    String WIKI_SEARCH_URL = "https://ygocdb.com/card/";
    String URL_HOME_VERSION = "https://ygomobile.top/version.txt";
    String URL_YGO233_DOWNLOAD_LINK = "https://ygo233.com/download/ygomobile";
    String URL_YGO233_ADVANCE = "https://ygo233.com/pre";
    String URL_YGO233_DATAVER = "https://ygo233.com/pre/dataver";
    String URL_YGO233_FILE = "https://ygo233.com/pre/download-ygomobile";
    String URL_YGO233_FILE_ALT = "https://ygo233.com/pre/download-ygomobile/alt";
    String URL_YGO233_BUG_REPORT = "https://ygo233.com/bugs";
    int PORT_YGO233 = 23333;
    String URL_YGO233_1 = "s1.ygo233.com";
    String URL_YGO233_2 = "s2.ygo233.com";

    String SERVER_FILE = "server_list.xml";
    String SHARE_FILE = ".share_deck.png";

    //原目录文件路径
    String ORI_DECK = Environment.getExternalStorageDirectory() + "/" + Constants.PREF_DEF_GAME_DIR + "/" + Constants.CORE_DECK_PATH;
    String ORI_REPLAY = Environment.getExternalStorageDirectory() + "/" + Constants.PREF_DEF_GAME_DIR + "/" + Constants.CORE_REPLAY_PATH;
    String ORI_TEXTURES = Environment.getExternalStorageDirectory() + "/" + Constants.PREF_DEF_GAME_DIR + "/" + Constants.CORE_SKIN_PATH;
    String ORI_PICS = Environment.getExternalStorageDirectory() + "/" + Constants.PREF_DEF_GAME_DIR + "/" + Constants.CORE_IMAGE_PATH;

    long LOG_TIME = 2 * 1000;
    /***
     * 如果是双击显示，则单击拖拽
     */
    boolean DECK_SINGLE_PRESS_DRAG = true;

    /***
     * 长按删除
     */
    long LONG_PRESS_DRAG = 800;
    /***
     * adb shell am start -n cn.garymb.ygomobile/cn.garymb.ygomobile.ui.home.MainActivity -a ygomobile.intent.action.DECK --es android.intent.extra.TEXT 青眼白龙.ydk
     * <p>
     * adb shell am start -n cn.garymb.ygomobile/cn.garymb.ygomobile.ui.home.MainActivity -a ygomobile.intent.action.DECK --es android.intent.extra.TEXT /sdcard/ygocore/deck/青眼白龙.ydk
     */
    String ACTION_OPEN_DECK = "ygomobile.intent.action.DECK";
    /***
     * Intent intent1=new Intent("ygomobile.intent.action.GAME");
     * intent1.putExtra("host", "127.0.0.1");
     * intent1.putExtra("port", 233);
     * intent1.putExtra("user", "player");
     * intent1.putExtra("room", "room$123");
     * intent1.setPackage("cn.garymb.ygomobile");
     * startActivity(intent1);
     */
    String ACTION_OPEN_GAME = "ygomobile.intent.action.GAME";
    String ACTION_RELOAD = "ygomobile.intent.action.RELOAD";
    String IMAGE_URL = "https://github.com/fallenstardust/YGOMobile-pics/master/pics/%s.jpg";
    String IMAGE_FIELD_URL = "https://github.com/fallenstardust/YGOMobile-pics/master/pics/field/%s.jpg";
    String IMAGE_URL_EX = ".jpg";
    String IMAGE_FIELD_URL_EX = ".png";
    /**
     * https://m.ygomobile.com/deck?ydk=卡组名&main=124563789,12456487&extra=123,145&side=4564,4546
     * ygomobile://m.ygomobile.com/deck?ydk=卡组名&main=124563789,12456487&extra=123,145&side=4564,4546
     * <p>
     * https://m.ygomobile.com/game?host=127.0.0.1&port=233&user=player&room=1235$123
     * ygomobile://m.ygomobile.com/game?host=127.0.0.1&port=233&user=player&room=1235$123
     */
    String PATH_DECK = "/deck";
    String SCHEME_HTTP = "http";
    String SCHEME_HTTPS = "https";
    String SCHEME_APP = "http";
    String URI_HOST = "deck.ourygo.top";
    String URI_DECK = "deck";
    String URI_ROOM = "room";

    String QUERY_YDK = "ydk";
    String QUERY_NAME = "name";
    String PATH_ROOM = "/room";
    String QUERY_HOST = "host";
    String QUERY_PORT = "port";
    String QUERY_USER = "user";
    String QUERY_ROOM = "room";

    //额外的cdb
    boolean NETWORK_IMAGE = false;
    boolean SHOW_MYCARD = !"core".equals(BuildConfig.FLAVOR);

    //打开ydk，是否复制到文件夹
    boolean COPY_YDK_FILE = false;

    String TAG = "ygo-java";

    String DEF_ENCODING = "utf-8";


    /*23333先行密码与正式密码对照数组
     *来源网站：https://ygocdb.com/api/v0/idChangelogArray.jsonp
     */
    int[] oldIDsArray = {
            100200002, 100200201, 100200202, 100200203, 100200209, 100200210, 100200211, 100200212, 100200213, 100200214, 100200215, 100200216, 100200217, 100200218, 100200219, 100200220, 100200221, 100200222, 100200226, 100200227, 100200228, 100200229, 100200230, 100200231, 100200232, 100200233, 100200234, 100200235, 100200236, 100200237, 100205001, 100205002, 100206001, 100206002, 100206003, 100206004, 100206005, 100206006, 100206007, 100206008, 100206009, 100206010, 100207001, 100207002, 100207003, 100207004, 100207005, 100207006, 100207007, 100207008, 100207009, 100207010, 100207011, 100207012, 100207013, 100207014, 100207015, 100207016, 100207017, 100207018, 100207019, 100207020, 100207021, 100207022, 100207023, 100207024, 100207025, 100207026, 100207027, 100207028, 100207029, 100282002, 100283001, 100284001, 100284002, 100284003, 100285001, 100285002, 100285003, 100285004, 100285005, 100285006, 100286001, 100286002, 100286003, 100286004, 100286005, 100286006, 100286007, 100286008, 100286009, 100286010, 100286011, 100286012, 100286013, 100286014, 100286015, 100286016, 100286017, 100286018, 100286019, 100286020, 100287004, 100287005, 100287006, 100287007, 100287011, 100287012, 100287013, 100287014, 100287019, 100287020, 100287021, 100287022, 100287027, 100287028, 100287029, 100287030, 100287034, 100287035, 100287036, 100287037, 100287043, 100287044, 100287045, 100287046, 100288001, 100288002, 100289001, 100290001, 100290002, 100290003, 100290004, 100290005, 100290006, 100290007, 100290008, 100290009, 100290010, 100290011, 100290012, 100290013, 100290014, 100290015, 100290016, 100290017, 100290018, 100290019, 100290020, 100290021, 100290022, 100290023, 100290024, 100290025, 100290026, 100290027, 100290028, 100290029, 100290030, 100290031, 100290032, 100290033, 100290034, 100290035, 100290036, 100290037, 100290038, 100290039, 100290040, 100290041, 100290042, 100290043, 100290044, 100290045, 100290046, 100291001, 100291002, 100291003, 100292273, 100292274, 100292275, 100293096, 100293097, 100293098, 100293099, 100293100, 100294001, 100294002, 100294003, 100294004, 100294005, 100294006, 100295001, 100296001, 100296002, 100297001, 100297002, 100297003, 100297004, 100297005, 100297006, 100297007, 100297008, 100297009, 100297010, 100297011, 100297012, 100297013, 100297014, 100297015, 100297016, 100297017, 100297018, 100297019, 100298001, 100298002, 100298003, 100298004, 100298005, 100312001, 100312002, 100312022, 100312033, 100312040, 100312051, 100312052, 100312053, 100313001, 100313002, 100313003, 100313025, 100313026, 100313034, 100313051, 100313052, 100343001, 100343002, 100343003, 100343020, 100343021, 100343031, 100343032, 100343041, 100343042, 100344016, 100344017, 100344032, 100344033, 100344034, 100344051, 100344054, 100345001, 100345002, 100345023, 100345024, 100345027, 100345051, 100345052, 100345055, 100346002, 100346025, 100346026, 100346032, 100346033, 100346051, 100346201, 100346202, 100418011, 100418014, 100418015, 100418016, 100418017, 100418018, 100418019, 100418020, 100418021, 100418022, 100418023, 100418024, 100418025, 100418026, 100418027, 100418028, 100418029, 100418030, 100418031, 100418032, 100418033, 100418034, 100418035, 100418036, 100418037, 100418038, 100418039, 100418201, 100418202, 100418203, 100418204, 100418205, 100418206, 100418207, 100418208, 100418209, 100418210, 100418211, 100418212, 100419001, 100419002, 100419003, 100419004, 100419005, 100419006, 100419007, 100419008, 100419009, 100419010, 100419011, 100419012, 100419013, 100419014, 100419015, 100419016, 100419017, 100419018, 100419019, 100419020, 100419021, 100419022, 100419023, 100419024, 100419025, 100419026, 100419027, 100419028, 100419029, 100419030, 100419031, 100419032, 100419033, 100419034, 100419035, 100419036, 100420001, 100420002, 100420003, 100420004, 100420005, 100420006, 100420007, 100420016, 100420017, 100420018, 100420019, 100420020, 100420021, 100420022, 100420023, 100420024, 100420025, 100420026, 100420027, 100420029, 100420030, 100420031, 100420032, 100420033, 100420034, 100420035, 100420036, 100420037, 100420038, 100420039, 100420040, 100426001, 100426002, 100426003, 100426004, 100426005, 100426006, 100426007, 100426016, 100426017, 100426018, 100426019, 100426020, 100426021, 100426022, 100426031, 100426032, 100426033, 100426034, 100426035, 100426036, 100426037, 100427001, 100427002, 100427003, 100427004, 100427005, 100427006, 100427007, 100427021, 100427022, 100427023, 100427024, 100427025, 100427026, 100427027, 100427030, 100427031, 100427032, 100427033, 100427034, 100427035, 100427036, 100428001, 100428002, 100428003, 100428004, 100428005, 100428006, 100428007, 100428018, 100428019, 100428020, 100428021, 100428022, 100428023, 100428024, 100428032, 100428033, 100428034, 100428035, 100428036, 100428037, 100428038, 101106000, 101106001, 101106003, 101106004, 101106005, 101106006, 101106007, 101106008, 101106009, 101106010, 101106011, 101106012, 101106013, 101106014, 101106015, 101106016, 101106017, 101106018, 101106019, 101106020, 101106021, 101106022, 101106023, 101106024, 101106025, 101106026, 101106027, 101106028, 101106029, 101106030, 101106031, 101106032, 101106033, 101106034, 101106035, 101106037, 101106038, 101106039, 101106040, 101106041, 101106042, 101106043, 101106044, 101106045, 101106046, 101106047, 101106048, 101106049, 101106050, 101106051, 101106053, 101106054, 101106055, 101106056, 101106057, 101106058, 101106059, 101106060, 101106061, 101106062, 101106063, 101106064, 101106065, 101106066, 101106067, 101106068, 101106069, 101106070, 101106071, 101106072, 101106073, 101106074, 101106075, 101106076, 101106077, 101106078, 101106079, 101106080, 101106081, 101106082, 101106083, 101106084, 101106085, 101106086, 101106087, 101106088, 101106089, 101106090, 101106091, 101106201, 101106202, 101106203, 101107000, 101107001, 101107002, 101107003, 101107004, 101107005, 101107006, 101107007, 101107008, 101107009, 101107010, 101107011, 101107012, 101107013, 101107014, 101107015, 101107016, 101107017, 101107018, 101107019, 101107020, 101107021, 101107022, 101107023, 101107024, 101107025, 101107026, 101107027, 101107028, 101107029, 101107030, 101107031, 101107032, 101107033, 101107034, 101107035, 101107036, 101107037, 101107038, 101107039, 101107040, 101107041, 101107042, 101107043, 101107044, 101107045, 101107046, 101107047, 101107048, 101107049, 101107050, 101107051, 101107052, 101107053, 101107054, 101107055, 101107056, 101107057, 101107058, 101107059, 101107060, 101107061, 101107062, 101107063, 101107064, 101107065, 101107066, 101107067, 101107068, 101107069, 101107070, 101107071, 101107072, 101107073, 101107074, 101107075, 101107076, 101107077, 101107078, 101107079, 101107080, 101107081, 101107082, 101107083, 101107084, 101107085, 101107086, 101107087, 101107088, 101107089, 101107090, 101107091, 101108000, 101108001, 101108002, 101108003, 101108004, 101108005, 101108006, 101108007, 101108008, 101108009, 101108010, 101108011, 101108012, 101108013, 101108014, 101108015, 101108016, 101108017, 101108018, 101108019, 101108020, 101108021, 101108022, 101108023, 101108024, 101108025, 101108026, 101108027, 101108028, 101108029, 101108030, 101108031, 101108032, 101108033, 101108034, 101108035, 101108036, 101108037, 101108038, 101108039, 101108040, 101108041, 101108042, 101108043, 101108044, 101108045, 101108046, 101108047, 101108048, 101108049, 101108050, 101108051, 101108052, 101108053, 101108054, 101108055, 101108056, 101108057, 101108058, 101108059, 101108060, 101108061, 101108062, 101108063, 101108064, 101108065, 101108066, 101108067, 101108068, 101108069, 101108070, 101108071, 101108072, 101108073, 101108074, 101108075, 101108076, 101108077, 101108078, 101108079, 101108080, 101108081, 101108082, 101108083, 101108084, 101108085, 101108086, 101108087, 101108088, 101108089, 101108090, 101108091, 101109000, 101109001, 101109002, 101109003, 101109004, 101109005, 101109006, 101109007, 101109008, 101109009, 101109010, 101109011, 101109012, 101109013, 101109014, 101109015, 101109016, 101109017, 101109018, 101109019, 101109020, 101109021, 101109022, 101109023, 101109024, 101109025, 101109026, 101109027, 101109028, 101109029, 101109030, 101109031, 101109032, 101109033, 101109034, 101109035, 101109036, 101109037, 101109038, 101109039, 101109040, 101109041, 101109042, 101109043, 101109044, 101109045, 101109046, 101109047, 101109048, 101109049, 101109050, 101109051, 101109052, 101109053, 101109054, 101109055, 101109056, 101109057, 101109058, 101109059, 101109060, 101109061, 101109062, 101109063, 101109064, 101109065, 101109066, 101109067, 101109068, 101109069, 101109070, 101109071, 101109072, 101109073, 101109074, 101109075, 101109076, 101109077, 101109078, 101109079, 101109080, 101109081, 101109082, 101109083, 101109084, 101109085, 101109086, 101109087, 101109088, 101109089, 101109090, 101109091, 101110000, 101110001, 101110002, 101110003, 101110004, 101110005, 101110006, 101110007, 101110008, 101110009, 101110010, 101110011, 101110012, 101110013, 101110014, 101110015, 101110016, 101110017, 101110018, 101110019, 101110020, 101110021, 101110022, 101110023, 101110024, 101110025, 101110026, 101110027, 101110028, 101110029, 101110030, 101110031, 101110032, 101110033, 101110034, 101110035, 101110036, 101110037, 101110038, 101110039, 101110040, 101110041, 101110042, 101110043, 101110044, 101110045, 101110046, 101110047, 101110048, 101110049, 101110050, 101110051, 101110052, 101110053, 101110054, 101110055, 101110056, 101110057, 101110058, 101110059, 101110060, 101110061, 101110062, 101110063, 101110064, 101110065, 101110066, 101110067, 101110068, 101110069, 101110070, 101110071, 101110072, 101110073, 101110074, 101110075, 101110076, 101110077, 101110078, 101110079, 101110080, 101110081, 101110082, 101110083, 101110084, 101110085, 101110086, 101110087, 101110088, 101110089, 101110090, 101110091, 101111001, 101111002, 101111003, 101111004, 101111005, 101111006, 101111007, 101111008, 101111009, 101111010, 101111011, 101111012, 101111013, 101111014, 101111015, 101111016, 101111017, 101111018, 101111019, 101111020, 101111021, 101111022, 101111023, 101111024, 101111025, 101111026, 101111027, 101111028, 101111029, 101111030, 101111031, 101111032, 101111033, 101111034, 101111035, 101111036, 101111037, 101111038, 101111039, 101111040, 101111041, 101111042, 101111043, 101111044, 101111045, 101111046, 101111047, 101111048, 101111049, 101111050, 101111051, 101111052, 101111053, 101111054, 101111055, 101111056, 101111057, 101111058, 101111059, 101111060, 101111061, 101111062, 101111063, 101111064, 101111065, 101111066, 101111067, 101111068, 101111069, 101111070, 101111071, 101111072, 101111073, 101111074, 101111075, 101111076, 101111077, 101111078, 101111079, 101111080, 101111081, 101111082, 101111083, 101111084, 101111085, 101111087, 101111088, 101111089, 101111090, 101111091, 101111092, 101111201, 101112001, 101112002, 101112003, 101112004, 101112005, 101112006, 101112007, 101112008, 101112009, 101112010, 101112011, 101112012, 101112013, 101112014, 101112015, 101112016, 101112017, 101112018, 101112019, 101112020, 101112021, 101112022, 101112023, 101112024, 101112025, 101112026, 101112027, 101112028, 101112029, 101112030, 101112031, 101112032, 101112033, 101112034, 101112035, 101112036, 101112037, 101112038, 101112039, 101112040, 101112041, 101112042, 101112043, 101112044, 101112045, 101112046, 101112047, 101112048, 101112049, 101112050, 101112051, 101112052, 101112053, 101112054, 101112055, 101112056, 101112057, 101112058, 101112059, 101112060, 101112061, 101112062, 101112063, 101112064, 101112065, 101112066, 101112067, 101112068, 101112069, 101112070, 101112071, 101112072, 101112073, 101112074, 101112075, 101112076, 101112077, 101112078, 101112079, 101112080, 101112081, 101112082, 101112083, 101112084, 101112085, 101112086, 101112087, 101112088, 101112089, 101112090, 101112091, 101112092, 101201000, 101201001, 101201002, 101201003, 101201004, 101201005, 101201006, 101201007, 101201008, 101201009, 101201010, 101201011, 101201012, 101201013, 101201014, 101201015, 101201016, 101201017, 101201018, 101201019, 101201020, 101201021, 101201022, 101201023, 101201024, 101201025, 101201026, 101201027, 101201028, 101201029, 101201030, 101201031, 101201032, 101201033, 101201034, 101201035, 101201036, 101201039, 101201040, 101201041, 101201042, 101201043, 101201044, 101201045, 101201046, 101201047, 101201048, 101201049, 101201052, 101201053, 101201054, 101201055, 101201056, 101201057, 101201058, 101201059, 101201060, 101201061, 101201062, 101201063, 101201064, 101201065, 101201066, 101201067, 101201069, 101201070, 101201071, 101201072, 101201073, 101201074, 101201075, 101201076, 101201077, 101201078, 101201079, 101201080, 101201203, 101201204, 101201205, 101201206, 101201207
    };

    int[] newIDsArray = {
            23923758, 69133798, 64583600, 13302026, 57511992, 90583279, 76352503, 77672444, 75311421, 12527118, 27657173, 50699850, 96084564, 86605515, 15464375, 15198996, 78077209, 64475743, 9627468, 62967433, 98462037, 5182107, 67853262, 8085950, 31464658, 8910240, 76823930, 97534104, 36629635, 33099732, 93347961, 30342076, 35026117, 62411811, 8505920, 34904525, 61398234, 97783338, 34771947, 60176682, 96661780, 33055499, 23446369, 50834074, 86239173, 22723778, 59712426, 85106525, 12501230, 58996839, 84384943, 11489642, 47873397, 84262395, 10666000, 47051709, 73046708, 19544412, 46939151, 72323266, 19322865, 45716579, 71101678, 8690387, 44094981, 71089030, 7473735, 33872334, 70366448, 6351147, 33750856, 49858495, 5916510, 3103067, 38105306, 85758066, 33331231, 9726840, 36114945, 62219643, 9603252, 35098357, 89839552, 77590412, 88617904, 42228966, 86469231, 47077697, 84900597, 1683982, 64104037, 99370594, 61103515, 35705817, 20994205, 57499304, 83888009, 19272658, 56677752, 82661461, 19050066, 55554175, 70551291, 6556909, 43940008, 79339613, 5833312, 32828466, 78217065, 5611760, 31006879, 68490573, 4599182, 30983281, 67378935, 93777634, 30761649, 66156348, 92644052, 39049051, 65433790, 92428405, 28827503, 64211118, 91706817, 27104921, 54878729, 91262474, 26988374, 11020863, 58415502, 76076738, 84813516, 11808215, 47292920, 84797028, 10186633, 46570372, 83575471, 19963185, 46358784, 72843899, 18847598, 45236142, 71620241, 39396763, 75780818, 8025950, 44413654, 70508653, 7903368, 33391067, 70786111, 6180710, 32175429, 79663524, 5068132, 32453837, 68441986, 4836680, 31230289, 67725394, 94113093, 30118701, 62503746, 99991455, 25396150, 62480168, 98875863, 25273572, 61668670, 97053215, 24151924, 50546029, 37930737, 23099524, 59494222, 85888377, 59094601, 85182315, 11587414, 47961342, 73355951, 844056, 36848764, 72233469, 5829717, 31817415, 77202120, 4606229, 30095833, 77189532, 91479482, 34456146, 63013339, 32549749, 31600513, 53754104, 3574681, 39973386, 61322713, 66367984, 54594017, 2752099, 35756798, 61245403, 97639441, 34034150, 60023855, 97417863, 23812568, 60306277, 96795312, 22790910, 26050548, 52445243, 39943352, 65938950, 1259814, 91434602, 38529357, 64927055, 90312154, 37706769, 63101468, 90290572, 26684111, 41406613, 77895328, 3289027, 30284022, 76672730, 3167439, 39552584, 65956182, 19096726, 45484331, 82489470, 18973184, 44362883, 81767888, 17751597, 44146295, 70534340, 12877076, 58371671, 85766789, 11155484, 47149093, 84544192, 10938846, 49027020, 75416738, 12801833, 48805472, 75294187, 1688285, 48183890, 74577599, 98396890, 51779204, 98173209, 24662957, 50056656, 87451661, 62991792, 25784595, 13179234, 2347656, 48745395, 75730490, 1225009, 37629703, 74018812, 2511, 33407125, 69895264, 5380979, 32785578, 68779682, 5168381, 92107604, 29595202, 31562086, 68957034, 94445733, 66712905, 30430448, 67835547, 20618850, 93229151, 55990317, 92385016, 28373620, 49131917, 15130912, 41525660, 88919365, 14418464, 41802073, 87897777, 13291886, 40680521, 76075139, 49568943, 75952542, 38339996, 65734501, 91222209, 37617348, 64612053, 90000652, 37495766, 63899465, 99984170, 26372118, 62777823, 99162522, 25550531, 52645235, 98049934, 24434049, 51822687, 83827392, 20212491, 56700100, 82105704, 29599813, 55584558, 82983267, 18377261, 54862960, 81260679, 17255673, 44649322, 80044027, 16433136, 43527730, 79912449, 16310544, 42705243, 78199891, 5852388, 31241087, 67745632, 94130731, 30128445, 67523044, 93918159, 29302858, 66401502, 92895501, 29280200, 55688914, 91073013, 28168628, 54562327, 91951471, 27345070, 53330789, 80738884, 26223582, 53618197, 89016236, 15001940, 52495649, 88890658, 15388353, 41773061, 87778106, 14166715, 40551410, 87955518, 61496006, 98881700, 34876719, 61374414, 97769122, 23153227, 60158866, 96546575, 23931679, 69436288, 95824983, 22819092, 58203736, 95602345, 21057444, 57541158, 84546257, 20934852, 57329501, 83723605, 19712214, 38082437, 1876841, 64487132, 37260946, 63265554, 90659259, 36148308, 63542003, 99937011, 25926710, 62320425, 98715423, 25209168, 51208877, 97692972, 24087580, 50486289, 97870394, 23965033, 59353647, 86758746, 11962031, 57357130, 84755744, 10140443, 57134592, 83533296, 19027895, 46412900, 22411609, 59805313, 85250352, 11654067, 58143766, 84138874, 11522479, 47921178, 83315222, 10300821, 46804536, 83293635, 19688343, 48784854, 67127799, 20001443, 56495147, 93490856, 29884951, 55273560, 82777208, 28762303, 55151012, 81555617, 53212882, 18940725, 54334420, 80433039, 17827173, 80611581, 16605586, 42090294, 89594399, 15983048, 42377643, 78362751, 14761450, 41255165, 73640163, 44818, 46033517, 72427512, 9822220, 35311929, 72305034, 8700633, 34198387, 71583486, 34072799, 6855503, 60461804, 33250142, 69248256, 96633955, 32138660, 69522668, 95911373, 21915012, 68300121, 94798725, 21293424, 67288539, 93672138, 56465981, 93850690, 29948294, 55343303, 82738008, 28126717, 55521751, 81615450, 17000165, 54408264, 80893872, 17888577, 53286626, 89771220, 16165939, 42560034, 89558743, 15943341, 41348446, 78836195, 14821890, 41215808, 77610503, 4008212, 40493210, 16598965, 43986064, 79371769, 20295753, 56790702, 82184400, 25573115, 51578214, 88962829, 14357527, 50855622, 87240371, 13234975, 40633084, 93612434, 7987191, 20071842, 46123974, 31699677, 77683371, 3078380, 30576089, 66961194, 3355732, 39354437, 66749546, 92133240, 38628859, 65626958, 91011603, 28406301, 64804316, 90299015, 27383719, 53782828, 90176467, 26561172, 52566270, 99054885, 25449584, 52843699, 88232397, 24226942, 51611041, 87116749, 14504454, 50599453, 86993168, 13382806, 49776811, 86271510, 12266229, 48654323, 85059922, 11443677, 48832775, 74936480, 11321089, 47710198, 73104892, 109401, 46593546, 73082255, 9486959, 35871958, 72860663, 8264361, 35659410, 71143015, 7142724, 34536828, 60921537, 7320132, 33814281, 69809989, 96203584, 32692693, 69087397, 95471006, 21570001, 64964750, 90359458, 27753563, 53742162, 99137266, 26631975, 52020510, 99414629, 25419323, 52807032, 28292031, 64797746, 91781484, 27170599, 54564198, 90969892, 26357901, 53442500, 84462118, 10851853, 57946551, 83340560, 19739265, 82128978, 19516687, 45001322, 71406430, 18890039, 44889144, 16312943, 21949879, 58938528, 84332527, 21727231, 57111330, 83610035, 10604644, 56099748, 83488497, 19882096, 46877100, 82361809, 18760514, 45154513, 71549257, 18548966, 44932065, 70427670, 17825378, 43210483, 70204022, 6609736, 42198835, 79582540, 5577149, 52253888, 32975247, 78360952, 4754691, 31259606, 67248304, 4632019, 30037118, 66425726, 3410461, 39915560, 66309175, 92798873, 38192988, 65187687, 91575236, 24070330, 60465049, 97453744, 23848752, 59242457, 96637156, 22125101, 59120809, 95515518, 21903613, 58308221, 84792926, 21887075, 57285770, 83670388, 10065487, 56063182, 83558891, 19942835, 45337544, 82735249, 18720257, 45115956, 81613061, 17008760, 44092304, 70491413, 17885118, 43270827, 79775821, 6763530, 42158279, 79552283, 5941982, 32335697, 78420796, 4825390, 31213049, 7608148, 54656181, 80040886, 26435595, 53923690, 89328238, 52707042, 88106656, 15590355, 41085464, 88083109, 14478717, 72309040, 13256226, 40740224, 76145933, 13533678, 49928686, 75922381, 2311090, 48806195, 75290703, 1295442, 37683547, 74078255, 37961969, 572850, 73956664, 9350312, 36745317, 62133026, 9238125, 35622739, 61011438, 98416533, 34800281, 1855886, 37343995, 63748694, 132308, 36521307, 63526052, 99910751, 35405755, 62803464, 98898163, 35283277, 61681816, 94076521, 20560620, 66569334, 93953933, 29348048, 56733747, 92731385, 28226490, 55610199, 81019803, 28403802, 54498517, 80993256, 27381364, 53776969, 80170678, 16169772, 89058026, 52553471, 15443125, 42431833, 88836438, 14220547, 41619242, 77103950, 14108995, 40597694, 76981308, 13386407, 49370016, 76869711, 2263869, 49658464, 75047173, 1041278, 38436986, 74920585, 1329620, 37313338, 63708033, 197042, 36591747, 63086455, 9070454, 35479109, 84366728, 11765832, 47759571, 73244186, 10632284, 46037983, 73421698, 9416697, 46815301, 8794055, 45792753, 3259760, 71187462, 8571567, 34976176, 70465810, 7459919, 33854624, 60242223, 6637331, 32731036, 69120785, 95515789, 32909498, 68304193, 94392192, 31887806, 67282505, 94670654, 20065259, 66069967, 93454062, 29942771, 56347375, 92332424, 28720123, 55125728, 81519836, 28004531, 54092240, 12061457, 81497285, 27882993, 53270092, 80275707, 16769305, 53154400, 89552119, 15947754, 42932862, 84330567, 11825276, 47219274, 73218989, 10602628, 46057733, 73542331, 9940036, 45935145, 72329844, 8728498, 45112597, 71607202, 7602800, 34090915, 70485614, 7889323, 33878367, 60362066, 6767771, 32152870, 69540484, 95545183, 32939238, 8428836, 34813545, 71817640, 7206349, 34690953, 60095092, 6589707, 33578406, 69973414, 96367119, 32756828, 68250822, 95245571, 21639276, 68038375, 94423983, 20417688, 67906797, 4472318, 40460013, 77855162, 30748475, 76133574, 3137279, 39522887, 65910922, 2405631, 38409239, 65898344, 73478096, 863795, 46261704, 72656408, 5141117, 31149212, 78534861, 4928565, 30327674, 77312273, 3806388, 30291086, 66699781, 3084730, 39078434, 65477143, 92962242, 38356857, 65351555, 91749600, 27134209, 64538914, 90027012, 27012717, 53416326, 99801464, 26259179, 52254878, 99748883, 25137581, 51522296, 88926295, 24915933, 51409648, 87804747, 13298352, 50687050, 86682165, 13076804, 49565413, 85969517, 12954226, 48348921, 85747929, 11132674, 48626373, 74615388, 10019086, 47404795, 73898890, 897409, 46382143, 72776252, 9175957, 35569555, 72554664, 8953369, 34447918, 71832012, 7236721, 34225426, 60619435, 6004133, 33503878, 9597987, 36982581, 72386290, 8775395, 35269904, 61264008, 8653757, 34047456, 60442460, 7436169, 33925864, 60329973, 92714517, 39103226, 65107325, 91592030, 61845881, 97240499, 24634594, 60623203, 96127902, 59900655, 96305350, 22390469, 58884063, 95283172, 21677871, 23512906, 20455229, 57940938, 83334932, 10333641, 56727340, 82112494, 19510093, 45005708, 82090807, 18494511, 45883110, 71277255, 17272964, 44760562, 70155677, 17550376, 43944080, 79933029, 6327734, 42822433, 79210531, 5205146, 31600845, 78098950, 4483598, 31987203, 67972302, 3361010, 30765615, 66150724, 3248469, 39643167, 65037172, 92422871, 38811586, 65815684, 91300233, 28798938, 64193046, 90587641, 27572350, 53971455, 90465153, 22850702, 58858807, 95243515, 21637210, 58036229, 84521924, 20515672, 57900671, 83308376, 10793085, 56787189, 82286798, 19671433, 45065541, 82460246, 18458255, 44843954, 21347668, 57736667, 84121302, 10125011, 56510115, 83008724, 19403423, 46497537, 82886276, 19271881, 45675980, 71164684, 18158393, 44553392, 71948047, 7336745, 43331750, 70825459, 6214163, 43618262, 66736715, 93125329, 29510428, 65914127, 91323605, 92003832, 28497830, 65892585, 91286284, 27275398, 54670997, 90164606, 15845914, 60283232, 97682931, 23076639, 55461744, 92565383, 28954097, 55349196, 81743801, 27132400, 54126514, 80621253, 27015862, 53404966, 89809665, 16893370, 52382379, 89776023, 15171722, 41165831, 88554436, 14959144, 41443249, 77832858, 13836592, 40221691, 76615300, 13014905, 49109013, 76593718, 2992467, 48386462, 75771170, 1769875, 38264974, 74659582, 43227, 821049, 36320744, 62714453, 9709452, 35103106, 62592805, 98986900, 34481518, 61470213, 97864322, 24269961, 63136489, 99531088, 36920182, 62314831, 98319530, 25807544, 61292243, 98696958, 24081957, 61070601, 97474300, 23969415, 50357013, 96352712, 23746827, 59131526, 22024279, 58019984, 85407683, 11802691, 57296396, 84281045, 10780049, 53174748, 89569453, 15967552, 42952160, 88346805, 37442336, 63436931, 653675, 36742774, 85520170
    };

}
