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
public final class ConfigureStrings {
    public static final String AMAZON_API_KEY_GALAXY_STORE = "Looks like you're using an Amazon API key but have configured the SDK for the Galaxy Store.\nEither use a Galaxy Store API key which should look like 'galx_1a2b3c4d5e6f7h' or configure the SDK to use Amazon.\nSee https://rev.cat/auth for more details.";
    public static final String AMAZON_API_KEY_GOOGLE_STORE = "Looks like you're using an Amazon API key but have configured the SDK for the Google play store.\nEither use a Google API key which should look like 'goog_1a2b3c4d5e6f7h' or configure the SDK to use Amazon.\nSee https://rev.cat/auth for more details.";
    public static final String APP_BACKGROUNDED = "App backgrounded";
    public static final String APP_FOREGROUNDED = "App foregrounded";
    public static final String AUTO_SYNC_PURCHASES_DISABLED = "Automatic syncing of purchases has been disabled. \nRevenueCat won’t observe the new purchases from the store, and it will not sync any purchase \nautomatically. Call syncPurchases whenever a new transaction is completed so the \nreceipt is sent to RevenueCat’s backend. Consumables disappear from the receipt \nafter the transaction is finished, so make sure purchases are synced before \nfinishing any consumable transaction, otherwise RevenueCat won’t register the \npurchase.";
    public static final String CONFIGURING_PURCHASES_PROXY_URL_SET = "Purchases is being configured using a proxy for RevenueCat";
    public static final String DEBUG_ENABLED = "Debug logging enabled";
    public static final String GALAXY_API_KEY_AMAZON_STORE = "Looks like you're using a Galaxy Store API key but have configured the SDK for the Amazon App Store.\nEither use an Amazon API key which should look like 'amzn_1a2b3c4d5e6f7h' or configure the SDK to use the Galaxy Store.\nSee https://rev.cat/auth for more details.";
    public static final String GALAXY_API_KEY_GOOGLE_STORE = "Looks like you're using a Galaxy Store API key but have configured the SDK for the Google Play Store.\nEither use a Google API key which should look like 'goog_1a2b3c4d5e6f7h' or configure the SDK to use the Galaxy Store.\nSee https://rev.cat/auth for more details.";
    public static final String GOOGLE_API_KEY_AMAZON_STORE = "Looks like you're using a Google API key but have configured the SDK for the Amazon app store.\nEither use an Amazon API key which should look like 'amzn_1a2b3c4d5e6f7h' or configure the SDK to use Google.\nSee https://rev.cat/auth for more details.";
    public static final String GOOGLE_API_KEY_GALAXY_STORE = "Looks like you're using a Google API key but have configured the SDK for the Galaxy Store.\nEither use a Galaxy Store API key which should look like 'galx_1a2b3c4d5e6f7h' or configure the SDK to use the Play Store.\nSee https://rev.cat/auth for more details.";
    public static final String INITIAL_APP_USER_ID = "Initial App User ID - %s";
    public static final ConfigureStrings INSTANCE = new ConfigureStrings();
    public static final String INSTANCE_ALREADY_EXISTS = "Purchases instance already set. Did you mean to configure two Purchases objects?";
    public static final String INSTANCE_ALREADY_EXISTS_WITH_SAME_CONFIG = "Purchases instance already set with the same configuration. Ignoring duplicate call.";
    public static final String INVALID_API_KEY = "The specified API Key is not recognized.\nEnsure that you are using the public app-specific API key, which should look like 'goog_1a2b3c4d5e6f7h', 'amzn_1a2b3c4d5e6f7h', or 'galx_1a2b3c4d5e6f7h'.\nSee https://rev.cat/auth for more details.";
    public static final String LEGACY_API_KEY = "Looks like you're using a legacy API key.\nThis is still supported, but it's recommended to migrate to using platform-specific API key, which should look like 'goog_1a2b3c4d5e6f7h', 'amzn_1a2b3c4d5e6f7h', or 'galx_1a2b3c4d5e6f7h'.\nSee https://rev.cat/auth for more details.";
    public static final String LISTENER_SET = "Listener set";
    public static final String NO_SINGLETON_INSTANCE = "There is no singleton instance. Make sure you configure Purchases before trying to get the default instance. More info here: https://errors.rev.cat/configuring-sdk";
    public static final String PACKAGE_NAME = "Package name - %s";
    public static final String SDK_VERSION = "SDK Version - %s";
    public static final String SIMULATED_STORE_API_KEY = "Using a Test Store API key.\nThe Test Store is for development only. Never use a Test Store API key in production. Our SDK will crash if using it in production. Test Store purchases are simulated, do not use Google Play or Amazon store, and generate no revenue. Apps submitted with a Test Store API key will be rejected during App Review.";
    public static final String VERIFICATION_MODE_SELECTED = "Purchases configured with response verification: %s";

    private ConfigureStrings() {
    }
}
