package com.google.android.gms.measurement.internal;

import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzha implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ boolean f73781a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ zzhb f73782b;

    zzha(zzhb zzhbVar, boolean z2) {
        this.f73781a = z2;
        Objects.requireNonNull(zzhbVar);
        this.f73782b = zzhbVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f73782b.c().s0(this.f73781a);
    }
}
