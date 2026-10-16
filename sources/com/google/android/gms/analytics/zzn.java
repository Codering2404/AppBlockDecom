package com.google.android.gms.analytics;

import f.b;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RunnableFuture;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
final class zzn extends ThreadPoolExecutor implements AutoCloseable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ zzr f70914a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzn(zzr zzrVar) {
        super(1, 1, 1L, TimeUnit.MINUTES, new LinkedBlockingQueue());
        this.f70914a = zzrVar;
        setThreadFactory(new zzp(null));
        allowCoreThreadTimeOut(true);
    }

    @Override // java.lang.AutoCloseable
    public /* synthetic */ void close() {
        b.a(this);
    }

    @Override // java.util.concurrent.AbstractExecutorService
    protected final RunnableFuture newTaskFor(Runnable runnable, Object obj) {
        return new zzm(this, runnable, obj);
    }
}
