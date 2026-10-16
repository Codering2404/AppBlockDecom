package com.applovin.impl;

import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.mediation.MaxAdFormat;
import com.facebook.GraphRequest;
import com.facebook.internal.AnalyticsEvents;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class z implements Comparable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f65274a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f65275b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final MaxAdFormat f65276c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final a0 f65277d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final List f65278f;

    public z(JSONObject jSONObject, Map map, com.applovin.impl.sdk.j jVar) {
        this.f65274a = JsonUtils.getString(jSONObject, "name", "");
        this.f65275b = JsonUtils.getString(jSONObject, "display_name", "");
        this.f65276c = MaxAdFormat.formatFromString(JsonUtils.getString(jSONObject, GraphRequest.FORMAT_PARAM, null));
        JSONArray jSONArray = JsonUtils.getJSONArray(jSONObject, "waterfalls", new JSONArray());
        this.f65278f = new ArrayList(jSONArray.length());
        for (int i3 = 0; i3 < jSONArray.length(); i3++) {
            JSONObject jSONObject2 = JsonUtils.getJSONObject(jSONArray, i3, (JSONObject) null);
            if (jSONObject2 != null) {
                this.f65278f.add(new a0(jSONObject2, map, this.f65276c, jVar));
            }
        }
        this.f65277d = this.f65278f.isEmpty() ? null : (a0) this.f65278f.get(0);
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(z zVar) {
        return this.f65275b.compareToIgnoreCase(zVar.f65275b);
    }

    public String b() {
        MaxAdFormat maxAdFormat = this.f65276c;
        return maxAdFormat != null ? maxAdFormat.getLabel() : AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_UNKNOWN;
    }

    public String c() {
        return this.f65274a;
    }

    public String d() {
        return this.f65275b;
    }

    public String e() {
        return "\n---------- " + this.f65275b + " ----------\nIdentifier - " + this.f65274a + "\nFormat     - " + b();
    }

    public a0 f() {
        return this.f65277d;
    }

    public List g() {
        return this.f65278f;
    }

    public MaxAdFormat a() {
        return this.f65276c;
    }
}
