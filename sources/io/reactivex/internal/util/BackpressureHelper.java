package io.reactivex.internal.util;

import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class BackpressureHelper {
    public static long a(AtomicLong atomicLong, long j3) {
        long j4;
        do {
            j4 = atomicLong.get();
            if (j4 == Long.MAX_VALUE) {
                return Long.MAX_VALUE;
            }
        } while (!atomicLong.compareAndSet(j4, c(j4, j3)));
        return j4;
    }

    public static long b(AtomicLong atomicLong, long j3) {
        long j4;
        do {
            j4 = atomicLong.get();
            if (j4 == Long.MIN_VALUE) {
                return Long.MIN_VALUE;
            }
            if (j4 == Long.MAX_VALUE) {
                return Long.MAX_VALUE;
            }
        } while (!atomicLong.compareAndSet(j4, c(j4, j3)));
        return j4;
    }

    public static long c(long j3, long j4) {
        long j5 = j3 + j4;
        if (j5 < 0) {
            return Long.MAX_VALUE;
        }
        return j5;
    }

    public static long d(long j3, long j4) {
        long j5 = j3 * j4;
        if (((j3 | j4) >>> 31) == 0 || j5 / j3 == j4) {
            return j5;
        }
        return Long.MAX_VALUE;
    }

    public static long e(AtomicLong atomicLong, long j3) {
        long j4;
        long j5;
        do {
            j4 = atomicLong.get();
            if (j4 == Long.MAX_VALUE) {
                return Long.MAX_VALUE;
            }
            j5 = j4 - j3;
            if (j5 < 0) {
                RxJavaPlugins.s(new IllegalStateException("More produced than requested: " + j5));
                j5 = 0L;
            }
        } while (!atomicLong.compareAndSet(j4, j5));
        return j5;
    }

    public static long f(AtomicLong atomicLong, long j3) {
        long j4;
        long j5;
        do {
            j4 = atomicLong.get();
            if (j4 == Long.MIN_VALUE) {
                return Long.MIN_VALUE;
            }
            if (j4 == Long.MAX_VALUE) {
                return Long.MAX_VALUE;
            }
            j5 = j4 - j3;
            if (j5 < 0) {
                RxJavaPlugins.s(new IllegalStateException("More produced than requested: " + j5));
                j5 = 0L;
            }
        } while (!atomicLong.compareAndSet(j4, j5));
        return j5;
    }
}
