package com.google.android.gms.ads.internal.client;

import android.os.Parcel;
import com.google.android.gms.internal.ads.zzbef;
import com.google.android.gms.internal.ads.zzbeg;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class zzcr extends zzbef implements zzcs {
    public zzcr() {
        super("com.google.android.gms.ads.internal.client.IFullScreenContentCallback");
    }

    @Override // com.google.android.gms.internal.ads.zzbef
    protected final boolean zzdd(int i3, Parcel parcel, Parcel parcel2, int i4) {
        if (i3 == 1) {
            zze zzeVar = (zze) zzbeg.zzb(parcel, zze.CREATOR);
            zzbeg.zzh(parcel);
            Y3(zzeVar);
        } else if (i3 == 2) {
            zzc();
        } else if (i3 == 3) {
            zzd();
        } else if (i3 == 4) {
            zze();
        } else {
            if (i3 != 5) {
                return false;
            }
            zzf();
        }
        parcel2.writeNoException();
        return true;
    }
}
