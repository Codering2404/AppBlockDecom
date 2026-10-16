package com.revenuecat.purchases.utils;

import com.revenuecat.purchases.models.Period;
import com.revenuecat.purchases.models.Price;
import java.util.Locale;
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
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class PriceExtensionsKt {
    public static final /* synthetic */ Price pricePerDay(Price price, Period billingPeriod, Locale locale) {
        Intrinsics.checkNotNullParameter(price, "<this>");
        Intrinsics.checkNotNullParameter(billingPeriod, "billingPeriod");
        Intrinsics.checkNotNullParameter(locale, "locale");
        return pricePerPeriod(price, billingPeriod.getValueInDays(), locale);
    }

    public static final Price pricePerMonth(Price price, Period billingPeriod, Locale locale) {
        Intrinsics.checkNotNullParameter(price, "<this>");
        Intrinsics.checkNotNullParameter(billingPeriod, "billingPeriod");
        Intrinsics.checkNotNullParameter(locale, "locale");
        return pricePerPeriod(price, billingPeriod.getValueInMonths(), locale);
    }

    private static final Price pricePerPeriod(Price price, double d3, Locale locale) {
        return PriceFactory.INSTANCE.createPrice$purchases_defaultsBc8Release((long) (price.getAmountMicros() / d3), price.getCurrencyCode(), locale);
    }

    public static final Price pricePerWeek(Price price, Period billingPeriod, Locale locale) {
        Intrinsics.checkNotNullParameter(price, "<this>");
        Intrinsics.checkNotNullParameter(billingPeriod, "billingPeriod");
        Intrinsics.checkNotNullParameter(locale, "locale");
        return pricePerPeriod(price, billingPeriod.getValueInWeeks(), locale);
    }

    public static final Price pricePerYear(Price price, Period billingPeriod, Locale locale) {
        Intrinsics.checkNotNullParameter(price, "<this>");
        Intrinsics.checkNotNullParameter(billingPeriod, "billingPeriod");
        Intrinsics.checkNotNullParameter(locale, "locale");
        return pricePerPeriod(price, billingPeriod.getValueInYears(), locale);
    }
}
