package com.google.android.libraries.places.internal;

import java.util.Objects;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzbyq implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ zzbzd f77213a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ zzbyr f77214b;

    zzbyq(zzbyr zzbyrVar, zzbzd zzbzdVar) {
        this.f77213a = zzbzdVar;
        Objects.requireNonNull(zzbyrVar);
        this.f77214b = zzbyrVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzbyp zzbypVar;
        boolean z2;
        zzbyr zzbyrVar = this.f77214b;
        zzbzf zzbzfVar = zzbyrVar.f77216b;
        synchronized (zzbzfVar.r()) {
            try {
                zzbypVar = null;
                if (zzbyrVar.f77215a.f77212c) {
                    z2 = true;
                } else {
                    zzbzfVar.y(zzbzfVar.x().c(this.f77213a));
                    if (zzbzfVar.d0(zzbzfVar.x()) && (zzbzfVar.v() == null || zzbzfVar.v().a())) {
                        zzbypVar = new zzbyp(zzbzfVar.r());
                        zzbzfVar.H(zzbypVar);
                    } else {
                        zzbzfVar.y(zzbzfVar.x().b());
                        zzbzfVar.H(null);
                    }
                    z2 = false;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (z2) {
            zzbzd zzbzdVar = this.f77213a;
            zzbzdVar.f77244a.a(new zzbzc(this.f77214b.f77216b, zzbzdVar));
            zzbzdVar.f77244a.c(zzbnp.f76489f.e("Unneeded hedging"));
            return;
        }
        if (zzbypVar != null) {
            zzbzf zzbzfVar2 = this.f77214b.f77216b;
            zzbypVar.a(zzbzfVar2.n().schedule(new zzbyr(zzbzfVar2, zzbypVar), zzbzfVar2.p().f76839b, TimeUnit.NANOSECONDS));
        }
        this.f77214b.f77216b.b0(this.f77213a);
    }
}
