package com.applovin.impl;

import com.applovin.impl.sdk.AppLovinError;
import com.applovin.sdk.AppLovinAdLoadListener;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class om extends hm {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final AppLovinAdLoadListener f62348j;

    public om(h0 h0Var, AppLovinAdLoadListener appLovinAdLoadListener, com.applovin.impl.sdk.j jVar) {
        this(h0Var, appLovinAdLoadListener, "TaskFetchNextAd", jVar);
    }

    @Override // com.applovin.impl.hm
    protected void a(int i3, String str) {
        super.a(i3, str);
        AppLovinAdLoadListener appLovinAdLoadListener = this.f62348j;
        if (!(appLovinAdLoadListener instanceof qb)) {
            appLovinAdLoadListener.failedToReceiveAd(i3);
        } else {
            ((qb) this.f62348j).failedToReceiveAdV2(new AppLovinError(i3, str));
        }
    }

    @Override // com.applovin.impl.hm
    protected String e() {
        return e4.a(this.f65231a);
    }

    @Override // com.applovin.impl.hm
    protected String f() {
        return e4.b(this.f65231a);
    }

    public om(h0 h0Var, AppLovinAdLoadListener appLovinAdLoadListener, String str, com.applovin.impl.sdk.j jVar) {
        super(h0Var, str, jVar);
        this.f62348j = appLovinAdLoadListener;
    }

    @Override // com.applovin.impl.hm
    protected yl a(JSONObject jSONObject) {
        return new um(jSONObject, this.f60223h, this.f62348j, this.f65231a);
    }
}
