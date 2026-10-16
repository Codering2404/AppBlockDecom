package com.google.android.gms.internal.maps;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.maps.model.Tile;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public abstract class zzao extends zzb implements zzap {
    public zzao() {
        super("com.google.android.gms.maps.model.internal.ITileProviderDelegate");
    }

    public static zzap zzc(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.maps.model.internal.ITileProviderDelegate");
        return iInterfaceQueryLocalInterface instanceof zzap ? (zzap) iInterfaceQueryLocalInterface : new zzan(iBinder);
    }

    @Override // com.google.android.gms.internal.maps.zzb
    protected final boolean zza(int i3, Parcel parcel, Parcel parcel2, int i4) throws RemoteException {
        if (i3 != 1) {
            return false;
        }
        int i5 = parcel.readInt();
        int i6 = parcel.readInt();
        int i7 = parcel.readInt();
        zzc.zzc(parcel);
        Tile tileZzb = zzb(i5, i6, i7);
        parcel2.writeNoException();
        if (tileZzb == null) {
            parcel2.writeInt(0);
        } else {
            parcel2.writeInt(1);
            tileZzb.writeToParcel(parcel2, 1);
        }
        return true;
    }
}
