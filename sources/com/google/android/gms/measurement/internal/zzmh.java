package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzmh implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ zzr f74237a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ zznl f74238b;

    zzmh(zznl zznlVar, zzr zzrVar) {
        this.f74237a = zzrVar;
        Objects.requireNonNull(zznlVar);
        this.f74238b = zznlVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zznl zznlVar = this.f74238b;
        zzgb zzgbVarN = zznlVar.N();
        if (zzgbVarN == null) {
            zznlVar.f73997a.a().o().a("Failed to reset data on the service: not connected to service");
            return;
        }
        try {
            zzr zzrVar = this.f74237a;
            Preconditions.m(zzrVar);
            zzgbVarN.O2(zzrVar);
        } catch (RemoteException e3) {
            this.f74238b.f73997a.a().o().b("Failed to reset data on the service: remote exception", e3);
        }
        this.f74238b.J();
    }
}
