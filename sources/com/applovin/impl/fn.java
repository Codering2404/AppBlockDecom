package com.applovin.impl;

import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class fn extends gn {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final he f59731h;

    public fn(he heVar, com.applovin.impl.sdk.j jVar) {
        super("TaskReportMaxReward", jVar);
        this.f59731h = heVar;
    }

    @Override // com.applovin.impl.in
    protected void a(int i3) {
        super.a(i3);
        if (com.applovin.impl.sdk.n.a()) {
            this.f65233c.a(this.f65232b, "Failed to report reward for mediated ad: " + this.f59731h + " - error code: " + i3);
        }
    }

    @Override // com.applovin.impl.gn
    protected void b(JSONObject jSONObject) {
        if (com.applovin.impl.sdk.n.a()) {
            this.f65233c.a(this.f65232b, "Reported reward successfully for mediated ad: " + this.f59731h);
        }
    }

    @Override // com.applovin.impl.in
    protected String f() {
        return "2.0/mcr";
    }

    @Override // com.applovin.impl.gn
    protected eh h() {
        return this.f59731h.k0();
    }

    @Override // com.applovin.impl.gn
    protected void i() {
        if (com.applovin.impl.sdk.n.a()) {
            this.f65233c.b(this.f65232b, "No reward result was found for mediated ad: " + this.f59731h);
        }
    }

    @Override // com.applovin.impl.in
    protected void a(JSONObject jSONObject) {
        JsonUtils.putString(jSONObject, "ad_unit_id", this.f59731h.getAdUnitId());
        JsonUtils.putString(jSONObject, "placement", this.f59731h.getPlacement());
        JsonUtils.putString(jSONObject, "custom_data", this.f59731h.e());
        String strO0 = this.f59731h.o0();
        if (!StringUtils.isValidString(strO0)) {
            strO0 = "NO_MCODE";
        }
        JsonUtils.putString(jSONObject, "mcode", strO0);
        String strB = this.f59731h.B();
        if (!StringUtils.isValidString(strB)) {
            strB = "NO_BCODE";
        }
        JsonUtils.putString(jSONObject, "bcode", strB);
    }
}
