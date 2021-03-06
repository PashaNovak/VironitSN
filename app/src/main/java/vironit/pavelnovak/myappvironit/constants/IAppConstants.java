package vironit.pavelnovak.myappvironit.constants;

public interface IAppConstants {

    int LONG_DOUBLE_BACK_DELAY = 2000;

    String COMPUTATION_SCHEDULER = "COMPUTATION_SCHEDULER";
    String UI_SCHEDULER = "UI_SCHEDULER";
    String IO_SCHEDULER = "IO_SCHEDULER";

    String FACEBOOK = "FACEBOOK";
    String TWITTER = "TWITTER";
    String GOOGLE = "GOOGLE";

    int NO_STRING_RES = -1;

    int RC_SIGN_IN = 9001;

    String AUTH_CLIENT = "AUTH_CLIENT";
    String NEWS = "NEWS";

    long CONNECT_TIMEOUT_SECONDS = 15;
    long READ_CONNECT_TIMEOUT_SECONDS = 20;
    long WRITE_CONNECT_TIMEOUT_SECONDS = 20;

    long CACH_SIZE = 20 * 1024 * 1024;

    int DEFAULT_ITEMS_COUNT_PER_PAGE = 3;

    float DEFAULT_GOOGLE_MAP_CAMERA_ZOOM = 15f;
    int GOOGLE_REQUEST_CODE = 402;
}
