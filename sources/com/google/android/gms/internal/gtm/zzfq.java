package com.google.android.gms.internal.gtm;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzfq {
    private final Clock zza;
    private long zzb;

    public zzfq(Clock clock) {
        Preconditions.m(clock);
        this.zza = clock;
    }

    public final void zza() {
        this.zzb = 0L;
    }

    public final void zzb() {
        this.zzb = this.zza.a();
    }

    public final boolean zzc(long j3) {
        return this.zzb == 0 || this.zza.a() - this.zzb > j3;
    }

    public zzfq(Clock clock, long j3) {
        Preconditions.m(clock);
        this.zza = clock;
        this.zzb = j3;
    }
}
