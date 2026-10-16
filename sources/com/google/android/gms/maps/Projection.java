package com.google.android.gms.maps;

import android.graphics.Point;
import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.maps.internal.IProjectionDelegate;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.RuntimeRemoteException;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class Projection {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final IProjectionDelegate f73073a;

    Projection(IProjectionDelegate iProjectionDelegate) {
        this.f73073a = iProjectionDelegate;
    }

    public Point a(LatLng latLng) {
        Preconditions.m(latLng);
        try {
            return (Point) ObjectWrapper.h5(this.f73073a.p0(latLng));
        } catch (RemoteException e3) {
            throw new RuntimeRemoteException(e3);
        }
    }
}
