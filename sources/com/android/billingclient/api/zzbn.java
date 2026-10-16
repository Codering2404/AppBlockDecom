package com.android.billingclient.api;

import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
final class zzbn extends ResultReceiver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ InAppMessageResponseListener f57473a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzbn(BillingClientImpl billingClientImpl, Handler handler, InAppMessageResponseListener inAppMessageResponseListener) {
        super(handler);
        this.f57473a = inAppMessageResponseListener;
        Objects.requireNonNull(billingClientImpl);
    }

    @Override // android.os.ResultReceiver
    public final void onReceiveResult(int i3, Bundle bundle) {
        this.f57473a.a(com.google.android.gms.internal.play_billing.zzc.zzj(bundle, "BillingClient"));
    }
}
