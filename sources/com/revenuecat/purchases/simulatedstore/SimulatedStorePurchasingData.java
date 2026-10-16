package com.revenuecat.purchases.simulatedstore;

import com.revenuecat.purchases.ProductType;
import com.revenuecat.purchases.models.PurchasingData;
import com.revenuecat.purchases.models.StoreProduct;
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
/* JADX INFO: loaded from: classes6.dex */
@Metadata
public final class SimulatedStorePurchasingData implements PurchasingData {
    private final String productId;
    private final ProductType productType;
    private final StoreProduct storeProduct;

    public SimulatedStorePurchasingData(String productId, ProductType productType, StoreProduct storeProduct) {
        Intrinsics.checkNotNullParameter(productId, "productId");
        Intrinsics.checkNotNullParameter(productType, "productType");
        Intrinsics.checkNotNullParameter(storeProduct, "storeProduct");
        this.productId = productId;
        this.productType = productType;
        this.storeProduct = storeProduct;
    }

    public static /* synthetic */ SimulatedStorePurchasingData copy$default(SimulatedStorePurchasingData simulatedStorePurchasingData, String str, ProductType productType, StoreProduct storeProduct, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = simulatedStorePurchasingData.productId;
        }
        if ((i3 & 2) != 0) {
            productType = simulatedStorePurchasingData.productType;
        }
        if ((i3 & 4) != 0) {
            storeProduct = simulatedStorePurchasingData.storeProduct;
        }
        return simulatedStorePurchasingData.copy(str, productType, storeProduct);
    }

    public final String component1() {
        return this.productId;
    }

    public final ProductType component2() {
        return this.productType;
    }

    public final StoreProduct component3() {
        return this.storeProduct;
    }

    public final SimulatedStorePurchasingData copy(String productId, ProductType productType, StoreProduct storeProduct) {
        Intrinsics.checkNotNullParameter(productId, "productId");
        Intrinsics.checkNotNullParameter(productType, "productType");
        Intrinsics.checkNotNullParameter(storeProduct, "storeProduct");
        return new SimulatedStorePurchasingData(productId, productType, storeProduct);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SimulatedStorePurchasingData)) {
            return false;
        }
        SimulatedStorePurchasingData simulatedStorePurchasingData = (SimulatedStorePurchasingData) obj;
        return Intrinsics.areEqual(this.productId, simulatedStorePurchasingData.productId) && this.productType == simulatedStorePurchasingData.productType && Intrinsics.areEqual(this.storeProduct, simulatedStorePurchasingData.storeProduct);
    }

    @Override // com.revenuecat.purchases.models.PurchasingData
    public String getProductId() {
        return this.productId;
    }

    @Override // com.revenuecat.purchases.models.PurchasingData
    public ProductType getProductType() {
        return this.productType;
    }

    public final StoreProduct getStoreProduct() {
        return this.storeProduct;
    }

    public int hashCode() {
        return (((this.productId.hashCode() * 31) + this.productType.hashCode()) * 31) + this.storeProduct.hashCode();
    }

    public String toString() {
        return "SimulatedStorePurchasingData(productId=" + this.productId + ", productType=" + this.productType + ", storeProduct=" + this.storeProduct + ')';
    }
}
