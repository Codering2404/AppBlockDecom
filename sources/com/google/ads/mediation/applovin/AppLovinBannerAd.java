package com.google.ads.mediation.applovin;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import com.applovin.adview.AppLovinAdView;
import com.applovin.adview.AppLovinAdViewDisplayErrorCode;
import com.applovin.adview.AppLovinAdViewEventListener;
import com.applovin.mediation.AppLovinUtils;
import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinAdClickListener;
import com.applovin.sdk.AppLovinAdDisplayListener;
import com.applovin.sdk.AppLovinAdLoadListener;
import com.applovin.sdk.AppLovinAdSize;
import com.applovin.sdk.AppLovinSdk;
import com.google.ads.mediation.applovin.AppLovinInitializer;
import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.mediation.MediationAdLoadCallback;
import com.google.android.gms.ads.mediation.MediationBannerAd;
import com.google.android.gms.ads.mediation.MediationBannerAdCallback;
import com.google.android.gms.ads.mediation.MediationBannerAdConfiguration;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class AppLovinBannerAd implements MediationBannerAd, AppLovinAdLoadListener, AppLovinAdDisplayListener, AppLovinAdClickListener, AppLovinAdViewEventListener {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final String f68946k = "AppLovinBannerAd";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private AppLovinAdViewWrapper f68947a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private AppLovinSdk f68948b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Context f68949c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f68950d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final AppLovinInitializer f68951f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final AppLovinAdFactory f68952g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final MediationBannerAdConfiguration f68953h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final MediationAdLoadCallback f68954i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private MediationBannerAdCallback f68955j;

    private AppLovinBannerAd(MediationBannerAdConfiguration mediationBannerAdConfiguration, MediationAdLoadCallback mediationAdLoadCallback, AppLovinInitializer appLovinInitializer, AppLovinAdFactory appLovinAdFactory) {
        this.f68953h = mediationBannerAdConfiguration;
        this.f68954i = mediationAdLoadCallback;
        this.f68951f = appLovinInitializer;
        this.f68952g = appLovinAdFactory;
    }

    public static AppLovinBannerAd n(MediationBannerAdConfiguration mediationBannerAdConfiguration, MediationAdLoadCallback mediationAdLoadCallback, AppLovinInitializer appLovinInitializer, AppLovinAdFactory appLovinAdFactory) {
        return new AppLovinBannerAd(mediationBannerAdConfiguration, mediationAdLoadCallback, appLovinInitializer, appLovinAdFactory);
    }

    @Override // com.google.android.gms.ads.mediation.MediationBannerAd
    public View a() {
        return this.f68947a.a();
    }

    @Override // com.applovin.sdk.AppLovinAdClickListener
    public void adClicked(AppLovinAd appLovinAd) {
        Log.d(f68946k, "Banner clicked.");
        MediationBannerAdCallback mediationBannerAdCallback = this.f68955j;
        if (mediationBannerAdCallback != null) {
            mediationBannerAdCallback.reportAdClicked();
        }
    }

    @Override // com.applovin.adview.AppLovinAdViewEventListener
    public void adClosedFullscreen(AppLovinAd appLovinAd, AppLovinAdView appLovinAdView) {
        Log.d(f68946k, "Banner closed fullscreen.");
        MediationBannerAdCallback mediationBannerAdCallback = this.f68955j;
        if (mediationBannerAdCallback != null) {
            mediationBannerAdCallback.onAdClosed();
        }
    }

    @Override // com.applovin.sdk.AppLovinAdDisplayListener
    public void adDisplayed(AppLovinAd appLovinAd) {
        Log.d(f68946k, "Banner displayed.");
        MediationBannerAdCallback mediationBannerAdCallback = this.f68955j;
        if (mediationBannerAdCallback != null) {
            mediationBannerAdCallback.onAdOpened();
        }
    }

    @Override // com.applovin.adview.AppLovinAdViewEventListener
    public void adFailedToDisplay(AppLovinAd appLovinAd, AppLovinAdView appLovinAdView, AppLovinAdViewDisplayErrorCode appLovinAdViewDisplayErrorCode) {
        Log.w(f68946k, "Banner failed to display: " + appLovinAdViewDisplayErrorCode);
    }

    @Override // com.applovin.sdk.AppLovinAdDisplayListener
    public void adHidden(AppLovinAd appLovinAd) {
        Log.d(f68946k, "Banner dismissed.");
    }

    @Override // com.applovin.adview.AppLovinAdViewEventListener
    public void adLeftApplication(AppLovinAd appLovinAd, AppLovinAdView appLovinAdView) {
        Log.d(f68946k, "Banner left application.");
        MediationBannerAdCallback mediationBannerAdCallback = this.f68955j;
        if (mediationBannerAdCallback != null) {
            mediationBannerAdCallback.onAdLeftApplication();
        }
    }

    @Override // com.applovin.adview.AppLovinAdViewEventListener
    public void adOpenedFullscreen(AppLovinAd appLovinAd, AppLovinAdView appLovinAdView) {
        Log.d(f68946k, "Banner opened fullscreen.");
        MediationBannerAdCallback mediationBannerAdCallback = this.f68955j;
        if (mediationBannerAdCallback != null) {
            mediationBannerAdCallback.onAdOpened();
        }
    }

    @Override // com.applovin.sdk.AppLovinAdLoadListener
    public void adReceived(AppLovinAd appLovinAd) {
        Log.d(f68946k, "Banner did load ad for zone: " + this.f68950d);
        this.f68947a.c(appLovinAd);
        this.f68955j = (MediationBannerAdCallback) this.f68954i.onSuccess(this);
    }

    @Override // com.applovin.sdk.AppLovinAdLoadListener
    public void failedToReceiveAd(int i3) {
        AdError adError = AppLovinUtils.getAdError(i3);
        Log.w(f68946k, "Failed to load banner ad with error: " + i3);
        this.f68954i.onFailure(adError);
    }

    public void m() {
        this.f68949c = this.f68953h.b();
        final Bundle bundleD = this.f68953h.d();
        AdSize adSizeH = this.f68953h.h();
        String string = bundleD.getString(AppLovinUtils.ServerParameterKeys.SDK_KEY);
        if (TextUtils.isEmpty(string)) {
            AdError adError = new AdError(110, "Missing or invalid SDK Key.", AppLovinMediationAdapter.ERROR_DOMAIN);
            Log.e(f68946k, adError.c());
            this.f68954i.onFailure(adError);
            return;
        }
        final AppLovinAdSize appLovinAdSizeAppLovinAdSizeFromAdMobAdSize = AppLovinUtils.appLovinAdSizeFromAdMobAdSize(this.f68949c, adSizeH);
        if (appLovinAdSizeAppLovinAdSizeFromAdMobAdSize != null) {
            this.f68951f.d(this.f68949c, string, new AppLovinInitializer.OnInitializeSuccessListener() { // from class: com.google.ads.mediation.applovin.AppLovinBannerAd.1
                @Override // com.google.ads.mediation.applovin.AppLovinInitializer.OnInitializeSuccessListener
                public void onInitializeSuccess(String str) {
                    AppLovinBannerAd appLovinBannerAd = AppLovinBannerAd.this;
                    appLovinBannerAd.f68948b = appLovinBannerAd.f68951f.e(bundleD, AppLovinBannerAd.this.f68949c);
                    AppLovinBannerAd.this.f68950d = AppLovinUtils.retrieveZoneId(bundleD);
                    Log.d(AppLovinBannerAd.f68946k, "Requesting banner of size " + appLovinAdSizeAppLovinAdSizeFromAdMobAdSize + " for zone: " + AppLovinBannerAd.this.f68950d);
                    AppLovinBannerAd appLovinBannerAd2 = AppLovinBannerAd.this;
                    appLovinBannerAd2.f68947a = appLovinBannerAd2.f68952g.a(AppLovinBannerAd.this.f68948b, appLovinAdSizeAppLovinAdSizeFromAdMobAdSize, AppLovinBannerAd.this.f68949c);
                    AppLovinBannerAd.this.f68947a.e(AppLovinBannerAd.this);
                    AppLovinBannerAd.this.f68947a.d(AppLovinBannerAd.this);
                    AppLovinBannerAd.this.f68947a.f(AppLovinBannerAd.this);
                    if (TextUtils.isEmpty(AppLovinBannerAd.this.f68950d)) {
                        AppLovinBannerAd.this.f68948b.getAdService().loadNextAd(appLovinAdSizeAppLovinAdSizeFromAdMobAdSize, AppLovinBannerAd.this);
                    } else {
                        AppLovinBannerAd.this.f68948b.getAdService().loadNextAdForZoneId(AppLovinBannerAd.this.f68950d, AppLovinBannerAd.this);
                    }
                }
            });
            return;
        }
        AdError adError2 = new AdError(101, "Failed to request banner with unsupported size.", AppLovinMediationAdapter.ERROR_DOMAIN);
        Log.e(f68946k, adError2.c());
        this.f68954i.onFailure(adError2);
    }
}
