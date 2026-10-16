package com.revenuecat.purchases.ui.revenuecatui.helpers;

import com.revenuecat.purchases.ui.revenuecatui.errors.PaywallValidationError;
import java.util.Set;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
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
public abstract class PaywallWarning {
    public static final int $stable = 0;
    public static final Companion Companion = new Companion(null);

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final PaywallWarning from(PaywallValidationError error) {
            Intrinsics.checkNotNullParameter(error, "error");
            if (error instanceof PaywallValidationError.MissingPaywall) {
                return new NoPaywall("unknown");
            }
            if (error instanceof PaywallValidationError.InvalidTemplate) {
                return new InvalidTemplate(((PaywallValidationError.InvalidTemplate) error).getTemplateName());
            }
            if (error instanceof PaywallValidationError.InvalidVariables) {
                return new InvalidVariables(((PaywallValidationError.InvalidVariables) error).getUnrecognizedVariables());
            }
            if (error instanceof PaywallValidationError.InvalidIcons) {
                return new InvalidIcons(((PaywallValidationError.InvalidIcons) error).getInvalidIcons());
            }
            if (error instanceof PaywallValidationError.MissingTiers) {
                return MissingTiers.INSTANCE;
            }
            if (error instanceof PaywallValidationError.MissingTierConfigurations) {
                String str = (String) CollectionsKt.firstOrNull(((PaywallValidationError.MissingTierConfigurations) error).getTierIds());
                return new MissingTier(str != null ? str : "unknown");
            }
            if (error instanceof PaywallValidationError.MissingStringLocalization ? true : error instanceof PaywallValidationError.MissingVideoLocalization ? true : error instanceof PaywallValidationError.AllVariableLocalizationsMissing ? true : error instanceof PaywallValidationError.AllLocalizationsMissing ? true : error instanceof PaywallValidationError.MissingImageLocalization) {
                return MissingLocalization.INSTANCE;
            }
            String message = error.getMessage();
            if (message == null) {
                message = "Unknown error";
            }
            return new Other(message);
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class InvalidIcons extends PaywallWarning {
        public static final int $stable = 8;
        private final Set<String> icons;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public InvalidIcons(Set<String> icons) {
            super(null);
            Intrinsics.checkNotNullParameter(icons, "icons");
            this.icons = icons;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ InvalidIcons copy$default(InvalidIcons invalidIcons, Set set, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                set = invalidIcons.icons;
            }
            return invalidIcons.copy(set);
        }

        public final Set<String> component1() {
            return this.icons;
        }

        public final InvalidIcons copy(Set<String> icons) {
            Intrinsics.checkNotNullParameter(icons, "icons");
            return new InvalidIcons(icons);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof InvalidIcons) && Intrinsics.areEqual(this.icons, ((InvalidIcons) obj).icons);
        }

        public final Set<String> getIcons() {
            return this.icons;
        }

        public int hashCode() {
            return this.icons.hashCode();
        }

        public String toString() {
            return "InvalidIcons(icons=" + this.icons + ')';
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class InvalidTemplate extends PaywallWarning {
        public static final int $stable = 0;
        private final String templateName;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public InvalidTemplate(String templateName) {
            super(null);
            Intrinsics.checkNotNullParameter(templateName, "templateName");
            this.templateName = templateName;
        }

        public static /* synthetic */ InvalidTemplate copy$default(InvalidTemplate invalidTemplate, String str, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                str = invalidTemplate.templateName;
            }
            return invalidTemplate.copy(str);
        }

        public final String component1() {
            return this.templateName;
        }

        public final InvalidTemplate copy(String templateName) {
            Intrinsics.checkNotNullParameter(templateName, "templateName");
            return new InvalidTemplate(templateName);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof InvalidTemplate) && Intrinsics.areEqual(this.templateName, ((InvalidTemplate) obj).templateName);
        }

        public final String getTemplateName() {
            return this.templateName;
        }

        public int hashCode() {
            return this.templateName.hashCode();
        }

        public String toString() {
            return "InvalidTemplate(templateName=" + this.templateName + ')';
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class InvalidVariables extends PaywallWarning {
        public static final int $stable = 8;
        private final Set<String> variables;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public InvalidVariables(Set<String> variables) {
            super(null);
            Intrinsics.checkNotNullParameter(variables, "variables");
            this.variables = variables;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ InvalidVariables copy$default(InvalidVariables invalidVariables, Set set, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                set = invalidVariables.variables;
            }
            return invalidVariables.copy(set);
        }

        public final Set<String> component1() {
            return this.variables;
        }

        public final InvalidVariables copy(Set<String> variables) {
            Intrinsics.checkNotNullParameter(variables, "variables");
            return new InvalidVariables(variables);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof InvalidVariables) && Intrinsics.areEqual(this.variables, ((InvalidVariables) obj).variables);
        }

        public final Set<String> getVariables() {
            return this.variables;
        }

        public int hashCode() {
            return this.variables.hashCode();
        }

        public String toString() {
            return "InvalidVariables(variables=" + this.variables + ')';
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class MissingLocalization extends PaywallWarning {
        public static final int $stable = 0;
        public static final MissingLocalization INSTANCE = new MissingLocalization();

        private MissingLocalization() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class MissingTier extends PaywallWarning {
        public static final int $stable = 0;
        private final String tierId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public MissingTier(String tierId) {
            super(null);
            Intrinsics.checkNotNullParameter(tierId, "tierId");
            this.tierId = tierId;
        }

        public static /* synthetic */ MissingTier copy$default(MissingTier missingTier, String str, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                str = missingTier.tierId;
            }
            return missingTier.copy(str);
        }

        public final String component1() {
            return this.tierId;
        }

        public final MissingTier copy(String tierId) {
            Intrinsics.checkNotNullParameter(tierId, "tierId");
            return new MissingTier(tierId);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof MissingTier) && Intrinsics.areEqual(this.tierId, ((MissingTier) obj).tierId);
        }

        public final String getTierId() {
            return this.tierId;
        }

        public int hashCode() {
            return this.tierId.hashCode();
        }

        public String toString() {
            return "MissingTier(tierId=" + this.tierId + ')';
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class MissingTierName extends PaywallWarning {
        public static final int $stable = 0;
        private final String tierId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public MissingTierName(String tierId) {
            super(null);
            Intrinsics.checkNotNullParameter(tierId, "tierId");
            this.tierId = tierId;
        }

        public static /* synthetic */ MissingTierName copy$default(MissingTierName missingTierName, String str, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                str = missingTierName.tierId;
            }
            return missingTierName.copy(str);
        }

        public final String component1() {
            return this.tierId;
        }

        public final MissingTierName copy(String tierId) {
            Intrinsics.checkNotNullParameter(tierId, "tierId");
            return new MissingTierName(tierId);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof MissingTierName) && Intrinsics.areEqual(this.tierId, ((MissingTierName) obj).tierId);
        }

        public final String getTierId() {
            return this.tierId;
        }

        public int hashCode() {
            return this.tierId.hashCode();
        }

        public String toString() {
            return "MissingTierName(tierId=" + this.tierId + ')';
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class MissingTiers extends PaywallWarning {
        public static final int $stable = 0;
        public static final MissingTiers INSTANCE = new MissingTiers();

        private MissingTiers() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class NoOffering extends PaywallWarning {
        public static final int $stable = 0;
        public static final NoOffering INSTANCE = new NoOffering();

        private NoOffering() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class NoPaywall extends PaywallWarning {
        public static final int $stable = 0;
        private final String offeringId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public NoPaywall(String offeringId) {
            super(null);
            Intrinsics.checkNotNullParameter(offeringId, "offeringId");
            this.offeringId = offeringId;
        }

        public static /* synthetic */ NoPaywall copy$default(NoPaywall noPaywall, String str, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                str = noPaywall.offeringId;
            }
            return noPaywall.copy(str);
        }

        public final String component1() {
            return this.offeringId;
        }

        public final NoPaywall copy(String offeringId) {
            Intrinsics.checkNotNullParameter(offeringId, "offeringId");
            return new NoPaywall(offeringId);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof NoPaywall) && Intrinsics.areEqual(this.offeringId, ((NoPaywall) obj).offeringId);
        }

        public final String getOfferingId() {
            return this.offeringId;
        }

        public int hashCode() {
            return this.offeringId.hashCode();
        }

        public String toString() {
            return "NoPaywall(offeringId=" + this.offeringId + ')';
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class NoProducts extends PaywallWarning {
        public static final int $stable = 8;
        private final Throwable error;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public NoProducts(Throwable error) {
            super(null);
            Intrinsics.checkNotNullParameter(error, "error");
            this.error = error;
        }

        public static /* synthetic */ NoProducts copy$default(NoProducts noProducts, Throwable th, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                th = noProducts.error;
            }
            return noProducts.copy(th);
        }

        public final Throwable component1() {
            return this.error;
        }

        public final NoProducts copy(Throwable error) {
            Intrinsics.checkNotNullParameter(error, "error");
            return new NoProducts(error);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof NoProducts) && Intrinsics.areEqual(this.error, ((NoProducts) obj).error);
        }

        public final Throwable getError() {
            return this.error;
        }

        public int hashCode() {
            return this.error.hashCode();
        }

        public String toString() {
            return "NoProducts(error=" + this.error + ')';
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Other extends PaywallWarning {
        public static final int $stable = 0;
        private final String message;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Other(String message) {
            super(null);
            Intrinsics.checkNotNullParameter(message, "message");
            this.message = message;
        }

        public static /* synthetic */ Other copy$default(Other other, String str, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                str = other.message;
            }
            return other.copy(str);
        }

        public final String component1() {
            return this.message;
        }

        public final Other copy(String message) {
            Intrinsics.checkNotNullParameter(message, "message");
            return new Other(message);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Other) && Intrinsics.areEqual(this.message, ((Other) obj).message);
        }

        public final String getMessage() {
            return this.message;
        }

        public int hashCode() {
            return this.message.hashCode();
        }

        public String toString() {
            return "Other(message=" + this.message + ')';
        }
    }

    public /* synthetic */ PaywallWarning(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public final String getBodyText() {
        if (this instanceof NoPaywall) {
            return "Your `" + ((NoPaywall) this).getOfferingId() + "` offering has no configured paywalls. Set one up in the RevenueCat Dashboard to begin.";
        }
        if (this instanceof NoOffering) {
            return "We could not detect any offerings. Set one up in the RevenueCat Dashboard to begin.";
        }
        if (this instanceof NoProducts) {
            StringBuilder sb = new StringBuilder();
            sb.append("We could not fetch any products: ");
            NoProducts noProducts = (NoProducts) this;
            String localizedMessage = noProducts.getError().getLocalizedMessage();
            if (localizedMessage == null && (localizedMessage = noProducts.getError().getMessage()) == null) {
                localizedMessage = "Unknown error";
            }
            sb.append(localizedMessage);
            return sb.toString();
        }
        if (this instanceof MissingLocalization) {
            return "Your paywall is missing a localization. Add a localization in the RevenueCat Dashboard to begin.";
        }
        if (this instanceof MissingTiers) {
            return "Your paywall is missing any tiers. Add some tiers in the RevenueCat Dashboard to begin.";
        }
        if (this instanceof MissingTier) {
            return "The tier with ID: " + ((MissingTier) this).getTierId() + " is missing a localization. Add a localization in the RevenueCat Dashboard to begin.";
        }
        if (this instanceof MissingTierName) {
            return "The tier: " + ((MissingTierName) this).getTierId() + " is missing a name. Add a name in the RevenueCat Dashboard to continue.";
        }
        if (this instanceof InvalidTemplate) {
            return "The template with ID: `" + ((InvalidTemplate) this).getTemplateName() + "` does not exist for this version of the SDK. Please make sure to update your SDK to the latest version and try again.";
        }
        if (this instanceof InvalidVariables) {
            return "The following variables are not recognized: " + CollectionsKt.joinToString$default(CollectionsKt.sorted(((InvalidVariables) this).getVariables()), ", ", null, null, 0, null, null, 62, null) + ". Please check the docs for a list of valid variables.";
        }
        if (this instanceof InvalidIcons) {
            return "The following icon names are not valid: " + CollectionsKt.joinToString$default(CollectionsKt.sorted(((InvalidIcons) this).getIcons()), ", ", null, null, 0, null, null, 62, null) + ". Please check `PaywallIcon` for the list of valid icon names.";
        }
        if (!(this instanceof Other)) {
            throw new NoWhenBranchMatchedException();
        }
        return "Paywall validation failed with message: " + ((Other) this).getMessage();
    }

    public final String getHelpUrl() {
        if (this instanceof NoPaywall ? true : this instanceof MissingTierName ? true : this instanceof MissingTier ? true : this instanceof MissingTiers) {
            return "https://www.revenuecat.com/docs/tools/paywalls";
        }
        if (this instanceof NoOffering) {
            return "https://www.revenuecat.com/docs/offerings/overview";
        }
        if (this instanceof NoProducts) {
            return "https://www.revenuecat.com/docs/offerings/products-overview";
        }
        if (this instanceof InvalidVariables) {
            return "https://www.revenuecat.com/docs/tools/paywalls/creating-paywalls/variables";
        }
        return null;
    }

    public final String getTitle() {
        if (this instanceof NoPaywall) {
            return "No Paywall configured";
        }
        if (this instanceof NoOffering) {
            return "No Offering found";
        }
        if (this instanceof NoProducts) {
            return "Could not fetch products";
        }
        if (this instanceof MissingLocalization) {
            return "Missing localization";
        }
        if (this instanceof MissingTiers) {
            return "No Tiers";
        }
        if (this instanceof MissingTier) {
            return "Tier is missing localization";
        }
        if (this instanceof MissingTierName) {
            return "Tier " + ((MissingTierName) this).getTierId() + " is missing a name";
        }
        if (this instanceof InvalidTemplate) {
            return "Unknown Template";
        }
        if (this instanceof InvalidVariables) {
            return "Unrecognized variables";
        }
        if (this instanceof InvalidIcons) {
            return "Invalid icon names";
        }
        if (this instanceof Other) {
            return "Paywall Misconfigured";
        }
        throw new NoWhenBranchMatchedException();
    }

    private PaywallWarning() {
    }
}
