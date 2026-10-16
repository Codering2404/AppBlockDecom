package com.google.android.gms.measurement.internal;

import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zza implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ String f73365a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ long f73366b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ zzd f73367c;

    zza(zzd zzdVar, String str, long j3) {
        this.f73365a = str;
        this.f73366b = j3;
        Objects.requireNonNull(zzdVar);
        this.f73367c = zzdVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f73367c.l(this.f73365a, this.f73366b);
    }
}
