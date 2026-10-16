package com.android.billingclient.api;

import android.os.Bundle;
import com.android.billingclient.api.BillingResult;
import com.google.android.gms.internal.play_billing.zzjd;
import com.google.android.gms.internal.play_billing.zzjk;
import org.json.JSONException;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
final class zzca extends com.google.android.gms.internal.play_billing.zzaf {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final BillingConfigResponseListener f57503a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final zzcz f57504b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final int f57505c;

    /* synthetic */ zzca(BillingConfigResponseListener billingConfigResponseListener, zzcz zzczVar, int i3, zzch zzchVar) {
        this.f57503a = billingConfigResponseListener;
        this.f57504b = zzczVar;
        this.f57505c = i3;
    }

    @Override // com.google.android.gms.internal.play_billing.zzag
    public final void zza(Bundle bundle) {
        if (bundle == null) {
            zzcz zzczVar = this.f57504b;
            zzjd zzjdVar = zzjd.NULL_BUNDLE_FROM_GET_BILLING_CONFIG_SERVICE_CALL;
            BillingResult billingResult = zzdc.f57558h;
            int i3 = zzcy.f57549a;
            zzczVar.f(zzcy.b(zzjdVar, 13, billingResult, null, zzjk.BROADCAST_ACTION_UNSPECIFIED), this.f57505c);
            this.f57503a.a(billingResult, null);
            return;
        }
        int iZzb = com.google.android.gms.internal.play_billing.zzc.zzb(bundle, "BillingClient");
        String strZzk = com.google.android.gms.internal.play_billing.zzc.zzk(bundle, "BillingClient");
        BillingResult.Builder builderD = BillingResult.d();
        builderD.d(iZzb);
        builderD.b(strZzk);
        if (iZzb != 0) {
            com.google.android.gms.internal.play_billing.zzc.zzo("BillingClient", "getBillingConfig() failed. Response code: " + iZzb);
            BillingResult billingResultA = builderD.a();
            zzcz zzczVar2 = this.f57504b;
            zzjd zzjdVar2 = zzjd.BILLING_RESULT_RECEIVED_FROM_PHONESKY;
            int i4 = zzcy.f57549a;
            zzczVar2.f(zzcy.b(zzjdVar2, 13, billingResultA, null, zzjk.BROADCAST_ACTION_UNSPECIFIED), this.f57505c);
            this.f57503a.a(billingResultA, null);
            return;
        }
        if (!bundle.containsKey("BILLING_CONFIG")) {
            com.google.android.gms.internal.play_billing.zzc.zzo("BillingClient", "getBillingConfig() returned a bundle with neither an error nor a billing config response");
            builderD.d(6);
            BillingResult billingResultA2 = builderD.a();
            zzcz zzczVar3 = this.f57504b;
            zzjd zzjdVar3 = zzjd.MISSING_BILLING_CONFIG_IN_GET_BILLING_CONFIG_RESPONSE;
            int i5 = zzcy.f57549a;
            zzczVar3.f(zzcy.b(zzjdVar3, 13, billingResultA2, null, zzjk.BROADCAST_ACTION_UNSPECIFIED), this.f57505c);
            this.f57503a.a(billingResultA2, null);
            return;
        }
        try {
            this.f57503a.a(builderD.a(), new BillingConfig(bundle.getString("BILLING_CONFIG")));
        } catch (JSONException e3) {
            com.google.android.gms.internal.play_billing.zzc.zzp("BillingClient", "Got a JSON exception trying to decode BillingConfig. \n Exception: ", e3);
            zzcz zzczVar4 = this.f57504b;
            zzjd zzjdVar4 = zzjd.ERROR_DECODING_BILLING_CONFIG_DATA;
            BillingResult billingResult2 = zzdc.f57558h;
            int i6 = zzcy.f57549a;
            zzczVar4.f(zzcy.b(zzjdVar4, 13, billingResult2, null, zzjk.BROADCAST_ACTION_UNSPECIFIED), this.f57505c);
            this.f57503a.a(billingResult2, null);
        }
    }
}
