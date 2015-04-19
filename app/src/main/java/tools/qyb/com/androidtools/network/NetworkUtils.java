package tools.qyb.com.androidtools.network;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public class NetworkUtils {
    //全球微波互联
    private static final int NETWORK_TYPE_WIMAX = 6;

    //有线网是否连接
    private static final int NETWORK_TYPE_ETHERNET = 9;

    private static ConnectivityManager manager;

    private static ConnectivityManager getConnectivityManager(Context context) {
        if (manager == null) {
            manager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        }
        return manager;
    }

    public static boolean isNetworkAvailable(Context context) {
        ConnectivityManager connMgr = getConnectivityManager(context);
        if (connMgr == null) {
            return false;
        }
        NetworkInfo info = connMgr.getActiveNetworkInfo();
        return info != null && info.isConnected();
    }

    public static boolean isWifi(Context context) {
        ConnectivityManager connMgr = getConnectivityManager(context);
        if (connMgr == null) {
            return false;
        }
        NetworkInfo info = connMgr.getActiveNetworkInfo();
        if (info != null) {
            int type = info.getType();
            return type == ConnectivityManager.TYPE_WIFI ||
                    type == NETWORK_TYPE_ETHERNET ||
                    type == NETWORK_TYPE_WIMAX;
        }
        return false;
    }
}
