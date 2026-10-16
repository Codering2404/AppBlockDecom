package com.applovin.impl;

import com.applovin.impl.sdk.AppLovinError;
import com.applovin.impl.sdk.nativeAd.AppLovinNativeAdLoadListener;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class pm extends hm {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final AppLovinNativeAdLoadListener f62443j;

    public pm(h0 h0Var, String str, AppLovinNativeAdLoadListener appLovinNativeAdLoadListener, com.applovin.impl.sdk.j jVar) {
        super(h0Var, str, jVar);
        this.f62443j = appLovinNativeAdLoadListener;
    }

    @Override // com.applovin.impl.hm
    protected void a(int i3, String str) {
        super.a(i3, str);
        this.f62443j.onNativeAdLoadFailed(new AppLovinError(i3, str));
    }

    @Override // com.applovin.impl.hm
    protected String e() {
        return e4.d(this.f65231a);
    }

    @Override // com.applovin.impl.hm
    protected String f() {
        return e4.e(this.f65231a);
    }

    @Override // com.applovin.impl.hm
    protected yl a(JSONObject jSONObject) {
        return new ym(jSONObject, this.f62443j, this.f65231a);
    }
}
