package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public abstract class zzcbz extends zzbef implements zzcca {
    public zzcbz() {
        super("com.google.android.gms.ads.internal.reward.mediation.client.IMediationRewardedVideoAdListener");
    }

    public static zzcca zzb(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.reward.mediation.client.IMediationRewardedVideoAdListener");
        return iInterfaceQueryLocalInterface instanceof zzcca ? (zzcca) iInterfaceQueryLocalInterface : new zzcby(iBinder);
    }

    @Override // com.google.android.gms.internal.ads.zzbef
    protected final boolean zzdd(int i3, Parcel parcel, Parcel parcel2, int i4) throws RemoteException {
        switch (i3) {
            case 1:
                IObjectWrapper iObjectWrapperX3 = IObjectWrapper.Stub.x3(parcel.readStrongBinder());
                zzbeg.zzh(parcel);
                zze(iObjectWrapperX3);
                break;
            case 2:
                IObjectWrapper iObjectWrapperX32 = IObjectWrapper.Stub.x3(parcel.readStrongBinder());
                int i5 = parcel.readInt();
                zzbeg.zzh(parcel);
                zzf(iObjectWrapperX32, i5);
                break;
            case 3:
                IObjectWrapper iObjectWrapperX33 = IObjectWrapper.Stub.x3(parcel.readStrongBinder());
                zzbeg.zzh(parcel);
                zzg(iObjectWrapperX33);
                break;
            case 4:
                IObjectWrapper iObjectWrapperX34 = IObjectWrapper.Stub.x3(parcel.readStrongBinder());
                zzbeg.zzh(parcel);
                zzh(iObjectWrapperX34);
                break;
            case 5:
                IObjectWrapper iObjectWrapperX35 = IObjectWrapper.Stub.x3(parcel.readStrongBinder());
                zzbeg.zzh(parcel);
                zzi(iObjectWrapperX35);
                break;
            case 6:
                IObjectWrapper iObjectWrapperX36 = IObjectWrapper.Stub.x3(parcel.readStrongBinder());
                zzbeg.zzh(parcel);
                zzj(iObjectWrapperX36);
                break;
            case 7:
                IObjectWrapper iObjectWrapperX37 = IObjectWrapper.Stub.x3(parcel.readStrongBinder());
                zzccb zzccbVar = (zzccb) zzbeg.zzb(parcel, zzccb.CREATOR);
                zzbeg.zzh(parcel);
                zzk(iObjectWrapperX37, zzccbVar);
                break;
            case 8:
                IObjectWrapper iObjectWrapperX38 = IObjectWrapper.Stub.x3(parcel.readStrongBinder());
                zzbeg.zzh(parcel);
                zzl(iObjectWrapperX38);
                break;
            case 9:
                IObjectWrapper iObjectWrapperX39 = IObjectWrapper.Stub.x3(parcel.readStrongBinder());
                int i6 = parcel.readInt();
                zzbeg.zzh(parcel);
                zzm(iObjectWrapperX39, i6);
                break;
            case 10:
                IObjectWrapper iObjectWrapperX310 = IObjectWrapper.Stub.x3(parcel.readStrongBinder());
                zzbeg.zzh(parcel);
                zzn(iObjectWrapperX310);
                break;
            case 11:
                IObjectWrapper iObjectWrapperX311 = IObjectWrapper.Stub.x3(parcel.readStrongBinder());
                zzbeg.zzh(parcel);
                zzo(iObjectWrapperX311);
                break;
            case 12:
                zzbeg.zzh(parcel);
                break;
            case 13:
                IObjectWrapper iObjectWrapperX312 = IObjectWrapper.Stub.x3(parcel.readStrongBinder());
                zzbeg.zzh(parcel);
                zzp(iObjectWrapperX312);
                break;
            default:
                return false;
        }
        parcel2.writeNoException();
        return true;
    }
}
