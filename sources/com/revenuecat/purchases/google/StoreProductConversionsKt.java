package com.revenuecat.purchases.google;

import com.android.billingclient.api.ProductDetails;
import com.revenuecat.purchases.LogHandler;
import com.revenuecat.purchases.LogLevel;
import com.revenuecat.purchases.PresentedOfferingContext;
import com.revenuecat.purchases.ProductType;
import com.revenuecat.purchases.common.Config;
import com.revenuecat.purchases.common.LogIntent;
import com.revenuecat.purchases.common.LogWrapperKt;
import com.revenuecat.purchases.models.GoogleStoreProduct;
import com.revenuecat.purchases.models.Price;
import com.revenuecat.purchases.models.PricingPhase;
import com.revenuecat.purchases.models.StoreProduct;
import com.revenuecat.purchases.models.SubscriptionOption;
import com.revenuecat.purchases.models.SubscriptionOptions;
import com.revenuecat.purchases.strings.PurchaseStrings;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
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
public final class StoreProductConversionsKt {
    private static final Price createOneTimeProductPrice(ProductDetails productDetails) {
        ProductDetails.OneTimePurchaseOfferDetails oneTimePurchaseOfferDetailsC;
        if (ProductTypeConversionsKt.toRevenueCatProductType(productDetails.f()) != ProductType.INAPP || (oneTimePurchaseOfferDetailsC = productDetails.c()) == null) {
            return null;
        }
        String strA = oneTimePurchaseOfferDetailsC.a();
        Intrinsics.checkNotNullExpressionValue(strA, "it.formattedPrice");
        long jD = oneTimePurchaseOfferDetailsC.d();
        String strE = oneTimePurchaseOfferDetailsC.e();
        Intrinsics.checkNotNullExpressionValue(strE, "it.priceCurrencyCode");
        return new Price(strA, jD, strE);
    }

    public static final StoreProduct toInAppStoreProduct(ProductDetails productDetails) {
        Intrinsics.checkNotNullParameter(productDetails, "<this>");
        return toStoreProduct(productDetails, CollectionsKt.emptyList());
    }

    public static final GoogleStoreProduct toStoreProduct(ProductDetails productDetails, List<ProductDetails.SubscriptionOfferDetails> offerDetails) {
        SubscriptionOptions subscriptionOptions;
        PricingPhase fullPricePhase;
        Intrinsics.checkNotNullParameter(productDetails, "<this>");
        Intrinsics.checkNotNullParameter(offerDetails, "offerDetails");
        if (ProductTypeConversionsKt.toRevenueCatProductType(productDetails.f()) == ProductType.SUBS) {
            List<ProductDetails.SubscriptionOfferDetails> list = offerDetails;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            for (ProductDetails.SubscriptionOfferDetails subscriptionOfferDetails : list) {
                String productId = productDetails.e();
                Intrinsics.checkNotNullExpressionValue(productId, "productId");
                arrayList.add(SubscriptionOptionConversionsKt.toSubscriptionOption(subscriptionOfferDetails, productId, productDetails));
            }
            subscriptionOptions = new SubscriptionOptions(arrayList);
        } else {
            subscriptionOptions = null;
        }
        SubscriptionOption basePlan = subscriptionOptions != null ? subscriptionOptions.getBasePlan() : null;
        Price price = (basePlan == null || (fullPricePhase = basePlan.getFullPricePhase()) == null) ? null : fullPricePhase.getPrice();
        Price priceCreateOneTimeProductPrice = createOneTimeProductPrice(productDetails);
        if (priceCreateOneTimeProductPrice != null) {
            price = priceCreateOneTimeProductPrice;
        } else if (price == null) {
            return null;
        }
        SubscriptionOption subscriptionOption = basePlan;
        Price price2 = price;
        String productId2 = productDetails.e();
        Intrinsics.checkNotNullExpressionValue(productId2, "productId");
        String id = subscriptionOption != null ? subscriptionOption.getId() : null;
        ProductType revenueCatProductType = ProductTypeConversionsKt.toRevenueCatProductType(productDetails.f());
        String name = productDetails.b();
        Intrinsics.checkNotNullExpressionValue(name, "name");
        String str = id;
        String title = productDetails.h();
        Intrinsics.checkNotNullExpressionValue(title, "title");
        String description = productDetails.a();
        Intrinsics.checkNotNullExpressionValue(description, "description");
        return new GoogleStoreProduct(productId2, str, revenueCatProductType, price2, name, title, description, subscriptionOption != null ? subscriptionOption.getBillingPeriod() : null, subscriptionOptions, subscriptionOptions != null ? subscriptionOptions.getDefaultOffer() : null, productDetails, (PresentedOfferingContext) null);
    }

    public static final List<StoreProduct> toStoreProducts(List<ProductDetails> list) {
        List listEmptyList;
        Map mapEmptyMap;
        LogHandler currentLogHandler;
        String str;
        String str2;
        Intrinsics.checkNotNullParameter(list, "<this>");
        ArrayList arrayList = new ArrayList();
        for (final ProductDetails productDetails : list) {
            List subscriptionOfferDetails = productDetails.g();
            if (subscriptionOfferDetails != null) {
                Intrinsics.checkNotNullExpressionValue(subscriptionOfferDetails, "subscriptionOfferDetails");
                listEmptyList = new ArrayList();
                for (Object obj : subscriptionOfferDetails) {
                    ProductDetails.SubscriptionOfferDetails it = (ProductDetails.SubscriptionOfferDetails) obj;
                    Intrinsics.checkNotNullExpressionValue(it, "it");
                    if (SubscriptionOptionConversionsKt.isBasePlan(it)) {
                        listEmptyList.add(obj);
                    }
                }
            } else {
                listEmptyList = CollectionsKt.emptyList();
            }
            List subscriptionOfferDetails2 = productDetails.g();
            if (subscriptionOfferDetails2 != null) {
                Intrinsics.checkNotNullExpressionValue(subscriptionOfferDetails2, "subscriptionOfferDetails");
                mapEmptyMap = new LinkedHashMap();
                for (Object obj2 : subscriptionOfferDetails2) {
                    String strA = ((ProductDetails.SubscriptionOfferDetails) obj2).a();
                    Object arrayList2 = mapEmptyMap.get(strA);
                    if (arrayList2 == null) {
                        arrayList2 = new ArrayList();
                        mapEmptyMap.put(strA, arrayList2);
                    }
                    ((List) arrayList2).add(obj2);
                }
            } else {
                mapEmptyMap = MapsKt.emptyMap();
            }
            if (listEmptyList.isEmpty()) {
                listEmptyList = null;
            }
            if (listEmptyList != null) {
                Iterator it2 = listEmptyList.iterator();
                while (it2.hasNext()) {
                    List listEmptyList2 = (List) mapEmptyMap.get(((ProductDetails.SubscriptionOfferDetails) it2.next()).a());
                    if (listEmptyList2 == null) {
                        listEmptyList2 = CollectionsKt.emptyList();
                    }
                    GoogleStoreProduct storeProduct = toStoreProduct(productDetails, listEmptyList2);
                    if (storeProduct != null) {
                        arrayList.add(storeProduct);
                    } else {
                        final LogIntent logIntent = LogIntent.RC_ERROR;
                        Function0<String> function0 = new Function0<String>() { // from class: com.revenuecat.purchases.google.StoreProductConversionsKt$toStoreProducts$lambda$10$lambda$7$$inlined$log$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(0);
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public final String invoke() {
                                StringBuilder sb = new StringBuilder();
                                sb.append(CollectionsKt.joinToString$default(logIntent.getEmojiList(), "", null, null, 0, null, null, 62, null));
                                sb.append(' ');
                                String str3 = String.format(PurchaseStrings.INVALID_PRODUCT_NO_PRICE, Arrays.copyOf(new Object[]{productDetails.e()}, 1));
                                Intrinsics.checkNotNullExpressionValue(str3, "format(...)");
                                sb.append(str3);
                                return sb.toString();
                            }
                        };
                        switch (LogWrapperKt.WhenMappings.$EnumSwitchMapping$0[logIntent.ordinal()]) {
                            case 1:
                                LogLevel logLevel = LogLevel.DEBUG;
                                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                                if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                                    str = "[Purchases] - " + logLevel.name();
                                    str2 = (String) function0.invoke();
                                    currentLogHandler.d(str, str2);
                                }
                                break;
                            case 2:
                                LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) function0.invoke(), null);
                                break;
                            case 3:
                                LogLevel logLevel2 = LogLevel.WARN;
                                LogHandler currentLogHandler2 = LogWrapperKt.getCurrentLogHandler();
                                if (Config.INSTANCE.getLogLevel().compareTo(logLevel2) <= 0) {
                                    currentLogHandler2.w("[Purchases] - " + logLevel2.name(), (String) function0.invoke());
                                }
                                break;
                            case 4:
                                LogLevel logLevel3 = LogLevel.INFO;
                                LogHandler currentLogHandler3 = LogWrapperKt.getCurrentLogHandler();
                                if (Config.INSTANCE.getLogLevel().compareTo(logLevel3) <= 0) {
                                    currentLogHandler3.i("[Purchases] - " + logLevel3.name(), (String) function0.invoke());
                                }
                                break;
                            case 5:
                                LogLevel logLevel4 = LogLevel.DEBUG;
                                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                                if (Config.INSTANCE.getLogLevel().compareTo(logLevel4) <= 0) {
                                    str = "[Purchases] - " + logLevel4.name();
                                    str2 = (String) function0.invoke();
                                    currentLogHandler.d(str, str2);
                                }
                                break;
                            case 6:
                                LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) function0.invoke(), null);
                                break;
                            case 7:
                                LogLevel logLevel5 = LogLevel.INFO;
                                LogHandler currentLogHandler4 = LogWrapperKt.getCurrentLogHandler();
                                if (Config.INSTANCE.getLogLevel().compareTo(logLevel5) <= 0) {
                                    currentLogHandler4.i("[Purchases] - " + logLevel5.name(), (String) function0.invoke());
                                }
                                break;
                            case 8:
                                LogLevel logLevel6 = LogLevel.DEBUG;
                                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                                if (Config.INSTANCE.getLogLevel().compareTo(logLevel6) <= 0) {
                                    str = "[Purchases] - " + logLevel6.name();
                                    str2 = (String) function0.invoke();
                                    currentLogHandler.d(str, str2);
                                }
                                break;
                            case 9:
                                LogLevel logLevel7 = LogLevel.DEBUG;
                                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                                if (Config.INSTANCE.getLogLevel().compareTo(logLevel7) <= 0) {
                                    str = "[Purchases] - " + logLevel7.name();
                                    str2 = (String) function0.invoke();
                                    currentLogHandler.d(str, str2);
                                }
                                break;
                            case 10:
                                LogLevel logLevel8 = LogLevel.WARN;
                                LogHandler currentLogHandler5 = LogWrapperKt.getCurrentLogHandler();
                                if (Config.INSTANCE.getLogLevel().compareTo(logLevel8) <= 0) {
                                    currentLogHandler5.w("[Purchases] - " + logLevel8.name(), (String) function0.invoke());
                                }
                                break;
                            case 11:
                                LogLevel logLevel9 = LogLevel.WARN;
                                LogHandler currentLogHandler6 = LogWrapperKt.getCurrentLogHandler();
                                if (Config.INSTANCE.getLogLevel().compareTo(logLevel9) <= 0) {
                                    currentLogHandler6.w("[Purchases] - " + logLevel9.name(), (String) function0.invoke());
                                }
                                break;
                            case 12:
                                LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) function0.invoke(), null);
                                break;
                            case 13:
                                LogLevel logLevel10 = LogLevel.WARN;
                                LogHandler currentLogHandler7 = LogWrapperKt.getCurrentLogHandler();
                                if (Config.INSTANCE.getLogLevel().compareTo(logLevel10) <= 0) {
                                    currentLogHandler7.w("[Purchases] - " + logLevel10.name(), (String) function0.invoke());
                                }
                                break;
                            case 14:
                                LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) function0.invoke(), null);
                                break;
                        }
                        Unit unit = Unit.f139807a;
                    }
                }
                Unit unit2 = Unit.f139807a;
            } else {
                StoreProduct inAppStoreProduct = toInAppStoreProduct(productDetails);
                if (inAppStoreProduct != null) {
                    arrayList.add(inAppStoreProduct);
                } else {
                    final LogIntent logIntent2 = LogIntent.RC_ERROR;
                    Function0<String> function02 = new Function0<String>() { // from class: com.revenuecat.purchases.google.StoreProductConversionsKt$toStoreProducts$lambda$10$$inlined$log$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public final String invoke() {
                            StringBuilder sb = new StringBuilder();
                            sb.append(CollectionsKt.joinToString$default(logIntent2.getEmojiList(), "", null, null, 0, null, null, 62, null));
                            sb.append(' ');
                            String str3 = String.format(PurchaseStrings.INVALID_PRODUCT_NO_PRICE, Arrays.copyOf(new Object[]{productDetails.e()}, 1));
                            Intrinsics.checkNotNullExpressionValue(str3, "format(...)");
                            sb.append(str3);
                            return sb.toString();
                        }
                    };
                    switch (LogWrapperKt.WhenMappings.$EnumSwitchMapping$0[logIntent2.ordinal()]) {
                        case 1:
                            LogLevel logLevel11 = LogLevel.DEBUG;
                            LogHandler currentLogHandler8 = LogWrapperKt.getCurrentLogHandler();
                            if (Config.INSTANCE.getLogLevel().compareTo(logLevel11) <= 0) {
                                currentLogHandler8.d("[Purchases] - " + logLevel11.name(), (String) function02.invoke());
                            }
                            break;
                        case 2:
                            LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) function02.invoke(), null);
                            break;
                        case 3:
                            LogLevel logLevel12 = LogLevel.WARN;
                            LogHandler currentLogHandler9 = LogWrapperKt.getCurrentLogHandler();
                            if (Config.INSTANCE.getLogLevel().compareTo(logLevel12) <= 0) {
                                currentLogHandler9.w("[Purchases] - " + logLevel12.name(), (String) function02.invoke());
                            }
                            break;
                        case 4:
                            LogLevel logLevel13 = LogLevel.INFO;
                            LogHandler currentLogHandler10 = LogWrapperKt.getCurrentLogHandler();
                            if (Config.INSTANCE.getLogLevel().compareTo(logLevel13) <= 0) {
                                currentLogHandler10.i("[Purchases] - " + logLevel13.name(), (String) function02.invoke());
                            }
                            break;
                        case 5:
                            LogLevel logLevel14 = LogLevel.DEBUG;
                            LogHandler currentLogHandler11 = LogWrapperKt.getCurrentLogHandler();
                            if (Config.INSTANCE.getLogLevel().compareTo(logLevel14) <= 0) {
                                currentLogHandler11.d("[Purchases] - " + logLevel14.name(), (String) function02.invoke());
                            }
                            break;
                        case 6:
                            LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) function02.invoke(), null);
                            break;
                        case 7:
                            LogLevel logLevel15 = LogLevel.INFO;
                            LogHandler currentLogHandler12 = LogWrapperKt.getCurrentLogHandler();
                            if (Config.INSTANCE.getLogLevel().compareTo(logLevel15) <= 0) {
                                currentLogHandler12.i("[Purchases] - " + logLevel15.name(), (String) function02.invoke());
                            }
                            break;
                        case 8:
                            LogLevel logLevel16 = LogLevel.DEBUG;
                            LogHandler currentLogHandler13 = LogWrapperKt.getCurrentLogHandler();
                            if (Config.INSTANCE.getLogLevel().compareTo(logLevel16) <= 0) {
                                currentLogHandler13.d("[Purchases] - " + logLevel16.name(), (String) function02.invoke());
                            }
                            break;
                        case 9:
                            LogLevel logLevel17 = LogLevel.DEBUG;
                            LogHandler currentLogHandler14 = LogWrapperKt.getCurrentLogHandler();
                            if (Config.INSTANCE.getLogLevel().compareTo(logLevel17) <= 0) {
                                currentLogHandler14.d("[Purchases] - " + logLevel17.name(), (String) function02.invoke());
                            }
                            break;
                        case 10:
                            LogLevel logLevel18 = LogLevel.WARN;
                            LogHandler currentLogHandler15 = LogWrapperKt.getCurrentLogHandler();
                            if (Config.INSTANCE.getLogLevel().compareTo(logLevel18) <= 0) {
                                currentLogHandler15.w("[Purchases] - " + logLevel18.name(), (String) function02.invoke());
                            }
                            break;
                        case 11:
                            LogLevel logLevel19 = LogLevel.WARN;
                            LogHandler currentLogHandler16 = LogWrapperKt.getCurrentLogHandler();
                            if (Config.INSTANCE.getLogLevel().compareTo(logLevel19) <= 0) {
                                currentLogHandler16.w("[Purchases] - " + logLevel19.name(), (String) function02.invoke());
                            }
                            break;
                        case 12:
                            LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) function02.invoke(), null);
                            break;
                        case 13:
                            LogLevel logLevel20 = LogLevel.WARN;
                            LogHandler currentLogHandler17 = LogWrapperKt.getCurrentLogHandler();
                            if (Config.INSTANCE.getLogLevel().compareTo(logLevel20) <= 0) {
                                currentLogHandler17.w("[Purchases] - " + logLevel20.name(), (String) function02.invoke());
                            }
                            break;
                        case 14:
                            LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) function02.invoke(), null);
                            break;
                    }
                    Unit unit3 = Unit.f139807a;
                }
            }
        }
        return arrayList;
    }
}
