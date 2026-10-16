package com.applovin.impl;

import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class ln extends mn {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final he f61248h;

    public ln(he heVar, com.applovin.impl.sdk.j jVar) {
        super("TaskValidateMaxReward", jVar);
        this.f61248h = heVar;
    }

    @Override // com.applovin.impl.mn
    protected void a(eh ehVar) {
        this.f61248h.a(ehVar);
    }

    @Override // com.applovin.impl.in
    protected String f() {
        return "2.0/mvr";
    }

    @Override // com.applovin.impl.mn
    protected boolean h() {
        return this.f61248h.r0();
    }

    @Override // com.applovin.impl.in
    protected void a(int i3) {
        super.a(i3);
        this.f61248h.a(eh.a((i3 < 400 || i3 >= 500) ? "network_timeout" : "rejected"));
    }

    @Override // com.applovin.impl.in
    protected void a(JSONObject jSONObject) {
        JsonUtils.putString(jSONObject, "ad_unit_id", this.f61248h.getAdUnitId());
        JsonUtils.putString(jSONObject, "placement", this.f61248h.getPlacement());
        JsonUtils.putString(jSONObject, "custom_data", this.f61248h.e());
        JsonUtils.putString(jSONObject, "ad_format", this.f61248h.getFormat().getLabel());
        String strO0 = this.f61248h.o0();
        if (!StringUtils.isValidString(strO0)) {
            strO0 = "NO_MCODE";
        }
        JsonUtils.putString(jSONObject, "mcode", strO0);
        String strB = this.f61248h.B();
        if (!StringUtils.isValidString(strB)) {
            strB = "NO_BCODE";
        }
        JsonUtils.putString(jSONObject, "bcode", strB);
    }
}
