package com.google.android.gms.measurement.internal;

import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzn implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ com.google.android.gms.internal.measurement.zzcu f74294a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ AppMeasurementDynamiteService f74295b;

    zzn(AppMeasurementDynamiteService appMeasurementDynamiteService, com.google.android.gms.internal.measurement.zzcu zzcuVar) {
        this.f74294a = zzcuVar;
        Objects.requireNonNull(appMeasurementDynamiteService);
        this.f74295b = appMeasurementDynamiteService;
    }

    @Override // java.lang.Runnable
    public final void run() {
        AppMeasurementDynamiteService appMeasurementDynamiteService = this.f74295b;
        appMeasurementDynamiteService.f73363a.C().e0(this.f74294a, appMeasurementDynamiteService.f73363a.f());
    }
}
