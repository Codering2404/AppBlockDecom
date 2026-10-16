package com.android.billingclient.api;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import androidx.core.util.Consumer;
import com.android.billingclient.api.BillingClient;
import com.google.android.gms.internal.play_billing.zziw;
import com.google.android.gms.internal.play_billing.zzja;
import com.google.android.gms.internal.play_billing.zzjd;
import com.google.android.gms.internal.play_billing.zzjk;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
final class zzcw extends BillingClientImpl {
    private final Context L;
    private volatile int M;
    private volatile com.google.android.gms.internal.play_billing.zzay N;
    private volatile zzcu O;
    private volatile ScheduledExecutorService P;

    zzcw(String str, Context context, zzcz zzczVar, ExecutorService executorService, BillingClient.Builder builder) {
        super(null, context, null, null, builder);
        this.M = 0;
        this.L = context;
    }

    public static /* synthetic */ Object O1(zzcw zzcwVar, int i3, com.google.android.gms.internal.play_billing.zzp zzpVar) {
        try {
            if (zzcwVar.N == null) {
                throw null;
            }
            zzcwVar.N.zza(zzcwVar.L.getPackageName(), i3 != 2 ? i3 != 3 ? i3 != 4 ? i3 != 5 ? i3 != 6 ? "QUERY_PRODUCT_DETAILS_ASYNC" : "START_CONNECTION" : "IS_FEATURE_SUPPORTED" : "CONSUME_ASYNC" : "ACKNOWLEDGE_PURCHASE" : "LAUNCH_BILLING_FLOW", new zzct(zzpVar));
            return "billingOverrideService.getBillingOverride";
        } catch (Exception e3) {
            zzcwVar.Y1(zzjd.BILLING_OVERRIDE_SERVICE_CALL_EXCEPTION, 28, zzdc.E);
            com.google.android.gms.internal.play_billing.zzc.zzp("BillingClientTesting", "An error occurred while retrieving billing override.", e3);
            zzpVar.zzb(0);
            return "billingOverrideService.getBillingOverride";
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final int R1(com.google.android.gms.internal.play_billing.zzdc zzdcVar) {
        try {
            return ((Integer) zzdcVar.get(28500L, TimeUnit.MILLISECONDS)).intValue();
        } catch (TimeoutException e3) {
            Y1(zzjd.BILLING_OVERRIDE_SERVICE_CALL_TIMEOUT, 28, zzdc.E);
            com.google.android.gms.internal.play_billing.zzc.zzp("BillingClientTesting", "Asynchronous call to Billing Override Service timed out.", e3);
            return 0;
        } catch (Exception e4) {
            if (e4 instanceof InterruptedException) {
                Thread.currentThread().interrupt();
            }
            Y1(zzjd.BILLING_OVERRIDE_SERVICE_CALL_EXCEPTION, 28, zzdc.E);
            com.google.android.gms.internal.play_billing.zzc.zzp("BillingClientTesting", "An error occurred while retrieving billing override.", e4);
            return 0;
        }
    }

    private final synchronized ScheduledExecutorService S1() {
        try {
            if (this.P == null) {
                this.P = Executors.newSingleThreadScheduledExecutor();
            }
        } catch (Throwable th) {
            throw th;
        }
        return this.P;
    }

    private final synchronized void T1() {
        Z1(27);
        try {
            try {
                zzcv zzcvVar = null;
                if (this.O != null && this.N != null) {
                    com.google.android.gms.internal.play_billing.zzc.zzn("BillingClientTesting", "Unbinding from Billing Override Service.");
                    this.L.unbindService(this.O);
                    this.O = new zzcu(this, zzcvVar);
                }
                this.N = null;
                if (this.P != null) {
                    this.P.shutdownNow();
                    this.P = null;
                }
            } catch (RuntimeException e3) {
                com.google.android.gms.internal.play_billing.zzc.zzp("BillingClientTesting", "There was an exception while ending Billing Override Service connection!", e3);
            }
            this.M = 3;
        } catch (Throwable th) {
            this.M = 3;
            throw th;
        }
    }

    private final synchronized void U1() {
        if (M1()) {
            com.google.android.gms.internal.play_billing.zzc.zzn("BillingClientTesting", "Billing Override Service connection is valid. No need to re-initialize.");
            Z1(26);
            return;
        }
        if (this.M == 1) {
            com.google.android.gms.internal.play_billing.zzc.zzo("BillingClientTesting", "Client is already in the process of connecting to Billing Override Service.");
            return;
        }
        if (this.M == 3) {
            com.google.android.gms.internal.play_billing.zzc.zzo("BillingClientTesting", "Billing Override Service Client was already closed and can't be reused. Please create another instance.");
            Y1(zzjd.BILLING_CLIENT_CLOSED, 26, zzdc.a(-1, "Billing Override Service connection is disconnected."));
            return;
        }
        this.M = 1;
        com.google.android.gms.internal.play_billing.zzc.zzn("BillingClientTesting", "Starting Billing Override Service setup.");
        this.O = new zzcu(this, null);
        Intent intent = new Intent("com.google.android.apps.play.billingtestcompanion.BillingOverrideService.BIND");
        intent.setPackage("com.google.android.apps.play.billingtestcompanion");
        Context context = this.L;
        List<ResolveInfo> listQueryIntentServices = context.getPackageManager().queryIntentServices(intent, 0);
        zzjd zzjdVar = zzjd.REASON_UNSPECIFIED;
        if (listQueryIntentServices == null || listQueryIntentServices.isEmpty()) {
            zzjdVar = zzjd.INTENT_SERVICE_NOT_FOUND;
        } else {
            ServiceInfo serviceInfo = listQueryIntentServices.get(0).serviceInfo;
            if (serviceInfo != null) {
                String str = serviceInfo.packageName;
                String str2 = serviceInfo.name;
                if (!Objects.equals(str, "com.google.android.apps.play.billingtestcompanion") || str2 == null) {
                    zzjdVar = zzjd.BILLING_SERVICE_BLOCKED;
                    com.google.android.gms.internal.play_billing.zzc.zzo("BillingClientTesting", "The device doesn't have valid Play Billing Lab.");
                } else {
                    ComponentName componentName = new ComponentName(str, str2);
                    Intent intent2 = new Intent(intent);
                    intent2.setComponent(componentName);
                    if (context.bindService(intent2, this.O, 1)) {
                        com.google.android.gms.internal.play_billing.zzc.zzn("BillingClientTesting", "Billing Override Service was bonded successfully.");
                        return;
                    } else {
                        zzjdVar = zzjd.BILLING_SERVICE_BLOCKED;
                        com.google.android.gms.internal.play_billing.zzc.zzo("BillingClientTesting", "Connection to Billing Override Service is blocked.");
                    }
                }
            }
        }
        this.M = 0;
        com.google.android.gms.internal.play_billing.zzc.zzn("BillingClientTesting", "Billing Override Service unavailable on device.");
        Y1(zzjdVar, 26, zzdc.a(2, "Billing Override Service unavailable on device."));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean V1(int i3) {
        return i3 > 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final BillingResult W1(int i3, int i4) {
        BillingResult billingResultA = zzdc.a(i4, "Billing override value was set by a license tester.");
        Y1(zzjd.LICENSE_TESTER_BILLING_OVERRIDE, i3, billingResultA);
        return billingResultA;
    }

    private final com.google.android.gms.internal.play_billing.zzdc X1(final int i3) {
        if (M1()) {
            return com.google.android.gms.internal.play_billing.zzu.zza(new com.google.android.gms.internal.play_billing.zzr() { // from class: com.android.billingclient.api.zzcn
                @Override // com.google.android.gms.internal.play_billing.zzr
                public final Object zza(com.google.android.gms.internal.play_billing.zzp zzpVar) {
                    return zzcw.O1(this.f57533a, i3, zzpVar);
                }
            });
        }
        com.google.android.gms.internal.play_billing.zzc.zzo("BillingClientTesting", "Billing Override Service is not ready.");
        Y1(zzjd.BILLING_OVERRIDE_SERVICE_CONNECTION_NOT_READY, 28, zzdc.a(-1, "Billing Override Service connection is disconnected."));
        return com.google.android.gms.internal.play_billing.zzcx.zza(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Y1(zzjd zzjdVar, int i3, BillingResult billingResult) {
        int i4 = zzcy.f57549a;
        zziw zziwVarB = zzcy.b(zzjdVar, i3, billingResult, null, zzjk.BROADCAST_ACTION_UNSPECIFIED);
        Objects.requireNonNull(zziwVarB, "ApiFailure should not be null");
        v1().k(zziwVarB);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Z1(int i3) {
        int i4 = zzcy.f57549a;
        zzja zzjaVarC = zzcy.c(i3, zzjk.BROADCAST_ACTION_UNSPECIFIED);
        Objects.requireNonNull(zzjaVarC, "ApiSuccess should not be null");
        v1().g(zzjaVarC);
    }

    private final void a2(int i3, Consumer consumer, Runnable runnable) {
        com.google.android.gms.internal.play_billing.zzcx.zzc(com.google.android.gms.internal.play_billing.zzcx.zzb(X1(i3), 28500L, TimeUnit.MILLISECONDS, S1()), new zzcs(this, i3, consumer, runnable), x());
    }

    public final synchronized boolean M1() {
        if (this.M == 2 && this.N != null) {
            if (this.O != null) {
                return true;
            }
        }
        return false;
    }

    @Override // com.android.billingclient.api.BillingClientImpl, com.android.billingclient.api.BillingClient
    public final void a(final AcknowledgePurchaseParams acknowledgePurchaseParams, final AcknowledgePurchaseResponseListener acknowledgePurchaseResponseListener) {
        Objects.requireNonNull(acknowledgePurchaseResponseListener);
        a2(3, new Consumer() { // from class: com.android.billingclient.api.zzco
            @Override // androidx.core.util.Consumer
            public final void accept(Object obj) {
                acknowledgePurchaseResponseListener.b((BillingResult) obj);
            }
        }, new Runnable() { // from class: com.android.billingclient.api.zzcp
            @Override // java.lang.Runnable
            public final void run() {
                super/*com.android.billingclient.api.BillingClientImpl*/.a(acknowledgePurchaseParams, acknowledgePurchaseResponseListener);
            }
        });
    }

    @Override // com.android.billingclient.api.BillingClientImpl, com.android.billingclient.api.BillingClient
    public final void b(final ConsumeParams consumeParams, final ConsumeResponseListener consumeResponseListener) {
        a2(4, new Consumer() { // from class: com.android.billingclient.api.zzcl
            @Override // androidx.core.util.Consumer
            public final void accept(Object obj) {
                consumeResponseListener.c((BillingResult) obj, consumeParams.a());
            }
        }, new Runnable() { // from class: com.android.billingclient.api.zzcm
            @Override // java.lang.Runnable
            public final void run() {
                super/*com.android.billingclient.api.BillingClientImpl*/.b(consumeParams, consumeResponseListener);
            }
        });
    }

    @Override // com.android.billingclient.api.BillingClientImpl, com.android.billingclient.api.BillingClient
    public final void c() {
        T1();
        super.c();
    }

    @Override // com.android.billingclient.api.BillingClientImpl, com.android.billingclient.api.BillingClient
    public final BillingResult g(final Activity activity, final BillingFlowParams billingFlowParams) {
        Consumer consumer = new Consumer() { // from class: com.android.billingclient.api.zzcq
            @Override // androidx.core.util.Consumer
            public final void accept(Object obj) {
                super/*com.android.billingclient.api.BillingClientImpl*/.y1((BillingResult) obj);
            }
        };
        Callable callable = new Callable() { // from class: com.android.billingclient.api.zzcr
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return super/*com.android.billingclient.api.BillingClientImpl*/.g(activity, billingFlowParams);
            }
        };
        int iR1 = R1(X1(2));
        if (V1(iR1)) {
            BillingResult billingResultW1 = W1(2, iR1);
            consumer.accept(billingResultW1);
            return billingResultW1;
        }
        try {
            return (BillingResult) callable.call();
        } catch (Exception e3) {
            zzjd zzjdVar = zzjd.BILLING_OVERRIDE_SERVICE_FALLBACK_ERROR;
            BillingResult billingResult = zzdc.f57558h;
            Y1(zzjdVar, 2, billingResult);
            com.google.android.gms.internal.play_billing.zzc.zzp("BillingClientTesting", "An internal error occurred.", e3);
            return billingResult;
        }
    }

    @Override // com.android.billingclient.api.BillingClientImpl, com.android.billingclient.api.BillingClient
    public final void i(final QueryProductDetailsParams queryProductDetailsParams, final ProductDetailsResponseListener productDetailsResponseListener) {
        a2(7, new Consumer() { // from class: com.android.billingclient.api.zzcj
            @Override // androidx.core.util.Consumer
            public final void accept(Object obj) {
                QueryProductDetailsResult queryProductDetailsResult = new QueryProductDetailsResult(new ArrayList(), new ArrayList());
                productDetailsResponseListener.a((BillingResult) obj, queryProductDetailsResult);
            }
        }, new Runnable() { // from class: com.android.billingclient.api.zzck
            @Override // java.lang.Runnable
            public final void run() {
                super/*com.android.billingclient.api.BillingClientImpl*/.i(queryProductDetailsParams, productDetailsResponseListener);
            }
        });
    }

    @Override // com.android.billingclient.api.BillingClientImpl, com.android.billingclient.api.BillingClient
    public final void l(BillingClientStateListener billingClientStateListener) {
        U1();
        super.l(billingClientStateListener);
    }

    zzcw(String str, PendingPurchasesParams pendingPurchasesParams, Context context, zzdo zzdoVar, zzcz zzczVar, ExecutorService executorService, BillingClient.Builder builder) {
        super(null, pendingPurchasesParams, context, null, null, null, builder);
        this.M = 0;
        this.L = context;
    }

    zzcw(String str, PendingPurchasesParams pendingPurchasesParams, Context context, PurchasesUpdatedListener purchasesUpdatedListener, zzb zzbVar, zzcz zzczVar, ExecutorService executorService, BillingClient.Builder builder) {
        super(null, pendingPurchasesParams, context, purchasesUpdatedListener, null, null, null, builder);
        this.M = 0;
        this.L = context;
    }

    zzcw(String str, PendingPurchasesParams pendingPurchasesParams, Context context, PurchasesUpdatedListener purchasesUpdatedListener, UserChoiceBillingListener userChoiceBillingListener, DeveloperProvidedBillingListener developerProvidedBillingListener, zzcz zzczVar, ExecutorService executorService, BillingClient.Builder builder) {
        super(null, pendingPurchasesParams, context, purchasesUpdatedListener, userChoiceBillingListener, developerProvidedBillingListener, null, null, builder);
        this.M = 0;
        this.L = context;
    }
}
