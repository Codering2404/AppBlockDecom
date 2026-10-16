package com.android.billingclient.api;

import com.google.android.gms.internal.play_billing.zzjd;
import com.google.android.gms.internal.play_billing.zzjk;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
final class zzde {
    static void a(zzjd zzjdVar, BillingResult billingResult, zzcz zzczVar, int i3, int i4) {
        int i5 = zzcy.f57549a;
        zzczVar.f(zzcy.b(zzjdVar, i3, billingResult, null, zzjk.BROADCAST_ACTION_UNSPECIFIED), i4);
    }

    static void b(zzjd zzjdVar, BillingResult billingResult, zzcz zzczVar, int i3, int i4, String str) {
        int i5 = zzcy.f57549a;
        zzczVar.f(zzcy.b(zzjdVar, i3, billingResult, str, zzjk.BROADCAST_ACTION_UNSPECIFIED), i4);
    }
}
