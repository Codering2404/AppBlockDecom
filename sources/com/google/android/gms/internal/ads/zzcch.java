package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.bumptech.glide.load.data.Bwyd.SbbqvQlxi;
import com.google.android.gms.dynamic.IObjectWrapper;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public abstract class zzcch extends zzbef implements zzcci {
    public zzcch() {
        super("com.google.android.gms.ads.internal.rewarded.client.IRewardedAd");
    }

    public static zzcci zzt(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.rewarded.client.IRewardedAd");
        return iInterfaceQueryLocalInterface instanceof zzcci ? (zzcci) iInterfaceQueryLocalInterface : new zzccg(iBinder);
    }

    @Override // com.google.android.gms.internal.ads.zzbef
    protected final boolean zzdd(int i3, Parcel parcel, Parcel parcel2, int i4) throws RemoteException {
        zzccp zzccnVar = null;
        zzccp zzccnVar2 = null;
        zzccq zzccqVar = null;
        zzccl zzccjVar = null;
        switch (i3) {
            case 1:
                com.google.android.gms.ads.internal.client.zzm zzmVar = (com.google.android.gms.ads.internal.client.zzm) zzbeg.zzb(parcel, com.google.android.gms.ads.internal.client.zzm.CREATOR);
                IBinder strongBinder = parcel.readStrongBinder();
                if (strongBinder != null) {
                    IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.ads.internal.rewarded.client.IRewardedAdLoadCallback");
                    zzccnVar = iInterfaceQueryLocalInterface instanceof zzccp ? (zzccp) iInterfaceQueryLocalInterface : new zzccn(strongBinder);
                }
                zzbeg.zzh(parcel);
                zzc(zzmVar, zzccnVar);
                parcel2.writeNoException();
                return true;
            case 2:
                IBinder strongBinder2 = parcel.readStrongBinder();
                if (strongBinder2 != null) {
                    IInterface iInterfaceQueryLocalInterface2 = strongBinder2.queryLocalInterface("com.google.android.gms.ads.internal.rewarded.client.IRewardedAdCallback");
                    zzccjVar = iInterfaceQueryLocalInterface2 instanceof zzccl ? (zzccl) iInterfaceQueryLocalInterface2 : new zzccj(strongBinder2);
                }
                zzbeg.zzh(parcel);
                zze(zzccjVar);
                parcel2.writeNoException();
                return true;
            case 3:
                boolean zZzi = zzi();
                parcel2.writeNoException();
                int i5 = zzbeg.zza;
                parcel2.writeInt(zZzi ? 1 : 0);
                return true;
            case 4:
                String strZzj = zzj();
                parcel2.writeNoException();
                parcel2.writeString(strZzj);
                return true;
            case 5:
                IObjectWrapper iObjectWrapperX3 = IObjectWrapper.Stub.x3(parcel.readStrongBinder());
                zzbeg.zzh(parcel);
                zzb(iObjectWrapperX3);
                parcel2.writeNoException();
                return true;
            case 6:
                IBinder strongBinder3 = parcel.readStrongBinder();
                if (strongBinder3 != null) {
                    IInterface iInterfaceQueryLocalInterface3 = strongBinder3.queryLocalInterface(SbbqvQlxi.EmoM);
                    zzccqVar = iInterfaceQueryLocalInterface3 instanceof zzccq ? (zzccq) iInterfaceQueryLocalInterface3 : new zzccq(strongBinder3);
                }
                zzbeg.zzh(parcel);
                zzs(zzccqVar);
                parcel2.writeNoException();
                return true;
            case 7:
                zzccw zzccwVar = (zzccw) zzbeg.zzb(parcel, zzccw.CREATOR);
                zzbeg.zzh(parcel);
                zzh(zzccwVar);
                parcel2.writeNoException();
                return true;
            case 8:
                com.google.android.gms.ads.internal.client.zzdn zzdnVarX3 = com.google.android.gms.ads.internal.client.zzdm.x3(parcel.readStrongBinder());
                zzbeg.zzh(parcel);
                zzf(zzdnVarX3);
                parcel2.writeNoException();
                return true;
            case 9:
                Bundle bundleZzg = zzg();
                parcel2.writeNoException();
                zzbeg.zzd(parcel2, bundleZzg);
                return true;
            case 10:
                IObjectWrapper iObjectWrapperX32 = IObjectWrapper.Stub.x3(parcel.readStrongBinder());
                boolean zZza = zzbeg.zza(parcel);
                zzbeg.zzh(parcel);
                zzk(iObjectWrapperX32, zZza);
                parcel2.writeNoException();
                return true;
            case 11:
                zzccf zzccfVarZzl = zzl();
                parcel2.writeNoException();
                zzbeg.zze(parcel2, zzccfVarZzl);
                return true;
            case 12:
                com.google.android.gms.ads.internal.client.zzdx zzdxVarZzm = zzm();
                parcel2.writeNoException();
                zzbeg.zze(parcel2, zzdxVarZzm);
                return true;
            case 13:
                com.google.android.gms.ads.internal.client.zzdq zzdqVarX3 = com.google.android.gms.ads.internal.client.zzdp.x3(parcel.readStrongBinder());
                zzbeg.zzh(parcel);
                zzo(zzdqVarX3);
                parcel2.writeNoException();
                return true;
            case 14:
                com.google.android.gms.ads.internal.client.zzm zzmVar2 = (com.google.android.gms.ads.internal.client.zzm) zzbeg.zzb(parcel, com.google.android.gms.ads.internal.client.zzm.CREATOR);
                IBinder strongBinder4 = parcel.readStrongBinder();
                if (strongBinder4 != null) {
                    IInterface iInterfaceQueryLocalInterface4 = strongBinder4.queryLocalInterface("com.google.android.gms.ads.internal.rewarded.client.IRewardedAdLoadCallback");
                    zzccnVar2 = iInterfaceQueryLocalInterface4 instanceof zzccp ? (zzccp) iInterfaceQueryLocalInterface4 : new zzccn(strongBinder4);
                }
                zzbeg.zzh(parcel);
                zzd(zzmVar2, zzccnVar2);
                parcel2.writeNoException();
                return true;
            case 15:
                boolean zZza2 = zzbeg.zza(parcel);
                zzbeg.zzh(parcel);
                zzp(zZza2);
                parcel2.writeNoException();
                return true;
            case 16:
                String strZzn = zzn();
                parcel2.writeNoException();
                parcel2.writeString(strZzn);
                return true;
            case 17:
                long jZzq = zzq();
                parcel2.writeNoException();
                parcel2.writeLong(jZzq);
                return true;
            case 18:
                long j3 = parcel.readLong();
                zzbeg.zzh(parcel);
                zzr(j3);
                parcel2.writeNoException();
                return true;
            default:
                return false;
        }
    }
}
