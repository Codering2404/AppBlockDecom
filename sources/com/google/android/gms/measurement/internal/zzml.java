package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzml implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ zzr f74247a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ zznl f74248b;

    zzml(zznl zznlVar, zzr zzrVar) {
        this.f74247a = zzrVar;
        Objects.requireNonNull(zznlVar);
        this.f74248b = zznlVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zznl zznlVar = this.f74248b;
        zzgb zzgbVarN = zznlVar.N();
        if (zzgbVarN == null) {
            zznlVar.f73997a.a().r().a("Failed to send app backgrounded");
            return;
        }
        try {
            zzr zzrVar = this.f74247a;
            Preconditions.m(zzrVar);
            zzgbVarN.E4(zzrVar);
            zznlVar.J();
        } catch (RemoteException e3) {
            this.f74248b.f73997a.a().o().b("Failed to send app backgrounded to the service", e3);
        }
    }
}
