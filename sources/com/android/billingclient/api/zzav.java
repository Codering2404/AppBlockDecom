package com.android.billingclient.api;

import com.google.android.gms.internal.play_billing.zzjd;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class zzav implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ BillingClientImpl f57428a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ AlternativeBillingOnlyReportingDetailsListener f57429b;

    @Override // java.lang.Runnable
    public final void run() {
        this.f57428a.h0(this.f57429b, zzdc.f57561k, zzjd.EXECUTE_ASYNC_TIMEOUT, null);
    }
}
