package com.google.android.gms.internal.ads;

import java.util.concurrent.ScheduledExecutorService;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzeyl implements zzimu {
    private final zzind zza;

    private zzeyl(zzind zzindVar, zzind zzindVar2) {
        this.zza = zzindVar2;
    }

    public static zzeyl zza(zzind zzindVar, zzind zzindVar2) {
        return new zzeyl(zzindVar, zzindVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzinj, com.google.android.gms.internal.ads.zzini
    public final /* bridge */ /* synthetic */ Object zzb() {
        return new zzfaw(zzezi.zzc(), ((Integer) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zznJ)).intValue(), (ScheduledExecutorService) this.zza.zzb());
    }
}
