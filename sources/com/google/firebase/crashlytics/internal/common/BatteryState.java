package com.google.firebase.crashlytics.internal.common;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.applovin.sdk.AppLovinEventTypes;
import com.facebook.internal.AnalyticsEvents;
import com.google.firebase.crashlytics.internal.Logger;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
class BatteryState {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Float f88312a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f88313b;

    private BatteryState(Float f3, boolean z2) {
        this.f88313b = z2;
        this.f88312a = f3;
    }

    public static BatteryState a(Context context) {
        boolean zE = false;
        Float fD = null;
        try {
            Intent intentRegisterReceiver = context.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
            if (intentRegisterReceiver != null) {
                zE = e(intentRegisterReceiver);
                fD = d(intentRegisterReceiver);
            }
        } catch (IllegalStateException e3) {
            Logger.f().e("An error occurred getting battery state.", e3);
        }
        return new BatteryState(fD, zE);
    }

    private static Float d(Intent intent) {
        int intExtra = intent.getIntExtra(AppLovinEventTypes.USER_COMPLETED_LEVEL, -1);
        int intExtra2 = intent.getIntExtra("scale", -1);
        if (intExtra == -1 || intExtra2 == -1) {
            return null;
        }
        return Float.valueOf(intExtra / intExtra2);
    }

    private static boolean e(Intent intent) {
        int intExtra = intent.getIntExtra(AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_STATUS, -1);
        if (intExtra == -1) {
            return false;
        }
        return intExtra == 2 || intExtra == 5;
    }

    public Float b() {
        return this.f88312a;
    }

    public int c() {
        Float f3;
        if (!this.f88313b || (f3 = this.f88312a) == null) {
            return 1;
        }
        return ((double) f3.floatValue()) < 0.99d ? 2 : 3;
    }
}
