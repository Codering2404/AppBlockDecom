package com.android.billingclient.api;

import android.os.Bundle;
import com.google.android.gms.internal.play_billing.zzjd;
import com.google.android.gms.internal.play_billing.zzjk;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
final class zzcd extends com.google.android.gms.internal.play_billing.zzaj {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final AlternativeBillingOnlyAvailabilityListener f57511a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final zzcz f57512b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final int f57513c;

    /* synthetic */ zzcd(AlternativeBillingOnlyAvailabilityListener alternativeBillingOnlyAvailabilityListener, zzcz zzczVar, int i3, zzch zzchVar) {
        this.f57511a = alternativeBillingOnlyAvailabilityListener;
        this.f57512b = zzczVar;
        this.f57513c = i3;
    }

    @Override // com.google.android.gms.internal.play_billing.zzak
    public final void zza(Bundle bundle) {
        if (bundle == null) {
            zzcz zzczVar = this.f57512b;
            zzjd zzjdVar = zzjd.NULL_BUNDLE_FROM_IS_ALTERNATIVE_BILLING_ONLY_AVAILABLE_SERVICE_CALL;
            BillingResult billingResult = zzdc.f57558h;
            int i3 = zzcy.f57549a;
            zzczVar.f(zzcy.b(zzjdVar, 14, billingResult, null, zzjk.BROADCAST_ACTION_UNSPECIFIED), this.f57513c);
            this.f57511a.a(billingResult);
            return;
        }
        int iZzb = com.google.android.gms.internal.play_billing.zzc.zzb(bundle, "BillingClient");
        BillingResult billingResultA = zzdc.a(iZzb, com.google.android.gms.internal.play_billing.zzc.zzk(bundle, "BillingClient"));
        if (iZzb != 0) {
            com.google.android.gms.internal.play_billing.zzc.zzo("BillingClient", "isAlternativeBillingOnlyAvailableAsync() failed. Response code: " + iZzb);
            zzcz zzczVar2 = this.f57512b;
            zzjd zzjdVar2 = zzjd.BILLING_RESULT_RECEIVED_FROM_PHONESKY;
            int i4 = zzcy.f57549a;
            zzczVar2.f(zzcy.b(zzjdVar2, 14, billingResultA, null, zzjk.BROADCAST_ACTION_UNSPECIFIED), this.f57513c);
        }
        this.f57511a.a(billingResultA);
    }
}
