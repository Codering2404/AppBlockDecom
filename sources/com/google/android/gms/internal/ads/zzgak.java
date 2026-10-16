package com.google.android.gms.internal.ads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzgak implements zzgaj {
    private zzgak() {
        throw null;
    }

    @Override // com.google.android.gms.internal.ads.zzgaj
    public final ExecutorService zza(int i3, ThreadFactory threadFactory, int i4) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(i3, i3, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), threadFactory);
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        return Executors.unconfigurableExecutorService(threadPoolExecutor);
    }

    @Override // com.google.android.gms.internal.ads.zzgaj
    public final ExecutorService zzb(int i3) {
        return zza(1, Executors.defaultThreadFactory(), 2);
    }

    @Override // com.google.android.gms.internal.ads.zzgaj
    public final ExecutorService zzc(ThreadFactory threadFactory, int i3) {
        return zza(1, threadFactory, 1);
    }

    /* synthetic */ zzgak(byte[] bArr) {
    }
}
