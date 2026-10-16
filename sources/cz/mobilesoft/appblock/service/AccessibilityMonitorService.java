package cz.mobilesoft.appblock.service;

import android.app.ActivityManager;
import android.app.Service;
import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.IBinder;
import android.os.Process;
import android.util.Log;
import com.facebook.appevents.AppEventsConstants;
import com.google.android.gms.common.api.Api;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes7.dex */
public class AccessibilityMonitorService extends Service {
    private void a() {
        ComponentName componentName = new ComponentName(this, (Class<?>) LockAccessibilityService.class);
        Log.v("AccessibilityMonitor", "ensureCollectorRunning collectorComponent: " + componentName);
        List<ActivityManager.RunningServiceInfo> runningServices = ((ActivityManager) getSystemService("activity")).getRunningServices(Api.BaseClientBuilder.API_PRIORITY_OTHER);
        if (runningServices == null) {
            Log.w("AccessibilityMonitor", "ensureCollectorRunning() runningServices is NULL");
            return;
        }
        boolean z2 = false;
        for (ActivityManager.RunningServiceInfo runningServiceInfo : runningServices) {
            if (runningServiceInfo.service.equals(componentName)) {
                StringBuilder sb = new StringBuilder();
                sb.append("ensureCollectorRunning service - pid: ");
                sb.append(runningServiceInfo.pid);
                sb.append(", currentPID: ");
                sb.append(Process.myPid());
                sb.append(", clientPackage: ");
                sb.append(runningServiceInfo.clientPackage);
                sb.append(", clientCount: ");
                sb.append(runningServiceInfo.clientCount);
                sb.append(", clientLabel: ");
                sb.append(runningServiceInfo.clientLabel == 0 ? AppEventsConstants.EVENT_PARAM_VALUE_NO : "(" + getResources().getString(runningServiceInfo.clientLabel) + ")");
                Log.w("AccessibilityMonitor", sb.toString());
                if (runningServiceInfo.pid == Process.myPid()) {
                    z2 = true;
                }
            }
        }
        if (z2) {
            Log.d("AccessibilityMonitor", "ensureCollectorRunning: collector is running");
        } else {
            Log.d("AccessibilityMonitor", "ensureCollectorRunning: collector not running, reviving...");
            b();
        }
    }

    private void b() {
        Log.d("AccessibilityMonitor", "toggleAccessibilityService() called");
        ComponentName componentName = new ComponentName(this, (Class<?>) LockAccessibilityService.class);
        PackageManager packageManager = getPackageManager();
        packageManager.setComponentEnabledSetting(componentName, 2, 1);
        packageManager.setComponentEnabledSetting(componentName, 1, 1);
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        Log.d("AccessibilityMonitor", "onCreate() called");
        try {
            a();
        } catch (NoClassDefFoundError unused) {
        }
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i3, int i4) {
        return 1;
    }
}
