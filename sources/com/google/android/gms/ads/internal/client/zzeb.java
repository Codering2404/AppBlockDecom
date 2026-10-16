package com.google.android.gms.ads.internal.client;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.ads.zzbee;
import com.google.android.gms.internal.ads.zzbeg;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzeb extends zzbee implements zzed {
    zzeb(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.client.IVideoLifecycleCallbacks");
    }

    @Override // com.google.android.gms.ads.internal.client.zzed
    public final void t1(boolean z2) throws RemoteException {
        Parcel parcelZza = zza();
        int i3 = zzbeg.zza;
        parcelZza.writeInt(z2 ? 1 : 0);
        zzda(5, parcelZza);
    }

    @Override // com.google.android.gms.ads.internal.client.zzed
    public final void zze() throws RemoteException {
        zzda(1, zza());
    }

    @Override // com.google.android.gms.ads.internal.client.zzed
    public final void zzf() throws RemoteException {
        zzda(2, zza());
    }

    @Override // com.google.android.gms.ads.internal.client.zzed
    public final void zzg() throws RemoteException {
        zzda(3, zza());
    }

    @Override // com.google.android.gms.ads.internal.client.zzed
    public final void zzh() throws RemoteException {
        zzda(4, zza());
    }
}
