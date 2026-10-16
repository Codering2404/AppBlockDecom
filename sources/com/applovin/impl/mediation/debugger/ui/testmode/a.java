package com.applovin.impl.mediation.debugger.ui.testmode;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.Switch;
import android.widget.TextView;
import com.amazon.device.ads.AdError;
import com.amazon.device.ads.AdRegistration;
import com.amazon.device.ads.DTBAdResponse;
import com.applovin.impl.je;
import com.applovin.impl.mediation.debugger.ui.testmode.AdControlButton;
import com.applovin.impl.o0;
import com.applovin.impl.p0;
import com.applovin.impl.re;
import com.applovin.impl.sdk.j;
import com.applovin.impl.sdk.n;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.impl.yp;
import com.applovin.mediation.MaxAd;
import com.applovin.mediation.MaxAdFormat;
import com.applovin.mediation.MaxAdRevenueListener;
import com.applovin.mediation.MaxAdViewAdListener;
import com.applovin.mediation.MaxError;
import com.applovin.mediation.MaxReward;
import com.applovin.mediation.MaxRewardedAdListener;
import com.applovin.mediation.ads.MaxAdView;
import com.applovin.mediation.ads.MaxAppOpenAd;
import com.applovin.mediation.ads.MaxInterstitialAd;
import com.applovin.mediation.ads.MaxRewardedAd;
import com.applovin.mediation.ads.MaxRewardedInterstitialAd;
import com.applovin.mediation.nativeAds.MaxNativeAdListener;
import com.applovin.mediation.nativeAds.MaxNativeAdLoader;
import com.applovin.mediation.nativeAds.MaxNativeAdView;
import com.applovin.sdk.AppLovinSdkUtils;
import com.applovin.sdk.R;
import com.facebook.internal.ServerProtocol;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class a extends re implements MaxRewardedAdListener, MaxAdViewAdListener, AdControlButton.a, MaxAdRevenueListener, o0.a {
    private Map A;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private je f61675a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private j f61676b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private MaxAdView f61677c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private MaxAdView f61678d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private MaxInterstitialAd f61679f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private MaxAppOpenAd f61680g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private MaxRewardedInterstitialAd f61681h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private MaxRewardedAd f61682i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private MaxAd f61683j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private MaxNativeAdLoader f61684k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private List f61685l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private String f61686m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private AdControlButton f61687n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private AdControlButton f61688o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private AdControlButton f61689p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private AdControlButton f61690q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private AdControlButton f61691r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private AdControlButton f61692s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private AdControlButton f61693t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private Button f61694u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private Button f61695v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private FrameLayout f61696w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private FrameLayout f61697x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private Switch f61698y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private Switch f61699z;

    /* JADX INFO: renamed from: com.applovin.impl.mediation.debugger.ui.testmode.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class C0112a extends MaxNativeAdListener {
        C0112a() {
        }

        @Override // com.applovin.mediation.nativeAds.MaxNativeAdListener
        public void onNativeAdClicked(MaxAd maxAd) {
            a.this.onAdClicked(maxAd);
        }

        @Override // com.applovin.mediation.nativeAds.MaxNativeAdListener
        public void onNativeAdLoadFailed(String str, MaxError maxError) {
            a.this.onAdLoadFailed(str, maxError);
        }

        @Override // com.applovin.mediation.nativeAds.MaxNativeAdListener
        public void onNativeAdLoaded(MaxNativeAdView maxNativeAdView, MaxAd maxAd) {
            if (a.this.f61683j != null) {
                a.this.f61684k.destroy(a.this.f61683j);
            }
            a.this.f61683j = maxAd;
            a.this.f61697x.removeAllViews();
            a.this.f61697x.addView(maxNativeAdView);
            a.this.onAdLoaded(maxAd);
        }
    }

    private void e() {
        List listR = this.f61675a.r();
        MaxAdFormat maxAdFormat = MaxAdFormat.REWARDED;
        if (!listR.contains(maxAdFormat)) {
            findViewById(R.id.rewarded_control_view).setVisibility(8);
            return;
        }
        String str = "test_mode_rewarded_" + this.f61675a.m();
        this.f61686m = str;
        MaxRewardedAd maxRewardedAd = MaxRewardedAd.getInstance(str, this.f61676b.q0(), this);
        this.f61682i = maxRewardedAd;
        maxRewardedAd.setExtraParameter("disable_auto_retries", ServerProtocol.DIALOG_RETURN_SCOPES_TRUE);
        this.f61682i.setListener(this);
        AdControlButton adControlButton = (AdControlButton) findViewById(R.id.rewarded_control_button);
        this.f61692s = adControlButton;
        adControlButton.setOnClickListener(this);
        this.f61692s.setFormat(maxAdFormat);
    }

    @Override // com.applovin.impl.re
    protected j getSdk() {
        return this.f61676b;
    }

    public String getTestModeNetwork(MaxAdFormat maxAdFormat) {
        return (this.f61675a.x() == null || !this.f61675a.x().containsKey(maxAdFormat)) ? this.f61675a.m() : (String) this.f61675a.x().get(maxAdFormat);
    }

    public void initialize(je jeVar) {
        this.f61675a = jeVar;
        this.f61676b = jeVar.o();
    }

    @Override // com.applovin.mediation.MaxAdListener
    public void onAdClicked(MaxAd maxAd) {
        yp.a("onAdClicked", maxAd, this);
    }

    @Override // com.applovin.mediation.MaxAdViewAdListener
    public void onAdCollapsed(MaxAd maxAd) {
        yp.a("onAdCollapsed", maxAd, this);
    }

    @Override // com.applovin.mediation.MaxAdListener
    public void onAdDisplayFailed(MaxAd maxAd, MaxError maxError) {
        a(maxAd.getAdUnitId()).setControlState(AdControlButton.b.LOAD);
        yp.a("Failed to display " + maxAd.getFormat().getDisplayName(), "MAX Error\nCode: " + maxError.getCode() + "\nMessage: " + maxError.getMessage() + "\n\n" + maxAd.getNetworkName() + " Display Error\nCode: " + maxError.getMediatedNetworkErrorCode() + "\nMessage: " + maxError.getMediatedNetworkErrorMessage(), this);
    }

    @Override // com.applovin.mediation.MaxAdListener
    public void onAdDisplayed(MaxAd maxAd) {
        yp.a("onAdDisplayed", maxAd, this);
    }

    @Override // com.applovin.mediation.MaxAdViewAdListener
    public void onAdExpanded(MaxAd maxAd) {
        yp.a("onAdExpanded", maxAd, this);
    }

    @Override // com.applovin.mediation.MaxAdListener
    public void onAdHidden(MaxAd maxAd) {
        yp.a("onAdHidden", maxAd, this);
    }

    @Override // com.applovin.mediation.MaxAdListener
    public void onAdLoadFailed(String str, MaxError maxError) {
        AdControlButton adControlButtonA = a(str);
        adControlButtonA.setControlState(AdControlButton.b.LOAD);
        yp.a(maxError, adControlButtonA.getFormat().getLabel(), this);
    }

    @Override // com.applovin.mediation.MaxAdListener
    public void onAdLoaded(MaxAd maxAd) {
        AdControlButton adControlButtonA = a(maxAd.getAdUnitId());
        if (maxAd.getFormat().isAdViewAd() || maxAd.getFormat().equals(MaxAdFormat.NATIVE)) {
            adControlButtonA.setControlState(AdControlButton.b.LOAD);
        } else {
            adControlButtonA.setControlState(AdControlButton.b.SHOW);
        }
    }

    @Override // com.applovin.impl.o0.a
    public void onAdResponseLoaded(DTBAdResponse dTBAdResponse, MaxAdFormat maxAdFormat) {
        if (MaxAdFormat.BANNER == maxAdFormat || MaxAdFormat.LEADER == maxAdFormat) {
            this.f61677c.setLocalExtraParameter("amazon_ad_response", dTBAdResponse);
        } else if (MaxAdFormat.MREC == maxAdFormat) {
            this.f61678d.setLocalExtraParameter("amazon_ad_response", dTBAdResponse);
        } else if (MaxAdFormat.INTERSTITIAL == maxAdFormat) {
            this.f61679f.setLocalExtraParameter("amazon_ad_response", dTBAdResponse);
        } else if (MaxAdFormat.APP_OPEN == maxAdFormat) {
            this.f61680g.setLocalExtraParameter("amazon_ad_response", dTBAdResponse);
        } else if (MaxAdFormat.REWARDED_INTERSTITIAL == maxAdFormat) {
            this.f61681h.setLocalExtraParameter("amazon_ad_response", dTBAdResponse);
        } else if (MaxAdFormat.REWARDED == maxAdFormat) {
            this.f61682i.setLocalExtraParameter("amazon_ad_response", dTBAdResponse);
        } else if (MaxAdFormat.NATIVE == maxAdFormat) {
            this.f61684k.setLocalExtraParameter("amazon_ad_response", dTBAdResponse);
        }
        a(maxAdFormat);
    }

    @Override // com.applovin.mediation.MaxAdRevenueListener
    public void onAdRevenuePaid(MaxAd maxAd) {
        yp.a("onAdRevenuePaid", maxAd, this);
    }

    @Override // com.applovin.impl.mediation.debugger.ui.testmode.AdControlButton.a
    public void onClick(AdControlButton adControlButton) {
        MaxAdFormat format = adControlButton.getFormat();
        AdControlButton.b bVar = AdControlButton.b.LOAD;
        if (bVar != adControlButton.getControlState()) {
            if (AdControlButton.b.SHOW == adControlButton.getControlState()) {
                adControlButton.setControlState(bVar);
                b(format);
                return;
            }
            return;
        }
        adControlButton.setControlState(AdControlButton.b.LOADING);
        Map map = this.A;
        if (map == null || map.get(format) == null) {
            a(format);
        } else {
            ((o0) this.A.get(format)).a();
        }
    }

    @Override // com.applovin.impl.re, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (this.f61675a == null) {
            n.h("MaxDebuggerMultiAdActivity", "Failed to initialize activity with a network model.");
            return;
        }
        setContentView(R.layout.mediation_debugger_multi_ad_activity);
        setTitle(this.f61675a.g() + " Test Ads");
        this.f61685l = this.f61676b.k0().b();
        a();
        c();
        b();
        e();
        d();
        findViewById(R.id.rewarded_interstitial_control_view).setVisibility(8);
        findViewById(R.id.app_open_ad_control_view).setVisibility(8);
        this.f61694u = (Button) findViewById(R.id.show_mrec_button);
        this.f61695v = (Button) findViewById(R.id.show_native_button);
        if (this.f61675a.H() && this.f61675a.r().contains(MaxAdFormat.MREC)) {
            this.f61697x.setVisibility(8);
            this.f61694u.setBackgroundColor(-1);
            this.f61695v.setBackgroundColor(-3355444);
            this.f61694u.setOnClickListener(new View.OnClickListener() { // from class: com.applovin.impl.mediation.debugger.ui.testmode.b
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f61701a.a(view);
                }
            });
            this.f61695v.setOnClickListener(new View.OnClickListener() { // from class: com.applovin.impl.mediation.debugger.ui.testmode.c
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f61702a.b(view);
                }
            });
        } else {
            this.f61694u.setVisibility(8);
            this.f61695v.setVisibility(8);
        }
        this.f61698y = (Switch) findViewById(R.id.native_banner_switch);
        this.f61699z = (Switch) findViewById(R.id.native_mrec_switch);
        if (this.f61675a.I()) {
            this.f61698y.setOnClickListener(new View.OnClickListener() { // from class: com.applovin.impl.mediation.debugger.ui.testmode.d
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f61703a.c(view);
                }
            });
            this.f61699z.setOnClickListener(new View.OnClickListener() { // from class: com.applovin.impl.mediation.debugger.ui.testmode.e
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f61704a.d(view);
                }
            });
        } else {
            this.f61698y.setVisibility(8);
            this.f61699z.setVisibility(8);
        }
        if (StringUtils.isValidString(this.f61675a.e()) && this.f61675a.d() != null && this.f61675a.d().size() > 0) {
            AdRegistration.getInstance(this.f61675a.e(), this);
            AdRegistration.enableTesting(true);
            AdRegistration.enableLogging(true);
            HashMap map = new HashMap(this.f61675a.d().size());
            for (MaxAdFormat maxAdFormat : this.f61675a.d().keySet()) {
                map.put(maxAdFormat, new o0((p0) this.f61675a.d().get(maxAdFormat), maxAdFormat, this));
            }
            this.A = map;
        }
        try {
            setRequestedOrientation(7);
        } catch (Throwable th) {
            n.c("AppLovinSdk", "Failed to set portrait orientation", th);
        }
    }

    @Override // com.applovin.impl.re, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        this.f61676b.k0().a(this.f61685l);
        MaxAdView maxAdView = this.f61677c;
        if (maxAdView != null) {
            maxAdView.destroy();
        }
        MaxAdView maxAdView2 = this.f61678d;
        if (maxAdView2 != null) {
            maxAdView2.destroy();
        }
        MaxInterstitialAd maxInterstitialAd = this.f61679f;
        if (maxInterstitialAd != null) {
            maxInterstitialAd.destroy();
        }
        MaxRewardedAd maxRewardedAd = this.f61682i;
        if (maxRewardedAd != null) {
            maxRewardedAd.destroy();
        }
        MaxNativeAdLoader maxNativeAdLoader = this.f61684k;
        if (maxNativeAdLoader != null) {
            MaxAd maxAd = this.f61683j;
            if (maxAd != null) {
                maxNativeAdLoader.destroy(maxAd);
            }
            this.f61684k.destroy();
        }
    }

    @Override // com.applovin.mediation.MaxRewardedAdListener
    public void onUserRewarded(MaxAd maxAd, MaxReward maxReward) {
        yp.a("onUserRewarded", maxAd, this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void d(View view) {
        this.f61678d.removeAllViews();
        this.f61688o.setControlState(AdControlButton.b.LOAD);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(View view) {
        this.f61697x.setVisibility(0);
        this.f61696w.setVisibility(8);
        this.f61695v.setBackgroundColor(-1);
        this.f61694u.setBackgroundColor(-3355444);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c(View view) {
        this.f61677c.removeAllViews();
        this.f61687n.setControlState(AdControlButton.b.LOAD);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(View view) {
        this.f61696w.setVisibility(0);
        this.f61697x.setVisibility(8);
        this.f61694u.setBackgroundColor(-1);
        this.f61695v.setBackgroundColor(-3355444);
    }

    private void d() {
        this.f61697x = (FrameLayout) findViewById(R.id.native_ad_view_container);
        if (this.f61675a.H()) {
            MaxNativeAdLoader maxNativeAdLoader = new MaxNativeAdLoader("test_mode_native", this.f61676b.q0(), this);
            this.f61684k = maxNativeAdLoader;
            maxNativeAdLoader.setExtraParameter("disable_auto_retries", ServerProtocol.DIALOG_RETURN_SCOPES_TRUE);
            this.f61684k.setNativeAdListener(new C0112a());
            this.f61684k.setRevenueListener(this);
            AdControlButton adControlButton = (AdControlButton) findViewById(R.id.native_control_button);
            this.f61693t = adControlButton;
            adControlButton.setOnClickListener(this);
            this.f61693t.setFormat(MaxAdFormat.NATIVE);
            return;
        }
        findViewById(R.id.native_control_view).setVisibility(8);
        this.f61697x.setVisibility(8);
    }

    @Override // com.applovin.impl.o0.a
    public void onAdLoadFailed(AdError adError, MaxAdFormat maxAdFormat) {
        if (MaxAdFormat.BANNER != maxAdFormat && MaxAdFormat.LEADER != maxAdFormat) {
            if (MaxAdFormat.MREC == maxAdFormat) {
                this.f61678d.setLocalExtraParameter("amazon_ad_error", adError);
            } else if (MaxAdFormat.INTERSTITIAL == maxAdFormat) {
                this.f61679f.setLocalExtraParameter("amazon_ad_error", adError);
            } else if (MaxAdFormat.APP_OPEN == maxAdFormat) {
                this.f61680g.setLocalExtraParameter("amazon_ad_error", adError);
            } else if (MaxAdFormat.REWARDED_INTERSTITIAL == maxAdFormat) {
                this.f61681h.setLocalExtraParameter("amazon_ad_error", adError);
            } else if (MaxAdFormat.REWARDED == maxAdFormat) {
                this.f61682i.setLocalExtraParameter("amazon_ad_error", adError);
            } else if (MaxAdFormat.NATIVE == maxAdFormat) {
                this.f61684k.setLocalExtraParameter("amazon_ad_error", adError);
            }
        } else {
            this.f61677c.setLocalExtraParameter("amazon_ad_error", adError);
        }
        a(maxAdFormat);
    }

    private void c() {
        this.f61696w = (FrameLayout) findViewById(R.id.mrec_ad_view_container);
        List listR = this.f61675a.r();
        MaxAdFormat maxAdFormat = MaxAdFormat.MREC;
        if (listR.contains(maxAdFormat)) {
            MaxAdView maxAdView = new MaxAdView("test_mode_mrec", maxAdFormat, this.f61676b.q0(), this);
            this.f61678d = maxAdView;
            maxAdView.setExtraParameter("disable_auto_retries", ServerProtocol.DIALOG_RETURN_SCOPES_TRUE);
            this.f61678d.setExtraParameter("disable_precache", ServerProtocol.DIALOG_RETURN_SCOPES_TRUE);
            this.f61678d.setExtraParameter("allow_pause_auto_refresh_immediately", ServerProtocol.DIALOG_RETURN_SCOPES_TRUE);
            this.f61678d.stopAutoRefresh();
            this.f61678d.setListener(this);
            this.f61696w.addView(this.f61678d, new FrameLayout.LayoutParams(-1, -1));
            AdControlButton adControlButton = (AdControlButton) findViewById(R.id.mrec_control_button);
            this.f61688o = adControlButton;
            adControlButton.setOnClickListener(this);
            this.f61688o.setFormat(maxAdFormat);
            return;
        }
        findViewById(R.id.mrec_control_view).setVisibility(8);
        this.f61696w.setVisibility(8);
    }

    private void b() {
        List listR = this.f61675a.r();
        MaxAdFormat maxAdFormat = MaxAdFormat.INTERSTITIAL;
        if (listR.contains(maxAdFormat)) {
            MaxInterstitialAd maxInterstitialAd = new MaxInterstitialAd("test_mode_interstitial", this.f61676b.q0(), this);
            this.f61679f = maxInterstitialAd;
            maxInterstitialAd.setExtraParameter("disable_auto_retries", ServerProtocol.DIALOG_RETURN_SCOPES_TRUE);
            this.f61679f.setListener(this);
            AdControlButton adControlButton = (AdControlButton) findViewById(R.id.interstitial_control_button);
            this.f61689p = adControlButton;
            adControlButton.setOnClickListener(this);
            this.f61689p.setFormat(maxAdFormat);
            return;
        }
        findViewById(R.id.interstitial_control_view).setVisibility(8);
    }

    private void a() {
        MaxAdFormat maxAdFormat;
        String str;
        boolean zIsTablet = AppLovinSdkUtils.isTablet(this);
        FrameLayout frameLayout = (FrameLayout) findViewById(R.id.banner_ad_view_container);
        if (zIsTablet) {
            maxAdFormat = MaxAdFormat.LEADER;
            ((TextView) findViewById(R.id.banner_label)).setText("Leader");
            str = "test_mode_leader";
        } else {
            maxAdFormat = MaxAdFormat.BANNER;
            str = "test_mode_banner";
        }
        if (this.f61675a.r().contains(maxAdFormat)) {
            MaxAdView maxAdView = new MaxAdView(str, maxAdFormat, this.f61676b.q0(), this);
            this.f61677c = maxAdView;
            maxAdView.setExtraParameter("adaptive_banner", "false");
            this.f61677c.setExtraParameter("disable_auto_retries", ServerProtocol.DIALOG_RETURN_SCOPES_TRUE);
            this.f61677c.setExtraParameter("disable_precache", ServerProtocol.DIALOG_RETURN_SCOPES_TRUE);
            this.f61677c.setExtraParameter("allow_pause_auto_refresh_immediately", ServerProtocol.DIALOG_RETURN_SCOPES_TRUE);
            this.f61677c.stopAutoRefresh();
            this.f61677c.setListener(this);
            frameLayout.addView(this.f61677c, new FrameLayout.LayoutParams(AppLovinSdkUtils.dpToPx(this, maxAdFormat.getSize().getWidth()), AppLovinSdkUtils.dpToPx(this, maxAdFormat.getSize().getHeight())));
            AdControlButton adControlButton = (AdControlButton) findViewById(R.id.banner_control_button);
            this.f61687n = adControlButton;
            adControlButton.setOnClickListener(this);
            this.f61687n.setFormat(maxAdFormat);
            return;
        }
        findViewById(R.id.banner_control_view).setVisibility(8);
        frameLayout.setVisibility(8);
    }

    private void b(MaxAdFormat maxAdFormat) {
        if (MaxAdFormat.INTERSTITIAL == maxAdFormat) {
            this.f61679f.showAd();
            return;
        }
        if (MaxAdFormat.APP_OPEN == maxAdFormat) {
            this.f61680g.showAd();
        } else if (MaxAdFormat.REWARDED_INTERSTITIAL == maxAdFormat) {
            this.f61681h.showAd();
        } else if (MaxAdFormat.REWARDED == maxAdFormat) {
            this.f61682i.showAd();
        }
    }

    private void a(MaxAdFormat maxAdFormat) {
        MaxAdFormat maxAdFormat2 = MaxAdFormat.BANNER;
        boolean z2 = false;
        boolean z3 = (maxAdFormat2 == maxAdFormat || MaxAdFormat.LEADER == maxAdFormat) && this.f61698y.isChecked();
        MaxAdFormat maxAdFormat3 = MaxAdFormat.MREC;
        if (maxAdFormat3 == maxAdFormat && this.f61699z.isChecked()) {
            z2 = true;
        }
        if (!z3 && !z2) {
            this.f61676b.k0().a(getTestModeNetwork(maxAdFormat));
        } else {
            this.f61676b.k0().a(this.f61675a.w());
        }
        if (maxAdFormat2 == maxAdFormat || MaxAdFormat.LEADER == maxAdFormat) {
            this.f61677c.loadAd();
            return;
        }
        if (maxAdFormat3 == maxAdFormat) {
            this.f61678d.loadAd();
            this.f61694u.callOnClick();
            return;
        }
        if (MaxAdFormat.INTERSTITIAL == maxAdFormat) {
            this.f61679f.loadAd();
            return;
        }
        if (MaxAdFormat.APP_OPEN == maxAdFormat) {
            this.f61680g.loadAd();
            return;
        }
        if (MaxAdFormat.REWARDED_INTERSTITIAL == maxAdFormat) {
            this.f61681h.loadAd();
            return;
        }
        if (MaxAdFormat.REWARDED == maxAdFormat) {
            this.f61682i.loadAd();
        } else if (MaxAdFormat.NATIVE == maxAdFormat) {
            this.f61684k.loadAd();
            this.f61695v.callOnClick();
        }
    }

    private AdControlButton a(String str) {
        if (!str.equals("test_mode_banner") && !str.equals("test_mode_leader")) {
            if (str.equals("test_mode_mrec")) {
                return this.f61688o;
            }
            if (str.equals("test_mode_interstitial")) {
                return this.f61689p;
            }
            if (str.equals("test_mode_app_open")) {
                return this.f61690q;
            }
            if (str.equals("test_mode_rewarded_interstitial")) {
                return this.f61691r;
            }
            if (str.equals(this.f61686m)) {
                return this.f61692s;
            }
            if (str.equals("test_mode_native")) {
                return this.f61693t;
            }
            throw new IllegalArgumentException("Invalid test mode ad unit identifier provided " + str);
        }
        return this.f61687n;
    }
}
