package com.google.ads.mediation.applovin;

import android.content.Context;
import com.applovin.adview.AppLovinIncentivizedInterstitial;
import com.applovin.adview.AppLovinInterstitialAd;
import com.applovin.adview.AppLovinInterstitialAdDialog;
import com.applovin.sdk.AppLovinAdSize;
import com.applovin.sdk.AppLovinSdk;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class AppLovinAdFactory {
    AppLovinAdViewWrapper a(AppLovinSdk appLovinSdk, AppLovinAdSize appLovinAdSize, Context context) {
        return AppLovinAdViewWrapper.b(appLovinSdk, appLovinAdSize, context);
    }

    public AppLovinIncentivizedInterstitial b(AppLovinSdk appLovinSdk) {
        return AppLovinIncentivizedInterstitial.create(appLovinSdk);
    }

    public AppLovinIncentivizedInterstitial c(String str, AppLovinSdk appLovinSdk) {
        return AppLovinIncentivizedInterstitial.create(str, appLovinSdk);
    }

    public AppLovinInterstitialAdDialog d(AppLovinSdk appLovinSdk, Context context) {
        return AppLovinInterstitialAd.create(appLovinSdk, context);
    }
}
