package com.google.android.gms.maps;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.Marker;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzb extends com.google.android.gms.maps.internal.zzaw {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ GoogleMap.OnMarkerDragListener f73332a;

    zzb(GoogleMap googleMap, GoogleMap.OnMarkerDragListener onMarkerDragListener) {
        this.f73332a = onMarkerDragListener;
    }

    @Override // com.google.android.gms.maps.internal.zzax
    public final void b(com.google.android.gms.internal.maps.zzad zzadVar) {
        this.f73332a.b(new Marker(zzadVar));
    }

    @Override // com.google.android.gms.maps.internal.zzax
    public final void g(com.google.android.gms.internal.maps.zzad zzadVar) {
        this.f73332a.c(new Marker(zzadVar));
    }

    @Override // com.google.android.gms.maps.internal.zzax
    public final void n4(com.google.android.gms.internal.maps.zzad zzadVar) {
        this.f73332a.a(new Marker(zzadVar));
    }
}
