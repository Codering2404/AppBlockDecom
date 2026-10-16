package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzhan extends zzhao {
    zzhan(ListenableFuture listenableFuture, Class cls, zzgta zzgtaVar) {
        super(listenableFuture, cls, zzgtaVar);
    }

    @Override // com.google.android.gms.internal.ads.zzhao
    final void zze(Object obj) {
        zza(obj);
    }

    @Override // com.google.android.gms.internal.ads.zzhao
    final /* synthetic */ Object zzf(Object obj, Throwable th) throws Exception {
        return ((zzgta) obj).apply(th);
    }
}
