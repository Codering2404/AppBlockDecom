package com.superwall.sdk.models.product;

import com.revenuecat.purchases.common.Constants;
import com.superwall.sdk.models.entitlements.Entitlement;
import com.superwall.sdk.models.product.CrossplatformProduct;
import com.superwall.sdk.models.product.Offer;
import com.superwall.sdk.models.product.ProductItem;
import java.lang.annotation.Annotation;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SealedClassSerializer;
import kotlinx.serialization.SerialName;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.json.JsonElement;
import kotlinx.serialization.json.JsonObject;

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
@Serializable(with = CrossplatformProductSerializer.class)
public final class CrossplatformProduct implements TemplatingProduct {
    public static final Companion Companion = new Companion(null);
    private final String compositeId;
    private final List<Entitlement> entitlements;
    private final String name;
    private final StoreProduct storeProduct;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KSerializer<CrossplatformProduct> serializer() {
            return CrossplatformProductSerializer.INSTANCE;
        }

        public final ProductItem toProductItem(CrossplatformProduct product) {
            Intrinsics.checkNotNullParameter(product, "product");
            return new ProductItem(product.getCompositeId(), product.getName(), product.getStoreProduct().toStoreProductType(), CollectionsKt.toSet(product.getEntitlements()));
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @Serializable
    public static abstract class StoreProduct {
        public static final Companion Companion = new Companion(null);
        private static final Lazy<KSerializer<Object>> $cachedSerializer$delegate = LazyKt.a(LazyThreadSafetyMode.f139762b, new Function0() { // from class: h0.a
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return CrossplatformProduct.StoreProduct._init_$_anonymous_();
            }
        });

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        @Serializable(with = AppStoreSerializer.class)
        @SerialName
        public static final class AppStore extends StoreProduct {
            public static final Companion Companion = new Companion(null);
            private final String productIdentifier;

            /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
            @Metadata
            public static final class Companion {
                private Companion() {
                }

                public final KSerializer<AppStore> serializer() {
                    return AppStoreSerializer.INSTANCE;
                }

                public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }
            }

            /* JADX WARN: Multi-variable type inference failed */
            public AppStore() {
                this(null, 1, 0 == true ? 1 : 0);
            }

            public static /* synthetic */ AppStore copy$default(AppStore appStore, String str, int i3, Object obj) {
                if ((i3 & 1) != 0) {
                    str = appStore.productIdentifier;
                }
                return appStore.copy(str);
            }

            public final String component1() {
                return this.productIdentifier;
            }

            public final AppStore copy(String productIdentifier) {
                Intrinsics.checkNotNullParameter(productIdentifier, "productIdentifier");
                return new AppStore(productIdentifier);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof AppStore) && Intrinsics.areEqual(this.productIdentifier, ((AppStore) obj).productIdentifier);
            }

            public final String getProductIdentifier() {
                return this.productIdentifier;
            }

            public int hashCode() {
                return this.productIdentifier.hashCode();
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.superwall.sdk.models.product.CrossplatformProduct.StoreProduct
            public ProductItem.StoreProductType toStoreProductType() {
                return new ProductItem.StoreProductType.AppStore(new AppStoreProduct((Store) null, this.productIdentifier, 1, (DefaultConstructorMarker) (0 == true ? 1 : 0)));
            }

            public String toString() {
                return "AppStore(productIdentifier=" + this.productIdentifier + ")";
            }

            public /* synthetic */ AppStore(String str, int i3, DefaultConstructorMarker defaultConstructorMarker) {
                this((i3 & 1) != 0 ? "" : str);
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AppStore(String productIdentifier) {
                super(null);
                Intrinsics.checkNotNullParameter(productIdentifier, "productIdentifier");
                this.productIdentifier = productIdentifier;
            }

            @SerialName
            public static /* synthetic */ void getProductIdentifier$annotations() {
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class Companion {
            private Companion() {
            }

            private final /* synthetic */ KSerializer get$cachedSerializer() {
                return (KSerializer) StoreProduct.$cachedSerializer$delegate.getValue();
            }

            public final KSerializer<StoreProduct> serializer() {
                return get$cachedSerializer();
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public /* synthetic */ StoreProduct(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final /* synthetic */ KSerializer _init_$_anonymous_() {
            return new SealedClassSerializer("com.superwall.sdk.models.product.CrossplatformProduct.StoreProduct", Reflection.b(StoreProduct.class), new KClass[]{Reflection.b(AppStore.class), Reflection.b(Custom.class), Reflection.b(Other.class), Reflection.b(Paddle.class), Reflection.b(PlayStore.class), Reflection.b(Stripe.class)}, new KSerializer[]{AppStoreSerializer.INSTANCE, CustomSerializer.INSTANCE, OtherSerializer.INSTANCE, PaddleSerializer.INSTANCE, PlayStoreSerializer.INSTANCE, StripeSerializer.INSTANCE}, new Annotation[0]);
        }

        public abstract ProductItem.StoreProductType toStoreProductType();

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        @Serializable(with = OtherSerializer.class)
        @SerialName
        public static final class Other extends StoreProduct {
            public static final Companion Companion = new Companion(null);
            private final JsonObject _data;
            private final Map<String, JsonElement> data;
            private final String productIdentifier;
            private final String storeType;

            /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
            @Metadata
            public static final class Companion {
                private Companion() {
                }

                public final KSerializer<Other> serializer() {
                    return OtherSerializer.INSTANCE;
                }

                public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }
            }

            public /* synthetic */ Other(String str, String str2, JsonObject jsonObject, int i3, DefaultConstructorMarker defaultConstructorMarker) {
                this(str, str2, (i3 & 4) != 0 ? new JsonObject(MapsKt.emptyMap()) : jsonObject);
            }

            private final JsonObject component3() {
                return this._data;
            }

            public static /* synthetic */ Other copy$default(Other other, String str, String str2, JsonObject jsonObject, int i3, Object obj) {
                if ((i3 & 1) != 0) {
                    str = other.storeType;
                }
                if ((i3 & 2) != 0) {
                    str2 = other.productIdentifier;
                }
                if ((i3 & 4) != 0) {
                    jsonObject = other._data;
                }
                return other.copy(str, str2, jsonObject);
            }

            public final String component1() {
                return this.storeType;
            }

            public final String component2() {
                return this.productIdentifier;
            }

            public final Other copy(String storeType, String productIdentifier, JsonObject _data) {
                Intrinsics.checkNotNullParameter(storeType, "storeType");
                Intrinsics.checkNotNullParameter(productIdentifier, "productIdentifier");
                Intrinsics.checkNotNullParameter(_data, "_data");
                return new Other(storeType, productIdentifier, _data);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof Other)) {
                    return false;
                }
                Other other = (Other) obj;
                return Intrinsics.areEqual(this.storeType, other.storeType) && Intrinsics.areEqual(this.productIdentifier, other.productIdentifier) && Intrinsics.areEqual(this._data, other._data);
            }

            public final Map<String, JsonElement> getData() {
                return this.data;
            }

            public final String getProductIdentifier() {
                return this.productIdentifier;
            }

            public final String getStoreType() {
                return this.storeType;
            }

            public int hashCode() {
                return (((this.storeType.hashCode() * 31) + this.productIdentifier.hashCode()) * 31) + this._data.hashCode();
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.superwall.sdk.models.product.CrossplatformProduct.StoreProduct
            public ProductItem.StoreProductType toStoreProductType() {
                return new ProductItem.StoreProductType.Other(new UnknownStoreProduct(this.productIdentifier, (Store) null, 2, (DefaultConstructorMarker) (0 == true ? 1 : 0)));
            }

            public String toString() {
                return "Other(storeType=" + this.storeType + ", productIdentifier=" + this.productIdentifier + ", _data=" + this._data + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Other(String storeType, String productIdentifier, JsonObject _data) {
                super(null);
                Intrinsics.checkNotNullParameter(storeType, "storeType");
                Intrinsics.checkNotNullParameter(productIdentifier, "productIdentifier");
                Intrinsics.checkNotNullParameter(_data, "_data");
                this.storeType = storeType;
                this.productIdentifier = productIdentifier;
                this._data = _data;
                this.data = MapsKt.toMap(_data);
            }

            @SerialName
            public static /* synthetic */ void getProductIdentifier$annotations() {
            }

            @SerialName
            public static /* synthetic */ void getStoreType$annotations() {
            }

            @SerialName
            private static /* synthetic */ void get_data$annotations() {
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        @Serializable(with = PaddleSerializer.class)
        @SerialName
        public static final class Paddle extends StoreProduct {
            public static final Companion Companion = new Companion(null);
            private final String environment;
            private final JsonObject meta;
            private final String productIdentifier;
            private final int trialDays;

            /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
            @Metadata
            public static final class Companion {
                private Companion() {
                }

                public final KSerializer<Paddle> serializer() {
                    return PaddleSerializer.INSTANCE;
                }

                public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }
            }

            public /* synthetic */ Paddle(String str, String str2, int i3, JsonObject jsonObject, int i4, DefaultConstructorMarker defaultConstructorMarker) {
                this(str, str2, i3, (i4 & 8) != 0 ? new JsonObject(MapsKt.emptyMap()) : jsonObject);
            }

            public static /* synthetic */ Paddle copy$default(Paddle paddle, String str, String str2, int i3, JsonObject jsonObject, int i4, Object obj) {
                if ((i4 & 1) != 0) {
                    str = paddle.environment;
                }
                if ((i4 & 2) != 0) {
                    str2 = paddle.productIdentifier;
                }
                if ((i4 & 4) != 0) {
                    i3 = paddle.trialDays;
                }
                if ((i4 & 8) != 0) {
                    jsonObject = paddle.meta;
                }
                return paddle.copy(str, str2, i3, jsonObject);
            }

            public final String component1() {
                return this.environment;
            }

            public final String component2() {
                return this.productIdentifier;
            }

            public final int component3() {
                return this.trialDays;
            }

            public final JsonObject component4() {
                return this.meta;
            }

            public final Paddle copy(String environment, String productIdentifier, int i3, JsonObject meta) {
                Intrinsics.checkNotNullParameter(environment, "environment");
                Intrinsics.checkNotNullParameter(productIdentifier, "productIdentifier");
                Intrinsics.checkNotNullParameter(meta, "meta");
                return new Paddle(environment, productIdentifier, i3, meta);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof Paddle)) {
                    return false;
                }
                Paddle paddle = (Paddle) obj;
                return Intrinsics.areEqual(this.environment, paddle.environment) && Intrinsics.areEqual(this.productIdentifier, paddle.productIdentifier) && this.trialDays == paddle.trialDays && Intrinsics.areEqual(this.meta, paddle.meta);
            }

            public final String getEnvironment() {
                return this.environment;
            }

            public final JsonObject getMeta() {
                return this.meta;
            }

            public final String getProductIdentifier() {
                return this.productIdentifier;
            }

            public final int getTrialDays() {
                return this.trialDays;
            }

            public int hashCode() {
                return (((((this.environment.hashCode() * 31) + this.productIdentifier.hashCode()) * 31) + Integer.hashCode(this.trialDays)) * 31) + this.meta.hashCode();
            }

            @Override // com.superwall.sdk.models.product.CrossplatformProduct.StoreProduct
            public ProductItem.StoreProductType toStoreProductType() {
                return new ProductItem.StoreProductType.Paddle(new PaddleProduct((Store) null, this.environment, this.productIdentifier, Integer.valueOf(this.trialDays), 1, (DefaultConstructorMarker) null));
            }

            public String toString() {
                return "Paddle(environment=" + this.environment + ", productIdentifier=" + this.productIdentifier + ", trialDays=" + this.trialDays + ", meta=" + this.meta + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Paddle(String environment, String productIdentifier, int i3, JsonObject meta) {
                super(null);
                Intrinsics.checkNotNullParameter(environment, "environment");
                Intrinsics.checkNotNullParameter(productIdentifier, "productIdentifier");
                Intrinsics.checkNotNullParameter(meta, "meta");
                this.environment = environment;
                this.productIdentifier = productIdentifier;
                this.trialDays = i3;
                this.meta = meta;
            }

            @SerialName
            public static /* synthetic */ void getEnvironment$annotations() {
            }

            @SerialName
            public static /* synthetic */ void getMeta$annotations() {
            }

            @SerialName
            public static /* synthetic */ void getProductIdentifier$annotations() {
            }

            @SerialName
            public static /* synthetic */ void getTrialDays$annotations() {
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        @Serializable(with = StripeSerializer.class)
        @SerialName
        public static final class Stripe extends StoreProduct {
            public static final Companion Companion = new Companion(null);
            private final String environment;
            private final JsonObject meta;
            private final String productIdentifier;
            private final int trialDays;

            /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
            @Metadata
            public static final class Companion {
                private Companion() {
                }

                public final KSerializer<Stripe> serializer() {
                    return StripeSerializer.INSTANCE;
                }

                public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }
            }

            public /* synthetic */ Stripe(String str, String str2, int i3, JsonObject jsonObject, int i4, DefaultConstructorMarker defaultConstructorMarker) {
                this(str, str2, i3, (i4 & 8) != 0 ? new JsonObject(MapsKt.emptyMap()) : jsonObject);
            }

            public static /* synthetic */ Stripe copy$default(Stripe stripe, String str, String str2, int i3, JsonObject jsonObject, int i4, Object obj) {
                if ((i4 & 1) != 0) {
                    str = stripe.environment;
                }
                if ((i4 & 2) != 0) {
                    str2 = stripe.productIdentifier;
                }
                if ((i4 & 4) != 0) {
                    i3 = stripe.trialDays;
                }
                if ((i4 & 8) != 0) {
                    jsonObject = stripe.meta;
                }
                return stripe.copy(str, str2, i3, jsonObject);
            }

            public final String component1() {
                return this.environment;
            }

            public final String component2() {
                return this.productIdentifier;
            }

            public final int component3() {
                return this.trialDays;
            }

            public final JsonObject component4() {
                return this.meta;
            }

            public final Stripe copy(String environment, String productIdentifier, int i3, JsonObject meta) {
                Intrinsics.checkNotNullParameter(environment, "environment");
                Intrinsics.checkNotNullParameter(productIdentifier, "productIdentifier");
                Intrinsics.checkNotNullParameter(meta, "meta");
                return new Stripe(environment, productIdentifier, i3, meta);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof Stripe)) {
                    return false;
                }
                Stripe stripe = (Stripe) obj;
                return Intrinsics.areEqual(this.environment, stripe.environment) && Intrinsics.areEqual(this.productIdentifier, stripe.productIdentifier) && this.trialDays == stripe.trialDays && Intrinsics.areEqual(this.meta, stripe.meta);
            }

            public final String getEnvironment() {
                return this.environment;
            }

            public final JsonObject getMeta() {
                return this.meta;
            }

            public final String getProductIdentifier() {
                return this.productIdentifier;
            }

            public final int getTrialDays() {
                return this.trialDays;
            }

            public int hashCode() {
                return (((((this.environment.hashCode() * 31) + this.productIdentifier.hashCode()) * 31) + Integer.hashCode(this.trialDays)) * 31) + this.meta.hashCode();
            }

            @Override // com.superwall.sdk.models.product.CrossplatformProduct.StoreProduct
            public ProductItem.StoreProductType toStoreProductType() {
                return new ProductItem.StoreProductType.Stripe(new StripeProduct((Store) null, this.environment, this.productIdentifier, Integer.valueOf(this.trialDays), 1, (DefaultConstructorMarker) null));
            }

            public String toString() {
                return "Stripe(environment=" + this.environment + ", productIdentifier=" + this.productIdentifier + ", trialDays=" + this.trialDays + ", meta=" + this.meta + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Stripe(String environment, String productIdentifier, int i3, JsonObject meta) {
                super(null);
                Intrinsics.checkNotNullParameter(environment, "environment");
                Intrinsics.checkNotNullParameter(productIdentifier, "productIdentifier");
                Intrinsics.checkNotNullParameter(meta, "meta");
                this.environment = environment;
                this.productIdentifier = productIdentifier;
                this.trialDays = i3;
                this.meta = meta;
            }

            @SerialName
            public static /* synthetic */ void getEnvironment$annotations() {
            }

            @SerialName
            public static /* synthetic */ void getMeta$annotations() {
            }

            @SerialName
            public static /* synthetic */ void getProductIdentifier$annotations() {
            }

            @SerialName
            public static /* synthetic */ void getTrialDays$annotations() {
            }
        }

        private StoreProduct() {
        }

        public /* synthetic */ StoreProduct(int i3, SerializationConstructorMarker serializationConstructorMarker) {
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        @Serializable(with = CustomSerializer.class)
        @SerialName
        public static final class Custom extends StoreProduct {
            public static final Companion Companion = new Companion(null);
            private final String productIdentifier;

            /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
            @Metadata
            public static final class Companion {
                private Companion() {
                }

                public final KSerializer<Custom> serializer() {
                    return CustomSerializer.INSTANCE;
                }

                public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Custom(String productIdentifier) {
                super(null);
                Intrinsics.checkNotNullParameter(productIdentifier, "productIdentifier");
                this.productIdentifier = productIdentifier;
            }

            public static /* synthetic */ Custom copy$default(Custom custom, String str, int i3, Object obj) {
                if ((i3 & 1) != 0) {
                    str = custom.productIdentifier;
                }
                return custom.copy(str);
            }

            public final String component1() {
                return this.productIdentifier;
            }

            public final Custom copy(String productIdentifier) {
                Intrinsics.checkNotNullParameter(productIdentifier, "productIdentifier");
                return new Custom(productIdentifier);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof Custom) && Intrinsics.areEqual(this.productIdentifier, ((Custom) obj).productIdentifier);
            }

            public final String getProductIdentifier() {
                return this.productIdentifier;
            }

            public int hashCode() {
                return this.productIdentifier.hashCode();
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.superwall.sdk.models.product.CrossplatformProduct.StoreProduct
            public ProductItem.StoreProductType toStoreProductType() {
                return new ProductItem.StoreProductType.Custom(new CustomStoreProduct((Store) null, this.productIdentifier, 1, (DefaultConstructorMarker) (0 == true ? 1 : 0)));
            }

            public String toString() {
                return "Custom(productIdentifier=" + this.productIdentifier + ")";
            }

            @SerialName
            public static /* synthetic */ void getProductIdentifier$annotations() {
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        @Serializable(with = PlayStoreSerializer.class)
        @SerialName
        public static final class PlayStore extends StoreProduct {
            public static final Companion Companion = new Companion(null);
            private final String basePlanIdentifier;
            private final Offer offer;
            private final String productIdentifier;

            /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
            @Metadata
            public static final class Companion {
                private Companion() {
                }

                public final KSerializer<PlayStore> serializer() {
                    return PlayStoreSerializer.INSTANCE;
                }

                public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public PlayStore(String productIdentifier, String basePlanIdentifier, Offer offer) {
                super(null);
                Intrinsics.checkNotNullParameter(productIdentifier, "productIdentifier");
                Intrinsics.checkNotNullParameter(basePlanIdentifier, "basePlanIdentifier");
                Intrinsics.checkNotNullParameter(offer, "offer");
                this.productIdentifier = productIdentifier;
                this.basePlanIdentifier = basePlanIdentifier;
                this.offer = offer;
            }

            public static /* synthetic */ PlayStore copy$default(PlayStore playStore, String str, String str2, Offer offer, int i3, Object obj) {
                if ((i3 & 1) != 0) {
                    str = playStore.productIdentifier;
                }
                if ((i3 & 2) != 0) {
                    str2 = playStore.basePlanIdentifier;
                }
                if ((i3 & 4) != 0) {
                    offer = playStore.offer;
                }
                return playStore.copy(str, str2, offer);
            }

            public final String component1() {
                return this.productIdentifier;
            }

            public final String component2() {
                return this.basePlanIdentifier;
            }

            public final Offer component3() {
                return this.offer;
            }

            public final PlayStore copy(String productIdentifier, String basePlanIdentifier, Offer offer) {
                Intrinsics.checkNotNullParameter(productIdentifier, "productIdentifier");
                Intrinsics.checkNotNullParameter(basePlanIdentifier, "basePlanIdentifier");
                Intrinsics.checkNotNullParameter(offer, "offer");
                return new PlayStore(productIdentifier, basePlanIdentifier, offer);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof PlayStore)) {
                    return false;
                }
                PlayStore playStore = (PlayStore) obj;
                return Intrinsics.areEqual(this.productIdentifier, playStore.productIdentifier) && Intrinsics.areEqual(this.basePlanIdentifier, playStore.basePlanIdentifier) && Intrinsics.areEqual(this.offer, playStore.offer);
            }

            public final String getBasePlanIdentifier() {
                return this.basePlanIdentifier;
            }

            public final String getFullIdentifier() {
                Offer offer = this.offer;
                if (offer instanceof Offer.Automatic) {
                    return this.productIdentifier + Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR + this.basePlanIdentifier + ":sw-auto";
                }
                if (offer instanceof Offer.NoOffer) {
                    return this.productIdentifier + Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR + this.basePlanIdentifier + ":sw-none";
                }
                if (!(offer instanceof Offer.Specified)) {
                    throw new NoWhenBranchMatchedException();
                }
                return this.productIdentifier + Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR + this.basePlanIdentifier + Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR + ((Offer.Specified) offer).getOfferIdentifier();
            }

            public final Offer getOffer() {
                return this.offer;
            }

            public final String getProductIdentifier() {
                return this.productIdentifier;
            }

            public int hashCode() {
                return (((this.productIdentifier.hashCode() * 31) + this.basePlanIdentifier.hashCode()) * 31) + this.offer.hashCode();
            }

            @Override // com.superwall.sdk.models.product.CrossplatformProduct.StoreProduct
            public ProductItem.StoreProductType toStoreProductType() {
                return new ProductItem.StoreProductType.PlayStore(new PlayStoreProduct(null, this.productIdentifier, this.basePlanIdentifier, this.offer, 1, null));
            }

            public String toString() {
                return "PlayStore(productIdentifier=" + this.productIdentifier + ", basePlanIdentifier=" + this.basePlanIdentifier + ", offer=" + this.offer + ")";
            }

            @SerialName
            public static /* synthetic */ void getBasePlanIdentifier$annotations() {
            }

            @SerialName
            public static /* synthetic */ void getOffer$annotations() {
            }

            @SerialName
            public static /* synthetic */ void getProductIdentifier$annotations() {
            }
        }

        @JvmStatic
        public static final /* synthetic */ void write$Self(StoreProduct storeProduct, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
        }
    }

    public CrossplatformProduct(String compositeId, StoreProduct storeProduct, List<Entitlement> entitlements, String name) {
        Intrinsics.checkNotNullParameter(compositeId, "compositeId");
        Intrinsics.checkNotNullParameter(storeProduct, "storeProduct");
        Intrinsics.checkNotNullParameter(entitlements, "entitlements");
        Intrinsics.checkNotNullParameter(name, "name");
        this.compositeId = compositeId;
        this.storeProduct = storeProduct;
        this.entitlements = entitlements;
        this.name = name;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ CrossplatformProduct copy$default(CrossplatformProduct crossplatformProduct, String str, StoreProduct storeProduct, List list, String str2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = crossplatformProduct.compositeId;
        }
        if ((i3 & 2) != 0) {
            storeProduct = crossplatformProduct.storeProduct;
        }
        if ((i3 & 4) != 0) {
            list = crossplatformProduct.entitlements;
        }
        if ((i3 & 8) != 0) {
            str2 = crossplatformProduct.name;
        }
        return crossplatformProduct.copy(str, storeProduct, list, str2);
    }

    public final String component1() {
        return this.compositeId;
    }

    public final StoreProduct component2() {
        return this.storeProduct;
    }

    public final List<Entitlement> component3() {
        return this.entitlements;
    }

    public final String component4() {
        return this.name;
    }

    public final CrossplatformProduct copy(String compositeId, StoreProduct storeProduct, List<Entitlement> entitlements, String name) {
        Intrinsics.checkNotNullParameter(compositeId, "compositeId");
        Intrinsics.checkNotNullParameter(storeProduct, "storeProduct");
        Intrinsics.checkNotNullParameter(entitlements, "entitlements");
        Intrinsics.checkNotNullParameter(name, "name");
        return new CrossplatformProduct(compositeId, storeProduct, entitlements, name);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CrossplatformProduct)) {
            return false;
        }
        CrossplatformProduct crossplatformProduct = (CrossplatformProduct) obj;
        return Intrinsics.areEqual(this.compositeId, crossplatformProduct.compositeId) && Intrinsics.areEqual(this.storeProduct, crossplatformProduct.storeProduct) && Intrinsics.areEqual(this.entitlements, crossplatformProduct.entitlements) && Intrinsics.areEqual(this.name, crossplatformProduct.name);
    }

    public final String getCompositeId() {
        return this.compositeId;
    }

    public final List<Entitlement> getEntitlements() {
        return this.entitlements;
    }

    public final String getFullProductId() {
        String str = this.compositeId;
        if (str.length() <= 0) {
            str = null;
        }
        if (str != null) {
            return str;
        }
        StoreProduct storeProduct = this.storeProduct;
        if (storeProduct instanceof StoreProduct.PlayStore) {
            return ((StoreProduct.PlayStore) storeProduct).getFullIdentifier();
        }
        if (storeProduct instanceof StoreProduct.AppStore) {
            return ((StoreProduct.AppStore) storeProduct).getProductIdentifier();
        }
        if (storeProduct instanceof StoreProduct.Stripe) {
            return ((StoreProduct.Stripe) storeProduct).getProductIdentifier();
        }
        if (storeProduct instanceof StoreProduct.Paddle) {
            return ((StoreProduct.Paddle) storeProduct).getProductIdentifier();
        }
        if (storeProduct instanceof StoreProduct.Custom) {
            return ((StoreProduct.Custom) storeProduct).getProductIdentifier();
        }
        if (storeProduct instanceof StoreProduct.Other) {
            return "";
        }
        throw new NoWhenBranchMatchedException();
    }

    public final String getName() {
        return this.name;
    }

    public final StoreProduct getStoreProduct() {
        return this.storeProduct;
    }

    public int hashCode() {
        return (((((this.compositeId.hashCode() * 31) + this.storeProduct.hashCode()) * 31) + this.entitlements.hashCode()) * 31) + this.name.hashCode();
    }

    public String toString() {
        return "CrossplatformProduct(compositeId=" + this.compositeId + ", storeProduct=" + this.storeProduct + ", entitlements=" + this.entitlements + ", name=" + this.name + ")";
    }

    @SerialName
    public static /* synthetic */ void getCompositeId$annotations() {
    }

    @SerialName
    public static /* synthetic */ void getEntitlements$annotations() {
    }

    @SerialName
    public static /* synthetic */ void getName$annotations() {
    }

    @SerialName
    public static /* synthetic */ void getStoreProduct$annotations() {
    }
}
