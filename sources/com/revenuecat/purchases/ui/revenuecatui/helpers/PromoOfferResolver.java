package com.revenuecat.purchases.ui.revenuecatui.helpers;

import com.revenuecat.purchases.Package;
import com.revenuecat.purchases.models.GoogleSubscriptionOption;
import com.revenuecat.purchases.models.SubscriptionOption;
import com.revenuecat.purchases.models.SubscriptionOptions;
import com.revenuecat.purchases.paywalls.components.common.PromoOfferConfig;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ResolvedOffer;
import java.util.Iterator;
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
public final class PromoOfferResolver {
    public static final int $stable = 0;
    public static final PromoOfferResolver INSTANCE = new PromoOfferResolver();

    private PromoOfferResolver() {
    }

    private final SubscriptionOption findOfferById(List<? extends SubscriptionOption> list, String str) {
        Object obj;
        Iterator<T> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            SubscriptionOption subscriptionOption = (SubscriptionOption) next;
            GoogleSubscriptionOption googleSubscriptionOption = subscriptionOption instanceof GoogleSubscriptionOption ? (GoogleSubscriptionOption) subscriptionOption : null;
            if (Intrinsics.areEqual(googleSubscriptionOption != null ? googleSubscriptionOption.getOfferId() : null, str)) {
                obj = next;
                break;
            }
        }
        return (SubscriptionOption) obj;
    }

    public final ResolvedOffer resolve(Package rcPackage, PromoOfferConfig promoOfferConfig) {
        Intrinsics.checkNotNullParameter(rcPackage, "rcPackage");
        SubscriptionOption defaultOption = rcPackage.getProduct().getDefaultOption();
        if (promoOfferConfig == null) {
            return new ResolvedOffer.NoConfiguration(defaultOption);
        }
        SubscriptionOptions subscriptionOptions = rcPackage.getProduct().getSubscriptionOptions();
        SubscriptionOption subscriptionOptionFindOfferById = subscriptionOptions != null ? INSTANCE.findOfferById(subscriptionOptions, promoOfferConfig.getOfferId()) : null;
        if (subscriptionOptionFindOfferById != null) {
            return new ResolvedOffer.ConfiguredOffer(subscriptionOptionFindOfferById);
        }
        String str = subscriptionOptions == null ? "product has no subscription options" : "offer not found in available options";
        Logger.INSTANCE.w("Configured offer '" + promoOfferConfig.getOfferId() + "' for package '" + rcPackage.getIdentifier() + "': " + str + ". Falling back to default option.");
        return new ResolvedOffer.OfferNotFound(promoOfferConfig.getOfferId(), defaultOption);
    }
}
