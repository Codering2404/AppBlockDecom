package com.google.android.gms.measurement.internal;

import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzlz implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ zzlu f74202a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ long f74203b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ zzmb f74204c;

    zzlz(zzmb zzmbVar, zzlu zzluVar, long j3) {
        this.f74202a = zzluVar;
        this.f74203b = j3;
        Objects.requireNonNull(zzmbVar);
        this.f74204c = zzmbVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzmb zzmbVar = this.f74204c;
        zzmbVar.C(this.f74202a, false, this.f74203b);
        zzmbVar.f74212e = null;
        zzmbVar.f73997a.J().u(null);
    }
}
