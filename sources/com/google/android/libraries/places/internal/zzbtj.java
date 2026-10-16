package com.google.android.libraries.places.internal;

import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzbtj implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ zzbua f76852a;

    zzbtj(zzbua zzbuaVar) {
        Objects.requireNonNull(zzbuaVar);
        this.f76852a = zzbuaVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzbua zzbuaVar = this.f76852a;
        if (zzbuaVar.i().c() == zzbjn.IDLE) {
            zzbuaVar.D().a(2, "CONNECTING as requested");
            zzbuaVar.w(zzbjn.CONNECTING);
            zzbuaVar.u();
        }
    }
}
