package com.superwall.sdk.paywall.view.webview.templating.models;

import com.superwall.sdk.models.product.ProductItem;
import com.superwall.sdk.models.product.ProductItemSerializer;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerialName;
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
public final class ProductTemplate {
    private final String eventName;
    private final List<ProductItem> products;
    public static final Companion Companion = new Companion(null);
    private static final KSerializer<Object>[] $childSerializers = {null, new ArrayListSerializer(ProductItemSerializer.INSTANCE)};

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        private Companion() {
        }

        public final KSerializer<ProductTemplate> serializer() {
            return ProductTemplate$$serializer.INSTANCE;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public /* synthetic */ ProductTemplate(int i3, String str, List list, SerializationConstructorMarker serializationConstructorMarker) {
        if (3 != (i3 & 3)) {
            PluginExceptionsKt.b(i3, 3, ProductTemplate$$serializer.INSTANCE.getDescriptor());
        }
        this.eventName = str;
        this.products = list;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ProductTemplate copy$default(ProductTemplate productTemplate, String str, List list, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = productTemplate.eventName;
        }
        if ((i3 & 2) != 0) {
            list = productTemplate.products;
        }
        return productTemplate.copy(str, list);
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$superwall_release(ProductTemplate productTemplate, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
        KSerializer<Object>[] kSerializerArr = $childSerializers;
        compositeEncoder.y(serialDescriptor, 0, productTemplate.eventName);
        compositeEncoder.C(serialDescriptor, 1, kSerializerArr[1], productTemplate.products);
    }

    public final String component1() {
        return this.eventName;
    }

    public final List<ProductItem> component2() {
        return this.products;
    }

    public final ProductTemplate copy(String eventName, List<ProductItem> products) {
        Intrinsics.checkNotNullParameter(eventName, "eventName");
        Intrinsics.checkNotNullParameter(products, "products");
        return new ProductTemplate(eventName, products);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ProductTemplate)) {
            return false;
        }
        ProductTemplate productTemplate = (ProductTemplate) obj;
        return Intrinsics.areEqual(this.eventName, productTemplate.eventName) && Intrinsics.areEqual(this.products, productTemplate.products);
    }

    public final String getEventName() {
        return this.eventName;
    }

    public final List<ProductItem> getProducts() {
        return this.products;
    }

    public int hashCode() {
        return (this.eventName.hashCode() * 31) + this.products.hashCode();
    }

    public String toString() {
        return "ProductTemplate(eventName=" + this.eventName + ", products=" + this.products + ")";
    }

    public ProductTemplate(String eventName, List<ProductItem> products) {
        Intrinsics.checkNotNullParameter(eventName, "eventName");
        Intrinsics.checkNotNullParameter(products, "products");
        this.eventName = eventName;
        this.products = products;
    }

    @SerialName
    public static /* synthetic */ void getEventName$annotations() {
    }

    @SerialName
    public static /* synthetic */ void getProducts$annotations() {
    }
}
