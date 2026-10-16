package com.google.android.gms.measurement.internal;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzke implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ AtomicReference f74067a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ zzlj f74068b;

    zzke(zzlj zzljVar, AtomicReference atomicReference) {
        this.f74067a = atomicReference;
        Objects.requireNonNull(zzljVar);
        this.f74068b = zzljVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        AtomicReference atomicReference = this.f74067a;
        synchronized (atomicReference) {
            try {
                try {
                    zzlj zzljVar = this.f74068b;
                    atomicReference.set(Boolean.valueOf(zzljVar.f73997a.w().H(zzljVar.f73997a.L().q(), zzfy.f73623b0)));
                } finally {
                    this.f74067a.notify();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
