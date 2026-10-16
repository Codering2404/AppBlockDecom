package com.google.android.gms.dynamite;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzq extends com.google.android.gms.internal.common.zza implements IInterface {
    zzq(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.dynamite.IDynamiteLoaderV2");
    }

    public final IObjectWrapper h5(IObjectWrapper iObjectWrapper, String str, int i3, IObjectWrapper iObjectWrapper2) throws RemoteException {
        Parcel parcelZza = zza();
        com.google.android.gms.internal.common.zzc.zze(parcelZza, iObjectWrapper);
        parcelZza.writeString(str);
        parcelZza.writeInt(i3);
        com.google.android.gms.internal.common.zzc.zze(parcelZza, iObjectWrapper2);
        Parcel parcelZzB = zzB(3, parcelZza);
        IObjectWrapper iObjectWrapperX3 = IObjectWrapper.Stub.x3(parcelZzB.readStrongBinder());
        parcelZzB.recycle();
        return iObjectWrapperX3;
    }

    public final IObjectWrapper x3(IObjectWrapper iObjectWrapper, String str, int i3, IObjectWrapper iObjectWrapper2) throws RemoteException {
        Parcel parcelZza = zza();
        com.google.android.gms.internal.common.zzc.zze(parcelZza, iObjectWrapper);
        parcelZza.writeString(str);
        parcelZza.writeInt(i3);
        com.google.android.gms.internal.common.zzc.zze(parcelZza, iObjectWrapper2);
        Parcel parcelZzB = zzB(2, parcelZza);
        IObjectWrapper iObjectWrapperX3 = IObjectWrapper.Stub.x3(parcelZzB.readStrongBinder());
        parcelZzB.recycle();
        return iObjectWrapperX3;
    }
}
