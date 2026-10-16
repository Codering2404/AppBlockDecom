package com.google.android.gms.common.api.internal;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
final class zas {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ BasePendingResult f71860a;

    /* synthetic */ zas(BasePendingResult basePendingResult, zar zarVar) {
        this.f71860a = basePendingResult;
    }

    protected final void finalize() throws Throwable {
        BasePendingResult.zal(this.f71860a.zaj);
        super.finalize();
    }
}
