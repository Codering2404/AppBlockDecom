package com.revenuecat.purchases.amazon;

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
/* JADX INFO: loaded from: classes4.dex */
@Metadata
public final class AmazonStrings {
    public static final String CACHING_RECEIPT_TERM_SKUS = "Caching term skus for receipts: \n %s";
    public static final String ERROR_FAILED_PURCHASES_UPDATES = "Failed to get purchase updates.";
    public static final String ERROR_FAILED_USER_DATA = "Failed to get user data. Make sure sandbox mode is enabled if using App Tester. https://rev.cat/enter-amazon-sandbox";
    public static final String ERROR_FETCHING_PURCHASE_HISTORY_ALL_RECEIPTS_INVALID = "Error fetching purchase history. All receipts are invalid.";
    public static final String ERROR_FETCHING_RECEIPTS = "Couldn't fetch information for the following receipts: \n %s";
    public static final String ERROR_FETCHING_RECEIPT_INFO = "There was an error fetching receipt information: %s";
    public static final String ERROR_FINDING_RECEIPT_SKU = "Couldn't find sku for token %s";
    public static final String ERROR_PURCHASES_UPDATES_STORE_PROBLEM = "Failed to get purchase updates. There was an Amazon store problem.";
    public static final String ERROR_PURCHASE_ALREADY_OWNED = "Failed to make purchase. User already owns SKU.";
    public static final String ERROR_PURCHASE_FAILED = "Failed to make purchase. This error normally means that the purchase was cancelled";
    public static final String ERROR_PURCHASE_INVALID_PROXY_ACTIVITY_ARGUMENTS = "Failed to make purchase. Arguments are invalid. \n Intent: %s";
    public static final String ERROR_PURCHASE_INVALID_SKU = "Failed to make purchase. SKU is invalid";
    public static final String ERROR_PURCHASE_NOT_SUPPORTED = "Failed to make purchase. Call is not supported";
    public static final String ERROR_PURCHASE_UNKNOWN = "Failed to make purchase. There was an Amazon store problem.";
    public static final String ERROR_TIMEOUT_GETTING_PRODUCT_DATA = "Timeout error trying to get Amazon product data for SKUs: %s. Please check that the SKUs are correct.";
    public static final String ERROR_TIMEOUT_GETTING_USER_DATA = "Timeout error trying to get Amazon user data.";
    public static final String ERROR_UNSUPPORTED_PURCHASES_UPDATES = "Failed to get purchase updates. Call is not supported.";
    public static final String ERROR_UNSUPPORTED_USER_DATA = "Failed to get user data. Call is not supported.";
    public static final String ERROR_USER_DATA_LWA_CONSENT_STATUS_NULL_STORE_PROBLEM = "Failed to get LWA Consent Status from user data. It was null.";
    public static final String ERROR_USER_DATA_MARKETPLACE_NULL_STORE_PROBLEM = "Failed to get marketplace from user data. It was null.";
    public static final String ERROR_USER_DATA_STORE_PROBLEM = "Failed to get user data. There was an Amazon store problem.";
    public static final AmazonStrings INSTANCE = new AmazonStrings();
    public static final String PRODUCTS_REQUEST_FINISHED = "Products request finished with result %s";
    public static final String PRODUCTS_REQUEST_UNAVAILABLE = "Unavailable products: %s";
    public static final String PRODUCT_CHANGES_NOT_SUPPORTED = "Amazon doesn't support product changes";
    public static final String PRODUCT_PRICE_MISSING = "Product %s is missing a price. This is common if you're trying to load a product SKU instead of a subscription term SKU. Make sure you configure the subscription term SKUs in the RevenueCat dashboard.";
    public static final String PURCHASE_REQUEST_FINISHED = "Purchase request finished: \n %s";
    public static final String RECEIPT_DATA_RECEIVED = "Received receipt data: \n %s";
    public static final String REQUESTING_PRODUCTS = "Requesting Amazon products with identifiers: %s";
    public static final String RETRIEVED_PRODUCT_DATA = "Retrieved productData: %s";
    public static final String RETRIEVED_PRODUCT_DATA_EMPTY = "Product data is empty";
    public static final String USER_DATA_REQUEST_FINISHED = "User data request finished with result %s";
    public static final String USER_DATA_REQUEST_FROM_CACHE = "Getting User data from cache";
    public static final String WARNING_AMAZON_NOT_FINISHING_TRANSACTIONS = "Attempting to interact with the Amazon App Store while RevenueCat is configured not to complete purchases won't do anything. (See AmazonConfiguration.Builder.purchasesAreCompletedBy().) Please use syncAmazonPurchase to send purchases to RevenueCat instead.";

    private AmazonStrings() {
    }
}
