package com.google.android.gms.measurement.internal;

import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzig implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ String f73918a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ String f73919b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ String f73920c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ long f73921d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ zzjd f73922f;

    zzig(zzjd zzjdVar, String str, String str2, String str3, long j3) {
        this.f73918a = str;
        this.f73919b = str2;
        this.f73920c = str3;
        this.f73921d = j3;
        Objects.requireNonNull(zzjdVar);
        this.f73922f = zzjdVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        String str = this.f73918a;
        if (str == null) {
            zzjd zzjdVar = this.f73922f;
            zzjdVar.n5().t0(this.f73919b, null);
        } else {
            zzlu zzluVar = new zzlu(this.f73920c, str, this.f73921d);
            zzjd zzjdVar2 = this.f73922f;
            zzjdVar2.n5().t0(this.f73919b, zzluVar);
        }
    }
}
