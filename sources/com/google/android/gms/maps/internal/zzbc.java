package com.google.android.gms.maps.internal;

import android.location.Location;
import android.os.Parcel;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public abstract class zzbc extends com.google.android.gms.internal.maps.zzb implements zzbd {
    public zzbc() {
        super("com.google.android.gms.maps.internal.IOnMyLocationClickListener");
    }

    @Override // com.google.android.gms.internal.maps.zzb
    protected final boolean zza(int i3, Parcel parcel, Parcel parcel2, int i4) {
        if (i3 != 1) {
            return false;
        }
        Location location = (Location) com.google.android.gms.internal.maps.zzc.zza(parcel, Location.CREATOR);
        com.google.android.gms.internal.maps.zzc.zzc(parcel);
        z0(location);
        parcel2.writeNoException();
        return true;
    }
}
