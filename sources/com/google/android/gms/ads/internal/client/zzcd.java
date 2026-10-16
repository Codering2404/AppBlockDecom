package com.google.android.gms.ads.internal.client;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.internal.ads.zzbef;
import com.google.android.gms.internal.ads.zzbeg;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class zzcd extends zzbef implements zzce {
    @Override // com.google.android.gms.internal.ads.zzbef
    protected final boolean zzdd(int i3, Parcel parcel, Parcel parcel2, int i4) {
        zzdx zzdvVar;
        if (i3 == 1) {
            String string = parcel.readString();
            IBinder strongBinder = parcel.readStrongBinder();
            if (strongBinder == null) {
                zzdvVar = null;
            } else {
                IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IResponseInfo");
                zzdvVar = iInterfaceQueryLocalInterface instanceof zzdx ? (zzdx) iInterfaceQueryLocalInterface : new zzdv(strongBinder);
            }
            zzbeg.zzh(parcel);
            b5(string, zzdvVar);
        } else if (i3 == 2) {
            String string2 = parcel.readString();
            zzbeg.zzh(parcel);
            zzf(string2);
        } else {
            if (i3 != 3) {
                return false;
            }
            String string3 = parcel.readString();
            zze zzeVar = (zze) zzbeg.zzb(parcel, zze.CREATOR);
            zzbeg.zzh(parcel);
            p3(string3, zzeVar);
        }
        parcel2.writeNoException();
        return true;
    }
}
