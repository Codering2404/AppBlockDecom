package com.revenuecat.purchases;

import coil.target.Yb.oUcQRqOVfOC;
import com.revenuecat.purchases.common.AppConfig;
import com.revenuecat.purchases.common.Backend;
import com.revenuecat.purchases.common.BillingAbstract;
import com.revenuecat.purchases.common.LogUtilsKt;
import com.revenuecat.purchases.common.PostReceiptErrorHandlingBehavior;
import com.revenuecat.purchases.common.ReceiptInfo;
import com.revenuecat.purchases.common.caching.DeviceCache;
import com.revenuecat.purchases.common.caching.LocalTransactionMetadata;
import com.revenuecat.purchases.common.caching.LocalTransactionMetadataStore;
import com.revenuecat.purchases.common.networking.PostReceiptResponse;
import com.revenuecat.purchases.common.offlineentitlements.OfflineEntitlementsManager;
import com.revenuecat.purchases.models.PurchaseState;
import com.revenuecat.purchases.models.StoreProduct;
import com.revenuecat.purchases.models.StoreTransaction;
import com.revenuecat.purchases.models.SubscriptionOption;
import com.revenuecat.purchases.paywalls.PaywallPresentedCache;
import com.revenuecat.purchases.paywalls.events.PaywallEvent;
import com.revenuecat.purchases.paywalls.events.PaywallPostReceiptData;
import com.revenuecat.purchases.subscriberattributes.BackendHelpersKt;
import com.revenuecat.purchases.subscriberattributes.SubscriberAttribute;
import com.revenuecat.purchases.subscriberattributes.SubscriberAttributesManager;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.revenuecat.purchases.utils.Result;
import com.sun.jna.Function;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentLinkedQueue;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
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
public final class PostReceiptHelper {
    private final AppConfig appConfig;
    private final Backend backend;
    private final BillingAbstract billing;
    private final CustomerInfoUpdateHandler customerInfoUpdateHandler;
    private final DeviceCache deviceCache;
    private final LocalTransactionMetadataStore localTransactionMetadataStore;
    private final OfflineEntitlementsManager offlineEntitlementsManager;
    private final PaywallPresentedCache paywallPresentedCache;
    private final SubscriberAttributesManager subscriberAttributesManager;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    private static final class CachedDataToPost {
        private final boolean didCacheData;
        private final LocalTransactionMetadata localTransactionMetadata;
        private final PaywallEvent paywallEvent;

        public CachedDataToPost(LocalTransactionMetadata localTransactionMetadata, PaywallEvent paywallEvent, boolean z2) {
            this.localTransactionMetadata = localTransactionMetadata;
            this.paywallEvent = paywallEvent;
            this.didCacheData = z2;
        }

        public static /* synthetic */ CachedDataToPost copy$default(CachedDataToPost cachedDataToPost, LocalTransactionMetadata localTransactionMetadata, PaywallEvent paywallEvent, boolean z2, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                localTransactionMetadata = cachedDataToPost.localTransactionMetadata;
            }
            if ((i3 & 2) != 0) {
                paywallEvent = cachedDataToPost.paywallEvent;
            }
            if ((i3 & 4) != 0) {
                z2 = cachedDataToPost.didCacheData;
            }
            return cachedDataToPost.copy(localTransactionMetadata, paywallEvent, z2);
        }

        public final LocalTransactionMetadata component1() {
            return this.localTransactionMetadata;
        }

        public final PaywallEvent component2() {
            return this.paywallEvent;
        }

        public final boolean component3() {
            return this.didCacheData;
        }

        public final CachedDataToPost copy(LocalTransactionMetadata localTransactionMetadata, PaywallEvent paywallEvent, boolean z2) {
            return new CachedDataToPost(localTransactionMetadata, paywallEvent, z2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof CachedDataToPost)) {
                return false;
            }
            CachedDataToPost cachedDataToPost = (CachedDataToPost) obj;
            return Intrinsics.areEqual(this.localTransactionMetadata, cachedDataToPost.localTransactionMetadata) && Intrinsics.areEqual(this.paywallEvent, cachedDataToPost.paywallEvent) && this.didCacheData == cachedDataToPost.didCacheData;
        }

        public final boolean getDidCacheData() {
            return this.didCacheData;
        }

        public final LocalTransactionMetadata getLocalTransactionMetadata() {
            return this.localTransactionMetadata;
        }

        public final PaywallEvent getPaywallEvent() {
            return this.paywallEvent;
        }

        public int hashCode() {
            LocalTransactionMetadata localTransactionMetadata = this.localTransactionMetadata;
            int iHashCode = (localTransactionMetadata == null ? 0 : localTransactionMetadata.hashCode()) * 31;
            PaywallEvent paywallEvent = this.paywallEvent;
            return ((iHashCode + (paywallEvent != null ? paywallEvent.hashCode() : 0)) * 31) + Boolean.hashCode(this.didCacheData);
        }

        public String toString() {
            return "CachedDataToPost(localTransactionMetadata=" + this.localTransactionMetadata + ", paywallEvent=" + this.paywallEvent + ", didCacheData=" + this.didCacheData + ')';
        }
    }

    public PostReceiptHelper(AppConfig appConfig, Backend backend, BillingAbstract billing, CustomerInfoUpdateHandler customerInfoUpdateHandler, DeviceCache deviceCache, SubscriberAttributesManager subscriberAttributesManager, OfflineEntitlementsManager offlineEntitlementsManager, PaywallPresentedCache paywallPresentedCache, LocalTransactionMetadataStore localTransactionMetadataStore) {
        Intrinsics.checkNotNullParameter(appConfig, "appConfig");
        Intrinsics.checkNotNullParameter(backend, "backend");
        Intrinsics.checkNotNullParameter(billing, "billing");
        Intrinsics.checkNotNullParameter(customerInfoUpdateHandler, "customerInfoUpdateHandler");
        Intrinsics.checkNotNullParameter(deviceCache, "deviceCache");
        Intrinsics.checkNotNullParameter(subscriberAttributesManager, "subscriberAttributesManager");
        Intrinsics.checkNotNullParameter(offlineEntitlementsManager, "offlineEntitlementsManager");
        Intrinsics.checkNotNullParameter(paywallPresentedCache, "paywallPresentedCache");
        Intrinsics.checkNotNullParameter(localTransactionMetadataStore, "localTransactionMetadataStore");
        this.appConfig = appConfig;
        this.backend = backend;
        this.billing = billing;
        this.customerInfoUpdateHandler = customerInfoUpdateHandler;
        this.deviceCache = deviceCache;
        this.subscriberAttributesManager = subscriberAttributesManager;
        this.offlineEntitlementsManager = offlineEntitlementsManager;
        this.paywallPresentedCache = paywallPresentedCache;
        this.localTransactionMetadataStore = localTransactionMetadataStore;
    }

    private final void calculateOfflineCustomerInfo(String str, final Function1<? super CustomerInfo, Unit> function1, final Function1<? super PurchasesError, Unit> function12) {
        this.offlineEntitlementsManager.calculateAndCacheOfflineCustomerInfo(str, new Function1<CustomerInfo, Unit>() { // from class: com.revenuecat.purchases.PostReceiptHelper.calculateOfflineCustomerInfo.1
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

            public final void invoke(CustomerInfo customerInfo) {
                Intrinsics.checkNotNullParameter(customerInfo, "customerInfo");
                PostReceiptHelper.this.customerInfoUpdateHandler.notifyListeners(customerInfo);
                function1.invoke(customerInfo);
            }
        }, new Function1<PurchasesError, Unit>() { // from class: com.revenuecat.purchases.PostReceiptHelper.calculateOfflineCustomerInfo.2
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
                function12.invoke(error);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void callTransactionMetadataCompletionFromResults(List<LocalTransactionMetadata> list, ConcurrentLinkedQueue<Result<CustomerInfo, PurchasesError>> concurrentLinkedQueue, Function1<? super PurchasesError, Unit> function1, Function1<? super CustomerInfo, Unit> function12) {
        if (list.size() == concurrentLinkedQueue.size()) {
            int i3 = 0;
            for (Object obj : concurrentLinkedQueue) {
                int i4 = i3 + 1;
                if (i3 < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                Result result = (Result) obj;
                if (result instanceof Result.Error) {
                    if (function1 != null) {
                        function1.invoke(((Result.Error) result).getValue());
                        return;
                    }
                    return;
                } else {
                    if (i3 == concurrentLinkedQueue.size() - 1 && function12 != null) {
                        Intrinsics.checkNotNull(result, "null cannot be cast to non-null type com.revenuecat.purchases.utils.Result.Success<com.revenuecat.purchases.CustomerInfo>");
                        function12.invoke(((Result.Success) result).getValue());
                    }
                    i3 = i4;
                }
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ void callTransactionMetadataCompletionFromResults$default(PostReceiptHelper postReceiptHelper, List list, ConcurrentLinkedQueue concurrentLinkedQueue, Function1 function1, Function1 function12, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            function1 = null;
        }
        if ((i3 & 8) != 0) {
            function12 = null;
        }
        postReceiptHelper.callTransactionMetadataCompletionFromResults(list, concurrentLinkedQueue, function1, function12);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean getFinishTransactions() {
        return this.appConfig.getFinishTransactions();
    }

    private final synchronized CachedDataToPost getOrPutDataToPost(LocalTransactionMetadataStore localTransactionMetadataStore, String str, ReceiptInfo receiptInfo, PostReceiptInitiationSource postReceiptInitiationSource) {
        LocalTransactionMetadata localTransactionMetadata;
        boolean z2;
        PaywallEvent andRemovePurchaseInitiatedEventIfNeeded;
        PaywallEvent.Data data;
        try {
            localTransactionMetadata = localTransactionMetadataStore.getLocalTransactionMetadata(str);
            z2 = localTransactionMetadata == null && postReceiptInitiationSource == PostReceiptInitiationSource.PURCHASE;
            andRemovePurchaseInitiatedEventIfNeeded = localTransactionMetadata == null ? this.paywallPresentedCache.getAndRemovePurchaseInitiatedEventIfNeeded(receiptInfo.getProductIDs(), receiptInfo.getPurchaseTime()) : null;
            if (z2) {
                PresentedOfferingContext presentedOfferingContext = (andRemovePurchaseInitiatedEventIfNeeded == null || (data = andRemovePurchaseInitiatedEventIfNeeded.getData()) == null) ? null : data.getPresentedOfferingContext();
                localTransactionMetadataStore.cacheLocalTransactionMetadata(str, new LocalTransactionMetadata(str, (receiptInfo.getPresentedOfferingContext() != null || presentedOfferingContext == null) ? receiptInfo : ReceiptInfo.copy$default(receiptInfo, null, null, presentedOfferingContext, null, null, null, null, null, null, null, false, null, null, 8187, null), andRemovePurchaseInitiatedEventIfNeeded != null ? andRemovePurchaseInitiatedEventIfNeeded.toPaywallPostReceiptData$purchases_defaultsBc8Release() : null, getPurchasesAreCompletedBy()));
            }
        } catch (Throwable th) {
            throw th;
        }
        return new CachedDataToPost(localTransactionMetadata, andRemovePurchaseInitiatedEventIfNeeded, z2);
    }

    private final PurchasesAreCompletedBy getPurchasesAreCompletedBy() {
        return this.appConfig.getPurchasesAreCompletedBy();
    }

    private final void performPostReceipt(final String str, final String str2, final boolean z2, final ReceiptInfo receiptInfo, final PostReceiptInitiationSource postReceiptInitiationSource, final PaywallPostReceiptData paywallPostReceiptData, final PurchasesAreCompletedBy purchasesAreCompletedBy, final boolean z3, final Function1<? super PostReceiptResponse, Unit> function1, final Function3<? super PurchasesError, ? super PostReceiptErrorHandlingBehavior, ? super JSONObject, Unit> function3) {
        this.subscriberAttributesManager.getUnsyncedSubscriberAttributes(str, new Function1<Map<String, ? extends SubscriberAttribute>, Unit>() { // from class: com.revenuecat.purchases.PostReceiptHelper.performPostReceipt.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Map<String, SubscriberAttribute>) obj);
                return Unit.f139807a;
            }

            public final void invoke(final Map<String, SubscriberAttribute> unsyncedSubscriberAttributesByKey) {
                Intrinsics.checkNotNullParameter(unsyncedSubscriberAttributesByKey, "unsyncedSubscriberAttributesByKey");
                Backend backend = PostReceiptHelper.this.backend;
                String str3 = str2;
                String str4 = str;
                boolean z4 = z2;
                boolean finishTransactions = PostReceiptHelper.this.getFinishTransactions();
                Map<String, Map<String, Object>> backendMap = BackendHelpersKt.toBackendMap(unsyncedSubscriberAttributesByKey);
                ReceiptInfo receiptInfo2 = receiptInfo;
                PostReceiptInitiationSource postReceiptInitiationSource2 = postReceiptInitiationSource;
                PaywallPostReceiptData paywallPostReceiptData2 = paywallPostReceiptData;
                PurchasesAreCompletedBy purchasesAreCompletedBy2 = purchasesAreCompletedBy;
                final boolean z5 = z3;
                final PostReceiptHelper postReceiptHelper = PostReceiptHelper.this;
                final String str5 = str2;
                final String str6 = str;
                final Function1<PostReceiptResponse, Unit> function12 = function1;
                Function1<PostReceiptResponse, Unit> function13 = new Function1<PostReceiptResponse, Unit>() { // from class: com.revenuecat.purchases.PostReceiptHelper.performPostReceipt.1.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        invoke((PostReceiptResponse) obj);
                        return Unit.f139807a;
                    }

                    public final void invoke(PostReceiptResponse postReceiptResponse) {
                        Intrinsics.checkNotNullParameter(postReceiptResponse, "postReceiptResponse");
                        if (z5) {
                            postReceiptHelper.localTransactionMetadataStore.clearLocalTransactionMetadata(SetsKt.setOf(str5));
                        }
                        postReceiptHelper.offlineEntitlementsManager.resetOfflineCustomerInfoCache();
                        postReceiptHelper.subscriberAttributesManager.markAsSynced(str6, unsyncedSubscriberAttributesByKey, BackendHelpersKt.getAttributeErrors(postReceiptResponse.getBody()));
                        postReceiptHelper.customerInfoUpdateHandler.cacheAndNotifyListeners(postReceiptResponse.getCustomerInfo());
                        function12.invoke(postReceiptResponse);
                    }
                };
                final boolean z6 = z3;
                final PostReceiptHelper postReceiptHelper2 = PostReceiptHelper.this;
                final String str7 = str2;
                final String str8 = str;
                final Function3<PurchasesError, PostReceiptErrorHandlingBehavior, JSONObject, Unit> function32 = function3;
                backend.postReceiptData(str3, str4, z4, finishTransactions, backendMap, receiptInfo2, postReceiptInitiationSource2, paywallPostReceiptData2, purchasesAreCompletedBy2, function13, new Function3<PurchasesError, PostReceiptErrorHandlingBehavior, JSONObject, Unit>() { // from class: com.revenuecat.purchases.PostReceiptHelper.performPostReceipt.1.2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(3);
                    }

                    @Override // kotlin.jvm.functions.Function3
                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                        invoke((PurchasesError) obj, (PostReceiptErrorHandlingBehavior) obj2, (JSONObject) obj3);
                        return Unit.f139807a;
                    }

                    public final void invoke(PurchasesError error, PostReceiptErrorHandlingBehavior errorHandlingBehavior, JSONObject jSONObject) {
                        Intrinsics.checkNotNullParameter(error, "error");
                        Intrinsics.checkNotNullParameter(errorHandlingBehavior, "errorHandlingBehavior");
                        if (errorHandlingBehavior == PostReceiptErrorHandlingBehavior.SHOULD_BE_MARKED_SYNCED) {
                            if (z6) {
                                postReceiptHelper2.localTransactionMetadataStore.clearLocalTransactionMetadata(SetsKt.setOf(str7));
                            }
                            postReceiptHelper2.subscriberAttributesManager.markAsSynced(str8, unsyncedSubscriberAttributesByKey, BackendHelpersKt.getAttributeErrors(jSONObject));
                        }
                        function32.invoke(error, errorHandlingBehavior, jSONObject);
                    }
                });
            }
        });
    }

    private final void postReceiptAndSubscriberAttributes(String str, String str2, boolean z2, ReceiptInfo receiptInfo, PostReceiptInitiationSource postReceiptInitiationSource, PurchaseState purchaseState, Function1<? super PostReceiptResponse, Unit> function1, Function3<? super PurchasesError, ? super PostReceiptErrorHandlingBehavior, ? super JSONObject, Unit> function3) {
        PaywallPostReceiptData paywallPostReceiptData;
        ReceiptInfo receiptInfo2;
        PurchasesAreCompletedBy purchasesAreCompletedBy;
        CachedDataToPost orPutDataToPost = getOrPutDataToPost(this.localTransactionMetadataStore, str2, receiptInfo, postReceiptInitiationSource);
        LocalTransactionMetadata localTransactionMetadataComponent1 = orPutDataToPost.component1();
        PaywallEvent paywallEventComponent2 = orPutDataToPost.component2();
        boolean zComponent3 = orPutDataToPost.component3();
        if (localTransactionMetadataComponent1 != null && (paywallPostReceiptData$purchases_defaultsBc8Release = localTransactionMetadataComponent1.getPaywallPostReceiptData()) != null) {
            paywallPostReceiptData = paywallPostReceiptData$purchases_defaultsBc8Release;
        } else if (paywallEventComponent2 != null) {
            PaywallPostReceiptData paywallPostReceiptData$purchases_defaultsBc8Release = paywallEventComponent2.toPaywallPostReceiptData$purchases_defaultsBc8Release();
            paywallPostReceiptData = paywallPostReceiptData$purchases_defaultsBc8Release;
        } else {
            paywallPostReceiptData = null;
        }
        if (localTransactionMetadataComponent1 == null || (receiptInfo2 = localTransactionMetadataComponent1.getReceiptInfo()) == null) {
            receiptInfo2 = receiptInfo;
        }
        if (localTransactionMetadataComponent1 == null || (purchasesAreCompletedBy = localTransactionMetadataComponent1.getPurchasesAreCompletedBy()) == null) {
            purchasesAreCompletedBy = getPurchasesAreCompletedBy();
        }
        if (purchaseState != PurchaseState.PENDING) {
            performPostReceipt(str, str2, z2, receiptInfo2, postReceiptInitiationSource, paywallPostReceiptData, purchasesAreCompletedBy, localTransactionMetadataComponent1 != null || zComponent3, function1, function3);
            return;
        }
        PurchasesError purchasesError = new PurchasesError(PurchasesErrorCode.PaymentPendingError, null, 2, null);
        LogUtilsKt.errorLog(purchasesError);
        function3.invoke(purchasesError, PostReceiptErrorHandlingBehavior.SHOULD_NOT_CONSUME, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void postTransactionAndConsumeIfNeeded$default(PostReceiptHelper postReceiptHelper, StoreTransaction storeTransaction, StoreProduct storeProduct, Map map, boolean z2, String str, PostReceiptInitiationSource postReceiptInitiationSource, boolean z3, Function2 function2, Function2 function22, int i3, Object obj) {
        Function2 function23;
        PostReceiptHelper postReceiptHelper2;
        StoreTransaction storeTransaction2;
        StoreProduct storeProduct2;
        Map map2;
        boolean z4;
        String str2;
        PostReceiptInitiationSource postReceiptInitiationSource2;
        boolean z5 = (i3 & 64) != 0 ? false : z3;
        Function2 function24 = (i3 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0 ? null : function2;
        if ((i3 & Function.MAX_NARGS) != 0) {
            function23 = null;
            storeTransaction2 = storeTransaction;
            storeProduct2 = storeProduct;
            map2 = map;
            z4 = z2;
            str2 = str;
            postReceiptInitiationSource2 = postReceiptInitiationSource;
            postReceiptHelper2 = postReceiptHelper;
        } else {
            function23 = function22;
            postReceiptHelper2 = postReceiptHelper;
            storeTransaction2 = storeTransaction;
            storeProduct2 = storeProduct;
            map2 = map;
            z4 = z2;
            str2 = str;
            postReceiptInitiationSource2 = postReceiptInitiationSource;
        }
        postReceiptHelper2.postTransactionAndConsumeIfNeeded(storeTransaction2, storeProduct2, map2, z4, str2, postReceiptInitiationSource2, z5, function24, function23);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void useOfflineEntitlementsCustomerInfoIfNeeded(PostReceiptErrorHandlingBehavior postReceiptErrorHandlingBehavior, String str, Function1<? super CustomerInfo, Unit> function1, final Function0<Unit> function0) {
        if (this.offlineEntitlementsManager.shouldCalculateOfflineCustomerInfoInPostReceipt(postReceiptErrorHandlingBehavior == PostReceiptErrorHandlingBehavior.SHOULD_USE_OFFLINE_ENTITLEMENTS_AND_NOT_CONSUME)) {
            calculateOfflineCustomerInfo(str, function1, new Function1<PurchasesError, Unit>() { // from class: com.revenuecat.purchases.PostReceiptHelper.useOfflineEntitlementsCustomerInfoIfNeeded.1
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
                    function0.invoke();
                }
            });
        } else {
            function0.invoke();
        }
    }

    public final void postRemainingCachedTransactionMetadata(String str, boolean z2, Set<String> pendingTransactionsTokens, Function0<Unit> onNoTransactionsToSync, final Function1<? super PurchasesError, Unit> function1, final Function1<? super CustomerInfo, Unit> function12) {
        String appUserID = str;
        Intrinsics.checkNotNullParameter(appUserID, "appUserID");
        Intrinsics.checkNotNullParameter(pendingTransactionsTokens, "pendingTransactionsTokens");
        Intrinsics.checkNotNullParameter(onNoTransactionsToSync, "onNoTransactionsToSync");
        final Function1<? super PurchasesError, Unit> onError = function1;
        Intrinsics.checkNotNullParameter(onError, "onError");
        final Function1<? super CustomerInfo, Unit> onSuccess = function12;
        Intrinsics.checkNotNullParameter(onSuccess, "onSuccess");
        final ConcurrentLinkedQueue concurrentLinkedQueue = new ConcurrentLinkedQueue();
        final PostReceiptHelper postReceiptHelper = this;
        List<LocalTransactionMetadata> allLocalTransactionMetadata = postReceiptHelper.localTransactionMetadataStore.getAllLocalTransactionMetadata();
        final ArrayList arrayList = new ArrayList();
        for (Object obj : allLocalTransactionMetadata) {
            if (!pendingTransactionsTokens.contains(((LocalTransactionMetadata) obj).getToken())) {
                arrayList.add(obj);
            }
        }
        if (arrayList.isEmpty()) {
            onNoTransactionsToSync.invoke();
            return;
        }
        int size = arrayList.size();
        int i3 = 0;
        while (i3 < size) {
            Object obj2 = arrayList.get(i3);
            i3++;
            LocalTransactionMetadata localTransactionMetadata = (LocalTransactionMetadata) obj2;
            performPostReceipt(appUserID, localTransactionMetadata.getToken(), z2, localTransactionMetadata.getReceiptInfo(), PostReceiptInitiationSource.UNSYNCED_ACTIVE_PURCHASES, localTransactionMetadata.getPaywallPostReceiptData(), localTransactionMetadata.getPurchasesAreCompletedBy(), true, new Function1<PostReceiptResponse, Unit>() { // from class: com.revenuecat.purchases.PostReceiptHelper$postRemainingCachedTransactionMetadata$1$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Object invoke(Object obj3) {
                    invoke((PostReceiptResponse) obj3);
                    return Unit.f139807a;
                }

                public final void invoke(PostReceiptResponse it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    concurrentLinkedQueue.add(new Result.Success(it.getCustomerInfo()));
                    postReceiptHelper.callTransactionMetadataCompletionFromResults(arrayList, concurrentLinkedQueue, onError, onSuccess);
                }
            }, new Function3<PurchasesError, PostReceiptErrorHandlingBehavior, JSONObject, Unit>() { // from class: com.revenuecat.purchases.PostReceiptHelper$postRemainingCachedTransactionMetadata$1$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(3);
                }

                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Object invoke(Object obj3, Object obj4, Object obj5) {
                    invoke((PurchasesError) obj3, (PostReceiptErrorHandlingBehavior) obj4, (JSONObject) obj5);
                    return Unit.f139807a;
                }

                public final void invoke(PurchasesError backendError, PostReceiptErrorHandlingBehavior postReceiptErrorHandlingBehavior, JSONObject jSONObject) {
                    Intrinsics.checkNotNullParameter(backendError, "backendError");
                    Intrinsics.checkNotNullParameter(postReceiptErrorHandlingBehavior, "<anonymous parameter 1>");
                    concurrentLinkedQueue.add(new Result.Error(backendError));
                    this.callTransactionMetadataCompletionFromResults(arrayList, concurrentLinkedQueue, function1, function12);
                }
            });
            postReceiptHelper = this;
            appUserID = str;
            onError = function1;
            onSuccess = function12;
            concurrentLinkedQueue = concurrentLinkedQueue;
            arrayList = arrayList;
        }
    }

    public final void postTransactionAndConsumeIfNeeded(final StoreTransaction purchase, StoreProduct storeProduct, Map<String, ? extends SubscriptionOption> map, boolean z2, final String appUserID, final PostReceiptInitiationSource initiationSource, boolean z3, final Function2<? super StoreTransaction, ? super CustomerInfo, Unit> function2, final Function2<? super StoreTransaction, ? super PurchasesError, Unit> function22) {
        Intrinsics.checkNotNullParameter(purchase, "purchase");
        Intrinsics.checkNotNullParameter(appUserID, "appUserID");
        Intrinsics.checkNotNullParameter(initiationSource, "initiationSource");
        postReceiptAndSubscriberAttributes(appUserID, purchase.getPurchaseToken(), z2, ReceiptInfo.Companion.from(purchase, storeProduct, map, z3), initiationSource, purchase.getPurchaseState(), new Function1<PostReceiptResponse, Unit>() { // from class: com.revenuecat.purchases.PostReceiptHelper.postTransactionAndConsumeIfNeeded.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((PostReceiptResponse) obj);
                return Unit.f139807a;
            }

            /* JADX WARN: Removed duplicated region for block: B:17:0x005d  */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public final void invoke(com.revenuecat.purchases.common.networking.PostReceiptResponse r7) {
                /*
                    r6 = this;
                    java.lang.String r0 = "postReceiptResponse"
                    kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
                    java.util.Map r0 = r7.getProductInfoByProductId()
                    if (r0 == 0) goto L5d
                    com.revenuecat.purchases.models.StoreTransaction r1 = r2
                    java.util.LinkedHashMap r2 = new java.util.LinkedHashMap
                    r2.<init>()
                    java.util.Set r0 = r0.entrySet()
                    java.util.Iterator r0 = r0.iterator()
                L1a:
                    boolean r3 = r0.hasNext()
                    if (r3 == 0) goto L42
                    java.lang.Object r3 = r0.next()
                    java.util.Map$Entry r3 = (java.util.Map.Entry) r3
                    java.lang.Object r4 = r3.getKey()
                    java.lang.String r4 = (java.lang.String) r4
                    java.util.List r5 = r1.getProductIds()
                    boolean r4 = r5.contains(r4)
                    if (r4 == 0) goto L1a
                    java.lang.Object r4 = r3.getKey()
                    java.lang.Object r3 = r3.getValue()
                    r2.put(r4, r3)
                    goto L1a
                L42:
                    java.util.Collection r0 = r2.values()
                    if (r0 == 0) goto L5d
                    java.lang.Iterable r0 = (java.lang.Iterable) r0
                    java.lang.Object r0 = kotlin.collections.CollectionsKt.firstOrNull(r0)
                    com.revenuecat.purchases.common.networking.PostReceiptProductInfo r0 = (com.revenuecat.purchases.common.networking.PostReceiptProductInfo) r0
                    if (r0 == 0) goto L5d
                    java.lang.Boolean r0 = r0.getShouldConsume()
                    if (r0 == 0) goto L5d
                    boolean r0 = r0.booleanValue()
                    goto L5e
                L5d:
                    r0 = 0
                L5e:
                    com.revenuecat.purchases.PostReceiptHelper r1 = com.revenuecat.purchases.PostReceiptHelper.this
                    com.revenuecat.purchases.common.BillingAbstract r1 = com.revenuecat.purchases.PostReceiptHelper.access$getBilling$p(r1)
                    com.revenuecat.purchases.PostReceiptHelper r2 = com.revenuecat.purchases.PostReceiptHelper.this
                    boolean r2 = com.revenuecat.purchases.PostReceiptHelper.access$getFinishTransactions(r2)
                    com.revenuecat.purchases.models.StoreTransaction r3 = r2
                    com.revenuecat.purchases.PostReceiptInitiationSource r4 = r3
                    r1.consumeAndSave(r2, r3, r0, r4)
                    kotlin.jvm.functions.Function2<com.revenuecat.purchases.models.StoreTransaction, com.revenuecat.purchases.CustomerInfo, kotlin.Unit> r0 = r4
                    if (r0 == 0) goto L7e
                    com.revenuecat.purchases.models.StoreTransaction r1 = r2
                    com.revenuecat.purchases.CustomerInfo r7 = r7.getCustomerInfo()
                    r0.invoke(r1, r7)
                L7e:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.revenuecat.purchases.PostReceiptHelper.C22931.invoke(com.revenuecat.purchases.common.networking.PostReceiptResponse):void");
            }
        }, new Function3<PurchasesError, PostReceiptErrorHandlingBehavior, JSONObject, Unit>() { // from class: com.revenuecat.purchases.PostReceiptHelper.postTransactionAndConsumeIfNeeded.2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                invoke((PurchasesError) obj, (PostReceiptErrorHandlingBehavior) obj2, (JSONObject) obj3);
                return Unit.f139807a;
            }

            public final void invoke(final PurchasesError backendError, PostReceiptErrorHandlingBehavior errorHandlingBehavior, JSONObject jSONObject) {
                Intrinsics.checkNotNullParameter(backendError, "backendError");
                Intrinsics.checkNotNullParameter(errorHandlingBehavior, "errorHandlingBehavior");
                if (errorHandlingBehavior == PostReceiptErrorHandlingBehavior.SHOULD_BE_MARKED_SYNCED) {
                    PostReceiptHelper.this.billing.consumeAndSave(PostReceiptHelper.this.getFinishTransactions(), purchase, false, initiationSource);
                }
                PostReceiptHelper postReceiptHelper = PostReceiptHelper.this;
                String str = appUserID;
                final Function2<StoreTransaction, CustomerInfo, Unit> function23 = function2;
                final StoreTransaction storeTransaction = purchase;
                Function1<CustomerInfo, Unit> function1 = new Function1<CustomerInfo, Unit>() { // from class: com.revenuecat.purchases.PostReceiptHelper.postTransactionAndConsumeIfNeeded.2.1
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

                    public final void invoke(CustomerInfo customerInfo) {
                        Intrinsics.checkNotNullParameter(customerInfo, "customerInfo");
                        Function2<StoreTransaction, CustomerInfo, Unit> function24 = function23;
                        if (function24 != null) {
                            function24.invoke(storeTransaction, customerInfo);
                        }
                    }
                };
                final Function2<StoreTransaction, PurchasesError, Unit> function24 = function22;
                final StoreTransaction storeTransaction2 = purchase;
                postReceiptHelper.useOfflineEntitlementsCustomerInfoIfNeeded(errorHandlingBehavior, str, function1, new Function0<Unit>() { // from class: com.revenuecat.purchases.PostReceiptHelper.postTransactionAndConsumeIfNeeded.2.2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Object invoke() {
                        m447invoke();
                        return Unit.f139807a;
                    }

                    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
                    public final void m447invoke() {
                        Function2<StoreTransaction, PurchasesError, Unit> function25 = function24;
                        if (function25 != null) {
                            function25.invoke(storeTransaction2, backendError);
                        }
                    }
                });
            }
        });
    }

    public final void postTokenWithoutConsuming(final String str, ReceiptInfo receiptInfo, boolean z2, final String appUserID, PostReceiptInitiationSource initiationSource, final Function1<? super CustomerInfo, Unit> onSuccess, final Function1<? super PurchasesError, Unit> onError, final Boolean bool) {
        Intrinsics.checkNotNullParameter(str, oUcQRqOVfOC.TLQ);
        Intrinsics.checkNotNullParameter(receiptInfo, "receiptInfo");
        Intrinsics.checkNotNullParameter(appUserID, "appUserID");
        Intrinsics.checkNotNullParameter(initiationSource, "initiationSource");
        Intrinsics.checkNotNullParameter(onSuccess, "onSuccess");
        Intrinsics.checkNotNullParameter(onError, "onError");
        postReceiptAndSubscriberAttributes(appUserID, str, z2, receiptInfo, initiationSource, PurchaseState.UNSPECIFIED_STATE, new Function1<PostReceiptResponse, Unit>() { // from class: com.revenuecat.purchases.PostReceiptHelper.postTokenWithoutConsuming.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((PostReceiptResponse) obj);
                return Unit.f139807a;
            }

            public final void invoke(PostReceiptResponse postReceiptResponse) {
                Intrinsics.checkNotNullParameter(postReceiptResponse, "postReceiptResponse");
                PostReceiptHelper.this.deviceCache.addSuccessfullyPostedToken(str, bool);
                onSuccess.invoke(postReceiptResponse.getCustomerInfo());
            }
        }, new Function3<PurchasesError, PostReceiptErrorHandlingBehavior, JSONObject, Unit>() { // from class: com.revenuecat.purchases.PostReceiptHelper.postTokenWithoutConsuming.2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                invoke((PurchasesError) obj, (PostReceiptErrorHandlingBehavior) obj2, (JSONObject) obj3);
                return Unit.f139807a;
            }

            public final void invoke(final PurchasesError backendError, PostReceiptErrorHandlingBehavior errorHandlingBehavior, JSONObject jSONObject) {
                Intrinsics.checkNotNullParameter(backendError, "backendError");
                Intrinsics.checkNotNullParameter(errorHandlingBehavior, "errorHandlingBehavior");
                if (errorHandlingBehavior == PostReceiptErrorHandlingBehavior.SHOULD_BE_MARKED_SYNCED) {
                    PostReceiptHelper.this.deviceCache.addSuccessfullyPostedToken(str, bool);
                }
                PostReceiptHelper postReceiptHelper = PostReceiptHelper.this;
                String str2 = appUserID;
                final Function1<CustomerInfo, Unit> function1 = onSuccess;
                Function1<CustomerInfo, Unit> function12 = new Function1<CustomerInfo, Unit>() { // from class: com.revenuecat.purchases.PostReceiptHelper.postTokenWithoutConsuming.2.1
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

                    public final void invoke(CustomerInfo it) {
                        Intrinsics.checkNotNullParameter(it, "it");
                        function1.invoke(it);
                    }
                };
                final Function1<PurchasesError, Unit> function13 = onError;
                postReceiptHelper.useOfflineEntitlementsCustomerInfoIfNeeded(errorHandlingBehavior, str2, function12, new Function0<Unit>() { // from class: com.revenuecat.purchases.PostReceiptHelper.postTokenWithoutConsuming.2.2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Object invoke() {
                        m446invoke();
                        return Unit.f139807a;
                    }

                    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
                    public final void m446invoke() {
                        function13.invoke(backendError);
                    }
                });
            }
        });
    }
}
