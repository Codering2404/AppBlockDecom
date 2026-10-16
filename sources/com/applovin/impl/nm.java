package com.applovin.impl;

import com.applovin.impl.sdk.nativeAd.AppLovinNativeAdLoadListener;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class nm extends pm {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final w f62089k;

    public nm(w wVar, AppLovinNativeAdLoadListener appLovinNativeAdLoadListener, com.applovin.impl.sdk.j jVar) {
        super(h0.a("adtoken_zone"), "TaskFetchNativeTokenAd", appLovinNativeAdLoadListener, jVar);
        this.f62089k = wVar;
    }

    @Override // com.applovin.impl.hm
    protected Map h() {
        HashMap map = new HashMap(2);
        map.put("adtoken", this.f62089k.b());
        map.put("adtoken_prefix", this.f62089k.d());
        return map;
    }
}
