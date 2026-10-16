package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzcnx implements zzimu {
    private final zzind zza;
    private final zzind zzb;

    private zzcnx(zzcnl zzcnlVar, zzind zzindVar, zzind zzindVar2) {
        this.zza = zzindVar;
        this.zzb = zzindVar2;
    }

    public static zzcnx zza(zzcnl zzcnlVar, zzind zzindVar, zzind zzindVar2) {
        return new zzcnx(zzcnlVar, zzindVar, zzindVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzinj, com.google.android.gms.internal.ads.zzini
    public final /* bridge */ /* synthetic */ Object zzb() {
        return ((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzdI)).booleanValue() ? new zzbap((zzbak) this.zzb.zzb()) : new zzbap((zzbak) this.zza.zzb());
    }
}
