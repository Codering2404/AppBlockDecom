package com.google.android.gms.maps;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.internal.zzbi;
import com.google.android.gms.maps.model.Polyline;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzp extends zzbi {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ GoogleMap.OnPolylineClickListener f73346a;

    zzp(GoogleMap googleMap, GoogleMap.OnPolylineClickListener onPolylineClickListener) {
        this.f73346a = onPolylineClickListener;
    }

    @Override // com.google.android.gms.maps.internal.zzbj
    public final void U2(com.google.android.gms.internal.maps.zzaj zzajVar) {
        this.f73346a.a(new Polyline(zzajVar));
    }
}
