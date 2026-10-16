package com.google.android.gms.internal.ads;

import android.net.Uri;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public abstract class zzcel extends zzbef implements zzcem {
    public zzcel() {
        super("com.google.android.gms.ads.internal.signals.ISignalGenerator");
    }

    public static zzcem zzb(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.signals.ISignalGenerator");
        return iInterfaceQueryLocalInterface instanceof zzcem ? (zzcem) iInterfaceQueryLocalInterface : new zzcek(iBinder);
    }

    @Override // com.google.android.gms.internal.ads.zzbef
    protected final boolean zzdd(int i3, Parcel parcel, Parcel parcel2, int i4) throws RemoteException {
        zzcej zzcehVar = null;
        switch (i3) {
            case 1:
                IObjectWrapper iObjectWrapperX3 = IObjectWrapper.Stub.x3(parcel.readStrongBinder());
                zzceq zzceqVar = (zzceq) zzbeg.zzb(parcel, zzceq.CREATOR);
                IBinder strongBinder = parcel.readStrongBinder();
                if (strongBinder != null) {
                    IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.ads.internal.signals.ISignalCallback");
                    zzcehVar = iInterfaceQueryLocalInterface instanceof zzcej ? (zzcej) iInterfaceQueryLocalInterface : new zzceh(strongBinder);
                }
                zzbeg.zzh(parcel);
                zze(iObjectWrapperX3, zzceqVar, zzcehVar);
                parcel2.writeNoException();
                return true;
            case 2:
                IObjectWrapper iObjectWrapperX32 = IObjectWrapper.Stub.x3(parcel.readStrongBinder());
                zzbeg.zzh(parcel);
                zzf(iObjectWrapperX32);
                parcel2.writeNoException();
                return true;
            case 3:
                IObjectWrapper.Stub.x3(parcel.readStrongBinder());
                IObjectWrapper.Stub.x3(parcel.readStrongBinder());
                zzbeg.zzh(parcel);
                parcel2.writeNoException();
                zzbeg.zze(parcel2, null);
                return true;
            case 4:
                IObjectWrapper.Stub.x3(parcel.readStrongBinder());
                zzbeg.zzh(parcel);
                parcel2.writeNoException();
                zzbeg.zze(parcel2, null);
                return true;
            case 5:
                ArrayList arrayListCreateTypedArrayList = parcel.createTypedArrayList(Uri.CREATOR);
                IObjectWrapper iObjectWrapperX33 = IObjectWrapper.Stub.x3(parcel.readStrongBinder());
                zzbzq zzbzqVarZzb = zzbzp.zzb(parcel.readStrongBinder());
                zzbeg.zzh(parcel);
                zzg(arrayListCreateTypedArrayList, iObjectWrapperX33, zzbzqVarZzb);
                parcel2.writeNoException();
                return true;
            case 6:
                ArrayList arrayListCreateTypedArrayList2 = parcel.createTypedArrayList(Uri.CREATOR);
                IObjectWrapper iObjectWrapperX34 = IObjectWrapper.Stub.x3(parcel.readStrongBinder());
                zzbzq zzbzqVarZzb2 = zzbzp.zzb(parcel.readStrongBinder());
                zzbeg.zzh(parcel);
                zzh(arrayListCreateTypedArrayList2, iObjectWrapperX34, zzbzqVarZzb2);
                parcel2.writeNoException();
                return true;
            case 7:
                zzbzt zzbztVar = (zzbzt) zzbeg.zzb(parcel, zzbzt.CREATOR);
                zzbeg.zzh(parcel);
                zzi(zzbztVar);
                parcel2.writeNoException();
                return true;
            case 8:
                IObjectWrapper iObjectWrapperX35 = IObjectWrapper.Stub.x3(parcel.readStrongBinder());
                zzbeg.zzh(parcel);
                zzj(iObjectWrapperX35);
                parcel2.writeNoException();
                return true;
            case 9:
                ArrayList arrayListCreateTypedArrayList3 = parcel.createTypedArrayList(Uri.CREATOR);
                IObjectWrapper iObjectWrapperX36 = IObjectWrapper.Stub.x3(parcel.readStrongBinder());
                zzbzq zzbzqVarZzb3 = zzbzp.zzb(parcel.readStrongBinder());
                zzbeg.zzh(parcel);
                zzk(arrayListCreateTypedArrayList3, iObjectWrapperX36, zzbzqVarZzb3);
                parcel2.writeNoException();
                return true;
            case 10:
                ArrayList arrayListCreateTypedArrayList4 = parcel.createTypedArrayList(Uri.CREATOR);
                IObjectWrapper iObjectWrapperX37 = IObjectWrapper.Stub.x3(parcel.readStrongBinder());
                zzbzq zzbzqVarZzb4 = zzbzp.zzb(parcel.readStrongBinder());
                zzbeg.zzh(parcel);
                zzl(arrayListCreateTypedArrayList4, iObjectWrapperX37, zzbzqVarZzb4);
                parcel2.writeNoException();
                return true;
            case 11:
                IObjectWrapper iObjectWrapperX38 = IObjectWrapper.Stub.x3(parcel.readStrongBinder());
                IObjectWrapper iObjectWrapperX39 = IObjectWrapper.Stub.x3(parcel.readStrongBinder());
                String string = parcel.readString();
                IObjectWrapper iObjectWrapperX310 = IObjectWrapper.Stub.x3(parcel.readStrongBinder());
                zzbeg.zzh(parcel);
                IObjectWrapper iObjectWrapperZzm = zzm(iObjectWrapperX38, iObjectWrapperX39, string, iObjectWrapperX310);
                parcel2.writeNoException();
                zzbeg.zze(parcel2, iObjectWrapperZzm);
                return true;
            default:
                return false;
        }
    }
}
