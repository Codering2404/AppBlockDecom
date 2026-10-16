package com.revenuecat.purchases;

import android.os.Handler;
import android.os.Looper;
import com.revenuecat.purchases.SyncPendingPurchaseResult;
import com.revenuecat.purchases.common.Backend;
import com.revenuecat.purchases.common.Config;
import com.revenuecat.purchases.common.DateProvider;
import com.revenuecat.purchases.common.DefaultDateProvider;
import com.revenuecat.purchases.common.DurationExtensionsKt;
import com.revenuecat.purchases.common.LogIntent;
import com.revenuecat.purchases.common.LogUtilsKt;
import com.revenuecat.purchases.common.LogWrapperKt;
import com.revenuecat.purchases.common.caching.DeviceCache;
import com.revenuecat.purchases.common.diagnostics.DiagnosticsTracker;
import com.revenuecat.purchases.common.offlineentitlements.OfflineEntitlementsManager;
import com.revenuecat.purchases.common.responses.CustomerInfoResponseJsonKeys;
import com.revenuecat.purchases.identity.IdentityManager;
import com.revenuecat.purchases.interfaces.ReceiveCustomerInfoCallback;
import com.revenuecat.purchases.strings.CustomerInfoStrings;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.revenuecat.purchases.utils.Result;
import com.sun.jna.Function;
import java.util.Arrays;
import java.util.Date;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.time.Duration;
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
/* JADX INFO: loaded from: classes4.dex */
@Metadata
public final class CustomerInfoHelper {
    public static final Companion Companion = new Companion(null);
    private final Backend backend;
    private final CustomerInfoUpdateHandler customerInfoUpdateHandler;
    private final DateProvider dateProvider;
    private final DeviceCache deviceCache;
    private final DiagnosticsTracker diagnosticsTrackerIfEnabled;
    private final Handler handler;
    private final OfflineEntitlementsManager offlineEntitlementsManager;
    private final PostPendingTransactionsHelper postPendingTransactionsHelper;
    private final boolean uiPreviewMode;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final CustomerInfo createPreviewCustomerInfo$purchases_defaultsBc8Release() throws JSONException {
            Date date = new Date();
            EntitlementInfos entitlementInfos = new EntitlementInfos(MapsKt.emptyMap(), VerificationResult.NOT_REQUESTED);
            Map mapEmptyMap = MapsKt.emptyMap();
            Map mapEmptyMap2 = MapsKt.emptyMap();
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put(CustomerInfoResponseJsonKeys.SUBSCRIPTIONS, new JSONObject());
            jSONObject2.put(CustomerInfoResponseJsonKeys.NON_SUBSCRIPTIONS, new JSONObject());
            Unit unit = Unit.f139807a;
            jSONObject.put(CustomerInfoResponseJsonKeys.SUBSCRIBER, jSONObject2);
            return new CustomerInfo(entitlementInfos, mapEmptyMap, mapEmptyMap2, date, 3, date, IdentityManager.UI_PREVIEW_MODE_APP_USER_ID, null, null, jSONObject);
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[CacheFetchPolicy.values().length];
            try {
                iArr[CacheFetchPolicy.CACHE_ONLY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[CacheFetchPolicy.FETCH_CURRENT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[CacheFetchPolicy.CACHED_OR_FETCHED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[CacheFetchPolicy.NOT_STALE_CACHED_OR_CURRENT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public CustomerInfoHelper(DeviceCache deviceCache, Backend backend, OfflineEntitlementsManager offlineEntitlementsManager, CustomerInfoUpdateHandler customerInfoUpdateHandler, PostPendingTransactionsHelper postPendingTransactionsHelper, DiagnosticsTracker diagnosticsTracker, boolean z2, DateProvider dateProvider, Handler handler) {
        Intrinsics.checkNotNullParameter(deviceCache, "deviceCache");
        Intrinsics.checkNotNullParameter(backend, "backend");
        Intrinsics.checkNotNullParameter(offlineEntitlementsManager, "offlineEntitlementsManager");
        Intrinsics.checkNotNullParameter(customerInfoUpdateHandler, "customerInfoUpdateHandler");
        Intrinsics.checkNotNullParameter(postPendingTransactionsHelper, "postPendingTransactionsHelper");
        Intrinsics.checkNotNullParameter(dateProvider, "dateProvider");
        Intrinsics.checkNotNullParameter(handler, "handler");
        this.deviceCache = deviceCache;
        this.backend = backend;
        this.offlineEntitlementsManager = offlineEntitlementsManager;
        this.customerInfoUpdateHandler = customerInfoUpdateHandler;
        this.postPendingTransactionsHelper = postPendingTransactionsHelper;
        this.diagnosticsTrackerIfEnabled = diagnosticsTracker;
        this.uiPreviewMode = z2;
        this.dateProvider = dateProvider;
        this.handler = handler;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void dispatch(final Function0<Unit> function0) {
        if (Intrinsics.areEqual(Thread.currentThread(), this.handler.getLooper().getThread())) {
            function0.invoke();
        } else {
            this.handler.post(new Runnable() { // from class: com.revenuecat.purchases.a
                @Override // java.lang.Runnable
                public final void run() {
                    function0.invoke();
                }
            });
        }
    }

    private final CustomerInfo getCachedCustomerInfo(String str) {
        CustomerInfo offlineCustomerInfo = this.offlineEntitlementsManager.getOfflineCustomerInfo();
        return offlineCustomerInfo == null ? this.deviceCache.getCachedCustomerInfo$purchases_defaultsBc8Release(str) : offlineCustomerInfo;
    }

    private final void getCustomerInfoCacheOnly(String str, final Function1<? super CustomerInfoDataResult, Unit> function1) {
        LogHandler currentLogHandler;
        String str2;
        String str3;
        if (function1 == null) {
            return;
        }
        final CustomerInfo cachedCustomerInfo = getCachedCustomerInfo(str);
        if (cachedCustomerInfo == null) {
            final PurchasesError purchasesError = new PurchasesError(PurchasesErrorCode.CustomerInfoError, CustomerInfoStrings.MISSING_CACHED_CUSTOMER_INFO);
            LogUtilsKt.errorLog(purchasesError);
            dispatch(new Function0<Unit>() { // from class: com.revenuecat.purchases.CustomerInfoHelper.getCustomerInfoCacheOnly.3
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Object invoke() {
                    m424invoke();
                    return Unit.f139807a;
                }

                /* JADX WARN: Multi-variable type inference failed */
                /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
                public final void m424invoke() {
                    function1.invoke(new CustomerInfoDataResult(new Result.Error(purchasesError), null, 2, 0 == true ? 1 : 0));
                }
            });
            return;
        }
        final LogIntent logIntent = LogIntent.DEBUG;
        Function0<String> function0 = new Function0<String>() { // from class: com.revenuecat.purchases.CustomerInfoHelper$getCustomerInfoCacheOnly$$inlined$log$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                return CollectionsKt.joinToString$default(logIntent.getEmojiList(), "", null, null, 0, null, null, 62, null) + ' ' + CustomerInfoStrings.VENDING_CACHE;
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
        dispatch(new Function0<Unit>() { // from class: com.revenuecat.purchases.CustomerInfoHelper.getCustomerInfoCacheOnly.2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Object invoke() {
                m423invoke();
                return Unit.f139807a;
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
            public final void m423invoke() {
                function1.invoke(new CustomerInfoDataResult(new Result.Success(cachedCustomerInfo), null, 2, 0 == true ? 1 : 0));
            }
        });
    }

    private final void getCustomerInfoCachedOrFetched(String str, boolean z2, boolean z3, final Function1<? super CustomerInfoDataResult, Unit> function1) {
        LogHandler currentLogHandler;
        String str2;
        String str3;
        final CustomerInfo cachedCustomerInfo = getCachedCustomerInfo(str);
        if (cachedCustomerInfo == null) {
            final LogIntent logIntent = LogIntent.DEBUG;
            Function0<String> function0 = new Function0<String>() { // from class: com.revenuecat.purchases.CustomerInfoHelper$getCustomerInfoCachedOrFetched$$inlined$log$2
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return CollectionsKt.joinToString$default(logIntent.getEmojiList(), "", null, null, 0, null, null, 62, null) + ' ' + CustomerInfoStrings.NO_CACHED_CUSTOMERINFO;
                }
            };
            switch (LogWrapperKt.WhenMappings.$EnumSwitchMapping$0[logIntent.ordinal()]) {
                case 1:
                    LogLevel logLevel = LogLevel.DEBUG;
                    LogHandler currentLogHandler2 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                        currentLogHandler2.d("[Purchases] - " + logLevel.name(), (String) function0.invoke());
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
                    LogHandler currentLogHandler5 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel4) <= 0) {
                        currentLogHandler5.d("[Purchases] - " + logLevel4.name(), (String) function0.invoke());
                    }
                    break;
                case 6:
                    LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) function0.invoke(), null);
                    break;
                case 7:
                    LogLevel logLevel5 = LogLevel.INFO;
                    LogHandler currentLogHandler6 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel5) <= 0) {
                        currentLogHandler6.i("[Purchases] - " + logLevel5.name(), (String) function0.invoke());
                    }
                    break;
                case 8:
                    LogLevel logLevel6 = LogLevel.DEBUG;
                    LogHandler currentLogHandler7 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel6) <= 0) {
                        currentLogHandler7.d("[Purchases] - " + logLevel6.name(), (String) function0.invoke());
                    }
                    break;
                case 9:
                    LogLevel logLevel7 = LogLevel.DEBUG;
                    LogHandler currentLogHandler8 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel7) <= 0) {
                        currentLogHandler8.d("[Purchases] - " + logLevel7.name(), (String) function0.invoke());
                    }
                    break;
                case 10:
                    LogLevel logLevel8 = LogLevel.WARN;
                    LogHandler currentLogHandler9 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel8) <= 0) {
                        currentLogHandler9.w("[Purchases] - " + logLevel8.name(), (String) function0.invoke());
                    }
                    break;
                case 11:
                    LogLevel logLevel9 = LogLevel.WARN;
                    LogHandler currentLogHandler10 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel9) <= 0) {
                        currentLogHandler10.w("[Purchases] - " + logLevel9.name(), (String) function0.invoke());
                    }
                    break;
                case 12:
                    LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) function0.invoke(), null);
                    break;
                case 13:
                    LogLevel logLevel10 = LogLevel.WARN;
                    LogHandler currentLogHandler11 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel10) <= 0) {
                        currentLogHandler11.w("[Purchases] - " + logLevel10.name(), (String) function0.invoke());
                    }
                    break;
                case 14:
                    LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) function0.invoke(), null);
                    break;
            }
            postPendingPurchasesAndFetchCustomerInfo(str, z2, z3, function1);
            return;
        }
        final LogIntent logIntent2 = LogIntent.DEBUG;
        Function0<String> function02 = new Function0<String>() { // from class: com.revenuecat.purchases.CustomerInfoHelper$getCustomerInfoCachedOrFetched$$inlined$log$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                return CollectionsKt.joinToString$default(logIntent2.getEmojiList(), "", null, null, 0, null, null, 62, null) + ' ' + CustomerInfoStrings.VENDING_CACHE;
            }
        };
        switch (LogWrapperKt.WhenMappings.$EnumSwitchMapping$0[logIntent2.ordinal()]) {
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
                LogHandler currentLogHandler12 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel12) <= 0) {
                    currentLogHandler12.w("[Purchases] - " + logLevel12.name(), (String) function02.invoke());
                }
                break;
            case 4:
                LogLevel logLevel13 = LogLevel.INFO;
                LogHandler currentLogHandler13 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel13) <= 0) {
                    currentLogHandler13.i("[Purchases] - " + logLevel13.name(), (String) function02.invoke());
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
                LogHandler currentLogHandler14 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel15) <= 0) {
                    currentLogHandler14.i("[Purchases] - " + logLevel15.name(), (String) function02.invoke());
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
        dispatch(new Function0<Unit>() { // from class: com.revenuecat.purchases.CustomerInfoHelper.getCustomerInfoCachedOrFetched.2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Object invoke() {
                m425invoke();
                return Unit.f139807a;
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
            public final void m425invoke() {
                Function1<CustomerInfoDataResult, Unit> function12 = function1;
                if (function12 != null) {
                    function12.invoke(new CustomerInfoDataResult(new Result.Success(cachedCustomerInfo), null, 2, 0 == true ? 1 : 0));
                }
            }
        });
        updateCachedCustomerInfoIfStale(str, z2, z3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ void getCustomerInfoCachedOrFetched$default(CustomerInfoHelper customerInfoHelper, String str, boolean z2, boolean z3, Function1 function1, int i3, Object obj) {
        if ((i3 & 8) != 0) {
            function1 = null;
        }
        customerInfoHelper.getCustomerInfoCachedOrFetched(str, z2, z3, function1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void getCustomerInfoFetchOnly(final String str, boolean z2, final Function1<? super Result<CustomerInfo, PurchasesError>, Unit> function1) {
        this.deviceCache.setCustomerInfoCacheTimestampToNow$purchases_defaultsBc8Release(str);
        this.backend.getCustomerInfo(str, z2, new Function1<CustomerInfo, Unit>() { // from class: com.revenuecat.purchases.CustomerInfoHelper.getCustomerInfoFetchOnly.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((CustomerInfo) obj);
                return Unit.f139807a;
            }

            public final void invoke(final CustomerInfo info) {
                LogHandler currentLogHandler;
                String str2;
                String str3;
                Intrinsics.checkNotNullParameter(info, "info");
                final LogIntent logIntent = LogIntent.RC_SUCCESS;
                Function0<String> function0 = new Function0<String>() { // from class: com.revenuecat.purchases.CustomerInfoHelper$getCustomerInfoFetchOnly$1$invoke$$inlined$log$1
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final String invoke() {
                        return CollectionsKt.joinToString$default(logIntent.getEmojiList(), "", null, null, 0, null, null, 62, null) + ' ' + CustomerInfoStrings.CUSTOMERINFO_UPDATED_FROM_NETWORK;
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
                CustomerInfoHelper.this.offlineEntitlementsManager.resetOfflineCustomerInfoCache();
                CustomerInfoHelper.this.customerInfoUpdateHandler.cacheAndNotifyListeners(info);
                CustomerInfoHelper customerInfoHelper = CustomerInfoHelper.this;
                final Function1<Result<CustomerInfo, PurchasesError>, Unit> function12 = function1;
                customerInfoHelper.dispatch(new Function0<Unit>() { // from class: com.revenuecat.purchases.CustomerInfoHelper.getCustomerInfoFetchOnly.1.2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Object invoke() {
                        m426invoke();
                        return Unit.f139807a;
                    }

                    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
                    public final void m426invoke() {
                        Function1<Result<CustomerInfo, PurchasesError>, Unit> function13 = function12;
                        if (function13 != null) {
                            function13.invoke(new Result.Success(info));
                        }
                    }
                });
            }
        }, new Function2<PurchasesError, Boolean, Unit>() { // from class: com.revenuecat.purchases.CustomerInfoHelper.getCustomerInfoFetchOnly.2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                invoke((PurchasesError) obj, ((Boolean) obj2).booleanValue());
                return Unit.f139807a;
            }

            public final void invoke(final PurchasesError backendError, boolean z3) {
                Intrinsics.checkNotNullParameter(backendError, "backendError");
                LogHandler currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                String str2 = String.format(CustomerInfoStrings.ERROR_FETCHING_CUSTOMER_INFO, Arrays.copyOf(new Object[]{backendError}, 1));
                Intrinsics.checkNotNullExpressionValue(str2, "format(...)");
                currentLogHandler.e("[Purchases] - ERROR", str2, null);
                CustomerInfoHelper.this.deviceCache.clearCustomerInfoCacheTimestamp$purchases_defaultsBc8Release(str);
                if (!CustomerInfoHelper.this.offlineEntitlementsManager.shouldCalculateOfflineCustomerInfoInGetCustomerInfoRequest(z3, str)) {
                    CustomerInfoHelper customerInfoHelper = CustomerInfoHelper.this;
                    final Function1<Result<CustomerInfo, PurchasesError>, Unit> function12 = function1;
                    customerInfoHelper.dispatch(new Function0<Unit>() { // from class: com.revenuecat.purchases.CustomerInfoHelper.getCustomerInfoFetchOnly.2.4
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(0);
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public /* bridge */ /* synthetic */ Object invoke() {
                            m429invoke();
                            return Unit.f139807a;
                        }

                        /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
                        public final void m429invoke() {
                            Function1<Result<CustomerInfo, PurchasesError>, Unit> function13 = function12;
                            if (function13 != null) {
                                function13.invoke(new Result.Error(backendError));
                            }
                        }
                    });
                    return;
                }
                OfflineEntitlementsManager offlineEntitlementsManager = CustomerInfoHelper.this.offlineEntitlementsManager;
                String str3 = str;
                final CustomerInfoHelper customerInfoHelper2 = CustomerInfoHelper.this;
                final Function1<Result<CustomerInfo, PurchasesError>, Unit> function13 = function1;
                Function1<CustomerInfo, Unit> function14 = new Function1<CustomerInfo, Unit>() { // from class: com.revenuecat.purchases.CustomerInfoHelper.getCustomerInfoFetchOnly.2.2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        invoke((CustomerInfo) obj);
                        return Unit.f139807a;
                    }

                    public final void invoke(final CustomerInfo offlineComputedCustomerInfo) {
                        Intrinsics.checkNotNullParameter(offlineComputedCustomerInfo, "offlineComputedCustomerInfo");
                        customerInfoHelper2.customerInfoUpdateHandler.notifyListeners(offlineComputedCustomerInfo);
                        CustomerInfoHelper customerInfoHelper3 = customerInfoHelper2;
                        final Function1<Result<CustomerInfo, PurchasesError>, Unit> function15 = function13;
                        customerInfoHelper3.dispatch(new Function0<Unit>() { // from class: com.revenuecat.purchases.CustomerInfoHelper.getCustomerInfoFetchOnly.2.2.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(0);
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public /* bridge */ /* synthetic */ Object invoke() {
                                m427invoke();
                                return Unit.f139807a;
                            }

                            /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
                            public final void m427invoke() {
                                Function1<Result<CustomerInfo, PurchasesError>, Unit> function16 = function15;
                                if (function16 != null) {
                                    function16.invoke(new Result.Success(offlineComputedCustomerInfo));
                                }
                            }
                        });
                    }
                };
                final CustomerInfoHelper customerInfoHelper3 = CustomerInfoHelper.this;
                final Function1<Result<CustomerInfo, PurchasesError>, Unit> function15 = function1;
                offlineEntitlementsManager.calculateAndCacheOfflineCustomerInfo(str3, function14, new Function1<PurchasesError, Unit>() { // from class: com.revenuecat.purchases.CustomerInfoHelper.getCustomerInfoFetchOnly.2.3
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
                        CustomerInfoHelper customerInfoHelper4 = customerInfoHelper3;
                        final Function1<Result<CustomerInfo, PurchasesError>, Unit> function16 = function15;
                        final PurchasesError purchasesError = backendError;
                        customerInfoHelper4.dispatch(new Function0<Unit>() { // from class: com.revenuecat.purchases.CustomerInfoHelper.getCustomerInfoFetchOnly.2.3.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(0);
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public /* bridge */ /* synthetic */ Object invoke() {
                                m428invoke();
                                return Unit.f139807a;
                            }

                            /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
                            public final void m428invoke() {
                                Function1<Result<CustomerInfo, PurchasesError>, Unit> function17 = function16;
                                if (function17 != null) {
                                    function17.invoke(new Result.Error(purchasesError));
                                }
                            }
                        });
                    }
                });
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ void getCustomerInfoFetchOnly$default(CustomerInfoHelper customerInfoHelper, String str, boolean z2, Function1 function1, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            function1 = null;
        }
        customerInfoHelper.getCustomerInfoFetchOnly(str, z2, function1);
    }

    private final void getCustomerInfoNotStaledCachedOrFetched(String str, boolean z2, boolean z3, Function1<? super CustomerInfoDataResult, Unit> function1) {
        if (this.deviceCache.isCustomerInfoCacheStale$purchases_defaultsBc8Release(str, z2)) {
            postPendingPurchasesAndFetchCustomerInfo(str, z2, z3, function1);
        } else {
            getCustomerInfoCachedOrFetched(str, z2, z3, function1);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ void getCustomerInfoNotStaledCachedOrFetched$default(CustomerInfoHelper customerInfoHelper, String str, boolean z2, boolean z3, Function1 function1, int i3, Object obj) {
        if ((i3 & 8) != 0) {
            function1 = null;
        }
        customerInfoHelper.getCustomerInfoNotStaledCachedOrFetched(str, z2, z3, function1);
    }

    private final void postPendingPurchasesAndFetchCustomerInfo(final String str, final boolean z2, boolean z3, final Function1<? super CustomerInfoDataResult, Unit> function1) {
        this.postPendingTransactionsHelper.syncPendingPurchaseQueue(z3, new Function1<SyncPendingPurchaseResult, Unit>() { // from class: com.revenuecat.purchases.CustomerInfoHelper.postPendingPurchasesAndFetchCustomerInfo.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((SyncPendingPurchaseResult) obj);
                return Unit.f139807a;
            }

            public final void invoke(final SyncPendingPurchaseResult syncResult) {
                LogHandler currentLogHandler;
                String str2;
                String str3;
                Intrinsics.checkNotNullParameter(syncResult, "syncResult");
                if (!(syncResult instanceof SyncPendingPurchaseResult.Success)) {
                    if (syncResult instanceof SyncPendingPurchaseResult.Error) {
                        CustomerInfoHelper customerInfoHelper = CustomerInfoHelper.this;
                        String str4 = str;
                        boolean z4 = z2;
                        final Function1<CustomerInfoDataResult, Unit> function12 = function1;
                        customerInfoHelper.getCustomerInfoFetchOnly(str4, z4, new Function1<Result<? extends CustomerInfo, ? extends PurchasesError>, Unit>() { // from class: com.revenuecat.purchases.CustomerInfoHelper.postPendingPurchasesAndFetchCustomerInfo.1.3
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                invoke((Result<CustomerInfo, PurchasesError>) obj);
                                return Unit.f139807a;
                            }

                            public final void invoke(Result<CustomerInfo, PurchasesError> result) {
                                Intrinsics.checkNotNullParameter(result, "result");
                                Function1<CustomerInfoDataResult, Unit> function13 = function12;
                                if (function13 != null) {
                                    function13.invoke(new CustomerInfoDataResult(result, Boolean.TRUE));
                                }
                            }
                        });
                        return;
                    }
                    if (syncResult instanceof SyncPendingPurchaseResult.AutoSyncDisabled) {
                        CustomerInfoHelper customerInfoHelper2 = CustomerInfoHelper.this;
                        String str5 = str;
                        boolean z5 = z2;
                        final Function1<CustomerInfoDataResult, Unit> function13 = function1;
                        customerInfoHelper2.getCustomerInfoFetchOnly(str5, z5, new Function1<Result<? extends CustomerInfo, ? extends PurchasesError>, Unit>() { // from class: com.revenuecat.purchases.CustomerInfoHelper.postPendingPurchasesAndFetchCustomerInfo.1.4
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                invoke((Result<CustomerInfo, PurchasesError>) obj);
                                return Unit.f139807a;
                            }

                            /* JADX WARN: Multi-variable type inference failed */
                            public final void invoke(Result<CustomerInfo, PurchasesError> result) {
                                Intrinsics.checkNotNullParameter(result, "result");
                                Function1<CustomerInfoDataResult, Unit> function14 = function13;
                                if (function14 != null) {
                                    function14.invoke(new CustomerInfoDataResult(result, null, 2, 0 == true ? 1 : 0));
                                }
                            }
                        });
                        return;
                    }
                    if (syncResult instanceof SyncPendingPurchaseResult.NoPendingPurchasesToSync) {
                        CustomerInfoHelper customerInfoHelper3 = CustomerInfoHelper.this;
                        String str6 = str;
                        boolean z6 = z2;
                        final Function1<CustomerInfoDataResult, Unit> function14 = function1;
                        customerInfoHelper3.getCustomerInfoFetchOnly(str6, z6, new Function1<Result<? extends CustomerInfo, ? extends PurchasesError>, Unit>() { // from class: com.revenuecat.purchases.CustomerInfoHelper.postPendingPurchasesAndFetchCustomerInfo.1.5
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                invoke((Result<CustomerInfo, PurchasesError>) obj);
                                return Unit.f139807a;
                            }

                            public final void invoke(Result<CustomerInfo, PurchasesError> result) {
                                Intrinsics.checkNotNullParameter(result, "result");
                                Function1<CustomerInfoDataResult, Unit> function15 = function14;
                                if (function15 != null) {
                                    function15.invoke(new CustomerInfoDataResult(result, Boolean.FALSE));
                                }
                            }
                        });
                        return;
                    }
                    return;
                }
                final LogIntent logIntent = LogIntent.RC_SUCCESS;
                Function0<String> function0 = new Function0<String>() { // from class: com.revenuecat.purchases.CustomerInfoHelper$postPendingPurchasesAndFetchCustomerInfo$1$invoke$$inlined$log$1
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final String invoke() {
                        return CollectionsKt.joinToString$default(logIntent.getEmojiList(), "", null, null, 0, null, null, 62, null) + ' ' + CustomerInfoStrings.CUSTOMERINFO_UPDATED_FROM_SYNCING_PENDING_PURCHASES;
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
                CustomerInfoHelper customerInfoHelper4 = CustomerInfoHelper.this;
                final Function1<CustomerInfoDataResult, Unit> function15 = function1;
                customerInfoHelper4.dispatch(new Function0<Unit>() { // from class: com.revenuecat.purchases.CustomerInfoHelper.postPendingPurchasesAndFetchCustomerInfo.1.2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Object invoke() {
                        m430invoke();
                        return Unit.f139807a;
                    }

                    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
                    public final void m430invoke() {
                        Function1<CustomerInfoDataResult, Unit> function16 = function15;
                        if (function16 != null) {
                            function16.invoke(new CustomerInfoDataResult(new Result.Success(((SyncPendingPurchaseResult.Success) syncResult).getCustomerInfo()), Boolean.TRUE));
                        }
                    }
                });
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ void postPendingPurchasesAndFetchCustomerInfo$default(CustomerInfoHelper customerInfoHelper, String str, boolean z2, boolean z3, Function1 function1, int i3, Object obj) {
        if ((i3 & 8) != 0) {
            function1 = null;
        }
        customerInfoHelper.postPendingPurchasesAndFetchCustomerInfo(str, z2, z3, function1);
    }

    public static /* synthetic */ void retrieveCustomerInfo$default(CustomerInfoHelper customerInfoHelper, String str, CacheFetchPolicy cacheFetchPolicy, boolean z2, boolean z3, boolean z4, ReceiveCustomerInfoCallback receiveCustomerInfoCallback, int i3, Object obj) {
        if ((i3 & 16) != 0) {
            z4 = false;
        }
        boolean z5 = z4;
        if ((i3 & 32) != 0) {
            receiveCustomerInfoCallback = null;
        }
        customerInfoHelper.retrieveCustomerInfo(str, cacheFetchPolicy, z2, z3, z5, receiveCustomerInfoCallback);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void trackGetCustomerInfoResultIfNeeded(boolean z2, Date date, CustomerInfoDataResult customerInfoDataResult, CacheFetchPolicy cacheFetchPolicy) {
        CustomerInfo customerInfo;
        PurchasesError purchasesError;
        PurchasesErrorCode code;
        EntitlementInfos entitlements;
        if (!z2 || this.diagnosticsTrackerIfEnabled == null) {
            return;
        }
        long jBetween = DurationExtensionsKt.between(Duration.f140631b, date, this.dateProvider.getNow());
        Result<CustomerInfo, PurchasesError> result = customerInfoDataResult.getResult();
        Integer numValueOf = null;
        if (result instanceof Result.Success) {
            customerInfo = (CustomerInfo) ((Result.Success) customerInfoDataResult.getResult()).getValue();
        } else {
            if (!(result instanceof Result.Error)) {
                throw new NoWhenBranchMatchedException();
            }
            customerInfo = null;
        }
        Result<CustomerInfo, PurchasesError> result2 = customerInfoDataResult.getResult();
        if (result2 instanceof Result.Success) {
            purchasesError = null;
        } else {
            if (!(result2 instanceof Result.Error)) {
                throw new NoWhenBranchMatchedException();
            }
            purchasesError = (PurchasesError) ((Result.Error) customerInfoDataResult.getResult()).getValue();
        }
        DiagnosticsTracker diagnosticsTracker = this.diagnosticsTrackerIfEnabled;
        VerificationResult verification = (customerInfo == null || (entitlements = customerInfo.getEntitlements()) == null) ? null : entitlements.getVerification();
        Boolean hadUnsyncedPurchasesBefore = customerInfoDataResult.getHadUnsyncedPurchasesBefore();
        String message = purchasesError != null ? purchasesError.getMessage() : null;
        if (purchasesError != null && (code = purchasesError.getCode()) != null) {
            numValueOf = Integer.valueOf(code.getCode());
        }
        diagnosticsTracker.m533trackGetCustomerInfoResult17CK4j0(cacheFetchPolicy, verification, hadUnsyncedPurchasesBefore, message, numValueOf, jBetween);
    }

    private final void trackGetCustomerInfoStartedIfNeeded(boolean z2) {
        DiagnosticsTracker diagnosticsTracker;
        if (!z2 || (diagnosticsTracker = this.diagnosticsTrackerIfEnabled) == null) {
            return;
        }
        diagnosticsTracker.trackGetCustomerInfoStarted();
    }

    private final void updateCachedCustomerInfoIfStale(String str, final boolean z2, boolean z3) {
        LogHandler currentLogHandler;
        String str2;
        String str3;
        if (this.deviceCache.isCustomerInfoCacheStale$purchases_defaultsBc8Release(str, z2)) {
            final LogIntent logIntent = LogIntent.DEBUG;
            Function0<String> function0 = new Function0<String>() { // from class: com.revenuecat.purchases.CustomerInfoHelper$updateCachedCustomerInfoIfStale$$inlined$log$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    StringBuilder sb = new StringBuilder();
                    sb.append(CollectionsKt.joinToString$default(logIntent.getEmojiList(), "", null, null, 0, null, null, 62, null));
                    sb.append(' ');
                    sb.append(z2 ? CustomerInfoStrings.CUSTOMERINFO_STALE_UPDATING_BACKGROUND : CustomerInfoStrings.CUSTOMERINFO_STALE_UPDATING_FOREGROUND);
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
            postPendingPurchasesAndFetchCustomerInfo$default(this, str, z2, z3, null, 8, null);
        }
    }

    public final void retrieveCustomerInfo(String appUserID, final CacheFetchPolicy fetchPolicy, boolean z2, boolean z3, final boolean z4, final ReceiveCustomerInfoCallback receiveCustomerInfoCallback) {
        Intrinsics.checkNotNullParameter(appUserID, "appUserID");
        Intrinsics.checkNotNullParameter(fetchPolicy, "fetchPolicy");
        if (this.uiPreviewMode) {
            if (receiveCustomerInfoCallback != null) {
                dispatch(new Function0<Unit>() { // from class: com.revenuecat.purchases.CustomerInfoHelper$retrieveCustomerInfo$1$1
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Object invoke() {
                        m431invoke();
                        return Unit.f139807a;
                    }

                    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
                    public final void m431invoke() {
                        receiveCustomerInfoCallback.onReceived(CustomerInfoHelper.Companion.createPreviewCustomerInfo$purchases_defaultsBc8Release());
                    }
                });
                return;
            }
            return;
        }
        LogLevel logLevel = LogLevel.DEBUG;
        LogHandler currentLogHandler = LogWrapperKt.getCurrentLogHandler();
        if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
            String str = "[Purchases] - " + logLevel.name();
            String str2 = String.format(CustomerInfoStrings.RETRIEVING_CUSTOMER_INFO, Arrays.copyOf(new Object[]{fetchPolicy}, 1));
            Intrinsics.checkNotNullExpressionValue(str2, "format(...)");
            currentLogHandler.d(str, str2);
        }
        trackGetCustomerInfoStartedIfNeeded(z4);
        final Date now = this.dateProvider.getNow();
        Function1<CustomerInfoDataResult, Unit> function1 = (receiveCustomerInfoCallback != null || z4) ? new Function1<CustomerInfoDataResult, Unit>() { // from class: com.revenuecat.purchases.CustomerInfoHelper$retrieveCustomerInfo$callbackWithDiagnostics$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((CustomerInfoDataResult) obj);
                return Unit.f139807a;
            }

            public final void invoke(CustomerInfoDataResult customerInfoDataResult) {
                Intrinsics.checkNotNullParameter(customerInfoDataResult, "customerInfoDataResult");
                this.this$0.trackGetCustomerInfoResultIfNeeded(z4, now, customerInfoDataResult, fetchPolicy);
                ReceiveCustomerInfoCallback receiveCustomerInfoCallback2 = receiveCustomerInfoCallback;
                if (receiveCustomerInfoCallback2 != null) {
                    Result<CustomerInfo, PurchasesError> result = customerInfoDataResult.getResult();
                    if (result instanceof Result.Success) {
                        receiveCustomerInfoCallback2.onReceived((CustomerInfo) ((Result.Success) customerInfoDataResult.getResult()).getValue());
                    } else if (result instanceof Result.Error) {
                        receiveCustomerInfoCallback2.onError((PurchasesError) ((Result.Error) customerInfoDataResult.getResult()).getValue());
                    }
                }
            }
        } : null;
        int i3 = WhenMappings.$EnumSwitchMapping$0[fetchPolicy.ordinal()];
        if (i3 == 1) {
            getCustomerInfoCacheOnly(appUserID, function1);
            return;
        }
        if (i3 == 2) {
            postPendingPurchasesAndFetchCustomerInfo(appUserID, z2, z3, function1);
        } else if (i3 == 3) {
            getCustomerInfoCachedOrFetched(appUserID, z2, z3, function1);
        } else {
            if (i3 != 4) {
                return;
            }
            getCustomerInfoNotStaledCachedOrFetched(appUserID, z2, z3, function1);
        }
    }

    public /* synthetic */ CustomerInfoHelper(DeviceCache deviceCache, Backend backend, OfflineEntitlementsManager offlineEntitlementsManager, CustomerInfoUpdateHandler customerInfoUpdateHandler, PostPendingTransactionsHelper postPendingTransactionsHelper, DiagnosticsTracker diagnosticsTracker, boolean z2, DateProvider dateProvider, Handler handler, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(deviceCache, backend, offlineEntitlementsManager, customerInfoUpdateHandler, postPendingTransactionsHelper, diagnosticsTracker, (i3 & 64) != 0 ? false : z2, (i3 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0 ? new DefaultDateProvider() : dateProvider, (i3 & Function.MAX_NARGS) != 0 ? new Handler(Looper.getMainLooper()) : handler);
    }
}
