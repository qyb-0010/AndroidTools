package tools.qyb.com.androidtools.app;

import android.content.Context;
import android.content.pm.PackageManager;

import java.util.List;

public class AppManager {

    private PackageManager mPm;
    private static AppManager mInstance;

    private AppManager (Context context) {
        mPm = context.getPackageManager();
    }

    public static AppManager getInstance(Context context) {
        if (mInstance == null) {
            synchronized (AppManager.class) {
                if (mInstance == null) {
                    mInstance = new AppManager(context);
                }
            }
        }
        return mInstance;
    }

    public List<AppInfo> getInstalledApps() {
        return null;
    }

    public List<AppInfo> getUserApps() {
        return null;
    }

    public List<AppInfo> getSysApps() {
        return null;
    }

    public AppInfo getAppInfo(String packageName) {
        return null;
    }
}
