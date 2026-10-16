package com.superwall.sdk.billing.observer;

import com.android.billingclient.api.BillingFlowParams;
import com.android.billingclient.api.ProductDetails;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:71)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:37)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:35)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class SuperwallBillingFlowParams {
    public static final Companion Companion = new Companion(null);
    private final BillingFlowParams params;
    private final List<ProductDetailsParams> productDetailsParams;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Builder {
        private final BillingFlowParams.Builder builder;
        private final List<ProductDetailsParams> productDetailsParams;

        public Builder() {
            BillingFlowParams.Builder builderB = BillingFlowParams.b();
            Intrinsics.checkNotNullExpressionValue(builderB, "newBuilder(...)");
            this.builder = builderB;
            this.productDetailsParams = new ArrayList();
        }

        public final SuperwallBillingFlowParams build() {
            BillingFlowParams billingFlowParamsA = this.builder.a();
            Intrinsics.checkNotNullExpressionValue(billingFlowParamsA, "build(...)");
            return new SuperwallBillingFlowParams(billingFlowParamsA, this.productDetailsParams, null);
        }

        public final List<ProductDetailsParams> getProductDetailsParams$superwall_release() {
            return this.productDetailsParams;
        }

        public final Builder setIsOfferPersonalized(boolean z2) {
            this.builder.b(z2);
            return this;
        }

        public final Builder setObfuscatedAccountId(String obfuscatedAccountId) {
            Intrinsics.checkNotNullParameter(obfuscatedAccountId, "obfuscatedAccountId");
            this.builder.c(obfuscatedAccountId);
            return this;
        }

        public final Builder setObfuscatedProfileId(String obfuscatedProfileId) {
            Intrinsics.checkNotNullParameter(obfuscatedProfileId, "obfuscatedProfileId");
            this.builder.d(obfuscatedProfileId);
            return this;
        }

        public final Builder setProductDetailsParamsList(List<ProductDetailsParams> productDetailsParamsList) {
            Intrinsics.checkNotNullParameter(productDetailsParamsList, "productDetailsParamsList");
            this.productDetailsParams.addAll(productDetailsParamsList);
            BillingFlowParams.Builder builder = this.builder;
            List<ProductDetailsParams> list = productDetailsParamsList;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(((ProductDetailsParams) it.next()).toOriginal());
            }
            builder.e(arrayList);
            return this;
        }

        public final Builder setSubscriptionUpdateParams(SubscriptionUpdateParams params) {
            Intrinsics.checkNotNullParameter(params, "params");
            this.builder.f(params.toOriginal());
            return this;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Builder newBuilder() {
            return new Builder();
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class ProductDetailsParams {
        public static final Companion Companion = new Companion(null);
        private final ProductDetails details;
        private final BillingFlowParams.ProductDetailsParams params;

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final ProductDetailsParamsBuilder newBuilder() {
                return new ProductDetailsParamsBuilder();
            }

            private Companion() {
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class ProductDetailsParamsBuilder {
            private final BillingFlowParams.ProductDetailsParams.Builder builder;
            private ProductDetails details;

            public ProductDetailsParamsBuilder() {
                BillingFlowParams.ProductDetailsParams.Builder builderB = BillingFlowParams.ProductDetailsParams.b();
                Intrinsics.checkNotNullExpressionValue(builderB, "newBuilder(...)");
                this.builder = builderB;
            }

            public final ProductDetailsParams build() {
                ProductDetails productDetails = this.details;
                if (productDetails == null) {
                    throw new IllegalArgumentException("ProductDetails are required");
                }
                BillingFlowParams.ProductDetailsParams productDetailsParamsA = this.builder.a();
                Intrinsics.checkNotNullExpressionValue(productDetailsParamsA, "build(...)");
                return new ProductDetailsParams(productDetailsParamsA, productDetails, null);
            }

            public final ProductDetails getDetails$superwall_release() {
                return this.details;
            }

            public final void setDetails$superwall_release(ProductDetails productDetails) {
                this.details = productDetails;
            }

            public final ProductDetailsParamsBuilder setOfferToken(String offerToken) {
                Intrinsics.checkNotNullParameter(offerToken, "offerToken");
                this.builder.b(offerToken);
                return this;
            }

            public final ProductDetailsParamsBuilder setProductDetails(ProductDetails productDetails) {
                Intrinsics.checkNotNullParameter(productDetails, "productDetails");
                this.details = productDetails;
                this.builder.c(productDetails);
                return this;
            }
        }

        public /* synthetic */ ProductDetailsParams(BillingFlowParams.ProductDetailsParams productDetailsParams, ProductDetails productDetails, DefaultConstructorMarker defaultConstructorMarker) {
            this(productDetailsParams, productDetails);
        }

        public final ProductDetails getDetails$superwall_release() {
            return this.details;
        }

        public final BillingFlowParams.ProductDetailsParams toOriginal() {
            return this.params;
        }

        private ProductDetailsParams(BillingFlowParams.ProductDetailsParams productDetailsParams, ProductDetails productDetails) {
            this.params = productDetailsParams;
            this.details = productDetails;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @Deprecated
    @Retention(RetentionPolicy.SOURCE)
    @kotlin.annotation.Retention
    public @interface ProrationMode {
        public static final Companion Companion = Companion.$$INSTANCE;
        public static final int DEFERRED = 4;
        public static final int IMMEDIATE_AND_CHARGE_FULL_PRICE = 5;
        public static final int IMMEDIATE_AND_CHARGE_PRORATED_PRICE = 2;
        public static final int IMMEDIATE_WITHOUT_PRORATION = 3;
        public static final int IMMEDIATE_WITH_TIME_PRORATION = 1;
        public static final int UNKNOWN_SUBSCRIPTION_UPGRADE_DOWNGRADE_POLICY = 0;

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class Companion {
            static final /* synthetic */ Companion $$INSTANCE = new Companion();
            public static final int DEFERRED = 4;
            public static final int IMMEDIATE_AND_CHARGE_FULL_PRICE = 5;
            public static final int IMMEDIATE_AND_CHARGE_PRORATED_PRICE = 2;
            public static final int IMMEDIATE_WITHOUT_PRORATION = 3;
            public static final int IMMEDIATE_WITH_TIME_PRORATION = 1;
            public static final int UNKNOWN_SUBSCRIPTION_UPGRADE_DOWNGRADE_POLICY = 0;

            private Companion() {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class SubscriptionUpdateParams {
        public static final Companion Companion = new Companion(null);
        private final BillingFlowParams.SubscriptionUpdateParams params;

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final SubscriptionUpdateParamsBuilder newBuilder() {
                return new SubscriptionUpdateParamsBuilder();
            }

            private Companion() {
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        @Retention(RetentionPolicy.SOURCE)
        @kotlin.annotation.Retention
        public @interface ReplacementMode {
            public static final int CHARGE_FULL_PRICE = 5;
            public static final int CHARGE_PRORATED_PRICE = 2;
            public static final Companion Companion = Companion.$$INSTANCE;
            public static final int DEFERRED = 6;
            public static final int UNKNOWN_REPLACEMENT_MODE = 0;
            public static final int WITHOUT_PRORATION = 3;
            public static final int WITH_TIME_PRORATION = 1;

            /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
            @Metadata
            public static final class Companion {
                static final /* synthetic */ Companion $$INSTANCE = new Companion();
                public static final int CHARGE_FULL_PRICE = 5;
                public static final int CHARGE_PRORATED_PRICE = 2;
                public static final int DEFERRED = 6;
                public static final int UNKNOWN_REPLACEMENT_MODE = 0;
                public static final int WITHOUT_PRORATION = 3;
                public static final int WITH_TIME_PRORATION = 1;

                private Companion() {
                }
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class SubscriptionUpdateParamsBuilder {
            private final BillingFlowParams.SubscriptionUpdateParams.Builder builder;

            public SubscriptionUpdateParamsBuilder() {
                BillingFlowParams.SubscriptionUpdateParams.Builder builderA = BillingFlowParams.SubscriptionUpdateParams.a();
                Intrinsics.checkNotNullExpressionValue(builderA, "newBuilder(...)");
                this.builder = builderA;
            }

            public final SubscriptionUpdateParams build() {
                BillingFlowParams.SubscriptionUpdateParams subscriptionUpdateParamsA = this.builder.a();
                Intrinsics.checkNotNullExpressionValue(subscriptionUpdateParamsA, "build(...)");
                return new SubscriptionUpdateParams(subscriptionUpdateParamsA, null);
            }

            public final SubscriptionUpdateParamsBuilder setOldPurchaseToken(String purchaseToken) {
                Intrinsics.checkNotNullParameter(purchaseToken, "purchaseToken");
                this.builder.b(purchaseToken);
                return this;
            }

            public final SubscriptionUpdateParamsBuilder setOriginalExternalTransactionId(String externalTransactionId) {
                Intrinsics.checkNotNullParameter(externalTransactionId, "externalTransactionId");
                this.builder.c(externalTransactionId);
                return this;
            }

            public final SubscriptionUpdateParamsBuilder setSubscriptionReplacementMode(int i3) {
                this.builder.d(i3);
                return this;
            }
        }

        public /* synthetic */ SubscriptionUpdateParams(BillingFlowParams.SubscriptionUpdateParams subscriptionUpdateParams, DefaultConstructorMarker defaultConstructorMarker) {
            this(subscriptionUpdateParams);
        }

        public final BillingFlowParams.SubscriptionUpdateParams toOriginal() {
            return this.params;
        }

        private SubscriptionUpdateParams(BillingFlowParams.SubscriptionUpdateParams subscriptionUpdateParams) {
            this.params = subscriptionUpdateParams;
        }
    }

    public /* synthetic */ SuperwallBillingFlowParams(BillingFlowParams billingFlowParams, List list, DefaultConstructorMarker defaultConstructorMarker) {
        this(billingFlowParams, list);
    }

    public final BillingFlowParams getParams$superwall_release() {
        return this.params;
    }

    public final List<ProductDetailsParams> getProductDetailsParams$superwall_release() {
        return this.productDetailsParams;
    }

    public final BillingFlowParams toOriginal() {
        return this.params;
    }

    private SuperwallBillingFlowParams(BillingFlowParams billingFlowParams, List<ProductDetailsParams> list) {
        this.params = billingFlowParams;
        this.productDetailsParams = list;
    }

    /* synthetic */ SuperwallBillingFlowParams(BillingFlowParams billingFlowParams, List list, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(billingFlowParams, (i3 & 2) != 0 ? new ArrayList() : list);
    }
}
