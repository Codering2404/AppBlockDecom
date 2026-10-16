package com.revenuecat.purchases.ui.revenuecatui.data.processed;

import com.revenuecat.purchases.Package;
import com.revenuecat.purchases.models.Period;
import com.revenuecat.purchases.models.Price;
import com.revenuecat.purchases.models.PricingPhase;
import com.revenuecat.purchases.models.StoreProduct;
import com.revenuecat.purchases.models.SubscriptionOption;
import com.revenuecat.purchases.paywalls.components.common.VariableLocalizationKey;
import java.text.DateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

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
public final class PricingPhaseExtensionsKt {
    public static final boolean canDisplay(PricingPhase pricingPhase, Period.Unit unit) {
        Intrinsics.checkNotNullParameter(pricingPhase, "<this>");
        Intrinsics.checkNotNullParameter(unit, "unit");
        return unit.ordinal() <= pricingPhase.getBillingPeriod().getUnit().ordinal();
    }

    public static final String getProductOfferPeriodInDays(PricingPhase pricingPhase) {
        Intrinsics.checkNotNullParameter(pricingPhase, "<this>");
        return productOfferPeriodInPeriodUnit(pricingPhase, Period.Unit.DAY, new Function1<Period, String>() { // from class: com.revenuecat.purchases.ui.revenuecatui.data.processed.PricingPhaseExtensionsKt$productOfferPeriodInDays$1
            @Override // kotlin.jvm.functions.Function1
            public final String invoke(Period productOfferPeriodInPeriodUnit) {
                Intrinsics.checkNotNullParameter(productOfferPeriodInPeriodUnit, "$this$productOfferPeriodInPeriodUnit");
                return PeriodExtensionsKt.getRoundedValueInDays(productOfferPeriodInPeriodUnit);
            }
        });
    }

    public static final String getProductOfferPeriodInMonths(PricingPhase pricingPhase) {
        Intrinsics.checkNotNullParameter(pricingPhase, "<this>");
        return productOfferPeriodInPeriodUnit(pricingPhase, Period.Unit.MONTH, new Function1<Period, String>() { // from class: com.revenuecat.purchases.ui.revenuecatui.data.processed.PricingPhaseExtensionsKt$productOfferPeriodInMonths$1
            @Override // kotlin.jvm.functions.Function1
            public final String invoke(Period productOfferPeriodInPeriodUnit) {
                Intrinsics.checkNotNullParameter(productOfferPeriodInPeriodUnit, "$this$productOfferPeriodInPeriodUnit");
                return PeriodExtensionsKt.getRoundedValueInMonths(productOfferPeriodInPeriodUnit);
            }
        });
    }

    public static final String getProductOfferPeriodInWeeks(PricingPhase pricingPhase) {
        Intrinsics.checkNotNullParameter(pricingPhase, "<this>");
        return productOfferPeriodInPeriodUnit(pricingPhase, Period.Unit.WEEK, new Function1<Period, String>() { // from class: com.revenuecat.purchases.ui.revenuecatui.data.processed.PricingPhaseExtensionsKt$productOfferPeriodInWeeks$1
            @Override // kotlin.jvm.functions.Function1
            public final String invoke(Period productOfferPeriodInPeriodUnit) {
                Intrinsics.checkNotNullParameter(productOfferPeriodInPeriodUnit, "$this$productOfferPeriodInPeriodUnit");
                return PeriodExtensionsKt.getRoundedValueInWeeks(productOfferPeriodInPeriodUnit);
            }
        });
    }

    public static final String getProductOfferPeriodInYears(PricingPhase pricingPhase) {
        Intrinsics.checkNotNullParameter(pricingPhase, "<this>");
        return productOfferPeriodInPeriodUnit(pricingPhase, Period.Unit.YEAR, new Function1<Period, String>() { // from class: com.revenuecat.purchases.ui.revenuecatui.data.processed.PricingPhaseExtensionsKt$productOfferPeriodInYears$1
            @Override // kotlin.jvm.functions.Function1
            public final String invoke(Period productOfferPeriodInPeriodUnit) {
                Intrinsics.checkNotNullParameter(productOfferPeriodInPeriodUnit, "$this$productOfferPeriodInPeriodUnit");
                return PeriodExtensionsKt.getRoundedValueInYears(productOfferPeriodInPeriodUnit);
            }
        });
    }

    public static final PricingPhase primaryDiscountPhase(SubscriptionOption subscriptionOption, Package r2) {
        StoreProduct product;
        if (subscriptionOption == null) {
            subscriptionOption = (r2 == null || (product = r2.getProduct()) == null) ? null : product.getDefaultOption();
        }
        if (subscriptionOption == null) {
            return null;
        }
        PricingPhase freePhase = subscriptionOption.getFreePhase();
        return freePhase == null ? subscriptionOption.getIntroPhase() : freePhase;
    }

    public static final String productOfferEndDate(PricingPhase pricingPhase, Locale locale, Date date) {
        Intrinsics.checkNotNullParameter(pricingPhase, "<this>");
        Intrinsics.checkNotNullParameter(locale, "locale");
        Intrinsics.checkNotNullParameter(date, "date");
        Calendar calendar = Calendar.getInstance(locale);
        calendar.setTime(date);
        calendar.add(6, MathKt.c(pricingPhase.getBillingPeriod().getValueInDays()));
        return DateFormat.getDateInstance(1, locale).format(calendar.getTime());
    }

    public static final String productOfferPeriod(PricingPhase pricingPhase, Map<VariableLocalizationKey, String> localizedVariableKeys) {
        Intrinsics.checkNotNullParameter(pricingPhase, "<this>");
        Intrinsics.checkNotNullParameter(localizedVariableKeys, "localizedVariableKeys");
        VariableLocalizationKey periodUnitLocalizationKey = PeriodExtensionsKt.getPeriodUnitLocalizationKey(pricingPhase.getBillingPeriod());
        if (periodUnitLocalizationKey != null) {
            return PackagePeriodExtensionsKt.getStringOrLogError(localizedVariableKeys, periodUnitLocalizationKey);
        }
        return null;
    }

    public static final String productOfferPeriodAbbreviated(PricingPhase pricingPhase, Map<VariableLocalizationKey, String> localizedVariableKeys) {
        Intrinsics.checkNotNullParameter(pricingPhase, "<this>");
        Intrinsics.checkNotNullParameter(localizedVariableKeys, "localizedVariableKeys");
        VariableLocalizationKey periodUnitAbbreviatedLocalizationKey = PeriodExtensionsKt.getPeriodUnitAbbreviatedLocalizationKey(pricingPhase.getBillingPeriod());
        if (periodUnitAbbreviatedLocalizationKey != null) {
            return PackagePeriodExtensionsKt.getStringOrLogError(localizedVariableKeys, periodUnitAbbreviatedLocalizationKey);
        }
        return null;
    }

    public static final String productOfferPeriodInPeriodUnit(PricingPhase pricingPhase, Period.Unit unit, Function1<? super Period, String> calculateValue) {
        Period billingPeriod;
        Intrinsics.checkNotNullParameter(pricingPhase, "<this>");
        Intrinsics.checkNotNullParameter(unit, "unit");
        Intrinsics.checkNotNullParameter(calculateValue, "calculateValue");
        if (!canDisplay(pricingPhase, unit)) {
            pricingPhase = null;
        }
        if (pricingPhase == null || (billingPeriod = pricingPhase.getBillingPeriod()) == null) {
            return null;
        }
        return (String) calculateValue.invoke(billingPeriod);
    }

    public static final String productOfferPeriodWithUnit(PricingPhase pricingPhase, Map<VariableLocalizationKey, String> localizedVariableKeys) {
        Intrinsics.checkNotNullParameter(pricingPhase, "<this>");
        Intrinsics.checkNotNullParameter(localizedVariableKeys, "localizedVariableKeys");
        String stringOrLogError = PackagePeriodExtensionsKt.getStringOrLogError(localizedVariableKeys, PeriodExtensionsKt.getPeriodValueWithUnitLocalizationKey(pricingPhase.getBillingPeriod()));
        if (stringOrLogError == null) {
            return null;
        }
        String str = String.format(stringOrLogError, Arrays.copyOf(new Object[]{Integer.valueOf(pricingPhase.getBillingPeriod().getValue())}, 1));
        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        return str;
    }

    public static final String productOfferPrice(PricingPhase pricingPhase, Locale locale, Map<VariableLocalizationKey, String> localizedVariableKeys) {
        Intrinsics.checkNotNullParameter(pricingPhase, "<this>");
        Intrinsics.checkNotNullParameter(locale, "locale");
        Intrinsics.checkNotNullParameter(localizedVariableKeys, "localizedVariableKeys");
        return pricingPhase.getPrice().getAmountMicros() == 0 ? PackagePeriodExtensionsKt.getStringOrLogError(localizedVariableKeys, VariableLocalizationKey.FREE_PRICE) : VariableDataProviderKt.getFormatted(pricingPhase.getPrice(), locale);
    }

    public static final String productOfferPricePerDay(PricingPhase pricingPhase, final Locale locale, Map<VariableLocalizationKey, String> localizedVariableKeys) {
        Intrinsics.checkNotNullParameter(pricingPhase, "<this>");
        Intrinsics.checkNotNullParameter(locale, "locale");
        Intrinsics.checkNotNullParameter(localizedVariableKeys, "localizedVariableKeys");
        return productOfferPricePerPeriod(pricingPhase, locale, localizedVariableKeys, Period.Unit.DAY, new Function1<PricingPhase, Price>() { // from class: com.revenuecat.purchases.ui.revenuecatui.data.processed.PricingPhaseExtensionsKt.productOfferPricePerDay.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Price invoke(PricingPhase productOfferPricePerPeriod) {
                Intrinsics.checkNotNullParameter(productOfferPricePerPeriod, "$this$productOfferPricePerPeriod");
                return productOfferPricePerPeriod.pricePerDay(locale);
            }
        });
    }

    public static final String productOfferPricePerMonth(PricingPhase pricingPhase, final Locale locale, Map<VariableLocalizationKey, String> localizedVariableKeys) {
        Intrinsics.checkNotNullParameter(pricingPhase, "<this>");
        Intrinsics.checkNotNullParameter(locale, "locale");
        Intrinsics.checkNotNullParameter(localizedVariableKeys, "localizedVariableKeys");
        return productOfferPricePerPeriod(pricingPhase, locale, localizedVariableKeys, Period.Unit.MONTH, new Function1<PricingPhase, Price>() { // from class: com.revenuecat.purchases.ui.revenuecatui.data.processed.PricingPhaseExtensionsKt.productOfferPricePerMonth.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Price invoke(PricingPhase productOfferPricePerPeriod) {
                Intrinsics.checkNotNullParameter(productOfferPricePerPeriod, "$this$productOfferPricePerPeriod");
                return productOfferPricePerPeriod.pricePerMonth(locale);
            }
        });
    }

    public static final String productOfferPricePerPeriod(PricingPhase pricingPhase, Locale locale, Map<VariableLocalizationKey, String> localizedVariableKeys, Period.Unit unit, Function1<? super PricingPhase, Price> calculatePrice) {
        Price price;
        Intrinsics.checkNotNullParameter(pricingPhase, "<this>");
        Intrinsics.checkNotNullParameter(locale, "locale");
        Intrinsics.checkNotNullParameter(localizedVariableKeys, "localizedVariableKeys");
        Intrinsics.checkNotNullParameter(unit, "unit");
        Intrinsics.checkNotNullParameter(calculatePrice, "calculatePrice");
        if (!canDisplay(pricingPhase, unit)) {
            pricingPhase = null;
        }
        if (pricingPhase == null || (price = (Price) calculatePrice.invoke(pricingPhase)) == null) {
            return null;
        }
        return price.getAmountMicros() == 0 ? PackagePeriodExtensionsKt.getStringOrLogError(localizedVariableKeys, VariableLocalizationKey.FREE_PRICE) : VariableDataProviderKt.getFormatted(price, locale);
    }

    public static final String productOfferPricePerWeek(PricingPhase pricingPhase, final Locale locale, Map<VariableLocalizationKey, String> localizedVariableKeys) {
        Intrinsics.checkNotNullParameter(pricingPhase, "<this>");
        Intrinsics.checkNotNullParameter(locale, "locale");
        Intrinsics.checkNotNullParameter(localizedVariableKeys, "localizedVariableKeys");
        return productOfferPricePerPeriod(pricingPhase, locale, localizedVariableKeys, Period.Unit.WEEK, new Function1<PricingPhase, Price>() { // from class: com.revenuecat.purchases.ui.revenuecatui.data.processed.PricingPhaseExtensionsKt.productOfferPricePerWeek.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Price invoke(PricingPhase productOfferPricePerPeriod) {
                Intrinsics.checkNotNullParameter(productOfferPricePerPeriod, "$this$productOfferPricePerPeriod");
                return productOfferPricePerPeriod.pricePerWeek(locale);
            }
        });
    }

    public static final String productOfferPricePerYear(PricingPhase pricingPhase, final Locale locale, Map<VariableLocalizationKey, String> localizedVariableKeys) {
        Intrinsics.checkNotNullParameter(pricingPhase, "<this>");
        Intrinsics.checkNotNullParameter(locale, "locale");
        Intrinsics.checkNotNullParameter(localizedVariableKeys, "localizedVariableKeys");
        return productOfferPricePerPeriod(pricingPhase, locale, localizedVariableKeys, Period.Unit.YEAR, new Function1<PricingPhase, Price>() { // from class: com.revenuecat.purchases.ui.revenuecatui.data.processed.PricingPhaseExtensionsKt.productOfferPricePerYear.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Price invoke(PricingPhase productOfferPricePerPeriod) {
                Intrinsics.checkNotNullParameter(productOfferPricePerPeriod, "$this$productOfferPricePerPeriod");
                return productOfferPricePerPeriod.pricePerYear(locale);
            }
        });
    }

    public static final String resolveOfferPeriod(PricingPhase pricingPhase, Function1<? super PricingPhase, String> discountValue, Function0<String> productFallback) {
        String str;
        Intrinsics.checkNotNullParameter(discountValue, "discountValue");
        Intrinsics.checkNotNullParameter(productFallback, "productFallback");
        return (pricingPhase == null || (str = (String) discountValue.invoke(pricingPhase)) == null) ? (String) productFallback.invoke() : str;
    }

    public static final String resolveOfferPrice(PricingPhase pricingPhase, Locale locale, Map<VariableLocalizationKey, String> localizedVariableKeys, Function0<String> productFallback) {
        String strProductOfferPrice;
        Intrinsics.checkNotNullParameter(locale, "locale");
        Intrinsics.checkNotNullParameter(localizedVariableKeys, "localizedVariableKeys");
        Intrinsics.checkNotNullParameter(productFallback, "productFallback");
        return (pricingPhase == null || (strProductOfferPrice = productOfferPrice(pricingPhase, locale, localizedVariableKeys)) == null) ? (String) productFallback.invoke() : strProductOfferPrice;
    }

    public static final PricingPhase secondaryDiscountPhase(SubscriptionOption subscriptionOption, Package r2) {
        StoreProduct product;
        if (subscriptionOption == null) {
            subscriptionOption = (r2 == null || (product = r2.getProduct()) == null) ? null : product.getDefaultOption();
        }
        if (subscriptionOption == null || subscriptionOption.getFreePhase() == null) {
            return null;
        }
        return subscriptionOption.getIntroPhase();
    }
}
