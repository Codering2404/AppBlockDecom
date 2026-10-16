package com.google.android.gms.maps;

import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.Marker;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzf extends com.google.android.gms.maps.internal.zzh {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ GoogleMap.InfoWindowAdapter f73336a;

    zzf(GoogleMap googleMap, GoogleMap.InfoWindowAdapter infoWindowAdapter) {
        this.f73336a = infoWindowAdapter;
    }

    @Override // com.google.android.gms.maps.internal.zzi
    public final IObjectWrapper b(com.google.android.gms.internal.maps.zzad zzadVar) {
        return ObjectWrapper.i5(this.f73336a.a(new Marker(zzadVar)));
    }

    @Override // com.google.android.gms.maps.internal.zzi
    public final IObjectWrapper g(com.google.android.gms.internal.maps.zzad zzadVar) {
        return ObjectWrapper.i5(this.f73336a.b(new Marker(zzadVar)));
    }
}
