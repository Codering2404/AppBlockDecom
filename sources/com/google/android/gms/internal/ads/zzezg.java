package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzezg implements zzfck {
    private final zzhcg zza;

    public zzezg(zzhcg zzhcgVar) {
        this.zza = zzhcgVar;
    }

    @Override // com.google.android.gms.internal.ads.zzfck
    public final ListenableFuture zza() {
        return this.zza.submit(zzezf.zza);
    }

    @Override // com.google.android.gms.internal.ads.zzfck
    public final int zzb() {
        return 20;
    }
}
