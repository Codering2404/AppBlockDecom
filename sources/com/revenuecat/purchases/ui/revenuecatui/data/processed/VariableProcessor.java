package com.revenuecat.purchases.ui.revenuecatui.data.processed;

import com.facebook.internal.NativeProtocol;
import com.revenuecat.purchases.Package;
import com.revenuecat.purchases.ui.revenuecatui.data.processed.VariableProcessor;
import com.revenuecat.purchases.ui.revenuecatui.helpers.Logger;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.sequences.SequencesKt;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

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
public final class VariableProcessor {
    public static final VariableProcessor INSTANCE = new VariableProcessor();
    private static final Regex REGEX = new Regex("\\{\\{\\s[a-zA-Z0-9_]+\\s\\}\\}");
    public static final int $stable = 8;

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    enum VariableName {
        APP_NAME(NativeProtocol.BRIDGE_ARG_APP_NAME_STRING),
        PRICE("price"),
        PRICE_PER_PERIOD("price_per_period"),
        PRICE_PER_PERIOD_FULL("price_per_period_full"),
        TOTAL_PRICE_AND_PER_MONTH("total_price_and_per_month"),
        TOTAL_PRICE_AND_PER_MONTH_FULL("total_price_and_per_month_full"),
        PRODUCT_NAME("product_name"),
        SUB_PERIOD("sub_period"),
        SUB_PERIOD_LENGTH("sub_period_length"),
        SUB_PERIOD_ABBREVIATED("sub_period_abbreviated"),
        SUB_PRICE_PER_WEEK("sub_price_per_week"),
        SUB_PRICE_PER_MONTH("sub_price_per_month"),
        SUB_DURATION("sub_duration"),
        SUB_DURATION_IN_MONTHS("sub_duration_in_months"),
        SUB_OFFER_DURATION("sub_offer_duration"),
        SUB_OFFER_DURATION_2("sub_offer_duration_2"),
        SUB_OFFER_PRICE("sub_offer_price"),
        SUB_OFFER_PRICE_2("sub_offer_price_2"),
        SUB_RELATIVE_DISCOUNT("sub_relative_discount");

        private final String identifier;
        public static final Companion Companion = new Companion(null);
        private static final Lazy<Map<String, VariableName>> valueMap$delegate = LazyKt.b(new Function0<Map<String, ? extends VariableName>>() { // from class: com.revenuecat.purchases.ui.revenuecatui.data.processed.VariableProcessor$VariableName$Companion$valueMap$2
            @Override // kotlin.jvm.functions.Function0
            public final Map<String, VariableProcessor.VariableName> invoke() {
                VariableProcessor.VariableName[] variableNameArrValues = VariableProcessor.VariableName.values();
                LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.f(MapsKt.mapCapacity(variableNameArrValues.length), 16));
                for (VariableProcessor.VariableName variableName : variableNameArrValues) {
                    linkedHashMap.put(variableName.getIdentifier(), variableName);
                }
                return linkedHashMap;
            }
        });

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private final Map<String, VariableName> getValueMap() {
                return (Map) VariableName.valueMap$delegate.getValue();
            }

            public final VariableName valueOfIdentifier(String identifier) {
                Intrinsics.checkNotNullParameter(identifier, "identifier");
                return getValueMap().get(identifier);
            }

            private Companion() {
            }
        }

        VariableName(String str) {
            this.identifier = str;
        }

        public final String getIdentifier() {
            return this.identifier;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[VariableName.values().length];
            try {
                iArr[VariableName.APP_NAME.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[VariableName.PRICE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[VariableName.PRICE_PER_PERIOD.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[VariableName.PRICE_PER_PERIOD_FULL.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[VariableName.TOTAL_PRICE_AND_PER_MONTH.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[VariableName.TOTAL_PRICE_AND_PER_MONTH_FULL.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[VariableName.PRODUCT_NAME.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr[VariableName.SUB_PERIOD.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr[VariableName.SUB_PERIOD_LENGTH.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                iArr[VariableName.SUB_PERIOD_ABBREVIATED.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                iArr[VariableName.SUB_PRICE_PER_WEEK.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                iArr[VariableName.SUB_PRICE_PER_MONTH.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                iArr[VariableName.SUB_DURATION.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                iArr[VariableName.SUB_DURATION_IN_MONTHS.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                iArr[VariableName.SUB_OFFER_DURATION.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                iArr[VariableName.SUB_OFFER_DURATION_2.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                iArr[VariableName.SUB_OFFER_PRICE.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                iArr[VariableName.SUB_OFFER_PRICE_2.ordinal()] = 18;
            } catch (NoSuchFieldError unused18) {
            }
            try {
                iArr[VariableName.SUB_RELATIVE_DISCOUNT.ordinal()] = 19;
            } catch (NoSuchFieldError unused19) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private VariableProcessor() {
    }

    private final String handleVariablesAndReplace(String str, Function1<? super String, String> function1) {
        for (MatchResult matchResult : CollectionsKt.reversed(SequencesKt.S(Regex.g(REGEX, str, 0, 2, null)))) {
            String value = matchResult.getValue();
            String strSubstring = value.substring(2, value.length() - 2);
            Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
            String str2 = (String) function1.invoke(StringsKt.t1(strSubstring).toString());
            if (str2 != null) {
                str = StringsKt.P0(str, matchResult.c(), str2).toString();
            }
        }
        return str;
    }

    private final String processVariable(VariableName variableName, VariableDataProvider variableDataProvider, PackageContext packageContext, Package r5, Locale locale) {
        switch (WhenMappings.$EnumSwitchMapping$0[variableName.ordinal()]) {
            case 1:
                return variableDataProvider.getApplicationName();
            case 2:
                return variableDataProvider.localizedPrice(r5, locale, packageContext.getShowZeroDecimalPlacePrices());
            case 3:
                return variableDataProvider.localizedPricePerPeriod(r5, locale, packageContext.getShowZeroDecimalPlacePrices());
            case 4:
                return variableDataProvider.localizedPricePerPeriodFull(r5, locale, packageContext.getShowZeroDecimalPlacePrices());
            case 5:
                return variableDataProvider.localizedPriceAndPerMonth(r5, locale, packageContext.getShowZeroDecimalPlacePrices());
            case 6:
                return variableDataProvider.localizedPriceAndPerMonthFull(r5, locale, packageContext.getShowZeroDecimalPlacePrices());
            case 7:
                return variableDataProvider.productName(r5);
            case 8:
                return variableDataProvider.periodName(r5);
            case 9:
                return variableDataProvider.periodLength(r5, locale);
            case 10:
                return variableDataProvider.periodNameAbbreviation(r5, locale);
            case 11:
                return variableDataProvider.localizedPricePerWeek(r5, locale, packageContext.getShowZeroDecimalPlacePrices());
            case 12:
                return variableDataProvider.localizedPricePerMonth(r5, locale, packageContext.getShowZeroDecimalPlacePrices());
            case 13:
                return variableDataProvider.subscriptionDuration(r5, locale);
            case 14:
                return variableDataProvider.subscriptionDurationInMonths(r5, locale);
            case 15:
                return variableDataProvider.firstIntroductoryOfferDuration(r5, locale);
            case 16:
                return variableDataProvider.secondIntroductoryOfferDuration(r5, locale);
            case 17:
                return variableDataProvider.localizedFirstIntroductoryOfferPrice(r5, locale, packageContext.getShowZeroDecimalPlacePrices());
            case 18:
                return variableDataProvider.localizedSecondIntroductoryOfferPrice(r5, locale, packageContext.getShowZeroDecimalPlacePrices());
            case 19:
                return variableDataProvider.localizedRelativeDiscount(packageContext.getDiscountRelativeToMostExpensivePerMonth());
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String variableValue(VariableDataProvider variableDataProvider, PackageContext packageContext, String str, Package r11, Locale locale) {
        VariableName variableNameValueOfIdentifier = VariableName.Companion.valueOfIdentifier(str);
        if (variableNameValueOfIdentifier == null) {
            Logger.INSTANCE.e("Unknown variable: " + str);
            return null;
        }
        String strProcessVariable = processVariable(variableNameValueOfIdentifier, variableDataProvider, packageContext, r11, locale);
        if (strProcessVariable != null) {
            return strProcessVariable;
        }
        Logger.INSTANCE.w("Could not process value for variable '" + str + "' for package '" + r11.getIdentifier() + "'. Please check that the product for that package matches the requirements for that variable. Defaulting to empty string.");
        return "";
    }

    public final String processVariables(final VariableDataProvider variableDataProvider, final PackageContext context, String originalString, final Package rcPackage, final Locale locale) {
        Intrinsics.checkNotNullParameter(variableDataProvider, "variableDataProvider");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(originalString, "originalString");
        Intrinsics.checkNotNullParameter(rcPackage, "rcPackage");
        Intrinsics.checkNotNullParameter(locale, "locale");
        return handleVariablesAndReplace(originalString, new Function1<String, String>() { // from class: com.revenuecat.purchases.ui.revenuecatui.data.processed.VariableProcessor$processVariables$resultString$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final String invoke(String variable) {
                Intrinsics.checkNotNullParameter(variable, "variable");
                return VariableProcessor.INSTANCE.variableValue(variableDataProvider, context, variable, rcPackage, locale);
            }
        });
    }

    public final Set<String> validateVariables(String originalString) {
        Intrinsics.checkNotNullParameter(originalString, "originalString");
        final ArrayList arrayList = new ArrayList();
        handleVariablesAndReplace(originalString, new Function1<String, String>() { // from class: com.revenuecat.purchases.ui.revenuecatui.data.processed.VariableProcessor.validateVariables.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final String invoke(String variable) {
                Intrinsics.checkNotNullParameter(variable, "variable");
                if (VariableName.Companion.valueOfIdentifier(variable) != null) {
                    return null;
                }
                arrayList.add(variable);
                return null;
            }
        });
        return CollectionsKt.toSet(arrayList);
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class PackageContext {
        public static final int $stable = 0;
        private final Double discountRelativeToMostExpensivePerMonth;
        private final boolean showZeroDecimalPlacePrices;

        public PackageContext(Double d3, boolean z2) {
            this.discountRelativeToMostExpensivePerMonth = d3;
            this.showZeroDecimalPlacePrices = z2;
        }

        public static /* synthetic */ PackageContext copy$default(PackageContext packageContext, Double d3, boolean z2, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                d3 = packageContext.discountRelativeToMostExpensivePerMonth;
            }
            if ((i3 & 2) != 0) {
                z2 = packageContext.showZeroDecimalPlacePrices;
            }
            return packageContext.copy(d3, z2);
        }

        public final Double component1() {
            return this.discountRelativeToMostExpensivePerMonth;
        }

        public final boolean component2() {
            return this.showZeroDecimalPlacePrices;
        }

        public final PackageContext copy(Double d3, boolean z2) {
            return new PackageContext(d3, z2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof PackageContext)) {
                return false;
            }
            PackageContext packageContext = (PackageContext) obj;
            return Intrinsics.areEqual((Object) this.discountRelativeToMostExpensivePerMonth, (Object) packageContext.discountRelativeToMostExpensivePerMonth) && this.showZeroDecimalPlacePrices == packageContext.showZeroDecimalPlacePrices;
        }

        public final Double getDiscountRelativeToMostExpensivePerMonth() {
            return this.discountRelativeToMostExpensivePerMonth;
        }

        public final boolean getShowZeroDecimalPlacePrices() {
            return this.showZeroDecimalPlacePrices;
        }

        public int hashCode() {
            Double d3 = this.discountRelativeToMostExpensivePerMonth;
            return ((d3 == null ? 0 : d3.hashCode()) * 31) + Boolean.hashCode(this.showZeroDecimalPlacePrices);
        }

        public String toString() {
            return "PackageContext(discountRelativeToMostExpensivePerMonth=" + this.discountRelativeToMostExpensivePerMonth + ", showZeroDecimalPlacePrices=" + this.showZeroDecimalPlacePrices + ')';
        }

        public /* synthetic */ PackageContext(Double d3, boolean z2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this(d3, (i3 & 2) != 0 ? false : z2);
        }
    }
}
