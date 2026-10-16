package com.google.android.libraries.places.internal;

import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzbrq implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ zzbmg f76727a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ zzbrs f76728b;

    zzbrq(zzbrs zzbrsVar, zzbmg zzbmgVar) {
        this.f76727a = zzbmgVar;
        Objects.requireNonNull(zzbrsVar);
        this.f76728b = zzbrsVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f76728b.e().a(this.f76727a);
    }
}
