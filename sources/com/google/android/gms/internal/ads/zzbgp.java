package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public abstract class zzbgp extends zzbef implements zzbgq {
    public zzbgp() {
        super("com.google.android.gms.ads.internal.appopen.client.IAppOpenFullScreenContentCallback");
    }

    @Override // com.google.android.gms.internal.ads.zzbef
    protected final boolean zzdd(int i3, Parcel parcel, Parcel parcel2, int i4) throws RemoteException {
        if (i3 == 1) {
            zzc();
        } else if (i3 == 2) {
            zzd();
        } else if (i3 == 3) {
            com.google.android.gms.ads.internal.client.zze zzeVar = (com.google.android.gms.ads.internal.client.zze) zzbeg.zzb(parcel, com.google.android.gms.ads.internal.client.zze.CREATOR);
            zzbeg.zzh(parcel);
            zze(zzeVar);
        } else if (i3 == 4) {
            zzf();
        } else {
            if (i3 != 5) {
                return false;
            }
            zzg();
        }
        parcel2.writeNoException();
        return true;
    }
}
