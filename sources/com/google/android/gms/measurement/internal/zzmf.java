package com.google.android.gms.measurement.internal;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzmf extends zzgg {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ AtomicReference f74231a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ zznl f74232b;

    zzmf(zznl zznlVar, AtomicReference atomicReference) {
        this.f74231a = atomicReference;
        Objects.requireNonNull(zznlVar);
        this.f74232b = zznlVar;
    }

    @Override // com.google.android.gms.measurement.internal.zzgh
    public final void v4(zzoq zzoqVar) {
        AtomicReference atomicReference = this.f74231a;
        synchronized (atomicReference) {
            this.f74232b.f73997a.a().w().b("[sgtm] Got upload batches from service. count", Integer.valueOf(zzoqVar.f74397a.size()));
            atomicReference.set(zzoqVar);
            atomicReference.notifyAll();
        }
    }
}
