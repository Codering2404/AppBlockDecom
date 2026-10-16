package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final /* synthetic */ class zzgfv implements zzhbe {
    static final /* synthetic */ zzgfv zza = new zzgfv();

    private /* synthetic */ zzgfv() {
    }

    @Override // com.google.android.gms.internal.ads.zzhbe
    public final /* synthetic */ ListenableFuture zza(Object obj) {
        final zzgfr zzgfrVar = (zzgfr) obj;
        return zzhbw.zzk(zzgfrVar.zzb(), new zzgta() { // from class: com.google.android.gms.internal.ads.zzgfw
            @Override // com.google.android.gms.internal.ads.zzgta
            public final /* synthetic */ Object apply(Object obj2) {
                return zzgfrVar;
            }
        }, zzhcn.zza());
    }
}
