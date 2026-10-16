package com.google.android.gms.internal.ads;

import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzhko implements zzhkq {
    private final AtomicBoolean zza = new AtomicBoolean(false);

    zzhko(boolean z2) {
    }

    @Override // com.google.android.gms.internal.ads.zzhkq
    public final boolean zza() {
        return this.zza.get();
    }
}
