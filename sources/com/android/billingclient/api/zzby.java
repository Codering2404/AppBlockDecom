package com.android.billingclient.api;

import android.os.Bundle;
import com.google.android.gms.internal.play_billing.zzjd;
import com.google.android.gms.internal.play_billing.zzjk;
import org.json.JSONException;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
final class zzby extends com.google.android.gms.internal.play_billing.zzy {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final ExternalOfferReportingDetailsListener f57495a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final zzcz f57496b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final int f57497c;

    /* synthetic */ zzby(ExternalOfferReportingDetailsListener externalOfferReportingDetailsListener, zzcz zzczVar, int i3, zzch zzchVar) {
        this.f57495a = externalOfferReportingDetailsListener;
        this.f57496b = zzczVar;
        this.f57497c = i3;
    }

    @Override // com.google.android.gms.internal.play_billing.zzz
    public final void zza(Bundle bundle) {
        if (bundle == null) {
            zzcz zzczVar = this.f57496b;
            zzjd zzjdVar = zzjd.NULL_BUNDLE_FROM_CREATE_EXTERNAL_PAYMENT_REPORTING_DETAILS_SERVICE_CALL;
            BillingResult billingResult = zzdc.f57558h;
            int i3 = zzcy.f57549a;
            zzczVar.f(zzcy.b(zzjdVar, 24, billingResult, null, zzjk.BROADCAST_ACTION_UNSPECIFIED), this.f57497c);
            this.f57495a.a(billingResult, null);
            return;
        }
        int iZzb = com.google.android.gms.internal.play_billing.zzc.zzb(bundle, "BillingClient");
        BillingResult billingResultA = zzdc.a(iZzb, com.google.android.gms.internal.play_billing.zzc.zzk(bundle, "BillingClient"));
        if (iZzb != 0) {
            com.google.android.gms.internal.play_billing.zzc.zzo("BillingClient", "createExternalOfferReportingDetailsAsync() failed. Response code: " + iZzb);
            zzcz zzczVar2 = this.f57496b;
            zzjd zzjdVar2 = zzjd.BILLING_RESULT_RECEIVED_FROM_PHONESKY;
            int i4 = zzcy.f57549a;
            zzczVar2.f(zzcy.b(zzjdVar2, 24, billingResultA, null, zzjk.BROADCAST_ACTION_UNSPECIFIED), this.f57497c);
            this.f57495a.a(billingResultA, null);
            return;
        }
        try {
            this.f57495a.a(billingResultA, new ExternalOfferReportingDetails(bundle.getString("CREATE_EXTERNAL_PAYMENT_REPORTING_DETAILS")));
        } catch (JSONException e3) {
            com.google.android.gms.internal.play_billing.zzc.zzp("BillingClient", "Error when parsing invalid external offer reporting details. \n Exception: ", e3);
            zzcz zzczVar3 = this.f57496b;
            zzjd zzjdVar3 = zzjd.ERROR_DECODING_EXTERNAL_OFFER_REPORTING_DETAILS;
            BillingResult billingResult2 = zzdc.f57558h;
            int i5 = zzcy.f57549a;
            zzczVar3.f(zzcy.b(zzjdVar3, 24, billingResult2, null, zzjk.BROADCAST_ACTION_UNSPECIFIED), this.f57497c);
            this.f57495a.a(billingResult2, null);
        }
    }
}
