package com.google.android.gms.maps;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.Marker;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zze extends com.google.android.gms.maps.internal.zzae {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ GoogleMap.OnInfoWindowCloseListener f73335a;

    zze(GoogleMap googleMap, GoogleMap.OnInfoWindowCloseListener onInfoWindowCloseListener) {
        this.f73335a = onInfoWindowCloseListener;
    }

    @Override // com.google.android.gms.maps.internal.zzaf
    public final void b(com.google.android.gms.internal.maps.zzad zzadVar) {
        this.f73335a.a(new Marker(zzadVar));
    }
}
