package com.superwall.sdk.models.product;

import com.superwall.sdk.models.entitlements.Entitlement;
import com.superwall.sdk.models.product.ProductItem;
import java.lang.annotation.Annotation;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
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
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;

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
@Serializable(with = ProductItemSerializer.class)
public final class ProductItem implements TemplatingProduct {
    public static final Companion Companion = new Companion(null);
    private final String compositeId;
    private final Set<Entitlement> entitlements;
    private final String name;
    private final StoreProductType type;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final ProductItem fromCrossplatformProduct(CrossplatformProduct product) {
            Intrinsics.checkNotNullParameter(product, "product");
            String name = product.getName();
            Set set = CollectionsKt.toSet(product.getEntitlements());
            return new ProductItem(product.getCompositeId(), name, product.getStoreProduct().toStoreProductType(), set);
        }

        public final KSerializer<ProductItem> serializer() {
            return ProductItemSerializer.INSTANCE;
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @Serializable
    public static abstract class StoreProductType {
        public static final Companion Companion = new Companion(null);
        private static final Lazy<KSerializer<Object>> $cachedSerializer$delegate = LazyKt.a(LazyThreadSafetyMode.f139762b, new Function0() { // from class: h0.c
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return ProductItem.StoreProductType._init_$_anonymous_();
            }
        });

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        @Serializable
        public static final class AppStore extends StoreProductType {
            public static final Companion Companion = new Companion(null);
            private final AppStoreProduct product;

            /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
            @Metadata
            public static final class Companion {
                private Companion() {
                }

                public final KSerializer<AppStore> serializer() {
                    return ProductItem$StoreProductType$AppStore$$serializer.INSTANCE;
                }

                public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public /* synthetic */ AppStore(int i3, AppStoreProduct appStoreProduct, SerializationConstructorMarker serializationConstructorMarker) {
                super(i3, serializationConstructorMarker);
                if (1 != (i3 & 1)) {
                    PluginExceptionsKt.b(i3, 1, ProductItem$StoreProductType$AppStore$$serializer.INSTANCE.getDescriptor());
                }
                this.product = appStoreProduct;
            }

            public static /* synthetic */ AppStore copy$default(AppStore appStore, AppStoreProduct appStoreProduct, int i3, Object obj) {
                if ((i3 & 1) != 0) {
                    appStoreProduct = appStore.product;
                }
                return appStore.copy(appStoreProduct);
            }

            @JvmStatic
            public static final /* synthetic */ void write$Self$superwall_release(AppStore appStore, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
                StoreProductType.write$Self(appStore, compositeEncoder, serialDescriptor);
                compositeEncoder.C(serialDescriptor, 0, AppStoreProduct$$serializer.INSTANCE, appStore.product);
            }

            public final AppStoreProduct component1() {
                return this.product;
            }

            public final AppStore copy(AppStoreProduct product) {
                Intrinsics.checkNotNullParameter(product, "product");
                return new AppStore(product);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof AppStore) && Intrinsics.areEqual(this.product, ((AppStore) obj).product);
            }

            public final AppStoreProduct getProduct() {
                return this.product;
            }

            public int hashCode() {
                return this.product.hashCode();
            }

            public String toString() {
                return "AppStore(product=" + this.product + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AppStore(AppStoreProduct product) {
                super(null);
                Intrinsics.checkNotNullParameter(product, "product");
                this.product = product;
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class Companion {
            private Companion() {
            }

            private final /* synthetic */ KSerializer get$cachedSerializer() {
                return (KSerializer) StoreProductType.$cachedSerializer$delegate.getValue();
            }

            public final KSerializer<StoreProductType> serializer() {
                return get$cachedSerializer();
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        @Serializable
        public static final class Custom extends StoreProductType {
            public static final Companion Companion = new Companion(null);
            private final CustomStoreProduct product;

            /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
            @Metadata
            public static final class Companion {
                private Companion() {
                }

                public final KSerializer<Custom> serializer() {
                    return ProductItem$StoreProductType$Custom$$serializer.INSTANCE;
                }

                public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public /* synthetic */ Custom(int i3, CustomStoreProduct customStoreProduct, SerializationConstructorMarker serializationConstructorMarker) {
                super(i3, serializationConstructorMarker);
                if (1 != (i3 & 1)) {
                    PluginExceptionsKt.b(i3, 1, ProductItem$StoreProductType$Custom$$serializer.INSTANCE.getDescriptor());
                }
                this.product = customStoreProduct;
            }

            public static /* synthetic */ Custom copy$default(Custom custom, CustomStoreProduct customStoreProduct, int i3, Object obj) {
                if ((i3 & 1) != 0) {
                    customStoreProduct = custom.product;
                }
                return custom.copy(customStoreProduct);
            }

            @JvmStatic
            public static final /* synthetic */ void write$Self$superwall_release(Custom custom, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
                StoreProductType.write$Self(custom, compositeEncoder, serialDescriptor);
                compositeEncoder.C(serialDescriptor, 0, CustomStoreProduct$$serializer.INSTANCE, custom.product);
            }

            public final CustomStoreProduct component1() {
                return this.product;
            }

            public final Custom copy(CustomStoreProduct product) {
                Intrinsics.checkNotNullParameter(product, "product");
                return new Custom(product);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof Custom) && Intrinsics.areEqual(this.product, ((Custom) obj).product);
            }

            public final CustomStoreProduct getProduct() {
                return this.product;
            }

            public int hashCode() {
                return this.product.hashCode();
            }

            public String toString() {
                return "Custom(product=" + this.product + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Custom(CustomStoreProduct product) {
                super(null);
                Intrinsics.checkNotNullParameter(product, "product");
                this.product = product;
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        @Serializable
        public static final class Other extends StoreProductType {
            public static final Companion Companion = new Companion(null);
            private final UnknownStoreProduct product;

            /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
            @Metadata
            public static final class Companion {
                private Companion() {
                }

                public final KSerializer<Other> serializer() {
                    return ProductItem$StoreProductType$Other$$serializer.INSTANCE;
                }

                public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public /* synthetic */ Other(int i3, UnknownStoreProduct unknownStoreProduct, SerializationConstructorMarker serializationConstructorMarker) {
                super(i3, serializationConstructorMarker);
                if (1 != (i3 & 1)) {
                    PluginExceptionsKt.b(i3, 1, ProductItem$StoreProductType$Other$$serializer.INSTANCE.getDescriptor());
                }
                this.product = unknownStoreProduct;
            }

            public static /* synthetic */ Other copy$default(Other other, UnknownStoreProduct unknownStoreProduct, int i3, Object obj) {
                if ((i3 & 1) != 0) {
                    unknownStoreProduct = other.product;
                }
                return other.copy(unknownStoreProduct);
            }

            @JvmStatic
            public static final /* synthetic */ void write$Self$superwall_release(Other other, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
                StoreProductType.write$Self(other, compositeEncoder, serialDescriptor);
                compositeEncoder.C(serialDescriptor, 0, UnknownStoreProduct$$serializer.INSTANCE, other.product);
            }

            public final UnknownStoreProduct component1() {
                return this.product;
            }

            public final Other copy(UnknownStoreProduct product) {
                Intrinsics.checkNotNullParameter(product, "product");
                return new Other(product);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof Other) && Intrinsics.areEqual(this.product, ((Other) obj).product);
            }

            public final UnknownStoreProduct getProduct() {
                return this.product;
            }

            public int hashCode() {
                return this.product.hashCode();
            }

            public String toString() {
                return "Other(product=" + this.product + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Other(UnknownStoreProduct product) {
                super(null);
                Intrinsics.checkNotNullParameter(product, "product");
                this.product = product;
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        @Serializable
        public static final class Paddle extends StoreProductType {
            public static final Companion Companion = new Companion(null);
            private final PaddleProduct product;

            /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
            @Metadata
            public static final class Companion {
                private Companion() {
                }

                public final KSerializer<Paddle> serializer() {
                    return ProductItem$StoreProductType$Paddle$$serializer.INSTANCE;
                }

                public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public /* synthetic */ Paddle(int i3, PaddleProduct paddleProduct, SerializationConstructorMarker serializationConstructorMarker) {
                super(i3, serializationConstructorMarker);
                if (1 != (i3 & 1)) {
                    PluginExceptionsKt.b(i3, 1, ProductItem$StoreProductType$Paddle$$serializer.INSTANCE.getDescriptor());
                }
                this.product = paddleProduct;
            }

            public static /* synthetic */ Paddle copy$default(Paddle paddle, PaddleProduct paddleProduct, int i3, Object obj) {
                if ((i3 & 1) != 0) {
                    paddleProduct = paddle.product;
                }
                return paddle.copy(paddleProduct);
            }

            @JvmStatic
            public static final /* synthetic */ void write$Self$superwall_release(Paddle paddle, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
                StoreProductType.write$Self(paddle, compositeEncoder, serialDescriptor);
                compositeEncoder.C(serialDescriptor, 0, PaddleProduct$$serializer.INSTANCE, paddle.product);
            }

            public final PaddleProduct component1() {
                return this.product;
            }

            public final Paddle copy(PaddleProduct product) {
                Intrinsics.checkNotNullParameter(product, "product");
                return new Paddle(product);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof Paddle) && Intrinsics.areEqual(this.product, ((Paddle) obj).product);
            }

            public final PaddleProduct getProduct() {
                return this.product;
            }

            public int hashCode() {
                return this.product.hashCode();
            }

            public String toString() {
                return "Paddle(product=" + this.product + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Paddle(PaddleProduct product) {
                super(null);
                Intrinsics.checkNotNullParameter(product, "product");
                this.product = product;
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        @Serializable
        public static final class PlayStore extends StoreProductType {
            public static final Companion Companion = new Companion(null);
            private final PlayStoreProduct product;

            /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
            @Metadata
            public static final class Companion {
                private Companion() {
                }

                public final KSerializer<PlayStore> serializer() {
                    return ProductItem$StoreProductType$PlayStore$$serializer.INSTANCE;
                }

                public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public /* synthetic */ PlayStore(int i3, PlayStoreProduct playStoreProduct, SerializationConstructorMarker serializationConstructorMarker) {
                super(i3, serializationConstructorMarker);
                if (1 != (i3 & 1)) {
                    PluginExceptionsKt.b(i3, 1, ProductItem$StoreProductType$PlayStore$$serializer.INSTANCE.getDescriptor());
                }
                this.product = playStoreProduct;
            }

            public static /* synthetic */ PlayStore copy$default(PlayStore playStore, PlayStoreProduct playStoreProduct, int i3, Object obj) {
                if ((i3 & 1) != 0) {
                    playStoreProduct = playStore.product;
                }
                return playStore.copy(playStoreProduct);
            }

            @JvmStatic
            public static final /* synthetic */ void write$Self$superwall_release(PlayStore playStore, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
                StoreProductType.write$Self(playStore, compositeEncoder, serialDescriptor);
                compositeEncoder.C(serialDescriptor, 0, PlayStoreProductSerializer.INSTANCE, playStore.product);
            }

            public final PlayStoreProduct component1() {
                return this.product;
            }

            public final PlayStore copy(PlayStoreProduct product) {
                Intrinsics.checkNotNullParameter(product, "product");
                return new PlayStore(product);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof PlayStore) && Intrinsics.areEqual(this.product, ((PlayStore) obj).product);
            }

            public final PlayStoreProduct getProduct() {
                return this.product;
            }

            public int hashCode() {
                return this.product.hashCode();
            }

            public String toString() {
                return "PlayStore(product=" + this.product + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public PlayStore(PlayStoreProduct product) {
                super(null);
                Intrinsics.checkNotNullParameter(product, "product");
                this.product = product;
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        @Serializable
        public static final class Stripe extends StoreProductType {
            public static final Companion Companion = new Companion(null);
            private final StripeProduct product;

            /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
            @Metadata
            public static final class Companion {
                private Companion() {
                }

                public final KSerializer<Stripe> serializer() {
                    return ProductItem$StoreProductType$Stripe$$serializer.INSTANCE;
                }

                public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public /* synthetic */ Stripe(int i3, StripeProduct stripeProduct, SerializationConstructorMarker serializationConstructorMarker) {
                super(i3, serializationConstructorMarker);
                if (1 != (i3 & 1)) {
                    PluginExceptionsKt.b(i3, 1, ProductItem$StoreProductType$Stripe$$serializer.INSTANCE.getDescriptor());
                }
                this.product = stripeProduct;
            }

            public static /* synthetic */ Stripe copy$default(Stripe stripe, StripeProduct stripeProduct, int i3, Object obj) {
                if ((i3 & 1) != 0) {
                    stripeProduct = stripe.product;
                }
                return stripe.copy(stripeProduct);
            }

            @JvmStatic
            public static final /* synthetic */ void write$Self$superwall_release(Stripe stripe, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
                StoreProductType.write$Self(stripe, compositeEncoder, serialDescriptor);
                compositeEncoder.C(serialDescriptor, 0, StripeProduct$$serializer.INSTANCE, stripe.product);
            }

            public final StripeProduct component1() {
                return this.product;
            }

            public final Stripe copy(StripeProduct product) {
                Intrinsics.checkNotNullParameter(product, "product");
                return new Stripe(product);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof Stripe) && Intrinsics.areEqual(this.product, ((Stripe) obj).product);
            }

            public final StripeProduct getProduct() {
                return this.product;
            }

            public int hashCode() {
                return this.product.hashCode();
            }

            public String toString() {
                return "Stripe(product=" + this.product + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Stripe(StripeProduct product) {
                super(null);
                Intrinsics.checkNotNullParameter(product, "product");
                this.product = product;
            }
        }

        public /* synthetic */ StoreProductType(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final /* synthetic */ KSerializer _init_$_anonymous_() {
            return new SealedClassSerializer("com.superwall.sdk.models.product.ProductItem.StoreProductType", Reflection.b(StoreProductType.class), new KClass[]{Reflection.b(AppStore.class), Reflection.b(Custom.class), Reflection.b(Other.class), Reflection.b(Paddle.class), Reflection.b(PlayStore.class), Reflection.b(Stripe.class)}, new KSerializer[]{ProductItem$StoreProductType$AppStore$$serializer.INSTANCE, ProductItem$StoreProductType$Custom$$serializer.INSTANCE, ProductItem$StoreProductType$Other$$serializer.INSTANCE, ProductItem$StoreProductType$Paddle$$serializer.INSTANCE, ProductItem$StoreProductType$PlayStore$$serializer.INSTANCE, ProductItem$StoreProductType$Stripe$$serializer.INSTANCE}, new Annotation[0]);
        }

        private StoreProductType() {
        }

        public /* synthetic */ StoreProductType(int i3, SerializationConstructorMarker serializationConstructorMarker) {
        }

        @JvmStatic
        public static final /* synthetic */ void write$Self(StoreProductType storeProductType, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
        }
    }

    public ProductItem(String compositeId, String name, StoreProductType type, Set<Entitlement> entitlements) {
        Intrinsics.checkNotNullParameter(compositeId, "compositeId");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(entitlements, "entitlements");
        this.compositeId = compositeId;
        this.name = name;
        this.type = type;
        this.entitlements = entitlements;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ProductItem copy$default(ProductItem productItem, String str, String str2, StoreProductType storeProductType, Set set, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = productItem.compositeId;
        }
        if ((i3 & 2) != 0) {
            str2 = productItem.name;
        }
        if ((i3 & 4) != 0) {
            storeProductType = productItem.type;
        }
        if ((i3 & 8) != 0) {
            set = productItem.entitlements;
        }
        return productItem.copy(str, str2, storeProductType, set);
    }

    public final String component1() {
        return this.compositeId;
    }

    public final String component2() {
        return this.name;
    }

    public final StoreProductType component3() {
        return this.type;
    }

    public final Set<Entitlement> component4() {
        return this.entitlements;
    }

    public final ProductItem copy(String compositeId, String name, StoreProductType type, Set<Entitlement> entitlements) {
        Intrinsics.checkNotNullParameter(compositeId, "compositeId");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(entitlements, "entitlements");
        return new ProductItem(compositeId, name, type, entitlements);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ProductItem)) {
            return false;
        }
        ProductItem productItem = (ProductItem) obj;
        return Intrinsics.areEqual(this.compositeId, productItem.compositeId) && Intrinsics.areEqual(this.name, productItem.name) && Intrinsics.areEqual(this.type, productItem.type) && Intrinsics.areEqual(this.entitlements, productItem.entitlements);
    }

    public final String getCompositeId() {
        return this.compositeId;
    }

    public final Set<Entitlement> getEntitlements() {
        return this.entitlements;
    }

    public final String getFullProductId() {
        StoreProductType storeProductType = this.type;
        if (storeProductType instanceof StoreProductType.PlayStore) {
            return ((StoreProductType.PlayStore) storeProductType).getProduct().getFullIdentifier();
        }
        if (storeProductType instanceof StoreProductType.AppStore) {
            return ((StoreProductType.AppStore) storeProductType).getProduct().getFullIdentifier();
        }
        if (storeProductType instanceof StoreProductType.Stripe) {
            return ((StoreProductType.Stripe) storeProductType).getProduct().getFullIdentifier();
        }
        if (storeProductType instanceof StoreProductType.Paddle) {
            return ((StoreProductType.Paddle) storeProductType).getProduct().getFullIdentifier();
        }
        if (storeProductType instanceof StoreProductType.Custom) {
            return ((StoreProductType.Custom) storeProductType).getProduct().getFullIdentifier();
        }
        if (storeProductType instanceof StoreProductType.Other) {
            return ((StoreProductType.Other) storeProductType).getProduct().getProductIdentifier();
        }
        throw new NoWhenBranchMatchedException();
    }

    public final String getName() {
        return this.name;
    }

    public final StoreProductType getType() {
        return this.type;
    }

    public int hashCode() {
        return (((((this.compositeId.hashCode() * 31) + this.name.hashCode()) * 31) + this.type.hashCode()) * 31) + this.entitlements.hashCode();
    }

    public String toString() {
        return "ProductItem(compositeId=" + this.compositeId + ", name=" + this.name + ", type=" + this.type + ", entitlements=" + this.entitlements + ")";
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
    public static /* synthetic */ void getType$annotations() {
    }
}
