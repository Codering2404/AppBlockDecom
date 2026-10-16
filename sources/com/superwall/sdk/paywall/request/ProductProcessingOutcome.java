package com.superwall.sdk.paywall.request;

import com.superwall.sdk.models.product.ProductVariable;
import java.util.List;
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
public final class ProductProcessingOutcome {
    private boolean isFreeTrialAvailable;
    private List<ProductVariable> productVariables;

    public ProductProcessingOutcome(List<ProductVariable> productVariables, boolean z2) {
        Intrinsics.checkNotNullParameter(productVariables, "productVariables");
        this.productVariables = productVariables;
        this.isFreeTrialAvailable = z2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ProductProcessingOutcome copy$default(ProductProcessingOutcome productProcessingOutcome, List list, boolean z2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            list = productProcessingOutcome.productVariables;
        }
        if ((i3 & 2) != 0) {
            z2 = productProcessingOutcome.isFreeTrialAvailable;
        }
        return productProcessingOutcome.copy(list, z2);
    }

    public final List<ProductVariable> component1() {
        return this.productVariables;
    }

    public final boolean component2() {
        return this.isFreeTrialAvailable;
    }

    public final ProductProcessingOutcome copy(List<ProductVariable> productVariables, boolean z2) {
        Intrinsics.checkNotNullParameter(productVariables, "productVariables");
        return new ProductProcessingOutcome(productVariables, z2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ProductProcessingOutcome)) {
            return false;
        }
        ProductProcessingOutcome productProcessingOutcome = (ProductProcessingOutcome) obj;
        return Intrinsics.areEqual(this.productVariables, productProcessingOutcome.productVariables) && this.isFreeTrialAvailable == productProcessingOutcome.isFreeTrialAvailable;
    }

    public final List<ProductVariable> getProductVariables() {
        return this.productVariables;
    }

    public int hashCode() {
        return (this.productVariables.hashCode() * 31) + Boolean.hashCode(this.isFreeTrialAvailable);
    }

    public final boolean isFreeTrialAvailable() {
        return this.isFreeTrialAvailable;
    }

    public final void setFreeTrialAvailable(boolean z2) {
        this.isFreeTrialAvailable = z2;
    }

    public final void setProductVariables(List<ProductVariable> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.productVariables = list;
    }

    public String toString() {
        return "ProductProcessingOutcome(productVariables=" + this.productVariables + ", isFreeTrialAvailable=" + this.isFreeTrialAvailable + ")";
    }
}
