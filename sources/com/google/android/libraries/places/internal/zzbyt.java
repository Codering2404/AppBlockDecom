package com.google.android.libraries.places.internal;

import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzbyt implements zzbym {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ zzbzf f77220a;

    zzbyt(zzbzf zzbzfVar) {
        Objects.requireNonNull(zzbzfVar);
        this.f77220a = zzbzfVar;
    }

    @Override // com.google.android.libraries.places.internal.zzbym
    public final void a(zzbzd zzbzdVar) {
        zzbzdVar.f77244a.a(new zzbzc(this.f77220a, zzbzdVar));
    }
}
