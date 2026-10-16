package com.google.android.libraries.places.internal;

import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzbyv implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ zzbmg f77229a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ zzbzc f77230b;

    zzbyv(zzbzc zzbzcVar, zzbmg zzbmgVar) {
        this.f77229a = zzbmgVar;
        Objects.requireNonNull(zzbzcVar);
        this.f77230b = zzbzcVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f77230b.f77243b.F().a(this.f77229a);
    }
}
