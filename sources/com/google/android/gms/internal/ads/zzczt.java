package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzczt implements com.google.android.gms.ads.internal.client.zza {
    private final zzczx zza;
    private final zzfky zzb;

    zzczt(zzczx zzczxVar, zzfky zzfkyVar) {
        this.zza = zzczxVar;
        this.zzb = zzfkyVar;
    }

    @Override // com.google.android.gms.ads.internal.client.zza
    public final void onAdClicked() {
        this.zza.zza(this.zzb.zzg);
    }
}
