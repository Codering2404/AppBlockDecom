package com.revenuecat.purchases.common.responses;

import com.applovin.impl.mediation.nativeAds.xNe.qRMDmh;
import com.facebook.internal.NativeProtocol;
import com.facebook.internal.Utility;
import com.revenuecat.purchases.OwnershipType;
import com.revenuecat.purchases.PeriodType;
import com.revenuecat.purchases.Store;
import com.revenuecat.purchases.StoreSerializer;
import com.revenuecat.purchases.models.Price;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.revenuecat.purchases.utils.serializers.ISO8601DateSerializer;
import com.sun.jna.Function;
import java.text.NumberFormat;
import java.util.Currency;
import java.util.Date;
import java.util.Locale;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerialName;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

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
/* JADX INFO: loaded from: classes5.dex */
@Metadata
@Serializable
public final class SubscriptionInfoResponse {
    private final Date autoResumeDate;
    private final Date billingIssuesDetectedAt;
    private final String displayName;
    private final Date expiresDate;
    private final Date gracePeriodExpiresDate;
    private final boolean isSandbox;
    private final String managementURL;
    private final Date originalPurchaseDate;
    private final OwnershipType ownershipType;
    private final PeriodType periodType;
    private final PriceResponse price;
    private final String productPlanIdentifier;
    private final Date purchaseDate;
    private final Date refundedAt;
    private final Store store;
    private final String storeTransactionId;
    private final Date unsubscribeDetectedAt;
    public static final Companion Companion = new Companion(null);
    private static final KSerializer<Object>[] $childSerializers = {null, null, null, null, null, null, null, null, OwnershipType.Companion.serializer(), PeriodType.Companion.serializer(), null, null, null, null, null, null, null};

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KSerializer<SubscriptionInfoResponse> serializer() {
            return SubscriptionInfoResponse$$serializer.INSTANCE;
        }

        private Companion() {
        }
    }

    @Deprecated
    public /* synthetic */ SubscriptionInfoResponse(int i3, @SerialName @Serializable(with = ISO8601DateSerializer.class) Date date, @SerialName @Serializable(with = ISO8601DateSerializer.class) Date date2, @SerialName @Serializable(with = ISO8601DateSerializer.class) Date date3, @SerialName Store store, @SerialName boolean z2, @SerialName @Serializable(with = ISO8601DateSerializer.class) Date date4, @SerialName @Serializable(with = ISO8601DateSerializer.class) Date date5, @SerialName @Serializable(with = ISO8601DateSerializer.class) Date date6, @SerialName OwnershipType ownershipType, @SerialName PeriodType periodType, @SerialName @Serializable(with = ISO8601DateSerializer.class) Date date7, @SerialName String str, @SerialName @Serializable(with = ISO8601DateSerializer.class) Date date8, @SerialName String str2, @SerialName PriceResponse priceResponse, @SerialName String str3, @SerialName String str4, SerializationConstructorMarker serializationConstructorMarker) {
        if (537 != (i3 & 537)) {
            PluginExceptionsKt.b(i3, 537, SubscriptionInfoResponse$$serializer.INSTANCE.getDescriptor());
        }
        this.purchaseDate = date;
        if ((i3 & 2) == 0) {
            this.originalPurchaseDate = null;
        } else {
            this.originalPurchaseDate = date2;
        }
        if ((i3 & 4) == 0) {
            this.expiresDate = null;
        } else {
            this.expiresDate = date3;
        }
        this.store = store;
        this.isSandbox = z2;
        if ((i3 & 32) == 0) {
            this.unsubscribeDetectedAt = null;
        } else {
            this.unsubscribeDetectedAt = date4;
        }
        if ((i3 & 64) == 0) {
            this.billingIssuesDetectedAt = null;
        } else {
            this.billingIssuesDetectedAt = date5;
        }
        if ((i3 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) == 0) {
            this.gracePeriodExpiresDate = null;
        } else {
            this.gracePeriodExpiresDate = date6;
        }
        if ((i3 & Function.MAX_NARGS) == 0) {
            this.ownershipType = OwnershipType.UNKNOWN;
        } else {
            this.ownershipType = ownershipType;
        }
        this.periodType = periodType;
        if ((i3 & 1024) == 0) {
            this.refundedAt = null;
        } else {
            this.refundedAt = date7;
        }
        if ((i3 & 2048) == 0) {
            this.storeTransactionId = null;
        } else {
            this.storeTransactionId = str;
        }
        if ((i3 & 4096) == 0) {
            this.autoResumeDate = null;
        } else {
            this.autoResumeDate = date8;
        }
        if ((i3 & Utility.DEFAULT_STREAM_BUFFER_SIZE) == 0) {
            this.displayName = null;
        } else {
            this.displayName = str2;
        }
        if ((i3 & 16384) == 0) {
            this.price = null;
        } else {
            this.price = priceResponse;
        }
        if ((32768 & i3) == 0) {
            this.productPlanIdentifier = null;
        } else {
            this.productPlanIdentifier = str3;
        }
        if ((i3 & NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST) == 0) {
            this.managementURL = null;
        } else {
            this.managementURL = str4;
        }
    }

    public static /* synthetic */ SubscriptionInfoResponse copy$default(SubscriptionInfoResponse subscriptionInfoResponse, Date date, Date date2, Date date3, Store store, boolean z2, Date date4, Date date5, Date date6, OwnershipType ownershipType, PeriodType periodType, Date date7, String str, Date date8, String str2, PriceResponse priceResponse, String str3, String str4, int i3, Object obj) {
        String str5;
        String str6;
        Date date9;
        SubscriptionInfoResponse subscriptionInfoResponse2;
        PriceResponse priceResponse2;
        Date date10;
        Date date11;
        Store store2;
        boolean z3;
        Date date12;
        Date date13;
        Date date14;
        OwnershipType ownershipType2;
        PeriodType periodType2;
        Date date15;
        String str7;
        Date date16;
        String str8;
        Date date17 = (i3 & 1) != 0 ? subscriptionInfoResponse.purchaseDate : date;
        Date date18 = (i3 & 2) != 0 ? subscriptionInfoResponse.originalPurchaseDate : date2;
        Date date19 = (i3 & 4) != 0 ? subscriptionInfoResponse.expiresDate : date3;
        Store store3 = (i3 & 8) != 0 ? subscriptionInfoResponse.store : store;
        boolean z4 = (i3 & 16) != 0 ? subscriptionInfoResponse.isSandbox : z2;
        Date date20 = (i3 & 32) != 0 ? subscriptionInfoResponse.unsubscribeDetectedAt : date4;
        Date date21 = (i3 & 64) != 0 ? subscriptionInfoResponse.billingIssuesDetectedAt : date5;
        Date date22 = (i3 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0 ? subscriptionInfoResponse.gracePeriodExpiresDate : date6;
        OwnershipType ownershipType3 = (i3 & Function.MAX_NARGS) != 0 ? subscriptionInfoResponse.ownershipType : ownershipType;
        PeriodType periodType3 = (i3 & 512) != 0 ? subscriptionInfoResponse.periodType : periodType;
        Date date23 = (i3 & 1024) != 0 ? subscriptionInfoResponse.refundedAt : date7;
        String str9 = (i3 & 2048) != 0 ? subscriptionInfoResponse.storeTransactionId : str;
        Date date24 = (i3 & 4096) != 0 ? subscriptionInfoResponse.autoResumeDate : date8;
        String str10 = (i3 & Utility.DEFAULT_STREAM_BUFFER_SIZE) != 0 ? subscriptionInfoResponse.displayName : str2;
        Date date25 = date17;
        PriceResponse priceResponse3 = (i3 & 16384) != 0 ? subscriptionInfoResponse.price : priceResponse;
        String str11 = (i3 & 32768) != 0 ? subscriptionInfoResponse.productPlanIdentifier : str3;
        if ((i3 & NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST) != 0) {
            str6 = str11;
            str5 = subscriptionInfoResponse.managementURL;
            priceResponse2 = priceResponse3;
            date10 = date18;
            date11 = date19;
            store2 = store3;
            z3 = z4;
            date12 = date20;
            date13 = date21;
            date14 = date22;
            ownershipType2 = ownershipType3;
            periodType2 = periodType3;
            date15 = date23;
            str7 = str9;
            date16 = date24;
            str8 = str10;
            date9 = date25;
            subscriptionInfoResponse2 = subscriptionInfoResponse;
        } else {
            str5 = str4;
            str6 = str11;
            date9 = date25;
            subscriptionInfoResponse2 = subscriptionInfoResponse;
            priceResponse2 = priceResponse3;
            date10 = date18;
            date11 = date19;
            store2 = store3;
            z3 = z4;
            date12 = date20;
            date13 = date21;
            date14 = date22;
            ownershipType2 = ownershipType3;
            periodType2 = periodType3;
            date15 = date23;
            str7 = str9;
            date16 = date24;
            str8 = str10;
        }
        return subscriptionInfoResponse2.copy(date9, date10, date11, store2, z3, date12, date13, date14, ownershipType2, periodType2, date15, str7, date16, str8, priceResponse2, str6, str5);
    }

    @SerialName
    @Serializable(with = ISO8601DateSerializer.class)
    public static /* synthetic */ void getAutoResumeDate$annotations() {
    }

    @SerialName
    @Serializable(with = ISO8601DateSerializer.class)
    public static /* synthetic */ void getBillingIssuesDetectedAt$annotations() {
    }

    @SerialName
    public static /* synthetic */ void getDisplayName$annotations() {
    }

    @SerialName
    @Serializable(with = ISO8601DateSerializer.class)
    public static /* synthetic */ void getExpiresDate$annotations() {
    }

    @SerialName
    @Serializable(with = ISO8601DateSerializer.class)
    public static /* synthetic */ void getGracePeriodExpiresDate$annotations() {
    }

    @SerialName
    public static /* synthetic */ void getManagementURL$annotations() {
    }

    @SerialName
    @Serializable(with = ISO8601DateSerializer.class)
    public static /* synthetic */ void getOriginalPurchaseDate$annotations() {
    }

    @SerialName
    public static /* synthetic */ void getOwnershipType$annotations() {
    }

    @SerialName
    public static /* synthetic */ void getPeriodType$annotations() {
    }

    @SerialName
    public static /* synthetic */ void getPrice$annotations() {
    }

    @SerialName
    public static /* synthetic */ void getProductPlanIdentifier$annotations() {
    }

    @SerialName
    @Serializable(with = ISO8601DateSerializer.class)
    public static /* synthetic */ void getPurchaseDate$annotations() {
    }

    @SerialName
    @Serializable(with = ISO8601DateSerializer.class)
    public static /* synthetic */ void getRefundedAt$annotations() {
    }

    @SerialName
    public static /* synthetic */ void getStore$annotations() {
    }

    @SerialName
    public static /* synthetic */ void getStoreTransactionId$annotations() {
    }

    @SerialName
    @Serializable(with = ISO8601DateSerializer.class)
    public static /* synthetic */ void getUnsubscribeDetectedAt$annotations() {
    }

    @SerialName
    public static /* synthetic */ void isSandbox$annotations() {
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$purchases_defaultsBc8Release(SubscriptionInfoResponse subscriptionInfoResponse, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
        KSerializer<Object>[] kSerializerArr = $childSerializers;
        ISO8601DateSerializer iSO8601DateSerializer = ISO8601DateSerializer.INSTANCE;
        compositeEncoder.C(serialDescriptor, 0, iSO8601DateSerializer, subscriptionInfoResponse.purchaseDate);
        if (compositeEncoder.z(serialDescriptor, 1) || subscriptionInfoResponse.originalPurchaseDate != null) {
            compositeEncoder.i(serialDescriptor, 1, iSO8601DateSerializer, subscriptionInfoResponse.originalPurchaseDate);
        }
        if (compositeEncoder.z(serialDescriptor, 2) || subscriptionInfoResponse.expiresDate != null) {
            compositeEncoder.i(serialDescriptor, 2, iSO8601DateSerializer, subscriptionInfoResponse.expiresDate);
        }
        compositeEncoder.C(serialDescriptor, 3, StoreSerializer.INSTANCE, subscriptionInfoResponse.store);
        compositeEncoder.x(serialDescriptor, 4, subscriptionInfoResponse.isSandbox);
        if (compositeEncoder.z(serialDescriptor, 5) || subscriptionInfoResponse.unsubscribeDetectedAt != null) {
            compositeEncoder.i(serialDescriptor, 5, iSO8601DateSerializer, subscriptionInfoResponse.unsubscribeDetectedAt);
        }
        if (compositeEncoder.z(serialDescriptor, 6) || subscriptionInfoResponse.billingIssuesDetectedAt != null) {
            compositeEncoder.i(serialDescriptor, 6, iSO8601DateSerializer, subscriptionInfoResponse.billingIssuesDetectedAt);
        }
        if (compositeEncoder.z(serialDescriptor, 7) || subscriptionInfoResponse.gracePeriodExpiresDate != null) {
            compositeEncoder.i(serialDescriptor, 7, iSO8601DateSerializer, subscriptionInfoResponse.gracePeriodExpiresDate);
        }
        if (compositeEncoder.z(serialDescriptor, 8) || subscriptionInfoResponse.ownershipType != OwnershipType.UNKNOWN) {
            compositeEncoder.C(serialDescriptor, 8, kSerializerArr[8], subscriptionInfoResponse.ownershipType);
        }
        compositeEncoder.C(serialDescriptor, 9, kSerializerArr[9], subscriptionInfoResponse.periodType);
        if (compositeEncoder.z(serialDescriptor, 10) || subscriptionInfoResponse.refundedAt != null) {
            compositeEncoder.i(serialDescriptor, 10, iSO8601DateSerializer, subscriptionInfoResponse.refundedAt);
        }
        if (compositeEncoder.z(serialDescriptor, 11) || subscriptionInfoResponse.storeTransactionId != null) {
            compositeEncoder.i(serialDescriptor, 11, StringSerializer.f142891a, subscriptionInfoResponse.storeTransactionId);
        }
        if (compositeEncoder.z(serialDescriptor, 12) || subscriptionInfoResponse.autoResumeDate != null) {
            compositeEncoder.i(serialDescriptor, 12, iSO8601DateSerializer, subscriptionInfoResponse.autoResumeDate);
        }
        if (compositeEncoder.z(serialDescriptor, 13) || subscriptionInfoResponse.displayName != null) {
            compositeEncoder.i(serialDescriptor, 13, StringSerializer.f142891a, subscriptionInfoResponse.displayName);
        }
        if (compositeEncoder.z(serialDescriptor, 14) || subscriptionInfoResponse.price != null) {
            compositeEncoder.i(serialDescriptor, 14, SubscriptionInfoResponse$PriceResponse$$serializer.INSTANCE, subscriptionInfoResponse.price);
        }
        if (compositeEncoder.z(serialDescriptor, 15) || subscriptionInfoResponse.productPlanIdentifier != null) {
            compositeEncoder.i(serialDescriptor, 15, StringSerializer.f142891a, subscriptionInfoResponse.productPlanIdentifier);
        }
        if (!compositeEncoder.z(serialDescriptor, 16) && subscriptionInfoResponse.managementURL == null) {
            return;
        }
        compositeEncoder.i(serialDescriptor, 16, StringSerializer.f142891a, subscriptionInfoResponse.managementURL);
    }

    public final Date component1() {
        return this.purchaseDate;
    }

    public final PeriodType component10() {
        return this.periodType;
    }

    public final Date component11() {
        return this.refundedAt;
    }

    public final String component12() {
        return this.storeTransactionId;
    }

    public final Date component13() {
        return this.autoResumeDate;
    }

    public final String component14() {
        return this.displayName;
    }

    public final PriceResponse component15() {
        return this.price;
    }

    public final String component16() {
        return this.productPlanIdentifier;
    }

    public final String component17() {
        return this.managementURL;
    }

    public final Date component2() {
        return this.originalPurchaseDate;
    }

    public final Date component3() {
        return this.expiresDate;
    }

    public final Store component4() {
        return this.store;
    }

    public final boolean component5() {
        return this.isSandbox;
    }

    public final Date component6() {
        return this.unsubscribeDetectedAt;
    }

    public final Date component7() {
        return this.billingIssuesDetectedAt;
    }

    public final Date component8() {
        return this.gracePeriodExpiresDate;
    }

    public final OwnershipType component9() {
        return this.ownershipType;
    }

    public final SubscriptionInfoResponse copy(Date purchaseDate, Date date, Date date2, Store store, boolean z2, Date date3, Date date4, Date date5, OwnershipType ownershipType, PeriodType periodType, Date date6, String str, Date date7, String str2, PriceResponse priceResponse, String str3, String str4) {
        Intrinsics.checkNotNullParameter(purchaseDate, "purchaseDate");
        Intrinsics.checkNotNullParameter(store, "store");
        Intrinsics.checkNotNullParameter(ownershipType, "ownershipType");
        Intrinsics.checkNotNullParameter(periodType, "periodType");
        return new SubscriptionInfoResponse(purchaseDate, date, date2, store, z2, date3, date4, date5, ownershipType, periodType, date6, str, date7, str2, priceResponse, str3, str4);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SubscriptionInfoResponse)) {
            return false;
        }
        SubscriptionInfoResponse subscriptionInfoResponse = (SubscriptionInfoResponse) obj;
        return Intrinsics.areEqual(this.purchaseDate, subscriptionInfoResponse.purchaseDate) && Intrinsics.areEqual(this.originalPurchaseDate, subscriptionInfoResponse.originalPurchaseDate) && Intrinsics.areEqual(this.expiresDate, subscriptionInfoResponse.expiresDate) && this.store == subscriptionInfoResponse.store && this.isSandbox == subscriptionInfoResponse.isSandbox && Intrinsics.areEqual(this.unsubscribeDetectedAt, subscriptionInfoResponse.unsubscribeDetectedAt) && Intrinsics.areEqual(this.billingIssuesDetectedAt, subscriptionInfoResponse.billingIssuesDetectedAt) && Intrinsics.areEqual(this.gracePeriodExpiresDate, subscriptionInfoResponse.gracePeriodExpiresDate) && this.ownershipType == subscriptionInfoResponse.ownershipType && this.periodType == subscriptionInfoResponse.periodType && Intrinsics.areEqual(this.refundedAt, subscriptionInfoResponse.refundedAt) && Intrinsics.areEqual(this.storeTransactionId, subscriptionInfoResponse.storeTransactionId) && Intrinsics.areEqual(this.autoResumeDate, subscriptionInfoResponse.autoResumeDate) && Intrinsics.areEqual(this.displayName, subscriptionInfoResponse.displayName) && Intrinsics.areEqual(this.price, subscriptionInfoResponse.price) && Intrinsics.areEqual(this.productPlanIdentifier, subscriptionInfoResponse.productPlanIdentifier) && Intrinsics.areEqual(this.managementURL, subscriptionInfoResponse.managementURL);
    }

    public final Date getAutoResumeDate() {
        return this.autoResumeDate;
    }

    public final Date getBillingIssuesDetectedAt() {
        return this.billingIssuesDetectedAt;
    }

    public final String getDisplayName() {
        return this.displayName;
    }

    public final Date getExpiresDate() {
        return this.expiresDate;
    }

    public final Date getGracePeriodExpiresDate() {
        return this.gracePeriodExpiresDate;
    }

    public final String getManagementURL() {
        return this.managementURL;
    }

    public final Date getOriginalPurchaseDate() {
        return this.originalPurchaseDate;
    }

    public final OwnershipType getOwnershipType() {
        return this.ownershipType;
    }

    public final PeriodType getPeriodType() {
        return this.periodType;
    }

    public final PriceResponse getPrice() {
        return this.price;
    }

    public final String getProductPlanIdentifier() {
        return this.productPlanIdentifier;
    }

    public final Date getPurchaseDate() {
        return this.purchaseDate;
    }

    public final Date getRefundedAt() {
        return this.refundedAt;
    }

    public final Store getStore() {
        return this.store;
    }

    public final String getStoreTransactionId() {
        return this.storeTransactionId;
    }

    public final Date getUnsubscribeDetectedAt() {
        return this.unsubscribeDetectedAt;
    }

    public int hashCode() {
        int iHashCode = this.purchaseDate.hashCode() * 31;
        Date date = this.originalPurchaseDate;
        int iHashCode2 = (iHashCode + (date == null ? 0 : date.hashCode())) * 31;
        Date date2 = this.expiresDate;
        int iHashCode3 = (((((iHashCode2 + (date2 == null ? 0 : date2.hashCode())) * 31) + this.store.hashCode()) * 31) + Boolean.hashCode(this.isSandbox)) * 31;
        Date date3 = this.unsubscribeDetectedAt;
        int iHashCode4 = (iHashCode3 + (date3 == null ? 0 : date3.hashCode())) * 31;
        Date date4 = this.billingIssuesDetectedAt;
        int iHashCode5 = (iHashCode4 + (date4 == null ? 0 : date4.hashCode())) * 31;
        Date date5 = this.gracePeriodExpiresDate;
        int iHashCode6 = (((((iHashCode5 + (date5 == null ? 0 : date5.hashCode())) * 31) + this.ownershipType.hashCode()) * 31) + this.periodType.hashCode()) * 31;
        Date date6 = this.refundedAt;
        int iHashCode7 = (iHashCode6 + (date6 == null ? 0 : date6.hashCode())) * 31;
        String str = this.storeTransactionId;
        int iHashCode8 = (iHashCode7 + (str == null ? 0 : str.hashCode())) * 31;
        Date date7 = this.autoResumeDate;
        int iHashCode9 = (iHashCode8 + (date7 == null ? 0 : date7.hashCode())) * 31;
        String str2 = this.displayName;
        int iHashCode10 = (iHashCode9 + (str2 == null ? 0 : str2.hashCode())) * 31;
        PriceResponse priceResponse = this.price;
        int iHashCode11 = (iHashCode10 + (priceResponse == null ? 0 : priceResponse.hashCode())) * 31;
        String str3 = this.productPlanIdentifier;
        int iHashCode12 = (iHashCode11 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.managementURL;
        return iHashCode12 + (str4 != null ? str4.hashCode() : 0);
    }

    public final boolean isSandbox() {
        return this.isSandbox;
    }

    public String toString() {
        return "SubscriptionInfoResponse(purchaseDate=" + this.purchaseDate + ", originalPurchaseDate=" + this.originalPurchaseDate + ", expiresDate=" + this.expiresDate + ", store=" + this.store + ", isSandbox=" + this.isSandbox + ", unsubscribeDetectedAt=" + this.unsubscribeDetectedAt + ", billingIssuesDetectedAt=" + this.billingIssuesDetectedAt + ", gracePeriodExpiresDate=" + this.gracePeriodExpiresDate + ", ownershipType=" + this.ownershipType + ", periodType=" + this.periodType + ", refundedAt=" + this.refundedAt + ", storeTransactionId=" + this.storeTransactionId + ", autoResumeDate=" + this.autoResumeDate + ", displayName=" + this.displayName + ", price=" + this.price + ", productPlanIdentifier=" + this.productPlanIdentifier + ", managementURL=" + this.managementURL + ')';
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @Serializable
    public static final class PriceResponse {
        public static final Companion Companion = new Companion(null);
        private final double amount;
        private final String currencyCode;

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final KSerializer<PriceResponse> serializer() {
                return SubscriptionInfoResponse$PriceResponse$$serializer.INSTANCE;
            }

            private Companion() {
            }
        }

        public PriceResponse(double d3, String currencyCode) {
            Intrinsics.checkNotNullParameter(currencyCode, "currencyCode");
            this.amount = d3;
            this.currencyCode = currencyCode;
        }

        public static /* synthetic */ PriceResponse copy$default(PriceResponse priceResponse, double d3, String str, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                d3 = priceResponse.amount;
            }
            if ((i3 & 2) != 0) {
                str = priceResponse.currencyCode;
            }
            return priceResponse.copy(d3, str);
        }

        @JvmStatic
        public static final /* synthetic */ void write$Self$purchases_defaultsBc8Release(PriceResponse priceResponse, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
            compositeEncoder.E(serialDescriptor, 0, priceResponse.amount);
            compositeEncoder.y(serialDescriptor, 1, priceResponse.currencyCode);
        }

        public final double component1() {
            return this.amount;
        }

        public final String component2() {
            return this.currencyCode;
        }

        public final PriceResponse copy(double d3, String currencyCode) {
            Intrinsics.checkNotNullParameter(currencyCode, "currencyCode");
            return new PriceResponse(d3, currencyCode);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof PriceResponse)) {
                return false;
            }
            PriceResponse priceResponse = (PriceResponse) obj;
            return Double.compare(this.amount, priceResponse.amount) == 0 && Intrinsics.areEqual(this.currencyCode, priceResponse.currencyCode);
        }

        public final double getAmount() {
            return this.amount;
        }

        public final String getCurrencyCode() {
            return this.currencyCode;
        }

        public int hashCode() {
            return (Double.hashCode(this.amount) * 31) + this.currencyCode.hashCode();
        }

        public final /* synthetic */ Price toPrice(Locale locale) {
            Intrinsics.checkNotNullParameter(locale, "locale");
            NumberFormat currencyInstance = NumberFormat.getCurrencyInstance(locale);
            currencyInstance.setCurrency(Currency.getInstance(this.currencyCode));
            String formatted = currencyInstance.format(this.amount);
            Intrinsics.checkNotNullExpressionValue(formatted, "formatted");
            return new Price(formatted, (long) (this.amount * 1000000.0d), this.currencyCode);
        }

        public String toString() {
            return "PriceResponse(amount=" + this.amount + ", currencyCode=" + this.currencyCode + ')';
        }

        @Deprecated
        public /* synthetic */ PriceResponse(int i3, @SerialName double d3, @SerialName String str, SerializationConstructorMarker serializationConstructorMarker) {
            if (3 != (i3 & 3)) {
                PluginExceptionsKt.b(i3, 3, SubscriptionInfoResponse$PriceResponse$$serializer.INSTANCE.getDescriptor());
            }
            this.amount = d3;
            this.currencyCode = str;
        }

        @SerialName
        public static /* synthetic */ void getAmount$annotations() {
        }

        @SerialName
        public static /* synthetic */ void getCurrencyCode$annotations() {
        }
    }

    public SubscriptionInfoResponse(Date purchaseDate, Date date, Date date2, Store store, boolean z2, Date date3, Date date4, Date date5, OwnershipType ownershipType, PeriodType periodType, Date date6, String str, Date date7, String str2, PriceResponse priceResponse, String str3, String str4) {
        Intrinsics.checkNotNullParameter(purchaseDate, "purchaseDate");
        Intrinsics.checkNotNullParameter(store, "store");
        Intrinsics.checkNotNullParameter(ownershipType, "ownershipType");
        Intrinsics.checkNotNullParameter(periodType, qRMDmh.ICnpRAhgnKdgMg);
        this.purchaseDate = purchaseDate;
        this.originalPurchaseDate = date;
        this.expiresDate = date2;
        this.store = store;
        this.isSandbox = z2;
        this.unsubscribeDetectedAt = date3;
        this.billingIssuesDetectedAt = date4;
        this.gracePeriodExpiresDate = date5;
        this.ownershipType = ownershipType;
        this.periodType = periodType;
        this.refundedAt = date6;
        this.storeTransactionId = str;
        this.autoResumeDate = date7;
        this.displayName = str2;
        this.price = priceResponse;
        this.productPlanIdentifier = str3;
        this.managementURL = str4;
    }

    public /* synthetic */ SubscriptionInfoResponse(Date date, Date date2, Date date3, Store store, boolean z2, Date date4, Date date5, Date date6, OwnershipType ownershipType, PeriodType periodType, Date date7, String str, Date date8, String str2, PriceResponse priceResponse, String str3, String str4, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(date, (i3 & 2) != 0 ? null : date2, (i3 & 4) != 0 ? null : date3, store, z2, (i3 & 32) != 0 ? null : date4, (i3 & 64) != 0 ? null : date5, (i3 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0 ? null : date6, (i3 & Function.MAX_NARGS) != 0 ? OwnershipType.UNKNOWN : ownershipType, periodType, (i3 & 1024) != 0 ? null : date7, (i3 & 2048) != 0 ? null : str, (i3 & 4096) != 0 ? null : date8, (i3 & Utility.DEFAULT_STREAM_BUFFER_SIZE) != 0 ? null : str2, (i3 & 16384) != 0 ? null : priceResponse, (32768 & i3) != 0 ? null : str3, (i3 & NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST) != 0 ? null : str4);
    }
}
