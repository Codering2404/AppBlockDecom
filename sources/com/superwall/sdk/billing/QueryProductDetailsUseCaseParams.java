package com.superwall.sdk.billing;

import java.util.List;
import java.util.Map;
import java.util.Set;
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
public final class QueryProductDetailsUseCaseParams implements UseCaseParams {
    private final boolean appInBackground;
    private final Map<String, List<DecomposedProductIds>> decomposedProductIdsBySubscriptionId;
    private final String productType;
    private final Set<String> subscriptionIds;

    public QueryProductDetailsUseCaseParams(Set<String> subscriptionIds, Map<String, List<DecomposedProductIds>> decomposedProductIdsBySubscriptionId, String productType, boolean z2) {
        Intrinsics.checkNotNullParameter(subscriptionIds, "subscriptionIds");
        Intrinsics.checkNotNullParameter(decomposedProductIdsBySubscriptionId, "decomposedProductIdsBySubscriptionId");
        Intrinsics.checkNotNullParameter(productType, "productType");
        this.subscriptionIds = subscriptionIds;
        this.decomposedProductIdsBySubscriptionId = decomposedProductIdsBySubscriptionId;
        this.productType = productType;
        this.appInBackground = z2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ QueryProductDetailsUseCaseParams copy$default(QueryProductDetailsUseCaseParams queryProductDetailsUseCaseParams, Set set, Map map, String str, boolean z2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            set = queryProductDetailsUseCaseParams.subscriptionIds;
        }
        if ((i3 & 2) != 0) {
            map = queryProductDetailsUseCaseParams.decomposedProductIdsBySubscriptionId;
        }
        if ((i3 & 4) != 0) {
            str = queryProductDetailsUseCaseParams.productType;
        }
        if ((i3 & 8) != 0) {
            z2 = queryProductDetailsUseCaseParams.appInBackground;
        }
        return queryProductDetailsUseCaseParams.copy(set, map, str, z2);
    }

    public final Set<String> component1() {
        return this.subscriptionIds;
    }

    public final Map<String, List<DecomposedProductIds>> component2() {
        return this.decomposedProductIdsBySubscriptionId;
    }

    public final String component3() {
        return this.productType;
    }

    public final boolean component4() {
        return this.appInBackground;
    }

    public final QueryProductDetailsUseCaseParams copy(Set<String> subscriptionIds, Map<String, List<DecomposedProductIds>> decomposedProductIdsBySubscriptionId, String productType, boolean z2) {
        Intrinsics.checkNotNullParameter(subscriptionIds, "subscriptionIds");
        Intrinsics.checkNotNullParameter(decomposedProductIdsBySubscriptionId, "decomposedProductIdsBySubscriptionId");
        Intrinsics.checkNotNullParameter(productType, "productType");
        return new QueryProductDetailsUseCaseParams(subscriptionIds, decomposedProductIdsBySubscriptionId, productType, z2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof QueryProductDetailsUseCaseParams)) {
            return false;
        }
        QueryProductDetailsUseCaseParams queryProductDetailsUseCaseParams = (QueryProductDetailsUseCaseParams) obj;
        return Intrinsics.areEqual(this.subscriptionIds, queryProductDetailsUseCaseParams.subscriptionIds) && Intrinsics.areEqual(this.decomposedProductIdsBySubscriptionId, queryProductDetailsUseCaseParams.decomposedProductIdsBySubscriptionId) && Intrinsics.areEqual(this.productType, queryProductDetailsUseCaseParams.productType) && this.appInBackground == queryProductDetailsUseCaseParams.appInBackground;
    }

    @Override // com.superwall.sdk.billing.UseCaseParams
    public boolean getAppInBackground() {
        return this.appInBackground;
    }

    public final Map<String, List<DecomposedProductIds>> getDecomposedProductIdsBySubscriptionId() {
        return this.decomposedProductIdsBySubscriptionId;
    }

    public final String getProductType() {
        return this.productType;
    }

    public final Set<String> getSubscriptionIds() {
        return this.subscriptionIds;
    }

    public int hashCode() {
        return (((((this.subscriptionIds.hashCode() * 31) + this.decomposedProductIdsBySubscriptionId.hashCode()) * 31) + this.productType.hashCode()) * 31) + Boolean.hashCode(this.appInBackground);
    }

    public String toString() {
        return "QueryProductDetailsUseCaseParams(subscriptionIds=" + this.subscriptionIds + ", decomposedProductIdsBySubscriptionId=" + this.decomposedProductIdsBySubscriptionId + ", productType=" + this.productType + ", appInBackground=" + this.appInBackground + ")";
    }
}
