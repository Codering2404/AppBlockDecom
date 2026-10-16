package com.google.android.gms.ads.internal.client;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.internal.ads.zzbef;
import com.google.android.gms.internal.ads.zzbeg;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class zzdp extends zzbef implements zzdq {
    public zzdp() {
        super("com.google.android.gms.ads.internal.client.IOnPaidEventListener");
    }

    public static zzdq x3(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IOnPaidEventListener");
        return iInterfaceQueryLocalInterface instanceof zzdq ? (zzdq) iInterfaceQueryLocalInterface : new zzdo(iBinder);
    }

    @Override // com.google.android.gms.internal.ads.zzbef
    protected final boolean zzdd(int i3, Parcel parcel, Parcel parcel2, int i4) {
        if (i3 == 1) {
            zzt zztVar = (zzt) zzbeg.zzb(parcel, zzt.CREATOR);
            zzbeg.zzh(parcel);
            p4(zztVar);
            parcel2.writeNoException();
        } else {
            if (i3 != 2) {
                return false;
            }
            boolean zZzf = zzf();
            parcel2.writeNoException();
            int i5 = zzbeg.zza;
            parcel2.writeInt(zZzf ? 1 : 0);
        }
        return true;
    }
}
