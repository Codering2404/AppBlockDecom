package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzbgh extends zzbee implements zzbgj {
    zzbgh(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.appopen.client.IAppOpenAd");
    }

    @Override // com.google.android.gms.internal.ads.zzbgj
    public final com.google.android.gms.ads.internal.client.zzbu zze() throws RemoteException {
        throw null;
    }

    @Override // com.google.android.gms.internal.ads.zzbgj
    public final void zzf(IObjectWrapper iObjectWrapper, zzbgq zzbgqVar) throws RemoteException {
        Parcel parcelZza = zza();
        zzbeg.zze(parcelZza, iObjectWrapper);
        zzbeg.zze(parcelZza, zzbgqVar);
        zzda(4, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbgj
    public final com.google.android.gms.ads.internal.client.zzdx zzg() throws RemoteException {
        Parcel parcelZzcZ = zzcZ(5, zza());
        com.google.android.gms.ads.internal.client.zzdx zzdxVarZzb = com.google.android.gms.ads.internal.client.zzdw.zzb(parcelZzcZ.readStrongBinder());
        parcelZzcZ.recycle();
        return zzdxVarZzb;
    }

    @Override // com.google.android.gms.internal.ads.zzbgj
    public final void zzh(boolean z2) throws RemoteException {
        Parcel parcelZza = zza();
        int i3 = zzbeg.zza;
        parcelZza.writeInt(z2 ? 1 : 0);
        zzda(6, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbgj
    public final void zzi(com.google.android.gms.ads.internal.client.zzdq zzdqVar) throws RemoteException {
        Parcel parcelZza = zza();
        zzbeg.zze(parcelZza, zzdqVar);
        zzda(7, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbgj
    public final String zzj() throws RemoteException {
        Parcel parcelZzcZ = zzcZ(8, zza());
        String string = parcelZzcZ.readString();
        parcelZzcZ.recycle();
        return string;
    }

    @Override // com.google.android.gms.internal.ads.zzbgj
    public final long zzk() throws RemoteException {
        Parcel parcelZzcZ = zzcZ(9, zza());
        long j3 = parcelZzcZ.readLong();
        parcelZzcZ.recycle();
        return j3;
    }

    @Override // com.google.android.gms.internal.ads.zzbgj
    public final void zzl(long j3) throws RemoteException {
        Parcel parcelZza = zza();
        parcelZza.writeLong(j3);
        zzda(10, parcelZza);
    }
}
