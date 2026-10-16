package com.google.android.gms.internal.ads;

import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzeai implements zzimu {
    private final zzind zza;

    private zzeai(zzeaa zzeaaVar, zzind zzindVar, zzind zzindVar2) {
        this.zza = zzindVar;
    }

    public static zzeai zza(zzeaa zzeaaVar, zzind zzindVar, zzind zzindVar2) {
        return new zzeai(zzeaaVar, zzindVar, zzindVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzinj, com.google.android.gms.internal.ads.zzini
    public final /* bridge */ /* synthetic */ Object zzb() {
        Set setZzh = zzeaa.zzh((zzeak) this.zza.zzb(), zzfoa.zzc());
        zzinc.zzb(setZzh);
        return setZzh;
    }
}
