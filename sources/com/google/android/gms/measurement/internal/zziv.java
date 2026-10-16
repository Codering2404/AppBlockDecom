package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import java.util.Objects;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zziv implements Callable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ zzr f73964a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ Bundle f73965b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ zzjd f73966c;

    zziv(zzjd zzjdVar, zzr zzrVar, Bundle bundle) {
        this.f73964a = zzrVar;
        this.f73965b = bundle;
        Objects.requireNonNull(zzjdVar);
        this.f73966c = zzjdVar;
    }

    @Override // java.util.concurrent.Callable
    public final /* bridge */ /* synthetic */ Object call() {
        zzjd zzjdVar = this.f73966c;
        zzjdVar.n5().E();
        return zzjdVar.n5().q0(this.f73964a, this.f73965b);
    }
}
