package com.google.android.libraries.places.internal;

import java.util.Objects;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzcbl implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ CyclicBarrier f77413a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ CountDownLatch f77414b;

    zzcbl(zzcbp zzcbpVar, CyclicBarrier cyclicBarrier, CountDownLatch countDownLatch) {
        this.f77413a = cyclicBarrier;
        this.f77414b = countDownLatch;
        Objects.requireNonNull(zzcbpVar);
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            this.f77413a.await(1000L, TimeUnit.MILLISECONDS);
            this.f77414b.await();
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
        } catch (BrokenBarrierException | TimeoutException unused2) {
        }
    }
}
