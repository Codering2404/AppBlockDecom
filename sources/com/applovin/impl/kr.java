package com.applovin.impl;

import com.applovin.impl.sdk.utils.JsonUtils;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class kr {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f61058a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f61059b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final List f61060c;

    public kr(JSONObject jSONObject) {
        this.f61058a = JsonUtils.getString(jSONObject, "user_type", "all");
        this.f61059b = JsonUtils.getString(jSONObject, "device_type", "all");
        this.f61060c = JsonUtils.getStringList(jSONObject, "segments", null);
    }

    public String a() {
        return this.f61058a;
    }

    public String b() {
        return this.f61059b;
    }

    public List c() {
        return this.f61060c;
    }
}
