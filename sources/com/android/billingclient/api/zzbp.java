package com.android.billingclient.api;

import android.os.Bundle;
import android.os.ResultReceiver;
import com.android.billingclient.api.BillingResult;
import com.google.android.gms.internal.play_billing.zzjd;
import com.google.android.gms.internal.play_billing.zzjk;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
final class zzbp extends ResultReceiver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ ExternalOfferInformationDialogListener f57476a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ BillingClientImpl f57477b;

    @Override // android.os.ResultReceiver
    public final void onReceiveResult(int i3, Bundle bundle) {
        BillingResult.Builder builderD = BillingResult.d();
        builderD.d(i3);
        if (i3 != 0) {
            if (bundle == null) {
                this.f57477b.l0(this.f57476a, zzdc.f57558h, zzjd.NULL_BUNDLE_IN_EXTERNAL_PAYMENT_INFORMATION_DIALOG_RECEIVER, null);
                return;
            }
            builderD.b(com.google.android.gms.internal.play_billing.zzc.zzk(bundle, "BillingClient"));
            int i4 = bundle.getInt("INTERNAL_LOG_ERROR_REASON");
            BillingClientImpl billingClientImpl = this.f57477b;
            zzjd zzjdVarZzb = i4 != 0 ? zzjd.zzb(i4) : zzjd.BILLING_RESULT_RECEIVED_FROM_PHONESKY;
            BillingResult billingResultA = builderD.a();
            String string = bundle.getString("INTERNAL_LOG_ERROR_ADDITIONAL_DETAILS");
            int i5 = zzcy.f57549a;
            billingClientImpl.R0(zzcy.b(zzjdVarZzb, 25, billingResultA, string, zzjk.BROADCAST_ACTION_UNSPECIFIED));
        }
        this.f57476a.a(builderD.a());
    }
}
