package com.applovin.impl;

import android.text.TextUtils;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.sdk.R;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class n4 {
    private static List a(int i3, com.applovin.impl.sdk.j jVar) {
        String strA = yp.a(i3, com.applovin.impl.sdk.j.m(), jVar);
        if (TextUtils.isEmpty(strA)) {
            throw new IllegalStateException("Unable to retrieve consent flow data! Please ensure that the AppLovin SDK resources are bundled correctly!");
        }
        JSONObject jSONObjectJsonObjectFromJsonString = JsonUtils.jsonObjectFromJsonString(strA, null);
        if (jSONObjectJsonObjectFromJsonString == null) {
            throw new IllegalStateException("Unable to parse consent flow data! Please ensure that the AppLovin SDK resources are bundled correctly!");
        }
        JSONArray jSONArray = JsonUtils.getJSONArray(jSONObjectJsonObjectFromJsonString, "states", new JSONArray());
        ArrayList arrayList = new ArrayList();
        for (int i4 = 0; i4 < jSONArray.length(); i4++) {
            arrayList.add(i4.a(JsonUtils.getJSONObject(jSONArray, i4, new JSONObject()), jVar));
        }
        return arrayList;
    }

    public static List b(com.applovin.impl.sdk.j jVar) {
        return a(R.raw.applovin_consent_flow_terms_of_service_and_privacy_policy, jVar);
    }

    public static List c(com.applovin.impl.sdk.j jVar) {
        return a(R.raw.applovin_consent_flow_unified_cmp, jVar);
    }

    public static List a(com.applovin.impl.sdk.j jVar) {
        return a(R.raw.applovin_consent_flow_privacy_policy, jVar);
    }
}
