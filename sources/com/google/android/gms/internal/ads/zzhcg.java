package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public interface zzhcg extends ExecutorService, AutoCloseable {
    @Override // java.lang.AutoCloseable
    /* synthetic */ default void close() {
        f.b.a(this);
    }

    @Override // java.util.concurrent.ExecutorService, com.google.android.gms.internal.ads.zzhcg
    /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
    ListenableFuture submit(Runnable runnable);

    @Override // java.util.concurrent.ExecutorService, com.google.android.gms.internal.ads.zzhcg
    /* JADX INFO: renamed from: zzb, reason: merged with bridge method [inline-methods] */
    ListenableFuture submit(Runnable runnable, Object obj);

    @Override // java.util.concurrent.ExecutorService, com.google.android.gms.internal.ads.zzhcg
    /* JADX INFO: renamed from: zzc, reason: merged with bridge method [inline-methods] */
    ListenableFuture submit(Callable callable);
}
