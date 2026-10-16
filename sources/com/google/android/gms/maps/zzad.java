package com.google.android.gms.maps;

import com.google.android.gms.maps.internal.IGoogleMapDelegate;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzad extends com.google.android.gms.maps.internal.zzas {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ OnMapReadyCallback f73282a;

    zzad(zzae zzaeVar, OnMapReadyCallback onMapReadyCallback) {
        this.f73282a = onMapReadyCallback;
    }

    @Override // com.google.android.gms.maps.internal.zzat
    public final void L2(IGoogleMapDelegate iGoogleMapDelegate) {
        this.f73282a.a(new GoogleMap(iGoogleMapDelegate));
    }
}
