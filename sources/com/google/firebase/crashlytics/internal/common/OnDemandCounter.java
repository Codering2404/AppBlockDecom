package com.google.firebase.crashlytics.internal.common;

import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class OnDemandCounter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final AtomicInteger f88447a = new AtomicInteger();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final AtomicInteger f88448b = new AtomicInteger();

    public void a() {
        this.f88448b.getAndIncrement();
    }

    public void b() {
        this.f88447a.getAndIncrement();
    }

    public void c() {
        this.f88448b.set(0);
    }
}
