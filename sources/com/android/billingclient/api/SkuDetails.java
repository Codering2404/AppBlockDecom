package com.android.billingclient.api;

import android.text.TextUtils;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
@Deprecated
public class SkuDetails {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f57354a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final JSONObject f57355b;

    public String a() {
        return this.f57355b.optString("productId");
    }

    public String b() {
        return this.f57355b.optString("type");
    }

    public int c() {
        return this.f57355b.optInt("offer_type");
    }

    public String d() {
        return this.f57355b.optString("offer_id");
    }

    public String e() {
        JSONObject jSONObject = this.f57355b;
        String strOptString = jSONObject.optString("offerIdToken");
        return strOptString.isEmpty() ? jSONObject.optString("offer_id_token") : strOptString;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof SkuDetails) {
            return TextUtils.equals(this.f57354a, ((SkuDetails) obj).f57354a);
        }
        return false;
    }

    public final String f() {
        return this.f57355b.optString("packageName");
    }

    public String g() {
        return this.f57355b.optString("serializedDocid");
    }

    final String h() {
        return this.f57355b.optString("skuDetailsToken");
    }

    public int hashCode() {
        return this.f57354a.hashCode();
    }

    public String toString() {
        return "SkuDetails: ".concat(String.valueOf(this.f57354a));
    }
}
