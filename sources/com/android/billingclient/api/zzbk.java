package com.android.billingclient.api;

import java.util.concurrent.Callable;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class zzbk implements Callable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ BillingClientImpl f57465a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ExternalOfferAvailabilityListener f57466b;

    @Override // java.util.concurrent.Callable
    public final Object call() {
        BillingClientImpl.p(this.f57465a, this.f57466b);
        return null;
    }
}
