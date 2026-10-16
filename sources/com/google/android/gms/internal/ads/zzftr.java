package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzftr implements Runnable {
    final /* synthetic */ long zza;
    final /* synthetic */ com.google.android.gms.ads.internal.client.zzdx zzb;
    final /* synthetic */ zzfub zzc;

    zzftr(zzfub zzfubVar, long j3, com.google.android.gms.ads.internal.client.zzdx zzdxVar) {
        this.zza = j3;
        this.zzb = zzdxVar;
        Objects.requireNonNull(zzfubVar);
        this.zzc = zzfubVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzfub zzfubVar = this.zzc;
        if (zzfubVar.zzN() != null) {
            long j3 = this.zza;
            String strZzV = zzfub.zzV(this.zzb);
            int iZzs = zzfubVar.zzs();
            int iZzt = zzfubVar.zzt();
            String strZzM = zzfubVar.zzM();
            zzfubVar.zzN().zzi(j3, strZzV, zzfubVar.zzP(), iZzs, iZzt, strZzM);
        }
    }
}
