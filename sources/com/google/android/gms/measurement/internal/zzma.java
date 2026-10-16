package com.google.android.gms.measurement.internal;

import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzma implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ zzmb f74209a;

    zzma(zzmb zzmbVar) {
        Objects.requireNonNull(zzmbVar);
        this.f74209a = zzmbVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f74209a.E(null);
    }
}
