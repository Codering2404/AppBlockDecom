package com.google.android.gms.maps;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.internal.zzbg;
import com.google.android.gms.maps.model.Polygon;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzo extends zzbg {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ GoogleMap.OnPolygonClickListener f73345a;

    zzo(GoogleMap googleMap, GoogleMap.OnPolygonClickListener onPolygonClickListener) {
        this.f73345a = onPolygonClickListener;
    }

    @Override // com.google.android.gms.maps.internal.zzbh
    public final void U3(com.google.android.gms.internal.maps.zzag zzagVar) {
        this.f73345a.a(new Polygon(zzagVar));
    }
}
