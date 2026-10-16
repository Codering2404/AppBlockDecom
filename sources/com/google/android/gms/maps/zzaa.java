package com.google.android.gms.maps;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.LatLng;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzaa extends com.google.android.gms.maps.internal.zzaq {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ GoogleMap.OnMapLongClickListener f73280a;

    zzaa(GoogleMap googleMap, GoogleMap.OnMapLongClickListener onMapLongClickListener) {
        this.f73280a = onMapLongClickListener;
    }

    @Override // com.google.android.gms.maps.internal.zzar
    public final void i(LatLng latLng) {
        this.f73280a.a(latLng);
    }
}
