package com.google.android.gms.maps.internal;

import android.os.Bundle;
import android.os.IInterface;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.maps.GoogleMapOptions;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public interface IMapFragmentDelegate extends IInterface {
    void d();

    void e3(IObjectWrapper iObjectWrapper, GoogleMapOptions googleMapOptions, Bundle bundle);

    void onCreate(Bundle bundle);

    void onDestroy();

    void onLowMemory();

    void onPause();

    void onResume();

    void onSaveInstanceState(Bundle bundle);

    void onStart();

    void onStop();

    void s(zzat zzatVar);

    IObjectWrapper t(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2, Bundle bundle);
}
