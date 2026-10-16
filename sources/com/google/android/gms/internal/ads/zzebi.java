package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzebi extends zzcck {
    final /* synthetic */ zzebj zza;

    zzebi(zzebj zzebjVar) {
        Objects.requireNonNull(zzebjVar);
        this.zza = zzebjVar;
    }

    @Override // com.google.android.gms.internal.ads.zzccl
    public final void zze() throws RemoteException {
        zzebj zzebjVar = this.zza;
        zzebjVar.zze().zzm(zzebjVar.zzd());
    }

    @Override // com.google.android.gms.internal.ads.zzccl
    public final void zzf() throws RemoteException {
        zzebj zzebjVar = this.zza;
        zzebjVar.zze().zzo(zzebjVar.zzd());
    }

    @Override // com.google.android.gms.internal.ads.zzccl
    public final void zzg(zzccf zzccfVar) throws RemoteException {
        zzebj zzebjVar = this.zza;
        zzebjVar.zze().zzp(zzebjVar.zzd(), zzccfVar);
    }

    @Override // com.google.android.gms.internal.ads.zzccl
    public final void zzh(int i3) throws RemoteException {
        zzebj zzebjVar = this.zza;
        zzebjVar.zze().zzn(zzebjVar.zzd(), i3);
    }

    @Override // com.google.android.gms.internal.ads.zzccl
    public final void zzi(com.google.android.gms.ads.internal.client.zze zzeVar) throws RemoteException {
        zzebj zzebjVar = this.zza;
        zzebjVar.zze().zzn(zzebjVar.zzd(), zzeVar.f69851a);
    }

    @Override // com.google.android.gms.internal.ads.zzccl
    public final void zzj() throws RemoteException {
        zzebj zzebjVar = this.zza;
        zzebjVar.zze().zzq(zzebjVar.zzd());
    }

    @Override // com.google.android.gms.internal.ads.zzccl
    public final void zzk() throws RemoteException {
        zzebj zzebjVar = this.zza;
        zzebjVar.zze().zzr(zzebjVar.zzd());
    }
}
