package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import java.util.Collections;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzmv implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ AtomicReference f74274a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ String f74275b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ String f74276c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ zzr f74277d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ zznl f74278f;

    zzmv(zznl zznlVar, AtomicReference atomicReference, String str, String str2, String str3, zzr zzrVar) {
        this.f74274a = atomicReference;
        this.f74275b = str2;
        this.f74276c = str3;
        this.f74277d = zzrVar;
        Objects.requireNonNull(zznlVar);
        this.f74278f = zznlVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        AtomicReference atomicReference;
        zznl zznlVar;
        zzgb zzgbVarN;
        AtomicReference atomicReference2 = this.f74274a;
        synchronized (atomicReference2) {
            try {
                try {
                    zznlVar = this.f74278f;
                    zzgbVarN = zznlVar.N();
                } catch (RemoteException e3) {
                    this.f74278f.f73997a.a().o().d("(legacy) Failed to get conditional properties; remote exception", null, this.f74275b, e3);
                    this.f74274a.set(Collections.EMPTY_LIST);
                    atomicReference = this.f74274a;
                }
                if (zzgbVarN == null) {
                    zznlVar.f73997a.a().o().d("(legacy) Failed to get conditional properties; not connected to service", null, this.f74275b, this.f74276c);
                    atomicReference2.set(Collections.EMPTY_LIST);
                    atomicReference2.notify();
                    return;
                }
                if (TextUtils.isEmpty(null)) {
                    zzr zzrVar = this.f74277d;
                    Preconditions.m(zzrVar);
                    atomicReference2.set(zzgbVarN.S4(this.f74275b, this.f74276c, zzrVar));
                } else {
                    atomicReference2.set(zzgbVarN.t0(null, this.f74275b, this.f74276c));
                }
                zznlVar.J();
                atomicReference = this.f74274a;
                atomicReference.notify();
            } catch (Throwable th) {
                this.f74274a.notify();
                throw th;
            }
        }
    }
}
