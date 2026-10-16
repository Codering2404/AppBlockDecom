package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzmt implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ zzr f74266a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ boolean f74267b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ zzbg f74268c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ zznl f74269d;

    zzmt(zznl zznlVar, boolean z2, zzr zzrVar, boolean z3, zzbg zzbgVar, String str) {
        this.f74266a = zzrVar;
        this.f74267b = z3;
        this.f74268c = zzbgVar;
        Objects.requireNonNull(zznlVar);
        this.f74269d = zznlVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zznl zznlVar = this.f74269d;
        zzgb zzgbVarN = zznlVar.N();
        if (zzgbVarN == null) {
            zznlVar.f73997a.a().o().a("Discarding data. Failed to send event to service");
            return;
        }
        zzr zzrVar = this.f74266a;
        Preconditions.m(zzrVar);
        zznlVar.b0(zzgbVarN, this.f74267b ? null : this.f74268c, zzrVar);
        zznlVar.J();
    }
}
