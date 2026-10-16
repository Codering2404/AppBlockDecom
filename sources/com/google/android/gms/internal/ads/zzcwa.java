package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzcwa implements zzimu {
    private final zzind zza;

    private zzcwa(zzcvs zzcvsVar, zzind zzindVar) {
        this.zza = zzindVar;
    }

    public static zzcwa zza(zzcvs zzcvsVar, zzind zzindVar) {
        return new zzcwa(zzcvsVar, zzindVar);
    }

    @Override // com.google.android.gms.internal.ads.zzinj, com.google.android.gms.internal.ads.zzini
    public final /* bridge */ /* synthetic */ Object zzb() {
        zzgww zzgwwVarZzi = ((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzoc)).booleanValue() ? zzgww.zzi(new zzdkq(((zzcxe) this.zza).zzb(), zzcfr.zza)) : zzgww.zzh();
        zzinc.zzb(zzgwwVarZzi);
        return zzgwwVarZzi;
    }
}
