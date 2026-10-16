package com.superwall.sdk.models.postback;

import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:71)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:37)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:35)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class StoreProduct {
    private final String productIdentifier;
    private final SWProduct swProduct;
    private final Map<String, Object> swProductTemplateVariablesJson;

    public StoreProduct(String productIdentifier, Map<String, ? extends Object> swProductTemplateVariablesJson, SWProduct swProduct) {
        Intrinsics.checkNotNullParameter(productIdentifier, "productIdentifier");
        Intrinsics.checkNotNullParameter(swProductTemplateVariablesJson, "swProductTemplateVariablesJson");
        Intrinsics.checkNotNullParameter(swProduct, "swProduct");
        this.productIdentifier = productIdentifier;
        this.swProductTemplateVariablesJson = swProductTemplateVariablesJson;
        this.swProduct = swProduct;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ StoreProduct copy$default(StoreProduct storeProduct, String str, Map map, SWProduct sWProduct, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = storeProduct.productIdentifier;
        }
        if ((i3 & 2) != 0) {
            map = storeProduct.swProductTemplateVariablesJson;
        }
        if ((i3 & 4) != 0) {
            sWProduct = storeProduct.swProduct;
        }
        return storeProduct.copy(str, map, sWProduct);
    }

    public final String component1() {
        return this.productIdentifier;
    }

    public final Map<String, Object> component2() {
        return this.swProductTemplateVariablesJson;
    }

    public final SWProduct component3() {
        return this.swProduct;
    }

    public final StoreProduct copy(String productIdentifier, Map<String, ? extends Object> swProductTemplateVariablesJson, SWProduct swProduct) {
        Intrinsics.checkNotNullParameter(productIdentifier, "productIdentifier");
        Intrinsics.checkNotNullParameter(swProductTemplateVariablesJson, "swProductTemplateVariablesJson");
        Intrinsics.checkNotNullParameter(swProduct, "swProduct");
        return new StoreProduct(productIdentifier, swProductTemplateVariablesJson, swProduct);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof StoreProduct)) {
            return false;
        }
        StoreProduct storeProduct = (StoreProduct) obj;
        return Intrinsics.areEqual(this.productIdentifier, storeProduct.productIdentifier) && Intrinsics.areEqual(this.swProductTemplateVariablesJson, storeProduct.swProductTemplateVariablesJson) && Intrinsics.areEqual(this.swProduct, storeProduct.swProduct);
    }

    public final String getProductIdentifier() {
        return this.productIdentifier;
    }

    public final SWProduct getSwProduct() {
        return this.swProduct;
    }

    public final Map<String, Object> getSwProductTemplateVariablesJson() {
        return this.swProductTemplateVariablesJson;
    }

    public int hashCode() {
        return (((this.productIdentifier.hashCode() * 31) + this.swProductTemplateVariablesJson.hashCode()) * 31) + this.swProduct.hashCode();
    }

    public String toString() {
        return "StoreProduct(productIdentifier=" + this.productIdentifier + ", swProductTemplateVariablesJson=" + this.swProductTemplateVariablesJson + ", swProduct=" + this.swProduct + ")";
    }
}
