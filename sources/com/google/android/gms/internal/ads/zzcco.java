package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.RemoteException;
import androidx.compose.animation.core.Xrg.muQRKXGtpOhe;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public abstract class zzcco extends zzbef implements zzccp {
    @Override // com.google.android.gms.internal.ads.zzbef
    protected final boolean zzdd(int i3, Parcel parcel, Parcel parcel2, int i4) throws RemoteException {
        if (i3 == 1) {
            zze();
        } else if (i3 == 2) {
            int i5 = parcel.readInt();
            zzbeg.zzh(parcel);
            zzf(i5);
        } else {
            if (i3 != 3) {
                return false;
            }
            com.google.android.gms.ads.internal.client.zze zzeVar = (com.google.android.gms.ads.internal.client.zze) zzbeg.zzb(parcel, com.google.android.gms.ads.internal.client.zze.CREATOR);
            zzbeg.zzh(parcel);
            zzg(zzeVar);
        }
        parcel2.writeNoException();
        return true;
    }

    public zzcco() {
        super(muQRKXGtpOhe.rBoflj);
    }
}
