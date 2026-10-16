package com.android.billingclient.api;

import android.os.RemoteException;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class zzao implements Callable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ BillingClientImpl f57411a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ BillingProgramReportingDetailsListener f57412b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ BillingProgramReportingDetailsParams f57413c;

    @Override // java.util.concurrent.Callable
    public final Object call() throws RemoteException {
        BillingClientImpl.v(this.f57411a, this.f57412b, this.f57413c);
        return null;
    }
}
