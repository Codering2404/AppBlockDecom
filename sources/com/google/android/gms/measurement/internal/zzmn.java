package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzmn implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ zzlu f74250a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ zznl f74251b;

    zzmn(zznl zznlVar, zzlu zzluVar) {
        this.f74250a = zzluVar;
        Objects.requireNonNull(zznlVar);
        this.f74251b = zznlVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zznl zznlVar = this.f74251b;
        zzgb zzgbVarN = zznlVar.N();
        if (zzgbVarN == null) {
            zznlVar.f73997a.a().o().a("Failed to send current screen to service");
            return;
        }
        try {
            zzlu zzluVar = this.f74250a;
            if (zzluVar == null) {
                zzgbVarN.M2(0L, null, null, zznlVar.f73997a.d().getPackageName());
            } else {
                zzgbVarN.M2(zzluVar.f74185c, zzluVar.f74183a, zzluVar.f74184b, zznlVar.f73997a.d().getPackageName());
            }
            zznlVar.J();
        } catch (RemoteException e3) {
            this.f74251b.f73997a.a().o().b("Failed to send current screen to the service", e3);
        }
    }
}
