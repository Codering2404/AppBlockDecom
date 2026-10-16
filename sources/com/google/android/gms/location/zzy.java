package com.google.android.gms.location;

import android.location.Location;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public abstract class zzy extends com.google.android.gms.internal.location.zzb implements zzz {
    public zzy() {
        super("com.google.android.gms.location.ILocationListener");
    }

    public static zzz zzb(IBinder iBinder) {
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.location.ILocationListener");
        return iInterfaceQueryLocalInterface instanceof zzz ? (zzz) iInterfaceQueryLocalInterface : new zzx(iBinder);
    }

    @Override // com.google.android.gms.internal.location.zzb
    protected final boolean zza(int i3, Parcel parcel, Parcel parcel2, int i4) throws RemoteException {
        if (i3 == 1) {
            Location location = (Location) com.google.android.gms.internal.location.zzc.zza(parcel, Location.CREATOR);
            com.google.android.gms.internal.location.zzc.zzd(parcel);
            zzd(location);
        } else {
            if (i3 != 2) {
                return false;
            }
            zze();
        }
        return true;
    }
}
