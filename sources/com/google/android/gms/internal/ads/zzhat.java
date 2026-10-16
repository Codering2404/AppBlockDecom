package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzhat extends zzhav {
    zzhat(ListenableFuture listenableFuture, zzhbe zzhbeVar) {
        super(listenableFuture, zzhbeVar);
    }

    @Override // com.google.android.gms.internal.ads.zzhav
    final /* synthetic */ void zze(Object obj) {
        zzk((ListenableFuture) obj);
    }

    @Override // com.google.android.gms.internal.ads.zzhav
    final /* bridge */ /* synthetic */ Object zzf(Object obj, Object obj2) throws Exception {
        zzhbe zzhbeVar = (zzhbe) obj;
        ListenableFuture listenableFutureZza = zzhbeVar.zza(obj2);
        zzgtj.zzl(listenableFutureZza, "AsyncFunction.apply returned null instead of a Future. Did you mean to return immediateFuture(null)? %s", zzhbeVar);
        return listenableFutureZza;
    }
}
