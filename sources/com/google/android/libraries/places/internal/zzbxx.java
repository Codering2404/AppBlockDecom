package com.google.android.libraries.places.internal;

import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzbxx implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ zzbxy f77185a;

    zzbxx(zzbxy zzbxyVar) {
        Objects.requireNonNull(zzbxyVar);
        this.f77185a = zzbxyVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzbzf zzbzfVar = this.f77185a.f77191g;
        zzbzfVar.L(true);
        zzbys zzbysVarC = zzbzfVar.C();
        zzbys zzbysVarC2 = zzbzfVar.C();
        zzbzfVar.F().b(zzbzfVar.C().a(), zzbysVarC2.b(), zzbysVarC.c());
    }
}
