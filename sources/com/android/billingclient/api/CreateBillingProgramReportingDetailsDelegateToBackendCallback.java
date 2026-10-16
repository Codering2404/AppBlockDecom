package com.android.billingclient.api;

import android.os.Bundle;
import android.os.Handler;
import com.google.android.gms.internal.play_billing.zzjd;
import java.util.concurrent.ExecutorService;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
final class CreateBillingProgramReportingDetailsDelegateToBackendCallback extends com.google.android.gms.internal.play_billing.zzab {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final BillingProgramReportingDetailsListener f57233a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final int f57234b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final int f57235c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final Handler f57236d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final ExecutorService f57237f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final zzcz f57238g;

    CreateBillingProgramReportingDetailsDelegateToBackendCallback(BillingProgramReportingDetailsListener billingProgramReportingDetailsListener, int i3, zzcz zzczVar, int i4, Handler handler, ExecutorService executorService) {
        billingProgramReportingDetailsListener.getClass();
        this.f57233a = billingProgramReportingDetailsListener;
        this.f57234b = i3;
        this.f57238g = zzczVar;
        this.f57235c = i4;
        this.f57236d = handler;
        this.f57237f = executorService;
    }

    private void h5(BillingResult billingResult, Bundle bundle) {
        try {
            this.f57233a.a(billingResult, x3(bundle));
        } catch (Exception e3) {
            com.google.android.gms.internal.play_billing.zzc.zzo("CreateBillingProgramReportingDetailsDelegateToBackendCallback", "Got a JSON exception trying to decode billing program reporting details.");
            zzcz zzczVar = this.f57238g;
            zzjd zzjdVar = zzjd.ERROR_DECODING_DELEGATE_TO_BACKEND_RESPONSE_DATA;
            BillingResult billingResult2 = zzdc.f57558h;
            zzde.b(zzjdVar, billingResult2, zzczVar, zzdf.CREATE_BILLING_PROGRAM_REPORTING_DETAILS_ASYNC.b(), this.f57235c, zzcy.a(e3));
            this.f57233a.a(billingResult2, null);
        }
    }

    private BillingProgramReportingDetails x3(Bundle bundle) throws Exception {
        byte[] byteArray = bundle.getByteArray("RESPONSE_DATA");
        if (byteArray != null) {
            return new BillingProgramReportingDetails(com.google.android.gms.internal.play_billing.zzdm.zzb(byteArray).zzc().zzc(), this.f57234b);
        }
        throw new Exception("Response data is null");
    }

    @Override // com.google.android.gms.internal.play_billing.zzac
    public void onDelegateToBackendResponse(Bundle bundle) {
        if (bundle == null) {
            zzcz zzczVar = this.f57238g;
            zzjd zzjdVar = zzjd.NULL_BUNDLE_FROM_DELEGATE_TO_BACKEND_SERVICE_CALL;
            BillingResult billingResult = zzdc.f57558h;
            zzde.a(zzjdVar, billingResult, zzczVar, zzdf.CREATE_BILLING_PROGRAM_REPORTING_DETAILS_ASYNC.b(), this.f57235c);
            this.f57233a.a(billingResult, null);
            return;
        }
        zzdf zzdfVar = zzdf.CREATE_BILLING_PROGRAM_REPORTING_DETAILS_ASYNC;
        BillingResult billingResultA = zzdh.a(bundle, "CreateBillingProgramReportingDetailsDelegateToBackendCallback", zzdfVar.b(), this.f57238g, this.f57235c);
        BillingProgramReportingDetailsListener billingProgramReportingDetailsListener = this.f57233a;
        if (billingProgramReportingDetailsListener == null) {
            zzde.a(zzjd.NULL_LISTENER_IN_DELEGATE_TO_BACKEND_CALLBACK, billingResultA, this.f57238g, zzdfVar.b(), this.f57235c);
        } else if (billingResultA.c() != 0) {
            billingProgramReportingDetailsListener.a(billingResultA, null);
        } else {
            h5(billingResultA, bundle);
        }
    }
}
