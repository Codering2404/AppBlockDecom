package com.revenuecat.purchases.common.offerings;

import android.os.Handler;
import android.os.Looper;
import com.revenuecat.purchases.LogHandler;
import com.revenuecat.purchases.LogLevel;
import com.revenuecat.purchases.Offering;
import com.revenuecat.purchases.Offerings;
import com.revenuecat.purchases.PurchasesError;
import com.revenuecat.purchases.PurchasesErrorCode;
import com.revenuecat.purchases.common.Backend;
import com.revenuecat.purchases.common.Config;
import com.revenuecat.purchases.common.DateProvider;
import com.revenuecat.purchases.common.DefaultDateProvider;
import com.revenuecat.purchases.common.DurationExtensionsKt;
import com.revenuecat.purchases.common.GetOfferingsErrorHandlingBehavior;
import com.revenuecat.purchases.common.HTTPResponseOriginalSource;
import com.revenuecat.purchases.common.LogIntent;
import com.revenuecat.purchases.common.LogWrapperKt;
import com.revenuecat.purchases.common.diagnostics.DiagnosticsTracker;
import com.revenuecat.purchases.common.offerings.OfferingsManager;
import com.revenuecat.purchases.paywalls.OfferingFontPreDownloader;
import com.revenuecat.purchases.strings.OfferingStrings;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.revenuecat.purchases.utils.OfferingImagePreDownloader;
import com.sun.jna.Function;
import java.util.Arrays;
import java.util.Date;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.time.Duration;
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
public final class OfferingsManager {
    private final Backend backend;
    private final DateProvider dateProvider;
    private final DiagnosticsTracker diagnosticsTrackerIfEnabled;
    private final Offerings emptyOfferings;
    private final Handler mainHandler;
    private final OfferingFontPreDownloader offeringFontPreDownloader;
    private final OfferingImagePreDownloader offeringImagePreDownloader;
    private final OfferingsCache offeringsCache;
    private final OfferingsFactory offeringsFactory;
    private final boolean uiPreviewMode;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[DiagnosticsTracker.CacheStatus.values().length];
            try {
                iArr[DiagnosticsTracker.CacheStatus.NOT_CHECKED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[DiagnosticsTracker.CacheStatus.NOT_FOUND.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public OfferingsManager(OfferingsCache offeringsCache, Backend backend, OfferingsFactory offeringsFactory, OfferingImagePreDownloader offeringImagePreDownloader, DiagnosticsTracker diagnosticsTracker, OfferingFontPreDownloader offeringFontPreDownloader, boolean z2, DateProvider dateProvider, Handler handler) {
        Intrinsics.checkNotNullParameter(offeringsCache, "offeringsCache");
        Intrinsics.checkNotNullParameter(backend, "backend");
        Intrinsics.checkNotNullParameter(offeringsFactory, "offeringsFactory");
        Intrinsics.checkNotNullParameter(offeringImagePreDownloader, "offeringImagePreDownloader");
        Intrinsics.checkNotNullParameter(offeringFontPreDownloader, "offeringFontPreDownloader");
        Intrinsics.checkNotNullParameter(dateProvider, "dateProvider");
        this.offeringsCache = offeringsCache;
        this.backend = backend;
        this.offeringsFactory = offeringsFactory;
        this.offeringImagePreDownloader = offeringImagePreDownloader;
        this.diagnosticsTrackerIfEnabled = diagnosticsTracker;
        this.offeringFontPreDownloader = offeringFontPreDownloader;
        this.uiPreviewMode = z2;
        this.dateProvider = dateProvider;
        this.mainHandler = handler;
        this.emptyOfferings = new Offerings(null, MapsKt.emptyMap());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void createAndCacheOfferings(final JSONObject jSONObject, HTTPResponseOriginalSource hTTPResponseOriginalSource, boolean z2, final Function1<? super PurchasesError, Unit> function1, final Function1<? super OfferingsResultData, Unit> function12) {
        this.offeringsFactory.createOfferings(jSONObject, hTTPResponseOriginalSource, z2, new Function1<PurchasesError, Unit>() { // from class: com.revenuecat.purchases.common.offerings.OfferingsManager.createAndCacheOfferings.1
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
                OfferingsManager.this.handleErrorFetchingOfferings(error, function1);
            }
        }, new Function1<OfferingsResultData, Unit>() { // from class: com.revenuecat.purchases.common.offerings.OfferingsManager.createAndCacheOfferings.2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((OfferingsResultData) obj);
                return Unit.f139807a;
            }

            public final void invoke(final OfferingsResultData offeringsResultData) {
                Intrinsics.checkNotNullParameter(offeringsResultData, "offeringsResultData");
                Offering current = offeringsResultData.getOfferings().getCurrent();
                if (current != null) {
                    OfferingsManager.this.offeringImagePreDownloader.preDownloadOfferingImages(current);
                }
                OfferingsManager.this.offeringFontPreDownloader.preDownloadOfferingFontsIfNeeded(offeringsResultData.getOfferings());
                OfferingsManager.this.offeringsCache.cacheOfferings(offeringsResultData.getOfferings(), jSONObject);
                OfferingsManager offeringsManager = OfferingsManager.this;
                final Function1<OfferingsResultData, Unit> function13 = function12;
                offeringsManager.dispatch(new Function0<Unit>() { // from class: com.revenuecat.purchases.common.offerings.OfferingsManager.createAndCacheOfferings.2.2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Object invoke() {
                        m554invoke();
                        return Unit.f139807a;
                    }

                    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
                    public final void m554invoke() {
                        Function1<OfferingsResultData, Unit> function14 = function13;
                        if (function14 != null) {
                            function14.invoke(offeringsResultData);
                        }
                    }
                });
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ void createAndCacheOfferings$default(OfferingsManager offeringsManager, JSONObject jSONObject, HTTPResponseOriginalSource hTTPResponseOriginalSource, boolean z2, Function1 function1, Function1 function12, int i3, Object obj) {
        if ((i3 & 8) != 0) {
            function1 = null;
        }
        if ((i3 & 16) != 0) {
            function12 = null;
        }
        offeringsManager.createAndCacheOfferings(jSONObject, hTTPResponseOriginalSource, z2, function1, function12);
    }

    private final Pair<Function2<PurchasesError, DiagnosticsTracker.CacheStatus, Unit>, Function2<OfferingsResultData, DiagnosticsTracker.CacheStatus, Unit>> createTrackedOfferingsCallbacks(final Date date, final Function1<? super PurchasesError, Unit> function1, final Function1<? super Offerings, Unit> function12) {
        return new Pair<>(new Function2<PurchasesError, DiagnosticsTracker.CacheStatus, Unit>() { // from class: com.revenuecat.purchases.common.offerings.OfferingsManager$createTrackedOfferingsCallbacks$onErrorWithTracking$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                invoke((PurchasesError) obj, (DiagnosticsTracker.CacheStatus) obj2);
                return Unit.f139807a;
            }

            public final void invoke(PurchasesError error, DiagnosticsTracker.CacheStatus cacheStatus) {
                Intrinsics.checkNotNullParameter(error, "error");
                Intrinsics.checkNotNullParameter(cacheStatus, "cacheStatus");
                this.this$0.trackGetOfferingsResultIfNeeded(date, cacheStatus, error, null, null);
                Function1<PurchasesError, Unit> function13 = function1;
                if (function13 != null) {
                    function13.invoke(error);
                }
            }
        }, new Function2<OfferingsResultData, DiagnosticsTracker.CacheStatus, Unit>() { // from class: com.revenuecat.purchases.common.offerings.OfferingsManager$createTrackedOfferingsCallbacks$onSuccessWithTracking$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                invoke((OfferingsResultData) obj, (DiagnosticsTracker.CacheStatus) obj2);
                return Unit.f139807a;
            }

            public final void invoke(OfferingsResultData result, DiagnosticsTracker.CacheStatus cacheStatus) {
                Intrinsics.checkNotNullParameter(result, "result");
                Intrinsics.checkNotNullParameter(cacheStatus, "cacheStatus");
                this.this$0.trackGetOfferingsResultIfNeeded(date, cacheStatus, null, result.getRequestedProductIds(), result.getNotFoundProductIds());
                Function1<Offerings, Unit> function13 = function12;
                if (function13 != null) {
                    function13.invoke(result.getOfferings());
                }
            }
        });
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
        handler.post(new Runnable() { // from class: com.revenuecat.purchases.common.offerings.c
            @Override // java.lang.Runnable
            public final void run() {
                function0.invoke();
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void fetchAndCacheOfferings$default(OfferingsManager offeringsManager, String str, boolean z2, Function1 function1, Function1 function12, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            function1 = null;
        }
        if ((i3 & 8) != 0) {
            function12 = null;
        }
        offeringsManager.fetchAndCacheOfferings(str, z2, function1, function12);
    }

    private final void fetchOfferingsFromNetwork(String str, boolean z2, final DiagnosticsTracker.CacheStatus cacheStatus, final Function2<? super PurchasesError, ? super DiagnosticsTracker.CacheStatus, Unit> function2, final Function2<? super OfferingsResultData, ? super DiagnosticsTracker.CacheStatus, Unit> function22) {
        LogHandler currentLogHandler;
        String str2;
        String str3;
        final LogIntent logIntent = LogIntent.DEBUG;
        Function0<String> function0 = new Function0<String>() { // from class: com.revenuecat.purchases.common.offerings.OfferingsManager$fetchOfferingsFromNetwork$$inlined$log$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                String str4;
                StringBuilder sb = new StringBuilder();
                sb.append(CollectionsKt.joinToString$default(logIntent.getEmojiList(), "", null, null, 0, null, null, 62, null));
                sb.append(' ');
                int i3 = OfferingsManager.WhenMappings.$EnumSwitchMapping$0[cacheStatus.ordinal()];
                if (i3 == 1) {
                    str4 = OfferingStrings.FORCE_OFFERINGS_FETCHING_NETWORK;
                } else {
                    if (i3 != 2) {
                        throw new IllegalArgumentException("Unexpected cache status for fetch: " + cacheStatus);
                    }
                    str4 = OfferingStrings.NO_CACHED_OFFERINGS_FETCHING_NETWORK;
                }
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
        fetchAndCacheOfferings(str, z2, new Function1<PurchasesError, Unit>() { // from class: com.revenuecat.purchases.common.offerings.OfferingsManager.fetchOfferingsFromNetwork.2
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
                function2.invoke(it, cacheStatus);
            }
        }, new Function1<OfferingsResultData, Unit>() { // from class: com.revenuecat.purchases.common.offerings.OfferingsManager.fetchOfferingsFromNetwork.3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((OfferingsResultData) obj);
                return Unit.f139807a;
            }

            public final void invoke(OfferingsResultData it) {
                Intrinsics.checkNotNullParameter(it, "it");
                function22.invoke(it, cacheStatus);
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void getOfferings$default(OfferingsManager offeringsManager, String str, boolean z2, Function1 function1, Function1 function12, boolean z3, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            function1 = null;
        }
        if ((i3 & 8) != 0) {
            function12 = null;
        }
        if ((i3 & 16) != 0) {
            z3 = false;
        }
        offeringsManager.getOfferings(str, z2, function1, function12, z3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void handleErrorFetchingOfferings(final PurchasesError purchasesError, final Function1<? super PurchasesError, Unit> function1) {
        LogHandler currentLogHandler;
        String str;
        String str2;
        final LogIntent logIntent = SetsKt.setOf((Object[]) new PurchasesErrorCode[]{PurchasesErrorCode.ConfigurationError, PurchasesErrorCode.UnexpectedBackendResponseError}).contains(purchasesError.getCode()) ? LogIntent.RC_ERROR : LogIntent.GOOGLE_ERROR;
        Function0<String> function0 = new Function0<String>() { // from class: com.revenuecat.purchases.common.offerings.OfferingsManager$handleErrorFetchingOfferings$$inlined$log$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                StringBuilder sb = new StringBuilder();
                sb.append(CollectionsKt.joinToString$default(logIntent.getEmojiList(), "", null, null, 0, null, null, 62, null));
                sb.append(' ');
                String str3 = String.format(OfferingStrings.FETCHING_OFFERINGS_ERROR, Arrays.copyOf(new Object[]{purchasesError}, 1));
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
        this.offeringsCache.forceCacheStale();
        dispatch(new Function0<Unit>() { // from class: com.revenuecat.purchases.common.offerings.OfferingsManager.handleErrorFetchingOfferings.2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Object invoke() {
                m557invoke();
                return Unit.f139807a;
            }

            /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
            public final void m557invoke() {
                Function1<PurchasesError, Unit> function12 = function1;
                if (function12 != null) {
                    function12.invoke(purchasesError);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void trackGetOfferingsResultIfNeeded(Date date, DiagnosticsTracker.CacheStatus cacheStatus, PurchasesError purchasesError, Set<String> set, Set<String> set2) {
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
        diagnosticsTracker.m534trackGetOfferingsResultB8UsjHI(set, set2, message, numValueOf, null, cacheStatus, jBetween);
    }

    private final void trackGetOfferingsStartedIfNeeded() {
        DiagnosticsTracker diagnosticsTracker = this.diagnosticsTrackerIfEnabled;
        if (diagnosticsTracker != null) {
            diagnosticsTracker.trackGetOfferingsStarted();
        }
    }

    private final void vendCachedOfferingsAndMaybeRefresh(String str, final boolean z2, final Offerings offerings, Date date, final Function1<? super Offerings, Unit> function1) {
        LogHandler currentLogHandler;
        String str2;
        String str3;
        final LogIntent logIntent = LogIntent.DEBUG;
        Function0<String> function0 = new Function0<String>() { // from class: com.revenuecat.purchases.common.offerings.OfferingsManager$vendCachedOfferingsAndMaybeRefresh$$inlined$log$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                return CollectionsKt.joinToString$default(logIntent.getEmojiList(), "", null, null, 0, null, null, 62, null) + ' ' + OfferingStrings.VENDING_OFFERINGS_CACHE;
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
        boolean zIsOfferingsCacheStale = this.offeringsCache.isOfferingsCacheStale(z2);
        trackGetOfferingsResultIfNeeded(date, zIsOfferingsCacheStale ? DiagnosticsTracker.CacheStatus.STALE : DiagnosticsTracker.CacheStatus.VALID, null, null, null);
        dispatch(new Function0<Unit>() { // from class: com.revenuecat.purchases.common.offerings.OfferingsManager.vendCachedOfferingsAndMaybeRefresh.2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Object invoke() {
                m558invoke();
                return Unit.f139807a;
            }

            /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
            public final void m558invoke() {
                Function1<Offerings, Unit> function12 = function1;
                if (function12 != null) {
                    function12.invoke(offerings);
                }
            }
        });
        if (zIsOfferingsCacheStale) {
            Function0<String> function02 = new Function0<String>() { // from class: com.revenuecat.purchases.common.offerings.OfferingsManager$vendCachedOfferingsAndMaybeRefresh$$inlined$log$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    StringBuilder sb = new StringBuilder();
                    sb.append(CollectionsKt.joinToString$default(logIntent.getEmojiList(), "", null, null, 0, null, null, 62, null));
                    sb.append(' ');
                    sb.append(z2 ? OfferingStrings.OFFERINGS_STALE_UPDATING_IN_BACKGROUND : OfferingStrings.OFFERINGS_STALE_UPDATING_IN_FOREGROUND);
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
            fetchAndCacheOfferings$default(this, str, z2, null, null, 12, null);
        }
    }

    public final void clearInMemoryOfferingsCache() {
        this.offeringsCache.clearInMemoryOfferingsCache();
    }

    public final void fetchAndCacheOfferings(String appUserID, boolean z2, final Function1<? super PurchasesError, Unit> function1, final Function1<? super OfferingsResultData, Unit> function12) {
        LogHandler currentLogHandler;
        String str;
        String str2;
        Intrinsics.checkNotNullParameter(appUserID, "appUserID");
        if (this.uiPreviewMode) {
            dispatch(new Function0<Unit>() { // from class: com.revenuecat.purchases.common.offerings.OfferingsManager.fetchAndCacheOfferings.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Object invoke() {
                    m555invoke();
                    return Unit.f139807a;
                }

                /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
                public final void m555invoke() {
                    Function1<OfferingsResultData, Unit> function13 = function12;
                    if (function13 != null) {
                        function13.invoke(new OfferingsResultData(this.emptyOfferings, SetsKt.emptySet(), SetsKt.emptySet()));
                    }
                }
            });
            return;
        }
        final LogIntent logIntent = LogIntent.RC_SUCCESS;
        Function0<String> function0 = new Function0<String>() { // from class: com.revenuecat.purchases.common.offerings.OfferingsManager$fetchAndCacheOfferings$$inlined$log$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                return CollectionsKt.joinToString$default(logIntent.getEmojiList(), "", null, null, 0, null, null, 62, null) + ' ' + OfferingStrings.OFFERINGS_START_UPDATE_FROM_NETWORK;
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
        this.backend.getOfferings(appUserID, z2, new Function2<JSONObject, HTTPResponseOriginalSource, Unit>() { // from class: com.revenuecat.purchases.common.offerings.OfferingsManager.fetchAndCacheOfferings.3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                invoke((JSONObject) obj, (HTTPResponseOriginalSource) obj2);
                return Unit.f139807a;
            }

            public final void invoke(JSONObject body, HTTPResponseOriginalSource originalDataSource) {
                Intrinsics.checkNotNullParameter(body, "body");
                Intrinsics.checkNotNullParameter(originalDataSource, "originalDataSource");
                OfferingsManager.this.createAndCacheOfferings(body, originalDataSource, false, function1, function12);
            }
        }, new Function2<PurchasesError, GetOfferingsErrorHandlingBehavior, Unit>() { // from class: com.revenuecat.purchases.common.offerings.OfferingsManager.fetchAndCacheOfferings.4

            /* JADX INFO: renamed from: com.revenuecat.purchases.common.offerings.OfferingsManager$fetchAndCacheOfferings$4$WhenMappings */
            /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
            @Metadata
            public /* synthetic */ class WhenMappings {
                public static final /* synthetic */ int[] $EnumSwitchMapping$0;

                static {
                    int[] iArr = new int[GetOfferingsErrorHandlingBehavior.values().length];
                    try {
                        iArr[GetOfferingsErrorHandlingBehavior.SHOULD_FALLBACK_TO_CACHED_OFFERINGS.ordinal()] = 1;
                    } catch (NoSuchFieldError unused) {
                    }
                    try {
                        iArr[GetOfferingsErrorHandlingBehavior.SHOULD_NOT_FALLBACK.ordinal()] = 2;
                    } catch (NoSuchFieldError unused2) {
                    }
                    $EnumSwitchMapping$0 = iArr;
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                invoke((PurchasesError) obj, (GetOfferingsErrorHandlingBehavior) obj2);
                return Unit.f139807a;
            }

            /* JADX WARN: Removed duplicated region for block: B:24:0x0081  */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public final void invoke(com.revenuecat.purchases.PurchasesError r7, com.revenuecat.purchases.common.GetOfferingsErrorHandlingBehavior r8) {
                /*
                    r6 = this;
                    java.lang.String r0 = "backendError"
                    kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
                    java.lang.String r0 = "errorBehavior"
                    kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
                    int[] r0 = com.revenuecat.purchases.common.offerings.OfferingsManager.AnonymousClass4.WhenMappings.$EnumSwitchMapping$0
                    int r8 = r8.ordinal()
                    r8 = r0[r8]
                    r0 = 1
                    if (r8 == r0) goto L21
                    r0 = 2
                    if (r8 == r0) goto L19
                    return
                L19:
                    com.revenuecat.purchases.common.offerings.OfferingsManager r8 = com.revenuecat.purchases.common.offerings.OfferingsManager.this
                    kotlin.jvm.functions.Function1<com.revenuecat.purchases.PurchasesError, kotlin.Unit> r0 = r2
                    com.revenuecat.purchases.common.offerings.OfferingsManager.access$handleErrorFetchingOfferings(r8, r7, r0)
                    return
                L21:
                    com.revenuecat.purchases.common.offerings.OfferingsManager r8 = com.revenuecat.purchases.common.offerings.OfferingsManager.this
                    com.revenuecat.purchases.common.offerings.OfferingsCache r8 = com.revenuecat.purchases.common.offerings.OfferingsManager.access$getOfferingsCache$p(r8)
                    org.json.JSONObject r1 = r8.getCachedOfferingsResponse()
                    if (r1 != 0) goto L35
                    com.revenuecat.purchases.common.offerings.OfferingsManager r8 = com.revenuecat.purchases.common.offerings.OfferingsManager.this
                    kotlin.jvm.functions.Function1<com.revenuecat.purchases.PurchasesError, kotlin.Unit> r0 = r2
                    com.revenuecat.purchases.common.offerings.OfferingsManager.access$handleErrorFetchingOfferings(r8, r7, r0)
                    return
                L35:
                    com.revenuecat.purchases.LogLevel r7 = com.revenuecat.purchases.LogLevel.WARN
                    com.revenuecat.purchases.LogHandler r8 = com.revenuecat.purchases.common.LogWrapperKt.getCurrentLogHandler()
                    com.revenuecat.purchases.common.Config r0 = com.revenuecat.purchases.common.Config.INSTANCE
                    com.revenuecat.purchases.LogLevel r0 = r0.getLogLevel()
                    int r0 = r0.compareTo(r7)
                    if (r0 > 0) goto L61
                    java.lang.StringBuilder r0 = new java.lang.StringBuilder
                    r0.<init>()
                    java.lang.String r2 = "[Purchases] - "
                    r0.append(r2)
                    java.lang.String r7 = r7.name()
                    r0.append(r7)
                    java.lang.String r7 = r0.toString()
                    java.lang.String r0 = "Error fetching offerings. Using disk cache."
                    r8.w(r7, r0)
                L61:
                    java.lang.String r7 = "rc_original_source"
                    java.lang.String r7 = com.revenuecat.purchases.utils.JSONObjectExtensionsKt.optNullableString(r1, r7)
                    if (r7 == 0) goto L81
                    com.revenuecat.purchases.common.HTTPResponseOriginalSource r7 = com.revenuecat.purchases.common.HTTPResponseOriginalSource.valueOf(r7)     // Catch: java.lang.IllegalArgumentException -> L6e
                    goto L7d
                L6e:
                    r0 = move-exception
                    r7 = r0
                    com.revenuecat.purchases.LogHandler r8 = com.revenuecat.purchases.common.LogWrapperKt.getCurrentLogHandler()
                    r0 = 0
                    java.lang.String r0 = androidx.appcompat.app.jE.vxrlPPpdv.fMhJISFaLfqEfv
                    java.lang.String r2 = "Invalid original data source for cached offerings"
                    r8.e(r0, r2, r7)
                    r7 = 0
                L7d:
                    if (r7 == 0) goto L81
                L7f:
                    r2 = r7
                    goto L84
                L81:
                    com.revenuecat.purchases.common.HTTPResponseOriginalSource r7 = com.revenuecat.purchases.common.HTTPResponseOriginalSource.MAIN
                    goto L7f
                L84:
                    com.revenuecat.purchases.common.offerings.OfferingsManager r0 = com.revenuecat.purchases.common.offerings.OfferingsManager.this
                    kotlin.jvm.functions.Function1<com.revenuecat.purchases.PurchasesError, kotlin.Unit> r4 = r2
                    kotlin.jvm.functions.Function1<com.revenuecat.purchases.common.offerings.OfferingsResultData, kotlin.Unit> r5 = r3
                    r3 = 1
                    com.revenuecat.purchases.common.offerings.OfferingsManager.access$createAndCacheOfferings(r0, r1, r2, r3, r4, r5)
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.revenuecat.purchases.common.offerings.OfferingsManager.AnonymousClass4.invoke(com.revenuecat.purchases.PurchasesError, com.revenuecat.purchases.common.GetOfferingsErrorHandlingBehavior):void");
            }
        });
    }

    public final String getCachedCurrentOfferingIdentifier() {
        Offering current;
        Offerings cachedOfferings = this.offeringsCache.getCachedOfferings();
        if (cachedOfferings == null || (current = cachedOfferings.getCurrent()) == null) {
            return null;
        }
        return current.getIdentifier();
    }

    public final void getOfferings(String appUserID, boolean z2, Function1<? super PurchasesError, Unit> function1, final Function1<? super Offerings, Unit> function12, boolean z3) {
        Intrinsics.checkNotNullParameter(appUserID, "appUserID");
        if (this.uiPreviewMode) {
            dispatch(new Function0<Unit>() { // from class: com.revenuecat.purchases.common.offerings.OfferingsManager.getOfferings.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Object invoke() {
                    m556invoke();
                    return Unit.f139807a;
                }

                /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
                public final void m556invoke() {
                    Function1<Offerings, Unit> function13 = function12;
                    if (function13 != null) {
                        function13.invoke(this.emptyOfferings);
                    }
                }
            });
            return;
        }
        trackGetOfferingsStartedIfNeeded();
        Date now = this.dateProvider.getNow();
        Pair<Function2<PurchasesError, DiagnosticsTracker.CacheStatus, Unit>, Function2<OfferingsResultData, DiagnosticsTracker.CacheStatus, Unit>> pairCreateTrackedOfferingsCallbacks = createTrackedOfferingsCallbacks(now, function1, function12);
        Function2<? super PurchasesError, ? super DiagnosticsTracker.CacheStatus, Unit> function2 = (Function2) pairCreateTrackedOfferingsCallbacks.a();
        Function2<? super OfferingsResultData, ? super DiagnosticsTracker.CacheStatus, Unit> function22 = (Function2) pairCreateTrackedOfferingsCallbacks.b();
        Offerings cachedOfferings = this.offeringsCache.getCachedOfferings();
        if (z3) {
            fetchOfferingsFromNetwork(appUserID, z2, DiagnosticsTracker.CacheStatus.NOT_CHECKED, function2, function22);
        } else if (cachedOfferings == null) {
            fetchOfferingsFromNetwork(appUserID, z2, DiagnosticsTracker.CacheStatus.NOT_FOUND, function2, function22);
        } else {
            vendCachedOfferingsAndMaybeRefresh(appUserID, z2, cachedOfferings, now, function12);
        }
    }

    public final void onAppForeground(String appUserID) {
        LogHandler currentLogHandler;
        String str;
        String str2;
        Intrinsics.checkNotNullParameter(appUserID, "appUserID");
        if (!this.uiPreviewMode && this.offeringsCache.isOfferingsCacheStale(false)) {
            final LogIntent logIntent = LogIntent.DEBUG;
            Function0<String> function0 = new Function0<String>() { // from class: com.revenuecat.purchases.common.offerings.OfferingsManager$onAppForeground$$inlined$log$1
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return CollectionsKt.joinToString$default(logIntent.getEmojiList(), "", null, null, 0, null, null, 62, null) + ' ' + OfferingStrings.OFFERINGS_STALE_UPDATING_IN_FOREGROUND;
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
            fetchAndCacheOfferings$default(this, appUserID, false, null, null, 12, null);
        }
    }

    public /* synthetic */ OfferingsManager(OfferingsCache offeringsCache, Backend backend, OfferingsFactory offeringsFactory, OfferingImagePreDownloader offeringImagePreDownloader, DiagnosticsTracker diagnosticsTracker, OfferingFontPreDownloader offeringFontPreDownloader, boolean z2, DateProvider dateProvider, Handler handler, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(offeringsCache, backend, offeringsFactory, offeringImagePreDownloader, diagnosticsTracker, offeringFontPreDownloader, (i3 & 64) != 0 ? false : z2, (i3 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0 ? new DefaultDateProvider() : dateProvider, (i3 & Function.MAX_NARGS) != 0 ? new Handler(Looper.getMainLooper()) : handler);
    }
}
