package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public abstract class zzbqs extends zzbef implements zzbqt {
    public zzbqs() {
        super("com.google.android.gms.ads.internal.h5.client.IH5AdsManager");
    }

    public static zzbqt zzb(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.h5.client.IH5AdsManager");
        return iInterfaceQueryLocalInterface instanceof zzbqt ? (zzbqt) iInterfaceQueryLocalInterface : new zzbqr(iBinder);
    }

    @Override // com.google.android.gms.internal.ads.zzbef
    protected final boolean zzdd(int i3, Parcel parcel, Parcel parcel2, int i4) throws RemoteException {
        if (i3 == 1) {
            String string = parcel.readString();
            zzbeg.zzh(parcel);
            zze(string);
        } else {
            if (i3 != 2) {
                return false;
            }
            zzf();
        }
        parcel2.writeNoException();
        return true;
    }
}
