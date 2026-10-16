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
public final class ProductResponseJsonKeys {
    public static final String BILLING_ISSUES_DETECTED_AT = "billing_issues_detected_at";
    public static final String EXPIRES_DATE = "expires_date";
    public static final ProductResponseJsonKeys INSTANCE = new ProductResponseJsonKeys();
    public static final String IS_SANDBOX = "is_sandbox";
    public static final String MANAGEMENT_URL = "management_url";
    public static final String ORIGINAL_PURCHASE_DATE = "original_purchase_date";
    public static final String OWNERSHIP_TYPE = "ownership_type";
    public static final String PERIOD_TYPE = "period_type";
    public static final String PRODUCT_PLAN_IDENTIFIER = "product_plan_identifier";
    public static final String PURCHASE_DATE = "purchase_date";
    public static final String STORE = "store";
    public static final String UNSUBSCRIBE_DETECTED_AT = "unsubscribe_detected_at";

    private ProductResponseJsonKeys() {
    }
}
