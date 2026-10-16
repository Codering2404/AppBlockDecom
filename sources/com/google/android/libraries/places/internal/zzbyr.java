package com.google.android.libraries.places.internal;

import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzbyr implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final zzbyp f77215a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ zzbzf f77216b;

    zzbyr(zzbzf zzbzfVar, zzbyp zzbypVar) {
        Objects.requireNonNull(zzbzfVar);
        this.f77216b = zzbzfVar;
        this.f77215a = zzbypVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzbzf zzbzfVar = this.f77216b;
        zzbzd zzbzdVarA0 = zzbzfVar.a0(zzbzfVar.x().f77225e, false, true);
        if (zzbzdVarA0 == null) {
            return;
        }
        zzbzfVar.l().execute(new zzbyq(this, zzbzdVarA0));
    }
}
