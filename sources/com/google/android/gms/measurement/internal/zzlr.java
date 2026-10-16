package com.google.android.gms.measurement.internal;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public enum zzlr {
    UNKNOWN(0),
    SUCCESS(1),
    FAILURE(2),
    BACKOFF(3);


    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f74174a;

    zzlr(int i3) {
        this.f74174a = i3;
    }

    public final int zza() {
        return this.f74174a;
    }
}
