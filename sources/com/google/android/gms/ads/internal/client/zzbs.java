package com.google.android.gms.ads.internal.client;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.ads.zzbee;
import com.google.android.gms.internal.ads.zzbeg;
import com.google.android.gms.internal.ads.zzbgm;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzbs extends zzbee implements zzbu {
    zzbs(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.client.IAdManager");
    }

    @Override // com.google.android.gms.ads.internal.client.zzbu
    public final zzea zzF() throws RemoteException {
        zzea zzdyVar;
        Parcel parcelZzcZ = zzcZ(26, zza());
        IBinder strongBinder = parcelZzcZ.readStrongBinder();
        if (strongBinder == null) {
            zzdyVar = null;
        } else {
            IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IVideoController");
            zzdyVar = iInterfaceQueryLocalInterface instanceof zzea ? (zzea) iInterfaceQueryLocalInterface : new zzdy(strongBinder);
        }
        parcelZzcZ.recycle();
        return zzdyVar;
    }

    @Override // com.google.android.gms.ads.internal.client.zzbu
    public final void zzG(zzfw zzfwVar) throws RemoteException {
        Parcel parcelZza = zza();
        zzbeg.zzc(parcelZza, zzfwVar);
        zzda(29, parcelZza);
    }

    @Override // com.google.android.gms.ads.internal.client.zzbu
    public final void zzJ(zzbgm zzbgmVar) throws RemoteException {
        Parcel parcelZza = zza();
        zzbeg.zze(parcelZza, zzbgmVar);
        zzda(40, parcelZza);
    }

    @Override // com.google.android.gms.ads.internal.client.zzbu
    public final void zzK(boolean z2) throws RemoteException {
        Parcel parcelZza = zza();
        int i3 = zzbeg.zza;
        parcelZza.writeInt(z2 ? 1 : 0);
        zzda(34, parcelZza);
    }

    @Override // com.google.android.gms.ads.internal.client.zzbu
    public final void zzP(zzdq zzdqVar) throws RemoteException {
        Parcel parcelZza = zza();
        zzbeg.zze(parcelZza, zzdqVar);
        zzda(42, parcelZza);
    }

    @Override // com.google.android.gms.ads.internal.client.zzbu
    public final void zzQ(zzm zzmVar, zzbk zzbkVar) throws RemoteException {
        Parcel parcelZza = zza();
        zzbeg.zzc(parcelZza, zzmVar);
        zzbeg.zze(parcelZza, zzbkVar);
        zzda(43, parcelZza);
    }

    @Override // com.google.android.gms.ads.internal.client.zzbu
    public final void zzR(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel parcelZza = zza();
        zzbeg.zze(parcelZza, iObjectWrapper);
        zzda(44, parcelZza);
    }

    @Override // com.google.android.gms.ads.internal.client.zzbu
    public final void zzS(zzcs zzcsVar) throws RemoteException {
        Parcel parcelZza = zza();
        zzbeg.zze(parcelZza, zzcsVar);
        zzda(45, parcelZza);
    }

    @Override // com.google.android.gms.ads.internal.client.zzbu
    public final void zzT(long j3) throws RemoteException {
        Parcel parcelZza = zza();
        parcelZza.writeLong(j3);
        zzda(48, parcelZza);
    }

    @Override // com.google.android.gms.ads.internal.client.zzbu
    public final long zzU() throws RemoteException {
        Parcel parcelZzcZ = zzcZ(47, zza());
        long j3 = parcelZzcZ.readLong();
        parcelZzcZ.recycle();
        return j3;
    }

    @Override // com.google.android.gms.ads.internal.client.zzbu
    public final IObjectWrapper zzb() throws RemoteException {
        Parcel parcelZzcZ = zzcZ(1, zza());
        IObjectWrapper iObjectWrapperX3 = IObjectWrapper.Stub.x3(parcelZzcZ.readStrongBinder());
        parcelZzcZ.recycle();
        return iObjectWrapperX3;
    }

    @Override // com.google.android.gms.ads.internal.client.zzbu
    public final void zzc() throws RemoteException {
        zzda(2, zza());
    }

    @Override // com.google.android.gms.ads.internal.client.zzbu
    public final void zzdS(zzbh zzbhVar) throws RemoteException {
        Parcel parcelZza = zza();
        zzbeg.zze(parcelZza, zzbhVar);
        zzda(7, parcelZza);
    }

    @Override // com.google.android.gms.ads.internal.client.zzbu
    public final boolean zze(zzm zzmVar) throws RemoteException {
        Parcel parcelZza = zza();
        zzbeg.zzc(parcelZza, zzmVar);
        Parcel parcelZzcZ = zzcZ(4, parcelZza);
        boolean zZza = zzbeg.zza(parcelZzcZ);
        parcelZzcZ.recycle();
        return zZza;
    }

    @Override // com.google.android.gms.ads.internal.client.zzbu
    public final void zzf() throws RemoteException {
        zzda(5, zza());
    }

    @Override // com.google.android.gms.ads.internal.client.zzbu
    public final void zzg() throws RemoteException {
        zzda(6, zza());
    }

    @Override // com.google.android.gms.ads.internal.client.zzbu
    public final void zzi(zzcl zzclVar) throws RemoteException {
        Parcel parcelZza = zza();
        zzbeg.zze(parcelZza, zzclVar);
        zzda(8, parcelZza);
    }

    @Override // com.google.android.gms.ads.internal.client.zzbu
    public final zzr zzn() throws RemoteException {
        Parcel parcelZzcZ = zzcZ(12, zza());
        zzr zzrVar = (zzr) zzbeg.zzb(parcelZzcZ, zzr.CREATOR);
        parcelZzcZ.recycle();
        return zzrVar;
    }

    @Override // com.google.android.gms.ads.internal.client.zzbu
    public final void zzo(zzr zzrVar) throws RemoteException {
        Parcel parcelZza = zza();
        zzbeg.zzc(parcelZza, zzrVar);
        zzda(13, parcelZza);
    }

    @Override // com.google.android.gms.ads.internal.client.zzbu
    public final zzdx zzt() throws RemoteException {
        zzdx zzdvVar;
        Parcel parcelZzcZ = zzcZ(41, zza());
        IBinder strongBinder = parcelZzcZ.readStrongBinder();
        if (strongBinder == null) {
            zzdvVar = null;
        } else {
            IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IResponseInfo");
            zzdvVar = iInterfaceQueryLocalInterface instanceof zzdx ? (zzdx) iInterfaceQueryLocalInterface : new zzdv(strongBinder);
        }
        parcelZzcZ.recycle();
        return zzdvVar;
    }

    @Override // com.google.android.gms.ads.internal.client.zzbu
    public final String zzu() throws RemoteException {
        Parcel parcelZzcZ = zzcZ(31, zza());
        String string = parcelZzcZ.readString();
        parcelZzcZ.recycle();
        return string;
    }

    @Override // com.google.android.gms.ads.internal.client.zzbu
    public final zzcl zzv() throws RemoteException {
        zzcl zzcjVar;
        Parcel parcelZzcZ = zzcZ(32, zza());
        IBinder strongBinder = parcelZzcZ.readStrongBinder();
        if (strongBinder == null) {
            zzcjVar = null;
        } else {
            IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAppEventListener");
            zzcjVar = iInterfaceQueryLocalInterface instanceof zzcl ? (zzcl) iInterfaceQueryLocalInterface : new zzcj(strongBinder);
        }
        parcelZzcZ.recycle();
        return zzcjVar;
    }

    @Override // com.google.android.gms.ads.internal.client.zzbu
    public final zzbh zzw() throws RemoteException {
        zzbh zzbfVar;
        Parcel parcelZzcZ = zzcZ(33, zza());
        IBinder strongBinder = parcelZzcZ.readStrongBinder();
        if (strongBinder == null) {
            zzbfVar = null;
        } else {
            IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdListener");
            zzbfVar = iInterfaceQueryLocalInterface instanceof zzbh ? (zzbh) iInterfaceQueryLocalInterface : new zzbf(strongBinder);
        }
        parcelZzcZ.recycle();
        return zzbfVar;
    }

    @Override // com.google.android.gms.ads.internal.client.zzbu
    public final void zzy(zzbe zzbeVar) throws RemoteException {
        Parcel parcelZza = zza();
        zzbeg.zze(parcelZza, zzbeVar);
        zzda(20, parcelZza);
    }

    @Override // com.google.android.gms.ads.internal.client.zzbu
    public final void zzz(boolean z2) throws RemoteException {
        Parcel parcelZza = zza();
        int i3 = zzbeg.zza;
        parcelZza.writeInt(z2 ? 1 : 0);
        zzda(22, parcelZza);
    }
}
