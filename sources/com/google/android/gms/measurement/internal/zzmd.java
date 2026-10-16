package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzmd implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ AtomicReference f74226a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ zzr f74227b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ boolean f74228c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ zznl f74229d;

    zzmd(zznl zznlVar, AtomicReference atomicReference, zzr zzrVar, boolean z2) {
        this.f74226a = atomicReference;
        this.f74227b = zzrVar;
        this.f74228c = z2;
        Objects.requireNonNull(zznlVar);
        this.f74229d = zznlVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        AtomicReference atomicReference;
        zznl zznlVar;
        zzgb zzgbVarN;
        AtomicReference atomicReference2 = this.f74226a;
        synchronized (atomicReference2) {
            try {
                try {
                    zznlVar = this.f74229d;
                    zzgbVarN = zznlVar.N();
                } catch (RemoteException e3) {
                    this.f74229d.f73997a.a().o().b("Failed to get all user properties; remote exception", e3);
                    atomicReference = this.f74226a;
                }
                if (zzgbVarN == null) {
                    zznlVar.f73997a.a().o().a("Failed to get all user properties; not connected to service");
                    atomicReference2.notify();
                    return;
                }
                zzr zzrVar = this.f74227b;
                Preconditions.m(zzrVar);
                atomicReference2.set(zzgbVarN.h2(zzrVar, this.f74228c));
                zznlVar.J();
                atomicReference = this.f74226a;
                atomicReference.notify();
            } catch (Throwable th) {
                this.f74226a.notify();
                throw th;
            }
        }
    }
}
