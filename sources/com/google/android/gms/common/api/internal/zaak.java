package com.google.android.gms.common.api.internal;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
final class zaak implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ zaaw f71653a;

    zaak(zaaw zaawVar) {
        this.f71653a = zaawVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zaaw zaawVar = this.f71653a;
        zaawVar.f71672d.a(zaawVar.f71671c);
    }
}
