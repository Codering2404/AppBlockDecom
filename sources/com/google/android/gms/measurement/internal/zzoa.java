package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzoa {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected long f74362a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected long f74363b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final zzay f74364c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ zzoc f74365d;

    public zzoa(zzoc zzocVar) {
        Objects.requireNonNull(zzocVar);
        this.f74365d = zzocVar;
        this.f74364c = new zznz(this, zzocVar.f73997a);
        long jA = zzocVar.f73997a.e().a();
        this.f74362a = jA;
        this.f74363b = jA;
    }

    final void a(long j3) {
        this.f74365d.h();
        this.f74364c.d();
        this.f74362a = j3;
        this.f74363b = j3;
    }

    final void b(long j3) {
        this.f74364c.d();
    }

    final void c() {
        this.f74364c.d();
        long jA = this.f74365d.f73997a.e().a();
        this.f74362a = jA;
        this.f74363b = jA;
    }

    public final boolean d(boolean z2, boolean z3, long j3) {
        zzoc zzocVar = this.f74365d;
        zzocVar.h();
        zzocVar.j();
        if (zzocVar.f73997a.g()) {
            zzic zzicVar = zzocVar.f73997a;
            zzicVar.x().f73823q.b(zzicVar.e().currentTimeMillis());
        }
        long j4 = j3 - this.f74362a;
        if (!z2 && j4 < 1000) {
            zzocVar.f73997a.a().w().b("Screen exposed for less than 1000 ms. Event not sent. time", Long.valueOf(j4));
            return false;
        }
        if (!z3) {
            j4 = j3 - this.f74363b;
            this.f74363b = j3;
        }
        zzic zzicVar2 = zzocVar.f73997a;
        zzicVar2.a().w().b("Recording user engagement, ms", Long.valueOf(j4));
        Bundle bundle = new Bundle();
        bundle.putLong("_et", j4);
        boolean z4 = !zzicVar2.w().N();
        zzic zzicVar3 = zzocVar.f73997a;
        zzpp.k0(zzicVar3.I().q(z4), bundle, true);
        if (!z3) {
            zzicVar3.B().t("auto", "_e", bundle);
        }
        this.f74362a = j3;
        zzay zzayVar = this.f74364c;
        zzayVar.d();
        zzayVar.b(((Long) zzfy.f73666r0.b(null)).longValue());
        return true;
    }
}
