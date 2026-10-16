package com.android.billingclient.api;

import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
final class zzci implements AcknowledgePurchaseResponseListener, BillingClientStateListener, ConsumeResponseListener, PurchaseHistoryResponseListener, PurchasesResponseListener, PurchasesUpdatedListener, SkuDetailsResponseListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f57523a;

    public static native void nativeOnAcknowledgePurchaseResponse(int i3, String str, long j3);

    public static native void nativeOnBillingServiceDisconnected();

    public static native void nativeOnBillingSetupFinished(int i3, String str, long j3);

    public static native void nativeOnConsumePurchaseResponse(int i3, String str, String str2, long j3);

    public static native void nativeOnPurchasesUpdated(int i3, String str, Purchase[] purchaseArr);

    public static native void nativeOnQueryPurchasesResponse(int i3, String str, Purchase[] purchaseArr, long j3);

    @Override // com.android.billingclient.api.PurchasesResponseListener
    public final void a(BillingResult billingResult, List list) {
        nativeOnQueryPurchasesResponse(billingResult.c(), billingResult.a(), (Purchase[]) list.toArray(new Purchase[list.size()]), this.f57523a);
    }

    @Override // com.android.billingclient.api.AcknowledgePurchaseResponseListener
    public final void b(BillingResult billingResult) {
        nativeOnAcknowledgePurchaseResponse(billingResult.c(), billingResult.a(), this.f57523a);
    }

    @Override // com.android.billingclient.api.ConsumeResponseListener
    public final void c(BillingResult billingResult, String str) {
        nativeOnConsumePurchaseResponse(billingResult.c(), billingResult.a(), str, this.f57523a);
    }

    @Override // com.android.billingclient.api.BillingClientStateListener
    public final void onBillingServiceDisconnected() {
        nativeOnBillingServiceDisconnected();
    }

    @Override // com.android.billingclient.api.BillingClientStateListener
    public final void onBillingSetupFinished(BillingResult billingResult) {
        nativeOnBillingSetupFinished(billingResult.c(), billingResult.a(), this.f57523a);
    }

    @Override // com.android.billingclient.api.PurchasesUpdatedListener
    public final void onPurchasesUpdated(BillingResult billingResult, List list) {
        if (list == null) {
            list = Collections.EMPTY_LIST;
        }
        nativeOnPurchasesUpdated(billingResult.c(), billingResult.a(), (Purchase[]) list.toArray(new Purchase[list.size()]));
    }
}
