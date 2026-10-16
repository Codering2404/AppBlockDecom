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
public final class OfflineEntitlementsStrings {
    public static final String ALREADY_CALCULATING_OFFLINE_CUSTOMER_INFO = "Already calculating offline customer info for %s.";
    public static final String ERROR_PARSING_PRODUCT_ENTITLEMENT_MAPPING = "Error parsing cached product entitlement mapping: %s";
    public static final String ERROR_UPDATING_PRODUCT_ENTITLEMENTS = "Error updating product entitlement mappings. Error: %s.";
    public static final OfflineEntitlementsStrings INSTANCE = new OfflineEntitlementsStrings();
    public static final String OFFLINE_ENTITLEMENTS_NOT_ENABLED = "Offline entitlements not enabled in this version.";
    public static final String OFFLINE_ENTITLEMENTS_UNSUPPORTED_INAPP_PURCHASES = "Offline entitlements are not supported for one time purchases. Found one time purchases. See for more info: https://rev.cat/offline-entitlements";
    public static final String PRODUCT_ENTITLEMENT_MAPPING_REQUIRED = "Product entitlement mapping is required for offline entitlements. Skipping offline customer info calculation.";
    public static final String RESETTING_OFFLINE_CUSTOMER_INFO_CACHE = "Resetting offline customer info cache.";
    public static final String SUCCESSFULLY_UPDATED_PRODUCT_ENTITLEMENTS = "Successfully updated product entitlement mappings.";
    public static final String UPDATING_PRODUCT_ENTITLEMENT_MAPPING = "Product entitlement mappings are stale. Updating.";
    public static final String USING_OFFLINE_ENTITLEMENTS_CUSTOMER_INFO = "Using offline computed customer info. In this state EntitlementInfo's isSandbox will always be false. Additionally, the expiration date may be inaccurate. Once the transactions are synced with our backend, these values will be automatically corrected.";

    private OfflineEntitlementsStrings() {
    }
}
