package com.applovin.impl;

import com.applovin.impl.sdk.utils.JsonUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class cq implements hh {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List f59017a;

    private cq(List list) {
        this.f59017a = list;
    }

    public static cq a(es esVar, cq cqVar, eq eqVar, com.applovin.impl.sdk.j jVar) {
        try {
            List listB = cqVar != null ? cqVar.b() : new ArrayList();
            Iterator it = esVar.a("Verification").iterator();
            while (it.hasNext()) {
                bq bqVarA = bq.a((es) it.next(), eqVar, jVar);
                if (bqVarA != null) {
                    listB.add(bqVarA);
                }
            }
            return new cq(listB);
        } catch (Throwable th) {
            jVar.I();
            if (com.applovin.impl.sdk.n.a()) {
                jVar.I().a("VastAdVerifications", "Error occurred while initializing", th);
            }
            jVar.D().a("VastAdVerifications", th);
            return null;
        }
    }

    public List b() {
        return this.f59017a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof cq) {
            return this.f59017a.equals(((cq) obj).f59017a);
        }
        return false;
    }

    public int hashCode() {
        return this.f59017a.hashCode();
    }

    public String toString() {
        return "VastAdVerification{verifications='" + this.f59017a + "'}";
    }

    static cq a(JSONObject jSONObject, com.applovin.impl.sdk.j jVar) {
        if (jSONObject == null) {
            return null;
        }
        JSONArray jSONArray = JsonUtils.getJSONArray(jSONObject, "verifications", new JSONArray());
        ArrayList arrayList = new ArrayList();
        for (int i3 = 0; i3 < jSONArray.length(); i3++) {
            bq bqVarA = bq.a(JsonUtils.getJSONObject(jSONArray, i3, (JSONObject) null), jVar);
            if (bqVarA != null) {
                arrayList.add(bqVarA);
            }
        }
        return new cq(arrayList);
    }

    @Override // com.applovin.impl.hh
    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        if (this.f59017a != null) {
            JSONArray jSONArray = new JSONArray();
            Iterator it = this.f59017a.iterator();
            while (it.hasNext()) {
                jSONArray.put(((bq) it.next()).a());
            }
            JsonUtils.putJsonArray(jSONObject, "verifications", jSONArray);
        }
        return jSONObject;
    }
}
