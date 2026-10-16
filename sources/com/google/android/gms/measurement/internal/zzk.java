package com.google.android.gms.measurement.internal;

import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzk implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ com.google.android.gms.internal.measurement.zzcu f74045a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ String f74046b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ String f74047c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ boolean f74048d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ AppMeasurementDynamiteService f74049f;

    zzk(AppMeasurementDynamiteService appMeasurementDynamiteService, com.google.android.gms.internal.measurement.zzcu zzcuVar, String str, String str2, boolean z2) {
        this.f74045a = zzcuVar;
        this.f74046b = str;
        this.f74047c = str2;
        this.f74048d = z2;
        Objects.requireNonNull(appMeasurementDynamiteService);
        this.f74049f = appMeasurementDynamiteService;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f74049f.f73363a.J().h0(this.f74045a, this.f74046b, this.f74047c, this.f74048d);
    }
}
