package com.applovin.impl;

import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.mediation.MaxAdFormat;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class ir {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ic f60529a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final cg f60530b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final List f60531c;

    public ir(JSONObject jSONObject, MaxAdFormat maxAdFormat, je jeVar, com.applovin.impl.sdk.j jVar) {
        JSONObject jSONObject2 = JsonUtils.getJSONObject(jSONObject, "bidder_placement", (JSONObject) null);
        if (jSONObject2 != null) {
            this.f60530b = new cg(jSONObject2, jVar);
        } else {
            this.f60530b = null;
        }
        this.f60529a = new ic(JsonUtils.getString(jSONObject, "name", ""), JsonUtils.getString(jSONObject, "display_name", ""), jSONObject2 != null, jeVar);
        JSONArray jSONArray = JsonUtils.getJSONArray(jSONObject, "placements", new JSONArray());
        this.f60531c = new ArrayList(jSONArray.length());
        for (int i3 = 0; i3 < jSONArray.length(); i3++) {
            JSONObject jSONObject3 = JsonUtils.getJSONObject(jSONArray, i3, (JSONObject) null);
            if (jSONObject3 != null) {
                this.f60531c.add(new cg(jSONObject3, jVar));
            }
        }
    }

    public cg a() {
        return this.f60530b;
    }

    public ic b() {
        return this.f60529a;
    }

    public List c() {
        return this.f60531c;
    }

    public boolean d() {
        return this.f60530b != null;
    }
}
