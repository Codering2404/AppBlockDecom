package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public abstract class zzbvq extends zzbef implements zzbvr {
    public zzbvq() {
        super("com.google.android.gms.ads.internal.mediation.client.IUnifiedNativeAdMapper");
    }

    public static zzbvr zzb(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.IUnifiedNativeAdMapper");
        return iInterfaceQueryLocalInterface instanceof zzbvr ? (zzbvr) iInterfaceQueryLocalInterface : new zzbvp(iBinder);
    }

    @Override // com.google.android.gms.internal.ads.zzbef
    protected final boolean zzdd(int i3, Parcel parcel, Parcel parcel2, int i4) throws RemoteException {
        switch (i3) {
            case 2:
                String strZze = zze();
                parcel2.writeNoException();
                parcel2.writeString(strZze);
                return true;
            case 3:
                List listZzf = zzf();
                parcel2.writeNoException();
                parcel2.writeList(listZzf);
                return true;
            case 4:
                String strZzg = zzg();
                parcel2.writeNoException();
                parcel2.writeString(strZzg);
                return true;
            case 5:
                zzbme zzbmeVarZzh = zzh();
                parcel2.writeNoException();
                zzbeg.zze(parcel2, zzbmeVarZzh);
                return true;
            case 6:
                String strZzi = zzi();
                parcel2.writeNoException();
                parcel2.writeString(strZzi);
                return true;
            case 7:
                String strZzj = zzj();
                parcel2.writeNoException();
                parcel2.writeString(strZzj);
                return true;
            case 8:
                double dZzk = zzk();
                parcel2.writeNoException();
                parcel2.writeDouble(dZzk);
                return true;
            case 9:
                String strZzl = zzl();
                parcel2.writeNoException();
                parcel2.writeString(strZzl);
                return true;
            case 10:
                String strZzm = zzm();
                parcel2.writeNoException();
                parcel2.writeString(strZzm);
                return true;
            case 11:
                com.google.android.gms.ads.internal.client.zzea zzeaVarZzn = zzn();
                parcel2.writeNoException();
                zzbeg.zze(parcel2, zzeaVarZzn);
                return true;
            case 12:
                parcel2.writeNoException();
                zzbeg.zze(parcel2, null);
                return true;
            case 13:
                IObjectWrapper iObjectWrapperZzp = zzp();
                parcel2.writeNoException();
                zzbeg.zze(parcel2, iObjectWrapperZzp);
                return true;
            case 14:
                IObjectWrapper iObjectWrapperZzq = zzq();
                parcel2.writeNoException();
                zzbeg.zze(parcel2, iObjectWrapperZzq);
                return true;
            case 15:
                IObjectWrapper iObjectWrapperZzr = zzr();
                parcel2.writeNoException();
                zzbeg.zze(parcel2, iObjectWrapperZzr);
                return true;
            case 16:
                Bundle bundleZzs = zzs();
                parcel2.writeNoException();
                zzbeg.zzd(parcel2, bundleZzs);
                return true;
            case 17:
                boolean zZzt = zzt();
                parcel2.writeNoException();
                int i5 = zzbeg.zza;
                parcel2.writeInt(zZzt ? 1 : 0);
                return true;
            case 18:
                boolean zZzu = zzu();
                parcel2.writeNoException();
                int i6 = zzbeg.zza;
                parcel2.writeInt(zZzu ? 1 : 0);
                return true;
            case 19:
                zzv();
                parcel2.writeNoException();
                return true;
            case 20:
                IObjectWrapper iObjectWrapperX3 = IObjectWrapper.Stub.x3(parcel.readStrongBinder());
                zzbeg.zzh(parcel);
                zzw(iObjectWrapperX3);
                parcel2.writeNoException();
                return true;
            case 21:
                IObjectWrapper iObjectWrapperX32 = IObjectWrapper.Stub.x3(parcel.readStrongBinder());
                IObjectWrapper iObjectWrapperX33 = IObjectWrapper.Stub.x3(parcel.readStrongBinder());
                IObjectWrapper iObjectWrapperX34 = IObjectWrapper.Stub.x3(parcel.readStrongBinder());
                zzbeg.zzh(parcel);
                zzx(iObjectWrapperX32, iObjectWrapperX33, iObjectWrapperX34);
                parcel2.writeNoException();
                return true;
            case 22:
                IObjectWrapper iObjectWrapperX35 = IObjectWrapper.Stub.x3(parcel.readStrongBinder());
                zzbeg.zzh(parcel);
                zzy(iObjectWrapperX35);
                parcel2.writeNoException();
                return true;
            case 23:
                float fZzz = zzz();
                parcel2.writeNoException();
                parcel2.writeFloat(fZzz);
                return true;
            case 24:
                float fZzA = zzA();
                parcel2.writeNoException();
                parcel2.writeFloat(fZzA);
                return true;
            case 25:
                float fZzB = zzB();
                parcel2.writeNoException();
                parcel2.writeFloat(fZzB);
                return true;
            case 26:
                zzC();
                parcel2.writeNoException();
                return true;
            default:
                return false;
        }
    }
}
