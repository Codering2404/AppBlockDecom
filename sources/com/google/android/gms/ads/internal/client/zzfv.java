package com.google.android.gms.ads.internal.client;

import com.google.android.gms.ads.VideoController;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzfv extends zzec {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final VideoController.VideoLifecycleCallbacks f69955a;

    public zzfv(VideoController.VideoLifecycleCallbacks videoLifecycleCallbacks) {
        this.f69955a = videoLifecycleCallbacks;
    }

    @Override // com.google.android.gms.ads.internal.client.zzed
    public final void t1(boolean z2) {
        this.f69955a.onVideoMute(z2);
    }

    @Override // com.google.android.gms.ads.internal.client.zzed
    public final void zze() {
        this.f69955a.onVideoStart();
    }

    @Override // com.google.android.gms.ads.internal.client.zzed
    public final void zzf() {
        this.f69955a.onVideoPlay();
    }

    @Override // com.google.android.gms.ads.internal.client.zzed
    public final void zzg() {
        this.f69955a.onVideoPause();
    }

    @Override // com.google.android.gms.ads.internal.client.zzed
    public final void zzh() {
        this.f69955a.onVideoEnd();
    }
}
