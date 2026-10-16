package com.google.android.gms.ads.internal.client;

import com.google.android.gms.ads.FullScreenContentCallback;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzbb extends zzcr {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final FullScreenContentCallback f69845a;

    public zzbb(FullScreenContentCallback fullScreenContentCallback) {
        this.f69845a = fullScreenContentCallback;
    }

    @Override // com.google.android.gms.ads.internal.client.zzcs
    public final void Y3(zze zzeVar) {
        FullScreenContentCallback fullScreenContentCallback = this.f69845a;
        if (fullScreenContentCallback != null) {
            fullScreenContentCallback.c(zzeVar.M());
        }
    }

    @Override // com.google.android.gms.ads.internal.client.zzcs
    public final void zzc() {
        FullScreenContentCallback fullScreenContentCallback = this.f69845a;
        if (fullScreenContentCallback != null) {
            fullScreenContentCallback.e();
        }
    }

    @Override // com.google.android.gms.ads.internal.client.zzcs
    public final void zzd() {
        FullScreenContentCallback fullScreenContentCallback = this.f69845a;
        if (fullScreenContentCallback != null) {
            fullScreenContentCallback.b();
        }
    }

    @Override // com.google.android.gms.ads.internal.client.zzcs
    public final void zze() {
        FullScreenContentCallback fullScreenContentCallback = this.f69845a;
        if (fullScreenContentCallback != null) {
            fullScreenContentCallback.d();
        }
    }

    @Override // com.google.android.gms.ads.internal.client.zzcs
    public final void zzf() {
        FullScreenContentCallback fullScreenContentCallback = this.f69845a;
        if (fullScreenContentCallback != null) {
            fullScreenContentCallback.a();
        }
    }
}
