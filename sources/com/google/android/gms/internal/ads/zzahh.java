package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzahh extends zzagn {
    final /* synthetic */ zzahb zza;
    final /* synthetic */ zzahi zzb;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzahh(zzahi zzahiVar, zzahb zzahbVar, zzahb zzahbVar2) {
        super(zzahbVar);
        this.zza = zzahbVar2;
        Objects.requireNonNull(zzahiVar);
        this.zzb = zzahiVar;
    }

    @Override // com.google.android.gms.internal.ads.zzagn, com.google.android.gms.internal.ads.zzahb
    public final zzagz zzc(long j3) {
        zzagz zzagzVarZzc = this.zza.zzc(j3);
        zzahc zzahcVar = zzagzVarZzc.zza;
        long j4 = zzahcVar.zzb;
        zzahi zzahiVar = this.zzb;
        zzahc zzahcVar2 = new zzahc(j4, zzahcVar.zzc + zzahiVar.zza());
        zzahc zzahcVar3 = zzagzVarZzc.zzb;
        return new zzagz(zzahcVar2, new zzahc(zzahcVar3.zzb, zzahcVar3.zzc + zzahiVar.zza()));
    }
}
