package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzbts implements zzcga {
    final /* synthetic */ zzbtt zza;

    zzbts(zzbtt zzbttVar) {
        Objects.requireNonNull(zzbttVar);
        this.zza = zzbttVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcga
    public final /* bridge */ /* synthetic */ void zza(Object obj) {
        final zzbsp zzbspVar = (zzbsp) obj;
        zzcfr.zzf.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzbtr
            @Override // java.lang.Runnable
            public final /* synthetic */ void run() {
                com.google.android.gms.ads.internal.util.zze.k("maybeDestroy > Destroying engine.");
                zzbsp zzbspVar2 = zzbspVar;
                zzbspVar2.zzn("/result", zzbpp.zzo);
                zzbspVar2.zzj();
            }
        });
    }
}
