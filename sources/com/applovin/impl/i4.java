package com.applovin.impl;

import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import com.facebook.internal.NativeProtocol;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class i4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected final com.applovin.impl.sdk.j f60333a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected final JSONObject f60334b;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public enum a {
        NONE,
        IS_AL_GDPR
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public enum b {
        ALERT,
        EVENT,
        HAS_USER_CONSENT,
        REINIT,
        CMP_LOAD,
        CMP_SHOW,
        DECISION,
        TERMS_FLOW
    }

    public i4(JSONObject jSONObject, com.applovin.impl.sdk.j jVar) {
        this.f60333a = jVar;
        this.f60334b = jSONObject;
    }

    public static i4 a(JSONObject jSONObject, com.applovin.impl.sdk.j jVar) {
        b bVarC = c(JsonUtils.getString(jSONObject, "type", null));
        return bVarC == b.ALERT ? new j4(jSONObject, jVar) : bVarC == b.EVENT ? new l4(jSONObject, jVar) : new i4(jSONObject, jVar);
    }

    public String b() {
        return JsonUtils.getString(this.f60334b, "id", null);
    }

    public b c() {
        return c(JsonUtils.getString(this.f60334b, "type", null));
    }

    public boolean d() {
        return JsonUtils.getBoolean(this.f60334b, "is_initial_state", Boolean.FALSE).booleanValue();
    }

    public String toString() {
        return "ConsentFlowState{id=" + b() + "type=" + c() + "isInitialState=" + d() + "}";
    }

    private static b c(String str) {
        if ("alert".equalsIgnoreCase(str)) {
            return b.ALERT;
        }
        if ("event".equalsIgnoreCase(str)) {
            return b.EVENT;
        }
        if ("cmp_load".equalsIgnoreCase(str)) {
            return b.CMP_LOAD;
        }
        if ("cmp_show".equalsIgnoreCase(str)) {
            return b.CMP_SHOW;
        }
        if ("decision".equalsIgnoreCase(str)) {
            return b.DECISION;
        }
        if ("terms_flow".equalsIgnoreCase(str)) {
            return b.TERMS_FLOW;
        }
        if ("huc".equalsIgnoreCase(str)) {
            return b.HAS_USER_CONSENT;
        }
        if ("reinit".equalsIgnoreCase(str)) {
            return b.REINIT;
        }
        throw new IllegalArgumentException("Invalid type provided: " + str);
    }

    protected String b(String str) {
        JSONObject jSONObject = JsonUtils.getJSONObject(this.f60334b, str, (JSONObject) null);
        JSONArray jSONArray = JsonUtils.getJSONArray(jSONObject, "replacements", new JSONArray());
        ArrayList arrayList = new ArrayList();
        for (int i3 = 0; i3 < jSONArray.length(); i3++) {
            String string = JsonUtils.getObjectAtIndex(jSONArray, i3, "").toString();
            if ("<APP_NAME>".equalsIgnoreCase(string)) {
                String str2 = (String) this.f60333a.x().G().get(NativeProtocol.BRIDGE_ARG_APP_NAME_STRING);
                if (StringUtils.isValidString(str2)) {
                    arrayList.add(str2);
                } else {
                    arrayList.add(com.applovin.impl.sdk.j.a("THIS_APP"));
                }
            } else {
                arrayList.add(string);
            }
        }
        return com.applovin.impl.sdk.j.a(JsonUtils.getString(jSONObject, "key", null), arrayList);
    }

    public a a() {
        return a(JsonUtils.getString(this.f60334b, "decision_type", null));
    }

    public String a(Boolean bool) {
        String string = JsonUtils.getString(this.f60334b, "destination_state_id", null);
        if (StringUtils.isValidString(string)) {
            return string;
        }
        if (bool != null) {
            return bool.booleanValue() ? JsonUtils.getString(this.f60334b, "destination_state_id_true", null) : JsonUtils.getString(this.f60334b, "destination_state_id_false", null);
        }
        throw new IllegalStateException("Decision needed for state: " + string);
    }

    private static a a(String str) {
        if ("is_al_gdpr".equalsIgnoreCase(str)) {
            return a.IS_AL_GDPR;
        }
        return a.NONE;
    }
}
