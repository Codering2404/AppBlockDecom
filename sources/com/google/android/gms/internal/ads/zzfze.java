package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public abstract class zzfze extends zzbef implements zzfzf {
    public zzfze() {
        super("com.google.android.gms.gass.internal.clearcut.IGassClearcut");
    }

    @Override // com.google.android.gms.internal.ads.zzbef
    protected final boolean zzdd(int i3, Parcel parcel, Parcel parcel2, int i4) throws RemoteException {
        switch (i3) {
            case 2:
                IObjectWrapper.Stub.x3(parcel.readStrongBinder());
                parcel.readString();
                zzbeg.zzh(parcel);
                break;
            case 3:
                break;
            case 4:
                parcel.createIntArray();
                zzbeg.zzh(parcel);
                break;
            case 5:
                parcel.createByteArray();
                zzbeg.zzh(parcel);
                break;
            case 6:
                parcel.readInt();
                zzbeg.zzh(parcel);
                break;
            case 7:
                parcel.readInt();
                zzbeg.zzh(parcel);
                break;
            case 8:
                IObjectWrapper.Stub.x3(parcel.readStrongBinder());
                parcel.readString();
                parcel.readString();
                zzbeg.zzh(parcel);
                break;
            default:
                return false;
        }
        parcel2.writeNoException();
        return true;
    }
}
