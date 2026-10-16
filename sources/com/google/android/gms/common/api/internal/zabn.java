package com.google.android.gms.common.api.internal;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
final class zabn implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ int f71747a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ zabq f71748b;

    zabn(zabq zabqVar, int i3) {
        this.f71748b = zabqVar;
        this.f71747a = i3;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f71748b.i(this.f71747a);
    }
}
