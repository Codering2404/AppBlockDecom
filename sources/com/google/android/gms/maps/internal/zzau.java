package com.google.android.gms.maps.internal;

import android.os.Parcel;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public abstract class zzau extends com.google.android.gms.internal.maps.zzb implements zzav {
    public zzau() {
        super("com.google.android.gms.maps.internal.IOnMarkerClickListener");
    }

    @Override // com.google.android.gms.internal.maps.zzb
    protected final boolean zza(int i3, Parcel parcel, Parcel parcel2, int i4) {
        if (i3 != 1) {
            return false;
        }
        com.google.android.gms.internal.maps.zzad zzadVarZzb = com.google.android.gms.internal.maps.zzac.zzb(parcel.readStrongBinder());
        com.google.android.gms.internal.maps.zzc.zzc(parcel);
        boolean zB = b(zzadVarZzb);
        parcel2.writeNoException();
        parcel2.writeInt(zB ? 1 : 0);
        return true;
    }
}
