package com.android.billingclient.api;

import android.os.Bundle;
import com.android.billingclient.api.BillingResult;
import com.google.android.gms.internal.play_billing.zzjd;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
final class zzdh {
    public static BillingResult a(Bundle bundle, String str, int i3, zzcz zzczVar, int i4) {
        if (!bundle.containsKey("BILLING_RESULT")) {
            com.google.android.gms.internal.play_billing.zzc.zzo(str, "delegateToBackendAsync does not contain a billing result in the response");
            zzjd zzjdVar = zzjd.MISSING_BILLING_RESULT_IN_DELEGATE_TO_BACKEND_RESPONSE;
            BillingResult billingResult = zzdc.f57558h;
            zzde.a(zzjdVar, billingResult, zzczVar, i3, i4);
            return billingResult;
        }
        try {
            byte[] byteArray = bundle.getByteArray("BILLING_RESULT");
            if (byteArray == null) {
                throw new Exception("Billing result is null");
            }
            com.google.android.gms.internal.play_billing.zzdw zzdwVarZzc = com.google.android.gms.internal.play_billing.zzdw.zzc(byteArray);
            BillingResult.Builder builderD = BillingResult.d();
            builderD.d(zzdwVarZzc.zza());
            builderD.b(zzdwVarZzc.zze());
            BillingResult billingResultA = builderD.a();
            if (billingResultA.c() != 0) {
                zzde.a(zzjd.BILLING_RESULT_RECEIVED_FROM_PHONESKY, billingResultA, zzczVar, i3, i4);
                return billingResultA;
            }
            if (bundle.containsKey("RESPONSE_DATA")) {
                return billingResultA;
            }
            com.google.android.gms.internal.play_billing.zzc.zzo(str, "delegateToBackendAsync returned a bundle with neither an error nor response data");
            zzjd zzjdVar2 = zzjd.MISSING_RESPONSE_DATA_IN_DELEGATE_TO_BACKEND_RESPONSE;
            BillingResult billingResult2 = zzdc.f57558h;
            zzde.a(zzjdVar2, billingResult2, zzczVar, i3, i4);
            return billingResult2;
        } catch (Exception e3) {
            com.google.android.gms.internal.play_billing.zzc.zzp(str, "Failed parsing BillingResult.", e3);
            zzjd zzjdVar3 = zzjd.ERROR_DECODING_DELEGATE_TO_BACKEND_BILLING_RESULT;
            BillingResult billingResult3 = zzdc.f57558h;
            zzde.b(zzjdVar3, billingResult3, zzczVar, i3, i4, zzcy.a(e3));
            return billingResult3;
        }
    }
}
