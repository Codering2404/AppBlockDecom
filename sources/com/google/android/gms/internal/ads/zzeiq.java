package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzeiq {
    private final zzcaw zza;

    zzeiq(zzcaw zzcawVar) {
        this.zza = zzcawVar;
    }

    public final void zza() {
        ListenableFuture listenableFutureZza = this.zza.zza();
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zziG)).booleanValue()) {
            zzcfu.zzb(listenableFutureZza, "persistFlags");
        } else {
            zzcfu.zza(listenableFutureZza, "persistFlags", zzcfr.zzh);
        }
    }
}
