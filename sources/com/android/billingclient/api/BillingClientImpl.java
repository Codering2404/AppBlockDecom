package com.android.billingclient.api;

import android.R;
import android.app.Activity;
import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import android.os.ResultReceiver;
import android.text.TextUtils;
import android.view.View;
import androidx.compose.material.icons.twotone.Phg.QaXmqxvjHhxVy;
import androidx.core.app.BundleCompat;
import com.android.billingclient.api.BillingClient;
import com.android.billingclient.api.QueryProductDetailsParams;
import com.facebook.internal.instrument.anrreport.jRA.jlWo;
import com.google.android.gms.internal.play_billing.zzhu;
import com.google.android.gms.internal.play_billing.zzhx;
import com.google.android.gms.internal.play_billing.zzio;
import com.google.android.gms.internal.play_billing.zziq;
import com.google.android.gms.internal.play_billing.zziu;
import com.google.android.gms.internal.play_billing.zziw;
import com.google.android.gms.internal.play_billing.zziy;
import com.google.android.gms.internal.play_billing.zzja;
import com.google.android.gms.internal.play_billing.zzjb;
import com.google.android.gms.internal.play_billing.zzjd;
import com.google.android.gms.internal.play_billing.zzjf;
import com.google.android.gms.internal.play_billing.zzjk;
import com.google.android.gms.internal.play_billing.zzjp;
import com.google.android.gms.internal.play_billing.zzjr;
import com.google.android.gms.internal.play_billing.zzjv;
import com.google.android.gms.internal.play_billing.zzjy;
import com.google.android.gms.internal.play_billing.zzks;
import com.google.android.gms.internal.play_billing.zzku;
import com.revenuecat.purchases.api.BuildConfig;
import com.revenuecat.purchases.common.responses.CustomerInfoResponseJsonKeys;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
class BillingClientImpl extends BillingClient {
    private boolean A;
    private boolean B;
    private boolean C;
    private boolean D;
    private PendingPurchasesParams E;
    private boolean F;
    private boolean G;
    private volatile BillingClientStateListener H;
    private ExecutorService I;
    private final Long J;
    private com.google.android.gms.internal.play_billing.zzbo K;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Object f57164a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private volatile int f57165b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f57166c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f57167d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Handler f57168e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private volatile zzab f57169f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private Context f57170g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private zzcz f57171h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private volatile com.google.android.gms.internal.play_billing.zzap f57172i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private volatile zzbw f57173j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private boolean f57174k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private boolean f57175l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private int f57176m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private boolean f57177n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private boolean f57178o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private boolean f57179p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private boolean f57180q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private boolean f57181r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private boolean f57182s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private boolean f57183t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private boolean f57184u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private boolean f57185v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private boolean f57186w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private boolean f57187x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private boolean f57188y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private boolean f57189z;

    private BillingClientImpl(Context context, PendingPurchasesParams pendingPurchasesParams, PurchasesUpdatedListener purchasesUpdatedListener, String str, String str2, UserChoiceBillingListener userChoiceBillingListener, DeveloperProvidedBillingListener developerProvidedBillingListener, zzcz zzczVar, ExecutorService executorService, BillingClient.Builder builder) {
        this.f57164a = new Object();
        this.f57165b = 0;
        this.f57168e = new Handler(Looper.getMainLooper());
        this.f57176m = 0;
        this.J = Long.valueOf(new Random().nextLong());
        this.K = com.google.android.gms.internal.play_billing.zzbd.zza();
        this.f57166c = str;
        this.f57167d = T();
        m(context, purchasesUpdatedListener, pendingPurchasesParams, userChoiceBillingListener, developerProvidedBillingListener, str, null, builder);
    }

    public static /* synthetic */ void A(BillingClientImpl billingClientImpl, PurchasesResponseListener purchasesResponseListener) {
        zzjd zzjdVar = zzjd.EXECUTE_ASYNC_TIMEOUT;
        BillingResult billingResult = zzdc.f57561k;
        billingClientImpl.h1(zzjdVar, 9, billingResult);
        purchasesResponseListener.a(billingResult, com.google.android.gms.internal.play_billing.zzbw.zzk());
    }

    static /* bridge */ /* synthetic */ void A0(BillingClientImpl billingClientImpl, int i3) {
        if (i3 != 0) {
            billingClientImpl.V0(0);
            return;
        }
        synchronized (billingClientImpl.f57164a) {
            try {
                if (billingClientImpl.f57165b == 3) {
                    return;
                }
                billingClientImpl.V0(2);
                zzab zzabVar = billingClientImpl.f57169f != null ? billingClientImpl.f57169f : null;
                if (zzabVar != null) {
                    zzabVar.i(billingClientImpl.f57188y);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static /* synthetic */ void B(BillingClientImpl billingClientImpl, BillingConfigResponseListener billingConfigResponseListener) {
        zzjd zzjdVar = zzjd.EXECUTE_ASYNC_TIMEOUT;
        BillingResult billingResult = zzdc.f57561k;
        billingClientImpl.h1(zzjdVar, 13, billingResult);
        billingConfigResponseListener.a(billingResult, null);
    }

    public static /* synthetic */ Object C1(BillingClientImpl billingClientImpl, int i3, com.google.android.gms.internal.play_billing.zzp zzpVar) {
        billingClientImpl.X0(new zzbs(billingClientImpl, zzpVar), i3);
        return "reconnectIfNeeded";
    }

    public static /* synthetic */ Object D1(BillingClientImpl billingClientImpl, ConsumeResponseListener consumeResponseListener, ConsumeParams consumeParams) throws Throwable {
        if (billingClientImpl.a1(30000L)) {
            billingClientImpl.c0(consumeParams, consumeResponseListener);
            return null;
        }
        zzjd zzjdVar = zzjd.SERVICE_CONNECTION_NOT_READY;
        BillingResult billingResult = zzdc.f57560j;
        billingClientImpl.h1(zzjdVar, 4, billingResult);
        consumeResponseListener.c(billingResult, consumeParams.a());
        return null;
    }

    static /* bridge */ /* synthetic */ boolean E0(BillingClientImpl billingClientImpl) {
        boolean z2;
        synchronized (billingClientImpl.f57164a) {
            z2 = true;
            if (billingClientImpl.f57165b != 1) {
                z2 = false;
            }
        }
        return z2;
    }

    public static /* synthetic */ Object E1(BillingClientImpl billingClientImpl, ProductDetailsResponseListener productDetailsResponseListener, QueryProductDetailsParams queryProductDetailsParams) {
        if (!billingClientImpl.a1(30000L)) {
            zzjd zzjdVar = zzjd.SERVICE_CONNECTION_NOT_READY;
            BillingResult billingResult = zzdc.f57560j;
            billingClientImpl.h1(zzjdVar, 7, billingResult);
            productDetailsResponseListener.a(billingResult, new QueryProductDetailsResult(com.google.android.gms.internal.play_billing.zzbw.zzk(), com.google.android.gms.internal.play_billing.zzbw.zzk()));
            return null;
        }
        if (billingClientImpl.f57184u) {
            zzcg zzcgVarS1 = billingClientImpl.s1(queryProductDetailsParams);
            productDetailsResponseListener.a(zzdc.a(zzcgVarS1.a(), zzcgVarS1.b()), new QueryProductDetailsResult(zzcgVarS1.c(), zzcgVarS1.d()));
            return null;
        }
        com.google.android.gms.internal.play_billing.zzc.zzo("BillingClient", "Querying product details is not supported.");
        zzjd zzjdVar2 = zzjd.PRODUCT_DETAILS_NOT_SUPPORTED;
        BillingResult billingResult2 = zzdc.f57568r;
        billingClientImpl.h1(zzjdVar2, 7, billingResult2);
        productDetailsResponseListener.a(billingResult2, new QueryProductDetailsResult(com.google.android.gms.internal.play_billing.zzbw.zzk(), com.google.android.gms.internal.play_billing.zzbw.zzk()));
        return null;
    }

    public static /* synthetic */ void F(BillingClientImpl billingClientImpl, AcknowledgePurchaseResponseListener acknowledgePurchaseResponseListener) {
        zzjd zzjdVar = zzjd.EXECUTE_ASYNC_TIMEOUT;
        BillingResult billingResult = zzdc.f57561k;
        billingClientImpl.h1(zzjdVar, 3, billingResult);
        acknowledgePurchaseResponseListener.b(billingResult);
    }

    public static /* synthetic */ Object F1(BillingClientImpl billingClientImpl, AcknowledgePurchaseResponseListener acknowledgePurchaseResponseListener, AcknowledgePurchaseParams acknowledgePurchaseParams) {
        billingClientImpl.P(acknowledgePurchaseResponseListener, acknowledgePurchaseParams);
        return null;
    }

    public static /* synthetic */ Object G1(BillingClientImpl billingClientImpl, Bundle bundle, Activity activity, ResultReceiver resultReceiver) {
        billingClientImpl.R(bundle, activity, resultReceiver);
        return null;
    }

    public static /* synthetic */ void H(BillingClientImpl billingClientImpl, ProductDetailsResponseListener productDetailsResponseListener) {
        zzjd zzjdVar = zzjd.EXECUTE_ASYNC_TIMEOUT;
        BillingResult billingResult = zzdc.f57561k;
        billingClientImpl.h1(zzjdVar, 7, billingResult);
        productDetailsResponseListener.a(billingResult, new QueryProductDetailsResult(com.google.android.gms.internal.play_billing.zzbw.zzk(), com.google.android.gms.internal.play_billing.zzbw.zzk()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final /* synthetic */ Bundle H0(int i3, String str, String str2, BillingFlowParams billingFlowParams, Bundle bundle) {
        com.google.android.gms.internal.play_billing.zzap zzapVar;
        try {
            synchronized (this.f57164a) {
                zzapVar = this.f57172i;
            }
            return zzapVar == null ? com.google.android.gms.internal.play_billing.zzc.zzd(zzdc.f57560j, zzjd.SERVICE_RESET_TO_NULL) : zzapVar.zzg(i3, this.f57170g.getPackageName(), str, str2, null, bundle);
        } catch (DeadObjectException e3) {
            return com.google.android.gms.internal.play_billing.zzc.zze(zzdc.f57560j, zzjd.LAUNCH_BILLING_FLOW_EXCEPTION, zzcy.a(e3));
        } catch (Exception e4) {
            return com.google.android.gms.internal.play_billing.zzc.zze(zzdc.f57558h, zzjd.LAUNCH_BILLING_FLOW_EXCEPTION, zzcy.a(e4));
        }
    }

    public static /* synthetic */ Object H1(BillingClientImpl billingClientImpl, BillingConfigResponseListener billingConfigResponseListener) {
        billingClientImpl.Q(billingConfigResponseListener);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final /* synthetic */ Bundle I0(String str, String str2) {
        com.google.android.gms.internal.play_billing.zzap zzapVar;
        try {
            synchronized (this.f57164a) {
                zzapVar = this.f57172i;
            }
            return zzapVar == null ? com.google.android.gms.internal.play_billing.zzc.zzd(zzdc.f57560j, zzjd.SERVICE_RESET_TO_NULL) : zzapVar.zzf(3, this.f57170g.getPackageName(), str, str2, null);
        } catch (DeadObjectException e3) {
            return com.google.android.gms.internal.play_billing.zzc.zze(zzdc.f57560j, zzjd.LAUNCH_BILLING_FLOW_EXCEPTION, zzcy.a(e3));
        } catch (Exception e4) {
            return com.google.android.gms.internal.play_billing.zzc.zze(zzdc.f57558h, zzjd.LAUNCH_BILLING_FLOW_EXCEPTION, zzcy.a(e4));
        }
    }

    public static /* synthetic */ void J(BillingClientImpl billingClientImpl, BillingResult billingResult) {
        if (billingClientImpl.f57169f.f() != null) {
            billingClientImpl.f57169f.f().onPurchasesUpdated(billingResult, null);
        } else {
            com.google.android.gms.internal.play_billing.zzc.zzo("BillingClient", "No valid listener is set in BroadcastManager");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Handler J0() {
        return Looper.myLooper() == null ? this.f57168e : new Handler(Looper.myLooper());
    }

    private final zzcg K0(BillingResult billingResult, zzjd zzjdVar, String str, Exception exc) {
        com.google.android.gms.internal.play_billing.zzc.zzp("BillingClient", str, exc);
        j1(zzjdVar, 7, billingResult, zzcy.a(exc));
        return new zzcg(billingResult.c(), billingResult.a(), new ArrayList(), new ArrayList());
    }

    private final BillingResult L0(int i3) {
        com.google.android.gms.internal.play_billing.zzc.zzn("BillingClient", "Service connection is valid. No need to re-initialize.");
        zziy zziyVarZza = zzja.zza();
        zziyVarZza.zze(6);
        zzks zzksVarZza = zzku.zza();
        zzksVarZza.zze(true);
        zzksVarZza.zza(i3 > 0);
        zzksVarZza.zzb(i3);
        zziyVarZza.zzd(zzksVarZza);
        T0((zzja) zziyVarZza.zzi());
        return zzdc.f57559i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final BillingResult M0() {
        int[] iArr = {0, 3};
        synchronized (this.f57164a) {
            for (int i3 = 0; i3 < 2; i3++) {
                if (this.f57165b == iArr[i3]) {
                    return zzdc.f57560j;
                }
            }
            return zzdc.f57558h;
        }
    }

    private final com.google.android.gms.internal.play_billing.zzdc N0(final int i3) {
        if (this.F && !b1()) {
            return com.google.android.gms.internal.play_billing.zzu.zza(new com.google.android.gms.internal.play_billing.zzr() { // from class: com.android.billingclient.api.zzad
                @Override // com.google.android.gms.internal.play_billing.zzr
                public final Object zza(com.google.android.gms.internal.play_billing.zzp zzpVar) {
                    return BillingClientImpl.C1(this.f57379a, i3, zzpVar);
                }
            });
        }
        com.google.android.gms.internal.play_billing.zzc.zzn("BillingClient", "Already connected or not opted into auto reconnection.");
        return com.google.android.gms.internal.play_billing.zzcx.zza(zzdc.f57559i);
    }

    private final /* synthetic */ Object P(AcknowledgePurchaseResponseListener acknowledgePurchaseResponseListener, AcknowledgePurchaseParams acknowledgePurchaseParams) {
        com.google.android.gms.internal.play_billing.zzap zzapVar;
        try {
            if (!a1(30000L)) {
                zzjd zzjdVar = zzjd.SERVICE_CONNECTION_NOT_READY;
                BillingResult billingResult = zzdc.f57560j;
                h1(zzjdVar, 3, billingResult);
                acknowledgePurchaseResponseListener.b(billingResult);
            } else if (TextUtils.isEmpty(acknowledgePurchaseParams.a())) {
                com.google.android.gms.internal.play_billing.zzc.zzo("BillingClient", "Please provide a valid purchase token.");
                zzjd zzjdVar2 = zzjd.EMPTY_PURCHASE_TOKEN;
                BillingResult billingResult2 = zzdc.f57557g;
                h1(zzjdVar2, 3, billingResult2);
                acknowledgePurchaseResponseListener.b(billingResult2);
            } else if (this.f57179p) {
                synchronized (this.f57164a) {
                    zzapVar = this.f57172i;
                }
                if (zzapVar != null) {
                    String packageName = this.f57170g.getPackageName();
                    String strA = acknowledgePurchaseParams.a();
                    String str = this.f57166c;
                    String str2 = this.f57167d;
                    long jLongValue = this.J.longValue();
                    int i3 = com.google.android.gms.internal.play_billing.zzc.zza;
                    Bundle bundle = new Bundle();
                    com.google.android.gms.internal.play_billing.zzc.zzc(bundle, str, str2, jLongValue);
                    Bundle bundleZzd = zzapVar.zzd(9, packageName, strA, bundle);
                    acknowledgePurchaseResponseListener.b(zzdc.a(com.google.android.gms.internal.play_billing.zzc.zzb(bundleZzd, "BillingClient"), com.google.android.gms.internal.play_billing.zzc.zzk(bundleZzd, "BillingClient")));
                    return null;
                }
                d0(acknowledgePurchaseResponseListener, zzdc.f57560j, zzjd.SERVICE_RESET_TO_NULL, null);
            } else {
                zzjd zzjdVar3 = zzjd.API_VERSION_NOT_V9;
                BillingResult billingResult3 = zzdc.f57551a;
                h1(zzjdVar3, 3, billingResult3);
                acknowledgePurchaseResponseListener.b(billingResult3);
            }
            return null;
        } catch (DeadObjectException e3) {
            d0(acknowledgePurchaseResponseListener, zzdc.f57560j, zzjd.ACKNOWLEDGE_PURCHASE_SERVICE_CALL_EXCEPTION, e3);
            return null;
        } catch (Exception e4) {
            d0(acknowledgePurchaseResponseListener, zzdc.f57558h, zzjd.ACKNOWLEDGE_PURCHASE_SERVICE_CALL_EXCEPTION, e4);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void P0(AlternativeBillingOnlyInformationDialogListener alternativeBillingOnlyInformationDialogListener, BillingResult billingResult, zzjd zzjdVar, Exception exc) {
        j1(zzjdVar, 16, billingResult, zzcy.a(exc));
        alternativeBillingOnlyInformationDialogListener.a(billingResult);
    }

    private final /* synthetic */ Object Q(BillingConfigResponseListener billingConfigResponseListener) {
        com.google.android.gms.internal.play_billing.zzap zzapVar;
        zzch zzchVar = null;
        try {
            if (!a1(30000L)) {
                com.google.android.gms.internal.play_billing.zzc.zzo("BillingClient", "Service disconnected.");
                zzjd zzjdVar = zzjd.SERVICE_CONNECTION_NOT_READY;
                BillingResult billingResult = zzdc.f57560j;
                h1(zzjdVar, 13, billingResult);
                billingConfigResponseListener.a(billingResult, null);
            } else if (this.f57185v) {
                synchronized (this.f57164a) {
                    zzapVar = this.f57172i;
                }
                if (zzapVar == null) {
                    m0(billingConfigResponseListener, zzdc.f57560j, zzjd.SERVICE_RESET_TO_NULL, null);
                } else {
                    String packageName = this.f57170g.getPackageName();
                    String str = this.f57166c;
                    String str2 = this.f57167d;
                    long jLongValue = this.J.longValue();
                    int i3 = com.google.android.gms.internal.play_billing.zzc.zza;
                    Bundle bundle = new Bundle();
                    com.google.android.gms.internal.play_billing.zzc.zzc(bundle, str, str2, jLongValue);
                    zzapVar.zzo(18, packageName, bundle, new zzca(billingConfigResponseListener, this.f57171h, this.f57176m, zzchVar));
                }
            } else {
                com.google.android.gms.internal.play_billing.zzc.zzo("BillingClient", "Current client doesn't support get billing config.");
                zzjd zzjdVar2 = zzjd.GET_BILLING_CONFIG_NOT_SUPPORTED;
                BillingResult billingResult2 = zzdc.f57575y;
                h1(zzjdVar2, 13, billingResult2);
                billingConfigResponseListener.a(billingResult2, null);
            }
        } catch (DeadObjectException e3) {
            m0(billingConfigResponseListener, zzdc.f57560j, zzjd.GET_BILLING_CONFIG_SERVICE_CALL_EXCEPTION, e3);
        } catch (Exception e4) {
            m0(billingConfigResponseListener, zzdc.f57558h, zzjd.GET_BILLING_CONFIG_SERVICE_CALL_EXCEPTION, e4);
        }
        return null;
    }

    private final void Q0(int i3, zzjd zzjdVar, Exception exc) {
        zziw zziwVar;
        com.google.android.gms.internal.play_billing.zzc.zzp("BillingClient", "showInAppMessages error.", exc);
        zzcz zzczVar = this.f57171h;
        String strA = zzcy.a(exc);
        try {
            zzjb zzjbVarZza = zzjf.zza();
            zzjbVarZza.zzp(i3);
            if (zzjdVar != null) {
                zzjbVarZza.zze(zzjdVar);
            }
            if (strA != null) {
                zzjbVarZza.zza(strA);
            }
            zziu zziuVarZza = zziw.zza();
            zziuVarZza.zzb(zzjbVarZza);
            zziuVarZza.zzp(30);
            zziwVar = (zziw) zziuVarZza.zzi();
        } catch (Throwable th) {
            com.google.android.gms.internal.play_billing.zzc.zzp("BillingLogger", "Unable to create logging payload", th);
            zziwVar = null;
        }
        zzczVar.k(zziwVar);
    }

    private final /* synthetic */ Object R(Bundle bundle, Activity activity, ResultReceiver resultReceiver) {
        com.google.android.gms.internal.play_billing.zzap zzapVar;
        try {
            synchronized (this.f57164a) {
                zzapVar = this.f57172i;
            }
            if (zzapVar == null) {
                Q0(-1, zzjd.SERVICE_RESET_TO_NULL, null);
            } else {
                zzapVar.zzs(12, this.f57170g.getPackageName(), bundle, new zzcf(new WeakReference(activity), resultReceiver, null));
            }
        } catch (DeadObjectException e3) {
            Q0(-1, zzjd.SERVICE_CALL_EXCEPTION, e3);
        } catch (Exception e4) {
            Q0(6, zzjd.SERVICE_CALL_EXCEPTION, e4);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void R0(zziw zziwVar) {
        try {
            this.f57171h.f(zziwVar, this.f57176m);
        } catch (Throwable th) {
            com.google.android.gms.internal.play_billing.zzc.zzp("BillingClient", "Unable to log.", th);
        }
    }

    private final String S(QueryProductDetailsParams queryProductDetailsParams) {
        if (TextUtils.isEmpty(null)) {
            return this.f57170g.getPackageName();
        }
        return null;
    }

    private final void S0(zziw zziwVar, long j3, boolean z2) {
        try {
            this.f57171h.j(zziwVar, this.f57176m, j3, z2);
        } catch (Throwable th) {
            com.google.android.gms.internal.play_billing.zzc.zzp("BillingClient", "Unable to log.", th);
        }
    }

    private static String T() {
        try {
            return (String) Class.forName("com.android.billingclient.ktx.BuildConfig").getField("VERSION_NAME").get(null);
        } catch (Exception unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void T0(zzja zzjaVar) {
        try {
            this.f57171h.a(zzjaVar, this.f57176m);
        } catch (Throwable th) {
            com.google.android.gms.internal.play_billing.zzc.zzp("BillingClient", "Unable to log.", th);
        }
    }

    private final /* synthetic */ Void U(AlternativeBillingOnlyReportingDetailsListener alternativeBillingOnlyReportingDetailsListener) {
        com.google.android.gms.internal.play_billing.zzap zzapVar;
        zzch zzchVar = null;
        try {
            if (!a1(30000L)) {
                h0(alternativeBillingOnlyReportingDetailsListener, zzdc.f57560j, zzjd.SERVICE_CONNECTION_NOT_READY, null);
            } else if (this.f57188y) {
                synchronized (this.f57164a) {
                    zzapVar = this.f57172i;
                }
                if (zzapVar == null) {
                    h0(alternativeBillingOnlyReportingDetailsListener, zzdc.f57560j, zzjd.SERVICE_RESET_TO_NULL, null);
                } else {
                    zzapVar.zzk(21, this.f57170g.getPackageName(), com.google.android.gms.internal.play_billing.zzc.zzh(this.f57166c, this.f57167d, this.J.longValue()), new zzbx(alternativeBillingOnlyReportingDetailsListener, this.f57171h, this.f57176m, zzchVar));
                }
            } else {
                com.google.android.gms.internal.play_billing.zzc.zzo("BillingClient", "Current client doesn't support alternative billing only.");
                h0(alternativeBillingOnlyReportingDetailsListener, zzdc.C, zzjd.ALTERNATIVE_BILLING_ONLY_NOT_SUPPORTED, null);
            }
        } catch (DeadObjectException e3) {
            h0(alternativeBillingOnlyReportingDetailsListener, zzdc.f57560j, zzjd.CREATE_ALTERNATIVE_BILLING_ONLY_TOKEN_SERVICE_CALL_EXCEPTION, e3);
        } catch (Exception e4) {
            h0(alternativeBillingOnlyReportingDetailsListener, zzdc.f57558h, zzjd.CREATE_ALTERNATIVE_BILLING_ONLY_TOKEN_SERVICE_CALL_EXCEPTION, e4);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void U0(zzjd zzjdVar, BillingResult billingResult, int i3) {
        try {
            int i4 = zzcy.f57549a;
            zziu zziuVar = (zziu) zzcy.b(zzjdVar, 6, billingResult, null, zzjk.BROADCAST_ACTION_UNSPECIFIED).zzq();
            zzks zzksVarZza = zzku.zza();
            zzksVarZza.zza(i3 > 0);
            zzksVarZza.zzb(i3);
            zziuVar.zze(zzksVarZza);
            R0((zziw) zziuVar.zzi());
        } catch (Throwable th) {
            com.google.android.gms.internal.play_billing.zzc.zzp("BillingClient", "Unable to log.", th);
        }
    }

    private final /* synthetic */ Void V(BillingProgramReportingDetailsListener billingProgramReportingDetailsListener, BillingProgramReportingDetailsParams billingProgramReportingDetailsParams) throws RemoteException {
        BillingProgramReportingDetailsListener billingProgramReportingDetailsListener2;
        BillingProgramReportingDetailsListener billingProgramReportingDetailsListener3;
        RuntimeException runtimeException;
        com.google.android.gms.internal.play_billing.zzap zzapVar;
        try {
        } catch (DeadObjectException e3) {
            e = e3;
            billingProgramReportingDetailsListener3 = billingProgramReportingDetailsListener;
        } catch (RuntimeException e4) {
            e = e4;
            billingProgramReportingDetailsListener2 = billingProgramReportingDetailsListener;
        }
        try {
            if (!a1(30000L)) {
                i0(billingProgramReportingDetailsListener, zzdc.f57560j, zzjd.SERVICE_CONNECTION_NOT_READY, null);
            } else if (this.D) {
                synchronized (this.f57164a) {
                    try {
                        try {
                            zzapVar = this.f57172i;
                        } finally {
                            th = th;
                            while (true) {
                                Throwable th = th;
                                try {
                                } catch (Throwable th2) {
                                    th = th2;
                                }
                            }
                        }
                    } catch (DeadObjectException e5) {
                        e = e5;
                        i0(billingProgramReportingDetailsListener3, zzdc.f57560j, zzjd.SERVICE_CALL_EXCEPTION, deadObjectException);
                    } catch (RuntimeException e6) {
                        e = e6;
                        runtimeException = e;
                        i0(billingProgramReportingDetailsListener2, zzdc.f57558h, zzjd.SERVICE_CALL_EXCEPTION, runtimeException);
                    }
                }
                if (zzapVar == null) {
                    i0(billingProgramReportingDetailsListener, zzdc.f57560j, zzjd.SERVICE_RESET_TO_NULL, null);
                } else {
                    String str = this.f57166c;
                    com.google.android.gms.internal.play_billing.zzdy zzdyVarB = zzdg.b(str, 24, this.f57170g, zzdf.CREATE_BILLING_PROGRAM_REPORTING_DETAILS_ASYNC.a());
                    zzhu zzhuVarZza = zzhx.zza();
                    zzio zzioVarZza = zziq.zza();
                    zzioVarZza.zza(str);
                    zzhuVarZza.zza("PLAY_BILLING_LIBRARY_VERSION", (zziq) zzioVarZza.zzi());
                    zzio zzioVarZza2 = zziq.zza();
                    zzioVarZza2.zza(this.f57170g.getPackageName());
                    zzhuVarZza.zza("CALLING_PACKAGE", (zziq) zzioVarZza2.zzi());
                    zzio zzioVarZza3 = zziq.zza();
                    zzioVarZza3.zza(String.valueOf(billingProgramReportingDetailsParams.a()));
                    zzhuVarZza.zza("BILLING_PROGRAM", (zziq) zzioVarZza3.zzi());
                    zzio zzioVarZza4 = zziq.zza();
                    zzioVarZza4.zza("RESPONSE_FORMAT_PROTO");
                    zzhuVarZza.zza("RESPONSE_FORMAT", (zziq) zzioVarZza4.zzi());
                    if (billingProgramReportingDetailsParams.a() == 3) {
                        zzio zzioVarZza5 = zziq.zza();
                        zzioVarZza5.zza(String.valueOf(this.f57170g.getPackageManager().getPackageInfo(this.f57170g.getPackageName(), 0).firstInstallTime));
                        zzhuVarZza.zza("APP_INSTALL_TIME_MILLIS", (zziq) zzioVarZza5.zzi());
                    }
                    zzapVar.zzm(zzdg.a(zzdyVarB, (zzhx) zzhuVarZza.zzi()), new CreateBillingProgramReportingDetailsDelegateToBackendCallback(billingProgramReportingDetailsListener, billingProgramReportingDetailsParams.a(), this.f57171h, this.f57176m, J0(), x()));
                }
            } else {
                com.google.android.gms.internal.play_billing.zzc.zzo("BillingClient", "Current client doesn't support the provided billing program.");
                i0(billingProgramReportingDetailsListener, zzdc.F, zzjd.BILLING_PROGRAM_NOT_SUPPORTED, null);
            }
        } catch (DeadObjectException e7) {
            DeadObjectException deadObjectException = e7;
            billingProgramReportingDetailsListener3 = billingProgramReportingDetailsListener;
            i0(billingProgramReportingDetailsListener3, zzdc.f57560j, zzjd.SERVICE_CALL_EXCEPTION, deadObjectException);
        } catch (RuntimeException e8) {
            runtimeException = e8;
            billingProgramReportingDetailsListener2 = billingProgramReportingDetailsListener;
            i0(billingProgramReportingDetailsListener2, zzdc.f57558h, zzjd.SERVICE_CALL_EXCEPTION, runtimeException);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void V0(int i3) {
        synchronized (this.f57164a) {
            try {
                if (this.f57165b == 3) {
                    return;
                }
                com.google.android.gms.internal.play_billing.zzc.zzn("BillingClient", "Setting clientState from " + c1(this.f57165b) + " to " + c1(i3));
                this.f57165b = i3;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private final synchronized void W0() {
        ExecutorService executorService = this.I;
        if (executorService != null) {
            executorService.shutdownNow();
            this.I = null;
        }
    }

    private final /* synthetic */ Void X(AlternativeBillingOnlyAvailabilityListener alternativeBillingOnlyAvailabilityListener) {
        com.google.android.gms.internal.play_billing.zzap zzapVar;
        zzch zzchVar = null;
        try {
            if (!a1(30000L)) {
                e0(alternativeBillingOnlyAvailabilityListener, zzdc.f57560j, zzjd.SERVICE_CONNECTION_NOT_READY, null);
            } else if (this.f57188y) {
                synchronized (this.f57164a) {
                    zzapVar = this.f57172i;
                }
                if (zzapVar == null) {
                    e0(alternativeBillingOnlyAvailabilityListener, zzdc.f57560j, zzjd.SERVICE_RESET_TO_NULL, null);
                } else {
                    zzapVar.zzq(21, this.f57170g.getPackageName(), com.google.android.gms.internal.play_billing.zzc.zzh(this.f57166c, this.f57167d, this.J.longValue()), new zzcd(alternativeBillingOnlyAvailabilityListener, this.f57171h, this.f57176m, zzchVar));
                }
            } else {
                com.google.android.gms.internal.play_billing.zzc.zzo("BillingClient", "Current client doesn't support alternative billing only.");
                e0(alternativeBillingOnlyAvailabilityListener, zzdc.C, zzjd.ALTERNATIVE_BILLING_ONLY_NOT_SUPPORTED, null);
            }
        } catch (DeadObjectException e3) {
            e0(alternativeBillingOnlyAvailabilityListener, zzdc.f57560j, zzjd.IS_ALTERNATIVE_BILLING_ONLY_AVAILABLE_SERVICE_CALL_EXCEPTION, e3);
        } catch (Exception e4) {
            e0(alternativeBillingOnlyAvailabilityListener, zzdc.f57558h, zzjd.IS_ALTERNATIVE_BILLING_ONLY_AVAILABLE_SERVICE_CALL_EXCEPTION, e4);
        }
        return null;
    }

    private final void X0(BillingClientStateListener billingClientStateListener, int i3) {
        zzjd zzjdVar;
        BillingResult billingResultL0;
        BillingResult billingResult;
        synchronized (this.f57164a) {
            try {
                if (b1()) {
                    billingResultL0 = L0(i3);
                } else {
                    if (this.f57165b == 1) {
                        com.google.android.gms.internal.play_billing.zzc.zzo("BillingClient", "Client is already in the process of connecting to billing service.");
                        zzjd zzjdVar2 = zzjd.BILLING_CLIENT_CONNECTING;
                        billingResult = zzdc.f57554d;
                        U0(zzjdVar2, billingResult, i3);
                    } else if (this.f57165b == 3) {
                        com.google.android.gms.internal.play_billing.zzc.zzo("BillingClient", "Client was already closed and can't be reused. Please create another instance.");
                        zzjd zzjdVar3 = zzjd.BILLING_CLIENT_CLOSED;
                        billingResult = zzdc.f57560j;
                        U0(zzjdVar3, billingResult, i3);
                    } else {
                        V0(1);
                        if (i3 == 0) {
                            this.H = billingClientStateListener;
                            i3 = 0;
                        }
                        Y0();
                        com.google.android.gms.internal.play_billing.zzc.zzn("BillingClient", "Starting in-app billing setup.");
                        this.f57173j = new zzbw(this, billingClientStateListener, i3, null);
                        this.f57173j.c();
                        Intent intent = new Intent("com.android.vending.billing.InAppBillingService.BIND");
                        intent.setPackage("com.android.vending");
                        List<ResolveInfo> listQueryIntentServices = this.f57170g.getPackageManager().queryIntentServices(intent, 0);
                        if (listQueryIntentServices == null || listQueryIntentServices.isEmpty()) {
                            zzjdVar = zzjd.INTENT_SERVICE_NOT_FOUND;
                        } else {
                            ServiceInfo serviceInfo = listQueryIntentServices.get(0).serviceInfo;
                            if (serviceInfo != null) {
                                String str = serviceInfo.packageName;
                                String str2 = serviceInfo.name;
                                if (!Objects.equals(str, "com.android.vending") || str2 == null) {
                                    zzjdVar = zzjd.INVALID_PHONESKY_PACKAGE;
                                    com.google.android.gms.internal.play_billing.zzc.zzo("BillingClient", "The device doesn't have valid Play Store.");
                                } else {
                                    ComponentName componentName = new ComponentName(str, str2);
                                    Intent intent2 = new Intent(intent);
                                    intent2.setComponent(componentName);
                                    intent2.putExtra("playBillingLibraryVersion", this.f57166c);
                                    synchronized (this.f57164a) {
                                        try {
                                            if (this.f57165b == 2) {
                                                billingResultL0 = L0(i3);
                                            } else if (this.f57165b != 1) {
                                                com.google.android.gms.internal.play_billing.zzc.zzo("BillingClient", "Client state no longer CONNECTING, returning service disconnected.");
                                                zzjd zzjdVar4 = zzjd.BILLING_CLIENT_TRANSITIONED_OUT_OF_CONNECTING;
                                                billingResult = zzdc.f57560j;
                                                U0(zzjdVar4, billingResult, i3);
                                            } else {
                                                zzbw zzbwVar = this.f57173j;
                                                if ((i3 <= 0 || Build.VERSION.SDK_INT < 29) ? this.f57170g.bindService(intent2, zzbwVar, 1) : this.f57170g.bindService(intent2, 1, x(), zzbwVar)) {
                                                    com.google.android.gms.internal.play_billing.zzc.zzn("BillingClient", "Service was bonded successfully.");
                                                    billingResultL0 = null;
                                                } else {
                                                    zzjdVar = zzjd.BILLING_SERVICE_BLOCKED;
                                                    com.google.android.gms.internal.play_billing.zzc.zzo("BillingClient", "Connection to Billing service is blocked.");
                                                }
                                            }
                                        } finally {
                                        }
                                    }
                                }
                            } else {
                                zzjdVar = zzjd.INVALID_PHONESKY_PACKAGE;
                                com.google.android.gms.internal.play_billing.zzc.zzo("BillingClient", "The device doesn't have valid Play Store.");
                            }
                        }
                        V0(0);
                        com.google.android.gms.internal.play_billing.zzc.zzn("BillingClient", "Billing service unavailable on device.");
                        BillingResult billingResult2 = zzdc.f57552b;
                        U0(zzjdVar, billingResult2, i3);
                        billingResultL0 = billingResult2;
                    }
                    billingResultL0 = billingResult;
                }
            } finally {
            }
        }
        if (billingResultL0 != null) {
            billingClientStateListener.onBillingSetupFinished(billingResultL0);
        }
    }

    private final /* synthetic */ Void Y(BillingProgramAvailabilityListener billingProgramAvailabilityListener, int i3) {
        BillingClientImpl billingClientImpl;
        BillingProgramAvailabilityListener billingProgramAvailabilityListener2;
        int i4;
        com.google.android.gms.internal.play_billing.zzap zzapVar;
        try {
            try {
                if (a1(30000L)) {
                    billingClientImpl = this;
                    billingProgramAvailabilityListener2 = billingProgramAvailabilityListener;
                    i4 = i3;
                    try {
                        if (!billingClientImpl.D) {
                            com.google.android.gms.internal.play_billing.zzc.zzo("BillingClient", "Current client doesn't support the provided billing program.");
                            billingClientImpl.f0(billingProgramAvailabilityListener2, i4, zzdc.F, zzjd.BILLING_PROGRAM_NOT_SUPPORTED, null);
                            return null;
                        }
                        synchronized (billingClientImpl.f57164a) {
                            zzapVar = billingClientImpl.f57172i;
                        }
                        if (zzapVar == null) {
                            billingClientImpl.f0(billingProgramAvailabilityListener2, i4, zzdc.f57560j, zzjd.SERVICE_RESET_TO_NULL, null);
                            return null;
                        }
                        String str = billingClientImpl.f57166c;
                        com.google.android.gms.internal.play_billing.zzdy zzdyVarB = zzdg.b(str, 24, billingClientImpl.f57170g, zzdf.IS_BILLING_PROGRAM_AVAILABLE_ASYNC.a());
                        zzhu zzhuVarZza = zzhx.zza();
                        zzio zzioVarZza = zziq.zza();
                        zzioVarZza.zza(str);
                        zzhuVarZza.zza("PLAY_BILLING_LIBRARY_VERSION", (zziq) zzioVarZza.zzi());
                        zzio zzioVarZza2 = zziq.zza();
                        zzioVarZza2.zza(billingClientImpl.f57170g.getPackageName());
                        zzhuVarZza.zza("CALLING_PACKAGE", (zziq) zzioVarZza2.zzi());
                        zzio zzioVarZza3 = zziq.zza();
                        zzioVarZza3.zza(String.valueOf(i4));
                        zzhuVarZza.zza("BILLING_PROGRAM", (zziq) zzioVarZza3.zzi());
                        try {
                            zzapVar.zzm(zzdg.a(zzdyVarB, (zzhx) zzhuVarZza.zzi()), new IsBillingProgramAvailableDelegateToBackendCallback(billingProgramAvailabilityListener2, i4, billingClientImpl.f57171h, billingClientImpl.f57176m, J0(), x()));
                            return null;
                        } catch (DeadObjectException e3) {
                            e = e3;
                            billingProgramAvailabilityListener2 = billingProgramAvailabilityListener2;
                            i4 = i4;
                            f0(billingProgramAvailabilityListener2, i4, zzdc.f57560j, zzjd.GET_BILLING_CONFIG_SERVICE_CALL_EXCEPTION, e);
                            return null;
                        } catch (Exception e4) {
                            e = e4;
                            billingProgramAvailabilityListener2 = billingProgramAvailabilityListener2;
                            i4 = i4;
                        }
                    } catch (DeadObjectException e5) {
                        e = e5;
                    } catch (Exception e6) {
                        e = e6;
                    }
                } else {
                    try {
                    } catch (DeadObjectException e7) {
                        e = e7;
                        billingProgramAvailabilityListener2 = billingProgramAvailabilityListener;
                        i4 = i3;
                        f0(billingProgramAvailabilityListener2, i4, zzdc.f57560j, zzjd.GET_BILLING_CONFIG_SERVICE_CALL_EXCEPTION, e);
                        return null;
                    }
                    try {
                        f0(billingProgramAvailabilityListener, i3, zzdc.f57560j, zzjd.SERVICE_CONNECTION_NOT_READY, null);
                        return null;
                    } catch (DeadObjectException e8) {
                        e = e8;
                        billingProgramAvailabilityListener2 = billingProgramAvailabilityListener;
                        i4 = i3;
                        f0(billingProgramAvailabilityListener2, i4, zzdc.f57560j, zzjd.GET_BILLING_CONFIG_SERVICE_CALL_EXCEPTION, e);
                        return null;
                    } catch (Exception e9) {
                        e = e9;
                        billingClientImpl = this;
                        billingProgramAvailabilityListener2 = billingProgramAvailabilityListener;
                        i4 = i3;
                    }
                }
            } catch (DeadObjectException e10) {
                e = e10;
            }
        } catch (Exception e11) {
            e = e11;
            billingClientImpl = this;
            billingProgramAvailabilityListener2 = billingProgramAvailabilityListener;
            i4 = i3;
        }
        billingClientImpl.f0(billingProgramAvailabilityListener2, i4, zzdc.f57558h, zzjd.SERVICE_CALL_EXCEPTION, e);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final void Y0() {
        synchronized (this.f57164a) {
            if (this.f57173j != null) {
                try {
                    this.f57170g.unbindService(this.f57173j);
                } catch (Throwable th) {
                    try {
                        com.google.android.gms.internal.play_billing.zzc.zzp("BillingClient", "There was an exception while unbinding service!", th);
                        this.f57172i = null;
                        this.f57173j = null;
                    } finally {
                        this.f57172i = null;
                        this.f57173j = null;
                    }
                }
            }
        }
    }

    private final /* synthetic */ Void Z(ExternalOfferAvailabilityListener externalOfferAvailabilityListener) {
        com.google.android.gms.internal.play_billing.zzap zzapVar;
        zzch zzchVar = null;
        try {
            if (!a1(30000L)) {
                k0(externalOfferAvailabilityListener, zzdc.f57560j, zzjd.SERVICE_CONNECTION_NOT_READY, null);
            } else if (this.B) {
                synchronized (this.f57164a) {
                    zzapVar = this.f57172i;
                }
                if (zzapVar == null) {
                    k0(externalOfferAvailabilityListener, zzdc.f57560j, zzjd.SERVICE_RESET_TO_NULL, null);
                } else {
                    zzapVar.zzr(24, this.f57170g.getPackageName(), com.google.android.gms.internal.play_billing.zzc.zzh(this.f57166c, this.f57167d, this.J.longValue()), new zzce(externalOfferAvailabilityListener, this.f57171h, this.f57176m, zzchVar));
                }
            } else {
                com.google.android.gms.internal.play_billing.zzc.zzo("BillingClient", "Current client doesn't support external offer.");
                k0(externalOfferAvailabilityListener, zzdc.f57570t, zzjd.EXTERNAL_OFFER_NOT_SUPPORTED, null);
            }
        } catch (DeadObjectException e3) {
            k0(externalOfferAvailabilityListener, zzdc.f57560j, zzjd.IS_EXTERNAL_PAYMENT_AVAILABLE_SERVICE_CALL_EXCEPTION, e3);
        } catch (Exception e4) {
            k0(externalOfferAvailabilityListener, zzdc.f57558h, zzjd.IS_EXTERNAL_PAYMENT_AVAILABLE_SERVICE_CALL_EXCEPTION, e4);
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final boolean Z0(long j3) {
        try {
            BillingResult billingResult = (BillingResult) N0(1).get(Build.VERSION.SDK_INT < 29 ? 0L : 3000L, TimeUnit.MILLISECONDS);
            if (billingResult.c() == 0) {
                com.google.android.gms.internal.play_billing.zzc.zzn("BillingClient", "Reconnection succeeded with result: " + billingResult.c());
            } else {
                com.google.android.gms.internal.play_billing.zzc.zzo("BillingClient", "Reconnection failed with result: " + billingResult.c());
            }
        } catch (Exception e3) {
            if (e3 instanceof InterruptedException) {
                Thread.currentThread().interrupt();
            }
            com.google.android.gms.internal.play_billing.zzc.zzp("BillingClient", "Error during reconnection attempt: ", e3);
        }
        return b1();
    }

    private final /* synthetic */ Void a0(AlternativeBillingOnlyInformationDialogListener alternativeBillingOnlyInformationDialogListener, Activity activity, ResultReceiver resultReceiver) {
        com.google.android.gms.internal.play_billing.zzap zzapVar;
        try {
            synchronized (this.f57164a) {
                zzapVar = this.f57172i;
            }
            if (zzapVar == null) {
                P0(alternativeBillingOnlyInformationDialogListener, zzdc.f57560j, zzjd.SERVICE_RESET_TO_NULL, null);
            } else {
                zzapVar.zzn(21, this.f57170g.getPackageName(), com.google.android.gms.internal.play_billing.zzc.zzh(this.f57166c, this.f57167d, this.J.longValue()), new zzbz(new WeakReference(activity), resultReceiver, null));
            }
        } catch (DeadObjectException e3) {
            P0(alternativeBillingOnlyInformationDialogListener, zzdc.f57560j, zzjd.SHOW_ALTERNATIVE_BILLING_ONLY_DIALOG_SERVICE_CALL_EXCEPTION, e3);
        } catch (Exception e4) {
            P0(alternativeBillingOnlyInformationDialogListener, zzdc.f57558h, zzjd.SHOW_ALTERNATIVE_BILLING_ONLY_DIALOG_SERVICE_CALL_EXCEPTION, e4);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final boolean a1(long j3) {
        long jMax;
        com.google.android.gms.internal.play_billing.zzbl zzblVarZzb = com.google.android.gms.internal.play_billing.zzbl.zzb(this.K);
        long jZza = 30000;
        for (int i3 = 1; i3 <= 3; i3++) {
            try {
                jMax = Math.max(0L, jZza);
            } catch (Exception e3) {
                if (e3 instanceof InterruptedException) {
                    Thread.currentThread().interrupt();
                }
                com.google.android.gms.internal.play_billing.zzc.zzp("BillingClient", "Error during reconnection attempt: ", e3);
            }
            if (jMax <= 0) {
                com.google.android.gms.internal.play_billing.zzc.zzo("BillingClient", "No time remaining for reconnection attempt.");
                return b1();
            }
            BillingResult billingResult = (BillingResult) N0(i3).get(jMax, TimeUnit.MILLISECONDS);
            if (billingResult.c() == 0) {
                com.google.android.gms.internal.play_billing.zzc.zzn("BillingClient", "Reconnection succeeded with result: " + billingResult.c());
                return b1();
            }
            com.google.android.gms.internal.play_billing.zzc.zzo("BillingClient", "Reconnection failed with result: " + billingResult.c());
            TimeUnit timeUnit = TimeUnit.MILLISECONDS;
            jZza = 30000 - zzblVarZzb.zza(timeUnit);
            long jPow = ((long) Math.pow(2.0d, i3 - 1)) * 1000;
            if (jZza < jPow) {
                com.google.android.gms.internal.play_billing.zzc.zzo("BillingClient", "Reconnection failed due to timeout limit reached.");
                return b1();
            }
            if (i3 < 3 && jPow > 0) {
                try {
                    Thread.sleep(jPow);
                    jZza = 30000 - zzblVarZzb.zza(timeUnit);
                } catch (InterruptedException e4) {
                    Thread.currentThread().interrupt();
                    com.google.android.gms.internal.play_billing.zzc.zzp("BillingClient", "Error sleeping during reconnection attempt: ", e4);
                }
            }
        }
        com.google.android.gms.internal.play_billing.zzc.zzo("BillingClient", "Max retries reached.");
        return b1();
    }

    private final /* synthetic */ Void b0(ExternalOfferInformationDialogListener externalOfferInformationDialogListener, Activity activity, ResultReceiver resultReceiver) {
        com.google.android.gms.internal.play_billing.zzap zzapVar;
        try {
            synchronized (this.f57164a) {
                zzapVar = this.f57172i;
            }
            if (zzapVar == null) {
                l0(externalOfferInformationDialogListener, zzdc.f57560j, zzjd.SERVICE_RESET_TO_NULL, null);
            } else {
                zzapVar.zzp(22, this.f57170g.getPackageName(), com.google.android.gms.internal.play_billing.zzc.zzh(this.f57166c, this.f57167d, this.J.longValue()), new zzcb(new WeakReference(activity), resultReceiver, null));
            }
        } catch (DeadObjectException e3) {
            l0(externalOfferInformationDialogListener, zzdc.f57560j, zzjd.SHOW_EXTERNAL_PAYMENT_DIALOG_SERVICE_CALL_EXCEPTION, e3);
        } catch (Exception e4) {
            l0(externalOfferInformationDialogListener, zzdc.f57558h, zzjd.SHOW_EXTERNAL_PAYMENT_DIALOG_SERVICE_CALL_EXCEPTION, e4);
        }
        return null;
    }

    private final boolean b1() {
        boolean z2;
        synchronized (this.f57164a) {
            try {
                z2 = false;
                if (this.f57165b == 2 && this.f57172i != null && this.f57173j != null) {
                    z2 = true;
                }
            } finally {
            }
        }
        return z2;
    }

    /* JADX WARN: Finally extract failed */
    private final void c0(ConsumeParams consumeParams, ConsumeResponseListener consumeResponseListener) throws Throwable {
        com.google.android.gms.internal.play_billing.zzap zzapVar;
        int iZza;
        String strZzk;
        String strA = consumeParams.a();
        try {
            com.google.android.gms.internal.play_billing.zzc.zzn("BillingClient", "Consuming purchase with token: " + strA);
            synchronized (this.f57164a) {
                try {
                    try {
                        zzapVar = this.f57172i;
                    } catch (Throwable th) {
                        th = th;
                        while (true) {
                            try {
                                throw th;
                            } catch (Throwable th2) {
                                th = th2;
                            }
                        }
                    }
                } catch (DeadObjectException e3) {
                    e = e3;
                    g0(consumeResponseListener, strA, zzdc.f57560j, zzjd.CONSUME_PURCHASE_SERVICE_CALL_EXCEPTION, "Error consuming purchase!", e);
                    return;
                } catch (Exception e4) {
                    e = e4;
                    g0(consumeResponseListener, strA, zzdc.f57558h, zzjd.CONSUME_PURCHASE_SERVICE_CALL_EXCEPTION, "Error consuming purchase!", e);
                    return;
                }
            }
            if (zzapVar == null) {
                try {
                    g0(consumeResponseListener, strA, zzdc.f57560j, zzjd.SERVICE_RESET_TO_NULL, "Service has been reset to null.", null);
                    return;
                } catch (DeadObjectException e5) {
                    e = e5;
                    g0(consumeResponseListener, strA, zzdc.f57560j, zzjd.CONSUME_PURCHASE_SERVICE_CALL_EXCEPTION, "Error consuming purchase!", e);
                    return;
                } catch (Exception e6) {
                    e = e6;
                    g0(consumeResponseListener, strA, zzdc.f57558h, zzjd.CONSUME_PURCHASE_SERVICE_CALL_EXCEPTION, "Error consuming purchase!", e);
                    return;
                }
            }
            if (this.f57179p) {
                String packageName = this.f57170g.getPackageName();
                boolean z2 = this.f57179p;
                String str = this.f57166c;
                String str2 = this.f57167d;
                long jLongValue = this.J.longValue();
                Bundle bundle = new Bundle();
                if (z2) {
                    com.google.android.gms.internal.play_billing.zzc.zzc(bundle, str, str2, jLongValue);
                }
                Bundle bundleZze = zzapVar.zze(9, packageName, strA, bundle);
                iZza = bundleZze.getInt("RESPONSE_CODE");
                strZzk = com.google.android.gms.internal.play_billing.zzc.zzk(bundleZze, "BillingClient");
            } else {
                iZza = zzapVar.zza(3, this.f57170g.getPackageName(), strA);
                strZzk = "";
            }
            BillingResult billingResultA = zzdc.a(iZza, strZzk);
            if (iZza == 0) {
                com.google.android.gms.internal.play_billing.zzc.zzn("BillingClient", "Successfully consumed purchase.");
                consumeResponseListener.c(billingResultA, strA);
                return;
            }
            g0(consumeResponseListener, strA, billingResultA, zzjd.BILLING_RESULT_RECEIVED_FROM_PHONESKY, "Error consuming purchase with token. Response code: " + iZza, null);
        } catch (DeadObjectException e7) {
            e = e7;
        } catch (Exception e8) {
            e = e8;
        }
    }

    private static final String c1(int i3) {
        return i3 != 0 ? i3 != 1 ? i3 != 2 ? "CLOSED" : "CONNECTED" : "CONNECTING" : "DISCONNECTED";
    }

    private final void d0(AcknowledgePurchaseResponseListener acknowledgePurchaseResponseListener, BillingResult billingResult, zzjd zzjdVar, Exception exc) {
        com.google.android.gms.internal.play_billing.zzc.zzp("BillingClient", "Error in acknowledge purchase!", exc);
        j1(zzjdVar, 3, billingResult, zzcy.a(exc));
        acknowledgePurchaseResponseListener.b(billingResult);
    }

    private static final void d1(zzjp zzjpVar, Context context) {
        try {
            ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
            if (activityManager != null) {
                ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
                activityManager.getMemoryInfo(memoryInfo);
                zzjpVar.zzv((int) (memoryInfo.totalMem / 1048576));
                zzjpVar.zzr(Build.BRAND);
                zzjpVar.zzu(Build.MODEL);
                zzjpVar.zzt(Build.MANUFACTURER);
                zzjpVar.zzs(Build.FINGERPRINT);
            }
        } catch (RuntimeException e3) {
            com.google.android.gms.internal.play_billing.zzc.zzp("BillingClient", "Runtime error while populating device info.", e3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void e0(AlternativeBillingOnlyAvailabilityListener alternativeBillingOnlyAvailabilityListener, BillingResult billingResult, zzjd zzjdVar, Exception exc) {
        j1(zzjdVar, 14, billingResult, zzcy.a(exc));
        alternativeBillingOnlyAvailabilityListener.a(billingResult);
    }

    private final zzdz e1(int i3, BillingResult billingResult, zzjd zzjdVar, String str, Exception exc) {
        j1(zzjdVar, 9, billingResult, zzcy.a(exc));
        com.google.android.gms.internal.play_billing.zzc.zzp("BillingClient", str, exc);
        return new zzdz(billingResult, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void f0(BillingProgramAvailabilityListener billingProgramAvailabilityListener, int i3, BillingResult billingResult, zzjd zzjdVar, Exception exc) {
        j1(zzjdVar, 33, billingResult, zzcy.a(exc));
        billingProgramAvailabilityListener.a(billingResult, new BillingProgramAvailabilityDetails(i3));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:104:0x0180 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:71:0x018c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final com.android.billingclient.api.zzdz f1(java.lang.String r17, boolean r18, int r19) {
        /*
            Method dump skipped, instruction units count: 577
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.billingclient.api.BillingClientImpl.f1(java.lang.String, boolean, int):com.android.billingclient.api.zzdz");
    }

    private final void g0(ConsumeResponseListener consumeResponseListener, String str, BillingResult billingResult, zzjd zzjdVar, String str2, Exception exc) {
        com.google.android.gms.internal.play_billing.zzc.zzp("BillingClient", str2, exc);
        j1(zzjdVar, 4, billingResult, zzcy.a(exc));
        consumeResponseListener.c(billingResult, str);
    }

    private final void g1(BillingResult billingResult, zzjd zzjdVar, int i3) {
        zzja zzjaVar = null;
        zziw zziwVar = null;
        if (billingResult.c() == 0) {
            int i4 = zzcy.f57549a;
            try {
                zziy zziyVarZza = zzja.zza();
                zziyVarZza.zze(5);
                zzjv zzjvVarZza = zzjy.zza();
                zzjvVarZza.zza(i3);
                zziyVarZza.zzb((zzjy) zzjvVarZza.zzi());
                zzjaVar = (zzja) zziyVarZza.zzi();
            } catch (Exception e3) {
                com.google.android.gms.internal.play_billing.zzc.zzp("BillingLogger", "Unable to create logging payload", e3);
            }
            T0(zzjaVar);
            return;
        }
        int i5 = zzcy.f57549a;
        try {
            zziu zziuVarZza = zziw.zza();
            zzjb zzjbVarZza = zzjf.zza();
            zzjbVarZza.zzp(billingResult.c());
            zzjbVarZza.zzb(billingResult.a());
            zzjbVarZza.zze(zzjdVar);
            zziuVarZza.zzb(zzjbVarZza);
            zziuVarZza.zzp(5);
            zzjv zzjvVarZza2 = zzjy.zza();
            zzjvVarZza2.zza(i3);
            zziuVarZza.zzc((zzjy) zzjvVarZza2.zzi());
            zziwVar = (zziw) zziuVarZza.zzi();
        } catch (Exception e4) {
            com.google.android.gms.internal.play_billing.zzc.zzp("BillingLogger", "Unable to create logging payload", e4);
        }
        R0(zziwVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void h0(AlternativeBillingOnlyReportingDetailsListener alternativeBillingOnlyReportingDetailsListener, BillingResult billingResult, zzjd zzjdVar, Exception exc) {
        j1(zzjdVar, 15, billingResult, zzcy.a(exc));
        alternativeBillingOnlyReportingDetailsListener.a(billingResult, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h1(zzjd zzjdVar, int i3, BillingResult billingResult) {
        try {
            int i4 = zzcy.f57549a;
            R0(zzcy.b(zzjdVar, i3, billingResult, null, zzjk.BROADCAST_ACTION_UNSPECIFIED));
        } catch (Throwable th) {
            com.google.android.gms.internal.play_billing.zzc.zzp("BillingClient", "Unable to log.", th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void i0(BillingProgramReportingDetailsListener billingProgramReportingDetailsListener, BillingResult billingResult, zzjd zzjdVar, Exception exc) {
        j1(zzjdVar, 35, billingResult, zzcy.a(exc));
        billingProgramReportingDetailsListener.a(billingResult, null);
    }

    private final void i1(zzjd zzjdVar, int i3, BillingResult billingResult, long j3) {
        try {
            int i4 = zzcy.f57549a;
            try {
                this.f57171h.d(zzcy.b(zzjdVar, 2, billingResult, null, zzjk.BROADCAST_ACTION_UNSPECIFIED), this.f57176m, j3);
            } catch (Throwable th) {
                com.google.android.gms.internal.play_billing.zzc.zzp("BillingClient", "Unable to log.", th);
            }
        } catch (Throwable th2) {
            com.google.android.gms.internal.play_billing.zzc.zzp("BillingClient", "Unable to log.", th2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void j0(ExternalOfferReportingDetailsListener externalOfferReportingDetailsListener, BillingResult billingResult, zzjd zzjdVar, Exception exc) {
        j1(zzjdVar, 24, billingResult, zzcy.a(exc));
        externalOfferReportingDetailsListener.a(billingResult, null);
    }

    private final void j1(zzjd zzjdVar, int i3, BillingResult billingResult, String str) {
        try {
            int i4 = zzcy.f57549a;
            R0(zzcy.b(zzjdVar, i3, billingResult, str, zzjk.BROADCAST_ACTION_UNSPECIFIED));
        } catch (Throwable th) {
            com.google.android.gms.internal.play_billing.zzc.zzp("BillingClient", "Unable to log.", th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void k0(ExternalOfferAvailabilityListener externalOfferAvailabilityListener, BillingResult billingResult, zzjd zzjdVar, Exception exc) {
        j1(zzjdVar, 23, billingResult, zzcy.a(exc));
        externalOfferAvailabilityListener.a(billingResult);
    }

    private final void k1(zzjd zzjdVar, int i3, BillingResult billingResult, long j3, boolean z2) {
        try {
            int i4 = zzcy.f57549a;
            S0(zzcy.b(zzjdVar, 2, billingResult, null, zzjk.BROADCAST_ACTION_UNSPECIFIED), j3, z2);
        } catch (Throwable th) {
            com.google.android.gms.internal.play_billing.zzc.zzp("BillingClient", "Unable to log.", th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void l0(ExternalOfferInformationDialogListener externalOfferInformationDialogListener, BillingResult billingResult, zzjd zzjdVar, Exception exc) {
        j1(zzjdVar, 25, billingResult, zzcy.a(exc));
        externalOfferInformationDialogListener.a(billingResult);
    }

    private final void l1(zzjd zzjdVar, int i3, BillingResult billingResult, String str, long j3, boolean z2) {
        try {
            int i4 = zzcy.f57549a;
            S0(zzcy.b(zzjdVar, 2, billingResult, str, zzjk.BROADCAST_ACTION_UNSPECIFIED), j3, z2);
        } catch (Throwable th) {
            com.google.android.gms.internal.play_billing.zzc.zzp("BillingClient", "Unable to log.", th);
        }
    }

    private void m(Context context, PurchasesUpdatedListener purchasesUpdatedListener, PendingPurchasesParams pendingPurchasesParams, UserChoiceBillingListener userChoiceBillingListener, DeveloperProvidedBillingListener developerProvidedBillingListener, String str, zzcz zzczVar, BillingClient.Builder builder) {
        this.f57170g = context.getApplicationContext();
        zzjp zzjpVarZza = zzjr.zza();
        zzjpVarZza.zzx(str);
        String str2 = this.f57167d;
        if (str2 != null) {
            zzjpVarZza.zzy(str2);
        }
        zzjpVarZza.zzq(this.f57170g.getPackageName());
        zzjpVarZza.zzd(this.J.longValue());
        zzjpVarZza.zzw(builder.f57163k);
        zzjpVarZza.zza(Build.VERSION.SDK_INT);
        zzjpVarZza.zzp(846465066L);
        d1(zzjpVarZza, context);
        try {
            zzjpVarZza.zzb(this.f57170g.getPackageManager().getPackageInfo(this.f57170g.getPackageName(), 0).versionCode);
        } catch (Throwable th) {
            com.google.android.gms.internal.play_billing.zzc.zzp("BillingClient", "Error getting app version code.", th);
        }
        if (zzczVar != null) {
            this.f57171h = zzczVar;
        } else {
            this.f57171h = new zzdl(this.f57170g, (zzjr) zzjpVarZza.zzi());
        }
        if (purchasesUpdatedListener == null) {
            com.google.android.gms.internal.play_billing.zzc.zzo("BillingClient", "Billing client should have a valid listener but the provided is null.");
        }
        this.f57169f = new zzab(this.f57170g, purchasesUpdatedListener, null, null, userChoiceBillingListener, developerProvidedBillingListener, this.f57171h);
        this.E = pendingPurchasesParams;
        this.G = userChoiceBillingListener != null;
        this.F = builder.f57163k;
    }

    private final void m0(BillingConfigResponseListener billingConfigResponseListener, BillingResult billingResult, zzjd zzjdVar, Exception exc) {
        com.google.android.gms.internal.play_billing.zzc.zzp("BillingClient", "getBillingConfig got an exception.", exc);
        j1(zzjdVar, 13, billingResult, zzcy.a(exc));
        billingConfigResponseListener.a(billingResult, null);
    }

    private void m1(int i3) {
        try {
            int i4 = zzcy.f57549a;
            T0(zzcy.c(i3, zzjk.BROADCAST_ACTION_UNSPECIFIED));
        } catch (Throwable th) {
            com.google.android.gms.internal.play_billing.zzc.zzp("BillingClient", "Unable to log.", th);
        }
    }

    private void n(Context context, PurchasesUpdatedListener purchasesUpdatedListener, PendingPurchasesParams pendingPurchasesParams, zzb zzbVar, String str, zzcz zzczVar, BillingClient.Builder builder) {
        this.f57170g = context.getApplicationContext();
        zzjp zzjpVarZza = zzjr.zza();
        zzjpVarZza.zzx(str);
        String str2 = this.f57167d;
        if (str2 != null) {
            zzjpVarZza.zzy(str2);
        }
        zzjpVarZza.zzq(this.f57170g.getPackageName());
        zzjpVarZza.zzd(this.J.longValue());
        zzjpVarZza.zzw(builder.f57163k);
        zzjpVarZza.zza(Build.VERSION.SDK_INT);
        zzjpVarZza.zzp(846465066L);
        d1(zzjpVarZza, context);
        try {
            zzjpVarZza.zzb(this.f57170g.getPackageManager().getPackageInfo(this.f57170g.getPackageName(), 0).versionCode);
        } catch (Throwable th) {
            com.google.android.gms.internal.play_billing.zzc.zzp("BillingClient", "Error getting app version code.", th);
        }
        if (zzczVar != null) {
            this.f57171h = zzczVar;
        } else {
            this.f57171h = new zzdl(this.f57170g, (zzjr) zzjpVarZza.zzi());
        }
        if (purchasesUpdatedListener == null) {
            com.google.android.gms.internal.play_billing.zzc.zzo("BillingClient", "Billing client should have a valid listener but the provided is null.");
        }
        this.f57169f = new zzab(this.f57170g, purchasesUpdatedListener, null, zzbVar, null, null, this.f57171h);
        this.E = pendingPurchasesParams;
        this.G = zzbVar != null;
        this.f57170g.getPackageName();
        this.F = builder.f57163k;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void n0(LaunchExternalLinkResponseListener launchExternalLinkResponseListener, BillingResult billingResult, zzjd zzjdVar, Exception exc) {
        j1(zzjdVar, 37, billingResult, zzcy.a(exc));
        launchExternalLinkResponseListener.a(billingResult);
    }

    public static /* synthetic */ Void o(BillingClientImpl billingClientImpl, AlternativeBillingOnlyInformationDialogListener alternativeBillingOnlyInformationDialogListener, Activity activity, ResultReceiver resultReceiver) {
        billingClientImpl.a0(alternativeBillingOnlyInformationDialogListener, activity, resultReceiver);
        return null;
    }

    public static /* synthetic */ Void p(BillingClientImpl billingClientImpl, ExternalOfferAvailabilityListener externalOfferAvailabilityListener) {
        billingClientImpl.Z(externalOfferAvailabilityListener);
        return null;
    }

    public static /* synthetic */ Void q(BillingClientImpl billingClientImpl, BillingProgramAvailabilityListener billingProgramAvailabilityListener, int i3) {
        billingClientImpl.Y(billingProgramAvailabilityListener, i3);
        return null;
    }

    public static /* synthetic */ Void r(BillingClientImpl billingClientImpl, LaunchExternalLinkResponseListener launchExternalLinkResponseListener, LaunchExternalLinkParams launchExternalLinkParams, Activity activity) throws RemoteException {
        com.google.android.gms.internal.play_billing.zzap zzapVar;
        zzch zzchVar = null;
        try {
            if (!billingClientImpl.a1(30000L)) {
                billingClientImpl.n0(launchExternalLinkResponseListener, zzdc.f57560j, zzjd.SERVICE_CONNECTION_NOT_READY, null);
            } else if (billingClientImpl.D) {
                synchronized (billingClientImpl.f57164a) {
                    zzapVar = billingClientImpl.f57172i;
                }
                if (zzapVar == null) {
                    billingClientImpl.n0(launchExternalLinkResponseListener, zzdc.f57560j, zzjd.SERVICE_RESET_TO_NULL, null);
                } else {
                    String packageName = billingClientImpl.f57170g.getPackageName();
                    String str = billingClientImpl.f57166c;
                    String str2 = billingClientImpl.f57167d;
                    long jLongValue = billingClientImpl.J.longValue();
                    int i3 = com.google.android.gms.internal.play_billing.zzc.zza;
                    Bundle bundle = new Bundle();
                    com.google.android.gms.internal.play_billing.zzc.zzc(bundle, str, str2, jLongValue);
                    zzhu zzhuVarZza = zzhx.zza();
                    zzio zzioVarZza = zziq.zza();
                    zzioVarZza.zza(launchExternalLinkParams.d().toString());
                    zzhuVarZza.zza("externalOfferUri", (zziq) zzioVarZza.zzi());
                    zzio zzioVarZza2 = zziq.zza();
                    zzioVarZza2.zza(String.valueOf(launchExternalLinkParams.b()));
                    zzhuVarZza.zza("externalOfferLaunchMode", (zziq) zzioVarZza2.zzi());
                    zzio zzioVarZza3 = zziq.zza();
                    zzioVarZza3.zza(String.valueOf(launchExternalLinkParams.c()));
                    zzhuVarZza.zza("externalOfferLinkType", (zziq) zzioVarZza3.zzi());
                    zzio zzioVarZza4 = zziq.zza();
                    zzioVarZza4.zza(String.valueOf(launchExternalLinkParams.a()));
                    zzhuVarZza.zza("externalOfferBillingProgram", (zziq) zzioVarZza4.zzi());
                    bundle.putByteArray("REQUEST_PARAMS", ((zzhx) zzhuVarZza.zzi()).zzQ());
                    zzapVar.zzp(27, packageName, bundle, new zzcc(billingClientImpl, new WeakReference(activity), launchExternalLinkResponseListener, zzchVar));
                }
            } else {
                com.google.android.gms.internal.play_billing.zzc.zzo("BillingClient", "Current client doesn't support launch external link.");
                billingClientImpl.n0(launchExternalLinkResponseListener, zzdc.G, zzjd.LAUNCH_EXTERNAL_LINK_NOT_SUPPORTED, null);
            }
        } catch (RuntimeException e3) {
            billingClientImpl.n0(launchExternalLinkResponseListener, zzdc.f57558h, zzjd.SERVICE_CALL_EXCEPTION, e3);
        }
        return null;
    }

    static /* bridge */ /* synthetic */ ResultReceiver r1(BillingClientImpl billingClientImpl, LaunchExternalLinkResponseListener launchExternalLinkResponseListener) {
        return new zzbt(billingClientImpl, billingClientImpl.f57168e, launchExternalLinkResponseListener);
    }

    public static /* synthetic */ Void s(BillingClientImpl billingClientImpl, ExternalOfferReportingDetailsListener externalOfferReportingDetailsListener) {
        billingClientImpl.W(externalOfferReportingDetailsListener);
        return null;
    }

    public static /* synthetic */ Void t(BillingClientImpl billingClientImpl, ExternalOfferInformationDialogListener externalOfferInformationDialogListener, Activity activity, ResultReceiver resultReceiver) {
        billingClientImpl.b0(externalOfferInformationDialogListener, activity, resultReceiver);
        return null;
    }

    public static /* synthetic */ Void u(BillingClientImpl billingClientImpl, AlternativeBillingOnlyReportingDetailsListener alternativeBillingOnlyReportingDetailsListener) {
        billingClientImpl.U(alternativeBillingOnlyReportingDetailsListener);
        return null;
    }

    public static /* synthetic */ Void v(BillingClientImpl billingClientImpl, BillingProgramReportingDetailsListener billingProgramReportingDetailsListener, BillingProgramReportingDetailsParams billingProgramReportingDetailsParams) throws RemoteException {
        billingClientImpl.V(billingProgramReportingDetailsListener, billingProgramReportingDetailsParams);
        return null;
    }

    public static /* synthetic */ Void w(BillingClientImpl billingClientImpl, AlternativeBillingOnlyAvailabilityListener alternativeBillingOnlyAvailabilityListener) {
        billingClientImpl.X(alternativeBillingOnlyAvailabilityListener);
        return null;
    }

    static /* bridge */ /* synthetic */ BillingResult x1(Exception exc) {
        return exc instanceof DeadObjectException ? zzdc.f57560j : zzdc.f57558h;
    }

    static Future y(Callable callable, long j3, final Runnable runnable, Handler handler, ExecutorService executorService) {
        try {
            final Future futureSubmit = executorService.submit(callable);
            handler.postDelayed(new Runnable() { // from class: com.android.billingclient.api.zzaz
                @Override // java.lang.Runnable
                public final void run() {
                    Future future = futureSubmit;
                    if (future.isDone() || future.isCancelled()) {
                        return;
                    }
                    Runnable runnable2 = runnable;
                    future.cancel(true);
                    com.google.android.gms.internal.play_billing.zzc.zzo("BillingClient", "Async task is taking too long, cancel it!");
                    if (runnable2 != null) {
                        runnable2.run();
                    }
                }
            }, (long) (j3 * 0.95d));
            return futureSubmit;
        } catch (Exception e3) {
            com.google.android.gms.internal.play_billing.zzc.zzp("BillingClient", "Async task throws exception!", e3);
            return null;
        }
    }

    static /* bridge */ /* synthetic */ void y0(BillingClientImpl billingClientImpl, int i3) {
        billingClientImpl.f57176m = i3;
        billingClientImpl.D = i3 >= 27;
        billingClientImpl.C = i3 >= 26;
        billingClientImpl.B = i3 >= 24;
        billingClientImpl.A = i3 >= 23;
        billingClientImpl.f57189z = i3 >= 22;
        billingClientImpl.f57188y = i3 >= 21;
        billingClientImpl.f57187x = i3 >= 20;
        billingClientImpl.f57186w = i3 >= 19;
        billingClientImpl.f57185v = i3 >= 18;
        billingClientImpl.f57184u = i3 >= 17;
        billingClientImpl.f57183t = i3 >= 16;
        billingClientImpl.f57182s = i3 >= 15;
        billingClientImpl.f57181r = i3 >= 14;
        billingClientImpl.f57180q = i3 >= 12;
        billingClientImpl.f57179p = i3 >= 9;
        billingClientImpl.f57178o = i3 >= 8;
        billingClientImpl.f57177n = i3 >= 6;
    }

    public static /* synthetic */ void z(BillingClientImpl billingClientImpl, ConsumeResponseListener consumeResponseListener, ConsumeParams consumeParams) {
        zzjd zzjdVar = zzjd.EXECUTE_ASYNC_TIMEOUT;
        BillingResult billingResult = zzdc.f57561k;
        billingClientImpl.h1(zzjdVar, 4, billingResult);
        consumeResponseListener.c(billingResult, consumeParams.a());
    }

    public final void C0(Runnable runnable) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            runnable.run();
        } else {
            this.f57168e.post(runnable);
        }
    }

    @Override // com.android.billingclient.api.BillingClient
    public void a(final AcknowledgePurchaseParams acknowledgePurchaseParams, final AcknowledgePurchaseResponseListener acknowledgePurchaseResponseListener) {
        if (y(new Callable() { // from class: com.android.billingclient.api.zzaj
            @Override // java.util.concurrent.Callable
            public final Object call() {
                BillingClientImpl.F1(this.f57398a, acknowledgePurchaseResponseListener, acknowledgePurchaseParams);
                return null;
            }
        }, 30000L, new Runnable() { // from class: com.android.billingclient.api.zzak
            @Override // java.lang.Runnable
            public final void run() {
                BillingClientImpl.F(this.f57401a, acknowledgePurchaseResponseListener);
            }
        }, J0(), x()) == null) {
            BillingResult billingResultM0 = M0();
            h1(zzjd.MISSING_RESULT_FROM_EXECUTE_ASYNC, 3, billingResultM0);
            acknowledgePurchaseResponseListener.b(billingResultM0);
        }
    }

    @Override // com.android.billingclient.api.BillingClient
    public void b(final ConsumeParams consumeParams, final ConsumeResponseListener consumeResponseListener) {
        if (y(new Callable() { // from class: com.android.billingclient.api.zzba
            @Override // java.util.concurrent.Callable
            public final Object call() throws Throwable {
                BillingClientImpl.D1(this.f57438a, consumeResponseListener, consumeParams);
                return null;
            }
        }, 30000L, new Runnable() { // from class: com.android.billingclient.api.zzbb
            @Override // java.lang.Runnable
            public final void run() {
                BillingClientImpl.z(this.f57441a, consumeResponseListener, consumeParams);
            }
        }, J0(), x()) == null) {
            BillingResult billingResultM0 = M0();
            h1(zzjd.MISSING_RESULT_FROM_EXECUTE_ASYNC, 4, billingResultM0);
            consumeResponseListener.c(billingResultM0, consumeParams.a());
        }
    }

    @Override // com.android.billingclient.api.BillingClient
    public void c() {
        m1(12);
        synchronized (this.f57164a) {
            try {
            } finally {
            }
            if (this.f57169f != null) {
                this.f57169f.h();
                try {
                    com.google.android.gms.internal.play_billing.zzc.zzn("BillingClient", "Unbinding from service.");
                    Y0();
                } catch (Throwable th) {
                    com.google.android.gms.internal.play_billing.zzc.zzp("BillingClient", "There was an exception while unbinding from the service while ending connection!", th);
                }
                try {
                    W0();
                } finally {
                    try {
                    } finally {
                    }
                }
            } else {
                com.google.android.gms.internal.play_billing.zzc.zzn("BillingClient", "Unbinding from service.");
                Y0();
                W0();
            }
        }
    }

    @Override // com.android.billingclient.api.BillingClient
    public void d(GetBillingConfigParams getBillingConfigParams, final BillingConfigResponseListener billingConfigResponseListener) {
        if (y(new Callable() { // from class: com.android.billingclient.api.zzaq
            @Override // java.util.concurrent.Callable
            public final Object call() {
                BillingClientImpl.H1(this.f57416a, billingConfigResponseListener);
                return null;
            }
        }, 30000L, new Runnable() { // from class: com.android.billingclient.api.zzar
            @Override // java.lang.Runnable
            public final void run() {
                BillingClientImpl.B(this.f57418a, billingConfigResponseListener);
            }
        }, J0(), x()) == null) {
            BillingResult billingResultM0 = M0();
            h1(zzjd.MISSING_RESULT_FROM_EXECUTE_ASYNC, 13, billingResultM0);
            billingConfigResponseListener.a(billingResultM0, null);
        }
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @Override // com.android.billingclient.api.BillingClient
    public final BillingResult e(String str) {
        if (!Z0(3000L)) {
            BillingResult billingResult = zzdc.f57560j;
            zzjd zzjdVar = zzjd.SERVICE_CONNECTION_NOT_READY;
            if (billingResult.c() != 0) {
                h1(zzjdVar, 5, billingResult);
                return billingResult;
            }
            m1(5);
            return billingResult;
        }
        BillingResult billingResult2 = zzdc.f57551a;
        switch (str.hashCode()) {
            case -422092961:
                if (str.equals("subscriptionsUpdate")) {
                    BillingResult billingResult3 = this.f57175l ? zzdc.f57559i : zzdc.f57563m;
                    g1(billingResult3, zzjd.SUBSCRIPTIONS_UPDATE_NOT_SUPPORTED, 3);
                    return billingResult3;
                }
                break;
            case 96321:
                if (str.equals("aaa")) {
                    BillingResult billingResult4 = this.f57182s ? zzdc.f57559i : zzdc.f57565o;
                    g1(billingResult4, zzjd.CROSS_APP_NOT_SUPPORTED, 6);
                    return billingResult4;
                }
                break;
            case 97314:
                if (str.equals("bbb")) {
                    BillingResult billingResult5 = this.f57180q ? zzdc.f57559i : zzdc.f57569s;
                    g1(billingResult5, zzjd.IN_APP_MESSAGE_NOT_SUPPORTED, 5);
                    return billingResult5;
                }
                break;
            case 98307:
                if (str.equals("ccc")) {
                    BillingResult billingResult6 = this.f57183t ? zzdc.f57559i : zzdc.f57566p;
                    g1(billingResult6, zzjd.MULTI_ITEM_NOT_SUPPORTED, 8);
                    return billingResult6;
                }
                break;
            case 99300:
                if (str.equals("ddd")) {
                    BillingResult billingResult7 = this.f57181r ? zzdc.f57559i : zzdc.f57567q;
                    g1(billingResult7, zzjd.OFFER_ID_TOKEN_NOT_SUPPORTED, 7);
                    return billingResult7;
                }
                break;
            case 100293:
                if (str.equals("eee")) {
                    BillingResult billingResult8 = this.f57183t ? zzdc.f57559i : zzdc.f57566p;
                    g1(billingResult8, zzjd.PBL_FOR_PAYMENTS_GATEWAY_BUYFLOW_NOT_SUPPORTED, 9);
                    return billingResult8;
                }
                break;
            case 101286:
                if (str.equals("fff")) {
                    BillingResult billingResult9 = this.f57184u ? zzdc.f57559i : zzdc.f57568r;
                    g1(billingResult9, zzjd.PRODUCT_DETAILS_NOT_SUPPORTED, 10);
                    return billingResult9;
                }
                break;
            case 102279:
                if (str.equals("ggg")) {
                    BillingResult billingResult10 = this.f57185v ? zzdc.f57559i : zzdc.f57575y;
                    g1(billingResult10, zzjd.GET_BILLING_CONFIG_NOT_SUPPORTED, 11);
                    return billingResult10;
                }
                break;
            case 103272:
                if (str.equals("hhh")) {
                    BillingResult billingResult11 = this.f57185v ? zzdc.f57559i : zzdc.f57576z;
                    g1(billingResult11, zzjd.QUERY_PRODUCT_DETAILS_WITH_SERIALIZED_DOCID_NOT_SUPPORTED, 12);
                    return billingResult11;
                }
                break;
            case 104265:
                if (str.equals("iii")) {
                    BillingResult billingResult12 = this.f57187x ? zzdc.f57559i : zzdc.B;
                    g1(billingResult12, zzjd.QUERY_PRODUCT_DETAILS_WITH_DEVELOPER_SPECIFIED_ACCOUNT_NOT_SUPPORTED, 13);
                    return billingResult12;
                }
                break;
            case 105258:
                if (str.equals("jjj")) {
                    BillingResult billingResult13 = this.f57188y ? zzdc.f57559i : zzdc.C;
                    g1(billingResult13, zzjd.ALTERNATIVE_BILLING_ONLY_NOT_SUPPORTED, 14);
                    return billingResult13;
                }
                break;
            case 106251:
                if (str.equals("kkk")) {
                    BillingResult billingResult14 = this.B ? zzdc.f57559i : zzdc.f57570t;
                    g1(billingResult14, zzjd.EXTERNAL_OFFER_NOT_SUPPORTED, 18);
                    return billingResult14;
                }
                break;
            case 107244:
                if (str.equals("lll")) {
                    BillingResult billingResult15 = this.A ? zzdc.f57559i : zzdc.f57571u;
                    g1(billingResult15, zzjd.MULTI_ITEM_WITH_SEASON_PASS_NOT_SUPPORTED, 19);
                    return billingResult15;
                }
                break;
            case 108237:
                if (str.equals("mmm")) {
                    BillingResult billingResult16 = this.B ? zzdc.f57559i : zzdc.f57572v;
                    g1(billingResult16, zzjd.AUTO_PAY_NOT_SUPPORTED, 20);
                    return billingResult16;
                }
                break;
            case 109230:
                if (str.equals("nnn")) {
                    BillingResult billingResult17 = this.C ? zzdc.f57559i : zzdc.f57573w;
                    g1(billingResult17, zzjd.INCLUDE_SUSPENDED_SUBSCRIPTIONS_NOT_SUPPORTED, 21);
                    return billingResult17;
                }
                break;
            case 207616302:
                if (str.equals("priceChangeConfirmation")) {
                    BillingResult billingResult18 = this.f57178o ? zzdc.f57559i : zzdc.f57564n;
                    g1(billingResult18, zzjd.PRICE_CHANGE_CONFIRMATION_NOT_SUPPORTED, 4);
                    return billingResult18;
                }
                break;
            case 1987365622:
                if (str.equals(CustomerInfoResponseJsonKeys.SUBSCRIPTIONS)) {
                    BillingResult billingResult19 = this.f57174k ? zzdc.f57559i : zzdc.f57562l;
                    g1(billingResult19, zzjd.SUBSCRIPTIONS_NOT_SUPPORTED, 2);
                    return billingResult19;
                }
                break;
        }
        com.google.android.gms.internal.play_billing.zzc.zzo("BillingClient", "Unsupported feature: ".concat(str));
        BillingResult billingResult20 = zzdc.f57574x;
        g1(billingResult20, zzjd.UNKNOWN_FEATURE, 1);
        return billingResult20;
    }

    @Override // com.android.billingclient.api.BillingClient
    public final boolean f() {
        if (this.F) {
            return true;
        }
        return b1();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:134:0x0383  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x038b  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x0393  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x039b  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x03da  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x03e3  */
    /* JADX WARN: Removed duplicated region for block: B:157:0x03e7  */
    /* JADX WARN: Removed duplicated region for block: B:158:0x03ea  */
    /* JADX WARN: Type inference failed for: r31v0, types: [com.android.billingclient.api.BillingClientImpl] */
    /* JADX WARN: Type inference failed for: r5v1 */
    /* JADX WARN: Type inference failed for: r5v11 */
    /* JADX WARN: Type inference failed for: r5v12 */
    /* JADX WARN: Type inference failed for: r5v16 */
    /* JADX WARN: Type inference failed for: r5v17 */
    /* JADX WARN: Type inference failed for: r5v18 */
    /* JADX WARN: Type inference failed for: r5v19 */
    /* JADX WARN: Type inference failed for: r5v2 */
    /* JADX WARN: Type inference failed for: r5v20 */
    /* JADX WARN: Type inference failed for: r5v4 */
    /* JADX WARN: Type inference failed for: r5v6 */
    /* JADX WARN: Type inference failed for: r5v7 */
    /* JADX WARN: Type inference failed for: r6v0, types: [long] */
    /* JADX WARN: Type inference failed for: r6v1, types: [long] */
    @Override // com.android.billingclient.api.BillingClient
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public com.android.billingclient.api.BillingResult g(android.app.Activity r32, com.android.billingclient.api.BillingFlowParams r33) {
        /*
            Method dump skipped, instruction units count: 1400
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.billingclient.api.BillingClientImpl.g(android.app.Activity, com.android.billingclient.api.BillingFlowParams):com.android.billingclient.api.BillingResult");
    }

    @Override // com.android.billingclient.api.BillingClient
    public void i(final QueryProductDetailsParams queryProductDetailsParams, final ProductDetailsResponseListener productDetailsResponseListener) {
        if (y(new Callable() { // from class: com.android.billingclient.api.zzbf
            @Override // java.util.concurrent.Callable
            public final Object call() {
                BillingClientImpl.E1(this.f57452a, productDetailsResponseListener, queryProductDetailsParams);
                return null;
            }
        }, 30000L, new Runnable() { // from class: com.android.billingclient.api.zzbg
            @Override // java.lang.Runnable
            public final void run() {
                BillingClientImpl.H(this.f57455a, productDetailsResponseListener);
            }
        }, J0(), x()) == null) {
            BillingResult billingResultM0 = M0();
            h1(zzjd.MISSING_RESULT_FROM_EXECUTE_ASYNC, 7, billingResultM0);
            productDetailsResponseListener.a(billingResultM0, new QueryProductDetailsResult(com.google.android.gms.internal.play_billing.zzbw.zzk(), com.google.android.gms.internal.play_billing.zzbw.zzk()));
        }
    }

    @Override // com.android.billingclient.api.BillingClient
    public final void j(QueryPurchasesParams queryPurchasesParams, final PurchasesResponseListener purchasesResponseListener) {
        if (y(new zzbm(this, purchasesResponseListener, queryPurchasesParams.c(), queryPurchasesParams.a()), 30000L, new Runnable() { // from class: com.android.billingclient.api.zzbj
            @Override // java.lang.Runnable
            public final void run() {
                BillingClientImpl.A(this.f57463a, purchasesResponseListener);
            }
        }, J0(), x()) == null) {
            BillingResult billingResultM0 = M0();
            h1(zzjd.MISSING_RESULT_FROM_EXECUTE_ASYNC, 9, billingResultM0);
            purchasesResponseListener.a(billingResultM0, com.google.android.gms.internal.play_billing.zzbw.zzk());
        }
    }

    @Override // com.android.billingclient.api.BillingClient
    public void l(BillingClientStateListener billingClientStateListener) {
        X0(billingClientStateListener, 0);
    }

    final zzcg s1(QueryProductDetailsParams queryProductDetailsParams) {
        com.google.android.gms.internal.play_billing.zzap zzapVar;
        int i3;
        int i4;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        String strC = queryProductDetailsParams.c();
        com.google.android.gms.internal.play_billing.zzbw zzbwVarB = queryProductDetailsParams.b();
        int size = zzbwVarB.size();
        int i5 = 0;
        while (i5 < size) {
            int i6 = i5 + 20;
            ArrayList arrayList3 = new ArrayList(zzbwVarB.subList(i5, i6 > size ? size : i6));
            ArrayList<String> arrayList4 = new ArrayList<>();
            int size2 = arrayList3.size();
            for (int i7 = 0; i7 < size2; i7++) {
                arrayList4.add(((QueryProductDetailsParams.Product) arrayList3.get(i7)).b());
            }
            Bundle bundle = new Bundle();
            bundle.putStringArrayList("ITEM_ID_LIST", arrayList4);
            String str = this.f57166c;
            bundle.putString("playBillingLibraryVersion", str);
            try {
                synchronized (this.f57164a) {
                    zzapVar = this.f57172i;
                }
                if (zzapVar == null) {
                    return K0(zzdc.f57560j, zzjd.SERVICE_RESET_TO_NULL, "Service has been reset to null.", null);
                }
                boolean z2 = this.f57186w && this.E.b();
                S(queryProductDetailsParams);
                S(queryProductDetailsParams);
                S(queryProductDetailsParams);
                S(queryProductDetailsParams);
                Bundle bundleZzj = zzapVar.zzj(true != this.f57187x ? 17 : 20, this.f57170g.getPackageName(), strC, bundle, com.google.android.gms.internal.play_billing.zzc.zzg(str, this.f57167d, arrayList3, null, null, com.google.android.gms.internal.play_billing.zza.zza(z2, true, true, true, false, true), this.J.longValue()));
                if (bundleZzj == null) {
                    return K0(zzdc.A, zzjd.NULL_BUNDLE_FROM_GET_SKU_DETAILS_SERVICE_CALL, "queryProductDetailsAsync got empty product details response.", null);
                }
                if (!bundleZzj.containsKey("DETAILS_LIST")) {
                    int iZzb = com.google.android.gms.internal.play_billing.zzc.zzb(bundleZzj, "BillingClient");
                    String strZzk = com.google.android.gms.internal.play_billing.zzc.zzk(bundleZzj, "BillingClient");
                    if (iZzb == 0) {
                        return K0(zzdc.a(6, strZzk), zzjd.MISSING_DETAILS_LIST_IN_GET_SKU_DETAILS_RESPONSE, "getSkuDetails() returned a bundle with neither an error nor a product detail list for queryProductDetailsAsync.", null);
                    }
                    return K0(zzdc.a(iZzb, strZzk), zzjd.BILLING_RESULT_RECEIVED_FROM_PHONESKY, "getSkuDetails() failed for queryProductDetailsAsync. Response code: " + iZzb, null);
                }
                ArrayList<String> stringArrayList = bundleZzj.getStringArrayList("DETAILS_LIST");
                if (stringArrayList == null) {
                    return K0(zzdc.A, zzjd.NULL_DETAILS_LIST_IN_GET_SKU_DETAILS_RESPONSE, "queryProductDetailsAsync got null response list", null);
                }
                ArrayList arrayList5 = new ArrayList();
                int size3 = stringArrayList.size();
                for (int i8 = 0; i8 < size3; i8++) {
                    try {
                        ProductDetails productDetails = new ProductDetails(stringArrayList.get(i8));
                        com.google.android.gms.internal.play_billing.zzc.zzn("BillingClient", "Got product details: ".concat(productDetails.toString()));
                        arrayList5.add(productDetails);
                    } catch (JSONException e3) {
                        return K0(zzdc.a(6, "Error trying to decode SkuDetails."), zzjd.ERROR_DECODING_SKU_DETAILS, "Got a JSON exception trying to decode ProductDetails. \n Exception: ", e3);
                    }
                }
                ArrayList<String> stringArrayList2 = bundleZzj.getStringArrayList("UNFETCHED_PRODUCT_LIST");
                new ArrayList();
                try {
                    ArrayList arrayList6 = new ArrayList();
                    if (stringArrayList2 != null) {
                        int size4 = stringArrayList2.size();
                        int i9 = 0;
                        while (i9 < size4) {
                            String str2 = stringArrayList2.get(i9);
                            i9++;
                            UnfetchedProduct unfetchedProduct = new UnfetchedProduct(str2);
                            com.google.android.gms.internal.play_billing.zzc.zzn("BillingClient", "Got unfetchedProduct: ".concat(unfetchedProduct.toString()));
                            arrayList6.add(unfetchedProduct);
                        }
                    } else {
                        int size5 = arrayList3.size();
                        int i10 = 0;
                        while (i10 < size5) {
                            Object obj = arrayList3.get(i10);
                            int i11 = i10 + 1;
                            QueryProductDetailsParams.Product product = (QueryProductDetailsParams.Product) obj;
                            int size6 = arrayList5.size();
                            int i12 = 0;
                            while (true) {
                                if (i12 >= size6) {
                                    i3 = size5;
                                    i4 = i11;
                                    arrayList6.add(new UnfetchedProduct(new JSONObject().put("productId", product.b()).put("type", product.c()).put("statusCode", 0).toString()));
                                    break;
                                }
                                Object obj2 = arrayList5.get(i12);
                                i12++;
                                ProductDetails productDetails2 = (ProductDetails) obj2;
                                i3 = size5;
                                i4 = i11;
                                if (!product.b().equals(productDetails2.e()) || !product.c().equals(productDetails2.f())) {
                                    size5 = i3;
                                    i11 = i4;
                                }
                            }
                            size5 = i3;
                            i10 = i4;
                        }
                    }
                    arrayList.addAll(arrayList5);
                    arrayList2.addAll(arrayList6);
                    i5 = i6;
                } catch (JSONException e4) {
                    return K0(zzdc.a(6, "Error trying to decode SkuDetails."), zzjd.ERROR_DECODING_SKU_DETAILS, "Got a JSON exception trying to decode UnfetchedProduct. \n Exception: ", e4);
                }
            } catch (DeadObjectException e5) {
                return K0(zzdc.f57560j, zzjd.zzQ, "queryProductDetailsAsync got a remote exception (try to reconnect).", e5);
            } catch (Exception e6) {
                return K0(zzdc.f57558h, zzjd.zzQ, "queryProductDetailsAsync got a remote exception (try to reconnect).", e6);
            }
        }
        return new zzcg(0, "", arrayList, arrayList2);
    }

    final zzcz v1() {
        return this.f57171h;
    }

    final synchronized ExecutorService x() {
        try {
            if (this.I == null) {
                this.I = Executors.newFixedThreadPool(com.google.android.gms.internal.play_billing.zzc.zza, new zzbl(this));
            }
        } catch (Throwable th) {
            throw th;
        }
        return this.I;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final BillingResult y1(final BillingResult billingResult) {
        if (Thread.interrupted()) {
            return billingResult;
        }
        this.f57168e.post(new Runnable() { // from class: com.android.billingclient.api.zzan
            @Override // java.lang.Runnable
            public final void run() {
                BillingClientImpl.J(this.f57409a, billingResult);
            }
        });
        return billingResult;
    }

    private final /* synthetic */ Void W(ExternalOfferReportingDetailsListener externalOfferReportingDetailsListener) {
        com.google.android.gms.internal.play_billing.zzap zzapVar;
        zzch zzchVar = null;
        try {
            if (!a1(30000L)) {
                j0(externalOfferReportingDetailsListener, zzdc.f57560j, zzjd.SERVICE_CONNECTION_NOT_READY, null);
            } else if (this.f57189z) {
                synchronized (this.f57164a) {
                    zzapVar = this.f57172i;
                }
                if (zzapVar == null) {
                    j0(externalOfferReportingDetailsListener, zzdc.f57560j, zzjd.SERVICE_RESET_TO_NULL, null);
                } else {
                    String packageName = this.f57170g.getPackageName();
                    long j3 = this.f57170g.getPackageManager().getPackageInfo(this.f57170g.getPackageName(), 0).firstInstallTime;
                    String str = this.f57166c;
                    String str2 = this.f57167d;
                    long jLongValue = this.J.longValue();
                    int i3 = com.google.android.gms.internal.play_billing.zzc.zza;
                    Bundle bundle = new Bundle();
                    com.google.android.gms.internal.play_billing.zzc.zzc(bundle, str, str2, jLongValue);
                    bundle.putLong("appInstallTimeMillis", j3);
                    zzapVar.zzl(22, packageName, bundle, new zzby(externalOfferReportingDetailsListener, this.f57171h, this.f57176m, zzchVar));
                }
            } else {
                com.google.android.gms.internal.play_billing.zzc.zzo(jlWo.RXbAG, "Current client doesn't support external offer.");
                j0(externalOfferReportingDetailsListener, zzdc.f57570t, zzjd.EXTERNAL_OFFER_NOT_SUPPORTED, null);
            }
        } catch (DeadObjectException e3) {
            j0(externalOfferReportingDetailsListener, zzdc.f57560j, zzjd.CREATE_EXTERNAL_PAYMENT_REPORTING_DETAILS_SERVICE_CALL_EXCEPTION, e3);
        } catch (Exception e4) {
            j0(externalOfferReportingDetailsListener, zzdc.f57558h, zzjd.CREATE_EXTERNAL_PAYMENT_REPORTING_DETAILS_SERVICE_CALL_EXCEPTION, e4);
        }
        return null;
    }

    @Override // com.android.billingclient.api.BillingClient
    public final BillingResult k(final Activity activity, InAppMessageParams inAppMessageParams, InAppMessageResponseListener inAppMessageResponseListener) {
        if (!Z0(3000L)) {
            com.google.android.gms.internal.play_billing.zzc.zzo("BillingClient", "Service disconnected.");
            return zzdc.f57560j;
        }
        if (!this.f57180q) {
            com.google.android.gms.internal.play_billing.zzc.zzo("BillingClient", "Current client doesn't support showing in-app messages.");
            return zzdc.f57569s;
        }
        View viewFindViewById = activity.findViewById(R.id.content);
        IBinder windowToken = viewFindViewById.getWindowToken();
        Rect rect = new Rect();
        viewFindViewById.getGlobalVisibleRect(rect);
        final Bundle bundle = new Bundle();
        BundleCompat.b(bundle, "KEY_WINDOW_TOKEN", windowToken);
        bundle.putInt("KEY_DIMEN_LEFT", rect.left);
        bundle.putInt("KEY_DIMEN_TOP", rect.top);
        bundle.putInt("KEY_DIMEN_RIGHT", rect.right);
        bundle.putInt("KEY_DIMEN_BOTTOM", rect.bottom);
        bundle.putString("playBillingLibraryVersion", this.f57166c);
        String str = this.f57167d;
        if (str != null) {
            bundle.putString(QaXmqxvjHhxVy.CIVOKoQLgDoVco, str);
        }
        bundle.putIntegerArrayList("KEY_CATEGORY_IDS", inAppMessageParams.b());
        Handler handler = this.f57168e;
        final zzbn zzbnVar = new zzbn(this, handler, inAppMessageResponseListener);
        y(new Callable() { // from class: com.android.billingclient.api.zzbh
            @Override // java.util.concurrent.Callable
            public final Object call() {
                BillingClientImpl.G1(this.f57457a, bundle, activity, zzbnVar);
                return null;
            }
        }, 5000L, null, handler, x());
        return zzdc.f57559i;
    }

    BillingClientImpl(String str, Context context, zzcz zzczVar, ExecutorService executorService, BillingClient.Builder builder) {
        this.f57164a = new Object();
        this.f57165b = 0;
        this.f57168e = new Handler(Looper.getMainLooper());
        this.f57176m = 0;
        Long lValueOf = Long.valueOf(new Random().nextLong());
        this.J = lValueOf;
        this.K = com.google.android.gms.internal.play_billing.zzbd.zza();
        this.f57166c = BuildConfig.BILLING_CLIENT_VERSION;
        String strT = T();
        this.f57167d = strT;
        this.f57170g = context.getApplicationContext();
        zzjp zzjpVarZza = zzjr.zza();
        zzjpVarZza.zzx(BuildConfig.BILLING_CLIENT_VERSION);
        if (strT != null) {
            zzjpVarZza.zzy(strT);
        }
        zzjpVarZza.zzq(this.f57170g.getPackageName());
        zzjpVarZza.zzd(lValueOf.longValue());
        zzjpVarZza.zzw(builder.f57163k);
        zzjpVarZza.zza(Build.VERSION.SDK_INT);
        zzjpVarZza.zzp(846465066L);
        d1(zzjpVarZza, context);
        try {
            zzjpVarZza.zzb(this.f57170g.getPackageManager().getPackageInfo(this.f57170g.getPackageName(), 0).versionCode);
        } catch (Throwable th) {
            com.google.android.gms.internal.play_billing.zzc.zzp("BillingClient", "Error getting app version code.", th);
        }
        this.f57171h = new zzdl(this.f57170g, (zzjr) zzjpVarZza.zzi());
        this.f57170g.getPackageName();
        this.F = builder.f57163k;
    }

    BillingClientImpl(String str, PendingPurchasesParams pendingPurchasesParams, Context context, zzdo zzdoVar, zzcz zzczVar, ExecutorService executorService, BillingClient.Builder builder) {
        this.f57164a = new Object();
        this.f57165b = 0;
        this.f57168e = new Handler(Looper.getMainLooper());
        this.f57176m = 0;
        Long lValueOf = Long.valueOf(new Random().nextLong());
        this.J = lValueOf;
        this.K = com.google.android.gms.internal.play_billing.zzbd.zza();
        this.f57166c = BuildConfig.BILLING_CLIENT_VERSION;
        String strT = T();
        this.f57167d = strT;
        this.f57170g = context.getApplicationContext();
        zzjp zzjpVarZza = zzjr.zza();
        zzjpVarZza.zzx(BuildConfig.BILLING_CLIENT_VERSION);
        if (strT != null) {
            zzjpVarZza.zzy(strT);
        }
        zzjpVarZza.zzq(this.f57170g.getPackageName());
        zzjpVarZza.zzd(lValueOf.longValue());
        zzjpVarZza.zzw(builder.f57163k);
        zzjpVarZza.zza(Build.VERSION.SDK_INT);
        zzjpVarZza.zzp(846465066L);
        d1(zzjpVarZza, context);
        try {
            zzjpVarZza.zzb(this.f57170g.getPackageManager().getPackageInfo(this.f57170g.getPackageName(), 0).versionCode);
        } catch (Throwable th) {
            com.google.android.gms.internal.play_billing.zzc.zzp("BillingClient", "Error getting app version code.", th);
        }
        this.f57171h = new zzdl(this.f57170g, (zzjr) zzjpVarZza.zzi());
        com.google.android.gms.internal.play_billing.zzc.zzo("BillingClient", "Billing client should have a valid listener but the provided is null.");
        this.f57169f = new zzab(this.f57170g, null, null, null, null, null, this.f57171h);
        this.E = pendingPurchasesParams;
        this.f57170g.getPackageName();
        this.F = builder.f57163k;
    }

    BillingClientImpl(String str, PendingPurchasesParams pendingPurchasesParams, Context context, PurchasesUpdatedListener purchasesUpdatedListener, zzb zzbVar, zzcz zzczVar, ExecutorService executorService, BillingClient.Builder builder) {
        this.f57164a = new Object();
        this.f57165b = 0;
        this.f57168e = new Handler(Looper.getMainLooper());
        this.f57176m = 0;
        this.J = Long.valueOf(new Random().nextLong());
        this.K = com.google.android.gms.internal.play_billing.zzbd.zza();
        this.f57166c = BuildConfig.BILLING_CLIENT_VERSION;
        this.f57167d = T();
        n(context, purchasesUpdatedListener, pendingPurchasesParams, null, BuildConfig.BILLING_CLIENT_VERSION, null, builder);
    }

    BillingClientImpl(String str, PendingPurchasesParams pendingPurchasesParams, Context context, PurchasesUpdatedListener purchasesUpdatedListener, UserChoiceBillingListener userChoiceBillingListener, DeveloperProvidedBillingListener developerProvidedBillingListener, zzcz zzczVar, ExecutorService executorService, BillingClient.Builder builder) {
        this(context, pendingPurchasesParams, purchasesUpdatedListener, BuildConfig.BILLING_CLIENT_VERSION, null, userChoiceBillingListener, developerProvidedBillingListener, null, null, builder);
    }
}
