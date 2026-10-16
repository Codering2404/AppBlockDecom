package com.google.android.libraries.places.internal;

import com.google.android.gms.maps.model.LatLng;
import com.google.android.libraries.places.api.model.CircularBounds;
import com.google.android.libraries.places.api.model.RectangularBounds;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzhq {
    zzhq() {
    }

    static final zzbht a(LatLng latLng) {
        zzbhs zzbhsVarI = zzbht.I();
        zzbhsVarI.y(latLng.f73163a);
        zzbhsVarI.z(latLng.f73164b);
        return (zzbht) zzbhsVarI.zzG();
    }

    static final zzaxc b(CircularBounds circularBounds) {
        LatLng latLngC = circularBounds.c();
        zzaxb zzaxbVarG = zzaxc.G();
        zzbhs zzbhsVarI = zzbht.I();
        zzbhsVarI.y(latLngC.f73163a);
        zzbhsVarI.z(latLngC.f73164b);
        zzaxbVarG.y(zzbhsVarI);
        zzaxbVarG.z(circularBounds.d());
        return (zzaxc) zzaxbVarG.zzG();
    }

    static final zzaua c(RectangularBounds rectangularBounds) {
        LatLng latLngD = rectangularBounds.d();
        LatLng latLngC = rectangularBounds.c();
        zzatz zzatzVarI = zzaua.I();
        zzbhs zzbhsVarI = zzbht.I();
        zzbhsVarI.y(latLngD.f73163a);
        zzbhsVarI.z(latLngD.f73164b);
        zzatzVarI.y((zzbht) zzbhsVarI.zzG());
        zzbhs zzbhsVarI2 = zzbht.I();
        zzbhsVarI2.y(latLngC.f73163a);
        zzbhsVarI2.z(latLngC.f73164b);
        zzatzVarI.z((zzbht) zzbhsVarI2.zzG());
        return (zzaua) zzatzVarI.zzG();
    }
}
