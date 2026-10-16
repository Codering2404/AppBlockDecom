package com.revenuecat.purchases.ui.revenuecatui.helpers;

import androidx.compose.material.icons.twotone.Phg.QaXmqxvjHhxVy;
import com.revenuecat.purchases.UiConfig;
import com.revenuecat.purchases.paywalls.PaywallData;
import com.revenuecat.purchases.paywalls.components.common.LocaleId;
import com.revenuecat.purchases.ui.revenuecatui.components.properties.BackgroundStyles;
import com.revenuecat.purchases.ui.revenuecatui.components.style.ComponentStyle;
import com.revenuecat.purchases.ui.revenuecatui.data.PaywallState;
import com.revenuecat.purchases.ui.revenuecatui.data.processed.PaywallTemplate;
import com.revenuecat.purchases.ui.revenuecatui.data.processed.VariableDataProvider;
import com.revenuecat.purchases.ui.revenuecatui.errors.PaywallValidationError;
import com.sun.jna.Function;
import java.util.Set;
import kotlin.Metadata;
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
public interface PaywallValidationResult {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Components implements PaywallValidationResult {
        public static final int $stable = 8;
        private final BackgroundStyles background;
        private final NonEmptyList<PaywallValidationError> errors;
        private final ComponentStyle header;
        private final Integer initialSelectedTabIndex;
        private final NonEmptySet<LocaleId> locales;
        private final boolean mainStackHasHeroImage;
        private final PaywallState.Loaded.Components.AvailablePackages packages;
        private final ComponentStyle stack;
        private final ComponentStyle stickyFooter;
        private final UiConfig.VariableConfig variableConfig;
        private final VariableDataProvider variableDataProvider;
        private final Set<String> zeroDecimalPlaceCountries;

        public Components(ComponentStyle stack, ComponentStyle componentStyle, ComponentStyle componentStyle2, BackgroundStyles background, NonEmptySet<LocaleId> locales, Set<String> zeroDecimalPlaceCountries, UiConfig.VariableConfig variableConfig, VariableDataProvider variableDataProvider, PaywallState.Loaded.Components.AvailablePackages packages, Integer num, boolean z2) {
            Intrinsics.checkNotNullParameter(stack, "stack");
            Intrinsics.checkNotNullParameter(background, "background");
            Intrinsics.checkNotNullParameter(locales, "locales");
            Intrinsics.checkNotNullParameter(zeroDecimalPlaceCountries, "zeroDecimalPlaceCountries");
            Intrinsics.checkNotNullParameter(variableConfig, "variableConfig");
            Intrinsics.checkNotNullParameter(variableDataProvider, "variableDataProvider");
            Intrinsics.checkNotNullParameter(packages, "packages");
            this.stack = stack;
            this.header = componentStyle;
            this.stickyFooter = componentStyle2;
            this.background = background;
            this.locales = locales;
            this.zeroDecimalPlaceCountries = zeroDecimalPlaceCountries;
            this.variableConfig = variableConfig;
            this.variableDataProvider = variableDataProvider;
            this.packages = packages;
            this.initialSelectedTabIndex = num;
            this.mainStackHasHeroImage = z2;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Components copy$default(Components components, ComponentStyle componentStyle, ComponentStyle componentStyle2, ComponentStyle componentStyle3, BackgroundStyles backgroundStyles, NonEmptySet nonEmptySet, Set set, UiConfig.VariableConfig variableConfig, VariableDataProvider variableDataProvider, PaywallState.Loaded.Components.AvailablePackages availablePackages, Integer num, boolean z2, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                componentStyle = components.stack;
            }
            if ((i3 & 2) != 0) {
                componentStyle2 = components.header;
            }
            if ((i3 & 4) != 0) {
                componentStyle3 = components.stickyFooter;
            }
            if ((i3 & 8) != 0) {
                backgroundStyles = components.background;
            }
            if ((i3 & 16) != 0) {
                nonEmptySet = components.locales;
            }
            if ((i3 & 32) != 0) {
                set = components.zeroDecimalPlaceCountries;
            }
            if ((i3 & 64) != 0) {
                variableConfig = components.variableConfig;
            }
            if ((i3 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0) {
                variableDataProvider = components.variableDataProvider;
            }
            if ((i3 & Function.MAX_NARGS) != 0) {
                availablePackages = components.packages;
            }
            if ((i3 & 512) != 0) {
                num = components.initialSelectedTabIndex;
            }
            if ((i3 & 1024) != 0) {
                z2 = components.mainStackHasHeroImage;
            }
            Integer num2 = num;
            boolean z3 = z2;
            VariableDataProvider variableDataProvider2 = variableDataProvider;
            PaywallState.Loaded.Components.AvailablePackages availablePackages2 = availablePackages;
            Set set2 = set;
            UiConfig.VariableConfig variableConfig2 = variableConfig;
            NonEmptySet nonEmptySet2 = nonEmptySet;
            ComponentStyle componentStyle4 = componentStyle3;
            return components.copy(componentStyle, componentStyle2, componentStyle4, backgroundStyles, nonEmptySet2, set2, variableConfig2, variableDataProvider2, availablePackages2, num2, z3);
        }

        public final ComponentStyle component1() {
            return this.stack;
        }

        public final Integer component10() {
            return this.initialSelectedTabIndex;
        }

        public final boolean component11() {
            return this.mainStackHasHeroImage;
        }

        public final ComponentStyle component2() {
            return this.header;
        }

        public final ComponentStyle component3() {
            return this.stickyFooter;
        }

        public final BackgroundStyles component4() {
            return this.background;
        }

        public final NonEmptySet<LocaleId> component5() {
            return this.locales;
        }

        public final Set<String> component6() {
            return this.zeroDecimalPlaceCountries;
        }

        public final UiConfig.VariableConfig component7() {
            return this.variableConfig;
        }

        public final VariableDataProvider component8() {
            return this.variableDataProvider;
        }

        public final PaywallState.Loaded.Components.AvailablePackages component9() {
            return this.packages;
        }

        public final Components copy(ComponentStyle stack, ComponentStyle componentStyle, ComponentStyle componentStyle2, BackgroundStyles background, NonEmptySet<LocaleId> locales, Set<String> zeroDecimalPlaceCountries, UiConfig.VariableConfig variableConfig, VariableDataProvider variableDataProvider, PaywallState.Loaded.Components.AvailablePackages packages, Integer num, boolean z2) {
            Intrinsics.checkNotNullParameter(stack, "stack");
            Intrinsics.checkNotNullParameter(background, "background");
            Intrinsics.checkNotNullParameter(locales, "locales");
            Intrinsics.checkNotNullParameter(zeroDecimalPlaceCountries, "zeroDecimalPlaceCountries");
            Intrinsics.checkNotNullParameter(variableConfig, "variableConfig");
            Intrinsics.checkNotNullParameter(variableDataProvider, "variableDataProvider");
            Intrinsics.checkNotNullParameter(packages, "packages");
            return new Components(stack, componentStyle, componentStyle2, background, locales, zeroDecimalPlaceCountries, variableConfig, variableDataProvider, packages, num, z2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Components)) {
                return false;
            }
            Components components = (Components) obj;
            return Intrinsics.areEqual(this.stack, components.stack) && Intrinsics.areEqual(this.header, components.header) && Intrinsics.areEqual(this.stickyFooter, components.stickyFooter) && Intrinsics.areEqual(this.background, components.background) && Intrinsics.areEqual(this.locales, components.locales) && Intrinsics.areEqual(this.zeroDecimalPlaceCountries, components.zeroDecimalPlaceCountries) && Intrinsics.areEqual(this.variableConfig, components.variableConfig) && Intrinsics.areEqual(this.variableDataProvider, components.variableDataProvider) && Intrinsics.areEqual(this.packages, components.packages) && Intrinsics.areEqual(this.initialSelectedTabIndex, components.initialSelectedTabIndex) && this.mainStackHasHeroImage == components.mainStackHasHeroImage;
        }

        public final BackgroundStyles getBackground() {
            return this.background;
        }

        @Override // com.revenuecat.purchases.ui.revenuecatui.helpers.PaywallValidationResult
        public NonEmptyList<PaywallValidationError> getErrors() {
            return this.errors;
        }

        public final ComponentStyle getHeader() {
            return this.header;
        }

        public final Integer getInitialSelectedTabIndex() {
            return this.initialSelectedTabIndex;
        }

        public final NonEmptySet<LocaleId> getLocales() {
            return this.locales;
        }

        public final boolean getMainStackHasHeroImage() {
            return this.mainStackHasHeroImage;
        }

        public final PaywallState.Loaded.Components.AvailablePackages getPackages() {
            return this.packages;
        }

        public final ComponentStyle getStack() {
            return this.stack;
        }

        public final ComponentStyle getStickyFooter() {
            return this.stickyFooter;
        }

        public final UiConfig.VariableConfig getVariableConfig() {
            return this.variableConfig;
        }

        public final VariableDataProvider getVariableDataProvider() {
            return this.variableDataProvider;
        }

        public final Set<String> getZeroDecimalPlaceCountries() {
            return this.zeroDecimalPlaceCountries;
        }

        public int hashCode() {
            int iHashCode = this.stack.hashCode() * 31;
            ComponentStyle componentStyle = this.header;
            int iHashCode2 = (iHashCode + (componentStyle == null ? 0 : componentStyle.hashCode())) * 31;
            ComponentStyle componentStyle2 = this.stickyFooter;
            int iHashCode3 = (((((((((((((iHashCode2 + (componentStyle2 == null ? 0 : componentStyle2.hashCode())) * 31) + this.background.hashCode()) * 31) + this.locales.hashCode()) * 31) + this.zeroDecimalPlaceCountries.hashCode()) * 31) + this.variableConfig.hashCode()) * 31) + this.variableDataProvider.hashCode()) * 31) + this.packages.hashCode()) * 31;
            Integer num = this.initialSelectedTabIndex;
            return ((iHashCode3 + (num != null ? num.hashCode() : 0)) * 31) + Boolean.hashCode(this.mainStackHasHeroImage);
        }

        public String toString() {
            return "Components(stack=" + this.stack + ", header=" + this.header + ", stickyFooter=" + this.stickyFooter + ", background=" + this.background + ", locales=" + this.locales + QaXmqxvjHhxVy.qfaSiwLNCeGhy + this.zeroDecimalPlaceCountries + ", variableConfig=" + this.variableConfig + ", variableDataProvider=" + this.variableDataProvider + ", packages=" + this.packages + ", initialSelectedTabIndex=" + this.initialSelectedTabIndex + ", mainStackHasHeroImage=" + this.mainStackHasHeroImage + ')';
        }

        public /* synthetic */ Components(ComponentStyle componentStyle, ComponentStyle componentStyle2, ComponentStyle componentStyle3, BackgroundStyles backgroundStyles, NonEmptySet nonEmptySet, Set set, UiConfig.VariableConfig variableConfig, VariableDataProvider variableDataProvider, PaywallState.Loaded.Components.AvailablePackages availablePackages, Integer num, boolean z2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this(componentStyle, componentStyle2, componentStyle3, backgroundStyles, nonEmptySet, set, variableConfig, variableDataProvider, availablePackages, num, (i3 & 1024) != 0 ? false : z2);
        }
    }

    NonEmptyList<PaywallValidationError> getErrors();

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Legacy implements PaywallValidationResult {
        public static final int $stable = 8;
        private final PaywallData displayablePaywall;
        private final NonEmptyList<PaywallValidationError> errors;
        private final PaywallTemplate template;

        /* JADX WARN: Multi-variable type inference failed */
        public Legacy(PaywallData displayablePaywall, PaywallTemplate template, NonEmptyList<? extends PaywallValidationError> nonEmptyList) {
            Intrinsics.checkNotNullParameter(displayablePaywall, "displayablePaywall");
            Intrinsics.checkNotNullParameter(template, "template");
            this.displayablePaywall = displayablePaywall;
            this.template = template;
            this.errors = nonEmptyList;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Legacy copy$default(Legacy legacy, PaywallData paywallData, PaywallTemplate paywallTemplate, NonEmptyList nonEmptyList, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                paywallData = legacy.displayablePaywall;
            }
            if ((i3 & 2) != 0) {
                paywallTemplate = legacy.template;
            }
            if ((i3 & 4) != 0) {
                nonEmptyList = legacy.errors;
            }
            return legacy.copy(paywallData, paywallTemplate, nonEmptyList);
        }

        public final PaywallData component1() {
            return this.displayablePaywall;
        }

        public final PaywallTemplate component2() {
            return this.template;
        }

        public final NonEmptyList<PaywallValidationError> component3() {
            return this.errors;
        }

        public final Legacy copy(PaywallData displayablePaywall, PaywallTemplate template, NonEmptyList<? extends PaywallValidationError> nonEmptyList) {
            Intrinsics.checkNotNullParameter(displayablePaywall, "displayablePaywall");
            Intrinsics.checkNotNullParameter(template, "template");
            return new Legacy(displayablePaywall, template, nonEmptyList);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Legacy)) {
                return false;
            }
            Legacy legacy = (Legacy) obj;
            return Intrinsics.areEqual(this.displayablePaywall, legacy.displayablePaywall) && this.template == legacy.template && Intrinsics.areEqual(this.errors, legacy.errors);
        }

        public final PaywallData getDisplayablePaywall() {
            return this.displayablePaywall;
        }

        @Override // com.revenuecat.purchases.ui.revenuecatui.helpers.PaywallValidationResult
        public NonEmptyList<PaywallValidationError> getErrors() {
            return this.errors;
        }

        public final PaywallTemplate getTemplate() {
            return this.template;
        }

        public final PaywallWarning getWarning() {
            PaywallValidationError paywallValidationError;
            NonEmptyList<PaywallValidationError> errors = getErrors();
            if (errors == null || (paywallValidationError = (PaywallValidationError) errors.getHead()) == null) {
                return null;
            }
            return PaywallWarning.Companion.from(paywallValidationError);
        }

        public int hashCode() {
            int iHashCode = ((this.displayablePaywall.hashCode() * 31) + this.template.hashCode()) * 31;
            NonEmptyList<PaywallValidationError> nonEmptyList = this.errors;
            return iHashCode + (nonEmptyList == null ? 0 : nonEmptyList.hashCode());
        }

        public String toString() {
            return "Legacy(displayablePaywall=" + this.displayablePaywall + ", template=" + this.template + ", errors=" + this.errors + ')';
        }

        public /* synthetic */ Legacy(PaywallData paywallData, PaywallTemplate paywallTemplate, NonEmptyList nonEmptyList, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this(paywallData, paywallTemplate, (NonEmptyList<? extends PaywallValidationError>) ((i3 & 4) != 0 ? null : nonEmptyList));
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public Legacy(PaywallData displayablePaywall, PaywallTemplate template, PaywallValidationError error) {
            this(displayablePaywall, template, (NonEmptyList<? extends PaywallValidationError>) NonEmptyListKt.nonEmptyListOf(error, new PaywallValidationError[0]));
            Intrinsics.checkNotNullParameter(displayablePaywall, "displayablePaywall");
            Intrinsics.checkNotNullParameter(template, "template");
            Intrinsics.checkNotNullParameter(error, "error");
        }
    }
}
