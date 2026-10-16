package com.google.android.gms.measurement.internal;

import java.util.Objects;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzik implements Callable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ String f73932a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ String f73933b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ String f73934c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ zzjd f73935d;

    zzik(zzjd zzjdVar, String str, String str2, String str3) {
        this.f73932a = str;
        this.f73933b = str2;
        this.f73934c = str3;
        Objects.requireNonNull(zzjdVar);
        this.f73935d = zzjdVar;
    }

    @Override // java.util.concurrent.Callable
    public final /* bridge */ /* synthetic */ Object call() {
        zzjd zzjdVar = this.f73935d;
        zzjdVar.n5().E();
        return zzjdVar.n5().F0().D0(this.f73932a, this.f73933b, this.f73934c);
    }
}
