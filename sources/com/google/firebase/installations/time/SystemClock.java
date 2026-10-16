package com.google.firebase.installations.time;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public class SystemClock implements Clock {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static SystemClock f89329a;

    private SystemClock() {
    }

    public static SystemClock a() {
        if (f89329a == null) {
            f89329a = new SystemClock();
        }
        return f89329a;
    }

    @Override // com.google.firebase.installations.time.Clock
    public long currentTimeMillis() {
        return System.currentTimeMillis();
    }
}
