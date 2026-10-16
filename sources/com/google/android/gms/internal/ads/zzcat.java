package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.RemoteException;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public abstract class zzcat extends zzbef implements zzcau {
    public zzcat() {
        super("com.google.android.gms.ads.internal.request.INonagonStreamingResponseListener");
    }

    @Override // com.google.android.gms.internal.ads.zzbef
    protected final boolean zzdd(int i3, Parcel parcel, Parcel parcel2, int i4) throws RemoteException {
        if (i3 == 1) {
            ParcelFileDescriptor parcelFileDescriptor = (ParcelFileDescriptor) zzbeg.zzb(parcel, ParcelFileDescriptor.CREATOR);
            zzbeg.zzh(parcel);
            zze(parcelFileDescriptor);
        } else if (i3 == 2) {
            com.google.android.gms.ads.internal.util.zzba zzbaVar = (com.google.android.gms.ads.internal.util.zzba) zzbeg.zzb(parcel, com.google.android.gms.ads.internal.util.zzba.CREATOR);
            zzbeg.zzh(parcel);
            zzf(zzbaVar);
        } else {
            if (i3 != 3) {
                return false;
            }
            ParcelFileDescriptor parcelFileDescriptor2 = (ParcelFileDescriptor) zzbeg.zzb(parcel, ParcelFileDescriptor.CREATOR);
            zzcbd zzcbdVar = (zzcbd) zzbeg.zzb(parcel, zzcbd.CREATOR);
            zzbeg.zzh(parcel);
            zzg(parcelFileDescriptor2, zzcbdVar);
        }
        parcel2.writeNoException();
        return true;
    }
}
