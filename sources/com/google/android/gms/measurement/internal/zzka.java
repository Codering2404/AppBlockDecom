package com.google.android.gms.measurement.internal;

import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzka implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ long f74050a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ zzlj f74051b;

    zzka(zzlj zzljVar, long j3) {
        this.f74050a = j3;
        Objects.requireNonNull(zzljVar);
        this.f74051b = zzljVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzic zzicVar = this.f74051b.f73997a;
        zzhe zzheVar = zzicVar.x().f73818l;
        long j3 = this.f74050a;
        zzheVar.b(j3);
        zzicVar.a().v().b("Session timeout duration set", Long.valueOf(j3));
    }
}
