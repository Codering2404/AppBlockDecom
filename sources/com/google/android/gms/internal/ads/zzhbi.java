package com.google.android.gms.internal.ads;

import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzhbi extends zzhbj {
    final /* synthetic */ zzhbk zza;
    private final Callable zzc;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzhbi(zzhbk zzhbkVar, Callable callable, Executor executor) {
        super(zzhbkVar, executor);
        Objects.requireNonNull(zzhbkVar);
        this.zza = zzhbkVar;
        this.zzc = callable;
    }

    @Override // com.google.android.gms.internal.ads.zzhcd
    final Object zza() throws Exception {
        return this.zzc.call();
    }

    @Override // com.google.android.gms.internal.ads.zzhbj
    final void zzb(Object obj) {
        this.zza.zza(obj);
    }

    @Override // com.google.android.gms.internal.ads.zzhcd
    final String zzc() {
        return this.zzc.toString();
    }
}
