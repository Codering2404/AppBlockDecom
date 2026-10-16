package com.android.billingclient.api;

import android.text.TextUtils;
import com.google.android.gms.internal.play_billing.zzjd;
import java.util.Objects;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
final class zzbm implements Callable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ PurchasesResponseListener f57469a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ String f57470b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ boolean f57471c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ BillingClientImpl f57472d;

    zzbm(BillingClientImpl billingClientImpl, PurchasesResponseListener purchasesResponseListener, String str, boolean z2) {
        this.f57469a = purchasesResponseListener;
        this.f57470b = str;
        this.f57471c = z2;
        Objects.requireNonNull(billingClientImpl);
        this.f57472d = billingClientImpl;
    }

    @Override // java.util.concurrent.Callable
    public final /* bridge */ /* synthetic */ Object call() {
        BillingClientImpl billingClientImpl = this.f57472d;
        if (!billingClientImpl.a1(30000L)) {
            zzjd zzjdVar = zzjd.SERVICE_CONNECTION_NOT_READY;
            BillingResult billingResult = zzdc.f57560j;
            billingClientImpl.h1(zzjdVar, 9, billingResult);
            this.f57469a.a(billingResult, com.google.android.gms.internal.play_billing.zzbw.zzk());
            return null;
        }
        String str = this.f57470b;
        if (TextUtils.isEmpty(str)) {
            com.google.android.gms.internal.play_billing.zzc.zzo("BillingClient", "Please provide a valid product type.");
            zzjd zzjdVar2 = zzjd.EMPTY_PRODUCT_TYPE;
            BillingResult billingResult2 = zzdc.f57555e;
            billingClientImpl.h1(zzjdVar2, 9, billingResult2);
            this.f57469a.a(billingResult2, com.google.android.gms.internal.play_billing.zzbw.zzk());
            return null;
        }
        zzdz zzdzVarF1 = billingClientImpl.f1(str, this.f57471c, 9);
        if (zzdzVarF1.b() != null) {
            this.f57469a.a(zzdzVarF1.a(), zzdzVarF1.b());
            return null;
        }
        this.f57469a.a(zzdzVarF1.a(), com.google.android.gms.internal.play_billing.zzbw.zzk());
        return null;
    }
}
