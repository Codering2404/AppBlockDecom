package com.google.android.gms.measurement.internal;

import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzl implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ zzp f74120a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ AppMeasurementDynamiteService f74121b;

    zzl(AppMeasurementDynamiteService appMeasurementDynamiteService, zzp zzpVar) {
        this.f74120a = zzpVar;
        Objects.requireNonNull(appMeasurementDynamiteService);
        this.f74121b = appMeasurementDynamiteService;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f74121b.f73363a.B().I(this.f74120a);
    }
}
