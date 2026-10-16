package com.google.android.gms.ads.internal.client;

import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.ads.zzbef;
import com.google.android.gms.internal.ads.zzbeg;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class zzds extends zzbef implements zzdt {
    public zzds() {
        super("com.google.android.gms.ads.internal.client.IOutOfContextTester");
    }

    @Override // com.google.android.gms.internal.ads.zzbef
    protected final boolean zzdd(int i3, Parcel parcel, Parcel parcel2, int i4) throws RemoteException {
        if (i3 != 1) {
            return false;
        }
        String string = parcel.readString();
        IObjectWrapper iObjectWrapperX3 = IObjectWrapper.Stub.x3(parcel.readStrongBinder());
        IObjectWrapper iObjectWrapperX32 = IObjectWrapper.Stub.x3(parcel.readStrongBinder());
        zzbeg.zzh(parcel);
        zze(string, iObjectWrapperX3, iObjectWrapperX32);
        parcel2.writeNoException();
        return true;
    }
}
