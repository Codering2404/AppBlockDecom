package com.google.android.gms.ads.internal.client;

import android.os.Parcel;
import com.google.android.gms.internal.ads.zzbef;
import com.google.android.gms.internal.ads.zzbeg;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class zzca extends zzbef implements zzcb {
    @Override // com.google.android.gms.internal.ads.zzbef
    protected final boolean zzdd(int i3, Parcel parcel, Parcel parcel2, int i4) {
        if (i3 == 1) {
            zzfp zzfpVar = (zzfp) zzbeg.zzb(parcel, zzfp.CREATOR);
            zzbeg.zzh(parcel);
            Q0(zzfpVar);
        } else {
            if (i3 != 2) {
                return false;
            }
            zzfp zzfpVar2 = (zzfp) zzbeg.zzb(parcel, zzfp.CREATOR);
            zzbeg.zzh(parcel);
            J(zzfpVar2);
        }
        parcel2.writeNoException();
        return true;
    }
}
