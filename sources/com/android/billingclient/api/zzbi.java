package com.android.billingclient.api;

import java.util.concurrent.Future;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class zzbi implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Future f57461a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Runnable f57462b;

    @Override // java.lang.Runnable
    public final void run() {
        Future future = this.f57461a;
        if (future.isDone() || future.isCancelled()) {
            return;
        }
        Runnable runnable = this.f57462b;
        future.cancel(true);
        com.google.android.gms.internal.play_billing.zzc.zzo("BillingClient", "Async task is taking too long, cancel it!");
        runnable.run();
    }
}
