package com.google.android.gms.internal.ads;

import java.util.concurrent.ExecutorService;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzgcu implements zzimu {
    private final zzind zza;

    private zzgcu(zzind zzindVar) {
        this.zza = zzindVar;
    }

    public static zzgcu zza(zzind zzindVar) {
        return new zzgcu(zzindVar);
    }

    @Override // com.google.android.gms.internal.ads.zzinj, com.google.android.gms.internal.ads.zzini
    public final /* bridge */ /* synthetic */ Object zzb() {
        zzhcg zzhcgVarZzb = zzhcn.zzb((ExecutorService) this.zza.zzb());
        zzinc.zzb(zzhcgVarZzb);
        return zzhcgVarZzb;
    }
}
