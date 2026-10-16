package com.revenuecat.purchases.ui.revenuecatui.helpers;

import androidx.compose.material3.ColorScheme;
import com.revenuecat.purchases.Offering;
import com.revenuecat.purchases.paywalls.PaywallData;
import com.revenuecat.purchases.paywalls.components.HeaderComponent;
import com.revenuecat.purchases.paywalls.components.PaywallComponent;
import com.revenuecat.purchases.paywalls.components.StackComponent;
import com.revenuecat.purchases.paywalls.components.StickyFooterComponent;
import com.revenuecat.purchases.paywalls.components.common.ComponentOverride;
import com.revenuecat.purchases.paywalls.components.common.LocalizationData;
import com.revenuecat.purchases.paywalls.components.common.LocalizationKey;
import com.revenuecat.purchases.paywalls.components.common.PaywallComponentsConfig;
import com.revenuecat.purchases.paywalls.components.common.PaywallComponentsData;
import com.revenuecat.purchases.paywalls.components.common.VariableLocalizationKey;
import com.revenuecat.purchases.ui.revenuecatui.CustomVariableValue;
import com.revenuecat.purchases.ui.revenuecatui.PaywallMode;
import com.revenuecat.purchases.ui.revenuecatui.components.ktx.LocalizationKt;
import com.revenuecat.purchases.ui.revenuecatui.composables.PaywallIconName;
import com.revenuecat.purchases.ui.revenuecatui.data.PaywallState;
import com.revenuecat.purchases.ui.revenuecatui.data.PurchasesType;
import com.revenuecat.purchases.ui.revenuecatui.data.processed.PackageConfigurationType;
import com.revenuecat.purchases.ui.revenuecatui.data.processed.PaywallTemplate;
import com.revenuecat.purchases.ui.revenuecatui.data.processed.TemplateConfiguration;
import com.revenuecat.purchases.ui.revenuecatui.data.processed.TemplateConfigurationFactory;
import com.revenuecat.purchases.ui.revenuecatui.data.processed.VariableDataProvider;
import com.revenuecat.purchases.ui.revenuecatui.data.processed.VariableProcessor;
import com.revenuecat.purchases.ui.revenuecatui.errors.PaywallValidationError;
import com.revenuecat.purchases.ui.revenuecatui.extensions.PaywallDataExtensionsKt;
import com.revenuecat.purchases.ui.revenuecatui.helpers.PaywallValidationResult;
import com.revenuecat.purchases.ui.revenuecatui.helpers.Result;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function0;
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
public final class OfferingToStateMapperKt {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[PackageConfigurationType.values().length];
            try {
                iArr[PackageConfigurationType.SINGLE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[PackageConfigurationType.MULTIPLE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[PackageConfigurationType.MULTITIER.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static final /* synthetic */ boolean containsUnsupportedCondition(PaywallComponentsConfig paywallComponentsConfig) {
        HeaderComponent header;
        StickyFooterComponent stickyFooter;
        StackComponent stack;
        StackComponent stack2;
        Intrinsics.checkNotNullParameter(paywallComponentsConfig, "<this>");
        return containsUnsupportedCondition(paywallComponentsConfig.getStack()) || !(((header = paywallComponentsConfig.getHeader()) == null || (stack2 = header.getStack()) == null || !containsUnsupportedCondition(stack2)) && ((stickyFooter = paywallComponentsConfig.getStickyFooter()) == null || (stack = stickyFooter.getStack()) == null || !containsUnsupportedCondition(stack)));
    }

    public static final /* synthetic */ PaywallValidationResult.Legacy fallbackPaywall(Offering offering, ColorScheme currentColorScheme, ResourceProvider resourceProvider, PaywallValidationError error) {
        Intrinsics.checkNotNullParameter(offering, "<this>");
        Intrinsics.checkNotNullParameter(currentColorScheme, "currentColorScheme");
        Intrinsics.checkNotNullParameter(resourceProvider, "resourceProvider");
        Intrinsics.checkNotNullParameter(error, "error");
        return fallbackPaywall(offering, currentColorScheme, resourceProvider, (NonEmptyList<? extends PaywallValidationError>) NonEmptyListKt.nonEmptyListOf(error, new PaywallValidationError[0]));
    }

    private static final Map<LocalizationKey, LocalizationData> getDefaultLocalization(PaywallComponentsData paywallComponentsData) {
        return (Map) LocalizationKt.m726getBestMatch64pKzr8(paywallComponentsData.getComponentsLocalizations(), paywallComponentsData.m658getDefaultLocaleIdentifieruqtKvyA());
    }

    private static final Map<VariableLocalizationKey, String> getDefaultVariableLocalization(Offering.PaywallComponents paywallComponents) {
        return (Map) LocalizationKt.m726getBestMatch64pKzr8(paywallComponents.getUiConfig().getLocalizations(), paywallComponents.getData().m658getDefaultLocaleIdentifieruqtKvyA());
    }

    private static final <T> Set<T> getMissingElements(Set<? extends T> set, Set<? extends T> set2) {
        if (set2 == null) {
            set2 = SetsKt.emptySet();
        }
        Set<T> setMinus = SetsKt.minus((Set) set, (Iterable) CollectionsKt.toSet(set2));
        if (setMinus.isEmpty()) {
            return null;
        }
        return setMinus;
    }

    public static final /* synthetic */ boolean hasUnsupportedCondition(List list) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        List list2 = list;
        if ((list2 instanceof Collection) && list2.isEmpty()) {
            return false;
        }
        Iterator it = list2.iterator();
        while (it.hasNext()) {
            List conditions = ((ComponentOverride) it.next()).getConditions();
            if (!(conditions instanceof Collection) || !conditions.isEmpty()) {
                Iterator it2 = conditions.iterator();
                while (it2.hasNext()) {
                    if (((ComponentOverride.Condition) it2.next()) instanceof ComponentOverride.Condition.Unsupported) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static final PaywallState.Loaded.Components toComponentsPaywallState(Offering offering, PaywallValidationResult.Components validationResult, String str, Function0<? extends Date> dateProvider, PurchasesType purchases, Map<String, ? extends CustomVariableValue> customVariables, Map<String, ? extends CustomVariableValue> defaultCustomVariables) {
        Intrinsics.checkNotNullParameter(offering, "<this>");
        Intrinsics.checkNotNullParameter(validationResult, "validationResult");
        Intrinsics.checkNotNullParameter(dateProvider, "dateProvider");
        Intrinsics.checkNotNullParameter(purchases, "purchases");
        Intrinsics.checkNotNullParameter(customVariables, "customVariables");
        Intrinsics.checkNotNullParameter(defaultCustomVariables, "defaultCustomVariables");
        boolean zContains = str != null ? true ^ validationResult.getZeroDecimalPlaceCountries().contains(str) : true;
        return new PaywallState.Loaded.Components(validationResult.getStack(), validationResult.getHeader(), validationResult.getStickyFooter(), validationResult.getBackground(), validationResult.getMainStackHasHeroImage(), zContains, validationResult.getVariableConfig(), validationResult.getVariableDataProvider(), offering, validationResult.getLocales(), str, dateProvider, validationResult.getPackages(), customVariables, defaultCustomVariables, null, validationResult.getInitialSelectedTabIndex(), null, purchases, 163840, null);
    }

    public static /* synthetic */ PaywallState.Loaded.Components toComponentsPaywallState$default(Offering offering, PaywallValidationResult.Components components, String str, Function0 function0, PurchasesType purchasesType, Map map, Map map2, int i3, Object obj) {
        if ((i3 & 16) != 0) {
            map = MapsKt.emptyMap();
        }
        Map map3 = map;
        if ((i3 & 32) != 0) {
            map2 = MapsKt.emptyMap();
        }
        return toComponentsPaywallState(offering, components, str, function0, purchasesType, map3, map2);
    }

    public static final PaywallState toLegacyPaywallState(Offering offering, VariableDataProvider variableDataProvider, PaywallMode mode, PaywallData validatedPaywallData, PaywallTemplate template, boolean z2, String str, PaywallWarning paywallWarning) {
        Intrinsics.checkNotNullParameter(offering, "<this>");
        Intrinsics.checkNotNullParameter(variableDataProvider, "variableDataProvider");
        Intrinsics.checkNotNullParameter(mode, "mode");
        Intrinsics.checkNotNullParameter(validatedPaywallData, "validatedPaywallData");
        Intrinsics.checkNotNullParameter(template, "template");
        Object objM1100createhUnOzRk = TemplateConfigurationFactory.INSTANCE.m1100createhUnOzRk(variableDataProvider, mode, validatedPaywallData, offering.getAvailablePackages(), template, str);
        Throwable thE = kotlin.Result.e(objM1100createhUnOzRk);
        if (thE == null) {
            TemplateConfiguration templateConfiguration = (TemplateConfiguration) objM1100createhUnOzRk;
            return new PaywallState.Loaded.Legacy(offering, templateConfiguration, templateConfiguration.getPackages().getDefault(), z2, paywallWarning);
        }
        String message = thE.getMessage();
        if (message == null) {
            message = "Unknown error";
        }
        return new PaywallState.Error(message);
    }

    public static final PaywallValidationResult.Legacy validate(PaywallData paywallData, ColorScheme currentColorScheme, ResourceProvider resourceProvider) {
        Intrinsics.checkNotNullParameter(paywallData, "<this>");
        Intrinsics.checkNotNullParameter(currentColorScheme, "currentColorScheme");
        Intrinsics.checkNotNullParameter(resourceProvider, "resourceProvider");
        Object objValidate = validate(paywallData);
        Throwable thE = kotlin.Result.e(objValidate);
        if (thE == null) {
            return new PaywallValidationResult.Legacy(paywallData, (PaywallTemplate) objValidate, null, 4, null);
        }
        PaywallData.Companion companion = PaywallData.Companion;
        PaywallData paywallDataCreateDefaultForIdentifiers = PaywallDataExtensionsKt.createDefaultForIdentifiers(companion, paywallData.getConfig().getPackageIds(), currentColorScheme, resourceProvider);
        PaywallTemplate defaultTemplate = PaywallDataExtensionsKt.getDefaultTemplate(companion);
        Intrinsics.checkNotNull(thE, "null cannot be cast to non-null type com.revenuecat.purchases.ui.revenuecatui.errors.PaywallValidationError");
        return new PaywallValidationResult.Legacy(paywallDataCreateDefaultForIdentifiers, defaultTemplate, (PaywallValidationError) thE);
    }

    private static final PaywallValidationError.InvalidIcons validateIcons(PaywallData.LocalizedConfiguration localizedConfiguration) {
        List<PaywallData.LocalizedConfiguration.Feature> features = localizedConfiguration.getFeatures();
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = features.iterator();
        while (it.hasNext()) {
            String strValidateIcons$validateIcon = validateIcons$validateIcon((PaywallData.LocalizedConfiguration.Feature) it.next());
            if (strValidateIcons$validateIcon != null) {
                arrayList.add(strValidateIcons$validateIcon);
            }
        }
        Set set = CollectionsKt.toSet(arrayList);
        if (set.isEmpty()) {
            return null;
        }
        return new PaywallValidationError.InvalidIcons(set);
    }

    private static final String validateIcons$validateIcon(PaywallData.LocalizedConfiguration.Feature feature) {
        String iconID = feature.getIconID();
        if (iconID == null || PaywallIconName.Companion.fromValue(iconID) != null) {
            return null;
        }
        return iconID;
    }

    /* JADX WARN: Removed duplicated region for block: B:156:0x0521  */
    /* JADX WARN: Removed duplicated region for block: B:174:0x057c A[PHI: r0
      0x057c: PHI (r0v24 java.lang.Integer) = (r0v23 java.lang.Integer), (r0v27 java.lang.Integer) binds: [B:166:0x0567, B:170:0x0571] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final com.revenuecat.purchases.ui.revenuecatui.helpers.Result<com.revenuecat.purchases.ui.revenuecatui.helpers.PaywallValidationResult.Components, com.revenuecat.purchases.ui.revenuecatui.helpers.NonEmptyList<com.revenuecat.purchases.ui.revenuecatui.errors.PaywallValidationError>> validatePaywallComponentsDataOrNull(com.revenuecat.purchases.Offering r43, com.revenuecat.purchases.ui.revenuecatui.helpers.ResourceProvider r44) {
        /*
            Method dump skipped, instruction units count: 1553
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.revenuecat.purchases.ui.revenuecatui.helpers.OfferingToStateMapperKt.validatePaywallComponentsDataOrNull(com.revenuecat.purchases.Offering, com.revenuecat.purchases.ui.revenuecatui.helpers.ResourceProvider):com.revenuecat.purchases.ui.revenuecatui.helpers.Result");
    }

    private static final PaywallTemplate validateTemplate(PaywallData paywallData) {
        return PaywallTemplate.Companion.fromId(paywallData.getTemplateName());
    }

    private static final PaywallValidationError.InvalidVariables validateVariables(PaywallData.LocalizedConfiguration localizedConfiguration) {
        Set setPlus = SetsKt.plus(SetsKt.plus(SetsKt.plus(SetsKt.plus(SetsKt.plus(SetsKt.plus((Set) validateVariables$validateVariablesInProperty(localizedConfiguration.getTitle()), (Iterable) validateVariables$validateVariablesInProperty(localizedConfiguration.getSubtitle())), (Iterable) validateVariables$validateVariablesInProperty(localizedConfiguration.getCallToAction())), (Iterable) validateVariables$validateVariablesInProperty(localizedConfiguration.getCallToActionWithIntroOffer())), (Iterable) validateVariables$validateVariablesInProperty(localizedConfiguration.getOfferDetails())), (Iterable) validateVariables$validateVariablesInProperty(localizedConfiguration.getOfferDetailsWithIntroOffer())), (Iterable) validateVariables$validateVariablesInProperty(localizedConfiguration.getOfferName()));
        List<PaywallData.LocalizedConfiguration.Feature> features = localizedConfiguration.getFeatures();
        ArrayList arrayList = new ArrayList();
        for (PaywallData.LocalizedConfiguration.Feature feature : features) {
            CollectionsKt.addAll(arrayList, SetsKt.plus((Set) validateVariables$validateVariablesInProperty(feature.getTitle()), (Iterable) validateVariables$validateVariablesInProperty(feature.getContent())));
        }
        Set setPlus2 = SetsKt.plus(setPlus, (Iterable) arrayList);
        if (setPlus2.isEmpty()) {
            return null;
        }
        return new PaywallValidationError.InvalidVariables(setPlus2);
    }

    private static final Set<String> validateVariables$validateVariablesInProperty(String str) {
        Set<String> setValidateVariables;
        return (str == null || (setValidateVariables = VariableProcessor.INSTANCE.validateVariables(str)) == null) ? SetsKt.emptySet() : setValidateVariables;
    }

    public static final PaywallValidationResult validatedPaywall(Offering offering, ColorScheme currentColorScheme, ResourceProvider resourceProvider) {
        PaywallValidationResult paywallValidationResultFallbackPaywall;
        Intrinsics.checkNotNullParameter(offering, "<this>");
        Intrinsics.checkNotNullParameter(currentColorScheme, "currentColorScheme");
        Intrinsics.checkNotNullParameter(resourceProvider, "resourceProvider");
        Result<PaywallValidationResult.Components, NonEmptyList<PaywallValidationError>> resultValidatePaywallComponentsDataOrNull = validatePaywallComponentsDataOrNull(offering, resourceProvider);
        if (resultValidatePaywallComponentsDataOrNull != null) {
            if (resultValidatePaywallComponentsDataOrNull instanceof Result.Success) {
                paywallValidationResultFallbackPaywall = (PaywallValidationResult) ((Result.Success) resultValidatePaywallComponentsDataOrNull).getValue();
            } else {
                if (!(resultValidatePaywallComponentsDataOrNull instanceof Result.Error)) {
                    throw new NoWhenBranchMatchedException();
                }
                paywallValidationResultFallbackPaywall = fallbackPaywall(offering, currentColorScheme, resourceProvider, (NonEmptyList<? extends PaywallValidationError>) ((Result.Error) resultValidatePaywallComponentsDataOrNull).getValue());
            }
            if (paywallValidationResultFallbackPaywall != null) {
                return paywallValidationResultFallbackPaywall;
            }
        }
        PaywallData paywall = offering.getPaywall();
        return paywall != null ? validate(paywall, currentColorScheme, resourceProvider) : fallbackPaywall(offering, currentColorScheme, resourceProvider, PaywallValidationError.MissingPaywall.INSTANCE);
    }

    private static final PaywallValidationResult.Legacy fallbackPaywall(Offering offering, ColorScheme colorScheme, ResourceProvider resourceProvider, NonEmptyList<? extends PaywallValidationError> nonEmptyList) {
        PaywallData.Companion companion = PaywallData.Companion;
        return new PaywallValidationResult.Legacy(PaywallDataExtensionsKt.createDefault(companion, offering.getAvailablePackages(), colorScheme, resourceProvider), PaywallDataExtensionsKt.getDefaultTemplate(companion), nonEmptyList);
    }

    public static final /* synthetic */ boolean containsUnsupportedCondition(StackComponent stackComponent) {
        Intrinsics.checkNotNullParameter(stackComponent, "<this>");
        if (hasUnsupportedCondition(stackComponent.getOverrides())) {
            return true;
        }
        List components = stackComponent.getComponents();
        if ((components instanceof Collection) && components.isEmpty()) {
            return false;
        }
        Iterator it = components.iterator();
        while (it.hasNext()) {
            if (containsUnsupportedCondition((PaywallComponent) it.next())) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:103:0x013e A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:121:0x0182  */
    /* JADX WARN: Removed duplicated region for block: B:162:0x0223  */
    /* JADX WARN: Removed duplicated region for block: B:167:0x022a A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:211:0x0226 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:215:? A[LOOP:2: B:143:0x01d7->B:215:?, LOOP_END, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final /* synthetic */ boolean containsUnsupportedCondition(com.revenuecat.purchases.paywalls.components.PaywallComponent r4) {
        /*
            Method dump skipped, instruction units count: 645
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.revenuecat.purchases.ui.revenuecatui.helpers.OfferingToStateMapperKt.containsUnsupportedCondition(com.revenuecat.purchases.paywalls.components.PaywallComponent):boolean");
    }

    private static final Object validate(PaywallData paywallData) {
        PaywallTemplate paywallTemplateValidateTemplate = validateTemplate(paywallData);
        if (paywallTemplateValidateTemplate == null) {
            Result.Companion companion = kotlin.Result.f139772b;
            return kotlin.Result.b(kotlin.ResultKt.a(new PaywallValidationError.InvalidTemplate(paywallData.getTemplateName())));
        }
        int i3 = WhenMappings.$EnumSwitchMapping$0[paywallTemplateValidateTemplate.getConfigurationType().ordinal()];
        if (i3 == 1 || i3 == 2) {
            PaywallValidationError paywallValidationErrorValidate = validate((PaywallData.LocalizedConfiguration) paywallData.getLocalizedConfiguration().b());
            if (paywallValidationErrorValidate != null) {
                Result.Companion companion2 = kotlin.Result.f139772b;
                return kotlin.Result.b(kotlin.ResultKt.a(paywallValidationErrorValidate));
            }
        } else if (i3 == 3) {
            List<PaywallData.Configuration.Tier> tiers = paywallData.getConfig().getTiers();
            if (tiers == null) {
                tiers = CollectionsKt.emptyList();
            }
            if (tiers.isEmpty()) {
                Result.Companion companion3 = kotlin.Result.f139772b;
                return kotlin.Result.b(kotlin.ResultKt.a(PaywallValidationError.MissingTiers.INSTANCE));
            }
            List<PaywallData.Configuration.Tier> list = tiers;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(((PaywallData.Configuration.Tier) it.next()).getId());
            }
            Set set = CollectionsKt.toSet(arrayList);
            Map<String, PaywallData.Configuration.ColorInformation> colorsByTier = paywallData.getConfig().getColorsByTier();
            Set missingElements = getMissingElements(set, colorsByTier != null ? colorsByTier.keySet() : null);
            if (missingElements != null) {
                Result.Companion companion4 = kotlin.Result.f139772b;
                return kotlin.Result.b(kotlin.ResultKt.a(new PaywallValidationError.MissingTierConfigurations(missingElements)));
            }
            Map<String, PaywallData.Configuration.Images> imagesByTier = paywallData.getConfig().getImagesByTier();
            Set missingElements2 = getMissingElements(set, imagesByTier != null ? imagesByTier.keySet() : null);
            if (missingElements2 != null) {
                Logger.INSTANCE.w("Missing images for tier(s): " + CollectionsKt.joinToString$default(missingElements2, ",", null, null, 0, null, null, 62, null));
            }
            Map map = (Map) paywallData.getTieredLocalizedConfiguration().b();
            Set missingElements3 = getMissingElements(set, map.keySet());
            if (missingElements3 != null) {
                Result.Companion companion5 = kotlin.Result.f139772b;
                return kotlin.Result.b(kotlin.ResultKt.a(new PaywallValidationError.MissingTierConfigurations(missingElements3)));
            }
            Iterator it2 = map.entrySet().iterator();
            while (it2.hasNext()) {
                PaywallValidationError paywallValidationErrorValidate2 = validate((PaywallData.LocalizedConfiguration) ((Map.Entry) it2.next()).getValue());
                if (paywallValidationErrorValidate2 != null) {
                    Result.Companion companion6 = kotlin.Result.f139772b;
                    return kotlin.Result.b(kotlin.ResultKt.a(paywallValidationErrorValidate2));
                }
            }
        }
        return kotlin.Result.b(paywallTemplateValidateTemplate);
    }

    private static final PaywallValidationError validate(PaywallData.LocalizedConfiguration localizedConfiguration) {
        PaywallValidationError.InvalidVariables invalidVariablesValidateVariables = validateVariables(localizedConfiguration);
        if (invalidVariablesValidateVariables != null) {
            return invalidVariablesValidateVariables;
        }
        PaywallValidationError.InvalidIcons invalidIconsValidateIcons = validateIcons(localizedConfiguration);
        if (invalidIconsValidateIcons != null) {
            return invalidIconsValidateIcons;
        }
        return null;
    }
}
