package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;
import java.util.ArrayList;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzmw implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ String f74279a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ String f74280b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ zzr f74281c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ com.google.android.gms.internal.measurement.zzcu f74282d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ zznl f74283f;

    zzmw(zznl zznlVar, String str, String str2, zzr zzrVar, com.google.android.gms.internal.measurement.zzcu zzcuVar) {
        this.f74279a = str;
        this.f74280b = str2;
        this.f74281c = zzrVar;
        this.f74282d = zzcuVar;
        Objects.requireNonNull(zznlVar);
        this.f74283f = zznlVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.google.android.gms.internal.measurement.zzcu zzcuVar;
        zzpp zzppVarC;
        zznl zznlVar;
        zzgb zzgbVarN;
        ArrayList arrayList = new ArrayList();
        try {
            try {
                zznlVar = this.f74283f;
                zzgbVarN = zznlVar.N();
            } catch (RemoteException e3) {
                this.f74283f.f73997a.a().o().d("Failed to get conditional properties; remote exception", this.f74279a, this.f74280b, e3);
            }
            if (zzgbVarN == null) {
                zzic zzicVar = zznlVar.f73997a;
                zzicVar.a().o().c("Failed to get conditional properties; not connected to service", this.f74279a, this.f74280b);
                zzppVarC = zzicVar.C();
                zzcuVar = this.f74282d;
                zzppVarC.g0(zzcuVar, arrayList);
            }
            zzr zzrVar = this.f74281c;
            Preconditions.m(zzrVar);
            arrayList = zzpp.h0(zzgbVarN.S4(this.f74279a, this.f74280b, zzrVar));
            zznlVar.J();
            zznl zznlVar2 = this.f74283f;
            zzcuVar = this.f74282d;
            zzppVarC = zznlVar2.f73997a.C();
            zzppVarC.g0(zzcuVar, arrayList);
        } catch (Throwable th) {
            zznl zznlVar3 = this.f74283f;
            zznlVar3.f73997a.C().g0(this.f74282d, arrayList);
            throw th;
        }
    }
}
