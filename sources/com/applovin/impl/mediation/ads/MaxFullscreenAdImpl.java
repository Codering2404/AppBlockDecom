package com.applovin.impl.mediation.ads;

import android.app.Activity;
import android.content.Context;
import android.view.ViewGroup;
import androidx.lifecycle.Lifecycle;
import com.applovin.impl.fc;
import com.applovin.impl.fe;
import com.applovin.impl.he;
import com.applovin.impl.i8;
import com.applovin.impl.jn;
import com.applovin.impl.ka;
import com.applovin.impl.kf;
import com.applovin.impl.mediation.MaxErrorImpl;
import com.applovin.impl.mediation.MediationServiceImpl;
import com.applovin.impl.mediation.ads.a;
import com.applovin.impl.mediation.d;
import com.applovin.impl.sdk.a;
import com.applovin.impl.sdk.utils.CollectionUtils;
import com.applovin.impl.tm;
import com.applovin.impl.ue;
import com.applovin.impl.v;
import com.applovin.impl.yp;
import com.applovin.mediation.MaxAd;
import com.applovin.mediation.MaxAdFormat;
import com.applovin.mediation.MaxAdListener;
import com.applovin.mediation.MaxAdRevenueListener;
import com.applovin.mediation.MaxError;
import com.applovin.mediation.MaxReward;
import com.applovin.mediation.MaxRewardedAdListener;
import com.applovin.mediation.adapter.MaxAdapterError;
import com.applovin.sdk.AppLovinSdkUtils;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class MaxFullscreenAdImpl extends com.applovin.impl.mediation.ads.a implements a.InterfaceC0121a, v.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final b f61509a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final WeakReference f61510b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final c f61511c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final com.applovin.impl.mediation.b f61512d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Object f61513e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private he f61514f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private d f61515g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final AtomicBoolean f61516h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final AtomicBoolean f61517i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private boolean f61518j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private boolean f61519k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private String f61520l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private String f61521m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private WeakReference f61522n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private WeakReference f61523o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private WeakReference f61524p;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface b {
        Activity getActivity();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class c implements MaxAdListener, MaxRewardedAdListener, MaxAdRevenueListener, a.InterfaceC0110a {
        private c() {
        }

        @Override // com.applovin.mediation.MaxAdListener
        public void onAdClicked(MaxAd maxAd) {
            com.applovin.impl.sdk.n nVar = MaxFullscreenAdImpl.this.logger;
            if (com.applovin.impl.sdk.n.a()) {
                MaxFullscreenAdImpl maxFullscreenAdImpl = MaxFullscreenAdImpl.this;
                maxFullscreenAdImpl.logger.a(maxFullscreenAdImpl.tag, "MaxAdListener.onAdClicked(ad=" + maxAd + "), listener=" + MaxFullscreenAdImpl.this.adListener);
            }
            fc.a(MaxFullscreenAdImpl.this.adListener, maxAd, true);
        }

        @Override // com.applovin.mediation.MaxAdListener
        public void onAdDisplayFailed(final MaxAd maxAd, final MaxError maxError) {
            final boolean z2 = MaxFullscreenAdImpl.this.f61519k;
            MaxFullscreenAdImpl.this.f61519k = false;
            final he heVar = (he) maxAd;
            MaxFullscreenAdImpl.this.a(d.IDLE, new e() { // from class: com.applovin.impl.mediation.ads.o
                @Override // com.applovin.impl.mediation.ads.MaxFullscreenAdImpl.e
                public final void a() {
                    this.f61588a.a(maxAd, z2, heVar, maxError);
                }
            });
        }

        @Override // com.applovin.mediation.MaxAdListener
        public void onAdDisplayed(MaxAd maxAd) {
            final he heVar = (he) maxAd;
            MaxFullscreenAdImpl.this.f61519k = false;
            MaxFullscreenAdImpl.this.sdk.f().a(heVar);
            if (((Integer) MaxFullscreenAdImpl.this.sdk.a(ue.G7)).intValue() > 0) {
                MaxFullscreenAdImpl.this.sdk.i0().b(new jn(MaxFullscreenAdImpl.this.sdk, "ReportAdHiddenCallbackNotCalled", new Runnable() { // from class: com.applovin.impl.mediation.ads.p
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f61593a.a(heVar);
                    }
                }), tm.b.TIMEOUT, TimeUnit.SECONDS.toMillis(r1.intValue()));
            }
            com.applovin.impl.sdk.n nVar = MaxFullscreenAdImpl.this.logger;
            if (com.applovin.impl.sdk.n.a()) {
                MaxFullscreenAdImpl maxFullscreenAdImpl = MaxFullscreenAdImpl.this;
                maxFullscreenAdImpl.logger.a(maxFullscreenAdImpl.tag, "MaxAdListener.onAdDisplayed(ad=" + maxAd + "), listener=" + MaxFullscreenAdImpl.this.adListener);
            }
            fc.c(MaxFullscreenAdImpl.this.adListener, maxAd, true);
        }

        @Override // com.applovin.mediation.MaxAdListener
        public void onAdHidden(final MaxAd maxAd) {
            MaxFullscreenAdImpl.this.f61519k = false;
            MaxFullscreenAdImpl.this.a(d.IDLE, new e() { // from class: com.applovin.impl.mediation.ads.r
                @Override // com.applovin.impl.mediation.ads.MaxFullscreenAdImpl.e
                public final void a() {
                    this.f61596a.a(maxAd);
                }
            });
        }

        @Override // com.applovin.mediation.MaxAdListener
        public void onAdLoadFailed(final String str, final MaxError maxError) {
            MaxFullscreenAdImpl.this.c();
            MaxFullscreenAdImpl.this.a(d.IDLE, new e() { // from class: com.applovin.impl.mediation.ads.m
                @Override // com.applovin.impl.mediation.ads.MaxFullscreenAdImpl.e
                public final void a() {
                    this.f61583a.a(str, maxError);
                }
            });
        }

        @Override // com.applovin.mediation.MaxAdListener
        public void onAdLoaded(final MaxAd maxAd) {
            he heVar;
            synchronized (MaxFullscreenAdImpl.this.f61513e) {
                heVar = MaxFullscreenAdImpl.this.f61514f;
            }
            MaxFullscreenAdImpl.this.sdk.B().a(MaxFullscreenAdImpl.this.adUnitId);
            MaxFullscreenAdImpl.this.a((he) maxAd);
            if (!MaxFullscreenAdImpl.this.f61516h.compareAndSet(true, false)) {
                MaxFullscreenAdImpl.this.a(d.READY, new e() { // from class: com.applovin.impl.mediation.ads.n
                    @Override // com.applovin.impl.mediation.ads.MaxFullscreenAdImpl.e
                    public final void a() {
                        this.f61586a.b(maxAd);
                    }
                });
                return;
            }
            MaxFullscreenAdImpl.this.extraParameters.remove("expired_ad_ad_unit_id");
            if (MaxFullscreenAdImpl.this.f61517i.compareAndSet(true, false)) {
                MaxFullscreenAdImpl.this.d();
            }
            com.applovin.impl.sdk.n nVar = MaxFullscreenAdImpl.this.logger;
            if (com.applovin.impl.sdk.n.a()) {
                MaxFullscreenAdImpl maxFullscreenAdImpl = MaxFullscreenAdImpl.this;
                maxFullscreenAdImpl.logger.a(maxFullscreenAdImpl.tag, "MaxAdListener.onExpiredAdReloaded(expiredAd=" + heVar + ", newAd=" + maxAd + "), listener=" + MaxFullscreenAdImpl.this.expirationListener);
            }
            fc.a(MaxFullscreenAdImpl.this.expirationListener, (MaxAd) heVar, maxAd, true);
        }

        @Override // com.applovin.mediation.MaxAdRequestListener
        public void onAdRequestStarted(String str) {
            com.applovin.impl.sdk.n nVar = MaxFullscreenAdImpl.this.logger;
            if (com.applovin.impl.sdk.n.a()) {
                MaxFullscreenAdImpl maxFullscreenAdImpl = MaxFullscreenAdImpl.this;
                maxFullscreenAdImpl.logger.a(maxFullscreenAdImpl.tag, "MaxAdRequestListener.onAdRequestStarted(adUnitId=" + str + "), listener=" + MaxFullscreenAdImpl.this.requestListener);
            }
            fc.a(MaxFullscreenAdImpl.this.requestListener, str, true);
        }

        @Override // com.applovin.mediation.MaxAdRevenueListener
        public void onAdRevenuePaid(MaxAd maxAd) {
            com.applovin.impl.sdk.n nVar = MaxFullscreenAdImpl.this.logger;
            if (com.applovin.impl.sdk.n.a()) {
                MaxFullscreenAdImpl maxFullscreenAdImpl = MaxFullscreenAdImpl.this;
                maxFullscreenAdImpl.logger.a(maxFullscreenAdImpl.tag, "MaxAdRevenueListener.onAdRevenuePaid(ad=" + maxAd + "), listener=" + MaxFullscreenAdImpl.this.revenueListener);
            }
            fc.a(MaxFullscreenAdImpl.this.revenueListener, maxAd, true);
        }

        @Override // com.applovin.mediation.MaxRewardedAdListener
        public void onUserRewarded(MaxAd maxAd, MaxReward maxReward) {
            com.applovin.impl.sdk.n nVar = MaxFullscreenAdImpl.this.logger;
            if (com.applovin.impl.sdk.n.a()) {
                MaxFullscreenAdImpl maxFullscreenAdImpl = MaxFullscreenAdImpl.this;
                maxFullscreenAdImpl.logger.a(maxFullscreenAdImpl.tag, "MaxRewardedAdListener.onUserRewarded(ad=" + maxAd + ", reward=" + maxReward + "), listener=" + MaxFullscreenAdImpl.this.adListener);
            }
            fc.a(MaxFullscreenAdImpl.this.adListener, maxAd, maxReward, true);
        }

        /* synthetic */ c(MaxFullscreenAdImpl maxFullscreenAdImpl, a aVar) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void a(MaxAd maxAd, boolean z2, he heVar, MaxError maxError) {
            MaxFullscreenAdImpl.this.a(maxAd);
            if (!z2 && heVar.u0() && MaxFullscreenAdImpl.this.sdk.J().d(MaxFullscreenAdImpl.this.adUnitId)) {
                AppLovinSdkUtils.runOnUiThread(true, new Runnable() { // from class: com.applovin.impl.mediation.ads.q
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f61595a.a();
                    }
                });
                return;
            }
            com.applovin.impl.sdk.n nVar = MaxFullscreenAdImpl.this.logger;
            if (com.applovin.impl.sdk.n.a()) {
                MaxFullscreenAdImpl maxFullscreenAdImpl = MaxFullscreenAdImpl.this;
                maxFullscreenAdImpl.logger.a(maxFullscreenAdImpl.tag, "MaxAdListener.onAdDisplayFailed(ad=" + maxAd + ", error=" + maxError + "), listener=" + MaxFullscreenAdImpl.this.adListener);
            }
            fc.a(MaxFullscreenAdImpl.this.adListener, maxAd, maxError, true);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void b(MaxAd maxAd) {
            if (MaxFullscreenAdImpl.this.f61519k) {
                MaxFullscreenAdImpl.this.d();
                return;
            }
            com.applovin.impl.sdk.n nVar = MaxFullscreenAdImpl.this.logger;
            if (com.applovin.impl.sdk.n.a()) {
                MaxFullscreenAdImpl maxFullscreenAdImpl = MaxFullscreenAdImpl.this;
                maxFullscreenAdImpl.logger.a(maxFullscreenAdImpl.tag, "MaxAdListener.onAdLoaded(ad=" + maxAd + "), listener=" + MaxFullscreenAdImpl.this.adListener);
            }
            fc.f(MaxFullscreenAdImpl.this.adListener, maxAd, true);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void a(he heVar) {
            if (heVar.w().get()) {
                return;
            }
            MaxFullscreenAdImpl.this.sdk.D().a(ka.L, heVar);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void a(String str, MaxError maxError) {
            com.applovin.impl.sdk.n nVar = MaxFullscreenAdImpl.this.logger;
            if (com.applovin.impl.sdk.n.a()) {
                MaxFullscreenAdImpl maxFullscreenAdImpl = MaxFullscreenAdImpl.this;
                maxFullscreenAdImpl.logger.a(maxFullscreenAdImpl.tag, "MaxAdListener.onAdLoadFailed(adUnitId=" + str + ", error=" + maxError + "), listener=" + MaxFullscreenAdImpl.this.adListener);
            }
            fc.a(MaxFullscreenAdImpl.this.adListener, str, maxError, true);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void a(MaxAd maxAd) {
            MaxFullscreenAdImpl.this.a(maxAd);
            com.applovin.impl.sdk.n nVar = MaxFullscreenAdImpl.this.logger;
            if (com.applovin.impl.sdk.n.a()) {
                MaxFullscreenAdImpl maxFullscreenAdImpl = MaxFullscreenAdImpl.this;
                maxFullscreenAdImpl.logger.a(maxFullscreenAdImpl.tag, "MaxAdListener.onAdHidden(ad=" + maxAd + "), listener=" + MaxFullscreenAdImpl.this.adListener);
            }
            fc.e(MaxFullscreenAdImpl.this.adListener, maxAd, true);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void a() {
            MaxFullscreenAdImpl.this.f61519k = true;
            MaxFullscreenAdImpl.this.loadAd();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public enum d {
        IDLE,
        LOADING,
        READY,
        SHOWING,
        DESTROYED
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    interface e {
        void a();

        default void a(MaxError maxError) {
        }
    }

    public MaxFullscreenAdImpl(String str, MaxAdFormat maxAdFormat, b bVar, String str2, com.applovin.impl.sdk.j jVar, Context context) {
        super(str, maxAdFormat, str2, jVar);
        this.f61513e = new Object();
        this.f61514f = null;
        this.f61515g = d.IDLE;
        this.f61516h = new AtomicBoolean();
        this.f61517i = new AtomicBoolean();
        this.f61522n = new WeakReference(null);
        this.f61523o = new WeakReference(null);
        this.f61524p = new WeakReference(null);
        this.f61509a = bVar;
        this.f61511c = new c(this, null);
        this.f61512d = new com.applovin.impl.mediation.b(jVar);
        this.f61510b = new WeakReference(context);
        jVar.i().a(this);
        com.applovin.impl.sdk.n.g(str2, "Created new " + str2 + " (" + this + ")");
    }

    @Override // com.applovin.impl.mediation.ads.a
    public void destroy() {
        a(d.DESTROYED, new e() { // from class: com.applovin.impl.mediation.ads.j
            @Override // com.applovin.impl.mediation.ads.MaxFullscreenAdImpl.e
            public final void a() {
                this.f61576a.b();
            }
        });
    }

    public boolean isReady() {
        boolean z2;
        synchronized (this.f61513e) {
            try {
                he heVar = this.f61514f;
                z2 = heVar != null && heVar.a0() && this.f61515g == d.READY;
            } catch (Throwable th) {
                throw th;
            }
        }
        if (!z2) {
            this.sdk.B().c(this.adUnitId);
        }
        return z2;
    }

    public void loadAd() {
        loadAd(d.b.PUBLISHER_INITIATED);
    }

    @Override // com.applovin.impl.sdk.a.InterfaceC0121a
    public void onAdExpired(i8 i8Var) {
        if (com.applovin.impl.sdk.n.a()) {
            this.logger.a(this.tag, "Ad expired " + getAdUnitId());
        }
        this.f61516h.set(true);
        b bVar = this.f61509a;
        Activity activity = bVar != null ? bVar.getActivity() : null;
        if (activity == null && (activity = this.sdk.e().b()) == null) {
            c();
            this.f61511c.onAdLoadFailed(this.adUnitId, MaxAdapterError.MISSING_ACTIVITY);
        } else {
            this.extraParameters.put("expired_ad_ad_unit_id", getAdUnitId());
            this.sdk.P().loadAd(this.adUnitId, null, this.adFormat, d.b.EXPIRED, this.localExtraParameters, this.extraParameters, activity, this.f61511c);
        }
    }

    @Override // com.applovin.impl.v.b
    public void onCreativeIdGenerated(String str, String str2) {
        he heVar = this.f61514f;
        if (heVar == null || !heVar.R().equalsIgnoreCase(str)) {
            return;
        }
        this.f61514f.h(str2);
        fc.b(this.adReviewListener, str2, this.f61514f);
    }

    public void showAd(final String str, final String str2, final Activity activity) {
        he heVar;
        List listB = this.sdk.k0().b();
        if (!this.sdk.k0().d() || listB == null || (heVar = this.f61514f) == null || listB.contains(heVar.c())) {
            if (activity == null) {
                activity = this.sdk.m0();
            }
            if (a(activity, str)) {
                a(d.SHOWING, new e() { // from class: com.applovin.impl.mediation.ads.l
                    @Override // com.applovin.impl.mediation.ads.MaxFullscreenAdImpl.e
                    public final void a() {
                        this.f61579a.a(str, str2, activity);
                    }
                });
                return;
            }
            return;
        }
        final String str3 = "Attempting to show ad from <" + this.f61514f.c() + "> which is not in the list of selected ad networks " + listB;
        com.applovin.impl.sdk.n.h(this.tag, str3);
        a(d.IDLE, new e() { // from class: com.applovin.impl.mediation.ads.k
            @Override // com.applovin.impl.mediation.ads.MaxFullscreenAdImpl.e
            public final void a() {
                this.f61577a.b(str3);
            }
        });
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.tag);
        sb.append("{adUnitId='");
        sb.append(this.adUnitId);
        sb.append('\'');
        sb.append(", adListener=");
        Object obj = this.adListener;
        if (obj == this.f61509a) {
            obj = "this";
        }
        sb.append(obj);
        sb.append(", revenueListener=");
        sb.append(this.revenueListener);
        sb.append(", requestListener");
        sb.append(this.requestListener);
        sb.append(", adReviewListener");
        sb.append(this.adReviewListener);
        sb.append(", isReady=");
        sb.append(isReady());
        sb.append('}');
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(he heVar) {
        if (!this.sdk.f().a(heVar, this)) {
            if (com.applovin.impl.sdk.n.a()) {
                this.logger.a(this.tag, "Loaded an expired ad, running expire logic...");
            }
            onAdExpired(heVar);
            return;
        }
        if (com.applovin.impl.sdk.n.a()) {
            this.logger.a(this.tag, "Handle ad loaded for regular ad: " + heVar);
        }
        this.f61514f = heVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        Activity activityM0 = (Activity) this.f61522n.get();
        if (activityM0 == null) {
            activityM0 = this.sdk.m0();
        }
        Activity activity = activityM0;
        if (this.f61518j) {
            showAd(this.f61520l, this.f61521m, (ViewGroup) this.f61523o.get(), (Lifecycle) this.f61524p.get(), activity);
        } else {
            showAd(this.f61520l, this.f61521m, activity);
        }
    }

    public void loadAd(d.b bVar) {
        if (com.applovin.impl.sdk.n.a()) {
            this.logger.a(this.tag, "Loading ad for '" + this.adUnitId + "'...");
        }
        if (this.f61515g == d.DESTROYED) {
            boolean zC = yp.c(this.sdk);
            this.sdk.D().a(ka.V, "attemptingToLoadDestroyedAd", (Map) CollectionUtils.hashMap("details", "debug=" + zC));
            if (zC) {
                throw new IllegalStateException("Failed to load new ad - this instance is already destroyed for ad unit ID: " + this.adUnitId);
            }
        }
        if (!isReady()) {
            b bVar2 = this.f61509a;
            a(d.LOADING, new a(bVar2 != null ? bVar2.getActivity() : null, (Context) this.f61510b.get(), bVar));
            return;
        }
        if (com.applovin.impl.sdk.n.a()) {
            this.logger.a(this.tag, "An ad is already loaded for '" + this.adUnitId + "'");
        }
        if (com.applovin.impl.sdk.n.a()) {
            this.logger.a(this.tag, "MaxAdListener.onAdLoaded(ad=" + this.f61514f + "), listener=" + this.adListener);
        }
        fc.f(this.adListener, (MaxAd) this.f61514f, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b() {
        synchronized (this.f61513e) {
            try {
                if (this.f61514f != null) {
                    if (com.applovin.impl.sdk.n.a()) {
                        this.logger.a(this.tag, "Destroying ad for '" + this.adUnitId + "'; current ad: " + this.f61514f + "...");
                    }
                    this.sdk.P().destroyAd(this.f61514f);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        this.sdk.i().b(this);
        this.f61512d.a();
        super.destroy();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c(String str) {
        he heVar = this.f61514f;
        a((MaxAd) heVar);
        MaxErrorImpl maxErrorImpl = new MaxErrorImpl(MaxAdapterError.ERROR_CODE_AD_DISPLAY_FAILED, str);
        if (com.applovin.impl.sdk.n.a()) {
            this.logger.a(this.tag, "MaxAdListener.onAdDisplayFailed(ad=" + heVar + ", error=" + maxErrorImpl + "), listener=" + this.adListener);
        }
        fc.a(this.adListener, (MaxAd) heVar, (MaxError) maxErrorImpl, true);
        this.sdk.P().processAdDisplayErrorPostbackForUserError(maxErrorImpl, heVar);
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class a implements e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Activity f61525a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Context f61526b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ d.b f61527c;

        a(Activity activity, Context context, d.b bVar) {
            this.f61525a = activity;
            this.f61526b = context;
            this.f61527c = bVar;
        }

        @Override // com.applovin.impl.mediation.ads.MaxFullscreenAdImpl.e
        public void a() {
            Context contextM0 = this.f61525a;
            if (contextM0 == null && (contextM0 = this.f61526b) == null) {
                contextM0 = MaxFullscreenAdImpl.this.sdk.m0() != null ? MaxFullscreenAdImpl.this.sdk.m0() : com.applovin.impl.sdk.j.m();
            }
            Context context = contextM0;
            MediationServiceImpl mediationServiceImplP = MaxFullscreenAdImpl.this.sdk.P();
            MaxFullscreenAdImpl maxFullscreenAdImpl = MaxFullscreenAdImpl.this;
            mediationServiceImplP.loadAd(maxFullscreenAdImpl.adUnitId, null, maxFullscreenAdImpl.adFormat, this.f61527c, maxFullscreenAdImpl.localExtraParameters, maxFullscreenAdImpl.extraParameters, context, maxFullscreenAdImpl.f61511c);
        }

        @Override // com.applovin.impl.mediation.ads.MaxFullscreenAdImpl.e
        public void a(MaxError maxError) {
            if (((Boolean) MaxFullscreenAdImpl.this.sdk.a(ue.F7)).booleanValue()) {
                com.applovin.impl.sdk.n nVar = MaxFullscreenAdImpl.this.logger;
                if (com.applovin.impl.sdk.n.a()) {
                    MaxFullscreenAdImpl maxFullscreenAdImpl = MaxFullscreenAdImpl.this;
                    maxFullscreenAdImpl.logger.a(maxFullscreenAdImpl.tag, "MaxAdListener.onAdLoadFailed(adUnitId=" + MaxFullscreenAdImpl.this.adUnitId + ", error=" + maxError + "), listener=" + MaxFullscreenAdImpl.this.adListener);
                }
                MaxFullscreenAdImpl maxFullscreenAdImpl2 = MaxFullscreenAdImpl.this;
                fc.a(maxFullscreenAdImpl2.adListener, maxFullscreenAdImpl2.adUnitId, maxError, true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        he heVar;
        if (this.f61516h.compareAndSet(true, false)) {
            synchronized (this.f61513e) {
                heVar = this.f61514f;
                this.f61514f = null;
            }
            this.sdk.P().destroyAd(heVar);
            this.extraParameters.remove("expired_ad_ad_unit_id");
        }
    }

    public void showAd(final String str, final String str2, final ViewGroup viewGroup, final Lifecycle lifecycle, Activity activity) {
        he heVar;
        if (viewGroup != null && lifecycle != null) {
            if (!viewGroup.isShown() && ((Boolean) this.sdk.a(ue.x7)).booleanValue()) {
                com.applovin.impl.sdk.n.h(this.tag, "Attempting to show ad when containerView and/or its ancestors are not visible");
                MaxErrorImpl maxErrorImpl = new MaxErrorImpl(-1, "Attempting to show ad when containerView and/or its ancestors are not visible");
                fc.a(this.adListener, (MaxAd) this.f61514f, (MaxError) maxErrorImpl, true);
                this.sdk.P().processAdDisplayErrorPostbackForUserError(maxErrorImpl, this.f61514f);
                return;
            }
            List listB = this.sdk.k0().b();
            if (this.sdk.k0().d() && listB != null && (heVar = this.f61514f) != null && !listB.contains(heVar.c())) {
                final String str3 = "Attempting to show ad from <" + this.f61514f.c() + "> which is not in the list of selected ad networks " + listB;
                com.applovin.impl.sdk.n.h(this.tag, str3);
                a(d.IDLE, new e() { // from class: com.applovin.impl.mediation.ads.g
                    @Override // com.applovin.impl.mediation.ads.MaxFullscreenAdImpl.e
                    public final void a() {
                        this.f61566a.c(str3);
                    }
                });
                return;
            }
            if (activity == null) {
                activity = this.sdk.m0();
            }
            final Activity activity2 = activity;
            if (a(activity2, str)) {
                a(d.SHOWING, new e() { // from class: com.applovin.impl.mediation.ads.h
                    @Override // com.applovin.impl.mediation.ads.MaxFullscreenAdImpl.e
                    public final void a() {
                        this.f61568a.a(str, str2, activity2, viewGroup, lifecycle);
                    }
                });
                return;
            }
            return;
        }
        com.applovin.impl.sdk.n.h(this.tag, "Attempting to show ad with null containerView or lifecycle.");
        MaxErrorImpl maxErrorImpl2 = new MaxErrorImpl(-1, "Attempting to show ad with null containerView or lifecycle.");
        if (com.applovin.impl.sdk.n.a()) {
            this.logger.a(this.tag, "MaxAdListener.onAdDisplayFailed(ad=" + this.f61514f + ", error=" + maxErrorImpl2 + "), listener=" + this.adListener);
        }
        fc.a(this.adListener, (MaxAd) this.f61514f, (MaxError) maxErrorImpl2, true);
        this.sdk.P().processAdDisplayErrorPostbackForUserError(maxErrorImpl2, this.f61514f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(String str, String str2, Activity activity) {
        a(str, str2);
        this.f61518j = false;
        this.f61522n = new WeakReference(activity);
        this.sdk.P().showFullscreenAd(this.f61514f, activity, this.f61511c);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(String str) {
        he heVar = this.f61514f;
        a((MaxAd) heVar);
        MaxErrorImpl maxErrorImpl = new MaxErrorImpl(MaxAdapterError.ERROR_CODE_AD_DISPLAY_FAILED, str);
        if (com.applovin.impl.sdk.n.a()) {
            this.logger.a(this.tag, "MaxAdListener.onAdDisplayFailed(ad=" + heVar + ", error=" + maxErrorImpl + "), listener=" + this.adListener);
        }
        fc.a(this.adListener, (MaxAd) heVar, (MaxError) maxErrorImpl, true);
        this.sdk.P().processAdDisplayErrorPostbackForUserError(maxErrorImpl, heVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(String str, String str2, Activity activity, ViewGroup viewGroup, Lifecycle lifecycle) {
        a(str, str2);
        this.f61518j = true;
        this.f61522n = new WeakReference(activity);
        this.f61523o = new WeakReference(viewGroup);
        this.f61524p = new WeakReference(lifecycle);
        this.sdk.P().showFullscreenAd(this.f61514f, viewGroup, lifecycle, activity, this.f61511c);
    }

    private boolean a(Activity activity, final String str) {
        if (activity == null && MaxAdFormat.APP_OPEN != this.adFormat) {
            throw new IllegalArgumentException("Attempting to show ad without a valid activity.");
        }
        if (this.f61515g == d.DESTROYED) {
            boolean zC = yp.c(this.sdk);
            this.sdk.D().a(ka.V, "attemptingToShowDestroyedAd", (Map) CollectionUtils.hashMap("details", "debug=" + zC));
            if (zC) {
                throw new IllegalStateException("Attempting to show ad that is destroyed for ad unit ID: " + this.adUnitId);
            }
        }
        if (!isReady()) {
            String str2 = "Attempting to show ad before it is ready - please check ad readiness using " + this.tag + "#isReady()";
            com.applovin.impl.sdk.n.h(this.tag, str2);
            MaxErrorImpl maxErrorImpl = new MaxErrorImpl(-24, str2);
            kf kfVar = new kf(this.adUnitId, this.adFormat, str);
            if (com.applovin.impl.sdk.n.a()) {
                this.logger.a(this.tag, "MaxAdListener.onAdDisplayFailed(ad=" + kfVar + ", error=" + maxErrorImpl + "), listener=" + this.adListener);
            }
            fc.a(this.adListener, (MaxAd) kfVar, (MaxError) maxErrorImpl, true);
            if (this.f61514f != null) {
                this.sdk.P().processAdDisplayErrorPostbackForUserError(maxErrorImpl, this.f61514f);
            }
            return false;
        }
        Long l3 = (Long) this.sdk.a(ue.k7);
        Long l4 = (Long) this.sdk.a(ue.d7);
        if (l3.longValue() > 0 && (this.f61514f.getTimeToLiveMillis() < l4.longValue() || this.f61516h.get())) {
            this.f61517i.set(true);
            this.sdk.i0().a(new jn(this.sdk, "handleShowOnLoadTimeoutError", new Runnable() { // from class: com.applovin.impl.mediation.ads.i
                @Override // java.lang.Runnable
                public final void run() {
                    this.f61574a.a(str);
                }
            }), tm.b.TIMEOUT, l3.longValue());
            return false;
        }
        if (yp.a(com.applovin.impl.sdk.j.m()) != 0 && this.sdk.f0().shouldFailAdDisplayIfDontKeepActivitiesIsEnabled()) {
            if (!yp.c(this.sdk)) {
                if (((Boolean) this.sdk.a(ue.w7)).booleanValue()) {
                    com.applovin.impl.sdk.n.h(this.tag, "Ad failed to display! Please disable the \"Don't Keep Activities\" setting in your developer settings!");
                    MaxErrorImpl maxErrorImpl2 = new MaxErrorImpl(-5602, "Ad failed to display! Please disable the \"Don't Keep Activities\" setting in your developer settings!");
                    if (com.applovin.impl.sdk.n.a()) {
                        this.logger.a(this.tag, "MaxAdListener.onAdDisplayFailed(ad=" + this.f61514f + ", error=" + maxErrorImpl2 + "), listener=" + this.adListener);
                    }
                    fc.a(this.adListener, (MaxAd) this.f61514f, (MaxError) maxErrorImpl2, true);
                    this.sdk.P().processAdDisplayErrorPostbackForUserError(maxErrorImpl2, this.f61514f);
                    return false;
                }
            } else {
                throw new IllegalStateException("Ad failed to display! Please disable the \"Don't Keep Activities\" setting in your developer settings!");
            }
        }
        if (!this.sdk.B().d() && !this.sdk.B().c()) {
            return true;
        }
        com.applovin.impl.sdk.n.h(this.tag, "Attempting to show ad when another fullscreen ad is already showing");
        MaxErrorImpl maxErrorImpl3 = new MaxErrorImpl(-23, "Attempting to show ad when another fullscreen ad is already showing");
        if (com.applovin.impl.sdk.n.a()) {
            this.logger.a(this.tag, "MaxAdListener.onAdDisplayFailed(ad=" + this.f61514f + ", error=" + maxErrorImpl3 + "), listener=" + this.adListener);
        }
        fc.a(this.adListener, (MaxAd) this.f61514f, (MaxError) maxErrorImpl3, true);
        this.sdk.P().processAdDisplayErrorPostbackForUserError(maxErrorImpl3, this.f61514f);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(String str) {
        if (this.f61517i.compareAndSet(true, false)) {
            com.applovin.impl.sdk.n.h(this.tag, "Failed to show an ad. Failed to load an ad in time to show.");
            this.sdk.B().c(this.adUnitId);
            MaxErrorImpl maxErrorImpl = new MaxErrorImpl(-24, "Failed to show an ad. Failed to load an ad in time to show.");
            kf kfVar = new kf(this.adUnitId, this.adFormat, str);
            if (com.applovin.impl.sdk.n.a()) {
                this.logger.a(this.tag, "MaxAdListener.onAdDisplayFailed(ad=" + kfVar + ", error=" + maxErrorImpl + "), listener=" + this.adListener);
            }
            fc.a(this.adListener, (MaxAd) kfVar, (MaxError) maxErrorImpl, true);
            if (this.f61514f != null) {
                this.sdk.P().processAdDisplayErrorPostbackForUserError(maxErrorImpl, this.f61514f);
            }
        }
    }

    private void a(String str, String str2) {
        this.f61512d.e(this.f61514f);
        this.f61514f.g(str);
        this.f61514f.f(str2);
        this.f61520l = str;
        this.f61521m = str2;
        this.sdk.v().d(this.f61514f);
        if (com.applovin.impl.sdk.n.a()) {
            this.logger.a(this.tag, "Showing ad for '" + this.adUnitId + "'; loaded ad: " + this.f61514f + "...");
        }
        a((fe) this.f61514f);
    }

    private void a() {
        he heVar;
        synchronized (this.f61513e) {
            heVar = this.f61514f;
            this.f61514f = null;
        }
        this.sdk.P().destroyAd(heVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(d dVar, e eVar) {
        boolean z2;
        MaxErrorImpl maxErrorImpl = new MaxErrorImpl(-1);
        d dVar2 = this.f61515g;
        synchronized (this.f61513e) {
            try {
                d dVar3 = d.IDLE;
                if (dVar2 == dVar3) {
                    if (dVar == d.LOADING || dVar == d.DESTROYED) {
                        z2 = true;
                    } else {
                        if (dVar == d.SHOWING) {
                            com.applovin.impl.sdk.n.h(this.tag, "No ad is loading or loaded");
                        } else if (com.applovin.impl.sdk.n.a()) {
                            this.logger.b(this.tag, "Unable to transition to: " + dVar);
                        }
                        z2 = false;
                    }
                } else {
                    d dVar4 = d.LOADING;
                    if (dVar2 == dVar4) {
                        if (dVar != dVar3) {
                            if (dVar == dVar4) {
                                maxErrorImpl = new MaxErrorImpl(-26, "An ad is already loading");
                                com.applovin.impl.sdk.n.h(this.tag, maxErrorImpl.getMessage());
                            } else if (dVar != d.READY) {
                                if (dVar == d.SHOWING) {
                                    com.applovin.impl.sdk.n.h(this.tag, "An ad is not ready to be shown yet");
                                } else if (dVar != d.DESTROYED) {
                                    if (com.applovin.impl.sdk.n.a()) {
                                        this.logger.b(this.tag, "Unable to transition to: " + dVar);
                                    }
                                }
                            }
                            z2 = false;
                        }
                        z2 = true;
                    } else {
                        d dVar5 = d.READY;
                        if (dVar2 == dVar5) {
                            if (dVar != dVar3) {
                                if (dVar == dVar4) {
                                    com.applovin.impl.sdk.n.h(this.tag, "An ad is already loaded");
                                } else if (dVar == dVar5) {
                                    if (com.applovin.impl.sdk.n.a()) {
                                        this.logger.b(this.tag, "An ad is already marked as ready");
                                    }
                                } else if (dVar != d.SHOWING && dVar != d.DESTROYED) {
                                    if (com.applovin.impl.sdk.n.a()) {
                                        this.logger.b(this.tag, "Unable to transition to: " + dVar);
                                    }
                                }
                                z2 = false;
                            }
                            z2 = true;
                        } else {
                            d dVar6 = d.SHOWING;
                            if (dVar2 == dVar6) {
                                if (dVar != dVar3) {
                                    if (dVar == dVar4) {
                                        maxErrorImpl = new MaxErrorImpl(-27, "Can not load another ad while the ad is showing");
                                        com.applovin.impl.sdk.n.h(this.tag, maxErrorImpl.getMessage());
                                    } else if (dVar == dVar5) {
                                        if (com.applovin.impl.sdk.n.a()) {
                                            this.logger.b(this.tag, "An ad is already showing, ignoring");
                                        }
                                    } else if (dVar == dVar6) {
                                        com.applovin.impl.sdk.n.h(this.tag, "The ad is already showing, not showing another one");
                                    } else if (dVar != d.DESTROYED) {
                                        if (com.applovin.impl.sdk.n.a()) {
                                            this.logger.b(this.tag, "Unable to transition to: " + dVar);
                                        }
                                    }
                                }
                                z2 = true;
                            } else if (dVar2 == d.DESTROYED) {
                                com.applovin.impl.sdk.n.h(this.tag, "No operations are allowed on a destroyed instance");
                            } else if (com.applovin.impl.sdk.n.a()) {
                                this.logger.b(this.tag, "Unknown state: " + this.f61515g);
                            }
                            z2 = false;
                        }
                    }
                }
                if (z2) {
                    if (com.applovin.impl.sdk.n.a()) {
                        this.logger.a(this.tag, "Transitioning from " + this.f61515g + " to " + dVar + "...");
                    }
                    this.f61515g = dVar;
                } else if (com.applovin.impl.sdk.n.a()) {
                    this.logger.k(this.tag, "Not allowed to transition from " + this.f61515g + " to " + dVar);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (z2) {
            eVar.a();
        } else {
            eVar.a(maxErrorImpl);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(MaxAd maxAd) {
        this.sdk.f().a((he) maxAd);
        this.f61512d.a();
        a();
        this.sdk.S().a((fe) maxAd);
    }
}
