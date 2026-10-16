package com.superwall.sdk.models.product;

import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;

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
@Serializable(with = ProductVariableSerializer.class)
public final class ProductVariable {
    public static final Companion Companion = new Companion(null);
    private final Map<String, Object> attributes;
    private final String name;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        private Companion() {
        }

        public final KSerializer<ProductVariable> serializer() {
            return ProductVariableSerializer.INSTANCE;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public ProductVariable(String name, Map<String, ? extends Object> attributes) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(attributes, "attributes");
        this.name = name;
        this.attributes = attributes;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ProductVariable copy$default(ProductVariable productVariable, String str, Map map, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = productVariable.name;
        }
        if ((i3 & 2) != 0) {
            map = productVariable.attributes;
        }
        return productVariable.copy(str, map);
    }

    public final String component1() {
        return this.name;
    }

    public final Map<String, Object> component2() {
        return this.attributes;
    }

    public final ProductVariable copy(String name, Map<String, ? extends Object> attributes) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(attributes, "attributes");
        return new ProductVariable(name, attributes);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ProductVariable)) {
            return false;
        }
        ProductVariable productVariable = (ProductVariable) obj;
        return Intrinsics.areEqual(this.name, productVariable.name) && Intrinsics.areEqual(this.attributes, productVariable.attributes);
    }

    public final Map<String, Object> getAttributes() {
        return this.attributes;
    }

    public final String getName() {
        return this.name;
    }

    public int hashCode() {
        return (this.name.hashCode() * 31) + this.attributes.hashCode();
    }

    public String toString() {
        return "ProductVariable(name=" + this.name + ", attributes=" + this.attributes + ")";
    }
}
