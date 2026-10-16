package com.google.android.gms.measurement.internal;

import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzif implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ zzr f73916a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ zzjd f73917b;

    zzif(zzjd zzjdVar, zzr zzrVar) {
        this.f73916a = zzrVar;
        Objects.requireNonNull(zzjdVar);
        this.f73917b = zzjdVar;
    }

    @Override // java.lang.Runnable
    public final void run() throws Throwable {
        zzjd zzjdVar = this.f73917b;
        zzjdVar.n5().E();
        zzjdVar.n5().i0(this.f73916a);
    }
}
