package com.google.android.gms.maps;

import android.location.Location;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.internal.zzba;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzg extends zzba {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ GoogleMap.OnMyLocationChangeListener f73337a;

    @Override // com.google.android.gms.maps.internal.zzbb
    public final void zzb(IObjectWrapper iObjectWrapper) {
        this.f73337a.a((Location) ObjectWrapper.h5(iObjectWrapper));
    }
}
