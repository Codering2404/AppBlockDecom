package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzbmg extends zzbee implements zzbmi {
    zzbmg(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.formats.client.INativeAdViewDelegate");
    }

    @Override // com.google.android.gms.internal.ads.zzbmi
    public final void zzb(String str, IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel parcelZza = zza();
        parcelZza.writeString(str);
        zzbeg.zze(parcelZza, iObjectWrapper);
        zzda(1, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbmi
    public final IObjectWrapper zzc(String str) throws RemoteException {
        Parcel parcelZza = zza();
        parcelZza.writeString(str);
        Parcel parcelZzcZ = zzcZ(2, parcelZza);
        IObjectWrapper iObjectWrapperX3 = IObjectWrapper.Stub.x3(parcelZzcZ.readStrongBinder());
        parcelZzcZ.recycle();
        return iObjectWrapperX3;
    }

    @Override // com.google.android.gms.internal.ads.zzbmi
    public final void zzd(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel parcelZza = zza();
        zzbeg.zze(parcelZza, iObjectWrapper);
        zzda(3, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbmi
    public final void zzdB(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel parcelZza = zza();
        zzbeg.zze(parcelZza, iObjectWrapper);
        zzda(6, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbmi
    public final void zzdC(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel parcelZza = zza();
        zzbeg.zze(parcelZza, iObjectWrapper);
        zzda(9, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbmi
    public final void zzdD(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel parcelZza = zza();
        zzbeg.zze(parcelZza, iObjectWrapper);
        zzda(7, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbmi
    public final void zzdE(zzbmb zzbmbVar) throws RemoteException {
        Parcel parcelZza = zza();
        zzbeg.zze(parcelZza, zzbmbVar);
        zzda(8, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbmi
    public final void zze() throws RemoteException {
        zzda(4, zza());
    }

    @Override // com.google.android.gms.internal.ads.zzbmi
    public final void zzf(IObjectWrapper iObjectWrapper, int i3) throws RemoteException {
        Parcel parcelZza = zza();
        zzbeg.zze(parcelZza, iObjectWrapper);
        parcelZza.writeInt(i3);
        zzda(5, parcelZza);
    }
}
