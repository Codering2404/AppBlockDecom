package com.google.android.gms.measurement.internal;

import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzih implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ zzah f73923a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ zzr f73924b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ zzjd f73925c;

    zzih(zzjd zzjdVar, zzah zzahVar, zzr zzrVar) {
        this.f73923a = zzahVar;
        this.f73924b = zzrVar;
        Objects.requireNonNull(zzjdVar);
        this.f73925c = zzjdVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzjd zzjdVar = this.f73925c;
        zzjdVar.n5().E();
        zzah zzahVar = this.f73923a;
        if (zzahVar.f73388c.zza() == null) {
            zzjdVar.n5().m0(zzahVar, this.f73924b);
        } else {
            zzjdVar.n5().k0(zzahVar, this.f73924b);
        }
    }
}
