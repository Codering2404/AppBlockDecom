package com.google.android.gms.common.moduleinstall.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.api.internal.IStatusCallback;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class zaf extends com.google.android.gms.internal.base.zaa implements IInterface {
    zaf(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.common.moduleinstall.internal.IModuleInstallService");
    }

    public final void h5(zae zaeVar, ApiFeatureRequest apiFeatureRequest) throws RemoteException {
        Parcel parcelZaa = zaa();
        com.google.android.gms.internal.base.zac.zad(parcelZaa, zaeVar);
        com.google.android.gms.internal.base.zac.zac(parcelZaa, apiFeatureRequest);
        zac(3, parcelZaa);
    }

    public final void i5(zae zaeVar, ApiFeatureRequest apiFeatureRequest, zah zahVar) throws RemoteException {
        Parcel parcelZaa = zaa();
        com.google.android.gms.internal.base.zac.zad(parcelZaa, zaeVar);
        com.google.android.gms.internal.base.zac.zac(parcelZaa, apiFeatureRequest);
        com.google.android.gms.internal.base.zac.zad(parcelZaa, zahVar);
        zac(2, parcelZaa);
    }

    public final void j5(IStatusCallback iStatusCallback, ApiFeatureRequest apiFeatureRequest) throws RemoteException {
        Parcel parcelZaa = zaa();
        com.google.android.gms.internal.base.zac.zad(parcelZaa, iStatusCallback);
        com.google.android.gms.internal.base.zac.zac(parcelZaa, apiFeatureRequest);
        zac(4, parcelZaa);
    }

    public final void k5(IStatusCallback iStatusCallback, zah zahVar) throws RemoteException {
        Parcel parcelZaa = zaa();
        com.google.android.gms.internal.base.zac.zad(parcelZaa, iStatusCallback);
        com.google.android.gms.internal.base.zac.zad(parcelZaa, zahVar);
        zac(6, parcelZaa);
    }

    public final void x3(zae zaeVar, ApiFeatureRequest apiFeatureRequest) throws RemoteException {
        Parcel parcelZaa = zaa();
        com.google.android.gms.internal.base.zac.zad(parcelZaa, zaeVar);
        com.google.android.gms.internal.base.zac.zac(parcelZaa, apiFeatureRequest);
        zac(1, parcelZaa);
    }
}
