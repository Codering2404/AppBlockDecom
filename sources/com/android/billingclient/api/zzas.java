package com.android.billingclient.api;

import android.app.Activity;
import android.os.RemoteException;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class zzas implements Callable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ BillingClientImpl f57420a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ LaunchExternalLinkResponseListener f57421b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ LaunchExternalLinkParams f57422c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Activity f57423d;

    @Override // java.util.concurrent.Callable
    public final Object call() throws RemoteException {
        BillingClientImpl.r(this.f57420a, this.f57421b, this.f57422c, this.f57423d);
        return null;
    }
}
