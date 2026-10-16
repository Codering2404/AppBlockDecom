package com.google.android.gms.internal.ads;

import android.content.Context;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final /* synthetic */ class zzep implements Runnable {
    private final /* synthetic */ zzeq zza;
    private final /* synthetic */ Context zzb;

    /* synthetic */ zzep(zzeq zzeqVar, Context context) {
        this.zza = zzeqVar;
        this.zzb = context;
    }

    @Override // java.lang.Runnable
    public final /* synthetic */ void run() {
        this.zza.zza.zzd(this.zzb);
    }
}
