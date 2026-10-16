package com.applovin.impl;

import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.mediation.AppLovinUtils;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class en extends gn {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final com.applovin.impl.sdk.ad.b f59525h;

    public en(com.applovin.impl.sdk.ad.b bVar, com.applovin.impl.sdk.j jVar) {
        super("TaskReportAppLovinReward", jVar);
        this.f59525h = bVar;
    }

    @Override // com.applovin.impl.in
    protected void a(int i3) {
        super.a(i3);
        if (com.applovin.impl.sdk.n.a()) {
            this.f65233c.b(this.f65232b, "Failed to report reward for ad: " + this.f59525h + " - error code: " + i3);
        }
    }

    @Override // com.applovin.impl.gn
    protected void b(JSONObject jSONObject) {
        if (com.applovin.impl.sdk.n.a()) {
            this.f65233c.a(this.f65232b, "Reported reward successfully for ad: " + this.f59525h);
        }
    }

    @Override // com.applovin.impl.in
    protected String f() {
        return "2.0/cr";
    }

    @Override // com.applovin.impl.gn
    protected eh h() {
        return this.f59525h.f();
    }

    @Override // com.applovin.impl.gn
    protected void i() {
        if (com.applovin.impl.sdk.n.a()) {
            this.f65233c.b(this.f65232b, "No reward result was found for ad: " + this.f59525h);
        }
    }

    @Override // com.applovin.impl.in
    protected void a(JSONObject jSONObject) {
        JsonUtils.putString(jSONObject, AppLovinUtils.ServerParameterKeys.ZONE_ID, this.f59525h.getAdZone().e());
        JsonUtils.putInt(jSONObject, "fire_percent", this.f59525h.W());
        String clCode = this.f59525h.getClCode();
        if (!StringUtils.isValidString(clCode)) {
            clCode = "NO_CLCODE";
        }
        JsonUtils.putString(jSONObject, "clcode", clCode);
    }
}
