package com.google.android.gms.maps.internal;

import android.os.Parcel;
import com.google.android.gms.dynamic.IObjectWrapper;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public abstract class zzh extends com.google.android.gms.internal.maps.zzb implements zzi {
    public zzh() {
        super("com.google.android.gms.maps.internal.IInfoWindowAdapter");
    }

    @Override // com.google.android.gms.internal.maps.zzb
    protected final boolean zza(int i3, Parcel parcel, Parcel parcel2, int i4) {
        if (i3 == 1) {
            com.google.android.gms.internal.maps.zzad zzadVarZzb = com.google.android.gms.internal.maps.zzac.zzb(parcel.readStrongBinder());
            com.google.android.gms.internal.maps.zzc.zzc(parcel);
            IObjectWrapper iObjectWrapperG = g(zzadVarZzb);
            parcel2.writeNoException();
            com.google.android.gms.internal.maps.zzc.zze(parcel2, iObjectWrapperG);
        } else {
            if (i3 != 2) {
                return false;
            }
            com.google.android.gms.internal.maps.zzad zzadVarZzb2 = com.google.android.gms.internal.maps.zzac.zzb(parcel.readStrongBinder());
            com.google.android.gms.internal.maps.zzc.zzc(parcel);
            IObjectWrapper iObjectWrapperB = b(zzadVarZzb2);
            parcel2.writeNoException();
            com.google.android.gms.internal.maps.zzc.zze(parcel2, iObjectWrapperB);
        }
        return true;
    }
}
