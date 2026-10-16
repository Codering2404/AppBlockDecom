package com.google.android.gms.maps.internal;

import android.os.Parcel;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public abstract class zzy extends com.google.android.gms.internal.maps.zzb implements zzz {
    public zzy() {
        super("com.google.android.gms.maps.internal.IOnGroundOverlayClickListener");
    }

    @Override // com.google.android.gms.internal.maps.zzb
    protected final boolean zza(int i3, Parcel parcel, Parcel parcel2, int i4) {
        if (i3 != 1) {
            return false;
        }
        com.google.android.gms.internal.maps.zzr zzrVarZzb = com.google.android.gms.internal.maps.zzq.zzb(parcel.readStrongBinder());
        com.google.android.gms.internal.maps.zzc.zzc(parcel);
        O0(zzrVarZzb);
        parcel2.writeNoException();
        return true;
    }
}
