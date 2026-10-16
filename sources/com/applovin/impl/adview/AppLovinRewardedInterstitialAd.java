package com.applovin.impl.adview;

import android.content.Context;
import com.applovin.adview.AppLovinIncentivizedInterstitial;
import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinAdClickListener;
import com.applovin.sdk.AppLovinAdDisplayListener;
import com.applovin.sdk.AppLovinAdRewardListener;
import com.applovin.sdk.AppLovinAdVideoPlaybackListener;
import com.applovin.sdk.AppLovinSdk;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class AppLovinRewardedInterstitialAd {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final AppLovinIncentivizedInterstitial f58253a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private AppLovinAdDisplayListener f58254b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private AppLovinAdClickListener f58255c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private AppLovinAdVideoPlaybackListener f58256d;

    public AppLovinRewardedInterstitialAd(AppLovinSdk appLovinSdk) {
        this.f58253a = new AppLovinIncentivizedInterstitial(appLovinSdk);
    }

    public void setAdClickListener(AppLovinAdClickListener appLovinAdClickListener) {
        this.f58255c = appLovinAdClickListener;
    }

    public void setAdDisplayListener(AppLovinAdDisplayListener appLovinAdDisplayListener) {
        this.f58254b = appLovinAdDisplayListener;
    }

    public void setAdVideoPlaybackListener(AppLovinAdVideoPlaybackListener appLovinAdVideoPlaybackListener) {
        this.f58256d = appLovinAdVideoPlaybackListener;
    }

    public void show(AppLovinAd appLovinAd, Context context, AppLovinAdRewardListener appLovinAdRewardListener) {
        this.f58253a.show(appLovinAd, context, appLovinAdRewardListener, this.f58256d, this.f58254b, this.f58255c);
    }

    public String toString() {
        return "AppLovinRewardedInterstitialAd{}";
    }
}
