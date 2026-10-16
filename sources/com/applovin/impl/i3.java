package com.applovin.impl;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
abstract class i3 {
    private static String a(String str) {
        return str.replace('+', '-').replace('/', '_');
    }

    private static String b(String str) {
        return str.replace('-', '+').replace('_', '/');
    }

    public static byte[] a(byte[] bArr) {
        return xp.f65027a >= 27 ? bArr : xp.c(a(xp.a(bArr)));
    }

    public static byte[] b(byte[] bArr) {
        if (xp.f65027a >= 27) {
            return bArr;
        }
        try {
            JSONObject jSONObject = new JSONObject(xp.a(bArr));
            StringBuilder sb = new StringBuilder("{\"keys\":[");
            JSONArray jSONArray = jSONObject.getJSONArray("keys");
            for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                if (i3 != 0) {
                    sb.append(",");
                }
                JSONObject jSONObject2 = jSONArray.getJSONObject(i3);
                sb.append("{\"k\":\"");
                sb.append(b(jSONObject2.getString("k")));
                sb.append("\",\"kid\":\"");
                sb.append(b(jSONObject2.getString("kid")));
                sb.append("\",\"kty\":\"");
                sb.append(jSONObject2.getString("kty"));
                sb.append("\"}");
            }
            sb.append("]}");
            return xp.c(sb.toString());
        } catch (JSONException e3) {
            oc.a("ClearKeyUtil", "Failed to adjust response data: " + xp.a(bArr), e3);
            return bArr;
        }
    }
}
