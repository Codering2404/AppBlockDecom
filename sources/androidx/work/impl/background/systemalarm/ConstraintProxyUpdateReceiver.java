package androidx.work.impl.background.systemalarm;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import androidx.compose.animation.core.Xrg.muQRKXGtpOhe;
import androidx.work.Logger;
import androidx.work.impl.WorkManagerImpl;
import androidx.work.impl.background.systemalarm.ConstraintProxy;
import androidx.work.impl.utils.PackageManagerHelper;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class ConstraintProxyUpdateReceiver extends BroadcastReceiver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final String f54784a = Logger.i("ConstrntProxyUpdtRecvr");

    @Override // android.content.BroadcastReceiver
    public void onReceive(final Context context, final Intent intent) {
        String action = intent != null ? intent.getAction() : null;
        if ("androidx.work.impl.background.systemalarm.UpdateProxies".equals(action)) {
            final BroadcastReceiver.PendingResult pendingResultGoAsync = goAsync();
            WorkManagerImpl.r(context).x().d(new Runnable() { // from class: androidx.work.impl.background.systemalarm.ConstraintProxyUpdateReceiver.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        boolean booleanExtra = intent.getBooleanExtra("KEY_BATTERY_NOT_LOW_PROXY_ENABLED", false);
                        boolean booleanExtra2 = intent.getBooleanExtra("KEY_BATTERY_CHARGING_PROXY_ENABLED", false);
                        boolean booleanExtra3 = intent.getBooleanExtra("KEY_STORAGE_NOT_LOW_PROXY_ENABLED", false);
                        boolean booleanExtra4 = intent.getBooleanExtra("KEY_NETWORK_STATE_PROXY_ENABLED", false);
                        Logger.e().a(ConstraintProxyUpdateReceiver.f54784a, "Updating proxies: (BatteryNotLowProxy (" + booleanExtra + "), BatteryChargingProxy (" + booleanExtra2 + "), StorageNotLowProxy (" + booleanExtra3 + "), NetworkStateProxy (" + booleanExtra4 + "), ");
                        PackageManagerHelper.c(context, ConstraintProxy.BatteryNotLowProxy.class, booleanExtra);
                        PackageManagerHelper.c(context, ConstraintProxy.BatteryChargingProxy.class, booleanExtra2);
                        PackageManagerHelper.c(context, ConstraintProxy.StorageNotLowProxy.class, booleanExtra3);
                        PackageManagerHelper.c(context, ConstraintProxy.NetworkStateProxy.class, booleanExtra4);
                    } finally {
                        pendingResultGoAsync.finish();
                    }
                }
            });
            return;
        }
        Logger.e().a(f54784a, "Ignoring unknown action " + action);
    }

    public static Intent a(Context context, boolean z2, boolean z3, boolean z4, boolean z5) {
        Intent intent = new Intent(muQRKXGtpOhe.afENjC);
        intent.setComponent(new ComponentName(context, (Class<?>) ConstraintProxyUpdateReceiver.class));
        intent.putExtra("KEY_BATTERY_NOT_LOW_PROXY_ENABLED", z2).putExtra("KEY_BATTERY_CHARGING_PROXY_ENABLED", z3).putExtra("KEY_STORAGE_NOT_LOW_PROXY_ENABLED", z4).putExtra("KEY_NETWORK_STATE_PROXY_ENABLED", z5);
        return intent;
    }
}
