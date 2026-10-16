package com.iab.omid.library.applovin.utils;

import android.text.TextUtils;
import android.util.Log;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class d {
    public static void a(String str) {
        if (!com.iab.omid.library.applovin.a.f92104a.booleanValue() || TextUtils.isEmpty(str)) {
            return;
        }
        Log.i("OMIDLIB", str);
    }

    public static void b(String str) {
        if (!com.iab.omid.library.applovin.a.f92104a.booleanValue() || TextUtils.isEmpty(str)) {
            return;
        }
        Log.w("OMIDLIB", str);
    }

    public static void a(String str, Exception exc) {
        if ((!com.iab.omid.library.applovin.a.f92104a.booleanValue() || TextUtils.isEmpty(str)) && exc == null) {
            return;
        }
        Log.e("OMIDLIB", str, exc);
    }
}
