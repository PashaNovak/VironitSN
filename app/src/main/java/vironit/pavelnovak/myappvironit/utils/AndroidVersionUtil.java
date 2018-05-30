package vironit.pavelnovak.myappvironit.utils;

public class AndroidVersionUtil {
    public static int getApiVersion() {
        return android.os.Build.VERSION.SDK_INT;
    }

    public static boolean isApiVersionGraterOrEqual(int thisVersion) {
        return android.os.Build.VERSION.SDK_INT >= thisVersion;
    }
}
