package com.google.android.gms.maps;

import com.google.android.gms.maps.StreetViewPanorama;
import com.google.android.gms.maps.internal.zzbo;
import com.google.android.gms.maps.model.StreetViewPanoramaOrientation;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzal extends zzbo {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ StreetViewPanorama.OnStreetViewPanoramaClickListener f73300a;

    zzal(StreetViewPanorama streetViewPanorama, StreetViewPanorama.OnStreetViewPanoramaClickListener onStreetViewPanoramaClickListener) {
        this.f73300a = onStreetViewPanoramaClickListener;
    }

    @Override // com.google.android.gms.maps.internal.zzbp
    public final void m(StreetViewPanoramaOrientation streetViewPanoramaOrientation) {
        this.f73300a.a(streetViewPanoramaOrientation);
    }
}
