package com.google.android.gms.internal.appset;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzg extends zza implements IInterface {
    zzg(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.appset.internal.IAppSetService");
    }

    public final void zzc(com.google.android.gms.appset.zza zzaVar, zzf zzfVar) throws RemoteException {
        Parcel parcelZza = zza();
        zzc.zzb(parcelZza, zzaVar);
        zzc.zzc(parcelZza, zzfVar);
        zzb(1, parcelZza);
    }
}
