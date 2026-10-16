package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.FullScreenContentCallback;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzbgg extends zzbgp {
    private FullScreenContentCallback zza;

    public final void zzb(FullScreenContentCallback fullScreenContentCallback) {
        this.zza = fullScreenContentCallback;
    }

    @Override // com.google.android.gms.internal.ads.zzbgq
    public final void zzc() {
        FullScreenContentCallback fullScreenContentCallback = this.zza;
        if (fullScreenContentCallback != null) {
            fullScreenContentCallback.e();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbgq
    public final void zzd() {
        FullScreenContentCallback fullScreenContentCallback = this.zza;
        if (fullScreenContentCallback != null) {
            fullScreenContentCallback.b();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbgq
    public final void zze(com.google.android.gms.ads.internal.client.zze zzeVar) {
        FullScreenContentCallback fullScreenContentCallback = this.zza;
        if (fullScreenContentCallback != null) {
            fullScreenContentCallback.c(zzeVar.M());
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbgq
    public final void zzf() {
        FullScreenContentCallback fullScreenContentCallback = this.zza;
        if (fullScreenContentCallback != null) {
            fullScreenContentCallback.d();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbgq
    public final void zzg() {
        FullScreenContentCallback fullScreenContentCallback = this.zza;
        if (fullScreenContentCallback != null) {
            fullScreenContentCallback.a();
        }
    }
}
