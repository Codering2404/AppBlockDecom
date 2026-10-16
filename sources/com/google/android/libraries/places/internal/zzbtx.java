package com.google.android.libraries.places.internal;

import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzbtx implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ zzbty f76876a;

    zzbtx(zzbty zzbtyVar) {
        Objects.requireNonNull(zzbtyVar);
        this.f76876a = zzbtyVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzbty zzbtyVar = this.f76876a;
        zzbua zzbuaVar = zzbtyVar.f76879c;
        zzbuaVar.N().remove(zzbtyVar.f76877a);
        if (zzbuaVar.i().c() == zzbjn.SHUTDOWN && zzbuaVar.N().isEmpty()) {
            zzbuaVar.x();
        }
    }
}
