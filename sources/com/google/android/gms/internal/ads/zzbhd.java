package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzbhd extends zzbee implements IInterface {
    zzbhd(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.cache.ICacheService");
    }

    public final zzbgy zze(zzbhb zzbhbVar) throws RemoteException {
        Parcel parcelZza = zza();
        zzbeg.zzc(parcelZza, zzbhbVar);
        Parcel parcelZzcZ = zzcZ(1, parcelZza);
        zzbgy zzbgyVar = (zzbgy) zzbeg.zzb(parcelZzcZ, zzbgy.CREATOR);
        parcelZzcZ.recycle();
        return zzbgyVar;
    }

    public final zzbgy zzf(zzbhb zzbhbVar) throws RemoteException {
        Parcel parcelZza = zza();
        zzbeg.zzc(parcelZza, zzbhbVar);
        Parcel parcelZzcZ = zzcZ(2, parcelZza);
        zzbgy zzbgyVar = (zzbgy) zzbeg.zzb(parcelZzcZ, zzbgy.CREATOR);
        parcelZzcZ.recycle();
        return zzbgyVar;
    }

    public final long zzg(zzbhb zzbhbVar) throws RemoteException {
        Parcel parcelZza = zza();
        zzbeg.zzc(parcelZza, zzbhbVar);
        Parcel parcelZzcZ = zzcZ(3, parcelZza);
        long j3 = parcelZzcZ.readLong();
        parcelZzcZ.recycle();
        return j3;
    }
}
