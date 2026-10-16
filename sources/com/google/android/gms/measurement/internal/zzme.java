package com.google.android.gms.measurement.internal;

import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzme extends zzgd {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ AtomicReference f74230a;

    zzme(zznl zznlVar, AtomicReference atomicReference) {
        this.f74230a = atomicReference;
        Objects.requireNonNull(zznlVar);
    }

    @Override // com.google.android.gms.measurement.internal.zzge
    public final void zze(List list) {
        AtomicReference atomicReference = this.f74230a;
        synchronized (atomicReference) {
            atomicReference.set(list);
            atomicReference.notifyAll();
        }
    }
}
