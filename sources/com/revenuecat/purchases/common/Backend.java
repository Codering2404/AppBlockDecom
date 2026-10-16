package com.revenuecat.purchases.common;

import com.applovin.sdk.AppLovinEventParameters;
import com.google.firebase.sessions.api.ITd.wgbAZXYjrv;
import com.revenuecat.purchases.CustomerInfo;
import com.revenuecat.purchases.LogHandler;
import com.revenuecat.purchases.LogLevel;
import com.revenuecat.purchases.PostReceiptInitiationSource;
import com.revenuecat.purchases.PresentedOfferingContext;
import com.revenuecat.purchases.PurchasesAreCompletedBy;
import com.revenuecat.purchases.PurchasesError;
import com.revenuecat.purchases.PurchasesErrorCode;
import com.revenuecat.purchases.ReplacementMode;
import com.revenuecat.purchases.ReplacementModeKt;
import com.revenuecat.purchases.common.Dispatcher;
import com.revenuecat.purchases.common.diagnostics.DiagnosticsTracker;
import com.revenuecat.purchases.common.events.EventsRequest;
import com.revenuecat.purchases.common.networking.Endpoint;
import com.revenuecat.purchases.common.networking.HTTPResult;
import com.revenuecat.purchases.common.networking.PostReceiptResponse;
import com.revenuecat.purchases.common.networking.PostReceiptResponseKt;
import com.revenuecat.purchases.common.networking.RCHTTPStatusCodes;
import com.revenuecat.purchases.common.networking.WebBillingProductsResponse;
import com.revenuecat.purchases.common.offlineentitlements.ProductEntitlementMapping;
import com.revenuecat.purchases.common.verification.SignatureVerificationMode;
import com.revenuecat.purchases.common.workflows.WorkflowDetailResponse;
import com.revenuecat.purchases.common.workflows.WorkflowJsonParser;
import com.revenuecat.purchases.customercenter.CustomerCenterConfigData;
import com.revenuecat.purchases.customercenter.CustomerCenterRoot;
import com.revenuecat.purchases.interfaces.RedeemWebPurchaseListener;
import com.revenuecat.purchases.models.PricingPhase;
import com.revenuecat.purchases.paywalls.events.PaywallPostReceiptData;
import com.revenuecat.purchases.strings.NetworkStrings;
import com.revenuecat.purchases.utils.JsonElementExtensionsKt;
import com.revenuecat.purchases.utils.MapExtensionsKt;
import com.revenuecat.purchases.virtualcurrencies.VirtualCurrencies;
import com.revenuecat.purchases.virtualcurrencies.VirtualCurrenciesFactory;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlinx.serialization.SerializationException;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonBuilder;
import kotlinx.serialization.json.JsonKt;
import org.json.JSONArray;
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
public final class Backend {
    private static final String APP_USER_ID = "app_user_id";
    private static final String FETCH_TOKEN = "fetch_token";
    private static final String NEW_APP_USER_ID = "new_app_user_id";
    private static final int POST_RECEIPT_PAYLOAD_VERSION = 1;
    private volatile Map<List<String>, List<Pair<Function0<Unit>, Function1<PurchasesError, Unit>>>> aliasCallbacks;
    private final AppConfig appConfig;
    private final BackendHelper backendHelper;
    private volatile Map<BackgroundAwareCallbackCacheKey, List<Pair<Function1<CustomerInfo, Unit>, Function2<PurchasesError, Boolean, Unit>>>> callbacks;
    private volatile Map<String, List<Pair<Function1<Boolean, Unit>, Function1<PurchasesError, Unit>>>> createSupportTicketCallbacks;
    private volatile Map<String, List<Pair<Function1<CustomerCenterConfigData, Unit>, Function1<PurchasesError, Unit>>>> customerCenterCallbacks;
    private volatile Map<List<String>, List<Pair<Function1<JSONObject, Unit>, Function2<PurchasesError, Boolean, Unit>>>> diagnosticsCallbacks;
    private final Dispatcher dispatcher;
    private final Dispatcher eventsDispatcher;
    private final HTTPClient httpClient;
    private volatile Map<List<String>, List<Pair<Function2<CustomerInfo, Boolean, Unit>, Function1<PurchasesError, Unit>>>> identifyCallbacks;
    private volatile Map<BackgroundAwareCallbackCacheKey, List<Pair<Function2<JSONObject, HTTPResponseOriginalSource, Unit>, Function2<PurchasesError, GetOfferingsErrorHandlingBehavior, Unit>>>> offeringsCallbacks;
    private volatile Map<List<String>, List<Pair<Function0<Unit>, Function2<PurchasesError, Boolean, Unit>>>> paywallEventsCallbacks;
    private volatile Map<List<String>, List<Pair<Function1<PostReceiptResponse, Unit>, Function3<PurchasesError, PostReceiptErrorHandlingBehavior, JSONObject, Unit>>>> postReceiptCallbacks;
    private volatile Map<String, List<Pair<Function1<ProductEntitlementMapping, Unit>, Function1<PurchasesError, Unit>>>> productEntitlementCallbacks;
    private volatile Map<String, List<Function1<RedeemWebPurchaseListener.Result, Unit>>> redeemWebPurchaseCallbacks;
    private volatile Map<BackgroundAwareCallbackCacheKey, List<Pair<Function1<VirtualCurrencies, Unit>, Function1<PurchasesError, Unit>>>> virtualCurrenciesCallbacks;
    private volatile Map<String, List<Pair<Function1<WebBillingProductsResponse, Unit>, Function1<PurchasesError, Unit>>>> webBillingProductsCallbacks;
    private volatile Map<BackgroundAwareCallbackCacheKey, List<Pair<Function1<WorkflowDetailResponse, Unit>, Function1<PurchasesError, Unit>>>> workflowDetailCallbacks;
    public static final Companion Companion = new Companion(null);
    private static final Json json = JsonKt.b(null, new Function1<JsonBuilder, Unit>() { // from class: com.revenuecat.purchases.common.Backend$Companion$json$1
        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((JsonBuilder) obj);
            return Unit.f139807a;
        }

        public final void invoke(JsonBuilder Json) {
            Intrinsics.checkNotNullParameter(Json, "$this$Json");
            Json.h(true);
        }
    }, 1, null);

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Json getJson$purchases_defaultsBc8Release() {
            return Backend.json;
        }

        private Companion() {
        }

        public static /* synthetic */ void getJson$purchases_defaultsBc8Release$annotations() {
        }
    }

    public Backend(AppConfig appConfig, Dispatcher dispatcher, Dispatcher eventsDispatcher, HTTPClient httpClient, BackendHelper backendHelper) {
        Intrinsics.checkNotNullParameter(appConfig, "appConfig");
        Intrinsics.checkNotNullParameter(dispatcher, "dispatcher");
        Intrinsics.checkNotNullParameter(eventsDispatcher, "eventsDispatcher");
        Intrinsics.checkNotNullParameter(httpClient, "httpClient");
        Intrinsics.checkNotNullParameter(backendHelper, "backendHelper");
        this.appConfig = appConfig;
        this.dispatcher = dispatcher;
        this.eventsDispatcher = eventsDispatcher;
        this.httpClient = httpClient;
        this.backendHelper = backendHelper;
        this.callbacks = new LinkedHashMap();
        this.postReceiptCallbacks = new LinkedHashMap();
        this.offeringsCallbacks = new LinkedHashMap();
        this.identifyCallbacks = new LinkedHashMap();
        this.aliasCallbacks = new LinkedHashMap();
        this.diagnosticsCallbacks = new LinkedHashMap();
        this.paywallEventsCallbacks = new LinkedHashMap();
        this.productEntitlementCallbacks = new LinkedHashMap();
        this.customerCenterCallbacks = new LinkedHashMap();
        this.createSupportTicketCallbacks = new LinkedHashMap();
        this.redeemWebPurchaseCallbacks = new LinkedHashMap();
        this.virtualCurrenciesCallbacks = new LinkedHashMap();
        this.webBillingProductsCallbacks = new LinkedHashMap();
        this.workflowDetailCallbacks = new LinkedHashMap();
    }

    private final synchronized <S, E> void addBackgroundAwareCallback(Map<BackgroundAwareCallbackCacheKey, List<Pair<S, E>>> map, Dispatcher.AsyncCall asyncCall, Dispatcher dispatcher, BackgroundAwareCallbackCacheKey backgroundAwareCallbackCacheKey, Pair<? extends S, ? extends E> pair, Delay delay) {
        BackgroundAwareCallbackCacheKey backgroundAwareCallbackCacheKey2;
        try {
            BackgroundAwareCallbackCacheKey backgroundAwareCallbackCacheKeyCopy$default = BackgroundAwareCallbackCacheKey.copy$default(backgroundAwareCallbackCacheKey, null, false, 1, null);
            boolean zContainsKey = map.containsKey(backgroundAwareCallbackCacheKeyCopy$default);
            if (backgroundAwareCallbackCacheKey.getAppInBackground() && zContainsKey) {
                LogLevel logLevel = LogLevel.DEBUG;
                LogHandler currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                    String str = "[Purchases] - " + logLevel.name();
                    String str2 = String.format(NetworkStrings.SAME_CALL_SCHEDULED_WITHOUT_JITTER, Arrays.copyOf(new Object[]{backgroundAwareCallbackCacheKeyCopy$default}, 1));
                    Intrinsics.checkNotNullExpressionValue(str2, "format(...)");
                    currentLogHandler.d(str, str2);
                }
                backgroundAwareCallbackCacheKey2 = backgroundAwareCallbackCacheKeyCopy$default;
            } else {
                backgroundAwareCallbackCacheKey2 = backgroundAwareCallbackCacheKey;
            }
            addCallback(map, asyncCall, dispatcher, backgroundAwareCallbackCacheKey2, pair, delay);
            BackgroundAwareCallbackCacheKey backgroundAwareCallbackCacheKeyCopy$default2 = BackgroundAwareCallbackCacheKey.copy$default(backgroundAwareCallbackCacheKey, null, true, 1, null);
            boolean zContainsKey2 = map.containsKey(backgroundAwareCallbackCacheKeyCopy$default);
            if (!backgroundAwareCallbackCacheKey.getAppInBackground() && zContainsKey2) {
                LogLevel logLevel2 = LogLevel.DEBUG;
                LogHandler currentLogHandler2 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel2) <= 0) {
                    String str3 = "[Purchases] - " + logLevel2.name();
                    String str4 = String.format(NetworkStrings.SAME_CALL_SCHEDULED_WITH_JITTER, Arrays.copyOf(new Object[]{backgroundAwareCallbackCacheKeyCopy$default}, 1));
                    Intrinsics.checkNotNullExpressionValue(str4, "format(...)");
                    currentLogHandler2.d(str3, str4);
                }
                List<Pair<S, E>> listRemove = map.remove(backgroundAwareCallbackCacheKeyCopy$default2);
                if (listRemove != null) {
                    List<Pair<S, E>> list = listRemove.isEmpty() ? null : listRemove;
                    if (list != null) {
                        if (map.containsKey(backgroundAwareCallbackCacheKey)) {
                            List<Pair<S, E>> list2 = map.get(backgroundAwareCallbackCacheKey);
                            if (list2 != null) {
                                list2.addAll(list);
                            }
                        } else {
                            map.put(backgroundAwareCallbackCacheKey, list);
                        }
                    }
                }
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    static /* synthetic */ void addBackgroundAwareCallback$default(Backend backend, Map map, Dispatcher.AsyncCall asyncCall, Dispatcher dispatcher, BackgroundAwareCallbackCacheKey backgroundAwareCallbackCacheKey, Pair pair, Delay delay, int i3, Object obj) {
        if ((i3 & 16) != 0) {
            delay = Delay.NONE;
        }
        backend.addBackgroundAwareCallback(map, asyncCall, dispatcher, backgroundAwareCallbackCacheKey, pair, delay);
    }

    private final <K, F> void addCallback(Map<K, List<F>> map, Dispatcher.AsyncCall asyncCall, Dispatcher dispatcher, K k3, F f3, Delay delay) {
        if (!map.containsKey(k3)) {
            map.put(k3, CollectionsKt.mutableListOf(f3));
            this.backendHelper.enqueue(asyncCall, dispatcher, delay);
            return;
        }
        LogLevel logLevel = LogLevel.DEBUG;
        LogHandler currentLogHandler = LogWrapperKt.getCurrentLogHandler();
        if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
            String str = "[Purchases] - " + logLevel.name();
            StringCompanionObject stringCompanionObject = StringCompanionObject.f140150a;
            String str2 = String.format(NetworkStrings.SAME_CALL_ALREADY_IN_PROGRESS, Arrays.copyOf(new Object[]{k3}, 1));
            Intrinsics.checkNotNullExpressionValue(str2, "format(...)");
            currentLogHandler.d(str, str2);
        }
        List<F> list = map.get(k3);
        Intrinsics.checkNotNull(list);
        list.add(f3);
    }

    static /* synthetic */ void addCallback$default(Backend backend, Map map, Dispatcher.AsyncCall asyncCall, Dispatcher dispatcher, Object obj, Object obj2, Delay delay, int i3, Object obj3) {
        if ((i3 & 16) != 0) {
            delay = Delay.NONE;
        }
        backend.addCallback(map, asyncCall, dispatcher, obj, obj2, delay);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final PostReceiptErrorHandlingBehavior determinePostReceiptErrorHandlingBehavior(int i3, PurchasesError purchasesError) {
        return RCHTTPStatusCodes.INSTANCE.isServerError(i3) ? PostReceiptErrorHandlingBehavior.SHOULD_USE_OFFLINE_ENTITLEMENTS_AND_NOT_CONSUME : purchasesError.getCode() == PurchasesErrorCode.UnsupportedError ? PostReceiptErrorHandlingBehavior.SHOULD_NOT_CONSUME : PostReceiptErrorHandlingBehavior.SHOULD_BE_MARKED_SYNCED;
    }

    public final void aliasUsers(final String oldAppUserID, final String newAppUserID, Function0<Unit> onSuccessHandler, Function1<? super PurchasesError, Unit> onErrorHandler) {
        Intrinsics.checkNotNullParameter(oldAppUserID, "oldAppUserID");
        Intrinsics.checkNotNullParameter(newAppUserID, "newAppUserID");
        Intrinsics.checkNotNullParameter(onSuccessHandler, "onSuccessHandler");
        Intrinsics.checkNotNullParameter(onErrorHandler, "onErrorHandler");
        final List listListOfNotNull = CollectionsKt.listOfNotNull((Object[]) new String[]{oldAppUserID, newAppUserID});
        Dispatcher.AsyncCall asyncCall = new Dispatcher.AsyncCall() { // from class: com.revenuecat.purchases.common.Backend$aliasUsers$call$1
            @Override // com.revenuecat.purchases.common.Dispatcher.AsyncCall
            public HTTPResult call() {
                return HTTPClient.performRequest$default(this.httpClient, this.appConfig.getBaseURL(), new Endpoint.AliasUsers(oldAppUserID), MapsKt.mapOf(TuplesKt.a("app_user_id", oldAppUserID), TuplesKt.a("new_app_user_id", newAppUserID)), null, this.backendHelper.getAuthenticationHeaders$purchases_defaultsBc8Release(), false, this.appConfig.getFallbackBaseURLs(), 0, 160, null);
            }

            @Override // com.revenuecat.purchases.common.Dispatcher.AsyncCall
            public void onCompletion(HTTPResult result) {
                List<Pair<Function0<Unit>, Function1<PurchasesError, Unit>>> listRemove;
                Intrinsics.checkNotNullParameter(result, "result");
                if (!BackendHelperKt.isSuccessful(result)) {
                    PurchasesError purchasesError = ErrorsKt.toPurchasesError(result);
                    LogUtilsKt.errorLog(purchasesError);
                    onError(purchasesError);
                    return;
                }
                Backend backend = this;
                List<String> list = listListOfNotNull;
                synchronized (backend) {
                    listRemove = backend.getAliasCallbacks().remove(list);
                }
                if (listRemove != null) {
                    Iterator<T> it = listRemove.iterator();
                    while (it.hasNext()) {
                        ((Function0) ((Pair) it.next()).a()).invoke();
                    }
                }
            }

            @Override // com.revenuecat.purchases.common.Dispatcher.AsyncCall
            public void onError(PurchasesError error) {
                List<Pair<Function0<Unit>, Function1<PurchasesError, Unit>>> listRemove;
                Intrinsics.checkNotNullParameter(error, "error");
                Backend backend = this;
                List<String> list = listListOfNotNull;
                synchronized (backend) {
                    listRemove = backend.getAliasCallbacks().remove(list);
                }
                if (listRemove != null) {
                    Iterator<T> it = listRemove.iterator();
                    while (it.hasNext()) {
                        ((Function1) ((Pair) it.next()).b()).invoke(error);
                    }
                }
            }
        };
        synchronized (this) {
            try {
                try {
                    addCallback$default(this, this.aliasCallbacks, asyncCall, this.dispatcher, listListOfNotNull, TuplesKt.a(onSuccessHandler, onErrorHandler), null, 16, null);
                    Unit unit = Unit.f139807a;
                } catch (Throwable th) {
                    th = th;
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        }
    }

    public final void clearCaches() {
        this.httpClient.clearCaches();
    }

    public final void close() {
        this.dispatcher.close();
    }

    public final synchronized Map<List<String>, List<Pair<Function0<Unit>, Function1<PurchasesError, Unit>>>> getAliasCallbacks() {
        return this.aliasCallbacks;
    }

    public final synchronized Map<BackgroundAwareCallbackCacheKey, List<Pair<Function1<CustomerInfo, Unit>, Function2<PurchasesError, Boolean, Unit>>>> getCallbacks() {
        return this.callbacks;
    }

    public final synchronized Map<String, List<Pair<Function1<Boolean, Unit>, Function1<PurchasesError, Unit>>>> getCreateSupportTicketCallbacks() {
        return this.createSupportTicketCallbacks;
    }

    public final synchronized Map<String, List<Pair<Function1<CustomerCenterConfigData, Unit>, Function1<PurchasesError, Unit>>>> getCustomerCenterCallbacks() {
        return this.customerCenterCallbacks;
    }

    public final void getCustomerCenterConfig(String appUserID, Function1<? super CustomerCenterConfigData, Unit> onSuccessHandler, Function1<? super PurchasesError, Unit> onErrorHandler) {
        Intrinsics.checkNotNullParameter(appUserID, "appUserID");
        Intrinsics.checkNotNullParameter(onSuccessHandler, "onSuccessHandler");
        Intrinsics.checkNotNullParameter(onErrorHandler, "onErrorHandler");
        final Endpoint.GetCustomerCenterConfig getCustomerCenterConfig = new Endpoint.GetCustomerCenterConfig(appUserID);
        final String path$default = Endpoint.getPath$default(getCustomerCenterConfig, false, 1, null);
        Dispatcher.AsyncCall asyncCall = new Dispatcher.AsyncCall() { // from class: com.revenuecat.purchases.common.Backend$getCustomerCenterConfig$call$1
            @Override // com.revenuecat.purchases.common.Dispatcher.AsyncCall
            public HTTPResult call() {
                return HTTPClient.performRequest$default(this.this$0.httpClient, this.this$0.appConfig.getBaseURL(), getCustomerCenterConfig, null, null, this.this$0.backendHelper.getAuthenticationHeaders$purchases_defaultsBc8Release(), false, this.this$0.appConfig.getFallbackBaseURLs(), 0, 160, null);
            }

            @Override // com.revenuecat.purchases.common.Dispatcher.AsyncCall
            public void onCompletion(HTTPResult result) {
                List<Pair<Function1<CustomerCenterConfigData, Unit>, Function1<PurchasesError, Unit>>> listRemove;
                Intrinsics.checkNotNullParameter(result, "result");
                Backend backend = this.this$0;
                String str = path$default;
                synchronized (backend) {
                    listRemove = backend.getCustomerCenterCallbacks().remove(str);
                }
                if (listRemove != null) {
                    Iterator<T> it = listRemove.iterator();
                    while (it.hasNext()) {
                        Pair pair = (Pair) it.next();
                        Function1 function1 = (Function1) pair.a();
                        Function1 function12 = (Function1) pair.b();
                        if (BackendHelperKt.isSuccessful(result)) {
                            try {
                                Json json$purchases_defaultsBc8Release = Backend.Companion.getJson$purchases_defaultsBc8Release();
                                String payload = result.getPayload();
                                json$purchases_defaultsBc8Release.a();
                                function1.invoke(((CustomerCenterRoot) json$purchases_defaultsBc8Release.d(CustomerCenterRoot.Companion.serializer(), payload)).getCustomerCenter());
                            } catch (SerializationException e3) {
                                PurchasesError purchasesError = ErrorsKt.toPurchasesError(e3);
                                LogUtilsKt.errorLog(purchasesError);
                                function12.invoke(purchasesError);
                            } catch (IllegalArgumentException e4) {
                                PurchasesError purchasesError2 = ErrorsKt.toPurchasesError(e4);
                                LogUtilsKt.errorLog(purchasesError2);
                                function12.invoke(purchasesError2);
                            }
                        } else {
                            PurchasesError purchasesError3 = ErrorsKt.toPurchasesError(result);
                            LogUtilsKt.errorLog(purchasesError3);
                            function12.invoke(purchasesError3);
                        }
                    }
                }
            }

            @Override // com.revenuecat.purchases.common.Dispatcher.AsyncCall
            public void onError(PurchasesError error) {
                List<Pair<Function1<CustomerCenterConfigData, Unit>, Function1<PurchasesError, Unit>>> listRemove;
                Intrinsics.checkNotNullParameter(error, "error");
                Backend backend = this.this$0;
                String str = path$default;
                synchronized (backend) {
                    listRemove = backend.getCustomerCenterCallbacks().remove(str);
                }
                if (listRemove != null) {
                    Iterator<T> it = listRemove.iterator();
                    while (it.hasNext()) {
                        ((Function1) ((Pair) it.next()).b()).invoke(error);
                    }
                }
            }
        };
        synchronized (this) {
            try {
                try {
                    addCallback(this.customerCenterCallbacks, asyncCall, this.dispatcher, path$default, TuplesKt.a(onSuccessHandler, onErrorHandler), Delay.NONE);
                    Unit unit = Unit.f139807a;
                } catch (Throwable th) {
                    th = th;
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        }
    }

    public final void getCustomerInfo(String appUserID, boolean z2, Function1<? super CustomerInfo, Unit> onSuccess, Function2<? super PurchasesError, ? super Boolean, Unit> onError) {
        Throwable th;
        BackgroundAwareCallbackCacheKey backgroundAwareCallbackCacheKey;
        Throwable th2;
        Delay delay;
        Intrinsics.checkNotNullParameter(appUserID, "appUserID");
        Intrinsics.checkNotNullParameter(onSuccess, "onSuccess");
        Intrinsics.checkNotNullParameter(onError, "onError");
        final Endpoint.GetCustomerInfo getCustomerInfo = new Endpoint.GetCustomerInfo(appUserID);
        String path$default = Endpoint.getPath$default(getCustomerInfo, false, 1, null);
        synchronized (this) {
            try {
                if (this.postReceiptCallbacks.isEmpty()) {
                    try {
                        backgroundAwareCallbackCacheKey = new BackgroundAwareCallbackCacheKey(CollectionsKt.listOf(path$default), z2);
                    } catch (Throwable th3) {
                        th = th3;
                        throw th;
                    }
                } else {
                    backgroundAwareCallbackCacheKey = new BackgroundAwareCallbackCacheKey(CollectionsKt.plus((Collection<? extends String>) CollectionsKt.listOf(path$default), String.valueOf(this.callbacks.size())), z2);
                }
                final BackgroundAwareCallbackCacheKey backgroundAwareCallbackCacheKey2 = backgroundAwareCallbackCacheKey;
                Dispatcher.AsyncCall asyncCall = new Dispatcher.AsyncCall() { // from class: com.revenuecat.purchases.common.Backend$getCustomerInfo$call$1
                    @Override // com.revenuecat.purchases.common.Dispatcher.AsyncCall
                    public HTTPResult call() {
                        return HTTPClient.performRequest$default(this.this$0.httpClient, this.this$0.appConfig.getBaseURL(), getCustomerInfo, null, null, this.this$0.backendHelper.getAuthenticationHeaders$purchases_defaultsBc8Release(), false, this.this$0.appConfig.getFallbackBaseURLs(), 0, 160, null);
                    }

                    @Override // com.revenuecat.purchases.common.Dispatcher.AsyncCall
                    public void onCompletion(HTTPResult result) {
                        List<Pair<Function1<CustomerInfo, Unit>, Function2<PurchasesError, Boolean, Unit>>> listRemove;
                        Intrinsics.checkNotNullParameter(result, "result");
                        Backend backend = this.this$0;
                        BackgroundAwareCallbackCacheKey backgroundAwareCallbackCacheKey3 = backgroundAwareCallbackCacheKey2;
                        synchronized (backend) {
                            listRemove = backend.getCallbacks().remove(backgroundAwareCallbackCacheKey3);
                        }
                        if (listRemove != null) {
                            Iterator<T> it = listRemove.iterator();
                            while (it.hasNext()) {
                                Pair pair = (Pair) it.next();
                                Function1 function1 = (Function1) pair.a();
                                Function2 function2 = (Function2) pair.b();
                                try {
                                    if (BackendHelperKt.isSuccessful(result)) {
                                        function1.invoke(CustomerInfoFactory.INSTANCE.buildCustomerInfo(result));
                                    } else {
                                        PurchasesError purchasesError = ErrorsKt.toPurchasesError(result);
                                        LogUtilsKt.errorLog(purchasesError);
                                        function2.invoke(purchasesError, Boolean.valueOf(RCHTTPStatusCodes.INSTANCE.isServerError(result.getResponseCode())));
                                    }
                                } catch (JSONException e3) {
                                    PurchasesError purchasesError2 = ErrorsKt.toPurchasesError(e3);
                                    LogUtilsKt.errorLog(purchasesError2);
                                    function2.invoke(purchasesError2, Boolean.FALSE);
                                }
                            }
                        }
                    }

                    @Override // com.revenuecat.purchases.common.Dispatcher.AsyncCall
                    public void onError(PurchasesError error) {
                        List<Pair<Function1<CustomerInfo, Unit>, Function2<PurchasesError, Boolean, Unit>>> listRemove;
                        Intrinsics.checkNotNullParameter(error, "error");
                        Backend backend = this.this$0;
                        BackgroundAwareCallbackCacheKey backgroundAwareCallbackCacheKey3 = backgroundAwareCallbackCacheKey2;
                        synchronized (backend) {
                            listRemove = backend.getCallbacks().remove(backgroundAwareCallbackCacheKey3);
                        }
                        if (listRemove != null) {
                            Iterator<T> it = listRemove.iterator();
                            while (it.hasNext()) {
                                ((Function2) ((Pair) it.next()).b()).invoke(error, Boolean.FALSE);
                            }
                        }
                    }
                };
                synchronized (this) {
                    if (z2) {
                        try {
                            delay = Delay.DEFAULT;
                        } catch (Throwable th4) {
                            th2 = th4;
                            throw th2;
                        }
                    } else {
                        try {
                            delay = Delay.NONE;
                        } catch (Throwable th5) {
                            th = th5;
                            th2 = th;
                            throw th2;
                        }
                    }
                    try {
                        addBackgroundAwareCallback(this.callbacks, asyncCall, this.dispatcher, backgroundAwareCallbackCacheKey2, TuplesKt.a(onSuccess, onError), delay);
                        Unit unit = Unit.f139807a;
                    } catch (Throwable th6) {
                        th = th6;
                        th2 = th;
                        throw th2;
                    }
                }
            } catch (Throwable th7) {
                th = th7;
            }
        }
    }

    public final synchronized Map<List<String>, List<Pair<Function1<JSONObject, Unit>, Function2<PurchasesError, Boolean, Unit>>>> getDiagnosticsCallbacks() {
        return this.diagnosticsCallbacks;
    }

    public final synchronized Map<List<String>, List<Pair<Function2<CustomerInfo, Boolean, Unit>, Function1<PurchasesError, Unit>>>> getIdentifyCallbacks() {
        return this.identifyCallbacks;
    }

    public final void getOfferings(String appUserID, boolean z2, Function2<? super JSONObject, ? super HTTPResponseOriginalSource, Unit> onSuccess, Function2<? super PurchasesError, ? super GetOfferingsErrorHandlingBehavior, Unit> onError) {
        Delay delay;
        Throwable th;
        Intrinsics.checkNotNullParameter(appUserID, "appUserID");
        Intrinsics.checkNotNullParameter(onSuccess, "onSuccess");
        Intrinsics.checkNotNullParameter(onError, "onError");
        final Endpoint.GetOfferings getOfferings = new Endpoint.GetOfferings(appUserID);
        final BackgroundAwareCallbackCacheKey backgroundAwareCallbackCacheKey = new BackgroundAwareCallbackCacheKey(CollectionsKt.listOf(Endpoint.getPath$default(getOfferings, false, 1, null)), z2);
        Dispatcher.AsyncCall asyncCall = new Dispatcher.AsyncCall() { // from class: com.revenuecat.purchases.common.Backend$getOfferings$call$1
            @Override // com.revenuecat.purchases.common.Dispatcher.AsyncCall
            public HTTPResult call() {
                return HTTPClient.performRequest$default(this.this$0.httpClient, this.this$0.appConfig.getBaseURL(), getOfferings, null, null, this.this$0.backendHelper.getAuthenticationHeaders$purchases_defaultsBc8Release(), false, this.this$0.appConfig.getFallbackBaseURLs(), 0, 160, null);
            }

            @Override // com.revenuecat.purchases.common.Dispatcher.AsyncCall
            public void onCompletion(HTTPResult result) {
                List<Pair<Function2<JSONObject, HTTPResponseOriginalSource, Unit>, Function2<PurchasesError, GetOfferingsErrorHandlingBehavior, Unit>>> listRemove;
                Intrinsics.checkNotNullParameter(result, "result");
                Backend backend = this.this$0;
                BackgroundAwareCallbackCacheKey backgroundAwareCallbackCacheKey2 = backgroundAwareCallbackCacheKey;
                synchronized (backend) {
                    listRemove = backend.getOfferingsCallbacks().remove(backgroundAwareCallbackCacheKey2);
                }
                if (listRemove != null) {
                    Iterator<T> it = listRemove.iterator();
                    while (it.hasNext()) {
                        Pair pair = (Pair) it.next();
                        Function2 function2 = (Function2) pair.a();
                        Function2 function22 = (Function2) pair.b();
                        if (BackendHelperKt.isSuccessful(result)) {
                            try {
                                function2.invoke(result.getBody(), HTTPResponseOriginalSourceKt.getOriginalDataSource(result));
                            } catch (JSONException e3) {
                                GetOfferingsErrorHandlingBehavior getOfferingsErrorHandlingBehavior = GetOfferingsErrorHandlingBehavior.SHOULD_FALLBACK_TO_CACHED_OFFERINGS;
                                PurchasesError purchasesError = ErrorsKt.toPurchasesError(e3);
                                LogUtilsKt.errorLog(purchasesError);
                                function22.invoke(purchasesError, getOfferingsErrorHandlingBehavior);
                            }
                        } else {
                            GetOfferingsErrorHandlingBehavior getOfferingsErrorHandlingBehavior2 = RCHTTPStatusCodes.INSTANCE.isServerError(result.getResponseCode()) ? GetOfferingsErrorHandlingBehavior.SHOULD_FALLBACK_TO_CACHED_OFFERINGS : GetOfferingsErrorHandlingBehavior.SHOULD_NOT_FALLBACK;
                            PurchasesError purchasesError2 = ErrorsKt.toPurchasesError(result);
                            LogUtilsKt.errorLog(purchasesError2);
                            function22.invoke(purchasesError2, getOfferingsErrorHandlingBehavior2);
                        }
                    }
                }
            }

            @Override // com.revenuecat.purchases.common.Dispatcher.AsyncCall
            public void onError(PurchasesError error) {
                List<Pair<Function2<JSONObject, HTTPResponseOriginalSource, Unit>, Function2<PurchasesError, GetOfferingsErrorHandlingBehavior, Unit>>> listRemove;
                Intrinsics.checkNotNullParameter(error, "error");
                Backend backend = this.this$0;
                BackgroundAwareCallbackCacheKey backgroundAwareCallbackCacheKey2 = backgroundAwareCallbackCacheKey;
                synchronized (backend) {
                    listRemove = backend.getOfferingsCallbacks().remove(backgroundAwareCallbackCacheKey2);
                }
                if (listRemove != null) {
                    Iterator<T> it = listRemove.iterator();
                    while (it.hasNext()) {
                        ((Function2) ((Pair) it.next()).b()).invoke(error, GetOfferingsErrorHandlingBehavior.SHOULD_FALLBACK_TO_CACHED_OFFERINGS);
                    }
                }
            }
        };
        synchronized (this) {
            if (z2) {
                try {
                    delay = Delay.DEFAULT;
                } catch (Throwable th2) {
                    th = th2;
                    throw th;
                }
            } else {
                try {
                    delay = Delay.NONE;
                } catch (Throwable th3) {
                    th = th3;
                    th = th;
                    throw th;
                }
            }
            try {
                addBackgroundAwareCallback(this.offeringsCallbacks, asyncCall, this.dispatcher, backgroundAwareCallbackCacheKey, TuplesKt.a(onSuccess, onError), delay);
                Unit unit = Unit.f139807a;
            } catch (Throwable th4) {
                th = th4;
                th = th;
                throw th;
            }
        }
    }

    public final synchronized Map<BackgroundAwareCallbackCacheKey, List<Pair<Function2<JSONObject, HTTPResponseOriginalSource, Unit>, Function2<PurchasesError, GetOfferingsErrorHandlingBehavior, Unit>>>> getOfferingsCallbacks() {
        return this.offeringsCallbacks;
    }

    public final synchronized Map<List<String>, List<Pair<Function0<Unit>, Function2<PurchasesError, Boolean, Unit>>>> getPaywallEventsCallbacks() {
        return this.paywallEventsCallbacks;
    }

    public final synchronized Map<List<String>, List<Pair<Function1<PostReceiptResponse, Unit>, Function3<PurchasesError, PostReceiptErrorHandlingBehavior, JSONObject, Unit>>>> getPostReceiptCallbacks() {
        return this.postReceiptCallbacks;
    }

    public final synchronized Map<String, List<Pair<Function1<ProductEntitlementMapping, Unit>, Function1<PurchasesError, Unit>>>> getProductEntitlementCallbacks() {
        return this.productEntitlementCallbacks;
    }

    public final void getProductEntitlementMapping(Function1<? super ProductEntitlementMapping, Unit> onSuccessHandler, Function1<? super PurchasesError, Unit> onErrorHandler) {
        Intrinsics.checkNotNullParameter(onSuccessHandler, "onSuccessHandler");
        Intrinsics.checkNotNullParameter(onErrorHandler, "onErrorHandler");
        final Endpoint.GetProductEntitlementMapping getProductEntitlementMapping = Endpoint.GetProductEntitlementMapping.INSTANCE;
        final String path$default = Endpoint.getPath$default(getProductEntitlementMapping, false, 1, null);
        Dispatcher.AsyncCall asyncCall = new Dispatcher.AsyncCall() { // from class: com.revenuecat.purchases.common.Backend$getProductEntitlementMapping$call$1
            @Override // com.revenuecat.purchases.common.Dispatcher.AsyncCall
            public HTTPResult call() {
                return HTTPClient.performRequest$default(this.this$0.httpClient, this.this$0.appConfig.getBaseURL(), getProductEntitlementMapping, null, null, this.this$0.backendHelper.getAuthenticationHeaders$purchases_defaultsBc8Release(), false, this.this$0.appConfig.getFallbackBaseURLs(), 0, 160, null);
            }

            @Override // com.revenuecat.purchases.common.Dispatcher.AsyncCall
            public void onCompletion(HTTPResult result) {
                List<Pair<Function1<ProductEntitlementMapping, Unit>, Function1<PurchasesError, Unit>>> listRemove;
                Intrinsics.checkNotNullParameter(result, "result");
                Backend backend = this.this$0;
                String str = path$default;
                synchronized (backend) {
                    listRemove = backend.getProductEntitlementCallbacks().remove(str);
                }
                if (listRemove != null) {
                    Iterator<T> it = listRemove.iterator();
                    while (it.hasNext()) {
                        Pair pair = (Pair) it.next();
                        Function1 function1 = (Function1) pair.a();
                        Function1 function12 = (Function1) pair.b();
                        if (BackendHelperKt.isSuccessful(result)) {
                            try {
                                function1.invoke(ProductEntitlementMapping.Companion.fromNetwork$purchases_defaultsBc8Release(result.getBody(), result));
                            } catch (JSONException e3) {
                                PurchasesError purchasesError = ErrorsKt.toPurchasesError(e3);
                                LogUtilsKt.errorLog(purchasesError);
                                function12.invoke(purchasesError);
                            }
                        } else {
                            PurchasesError purchasesError2 = ErrorsKt.toPurchasesError(result);
                            LogUtilsKt.errorLog(purchasesError2);
                            function12.invoke(purchasesError2);
                        }
                    }
                }
            }

            @Override // com.revenuecat.purchases.common.Dispatcher.AsyncCall
            public void onError(PurchasesError error) {
                List<Pair<Function1<ProductEntitlementMapping, Unit>, Function1<PurchasesError, Unit>>> listRemove;
                Intrinsics.checkNotNullParameter(error, "error");
                Backend backend = this.this$0;
                String str = path$default;
                synchronized (backend) {
                    listRemove = backend.getProductEntitlementCallbacks().remove(str);
                }
                if (listRemove != null) {
                    Iterator<T> it = listRemove.iterator();
                    while (it.hasNext()) {
                        ((Function1) ((Pair) it.next()).b()).invoke(error);
                    }
                }
            }
        };
        synchronized (this) {
            try {
                try {
                    addCallback(this.productEntitlementCallbacks, asyncCall, this.dispatcher, path$default, TuplesKt.a(onSuccessHandler, onErrorHandler), Delay.LONG);
                    Unit unit = Unit.f139807a;
                } catch (Throwable th) {
                    th = th;
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        }
    }

    public final synchronized Map<String, List<Function1<RedeemWebPurchaseListener.Result, Unit>>> getRedeemWebPurchaseCallbacks() {
        return this.redeemWebPurchaseCallbacks;
    }

    public final SignatureVerificationMode getVerificationMode() {
        return this.httpClient.getSigningManager().getSignatureVerificationMode();
    }

    public final void getVirtualCurrencies(String appUserID, boolean z2, Function1<? super VirtualCurrencies, Unit> onSuccess, Function1<? super PurchasesError, Unit> onError) throws Throwable {
        Delay delay;
        Throwable th;
        Intrinsics.checkNotNullParameter(appUserID, "appUserID");
        Intrinsics.checkNotNullParameter(onSuccess, "onSuccess");
        Intrinsics.checkNotNullParameter(onError, "onError");
        final Endpoint.GetVirtualCurrencies getVirtualCurrencies = new Endpoint.GetVirtualCurrencies(appUserID);
        final BackgroundAwareCallbackCacheKey backgroundAwareCallbackCacheKey = new BackgroundAwareCallbackCacheKey(CollectionsKt.listOf(Endpoint.getPath$default(getVirtualCurrencies, false, 1, null)), z2);
        Dispatcher.AsyncCall asyncCall = new Dispatcher.AsyncCall() { // from class: com.revenuecat.purchases.common.Backend$getVirtualCurrencies$call$1
            @Override // com.revenuecat.purchases.common.Dispatcher.AsyncCall
            public HTTPResult call() {
                return HTTPClient.performRequest$default(this.this$0.httpClient, this.this$0.appConfig.getBaseURL(), getVirtualCurrencies, null, null, this.this$0.backendHelper.getAuthenticationHeaders$purchases_defaultsBc8Release(), false, this.this$0.appConfig.getFallbackBaseURLs(), 0, 160, null);
            }

            @Override // com.revenuecat.purchases.common.Dispatcher.AsyncCall
            public void onCompletion(HTTPResult result) {
                List<Pair<Function1<VirtualCurrencies, Unit>, Function1<PurchasesError, Unit>>> listRemove;
                Intrinsics.checkNotNullParameter(result, "result");
                Backend backend = this.this$0;
                BackgroundAwareCallbackCacheKey backgroundAwareCallbackCacheKey2 = backgroundAwareCallbackCacheKey;
                synchronized (backend) {
                    listRemove = backend.getVirtualCurrenciesCallbacks().remove(backgroundAwareCallbackCacheKey2);
                }
                if (listRemove != null) {
                    Iterator<T> it = listRemove.iterator();
                    while (it.hasNext()) {
                        Pair pair = (Pair) it.next();
                        Function1 function1 = (Function1) pair.a();
                        Function1 function12 = (Function1) pair.b();
                        if (BackendHelperKt.isSuccessful(result)) {
                            try {
                                function1.invoke(VirtualCurrenciesFactory.INSTANCE.buildVirtualCurrencies(result));
                            } catch (SerializationException e3) {
                                PurchasesError purchasesError = ErrorsKt.toPurchasesError(e3);
                                LogUtilsKt.errorLog(purchasesError);
                                function12.invoke(purchasesError);
                            } catch (IllegalArgumentException e4) {
                                PurchasesError purchasesError2 = ErrorsKt.toPurchasesError(e4);
                                LogUtilsKt.errorLog(purchasesError2);
                                function12.invoke(purchasesError2);
                            } catch (JSONException e5) {
                                PurchasesError purchasesError3 = ErrorsKt.toPurchasesError(e5);
                                LogUtilsKt.errorLog(purchasesError3);
                                function12.invoke(purchasesError3);
                            }
                        } else {
                            PurchasesError purchasesError4 = ErrorsKt.toPurchasesError(result);
                            LogUtilsKt.errorLog(purchasesError4);
                            function12.invoke(purchasesError4);
                        }
                    }
                }
            }

            @Override // com.revenuecat.purchases.common.Dispatcher.AsyncCall
            public void onError(PurchasesError error) {
                List<Pair<Function1<VirtualCurrencies, Unit>, Function1<PurchasesError, Unit>>> listRemove;
                Intrinsics.checkNotNullParameter(error, "error");
                Backend backend = this.this$0;
                BackgroundAwareCallbackCacheKey backgroundAwareCallbackCacheKey2 = backgroundAwareCallbackCacheKey;
                synchronized (backend) {
                    listRemove = backend.getVirtualCurrenciesCallbacks().remove(backgroundAwareCallbackCacheKey2);
                }
                if (listRemove != null) {
                    Iterator<T> it = listRemove.iterator();
                    while (it.hasNext()) {
                        ((Function1) ((Pair) it.next()).b()).invoke(error);
                    }
                }
            }
        };
        synchronized (this) {
            if (z2) {
                try {
                    delay = Delay.DEFAULT;
                } catch (Throwable th2) {
                    th = th2;
                    throw th;
                }
            } else {
                try {
                    delay = Delay.NONE;
                } catch (Throwable th3) {
                    th = th3;
                    th = th;
                    throw th;
                }
            }
            try {
                addBackgroundAwareCallback(this.virtualCurrenciesCallbacks, asyncCall, this.dispatcher, backgroundAwareCallbackCacheKey, TuplesKt.a(onSuccess, onError), delay);
                Unit unit = Unit.f139807a;
            } catch (Throwable th4) {
                th = th4;
                th = th;
                throw th;
            }
        }
    }

    public final synchronized Map<BackgroundAwareCallbackCacheKey, List<Pair<Function1<VirtualCurrencies, Unit>, Function1<PurchasesError, Unit>>>> getVirtualCurrenciesCallbacks() {
        return this.virtualCurrenciesCallbacks;
    }

    public final void getWebBillingProducts(String appUserID, Set<String> productIds, Function1<? super WebBillingProductsResponse, Unit> onSuccess, Function1<? super PurchasesError, Unit> onError) throws Throwable {
        Intrinsics.checkNotNullParameter(appUserID, "appUserID");
        Intrinsics.checkNotNullParameter(productIds, "productIds");
        Intrinsics.checkNotNullParameter(onSuccess, "onSuccess");
        Intrinsics.checkNotNullParameter(onError, "onError");
        final Endpoint.WebBillingGetProducts webBillingGetProducts = new Endpoint.WebBillingGetProducts(appUserID, productIds);
        final String path$default = Endpoint.getPath$default(webBillingGetProducts, false, 1, null);
        Dispatcher.AsyncCall asyncCall = new Dispatcher.AsyncCall() { // from class: com.revenuecat.purchases.common.Backend$getWebBillingProducts$call$1
            @Override // com.revenuecat.purchases.common.Dispatcher.AsyncCall
            public HTTPResult call() {
                return HTTPClient.performRequest$default(this.this$0.httpClient, this.this$0.appConfig.getBaseURL(), webBillingGetProducts, null, null, this.this$0.backendHelper.getAuthenticationHeaders$purchases_defaultsBc8Release(), false, this.this$0.appConfig.getFallbackBaseURLs(), 0, 160, null);
            }

            @Override // com.revenuecat.purchases.common.Dispatcher.AsyncCall
            public void onCompletion(HTTPResult result) {
                List<Pair<Function1<WebBillingProductsResponse, Unit>, Function1<PurchasesError, Unit>>> listRemove;
                Intrinsics.checkNotNullParameter(result, "result");
                Backend backend = this.this$0;
                String str = path$default;
                synchronized (backend) {
                    listRemove = backend.getWebBillingProductsCallbacks().remove(str);
                }
                if (listRemove != null) {
                    Iterator<T> it = listRemove.iterator();
                    while (it.hasNext()) {
                        Pair pair = (Pair) it.next();
                        Function1 function1 = (Function1) pair.a();
                        Function1 function12 = (Function1) pair.b();
                        if (BackendHelperKt.isSuccessful(result)) {
                            try {
                                Json json$purchases_defaultsBc8Release = Backend.Companion.getJson$purchases_defaultsBc8Release();
                                String payload = result.getPayload();
                                json$purchases_defaultsBc8Release.a();
                                function1.invoke((WebBillingProductsResponse) json$purchases_defaultsBc8Release.d(WebBillingProductsResponse.Companion.serializer(), payload));
                            } catch (SerializationException e3) {
                                PurchasesError purchasesError = ErrorsKt.toPurchasesError(e3);
                                LogUtilsKt.errorLog(purchasesError);
                                function12.invoke(purchasesError);
                            } catch (IllegalArgumentException e4) {
                                PurchasesError purchasesError2 = ErrorsKt.toPurchasesError(e4);
                                LogUtilsKt.errorLog(purchasesError2);
                                function12.invoke(purchasesError2);
                            }
                        } else {
                            PurchasesError purchasesError3 = ErrorsKt.toPurchasesError(result);
                            LogUtilsKt.errorLog(purchasesError3);
                            function12.invoke(purchasesError3);
                        }
                    }
                }
            }

            @Override // com.revenuecat.purchases.common.Dispatcher.AsyncCall
            public void onError(PurchasesError error) {
                List<Pair<Function1<WebBillingProductsResponse, Unit>, Function1<PurchasesError, Unit>>> listRemove;
                Intrinsics.checkNotNullParameter(error, "error");
                Backend backend = this.this$0;
                String str = path$default;
                synchronized (backend) {
                    listRemove = backend.getWebBillingProductsCallbacks().remove(str);
                }
                if (listRemove != null) {
                    Iterator<T> it = listRemove.iterator();
                    while (it.hasNext()) {
                        ((Function1) ((Pair) it.next()).b()).invoke(error);
                    }
                }
            }
        };
        synchronized (this) {
            try {
                try {
                    addCallback(this.webBillingProductsCallbacks, asyncCall, this.dispatcher, path$default, TuplesKt.a(onSuccess, onError), Delay.NONE);
                    Unit unit = Unit.f139807a;
                } catch (Throwable th) {
                    th = th;
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        }
    }

    public final synchronized Map<String, List<Pair<Function1<WebBillingProductsResponse, Unit>, Function1<PurchasesError, Unit>>>> getWebBillingProductsCallbacks() {
        return this.webBillingProductsCallbacks;
    }

    public final void getWorkflow(String appUserID, String workflowId, boolean z2, Function1<? super WorkflowDetailResponse, Unit> onSuccess, Function1<? super PurchasesError, Unit> onError) throws Throwable {
        Delay delay;
        Throwable th;
        Intrinsics.checkNotNullParameter(appUserID, "appUserID");
        Intrinsics.checkNotNullParameter(workflowId, "workflowId");
        Intrinsics.checkNotNullParameter(onSuccess, "onSuccess");
        Intrinsics.checkNotNullParameter(onError, "onError");
        final Endpoint.GetWorkflow getWorkflow = new Endpoint.GetWorkflow(appUserID, workflowId);
        final BackgroundAwareCallbackCacheKey backgroundAwareCallbackCacheKey = new BackgroundAwareCallbackCacheKey(CollectionsKt.listOf(Endpoint.getPath$default(getWorkflow, false, 1, null)), z2);
        Dispatcher.AsyncCall asyncCall = new Dispatcher.AsyncCall() { // from class: com.revenuecat.purchases.common.Backend$getWorkflow$call$1
            @Override // com.revenuecat.purchases.common.Dispatcher.AsyncCall
            public HTTPResult call() {
                return HTTPClient.performRequest$default(this.this$0.httpClient, this.this$0.appConfig.getBaseURL(), getWorkflow, null, null, this.this$0.backendHelper.getAuthenticationHeaders$purchases_defaultsBc8Release(), false, this.this$0.appConfig.getFallbackBaseURLs(), 0, 160, null);
            }

            @Override // com.revenuecat.purchases.common.Dispatcher.AsyncCall
            public void onCompletion(HTTPResult result) {
                List<Pair<Function1<WorkflowDetailResponse, Unit>, Function1<PurchasesError, Unit>>> listRemove;
                Intrinsics.checkNotNullParameter(result, "result");
                Backend backend = this.this$0;
                BackgroundAwareCallbackCacheKey backgroundAwareCallbackCacheKey2 = backgroundAwareCallbackCacheKey;
                synchronized (backend) {
                    listRemove = backend.getWorkflowDetailCallbacks().remove(backgroundAwareCallbackCacheKey2);
                }
                if (listRemove != null) {
                    Iterator<T> it = listRemove.iterator();
                    while (it.hasNext()) {
                        Pair pair = (Pair) it.next();
                        Function1 function1 = (Function1) pair.a();
                        Function1 function12 = (Function1) pair.b();
                        if (BackendHelperKt.isSuccessful(result)) {
                            try {
                                function1.invoke(WorkflowJsonParser.INSTANCE.parseWorkflowDetailResponse(result.getPayload()));
                            } catch (SerializationException e3) {
                                PurchasesError purchasesError = ErrorsKt.toPurchasesError(e3);
                                LogUtilsKt.errorLog(purchasesError);
                                function12.invoke(purchasesError);
                            } catch (IllegalArgumentException e4) {
                                PurchasesError purchasesError2 = ErrorsKt.toPurchasesError(e4);
                                LogUtilsKt.errorLog(purchasesError2);
                                function12.invoke(purchasesError2);
                            }
                        } else {
                            PurchasesError purchasesError3 = ErrorsKt.toPurchasesError(result);
                            LogUtilsKt.errorLog(purchasesError3);
                            function12.invoke(purchasesError3);
                        }
                    }
                }
            }

            @Override // com.revenuecat.purchases.common.Dispatcher.AsyncCall
            public void onError(PurchasesError error) {
                List<Pair<Function1<WorkflowDetailResponse, Unit>, Function1<PurchasesError, Unit>>> listRemove;
                Intrinsics.checkNotNullParameter(error, "error");
                Backend backend = this.this$0;
                BackgroundAwareCallbackCacheKey backgroundAwareCallbackCacheKey2 = backgroundAwareCallbackCacheKey;
                synchronized (backend) {
                    listRemove = backend.getWorkflowDetailCallbacks().remove(backgroundAwareCallbackCacheKey2);
                }
                if (listRemove != null) {
                    Iterator<T> it = listRemove.iterator();
                    while (it.hasNext()) {
                        ((Function1) ((Pair) it.next()).b()).invoke(error);
                    }
                }
            }
        };
        synchronized (this) {
            if (z2) {
                try {
                    delay = Delay.DEFAULT;
                } catch (Throwable th2) {
                    th = th2;
                    throw th;
                }
            } else {
                try {
                    delay = Delay.NONE;
                } catch (Throwable th3) {
                    th = th3;
                    th = th;
                    throw th;
                }
            }
            try {
                addBackgroundAwareCallback(this.workflowDetailCallbacks, asyncCall, this.dispatcher, backgroundAwareCallbackCacheKey, TuplesKt.a(onSuccess, onError), delay);
                Unit unit = Unit.f139807a;
            } catch (Throwable th4) {
                th = th4;
                th = th;
                throw th;
            }
        }
    }

    public final synchronized Map<BackgroundAwareCallbackCacheKey, List<Pair<Function1<WorkflowDetailResponse, Unit>, Function1<PurchasesError, Unit>>>> getWorkflowDetailCallbacks() {
        return this.workflowDetailCallbacks;
    }

    public final void postCreateSupportTicket(String appUserID, String email, String description, Function1<? super Boolean, Unit> onSuccessHandler, Function1<? super PurchasesError, Unit> onErrorHandler) {
        Intrinsics.checkNotNullParameter(appUserID, "appUserID");
        Intrinsics.checkNotNullParameter(email, "email");
        Intrinsics.checkNotNullParameter(description, "description");
        Intrinsics.checkNotNullParameter(onSuccessHandler, "onSuccessHandler");
        Intrinsics.checkNotNullParameter(onErrorHandler, "onErrorHandler");
        final Endpoint.PostCreateSupportTicket postCreateSupportTicket = Endpoint.PostCreateSupportTicket.INSTANCE;
        final String path$default = Endpoint.getPath$default(postCreateSupportTicket, false, 1, null);
        final Map mapMapOf = MapsKt.mapOf(TuplesKt.a(APP_USER_ID, appUserID), TuplesKt.a("customer_email", email), TuplesKt.a("issue_description", description));
        Dispatcher.AsyncCall asyncCall = new Dispatcher.AsyncCall() { // from class: com.revenuecat.purchases.common.Backend$postCreateSupportTicket$call$1
            @Override // com.revenuecat.purchases.common.Dispatcher.AsyncCall
            public HTTPResult call() {
                return HTTPClient.performRequest$default(this.this$0.httpClient, this.this$0.appConfig.getBaseURL(), postCreateSupportTicket, mapMapOf, null, this.this$0.backendHelper.getAuthenticationHeaders$purchases_defaultsBc8Release(), false, this.this$0.appConfig.getFallbackBaseURLs(), 0, 160, null);
            }

            @Override // com.revenuecat.purchases.common.Dispatcher.AsyncCall
            public void onCompletion(HTTPResult result) {
                List<Pair<Function1<Boolean, Unit>, Function1<PurchasesError, Unit>>> listRemove;
                Intrinsics.checkNotNullParameter(result, "result");
                Backend backend = this.this$0;
                String str = path$default;
                synchronized (backend) {
                    listRemove = backend.getCreateSupportTicketCallbacks().remove(str);
                }
                if (listRemove != null) {
                    Iterator<T> it = listRemove.iterator();
                    while (it.hasNext()) {
                        Pair pair = (Pair) it.next();
                        Function1 function1 = (Function1) pair.a();
                        Function1 function12 = (Function1) pair.b();
                        if (BackendHelperKt.isSuccessful(result)) {
                            try {
                                function1.invoke(Boolean.valueOf(result.getBody().optBoolean("sent", false)));
                            } catch (SerializationException e3) {
                                PurchasesError purchasesError = ErrorsKt.toPurchasesError(e3);
                                LogUtilsKt.errorLog(purchasesError);
                                function12.invoke(purchasesError);
                            } catch (IllegalArgumentException e4) {
                                PurchasesError purchasesError2 = ErrorsKt.toPurchasesError(e4);
                                LogUtilsKt.errorLog(purchasesError2);
                                function12.invoke(purchasesError2);
                            }
                        } else {
                            PurchasesError purchasesError3 = ErrorsKt.toPurchasesError(result);
                            LogUtilsKt.errorLog(purchasesError3);
                            function12.invoke(purchasesError3);
                        }
                    }
                }
            }

            @Override // com.revenuecat.purchases.common.Dispatcher.AsyncCall
            public void onError(PurchasesError error) {
                List<Pair<Function1<Boolean, Unit>, Function1<PurchasesError, Unit>>> listRemove;
                Intrinsics.checkNotNullParameter(error, "error");
                Backend backend = this.this$0;
                String str = path$default;
                synchronized (backend) {
                    listRemove = backend.getCreateSupportTicketCallbacks().remove(str);
                }
                if (listRemove != null) {
                    Iterator<T> it = listRemove.iterator();
                    while (it.hasNext()) {
                        ((Function1) ((Pair) it.next()).b()).invoke(error);
                    }
                }
            }
        };
        synchronized (this) {
            addCallback(this.createSupportTicketCallbacks, asyncCall, this.dispatcher, path$default, TuplesKt.a(onSuccessHandler, onErrorHandler), Delay.NONE);
            Unit unit = Unit.f139807a;
        }
    }

    public final void postDiagnostics(List<? extends JSONObject> diagnosticsList, Function1<? super JSONObject, Unit> onSuccessHandler, Function2<? super PurchasesError, ? super Boolean, Unit> onErrorHandler) throws Throwable {
        Intrinsics.checkNotNullParameter(diagnosticsList, "diagnosticsList");
        Intrinsics.checkNotNullParameter(onSuccessHandler, "onSuccessHandler");
        Intrinsics.checkNotNullParameter(onErrorHandler, "onErrorHandler");
        List<? extends JSONObject> list = diagnosticsList;
        final ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(String.valueOf(((JSONObject) it.next()).hashCode()));
        }
        final Map mapMapOf = MapsKt.mapOf(TuplesKt.a("entries", new JSONArray((Collection) diagnosticsList)));
        Dispatcher.AsyncCall asyncCall = new Dispatcher.AsyncCall() { // from class: com.revenuecat.purchases.common.Backend$postDiagnostics$call$1
            @Override // com.revenuecat.purchases.common.Dispatcher.AsyncCall
            public HTTPResult call() {
                return HTTPClient.performRequest$default(this.this$0.httpClient, AppConfig.Companion.getDiagnosticsURL(), Endpoint.PostDiagnostics.INSTANCE, mapMapOf, null, this.this$0.backendHelper.getAuthenticationHeaders$purchases_defaultsBc8Release(), false, this.this$0.appConfig.getFallbackBaseURLs(), 0, 160, null);
            }

            @Override // com.revenuecat.purchases.common.Dispatcher.AsyncCall
            public void onCompletion(HTTPResult result) {
                List<Pair<Function1<JSONObject, Unit>, Function2<PurchasesError, Boolean, Unit>>> listRemove;
                Intrinsics.checkNotNullParameter(result, "result");
                Backend backend = this.this$0;
                List<String> list2 = arrayList;
                synchronized (backend) {
                    listRemove = backend.getDiagnosticsCallbacks().remove(list2);
                }
                if (listRemove != null) {
                    Iterator<T> it2 = listRemove.iterator();
                    while (it2.hasNext()) {
                        Pair pair = (Pair) it2.next();
                        Function1 function1 = (Function1) pair.a();
                        Function2 function2 = (Function2) pair.b();
                        if (BackendHelperKt.isSuccessful(result)) {
                            function1.invoke(result.getBody());
                        } else {
                            PurchasesError purchasesError = ErrorsKt.toPurchasesError(result);
                            function2.invoke(purchasesError, Boolean.valueOf(RCHTTPStatusCodes.INSTANCE.isServerError(result.getResponseCode()) || purchasesError.getCode() == PurchasesErrorCode.NetworkError));
                        }
                    }
                }
            }

            @Override // com.revenuecat.purchases.common.Dispatcher.AsyncCall
            public void onError(PurchasesError error) {
                List<Pair<Function1<JSONObject, Unit>, Function2<PurchasesError, Boolean, Unit>>> listRemove;
                Intrinsics.checkNotNullParameter(error, "error");
                Backend backend = this.this$0;
                List<String> list2 = arrayList;
                synchronized (backend) {
                    listRemove = backend.getDiagnosticsCallbacks().remove(list2);
                }
                if (listRemove != null) {
                    Iterator<T> it2 = listRemove.iterator();
                    while (it2.hasNext()) {
                        ((Function2) ((Pair) it2.next()).b()).invoke(error, Boolean.valueOf(error.getCode() == PurchasesErrorCode.NetworkError));
                    }
                }
            }
        };
        synchronized (this) {
            try {
                try {
                    addCallback(this.diagnosticsCallbacks, asyncCall, this.eventsDispatcher, arrayList, TuplesKt.a(onSuccessHandler, onErrorHandler), Delay.LONG);
                    Unit unit = Unit.f139807a;
                } catch (Throwable th) {
                    th = th;
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        }
    }

    public final void postEvents(final EventsRequest paywallEventRequest, final URL baseURL, Delay delay, Function0<Unit> onSuccessHandler, Function2<? super PurchasesError, ? super Boolean, Unit> onErrorHandler) {
        Intrinsics.checkNotNullParameter(paywallEventRequest, "paywallEventRequest");
        Intrinsics.checkNotNullParameter(baseURL, "baseURL");
        Intrinsics.checkNotNullParameter(delay, "delay");
        Intrinsics.checkNotNullParameter(onSuccessHandler, "onSuccessHandler");
        Intrinsics.checkNotNullParameter(onErrorHandler, "onErrorHandler");
        Json defaultJson = JsonProvider.Companion.getDefaultJson();
        defaultJson.a();
        final Map<String, Object> mapAsMap = JsonElementExtensionsKt.asMap(defaultJson.e(EventsRequest.Companion.serializer(), paywallEventRequest));
        if (mapAsMap == null) {
            PurchasesError purchasesError = new PurchasesError(PurchasesErrorCode.UnknownError, "Error encoding paywall event request");
            LogUtilsKt.errorLog(purchasesError);
            onErrorHandler.invoke(purchasesError, Boolean.TRUE);
            return;
        }
        Dispatcher.AsyncCall asyncCall = new Dispatcher.AsyncCall() { // from class: com.revenuecat.purchases.common.Backend$postEvents$call$1
            @Override // com.revenuecat.purchases.common.Dispatcher.AsyncCall
            public HTTPResult call() {
                return HTTPClient.performRequest$default(this.this$0.httpClient, baseURL, Endpoint.PostEvents.INSTANCE, mapAsMap, null, this.this$0.backendHelper.getAuthenticationHeaders$purchases_defaultsBc8Release(), false, this.this$0.appConfig.getFallbackBaseURLs(), 0, 160, null);
            }

            @Override // com.revenuecat.purchases.common.Dispatcher.AsyncCall
            public void onCompletion(HTTPResult result) {
                List<Pair<Function0<Unit>, Function2<PurchasesError, Boolean, Unit>>> listRemove;
                Intrinsics.checkNotNullParameter(result, "result");
                Backend backend = this.this$0;
                EventsRequest eventsRequest = paywallEventRequest;
                synchronized (backend) {
                    listRemove = backend.getPaywallEventsCallbacks().remove(eventsRequest.getCacheKey());
                }
                if (listRemove != null) {
                    Iterator<T> it = listRemove.iterator();
                    while (it.hasNext()) {
                        Pair pair = (Pair) it.next();
                        Function0 function0 = (Function0) pair.a();
                        Function2 function2 = (Function2) pair.b();
                        if (BackendHelperKt.isSuccessful(result)) {
                            function0.invoke();
                        } else {
                            function2.invoke(ErrorsKt.toPurchasesError(result), Boolean.valueOf(RCHTTPStatusCodes.INSTANCE.isSynced(result.getResponseCode())));
                        }
                    }
                }
            }

            @Override // com.revenuecat.purchases.common.Dispatcher.AsyncCall
            public void onError(PurchasesError error) {
                List<Pair<Function0<Unit>, Function2<PurchasesError, Boolean, Unit>>> listRemove;
                Intrinsics.checkNotNullParameter(error, "error");
                Backend backend = this.this$0;
                EventsRequest eventsRequest = paywallEventRequest;
                synchronized (backend) {
                    listRemove = backend.getPaywallEventsCallbacks().remove(eventsRequest.getCacheKey());
                }
                if (listRemove != null) {
                    Iterator<T> it = listRemove.iterator();
                    while (it.hasNext()) {
                        ((Function2) ((Pair) it.next()).b()).invoke(error, Boolean.FALSE);
                    }
                }
            }
        };
        synchronized (this) {
            try {
                try {
                    addCallback(this.paywallEventsCallbacks, asyncCall, this.eventsDispatcher, paywallEventRequest.getCacheKey(), TuplesKt.a(onSuccessHandler, onErrorHandler), delay);
                    Unit unit = Unit.f139807a;
                } catch (Throwable th) {
                    th = th;
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        }
    }

    public final void postReceiptData(String purchaseToken, String appUserID, boolean z2, boolean z3, Map<String, ? extends Map<String, ? extends Object>> map, ReceiptInfo receiptInfo, PostReceiptInitiationSource initiationSource, PaywallPostReceiptData paywallPostReceiptData, PurchasesAreCompletedBy purchasesAreCompletedBy, Function1<? super PostReceiptResponse, Unit> onSuccess, Function3<? super PurchasesError, ? super PostReceiptErrorHandlingBehavior, ? super JSONObject, Unit> onError) {
        ArrayList arrayList;
        PresentedOfferingContext.TargetingContext targetingContext;
        Intrinsics.checkNotNullParameter(purchaseToken, "purchaseToken");
        Intrinsics.checkNotNullParameter(appUserID, "appUserID");
        Map<String, ? extends Map<String, ? extends Object>> subscriberAttributes = map;
        Intrinsics.checkNotNullParameter(subscriberAttributes, "subscriberAttributes");
        Intrinsics.checkNotNullParameter(receiptInfo, "receiptInfo");
        Intrinsics.checkNotNullParameter(initiationSource, "initiationSource");
        Intrinsics.checkNotNullParameter(purchasesAreCompletedBy, "purchasesAreCompletedBy");
        Intrinsics.checkNotNullParameter(onSuccess, "onSuccess");
        Intrinsics.checkNotNullParameter(onError, "onError");
        final List listListOfNotNull = CollectionsKt.listOfNotNull((Object[]) new String[]{purchaseToken, appUserID, String.valueOf(z2), String.valueOf(z3), subscriberAttributes.toString(), receiptInfo.toString(), purchasesAreCompletedBy.toString()});
        Pair pairA = TuplesKt.a(FETCH_TOKEN, purchaseToken);
        Pair pairA2 = TuplesKt.a(DiagnosticsTracker.PRODUCT_IDS_KEY, receiptInfo.getProductIDs());
        Pair pairA3 = TuplesKt.a("platform_product_ids", receiptInfo.getPlatformProductIds());
        Pair pairA4 = TuplesKt.a(APP_USER_ID, appUserID);
        Pair pairA5 = TuplesKt.a("is_restore", Boolean.valueOf(z2));
        PresentedOfferingContext presentedOfferingContext = receiptInfo.getPresentedOfferingContext();
        Pair pairA6 = TuplesKt.a("presented_offering_identifier", presentedOfferingContext != null ? presentedOfferingContext.getOfferingIdentifier() : null);
        PresentedOfferingContext presentedOfferingContext2 = receiptInfo.getPresentedOfferingContext();
        Pair pairA7 = TuplesKt.a("presented_placement_identifier", presentedOfferingContext2 != null ? presentedOfferingContext2.getPlacementIdentifier() : null);
        PresentedOfferingContext presentedOfferingContext3 = receiptInfo.getPresentedOfferingContext();
        Pair pairA8 = TuplesKt.a("applied_targeting_rule", (presentedOfferingContext3 == null || (targetingContext = presentedOfferingContext3.getTargetingContext()) == null) ? null : MapsKt.mapOf(TuplesKt.a("revision", Integer.valueOf(targetingContext.getRevision())), TuplesKt.a("rule_id", targetingContext.getRuleId())));
        Pair pairA9 = TuplesKt.a("observer_mode", Boolean.valueOf(!z3));
        String lowerCase = purchasesAreCompletedBy.name().toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        Pair pairA10 = TuplesKt.a("purchase_completed_by", lowerCase);
        Pair pairA11 = TuplesKt.a("price", receiptInfo.getPrice());
        Pair pairA12 = TuplesKt.a(AppLovinEventParameters.REVENUE_CURRENCY, receiptInfo.getCurrency());
        if (subscriberAttributes.isEmpty() || this.appConfig.getCustomEntitlementComputation()) {
            subscriberAttributes = null;
        }
        Pair pairA13 = TuplesKt.a("attributes", subscriberAttributes);
        Pair pairA14 = TuplesKt.a("normal_duration", receiptInfo.getDuration());
        Pair pairA15 = TuplesKt.a("store_user_id", receiptInfo.getStoreUserID());
        List<PricingPhase> pricingPhases = receiptInfo.getPricingPhases();
        if (pricingPhases != null) {
            List<PricingPhase> list = pricingPhases;
            arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(BackendKt.toMap((PricingPhase) it.next()));
            }
        } else {
            arrayList = null;
        }
        Pair pairA16 = TuplesKt.a("pricing_phases", arrayList);
        ReplacementMode replacementMode = receiptInfo.getReplacementMode();
        final Map mapFilterNotNullValues = MapExtensionsKt.filterNotNullValues(MapsKt.mapOf(pairA, pairA2, pairA3, pairA4, pairA5, pairA6, pairA7, pairA8, pairA9, pairA10, pairA11, pairA12, pairA13, pairA14, pairA15, pairA16, TuplesKt.a("proration_mode", replacementMode != null ? ReplacementModeKt.backendName(replacementMode, this.appConfig.getStore()) : null), TuplesKt.a("initiation_source", initiationSource.getPostReceiptFieldValue()), TuplesKt.a("paywall", paywallPostReceiptData != null ? paywallPostReceiptData.toMap() : null), TuplesKt.a("sdk_originated", Boolean.valueOf(receiptInfo.getSdkOriginated())), TuplesKt.a("payload_version", 1)));
        final List listListOf = CollectionsKt.listOf((Object[]) new Pair[]{TuplesKt.a(APP_USER_ID, appUserID), TuplesKt.a(FETCH_TOKEN, purchaseToken)});
        final Map mapFilterNotNullValues2 = MapExtensionsKt.filterNotNullValues(MapsKt.mapOf(TuplesKt.a("price_string", receiptInfo.getFormattedPrice()), TuplesKt.a("marketplace", receiptInfo.getMarketplace())));
        Dispatcher.AsyncCall asyncCall = new Dispatcher.AsyncCall() { // from class: com.revenuecat.purchases.common.Backend$postReceiptData$call$1
            @Override // com.revenuecat.purchases.common.Dispatcher.AsyncCall
            public HTTPResult call() {
                return HTTPClient.performRequest$default(this.this$0.httpClient, this.this$0.appConfig.getBaseURL(), Endpoint.PostReceipt.INSTANCE, mapFilterNotNullValues, listListOf, MapsKt.plus(this.this$0.backendHelper.getAuthenticationHeaders$purchases_defaultsBc8Release(), mapFilterNotNullValues2), false, this.this$0.appConfig.getFallbackBaseURLs(), 0, 160, null);
            }

            @Override // com.revenuecat.purchases.common.Dispatcher.AsyncCall
            public void onCompletion(HTTPResult result) {
                List<Pair<Function1<PostReceiptResponse, Unit>, Function3<PurchasesError, PostReceiptErrorHandlingBehavior, JSONObject, Unit>>> listRemove;
                Intrinsics.checkNotNullParameter(result, "result");
                Backend backend = this.this$0;
                List<String> list2 = listListOfNotNull;
                synchronized (backend) {
                    listRemove = backend.getPostReceiptCallbacks().remove(list2);
                }
                if (listRemove != null) {
                    Backend backend2 = this.this$0;
                    Iterator<T> it2 = listRemove.iterator();
                    while (it2.hasNext()) {
                        Pair pair = (Pair) it2.next();
                        Function1 function1 = (Function1) pair.a();
                        Function3 function3 = (Function3) pair.b();
                        try {
                            if (BackendHelperKt.isSuccessful(result)) {
                                function1.invoke(PostReceiptResponseKt.buildPostReceiptResponse(result));
                            } else {
                                PurchasesError purchasesError = ErrorsKt.toPurchasesError(result);
                                LogUtilsKt.errorLog(purchasesError);
                                function3.invoke(purchasesError, backend2.determinePostReceiptErrorHandlingBehavior(result.getResponseCode(), purchasesError), result.getBody());
                            }
                        } catch (JSONException e3) {
                            PurchasesError purchasesError2 = ErrorsKt.toPurchasesError(e3);
                            LogUtilsKt.errorLog(purchasesError2);
                            function3.invoke(purchasesError2, PostReceiptErrorHandlingBehavior.SHOULD_NOT_CONSUME, null);
                        }
                    }
                }
            }

            @Override // com.revenuecat.purchases.common.Dispatcher.AsyncCall
            public void onError(PurchasesError error) {
                List<Pair<Function1<PostReceiptResponse, Unit>, Function3<PurchasesError, PostReceiptErrorHandlingBehavior, JSONObject, Unit>>> listRemove;
                Intrinsics.checkNotNullParameter(error, "error");
                Backend backend = this.this$0;
                List<String> list2 = listListOfNotNull;
                synchronized (backend) {
                    listRemove = backend.getPostReceiptCallbacks().remove(list2);
                }
                if (listRemove != null) {
                    Iterator<T> it2 = listRemove.iterator();
                    while (it2.hasNext()) {
                        ((Function3) ((Pair) it2.next()).b()).invoke(error, PostReceiptErrorHandlingBehavior.SHOULD_NOT_CONSUME, null);
                    }
                }
            }
        };
        synchronized (this) {
            addCallback$default(this, this.postReceiptCallbacks, asyncCall, this.dispatcher, listListOfNotNull, TuplesKt.a(onSuccess, onError), null, 16, null);
            Unit unit = Unit.f139807a;
        }
    }

    public final void postRedeemWebPurchase(String appUserID, String redemptionToken, Function1<? super RedeemWebPurchaseListener.Result, Unit> onResultHandler) throws Throwable {
        Intrinsics.checkNotNullParameter(appUserID, "appUserID");
        Intrinsics.checkNotNullParameter(redemptionToken, "redemptionToken");
        Intrinsics.checkNotNullParameter(onResultHandler, "onResultHandler");
        final Endpoint.PostRedeemWebPurchase postRedeemWebPurchase = Endpoint.PostRedeemWebPurchase.INSTANCE;
        final String path$default = Endpoint.getPath$default(postRedeemWebPurchase, false, 1, null);
        final Map mapMapOf = MapsKt.mapOf(TuplesKt.a("redemption_token", redemptionToken), TuplesKt.a(APP_USER_ID, appUserID));
        Dispatcher.AsyncCall asyncCall = new Dispatcher.AsyncCall() { // from class: com.revenuecat.purchases.common.Backend$postRedeemWebPurchase$call$1
            @Override // com.revenuecat.purchases.common.Dispatcher.AsyncCall
            public HTTPResult call() {
                return HTTPClient.performRequest$default(this.this$0.httpClient, this.this$0.appConfig.getBaseURL(), postRedeemWebPurchase, mapMapOf, null, this.this$0.backendHelper.getAuthenticationHeaders$purchases_defaultsBc8Release(), false, this.this$0.appConfig.getFallbackBaseURLs(), 0, 160, null);
            }

            @Override // com.revenuecat.purchases.common.Dispatcher.AsyncCall
            public void onCompletion(HTTPResult result) {
                List<Function1<RedeemWebPurchaseListener.Result, Unit>> listRemove;
                Intrinsics.checkNotNullParameter(result, "result");
                Backend backend = this.this$0;
                String str = path$default;
                synchronized (backend) {
                    listRemove = backend.getRedeemWebPurchaseCallbacks().remove(str);
                }
                if (listRemove != null) {
                    Iterator<T> it = listRemove.iterator();
                    while (it.hasNext()) {
                        Function1 function1 = (Function1) it.next();
                        if (BackendHelperKt.isSuccessful(result)) {
                            function1.invoke(new RedeemWebPurchaseListener.Result.Success(CustomerInfoFactory.INSTANCE.buildCustomerInfo(result)));
                        } else {
                            Integer backendErrorCode = result.getBackendErrorCode();
                            int value = BackendErrorCode.BackendInvalidWebRedemptionToken.getValue();
                            if (backendErrorCode != null && backendErrorCode.intValue() == value) {
                                function1.invoke(RedeemWebPurchaseListener.Result.InvalidToken.INSTANCE);
                            } else {
                                int value2 = BackendErrorCode.BackendExpiredWebRedemptionToken.getValue();
                                if (backendErrorCode != null && backendErrorCode.intValue() == value2) {
                                    JSONObject body = result.getBody();
                                    JSONObject jSONObjectOptJSONObject = body.optJSONObject("purchase_redemption_error_info");
                                    String strOptString = jSONObjectOptJSONObject != null ? jSONObjectOptJSONObject.optString("obfuscated_email") : null;
                                    if (strOptString == null) {
                                        LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", "Error parsing expired redemption token response: " + body, null);
                                        function1.invoke(new RedeemWebPurchaseListener.Result.Error(ErrorsKt.toPurchasesError(result)));
                                    } else {
                                        function1.invoke(new RedeemWebPurchaseListener.Result.Expired(strOptString));
                                    }
                                } else {
                                    int value3 = BackendErrorCode.BackendPurchaseBelongsToOtherUser.getValue();
                                    if (backendErrorCode != null && backendErrorCode.intValue() == value3) {
                                        function1.invoke(RedeemWebPurchaseListener.Result.PurchaseBelongsToOtherUser.INSTANCE);
                                    } else {
                                        function1.invoke(new RedeemWebPurchaseListener.Result.Error(ErrorsKt.toPurchasesError(result)));
                                    }
                                }
                            }
                        }
                    }
                }
            }

            @Override // com.revenuecat.purchases.common.Dispatcher.AsyncCall
            public void onError(PurchasesError error) {
                List<Function1<RedeemWebPurchaseListener.Result, Unit>> listRemove;
                Intrinsics.checkNotNullParameter(error, "error");
                Backend backend = this.this$0;
                String str = path$default;
                synchronized (backend) {
                    listRemove = backend.getRedeemWebPurchaseCallbacks().remove(str);
                }
                if (listRemove != null) {
                    Iterator<T> it = listRemove.iterator();
                    while (it.hasNext()) {
                        ((Function1) it.next()).invoke(new RedeemWebPurchaseListener.Result.Error(error));
                    }
                }
            }
        };
        synchronized (this) {
            try {
                try {
                    addCallback(this.redeemWebPurchaseCallbacks, asyncCall, this.dispatcher, path$default, onResultHandler, Delay.NONE);
                    Unit unit = Unit.f139807a;
                } catch (Throwable th) {
                    th = th;
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        }
    }

    public final synchronized void setAliasCallbacks(Map<List<String>, List<Pair<Function0<Unit>, Function1<PurchasesError, Unit>>>> map) {
        Intrinsics.checkNotNullParameter(map, "<set-?>");
        this.aliasCallbacks = map;
    }

    public final synchronized void setCallbacks(Map<BackgroundAwareCallbackCacheKey, List<Pair<Function1<CustomerInfo, Unit>, Function2<PurchasesError, Boolean, Unit>>>> map) {
        Intrinsics.checkNotNullParameter(map, "<set-?>");
        this.callbacks = map;
    }

    public final synchronized void setCreateSupportTicketCallbacks(Map<String, List<Pair<Function1<Boolean, Unit>, Function1<PurchasesError, Unit>>>> map) {
        Intrinsics.checkNotNullParameter(map, "<set-?>");
        this.createSupportTicketCallbacks = map;
    }

    public final synchronized void setCustomerCenterCallbacks(Map<String, List<Pair<Function1<CustomerCenterConfigData, Unit>, Function1<PurchasesError, Unit>>>> map) {
        Intrinsics.checkNotNullParameter(map, "<set-?>");
        this.customerCenterCallbacks = map;
    }

    public final synchronized void setDiagnosticsCallbacks(Map<List<String>, List<Pair<Function1<JSONObject, Unit>, Function2<PurchasesError, Boolean, Unit>>>> map) {
        Intrinsics.checkNotNullParameter(map, "<set-?>");
        this.diagnosticsCallbacks = map;
    }

    public final synchronized void setIdentifyCallbacks(Map<List<String>, List<Pair<Function2<CustomerInfo, Boolean, Unit>, Function1<PurchasesError, Unit>>>> map) {
        Intrinsics.checkNotNullParameter(map, "<set-?>");
        this.identifyCallbacks = map;
    }

    public final synchronized void setOfferingsCallbacks(Map<BackgroundAwareCallbackCacheKey, List<Pair<Function2<JSONObject, HTTPResponseOriginalSource, Unit>, Function2<PurchasesError, GetOfferingsErrorHandlingBehavior, Unit>>>> map) {
        Intrinsics.checkNotNullParameter(map, "<set-?>");
        this.offeringsCallbacks = map;
    }

    public final synchronized void setPaywallEventsCallbacks(Map<List<String>, List<Pair<Function0<Unit>, Function2<PurchasesError, Boolean, Unit>>>> map) {
        Intrinsics.checkNotNullParameter(map, "<set-?>");
        this.paywallEventsCallbacks = map;
    }

    public final synchronized void setPostReceiptCallbacks(Map<List<String>, List<Pair<Function1<PostReceiptResponse, Unit>, Function3<PurchasesError, PostReceiptErrorHandlingBehavior, JSONObject, Unit>>>> map) {
        Intrinsics.checkNotNullParameter(map, "<set-?>");
        this.postReceiptCallbacks = map;
    }

    public final synchronized void setProductEntitlementCallbacks(Map<String, List<Pair<Function1<ProductEntitlementMapping, Unit>, Function1<PurchasesError, Unit>>>> map) {
        Intrinsics.checkNotNullParameter(map, "<set-?>");
        this.productEntitlementCallbacks = map;
    }

    public final synchronized void setRedeemWebPurchaseCallbacks(Map<String, List<Function1<RedeemWebPurchaseListener.Result, Unit>>> map) {
        Intrinsics.checkNotNullParameter(map, "<set-?>");
        this.redeemWebPurchaseCallbacks = map;
    }

    public final synchronized void setVirtualCurrenciesCallbacks(Map<BackgroundAwareCallbackCacheKey, List<Pair<Function1<VirtualCurrencies, Unit>, Function1<PurchasesError, Unit>>>> map) {
        Intrinsics.checkNotNullParameter(map, "<set-?>");
        this.virtualCurrenciesCallbacks = map;
    }

    public final synchronized void setWebBillingProductsCallbacks(Map<String, List<Pair<Function1<WebBillingProductsResponse, Unit>, Function1<PurchasesError, Unit>>>> map) {
        Intrinsics.checkNotNullParameter(map, "<set-?>");
        this.webBillingProductsCallbacks = map;
    }

    public final synchronized void setWorkflowDetailCallbacks(Map<BackgroundAwareCallbackCacheKey, List<Pair<Function1<WorkflowDetailResponse, Unit>, Function1<PurchasesError, Unit>>>> map) {
        Intrinsics.checkNotNullParameter(map, "<set-?>");
        this.workflowDetailCallbacks = map;
    }

    public final void logIn(final String str, final String newAppUserID, Function2<? super CustomerInfo, ? super Boolean, Unit> onSuccessHandler, Function1<? super PurchasesError, Unit> onErrorHandler) {
        Intrinsics.checkNotNullParameter(str, wgbAZXYjrv.VxAhQH);
        Intrinsics.checkNotNullParameter(newAppUserID, "newAppUserID");
        Intrinsics.checkNotNullParameter(onSuccessHandler, "onSuccessHandler");
        Intrinsics.checkNotNullParameter(onErrorHandler, "onErrorHandler");
        final List listListOfNotNull = CollectionsKt.listOfNotNull((Object[]) new String[]{str, newAppUserID});
        Dispatcher.AsyncCall asyncCall = new Dispatcher.AsyncCall() { // from class: com.revenuecat.purchases.common.Backend$logIn$call$1
            @Override // com.revenuecat.purchases.common.Dispatcher.AsyncCall
            public HTTPResult call() {
                return HTTPClient.performRequest$default(this.httpClient, this.appConfig.getBaseURL(), Endpoint.LogIn.INSTANCE, MapsKt.mapOf(TuplesKt.a("app_user_id", str), TuplesKt.a("new_app_user_id", newAppUserID)), CollectionsKt.listOf((Object[]) new Pair[]{TuplesKt.a("app_user_id", str), TuplesKt.a("new_app_user_id", newAppUserID)}), this.backendHelper.getAuthenticationHeaders$purchases_defaultsBc8Release(), false, this.appConfig.getFallbackBaseURLs(), 0, 160, null);
            }

            @Override // com.revenuecat.purchases.common.Dispatcher.AsyncCall
            public void onCompletion(HTTPResult result) {
                List<Pair<Function2<CustomerInfo, Boolean, Unit>, Function1<PurchasesError, Unit>>> listRemove;
                Intrinsics.checkNotNullParameter(result, "result");
                if (!BackendHelperKt.isSuccessful(result)) {
                    PurchasesError purchasesError = ErrorsKt.toPurchasesError(result);
                    LogUtilsKt.errorLog(purchasesError);
                    onError(purchasesError);
                    return;
                }
                Backend backend = this;
                List<String> list = listListOfNotNull;
                synchronized (backend) {
                    listRemove = backend.getIdentifyCallbacks().remove(list);
                }
                if (listRemove != null) {
                    Iterator<T> it = listRemove.iterator();
                    while (it.hasNext()) {
                        Pair pair = (Pair) it.next();
                        Function2 function2 = (Function2) pair.a();
                        Function1 function1 = (Function1) pair.b();
                        boolean z2 = result.getResponseCode() == 201;
                        if (result.getBody().length() > 0) {
                            function2.invoke(CustomerInfoFactory.INSTANCE.buildCustomerInfo(result), Boolean.valueOf(z2));
                        } else {
                            PurchasesError purchasesError2 = new PurchasesError(PurchasesErrorCode.UnknownError, null, 2, null);
                            LogUtilsKt.errorLog(purchasesError2);
                            function1.invoke(purchasesError2);
                        }
                    }
                }
            }

            @Override // com.revenuecat.purchases.common.Dispatcher.AsyncCall
            public void onError(PurchasesError error) {
                List<Pair<Function2<CustomerInfo, Boolean, Unit>, Function1<PurchasesError, Unit>>> listRemove;
                Intrinsics.checkNotNullParameter(error, "error");
                Backend backend = this;
                List<String> list = listListOfNotNull;
                synchronized (backend) {
                    listRemove = backend.getIdentifyCallbacks().remove(list);
                }
                if (listRemove != null) {
                    Iterator<T> it = listRemove.iterator();
                    while (it.hasNext()) {
                        ((Function1) ((Pair) it.next()).b()).invoke(error);
                    }
                }
            }
        };
        synchronized (this) {
            try {
                try {
                    addCallback$default(this, this.identifyCallbacks, asyncCall, this.dispatcher, listListOfNotNull, TuplesKt.a(onSuccessHandler, onErrorHandler), null, 16, null);
                    Unit unit = Unit.f139807a;
                } catch (Throwable th) {
                    th = th;
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        }
    }
}
