package com.applovin.impl.mediation;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.Lifecycle;
import com.applovin.impl.fe;
import com.applovin.impl.he;
import com.applovin.impl.jn;
import com.applovin.impl.mediation.MediationServiceImpl;
import com.applovin.impl.oe;
import com.applovin.impl.sdk.utils.CollectionUtils;
import com.applovin.impl.sj;
import com.applovin.impl.tm;
import com.applovin.impl.ue;
import com.applovin.impl.yl;
import com.applovin.impl.zj;
import com.applovin.mediation.MaxAdFormat;
import com.applovin.mediation.MaxAdListener;
import com.applovin.mediation.MaxError;
import com.applovin.mediation.MaxReward;
import com.applovin.mediation.adapter.MaxAdViewAdapter;
import com.applovin.mediation.adapter.MaxAdapter;
import com.applovin.mediation.adapter.MaxAdapterError;
import com.applovin.mediation.adapter.MaxAppOpenAdapter;
import com.applovin.mediation.adapter.MaxInterstitialAdViewAdapter;
import com.applovin.mediation.adapter.MaxInterstitialAdapter;
import com.applovin.mediation.adapter.MaxRewardedAdViewAdapter;
import com.applovin.mediation.adapter.MaxRewardedAdapter;
import com.applovin.mediation.adapter.MaxRewardedInterstitialAdapter;
import com.applovin.mediation.adapter.MaxSignalProvider;
import com.applovin.mediation.adapter.listeners.MaxAdViewAdapterListener;
import com.applovin.mediation.adapter.listeners.MaxAppOpenAdapterListener;
import com.applovin.mediation.adapter.listeners.MaxInterstitialAdapterListener;
import com.applovin.mediation.adapter.listeners.MaxNativeAdAdapterListener;
import com.applovin.mediation.adapter.listeners.MaxRewardedAdapterListener;
import com.applovin.mediation.adapter.listeners.MaxRewardedInterstitialAdapterListener;
import com.applovin.mediation.adapter.listeners.MaxSignalCollectionListener;
import com.applovin.mediation.adapter.parameters.MaxAdapterInitializationParameters;
import com.applovin.mediation.adapter.parameters.MaxAdapterResponseParameters;
import com.applovin.mediation.adapter.parameters.MaxAdapterSignalCollectionParameters;
import com.applovin.mediation.adapters.MediationAdapterBase;
import com.applovin.mediation.nativeAds.MaxNativeAd;
import com.applovin.mediation.nativeAds.MaxNativeAdView;
import com.applovin.sdk.AppLovinSdkUtils;
import com.facebook.internal.ServerProtocol;
import com.revenuecat.purchases.common.Constants;
import com.revenuecat.purchases.ui.revenuecatui.templates.VWmQ.cJfnYMIyomoWf;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.experimental.kJ.HcgZcEUYo;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class g {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.applovin.impl.sdk.j f61734b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final com.applovin.impl.sdk.n f61735c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f61736d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final oe f61737e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final String f61738f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private MaxAdapter f61739g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private String f61740h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private fe f61741i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private View f61742j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private MaxNativeAd f61743k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private MaxNativeAdView f61744l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private ViewGroup f61745m;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private MaxAdapterResponseParameters f61747o;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private final boolean f61751s;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Handler f61733a = new Handler(Looper.getMainLooper());

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final d f61746n = new d(this, null);

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private final AtomicBoolean f61748p = new AtomicBoolean(true);

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private final AtomicBoolean f61749q = new AtomicBoolean(false);

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private final AtomicBoolean f61750r = new AtomicBoolean(false);

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class a implements MaxSignalCollectionListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ zj f61752a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ f f61753b;

        a(zj zjVar, f fVar) {
            this.f61752a = zjVar;
            this.f61753b = fVar;
        }

        @Override // com.applovin.mediation.adapter.listeners.MaxSignalCollectionListener
        public void onSignalCollected(String str) {
            if (this.f61752a.x() && TextUtils.isEmpty(str)) {
                g.this.a(new MaxErrorImpl("Signal is not a valid string"), this.f61753b);
            } else {
                g.this.a(str, this.f61753b);
            }
        }

        @Override // com.applovin.mediation.adapter.listeners.MaxSignalCollectionListener
        public void onSignalCollectionFailed(String str) {
            g.this.a(new MaxErrorImpl(str), this.f61753b);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            MaxAdapter maxAdapter = g.this.f61739g;
            if (maxAdapter != null) {
                g.this.f61739g = null;
                maxAdapter.onDestroy();
            } else {
                com.applovin.impl.sdk.n unused = g.this.f61735c;
                if (com.applovin.impl.sdk.n.a()) {
                    g.this.f61735c.k("MediationAdapterWrapper", "Mediation adapter '" + g.this.f61738f + "' is already destroyed");
                }
            }
            g.this.f61742j = null;
            g.this.f61743k = null;
            g.this.f61744l = null;
            g.this.f61745m = null;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface c {
        void a(MaxError maxError);

        void onSignalCollected(String str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class d implements MaxInterstitialAdapterListener, MaxAppOpenAdapterListener, MaxRewardedAdapterListener, MaxRewardedInterstitialAdapterListener, MaxAdViewAdapterListener, MaxNativeAdAdapterListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private MediationServiceImpl.d f61756a;

        private d() {
        }

        @Override // com.applovin.mediation.adapter.listeners.MaxAdViewAdapterListener
        public void onAdViewAdClicked() {
            onAdViewAdClicked(null);
        }

        @Override // com.applovin.mediation.adapter.listeners.MaxAdViewAdapterListener
        public void onAdViewAdCollapsed() {
            onAdViewAdCollapsed(null);
        }

        @Override // com.applovin.mediation.adapter.listeners.MaxAdViewAdapterListener
        public void onAdViewAdDisplayFailed(MaxAdapterError maxAdapterError) {
            onAdViewAdDisplayFailed(maxAdapterError, null);
        }

        @Override // com.applovin.mediation.adapter.listeners.MaxAdViewAdapterListener
        public void onAdViewAdDisplayed() {
            onAdViewAdDisplayed(null);
        }

        @Override // com.applovin.mediation.adapter.listeners.MaxAdViewAdapterListener
        public void onAdViewAdExpanded() {
            onAdViewAdExpanded(null);
        }

        @Override // com.applovin.mediation.adapter.listeners.MaxAdViewAdapterListener
        public void onAdViewAdHidden() {
            onAdViewAdHidden(null);
        }

        @Override // com.applovin.mediation.adapter.listeners.MaxAdViewAdapterListener
        public void onAdViewAdLoadFailed(MaxAdapterError maxAdapterError) {
            com.applovin.impl.sdk.n unused = g.this.f61735c;
            if (com.applovin.impl.sdk.n.a()) {
                g.this.f61735c.k("MediationAdapterWrapper", g.this.f61738f + ": adview ad ad failed to load with error: " + maxAdapterError);
            }
            a("onAdViewAdLoadFailed", maxAdapterError);
        }

        @Override // com.applovin.mediation.adapter.listeners.MaxAdViewAdapterListener
        public void onAdViewAdLoaded(View view) {
            onAdViewAdLoaded(view, null);
        }

        @Override // com.applovin.mediation.adapter.listeners.MaxAppOpenAdapterListener
        public void onAppOpenAdClicked() {
            onAppOpenAdClicked(null);
        }

        @Override // com.applovin.mediation.adapter.listeners.MaxAppOpenAdapterListener
        public void onAppOpenAdDisplayFailed(MaxAdapterError maxAdapterError) {
            onAppOpenAdDisplayFailed(maxAdapterError, null);
        }

        @Override // com.applovin.mediation.adapter.listeners.MaxAppOpenAdapterListener
        public void onAppOpenAdDisplayed() {
            onAppOpenAdDisplayed(null);
        }

        @Override // com.applovin.mediation.adapter.listeners.MaxAppOpenAdapterListener
        public void onAppOpenAdHidden() {
            onAppOpenAdHidden(null);
        }

        @Override // com.applovin.mediation.adapter.listeners.MaxAppOpenAdapterListener
        public void onAppOpenAdLoadFailed(MaxAdapterError maxAdapterError) {
            com.applovin.impl.sdk.n unused = g.this.f61735c;
            if (com.applovin.impl.sdk.n.a()) {
                g.this.f61735c.k("MediationAdapterWrapper", g.this.f61738f + ": app open ad failed to load with error: " + maxAdapterError);
            }
            a("onAppOpenAdLoadFailed", maxAdapterError);
        }

        @Override // com.applovin.mediation.adapter.listeners.MaxAppOpenAdapterListener
        public void onAppOpenAdLoaded() {
            onAppOpenAdLoaded(null);
        }

        @Override // com.applovin.mediation.adapter.listeners.MaxInterstitialAdapterListener
        public void onInterstitialAdClicked() {
            onInterstitialAdClicked(null);
        }

        @Override // com.applovin.mediation.adapter.listeners.MaxInterstitialAdapterListener
        public void onInterstitialAdDisplayFailed(MaxAdapterError maxAdapterError) {
            onInterstitialAdDisplayFailed(maxAdapterError, null);
        }

        @Override // com.applovin.mediation.adapter.listeners.MaxInterstitialAdapterListener
        public void onInterstitialAdDisplayed() {
            onInterstitialAdDisplayed(null);
        }

        @Override // com.applovin.mediation.adapter.listeners.MaxInterstitialAdapterListener
        public void onInterstitialAdHidden() {
            onInterstitialAdHidden(null);
        }

        @Override // com.applovin.mediation.adapter.listeners.MaxInterstitialAdapterListener
        public void onInterstitialAdLoadFailed(MaxAdapterError maxAdapterError) {
            com.applovin.impl.sdk.n unused = g.this.f61735c;
            if (com.applovin.impl.sdk.n.a()) {
                g.this.f61735c.k("MediationAdapterWrapper", g.this.f61738f + ": interstitial ad failed to load with error " + maxAdapterError);
            }
            a("onInterstitialAdLoadFailed", maxAdapterError);
        }

        @Override // com.applovin.mediation.adapter.listeners.MaxInterstitialAdapterListener
        public void onInterstitialAdLoaded() {
            onInterstitialAdLoaded(null);
        }

        @Override // com.applovin.mediation.adapter.listeners.MaxNativeAdAdapterListener
        public void onNativeAdClicked() {
            onNativeAdClicked(null);
        }

        @Override // com.applovin.mediation.adapter.listeners.MaxNativeAdAdapterListener
        public void onNativeAdDisplayed(Bundle bundle) {
            if (g.this.f61741i.Y()) {
                return;
            }
            com.applovin.impl.sdk.n unused = g.this.f61735c;
            if (com.applovin.impl.sdk.n.a()) {
                g.this.f61735c.d("MediationAdapterWrapper", g.this.f61738f + ": native ad displayed with extra info: " + bundle);
            }
            a("onNativeAdDisplayed", bundle);
        }

        @Override // com.applovin.mediation.adapter.listeners.MaxNativeAdAdapterListener
        public void onNativeAdLoadFailed(MaxAdapterError maxAdapterError) {
            com.applovin.impl.sdk.n unused = g.this.f61735c;
            if (com.applovin.impl.sdk.n.a()) {
                g.this.f61735c.k("MediationAdapterWrapper", g.this.f61738f + ": native ad ad failed to load with error: " + maxAdapterError);
            }
            a("onNativeAdLoadFailed", maxAdapterError);
        }

        @Override // com.applovin.mediation.adapter.listeners.MaxNativeAdAdapterListener
        public void onNativeAdLoaded(MaxNativeAd maxNativeAd, Bundle bundle) {
            com.applovin.impl.sdk.n unused = g.this.f61735c;
            if (com.applovin.impl.sdk.n.a()) {
                g.this.f61735c.d("MediationAdapterWrapper", g.this.f61738f + ": native ad loaded with extra info: " + bundle);
            }
            g.this.f61743k = maxNativeAd;
            c("onNativeAdLoaded", bundle);
        }

        @Override // com.applovin.mediation.adapter.listeners.MaxRewardedAdapterListener
        public void onRewardedAdClicked() {
            onRewardedAdClicked(null);
        }

        @Override // com.applovin.mediation.adapter.listeners.MaxRewardedAdapterListener
        public void onRewardedAdDisplayFailed(MaxAdapterError maxAdapterError) {
            onRewardedAdDisplayFailed(maxAdapterError, null);
        }

        @Override // com.applovin.mediation.adapter.listeners.MaxRewardedAdapterListener
        public void onRewardedAdDisplayed() {
            onRewardedAdDisplayed(null);
        }

        @Override // com.applovin.mediation.adapter.listeners.MaxRewardedAdapterListener
        public void onRewardedAdHidden() {
            onRewardedAdHidden(null);
        }

        @Override // com.applovin.mediation.adapter.listeners.MaxRewardedAdapterListener
        public void onRewardedAdLoadFailed(MaxAdapterError maxAdapterError) {
            com.applovin.impl.sdk.n unused = g.this.f61735c;
            if (com.applovin.impl.sdk.n.a()) {
                g.this.f61735c.k("MediationAdapterWrapper", g.this.f61738f + ": rewarded ad failed to load with error: " + maxAdapterError);
            }
            a("onRewardedAdLoadFailed", maxAdapterError);
        }

        @Override // com.applovin.mediation.adapter.listeners.MaxRewardedAdapterListener
        public void onRewardedAdLoaded() {
            onRewardedAdLoaded(null);
        }

        @Override // com.applovin.mediation.adapter.listeners.MaxRewardedInterstitialAdapterListener
        public void onRewardedInterstitialAdClicked() {
            onRewardedInterstitialAdClicked(null);
        }

        @Override // com.applovin.mediation.adapter.listeners.MaxRewardedInterstitialAdapterListener
        public void onRewardedInterstitialAdDisplayFailed(MaxAdapterError maxAdapterError) {
            onRewardedInterstitialAdDisplayFailed(maxAdapterError, null);
        }

        @Override // com.applovin.mediation.adapter.listeners.MaxRewardedInterstitialAdapterListener
        public void onRewardedInterstitialAdDisplayed() {
            onRewardedInterstitialAdDisplayed(null);
        }

        @Override // com.applovin.mediation.adapter.listeners.MaxRewardedInterstitialAdapterListener
        public void onRewardedInterstitialAdHidden() {
            onRewardedInterstitialAdHidden(null);
        }

        @Override // com.applovin.mediation.adapter.listeners.MaxRewardedInterstitialAdapterListener
        public void onRewardedInterstitialAdLoadFailed(MaxAdapterError maxAdapterError) {
            com.applovin.impl.sdk.n unused = g.this.f61735c;
            if (com.applovin.impl.sdk.n.a()) {
                g.this.f61735c.k("MediationAdapterWrapper", g.this.f61738f + ": rewarded ad failed to load with error: " + maxAdapterError);
            }
            a("onRewardedInterstitialAdLoadFailed", maxAdapterError);
        }

        @Override // com.applovin.mediation.adapter.listeners.MaxRewardedInterstitialAdapterListener
        public void onRewardedInterstitialAdLoaded() {
            onRewardedInterstitialAdLoaded(null);
        }

        @Override // com.applovin.mediation.adapter.listeners.MaxRewardedAdapterListener, com.applovin.mediation.adapter.listeners.MaxRewardedInterstitialAdapterListener
        public void onUserRewarded(MaxReward maxReward) {
            onUserRewarded(maxReward, null);
        }

        /* synthetic */ d(g gVar, a aVar) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void a(he heVar, MaxReward maxReward, Bundle bundle) {
            this.f61756a.a(heVar, maxReward, bundle);
        }

        private void b(String str, final Bundle bundle) {
            if (g.this.f61741i.w().compareAndSet(false, true)) {
                a(str, this.f61756a, new Runnable() { // from class: com.applovin.impl.mediation.q0
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f61844a.j(bundle);
                    }
                });
            }
        }

        private void c(String str, final Bundle bundle) {
            if (!g.this.f61741i.w().get()) {
                g.this.f61750r.set(true);
                a(str, this.f61756a, new Runnable() { // from class: com.applovin.impl.mediation.y0
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f61883a.k(bundle);
                    }
                });
                return;
            }
            com.applovin.impl.sdk.n unused = g.this.f61735c;
            if (com.applovin.impl.sdk.n.a()) {
                g.this.f61735c.b("MediationAdapterWrapper", g.this.f61738f + ": blocking ad loaded callback for " + g.this.f61741i + " since onAdHidden() has been called");
            }
            g.this.f61734b.q().a(g.this.f61741i, str);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void d(Bundle bundle) {
            this.f61756a.a(g.this.f61741i, bundle);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void e(Bundle bundle) {
            this.f61756a.a(g.this.f61741i, bundle);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void f(Bundle bundle) {
            this.f61756a.a(g.this.f61741i, bundle);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void g(Bundle bundle) {
            this.f61756a.a(g.this.f61741i, bundle);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void h(Bundle bundle) {
            this.f61756a.c(g.this.f61741i, bundle);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void i(Bundle bundle) {
            this.f61756a.c(g.this.f61741i, bundle);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void j(Bundle bundle) {
            this.f61756a.e(g.this.f61741i, bundle);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void k(Bundle bundle) {
            if (g.this.f61749q.compareAndSet(false, true)) {
                this.f61756a.f(g.this.f61741i, bundle);
            }
        }

        @Override // com.applovin.mediation.adapter.listeners.MaxAdViewAdapterListener
        public void onAdViewAdClicked(final Bundle bundle) {
            com.applovin.impl.sdk.n unused = g.this.f61735c;
            if (com.applovin.impl.sdk.n.a()) {
                g.this.f61735c.d("MediationAdapterWrapper", g.this.f61738f + ": adview ad clicked with extra info: " + bundle);
            }
            a("onAdViewAdClicked", this.f61756a, new Runnable() { // from class: com.applovin.impl.mediation.p0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f61840a.a(bundle);
                }
            });
        }

        @Override // com.applovin.mediation.adapter.listeners.MaxAdViewAdapterListener
        public void onAdViewAdCollapsed(Bundle bundle) {
            com.applovin.impl.sdk.n unused = g.this.f61735c;
            if (com.applovin.impl.sdk.n.a()) {
                g.this.f61735c.d("MediationAdapterWrapper", g.this.f61738f + ": adview ad collapsed");
            }
            a("onAdViewAdCollapsed", this.f61756a, new Runnable() { // from class: com.applovin.impl.mediation.s0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f61853a.a();
                }
            });
        }

        @Override // com.applovin.mediation.adapter.listeners.MaxAdViewAdapterListener
        public void onAdViewAdDisplayFailed(MaxAdapterError maxAdapterError, Bundle bundle) {
            com.applovin.impl.sdk.n unused = g.this.f61735c;
            if (com.applovin.impl.sdk.n.a()) {
                g.this.f61735c.k("MediationAdapterWrapper", g.this.f61738f + ": adview ad failed to display with error: " + maxAdapterError);
            }
            a("onAdViewAdDisplayFailed", maxAdapterError, bundle);
        }

        @Override // com.applovin.mediation.adapter.listeners.MaxAdViewAdapterListener
        public void onAdViewAdDisplayed(Bundle bundle) {
            if (g.this.f61741i.Y()) {
                return;
            }
            com.applovin.impl.sdk.n unused = g.this.f61735c;
            if (com.applovin.impl.sdk.n.a()) {
                g.this.f61735c.d("MediationAdapterWrapper", g.this.f61738f + ": adview ad displayed with extra info: " + bundle);
            }
            a("onAdViewAdDisplayed", bundle);
        }

        @Override // com.applovin.mediation.adapter.listeners.MaxAdViewAdapterListener
        public void onAdViewAdExpanded(final Bundle bundle) {
            com.applovin.impl.sdk.n unused = g.this.f61735c;
            if (com.applovin.impl.sdk.n.a()) {
                g.this.f61735c.d("MediationAdapterWrapper", g.this.f61738f + ": adview ad expanded");
            }
            a("onAdViewAdExpanded", this.f61756a, new Runnable() { // from class: com.applovin.impl.mediation.u0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f61861a.b(bundle);
                }
            });
        }

        @Override // com.applovin.mediation.adapter.listeners.MaxAdViewAdapterListener
        public void onAdViewAdHidden(Bundle bundle) {
            com.applovin.impl.sdk.n unused = g.this.f61735c;
            if (com.applovin.impl.sdk.n.a()) {
                g.this.f61735c.d("MediationAdapterWrapper", g.this.f61738f + ": adview ad hidden with extra info: " + bundle);
            }
            b("onAdViewAdHidden", bundle);
        }

        @Override // com.applovin.mediation.adapter.listeners.MaxAdViewAdapterListener
        public void onAdViewAdLoaded(View view, Bundle bundle) {
            com.applovin.impl.sdk.n unused = g.this.f61735c;
            if (com.applovin.impl.sdk.n.a()) {
                g.this.f61735c.d("MediationAdapterWrapper", g.this.f61738f + ": adview ad loaded with extra info: " + bundle);
            }
            g.this.f61742j = view;
            c("onAdViewAdLoaded", bundle);
        }

        @Override // com.applovin.mediation.adapter.listeners.MaxAppOpenAdapterListener
        public void onAppOpenAdClicked(final Bundle bundle) {
            com.applovin.impl.sdk.n unused = g.this.f61735c;
            if (com.applovin.impl.sdk.n.a()) {
                g.this.f61735c.d("MediationAdapterWrapper", g.this.f61738f + ": app open ad clicked with extra info: " + bundle);
            }
            a("onAppOpenAdClicked", this.f61756a, new Runnable() { // from class: com.applovin.impl.mediation.n0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f61827a.c(bundle);
                }
            });
        }

        @Override // com.applovin.mediation.adapter.listeners.MaxAppOpenAdapterListener
        public void onAppOpenAdDisplayFailed(MaxAdapterError maxAdapterError, Bundle bundle) {
            com.applovin.impl.sdk.n unused = g.this.f61735c;
            if (com.applovin.impl.sdk.n.a()) {
                g.this.f61735c.k("MediationAdapterWrapper", g.this.f61738f + ": app open ad display failed with error: " + maxAdapterError);
            }
            a("onAppOpenAdDisplayFailed", maxAdapterError, bundle);
        }

        @Override // com.applovin.mediation.adapter.listeners.MaxAppOpenAdapterListener
        public void onAppOpenAdDisplayed(Bundle bundle) {
            com.applovin.impl.sdk.n unused = g.this.f61735c;
            if (com.applovin.impl.sdk.n.a()) {
                g.this.f61735c.d("MediationAdapterWrapper", g.this.f61738f + ": app open ad displayed with extra info: " + bundle);
            }
            a("onAppOpenAdDisplayed", bundle);
        }

        @Override // com.applovin.mediation.adapter.listeners.MaxAppOpenAdapterListener
        public void onAppOpenAdHidden(Bundle bundle) {
            com.applovin.impl.sdk.n unused = g.this.f61735c;
            if (com.applovin.impl.sdk.n.a()) {
                g.this.f61735c.d("MediationAdapterWrapper", g.this.f61738f + ": app open ad hidden with extra info: " + bundle);
            }
            b("onAppOpenAdHidden", bundle);
        }

        @Override // com.applovin.mediation.adapter.listeners.MaxAppOpenAdapterListener
        public void onAppOpenAdLoaded(Bundle bundle) {
            com.applovin.impl.sdk.n unused = g.this.f61735c;
            if (com.applovin.impl.sdk.n.a()) {
                g.this.f61735c.d("MediationAdapterWrapper", g.this.f61738f + ": app open ad loaded with extra info: " + bundle);
            }
            c("onAppOpenAdLoaded", bundle);
        }

        @Override // com.applovin.mediation.adapter.listeners.MaxInterstitialAdapterListener
        public void onInterstitialAdClicked(final Bundle bundle) {
            com.applovin.impl.sdk.n unused = g.this.f61735c;
            if (com.applovin.impl.sdk.n.a()) {
                g.this.f61735c.d("MediationAdapterWrapper", g.this.f61738f + ": interstitial ad clicked with extra info: " + bundle);
            }
            a("onInterstitialAdClicked", this.f61756a, new Runnable() { // from class: com.applovin.impl.mediation.c1
                @Override // java.lang.Runnable
                public final void run() {
                    this.f61616a.d(bundle);
                }
            });
        }

        @Override // com.applovin.mediation.adapter.listeners.MaxInterstitialAdapterListener
        public void onInterstitialAdDisplayFailed(MaxAdapterError maxAdapterError, Bundle bundle) {
            com.applovin.impl.sdk.n unused = g.this.f61735c;
            if (com.applovin.impl.sdk.n.a()) {
                g.this.f61735c.k("MediationAdapterWrapper", g.this.f61738f + ": interstitial ad failed to display with error " + maxAdapterError);
            }
            a("onInterstitialAdDisplayFailed", maxAdapterError, bundle);
        }

        @Override // com.applovin.mediation.adapter.listeners.MaxInterstitialAdapterListener
        public void onInterstitialAdDisplayed(Bundle bundle) {
            com.applovin.impl.sdk.n unused = g.this.f61735c;
            if (com.applovin.impl.sdk.n.a()) {
                g.this.f61735c.d("MediationAdapterWrapper", g.this.f61738f + ": interstitial ad displayed with extra info: " + bundle);
            }
            a("onInterstitialAdDisplayed", bundle);
        }

        @Override // com.applovin.mediation.adapter.listeners.MaxInterstitialAdapterListener
        public void onInterstitialAdHidden(Bundle bundle) {
            com.applovin.impl.sdk.n unused = g.this.f61735c;
            if (com.applovin.impl.sdk.n.a()) {
                g.this.f61735c.d("MediationAdapterWrapper", g.this.f61738f + ": interstitial ad hidden with extra info " + bundle);
            }
            b("onInterstitialAdHidden", bundle);
        }

        @Override // com.applovin.mediation.adapter.listeners.MaxInterstitialAdapterListener
        public void onInterstitialAdLoaded(Bundle bundle) {
            com.applovin.impl.sdk.n unused = g.this.f61735c;
            if (com.applovin.impl.sdk.n.a()) {
                g.this.f61735c.d("MediationAdapterWrapper", g.this.f61738f + ": interstitial ad loaded with extra info: " + bundle);
            }
            c("onInterstitialAdLoaded", bundle);
        }

        @Override // com.applovin.mediation.adapter.listeners.MaxNativeAdAdapterListener
        public void onNativeAdClicked(final Bundle bundle) {
            com.applovin.impl.sdk.n unused = g.this.f61735c;
            if (com.applovin.impl.sdk.n.a()) {
                g.this.f61735c.d("MediationAdapterWrapper", g.this.f61738f + ": native ad clicked");
            }
            a("onNativeAdClicked", this.f61756a, new Runnable() { // from class: com.applovin.impl.mediation.w0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f61871a.e(bundle);
                }
            });
        }

        @Override // com.applovin.mediation.adapter.listeners.MaxRewardedAdapterListener
        public void onRewardedAdClicked(final Bundle bundle) {
            com.applovin.impl.sdk.n unused = g.this.f61735c;
            if (com.applovin.impl.sdk.n.a()) {
                g.this.f61735c.d("MediationAdapterWrapper", g.this.f61738f + ": rewarded ad clicked with extra info: " + bundle);
            }
            a("onRewardedAdClicked", this.f61756a, new Runnable() { // from class: com.applovin.impl.mediation.r0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f61848a.f(bundle);
                }
            });
        }

        @Override // com.applovin.mediation.adapter.listeners.MaxRewardedAdapterListener
        public void onRewardedAdDisplayFailed(MaxAdapterError maxAdapterError, Bundle bundle) {
            com.applovin.impl.sdk.n unused = g.this.f61735c;
            if (com.applovin.impl.sdk.n.a()) {
                g.this.f61735c.k("MediationAdapterWrapper", g.this.f61738f + ": rewarded ad display failed with error: " + maxAdapterError);
            }
            a("onRewardedAdDisplayFailed", maxAdapterError, bundle);
        }

        @Override // com.applovin.mediation.adapter.listeners.MaxRewardedAdapterListener
        public void onRewardedAdDisplayed(Bundle bundle) {
            com.applovin.impl.sdk.n unused = g.this.f61735c;
            if (com.applovin.impl.sdk.n.a()) {
                g.this.f61735c.d("MediationAdapterWrapper", g.this.f61738f + ": rewarded ad displayed with extra info: " + bundle);
            }
            a("onRewardedAdDisplayed", bundle);
        }

        @Override // com.applovin.mediation.adapter.listeners.MaxRewardedAdapterListener
        public void onRewardedAdHidden(Bundle bundle) {
            com.applovin.impl.sdk.n unused = g.this.f61735c;
            if (com.applovin.impl.sdk.n.a()) {
                g.this.f61735c.d("MediationAdapterWrapper", g.this.f61738f + ": rewarded ad hidden with extra info: " + bundle);
            }
            b("onRewardedAdHidden", bundle);
        }

        @Override // com.applovin.mediation.adapter.listeners.MaxRewardedAdapterListener
        public void onRewardedAdLoaded(Bundle bundle) {
            com.applovin.impl.sdk.n unused = g.this.f61735c;
            if (com.applovin.impl.sdk.n.a()) {
                g.this.f61735c.d("MediationAdapterWrapper", g.this.f61738f + ": rewarded ad loaded with extra info: " + bundle);
            }
            c("onRewardedAdLoaded", bundle);
        }

        @Override // com.applovin.mediation.adapter.listeners.MaxRewardedInterstitialAdapterListener
        public void onRewardedInterstitialAdClicked(final Bundle bundle) {
            com.applovin.impl.sdk.n unused = g.this.f61735c;
            if (com.applovin.impl.sdk.n.a()) {
                g.this.f61735c.d("MediationAdapterWrapper", g.this.f61738f + ": rewarded interstitial ad clicked with extra info: " + bundle);
            }
            a("onRewardedInterstitialAdClicked", this.f61756a, new Runnable() { // from class: com.applovin.impl.mediation.v0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f61866a.g(bundle);
                }
            });
        }

        @Override // com.applovin.mediation.adapter.listeners.MaxRewardedInterstitialAdapterListener
        public void onRewardedInterstitialAdDisplayFailed(MaxAdapterError maxAdapterError, Bundle bundle) {
            com.applovin.impl.sdk.n unused = g.this.f61735c;
            if (com.applovin.impl.sdk.n.a()) {
                g.this.f61735c.k("MediationAdapterWrapper", g.this.f61738f + ": rewarded interstitial ad display failed with error: " + maxAdapterError);
            }
            a("onRewardedInterstitialAdDisplayFailed", maxAdapterError, bundle);
        }

        @Override // com.applovin.mediation.adapter.listeners.MaxRewardedInterstitialAdapterListener
        public void onRewardedInterstitialAdDisplayed(Bundle bundle) {
            com.applovin.impl.sdk.n unused = g.this.f61735c;
            if (com.applovin.impl.sdk.n.a()) {
                g.this.f61735c.d("MediationAdapterWrapper", g.this.f61738f + ": rewarded interstitial ad displayed with extra info: " + bundle);
            }
            a("onRewardedInterstitialAdDisplayed", bundle);
        }

        @Override // com.applovin.mediation.adapter.listeners.MaxRewardedInterstitialAdapterListener
        public void onRewardedInterstitialAdHidden(Bundle bundle) {
            com.applovin.impl.sdk.n unused = g.this.f61735c;
            if (com.applovin.impl.sdk.n.a()) {
                g.this.f61735c.d("MediationAdapterWrapper", g.this.f61738f + ": rewarded interstitial ad hidden with extra info: " + bundle);
            }
            b("onRewardedInterstitialAdHidden", bundle);
        }

        @Override // com.applovin.mediation.adapter.listeners.MaxRewardedInterstitialAdapterListener
        public void onRewardedInterstitialAdLoaded(Bundle bundle) {
            com.applovin.impl.sdk.n unused = g.this.f61735c;
            if (com.applovin.impl.sdk.n.a()) {
                g.this.f61735c.d("MediationAdapterWrapper", g.this.f61738f + ": rewarded interstitial ad loaded with extra info: " + bundle);
            }
            c("onRewardedInterstitialAdLoaded", bundle);
        }

        @Override // com.applovin.mediation.adapter.listeners.MaxRewardedAdapterListener, com.applovin.mediation.adapter.listeners.MaxRewardedInterstitialAdapterListener
        public void onUserRewarded(final MaxReward maxReward, final Bundle bundle) {
            if (g.this.f61741i instanceof he) {
                final he heVar = (he) g.this.f61741i;
                if (heVar.p0().compareAndSet(false, true)) {
                    com.applovin.impl.sdk.n unused = g.this.f61735c;
                    if (com.applovin.impl.sdk.n.a()) {
                        g.this.f61735c.d("MediationAdapterWrapper", g.this.f61738f + ": user was rewarded: " + maxReward);
                    }
                    a("onUserRewarded", this.f61756a, new Runnable() { // from class: com.applovin.impl.mediation.x0
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f61876a.a(heVar, maxReward, bundle);
                        }
                    });
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void b(Bundle bundle) {
            this.f61756a.d(g.this.f61741i, bundle);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(MediationServiceImpl.d dVar) {
            if (dVar != null) {
                this.f61756a = dVar;
                return;
            }
            throw new IllegalArgumentException("No listener specified");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void c(Bundle bundle) {
            this.f61756a.a(g.this.f61741i, bundle);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(String str, final MaxError maxError) {
            if (g.this.f61741i.w().get()) {
                com.applovin.impl.sdk.n unused = g.this.f61735c;
                if (com.applovin.impl.sdk.n.a()) {
                    g.this.f61735c.b("MediationAdapterWrapper", g.this.f61738f + ": blocking ad load failed callback for " + g.this.f61741i + " since onAdHidden() has been called");
                }
                g.this.f61734b.q().a(g.this.f61741i, str);
                return;
            }
            a(str, this.f61756a, new Runnable() { // from class: com.applovin.impl.mediation.o0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f61836a.a(maxError);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void a(MaxError maxError) {
            if (g.this.f61749q.compareAndSet(false, true)) {
                this.f61756a.onAdLoadFailed(g.this.f61740h, maxError);
            }
        }

        private void a(String str, final Bundle bundle) {
            if (!g.this.f61741i.w().get()) {
                if (!((Boolean) g.this.f61734b.a(ue.K7)).booleanValue()) {
                    if (g.this.f61741i.u().compareAndSet(false, true)) {
                        a(str, this.f61756a, new Runnable() { // from class: com.applovin.impl.mediation.a1
                            @Override // java.lang.Runnable
                            public final void run() {
                                this.f61477a.i(bundle);
                            }
                        });
                        return;
                    }
                    return;
                }
                a(str, this.f61756a, new Runnable() { // from class: com.applovin.impl.mediation.z0
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f61888a.h(bundle);
                    }
                });
                return;
            }
            com.applovin.impl.sdk.n unused = g.this.f61735c;
            if (com.applovin.impl.sdk.n.a()) {
                g.this.f61735c.b("MediationAdapterWrapper", g.this.f61738f + ": blocking ad displayed callback for " + g.this.f61741i + " since onAdHidden() has been called");
            }
            g.this.f61734b.q().a(g.this.f61741i, str);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(String str, final MaxError maxError, final Bundle bundle) {
            if (g.this.f61741i.w().get()) {
                com.applovin.impl.sdk.n unused = g.this.f61735c;
                if (com.applovin.impl.sdk.n.a()) {
                    g.this.f61735c.b("MediationAdapterWrapper", g.this.f61738f + ": blocking ad display failed callback for " + g.this.f61741i + " since onAdHidden() has been called");
                }
                g.this.f61734b.q().a(g.this.f61741i, str);
                return;
            }
            a(str, this.f61756a, new Runnable() { // from class: com.applovin.impl.mediation.t0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f61855a.a(maxError, bundle);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void a(MaxError maxError, Bundle bundle) {
            this.f61756a.a(g.this.f61741i, maxError, bundle);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void a(Bundle bundle) {
            this.f61756a.a(g.this.f61741i, bundle);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void a() {
            this.f61756a.onAdCollapsed(g.this.f61741i);
        }

        private void a(final String str, final MaxAdListener maxAdListener, final Runnable runnable) {
            g.this.f61733a.post(new Runnable() { // from class: com.applovin.impl.mediation.b1
                @Override // java.lang.Runnable
                public final void run() {
                    this.f61606a.a(runnable, maxAdListener, str);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void a(Runnable runnable, MaxAdListener maxAdListener, String str) {
            try {
                runnable.run();
            } catch (Throwable th) {
                com.applovin.impl.sdk.n.c("MediationAdapterWrapper", "Failed to forward call (" + str + ") to " + (maxAdListener != null ? maxAdListener.getClass().getName() : null), th);
                g.this.f61734b.D().a("MediationAdapterWrapper", str, th, CollectionUtils.hashMap("adapter_class", g.this.f61737e.b()));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class e implements MaxAdapter.OnCompletionListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final com.applovin.impl.sdk.j f61758a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final oe f61759b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final long f61760c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final MaxAdapter.OnCompletionListener f61761d;

        public e(com.applovin.impl.sdk.j jVar, oe oeVar, long j3, MaxAdapter.OnCompletionListener onCompletionListener) {
            this.f61758a = jVar;
            this.f61759b = oeVar;
            this.f61760c = j3;
            this.f61761d = onCompletionListener;
        }

        @Override // com.applovin.mediation.adapter.MaxAdapter.OnCompletionListener
        public void onCompletion(final MaxAdapter.InitializationStatus initializationStatus, final String str) {
            AppLovinSdkUtils.runOnUiThreadDelayed(new Runnable() { // from class: com.applovin.impl.mediation.d1
                @Override // java.lang.Runnable
                public final void run() {
                    this.f61662a.a(initializationStatus, str);
                }
            }, this.f61759b.h());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void a(MaxAdapter.InitializationStatus initializationStatus, String str) {
            this.f61758a.K().a(this.f61759b, SystemClock.elapsedRealtime() - this.f61760c, initializationStatus, str);
            MaxAdapter.OnCompletionListener onCompletionListener = this.f61761d;
            if (onCompletionListener != null) {
                onCompletionListener.onCompletion(initializationStatus, str);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final zj f61762a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final c f61763b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final AtomicBoolean f61764c = new AtomicBoolean();

        f(zj zjVar, c cVar) {
            this.f61762a = zjVar;
            this.f61763b = cVar;
        }
    }

    /* JADX INFO: renamed from: com.applovin.impl.mediation.g$g, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private class C0113g extends yl {

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private final WeakReference f61765h;

        /* synthetic */ C0113g(g gVar, a aVar) {
            this();
        }

        private void b(fe feVar) {
            if (feVar != null) {
                this.f65231a.R().a(feVar);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (g.this.f61749q.get()) {
                return;
            }
            if (g.this.f61741i.Z()) {
                if (com.applovin.impl.sdk.n.a()) {
                    this.f65233c.a(this.f65232b, g.this.f61738f + " is timing out, considering JS Tag ad loaded: " + g.this.f61741i);
                }
                b(g.this.f61741i);
                return;
            }
            if (com.applovin.impl.sdk.n.a()) {
                this.f65233c.b(this.f65232b, g.this.f61738f + " is timing out " + g.this.f61741i + "...");
            }
            b(g.this.f61741i);
            MaxErrorImpl maxErrorImpl = new MaxErrorImpl(-5101, "Adapter timed out");
            d dVar = (d) this.f61765h.get();
            if (dVar != null) {
                dVar.a(this.f65232b, maxErrorImpl);
            }
        }

        private C0113g() {
            super("TaskTimeoutMediatedAd", g.this.f61734b);
            this.f61765h = new WeakReference(g.this.f61746n);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private class h extends yl {

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private final f f61767h;

        /* synthetic */ h(g gVar, f fVar, a aVar) {
            this(fVar);
        }

        private h(f fVar) {
            super("TaskTimeoutSignalCollection", g.this.f61734b);
            this.f61767h = fVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f61767h.f61764c.get()) {
                return;
            }
            if (com.applovin.impl.sdk.n.a()) {
                this.f65233c.b(this.f65232b, g.this.f61738f + " is timing out " + this.f61767h.f61762a + "...");
            }
            g.this.a(new MaxErrorImpl(MaxAdapterError.ERROR_CODE_SIGNAL_COLLECTION_TIMEOUT, "The adapter (" + g.this.f61738f + HcgZcEUYo.HaqpWKemlhEBsHN), this.f61767h);
        }
    }

    g(oe oeVar, MaxAdapter maxAdapter, boolean z2, com.applovin.impl.sdk.j jVar) {
        if (oeVar == null) {
            throw new IllegalArgumentException("No adapter name specified");
        }
        if (maxAdapter == null) {
            throw new IllegalArgumentException("No adapter specified");
        }
        if (jVar == null) {
            throw new IllegalArgumentException("No sdk specified");
        }
        this.f61736d = oeVar.c();
        this.f61739g = maxAdapter;
        this.f61734b = jVar;
        this.f61735c = jVar.I();
        this.f61737e = oeVar;
        this.f61738f = maxAdapter.getClass().getSimpleName();
        this.f61751s = z2;
    }

    public String toString() {
        return "MediationAdapterWrapper{adapterTag='" + this.f61738f + "'}";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void l() {
        a("destroy");
        b bVar = new b();
        if (((Boolean) this.f61734b.a(ue.M7)).booleanValue()) {
            AppLovinSdkUtils.runOnUiThread(bVar);
        } else {
            bVar.run();
        }
    }

    void a(final MaxAdapterSignalCollectionParameters maxAdapterSignalCollectionParameters, final zj zjVar, final Activity activity, c cVar) {
        if (cVar == null) {
            throw new IllegalArgumentException("No callback specified");
        }
        if (!this.f61748p.get()) {
            com.applovin.impl.sdk.n.h("MediationAdapterWrapper", "Mediation adapter '" + this.f61738f + "' is disabled. Signal collection ads with this adapter is disabled.");
            cVar.a(new MaxErrorImpl("The adapter (" + this.f61738f + ") is disabled"));
            return;
        }
        final f fVar = new f(zjVar, cVar);
        MaxAdapter maxAdapter = this.f61739g;
        if (maxAdapter instanceof MaxSignalProvider) {
            final MaxSignalProvider maxSignalProvider = (MaxSignalProvider) maxAdapter;
            b("collect_signal", new Runnable() { // from class: com.applovin.impl.mediation.i0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f61785a.a(zjVar, fVar, maxSignalProvider, maxAdapterSignalCollectionParameters, activity);
                }
            });
            return;
        }
        a(new MaxErrorImpl(MaxAdapterError.ERROR_CODE_SIGNAL_COLLECTION_NOT_SUPPORTED, "The adapter (" + this.f61738f + ") does not support signal collection"), fVar);
    }

    public void c(final fe feVar, final Activity activity) {
        Runnable runnable;
        if (b(feVar, activity)) {
            if (feVar.Y()) {
                runnable = new Runnable() { // from class: com.applovin.impl.mediation.u
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f61858a.a(feVar, activity);
                    }
                };
            } else if (feVar.getFormat() == MaxAdFormat.INTERSTITIAL) {
                runnable = new Runnable() { // from class: com.applovin.impl.mediation.e0
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f61717a.d(activity);
                    }
                };
            } else if (feVar.getFormat() == MaxAdFormat.APP_OPEN) {
                runnable = new Runnable() { // from class: com.applovin.impl.mediation.f0
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f61731a.a(activity);
                    }
                };
            } else if (feVar.getFormat() == MaxAdFormat.REWARDED) {
                runnable = new Runnable() { // from class: com.applovin.impl.mediation.g0
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f61769a.b(activity);
                    }
                };
            } else {
                if (feVar.getFormat() != MaxAdFormat.REWARDED_INTERSTITIAL) {
                    throw new IllegalStateException("Failed to show " + feVar + ": " + feVar.getFormat() + " is not a supported ad format");
                }
                runnable = new Runnable() { // from class: com.applovin.impl.mediation.h0
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f61776a.c(activity);
                    }
                };
            }
            a(runnable, feVar);
        }
    }

    public String g() {
        return this.f61736d;
    }

    public ViewGroup h() {
        return this.f61745m;
    }

    public String i() {
        MaxAdapter maxAdapter = this.f61739g;
        if (maxAdapter == null) {
            return null;
        }
        try {
            return maxAdapter.getSdkVersion();
        } catch (Throwable th) {
            com.applovin.impl.sdk.n.c("MediationAdapterWrapper", "Failed to get adapter's SDK version for " + this.f61736d, th);
            this.f61734b.D().a("MediationAdapterWrapper", "sdk_version", th, CollectionUtils.hashMap("adapter_class", this.f61737e.b()));
            a("sdk_version");
            this.f61734b.L().a(this.f61737e.b(), "sdk_version", this.f61741i);
            return null;
        }
    }

    public boolean j() {
        return this.f61749q.get() && this.f61750r.get();
    }

    public boolean k() {
        return this.f61748p.get();
    }

    private boolean b(fe feVar, Activity activity) {
        if (feVar != null) {
            if (feVar.A() == null) {
                com.applovin.impl.sdk.n.h("MediationAdapterWrapper", "Adapter has been garbage collected");
                this.f61746n.a("ad_show", new MaxErrorImpl(-1, "Adapter has been garbage collected"), (Bundle) null);
                return false;
            }
            if (feVar.A() == this) {
                if (activity == null && MaxAdFormat.APP_OPEN != feVar.getFormat()) {
                    throw new IllegalArgumentException("No activity specified");
                }
                if (!this.f61748p.get()) {
                    String str = "Mediation adapter '" + this.f61738f + "' is disabled. Showing ads with this adapter is disabled.";
                    com.applovin.impl.sdk.n.h("MediationAdapterWrapper", str);
                    this.f61746n.a("ad_show", new MaxErrorImpl(-1, str), (Bundle) null);
                    return false;
                }
                if (j()) {
                    return true;
                }
                throw new IllegalStateException("Mediation adapter '" + this.f61738f + cJfnYMIyomoWf.CwenEP);
            }
            throw new IllegalArgumentException("Mediated ad belongs to a different adapter");
        }
        throw new IllegalArgumentException("No mediated ad specified");
    }

    public View d() {
        return this.f61742j;
    }

    public MaxNativeAd e() {
        return this.f61743k;
    }

    public MaxNativeAdView f() {
        return this.f61744l;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void d(MaxAdapterResponseParameters maxAdapterResponseParameters, Activity activity) {
        ((MaxRewardedInterstitialAdapter) this.f61739g).loadRewardedInterstitialAd(maxAdapterResponseParameters, activity, this.f61746n);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void e(MaxAdapterResponseParameters maxAdapterResponseParameters, Activity activity) {
        ((MediationAdapterBase) this.f61739g).loadNativeAd(maxAdapterResponseParameters, activity, this.f61746n);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void d(Activity activity) {
        ((MaxInterstitialAdapter) this.f61739g).showInterstitialAd(this.f61747o, activity, this.f61746n);
    }

    private void a(final Runnable runnable, fe feVar) {
        a("show_ad", feVar.getFormat(), new Runnable() { // from class: com.applovin.impl.mediation.c0
            @Override // java.lang.Runnable
            public final void run() {
                this.f61614a.a(runnable);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(zj zjVar, f fVar, MaxSignalProvider maxSignalProvider, MaxAdapterSignalCollectionParameters maxAdapterSignalCollectionParameters, Activity activity) {
        a(zjVar, fVar);
        try {
            maxSignalProvider.collectSignal(maxAdapterSignalCollectionParameters, activity, new a(zjVar, fVar));
        } catch (Throwable th) {
            MaxErrorImpl maxErrorImpl = new MaxErrorImpl("Failed signal collection for " + this.f61736d + " due to: " + th);
            com.applovin.impl.sdk.n.h("MediationAdapterWrapper", maxErrorImpl.getMessage());
            a(maxErrorImpl, fVar);
            this.f61734b.D().a("MediationAdapterWrapper", "collect_signal", th, CollectionUtils.hashMap("adapter_class", this.f61737e.b()));
            a("collect_signal");
            this.f61734b.L().a(this.f61737e.b(), "collect_signal", this.f61741i);
        }
        if (!fVar.f61764c.get() && zjVar.m() == 0) {
            if (com.applovin.impl.sdk.n.a()) {
                this.f61735c.a("MediationAdapterWrapper", "Failing signal collection " + zjVar + " since it has 0 timeout");
            }
            a(new MaxErrorImpl(MaxAdapterError.ERROR_CODE_SIGNAL_COLLECTION_TIMEOUT, "The adapter (" + this.f61738f + ") has 0 timeout"), fVar);
        }
    }

    public MediationServiceImpl.d c() {
        return this.f61746n.f61756a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c(MaxAdapterResponseParameters maxAdapterResponseParameters, Activity activity) {
        ((MaxRewardedAdapter) this.f61739g).loadRewardedAd(maxAdapterResponseParameters, activity, this.f61746n);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(MaxAdapterResponseParameters maxAdapterResponseParameters, Activity activity) {
        ((MaxAppOpenAdapter) this.f61739g).loadAppOpenAd(maxAdapterResponseParameters, activity, this.f61746n);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c(Activity activity) {
        ((MaxRewardedInterstitialAdapter) this.f61739g).showRewardedInterstitialAd(this.f61747o, activity, this.f61746n);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(Activity activity) {
        ((MaxRewardedAdapter) this.f61739g).showRewardedAd(this.f61747o, activity, this.f61746n);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(ViewGroup viewGroup, Lifecycle lifecycle, Activity activity) {
        ((MaxRewardedAdViewAdapter) this.f61739g).showRewardedAd(this.f61747o, viewGroup, lifecycle, activity, this.f61746n);
    }

    public String b() {
        MaxAdapter maxAdapter = this.f61739g;
        if (maxAdapter == null) {
            return null;
        }
        try {
            return maxAdapter.getAdapterVersion();
        } catch (Throwable th) {
            com.applovin.impl.sdk.n.c("MediationAdapterWrapper", "Failed to get adapter version for " + this.f61736d, th);
            this.f61734b.D().a("MediationAdapterWrapper", "adapter_version", th, CollectionUtils.hashMap("adapter_class", this.f61737e.b()));
            a("adapter_version");
            this.f61734b.L().a(this.f61737e.b(), "adapter_version", this.f61741i);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(fe feVar, Runnable runnable) {
        a(this.f61737e, feVar);
        try {
            runnable.run();
        } catch (Throwable th) {
            String str = "Failed to start loading ad for " + this.f61736d + " due to: " + th;
            com.applovin.impl.sdk.n.h("MediationAdapterWrapper", str);
            this.f61746n.a("load_ad", new MaxErrorImpl(-1, str));
            this.f61734b.D().a("MediationAdapterWrapper", "load_ad", th, CollectionUtils.hashMap("adapter_class", this.f61737e.b()));
            a("load_ad");
            this.f61734b.L().a(this.f61737e.b(), "load_ad", this.f61741i);
        }
    }

    private void b(String str, Runnable runnable) {
        a(str, (MaxAdFormat) null, runnable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(fe feVar, Activity activity) {
        this.f61734b.E().a((he) feVar, activity, this.f61746n);
    }

    public void a(String str, final MaxAdapterResponseParameters maxAdapterResponseParameters, final fe feVar, final Activity activity, MediationServiceImpl.d dVar) {
        final Runnable runnable;
        if (feVar != null) {
            if (!this.f61748p.get()) {
                String str2 = "Mediation adapter '" + this.f61738f + "' was disabled due to earlier failures. Loading ads with this adapter is disabled.";
                com.applovin.impl.sdk.n.h("MediationAdapterWrapper", str2);
                dVar.onAdLoadFailed(str, new MaxErrorImpl(-1, str2));
                return;
            }
            this.f61747o = maxAdapterResponseParameters;
            this.f61746n.a(dVar);
            final MaxAdFormat maxAdFormatI = feVar.Y() ? feVar.I() : feVar.getFormat();
            if (maxAdFormatI == MaxAdFormat.INTERSTITIAL) {
                runnable = new Runnable() { // from class: com.applovin.impl.mediation.v
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f61863a.a(maxAdapterResponseParameters, activity);
                    }
                };
            } else if (maxAdFormatI == MaxAdFormat.APP_OPEN) {
                runnable = new Runnable() { // from class: com.applovin.impl.mediation.w
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f61868a.b(maxAdapterResponseParameters, activity);
                    }
                };
            } else if (maxAdFormatI == MaxAdFormat.REWARDED) {
                runnable = new Runnable() { // from class: com.applovin.impl.mediation.x
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f61873a.c(maxAdapterResponseParameters, activity);
                    }
                };
            } else if (maxAdFormatI == MaxAdFormat.REWARDED_INTERSTITIAL) {
                runnable = new Runnable() { // from class: com.applovin.impl.mediation.y
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f61880a.d(maxAdapterResponseParameters, activity);
                    }
                };
            } else if (maxAdFormatI == MaxAdFormat.NATIVE) {
                runnable = new Runnable() { // from class: com.applovin.impl.mediation.z
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f61885a.e(maxAdapterResponseParameters, activity);
                    }
                };
            } else if (maxAdFormatI.isAdViewAd()) {
                runnable = new Runnable() { // from class: com.applovin.impl.mediation.a0
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f61473a.a(maxAdapterResponseParameters, maxAdFormatI, activity);
                    }
                };
            } else {
                throw new IllegalStateException("Failed to load " + feVar + ": " + feVar.getFormat() + " (" + feVar.I() + ") is not a supported ad format");
            }
            a("load_ad", maxAdFormatI, new Runnable() { // from class: com.applovin.impl.mediation.b0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f61603a.a(feVar, runnable);
                }
            });
            return;
        }
        throw new IllegalArgumentException("No mediated ad specified");
    }

    private void a(oe oeVar, fe feVar) {
        a(new C0113g(this, null), oeVar, feVar);
    }

    private void a(oe oeVar, f fVar) {
        a(new h(this, fVar, null), oeVar, (fe) null);
    }

    private void a(yl ylVar, oe oeVar, fe feVar) {
        long jM = oeVar.m();
        if (jM <= 0) {
            if (com.applovin.impl.sdk.n.a()) {
                com.applovin.impl.sdk.n nVar = this.f61735c;
                StringBuilder sb = new StringBuilder();
                sb.append("Non-positive timeout set for ");
                if (feVar != null) {
                    oeVar = feVar;
                }
                sb.append(oeVar);
                sb.append(", not scheduling a timeout");
                nVar.a("MediationAdapterWrapper", sb.toString());
                return;
            }
            return;
        }
        if (com.applovin.impl.sdk.n.a()) {
            com.applovin.impl.sdk.n nVar2 = this.f61735c;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Setting timeout ");
            sb2.append(jM);
            sb2.append("ms for ");
            if (feVar != null) {
                oeVar = feVar;
            }
            sb2.append(oeVar);
            nVar2.a("MediationAdapterWrapper", sb2.toString());
        }
        this.f61734b.i0().a(ylVar, tm.b.TIMEOUT, jM);
    }

    void a(String str, fe feVar) {
        this.f61740h = str;
        this.f61741i = feVar;
    }

    public void a(fe feVar, final ViewGroup viewGroup, final Lifecycle lifecycle, final Activity activity) {
        Runnable runnable;
        if (b(feVar, activity)) {
            if (feVar.getFormat() == MaxAdFormat.INTERSTITIAL) {
                runnable = new Runnable() { // from class: com.applovin.impl.mediation.k0
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f61808a.a(viewGroup, lifecycle, activity);
                    }
                };
            } else if (feVar.getFormat() == MaxAdFormat.REWARDED) {
                runnable = new Runnable() { // from class: com.applovin.impl.mediation.l0
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f61815a.b(viewGroup, lifecycle, activity);
                    }
                };
            } else {
                throw new IllegalStateException("Failed to show " + feVar + ": " + feVar.getFormat() + " is not a supported ad format");
            }
            a(runnable, feVar);
        }
    }

    void a(final MaxAdapterInitializationParameters maxAdapterInitializationParameters, final Activity activity, final MaxAdapter.OnCompletionListener onCompletionListener) {
        b("initialize", new Runnable() { // from class: com.applovin.impl.mediation.d0
            @Override // java.lang.Runnable
            public final void run() {
                this.f61658a.a(onCompletionListener, maxAdapterInitializationParameters, activity);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(MaxAdapter.OnCompletionListener onCompletionListener, MaxAdapterInitializationParameters maxAdapterInitializationParameters, Activity activity) {
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        if (com.applovin.impl.sdk.n.a()) {
            this.f61735c.a("MediationAdapterWrapper", "Initializing " + this.f61738f + " on thread: " + Thread.currentThread() + " with 'run_on_ui_thread' value: " + this.f61737e.r());
        }
        this.f61739g.initialize(maxAdapterInitializationParameters, activity, new e(this.f61734b, this.f61737e, jElapsedRealtime, onCompletionListener));
    }

    public void a(MaxNativeAdView maxNativeAdView) {
        this.f61744l = maxNativeAdView;
    }

    public void a(ViewGroup viewGroup) {
        this.f61745m = viewGroup;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(MaxAdapterResponseParameters maxAdapterResponseParameters, Activity activity) {
        ((MaxInterstitialAdapter) this.f61739g).loadInterstitialAd(maxAdapterResponseParameters, activity, this.f61746n);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(MaxAdapterResponseParameters maxAdapterResponseParameters, MaxAdFormat maxAdFormat, Activity activity) {
        ((MaxAdViewAdapter) this.f61739g).loadAdViewAd(maxAdapterResponseParameters, maxAdFormat, activity, this.f61746n);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(Activity activity) {
        ((MaxAppOpenAdapter) this.f61739g).showAppOpenAd(this.f61747o, activity, this.f61746n);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(ViewGroup viewGroup, Lifecycle lifecycle, Activity activity) {
        ((MaxInterstitialAdViewAdapter) this.f61739g).showInterstitialAd(this.f61747o, viewGroup, lifecycle, activity, this.f61746n);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(Runnable runnable) {
        try {
            runnable.run();
        } catch (Throwable th) {
            String str = "Failed to start displaying ad for " + this.f61736d + " due to: " + th;
            com.applovin.impl.sdk.n.h("MediationAdapterWrapper", str);
            this.f61746n.a("show_ad", new MaxErrorImpl(-1, str), (Bundle) null);
            this.f61734b.D().a("MediationAdapterWrapper", "show_ad", th, CollectionUtils.hashMap("adapter_class", this.f61737e.b()));
            a("show_ad");
            this.f61734b.L().a(this.f61737e.b(), "show_ad", this.f61741i);
        }
    }

    void a() {
        if (this.f61751s) {
            return;
        }
        b("destroy", new Runnable() { // from class: com.applovin.impl.mediation.m0
            @Override // java.lang.Runnable
            public final void run() {
                this.f61823a.l();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, f fVar) {
        if (!fVar.f61764c.compareAndSet(false, true) || fVar.f61763b == null) {
            return;
        }
        fVar.f61763b.onSignalCollected(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(MaxError maxError, f fVar) {
        if (!fVar.f61764c.compareAndSet(false, true) || fVar.f61763b == null) {
            return;
        }
        fVar.f61763b.a(maxError);
    }

    private void a(String str) {
        if (com.applovin.impl.sdk.n.a()) {
            this.f61735c.d("MediationAdapterWrapper", "Marking " + this.f61738f + " as disabled due to: " + str);
        }
        this.f61748p.set(false);
    }

    private void a(final String str, MaxAdFormat maxAdFormat, final Runnable runnable) {
        Runnable runnable2 = new Runnable() { // from class: com.applovin.impl.mediation.j0
            @Override // java.lang.Runnable
            public final void run() {
                this.f61798a.a(str, runnable);
            }
        };
        if (a(str, maxAdFormat)) {
            this.f61733a.post(runnable2);
            return;
        }
        jn jnVar = new jn(this.f61734b, str + Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR + this.f61737e.c(), runnable2);
        if (((Boolean) this.f61734b.a(sj.f63723b0)).booleanValue()) {
            this.f61734b.i0().a(jnVar, this.f61737e);
        } else {
            this.f61734b.i0().a(jnVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(String str, Runnable runnable) {
        try {
            if (com.applovin.impl.sdk.n.a()) {
                this.f61735c.a("MediationAdapterWrapper", this.f61738f + ": running " + str + "...");
            }
            runnable.run();
            if (com.applovin.impl.sdk.n.a()) {
                this.f61735c.a("MediationAdapterWrapper", this.f61738f + ": finished " + str + "");
            }
        } catch (Throwable th) {
            com.applovin.impl.sdk.n.c("MediationAdapterWrapper", "Failed operation " + str + " for " + this.f61736d, th);
            StringBuilder sb = new StringBuilder();
            sb.append("fail_");
            sb.append(str);
            a(sb.toString());
            if (!str.equals("destroy")) {
                this.f61734b.L().a(this.f61737e.b(), str, this.f61741i);
            }
            HashMap<String, String> mapHashMap = CollectionUtils.hashMap("is_wrapper", ServerProtocol.DIALOG_RETURN_SCOPES_TRUE);
            CollectionUtils.putStringIfValid("adapter_class", this.f61737e.b(), mapHashMap);
            this.f61734b.D().a("MediationAdapterWrapper", str, th, mapHashMap);
        }
    }

    private boolean a(String str, MaxAdFormat maxAdFormat) {
        Boolean boolShouldShowAdsOnUiThread;
        MaxAdapter maxAdapter = this.f61739g;
        if (maxAdapter == null) {
            return this.f61737e.r();
        }
        if ("initialize".equals(str)) {
            Boolean boolShouldInitializeOnUiThread = maxAdapter.shouldInitializeOnUiThread();
            if (boolShouldInitializeOnUiThread != null) {
                return boolShouldInitializeOnUiThread.booleanValue();
            }
        } else if ("collect_signal".equals(str)) {
            Boolean boolShouldCollectSignalsOnUiThread = maxAdapter.shouldCollectSignalsOnUiThread();
            if (boolShouldCollectSignalsOnUiThread != null) {
                return boolShouldCollectSignalsOnUiThread.booleanValue();
            }
        } else if ("load_ad".equals(str) && maxAdFormat != null) {
            Boolean boolShouldLoadAdsOnUiThread = maxAdapter.shouldLoadAdsOnUiThread(maxAdFormat);
            if (boolShouldLoadAdsOnUiThread != null) {
                return boolShouldLoadAdsOnUiThread.booleanValue();
            }
        } else if ("show_ad".equals(str) && maxAdFormat != null && (boolShouldShowAdsOnUiThread = maxAdapter.shouldShowAdsOnUiThread(maxAdFormat)) != null) {
            return boolShouldShowAdsOnUiThread.booleanValue();
        }
        return this.f61737e.r();
    }
}
