package com.revenuecat.purchases.models;

import com.revenuecat.purchases.PresentedOfferingContext;
import com.revenuecat.purchases.ProductType;
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
/* JADX INFO: loaded from: classes6.dex */
@Metadata
final class ComparableData {
    private final Boolean isAutoRenewing;
    private final String marketplace;
    private final String orderId;
    private final PresentedOfferingContext presentedOfferingContext;
    private final List<String> productIds;
    private final PurchaseState purchaseState;
    private final long purchaseTime;
    private final String purchaseToken;
    private final PurchaseType purchaseType;
    private final String signature;
    private final String storeUserID;
    private final String subscriptionOptionId;
    private final ProductType type;

    public ComparableData(String str, List<String> productIds, ProductType type, long j3, String purchaseToken, PurchaseState purchaseState, Boolean bool, String str2, PresentedOfferingContext presentedOfferingContext, String str3, PurchaseType purchaseType, String str4, String str5) {
        Intrinsics.checkNotNullParameter(productIds, "productIds");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(purchaseToken, "purchaseToken");
        Intrinsics.checkNotNullParameter(purchaseState, "purchaseState");
        Intrinsics.checkNotNullParameter(purchaseType, "purchaseType");
        this.orderId = str;
        this.productIds = productIds;
        this.type = type;
        this.purchaseTime = j3;
        this.purchaseToken = purchaseToken;
        this.purchaseState = purchaseState;
        this.isAutoRenewing = bool;
        this.signature = str2;
        this.presentedOfferingContext = presentedOfferingContext;
        this.storeUserID = str3;
        this.purchaseType = purchaseType;
        this.marketplace = str4;
        this.subscriptionOptionId = str5;
    }

    public final String component1() {
        return this.orderId;
    }

    public final String component10() {
        return this.storeUserID;
    }

    public final PurchaseType component11() {
        return this.purchaseType;
    }

    public final String component12() {
        return this.marketplace;
    }

    public final String component13() {
        return this.subscriptionOptionId;
    }

    public final List<String> component2() {
        return this.productIds;
    }

    public final ProductType component3() {
        return this.type;
    }

    public final long component4() {
        return this.purchaseTime;
    }

    public final String component5() {
        return this.purchaseToken;
    }

    public final PurchaseState component6() {
        return this.purchaseState;
    }

    public final Boolean component7() {
        return this.isAutoRenewing;
    }

    public final String component8() {
        return this.signature;
    }

    public final PresentedOfferingContext component9() {
        return this.presentedOfferingContext;
    }

    public final ComparableData copy(String str, List<String> productIds, ProductType type, long j3, String purchaseToken, PurchaseState purchaseState, Boolean bool, String str2, PresentedOfferingContext presentedOfferingContext, String str3, PurchaseType purchaseType, String str4, String str5) {
        Intrinsics.checkNotNullParameter(productIds, "productIds");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(purchaseToken, "purchaseToken");
        Intrinsics.checkNotNullParameter(purchaseState, "purchaseState");
        Intrinsics.checkNotNullParameter(purchaseType, "purchaseType");
        return new ComparableData(str, productIds, type, j3, purchaseToken, purchaseState, bool, str2, presentedOfferingContext, str3, purchaseType, str4, str5);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ComparableData)) {
            return false;
        }
        ComparableData comparableData = (ComparableData) obj;
        return Intrinsics.areEqual(this.orderId, comparableData.orderId) && Intrinsics.areEqual(this.productIds, comparableData.productIds) && this.type == comparableData.type && this.purchaseTime == comparableData.purchaseTime && Intrinsics.areEqual(this.purchaseToken, comparableData.purchaseToken) && this.purchaseState == comparableData.purchaseState && Intrinsics.areEqual(this.isAutoRenewing, comparableData.isAutoRenewing) && Intrinsics.areEqual(this.signature, comparableData.signature) && Intrinsics.areEqual(this.presentedOfferingContext, comparableData.presentedOfferingContext) && Intrinsics.areEqual(this.storeUserID, comparableData.storeUserID) && this.purchaseType == comparableData.purchaseType && Intrinsics.areEqual(this.marketplace, comparableData.marketplace) && Intrinsics.areEqual(this.subscriptionOptionId, comparableData.subscriptionOptionId);
    }

    public final String getMarketplace() {
        return this.marketplace;
    }

    public final String getOrderId() {
        return this.orderId;
    }

    public final PresentedOfferingContext getPresentedOfferingContext() {
        return this.presentedOfferingContext;
    }

    public final List<String> getProductIds() {
        return this.productIds;
    }

    public final PurchaseState getPurchaseState() {
        return this.purchaseState;
    }

    public final long getPurchaseTime() {
        return this.purchaseTime;
    }

    public final String getPurchaseToken() {
        return this.purchaseToken;
    }

    public final PurchaseType getPurchaseType() {
        return this.purchaseType;
    }

    public final String getSignature() {
        return this.signature;
    }

    public final String getStoreUserID() {
        return this.storeUserID;
    }

    public final String getSubscriptionOptionId() {
        return this.subscriptionOptionId;
    }

    public final ProductType getType() {
        return this.type;
    }

    public int hashCode() {
        String str = this.orderId;
        int iHashCode = (((((((((((str == null ? 0 : str.hashCode()) * 31) + this.productIds.hashCode()) * 31) + this.type.hashCode()) * 31) + Long.hashCode(this.purchaseTime)) * 31) + this.purchaseToken.hashCode()) * 31) + this.purchaseState.hashCode()) * 31;
        Boolean bool = this.isAutoRenewing;
        int iHashCode2 = (iHashCode + (bool == null ? 0 : bool.hashCode())) * 31;
        String str2 = this.signature;
        int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        PresentedOfferingContext presentedOfferingContext = this.presentedOfferingContext;
        int iHashCode4 = (iHashCode3 + (presentedOfferingContext == null ? 0 : presentedOfferingContext.hashCode())) * 31;
        String str3 = this.storeUserID;
        int iHashCode5 = (((iHashCode4 + (str3 == null ? 0 : str3.hashCode())) * 31) + this.purchaseType.hashCode()) * 31;
        String str4 = this.marketplace;
        int iHashCode6 = (iHashCode5 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.subscriptionOptionId;
        return iHashCode6 + (str5 != null ? str5.hashCode() : 0);
    }

    public final Boolean isAutoRenewing() {
        return this.isAutoRenewing;
    }

    public String toString() {
        return "ComparableData(orderId=" + this.orderId + ", productIds=" + this.productIds + ", type=" + this.type + ", purchaseTime=" + this.purchaseTime + ", purchaseToken=" + this.purchaseToken + ", purchaseState=" + this.purchaseState + ", isAutoRenewing=" + this.isAutoRenewing + ", signature=" + this.signature + ", presentedOfferingContext=" + this.presentedOfferingContext + ", storeUserID=" + this.storeUserID + ", purchaseType=" + this.purchaseType + ", marketplace=" + this.marketplace + ", subscriptionOptionId=" + this.subscriptionOptionId + ')';
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ComparableData(StoreTransaction storeTransaction) {
        this(storeTransaction.getOrderId(), storeTransaction.getProductIds(), storeTransaction.getType(), storeTransaction.getPurchaseTime(), storeTransaction.getPurchaseToken(), storeTransaction.getPurchaseState(), storeTransaction.isAutoRenewing(), storeTransaction.getSignature(), storeTransaction.getPresentedOfferingContext(), storeTransaction.getStoreUserID(), storeTransaction.getPurchaseType(), storeTransaction.getMarketplace(), storeTransaction.getSubscriptionOptionId());
        Intrinsics.checkNotNullParameter(storeTransaction, "storeTransaction");
    }
}
