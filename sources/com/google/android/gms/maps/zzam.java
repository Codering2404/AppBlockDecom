package com.google.android.gms.maps;

import com.google.android.gms.maps.StreetViewPanorama;
import com.google.android.gms.maps.internal.zzbq;
import com.google.android.gms.maps.model.StreetViewPanoramaOrientation;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzam extends zzbq {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ StreetViewPanorama.OnStreetViewPanoramaLongClickListener f73301a;

    zzam(StreetViewPanorama streetViewPanorama, StreetViewPanorama.OnStreetViewPanoramaLongClickListener onStreetViewPanoramaLongClickListener) {
        this.f73301a = onStreetViewPanoramaLongClickListener;
    }

    @Override // com.google.android.gms.maps.internal.zzbr
    public final void m(StreetViewPanoramaOrientation streetViewPanoramaOrientation) {
        this.f73301a.a(streetViewPanoramaOrientation);
    }
}
