package com.google.android.gms.ads.internal.client;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.ads.zzbee;
import com.google.android.gms.internal.ads.zzbeg;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzbz extends zzbee implements zzcb {
    zzbz(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.client.IAdPreloadCallback");
    }

    @Override // com.google.android.gms.ads.internal.client.zzcb
    public final void J(zzfp zzfpVar) throws RemoteException {
        Parcel parcelZza = zza();
        zzbeg.zzc(parcelZza, zzfpVar);
        zzda(2, parcelZza);
    }

    @Override // com.google.android.gms.ads.internal.client.zzcb
    public final void Q0(zzfp zzfpVar) throws RemoteException {
        Parcel parcelZza = zza();
        zzbeg.zzc(parcelZza, zzfpVar);
        zzda(1, parcelZza);
    }
}
