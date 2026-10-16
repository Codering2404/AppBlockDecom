package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public abstract class zzbvb extends zzbef implements zzbvc {
    public zzbvb() {
        super("com.google.android.gms.ads.internal.mediation.client.IAdapterCreator");
    }

    public static zzbvc zzf(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.IAdapterCreator");
        return iInterfaceQueryLocalInterface instanceof zzbvc ? (zzbvc) iInterfaceQueryLocalInterface : new zzbva(iBinder);
    }

    @Override // com.google.android.gms.internal.ads.zzbef
    protected final boolean zzdd(int i3, Parcel parcel, Parcel parcel2, int i4) throws RemoteException {
        if (i3 == 1) {
            String string = parcel.readString();
            zzbeg.zzh(parcel);
            zzbvf zzbvfVarZzb = zzb(string);
            parcel2.writeNoException();
            zzbeg.zze(parcel2, zzbvfVarZzb);
        } else if (i3 == 2) {
            String string2 = parcel.readString();
            zzbeg.zzh(parcel);
            boolean zZzc = zzc(string2);
            parcel2.writeNoException();
            parcel2.writeInt(zZzc ? 1 : 0);
        } else if (i3 == 3) {
            String string3 = parcel.readString();
            zzbeg.zzh(parcel);
            zzbxb zzbxbVarZze = zze(string3);
            parcel2.writeNoException();
            zzbeg.zze(parcel2, zzbxbVarZze);
        } else {
            if (i3 != 4) {
                return false;
            }
            String string4 = parcel.readString();
            zzbeg.zzh(parcel);
            boolean zZzd = zzd(string4);
            parcel2.writeNoException();
            parcel2.writeInt(zZzd ? 1 : 0);
        }
        return true;
    }
}
