package com.revenuecat.purchases.common;

import com.revenuecat.purchases.models.PricingPhase;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
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
/* JADX INFO: loaded from: classes5.dex */
@Metadata
public final class BackendKt {
    public static final String ATTRIBUTES_ERROR_RESPONSE_KEY = "attributes_error_response";
    public static final String ATTRIBUTE_ERRORS_KEY = "attribute_errors";

    public static final Map<String, Object> toMap(PricingPhase pricingPhase) {
        Intrinsics.checkNotNullParameter(pricingPhase, "<this>");
        return MapsKt.mapOf(TuplesKt.a(com.facebook.appevents.internal.Constants.GP_IAP_BILLING_PERIOD, pricingPhase.getBillingPeriod().getIso8601()), TuplesKt.a("billingCycleCount", pricingPhase.getBillingCycleCount()), TuplesKt.a(com.facebook.appevents.internal.Constants.GP_IAP_RECURRENCE_MODE, pricingPhase.getRecurrenceMode().getIdentifier()), TuplesKt.a("formattedPrice", pricingPhase.getPrice().getFormatted()), TuplesKt.a(com.facebook.appevents.internal.Constants.GP_IAP_PRICE_AMOUNT_MICROS_V5V7, Long.valueOf(pricingPhase.getPrice().getAmountMicros())), TuplesKt.a(com.facebook.appevents.internal.Constants.GP_IAP_PRICE_CURRENCY_CODE_V5V7, pricingPhase.getPrice().getCurrencyCode()));
    }

    public static /* synthetic */ void CustomerCenterCallback$annotations() {
    }

    public static /* synthetic */ void OfferingsCallback$annotations() {
    }

    public static /* synthetic */ void ProductEntitlementCallback$annotations() {
    }

    public static /* synthetic */ void WorkflowDetailCallback$annotations() {
    }
}
