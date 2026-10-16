package com.google.android.gms.internal.ads;

import java.util.Objects;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzeiz {
    private final zzeiv zza;
    private final zzhcg zzb;

    public zzeiz(zzeiv zzeivVar, zzhcg zzhcgVar) {
        this.zza = zzeivVar;
        this.zzb = zzhcgVar;
    }

    public final void zza(zzfok zzfokVar) {
        final zzeiv zzeivVar = this.zza;
        Objects.requireNonNull(zzeivVar);
        Callable callable = new Callable() { // from class: com.google.android.gms.internal.ads.zzeiy
            @Override // java.util.concurrent.Callable
            public final /* synthetic */ Object call() {
                return zzeivVar.getWritableDatabase();
            }
        };
        zzhcg zzhcgVar = this.zzb;
        zzhbw.zzr(zzhcgVar.submit(callable), new zzeix(this, zzfokVar), zzhcgVar);
    }
}
