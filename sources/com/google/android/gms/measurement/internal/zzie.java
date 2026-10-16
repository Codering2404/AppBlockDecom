package com.google.android.gms.measurement.internal;

import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzie implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ zzr f73914a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ zzjd f73915b;

    zzie(zzjd zzjdVar, zzr zzrVar) {
        this.f73914a = zzrVar;
        Objects.requireNonNull(zzjdVar);
        this.f73915b = zzjdVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzjd zzjdVar = this.f73915b;
        zzjdVar.n5().E();
        zzjdVar.n5().h0(this.f73914a);
    }
}
