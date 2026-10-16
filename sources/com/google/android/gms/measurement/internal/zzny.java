package com.google.android.gms.measurement.internal;

import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzny {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private zznx f74357a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ zzoc f74358b;

    zzny(zzoc zzocVar) {
        Objects.requireNonNull(zzocVar);
        this.f74358b = zzocVar;
    }

    final void a() {
        zzoc zzocVar = this.f74358b;
        zzocVar.h();
        zznx zznxVar = this.f74357a;
        if (zznxVar != null) {
            zzocVar.t().removeCallbacks(zznxVar);
        }
        zzic zzicVar = zzocVar.f73997a;
        zzicVar.x().f73826t.b(false);
        zzocVar.o(false);
        if (zzicVar.w().H(null, zzfy.U0)) {
            zzic zzicVar2 = zzocVar.f73997a;
            if (zzicVar2.B().v0()) {
                zzicVar.a().w().a("Retrying trigger URI registration in foreground");
                zzicVar2.B().x0();
            }
        }
    }

    final void b(long j3) {
        zzoc zzocVar = this.f74358b;
        this.f74357a = new zznx(this, zzocVar.f73997a.e().currentTimeMillis(), j3);
        zzocVar.t().postDelayed(this.f74357a, 2000L);
    }
}
