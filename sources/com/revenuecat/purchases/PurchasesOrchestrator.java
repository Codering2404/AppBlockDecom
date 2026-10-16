package com.revenuecat.purchases;

import android.app.Activity;
import android.app.Application;
import android.app.backup.BackupManager;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.Pair;
import androidx.lifecycle.LifecycleOwner;
import coil.ImageLoader;
import coil.disk.DiskCache;
import com.android.billingclient.api.BillingClient;
import com.android.billingclient.api.BillingResult;
import com.android.billingclient.api.PendingPurchasesParams;
import com.android.billingclient.api.PurchasesUpdatedListener;
import com.facebook.ads.AdError;
import com.facebook.internal.AnalyticsEvents;
import com.revenuecat.purchases.APIKeyValidator;
import com.revenuecat.purchases.UiConfig;
import com.revenuecat.purchases.ads.events.AdTracker;
import com.revenuecat.purchases.blockstore.BlockstoreHelper;
import com.revenuecat.purchases.common.AppConfig;
import com.revenuecat.purchases.common.Backend;
import com.revenuecat.purchases.common.BillingAbstract;
import com.revenuecat.purchases.common.Config;
import com.revenuecat.purchases.common.Constants;
import com.revenuecat.purchases.common.DateProvider;
import com.revenuecat.purchases.common.DefaultLocaleProvider;
import com.revenuecat.purchases.common.Delay;
import com.revenuecat.purchases.common.Dispatcher;
import com.revenuecat.purchases.common.DurationExtensionsKt;
import com.revenuecat.purchases.common.LogIntent;
import com.revenuecat.purchases.common.LogUtilsKt;
import com.revenuecat.purchases.common.LogWrapperKt;
import com.revenuecat.purchases.common.PlatformInfo;
import com.revenuecat.purchases.common.ReceiptInfo;
import com.revenuecat.purchases.common.ReplaceProductInfo;
import com.revenuecat.purchases.common.UtilsKt;
import com.revenuecat.purchases.common.caching.DeviceCache;
import com.revenuecat.purchases.common.diagnostics.DiagnosticsSynchronizer;
import com.revenuecat.purchases.common.diagnostics.DiagnosticsTracker;
import com.revenuecat.purchases.common.events.EventsManager;
import com.revenuecat.purchases.common.events.FeatureEvent;
import com.revenuecat.purchases.common.offerings.OfferingsManager;
import com.revenuecat.purchases.common.offlineentitlements.OfflineEntitlementsManager;
import com.revenuecat.purchases.common.subscriberattributes.SubscriberAttributeKey;
import com.revenuecat.purchases.common.workflows.WorkflowDataResult;
import com.revenuecat.purchases.common.workflows.WorkflowManager;
import com.revenuecat.purchases.customercenter.CustomerCenterConfigData;
import com.revenuecat.purchases.customercenter.CustomerCenterListener;
import com.revenuecat.purchases.deeplinks.WebPurchaseRedemptionHelper;
import com.revenuecat.purchases.identity.IdentityManager;
import com.revenuecat.purchases.interfaces.Callback;
import com.revenuecat.purchases.interfaces.GetAmazonLWAConsentStatusCallback;
import com.revenuecat.purchases.interfaces.GetCustomerCenterConfigCallback;
import com.revenuecat.purchases.interfaces.GetStoreProductsCallback;
import com.revenuecat.purchases.interfaces.GetStorefrontCallback;
import com.revenuecat.purchases.interfaces.GetStorefrontLocaleCallback;
import com.revenuecat.purchases.interfaces.GetVirtualCurrenciesCallback;
import com.revenuecat.purchases.interfaces.LogInCallback;
import com.revenuecat.purchases.interfaces.ProductChangeCallback;
import com.revenuecat.purchases.interfaces.PurchaseCallback;
import com.revenuecat.purchases.interfaces.PurchaseErrorCallback;
import com.revenuecat.purchases.interfaces.ReceiveCustomerInfoCallback;
import com.revenuecat.purchases.interfaces.ReceiveOfferingsCallback;
import com.revenuecat.purchases.interfaces.RedeemWebPurchaseListener;
import com.revenuecat.purchases.interfaces.SyncAttributesAndOfferingsCallback;
import com.revenuecat.purchases.interfaces.SyncPurchasesCallback;
import com.revenuecat.purchases.interfaces.UpdatedCustomerInfoListener;
import com.revenuecat.purchases.models.BillingFeature;
import com.revenuecat.purchases.models.GooglePurchasingData;
import com.revenuecat.purchases.models.GoogleStoreProduct;
import com.revenuecat.purchases.models.InAppMessageType;
import com.revenuecat.purchases.models.PurchasingData;
import com.revenuecat.purchases.models.StoreProduct;
import com.revenuecat.purchases.models.StoreReplacementMode;
import com.revenuecat.purchases.models.StoreTransaction;
import com.revenuecat.purchases.paywalls.DownloadedFontFamily;
import com.revenuecat.purchases.paywalls.FontLoader;
import com.revenuecat.purchases.paywalls.PaywallPresentedCache;
import com.revenuecat.purchases.paywalls.events.PaywallEvent;
import com.revenuecat.purchases.storage.FileRepository;
import com.revenuecat.purchases.strings.AttributionStrings;
import com.revenuecat.purchases.strings.BillingStrings;
import com.revenuecat.purchases.strings.ConfigureStrings;
import com.revenuecat.purchases.strings.CustomerInfoStrings;
import com.revenuecat.purchases.strings.IdentityStrings;
import com.revenuecat.purchases.strings.PurchaseStrings;
import com.revenuecat.purchases.strings.RestoreStrings;
import com.revenuecat.purchases.strings.SyncAttributesAndOfferingsStrings;
import com.revenuecat.purchases.subscriberattributes.SubscriberAttributesManager;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.revenuecat.purchases.utils.AndroidVersionUtilsKt;
import com.revenuecat.purchases.utils.CustomActivityLifecycleHandler;
import com.revenuecat.purchases.utils.PurchaseParamsValidator;
import com.revenuecat.purchases.utils.RateLimiter;
import com.revenuecat.purchases.utils.Result;
import com.revenuecat.purchases.virtualcurrencies.VirtualCurrencies;
import com.revenuecat.purchases.virtualcurrencies.VirtualCurrencyManager;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.experimental.kJ.HcgZcEUYo;
import kotlin.io.FilesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;
import kotlin.time.Duration;
import kotlin.time.DurationKt;
import kotlin.time.DurationUnit;

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
public final class PurchasesOrchestrator implements LifecycleDelegate, CustomActivityLifecycleHandler {
    private static ImageLoader cachedImageLoader = null;
    public static final String frameworkVersion = "10.3.1";
    private static URL proxyURL;
    private volatile String _preferredUILocaleOverride;
    private final EventsManager adEventsManager;
    private final AdTracker adTracker;
    private AppConfig appConfig;
    private final Application application;
    private final Backend backend;
    private final BackupManager backupManager;
    private final BillingAbstract billing;
    private final BlockstoreHelper blockstoreHelper;
    private CustomerCenterListener customerCenterListener;
    private final CustomerInfoHelper customerInfoHelper;
    private final CustomerInfoUpdateHandler customerInfoUpdateHandler;
    private final DateProvider dateProvider;
    private final DeviceCache deviceCache;
    private final DiagnosticsSynchronizer diagnosticsSynchronizer;
    private final DiagnosticsTracker diagnosticsTrackerIfEnabled;
    private final Dispatcher dispatcher;
    private final EventsManager eventsManager;
    private final FileRepository fileRepository;
    private final FontLoader fontLoader;
    private final IdentityManager identityManager;
    private final PurchasesConfiguration initialConfiguration;
    private final RateLimiter lastSyncAttributesAndOfferingsRateLimiter;
    private final Lazy lifecycleHandler$delegate;
    private final DefaultLocaleProvider localeProvider;
    private final Handler mainHandler;
    private final OfferingsManager offeringsManager;
    private final OfflineEntitlementsManager offlineEntitlementsManager;
    private final PaywallPresentedCache paywallPresentedCache;
    private final PostPendingTransactionsHelper postPendingTransactionsHelper;
    private final PostReceiptHelper postReceiptHelper;
    private final PostTransactionWithProductDetailsHelper postTransactionWithProductDetailsHelper;
    private final RateLimiter preferredLocaleOverrideRateLimiter;
    private final Function0<LifecycleOwner> processLifecycleOwnerProvider;
    private final PurchaseParamsValidator purchaseParamsValidator;
    private final PurchasesStateCache purchasesStateCache;
    private String storefrontCountryCode;
    private final SubscriberAttributesManager subscriberAttributesManager;
    private final SyncPurchasesHelper syncPurchasesHelper;
    private TrackedEventListener trackedEventListener;
    private final VirtualCurrencyManager virtualCurrencyManager;
    private final WebPurchaseRedemptionHelper webPurchaseRedemptionHelper;
    private final WorkflowManager workflowManager;
    public static final Companion Companion = new Companion(null);
    private static PlatformInfo platformInfo = new PlatformInfo(AnalyticsEvents.PARAMETER_SHARE_DIALOG_SHOW_NATIVE, null);

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void canMakePayments$default(Companion companion, Context context, List list, Callback callback, int i3, Object obj) {
            if ((i3 & 2) != 0) {
                list = CollectionsKt.emptyList();
            }
            companion.canMakePayments(context, list, callback);
        }

        public final void canMakePayments(Context context, List<? extends BillingFeature> features, Callback<Boolean> callback) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(features, "features");
            Intrinsics.checkNotNullParameter(callback, "callback");
            BillingClient billingClientA = BillingClient.h(context).b(PendingPurchasesParams.c().b().a()).c(new PurchasesUpdatedListener() { // from class: com.revenuecat.purchases.j
                @Override // com.android.billingclient.api.PurchasesUpdatedListener
                public final void onPurchasesUpdated(BillingResult billingResult, List list) {
                    Intrinsics.checkNotNullParameter(billingResult, "<anonymous parameter 0>");
                }
            }).a();
            billingClientA.l(new PurchasesOrchestrator$Companion$canMakePayments$2$1(new Handler(context.getMainLooper()), new AtomicBoolean(false), callback, billingClientA, features));
        }

        public final boolean getDebugLogsEnabled() {
            return LogUtilsKt.getDebugLogsEnabled(getLogLevel());
        }

        public final synchronized ImageLoader getImageLoader(final Context context) {
            ImageLoader imageLoaderB;
            Intrinsics.checkNotNullParameter(context, "context");
            imageLoaderB = PurchasesOrchestrator.cachedImageLoader;
            if (imageLoaderB == null) {
                final String str = "revenuecatui_cache";
                final long j3 = 26214400;
                imageLoaderB = new ImageLoader.Builder(context).d(new Function0<DiskCache>() { // from class: com.revenuecat.purchases.PurchasesOrchestrator$Companion$getImageLoader$imageLoader$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final DiskCache invoke() {
                        DiskCache.Builder builder = new DiskCache.Builder();
                        File cacheDir = context.getCacheDir();
                        Intrinsics.checkNotNullExpressionValue(cacheDir, "context.cacheDir");
                        return builder.b(FilesKt.t(cacheDir, str)).d(j3).a();
                    }
                }).b();
                PurchasesOrchestrator.cachedImageLoader = imageLoaderB;
            }
            return imageLoaderB;
        }

        public final synchronized LogHandler getLogHandler() {
            return LogWrapperKt.getCurrentLogHandler();
        }

        public final LogLevel getLogLevel() {
            return Config.INSTANCE.getLogLevel();
        }

        public final PlatformInfo getPlatformInfo() {
            return PurchasesOrchestrator.platformInfo;
        }

        public final URL getProxyURL() {
            return PurchasesOrchestrator.proxyURL;
        }

        public final void setDebugLogsEnabled(boolean z2) {
            setLogLevel(LogUtilsKt.debugLogsEnabled(LogLevel.Companion, z2));
        }

        public final synchronized void setLogHandler(LogHandler value) {
            Intrinsics.checkNotNullParameter(value, "value");
            LogWrapperKt.setCurrentLogHandler(value);
        }

        public final void setLogLevel(LogLevel value) {
            Intrinsics.checkNotNullParameter(value, "value");
            Config.INSTANCE.setLogLevel(value);
        }

        public final void setPlatformInfo(PlatformInfo platformInfo) {
            Intrinsics.checkNotNullParameter(platformInfo, "<set-?>");
            PurchasesOrchestrator.platformInfo = platformInfo;
        }

        public final void setProxyURL(URL url) {
            PurchasesOrchestrator.proxyURL = url;
        }

        private Companion() {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public PurchasesOrchestrator(Application application, String str, Backend backend, BillingAbstract billing, DeviceCache deviceCache, IdentityManager identityManager, SubscriberAttributesManager subscriberAttributesManager, AppConfig appConfig, CustomerInfoHelper customerInfoHelper, CustomerInfoUpdateHandler customerInfoUpdateHandler, DiagnosticsSynchronizer diagnosticsSynchronizer, DiagnosticsTracker diagnosticsTracker, DateProvider dateProvider, OfflineEntitlementsManager offlineEntitlementsManager, PostReceiptHelper postReceiptHelper, PostTransactionWithProductDetailsHelper postTransactionWithProductDetailsHelper, PostPendingTransactionsHelper postPendingTransactionsHelper, SyncPurchasesHelper syncPurchasesHelper, OfferingsManager offeringsManager, EventsManager eventsManager, EventsManager adEventsManager, PaywallPresentedCache paywallPresentedCache, PurchasesStateCache purchasesStateCache, Handler handler, Dispatcher dispatcher, PurchasesConfiguration initialConfiguration, FontLoader fontLoader, DefaultLocaleProvider localeProvider, WebPurchaseRedemptionHelper webPurchaseRedemptionHelper, VirtualCurrencyManager virtualCurrencyManager, PurchaseParamsValidator purchaseParamsValidator, WorkflowManager workflowManager, Function0<? extends LifecycleOwner> processLifecycleOwnerProvider, BlockstoreHelper blockstoreHelper, BackupManager backupManager, FileRepository fileRepository, AdTracker adTracker) {
        Intrinsics.checkNotNullParameter(application, "application");
        Intrinsics.checkNotNullParameter(backend, "backend");
        Intrinsics.checkNotNullParameter(billing, "billing");
        Intrinsics.checkNotNullParameter(deviceCache, "deviceCache");
        Intrinsics.checkNotNullParameter(identityManager, "identityManager");
        Intrinsics.checkNotNullParameter(subscriberAttributesManager, "subscriberAttributesManager");
        Intrinsics.checkNotNullParameter(appConfig, "appConfig");
        Intrinsics.checkNotNullParameter(customerInfoHelper, "customerInfoHelper");
        Intrinsics.checkNotNullParameter(customerInfoUpdateHandler, "customerInfoUpdateHandler");
        Intrinsics.checkNotNullParameter(dateProvider, "dateProvider");
        Intrinsics.checkNotNullParameter(offlineEntitlementsManager, "offlineEntitlementsManager");
        Intrinsics.checkNotNullParameter(postReceiptHelper, "postReceiptHelper");
        Intrinsics.checkNotNullParameter(postTransactionWithProductDetailsHelper, "postTransactionWithProductDetailsHelper");
        Intrinsics.checkNotNullParameter(postPendingTransactionsHelper, "postPendingTransactionsHelper");
        Intrinsics.checkNotNullParameter(syncPurchasesHelper, "syncPurchasesHelper");
        Intrinsics.checkNotNullParameter(offeringsManager, "offeringsManager");
        Intrinsics.checkNotNullParameter(eventsManager, "eventsManager");
        Intrinsics.checkNotNullParameter(adEventsManager, "adEventsManager");
        Intrinsics.checkNotNullParameter(paywallPresentedCache, "paywallPresentedCache");
        Intrinsics.checkNotNullParameter(purchasesStateCache, "purchasesStateCache");
        Intrinsics.checkNotNullParameter(dispatcher, "dispatcher");
        Intrinsics.checkNotNullParameter(initialConfiguration, "initialConfiguration");
        Intrinsics.checkNotNullParameter(fontLoader, "fontLoader");
        Intrinsics.checkNotNullParameter(localeProvider, "localeProvider");
        Intrinsics.checkNotNullParameter(webPurchaseRedemptionHelper, "webPurchaseRedemptionHelper");
        Intrinsics.checkNotNullParameter(virtualCurrencyManager, "virtualCurrencyManager");
        Intrinsics.checkNotNullParameter(purchaseParamsValidator, "purchaseParamsValidator");
        Intrinsics.checkNotNullParameter(workflowManager, "workflowManager");
        Intrinsics.checkNotNullParameter(processLifecycleOwnerProvider, "processLifecycleOwnerProvider");
        Intrinsics.checkNotNullParameter(blockstoreHelper, "blockstoreHelper");
        Intrinsics.checkNotNullParameter(backupManager, "backupManager");
        Intrinsics.checkNotNullParameter(fileRepository, "fileRepository");
        Intrinsics.checkNotNullParameter(adTracker, "adTracker");
        this.application = application;
        this.backend = backend;
        this.billing = billing;
        this.deviceCache = deviceCache;
        this.identityManager = identityManager;
        this.subscriberAttributesManager = subscriberAttributesManager;
        this.appConfig = appConfig;
        this.customerInfoHelper = customerInfoHelper;
        this.customerInfoUpdateHandler = customerInfoUpdateHandler;
        this.diagnosticsSynchronizer = diagnosticsSynchronizer;
        this.diagnosticsTrackerIfEnabled = diagnosticsTracker;
        this.dateProvider = dateProvider;
        this.offlineEntitlementsManager = offlineEntitlementsManager;
        this.postReceiptHelper = postReceiptHelper;
        this.postTransactionWithProductDetailsHelper = postTransactionWithProductDetailsHelper;
        this.postPendingTransactionsHelper = postPendingTransactionsHelper;
        this.syncPurchasesHelper = syncPurchasesHelper;
        this.offeringsManager = offeringsManager;
        this.eventsManager = eventsManager;
        this.adEventsManager = adEventsManager;
        this.paywallPresentedCache = paywallPresentedCache;
        this.purchasesStateCache = purchasesStateCache;
        this.mainHandler = handler;
        this.dispatcher = dispatcher;
        this.initialConfiguration = initialConfiguration;
        this.fontLoader = fontLoader;
        this.localeProvider = localeProvider;
        this.webPurchaseRedemptionHelper = webPurchaseRedemptionHelper;
        this.virtualCurrencyManager = virtualCurrencyManager;
        this.purchaseParamsValidator = purchaseParamsValidator;
        this.workflowManager = workflowManager;
        this.processLifecycleOwnerProvider = processLifecycleOwnerProvider;
        this.blockstoreHelper = blockstoreHelper;
        this.backupManager = backupManager;
        this.fileRepository = fileRepository;
        this.adTracker = adTracker;
        this.lifecycleHandler$delegate = LazyKt.b(new Function0<AppLifecycleHandler>() { // from class: com.revenuecat.purchases.PurchasesOrchestrator$lifecycleHandler$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final AppLifecycleHandler invoke() {
                return new AppLifecycleHandler(this.this$0);
            }
        });
        Duration.Companion companion = Duration.f140631b;
        DurationUnit durationUnit = DurationUnit.f140641f;
        this.lastSyncAttributesAndOfferingsRateLimiter = new RateLimiter(5, DurationKt.s(60, durationUnit), null);
        this.preferredLocaleOverrideRateLimiter = new RateLimiter(2, DurationKt.s(60, durationUnit), null);
        this._preferredUILocaleOverride = initialConfiguration.getPreferredUILocaleOverride();
        localeProvider.setPreferredLocaleOverride(this._preferredUILocaleOverride);
        identityManager.configure(str);
        billing.setStateListener(new BillingAbstract.StateListener() { // from class: com.revenuecat.purchases.PurchasesOrchestrator.2
            @Override // com.revenuecat.purchases.common.BillingAbstract.StateListener
            public void onConnected() {
                PostPendingTransactionsHelper.syncPendingPurchaseQueue$default(PurchasesOrchestrator.this.postPendingTransactionsHelper, PurchasesOrchestrator.this.getAllowSharingPlayStoreAccount(), null, 2, null);
                BillingAbstract billingAbstract = PurchasesOrchestrator.this.billing;
                final PurchasesOrchestrator purchasesOrchestrator = PurchasesOrchestrator.this;
                billingAbstract.getStorefront(new Function1<String, Unit>() { // from class: com.revenuecat.purchases.PurchasesOrchestrator$2$onConnected$1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        invoke((String) obj);
                        return Unit.f139807a;
                    }

                    public final void invoke(String countryCode) {
                        Intrinsics.checkNotNullParameter(countryCode, "countryCode");
                        purchasesOrchestrator.storefrontCountryCode = countryCode;
                        LogLevel logLevel = LogLevel.DEBUG;
                        LogHandler currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                            String str2 = "[Purchases] - " + logLevel.name();
                            String str3 = String.format(BillingStrings.BILLING_COUNTRY_CODE, Arrays.copyOf(new Object[]{countryCode}, 1));
                            Intrinsics.checkNotNullExpressionValue(str3, "format(...)");
                            currentLogHandler.d(str2, str3);
                        }
                    }
                }, new Function1<PurchasesError, Unit>() { // from class: com.revenuecat.purchases.PurchasesOrchestrator$2$onConnected$2
                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        invoke((PurchasesError) obj);
                        return Unit.f139807a;
                    }

                    public final void invoke(PurchasesError error) {
                        Intrinsics.checkNotNullParameter(error, "error");
                        LogUtilsKt.errorLog(error);
                    }
                });
            }
        });
        billing.setPurchasesUpdatedListener(getPurchasesUpdatedListener());
        BillingAbstract.startConnection$default(billing, 0L, 1, null);
        dispatch(new Function0<Unit>() { // from class: com.revenuecat.purchases.PurchasesOrchestrator.3
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Object invoke() {
                m448invoke();
                return Unit.f139807a;
            }

            /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
            public final void m448invoke() {
                ((LifecycleOwner) PurchasesOrchestrator.this.getProcessLifecycleOwnerProvider().invoke()).getLifecycle().addObserver(PurchasesOrchestrator.this.getLifecycleHandler());
                PurchasesOrchestrator.this.application.registerActivityLifecycleCallbacks(PurchasesOrchestrator.this);
            }
        });
        if (this.appConfig.getDangerousSettings().getAutoSyncPurchases()) {
            return;
        }
        final LogIntent logIntent = LogIntent.WARNING;
        Function0<String> function0 = new Function0<String>() { // from class: com.revenuecat.purchases.PurchasesOrchestrator$special$$inlined$log$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                return CollectionsKt.joinToString$default(logIntent.getEmojiList(), "", null, null, 0, null, null, 62, null) + ' ' + ConfigureStrings.AUTO_SYNC_PURCHASES_DISABLED;
            }
        };
        switch (LogWrapperKt.WhenMappings.$EnumSwitchMapping$0[logIntent.ordinal()]) {
            case 1:
                LogLevel logLevel = LogLevel.DEBUG;
                LogHandler currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                    currentLogHandler.d("[Purchases] - " + logLevel.name(), (String) function0.invoke());
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
                LogHandler currentLogHandler4 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel4) <= 0) {
                    currentLogHandler4.d("[Purchases] - " + logLevel4.name(), (String) function0.invoke());
                }
                break;
            case 6:
                LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) function0.invoke(), null);
                break;
            case 7:
                LogLevel logLevel5 = LogLevel.INFO;
                LogHandler currentLogHandler5 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel5) <= 0) {
                    currentLogHandler5.i("[Purchases] - " + logLevel5.name(), (String) function0.invoke());
                }
                break;
            case 8:
                LogLevel logLevel6 = LogLevel.DEBUG;
                LogHandler currentLogHandler6 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel6) <= 0) {
                    currentLogHandler6.d("[Purchases] - " + logLevel6.name(), (String) function0.invoke());
                }
                break;
            case 9:
                LogLevel logLevel7 = LogLevel.DEBUG;
                LogHandler currentLogHandler7 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel7) <= 0) {
                    currentLogHandler7.d("[Purchases] - " + logLevel7.name(), (String) function0.invoke());
                }
                break;
            case 10:
                LogLevel logLevel8 = LogLevel.WARN;
                LogHandler currentLogHandler8 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel8) <= 0) {
                    currentLogHandler8.w("[Purchases] - " + logLevel8.name(), (String) function0.invoke());
                }
                break;
            case 11:
                LogLevel logLevel9 = LogLevel.WARN;
                LogHandler currentLogHandler9 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel9) <= 0) {
                    currentLogHandler9.w("[Purchases] - " + logLevel9.name(), (String) function0.invoke());
                }
                break;
            case 12:
                LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) function0.invoke(), null);
                break;
            case 13:
                LogLevel logLevel10 = LogLevel.WARN;
                LogHandler currentLogHandler10 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel10) <= 0) {
                    currentLogHandler10.w("[Purchases] - " + logLevel10.name(), (String) function0.invoke());
                }
                break;
            case 14:
                LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) function0.invoke(), null);
                break;
        }
    }

    private final boolean clearInMemoryCacheAndFetchOfferingsWithRateLimit(final Function2<? super Offerings, ? super PurchasesError, Unit> function2) {
        if (this.preferredLocaleOverrideRateLimiter.shouldProceed()) {
            this.offeringsManager.clearInMemoryOfferingsCache();
            LogLevel logLevel = LogLevel.VERBOSE;
            LogHandler currentLogHandler = LogWrapperKt.getCurrentLogHandler();
            if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                currentLogHandler.v("[Purchases] - " + logLevel.name(), "Fetching fresh offerings");
            }
            getOfferings$default(this, new ReceiveOfferingsCallback() { // from class: com.revenuecat.purchases.PurchasesOrchestrator.clearInMemoryCacheAndFetchOfferingsWithRateLimit.2
                @Override // com.revenuecat.purchases.interfaces.ReceiveOfferingsCallback
                public void onError(PurchasesError error) {
                    Intrinsics.checkNotNullParameter(error, "error");
                    function2.invoke(null, error);
                }

                @Override // com.revenuecat.purchases.interfaces.ReceiveOfferingsCallback
                public void onReceived(Offerings offerings) {
                    Intrinsics.checkNotNullParameter(offerings, "offerings");
                    function2.invoke(offerings, null);
                }
            }, false, 2, null);
            return true;
        }
        LogLevel logLevel2 = LogLevel.DEBUG;
        LogHandler currentLogHandler2 = LogWrapperKt.getCurrentLogHandler();
        if (Config.INSTANCE.getLogLevel().compareTo(logLevel2) <= 0) {
            currentLogHandler2.d("[Purchases] - " + logLevel2.name(), "Fresh offerings fetch rate limit reached: " + this.preferredLocaleOverrideRateLimiter.getMaxCallsInPeriod() + " per " + Duration.s(this.preferredLocaleOverrideRateLimiter.m1244getPeriodSecondsUwyO8pc()) + " seconds. Fetch not triggered.");
        }
        return false;
    }

    private final PurchaseCallback createCallbackWithDiagnosticsIfNeeded(final PurchaseCallback purchaseCallback, final PurchasingData purchasingData, final Date date) {
        return this.diagnosticsTrackerIfEnabled == null ? purchaseCallback : new PurchaseCallback() { // from class: com.revenuecat.purchases.PurchasesOrchestrator.createCallbackWithDiagnosticsIfNeeded.1
            @Override // com.revenuecat.purchases.interfaces.PurchaseCallback
            public void onCompleted(StoreTransaction storeTransaction, CustomerInfo customerInfo) {
                Intrinsics.checkNotNullParameter(storeTransaction, "storeTransaction");
                Intrinsics.checkNotNullParameter(customerInfo, "customerInfo");
                PurchasesOrchestrator.this.trackPurchaseResultIfNeeded(purchasingData, null, date, customerInfo.getEntitlements().getVerification());
                purchaseCallback.onCompleted(storeTransaction, customerInfo);
            }

            @Override // com.revenuecat.purchases.interfaces.PurchaseErrorCallback
            public void onError(PurchasesError error, boolean z2) {
                Intrinsics.checkNotNullParameter(error, "error");
                PurchasesOrchestrator.this.trackPurchaseResultIfNeeded(purchasingData, error, date, null);
                purchaseCallback.onError(error, z2);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void dispatch(final Function0<Unit> function0) {
        if (Intrinsics.areEqual(Thread.currentThread(), Looper.getMainLooper().getThread())) {
            function0.invoke();
            return;
        }
        Handler handler = this.mainHandler;
        if (handler == null) {
            handler = new Handler(Looper.getMainLooper());
        }
        handler.post(new Runnable() { // from class: com.revenuecat.purchases.h
            @Override // java.lang.Runnable
            public final void run() {
                function0.invoke();
            }
        });
    }

    private final void enqueue(final Function0<Unit> function0) {
        this.dispatcher.enqueue(new Runnable() { // from class: com.revenuecat.purchases.i
            @Override // java.lang.Runnable
            public final void run() {
                function0.invoke();
            }
        }, Delay.NONE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void flushEvents(Delay delay) {
        if (this.appConfig.getUiPreviewMode()) {
            return;
        }
        this.eventsManager.flushEvents(delay);
        this.adEventsManager.flushEvents(delay);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List<PurchaseCallback> getAndClearAllPurchaseCallbacks() {
        List<PurchaseCallback> list;
        synchronized (this) {
            Map<String, PurchaseCallback> purchaseCallbacksByProductId = getState$purchases_defaultsBc8Release().getPurchaseCallbacksByProductId();
            PurchasesState state$purchases_defaultsBc8Release = getState$purchases_defaultsBc8Release();
            Map map = Collections.EMPTY_MAP;
            Intrinsics.checkNotNullExpressionValue(map, "emptyMap()");
            setState$purchases_defaultsBc8Release(PurchasesState.copy$default(state$purchases_defaultsBc8Release, null, map, null, false, false, 29, null));
            list = CollectionsKt.toList(purchaseCallbacksByProductId.values());
        }
        return list;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ProductChangeCallback getAndClearProductChangeCallback() {
        ProductChangeCallback deprecatedProductChangeCallback = getState$purchases_defaultsBc8Release().getDeprecatedProductChangeCallback();
        setState$purchases_defaultsBc8Release(PurchasesState.copy$default(getState$purchases_defaultsBc8Release(), null, null, null, false, false, 27, null));
        return deprecatedProductChangeCallback;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void getCustomerInfo(ReceiveCustomerInfoCallback receiveCustomerInfoCallback) {
        getCustomerInfo(CacheFetchPolicy.Companion.m413default(), false, receiveCustomerInfoCallback);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final AppLifecycleHandler getLifecycleHandler() {
        return (AppLifecycleHandler) this.lifecycleHandler$delegate.getValue();
    }

    public static /* synthetic */ void getOfferings$default(PurchasesOrchestrator purchasesOrchestrator, ReceiveOfferingsCallback receiveOfferingsCallback, boolean z2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z2 = false;
        }
        purchasesOrchestrator.getOfferings(receiveOfferingsCallback, z2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Pair<Function2<StoreTransaction, CustomerInfo, Unit>, Function2<StoreTransaction, PurchasesError, Unit>> getProductChangeCompletedCallbacks(final ProductChangeCallback productChangeCallback) {
        return new Pair<>(new Function2<StoreTransaction, CustomerInfo, Unit>() { // from class: com.revenuecat.purchases.PurchasesOrchestrator$getProductChangeCompletedCallbacks$onSuccess$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                invoke((StoreTransaction) obj, (CustomerInfo) obj2);
                return Unit.f139807a;
            }

            public final void invoke(final StoreTransaction storeTransaction, final CustomerInfo info) {
                Intrinsics.checkNotNullParameter(storeTransaction, "storeTransaction");
                Intrinsics.checkNotNullParameter(info, "info");
                final ProductChangeCallback productChangeCallback2 = productChangeCallback;
                if (productChangeCallback2 != null) {
                    this.dispatch(new Function0<Unit>() { // from class: com.revenuecat.purchases.PurchasesOrchestrator$getProductChangeCompletedCallbacks$onSuccess$1$1$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public /* bridge */ /* synthetic */ Object invoke() {
                            m451invoke();
                            return Unit.f139807a;
                        }

                        /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
                        public final void m451invoke() {
                            productChangeCallback2.onCompleted(storeTransaction, info);
                        }
                    });
                }
            }
        }, new Function2<StoreTransaction, PurchasesError, Unit>() { // from class: com.revenuecat.purchases.PurchasesOrchestrator$getProductChangeCompletedCallbacks$onError$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                invoke((StoreTransaction) obj, (PurchasesError) obj2);
                return Unit.f139807a;
            }

            public final void invoke(StoreTransaction storeTransaction, PurchasesError error) {
                Intrinsics.checkNotNullParameter(storeTransaction, "<anonymous parameter 0>");
                Intrinsics.checkNotNullParameter(error, "error");
                ProductChangeCallback productChangeCallback2 = productChangeCallback;
                if (productChangeCallback2 != null) {
                    this.dispatch(productChangeCallback2, error);
                }
            }
        });
    }

    public static /* synthetic */ void getProducts$default(PurchasesOrchestrator purchasesOrchestrator, List list, ProductType productType, GetStoreProductsCallback getStoreProductsCallback, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            productType = null;
        }
        purchasesOrchestrator.getProducts(list, productType, getStoreProductsCallback);
    }

    static /* synthetic */ void getProductsOfTypes$default(PurchasesOrchestrator purchasesOrchestrator, Set set, Set set2, List list, Date date, GetStoreProductsCallback getStoreProductsCallback, int i3, Object obj) {
        if ((i3 & 8) != 0) {
            date = null;
        }
        purchasesOrchestrator.getProductsOfTypes(set, set2, list, date, getStoreProductsCallback);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final PurchaseCallback getPurchaseCallback(String str) {
        PurchaseCallback purchaseCallback = getState$purchases_defaultsBc8Release().getPurchaseCallbacksByProductId().get(str);
        PurchasesState state$purchases_defaultsBc8Release = getState$purchases_defaultsBc8Release();
        Map<String, PurchaseCallback> purchaseCallbacksByProductId = getState$purchases_defaultsBc8Release().getPurchaseCallbacksByProductId();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry<String, PurchaseCallback> entry : purchaseCallbacksByProductId.entrySet()) {
            if (!Intrinsics.areEqual(entry.getKey(), str)) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
        }
        setState$purchases_defaultsBc8Release(PurchasesState.copy$default(state$purchases_defaultsBc8Release, null, linkedHashMap, null, false, false, 29, null));
        return purchaseCallback;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Pair<Function2<StoreTransaction, CustomerInfo, Unit>, Function2<StoreTransaction, PurchasesError, Unit>> getPurchaseCompletedCallbacks() {
        return new Pair<>(new Function2<StoreTransaction, CustomerInfo, Unit>() { // from class: com.revenuecat.purchases.PurchasesOrchestrator$getPurchaseCompletedCallbacks$onSuccess$1
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                invoke((StoreTransaction) obj, (CustomerInfo) obj2);
                return Unit.f139807a;
            }

            public final void invoke(final StoreTransaction storeTransaction, final CustomerInfo info) {
                Intrinsics.checkNotNullParameter(storeTransaction, "storeTransaction");
                Intrinsics.checkNotNullParameter(info, "info");
                this.this$0.backupManager.dataChanged();
                BlockstoreHelper blockstoreHelper = this.this$0.blockstoreHelper;
                final PurchasesOrchestrator purchasesOrchestrator = this.this$0;
                blockstoreHelper.aliasCurrentAndStoredUserIdsIfNeeded(new Function0<Unit>() { // from class: com.revenuecat.purchases.PurchasesOrchestrator$getPurchaseCompletedCallbacks$onSuccess$1.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Object invoke() {
                        m454invoke();
                        return Unit.f139807a;
                    }

                    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
                    public final void m454invoke() {
                        purchasesOrchestrator.blockstoreHelper.storeUserIdIfNeeded(info);
                        final PurchaseCallback purchaseCallback = purchasesOrchestrator.getPurchaseCallback(storeTransaction.getProductIds().get(0));
                        if (purchaseCallback != null) {
                            PurchasesOrchestrator purchasesOrchestrator2 = purchasesOrchestrator;
                            final StoreTransaction storeTransaction2 = storeTransaction;
                            final CustomerInfo customerInfo = info;
                            purchasesOrchestrator2.dispatch(new Function0<Unit>() { // from class: com.revenuecat.purchases.PurchasesOrchestrator$getPurchaseCompletedCallbacks$onSuccess$1$1$1$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(0);
                                }

                                @Override // kotlin.jvm.functions.Function0
                                public /* bridge */ /* synthetic */ Object invoke() {
                                    m455invoke();
                                    return Unit.f139807a;
                                }

                                /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
                                public final void m455invoke() {
                                    purchaseCallback.onCompleted(storeTransaction2, customerInfo);
                                }
                            });
                        }
                    }
                });
            }
        }, new Function2<StoreTransaction, PurchasesError, Unit>() { // from class: com.revenuecat.purchases.PurchasesOrchestrator$getPurchaseCompletedCallbacks$onError$1
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                invoke((StoreTransaction) obj, (PurchasesError) obj2);
                return Unit.f139807a;
            }

            public final void invoke(StoreTransaction purchase, PurchasesError error) {
                Intrinsics.checkNotNullParameter(purchase, "purchase");
                Intrinsics.checkNotNullParameter(error, "error");
                PurchaseCallback purchaseCallback = this.this$0.getPurchaseCallback(purchase.getProductIds().get(0));
                if (purchaseCallback != null) {
                    this.this$0.dispatch(purchaseCallback, error);
                }
            }
        });
    }

    private final BillingAbstract.PurchasesUpdatedListener getPurchasesUpdatedListener() {
        return new BillingAbstract.PurchasesUpdatedListener() { // from class: com.revenuecat.purchases.PurchasesOrchestrator.getPurchasesUpdatedListener.1
            @Override // com.revenuecat.purchases.common.BillingAbstract.PurchasesUpdatedListener
            public void onPurchasesFailedToUpdate(PurchasesError purchasesError) {
                Unit unit;
                Intrinsics.checkNotNullParameter(purchasesError, "purchasesError");
                PurchasesOrchestrator purchasesOrchestrator = PurchasesOrchestrator.this;
                synchronized (purchasesOrchestrator) {
                    try {
                        ProductChangeCallback andClearProductChangeCallback = purchasesOrchestrator.getAndClearProductChangeCallback();
                        if (andClearProductChangeCallback != null) {
                            purchasesOrchestrator.dispatch(andClearProductChangeCallback, purchasesError);
                            unit = Unit.f139807a;
                        } else {
                            unit = null;
                        }
                        if (unit == null) {
                            Iterator it = purchasesOrchestrator.getAndClearAllPurchaseCallbacks().iterator();
                            while (it.hasNext()) {
                                purchasesOrchestrator.dispatch((PurchaseCallback) it.next(), purchasesError);
                            }
                        }
                        Unit unit2 = Unit.f139807a;
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }

            @Override // com.revenuecat.purchases.common.BillingAbstract.PurchasesUpdatedListener
            public void onPurchasesUpdated(List<StoreTransaction> purchases) {
                boolean z2;
                Pair productChangeCompletedCallbacks;
                Intrinsics.checkNotNullParameter(purchases, "purchases");
                PurchasesOrchestrator purchasesOrchestrator = PurchasesOrchestrator.this;
                synchronized (purchasesOrchestrator) {
                    try {
                        List<StoreTransaction> list = purchases;
                        boolean z3 = true;
                        if (!(list instanceof Collection) || !list.isEmpty()) {
                            Iterator<T> it = list.iterator();
                            loop0: while (it.hasNext()) {
                                List<String> productIds = ((StoreTransaction) it.next()).getProductIds();
                                if (!(productIds instanceof Collection) || !productIds.isEmpty()) {
                                    Iterator<T> it2 = productIds.iterator();
                                    while (it2.hasNext()) {
                                        if (purchasesOrchestrator.getState$purchases_defaultsBc8Release().getPurchaseCallbacksByProductId().containsKey((String) it2.next())) {
                                            break;
                                        }
                                    }
                                }
                                z3 = false;
                            }
                        }
                        z2 = z3;
                        productChangeCompletedCallbacks = purchasesOrchestrator.getState$purchases_defaultsBc8Release().getDeprecatedProductChangeCallback() != null ? purchasesOrchestrator.getProductChangeCompletedCallbacks(purchasesOrchestrator.getAndClearProductChangeCallback()) : purchasesOrchestrator.getPurchaseCompletedCallbacks();
                        Unit unit = Unit.f139807a;
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                PurchasesOrchestrator.this.postTransactionWithProductDetailsHelper.postTransactions(purchases, PurchasesOrchestrator.this.getAllowSharingPlayStoreAccount(), PurchasesOrchestrator.this.getAppUserID(), PostReceiptInitiationSource.PURCHASE, z2, (Function2) productChangeCompletedCallbacks.first, (Function2) productChangeCompletedCallbacks.second);
                PurchasesOrchestrator.this.flushEvents(Delay.NONE);
            }
        };
    }

    public static /* synthetic */ void logIn$default(PurchasesOrchestrator purchasesOrchestrator, String str, LogInCallback logInCallback, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            logInCallback = null;
        }
        purchasesOrchestrator.logIn(str, logInCallback);
    }

    public static /* synthetic */ void logOut$default(PurchasesOrchestrator purchasesOrchestrator, ReceiveCustomerInfoCallback receiveCustomerInfoCallback, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            receiveCustomerInfoCallback = null;
        }
        purchasesOrchestrator.logOut(receiveCustomerInfoCallback);
    }

    private final void replaceOldPurchaseWithNewProduct(final PurchasingData purchasingData, String str, final StoreReplacementMode storeReplacementMode, final Activity activity, final String str2, final PresentedOfferingContext presentedOfferingContext, final Boolean bool, final PurchaseErrorCallback purchaseErrorCallback) {
        ProductType productType = purchasingData.getProductType();
        ProductType productType2 = ProductType.SUBS;
        if (productType != productType2) {
            PurchasesError purchasesError = new PurchasesError(PurchasesErrorCode.PurchaseNotAllowedError, PurchaseStrings.UPGRADING_INVALID_TYPE);
            LogUtilsKt.errorLog(purchasesError);
            ProductChangeCallback andClearProductChangeCallback = getAndClearProductChangeCallback();
            if (andClearProductChangeCallback != null) {
                dispatch(andClearProductChangeCallback, purchasesError);
            }
            Iterator<T> it = getAndClearAllPurchaseCallbacks().iterator();
            while (it.hasNext()) {
                dispatch((PurchaseCallback) it.next(), purchasesError);
            }
            return;
        }
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.f140144a = str;
        if (StringsKt.a0(str, Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR, false, 2, null)) {
            objectRef.f140144a = StringsKt.n1(str, Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR, null, 2, null);
            LogLevel logLevel = LogLevel.WARN;
            LogHandler currentLogHandler = LogWrapperKt.getCurrentLogHandler();
            if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                currentLogHandler.w("[Purchases] - " + logLevel.name(), "Using incorrect oldProductId: " + str + ". The productId should not contain the basePlanId. Using productId: " + ((String) objectRef.f140144a) + '.');
            }
        }
        this.billing.findPurchaseInPurchaseHistory(str2, productType2, (String) objectRef.f140144a, new Function1<StoreTransaction, Unit>() { // from class: com.revenuecat.purchases.PurchasesOrchestrator.replaceOldPurchaseWithNewProduct.3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((StoreTransaction) obj);
                return Unit.f139807a;
            }

            public final void invoke(StoreTransaction purchaseRecord) {
                LogHandler currentLogHandler2;
                String str3;
                String str4;
                Intrinsics.checkNotNullParameter(purchaseRecord, "purchaseRecord");
                final LogIntent logIntent = LogIntent.PURCHASE;
                final Ref.ObjectRef<String> objectRef2 = objectRef;
                Function0<String> function0 = new Function0<String>() { // from class: com.revenuecat.purchases.PurchasesOrchestrator$replaceOldPurchaseWithNewProduct$3$invoke$$inlined$log$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final String invoke() {
                        StringBuilder sb = new StringBuilder();
                        sb.append(CollectionsKt.joinToString$default(logIntent.getEmojiList(), "", null, null, 0, null, null, 62, null));
                        sb.append(' ');
                        String str5 = String.format(PurchaseStrings.FOUND_EXISTING_PURCHASE, Arrays.copyOf(new Object[]{objectRef2.f140144a}, 1));
                        Intrinsics.checkNotNullExpressionValue(str5, "format(...)");
                        sb.append(str5);
                        return sb.toString();
                    }
                };
                switch (LogWrapperKt.WhenMappings.$EnumSwitchMapping$0[logIntent.ordinal()]) {
                    case 1:
                        LogLevel logLevel2 = LogLevel.DEBUG;
                        currentLogHandler2 = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel2) <= 0) {
                            str3 = "[Purchases] - " + logLevel2.name();
                            str4 = (String) function0.invoke();
                            currentLogHandler2.d(str3, str4);
                        }
                        break;
                    case 2:
                        LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) function0.invoke(), null);
                        break;
                    case 3:
                        LogLevel logLevel3 = LogLevel.WARN;
                        LogHandler currentLogHandler3 = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel3) <= 0) {
                            currentLogHandler3.w("[Purchases] - " + logLevel3.name(), (String) function0.invoke());
                        }
                        break;
                    case 4:
                        LogLevel logLevel4 = LogLevel.INFO;
                        LogHandler currentLogHandler4 = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel4) <= 0) {
                            currentLogHandler4.i("[Purchases] - " + logLevel4.name(), (String) function0.invoke());
                        }
                        break;
                    case 5:
                        LogLevel logLevel5 = LogLevel.DEBUG;
                        currentLogHandler2 = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel5) <= 0) {
                            str3 = "[Purchases] - " + logLevel5.name();
                            str4 = (String) function0.invoke();
                            currentLogHandler2.d(str3, str4);
                        }
                        break;
                    case 6:
                        LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) function0.invoke(), null);
                        break;
                    case 7:
                        LogLevel logLevel6 = LogLevel.INFO;
                        LogHandler currentLogHandler5 = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel6) <= 0) {
                            currentLogHandler5.i("[Purchases] - " + logLevel6.name(), (String) function0.invoke());
                        }
                        break;
                    case 8:
                        LogLevel logLevel7 = LogLevel.DEBUG;
                        currentLogHandler2 = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel7) <= 0) {
                            str3 = "[Purchases] - " + logLevel7.name();
                            str4 = (String) function0.invoke();
                            currentLogHandler2.d(str3, str4);
                        }
                        break;
                    case 9:
                        LogLevel logLevel8 = LogLevel.DEBUG;
                        currentLogHandler2 = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel8) <= 0) {
                            str3 = "[Purchases] - " + logLevel8.name();
                            str4 = (String) function0.invoke();
                            currentLogHandler2.d(str3, str4);
                        }
                        break;
                    case 10:
                        LogLevel logLevel9 = LogLevel.WARN;
                        LogHandler currentLogHandler6 = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel9) <= 0) {
                            currentLogHandler6.w("[Purchases] - " + logLevel9.name(), (String) function0.invoke());
                        }
                        break;
                    case 11:
                        LogLevel logLevel10 = LogLevel.WARN;
                        LogHandler currentLogHandler7 = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel10) <= 0) {
                            currentLogHandler7.w("[Purchases] - " + logLevel10.name(), (String) function0.invoke());
                        }
                        break;
                    case 12:
                        LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) function0.invoke(), null);
                        break;
                    case 13:
                        LogLevel logLevel11 = LogLevel.WARN;
                        LogHandler currentLogHandler8 = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel11) <= 0) {
                            currentLogHandler8.w("[Purchases] - " + logLevel11.name(), (String) function0.invoke());
                        }
                        break;
                    case 14:
                        LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) function0.invoke(), null);
                        break;
                }
                PurchasesOrchestrator.this.billing.makePurchaseAsync(activity, str2, purchasingData, new ReplaceProductInfo(purchaseRecord, storeReplacementMode), presentedOfferingContext, bool);
            }
        }, new Function1<PurchasesError, Unit>() { // from class: com.revenuecat.purchases.PurchasesOrchestrator.replaceOldPurchaseWithNewProduct.4
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((PurchasesError) obj);
                return Unit.f139807a;
            }

            public final void invoke(final PurchasesError error) {
                LogHandler currentLogHandler2;
                String str3;
                String str4;
                Intrinsics.checkNotNullParameter(error, "error");
                final LogIntent logIntent = LogIntent.GOOGLE_ERROR;
                Function0<String> function0 = new Function0<String>() { // from class: com.revenuecat.purchases.PurchasesOrchestrator$replaceOldPurchaseWithNewProduct$4$invoke$$inlined$log$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final String invoke() {
                        return CollectionsKt.joinToString$default(logIntent.getEmojiList(), "", null, null, 0, null, null, 62, null) + ' ' + error.toString();
                    }
                };
                switch (LogWrapperKt.WhenMappings.$EnumSwitchMapping$0[logIntent.ordinal()]) {
                    case 1:
                        LogLevel logLevel2 = LogLevel.DEBUG;
                        currentLogHandler2 = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel2) <= 0) {
                            str3 = "[Purchases] - " + logLevel2.name();
                            str4 = (String) function0.invoke();
                            currentLogHandler2.d(str3, str4);
                        }
                        break;
                    case 2:
                        LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) function0.invoke(), null);
                        break;
                    case 3:
                        LogLevel logLevel3 = LogLevel.WARN;
                        LogHandler currentLogHandler3 = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel3) <= 0) {
                            currentLogHandler3.w("[Purchases] - " + logLevel3.name(), (String) function0.invoke());
                        }
                        break;
                    case 4:
                        LogLevel logLevel4 = LogLevel.INFO;
                        LogHandler currentLogHandler4 = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel4) <= 0) {
                            currentLogHandler4.i("[Purchases] - " + logLevel4.name(), (String) function0.invoke());
                        }
                        break;
                    case 5:
                        LogLevel logLevel5 = LogLevel.DEBUG;
                        currentLogHandler2 = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel5) <= 0) {
                            str3 = "[Purchases] - " + logLevel5.name();
                            str4 = (String) function0.invoke();
                            currentLogHandler2.d(str3, str4);
                        }
                        break;
                    case 6:
                        LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) function0.invoke(), null);
                        break;
                    case 7:
                        LogLevel logLevel6 = LogLevel.INFO;
                        LogHandler currentLogHandler5 = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel6) <= 0) {
                            currentLogHandler5.i("[Purchases] - " + logLevel6.name(), (String) function0.invoke());
                        }
                        break;
                    case 8:
                        LogLevel logLevel7 = LogLevel.DEBUG;
                        currentLogHandler2 = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel7) <= 0) {
                            str3 = "[Purchases] - " + logLevel7.name();
                            str4 = (String) function0.invoke();
                            currentLogHandler2.d(str3, str4);
                        }
                        break;
                    case 9:
                        LogLevel logLevel8 = LogLevel.DEBUG;
                        currentLogHandler2 = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel8) <= 0) {
                            str3 = "[Purchases] - " + logLevel8.name();
                            str4 = (String) function0.invoke();
                            currentLogHandler2.d(str3, str4);
                        }
                        break;
                    case 10:
                        LogLevel logLevel9 = LogLevel.WARN;
                        LogHandler currentLogHandler6 = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel9) <= 0) {
                            currentLogHandler6.w("[Purchases] - " + logLevel9.name(), (String) function0.invoke());
                        }
                        break;
                    case 11:
                        LogLevel logLevel10 = LogLevel.WARN;
                        LogHandler currentLogHandler7 = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel10) <= 0) {
                            currentLogHandler7.w("[Purchases] - " + logLevel10.name(), (String) function0.invoke());
                        }
                        break;
                    case 12:
                        LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) function0.invoke(), null);
                        break;
                    case 13:
                        LogLevel logLevel11 = LogLevel.WARN;
                        LogHandler currentLogHandler8 = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel11) <= 0) {
                            currentLogHandler8.w("[Purchases] - " + logLevel11.name(), (String) function0.invoke());
                        }
                        break;
                    case 14:
                        LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) function0.invoke(), null);
                        break;
                }
                PurchasesOrchestrator.this.getAndClearProductChangeCallback();
                PurchasesOrchestrator.this.getAndClearAllPurchaseCallbacks();
                PurchasesOrchestrator.this.dispatch(purchaseErrorCallback, error);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean shouldRefreshCustomerInfo(boolean z2) {
        return !this.appConfig.getCustomEntitlementComputation() && (z2 || this.deviceCache.isCustomerInfoCacheStale$purchases_defaultsBc8Release(getAppUserID(), false));
    }

    private final void startProductChange(Activity activity, final PurchasingData purchasingData, final PresentedOfferingContext presentedOfferingContext, final String str, final StoreReplacementMode storeReplacementMode, Boolean bool, PurchaseCallback purchaseCallback) {
        StoreReplacementMode storeReplacementMode2;
        String currentAppUserID;
        Unit unit;
        String productId;
        LogHandler currentLogHandler;
        String str2;
        String str3;
        LogHandler currentLogHandler2;
        String str4;
        String str5;
        List addOnProducts;
        trackPurchaseStarted(purchasingData.getProductId(), purchasingData.getProductType());
        PurchaseCallback purchaseCallbackCreateCallbackWithDiagnosticsIfNeeded = createCallbackWithDiagnosticsIfNeeded(purchaseCallback, purchasingData, this.dateProvider.getNow());
        if (purchasingData.getProductType() != ProductType.SUBS) {
            PurchasesError purchasesError = new PurchasesError(PurchasesErrorCode.PurchaseNotAllowedError, PurchaseStrings.UPGRADING_INVALID_TYPE);
            LogUtilsKt.errorLog(purchasesError);
            dispatch(purchaseCallbackCreateCallbackWithDiagnosticsIfNeeded, purchasesError);
            return;
        }
        if ((purchasingData instanceof GooglePurchasingData.Subscription) && (addOnProducts = ((GooglePurchasingData.Subscription) purchasingData).getAddOnProducts()) != null && (!addOnProducts.isEmpty()) && getStore() != Store.PLAY_STORE) {
            PurchasesError purchasesError2 = new PurchasesError(PurchasesErrorCode.PurchaseInvalidError, PurchaseStrings.PURCHASING_ADD_ONS_ONLY_SUPPORTED_ON_PLAY_STORE);
            LogUtilsKt.errorLog(purchasesError2);
            dispatch(purchaseCallbackCreateCallbackWithDiagnosticsIfNeeded, purchasesError2);
            return;
        }
        final LogIntent logIntent = LogIntent.PURCHASE;
        Function0<String> function0 = new Function0<String>() { // from class: com.revenuecat.purchases.PurchasesOrchestrator$startProductChange$$inlined$log$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                String str6;
                String offeringIdentifier;
                StringBuilder sb = new StringBuilder();
                sb.append(CollectionsKt.joinToString$default(logIntent.getEmojiList(), "", null, null, 0, null, null, 62, null));
                sb.append(' ');
                StringBuilder sb2 = new StringBuilder();
                sb2.append(' ');
                sb2.append(purchasingData);
                sb2.append(' ');
                PresentedOfferingContext presentedOfferingContext2 = presentedOfferingContext;
                if (presentedOfferingContext2 == null || (offeringIdentifier = presentedOfferingContext2.getOfferingIdentifier()) == null) {
                    str6 = null;
                } else {
                    str6 = PurchaseStrings.OFFERING + offeringIdentifier;
                }
                sb2.append(str6);
                sb2.append(" oldProductId: ");
                sb2.append(str);
                sb2.append(" replacementMode ");
                sb2.append(storeReplacementMode);
                String str7 = String.format(PurchaseStrings.PRODUCT_CHANGE_STARTED, Arrays.copyOf(new Object[]{sb2.toString()}, 1));
                Intrinsics.checkNotNullExpressionValue(str7, "format(...)");
                sb.append(str7);
                return sb.toString();
            }
        };
        int[] iArr = LogWrapperKt.WhenMappings.$EnumSwitchMapping$0;
        switch (iArr[logIntent.ordinal()]) {
            case 1:
                LogLevel logLevel = LogLevel.DEBUG;
                currentLogHandler2 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                    str4 = "[Purchases] - " + logLevel.name();
                    str5 = (String) function0.invoke();
                    currentLogHandler2.d(str4, str5);
                }
                break;
            case 2:
                LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) function0.invoke(), null);
                break;
            case 3:
                LogLevel logLevel2 = LogLevel.WARN;
                LogHandler currentLogHandler3 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel2) <= 0) {
                    currentLogHandler3.w("[Purchases] - " + logLevel2.name(), (String) function0.invoke());
                }
                break;
            case 4:
                LogLevel logLevel3 = LogLevel.INFO;
                LogHandler currentLogHandler4 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel3) <= 0) {
                    currentLogHandler4.i("[Purchases] - " + logLevel3.name(), (String) function0.invoke());
                }
                break;
            case 5:
                LogLevel logLevel4 = LogLevel.DEBUG;
                currentLogHandler2 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel4) <= 0) {
                    str4 = "[Purchases] - " + logLevel4.name();
                    str5 = (String) function0.invoke();
                    currentLogHandler2.d(str4, str5);
                }
                break;
            case 6:
                LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) function0.invoke(), null);
                break;
            case 7:
                LogLevel logLevel5 = LogLevel.INFO;
                LogHandler currentLogHandler5 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel5) <= 0) {
                    currentLogHandler5.i("[Purchases] - " + logLevel5.name(), (String) function0.invoke());
                }
                break;
            case 8:
                LogLevel logLevel6 = LogLevel.DEBUG;
                currentLogHandler2 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel6) <= 0) {
                    str4 = "[Purchases] - " + logLevel6.name();
                    str5 = (String) function0.invoke();
                    currentLogHandler2.d(str4, str5);
                }
                break;
            case 9:
                LogLevel logLevel7 = LogLevel.DEBUG;
                currentLogHandler2 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel7) <= 0) {
                    str4 = "[Purchases] - " + logLevel7.name();
                    str5 = (String) function0.invoke();
                    currentLogHandler2.d(str4, str5);
                }
                break;
            case 10:
                LogLevel logLevel8 = LogLevel.WARN;
                LogHandler currentLogHandler6 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel8) <= 0) {
                    currentLogHandler6.w("[Purchases] - " + logLevel8.name(), (String) function0.invoke());
                }
                break;
            case 11:
                LogLevel logLevel9 = LogLevel.WARN;
                LogHandler currentLogHandler7 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel9) <= 0) {
                    currentLogHandler7.w("[Purchases] - " + logLevel9.name(), (String) function0.invoke());
                }
                break;
            case 12:
                LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) function0.invoke(), null);
                break;
            case 13:
                LogLevel logLevel10 = LogLevel.WARN;
                LogHandler currentLogHandler8 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel10) <= 0) {
                    currentLogHandler8.w("[Purchases] - " + logLevel10.name(), (String) function0.invoke());
                }
                break;
            case 14:
                LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) function0.invoke(), null);
                break;
        }
        synchronized (this) {
            try {
                if (!this.appConfig.getFinishTransactions()) {
                    final LogIntent logIntent2 = LogIntent.WARNING;
                    Function0<String> function02 = new Function0<String>() { // from class: com.revenuecat.purchases.PurchasesOrchestrator$startProductChange$lambda$95$$inlined$log$1
                        {
                            super(0);
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public final String invoke() {
                            return CollectionsKt.joinToString$default(logIntent2.getEmojiList(), "", null, null, 0, null, null, 62, null) + ' ' + PurchaseStrings.PURCHASE_FINISH_TRANSACTION_FALSE;
                        }
                    };
                    switch (iArr[logIntent2.ordinal()]) {
                        case 1:
                            LogLevel logLevel11 = LogLevel.DEBUG;
                            currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                            if (Config.INSTANCE.getLogLevel().compareTo(logLevel11) <= 0) {
                                str2 = "[Purchases] - " + logLevel11.name();
                                str3 = (String) function02.invoke();
                                currentLogHandler.d(str2, str3);
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
                            currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                            if (Config.INSTANCE.getLogLevel().compareTo(logLevel14) <= 0) {
                                str2 = "[Purchases] - " + logLevel14.name();
                                str3 = (String) function02.invoke();
                                currentLogHandler.d(str2, str3);
                            }
                            break;
                        case 6:
                            LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) function02.invoke(), null);
                            break;
                        case 7:
                            LogLevel logLevel15 = LogLevel.INFO;
                            LogHandler currentLogHandler11 = LogWrapperKt.getCurrentLogHandler();
                            if (Config.INSTANCE.getLogLevel().compareTo(logLevel15) <= 0) {
                                currentLogHandler11.i("[Purchases] - " + logLevel15.name(), (String) function02.invoke());
                            }
                            break;
                        case 8:
                            LogLevel logLevel16 = LogLevel.DEBUG;
                            currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                            if (Config.INSTANCE.getLogLevel().compareTo(logLevel16) <= 0) {
                                str2 = "[Purchases] - " + logLevel16.name();
                                str3 = (String) function02.invoke();
                                currentLogHandler.d(str2, str3);
                            }
                            break;
                        case 9:
                            LogLevel logLevel17 = LogLevel.DEBUG;
                            currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                            if (Config.INSTANCE.getLogLevel().compareTo(logLevel17) <= 0) {
                                str2 = "[Purchases] - " + logLevel17.name();
                                str3 = (String) function02.invoke();
                                currentLogHandler.d(str2, str3);
                            }
                            break;
                        case 10:
                            LogLevel logLevel18 = LogLevel.WARN;
                            LogHandler currentLogHandler12 = LogWrapperKt.getCurrentLogHandler();
                            if (Config.INSTANCE.getLogLevel().compareTo(logLevel18) <= 0) {
                                currentLogHandler12.w("[Purchases] - " + logLevel18.name(), (String) function02.invoke());
                            }
                            break;
                        case 11:
                            LogLevel logLevel19 = LogLevel.WARN;
                            LogHandler currentLogHandler13 = LogWrapperKt.getCurrentLogHandler();
                            if (Config.INSTANCE.getLogLevel().compareTo(logLevel19) <= 0) {
                                currentLogHandler13.w("[Purchases] - " + logLevel19.name(), (String) function02.invoke());
                            }
                            break;
                        case 12:
                            LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) function02.invoke(), null);
                            break;
                        case 13:
                            LogLevel logLevel20 = LogLevel.WARN;
                            LogHandler currentLogHandler14 = LogWrapperKt.getCurrentLogHandler();
                            if (Config.INSTANCE.getLogLevel().compareTo(logLevel20) <= 0) {
                                currentLogHandler14.w("[Purchases] - " + logLevel20.name(), (String) function02.invoke());
                            }
                            break;
                        case 14:
                            LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) function02.invoke(), null);
                            break;
                    }
                }
                if (getState$purchases_defaultsBc8Release().getPurchaseCallbacksByProductId().containsKey(purchasingData.getProductId())) {
                    storeReplacementMode2 = storeReplacementMode;
                    currentAppUserID = null;
                } else {
                    storeReplacementMode2 = storeReplacementMode;
                    if (Intrinsics.areEqual(storeReplacementMode2, StoreReplacementMode.DEFERRED) && getStore() == Store.PLAY_STORE) {
                        if (StringsKt.a0(str, Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR, false, 2, null)) {
                            LogLevel logLevel21 = LogLevel.WARN;
                            LogHandler currentLogHandler15 = LogWrapperKt.getCurrentLogHandler();
                            if (Config.INSTANCE.getLogLevel().compareTo(logLevel21) <= 0) {
                                String str6 = "[Purchases] - " + logLevel21.name();
                                String str7 = String.format(PurchaseStrings.DEFERRED_PRODUCT_CHANGE_WITH_BASE_PLAN_ID, Arrays.copyOf(new Object[]{str}, 1));
                                Intrinsics.checkNotNullExpressionValue(str7, "format(...)");
                                currentLogHandler15.w(str6, str7);
                            }
                        }
                        productId = StringsKt.n1(str, Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR, null, 2, null);
                    } else {
                        productId = purchasingData.getProductId();
                    }
                    setState$purchases_defaultsBc8Release(PurchasesState.copy$default(getState$purchases_defaultsBc8Release(), null, MapsKt.plus(getState$purchases_defaultsBc8Release().getPurchaseCallbacksByProductId(), MapsKt.mapOf(TuplesKt.a(productId, purchaseCallbackCreateCallbackWithDiagnosticsIfNeeded))), null, false, false, 29, null));
                    currentAppUserID = this.identityManager.getCurrentAppUserID();
                }
                Unit unit2 = Unit.f139807a;
            } catch (Throwable th) {
                throw th;
            }
        }
        if (currentAppUserID != null) {
            replaceOldPurchaseWithNewProduct(purchasingData, str, storeReplacementMode2, activity, currentAppUserID, presentedOfferingContext, bool, purchaseCallbackCreateCallbackWithDiagnosticsIfNeeded);
            unit = Unit.f139807a;
        } else {
            unit = null;
        }
        if (unit == null) {
            PurchasesError purchasesError3 = new PurchasesError(PurchasesErrorCode.OperationAlreadyInProgressError, null, 2, null);
            LogUtilsKt.errorLog(purchasesError3);
            Iterator<T> it = getAndClearAllPurchaseCallbacks().iterator();
            while (it.hasNext()) {
                dispatch((PurchaseCallback) it.next(), purchasesError3);
            }
            Unit unit3 = Unit.f139807a;
        }
    }

    private final void startPurchase(Activity activity, final PurchasingData purchasingData, final PresentedOfferingContext presentedOfferingContext, Boolean bool, PurchaseCallback purchaseCallback) {
        String currentAppUserID;
        Unit unit;
        LogHandler currentLogHandler;
        String str;
        String str2;
        List addOnProducts;
        LogHandler currentLogHandler2;
        String str3;
        String str4;
        final LogIntent logIntent = LogIntent.PURCHASE;
        Function0<String> function0 = new Function0<String>() { // from class: com.revenuecat.purchases.PurchasesOrchestrator$startPurchase$$inlined$log$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                String str5;
                String offeringIdentifier;
                StringBuilder sb = new StringBuilder();
                sb.append(CollectionsKt.joinToString$default(logIntent.getEmojiList(), "", null, null, 0, null, null, 62, null));
                sb.append(' ');
                StringBuilder sb2 = new StringBuilder();
                sb2.append(' ');
                sb2.append(purchasingData);
                sb2.append(' ');
                PresentedOfferingContext presentedOfferingContext2 = presentedOfferingContext;
                if (presentedOfferingContext2 == null || (offeringIdentifier = presentedOfferingContext2.getOfferingIdentifier()) == null) {
                    str5 = null;
                } else {
                    str5 = PurchaseStrings.OFFERING + offeringIdentifier;
                }
                sb2.append(str5);
                String str6 = String.format(PurchaseStrings.PURCHASE_STARTED, Arrays.copyOf(new Object[]{sb2.toString()}, 1));
                Intrinsics.checkNotNullExpressionValue(str6, "format(...)");
                sb.append(str6);
                return sb.toString();
            }
        };
        int[] iArr = LogWrapperKt.WhenMappings.$EnumSwitchMapping$0;
        switch (iArr[logIntent.ordinal()]) {
            case 1:
                LogLevel logLevel = LogLevel.DEBUG;
                currentLogHandler2 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                    str3 = "[Purchases] - " + logLevel.name();
                    str4 = (String) function0.invoke();
                    currentLogHandler2.d(str3, str4);
                }
                break;
            case 2:
                LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) function0.invoke(), null);
                break;
            case 3:
                LogLevel logLevel2 = LogLevel.WARN;
                LogHandler currentLogHandler3 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel2) <= 0) {
                    currentLogHandler3.w("[Purchases] - " + logLevel2.name(), (String) function0.invoke());
                }
                break;
            case 4:
                LogLevel logLevel3 = LogLevel.INFO;
                LogHandler currentLogHandler4 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel3) <= 0) {
                    currentLogHandler4.i("[Purchases] - " + logLevel3.name(), (String) function0.invoke());
                }
                break;
            case 5:
                LogLevel logLevel4 = LogLevel.DEBUG;
                currentLogHandler2 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel4) <= 0) {
                    str3 = "[Purchases] - " + logLevel4.name();
                    str4 = (String) function0.invoke();
                    currentLogHandler2.d(str3, str4);
                }
                break;
            case 6:
                LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) function0.invoke(), null);
                break;
            case 7:
                LogLevel logLevel5 = LogLevel.INFO;
                LogHandler currentLogHandler5 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel5) <= 0) {
                    currentLogHandler5.i("[Purchases] - " + logLevel5.name(), (String) function0.invoke());
                }
                break;
            case 8:
                LogLevel logLevel6 = LogLevel.DEBUG;
                currentLogHandler2 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel6) <= 0) {
                    str3 = "[Purchases] - " + logLevel6.name();
                    str4 = (String) function0.invoke();
                    currentLogHandler2.d(str3, str4);
                }
                break;
            case 9:
                LogLevel logLevel7 = LogLevel.DEBUG;
                currentLogHandler2 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel7) <= 0) {
                    str3 = "[Purchases] - " + logLevel7.name();
                    str4 = (String) function0.invoke();
                    currentLogHandler2.d(str3, str4);
                }
                break;
            case 10:
                LogLevel logLevel8 = LogLevel.WARN;
                LogHandler currentLogHandler6 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel8) <= 0) {
                    currentLogHandler6.w("[Purchases] - " + logLevel8.name(), (String) function0.invoke());
                }
                break;
            case 11:
                LogLevel logLevel9 = LogLevel.WARN;
                LogHandler currentLogHandler7 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel9) <= 0) {
                    currentLogHandler7.w("[Purchases] - " + logLevel9.name(), (String) function0.invoke());
                }
                break;
            case 12:
                LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) function0.invoke(), null);
                break;
            case 13:
                LogLevel logLevel10 = LogLevel.WARN;
                LogHandler currentLogHandler8 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel10) <= 0) {
                    currentLogHandler8.w("[Purchases] - " + logLevel10.name(), (String) function0.invoke());
                }
                break;
            case 14:
                LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) function0.invoke(), null);
                break;
        }
        if ((purchasingData instanceof GooglePurchasingData.Subscription) && (addOnProducts = ((GooglePurchasingData.Subscription) purchasingData).getAddOnProducts()) != null && (!addOnProducts.isEmpty()) && getStore() != Store.PLAY_STORE) {
            PurchasesError purchasesError = new PurchasesError(PurchasesErrorCode.PurchaseInvalidError, PurchaseStrings.PURCHASING_ADD_ONS_ONLY_SUPPORTED_ON_PLAY_STORE);
            LogUtilsKt.errorLog(purchasesError);
            dispatch(purchaseCallback, purchasesError);
            return;
        }
        trackPurchaseStarted(purchasingData.getProductId(), purchasingData.getProductType());
        PurchaseCallback purchaseCallbackCreateCallbackWithDiagnosticsIfNeeded = createCallbackWithDiagnosticsIfNeeded(purchaseCallback, purchasingData, this.dateProvider.getNow());
        synchronized (this) {
            try {
                if (!this.appConfig.getFinishTransactions()) {
                    final LogIntent logIntent2 = LogIntent.WARNING;
                    Function0<String> function02 = new Function0<String>() { // from class: com.revenuecat.purchases.PurchasesOrchestrator$startPurchase$lambda$84$$inlined$log$1
                        {
                            super(0);
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public final String invoke() {
                            return CollectionsKt.joinToString$default(logIntent2.getEmojiList(), "", null, null, 0, null, null, 62, null) + ' ' + PurchaseStrings.PURCHASE_FINISH_TRANSACTION_FALSE;
                        }
                    };
                    switch (iArr[logIntent2.ordinal()]) {
                        case 1:
                            LogLevel logLevel11 = LogLevel.DEBUG;
                            currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                            if (Config.INSTANCE.getLogLevel().compareTo(logLevel11) <= 0) {
                                str = "[Purchases] - " + logLevel11.name();
                                str2 = (String) function02.invoke();
                                currentLogHandler.d(str, str2);
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
                            currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                            if (Config.INSTANCE.getLogLevel().compareTo(logLevel14) <= 0) {
                                str = "[Purchases] - " + logLevel14.name();
                                str2 = (String) function02.invoke();
                                currentLogHandler.d(str, str2);
                            }
                            break;
                        case 6:
                            LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) function02.invoke(), null);
                            break;
                        case 7:
                            LogLevel logLevel15 = LogLevel.INFO;
                            LogHandler currentLogHandler11 = LogWrapperKt.getCurrentLogHandler();
                            if (Config.INSTANCE.getLogLevel().compareTo(logLevel15) <= 0) {
                                currentLogHandler11.i("[Purchases] - " + logLevel15.name(), (String) function02.invoke());
                            }
                            break;
                        case 8:
                            LogLevel logLevel16 = LogLevel.DEBUG;
                            currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                            if (Config.INSTANCE.getLogLevel().compareTo(logLevel16) <= 0) {
                                str = "[Purchases] - " + logLevel16.name();
                                str2 = (String) function02.invoke();
                                currentLogHandler.d(str, str2);
                            }
                            break;
                        case 9:
                            LogLevel logLevel17 = LogLevel.DEBUG;
                            currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                            if (Config.INSTANCE.getLogLevel().compareTo(logLevel17) <= 0) {
                                str = "[Purchases] - " + logLevel17.name();
                                str2 = (String) function02.invoke();
                                currentLogHandler.d(str, str2);
                            }
                            break;
                        case 10:
                            LogLevel logLevel18 = LogLevel.WARN;
                            LogHandler currentLogHandler12 = LogWrapperKt.getCurrentLogHandler();
                            if (Config.INSTANCE.getLogLevel().compareTo(logLevel18) <= 0) {
                                currentLogHandler12.w("[Purchases] - " + logLevel18.name(), (String) function02.invoke());
                            }
                            break;
                        case 11:
                            LogLevel logLevel19 = LogLevel.WARN;
                            LogHandler currentLogHandler13 = LogWrapperKt.getCurrentLogHandler();
                            if (Config.INSTANCE.getLogLevel().compareTo(logLevel19) <= 0) {
                                currentLogHandler13.w("[Purchases] - " + logLevel19.name(), (String) function02.invoke());
                            }
                            break;
                        case 12:
                            LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) function02.invoke(), null);
                            break;
                        case 13:
                            LogLevel logLevel20 = LogLevel.WARN;
                            LogHandler currentLogHandler14 = LogWrapperKt.getCurrentLogHandler();
                            if (Config.INSTANCE.getLogLevel().compareTo(logLevel20) <= 0) {
                                currentLogHandler14.w("[Purchases] - " + logLevel20.name(), (String) function02.invoke());
                            }
                            break;
                        case 14:
                            LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) function02.invoke(), null);
                            break;
                    }
                }
                if (getState$purchases_defaultsBc8Release().getPurchaseCallbacksByProductId().containsKey(purchasingData.getProductId())) {
                    currentAppUserID = null;
                } else {
                    setState$purchases_defaultsBc8Release(PurchasesState.copy$default(getState$purchases_defaultsBc8Release(), null, MapsKt.plus(getState$purchases_defaultsBc8Release().getPurchaseCallbacksByProductId(), MapsKt.mapOf(TuplesKt.a(purchasingData.getProductId(), purchaseCallbackCreateCallbackWithDiagnosticsIfNeeded))), null, false, false, 29, null));
                    currentAppUserID = this.identityManager.getCurrentAppUserID();
                }
                Unit unit2 = Unit.f139807a;
            } catch (Throwable th) {
                throw th;
            }
        }
        if (currentAppUserID != null) {
            this.billing.makePurchaseAsync(activity, currentAppUserID, purchasingData, null, presentedOfferingContext, bool);
            unit = Unit.f139807a;
        } else {
            unit = null;
        }
        if (unit == null) {
            PurchasesError purchasesError2 = new PurchasesError(PurchasesErrorCode.OperationAlreadyInProgressError, null, 2, null);
            LogUtilsKt.errorLog(purchasesError2);
            dispatch(purchaseCallbackCreateCallbackWithDiagnosticsIfNeeded, purchasesError2);
        }
    }

    public static /* synthetic */ void syncPurchases$default(PurchasesOrchestrator purchasesOrchestrator, SyncPurchasesCallback syncPurchasesCallback, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            syncPurchasesCallback = null;
        }
        purchasesOrchestrator.syncPurchases(syncPurchasesCallback);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void synchronizeSubscriberAttributesIfNeeded() {
        if (this.appConfig.getUiPreviewMode()) {
            return;
        }
        SubscriberAttributesManager.synchronizeSubscriberAttributesForAllUsers$default(this.subscriberAttributesManager, getAppUserID(), null, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void trackGetProductsResult(Date date, Set<String> set, Set<String> set2, PurchasesError purchasesError) {
        PurchasesErrorCode code;
        if (this.diagnosticsTrackerIfEnabled == null) {
            return;
        }
        long jBetween = DurationExtensionsKt.between(Duration.f140631b, date, this.dateProvider.getNow());
        DiagnosticsTracker diagnosticsTracker = this.diagnosticsTrackerIfEnabled;
        Integer numValueOf = null;
        String message = purchasesError != null ? purchasesError.getMessage() : null;
        if (purchasesError != null && (code = purchasesError.getCode()) != null) {
            numValueOf = Integer.valueOf(code.getCode());
        }
        diagnosticsTracker.m535trackGetProductsResult9VgGkz4(set, set2, message, numValueOf, jBetween);
    }

    private final void trackGetProductsStarted(Set<String> set) {
        DiagnosticsTracker diagnosticsTracker = this.diagnosticsTrackerIfEnabled;
        if (diagnosticsTracker != null) {
            diagnosticsTracker.trackGetProductsStarted(set);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void trackPurchaseResultIfNeeded(PurchasingData purchasingData, PurchasesError purchasesError, Date date, VerificationResult verificationResult) {
        PurchasesErrorCode code;
        if (this.diagnosticsTrackerIfEnabled == null) {
            return;
        }
        this.diagnosticsTrackerIfEnabled.m540trackPurchaseResultmyKFqkg(purchasingData.getProductId(), purchasingData.getProductType(), (purchasesError == null || (code = purchasesError.getCode()) == null) ? null : Integer.valueOf(code.getCode()), purchasesError != null ? purchasesError.getMessage() : null, DurationExtensionsKt.between(Duration.f140631b, date, this.dateProvider.getNow()), verificationResult);
    }

    private final void trackPurchaseStarted(String str, ProductType productType) {
        DiagnosticsTracker diagnosticsTracker = this.diagnosticsTrackerIfEnabled;
        if (diagnosticsTracker != null) {
            diagnosticsTracker.trackPurchaseStarted(str, productType);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateAllCaches(String str, ReceiveCustomerInfoCallback receiveCustomerInfoCallback) {
        boolean appInBackground = getState$purchases_defaultsBc8Release().getAppInBackground();
        CustomerInfoHelper.retrieveCustomerInfo$default(this.customerInfoHelper, str, CacheFetchPolicy.FETCH_CURRENT, appInBackground, getAllowSharingPlayStoreAccount(), false, receiveCustomerInfoCallback, 16, null);
        OfferingsManager.fetchAndCacheOfferings$default(this.offeringsManager, str, appInBackground, null, null, 12, null);
    }

    static /* synthetic */ void updateAllCaches$default(PurchasesOrchestrator purchasesOrchestrator, String str, ReceiveCustomerInfoCallback receiveCustomerInfoCallback, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            receiveCustomerInfoCallback = null;
        }
        purchasesOrchestrator.updateAllCaches(str, receiveCustomerInfoCallback);
    }

    public final void close() {
        synchronized (this) {
            PurchasesState state$purchases_defaultsBc8Release = getState$purchases_defaultsBc8Release();
            Map map = Collections.EMPTY_MAP;
            Intrinsics.checkNotNullExpressionValue(map, "emptyMap()");
            setState$purchases_defaultsBc8Release(PurchasesState.copy$default(state$purchases_defaultsBc8Release, null, map, null, false, false, 29, null));
            Unit unit = Unit.f139807a;
        }
        this.backend.close();
        this.workflowManager.close();
        this.billing.close();
        setUpdatedCustomerInfoListener(null);
        dispatch(new Function0<Unit>() { // from class: com.revenuecat.purchases.PurchasesOrchestrator.close.2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Object invoke() {
                m449invoke();
                return Unit.f139807a;
            }

            /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
            public final void m449invoke() {
                ((LifecycleOwner) PurchasesOrchestrator.this.getProcessLifecycleOwnerProvider().invoke()).getLifecycle().removeObserver(PurchasesOrchestrator.this.getLifecycleHandler());
            }
        });
    }

    public final void collectDeviceIdentifiers() {
        LogHandler currentLogHandler;
        String str;
        String str2;
        final LogIntent logIntent = LogIntent.DEBUG;
        Function0<String> function0 = new Function0<String>() { // from class: com.revenuecat.purchases.PurchasesOrchestrator$collectDeviceIdentifiers$$inlined$log$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                StringBuilder sb = new StringBuilder();
                sb.append(CollectionsKt.joinToString$default(logIntent.getEmojiList(), "", null, null, 0, null, null, 62, null));
                sb.append(' ');
                String str3 = String.format(AttributionStrings.METHOD_CALLED, Arrays.copyOf(new Object[]{"collectDeviceIdentifiers"}, 1));
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
        this.subscriberAttributesManager.collectDeviceIdentifiers(getAppUserID(), this.application);
    }

    public final AdTracker getAdTracker() {
        return this.adTracker;
    }

    public final boolean getAllowSharingPlayStoreAccount() {
        Boolean allowSharingPlayStoreAccount;
        synchronized (this) {
            allowSharingPlayStoreAccount = getState$purchases_defaultsBc8Release().getAllowSharingPlayStoreAccount();
        }
        return allowSharingPlayStoreAccount != null ? allowSharingPlayStoreAccount.booleanValue() : this.identityManager.currentUserIsAnonymous();
    }

    public final void getAmazonLWAConsentStatus(final GetAmazonLWAConsentStatusCallback callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.billing.getAmazonLWAConsentStatus(new Function1<AmazonLWAConsentStatus, Unit>() { // from class: com.revenuecat.purchases.PurchasesOrchestrator.getAmazonLWAConsentStatus.1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((AmazonLWAConsentStatus) obj);
                return Unit.f139807a;
            }

            public final void invoke(AmazonLWAConsentStatus it) {
                Intrinsics.checkNotNullParameter(it, "it");
                callback.onSuccess(it);
            }
        }, new Function1<PurchasesError, Unit>() { // from class: com.revenuecat.purchases.PurchasesOrchestrator.getAmazonLWAConsentStatus.2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((PurchasesError) obj);
                return Unit.f139807a;
            }

            public final void invoke(PurchasesError it) {
                Intrinsics.checkNotNullParameter(it, "it");
                callback.onError(it);
            }
        });
    }

    public final AppConfig getAppConfig() {
        return this.appConfig;
    }

    public final synchronized String getAppUserID() {
        return this.identityManager.getCurrentAppUserID();
    }

    public final String getCachedCurrentOfferingIdentifier() {
        return this.offeringsManager.getCachedCurrentOfferingIdentifier();
    }

    public final DownloadedFontFamily getCachedFontFamilyOrStartDownload(UiConfig.AppConfig.FontsConfig.FontInfo.Name fontInfo) {
        Intrinsics.checkNotNullParameter(fontInfo, "fontInfo");
        return this.fontLoader.getCachedFontFamilyOrStartDownload(fontInfo);
    }

    public final VirtualCurrencies getCachedVirtualCurrencies() {
        return this.virtualCurrencyManager.cachedVirtualCurrencies();
    }

    public final PurchasesConfiguration getCurrentConfiguration() {
        return this.initialConfiguration.getAppUserID() == null ? this.initialConfiguration : PurchasesConfiguration.copy$purchases_defaultsBc8Release$default(this.initialConfiguration, getAppUserID(), null, 2, null);
    }

    public final void getCustomerCenterConfig(final GetCustomerCenterConfigCallback callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.backend.getCustomerCenterConfig(this.identityManager.getCurrentAppUserID(), new Function1<CustomerCenterConfigData, Unit>() { // from class: com.revenuecat.purchases.PurchasesOrchestrator.getCustomerCenterConfig.1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((CustomerCenterConfigData) obj);
                return Unit.f139807a;
            }

            public final void invoke(CustomerCenterConfigData config) {
                Intrinsics.checkNotNullParameter(config, "config");
                callback.onSuccess(config);
            }
        }, new Function1<PurchasesError, Unit>() { // from class: com.revenuecat.purchases.PurchasesOrchestrator.getCustomerCenterConfig.2
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
                callback.onError(error);
            }
        });
    }

    public final synchronized CustomerCenterListener getCustomerCenterListener() {
        return this.customerCenterListener;
    }

    public final synchronized DebugEventListener getDebugEventListener() {
        return this.eventsManager.getDebugEventListener();
    }

    public final FileRepository getFileRepository() {
        return this.fileRepository;
    }

    public final synchronized boolean getFinishTransactions() {
        return this.appConfig.getFinishTransactions();
    }

    public final void getOfferings(final ReceiveOfferingsCallback listener, boolean z2) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.offeringsManager.getOfferings(this.identityManager.getCurrentAppUserID(), getState$purchases_defaultsBc8Release().getAppInBackground(), new Function1<PurchasesError, Unit>() { // from class: com.revenuecat.purchases.PurchasesOrchestrator.getOfferings.1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((PurchasesError) obj);
                return Unit.f139807a;
            }

            public final void invoke(PurchasesError it) {
                Intrinsics.checkNotNullParameter(it, "it");
                listener.onError(it);
            }
        }, new Function1<Offerings, Unit>() { // from class: com.revenuecat.purchases.PurchasesOrchestrator.getOfferings.2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Offerings) obj);
                return Unit.f139807a;
            }

            public final void invoke(Offerings it) {
                Intrinsics.checkNotNullParameter(it, "it");
                listener.onReceived(it);
            }
        }, z2);
    }

    public final OfflineEntitlementsManager getOfflineEntitlementsManager() {
        return this.offlineEntitlementsManager;
    }

    public final String getPreferredUILocaleOverride() {
        return this._preferredUILocaleOverride;
    }

    public final Function0<LifecycleOwner> getProcessLifecycleOwnerProvider() {
        return this.processLifecycleOwnerProvider;
    }

    public final void getProducts(List<String> productIds, ProductType productType, final GetStoreProductsCallback callback) {
        Set<? extends ProductType> of;
        Intrinsics.checkNotNullParameter(productIds, "productIds");
        Intrinsics.checkNotNullParameter(callback, "callback");
        if (productType == null || (of = SetsKt.setOf(productType)) == null) {
            of = SetsKt.setOf((Object[]) new ProductType[]{ProductType.SUBS, ProductType.INAPP});
        }
        List<String> list = productIds;
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            if (!StringsKt.a0((String) obj, Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR, false, 2, null)) {
                arrayList.add(obj);
            }
        }
        Set set = CollectionsKt.toSet(arrayList);
        final LinkedHashMap linkedHashMap = new LinkedHashMap();
        ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        for (String str : list) {
            if (StringsKt.a0(str, Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR, false, 2, null)) {
                String strN1 = StringsKt.n1(str, Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR, null, 2, null);
                String strF1 = StringsKt.f1(str, Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR, null, 2, null);
                if (!set.contains(strN1)) {
                    Object linkedHashSet = linkedHashMap.get(strN1);
                    if (linkedHashSet == null) {
                        linkedHashSet = new LinkedHashSet();
                        linkedHashMap.put(strN1, linkedHashSet);
                    }
                    ((Set) linkedHashSet).add(strF1);
                }
                str = strN1;
            }
            arrayList2.add(str);
        }
        getProductsOfTypes(CollectionsKt.toSet(arrayList2), of, new GetStoreProductsCallback() { // from class: com.revenuecat.purchases.PurchasesOrchestrator.getProducts.1
            @Override // com.revenuecat.purchases.interfaces.GetStoreProductsCallback
            public void onError(PurchasesError error) {
                Intrinsics.checkNotNullParameter(error, "error");
                callback.onError(error);
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.revenuecat.purchases.interfaces.GetStoreProductsCallback
            public void onReceived(List<? extends StoreProduct> storeProducts) {
                boolean zContains;
                Intrinsics.checkNotNullParameter(storeProducts, "storeProducts");
                if (!linkedHashMap.isEmpty()) {
                    Map<String, Set<String>> map = linkedHashMap;
                    ArrayList arrayList3 = new ArrayList();
                    for (Object obj2 : storeProducts) {
                        StoreProduct storeProduct = (StoreProduct) obj2;
                        Set<String> set2 = map.get(storeProduct.getPurchasingData().getProductId());
                        if (set2 != null) {
                            Set<String> set3 = set2;
                            GoogleStoreProduct googleStoreProduct = storeProduct instanceof GoogleStoreProduct ? (GoogleStoreProduct) storeProduct : null;
                            zContains = CollectionsKt.contains(set3, googleStoreProduct != null ? googleStoreProduct.getBasePlanId() : null);
                        } else {
                            zContains = true;
                        }
                        if (zContains) {
                            arrayList3.add(obj2);
                        }
                    }
                    storeProducts = arrayList3;
                }
                callback.onReceived(storeProducts);
            }
        });
    }

    public final void getProductsOfTypes(Set<String> productIds, Set<? extends ProductType> types, GetStoreProductsCallback callback) {
        Intrinsics.checkNotNullParameter(productIds, "productIds");
        Intrinsics.checkNotNullParameter(types, "types");
        Intrinsics.checkNotNullParameter(callback, "callback");
        ArrayList arrayList = new ArrayList();
        for (Object obj : types) {
            if (((ProductType) obj) != ProductType.UNKNOWN) {
                arrayList.add(obj);
            }
        }
        getProductsOfTypes$default(this, productIds, CollectionsKt.toSet(arrayList), CollectionsKt.emptyList(), null, callback, 8, null);
    }

    public final PurchasesState getState$purchases_defaultsBc8Release() {
        return this.purchasesStateCache.getPurchasesState();
    }

    public final Store getStore() {
        return this.appConfig.getStore();
    }

    public final String getStorefrontCountryCode() {
        return this.storefrontCountryCode;
    }

    public final Locale getStorefrontLocale() {
        String str = this.storefrontCountryCode;
        if (str != null) {
            return new Locale.Builder().setRegion(str).build();
        }
        return null;
    }

    public final synchronized TrackedEventListener getTrackedEventListener() {
        return this.trackedEventListener;
    }

    public final synchronized UpdatedCustomerInfoListener getUpdatedCustomerInfoListener() {
        return this.customerInfoUpdateHandler.getUpdatedCustomerInfoListener();
    }

    public final void getVirtualCurrencies(GetVirtualCurrenciesCallback callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.virtualCurrencyManager.virtualCurrencies(callback);
    }

    public final void getWorkflow(String workflowId, Function1<? super WorkflowDataResult, Unit> onSuccess, Function1<? super PurchasesError, Unit> onError) {
        Intrinsics.checkNotNullParameter(workflowId, "workflowId");
        Intrinsics.checkNotNullParameter(onSuccess, "onSuccess");
        Intrinsics.checkNotNullParameter(onError, "onError");
        this.workflowManager.getWorkflow(this.identityManager.getCurrentAppUserID(), workflowId, getState$purchases_defaultsBc8Release().getAppInBackground(), onSuccess, onError);
    }

    public final void invalidateCustomerInfoCache() {
        LogHandler currentLogHandler;
        String str;
        String str2;
        final LogIntent logIntent = LogIntent.DEBUG;
        Function0<String> function0 = new Function0<String>() { // from class: com.revenuecat.purchases.PurchasesOrchestrator$invalidateCustomerInfoCache$$inlined$log$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                return CollectionsKt.joinToString$default(logIntent.getEmojiList(), "", null, null, 0, null, null, 62, null) + ' ' + CustomerInfoStrings.INVALIDATING_CUSTOMERINFO_CACHE;
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
        this.deviceCache.clearCustomerInfoCache$purchases_defaultsBc8Release(getAppUserID());
    }

    public final void invalidateVirtualCurrenciesCache() {
        this.virtualCurrencyManager.invalidateVirtualCurrenciesCache();
    }

    public final boolean isAnonymous() {
        return this.identityManager.currentUserIsAnonymous();
    }

    public final void logIn(final String newAppUserID, final LogInCallback logInCallback) {
        Intrinsics.checkNotNullParameter(newAppUserID, "newAppUserID");
        String currentAppUserID = this.identityManager.getCurrentAppUserID();
        Unit unit = null;
        if (Intrinsics.areEqual(currentAppUserID, newAppUserID)) {
            currentAppUserID = null;
        }
        if (currentAppUserID != null) {
            this.blockstoreHelper.clearUserIdBackupIfNeeded(new Function0<Unit>() { // from class: com.revenuecat.purchases.PurchasesOrchestrator$logIn$2$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Object invoke() {
                    m456invoke();
                    return Unit.f139807a;
                }

                /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
                public final void m456invoke() {
                    IdentityManager identityManager = this.this$0.identityManager;
                    final String str = newAppUserID;
                    final PurchasesOrchestrator purchasesOrchestrator = this.this$0;
                    final LogInCallback logInCallback2 = logInCallback;
                    Function2<CustomerInfo, Boolean, Unit> function2 = new Function2<CustomerInfo, Boolean, Unit>() { // from class: com.revenuecat.purchases.PurchasesOrchestrator$logIn$2$1.1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                            invoke((CustomerInfo) obj, ((Boolean) obj2).booleanValue());
                            return Unit.f139807a;
                        }

                        public final void invoke(final CustomerInfo customerInfo, final boolean z2) {
                            Intrinsics.checkNotNullParameter(customerInfo, "customerInfo");
                            final PurchasesOrchestrator purchasesOrchestrator2 = purchasesOrchestrator;
                            final LogInCallback logInCallback3 = logInCallback2;
                            purchasesOrchestrator2.dispatch(new Function0<Unit>() { // from class: com.revenuecat.purchases.PurchasesOrchestrator.logIn.2.1.1.1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(0);
                                }

                                @Override // kotlin.jvm.functions.Function0
                                public /* bridge */ /* synthetic */ Object invoke() {
                                    m457invoke();
                                    return Unit.f139807a;
                                }

                                /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
                                public final void m457invoke() {
                                    LogInCallback logInCallback4 = logInCallback3;
                                    if (logInCallback4 != null) {
                                        logInCallback4.onReceived(customerInfo, z2);
                                    }
                                    purchasesOrchestrator2.customerInfoUpdateHandler.notifyListeners(customerInfo);
                                }
                            });
                            OfferingsManager.fetchAndCacheOfferings$default(purchasesOrchestrator.offeringsManager, str, purchasesOrchestrator.getState$purchases_defaultsBc8Release().getAppInBackground(), null, null, 12, null);
                            purchasesOrchestrator.backupManager.dataChanged();
                        }
                    };
                    final PurchasesOrchestrator purchasesOrchestrator2 = this.this$0;
                    final LogInCallback logInCallback3 = logInCallback;
                    identityManager.logIn(str, function2, new Function1<PurchasesError, Unit>() { // from class: com.revenuecat.purchases.PurchasesOrchestrator$logIn$2$1.2
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                            invoke((PurchasesError) obj);
                            return Unit.f139807a;
                        }

                        public final void invoke(final PurchasesError error) {
                            Intrinsics.checkNotNullParameter(error, "error");
                            PurchasesOrchestrator purchasesOrchestrator3 = purchasesOrchestrator2;
                            final LogInCallback logInCallback4 = logInCallback3;
                            purchasesOrchestrator3.dispatch(new Function0<Unit>() { // from class: com.revenuecat.purchases.PurchasesOrchestrator.logIn.2.1.2.1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(0);
                                }

                                @Override // kotlin.jvm.functions.Function0
                                public /* bridge */ /* synthetic */ Object invoke() {
                                    m458invoke();
                                    return Unit.f139807a;
                                }

                                /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
                                public final void m458invoke() {
                                    LogInCallback logInCallback5 = logInCallback4;
                                    if (logInCallback5 != null) {
                                        logInCallback5.onError(error);
                                    }
                                }
                            });
                        }
                    });
                }
            });
            unit = Unit.f139807a;
        }
        if (unit == null) {
            CustomerInfoHelper.retrieveCustomerInfo$default(this.customerInfoHelper, this.identityManager.getCurrentAppUserID(), CacheFetchPolicy.Companion.m413default(), getState$purchases_defaultsBc8Release().getAppInBackground(), getAllowSharingPlayStoreAccount(), false, ListenerConversionsCommonKt.receiveCustomerInfoCallback(new Function1<CustomerInfo, Unit>() { // from class: com.revenuecat.purchases.PurchasesOrchestrator.logIn.3
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke((CustomerInfo) obj);
                    return Unit.f139807a;
                }

                public final void invoke(final CustomerInfo customerInfo) {
                    Intrinsics.checkNotNullParameter(customerInfo, "customerInfo");
                    PurchasesOrchestrator purchasesOrchestrator = PurchasesOrchestrator.this;
                    final LogInCallback logInCallback2 = logInCallback;
                    purchasesOrchestrator.dispatch(new Function0<Unit>() { // from class: com.revenuecat.purchases.PurchasesOrchestrator.logIn.3.1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public /* bridge */ /* synthetic */ Object invoke() {
                            m459invoke();
                            return Unit.f139807a;
                        }

                        /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
                        public final void m459invoke() {
                            LogInCallback logInCallback3 = logInCallback2;
                            if (logInCallback3 != null) {
                                logInCallback3.onReceived(customerInfo, false);
                            }
                        }
                    });
                }
            }, new Function1<PurchasesError, Unit>() { // from class: com.revenuecat.purchases.PurchasesOrchestrator.logIn.4
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke((PurchasesError) obj);
                    return Unit.f139807a;
                }

                public final void invoke(final PurchasesError error) {
                    Intrinsics.checkNotNullParameter(error, "error");
                    PurchasesOrchestrator purchasesOrchestrator = PurchasesOrchestrator.this;
                    final LogInCallback logInCallback2 = logInCallback;
                    purchasesOrchestrator.dispatch(new Function0<Unit>() { // from class: com.revenuecat.purchases.PurchasesOrchestrator.logIn.4.1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public /* bridge */ /* synthetic */ Object invoke() {
                            m460invoke();
                            return Unit.f139807a;
                        }

                        /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
                        public final void m460invoke() {
                            LogInCallback logInCallback3 = logInCallback2;
                            if (logInCallback3 != null) {
                                logInCallback3.onError(error);
                            }
                        }
                    });
                }
            }), 16, null);
        }
    }

    public final void logOut(final ReceiveCustomerInfoCallback receiveCustomerInfoCallback) {
        this.identityManager.logOut(new Function1<PurchasesError, Unit>() { // from class: com.revenuecat.purchases.PurchasesOrchestrator.logOut.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((PurchasesError) obj);
                return Unit.f139807a;
            }

            public final void invoke(PurchasesError purchasesError) {
                if (purchasesError != null) {
                    ReceiveCustomerInfoCallback receiveCustomerInfoCallback2 = receiveCustomerInfoCallback;
                    if (receiveCustomerInfoCallback2 != null) {
                        receiveCustomerInfoCallback2.onError(purchasesError);
                        return;
                    }
                    return;
                }
                PurchasesOrchestrator purchasesOrchestrator = this;
                synchronized (purchasesOrchestrator) {
                    PurchasesState state$purchases_defaultsBc8Release = purchasesOrchestrator.getState$purchases_defaultsBc8Release();
                    Map map = Collections.EMPTY_MAP;
                    Intrinsics.checkNotNullExpressionValue(map, "emptyMap()");
                    purchasesOrchestrator.setState$purchases_defaultsBc8Release(PurchasesState.copy$default(state$purchases_defaultsBc8Release, null, map, null, false, false, 29, null));
                    Unit unit = Unit.f139807a;
                }
                PurchasesOrchestrator purchasesOrchestrator2 = this;
                purchasesOrchestrator2.updateAllCaches(purchasesOrchestrator2.identityManager.getCurrentAppUserID(), receiveCustomerInfoCallback);
                this.backupManager.dataChanged();
            }
        });
    }

    @Override // com.revenuecat.purchases.utils.CustomActivityLifecycleHandler, android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        flushEvents(Delay.NONE);
    }

    @Override // com.revenuecat.purchases.utils.CustomActivityLifecycleHandler, android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        if (this.appConfig.getShowInAppMessagesAutomatically()) {
            showInAppMessagesIfNeeded(activity, ArraysKt.toList(InAppMessageType.values()));
        }
    }

    @Override // com.revenuecat.purchases.LifecycleDelegate
    public void onAppBackgrounded() {
        LogHandler currentLogHandler;
        String str;
        String str2;
        synchronized (this) {
            setState$purchases_defaultsBc8Release(PurchasesState.copy$default(getState$purchases_defaultsBc8Release(), null, null, null, true, false, 23, null));
            Unit unit = Unit.f139807a;
        }
        final LogIntent logIntent = LogIntent.DEBUG;
        Function0<String> function0 = new Function0<String>() { // from class: com.revenuecat.purchases.PurchasesOrchestrator$onAppBackgrounded$$inlined$log$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                return CollectionsKt.joinToString$default(logIntent.getEmojiList(), "", null, null, 0, null, null, 62, null) + ' ' + ConfigureStrings.APP_BACKGROUNDED;
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
        DebugEventListener debugEventListener = getDebugEventListener();
        if (debugEventListener != null) {
            debugEventListener.onDebugEventReceived(new DebugEvent(DebugEventName.APP_BACKGROUNDED, null, 2, null));
        }
        this.appConfig.setAppBackgrounded(true);
        if (this.appConfig.getUiPreviewMode()) {
            return;
        }
        synchronizeSubscriberAttributesIfNeeded();
        flushEvents(Delay.NONE);
    }

    @Override // com.revenuecat.purchases.LifecycleDelegate
    public void onAppForegrounded() {
        LogHandler currentLogHandler;
        String str;
        String str2;
        final Ref.BooleanRef booleanRef = new Ref.BooleanRef();
        synchronized (this) {
            booleanRef.f140137a = getState$purchases_defaultsBc8Release().getFirstTimeInForeground();
            setState$purchases_defaultsBc8Release(PurchasesState.copy$default(getState$purchases_defaultsBc8Release(), null, null, null, false, false, 7, null));
            Unit unit = Unit.f139807a;
        }
        final LogIntent logIntent = LogIntent.DEBUG;
        Function0<String> function0 = new Function0<String>() { // from class: com.revenuecat.purchases.PurchasesOrchestrator$onAppForegrounded$$inlined$log$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                return CollectionsKt.joinToString$default(logIntent.getEmojiList(), "", null, null, 0, null, null, 62, null) + ' ' + ConfigureStrings.APP_FOREGROUNDED;
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
        this.appConfig.setAppBackgrounded(false);
        enqueue(new Function0<Unit>() { // from class: com.revenuecat.purchases.PurchasesOrchestrator.onAppForegrounded.3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Object invoke() {
                m461invoke();
                return Unit.f139807a;
            }

            /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
            public final void m461invoke() {
                DiagnosticsSynchronizer diagnosticsSynchronizer;
                LogHandler currentLogHandler8;
                String str3;
                String str4;
                if (PurchasesOrchestrator.this.getAppConfig().getUiPreviewMode()) {
                    return;
                }
                if (PurchasesOrchestrator.this.shouldRefreshCustomerInfo(booleanRef.f140137a)) {
                    final LogIntent logIntent2 = LogIntent.DEBUG;
                    Function0<String> function02 = new Function0<String>() { // from class: com.revenuecat.purchases.PurchasesOrchestrator$onAppForegrounded$3$invoke$$inlined$log$1
                        {
                            super(0);
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public final String invoke() {
                            return CollectionsKt.joinToString$default(logIntent2.getEmojiList(), "", null, null, 0, null, null, 62, null) + ' ' + CustomerInfoStrings.CUSTOMERINFO_STALE_UPDATING_FOREGROUND;
                        }
                    };
                    switch (LogWrapperKt.WhenMappings.$EnumSwitchMapping$0[logIntent2.ordinal()]) {
                        case 1:
                            LogLevel logLevel11 = LogLevel.DEBUG;
                            currentLogHandler8 = LogWrapperKt.getCurrentLogHandler();
                            if (Config.INSTANCE.getLogLevel().compareTo(logLevel11) <= 0) {
                                str3 = "[Purchases] - " + logLevel11.name();
                                str4 = (String) function02.invoke();
                                currentLogHandler8.d(str3, str4);
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
                            currentLogHandler8 = LogWrapperKt.getCurrentLogHandler();
                            if (Config.INSTANCE.getLogLevel().compareTo(logLevel14) <= 0) {
                                str3 = "[Purchases] - " + logLevel14.name();
                                str4 = (String) function02.invoke();
                                currentLogHandler8.d(str3, str4);
                            }
                            break;
                        case 6:
                            LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) function02.invoke(), null);
                            break;
                        case 7:
                            LogLevel logLevel15 = LogLevel.INFO;
                            LogHandler currentLogHandler11 = LogWrapperKt.getCurrentLogHandler();
                            if (Config.INSTANCE.getLogLevel().compareTo(logLevel15) <= 0) {
                                currentLogHandler11.i("[Purchases] - " + logLevel15.name(), (String) function02.invoke());
                            }
                            break;
                        case 8:
                            LogLevel logLevel16 = LogLevel.DEBUG;
                            currentLogHandler8 = LogWrapperKt.getCurrentLogHandler();
                            if (Config.INSTANCE.getLogLevel().compareTo(logLevel16) <= 0) {
                                str3 = "[Purchases] - " + logLevel16.name();
                                str4 = (String) function02.invoke();
                                currentLogHandler8.d(str3, str4);
                            }
                            break;
                        case 9:
                            LogLevel logLevel17 = LogLevel.DEBUG;
                            currentLogHandler8 = LogWrapperKt.getCurrentLogHandler();
                            if (Config.INSTANCE.getLogLevel().compareTo(logLevel17) <= 0) {
                                str3 = "[Purchases] - " + logLevel17.name();
                                str4 = (String) function02.invoke();
                                currentLogHandler8.d(str3, str4);
                            }
                            break;
                        case 10:
                            LogLevel logLevel18 = LogLevel.WARN;
                            LogHandler currentLogHandler12 = LogWrapperKt.getCurrentLogHandler();
                            if (Config.INSTANCE.getLogLevel().compareTo(logLevel18) <= 0) {
                                currentLogHandler12.w("[Purchases] - " + logLevel18.name(), (String) function02.invoke());
                            }
                            break;
                        case 11:
                            LogLevel logLevel19 = LogLevel.WARN;
                            LogHandler currentLogHandler13 = LogWrapperKt.getCurrentLogHandler();
                            if (Config.INSTANCE.getLogLevel().compareTo(logLevel19) <= 0) {
                                currentLogHandler13.w("[Purchases] - " + logLevel19.name(), (String) function02.invoke());
                            }
                            break;
                        case 12:
                            LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) function02.invoke(), null);
                            break;
                        case 13:
                            LogLevel logLevel20 = LogLevel.WARN;
                            LogHandler currentLogHandler14 = LogWrapperKt.getCurrentLogHandler();
                            if (Config.INSTANCE.getLogLevel().compareTo(logLevel20) <= 0) {
                                currentLogHandler14.w("[Purchases] - " + logLevel20.name(), (String) function02.invoke());
                            }
                            break;
                        case 14:
                            LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) function02.invoke(), null);
                            break;
                    }
                    CustomerInfoHelper customerInfoHelper = PurchasesOrchestrator.this.customerInfoHelper;
                    String currentAppUserID = PurchasesOrchestrator.this.identityManager.getCurrentAppUserID();
                    CacheFetchPolicy cacheFetchPolicy = CacheFetchPolicy.FETCH_CURRENT;
                    boolean allowSharingPlayStoreAccount = PurchasesOrchestrator.this.getAllowSharingPlayStoreAccount();
                    final PurchasesOrchestrator purchasesOrchestrator = PurchasesOrchestrator.this;
                    CustomerInfoHelper.retrieveCustomerInfo$default(customerInfoHelper, currentAppUserID, cacheFetchPolicy, false, allowSharingPlayStoreAccount, false, new ReceiveCustomerInfoCallback() { // from class: com.revenuecat.purchases.PurchasesOrchestrator.onAppForegrounded.3.2
                        @Override // com.revenuecat.purchases.interfaces.ReceiveCustomerInfoCallback
                        public void onError(PurchasesError error) {
                            Intrinsics.checkNotNullParameter(error, "error");
                        }

                        @Override // com.revenuecat.purchases.interfaces.ReceiveCustomerInfoCallback
                        public void onReceived(CustomerInfo customerInfo) {
                            Intrinsics.checkNotNullParameter(customerInfo, "customerInfo");
                            purchasesOrchestrator.blockstoreHelper.storeUserIdIfNeeded(customerInfo);
                        }
                    }, 16, null);
                }
                PurchasesOrchestrator.this.offeringsManager.onAppForeground(PurchasesOrchestrator.this.identityManager.getCurrentAppUserID());
                PostPendingTransactionsHelper.syncPendingPurchaseQueue$default(PurchasesOrchestrator.this.postPendingTransactionsHelper, PurchasesOrchestrator.this.getAllowSharingPlayStoreAccount(), null, 2, null);
                PurchasesOrchestrator.this.synchronizeSubscriberAttributesIfNeeded();
                OfflineEntitlementsManager.updateProductEntitlementMappingCacheIfStale$default(PurchasesOrchestrator.this.getOfflineEntitlementsManager(), null, 1, null);
                PurchasesOrchestrator.this.flushEvents(Delay.DEFAULT);
                if (booleanRef.f140137a && AndroidVersionUtilsKt.isAndroidNOrNewer() && (diagnosticsSynchronizer = PurchasesOrchestrator.this.diagnosticsSynchronizer) != null) {
                    diagnosticsSynchronizer.syncDiagnosticsFileIfNeeded();
                }
            }
        });
    }

    public final boolean overridePreferredUILocale(String str) {
        if (Intrinsics.areEqual(this._preferredUILocaleOverride, str)) {
            LogLevel logLevel = LogLevel.DEBUG;
            LogHandler currentLogHandler = LogWrapperKt.getCurrentLogHandler();
            if (Config.INSTANCE.getLogLevel().compareTo(logLevel) > 0) {
                return false;
            }
            currentLogHandler.d("[Purchases] - " + logLevel.name(), "Locale unchanged, no fresh fetch needed");
            return false;
        }
        synchronized (this) {
            this._preferredUILocaleOverride = str;
            this.localeProvider.setPreferredLocaleOverride(str);
            Unit unit = Unit.f139807a;
        }
        LogLevel logLevel2 = LogLevel.DEBUG;
        LogHandler currentLogHandler2 = LogWrapperKt.getCurrentLogHandler();
        if (Config.INSTANCE.getLogLevel().compareTo(logLevel2) <= 0) {
            currentLogHandler2.d("[Purchases] - " + logLevel2.name(), "Locale changed, attempting to fetch fresh offerings");
        }
        return clearInMemoryCacheAndFetchOfferingsWithRateLimit(new Function2<Offerings, PurchasesError, Unit>() { // from class: com.revenuecat.purchases.PurchasesOrchestrator.overridePreferredUILocale.4
            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                invoke((Offerings) obj, (PurchasesError) obj2);
                return Unit.f139807a;
            }

            public final void invoke(Offerings offerings, PurchasesError purchasesError) {
                if (offerings != null) {
                    LogLevel logLevel3 = LogLevel.DEBUG;
                    LogHandler currentLogHandler3 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel3) <= 0) {
                        currentLogHandler3.d("[Purchases] - " + logLevel3.name(), "Fresh offerings fetch completed successfully");
                        return;
                    }
                    return;
                }
                LogLevel logLevel4 = LogLevel.DEBUG;
                LogHandler currentLogHandler4 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel4) <= 0) {
                    String str2 = "[Purchases] - " + logLevel4.name();
                    StringBuilder sb = new StringBuilder();
                    sb.append("Fresh offerings fetch failed: ");
                    sb.append(purchasesError != null ? purchasesError.getMessage() : null);
                    currentLogHandler4.d(str2, sb.toString());
                }
            }
        });
    }

    public final void purchase(PurchaseParams purchaseParams, final PurchaseCallback callback) throws PurchasesException {
        Unit unit;
        Intrinsics.checkNotNullParameter(purchaseParams, "purchaseParams");
        Intrinsics.checkNotNullParameter(callback, "callback");
        final Result<Unit, PurchasesError> resultValidate = this.purchaseParamsValidator.validate(purchaseParams);
        if (resultValidate instanceof Result.Error) {
            dispatch(new Function0<Unit>() { // from class: com.revenuecat.purchases.PurchasesOrchestrator.purchase.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Object invoke() {
                    m462invoke();
                    return Unit.f139807a;
                }

                /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
                public final void m462invoke() {
                    callback.onError((PurchasesError) ((Result.Error) resultValidate).getValue(), false);
                }
            });
            return;
        }
        String oldProductId = purchaseParams.getOldProductId();
        if (oldProductId != null) {
            startProductChange(purchaseParams.getActivity$purchases_defaultsBc8Release(), purchaseParams.getPurchasingData$purchases_defaultsBc8Release(), purchaseParams.getPresentedOfferingContext$purchases_defaultsBc8Release(), oldProductId, purchaseParams.getReplacementMode(), purchaseParams.isPersonalizedPrice(), callback);
            unit = Unit.f139807a;
        } else {
            unit = null;
        }
        if (unit == null) {
            startPurchase(purchaseParams.getActivity$purchases_defaultsBc8Release(), purchaseParams.getPurchasingData$purchases_defaultsBc8Release(), purchaseParams.getPresentedOfferingContext$purchases_defaultsBc8Release(), purchaseParams.isPersonalizedPrice(), callback);
        }
    }

    public final void redeemWebPurchase(WebPurchaseRedemption webPurchaseRedemption, RedeemWebPurchaseListener listener) {
        Intrinsics.checkNotNullParameter(webPurchaseRedemption, "webPurchaseRedemption");
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.webPurchaseRedemptionHelper.handleRedeemWebPurchase(webPurchaseRedemption, listener);
    }

    public final void removeUpdatedCustomerInfoListener() {
        setUpdatedCustomerInfoListener(null);
    }

    public final void restorePurchases(final ReceiveCustomerInfoCallback callback) {
        LogHandler currentLogHandler;
        String str;
        String str2;
        Intrinsics.checkNotNullParameter(callback, "callback");
        final LogIntent logIntent = LogIntent.DEBUG;
        Function0<String> function0 = new Function0<String>() { // from class: com.revenuecat.purchases.PurchasesOrchestrator$restorePurchases$$inlined$log$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                return CollectionsKt.joinToString$default(logIntent.getEmojiList(), "", null, null, 0, null, null, 62, null) + ' ' + RestoreStrings.RESTORING_PURCHASE;
            }
        };
        int[] iArr = LogWrapperKt.WhenMappings.$EnumSwitchMapping$0;
        switch (iArr[logIntent.ordinal()]) {
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
        if (!getAllowSharingPlayStoreAccount()) {
            final LogIntent logIntent2 = LogIntent.WARNING;
            Function0<String> function02 = new Function0<String>() { // from class: com.revenuecat.purchases.PurchasesOrchestrator$restorePurchases$$inlined$log$2
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return CollectionsKt.joinToString$default(logIntent2.getEmojiList(), "", null, null, 0, null, null, 62, null) + ' ' + RestoreStrings.SHARING_ACC_RESTORE_FALSE;
                }
            };
            switch (iArr[logIntent2.ordinal()]) {
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
        }
        if (this.appConfig.getApiKeyValidationResult() != APIKeyValidator.ValidationResult.SIMULATED_STORE) {
            final Date now = this.dateProvider.getNow();
            DiagnosticsTracker diagnosticsTracker = this.diagnosticsTrackerIfEnabled;
            if (diagnosticsTracker != null) {
                diagnosticsTracker.trackRestorePurchasesStarted();
                Unit unit = Unit.f139807a;
            }
            final String currentAppUserID = this.identityManager.getCurrentAppUserID();
            if (this.diagnosticsTrackerIfEnabled != null) {
                callback = new ReceiveCustomerInfoCallback() { // from class: com.revenuecat.purchases.PurchasesOrchestrator$restorePurchases$callbackWithTracking$1
                    @Override // com.revenuecat.purchases.interfaces.ReceiveCustomerInfoCallback
                    public void onError(PurchasesError error) {
                        Intrinsics.checkNotNullParameter(error, "error");
                        this.this$0.diagnosticsTrackerIfEnabled.m541trackRestorePurchasesResultSxA4cEA(Integer.valueOf(error.getCode().getCode()), error.getMessage(), DurationExtensionsKt.between(Duration.f140631b, now, this.this$0.dateProvider.getNow()));
                        callback.onError(error);
                    }

                    @Override // com.revenuecat.purchases.interfaces.ReceiveCustomerInfoCallback
                    public void onReceived(CustomerInfo customerInfo) {
                        Intrinsics.checkNotNullParameter(customerInfo, "customerInfo");
                        this.this$0.diagnosticsTrackerIfEnabled.m541trackRestorePurchasesResultSxA4cEA(null, null, DurationExtensionsKt.between(Duration.f140631b, now, this.this$0.dateProvider.getNow()));
                        callback.onReceived(customerInfo);
                    }
                };
            }
            this.blockstoreHelper.aliasCurrentAndStoredUserIdsIfNeeded(new Function0<Unit>() { // from class: com.revenuecat.purchases.PurchasesOrchestrator.restorePurchases.4
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Object invoke() {
                    m463invoke();
                    return Unit.f139807a;
                }

                /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
                public final void m463invoke() {
                    BillingAbstract billingAbstract = PurchasesOrchestrator.this.billing;
                    final String str3 = currentAppUserID;
                    final PurchasesOrchestrator purchasesOrchestrator = PurchasesOrchestrator.this;
                    final ReceiveCustomerInfoCallback receiveCustomerInfoCallback = callback;
                    Function1<List<? extends StoreTransaction>, Unit> function1 = new Function1<List<? extends StoreTransaction>, Unit>() { // from class: com.revenuecat.purchases.PurchasesOrchestrator.restorePurchases.4.1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                            invoke((List<StoreTransaction>) obj);
                            return Unit.f139807a;
                        }

                        public final void invoke(List<StoreTransaction> allPurchases) {
                            LogHandler currentLogHandler18;
                            String str4;
                            String str5;
                            Intrinsics.checkNotNullParameter(allPurchases, "allPurchases");
                            if (!allPurchases.isEmpty()) {
                                final List<StoreTransaction> listSortedWith = CollectionsKt.sortedWith(allPurchases, new Comparator() { // from class: com.revenuecat.purchases.PurchasesOrchestrator$restorePurchases$4$1$invoke$$inlined$sortedBy$1
                                    /* JADX WARN: Multi-variable type inference failed */
                                    @Override // java.util.Comparator
                                    public final int compare(T t2, T t3) {
                                        return ComparisonsKt.d(Long.valueOf(((StoreTransaction) t2).getPurchaseTime()), Long.valueOf(((StoreTransaction) t3).getPurchaseTime()));
                                    }
                                });
                                final PurchasesOrchestrator purchasesOrchestrator2 = purchasesOrchestrator;
                                String str6 = str3;
                                final ReceiveCustomerInfoCallback receiveCustomerInfoCallback2 = receiveCustomerInfoCallback;
                                for (final StoreTransaction storeTransaction : listSortedWith) {
                                    purchasesOrchestrator2.postReceiptHelper.postTransactionAndConsumeIfNeeded(storeTransaction, null, null, true, str6, PostReceiptInitiationSource.RESTORE, false, new Function2<StoreTransaction, CustomerInfo, Unit>() { // from class: com.revenuecat.purchases.PurchasesOrchestrator$restorePurchases$4$1$3$1$1
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        {
                                            super(2);
                                        }

                                        @Override // kotlin.jvm.functions.Function2
                                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                                            invoke((StoreTransaction) obj, (CustomerInfo) obj2);
                                            return Unit.f139807a;
                                        }

                                        public final void invoke(StoreTransaction storeTransaction2, final CustomerInfo info) {
                                            LogHandler currentLogHandler19;
                                            String str7;
                                            String str8;
                                            Intrinsics.checkNotNullParameter(storeTransaction2, "<anonymous parameter 0>");
                                            Intrinsics.checkNotNullParameter(info, "info");
                                            final LogIntent logIntent3 = LogIntent.DEBUG;
                                            final StoreTransaction storeTransaction3 = storeTransaction;
                                            Function0<String> function03 = new Function0<String>() { // from class: com.revenuecat.purchases.PurchasesOrchestrator$restorePurchases$4$1$3$1$1$invoke$$inlined$log$1
                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                {
                                                    super(0);
                                                }

                                                @Override // kotlin.jvm.functions.Function0
                                                public final String invoke() {
                                                    StringBuilder sb = new StringBuilder();
                                                    sb.append(CollectionsKt.joinToString$default(logIntent3.getEmojiList(), "", null, null, 0, null, null, 62, null));
                                                    sb.append(' ');
                                                    String str9 = String.format(RestoreStrings.PURCHASE_RESTORED, Arrays.copyOf(new Object[]{storeTransaction3}, 1));
                                                    Intrinsics.checkNotNullExpressionValue(str9, "format(...)");
                                                    sb.append(str9);
                                                    return sb.toString();
                                                }
                                            };
                                            switch (LogWrapperKt.WhenMappings.$EnumSwitchMapping$0[logIntent3.ordinal()]) {
                                                case 1:
                                                    LogLevel logLevel21 = LogLevel.DEBUG;
                                                    currentLogHandler19 = LogWrapperKt.getCurrentLogHandler();
                                                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel21) <= 0) {
                                                        str7 = "[Purchases] - " + logLevel21.name();
                                                        str8 = (String) function03.invoke();
                                                        currentLogHandler19.d(str7, str8);
                                                    }
                                                    break;
                                                case 2:
                                                    LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) function03.invoke(), null);
                                                    break;
                                                case 3:
                                                    LogLevel logLevel22 = LogLevel.WARN;
                                                    LogHandler currentLogHandler20 = LogWrapperKt.getCurrentLogHandler();
                                                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel22) <= 0) {
                                                        currentLogHandler20.w("[Purchases] - " + logLevel22.name(), (String) function03.invoke());
                                                    }
                                                    break;
                                                case 4:
                                                    LogLevel logLevel23 = LogLevel.INFO;
                                                    LogHandler currentLogHandler21 = LogWrapperKt.getCurrentLogHandler();
                                                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel23) <= 0) {
                                                        currentLogHandler21.i("[Purchases] - " + logLevel23.name(), (String) function03.invoke());
                                                    }
                                                    break;
                                                case 5:
                                                    LogLevel logLevel24 = LogLevel.DEBUG;
                                                    currentLogHandler19 = LogWrapperKt.getCurrentLogHandler();
                                                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel24) <= 0) {
                                                        str7 = "[Purchases] - " + logLevel24.name();
                                                        str8 = (String) function03.invoke();
                                                        currentLogHandler19.d(str7, str8);
                                                    }
                                                    break;
                                                case 6:
                                                    LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) function03.invoke(), null);
                                                    break;
                                                case 7:
                                                    LogLevel logLevel25 = LogLevel.INFO;
                                                    LogHandler currentLogHandler22 = LogWrapperKt.getCurrentLogHandler();
                                                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel25) <= 0) {
                                                        currentLogHandler22.i("[Purchases] - " + logLevel25.name(), (String) function03.invoke());
                                                    }
                                                    break;
                                                case 8:
                                                    LogLevel logLevel26 = LogLevel.DEBUG;
                                                    currentLogHandler19 = LogWrapperKt.getCurrentLogHandler();
                                                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel26) <= 0) {
                                                        str7 = "[Purchases] - " + logLevel26.name();
                                                        str8 = (String) function03.invoke();
                                                        currentLogHandler19.d(str7, str8);
                                                    }
                                                    break;
                                                case 9:
                                                    LogLevel logLevel27 = LogLevel.DEBUG;
                                                    currentLogHandler19 = LogWrapperKt.getCurrentLogHandler();
                                                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel27) <= 0) {
                                                        str7 = "[Purchases] - " + logLevel27.name();
                                                        str8 = (String) function03.invoke();
                                                        currentLogHandler19.d(str7, str8);
                                                    }
                                                    break;
                                                case 10:
                                                    LogLevel logLevel28 = LogLevel.WARN;
                                                    LogHandler currentLogHandler23 = LogWrapperKt.getCurrentLogHandler();
                                                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel28) <= 0) {
                                                        currentLogHandler23.w("[Purchases] - " + logLevel28.name(), (String) function03.invoke());
                                                    }
                                                    break;
                                                case 11:
                                                    LogLevel logLevel29 = LogLevel.WARN;
                                                    LogHandler currentLogHandler24 = LogWrapperKt.getCurrentLogHandler();
                                                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel29) <= 0) {
                                                        currentLogHandler24.w("[Purchases] - " + logLevel29.name(), (String) function03.invoke());
                                                    }
                                                    break;
                                                case 12:
                                                    LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) function03.invoke(), null);
                                                    break;
                                                case 13:
                                                    LogLevel logLevel30 = LogLevel.WARN;
                                                    LogHandler currentLogHandler25 = LogWrapperKt.getCurrentLogHandler();
                                                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel30) <= 0) {
                                                        currentLogHandler25.w("[Purchases] - " + logLevel30.name(), (String) function03.invoke());
                                                    }
                                                    break;
                                                case 14:
                                                    LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) function03.invoke(), null);
                                                    break;
                                            }
                                            if (Intrinsics.areEqual(CollectionsKt.last((List) listSortedWith), storeTransaction)) {
                                                PurchasesOrchestrator purchasesOrchestrator3 = purchasesOrchestrator2;
                                                final ReceiveCustomerInfoCallback receiveCustomerInfoCallback3 = receiveCustomerInfoCallback2;
                                                purchasesOrchestrator3.dispatch(new Function0<Unit>() { // from class: com.revenuecat.purchases.PurchasesOrchestrator$restorePurchases$4$1$3$1$1.2
                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                    {
                                                        super(0);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function0
                                                    public /* bridge */ /* synthetic */ Object invoke() {
                                                        m464invoke();
                                                        return Unit.f139807a;
                                                    }

                                                    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
                                                    public final void m464invoke() {
                                                        receiveCustomerInfoCallback3.onReceived(info);
                                                    }
                                                });
                                            }
                                        }
                                    }, new Function2<StoreTransaction, PurchasesError, Unit>() { // from class: com.revenuecat.purchases.PurchasesOrchestrator$restorePurchases$4$1$3$1$2
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        {
                                            super(2);
                                        }

                                        @Override // kotlin.jvm.functions.Function2
                                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                                            invoke((StoreTransaction) obj, (PurchasesError) obj2);
                                            return Unit.f139807a;
                                        }

                                        public final void invoke(StoreTransaction storeTransaction2, final PurchasesError error) {
                                            LogHandler currentLogHandler19;
                                            String str7;
                                            String str8;
                                            Intrinsics.checkNotNullParameter(storeTransaction2, "<anonymous parameter 0>");
                                            Intrinsics.checkNotNullParameter(error, "error");
                                            final LogIntent logIntent3 = LogIntent.RC_ERROR;
                                            final StoreTransaction storeTransaction3 = storeTransaction;
                                            Function0<String> function03 = new Function0<String>() { // from class: com.revenuecat.purchases.PurchasesOrchestrator$restorePurchases$4$1$3$1$2$invoke$$inlined$log$1
                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                {
                                                    super(0);
                                                }

                                                @Override // kotlin.jvm.functions.Function0
                                                public final String invoke() {
                                                    StringBuilder sb = new StringBuilder();
                                                    sb.append(CollectionsKt.joinToString$default(logIntent3.getEmojiList(), "", null, null, 0, null, null, 62, null));
                                                    sb.append(' ');
                                                    String str9 = String.format(RestoreStrings.RESTORING_PURCHASE_ERROR, Arrays.copyOf(new Object[]{storeTransaction3, error}, 2));
                                                    Intrinsics.checkNotNullExpressionValue(str9, "format(...)");
                                                    sb.append(str9);
                                                    return sb.toString();
                                                }
                                            };
                                            switch (LogWrapperKt.WhenMappings.$EnumSwitchMapping$0[logIntent3.ordinal()]) {
                                                case 1:
                                                    LogLevel logLevel21 = LogLevel.DEBUG;
                                                    currentLogHandler19 = LogWrapperKt.getCurrentLogHandler();
                                                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel21) <= 0) {
                                                        str7 = "[Purchases] - " + logLevel21.name();
                                                        str8 = (String) function03.invoke();
                                                        currentLogHandler19.d(str7, str8);
                                                    }
                                                    break;
                                                case 2:
                                                    LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) function03.invoke(), null);
                                                    break;
                                                case 3:
                                                    LogLevel logLevel22 = LogLevel.WARN;
                                                    LogHandler currentLogHandler20 = LogWrapperKt.getCurrentLogHandler();
                                                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel22) <= 0) {
                                                        currentLogHandler20.w("[Purchases] - " + logLevel22.name(), (String) function03.invoke());
                                                    }
                                                    break;
                                                case 4:
                                                    LogLevel logLevel23 = LogLevel.INFO;
                                                    LogHandler currentLogHandler21 = LogWrapperKt.getCurrentLogHandler();
                                                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel23) <= 0) {
                                                        currentLogHandler21.i("[Purchases] - " + logLevel23.name(), (String) function03.invoke());
                                                    }
                                                    break;
                                                case 5:
                                                    LogLevel logLevel24 = LogLevel.DEBUG;
                                                    currentLogHandler19 = LogWrapperKt.getCurrentLogHandler();
                                                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel24) <= 0) {
                                                        str7 = "[Purchases] - " + logLevel24.name();
                                                        str8 = (String) function03.invoke();
                                                        currentLogHandler19.d(str7, str8);
                                                    }
                                                    break;
                                                case 6:
                                                    LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) function03.invoke(), null);
                                                    break;
                                                case 7:
                                                    LogLevel logLevel25 = LogLevel.INFO;
                                                    LogHandler currentLogHandler22 = LogWrapperKt.getCurrentLogHandler();
                                                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel25) <= 0) {
                                                        currentLogHandler22.i("[Purchases] - " + logLevel25.name(), (String) function03.invoke());
                                                    }
                                                    break;
                                                case 8:
                                                    LogLevel logLevel26 = LogLevel.DEBUG;
                                                    currentLogHandler19 = LogWrapperKt.getCurrentLogHandler();
                                                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel26) <= 0) {
                                                        str7 = "[Purchases] - " + logLevel26.name();
                                                        str8 = (String) function03.invoke();
                                                        currentLogHandler19.d(str7, str8);
                                                    }
                                                    break;
                                                case 9:
                                                    LogLevel logLevel27 = LogLevel.DEBUG;
                                                    currentLogHandler19 = LogWrapperKt.getCurrentLogHandler();
                                                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel27) <= 0) {
                                                        str7 = "[Purchases] - " + logLevel27.name();
                                                        str8 = (String) function03.invoke();
                                                        currentLogHandler19.d(str7, str8);
                                                    }
                                                    break;
                                                case 10:
                                                    LogLevel logLevel28 = LogLevel.WARN;
                                                    LogHandler currentLogHandler23 = LogWrapperKt.getCurrentLogHandler();
                                                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel28) <= 0) {
                                                        currentLogHandler23.w("[Purchases] - " + logLevel28.name(), (String) function03.invoke());
                                                    }
                                                    break;
                                                case 11:
                                                    LogLevel logLevel29 = LogLevel.WARN;
                                                    LogHandler currentLogHandler24 = LogWrapperKt.getCurrentLogHandler();
                                                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel29) <= 0) {
                                                        currentLogHandler24.w("[Purchases] - " + logLevel29.name(), (String) function03.invoke());
                                                    }
                                                    break;
                                                case 12:
                                                    LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) function03.invoke(), null);
                                                    break;
                                                case 13:
                                                    LogLevel logLevel30 = LogLevel.WARN;
                                                    LogHandler currentLogHandler25 = LogWrapperKt.getCurrentLogHandler();
                                                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel30) <= 0) {
                                                        currentLogHandler25.w("[Purchases] - " + logLevel30.name(), (String) function03.invoke());
                                                    }
                                                    break;
                                                case 14:
                                                    LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) function03.invoke(), null);
                                                    break;
                                            }
                                            if (Intrinsics.areEqual(CollectionsKt.last((List) listSortedWith), storeTransaction)) {
                                                PurchasesOrchestrator purchasesOrchestrator3 = purchasesOrchestrator2;
                                                final ReceiveCustomerInfoCallback receiveCustomerInfoCallback3 = receiveCustomerInfoCallback2;
                                                purchasesOrchestrator3.dispatch(new Function0<Unit>() { // from class: com.revenuecat.purchases.PurchasesOrchestrator$restorePurchases$4$1$3$1$2.2
                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                    {
                                                        super(0);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function0
                                                    public /* bridge */ /* synthetic */ Object invoke() {
                                                        m465invoke();
                                                        return Unit.f139807a;
                                                    }

                                                    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
                                                    public final void m465invoke() {
                                                        receiveCustomerInfoCallback3.onError(error);
                                                    }
                                                });
                                            }
                                        }
                                    });
                                }
                                return;
                            }
                            final LogIntent logIntent3 = LogIntent.DEBUG;
                            Function0<String> function03 = new Function0<String>() { // from class: com.revenuecat.purchases.PurchasesOrchestrator$restorePurchases$4$1$invoke$$inlined$log$1
                                {
                                    super(0);
                                }

                                @Override // kotlin.jvm.functions.Function0
                                public final String invoke() {
                                    return CollectionsKt.joinToString$default(logIntent3.getEmojiList(), "", null, null, 0, null, null, 62, null) + ' ' + RestoreStrings.RESTORE_PURCHASES_NO_PURCHASES_FOUND;
                                }
                            };
                            switch (LogWrapperKt.WhenMappings.$EnumSwitchMapping$0[logIntent3.ordinal()]) {
                                case 1:
                                    LogLevel logLevel21 = LogLevel.DEBUG;
                                    currentLogHandler18 = LogWrapperKt.getCurrentLogHandler();
                                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel21) <= 0) {
                                        str4 = "[Purchases] - " + logLevel21.name();
                                        str5 = (String) function03.invoke();
                                        currentLogHandler18.d(str4, str5);
                                    }
                                    break;
                                case 2:
                                    LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) function03.invoke(), null);
                                    break;
                                case 3:
                                    LogLevel logLevel22 = LogLevel.WARN;
                                    LogHandler currentLogHandler19 = LogWrapperKt.getCurrentLogHandler();
                                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel22) <= 0) {
                                        currentLogHandler19.w("[Purchases] - " + logLevel22.name(), (String) function03.invoke());
                                    }
                                    break;
                                case 4:
                                    LogLevel logLevel23 = LogLevel.INFO;
                                    LogHandler currentLogHandler20 = LogWrapperKt.getCurrentLogHandler();
                                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel23) <= 0) {
                                        currentLogHandler20.i("[Purchases] - " + logLevel23.name(), (String) function03.invoke());
                                    }
                                    break;
                                case 5:
                                    LogLevel logLevel24 = LogLevel.DEBUG;
                                    currentLogHandler18 = LogWrapperKt.getCurrentLogHandler();
                                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel24) <= 0) {
                                        str4 = "[Purchases] - " + logLevel24.name();
                                        str5 = (String) function03.invoke();
                                        currentLogHandler18.d(str4, str5);
                                    }
                                    break;
                                case 6:
                                    LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) function03.invoke(), null);
                                    break;
                                case 7:
                                    LogLevel logLevel25 = LogLevel.INFO;
                                    LogHandler currentLogHandler21 = LogWrapperKt.getCurrentLogHandler();
                                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel25) <= 0) {
                                        currentLogHandler21.i("[Purchases] - " + logLevel25.name(), (String) function03.invoke());
                                    }
                                    break;
                                case 8:
                                    LogLevel logLevel26 = LogLevel.DEBUG;
                                    currentLogHandler18 = LogWrapperKt.getCurrentLogHandler();
                                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel26) <= 0) {
                                        str4 = "[Purchases] - " + logLevel26.name();
                                        str5 = (String) function03.invoke();
                                        currentLogHandler18.d(str4, str5);
                                    }
                                    break;
                                case 9:
                                    LogLevel logLevel27 = LogLevel.DEBUG;
                                    currentLogHandler18 = LogWrapperKt.getCurrentLogHandler();
                                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel27) <= 0) {
                                        str4 = "[Purchases] - " + logLevel27.name();
                                        str5 = (String) function03.invoke();
                                        currentLogHandler18.d(str4, str5);
                                    }
                                    break;
                                case 10:
                                    LogLevel logLevel28 = LogLevel.WARN;
                                    LogHandler currentLogHandler22 = LogWrapperKt.getCurrentLogHandler();
                                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel28) <= 0) {
                                        currentLogHandler22.w("[Purchases] - " + logLevel28.name(), (String) function03.invoke());
                                    }
                                    break;
                                case 11:
                                    LogLevel logLevel29 = LogLevel.WARN;
                                    LogHandler currentLogHandler23 = LogWrapperKt.getCurrentLogHandler();
                                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel29) <= 0) {
                                        currentLogHandler23.w("[Purchases] - " + logLevel29.name(), (String) function03.invoke());
                                    }
                                    break;
                                case 12:
                                    LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) function03.invoke(), null);
                                    break;
                                case 13:
                                    LogLevel logLevel30 = LogLevel.WARN;
                                    LogHandler currentLogHandler24 = LogWrapperKt.getCurrentLogHandler();
                                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel30) <= 0) {
                                        currentLogHandler24.w("[Purchases] - " + logLevel30.name(), (String) function03.invoke());
                                    }
                                    break;
                                case 14:
                                    LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) function03.invoke(), null);
                                    break;
                            }
                            purchasesOrchestrator.getCustomerInfo(receiveCustomerInfoCallback);
                        }
                    };
                    final PurchasesOrchestrator purchasesOrchestrator2 = PurchasesOrchestrator.this;
                    final ReceiveCustomerInfoCallback receiveCustomerInfoCallback2 = callback;
                    billingAbstract.queryAllPurchases(str3, function1, new Function1<PurchasesError, Unit>() { // from class: com.revenuecat.purchases.PurchasesOrchestrator.restorePurchases.4.2
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                            invoke((PurchasesError) obj);
                            return Unit.f139807a;
                        }

                        public final void invoke(final PurchasesError error) {
                            Intrinsics.checkNotNullParameter(error, "error");
                            PurchasesOrchestrator purchasesOrchestrator3 = purchasesOrchestrator2;
                            final ReceiveCustomerInfoCallback receiveCustomerInfoCallback3 = receiveCustomerInfoCallback2;
                            purchasesOrchestrator3.dispatch(new Function0<Unit>() { // from class: com.revenuecat.purchases.PurchasesOrchestrator.restorePurchases.4.2.1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(0);
                                }

                                @Override // kotlin.jvm.functions.Function0
                                public /* bridge */ /* synthetic */ Object invoke() {
                                    m466invoke();
                                    return Unit.f139807a;
                                }

                                /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
                                public final void m466invoke() {
                                    receiveCustomerInfoCallback3.onError(error);
                                }
                            });
                        }
                    });
                }
            });
            return;
        }
        Function0<String> function03 = new Function0<String>() { // from class: com.revenuecat.purchases.PurchasesOrchestrator$restorePurchases$$inlined$log$3
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                return CollectionsKt.joinToString$default(logIntent.getEmojiList(), "", null, null, 0, null, null, 62, null) + ' ' + RestoreStrings.RESTORE_PURCHASES_SIMULATED_STORE;
            }
        };
        switch (iArr[logIntent.ordinal()]) {
            case 1:
                LogLevel logLevel21 = LogLevel.DEBUG;
                LogHandler currentLogHandler18 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel21) <= 0) {
                    currentLogHandler18.d("[Purchases] - " + logLevel21.name(), (String) function03.invoke());
                }
                break;
            case 2:
                LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) function03.invoke(), null);
                break;
            case 3:
                LogLevel logLevel22 = LogLevel.WARN;
                LogHandler currentLogHandler19 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel22) <= 0) {
                    currentLogHandler19.w("[Purchases] - " + logLevel22.name(), (String) function03.invoke());
                }
                break;
            case 4:
                LogLevel logLevel23 = LogLevel.INFO;
                LogHandler currentLogHandler20 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel23) <= 0) {
                    currentLogHandler20.i("[Purchases] - " + logLevel23.name(), (String) function03.invoke());
                }
                break;
            case 5:
                LogLevel logLevel24 = LogLevel.DEBUG;
                LogHandler currentLogHandler21 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel24) <= 0) {
                    currentLogHandler21.d("[Purchases] - " + logLevel24.name(), (String) function03.invoke());
                }
                break;
            case 6:
                LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) function03.invoke(), null);
                break;
            case 7:
                LogLevel logLevel25 = LogLevel.INFO;
                LogHandler currentLogHandler22 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel25) <= 0) {
                    currentLogHandler22.i("[Purchases] - " + logLevel25.name(), (String) function03.invoke());
                }
                break;
            case 8:
                LogLevel logLevel26 = LogLevel.DEBUG;
                LogHandler currentLogHandler23 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel26) <= 0) {
                    currentLogHandler23.d("[Purchases] - " + logLevel26.name(), (String) function03.invoke());
                }
                break;
            case 9:
                LogLevel logLevel27 = LogLevel.DEBUG;
                LogHandler currentLogHandler24 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel27) <= 0) {
                    currentLogHandler24.d("[Purchases] - " + logLevel27.name(), (String) function03.invoke());
                }
                break;
            case 10:
                LogLevel logLevel28 = LogLevel.WARN;
                LogHandler currentLogHandler25 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel28) <= 0) {
                    currentLogHandler25.w("[Purchases] - " + logLevel28.name(), (String) function03.invoke());
                }
                break;
            case 11:
                LogLevel logLevel29 = LogLevel.WARN;
                LogHandler currentLogHandler26 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel29) <= 0) {
                    currentLogHandler26.w("[Purchases] - " + logLevel29.name(), (String) function03.invoke());
                }
                break;
            case 12:
                LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) function03.invoke(), null);
                break;
            case 13:
                LogLevel logLevel30 = LogLevel.WARN;
                LogHandler currentLogHandler27 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel30) <= 0) {
                    currentLogHandler27.w("[Purchases] - " + logLevel30.name(), (String) function03.invoke());
                }
                break;
            case 14:
                LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) function03.invoke(), null);
                break;
        }
        getCustomerInfo(callback);
    }

    public final void setAd(String str) {
        LogHandler currentLogHandler;
        String str2;
        String str3;
        final LogIntent logIntent = LogIntent.DEBUG;
        Function0<String> function0 = new Function0<String>() { // from class: com.revenuecat.purchases.PurchasesOrchestrator$setAd$$inlined$log$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                StringBuilder sb = new StringBuilder();
                sb.append(CollectionsKt.joinToString$default(logIntent.getEmojiList(), "", null, null, 0, null, null, 62, null));
                sb.append(' ');
                String str4 = String.format(AttributionStrings.METHOD_CALLED, Arrays.copyOf(new Object[]{"setAd"}, 1));
                Intrinsics.checkNotNullExpressionValue(str4, "format(...)");
                sb.append(str4);
                return sb.toString();
            }
        };
        switch (LogWrapperKt.WhenMappings.$EnumSwitchMapping$0[logIntent.ordinal()]) {
            case 1:
                LogLevel logLevel = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                    str2 = "[Purchases] - " + logLevel.name();
                    str3 = (String) function0.invoke();
                    currentLogHandler.d(str2, str3);
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
                    str2 = "[Purchases] - " + logLevel4.name();
                    str3 = (String) function0.invoke();
                    currentLogHandler.d(str2, str3);
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
                    str2 = "[Purchases] - " + logLevel6.name();
                    str3 = (String) function0.invoke();
                    currentLogHandler.d(str2, str3);
                }
                break;
            case 9:
                LogLevel logLevel7 = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel7) <= 0) {
                    str2 = "[Purchases] - " + logLevel7.name();
                    str3 = (String) function0.invoke();
                    currentLogHandler.d(str2, str3);
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
        this.subscriberAttributesManager.setAttribute(SubscriberAttributeKey.CampaignParameters.Ad.INSTANCE, str, getAppUserID());
    }

    public final void setAdGroup(String str) {
        LogHandler currentLogHandler;
        String str2;
        String str3;
        final LogIntent logIntent = LogIntent.DEBUG;
        Function0<String> function0 = new Function0<String>() { // from class: com.revenuecat.purchases.PurchasesOrchestrator$setAdGroup$$inlined$log$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                StringBuilder sb = new StringBuilder();
                sb.append(CollectionsKt.joinToString$default(logIntent.getEmojiList(), "", null, null, 0, null, null, 62, null));
                sb.append(' ');
                String str4 = String.format(AttributionStrings.METHOD_CALLED, Arrays.copyOf(new Object[]{"setAdGroup"}, 1));
                Intrinsics.checkNotNullExpressionValue(str4, "format(...)");
                sb.append(str4);
                return sb.toString();
            }
        };
        switch (LogWrapperKt.WhenMappings.$EnumSwitchMapping$0[logIntent.ordinal()]) {
            case 1:
                LogLevel logLevel = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                    str2 = "[Purchases] - " + logLevel.name();
                    str3 = (String) function0.invoke();
                    currentLogHandler.d(str2, str3);
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
                    str2 = "[Purchases] - " + logLevel4.name();
                    str3 = (String) function0.invoke();
                    currentLogHandler.d(str2, str3);
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
                    str2 = "[Purchases] - " + logLevel6.name();
                    str3 = (String) function0.invoke();
                    currentLogHandler.d(str2, str3);
                }
                break;
            case 9:
                LogLevel logLevel7 = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel7) <= 0) {
                    str2 = "[Purchases] - " + logLevel7.name();
                    str3 = (String) function0.invoke();
                    currentLogHandler.d(str2, str3);
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
        this.subscriberAttributesManager.setAttribute(SubscriberAttributeKey.CampaignParameters.AdGroup.INSTANCE, str, getAppUserID());
    }

    public final void setAdjustID(String str) {
        LogHandler currentLogHandler;
        String str2;
        String str3;
        final LogIntent logIntent = LogIntent.DEBUG;
        Function0<String> function0 = new Function0<String>() { // from class: com.revenuecat.purchases.PurchasesOrchestrator$setAdjustID$$inlined$log$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                StringBuilder sb = new StringBuilder();
                sb.append(CollectionsKt.joinToString$default(logIntent.getEmojiList(), "", null, null, 0, null, null, 62, null));
                sb.append(' ');
                String str4 = String.format(AttributionStrings.METHOD_CALLED, Arrays.copyOf(new Object[]{"setAdjustID"}, 1));
                Intrinsics.checkNotNullExpressionValue(str4, "format(...)");
                sb.append(str4);
                return sb.toString();
            }
        };
        switch (LogWrapperKt.WhenMappings.$EnumSwitchMapping$0[logIntent.ordinal()]) {
            case 1:
                LogLevel logLevel = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                    str2 = "[Purchases] - " + logLevel.name();
                    str3 = (String) function0.invoke();
                    currentLogHandler.d(str2, str3);
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
                    str2 = "[Purchases] - " + logLevel4.name();
                    str3 = (String) function0.invoke();
                    currentLogHandler.d(str2, str3);
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
                    str2 = "[Purchases] - " + logLevel6.name();
                    str3 = (String) function0.invoke();
                    currentLogHandler.d(str2, str3);
                }
                break;
            case 9:
                LogLevel logLevel7 = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel7) <= 0) {
                    str2 = "[Purchases] - " + logLevel7.name();
                    str3 = (String) function0.invoke();
                    currentLogHandler.d(str2, str3);
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
        this.subscriberAttributesManager.setAttributionID(SubscriberAttributeKey.AttributionIds.Adjust.INSTANCE, str, getAppUserID(), this.application);
    }

    public final void setAirbridgeDeviceID(String str) {
        LogHandler currentLogHandler;
        String str2;
        String str3;
        final LogIntent logIntent = LogIntent.DEBUG;
        Function0<String> function0 = new Function0<String>() { // from class: com.revenuecat.purchases.PurchasesOrchestrator$setAirbridgeDeviceID$$inlined$log$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                StringBuilder sb = new StringBuilder();
                sb.append(CollectionsKt.joinToString$default(logIntent.getEmojiList(), "", null, null, 0, null, null, 62, null));
                sb.append(' ');
                String str4 = String.format(AttributionStrings.METHOD_CALLED, Arrays.copyOf(new Object[]{"setAirbridgeDeviceID"}, 1));
                Intrinsics.checkNotNullExpressionValue(str4, "format(...)");
                sb.append(str4);
                return sb.toString();
            }
        };
        switch (LogWrapperKt.WhenMappings.$EnumSwitchMapping$0[logIntent.ordinal()]) {
            case 1:
                LogLevel logLevel = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                    str2 = "[Purchases] - " + logLevel.name();
                    str3 = (String) function0.invoke();
                    currentLogHandler.d(str2, str3);
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
                    str2 = "[Purchases] - " + logLevel4.name();
                    str3 = (String) function0.invoke();
                    currentLogHandler.d(str2, str3);
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
                    str2 = "[Purchases] - " + logLevel6.name();
                    str3 = (String) function0.invoke();
                    currentLogHandler.d(str2, str3);
                }
                break;
            case 9:
                LogLevel logLevel7 = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel7) <= 0) {
                    str2 = "[Purchases] - " + logLevel7.name();
                    str3 = (String) function0.invoke();
                    currentLogHandler.d(str2, str3);
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
        this.subscriberAttributesManager.setAttributionID(SubscriberAttributeKey.AttributionIds.Airbridge.INSTANCE, str, getAppUserID(), this.application);
    }

    public final void setAirshipChannelID(String str) {
        LogHandler currentLogHandler;
        String str2;
        String str3;
        final LogIntent logIntent = LogIntent.DEBUG;
        Function0<String> function0 = new Function0<String>() { // from class: com.revenuecat.purchases.PurchasesOrchestrator$setAirshipChannelID$$inlined$log$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                StringBuilder sb = new StringBuilder();
                sb.append(CollectionsKt.joinToString$default(logIntent.getEmojiList(), "", null, null, 0, null, null, 62, null));
                sb.append(' ');
                String str4 = String.format(AttributionStrings.METHOD_CALLED, Arrays.copyOf(new Object[]{"setAirshipChannelID"}, 1));
                Intrinsics.checkNotNullExpressionValue(str4, "format(...)");
                sb.append(str4);
                return sb.toString();
            }
        };
        switch (LogWrapperKt.WhenMappings.$EnumSwitchMapping$0[logIntent.ordinal()]) {
            case 1:
                LogLevel logLevel = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                    str2 = "[Purchases] - " + logLevel.name();
                    str3 = (String) function0.invoke();
                    currentLogHandler.d(str2, str3);
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
                    str2 = "[Purchases] - " + logLevel4.name();
                    str3 = (String) function0.invoke();
                    currentLogHandler.d(str2, str3);
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
                    str2 = "[Purchases] - " + logLevel6.name();
                    str3 = (String) function0.invoke();
                    currentLogHandler.d(str2, str3);
                }
                break;
            case 9:
                LogLevel logLevel7 = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel7) <= 0) {
                    str2 = "[Purchases] - " + logLevel7.name();
                    str3 = (String) function0.invoke();
                    currentLogHandler.d(str2, str3);
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
        this.subscriberAttributesManager.setAttribute(SubscriberAttributeKey.IntegrationIds.Airship.INSTANCE, str, getAppUserID());
    }

    public final synchronized void setAllowSharingPlayStoreAccount(boolean z2) {
        setState$purchases_defaultsBc8Release(PurchasesState.copy$default(getState$purchases_defaultsBc8Release(), Boolean.valueOf(z2), null, null, false, false, 30, null));
    }

    public final void setAppConfig(AppConfig appConfig) {
        Intrinsics.checkNotNullParameter(appConfig, "<set-?>");
        this.appConfig = appConfig;
    }

    public final void setAppsFlyerConversionData(Map<?, ?> map) {
        LogHandler currentLogHandler;
        String str;
        String str2;
        final LogIntent logIntent = LogIntent.DEBUG;
        Function0<String> function0 = new Function0<String>() { // from class: com.revenuecat.purchases.PurchasesOrchestrator$setAppsFlyerConversionData$$inlined$log$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                StringBuilder sb = new StringBuilder();
                sb.append(CollectionsKt.joinToString$default(logIntent.getEmojiList(), "", null, null, 0, null, null, 62, null));
                sb.append(' ');
                String str3 = String.format(AttributionStrings.METHOD_CALLED, Arrays.copyOf(new Object[]{"setAppsFlyerConversionData"}, 1));
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
        this.subscriberAttributesManager.setAppsFlyerConversionData(getAppUserID(), map);
    }

    public final void setAppsflyerID(String str) {
        LogHandler currentLogHandler;
        String str2;
        String str3;
        final LogIntent logIntent = LogIntent.DEBUG;
        Function0<String> function0 = new Function0<String>() { // from class: com.revenuecat.purchases.PurchasesOrchestrator$setAppsflyerID$$inlined$log$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                StringBuilder sb = new StringBuilder();
                sb.append(CollectionsKt.joinToString$default(logIntent.getEmojiList(), "", null, null, 0, null, null, 62, null));
                sb.append(' ');
                String str4 = String.format(AttributionStrings.METHOD_CALLED, Arrays.copyOf(new Object[]{"setAppsflyerID"}, 1));
                Intrinsics.checkNotNullExpressionValue(str4, "format(...)");
                sb.append(str4);
                return sb.toString();
            }
        };
        switch (LogWrapperKt.WhenMappings.$EnumSwitchMapping$0[logIntent.ordinal()]) {
            case 1:
                LogLevel logLevel = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                    str2 = "[Purchases] - " + logLevel.name();
                    str3 = (String) function0.invoke();
                    currentLogHandler.d(str2, str3);
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
                    str2 = "[Purchases] - " + logLevel4.name();
                    str3 = (String) function0.invoke();
                    currentLogHandler.d(str2, str3);
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
                    str2 = "[Purchases] - " + logLevel6.name();
                    str3 = (String) function0.invoke();
                    currentLogHandler.d(str2, str3);
                }
                break;
            case 9:
                LogLevel logLevel7 = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel7) <= 0) {
                    str2 = "[Purchases] - " + logLevel7.name();
                    str3 = (String) function0.invoke();
                    currentLogHandler.d(str2, str3);
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
        this.subscriberAttributesManager.setAttributionID(SubscriberAttributeKey.AttributionIds.AppsFlyer.INSTANCE, str, getAppUserID(), this.application);
    }

    public final void setAppstackAttributionParams(Map<String, String> data, SyncAttributesAndOfferingsCallback callback) {
        LogHandler currentLogHandler;
        String str;
        String str2;
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(callback, "callback");
        final LogIntent logIntent = LogIntent.DEBUG;
        Function0<String> function0 = new Function0<String>() { // from class: com.revenuecat.purchases.PurchasesOrchestrator$setAppstackAttributionParams$$inlined$log$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                StringBuilder sb = new StringBuilder();
                sb.append(CollectionsKt.joinToString$default(logIntent.getEmojiList(), "", null, null, 0, null, null, 62, null));
                sb.append(' ');
                String str3 = String.format(AttributionStrings.METHOD_CALLED, Arrays.copyOf(new Object[]{"setAppstackAttributionParams"}, 1));
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
        this.subscriberAttributesManager.setAppstackAttributionParams(getAppUserID(), data, this.application);
        syncAttributesAndOfferingsIfNeeded(callback);
    }

    public final void setAttributes(Map<String, String> attributes) {
        LogHandler currentLogHandler;
        String str;
        String str2;
        Intrinsics.checkNotNullParameter(attributes, "attributes");
        final LogIntent logIntent = LogIntent.DEBUG;
        Function0<String> function0 = new Function0<String>() { // from class: com.revenuecat.purchases.PurchasesOrchestrator$setAttributes$$inlined$log$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                StringBuilder sb = new StringBuilder();
                sb.append(CollectionsKt.joinToString$default(logIntent.getEmojiList(), "", null, null, 0, null, null, 62, null));
                sb.append(' ');
                String str3 = String.format(AttributionStrings.METHOD_CALLED, Arrays.copyOf(new Object[]{"setAttributes"}, 1));
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
        this.subscriberAttributesManager.setAttributes(attributes, getAppUserID());
    }

    public final void setCampaign(String str) {
        LogHandler currentLogHandler;
        String str2;
        String str3;
        final LogIntent logIntent = LogIntent.DEBUG;
        Function0<String> function0 = new Function0<String>() { // from class: com.revenuecat.purchases.PurchasesOrchestrator$setCampaign$$inlined$log$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                StringBuilder sb = new StringBuilder();
                sb.append(CollectionsKt.joinToString$default(logIntent.getEmojiList(), "", null, null, 0, null, null, 62, null));
                sb.append(' ');
                String str4 = String.format(AttributionStrings.METHOD_CALLED, Arrays.copyOf(new Object[]{"setCampaign"}, 1));
                Intrinsics.checkNotNullExpressionValue(str4, "format(...)");
                sb.append(str4);
                return sb.toString();
            }
        };
        switch (LogWrapperKt.WhenMappings.$EnumSwitchMapping$0[logIntent.ordinal()]) {
            case 1:
                LogLevel logLevel = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                    str2 = "[Purchases] - " + logLevel.name();
                    str3 = (String) function0.invoke();
                    currentLogHandler.d(str2, str3);
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
                    str2 = "[Purchases] - " + logLevel4.name();
                    str3 = (String) function0.invoke();
                    currentLogHandler.d(str2, str3);
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
                    str2 = "[Purchases] - " + logLevel6.name();
                    str3 = (String) function0.invoke();
                    currentLogHandler.d(str2, str3);
                }
                break;
            case 9:
                LogLevel logLevel7 = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel7) <= 0) {
                    str2 = "[Purchases] - " + logLevel7.name();
                    str3 = (String) function0.invoke();
                    currentLogHandler.d(str2, str3);
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
        this.subscriberAttributesManager.setAttribute(SubscriberAttributeKey.CampaignParameters.Campaign.INSTANCE, str, getAppUserID());
    }

    public final void setCleverTapID(String str) {
        LogHandler currentLogHandler;
        String str2;
        String str3;
        final LogIntent logIntent = LogIntent.DEBUG;
        Function0<String> function0 = new Function0<String>() { // from class: com.revenuecat.purchases.PurchasesOrchestrator$setCleverTapID$$inlined$log$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                StringBuilder sb = new StringBuilder();
                sb.append(CollectionsKt.joinToString$default(logIntent.getEmojiList(), "", null, null, 0, null, null, 62, null));
                sb.append(' ');
                String str4 = String.format(AttributionStrings.METHOD_CALLED, Arrays.copyOf(new Object[]{"setCleverTapID"}, 1));
                Intrinsics.checkNotNullExpressionValue(str4, "format(...)");
                sb.append(str4);
                return sb.toString();
            }
        };
        switch (LogWrapperKt.WhenMappings.$EnumSwitchMapping$0[logIntent.ordinal()]) {
            case 1:
                LogLevel logLevel = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                    str2 = "[Purchases] - " + logLevel.name();
                    str3 = (String) function0.invoke();
                    currentLogHandler.d(str2, str3);
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
                    str2 = "[Purchases] - " + logLevel4.name();
                    str3 = (String) function0.invoke();
                    currentLogHandler.d(str2, str3);
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
                    str2 = "[Purchases] - " + logLevel6.name();
                    str3 = (String) function0.invoke();
                    currentLogHandler.d(str2, str3);
                }
                break;
            case 9:
                LogLevel logLevel7 = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel7) <= 0) {
                    str2 = "[Purchases] - " + logLevel7.name();
                    str3 = (String) function0.invoke();
                    currentLogHandler.d(str2, str3);
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
        this.subscriberAttributesManager.setAttributionID(SubscriberAttributeKey.AttributionIds.CleverTap.INSTANCE, str, getAppUserID(), this.application);
    }

    public final void setCreative(String str) {
        LogHandler currentLogHandler;
        String str2;
        String str3;
        final LogIntent logIntent = LogIntent.DEBUG;
        Function0<String> function0 = new Function0<String>() { // from class: com.revenuecat.purchases.PurchasesOrchestrator$setCreative$$inlined$log$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                StringBuilder sb = new StringBuilder();
                sb.append(CollectionsKt.joinToString$default(logIntent.getEmojiList(), "", null, null, 0, null, null, 62, null));
                sb.append(' ');
                String str4 = String.format(AttributionStrings.METHOD_CALLED, Arrays.copyOf(new Object[]{"setCreative"}, 1));
                Intrinsics.checkNotNullExpressionValue(str4, "format(...)");
                sb.append(str4);
                return sb.toString();
            }
        };
        switch (LogWrapperKt.WhenMappings.$EnumSwitchMapping$0[logIntent.ordinal()]) {
            case 1:
                LogLevel logLevel = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                    str2 = "[Purchases] - " + logLevel.name();
                    str3 = (String) function0.invoke();
                    currentLogHandler.d(str2, str3);
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
                    str2 = "[Purchases] - " + logLevel4.name();
                    str3 = (String) function0.invoke();
                    currentLogHandler.d(str2, str3);
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
                    str2 = "[Purchases] - " + logLevel6.name();
                    str3 = (String) function0.invoke();
                    currentLogHandler.d(str2, str3);
                }
                break;
            case 9:
                LogLevel logLevel7 = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel7) <= 0) {
                    str2 = "[Purchases] - " + logLevel7.name();
                    str3 = (String) function0.invoke();
                    currentLogHandler.d(str2, str3);
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
        this.subscriberAttributesManager.setAttribute(SubscriberAttributeKey.CampaignParameters.Creative.INSTANCE, str, getAppUserID());
    }

    public final synchronized void setCustomerCenterListener(CustomerCenterListener customerCenterListener) {
        this.customerCenterListener = customerCenterListener;
    }

    public final synchronized void setDebugEventListener(DebugEventListener debugEventListener) {
        this.eventsManager.setDebugEventListener(debugEventListener);
    }

    public final void setDisplayName(String str) {
        LogHandler currentLogHandler;
        String str2;
        String str3;
        final LogIntent logIntent = LogIntent.DEBUG;
        Function0<String> function0 = new Function0<String>() { // from class: com.revenuecat.purchases.PurchasesOrchestrator$setDisplayName$$inlined$log$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                StringBuilder sb = new StringBuilder();
                sb.append(CollectionsKt.joinToString$default(logIntent.getEmojiList(), "", null, null, 0, null, null, 62, null));
                sb.append(' ');
                String str4 = String.format(AttributionStrings.METHOD_CALLED, Arrays.copyOf(new Object[]{"setDisplayName"}, 1));
                Intrinsics.checkNotNullExpressionValue(str4, "format(...)");
                sb.append(str4);
                return sb.toString();
            }
        };
        switch (LogWrapperKt.WhenMappings.$EnumSwitchMapping$0[logIntent.ordinal()]) {
            case 1:
                LogLevel logLevel = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                    str2 = "[Purchases] - " + logLevel.name();
                    str3 = (String) function0.invoke();
                    currentLogHandler.d(str2, str3);
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
                    str2 = "[Purchases] - " + logLevel4.name();
                    str3 = (String) function0.invoke();
                    currentLogHandler.d(str2, str3);
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
                    str2 = "[Purchases] - " + logLevel6.name();
                    str3 = (String) function0.invoke();
                    currentLogHandler.d(str2, str3);
                }
                break;
            case 9:
                LogLevel logLevel7 = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel7) <= 0) {
                    str2 = "[Purchases] - " + logLevel7.name();
                    str3 = (String) function0.invoke();
                    currentLogHandler.d(str2, str3);
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
        this.subscriberAttributesManager.setAttribute(SubscriberAttributeKey.DisplayName.INSTANCE, str, getAppUserID());
    }

    public final void setEmail(String str) {
        LogHandler currentLogHandler;
        String str2;
        String str3;
        final LogIntent logIntent = LogIntent.DEBUG;
        Function0<String> function0 = new Function0<String>() { // from class: com.revenuecat.purchases.PurchasesOrchestrator$setEmail$$inlined$log$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                StringBuilder sb = new StringBuilder();
                sb.append(CollectionsKt.joinToString$default(logIntent.getEmojiList(), "", null, null, 0, null, null, 62, null));
                sb.append(' ');
                String str4 = String.format(AttributionStrings.METHOD_CALLED, Arrays.copyOf(new Object[]{"setEmail"}, 1));
                Intrinsics.checkNotNullExpressionValue(str4, "format(...)");
                sb.append(str4);
                return sb.toString();
            }
        };
        switch (LogWrapperKt.WhenMappings.$EnumSwitchMapping$0[logIntent.ordinal()]) {
            case 1:
                LogLevel logLevel = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                    str2 = "[Purchases] - " + logLevel.name();
                    str3 = (String) function0.invoke();
                    currentLogHandler.d(str2, str3);
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
                    str2 = "[Purchases] - " + logLevel4.name();
                    str3 = (String) function0.invoke();
                    currentLogHandler.d(str2, str3);
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
                    str2 = "[Purchases] - " + logLevel6.name();
                    str3 = (String) function0.invoke();
                    currentLogHandler.d(str2, str3);
                }
                break;
            case 9:
                LogLevel logLevel7 = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel7) <= 0) {
                    str2 = "[Purchases] - " + logLevel7.name();
                    str3 = (String) function0.invoke();
                    currentLogHandler.d(str2, str3);
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
        this.subscriberAttributesManager.setAttribute(SubscriberAttributeKey.Email.INSTANCE, str, getAppUserID());
    }

    public final void setFBAnonymousID(String str) {
        LogHandler currentLogHandler;
        String str2;
        String str3;
        final LogIntent logIntent = LogIntent.DEBUG;
        Function0<String> function0 = new Function0<String>() { // from class: com.revenuecat.purchases.PurchasesOrchestrator$setFBAnonymousID$$inlined$log$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                StringBuilder sb = new StringBuilder();
                sb.append(CollectionsKt.joinToString$default(logIntent.getEmojiList(), "", null, null, 0, null, null, 62, null));
                sb.append(' ');
                String str4 = String.format(AttributionStrings.METHOD_CALLED, Arrays.copyOf(new Object[]{"setFBAnonymousID"}, 1));
                Intrinsics.checkNotNullExpressionValue(str4, "format(...)");
                sb.append(str4);
                return sb.toString();
            }
        };
        switch (LogWrapperKt.WhenMappings.$EnumSwitchMapping$0[logIntent.ordinal()]) {
            case 1:
                LogLevel logLevel = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                    str2 = "[Purchases] - " + logLevel.name();
                    str3 = (String) function0.invoke();
                    currentLogHandler.d(str2, str3);
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
                    str2 = "[Purchases] - " + logLevel4.name();
                    str3 = (String) function0.invoke();
                    currentLogHandler.d(str2, str3);
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
                    str2 = "[Purchases] - " + logLevel6.name();
                    str3 = (String) function0.invoke();
                    currentLogHandler.d(str2, str3);
                }
                break;
            case 9:
                LogLevel logLevel7 = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel7) <= 0) {
                    str2 = "[Purchases] - " + logLevel7.name();
                    str3 = (String) function0.invoke();
                    currentLogHandler.d(str2, str3);
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
        this.subscriberAttributesManager.setAttributionID(SubscriberAttributeKey.AttributionIds.Facebook.INSTANCE, str, getAppUserID(), this.application);
    }

    public final synchronized void setFinishTransactions(boolean z2) {
        this.appConfig.setFinishTransactions(z2);
    }

    public final void setFirebaseAppInstanceID(String str) {
        LogHandler currentLogHandler;
        String str2;
        String str3;
        final LogIntent logIntent = LogIntent.DEBUG;
        Function0<String> function0 = new Function0<String>() { // from class: com.revenuecat.purchases.PurchasesOrchestrator$setFirebaseAppInstanceID$$inlined$log$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                StringBuilder sb = new StringBuilder();
                sb.append(CollectionsKt.joinToString$default(logIntent.getEmojiList(), "", null, null, 0, null, null, 62, null));
                sb.append(' ');
                String str4 = String.format(AttributionStrings.METHOD_CALLED, Arrays.copyOf(new Object[]{"setFirebaseAppInstanceID"}, 1));
                Intrinsics.checkNotNullExpressionValue(str4, "format(...)");
                sb.append(str4);
                return sb.toString();
            }
        };
        switch (LogWrapperKt.WhenMappings.$EnumSwitchMapping$0[logIntent.ordinal()]) {
            case 1:
                LogLevel logLevel = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                    str2 = "[Purchases] - " + logLevel.name();
                    str3 = (String) function0.invoke();
                    currentLogHandler.d(str2, str3);
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
                    str2 = "[Purchases] - " + logLevel4.name();
                    str3 = (String) function0.invoke();
                    currentLogHandler.d(str2, str3);
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
                    str2 = "[Purchases] - " + logLevel6.name();
                    str3 = (String) function0.invoke();
                    currentLogHandler.d(str2, str3);
                }
                break;
            case 9:
                LogLevel logLevel7 = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel7) <= 0) {
                    str2 = "[Purchases] - " + logLevel7.name();
                    str3 = (String) function0.invoke();
                    currentLogHandler.d(str2, str3);
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
        this.subscriberAttributesManager.setAttribute(SubscriberAttributeKey.IntegrationIds.FirebaseAppInstanceId.INSTANCE, str, getAppUserID());
    }

    public final void setKeyword(String str) {
        LogHandler currentLogHandler;
        String str2;
        String str3;
        final LogIntent logIntent = LogIntent.DEBUG;
        Function0<String> function0 = new Function0<String>() { // from class: com.revenuecat.purchases.PurchasesOrchestrator$setKeyword$$inlined$log$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                StringBuilder sb = new StringBuilder();
                sb.append(CollectionsKt.joinToString$default(logIntent.getEmojiList(), "", null, null, 0, null, null, 62, null));
                sb.append(' ');
                String str4 = String.format(AttributionStrings.METHOD_CALLED, Arrays.copyOf(new Object[]{"seKeyword"}, 1));
                Intrinsics.checkNotNullExpressionValue(str4, "format(...)");
                sb.append(str4);
                return sb.toString();
            }
        };
        switch (LogWrapperKt.WhenMappings.$EnumSwitchMapping$0[logIntent.ordinal()]) {
            case 1:
                LogLevel logLevel = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                    str2 = "[Purchases] - " + logLevel.name();
                    str3 = (String) function0.invoke();
                    currentLogHandler.d(str2, str3);
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
                    str2 = "[Purchases] - " + logLevel4.name();
                    str3 = (String) function0.invoke();
                    currentLogHandler.d(str2, str3);
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
                    str2 = "[Purchases] - " + logLevel6.name();
                    str3 = (String) function0.invoke();
                    currentLogHandler.d(str2, str3);
                }
                break;
            case 9:
                LogLevel logLevel7 = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel7) <= 0) {
                    str2 = "[Purchases] - " + logLevel7.name();
                    str3 = (String) function0.invoke();
                    currentLogHandler.d(str2, str3);
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
        this.subscriberAttributesManager.setAttribute(SubscriberAttributeKey.CampaignParameters.Keyword.INSTANCE, str, getAppUserID());
    }

    public final void setKochavaDeviceID(String str) {
        LogHandler currentLogHandler;
        String str2;
        String str3;
        final LogIntent logIntent = LogIntent.DEBUG;
        Function0<String> function0 = new Function0<String>() { // from class: com.revenuecat.purchases.PurchasesOrchestrator$setKochavaDeviceID$$inlined$log$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                StringBuilder sb = new StringBuilder();
                sb.append(CollectionsKt.joinToString$default(logIntent.getEmojiList(), "", null, null, 0, null, null, 62, null));
                sb.append(' ');
                String str4 = String.format(AttributionStrings.METHOD_CALLED, Arrays.copyOf(new Object[]{"setKochavaDeviceID"}, 1));
                Intrinsics.checkNotNullExpressionValue(str4, "format(...)");
                sb.append(str4);
                return sb.toString();
            }
        };
        switch (LogWrapperKt.WhenMappings.$EnumSwitchMapping$0[logIntent.ordinal()]) {
            case 1:
                LogLevel logLevel = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                    str2 = "[Purchases] - " + logLevel.name();
                    str3 = (String) function0.invoke();
                    currentLogHandler.d(str2, str3);
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
                    str2 = "[Purchases] - " + logLevel4.name();
                    str3 = (String) function0.invoke();
                    currentLogHandler.d(str2, str3);
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
                    str2 = "[Purchases] - " + logLevel6.name();
                    str3 = (String) function0.invoke();
                    currentLogHandler.d(str2, str3);
                }
                break;
            case 9:
                LogLevel logLevel7 = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel7) <= 0) {
                    str2 = "[Purchases] - " + logLevel7.name();
                    str3 = (String) function0.invoke();
                    currentLogHandler.d(str2, str3);
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
        this.subscriberAttributesManager.setAttributionID(SubscriberAttributeKey.AttributionIds.Kochava.INSTANCE, str, getAppUserID(), this.application);
    }

    public final void setMediaSource(String str) {
        LogHandler currentLogHandler;
        String str2;
        String str3;
        final LogIntent logIntent = LogIntent.DEBUG;
        Function0<String> function0 = new Function0<String>() { // from class: com.revenuecat.purchases.PurchasesOrchestrator$setMediaSource$$inlined$log$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                StringBuilder sb = new StringBuilder();
                sb.append(CollectionsKt.joinToString$default(logIntent.getEmojiList(), "", null, null, 0, null, null, 62, null));
                sb.append(' ');
                String str4 = String.format(AttributionStrings.METHOD_CALLED, Arrays.copyOf(new Object[]{"setMediaSource"}, 1));
                Intrinsics.checkNotNullExpressionValue(str4, "format(...)");
                sb.append(str4);
                return sb.toString();
            }
        };
        switch (LogWrapperKt.WhenMappings.$EnumSwitchMapping$0[logIntent.ordinal()]) {
            case 1:
                LogLevel logLevel = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                    str2 = "[Purchases] - " + logLevel.name();
                    str3 = (String) function0.invoke();
                    currentLogHandler.d(str2, str3);
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
                    str2 = "[Purchases] - " + logLevel4.name();
                    str3 = (String) function0.invoke();
                    currentLogHandler.d(str2, str3);
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
                    str2 = "[Purchases] - " + logLevel6.name();
                    str3 = (String) function0.invoke();
                    currentLogHandler.d(str2, str3);
                }
                break;
            case 9:
                LogLevel logLevel7 = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel7) <= 0) {
                    str2 = "[Purchases] - " + logLevel7.name();
                    str3 = (String) function0.invoke();
                    currentLogHandler.d(str2, str3);
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
        this.subscriberAttributesManager.setAttribute(SubscriberAttributeKey.CampaignParameters.MediaSource.INSTANCE, str, getAppUserID());
    }

    public final void setMixpanelDistinctID(String str) {
        LogHandler currentLogHandler;
        String str2;
        String str3;
        final LogIntent logIntent = LogIntent.DEBUG;
        Function0<String> function0 = new Function0<String>() { // from class: com.revenuecat.purchases.PurchasesOrchestrator$setMixpanelDistinctID$$inlined$log$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                StringBuilder sb = new StringBuilder();
                sb.append(CollectionsKt.joinToString$default(logIntent.getEmojiList(), "", null, null, 0, null, null, 62, null));
                sb.append(' ');
                String str4 = String.format(AttributionStrings.METHOD_CALLED, Arrays.copyOf(new Object[]{"setMixpanelDistinctID"}, 1));
                Intrinsics.checkNotNullExpressionValue(str4, "format(...)");
                sb.append(str4);
                return sb.toString();
            }
        };
        switch (LogWrapperKt.WhenMappings.$EnumSwitchMapping$0[logIntent.ordinal()]) {
            case 1:
                LogLevel logLevel = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                    str2 = "[Purchases] - " + logLevel.name();
                    str3 = (String) function0.invoke();
                    currentLogHandler.d(str2, str3);
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
                    str2 = "[Purchases] - " + logLevel4.name();
                    str3 = (String) function0.invoke();
                    currentLogHandler.d(str2, str3);
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
                    str2 = "[Purchases] - " + logLevel6.name();
                    str3 = (String) function0.invoke();
                    currentLogHandler.d(str2, str3);
                }
                break;
            case 9:
                LogLevel logLevel7 = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel7) <= 0) {
                    str2 = "[Purchases] - " + logLevel7.name();
                    str3 = (String) function0.invoke();
                    currentLogHandler.d(str2, str3);
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
        this.subscriberAttributesManager.setAttribute(SubscriberAttributeKey.IntegrationIds.MixpanelDistinctId.INSTANCE, str, getAppUserID());
    }

    public final void setMparticleID(String str) {
        LogHandler currentLogHandler;
        String str2;
        String str3;
        final LogIntent logIntent = LogIntent.DEBUG;
        Function0<String> function0 = new Function0<String>() { // from class: com.revenuecat.purchases.PurchasesOrchestrator$setMparticleID$$inlined$log$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                StringBuilder sb = new StringBuilder();
                sb.append(CollectionsKt.joinToString$default(logIntent.getEmojiList(), "", null, null, 0, null, null, 62, null));
                sb.append(' ');
                String str4 = String.format(AttributionStrings.METHOD_CALLED, Arrays.copyOf(new Object[]{"setMparticleID"}, 1));
                Intrinsics.checkNotNullExpressionValue(str4, "format(...)");
                sb.append(str4);
                return sb.toString();
            }
        };
        switch (LogWrapperKt.WhenMappings.$EnumSwitchMapping$0[logIntent.ordinal()]) {
            case 1:
                LogLevel logLevel = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                    str2 = "[Purchases] - " + logLevel.name();
                    str3 = (String) function0.invoke();
                    currentLogHandler.d(str2, str3);
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
                    str2 = "[Purchases] - " + logLevel4.name();
                    str3 = (String) function0.invoke();
                    currentLogHandler.d(str2, str3);
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
                    str2 = "[Purchases] - " + logLevel6.name();
                    str3 = (String) function0.invoke();
                    currentLogHandler.d(str2, str3);
                }
                break;
            case 9:
                LogLevel logLevel7 = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel7) <= 0) {
                    str2 = "[Purchases] - " + logLevel7.name();
                    str3 = (String) function0.invoke();
                    currentLogHandler.d(str2, str3);
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
        this.subscriberAttributesManager.setAttributionID(SubscriberAttributeKey.AttributionIds.Mparticle.INSTANCE, str, getAppUserID(), this.application);
    }

    public final void setOnesignalID(String str) {
        LogHandler currentLogHandler;
        String str2;
        String str3;
        final LogIntent logIntent = LogIntent.DEBUG;
        Function0<String> function0 = new Function0<String>() { // from class: com.revenuecat.purchases.PurchasesOrchestrator$setOnesignalID$$inlined$log$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                StringBuilder sb = new StringBuilder();
                sb.append(CollectionsKt.joinToString$default(logIntent.getEmojiList(), "", null, null, 0, null, null, 62, null));
                sb.append(' ');
                String str4 = String.format(AttributionStrings.METHOD_CALLED, Arrays.copyOf(new Object[]{"setOnesignalID"}, 1));
                Intrinsics.checkNotNullExpressionValue(str4, "format(...)");
                sb.append(str4);
                return sb.toString();
            }
        };
        switch (LogWrapperKt.WhenMappings.$EnumSwitchMapping$0[logIntent.ordinal()]) {
            case 1:
                LogLevel logLevel = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                    str2 = "[Purchases] - " + logLevel.name();
                    str3 = (String) function0.invoke();
                    currentLogHandler.d(str2, str3);
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
                    str2 = "[Purchases] - " + logLevel4.name();
                    str3 = (String) function0.invoke();
                    currentLogHandler.d(str2, str3);
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
                    str2 = "[Purchases] - " + logLevel6.name();
                    str3 = (String) function0.invoke();
                    currentLogHandler.d(str2, str3);
                }
                break;
            case 9:
                LogLevel logLevel7 = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel7) <= 0) {
                    str2 = "[Purchases] - " + logLevel7.name();
                    str3 = (String) function0.invoke();
                    currentLogHandler.d(str2, str3);
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
        this.subscriberAttributesManager.setAttribute(SubscriberAttributeKey.IntegrationIds.OneSignal.INSTANCE, str, getAppUserID());
    }

    public final void setOnesignalUserID(String str) {
        LogHandler currentLogHandler;
        String str2;
        String str3;
        final LogIntent logIntent = LogIntent.DEBUG;
        Function0<String> function0 = new Function0<String>() { // from class: com.revenuecat.purchases.PurchasesOrchestrator$setOnesignalUserID$$inlined$log$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                StringBuilder sb = new StringBuilder();
                sb.append(CollectionsKt.joinToString$default(logIntent.getEmojiList(), "", null, null, 0, null, null, 62, null));
                sb.append(' ');
                String str4 = String.format(AttributionStrings.METHOD_CALLED, Arrays.copyOf(new Object[]{"setOnesignalUserID"}, 1));
                Intrinsics.checkNotNullExpressionValue(str4, "format(...)");
                sb.append(str4);
                return sb.toString();
            }
        };
        switch (LogWrapperKt.WhenMappings.$EnumSwitchMapping$0[logIntent.ordinal()]) {
            case 1:
                LogLevel logLevel = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                    str2 = "[Purchases] - " + logLevel.name();
                    str3 = (String) function0.invoke();
                    currentLogHandler.d(str2, str3);
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
                    str2 = "[Purchases] - " + logLevel4.name();
                    str3 = (String) function0.invoke();
                    currentLogHandler.d(str2, str3);
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
                    str2 = "[Purchases] - " + logLevel6.name();
                    str3 = (String) function0.invoke();
                    currentLogHandler.d(str2, str3);
                }
                break;
            case 9:
                LogLevel logLevel7 = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel7) <= 0) {
                    str2 = "[Purchases] - " + logLevel7.name();
                    str3 = (String) function0.invoke();
                    currentLogHandler.d(str2, str3);
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
        this.subscriberAttributesManager.setAttribute(SubscriberAttributeKey.IntegrationIds.OneSignalUserId.INSTANCE, str, getAppUserID());
    }

    public final void setPhoneNumber(String str) {
        LogHandler currentLogHandler;
        String str2;
        String str3;
        final LogIntent logIntent = LogIntent.DEBUG;
        Function0<String> function0 = new Function0<String>() { // from class: com.revenuecat.purchases.PurchasesOrchestrator$setPhoneNumber$$inlined$log$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                StringBuilder sb = new StringBuilder();
                sb.append(CollectionsKt.joinToString$default(logIntent.getEmojiList(), "", null, null, 0, null, null, 62, null));
                sb.append(' ');
                String str4 = String.format(AttributionStrings.METHOD_CALLED, Arrays.copyOf(new Object[]{"setPhoneNumber"}, 1));
                Intrinsics.checkNotNullExpressionValue(str4, "format(...)");
                sb.append(str4);
                return sb.toString();
            }
        };
        switch (LogWrapperKt.WhenMappings.$EnumSwitchMapping$0[logIntent.ordinal()]) {
            case 1:
                LogLevel logLevel = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                    str2 = "[Purchases] - " + logLevel.name();
                    str3 = (String) function0.invoke();
                    currentLogHandler.d(str2, str3);
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
                    str2 = "[Purchases] - " + logLevel4.name();
                    str3 = (String) function0.invoke();
                    currentLogHandler.d(str2, str3);
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
                    str2 = "[Purchases] - " + logLevel6.name();
                    str3 = (String) function0.invoke();
                    currentLogHandler.d(str2, str3);
                }
                break;
            case 9:
                LogLevel logLevel7 = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel7) <= 0) {
                    str2 = "[Purchases] - " + logLevel7.name();
                    str3 = (String) function0.invoke();
                    currentLogHandler.d(str2, str3);
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
        this.subscriberAttributesManager.setAttribute(SubscriberAttributeKey.PhoneNumber.INSTANCE, str, getAppUserID());
    }

    public final void setPostHogUserId(String str) {
        LogHandler currentLogHandler;
        String str2;
        String str3;
        final LogIntent logIntent = LogIntent.DEBUG;
        Function0<String> function0 = new Function0<String>() { // from class: com.revenuecat.purchases.PurchasesOrchestrator$setPostHogUserId$$inlined$log$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                StringBuilder sb = new StringBuilder();
                sb.append(CollectionsKt.joinToString$default(logIntent.getEmojiList(), "", null, null, 0, null, null, 62, null));
                sb.append(' ');
                String str4 = String.format(AttributionStrings.METHOD_CALLED, Arrays.copyOf(new Object[]{"setPostHogUserId"}, 1));
                Intrinsics.checkNotNullExpressionValue(str4, "format(...)");
                sb.append(str4);
                return sb.toString();
            }
        };
        switch (LogWrapperKt.WhenMappings.$EnumSwitchMapping$0[logIntent.ordinal()]) {
            case 1:
                LogLevel logLevel = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                    str2 = "[Purchases] - " + logLevel.name();
                    str3 = (String) function0.invoke();
                    currentLogHandler.d(str2, str3);
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
                    str2 = "[Purchases] - " + logLevel4.name();
                    str3 = (String) function0.invoke();
                    currentLogHandler.d(str2, str3);
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
                    str2 = "[Purchases] - " + logLevel6.name();
                    str3 = (String) function0.invoke();
                    currentLogHandler.d(str2, str3);
                }
                break;
            case 9:
                LogLevel logLevel7 = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel7) <= 0) {
                    str2 = "[Purchases] - " + logLevel7.name();
                    str3 = (String) function0.invoke();
                    currentLogHandler.d(str2, str3);
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
        this.subscriberAttributesManager.setAttribute(SubscriberAttributeKey.IntegrationIds.PostHogUserId.INSTANCE, str, getAppUserID());
    }

    public final void setPushToken(String str) {
        LogHandler currentLogHandler;
        String str2;
        String str3;
        final LogIntent logIntent = LogIntent.DEBUG;
        Function0<String> function0 = new Function0<String>() { // from class: com.revenuecat.purchases.PurchasesOrchestrator$setPushToken$$inlined$log$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                StringBuilder sb = new StringBuilder();
                sb.append(CollectionsKt.joinToString$default(logIntent.getEmojiList(), "", null, null, 0, null, null, 62, null));
                sb.append(' ');
                String str4 = String.format(AttributionStrings.METHOD_CALLED, Arrays.copyOf(new Object[]{"setPushToken"}, 1));
                Intrinsics.checkNotNullExpressionValue(str4, "format(...)");
                sb.append(str4);
                return sb.toString();
            }
        };
        switch (LogWrapperKt.WhenMappings.$EnumSwitchMapping$0[logIntent.ordinal()]) {
            case 1:
                LogLevel logLevel = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                    str2 = "[Purchases] - " + logLevel.name();
                    str3 = (String) function0.invoke();
                    currentLogHandler.d(str2, str3);
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
                    str2 = "[Purchases] - " + logLevel4.name();
                    str3 = (String) function0.invoke();
                    currentLogHandler.d(str2, str3);
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
                    str2 = "[Purchases] - " + logLevel6.name();
                    str3 = (String) function0.invoke();
                    currentLogHandler.d(str2, str3);
                }
                break;
            case 9:
                LogLevel logLevel7 = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel7) <= 0) {
                    str2 = "[Purchases] - " + logLevel7.name();
                    str3 = (String) function0.invoke();
                    currentLogHandler.d(str2, str3);
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
        this.subscriberAttributesManager.setAttribute(SubscriberAttributeKey.FCMTokens.INSTANCE, str, getAppUserID());
    }

    public final void setSolarEngineAccountId(String str) {
        LogHandler currentLogHandler;
        String str2;
        String str3;
        final LogIntent logIntent = LogIntent.DEBUG;
        Function0<String> function0 = new Function0<String>() { // from class: com.revenuecat.purchases.PurchasesOrchestrator$setSolarEngineAccountId$$inlined$log$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                StringBuilder sb = new StringBuilder();
                sb.append(CollectionsKt.joinToString$default(logIntent.getEmojiList(), "", null, null, 0, null, null, 62, null));
                sb.append(' ');
                String str4 = String.format(AttributionStrings.METHOD_CALLED, Arrays.copyOf(new Object[]{"setSolarEngineAccountId"}, 1));
                Intrinsics.checkNotNullExpressionValue(str4, "format(...)");
                sb.append(str4);
                return sb.toString();
            }
        };
        switch (LogWrapperKt.WhenMappings.$EnumSwitchMapping$0[logIntent.ordinal()]) {
            case 1:
                LogLevel logLevel = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                    str2 = "[Purchases] - " + logLevel.name();
                    str3 = (String) function0.invoke();
                    currentLogHandler.d(str2, str3);
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
                    str2 = "[Purchases] - " + logLevel4.name();
                    str3 = (String) function0.invoke();
                    currentLogHandler.d(str2, str3);
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
                    str2 = "[Purchases] - " + logLevel6.name();
                    str3 = (String) function0.invoke();
                    currentLogHandler.d(str2, str3);
                }
                break;
            case 9:
                LogLevel logLevel7 = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel7) <= 0) {
                    str2 = "[Purchases] - " + logLevel7.name();
                    str3 = (String) function0.invoke();
                    currentLogHandler.d(str2, str3);
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
        this.subscriberAttributesManager.setAttributionID(SubscriberAttributeKey.AttributionIds.SolarEngineAccountId.INSTANCE, str, getAppUserID(), this.application);
    }

    public final void setSolarEngineDistinctId(String str) {
        LogHandler currentLogHandler;
        String str2;
        String str3;
        final LogIntent logIntent = LogIntent.DEBUG;
        Function0<String> function0 = new Function0<String>() { // from class: com.revenuecat.purchases.PurchasesOrchestrator$setSolarEngineDistinctId$$inlined$log$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                StringBuilder sb = new StringBuilder();
                sb.append(CollectionsKt.joinToString$default(logIntent.getEmojiList(), "", null, null, 0, null, null, 62, null));
                sb.append(' ');
                String str4 = String.format(AttributionStrings.METHOD_CALLED, Arrays.copyOf(new Object[]{"setSolarEngineDistinctId"}, 1));
                Intrinsics.checkNotNullExpressionValue(str4, "format(...)");
                sb.append(str4);
                return sb.toString();
            }
        };
        switch (LogWrapperKt.WhenMappings.$EnumSwitchMapping$0[logIntent.ordinal()]) {
            case 1:
                LogLevel logLevel = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                    str2 = "[Purchases] - " + logLevel.name();
                    str3 = (String) function0.invoke();
                    currentLogHandler.d(str2, str3);
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
                    str2 = "[Purchases] - " + logLevel4.name();
                    str3 = (String) function0.invoke();
                    currentLogHandler.d(str2, str3);
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
                    str2 = "[Purchases] - " + logLevel6.name();
                    str3 = (String) function0.invoke();
                    currentLogHandler.d(str2, str3);
                }
                break;
            case 9:
                LogLevel logLevel7 = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel7) <= 0) {
                    str2 = "[Purchases] - " + logLevel7.name();
                    str3 = (String) function0.invoke();
                    currentLogHandler.d(str2, str3);
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
        this.subscriberAttributesManager.setAttributionID(SubscriberAttributeKey.AttributionIds.SolarEngineDistinctId.INSTANCE, str, getAppUserID(), this.application);
    }

    public final void setSolarEngineVisitorId(String str) {
        LogHandler currentLogHandler;
        String str2;
        String str3;
        final LogIntent logIntent = LogIntent.DEBUG;
        Function0<String> function0 = new Function0<String>() { // from class: com.revenuecat.purchases.PurchasesOrchestrator$setSolarEngineVisitorId$$inlined$log$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                StringBuilder sb = new StringBuilder();
                sb.append(CollectionsKt.joinToString$default(logIntent.getEmojiList(), "", null, null, 0, null, null, 62, null));
                sb.append(' ');
                String str4 = String.format(AttributionStrings.METHOD_CALLED, Arrays.copyOf(new Object[]{"setSolarEngineVisitorId"}, 1));
                Intrinsics.checkNotNullExpressionValue(str4, "format(...)");
                sb.append(str4);
                return sb.toString();
            }
        };
        switch (LogWrapperKt.WhenMappings.$EnumSwitchMapping$0[logIntent.ordinal()]) {
            case 1:
                LogLevel logLevel = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                    str2 = "[Purchases] - " + logLevel.name();
                    str3 = (String) function0.invoke();
                    currentLogHandler.d(str2, str3);
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
                    str2 = "[Purchases] - " + logLevel4.name();
                    str3 = (String) function0.invoke();
                    currentLogHandler.d(str2, str3);
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
                    str2 = "[Purchases] - " + logLevel6.name();
                    str3 = (String) function0.invoke();
                    currentLogHandler.d(str2, str3);
                }
                break;
            case 9:
                LogLevel logLevel7 = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel7) <= 0) {
                    str2 = "[Purchases] - " + logLevel7.name();
                    str3 = (String) function0.invoke();
                    currentLogHandler.d(str2, str3);
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
        this.subscriberAttributesManager.setAttributionID(SubscriberAttributeKey.AttributionIds.SolarEngineVisitorId.INSTANCE, str, getAppUserID(), this.application);
    }

    public final void setState$purchases_defaultsBc8Release(PurchasesState value) {
        Intrinsics.checkNotNullParameter(value, "value");
        this.purchasesStateCache.setPurchasesState(value);
    }

    public final void setTenjinAnalyticsInstallationID(String str) {
        LogHandler currentLogHandler;
        String str2;
        String str3;
        final LogIntent logIntent = LogIntent.DEBUG;
        Function0<String> function0 = new Function0<String>() { // from class: com.revenuecat.purchases.PurchasesOrchestrator$setTenjinAnalyticsInstallationID$$inlined$log$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                StringBuilder sb = new StringBuilder();
                sb.append(CollectionsKt.joinToString$default(logIntent.getEmojiList(), "", null, null, 0, null, null, 62, null));
                sb.append(' ');
                String str4 = String.format(AttributionStrings.METHOD_CALLED, Arrays.copyOf(new Object[]{"setTenjinAnalyticsInstallationID"}, 1));
                Intrinsics.checkNotNullExpressionValue(str4, "format(...)");
                sb.append(str4);
                return sb.toString();
            }
        };
        switch (LogWrapperKt.WhenMappings.$EnumSwitchMapping$0[logIntent.ordinal()]) {
            case 1:
                LogLevel logLevel = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                    str2 = "[Purchases] - " + logLevel.name();
                    str3 = (String) function0.invoke();
                    currentLogHandler.d(str2, str3);
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
                    str2 = "[Purchases] - " + logLevel4.name();
                    str3 = (String) function0.invoke();
                    currentLogHandler.d(str2, str3);
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
                    str2 = "[Purchases] - " + logLevel6.name();
                    str3 = (String) function0.invoke();
                    currentLogHandler.d(str2, str3);
                }
                break;
            case 9:
                LogLevel logLevel7 = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel7) <= 0) {
                    str2 = "[Purchases] - " + logLevel7.name();
                    str3 = (String) function0.invoke();
                    currentLogHandler.d(str2, str3);
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
        this.subscriberAttributesManager.setAttribute(SubscriberAttributeKey.IntegrationIds.TenjinAnalyticsInstallationId.INSTANCE, str, getAppUserID());
    }

    public final synchronized void setTrackedEventListener(TrackedEventListener trackedEventListener) {
        this.trackedEventListener = trackedEventListener;
    }

    public final synchronized void setUpdatedCustomerInfoListener(UpdatedCustomerInfoListener updatedCustomerInfoListener) {
        this.customerInfoUpdateHandler.setUpdatedCustomerInfoListener(updatedCustomerInfoListener);
    }

    public final void showInAppMessagesIfNeeded(Activity activity, List<? extends InAppMessageType> inAppMessageTypes) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(inAppMessageTypes, "inAppMessageTypes");
        this.billing.showInAppMessagesIfNeeded(activity, inAppMessageTypes, new Function0<Unit>() { // from class: com.revenuecat.purchases.PurchasesOrchestrator.showInAppMessagesIfNeeded.1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Object invoke() {
                m467invoke();
                return Unit.f139807a;
            }

            /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
            public final void m467invoke() {
                PurchasesOrchestrator.syncPurchases$default(PurchasesOrchestrator.this, null, 1, null);
            }
        });
    }

    public final void switchUser(String newAppUserID) {
        Intrinsics.checkNotNullParameter(newAppUserID, "newAppUserID");
        if (!Intrinsics.areEqual(this.identityManager.getCurrentAppUserID(), newAppUserID)) {
            this.identityManager.switchUser(newAppUserID);
            OfferingsManager.fetchAndCacheOfferings$default(this.offeringsManager, newAppUserID, getState$purchases_defaultsBc8Release().getAppInBackground(), null, null, 12, null);
            return;
        }
        LogLevel logLevel = LogLevel.WARN;
        LogHandler currentLogHandler = LogWrapperKt.getCurrentLogHandler();
        if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
            String str = "[Purchases] - " + logLevel.name();
            String str2 = String.format(IdentityStrings.SWITCHING_USER_SAME_APP_USER_ID, Arrays.copyOf(new Object[]{newAppUserID}, 1));
            Intrinsics.checkNotNullExpressionValue(str2, "format(...)");
            currentLogHandler.w(str, str2);
        }
    }

    public final void syncAmazonPurchase(String productID, final String receiptID, final String amazonUserID, final String str, final Double d3, final Long l3) {
        LogHandler currentLogHandler;
        String str2;
        String str3;
        Intrinsics.checkNotNullParameter(productID, "productID");
        Intrinsics.checkNotNullParameter(receiptID, "receiptID");
        Intrinsics.checkNotNullParameter(amazonUserID, "amazonUserID");
        final LogIntent logIntent = LogIntent.DEBUG;
        Function0<String> function0 = new Function0<String>() { // from class: com.revenuecat.purchases.PurchasesOrchestrator$syncAmazonPurchase$$inlined$log$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                StringBuilder sb = new StringBuilder();
                sb.append(CollectionsKt.joinToString$default(logIntent.getEmojiList(), "", null, null, 0, null, null, 62, null));
                sb.append(' ');
                String str4 = String.format(PurchaseStrings.SYNCING_PURCHASE_STORE_USER_ID, Arrays.copyOf(new Object[]{receiptID, amazonUserID}, 2));
                Intrinsics.checkNotNullExpressionValue(str4, "format(...)");
                sb.append(str4);
                return sb.toString();
            }
        };
        int[] iArr = LogWrapperKt.WhenMappings.$EnumSwitchMapping$0;
        switch (iArr[logIntent.ordinal()]) {
            case 1:
                LogLevel logLevel = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                    str2 = "[Purchases] - " + logLevel.name();
                    str3 = (String) function0.invoke();
                    currentLogHandler.d(str2, str3);
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
                    str2 = "[Purchases] - " + logLevel4.name();
                    str3 = (String) function0.invoke();
                    currentLogHandler.d(str2, str3);
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
                    str2 = "[Purchases] - " + logLevel6.name();
                    str3 = (String) function0.invoke();
                    currentLogHandler.d(str2, str3);
                }
                break;
            case 9:
                LogLevel logLevel7 = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel7) <= 0) {
                    str2 = "[Purchases] - " + logLevel7.name();
                    str3 = (String) function0.invoke();
                    currentLogHandler.d(str2, str3);
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
        Set<String> previouslySentHashedTokens$purchases_defaultsBc8Release = this.deviceCache.getPreviouslySentHashedTokens$purchases_defaultsBc8Release();
        if (!previouslySentHashedTokens$purchases_defaultsBc8Release.contains(UtilsKt.sha1(receiptID))) {
            previouslySentHashedTokens$purchases_defaultsBc8Release = null;
        }
        if (previouslySentHashedTokens$purchases_defaultsBc8Release == null) {
            final String currentAppUserID = this.identityManager.getCurrentAppUserID();
            this.billing.normalizePurchaseData(productID, receiptID, amazonUserID, new Function1<String, Unit>() { // from class: com.revenuecat.purchases.PurchasesOrchestrator.syncAmazonPurchase.4
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke((String) obj);
                    return Unit.f139807a;
                }

                public final void invoke(String normalizedProductID) {
                    Intrinsics.checkNotNullParameter(normalizedProductID, "normalizedProductID");
                    List listListOf = CollectionsKt.listOf(normalizedProductID);
                    Double d4 = d3;
                    Double d5 = (d4 == null || d4.doubleValue() == 0.0d) ? null : d4;
                    String str4 = str;
                    ReceiptInfo receiptInfo = new ReceiptInfo(listListOf, l3, null, d5, null, (str4 == null || StringsKt.p0(str4)) ? null : str4, null, null, null, null, false, amazonUserID, null, AdError.INTERNAL_ERROR_2004, null);
                    PostReceiptHelper postReceiptHelper = this.postReceiptHelper;
                    String str5 = receiptID;
                    boolean allowSharingPlayStoreAccount = this.getAllowSharingPlayStoreAccount();
                    String str6 = currentAppUserID;
                    PostReceiptInitiationSource postReceiptInitiationSource = PostReceiptInitiationSource.RESTORE;
                    final String str7 = receiptID;
                    final String str8 = amazonUserID;
                    Function1<CustomerInfo, Unit> function1 = new Function1<CustomerInfo, Unit>() { // from class: com.revenuecat.purchases.PurchasesOrchestrator.syncAmazonPurchase.4.1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                            invoke((CustomerInfo) obj);
                            return Unit.f139807a;
                        }

                        public final void invoke(CustomerInfo it) {
                            Intrinsics.checkNotNullParameter(it, "it");
                            final LogIntent logIntent2 = LogIntent.PURCHASE;
                            final String str9 = str7;
                            final String str10 = str8;
                            Function0<String> function02 = new Function0<String>() { // from class: com.revenuecat.purchases.PurchasesOrchestrator$syncAmazonPurchase$4$1$invoke$$inlined$log$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(0);
                                }

                                @Override // kotlin.jvm.functions.Function0
                                public final String invoke() {
                                    StringBuilder sb = new StringBuilder();
                                    sb.append(CollectionsKt.joinToString$default(logIntent2.getEmojiList(), "", null, null, 0, null, null, 62, null));
                                    sb.append(' ');
                                    String str11 = String.format(PurchaseStrings.PURCHASE_SYNCED_USER_ID, Arrays.copyOf(new Object[]{str9, str10}, 2));
                                    Intrinsics.checkNotNullExpressionValue(str11, "format(...)");
                                    sb.append(str11);
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
                        }
                    };
                    final String str9 = receiptID;
                    final String str10 = amazonUserID;
                    postReceiptHelper.postTokenWithoutConsuming(str5, receiptInfo, allowSharingPlayStoreAccount, str6, postReceiptInitiationSource, function1, new Function1<PurchasesError, Unit>() { // from class: com.revenuecat.purchases.PurchasesOrchestrator.syncAmazonPurchase.4.2
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                            invoke((PurchasesError) obj);
                            return Unit.f139807a;
                        }

                        public final void invoke(final PurchasesError error) {
                            Intrinsics.checkNotNullParameter(error, "error");
                            final LogIntent logIntent2 = LogIntent.RC_ERROR;
                            final String str11 = str9;
                            final String str12 = str10;
                            Function0<String> function02 = new Function0<String>() { // from class: com.revenuecat.purchases.PurchasesOrchestrator$syncAmazonPurchase$4$2$invoke$$inlined$log$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(0);
                                }

                                @Override // kotlin.jvm.functions.Function0
                                public final String invoke() {
                                    StringBuilder sb = new StringBuilder();
                                    sb.append(CollectionsKt.joinToString$default(logIntent2.getEmojiList(), "", null, null, 0, null, null, 62, null));
                                    sb.append(' ');
                                    String str13 = String.format(PurchaseStrings.SYNCING_PURCHASE_ERROR_DETAILS_USER_ID, Arrays.copyOf(new Object[]{str11, str12, error}, 3));
                                    Intrinsics.checkNotNullExpressionValue(str13, "format(...)");
                                    sb.append(str13);
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
                        }
                    }, (ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0 ? null : null);
                }
            }, new Function1<PurchasesError, Unit>() { // from class: com.revenuecat.purchases.PurchasesOrchestrator.syncAmazonPurchase.5
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke((PurchasesError) obj);
                    return Unit.f139807a;
                }

                public final void invoke(final PurchasesError error) {
                    Intrinsics.checkNotNullParameter(error, "error");
                    final LogIntent logIntent2 = LogIntent.RC_ERROR;
                    final String str4 = receiptID;
                    final String str5 = amazonUserID;
                    Function0<String> function02 = new Function0<String>() { // from class: com.revenuecat.purchases.PurchasesOrchestrator$syncAmazonPurchase$5$invoke$$inlined$log$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public final String invoke() {
                            StringBuilder sb = new StringBuilder();
                            sb.append(CollectionsKt.joinToString$default(logIntent2.getEmojiList(), "", null, null, 0, null, null, 62, null));
                            sb.append(' ');
                            String str6 = String.format(PurchaseStrings.SYNCING_PURCHASE_ERROR_DETAILS_USER_ID, Arrays.copyOf(new Object[]{str4, str5, error}, 3));
                            Intrinsics.checkNotNullExpressionValue(str6, "format(...)");
                            sb.append(str6);
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
                }
            });
            return;
        }
        Function0<String> function02 = new Function0<String>() { // from class: com.revenuecat.purchases.PurchasesOrchestrator$syncAmazonPurchase$lambda$14$$inlined$log$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                StringBuilder sb = new StringBuilder();
                sb.append(CollectionsKt.joinToString$default(logIntent.getEmojiList(), "", null, null, 0, null, null, 62, null));
                sb.append(' ');
                String str4 = String.format(PurchaseStrings.SYNCING_PURCHASE_SKIPPING, Arrays.copyOf(new Object[]{receiptID, amazonUserID}, 2));
                Intrinsics.checkNotNullExpressionValue(str4, "format(...)");
                sb.append(str4);
                return sb.toString();
            }
        };
        switch (iArr[logIntent.ordinal()]) {
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
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [com.revenuecat.purchases.PurchasesOrchestrator$syncAttributesAndOfferingsIfNeeded$receiveOfferingsCallback$1, com.revenuecat.purchases.interfaces.ReceiveOfferingsCallback] */
    public final void syncAttributesAndOfferingsIfNeeded(final SyncAttributesAndOfferingsCallback callback) {
        LogHandler currentLogHandler;
        String str;
        String str2;
        Intrinsics.checkNotNullParameter(callback, "callback");
        final ?? r02 = new ReceiveOfferingsCallback() { // from class: com.revenuecat.purchases.PurchasesOrchestrator$syncAttributesAndOfferingsIfNeeded$receiveOfferingsCallback$1
            @Override // com.revenuecat.purchases.interfaces.ReceiveOfferingsCallback
            public void onError(PurchasesError error) {
                Intrinsics.checkNotNullParameter(error, "error");
                callback.onError(error);
            }

            @Override // com.revenuecat.purchases.interfaces.ReceiveOfferingsCallback
            public void onReceived(Offerings offerings) {
                Intrinsics.checkNotNullParameter(offerings, "offerings");
                callback.onSuccess(offerings);
            }
        };
        if (this.lastSyncAttributesAndOfferingsRateLimiter.shouldProceed()) {
            this.subscriberAttributesManager.synchronizeSubscriberAttributesForAllUsers(getAppUserID(), new Function0<Unit>() { // from class: com.revenuecat.purchases.PurchasesOrchestrator.syncAttributesAndOfferingsIfNeeded.2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Object invoke() {
                    m468invoke();
                    return Unit.f139807a;
                }

                /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
                public final void m468invoke() {
                    PurchasesOrchestrator.this.getOfferings(r02, true);
                }
            });
            return;
        }
        final LogIntent logIntent = LogIntent.WARNING;
        Function0<String> function0 = new Function0<String>() { // from class: com.revenuecat.purchases.PurchasesOrchestrator$syncAttributesAndOfferingsIfNeeded$$inlined$log$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                StringBuilder sb = new StringBuilder();
                sb.append(CollectionsKt.joinToString$default(logIntent.getEmojiList(), "", null, null, 0, null, null, 62, null));
                sb.append(' ');
                String str3 = String.format(SyncAttributesAndOfferingsStrings.RATE_LIMIT_REACHED, Arrays.copyOf(new Object[]{Integer.valueOf(this.lastSyncAttributesAndOfferingsRateLimiter.getMaxCallsInPeriod()), Long.valueOf(Duration.s(this.lastSyncAttributesAndOfferingsRateLimiter.m1244getPeriodSecondsUwyO8pc()))}, 2));
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
        getOfferings$default(this, r02, false, 2, null);
    }

    public final void syncPurchases(final SyncPurchasesCallback syncPurchasesCallback) {
        LogHandler currentLogHandler;
        String str;
        String str2;
        if (this.appConfig.getApiKeyValidationResult() != APIKeyValidator.ValidationResult.SIMULATED_STORE) {
            this.syncPurchasesHelper.syncPurchases(getAllowSharingPlayStoreAccount(), getState$purchases_defaultsBc8Release().getAppInBackground(), new Function1<CustomerInfo, Unit>() { // from class: com.revenuecat.purchases.PurchasesOrchestrator.syncPurchases.3
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke((CustomerInfo) obj);
                    return Unit.f139807a;
                }

                public final void invoke(CustomerInfo it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    SyncPurchasesCallback syncPurchasesCallback2 = syncPurchasesCallback;
                    if (syncPurchasesCallback2 != null) {
                        syncPurchasesCallback2.onSuccess(it);
                    }
                }
            }, new Function1<PurchasesError, Unit>() { // from class: com.revenuecat.purchases.PurchasesOrchestrator.syncPurchases.4
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke((PurchasesError) obj);
                    return Unit.f139807a;
                }

                public final void invoke(PurchasesError it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    SyncPurchasesCallback syncPurchasesCallback2 = syncPurchasesCallback;
                    if (syncPurchasesCallback2 != null) {
                        syncPurchasesCallback2.onError(it);
                    }
                }
            });
            return;
        }
        final LogIntent logIntent = LogIntent.DEBUG;
        Function0<String> function0 = new Function0<String>() { // from class: com.revenuecat.purchases.PurchasesOrchestrator$syncPurchases$$inlined$log$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                return CollectionsKt.joinToString$default(logIntent.getEmojiList(), "", null, null, 0, null, null, 62, null) + ' ' + RestoreStrings.SYNC_PURCHASES_SIMULATED_STORE;
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
        getCustomerInfo(new ReceiveCustomerInfoCallback() { // from class: com.revenuecat.purchases.PurchasesOrchestrator.syncPurchases.2
            @Override // com.revenuecat.purchases.interfaces.ReceiveCustomerInfoCallback
            public void onError(PurchasesError error) {
                Intrinsics.checkNotNullParameter(error, "error");
                SyncPurchasesCallback syncPurchasesCallback2 = syncPurchasesCallback;
                if (syncPurchasesCallback2 != null) {
                    syncPurchasesCallback2.onError(error);
                }
            }

            @Override // com.revenuecat.purchases.interfaces.ReceiveCustomerInfoCallback
            public void onReceived(CustomerInfo customerInfo) {
                Intrinsics.checkNotNullParameter(customerInfo, "customerInfo");
                SyncPurchasesCallback syncPurchasesCallback2 = syncPurchasesCallback;
                if (syncPurchasesCallback2 != null) {
                    syncPurchasesCallback2.onSuccess(customerInfo);
                }
            }
        });
    }

    public final void track(FeatureEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (event instanceof PaywallEvent) {
            this.paywallPresentedCache.receiveEvent((PaywallEvent) event);
        }
        this.eventsManager.track(event);
        TrackedEventListener trackedEventListener = this.trackedEventListener;
        if (trackedEventListener != null) {
            trackedEventListener.onEventTracked(event);
        }
    }

    public final void createSupportTicket(String email, String description, Function1<? super Boolean, Unit> onSuccess, Function1<? super PurchasesError, Unit> function1) {
        Intrinsics.checkNotNullParameter(email, "email");
        Intrinsics.checkNotNullParameter(description, "description");
        Intrinsics.checkNotNullParameter(onSuccess, "onSuccess");
        Intrinsics.checkNotNullParameter(function1, HcgZcEUYo.vdDcfsZDH);
        this.backend.postCreateSupportTicket(this.identityManager.getCurrentAppUserID(), email, description, onSuccess, function1);
    }

    public final void getCustomerInfo(CacheFetchPolicy fetchPolicy, boolean z2, ReceiveCustomerInfoCallback callback) {
        Intrinsics.checkNotNullParameter(fetchPolicy, "fetchPolicy");
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.customerInfoHelper.retrieveCustomerInfo(this.identityManager.getCurrentAppUserID(), fetchPolicy, getState$purchases_defaultsBc8Release().getAppInBackground(), getAllowSharingPlayStoreAccount(), z2, callback);
    }

    public final void getStorefrontCountryCode(final GetStorefrontCallback callback) {
        Unit unit;
        Intrinsics.checkNotNullParameter(callback, "callback");
        String str = this.storefrontCountryCode;
        if (str != null) {
            callback.onReceived(str);
            unit = Unit.f139807a;
        } else {
            unit = null;
        }
        if (unit == null) {
            this.billing.getStorefront(new Function1<String, Unit>() { // from class: com.revenuecat.purchases.PurchasesOrchestrator$getStorefrontCountryCode$2$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke((String) obj);
                    return Unit.f139807a;
                }

                public final void invoke(String countryCode) {
                    Intrinsics.checkNotNullParameter(countryCode, "countryCode");
                    this.$this_run.storefrontCountryCode = countryCode;
                    callback.onReceived(countryCode);
                }
            }, new Function1<PurchasesError, Unit>() { // from class: com.revenuecat.purchases.PurchasesOrchestrator$getStorefrontCountryCode$2$2
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
                    LogUtilsKt.errorLog(error);
                    callback.onError(error);
                }
            });
        }
    }

    public final void getStorefrontLocale(final GetStorefrontLocaleCallback callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        getStorefrontCountryCode(new GetStorefrontCallback() { // from class: com.revenuecat.purchases.PurchasesOrchestrator.getStorefrontLocale.1
            @Override // com.revenuecat.purchases.interfaces.GetStorefrontCallback
            public void onError(PurchasesError error) {
                Intrinsics.checkNotNullParameter(error, "error");
                callback.onError(error);
            }

            @Override // com.revenuecat.purchases.interfaces.GetStorefrontCallback
            public void onReceived(String storefrontCountryCode) {
                Intrinsics.checkNotNullParameter(storefrontCountryCode, "storefrontCountryCode");
                GetStorefrontLocaleCallback getStorefrontLocaleCallback = callback;
                Locale localeBuild = new Locale.Builder().setRegion(storefrontCountryCode).build();
                Intrinsics.checkNotNullExpressionValue(localeBuild, "Builder().setRegion(storefrontCountryCode).build()");
                getStorefrontLocaleCallback.onReceived(localeBuild);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void dispatch(final PurchaseErrorCallback purchaseErrorCallback, final PurchasesError purchasesError) {
        dispatch(new Function0<Unit>() { // from class: com.revenuecat.purchases.PurchasesOrchestrator.dispatch.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Object invoke() {
                m450invoke();
                return Unit.f139807a;
            }

            /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
            public final void m450invoke() {
                PurchaseErrorCallback purchaseErrorCallback2 = purchaseErrorCallback;
                PurchasesError purchasesError2 = purchasesError;
                purchaseErrorCallback2.onError(purchasesError2, purchasesError2.getCode() == PurchasesErrorCode.PurchaseCancelledError);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final void getProductsOfTypes(Set<String> set, Set<? extends ProductType> set2, List<? extends StoreProduct> list, Date date, GetStoreProductsCallback getStoreProductsCallback) {
        final Set<String> set3;
        final List<? extends StoreProduct> list2;
        GetStoreProductsCallback getStoreProductsCallback2;
        Unit unit;
        if (date == null) {
            trackGetProductsStarted(set);
            date = this.dateProvider.getNow();
        }
        final Date date2 = date;
        final Set mutableSet = CollectionsKt.toMutableSet(set2);
        ProductType productType = (ProductType) CollectionsKt.firstOrNull(mutableSet);
        if (productType != null) {
            mutableSet.remove(productType);
        } else {
            productType = null;
        }
        if (productType != null) {
            set3 = set;
            list2 = list;
            final GetStoreProductsCallback getStoreProductsCallback3 = getStoreProductsCallback;
            this.billing.queryProductDetailsAsync(productType, set3, new Function1<List<? extends StoreProduct>, Unit>() { // from class: com.revenuecat.purchases.PurchasesOrchestrator$getProductsOfTypes$1$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke((List<? extends StoreProduct>) obj);
                    return Unit.f139807a;
                }

                public final void invoke(final List<? extends StoreProduct> storeProducts) {
                    Intrinsics.checkNotNullParameter(storeProducts, "storeProducts");
                    final PurchasesOrchestrator purchasesOrchestrator = this.this$0;
                    final Set<String> set4 = set3;
                    final Set<ProductType> set5 = mutableSet;
                    final List<StoreProduct> list3 = list2;
                    final Date date3 = date2;
                    final GetStoreProductsCallback getStoreProductsCallback4 = getStoreProductsCallback3;
                    purchasesOrchestrator.dispatch(new Function0<Unit>() { // from class: com.revenuecat.purchases.PurchasesOrchestrator$getProductsOfTypes$1$1.1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(0);
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public /* bridge */ /* synthetic */ Object invoke() {
                            m452invoke();
                            return Unit.f139807a;
                        }

                        /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
                        public final void m452invoke() {
                            purchasesOrchestrator.getProductsOfTypes(set4, set5, CollectionsKt.plus((Collection) list3, (Iterable) storeProducts), date3, getStoreProductsCallback4);
                        }
                    });
                }
            }, new Function1<PurchasesError, Unit>() { // from class: com.revenuecat.purchases.PurchasesOrchestrator$getProductsOfTypes$1$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke((PurchasesError) obj);
                    return Unit.f139807a;
                }

                public final void invoke(final PurchasesError it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    final PurchasesOrchestrator purchasesOrchestrator = this.this$0;
                    final Date date3 = date2;
                    final Set<String> set4 = set3;
                    final GetStoreProductsCallback getStoreProductsCallback4 = getStoreProductsCallback3;
                    purchasesOrchestrator.dispatch(new Function0<Unit>() { // from class: com.revenuecat.purchases.PurchasesOrchestrator$getProductsOfTypes$1$2.1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public /* bridge */ /* synthetic */ Object invoke() {
                            m453invoke();
                            return Unit.f139807a;
                        }

                        /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
                        public final void m453invoke() {
                            PurchasesOrchestrator purchasesOrchestrator2 = purchasesOrchestrator;
                            Date date4 = date3;
                            Set<String> set5 = set4;
                            purchasesOrchestrator2.trackGetProductsResult(date4, set5, set5, it);
                            getStoreProductsCallback4.onError(it);
                        }
                    });
                }
            });
            unit = Unit.f139807a;
            getStoreProductsCallback2 = getStoreProductsCallback3;
        } else {
            set3 = set;
            list2 = list;
            getStoreProductsCallback2 = getStoreProductsCallback;
            unit = null;
        }
        if (unit == null) {
            List<? extends StoreProduct> list3 = list2;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list3, 10));
            Iterator<T> it = list3.iterator();
            while (it.hasNext()) {
                arrayList.add(((StoreProduct) it.next()).getId());
            }
            trackGetProductsResult(date2, set3, SetsKt.minus((Set) set3, (Iterable) CollectionsKt.toSet(arrayList)), null);
            getStoreProductsCallback2.onReceived(list2);
        }
    }

    /*  JADX ERROR: NullPointerException in pass: InitCodeVariables
        java.lang.NullPointerException
        */
    public /* synthetic */ PurchasesOrchestrator(android.app.Application r39, java.lang.String r40, com.revenuecat.purchases.common.Backend r41, com.revenuecat.purchases.common.BillingAbstract r42, com.revenuecat.purchases.common.caching.DeviceCache r43, com.revenuecat.purchases.identity.IdentityManager r44, com.revenuecat.purchases.subscriberattributes.SubscriberAttributesManager r45, com.revenuecat.purchases.common.AppConfig r46, com.revenuecat.purchases.CustomerInfoHelper r47, com.revenuecat.purchases.CustomerInfoUpdateHandler r48, com.revenuecat.purchases.common.diagnostics.DiagnosticsSynchronizer r49, com.revenuecat.purchases.common.diagnostics.DiagnosticsTracker r50, com.revenuecat.purchases.common.DateProvider r51, com.revenuecat.purchases.common.offlineentitlements.OfflineEntitlementsManager r52, com.revenuecat.purchases.PostReceiptHelper r53, com.revenuecat.purchases.PostTransactionWithProductDetailsHelper r54, com.revenuecat.purchases.PostPendingTransactionsHelper r55, com.revenuecat.purchases.SyncPurchasesHelper r56, com.revenuecat.purchases.common.offerings.OfferingsManager r57, com.revenuecat.purchases.common.events.EventsManager r58, com.revenuecat.purchases.common.events.EventsManager r59, com.revenuecat.purchases.paywalls.PaywallPresentedCache r60, com.revenuecat.purchases.PurchasesStateCache r61, android.os.Handler r62, com.revenuecat.purchases.common.Dispatcher r63, com.revenuecat.purchases.PurchasesConfiguration r64, com.revenuecat.purchases.paywalls.FontLoader r65, com.revenuecat.purchases.common.DefaultLocaleProvider r66, com.revenuecat.purchases.deeplinks.WebPurchaseRedemptionHelper r67, com.revenuecat.purchases.virtualcurrencies.VirtualCurrencyManager r68, com.revenuecat.purchases.utils.PurchaseParamsValidator r69, com.revenuecat.purchases.common.workflows.WorkflowManager r70, kotlin.jvm.functions.Function0 r71, com.revenuecat.purchases.blockstore.BlockstoreHelper r72, android.app.backup.BackupManager r73, com.revenuecat.purchases.storage.FileRepository r74, com.revenuecat.purchases.ads.events.AdTracker r75, int r76, int r77, kotlin.jvm.internal.DefaultConstructorMarker r78) {
        /*
            Method dump skipped, instruction units count: 264
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.revenuecat.purchases.PurchasesOrchestrator.<init>(android.app.Application, java.lang.String, com.revenuecat.purchases.common.Backend, com.revenuecat.purchases.common.BillingAbstract, com.revenuecat.purchases.common.caching.DeviceCache, com.revenuecat.purchases.identity.IdentityManager, com.revenuecat.purchases.subscriberattributes.SubscriberAttributesManager, com.revenuecat.purchases.common.AppConfig, com.revenuecat.purchases.CustomerInfoHelper, com.revenuecat.purchases.CustomerInfoUpdateHandler, com.revenuecat.purchases.common.diagnostics.DiagnosticsSynchronizer, com.revenuecat.purchases.common.diagnostics.DiagnosticsTracker, com.revenuecat.purchases.common.DateProvider, com.revenuecat.purchases.common.offlineentitlements.OfflineEntitlementsManager, com.revenuecat.purchases.PostReceiptHelper, com.revenuecat.purchases.PostTransactionWithProductDetailsHelper, com.revenuecat.purchases.PostPendingTransactionsHelper, com.revenuecat.purchases.SyncPurchasesHelper, com.revenuecat.purchases.common.offerings.OfferingsManager, com.revenuecat.purchases.common.events.EventsManager, com.revenuecat.purchases.common.events.EventsManager, com.revenuecat.purchases.paywalls.PaywallPresentedCache, com.revenuecat.purchases.PurchasesStateCache, android.os.Handler, com.revenuecat.purchases.common.Dispatcher, com.revenuecat.purchases.PurchasesConfiguration, com.revenuecat.purchases.paywalls.FontLoader, com.revenuecat.purchases.common.DefaultLocaleProvider, com.revenuecat.purchases.deeplinks.WebPurchaseRedemptionHelper, com.revenuecat.purchases.virtualcurrencies.VirtualCurrencyManager, com.revenuecat.purchases.utils.PurchaseParamsValidator, com.revenuecat.purchases.common.workflows.WorkflowManager, kotlin.jvm.functions.Function0, com.revenuecat.purchases.blockstore.BlockstoreHelper, android.app.backup.BackupManager, com.revenuecat.purchases.storage.FileRepository, com.revenuecat.purchases.ads.events.AdTracker, int, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
