package com.google.android.gms.internal.play_billing;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzaw extends zzas implements zzay {
    zzaw(IBinder iBinder) {
        super(iBinder, "com.google.android.apps.play.billingtestcompanion.aidl.IBillingOverrideService");
    }

    @Override // com.google.android.gms.internal.play_billing.zzay
    public final void zza(String str, String str2, zzba zzbaVar) throws RemoteException {
        Parcel parcelZzt = zzt();
        parcelZzt.writeString(str);
        parcelZzt.writeString(str2);
        zzau.zzc(parcelZzt, zzbaVar);
        zzw(1, parcelZzt);
    }
}
