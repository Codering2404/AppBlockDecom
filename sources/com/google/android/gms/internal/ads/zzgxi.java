package com.google.android.gms.internal.ads;

import java.util.ListIterator;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzgxi extends zzgyz {
    final /* synthetic */ zzgxj zza;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzgxi(zzgxj zzgxjVar, ListIterator listIterator) {
        super(listIterator);
        Objects.requireNonNull(zzgxjVar);
        this.zza = zzgxjVar;
    }

    @Override // com.google.android.gms.internal.ads.zzgyy
    final Object zza(Object obj) {
        return this.zza.zzb.apply(obj);
    }
}
