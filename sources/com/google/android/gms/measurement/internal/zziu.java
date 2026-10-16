package com.google.android.gms.measurement.internal;

import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zziu implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ zzpl f73961a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ zzr f73962b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ zzjd f73963c;

    zziu(zzjd zzjdVar, zzpl zzplVar, zzr zzrVar) {
        this.f73961a = zzplVar;
        this.f73962b = zzrVar;
        Objects.requireNonNull(zzjdVar);
        this.f73963c = zzjdVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzjd zzjdVar = this.f73963c;
        zzjdVar.n5().E();
        zzpl zzplVar = this.f73961a;
        if (zzplVar.zza() != null) {
            zzjdVar.n5().c0(zzplVar, this.f73962b);
        } else {
            zzr zzrVar = this.f73962b;
            zzjdVar.n5().d0(zzplVar.f74478b, zzrVar);
        }
    }
}
