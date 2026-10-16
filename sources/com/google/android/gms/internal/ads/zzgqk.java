package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzgqk extends zzbee implements zzgqm {
    zzgqk(IBinder iBinder) {
        super(iBinder, "com.google.android.play.core.lmd.protocol.ILmdOverlayService");
    }

    @Override // com.google.android.gms.internal.ads.zzgqm
    public final void zze(String str, Bundle bundle, zzgqo zzgqoVar) throws RemoteException {
        Parcel parcelZza = zza();
        parcelZza.writeString(str);
        zzbeg.zzc(parcelZza, bundle);
        zzbeg.zze(parcelZza, zzgqoVar);
        zzdb(1, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzgqm
    public final void zzf(Bundle bundle, zzgqo zzgqoVar) throws RemoteException {
        Parcel parcelZza = zza();
        zzbeg.zzc(parcelZza, bundle);
        zzbeg.zze(parcelZza, zzgqoVar);
        zzdb(2, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzgqm
    public final void zzg(Bundle bundle, zzgqo zzgqoVar) throws RemoteException {
        Parcel parcelZza = zza();
        zzbeg.zzc(parcelZza, bundle);
        zzbeg.zze(parcelZza, zzgqoVar);
        zzdb(3, parcelZza);
    }
}
