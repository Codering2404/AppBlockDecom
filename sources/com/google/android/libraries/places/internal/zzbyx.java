package com.google.android.libraries.places.internal;

import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzbyx implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ zzbyp f77233a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ zzbzd f77234b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ zzbzc f77235c;

    zzbyx(zzbzc zzbzcVar, zzbyp zzbypVar, zzbzd zzbzdVar) {
        this.f77233a = zzbypVar;
        this.f77234b = zzbzdVar;
        Objects.requireNonNull(zzbzcVar);
        this.f77235c = zzbzcVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzbyp zzbypVar = this.f77233a;
        synchronized (zzbypVar.f77210a) {
            if (zzbypVar.f77212c) {
                return;
            }
            zzbypVar.b();
            zzbzc zzbzcVar = this.f77235c;
            zzbzcVar.f77243b.l().execute(new zzbyw(this, this.f77234b));
        }
    }
}
