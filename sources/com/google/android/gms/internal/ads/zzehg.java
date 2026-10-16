package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzehg {
    private final zzcnj zza;
    private final Context zzb;
    private final Executor zzc;

    zzehg(zzcnj zzcnjVar, Context context, Executor executor) {
        this.zza = zzcnjVar;
        this.zzb = context;
        this.zzc = executor;
    }

    public final void zza() {
        this.zzc.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzehf
            @Override // java.lang.Runnable
            public final /* synthetic */ void run() {
                this.zza.zzb();
            }
        });
    }

    final /* synthetic */ void zzb() {
        zzehi zzehiVarZzh = this.zza.zzh();
        zzehiVarZzh.zzb(this.zzb);
        zzehiVarZzh.zza().zza().zza();
    }
}
