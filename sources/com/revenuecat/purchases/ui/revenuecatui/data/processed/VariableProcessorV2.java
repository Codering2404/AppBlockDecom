package com.revenuecat.purchases.ui.revenuecatui.data.processed;

import androidx.media3.extractor.jpeg.xWt.jTYhJgqLBN;
import com.facebook.internal.Utility;
import com.revenuecat.purchases.Package;
import com.revenuecat.purchases.UiConfig;
import com.revenuecat.purchases.models.Period;
import com.revenuecat.purchases.models.Price;
import com.revenuecat.purchases.models.PricingPhase;
import com.revenuecat.purchases.models.StoreProduct;
import com.revenuecat.purchases.models.SubscriptionOption;
import com.revenuecat.purchases.paywalls.components.CountdownComponent;
import com.revenuecat.purchases.paywalls.components.common.VariableLocalizationKey;
import com.revenuecat.purchases.ui.revenuecatui.CustomVariableValue;
import com.revenuecat.purchases.ui.revenuecatui.components.countdown.CountdownTime;
import com.revenuecat.purchases.ui.revenuecatui.data.processed.VariableProcessor;
import com.revenuecat.purchases.ui.revenuecatui.data.processed.VariableProcessorV2;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.revenuecat.purchases.ui.revenuecatui.helpers.Logger;
import cz.mobilesoft.coreblock.storage.room.dao.cI.KrzujOtzIk;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Currency;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;
import kotlin.text.CharsKt;
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
public final class VariableProcessorV2 {
    private static final float PERCENT_SCALE = 100.0f;
    public static final VariableProcessorV2 INSTANCE = new VariableProcessorV2();
    private static final Regex regex = new Regex("\\{\\{\\s*(.*?)\\s*\\}\\}");
    private static final List<String> customVariablePrefixes = CollectionsKt.listOf((Object[]) new String[]{"custom.", "$custom."});
    public static final int $stable = 8;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public enum Function {
        LOWERCASE("lowercase"),
        UPPERCASE("uppercase"),
        CAPITALIZE("capitalize");

        private final String identifier;
        public static final Companion Companion = new Companion(null);
        private static final Lazy<Map<String, Function>> valuesByIdentifier$delegate = LazyKt.b(new Function0<Map<String, ? extends Function>>() { // from class: com.revenuecat.purchases.ui.revenuecatui.data.processed.VariableProcessorV2$Function$Companion$valuesByIdentifier$2
            @Override // kotlin.jvm.functions.Function0
            public final Map<String, VariableProcessorV2.Function> invoke() {
                VariableProcessorV2.Function[] functionArrValues = VariableProcessorV2.Function.values();
                LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.f(MapsKt.mapCapacity(functionArrValues.length), 16));
                for (VariableProcessorV2.Function function : functionArrValues) {
                    linkedHashMap.put(function.getIdentifier(), function);
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

            private final Map<String, Function> getValuesByIdentifier() {
                return (Map) Function.valuesByIdentifier$delegate.getValue();
            }

            private Companion() {
            }

            public final Function valueOfIdentifier(String str) {
                Intrinsics.checkNotNullParameter(str, jTYhJgqLBN.FFOiIIUvHg);
                return getValuesByIdentifier().get(str);
            }
        }

        Function(String str) {
            this.identifier = str;
        }

        public final /* synthetic */ String getIdentifier() {
            return this.identifier;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public enum Variable {
        PRODUCT_CURRENCY_CODE("product.currency_code"),
        PRODUCT_CURRENCY_SYMBOL("product.currency_symbol"),
        PRODUCT_PERIODLY("product.periodly"),
        PRODUCT_PRICE("product.price"),
        PRODUCT_PRICE_PER_PERIOD("product.price_per_period"),
        PRODUCT_PRICE_PER_PERIOD_ABBREVIATED("product.price_per_period_abbreviated"),
        PRODUCT_PRICE_PER_DAY("product.price_per_day"),
        PRODUCT_PRICE_PER_WEEK("product.price_per_week"),
        PRODUCT_PRICE_PER_MONTH("product.price_per_month"),
        PRODUCT_PRICE_PER_YEAR("product.price_per_year"),
        PRODUCT_PERIOD("product.period"),
        PRODUCT_PERIOD_ABBREVIATED("product.period_abbreviated"),
        PRODUCT_PERIOD_IN_DAYS("product.period_in_days"),
        PRODUCT_PERIOD_IN_WEEKS("product.period_in_weeks"),
        PRODUCT_PERIOD_IN_MONTHS("product.period_in_months"),
        PRODUCT_PERIOD_IN_YEARS("product.period_in_years"),
        PRODUCT_PERIOD_WITH_UNIT("product.period_with_unit"),
        PRODUCT_OFFER_PRICE("product.offer_price"),
        PRODUCT_OFFER_PRICE_PER_DAY("product.offer_price_per_day"),
        PRODUCT_OFFER_PRICE_PER_WEEK("product.offer_price_per_week"),
        PRODUCT_OFFER_PRICE_PER_MONTH("product.offer_price_per_month"),
        PRODUCT_OFFER_PRICE_PER_YEAR("product.offer_price_per_year"),
        PRODUCT_OFFER_PERIOD("product.offer_period"),
        PRODUCT_OFFER_PERIOD_ABBREVIATED("product.offer_period_abbreviated"),
        PRODUCT_OFFER_PERIOD_IN_DAYS("product.offer_period_in_days"),
        PRODUCT_OFFER_PERIOD_IN_WEEKS("product.offer_period_in_weeks"),
        PRODUCT_OFFER_PERIOD_IN_MONTHS("product.offer_period_in_months"),
        PRODUCT_OFFER_PERIOD_IN_YEARS("product.offer_period_in_years"),
        PRODUCT_OFFER_PERIOD_WITH_UNIT("product.offer_period_with_unit"),
        PRODUCT_OFFER_END_DATE("product.offer_end_date"),
        PRODUCT_SECONDARY_OFFER_PRICE("product.secondary_offer_price"),
        PRODUCT_SECONDARY_OFFER_PERIOD("product.secondary_offer_period"),
        PRODUCT_SECONDARY_OFFER_PERIOD_ABBREVIATED("product.secondary_offer_period_abbreviated"),
        PRODUCT_RELATIVE_DISCOUNT("product.relative_discount"),
        PRODUCT_STORE_PRODUCT_NAME("product.store_product_name"),
        COUNT_DAYS_WITH_ZERO("count_days_with_zero"),
        COUNT_DAYS_WITHOUT_ZERO("count_days_without_zero"),
        COUNT_HOURS_WITH_ZERO("count_hours_with_zero"),
        COUNT_HOURS_WITHOUT_ZERO("count_hours_without_zero"),
        COUNT_MINUTES_WITH_ZERO("count_minutes_with_zero"),
        COUNT_MINUTES_WITHOUT_ZERO("count_minutes_without_zero"),
        COUNT_SECONDS_WITH_ZERO("count_seconds_with_zero"),
        COUNT_SECONDS_WITHOUT_ZERO("count_seconds_without_zero");

        private final String identifier;
        public static final Companion Companion = new Companion(null);
        private static final Lazy<Map<String, Variable>> valuesByIdentifier$delegate = LazyKt.b(new Function0<Map<String, ? extends Variable>>() { // from class: com.revenuecat.purchases.ui.revenuecatui.data.processed.VariableProcessorV2$Variable$Companion$valuesByIdentifier$2
            @Override // kotlin.jvm.functions.Function0
            public final Map<String, VariableProcessorV2.Variable> invoke() {
                VariableProcessorV2.Variable[] variableArrValues = VariableProcessorV2.Variable.values();
                LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.f(MapsKt.mapCapacity(variableArrValues.length), 16));
                for (VariableProcessorV2.Variable variable : variableArrValues) {
                    linkedHashMap.put(variable.getIdentifier(), variable);
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

            private final Map<String, Variable> getValuesByIdentifier() {
                return (Map) Variable.valuesByIdentifier$delegate.getValue();
            }

            public final Variable valueOfIdentifier(String identifier) {
                Intrinsics.checkNotNullParameter(identifier, "identifier");
                return getValuesByIdentifier().get(identifier);
            }

            private Companion() {
            }
        }

        Variable(String str) {
            this.identifier = str;
        }

        public final /* synthetic */ String getIdentifier() {
            return this.identifier;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;
        public static final /* synthetic */ int[] $EnumSwitchMapping$2;

        static {
            int[] iArr = new int[CountdownComponent.CountFrom.values().length];
            try {
                iArr[CountdownComponent.CountFrom.DAYS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[CountdownComponent.CountFrom.HOURS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[CountdownComponent.CountFrom.MINUTES.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[Variable.values().length];
            try {
                iArr2[Variable.PRODUCT_CURRENCY_CODE.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr2[Variable.PRODUCT_CURRENCY_SYMBOL.ordinal()] = 2;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr2[Variable.PRODUCT_PERIODLY.ordinal()] = 3;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr2[Variable.PRODUCT_PRICE.ordinal()] = 4;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr2[Variable.PRODUCT_PRICE_PER_PERIOD.ordinal()] = 5;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr2[Variable.PRODUCT_PRICE_PER_PERIOD_ABBREVIATED.ordinal()] = 6;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                iArr2[Variable.PRODUCT_PRICE_PER_DAY.ordinal()] = 7;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                iArr2[Variable.PRODUCT_PRICE_PER_WEEK.ordinal()] = 8;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                iArr2[Variable.PRODUCT_PRICE_PER_MONTH.ordinal()] = 9;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                iArr2[Variable.PRODUCT_PRICE_PER_YEAR.ordinal()] = 10;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                iArr2[Variable.PRODUCT_PERIOD.ordinal()] = 11;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                iArr2[Variable.PRODUCT_PERIOD_ABBREVIATED.ordinal()] = 12;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                iArr2[Variable.PRODUCT_PERIOD_IN_DAYS.ordinal()] = 13;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                iArr2[Variable.PRODUCT_PERIOD_IN_WEEKS.ordinal()] = 14;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                iArr2[Variable.PRODUCT_PERIOD_IN_MONTHS.ordinal()] = 15;
            } catch (NoSuchFieldError unused18) {
            }
            try {
                iArr2[Variable.PRODUCT_PERIOD_IN_YEARS.ordinal()] = 16;
            } catch (NoSuchFieldError unused19) {
            }
            try {
                iArr2[Variable.PRODUCT_PERIOD_WITH_UNIT.ordinal()] = 17;
            } catch (NoSuchFieldError unused20) {
            }
            try {
                iArr2[Variable.PRODUCT_OFFER_PRICE.ordinal()] = 18;
            } catch (NoSuchFieldError unused21) {
            }
            try {
                iArr2[Variable.PRODUCT_OFFER_PRICE_PER_DAY.ordinal()] = 19;
            } catch (NoSuchFieldError unused22) {
            }
            try {
                iArr2[Variable.PRODUCT_OFFER_PRICE_PER_WEEK.ordinal()] = 20;
            } catch (NoSuchFieldError unused23) {
            }
            try {
                iArr2[Variable.PRODUCT_OFFER_PRICE_PER_MONTH.ordinal()] = 21;
            } catch (NoSuchFieldError unused24) {
            }
            try {
                iArr2[Variable.PRODUCT_OFFER_PRICE_PER_YEAR.ordinal()] = 22;
            } catch (NoSuchFieldError unused25) {
            }
            try {
                iArr2[Variable.PRODUCT_OFFER_PERIOD.ordinal()] = 23;
            } catch (NoSuchFieldError unused26) {
            }
            try {
                iArr2[Variable.PRODUCT_OFFER_PERIOD_ABBREVIATED.ordinal()] = 24;
            } catch (NoSuchFieldError unused27) {
            }
            try {
                iArr2[Variable.PRODUCT_OFFER_PERIOD_IN_DAYS.ordinal()] = 25;
            } catch (NoSuchFieldError unused28) {
            }
            try {
                iArr2[Variable.PRODUCT_OFFER_PERIOD_IN_WEEKS.ordinal()] = 26;
            } catch (NoSuchFieldError unused29) {
            }
            try {
                iArr2[Variable.PRODUCT_OFFER_PERIOD_IN_MONTHS.ordinal()] = 27;
            } catch (NoSuchFieldError unused30) {
            }
            try {
                iArr2[Variable.PRODUCT_OFFER_PERIOD_IN_YEARS.ordinal()] = 28;
            } catch (NoSuchFieldError unused31) {
            }
            try {
                iArr2[Variable.PRODUCT_OFFER_PERIOD_WITH_UNIT.ordinal()] = 29;
            } catch (NoSuchFieldError unused32) {
            }
            try {
                iArr2[Variable.PRODUCT_OFFER_END_DATE.ordinal()] = 30;
            } catch (NoSuchFieldError unused33) {
            }
            try {
                iArr2[Variable.PRODUCT_SECONDARY_OFFER_PRICE.ordinal()] = 31;
            } catch (NoSuchFieldError unused34) {
            }
            try {
                iArr2[Variable.PRODUCT_SECONDARY_OFFER_PERIOD.ordinal()] = 32;
            } catch (NoSuchFieldError unused35) {
            }
            try {
                iArr2[Variable.PRODUCT_SECONDARY_OFFER_PERIOD_ABBREVIATED.ordinal()] = 33;
            } catch (NoSuchFieldError unused36) {
            }
            try {
                iArr2[Variable.PRODUCT_RELATIVE_DISCOUNT.ordinal()] = 34;
            } catch (NoSuchFieldError unused37) {
            }
            try {
                iArr2[Variable.PRODUCT_STORE_PRODUCT_NAME.ordinal()] = 35;
            } catch (NoSuchFieldError unused38) {
            }
            try {
                iArr2[Variable.COUNT_DAYS_WITH_ZERO.ordinal()] = 36;
            } catch (NoSuchFieldError unused39) {
            }
            try {
                iArr2[Variable.COUNT_DAYS_WITHOUT_ZERO.ordinal()] = 37;
            } catch (NoSuchFieldError unused40) {
            }
            try {
                iArr2[Variable.COUNT_HOURS_WITH_ZERO.ordinal()] = 38;
            } catch (NoSuchFieldError unused41) {
            }
            try {
                iArr2[Variable.COUNT_HOURS_WITHOUT_ZERO.ordinal()] = 39;
            } catch (NoSuchFieldError unused42) {
            }
            try {
                iArr2[Variable.COUNT_MINUTES_WITH_ZERO.ordinal()] = 40;
            } catch (NoSuchFieldError unused43) {
            }
            try {
                iArr2[Variable.COUNT_MINUTES_WITHOUT_ZERO.ordinal()] = 41;
            } catch (NoSuchFieldError unused44) {
            }
            try {
                iArr2[Variable.COUNT_SECONDS_WITH_ZERO.ordinal()] = 42;
            } catch (NoSuchFieldError unused45) {
            }
            try {
                iArr2[Variable.COUNT_SECONDS_WITHOUT_ZERO.ordinal()] = 43;
            } catch (NoSuchFieldError unused46) {
            }
            $EnumSwitchMapping$1 = iArr2;
            int[] iArr3 = new int[Function.values().length];
            try {
                iArr3[Function.LOWERCASE.ordinal()] = 1;
            } catch (NoSuchFieldError unused47) {
            }
            try {
                iArr3[Function.UPPERCASE.ordinal()] = 2;
            } catch (NoSuchFieldError unused48) {
            }
            try {
                iArr3[Function.CAPITALIZE.ordinal()] = 3;
            } catch (NoSuchFieldError unused49) {
            }
            $EnumSwitchMapping$2 = iArr3;
        }
    }

    private VariableProcessorV2() {
    }

    private final void checkForMalformedCustomVariable(String str) {
        for (String str2 : CollectionsKt.listOf((Object[]) new String[]{"custom", "$custom"})) {
            if (!Intrinsics.areEqual(str, str2)) {
                if (StringsKt.U(str, str2 + ' ', false, 2, null)) {
                }
            }
            Logger.INSTANCE.w("Variable '" + str + "' looks like it might be intended as a custom variable. Use 'custom.<variable_name>' or '$custom.<variable_name>' syntax instead.");
            return;
        }
    }

    private final String extractCustomVariableKey(String str) {
        for (String str2 : customVariablePrefixes) {
            if (StringsKt.U(str, str2, false, 2, null)) {
                String strK0 = StringsKt.K0(str, str2);
                if (strK0.length() != 0) {
                    return strK0;
                }
                Logger.INSTANCE.w("Custom variable '" + str + "' appears to be malformed. Expected format: 'custom.<variable_name>' or '$custom.<variable_name>'.");
                return null;
            }
        }
        checkForMalformedCustomVariable(str);
        return null;
    }

    private final void failedToGetValue(Logger logger, String str, Package r5) {
        logger.w("Could not process value for variable '" + str + "' for package '" + r5.getIdentifier() + "'. Please check that the product for that package matches the requirements for that variable. Defaulting to empty string.");
    }

    private final Function findFunction(String str, Map<String, String> map) {
        Function functionValueOfIdentifier = Function.Companion.valueOfIdentifier(str);
        if (functionValueOfIdentifier != null) {
            return functionValueOfIdentifier;
        }
        String str2 = map.get(str);
        if (str2 == null) {
            unsupportedFunctionWithoutFallback(Logger.INSTANCE, str);
            return null;
        }
        Function functionFindFunction = findFunction(str2, map);
        if (functionFindFunction == null) {
            return null;
        }
        INSTANCE.usingFallbackFunction(Logger.INSTANCE, str, str2);
        return functionFindFunction;
    }

    private final Variable findVariable(String str, Map<String, String> map) {
        Variable variableValueOfIdentifier = Variable.Companion.valueOfIdentifier(str);
        if (variableValueOfIdentifier != null) {
            return variableValueOfIdentifier;
        }
        String str2 = map.get(str);
        if (str2 == null) {
            unsupportedVariableWithoutFallback(Logger.INSTANCE, str);
            return null;
        }
        Variable variableFindVariable = findVariable(str2, map);
        if (variableFindVariable == null) {
            return null;
        }
        INSTANCE.usingFallbackVariable(Logger.INSTANCE, str, str2);
        return variableFindVariable;
    }

    private final String getValue(Variable variable, final Map<VariableLocalizationKey, String> map, final VariableDataProvider variableDataProvider, final VariableProcessor.PackageContext packageContext, final Package r23, SubscriptionOption subscriptionOption, final Locale locale, Locale locale2, Date date, CountdownTime countdownTime, CountdownComponent.CountFrom countFrom) {
        StoreProduct product;
        Price price;
        StoreProduct product2;
        Period period;
        StoreProduct product3;
        Period period2;
        StoreProduct product4;
        Period period3;
        StoreProduct product5;
        Period period4;
        String strProductOfferPricePerDay;
        String strProductOfferPricePerWeek;
        String strProductOfferPricePerMonth;
        String strProductOfferPricePerYear;
        StoreProduct product6;
        Period period5;
        String productOfferPeriodInDays;
        StoreProduct product7;
        Period period6;
        String productOfferPeriodInWeeks;
        StoreProduct product8;
        Period period7;
        String productOfferPeriodInMonths;
        StoreProduct product9;
        Period period8;
        String productOfferPeriodInYears;
        String strProductOfferPeriodWithUnit;
        StoreProduct product10;
        int minutes;
        int minutes2;
        int hours = 0;
        int hours2 = 0;
        days = 0;
        int days = 0;
        days = 0;
        int days2 = 0;
        switch (WhenMappings.$EnumSwitchMapping$1[variable.ordinal()]) {
            case 1:
                if (r23 == null || (product = r23.getProduct()) == null || (price = product.getPrice()) == null) {
                    return null;
                }
                return price.getCurrencyCode();
            case 2:
                if (r23 != null) {
                    return Currency.getInstance(r23.getProduct().getPrice().getCurrencyCode()).getSymbol(locale);
                }
                return null;
            case 3:
                if (r23 != null) {
                    return PackagePeriodExtensionsKt.productPeriodly(r23, map);
                }
                return null;
            case 4:
                if (r23 == null || variableDataProvider == null) {
                    return null;
                }
                return variableDataProvider.localizedPrice(r23, locale, packageContext != null ? packageContext.getShowZeroDecimalPlacePrices() : false);
            case 5:
                if (r23 != null && variableDataProvider != null) {
                    String strLocalizedPrice = variableDataProvider.localizedPrice(r23, locale, packageContext != null ? packageContext.getShowZeroDecimalPlacePrices() : false);
                    if (strLocalizedPrice != null) {
                        String strProductPeriod = PackagePeriodExtensionsKt.productPeriod(r23, map);
                        if (PackagePeriodExtensionsKt.isLifetime(r23)) {
                            return strLocalizedPrice;
                        }
                        if (strProductPeriod != null) {
                            return strLocalizedPrice + '/' + strProductPeriod;
                        }
                    }
                }
                return null;
            case 6:
                if (r23 != null && variableDataProvider != null) {
                    String strLocalizedPrice2 = variableDataProvider.localizedPrice(r23, locale, packageContext != null ? packageContext.getShowZeroDecimalPlacePrices() : false);
                    if (strLocalizedPrice2 != null) {
                        String strProductPeriodAbbreviated = PackagePeriodExtensionsKt.productPeriodAbbreviated(r23, map);
                        if (PackagePeriodExtensionsKt.isLifetime(r23)) {
                            return strLocalizedPrice2;
                        }
                        if (strProductPeriodAbbreviated != null) {
                            return strLocalizedPrice2 + '/' + strProductPeriodAbbreviated;
                        }
                    }
                }
                return null;
            case 7:
                if (r23 != null) {
                    boolean showZeroDecimalPlacePrices = packageContext != null ? packageContext.getShowZeroDecimalPlacePrices() : false;
                    if (PackagePeriodExtensionsKt.isLifetime(r23)) {
                        if (variableDataProvider != null) {
                            return variableDataProvider.localizedPrice(r23, locale, showZeroDecimalPlacePrices);
                        }
                        return null;
                    }
                    if (variableDataProvider != null) {
                        return variableDataProvider.localizedPricePerDay(r23, locale, showZeroDecimalPlacePrices);
                    }
                }
                return null;
            case 8:
                if (r23 != null) {
                    boolean showZeroDecimalPlacePrices2 = packageContext != null ? packageContext.getShowZeroDecimalPlacePrices() : false;
                    if (PackagePeriodExtensionsKt.isLifetime(r23)) {
                        if (variableDataProvider != null) {
                            return variableDataProvider.localizedPrice(r23, locale, showZeroDecimalPlacePrices2);
                        }
                        return null;
                    }
                    if (variableDataProvider != null) {
                        return variableDataProvider.localizedPricePerWeek(r23, locale, showZeroDecimalPlacePrices2);
                    }
                }
                return null;
            case 9:
                if (r23 != null) {
                    boolean showZeroDecimalPlacePrices3 = packageContext != null ? packageContext.getShowZeroDecimalPlacePrices() : false;
                    if (PackagePeriodExtensionsKt.isLifetime(r23)) {
                        if (variableDataProvider != null) {
                            return variableDataProvider.localizedPrice(r23, locale, showZeroDecimalPlacePrices3);
                        }
                        return null;
                    }
                    if (variableDataProvider != null) {
                        return variableDataProvider.localizedPricePerMonth(r23, locale, showZeroDecimalPlacePrices3);
                    }
                }
                return null;
            case 10:
                if (r23 != null) {
                    boolean showZeroDecimalPlacePrices4 = packageContext != null ? packageContext.getShowZeroDecimalPlacePrices() : false;
                    if (PackagePeriodExtensionsKt.isLifetime(r23)) {
                        if (variableDataProvider != null) {
                            return variableDataProvider.localizedPrice(r23, locale, showZeroDecimalPlacePrices4);
                        }
                        return null;
                    }
                    if (variableDataProvider != null) {
                        return variableDataProvider.localizedPricePerYear(r23, locale, showZeroDecimalPlacePrices4);
                    }
                }
                return null;
            case 11:
                if (r23 != null) {
                    return PackagePeriodExtensionsKt.productPeriod(r23, map);
                }
                return null;
            case 12:
                if (r23 != null) {
                    return PackagePeriodExtensionsKt.productPeriodAbbreviated(r23, map);
                }
                return null;
            case 13:
                if (r23 == null || (product2 = r23.getProduct()) == null || (period = product2.getPeriod()) == null) {
                    return null;
                }
                return PeriodExtensionsKt.getRoundedValueInDays(period);
            case 14:
                if (r23 == null || (product3 = r23.getProduct()) == null || (period2 = product3.getPeriod()) == null) {
                    return null;
                }
                return PeriodExtensionsKt.getRoundedValueInWeeks(period2);
            case 15:
                if (r23 == null || (product4 = r23.getProduct()) == null || (period3 = product4.getPeriod()) == null) {
                    return null;
                }
                return PeriodExtensionsKt.getRoundedValueInMonths(period3);
            case 16:
                if (r23 == null || (product5 = r23.getProduct()) == null || (period4 = product5.getPeriod()) == null) {
                    return null;
                }
                return PeriodExtensionsKt.getRoundedValueInYears(period4);
            case 17:
                if (r23 != null) {
                    return PackagePeriodExtensionsKt.productPeriodWithUnit(r23, map);
                }
                return null;
            case 18:
                return PricingPhaseExtensionsKt.resolveOfferPrice(PricingPhaseExtensionsKt.primaryDiscountPhase(subscriptionOption, r23), locale, map, new Function0<String>() { // from class: com.revenuecat.purchases.ui.revenuecatui.data.processed.VariableProcessorV2.getValue.9
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final String invoke() {
                        Package r02 = r23;
                        if (r02 != null) {
                            VariableProcessor.PackageContext packageContext2 = packageContext;
                            VariableDataProvider variableDataProvider2 = variableDataProvider;
                            Locale locale3 = locale;
                            boolean showZeroDecimalPlacePrices5 = packageContext2 != null ? packageContext2.getShowZeroDecimalPlacePrices() : false;
                            if (variableDataProvider2 != null) {
                                return variableDataProvider2.localizedPrice(r02, locale3, showZeroDecimalPlacePrices5);
                            }
                        }
                        return null;
                    }
                });
            case 19:
                PricingPhase pricingPhasePrimaryDiscountPhase = PricingPhaseExtensionsKt.primaryDiscountPhase(subscriptionOption, r23);
                if (pricingPhasePrimaryDiscountPhase != null && (strProductOfferPricePerDay = PricingPhaseExtensionsKt.productOfferPricePerDay(pricingPhasePrimaryDiscountPhase, locale, map)) != null) {
                    return strProductOfferPricePerDay;
                }
                if (r23 != null) {
                    boolean showZeroDecimalPlacePrices5 = packageContext != null ? packageContext.getShowZeroDecimalPlacePrices() : false;
                    if (variableDataProvider != null) {
                        return variableDataProvider.localizedPricePerDay(r23, locale, showZeroDecimalPlacePrices5);
                    }
                }
                return null;
            case 20:
                PricingPhase pricingPhasePrimaryDiscountPhase2 = PricingPhaseExtensionsKt.primaryDiscountPhase(subscriptionOption, r23);
                if (pricingPhasePrimaryDiscountPhase2 != null && (strProductOfferPricePerWeek = PricingPhaseExtensionsKt.productOfferPricePerWeek(pricingPhasePrimaryDiscountPhase2, locale, map)) != null) {
                    return strProductOfferPricePerWeek;
                }
                if (r23 != null) {
                    boolean showZeroDecimalPlacePrices6 = packageContext != null ? packageContext.getShowZeroDecimalPlacePrices() : false;
                    if (variableDataProvider != null) {
                        return variableDataProvider.localizedPricePerWeek(r23, locale, showZeroDecimalPlacePrices6);
                    }
                }
                return null;
            case 21:
                PricingPhase pricingPhasePrimaryDiscountPhase3 = PricingPhaseExtensionsKt.primaryDiscountPhase(subscriptionOption, r23);
                if (pricingPhasePrimaryDiscountPhase3 != null && (strProductOfferPricePerMonth = PricingPhaseExtensionsKt.productOfferPricePerMonth(pricingPhasePrimaryDiscountPhase3, locale, map)) != null) {
                    return strProductOfferPricePerMonth;
                }
                if (r23 != null) {
                    boolean showZeroDecimalPlacePrices7 = packageContext != null ? packageContext.getShowZeroDecimalPlacePrices() : false;
                    if (variableDataProvider != null) {
                        return variableDataProvider.localizedPricePerMonth(r23, locale, showZeroDecimalPlacePrices7);
                    }
                }
                return null;
            case 22:
                PricingPhase pricingPhasePrimaryDiscountPhase4 = PricingPhaseExtensionsKt.primaryDiscountPhase(subscriptionOption, r23);
                if (pricingPhasePrimaryDiscountPhase4 != null && (strProductOfferPricePerYear = PricingPhaseExtensionsKt.productOfferPricePerYear(pricingPhasePrimaryDiscountPhase4, locale, map)) != null) {
                    return strProductOfferPricePerYear;
                }
                if (r23 != null) {
                    boolean showZeroDecimalPlacePrices8 = packageContext != null ? packageContext.getShowZeroDecimalPlacePrices() : false;
                    if (variableDataProvider != null) {
                        return variableDataProvider.localizedPricePerYear(r23, locale, showZeroDecimalPlacePrices8);
                    }
                }
                return null;
            case 23:
                return PricingPhaseExtensionsKt.resolveOfferPeriod(PricingPhaseExtensionsKt.primaryDiscountPhase(subscriptionOption, r23), new Function1<PricingPhase, String>() { // from class: com.revenuecat.purchases.ui.revenuecatui.data.processed.VariableProcessorV2.getValue.14
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final String invoke(PricingPhase it) {
                        Intrinsics.checkNotNullParameter(it, "it");
                        return PricingPhaseExtensionsKt.productOfferPeriod(it, map);
                    }
                }, new Function0<String>() { // from class: com.revenuecat.purchases.ui.revenuecatui.data.processed.VariableProcessorV2.getValue.15
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final String invoke() {
                        Package r02 = r23;
                        if (r02 != null) {
                            return PackagePeriodExtensionsKt.productPeriod(r02, map);
                        }
                        return null;
                    }
                });
            case 24:
                return PricingPhaseExtensionsKt.resolveOfferPeriod(PricingPhaseExtensionsKt.primaryDiscountPhase(subscriptionOption, r23), new Function1<PricingPhase, String>() { // from class: com.revenuecat.purchases.ui.revenuecatui.data.processed.VariableProcessorV2.getValue.16
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final String invoke(PricingPhase it) {
                        Intrinsics.checkNotNullParameter(it, "it");
                        return PricingPhaseExtensionsKt.productOfferPeriodAbbreviated(it, map);
                    }
                }, new Function0<String>() { // from class: com.revenuecat.purchases.ui.revenuecatui.data.processed.VariableProcessorV2.getValue.17
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final String invoke() {
                        Package r02 = r23;
                        if (r02 != null) {
                            return PackagePeriodExtensionsKt.productPeriodAbbreviated(r02, map);
                        }
                        return null;
                    }
                });
            case 25:
                PricingPhase pricingPhasePrimaryDiscountPhase5 = PricingPhaseExtensionsKt.primaryDiscountPhase(subscriptionOption, r23);
                if (pricingPhasePrimaryDiscountPhase5 != null && (productOfferPeriodInDays = PricingPhaseExtensionsKt.getProductOfferPeriodInDays(pricingPhasePrimaryDiscountPhase5)) != null) {
                    return productOfferPeriodInDays;
                }
                if (r23 == null || (product6 = r23.getProduct()) == null || (period5 = product6.getPeriod()) == null) {
                    return null;
                }
                return PeriodExtensionsKt.getRoundedValueInDays(period5);
            case 26:
                PricingPhase pricingPhasePrimaryDiscountPhase6 = PricingPhaseExtensionsKt.primaryDiscountPhase(subscriptionOption, r23);
                if (pricingPhasePrimaryDiscountPhase6 != null && (productOfferPeriodInWeeks = PricingPhaseExtensionsKt.getProductOfferPeriodInWeeks(pricingPhasePrimaryDiscountPhase6)) != null) {
                    return productOfferPeriodInWeeks;
                }
                if (r23 == null || (product7 = r23.getProduct()) == null || (period6 = product7.getPeriod()) == null) {
                    return null;
                }
                return PeriodExtensionsKt.getRoundedValueInWeeks(period6);
            case 27:
                PricingPhase pricingPhasePrimaryDiscountPhase7 = PricingPhaseExtensionsKt.primaryDiscountPhase(subscriptionOption, r23);
                if (pricingPhasePrimaryDiscountPhase7 != null && (productOfferPeriodInMonths = PricingPhaseExtensionsKt.getProductOfferPeriodInMonths(pricingPhasePrimaryDiscountPhase7)) != null) {
                    return productOfferPeriodInMonths;
                }
                if (r23 == null || (product8 = r23.getProduct()) == null || (period7 = product8.getPeriod()) == null) {
                    return null;
                }
                return PeriodExtensionsKt.getRoundedValueInMonths(period7);
            case 28:
                PricingPhase pricingPhasePrimaryDiscountPhase8 = PricingPhaseExtensionsKt.primaryDiscountPhase(subscriptionOption, r23);
                if (pricingPhasePrimaryDiscountPhase8 != null && (productOfferPeriodInYears = PricingPhaseExtensionsKt.getProductOfferPeriodInYears(pricingPhasePrimaryDiscountPhase8)) != null) {
                    return productOfferPeriodInYears;
                }
                if (r23 == null || (product9 = r23.getProduct()) == null || (period8 = product9.getPeriod()) == null) {
                    return null;
                }
                return PeriodExtensionsKt.getRoundedValueInYears(period8);
            case 29:
                PricingPhase pricingPhasePrimaryDiscountPhase9 = PricingPhaseExtensionsKt.primaryDiscountPhase(subscriptionOption, r23);
                if (pricingPhasePrimaryDiscountPhase9 != null && (strProductOfferPeriodWithUnit = PricingPhaseExtensionsKt.productOfferPeriodWithUnit(pricingPhasePrimaryDiscountPhase9, map)) != null) {
                    return strProductOfferPeriodWithUnit;
                }
                if (r23 != null) {
                    return PackagePeriodExtensionsKt.productPeriodWithUnit(r23, map);
                }
                return null;
            case 30:
                PricingPhase pricingPhasePrimaryDiscountPhase10 = PricingPhaseExtensionsKt.primaryDiscountPhase(subscriptionOption, r23);
                if (pricingPhasePrimaryDiscountPhase10 != null) {
                    return PricingPhaseExtensionsKt.productOfferEndDate(pricingPhasePrimaryDiscountPhase10, locale2, date);
                }
                return null;
            case 31:
                return PricingPhaseExtensionsKt.resolveOfferPrice(PricingPhaseExtensionsKt.secondaryDiscountPhase(subscriptionOption, r23), locale, map, new Function0<String>() { // from class: com.revenuecat.purchases.ui.revenuecatui.data.processed.VariableProcessorV2.getValue.18
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final String invoke() {
                        Package r02 = r23;
                        if (r02 != null) {
                            VariableProcessor.PackageContext packageContext2 = packageContext;
                            VariableDataProvider variableDataProvider2 = variableDataProvider;
                            Locale locale3 = locale;
                            boolean showZeroDecimalPlacePrices9 = packageContext2 != null ? packageContext2.getShowZeroDecimalPlacePrices() : false;
                            if (variableDataProvider2 != null) {
                                return variableDataProvider2.localizedPrice(r02, locale3, showZeroDecimalPlacePrices9);
                            }
                        }
                        return null;
                    }
                });
            case 32:
                return PricingPhaseExtensionsKt.resolveOfferPeriod(PricingPhaseExtensionsKt.secondaryDiscountPhase(subscriptionOption, r23), new Function1<PricingPhase, String>() { // from class: com.revenuecat.purchases.ui.revenuecatui.data.processed.VariableProcessorV2.getValue.19
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final String invoke(PricingPhase it) {
                        Intrinsics.checkNotNullParameter(it, "it");
                        return PricingPhaseExtensionsKt.productOfferPeriod(it, map);
                    }
                }, new Function0<String>() { // from class: com.revenuecat.purchases.ui.revenuecatui.data.processed.VariableProcessorV2.getValue.20
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final String invoke() {
                        Package r02 = r23;
                        if (r02 != null) {
                            return PackagePeriodExtensionsKt.productPeriod(r02, map);
                        }
                        return null;
                    }
                });
            case 33:
                return PricingPhaseExtensionsKt.resolveOfferPeriod(PricingPhaseExtensionsKt.secondaryDiscountPhase(subscriptionOption, r23), new Function1<PricingPhase, String>() { // from class: com.revenuecat.purchases.ui.revenuecatui.data.processed.VariableProcessorV2.getValue.21
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final String invoke(PricingPhase it) {
                        Intrinsics.checkNotNullParameter(it, "it");
                        return PricingPhaseExtensionsKt.productOfferPeriodAbbreviated(it, map);
                    }
                }, new Function0<String>() { // from class: com.revenuecat.purchases.ui.revenuecatui.data.processed.VariableProcessorV2.getValue.22
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final String invoke() {
                        Package r02 = r23;
                        if (r02 != null) {
                            return PackagePeriodExtensionsKt.productPeriodAbbreviated(r02, map);
                        }
                        return null;
                    }
                });
            case 34:
                if (packageContext != null) {
                    return relativeDiscount(packageContext, map);
                }
                return null;
            case 35:
                if (r23 == null || (product10 = r23.getProduct()) == null) {
                    return null;
                }
                return product10.getName();
            case 36:
                if (countdownTime == null) {
                    return "";
                }
                int i3 = WhenMappings.$EnumSwitchMapping$0[countFrom.ordinal()];
                if (i3 == 1) {
                    days2 = countdownTime.getDays();
                } else if (i3 != 2 && i3 != 3) {
                    throw new NoWhenBranchMatchedException();
                }
                StringCompanionObject stringCompanionObject = StringCompanionObject.f140150a;
                String str = String.format(locale2, "%02d", Arrays.copyOf(new Object[]{Integer.valueOf(days2)}, 1));
                Intrinsics.checkNotNullExpressionValue(str, "format(...)");
                return str;
            case 37:
                if (countdownTime == null) {
                    return "";
                }
                int i4 = WhenMappings.$EnumSwitchMapping$0[countFrom.ordinal()];
                if (i4 == 1) {
                    days = countdownTime.getDays();
                } else if (i4 != 2 && i4 != 3) {
                    throw new NoWhenBranchMatchedException();
                }
                StringCompanionObject stringCompanionObject2 = StringCompanionObject.f140150a;
                String str2 = String.format(locale2, "%d", Arrays.copyOf(new Object[]{Integer.valueOf(days)}, 1));
                Intrinsics.checkNotNullExpressionValue(str2, "format(...)");
                return str2;
            case 38:
                if (countdownTime == null) {
                    return "";
                }
                int i5 = WhenMappings.$EnumSwitchMapping$0[countFrom.ordinal()];
                if (i5 == 1) {
                    hours2 = countdownTime.getHours();
                } else if (i5 == 2) {
                    hours2 = countdownTime.getTotalHours();
                } else if (i5 != 3) {
                    throw new NoWhenBranchMatchedException();
                }
                StringCompanionObject stringCompanionObject3 = StringCompanionObject.f140150a;
                String str3 = String.format(locale2, "%02d", Arrays.copyOf(new Object[]{Integer.valueOf(hours2)}, 1));
                Intrinsics.checkNotNullExpressionValue(str3, "format(...)");
                return str3;
            case 39:
                if (countdownTime == null) {
                    return "";
                }
                int i6 = WhenMappings.$EnumSwitchMapping$0[countFrom.ordinal()];
                if (i6 == 1) {
                    hours = countdownTime.getHours();
                } else if (i6 == 2) {
                    hours = countdownTime.getTotalHours();
                } else if (i6 != 3) {
                    throw new NoWhenBranchMatchedException();
                }
                StringCompanionObject stringCompanionObject4 = StringCompanionObject.f140150a;
                String str4 = String.format(locale2, "%d", Arrays.copyOf(new Object[]{Integer.valueOf(hours)}, 1));
                Intrinsics.checkNotNullExpressionValue(str4, "format(...)");
                return str4;
            case 40:
                if (countdownTime == null) {
                    return "";
                }
                int i7 = WhenMappings.$EnumSwitchMapping$0[countFrom.ordinal()];
                if (i7 == 1 || i7 == 2) {
                    minutes = countdownTime.getMinutes();
                } else {
                    if (i7 != 3) {
                        throw new NoWhenBranchMatchedException();
                    }
                    minutes = countdownTime.getTotalMinutes();
                }
                StringCompanionObject stringCompanionObject5 = StringCompanionObject.f140150a;
                String str5 = String.format(locale2, "%02d", Arrays.copyOf(new Object[]{Integer.valueOf(minutes)}, 1));
                Intrinsics.checkNotNullExpressionValue(str5, "format(...)");
                return str5;
            case 41:
                if (countdownTime == null) {
                    return "";
                }
                int i8 = WhenMappings.$EnumSwitchMapping$0[countFrom.ordinal()];
                if (i8 == 1 || i8 == 2) {
                    minutes2 = countdownTime.getMinutes();
                } else {
                    if (i8 != 3) {
                        throw new NoWhenBranchMatchedException();
                    }
                    minutes2 = countdownTime.getTotalMinutes();
                }
                StringCompanionObject stringCompanionObject6 = StringCompanionObject.f140150a;
                String str6 = String.format(locale2, "%d", Arrays.copyOf(new Object[]{Integer.valueOf(minutes2)}, 1));
                Intrinsics.checkNotNullExpressionValue(str6, "format(...)");
                return str6;
            case 42:
                if (countdownTime == null) {
                    return "";
                }
                int seconds = countdownTime.getSeconds();
                StringCompanionObject stringCompanionObject7 = StringCompanionObject.f140150a;
                String str7 = String.format(locale2, "%02d", Arrays.copyOf(new Object[]{Integer.valueOf(seconds)}, 1));
                Intrinsics.checkNotNullExpressionValue(str7, "format(...)");
                return str7;
            case 43:
                if (countdownTime == null) {
                    return "";
                }
                int seconds2 = countdownTime.getSeconds();
                StringCompanionObject stringCompanionObject8 = StringCompanionObject.f140150a;
                String str8 = String.format(locale2, "%d", Arrays.copyOf(new Object[]{Integer.valueOf(seconds2)}, 1));
                Intrinsics.checkNotNullExpressionValue(str8, "format(...)");
                return str8;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String getVariableValue(String str, List<String> list, Map<VariableLocalizationKey, String> map, UiConfig.VariableConfig variableConfig, VariableDataProvider variableDataProvider, VariableProcessor.PackageContext packageContext, Package r22, SubscriptionOption subscriptionOption, Locale locale, Locale locale2, Date date, CountdownTime countdownTime, CountdownComponent.CountFrom countFrom, Map<String, ? extends CustomVariableValue> map2, Map<String, ? extends CustomVariableValue> map3) {
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            Function functionFindFunction = INSTANCE.findFunction((String) it.next(), variableConfig.getFunctionCompatibilityMap());
            if (functionFindFunction != null) {
                arrayList.add(functionFindFunction);
            }
        }
        String strExtractCustomVariableKey = extractCustomVariableKey(str);
        if (strExtractCustomVariableKey != null) {
            return resolveCustomVariable(strExtractCustomVariableKey, map2, map3, arrayList, locale);
        }
        Variable variableFindVariable = findVariable(str, variableConfig.getVariableCompatibilityMap());
        if (variableFindVariable == null) {
            return "";
        }
        String value = getValue(variableFindVariable, map, variableDataProvider, packageContext, r22, subscriptionOption, locale, locale2, date, countdownTime, countFrom);
        if (value != null) {
            int size = arrayList.size();
            int i3 = 0;
            while (i3 < size) {
                Object obj = arrayList.get(i3);
                i3++;
                value = INSTANCE.processFunction(value, (Function) obj, locale);
            }
        } else {
            value = null;
        }
        if (value != null) {
            return value;
        }
        if (r22 != null) {
            failedToGetValue(Logger.INSTANCE, str, r22);
        }
        return "";
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ String processVariables$default(VariableProcessorV2 variableProcessorV2, String str, Map map, UiConfig.VariableConfig variableConfig, VariableDataProvider variableDataProvider, VariableProcessor.PackageContext packageContext, Package r23, SubscriptionOption subscriptionOption, Locale locale, Locale locale2, Date date, CountdownTime countdownTime, CountdownComponent.CountFrom countFrom, Map map2, Map map3, int i3, Object obj) {
        Locale locale3;
        Map mapEmptyMap = (i3 & 2) != 0 ? MapsKt.emptyMap() : map;
        VariableDataProvider variableDataProvider2 = (i3 & 8) != 0 ? null : variableDataProvider;
        VariableProcessor.PackageContext packageContext2 = (i3 & 16) != 0 ? null : packageContext;
        Package r8 = (i3 & 32) != 0 ? null : r23;
        SubscriptionOption subscriptionOption2 = (i3 & 64) != 0 ? null : subscriptionOption;
        if ((i3 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0) {
            Locale locale4 = Locale.getDefault();
            Intrinsics.checkNotNullExpressionValue(locale4, "getDefault()");
            locale3 = locale4;
        } else {
            locale3 = locale;
        }
        return variableProcessorV2.processVariables(str, mapEmptyMap, variableConfig, variableDataProvider2, packageContext2, r8, subscriptionOption2, locale3, locale2, (i3 & 512) != 0 ? new Date() : date, (i3 & 1024) != 0 ? null : countdownTime, (i3 & 2048) != 0 ? CountdownComponent.CountFrom.DAYS : countFrom, (i3 & 4096) != 0 ? MapsKt.emptyMap() : map2, (i3 & Utility.DEFAULT_STREAM_BUFFER_SIZE) != 0 ? MapsKt.emptyMap() : map3);
    }

    private final String relativeDiscount(VariableProcessor.PackageContext packageContext, Map<VariableLocalizationKey, String> map) {
        Double discountRelativeToMostExpensivePerMonth = packageContext.getDiscountRelativeToMostExpensivePerMonth();
        if (discountRelativeToMostExpensivePerMonth != null) {
            int iC = MathKt.c(discountRelativeToMostExpensivePerMonth.doubleValue() * ((double) PERCENT_SCALE));
            String stringOrLogError = PackagePeriodExtensionsKt.getStringOrLogError(map, VariableLocalizationKey.PERCENT);
            if (stringOrLogError != null) {
                String str = String.format(stringOrLogError, Arrays.copyOf(new Object[]{Integer.valueOf(iC)}, 1));
                Intrinsics.checkNotNullExpressionValue(str, "format(...)");
                return str;
            }
        }
        return null;
    }

    private final String replaceVariablesWithValues(String str, Function2<? super String, ? super List<String>, String> function2) {
        StringBuilder sb = new StringBuilder();
        int iH = 0;
        for (MatchResult matchResult : Regex.g(regex, str, 0, 2, null)) {
            sb.append((CharSequence) str, iH, matchResult.c().g());
            List listV0 = StringsKt.V0((String) matchResult.a().a().b().get(1), new String[]{"|"}, false, 0, 6, null);
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(listV0, 10));
            Iterator it = listV0.iterator();
            while (it.hasNext()) {
                arrayList.add(StringsKt.t1((String) it.next()).toString());
            }
            sb.append((String) function2.invoke((String) arrayList.get(0), arrayList.size() > 1 ? CollectionsKt.drop(arrayList, 1) : CollectionsKt.emptyList()));
            iH = matchResult.c().h() + 1;
        }
        sb.append((CharSequence) str, iH, str.length());
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return string;
    }

    private final String resolveCustomVariable(String str, Map<String, ? extends CustomVariableValue> map, Map<String, ? extends CustomVariableValue> map2, List<? extends Function> list, Locale locale) {
        CustomVariableValue customVariableValue = map.get(str);
        if (customVariableValue != null || (customVariableValue = map2.get(str)) != null) {
            String stringValue = customVariableValue.getStringValue();
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                stringValue = INSTANCE.processFunction(stringValue, (Function) it.next(), locale);
            }
            return stringValue;
        }
        Logger.INSTANCE.w("Custom variable '" + str + "' was not provided and has no default value. Defaulting to empty string.");
        return "";
    }

    private final void unsupportedFunctionWithoutFallback(Logger logger, String str) {
        logger.e("Paywall function '" + str + "' is not supported and no backwards compatible replacement found.");
    }

    private final void unsupportedVariableWithoutFallback(Logger logger, String str) {
        logger.e("Paywall variable '" + str + "' is not supported and no backwards compatible replacement found.");
    }

    private final void usingFallbackFunction(Logger logger, String str, String str2) {
        logger.w("Paywall function '" + str + "' is not supported. Using backward compatible '" + str2 + "' instead.");
    }

    private final void usingFallbackVariable(Logger logger, String str, String str2) {
        logger.w("Paywall variable '" + str + "' is not supported. Using backwards compatible '" + str2 + "' instead.");
    }

    public final String processVariables(String template, final Map<VariableLocalizationKey, String> localizedVariableKeys, final UiConfig.VariableConfig variableConfig, final VariableDataProvider variableDataProvider, final VariableProcessor.PackageContext packageContext, final Package r22, final SubscriptionOption subscriptionOption, final Locale currencyLocale, final Locale dateLocale, final Date date, final CountdownTime countdownTime, final CountdownComponent.CountFrom countFrom, final Map<String, ? extends CustomVariableValue> customVariables, final Map<String, ? extends CustomVariableValue> defaultCustomVariables) {
        Intrinsics.checkNotNullParameter(template, "template");
        Intrinsics.checkNotNullParameter(localizedVariableKeys, "localizedVariableKeys");
        Intrinsics.checkNotNullParameter(variableConfig, "variableConfig");
        Intrinsics.checkNotNullParameter(currencyLocale, "currencyLocale");
        Intrinsics.checkNotNullParameter(dateLocale, "dateLocale");
        Intrinsics.checkNotNullParameter(date, "date");
        Intrinsics.checkNotNullParameter(countFrom, "countFrom");
        Intrinsics.checkNotNullParameter(customVariables, "customVariables");
        Intrinsics.checkNotNullParameter(defaultCustomVariables, "defaultCustomVariables");
        return replaceVariablesWithValues(template, new Function2<String, List<? extends String>, String>() { // from class: com.revenuecat.purchases.ui.revenuecatui.data.processed.VariableProcessorV2.processVariables.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final String invoke(String variable, List<String> functions) {
                Intrinsics.checkNotNullParameter(variable, "variable");
                Intrinsics.checkNotNullParameter(functions, "functions");
                return VariableProcessorV2.INSTANCE.getVariableValue(variable, functions, localizedVariableKeys, variableConfig, variableDataProvider, packageContext, r22, subscriptionOption, currencyLocale, dateLocale, date, countdownTime, countFrom, customVariables, defaultCustomVariables);
            }
        });
    }

    private final String processFunction(String str, Function function, Locale locale) {
        int i3 = WhenMappings.$EnumSwitchMapping$2[function.ordinal()];
        if (i3 == 1) {
            String lowerCase = str.toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
            return lowerCase;
        }
        if (i3 == 2) {
            String upperCase = str.toUpperCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(upperCase, KrzujOtzIk.AooyDFnHTzX);
            return upperCase;
        }
        if (i3 != 3) {
            throw new NoWhenBranchMatchedException();
        }
        if (str.length() <= 0) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        char cCharAt = str.charAt(0);
        sb.append((Object) (Character.isLowerCase(cCharAt) ? CharsKt.d(cCharAt, locale) : String.valueOf(cCharAt)));
        String strSubstring = str.substring(1);
        Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
        sb.append(strSubstring);
        return sb.toString();
    }
}
