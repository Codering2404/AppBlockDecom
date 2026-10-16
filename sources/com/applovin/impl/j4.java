package com.applovin.impl;

import com.applovin.impl.sdk.utils.JsonUtils;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class j4 extends i4 {
    public j4(JSONObject jSONObject, com.applovin.impl.sdk.j jVar) {
        super(jSONObject, jVar);
    }

    public List e() {
        k4 k4VarA;
        JSONArray jSONArray = JsonUtils.getJSONArray(this.f60334b, "transitions", null);
        ArrayList arrayList = new ArrayList();
        for (int i3 = 0; i3 < jSONArray.length(); i3++) {
            JSONObject jSONObject = JsonUtils.getJSONObject(jSONArray, i3, (JSONObject) null);
            if (jSONObject != null && (k4VarA = k4.a(jSONObject, this.f60333a)) != null) {
                arrayList.add(k4VarA);
            }
        }
        return arrayList;
    }

    public String f() {
        return b("message");
    }

    public String g() {
        return b("title");
    }

    @Override // com.applovin.impl.i4
    public String toString() {
        return "ConsentFlowState{id=" + b() + "type=" + c() + "isInitialState=" + d() + "title=" + g() + "message=" + f() + "actions=" + e() + "}";
    }
}
