package com.google.android.libraries.places.internal;

import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzbyz implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ zzbzd f77237a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ zzbzc f77238b;

    zzbyz(zzbzc zzbzcVar, zzbzd zzbzdVar) {
        this.f77237a = zzbzdVar;
        Objects.requireNonNull(zzbzcVar);
        this.f77238b = zzbzcVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f77238b.f77243b.b0(this.f77237a);
    }
}
