package com.google.android.libraries.places.internal;

import com.google.android.gms.common.api.Api;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzcbm implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ zzcbp f77415a;

    zzcbm(zzcbp zzcbpVar) {
        Objects.requireNonNull(zzcbpVar);
        this.f77415a = zzcbpVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzcbp zzcbpVar = this.f77415a;
        zzcbpVar.n().execute(zzcbpVar.q());
        synchronized (zzcbpVar.l()) {
            zzcbpVar.B(Api.BaseClientBuilder.API_PRIORITY_OTHER);
            zzcbpVar.X();
        }
    }
}
