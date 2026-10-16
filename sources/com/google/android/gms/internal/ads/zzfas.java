package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzfas implements zzfck {
    private final zzhcg zza;
    private final zzeao zzb;

    zzfas(zzhcg zzhcgVar, zzeao zzeaoVar) {
        this.zza = zzhcgVar;
        this.zzb = zzeaoVar;
    }

    @Override // com.google.android.gms.internal.ads.zzfck
    public final ListenableFuture zza() {
        return this.zza.submit(new Callable() { // from class: com.google.android.gms.internal.ads.zzfar
            @Override // java.util.concurrent.Callable
            public final /* synthetic */ Object call() {
                return this.zza.zzc();
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzfck
    public final int zzb() {
        return 62;
    }

    final /* synthetic */ zzfat zzc() {
        return new zzfat(this.zzb.zzb());
    }
}
