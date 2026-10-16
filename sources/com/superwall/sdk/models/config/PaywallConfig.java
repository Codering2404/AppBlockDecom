package com.superwall.sdk.models.config;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.ArrayListSerializer;
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
@Serializable
public final class PaywallConfig {
    private String identifier;
    private List<ProductConfig> products;
    public static final Companion Companion = new Companion(null);
    private static final KSerializer<Object>[] $childSerializers = {null, new ArrayListSerializer(PaywallConfig$ProductConfig$$serializer.INSTANCE)};

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        private Companion() {
        }

        public final KSerializer<PaywallConfig> serializer() {
            return PaywallConfig$$serializer.INSTANCE;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @Serializable
    public static final class ProductConfig {
        public static final Companion Companion = new Companion(null);
        private String identifier;

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class Companion {
            private Companion() {
            }

            public final KSerializer<ProductConfig> serializer() {
                return PaywallConfig$ProductConfig$$serializer.INSTANCE;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public /* synthetic */ ProductConfig(int i3, String str, SerializationConstructorMarker serializationConstructorMarker) {
            if (1 != (i3 & 1)) {
                PluginExceptionsKt.b(i3, 1, PaywallConfig$ProductConfig$$serializer.INSTANCE.getDescriptor());
            }
            this.identifier = str;
        }

        public static /* synthetic */ ProductConfig copy$default(ProductConfig productConfig, String str, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                str = productConfig.identifier;
            }
            return productConfig.copy(str);
        }

        public final String component1() {
            return this.identifier;
        }

        public final ProductConfig copy(String identifier) {
            Intrinsics.checkNotNullParameter(identifier, "identifier");
            return new ProductConfig(identifier);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof ProductConfig) && Intrinsics.areEqual(this.identifier, ((ProductConfig) obj).identifier);
        }

        public final String getIdentifier() {
            return this.identifier;
        }

        public int hashCode() {
            return this.identifier.hashCode();
        }

        public final void setIdentifier(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.identifier = str;
        }

        public String toString() {
            return "ProductConfig(identifier=" + this.identifier + ")";
        }

        public ProductConfig(String identifier) {
            Intrinsics.checkNotNullParameter(identifier, "identifier");
            this.identifier = identifier;
        }
    }

    public /* synthetic */ PaywallConfig(int i3, String str, List list, SerializationConstructorMarker serializationConstructorMarker) {
        if (3 != (i3 & 3)) {
            PluginExceptionsKt.b(i3, 3, PaywallConfig$$serializer.INSTANCE.getDescriptor());
        }
        this.identifier = str;
        this.products = list;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ PaywallConfig copy$default(PaywallConfig paywallConfig, String str, List list, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = paywallConfig.identifier;
        }
        if ((i3 & 2) != 0) {
            list = paywallConfig.products;
        }
        return paywallConfig.copy(str, list);
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$superwall_release(PaywallConfig paywallConfig, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
        KSerializer<Object>[] kSerializerArr = $childSerializers;
        compositeEncoder.y(serialDescriptor, 0, paywallConfig.identifier);
        compositeEncoder.C(serialDescriptor, 1, kSerializerArr[1], paywallConfig.products);
    }

    public final String component1() {
        return this.identifier;
    }

    public final List<ProductConfig> component2() {
        return this.products;
    }

    public final PaywallConfig copy(String identifier, List<ProductConfig> products) {
        Intrinsics.checkNotNullParameter(identifier, "identifier");
        Intrinsics.checkNotNullParameter(products, "products");
        return new PaywallConfig(identifier, products);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PaywallConfig)) {
            return false;
        }
        PaywallConfig paywallConfig = (PaywallConfig) obj;
        return Intrinsics.areEqual(this.identifier, paywallConfig.identifier) && Intrinsics.areEqual(this.products, paywallConfig.products);
    }

    public final String getIdentifier() {
        return this.identifier;
    }

    public final List<ProductConfig> getProducts() {
        return this.products;
    }

    public int hashCode() {
        return (this.identifier.hashCode() * 31) + this.products.hashCode();
    }

    public final void setIdentifier(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.identifier = str;
    }

    public final void setProducts(List<ProductConfig> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.products = list;
    }

    public String toString() {
        return "PaywallConfig(identifier=" + this.identifier + ", products=" + this.products + ")";
    }

    public PaywallConfig(String identifier, List<ProductConfig> products) {
        Intrinsics.checkNotNullParameter(identifier, "identifier");
        Intrinsics.checkNotNullParameter(products, "products");
        this.identifier = identifier;
        this.products = products;
    }
}
