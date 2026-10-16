package com.google.android.gms.maps;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.internal.zzbe;
import com.google.android.gms.maps.model.PointOfInterest;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzr extends zzbe {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ GoogleMap.OnPoiClickListener f73348a;

    zzr(GoogleMap googleMap, GoogleMap.OnPoiClickListener onPoiClickListener) {
        this.f73348a = onPoiClickListener;
    }

    @Override // com.google.android.gms.maps.internal.zzbf
    public final void Q(PointOfInterest pointOfInterest) {
        this.f73348a.a(pointOfInterest);
    }
}
