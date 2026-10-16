package com.revenuecat.purchases.ui.revenuecatui.customercenter.data;

import com.revenuecat.purchases.EntitlementInfo;
import com.revenuecat.purchases.PeriodType;
import com.revenuecat.purchases.Store;
import com.revenuecat.purchases.customercenter.CustomerCenterConfigData;
import com.revenuecat.purchases.models.Price;
import com.revenuecat.purchases.models.StoreProduct;
import com.revenuecat.purchases.ui.revenuecatui.customercenter.data.ExpirationOrRenewal;
import com.revenuecat.purchases.ui.revenuecatui.customercenter.data.PriceDetails;
import com.revenuecat.purchases.ui.revenuecatui.customercenter.viewmodel.TransactionDetails;
import com.revenuecat.purchases.ui.revenuecatui.utils.DateFormatter;
import java.util.Date;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
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
public final class PurchaseInformationKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean determineCancellationStatus(EntitlementInfo entitlementInfo, TransactionDetails transactionDetails) {
        boolean z2 = (entitlementInfo == null || entitlementInfo.getUnsubscribeDetectedAt() == null || entitlementInfo.getWillRenew()) ? false : true;
        TransactionDetails.Subscription subscription = transactionDetails instanceof TransactionDetails.Subscription ? (TransactionDetails.Subscription) transactionDetails : null;
        return z2 || (subscription != null ? subscription.getWillRenew() ^ true : false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ExpirationOrRenewal determineExpirationOrRenewal(EntitlementInfo entitlementInfo, TransactionDetails transactionDetails, DateFormatter dateFormatter, Locale locale) {
        String strExpirationDate;
        String strRenewalDate;
        ExpirationOrRenewal expiration = null;
        ExpirationOrRenewal expiration2 = (entitlementInfo == null || (strRenewalDate = renewalDate(entitlementInfo, dateFormatter, locale)) == null) ? (entitlementInfo == null || (strExpirationDate = expirationDate(entitlementInfo, dateFormatter, locale)) == null) ? null : new ExpirationOrRenewal.Expiration(strExpirationDate) : new ExpirationOrRenewal.Renewal(strRenewalDate);
        String strRenewalDate2 = renewalDate(transactionDetails, dateFormatter, locale);
        if (strRenewalDate2 != null) {
            expiration = new ExpirationOrRenewal.Renewal(strRenewalDate2);
        } else {
            String strExpirationDate2 = expirationDate(transactionDetails, dateFormatter, locale);
            if (strExpirationDate2 != null) {
                expiration = new ExpirationOrRenewal.Expiration(strExpirationDate2);
            }
        }
        return expiration2 == null ? expiration : expiration2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean determineLifetimeStatus(EntitlementInfo entitlementInfo, TransactionDetails transactionDetails) {
        return (entitlementInfo != null && isPromotionalLifetime(entitlementInfo)) || (!(transactionDetails instanceof TransactionDetails.Subscription) && transactionDetails.getStore() != Store.PROMOTIONAL && entitlementInfo != null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PriceDetails determinePrice(StoreProduct storeProduct, TransactionDetails transactionDetails) {
        Price price;
        if (transactionDetails.getStore() == Store.PROMOTIONAL || ((price = transactionDetails.getPrice()) != null && price.getAmountMicros() == 0)) {
            return PriceDetails.Free.INSTANCE;
        }
        Price price2 = transactionDetails.getPrice();
        if (price2 == null || price2.getAmountMicros() <= 0) {
            return storeProduct != null ? storeProduct.getPrice().getAmountMicros() == 0 ? PriceDetails.Free.INSTANCE : new PriceDetails.Paid(storeProduct.getPrice().getFormatted()) : PriceDetails.Unknown.INSTANCE;
        }
        Price price3 = transactionDetails.getPrice();
        return price3 != null ? new PriceDetails.Paid(price3.getFormatted()) : PriceDetails.Unknown.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String determineTitle(EntitlementInfo entitlementInfo, StoreProduct storeProduct, TransactionDetails transactionDetails, CustomerCenterConfigData.Localization localization) {
        String title;
        if (transactionDetails.getStore() == Store.PROMOTIONAL && entitlementInfo != null) {
            return entitlementInfo.getIdentifier();
        }
        if (storeProduct != null && (title = storeProduct.getTitle()) != null) {
            return title;
        }
        if (transactionDetails instanceof TransactionDetails.Subscription) {
            return localization.commonLocalizedString(CustomerCenterConfigData.Localization.CommonLocalizedString.TYPE_SUBSCRIPTION);
        }
        if (transactionDetails instanceof TransactionDetails.NonSubscription) {
            return localization.commonLocalizedString(CustomerCenterConfigData.Localization.CommonLocalizedString.TYPE_ONE_TIME_PURCHASE);
        }
        throw new NoWhenBranchMatchedException();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean determineTrialStatus(EntitlementInfo entitlementInfo, TransactionDetails transactionDetails) {
        if ((entitlementInfo != null ? entitlementInfo.getPeriodType() : null) != PeriodType.TRIAL) {
            TransactionDetails.Subscription subscription = transactionDetails instanceof TransactionDetails.Subscription ? (TransactionDetails.Subscription) transactionDetails : null;
            if (subscription == null || !subscription.isTrial()) {
                return false;
            }
        }
        return true;
    }

    private static final String expirationDate(EntitlementInfo entitlementInfo, DateFormatter dateFormatter, Locale locale) {
        Date expirationDate;
        if (isPromotionalLifetime(entitlementInfo)) {
            return null;
        }
        if ((entitlementInfo.getWillRenew() && entitlementInfo.isActive()) || (expirationDate = entitlementInfo.getExpirationDate()) == null) {
            return null;
        }
        return dateFormatter.format(expirationDate, locale);
    }

    private static final boolean isExpiringOrExpired(TransactionDetails.Subscription subscription) {
        return (subscription.getWillRenew() && subscription.isActive()) ? false : true;
    }

    private static final boolean isPromotionalLifetime(EntitlementInfo entitlementInfo) {
        return entitlementInfo.getStore() == Store.PROMOTIONAL && StringsKt.E(entitlementInfo.getProductIdentifier(), "_lifetime", false, 2, null);
    }

    private static final String renewalDate(EntitlementInfo entitlementInfo, DateFormatter dateFormatter, Locale locale) {
        Date expirationDate;
        if (!entitlementInfo.getWillRenew() || isPromotionalLifetime(entitlementInfo) || (expirationDate = entitlementInfo.getExpirationDate()) == null) {
            return null;
        }
        return dateFormatter.format(expirationDate, locale);
    }

    private static final String expirationDate(TransactionDetails transactionDetails, DateFormatter dateFormatter, Locale locale) {
        if (!(transactionDetails instanceof TransactionDetails.Subscription) || ((TransactionDetails.Subscription) transactionDetails).getExpiresDate() == null) {
            return null;
        }
        Intrinsics.checkNotNull(transactionDetails, "null cannot be cast to non-null type com.revenuecat.purchases.ui.revenuecatui.customercenter.viewmodel.TransactionDetails.Subscription");
        if (!isExpiringOrExpired((TransactionDetails.Subscription) transactionDetails)) {
            return null;
        }
        Intrinsics.checkNotNull(transactionDetails, "null cannot be cast to non-null type com.revenuecat.purchases.ui.revenuecatui.customercenter.viewmodel.TransactionDetails.Subscription");
        Date expiresDate = ((TransactionDetails.Subscription) transactionDetails).getExpiresDate();
        Intrinsics.checkNotNull(expiresDate);
        return dateFormatter.format(expiresDate, locale);
    }

    private static final String renewalDate(TransactionDetails transactionDetails, DateFormatter dateFormatter, Locale locale) {
        if (!(transactionDetails instanceof TransactionDetails.Subscription)) {
            return null;
        }
        TransactionDetails.Subscription subscription = (TransactionDetails.Subscription) transactionDetails;
        if (!subscription.getWillRenew() || subscription.getExpiresDate() == null) {
            return null;
        }
        return dateFormatter.format(subscription.getExpiresDate(), locale);
    }
}
