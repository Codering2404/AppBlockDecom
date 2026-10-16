package com.applovin.impl;

import com.applovin.impl.sdk.utils.JsonUtils;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class hq implements hh {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f60243a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f60244b;

    private hq(String str, String str2) {
        this.f60243a = str;
        this.f60244b = str2;
    }

    public static hq a(es esVar, com.applovin.impl.sdk.j jVar) {
        if (esVar == null) {
            throw new IllegalArgumentException("No node specified.");
        }
        if (jVar == null) {
            throw new IllegalArgumentException("No sdk specified.");
        }
        try {
            return new hq((String) esVar.a().get("apiFramework"), esVar.d());
        } catch (Throwable th) {
            jVar.I();
            if (com.applovin.impl.sdk.n.a()) {
                jVar.I().a("VastJavaScriptResource", "Error occurred while initializing", th);
            }
            jVar.D().a("VastJavaScriptResource", th);
            return null;
        }
    }

    public String b() {
        return this.f60243a;
    }

    public String c() {
        return this.f60244b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            hq hqVar = (hq) obj;
            String str = this.f60243a;
            if (str == null ? hqVar.f60243a != null : !str.equals(hqVar.f60243a)) {
                return false;
            }
            String str2 = this.f60244b;
            String str3 = hqVar.f60244b;
            if (str2 != null) {
                return str2.equals(str3);
            }
            if (str3 == null) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        String str = this.f60243a;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.f60244b;
        return iHashCode + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        return "VastJavaScriptResource{apiFramework='" + this.f60243a + "', javascriptResourceUrl='" + this.f60244b + "'}";
    }

    public static hq a(JSONObject jSONObject, com.applovin.impl.sdk.j jVar) {
        if (jSONObject == null) {
            return null;
        }
        return new hq(JsonUtils.getString(jSONObject, "api_framework", null), JsonUtils.getString(jSONObject, "javascript_resource_url", null));
    }

    @Override // com.applovin.impl.hh
    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        JsonUtils.putString(jSONObject, "api_framework", this.f60243a);
        JsonUtils.putString(jSONObject, "javascript_resource_url", this.f60244b);
        return jSONObject;
    }
}
