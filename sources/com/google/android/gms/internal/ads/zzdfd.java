package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzdfd implements zzimu {
    private final zzind zza;

    private zzdfd(zzind zzindVar) {
        this.zza = zzindVar;
    }

    public static zzdfd zza(zzind zzindVar) {
        return new zzdfd(zzindVar);
    }

    @Override // com.google.android.gms.internal.ads.zzinj, com.google.android.gms.internal.ads.zzini
    public final /* bridge */ /* synthetic */ Object zzb() {
        return new zzdfc(((zzing) this.zza).zzb());
    }
}
