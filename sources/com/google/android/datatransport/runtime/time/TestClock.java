package com.google.android.datatransport.runtime.time;

import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class TestClock implements Clock {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final AtomicLong f69620a;

    @Override // com.google.android.datatransport.runtime.time.Clock
    public long a() {
        return this.f69620a.get();
    }
}
