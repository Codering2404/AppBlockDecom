package com.applovin.impl;

import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class jq implements hh {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f60809a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f60810b;

    private jq() {
    }

    public static jq a(es esVar, jq jqVar, com.applovin.impl.sdk.j jVar) {
        if (esVar == null) {
            throw new IllegalArgumentException("No node specified.");
        }
        if (jVar == null) {
            throw new IllegalArgumentException("No sdk specified.");
        }
        if (jqVar == null) {
            try {
                jqVar = new jq();
            } catch (Throwable th) {
                jVar.I();
                if (com.applovin.impl.sdk.n.a()) {
                    jVar.I().a("VastSystemInfo", "Error occurred while initializing", th);
                }
                jVar.D().a("VastSystemInfo", th);
                return null;
            }
        }
        if (!StringUtils.isValidString(jqVar.f60809a)) {
            String strD = esVar.d();
            if (StringUtils.isValidString(strD)) {
                jqVar.f60809a = strD;
            }
        }
        if (!StringUtils.isValidString(jqVar.f60810b)) {
            String str = (String) esVar.a().get("version");
            if (StringUtils.isValidString(str)) {
                jqVar.f60810b = str;
            }
        }
        return jqVar;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof jq)) {
            return false;
        }
        jq jqVar = (jq) obj;
        String str = this.f60809a;
        if (str == null ? jqVar.f60809a != null : !str.equals(jqVar.f60809a)) {
            return false;
        }
        String str2 = this.f60810b;
        String str3 = jqVar.f60810b;
        return str2 != null ? str2.equals(str3) : str3 == null;
    }

    public int hashCode() {
        String str = this.f60809a;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.f60810b;
        return iHashCode + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        return "VastSystemInfo{name='" + this.f60809a + "', version='" + this.f60810b + "'}";
    }

    public static jq a(JSONObject jSONObject, com.applovin.impl.sdk.j jVar) {
        if (jSONObject == null) {
            return null;
        }
        jq jqVar = new jq();
        jqVar.f60809a = JsonUtils.getString(jSONObject, "name", null);
        jqVar.f60810b = JsonUtils.getString(jSONObject, "version", null);
        return jqVar;
    }

    @Override // com.applovin.impl.hh
    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        JsonUtils.putString(jSONObject, "name", this.f60809a);
        JsonUtils.putString(jSONObject, "version", this.f60810b);
        return jSONObject;
    }
}
