package com.revenuecat.purchases.ui.revenuecatui.errors;

import androidx.legacy.content.Werj.QgXempTBEfV;
import com.revenuecat.purchases.ColorAlias;
import com.revenuecat.purchases.FontAlias;
import com.revenuecat.purchases.Offering;
import com.revenuecat.purchases.paywalls.components.PaywallComponent;
import com.revenuecat.purchases.paywalls.components.common.Background;
import com.revenuecat.purchases.paywalls.components.common.LocaleId;
import com.revenuecat.purchases.paywalls.components.common.LocalizationKey;
import com.revenuecat.purchases.ui.revenuecatui.strings.PaywallValidationErrorStrings;
import java.util.Arrays;
import java.util.Collection;
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
public abstract class PaywallValidationError extends Throwable {
    public static final int $stable = 0;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class AliasedColorIsAlias extends PaywallValidationError {
        public static final int $stable = 0;
        private final String alias;
        private final String aliasedValue;
        private final String message;

        public /* synthetic */ AliasedColorIsAlias(String str, String str2, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, str2);
        }

        /* JADX INFO: renamed from: copy-tjeIzsg$default, reason: not valid java name */
        public static /* synthetic */ AliasedColorIsAlias m1116copytjeIzsg$default(AliasedColorIsAlias aliasedColorIsAlias, String str, String str2, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                str = aliasedColorIsAlias.alias;
            }
            if ((i3 & 2) != 0) {
                str2 = aliasedColorIsAlias.aliasedValue;
            }
            return aliasedColorIsAlias.m1119copytjeIzsg(str, str2);
        }

        /* JADX INFO: renamed from: component1-671NwFM, reason: not valid java name */
        public final String m1117component1671NwFM() {
            return this.alias;
        }

        /* JADX INFO: renamed from: component2-671NwFM, reason: not valid java name */
        public final String m1118component2671NwFM() {
            return this.aliasedValue;
        }

        /* JADX INFO: renamed from: copy-tjeIzsg, reason: not valid java name */
        public final AliasedColorIsAlias m1119copytjeIzsg(String alias, String aliasedValue) {
            Intrinsics.checkNotNullParameter(alias, "alias");
            Intrinsics.checkNotNullParameter(aliasedValue, "aliasedValue");
            return new AliasedColorIsAlias(alias, aliasedValue, null);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof AliasedColorIsAlias)) {
                return false;
            }
            AliasedColorIsAlias aliasedColorIsAlias = (AliasedColorIsAlias) obj;
            return ColorAlias.m417equalsimpl0(this.alias, aliasedColorIsAlias.alias) && ColorAlias.m417equalsimpl0(this.aliasedValue, aliasedColorIsAlias.aliasedValue);
        }

        /* JADX INFO: renamed from: getAlias-671NwFM, reason: not valid java name */
        public final String m1120getAlias671NwFM() {
            return this.alias;
        }

        /* JADX INFO: renamed from: getAliasedValue-671NwFM, reason: not valid java name */
        public final String m1121getAliasedValue671NwFM() {
            return this.aliasedValue;
        }

        @Override // java.lang.Throwable
        public String getMessage() {
            return this.message;
        }

        public int hashCode() {
            return (ColorAlias.m418hashCodeimpl(this.alias) * 31) + ColorAlias.m418hashCodeimpl(this.aliasedValue);
        }

        @Override // java.lang.Throwable
        public String toString() {
            return "AliasedColorIsAlias(alias=" + ((Object) ColorAlias.m419toStringimpl(this.alias)) + ", aliasedValue=" + ((Object) ColorAlias.m419toStringimpl(this.aliasedValue)) + ')';
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        private AliasedColorIsAlias(String alias, String aliasedValue) {
            super(null);
            Intrinsics.checkNotNullParameter(alias, "alias");
            Intrinsics.checkNotNullParameter(aliasedValue, "aliasedValue");
            this.alias = alias;
            this.aliasedValue = aliasedValue;
            String str = String.format(PaywallValidationErrorStrings.ALIASED_COLOR_IS_ALIAS, Arrays.copyOf(new Object[]{alias, aliasedValue}, 2));
            Intrinsics.checkNotNullExpressionValue(str, "format(...)");
            this.message = str;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class AllLocalizationsMissing extends PaywallValidationError {
        public static final int $stable = 0;
        private final String locale;
        private final String message;

        public /* synthetic */ AllLocalizationsMissing(String str, DefaultConstructorMarker defaultConstructorMarker) {
            this(str);
        }

        /* JADX INFO: renamed from: copy-_KYeFs0$default, reason: not valid java name */
        public static /* synthetic */ AllLocalizationsMissing m1122copy_KYeFs0$default(AllLocalizationsMissing allLocalizationsMissing, String str, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                str = allLocalizationsMissing.locale;
            }
            return allLocalizationsMissing.m1124copy_KYeFs0(str);
        }

        /* JADX INFO: renamed from: component1-uqtKvyA, reason: not valid java name */
        public final String m1123component1uqtKvyA() {
            return this.locale;
        }

        /* JADX INFO: renamed from: copy-_KYeFs0, reason: not valid java name */
        public final AllLocalizationsMissing m1124copy_KYeFs0(String locale) {
            Intrinsics.checkNotNullParameter(locale, "locale");
            return new AllLocalizationsMissing(locale, null);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof AllLocalizationsMissing) && LocaleId.m615equalsimpl0(this.locale, ((AllLocalizationsMissing) obj).locale);
        }

        /* JADX INFO: renamed from: getLocale-uqtKvyA, reason: not valid java name */
        public final String m1125getLocaleuqtKvyA() {
            return this.locale;
        }

        @Override // java.lang.Throwable
        public String getMessage() {
            return this.message;
        }

        public int hashCode() {
            return LocaleId.m616hashCodeimpl(this.locale);
        }

        @Override // java.lang.Throwable
        public String toString() {
            return "AllLocalizationsMissing(locale=" + ((Object) LocaleId.m617toStringimpl(this.locale)) + ')';
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        private AllLocalizationsMissing(String locale) {
            super(null);
            Intrinsics.checkNotNullParameter(locale, "locale");
            this.locale = locale;
            String str = String.format(PaywallValidationErrorStrings.ALL_LOCALIZATIONS_MISSING_FOR_LOCALE, Arrays.copyOf(new Object[]{locale}, 1));
            Intrinsics.checkNotNullExpressionValue(str, "format(...)");
            this.message = str;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class AllVariableLocalizationsMissing extends PaywallValidationError {
        public static final int $stable = 0;
        private final String locale;
        private final String message;

        public /* synthetic */ AllVariableLocalizationsMissing(String str, DefaultConstructorMarker defaultConstructorMarker) {
            this(str);
        }

        /* JADX INFO: renamed from: copy-_KYeFs0$default, reason: not valid java name */
        public static /* synthetic */ AllVariableLocalizationsMissing m1126copy_KYeFs0$default(AllVariableLocalizationsMissing allVariableLocalizationsMissing, String str, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                str = allVariableLocalizationsMissing.locale;
            }
            return allVariableLocalizationsMissing.m1128copy_KYeFs0(str);
        }

        /* JADX INFO: renamed from: component1-uqtKvyA, reason: not valid java name */
        public final String m1127component1uqtKvyA() {
            return this.locale;
        }

        /* JADX INFO: renamed from: copy-_KYeFs0, reason: not valid java name */
        public final AllVariableLocalizationsMissing m1128copy_KYeFs0(String locale) {
            Intrinsics.checkNotNullParameter(locale, "locale");
            return new AllVariableLocalizationsMissing(locale, null);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof AllVariableLocalizationsMissing) && LocaleId.m615equalsimpl0(this.locale, ((AllVariableLocalizationsMissing) obj).locale);
        }

        /* JADX INFO: renamed from: getLocale-uqtKvyA, reason: not valid java name */
        public final String m1129getLocaleuqtKvyA() {
            return this.locale;
        }

        @Override // java.lang.Throwable
        public String getMessage() {
            return this.message;
        }

        public int hashCode() {
            return LocaleId.m616hashCodeimpl(this.locale);
        }

        @Override // java.lang.Throwable
        public String toString() {
            return "AllVariableLocalizationsMissing(locale=" + ((Object) LocaleId.m617toStringimpl(this.locale)) + ')';
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        private AllVariableLocalizationsMissing(String locale) {
            super(null);
            Intrinsics.checkNotNullParameter(locale, "locale");
            this.locale = locale;
            String str = String.format(PaywallValidationErrorStrings.ALL_VARIABLE_LOCALIZATIONS_MISSING_FOR_LOCALE, Arrays.copyOf(new Object[]{locale}, 1));
            Intrinsics.checkNotNullExpressionValue(str, "format(...)");
            this.message = str;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class InvalidIcons extends PaywallValidationError {
        public static final int $stable = 8;
        private final Set<String> invalidIcons;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public InvalidIcons(Set<String> invalidIcons) {
            super(null);
            Intrinsics.checkNotNullParameter(invalidIcons, "invalidIcons");
            this.invalidIcons = invalidIcons;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ InvalidIcons copy$default(InvalidIcons invalidIcons, Set set, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                set = invalidIcons.invalidIcons;
            }
            return invalidIcons.copy(set);
        }

        public final Set<String> component1() {
            return this.invalidIcons;
        }

        public final InvalidIcons copy(Set<String> invalidIcons) {
            Intrinsics.checkNotNullParameter(invalidIcons, "invalidIcons");
            return new InvalidIcons(invalidIcons);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof InvalidIcons) && Intrinsics.areEqual(this.invalidIcons, ((InvalidIcons) obj).invalidIcons);
        }

        public final Set<String> getInvalidIcons() {
            return this.invalidIcons;
        }

        public int hashCode() {
            return this.invalidIcons.hashCode();
        }

        @Override // java.lang.Throwable
        public String toString() {
            return "InvalidIcons(invalidIcons=" + this.invalidIcons + ')';
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class InvalidModeForComponentsPaywall extends PaywallValidationError {
        public static final int $stable = 0;
        public static final InvalidModeForComponentsPaywall INSTANCE = new InvalidModeForComponentsPaywall();

        private InvalidModeForComponentsPaywall() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class InvalidTemplate extends PaywallValidationError {
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

        @Override // java.lang.Throwable
        public String toString() {
            return "InvalidTemplate(templateName=" + this.templateName + ')';
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class InvalidVariables extends PaywallValidationError {
        public static final int $stable = 8;
        private final Set<String> unrecognizedVariables;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public InvalidVariables(Set<String> unrecognizedVariables) {
            super(null);
            Intrinsics.checkNotNullParameter(unrecognizedVariables, "unrecognizedVariables");
            this.unrecognizedVariables = unrecognizedVariables;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ InvalidVariables copy$default(InvalidVariables invalidVariables, Set set, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                set = invalidVariables.unrecognizedVariables;
            }
            return invalidVariables.copy(set);
        }

        public final Set<String> component1() {
            return this.unrecognizedVariables;
        }

        public final InvalidVariables copy(Set<String> unrecognizedVariables) {
            Intrinsics.checkNotNullParameter(unrecognizedVariables, "unrecognizedVariables");
            return new InvalidVariables(unrecognizedVariables);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof InvalidVariables) && Intrinsics.areEqual(this.unrecognizedVariables, ((InvalidVariables) obj).unrecognizedVariables);
        }

        public final Set<String> getUnrecognizedVariables() {
            return this.unrecognizedVariables;
        }

        public int hashCode() {
            return this.unrecognizedVariables.hashCode();
        }

        @Override // java.lang.Throwable
        public String toString() {
            return "InvalidVariables(unrecognizedVariables=" + this.unrecognizedVariables + ')';
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class MissingColorAlias extends PaywallValidationError {
        public static final int $stable = 0;
        private final String alias;
        private final String message;

        public /* synthetic */ MissingColorAlias(String str, DefaultConstructorMarker defaultConstructorMarker) {
            this(str);
        }

        /* JADX INFO: renamed from: copy-iZ0V_xs$default, reason: not valid java name */
        public static /* synthetic */ MissingColorAlias m1130copyiZ0V_xs$default(MissingColorAlias missingColorAlias, String str, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                str = missingColorAlias.alias;
            }
            return missingColorAlias.m1132copyiZ0V_xs(str);
        }

        /* JADX INFO: renamed from: component1-671NwFM, reason: not valid java name */
        public final String m1131component1671NwFM() {
            return this.alias;
        }

        /* JADX INFO: renamed from: copy-iZ0V_xs, reason: not valid java name */
        public final MissingColorAlias m1132copyiZ0V_xs(String alias) {
            Intrinsics.checkNotNullParameter(alias, "alias");
            return new MissingColorAlias(alias, null);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof MissingColorAlias) && ColorAlias.m417equalsimpl0(this.alias, ((MissingColorAlias) obj).alias);
        }

        /* JADX INFO: renamed from: getAlias-671NwFM, reason: not valid java name */
        public final String m1133getAlias671NwFM() {
            return this.alias;
        }

        @Override // java.lang.Throwable
        public String getMessage() {
            return this.message;
        }

        public int hashCode() {
            return ColorAlias.m418hashCodeimpl(this.alias);
        }

        @Override // java.lang.Throwable
        public String toString() {
            return "MissingColorAlias(alias=" + ((Object) ColorAlias.m419toStringimpl(this.alias)) + ')';
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        private MissingColorAlias(String alias) {
            super(null);
            Intrinsics.checkNotNullParameter(alias, "alias");
            this.alias = alias;
            String str = String.format(PaywallValidationErrorStrings.MISSING_COLOR_ALIAS, Arrays.copyOf(new Object[]{alias}, 1));
            Intrinsics.checkNotNullExpressionValue(str, "format(...)");
            this.message = str;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class MissingFontAlias extends PaywallValidationError {
        public static final int $stable = 0;
        private final String alias;
        private final String message;

        public /* synthetic */ MissingFontAlias(String str, DefaultConstructorMarker defaultConstructorMarker) {
            this(str);
        }

        /* JADX INFO: renamed from: copy-Qd9eHpM$default, reason: not valid java name */
        public static /* synthetic */ MissingFontAlias m1134copyQd9eHpM$default(MissingFontAlias missingFontAlias, String str, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                str = missingFontAlias.alias;
            }
            return missingFontAlias.m1136copyQd9eHpM(str);
        }

        /* JADX INFO: renamed from: component1-BejUyPs, reason: not valid java name */
        public final String m1135component1BejUyPs() {
            return this.alias;
        }

        /* JADX INFO: renamed from: copy-Qd9eHpM, reason: not valid java name */
        public final MissingFontAlias m1136copyQd9eHpM(String alias) {
            Intrinsics.checkNotNullParameter(alias, "alias");
            return new MissingFontAlias(alias, null);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof MissingFontAlias) && FontAlias.m436equalsimpl0(this.alias, ((MissingFontAlias) obj).alias);
        }

        /* JADX INFO: renamed from: getAlias-BejUyPs, reason: not valid java name */
        public final String m1137getAliasBejUyPs() {
            return this.alias;
        }

        @Override // java.lang.Throwable
        public String getMessage() {
            return this.message;
        }

        public int hashCode() {
            return FontAlias.m437hashCodeimpl(this.alias);
        }

        @Override // java.lang.Throwable
        public String toString() {
            return "MissingFontAlias(alias=" + ((Object) FontAlias.m438toStringimpl(this.alias)) + ')';
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        private MissingFontAlias(String alias) {
            super(null);
            Intrinsics.checkNotNullParameter(alias, "alias");
            this.alias = alias;
            String str = String.format(QgXempTBEfV.oHAwTUrnpyF, Arrays.copyOf(new Object[]{alias}, 1));
            Intrinsics.checkNotNullExpressionValue(str, "format(...)");
            this.message = str;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class MissingImageLocalization extends PaywallValidationError {
        public static final int $stable = 0;
        private final String key;
        private final String locale;
        private final String message;

        public /* synthetic */ MissingImageLocalization(String str, String str2, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, str2);
        }

        /* JADX INFO: renamed from: copy-bzYoJhk$default, reason: not valid java name */
        public static /* synthetic */ MissingImageLocalization m1138copybzYoJhk$default(MissingImageLocalization missingImageLocalization, String str, String str2, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                str = missingImageLocalization.key;
            }
            if ((i3 & 2) != 0) {
                str2 = missingImageLocalization.locale;
            }
            return missingImageLocalization.m1141copybzYoJhk(str, str2);
        }

        /* JADX INFO: renamed from: component1-z7Tp-4o, reason: not valid java name */
        public final String m1139component1z7Tp4o() {
            return this.key;
        }

        /* JADX INFO: renamed from: component2-DxqohGs, reason: not valid java name */
        public final String m1140component2DxqohGs() {
            return this.locale;
        }

        /* JADX INFO: renamed from: copy-bzYoJhk, reason: not valid java name */
        public final MissingImageLocalization m1141copybzYoJhk(String key, String str) {
            Intrinsics.checkNotNullParameter(key, "key");
            return new MissingImageLocalization(key, str, null);
        }

        /* JADX WARN: Removed duplicated region for block: B:15:0x0021  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public boolean equals(java.lang.Object r5) {
            /*
                r4 = this;
                r0 = 1
                if (r4 != r5) goto L4
                return r0
            L4:
                boolean r1 = r5 instanceof com.revenuecat.purchases.ui.revenuecatui.errors.PaywallValidationError.MissingImageLocalization
                r2 = 0
                if (r1 != 0) goto La
                return r2
            La:
                com.revenuecat.purchases.ui.revenuecatui.errors.PaywallValidationError$MissingImageLocalization r5 = (com.revenuecat.purchases.ui.revenuecatui.errors.PaywallValidationError.MissingImageLocalization) r5
                java.lang.String r1 = r4.key
                java.lang.String r3 = r5.key
                boolean r1 = com.revenuecat.purchases.paywalls.components.common.LocalizationKey.m651equalsimpl0(r1, r3)
                if (r1 != 0) goto L17
                return r2
            L17:
                java.lang.String r1 = r4.locale
                java.lang.String r5 = r5.locale
                if (r1 != 0) goto L23
                if (r5 != 0) goto L21
                r5 = r0
                goto L2a
            L21:
                r5 = r2
                goto L2a
            L23:
                if (r5 != 0) goto L26
                goto L21
            L26:
                boolean r5 = com.revenuecat.purchases.paywalls.components.common.LocaleId.m615equalsimpl0(r1, r5)
            L2a:
                if (r5 != 0) goto L2d
                return r2
            L2d:
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.revenuecat.purchases.ui.revenuecatui.errors.PaywallValidationError.MissingImageLocalization.equals(java.lang.Object):boolean");
        }

        /* JADX INFO: renamed from: getKey-z7Tp-4o, reason: not valid java name */
        public final String m1142getKeyz7Tp4o() {
            return this.key;
        }

        /* JADX INFO: renamed from: getLocale-DxqohGs, reason: not valid java name */
        public final String m1143getLocaleDxqohGs() {
            return this.locale;
        }

        @Override // java.lang.Throwable
        public String getMessage() {
            return this.message;
        }

        public int hashCode() {
            int iM652hashCodeimpl = LocalizationKey.m652hashCodeimpl(this.key) * 31;
            String str = this.locale;
            return iM652hashCodeimpl + (str == null ? 0 : LocaleId.m616hashCodeimpl(str));
        }

        @Override // java.lang.Throwable
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("MissingImageLocalization(key=");
            sb.append((Object) LocalizationKey.m653toStringimpl(this.key));
            sb.append(", locale=");
            String str = this.locale;
            sb.append((Object) (str == null ? "null" : LocaleId.m617toStringimpl(str)));
            sb.append(')');
            return sb.toString();
        }

        public /* synthetic */ MissingImageLocalization(String str, String str2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, (i3 & 2) != 0 ? null : str2, null);
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        private MissingImageLocalization(String key, String str) {
            String str2;
            super(null);
            Intrinsics.checkNotNullParameter(key, "key");
            this.key = key;
            this.locale = str;
            if (str != null) {
                str2 = String.format(PaywallValidationErrorStrings.MISSING_IMAGE_LOCALIZATION_WITH_LOCALE, Arrays.copyOf(new Object[]{key, str}, 2));
                Intrinsics.checkNotNullExpressionValue(str2, "format(...)");
            } else {
                str2 = String.format(PaywallValidationErrorStrings.MISSING_IMAGE_LOCALIZATION, Arrays.copyOf(new Object[]{key}, 1));
                Intrinsics.checkNotNullExpressionValue(str2, "format(...)");
            }
            this.message = str2;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class MissingPackage extends PaywallValidationError {
        public static final int $stable = 8;
        private final Collection<String> allPackageIds;
        private final String message;
        private final String missingPackageId;
        private final String offeringId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public MissingPackage(String offeringId, String missingPackageId, Collection<String> allPackageIds) {
            super(null);
            Intrinsics.checkNotNullParameter(offeringId, "offeringId");
            Intrinsics.checkNotNullParameter(missingPackageId, "missingPackageId");
            Intrinsics.checkNotNullParameter(allPackageIds, "allPackageIds");
            this.offeringId = offeringId;
            this.missingPackageId = missingPackageId;
            this.allPackageIds = allPackageIds;
            String str = String.format(PaywallValidationErrorStrings.MISSING_PACKAGE, Arrays.copyOf(new Object[]{missingPackageId, offeringId, CollectionsKt.joinToString$default(allPackageIds, null, null, null, 0, null, null, 63, null)}, 3));
            Intrinsics.checkNotNullExpressionValue(str, "format(...)");
            this.message = str;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ MissingPackage copy$default(MissingPackage missingPackage, String str, String str2, Collection collection, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                str = missingPackage.offeringId;
            }
            if ((i3 & 2) != 0) {
                str2 = missingPackage.missingPackageId;
            }
            if ((i3 & 4) != 0) {
                collection = missingPackage.allPackageIds;
            }
            return missingPackage.copy(str, str2, collection);
        }

        public final String component1() {
            return this.offeringId;
        }

        public final String component2() {
            return this.missingPackageId;
        }

        public final Collection<String> component3() {
            return this.allPackageIds;
        }

        public final MissingPackage copy(String offeringId, String missingPackageId, Collection<String> allPackageIds) {
            Intrinsics.checkNotNullParameter(offeringId, "offeringId");
            Intrinsics.checkNotNullParameter(missingPackageId, "missingPackageId");
            Intrinsics.checkNotNullParameter(allPackageIds, "allPackageIds");
            return new MissingPackage(offeringId, missingPackageId, allPackageIds);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof MissingPackage)) {
                return false;
            }
            MissingPackage missingPackage = (MissingPackage) obj;
            return Intrinsics.areEqual(this.offeringId, missingPackage.offeringId) && Intrinsics.areEqual(this.missingPackageId, missingPackage.missingPackageId) && Intrinsics.areEqual(this.allPackageIds, missingPackage.allPackageIds);
        }

        public final Collection<String> getAllPackageIds() {
            return this.allPackageIds;
        }

        @Override // java.lang.Throwable
        public String getMessage() {
            return this.message;
        }

        public final String getMissingPackageId() {
            return this.missingPackageId;
        }

        public final String getOfferingId() {
            return this.offeringId;
        }

        public int hashCode() {
            return (((this.offeringId.hashCode() * 31) + this.missingPackageId.hashCode()) * 31) + this.allPackageIds.hashCode();
        }

        @Override // java.lang.Throwable
        public String toString() {
            return "MissingPackage(offeringId=" + this.offeringId + ", missingPackageId=" + this.missingPackageId + ", allPackageIds=" + this.allPackageIds + ')';
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class MissingPaywall extends PaywallValidationError {
        public static final int $stable = 0;
        public static final MissingPaywall INSTANCE = new MissingPaywall();

        private MissingPaywall() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class MissingStringLocalization extends PaywallValidationError {
        public static final int $stable = 0;
        private final String key;
        private final String locale;
        private final String message;

        public /* synthetic */ MissingStringLocalization(String str, String str2, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, str2);
        }

        /* JADX INFO: renamed from: copy-bzYoJhk$default, reason: not valid java name */
        public static /* synthetic */ MissingStringLocalization m1144copybzYoJhk$default(MissingStringLocalization missingStringLocalization, String str, String str2, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                str = missingStringLocalization.key;
            }
            if ((i3 & 2) != 0) {
                str2 = missingStringLocalization.locale;
            }
            return missingStringLocalization.m1147copybzYoJhk(str, str2);
        }

        /* JADX INFO: renamed from: component1-z7Tp-4o, reason: not valid java name */
        public final String m1145component1z7Tp4o() {
            return this.key;
        }

        /* JADX INFO: renamed from: component2-DxqohGs, reason: not valid java name */
        public final String m1146component2DxqohGs() {
            return this.locale;
        }

        /* JADX INFO: renamed from: copy-bzYoJhk, reason: not valid java name */
        public final MissingStringLocalization m1147copybzYoJhk(String key, String str) {
            Intrinsics.checkNotNullParameter(key, "key");
            return new MissingStringLocalization(key, str, null);
        }

        /* JADX WARN: Removed duplicated region for block: B:15:0x0021  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public boolean equals(java.lang.Object r5) {
            /*
                r4 = this;
                r0 = 1
                if (r4 != r5) goto L4
                return r0
            L4:
                boolean r1 = r5 instanceof com.revenuecat.purchases.ui.revenuecatui.errors.PaywallValidationError.MissingStringLocalization
                r2 = 0
                if (r1 != 0) goto La
                return r2
            La:
                com.revenuecat.purchases.ui.revenuecatui.errors.PaywallValidationError$MissingStringLocalization r5 = (com.revenuecat.purchases.ui.revenuecatui.errors.PaywallValidationError.MissingStringLocalization) r5
                java.lang.String r1 = r4.key
                java.lang.String r3 = r5.key
                boolean r1 = com.revenuecat.purchases.paywalls.components.common.LocalizationKey.m651equalsimpl0(r1, r3)
                if (r1 != 0) goto L17
                return r2
            L17:
                java.lang.String r1 = r4.locale
                java.lang.String r5 = r5.locale
                if (r1 != 0) goto L23
                if (r5 != 0) goto L21
                r5 = r0
                goto L2a
            L21:
                r5 = r2
                goto L2a
            L23:
                if (r5 != 0) goto L26
                goto L21
            L26:
                boolean r5 = com.revenuecat.purchases.paywalls.components.common.LocaleId.m615equalsimpl0(r1, r5)
            L2a:
                if (r5 != 0) goto L2d
                return r2
            L2d:
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.revenuecat.purchases.ui.revenuecatui.errors.PaywallValidationError.MissingStringLocalization.equals(java.lang.Object):boolean");
        }

        /* JADX INFO: renamed from: getKey-z7Tp-4o, reason: not valid java name */
        public final String m1148getKeyz7Tp4o() {
            return this.key;
        }

        /* JADX INFO: renamed from: getLocale-DxqohGs, reason: not valid java name */
        public final String m1149getLocaleDxqohGs() {
            return this.locale;
        }

        @Override // java.lang.Throwable
        public String getMessage() {
            return this.message;
        }

        public int hashCode() {
            int iM652hashCodeimpl = LocalizationKey.m652hashCodeimpl(this.key) * 31;
            String str = this.locale;
            return iM652hashCodeimpl + (str == null ? 0 : LocaleId.m616hashCodeimpl(str));
        }

        @Override // java.lang.Throwable
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("MissingStringLocalization(key=");
            sb.append((Object) LocalizationKey.m653toStringimpl(this.key));
            sb.append(", locale=");
            String str = this.locale;
            sb.append((Object) (str == null ? "null" : LocaleId.m617toStringimpl(str)));
            sb.append(')');
            return sb.toString();
        }

        public /* synthetic */ MissingStringLocalization(String str, String str2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, (i3 & 2) != 0 ? null : str2, null);
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        private MissingStringLocalization(String key, String str) {
            String str2;
            super(null);
            Intrinsics.checkNotNullParameter(key, "key");
            this.key = key;
            this.locale = str;
            if (str != null) {
                str2 = String.format(PaywallValidationErrorStrings.MISSING_STRING_LOCALIZATION_WITH_LOCALE, Arrays.copyOf(new Object[]{key, str}, 2));
                Intrinsics.checkNotNullExpressionValue(str2, "format(...)");
            } else {
                str2 = String.format(PaywallValidationErrorStrings.MISSING_STRING_LOCALIZATION, Arrays.copyOf(new Object[]{key}, 1));
                Intrinsics.checkNotNullExpressionValue(str2, "format(...)");
            }
            this.message = str2;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class MissingTierConfigurations extends PaywallValidationError {
        public static final int $stable = 8;
        private final Set<String> tierIds;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public MissingTierConfigurations(Set<String> tierIds) {
            super(null);
            Intrinsics.checkNotNullParameter(tierIds, "tierIds");
            this.tierIds = tierIds;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ MissingTierConfigurations copy$default(MissingTierConfigurations missingTierConfigurations, Set set, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                set = missingTierConfigurations.tierIds;
            }
            return missingTierConfigurations.copy(set);
        }

        public final Set<String> component1() {
            return this.tierIds;
        }

        public final MissingTierConfigurations copy(Set<String> tierIds) {
            Intrinsics.checkNotNullParameter(tierIds, "tierIds");
            return new MissingTierConfigurations(tierIds);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof MissingTierConfigurations) && Intrinsics.areEqual(this.tierIds, ((MissingTierConfigurations) obj).tierIds);
        }

        public final Set<String> getTierIds() {
            return this.tierIds;
        }

        public int hashCode() {
            return this.tierIds.hashCode();
        }

        @Override // java.lang.Throwable
        public String toString() {
            return "MissingTierConfigurations(tierIds=" + this.tierIds + ')';
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class MissingTiers extends PaywallValidationError {
        public static final int $stable = 0;
        public static final MissingTiers INSTANCE = new MissingTiers();

        private MissingTiers() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class MissingVideoLocalization extends PaywallValidationError {
        public static final int $stable = 0;
        private final String key;
        private final String locale;
        private final String message;

        public /* synthetic */ MissingVideoLocalization(String str, String str2, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, str2);
        }

        /* JADX INFO: renamed from: copy-bzYoJhk$default, reason: not valid java name */
        public static /* synthetic */ MissingVideoLocalization m1150copybzYoJhk$default(MissingVideoLocalization missingVideoLocalization, String str, String str2, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                str = missingVideoLocalization.key;
            }
            if ((i3 & 2) != 0) {
                str2 = missingVideoLocalization.locale;
            }
            return missingVideoLocalization.m1153copybzYoJhk(str, str2);
        }

        /* JADX INFO: renamed from: component1-z7Tp-4o, reason: not valid java name */
        public final String m1151component1z7Tp4o() {
            return this.key;
        }

        /* JADX INFO: renamed from: component2-DxqohGs, reason: not valid java name */
        public final String m1152component2DxqohGs() {
            return this.locale;
        }

        /* JADX INFO: renamed from: copy-bzYoJhk, reason: not valid java name */
        public final MissingVideoLocalization m1153copybzYoJhk(String key, String str) {
            Intrinsics.checkNotNullParameter(key, "key");
            return new MissingVideoLocalization(key, str, null);
        }

        /* JADX WARN: Removed duplicated region for block: B:15:0x0021  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public boolean equals(java.lang.Object r5) {
            /*
                r4 = this;
                r0 = 1
                if (r4 != r5) goto L4
                return r0
            L4:
                boolean r1 = r5 instanceof com.revenuecat.purchases.ui.revenuecatui.errors.PaywallValidationError.MissingVideoLocalization
                r2 = 0
                if (r1 != 0) goto La
                return r2
            La:
                com.revenuecat.purchases.ui.revenuecatui.errors.PaywallValidationError$MissingVideoLocalization r5 = (com.revenuecat.purchases.ui.revenuecatui.errors.PaywallValidationError.MissingVideoLocalization) r5
                java.lang.String r1 = r4.key
                java.lang.String r3 = r5.key
                boolean r1 = com.revenuecat.purchases.paywalls.components.common.LocalizationKey.m651equalsimpl0(r1, r3)
                if (r1 != 0) goto L17
                return r2
            L17:
                java.lang.String r1 = r4.locale
                java.lang.String r5 = r5.locale
                if (r1 != 0) goto L23
                if (r5 != 0) goto L21
                r5 = r0
                goto L2a
            L21:
                r5 = r2
                goto L2a
            L23:
                if (r5 != 0) goto L26
                goto L21
            L26:
                boolean r5 = com.revenuecat.purchases.paywalls.components.common.LocaleId.m615equalsimpl0(r1, r5)
            L2a:
                if (r5 != 0) goto L2d
                return r2
            L2d:
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.revenuecat.purchases.ui.revenuecatui.errors.PaywallValidationError.MissingVideoLocalization.equals(java.lang.Object):boolean");
        }

        /* JADX INFO: renamed from: getKey-z7Tp-4o, reason: not valid java name */
        public final String m1154getKeyz7Tp4o() {
            return this.key;
        }

        /* JADX INFO: renamed from: getLocale-DxqohGs, reason: not valid java name */
        public final String m1155getLocaleDxqohGs() {
            return this.locale;
        }

        @Override // java.lang.Throwable
        public String getMessage() {
            return this.message;
        }

        public int hashCode() {
            int iM652hashCodeimpl = LocalizationKey.m652hashCodeimpl(this.key) * 31;
            String str = this.locale;
            return iM652hashCodeimpl + (str == null ? 0 : LocaleId.m616hashCodeimpl(str));
        }

        @Override // java.lang.Throwable
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("MissingVideoLocalization(key=");
            sb.append((Object) LocalizationKey.m653toStringimpl(this.key));
            sb.append(", locale=");
            String str = this.locale;
            sb.append((Object) (str == null ? "null" : LocaleId.m617toStringimpl(str)));
            sb.append(')');
            return sb.toString();
        }

        public /* synthetic */ MissingVideoLocalization(String str, String str2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, (i3 & 2) != 0 ? null : str2, null);
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        private MissingVideoLocalization(String key, String str) {
            String str2;
            super(null);
            Intrinsics.checkNotNullParameter(key, "key");
            this.key = key;
            this.locale = str;
            if (str != null) {
                str2 = String.format(PaywallValidationErrorStrings.MISSING_VIDEO_LOCALIZATION_WITH_LOCALE, Arrays.copyOf(new Object[]{key, str}, 2));
                Intrinsics.checkNotNullExpressionValue(str2, "format(...)");
            } else {
                str2 = String.format(PaywallValidationErrorStrings.MISSING_VIDEO_LOCALIZATION, Arrays.copyOf(new Object[]{key}, 1));
                Intrinsics.checkNotNullExpressionValue(str2, "format(...)");
            }
            this.message = str2;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class RootComponentUnsupportedProperties extends PaywallValidationError {
        public static final int $stable = 8;
        private final PaywallComponent component;
        private final String message;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public RootComponentUnsupportedProperties(PaywallComponent component) {
            super(null);
            Intrinsics.checkNotNullParameter(component, "component");
            this.component = component;
            String str = String.format(PaywallValidationErrorStrings.ROOT_COMPONENT_UNSUPPORTED_PROPERTIES, Arrays.copyOf(new Object[]{component.getClass().getSimpleName()}, 1));
            Intrinsics.checkNotNullExpressionValue(str, "format(...)");
            this.message = str;
        }

        public static /* synthetic */ RootComponentUnsupportedProperties copy$default(RootComponentUnsupportedProperties rootComponentUnsupportedProperties, PaywallComponent paywallComponent, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                paywallComponent = rootComponentUnsupportedProperties.component;
            }
            return rootComponentUnsupportedProperties.copy(paywallComponent);
        }

        public final PaywallComponent component1() {
            return this.component;
        }

        public final RootComponentUnsupportedProperties copy(PaywallComponent component) {
            Intrinsics.checkNotNullParameter(component, "component");
            return new RootComponentUnsupportedProperties(component);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof RootComponentUnsupportedProperties) && Intrinsics.areEqual(this.component, ((RootComponentUnsupportedProperties) obj).component);
        }

        public final PaywallComponent getComponent() {
            return this.component;
        }

        @Override // java.lang.Throwable
        public String getMessage() {
            return this.message;
        }

        public int hashCode() {
            return this.component.hashCode();
        }

        @Override // java.lang.Throwable
        public String toString() {
            return "RootComponentUnsupportedProperties(component=" + this.component + ')';
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class TabControlNotInTab extends PaywallValidationError {
        public static final int $stable = 0;
        public static final TabControlNotInTab INSTANCE = new TabControlNotInTab();
        private static final String message = PaywallValidationErrorStrings.TAB_CONTROL_NOT_IN_TAB;

        private TabControlNotInTab() {
            super(null);
        }

        @Override // java.lang.Throwable
        public String getMessage() {
            return message;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class TabsComponentWithoutTabs extends PaywallValidationError {
        public static final int $stable = 0;
        public static final TabsComponentWithoutTabs INSTANCE = new TabsComponentWithoutTabs();
        private static final String message = PaywallValidationErrorStrings.TABS_COMPONENT_WITHOUT_TABS;

        private TabsComponentWithoutTabs() {
            super(null);
        }

        @Override // java.lang.Throwable
        public String getMessage() {
            return message;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class UnsupportedBackgroundType extends PaywallValidationError {
        public static final int $stable = 8;
        private final Background.Unknown background;
        private final String message;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public UnsupportedBackgroundType(Background.Unknown background) {
            super(null);
            Intrinsics.checkNotNullParameter(background, "background");
            this.background = background;
            String str = String.format(PaywallValidationErrorStrings.UNSUPPORTED_BACKGROUND_TYPE, Arrays.copyOf(new Object[]{background.getType()}, 1));
            Intrinsics.checkNotNullExpressionValue(str, "format(...)");
            this.message = str;
        }

        public static /* synthetic */ UnsupportedBackgroundType copy$default(UnsupportedBackgroundType unsupportedBackgroundType, Background.Unknown unknown, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                unknown = unsupportedBackgroundType.background;
            }
            return unsupportedBackgroundType.copy(unknown);
        }

        public final Background.Unknown component1() {
            return this.background;
        }

        public final UnsupportedBackgroundType copy(Background.Unknown background) {
            Intrinsics.checkNotNullParameter(background, "background");
            return new UnsupportedBackgroundType(background);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof UnsupportedBackgroundType) && Intrinsics.areEqual(this.background, ((UnsupportedBackgroundType) obj).background);
        }

        public final Background.Unknown getBackground() {
            return this.background;
        }

        @Override // java.lang.Throwable
        public String getMessage() {
            return this.message;
        }

        public int hashCode() {
            return this.background.hashCode();
        }

        @Override // java.lang.Throwable
        public String toString() {
            return "UnsupportedBackgroundType(background=" + this.background + ')';
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class WorkflowButtonMissingComponentId extends PaywallValidationError {
        public static final int $stable = 0;
        private final String componentName;
        private final String message;

        public WorkflowButtonMissingComponentId(String str) {
            super(null);
            this.componentName = str;
            String str2 = String.format(PaywallValidationErrorStrings.WORKFLOW_BUTTON_MISSING_COMPONENT_ID, Arrays.copyOf(new Object[]{str == null ? "<unnamed>" : str}, 1));
            Intrinsics.checkNotNullExpressionValue(str2, "format(...)");
            this.message = str2;
        }

        public static /* synthetic */ WorkflowButtonMissingComponentId copy$default(WorkflowButtonMissingComponentId workflowButtonMissingComponentId, String str, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                str = workflowButtonMissingComponentId.componentName;
            }
            return workflowButtonMissingComponentId.copy(str);
        }

        public final String component1() {
            return this.componentName;
        }

        public final WorkflowButtonMissingComponentId copy(String str) {
            return new WorkflowButtonMissingComponentId(str);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof WorkflowButtonMissingComponentId) && Intrinsics.areEqual(this.componentName, ((WorkflowButtonMissingComponentId) obj).componentName);
        }

        public final String getComponentName() {
            return this.componentName;
        }

        @Override // java.lang.Throwable
        public String getMessage() {
            return this.message;
        }

        public int hashCode() {
            String str = this.componentName;
            if (str == null) {
                return 0;
            }
            return str.hashCode();
        }

        @Override // java.lang.Throwable
        public String toString() {
            return "WorkflowButtonMissingComponentId(componentName=" + this.componentName + ')';
        }
    }

    public /* synthetic */ PaywallValidationError(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public final String associatedErrorString(Offering offering) {
        Intrinsics.checkNotNullParameter(offering, "offering");
        if (this instanceof InvalidIcons) {
            String str = String.format(PaywallValidationErrorStrings.INVALID_ICONS, Arrays.copyOf(new Object[]{CollectionsKt.joinToString$default(((InvalidIcons) this).getInvalidIcons(), null, null, null, 0, null, null, 63, null)}, 1));
            Intrinsics.checkNotNullExpressionValue(str, "format(...)");
            return str;
        }
        if (this instanceof InvalidTemplate) {
            String str2 = String.format(PaywallValidationErrorStrings.INVALID_TEMPLATE_NAME, Arrays.copyOf(new Object[]{((InvalidTemplate) this).getTemplateName()}, 1));
            Intrinsics.checkNotNullExpressionValue(str2, "format(...)");
            return str2;
        }
        if (this instanceof InvalidVariables) {
            String str3 = String.format(PaywallValidationErrorStrings.INVALID_VARIABLES, Arrays.copyOf(new Object[]{CollectionsKt.joinToString$default(((InvalidVariables) this).getUnrecognizedVariables(), null, null, null, 0, null, null, 63, null)}, 1));
            Intrinsics.checkNotNullExpressionValue(str3, "format(...)");
            return str3;
        }
        if (this instanceof MissingPaywall) {
            String str4 = String.format(PaywallValidationErrorStrings.MISSING_PAYWALL, Arrays.copyOf(new Object[]{offering.getIdentifier()}, 1));
            Intrinsics.checkNotNullExpressionValue(str4, "format(...)");
            return str4;
        }
        if (this instanceof MissingTiers) {
            String str5 = String.format(PaywallValidationErrorStrings.MISSING_TIERS, Arrays.copyOf(new Object[]{offering.getIdentifier()}, 1));
            Intrinsics.checkNotNullExpressionValue(str5, "format(...)");
            return str5;
        }
        if (this instanceof MissingTierConfigurations) {
            String str6 = String.format(PaywallValidationErrorStrings.MISSING_TIER_CONFIGURATIONS, Arrays.copyOf(new Object[]{CollectionsKt.joinToString$default(((MissingTierConfigurations) this).getTierIds(), null, null, null, 0, null, null, 63, null)}, 1));
            Intrinsics.checkNotNullExpressionValue(str6, "format(...)");
            return str6;
        }
        if (this instanceof MissingStringLocalization) {
            return ((MissingStringLocalization) this).getMessage();
        }
        if (this instanceof MissingImageLocalization) {
            return ((MissingImageLocalization) this).getMessage();
        }
        if (this instanceof MissingVideoLocalization) {
            return ((MissingVideoLocalization) this).getMessage();
        }
        if (this instanceof AllLocalizationsMissing) {
            return ((AllLocalizationsMissing) this).getMessage();
        }
        if (this instanceof AllVariableLocalizationsMissing) {
            return ((AllVariableLocalizationsMissing) this).getMessage();
        }
        if (this instanceof MissingPackage) {
            return ((MissingPackage) this).getMessage();
        }
        if (this instanceof MissingColorAlias) {
            return ((MissingColorAlias) this).getMessage();
        }
        if (this instanceof AliasedColorIsAlias) {
            return ((AliasedColorIsAlias) this).getMessage();
        }
        if (this instanceof MissingFontAlias) {
            return ((MissingFontAlias) this).getMessage();
        }
        if (this instanceof InvalidModeForComponentsPaywall) {
            return PaywallValidationErrorStrings.INVALID_MODE_FOR_COMPONENTS_PAYWALL;
        }
        if (this instanceof TabsComponentWithoutTabs) {
            return ((TabsComponentWithoutTabs) this).getMessage();
        }
        if (this instanceof TabControlNotInTab) {
            return ((TabControlNotInTab) this).getMessage();
        }
        if (this instanceof UnsupportedBackgroundType) {
            return ((UnsupportedBackgroundType) this).getMessage();
        }
        if (this instanceof RootComponentUnsupportedProperties) {
            return ((RootComponentUnsupportedProperties) this).getMessage();
        }
        if (this instanceof WorkflowButtonMissingComponentId) {
            return ((WorkflowButtonMissingComponentId) this).getMessage();
        }
        throw new NoWhenBranchMatchedException();
    }

    private PaywallValidationError() {
    }
}
