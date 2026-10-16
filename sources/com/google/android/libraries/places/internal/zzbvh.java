package com.google.android.libraries.places.internal;

import java.util.LinkedHashSet;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzbvh implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ zzbvk f76944a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ zzbvl f76945b;

    zzbvh(zzbvl zzbvlVar, zzbvk zzbvkVar) {
        this.f76944a = zzbvkVar;
        Objects.requireNonNull(zzbvlVar);
        this.f76945b = zzbvlVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzbvl zzbvlVar = this.f76945b;
        if (zzbvlVar.j().get() != zzbvr.f76981j0) {
            this.f76944a.p();
            return;
        }
        zzbvr zzbvrVar = zzbvlVar.f76957d;
        if (zzbvrVar.p() == null) {
            zzbvrVar.q(new LinkedHashSet());
            zzbvrVar.Y.a(zzbvrVar.r(), true);
        }
        zzbvrVar.p().add(this.f76944a);
    }
}
