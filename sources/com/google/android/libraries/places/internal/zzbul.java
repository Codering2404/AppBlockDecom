package com.google.android.libraries.places.internal;

import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzbul implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ zzbvr f76913a;

    zzbul(zzbvr zzbvrVar) {
        Objects.requireNonNull(zzbvrVar);
        this.f76913a = zzbvrVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzbvr zzbvrVar = this.f76913a;
        zzbvrVar.D().a(2, "Entering SHUTDOWN state");
        zzbvrVar.i().a(zzbjn.SHUTDOWN);
    }
}
