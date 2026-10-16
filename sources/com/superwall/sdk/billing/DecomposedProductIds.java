package com.superwall.sdk.billing;

import com.revenuecat.purchases.common.Constants;
import com.superwall.sdk.store.abstractions.product.BasePlanType;
import com.superwall.sdk.store.abstractions.product.OfferType;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

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
public final class DecomposedProductIds {
    public static final Companion Companion = new Companion(null);
    private final BasePlanType basePlanType;
    private final String fullId;
    private final OfferType offerType;
    private final String subscriptionId;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final DecomposedProductIds from(String productId) {
            Intrinsics.checkNotNullParameter(productId, "productId");
            List listV0 = StringsKt.V0(productId, new String[]{Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR}, false, 0, 6, null);
            String str = (String) CollectionsKt.getOrNull(listV0, 0);
            if (str == null) {
                str = "";
            }
            return new DecomposedProductIds(str, BasePlanType.Companion.from((String) CollectionsKt.getOrNull(listV0, 1)), OfferType.Companion.from((String) CollectionsKt.getOrNull(listV0, 2)), productId);
        }

        private Companion() {
        }
    }

    public DecomposedProductIds(String subscriptionId, BasePlanType basePlanType, OfferType offerType, String fullId) {
        Intrinsics.checkNotNullParameter(subscriptionId, "subscriptionId");
        Intrinsics.checkNotNullParameter(basePlanType, "basePlanType");
        Intrinsics.checkNotNullParameter(offerType, "offerType");
        Intrinsics.checkNotNullParameter(fullId, "fullId");
        this.subscriptionId = subscriptionId;
        this.basePlanType = basePlanType;
        this.offerType = offerType;
        this.fullId = fullId;
    }

    public static /* synthetic */ DecomposedProductIds copy$default(DecomposedProductIds decomposedProductIds, String str, BasePlanType basePlanType, OfferType offerType, String str2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = decomposedProductIds.subscriptionId;
        }
        if ((i3 & 2) != 0) {
            basePlanType = decomposedProductIds.basePlanType;
        }
        if ((i3 & 4) != 0) {
            offerType = decomposedProductIds.offerType;
        }
        if ((i3 & 8) != 0) {
            str2 = decomposedProductIds.fullId;
        }
        return decomposedProductIds.copy(str, basePlanType, offerType, str2);
    }

    public final String component1() {
        return this.subscriptionId;
    }

    public final BasePlanType component2() {
        return this.basePlanType;
    }

    public final OfferType component3() {
        return this.offerType;
    }

    public final String component4() {
        return this.fullId;
    }

    public final DecomposedProductIds copy(String subscriptionId, BasePlanType basePlanType, OfferType offerType, String fullId) {
        Intrinsics.checkNotNullParameter(subscriptionId, "subscriptionId");
        Intrinsics.checkNotNullParameter(basePlanType, "basePlanType");
        Intrinsics.checkNotNullParameter(offerType, "offerType");
        Intrinsics.checkNotNullParameter(fullId, "fullId");
        return new DecomposedProductIds(subscriptionId, basePlanType, offerType, fullId);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DecomposedProductIds)) {
            return false;
        }
        DecomposedProductIds decomposedProductIds = (DecomposedProductIds) obj;
        return Intrinsics.areEqual(this.subscriptionId, decomposedProductIds.subscriptionId) && Intrinsics.areEqual(this.basePlanType, decomposedProductIds.basePlanType) && Intrinsics.areEqual(this.offerType, decomposedProductIds.offerType) && Intrinsics.areEqual(this.fullId, decomposedProductIds.fullId);
    }

    public final String getBasePlanId() {
        return this.basePlanType.getSpecificId();
    }

    public final BasePlanType getBasePlanType() {
        return this.basePlanType;
    }

    public final String getFullId() {
        return this.fullId;
    }

    public final OfferType getOfferType() {
        return this.offerType;
    }

    public final String getSubscriptionId() {
        return this.subscriptionId;
    }

    public int hashCode() {
        return (((((this.subscriptionId.hashCode() * 31) + this.basePlanType.hashCode()) * 31) + this.offerType.hashCode()) * 31) + this.fullId.hashCode();
    }

    public String toString() {
        return "DecomposedProductIds(subscriptionId=" + this.subscriptionId + ", basePlanType=" + this.basePlanType + ", offerType=" + this.offerType + ", fullId=" + this.fullId + ")";
    }
}
