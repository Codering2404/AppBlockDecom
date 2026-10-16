package com.revenuecat.purchases.models;

import com.applovin.impl.mediation.nativeAds.xNe.qRMDmh;
import com.revenuecat.purchases.PresentedOfferingContext;
import com.revenuecat.purchases.ProductType;
import com.revenuecat.purchases.utils.PriceExtensionsKt;
import java.util.Locale;
import kotlin.Deprecated;
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
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
@Metadata
public interface StoreProduct {
    static /* synthetic */ String formattedPricePerMonth$default(StoreProduct storeProduct, Locale locale, int i3, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: formattedPricePerMonth");
        }
        if ((i3 & 1) != 0) {
            locale = Locale.getDefault();
            Intrinsics.checkNotNullExpressionValue(locale, "getDefault()");
        }
        return storeProduct.formattedPricePerMonth(locale);
    }

    static /* synthetic */ Price pricePerDay$default(StoreProduct storeProduct, Locale locale, int i3, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: pricePerDay");
        }
        if ((i3 & 1) != 0) {
            locale = Locale.getDefault();
            Intrinsics.checkNotNullExpressionValue(locale, "getDefault()");
        }
        return storeProduct.pricePerDay(locale);
    }

    static /* synthetic */ Price pricePerMonth$default(StoreProduct storeProduct, Locale locale, int i3, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: pricePerMonth");
        }
        if ((i3 & 1) != 0) {
            locale = Locale.getDefault();
            Intrinsics.checkNotNullExpressionValue(locale, "getDefault()");
        }
        return storeProduct.pricePerMonth(locale);
    }

    static /* synthetic */ Price pricePerWeek$default(StoreProduct storeProduct, Locale locale, int i3, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: pricePerWeek");
        }
        if ((i3 & 1) != 0) {
            locale = Locale.getDefault();
            Intrinsics.checkNotNullExpressionValue(locale, "getDefault()");
        }
        return storeProduct.pricePerWeek(locale);
    }

    static /* synthetic */ Price pricePerYear$default(StoreProduct storeProduct, Locale locale, int i3, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: pricePerYear");
        }
        if ((i3 & 1) != 0) {
            locale = Locale.getDefault();
            Intrinsics.checkNotNullExpressionValue(locale, "getDefault()");
        }
        return storeProduct.pricePerYear(locale);
    }

    @Deprecated
    StoreProduct copyWithOfferingId(String str);

    StoreProduct copyWithPresentedOfferingContext(PresentedOfferingContext presentedOfferingContext);

    default String formattedPricePerMonth(Locale locale) {
        Intrinsics.checkNotNullParameter(locale, "locale");
        Price pricePricePerMonth = pricePerMonth(locale);
        if (pricePricePerMonth != null) {
            return pricePricePerMonth.getFormatted();
        }
        return null;
    }

    SubscriptionOption getDefaultOption();

    String getDescription();

    String getId();

    String getName();

    Period getPeriod();

    PresentedOfferingContext getPresentedOfferingContext();

    String getPresentedOfferingIdentifier();

    Price getPrice();

    PurchasingData getPurchasingData();

    String getSku();

    SubscriptionOptions getSubscriptionOptions();

    String getTitle();

    ProductType getType();

    default Price pricePerMonth(Locale locale) {
        Intrinsics.checkNotNullParameter(locale, "locale");
        Period period = getPeriod();
        if (period != null) {
            return PriceExtensionsKt.pricePerMonth(getPrice(), period, locale);
        }
        return null;
    }

    default Price pricePerWeek(Locale locale) {
        Intrinsics.checkNotNullParameter(locale, "locale");
        Period period = getPeriod();
        if (period != null) {
            return PriceExtensionsKt.pricePerWeek(getPrice(), period, locale);
        }
        return null;
    }

    default Price pricePerYear(Locale locale) {
        Intrinsics.checkNotNullParameter(locale, "locale");
        Period period = getPeriod();
        if (period != null) {
            return PriceExtensionsKt.pricePerYear(getPrice(), period, locale);
        }
        return null;
    }

    default Price pricePerDay(Locale locale) {
        Intrinsics.checkNotNullParameter(locale, qRMDmh.ANQBozLy);
        Period period = getPeriod();
        if (period != null) {
            return PriceExtensionsKt.pricePerDay(getPrice(), period, locale);
        }
        return null;
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class DefaultImpls {
        @Deprecated
        public static String formattedPricePerMonth(StoreProduct storeProduct, Locale locale) {
            Intrinsics.checkNotNullParameter(locale, "locale");
            return StoreProduct.super.formattedPricePerMonth(locale);
        }

        @Deprecated
        public static Price pricePerDay(StoreProduct storeProduct, Locale locale) {
            Intrinsics.checkNotNullParameter(locale, "locale");
            return StoreProduct.super.pricePerDay(locale);
        }

        @Deprecated
        public static Price pricePerMonth(StoreProduct storeProduct, Locale locale) {
            Intrinsics.checkNotNullParameter(locale, "locale");
            return StoreProduct.super.pricePerMonth(locale);
        }

        @Deprecated
        public static Price pricePerWeek(StoreProduct storeProduct, Locale locale) {
            Intrinsics.checkNotNullParameter(locale, "locale");
            return StoreProduct.super.pricePerWeek(locale);
        }

        @Deprecated
        public static Price pricePerYear(StoreProduct storeProduct, Locale locale) {
            Intrinsics.checkNotNullParameter(locale, "locale");
            return StoreProduct.super.pricePerYear(locale);
        }

        @Deprecated
        public static /* synthetic */ void getPresentedOfferingIdentifier$annotations() {
        }

        @Deprecated
        public static /* synthetic */ void getSku$annotations() {
        }
    }
}
