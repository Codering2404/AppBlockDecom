package com.google.android.gms.internal.ads;

import java.util.Set;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzhba extends zzhaz {
    private static final AtomicReferenceFieldUpdater zza = AtomicReferenceFieldUpdater.newUpdater(zzhbc.class, Set.class, "seenExceptionsField");
    private static final AtomicIntegerFieldUpdater zzb = AtomicIntegerFieldUpdater.newUpdater(zzhbc.class, "remainingField");

    private zzhba() {
        throw null;
    }

    @Override // com.google.android.gms.internal.ads.zzhaz
    final void zza(zzhbc zzhbcVar, Set set, Set set2) {
        androidx.concurrent.futures.a.a(zza, zzhbcVar, null, set2);
    }

    @Override // com.google.android.gms.internal.ads.zzhaz
    final int zzb(zzhbc zzhbcVar) {
        return zzb.decrementAndGet(zzhbcVar);
    }

    /* synthetic */ zzhba(byte[] bArr) {
        super(null);
    }
}
