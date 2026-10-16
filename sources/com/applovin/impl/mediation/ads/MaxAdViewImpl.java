package com.applovin.impl.mediation.ads;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.applovin.impl.ar;
import com.applovin.impl.br;
import com.applovin.impl.e0;
import com.applovin.impl.fc;
import com.applovin.impl.fe;
import com.applovin.impl.ge;
import com.applovin.impl.jn;
import com.applovin.impl.ka;
import com.applovin.impl.mediation.MaxErrorImpl;
import com.applovin.impl.mediation.ads.a;
import com.applovin.impl.mediation.d;
import com.applovin.impl.sdk.f;
import com.applovin.impl.sdk.utils.CollectionUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.impl.tm;
import com.applovin.impl.ue;
import com.applovin.impl.v;
import com.applovin.impl.yl;
import com.applovin.impl.yp;
import com.applovin.impl.z3;
import com.applovin.impl.zq;
import com.applovin.mediation.MaxAd;
import com.applovin.mediation.MaxAdFormat;
import com.applovin.mediation.MaxAdListener;
import com.applovin.mediation.MaxAdRevenueListener;
import com.applovin.mediation.MaxAdViewAdListener;
import com.applovin.mediation.MaxError;
import com.applovin.mediation.ads.MaxAdView;
import com.applovin.sdk.AppLovinSdkUtils;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class MaxAdViewImpl extends com.applovin.impl.mediation.ads.a implements f.a, br.a, v.b {
    private boolean A;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f61479a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final MaxAdView f61480b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f61481c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final View f61482d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private long f61483e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private ge f61484f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private String f61485g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private String f61486h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final b f61487i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final d f61488j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final com.applovin.impl.sdk.f f61489k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final ar f61490l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final br f61491m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final Object f61492n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final Object f61493o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private ge f61494p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private boolean f61495q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private boolean f61496r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private final AtomicBoolean f61497s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private boolean f61498t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private boolean f61499u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private boolean f61500v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private boolean f61501w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private boolean f61502x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private boolean f61503y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private boolean f61504z;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private class b extends c {
        private b() {
            super();
        }

        @Override // com.applovin.mediation.MaxAdListener
        public void onAdLoadFailed(String str, MaxError maxError) {
            com.applovin.impl.sdk.n nVar = MaxAdViewImpl.this.logger;
            if (com.applovin.impl.sdk.n.a()) {
                MaxAdViewImpl maxAdViewImpl = MaxAdViewImpl.this;
                maxAdViewImpl.logger.a(maxAdViewImpl.tag, "MaxAdListener.onAdLoadFailed(adUnitId=" + str + ", error=" + maxError + "), listener=" + MaxAdViewImpl.this.adListener);
            }
            fc.a(MaxAdViewImpl.this.adListener, str, maxError, true);
            MaxAdViewImpl.this.a(maxError);
        }

        @Override // com.applovin.mediation.MaxAdListener
        public void onAdLoaded(MaxAd maxAd) {
            if (MaxAdViewImpl.this.a()) {
                com.applovin.impl.sdk.n nVar = MaxAdViewImpl.this.logger;
                if (com.applovin.impl.sdk.n.a()) {
                    MaxAdViewImpl maxAdViewImpl = MaxAdViewImpl.this;
                    maxAdViewImpl.logger.a(maxAdViewImpl.tag, "Precache ad with ad unit ID '" + MaxAdViewImpl.this.adUnitId + "' loaded after MaxAdView was destroyed. Destroying the ad.");
                }
                MaxAdViewImpl.this.sdk.P().destroyAd(maxAd);
                return;
            }
            ge geVar = (ge) maxAd;
            geVar.g(MaxAdViewImpl.this.f61485g);
            geVar.f(MaxAdViewImpl.this.f61486h);
            if (geVar.y() == null) {
                MaxAdViewImpl.this.sdk.P().destroyAd(geVar);
                onAdLoadFailed(geVar.getAdUnitId(), new MaxErrorImpl(-5001, "Ad view not fully loaded"));
                return;
            }
            if (geVar.s0()) {
                long jN0 = geVar.n0();
                MaxAdViewImpl.this.sdk.I();
                if (com.applovin.impl.sdk.n.a()) {
                    MaxAdViewImpl.this.sdk.I().a(MaxAdViewImpl.this.tag, "Scheduling banner ad refresh " + jN0 + " milliseconds from now for '" + MaxAdViewImpl.this.adUnitId + "'...");
                }
                MaxAdViewImpl.this.f61489k.a(jN0);
                if (MaxAdViewImpl.this.f61489k.g() || MaxAdViewImpl.this.f61496r) {
                    com.applovin.impl.sdk.n nVar2 = MaxAdViewImpl.this.logger;
                    if (com.applovin.impl.sdk.n.a()) {
                        MaxAdViewImpl maxAdViewImpl2 = MaxAdViewImpl.this;
                        maxAdViewImpl2.logger.a(maxAdViewImpl2.tag, "Pausing ad refresh for publisher");
                    }
                    MaxAdViewImpl.this.f61489k.j();
                }
            }
            com.applovin.impl.sdk.n nVar3 = MaxAdViewImpl.this.logger;
            if (com.applovin.impl.sdk.n.a()) {
                MaxAdViewImpl maxAdViewImpl3 = MaxAdViewImpl.this;
                maxAdViewImpl3.logger.a(maxAdViewImpl3.tag, "MaxAdListener.onAdLoaded(ad=" + maxAd + "), listener=" + MaxAdViewImpl.this.adListener);
            }
            fc.f(MaxAdViewImpl.this.adListener, maxAd, true);
            MaxAdViewImpl.this.d(geVar);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private abstract class c implements MaxAdListener, MaxAdViewAdListener, MaxAdRevenueListener, a.InterfaceC0110a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private boolean f61506a;

        private c() {
        }

        @Override // com.applovin.mediation.MaxAdListener
        public void onAdClicked(MaxAd maxAd) {
            if (maxAd.equals(MaxAdViewImpl.this.f61494p)) {
                com.applovin.impl.sdk.n nVar = MaxAdViewImpl.this.logger;
                if (com.applovin.impl.sdk.n.a()) {
                    MaxAdViewImpl maxAdViewImpl = MaxAdViewImpl.this;
                    maxAdViewImpl.logger.a(maxAdViewImpl.tag, "MaxAdListener.onAdClicked(ad=" + maxAd + "), listener=" + MaxAdViewImpl.this.adListener);
                }
                fc.a(MaxAdViewImpl.this.adListener, maxAd, true);
            }
        }

        @Override // com.applovin.mediation.MaxAdViewAdListener
        public void onAdCollapsed(MaxAd maxAd) {
            if (maxAd.equals(MaxAdViewImpl.this.f61494p)) {
                if ((MaxAdViewImpl.this.f61494p.t0() || MaxAdViewImpl.this.f61503y) && this.f61506a) {
                    this.f61506a = false;
                    MaxAdViewImpl.this.startAutoRefresh();
                }
                com.applovin.impl.sdk.n nVar = MaxAdViewImpl.this.logger;
                if (com.applovin.impl.sdk.n.a()) {
                    MaxAdViewImpl maxAdViewImpl = MaxAdViewImpl.this;
                    maxAdViewImpl.logger.a(maxAdViewImpl.tag, "MaxAdViewAdListener.onAdCollapsed(ad=" + maxAd + "), listener=" + MaxAdViewImpl.this.adListener);
                }
                fc.b(MaxAdViewImpl.this.adListener, maxAd, true);
            }
        }

        @Override // com.applovin.mediation.MaxAdListener
        public void onAdDisplayFailed(MaxAd maxAd, MaxError maxError) {
            if (maxAd.equals(MaxAdViewImpl.this.f61494p)) {
                com.applovin.impl.sdk.n nVar = MaxAdViewImpl.this.logger;
                if (com.applovin.impl.sdk.n.a()) {
                    MaxAdViewImpl maxAdViewImpl = MaxAdViewImpl.this;
                    maxAdViewImpl.logger.a(maxAdViewImpl.tag, "MaxAdListener.onAdDisplayFailed(ad=" + maxAd + ", error=" + maxError + "), listener=" + MaxAdViewImpl.this.adListener);
                }
                fc.a(MaxAdViewImpl.this.adListener, maxAd, maxError, true);
            }
        }

        @Override // com.applovin.mediation.MaxAdListener
        public void onAdDisplayed(MaxAd maxAd) {
            if (maxAd.equals(MaxAdViewImpl.this.f61494p)) {
                com.applovin.impl.sdk.n nVar = MaxAdViewImpl.this.logger;
                if (com.applovin.impl.sdk.n.a()) {
                    MaxAdViewImpl maxAdViewImpl = MaxAdViewImpl.this;
                    maxAdViewImpl.logger.a(maxAdViewImpl.tag, "MaxAdListener.onAdDisplayed(ad=" + maxAd + "), listener=" + MaxAdViewImpl.this.adListener);
                }
                fc.c(MaxAdViewImpl.this.adListener, maxAd, true);
            }
        }

        @Override // com.applovin.mediation.MaxAdViewAdListener
        public void onAdExpanded(MaxAd maxAd) {
            if (maxAd.equals(MaxAdViewImpl.this.f61494p)) {
                if ((MaxAdViewImpl.this.f61494p.t0() || MaxAdViewImpl.this.f61503y) && !MaxAdViewImpl.this.f61489k.g()) {
                    this.f61506a = true;
                    MaxAdViewImpl.this.stopAutoRefresh();
                }
                com.applovin.impl.sdk.n nVar = MaxAdViewImpl.this.logger;
                if (com.applovin.impl.sdk.n.a()) {
                    MaxAdViewImpl maxAdViewImpl = MaxAdViewImpl.this;
                    maxAdViewImpl.logger.a(maxAdViewImpl.tag, "MaxAdViewAdListener.onAdExpanded(ad=" + maxAd + "), listener=" + MaxAdViewImpl.this.adListener);
                }
                fc.d(MaxAdViewImpl.this.adListener, maxAd, true);
            }
        }

        @Override // com.applovin.mediation.MaxAdListener
        public void onAdHidden(MaxAd maxAd) {
            if (maxAd.equals(MaxAdViewImpl.this.f61494p)) {
                com.applovin.impl.sdk.n nVar = MaxAdViewImpl.this.logger;
                if (com.applovin.impl.sdk.n.a()) {
                    MaxAdViewImpl maxAdViewImpl = MaxAdViewImpl.this;
                    maxAdViewImpl.logger.a(maxAdViewImpl.tag, "MaxAdListener.onAdHidden(ad=" + maxAd + "), listener=" + MaxAdViewImpl.this.adListener);
                }
                fc.e(MaxAdViewImpl.this.adListener, maxAd, true);
            }
        }

        @Override // com.applovin.mediation.MaxAdRequestListener
        public void onAdRequestStarted(String str) {
            com.applovin.impl.sdk.n nVar = MaxAdViewImpl.this.logger;
            if (com.applovin.impl.sdk.n.a()) {
                MaxAdViewImpl maxAdViewImpl = MaxAdViewImpl.this;
                maxAdViewImpl.logger.a(maxAdViewImpl.tag, "MaxAdRequestListener.onAdRequestStarted(adUnitId=" + str + "), listener=" + MaxAdViewImpl.this.requestListener);
            }
            fc.a(MaxAdViewImpl.this.requestListener, str, true);
        }

        @Override // com.applovin.mediation.MaxAdRevenueListener
        public void onAdRevenuePaid(MaxAd maxAd) {
            com.applovin.impl.sdk.n nVar = MaxAdViewImpl.this.logger;
            if (com.applovin.impl.sdk.n.a()) {
                MaxAdViewImpl maxAdViewImpl = MaxAdViewImpl.this;
                maxAdViewImpl.logger.a(maxAdViewImpl.tag, "MaxAdRevenueListener.onAdRevenuePaid(ad=" + maxAd + "), listener=" + MaxAdViewImpl.this.revenueListener);
            }
            fc.a(MaxAdViewImpl.this.revenueListener, maxAd, true);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private class d extends c {
        private d() {
            super();
        }

        @Override // com.applovin.mediation.MaxAdListener
        public void onAdLoadFailed(String str, MaxError maxError) {
            com.applovin.impl.sdk.n nVar = MaxAdViewImpl.this.logger;
            if (com.applovin.impl.sdk.n.a()) {
                MaxAdViewImpl maxAdViewImpl = MaxAdViewImpl.this;
                maxAdViewImpl.logger.a(maxAdViewImpl.tag, "Failed to precache ad for refresh with error code: " + maxError.getCode());
            }
            MaxAdViewImpl.this.a(maxError);
        }

        @Override // com.applovin.mediation.MaxAdListener
        public void onAdLoaded(MaxAd maxAd) {
            if (!MaxAdViewImpl.this.f61499u) {
                com.applovin.impl.sdk.n nVar = MaxAdViewImpl.this.logger;
                if (com.applovin.impl.sdk.n.a()) {
                    MaxAdViewImpl maxAdViewImpl = MaxAdViewImpl.this;
                    maxAdViewImpl.logger.a(maxAdViewImpl.tag, "Successfully precached ad for refresh");
                }
                if (((Boolean) MaxAdViewImpl.this.sdk.a(ue.X6)).booleanValue()) {
                    MaxAdViewImpl.this.b(maxAd);
                    return;
                } else {
                    MaxAdViewImpl.this.a(maxAd);
                    return;
                }
            }
            com.applovin.impl.sdk.n nVar2 = MaxAdViewImpl.this.logger;
            if (com.applovin.impl.sdk.n.a()) {
                MaxAdViewImpl maxAdViewImpl2 = MaxAdViewImpl.this;
                maxAdViewImpl2.logger.a(maxAdViewImpl2.tag, "Ad with ad unit ID '" + MaxAdViewImpl.this.adUnitId + "' loaded after MaxAdView was destroyed. Destroying the ad.");
            }
            MaxAdViewImpl.this.sdk.P().destroyAd(maxAd);
        }
    }

    public MaxAdViewImpl(String str, MaxAdFormat maxAdFormat, MaxAdView maxAdView, View view, com.applovin.impl.sdk.j jVar, Context context) {
        super(str, maxAdFormat, "MaxAdView", jVar);
        this.f61481c = UUID.randomUUID().toString().toLowerCase(Locale.US);
        this.f61483e = Long.MAX_VALUE;
        this.f61492n = new Object();
        this.f61493o = new Object();
        this.f61494p = null;
        this.f61497s = new AtomicBoolean();
        this.f61499u = false;
        if (context == null) {
            throw new IllegalArgumentException("No context specified");
        }
        this.f61479a = context.getApplicationContext();
        this.f61480b = maxAdView;
        this.f61482d = view;
        this.f61487i = new b();
        this.f61488j = new d();
        this.f61489k = new com.applovin.impl.sdk.f(jVar, this);
        this.f61490l = new ar(maxAdView, jVar);
        this.f61491m = new br(maxAdView, jVar, this);
        jVar.i().a(this);
        if (com.applovin.impl.sdk.n.a()) {
            this.logger.a(this.tag, "Created new MaxAdView (" + this + ")");
        }
    }

    @Override // com.applovin.impl.mediation.ads.a
    public void destroy() {
        g();
        if (this.f61484f != null) {
            this.sdk.P().destroyAd(this.f61484f);
        }
        synchronized (this.f61492n) {
            this.f61499u = true;
        }
        this.f61489k.a();
        this.sdk.i().b(this);
        this.sdk.J().c(this.adUnitId, this.f61481c);
        super.destroy();
    }

    public MaxAdFormat getAdFormat() {
        return this.adFormat;
    }

    public String getPlacement() {
        return this.f61485g;
    }

    public void loadAd() {
        loadAd(d.b.PUBLISHER_INITIATED);
    }

    @Override // com.applovin.impl.sdk.f.a
    public void onAdRefresh() {
        if (((Boolean) this.sdk.a(ue.X6)).booleanValue()) {
            f();
        } else {
            e();
        }
    }

    @Override // com.applovin.impl.v.b
    public void onCreativeIdGenerated(String str, String str2) {
        ge geVar = this.f61494p;
        if (geVar != null && geVar.R().equalsIgnoreCase(str)) {
            this.f61494p.h(str2);
            fc.b(this.adReviewListener, str2, this.f61494p);
            return;
        }
        ge geVar2 = this.f61484f;
        if (geVar2 == null || !geVar2.R().equalsIgnoreCase(str)) {
            return;
        }
        this.f61484f.h(str2);
    }

    @Override // com.applovin.impl.br.a
    public void onLogVisibilityImpression() {
        a(this.f61494p, this.f61490l.a(this.f61494p));
    }

    public void onWindowVisibilityChanged(int i3) {
        if (((Boolean) this.sdk.a(ue.U6)).booleanValue() && this.f61489k.h()) {
            if (zq.b(i3)) {
                if (com.applovin.impl.sdk.n.a()) {
                    this.logger.a(this.tag, "Ad view visible");
                }
                this.f61489k.d();
            } else {
                if (com.applovin.impl.sdk.n.a()) {
                    this.logger.a(this.tag, "Ad view hidden");
                }
                this.f61489k.c();
            }
        }
    }

    public void setCustomData(String str) {
        if (this.f61494p != null && com.applovin.impl.sdk.n.a()) {
            this.logger.k(this.tag, "Setting custom data (" + str + ") for Ad Unit ID (" + this.adUnitId + ") after an ad has been loaded already.");
        }
        yp.b(str, this.tag);
        this.f61486h = str;
    }

    @Override // com.applovin.impl.mediation.ads.a
    public void setExtraParameter(String str, String str2) {
        super.setExtraParameter(str, str2);
        a(str, str2);
    }

    public void setPlacement(String str) {
        if (this.f61494p != null && com.applovin.impl.sdk.n.a()) {
            this.logger.k(this.tag, "Setting placement (" + str + ") for Ad Unit ID (" + this.adUnitId + ") after an ad has been loaded already.");
        }
        this.f61485g = str;
    }

    public void setPublisherBackgroundColor(int i3) {
        this.f61483e = i3;
    }

    public void startAutoRefresh() {
        this.f61496r = false;
        if (!this.f61489k.g()) {
            if (com.applovin.impl.sdk.n.a()) {
                this.logger.a(this.tag, "Ignoring call to startAutoRefresh() - ad refresh is not paused");
                return;
            }
            return;
        }
        this.f61489k.m();
        if (com.applovin.impl.sdk.n.a()) {
            this.logger.a(this.tag, "Resumed auto-refresh with remaining time: " + this.f61489k.b() + "ms");
        }
    }

    public void stopAutoRefresh() {
        if (this.f61494p == null) {
            if (this.f61500v || ((Boolean) this.sdk.a(ue.W6)).booleanValue()) {
                this.f61496r = true;
                return;
            } else {
                com.applovin.impl.sdk.n.j(this.tag, "Stopping auto-refresh has no effect until after the first ad has been loaded.");
                return;
            }
        }
        if (com.applovin.impl.sdk.n.a()) {
            this.logger.a(this.tag, "Pausing auto-refresh with remaining time: " + this.f61489k.b() + "ms");
        }
        this.f61489k.j();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("MaxAdView{adUnitId='");
        sb.append(this.adUnitId);
        sb.append('\'');
        sb.append(", adListener=");
        Object obj = this.adListener;
        if (obj == this.f61480b) {
            obj = "this";
        }
        sb.append(obj);
        sb.append(", isDestroyed=");
        sb.append(a());
        sb.append('}');
        return sb.toString();
    }

    private void a(View view, ge geVar) {
        int iR0 = geVar.r0();
        int iP0 = geVar.p0();
        int iDpToPx = iR0 == -1 ? -1 : AppLovinSdkUtils.dpToPx(view.getContext(), iR0);
        int iDpToPx2 = iP0 != -1 ? AppLovinSdkUtils.dpToPx(view.getContext(), iP0) : -1;
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new RelativeLayout.LayoutParams(iDpToPx, iDpToPx2);
        } else {
            layoutParams.width = iDpToPx;
            layoutParams.height = iDpToPx2;
        }
        if (layoutParams instanceof RelativeLayout.LayoutParams) {
            if (com.applovin.impl.sdk.n.a()) {
                this.logger.a(this.tag, "Pinning ad view to MAX ad view with width: " + iDpToPx + " and height: " + iDpToPx2 + ".");
            }
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
            for (int i3 : zq.a(this.f61480b.getGravity(), 10, 14)) {
                layoutParams2.addRule(i3);
            }
        }
        view.setLayoutParams(layoutParams);
    }

    private void c(ge geVar) {
        int height = this.f61480b.getHeight();
        int width = this.f61480b.getWidth();
        if (height > 0 || width > 0) {
            int iPxToDp = AppLovinSdkUtils.pxToDp(this.f61479a, height);
            int iPxToDp2 = AppLovinSdkUtils.pxToDp(this.f61479a, width);
            MaxAdFormat format = geVar.getFormat();
            int height2 = (this.A ? format.getAdaptiveSize(iPxToDp2, this.f61480b.getContext()) : format.getSize()).getHeight();
            int iMin = Math.min(format.getSize().getWidth(), z3.b(this.f61479a).x);
            if (iPxToDp < height2 || iPxToDp2 < iMin) {
                StringBuilder sb = new StringBuilder();
                sb.append("\n**************************************************\n`MaxAdView` size ");
                sb.append(iPxToDp2);
                sb.append("x");
                sb.append(iPxToDp);
                sb.append(" dp smaller than required ");
                sb.append(this.A ? "adaptive " : "");
                sb.append("size: ");
                sb.append(iMin);
                sb.append("x");
                sb.append(height2);
                sb.append(" dp\nSome mediated networks (e.g. Google Ad Manager) may not render correctly\n**************************************************\n");
                String string = sb.toString();
                if (com.applovin.impl.sdk.n.a()) {
                    this.logger.b("AppLovinSdk", string);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(final ge geVar) {
        AppLovinSdkUtils.runOnUiThread(new Runnable() { // from class: com.applovin.impl.mediation.ads.e
            @Override // java.lang.Runnable
            public final void run() {
                this.f61563a.b(geVar);
            }
        });
    }

    private void e() {
        this.f61497s.set(false);
        if (this.f61484f != null) {
            h();
            return;
        }
        if (!b()) {
            if (com.applovin.impl.sdk.n.a()) {
                this.logger.a(this.tag, "Refreshing ad from network...");
            }
            loadAd(d.b.REFRESH);
        } else if (this.f61495q) {
            if (com.applovin.impl.sdk.n.a()) {
                this.logger.a(this.tag, "Refreshing ad from network due to viewability requirements not met for refresh request...");
            }
            loadAd(d.b.REFRESH);
        } else {
            if (com.applovin.impl.sdk.n.a()) {
                this.logger.b(this.tag, "Ignoring attempt to refresh ad - either still waiting for precache or did not attempt request due to visibility requirement not met");
            }
            this.f61497s.set(true);
        }
    }

    private void f() {
        boolean z2;
        boolean z3;
        synchronized (this.f61493o) {
            try {
                z2 = false;
                this.f61497s.set(false);
                z3 = this.f61484f != null;
                if (!z3) {
                    if (b()) {
                        if (!this.f61495q) {
                            if (com.applovin.impl.sdk.n.a()) {
                                this.logger.b(this.tag, "Ignoring attempt to refresh ad - either still waiting for precache or did not attempt request due to visibility requirement not met");
                            }
                            this.f61497s.set(true);
                        } else if (com.applovin.impl.sdk.n.a()) {
                            this.logger.a(this.tag, "Refreshing ad from network due to viewability requirements not met for refresh request...");
                        }
                    } else if (com.applovin.impl.sdk.n.a()) {
                        this.logger.a(this.tag, "Refreshing ad from network...");
                    }
                    z2 = true;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (z3) {
            h();
        } else if (z2) {
            loadAd(d.b.REFRESH);
        }
    }

    private void g() {
        ge geVar;
        MaxAdView maxAdView = this.f61480b;
        if (maxAdView != null) {
            e0.a(maxAdView, this.f61482d);
        }
        this.f61491m.b();
        synchronized (this.f61492n) {
            geVar = this.f61494p;
        }
        if (geVar != null) {
            this.sdk.P().destroyAd(geVar);
        }
    }

    private void h() {
        if (com.applovin.impl.sdk.n.a()) {
            this.logger.a(this.tag, "Rendering for cached ad: " + this.f61484f + "...");
        }
        this.f61487i.onAdLoaded(this.f61484f);
        this.f61484f = null;
    }

    public void loadAd(d.b bVar) {
        if (com.applovin.impl.sdk.n.a()) {
            this.logger.a(this.tag, "" + this + " Loading ad for " + this.adUnitId + "...");
        }
        boolean z2 = this.f61500v || ((Boolean) this.sdk.a(ue.W6)).booleanValue();
        if (z2 && !this.f61489k.g() && this.f61489k.h()) {
            com.applovin.impl.sdk.n.h(this.tag, "Unable to load a new ad. An ad refresh has already been scheduled in " + TimeUnit.MILLISECONDS.toSeconds(this.f61489k.b()) + " seconds.");
            return;
        }
        if (!z2) {
            if (com.applovin.impl.sdk.n.a()) {
                this.logger.a(this.tag, "Loading ad...");
            }
            a(bVar, this.f61487i);
        } else if (this.f61484f != null) {
            if (com.applovin.impl.sdk.n.a()) {
                this.logger.a(this.tag, "Rendering cached ad");
            }
            h();
        } else if (this.f61498t) {
            if (com.applovin.impl.sdk.n.a()) {
                this.logger.a(this.tag, "Waiting for precache ad to load to render");
            }
            this.f61497s.set(true);
        } else {
            if (com.applovin.impl.sdk.n.a()) {
                this.logger.a(this.tag, "Loading ad...");
            }
            a(bVar, this.f61487i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(final ge geVar) {
        View viewY = geVar.y();
        String str = viewY == null ? "MaxAdView does not have a loaded ad view" : null;
        MaxAdView maxAdView = this.f61480b;
        if (maxAdView == null) {
            str = "MaxAdView does not have a parent view";
        }
        if (str != null) {
            if (com.applovin.impl.sdk.n.a()) {
                this.logger.b(this.tag, str);
            }
            MaxErrorImpl maxErrorImpl = new MaxErrorImpl(-1, str);
            if (com.applovin.impl.sdk.n.a()) {
                this.logger.a(this.tag, "MaxAdListener.onAdDisplayFailed(ad=" + geVar + ", error=" + maxErrorImpl + "), listener=" + this.adListener);
            }
            fc.a(this.adListener, (MaxAd) geVar, (MaxError) maxErrorImpl, true);
            this.sdk.P().processAdDisplayErrorPostbackForUserError(maxErrorImpl, geVar);
            return;
        }
        g();
        a((fe) geVar);
        if (geVar.m0()) {
            this.f61491m.a(geVar);
        }
        maxAdView.setDescendantFocusability(393216);
        if (geVar.o0() != Long.MAX_VALUE) {
            this.f61482d.setBackgroundColor((int) geVar.o0());
        } else {
            long j3 = this.f61483e;
            if (j3 != Long.MAX_VALUE) {
                this.f61482d.setBackgroundColor((int) j3);
            } else {
                this.f61482d.setBackgroundColor(0);
            }
        }
        maxAdView.addView(viewY);
        a(viewY, geVar);
        this.sdk.v().d(geVar);
        c(geVar);
        synchronized (this.f61492n) {
            this.f61494p = geVar;
        }
        if (com.applovin.impl.sdk.n.a()) {
            this.logger.a(this.tag, "Scheduling impression for ad manually...");
        }
        this.sdk.P().processRawAdImpression(geVar, this.f61487i);
        if (StringUtils.isValidString(this.f61494p.getAdReviewCreativeId())) {
            fc.a(this.adReviewListener, this.f61494p.getAdReviewCreativeId(), (MaxAd) this.f61494p, true);
        }
        AppLovinSdkUtils.runOnUiThreadDelayed(new Runnable() { // from class: com.applovin.impl.mediation.ads.c
            @Override // java.lang.Runnable
            public final void run() {
                this.f61558a.a(geVar);
            }
        }, geVar.q0());
    }

    private void d() {
        if (b()) {
            if (com.applovin.impl.sdk.n.a()) {
                this.logger.a(this.tag, "Scheduling refresh precache request now");
            }
            this.f61498t = true;
            this.sdk.i0().a((yl) new jn(this.sdk, "loadMaxAdForPrecacheRequest", new Runnable() { // from class: com.applovin.impl.mediation.ads.f
                @Override // java.lang.Runnable
                public final void run() {
                    this.f61565a.c();
                }
            }), tm.b.MEDIATION);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c() {
        if (com.applovin.impl.sdk.n.a()) {
            this.logger.a(this.tag, "Loading ad for precache request...");
        }
        a(d.b.SEQUENTIAL_OR_PRECACHE, this.f61488j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(ge geVar) {
        long jA = this.f61490l.a(geVar);
        if (!geVar.m0()) {
            a(geVar, jA);
        }
        a(jA);
    }

    private void a(final d.b bVar, final a.InterfaceC0110a interfaceC0110a) {
        if (a()) {
            boolean zC = yp.c(this.sdk);
            this.sdk.D().a(ka.V, "attemptingToLoadDestroyedAdView", (Map) CollectionUtils.hashMap("details", "debug=" + zC));
            if (!zC) {
                com.applovin.impl.sdk.n.h(this.tag, "Failed to load new ad - this instance is already destroyed");
                return;
            }
            throw new IllegalStateException("Failed to load new ad - this instance is already destroyed for ad unit ID: " + this.adUnitId);
        }
        AppLovinSdkUtils.runOnUiThread(true, new Runnable() { // from class: com.applovin.impl.mediation.ads.d
            @Override // java.lang.Runnable
            public final void run() {
                this.f61560a.a(interfaceC0110a, bVar);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(a.InterfaceC0110a interfaceC0110a, d.b bVar) {
        ge geVar = this.f61494p;
        if (geVar != null) {
            long jA = this.f61490l.a(geVar);
            this.extraParameters.put("visible_ad_ad_unit_id", this.f61494p.getAdUnitId());
            this.extraParameters.put("viewability_flags", Long.valueOf(jA));
        } else {
            this.extraParameters.remove("visible_ad_ad_unit_id");
            this.extraParameters.remove("viewability_flags");
        }
        int iPxToDp = AppLovinSdkUtils.pxToDp(this.f61480b.getContext(), this.f61480b.getWidth());
        int iPxToDp2 = AppLovinSdkUtils.pxToDp(this.f61480b.getContext(), this.f61480b.getHeight());
        this.extraParameters.put("viewport_width", Integer.valueOf(iPxToDp));
        this.extraParameters.put("viewport_height", Integer.valueOf(iPxToDp2));
        this.extraParameters.put("auto_refresh_stopped", Boolean.valueOf(this.f61489k.g() || this.f61496r));
        this.extraParameters.put("auto_retries_disabled", Boolean.valueOf(this.f61501w));
        if (com.applovin.impl.sdk.n.a()) {
            this.logger.a(this.tag, "Loading " + this.adFormat.getLabel().toLowerCase(Locale.ENGLISH) + " ad for '" + this.adUnitId + "' and notifying " + interfaceC0110a + "...");
        }
        this.sdk.P().loadAd(this.adUnitId, this.f61481c, this.adFormat, bVar, this.localExtraParameters, this.extraParameters, this.f61479a, interfaceC0110a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(MaxAd maxAd) {
        boolean zCompareAndSet;
        this.f61498t = false;
        synchronized (this.f61493o) {
            try {
                zCompareAndSet = this.f61497s.compareAndSet(true, false);
                if (!zCompareAndSet) {
                    if (com.applovin.impl.sdk.n.a()) {
                        this.logger.a(this.tag, "Saving precache ad...");
                    }
                    ge geVar = (ge) maxAd;
                    this.f61484f = geVar;
                    geVar.g(this.f61485g);
                    this.f61484f.f(this.f61486h);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (zCompareAndSet) {
            if (com.applovin.impl.sdk.n.a()) {
                this.logger.a(this.tag, "Rendering precache request ad: " + maxAd.getAdUnitId() + "...");
            }
            this.f61487i.onAdLoaded(maxAd);
        }
    }

    private void a(String str, String str2) {
        if ("allow_pause_auto_refresh_immediately".equalsIgnoreCase(str)) {
            if (com.applovin.impl.sdk.n.a()) {
                this.logger.a(this.tag, "Updated allow immediate auto-refresh pause and ad load to: " + str2);
            }
            this.f61500v = Boolean.parseBoolean(str2);
            return;
        }
        if ("disable_auto_retries".equalsIgnoreCase(str)) {
            if (com.applovin.impl.sdk.n.a()) {
                this.logger.a(this.tag, "Updated disable auto-retries to: " + str2);
            }
            this.f61501w = Boolean.parseBoolean(str2);
            return;
        }
        if ("disable_precache".equalsIgnoreCase(str)) {
            if (com.applovin.impl.sdk.n.a()) {
                this.logger.a(this.tag, "Updated precached disabled to: " + str2);
            }
            this.f61502x = Boolean.parseBoolean(str2);
            return;
        }
        if ("should_stop_auto_refresh_on_ad_expand".equals(str)) {
            if (com.applovin.impl.sdk.n.a()) {
                this.logger.a(this.tag, "Updated should stop auto-refresh on ad expand to: " + str2);
            }
            this.f61503y = Boolean.parseBoolean(str2);
            return;
        }
        if ("force_precache".equals(str)) {
            if (com.applovin.impl.sdk.n.a()) {
                this.logger.a(this.tag, "Updated force precache to: " + str2);
            }
            this.f61504z = Boolean.parseBoolean(str2);
            return;
        }
        if ("adaptive_banner".equalsIgnoreCase(str)) {
            if (com.applovin.impl.sdk.n.a()) {
                this.logger.a(this.tag, "Updated is adaptive banner to: " + str2);
            }
            this.A = Boolean.parseBoolean(str2);
            setLocalExtraParameter(str, str2);
        }
    }

    private boolean b() {
        if (this.f61502x) {
            return false;
        }
        return ((Boolean) this.sdk.a(ue.c7)).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(MaxError maxError) {
        if (a()) {
            if (com.applovin.impl.sdk.n.a()) {
                this.logger.a(this.tag, "Ad load failure with ad unit ID '" + this.adUnitId + "' occured after MaxAdView was destroyed.");
                return;
            }
            return;
        }
        if (this.sdk.c(ue.Q6).contains(String.valueOf(maxError.getCode()))) {
            this.sdk.I();
            if (com.applovin.impl.sdk.n.a()) {
                this.sdk.I().a(this.tag, "Ignoring banner ad refresh for error code " + maxError.getCode());
                return;
            }
            return;
        }
        if (!this.f61496r && !this.f61489k.g()) {
            this.f61495q = true;
            this.f61498t = false;
            long jLongValue = ((Long) this.sdk.a(ue.P6)).longValue();
            if (jLongValue >= 0) {
                this.sdk.I();
                if (com.applovin.impl.sdk.n.a()) {
                    this.sdk.I().a(this.tag, "Scheduling failed banner ad refresh " + jLongValue + " milliseconds from now for '" + this.adUnitId + "'...");
                }
                this.f61489k.a(jLongValue);
                return;
            }
            return;
        }
        if (this.f61498t) {
            if (com.applovin.impl.sdk.n.a()) {
                this.logger.a(this.tag, "Refresh precache failed when auto-refresh is stopped");
            }
            this.f61498t = false;
        }
        if (this.f61497s.get()) {
            if (com.applovin.impl.sdk.n.a()) {
                this.logger.a(this.tag, "Refresh precache failed - MaxAdListener.onAdLoadFailed(adUnitId=" + this.adUnitId + ", error=" + maxError + "), listener=" + this.adListener);
            }
            fc.a(this.adListener, this.adUnitId, maxError, true);
        }
    }

    private void a(ge geVar, long j3) {
        if (com.applovin.impl.sdk.n.a()) {
            this.logger.a(this.tag, "Scheduling viewability impression for ad...");
        }
        this.sdk.P().processViewabilityAdImpressionPostback(geVar, j3, this.f61487i);
    }

    private void a(long j3) {
        if (yp.a(j3, ((Long) this.sdk.a(ue.b7)).longValue()) && !this.f61504z) {
            if (com.applovin.impl.sdk.n.a()) {
                this.logger.a(this.tag, "Undesired flags matched - current: " + Long.toBinaryString(j3) + ", undesired: " + Long.toBinaryString(j3));
            }
            if (com.applovin.impl.sdk.n.a()) {
                this.logger.a(this.tag, "Waiting for refresh timer to manually fire request");
            }
            this.f61495q = true;
            return;
        }
        if (com.applovin.impl.sdk.n.a()) {
            this.logger.a(this.tag, "No undesired viewability flags matched or forcing precache - scheduling viewability");
        }
        this.f61495q = false;
        d();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(MaxAd maxAd) {
        this.f61498t = false;
        if (this.f61497s.compareAndSet(true, false)) {
            if (com.applovin.impl.sdk.n.a()) {
                this.logger.a(this.tag, "Rendering precache request ad: " + maxAd.getAdUnitId() + "...");
            }
            this.f61487i.onAdLoaded(maxAd);
            return;
        }
        if (com.applovin.impl.sdk.n.a()) {
            this.logger.a(this.tag, "Saving precache ad...");
        }
        ge geVar = (ge) maxAd;
        this.f61484f = geVar;
        geVar.g(this.f61485g);
        this.f61484f.f(this.f61486h);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a() {
        boolean z2;
        synchronized (this.f61492n) {
            z2 = this.f61499u;
        }
        return z2;
    }
}
