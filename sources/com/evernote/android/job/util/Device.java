package com.evernote.android.job.util;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.PowerManager;
import androidx.core.net.ConnectivityManagerCompat;
import com.applovin.sdk.AppLovinEventTypes;
import com.evernote.android.job.JobRequest;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class Device {
    public static BatteryStatus a(Context context) {
        Intent intentRegisterReceiver = context.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        if (intentRegisterReceiver == null) {
            return BatteryStatus.f67958c;
        }
        float intExtra = intentRegisterReceiver.getIntExtra(AppLovinEventTypes.USER_COMPLETED_LEVEL, -1) / intentRegisterReceiver.getIntExtra("scale", -1);
        int intExtra2 = intentRegisterReceiver.getIntExtra("plugged", 0);
        return new BatteryStatus(intExtra2 == 1 || intExtra2 == 2 || intExtra2 == 4, intExtra);
    }

    public static JobRequest.NetworkType b(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        try {
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            return (activeNetworkInfo == null || !activeNetworkInfo.isConnectedOrConnecting()) ? JobRequest.NetworkType.ANY : !ConnectivityManagerCompat.a(connectivityManager) ? JobRequest.NetworkType.UNMETERED : d(connectivityManager, activeNetworkInfo) ? JobRequest.NetworkType.CONNECTED : JobRequest.NetworkType.NOT_ROAMING;
        } catch (Throwable unused) {
            return JobRequest.NetworkType.ANY;
        }
    }

    public static boolean c(Context context) {
        PowerManager powerManager = (PowerManager) context.getSystemService("power");
        return powerManager.isDeviceIdleMode() || !powerManager.isInteractive();
    }

    private static boolean d(ConnectivityManager connectivityManager, NetworkInfo networkInfo) {
        try {
            return connectivityManager.getNetworkCapabilities(connectivityManager.getActiveNetwork()).hasCapability(18);
        } catch (Exception unused) {
            return networkInfo.isRoaming();
        }
    }

    public static boolean e() {
        return false;
    }
}
