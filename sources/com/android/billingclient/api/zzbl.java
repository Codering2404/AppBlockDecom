package com.android.billingclient.api;

import java.util.Objects;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
final class zzbl implements ThreadFactory {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ThreadFactory f57467a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final AtomicInteger f57468b;

    zzbl(BillingClientImpl billingClientImpl) {
        Objects.requireNonNull(billingClientImpl);
        this.f57467a = Executors.defaultThreadFactory();
        this.f57468b = new AtomicInteger(1);
    }

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable runnable) {
        AtomicInteger atomicInteger = this.f57468b;
        Thread threadNewThread = this.f57467a.newThread(runnable);
        threadNewThread.setName("PlayBillingLibrary-" + atomicInteger.getAndIncrement());
        return threadNewThread;
    }
}
