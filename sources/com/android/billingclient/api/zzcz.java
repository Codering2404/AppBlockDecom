package com.android.billingclient.api;

import com.google.android.gms.internal.play_billing.zziw;
import com.google.android.gms.internal.play_billing.zzja;
import com.google.android.gms.internal.play_billing.zzji;
import com.google.android.gms.internal.play_billing.zzjk;
import com.google.android.gms.internal.play_billing.zzkn;
import com.google.android.gms.internal.play_billing.zzkr;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
interface zzcz {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f57550a = 0;

    static {
        com.google.android.gms.internal.play_billing.zzbz.zzc("com.android.vending.billing.PURCHASES_UPDATED", zzjk.PURCHASES_UPDATED_ACTION, "com.android.vending.billing.LOCAL_BROADCAST_PURCHASES_UPDATED", zzjk.LOCAL_PURCHASES_UPDATED_ACTION, "com.android.vending.billing.ALTERNATIVE_BILLING", zzjk.ALTERNATIVE_BILLING_ACTION);
    }

    void a(zzja zzjaVar, int i3);

    void b(zzji zzjiVar);

    void c(zziw zziwVar, long j3, boolean z2);

    void d(zziw zziwVar, int i3, long j3);

    void e(zzkn zzknVar);

    void f(zziw zziwVar, int i3);

    void g(zzja zzjaVar);

    void h(zzkr zzkrVar);

    void i(zzja zzjaVar, long j3, boolean z2);

    void j(zziw zziwVar, int i3, long j3, boolean z2);

    void k(zziw zziwVar);
}
