package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzezo implements zzfck {
    private final zzhcg zza;
    private final zzfky zzb;

    zzezo(zzhcg zzhcgVar, zzfky zzfkyVar) {
        this.zza = zzhcgVar;
        this.zzb = zzfkyVar;
    }

    @Override // com.google.android.gms.internal.ads.zzfck
    public final ListenableFuture zza() {
        return this.zza.submit(new Callable() { // from class: com.google.android.gms.internal.ads.zzezn
            @Override // java.util.concurrent.Callable
            public final /* synthetic */ Object call() {
                return this.zza.zzc();
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzfck
    public final int zzb() {
        return 21;
    }

    final /* synthetic */ zzezp zzc() {
        return new zzezp("requester_type_2".equals(com.google.android.gms.ads.nonagon.signalgeneration.zzv.c(this.zzb.zzd)));
    }
}
