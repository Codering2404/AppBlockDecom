package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.ConnectionResult;
import java.util.Objects;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzne implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ ConnectionResult f74301a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ zznf f74302b;

    zzne(zznf zznfVar, ConnectionResult connectionResult) {
        this.f74301a = connectionResult;
        Objects.requireNonNull(zznfVar);
        this.f74302b = zznfVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zznl zznlVar = this.f74302b.f74305c;
        zznlVar.O(null);
        if (this.f74301a.N() != 7777) {
            zznlVar.L();
            return;
        }
        if (zznlVar.P() == null) {
            zznlVar.Q(Executors.newScheduledThreadPool(1));
        }
        zznlVar.P().schedule(new Runnable() { // from class: com.google.android.gms.measurement.internal.zznc
            @Override // java.lang.Runnable
            public final /* synthetic */ void run() {
                final zznl zznlVar2 = this.f74299a.f74302b.f74305c;
                zznlVar2.f73997a.b().t(new Runnable() { // from class: com.google.android.gms.measurement.internal.zznd
                    @Override // java.lang.Runnable
                    public final /* synthetic */ void run() {
                        zznlVar2.w();
                    }
                });
            }
        }, ((Long) zzfy.f73620a0.b(null)).longValue(), TimeUnit.MILLISECONDS);
    }
}
