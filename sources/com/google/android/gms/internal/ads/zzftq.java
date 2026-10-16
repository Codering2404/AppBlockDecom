package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzftq implements Runnable {
    final /* synthetic */ com.google.android.gms.ads.internal.client.zzdx zza;
    final /* synthetic */ zzfub zzb;

    zzftq(zzfub zzfubVar, com.google.android.gms.ads.internal.client.zzdx zzdxVar) {
        this.zza = zzdxVar;
        Objects.requireNonNull(zzfubVar);
        this.zzb = zzfubVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzb.zzK(this.zza);
    }
}
