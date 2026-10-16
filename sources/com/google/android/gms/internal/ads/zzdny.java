package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzdny implements zzimu {
    private final zzdnx zza;

    private zzdny(zzdnx zzdnxVar) {
        this.zza = zzdnxVar;
    }

    public static zzdny zzc(zzdnx zzdnxVar) {
        return new zzdny(zzdnxVar);
    }

    public final com.google.android.gms.ads.internal.client.zzbh zza() {
        return this.zza.zzb();
    }

    @Override // com.google.android.gms.internal.ads.zzinj, com.google.android.gms.internal.ads.zzini
    public final /* synthetic */ Object zzb() {
        return this.zza.zzb();
    }
}
