package com.applovin.impl.mediation.ads;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.applovin.impl.fc;
import com.applovin.impl.fe;
import com.applovin.impl.i8;
import com.applovin.impl.ie;
import com.applovin.impl.jn;
import com.applovin.impl.mediation.MaxErrorImpl;
import com.applovin.impl.mediation.ads.a;
import com.applovin.impl.mediation.d;
import com.applovin.impl.sdk.a;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.impl.tm;
import com.applovin.impl.ue;
import com.applovin.impl.v;
import com.applovin.impl.yl;
import com.applovin.impl.yp;
import com.applovin.impl.z3;
import com.applovin.mediation.MaxAd;
import com.applovin.mediation.MaxAdFormat;
import com.applovin.mediation.MaxError;
import com.applovin.mediation.nativeAds.MaxNativeAd;
import com.applovin.mediation.nativeAds.MaxNativeAdListener;
import com.applovin.mediation.nativeAds.MaxNativeAdView;
import com.applovin.sdk.AppLovinSdkUtils;
import com.google.firebase.crashlytics.internal.breadcrumbs.PKU.tDEtWsFLJfe;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class MaxNativeAdLoaderImpl extends com.applovin.impl.mediation.ads.a implements a.InterfaceC0121a, v.b {
    public static final String KEY_EXTRA_PARAMETER_AD_REQUEST_TYPE = "ad_request_type";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final c f61536a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f61537b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f61538c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private d.b f61539d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Object f61540e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private MaxNativeAdListener f61541f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Map f61542g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final Set f61543h;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ MaxNativeAd f61544a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ List f61545b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ ViewGroup f61546c;

        a(MaxNativeAd maxNativeAd, List list, ViewGroup viewGroup) {
            this.f61544a = maxNativeAd;
            this.f61545b = list;
            this.f61546c = viewGroup;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f61544a.prepareForInteraction(this.f61545b, this.f61546c)) {
                return;
            }
            com.applovin.impl.sdk.n.h(MaxNativeAdLoaderImpl.this.tag, "Failed to prepare native ad for interaction...");
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ MaxNativeAdView f61548a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ ie f61549b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ MaxNativeAd f61550c;

        b(MaxNativeAdView maxNativeAdView, ie ieVar, MaxNativeAd maxNativeAd) {
            this.f61548a = maxNativeAdView;
            this.f61549b = ieVar;
            this.f61550c = maxNativeAd;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.applovin.impl.sdk.n nVar = MaxNativeAdLoaderImpl.this.logger;
            if (com.applovin.impl.sdk.n.a()) {
                MaxNativeAdLoaderImpl maxNativeAdLoaderImpl = MaxNativeAdLoaderImpl.this;
                maxNativeAdLoaderImpl.logger.a(maxNativeAdLoaderImpl.tag, "Rendering native ad view: " + this.f61548a);
            }
            this.f61548a.render(this.f61549b, MaxNativeAdLoaderImpl.this.f61536a, MaxNativeAdLoaderImpl.this.sdk);
            this.f61550c.setNativeAdView(this.f61548a);
            if (this.f61550c.prepareForInteraction(this.f61548a.getClickableViews(), this.f61548a)) {
                return;
            }
            this.f61550c.prepareViewForInteraction(this.f61548a);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class c implements a.InterfaceC0110a {
        private c() {
        }

        @Override // com.applovin.mediation.MaxAdListener
        public void onAdClicked(MaxAd maxAd) {
            com.applovin.impl.sdk.n nVar = MaxNativeAdLoaderImpl.this.logger;
            if (com.applovin.impl.sdk.n.a()) {
                MaxNativeAdLoaderImpl maxNativeAdLoaderImpl = MaxNativeAdLoaderImpl.this;
                maxNativeAdLoaderImpl.logger.a(maxNativeAdLoaderImpl.tag, "MaxNativeAdListener.onNativeAdClicked(nativeAd=" + maxAd + "), listener=" + MaxNativeAdLoaderImpl.this.f61541f);
            }
            fc.a(MaxNativeAdLoaderImpl.this.f61541f, maxAd, true);
        }

        @Override // com.applovin.mediation.MaxAdListener
        public void onAdLoadFailed(String str, MaxError maxError) {
            MaxNativeAdLoaderImpl.this.a(((MaxErrorImpl) maxError).getLoadTag());
            com.applovin.impl.sdk.n nVar = MaxNativeAdLoaderImpl.this.logger;
            if (com.applovin.impl.sdk.n.a()) {
                MaxNativeAdLoaderImpl maxNativeAdLoaderImpl = MaxNativeAdLoaderImpl.this;
                maxNativeAdLoaderImpl.logger.a(maxNativeAdLoaderImpl.tag, "MaxNativeAdListener.onNativeAdLoadFailed(adUnitId=" + str + ", error=" + maxError + "), listener=" + MaxNativeAdLoaderImpl.this.f61541f);
            }
            fc.a(MaxNativeAdLoaderImpl.this.f61541f, str, maxError, true);
        }

        @Override // com.applovin.mediation.MaxAdListener
        public void onAdLoaded(final MaxAd maxAd) {
            AppLovinSdkUtils.runOnUiThread(new Runnable() { // from class: com.applovin.impl.mediation.ads.s
                @Override // java.lang.Runnable
                public final void run() {
                    this.f61598a.a(maxAd);
                }
            });
        }

        @Override // com.applovin.mediation.MaxAdRevenueListener
        public void onAdRevenuePaid(MaxAd maxAd) {
            com.applovin.impl.sdk.n nVar = MaxNativeAdLoaderImpl.this.logger;
            if (com.applovin.impl.sdk.n.a()) {
                MaxNativeAdLoaderImpl maxNativeAdLoaderImpl = MaxNativeAdLoaderImpl.this;
                maxNativeAdLoaderImpl.logger.a(maxNativeAdLoaderImpl.tag, "MaxAdRevenueListener.onAdRevenuePaid(ad=" + maxAd + "), listener=" + MaxNativeAdLoaderImpl.this.revenueListener);
            }
            fc.a(MaxNativeAdLoaderImpl.this.revenueListener, maxAd, true);
        }

        /* synthetic */ c(MaxNativeAdLoaderImpl maxNativeAdLoaderImpl, a aVar) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void a(MaxAd maxAd) {
            com.applovin.impl.sdk.n nVar = MaxNativeAdLoaderImpl.this.logger;
            if (com.applovin.impl.sdk.n.a()) {
                MaxNativeAdLoaderImpl maxNativeAdLoaderImpl = MaxNativeAdLoaderImpl.this;
                maxNativeAdLoaderImpl.logger.a(maxNativeAdLoaderImpl.tag, "Native ad loaded");
            }
            ie ieVar = (ie) maxAd;
            ieVar.g(MaxNativeAdLoaderImpl.this.f61537b);
            ieVar.f(MaxNativeAdLoaderImpl.this.f61538c);
            MaxNativeAdLoaderImpl.this.sdk.v().d(ieVar);
            synchronized (MaxNativeAdLoaderImpl.this.f61540e) {
                MaxNativeAdLoaderImpl.this.f61543h.add(ieVar);
            }
            MaxNativeAdView maxNativeAdViewA = MaxNativeAdLoaderImpl.this.a(ieVar.M());
            if (maxNativeAdViewA == null) {
                com.applovin.impl.sdk.n nVar2 = MaxNativeAdLoaderImpl.this.logger;
                if (com.applovin.impl.sdk.n.a()) {
                    MaxNativeAdLoaderImpl maxNativeAdLoaderImpl2 = MaxNativeAdLoaderImpl.this;
                    maxNativeAdLoaderImpl2.logger.a(maxNativeAdLoaderImpl2.tag, "No custom view provided, checking template");
                }
                String strR0 = ieVar.r0();
                if (StringUtils.isValidString(strR0)) {
                    com.applovin.impl.sdk.n nVar3 = MaxNativeAdLoaderImpl.this.logger;
                    if (com.applovin.impl.sdk.n.a()) {
                        MaxNativeAdLoaderImpl maxNativeAdLoaderImpl3 = MaxNativeAdLoaderImpl.this;
                        maxNativeAdLoaderImpl3.logger.a(maxNativeAdLoaderImpl3.tag, "Using template: " + strR0 + "...");
                    }
                    maxNativeAdViewA = new MaxNativeAdView(strR0, com.applovin.impl.sdk.j.m());
                }
            }
            if (maxNativeAdViewA == null) {
                com.applovin.impl.sdk.n nVar4 = MaxNativeAdLoaderImpl.this.logger;
                if (com.applovin.impl.sdk.n.a()) {
                    MaxNativeAdLoaderImpl maxNativeAdLoaderImpl4 = MaxNativeAdLoaderImpl.this;
                    maxNativeAdLoaderImpl4.logger.a(maxNativeAdLoaderImpl4.tag, "No native ad view to render. Returning the native ad to be rendered later.");
                }
                com.applovin.impl.sdk.n nVar5 = MaxNativeAdLoaderImpl.this.logger;
                if (com.applovin.impl.sdk.n.a()) {
                    MaxNativeAdLoaderImpl maxNativeAdLoaderImpl5 = MaxNativeAdLoaderImpl.this;
                    maxNativeAdLoaderImpl5.logger.a(maxNativeAdLoaderImpl5.tag, "MaxNativeAdListener.onNativeAdLoaded(nativeAdView=null, nativeAd=" + maxAd + "), listener=" + MaxNativeAdLoaderImpl.this.f61541f);
                }
                fc.a(MaxNativeAdLoaderImpl.this.f61541f, (MaxNativeAdView) null, maxAd, true);
                MaxNativeAdLoaderImpl.this.a(ieVar);
                return;
            }
            a(maxNativeAdViewA);
            MaxNativeAdLoaderImpl.this.a(maxNativeAdViewA, ieVar, ieVar.getNativeAd());
            com.applovin.impl.sdk.n nVar6 = MaxNativeAdLoaderImpl.this.logger;
            if (com.applovin.impl.sdk.n.a()) {
                MaxNativeAdLoaderImpl maxNativeAdLoaderImpl6 = MaxNativeAdLoaderImpl.this;
                maxNativeAdLoaderImpl6.logger.a(maxNativeAdLoaderImpl6.tag, "MaxNativeAdListener.onNativeAdLoaded(nativeAdView=" + maxNativeAdViewA + ", nativeAd=" + maxAd + "), listener=" + MaxNativeAdLoaderImpl.this.f61541f);
            }
            fc.a(MaxNativeAdLoaderImpl.this.f61541f, maxNativeAdViewA, maxAd, true);
            MaxNativeAdLoaderImpl.this.a(ieVar);
            MaxNativeAdLoaderImpl.this.a(maxNativeAdViewA);
        }

        @Override // com.applovin.mediation.MaxAdListener
        public void onAdDisplayed(MaxAd maxAd) {
        }

        @Override // com.applovin.mediation.MaxAdListener
        public void onAdHidden(MaxAd maxAd) {
        }

        @Override // com.applovin.mediation.MaxAdRequestListener
        public void onAdRequestStarted(String str) {
        }

        private void a(MaxNativeAdView maxNativeAdView) {
            ie ieVarB;
            com.applovin.impl.mediation.ads.b adViewTracker = maxNativeAdView.getAdViewTracker();
            if (adViewTracker == null || (ieVarB = adViewTracker.b()) == null) {
                return;
            }
            com.applovin.impl.sdk.n nVar = MaxNativeAdLoaderImpl.this.logger;
            if (com.applovin.impl.sdk.n.a()) {
                MaxNativeAdLoaderImpl maxNativeAdLoaderImpl = MaxNativeAdLoaderImpl.this;
                maxNativeAdLoaderImpl.logger.a(maxNativeAdLoaderImpl.tag, "Destroying previous ad");
            }
            MaxNativeAdLoaderImpl.this.destroy(ieVarB);
        }

        @Override // com.applovin.mediation.MaxAdListener
        public void onAdDisplayFailed(MaxAd maxAd, MaxError maxError) {
        }
    }

    public MaxNativeAdLoaderImpl(String str, com.applovin.impl.sdk.j jVar) {
        super(str, MaxAdFormat.NATIVE, "MaxNativeAdLoader", jVar);
        this.f61536a = new c(this, null);
        this.f61539d = d.b.PUBLISHER_INITIATED;
        this.f61540e = new Object();
        this.f61542g = new HashMap();
        this.f61543h = new HashSet();
        jVar.i().a(this);
        if (com.applovin.impl.sdk.n.a()) {
            this.logger.a(this.tag, "Created new MaxNativeAdLoader (" + this + ")");
        }
    }

    @Override // com.applovin.impl.mediation.ads.a
    public void destroy() {
        this.f61541f = null;
        this.sdk.i().b(this);
        synchronized (this.f61540e) {
            this.f61542g.clear();
            this.f61543h.clear();
        }
        super.destroy();
    }

    public String getPlacement() {
        return this.f61537b;
    }

    public void loadAd(MaxNativeAdView maxNativeAdView) {
        if (com.applovin.impl.sdk.n.a()) {
            this.logger.a(this.tag, "Loading native ad for '" + this.adUnitId + "' into '" + maxNativeAdView + "' and notifying " + this.f61536a + "...");
        }
        this.extraParameters.put("integration_type", maxNativeAdView != null ? "custom_ad_view" : "no_ad_view");
        String lowerCase = UUID.randomUUID().toString().toLowerCase(Locale.US);
        a(lowerCase, maxNativeAdView);
        this.sdk.P().loadAd(this.adUnitId, lowerCase, MaxAdFormat.NATIVE, this.f61539d, this.localExtraParameters, this.extraParameters, com.applovin.impl.sdk.j.m(), this.f61536a);
    }

    @Override // com.applovin.impl.sdk.a.InterfaceC0121a
    public void onAdExpired(i8 i8Var) {
        if (com.applovin.impl.sdk.n.a()) {
            this.logger.a(this.tag, "Ad expired for ad unit id " + getAdUnitId());
        }
        if (com.applovin.impl.sdk.n.a()) {
            this.logger.a(this.tag, "MaxNativeAdListener.onNativeAdExpired(nativeAd=" + i8Var + "), listener=" + this.f61541f);
        }
        fc.b(this.f61541f, (MaxAd) i8Var, true);
    }

    @Override // com.applovin.impl.v.b
    public void onCreativeIdGenerated(String str, String str2) {
        ie ieVar;
        Iterator it = this.f61543h.iterator();
        while (true) {
            if (!it.hasNext()) {
                ieVar = null;
                break;
            } else {
                ieVar = (ie) it.next();
                if (ieVar.R().equalsIgnoreCase(str)) {
                    break;
                }
            }
        }
        if (ieVar != null) {
            ieVar.h(str2);
            fc.b(this.adReviewListener, str2, ieVar);
            synchronized (this.f61540e) {
                this.f61543h.remove(ieVar);
            }
        }
    }

    public void registerClickableViews(List<View> list, ViewGroup viewGroup, MaxAd maxAd) {
        ie ieVar = (ie) maxAd;
        MaxNativeAd nativeAd = ieVar.getNativeAd();
        if (nativeAd == null) {
            if (com.applovin.impl.sdk.n.a()) {
                this.logger.b(this.tag, "Failed to register native ad. Could not retrieve MaxNativeAd. The ad may have already been destroyed.");
                return;
            }
            return;
        }
        ieVar.a(viewGroup);
        this.sdk.v().d(ieVar);
        a((fe) ieVar);
        nativeAd.setClickableViews(list);
        nativeAd.setAdViewTracker(new com.applovin.impl.mediation.ads.b(ieVar, viewGroup, this.f61536a, this.sdk));
        a aVar = new a(nativeAd, list, viewGroup);
        if (nativeAd.shouldPrepareViewForInteractionOnMainThread()) {
            AppLovinSdkUtils.runOnUiThread(aVar);
        } else {
            this.sdk.i0().a((yl) new jn(this.sdk, "renderMaxNativeAd", aVar), tm.b.MEDIATION);
        }
    }

    public boolean render(MaxNativeAdView maxNativeAdView, MaxAd maxAd) {
        if (!(maxAd instanceof ie)) {
            com.applovin.impl.sdk.n.h(this.tag, "Failed to render native ad. `ad` needs to be of type `MediatedNativeAd` to render.");
            return false;
        }
        if (maxNativeAdView == null) {
            com.applovin.impl.sdk.n.h(this.tag, "Failed to render native ad. `adView` to render cannot be null.");
            return false;
        }
        ie ieVar = (ie) maxAd;
        MaxNativeAd nativeAd = ieVar.getNativeAd();
        if (nativeAd == null) {
            if (com.applovin.impl.sdk.n.a()) {
                this.logger.b(this.tag, "Failed to render native ad. Could not retrieve MaxNativeAd. The ad may have already been destroyed.");
            }
            return false;
        }
        if (nativeAd.isExpired() && !((Boolean) this.sdk.a(ue.i7)).booleanValue()) {
            com.applovin.impl.sdk.n.h(this.tag, "Cancelled rendering for expired native ad. Check if an ad is expired before displaying using `MaxAd.getNativeAd().isExpired()`");
            return false;
        }
        a(maxNativeAdView, ieVar, nativeAd);
        a(maxNativeAdView);
        return true;
    }

    public void setCustomData(String str) {
        yp.b(str, this.tag);
        this.f61538c = str;
    }

    @Override // com.applovin.impl.mediation.ads.a
    public void setLocalExtraParameter(String str, Object obj) {
        super.setLocalExtraParameter(str, obj);
        if (KEY_EXTRA_PARAMETER_AD_REQUEST_TYPE.equalsIgnoreCase(str) && (obj instanceof d.b)) {
            this.f61539d = (d.b) obj;
        }
    }

    public void setNativeAdListener(MaxNativeAdListener maxNativeAdListener) {
        if (com.applovin.impl.sdk.n.a()) {
            this.logger.a(this.tag, "Setting native ad listener: " + maxNativeAdListener);
        }
        this.f61541f = maxNativeAdListener;
    }

    public void setPlacement(String str) {
        this.f61537b = str;
    }

    public String toString() {
        return "MaxNativeAdLoader{adUnitId='" + this.adUnitId + "', nativeAdListener=" + this.f61541f + ", revenueListener=" + this.revenueListener + '}';
    }

    public void handleNativeAdViewRendered(MaxAd maxAd) {
        MaxNativeAd nativeAd = ((ie) maxAd).getNativeAd();
        if (nativeAd == null) {
            if (com.applovin.impl.sdk.n.a()) {
                this.logger.b(this.tag, tDEtWsFLJfe.opSA);
                return;
            }
            return;
        }
        com.applovin.impl.mediation.ads.b adViewTracker = nativeAd.getAdViewTracker();
        if (adViewTracker != null) {
            adViewTracker.c();
        } else if (com.applovin.impl.sdk.n.a()) {
            this.logger.b(this.tag, "Failed to handle native ad rendered. Could not retrieve tracker. Ad might not have been registered via MaxNativeAdLoader.a(...).");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(MaxNativeAdView maxNativeAdView, ie ieVar, MaxNativeAd maxNativeAd) {
        ieVar.a(maxNativeAdView);
        a((fe) ieVar);
        b bVar = new b(maxNativeAdView, ieVar, maxNativeAd);
        if (maxNativeAd.shouldPrepareViewForInteractionOnMainThread()) {
            AppLovinSdkUtils.runOnUiThread(bVar);
        } else {
            this.sdk.i0().a((yl) new jn(this.sdk, "renderMaxNativeAd", bVar), tm.b.MEDIATION);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ie ieVar) {
        if (ieVar.q0().get()) {
            return;
        }
        this.sdk.f().a(ieVar, this);
    }

    public void destroy(MaxAd maxAd) {
        com.applovin.impl.mediation.ads.b adViewTracker;
        if (maxAd instanceof ie) {
            ie ieVar = (ie) maxAd;
            if (ieVar.u0()) {
                if (com.applovin.impl.sdk.n.a()) {
                    this.logger.a(this.tag, "Native ad (" + ieVar + ") has already been destroyed");
                    return;
                }
                return;
            }
            synchronized (this.f61540e) {
                this.f61543h.remove(ieVar);
            }
            MaxNativeAdView maxNativeAdViewO0 = ieVar.o0();
            if (maxNativeAdViewO0 != null && (adViewTracker = maxNativeAdViewO0.getAdViewTracker()) != null && maxAd.equals(adViewTracker.b())) {
                maxNativeAdViewO0.recycle();
            }
            MaxNativeAd nativeAd = ieVar.getNativeAd();
            if (nativeAd != null && nativeAd.getAdViewTracker() != null) {
                nativeAd.getAdViewTracker().a();
            }
            this.sdk.f().a(ieVar);
            this.sdk.P().destroyAd(ieVar);
            this.sdk.J().c(this.adUnitId, ieVar.M());
            return;
        }
        if (com.applovin.impl.sdk.n.a()) {
            this.logger.a(this.tag, "Destroy failed on non-native ad(" + maxAd + ")");
        }
    }

    private void a(String str, MaxNativeAdView maxNativeAdView) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        synchronized (this.f61540e) {
            this.f61542g.put(str, maxNativeAdView);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public MaxNativeAdView a(String str) {
        MaxNativeAdView maxNativeAdView;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        synchronized (this.f61540e) {
            maxNativeAdView = (MaxNativeAdView) this.f61542g.remove(str);
        }
        return maxNativeAdView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(MaxNativeAdView maxNativeAdView) {
        com.applovin.impl.mediation.ads.b adViewTracker = maxNativeAdView.getAdViewTracker();
        if (adViewTracker != null) {
            if (z3.e()) {
                if (maxNativeAdView.isAttachedToWindow()) {
                    adViewTracker.c();
                }
            } else if (maxNativeAdView.getParent() != null) {
                adViewTracker.c();
            }
        }
    }
}
