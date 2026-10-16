package com.google.android.gms.measurement.internal;

import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzm implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ com.google.android.gms.internal.measurement.zzcu f74205a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ String f74206b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ String f74207c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ AppMeasurementDynamiteService f74208d;

    zzm(AppMeasurementDynamiteService appMeasurementDynamiteService, com.google.android.gms.internal.measurement.zzcu zzcuVar, String str, String str2) {
        this.f74205a = zzcuVar;
        this.f74206b = str;
        this.f74207c = str2;
        Objects.requireNonNull(appMeasurementDynamiteService);
        this.f74208d = appMeasurementDynamiteService;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f74208d.f73363a.J().f0(this.f74205a, this.f74206b, this.f74207c);
    }
}
