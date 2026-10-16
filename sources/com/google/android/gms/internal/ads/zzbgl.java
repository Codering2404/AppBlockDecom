package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public abstract class zzbgl extends zzbef implements zzbgm {
    public zzbgl() {
        super("com.google.android.gms.ads.internal.appopen.client.IAppOpenAdLoadCallback");
    }

    public static zzbgm zze(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.appopen.client.IAppOpenAdLoadCallback");
        return iInterfaceQueryLocalInterface instanceof zzbgm ? (zzbgm) iInterfaceQueryLocalInterface : new zzbgk(iBinder);
    }

    @Override // com.google.android.gms.internal.ads.zzbef
    protected final boolean zzdd(int i3, Parcel parcel, Parcel parcel2, int i4) throws RemoteException {
        zzbgj zzbghVar;
        if (i3 == 1) {
            IBinder strongBinder = parcel.readStrongBinder();
            if (strongBinder == null) {
                zzbghVar = null;
            } else {
                IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.ads.internal.appopen.client.IAppOpenAd");
                zzbghVar = iInterfaceQueryLocalInterface instanceof zzbgj ? (zzbgj) iInterfaceQueryLocalInterface : new zzbgh(strongBinder);
            }
            zzbeg.zzh(parcel);
            zzb(zzbghVar);
        } else if (i3 == 2) {
            int i5 = parcel.readInt();
            zzbeg.zzh(parcel);
            zzc(i5);
        } else {
            if (i3 != 3) {
                return false;
            }
            com.google.android.gms.ads.internal.client.zze zzeVar = (com.google.android.gms.ads.internal.client.zze) zzbeg.zzb(parcel, com.google.android.gms.ads.internal.client.zze.CREATOR);
            zzbeg.zzh(parcel);
            zzd(zzeVar);
        }
        parcel2.writeNoException();
        return true;
    }
}
