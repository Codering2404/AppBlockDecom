package com.revenuecat.purchases.common.diagnostics;

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
/* JADX INFO: loaded from: classes5.dex */
@Metadata
public enum DiagnosticsEntryName {
    HTTP_REQUEST_PERFORMED,
    MAX_EVENTS_STORED_LIMIT_REACHED,
    MAX_DIAGNOSTICS_SYNC_RETRIES_REACHED,
    CLEARING_DIAGNOSTICS_AFTER_FAILED_SYNC,
    GOOGLE_QUERY_PRODUCT_DETAILS_REQUEST,
    GOOGLE_QUERY_PURCHASES_REQUEST,
    GOOGLE_QUERY_PURCHASE_HISTORY_REQUEST,
    GOOGLE_BILLING_START_CONNECTION,
    GOOGLE_BILLING_SETUP_FINISHED,
    GOOGLE_BILLING_SERVICE_DISCONNECTED,
    PRODUCT_DETAILS_NOT_SUPPORTED,
    CUSTOMER_INFO_VERIFICATION_RESULT,
    AMAZON_QUERY_PRODUCT_DETAILS_REQUEST,
    AMAZON_QUERY_PURCHASES_REQUEST,
    AMAZON_PURCHASE_ATTEMPT,
    ENTERED_OFFLINE_ENTITLEMENTS_MODE,
    ERROR_ENTERING_OFFLINE_ENTITLEMENTS_MODE,
    GOOGLE_PURCHASE_STARTED,
    GOOGLE_PURCHASES_UPDATE_RECEIVED,
    GET_OFFERINGS_STARTED,
    GET_OFFERINGS_RESULT,
    GET_PRODUCTS_STARTED,
    GET_PRODUCTS_RESULT,
    PURCHASE_STARTED,
    PURCHASE_RESULT,
    SYNC_PURCHASES_STARTED,
    SYNC_PURCHASES_RESULT,
    RESTORE_PURCHASES_STARTED,
    RESTORE_PURCHASES_RESULT,
    GET_CUSTOMER_INFO_STARTED,
    GET_CUSTOMER_INFO_RESULT
}
