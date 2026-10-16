package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public abstract class zzbsd extends zzbef implements zzbse {
    public zzbsd() {
        super("com.google.android.gms.ads.internal.instream.client.IInstreamAd");
    }

    @Override // com.google.android.gms.internal.ads.zzbef
    protected final boolean zzdd(int i3, Parcel parcel, Parcel parcel2, int i4) throws RemoteException {
        zzbsh zzbsfVar;
        if (i3 == 3) {
            com.google.android.gms.ads.internal.client.zzea zzeaVarZzb = zzb();
            parcel2.writeNoException();
            zzbeg.zze(parcel2, zzeaVarZzb);
            return true;
        }
        if (i3 == 4) {
            zzc();
            parcel2.writeNoException();
            return true;
        }
        if (i3 == 5) {
            IObjectWrapper iObjectWrapperX3 = IObjectWrapper.Stub.x3(parcel.readStrongBinder());
            IBinder strongBinder = parcel.readStrongBinder();
            if (strongBinder == null) {
                zzbsfVar = null;
            } else {
                IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.ads.internal.instream.client.IInstreamAdCallback");
                zzbsfVar = iInterfaceQueryLocalInterface instanceof zzbsh ? (zzbsh) iInterfaceQueryLocalInterface : new zzbsf(strongBinder);
            }
            zzbeg.zzh(parcel);
            zzd(iObjectWrapperX3, zzbsfVar);
            parcel2.writeNoException();
            return true;
        }
        if (i3 == 6) {
            IObjectWrapper iObjectWrapperX32 = IObjectWrapper.Stub.x3(parcel.readStrongBinder());
            zzbeg.zzh(parcel);
            zze(iObjectWrapperX32);
            parcel2.writeNoException();
            return true;
        }
        if (i3 != 7) {
            return false;
        }
        zzbmb zzbmbVarZzf = zzf();
        parcel2.writeNoException();
        zzbeg.zze(parcel2, zzbmbVarZzf);
        return true;
    }
}
