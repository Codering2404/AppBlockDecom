package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzbng extends zzbee implements zzbni {
    zzbng(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.formats.client.IOnCustomTemplateAdLoadedListener");
    }

    @Override // com.google.android.gms.internal.ads.zzbni
    public final void zze(zzbmv zzbmvVar) throws RemoteException {
        Parcel parcelZza = zza();
        zzbeg.zze(parcelZza, zzbmvVar);
        zzda(1, parcelZza);
    }
}
