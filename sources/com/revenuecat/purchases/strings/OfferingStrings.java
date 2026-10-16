package com.revenuecat.purchases.strings;

import com.revenuecat.purchases.APIKeyValidator;
import com.revenuecat.purchases.Store;
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
public final class OfferingStrings {
    public static final String BUILDING_OFFERINGS = "Building offerings response with %d products";
    public static final String CANNOT_FIND_PRODUCT_CONFIGURATION_ERROR = "Could not find ProductDetails for %s \nThere is a problem with your configuration in Play Store Developer Console. More info here: https://errors.rev.cat/configuring-products";
    public static final String CONFIGURATION_ERROR_PRODUCTS_NOT_FOUND = "There's a problem with your configuration. None of the products registered in the RevenueCat dashboard could be fetched from the Play Store.\nMore information: https://rev.cat/why-are-offerings-empty";
    public static final String CREATED_OFFERINGS = "Offerings object created with %d offerings";
    public static final String EMPTY_PRODUCT_ID_LIST = "productId list is empty, skipping queryProductDetailsAsync call";
    public static final String ERROR_FETCHING_OFFERINGS_USING_DISK_CACHE = "Error fetching offerings. Using disk cache.";
    public static final String EXTRA_GET_BILLING_CONFIG_RESPONSE = "BillingClient getBillingConfigAsync has returned more than once, with result: %s.";
    public static final String EXTRA_QUERY_PRODUCT_DETAILS_RESPONSE = "BillingClient queryProductDetails has returned more than once, with result: %s. More info here: https://rev.cat/google-duplicated-listener-timeouts";
    public static final String EXTRA_QUERY_PURCHASES_RESPONSE = "BillingClient queryPurchases has returned more than once, with result: %s.";
    public static final String FETCHING_OFFERINGS_ERROR = "Error fetching offerings - %s";
    public static final String FETCHING_PRODUCTS = "Requesting products from the store with identifiers: %s";
    public static final String FETCHING_PRODUCTS_FINISHED = "Products request finished for %s";
    public static final String FORCE_OFFERINGS_FETCHING_NETWORK = "Latest Offerings requested, fetching from network";
    public static final OfferingStrings INSTANCE = new OfferingStrings();
    public static final String JSON_EXCEPTION_ERROR = "JSONException when building Offerings object. Message: %s";
    public static final String LIST_PRODUCTS = "%s - %s";
    public static final String LIST_UNFETCHED_PRODUCTS = "Product not found: %s - Product Type: %s, Reason: %s, Serialized doc ID: %s";
    public static final String MISSING_PRODUCT_DETAILS = "Missing productDetails: %s";
    public static final String NO_CACHED_OFFERINGS_FETCHING_NETWORK = "No cached Offerings, fetching from network";
    public static final String OFFERINGS_STALE_UPDATING_IN_BACKGROUND = "Offerings cache is stale, updating from network in background";
    public static final String OFFERINGS_STALE_UPDATING_IN_FOREGROUND = "Offerings cache is stale, updating from network in foreground";
    public static final String OFFERINGS_START_UPDATE_FROM_NETWORK = "Start Offerings update from network.";
    public static final String OFFERING_EMPTY = "There's a problem with your configuration. No packages could be found for offering with identifier %s. This could be due to Products not being configured correctly in the RevenueCat dashboard or Play Store.\nTo configure products, follow the instructions in https://rev.cat/how-to-configure-offerings.\nMore information: https://rev.cat/why-are-offerings-empty";
    public static final String RETRIEVED_PRODUCTS = "Retrieved productDetailsList: %s";
    public static final String TARGETING_ERROR = "Error while parsing targeting - skipping";
    public static final String VENDING_OFFERINGS_CACHE = "Vending Offerings from cache";

    private OfferingStrings() {
    }

    public final String getConfigurationErrorNoProductsForOfferings(APIKeyValidator.ValidationResult apiKeyValidationResult, Store configuredStore) {
        String str;
        Intrinsics.checkNotNullParameter(apiKeyValidationResult, "apiKeyValidationResult");
        Intrinsics.checkNotNullParameter(configuredStore, "configuredStore");
        String strStoreNameForLogging = OfferingStringsKt.storeNameForLogging(apiKeyValidationResult, configuredStore);
        if (strStoreNameForLogging != null) {
            str = "You have configured the SDK with " + OfferingStringsKt.indefiniteArticle(apiKeyValidationResult, configuredStore) + ' ' + strStoreNameForLogging + " API key, but there are no " + strStoreNameForLogging + " products registered in the RevenueCat dashboard for your offerings.";
        } else {
            str = "You have configured the SDK with an API key from a store that has no products registered in the RevenueCat dashboard for your offerings.";
        }
        return str + " If you don't want to use the offerings system, you can safely ignore this message. To configure offerings and their products, follow the instructions in https://rev.cat/how-to-configure-offerings.\nMore information: https://rev.cat/why-are-offerings-empty";
    }
}
