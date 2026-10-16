package com.google.android.gms.internal.ads;

import java.io.File;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzatw implements zzatz {
    final /* synthetic */ File zza;

    zzatw(zzaua zzauaVar, File file) {
        this.zza = file;
        Objects.requireNonNull(zzauaVar);
    }

    @Override // com.google.android.gms.internal.ads.zzatz
    public final File zza() {
        return this.zza;
    }
}
