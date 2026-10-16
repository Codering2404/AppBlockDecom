package com.google.android.gms.internal.play_billing;

import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public abstract class zzaz extends zzat implements zzba {
    public zzaz() {
        super("com.google.android.apps.play.billingtestcompanion.aidl.IBillingOverrideServiceCallback");
    }

    @Override // com.google.android.gms.internal.play_billing.zzat
    protected final boolean dispatchTransaction(int i3, Parcel parcel, Parcel parcel2, int i4) throws RemoteException {
        if (i3 != 1) {
            return false;
        }
        int i5 = parcel.readInt();
        enforceNoDataAvail(parcel);
        zza(i5);
        return true;
    }
}
