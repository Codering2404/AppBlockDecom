package com.google.android.gms.internal.location;

import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public abstract class zzq extends zzb implements zzr {
    public zzq() {
        super("com.google.android.gms.location.internal.IFusedLocationProviderCallback");
    }

    @Override // com.google.android.gms.internal.location.zzb
    protected final boolean zza(int i3, Parcel parcel, Parcel parcel2, int i4) throws RemoteException {
        if (i3 == 1) {
            zzl zzlVar = (zzl) zzc.zza(parcel, zzl.CREATOR);
            zzc.zzd(parcel);
            zzd(zzlVar);
        } else {
            if (i3 != 2) {
                return false;
            }
            zze();
        }
        return true;
    }
}
