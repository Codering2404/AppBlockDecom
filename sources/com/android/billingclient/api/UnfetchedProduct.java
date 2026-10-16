package com.android.billingclient.api;

import android.text.TextUtils;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class UnfetchedProduct {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f57356a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f57357b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f57358c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f57359d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final String f57360e;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Retention(RetentionPolicy.SOURCE)
    public @interface StatusCode {
    }

    UnfetchedProduct(String str) {
        this.f57356a = str;
        JSONObject jSONObject = new JSONObject(str);
        this.f57357b = jSONObject.optString("productId");
        String strOptString = jSONObject.optString("type");
        this.f57358c = strOptString;
        this.f57359d = jSONObject.has("statusCode") ? jSONObject.optInt("statusCode") : 0;
        if (TextUtils.isEmpty(strOptString)) {
            throw new IllegalArgumentException("Product type cannot be empty.");
        }
        this.f57360e = jSONObject.optString("serializedDocid");
    }

    public String a() {
        return this.f57357b;
    }

    public String b() {
        return this.f57358c;
    }

    public String c() {
        return this.f57360e;
    }

    public int d() {
        return this.f57359d;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof UnfetchedProduct) {
            return TextUtils.equals(this.f57356a, ((UnfetchedProduct) obj).f57356a);
        }
        return false;
    }

    public int hashCode() {
        return this.f57356a.hashCode();
    }

    public String toString() {
        return "UnfetchedProduct{productId='" + this.f57357b + "', productType='" + this.f57358c + "', statusCode=" + this.f57359d + "}";
    }
}
