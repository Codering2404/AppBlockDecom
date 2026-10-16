package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import java.util.Collections;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzmx implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ AtomicReference f74284a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ String f74285b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ String f74286c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ zzr f74287d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ boolean f74288f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final /* synthetic */ zznl f74289g;

    zzmx(zznl zznlVar, AtomicReference atomicReference, String str, String str2, String str3, zzr zzrVar, boolean z2) {
        this.f74284a = atomicReference;
        this.f74285b = str2;
        this.f74286c = str3;
        this.f74287d = zzrVar;
        this.f74288f = z2;
        Objects.requireNonNull(zznlVar);
        this.f74289g = zznlVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        AtomicReference atomicReference;
        zznl zznlVar;
        zzgb zzgbVarN;
        AtomicReference atomicReference2 = this.f74284a;
        synchronized (atomicReference2) {
            try {
                try {
                    zznlVar = this.f74289g;
                    zzgbVarN = zznlVar.N();
                } catch (RemoteException e3) {
                    this.f74289g.f73997a.a().o().d("(legacy) Failed to get user properties; remote exception", null, this.f74285b, e3);
                    this.f74284a.set(Collections.EMPTY_LIST);
                    atomicReference = this.f74284a;
                }
                if (zzgbVarN == null) {
                    zznlVar.f73997a.a().o().d("(legacy) Failed to get user properties; not connected to service", null, this.f74285b, this.f74286c);
                    atomicReference2.set(Collections.EMPTY_LIST);
                    atomicReference2.notify();
                    return;
                }
                if (TextUtils.isEmpty(null)) {
                    zzr zzrVar = this.f74287d;
                    Preconditions.m(zzrVar);
                    atomicReference2.set(zzgbVarN.K4(this.f74285b, this.f74286c, this.f74288f, zzrVar));
                } else {
                    atomicReference2.set(zzgbVarN.I(null, this.f74285b, this.f74286c, this.f74288f));
                }
                zznlVar.J();
                atomicReference = this.f74284a;
                atomicReference.notify();
            } catch (Throwable th) {
                this.f74284a.notify();
                throw th;
            }
        }
    }
}
