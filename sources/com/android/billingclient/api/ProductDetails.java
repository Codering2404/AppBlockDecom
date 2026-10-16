package com.android.billingclient.api;

import android.text.TextUtils;
import com.facebook.appevents.internal.Constants;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class ProductDetails {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f57267a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final JSONObject f57268b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f57269c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f57270d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final String f57271e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final String f57272f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final String f57273g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final String f57274h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final String f57275i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final List f57276j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final List f57277k;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class InstallmentPlanDetails {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f57278a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f57279b;

        InstallmentPlanDetails(JSONObject jSONObject) {
            this.f57278a = jSONObject.getInt("commitmentPaymentsCount");
            this.f57279b = jSONObject.optInt("subsequentCommitmentPaymentsCount");
        }

        public int a() {
            return this.f57278a;
        }

        public int b() {
            return this.f57279b;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class OneTimePurchaseOfferDetails {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f57280a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final long f57281b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final String f57282c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final String f57283d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final String f57284e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final String f57285f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private final List f57286g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private final Long f57287h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private final DiscountDisplayInfo f57288i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private final ValidTimeWindow f57289j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private final LimitedQuantityInfo f57290k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        private final String f57291l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        private final PreorderDetails f57292m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        private final RentalDetails f57293n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        private final zzdt f57294o;

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        public static final class DiscountDisplayInfo {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final Integer f57295a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private final DiscountAmount f57296b;

            /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
            public static final class DiscountAmount {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                private final String f57297a;

                /* JADX INFO: renamed from: b, reason: collision with root package name */
                private final long f57298b;

                /* JADX INFO: renamed from: c, reason: collision with root package name */
                private final String f57299c;

                DiscountAmount(JSONObject jSONObject) {
                    this.f57297a = jSONObject.optString("formattedDiscountAmount");
                    this.f57298b = jSONObject.optLong("discountAmountMicros");
                    this.f57299c = jSONObject.optString("discountAmountCurrencyCode");
                }
            }

            DiscountDisplayInfo(JSONObject jSONObject) {
                this.f57295a = jSONObject.has("percentageDiscount") ? Integer.valueOf(jSONObject.optInt("percentageDiscount")) : null;
                JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("discountAmount");
                this.f57296b = jSONObjectOptJSONObject != null ? new DiscountAmount(jSONObjectOptJSONObject) : null;
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        public static final class LimitedQuantityInfo {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final int f57300a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private final int f57301b;

            LimitedQuantityInfo(JSONObject jSONObject) {
                this.f57300a = jSONObject.getInt("maximumQuantity");
                this.f57301b = jSONObject.getInt("remainingQuantity");
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        public static final class PreorderDetails {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final long f57302a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private final long f57303b;

            PreorderDetails(JSONObject jSONObject) {
                this.f57302a = jSONObject.getLong("preorderReleaseTimeMillis");
                this.f57303b = jSONObject.getLong("preorderPresaleEndTimeMillis");
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        public static final class RentalDetails {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final String f57304a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private final String f57305b;

            RentalDetails(JSONObject jSONObject) {
                this.f57304a = jSONObject.getString("rentalPeriod");
                String strOptString = jSONObject.optString("rentalExpirationPeriod");
                this.f57305b = true == strOptString.isEmpty() ? null : strOptString;
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        public static final class ValidTimeWindow {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final Long f57306a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private final Long f57307b;

            ValidTimeWindow(JSONObject jSONObject) {
                this.f57306a = jSONObject.has("startTimeMillis") ? Long.valueOf(jSONObject.optLong("startTimeMillis")) : null;
                this.f57307b = jSONObject.has("endTimeMillis") ? Long.valueOf(jSONObject.optLong("endTimeMillis")) : null;
            }
        }

        OneTimePurchaseOfferDetails(JSONObject jSONObject) {
            this.f57280a = jSONObject.optString("formattedPrice");
            this.f57281b = jSONObject.optLong(Constants.GP_IAP_PRICE_AMOUNT_MICROS_V5V7);
            this.f57282c = jSONObject.optString(Constants.GP_IAP_PRICE_CURRENCY_CODE_V5V7);
            String strOptString = jSONObject.optString("offerIdToken");
            this.f57283d = true == strOptString.isEmpty() ? null : strOptString;
            String strOptString2 = jSONObject.optString(Constants.GP_IAP_OFFER_ID);
            this.f57284e = true == strOptString2.isEmpty() ? null : strOptString2;
            String strOptString3 = jSONObject.optString("purchaseOptionId");
            this.f57285f = true == strOptString3.isEmpty() ? null : strOptString3;
            jSONObject.optInt("offerType");
            JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("offerTags");
            this.f57286g = new ArrayList();
            if (jSONArrayOptJSONArray != null) {
                for (int i3 = 0; i3 < jSONArrayOptJSONArray.length(); i3++) {
                    this.f57286g.add(jSONArrayOptJSONArray.getString(i3));
                }
            }
            this.f57287h = jSONObject.has("fullPriceMicros") ? Long.valueOf(jSONObject.optLong("fullPriceMicros")) : null;
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("discountDisplayInfo");
            this.f57288i = jSONObjectOptJSONObject == null ? null : new DiscountDisplayInfo(jSONObjectOptJSONObject);
            JSONObject jSONObjectOptJSONObject2 = jSONObject.optJSONObject("validTimeWindow");
            this.f57289j = jSONObjectOptJSONObject2 == null ? null : new ValidTimeWindow(jSONObjectOptJSONObject2);
            JSONObject jSONObjectOptJSONObject3 = jSONObject.optJSONObject("limitedQuantityInfo");
            this.f57290k = jSONObjectOptJSONObject3 == null ? null : new LimitedQuantityInfo(jSONObjectOptJSONObject3);
            this.f57291l = jSONObject.optString("serializedDocid");
            JSONObject jSONObjectOptJSONObject4 = jSONObject.optJSONObject("preorderDetails");
            this.f57292m = jSONObjectOptJSONObject4 == null ? null : new PreorderDetails(jSONObjectOptJSONObject4);
            JSONObject jSONObjectOptJSONObject5 = jSONObject.optJSONObject("rentalDetails");
            this.f57293n = jSONObjectOptJSONObject5 == null ? null : new RentalDetails(jSONObjectOptJSONObject5);
            JSONObject jSONObjectOptJSONObject6 = jSONObject.optJSONObject("autoPayDetails");
            this.f57294o = jSONObjectOptJSONObject6 != null ? new zzdt(jSONObjectOptJSONObject6) : null;
            JSONArray jSONArrayOptJSONArray2 = jSONObject.optJSONArray(Constants.GP_IAP_SUBSCRIPTION_PRICING_PHASES);
            if (jSONArrayOptJSONArray2 == null) {
                return;
            }
            new PricingPhases(jSONArrayOptJSONArray2);
        }

        public String a() {
            return this.f57280a;
        }

        public String b() {
            return this.f57284e;
        }

        public String c() {
            return this.f57283d;
        }

        public long d() {
            return this.f57281b;
        }

        public String e() {
            return this.f57282c;
        }

        public String f() {
            return this.f57285f;
        }

        public final zzdt g() {
            return this.f57294o;
        }

        final String h() {
            return this.f57291l;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class PricingPhase {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f57308a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final long f57309b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final String f57310c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final String f57311d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final int f57312e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final int f57313f;

        PricingPhase(JSONObject jSONObject) {
            this.f57311d = jSONObject.optString(Constants.GP_IAP_BILLING_PERIOD);
            this.f57310c = jSONObject.optString(Constants.GP_IAP_PRICE_CURRENCY_CODE_V5V7);
            this.f57308a = jSONObject.optString("formattedPrice");
            this.f57309b = jSONObject.optLong(Constants.GP_IAP_PRICE_AMOUNT_MICROS_V5V7);
            this.f57313f = jSONObject.optInt(Constants.GP_IAP_RECURRENCE_MODE);
            this.f57312e = jSONObject.optInt("billingCycleCount");
        }

        public int a() {
            return this.f57312e;
        }

        public String b() {
            return this.f57311d;
        }

        public String c() {
            return this.f57308a;
        }

        public long d() {
            return this.f57309b;
        }

        public String e() {
            return this.f57310c;
        }

        public int f() {
            return this.f57313f;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static class PricingPhases {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final List f57314a;

        PricingPhases(JSONArray jSONArray) {
            ArrayList arrayList = new ArrayList();
            if (jSONArray != null) {
                for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                    JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i3);
                    if (jSONObjectOptJSONObject != null) {
                        arrayList.add(new PricingPhase(jSONObjectOptJSONObject));
                    }
                }
            }
            this.f57314a = arrayList;
        }

        public List a() {
            return this.f57314a;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Retention(RetentionPolicy.SOURCE)
    public @interface RecurrenceMode {
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class SubscriptionOfferDetails {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f57315a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f57316b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final String f57317c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final PricingPhases f57318d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final List f57319e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final InstallmentPlanDetails f57320f;

        SubscriptionOfferDetails(JSONObject jSONObject) throws JSONException {
            this.f57315a = jSONObject.optString(Constants.GP_IAP_BASE_PLAN_ID);
            String strOptString = jSONObject.optString(Constants.GP_IAP_OFFER_ID);
            this.f57316b = true == strOptString.isEmpty() ? null : strOptString;
            this.f57317c = jSONObject.getString("offerIdToken");
            this.f57318d = new PricingPhases(jSONObject.getJSONArray(Constants.GP_IAP_SUBSCRIPTION_PRICING_PHASES));
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("installmentPlanDetails");
            this.f57320f = jSONObjectOptJSONObject != null ? new InstallmentPlanDetails(jSONObjectOptJSONObject) : null;
            JSONObject jSONObjectOptJSONObject2 = jSONObject.optJSONObject("transitionPlanDetails");
            if (jSONObjectOptJSONObject2 != null) {
                jSONObjectOptJSONObject2.getString("productId");
                jSONObjectOptJSONObject2.optString("title");
                jSONObjectOptJSONObject2.optString("name");
                jSONObjectOptJSONObject2.optString("description");
                jSONObjectOptJSONObject2.optString(Constants.GP_IAP_BASE_PLAN_ID);
                JSONObject jSONObjectOptJSONObject3 = jSONObjectOptJSONObject2.optJSONObject("pricingPhase");
                if (jSONObjectOptJSONObject3 != null) {
                    new PricingPhase(jSONObjectOptJSONObject3);
                }
            }
            ArrayList arrayList = new ArrayList();
            JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("offerTags");
            if (jSONArrayOptJSONArray != null) {
                for (int i3 = 0; i3 < jSONArrayOptJSONArray.length(); i3++) {
                    arrayList.add(jSONArrayOptJSONArray.getString(i3));
                }
            }
            this.f57319e = arrayList;
        }

        public String a() {
            return this.f57315a;
        }

        public InstallmentPlanDetails b() {
            return this.f57320f;
        }

        public String c() {
            return this.f57316b;
        }

        public List d() {
            return this.f57319e;
        }

        public String e() {
            return this.f57317c;
        }

        public PricingPhases f() {
            return this.f57318d;
        }
    }

    ProductDetails(String str) {
        this.f57267a = str;
        JSONObject jSONObject = new JSONObject(str);
        this.f57268b = jSONObject;
        String strOptString = jSONObject.optString("productId");
        this.f57269c = strOptString;
        String strOptString2 = jSONObject.optString("type");
        this.f57270d = strOptString2;
        if (TextUtils.isEmpty(strOptString)) {
            throw new IllegalArgumentException("Product id cannot be empty.");
        }
        if (TextUtils.isEmpty(strOptString2)) {
            throw new IllegalArgumentException("Product type cannot be empty.");
        }
        this.f57271e = jSONObject.optString("title");
        this.f57272f = jSONObject.optString("name");
        this.f57273g = jSONObject.optString("description");
        jSONObject.optString("packageDisplayName");
        jSONObject.optString("iconUrl");
        this.f57274h = jSONObject.optString("skuDetailsToken");
        this.f57275i = jSONObject.optString("serializedDocid");
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray(Constants.GP_IAP_SUBSCRIPTION_OFFER_DETAILS);
        if (jSONArrayOptJSONArray != null) {
            ArrayList arrayList = new ArrayList();
            for (int i3 = 0; i3 < jSONArrayOptJSONArray.length(); i3++) {
                arrayList.add(new SubscriptionOfferDetails(jSONArrayOptJSONArray.getJSONObject(i3)));
            }
            this.f57276j = arrayList;
        } else {
            this.f57276j = (strOptString2.equals("subs") || strOptString2.equals("play_pass_subs")) ? new ArrayList() : null;
        }
        JSONObject jSONObjectOptJSONObject = this.f57268b.optJSONObject(Constants.GP_IAP_ONE_TIME_PURCHASE_OFFER_DETAILS);
        JSONArray jSONArrayOptJSONArray2 = this.f57268b.optJSONArray("oneTimePurchaseOfferDetailsList");
        ArrayList arrayList2 = new ArrayList();
        if (jSONArrayOptJSONArray2 != null) {
            for (int i4 = 0; i4 < jSONArrayOptJSONArray2.length(); i4++) {
                arrayList2.add(new OneTimePurchaseOfferDetails(jSONArrayOptJSONArray2.getJSONObject(i4)));
            }
            this.f57277k = arrayList2;
            return;
        }
        if (jSONObjectOptJSONObject == null) {
            this.f57277k = null;
        } else {
            arrayList2.add(new OneTimePurchaseOfferDetails(jSONObjectOptJSONObject));
            this.f57277k = arrayList2;
        }
    }

    public String a() {
        return this.f57273g;
    }

    public String b() {
        return this.f57272f;
    }

    public OneTimePurchaseOfferDetails c() {
        List list = this.f57277k;
        if (list == null || list.isEmpty()) {
            return null;
        }
        return (OneTimePurchaseOfferDetails) list.get(0);
    }

    public List d() {
        return this.f57277k;
    }

    public String e() {
        return this.f57269c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ProductDetails) {
            return TextUtils.equals(this.f57267a, ((ProductDetails) obj).f57267a);
        }
        return false;
    }

    public String f() {
        return this.f57270d;
    }

    public List g() {
        return this.f57276j;
    }

    public String h() {
        return this.f57271e;
    }

    public int hashCode() {
        return this.f57267a.hashCode();
    }

    public final String i() {
        return this.f57268b.optString("packageName");
    }

    final String j() {
        return this.f57274h;
    }

    final String k(String str) {
        List<OneTimePurchaseOfferDetails> list;
        if (!TextUtils.isEmpty(str) && (list = this.f57277k) != null && !list.isEmpty()) {
            for (OneTimePurchaseOfferDetails oneTimePurchaseOfferDetails : list) {
                if (!TextUtils.isEmpty(oneTimePurchaseOfferDetails.h()) && Objects.equals(oneTimePurchaseOfferDetails.c(), str)) {
                    return oneTimePurchaseOfferDetails.h();
                }
            }
        }
        return this.f57275i;
    }

    public String toString() {
        List list = this.f57276j;
        return "ProductDetails{jsonString='" + this.f57267a + "', parsedJson=" + this.f57268b.toString() + ", productId='" + this.f57269c + "', productType='" + this.f57270d + "', title='" + this.f57271e + "', productDetailsToken='" + this.f57274h + "', subscriptionOfferDetails=" + String.valueOf(list) + "}";
    }
}
