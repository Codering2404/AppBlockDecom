package com.google.android.gms.measurement.internal;

import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzmy implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ zzgb f74290a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ zznf f74291b;

    zzmy(zznf zznfVar, zzgb zzgbVar) {
        this.f74290a = zzgbVar;
        Objects.requireNonNull(zznfVar);
        this.f74291b = zznfVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zznf zznfVar = this.f74291b;
        synchronized (zznfVar) {
            try {
                zznfVar.d(false);
                zznl zznlVar = zznfVar.f74305c;
                if (!zznlVar.W()) {
                    zznlVar.f73997a.a().w().a("Connected to service");
                    zznlVar.z(this.f74290a);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
