package com.google.android.gms.measurement.internal;

import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzna implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ zzgb f74296a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ zznf f74297b;

    zzna(zznf zznfVar, zzgb zzgbVar) {
        this.f74296a = zzgbVar;
        Objects.requireNonNull(zznfVar);
        this.f74297b = zznfVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zznf zznfVar = this.f74297b;
        synchronized (zznfVar) {
            try {
                zznfVar.d(false);
                zznl zznlVar = zznfVar.f74305c;
                if (!zznlVar.W()) {
                    zznlVar.f73997a.a().v().a("Connected to remote service");
                    zznlVar.z(this.f74296a);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        zznl zznlVar2 = this.f74297b.f74305c;
        if (zznlVar2.P() != null) {
            zznlVar2.P().shutdownNow();
            zznlVar2.Q(null);
        }
    }
}
