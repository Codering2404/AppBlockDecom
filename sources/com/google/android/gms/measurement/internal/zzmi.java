package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzmi implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ AtomicReference f74239a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ zzr f74240b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ zznl f74241c;

    zzmi(zznl zznlVar, AtomicReference atomicReference, zzr zzrVar) {
        this.f74239a = atomicReference;
        this.f74240b = zzrVar;
        Objects.requireNonNull(zznlVar);
        this.f74241c = zznlVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        AtomicReference atomicReference;
        zznl zznlVar;
        zzic zzicVar;
        AtomicReference atomicReference2 = this.f74239a;
        synchronized (atomicReference2) {
            try {
                try {
                    zznlVar = this.f74241c;
                    zzicVar = zznlVar.f73997a;
                } catch (RemoteException e3) {
                    this.f74241c.f73997a.a().o().b("Failed to get app instance id", e3);
                    atomicReference = this.f74239a;
                }
                if (zzicVar.x().w().o(zzjk.ANALYTICS_STORAGE)) {
                    zzgb zzgbVarN = zznlVar.N();
                    if (zzgbVarN != null) {
                        zzr zzrVar = this.f74240b;
                        Preconditions.m(zzrVar);
                        atomicReference2.set(zzgbVarN.W1(zzrVar));
                        String str = (String) atomicReference2.get();
                        if (str != null) {
                            zznlVar.f73997a.B().E(str);
                            zzicVar.x().f73814h.b(str);
                        }
                        zznlVar.J();
                        atomicReference = this.f74239a;
                        atomicReference.notify();
                        return;
                    }
                    zzicVar.a().o().a("Failed to get app instance id");
                } else {
                    zzicVar.a().t().a("Analytics storage consent denied; will not get app instance id");
                    zznlVar.f73997a.B().E(null);
                    zzicVar.x().f73814h.b(null);
                    atomicReference2.set(null);
                }
                atomicReference2.notify();
            } catch (Throwable th) {
                this.f74239a.notify();
                throw th;
            }
        }
    }
}
