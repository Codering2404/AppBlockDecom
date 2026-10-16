package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzexa implements zzfck {
    private final zzhcg zza;

    zzexa(zzhcg zzhcgVar) {
        this.zza = zzhcgVar;
    }

    @Override // com.google.android.gms.internal.ads.zzfck
    public final ListenableFuture zza() {
        return this.zza.submit(new Callable(this) { // from class: com.google.android.gms.internal.ads.zzewz
            @Override // java.util.concurrent.Callable
            public final /* synthetic */ Object call() {
                return new zzexb(com.google.android.gms.ads.internal.zzt.o().currentTimeMillis() - com.google.android.gms.ads.internal.zzt.l().zzo().zzi().zzb());
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzfck
    public final int zzb() {
        return 55;
    }
}
