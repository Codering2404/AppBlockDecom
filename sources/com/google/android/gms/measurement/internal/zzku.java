package com.google.android.gms.measurement.internal;

import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzku implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ zzjl f74103a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ long f74104b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ boolean f74105c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ zzlj f74106d;

    zzku(zzlj zzljVar, zzjl zzjlVar, long j3, boolean z2) {
        this.f74103a = zzjlVar;
        this.f74104b = j3;
        this.f74105c = z2;
        Objects.requireNonNull(zzljVar);
        this.f74106d = zzljVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzlj zzljVar = this.f74106d;
        zzjl zzjlVar = this.f74103a;
        zzljVar.o(zzjlVar);
        zzljVar.X(zzjlVar, this.f74104b, true, this.f74105c);
    }
}
