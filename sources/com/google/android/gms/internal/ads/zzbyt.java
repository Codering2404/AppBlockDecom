package com.google.android.gms.internal.ads;

import android.content.Intent;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public abstract class zzbyt extends zzbef implements zzbyu {
    public zzbyt() {
        super("com.google.android.gms.ads.internal.offline.IOfflineUtils");
    }

    public static zzbyu zzb(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.offline.IOfflineUtils");
        return iInterfaceQueryLocalInterface instanceof zzbyu ? (zzbyu) iInterfaceQueryLocalInterface : new zzbys(iBinder);
    }

    @Override // com.google.android.gms.internal.ads.zzbef
    protected final boolean zzdd(int i3, Parcel parcel, Parcel parcel2, int i4) throws RemoteException {
        switch (i3) {
            case 1:
                Intent intent = (Intent) zzbeg.zzb(parcel, Intent.CREATOR);
                zzbeg.zzh(parcel);
                zze(intent);
                break;
            case 2:
                IObjectWrapper iObjectWrapperX3 = IObjectWrapper.Stub.x3(parcel.readStrongBinder());
                String string = parcel.readString();
                String string2 = parcel.readString();
                zzbeg.zzh(parcel);
                zzf(iObjectWrapperX3, string, string2);
                break;
            case 3:
                zzg();
                break;
            case 4:
                IObjectWrapper iObjectWrapperX32 = IObjectWrapper.Stub.x3(parcel.readStrongBinder());
                zzbeg.zzh(parcel);
                zzh(iObjectWrapperX32);
                break;
            case 5:
                String[] strArrCreateStringArray = parcel.createStringArray();
                int[] iArrCreateIntArray = parcel.createIntArray();
                IObjectWrapper iObjectWrapperX33 = IObjectWrapper.Stub.x3(parcel.readStrongBinder());
                zzbeg.zzh(parcel);
                zzi(strArrCreateStringArray, iArrCreateIntArray, iObjectWrapperX33);
                break;
            case 6:
                IObjectWrapper iObjectWrapperX34 = IObjectWrapper.Stub.x3(parcel.readStrongBinder());
                com.google.android.gms.ads.internal.offline.buffering.zza zzaVar = (com.google.android.gms.ads.internal.offline.buffering.zza) zzbeg.zzb(parcel, com.google.android.gms.ads.internal.offline.buffering.zza.CREATOR);
                zzbeg.zzh(parcel);
                zzj(iObjectWrapperX34, zzaVar);
                break;
            default:
                return false;
        }
        parcel2.writeNoException();
        return true;
    }
}
