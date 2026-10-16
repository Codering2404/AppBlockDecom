package com.revenuecat.purchases.common.offlineentitlements;

import com.google.gson.internal.bind.util.ISO8601Utils;
import com.revenuecat.purchases.CustomerInfo;
import com.revenuecat.purchases.CustomerInfoOriginalSource;
import com.revenuecat.purchases.LogHandler;
import com.revenuecat.purchases.ProductType;
import com.revenuecat.purchases.PurchasesError;
import com.revenuecat.purchases.PurchasesErrorCode;
import com.revenuecat.purchases.VerificationResult;
import com.revenuecat.purchases.common.AppConfig;
import com.revenuecat.purchases.common.CustomerInfoFactory;
import com.revenuecat.purchases.common.DateProvider;
import com.revenuecat.purchases.common.DefaultDateProvider;
import com.revenuecat.purchases.common.LogWrapperKt;
import com.revenuecat.purchases.common.diagnostics.DiagnosticsTracker;
import com.revenuecat.purchases.common.responses.CustomerInfoResponseJsonKeys;
import com.revenuecat.purchases.common.responses.EntitlementsResponseJsonKeys;
import com.revenuecat.purchases.common.responses.ProductResponseJsonKeys;
import com.revenuecat.purchases.strings.CustomerInfoStrings;
import com.revenuecat.purchases.strings.OfflineEntitlementsStrings;
import com.revenuecat.purchases.utils.Iso8601Utils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

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
/* JADX INFO: loaded from: classes5.dex */
@Metadata
public final class OfflineCustomerInfoCalculator {
    private final AppConfig appConfig;
    private final DateProvider dateProvider;
    private final DiagnosticsTracker diagnosticsTracker;
    private final PurchasedProductsFetcher purchasedProductsFetcher;

    public OfflineCustomerInfoCalculator(PurchasedProductsFetcher purchasedProductsFetcher, AppConfig appConfig, DiagnosticsTracker diagnosticsTracker, DateProvider dateProvider) {
        Intrinsics.checkNotNullParameter(purchasedProductsFetcher, "purchasedProductsFetcher");
        Intrinsics.checkNotNullParameter(appConfig, "appConfig");
        Intrinsics.checkNotNullParameter(dateProvider, "dateProvider");
        this.purchasedProductsFetcher = purchasedProductsFetcher;
        this.appConfig = appConfig;
        this.diagnosticsTracker = diagnosticsTracker;
        this.dateProvider = dateProvider;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final CustomerInfo buildCustomerInfoUsingListOfPurchases(String str, List<PurchasedProduct> list) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        Date now = this.dateProvider.getNow();
        String str2 = Iso8601Utils.format(now);
        jSONObject.put(CustomerInfoResponseJsonKeys.REQUEST_DATE, str2);
        jSONObject.put(CustomerInfoResponseJsonKeys.REQUEST_DATE_MS, now.getTime());
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put(CustomerInfoResponseJsonKeys.ORIGINAL_APP_USER_ID, str);
        jSONObject2.put(CustomerInfoResponseJsonKeys.ORIGINAL_APPLICATION_VERSION, "1.0");
        jSONObject2.put(CustomerInfoResponseJsonKeys.ENTITLEMENTS, generateEntitlementsResponse(list));
        jSONObject2.put(CustomerInfoResponseJsonKeys.FIRST_SEEN, str2);
        jSONObject2.put("original_purchase_date", calculateOriginalPurchaseDate(list));
        jSONObject2.put(CustomerInfoResponseJsonKeys.NON_SUBSCRIPTIONS, new JSONObject());
        jSONObject2.put(CustomerInfoResponseJsonKeys.SUBSCRIPTIONS, generateSubscriptions(list));
        jSONObject2.put("management_url", determineManagementURL());
        Unit unit = Unit.f139807a;
        jSONObject.put(CustomerInfoResponseJsonKeys.SUBSCRIBER, jSONObject2);
        return CustomerInfoFactory.INSTANCE.buildCustomerInfo(jSONObject, now, VerificationResult.VERIFIED_ON_DEVICE, CustomerInfoOriginalSource.OFFLINE_ENTITLEMENTS, false);
    }

    private final String calculateOriginalPurchaseDate(List<PurchasedProduct> list) {
        Long lValueOf;
        Iterator<T> it = list.iterator();
        if (it.hasNext()) {
            lValueOf = Long.valueOf(((PurchasedProduct) it.next()).getStoreTransaction().getPurchaseTime());
            while (it.hasNext()) {
                Long lValueOf2 = Long.valueOf(((PurchasedProduct) it.next()).getStoreTransaction().getPurchaseTime());
                if (lValueOf.compareTo(lValueOf2) > 0) {
                    lValueOf = lValueOf2;
                }
            }
        } else {
            lValueOf = null;
        }
        if (lValueOf != null) {
            return ISO8601Utils.b(new Date(lValueOf.longValue()));
        }
        return null;
    }

    private final Object determineManagementURL() {
        String managementUrl$purchases_defaultsBc8Release = this.appConfig.getStore().getManagementUrl$purchases_defaultsBc8Release();
        if (managementUrl$purchases_defaultsBc8Release != null) {
            return managementUrl$purchases_defaultsBc8Release;
        }
        Object NULL = JSONObject.NULL;
        Intrinsics.checkNotNullExpressionValue(NULL, "NULL");
        return NULL;
    }

    private final JSONObject generateEntitlementsResponse(List<PurchasedProduct> list) throws JSONException {
        ArrayList arrayList = new ArrayList();
        for (PurchasedProduct purchasedProduct : list) {
            List<String> entitlements = purchasedProduct.getEntitlements();
            ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(entitlements, 10));
            Iterator<T> it = entitlements.iterator();
            while (it.hasNext()) {
                arrayList2.add(TuplesKt.a((String) it.next(), purchasedProduct));
            }
            CollectionsKt.addAll(arrayList, arrayList2);
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        int size = arrayList.size();
        int i3 = 0;
        while (i3 < size) {
            Object obj = arrayList.get(i3);
            i3++;
            Pair pair = (Pair) obj;
            String str = (String) pair.e();
            Object arrayList3 = linkedHashMap.get(str);
            if (arrayList3 == null) {
                arrayList3 = new ArrayList();
                linkedHashMap.put(str, arrayList3);
            }
            ((List) arrayList3).add((PurchasedProduct) pair.f());
        }
        LinkedHashMap linkedHashMap2 = new LinkedHashMap(MapsKt.mapCapacity(linkedHashMap.size()));
        Iterator it2 = linkedHashMap.entrySet().iterator();
        while (true) {
            Object next = null;
            if (!it2.hasNext()) {
                break;
            }
            Map.Entry entry = (Map.Entry) it2.next();
            Object key = entry.getKey();
            List list2 = (List) entry.getValue();
            Iterator it3 = list2.iterator();
            if (it3.hasNext()) {
                next = it3.next();
                if (it3.hasNext()) {
                    Date expiresDate = ((PurchasedProduct) next).getExpiresDate();
                    long time = expiresDate != null ? expiresDate.getTime() : Long.MAX_VALUE;
                    do {
                        Object next2 = it3.next();
                        Date expiresDate2 = ((PurchasedProduct) next2).getExpiresDate();
                        long time2 = expiresDate2 != null ? expiresDate2.getTime() : Long.MAX_VALUE;
                        if (time < time2) {
                            next = next2;
                            time = time2;
                        }
                    } while (it3.hasNext());
                }
            }
            PurchasedProduct purchasedProduct2 = (PurchasedProduct) next;
            if (purchasedProduct2 == null) {
                purchasedProduct2 = (PurchasedProduct) CollectionsKt.first(list2);
            }
            linkedHashMap2.put(key, purchasedProduct2);
        }
        JSONObject jSONObject = new JSONObject();
        for (Map.Entry entry2 : linkedHashMap2.entrySet()) {
            String str2 = (String) entry2.getKey();
            PurchasedProduct purchasedProduct3 = (PurchasedProduct) entry2.getValue();
            JSONObject jSONObject2 = new JSONObject();
            Date expiresDate3 = purchasedProduct3.getExpiresDate();
            jSONObject2.put("expires_date", expiresDate3 != null ? Iso8601Utils.format(expiresDate3) : null);
            jSONObject2.put(EntitlementsResponseJsonKeys.PRODUCT_IDENTIFIER, purchasedProduct3.getProductIdentifier());
            jSONObject2.put("purchase_date", Iso8601Utils.format(new Date(purchasedProduct3.getStoreTransaction().getPurchaseTime())));
            String basePlanId = purchasedProduct3.getBasePlanId();
            if (basePlanId != null) {
                jSONObject2.put("product_plan_identifier", basePlanId);
            }
            jSONObject.put(str2, jSONObject2);
        }
        return jSONObject;
    }

    private final JSONObject generateSubscriptions(List<PurchasedProduct> list) throws JSONException {
        String str;
        JSONObject jSONObject = new JSONObject();
        for (PurchasedProduct purchasedProduct : list) {
            String productIdentifier = purchasedProduct.getProductIdentifier();
            JSONObject jSONObject2 = new JSONObject();
            Object obj = JSONObject.NULL;
            jSONObject2.put(ProductResponseJsonKeys.BILLING_ISSUES_DETECTED_AT, obj);
            jSONObject2.put(ProductResponseJsonKeys.IS_SANDBOX, false);
            Date date = new Date(purchasedProduct.getStoreTransaction().getPurchaseTime());
            jSONObject2.put("original_purchase_date", Iso8601Utils.format(date));
            jSONObject2.put("purchase_date", Iso8601Utils.format(date));
            String strName = this.appConfig.getStore().name();
            Locale locale = Locale.ROOT;
            String lowerCase = strName.toLowerCase(locale);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
            jSONObject2.put(ProductResponseJsonKeys.STORE, lowerCase);
            jSONObject2.put(ProductResponseJsonKeys.UNSUBSCRIBE_DETECTED_AT, obj);
            jSONObject2.put("product_plan_identifier", purchasedProduct.getBasePlanId());
            Date expiresDate = purchasedProduct.getExpiresDate();
            if (expiresDate != null && (str = Iso8601Utils.format(expiresDate)) != null) {
                obj = str;
            }
            jSONObject2.put("expires_date", obj);
            jSONObject2.put("management_url", determineManagementURL());
            String lowerCase2 = "NORMAL".toLowerCase(locale);
            Intrinsics.checkNotNullExpressionValue(lowerCase2, "toLowerCase(...)");
            jSONObject2.put(ProductResponseJsonKeys.PERIOD_TYPE, lowerCase2);
            Unit unit = Unit.f139807a;
            jSONObject.put(productIdentifier, jSONObject2);
        }
        return jSONObject;
    }

    public final void computeOfflineCustomerInfo(final String appUserID, final Function1<? super CustomerInfo, Unit> onSuccess, final Function1<? super PurchasesError, Unit> onError) {
        Intrinsics.checkNotNullParameter(appUserID, "appUserID");
        Intrinsics.checkNotNullParameter(onSuccess, "onSuccess");
        Intrinsics.checkNotNullParameter(onError, "onError");
        this.purchasedProductsFetcher.queryActiveProducts(appUserID, new Function1<List<? extends PurchasedProduct>, Unit>() { // from class: com.revenuecat.purchases.common.offlineentitlements.OfflineCustomerInfoCalculator.computeOfflineCustomerInfo.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) throws JSONException {
                invoke((List<PurchasedProduct>) obj);
                return Unit.f139807a;
            }

            public final void invoke(List<PurchasedProduct> purchasedProducts) throws JSONException {
                Intrinsics.checkNotNullParameter(purchasedProducts, "purchasedProducts");
                List<PurchasedProduct> list = purchasedProducts;
                if (!(list instanceof Collection) || !list.isEmpty()) {
                    Iterator<T> it = list.iterator();
                    while (it.hasNext()) {
                        if (((PurchasedProduct) it.next()).getStoreTransaction().getType() == ProductType.INAPP) {
                            PurchasesError purchasesError = new PurchasesError(PurchasesErrorCode.UnsupportedError, OfflineEntitlementsStrings.OFFLINE_ENTITLEMENTS_UNSUPPORTED_INAPP_PURCHASES);
                            LogHandler currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                            String str = String.format(CustomerInfoStrings.COMPUTING_OFFLINE_CUSTOMER_INFO_FAILED, Arrays.copyOf(new Object[]{purchasesError}, 1));
                            Intrinsics.checkNotNullExpressionValue(str, "format(...)");
                            currentLogHandler.e("[Purchases] - ERROR", str, null);
                            DiagnosticsTracker diagnosticsTracker = OfflineCustomerInfoCalculator.this.diagnosticsTracker;
                            if (diagnosticsTracker != null) {
                                diagnosticsTracker.trackErrorEnteringOfflineEntitlementsMode(purchasesError);
                            }
                            onError.invoke(purchasesError);
                            return;
                        }
                    }
                }
                onSuccess.invoke(OfflineCustomerInfoCalculator.this.buildCustomerInfoUsingListOfPurchases(appUserID, purchasedProducts));
            }
        }, new Function1<PurchasesError, Unit>() { // from class: com.revenuecat.purchases.common.offlineentitlements.OfflineCustomerInfoCalculator.computeOfflineCustomerInfo.2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((PurchasesError) obj);
                return Unit.f139807a;
            }

            public final void invoke(PurchasesError error) {
                Intrinsics.checkNotNullParameter(error, "error");
                LogHandler currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                String str = String.format(CustomerInfoStrings.COMPUTING_OFFLINE_CUSTOMER_INFO_FAILED, Arrays.copyOf(new Object[]{error}, 1));
                Intrinsics.checkNotNullExpressionValue(str, "format(...)");
                currentLogHandler.e("[Purchases] - ERROR", str, null);
                DiagnosticsTracker diagnosticsTracker = OfflineCustomerInfoCalculator.this.diagnosticsTracker;
                if (diagnosticsTracker != null) {
                    diagnosticsTracker.trackErrorEnteringOfflineEntitlementsMode(error);
                }
                onError.invoke(error);
            }
        });
    }

    public /* synthetic */ OfflineCustomerInfoCalculator(PurchasedProductsFetcher purchasedProductsFetcher, AppConfig appConfig, DiagnosticsTracker diagnosticsTracker, DateProvider dateProvider, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(purchasedProductsFetcher, appConfig, diagnosticsTracker, (i3 & 8) != 0 ? new DefaultDateProvider() : dateProvider);
    }
}
