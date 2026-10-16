package com.android.billingclient.api;

import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
final class zzbs implements BillingClientStateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ com.google.android.gms.internal.play_billing.zzp f57481a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ BillingClientImpl f57482b;

    zzbs(BillingClientImpl billingClientImpl, com.google.android.gms.internal.play_billing.zzp zzpVar) {
        this.f57481a = zzpVar;
        Objects.requireNonNull(billingClientImpl);
        this.f57482b = billingClientImpl;
    }

    @Override // com.android.billingclient.api.BillingClientStateListener
    public final void onBillingServiceDisconnected() {
        com.google.android.gms.internal.play_billing.zzc.zzn("BillingClient", "Reconnection attempt failed.");
        try {
            this.f57481a.zzb(zzdc.f57560j);
        } catch (Throwable th) {
            com.google.android.gms.internal.play_billing.zzc.zzp("BillingClient", "Exception setting completer.", th);
        }
        BillingClientImpl billingClientImpl = this.f57482b;
        if (billingClientImpl.H != null) {
            billingClientImpl.C0(new Runnable() { // from class: com.android.billingclient.api.zzbq
                @Override // java.lang.Runnable
                public final void run() {
                    try {
                        this.f57478a.f57482b.H.onBillingServiceDisconnected();
                    } catch (Throwable th2) {
                        com.google.android.gms.internal.play_billing.zzc.zzp("BillingClient", "Exception calling onBillingServiceDisconnected.", th2);
                    }
                }
            });
        }
    }

    @Override // com.android.billingclient.api.BillingClientStateListener
    public final void onBillingSetupFinished(final BillingResult billingResult) {
        com.google.android.gms.internal.play_billing.zzc.zzn("BillingClient", "Reconnection finished with result: " + billingResult.c());
        try {
            this.f57481a.zzb(billingResult);
        } catch (Throwable th) {
            com.google.android.gms.internal.play_billing.zzc.zzp("BillingClient", "Exception setting completer.", th);
        }
        BillingClientImpl billingClientImpl = this.f57482b;
        if (billingClientImpl.H != null) {
            billingClientImpl.C0(new Runnable() { // from class: com.android.billingclient.api.zzbr
                @Override // java.lang.Runnable
                public final void run() {
                    zzbs zzbsVar = this.f57479a;
                    try {
                        zzbsVar.f57482b.H.onBillingSetupFinished(billingResult);
                    } catch (Throwable th2) {
                        com.google.android.gms.internal.play_billing.zzc.zzp("BillingClient", "Exception calling onBillingSetupFinished.", th2);
                    }
                }
            });
        }
    }
}
