package com.google.android.gms.measurement.internal;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzkp implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ AtomicReference f74093a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ zzlj f74094b;

    zzkp(zzlj zzljVar, AtomicReference atomicReference) {
        this.f74093a = atomicReference;
        Objects.requireNonNull(zzljVar);
        this.f74094b = zzljVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        AtomicReference atomicReference = this.f74093a;
        synchronized (atomicReference) {
            try {
                try {
                    zzlj zzljVar = this.f74094b;
                    atomicReference.set(Long.valueOf(zzljVar.f73997a.w().D(zzljVar.f73997a.L().q(), zzfy.f73629d0)));
                } finally {
                    this.f74093a.notify();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
