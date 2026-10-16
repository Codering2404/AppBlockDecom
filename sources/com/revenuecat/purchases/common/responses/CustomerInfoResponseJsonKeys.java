package com.revenuecat.purchases.common.responses;

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
public final class CustomerInfoResponseJsonKeys {
    public static final String ENTITLEMENTS = "entitlements";
    public static final String FIRST_SEEN = "first_seen";
    public static final CustomerInfoResponseJsonKeys INSTANCE = new CustomerInfoResponseJsonKeys();
    public static final String MANAGEMENT_URL = "management_url";
    public static final String NON_SUBSCRIPTIONS = "non_subscriptions";
    public static final String ORIGINAL_APPLICATION_VERSION = "original_application_version";
    public static final String ORIGINAL_APP_USER_ID = "original_app_user_id";
    public static final String ORIGINAL_PURCHASE_DATE = "original_purchase_date";
    public static final String PURCHASE_DATE = "purchase_date";
    public static final String REQUEST_DATE = "request_date";
    public static final String REQUEST_DATE_MS = "request_date_ms";
    public static final String SUBSCRIBER = "subscriber";
    public static final String SUBSCRIPTIONS = "subscriptions";

    private CustomerInfoResponseJsonKeys() {
    }
}
