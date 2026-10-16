package com.google.android.libraries.places.internal;

import android.os.Looper;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzqw {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Thread f78487a;

    public static boolean a(Thread thread) {
        if (f78487a == null) {
            f78487a = Looper.getMainLooper().getThread();
        }
        return thread == f78487a;
    }
}
