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
public final class BillingStrings {
    public static final String BILLING_AMAZON_ERROR_LWA_CONSENT_STATUS = "Error obtaining LWA Consent Status in Amazon: %s";
    public static final String BILLING_AMAZON_ERROR_STOREFRONT = "Error obtaining storefront in Amazon: %s";
    public static final String BILLING_CLIENT_DISCONNECTED = "Billing is disconnected and purchase methods won't work. Stacktrace: %s";
    public static final String BILLING_CLIENT_ENDING = "Ending connection for %s";
    public static final String BILLING_CLIENT_ERROR = "Billing Service Setup finished with error code: %s";
    public static final String BILLING_CLIENT_RETRY = "Retrying BillingClient connection after backoff of %s milliseconds.";
    public static final String BILLING_CLIENT_RETRY_ALREADY_SCHEDULED = "BillingClient connection retry already scheduled. Ignoring";
    public static final String BILLING_CLIENT_STARTING = "Starting connection for %s";
    public static final String BILLING_CONFIG_NULL_ON_SUCCESS = "Billing config is null even though Google return OK result";
    public static final String BILLING_CONNECTION_ERROR_INAPP_MESSAGES = "Error connecting to billing client to display in-app messages: %s";
    public static final String BILLING_CONNECTION_ERROR_LWA_CONSENT_STATUS = "Error connecting to billing client to get LWA consent status: %s";
    public static final String BILLING_CONNECTION_ERROR_STORE_COUNTRY = "Error connecting to billing client to get store country: %s";
    public static final String BILLING_COUNTRY_CODE = "Billing connected with country code: %s";
    public static final String BILLING_INAPP_MESSAGE_NONE = "No Google Play in-app message was available.";
    public static final String BILLING_INAPP_MESSAGE_SHOW_EXCEPTION = "Error showing Google Play in-app message: %s";
    public static final String BILLING_INAPP_MESSAGE_UNEXPECTED_CODE = "Unexpected billing code: %s";
    public static final String BILLING_INAPP_MESSAGE_UPDATE = "Subscription status was updated from in-app message.";
    public static final String BILLING_INITIATE_GETTING_COUNTRY_CODE = "Billing client: Initiating getting country code.";
    public static final String BILLING_INTENT_FAILED = "Failed to launch billing intent. %s";
    public static final String BILLING_PURCHASE_HISTORY_RECORD_MORE_THAN_ONE_SKU = "There's more than one sku in the PurchaseHistoryRecord, but only one will be used.";
    public static final String BILLING_SERVICE_DISCONNECTED = "Billing Service disconnected";
    public static final String BILLING_SERVICE_DISCONNECTED_INSTANCE = "Billing Service disconnected for %s";
    public static final String BILLING_SERVICE_SETUP_FINISHED = "Billing Service Setup finished for %s";
    public static final String BILLING_SERVICE_UNAVAILABLE = "Billing is unavailable. Will retry with backoff. App is in background: %s";
    public static final String BILLING_STOREFRONT_CACHING = "Setting storefront cache to %s";
    public static final String BILLING_STOREFRONT_NULL_FROM_CACHE = "Getting storefront from cache was null.";
    public static final String BILLING_UNAVAILABLE = "Billing is not available in this device. %s";
    public static final String BILLING_UNAVAILABLE_LESS_THAN_3 = "Billing is not available in this device. Make sure there's an account configured in Play Store. Reopen the Play Store or clean its caches if this keeps happening. Original error message: %s";
    public static final String BILLING_UNSPECIFIED_INAPP_MESSAGE_TYPES = "Tried to show in-app messages without specifying any types. Please add what types of in-app message you want to display.";
    public static final String BILLING_WRAPPER_PURCHASES_ERROR = "BillingWrapper purchases failed to update: %s";
    public static final String BILLING_WRAPPER_PURCHASES_UPDATED = "BillingWrapper purchases updated: %s";
    public static final String CANNOT_CALL_CAN_MAKE_PAYMENTS = "canMakePayments requires the Google Play Store. Skipping any checks and returning true.";
    public static final String ILLEGAL_STATE_EXCEPTION_WHEN_CONNECTING = "There was an IllegalStateException when connecting to BillingClient. This has been reported to occur on Samsung devices in unknown circumstances.\nException: %s";
    public static final BillingStrings INSTANCE = new BillingStrings();
    public static final String NULL_ACTIVITY_INTENT = "Activity passed into launchBillingFlow has a null intent, which may cause a crash. See https://github.com/RevenueCat/purchases-android/issues/381 for more information.";
    public static final String SECURITY_EXCEPTION_WHEN_CONNECTING = "There was a SecurityException when connecting to BillingClient. This has been reported to occur on some devices in unknown circumstances. See issuetracker: https://issuetracker.google.com/issues/457463701";

    private BillingStrings() {
    }
}
