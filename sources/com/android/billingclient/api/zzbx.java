package com.android.billingclient.api;

import android.os.Bundle;
import com.google.android.gms.internal.play_billing.zzjd;
import com.google.android.gms.internal.play_billing.zzjk;
import org.json.JSONException;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
final class zzbx extends com.google.android.gms.internal.play_billing.zzw {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final AlternativeBillingOnlyReportingDetailsListener f57492a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final zzcz f57493b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final int f57494c;

    /* synthetic */ zzbx(AlternativeBillingOnlyReportingDetailsListener alternativeBillingOnlyReportingDetailsListener, zzcz zzczVar, int i3, zzch zzchVar) {
        this.f57492a = alternativeBillingOnlyReportingDetailsListener;
        this.f57493b = zzczVar;
        this.f57494c = i3;
    }

    @Override // com.google.android.gms.internal.play_billing.zzx
    public final void zza(Bundle bundle) {
        if (bundle == null) {
            zzcz zzczVar = this.f57493b;
            zzjd zzjdVar = zzjd.NULL_BUNDLE_FROM_CREATE_ALTERNATIVE_BILLING_ONLY_TOKEN_SERVICE_CALL;
            BillingResult billingResult = zzdc.f57558h;
            int i3 = zzcy.f57549a;
            zzczVar.f(zzcy.b(zzjdVar, 15, billingResult, null, zzjk.BROADCAST_ACTION_UNSPECIFIED), this.f57494c);
            this.f57492a.a(billingResult, null);
            return;
        }
        int iZzb = com.google.android.gms.internal.play_billing.zzc.zzb(bundle, "BillingClient");
        BillingResult billingResultA = zzdc.a(iZzb, com.google.android.gms.internal.play_billing.zzc.zzk(bundle, "BillingClient"));
        if (iZzb != 0) {
            com.google.android.gms.internal.play_billing.zzc.zzo("BillingClient", "createAlternativeBillingOnlyReportingDetailsAsync() failed. Response code: " + iZzb);
            zzcz zzczVar2 = this.f57493b;
            zzjd zzjdVar2 = zzjd.BILLING_RESULT_RECEIVED_FROM_PHONESKY;
            int i4 = zzcy.f57549a;
            zzczVar2.f(zzcy.b(zzjdVar2, 15, billingResultA, null, zzjk.BROADCAST_ACTION_UNSPECIFIED), this.f57494c);
            this.f57492a.a(billingResultA, null);
            return;
        }
        try {
            this.f57492a.a(billingResultA, new AlternativeBillingOnlyReportingDetails(bundle.getString("CREATE_ALTERNATIVE_BILLING_ONLY_REPORTING_DETAILS")));
        } catch (JSONException e3) {
            com.google.android.gms.internal.play_billing.zzc.zzp("BillingClient", "Error when parsing invalid alternative billing only reporting details. \n Exception: ", e3);
            zzcz zzczVar3 = this.f57493b;
            zzjd zzjdVar3 = zzjd.ERROR_DECODING_ALTERNATIVE_BILLING_ONLY_REPORTING_DETAILS;
            BillingResult billingResult2 = zzdc.f57558h;
            int i5 = zzcy.f57549a;
            zzczVar3.f(zzcy.b(zzjdVar3, 15, billingResult2, null, zzjk.BROADCAST_ACTION_UNSPECIFIED), this.f57494c);
            this.f57492a.a(billingResult2, null);
        }
    }
}
