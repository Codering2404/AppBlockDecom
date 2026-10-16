package com.google.android.gms.internal.ads;

import java.util.Map;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzcty implements zzbpq {
    final /* synthetic */ zzcub zza;

    zzcty(zzcub zzcubVar) {
        Objects.requireNonNull(zzcubVar);
        this.zza = zzcubVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbpq
    public final void zza(Object obj, Map map) {
        zzcub zzcubVar = this.zza;
        if (zzcubVar.zze(map)) {
            zzcubVar.zzf().execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzctx
                @Override // java.lang.Runnable
                public final /* synthetic */ void run() {
                    this.zza.zza.zzg().zzl();
                }
            });
        }
    }
}
