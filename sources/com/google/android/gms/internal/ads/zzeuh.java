package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;
import com.google.common.util.concurrent.ListenableFuture;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzeuh implements zzfck {
    private final Clock zza;
    private final zzfky zzb;
    private final long zzc;

    zzeuh(Clock clock, zzfky zzfkyVar, long j3) {
        this.zza = clock;
        this.zzb = zzfkyVar;
        this.zzc = j3;
    }

    @Override // com.google.android.gms.internal.ads.zzfck
    public final ListenableFuture zza() {
        return zzhbw.zza(new zzeui(this.zzb, this.zza.currentTimeMillis(), this.zzc));
    }

    @Override // com.google.android.gms.internal.ads.zzfck
    public final int zzb() {
        return 4;
    }
}
