package com.google.android.gms.measurement.internal;

import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzjz implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ zzlj f74044a;

    zzjz(zzlj zzljVar) {
        Objects.requireNonNull(zzljVar);
        this.f74044a = zzljVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f74044a.f74151r.a();
    }
}
