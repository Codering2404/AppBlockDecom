package com.google.android.gms.internal.ads;

import android.content.Context;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzfuj {
    private boolean zza;

    final boolean zza() {
        return this.zza;
    }

    final void zzb(Context context) {
        zzfwi.zzb(context, "Application Context cannot be null");
        if (this.zza) {
            return;
        }
        this.zza = true;
        zzfvq.zza().zzb(context);
        zzfvh.zza().zzd(context);
        zzfwd.zza(context);
        zzfwe.zza(context);
        zzfwh.zza(context);
        zzfvn.zza().zzc(context);
        zzfvg.zza().zzc(context);
        zzfvs.zza().zzb(context);
    }
}
