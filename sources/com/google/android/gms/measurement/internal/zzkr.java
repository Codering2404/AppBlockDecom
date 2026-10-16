package com.google.android.gms.measurement.internal;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzkr implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ AtomicReference f74097a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ zzlj f74098b;

    zzkr(zzlj zzljVar, AtomicReference atomicReference) {
        this.f74097a = atomicReference;
        Objects.requireNonNull(zzljVar);
        this.f74098b = zzljVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        AtomicReference atomicReference = this.f74097a;
        synchronized (atomicReference) {
            try {
                try {
                    zzlj zzljVar = this.f74098b;
                    atomicReference.set(Double.valueOf(zzljVar.f73997a.w().G(zzljVar.f73997a.L().q(), zzfy.f73635f0)));
                } finally {
                    this.f74097a.notify();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
