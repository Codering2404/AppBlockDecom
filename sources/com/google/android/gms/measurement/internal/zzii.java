package com.google.android.gms.measurement.internal;

import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzii implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ zzah f73926a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ zzjd f73927b;

    zzii(zzjd zzjdVar, zzah zzahVar) {
        this.f73926a = zzahVar;
        Objects.requireNonNull(zzjdVar);
        this.f73927b = zzjdVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzjd zzjdVar = this.f73927b;
        zzjdVar.n5().E();
        zzah zzahVar = this.f73926a;
        if (zzahVar.f73388c.zza() == null) {
            zzjdVar.n5().l0(zzahVar);
        } else {
            zzjdVar.n5().j0(zzahVar);
        }
    }
}
