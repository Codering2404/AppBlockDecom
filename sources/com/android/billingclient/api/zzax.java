package com.android.billingclient.api;

import java.util.concurrent.Callable;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class zzax implements Callable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ BillingClientImpl f57432a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ AlternativeBillingOnlyAvailabilityListener f57433b;

    @Override // java.util.concurrent.Callable
    public final Object call() {
        BillingClientImpl.w(this.f57432a, this.f57433b);
        return null;
    }
}
