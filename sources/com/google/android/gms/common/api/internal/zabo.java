package com.google.android.gms.common.api.internal;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
final class zabo implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ zabp f71749a;

    zabo(zabp zabpVar) {
        this.f71749a = zabpVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zabq zabqVar = this.f71749a.f71750a;
        zabqVar.f71752b.disconnect(zabqVar.f71752b.getClass().getName().concat(" disconnecting because it was signed out."));
    }
}
