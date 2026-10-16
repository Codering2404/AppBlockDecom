package com.applovin.impl;

import android.os.Build;
import java.util.HashSet;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class e8 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f59377a = "ExoPlayerLib/2.15.1 (Linux; Android " + Build.VERSION.RELEASE + ") ExoPlayerLib/2.15.1";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final HashSet f59378b = new HashSet();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static String f59379c = "goog.exo.core";

    public static synchronized String a() {
        return f59379c;
    }

    public static synchronized void a(String str) {
        if (f59378b.add(str)) {
            f59379c += ", " + str;
        }
    }
}
