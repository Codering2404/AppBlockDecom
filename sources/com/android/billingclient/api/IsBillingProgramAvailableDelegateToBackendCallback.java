package com.android.billingclient.api;

import android.os.Bundle;
import android.os.Handler;
import com.google.android.gms.internal.play_billing.zzjd;
import java.util.concurrent.ExecutorService;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
final class IsBillingProgramAvailableDelegateToBackendCallback extends com.google.android.gms.internal.play_billing.zzab {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final BillingProgramAvailabilityListener f57253a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final int f57254b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final int f57255c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final Handler f57256d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final ExecutorService f57257f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final zzcz f57258g;

    IsBillingProgramAvailableDelegateToBackendCallback(BillingProgramAvailabilityListener billingProgramAvailabilityListener, int i3, zzcz zzczVar, int i4, Handler handler, ExecutorService executorService) {
        billingProgramAvailabilityListener.getClass();
        this.f57253a = billingProgramAvailabilityListener;
        this.f57254b = i3;
        this.f57258g = zzczVar;
        this.f57255c = i4;
        this.f57256d = handler;
        this.f57257f = executorService;
    }

    @Override // com.google.android.gms.internal.play_billing.zzac
    public void onDelegateToBackendResponse(Bundle bundle) {
        BillingProgramAvailabilityDetails billingProgramAvailabilityDetails = new BillingProgramAvailabilityDetails(this.f57254b);
        if (bundle == null) {
            zzcz zzczVar = this.f57258g;
            zzjd zzjdVar = zzjd.NULL_BUNDLE_FROM_DELEGATE_TO_BACKEND_SERVICE_CALL;
            BillingResult billingResult = zzdc.f57558h;
            zzde.a(zzjdVar, billingResult, zzczVar, zzdf.IS_BILLING_PROGRAM_AVAILABLE_ASYNC.b(), this.f57255c);
            this.f57253a.a(billingResult, billingProgramAvailabilityDetails);
            return;
        }
        zzdf zzdfVar = zzdf.IS_BILLING_PROGRAM_AVAILABLE_ASYNC;
        BillingResult billingResultA = zzdh.a(bundle, "IsBillingProgramAvailableDelegateToBackendCallback", zzdfVar.b(), this.f57258g, this.f57255c);
        BillingProgramAvailabilityListener billingProgramAvailabilityListener = this.f57253a;
        if (billingProgramAvailabilityListener != null) {
            billingProgramAvailabilityListener.a(billingResultA, billingProgramAvailabilityDetails);
        } else {
            zzde.a(zzjd.NULL_LISTENER_IN_DELEGATE_TO_BACKEND_CALLBACK, billingResultA, this.f57258g, zzdfVar.b(), this.f57255c);
        }
    }
}
