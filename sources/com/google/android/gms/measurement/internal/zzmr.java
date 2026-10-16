package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzmr implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ zzr f74262a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ zznl f74263b;

    zzmr(zznl zznlVar, zzr zzrVar) {
        this.f74262a = zzrVar;
        Objects.requireNonNull(zznlVar);
        this.f74263b = zznlVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zznl zznlVar = this.f74263b;
        zzgb zzgbVarN = zznlVar.N();
        if (zzgbVarN == null) {
            zznlVar.f73997a.a().o().a("Failed to send measurementEnabled to service");
            return;
        }
        try {
            zzr zzrVar = this.f74262a;
            Preconditions.m(zzrVar);
            zzgbVarN.X0(zzrVar);
            zznlVar.J();
        } catch (RemoteException e3) {
            this.f74263b.f73997a.a().o().b("Failed to send measurementEnabled to the service", e3);
        }
    }
}
