package com.revenuecat.purchases.ui.revenuecatui.utils;

import com.revenuecat.purchases.ProductType;
import com.revenuecat.purchases.models.PurchasingData;
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
public final class PreviewPurchasingData implements PurchasingData {
    public static final int $stable = 0;
    private final String productId;

    public PreviewPurchasingData(String productId) {
        Intrinsics.checkNotNullParameter(productId, "productId");
        this.productId = productId;
    }

    public static /* synthetic */ PreviewPurchasingData copy$default(PreviewPurchasingData previewPurchasingData, String str, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = previewPurchasingData.productId;
        }
        return previewPurchasingData.copy(str);
    }

    public final String component1() {
        return this.productId;
    }

    public final PreviewPurchasingData copy(String productId) {
        Intrinsics.checkNotNullParameter(productId, "productId");
        return new PreviewPurchasingData(productId);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof PreviewPurchasingData) && Intrinsics.areEqual(this.productId, ((PreviewPurchasingData) obj).productId);
    }

    @Override // com.revenuecat.purchases.models.PurchasingData
    public /* synthetic */ String getProductId() {
        return this.productId;
    }

    @Override // com.revenuecat.purchases.models.PurchasingData
    public /* synthetic */ ProductType getProductType() {
        return ProductType.SUBS;
    }

    public int hashCode() {
        return this.productId.hashCode();
    }

    public String toString() {
        return "PreviewPurchasingData(productId=" + this.productId + ')';
    }
}
