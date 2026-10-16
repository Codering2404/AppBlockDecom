package com.google.android.gms.common.api.internal;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
final class zacr implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ com.google.android.gms.signin.internal.zak f71804a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ zact f71805b;

    zacr(zact zactVar, com.google.android.gms.signin.internal.zak zakVar) {
        this.f71805b = zactVar;
        this.f71804a = zakVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zact.i5(this.f71805b, this.f71804a);
    }
}
