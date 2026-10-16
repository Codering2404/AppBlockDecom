package com.google.android.gms.maps;

import com.google.android.gms.maps.GoogleMap;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzy extends com.google.android.gms.maps.internal.zzo {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ GoogleMap.OnCameraIdleListener f73355a;

    zzy(GoogleMap googleMap, GoogleMap.OnCameraIdleListener onCameraIdleListener) {
        this.f73355a = onCameraIdleListener;
    }

    @Override // com.google.android.gms.maps.internal.zzp
    public final void zzb() {
        this.f73355a.a();
    }
}
