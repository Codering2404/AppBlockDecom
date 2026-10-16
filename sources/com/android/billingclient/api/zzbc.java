package com.android.billingclient.api;

import android.app.Activity;
import android.os.ResultReceiver;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class zzbc implements Callable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ BillingClientImpl f57444a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ExternalOfferInformationDialogListener f57445b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Activity f57446c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ ResultReceiver f57447d;

    @Override // java.util.concurrent.Callable
    public final Object call() {
        BillingClientImpl.t(this.f57444a, this.f57445b, this.f57446c, this.f57447d);
        return null;
    }
}
