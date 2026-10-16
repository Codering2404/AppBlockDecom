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
import com.applovin.mediation.MaxAdRequestListener;
import com.applovin.mediation.MaxAdRevenueListener;
import com.applovin.mediation.MaxAdReviewListener;
import com.applovin.mediation.MaxRewardedAdListener;
import com.applovin.sdk.AppLovinSdk;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class MaxRewardedAd implements MaxFullscreenAdImpl.b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Map f65513b = new HashMap();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Object f65514c = new Object();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static WeakReference f65515d = new WeakReference(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final MaxFullscreenAdImpl f65516a;

    private MaxRewardedAd(String str, AppLovinSdk appLovinSdk, Context context) {
        this.f65516a = new MaxFullscreenAdImpl(str.trim(), MaxAdFormat.REWARDED, this, "MaxRewardedAd", appLovinSdk.a(), context);
    }

    public static MaxRewardedAd getInstance(String str, Context context) {
        return getInstance(str, AppLovinSdk.getInstance(context), context);
    }

    public void destroy() {
        this.f65516a.logApiCall("destroy()");
        synchronized (f65514c) {
            f65513b.remove(this.f65516a.getAdUnitId());
        }
        this.f65516a.destroy();
    }

    @Override // com.applovin.impl.mediation.ads.MaxFullscreenAdImpl.b
    public Activity getActivity() {
        this.f65516a.logApiCall("getActivity()");
        return (Activity) f65515d.get();
    }

    public String getAdUnitId() {
        return this.f65516a.getAdUnitId();
    }

    public boolean isReady() {
        boolean zIsReady = this.f65516a.isReady();
        this.f65516a.logApiCall("isReady() " + zIsReady + " for ad unit id " + this.f65516a.getAdUnitId());
        return zIsReady;
    }

    public void loadAd() {
        this.f65516a.logApiCall("loadAd()");
        this.f65516a.loadAd();
    }

    public void setAdReviewListener(MaxAdReviewListener maxAdReviewListener) {
        this.f65516a.logApiCall("setAdReviewListener(listener=" + maxAdReviewListener + ")");
        this.f65516a.setAdReviewListener(maxAdReviewListener);
    }

    public void setExpirationListener(MaxAdExpirationListener maxAdExpirationListener) {
        this.f65516a.logApiCall("setExpirationListener(listener=" + maxAdExpirationListener + ")");
        this.f65516a.setExpirationListener(maxAdExpirationListener);
    }

    public void setExtraParameter(String str, String str2) {
        this.f65516a.logApiCall("setExtraParameter(key=" + str + ", value=" + str2 + ")");
        this.f65516a.setExtraParameter(str, str2);
    }

    public void setListener(MaxRewardedAdListener maxRewardedAdListener) {
        this.f65516a.logApiCall("setListener(listener=" + maxRewardedAdListener + ")");
        this.f65516a.setListener(maxRewardedAdListener);
    }

    public void setLocalExtraParameter(String str, Object obj) {
        this.f65516a.logApiCall("setLocalExtraParameter(key=" + str + ", value=" + obj + ")");
        this.f65516a.setLocalExtraParameter(str, obj);
    }

    public void setRequestListener(MaxAdRequestListener maxAdRequestListener) {
        this.f65516a.logApiCall("setRequestListener(listener=" + maxAdRequestListener + ")");
        this.f65516a.setRequestListener(maxAdRequestListener);
    }

    public void setRevenueListener(MaxAdRevenueListener maxAdRevenueListener) {
        this.f65516a.logApiCall("setRevenueListener(listener=" + maxAdRevenueListener + ")");
        this.f65516a.setRevenueListener(maxAdRevenueListener);
    }

    public void showAd(Activity activity) {
        showAd((String) null, activity);
    }

    public String toString() {
        return "" + this.f65516a;
    }

    public static MaxRewardedAd getInstance(String str, AppLovinSdk appLovinSdk, Context context) {
        a.logApiCall("MaxRewardedAd", "getInstance(adUnitId=" + str + ", sdk=" + appLovinSdk + ", context=" + context + ")");
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
            f65515d = new WeakReference((Activity) context);
        }
        synchronized (f65514c) {
            try {
                Map map = f65513b;
                MaxRewardedAd maxRewardedAd = (MaxRewardedAd) map.get(str);
                if (maxRewardedAd != null) {
                    return maxRewardedAd;
                }
                MaxRewardedAd maxRewardedAd2 = new MaxRewardedAd(str, appLovinSdk, context);
                map.put(str, maxRewardedAd2);
                return maxRewardedAd2;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void showAd(String str, Activity activity) {
        showAd(str, (String) null, activity);
    }

    public void showAd(String str, String str2, Activity activity) {
        this.f65516a.logApiCall("showAd(placement=" + str + ", customData=" + str2 + ", activity=" + activity + ")");
        yp.b(str2, "MaxRewardedAd");
        this.f65516a.showAd(str, str2, activity);
    }

    public void showAd(ViewGroup viewGroup, Lifecycle lifecycle, Activity activity) {
        showAd((String) null, viewGroup, lifecycle, activity);
    }

    public void showAd(String str, ViewGroup viewGroup, Lifecycle lifecycle, Activity activity) {
        showAd(str, null, viewGroup, lifecycle, activity);
    }

    public void showAd(String str, String str2, ViewGroup viewGroup, Lifecycle lifecycle, Activity activity) {
        this.f65516a.logApiCall("showAd(placement=" + str + ", customData=" + str2 + ", containerView=" + viewGroup + ", lifecycle=" + lifecycle + ", activity=" + activity + ")");
        this.f65516a.showAd(str, str2, viewGroup, lifecycle, activity);
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
        this.f65516a.logApiCall("showAd(placement=" + str + ", customData=" + str2 + ")");
        yp.b(str2, "MaxRewardedAd");
        this.f65516a.showAd(str, str2, getActivity());
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
        this.f65516a.logApiCall("showAd(placement=" + str + ", customData=" + str2 + ", containerView=" + viewGroup + ", lifecycle=" + lifecycle + ")");
        this.f65516a.showAd(str, str2, viewGroup, lifecycle, getActivity());
    }
}
