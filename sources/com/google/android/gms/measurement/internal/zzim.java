package com.google.android.gms.measurement.internal;

import java.util.Objects;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzim implements Callable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ String f73940a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ String f73941b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ String f73942c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ zzjd f73943d;

    zzim(zzjd zzjdVar, String str, String str2, String str3) {
        this.f73940a = str;
        this.f73941b = str2;
        this.f73942c = str3;
        Objects.requireNonNull(zzjdVar);
        this.f73943d = zzjdVar;
    }

    @Override // java.util.concurrent.Callable
    public final /* bridge */ /* synthetic */ Object call() {
        zzjd zzjdVar = this.f73943d;
        zzjdVar.n5().E();
        return zzjdVar.n5().F0().H0(this.f73940a, this.f73941b, this.f73942c);
    }
}
