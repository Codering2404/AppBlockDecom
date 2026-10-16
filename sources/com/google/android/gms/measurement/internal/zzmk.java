package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzmk implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ zzr f74245a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ zznl f74246b;

    zzmk(zznl zznlVar, zzr zzrVar, boolean z2) {
        this.f74245a = zzrVar;
        Objects.requireNonNull(zznlVar);
        this.f74246b = zznlVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zznl zznlVar = this.f74246b;
        zzgb zzgbVarN = zznlVar.N();
        if (zzgbVarN == null) {
            zznlVar.f73997a.a().o().a("Discarding data. Failed to send app launch");
            return;
        }
        try {
            zzr zzrVar = this.f74245a;
            Preconditions.m(zzrVar);
            zzic zzicVar = zznlVar.f73997a;
            zzal zzalVarW = zzicVar.w();
            zzfx zzfxVar = zzfy.f73627c1;
            if (zzalVarW.H(null, zzfxVar)) {
                zznlVar.b0(zzgbVarN, null, zzrVar);
            }
            zzgbVarN.q4(zzrVar);
            zznlVar.f73997a.E().v();
            zzicVar.w().H(null, zzfxVar);
            zznlVar.b0(zzgbVarN, null, zzrVar);
            zznlVar.J();
        } catch (RemoteException e3) {
            this.f74246b.f73997a.a().o().b("Failed to send app launch to the service", e3);
        }
    }
}
