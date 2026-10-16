package com.google.android.gms.maps;

import com.google.android.gms.maps.GoogleMap;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzw extends com.google.android.gms.maps.internal.zzs {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ GoogleMap.OnCameraMoveListener f73353a;

    zzw(GoogleMap googleMap, GoogleMap.OnCameraMoveListener onCameraMoveListener) {
        this.f73353a = onCameraMoveListener;
    }

    @Override // com.google.android.gms.maps.internal.zzt
    public final void zzb() {
        this.f73353a.a();
    }
}
