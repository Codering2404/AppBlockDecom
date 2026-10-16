package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzblz extends zzbee implements zzbmb {
    zzblz(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.formats.client.IMediaContent");
    }

    @Override // com.google.android.gms.internal.ads.zzbmb
    public final float zze() throws RemoteException {
        Parcel parcelZzcZ = zzcZ(2, zza());
        float f3 = parcelZzcZ.readFloat();
        parcelZzcZ.recycle();
        return f3;
    }

    @Override // com.google.android.gms.internal.ads.zzbmb
    public final void zzf(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel parcelZza = zza();
        zzbeg.zze(parcelZza, iObjectWrapper);
        zzda(3, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbmb
    public final IObjectWrapper zzg() throws RemoteException {
        Parcel parcelZzcZ = zzcZ(4, zza());
        IObjectWrapper iObjectWrapperX3 = IObjectWrapper.Stub.x3(parcelZzcZ.readStrongBinder());
        parcelZzcZ.recycle();
        return iObjectWrapperX3;
    }

    @Override // com.google.android.gms.internal.ads.zzbmb
    public final float zzh() throws RemoteException {
        Parcel parcelZzcZ = zzcZ(5, zza());
        float f3 = parcelZzcZ.readFloat();
        parcelZzcZ.recycle();
        return f3;
    }

    @Override // com.google.android.gms.internal.ads.zzbmb
    public final float zzi() throws RemoteException {
        Parcel parcelZzcZ = zzcZ(6, zza());
        float f3 = parcelZzcZ.readFloat();
        parcelZzcZ.recycle();
        return f3;
    }

    @Override // com.google.android.gms.internal.ads.zzbmb
    public final com.google.android.gms.ads.internal.client.zzea zzj() throws RemoteException {
        Parcel parcelZzcZ = zzcZ(7, zza());
        com.google.android.gms.ads.internal.client.zzea zzeaVarZzb = com.google.android.gms.ads.internal.client.zzdz.zzb(parcelZzcZ.readStrongBinder());
        parcelZzcZ.recycle();
        return zzeaVarZzb;
    }

    @Override // com.google.android.gms.internal.ads.zzbmb
    public final boolean zzk() throws RemoteException {
        Parcel parcelZzcZ = zzcZ(8, zza());
        boolean zZza = zzbeg.zza(parcelZzcZ);
        parcelZzcZ.recycle();
        return zZza;
    }

    @Override // com.google.android.gms.internal.ads.zzbmb
    public final boolean zzl() throws RemoteException {
        Parcel parcelZzcZ = zzcZ(10, zza());
        boolean zZza = zzbeg.zza(parcelZzcZ);
        parcelZzcZ.recycle();
        return zZza;
    }

    @Override // com.google.android.gms.internal.ads.zzbmb
    public final void zzm(zzbnj zzbnjVar) throws RemoteException {
        throw null;
    }
}
