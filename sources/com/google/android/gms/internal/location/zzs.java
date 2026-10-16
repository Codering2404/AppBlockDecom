package com.google.android.gms.internal.location;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public abstract class zzs extends zzb implements zzt {
    public zzs() {
        super("com.google.android.gms.location.internal.IGeofencerCallbacks");
    }

    @Override // com.google.android.gms.internal.location.zzb
    protected final boolean zza(int i3, Parcel parcel, Parcel parcel2, int i4) throws RemoteException {
        if (i3 == 1) {
            int i5 = parcel.readInt();
            String[] strArrCreateStringArray = parcel.createStringArray();
            zzc.zzd(parcel);
            zzb(i5, strArrCreateStringArray);
        } else if (i3 == 2) {
            int i6 = parcel.readInt();
            String[] strArrCreateStringArray2 = parcel.createStringArray();
            zzc.zzd(parcel);
            zzc(i6, strArrCreateStringArray2);
        } else {
            if (i3 != 3) {
                return false;
            }
            int i7 = parcel.readInt();
            PendingIntent pendingIntent = (PendingIntent) zzc.zza(parcel, PendingIntent.CREATOR);
            zzc.zzd(parcel);
            zzd(i7, pendingIntent);
        }
        return true;
    }
}
