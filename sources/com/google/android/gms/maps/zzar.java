package com.google.android.gms.maps;

import com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate;
import com.google.android.gms.maps.internal.zzbs;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzar extends zzbs {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ OnStreetViewPanoramaReadyCallback f73309a;

    zzar(zzas zzasVar, OnStreetViewPanoramaReadyCallback onStreetViewPanoramaReadyCallback) {
        this.f73309a = onStreetViewPanoramaReadyCallback;
    }

    @Override // com.google.android.gms.maps.internal.zzbt
    public final void s2(IStreetViewPanoramaDelegate iStreetViewPanoramaDelegate) {
        this.f73309a.a(new StreetViewPanorama(iStreetViewPanoramaDelegate));
    }
}
