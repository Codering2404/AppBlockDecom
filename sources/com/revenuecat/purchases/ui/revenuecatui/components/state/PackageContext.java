package com.revenuecat.purchases.ui.revenuecatui.components.state;

import com.revenuecat.purchases.Package;
import com.revenuecat.purchases.models.SubscriptionOption;
import com.revenuecat.purchases.ui.revenuecatui.composables.OfferEligibility;
import com.revenuecat.purchases.ui.revenuecatui.data.PaywallState;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ResolvedOffer;
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
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public interface PackageContext {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class DefaultImpls {
        public static /* synthetic */ boolean computeIsSelected(PackageContext packageContext, PaywallState.Loaded.Components.SelectedPackageInfo selectedPackageInfo, int i3) {
            Package rcPackage;
            String packageUniqueId = packageContext.getPackageUniqueId();
            Package rcPackage2 = packageContext.getRcPackage();
            Integer tabIndex = packageContext.getTabIndex();
            if (packageUniqueId != null) {
                return Intrinsics.areEqual(packageUniqueId, selectedPackageInfo != null ? selectedPackageInfo.getUniqueId() : null);
            }
            if (rcPackage2 == null) {
                return tabIndex != null && tabIndex.intValue() == i3;
            }
            String identifier = rcPackage2.getIdentifier();
            if (selectedPackageInfo != null && (rcPackage = selectedPackageInfo.getRcPackage()) != null) {
                identifier = rcPackage.getIdentifier();
            }
            return Intrinsics.areEqual(identifier, identifier);
        }

        public static String getPackageUniqueId(PackageContext packageContext) {
            SubscriptionOption option;
            Package rcPackage = packageContext.getRcPackage();
            String id = null;
            if (rcPackage == null) {
                return null;
            }
            ResolvedOffer resolvedOffer = packageContext.getResolvedOffer();
            ResolvedOffer.ConfiguredOffer configuredOffer = resolvedOffer instanceof ResolvedOffer.ConfiguredOffer ? (ResolvedOffer.ConfiguredOffer) resolvedOffer : null;
            if (configuredOffer != null && (option = configuredOffer.getOption()) != null) {
                id = option.getId();
            }
            if (id == null) {
                return rcPackage.getIdentifier();
            }
            return rcPackage.getIdentifier() + ':' + id;
        }

        public static /* synthetic */ OfferEligibility resolveOfferEligibility(PackageContext packageContext, OfferEligibility selectedOfferEligibility) {
            Intrinsics.checkNotNullParameter(selectedOfferEligibility, "selectedOfferEligibility");
            OfferEligibility offerEligibility = packageContext.getOfferEligibility();
            return offerEligibility == null ? selectedOfferEligibility : offerEligibility;
        }
    }

    /* synthetic */ boolean computeIsSelected(PaywallState.Loaded.Components.SelectedPackageInfo selectedPackageInfo, int i3);

    OfferEligibility getOfferEligibility();

    String getPackageUniqueId();

    Package getRcPackage();

    ResolvedOffer getResolvedOffer();

    Integer getTabIndex();

    /* synthetic */ OfferEligibility resolveOfferEligibility(OfferEligibility offerEligibility);
}
