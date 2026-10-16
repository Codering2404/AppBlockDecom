package com.applovin.impl;

import android.text.TextUtils;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.mediation.AppLovinUtils;
import com.applovin.mediation.MaxAdFormat;
import com.applovin.sdk.AppLovinAdSize;
import com.applovin.sdk.AppLovinAdType;
import com.facebook.appevents.AppEventsConstants;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Locale;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class h0 {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final Map f60073e = new HashMap();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final Object f60074f = new Object();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private JSONObject f60075a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f60076b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private AppLovinAdSize f60077c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private AppLovinAdType f60078d;

    private h0(AppLovinAdSize appLovinAdSize, AppLovinAdType appLovinAdType, String str, boolean z2, boolean z3) {
        String lowerCase;
        if (TextUtils.isEmpty(str) && (appLovinAdType == null || appLovinAdSize == null)) {
            throw new IllegalArgumentException("No zone identifier or type or size specified");
        }
        this.f60077c = appLovinAdSize;
        this.f60078d = appLovinAdType;
        if (StringUtils.isValidString(str)) {
            lowerCase = str.trim().toLowerCase(Locale.ENGLISH);
        } else {
            lowerCase = (appLovinAdSize.getLabel() + "_" + appLovinAdType.getLabel()).toLowerCase(Locale.ENGLISH);
        }
        if (z2) {
            lowerCase = lowerCase + "_bidding";
        }
        if (z3) {
            lowerCase = lowerCase + "_direct_sold";
        }
        this.f60076b = lowerCase;
    }

    public static h0 a(AppLovinAdSize appLovinAdSize, AppLovinAdType appLovinAdType) {
        return a(appLovinAdSize, appLovinAdType, null);
    }

    public static h0 b(String str) {
        return a(AppLovinAdSize.INTERSTITIAL, AppLovinAdType.INCENTIVIZED, str);
    }

    public static h0 c() {
        return a(AppLovinAdSize.BANNER, AppLovinAdType.REGULAR);
    }

    public static h0 h() {
        return a(AppLovinAdSize.INTERSTITIAL, AppLovinAdType.INCENTIVIZED);
    }

    public static h0 j() {
        return a(AppLovinAdSize.LEADER, AppLovinAdType.REGULAR);
    }

    public static h0 k() {
        return a(AppLovinAdSize.MREC, AppLovinAdType.REGULAR);
    }

    public static h0 l() {
        return a(AppLovinAdSize.NATIVE, AppLovinAdType.NATIVE);
    }

    public static h0 m() {
        return a(AppLovinAdSize.INTERSTITIAL, AppLovinAdType.REGULAR);
    }

    public MaxAdFormat d() {
        AppLovinAdSize appLovinAdSizeF = f();
        if (appLovinAdSizeF == AppLovinAdSize.BANNER) {
            return MaxAdFormat.BANNER;
        }
        if (appLovinAdSizeF == AppLovinAdSize.LEADER) {
            return MaxAdFormat.LEADER;
        }
        if (appLovinAdSizeF == AppLovinAdSize.MREC) {
            return MaxAdFormat.MREC;
        }
        if (appLovinAdSizeF != AppLovinAdSize.INTERSTITIAL) {
            if (appLovinAdSizeF == AppLovinAdSize.NATIVE) {
                return MaxAdFormat.NATIVE;
            }
            return null;
        }
        if (g() == AppLovinAdType.REGULAR) {
            return MaxAdFormat.INTERSTITIAL;
        }
        if (g() == AppLovinAdType.APP_OPEN) {
            return MaxAdFormat.APP_OPEN;
        }
        if (g() == AppLovinAdType.INCENTIVIZED) {
            return MaxAdFormat.REWARDED;
        }
        if (g() == AppLovinAdType.AUTO_INCENTIVIZED) {
            return MaxAdFormat.REWARDED_INTERSTITIAL;
        }
        return null;
    }

    public String e() {
        return this.f60076b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || h0.class != obj.getClass()) {
            return false;
        }
        return this.f60076b.equalsIgnoreCase(((h0) obj).f60076b);
    }

    public AppLovinAdSize f() {
        if (this.f60077c == null && JsonUtils.valueExists(this.f60075a, "ad_size")) {
            this.f60077c = AppLovinAdSize.fromString(JsonUtils.getString(this.f60075a, "ad_size", null));
        }
        return this.f60077c;
    }

    public AppLovinAdType g() {
        if (this.f60078d == null && JsonUtils.valueExists(this.f60075a, AppEventsConstants.EVENT_PARAM_AD_TYPE)) {
            this.f60078d = AppLovinAdType.fromString(JsonUtils.getString(this.f60075a, AppEventsConstants.EVENT_PARAM_AD_TYPE, null));
        }
        return this.f60078d;
    }

    public int hashCode() {
        return this.f60076b.hashCode();
    }

    public boolean i() {
        return a().contains(this);
    }

    public String toString() {
        return "AdZone{id=" + this.f60076b + ", zoneObject=" + this.f60075a + '}';
    }

    public static h0 a(AppLovinAdSize appLovinAdSize, AppLovinAdType appLovinAdType, String str) {
        return a(appLovinAdSize, appLovinAdType, str, false, false);
    }

    public static h0 b() {
        return a(AppLovinAdSize.INTERSTITIAL, AppLovinAdType.APP_OPEN);
    }

    public static h0 a(String str) {
        return a(null, null, str);
    }

    public static void a(JSONObject jSONObject) {
        if (jSONObject != null && jSONObject.has("ad_size") && jSONObject.has(AppEventsConstants.EVENT_PARAM_AD_TYPE)) {
            synchronized (f60074f) {
                try {
                    h0 h0Var = (h0) f60073e.get(JsonUtils.getString(jSONObject, AppLovinUtils.ServerParameterKeys.ZONE_ID, ""));
                    if (h0Var != null) {
                        h0Var.f60077c = AppLovinAdSize.fromString(JsonUtils.getString(jSONObject, "ad_size", ""));
                        h0Var.f60078d = AppLovinAdType.fromString(JsonUtils.getString(jSONObject, AppEventsConstants.EVENT_PARAM_AD_TYPE, ""));
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    public static h0 a(AppLovinAdSize appLovinAdSize, AppLovinAdType appLovinAdType, String str, boolean z2, boolean z3) {
        h0 h0Var = new h0(appLovinAdSize, appLovinAdType, str, z2, z3);
        synchronized (f60074f) {
            try {
                String str2 = h0Var.f60076b;
                Map map = f60073e;
                if (map.containsKey(str2)) {
                    h0Var = (h0) map.get(str2);
                } else {
                    map.put(str2, h0Var);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return h0Var;
    }

    public static Collection a() {
        LinkedHashSet linkedHashSet = new LinkedHashSet(7);
        Collections.addAll(linkedHashSet, c(), k(), j(), m(), b(), h(), l());
        return Collections.unmodifiableSet(linkedHashSet);
    }
}
