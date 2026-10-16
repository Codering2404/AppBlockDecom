package com.applovin.mediation.ads;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.ViewGroup;
import androidx.lifecycle.Lifecycle;
import com.applovin.impl.mediation.ads.MaxFullscreenAdImpl;
import com.applovin.impl.mediation.ads.a;
import com.applovin.impl.yp;
import com.applovin.mediation.MaxAdExpirationListener;
import com.applovin.mediation.MaxAdFormat;
import com.applovin.mediation.MaxAdListener;
import com.applovin.mediation.MaxAdRequestListener;
import com.applovin.mediation.MaxAdRevenueListener;
import com.applovin.mediation.MaxAdReviewListener;
import com.applovin.sdk.AppLovinSdk;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class MaxInterstitialAd implements MaxFullscreenAdImpl.b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static WeakReference f65511b = new WeakReference(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final MaxFullscreenAdImpl f65512a;

    public MaxInterstitialAd(String str, Context context) {
        this(str, AppLovinSdk.getInstance(context), context);
    }

    public void destroy() {
        this.f65512a.logApiCall("destroy()");
        this.f65512a.destroy();
    }

    @Override // com.applovin.impl.mediation.ads.MaxFullscreenAdImpl.b
    public Activity getActivity() {
        this.f65512a.logApiCall("getActivity()");
        return (Activity) f65511b.get();
    }

    public String getAdUnitId() {
        return this.f65512a.getAdUnitId();
    }

    public boolean isReady() {
        boolean zIsReady = this.f65512a.isReady();
        this.f65512a.logApiCall("isReady() " + zIsReady + " for ad unit id " + this.f65512a.getAdUnitId());
        return zIsReady;
    }

    public void loadAd() {
        this.f65512a.logApiCall("loadAd()");
        this.f65512a.loadAd();
    }

    public void setAdReviewListener(MaxAdReviewListener maxAdReviewListener) {
        this.f65512a.logApiCall("setAdReviewListener(listener=" + maxAdReviewListener + ")");
        this.f65512a.setAdReviewListener(maxAdReviewListener);
    }

    public void setExpirationListener(MaxAdExpirationListener maxAdExpirationListener) {
        this.f65512a.logApiCall("setExpirationListener(listener=" + maxAdExpirationListener + ")");
        this.f65512a.setExpirationListener(maxAdExpirationListener);
    }

    public void setExtraParameter(String str, String str2) {
        this.f65512a.logApiCall("setExtraParameter(key=" + str + ", value=" + str2 + ")");
        this.f65512a.setExtraParameter(str, str2);
    }

    public void setListener(MaxAdListener maxAdListener) {
        this.f65512a.logApiCall("setListener(listener=" + maxAdListener + ")");
        this.f65512a.setListener(maxAdListener);
    }

    public void setLocalExtraParameter(String str, Object obj) {
        this.f65512a.logApiCall("setLocalExtraParameter(key=" + str + ", value=" + obj + ")");
        this.f65512a.setLocalExtraParameter(str, obj);
    }

    public void setRequestListener(MaxAdRequestListener maxAdRequestListener) {
        this.f65512a.logApiCall("setRequestListener(listener=" + maxAdRequestListener + ")");
        this.f65512a.setRequestListener(maxAdRequestListener);
    }

    public void setRevenueListener(MaxAdRevenueListener maxAdRevenueListener) {
        this.f65512a.logApiCall("setRevenueListener(listener=" + maxAdRevenueListener + ")");
        this.f65512a.setRevenueListener(maxAdRevenueListener);
    }

    public void showAd(Activity activity) {
        showAd((String) null, activity);
    }

    public String toString() {
        return "" + this.f65512a;
    }

    public MaxInterstitialAd(String str, AppLovinSdk appLovinSdk, Context context) {
        a.logApiCall("MaxInterstitialAd", "MaxInterstitialAd(adUnitId=" + str + ", sdk=" + appLovinSdk + ", context=" + context + ")");
        if (str == null) {
            throw new IllegalArgumentException("No ad unit ID specified");
        }
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("Empty ad unit ID specified");
        }
        if (context == null) {
            throw new IllegalArgumentException("No context specified");
        }
        if (appLovinSdk == null) {
            throw new IllegalArgumentException("No sdk specified");
        }
        if (context instanceof Activity) {
            f65511b = new WeakReference((Activity) context);
        }
        this.f65512a = new MaxFullscreenAdImpl(str.trim(), MaxAdFormat.INTERSTITIAL, this, "MaxInterstitialAd", appLovinSdk.a(), context);
    }

    public void showAd(String str, Activity activity) {
        showAd(str, (String) null, activity);
    }

    public void showAd(String str, String str2, Activity activity) {
        this.f65512a.logApiCall("showAd(placement=" + str + ", customData=" + str2 + ", activity=" + activity + ")");
        yp.b(str2, "MaxInterstitialAd");
        this.f65512a.showAd(str, str2, activity);
    }

    public void showAd(ViewGroup viewGroup, Lifecycle lifecycle, Activity activity) {
        showAd((String) null, viewGroup, lifecycle, activity);
    }

    public void showAd(String str, ViewGroup viewGroup, Lifecycle lifecycle, Activity activity) {
        showAd(str, null, viewGroup, lifecycle, activity);
    }

    public void showAd(String str, String str2, ViewGroup viewGroup, Lifecycle lifecycle, Activity activity) {
        this.f65512a.logApiCall("showAd(placement=" + str + ", customData=" + str2 + ", containerView=" + viewGroup + ", lifecycle=" + lifecycle + ", activity=" + activity + ")");
        this.f65512a.showAd(str, str2, viewGroup, lifecycle, activity);
    }

    @Deprecated
    public void showAd() {
        showAd((String) null);
    }

    @Deprecated
    public void showAd(String str) {
        showAd(str, (String) null);
    }

    @Deprecated
    public void showAd(String str, String str2) {
        this.f65512a.logApiCall("showAd(placement=" + str + ", customData=" + str2 + ")");
        yp.b(str2, "MaxInterstitialAd");
        this.f65512a.showAd(str, str2, getActivity());
    }

    @Deprecated
    public void showAd(ViewGroup viewGroup, Lifecycle lifecycle) {
        showAd((String) null, viewGroup, lifecycle);
    }

    @Deprecated
    public void showAd(String str, ViewGroup viewGroup, Lifecycle lifecycle) {
        showAd(str, (String) null, viewGroup, lifecycle);
    }

    @Deprecated
    public void showAd(String str, String str2, ViewGroup viewGroup, Lifecycle lifecycle) {
        this.f65512a.logApiCall("showAd(placement=" + str + ", customData=" + str2 + ", containerView=" + viewGroup + ", lifecycle=" + lifecycle + ")");
        this.f65512a.showAd(str, str2, viewGroup, lifecycle, getActivity());
    }
}
