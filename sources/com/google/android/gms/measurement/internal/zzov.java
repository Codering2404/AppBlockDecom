package com.google.android.gms.measurement.internal;

import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzov implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ zzph f74403a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ zzpg f74404b;

    zzov(zzpg zzpgVar, zzph zzphVar) {
        this.f74403a = zzphVar;
        Objects.requireNonNull(zzpgVar);
        this.f74404b = zzpgVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzpg zzpgVar = this.f74404b;
        zzpgVar.u0(this.f74403a);
        zzpgVar.A0();
    }
}
