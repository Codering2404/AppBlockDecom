package com.revenuecat.purchases;

import android.net.Uri;
import com.revenuecat.purchases.common.responses.SubscriptionInfoResponse;
import com.revenuecat.purchases.models.Price;
import com.revenuecat.purchases.utils.DateHelper;
import com.revenuecat.purchases.utils.EntitlementInfoHelper;
import java.util.Date;
import java.util.Locale;
import kotlin.Deprecated;
import kotlin.Metadata;
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
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
@Metadata
public final class SubscriptionInfo {
    private final Date autoResumeDate;
    private final Date billingIssuesDetectedAt;
    private final String displayName;
    private final Date expiresDate;
    private final Date gracePeriodExpiresDate;
    private final boolean isActive;
    private final boolean isSandbox;
    private final Uri managementURL;
    private final Date originalPurchaseDate;
    private final OwnershipType ownershipType;
    private final PeriodType periodType;
    private final Price price;
    private final String productIdentifier;
    private final String productPlanIdentifier;
    private final Date purchaseDate;
    private final Date refundedAt;
    private final Date requestDate;
    private final Store store;
    private final String storeTransactionId;
    private final Date unsubscribeDetectedAt;
    private final boolean willRenew;

    public SubscriptionInfo(String productIdentifier, Date purchaseDate, Date date, Date date2, Store store, Date date3, boolean z2, Date date4, Date date5, OwnershipType ownershipType, PeriodType periodType, Date date6, String str, Date date7, String str2, Price price, String str3, Uri uri, Date requestDate) {
        Intrinsics.checkNotNullParameter(productIdentifier, "productIdentifier");
        Intrinsics.checkNotNullParameter(purchaseDate, "purchaseDate");
        Intrinsics.checkNotNullParameter(store, "store");
        Intrinsics.checkNotNullParameter(ownershipType, "ownershipType");
        Intrinsics.checkNotNullParameter(periodType, "periodType");
        Intrinsics.checkNotNullParameter(requestDate, "requestDate");
        this.productIdentifier = productIdentifier;
        this.purchaseDate = purchaseDate;
        this.originalPurchaseDate = date;
        this.expiresDate = date2;
        this.store = store;
        this.unsubscribeDetectedAt = date3;
        this.isSandbox = z2;
        this.billingIssuesDetectedAt = date4;
        this.gracePeriodExpiresDate = date5;
        this.ownershipType = ownershipType;
        this.periodType = periodType;
        this.refundedAt = date6;
        this.storeTransactionId = str;
        this.autoResumeDate = date7;
        this.displayName = str2;
        this.price = price;
        this.productPlanIdentifier = str3;
        this.managementURL = uri;
        this.requestDate = requestDate;
        this.isActive = DateHelper.Companion.m1240isDateActiveSxA4cEA$default(DateHelper.Companion, date2, requestDate, 0L, 4, null).isActive();
        this.willRenew = EntitlementInfoHelper.INSTANCE.getWillRenew(store, date2, date3, date4, periodType);
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

    public final Uri getManagementURL() {
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

    public final Price getPrice() {
        return this.price;
    }

    public final String getProductIdentifier() {
        return this.productIdentifier;
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

    public final boolean getWillRenew() {
        return this.willRenew;
    }

    public final boolean isActive() {
        return this.isActive;
    }

    public final boolean isSandbox() {
        return this.isSandbox;
    }

    public String toString() {
        return StringsKt.n("\n            SubscriptionInfo {\n                purchaseDate: " + this.purchaseDate + ",\n                originalPurchaseDate: " + this.originalPurchaseDate + ",\n                expiresDate: " + this.expiresDate + ",\n                store: " + this.store + ",\n                isSandbox: " + this.isSandbox + ",\n                unsubscribeDetectedAt: " + this.unsubscribeDetectedAt + ",\n                billingIssuesDetectedAt: " + this.billingIssuesDetectedAt + ",\n                gracePeriodExpiresDate: " + this.gracePeriodExpiresDate + ",\n                ownershipType: " + this.ownershipType + ",\n                periodType: " + this.periodType + ",\n                refundedAt: " + this.refundedAt + ",\n                storeTransactionId: " + this.storeTransactionId + ",\n                isActive: " + this.isActive + ",\n                willRenew: " + this.willRenew + ",\n                price: " + this.price + ",\n                productPlanIdentifier: " + this.productPlanIdentifier + ",\n                displayName: " + this.displayName + ",\n                autoResumeDate: " + this.autoResumeDate + ",\n                managementURL: " + this.managementURL + ",\n                requestDate: " + this.requestDate + ",\n                productIdentifier: " + this.productIdentifier + "\n            }\n        ");
    }

    public /* synthetic */ SubscriptionInfo(String str, Date date, Date date2, Date date3, Store store, Date date4, boolean z2, Date date5, Date date6, OwnershipType ownershipType, PeriodType periodType, Date date7, String str2, Date date8, String str3, Price price, String str4, Uri uri, Date date9, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, date, date2, date3, store, date4, z2, date5, date6, (i3 & 512) != 0 ? OwnershipType.UNKNOWN : ownershipType, periodType, date7, str2, date8, str3, price, str4, uri, date9);
    }

    public /* synthetic */ SubscriptionInfo(String str, Date date, Date date2, Date date3, Store store, Date date4, boolean z2, Date date5, Date date6, OwnershipType ownershipType, PeriodType periodType, Date date7, String str2, Date date8, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, date, date2, date3, store, date4, z2, date5, date6, (i3 & 512) != 0 ? OwnershipType.UNKNOWN : ownershipType, periodType, date7, str2, date8);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @Deprecated
    public SubscriptionInfo(String productIdentifier, Date purchaseDate, Date date, Date date2, Store store, Date date3, boolean z2, Date date4, Date date5, OwnershipType ownershipType, PeriodType periodType, Date date6, String str, Date requestDate) {
        this(productIdentifier, purchaseDate, date, date2, store, date3, z2, date4, date5, ownershipType, periodType, date6, str, null, null, null, null, null, requestDate);
        Intrinsics.checkNotNullParameter(productIdentifier, "productIdentifier");
        Intrinsics.checkNotNullParameter(purchaseDate, "purchaseDate");
        Intrinsics.checkNotNullParameter(store, "store");
        Intrinsics.checkNotNullParameter(ownershipType, "ownershipType");
        Intrinsics.checkNotNullParameter(periodType, "periodType");
        Intrinsics.checkNotNullParameter(requestDate, "requestDate");
    }

    public /* synthetic */ SubscriptionInfo(String str, Date date, Date date2, Date date3, Store store, Date date4, boolean z2, Date date5, Date date6, OwnershipType ownershipType, PeriodType periodType, Date date7, String str2, Date date8, String str3, Price price, String str4, Date date9, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, date, date2, date3, store, date4, z2, date5, date6, (i3 & 512) != 0 ? OwnershipType.UNKNOWN : ownershipType, periodType, date7, str2, date8, str3, price, str4, date9);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @Deprecated
    public SubscriptionInfo(String productIdentifier, Date purchaseDate, Date date, Date date2, Store store, Date date3, boolean z2, Date date4, Date date5, OwnershipType ownershipType, PeriodType periodType, Date date6, String str, Date date7, String str2, Price price, String str3, Date requestDate) {
        this(productIdentifier, purchaseDate, date, date2, store, date3, z2, date4, date5, ownershipType, periodType, date6, str, date7, str2, price, str3, null, requestDate);
        Intrinsics.checkNotNullParameter(productIdentifier, "productIdentifier");
        Intrinsics.checkNotNullParameter(purchaseDate, "purchaseDate");
        Intrinsics.checkNotNullParameter(store, "store");
        Intrinsics.checkNotNullParameter(ownershipType, "ownershipType");
        Intrinsics.checkNotNullParameter(periodType, "periodType");
        Intrinsics.checkNotNullParameter(requestDate, "requestDate");
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ SubscriptionInfo(String str, Date date, SubscriptionInfoResponse subscriptionInfoResponse, Locale locale, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        if ((i3 & 8) != 0) {
            locale = Locale.getDefault();
            Intrinsics.checkNotNullExpressionValue(locale, "getDefault()");
        }
        this(str, date, subscriptionInfoResponse, locale);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public SubscriptionInfo(String productIdentifier, Date requestDate, SubscriptionInfoResponse response, Locale locale) {
        Intrinsics.checkNotNullParameter(productIdentifier, "productIdentifier");
        Intrinsics.checkNotNullParameter(requestDate, "requestDate");
        Intrinsics.checkNotNullParameter(response, "response");
        Intrinsics.checkNotNullParameter(locale, "locale");
        Date purchaseDate = response.getPurchaseDate();
        Date originalPurchaseDate = response.getOriginalPurchaseDate();
        Date expiresDate = response.getExpiresDate();
        Store store = response.getStore();
        boolean zIsSandbox = response.isSandbox();
        Date unsubscribeDetectedAt = response.getUnsubscribeDetectedAt();
        Date billingIssuesDetectedAt = response.getBillingIssuesDetectedAt();
        Date gracePeriodExpiresDate = response.getGracePeriodExpiresDate();
        OwnershipType ownershipType = response.getOwnershipType();
        PeriodType periodType = response.getPeriodType();
        Date refundedAt = response.getRefundedAt();
        String storeTransactionId = response.getStoreTransactionId();
        Date autoResumeDate = response.getAutoResumeDate();
        String displayName = response.getDisplayName();
        SubscriptionInfoResponse.PriceResponse price = response.getPrice();
        Price price2 = price != null ? price.toPrice(locale) : null;
        String productPlanIdentifier = response.getProductPlanIdentifier();
        String managementURL = response.getManagementURL();
        this(productIdentifier, purchaseDate, originalPurchaseDate, expiresDate, store, unsubscribeDetectedAt, zIsSandbox, billingIssuesDetectedAt, gracePeriodExpiresDate, ownershipType, periodType, refundedAt, storeTransactionId, autoResumeDate, displayName, price2, productPlanIdentifier, managementURL != null ? Uri.parse(managementURL) : null, requestDate);
    }
}
