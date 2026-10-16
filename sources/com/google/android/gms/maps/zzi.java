package com.google.android.gms.maps;

import android.location.Location;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.internal.zzbc;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzi extends zzbc {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ GoogleMap.OnMyLocationClickListener f73339a;

    zzi(GoogleMap googleMap, GoogleMap.OnMyLocationClickListener onMyLocationClickListener) {
        this.f73339a = onMyLocationClickListener;
    }

    @Override // com.google.android.gms.maps.internal.zzbd
    public final void z0(Location location) {
        this.f73339a.a(location);
    }
}
