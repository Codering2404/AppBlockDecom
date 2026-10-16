package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzbhf extends zzcfw {
    final /* synthetic */ zzbhl zza;

    zzbhf(zzbhl zzbhlVar) {
        Objects.requireNonNull(zzbhlVar);
        this.zza = zzbhlVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcfw, java.util.concurrent.Future
    public final boolean cancel(boolean z2) {
        this.zza.zzb();
        return super.cancel(z2);
    }
}
