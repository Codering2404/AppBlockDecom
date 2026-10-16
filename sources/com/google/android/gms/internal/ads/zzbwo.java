package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public abstract class zzbwo extends zzbef implements zzbwp {
    public zzbwo() {
        super("com.google.android.gms.ads.internal.mediation.client.rtb.IBannerCallback");
    }

    @Override // com.google.android.gms.internal.ads.zzbef
    protected final boolean zzdd(int i3, Parcel parcel, Parcel parcel2, int i4) throws RemoteException {
        if (i3 == 1) {
            IObjectWrapper iObjectWrapperX3 = IObjectWrapper.Stub.x3(parcel.readStrongBinder());
            zzbeg.zzh(parcel);
            zze(iObjectWrapperX3);
        } else if (i3 == 2) {
            String string = parcel.readString();
            zzbeg.zzh(parcel);
            zzf(string);
        } else if (i3 == 3) {
            com.google.android.gms.ads.internal.client.zze zzeVar = (com.google.android.gms.ads.internal.client.zze) zzbeg.zzb(parcel, com.google.android.gms.ads.internal.client.zze.CREATOR);
            zzbeg.zzh(parcel);
            zzg(zzeVar);
        } else {
            if (i3 != 4) {
                return false;
            }
            zzbvl zzbvlVarZzb = zzbvk.zzb(parcel.readStrongBinder());
            zzbeg.zzh(parcel);
            zzh(zzbvlVarZzb);
        }
        parcel2.writeNoException();
        return true;
    }
}
