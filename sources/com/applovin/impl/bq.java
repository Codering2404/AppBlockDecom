package com.applovin.impl;

import com.applovin.impl.sdk.utils.JsonUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class bq implements hh {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f58761a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final List f58762b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f58763c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Set f58764d;

    private bq(String str, List list, String str2, Set set) {
        this.f58761a = str;
        this.f58762b = list;
        this.f58763c = str2;
        this.f58764d = set;
    }

    public static bq a(es esVar, eq eqVar, com.applovin.impl.sdk.j jVar) {
        try {
            String str = (String) esVar.a().get("vendor");
            es esVarB = esVar.b("VerificationParameters");
            String strD = esVarB != null ? esVarB.d() : null;
            List listA = esVar.a("JavaScriptResource");
            ArrayList arrayList = new ArrayList(listA.size());
            Iterator it = listA.iterator();
            while (it.hasNext()) {
                hq hqVarA = hq.a((es) it.next(), jVar);
                if (hqVarA != null) {
                    arrayList.add(hqVarA);
                }
            }
            HashMap map = new HashMap();
            mq.a(esVar, map, eqVar, jVar);
            return new bq(str, arrayList, strD, (Set) map.get("verificationNotExecuted"));
        } catch (Throwable th) {
            jVar.I();
            if (com.applovin.impl.sdk.n.a()) {
                jVar.I().a("VastAdVerification", "Error occurred while initializing", th);
            }
            jVar.D().a("VastAdVerification", th);
            return null;
        }
    }

    public Set b() {
        return this.f58764d;
    }

    public List c() {
        return this.f58762b;
    }

    public String d() {
        return this.f58761a;
    }

    public String e() {
        return this.f58763c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            bq bqVar = (bq) obj;
            String str = this.f58761a;
            if (str == null ? bqVar.f58761a != null : !str.equals(bqVar.f58761a)) {
                return false;
            }
            List list = this.f58762b;
            if (list == null ? bqVar.f58762b != null : !list.equals(bqVar.f58762b)) {
                return false;
            }
            String str2 = this.f58763c;
            if (str2 == null ? bqVar.f58763c != null : !str2.equals(bqVar.f58763c)) {
                return false;
            }
            Set set = this.f58764d;
            Set set2 = bqVar.f58764d;
            if (set != null) {
                return set.equals(set2);
            }
            if (set2 == null) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        String str = this.f58761a;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        List list = this.f58762b;
        int iHashCode2 = (iHashCode + (list != null ? list.hashCode() : 0)) * 31;
        String str2 = this.f58763c;
        int iHashCode3 = (iHashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31;
        Set set = this.f58764d;
        return iHashCode3 + (set != null ? set.hashCode() : 0);
    }

    public String toString() {
        return "VastAdVerification{vendorId='" + this.f58761a + "'javascriptResources='" + this.f58762b + "'verificationParameters='" + this.f58763c + "'errorEventTrackers='" + this.f58764d + "'}";
    }

    public static bq a(JSONObject jSONObject, com.applovin.impl.sdk.j jVar) {
        if (jSONObject == null) {
            return null;
        }
        String string = JsonUtils.getString(jSONObject, "vendor_id", null);
        JSONArray jSONArray = JsonUtils.getJSONArray(jSONObject, "javascript_resources", new JSONArray());
        ArrayList arrayList = new ArrayList();
        for (int i3 = 0; i3 < jSONArray.length(); i3++) {
            hq hqVarA = hq.a(JsonUtils.getJSONObject(jSONArray, i3, (JSONObject) null), jVar);
            if (hqVarA != null) {
                arrayList.add(hqVarA);
            }
        }
        String string2 = JsonUtils.getString(jSONObject, "verification_parameters", null);
        JSONArray jSONArray2 = JsonUtils.getJSONArray(jSONObject, "error_event_trackers", new JSONArray());
        HashSet hashSet = new HashSet();
        for (int i4 = 0; i4 < jSONArray2.length(); i4++) {
            kq kqVarA = kq.a(JsonUtils.getJSONObject(jSONArray2, i4, (JSONObject) null), jVar);
            if (kqVarA != null) {
                hashSet.add(kqVarA);
            }
        }
        return new bq(string, arrayList, string2, hashSet);
    }

    @Override // com.applovin.impl.hh
    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        JsonUtils.putString(jSONObject, "vendor_id", this.f58761a);
        if (this.f58762b != null) {
            JSONArray jSONArray = new JSONArray();
            Iterator it = this.f58762b.iterator();
            while (it.hasNext()) {
                jSONArray.put(((hq) it.next()).a());
            }
            JsonUtils.putJsonArray(jSONObject, "javascript_resources", jSONArray);
        }
        JsonUtils.putString(jSONObject, "verification_parameters", this.f58763c);
        if (this.f58764d != null) {
            JSONArray jSONArray2 = new JSONArray();
            Iterator it2 = this.f58764d.iterator();
            while (it2.hasNext()) {
                jSONArray2.put(((kq) it2.next()).a());
            }
            JsonUtils.putJsonArray(jSONObject, "error_event_trackers", jSONArray2);
        }
        return jSONObject;
    }
}
