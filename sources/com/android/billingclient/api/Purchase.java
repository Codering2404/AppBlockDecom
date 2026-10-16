package com.android.billingclient.api;

import android.text.TextUtils;
import com.facebook.AccessToken;
import com.facebook.appevents.internal.Constants;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class Purchase {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f57336a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f57337b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final JSONObject f57338c;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class PendingPurchaseUpdate {
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Retention(RetentionPolicy.SOURCE)
    public @interface PurchaseState {
    }

    public Purchase(String str, String str2) {
        this.f57336a = str;
        this.f57337b = str2;
        this.f57338c = new JSONObject(str);
    }

    private final ArrayList j() {
        ArrayList arrayList = new ArrayList();
        JSONObject jSONObject = this.f57338c;
        if (jSONObject.has("productIds")) {
            JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("productIds");
            if (jSONArrayOptJSONArray != null) {
                for (int i3 = 0; i3 < jSONArrayOptJSONArray.length(); i3++) {
                    arrayList.add(jSONArrayOptJSONArray.optString(i3));
                }
            }
        } else if (jSONObject.has("productId")) {
            arrayList.add(jSONObject.optString("productId"));
        }
        return arrayList;
    }

    public String a() {
        String strOptString = this.f57338c.optString("orderId");
        if (TextUtils.isEmpty(strOptString)) {
            return null;
        }
        return strOptString;
    }

    public String b() {
        return this.f57336a;
    }

    public List c() {
        return j();
    }

    public int d() {
        return this.f57338c.optInt("purchaseState", 1) != 4 ? 1 : 2;
    }

    public long e() {
        return this.f57338c.optLong(Constants.GP_IAP_PURCHASE_TIME);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Purchase)) {
            return false;
        }
        Purchase purchase = (Purchase) obj;
        return TextUtils.equals(this.f57336a, purchase.b()) && TextUtils.equals(this.f57337b, purchase.g());
    }

    public String f() {
        JSONObject jSONObject = this.f57338c;
        return jSONObject.optString(AccessToken.TOKEN_KEY, jSONObject.optString("purchaseToken"));
    }

    public String g() {
        return this.f57337b;
    }

    public boolean h() {
        return this.f57338c.optBoolean("acknowledged", true);
    }

    public int hashCode() {
        return this.f57336a.hashCode();
    }

    public boolean i() {
        return this.f57338c.optBoolean(Constants.GP_IAP_AUTORENEWING);
    }

    public String toString() {
        return "Purchase. Json: ".concat(String.valueOf(this.f57336a));
    }
}
