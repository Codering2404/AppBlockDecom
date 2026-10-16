package com.google.android.gms.maps;

import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.maps.internal.ICameraUpdateFactoryDelegate;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.RuntimeRemoteException;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class CameraUpdateFactory {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static ICameraUpdateFactoryDelegate f73040a;

    public static CameraUpdate a(CameraPosition cameraPosition) {
        Preconditions.n(cameraPosition, "cameraPosition must not be null");
        try {
            return new CameraUpdate(e().q1(cameraPosition));
        } catch (RemoteException e3) {
            throw new RuntimeRemoteException(e3);
        }
    }

    public static CameraUpdate b(LatLngBounds latLngBounds, int i3) {
        Preconditions.n(latLngBounds, "bounds must not be null");
        try {
            return new CameraUpdate(e().G(latLngBounds, i3));
        } catch (RemoteException e3) {
            throw new RuntimeRemoteException(e3);
        }
    }

    public static CameraUpdate c(LatLng latLng, float f3) {
        Preconditions.n(latLng, "latLng must not be null");
        try {
            return new CameraUpdate(e().V1(latLng, f3));
        } catch (RemoteException e3) {
            throw new RuntimeRemoteException(e3);
        }
    }

    public static void d(ICameraUpdateFactoryDelegate iCameraUpdateFactoryDelegate) {
        f73040a = (ICameraUpdateFactoryDelegate) Preconditions.m(iCameraUpdateFactoryDelegate);
    }

    private static ICameraUpdateFactoryDelegate e() {
        return (ICameraUpdateFactoryDelegate) Preconditions.n(f73040a, "CameraUpdateFactory is not initialized");
    }
}
