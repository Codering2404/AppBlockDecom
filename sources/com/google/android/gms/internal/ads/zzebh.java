package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzebh extends zzcco {
    final /* synthetic */ zzebj zza;

    zzebh(zzebj zzebjVar) {
        Objects.requireNonNull(zzebjVar);
        this.zza = zzebjVar;
    }

    @Override // com.google.android.gms.internal.ads.zzccp
    public final void zze() throws RemoteException {
        zzebj zzebjVar = this.zza;
        zzebjVar.zze().zzk(zzebjVar.zzd());
    }

    @Override // com.google.android.gms.internal.ads.zzccp
    public final void zzf(int i3) throws RemoteException {
        zzebj zzebjVar = this.zza;
        zzebjVar.zze().zzl(zzebjVar.zzd(), i3);
    }

    @Override // com.google.android.gms.internal.ads.zzccp
    public final void zzg(com.google.android.gms.ads.internal.client.zze zzeVar) throws RemoteException {
        zzebj zzebjVar = this.zza;
        zzebjVar.zze().zzl(zzebjVar.zzd(), zzeVar.f69851a);
    }
}
