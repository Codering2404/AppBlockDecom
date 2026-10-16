package com.applovin.mediation.ads;

import android.content.Context;
import com.applovin.impl.mediation.ads.MaxFullscreenAdImpl;
import com.applovin.impl.mediation.ads.a;
import com.applovin.impl.sdk.j;
import com.applovin.impl.yp;
import com.applovin.mediation.MaxAdExpirationListener;
import com.applovin.mediation.MaxAdFormat;
import com.applovin.mediation.MaxAdListener;
import com.applovin.mediation.MaxAdRequestListener;
import com.applovin.mediation.MaxAdRevenueListener;
import com.applovin.mediation.MaxAdReviewListener;
import com.applovin.sdk.AppLovinSdk;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class MaxAppOpenAd {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final MaxFullscreenAdImpl f65510a;

    public MaxAppOpenAd(String str, Context context) {
        this(str, AppLovinSdk.getInstance(context), context);
    }

    public void destroy() {
        this.f65510a.logApiCall("destroy()");
        this.f65510a.destroy();
    }

    public String getAdUnitId() {
        return this.f65510a.getAdUnitId();
    }

    public boolean isReady() {
        boolean zIsReady = this.f65510a.isReady();
        this.f65510a.logApiCall("isReady() " + zIsReady + " for ad unit id " + this.f65510a.getAdUnitId());
        return zIsReady;
    }

    public void loadAd() {
        this.f65510a.logApiCall("loadAd()");
        this.f65510a.loadAd();
    }

    public void setAdReviewListener(MaxAdReviewListener maxAdReviewListener) {
        this.f65510a.logApiCall("setAdReviewListener(listener=" + maxAdReviewListener + ")");
        this.f65510a.setAdReviewListener(maxAdReviewListener);
    }

    public void setExpirationListener(MaxAdExpirationListener maxAdExpirationListener) {
        this.f65510a.logApiCall("setExpirationListener(listener=" + maxAdExpirationListener + ")");
        this.f65510a.setExpirationListener(maxAdExpirationListener);
    }

    public void setExtraParameter(String str, String str2) {
        this.f65510a.logApiCall("setExtraParameter(key=" + str + ", value=" + str2 + ")");
        this.f65510a.setExtraParameter(str, str2);
    }

    public void setListener(MaxAdListener maxAdListener) {
        this.f65510a.logApiCall("setListener(listener=" + maxAdListener + ")");
        this.f65510a.setListener(maxAdListener);
    }

    public void setLocalExtraParameter(String str, Object obj) {
        this.f65510a.logApiCall("setLocalExtraParameter(key=" + str + ", value=" + obj + ")");
        this.f65510a.setLocalExtraParameter(str, obj);
    }

    public void setRequestListener(MaxAdRequestListener maxAdRequestListener) {
        this.f65510a.logApiCall("setRequestListener(listener=" + maxAdRequestListener + ")");
        this.f65510a.setRequestListener(maxAdRequestListener);
    }

    public void setRevenueListener(MaxAdRevenueListener maxAdRevenueListener) {
        this.f65510a.logApiCall("setRevenueListener(listener=" + maxAdRevenueListener + ")");
        this.f65510a.setRevenueListener(maxAdRevenueListener);
    }

    public void showAd() {
        showAd(null);
    }

    public String toString() {
        return "" + this.f65510a;
    }

    public MaxAppOpenAd(String str, AppLovinSdk appLovinSdk) {
        this(str, appLovinSdk, j.m());
    }

    public void showAd(String str) {
        showAd(str, null);
    }

    private MaxAppOpenAd(String str, AppLovinSdk appLovinSdk, Context context) {
        a.logApiCall("MaxAppOpenAd", "MaxAppOpenAd(adUnitId=" + str + ", sdk=" + appLovinSdk + ", context=" + context + ")");
        this.f65510a = new MaxFullscreenAdImpl(str.trim(), MaxAdFormat.APP_OPEN, null, "MaxAppOpenAd", appLovinSdk.a(), context);
    }

    public void showAd(String str, String str2) {
        this.f65510a.logApiCall("showAd(placement=" + str + ", customData=" + str2 + ")");
        yp.b(str2, "MaxAppOpenAd");
        this.f65510a.showAd(str, str2, null);
    }
}
