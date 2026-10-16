package com.google.android.libraries.places.internal;

import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzbvi implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Runnable f76946a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ zzbvk f76947b;

    zzbvi(zzbvk zzbvkVar, Runnable runnable) {
        this.f76946a = runnable;
        Objects.requireNonNull(zzbvkVar);
        this.f76947b = zzbvkVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f76946a.run();
        zzbvk zzbvkVar = this.f76947b;
        zzbvj zzbvjVar = new zzbvj(zzbvkVar);
        zzbnx zzbnxVar = zzbvkVar.f76953o.f76957d.f77001n;
        zzbnxVar.a(zzbvjVar);
        zzbnxVar.zza();
    }
}
