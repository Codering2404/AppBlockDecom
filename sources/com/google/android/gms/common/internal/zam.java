package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class zam extends com.google.android.gms.internal.base.zaa implements IInterface {
    zam(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.common.internal.ISignInButtonCreator");
    }

    public final IObjectWrapper x3(IObjectWrapper iObjectWrapper, zax zaxVar) throws RemoteException {
        Parcel parcelZaa = zaa();
        com.google.android.gms.internal.base.zac.zad(parcelZaa, iObjectWrapper);
        com.google.android.gms.internal.base.zac.zac(parcelZaa, zaxVar);
        Parcel parcelZab = zab(2, parcelZaa);
        IObjectWrapper iObjectWrapperX3 = IObjectWrapper.Stub.x3(parcelZab.readStrongBinder());
        parcelZab.recycle();
        return iObjectWrapperX3;
    }
}
