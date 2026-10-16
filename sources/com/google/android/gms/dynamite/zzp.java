package com.google.android.gms.dynamite;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzp extends com.google.android.gms.internal.common.zza implements IInterface {
    zzp(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.dynamite.IDynamiteLoader");
    }

    public final int h5(IObjectWrapper iObjectWrapper, String str, boolean z2) throws RemoteException {
        Parcel parcelZza = zza();
        com.google.android.gms.internal.common.zzc.zze(parcelZza, iObjectWrapper);
        parcelZza.writeString(str);
        parcelZza.writeInt(z2 ? 1 : 0);
        Parcel parcelZzB = zzB(3, parcelZza);
        int i3 = parcelZzB.readInt();
        parcelZzB.recycle();
        return i3;
    }

    public final IObjectWrapper i5(IObjectWrapper iObjectWrapper, String str, int i3) throws RemoteException {
        Parcel parcelZza = zza();
        com.google.android.gms.internal.common.zzc.zze(parcelZza, iObjectWrapper);
        parcelZza.writeString(str);
        parcelZza.writeInt(i3);
        Parcel parcelZzB = zzB(4, parcelZza);
        IObjectWrapper iObjectWrapperX3 = IObjectWrapper.Stub.x3(parcelZzB.readStrongBinder());
        parcelZzB.recycle();
        return iObjectWrapperX3;
    }

    public final int j5(IObjectWrapper iObjectWrapper, String str, boolean z2) throws RemoteException {
        Parcel parcelZza = zza();
        com.google.android.gms.internal.common.zzc.zze(parcelZza, iObjectWrapper);
        parcelZza.writeString(str);
        parcelZza.writeInt(z2 ? 1 : 0);
        Parcel parcelZzB = zzB(5, parcelZza);
        int i3 = parcelZzB.readInt();
        parcelZzB.recycle();
        return i3;
    }

    public final IObjectWrapper k5(IObjectWrapper iObjectWrapper, String str, boolean z2, long j3) throws RemoteException {
        Parcel parcelZza = zza();
        com.google.android.gms.internal.common.zzc.zze(parcelZza, iObjectWrapper);
        parcelZza.writeString(str);
        parcelZza.writeInt(z2 ? 1 : 0);
        parcelZza.writeLong(j3);
        Parcel parcelZzB = zzB(7, parcelZza);
        IObjectWrapper iObjectWrapperX3 = IObjectWrapper.Stub.x3(parcelZzB.readStrongBinder());
        parcelZzB.recycle();
        return iObjectWrapperX3;
    }

    public final IObjectWrapper l5(IObjectWrapper iObjectWrapper, String str, int i3, IObjectWrapper iObjectWrapper2) throws RemoteException {
        Parcel parcelZza = zza();
        com.google.android.gms.internal.common.zzc.zze(parcelZza, iObjectWrapper);
        parcelZza.writeString(str);
        parcelZza.writeInt(i3);
        com.google.android.gms.internal.common.zzc.zze(parcelZza, iObjectWrapper2);
        Parcel parcelZzB = zzB(8, parcelZza);
        IObjectWrapper iObjectWrapperX3 = IObjectWrapper.Stub.x3(parcelZzB.readStrongBinder());
        parcelZzB.recycle();
        return iObjectWrapperX3;
    }

    public final IObjectWrapper x3(IObjectWrapper iObjectWrapper, String str, int i3) throws RemoteException {
        Parcel parcelZza = zza();
        com.google.android.gms.internal.common.zzc.zze(parcelZza, iObjectWrapper);
        parcelZza.writeString(str);
        parcelZza.writeInt(i3);
        Parcel parcelZzB = zzB(2, parcelZza);
        IObjectWrapper iObjectWrapperX3 = IObjectWrapper.Stub.x3(parcelZzB.readStrongBinder());
        parcelZzB.recycle();
        return iObjectWrapperX3;
    }

    public final int zzi() throws RemoteException {
        Parcel parcelZzB = zzB(6, zza());
        int i3 = parcelZzB.readInt();
        parcelZzB.recycle();
        return i3;
    }
}
