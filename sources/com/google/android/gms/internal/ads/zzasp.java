package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzasp implements Runnable {
    final /* synthetic */ zzate zza;
    final /* synthetic */ zzasq zzb;

    zzasp(zzasq zzasqVar, zzate zzateVar) {
        this.zza = zzateVar;
        Objects.requireNonNull(zzasqVar);
        this.zzb = zzasqVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            this.zzb.zzb().put(this.zza);
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
        }
    }
}
