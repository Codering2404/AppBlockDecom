package com.google.android.libraries.places.internal;

import com.google.common.base.Preconditions;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzbtw implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ zzbnp f76874a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ zzbty f76875b;

    zzbtw(zzbty zzbtyVar, zzbnp zzbnpVar) {
        this.f76874a = zzbnpVar;
        Objects.requireNonNull(zzbtyVar);
        this.f76875b = zzbtyVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzbty zzbtyVar = this.f76875b;
        zzbua zzbuaVar = zzbtyVar.f76879c;
        if (zzbuaVar.i().c() == zzbjn.SHUTDOWN) {
            return;
        }
        zzbqa zzbqaVar = zzbtyVar.f76877a;
        if (zzbuaVar.g() == zzbqaVar) {
            zzbuaVar.h(null);
            zzbuaVar.G().d();
            zzbuaVar.w(zzbjn.IDLE);
            zzbuaVar.m().c(zzbuaVar.n(), zzbty.d(zzbuaVar.G().f(), zzbmy.f76451a), zzbty.d(zzbuaVar.G().f(), zzbka.f76311e), zzcae.UNKNOWN.a(null), zzbty.c((zzbni) zzbuaVar.G().f().a(zzbsr.f76800a)));
            return;
        }
        if (zzbuaVar.d() == zzbqaVar) {
            zzbuaVar.m().b(zzbuaVar.n(), zzbty.d(zzbuaVar.G().f(), zzbmy.f76451a), zzbty.d(zzbuaVar.G().f(), zzbka.f76311e));
            Preconditions.D(zzbuaVar.i().c() == zzbjn.CONNECTING, "Expected state is CONNECTING, actual state is %s", zzbuaVar.i().c());
            zzbuaVar.G().c();
            if (zzbuaVar.G().a()) {
                zzbuaVar.u();
                return;
            }
            zzbuaVar.f(null);
            zzbuaVar.G().d();
            zzbuaVar.v(this.f76874a);
        }
    }
}
