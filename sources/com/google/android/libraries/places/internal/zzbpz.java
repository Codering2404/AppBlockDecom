package com.google.android.libraries.places.internal;

import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzbpz implements zzcag {
    zzbpz() {
    }

    @Override // com.google.android.libraries.places.internal.zzcag
    public final long zza() {
        return TimeUnit.MILLISECONDS.toNanos(System.currentTimeMillis());
    }
}
