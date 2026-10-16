package com.google.android.gms.maps;

import com.google.android.gms.maps.GoogleMap;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzh extends com.google.android.gms.maps.internal.zzay {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ GoogleMap.OnMyLocationButtonClickListener f73338a;

    zzh(GoogleMap googleMap, GoogleMap.OnMyLocationButtonClickListener onMyLocationButtonClickListener) {
        this.f73338a = onMyLocationButtonClickListener;
    }

    @Override // com.google.android.gms.maps.internal.zzaz
    public final boolean zzb() {
        return this.f73338a.a();
    }
}
