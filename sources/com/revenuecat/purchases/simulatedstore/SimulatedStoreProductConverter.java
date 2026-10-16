package com.revenuecat.purchases.simulatedstore;

import com.revenuecat.purchases.PurchasesError;
import com.revenuecat.purchases.PurchasesErrorCode;
import com.revenuecat.purchases.PurchasesException;
import com.revenuecat.purchases.common.networking.WebBillingPhase;
import com.revenuecat.purchases.common.networking.WebBillingPrice;
import com.revenuecat.purchases.common.networking.WebBillingProductResponse;
import com.revenuecat.purchases.common.networking.WebBillingPurchaseOption;
import com.revenuecat.purchases.models.Period;
import com.revenuecat.purchases.models.Price;
import com.revenuecat.purchases.models.PricingPhase;
import com.revenuecat.purchases.models.RecurrenceMode;
import com.revenuecat.purchases.models.TestStoreProduct;
import com.revenuecat.purchases.utils.PriceFactory;
import com.sun.jna.Function;
import io.reactivex.internal.operators.mixed.yrog.FptyjHFU;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
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
/* JADX INFO: loaded from: classes6.dex */
@Metadata
public final class SimulatedStoreProductConverter {
    public static final SimulatedStoreProductConverter INSTANCE = new SimulatedStoreProductConverter();

    private SimulatedStoreProductConverter() {
    }

    public static /* synthetic */ TestStoreProduct convertToStoreProduct$default(SimulatedStoreProductConverter simulatedStoreProductConverter, WebBillingProductResponse webBillingProductResponse, Locale locale, int i3, Object obj) throws PurchasesException {
        if ((i3 & 2) != 0) {
            locale = Locale.getDefault();
            Intrinsics.checkNotNullExpressionValue(locale, "getDefault()");
        }
        return simulatedStoreProductConverter.convertToStoreProduct(webBillingProductResponse, locale);
    }

    public final /* synthetic */ TestStoreProduct convertToStoreProduct(WebBillingProductResponse productResponse, Locale locale) throws PurchasesException {
        PricingPhase pricingPhase;
        Price priceCreatePrice$purchases_defaultsBc8Release;
        Period period;
        PricingPhase pricingPhase2;
        Intrinsics.checkNotNullParameter(productResponse, "productResponse");
        Intrinsics.checkNotNullParameter(locale, "locale");
        String defaultPurchaseOptionId = productResponse.getDefaultPurchaseOptionId();
        Map<String, WebBillingPurchaseOption> purchaseOptions = productResponse.getPurchaseOptions();
        if (defaultPurchaseOptionId == null) {
            defaultPurchaseOptionId = (String) CollectionsKt.first(purchaseOptions.keySet());
        }
        WebBillingPurchaseOption webBillingPurchaseOption = purchaseOptions.get(defaultPurchaseOptionId);
        if (webBillingPurchaseOption == null) {
            throw new PurchasesException(new PurchasesError(PurchasesErrorCode.ProductNotAvailableForPurchaseError, "No purchase option found for product " + productResponse.getIdentifier()));
        }
        PricingPhase pricingPhase3 = null;
        if (webBillingPurchaseOption.getBasePrice() != null) {
            WebBillingPrice basePrice = webBillingPurchaseOption.getBasePrice();
            priceCreatePrice$purchases_defaultsBc8Release = PriceFactory.INSTANCE.createPrice$purchases_defaultsBc8Release(basePrice.getAmountMicros(), basePrice.getCurrency(), locale);
            period = null;
            pricingPhase2 = null;
            pricingPhase = null;
        } else {
            WebBillingPhase base = webBillingPurchaseOption.getBase();
            if ((base != null ? base.getPrice() : null) == null) {
                throw new PurchasesException(new PurchasesError(PurchasesErrorCode.ProductNotAvailableForPurchaseError, "Base price is required for test subscription products"));
            }
            WebBillingPrice price = base.getPrice();
            PriceFactory priceFactory = PriceFactory.INSTANCE;
            Price priceCreatePrice$purchases_defaultsBc8Release2 = priceFactory.createPrice$purchases_defaultsBc8Release(price.getAmountMicros(), price.getCurrency(), locale);
            Period periodCreate = base.getPeriodDuration() != null ? Period.Factory.create(base.getPeriodDuration()) : null;
            WebBillingPhase trial = webBillingPurchaseOption.getTrial();
            PricingPhase pricingPhase4 = (trial != null ? trial.getPeriodDuration() : null) != null ? new PricingPhase(Period.Factory.create(trial.getPeriodDuration()), RecurrenceMode.FINITE_RECURRING, Integer.valueOf(trial.getCycleCount()), priceFactory.createPrice$purchases_defaultsBc8Release(0L, base.getPrice().getCurrency(), locale)) : null;
            WebBillingPhase introPrice = webBillingPurchaseOption.getIntroPrice();
            if ((introPrice != null ? introPrice.getPrice() : null) != null && introPrice.getPeriodDuration() != null) {
                WebBillingPrice price2 = introPrice.getPrice();
                pricingPhase3 = new PricingPhase(Period.Factory.create(introPrice.getPeriodDuration()), RecurrenceMode.FINITE_RECURRING, Integer.valueOf(introPrice.getCycleCount()), priceFactory.createPrice$purchases_defaultsBc8Release(price2.getAmountMicros(), price2.getCurrency(), locale));
            }
            pricingPhase = pricingPhase3;
            priceCreatePrice$purchases_defaultsBc8Release = priceCreatePrice$purchases_defaultsBc8Release2;
            period = periodCreate;
            pricingPhase2 = pricingPhase4;
        }
        String identifier = productResponse.getIdentifier();
        String title = productResponse.getTitle();
        String title2 = productResponse.getTitle();
        String description = productResponse.getDescription();
        if (description == null) {
            description = FptyjHFU.cKmjBwwyNiJYd;
        }
        return new TestStoreProduct(identifier, title, title2, description, priceCreatePrice$purchases_defaultsBc8Release, period, pricingPhase2, pricingPhase, null, Function.MAX_NARGS, null);
    }
}
