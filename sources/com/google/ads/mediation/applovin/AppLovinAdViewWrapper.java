package com.google.ads.mediation.applovin;

import android.content.Context;
import com.applovin.adview.AppLovinAdView;
import com.applovin.adview.AppLovinAdViewEventListener;
import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinAdClickListener;
import com.applovin.sdk.AppLovinAdDisplayListener;
import com.applovin.sdk.AppLovinAdSize;
import com.applovin.sdk.AppLovinSdk;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
class AppLovinAdViewWrapper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final AppLovinAdView f68945a;

    private AppLovinAdViewWrapper(AppLovinSdk appLovinSdk, AppLovinAdSize appLovinAdSize, Context context) {
        this.f68945a = new AppLovinAdView(appLovinSdk, appLovinAdSize, context);
    }

    public static AppLovinAdViewWrapper b(AppLovinSdk appLovinSdk, AppLovinAdSize appLovinAdSize, Context context) {
        return new AppLovinAdViewWrapper(appLovinSdk, appLovinAdSize, context);
    }

    public AppLovinAdView a() {
        return this.f68945a;
    }

    public void c(AppLovinAd appLovinAd) {
        this.f68945a.renderAd(appLovinAd);
    }

    public void d(AppLovinAdClickListener appLovinAdClickListener) {
        this.f68945a.setAdClickListener(appLovinAdClickListener);
    }

    public void e(AppLovinAdDisplayListener appLovinAdDisplayListener) {
        this.f68945a.setAdDisplayListener(appLovinAdDisplayListener);
    }

    public void f(AppLovinAdViewEventListener appLovinAdViewEventListener) {
        this.f68945a.setAdViewEventListener(appLovinAdViewEventListener);
    }
}
