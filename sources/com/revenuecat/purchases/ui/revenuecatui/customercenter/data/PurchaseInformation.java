package com.revenuecat.purchases.ui.revenuecatui.customercenter.data;

import android.net.Uri;
import com.revenuecat.purchases.EntitlementInfo;
import com.revenuecat.purchases.Store;
import com.revenuecat.purchases.customercenter.CustomerCenterConfigData;
import com.revenuecat.purchases.models.StoreProduct;
import com.revenuecat.purchases.ui.revenuecatui.customercenter.data.PriceDetails;
import com.revenuecat.purchases.ui.revenuecatui.customercenter.viewmodel.TransactionDetails;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.revenuecat.purchases.ui.revenuecatui.utils.DateFormatter;
import com.revenuecat.purchases.ui.revenuecatui.utils.DefaultDateFormatter;
import com.sun.jna.Function;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class PurchaseInformation {
    public static final int $stable = 8;
    private final ExpirationOrRenewal expirationOrRenewal;
    private final boolean isCancelled;
    private final boolean isExpired;
    private final boolean isLifetime;
    private boolean isSubscription;
    private final boolean isTrial;
    private final Uri managementURL;
    private final PriceDetails pricePaid;
    private final StoreProduct product;
    private final Store store;
    private final String title;

    public PurchaseInformation(String str, PriceDetails pricePaid, ExpirationOrRenewal expirationOrRenewal, StoreProduct storeProduct, Store store, boolean z2, Uri uri, boolean z3, boolean z4, boolean z5, boolean z6) {
        Intrinsics.checkNotNullParameter(pricePaid, "pricePaid");
        Intrinsics.checkNotNullParameter(store, "store");
        this.title = str;
        this.pricePaid = pricePaid;
        this.expirationOrRenewal = expirationOrRenewal;
        this.product = storeProduct;
        this.store = store;
        this.isSubscription = z2;
        this.managementURL = uri;
        this.isExpired = z3;
        this.isTrial = z4;
        this.isCancelled = z5;
        this.isLifetime = z6;
    }

    public static /* synthetic */ PurchaseInformation copy$default(PurchaseInformation purchaseInformation, String str, PriceDetails priceDetails, ExpirationOrRenewal expirationOrRenewal, StoreProduct storeProduct, Store store, boolean z2, Uri uri, boolean z3, boolean z4, boolean z5, boolean z6, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = purchaseInformation.title;
        }
        if ((i3 & 2) != 0) {
            priceDetails = purchaseInformation.pricePaid;
        }
        if ((i3 & 4) != 0) {
            expirationOrRenewal = purchaseInformation.expirationOrRenewal;
        }
        if ((i3 & 8) != 0) {
            storeProduct = purchaseInformation.product;
        }
        if ((i3 & 16) != 0) {
            store = purchaseInformation.store;
        }
        if ((i3 & 32) != 0) {
            z2 = purchaseInformation.isSubscription;
        }
        if ((i3 & 64) != 0) {
            uri = purchaseInformation.managementURL;
        }
        if ((i3 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0) {
            z3 = purchaseInformation.isExpired;
        }
        if ((i3 & Function.MAX_NARGS) != 0) {
            z4 = purchaseInformation.isTrial;
        }
        if ((i3 & 512) != 0) {
            z5 = purchaseInformation.isCancelled;
        }
        if ((i3 & 1024) != 0) {
            z6 = purchaseInformation.isLifetime;
        }
        boolean z7 = z5;
        boolean z8 = z6;
        boolean z9 = z3;
        boolean z10 = z4;
        boolean z11 = z2;
        Uri uri2 = uri;
        Store store2 = store;
        ExpirationOrRenewal expirationOrRenewal2 = expirationOrRenewal;
        return purchaseInformation.copy(str, priceDetails, expirationOrRenewal2, storeProduct, store2, z11, uri2, z9, z10, z7, z8);
    }

    public final String component1() {
        return this.title;
    }

    public final boolean component10() {
        return this.isCancelled;
    }

    public final boolean component11() {
        return this.isLifetime;
    }

    public final PriceDetails component2() {
        return this.pricePaid;
    }

    public final ExpirationOrRenewal component3() {
        return this.expirationOrRenewal;
    }

    public final StoreProduct component4() {
        return this.product;
    }

    public final Store component5() {
        return this.store;
    }

    public final boolean component6() {
        return this.isSubscription;
    }

    public final Uri component7() {
        return this.managementURL;
    }

    public final boolean component8() {
        return this.isExpired;
    }

    public final boolean component9() {
        return this.isTrial;
    }

    public final PurchaseInformation copy(String str, PriceDetails pricePaid, ExpirationOrRenewal expirationOrRenewal, StoreProduct storeProduct, Store store, boolean z2, Uri uri, boolean z3, boolean z4, boolean z5, boolean z6) {
        Intrinsics.checkNotNullParameter(pricePaid, "pricePaid");
        Intrinsics.checkNotNullParameter(store, "store");
        return new PurchaseInformation(str, pricePaid, expirationOrRenewal, storeProduct, store, z2, uri, z3, z4, z5, z6);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PurchaseInformation)) {
            return false;
        }
        PurchaseInformation purchaseInformation = (PurchaseInformation) obj;
        return Intrinsics.areEqual(this.title, purchaseInformation.title) && Intrinsics.areEqual(this.pricePaid, purchaseInformation.pricePaid) && Intrinsics.areEqual(this.expirationOrRenewal, purchaseInformation.expirationOrRenewal) && Intrinsics.areEqual(this.product, purchaseInformation.product) && this.store == purchaseInformation.store && this.isSubscription == purchaseInformation.isSubscription && Intrinsics.areEqual(this.managementURL, purchaseInformation.managementURL) && this.isExpired == purchaseInformation.isExpired && this.isTrial == purchaseInformation.isTrial && this.isCancelled == purchaseInformation.isCancelled && this.isLifetime == purchaseInformation.isLifetime;
    }

    public final String expirationString(String expirationDate, CustomerCenterConfigData.Localization localization) {
        Intrinsics.checkNotNullParameter(expirationDate, "expirationDate");
        Intrinsics.checkNotNullParameter(localization, "localization");
        return this.isExpired ? StringsKt.O(localization.commonLocalizedString(CustomerCenterConfigData.Localization.CommonLocalizedString.PURCHASE_INFO_EXPIRED_ON_DATE), "{{ date }}", expirationDate, false, 4, null) : StringsKt.O(localization.commonLocalizedString(CustomerCenterConfigData.Localization.CommonLocalizedString.PURCHASE_INFO_EXPIRES_ON_DATE), "{{ date }}", expirationDate, false, 4, null);
    }

    public final ExpirationOrRenewal getExpirationOrRenewal() {
        return this.expirationOrRenewal;
    }

    public final Uri getManagementURL() {
        return this.managementURL;
    }

    public final PriceDetails getPricePaid() {
        return this.pricePaid;
    }

    public final StoreProduct getProduct() {
        return this.product;
    }

    public final Store getStore() {
        return this.store;
    }

    public final String getTitle() {
        return this.title;
    }

    public int hashCode() {
        String str = this.title;
        int iHashCode = (((str == null ? 0 : str.hashCode()) * 31) + this.pricePaid.hashCode()) * 31;
        ExpirationOrRenewal expirationOrRenewal = this.expirationOrRenewal;
        int iHashCode2 = (iHashCode + (expirationOrRenewal == null ? 0 : expirationOrRenewal.hashCode())) * 31;
        StoreProduct storeProduct = this.product;
        int iHashCode3 = (((((iHashCode2 + (storeProduct == null ? 0 : storeProduct.hashCode())) * 31) + this.store.hashCode()) * 31) + Boolean.hashCode(this.isSubscription)) * 31;
        Uri uri = this.managementURL;
        return ((((((((iHashCode3 + (uri != null ? uri.hashCode() : 0)) * 31) + Boolean.hashCode(this.isExpired)) * 31) + Boolean.hashCode(this.isTrial)) * 31) + Boolean.hashCode(this.isCancelled)) * 31) + Boolean.hashCode(this.isLifetime);
    }

    public final boolean isCancelled() {
        return this.isCancelled;
    }

    public final boolean isExpired() {
        return this.isExpired;
    }

    public final boolean isLifetime() {
        return this.isLifetime;
    }

    public final boolean isSubscription() {
        return this.isSubscription;
    }

    public final boolean isTrial() {
        return this.isTrial;
    }

    public final String renewalString(String renewalDate, CustomerCenterConfigData.Localization localization) {
        Intrinsics.checkNotNullParameter(renewalDate, "renewalDate");
        Intrinsics.checkNotNullParameter(localization, "localization");
        PriceDetails priceDetails = this.pricePaid;
        if (Intrinsics.areEqual(priceDetails, PriceDetails.Free.INSTANCE) ? true : Intrinsics.areEqual(priceDetails, PriceDetails.Unknown.INSTANCE)) {
            return StringsKt.O(localization.commonLocalizedString(CustomerCenterConfigData.Localization.CommonLocalizedString.RENEWS_ON_DATE), "{{ date }}", renewalDate, false, 4, null);
        }
        if (!(priceDetails instanceof PriceDetails.Paid)) {
            throw new NoWhenBranchMatchedException();
        }
        return StringsKt.O(localization.commonLocalizedString(CustomerCenterConfigData.Localization.CommonLocalizedString.LAST_CHARGE_WAS), "{{ price }}", ((PriceDetails.Paid) this.pricePaid).getPrice(), false, 4, null) + '\n' + StringsKt.O(localization.commonLocalizedString(CustomerCenterConfigData.Localization.CommonLocalizedString.NEXT_BILLING_DATE_ON), "{{ date }}", renewalDate, false, 4, null);
    }

    public final void setSubscription(boolean z2) {
        this.isSubscription = z2;
    }

    public String toString() {
        return "PurchaseInformation(title=" + this.title + ", pricePaid=" + this.pricePaid + ", expirationOrRenewal=" + this.expirationOrRenewal + ", product=" + this.product + ", store=" + this.store + ", isSubscription=" + this.isSubscription + ", managementURL=" + this.managementURL + ", isExpired=" + this.isExpired + ", isTrial=" + this.isTrial + ", isCancelled=" + this.isCancelled + ", isLifetime=" + this.isLifetime + ')';
    }

    public /* synthetic */ PurchaseInformation(EntitlementInfo entitlementInfo, StoreProduct storeProduct, TransactionDetails transactionDetails, DateFormatter dateFormatter, Locale locale, CustomerCenterConfigData.Localization localization, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? null : entitlementInfo, (i3 & 2) != 0 ? null : storeProduct, transactionDetails, (i3 & 8) != 0 ? new DefaultDateFormatter() : dateFormatter, locale, localization);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public PurchaseInformation(EntitlementInfo entitlementInfo, StoreProduct storeProduct, TransactionDetails transaction, DateFormatter dateFormatter, Locale locale, CustomerCenterConfigData.Localization localization) {
        boolean z2;
        Store store;
        Intrinsics.checkNotNullParameter(transaction, "transaction");
        Intrinsics.checkNotNullParameter(dateFormatter, "dateFormatter");
        Intrinsics.checkNotNullParameter(locale, "locale");
        Intrinsics.checkNotNullParameter(localization, "localization");
        String strDetermineTitle = PurchaseInformationKt.determineTitle(entitlementInfo, storeProduct, transaction, localization);
        ExpirationOrRenewal expirationOrRenewalDetermineExpirationOrRenewal = PurchaseInformationKt.determineExpirationOrRenewal(entitlementInfo, transaction, dateFormatter, locale);
        Store store2 = (entitlementInfo == null || (store = entitlementInfo.getStore()) == null) ? transaction.getStore() : store;
        PriceDetails priceDetailsDeterminePrice = PurchaseInformationKt.determinePrice(storeProduct, transaction);
        boolean z3 = transaction instanceof TransactionDetails.Subscription;
        boolean z4 = false;
        boolean z5 = z3 && transaction.getStore() != Store.PROMOTIONAL;
        TransactionDetails.Subscription subscription = z3 ? (TransactionDetails.Subscription) transaction : null;
        Uri managementURL = subscription != null ? subscription.getManagementURL() : null;
        if (entitlementInfo != null) {
            z4 = !entitlementInfo.isActive();
        } else if (z3) {
            z2 = ((TransactionDetails.Subscription) transaction).isActive() ? z2 : true;
            this(strDetermineTitle, priceDetailsDeterminePrice, expirationOrRenewalDetermineExpirationOrRenewal, storeProduct, store2, z5, managementURL, z2, PurchaseInformationKt.determineTrialStatus(entitlementInfo, transaction), PurchaseInformationKt.determineCancellationStatus(entitlementInfo, transaction), PurchaseInformationKt.determineLifetimeStatus(entitlementInfo, transaction));
        } else if (!(transaction instanceof TransactionDetails.NonSubscription)) {
            throw new NoWhenBranchMatchedException();
        }
        z2 = z4;
        this(strDetermineTitle, priceDetailsDeterminePrice, expirationOrRenewalDetermineExpirationOrRenewal, storeProduct, store2, z5, managementURL, z2, PurchaseInformationKt.determineTrialStatus(entitlementInfo, transaction), PurchaseInformationKt.determineCancellationStatus(entitlementInfo, transaction), PurchaseInformationKt.determineLifetimeStatus(entitlementInfo, transaction));
    }
}
