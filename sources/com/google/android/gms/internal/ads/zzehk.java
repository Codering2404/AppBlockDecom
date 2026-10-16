package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzehk implements zzefw {
    final /* synthetic */ zzehn zza;

    zzehk(zzehn zzehnVar) {
        Objects.requireNonNull(zzehnVar);
        this.zza = zzehnVar;
    }

    @Override // com.google.android.gms.internal.ads.zzefw
    public final void zza() {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzpC)).booleanValue()) {
            zzdzk zzdzkVarZza = this.zza.zzd().zza();
            zzdzkVarZza.zzc("action", "ptard");
            zzdzkVarZza.zzc("ptard", "r");
            zzdzkVarZza.zzd();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzefw
    public final void zzb(RemoteException remoteException) {
        this.zza.zzc();
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzpD)).booleanValue()) {
            com.google.android.gms.ads.internal.zzt.l().zzg(remoteException, "Preconnect Remote");
        }
    }
}
