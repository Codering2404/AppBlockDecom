package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzcrc implements zzimu {
    private final zzind zza;

    private zzcrc(zzcqt zzcqtVar, zzind zzindVar) {
        this.zza = zzindVar;
    }

    public static zzcrc zzc(zzcqt zzcqtVar, zzind zzindVar) {
        return new zzcrc(zzcqtVar, zzindVar);
    }

    @Override // com.google.android.gms.internal.ads.zzinj, com.google.android.gms.internal.ads.zzini
    /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
    public final zzflu zzb() {
        zzflu zzfluVarZza = zzflu.zza(((zzcns) this.zza).zza());
        zzinc.zzb(zzfluVarZza);
        return zzfluVarZza;
    }
}
