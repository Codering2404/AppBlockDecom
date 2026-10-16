package com.revenuecat.purchases.identity;

import android.content.SharedPreferences;
import com.revenuecat.purchases.CustomerInfo;
import com.revenuecat.purchases.LogHandler;
import com.revenuecat.purchases.LogLevel;
import com.revenuecat.purchases.PurchasesError;
import com.revenuecat.purchases.PurchasesErrorCode;
import com.revenuecat.purchases.PurchasesException;
import com.revenuecat.purchases.VerificationResult;
import com.revenuecat.purchases.common.Backend;
import com.revenuecat.purchases.common.CancellableContinuationExtensionsKt;
import com.revenuecat.purchases.common.Config;
import com.revenuecat.purchases.common.Delay;
import com.revenuecat.purchases.common.Dispatcher;
import com.revenuecat.purchases.common.LogIntent;
import com.revenuecat.purchases.common.LogUtilsKt;
import com.revenuecat.purchases.common.LogWrapperKt;
import com.revenuecat.purchases.common.caching.DeviceCache;
import com.revenuecat.purchases.common.offerings.OfferingsCache;
import com.revenuecat.purchases.common.offlineentitlements.OfflineEntitlementsManager;
import com.revenuecat.purchases.common.verification.SignatureVerificationMode;
import com.revenuecat.purchases.strings.IdentityStrings;
import com.revenuecat.purchases.subscriberattributes.SubscriberAttributesManager;
import com.revenuecat.purchases.subscriberattributes.caching.SubscriberAttributesCache;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import java.util.Arrays;
import java.util.Locale;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CancellableContinuationImpl;

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
public final class IdentityManager {
    public static final String UI_PREVIEW_MODE_APP_USER_ID = "$RC_PREVIEW_MODE_USER";
    private final Backend backend;
    private final DeviceCache deviceCache;
    private final Dispatcher dispatcher;
    private final OfferingsCache offeringsCache;
    private final OfflineEntitlementsManager offlineEntitlementsManager;
    private final SubscriberAttributesCache subscriberAttributesCache;
    private final SubscriberAttributesManager subscriberAttributesManager;
    private final boolean uiPreviewMode;
    public static final Companion Companion = new Companion(null);
    private static final Regex anonymousIdRegex = new Regex("^\\$RCAnonymousID:([a-f0-9]{32})$");

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final boolean isUserIDAnonymous(String appUserID) {
            Intrinsics.checkNotNullParameter(appUserID, "appUserID");
            return IdentityManager.anonymousIdRegex.k(appUserID);
        }

        private Companion() {
        }
    }

    public IdentityManager(DeviceCache deviceCache, SubscriberAttributesCache subscriberAttributesCache, SubscriberAttributesManager subscriberAttributesManager, OfferingsCache offeringsCache, Backend backend, OfflineEntitlementsManager offlineEntitlementsManager, Dispatcher dispatcher, boolean z2) {
        Intrinsics.checkNotNullParameter(deviceCache, "deviceCache");
        Intrinsics.checkNotNullParameter(subscriberAttributesCache, "subscriberAttributesCache");
        Intrinsics.checkNotNullParameter(subscriberAttributesManager, "subscriberAttributesManager");
        Intrinsics.checkNotNullParameter(offeringsCache, "offeringsCache");
        Intrinsics.checkNotNullParameter(backend, "backend");
        Intrinsics.checkNotNullParameter(offlineEntitlementsManager, "offlineEntitlementsManager");
        Intrinsics.checkNotNullParameter(dispatcher, "dispatcher");
        this.deviceCache = deviceCache;
        this.subscriberAttributesCache = subscriberAttributesCache;
        this.subscriberAttributesManager = subscriberAttributesManager;
        this.offeringsCache = offeringsCache;
        this.backend = backend;
        this.offlineEntitlementsManager = offlineEntitlementsManager;
        this.dispatcher = dispatcher;
        this.uiPreviewMode = z2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void copySubscriberAttributesToNewUserIfOldIsAnonymous(String str, String str2) {
        if (Companion.isUserIDAnonymous(str)) {
            this.subscriberAttributesManager.copyUnsyncedSubscriberAttributes(str, str2);
        }
    }

    private final synchronized void enqueue(final Function0<Unit> function0) {
        this.dispatcher.enqueue(new Runnable() { // from class: com.revenuecat.purchases.identity.a
            @Override // java.lang.Runnable
            public final void run() {
                function0.invoke();
            }
        }, Delay.NONE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String generateRandomID() {
        LogHandler currentLogHandler;
        String str;
        String str2;
        StringBuilder sb = new StringBuilder();
        sb.append("$RCAnonymousID:");
        String string = UUID.randomUUID().toString();
        Intrinsics.checkNotNullExpressionValue(string, "randomUUID().toString()");
        Locale ROOT = Locale.ROOT;
        Intrinsics.checkNotNullExpressionValue(ROOT, "ROOT");
        String lowerCase = string.toLowerCase(ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        String strO = StringsKt.O(lowerCase, "-", "", false, 4, null);
        final LogIntent logIntent = LogIntent.USER;
        Function0<String> function0 = new Function0<String>() { // from class: com.revenuecat.purchases.identity.IdentityManager$generateRandomID$lambda$12$$inlined$log$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                return CollectionsKt.joinToString$default(logIntent.getEmojiList(), "", null, null, 0, null, null, 62, null) + ' ' + IdentityStrings.SETTING_NEW_ANON_ID;
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
        sb.append(strO);
        return sb.toString();
    }

    private final void invalidateETagCacheIfNeeded(String str) {
        if (!Intrinsics.areEqual(this.backend.getVerificationMode(), SignatureVerificationMode.Disabled.INSTANCE) && shouldInvalidateETagCache(this.deviceCache.getCachedCustomerInfo$purchases_defaultsBc8Release(str))) {
            LogLevel logLevel = LogLevel.INFO;
            LogHandler currentLogHandler = LogWrapperKt.getCurrentLogHandler();
            if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                currentLogHandler.i("[Purchases] - " + logLevel.name(), IdentityStrings.INVALIDATING_CACHED_ETAG_CACHE);
            }
            this.backend.clearCaches();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final synchronized void resetAndSaveUserID(String str) {
        this.deviceCache.clearCachesForAppUserID$purchases_defaultsBc8Release(getCurrentAppUserID());
        this.offeringsCache.clearCache();
        this.subscriberAttributesCache.clearSubscriberAttributesIfSyncedForSubscriber(getCurrentAppUserID());
        this.offlineEntitlementsManager.resetOfflineCustomerInfoCache();
        this.deviceCache.cacheAppUserID$purchases_defaultsBc8Release(str);
        this.backend.clearCaches();
    }

    private final boolean shouldInvalidateETagCache(CustomerInfo customerInfo) {
        return (customerInfo == null || customerInfo.getEntitlements().getVerification() != VerificationResult.NOT_REQUESTED || Intrinsics.areEqual(this.backend.getVerificationMode(), SignatureVerificationMode.Disabled.INSTANCE)) ? false : true;
    }

    public final Object aliasCurrentUserIdTo(final String str, Continuation<? super Unit> continuation) {
        final String currentAppUserID = getCurrentAppUserID();
        final CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.c(continuation), 1);
        cancellableContinuationImpl.C();
        this.backend.aliasUsers(str, currentAppUserID, new Function0<Unit>() { // from class: com.revenuecat.purchases.identity.IdentityManager$aliasCurrentUserIdTo$2$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Object invoke() {
                m566invoke();
                return Unit.f139807a;
            }

            /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
            public final void m566invoke() {
                LogHandler currentLogHandler;
                String str2;
                String str3;
                IdentityManager identityManager = this.this$0;
                final String str4 = currentAppUserID;
                final String str5 = str;
                synchronized (identityManager) {
                    try {
                        final LogIntent logIntent = LogIntent.USER;
                        Function0<String> function0 = new Function0<String>() { // from class: com.revenuecat.purchases.identity.IdentityManager$aliasCurrentUserIdTo$2$1$invoke$lambda$1$$inlined$log$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(0);
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public final String invoke() {
                                StringBuilder sb = new StringBuilder();
                                sb.append(CollectionsKt.joinToString$default(logIntent.getEmojiList(), "", null, null, 0, null, null, 62, null));
                                sb.append(' ');
                                String str6 = String.format(IdentityStrings.ALIAS_OLD_USER_ID_TO_CURRENT_SUCCESSFUL, Arrays.copyOf(new Object[]{str5, str4}, 2));
                                Intrinsics.checkNotNullExpressionValue(str6, "format(...)");
                                sb.append(str6);
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
                        identityManager.offeringsCache.clearCache();
                        identityManager.deviceCache.clearCustomerInfoCache$purchases_defaultsBc8Release(str4);
                        identityManager.offlineEntitlementsManager.resetOfflineCustomerInfoCache();
                        Unit unit = Unit.f139807a;
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                CancellableContinuationExtensionsKt.safeResume(cancellableContinuationImpl, Unit.f139807a);
            }
        }, new Function1<PurchasesError, Unit>() { // from class: com.revenuecat.purchases.identity.IdentityManager$aliasCurrentUserIdTo$2$2
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
                CancellableContinuationExtensionsKt.safeResumeWithException(cancellableContinuationImpl, new PurchasesException(error));
            }
        });
        Object objV = cancellableContinuationImpl.v();
        if (objV == IntrinsicsKt.f()) {
            DebugProbesKt.c(continuation);
        }
        return objV == IntrinsicsKt.f() ? objV : Unit.f139807a;
    }

    public final synchronized void configure(final String str) {
        LogHandler currentLogHandler;
        String str2;
        String str3;
        try {
            if (this.uiPreviewMode) {
                final LogIntent logIntent = LogIntent.USER;
                Function0<String> function0 = new Function0<String>() { // from class: com.revenuecat.purchases.identity.IdentityManager$configure$$inlined$log$1
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final String invoke() {
                        return CollectionsKt.joinToString$default(logIntent.getEmojiList(), "", null, null, 0, null, null, 62, null) + ' ' + IdentityStrings.CONFIGURING_WITH_PREVIEW_MODE_USER_ID;
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
                str = UI_PREVIEW_MODE_APP_USER_ID;
            } else if (str == null || StringsKt.p0(str)) {
                if (str != null && StringsKt.p0(str)) {
                    final LogIntent logIntent2 = LogIntent.WARNING;
                    Function0<String> function02 = new Function0<String>() { // from class: com.revenuecat.purchases.identity.IdentityManager$configure$$inlined$log$2
                        {
                            super(0);
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public final String invoke() {
                            return CollectionsKt.joinToString$default(logIntent2.getEmojiList(), "", null, null, 0, null, null, 62, null) + ' ' + IdentityStrings.EMPTY_APP_USER_ID_WILL_BECOME_ANONYMOUS;
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
                str = this.deviceCache.getCachedAppUserID$purchases_defaultsBc8Release();
                if (str == null && (str = this.deviceCache.getLegacyCachedAppUserID$purchases_defaultsBc8Release()) == null) {
                    str = generateRandomID();
                }
            }
            final LogIntent logIntent3 = LogIntent.USER;
            Function0<String> function03 = new Function0<String>() { // from class: com.revenuecat.purchases.identity.IdentityManager$configure$$inlined$log$3
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    StringBuilder sb = new StringBuilder();
                    sb.append(CollectionsKt.joinToString$default(logIntent3.getEmojiList(), "", null, null, 0, null, null, 62, null));
                    sb.append(' ');
                    String str4 = String.format(IdentityStrings.IDENTIFYING_APP_USER_ID, Arrays.copyOf(new Object[]{str}, 1));
                    Intrinsics.checkNotNullExpressionValue(str4, "format(...)");
                    sb.append(str4);
                    return sb.toString();
                }
            };
            switch (LogWrapperKt.WhenMappings.$EnumSwitchMapping$0[logIntent3.ordinal()]) {
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
            SharedPreferences.Editor editorStartEditing$purchases_defaultsBc8Release = this.deviceCache.startEditing$purchases_defaultsBc8Release();
            this.deviceCache.cacheAppUserID$purchases_defaultsBc8Release(str, editorStartEditing$purchases_defaultsBc8Release);
            this.subscriberAttributesCache.cleanUpSubscriberAttributeCache(str, editorStartEditing$purchases_defaultsBc8Release);
            invalidateETagCacheIfNeeded(str);
            editorStartEditing$purchases_defaultsBc8Release.apply();
            enqueue(new Function0<Unit>() { // from class: com.revenuecat.purchases.identity.IdentityManager.configure.2
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Object invoke() {
                    m567invoke();
                    return Unit.f139807a;
                }

                /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
                public final void m567invoke() {
                    IdentityManager.this.deviceCache.cleanupOldAttributionData$purchases_defaultsBc8Release();
                }
            });
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized boolean currentUserIsAnonymous() {
        Companion companion;
        String cachedAppUserID$purchases_defaultsBc8Release;
        try {
            companion = Companion;
            cachedAppUserID$purchases_defaultsBc8Release = this.deviceCache.getCachedAppUserID$purchases_defaultsBc8Release();
            if (cachedAppUserID$purchases_defaultsBc8Release == null) {
                cachedAppUserID$purchases_defaultsBc8Release = "";
            }
        } catch (Throwable th) {
            throw th;
        }
        return companion.isUserIDAnonymous(cachedAppUserID$purchases_defaultsBc8Release) || Intrinsics.areEqual(this.deviceCache.getCachedAppUserID$purchases_defaultsBc8Release(), this.deviceCache.getLegacyCachedAppUserID$purchases_defaultsBc8Release());
    }

    public final String getCurrentAppUserID() {
        String cachedAppUserID$purchases_defaultsBc8Release = this.deviceCache.getCachedAppUserID$purchases_defaultsBc8Release();
        return cachedAppUserID$purchases_defaultsBc8Release == null ? "" : cachedAppUserID$purchases_defaultsBc8Release;
    }

    public final void logIn(final String newAppUserID, final Function2<? super CustomerInfo, ? super Boolean, Unit> onSuccess, final Function1<? super PurchasesError, Unit> onError) {
        LogHandler currentLogHandler;
        String str;
        String str2;
        Intrinsics.checkNotNullParameter(newAppUserID, "newAppUserID");
        Intrinsics.checkNotNullParameter(onSuccess, "onSuccess");
        Intrinsics.checkNotNullParameter(onError, "onError");
        if (Intrinsics.areEqual(getCurrentAppUserID(), UI_PREVIEW_MODE_APP_USER_ID) || Intrinsics.areEqual(newAppUserID, UI_PREVIEW_MODE_APP_USER_ID)) {
            PurchasesError purchasesError = new PurchasesError(PurchasesErrorCode.UnsupportedError, IdentityStrings.OPERATION_NOT_SUPPORTED_IN_PREVIEW_MODE);
            LogUtilsKt.errorLog(purchasesError);
            onError.invoke(purchasesError);
            return;
        }
        if (StringsKt.p0(newAppUserID)) {
            PurchasesError purchasesError2 = new PurchasesError(PurchasesErrorCode.InvalidAppUserIdError, IdentityStrings.LOG_IN_ERROR_MISSING_APP_USER_ID);
            LogUtilsKt.errorLog(purchasesError2);
            onError.invoke(purchasesError2);
            return;
        }
        final LogIntent logIntent = LogIntent.USER;
        Function0<String> function0 = new Function0<String>() { // from class: com.revenuecat.purchases.identity.IdentityManager$logIn$$inlined$log$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                StringBuilder sb = new StringBuilder();
                sb.append(CollectionsKt.joinToString$default(logIntent.getEmojiList(), "", null, null, 0, null, null, 62, null));
                sb.append(' ');
                String str3 = String.format(IdentityStrings.LOGGING_IN, Arrays.copyOf(new Object[]{this.getCurrentAppUserID(), newAppUserID}, 2));
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
        final String currentAppUserID = getCurrentAppUserID();
        this.subscriberAttributesManager.synchronizeSubscriberAttributesForAllUsers(newAppUserID, new Function0<Unit>() { // from class: com.revenuecat.purchases.identity.IdentityManager.logIn.4
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Object invoke() {
                m568invoke();
                return Unit.f139807a;
            }

            /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
            public final void m568invoke() {
                Backend backend = IdentityManager.this.backend;
                final String str3 = currentAppUserID;
                final String str4 = newAppUserID;
                final IdentityManager identityManager = IdentityManager.this;
                final Function2<CustomerInfo, Boolean, Unit> function2 = onSuccess;
                backend.logIn(str3, str4, new Function2<CustomerInfo, Boolean, Unit>() { // from class: com.revenuecat.purchases.identity.IdentityManager.logIn.4.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                        invoke((CustomerInfo) obj, ((Boolean) obj2).booleanValue());
                        return Unit.f139807a;
                    }

                    public final void invoke(CustomerInfo customerInfo, final boolean z2) {
                        LogHandler currentLogHandler8;
                        String str5;
                        String str6;
                        Intrinsics.checkNotNullParameter(customerInfo, "customerInfo");
                        IdentityManager identityManager2 = identityManager;
                        String str7 = str3;
                        final String str8 = str4;
                        synchronized (identityManager2) {
                            try {
                                final LogIntent logIntent2 = LogIntent.USER;
                                Function0<String> function02 = new Function0<String>() { // from class: com.revenuecat.purchases.identity.IdentityManager$logIn$4$1$invoke$lambda$1$$inlined$log$1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(0);
                                    }

                                    @Override // kotlin.jvm.functions.Function0
                                    public final String invoke() {
                                        StringBuilder sb = new StringBuilder();
                                        sb.append(CollectionsKt.joinToString$default(logIntent2.getEmojiList(), "", null, null, 0, null, null, 62, null));
                                        sb.append(' ');
                                        String str9 = String.format(IdentityStrings.LOG_IN_SUCCESSFUL, Arrays.copyOf(new Object[]{str8, Boolean.valueOf(z2)}, 2));
                                        Intrinsics.checkNotNullExpressionValue(str9, "format(...)");
                                        sb.append(str9);
                                        return sb.toString();
                                    }
                                };
                                switch (LogWrapperKt.WhenMappings.$EnumSwitchMapping$0[logIntent2.ordinal()]) {
                                    case 1:
                                        LogLevel logLevel11 = LogLevel.DEBUG;
                                        currentLogHandler8 = LogWrapperKt.getCurrentLogHandler();
                                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel11) <= 0) {
                                            str5 = "[Purchases] - " + logLevel11.name();
                                            str6 = (String) function02.invoke();
                                            currentLogHandler8.d(str5, str6);
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
                                            str5 = "[Purchases] - " + logLevel14.name();
                                            str6 = (String) function02.invoke();
                                            currentLogHandler8.d(str5, str6);
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
                                            str5 = "[Purchases] - " + logLevel16.name();
                                            str6 = (String) function02.invoke();
                                            currentLogHandler8.d(str5, str6);
                                        }
                                        break;
                                    case 9:
                                        LogLevel logLevel17 = LogLevel.DEBUG;
                                        currentLogHandler8 = LogWrapperKt.getCurrentLogHandler();
                                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel17) <= 0) {
                                            str5 = "[Purchases] - " + logLevel17.name();
                                            str6 = (String) function02.invoke();
                                            currentLogHandler8.d(str5, str6);
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
                                identityManager2.deviceCache.clearCachesForAppUserID$purchases_defaultsBc8Release(str7);
                                identityManager2.offeringsCache.clearCache();
                                identityManager2.subscriberAttributesCache.clearSubscriberAttributesIfSyncedForSubscriber(str7);
                                identityManager2.deviceCache.cacheAppUserID$purchases_defaultsBc8Release(str8);
                                identityManager2.deviceCache.cacheCustomerInfo$purchases_defaultsBc8Release(str8, customerInfo);
                                identityManager2.copySubscriberAttributesToNewUserIfOldIsAnonymous(str7, str8);
                                identityManager2.offlineEntitlementsManager.resetOfflineCustomerInfoCache();
                                Unit unit = Unit.f139807a;
                            } catch (Throwable th) {
                                throw th;
                            }
                        }
                        function2.invoke(customerInfo, Boolean.valueOf(z2));
                    }
                }, onError);
            }
        });
    }

    public final synchronized void logOut(final Function1<? super PurchasesError, Unit> completion) {
        LogHandler currentLogHandler;
        String str;
        String str2;
        Intrinsics.checkNotNullParameter(completion, "completion");
        if (Intrinsics.areEqual(getCurrentAppUserID(), UI_PREVIEW_MODE_APP_USER_ID)) {
            PurchasesError purchasesError = new PurchasesError(PurchasesErrorCode.UnsupportedError, IdentityStrings.OPERATION_NOT_SUPPORTED_IN_PREVIEW_MODE);
            LogUtilsKt.errorLog(purchasesError);
            completion.invoke(purchasesError);
            return;
        }
        if (!currentUserIsAnonymous()) {
            this.subscriberAttributesManager.synchronizeSubscriberAttributesForAllUsers(getCurrentAppUserID(), new Function0<Unit>() { // from class: com.revenuecat.purchases.identity.IdentityManager.logOut.3
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Object invoke() {
                    m569invoke();
                    return Unit.f139807a;
                }

                /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
                public final void m569invoke() {
                    LogHandler currentLogHandler2;
                    String str3;
                    String str4;
                    IdentityManager identityManager = IdentityManager.this;
                    identityManager.resetAndSaveUserID(identityManager.generateRandomID());
                    final LogIntent logIntent = LogIntent.USER;
                    Function0<String> function0 = new Function0<String>() { // from class: com.revenuecat.purchases.identity.IdentityManager$logOut$3$invoke$$inlined$log$1
                        {
                            super(0);
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public final String invoke() {
                            return CollectionsKt.joinToString$default(logIntent.getEmojiList(), "", null, null, 0, null, null, 62, null) + ' ' + IdentityStrings.LOG_OUT_SUCCESSFUL;
                        }
                    };
                    switch (LogWrapperKt.WhenMappings.$EnumSwitchMapping$0[logIntent.ordinal()]) {
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
                    completion.invoke(null);
                }
            });
            return;
        }
        final LogIntent logIntent = LogIntent.RC_ERROR;
        Function0<String> function0 = new Function0<String>() { // from class: com.revenuecat.purchases.identity.IdentityManager$logOut$$inlined$log$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                return CollectionsKt.joinToString$default(logIntent.getEmojiList(), "", null, null, 0, null, null, 62, null) + ' ' + IdentityStrings.LOG_OUT_CALLED_ON_ANONYMOUS_USER;
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
        completion.invoke(new PurchasesError(PurchasesErrorCode.LogOutWithAnonymousUserError, null, 2, null));
    }

    public final void switchUser(String newAppUserID) {
        Intrinsics.checkNotNullParameter(newAppUserID, "newAppUserID");
        if (Intrinsics.areEqual(getCurrentAppUserID(), UI_PREVIEW_MODE_APP_USER_ID) || Intrinsics.areEqual(newAppUserID, UI_PREVIEW_MODE_APP_USER_ID)) {
            LogUtilsKt.errorLog(new PurchasesError(PurchasesErrorCode.UnsupportedError, IdentityStrings.OPERATION_NOT_SUPPORTED_IN_PREVIEW_MODE));
            return;
        }
        LogLevel logLevel = LogLevel.DEBUG;
        LogHandler currentLogHandler = LogWrapperKt.getCurrentLogHandler();
        if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
            String str = "[Purchases] - " + logLevel.name();
            String str2 = String.format(IdentityStrings.SWITCHING_USER, Arrays.copyOf(new Object[]{newAppUserID}, 1));
            Intrinsics.checkNotNullExpressionValue(str2, "format(...)");
            currentLogHandler.d(str, str2);
        }
        resetAndSaveUserID(newAppUserID);
    }

    public /* synthetic */ IdentityManager(DeviceCache deviceCache, SubscriberAttributesCache subscriberAttributesCache, SubscriberAttributesManager subscriberAttributesManager, OfferingsCache offeringsCache, Backend backend, OfflineEntitlementsManager offlineEntitlementsManager, Dispatcher dispatcher, boolean z2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(deviceCache, subscriberAttributesCache, subscriberAttributesManager, offeringsCache, backend, offlineEntitlementsManager, dispatcher, (i3 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0 ? false : z2);
    }
}
