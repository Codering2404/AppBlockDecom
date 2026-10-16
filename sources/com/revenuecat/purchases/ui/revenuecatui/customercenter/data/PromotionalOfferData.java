package com.revenuecat.purchases.ui.revenuecatui.customercenter.data;

import com.revenuecat.purchases.customercenter.CustomerCenterConfigData;
import com.revenuecat.purchases.models.SubscriptionOption;
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
public final class PromotionalOfferData {
    public static final int $stable = 8;
    private final CustomerCenterConfigData.HelpPath.PathDetail.PromotionalOffer configuredPromotionalOffer;
    private final String localizedPricingPhasesDescription;
    private final CustomerCenterConfigData.HelpPath originalPath;
    private final SubscriptionOption subscriptionOption;

    public PromotionalOfferData(CustomerCenterConfigData.HelpPath.PathDetail.PromotionalOffer configuredPromotionalOffer, SubscriptionOption subscriptionOption, CustomerCenterConfigData.HelpPath originalPath, String localizedPricingPhasesDescription) {
        Intrinsics.checkNotNullParameter(configuredPromotionalOffer, "configuredPromotionalOffer");
        Intrinsics.checkNotNullParameter(subscriptionOption, "subscriptionOption");
        Intrinsics.checkNotNullParameter(originalPath, "originalPath");
        Intrinsics.checkNotNullParameter(localizedPricingPhasesDescription, "localizedPricingPhasesDescription");
        this.configuredPromotionalOffer = configuredPromotionalOffer;
        this.subscriptionOption = subscriptionOption;
        this.originalPath = originalPath;
        this.localizedPricingPhasesDescription = localizedPricingPhasesDescription;
    }

    public static /* synthetic */ PromotionalOfferData copy$default(PromotionalOfferData promotionalOfferData, CustomerCenterConfigData.HelpPath.PathDetail.PromotionalOffer promotionalOffer, SubscriptionOption subscriptionOption, CustomerCenterConfigData.HelpPath helpPath, String str, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            promotionalOffer = promotionalOfferData.configuredPromotionalOffer;
        }
        if ((i3 & 2) != 0) {
            subscriptionOption = promotionalOfferData.subscriptionOption;
        }
        if ((i3 & 4) != 0) {
            helpPath = promotionalOfferData.originalPath;
        }
        if ((i3 & 8) != 0) {
            str = promotionalOfferData.localizedPricingPhasesDescription;
        }
        return promotionalOfferData.copy(promotionalOffer, subscriptionOption, helpPath, str);
    }

    public final CustomerCenterConfigData.HelpPath.PathDetail.PromotionalOffer component1() {
        return this.configuredPromotionalOffer;
    }

    public final SubscriptionOption component2() {
        return this.subscriptionOption;
    }

    public final CustomerCenterConfigData.HelpPath component3() {
        return this.originalPath;
    }

    public final String component4() {
        return this.localizedPricingPhasesDescription;
    }

    public final PromotionalOfferData copy(CustomerCenterConfigData.HelpPath.PathDetail.PromotionalOffer configuredPromotionalOffer, SubscriptionOption subscriptionOption, CustomerCenterConfigData.HelpPath originalPath, String localizedPricingPhasesDescription) {
        Intrinsics.checkNotNullParameter(configuredPromotionalOffer, "configuredPromotionalOffer");
        Intrinsics.checkNotNullParameter(subscriptionOption, "subscriptionOption");
        Intrinsics.checkNotNullParameter(originalPath, "originalPath");
        Intrinsics.checkNotNullParameter(localizedPricingPhasesDescription, "localizedPricingPhasesDescription");
        return new PromotionalOfferData(configuredPromotionalOffer, subscriptionOption, originalPath, localizedPricingPhasesDescription);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PromotionalOfferData)) {
            return false;
        }
        PromotionalOfferData promotionalOfferData = (PromotionalOfferData) obj;
        return Intrinsics.areEqual(this.configuredPromotionalOffer, promotionalOfferData.configuredPromotionalOffer) && Intrinsics.areEqual(this.subscriptionOption, promotionalOfferData.subscriptionOption) && Intrinsics.areEqual(this.originalPath, promotionalOfferData.originalPath) && Intrinsics.areEqual(this.localizedPricingPhasesDescription, promotionalOfferData.localizedPricingPhasesDescription);
    }

    public final /* synthetic */ CustomerCenterConfigData.HelpPath.PathDetail.PromotionalOffer getConfiguredPromotionalOffer() {
        return this.configuredPromotionalOffer;
    }

    public final /* synthetic */ String getLocalizedPricingPhasesDescription() {
        return this.localizedPricingPhasesDescription;
    }

    public final /* synthetic */ CustomerCenterConfigData.HelpPath getOriginalPath() {
        return this.originalPath;
    }

    public final /* synthetic */ SubscriptionOption getSubscriptionOption() {
        return this.subscriptionOption;
    }

    public int hashCode() {
        return (((((this.configuredPromotionalOffer.hashCode() * 31) + this.subscriptionOption.hashCode()) * 31) + this.originalPath.hashCode()) * 31) + this.localizedPricingPhasesDescription.hashCode();
    }

    public String toString() {
        return "PromotionalOfferData(configuredPromotionalOffer=" + this.configuredPromotionalOffer + ", subscriptionOption=" + this.subscriptionOption + ", originalPath=" + this.originalPath + ", localizedPricingPhasesDescription=" + this.localizedPricingPhasesDescription + ')';
    }
}
