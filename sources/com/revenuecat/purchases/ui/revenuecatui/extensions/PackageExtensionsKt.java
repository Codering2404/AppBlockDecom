package com.revenuecat.purchases.ui.revenuecatui.extensions;

import com.revenuecat.purchases.Package;
import com.revenuecat.purchases.ProductType;
import com.revenuecat.purchases.models.Period;
import com.revenuecat.purchases.models.PricingPhase;
import com.revenuecat.purchases.models.SubscriptionOption;
import com.revenuecat.purchases.ui.revenuecatui.composables.OfferEligibility;
import com.revenuecat.purchases.ui.revenuecatui.data.processed.TemplateConfiguration;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ResolvedOffer;
import java.util.List;
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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class PackageExtensionsKt {
    public static final OfferEligibility calculateOfferEligibility(ResolvedOffer resolvedOffer, Package rcPackage) {
        Intrinsics.checkNotNullParameter(rcPackage, "rcPackage");
        if (resolvedOffer != null && resolvedOffer.isPromoOffer()) {
            OfferEligibility offerEligibilityPromoOfferEligibility = promoOfferEligibility(resolvedOffer);
            if (!Intrinsics.areEqual(offerEligibilityPromoOfferEligibility, OfferEligibility.PromoOfferIneligible.INSTANCE)) {
                return offerEligibilityPromoOfferEligibility;
            }
        }
        return getIntroOfferEligibility(rcPackage);
    }

    public static final OfferEligibility getIntroOfferEligibility(Package r12) {
        List<PricingPhase> pricingPhases;
        Intrinsics.checkNotNullParameter(r12, "<this>");
        SubscriptionOption defaultOption = r12.getProduct().getDefaultOption();
        int size = ((defaultOption == null || (pricingPhases = defaultOption.getPricingPhases()) == null) ? 0 : pricingPhases.size()) - 1;
        return size != 1 ? size != 2 ? OfferEligibility.Ineligible.INSTANCE : OfferEligibility.IntroOfferMultiple.INSTANCE : OfferEligibility.IntroOfferSingle.INSTANCE;
    }

    public static final OfferEligibility getOfferEligibility(TemplateConfiguration.PackageInfo packageInfo) {
        Intrinsics.checkNotNullParameter(packageInfo, "<this>");
        return getIntroOfferEligibility(packageInfo.getRcPackage());
    }

    public static final boolean isMonthly(Package r3) {
        Intrinsics.checkNotNullParameter(r3, "<this>");
        Period period = r3.getProduct().getPeriod();
        return period != null && period.getUnit() == Period.Unit.MONTH && period.getValue() == 1;
    }

    public static final boolean isSubscription(Package r12) {
        Intrinsics.checkNotNullParameter(r12, "<this>");
        return r12.getProduct().getType() == ProductType.SUBS;
    }

    private static final OfferEligibility promoOfferEligibility(ResolvedOffer resolvedOffer) {
        List<PricingPhase> pricingPhases;
        SubscriptionOption subscriptionOption = resolvedOffer.getSubscriptionOption();
        int size = ((subscriptionOption == null || (pricingPhases = subscriptionOption.getPricingPhases()) == null) ? 0 : pricingPhases.size()) - 1;
        return size != 1 ? size != 2 ? OfferEligibility.PromoOfferIneligible.INSTANCE : OfferEligibility.PromoOfferMultiple.INSTANCE : OfferEligibility.PromoOfferSingle.INSTANCE;
    }
}
