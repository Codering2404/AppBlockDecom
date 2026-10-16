package com.google.android.gms.internal.ads;

import java.util.Objects;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzfhg implements zzhbt {
    zzfhg(zzfhj zzfhjVar) {
        Objects.requireNonNull(zzfhjVar);
    }

    @Override // com.google.android.gms.internal.ads.zzhbt
    public final void zza(Throwable th) {
        com.google.android.gms.ads.internal.util.zze.k("Notification of cache hit failed.");
    }

    @Override // com.google.android.gms.internal.ads.zzhbt
    public final /* synthetic */ void zzb(@NullableDecl Object obj) {
        com.google.android.gms.ads.internal.util.zze.k("Notification of cache hit successful.");
    }
}
