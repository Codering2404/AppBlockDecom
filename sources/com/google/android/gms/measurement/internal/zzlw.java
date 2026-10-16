package com.google.android.gms.measurement.internal;

import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzlw implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ zzlu f74194a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ zzlu f74195b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ long f74196c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ boolean f74197d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ zzmb f74198f;

    zzlw(zzmb zzmbVar, zzlu zzluVar, zzlu zzluVar2, long j3, boolean z2) {
        this.f74194a = zzluVar;
        this.f74195b = zzluVar2;
        this.f74196c = j3;
        this.f74197d = z2;
        Objects.requireNonNull(zzmbVar);
        this.f74198f = zzmbVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f74198f.B(this.f74194a, this.f74195b, this.f74196c, this.f74197d, null);
    }
}
