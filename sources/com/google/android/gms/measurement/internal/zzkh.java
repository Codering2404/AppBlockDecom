package com.google.android.gms.measurement.internal;

import android.text.TextUtils;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzkh implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ long f74073a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ zzlj f74074b;

    zzkh(zzlj zzljVar, long j3) {
        this.f74073a = j3;
        Objects.requireNonNull(zzljVar);
        this.f74074b = zzljVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzlj zzljVar = this.f74074b;
        zzljVar.h();
        zzljVar.j();
        zzic zzicVar = zzljVar.f73997a;
        zzicVar.a().v().a("Resetting analytics data (FE)");
        zzic zzicVar2 = zzljVar.f73997a;
        zzoc zzocVarZ = zzicVar2.z();
        zzocVarZ.h();
        zzocVarZ.f74370f.c();
        zzicVar2.L().p();
        boolean z2 = !zzljVar.f73997a.g();
        zzhh zzhhVarX = zzicVar.x();
        zzhhVarX.f73812f.b(this.f74073a);
        zzic zzicVar3 = zzhhVarX.f73997a;
        if (!TextUtils.isEmpty(zzicVar3.x().f73829w.a())) {
            zzhhVarX.f73829w.b(null);
        }
        zzhhVarX.f73823q.b(0L);
        zzhhVarX.f73824r.b(0L);
        if (!zzicVar3.w().L()) {
            zzhhVarX.y(z2);
        }
        zzhhVarX.f73830x.b(null);
        zzhhVarX.f73831y.b(0L);
        zzhhVarX.f73832z.b(null);
        zzicVar2.J().p();
        zzicVar2.z().f74369e.a();
        zzljVar.f74152s = z2;
        zzicVar2.J().q(new AtomicReference());
    }
}
