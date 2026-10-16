package com.google.android.gms.common.util;

import android.os.SystemClock;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class DefaultClock implements Clock {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final DefaultClock f72269a = new DefaultClock();

    private DefaultClock() {
    }

    public static Clock c() {
        return f72269a;
    }

    @Override // com.google.android.gms.common.util.Clock
    public final long a() {
        return SystemClock.elapsedRealtime();
    }

    @Override // com.google.android.gms.common.util.Clock
    public final long b() {
        return System.nanoTime();
    }

    @Override // com.google.android.gms.common.util.Clock
    public final long currentTimeMillis() {
        return System.currentTimeMillis();
    }
}
