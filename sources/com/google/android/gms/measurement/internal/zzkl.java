package com.google.android.gms.measurement.internal;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzkl implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ AtomicReference f74083a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ String f74084b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ String f74085c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ boolean f74086d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ zzlj f74087f;

    zzkl(zzlj zzljVar, AtomicReference atomicReference, String str, String str2, String str3, boolean z2) {
        this.f74083a = atomicReference;
        this.f74084b = str2;
        this.f74085c = str3;
        this.f74086d = z2;
        Objects.requireNonNull(zzljVar);
        this.f74087f = zzljVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f74087f.f73997a.J().g0(this.f74083a, null, this.f74084b, this.f74085c, this.f74086d);
    }
}
