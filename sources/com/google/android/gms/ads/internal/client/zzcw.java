package com.google.android.gms.ads.internal.client;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.ads.zzbee;
import com.google.android.gms.internal.ads.zzbeg;
import com.google.android.gms.internal.ads.zzbrp;
import com.google.android.gms.internal.ads.zzbrw;
import com.google.android.gms.internal.ads.zzbvc;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzcw extends zzbee implements zzcy {
    zzcw(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.client.IMobileAdsSettingManager");
    }

    @Override // com.google.android.gms.ads.internal.client.zzcy
    public final void zze() throws RemoteException {
        zzda(1, zza());
    }

    @Override // com.google.android.gms.ads.internal.client.zzcy
    public final void zzh(boolean z2) throws RemoteException {
        Parcel parcelZza = zza();
        int i3 = zzbeg.zza;
        parcelZza.writeInt(z2 ? 1 : 0);
        zzda(4, parcelZza);
    }

    @Override // com.google.android.gms.ads.internal.client.zzcy
    public final void zzj(String str, IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel parcelZza = zza();
        parcelZza.writeString(null);
        zzbeg.zze(parcelZza, iObjectWrapper);
        zzda(6, parcelZza);
    }

    @Override // com.google.android.gms.ads.internal.client.zzcy
    public final float zzk() throws RemoteException {
        Parcel parcelZzcZ = zzcZ(7, zza());
        float f3 = parcelZzcZ.readFloat();
        parcelZzcZ.recycle();
        return f3;
    }

    @Override // com.google.android.gms.ads.internal.client.zzcy
    public final boolean zzl() throws RemoteException {
        Parcel parcelZzcZ = zzcZ(8, zza());
        boolean zZza = zzbeg.zza(parcelZzcZ);
        parcelZzcZ.recycle();
        return zZza;
    }

    @Override // com.google.android.gms.ads.internal.client.zzcy
    public final void zzo(zzbvc zzbvcVar) throws RemoteException {
        Parcel parcelZza = zza();
        zzbeg.zze(parcelZza, zzbvcVar);
        zzda(11, parcelZza);
    }

    @Override // com.google.android.gms.ads.internal.client.zzcy
    public final void zzp(zzbrw zzbrwVar) throws RemoteException {
        Parcel parcelZza = zza();
        zzbeg.zze(parcelZza, zzbrwVar);
        zzda(12, parcelZza);
    }

    @Override // com.google.android.gms.ads.internal.client.zzcy
    public final List zzq() throws RemoteException {
        Parcel parcelZzcZ = zzcZ(13, zza());
        ArrayList arrayListCreateTypedArrayList = parcelZzcZ.createTypedArrayList(zzbrp.CREATOR);
        parcelZzcZ.recycle();
        return arrayListCreateTypedArrayList;
    }

    @Override // com.google.android.gms.ads.internal.client.zzcy
    public final void zzr(zzfr zzfrVar) throws RemoteException {
        Parcel parcelZza = zza();
        zzbeg.zzc(parcelZza, zzfrVar);
        zzda(14, parcelZza);
    }

    @Override // com.google.android.gms.ads.internal.client.zzcy
    public final void zzt(zzdk zzdkVar) throws RemoteException {
        Parcel parcelZza = zza();
        zzbeg.zze(parcelZza, zzdkVar);
        zzda(16, parcelZza);
    }

    @Override // com.google.android.gms.ads.internal.client.zzcy
    public final void zzv(String str) throws RemoteException {
        Parcel parcelZza = zza();
        parcelZza.writeString(str);
        zzda(18, parcelZza);
    }

    @Override // com.google.android.gms.ads.internal.client.zzcy
    public final void zzw() throws RemoteException {
        zzda(19, zza());
    }
}
