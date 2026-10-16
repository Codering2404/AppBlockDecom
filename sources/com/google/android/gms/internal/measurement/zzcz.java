package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public abstract class zzcz extends zzbm implements zzda {
    public zzcz() {
        super("com.google.android.gms.measurement.api.internal.IEventHandlerProxy");
    }

    @Override // com.google.android.gms.internal.measurement.zzbm
    protected final boolean zza(int i3, Parcel parcel, Parcel parcel2, int i4) throws RemoteException {
        if (i3 == 1) {
            String string = parcel.readString();
            String string2 = parcel.readString();
            Bundle bundle = (Bundle) zzbn.zzb(parcel, Bundle.CREATOR);
            long j3 = parcel.readLong();
            zzbn.zzf(parcel);
            zze(string, string2, bundle, j3);
            parcel2.writeNoException();
        } else {
            if (i3 != 2) {
                return false;
            }
            int iZzf = zzf();
            parcel2.writeNoException();
            parcel2.writeInt(iZzf);
        }
        return true;
    }
}
