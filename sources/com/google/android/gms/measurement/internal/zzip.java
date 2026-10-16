package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzip implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ zzr f73948a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ zzjd f73949b;

    zzip(zzjd zzjdVar, zzr zzrVar) {
        this.f73948a = zzrVar;
        Objects.requireNonNull(zzjdVar);
        this.f73949b = zzjdVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzjd zzjdVar = this.f73949b;
        zzjdVar.n5().E();
        zzpg zzpgVarN5 = zzjdVar.n5();
        zzpgVarN5.b().h();
        zzpgVarN5.O0();
        zzr zzrVar = this.f73948a;
        Preconditions.g(zzrVar.f74500a);
        zzpgVarN5.P0(zzrVar);
        zzpgVarN5.Q0(zzrVar);
    }
}
