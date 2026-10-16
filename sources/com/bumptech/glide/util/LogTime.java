package com.bumptech.glide.util;

import android.os.SystemClock;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class LogTime {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final double f67284a = 1.0d / Math.pow(10.0d, 6.0d);

    public static double a(long j3) {
        return (b() - j3) * f67284a;
    }

    public static long b() {
        return SystemClock.elapsedRealtimeNanos();
    }
}
