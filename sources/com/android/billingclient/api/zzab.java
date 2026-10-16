package com.android.billingclient.api;

import android.content.Context;
import android.content.IntentFilter;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
final class zzab {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f57370a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final PurchasesUpdatedListener f57371b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final zzb f57372c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final UserChoiceBillingListener f57373d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final DeveloperProvidedBillingListener f57374e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final zzcz f57375f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final zzaa f57376g = new zzaa(this, true);

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final zzaa f57377h = new zzaa(this, false);

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f57378i;

    zzab(Context context, PurchasesUpdatedListener purchasesUpdatedListener, zzdo zzdoVar, zzb zzbVar, UserChoiceBillingListener userChoiceBillingListener, DeveloperProvidedBillingListener developerProvidedBillingListener, zzcz zzczVar) {
        this.f57370a = context;
        this.f57371b = purchasesUpdatedListener;
        this.f57372c = zzbVar;
        this.f57373d = userChoiceBillingListener;
        this.f57374e = developerProvidedBillingListener;
        this.f57375f = zzczVar;
    }

    final DeveloperProvidedBillingListener d() {
        return this.f57374e;
    }

    final PurchasesUpdatedListener f() {
        return this.f57371b;
    }

    final void h() {
        zzaa zzaaVar = this.f57376g;
        Context context = this.f57370a;
        zzaaVar.c(context);
        this.f57377h.c(context);
    }

    final void i(boolean z2) {
        IntentFilter intentFilter = new IntentFilter("com.android.vending.billing.PURCHASES_UPDATED");
        IntentFilter intentFilter2 = new IntentFilter("com.android.vending.billing.LOCAL_BROADCAST_PURCHASES_UPDATED");
        intentFilter2.addAction("com.android.vending.billing.ALTERNATIVE_BILLING");
        this.f57378i = z2;
        zzaa zzaaVar = this.f57377h;
        Context context = this.f57370a;
        zzaaVar.a(context, intentFilter2);
        if (this.f57378i) {
            this.f57376g.b(context, intentFilter, "com.google.android.finsky.permission.PLAY_BILLING_LIBRARY_BROADCAST");
        } else {
            this.f57376g.a(context, intentFilter);
        }
    }
}
