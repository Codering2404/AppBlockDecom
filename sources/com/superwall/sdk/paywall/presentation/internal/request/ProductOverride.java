package com.superwall.sdk.paywall.presentation.internal.request;

import com.superwall.sdk.store.abstractions.product.StoreProduct;
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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public abstract class ProductOverride {
    public static final Companion Companion = new Companion(null);

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class ById extends ProductOverride {
        private final String productId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ById(String productId) {
            super(null);
            Intrinsics.checkNotNullParameter(productId, "productId");
            this.productId = productId;
        }

        public static /* synthetic */ ById copy$default(ById byId, String str, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                str = byId.productId;
            }
            return byId.copy(str);
        }

        public final String component1() {
            return this.productId;
        }

        public final ById copy(String productId) {
            Intrinsics.checkNotNullParameter(productId, "productId");
            return new ById(productId);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof ById) && Intrinsics.areEqual(this.productId, ((ById) obj).productId);
        }

        public final String getProductId() {
            return this.productId;
        }

        public int hashCode() {
            return this.productId.hashCode();
        }

        public String toString() {
            return "ById(productId=" + this.productId + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class ByProduct extends ProductOverride {
        private final StoreProduct product;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ByProduct(StoreProduct product) {
            super(null);
            Intrinsics.checkNotNullParameter(product, "product");
            this.product = product;
        }

        public static /* synthetic */ ByProduct copy$default(ByProduct byProduct, StoreProduct storeProduct, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                storeProduct = byProduct.product;
            }
            return byProduct.copy(storeProduct);
        }

        public final StoreProduct component1() {
            return this.product;
        }

        public final ByProduct copy(StoreProduct product) {
            Intrinsics.checkNotNullParameter(product, "product");
            return new ByProduct(product);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof ByProduct) && Intrinsics.areEqual(this.product, ((ByProduct) obj).product);
        }

        public final StoreProduct getProduct() {
            return this.product;
        }

        public int hashCode() {
            return this.product.hashCode();
        }

        public String toString() {
            return "ByProduct(product=" + this.product + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final ProductOverride byId(String productId) {
            Intrinsics.checkNotNullParameter(productId, "productId");
            return new ById(productId);
        }

        public final ProductOverride byProduct(StoreProduct product) {
            Intrinsics.checkNotNullParameter(product, "product");
            return new ByProduct(product);
        }

        private Companion() {
        }
    }

    public /* synthetic */ ProductOverride(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private ProductOverride() {
    }
}
