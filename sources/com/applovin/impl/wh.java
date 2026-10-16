package com.applovin.impl;

import android.adservices.AdServicesState;
import android.content.Context;
import com.applovin.sdk.AppLovinSdkUtils;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class wh {
    public static boolean a(Context context) {
        return z3.a("android.permission.ACCESS_ADSERVICES_AD_ID", context);
    }

    public static boolean b(Context context) {
        return z3.a("android.permission.ACCESS_ADSERVICES_ATTRIBUTION", context);
    }

    public static boolean c(Context context) {
        return z3.a("android.permission.ACCESS_ADSERVICES_CUSTOM_AUDIENCE", context);
    }

    public static boolean d(Context context) {
        return z3.a("android.permission.ACCESS_ADSERVICES_TOPICS", context);
    }

    public static boolean e(Context context) {
        return f(context) && AdServicesState.isAdServicesStateEnabled();
    }

    public static boolean f(Context context) {
        return z3.c() && !AppLovinSdkUtils.isFireOS(context);
    }
}
