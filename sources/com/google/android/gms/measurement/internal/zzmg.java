package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzmg implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ zzr f74233a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ boolean f74234b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ zzpl f74235c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ zznl f74236d;

    zzmg(zznl zznlVar, zzr zzrVar, boolean z2, zzpl zzplVar) {
        this.f74233a = zzrVar;
        this.f74234b = z2;
        this.f74235c = zzplVar;
        Objects.requireNonNull(zznlVar);
        this.f74236d = zznlVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zznl zznlVar = this.f74236d;
        zzgb zzgbVarN = zznlVar.N();
        if (zzgbVarN == null) {
            zznlVar.f73997a.a().o().a("Discarding data. Failed to set user property");
            return;
        }
        zzr zzrVar = this.f74233a;
        Preconditions.m(zzrVar);
        zznlVar.b0(zzgbVarN, this.f74234b ? null : this.f74235c, zzrVar);
        zznlVar.J();
    }
}
