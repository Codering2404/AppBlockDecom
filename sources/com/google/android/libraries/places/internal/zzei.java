package com.google.android.libraries.places.internal;

import android.os.SystemClock;
import java.time.Instant;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzei implements zzef {
    @Override // com.google.android.libraries.places.internal.zzef
    public final Instant zza() {
        return Instant.now();
    }

    @Override // com.google.android.libraries.places.internal.zzef
    public final long zzb() {
        return SystemClock.elapsedRealtime();
    }
}
