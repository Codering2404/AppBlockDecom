package com.google.android.gms.internal.ads;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzwt implements zzze {
    private final zzze zza;
    private final zzgwm zzb;

    public zzwt(zzze zzzeVar, List list) {
        this.zza = zzzeVar;
        this.zzb = zzgwm.zzq(list);
    }

    public final zzgwm zza() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.ads.zzze
    public final void zzg(long j3) {
        this.zza.zzg(j3);
    }

    @Override // com.google.android.gms.internal.ads.zzze
    public final long zzi() {
        return this.zza.zzi();
    }

    @Override // com.google.android.gms.internal.ads.zzze
    public final long zzl() {
        return this.zza.zzl();
    }

    @Override // com.google.android.gms.internal.ads.zzze
    public final boolean zzm(zzma zzmaVar) {
        return this.zza.zzm(zzmaVar);
    }

    @Override // com.google.android.gms.internal.ads.zzze
    public final boolean zzn() {
        return this.zza.zzn();
    }
}
