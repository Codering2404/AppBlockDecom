package com.applovin.impl;

import com.applovin.sdk.AppLovinAdLoadListener;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class qm extends om {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final w f62648k;

    public qm(w wVar, AppLovinAdLoadListener appLovinAdLoadListener, com.applovin.impl.sdk.j jVar) {
        super(h0.a("adtoken_zone"), appLovinAdLoadListener, "TaskFetchTokenAd", jVar);
        this.f62648k = wVar;
    }

    @Override // com.applovin.impl.hm
    protected Map h() {
        HashMap map = new HashMap(2);
        map.put("adtoken", this.f62648k.b());
        map.put("adtoken_prefix", this.f62648k.d());
        return map;
    }
}
