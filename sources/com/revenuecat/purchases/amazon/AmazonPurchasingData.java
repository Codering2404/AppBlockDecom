package com.revenuecat.purchases.amazon;

import com.revenuecat.purchases.ProductType;
import com.revenuecat.purchases.models.PurchasingData;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

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
/* JADX INFO: loaded from: classes4.dex */
@Metadata
public abstract class AmazonPurchasingData implements PurchasingData {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Product extends AmazonPurchasingData {
        private final AmazonStoreProduct storeProduct;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Product(AmazonStoreProduct storeProduct) {
            super(null);
            Intrinsics.checkNotNullParameter(storeProduct, "storeProduct");
            this.storeProduct = storeProduct;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Product) && Intrinsics.areEqual(this.storeProduct, ((Product) obj).storeProduct);
        }

        @Override // com.revenuecat.purchases.models.PurchasingData
        public String getProductId() {
            return this.storeProduct.getId();
        }

        @Override // com.revenuecat.purchases.models.PurchasingData
        public ProductType getProductType() {
            return this.storeProduct.getType();
        }

        public final AmazonStoreProduct getStoreProduct() {
            return this.storeProduct;
        }

        public int hashCode() {
            return this.storeProduct.hashCode();
        }

        public String toString() {
            return "Product(storeProduct=" + this.storeProduct + ')';
        }
    }

    public /* synthetic */ AmazonPurchasingData(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private AmazonPurchasingData() {
    }
}
