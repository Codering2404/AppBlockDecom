package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzmp implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ zzbg f74257a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ String f74258b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ com.google.android.gms.internal.measurement.zzcu f74259c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ zznl f74260d;

    zzmp(zznl zznlVar, zzbg zzbgVar, String str, com.google.android.gms.internal.measurement.zzcu zzcuVar) {
        this.f74257a = zzbgVar;
        this.f74258b = str;
        this.f74259c = zzcuVar;
        Objects.requireNonNull(zznlVar);
        this.f74260d = zznlVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.google.android.gms.internal.measurement.zzcu zzcuVar;
        zzpp zzppVarC;
        zznl zznlVar;
        zzgb zzgbVarN;
        byte[] bArrD1 = null;
        try {
            try {
                zznlVar = this.f74260d;
                zzgbVarN = zznlVar.N();
            } catch (RemoteException e3) {
                this.f74260d.f73997a.a().o().b("Failed to send event to the service to bundle", e3);
            }
            if (zzgbVarN == null) {
                zzic zzicVar = zznlVar.f73997a;
                zzicVar.a().o().a("Discarding data. Failed to send event to service to bundle");
                zzppVarC = zzicVar.C();
                zzcuVar = this.f74259c;
                zzppVarC.d0(zzcuVar, bArrD1);
            }
            bArrD1 = zzgbVarN.d1(this.f74257a, this.f74258b);
            zznlVar.J();
            zznl zznlVar2 = this.f74260d;
            zzcuVar = this.f74259c;
            zzppVarC = zznlVar2.f73997a.C();
            zzppVarC.d0(zzcuVar, bArrD1);
        } catch (Throwable th) {
            zznl zznlVar3 = this.f74260d;
            zznlVar3.f73997a.C().d0(this.f74259c, null);
            throw th;
        }
    }
}
