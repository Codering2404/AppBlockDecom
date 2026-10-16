package com.google.android.libraries.places.internal;

import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzbrf implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ zzbjy f76709a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ zzbrt f76710b;

    zzbrf(zzbrt zzbrtVar, zzbjy zzbjyVar) {
        this.f76709a = zzbjyVar;
        Objects.requireNonNull(zzbrtVar);
        this.f76710b = zzbrtVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f76710b.o().e(this.f76709a);
    }
}
