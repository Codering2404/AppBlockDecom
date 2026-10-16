package com.superwall.sdk.models.postback;

import com.superwall.sdk.models.serialization.AnySerializer;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.LinkedHashMapSerializer;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

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
public final class PostbackProduct {
    private final String identifier;
    private final SWProduct product;
    private final Map<String, Object> productVariables;
    public static final Companion Companion = new Companion(null);
    private static final KSerializer<Object>[] $childSerializers = {null, new LinkedHashMapSerializer(StringSerializer.f142891a, AnySerializer.INSTANCE), null};

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        private Companion() {
        }

        public final KSerializer<PostbackProduct> serializer() {
            return PostbackProduct$$serializer.INSTANCE;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public /* synthetic */ PostbackProduct(int i3, String str, Map map, SWProduct sWProduct, SerializationConstructorMarker serializationConstructorMarker) {
        if (7 != (i3 & 7)) {
            PluginExceptionsKt.b(i3, 7, PostbackProduct$$serializer.INSTANCE.getDescriptor());
        }
        this.identifier = str;
        this.productVariables = map;
        this.product = sWProduct;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ PostbackProduct copy$default(PostbackProduct postbackProduct, String str, Map map, SWProduct sWProduct, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = postbackProduct.identifier;
        }
        if ((i3 & 2) != 0) {
            map = postbackProduct.productVariables;
        }
        if ((i3 & 4) != 0) {
            sWProduct = postbackProduct.product;
        }
        return postbackProduct.copy(str, map, sWProduct);
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$superwall_release(PostbackProduct postbackProduct, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
        KSerializer<Object>[] kSerializerArr = $childSerializers;
        compositeEncoder.y(serialDescriptor, 0, postbackProduct.identifier);
        compositeEncoder.C(serialDescriptor, 1, kSerializerArr[1], postbackProduct.productVariables);
        compositeEncoder.C(serialDescriptor, 2, SWProduct$$serializer.INSTANCE, postbackProduct.product);
    }

    public final String component1() {
        return this.identifier;
    }

    public final Map<String, Object> component2() {
        return this.productVariables;
    }

    public final SWProduct component3() {
        return this.product;
    }

    public final PostbackProduct copy(String identifier, Map<String, ? extends Object> productVariables, SWProduct product) {
        Intrinsics.checkNotNullParameter(identifier, "identifier");
        Intrinsics.checkNotNullParameter(productVariables, "productVariables");
        Intrinsics.checkNotNullParameter(product, "product");
        return new PostbackProduct(identifier, productVariables, product);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PostbackProduct)) {
            return false;
        }
        PostbackProduct postbackProduct = (PostbackProduct) obj;
        return Intrinsics.areEqual(this.identifier, postbackProduct.identifier) && Intrinsics.areEqual(this.productVariables, postbackProduct.productVariables) && Intrinsics.areEqual(this.product, postbackProduct.product);
    }

    public final String getIdentifier() {
        return this.identifier;
    }

    public final SWProduct getProduct() {
        return this.product;
    }

    public final Map<String, Object> getProductVariables() {
        return this.productVariables;
    }

    public int hashCode() {
        return (((this.identifier.hashCode() * 31) + this.productVariables.hashCode()) * 31) + this.product.hashCode();
    }

    public String toString() {
        return "PostbackProduct(identifier=" + this.identifier + ", productVariables=" + this.productVariables + ", product=" + this.product + ")";
    }

    public PostbackProduct(String identifier, Map<String, ? extends Object> productVariables, SWProduct product) {
        Intrinsics.checkNotNullParameter(identifier, "identifier");
        Intrinsics.checkNotNullParameter(productVariables, "productVariables");
        Intrinsics.checkNotNullParameter(product, "product");
        this.identifier = identifier;
        this.productVariables = productVariables;
        this.product = product;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public PostbackProduct(StoreProduct product) {
        this(product.getProductIdentifier(), product.getSwProductTemplateVariablesJson(), product.getSwProduct());
        Intrinsics.checkNotNullParameter(product, "product");
    }
}
