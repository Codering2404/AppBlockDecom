package com.android.billingclient.api;

import android.app.Activity;
import android.os.ResultReceiver;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class zzah implements Callable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ BillingClientImpl f57392a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ AlternativeBillingOnlyInformationDialogListener f57393b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Activity f57394c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ ResultReceiver f57395d;

    @Override // java.util.concurrent.Callable
    public final Object call() {
        BillingClientImpl.o(this.f57392a, this.f57393b, this.f57394c, this.f57395d);
        return null;
    }
}
