package com.google.android.gms.maps;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.GroundOverlay;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzm extends com.google.android.gms.maps.internal.zzy {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ GoogleMap.OnGroundOverlayClickListener f73343a;

    zzm(GoogleMap googleMap, GoogleMap.OnGroundOverlayClickListener onGroundOverlayClickListener) {
        this.f73343a = onGroundOverlayClickListener;
    }

    @Override // com.google.android.gms.maps.internal.zzz
    public final void O0(com.google.android.gms.internal.maps.zzr zzrVar) {
        this.f73343a.a(new GroundOverlay(zzrVar));
    }
}
