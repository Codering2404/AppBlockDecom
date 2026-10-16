package com.applovin.impl;

import com.applovin.impl.sdk.utils.JsonUtils;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class l4 extends i4 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Map f61110c;

    public l4(JSONObject jSONObject, com.applovin.impl.sdk.j jVar) {
        super(jSONObject, jVar);
    }

    public Map e() {
        return this.f61110c;
    }

    public String f() {
        return JsonUtils.getString(this.f60334b, "name", null);
    }

    @Override // com.applovin.impl.i4
    public String toString() {
        return "ConsentFlowState{id=" + b() + "type=" + c() + "isInitialState=" + d() + "name=" + f() + "}";
    }
}
