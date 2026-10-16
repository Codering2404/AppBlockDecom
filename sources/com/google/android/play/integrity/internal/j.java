package com.google.android.play.integrity.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public abstract class j extends b implements k {
    public j() {
        super("com.google.android.play.core.integrity.protocol.IExpressIntegrityServiceCallback");
    }

    @Override // com.google.android.play.integrity.internal.b
    protected final boolean a(int i3, Parcel parcel, Parcel parcel2, int i4) throws RemoteException {
        if (i3 == 2) {
            Bundle bundle = (Bundle) c.a(parcel, Bundle.CREATOR);
            c.b(parcel);
            e(bundle);
            return true;
        }
        if (i3 == 3) {
            Bundle bundle2 = (Bundle) c.a(parcel, Bundle.CREATOR);
            c.b(parcel);
            c(bundle2);
            return true;
        }
        if (i3 == 4) {
            Bundle bundle3 = (Bundle) c.a(parcel, Bundle.CREATOR);
            c.b(parcel);
            d(bundle3);
            return true;
        }
        if (i3 != 5) {
            return false;
        }
        Bundle bundle4 = (Bundle) c.a(parcel, Bundle.CREATOR);
        c.b(parcel);
        b(bundle4);
        return true;
    }
}
