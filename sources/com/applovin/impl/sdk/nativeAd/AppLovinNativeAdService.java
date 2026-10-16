package com.applovin.impl.sdk.nativeAd;

import android.text.TextUtils;
import com.applovin.impl.e4;
import com.applovin.impl.fc;
import com.applovin.impl.nm;
import com.applovin.impl.sdk.AppLovinError;
import com.applovin.impl.sdk.n;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.tm;
import com.applovin.impl.w;
import com.applovin.impl.yl;
import com.applovin.impl.ym;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class AppLovinNativeAdService {
    private static final String TAG = "AppLovinNativeAdService";
    private final n logger;
    private final com.applovin.impl.sdk.j sdk;

    public AppLovinNativeAdService(com.applovin.impl.sdk.j jVar) {
        this.sdk = jVar;
        this.logger = jVar.I();
    }

    public void loadNextAdForAdToken(String str, AppLovinNativeAdLoadListener appLovinNativeAdLoadListener) {
        String strTrim = str != null ? str.trim() : null;
        if (TextUtils.isEmpty(strTrim)) {
            n.h(TAG, "Empty ad token");
            fc.b(appLovinNativeAdLoadListener, new AppLovinError(-8, "Empty ad token"));
            return;
        }
        w wVar = new w(strTrim, this.sdk);
        if (wVar.c() == w.a.REGULAR) {
            if (n.a()) {
                this.logger.a(TAG, "Loading next ad for token: " + wVar);
            }
            this.sdk.i0().a((yl) new nm(wVar, appLovinNativeAdLoadListener, this.sdk), tm.b.CORE);
            return;
        }
        if (wVar.c() != w.a.AD_RESPONSE_JSON) {
            AppLovinError appLovinError = new AppLovinError(-8, "Invalid token type");
            n.h(TAG, "Invalid token type");
            fc.b(appLovinNativeAdLoadListener, appLovinError);
            return;
        }
        JSONObject jSONObjectA = wVar.a();
        if (jSONObjectA == null) {
            String str2 = "Unable to retrieve ad response JSON from token: " + wVar.b();
            AppLovinError appLovinError2 = new AppLovinError(-8, str2);
            n.h(TAG, str2);
            fc.b(appLovinNativeAdLoadListener, appLovinError2);
            return;
        }
        e4.c(jSONObjectA, this.sdk);
        e4.b(jSONObjectA, this.sdk);
        e4.a(jSONObjectA, this.sdk);
        if (JsonUtils.getJSONArray(jSONObjectA, "ads", new JSONArray()).length() > 0) {
            if (n.a()) {
                this.logger.a(TAG, "Rendering ad for token: " + wVar);
            }
            this.sdk.i0().a((yl) new ym(jSONObjectA, appLovinNativeAdLoadListener, this.sdk), tm.b.CORE);
            return;
        }
        if (n.a()) {
            this.logger.b(TAG, "No ad returned from the server for token: " + wVar);
        }
        fc.b(appLovinNativeAdLoadListener, AppLovinError.NO_FILL);
    }
}
