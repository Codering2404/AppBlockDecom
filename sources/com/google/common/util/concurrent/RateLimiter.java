package com.google.common.util.concurrent;

import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
@ElementTypesAreNonnullByDefault
public abstract class RateLimiter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private volatile Object f85906a;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static abstract class SleepingStopwatch {

        /* JADX INFO: renamed from: com.google.common.util.concurrent.RateLimiter$SleepingStopwatch$1, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        class AnonymousClass1 extends SleepingStopwatch {
        }
    }

    private Object c() {
        Object obj;
        Object obj2 = this.f85906a;
        if (obj2 != null) {
            return obj2;
        }
        synchronized (this) {
            try {
                obj = this.f85906a;
                if (obj == null) {
                    obj = new Object();
                    this.f85906a = obj;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return obj;
    }

    abstract double a();

    public final double b() {
        double dA;
        synchronized (c()) {
            dA = a();
        }
        return dA;
    }

    public String toString() {
        return String.format(Locale.ROOT, "RateLimiter[stableRate=%3.1fqps]", Double.valueOf(b()));
    }
}
