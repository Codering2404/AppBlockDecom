package com.revenuecat.purchases.ui.revenuecatui.data.processed;

import com.revenuecat.purchases.models.Period;
import com.revenuecat.purchases.models.Price;
import com.revenuecat.purchases.ui.revenuecatui.R;
import com.revenuecat.purchases.ui.revenuecatui.data.processed.TemplateConfiguration;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ResourceProvider;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.NumberFormat;
import java.util.Currency;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;

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
public final class VariableDataProviderKt {
    private static final double MICRO_MULTIPLIER = 1000000.0d;

    public static final boolean endsIn00Cents(Price price) {
        Intrinsics.checkNotNullParameter(price, "<this>");
        double d3 = 100;
        return ((((double) Math.round((((double) price.getAmountMicros()) / 1000000.0d) * d3)) / 100.0d) * d3) % d3 == 0.0d;
    }

    public static final String getFormatted(Price price, Locale locale) {
        Intrinsics.checkNotNullParameter(price, "<this>");
        Intrinsics.checkNotNullParameter(locale, "locale");
        Currency currency = Currency.getInstance(price.getCurrencyCode());
        int iF = RangesKt.f(currency.getDefaultFractionDigits(), 0);
        NumberFormat currencyInstance = NumberFormat.getCurrencyInstance(locale);
        currencyInstance.setCurrency(currency);
        currencyInstance.setMaximumFractionDigits(iF);
        currencyInstance.setMinimumFractionDigits(iF);
        String str = currencyInstance.format(BigDecimal.valueOf(price.getAmountMicros()).divide(BigDecimal.valueOf(1000000L), iF, RoundingMode.DOWN));
        Intrinsics.checkNotNullExpressionValue(str, "numberFormat.format(amount)");
        return str;
    }

    public static /* synthetic */ String getFormatted$default(Price price, Locale locale, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            locale = Locale.getDefault();
            Intrinsics.checkNotNullExpressionValue(locale, "getDefault()");
        }
        return getFormatted(price, locale);
    }

    public static final String getTruncatedFormatted(Price price, Locale locale) {
        Intrinsics.checkNotNullParameter(price, "<this>");
        Intrinsics.checkNotNullParameter(locale, "locale");
        NumberFormat currencyInstance = NumberFormat.getCurrencyInstance(locale);
        currencyInstance.setCurrency(Currency.getInstance(price.getCurrencyCode()));
        currencyInstance.setMaximumFractionDigits(0);
        String str = currencyInstance.format(price.getAmountMicros() / 1000000.0d);
        Intrinsics.checkNotNullExpressionValue(str, "numberFormat.format(amount)");
        return str;
    }

    public static /* synthetic */ String getTruncatedFormatted$default(Price price, Locale locale, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            locale = Locale.getDefault();
            Intrinsics.checkNotNullExpressionValue(locale, "getDefault()");
        }
        return getTruncatedFormatted(price, locale);
    }

    public static final String localizedDiscount(TemplateConfiguration.PackageInfo packageInfo, ResourceProvider resourceProvider) {
        Intrinsics.checkNotNullParameter(packageInfo, "<this>");
        Intrinsics.checkNotNullParameter(resourceProvider, "resourceProvider");
        return localizedDiscount(resourceProvider, packageInfo.getDiscountRelativeToMostExpensivePerMonth());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Period normalizedMonths(Period period) {
        if (period.getUnit() != Period.Unit.YEAR) {
            return period;
        }
        int value = period.getValue() * 12;
        Period.Unit unit = Period.Unit.MONTH;
        StringBuilder sb = new StringBuilder();
        sb.append('P');
        sb.append(value);
        sb.append('M');
        return new Period(value, unit, sb.toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String localizedDiscount(ResourceProvider resourceProvider, Double d3) {
        if (d3 == null) {
            return null;
        }
        return resourceProvider.getString(R.string.package_discount, Integer.valueOf(MathKt.c(d3.doubleValue() * 100.0d)));
    }
}
