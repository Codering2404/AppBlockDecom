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
public final class RestoreStrings {
    public static final String EXTRA_QUERY_PURCHASE_HISTORY_RESPONSE = "BillingClient queryPurchaseHistory has returned more than once, with result: %s. More info here: https://rev.cat/google-duplicated-listener-timeouts";
    public static final RestoreStrings INSTANCE = new RestoreStrings();
    public static final String PURCHASE_HISTORY_EMPTY = "Purchase history is empty.";
    public static final String PURCHASE_HISTORY_RETRIEVED = "Purchase history retrieved %s";
    public static final String PURCHASE_RESTORED = "Purchase %s restored";
    public static final String QUERYING_INAPP_ERROR = "Error when querying inapps. %s";
    public static final String QUERYING_PURCHASE = "Querying purchases";
    public static final String QUERYING_PURCHASE_HISTORY = "Querying purchase history for type %s";
    public static final String QUERYING_PURCHASE_WITH_HASH = "Purchase of type %s with hash %s";
    public static final String QUERYING_PURCHASE_WITH_TYPE = "Querying Purchase with %s and type %s";
    public static final String QUERYING_SUBS_ERROR = "Error when querying subscriptions. %s";
    public static final String RESTORE_PURCHASES_NO_PURCHASES_FOUND = "No purchases found to restore. This will happen if the user does not have any active subscriptions or unconsumed one-time products.Please make sure you're using the correct Store account (Google/Amazon) and that you have configured your one-time products correctly as either consumables (that can be purchased multiple times) or non-consumables (that can only be purchased one by each user) in the RevenueCat dashboard. This will return the current CustomerInfo.";
    public static final String RESTORE_PURCHASES_SIMULATED_STORE = "Restoring purchases not available in test store. Returning current CustomerInfo.";
    public static final String RESTORING_PURCHASE = "Restoring purchases";
    public static final String RESTORING_PURCHASE_ERROR = "Error restoring purchase: %s. Error: %s";
    public static final String SHARING_ACC_RESTORE_FALSE = "allowSharingPlayStoreAccount is set to false and restorePurchases has been called. This will 'alias' any app user id's sharing the same receipt. Are you sure you want to do this? More info here: https://errors.rev.cat/allowsSharingPlayStoreAccount";
    public static final String SYNC_PURCHASES_SIMULATED_STORE = "Syncing purchases not available in test store. Returning current CustomerInfo.";

    private RestoreStrings() {
    }
}
