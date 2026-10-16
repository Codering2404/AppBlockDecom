package com.google.android.libraries.places.internal;

import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzbvj implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ zzbvk f76948a;

    zzbvj(zzbvk zzbvkVar) {
        Objects.requireNonNull(zzbvkVar);
        this.f76948a = zzbvkVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzbvk zzbvkVar = this.f76948a;
        zzbvr zzbvrVar = zzbvkVar.f76953o.f76957d;
        if (zzbvrVar.p() != null) {
            zzbvrVar.p().remove(zzbvkVar);
            if (zzbvrVar.p().isEmpty()) {
                zzbvrVar.Y.a(zzbvrVar.r(), false);
                zzbvrVar.q(null);
                if (zzbvrVar.u().get()) {
                    zzbvrVar.t().a(zzbvr.f76978g0);
                }
            }
        }
    }
}
