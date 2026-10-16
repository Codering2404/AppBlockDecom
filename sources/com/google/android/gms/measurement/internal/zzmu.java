package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzmu implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ zzr f74270a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ boolean f74271b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ zzah f74272c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ zznl f74273d;

    zzmu(zznl zznlVar, boolean z2, zzr zzrVar, boolean z3, zzah zzahVar, zzah zzahVar2) {
        this.f74270a = zzrVar;
        this.f74271b = z3;
        this.f74272c = zzahVar;
        Objects.requireNonNull(zznlVar);
        this.f74273d = zznlVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zznl zznlVar = this.f74273d;
        zzgb zzgbVarN = zznlVar.N();
        if (zzgbVarN == null) {
            zznlVar.f73997a.a().o().a("Discarding data. Failed to send conditional user property to service");
            return;
        }
        zzr zzrVar = this.f74270a;
        Preconditions.m(zzrVar);
        zznlVar.b0(zzgbVarN, this.f74271b ? null : this.f74272c, zzrVar);
        zznlVar.J();
    }
}
