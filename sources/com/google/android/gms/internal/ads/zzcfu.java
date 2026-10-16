package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzcfu {
    public static void zza(ListenableFuture listenableFuture, String str, Executor executor) {
        zzhbw.zzr(listenableFuture, new zzcfs(str), executor);
    }

    public static void zzb(ListenableFuture listenableFuture, String str) {
        zzhbw.zzr(listenableFuture, new zzcft(str), zzcfr.zzh);
    }
}
