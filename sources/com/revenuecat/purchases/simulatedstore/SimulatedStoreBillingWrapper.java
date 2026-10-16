package com.revenuecat.purchases.simulatedstore;

import android.app.Activity;
import android.os.Handler;
import com.facebook.appevents.internal.Constants;
import com.revenuecat.purchases.LogHandler;
import com.revenuecat.purchases.LogLevel;
import com.revenuecat.purchases.PostReceiptInitiationSource;
import com.revenuecat.purchases.PresentedOfferingContext;
import com.revenuecat.purchases.ProductType;
import com.revenuecat.purchases.PurchasesError;
import com.revenuecat.purchases.PurchasesErrorCode;
import com.revenuecat.purchases.PurchasesException;
import com.revenuecat.purchases.PurchasesStateProvider;
import com.revenuecat.purchases.common.Backend;
import com.revenuecat.purchases.common.BillingAbstract;
import com.revenuecat.purchases.common.Config;
import com.revenuecat.purchases.common.LogWrapperKt;
import com.revenuecat.purchases.common.ReplaceProductInfo;
import com.revenuecat.purchases.common.caching.DeviceCache;
import com.revenuecat.purchases.common.networking.WebBillingProductResponse;
import com.revenuecat.purchases.common.networking.WebBillingProductsResponse;
import com.revenuecat.purchases.models.InAppMessageType;
import com.revenuecat.purchases.models.PricingPhase;
import com.revenuecat.purchases.models.PurchaseState;
import com.revenuecat.purchases.models.PurchaseType;
import com.revenuecat.purchases.models.PurchasingData;
import com.revenuecat.purchases.models.StoreProduct;
import com.revenuecat.purchases.models.StoreTransaction;
import com.revenuecat.purchases.models.SubscriptionOption;
import com.revenuecat.purchases.utils.AlertDialogHelper;
import com.revenuecat.purchases.utils.DefaultAlertDialogHelper;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
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
/* JADX INFO: loaded from: classes6.dex */
@Metadata
public final class SimulatedStoreBillingWrapper extends BillingAbstract {
    private final Backend backend;
    private volatile boolean connected;
    private final DeviceCache deviceCache;
    private final AlertDialogHelper dialogHelper;
    private final Handler mainHandler;

    public /* synthetic */ SimulatedStoreBillingWrapper(DeviceCache deviceCache, Handler handler, PurchasesStateProvider purchasesStateProvider, Backend backend, AlertDialogHelper alertDialogHelper, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(deviceCache, handler, purchasesStateProvider, backend, (i3 & 16) != 0 ? new DefaultAlertDialogHelper() : alertDialogHelper);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void completePurchase(StoreProduct storeProduct, PresentedOfferingContext presentedOfferingContext) throws JSONException {
        Map mapEmptyMap;
        String id;
        long time = new Date().getTime();
        String str = "test_" + time + '_' + UUID.randomUUID();
        List listListOf = CollectionsKt.listOf(storeProduct.getId());
        ProductType type = storeProduct.getType();
        PurchaseState purchaseState = PurchaseState.PURCHASED;
        Boolean boolValueOf = Boolean.valueOf(storeProduct.getType() == ProductType.SUBS);
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("orderId", str);
        jSONObject.put("productId", storeProduct.getId());
        jSONObject.put(Constants.GP_IAP_PURCHASE_TIME, time);
        jSONObject.put("purchaseToken", str);
        jSONObject.put("purchaseState", purchaseState.ordinal());
        Unit unit = Unit.f139807a;
        PurchaseType purchaseType = PurchaseType.GOOGLE_PURCHASE;
        SubscriptionOption defaultOption = storeProduct.getDefaultOption();
        String id2 = defaultOption != null ? defaultOption.getId() : null;
        SubscriptionOption defaultOption2 = storeProduct.getDefaultOption();
        if (defaultOption2 == null || (id = defaultOption2.getId()) == null || (mapEmptyMap = MapsKt.mapOf(TuplesKt.a(storeProduct.getId(), id))) == null) {
            mapEmptyMap = MapsKt.emptyMap();
        }
        StoreTransaction storeTransaction = new StoreTransaction(str, listListOf, type, time, str, purchaseState, boolValueOf, null, jSONObject, presentedOfferingContext, null, purchaseType, null, id2, mapEmptyMap, null);
        BillingAbstract.PurchasesUpdatedListener purchasesUpdatedListener = getPurchasesUpdatedListener();
        if (purchasesUpdatedListener != null) {
            purchasesUpdatedListener.onPurchasesUpdated(CollectionsKt.listOf(storeTransaction));
        }
    }

    private final void showPurchaseDialog(Activity activity, final StoreProduct storeProduct, final PresentedOfferingContext presentedOfferingContext) {
        StringBuilder sb = new StringBuilder();
        sb.append("This is a test purchase and should only be used during development. In production, use a Google/Amazon API key from RevenueCat.\n\n");
        sb.append("Product: " + storeProduct.getId() + '\n');
        sb.append("Price: " + storeProduct.getPrice().getFormatted() + '\n');
        SubscriptionOption defaultOption = storeProduct.getDefaultOption();
        if (defaultOption != null) {
            for (PricingPhase pricingPhase : defaultOption.getPricingPhases()) {
                sb.append("Phase: " + pricingPhase.getPrice().getFormatted() + " for " + pricingPhase.getBillingPeriod().getIso8601() + '\n');
            }
        }
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        this.dialogHelper.showDialog(activity, "Test Store Purchase", string, "Test valid purchase", "Test failed purchase", "Cancel", new Function0<Unit>() { // from class: com.revenuecat.purchases.simulatedstore.SimulatedStoreBillingWrapper.showPurchaseDialog.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Object invoke() throws JSONException {
                m665invoke();
                return Unit.f139807a;
            }

            /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
            public final void m665invoke() throws JSONException {
                LogLevel logLevel = LogLevel.DEBUG;
                LogHandler currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                    currentLogHandler.d("[Purchases] - " + logLevel.name(), "[Test store] Performing test purchase. This purchase won't appear in production.");
                }
                SimulatedStoreBillingWrapper.this.completePurchase(storeProduct, presentedOfferingContext);
            }
        }, new Function0<Unit>() { // from class: com.revenuecat.purchases.simulatedstore.SimulatedStoreBillingWrapper.showPurchaseDialog.2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Object invoke() {
                m666invoke();
                return Unit.f139807a;
            }

            /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
            public final void m666invoke() {
                LogLevel logLevel = LogLevel.DEBUG;
                LogHandler currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                    currentLogHandler.d("[Purchases] - " + logLevel.name(), "[Test store] Purchase failure simulated successfully in Test Store.");
                }
                BillingAbstract.PurchasesUpdatedListener purchasesUpdatedListener = SimulatedStoreBillingWrapper.this.getPurchasesUpdatedListener();
                if (purchasesUpdatedListener != null) {
                    purchasesUpdatedListener.onPurchasesFailedToUpdate(new PurchasesError(PurchasesErrorCode.TestStoreSimulatedPurchaseError, "Simulated error successfully."));
                }
            }
        }, new Function0<Unit>() { // from class: com.revenuecat.purchases.simulatedstore.SimulatedStoreBillingWrapper.showPurchaseDialog.3
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Object invoke() {
                m667invoke();
                return Unit.f139807a;
            }

            /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
            public final void m667invoke() {
                BillingAbstract.PurchasesUpdatedListener purchasesUpdatedListener = SimulatedStoreBillingWrapper.this.getPurchasesUpdatedListener();
                if (purchasesUpdatedListener != null) {
                    purchasesUpdatedListener.onPurchasesFailedToUpdate(new PurchasesError(PurchasesErrorCode.PurchaseCancelledError, "Purchase cancelled by user"));
                }
            }
        });
    }

    @Override // com.revenuecat.purchases.common.BillingAbstract
    public void consumeAndSave(boolean z2, StoreTransaction purchase, boolean z3, PostReceiptInitiationSource initiationSource) {
        Intrinsics.checkNotNullParameter(purchase, "purchase");
        Intrinsics.checkNotNullParameter(initiationSource, "initiationSource");
        LogLevel logLevel = LogLevel.DEBUG;
        LogHandler currentLogHandler = LogWrapperKt.getCurrentLogHandler();
        if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
            currentLogHandler.d("[Purchases] - " + logLevel.name(), "SimulatedStoreBillingAbstract: consumeAndSave - no-op for test store");
        }
    }

    @Override // com.revenuecat.purchases.common.BillingAbstract
    protected void endConnection() {
        LogLevel logLevel = LogLevel.DEBUG;
        LogHandler currentLogHandler = LogWrapperKt.getCurrentLogHandler();
        if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
            currentLogHandler.d("[Purchases] - " + logLevel.name(), "SimulatedStoreBillingAbstract: Ending connection");
        }
        this.connected = false;
    }

    @Override // com.revenuecat.purchases.common.BillingAbstract
    public void findPurchaseInPurchaseHistory(String appUserID, ProductType productType, String productId, Function1<? super StoreTransaction, Unit> onCompletion, Function1<? super PurchasesError, Unit> onError) {
        Intrinsics.checkNotNullParameter(appUserID, "appUserID");
        Intrinsics.checkNotNullParameter(productType, "productType");
        Intrinsics.checkNotNullParameter(productId, "productId");
        Intrinsics.checkNotNullParameter(onCompletion, "onCompletion");
        Intrinsics.checkNotNullParameter(onError, "onError");
        LogLevel logLevel = LogLevel.DEBUG;
        LogHandler currentLogHandler = LogWrapperKt.getCurrentLogHandler();
        if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
            currentLogHandler.d("[Purchases] - " + logLevel.name(), "SimulatedStoreBillingAbstract: findPurchaseInPurchaseHistory for product: " + productId + " will always fail");
        }
        onError.invoke(new PurchasesError(PurchasesErrorCode.PurchaseNotAllowedError, "No active purchase found for product: " + productId));
    }

    @Override // com.revenuecat.purchases.common.BillingAbstract
    public void getStorefront(Function1<? super String, Unit> onSuccess, Function1<? super PurchasesError, Unit> onError) {
        Intrinsics.checkNotNullParameter(onSuccess, "onSuccess");
        Intrinsics.checkNotNullParameter(onError, "onError");
        LogLevel logLevel = LogLevel.DEBUG;
        LogHandler currentLogHandler = LogWrapperKt.getCurrentLogHandler();
        if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
            currentLogHandler.d("[Purchases] - " + logLevel.name(), "SimulatedStoreBillingAbstract: getStorefront - returning US by default");
        }
        onSuccess.invoke("US");
    }

    @Override // com.revenuecat.purchases.common.BillingAbstract
    public boolean isConnected() {
        return this.connected;
    }

    @Override // com.revenuecat.purchases.common.BillingAbstract
    public void makePurchaseAsync(Activity activity, String appUserID, PurchasingData purchasingData, ReplaceProductInfo replaceProductInfo, PresentedOfferingContext presentedOfferingContext, Boolean bool) throws PurchasesException {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(appUserID, "appUserID");
        Intrinsics.checkNotNullParameter(purchasingData, "purchasingData");
        LogLevel logLevel = LogLevel.DEBUG;
        LogHandler currentLogHandler = LogWrapperKt.getCurrentLogHandler();
        if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
            currentLogHandler.d("[Purchases] - " + logLevel.name(), "SimulatedStoreBillingAbstract: makePurchaseAsync for product: " + purchasingData.getProductId());
        }
        SimulatedStorePurchasingData simulatedStorePurchasingData = purchasingData instanceof SimulatedStorePurchasingData ? (SimulatedStorePurchasingData) purchasingData : null;
        if (simulatedStorePurchasingData != null) {
            showPurchaseDialog(activity, simulatedStorePurchasingData.getStoreProduct(), presentedOfferingContext);
            return;
        }
        throw new PurchasesException(new PurchasesError(PurchasesErrorCode.ProductNotAvailableForPurchaseError, "Purchasing data is not a valid SimulatedStorePurchasingData: " + purchasingData.getProductId()));
    }

    public final void performStartConnection$purchases_defaultsBc8Release() {
        LogLevel logLevel = LogLevel.DEBUG;
        LogHandler currentLogHandler = LogWrapperKt.getCurrentLogHandler();
        if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
            currentLogHandler.d("[Purchases] - " + logLevel.name(), "SimulatedStoreBillingAbstract: Starting connection");
        }
        this.connected = true;
        BillingAbstract.StateListener stateListener = getStateListener();
        if (stateListener != null) {
            stateListener.onConnected();
        }
    }

    @Override // com.revenuecat.purchases.common.BillingAbstract
    public void queryAllPurchases(String appUserID, Function1<? super List<StoreTransaction>, Unit> onReceivePurchaseHistory, Function1<? super PurchasesError, Unit> onReceivePurchaseHistoryError) {
        Intrinsics.checkNotNullParameter(appUserID, "appUserID");
        Intrinsics.checkNotNullParameter(onReceivePurchaseHistory, "onReceivePurchaseHistory");
        Intrinsics.checkNotNullParameter(onReceivePurchaseHistoryError, "onReceivePurchaseHistoryError");
        LogLevel logLevel = LogLevel.DEBUG;
        LogHandler currentLogHandler = LogWrapperKt.getCurrentLogHandler();
        if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
            currentLogHandler.d("[Purchases] - " + logLevel.name(), "SimulatedStoreBillingAbstract: queryAllPurchases - returning empty list");
        }
        onReceivePurchaseHistory.invoke(CollectionsKt.emptyList());
    }

    @Override // com.revenuecat.purchases.common.BillingAbstract
    public void queryProductDetailsAsync(ProductType productType, Set<String> productIds, final Function1<? super List<? extends StoreProduct>, Unit> onReceive, final Function1<? super PurchasesError, Unit> onError) throws Throwable {
        Intrinsics.checkNotNullParameter(productType, "productType");
        Intrinsics.checkNotNullParameter(productIds, "productIds");
        Intrinsics.checkNotNullParameter(onReceive, "onReceive");
        Intrinsics.checkNotNullParameter(onError, "onError");
        LogLevel logLevel = LogLevel.DEBUG;
        LogHandler currentLogHandler = LogWrapperKt.getCurrentLogHandler();
        if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
            currentLogHandler.d("[Purchases] - " + logLevel.name(), "SimulatedStoreBillingAbstract: queryProductDetailsAsync for products: " + productIds);
        }
        Backend backend = this.backend;
        String cachedAppUserID$purchases_defaultsBc8Release = this.deviceCache.getCachedAppUserID$purchases_defaultsBc8Release();
        if (cachedAppUserID$purchases_defaultsBc8Release == null) {
            cachedAppUserID$purchases_defaultsBc8Release = "";
        }
        backend.getWebBillingProducts(cachedAppUserID$purchases_defaultsBc8Release, productIds, new Function1<WebBillingProductsResponse, Unit>() { // from class: com.revenuecat.purchases.simulatedstore.SimulatedStoreBillingWrapper.queryProductDetailsAsync.2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((WebBillingProductsResponse) obj);
                return Unit.f139807a;
            }

            public final void invoke(WebBillingProductsResponse response) {
                Intrinsics.checkNotNullParameter(response, "response");
                try {
                    List<WebBillingProductResponse> productDetails = response.getProductDetails();
                    ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(productDetails, 10));
                    Iterator<T> it = productDetails.iterator();
                    while (it.hasNext()) {
                        arrayList.add(SimulatedStoreProductConverter.convertToStoreProduct$default(SimulatedStoreProductConverter.INSTANCE, (WebBillingProductResponse) it.next(), null, 2, null));
                    }
                    onReceive.invoke(arrayList);
                } catch (PurchasesException e3) {
                    onError.invoke(e3.getError());
                }
            }
        }, onError);
    }

    @Override // com.revenuecat.purchases.common.BillingAbstract
    public void queryPurchases(String appUserID, Function1<? super Map<String, StoreTransaction>, Unit> onSuccess, Function1<? super PurchasesError, Unit> onError) {
        Intrinsics.checkNotNullParameter(appUserID, "appUserID");
        Intrinsics.checkNotNullParameter(onSuccess, "onSuccess");
        Intrinsics.checkNotNullParameter(onError, "onError");
        LogLevel logLevel = LogLevel.DEBUG;
        LogHandler currentLogHandler = LogWrapperKt.getCurrentLogHandler();
        if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
            currentLogHandler.d("[Purchases] - " + logLevel.name(), "SimulatedStoreBillingAbstract: queryPurchases - returning empty map");
        }
        onSuccess.invoke(MapsKt.emptyMap());
    }

    @Override // com.revenuecat.purchases.common.BillingAbstract
    public void showInAppMessagesIfNeeded(Activity activity, List<? extends InAppMessageType> inAppMessageTypes, Function0<Unit> subscriptionStatusChange) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(inAppMessageTypes, "inAppMessageTypes");
        Intrinsics.checkNotNullParameter(subscriptionStatusChange, "subscriptionStatusChange");
        LogLevel logLevel = LogLevel.DEBUG;
        LogHandler currentLogHandler = LogWrapperKt.getCurrentLogHandler();
        if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
            currentLogHandler.d("[Purchases] - " + logLevel.name(), "SimulatedStoreBillingAbstract: showInAppMessagesIfNeeded - no-op for test store");
        }
    }

    @Override // com.revenuecat.purchases.common.BillingAbstract
    public void startConnection(long j3) {
        this.mainHandler.postDelayed(new Runnable() { // from class: com.revenuecat.purchases.simulatedstore.a
            @Override // java.lang.Runnable
            public final void run() {
                this.f92315a.performStartConnection$purchases_defaultsBc8Release();
            }
        }, j3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SimulatedStoreBillingWrapper(DeviceCache deviceCache, Handler mainHandler, PurchasesStateProvider purchasesStateProvider, Backend backend, AlertDialogHelper dialogHelper) {
        super(purchasesStateProvider);
        Intrinsics.checkNotNullParameter(deviceCache, "deviceCache");
        Intrinsics.checkNotNullParameter(mainHandler, "mainHandler");
        Intrinsics.checkNotNullParameter(purchasesStateProvider, "purchasesStateProvider");
        Intrinsics.checkNotNullParameter(backend, "backend");
        Intrinsics.checkNotNullParameter(dialogHelper, "dialogHelper");
        this.deviceCache = deviceCache;
        this.mainHandler = mainHandler;
        this.backend = backend;
        this.dialogHelper = dialogHelper;
    }
}
