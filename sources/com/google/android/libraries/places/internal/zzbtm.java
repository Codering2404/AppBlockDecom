package com.google.android.libraries.places.internal;

import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzbtm implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ zzbnp f76856a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ zzbua f76857b;

    zzbtm(zzbua zzbuaVar, zzbnp zzbnpVar) {
        this.f76856a = zzbnpVar;
        Objects.requireNonNull(zzbuaVar);
        this.f76857b = zzbuaVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzbua zzbuaVar = this.f76857b;
        zzbjn zzbjnVarC = zzbuaVar.i().c();
        zzbjn zzbjnVar = zzbjn.SHUTDOWN;
        if (zzbjnVarC == zzbjnVar) {
            return;
        }
        zzbnp zzbnpVar = this.f76856a;
        zzbuaVar.k(zzbnpVar);
        zzbwd zzbwdVarG = zzbuaVar.g();
        zzbuaVar.h(null);
        zzbuaVar.f(null);
        zzbuaVar.w(zzbjnVar);
        zzbuaVar.G().d();
        if (zzbuaVar.N().isEmpty()) {
            zzbuaVar.x();
        }
        zzbuaVar.z();
        if (zzbuaVar.J() != null) {
            zzbuaVar.J().a();
            zzbuaVar.L().a(zzbnpVar);
            zzbuaVar.K(null);
            zzbuaVar.M(null);
        }
        if (zzbwdVarG != null) {
            zzbwdVarG.a(zzbnpVar);
        }
        zzbqa zzbqaVarD = zzbuaVar.d();
        if (zzbqaVarD != null) {
            zzbqaVarD.a(zzbnpVar);
        }
    }
}
