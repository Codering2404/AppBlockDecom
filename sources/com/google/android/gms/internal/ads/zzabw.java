package com.google.android.gms.internal.ads;

import java.util.concurrent.ExecutorService;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final /* synthetic */ class zzabw implements zzdt {
    static final /* synthetic */ zzabw zza = new zzabw();

    private /* synthetic */ zzabw() {
    }

    @Override // com.google.android.gms.internal.ads.zzdt
    public final /* synthetic */ void zza(Object obj) {
        ((ExecutorService) obj).shutdown();
    }
}
