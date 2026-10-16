package com.google.android.libraries.places.internal;

import com.google.common.base.Preconditions;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzbtv implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ zzbty f76873a;

    zzbtv(zzbty zzbtyVar) {
        Objects.requireNonNull(zzbtyVar);
        this.f76873a = zzbtyVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzbty zzbtyVar = this.f76873a;
        zzbua zzbuaVar = zzbtyVar.f76879c;
        zzbuaVar.o(null);
        if (zzbuaVar.j() != null) {
            Preconditions.A(zzbuaVar.g() == null, "Unexpected non-null activeTransport");
            zzbtyVar.f76877a.a(zzbuaVar.j());
            return;
        }
        zzbqa zzbqaVar = zzbtyVar.f76877a;
        if (zzbuaVar.d() == zzbqaVar) {
            zzbuaVar.h(zzbqaVar);
            zzbuaVar.f(null);
            zzbuaVar.l(zzbuaVar.G().f());
            zzbuaVar.w(zzbjn.READY);
            zzbuaVar.m().a(zzbuaVar.n(), zzbty.d(zzbuaVar.G().f(), zzbmy.f76451a), zzbty.d(zzbuaVar.G().f(), zzbka.f76311e), zzbty.c((zzbni) zzbuaVar.G().f().a(zzbsr.f76800a)));
        }
    }
}
