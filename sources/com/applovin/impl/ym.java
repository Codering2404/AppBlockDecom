package com.applovin.impl;

import com.applovin.impl.sdk.AppLovinError;
import com.applovin.impl.sdk.nativeAd.AppLovinNativeAdLoadListener;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.mediation.MaxAdFormat;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class ym extends yl {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final JSONObject f65237h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final AppLovinNativeAdLoadListener f65238i;

    public ym(JSONObject jSONObject, AppLovinNativeAdLoadListener appLovinNativeAdLoadListener, com.applovin.impl.sdk.j jVar) {
        super("TaskProcessNativeAdResponse", jVar);
        this.f65237h = jSONObject;
        this.f65238i = appLovinNativeAdLoadListener;
    }

    @Override // java.lang.Runnable
    public void run() {
        JSONArray jSONArray = JsonUtils.getJSONArray(this.f65237h, "ads", new JSONArray());
        if (jSONArray.length() > 0) {
            if (com.applovin.impl.sdk.n.a()) {
                this.f65233c.a(this.f65232b, "Processing ad...");
            }
            this.f65231a.i0().a(new com.applovin.impl.sdk.nativeAd.b(JsonUtils.getJSONObject(jSONArray, 0, new JSONObject()), this.f65237h, this.f65238i, this.f65231a));
            return;
        }
        if (com.applovin.impl.sdk.n.a()) {
            this.f65233c.k(this.f65232b, "No ads were returned from the server");
        }
        yp.a("native_native", MaxAdFormat.NATIVE, this.f65237h, this.f65231a);
        this.f65238i.onNativeAdLoadFailed(AppLovinError.NO_FILL);
    }
}
