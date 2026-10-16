package com.google.android.gms.measurement.internal;

import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzkd implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ String f74062a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ String f74063b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ Object f74064c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ long f74065d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ zzlj f74066f;

    zzkd(zzlj zzljVar, String str, String str2, Object obj, long j3) {
        this.f74062a = str;
        this.f74063b = str2;
        this.f74064c = obj;
        this.f74065d = j3;
        Objects.requireNonNull(zzljVar);
        this.f74066f = zzljVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f74066f.B(this.f74062a, this.f74063b, this.f74064c, this.f74065d);
    }
}
