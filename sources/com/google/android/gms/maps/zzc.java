package com.google.android.gms.maps;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.Marker;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzc extends com.google.android.gms.maps.internal.zzac {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ GoogleMap.OnInfoWindowClickListener f73333a;

    zzc(GoogleMap googleMap, GoogleMap.OnInfoWindowClickListener onInfoWindowClickListener) {
        this.f73333a = onInfoWindowClickListener;
    }

    @Override // com.google.android.gms.maps.internal.zzad
    public final void b(com.google.android.gms.internal.maps.zzad zzadVar) {
        this.f73333a.a(new Marker(zzadVar));
    }
}
