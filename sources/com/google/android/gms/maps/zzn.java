package com.google.android.gms.maps;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.Circle;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzn extends com.google.android.gms.maps.internal.zzw {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ GoogleMap.OnCircleClickListener f73344a;

    zzn(GoogleMap googleMap, GoogleMap.OnCircleClickListener onCircleClickListener) {
        this.f73344a = onCircleClickListener;
    }

    @Override // com.google.android.gms.maps.internal.zzx
    public final void x4(com.google.android.gms.internal.maps.zzl zzlVar) {
        this.f73344a.a(new Circle(zzlVar));
    }
}
