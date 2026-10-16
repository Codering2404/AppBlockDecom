package com.google.android.gms.measurement.internal;

import java.util.Objects;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zziq implements Callable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ zzr f73950a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ zzjd f73951b;

    zziq(zzjd zzjdVar, zzr zzrVar) {
        this.f73950a = zzrVar;
        Objects.requireNonNull(zzjdVar);
        this.f73951b = zzjdVar;
    }

    @Override // java.util.concurrent.Callable
    public final /* bridge */ /* synthetic */ Object call() {
        zzjd zzjdVar = this.f73951b;
        zzjdVar.n5().E();
        return new zzao(zzjdVar.n5().S0(this.f73950a.f74500a));
    }
}
