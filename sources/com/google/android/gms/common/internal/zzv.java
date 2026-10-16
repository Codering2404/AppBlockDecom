package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzv extends com.google.android.gms.internal.common.zza implements zzx {
    zzv(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.common.internal.ICertData");
    }

    @Override // com.google.android.gms.common.internal.zzx
    public final IObjectWrapper zzd() throws RemoteException {
        Parcel parcelZzB = zzB(1, zza());
        IObjectWrapper iObjectWrapperX3 = IObjectWrapper.Stub.x3(parcelZzB.readStrongBinder());
        parcelZzB.recycle();
        return iObjectWrapperX3;
    }

    @Override // com.google.android.gms.common.internal.zzx
    public final int zze() throws RemoteException {
        Parcel parcelZzB = zzB(2, zza());
        int i3 = parcelZzB.readInt();
        parcelZzB.recycle();
        return i3;
    }
}
