package com.google.android.gms.maps;

import com.google.android.gms.maps.GoogleMap;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzx extends com.google.android.gms.maps.internal.zzq {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ GoogleMap.OnCameraMoveCanceledListener f73354a;

    zzx(GoogleMap googleMap, GoogleMap.OnCameraMoveCanceledListener onCameraMoveCanceledListener) {
        this.f73354a = onCameraMoveCanceledListener;
    }

    @Override // com.google.android.gms.maps.internal.zzr
    public final void zzb() {
        this.f73354a.a();
    }
}
