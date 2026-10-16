package com.google.ads.mediation.applovin;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.applovin.adview.AppLovinInterstitialAdDialog;
import com.applovin.mediation.AppLovinUtils;
import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinAdService;
import com.applovin.sdk.AppLovinAdSize;
import com.applovin.sdk.AppLovinSdk;
import com.google.ads.mediation.applovin.AppLovinInitializer;
import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.mediation.MediationAdLoadCallback;
import com.google.android.gms.ads.mediation.MediationInterstitialAd;
import com.google.android.gms.ads.mediation.MediationInterstitialAdConfiguration;
import java.lang.ref.WeakReference;
import java.util.HashMap;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class AppLovinWaterfallInterstitialAd extends AppLovinInterstitialRenderer implements MediationInterstitialAd {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    protected static final HashMap f68975f = new HashMap();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private AppLovinSdk f68976a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Context f68977b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Bundle f68978c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f68979d;

    public AppLovinWaterfallInterstitialAd(MediationInterstitialAdConfiguration mediationInterstitialAdConfiguration, MediationAdLoadCallback mediationAdLoadCallback, AppLovinInitializer appLovinInitializer, AppLovinAdFactory appLovinAdFactory) {
        super(mediationInterstitialAdConfiguration, mediationAdLoadCallback, appLovinInitializer, appLovinAdFactory);
        this.f68979d = false;
    }

    @Override // com.google.ads.mediation.applovin.AppLovinInterstitialRenderer, com.applovin.sdk.AppLovinAdDisplayListener
    public void adHidden(AppLovinAd appLovinAd) {
        f();
        super.adHidden(appLovinAd);
    }

    @Override // com.google.ads.mediation.applovin.AppLovinInterstitialRenderer, com.applovin.sdk.AppLovinAdLoadListener
    public void adReceived(AppLovinAd appLovinAd) {
        if (this.f68979d) {
            f();
        }
        super.adReceived(appLovinAd);
    }

    void f() {
        if (TextUtils.isEmpty(this.zoneId)) {
            return;
        }
        HashMap map = f68975f;
        if (map.containsKey(this.zoneId) && equals(((WeakReference) map.get(this.zoneId)).get())) {
            map.remove(this.zoneId);
        }
    }

    @Override // com.google.ads.mediation.applovin.AppLovinInterstitialRenderer, com.applovin.sdk.AppLovinAdLoadListener
    public void failedToReceiveAd(int i3) {
        f();
        super.failedToReceiveAd(i3);
    }

    public void loadAd() {
        this.f68977b = this.interstitialAdConfiguration.b();
        final Bundle bundleD = this.interstitialAdConfiguration.d();
        String string = bundleD.getString(AppLovinUtils.ServerParameterKeys.SDK_KEY);
        if (TextUtils.isEmpty(string)) {
            AdError adError = new AdError(110, "Missing or invalid SDK Key.", AppLovinMediationAdapter.APPLOVIN_SDK_ERROR_DOMAIN);
            Log.e(AppLovinInterstitialRenderer.TAG, adError.c());
            this.interstitialAdLoadCallback.onFailure(adError);
        } else {
            if (AppLovinUtils.isMultiAdsEnabled(bundleD)) {
                this.f68979d = true;
            }
            this.appLovinInitializer.d(this.f68977b, string, new AppLovinInitializer.OnInitializeSuccessListener() { // from class: com.google.ads.mediation.applovin.AppLovinWaterfallInterstitialAd.1
                @Override // com.google.ads.mediation.applovin.AppLovinInitializer.OnInitializeSuccessListener
                public void onInitializeSuccess(String str) {
                    AppLovinWaterfallInterstitialAd.this.zoneId = AppLovinUtils.retrieveZoneId(bundleD);
                    HashMap map = AppLovinWaterfallInterstitialAd.f68975f;
                    if (map.containsKey(AppLovinWaterfallInterstitialAd.this.zoneId) && ((WeakReference) map.get(AppLovinWaterfallInterstitialAd.this.zoneId)).get() != null) {
                        AdError adError2 = new AdError(105, AppLovinInterstitialRenderer.ERROR_MSG_MULTIPLE_INTERSTITIAL_AD, AppLovinMediationAdapter.ERROR_DOMAIN);
                        Log.e(AppLovinInterstitialRenderer.TAG, adError2.c());
                        AppLovinWaterfallInterstitialAd.this.interstitialAdLoadCallback.onFailure(adError2);
                        return;
                    }
                    map.put(AppLovinWaterfallInterstitialAd.this.zoneId, new WeakReference(AppLovinWaterfallInterstitialAd.this));
                    AppLovinWaterfallInterstitialAd appLovinWaterfallInterstitialAd = AppLovinWaterfallInterstitialAd.this;
                    appLovinWaterfallInterstitialAd.f68976a = appLovinWaterfallInterstitialAd.appLovinInitializer.e(bundleD, appLovinWaterfallInterstitialAd.f68977b);
                    AppLovinWaterfallInterstitialAd appLovinWaterfallInterstitialAd2 = AppLovinWaterfallInterstitialAd.this;
                    appLovinWaterfallInterstitialAd2.f68978c = appLovinWaterfallInterstitialAd2.f68978c;
                    Log.d(AppLovinInterstitialRenderer.TAG, "Requesting interstitial for zone: " + AppLovinWaterfallInterstitialAd.this.zoneId);
                    if (TextUtils.isEmpty(AppLovinWaterfallInterstitialAd.this.zoneId)) {
                        AppLovinWaterfallInterstitialAd.this.f68976a.getAdService().loadNextAd(AppLovinAdSize.INTERSTITIAL, AppLovinWaterfallInterstitialAd.this);
                        return;
                    }
                    AppLovinAdService adService = AppLovinWaterfallInterstitialAd.this.f68976a.getAdService();
                    AppLovinWaterfallInterstitialAd appLovinWaterfallInterstitialAd3 = AppLovinWaterfallInterstitialAd.this;
                    adService.loadNextAdForZoneId(appLovinWaterfallInterstitialAd3.zoneId, appLovinWaterfallInterstitialAd3);
                }
            });
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationInterstitialAd
    public void showAd(Context context) {
        this.f68976a.getSettings().setMuted(AppLovinUtils.shouldMuteAudio(this.f68978c));
        AppLovinInterstitialAdDialog appLovinInterstitialAdDialogD = this.appLovinAdFactory.d(this.f68976a, context);
        appLovinInterstitialAdDialogD.setAdDisplayListener(this);
        appLovinInterstitialAdDialogD.setAdClickListener(this);
        appLovinInterstitialAdDialogD.setAdVideoPlaybackListener(this);
        if (this.appLovinInterstitialAd == null) {
            String str = AppLovinInterstitialRenderer.TAG;
            Log.d(str, "Attempting to show interstitial before one was loaded.");
            if (TextUtils.isEmpty(this.zoneId)) {
                Log.d(str, "Showing interstitial preloaded by SDK.");
                appLovinInterstitialAdDialogD.show();
                return;
            }
            return;
        }
        Log.d(AppLovinInterstitialRenderer.TAG, "Showing interstitial for zone: " + this.zoneId);
        appLovinInterstitialAdDialogD.showAndRender(this.appLovinInterstitialAd);
    }
}
