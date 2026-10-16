package com.revenuecat.purchases.google;

import com.android.billingclient.api.ProductDetails;
import com.revenuecat.purchases.models.GoogleInstallmentsInfo;
import com.revenuecat.purchases.models.GoogleSubscriptionOption;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
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
public final class SubscriptionOptionConversionsKt {
    private static final GoogleInstallmentsInfo getInstallmentsInfo(ProductDetails.InstallmentPlanDetails installmentPlanDetails) {
        return new GoogleInstallmentsInfo(installmentPlanDetails.a(), installmentPlanDetails.b());
    }

    public static final String getSubscriptionBillingPeriod(ProductDetails.SubscriptionOfferDetails subscriptionOfferDetails) {
        Intrinsics.checkNotNullParameter(subscriptionOfferDetails, "<this>");
        List listA = subscriptionOfferDetails.f().a();
        Intrinsics.checkNotNullExpressionValue(listA, "this.pricingPhases.pricingPhaseList");
        ProductDetails.PricingPhase pricingPhase = (ProductDetails.PricingPhase) CollectionsKt.lastOrNull(listA);
        if (pricingPhase != null) {
            return pricingPhase.b();
        }
        return null;
    }

    public static final boolean isBasePlan(ProductDetails.SubscriptionOfferDetails subscriptionOfferDetails) {
        Intrinsics.checkNotNullParameter(subscriptionOfferDetails, "<this>");
        return subscriptionOfferDetails.f().a().size() == 1;
    }

    public static final GoogleSubscriptionOption toSubscriptionOption(ProductDetails.SubscriptionOfferDetails subscriptionOfferDetails, String productId, ProductDetails productDetails) {
        Intrinsics.checkNotNullParameter(subscriptionOfferDetails, "<this>");
        Intrinsics.checkNotNullParameter(productId, "productId");
        Intrinsics.checkNotNullParameter(productDetails, "productDetails");
        List listA = subscriptionOfferDetails.f().a();
        Intrinsics.checkNotNullExpressionValue(listA, "pricingPhases.pricingPhaseList");
        List<ProductDetails.PricingPhase> list = listA;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        for (ProductDetails.PricingPhase it : list) {
            Intrinsics.checkNotNullExpressionValue(it, "it");
            arrayList.add(PricingPhaseConversionsKt.toRevenueCatPricingPhase(it));
        }
        String basePlanId = subscriptionOfferDetails.a();
        Intrinsics.checkNotNullExpressionValue(basePlanId, "basePlanId");
        String strC = subscriptionOfferDetails.c();
        List offerTags = subscriptionOfferDetails.d();
        Intrinsics.checkNotNullExpressionValue(offerTags, "offerTags");
        String offerToken = subscriptionOfferDetails.e();
        Intrinsics.checkNotNullExpressionValue(offerToken, "offerToken");
        ProductDetails.InstallmentPlanDetails installmentPlanDetailsB = subscriptionOfferDetails.b();
        return new GoogleSubscriptionOption(productId, basePlanId, strC, arrayList, offerTags, productDetails, offerToken, null, installmentPlanDetailsB != null ? getInstallmentsInfo(installmentPlanDetailsB) : null);
    }
}
