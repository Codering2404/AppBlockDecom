package com.google.android.libraries.places.internal;

import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzbtk implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ zzbtl f76853a;

    zzbtk(zzbtl zzbtlVar) {
        Objects.requireNonNull(zzbtlVar);
        this.f76853a = zzbtlVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzbua zzbuaVar = this.f76853a.f76855b;
        zzbuaVar.K(null);
        zzbuaVar.M(null);
        zzbuaVar.L().a(zzbnp.f76496m.e("InternalSubchannel closed transport due to address change"));
    }
}
