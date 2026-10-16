package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzbeh extends zzbee implements zzbej {
    zzbeh(IBinder iBinder) {
        super(iBinder, "com.google.android.finsky.externalreferrer.IGetInstallReferrerService");
    }

    @Override // com.google.android.gms.internal.ads.zzbej
    public final Bundle zze(Bundle bundle) throws RemoteException {
        Parcel parcelZza = zza();
        zzbeg.zzc(parcelZza, bundle);
        Parcel parcelZzcZ = zzcZ(1, parcelZza);
        Bundle bundle2 = (Bundle) zzbeg.zzb(parcelZzcZ, Bundle.CREATOR);
        parcelZzcZ.recycle();
        return bundle2;
    }
}
