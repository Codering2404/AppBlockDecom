package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzmo implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ zzr f74252a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ boolean f74253b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ zzbe f74254c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ Bundle f74255d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ zznl f74256f;

    zzmo(zznl zznlVar, boolean z2, zzr zzrVar, boolean z3, zzbe zzbeVar, Bundle bundle) {
        this.f74252a = zzrVar;
        this.f74253b = z3;
        this.f74254c = zzbeVar;
        this.f74255d = bundle;
        Objects.requireNonNull(zznlVar);
        this.f74256f = zznlVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zznl zznlVar = this.f74256f;
        zzgb zzgbVarN = zznlVar.N();
        if (zzgbVarN == null) {
            zznlVar.f73997a.a().o().a("Failed to send default event parameters to service");
            return;
        }
        if (zznlVar.f73997a.w().H(null, zzfy.f73627c1)) {
            zzr zzrVar = this.f74252a;
            Preconditions.m(zzrVar);
            this.f74256f.b0(zzgbVarN, this.f74253b ? null : this.f74254c, zzrVar);
            return;
        }
        try {
            zzr zzrVar2 = this.f74252a;
            Preconditions.m(zzrVar2);
            zzgbVarN.e4(this.f74255d, zzrVar2);
            zznlVar.J();
        } catch (RemoteException e3) {
            this.f74256f.f73997a.a().o().b("Failed to send default event parameters to service", e3);
        }
    }
}
