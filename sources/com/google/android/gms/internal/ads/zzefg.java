package com.google.android.gms.internal.ads;

import java.util.concurrent.ScheduledExecutorService;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzefg implements zzimu {
    private final zzind zza;
    private final zzind zzb;
    private final zzind zzc;

    private zzefg(zzind zzindVar, zzind zzindVar2, zzind zzindVar3, zzind zzindVar4, zzind zzindVar5) {
        this.zza = zzindVar;
        this.zzb = zzindVar4;
        this.zzc = zzindVar5;
    }

    public static zzefg zzc(zzind zzindVar, zzind zzindVar2, zzind zzindVar3, zzind zzindVar4, zzind zzindVar5) {
        return new zzefg(zzindVar, zzindVar2, zzindVar3, zzindVar4, zzindVar5);
    }

    @Override // com.google.android.gms.internal.ads.zzinj, com.google.android.gms.internal.ads.zzini
    /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
    public final zzeff zzb() {
        return new zzeff((ScheduledExecutorService) this.zza.zzb(), zzfoa.zzc(), zzfog.zzc(), ((zzegf) this.zzb).zzb(), zzimt.zzc(this.zzc));
    }
}
