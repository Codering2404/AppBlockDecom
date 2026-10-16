package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzgxz extends zzgxy {
    final /* synthetic */ zzgya zza;

    zzgxz(zzgya zzgyaVar, int i3) {
        Objects.requireNonNull(zzgyaVar);
        this.zza = zzgyaVar;
    }

    @Override // com.google.android.gms.internal.ads.zzgxy
    public final zzgxh zza() {
        return new zzgyc(this.zza.zza(), new zzgxx(2));
    }
}
