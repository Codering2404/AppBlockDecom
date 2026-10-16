package com.google.android.gms.measurement.internal;

import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzir implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ zzbg f73952a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ zzr f73953b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ zzjd f73954c;

    zzir(zzjd zzjdVar, zzbg zzbgVar, zzr zzrVar) {
        this.f73952a = zzbgVar;
        this.f73953b = zzrVar;
        Objects.requireNonNull(zzjdVar);
        this.f73954c = zzjdVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzbg zzbgVar = this.f73952a;
        zzr zzrVar = this.f73953b;
        zzjd zzjdVar = this.f73954c;
        zzjdVar.r5(zzjdVar.s5(zzbgVar, zzrVar), zzrVar);
    }
}
