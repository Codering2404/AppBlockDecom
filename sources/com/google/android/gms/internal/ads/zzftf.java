package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzftf implements zzbfk {
    final /* synthetic */ zzfth zza;

    zzftf(zzfth zzfthVar) {
        Objects.requireNonNull(zzfthVar);
        this.zza = zzfthVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbfk
    public final void zza(boolean z2) {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzz)).booleanValue()) {
            this.zza.zzj(z2);
        }
    }
}
