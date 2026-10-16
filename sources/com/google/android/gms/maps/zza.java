package com.google.android.gms.maps;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.Marker;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zza extends com.google.android.gms.maps.internal.zzau {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ GoogleMap.OnMarkerClickListener f73279a;

    zza(GoogleMap googleMap, GoogleMap.OnMarkerClickListener onMarkerClickListener) {
        this.f73279a = onMarkerClickListener;
    }

    @Override // com.google.android.gms.maps.internal.zzav
    public final boolean b(com.google.android.gms.internal.maps.zzad zzadVar) {
        return this.f73279a.a(new Marker(zzadVar));
    }
}
