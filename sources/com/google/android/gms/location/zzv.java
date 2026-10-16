package com.google.android.gms.location;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public abstract class zzv extends com.google.android.gms.internal.location.zzb implements zzw {
    public zzv() {
        super("com.google.android.gms.location.ILocationCallback");
    }

    public static zzw zzb(IBinder iBinder) {
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.location.ILocationCallback");
        return iInterfaceQueryLocalInterface instanceof zzw ? (zzw) iInterfaceQueryLocalInterface : new zzu(iBinder);
    }

    @Override // com.google.android.gms.internal.location.zzb
    protected final boolean zza(int i3, Parcel parcel, Parcel parcel2, int i4) throws RemoteException {
        if (i3 == 1) {
            LocationResult locationResult = (LocationResult) com.google.android.gms.internal.location.zzc.zza(parcel, LocationResult.CREATOR);
            com.google.android.gms.internal.location.zzc.zzd(parcel);
            zzd(locationResult);
        } else if (i3 == 2) {
            LocationAvailability locationAvailability = (LocationAvailability) com.google.android.gms.internal.location.zzc.zza(parcel, LocationAvailability.CREATOR);
            com.google.android.gms.internal.location.zzc.zzd(parcel);
            zze(locationAvailability);
        } else {
            if (i3 != 3) {
                return false;
            }
            zzf();
        }
        return true;
    }
}
