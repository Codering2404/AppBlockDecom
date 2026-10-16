package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzcsq implements zzimu {
    private final zzind zza;

    private zzcsq(zzind zzindVar) {
        this.zza = zzindVar;
    }

    public static zzcsq zza(zzind zzindVar) {
        return new zzcsq(zzindVar);
    }

    @Override // com.google.android.gms.internal.ads.zzinj, com.google.android.gms.internal.ads.zzini
    public final /* bridge */ /* synthetic */ Object zzb() {
        return new zzcsp((zzfke) this.zza.zzb());
    }
}
