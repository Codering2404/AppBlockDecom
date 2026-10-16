package com.android.billingclient.api;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.android.billingclient.api.BillingResult;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
final class zzdy extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        if (intent == null || !intent.hasExtra("RESPONSE_CODE")) {
            com.google.android.gms.internal.play_billing.zzc.zzo("ProxyBillingBroadcastReceiver", "Null intent or intent missing response code!");
            return;
        }
        BillingResult.Builder builderD = BillingResult.d();
        builderD.d(intent.getIntExtra("RESPONSE_CODE", 0));
        builderD.b(com.google.android.gms.internal.play_billing.zzbm.zzc(intent.getStringExtra("DEBUG_MESSAGE")));
        builderD.a();
    }
}
