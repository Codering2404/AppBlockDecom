package com.google.android.gms.maps;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.LatLng;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzz extends com.google.android.gms.maps.internal.zzam {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ GoogleMap.OnMapClickListener f73356a;

    zzz(GoogleMap googleMap, GoogleMap.OnMapClickListener onMapClickListener) {
        this.f73356a = onMapClickListener;
    }

    @Override // com.google.android.gms.maps.internal.zzan
    public final void i(LatLng latLng) {
        this.f73356a.a(latLng);
    }
}
