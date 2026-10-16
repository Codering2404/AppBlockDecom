package com.revenuecat.purchases.strings;

import kotlin.Metadata;

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
public final class PurchaseStrings {
    public static final String ACKNOWLEDGING_PURCHASE = "Acknowledging purchase with token %s";
    public static final String ACKNOWLEDGING_PURCHASE_ERROR = "Error acknowledging purchase. Will retry next queryPurchases. %s";
    public static final String ACKNOWLEDGING_PURCHASE_ERROR_RESTORE = "Couldn't acknowledge purchase after restoring it, this most likely means the subscription has expired already or the product has already been acknowledged.";
    public static final String BILLING_CLIENT_NOT_CONNECTED = "Skipping updating pending purchase queue since BillingClient is not connected yet.";
    public static final String CONSUMING_PURCHASE = "Consuming purchase with token %s";
    public static final String CONSUMING_PURCHASE_ERROR = "Error consuming purchase. Will retry next queryPurchases. %s";
    public static final String CONSUMING_PURCHASE_ERROR_RESTORE = "Couldn't consume purchase after restoring it, this most likely means the product has already been consumed.";
    public static final String DEFERRED_PRODUCT_CHANGE_WITH_BASE_PLAN_ID = "Passing a basePlanId in oldProductId (%s) during a DEFERRED product change is not recommended. The basePlanId will be stripped automatically.";
    public static final String EMPTY_ADD_ONS_LIST_PASSED = "An empty list of add-ons was provided. Will proceed with purchasing the base product.";
    public static final String ENTITLEMENT_EXPIRED_OUTSIDE_GRACE_PERIOD = "Entitlement %s is no longer active (expired %s) and it's outside grace period window (last updated %s)";
    public static final String ERROR_FINDING_PURCHASE = "Error finding existing purchase for SKU: %s";
    public static final String EXCEPTION_CANMAKEPAYMENTS = "Exception received when checking if device can make payments: \n%s.";
    public static final String EXTRA_CALLBACK_CANMAKEPAYMENTS = "Callback has already been called when checking if device can make payments.";
    public static final String EXTRA_CONNECTION_CANMAKEPAYMENTS = "BillingClient has returned more than once when checking if device can make payments with result: %s.";
    public static final String FOUND_EXISTING_PURCHASE = "Found existing purchase for SKU: %s";
    public static final PurchaseStrings INSTANCE = new PurchaseStrings();
    public static final String INVALID_CALLBACK_TYPE_INTERNAL_ERROR = "Internal SDK error -- invalid callback type passed to startProductChange.";
    public static final String INVALID_PRODUCT_NO_PRICE = "Error finding a price for %s.";
    public static final String INVALID_PRODUCT_TYPE = "Invalid product type passed to %s.";
    public static final String INVALID_PURCHASE_TYPE = "Purchase for a %s purchase must be a %s.";
    public static final String INVALID_STORE_PRODUCT_TYPE = "StoreProduct for a %s purchase must be a %s.";
    public static final String NOT_CONSUMING_IN_APP_PURCHASE_ACCORDING_TO_BACKEND = "Not consuming in-app purchase according to server configuration. This is expected for non-consumable products. The user won't be able to purchase this product again.";
    public static final String NOT_RECOGNIZED_PRODUCT_TYPE = "Type of product not recognized.";
    public static final String NO_EXISTING_PURCHASE = "Couldn't find existing purchase for SKU: %s";
    public static final String NO_PENDING_PURCHASES_TO_SYNC = "No pending purchases to sync";
    public static final String OFFERING = " - offering: ";
    public static final String PRODUCT_CHANGE_STARTED = "Product change started: %s";
    public static final String PURCHASE_FINISH_TRANSACTION_FALSE = "finishTransactions is set to false and a purchase has been started. Are you sure you want to do this? More info here: https://errors.rev.cat/finishTransactions";
    public static final String PURCHASE_STARTED = "Purchase started - product: %s";
    public static final String PURCHASE_SYNCED = "Purchase %s synced";
    public static final String PURCHASE_SYNCED_USER_ID = "Purchase %s synced %s";
    public static final String PURCHASING_ADD_ONS_ONLY_SUPPORTED_ON_PLAY_STORE = "Making a purchase with add-ons is only supported on the Play Store.";
    public static final String PURCHASING_PRODUCT = "Purchasing product: %s";
    public static final String SKIPPING_AUTOMATIC_SYNC = "Skipping automatic synchronization.";
    public static final String SYNCED_PURCHASES_SUCCESSFULLY = "Synced purchases successfully";
    public static final String SYNCING_PURCHASES = "Syncing purchases";
    public static final String SYNCING_PURCHASES_ERROR = "Error syncing purchases. Error: %s";
    public static final String SYNCING_PURCHASES_ERROR_DETAILS = "Error syncing purchases %s. Error: %s";
    public static final String SYNCING_PURCHASE_ERROR_DETAILS_USER_ID = "Error syncing purchase %s for store user ID %s. Error: %s";
    public static final String SYNCING_PURCHASE_SKIPPING = "Skipping syncing purchase %s for store user ID %s. It has already been posted";
    public static final String SYNCING_PURCHASE_STORE_USER_ID = "Syncing purchase with token %s, for store user ID %s";
    public static final String UPDATING_PENDING_PURCHASE_QUEUE = "Updating pending purchase queue";
    public static final String UPGRADING_INVALID_TYPE = "UpgradeInfo passed to purchase for non-sub product type. No upgrade will occur. Consider using non-upgrade purchase flows for this product.";
    public static final String UPGRADING_SKU = "Moving from old SKU %s to sku %s";
    public static final String UPGRADING_SKU_ERROR = "There was an error trying to upgrade. BillingResponseCode: %s";

    private PurchaseStrings() {
    }
}
