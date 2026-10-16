package com.google.android.gms.maps;

import com.google.android.gms.maps.StreetViewPanorama;
import com.google.android.gms.maps.internal.zzbm;
import com.google.android.gms.maps.model.StreetViewPanoramaLocation;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzaj extends zzbm {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ StreetViewPanorama.OnStreetViewPanoramaChangeListener f73298a;

    zzaj(StreetViewPanorama streetViewPanorama, StreetViewPanorama.OnStreetViewPanoramaChangeListener onStreetViewPanoramaChangeListener) {
        this.f73298a = onStreetViewPanoramaChangeListener;
    }

    @Override // com.google.android.gms.maps.internal.zzbn
    public final void f2(StreetViewPanoramaLocation streetViewPanoramaLocation) {
        this.f73298a.a(streetViewPanoramaLocation);
    }
}
