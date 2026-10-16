package com.revenuecat.purchases.common.diagnostics;

import androidx.glance.color.Tq.KqqtdetwHMIO;
import com.google.firebase.crashlytics.internal.breadcrumbs.PKU.tDEtWsFLJfe;
import com.revenuecat.purchases.CacheFetchPolicy;
import com.revenuecat.purchases.CustomerInfo;
import com.revenuecat.purchases.LogHandler;
import com.revenuecat.purchases.LogLevel;
import com.revenuecat.purchases.ProductType;
import com.revenuecat.purchases.PurchasesError;
import com.revenuecat.purchases.PurchasesErrorCode;
import com.revenuecat.purchases.Store;
import com.revenuecat.purchases.VerificationResult;
import com.revenuecat.purchases.common.AppConfig;
import com.revenuecat.purchases.common.Config;
import com.revenuecat.purchases.common.Dispatcher;
import com.revenuecat.purchases.common.LogWrapperKt;
import com.revenuecat.purchases.common.events.EventsManager;
import com.revenuecat.purchases.common.networking.ConnectionErrorReason;
import com.revenuecat.purchases.common.networking.Endpoint;
import com.revenuecat.purchases.common.networking.HTTPResult;
import com.revenuecat.purchases.strings.OfflineEntitlementsStrings;
import com.revenuecat.purchases.utils.MapExtensionsKt;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.time.Duration;
import kotlinx.serialization.json.internal.OBeo.vgWWUoTKYyuC;

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
public final class DiagnosticsTracker {

    @Deprecated
    public static final String BACKEND_ERROR_CODE_KEY = "backend_error_code";

    @Deprecated
    public static final String BILLING_DEBUG_MESSAGE = "billing_debug_message";

    @Deprecated
    public static final String BILLING_RESPONSE_CODE = "billing_response_code";

    @Deprecated
    public static final String CACHE_STATUS_KEY = "cache_status";

    @Deprecated
    public static final String CONNECTION_ERROR_REASON_KEY = "connection_error_reason";
    private static final Companion Companion = new Companion(null);

    @Deprecated
    public static final String ENDPOINT_NAME_KEY = "endpoint_name";

    @Deprecated
    public static final String ERROR_CODE_KEY = "error_code";

    @Deprecated
    public static final String ERROR_MESSAGE_KEY = "error_message";

    @Deprecated
    public static final String ETAG_HIT_KEY = "etag_hit";

    @Deprecated
    public static final String FETCH_POLICY_KEY = "fetch_policy";

    @Deprecated
    public static final String FOUND_PRODUCT_IDS_KEY = "found_product_ids";

    @Deprecated
    public static final String HAD_UNSYNCED_PURCHASES_BEFORE_KEY = "had_unsynced_purchases_before";

    @Deprecated
    public static final String HAS_INTRO_PRICE_KEY = "has_intro_price";

    @Deprecated
    public static final String HAS_INTRO_TRIAL_KEY = "has_intro_trial";

    @Deprecated
    public static final String HOST_KEY = "host";

    @Deprecated
    public static final String IS_RETRY = "is_retry";

    @Deprecated
    public static final String NOT_FOUND_PRODUCT_IDS_KEY = "not_found_product_ids";

    @Deprecated
    public static final String OLD_PRODUCT_ID_KEY = "old_product_id";

    @Deprecated
    public static final String PENDING_REQUEST_COUNT = "pending_request_count";

    @Deprecated
    public static final String PRODUCT_IDS_KEY = "product_ids";

    @Deprecated
    public static final String PRODUCT_ID_KEY = "product_id";

    @Deprecated
    public static final String PRODUCT_TYPE_KEY = "product_type";

    @Deprecated
    public static final String PRODUCT_TYPE_QUERIED_KEY = "product_type_queried";

    @Deprecated
    public static final String PURCHASE_STATUSES_KEY = "purchase_statuses";

    @Deprecated
    public static final String REQUESTED_PRODUCT_IDS_KEY = "requested_product_ids";

    @Deprecated
    public static final String REQUEST_STATUS_KEY = "request_status";

    @Deprecated
    public static final String RESPONSE_CODE_KEY = "response_code";

    @Deprecated
    public static final String RESPONSE_TIME_MILLIS_KEY = "response_time_millis";

    @Deprecated
    public static final String SUCCESSFUL_KEY = "successful";

    @Deprecated
    public static final String VERIFICATION_RESULT_KEY = "verification_result";
    private final AppConfig appConfig;
    private final UUID appSessionID;
    private final Map<String, String> commonProperties;
    private final Dispatcher diagnosticsDispatcher;
    private final DiagnosticsFileHelper diagnosticsFileHelper;
    private final DiagnosticsHelper diagnosticsHelper;
    private DiagnosticsEventTrackerListener listener;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public enum CacheStatus {
        NOT_CHECKED,
        NOT_FOUND,
        STALE,
        VALID
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public DiagnosticsTracker(AppConfig appConfig, DiagnosticsFileHelper diagnosticsFileHelper, DiagnosticsHelper diagnosticsHelper, Dispatcher diagnosticsDispatcher, UUID appSessionID) {
        Intrinsics.checkNotNullParameter(appConfig, "appConfig");
        Intrinsics.checkNotNullParameter(diagnosticsFileHelper, "diagnosticsFileHelper");
        Intrinsics.checkNotNullParameter(diagnosticsHelper, "diagnosticsHelper");
        Intrinsics.checkNotNullParameter(diagnosticsDispatcher, "diagnosticsDispatcher");
        Intrinsics.checkNotNullParameter(appSessionID, "appSessionID");
        this.appConfig = appConfig;
        this.diagnosticsFileHelper = diagnosticsFileHelper;
        this.diagnosticsHelper = diagnosticsHelper;
        this.diagnosticsDispatcher = diagnosticsDispatcher;
        this.appSessionID = appSessionID;
        this.commonProperties = appConfig.getStore() == Store.PLAY_STORE ? MapExtensionsKt.filterNotNullValues(MapsKt.mapOf(TuplesKt.a("play_store_version", appConfig.getPlayStoreVersionName()), TuplesKt.a("play_services_version", appConfig.getPlayServicesVersionName()))) : MapsKt.emptyMap();
    }

    private final void checkAndClearDiagnosticsFileIfTooBig(final Function0<Unit> function0) {
        enqueue(new Function0<Unit>() { // from class: com.revenuecat.purchases.common.diagnostics.DiagnosticsTracker.checkAndClearDiagnosticsFileIfTooBig.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Object invoke() {
                m543invoke();
                return Unit.f139807a;
            }

            /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
            public final void m543invoke() {
                if (DiagnosticsTracker.this.diagnosticsFileHelper.isDiagnosticsFileTooBig()) {
                    LogLevel logLevel = LogLevel.VERBOSE;
                    LogHandler currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                        currentLogHandler.v("[Purchases] - " + logLevel.name(), "Diagnostics file is too big. Deleting it.");
                    }
                    DiagnosticsTracker.this.diagnosticsHelper.resetDiagnosticsStatus();
                    DiagnosticsTracker.trackMaxEventsStoredLimitReached$default(DiagnosticsTracker.this, false, 1, null);
                }
                function0.invoke();
            }
        });
    }

    private final void enqueue(final Function0<Unit> function0) {
        Dispatcher.enqueue$default(this.diagnosticsDispatcher, new Runnable() { // from class: com.revenuecat.purchases.common.diagnostics.b
            @Override // java.lang.Runnable
            public final void run() {
                function0.invoke();
            }
        }, null, 2, null);
    }

    private final void trackEvent(DiagnosticsEntryName diagnosticsEntryName, Map<String, ? extends Object> map) {
        trackEvent(new DiagnosticsEntry(null, diagnosticsEntryName, MapsKt.plus(this.commonProperties, map), this.appSessionID, null, null, 49, null));
    }

    public static /* synthetic */ void trackMaxEventsStoredLimitReached$default(DiagnosticsTracker diagnosticsTracker, boolean z2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            z2 = true;
        }
        diagnosticsTracker.trackMaxEventsStoredLimitReached(z2);
    }

    public final DiagnosticsEventTrackerListener getListener() {
        return this.listener;
    }

    public final void setListener(DiagnosticsEventTrackerListener diagnosticsEventTrackerListener) {
        this.listener = diagnosticsEventTrackerListener;
    }

    /* JADX INFO: renamed from: trackAmazonPurchaseAttempt-9VgGkz4, reason: not valid java name */
    public final void m530trackAmazonPurchaseAttempt9VgGkz4(String productId, String str, Integer num, String str2, long j3) {
        Intrinsics.checkNotNullParameter(productId, "productId");
        trackEvent(DiagnosticsEntryName.AMAZON_PURCHASE_ATTEMPT, MapExtensionsKt.filterNotNullValues(MapsKt.mapOf(TuplesKt.a(PRODUCT_ID_KEY, productId), TuplesKt.a(REQUEST_STATUS_KEY, str), TuplesKt.a("error_code", num), TuplesKt.a("error_message", str2), TuplesKt.a(RESPONSE_TIME_MILLIS_KEY, Long.valueOf(Duration.p(j3))))));
    }

    /* JADX INFO: renamed from: trackAmazonQueryProductDetailsRequest-KLykuaI, reason: not valid java name */
    public final void m531trackAmazonQueryProductDetailsRequestKLykuaI(long j3, boolean z2, Set<String> requestedProductIds) {
        Intrinsics.checkNotNullParameter(requestedProductIds, "requestedProductIds");
        trackEvent(DiagnosticsEntryName.AMAZON_QUERY_PRODUCT_DETAILS_REQUEST, MapsKt.mapOf(TuplesKt.a(SUCCESSFUL_KEY, Boolean.valueOf(z2)), TuplesKt.a(RESPONSE_TIME_MILLIS_KEY, Long.valueOf(Duration.p(j3))), TuplesKt.a(REQUESTED_PRODUCT_IDS_KEY, requestedProductIds)));
    }

    /* JADX INFO: renamed from: trackAmazonQueryPurchasesRequest-KLykuaI, reason: not valid java name */
    public final void m532trackAmazonQueryPurchasesRequestKLykuaI(long j3, boolean z2, List<String> list) {
        trackEvent(DiagnosticsEntryName.AMAZON_QUERY_PURCHASES_REQUEST, MapExtensionsKt.filterNotNullValues(MapsKt.mapOf(TuplesKt.a(SUCCESSFUL_KEY, Boolean.valueOf(z2)), TuplesKt.a(RESPONSE_TIME_MILLIS_KEY, Long.valueOf(Duration.p(j3))), TuplesKt.a(FOUND_PRODUCT_IDS_KEY, list))));
    }

    public final void trackClearingDiagnosticsAfterFailedSync() {
        trackEvent(DiagnosticsEntryName.CLEARING_DIAGNOSTICS_AFTER_FAILED_SYNC, MapsKt.emptyMap());
    }

    public final void trackCustomerInfoVerificationResultIfNeeded(CustomerInfo customerInfo) {
        Intrinsics.checkNotNullParameter(customerInfo, "customerInfo");
        VerificationResult verification = customerInfo.getEntitlements().getVerification();
        if (verification == VerificationResult.NOT_REQUESTED) {
            return;
        }
        trackEvent(DiagnosticsEntryName.CUSTOMER_INFO_VERIFICATION_RESULT, MapsKt.mapOf(TuplesKt.a(VERIFICATION_RESULT_KEY, verification.name())));
    }

    public final void trackEnteredOfflineEntitlementsMode() {
        trackEvent(DiagnosticsEntryName.ENTERED_OFFLINE_ENTITLEMENTS_MODE, MapsKt.emptyMap());
    }

    public final void trackErrorEnteringOfflineEntitlementsMode(PurchasesError error) {
        Intrinsics.checkNotNullParameter(error, "error");
        String str = (error.getCode() == PurchasesErrorCode.UnsupportedError && Intrinsics.areEqual(error.getUnderlyingErrorMessage(), OfflineEntitlementsStrings.OFFLINE_ENTITLEMENTS_UNSUPPORTED_INAPP_PURCHASES)) ? "one_time_purchase_found" : (error.getCode() == PurchasesErrorCode.CustomerInfoError && Intrinsics.areEqual(error.getUnderlyingErrorMessage(), OfflineEntitlementsStrings.PRODUCT_ENTITLEMENT_MAPPING_REQUIRED)) ? "no_entitlement_mapping_available" : "unknown";
        trackEvent(DiagnosticsEntryName.ERROR_ENTERING_OFFLINE_ENTITLEMENTS_MODE, MapsKt.mapOf(TuplesKt.a("offline_entitlement_error_reason", str), TuplesKt.a("error_message", error.getMessage() + " Underlying error: " + error.getUnderlyingErrorMessage())));
    }

    public final void trackEventInCurrentThread$purchases_defaultsBc8Release(DiagnosticsEntry diagnosticsEntry) {
        Intrinsics.checkNotNullParameter(diagnosticsEntry, "diagnosticsEntry");
        LogLevel logLevel = LogLevel.VERBOSE;
        LogHandler currentLogHandler = LogWrapperKt.getCurrentLogHandler();
        if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
            currentLogHandler.v("[Purchases] - " + logLevel.name(), "Tracking diagnostics entry: " + diagnosticsEntry);
        }
        try {
            this.diagnosticsFileHelper.appendEvent(diagnosticsEntry);
            DiagnosticsEventTrackerListener diagnosticsEventTrackerListener = this.listener;
            if (diagnosticsEventTrackerListener != null) {
                diagnosticsEventTrackerListener.onEventTracked();
            }
        } catch (IOException e3) {
            LogLevel logLevel2 = LogLevel.VERBOSE;
            LogHandler currentLogHandler2 = LogWrapperKt.getCurrentLogHandler();
            if (Config.INSTANCE.getLogLevel().compareTo(logLevel2) <= 0) {
                currentLogHandler2.v("[Purchases] - " + logLevel2.name(), "Error tracking diagnostics entry: " + e3);
            }
        }
    }

    public final void trackGetCustomerInfoStarted() {
        trackEvent(DiagnosticsEntryName.GET_CUSTOMER_INFO_STARTED, MapsKt.emptyMap());
    }

    /* JADX INFO: renamed from: trackGetOfferingsResult-B8UsjHI, reason: not valid java name */
    public final void m534trackGetOfferingsResultB8UsjHI(Set<String> set, Set<String> set2, String str, Integer num, String str2, CacheStatus cacheStatus, long j3) {
        Intrinsics.checkNotNullParameter(cacheStatus, "cacheStatus");
        trackEvent(DiagnosticsEntryName.GET_OFFERINGS_RESULT, MapExtensionsKt.filterNotNullValues(MapsKt.mapOf(TuplesKt.a(REQUESTED_PRODUCT_IDS_KEY, set), TuplesKt.a(NOT_FOUND_PRODUCT_IDS_KEY, set2), TuplesKt.a("error_message", str), TuplesKt.a("error_code", num), TuplesKt.a(VERIFICATION_RESULT_KEY, str2), TuplesKt.a(CACHE_STATUS_KEY, cacheStatus.name()), TuplesKt.a(RESPONSE_TIME_MILLIS_KEY, Long.valueOf(Duration.p(j3))))));
    }

    public final void trackGetOfferingsStarted() {
        trackEvent(DiagnosticsEntryName.GET_OFFERINGS_STARTED, MapsKt.emptyMap());
    }

    /* JADX INFO: renamed from: trackGetProductsResult-9VgGkz4, reason: not valid java name */
    public final void m535trackGetProductsResult9VgGkz4(Set<String> requestedProductIds, Set<String> notFoundProductIds, String str, Integer num, long j3) {
        Intrinsics.checkNotNullParameter(requestedProductIds, "requestedProductIds");
        Intrinsics.checkNotNullParameter(notFoundProductIds, "notFoundProductIds");
        trackEvent(DiagnosticsEntryName.GET_PRODUCTS_RESULT, MapExtensionsKt.filterNotNullValues(MapsKt.mapOf(TuplesKt.a(REQUESTED_PRODUCT_IDS_KEY, requestedProductIds), TuplesKt.a(NOT_FOUND_PRODUCT_IDS_KEY, notFoundProductIds), TuplesKt.a("error_message", str), TuplesKt.a("error_code", num), TuplesKt.a(RESPONSE_TIME_MILLIS_KEY, Long.valueOf(Duration.p(j3))))));
    }

    public final void trackGetProductsStarted(Set<String> requestedProductIds) {
        Intrinsics.checkNotNullParameter(requestedProductIds, "requestedProductIds");
        trackEvent(DiagnosticsEntryName.GET_PRODUCTS_STARTED, MapsKt.mapOf(TuplesKt.a(REQUESTED_PRODUCT_IDS_KEY, requestedProductIds)));
    }

    public final void trackGoogleBillingServiceDisconnected() {
        trackEvent(DiagnosticsEntryName.GOOGLE_BILLING_SERVICE_DISCONNECTED, MapsKt.emptyMap());
    }

    public final void trackGoogleBillingSetupFinished(int i3, String debugMessage, int i4) {
        Intrinsics.checkNotNullParameter(debugMessage, "debugMessage");
        trackEvent(DiagnosticsEntryName.GOOGLE_BILLING_SETUP_FINISHED, MapsKt.mapOf(TuplesKt.a(BILLING_RESPONSE_CODE, Integer.valueOf(i3)), TuplesKt.a(BILLING_DEBUG_MESSAGE, debugMessage), TuplesKt.a(PENDING_REQUEST_COUNT, Integer.valueOf(i4))));
    }

    public final void trackGoogleBillingStartConnection() {
        trackEvent(DiagnosticsEntryName.GOOGLE_BILLING_START_CONNECTION, MapsKt.emptyMap());
    }

    public final void trackGooglePurchaseStarted(String productId, String str, Boolean bool, Boolean bool2) {
        Intrinsics.checkNotNullParameter(productId, "productId");
        trackEvent(DiagnosticsEntryName.GOOGLE_PURCHASE_STARTED, MapExtensionsKt.filterNotNullValues(MapsKt.mapOf(TuplesKt.a(PRODUCT_ID_KEY, productId), TuplesKt.a(OLD_PRODUCT_ID_KEY, str), TuplesKt.a(HAS_INTRO_TRIAL_KEY, bool), TuplesKt.a(HAS_INTRO_PRICE_KEY, bool2))));
    }

    public final void trackGooglePurchaseUpdateReceived(List<String> list, List<String> list2, int i3, String billingDebugMessage) {
        Intrinsics.checkNotNullParameter(billingDebugMessage, "billingDebugMessage");
        trackEvent(DiagnosticsEntryName.GOOGLE_PURCHASES_UPDATE_RECEIVED, MapExtensionsKt.filterNotNullValues(MapsKt.mapOf(TuplesKt.a(PRODUCT_IDS_KEY, list), TuplesKt.a(PURCHASE_STATUSES_KEY, list2), TuplesKt.a(BILLING_RESPONSE_CODE, Integer.valueOf(i3)), TuplesKt.a(BILLING_DEBUG_MESSAGE, billingDebugMessage))));
    }

    /* JADX INFO: renamed from: trackGoogleQueryProductDetailsRequest-9VgGkz4, reason: not valid java name */
    public final void m536trackGoogleQueryProductDetailsRequest9VgGkz4(Set<String> requestedProductIds, String productType, int i3, String billingDebugMessage, long j3) {
        Intrinsics.checkNotNullParameter(requestedProductIds, "requestedProductIds");
        Intrinsics.checkNotNullParameter(productType, "productType");
        Intrinsics.checkNotNullParameter(billingDebugMessage, "billingDebugMessage");
        trackEvent(DiagnosticsEntryName.GOOGLE_QUERY_PRODUCT_DETAILS_REQUEST, MapsKt.mapOf(TuplesKt.a(REQUESTED_PRODUCT_IDS_KEY, requestedProductIds), TuplesKt.a(PRODUCT_TYPE_QUERIED_KEY, productType), TuplesKt.a(BILLING_RESPONSE_CODE, Integer.valueOf(i3)), TuplesKt.a(BILLING_DEBUG_MESSAGE, billingDebugMessage), TuplesKt.a(RESPONSE_TIME_MILLIS_KEY, Long.valueOf(Duration.p(j3)))));
    }

    /* JADX INFO: renamed from: trackGoogleQueryPurchaseHistoryRequest-Wn2Vu4Y, reason: not valid java name */
    public final void m537trackGoogleQueryPurchaseHistoryRequestWn2Vu4Y(String productType, int i3, String billingDebugMessage, long j3) {
        Intrinsics.checkNotNullParameter(productType, "productType");
        Intrinsics.checkNotNullParameter(billingDebugMessage, "billingDebugMessage");
        trackEvent(DiagnosticsEntryName.GOOGLE_QUERY_PURCHASE_HISTORY_REQUEST, MapsKt.mapOf(TuplesKt.a(PRODUCT_TYPE_QUERIED_KEY, productType), TuplesKt.a(BILLING_RESPONSE_CODE, Integer.valueOf(i3)), TuplesKt.a(BILLING_DEBUG_MESSAGE, billingDebugMessage), TuplesKt.a(RESPONSE_TIME_MILLIS_KEY, Long.valueOf(Duration.p(j3)))));
    }

    /* JADX INFO: renamed from: trackGoogleQueryPurchasesRequest-zkXUZaI, reason: not valid java name */
    public final void m538trackGoogleQueryPurchasesRequestzkXUZaI(String productType, int i3, String billingDebugMessage, long j3, List<String> foundProductIds) {
        Intrinsics.checkNotNullParameter(productType, "productType");
        Intrinsics.checkNotNullParameter(billingDebugMessage, "billingDebugMessage");
        Intrinsics.checkNotNullParameter(foundProductIds, "foundProductIds");
        trackEvent(DiagnosticsEntryName.GOOGLE_QUERY_PURCHASES_REQUEST, MapsKt.mapOf(TuplesKt.a(PRODUCT_TYPE_QUERIED_KEY, productType), TuplesKt.a(BILLING_RESPONSE_CODE, Integer.valueOf(i3)), TuplesKt.a(BILLING_DEBUG_MESSAGE, billingDebugMessage), TuplesKt.a(RESPONSE_TIME_MILLIS_KEY, Long.valueOf(Duration.p(j3))), TuplesKt.a(FOUND_PRODUCT_IDS_KEY, foundProductIds)));
    }

    public final void trackMaxDiagnosticsSyncRetriesReached() {
        trackEvent(DiagnosticsEntryName.MAX_DIAGNOSTICS_SYNC_RETRIES_REACHED, MapsKt.emptyMap());
    }

    public final void trackMaxEventsStoredLimitReached(boolean z2) {
        DiagnosticsEntry diagnosticsEntry = new DiagnosticsEntry(null, DiagnosticsEntryName.MAX_EVENTS_STORED_LIMIT_REACHED, this.commonProperties, this.appSessionID, null, null, 49, null);
        if (z2) {
            trackEventInCurrentThread$purchases_defaultsBc8Release(diagnosticsEntry);
        } else {
            trackEvent(diagnosticsEntry);
        }
    }

    /* JADX INFO: renamed from: trackPurchaseResult-myKFqkg, reason: not valid java name */
    public final void m540trackPurchaseResultmyKFqkg(String productId, ProductType productType, Integer num, String str, long j3, VerificationResult verificationResult) {
        Intrinsics.checkNotNullParameter(productId, "productId");
        Intrinsics.checkNotNullParameter(productType, "productType");
        trackEvent(DiagnosticsEntryName.PURCHASE_RESULT, MapExtensionsKt.filterNotNullValues(MapsKt.mapOf(TuplesKt.a(PRODUCT_ID_KEY, productId), TuplesKt.a(PRODUCT_TYPE_KEY, DiagnosticsTrackerKt.getDiagnosticsName(productType)), TuplesKt.a("error_code", num), TuplesKt.a("error_message", str), TuplesKt.a(RESPONSE_TIME_MILLIS_KEY, Long.valueOf(Duration.p(j3))), TuplesKt.a(VERIFICATION_RESULT_KEY, verificationResult != null ? verificationResult.name() : null))));
    }

    public final void trackPurchaseStarted(String productId, ProductType productType) {
        Intrinsics.checkNotNullParameter(productId, "productId");
        Intrinsics.checkNotNullParameter(productType, "productType");
        trackEvent(DiagnosticsEntryName.PURCHASE_STARTED, MapsKt.mapOf(TuplesKt.a(PRODUCT_ID_KEY, productId), TuplesKt.a(PRODUCT_TYPE_KEY, DiagnosticsTrackerKt.getDiagnosticsName(productType))));
    }

    /* JADX INFO: renamed from: trackRestorePurchasesResult-SxA4cEA, reason: not valid java name */
    public final void m541trackRestorePurchasesResultSxA4cEA(Integer num, String str, long j3) {
        trackEvent(DiagnosticsEntryName.RESTORE_PURCHASES_RESULT, MapExtensionsKt.filterNotNullValues(MapsKt.mapOf(TuplesKt.a("error_code", num), TuplesKt.a("error_message", str), TuplesKt.a(RESPONSE_TIME_MILLIS_KEY, Long.valueOf(Duration.p(j3))))));
    }

    public final void trackRestorePurchasesStarted() {
        trackEvent(DiagnosticsEntryName.RESTORE_PURCHASES_STARTED, MapsKt.emptyMap());
    }

    /* JADX INFO: renamed from: trackSyncPurchasesResult-SxA4cEA, reason: not valid java name */
    public final void m542trackSyncPurchasesResultSxA4cEA(Integer num, String str, long j3) {
        trackEvent(DiagnosticsEntryName.SYNC_PURCHASES_RESULT, MapExtensionsKt.filterNotNullValues(MapsKt.mapOf(TuplesKt.a("error_code", num), TuplesKt.a("error_message", str), TuplesKt.a(RESPONSE_TIME_MILLIS_KEY, Long.valueOf(Duration.p(j3))))));
    }

    public final void trackSyncPurchasesStarted() {
        trackEvent(DiagnosticsEntryName.SYNC_PURCHASES_STARTED, MapsKt.emptyMap());
    }

    /* JADX INFO: renamed from: trackGetCustomerInfoResult-17CK4j0, reason: not valid java name */
    public final void m533trackGetCustomerInfoResult17CK4j0(CacheFetchPolicy cacheFetchPolicy, VerificationResult verificationResult, Boolean bool, String str, Integer num, long j3) {
        Intrinsics.checkNotNullParameter(cacheFetchPolicy, "cacheFetchPolicy");
        trackEvent(DiagnosticsEntryName.GET_CUSTOMER_INFO_RESULT, MapExtensionsKt.filterNotNullValues(MapsKt.mapOf(TuplesKt.a(FETCH_POLICY_KEY, cacheFetchPolicy.name()), TuplesKt.a(VERIFICATION_RESULT_KEY, verificationResult != null ? verificationResult.name() : null), TuplesKt.a(HAD_UNSYNCED_PURCHASES_BEFORE_KEY, bool), TuplesKt.a("error_message", str), TuplesKt.a(vgWWUoTKYyuC.hIcnsPTycrQC, num), TuplesKt.a(RESPONSE_TIME_MILLIS_KEY, Long.valueOf(Duration.p(j3))))));
    }

    /* JADX INFO: renamed from: trackHttpRequestPerformed--XzGXFE, reason: not valid java name */
    public final void m539trackHttpRequestPerformedXzGXFE(String host, Endpoint endpoint, long j3, boolean z2, int i3, Integer num, HTTPResult.Origin origin, VerificationResult verificationResult, boolean z3, ConnectionErrorReason connectionErrorReason) {
        Intrinsics.checkNotNullParameter(host, "host");
        Intrinsics.checkNotNullParameter(endpoint, "endpoint");
        Intrinsics.checkNotNullParameter(verificationResult, "verificationResult");
        trackEvent(DiagnosticsEntryName.HTTP_REQUEST_PERFORMED, MapExtensionsKt.filterNotNullValues(MapsKt.mapOf(TuplesKt.a(HOST_KEY, host), TuplesKt.a(ENDPOINT_NAME_KEY, endpoint.getName()), TuplesKt.a(RESPONSE_TIME_MILLIS_KEY, Long.valueOf(Duration.p(j3))), TuplesKt.a(SUCCESSFUL_KEY, Boolean.valueOf(z2)), TuplesKt.a(RESPONSE_CODE_KEY, Integer.valueOf(i3)), TuplesKt.a(BACKEND_ERROR_CODE_KEY, num), TuplesKt.a(ETAG_HIT_KEY, Boolean.valueOf(origin == HTTPResult.Origin.CACHE)), TuplesKt.a(VERIFICATION_RESULT_KEY, verificationResult.name()), TuplesKt.a(KqqtdetwHMIO.dmGLs, Boolean.valueOf(z3)), TuplesKt.a(CONNECTION_ERROR_REASON_KEY, connectionErrorReason != null ? connectionErrorReason.name() : null))));
    }

    public final void trackProductDetailsNotSupported(int i3, String billingDebugMessage) {
        Intrinsics.checkNotNullParameter(billingDebugMessage, "billingDebugMessage");
        DiagnosticsEntryName diagnosticsEntryName = DiagnosticsEntryName.PRODUCT_DETAILS_NOT_SUPPORTED;
        String playStoreVersionName = this.appConfig.getPlayStoreVersionName();
        if (playStoreVersionName == null) {
            playStoreVersionName = "";
        }
        Pair pairA = TuplesKt.a("play_store_version", playStoreVersionName);
        String playServicesVersionName = this.appConfig.getPlayServicesVersionName();
        trackEvent(diagnosticsEntryName, MapsKt.mapOf(pairA, TuplesKt.a(tDEtWsFLJfe.hbOvIelwtNFPGFn, playServicesVersionName != null ? playServicesVersionName : ""), TuplesKt.a(BILLING_RESPONSE_CODE, Integer.valueOf(i3)), TuplesKt.a(BILLING_DEBUG_MESSAGE, billingDebugMessage)));
    }

    public final void trackEvent(final DiagnosticsEntry diagnosticsEntry) {
        Intrinsics.checkNotNullParameter(diagnosticsEntry, "diagnosticsEntry");
        checkAndClearDiagnosticsFileIfTooBig(new Function0<Unit>() { // from class: com.revenuecat.purchases.common.diagnostics.DiagnosticsTracker.trackEvent.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Object invoke() {
                m544invoke();
                return Unit.f139807a;
            }

            /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
            public final void m544invoke() {
                DiagnosticsTracker.this.trackEventInCurrentThread$purchases_defaultsBc8Release(diagnosticsEntry);
            }
        });
    }

    public /* synthetic */ DiagnosticsTracker(AppConfig appConfig, DiagnosticsFileHelper diagnosticsFileHelper, DiagnosticsHelper diagnosticsHelper, Dispatcher dispatcher, UUID uuid, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(appConfig, diagnosticsFileHelper, diagnosticsHelper, dispatcher, (i3 & 16) != 0 ? EventsManager.Companion.getAppSessionID$purchases_defaultsBc8Release() : uuid);
    }
}
