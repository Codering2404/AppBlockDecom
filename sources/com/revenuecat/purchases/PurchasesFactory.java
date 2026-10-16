package com.revenuecat.purchases;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Process;
import androidx.core.os.UserManagerCompat;
import com.revenuecat.purchases.APIKeyValidator;
import com.revenuecat.purchases.PurchasesFactory;
import com.revenuecat.purchases.common.AppConfig;
import com.revenuecat.purchases.common.Backend;
import com.revenuecat.purchases.common.BackendHelper;
import com.revenuecat.purchases.common.BillingAbstract;
import com.revenuecat.purchases.common.Config;
import com.revenuecat.purchases.common.DateProvider;
import com.revenuecat.purchases.common.DefaultLocaleProvider;
import com.revenuecat.purchases.common.Delay;
import com.revenuecat.purchases.common.Dispatcher;
import com.revenuecat.purchases.common.FileHelper;
import com.revenuecat.purchases.common.HTTPClient;
import com.revenuecat.purchases.common.LogIntent;
import com.revenuecat.purchases.common.LogUtilsKt;
import com.revenuecat.purchases.common.LogWrapperKt;
import com.revenuecat.purchases.common.OfferingParser;
import com.revenuecat.purchases.common.PlatformInfo;
import com.revenuecat.purchases.common.SharedPreferencesManager;
import com.revenuecat.purchases.common.UtilsKt;
import com.revenuecat.purchases.common.caching.DeviceCache;
import com.revenuecat.purchases.common.caching.LocalTransactionMetadataStore;
import com.revenuecat.purchases.common.diagnostics.DiagnosticsFileHelper;
import com.revenuecat.purchases.common.diagnostics.DiagnosticsHelper;
import com.revenuecat.purchases.common.diagnostics.DiagnosticsSynchronizer;
import com.revenuecat.purchases.common.diagnostics.DiagnosticsTracker;
import com.revenuecat.purchases.common.events.BackendStoredEvent;
import com.revenuecat.purchases.common.events.EventsManager;
import com.revenuecat.purchases.common.events.EventsRequest;
import com.revenuecat.purchases.common.networking.ETagManager;
import com.revenuecat.purchases.common.offerings.OfferingsCache;
import com.revenuecat.purchases.common.offerings.OfferingsFactory;
import com.revenuecat.purchases.common.offerings.OfferingsManager;
import com.revenuecat.purchases.common.offlineentitlements.OfflineCustomerInfoCalculator;
import com.revenuecat.purchases.common.offlineentitlements.OfflineEntitlementsManager;
import com.revenuecat.purchases.common.offlineentitlements.PurchasedProductsFetcher;
import com.revenuecat.purchases.common.subscriberattributes.DeviceIdentifiersFetcher;
import com.revenuecat.purchases.common.verification.SignatureVerificationMode;
import com.revenuecat.purchases.common.verification.SigningManager;
import com.revenuecat.purchases.common.workflows.FileCachedWorkflowCdnFetcher;
import com.revenuecat.purchases.common.workflows.WorkflowDetailResolver;
import com.revenuecat.purchases.common.workflows.WorkflowManager;
import com.revenuecat.purchases.identity.IdentityManager;
import com.revenuecat.purchases.paywalls.FontLoader;
import com.revenuecat.purchases.paywalls.OfferingFontPreDownloader;
import com.revenuecat.purchases.paywalls.PaywallPresentedCache;
import com.revenuecat.purchases.paywalls.events.PaywallStoredEvent;
import com.revenuecat.purchases.storage.DefaultFileRepository;
import com.revenuecat.purchases.strings.ConfigureStrings;
import com.revenuecat.purchases.subscriberattributes.SubscriberAttributesManager;
import com.revenuecat.purchases.subscriberattributes.SubscriberAttributesPoster;
import com.revenuecat.purchases.subscriberattributes.caching.SubscriberAttributesCache;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.revenuecat.purchases.utils.AndroidVersionUtilsKt;
import com.revenuecat.purchases.utils.CoilImageDownloader;
import com.revenuecat.purchases.utils.EventsFileHelper;
import com.revenuecat.purchases.utils.IsDebugBuildProvider;
import com.revenuecat.purchases.utils.OfferingImagePreDownloader;
import com.revenuecat.purchases.utils.PurchaseParamsValidator;
import com.revenuecat.purchases.virtualcurrencies.VirtualCurrencyManager;
import java.net.URL;
import java.util.Arrays;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

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
/* JADX INFO: loaded from: classes4.dex */
@Metadata
public final class PurchasesFactory {
    public static final Companion Companion = new Companion(null);
    private final APIKeyValidator apiKeyValidator;
    private final IsDebugBuildProvider isDebugBuild;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final boolean shouldInitializeDiagnostics$purchases_defaultsBc8Release(boolean z2, boolean z3) {
            return z2 && !z3;
        }

        private Companion() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    static final class LowPriorityThreadFactory implements ThreadFactory {
        private final String threadName;

        public LowPriorityThreadFactory(String threadName) {
            Intrinsics.checkNotNullParameter(threadName, "threadName");
            this.threadName = threadName;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void newThread$lambda$1(Runnable runnable) {
            if (runnable != null) {
                Process.setThreadPriority(5);
                runnable.run();
            }
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(final Runnable runnable) {
            return new Thread(new Runnable() { // from class: com.revenuecat.purchases.g
                @Override // java.lang.Runnable
                public final void run() {
                    PurchasesFactory.LowPriorityThreadFactory.newThread$lambda$1(runnable);
                }
            }, this.threadName);
        }
    }

    public PurchasesFactory(IsDebugBuildProvider isDebugBuild, APIKeyValidator apiKeyValidator) {
        Intrinsics.checkNotNullParameter(isDebugBuild, "isDebugBuild");
        Intrinsics.checkNotNullParameter(apiKeyValidator, "apiKeyValidator");
        this.isDebugBuild = isDebugBuild;
        this.apiKeyValidator = apiKeyValidator;
    }

    private final ExecutorService createDefaultExecutor() {
        ScheduledExecutorService scheduledExecutorServiceNewSingleThreadScheduledExecutor = Executors.newSingleThreadScheduledExecutor();
        Intrinsics.checkNotNullExpressionValue(scheduledExecutorServiceNewSingleThreadScheduledExecutor, "newSingleThreadScheduledExecutor()");
        return scheduledExecutorServiceNewSingleThreadScheduledExecutor;
    }

    private final ExecutorService createEventsExecutor() {
        ScheduledExecutorService scheduledExecutorServiceNewSingleThreadScheduledExecutor = Executors.newSingleThreadScheduledExecutor(new LowPriorityThreadFactory("revenuecat-events-thread"));
        Intrinsics.checkNotNullExpressionValue(scheduledExecutorServiceNewSingleThreadScheduledExecutor, "newSingleThreadScheduled…venuecat-events-thread\"))");
        return scheduledExecutorServiceNewSingleThreadScheduledExecutor;
    }

    private final EventsManager createEventsManager(IdentityManager identityManager, Dispatcher dispatcher, final Backend backend, EventsFileHelper<PaywallStoredEvent> eventsFileHelper, EventsFileHelper<BackendStoredEvent> eventsFileHelper2, final URL url) {
        return new EventsManager(null, eventsFileHelper, eventsFileHelper2, identityManager, dispatcher, new Function4<EventsRequest, Delay, Function0<? extends Unit>, Function2<? super PurchasesError, ? super Boolean, ? extends Unit>, Unit>() { // from class: com.revenuecat.purchases.PurchasesFactory.createEventsManager.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(4);
            }

            @Override // kotlin.jvm.functions.Function4
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                invoke((EventsRequest) obj, (Delay) obj2, (Function0<Unit>) obj3, (Function2<? super PurchasesError, ? super Boolean, Unit>) obj4);
                return Unit.f139807a;
            }

            public final void invoke(EventsRequest request, Delay delay, Function0<Unit> onSuccess, Function2<? super PurchasesError, ? super Boolean, Unit> onError) {
                Intrinsics.checkNotNullParameter(request, "request");
                Intrinsics.checkNotNullParameter(delay, "delay");
                Intrinsics.checkNotNullParameter(onSuccess, "onSuccess");
                Intrinsics.checkNotNullParameter(onError, "onError");
                backend.postEvents(request, url, delay, onSuccess, onError);
            }
        }, null, 65, null);
    }

    public static /* synthetic */ Purchases createPurchases$default(PurchasesFactory purchasesFactory, PurchasesConfiguration purchasesConfiguration, PlatformInfo platformInfo, URL url, BillingAbstract billingAbstract, ForceServerErrorStrategy forceServerErrorStrategy, boolean z2, boolean z3, String str, int i3, Object obj) {
        if ((i3 & 8) != 0) {
            billingAbstract = null;
        }
        if ((i3 & 16) != 0) {
            forceServerErrorStrategy = null;
        }
        if ((i3 & 32) != 0) {
            z2 = false;
        }
        if ((i3 & 64) != 0) {
            z3 = false;
        }
        if ((i3 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0) {
            str = AppConfig.baseUrlString;
        }
        return purchasesFactory.createPurchases(purchasesConfiguration, platformInfo, url, billingAbstract, forceServerErrorStrategy, z2, z3, str);
    }

    private final Application getApplication(Context context) {
        Context applicationContext = context.getApplicationContext();
        Intrinsics.checkNotNull(applicationContext, "null cannot be cast to non-null type android.app.Application");
        return (Application) applicationContext;
    }

    private final boolean hasPermission(Context context, String str) {
        return context.checkCallingOrSelfPermission(str) == 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Purchases createPurchases(final PurchasesConfiguration configuration, PlatformInfo platformInfo, URL url, BillingAbstract billingAbstract, ForceServerErrorStrategy forceServerErrorStrategy, boolean z2, boolean z3, String baseUrlString) {
        Context context;
        AppConfig appConfig;
        Dispatcher dispatcher;
        DiagnosticsTracker diagnosticsTracker;
        DiagnosticsHelper diagnosticsHelper;
        DiagnosticsFileHelper diagnosticsFileHelper;
        SignatureVerificationMode signatureVerificationModeFromEntitlementVerificationMode$default;
        PurchasesStateCache purchasesStateCache;
        Application application;
        DeviceCache deviceCache;
        BillingAbstract billingAbstract2;
        BillingAbstract billingAbstract3;
        Dispatcher dispatcher2;
        DiagnosticsTracker diagnosticsTracker2;
        Backend backend;
        DiagnosticsSynchronizer diagnosticsSynchronizer;
        int[] iArr;
        Intrinsics.checkNotNullParameter(configuration, "configuration");
        Intrinsics.checkNotNullParameter(platformInfo, "platformInfo");
        Intrinsics.checkNotNullParameter(baseUrlString, "baseUrlString");
        APIKeyValidator.ValidationResult validationResultValidateConfiguration = validateConfiguration(configuration);
        Store store = validationResultValidateConfiguration == APIKeyValidator.ValidationResult.SIMULATED_STORE ? Store.TEST_STORE : configuration.getStore();
        Application application2 = getApplication(configuration.getContext());
        AppConfig appConfig2 = new AppConfig(configuration.getContext(), configuration.getPurchasesAreCompletedBy(), configuration.getShowInAppMessagesAutomatically(), platformInfo, url, store, this.isDebugBuild.invoke(), validationResultValidateConfiguration, configuration.getDangerousSettings(), z3, z2, baseUrlString);
        if (UtilsKt.isDeviceProtectedStorageCompat(configuration.getContext())) {
            LogLevel logLevel = LogLevel.DEBUG;
            LogHandler currentLogHandler = LogWrapperKt.getCurrentLogHandler();
            if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                currentLogHandler.d("[Purchases] - " + logLevel.name(), "‼️ Using device-protected storage. Make sure to *always* configure Purchases with a Context object created using `createDeviceProtectedStorageContext()` to avoid undefined behavior.\nSee https://developer.android.com/reference/android/content/Context#createDeviceProtectedStorageContext() for more info.");
            }
            context = configuration.getContext();
        } else {
            context = application2;
        }
        try {
            SharedPreferences sharedPreferences = new SharedPreferencesManager(context, null, null, 6, null).getSharedPreferences();
            ETagManager eTagManager = new ETagManager(context, null, null, 6, null);
            Dispatcher dispatcher3 = new Dispatcher(createDefaultExecutor(), null, z3, 2, null);
            ExecutorService service = configuration.getService();
            if (service == null) {
                service = createDefaultExecutor();
            }
            int i3 = 2;
            DefaultConstructorMarker defaultConstructorMarker = null;
            Handler handler = null;
            Dispatcher dispatcher4 = new Dispatcher(service, handler, z3, i3, defaultConstructorMarker);
            Dispatcher dispatcher5 = new Dispatcher(createEventsExecutor(), handler, z3, i3, defaultConstructorMarker);
            Companion companion = Companion;
            if (companion.shouldInitializeDiagnostics$purchases_defaultsBc8Release(configuration.getDiagnosticsEnabled(), appConfig2.getUiPreviewMode()) && AndroidVersionUtilsKt.isAndroidNOrNewer()) {
                DiagnosticsFileHelper diagnosticsFileHelper2 = new DiagnosticsFileHelper(new FileHelper(context));
                DiagnosticsHelper diagnosticsHelper2 = new DiagnosticsHelper(context, diagnosticsFileHelper2, null, 4, null);
                DiagnosticsTracker diagnosticsTracker3 = new DiagnosticsTracker(appConfig2, diagnosticsFileHelper2, diagnosticsHelper2, dispatcher5, null, 16, null);
                appConfig = appConfig2;
                dispatcher = dispatcher5;
                diagnosticsHelper = diagnosticsHelper2;
                diagnosticsFileHelper = diagnosticsFileHelper2;
                diagnosticsTracker = diagnosticsTracker3;
            } else {
                appConfig = appConfig2;
                dispatcher = dispatcher5;
                if (companion.shouldInitializeDiagnostics$purchases_defaultsBc8Release(configuration.getDiagnosticsEnabled(), appConfig.getUiPreviewMode())) {
                    LogLevel logLevel2 = LogLevel.WARN;
                    LogHandler currentLogHandler2 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel2) <= 0) {
                        currentLogHandler2.w("[Purchases] - " + logLevel2.name(), "Diagnostics are only supported on Android N or newer.");
                    }
                }
                diagnosticsTracker = null;
                diagnosticsHelper = null;
                diagnosticsFileHelper = null;
            }
            try {
                signatureVerificationModeFromEntitlementVerificationMode$default = SignatureVerificationMode.Companion.fromEntitlementVerificationMode$default(SignatureVerificationMode.Companion, configuration.getVerificationMode(), null, 2, null);
            } catch (IllegalStateException e3) {
                LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", "Error creating signature verifier: " + e3.getMessage() + ". Disabling signature verification.", null);
                signatureVerificationModeFromEntitlementVerificationMode$default = SignatureVerificationMode.Disabled.INSTANCE;
            }
            SigningManager signingManager = new SigningManager(signatureVerificationModeFromEntitlementVerificationMode$default, appConfig, configuration.getApiKey());
            DeviceCache deviceCache2 = new DeviceCache(sharedPreferences, configuration.getApiKey(), null, 4, null);
            DefaultLocaleProvider defaultLocaleProvider = new DefaultLocaleProvider();
            DiagnosticsTracker diagnosticsTracker4 = diagnosticsTracker;
            HTTPClient hTTPClient = new HTTPClient(appConfig, eTagManager, diagnosticsTracker4, signingManager, deviceCache2, null, 0 == true ? 1 : 0, defaultLocaleProvider, forceServerErrorStrategy, null, null, 1632, null);
            DiagnosticsTracker diagnosticsTracker5 = diagnosticsTracker4;
            BackendHelper backendHelper = new BackendHelper(configuration.getApiKey(), dispatcher4, appConfig, hTTPClient);
            Context context2 = context;
            final AppConfig appConfig3 = appConfig;
            Backend backend2 = new Backend(appConfig3, dispatcher4, dispatcher, hTTPClient, backendHelper);
            WorkflowManager workflowManager = new WorkflowManager(backend2, new WorkflowDetailResolver(new FileCachedWorkflowCdnFetcher(new DefaultFileRepository(context2, "rc_compiled_workflows"))), null, 4, null);
            PurchasesStateCache purchasesStateCache2 = new PurchasesStateCache(new PurchasesState(null, null, null, false, false, 31, null));
            if (billingAbstract == null) {
                application = application2;
                BillingAbstract billingAbstractCreateBilling = BillingFactory.INSTANCE.createBilling(store, application, backendHelper, deviceCache2, PurchasesAreCompletedByKt.getFinishTransactions(configuration.getPurchasesAreCompletedBy()), diagnosticsTracker5, purchasesStateCache2, configuration.getPendingTransactionsForPrepaidPlansEnabled(), configuration.getGalaxyBillingMode(), backend2);
                deviceCache = deviceCache2;
                purchasesStateCache = purchasesStateCache2;
                diagnosticsTracker5 = diagnosticsTracker5;
                billingAbstract2 = billingAbstractCreateBilling;
            } else {
                purchasesStateCache = purchasesStateCache2;
                application = application2;
                deviceCache = deviceCache2;
                billingAbstract2 = billingAbstract;
            }
            SubscriberAttributesPoster subscriberAttributesPoster = new SubscriberAttributesPoster(backendHelper);
            DeviceIdentifiersFetcher deviceIdentifiersFetcherCreateAttributionFetcher = AttributionFetcherFactory.INSTANCE.createAttributionFetcher(configuration.getStore(), dispatcher4);
            SubscriberAttributesCache subscriberAttributesCache = new SubscriberAttributesCache(deviceCache);
            SubscriberAttributesManager subscriberAttributesManager = new SubscriberAttributesManager(subscriberAttributesCache, subscriberAttributesPoster, deviceIdentifiersFetcherCreateAttributionFetcher, configuration.getAutomaticDeviceIdentifierCollectionEnabled());
            DefaultConstructorMarker defaultConstructorMarker2 = null;
            DateProvider dateProvider = null;
            DeviceCache deviceCache3 = deviceCache;
            BillingAbstract billingAbstract4 = billingAbstract2;
            DiagnosticsTracker diagnosticsTracker6 = diagnosticsTracker5;
            OfflineEntitlementsManager offlineEntitlementsManager = new OfflineEntitlementsManager(backend2, new OfflineCustomerInfoCalculator(new PurchasedProductsFetcher(deviceCache3, billingAbstract4, dateProvider, 4, defaultConstructorMarker2), appConfig3, diagnosticsTracker5, dateProvider, 8, defaultConstructorMarker2), deviceCache3, appConfig3, diagnosticsTracker6);
            OfferingsCache offeringsCache = new OfferingsCache(deviceCache3, null, null, defaultLocaleProvider, 6, null);
            IdentityManager identityManager = new IdentityManager(deviceCache3, subscriberAttributesCache, subscriberAttributesManager, offeringsCache, backend2, offlineEntitlementsManager, dispatcher3, appConfig3.getUiPreviewMode());
            CustomerInfoUpdateHandler customerInfoUpdateHandler = new CustomerInfoUpdateHandler(deviceCache3, identityManager, offlineEntitlementsManager, appConfig3, diagnosticsTracker6, null, 32, null);
            PaywallPresentedCache paywallPresentedCache = new PaywallPresentedCache();
            PostReceiptHelper postReceiptHelper = new PostReceiptHelper(appConfig3, backend2, billingAbstract4, customerInfoUpdateHandler, deviceCache3, subscriberAttributesManager, offlineEntitlementsManager, paywallPresentedCache, new LocalTransactionMetadataStore(context2, configuration.getApiKey(), 0 == true ? 1 : 0, null, 12, null));
            PostTransactionWithProductDetailsHelper postTransactionWithProductDetailsHelper = new PostTransactionWithProductDetailsHelper(billingAbstract4, postReceiptHelper);
            PostPendingTransactionsHelper postPendingTransactionsHelper = new PostPendingTransactionsHelper(appConfig3, deviceCache3, billingAbstract4, dispatcher4, identityManager, postTransactionWithProductDetailsHelper, postReceiptHelper);
            CustomerInfoHelper customerInfoHelper = new CustomerInfoHelper(deviceCache3, backend2, offlineEntitlementsManager, customerInfoUpdateHandler, postPendingTransactionsHelper, diagnosticsTracker6, appConfig3.getUiPreviewMode(), null, null, 384, null);
            OfferingParser offeringParserCreateOfferingParser = OfferingParserFactory.INSTANCE.createOfferingParser(store);
            if (diagnosticsFileHelper == null || diagnosticsHelper == null || diagnosticsTracker6 == null || !AndroidVersionUtilsKt.isAndroidNOrNewer()) {
                billingAbstract3 = billingAbstract4;
                dispatcher2 = dispatcher;
                diagnosticsTracker2 = diagnosticsTracker6;
                backend = backend2;
                diagnosticsSynchronizer = null;
            } else {
                Dispatcher dispatcher6 = dispatcher;
                diagnosticsSynchronizer = new DiagnosticsSynchronizer(diagnosticsHelper, diagnosticsFileHelper, diagnosticsTracker6, backend2, dispatcher6);
                backend = backend2;
                dispatcher2 = dispatcher6;
                billingAbstract3 = billingAbstract4;
                diagnosticsTracker2 = diagnosticsTracker6;
                diagnosticsTracker2.setListener(diagnosticsSynchronizer);
            }
            BillingAbstract billingAbstract5 = billingAbstract3;
            DiagnosticsTracker diagnosticsTracker7 = diagnosticsTracker2;
            SyncPurchasesHelper syncPurchasesHelper = new SyncPurchasesHelper(billingAbstract5, identityManager, customerInfoHelper, postReceiptHelper, diagnosticsTracker7, null, 32, null);
            FontLoader fontLoader = new FontLoader(context2, null, null, 0 == true ? 1 : 0, 14, null);
            DiagnosticsSynchronizer diagnosticsSynchronizer2 = diagnosticsSynchronizer;
            Backend backend3 = backend;
            OfferingsManager offeringsManager = new OfferingsManager(offeringsCache, backend3, new OfferingsFactory(billingAbstract5, offeringParserCreateOfferingParser, dispatcher3, appConfig3), new OfferingImagePreDownloader(false, new CoilImageDownloader(application), 1, null), diagnosticsTracker7, new OfferingFontPreDownloader(context2, fontLoader), appConfig3.getUiPreviewMode(), 0 == true ? 1 : 0, null, 384, null);
            final LogIntent logIntent = LogIntent.DEBUG;
            Function0<String> function0 = new Function0<String>() { // from class: com.revenuecat.purchases.PurchasesFactory$createPurchases$lambda$8$$inlined$log$1
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return CollectionsKt.joinToString$default(logIntent.getEmojiList(), "", null, null, 0, null, null, 62, null) + ' ' + ConfigureStrings.DEBUG_ENABLED;
                }
            };
            int[] iArr2 = LogWrapperKt.WhenMappings.$EnumSwitchMapping$0;
            switch (iArr2[logIntent.ordinal()]) {
                case 1:
                    LogLevel logLevel3 = LogLevel.DEBUG;
                    LogHandler currentLogHandler3 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel3) <= 0) {
                        currentLogHandler3.d("[Purchases] - " + logLevel3.name(), (String) function0.invoke());
                    }
                    break;
                case 2:
                    LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) function0.invoke(), null);
                    break;
                case 3:
                    LogLevel logLevel4 = LogLevel.WARN;
                    LogHandler currentLogHandler4 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel4) <= 0) {
                        currentLogHandler4.w("[Purchases] - " + logLevel4.name(), (String) function0.invoke());
                    }
                    break;
                case 4:
                    LogLevel logLevel5 = LogLevel.INFO;
                    LogHandler currentLogHandler5 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel5) <= 0) {
                        currentLogHandler5.i("[Purchases] - " + logLevel5.name(), (String) function0.invoke());
                    }
                    break;
                case 5:
                    LogLevel logLevel6 = LogLevel.DEBUG;
                    LogHandler currentLogHandler6 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel6) <= 0) {
                        currentLogHandler6.d("[Purchases] - " + logLevel6.name(), (String) function0.invoke());
                    }
                    break;
                case 6:
                    LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) function0.invoke(), null);
                    break;
                case 7:
                    LogLevel logLevel7 = LogLevel.INFO;
                    LogHandler currentLogHandler7 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel7) <= 0) {
                        currentLogHandler7.i("[Purchases] - " + logLevel7.name(), (String) function0.invoke());
                    }
                    break;
                case 8:
                    LogLevel logLevel8 = LogLevel.DEBUG;
                    LogHandler currentLogHandler8 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel8) <= 0) {
                        currentLogHandler8.d("[Purchases] - " + logLevel8.name(), (String) function0.invoke());
                    }
                    break;
                case 9:
                    LogLevel logLevel9 = LogLevel.DEBUG;
                    LogHandler currentLogHandler9 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel9) <= 0) {
                        currentLogHandler9.d("[Purchases] - " + logLevel9.name(), (String) function0.invoke());
                    }
                    break;
                case 10:
                    LogLevel logLevel10 = LogLevel.WARN;
                    LogHandler currentLogHandler10 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel10) <= 0) {
                        currentLogHandler10.w("[Purchases] - " + logLevel10.name(), (String) function0.invoke());
                    }
                    break;
                case 11:
                    LogLevel logLevel11 = LogLevel.WARN;
                    LogHandler currentLogHandler11 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel11) <= 0) {
                        currentLogHandler11.w("[Purchases] - " + logLevel11.name(), (String) function0.invoke());
                    }
                    break;
                case 12:
                    LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) function0.invoke(), null);
                    break;
                case 13:
                    LogLevel logLevel12 = LogLevel.WARN;
                    LogHandler currentLogHandler12 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel12) <= 0) {
                        currentLogHandler12.w("[Purchases] - " + logLevel12.name(), (String) function0.invoke());
                    }
                    break;
                case 14:
                    LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) function0.invoke(), null);
                    break;
            }
            Function0<String> function02 = new Function0<String>() { // from class: com.revenuecat.purchases.PurchasesFactory$createPurchases$lambda$8$$inlined$log$2
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    StringBuilder sb = new StringBuilder();
                    sb.append(CollectionsKt.joinToString$default(logIntent.getEmojiList(), "", null, null, 0, null, null, 62, null));
                    sb.append(' ');
                    String str = String.format(ConfigureStrings.SDK_VERSION, Arrays.copyOf(new Object[]{Purchases.Companion.getFrameworkVersion()}, 1));
                    Intrinsics.checkNotNullExpressionValue(str, "format(...)");
                    sb.append(str);
                    return sb.toString();
                }
            };
            switch (iArr2[logIntent.ordinal()]) {
                case 1:
                    LogLevel logLevel13 = LogLevel.DEBUG;
                    LogHandler currentLogHandler13 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel13) <= 0) {
                        currentLogHandler13.d("[Purchases] - " + logLevel13.name(), (String) function02.invoke());
                    }
                    break;
                case 2:
                    LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) function02.invoke(), null);
                    break;
                case 3:
                    LogLevel logLevel14 = LogLevel.WARN;
                    LogHandler currentLogHandler14 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel14) <= 0) {
                        currentLogHandler14.w("[Purchases] - " + logLevel14.name(), (String) function02.invoke());
                    }
                    break;
                case 4:
                    LogLevel logLevel15 = LogLevel.INFO;
                    LogHandler currentLogHandler15 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel15) <= 0) {
                        currentLogHandler15.i("[Purchases] - " + logLevel15.name(), (String) function02.invoke());
                    }
                    break;
                case 5:
                    LogLevel logLevel16 = LogLevel.DEBUG;
                    LogHandler currentLogHandler16 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel16) <= 0) {
                        currentLogHandler16.d("[Purchases] - " + logLevel16.name(), (String) function02.invoke());
                    }
                    break;
                case 6:
                    LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) function02.invoke(), null);
                    break;
                case 7:
                    LogLevel logLevel17 = LogLevel.INFO;
                    LogHandler currentLogHandler17 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel17) <= 0) {
                        currentLogHandler17.i("[Purchases] - " + logLevel17.name(), (String) function02.invoke());
                    }
                    break;
                case 8:
                    LogLevel logLevel18 = LogLevel.DEBUG;
                    LogHandler currentLogHandler18 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel18) <= 0) {
                        currentLogHandler18.d("[Purchases] - " + logLevel18.name(), (String) function02.invoke());
                    }
                    break;
                case 9:
                    LogLevel logLevel19 = LogLevel.DEBUG;
                    LogHandler currentLogHandler19 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel19) <= 0) {
                        currentLogHandler19.d("[Purchases] - " + logLevel19.name(), (String) function02.invoke());
                    }
                    break;
                case 10:
                    LogLevel logLevel20 = LogLevel.WARN;
                    LogHandler currentLogHandler20 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel20) <= 0) {
                        currentLogHandler20.w("[Purchases] - " + logLevel20.name(), (String) function02.invoke());
                    }
                    break;
                case 11:
                    LogLevel logLevel21 = LogLevel.WARN;
                    LogHandler currentLogHandler21 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel21) <= 0) {
                        currentLogHandler21.w("[Purchases] - " + logLevel21.name(), (String) function02.invoke());
                    }
                    break;
                case 12:
                    LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) function02.invoke(), null);
                    break;
                case 13:
                    LogLevel logLevel22 = LogLevel.WARN;
                    LogHandler currentLogHandler22 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel22) <= 0) {
                        currentLogHandler22.w("[Purchases] - " + logLevel22.name(), (String) function02.invoke());
                    }
                    break;
                case 14:
                    LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) function02.invoke(), null);
                    break;
            }
            Function0<String> function03 = new Function0<String>() { // from class: com.revenuecat.purchases.PurchasesFactory$createPurchases$lambda$8$$inlined$log$3
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    StringBuilder sb = new StringBuilder();
                    sb.append(CollectionsKt.joinToString$default(logIntent.getEmojiList(), "", null, null, 0, null, null, 62, null));
                    sb.append(' ');
                    String str = String.format(ConfigureStrings.PACKAGE_NAME, Arrays.copyOf(new Object[]{appConfig3.getPackageName()}, 1));
                    Intrinsics.checkNotNullExpressionValue(str, "format(...)");
                    sb.append(str);
                    return sb.toString();
                }
            };
            switch (iArr2[logIntent.ordinal()]) {
                case 1:
                    LogLevel logLevel23 = LogLevel.DEBUG;
                    LogHandler currentLogHandler23 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel23) <= 0) {
                        currentLogHandler23.d("[Purchases] - " + logLevel23.name(), (String) function03.invoke());
                    }
                    break;
                case 2:
                    LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) function03.invoke(), null);
                    break;
                case 3:
                    LogLevel logLevel24 = LogLevel.WARN;
                    LogHandler currentLogHandler24 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel24) <= 0) {
                        currentLogHandler24.w("[Purchases] - " + logLevel24.name(), (String) function03.invoke());
                    }
                    break;
                case 4:
                    LogLevel logLevel25 = LogLevel.INFO;
                    LogHandler currentLogHandler25 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel25) <= 0) {
                        currentLogHandler25.i("[Purchases] - " + logLevel25.name(), (String) function03.invoke());
                    }
                    break;
                case 5:
                    LogLevel logLevel26 = LogLevel.DEBUG;
                    LogHandler currentLogHandler26 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel26) <= 0) {
                        currentLogHandler26.d("[Purchases] - " + logLevel26.name(), (String) function03.invoke());
                    }
                    break;
                case 6:
                    LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) function03.invoke(), null);
                    break;
                case 7:
                    LogLevel logLevel27 = LogLevel.INFO;
                    LogHandler currentLogHandler27 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel27) <= 0) {
                        currentLogHandler27.i("[Purchases] - " + logLevel27.name(), (String) function03.invoke());
                    }
                    break;
                case 8:
                    LogLevel logLevel28 = LogLevel.DEBUG;
                    LogHandler currentLogHandler28 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel28) <= 0) {
                        currentLogHandler28.d("[Purchases] - " + logLevel28.name(), (String) function03.invoke());
                    }
                    break;
                case 9:
                    LogLevel logLevel29 = LogLevel.DEBUG;
                    LogHandler currentLogHandler29 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel29) <= 0) {
                        currentLogHandler29.d("[Purchases] - " + logLevel29.name(), (String) function03.invoke());
                    }
                    break;
                case 10:
                    LogLevel logLevel30 = LogLevel.WARN;
                    LogHandler currentLogHandler30 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel30) <= 0) {
                        currentLogHandler30.w("[Purchases] - " + logLevel30.name(), (String) function03.invoke());
                    }
                    break;
                case 11:
                    LogLevel logLevel31 = LogLevel.WARN;
                    LogHandler currentLogHandler31 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel31) <= 0) {
                        currentLogHandler31.w("[Purchases] - " + logLevel31.name(), (String) function03.invoke());
                    }
                    break;
                case 12:
                    LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) function03.invoke(), null);
                    break;
                case 13:
                    LogLevel logLevel32 = LogLevel.WARN;
                    LogHandler currentLogHandler32 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel32) <= 0) {
                        currentLogHandler32.w("[Purchases] - " + logLevel32.name(), (String) function03.invoke());
                    }
                    break;
                case 14:
                    LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) function03.invoke(), null);
                    break;
            }
            final LogIntent logIntent2 = LogIntent.USER;
            Function0<String> function04 = new Function0<String>() { // from class: com.revenuecat.purchases.PurchasesFactory$createPurchases$lambda$8$$inlined$log$4
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    StringBuilder sb = new StringBuilder();
                    sb.append(CollectionsKt.joinToString$default(logIntent2.getEmojiList(), "", null, null, 0, null, null, 62, null));
                    sb.append(' ');
                    String str = String.format(ConfigureStrings.INITIAL_APP_USER_ID, Arrays.copyOf(new Object[]{configuration.getAppUserID()}, 1));
                    Intrinsics.checkNotNullExpressionValue(str, "format(...)");
                    sb.append(str);
                    return sb.toString();
                }
            };
            switch (iArr2[logIntent2.ordinal()]) {
                case 1:
                    iArr = iArr2;
                    LogLevel logLevel33 = LogLevel.DEBUG;
                    LogHandler currentLogHandler33 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel33) <= 0) {
                        currentLogHandler33.d("[Purchases] - " + logLevel33.name(), (String) function04.invoke());
                    }
                    break;
                case 2:
                    iArr = iArr2;
                    LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) function04.invoke(), null);
                    break;
                case 3:
                    iArr = iArr2;
                    LogLevel logLevel34 = LogLevel.WARN;
                    LogHandler currentLogHandler34 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel34) <= 0) {
                        currentLogHandler34.w("[Purchases] - " + logLevel34.name(), (String) function04.invoke());
                    }
                    break;
                case 4:
                    iArr = iArr2;
                    LogLevel logLevel35 = LogLevel.INFO;
                    LogHandler currentLogHandler35 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel35) <= 0) {
                        currentLogHandler35.i("[Purchases] - " + logLevel35.name(), (String) function04.invoke());
                    }
                    break;
                case 5:
                    iArr = iArr2;
                    LogLevel logLevel36 = LogLevel.DEBUG;
                    LogHandler currentLogHandler36 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel36) <= 0) {
                        currentLogHandler36.d("[Purchases] - " + logLevel36.name(), (String) function04.invoke());
                    }
                    break;
                case 6:
                    iArr = iArr2;
                    LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) function04.invoke(), null);
                    break;
                case 7:
                    iArr = iArr2;
                    LogLevel logLevel37 = LogLevel.INFO;
                    LogHandler currentLogHandler37 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel37) <= 0) {
                        currentLogHandler37.i("[Purchases] - " + logLevel37.name(), (String) function04.invoke());
                    }
                    break;
                case 8:
                    iArr = iArr2;
                    LogLevel logLevel38 = LogLevel.DEBUG;
                    LogHandler currentLogHandler38 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel38) <= 0) {
                        currentLogHandler38.d("[Purchases] - " + logLevel38.name(), (String) function04.invoke());
                    }
                    break;
                case 9:
                    iArr = iArr2;
                    LogLevel logLevel39 = LogLevel.DEBUG;
                    LogHandler currentLogHandler39 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel39) <= 0) {
                        currentLogHandler39.d("[Purchases] - " + logLevel39.name(), (String) function04.invoke());
                    }
                    break;
                case 10:
                    iArr = iArr2;
                    LogLevel logLevel40 = LogLevel.WARN;
                    LogHandler currentLogHandler40 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel40) <= 0) {
                        currentLogHandler40.w("[Purchases] - " + logLevel40.name(), (String) function04.invoke());
                    }
                    break;
                case 11:
                    iArr = iArr2;
                    LogLevel logLevel41 = LogLevel.WARN;
                    LogHandler currentLogHandler41 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel41) <= 0) {
                        currentLogHandler41.w("[Purchases] - " + logLevel41.name(), (String) function04.invoke());
                    }
                    break;
                case 12:
                    iArr = iArr2;
                    LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) function04.invoke(), null);
                    break;
                case 13:
                    LogLevel logLevel42 = LogLevel.WARN;
                    LogHandler currentLogHandler42 = LogWrapperKt.getCurrentLogHandler();
                    iArr = iArr2;
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel42) <= 0) {
                        currentLogHandler42.w("[Purchases] - " + logLevel42.name(), (String) function04.invoke());
                    }
                    break;
                case 14:
                    LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) function04.invoke(), null);
                default:
                    iArr = iArr2;
                    break;
            }
            Function0<String> function05 = new Function0<String>() { // from class: com.revenuecat.purchases.PurchasesFactory$createPurchases$lambda$8$$inlined$log$5
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    StringBuilder sb = new StringBuilder();
                    sb.append(CollectionsKt.joinToString$default(logIntent.getEmojiList(), "", null, null, 0, null, null, 62, null));
                    sb.append(' ');
                    String str = String.format(ConfigureStrings.VERIFICATION_MODE_SELECTED, Arrays.copyOf(new Object[]{configuration.getVerificationMode().name()}, 1));
                    Intrinsics.checkNotNullExpressionValue(str, "format(...)");
                    sb.append(str);
                    return sb.toString();
                }
            };
            switch (iArr[logIntent.ordinal()]) {
                case 1:
                    LogLevel logLevel43 = LogLevel.DEBUG;
                    LogHandler currentLogHandler43 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel43) <= 0) {
                        currentLogHandler43.d("[Purchases] - " + logLevel43.name(), (String) function05.invoke());
                    }
                    break;
                case 2:
                    LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) function05.invoke(), null);
                    break;
                case 3:
                    LogLevel logLevel44 = LogLevel.WARN;
                    LogHandler currentLogHandler44 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel44) <= 0) {
                        currentLogHandler44.w("[Purchases] - " + logLevel44.name(), (String) function05.invoke());
                    }
                    break;
                case 4:
                    LogLevel logLevel45 = LogLevel.INFO;
                    LogHandler currentLogHandler45 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel45) <= 0) {
                        currentLogHandler45.i("[Purchases] - " + logLevel45.name(), (String) function05.invoke());
                    }
                    break;
                case 5:
                    LogLevel logLevel46 = LogLevel.DEBUG;
                    LogHandler currentLogHandler46 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel46) <= 0) {
                        currentLogHandler46.d("[Purchases] - " + logLevel46.name(), (String) function05.invoke());
                    }
                    break;
                case 6:
                    LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) function05.invoke(), null);
                    break;
                case 7:
                    LogLevel logLevel47 = LogLevel.INFO;
                    LogHandler currentLogHandler47 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel47) <= 0) {
                        currentLogHandler47.i("[Purchases] - " + logLevel47.name(), (String) function05.invoke());
                    }
                    break;
                case 8:
                    LogLevel logLevel48 = LogLevel.DEBUG;
                    LogHandler currentLogHandler48 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel48) <= 0) {
                        currentLogHandler48.d("[Purchases] - " + logLevel48.name(), (String) function05.invoke());
                    }
                    break;
                case 9:
                    LogLevel logLevel49 = LogLevel.DEBUG;
                    LogHandler currentLogHandler49 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel49) <= 0) {
                        currentLogHandler49.d("[Purchases] - " + logLevel49.name(), (String) function05.invoke());
                    }
                    break;
                case 10:
                    LogLevel logLevel50 = LogLevel.WARN;
                    LogHandler currentLogHandler50 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel50) <= 0) {
                        currentLogHandler50.w("[Purchases] - " + logLevel50.name(), (String) function05.invoke());
                    }
                    break;
                case 11:
                    LogLevel logLevel51 = LogLevel.WARN;
                    LogHandler currentLogHandler51 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel51) <= 0) {
                        currentLogHandler51.w("[Purchases] - " + logLevel51.name(), (String) function05.invoke());
                    }
                    break;
                case 12:
                    LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) function05.invoke(), null);
                    break;
                case 13:
                    LogLevel logLevel52 = LogLevel.WARN;
                    LogHandler currentLogHandler52 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel52) <= 0) {
                        currentLogHandler52.w("[Purchases] - " + logLevel52.name(), (String) function05.invoke());
                    }
                    break;
                case 14:
                    LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) function05.invoke(), null);
                    break;
            }
            VirtualCurrencyManager virtualCurrencyManager = new VirtualCurrencyManager(identityManager, deviceCache3, backend3, appConfig3);
            PurchaseParamsValidator purchaseParamsValidator = new PurchaseParamsValidator();
            EventsManager.Companion companion2 = EventsManager.Companion;
            EventsFileHelper<PaywallStoredEvent> eventsFileHelperPaywalls = companion2.paywalls(new FileHelper(application));
            EventsFileHelper<BackendStoredEvent> eventsFileHelperBackendEvents = companion2.backendEvents(new FileHelper(application));
            AppConfig.Companion companion3 = AppConfig.Companion;
            Dispatcher dispatcher7 = dispatcher2;
            return new Purchases(new PurchasesOrchestrator(application, configuration.getAppUserID(), backend3, billingAbstract5, deviceCache3, identityManager, subscriberAttributesManager, appConfig3, customerInfoHelper, customerInfoUpdateHandler, diagnosticsSynchronizer2, diagnosticsTracker7, null, offlineEntitlementsManager, postReceiptHelper, postTransactionWithProductDetailsHelper, postPendingTransactionsHelper, syncPurchasesHelper, offeringsManager, createEventsManager(identityManager, dispatcher7, backend3, eventsFileHelperPaywalls, eventsFileHelperBackendEvents, companion3.getPaywallEventsURL()), createEventsManager(identityManager, dispatcher7, backend3, null, companion2.adEvents(new FileHelper(application)), companion3.getAdEventsURL()), paywallPresentedCache, purchasesStateCache, null, dispatcher3, configuration, fontLoader, defaultLocaleProvider, null, virtualCurrencyManager, purchaseParamsValidator, workflowManager, null, null, null, null, null, 276828160, 31, null));
        } catch (IllegalStateException e4) {
            if (UserManagerCompat.a(configuration.getContext())) {
                throw e4;
            }
            throw new IllegalStateException("Trying to configure Purchases while the device is locked. If you need to support this scenario, ensure you *always* configure Purchases with a Context created with `createDeviceProtectedStorageContext()` to avoid undefined behavior.\nSee https://developer.android.com/reference/android/content/Context#createDeviceProtectedStorageContext() for more info.", e4);
        }
    }

    public final APIKeyValidator.ValidationResult validateConfiguration(PurchasesConfiguration configuration) {
        Intrinsics.checkNotNullParameter(configuration, "configuration");
        if (!hasPermission(configuration.getContext(), "android.permission.INTERNET")) {
            throw new IllegalArgumentException("Purchases requires INTERNET permission.");
        }
        if (StringsKt.p0(configuration.getApiKey())) {
            throw new IllegalArgumentException("API key must be set. Get this from the RevenueCat web app");
        }
        APIKeyValidator.ValidationResult validationResultValidateAndLog = this.apiKeyValidator.validateAndLog(configuration.getApiKey(), configuration.getStore());
        if (this.isDebugBuild.invoke() || validationResultValidateAndLog != APIKeyValidator.ValidationResult.SIMULATED_STORE || configuration.getDangerousSettings().getUiPreviewMode$purchases_defaultsBc8Release()) {
            if (configuration.getContext().getApplicationContext() instanceof Application) {
                return validationResultValidateAndLog;
            }
            throw new IllegalArgumentException("Needs an application context.");
        }
        String strRedactApiKey = this.apiKeyValidator.redactApiKey(configuration.getApiKey());
        LogUtilsKt.errorLog(new PurchasesError(PurchasesErrorCode.ConfigurationError, "Test Store API key used in release build: " + strRedactApiKey + ". Please configure the Play Store/Amazon app on the RevenueCat dashboard and use its corresponding API key before releasing. Visit https://rev.cat/sdk-test-store to learn more."));
        SimulatedStoreErrorDialogActivity.Companion.show(configuration.getContext(), strRedactApiKey);
        return validationResultValidateAndLog;
    }

    public /* synthetic */ PurchasesFactory(IsDebugBuildProvider isDebugBuildProvider, APIKeyValidator aPIKeyValidator, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(isDebugBuildProvider, (i3 & 2) != 0 ? new APIKeyValidator() : aPIKeyValidator);
    }
}
