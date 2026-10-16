package com.applovin.impl;

import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.tm;
import com.applovin.sdk.AppLovinAdLoadListener;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class bn extends yl {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final JSONObject f58736h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final JSONObject f58737i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final AppLovinAdLoadListener f58738j;

    public bn(JSONObject jSONObject, JSONObject jSONObject2, AppLovinAdLoadListener appLovinAdLoadListener, com.applovin.impl.sdk.j jVar) {
        super("TaskRenderAppLovinAd", jVar);
        this.f58736h = jSONObject;
        this.f58737i = jSONObject2;
        this.f58738j = appLovinAdLoadListener;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (com.applovin.impl.sdk.n.a()) {
            this.f65233c.a(this.f65232b, "Rendering ad...");
        }
        com.applovin.impl.sdk.ad.a aVar = new com.applovin.impl.sdk.ad.a(this.f58736h, this.f58737i, this.f65231a);
        boolean zBooleanValue = JsonUtils.getBoolean(this.f58736h, "gs_load_immediately", Boolean.FALSE).booleanValue();
        boolean zBooleanValue2 = JsonUtils.getBoolean(this.f58736h, "vs_load_immediately", Boolean.TRUE).booleanValue();
        cm cmVar = new cm(aVar, this.f65231a, this.f58738j);
        cmVar.c(zBooleanValue2);
        cmVar.b(zBooleanValue);
        this.f65231a.i0().a((yl) cmVar, tm.b.CACHING);
    }
}
