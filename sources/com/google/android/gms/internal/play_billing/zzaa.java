package com.google.android.gms.internal.play_billing;

import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzaa extends zzas implements zzac {
    zzaa(IBinder iBinder) {
        super(iBinder, "com.android.vending.billing.IInAppBillingDelegateToBackendCallback");
    }

    @Override // com.google.android.gms.internal.play_billing.zzac
    public final void onDelegateToBackendResponse(Bundle bundle) throws RemoteException {
        throw null;
    }
}
