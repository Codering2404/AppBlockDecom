package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzfcc implements zzfck {
    private final boolean zza;

    zzfcc(zzfia zzfiaVar) {
        this.zza = zzfiaVar != null;
    }

    @Override // com.google.android.gms.internal.ads.zzfck
    public final ListenableFuture zza() {
        return zzhbw.zza(new zzfcb(this.zza, null));
    }

    @Override // com.google.android.gms.internal.ads.zzfck
    public final int zzb() {
        return 36;
    }
}
