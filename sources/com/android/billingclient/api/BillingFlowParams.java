package com.android.billingclient.api;

import android.text.TextUtils;
import com.android.billingclient.api.ProductDetails;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class BillingFlowParams {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f57191a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f57192b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f57193c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private SubscriptionUpdateParams f57194d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private com.google.android.gms.internal.play_billing.zzbw f57195e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private ArrayList f57196f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f57197g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private DeveloperBillingOptionParams f57198h;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static class Builder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f57199a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private String f57200b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private List f57201c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private ArrayList f57202d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private boolean f57203e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private SubscriptionUpdateParams.Builder f57204f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private DeveloperBillingOptionParams f57205g;

        /* synthetic */ Builder(zzcx zzcxVar) {
            SubscriptionUpdateParams.Builder builderA = SubscriptionUpdateParams.a();
            SubscriptionUpdateParams.Builder.e(builderA);
            this.f57204f = builderA;
        }

        public BillingFlowParams a() {
            ArrayList arrayList = this.f57202d;
            boolean z2 = true;
            boolean z3 = (arrayList == null || arrayList.isEmpty()) ? false : true;
            List list = this.f57201c;
            boolean z4 = (list == null || list.isEmpty()) ? false : true;
            if (!z3 && !z4) {
                throw new IllegalArgumentException("Details of the products must be provided.");
            }
            if (z3 && z4) {
                throw new IllegalArgumentException("Set SkuDetails or ProductDetailsParams, not both.");
            }
            zzcx zzcxVar = null;
            if (!z3) {
                List list2 = this.f57201c;
                if (list2 != null) {
                    Iterator it = list2.iterator();
                    while (it.hasNext()) {
                        if (((ProductDetailsParams) it.next()) == null) {
                            throw new IllegalArgumentException("ProductDetailsParams cannot be null.");
                        }
                    }
                }
            } else {
                if (this.f57202d.contains(null)) {
                    throw new IllegalArgumentException("SKU cannot be null.");
                }
                if (this.f57202d.size() > 1) {
                    SkuDetails skuDetails = (SkuDetails) this.f57202d.get(0);
                    String strB = skuDetails.b();
                    ArrayList arrayList2 = this.f57202d;
                    int size = arrayList2.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        SkuDetails skuDetails2 = (SkuDetails) arrayList2.get(i3);
                        if (!strB.equals("play_pass_subs") && !skuDetails2.b().equals("play_pass_subs") && !strB.equals(skuDetails2.b())) {
                            throw new IllegalArgumentException("SKUs should have the same type.");
                        }
                    }
                    String strF = skuDetails.f();
                    ArrayList arrayList3 = this.f57202d;
                    int size2 = arrayList3.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        SkuDetails skuDetails3 = (SkuDetails) arrayList3.get(i4);
                        if (!strB.equals("play_pass_subs") && !skuDetails3.b().equals("play_pass_subs") && !strF.equals(skuDetails3.f())) {
                            throw new IllegalArgumentException("All SKUs must have the same package name.");
                        }
                    }
                }
            }
            BillingFlowParams billingFlowParams = new BillingFlowParams(zzcxVar);
            if ((!z3 || ((SkuDetails) this.f57202d.get(0)).f().isEmpty()) && (!z4 || ((ProductDetailsParams) this.f57201c.get(0)).c().i().isEmpty())) {
                z2 = false;
            }
            billingFlowParams.f57191a = z2;
            billingFlowParams.f57192b = this.f57199a;
            billingFlowParams.f57193c = this.f57200b;
            billingFlowParams.f57194d = this.f57204f.a();
            ArrayList arrayList4 = this.f57202d;
            billingFlowParams.f57196f = arrayList4 != null ? new ArrayList(arrayList4) : new ArrayList();
            billingFlowParams.f57197g = this.f57203e;
            List list3 = this.f57201c;
            billingFlowParams.f57195e = list3 != null ? com.google.android.gms.internal.play_billing.zzbw.zzj(list3) : com.google.android.gms.internal.play_billing.zzbw.zzk();
            billingFlowParams.f57198h = this.f57205g;
            return billingFlowParams;
        }

        public Builder b(boolean z2) {
            this.f57203e = z2;
            return this;
        }

        public Builder c(String str) {
            this.f57199a = str;
            return this;
        }

        public Builder d(String str) {
            this.f57200b = str;
            return this;
        }

        public Builder e(List list) {
            this.f57201c = new ArrayList(list);
            return this;
        }

        public Builder f(SubscriptionUpdateParams subscriptionUpdateParams) {
            this.f57204f = SubscriptionUpdateParams.c(subscriptionUpdateParams);
            return this;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class ProductDetailsParams {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final SubscriptionProductReplacementParams f57206a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final ProductDetails f57207b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final String f57208c;

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        public static class Builder {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private SubscriptionProductReplacementParams f57209a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private ProductDetails f57210b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            private String f57211c;

            /* synthetic */ Builder(zzcx zzcxVar) {
            }

            public ProductDetailsParams a() {
                com.google.android.gms.internal.play_billing.zzbj.zzc(this.f57210b, "ProductDetails is required for constructing ProductDetailsParams.");
                return new ProductDetailsParams(this, null);
            }

            public Builder b(String str) {
                if (TextUtils.isEmpty(str)) {
                    throw new IllegalArgumentException("offerToken can not be empty");
                }
                this.f57211c = str;
                return this;
            }

            public Builder c(ProductDetails productDetails) {
                this.f57210b = productDetails;
                if (productDetails.c() != null) {
                    productDetails.c().getClass();
                    ProductDetails.OneTimePurchaseOfferDetails oneTimePurchaseOfferDetailsC = productDetails.c();
                    if (oneTimePurchaseOfferDetailsC.c() != null) {
                        this.f57211c = oneTimePurchaseOfferDetailsC.c();
                    }
                }
                return this;
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        public static class SubscriptionProductReplacementParams {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private String f57212a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private int f57213b;

            /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
            public static class Builder {
            }

            /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
            @Retention(RetentionPolicy.SOURCE)
            public @interface ReplacementMode {
            }

            public String b() {
                return this.f57212a;
            }

            public int c() {
                return this.f57213b;
            }
        }

        /* synthetic */ ProductDetailsParams(Builder builder, zzcx zzcxVar) {
            this.f57207b = builder.f57210b;
            this.f57208c = builder.f57211c;
            this.f57206a = builder.f57209a;
        }

        public static Builder b() {
            return new Builder(null);
        }

        public SubscriptionProductReplacementParams a() {
            return this.f57206a;
        }

        public final ProductDetails c() {
            return this.f57207b;
        }

        public final String d() {
            return this.f57208c;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static class SubscriptionUpdateParams {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f57214a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private String f57215b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private int f57216c = 0;

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        public static class Builder {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private String f57217a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private String f57218b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            private boolean f57219c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            private int f57220d = 0;

            /* synthetic */ Builder(zzcx zzcxVar) {
            }

            static /* synthetic */ Builder e(Builder builder) {
                builder.f57219c = true;
                return builder;
            }

            public SubscriptionUpdateParams a() {
                boolean z2 = true;
                zzcx zzcxVar = null;
                if (TextUtils.isEmpty(this.f57217a) && TextUtils.isEmpty(null)) {
                    z2 = false;
                }
                boolean zIsEmpty = TextUtils.isEmpty(this.f57218b);
                if (z2 && !zIsEmpty) {
                    throw new IllegalArgumentException("Please provide Old SKU purchase information(token/id) or original external transaction id, not both.");
                }
                if (!this.f57219c && !z2 && zIsEmpty) {
                    throw new IllegalArgumentException("Old SKU purchase information(token/id) or original external transaction id must be provided.");
                }
                SubscriptionUpdateParams subscriptionUpdateParams = new SubscriptionUpdateParams(zzcxVar);
                subscriptionUpdateParams.f57214a = this.f57217a;
                subscriptionUpdateParams.f57216c = this.f57220d;
                subscriptionUpdateParams.f57215b = this.f57218b;
                return subscriptionUpdateParams;
            }

            public Builder b(String str) {
                this.f57217a = str;
                return this;
            }

            public Builder c(String str) {
                this.f57218b = str;
                return this;
            }

            public Builder d(int i3) {
                this.f57220d = i3;
                return this;
            }

            public final Builder f(String str) {
                this.f57217a = str;
                return this;
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Retention(RetentionPolicy.SOURCE)
        public @interface ReplacementMode {
        }

        /* synthetic */ SubscriptionUpdateParams(zzcx zzcxVar) {
        }

        public static Builder a() {
            return new Builder(null);
        }

        static /* bridge */ /* synthetic */ Builder c(SubscriptionUpdateParams subscriptionUpdateParams) {
            Builder builderA = a();
            builderA.f(subscriptionUpdateParams.f57214a);
            builderA.d(subscriptionUpdateParams.f57216c);
            builderA.c(subscriptionUpdateParams.f57215b);
            return builderA;
        }

        final int b() {
            return this.f57216c;
        }

        final String d() {
            return this.f57214a;
        }

        final String e() {
            return this.f57215b;
        }
    }

    /* synthetic */ BillingFlowParams(zzcx zzcxVar) {
    }

    public static Builder b() {
        return new Builder(null);
    }

    public DeveloperBillingOptionParams a() {
        return this.f57198h;
    }

    public int c() {
        return 0;
    }

    public final int d() {
        return this.f57194d.b();
    }

    public long e() {
        return 0L;
    }

    final BillingResult f() {
        ProductDetails.OneTimePurchaseOfferDetails oneTimePurchaseOfferDetails;
        ProductDetailsParams.SubscriptionProductReplacementParams subscriptionProductReplacementParamsA;
        if (this.f57195e.isEmpty()) {
            return zzdc.f57559i;
        }
        ProductDetailsParams productDetailsParams = (ProductDetailsParams) this.f57195e.get(0);
        for (int i3 = 1; i3 < this.f57195e.size(); i3++) {
            ProductDetailsParams productDetailsParams2 = (ProductDetailsParams) this.f57195e.get(i3);
            if (!productDetailsParams2.c().f().equals(productDetailsParams.c().f()) && !productDetailsParams2.c().f().equals("play_pass_subs")) {
                return zzdc.a(5, "All products should have same ProductType.");
            }
        }
        String strI = productDetailsParams.c().i();
        HashMap map = new HashMap();
        HashSet<String> hashSet = new HashSet();
        com.google.android.gms.internal.play_billing.zzbw zzbwVar = this.f57195e;
        int size = zzbwVar.size();
        boolean z2 = false;
        for (int i4 = 0; i4 < size; i4++) {
            ProductDetailsParams productDetailsParams3 = (ProductDetailsParams) zzbwVar.get(i4);
            ProductDetailsParams.SubscriptionProductReplacementParams subscriptionProductReplacementParamsA2 = productDetailsParams3.a();
            if (subscriptionProductReplacementParamsA2 != null) {
                BillingResult billingResultA = !productDetailsParams3.c().f().equals("subs") ? zzdc.a(5, String.format("Non-subscription product cannot have SubscriptionProductReplacementParams. Invalid product id: %s", productDetailsParams3.c().e())) : subscriptionProductReplacementParamsA2.c() <= 0 ? zzdc.a(5, String.format("replacementMode is required for constructing SubscriptionProductReplacementParams. Not correctly set for product id: %s", productDetailsParams3.c().e())) : com.google.android.gms.internal.play_billing.zzbm.zzd(subscriptionProductReplacementParamsA2.f57212a) ? zzdc.a(5, String.format("oldProductId is required for constructing SubscriptionProductReplacementParams. Not correctly set for product id: %s", productDetailsParams3.c().e())) : zzdc.f57559i;
                if (billingResultA != zzdc.f57559i) {
                    return billingResultA;
                }
            }
            if (subscriptionProductReplacementParamsA2 != null && subscriptionProductReplacementParamsA2.c() == 6) {
                BillingResult billingResultA2 = productDetailsParams3.d() != null ? zzdc.a(5, String.format("When using KEEP_EXISTING mode, offerToken in ProductDetailsParams should not be set. Offer token is set for product id: %s", productDetailsParams3.c().e())) : !subscriptionProductReplacementParamsA2.b().equals(productDetailsParams3.c().e()) ? zzdc.a(5, String.format("When using KEEP_EXISTING mode, oldProductId in SubscriptionProductReplacementParams should be the same as the product id in ProductDetails. Value is invalid for product id: %s", productDetailsParams3.c().e())) : zzdc.f57559i;
                if (billingResultA2 != zzdc.f57559i) {
                    return billingResultA2;
                }
            }
            if (productDetailsParams3.c().g() != null && productDetailsParams3.d() == null && (subscriptionProductReplacementParamsA2 == null || subscriptionProductReplacementParamsA2.c() != 6)) {
                return zzdc.a(5, String.format("offerToken is required for constructing ProductDetailsParams for subscriptions. Missing value for product id: %s", productDetailsParams3.c().e()));
            }
            if (map.containsKey(productDetailsParams3.c().e())) {
                return zzdc.a(5, String.format("ProductId can not be duplicated. Invalid product id: %s.", productDetailsParams3.c().e()));
            }
            map.put(productDetailsParams3.c().e(), productDetailsParams3);
            if (subscriptionProductReplacementParamsA2 != null) {
                if (hashSet.contains(subscriptionProductReplacementParamsA2.b())) {
                    return zzdc.a(5, String.format("OldProductId can not be duplicated. Invalid old product id: %s.", subscriptionProductReplacementParamsA2.b()));
                }
                hashSet.add(subscriptionProductReplacementParamsA2.b());
                z2 = true;
            }
            if (!productDetailsParams.c().f().equals("play_pass_subs") && !productDetailsParams3.c().f().equals("play_pass_subs") && !strI.equals(productDetailsParams3.c().i())) {
                return zzdc.a(5, "All products must have the same package name.");
            }
        }
        for (String str : hashSet) {
            if (map.containsKey(str) && ((subscriptionProductReplacementParamsA = ((ProductDetailsParams) map.get(str)).a()) == null || !subscriptionProductReplacementParamsA.b().equals(str))) {
                return zzdc.a(5, String.format("OldProductId must not be one of the products to be purchased. Invalid old product id: %s.", str));
            }
        }
        if (z2 && this.f57194d.b() != 0) {
            return zzdc.a(5, "SubscriptionUpdateParams.setSubscriptionReplaceMode and  ProductDetailsParams.setSubscriptionProductReplacementParams cannot be called at the same time.");
        }
        List listD = productDetailsParams.c().d();
        String strD = productDetailsParams.d();
        if (strD != null && listD != null) {
            Iterator it = listD.iterator();
            while (true) {
                if (!it.hasNext()) {
                    oneTimePurchaseOfferDetails = null;
                    break;
                }
                oneTimePurchaseOfferDetails = (ProductDetails.OneTimePurchaseOfferDetails) it.next();
                if (strD.equals(oneTimePurchaseOfferDetails.c())) {
                    break;
                }
            }
            if (oneTimePurchaseOfferDetails != null && oneTimePurchaseOfferDetails.g() != null) {
                return zzdc.a(5, "Both autoPayDetails and autoPayBalanceThreshold is required for constructing ProductDetailsParams for autopay.");
            }
        }
        return zzdc.f57559i;
    }

    public final String g() {
        return this.f57192b;
    }

    public final String h() {
        return this.f57193c;
    }

    public String i() {
        return null;
    }

    public final String j() {
        return this.f57194d.d();
    }

    public final String k() {
        return this.f57194d.e();
    }

    public final ArrayList l() {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(this.f57196f);
        return arrayList;
    }

    public final List m() {
        return this.f57195e;
    }

    public final boolean v() {
        return this.f57197g;
    }

    final boolean w() {
        if (this.f57192b != null || this.f57193c != null || this.f57194d.e() != null || this.f57194d.b() != 0 || this.f57191a || this.f57197g) {
            return true;
        }
        com.google.android.gms.internal.play_billing.zzbw zzbwVar = this.f57195e;
        if (zzbwVar != null) {
            int size = zzbwVar.size();
            int i3 = 0;
            while (i3 < size) {
                ProductDetailsParams.SubscriptionProductReplacementParams subscriptionProductReplacementParamsA = ((ProductDetailsParams) zzbwVar.get(i3)).a();
                i3++;
                if (subscriptionProductReplacementParamsA != null) {
                    return true;
                }
            }
        }
        return false;
    }
}
