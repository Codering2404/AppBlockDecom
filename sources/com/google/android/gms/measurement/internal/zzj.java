package com.google.android.gms.measurement.internal;

import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzj implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ com.google.android.gms.internal.measurement.zzcu f73981a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ zzbg f73982b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ String f73983c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ AppMeasurementDynamiteService f73984d;

    zzj(AppMeasurementDynamiteService appMeasurementDynamiteService, com.google.android.gms.internal.measurement.zzcu zzcuVar, zzbg zzbgVar, String str) {
        this.f73981a = zzcuVar;
        this.f73982b = zzbgVar;
        this.f73983c = str;
        Objects.requireNonNull(appMeasurementDynamiteService);
        this.f73984d = appMeasurementDynamiteService;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f73984d.f73363a.J().B(this.f73981a, this.f73982b, this.f73983c);
    }
}
