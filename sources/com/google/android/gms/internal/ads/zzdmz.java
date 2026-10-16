package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzdmz implements zzimu {
    private final zzdmd zza;
    private final zzind zzb;

    private zzdmz(zzdmd zzdmdVar, zzind zzindVar) {
        this.zza = zzdmdVar;
        this.zzb = zzindVar;
    }

    public static zzdmz zza(zzdmd zzdmdVar, zzind zzindVar) {
        return new zzdmz(zzdmdVar, zzindVar);
    }

    @Override // com.google.android.gms.internal.ads.zzinj, com.google.android.gms.internal.ads.zzini
    public final /* bridge */ /* synthetic */ Object zzb() {
        return this.zza.zzg((Executor) this.zzb.zzb());
    }
}
