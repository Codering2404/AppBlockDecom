package com.google.android.gms.measurement.internal;

import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzis implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ zzbg f73955a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ String f73956b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ zzjd f73957c;

    zzis(zzjd zzjdVar, zzbg zzbgVar, String str) {
        this.f73955a = zzbgVar;
        this.f73956b = str;
        Objects.requireNonNull(zzjdVar);
        this.f73957c = zzjdVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzjd zzjdVar = this.f73957c;
        zzjdVar.n5().E();
        zzjdVar.n5().i(this.f73955a, this.f73956b);
    }
}
