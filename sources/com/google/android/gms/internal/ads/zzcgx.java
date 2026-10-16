package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzcgx implements Runnable {
    final /* synthetic */ boolean zza;
    final /* synthetic */ zzchb zzb;

    zzcgx(zzchb zzchbVar, boolean z2) {
        this.zza = z2;
        Objects.requireNonNull(zzchbVar);
        this.zzb = zzchbVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzb.zzI("windowVisibilityChanged", new String[]{"isVisible", String.valueOf(this.zza)});
    }
}
