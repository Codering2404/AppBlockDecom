package com.google.android.gms.maps;

import com.google.android.gms.maps.GoogleMap;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzj extends com.google.android.gms.maps.internal.zzao {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ GoogleMap.OnMapLoadedCallback f73340a;

    zzj(GoogleMap googleMap, GoogleMap.OnMapLoadedCallback onMapLoadedCallback) {
        this.f73340a = onMapLoadedCallback;
    }

    @Override // com.google.android.gms.maps.internal.zzap
    public final void zzb() {
        this.f73340a.a();
    }
}
