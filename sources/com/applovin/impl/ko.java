package com.applovin.impl;

import android.os.Trace;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class ko {
    public static void a(String str) {
        if (xp.f65027a >= 18) {
            b(str);
        }
    }

    private static void b(String str) {
        Trace.beginSection(str);
    }

    private static void b() {
        Trace.endSection();
    }

    public static void a() {
        if (xp.f65027a >= 18) {
            b();
        }
    }
}
