package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzczv implements zzdim, zzdef {
    private final Clock zza;
    private final zzczx zzb;
    private final zzfky zzc;
    private final String zzd;

    zzczv(Clock clock, zzczx zzczxVar, zzfky zzfkyVar, String str) {
        this.zza = clock;
        this.zzb = zzczxVar;
        this.zzc = zzfkyVar;
        this.zzd = str;
    }

    @Override // com.google.android.gms.internal.ads.zzdim
    public final void zza() {
        this.zzb.zzd(this.zzd, this.zza.a());
    }

    @Override // com.google.android.gms.internal.ads.zzdef
    public final void zzg() {
        Clock clock = this.zza;
        this.zzb.zze(this.zzc.zzg, this.zzd, clock.a());
    }
}
