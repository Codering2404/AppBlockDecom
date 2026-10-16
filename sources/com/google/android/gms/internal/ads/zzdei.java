package com.google.android.gms.internal.ads;

import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzdei implements zzimu {
    private final zzind zza;

    private zzdei(zzind zzindVar) {
        this.zza = zzindVar;
    }

    public static zzdei zzc(zzind zzindVar) {
        return new zzdei(zzindVar);
    }

    public static zzdeh zzd(Set set) {
        return new zzdeh(set);
    }

    @Override // com.google.android.gms.internal.ads.zzinj, com.google.android.gms.internal.ads.zzini
    /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
    public final zzdeh zzb() {
        return new zzdeh(((zzing) this.zza).zzb());
    }
}
