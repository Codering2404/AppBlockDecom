package com.applovin.impl;

import com.applovin.impl.sdk.utils.JsonUtils;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class cg {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f58904a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f58905b;

    public cg(JSONObject jSONObject, com.applovin.impl.sdk.j jVar) {
        this.f58904a = JsonUtils.getString(jSONObject, "id", "");
        this.f58905b = JsonUtils.getString(jSONObject, "price", null);
    }

    public String a() {
        return this.f58904a;
    }

    public String b() {
        return this.f58905b;
    }
}
