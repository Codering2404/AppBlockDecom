package com.google.android.gms.measurement.internal;

import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zznu implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ long f74349a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ zzoc f74350b;

    zznu(zzoc zzocVar, long j3) {
        this.f74349a = j3;
        Objects.requireNonNull(zzocVar);
        this.f74350b = zzocVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f74350b.r(this.f74349a);
    }
}
