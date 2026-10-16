package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzcy extends zzbl implements zzda {
    zzcy(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.measurement.api.internal.IEventHandlerProxy");
    }

    @Override // com.google.android.gms.internal.measurement.zzda
    public final void zze(String str, String str2, Bundle bundle, long j3) throws RemoteException {
        Parcel parcelZza = zza();
        parcelZza.writeString(str);
        parcelZza.writeString(str2);
        zzbn.zzc(parcelZza, bundle);
        parcelZza.writeLong(j3);
        zzc(1, parcelZza);
    }

    @Override // com.google.android.gms.internal.measurement.zzda
    public final int zzf() throws RemoteException {
        Parcel parcelZzP = zzP(2, zza());
        int i3 = parcelZzP.readInt();
        parcelZzP.recycle();
        return i3;
    }
}
