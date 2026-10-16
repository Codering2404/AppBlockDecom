package com.google.android.libraries.places.internal;

import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzbro implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ zzcac f76724a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ zzbrs f76725b;

    zzbro(zzbrs zzbrsVar, zzcac zzcacVar) {
        this.f76724a = zzcacVar;
        Objects.requireNonNull(zzbrsVar);
        this.f76725b = zzbrsVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f76725b.e().c(this.f76724a);
    }
}
