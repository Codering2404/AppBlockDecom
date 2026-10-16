package com.revenuecat.purchases.common.offerings;

import com.revenuecat.purchases.Offerings;
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
/* JADX INFO: loaded from: classes5.dex */
@Metadata
public final class OfferingsResultData {
    private final Set<String> notFoundProductIds;
    private final Offerings offerings;
    private final Set<String> requestedProductIds;

    public OfferingsResultData(Offerings offerings, Set<String> requestedProductIds, Set<String> notFoundProductIds) {
        Intrinsics.checkNotNullParameter(offerings, "offerings");
        Intrinsics.checkNotNullParameter(requestedProductIds, "requestedProductIds");
        Intrinsics.checkNotNullParameter(notFoundProductIds, "notFoundProductIds");
        this.offerings = offerings;
        this.requestedProductIds = requestedProductIds;
        this.notFoundProductIds = notFoundProductIds;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ OfferingsResultData copy$default(OfferingsResultData offeringsResultData, Offerings offerings, Set set, Set set2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            offerings = offeringsResultData.offerings;
        }
        if ((i3 & 2) != 0) {
            set = offeringsResultData.requestedProductIds;
        }
        if ((i3 & 4) != 0) {
            set2 = offeringsResultData.notFoundProductIds;
        }
        return offeringsResultData.copy(offerings, set, set2);
    }

    public final Offerings component1() {
        return this.offerings;
    }

    public final Set<String> component2() {
        return this.requestedProductIds;
    }

    public final Set<String> component3() {
        return this.notFoundProductIds;
    }

    public final OfferingsResultData copy(Offerings offerings, Set<String> requestedProductIds, Set<String> notFoundProductIds) {
        Intrinsics.checkNotNullParameter(offerings, "offerings");
        Intrinsics.checkNotNullParameter(requestedProductIds, "requestedProductIds");
        Intrinsics.checkNotNullParameter(notFoundProductIds, "notFoundProductIds");
        return new OfferingsResultData(offerings, requestedProductIds, notFoundProductIds);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof OfferingsResultData)) {
            return false;
        }
        OfferingsResultData offeringsResultData = (OfferingsResultData) obj;
        return Intrinsics.areEqual(this.offerings, offeringsResultData.offerings) && Intrinsics.areEqual(this.requestedProductIds, offeringsResultData.requestedProductIds) && Intrinsics.areEqual(this.notFoundProductIds, offeringsResultData.notFoundProductIds);
    }

    public final Set<String> getNotFoundProductIds() {
        return this.notFoundProductIds;
    }

    public final Offerings getOfferings() {
        return this.offerings;
    }

    public final Set<String> getRequestedProductIds() {
        return this.requestedProductIds;
    }

    public int hashCode() {
        return (((this.offerings.hashCode() * 31) + this.requestedProductIds.hashCode()) * 31) + this.notFoundProductIds.hashCode();
    }

    public String toString() {
        return "OfferingsResultData(offerings=" + this.offerings + ", requestedProductIds=" + this.requestedProductIds + ", notFoundProductIds=" + this.notFoundProductIds + ')';
    }
}
