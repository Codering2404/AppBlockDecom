package com.android.billingclient.api;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class UserChoiceDetails {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f57361a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final JSONObject f57362b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final List f57363c;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static class Product {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f57364a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f57365b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final String f57366c;

        public String a() {
            return this.f57364a;
        }

        public String b() {
            return this.f57366c;
        }

        public String c() {
            return this.f57365b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Product)) {
                return false;
            }
            Product product = (Product) obj;
            return this.f57364a.equals(product.a()) && this.f57365b.equals(product.c()) && Objects.equals(this.f57366c, product.b());
        }

        public int hashCode() {
            return Objects.hash(this.f57364a, this.f57365b, this.f57366c);
        }

        public String toString() {
            return String.format("{id: %s, type: %s, offer token: %s}", this.f57364a, this.f57365b, this.f57366c);
        }

        private Product(JSONObject jSONObject) {
            this.f57364a = jSONObject.optString("productId");
            this.f57365b = jSONObject.optString("productType");
            String strOptString = jSONObject.optString("offerToken");
            this.f57366c = true == strOptString.isEmpty() ? null : strOptString;
        }
    }

    UserChoiceDetails(String str) {
        this.f57361a = str;
        JSONObject jSONObject = new JSONObject(str);
        this.f57362b = jSONObject;
        this.f57363c = a(jSONObject.optJSONArray("products"));
    }

    private static List a(JSONArray jSONArray) {
        ArrayList arrayList = new ArrayList();
        if (jSONArray != null) {
            for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i3);
                if (jSONObjectOptJSONObject != null) {
                    arrayList.add(new Product(jSONObjectOptJSONObject));
                }
            }
        }
        return arrayList;
    }
}
