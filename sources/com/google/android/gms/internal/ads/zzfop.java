package com.google.android.gms.internal.ads;

import java.util.concurrent.ScheduledExecutorService;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzfop implements zzimu {
    private final zzind zza;

    private zzfop(zzind zzindVar, zzind zzindVar2) {
        this.zza = zzindVar;
    }

    public static zzfop zza(zzind zzindVar, zzind zzindVar2) {
        return new zzfop(zzindVar, zzindVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzinj, com.google.android.gms.internal.ads.zzini
    public final /* bridge */ /* synthetic */ Object zzb() {
        return new zzfoo((ScheduledExecutorService) this.zza.zzb(), zzfoa.zzc());
    }
}
