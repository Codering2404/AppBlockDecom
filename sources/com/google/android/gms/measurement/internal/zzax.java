package com.google.android.gms.measurement.internal;

import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzax implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ zzjg f73447a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ zzay f73448b;

    zzax(zzay zzayVar, zzjg zzjgVar) {
        this.f73447a = zzjgVar;
        Objects.requireNonNull(zzayVar);
        this.f73448b = zzayVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzjg zzjgVar = this.f73447a;
        zzjgVar.c();
        if (zzae.a()) {
            zzjgVar.b().t(this);
            return;
        }
        zzay zzayVar = this.f73448b;
        boolean zC = zzayVar.c();
        zzayVar.e(0L);
        if (zC) {
            zzayVar.a();
        }
    }
}
