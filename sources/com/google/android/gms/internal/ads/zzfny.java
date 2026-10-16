package com.google.android.gms.internal.ads;

import java.util.concurrent.ExecutorService;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzfny implements zzimu {
    public static zzfny zza() {
        return zzfnx.zza;
    }

    public static ExecutorService zzc() {
        ExecutorService executorService = zzcfr.zzg;
        zzinc.zzb(executorService);
        return executorService;
    }

    @Override // com.google.android.gms.internal.ads.zzinj, com.google.android.gms.internal.ads.zzini
    public final /* synthetic */ Object zzb() {
        return zzc();
    }
}
