package com.google.android.gms.measurement.internal;

import java.util.Objects;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzij implements Callable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ String f73928a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ String f73929b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ String f73930c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ zzjd f73931d;

    zzij(zzjd zzjdVar, String str, String str2, String str3) {
        this.f73928a = str;
        this.f73929b = str2;
        this.f73930c = str3;
        Objects.requireNonNull(zzjdVar);
        this.f73931d = zzjdVar;
    }

    @Override // java.util.concurrent.Callable
    public final /* bridge */ /* synthetic */ Object call() {
        zzjd zzjdVar = this.f73931d;
        zzjdVar.n5().E();
        return zzjdVar.n5().F0().D0(this.f73928a, this.f73929b, this.f73930c);
    }
}
