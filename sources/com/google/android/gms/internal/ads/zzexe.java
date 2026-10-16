package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzexe implements zzfck {
    private final zzhcg zza;
    private final zzdxh zzb;
    private final String zzc;
    private final zzfky zzd;

    public zzexe(zzhcg zzhcgVar, zzdxh zzdxhVar, zzfky zzfkyVar, String str) {
        this.zza = zzhcgVar;
        this.zzb = zzdxhVar;
        this.zzd = zzfkyVar;
        this.zzc = str;
    }

    @Override // com.google.android.gms.internal.ads.zzfck
    public final ListenableFuture zza() {
        return this.zza.submit(new Callable() { // from class: com.google.android.gms.internal.ads.zzexd
            @Override // java.util.concurrent.Callable
            public final /* synthetic */ Object call() {
                return this.zza.zzc();
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzfck
    public final int zzb() {
        return 17;
    }

    final /* synthetic */ zzexf zzc() {
        zzfky zzfkyVar = this.zzd;
        zzdxh zzdxhVar = this.zzb;
        return new zzexf(zzdxhVar.zzb(zzfkyVar.zzg, this.zzc), zzdxhVar.zzc());
    }
}
