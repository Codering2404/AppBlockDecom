package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzcqg implements zzimu {
    private final zzcqf zza;

    private zzcqg(zzcqf zzcqfVar) {
        this.zza = zzcqfVar;
    }

    public static zzcqg zzc(zzcqf zzcqfVar) {
        return new zzcqg(zzcqfVar);
    }

    public static com.google.android.gms.ads.internal.zza zzd(zzcqf zzcqfVar) {
        return new com.google.android.gms.ads.internal.zza(new zzcik(), new zzchf());
    }

    public final com.google.android.gms.ads.internal.zza zza() {
        return zzd(this.zza);
    }

    @Override // com.google.android.gms.internal.ads.zzinj, com.google.android.gms.internal.ads.zzini
    public final /* synthetic */ Object zzb() {
        return zzd(this.zza);
    }
}
