package com.google.android.gms.maps;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.Marker;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzd extends com.google.android.gms.maps.internal.zzag {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ GoogleMap.OnInfoWindowLongClickListener f73334a;

    zzd(GoogleMap googleMap, GoogleMap.OnInfoWindowLongClickListener onInfoWindowLongClickListener) {
        this.f73334a = onInfoWindowLongClickListener;
    }

    @Override // com.google.android.gms.maps.internal.zzah
    public final void b(com.google.android.gms.internal.maps.zzad zzadVar) {
        this.f73334a.a(new Marker(zzadVar));
    }
}
