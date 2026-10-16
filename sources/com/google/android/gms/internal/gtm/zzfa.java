package com.google.android.gms.internal.gtm;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzfa extends zzau implements IInterface {
    zzfa(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.analytics.internal.IAnalyticsService");
    }

    public final void zze() throws RemoteException {
        zzl(2, zza());
    }

    public final void zzf(Map map, long j3, String str, List list) throws RemoteException {
        Parcel parcelZza = zza();
        parcelZza.writeMap(map);
        parcelZza.writeLong(j3);
        parcelZza.writeString(str);
        parcelZza.writeTypedList(list);
        zzl(1, parcelZza);
    }
}
