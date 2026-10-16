package com.google.android.gms.internal.ads;

import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzgsm {
    private final Mutex zza = MutexKt.b(false, 1, null);

    public final Mutex zza() {
        return this.zza;
    }
}
