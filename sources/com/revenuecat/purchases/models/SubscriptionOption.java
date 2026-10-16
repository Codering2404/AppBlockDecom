package com.revenuecat.purchases.models;

import com.revenuecat.purchases.PresentedOfferingContext;
import java.util.Iterator;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:71)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:37)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:35)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
@Metadata
public interface SubscriptionOption {
    default Period getBillingPeriod() {
        PricingPhase fullPricePhase = getFullPricePhase();
        if (fullPricePhase != null) {
            return fullPricePhase.getBillingPeriod();
        }
        return null;
    }

    default PricingPhase getFreePhase() {
        Object next;
        Iterator it = CollectionsKt.dropLast(getPricingPhases(), 1).iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (((PricingPhase) next).getPrice().getAmountMicros() == 0) {
                break;
            }
        }
        return (PricingPhase) next;
    }

    default PricingPhase getFullPricePhase() {
        return (PricingPhase) CollectionsKt.lastOrNull((List) getPricingPhases());
    }

    String getId();

    InstallmentsInfo getInstallmentsInfo();

    default PricingPhase getIntroPhase() {
        Object next;
        Iterator it = CollectionsKt.dropLast(getPricingPhases(), 1).iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (((PricingPhase) next).getPrice().getAmountMicros() > 0) {
                break;
            }
        }
        return (PricingPhase) next;
    }

    PresentedOfferingContext getPresentedOfferingContext();

    String getPresentedOfferingIdentifier();

    List<PricingPhase> getPricingPhases();

    PurchasingData getPurchasingData();

    List<String> getTags();

    default boolean isBasePlan() {
        return getPricingPhases().size() == 1;
    }

    default boolean isPrepaid() {
        PricingPhase fullPricePhase = getFullPricePhase();
        return (fullPricePhase != null ? fullPricePhase.getRecurrenceMode() : null) == RecurrenceMode.NON_RECURRING;
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class DefaultImpls {
        @Deprecated
        public static Period getBillingPeriod(SubscriptionOption subscriptionOption) {
            return SubscriptionOption.super.getBillingPeriod();
        }

        @Deprecated
        public static PricingPhase getFreePhase(SubscriptionOption subscriptionOption) {
            return SubscriptionOption.super.getFreePhase();
        }

        @Deprecated
        public static PricingPhase getFullPricePhase(SubscriptionOption subscriptionOption) {
            return SubscriptionOption.super.getFullPricePhase();
        }

        @Deprecated
        public static PricingPhase getIntroPhase(SubscriptionOption subscriptionOption) {
            return SubscriptionOption.super.getIntroPhase();
        }

        @Deprecated
        public static boolean isBasePlan(SubscriptionOption subscriptionOption) {
            return SubscriptionOption.super.isBasePlan();
        }

        @Deprecated
        public static boolean isPrepaid(SubscriptionOption subscriptionOption) {
            return SubscriptionOption.super.isPrepaid();
        }

        @Deprecated
        public static /* synthetic */ void getPresentedOfferingIdentifier$annotations() {
        }
    }
}
