package com.revenuecat.purchases.google;

import com.android.billingclient.api.BillingResult;
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
public final class BillingResultExtensionsBillingIndependentKt {
    private static final String getOnPurchasesUpdatedSubResponseCodeName(int i3) {
        if (i3 == 0) {
            return "NO_APPLICABLE_SUB_RESPONSE_CODE";
        }
        if (i3 == 1) {
            return "PAYMENT_DECLINED_DUE_TO_INSUFFICIENT_FUNDS";
        }
        if (i3 == 2) {
            return "USER_INELIGIBLE";
        }
        return "UNKNOWN_SUB_RESPONSE_CODE (" + i3 + ')';
    }

    public static final String toHumanReadableDescription(BillingResult billingResult) {
        Intrinsics.checkNotNullParameter(billingResult, "<this>");
        return "DebugMessage: " + billingResult.a() + ". ErrorCode: " + ErrorsKt.getBillingResponseCodeName(billingResult.c()) + ". SubResponseCode: " + getOnPurchasesUpdatedSubResponseCodeName(billingResult.b()) + '.';
    }
}
