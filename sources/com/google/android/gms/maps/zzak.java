package com.google.android.gms.maps;

import com.google.android.gms.maps.StreetViewPanorama;
import com.google.android.gms.maps.internal.zzbk;
import com.google.android.gms.maps.model.StreetViewPanoramaCamera;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzak extends zzbk {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ StreetViewPanorama.OnStreetViewPanoramaCameraChangeListener f73299a;

    zzak(StreetViewPanorama streetViewPanorama, StreetViewPanorama.OnStreetViewPanoramaCameraChangeListener onStreetViewPanoramaCameraChangeListener) {
        this.f73299a = onStreetViewPanoramaCameraChangeListener;
    }

    @Override // com.google.android.gms.maps.internal.zzbl
    public final void J1(StreetViewPanoramaCamera streetViewPanoramaCamera) {
        this.f73299a.a(streetViewPanoramaCamera);
    }
}
