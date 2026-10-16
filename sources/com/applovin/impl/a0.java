package com.applovin.impl;

import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.mediation.MaxAdFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class a0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f58136a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f58137b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final kr f58138c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final List f58139d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final List f58140e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f58141f = false;

    a0(JSONObject jSONObject, Map map, MaxAdFormat maxAdFormat, com.applovin.impl.sdk.j jVar) {
        this.f58136a = JsonUtils.getString(jSONObject, "name", "");
        this.f58137b = JsonUtils.getString(jSONObject, "experiment", null);
        this.f58138c = a(jSONObject);
        this.f58139d = a("bidders", jSONObject, map, maxAdFormat, jVar);
        this.f58140e = a("waterfall", jSONObject, map, maxAdFormat, jVar);
    }

    public List a() {
        return this.f58139d;
    }

    public String b() {
        return this.f58137b;
    }

    public String c() {
        return this.f58136a;
    }

    public kr d() {
        return this.f58138c;
    }

    public List e() {
        return this.f58140e;
    }

    public boolean f() {
        return this.f58141f;
    }

    private List a(String str, JSONObject jSONObject, Map map, MaxAdFormat maxAdFormat, com.applovin.impl.sdk.j jVar) {
        je jeVar;
        ArrayList arrayList = new ArrayList();
        JSONArray jSONArray = JsonUtils.getJSONArray(jSONObject, str, new JSONArray());
        for (int i3 = 0; i3 < jSONArray.length(); i3++) {
            JSONObject jSONObject2 = JsonUtils.getJSONObject(jSONArray, i3, (JSONObject) null);
            if (jSONObject2 != null && (jeVar = (je) map.get(JsonUtils.getString(jSONObject2, "adapter_class", ""))) != null) {
                if (jeVar.C()) {
                    this.f58141f = true;
                }
                arrayList.add(new ir(jSONObject2, maxAdFormat, jeVar, jVar));
            }
        }
        return arrayList;
    }

    private kr a(JSONObject jSONObject) {
        return new kr(JsonUtils.getJSONObject(jSONObject, "targeting"));
    }
}
