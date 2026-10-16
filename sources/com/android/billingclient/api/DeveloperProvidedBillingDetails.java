package com.android.billingclient.api;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class DeveloperProvidedBillingDetails {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f57242a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final JSONObject f57243b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final List f57244c;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static class Product {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f57245a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f57246b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final String f57247c;

        /* synthetic */ Product(JSONObject jSONObject, zzdj zzdjVar) {
            this.f57245a = jSONObject.optString("productId");
            this.f57246b = jSONObject.optString("productType");
            String strOptString = jSONObject.optString("offerToken");
            this.f57247c = true == strOptString.isEmpty() ? null : strOptString;
        }

        public String a() {
            return this.f57245a;
        }

        public String b() {
            return this.f57247c;
        }

        public String c() {
            return this.f57246b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Product)) {
                return false;
            }
            Product product = (Product) obj;
            return this.f57245a.equals(product.a()) && this.f57246b.equals(product.c()) && Objects.equals(this.f57247c, product.b());
        }

        public int hashCode() {
            return Objects.hash(this.f57245a, this.f57246b, this.f57247c);
        }

        public String toString() {
            return String.format("{id: %s, type: %s, offer token: %s}", this.f57245a, this.f57246b, this.f57247c);
        }
    }

    DeveloperProvidedBillingDetails(String str) {
        this.f57242a = str;
        JSONObject jSONObject = new JSONObject(str);
        this.f57243b = jSONObject;
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("products");
        ArrayList arrayList = new ArrayList();
        if (jSONArrayOptJSONArray != null) {
            for (int i3 = 0; i3 < jSONArrayOptJSONArray.length(); i3++) {
                JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i3);
                if (jSONObjectOptJSONObject != null) {
                    arrayList.add(new Product(jSONObjectOptJSONObject, null));
                }
            }
        }
        this.f57244c = arrayList;
    }
}
