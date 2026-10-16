package com.google.android.gms.measurement.internal;

import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zznx implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final long f74354a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final long f74355b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ zzny f74356c;

    zznx(zzny zznyVar, long j3, long j4) {
        Objects.requireNonNull(zznyVar);
        this.f74356c = zznyVar;
        this.f74354a = j3;
        this.f74355b = j4;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f74356c.f74358b.f73997a.b().t(new Runnable() { // from class: com.google.android.gms.measurement.internal.zznw
            @Override // java.lang.Runnable
            public final /* synthetic */ void run() {
                zznx zznxVar = this.f74353a;
                zzoc zzocVar = zznxVar.f74356c.f74358b;
                zzocVar.h();
                zzic zzicVar = zzocVar.f73997a;
                zzicVar.a().v().a("Application going to the background");
                zzicVar.x().f73826t.b(true);
                zzocVar.o(true);
                if (!zzicVar.w().N()) {
                    long j3 = zznxVar.f74355b;
                    zzoa zzoaVar = zzocVar.f74370f;
                    zzoaVar.d(false, false, j3);
                    zzoaVar.b(j3);
                }
                zzicVar.a().u().b("Application backgrounded at: timestamp_millis", Long.valueOf(zznxVar.f74354a));
                zzic zzicVar2 = zzocVar.f73997a;
                zzlj zzljVarB = zzicVar2.B();
                zzljVarB.h();
                zzic zzicVar3 = zzljVarB.f73997a;
                zzljVarB.j();
                zznl zznlVarJ = zzicVar3.J();
                zznlVarJ.h();
                zznlVarJ.j();
                if (!zznlVarJ.y() || zznlVarJ.f73997a.C().W() >= 242600) {
                    zzicVar3.J().t();
                }
                if (zzicVar.w().H(null, zzfy.O0)) {
                    long jD = zzicVar.C().P(zzicVar.d().getPackageName(), zzicVar.w().R()) ? 1000L : zzicVar.w().D(zzicVar.d().getPackageName(), zzfy.E);
                    zzicVar.a().w().b("[sgtm] Scheduling batch upload with minimum latency in millis", Long.valueOf(jD));
                    zzicVar2.N().o(jD);
                }
            }
        });
    }
}
