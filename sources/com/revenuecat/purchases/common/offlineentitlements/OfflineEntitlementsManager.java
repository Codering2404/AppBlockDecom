package com.revenuecat.purchases.common.offlineentitlements;

import com.bumptech.glide.load.data.Bwyd.SbbqvQlxi;
import com.revenuecat.purchases.CustomerInfo;
import com.revenuecat.purchases.LogHandler;
import com.revenuecat.purchases.LogLevel;
import com.revenuecat.purchases.PurchasesError;
import com.revenuecat.purchases.PurchasesErrorCode;
import com.revenuecat.purchases.Store;
import com.revenuecat.purchases.common.AppConfig;
import com.revenuecat.purchases.common.Backend;
import com.revenuecat.purchases.common.Config;
import com.revenuecat.purchases.common.LogWrapperKt;
import com.revenuecat.purchases.common.caching.DeviceCache;
import com.revenuecat.purchases.common.diagnostics.DiagnosticsTracker;
import com.revenuecat.purchases.strings.OfflineEntitlementsStrings;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
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
/* JADX INFO: loaded from: classes5.dex */
@Metadata
public final class OfflineEntitlementsManager {
    private CustomerInfo _offlineCustomerInfo;
    private final AppConfig appConfig;
    private final Backend backend;
    private final DeviceCache deviceCache;
    private final DiagnosticsTracker diagnosticsTracker;
    private final OfflineCustomerInfoCalculator offlineCustomerInfoCalculator;
    private final Map<String, List<Pair<Function1<CustomerInfo, Unit>, Function1<PurchasesError, Unit>>>> offlineCustomerInfoCallbackCache;

    public OfflineEntitlementsManager(Backend backend, OfflineCustomerInfoCalculator offlineCustomerInfoCalculator, DeviceCache deviceCache, AppConfig appConfig, DiagnosticsTracker diagnosticsTracker) {
        Intrinsics.checkNotNullParameter(backend, "backend");
        Intrinsics.checkNotNullParameter(offlineCustomerInfoCalculator, "offlineCustomerInfoCalculator");
        Intrinsics.checkNotNullParameter(deviceCache, "deviceCache");
        Intrinsics.checkNotNullParameter(appConfig, "appConfig");
        this.backend = backend;
        this.offlineCustomerInfoCalculator = offlineCustomerInfoCalculator;
        this.deviceCache = deviceCache;
        this.appConfig = appConfig;
        this.diagnosticsTracker = diagnosticsTracker;
        this.offlineCustomerInfoCallbackCache = new LinkedHashMap();
    }

    private final boolean isOfflineEntitlementsEnabled() {
        return this.appConfig.getFinishTransactions() && this.appConfig.getEnableOfflineEntitlements() && !this.appConfig.getCustomEntitlementComputation() && this.appConfig.getStore() != Store.TEST_STORE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void updateProductEntitlementMappingCacheIfStale$default(OfflineEntitlementsManager offlineEntitlementsManager, Function1 function1, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            function1 = null;
        }
        offlineEntitlementsManager.updateProductEntitlementMappingCacheIfStale(function1);
    }

    public final void calculateAndCacheOfflineCustomerInfo(final String appUserId, Function1<? super CustomerInfo, Unit> onSuccess, Function1<? super PurchasesError, Unit> onError) {
        Intrinsics.checkNotNullParameter(appUserId, "appUserId");
        Intrinsics.checkNotNullParameter(onSuccess, "onSuccess");
        Intrinsics.checkNotNullParameter(onError, "onError");
        if (!this.appConfig.getEnableOfflineEntitlements()) {
            onError.invoke(new PurchasesError(PurchasesErrorCode.UnsupportedError, OfflineEntitlementsStrings.OFFLINE_ENTITLEMENTS_NOT_ENABLED));
            return;
        }
        synchronized (this) {
            try {
                boolean zContainsKey = this.offlineCustomerInfoCallbackCache.containsKey(appUserId);
                List<Pair<Function1<CustomerInfo, Unit>, Function1<PurchasesError, Unit>>> listEmptyList = this.offlineCustomerInfoCallbackCache.get(appUserId);
                if (listEmptyList == null) {
                    listEmptyList = CollectionsKt.emptyList();
                }
                this.offlineCustomerInfoCallbackCache.put(appUserId, CollectionsKt.plus((Collection) listEmptyList, (Iterable) CollectionsKt.listOf(TuplesKt.a(onSuccess, onError))));
                if (!zContainsKey) {
                    Unit unit = Unit.f139807a;
                    this.offlineCustomerInfoCalculator.computeOfflineCustomerInfo(appUserId, new Function1<CustomerInfo, Unit>() { // from class: com.revenuecat.purchases.common.offlineentitlements.OfflineEntitlementsManager.calculateAndCacheOfflineCustomerInfo.2
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                            invoke((CustomerInfo) obj);
                            return Unit.f139807a;
                        }

                        public final void invoke(CustomerInfo customerInfo) {
                            Intrinsics.checkNotNullParameter(customerInfo, "customerInfo");
                            OfflineEntitlementsManager offlineEntitlementsManager = OfflineEntitlementsManager.this;
                            String str = appUserId;
                            synchronized (offlineEntitlementsManager) {
                                try {
                                    LogLevel logLevel = LogLevel.WARN;
                                    LogHandler currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                                        currentLogHandler.w("[Purchases] - " + logLevel.name(), OfflineEntitlementsStrings.USING_OFFLINE_ENTITLEMENTS_CUSTOMER_INFO);
                                    }
                                    DiagnosticsTracker diagnosticsTracker = offlineEntitlementsManager.diagnosticsTracker;
                                    if (diagnosticsTracker != null) {
                                        diagnosticsTracker.trackEnteredOfflineEntitlementsMode();
                                    }
                                    offlineEntitlementsManager._offlineCustomerInfo = customerInfo;
                                    String cachedAppUserID$purchases_defaultsBc8Release = offlineEntitlementsManager.deviceCache.getCachedAppUserID$purchases_defaultsBc8Release();
                                    if (cachedAppUserID$purchases_defaultsBc8Release != null) {
                                        offlineEntitlementsManager.deviceCache.clearCustomerInfoCache$purchases_defaultsBc8Release(cachedAppUserID$purchases_defaultsBc8Release);
                                    }
                                    List list = (List) offlineEntitlementsManager.offlineCustomerInfoCallbackCache.remove(str);
                                    if (list != null) {
                                        Iterator it = list.iterator();
                                        while (it.hasNext()) {
                                            ((Function1) ((Pair) it.next()).a()).invoke(customerInfo);
                                        }
                                    }
                                    Unit unit2 = Unit.f139807a;
                                } catch (Throwable th) {
                                    throw th;
                                }
                            }
                        }
                    }, new Function1<PurchasesError, Unit>() { // from class: com.revenuecat.purchases.common.offlineentitlements.OfflineEntitlementsManager.calculateAndCacheOfflineCustomerInfo.3
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                            OfflineEntitlementsManager offlineEntitlementsManager = OfflineEntitlementsManager.this;
                            String str = appUserId;
                            synchronized (offlineEntitlementsManager) {
                                try {
                                    List list = (List) offlineEntitlementsManager.offlineCustomerInfoCallbackCache.remove(str);
                                    if (list != null) {
                                        Iterator it2 = list.iterator();
                                        while (it2.hasNext()) {
                                            ((Function1) ((Pair) it2.next()).b()).invoke(it);
                                        }
                                    }
                                    Unit unit2 = Unit.f139807a;
                                } catch (Throwable th) {
                                    throw th;
                                }
                            }
                        }
                    });
                    return;
                }
                LogLevel logLevel = LogLevel.DEBUG;
                LogHandler currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                    String str = "[Purchases] - " + logLevel.name();
                    String str2 = String.format(OfflineEntitlementsStrings.ALREADY_CALCULATING_OFFLINE_CUSTOMER_INFO, Arrays.copyOf(new Object[]{appUserId}, 1));
                    Intrinsics.checkNotNullExpressionValue(str2, "format(...)");
                    currentLogHandler.d(str, str2);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final CustomerInfo getOfflineCustomerInfo() {
        return this._offlineCustomerInfo;
    }

    public final synchronized void resetOfflineCustomerInfoCache() {
        try {
            if (this._offlineCustomerInfo != null) {
                LogLevel logLevel = LogLevel.DEBUG;
                LogHandler currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                    currentLogHandler.d("[Purchases] - " + logLevel.name(), OfflineEntitlementsStrings.RESETTING_OFFLINE_CUSTOMER_INFO_CACHE);
                }
                this._offlineCustomerInfo = null;
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public final boolean shouldCalculateOfflineCustomerInfoInGetCustomerInfoRequest(boolean z2, String appUserId) {
        Intrinsics.checkNotNullParameter(appUserId, "appUserId");
        return z2 && isOfflineEntitlementsEnabled() && this.deviceCache.getCachedCustomerInfo$purchases_defaultsBc8Release(appUserId) == null;
    }

    public final boolean shouldCalculateOfflineCustomerInfoInPostReceipt(boolean z2) {
        return z2 && isOfflineEntitlementsEnabled();
    }

    public final void updateProductEntitlementMappingCacheIfStale(final Function1<? super PurchasesError, Unit> function1) {
        if (!isOfflineEntitlementsEnabled() || !this.deviceCache.isProductEntitlementMappingCacheStale$purchases_defaultsBc8Release()) {
            if (function1 != null) {
                function1.invoke(null);
                return;
            }
            return;
        }
        LogLevel logLevel = LogLevel.DEBUG;
        LogHandler currentLogHandler = LogWrapperKt.getCurrentLogHandler();
        if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
            currentLogHandler.d("[Purchases] - " + logLevel.name(), OfflineEntitlementsStrings.UPDATING_PRODUCT_ENTITLEMENT_MAPPING);
        }
        this.backend.getProductEntitlementMapping(new Function1<ProductEntitlementMapping, Unit>() { // from class: com.revenuecat.purchases.common.offlineentitlements.OfflineEntitlementsManager.updateProductEntitlementMappingCacheIfStale.2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((ProductEntitlementMapping) obj);
                return Unit.f139807a;
            }

            public final void invoke(ProductEntitlementMapping productEntitlementMapping) {
                Intrinsics.checkNotNullParameter(productEntitlementMapping, "productEntitlementMapping");
                OfflineEntitlementsManager.this.deviceCache.cacheProductEntitlementMapping$purchases_defaultsBc8Release(productEntitlementMapping);
                LogLevel logLevel2 = LogLevel.DEBUG;
                LogHandler currentLogHandler2 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel2) <= 0) {
                    currentLogHandler2.d("[Purchases] - " + logLevel2.name(), OfflineEntitlementsStrings.SUCCESSFULLY_UPDATED_PRODUCT_ENTITLEMENTS);
                }
                Function1<PurchasesError, Unit> function12 = function1;
                if (function12 != null) {
                    function12.invoke(null);
                }
            }
        }, new Function1<PurchasesError, Unit>() { // from class: com.revenuecat.purchases.common.offlineentitlements.OfflineEntitlementsManager.updateProductEntitlementMappingCacheIfStale.3
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

            public final void invoke(PurchasesError e3) {
                Intrinsics.checkNotNullParameter(e3, "e");
                LogHandler currentLogHandler2 = LogWrapperKt.getCurrentLogHandler();
                String str = String.format(OfflineEntitlementsStrings.ERROR_UPDATING_PRODUCT_ENTITLEMENTS, Arrays.copyOf(new Object[]{e3}, 1));
                Intrinsics.checkNotNullExpressionValue(str, SbbqvQlxi.fTfX);
                currentLogHandler2.e("[Purchases] - ERROR", str, null);
                Function1<PurchasesError, Unit> function12 = function1;
                if (function12 != null) {
                    function12.invoke(e3);
                }
            }
        });
    }
}
