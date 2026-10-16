package com.revenuecat.purchases.utils;

import com.revenuecat.purchases.models.Price;
import java.text.NumberFormat;
import java.util.Currency;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
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
public final class PriceFactory {
    public static final PriceFactory INSTANCE = new PriceFactory();

    private PriceFactory() {
    }

    public final /* synthetic */ Price createPrice$purchases_defaultsBc8Release(long j3, String currencyCode, Locale locale) {
        Intrinsics.checkNotNullParameter(currencyCode, "currencyCode");
        Intrinsics.checkNotNullParameter(locale, "locale");
        Currency currency = Currency.getInstance(currencyCode);
        int iF = RangesKt.f(currency.getDefaultFractionDigits(), 0);
        double dRoundToDecimalPlaces = DoubleExtensionsKt.roundToDecimalPlaces(j3 / 1000000.0d, iF);
        NumberFormat currencyInstance = NumberFormat.getCurrencyInstance(locale);
        currencyInstance.setCurrency(currency);
        currencyInstance.setMaximumFractionDigits(iF);
        currencyInstance.setMinimumFractionDigits(iF);
        String formatted = currencyInstance.format(dRoundToDecimalPlaces);
        Intrinsics.checkNotNullExpressionValue(formatted, "formatted");
        return new Price(formatted, j3, currencyCode);
    }
}
