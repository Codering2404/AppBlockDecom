package com.google.android.gms.measurement.internal;

import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzjy implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ boolean f74042a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ zzlj f74043b;

    zzjy(zzlj zzljVar, boolean z2) {
        this.f74042a = z2;
        Objects.requireNonNull(zzljVar);
        this.f74043b = zzljVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzlj zzljVar = this.f74043b;
        zzic zzicVar = zzljVar.f73997a;
        boolean zG = zzicVar.g();
        boolean zF = zzicVar.f();
        boolean z2 = this.f74042a;
        zzicVar.P(z2);
        if (zF == z2) {
            zzicVar.a().w().b("Default data collection state already set to", Boolean.valueOf(z2));
        }
        if (zzicVar.g() == zG || zzicVar.g() != zzicVar.f()) {
            zzicVar.a().t().c("Default data collection is different than actual status", Boolean.valueOf(z2), Boolean.valueOf(zG));
        }
        zzljVar.Y();
    }
}
