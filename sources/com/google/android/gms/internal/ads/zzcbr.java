package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public abstract class zzcbr extends zzbef implements zzcbs {
    public zzcbr() {
        super("com.google.android.gms.ads.internal.reward.client.IRewardedVideoAd");
    }

    @Override // com.google.android.gms.internal.ads.zzbef
    protected final boolean zzdd(int i3, Parcel parcel, Parcel parcel2, int i4) throws RemoteException {
        if (i3 == 1) {
            zzcbw zzcbwVar = (zzcbw) zzbeg.zzb(parcel, zzcbw.CREATOR);
            zzbeg.zzh(parcel);
            zzb(zzcbwVar);
            parcel2.writeNoException();
        } else if (i3 != 2) {
            zzcbv zzcbtVar = null;
            zzcbq zzcbqVar = null;
            if (i3 == 3) {
                IBinder strongBinder = parcel.readStrongBinder();
                if (strongBinder != null) {
                    IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.ads.internal.reward.client.IRewardedVideoAdListener");
                    zzcbtVar = iInterfaceQueryLocalInterface instanceof zzcbv ? (zzcbv) iInterfaceQueryLocalInterface : new zzcbt(strongBinder);
                }
                zzbeg.zzh(parcel);
                zzd(zzcbtVar);
                parcel2.writeNoException();
            } else if (i3 != 34) {
                switch (i3) {
                    case 5:
                        boolean zZze = zze();
                        parcel2.writeNoException();
                        int i5 = zzbeg.zza;
                        parcel2.writeInt(zZze ? 1 : 0);
                        break;
                    case 6:
                        zzf();
                        parcel2.writeNoException();
                        break;
                    case 7:
                        zzg();
                        parcel2.writeNoException();
                        break;
                    case 8:
                        zzh();
                        parcel2.writeNoException();
                        break;
                    case 9:
                        IObjectWrapper iObjectWrapperX3 = IObjectWrapper.Stub.x3(parcel.readStrongBinder());
                        zzbeg.zzh(parcel);
                        zzi(iObjectWrapperX3);
                        parcel2.writeNoException();
                        break;
                    case 10:
                        IObjectWrapper iObjectWrapperX32 = IObjectWrapper.Stub.x3(parcel.readStrongBinder());
                        zzbeg.zzh(parcel);
                        zzj(iObjectWrapperX32);
                        parcel2.writeNoException();
                        break;
                    case 11:
                        IObjectWrapper iObjectWrapperX33 = IObjectWrapper.Stub.x3(parcel.readStrongBinder());
                        zzbeg.zzh(parcel);
                        zzk(iObjectWrapperX33);
                        parcel2.writeNoException();
                        break;
                    case 12:
                        String strZzl = zzl();
                        parcel2.writeNoException();
                        parcel2.writeString(strZzl);
                        break;
                    case 13:
                        String string = parcel.readString();
                        zzbeg.zzh(parcel);
                        zzm(string);
                        parcel2.writeNoException();
                        break;
                    case 14:
                        com.google.android.gms.ads.internal.client.zzby zzbyVarX3 = com.google.android.gms.ads.internal.client.zzbx.x3(parcel.readStrongBinder());
                        zzbeg.zzh(parcel);
                        zzn(zzbyVarX3);
                        parcel2.writeNoException();
                        break;
                    case 15:
                        Bundle bundleZzo = zzo();
                        parcel2.writeNoException();
                        zzbeg.zzd(parcel2, bundleZzo);
                        break;
                    case 16:
                        IBinder strongBinder2 = parcel.readStrongBinder();
                        if (strongBinder2 != null) {
                            IInterface iInterfaceQueryLocalInterface2 = strongBinder2.queryLocalInterface("com.google.android.gms.ads.internal.reward.client.IRewardedAdSkuListener");
                            zzcbqVar = iInterfaceQueryLocalInterface2 instanceof zzcbq ? (zzcbq) iInterfaceQueryLocalInterface2 : new zzcbq(strongBinder2);
                        }
                        zzbeg.zzh(parcel);
                        zzu(zzcbqVar);
                        parcel2.writeNoException();
                        break;
                    case 17:
                        parcel.readString();
                        zzbeg.zzh(parcel);
                        parcel2.writeNoException();
                        break;
                    case 18:
                        IObjectWrapper iObjectWrapperX34 = IObjectWrapper.Stub.x3(parcel.readStrongBinder());
                        zzbeg.zzh(parcel);
                        zzp(iObjectWrapperX34);
                        parcel2.writeNoException();
                        break;
                    case 19:
                        String string2 = parcel.readString();
                        zzbeg.zzh(parcel);
                        zzq(string2);
                        parcel2.writeNoException();
                        break;
                    case 20:
                        boolean zZzs = zzs();
                        parcel2.writeNoException();
                        int i6 = zzbeg.zza;
                        parcel2.writeInt(zZzs ? 1 : 0);
                        break;
                    case 21:
                        com.google.android.gms.ads.internal.client.zzdx zzdxVarZzt = zzt();
                        parcel2.writeNoException();
                        zzbeg.zze(parcel2, zzdxVarZzt);
                        break;
                    default:
                        return false;
                }
            } else {
                boolean zZza = zzbeg.zza(parcel);
                zzbeg.zzh(parcel);
                zzr(zZza);
                parcel2.writeNoException();
            }
        } else {
            zzc();
            parcel2.writeNoException();
        }
        return true;
    }
}
