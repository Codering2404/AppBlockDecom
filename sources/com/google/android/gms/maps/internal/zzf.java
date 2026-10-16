package com.google.android.gms.maps.internal;

import android.os.IInterface;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.maps.GoogleMapOptions;
import com.google.android.gms.maps.StreetViewPanoramaOptions;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public interface zzf extends IInterface {
    void P2(IObjectWrapper iObjectWrapper, int i3);

    IMapViewDelegate f4(IObjectWrapper iObjectWrapper, GoogleMapOptions googleMapOptions);

    IStreetViewPanoramaViewDelegate m1(IObjectWrapper iObjectWrapper, StreetViewPanoramaOptions streetViewPanoramaOptions);

    void y2(IObjectWrapper iObjectWrapper, int i3);

    int zzd();

    ICameraUpdateFactoryDelegate zze();

    IMapFragmentDelegate zzf(IObjectWrapper iObjectWrapper);

    IStreetViewPanoramaFragmentDelegate zzh(IObjectWrapper iObjectWrapper);

    com.google.android.gms.internal.maps.zzi zzj();

    void zzm(IObjectWrapper iObjectWrapper);
}
