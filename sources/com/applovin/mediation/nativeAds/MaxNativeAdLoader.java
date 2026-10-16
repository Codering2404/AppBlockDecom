package com.applovin.mediation.nativeAds;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.applovin.impl.mediation.ads.MaxNativeAdLoaderImpl;
import com.applovin.mediation.MaxAd;
import com.applovin.mediation.MaxAdRevenueListener;
import com.applovin.mediation.MaxAdReviewListener;
import com.applovin.sdk.AppLovinSdk;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class MaxNativeAdLoader {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final MaxNativeAdLoaderImpl f65537a;

    public MaxNativeAdLoader(String str, Context context) {
        this(str, AppLovinSdk.getInstance(context), context);
    }

    public void a(List<View> list, ViewGroup viewGroup, MaxAd maxAd) {
        this.f65537a.logApiCall("a()");
        this.f65537a.registerClickableViews(list, viewGroup, maxAd);
    }

    public void b(MaxAd maxAd) {
        this.f65537a.logApiCall("b()");
        this.f65537a.handleNativeAdViewRendered(maxAd);
    }

    public void destroy() {
        this.f65537a.logApiCall("destroy()");
        this.f65537a.destroy();
    }

    public String getAdUnitId() {
        return this.f65537a.getAdUnitId();
    }

    public String getPlacement() {
        this.f65537a.logApiCall("getPlacement()");
        return this.f65537a.getPlacement();
    }

    public void loadAd() {
        loadAd(null);
    }

    public boolean render(MaxNativeAdView maxNativeAdView, MaxAd maxAd) {
        this.f65537a.logApiCall("render(adView=" + maxNativeAdView + ", ad=" + maxAd + ")");
        return this.f65537a.render(maxNativeAdView, maxAd);
    }

    public void setAdReviewListener(MaxAdReviewListener maxAdReviewListener) {
        this.f65537a.logApiCall("setAdReviewListener(listener=" + maxAdReviewListener + ")");
        this.f65537a.setAdReviewListener(maxAdReviewListener);
    }

    public void setCustomData(String str) {
        this.f65537a.logApiCall("setCustomData(value=" + str + ")");
        this.f65537a.setCustomData(str);
    }

    public void setExtraParameter(String str, String str2) {
        this.f65537a.logApiCall("setExtraParameter(key=" + str + ", value=" + str2 + ")");
        this.f65537a.setExtraParameter(str, str2);
    }

    public void setLocalExtraParameter(String str, Object obj) {
        this.f65537a.logApiCall("setLocalExtraParameter(key=" + str + ", value=" + obj + ")");
        this.f65537a.setLocalExtraParameter(str, obj);
    }

    public void setNativeAdListener(MaxNativeAdListener maxNativeAdListener) {
        this.f65537a.logApiCall("setNativeAdListener(listener=" + maxNativeAdListener + ")");
        this.f65537a.setNativeAdListener(maxNativeAdListener);
    }

    public void setPlacement(String str) {
        this.f65537a.logApiCall("setPlacement(placement=" + str + ")");
        this.f65537a.setPlacement(str);
    }

    public void setRevenueListener(MaxAdRevenueListener maxAdRevenueListener) {
        this.f65537a.logApiCall("setRevenueListener(listener=" + maxAdRevenueListener + ")");
        this.f65537a.setRevenueListener(maxAdRevenueListener);
    }

    public MaxNativeAdLoader(String str, AppLovinSdk appLovinSdk, Context context) {
        com.applovin.impl.mediation.ads.a.logApiCall("MaxNativeAdLoader", "MaxNativeAdLoader(adUnitId=" + str + ", sdk=" + appLovinSdk + ")");
        if (str == null) {
            throw new IllegalArgumentException("No ad unit ID specified");
        }
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("Empty ad unit ID specified");
        }
        if (appLovinSdk == null) {
            throw new IllegalArgumentException("No sdk specified");
        }
        if (context == null) {
            throw new IllegalArgumentException("No context specified");
        }
        this.f65537a = new MaxNativeAdLoaderImpl(str, appLovinSdk.a());
    }

    public void loadAd(MaxNativeAdView maxNativeAdView) {
        this.f65537a.logApiCall("loadAd(adView=" + maxNativeAdView + ")");
        this.f65537a.loadAd(maxNativeAdView);
    }

    public void destroy(MaxAd maxAd) {
        this.f65537a.logApiCall("destroy(nativeAd=" + maxAd + ")");
        this.f65537a.destroy(maxAd);
    }
}
