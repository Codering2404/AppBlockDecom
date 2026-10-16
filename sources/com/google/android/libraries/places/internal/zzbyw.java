package com.google.android.libraries.places.internal;

import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzbyw implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ zzbzd f77231a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ zzbyx f77232b;

    zzbyw(zzbyx zzbyxVar, zzbzd zzbzdVar) {
        this.f77231a = zzbzdVar;
        Objects.requireNonNull(zzbyxVar);
        this.f77232b = zzbyxVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f77232b.f77235c.f77243b.b0(this.f77231a);
    }
}
