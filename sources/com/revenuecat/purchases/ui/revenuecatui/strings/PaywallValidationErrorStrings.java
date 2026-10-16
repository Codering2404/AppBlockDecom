package com.revenuecat.purchases.ui.revenuecatui.strings;

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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class PaywallValidationErrorStrings {
    public static final int $stable = 0;
    public static final String ALIASED_COLOR_IS_ALIAS = "Aliased color '%s' has an aliased value '%s', which is not allowed.";
    public static final String ALL_LOCALIZATIONS_MISSING_FOR_LOCALE = "All localizations for locale '%s' are missing.";
    public static final String ALL_VARIABLE_LOCALIZATIONS_MISSING_FOR_LOCALE = "All variable localizations for locale '%s' are missing.";
    public static final String DISPLAYING_DEFAULT = "Displaying default template due to validation errors.";
    public static final PaywallValidationErrorStrings INSTANCE = new PaywallValidationErrorStrings();
    public static final String INVALID_ICONS = "One or more icons were not recognized: %s";
    public static final String INVALID_MODE_FOR_COMPONENTS_PAYWALL = "Paywalls V2 does not support footer modes. Falling back to legacy fallback paywall.";
    public static final String INVALID_TEMPLATE_NAME = "Template name is not recognized: %s";
    public static final String INVALID_VARIABLES = "There were some errors validating variables in the paywall strings. The unrecognized variables are: %s";
    public static final String MISSING_COLOR_ALIAS = "Aliased color '%s' does not exist.";
    public static final String MISSING_FONT_ALIAS = "Aliased font '%s' does not exist.";
    public static final String MISSING_IMAGE_LOCALIZATION = "Missing image localization for property with id: '%s'";
    public static final String MISSING_IMAGE_LOCALIZATION_WITH_LOCALE = "Missing image localization for property with id: '%s', for locale: '%s'.";
    public static final String MISSING_PACKAGE = "The Paywall references a package with id '%s', but Offering '%s' does not contain such a package. It has these packages instead: [%s]. Either add the missing package to the Offering or remove it from the Paywall.";
    public static final String MISSING_PAYWALL = "Displaying default template because paywall is missing for offering '%s'. If you expected to see a v2 Paywall, make sure it is published.";
    public static final String MISSING_STRING_LOCALIZATION = "Missing string localization for property with id: '%s'";
    public static final String MISSING_STRING_LOCALIZATION_WITH_LOCALE = "Missing string localization for property with id: '%s', for locale: '%s'.";
    public static final String MISSING_TIERS = "Displaying default template because paywall tiers are missing for offering '%s'.";
    public static final String MISSING_TIER_CONFIGURATIONS = "There are required tier configurations missing for: '%s'.";
    public static final String MISSING_VIDEO_LOCALIZATION = "Missing video localization for property with id: '%s'";
    public static final String MISSING_VIDEO_LOCALIZATION_WITH_LOCALE = "Missing video localization for property with id: '%s', for locale: '%s'.";
    public static final String ROOT_COMPONENT_UNSUPPORTED_PROPERTIES = "This paywall's root component is hidden because it contains unsupported properties: %s";
    public static final String TABS_COMPONENT_WITHOUT_TABS = "Tabs component has no tabs configured.";
    public static final String TAB_CONTROL_NOT_IN_TAB = "Encountered a Tab Control component that is not in any tab.";
    public static final String UNSUPPORTED_BACKGROUND_TYPE = "This SDK version does not support this background type: %s";
    public static final String WORKFLOW_BUTTON_MISSING_COMPONENT_ID = "Workflow button '%s' has no component id and will not respond to taps.";

    private PaywallValidationErrorStrings() {
    }
}
