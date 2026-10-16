package com.applovin.impl;

import android.app.Activity;
import android.content.DialogInterface;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RectShape;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.amazon.device.ads.AdError;
import com.amazon.device.ads.DTBAdResponse;
import com.applovin.impl.dc;
import com.applovin.impl.mediation.debugger.ui.testmode.AdControlButton;
import com.applovin.impl.o0;
import com.applovin.impl.r;
import com.applovin.impl.y;
import com.applovin.mediation.MaxAd;
import com.applovin.mediation.MaxAdFormat;
import com.applovin.mediation.MaxAdRevenueListener;
import com.applovin.mediation.MaxAdViewAdListener;
import com.applovin.mediation.MaxDebuggerAdUnitDetailActivity;
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
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class x extends re implements AdControlButton.a, MaxRewardedAdListener, MaxAdViewAdListener, MaxAdRevenueListener, o0.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.applovin.impl.sdk.j f64750a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private z f64751b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private ir f64752c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private y f64753d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private MaxAdView f64754f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private MaxInterstitialAd f64755g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private MaxAppOpenAd f64756h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private MaxRewardedInterstitialAd f64757i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private MaxRewardedAd f64758j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private MaxNativeAdView f64759k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private MaxNativeAdLoader f64760l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private MaxAd f64761m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private d0 f64762n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private List f64763o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private ListView f64764p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private View f64765q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private AdControlButton f64766r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private TextView f64767s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private o0 f64768t;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class a extends MaxNativeAdListener {
        a() {
        }

        @Override // com.applovin.mediation.nativeAds.MaxNativeAdListener
        public void onNativeAdClicked(MaxAd maxAd) {
            x.this.onAdClicked(maxAd);
        }

        @Override // com.applovin.mediation.nativeAds.MaxNativeAdListener
        public void onNativeAdLoadFailed(String str, MaxError maxError) {
            x.this.onAdLoadFailed(str, maxError);
        }

        @Override // com.applovin.mediation.nativeAds.MaxNativeAdListener
        public void onNativeAdLoaded(MaxNativeAdView maxNativeAdView, MaxAd maxAd) {
            if (x.this.f64761m != null) {
                x.this.f64760l.destroy(x.this.f64761m);
            }
            x.this.f64761m = maxAd;
            if (maxNativeAdView != null) {
                x.this.f64759k = maxNativeAdView;
            } else {
                x xVar = x.this;
                com.applovin.impl.sdk.j unused = x.this.f64750a;
                xVar.f64759k = new MaxNativeAdView(MaxNativeAdView.MEDIUM_TEMPLATE_1, com.applovin.impl.sdk.j.m());
                x.this.f64760l.render(x.this.f64759k, maxAd);
            }
            x.this.onAdLoaded(maxAd);
        }
    }

    @Override // com.applovin.impl.re
    protected com.applovin.impl.sdk.j getSdk() {
        return this.f64750a;
    }

    public void initialize(final z zVar, final a0 a0Var, ir irVar, final com.applovin.impl.sdk.j jVar) {
        List listA;
        this.f64750a = jVar;
        this.f64751b = zVar;
        this.f64752c = irVar;
        this.f64763o = jVar.k0().b();
        y yVar = new y(zVar, a0Var, irVar, this);
        this.f64753d = yVar;
        yVar.a(new dc.a() { // from class: com.applovin.impl.b80
            @Override // com.applovin.impl.dc.a
            public final void a(kb kbVar, cc ccVar) {
                this.f58599a.a(jVar, zVar, a0Var, kbVar, ccVar);
            }
        });
        b();
        if (zVar.f().f()) {
            if ((irVar != null && !irVar.b().d().C()) || (listA = jVar.M().a(zVar.c())) == null || listA.isEmpty()) {
                return;
            }
            this.f64768t = new o0(listA, zVar.a(), this);
        }
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
        this.f64766r.setControlState(AdControlButton.b.LOAD);
        this.f64767s.setText("");
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

    @Override // com.applovin.impl.o0.a
    public void onAdLoadFailed(AdError adError, MaxAdFormat maxAdFormat) {
        if (maxAdFormat.isAdViewAd()) {
            this.f64754f.setLocalExtraParameter("amazon_ad_error", adError);
        } else if (MaxAdFormat.INTERSTITIAL == maxAdFormat) {
            this.f64755g.setLocalExtraParameter("amazon_ad_error", adError);
        } else if (MaxAdFormat.APP_OPEN == maxAdFormat) {
            this.f64756h.setLocalExtraParameter("amazon_ad_error", adError);
        } else if (MaxAdFormat.REWARDED_INTERSTITIAL == maxAdFormat) {
            this.f64757i.setLocalExtraParameter("amazon_ad_error", adError);
        } else if (MaxAdFormat.REWARDED == maxAdFormat) {
            this.f64758j.setLocalExtraParameter("amazon_ad_error", adError);
        } else if (MaxAdFormat.NATIVE == maxAdFormat) {
            this.f64760l.setLocalExtraParameter("amazon_ad_error", adError);
        }
        a(maxAdFormat);
    }

    @Override // com.applovin.mediation.MaxAdListener
    public void onAdLoaded(MaxAd maxAd) {
        this.f64767s.setText(maxAd.getNetworkName() + " ad loaded");
        this.f64766r.setControlState(AdControlButton.b.SHOW);
        if (maxAd.getFormat().isAdViewAd()) {
            a(this.f64754f, maxAd.getFormat().getSize());
        } else if (MaxAdFormat.NATIVE == this.f64751b.a()) {
            a(this.f64759k, MaxAdFormat.MREC.getSize());
        }
    }

    @Override // com.applovin.impl.o0.a
    public void onAdResponseLoaded(DTBAdResponse dTBAdResponse, MaxAdFormat maxAdFormat) {
        if (maxAdFormat.isAdViewAd()) {
            this.f64754f.setLocalExtraParameter("amazon_ad_response", dTBAdResponse);
        } else if (MaxAdFormat.INTERSTITIAL == maxAdFormat) {
            this.f64755g.setLocalExtraParameter("amazon_ad_response", dTBAdResponse);
        } else if (MaxAdFormat.APP_OPEN == maxAdFormat) {
            this.f64756h.setLocalExtraParameter("amazon_ad_response", dTBAdResponse);
        } else if (MaxAdFormat.REWARDED_INTERSTITIAL == maxAdFormat) {
            this.f64757i.setLocalExtraParameter("amazon_ad_response", dTBAdResponse);
        } else if (MaxAdFormat.REWARDED == maxAdFormat) {
            this.f64758j.setLocalExtraParameter("amazon_ad_response", dTBAdResponse);
        } else if (MaxAdFormat.NATIVE == maxAdFormat) {
            this.f64760l.setLocalExtraParameter("amazon_ad_response", dTBAdResponse);
        }
        a(maxAdFormat);
    }

    @Override // com.applovin.mediation.MaxAdRevenueListener
    public void onAdRevenuePaid(MaxAd maxAd) {
        yp.a("onAdRevenuePaid", maxAd, this);
    }

    @Override // com.applovin.impl.mediation.debugger.ui.testmode.AdControlButton.a
    public void onClick(AdControlButton adControlButton) {
        if (this.f64750a.k0().c()) {
            yp.a("Not Supported", "Ad loads are not supported while Test Mode is enabled. Please restart the app.", this);
            return;
        }
        if (this.f64753d.j() != this.f64751b.f()) {
            yp.a("Not Supported", "You cannot load an ad from this waterfall because it does not target the current device. To load an ad, please select the targeted waterfall.", this);
            return;
        }
        MaxAdFormat maxAdFormatA = this.f64751b.a();
        AdControlButton.b bVar = AdControlButton.b.LOAD;
        if (bVar == adControlButton.getControlState()) {
            adControlButton.setControlState(AdControlButton.b.LOADING);
            o0 o0Var = this.f64768t;
            if (o0Var != null) {
                o0Var.a();
                return;
            } else {
                a(maxAdFormatA);
                return;
            }
        }
        if (AdControlButton.b.SHOW == adControlButton.getControlState()) {
            if (!maxAdFormatA.isAdViewAd() && maxAdFormatA != MaxAdFormat.NATIVE) {
                adControlButton.setControlState(bVar);
            }
            b(maxAdFormatA);
        }
    }

    @Override // com.applovin.impl.re, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.mediation_debugger_ad_unit_detail_activity);
        setTitle(this.f64753d.k());
        this.f64764p = (ListView) findViewById(R.id.listView);
        this.f64765q = findViewById(R.id.ad_presenter_view);
        this.f64766r = (AdControlButton) findViewById(R.id.ad_control_button);
        this.f64767s = (TextView) findViewById(R.id.status_textview);
        this.f64764p.setAdapter((ListAdapter) this.f64753d);
        this.f64767s.setText(a());
        this.f64767s.setTypeface(Typeface.DEFAULT_BOLD);
        this.f64766r.setOnClickListener(this);
        ShapeDrawable shapeDrawable = new ShapeDrawable();
        shapeDrawable.setPadding(0, 10, 0, 0);
        shapeDrawable.getPaint().setColor(-1);
        shapeDrawable.getPaint().setShadowLayer(10, 0.0f, -10, 855638016);
        shapeDrawable.setShape(new RectShape());
        LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{shapeDrawable});
        layerDrawable.setLayerInset(0, 0, 10, 0, 0);
        this.f64765q.setBackground(layerDrawable);
    }

    @Override // com.applovin.impl.re, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        if (this.f64752c != null) {
            this.f64750a.k0().a(this.f64763o);
        }
        MaxAdView maxAdView = this.f64754f;
        if (maxAdView != null) {
            maxAdView.destroy();
        }
        MaxInterstitialAd maxInterstitialAd = this.f64755g;
        if (maxInterstitialAd != null) {
            maxInterstitialAd.destroy();
        }
        MaxAppOpenAd maxAppOpenAd = this.f64756h;
        if (maxAppOpenAd != null) {
            maxAppOpenAd.destroy();
        }
        MaxRewardedInterstitialAd maxRewardedInterstitialAd = this.f64757i;
        if (maxRewardedInterstitialAd != null) {
            maxRewardedInterstitialAd.destroy();
        }
        MaxRewardedAd maxRewardedAd = this.f64758j;
        if (maxRewardedAd != null) {
            maxRewardedAd.destroy();
        }
        MaxNativeAdLoader maxNativeAdLoader = this.f64760l;
        if (maxNativeAdLoader != null) {
            MaxAd maxAd = this.f64761m;
            if (maxAd != null) {
                maxNativeAdLoader.destroy(maxAd);
            }
            this.f64760l.destroy();
        }
    }

    @Override // com.applovin.mediation.MaxRewardedAdListener
    public void onUserRewarded(MaxAd maxAd, MaxReward maxReward) {
        yp.a("onUserRewarded", maxAd, this);
    }

    private void b() {
        String strC = this.f64751b.c();
        if (this.f64751b.a().isAdViewAd()) {
            MaxAdView maxAdView = new MaxAdView(strC, this.f64751b.a(), this.f64750a.q0(), this);
            this.f64754f = maxAdView;
            maxAdView.setExtraParameter("adaptive_banner", "false");
            this.f64754f.setExtraParameter("disable_auto_retries", ServerProtocol.DIALOG_RETURN_SCOPES_TRUE);
            this.f64754f.setExtraParameter("disable_precache", ServerProtocol.DIALOG_RETURN_SCOPES_TRUE);
            this.f64754f.setExtraParameter("allow_pause_auto_refresh_immediately", ServerProtocol.DIALOG_RETURN_SCOPES_TRUE);
            this.f64754f.stopAutoRefresh();
            this.f64754f.setListener(this);
            return;
        }
        if (MaxAdFormat.INTERSTITIAL == this.f64751b.a()) {
            MaxInterstitialAd maxInterstitialAd = new MaxInterstitialAd(strC, this.f64750a.q0(), this);
            this.f64755g = maxInterstitialAd;
            maxInterstitialAd.setExtraParameter("disable_auto_retries", ServerProtocol.DIALOG_RETURN_SCOPES_TRUE);
            this.f64755g.setListener(this);
            return;
        }
        if (MaxAdFormat.APP_OPEN == this.f64751b.a()) {
            MaxAppOpenAd maxAppOpenAd = new MaxAppOpenAd(strC, this.f64750a.q0());
            this.f64756h = maxAppOpenAd;
            maxAppOpenAd.setExtraParameter("disable_auto_retries", ServerProtocol.DIALOG_RETURN_SCOPES_TRUE);
            this.f64756h.setListener(this);
            return;
        }
        if (MaxAdFormat.REWARDED_INTERSTITIAL == this.f64751b.a()) {
            MaxRewardedInterstitialAd maxRewardedInterstitialAd = new MaxRewardedInterstitialAd(strC, this.f64750a.q0(), this);
            this.f64757i = maxRewardedInterstitialAd;
            maxRewardedInterstitialAd.setExtraParameter("disable_auto_retries", ServerProtocol.DIALOG_RETURN_SCOPES_TRUE);
            this.f64757i.setListener(this);
            return;
        }
        if (MaxAdFormat.REWARDED == this.f64751b.a()) {
            MaxRewardedAd maxRewardedAd = MaxRewardedAd.getInstance(strC, this.f64750a.q0(), this);
            this.f64758j = maxRewardedAd;
            maxRewardedAd.setExtraParameter("disable_auto_retries", ServerProtocol.DIALOG_RETURN_SCOPES_TRUE);
            this.f64758j.setListener(this);
            return;
        }
        if (MaxAdFormat.NATIVE == this.f64751b.a()) {
            MaxNativeAdLoader maxNativeAdLoader = new MaxNativeAdLoader(strC, this.f64750a.q0(), this);
            this.f64760l = maxNativeAdLoader;
            maxNativeAdLoader.setExtraParameter("disable_auto_retries", ServerProtocol.DIALOG_RETURN_SCOPES_TRUE);
            this.f64760l.setNativeAdListener(new a());
            this.f64760l.setRevenueListener(this);
        }
    }

    private String a() {
        if (this.f64750a.k0().c()) {
            return "Not supported while Test Mode is enabled";
        }
        if (this.f64753d.j() != this.f64751b.f()) {
            return "This waterfall is not targeted for the current device";
        }
        return "Tap to load an ad";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(cc ccVar, z zVar, a0 a0Var, com.applovin.impl.sdk.j jVar, MaxDebuggerAdUnitDetailActivity maxDebuggerAdUnitDetailActivity) {
        maxDebuggerAdUnitDetailActivity.initialize(zVar, a0Var, ((y.b) ccVar).v(), jVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(final com.applovin.impl.sdk.j jVar, final z zVar, final a0 a0Var, kb kbVar, final cc ccVar) {
        if (ccVar instanceof y.b) {
            r.a(this, MaxDebuggerAdUnitDetailActivity.class, jVar.e(), new r.b() { // from class: com.applovin.impl.c80
                @Override // com.applovin.impl.r.b
                public final void a(Activity activity) {
                    x.a(ccVar, zVar, a0Var, jVar, (MaxDebuggerAdUnitDetailActivity) activity);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(DialogInterface dialogInterface) {
        this.f64762n = null;
    }

    @Override // com.applovin.mediation.MaxAdListener
    public void onAdLoadFailed(String str, MaxError maxError) {
        this.f64766r.setControlState(AdControlButton.b.LOAD);
        this.f64767s.setText("");
        if (204 == maxError.getCode()) {
            yp.a("No Fill", "No fills often happen in live environments. Please make sure to use the Mediation Debugger test mode before you go live.", this);
            return;
        }
        yp.a("", "Failed to load with error code: " + maxError.getCode(), this);
    }

    private void a(MaxAdFormat maxAdFormat) {
        if (this.f64752c != null) {
            this.f64750a.k0().a(this.f64752c.b().b());
        }
        if (maxAdFormat.isAdViewAd()) {
            this.f64754f.setPlacement("[Mediation Debugger Live Ad]");
            this.f64754f.loadAd();
            return;
        }
        if (MaxAdFormat.INTERSTITIAL == this.f64751b.a()) {
            this.f64755g.loadAd();
            return;
        }
        if (MaxAdFormat.APP_OPEN == this.f64751b.a()) {
            this.f64756h.loadAd();
            return;
        }
        if (MaxAdFormat.REWARDED_INTERSTITIAL == this.f64751b.a()) {
            this.f64757i.loadAd();
            return;
        }
        if (MaxAdFormat.REWARDED == this.f64751b.a()) {
            this.f64758j.loadAd();
        } else if (MaxAdFormat.NATIVE == this.f64751b.a()) {
            this.f64760l.setPlacement("[Mediation Debugger Live Ad]");
            this.f64760l.loadAd();
        } else {
            yp.a("Live ads currently unavailable for ad format", this);
        }
    }

    private void a(ViewGroup viewGroup, AppLovinSdkUtils.Size size) {
        if (this.f64762n != null) {
            return;
        }
        d0 d0Var = new d0(viewGroup, size, this);
        this.f64762n = d0Var;
        d0Var.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.applovin.impl.d80
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(DialogInterface dialogInterface) {
                this.f59175a.a(dialogInterface);
            }
        });
        this.f64762n.show();
    }

    private void b(MaxAdFormat maxAdFormat) {
        if (maxAdFormat.isAdViewAd()) {
            a(this.f64754f, maxAdFormat.getSize());
            return;
        }
        if (MaxAdFormat.INTERSTITIAL == this.f64751b.a()) {
            this.f64755g.showAd("[Mediation Debugger Live Ad]");
            return;
        }
        if (MaxAdFormat.APP_OPEN == this.f64751b.a()) {
            this.f64756h.showAd("[Mediation Debugger Live Ad]");
            return;
        }
        if (MaxAdFormat.REWARDED_INTERSTITIAL == this.f64751b.a()) {
            this.f64757i.showAd("[Mediation Debugger Live Ad]");
        } else if (MaxAdFormat.REWARDED == this.f64751b.a()) {
            this.f64758j.showAd("[Mediation Debugger Live Ad]");
        } else if (MaxAdFormat.NATIVE == this.f64751b.a()) {
            a(this.f64759k, MaxAdFormat.MREC.getSize());
        }
    }
}
