package com.google.android.gms.ads.internal.util;

import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
final class zza implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ zzb f70201a;

    zza(zzb zzbVar) {
        Objects.requireNonNull(zzbVar);
        this.f70201a = zzbVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzb zzbVar = this.f70201a;
        zzbVar.zzc(Thread.currentThread());
        zzbVar.zza();
    }
}
