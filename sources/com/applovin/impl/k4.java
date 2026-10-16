package com.applovin.impl;

import com.applovin.impl.sdk.utils.JsonUtils;
import com.facebook.internal.AnalyticsEvents;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class k4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.applovin.impl.sdk.j f60904a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final JSONObject f60905b;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public enum a {
        NEUTRAL,
        POSITIVE,
        NEGATIVE
    }

    private k4(JSONObject jSONObject, com.applovin.impl.sdk.j jVar) {
        this.f60904a = jVar;
        this.f60905b = jSONObject;
    }

    public static k4 a(JSONObject jSONObject, com.applovin.impl.sdk.j jVar) {
        String string = JsonUtils.getString(JsonUtils.getJSONObject(jSONObject, "title", (JSONObject) null), "key", null);
        if ("TOS".equalsIgnoreCase(string) && jVar.u().h() == null) {
            return null;
        }
        if ("PP".equalsIgnoreCase(string) && jVar.u().g() == null) {
            return null;
        }
        return new k4(jSONObject, jVar);
    }

    public String b() {
        return JsonUtils.getString(this.f60905b, "event", null);
    }

    public a c() {
        String string = JsonUtils.getString(this.f60905b, AnalyticsEvents.PARAMETER_LIKE_VIEW_STYLE, null);
        return "default".equalsIgnoreCase(string) ? a.POSITIVE : ("destructive".equalsIgnoreCase(string) || "cancel".equalsIgnoreCase(string)) ? a.NEGATIVE : a.NEUTRAL;
    }

    public String d() {
        JSONObject jSONObject = JsonUtils.getJSONObject(this.f60905b, "title", (JSONObject) null);
        return com.applovin.impl.sdk.j.a(JsonUtils.getString(jSONObject, "key", ""), JsonUtils.optList(JsonUtils.getJSONArray(jSONObject, "replacements", null), null));
    }

    public String toString() {
        return "ConsentFlowStateAlertAction{title=" + d() + "destinationStateId=" + a() + "event=" + b() + "}";
    }

    public String a() {
        return JsonUtils.getString(this.f60905b, "destination_state_id", null);
    }
}
