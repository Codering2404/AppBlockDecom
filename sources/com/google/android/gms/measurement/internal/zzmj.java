package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzmj implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ zzr f74242a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ com.google.android.gms.internal.measurement.zzcu f74243b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ zznl f74244c;

    zzmj(zznl zznlVar, zzr zzrVar, com.google.android.gms.internal.measurement.zzcu zzcuVar) {
        this.f74242a = zzrVar;
        this.f74243b = zzcuVar;
        Objects.requireNonNull(zznlVar);
        this.f74244c = zznlVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.google.android.gms.internal.measurement.zzcu zzcuVar;
        zzpp zzppVarC;
        zznl zznlVar;
        zzic zzicVar;
        String strW1 = null;
        try {
            try {
                zznlVar = this.f74244c;
                zzicVar = zznlVar.f73997a;
            } catch (RemoteException e3) {
                this.f74244c.f73997a.a().o().b("Failed to get app instance id", e3);
            }
            if (zzicVar.x().w().o(zzjk.ANALYTICS_STORAGE)) {
                zzgb zzgbVarN = zznlVar.N();
                if (zzgbVarN != null) {
                    zzr zzrVar = this.f74242a;
                    Preconditions.m(zzrVar);
                    strW1 = zzgbVarN.W1(zzrVar);
                    if (strW1 != null) {
                        zznlVar.f73997a.B().E(strW1);
                        zzicVar.x().f73814h.b(strW1);
                    }
                    zznlVar.J();
                    zznl zznlVar2 = this.f74244c;
                    zzcuVar = this.f74243b;
                    zzppVarC = zznlVar2.f73997a.C();
                    zzppVarC.a0(zzcuVar, strW1);
                }
                zzicVar.a().o().a("Failed to get app instance id");
            } else {
                zzicVar.a().t().a("Analytics storage consent denied; will not get app instance id");
                zznlVar.f73997a.B().E(null);
                zzicVar.x().f73814h.b(null);
            }
            zzppVarC = zzicVar.C();
            zzcuVar = this.f74243b;
            zzppVarC.a0(zzcuVar, strW1);
        } catch (Throwable th) {
            zznl zznlVar3 = this.f74244c;
            zznlVar3.f73997a.C().a0(this.f74243b, null);
            throw th;
        }
    }
}
