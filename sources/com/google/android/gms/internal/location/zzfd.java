package com.google.android.gms.internal.location;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzfd {
    public static boolean zza(CountDownLatch countDownLatch, long j3, TimeUnit timeUnit) {
        boolean z2 = false;
        try {
            long nanos = timeUnit.toNanos(30L);
            while (true) {
                try {
                    break;
                } catch (InterruptedException unused) {
                    z2 = true;
                    nanos = (System.nanoTime() + nanos) - System.nanoTime();
                }
            }
            return countDownLatch.await(nanos, TimeUnit.NANOSECONDS);
        } finally {
            if (z2) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
