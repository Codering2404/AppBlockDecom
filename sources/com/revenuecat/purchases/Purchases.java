package com.revenuecat.purchases;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.revenuecat.purchases.PurchaseParams;
import com.revenuecat.purchases.UiConfig;
import com.revenuecat.purchases.ads.events.AdTracker;
import com.revenuecat.purchases.common.Config;
import com.revenuecat.purchases.common.LogIntent;
import com.revenuecat.purchases.common.LogWrapperKt;
import com.revenuecat.purchases.common.PlatformInfo;
import com.revenuecat.purchases.common.events.FeatureEvent;
import com.revenuecat.purchases.common.workflows.WorkflowDataResult;
import com.revenuecat.purchases.customercenter.CustomerCenterListener;
import com.revenuecat.purchases.deeplinks.DeepLinkParser;
import com.revenuecat.purchases.interfaces.Callback;
import com.revenuecat.purchases.interfaces.GetAmazonLWAConsentStatusCallback;
import com.revenuecat.purchases.interfaces.GetCustomerCenterConfigCallback;
import com.revenuecat.purchases.interfaces.GetStoreProductsCallback;
import com.revenuecat.purchases.interfaces.GetStorefrontCallback;
import com.revenuecat.purchases.interfaces.GetStorefrontLocaleCallback;
import com.revenuecat.purchases.interfaces.GetVirtualCurrenciesCallback;
import com.revenuecat.purchases.interfaces.LogInCallback;
import com.revenuecat.purchases.interfaces.PurchaseCallback;
import com.revenuecat.purchases.interfaces.ReceiveCustomerInfoCallback;
import com.revenuecat.purchases.interfaces.ReceiveOfferingsCallback;
import com.revenuecat.purchases.interfaces.RedeemWebPurchaseListener;
import com.revenuecat.purchases.interfaces.SyncAttributesAndOfferingsCallback;
import com.revenuecat.purchases.interfaces.SyncPurchasesCallback;
import com.revenuecat.purchases.interfaces.UpdatedCustomerInfoListener;
import com.revenuecat.purchases.models.BillingFeature;
import com.revenuecat.purchases.models.InAppMessageType;
import com.revenuecat.purchases.models.StoreProduct;
import com.revenuecat.purchases.paywalls.DownloadedFontFamily;
import com.revenuecat.purchases.paywalls.events.CustomPaywallEvent;
import com.revenuecat.purchases.paywalls.events.CustomPaywallImpressionParams;
import com.revenuecat.purchases.storage.FileRepository;
import com.revenuecat.purchases.strings.BillingStrings;
import com.revenuecat.purchases.strings.ConfigureStrings;
import com.revenuecat.purchases.utils.DefaultIsDebugBuildProvider;
import com.revenuecat.purchases.virtualcurrencies.VirtualCurrencies;
import java.net.URL;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.UninitializedPropertyAccessException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.SafeContinuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
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
/* JADX INFO: loaded from: classes4.dex */
@Metadata
public final class Purchases implements LifecycleDelegate {
    private static /* synthetic */ Purchases backingFieldSharedInstance;
    private final PurchasesOrchestrator purchasesOrchestrator;
    public static final Companion Companion = new Companion(null);
    private static final String frameworkVersion = "10.3.1";

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

        @JvmStatic
        public final void canMakePayments(Context context, Callback<Boolean> callback) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(callback, "callback");
            canMakePayments$default(this, context, null, callback, 2, null);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @JvmStatic
        public final Purchases configure(PurchasesConfiguration configuration) {
            PurchasesOrchestrator purchasesOrchestrator$purchases_defaultsBc8Release;
            Intrinsics.checkNotNullParameter(configuration, "configuration");
            APIKeyValidator aPIKeyValidator = null;
            Object[] objArr = 0;
            if (isConfigured()) {
                Purchases backingFieldSharedInstance$purchases_defaultsBc8Release = getBackingFieldSharedInstance$purchases_defaultsBc8Release();
                if (Intrinsics.areEqual((backingFieldSharedInstance$purchases_defaultsBc8Release == null || (purchasesOrchestrator$purchases_defaultsBc8Release = backingFieldSharedInstance$purchases_defaultsBc8Release.getPurchasesOrchestrator$purchases_defaultsBc8Release()) == null) ? null : purchasesOrchestrator$purchases_defaultsBc8Release.getCurrentConfiguration(), configuration)) {
                    LogLevel logLevel = LogLevel.INFO;
                    LogHandler currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                        currentLogHandler.i("[Purchases] - " + logLevel.name(), ConfigureStrings.INSTANCE_ALREADY_EXISTS_WITH_SAME_CONFIG);
                    }
                    return getSharedInstance();
                }
                LogLevel logLevel2 = LogLevel.INFO;
                LogHandler currentLogHandler2 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel2) <= 0) {
                    currentLogHandler2.i("[Purchases] - " + logLevel2.name(), ConfigureStrings.INSTANCE_ALREADY_EXISTS);
                }
            }
            Purchases purchasesCreatePurchases$default = PurchasesFactory.createPurchases$default(new PurchasesFactory(new DefaultIsDebugBuildProvider(configuration.getContext()), aPIKeyValidator, 2, objArr == true ? 1 : 0), configuration, getPlatformInfo(), getProxyURL(), null, null, false, false, null, 248, null);
            Purchases.Companion.setSharedInstance$purchases_defaultsBc8Release(purchasesCreatePurchases$default);
            return purchasesCreatePurchases$default;
        }

        public final Purchases getBackingFieldSharedInstance$purchases_defaultsBc8Release() {
            return Purchases.backingFieldSharedInstance;
        }

        public final boolean getDebugLogsEnabled() {
            return PurchasesOrchestrator.Companion.getDebugLogsEnabled();
        }

        public final String getFrameworkVersion() {
            return Purchases.frameworkVersion;
        }

        public final Object getImageLoader(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            return PurchasesOrchestrator.Companion.getImageLoader(context);
        }

        public final synchronized LogHandler getLogHandler() {
            return PurchasesOrchestrator.Companion.getLogHandler();
        }

        public final LogLevel getLogLevel() {
            return PurchasesOrchestrator.Companion.getLogLevel();
        }

        public final PlatformInfo getPlatformInfo() {
            return PurchasesOrchestrator.Companion.getPlatformInfo();
        }

        public final URL getProxyURL() {
            return PurchasesOrchestrator.Companion.getProxyURL();
        }

        public final Purchases getSharedInstance() {
            Purchases backingFieldSharedInstance$purchases_defaultsBc8Release = getBackingFieldSharedInstance$purchases_defaultsBc8Release();
            if (backingFieldSharedInstance$purchases_defaultsBc8Release != null) {
                return backingFieldSharedInstance$purchases_defaultsBc8Release;
            }
            throw new UninitializedPropertyAccessException(ConfigureStrings.NO_SINGLETON_INSTANCE);
        }

        public final boolean isConfigured() {
            return getBackingFieldSharedInstance$purchases_defaultsBc8Release() != null;
        }

        @JvmStatic
        public final WebPurchaseRedemption parseAsWebPurchaseRedemption(Intent intent) {
            Intrinsics.checkNotNullParameter(intent, "intent");
            Uri data = intent.getData();
            if (data == null) {
                return null;
            }
            return DeepLinkParser.INSTANCE.parseWebPurchaseRedemption(data);
        }

        public final void setBackingFieldSharedInstance$purchases_defaultsBc8Release(Purchases purchases) {
            Purchases.backingFieldSharedInstance = purchases;
        }

        public final void setDebugLogsEnabled(boolean z2) {
            PurchasesOrchestrator.Companion.setDebugLogsEnabled(z2);
        }

        public final synchronized void setLogHandler(LogHandler value) {
            Intrinsics.checkNotNullParameter(value, "value");
            PurchasesOrchestrator.Companion.setLogHandler(value);
        }

        public final void setLogLevel(LogLevel value) {
            Intrinsics.checkNotNullParameter(value, "value");
            PurchasesOrchestrator.Companion.setLogLevel(value);
        }

        public final void setPlatformInfo(PlatformInfo value) {
            Intrinsics.checkNotNullParameter(value, "value");
            PurchasesOrchestrator.Companion.setPlatformInfo(value);
        }

        public final void setProxyURL(URL url) {
            PurchasesOrchestrator.Companion.setProxyURL(url);
        }

        public final void setSharedInstance$purchases_defaultsBc8Release(Purchases value) {
            Intrinsics.checkNotNullParameter(value, "value");
            Purchases backingFieldSharedInstance$purchases_defaultsBc8Release = getBackingFieldSharedInstance$purchases_defaultsBc8Release();
            if (backingFieldSharedInstance$purchases_defaultsBc8Release != null) {
                backingFieldSharedInstance$purchases_defaultsBc8Release.close();
            }
            setBackingFieldSharedInstance$purchases_defaultsBc8Release(value);
        }

        private Companion() {
        }

        @JvmStatic
        public final void canMakePayments(Context context, List<? extends BillingFeature> features, Callback<Boolean> callback) {
            LogHandler currentLogHandler;
            String str;
            String str2;
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(features, "features");
            Intrinsics.checkNotNullParameter(callback, "callback");
            if (getSharedInstance().getPurchasesOrchestrator$purchases_defaultsBc8Release().getAppConfig().getStore() == Store.PLAY_STORE) {
                PurchasesOrchestrator.Companion.canMakePayments(context, features, callback);
                return;
            }
            final LogIntent logIntent = LogIntent.RC_ERROR;
            Function0<String> function0 = new Function0<String>() { // from class: com.revenuecat.purchases.Purchases$Companion$canMakePayments$$inlined$log$1
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return CollectionsKt.joinToString$default(logIntent.getEmojiList(), "", null, null, 0, null, null, 62, null) + ' ' + BillingStrings.CANNOT_CALL_CAN_MAKE_PAYMENTS;
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
            callback.onReceived(Boolean.TRUE);
        }

        @JvmStatic
        public final WebPurchaseRedemption parseAsWebPurchaseRedemption(String string) {
            Intrinsics.checkNotNullParameter(string, "string");
            try {
                Uri uri = Uri.parse(string);
                DeepLinkParser deepLinkParser = DeepLinkParser.INSTANCE;
                Intrinsics.checkNotNullExpressionValue(uri, "uri");
                return deepLinkParser.parseWebPurchaseRedemption(uri);
            } catch (Throwable th) {
                LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", "Error parsing URL: " + string, th);
                return null;
            }
        }

        @Deprecated
        @JvmStatic
        public static /* synthetic */ void getDebugLogsEnabled$annotations() {
        }

        @JvmStatic
        public static /* synthetic */ void getFrameworkVersion$annotations() {
        }

        @JvmStatic
        public static /* synthetic */ void getLogHandler$annotations() {
        }

        @JvmStatic
        public static /* synthetic */ void getLogLevel$annotations() {
        }

        @JvmStatic
        public static /* synthetic */ void getPlatformInfo$annotations() {
        }

        @JvmStatic
        public static /* synthetic */ void getProxyURL$annotations() {
        }

        @JvmStatic
        public static /* synthetic */ void getSharedInstance$annotations() {
        }

        @JvmStatic
        public static /* synthetic */ void isConfigured$annotations() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[PurchasesAreCompletedBy.values().length];
            try {
                iArr[PurchasesAreCompletedBy.REVENUECAT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[PurchasesAreCompletedBy.MY_APP.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public Purchases(PurchasesOrchestrator purchasesOrchestrator) {
        Intrinsics.checkNotNullParameter(purchasesOrchestrator, "purchasesOrchestrator");
        this.purchasesOrchestrator = purchasesOrchestrator;
    }

    @JvmStatic
    public static final void canMakePayments(Context context, Callback<Boolean> callback) {
        Companion.canMakePayments(context, callback);
    }

    @JvmStatic
    public static final Purchases configure(PurchasesConfiguration purchasesConfiguration) {
        return Companion.configure(purchasesConfiguration);
    }

    public static final boolean getDebugLogsEnabled() {
        return Companion.getDebugLogsEnabled();
    }

    public static final String getFrameworkVersion() {
        return Companion.getFrameworkVersion();
    }

    public static final synchronized LogHandler getLogHandler() {
        return Companion.getLogHandler();
    }

    public static final LogLevel getLogLevel() {
        return Companion.getLogLevel();
    }

    public static final PlatformInfo getPlatformInfo() {
        return Companion.getPlatformInfo();
    }

    public static /* synthetic */ void getProducts$default(Purchases purchases, List list, ProductType productType, GetStoreProductsCallback getStoreProductsCallback, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            productType = null;
        }
        purchases.getProducts(list, productType, getStoreProductsCallback);
    }

    public static final URL getProxyURL() {
        return Companion.getProxyURL();
    }

    public static final Purchases getSharedInstance() {
        return Companion.getSharedInstance();
    }

    public static final boolean isConfigured() {
        return Companion.isConfigured();
    }

    public static /* synthetic */ void logIn$default(Purchases purchases, String str, LogInCallback logInCallback, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            logInCallback = null;
        }
        purchases.logIn(str, logInCallback);
    }

    public static /* synthetic */ void logOut$default(Purchases purchases, ReceiveCustomerInfoCallback receiveCustomerInfoCallback, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            receiveCustomerInfoCallback = null;
        }
        purchases.logOut(receiveCustomerInfoCallback);
    }

    @JvmStatic
    public static final WebPurchaseRedemption parseAsWebPurchaseRedemption(Intent intent) {
        return Companion.parseAsWebPurchaseRedemption(intent);
    }

    public static final void setDebugLogsEnabled(boolean z2) {
        Companion.setDebugLogsEnabled(z2);
    }

    public static final synchronized void setLogHandler(LogHandler logHandler) {
        Companion.setLogHandler(logHandler);
    }

    public static final void setLogLevel(LogLevel logLevel) {
        Companion.setLogLevel(logLevel);
    }

    public static final void setPlatformInfo(PlatformInfo platformInfo) {
        Companion.setPlatformInfo(platformInfo);
    }

    public static final void setProxyURL(URL url) {
        Companion.setProxyURL(url);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void showInAppMessagesIfNeeded$default(Purchases purchases, Activity activity, List list, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            list = CollectionsKt.listOf(InAppMessageType.BILLING_ISSUES);
        }
        purchases.showInAppMessagesIfNeeded(activity, list);
    }

    public static /* synthetic */ void syncPurchases$default(Purchases purchases, SyncPurchasesCallback syncPurchasesCallback, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            syncPurchasesCallback = null;
        }
        purchases.syncPurchases(syncPurchasesCallback);
    }

    public static /* synthetic */ void trackCustomPaywallImpression$default(Purchases purchases, CustomPaywallImpressionParams customPaywallImpressionParams, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            customPaywallImpressionParams = new CustomPaywallImpressionParams(null, null, 3, null);
        }
        purchases.trackCustomPaywallImpression(customPaywallImpressionParams);
    }

    public final /* synthetic */ Object awaitGetWorkflow(String str, Continuation continuation) throws Throwable {
        final SafeContinuation safeContinuation = new SafeContinuation(IntrinsicsKt.c(continuation));
        this.purchasesOrchestrator.getWorkflow(str, new Purchases$awaitGetWorkflow$2$1(safeContinuation), new Function1<PurchasesError, Unit>() { // from class: com.revenuecat.purchases.Purchases$awaitGetWorkflow$2$2
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

            public final void invoke(PurchasesError it) {
                Intrinsics.checkNotNullParameter(it, "it");
                Continuation<WorkflowDataResult> continuation2 = safeContinuation;
                Result.Companion companion = Result.f139772b;
                continuation2.resumeWith(Result.b(ResultKt.a(new PurchasesException(it))));
            }
        });
        Object objA = safeContinuation.a();
        if (objA == IntrinsicsKt.f()) {
            DebugProbesKt.c(continuation);
        }
        return objA;
    }

    public final void close() {
        this.purchasesOrchestrator.close();
        backingFieldSharedInstance = null;
    }

    public final void collectDeviceIdentifiers() {
        this.purchasesOrchestrator.collectDeviceIdentifiers();
    }

    public final void createSupportTicket(String email, String description, Function1<? super Boolean, Unit> onSuccess, Function1<? super PurchasesError, Unit> onError) {
        Intrinsics.checkNotNullParameter(email, "email");
        Intrinsics.checkNotNullParameter(description, "description");
        Intrinsics.checkNotNullParameter(onSuccess, "onSuccess");
        Intrinsics.checkNotNullParameter(onError, "onError");
        this.purchasesOrchestrator.createSupportTicket(email, description, onSuccess, onError);
    }

    public final /* synthetic */ AdTracker getAdTracker() {
        return this.purchasesOrchestrator.getAdTracker();
    }

    public final synchronized boolean getAllowSharingPlayStoreAccount() {
        return this.purchasesOrchestrator.getAllowSharingPlayStoreAccount();
    }

    public final void getAmazonLWAConsentStatus(GetAmazonLWAConsentStatusCallback callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.purchasesOrchestrator.getAmazonLWAConsentStatus(callback);
    }

    public final synchronized String getAppUserID() {
        return this.purchasesOrchestrator.getAppUserID();
    }

    public final DownloadedFontFamily getCachedFontFamilyOrStartDownload(UiConfig.AppConfig.FontsConfig.FontInfo.Name fontInfo) {
        Intrinsics.checkNotNullParameter(fontInfo, "fontInfo");
        return this.purchasesOrchestrator.getCachedFontFamilyOrStartDownload(fontInfo);
    }

    public final VirtualCurrencies getCachedVirtualCurrencies() {
        return this.purchasesOrchestrator.getCachedVirtualCurrencies();
    }

    public final PurchasesConfiguration getCurrentConfiguration() {
        return this.purchasesOrchestrator.getCurrentConfiguration();
    }

    public final void getCustomerCenterConfigData$purchases_defaultsBc8Release(GetCustomerCenterConfigCallback callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.purchasesOrchestrator.getCustomerCenterConfig(callback);
    }

    public final CustomerCenterListener getCustomerCenterListener() {
        return this.purchasesOrchestrator.getCustomerCenterListener();
    }

    public final void getCustomerInfo(ReceiveCustomerInfoCallback callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.purchasesOrchestrator.getCustomerInfo(CacheFetchPolicy.Companion.m413default(), true, callback);
    }

    public final /* synthetic */ DebugEventListener getDebugEventListener() {
        return this.purchasesOrchestrator.getDebugEventListener();
    }

    public final /* synthetic */ FileRepository getFileRepository() {
        return this.purchasesOrchestrator.getFileRepository();
    }

    public final synchronized boolean getFinishTransactions() {
        return this.purchasesOrchestrator.getFinishTransactions();
    }

    @Deprecated
    public final void getNonSubscriptionSkus(List<String> productIds, GetStoreProductsCallback callback) {
        Intrinsics.checkNotNullParameter(productIds, "productIds");
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.purchasesOrchestrator.getProductsOfTypes(CollectionsKt.toSet(productIds), SetsKt.setOf(ProductType.INAPP), callback);
    }

    public final void getOfferings(ReceiveOfferingsCallback listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        PurchasesOrchestrator.getOfferings$default(this.purchasesOrchestrator, listener, false, 2, null);
    }

    public final synchronized String getPreferredUILocaleOverride() {
        return this.purchasesOrchestrator.getPreferredUILocaleOverride();
    }

    public final void getProducts(List<String> productIds, GetStoreProductsCallback callback) {
        Intrinsics.checkNotNullParameter(productIds, "productIds");
        Intrinsics.checkNotNullParameter(callback, "callback");
        getProducts(productIds, null, callback);
    }

    public final synchronized PurchasesAreCompletedBy getPurchasesAreCompletedBy() {
        try {
        } catch (Throwable th) {
            throw th;
        }
        return this.purchasesOrchestrator.getFinishTransactions() ? PurchasesAreCompletedBy.REVENUECAT : PurchasesAreCompletedBy.MY_APP;
    }

    public final /* synthetic */ PurchasesOrchestrator getPurchasesOrchestrator$purchases_defaultsBc8Release() {
        return this.purchasesOrchestrator;
    }

    public final Store getStore() {
        return this.purchasesOrchestrator.getStore();
    }

    public final synchronized String getStorefrontCountryCode() {
        return this.purchasesOrchestrator.getStorefrontCountryCode();
    }

    public final Locale getStorefrontLocale() {
        return this.purchasesOrchestrator.getStorefrontLocale();
    }

    @Deprecated
    public final void getSubscriptionSkus(List<String> productIds, GetStoreProductsCallback callback) {
        Intrinsics.checkNotNullParameter(productIds, "productIds");
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.purchasesOrchestrator.getProductsOfTypes(CollectionsKt.toSet(productIds), SetsKt.setOf(ProductType.SUBS), callback);
    }

    public final /* synthetic */ TrackedEventListener getTrackedEventListener() {
        return this.purchasesOrchestrator.getTrackedEventListener();
    }

    public final synchronized UpdatedCustomerInfoListener getUpdatedCustomerInfoListener() {
        return this.purchasesOrchestrator.getUpdatedCustomerInfoListener();
    }

    public final void getVirtualCurrencies(GetVirtualCurrenciesCallback callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.purchasesOrchestrator.getVirtualCurrencies(callback);
    }

    public final void invalidateCustomerInfoCache() {
        this.purchasesOrchestrator.invalidateCustomerInfoCache();
    }

    public final void invalidateVirtualCurrenciesCache() {
        this.purchasesOrchestrator.invalidateVirtualCurrenciesCache();
    }

    public final boolean isAnonymous() {
        return this.purchasesOrchestrator.isAnonymous();
    }

    public final void logIn(String newAppUserID) {
        Intrinsics.checkNotNullParameter(newAppUserID, "newAppUserID");
        logIn$default(this, newAppUserID, null, 2, null);
    }

    public final void logOut() {
        logOut$default(this, null, 1, null);
    }

    @Override // com.revenuecat.purchases.LifecycleDelegate
    @Deprecated
    public void onAppBackgrounded() {
        this.purchasesOrchestrator.onAppBackgrounded();
    }

    @Override // com.revenuecat.purchases.LifecycleDelegate
    @Deprecated
    public void onAppForegrounded() {
        this.purchasesOrchestrator.onAppForegrounded();
    }

    public final boolean overridePreferredUILocale(String str) {
        return this.purchasesOrchestrator.overridePreferredUILocale(str);
    }

    public final void purchase(PurchaseParams purchaseParams, PurchaseCallback callback) throws PurchasesException {
        Intrinsics.checkNotNullParameter(purchaseParams, "purchaseParams");
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.purchasesOrchestrator.purchase(purchaseParams, callback);
    }

    @Deprecated
    public final void purchasePackage(Activity activity, Package packageToPurchase, PurchaseCallback listener) throws PurchasesException {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(packageToPurchase, "packageToPurchase");
        Intrinsics.checkNotNullParameter(listener, "listener");
        purchase(new PurchaseParams.Builder(activity, packageToPurchase).build(), listener);
    }

    @Deprecated
    public final void purchaseProduct(Activity activity, StoreProduct storeProduct, PurchaseCallback callback) throws PurchasesException {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(storeProduct, "storeProduct");
        Intrinsics.checkNotNullParameter(callback, "callback");
        purchase(new PurchaseParams.Builder(activity, storeProduct).build(), callback);
    }

    public final void redeemWebPurchase(WebPurchaseRedemption webPurchaseRedemption, RedeemWebPurchaseListener listener) {
        Intrinsics.checkNotNullParameter(webPurchaseRedemption, "webPurchaseRedemption");
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.purchasesOrchestrator.redeemWebPurchase(webPurchaseRedemption, listener);
    }

    public final void removeUpdatedCustomerInfoListener() {
        this.purchasesOrchestrator.removeUpdatedCustomerInfoListener();
    }

    public final void restorePurchases(ReceiveCustomerInfoCallback callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.purchasesOrchestrator.restorePurchases(callback);
    }

    public final void setAd(String str) {
        this.purchasesOrchestrator.setAd(str);
    }

    public final void setAdGroup(String str) {
        this.purchasesOrchestrator.setAdGroup(str);
    }

    public final void setAdjustID(String str) {
        this.purchasesOrchestrator.setAdjustID(str);
    }

    public final void setAirbridgeDeviceID(String str) {
        this.purchasesOrchestrator.setAirbridgeDeviceID(str);
    }

    public final void setAirshipChannelID(String str) {
        this.purchasesOrchestrator.setAirshipChannelID(str);
    }

    public final synchronized void setAllowSharingPlayStoreAccount(boolean z2) {
        this.purchasesOrchestrator.setAllowSharingPlayStoreAccount(z2);
    }

    public final void setAppsFlyerConversionData(Map<?, ?> map) {
        this.purchasesOrchestrator.setAppsFlyerConversionData(map);
    }

    public final void setAppsflyerID(String str) {
        this.purchasesOrchestrator.setAppsflyerID(str);
    }

    public final void setAppstackAttributionParams(Map<String, String> data, SyncAttributesAndOfferingsCallback callback) {
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.purchasesOrchestrator.setAppstackAttributionParams(data, callback);
    }

    public final void setAttributes(Map<String, String> attributes) {
        Intrinsics.checkNotNullParameter(attributes, "attributes");
        this.purchasesOrchestrator.setAttributes(attributes);
    }

    public final void setCampaign(String str) {
        this.purchasesOrchestrator.setCampaign(str);
    }

    public final void setCleverTapID(String str) {
        this.purchasesOrchestrator.setCleverTapID(str);
    }

    public final void setCreative(String str) {
        this.purchasesOrchestrator.setCreative(str);
    }

    public final void setCustomerCenterListener(CustomerCenterListener customerCenterListener) {
        this.purchasesOrchestrator.setCustomerCenterListener(customerCenterListener);
    }

    public final /* synthetic */ void setDebugEventListener(DebugEventListener debugEventListener) {
        this.purchasesOrchestrator.setDebugEventListener(debugEventListener);
    }

    public final void setDisplayName(String str) {
        this.purchasesOrchestrator.setDisplayName(str);
    }

    public final void setEmail(String str) {
        this.purchasesOrchestrator.setEmail(str);
    }

    public final void setFBAnonymousID(String str) {
        this.purchasesOrchestrator.setFBAnonymousID(str);
    }

    public final synchronized void setFinishTransactions(boolean z2) {
        this.purchasesOrchestrator.setFinishTransactions(z2);
    }

    public final void setFirebaseAppInstanceID(String str) {
        this.purchasesOrchestrator.setFirebaseAppInstanceID(str);
    }

    public final void setKeyword(String str) {
        this.purchasesOrchestrator.setKeyword(str);
    }

    public final void setKochavaDeviceID(String str) {
        this.purchasesOrchestrator.setKochavaDeviceID(str);
    }

    public final void setMediaSource(String str) {
        this.purchasesOrchestrator.setMediaSource(str);
    }

    public final void setMixpanelDistinctID(String str) {
        this.purchasesOrchestrator.setMixpanelDistinctID(str);
    }

    public final void setMparticleID(String str) {
        this.purchasesOrchestrator.setMparticleID(str);
    }

    public final void setOnesignalID(String str) {
        this.purchasesOrchestrator.setOnesignalID(str);
    }

    public final void setOnesignalUserID(String str) {
        this.purchasesOrchestrator.setOnesignalUserID(str);
    }

    public final void setPhoneNumber(String str) {
        this.purchasesOrchestrator.setPhoneNumber(str);
    }

    public final void setPostHogUserId(String str) {
        this.purchasesOrchestrator.setPostHogUserId(str);
    }

    public final synchronized void setPurchasesAreCompletedBy(PurchasesAreCompletedBy value) {
        try {
            Intrinsics.checkNotNullParameter(value, "value");
            PurchasesOrchestrator purchasesOrchestrator = this.purchasesOrchestrator;
            int i3 = WhenMappings.$EnumSwitchMapping$0[value.ordinal()];
            boolean z2 = true;
            if (i3 != 1) {
                if (i3 != 2) {
                    throw new NoWhenBranchMatchedException();
                }
                z2 = false;
            }
            purchasesOrchestrator.setFinishTransactions(z2);
        } catch (Throwable th) {
            throw th;
        }
    }

    public final void setPushToken(String str) {
        this.purchasesOrchestrator.setPushToken(str);
    }

    public final void setSolarEngineAccountId(String str) {
        this.purchasesOrchestrator.setSolarEngineAccountId(str);
    }

    public final void setSolarEngineDistinctId(String str) {
        this.purchasesOrchestrator.setSolarEngineDistinctId(str);
    }

    public final void setSolarEngineVisitorId(String str) {
        this.purchasesOrchestrator.setSolarEngineVisitorId(str);
    }

    public final void setTenjinAnalyticsInstallationID(String str) {
        this.purchasesOrchestrator.setTenjinAnalyticsInstallationID(str);
    }

    public final /* synthetic */ void setTrackedEventListener(TrackedEventListener trackedEventListener) {
        this.purchasesOrchestrator.setTrackedEventListener(trackedEventListener);
    }

    public final synchronized void setUpdatedCustomerInfoListener(UpdatedCustomerInfoListener updatedCustomerInfoListener) {
        this.purchasesOrchestrator.setUpdatedCustomerInfoListener(updatedCustomerInfoListener);
    }

    public final void showInAppMessagesIfNeeded(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        showInAppMessagesIfNeeded$default(this, activity, null, 2, null);
    }

    @Deprecated
    public final void syncAmazonPurchase(String productID, String receiptID, String amazonUserID, String str, Double d3) {
        Intrinsics.checkNotNullParameter(productID, "productID");
        Intrinsics.checkNotNullParameter(receiptID, "receiptID");
        Intrinsics.checkNotNullParameter(amazonUserID, "amazonUserID");
        this.purchasesOrchestrator.syncAmazonPurchase(productID, receiptID, amazonUserID, str, d3, null);
    }

    public final void syncAttributesAndOfferingsIfNeeded(SyncAttributesAndOfferingsCallback callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.purchasesOrchestrator.syncAttributesAndOfferingsIfNeeded(callback);
    }

    @Deprecated
    public final void syncObserverModeAmazonPurchase(String productID, String receiptID, String amazonUserID, String str, Double d3) {
        Intrinsics.checkNotNullParameter(productID, "productID");
        Intrinsics.checkNotNullParameter(receiptID, "receiptID");
        Intrinsics.checkNotNullParameter(amazonUserID, "amazonUserID");
        syncAmazonPurchase(productID, receiptID, amazonUserID, str, d3);
    }

    public final void syncPurchases() {
        syncPurchases$default(this, null, 1, null);
    }

    public final /* synthetic */ void track(FeatureEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        this.purchasesOrchestrator.track(event);
    }

    public final void trackCustomPaywallImpression() {
        trackCustomPaywallImpression$default(this, null, 1, null);
    }

    @JvmStatic
    public static final void canMakePayments(Context context, List<? extends BillingFeature> list, Callback<Boolean> callback) {
        Companion.canMakePayments(context, list, callback);
    }

    @JvmStatic
    public static final WebPurchaseRedemption parseAsWebPurchaseRedemption(String str) {
        return Companion.parseAsWebPurchaseRedemption(str);
    }

    public final void getCustomerInfo(CacheFetchPolicy fetchPolicy, ReceiveCustomerInfoCallback callback) {
        Intrinsics.checkNotNullParameter(fetchPolicy, "fetchPolicy");
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.purchasesOrchestrator.getCustomerInfo(fetchPolicy, true, callback);
    }

    public final void getProducts(List<String> productIds, ProductType productType, GetStoreProductsCallback callback) {
        Intrinsics.checkNotNullParameter(productIds, "productIds");
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.purchasesOrchestrator.getProducts(productIds, productType, callback);
    }

    public final void getStorefrontCountryCode(GetStorefrontCallback callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.purchasesOrchestrator.getStorefrontCountryCode(callback);
    }

    public final void getStorefrontLocale(GetStorefrontLocaleCallback callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.purchasesOrchestrator.getStorefrontLocale(callback);
    }

    public final void logIn(String newAppUserID, LogInCallback logInCallback) {
        Intrinsics.checkNotNullParameter(newAppUserID, "newAppUserID");
        this.purchasesOrchestrator.logIn(newAppUserID, logInCallback);
    }

    public final void logOut(ReceiveCustomerInfoCallback receiveCustomerInfoCallback) {
        this.purchasesOrchestrator.logOut(receiveCustomerInfoCallback);
    }

    public final void showInAppMessagesIfNeeded(Activity activity, List<? extends InAppMessageType> inAppMessageTypes) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(inAppMessageTypes, "inAppMessageTypes");
        this.purchasesOrchestrator.showInAppMessagesIfNeeded(activity, inAppMessageTypes);
    }

    public final void syncAmazonPurchase(String productID, String receiptID, String amazonUserID, String str, Double d3, long j3) {
        Intrinsics.checkNotNullParameter(productID, "productID");
        Intrinsics.checkNotNullParameter(receiptID, "receiptID");
        Intrinsics.checkNotNullParameter(amazonUserID, "amazonUserID");
        this.purchasesOrchestrator.syncAmazonPurchase(productID, receiptID, amazonUserID, str, d3, Long.valueOf(j3));
    }

    public final void syncPurchases(SyncPurchasesCallback syncPurchasesCallback) {
        this.purchasesOrchestrator.syncPurchases(syncPurchasesCallback);
    }

    public final void trackCustomPaywallImpression(CustomPaywallImpressionParams params) {
        Intrinsics.checkNotNullParameter(params, "params");
        PurchasesOrchestrator purchasesOrchestrator = this.purchasesOrchestrator;
        String paywallId = params.getPaywallId();
        String offeringId = params.getOfferingId();
        if (offeringId == null) {
            offeringId = this.purchasesOrchestrator.getCachedCurrentOfferingIdentifier();
        }
        purchasesOrchestrator.track(new CustomPaywallEvent.Impression(null, new CustomPaywallEvent.Impression.Data(paywallId, offeringId), 1, null));
    }

    public static /* synthetic */ void getAdTracker$annotations() {
    }

    @Deprecated
    public static /* synthetic */ void getAllowSharingPlayStoreAccount$annotations() {
    }

    public static /* synthetic */ void getDebugEventListener$annotations() {
    }

    public static /* synthetic */ void getFileRepository$annotations() {
    }

    @Deprecated
    public static /* synthetic */ void getFinishTransactions$annotations() {
    }

    public static /* synthetic */ void getStorefrontLocale$annotations() {
    }

    public static /* synthetic */ void getTrackedEventListener$annotations() {
    }
}
