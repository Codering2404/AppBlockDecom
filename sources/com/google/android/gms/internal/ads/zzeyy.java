package com.google.android.gms.internal.ads;

import java.util.concurrent.ScheduledExecutorService;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzeyy implements zzimu {
    private final zzind zza;
    private final zzind zzb;

    private zzeyy(zzind zzindVar, zzind zzindVar2) {
        this.zza = zzindVar;
        this.zzb = zzindVar2;
    }

    public static zzeyy zza(zzind zzindVar, zzind zzindVar2) {
        return new zzeyy(zzindVar, zzindVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzinj, com.google.android.gms.internal.ads.zzini
    public final /* bridge */ /* synthetic */ Object zzb() {
        return new zzfaw(((zzfch) this.zza).zzb(), ((Integer) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zznA)).intValue(), (ScheduledExecutorService) this.zzb.zzb());
    }
}
