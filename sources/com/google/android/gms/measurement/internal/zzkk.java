package com.google.android.gms.measurement.internal;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzkk implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ AtomicReference f74079a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ String f74080b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ String f74081c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ zzlj f74082d;

    zzkk(zzlj zzljVar, AtomicReference atomicReference, String str, String str2, String str3) {
        this.f74079a = atomicReference;
        this.f74080b = str2;
        this.f74081c = str3;
        Objects.requireNonNull(zzljVar);
        this.f74082d = zzljVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f74082d.f73997a.J().e0(this.f74079a, null, this.f74080b, this.f74081c);
    }
}
