package com.google.android.libraries.places.internal;

import com.google.common.math.LongMath;
import java.time.Instant;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzbtg implements zzcag {
    zzbtg() {
    }

    @Override // com.google.android.libraries.places.internal.zzcag
    public final long zza() {
        return LongMath.d(TimeUnit.SECONDS.toNanos(Instant.now().getEpochSecond()), r0.getNano());
    }
}
