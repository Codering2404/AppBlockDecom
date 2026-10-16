package com.superwall.sdk.store;

import com.superwall.sdk.models.paywall.Paywall;
import com.superwall.sdk.models.product.ProductItem;
import com.superwall.sdk.store.abstractions.product.StoreProduct;
import java.util.List;
import java.util.Map;
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
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class GetProductsResponse {
    private final Paywall paywall;
    private final List<ProductItem> productItems;
    private final Map<String, StoreProduct> productsByFullId;

    public GetProductsResponse(Map<String, StoreProduct> productsByFullId, List<ProductItem> productItems, Paywall paywall) {
        Intrinsics.checkNotNullParameter(productsByFullId, "productsByFullId");
        Intrinsics.checkNotNullParameter(productItems, "productItems");
        this.productsByFullId = productsByFullId;
        this.productItems = productItems;
        this.paywall = paywall;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ GetProductsResponse copy$default(GetProductsResponse getProductsResponse, Map map, List list, Paywall paywall, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            map = getProductsResponse.productsByFullId;
        }
        if ((i3 & 2) != 0) {
            list = getProductsResponse.productItems;
        }
        if ((i3 & 4) != 0) {
            paywall = getProductsResponse.paywall;
        }
        return getProductsResponse.copy(map, list, paywall);
    }

    public final Map<String, StoreProduct> component1() {
        return this.productsByFullId;
    }

    public final List<ProductItem> component2() {
        return this.productItems;
    }

    public final Paywall component3() {
        return this.paywall;
    }

    public final GetProductsResponse copy(Map<String, StoreProduct> productsByFullId, List<ProductItem> productItems, Paywall paywall) {
        Intrinsics.checkNotNullParameter(productsByFullId, "productsByFullId");
        Intrinsics.checkNotNullParameter(productItems, "productItems");
        return new GetProductsResponse(productsByFullId, productItems, paywall);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GetProductsResponse)) {
            return false;
        }
        GetProductsResponse getProductsResponse = (GetProductsResponse) obj;
        return Intrinsics.areEqual(this.productsByFullId, getProductsResponse.productsByFullId) && Intrinsics.areEqual(this.productItems, getProductsResponse.productItems) && Intrinsics.areEqual(this.paywall, getProductsResponse.paywall);
    }

    public final Paywall getPaywall() {
        return this.paywall;
    }

    public final List<ProductItem> getProductItems() {
        return this.productItems;
    }

    public final Map<String, StoreProduct> getProductsByFullId() {
        return this.productsByFullId;
    }

    public int hashCode() {
        int iHashCode = ((this.productsByFullId.hashCode() * 31) + this.productItems.hashCode()) * 31;
        Paywall paywall = this.paywall;
        return iHashCode + (paywall == null ? 0 : paywall.hashCode());
    }

    public String toString() {
        return "GetProductsResponse(productsByFullId=" + this.productsByFullId + ", productItems=" + this.productItems + ", paywall=" + this.paywall + ")";
    }

    public /* synthetic */ GetProductsResponse(Map map, List list, Paywall paywall, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(map, list, (i3 & 4) != 0 ? null : paywall);
    }
}
