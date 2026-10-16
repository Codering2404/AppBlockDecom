package com.google.android.libraries.places.internal;

import java.net.SocketAddress;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzbtl implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ List f76854a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ zzbua f76855b;

    zzbtl(zzbua zzbuaVar, List list) {
        this.f76854a = list;
        Objects.requireNonNull(zzbuaVar);
        this.f76855b = zzbuaVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzbwd zzbwdVarG;
        zzbua zzbuaVar = this.f76855b;
        zzbtu zzbtuVarG = zzbuaVar.G();
        List list = this.f76854a;
        SocketAddress socketAddressE = zzbuaVar.G().e();
        zzbtuVarG.g(list);
        zzbuaVar.H(list);
        zzbjn zzbjnVarC = zzbuaVar.i().c();
        zzbjn zzbjnVar = zzbjn.READY;
        if ((zzbjnVarC != zzbjnVar && zzbuaVar.i().c() != zzbjn.CONNECTING) || zzbuaVar.G().h(socketAddressE)) {
            zzbwdVarG = null;
        } else if (zzbuaVar.i().c() == zzbjnVar) {
            zzbwdVarG = zzbuaVar.g();
            zzbuaVar.h(null);
            zzbuaVar.G().d();
            zzbuaVar.w(zzbjn.IDLE);
        } else {
            zzbuaVar.d().a(zzbnp.f76496m.e("InternalSubchannel closed pending transport due to address change"));
            zzbuaVar.f(null);
            zzbuaVar.G().d();
            zzbuaVar.u();
            zzbwdVarG = null;
        }
        if (zzbwdVarG != null) {
            if (zzbuaVar.J() != null) {
                zzbuaVar.L().a(zzbnp.f76496m.e("InternalSubchannel closed transport early due to address change"));
                zzbuaVar.J().a();
                zzbuaVar.K(null);
                zzbuaVar.M(null);
            }
            zzbuaVar.M(zzbwdVarG);
            zzbuaVar.K(zzbuaVar.F().c(new zzbtk(this), 5L, TimeUnit.SECONDS, zzbuaVar.B()));
        }
    }
}
