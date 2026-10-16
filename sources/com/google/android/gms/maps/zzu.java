package com.google.android.gms.maps;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.CameraPosition;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzu extends com.google.android.gms.maps.internal.zzm {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ GoogleMap.OnCameraChangeListener f73351a;

    @Override // com.google.android.gms.maps.internal.zzn
    public final void A1(CameraPosition cameraPosition) {
        this.f73351a.a(cameraPosition);
    }
}
