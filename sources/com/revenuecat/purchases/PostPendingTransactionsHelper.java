package com.revenuecat.purchases;

import com.revenuecat.purchases.SyncPendingPurchaseResult;
import com.revenuecat.purchases.common.AppConfig;
import com.revenuecat.purchases.common.BillingAbstract;
import com.revenuecat.purchases.common.Config;
import com.revenuecat.purchases.common.Dispatcher;
import com.revenuecat.purchases.common.LogIntent;
import com.revenuecat.purchases.common.LogWrapperKt;
import com.revenuecat.purchases.common.UtilsKt;
import com.revenuecat.purchases.common.caching.DeviceCache;
import com.revenuecat.purchases.identity.IdentityManager;
import com.revenuecat.purchases.models.PurchaseState;
import com.revenuecat.purchases.models.StoreTransaction;
import com.revenuecat.purchases.strings.PurchaseStrings;
import com.revenuecat.purchases.strings.RestoreStrings;
import com.revenuecat.purchases.utils.Result;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
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
public final class PostPendingTransactionsHelper {
    private final AppConfig appConfig;
    private final BillingAbstract billing;
    private final DeviceCache deviceCache;
    private final Dispatcher dispatcher;
    private final IdentityManager identityManager;
    private final PostReceiptHelper postReceiptHelper;
    private final PostTransactionWithProductDetailsHelper postTransactionWithProductDetailsHelper;

    public PostPendingTransactionsHelper(AppConfig appConfig, DeviceCache deviceCache, BillingAbstract billing, Dispatcher dispatcher, IdentityManager identityManager, PostTransactionWithProductDetailsHelper postTransactionWithProductDetailsHelper, PostReceiptHelper postReceiptHelper) {
        Intrinsics.checkNotNullParameter(appConfig, "appConfig");
        Intrinsics.checkNotNullParameter(deviceCache, "deviceCache");
        Intrinsics.checkNotNullParameter(billing, "billing");
        Intrinsics.checkNotNullParameter(dispatcher, "dispatcher");
        Intrinsics.checkNotNullParameter(identityManager, "identityManager");
        Intrinsics.checkNotNullParameter(postTransactionWithProductDetailsHelper, "postTransactionWithProductDetailsHelper");
        Intrinsics.checkNotNullParameter(postReceiptHelper, "postReceiptHelper");
        this.appConfig = appConfig;
        this.deviceCache = deviceCache;
        this.billing = billing;
        this.dispatcher = dispatcher;
        this.identityManager = identityManager;
        this.postTransactionWithProductDetailsHelper = postTransactionWithProductDetailsHelper;
        this.postReceiptHelper = postReceiptHelper;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void callCompletionFromResults(List<StoreTransaction> list, List<? extends Result<CustomerInfo, PurchasesError>> list2, Function1<? super PurchasesError, Unit> function1, Function1<? super CustomerInfo, Unit> function12) {
        if (list.size() == list2.size()) {
            int i3 = 0;
            for (Object obj : list2) {
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
                    if (i3 == list2.size() - 1 && function12 != null) {
                        Intrinsics.checkNotNull(result, "null cannot be cast to non-null type com.revenuecat.purchases.utils.Result.Success<com.revenuecat.purchases.CustomerInfo>");
                        function12.invoke(((Result.Success) result).getValue());
                    }
                    i3 = i4;
                }
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ void callCompletionFromResults$default(PostPendingTransactionsHelper postPendingTransactionsHelper, List list, List list2, Function1 function1, Function1 function12, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            function1 = null;
        }
        if ((i3 & 8) != 0) {
            function12 = null;
        }
        postPendingTransactionsHelper.callCompletionFromResults(list, list2, function1, function12);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void postTransactionsWithCompletion(final List<StoreTransaction> list, boolean z2, String str, Function0<Unit> function0, final Function1<? super PurchasesError, Unit> function1, final Function1<? super CustomerInfo, Unit> function12) {
        LogHandler currentLogHandler;
        String str2;
        String str3;
        if (!list.isEmpty()) {
            final ArrayList arrayList = new ArrayList();
            this.postTransactionWithProductDetailsHelper.postTransactions(list, z2, str, PostReceiptInitiationSource.UNSYNCED_ACTIVE_PURCHASES, false, new Function2<StoreTransaction, CustomerInfo, Unit>() { // from class: com.revenuecat.purchases.PostPendingTransactionsHelper.postTransactionsWithCompletion.2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((StoreTransaction) obj, (CustomerInfo) obj2);
                    return Unit.f139807a;
                }

                public final void invoke(StoreTransaction storeTransaction, CustomerInfo customerInfo) {
                    Intrinsics.checkNotNullParameter(storeTransaction, "<anonymous parameter 0>");
                    Intrinsics.checkNotNullParameter(customerInfo, "customerInfo");
                    arrayList.add(new Result.Success(customerInfo));
                    this.callCompletionFromResults(list, arrayList, function1, function12);
                }
            }, new Function2<StoreTransaction, PurchasesError, Unit>() { // from class: com.revenuecat.purchases.PostPendingTransactionsHelper.postTransactionsWithCompletion.3
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((StoreTransaction) obj, (PurchasesError) obj2);
                    return Unit.f139807a;
                }

                public final void invoke(StoreTransaction storeTransaction, PurchasesError purchasesError) {
                    Intrinsics.checkNotNullParameter(storeTransaction, "<anonymous parameter 0>");
                    Intrinsics.checkNotNullParameter(purchasesError, "purchasesError");
                    arrayList.add(new Result.Error(purchasesError));
                    this.callCompletionFromResults(list, arrayList, function1, function12);
                }
            });
            return;
        }
        final LogIntent logIntent = LogIntent.DEBUG;
        Function0<String> function02 = new Function0<String>() { // from class: com.revenuecat.purchases.PostPendingTransactionsHelper$postTransactionsWithCompletion$$inlined$log$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                return CollectionsKt.joinToString$default(logIntent.getEmojiList(), "", null, null, 0, null, null, 62, null) + ' ' + PurchaseStrings.NO_PENDING_PURCHASES_TO_SYNC;
            }
        };
        switch (LogWrapperKt.WhenMappings.$EnumSwitchMapping$0[logIntent.ordinal()]) {
            case 1:
                LogLevel logLevel = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                    str2 = "[Purchases] - " + logLevel.name();
                    str3 = (String) function02.invoke();
                    currentLogHandler.d(str2, str3);
                }
                break;
            case 2:
                LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) function02.invoke(), null);
                break;
            case 3:
                LogLevel logLevel2 = LogLevel.WARN;
                LogHandler currentLogHandler2 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel2) <= 0) {
                    currentLogHandler2.w("[Purchases] - " + logLevel2.name(), (String) function02.invoke());
                }
                break;
            case 4:
                LogLevel logLevel3 = LogLevel.INFO;
                LogHandler currentLogHandler3 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel3) <= 0) {
                    currentLogHandler3.i("[Purchases] - " + logLevel3.name(), (String) function02.invoke());
                }
                break;
            case 5:
                LogLevel logLevel4 = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel4) <= 0) {
                    str2 = "[Purchases] - " + logLevel4.name();
                    str3 = (String) function02.invoke();
                    currentLogHandler.d(str2, str3);
                }
                break;
            case 6:
                LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) function02.invoke(), null);
                break;
            case 7:
                LogLevel logLevel5 = LogLevel.INFO;
                LogHandler currentLogHandler4 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel5) <= 0) {
                    currentLogHandler4.i("[Purchases] - " + logLevel5.name(), (String) function02.invoke());
                }
                break;
            case 8:
                LogLevel logLevel6 = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel6) <= 0) {
                    str2 = "[Purchases] - " + logLevel6.name();
                    str3 = (String) function02.invoke();
                    currentLogHandler.d(str2, str3);
                }
                break;
            case 9:
                LogLevel logLevel7 = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel7) <= 0) {
                    str2 = "[Purchases] - " + logLevel7.name();
                    str3 = (String) function02.invoke();
                    currentLogHandler.d(str2, str3);
                }
                break;
            case 10:
                LogLevel logLevel8 = LogLevel.WARN;
                LogHandler currentLogHandler5 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel8) <= 0) {
                    currentLogHandler5.w("[Purchases] - " + logLevel8.name(), (String) function02.invoke());
                }
                break;
            case 11:
                LogLevel logLevel9 = LogLevel.WARN;
                LogHandler currentLogHandler6 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel9) <= 0) {
                    currentLogHandler6.w("[Purchases] - " + logLevel9.name(), (String) function02.invoke());
                }
                break;
            case 12:
                LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) function02.invoke(), null);
                break;
            case 13:
                LogLevel logLevel10 = LogLevel.WARN;
                LogHandler currentLogHandler7 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel10) <= 0) {
                    currentLogHandler7.w("[Purchases] - " + logLevel10.name(), (String) function02.invoke());
                }
                break;
            case 14:
                LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) function02.invoke(), null);
                break;
        }
        function0.invoke();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void syncPendingPurchaseQueue$default(PostPendingTransactionsHelper postPendingTransactionsHelper, boolean z2, Function1 function1, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            function1 = null;
        }
        postPendingTransactionsHelper.syncPendingPurchaseQueue(z2, function1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void syncPendingPurchaseQueue$lambda$2(final PostPendingTransactionsHelper postPendingTransactionsHelper, final String str, final boolean z2, final Function1 function1) {
        postPendingTransactionsHelper.billing.queryPurchases(str, new Function1<Map<String, ? extends StoreTransaction>, Unit>() { // from class: com.revenuecat.purchases.PostPendingTransactionsHelper$syncPendingPurchaseQueue$3$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Map<String, StoreTransaction>) obj);
                return Unit.f139807a;
            }

            public final void invoke(Map<String, StoreTransaction> purchasesByHashedToken) {
                LogHandler currentLogHandler;
                String str2;
                Object objInvoke;
                Intrinsics.checkNotNullParameter(purchasesByHashedToken, "purchasesByHashedToken");
                for (Map.Entry<String, StoreTransaction> entry : purchasesByHashedToken.entrySet()) {
                    final String key = entry.getKey();
                    final StoreTransaction value = entry.getValue();
                    final LogIntent logIntent = LogIntent.DEBUG;
                    Function0<String> function0 = new Function0<String>() { // from class: com.revenuecat.purchases.PostPendingTransactionsHelper$syncPendingPurchaseQueue$3$1$invoke$lambda$1$$inlined$log$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public final String invoke() {
                            StringBuilder sb = new StringBuilder();
                            sb.append(CollectionsKt.joinToString$default(logIntent.getEmojiList(), "", null, null, 0, null, null, 62, null));
                            sb.append(' ');
                            String str3 = String.format(RestoreStrings.QUERYING_PURCHASE_WITH_HASH, Arrays.copyOf(new Object[]{value.getType(), key}, 2));
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
                                str2 = "[Purchases] - " + logLevel.name();
                                objInvoke = function0.invoke();
                            }
                            break;
                        case 2:
                            LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) function0.invoke(), null);
                            continue;
                        case 3:
                            LogLevel logLevel2 = LogLevel.WARN;
                            LogHandler currentLogHandler2 = LogWrapperKt.getCurrentLogHandler();
                            if (Config.INSTANCE.getLogLevel().compareTo(logLevel2) <= 0) {
                                currentLogHandler2.w("[Purchases] - " + logLevel2.name(), (String) function0.invoke());
                            } else {
                                continue;
                            }
                            break;
                        case 4:
                            LogLevel logLevel3 = LogLevel.INFO;
                            LogHandler currentLogHandler3 = LogWrapperKt.getCurrentLogHandler();
                            if (Config.INSTANCE.getLogLevel().compareTo(logLevel3) <= 0) {
                                currentLogHandler3.i("[Purchases] - " + logLevel3.name(), (String) function0.invoke());
                            } else {
                                continue;
                            }
                            break;
                        case 5:
                            LogLevel logLevel4 = LogLevel.DEBUG;
                            currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                            if (Config.INSTANCE.getLogLevel().compareTo(logLevel4) <= 0) {
                                str2 = "[Purchases] - " + logLevel4.name();
                                objInvoke = function0.invoke();
                            }
                            break;
                        case 6:
                            LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) function0.invoke(), null);
                            continue;
                        case 7:
                            LogLevel logLevel5 = LogLevel.INFO;
                            LogHandler currentLogHandler4 = LogWrapperKt.getCurrentLogHandler();
                            if (Config.INSTANCE.getLogLevel().compareTo(logLevel5) <= 0) {
                                currentLogHandler4.i("[Purchases] - " + logLevel5.name(), (String) function0.invoke());
                            } else {
                                continue;
                            }
                            break;
                        case 8:
                            LogLevel logLevel6 = LogLevel.DEBUG;
                            currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                            if (Config.INSTANCE.getLogLevel().compareTo(logLevel6) <= 0) {
                                str2 = "[Purchases] - " + logLevel6.name();
                                objInvoke = function0.invoke();
                            }
                            break;
                        case 9:
                            LogLevel logLevel7 = LogLevel.DEBUG;
                            currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                            if (Config.INSTANCE.getLogLevel().compareTo(logLevel7) <= 0) {
                                str2 = "[Purchases] - " + logLevel7.name();
                                objInvoke = function0.invoke();
                            }
                            break;
                        case 10:
                            LogLevel logLevel8 = LogLevel.WARN;
                            LogHandler currentLogHandler5 = LogWrapperKt.getCurrentLogHandler();
                            if (Config.INSTANCE.getLogLevel().compareTo(logLevel8) <= 0) {
                                currentLogHandler5.w("[Purchases] - " + logLevel8.name(), (String) function0.invoke());
                            } else {
                                continue;
                            }
                            break;
                        case 11:
                            LogLevel logLevel9 = LogLevel.WARN;
                            LogHandler currentLogHandler6 = LogWrapperKt.getCurrentLogHandler();
                            if (Config.INSTANCE.getLogLevel().compareTo(logLevel9) <= 0) {
                                currentLogHandler6.w("[Purchases] - " + logLevel9.name(), (String) function0.invoke());
                            } else {
                                continue;
                            }
                            break;
                        case 12:
                            LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) function0.invoke(), null);
                            continue;
                        case 13:
                            LogLevel logLevel10 = LogLevel.WARN;
                            LogHandler currentLogHandler7 = LogWrapperKt.getCurrentLogHandler();
                            if (Config.INSTANCE.getLogLevel().compareTo(logLevel10) <= 0) {
                                currentLogHandler7.w("[Purchases] - " + logLevel10.name(), (String) function0.invoke());
                            } else {
                                continue;
                            }
                            break;
                        case 14:
                            LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) function0.invoke(), null);
                            continue;
                    }
                    currentLogHandler.d(str2, (String) objInvoke);
                }
                this.this$0.deviceCache.cleanPreviouslySentTokens$purchases_defaultsBc8Release(purchasesByHashedToken.keySet());
                List<StoreTransaction> activePurchasesNotInCache$purchases_defaultsBc8Release = this.this$0.deviceCache.getActivePurchasesNotInCache$purchases_defaultsBc8Release(purchasesByHashedToken);
                List<StoreTransaction> purchasesWithAutoRenewingChange$purchases_defaultsBc8Release = this.this$0.deviceCache.getPurchasesWithAutoRenewingChange$purchases_defaultsBc8Release(purchasesByHashedToken);
                ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(purchasesWithAutoRenewingChange$purchases_defaultsBc8Release, 10));
                Iterator<T> it = purchasesWithAutoRenewingChange$purchases_defaultsBc8Release.iterator();
                while (it.hasNext()) {
                    arrayList.add(UtilsKt.sha1(((StoreTransaction) it.next()).getPurchaseToken()));
                }
                this.this$0.deviceCache.saveAutoRenewingStatus$purchases_defaultsBc8Release(MapsKt.minus((Map) purchasesByHashedToken, (Iterable) CollectionsKt.toSet(arrayList)));
                List listPlus = CollectionsKt.plus((Collection) activePurchasesNotInCache$purchases_defaultsBc8Release, (Iterable) purchasesWithAutoRenewingChange$purchases_defaultsBc8Release);
                HashSet hashSet = new HashSet();
                ArrayList arrayList2 = new ArrayList();
                for (Object obj : listPlus) {
                    if (hashSet.add(((StoreTransaction) obj).getPurchaseToken())) {
                        arrayList2.add(obj);
                    }
                }
                Collection<StoreTransaction> collectionValues = purchasesByHashedToken.values();
                ArrayList arrayList3 = new ArrayList();
                for (Object obj2 : collectionValues) {
                    if (((StoreTransaction) obj2).getPurchaseState() == PurchaseState.PENDING) {
                        arrayList3.add(obj2);
                    }
                }
                ArrayList arrayList4 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList3, 10));
                int size = arrayList3.size();
                int i3 = 0;
                while (i3 < size) {
                    Object obj3 = arrayList3.get(i3);
                    i3++;
                    arrayList4.add(((StoreTransaction) obj3).getPurchaseToken());
                }
                final Set set = CollectionsKt.toSet(arrayList4);
                final PostPendingTransactionsHelper postPendingTransactionsHelper2 = this.this$0;
                final boolean z3 = z2;
                final String str3 = str;
                final Function1<SyncPendingPurchaseResult, Unit> function12 = function1;
                Function0<Unit> function02 = new Function0<Unit>() { // from class: com.revenuecat.purchases.PostPendingTransactionsHelper$syncPendingPurchaseQueue$3$1.2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Object invoke() {
                        m442invoke();
                        return Unit.f139807a;
                    }

                    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
                    public final void m442invoke() {
                        PostReceiptHelper postReceiptHelper = postPendingTransactionsHelper2.postReceiptHelper;
                        String str4 = str3;
                        boolean z4 = z3;
                        Set<String> set2 = set;
                        final Function1<SyncPendingPurchaseResult, Unit> function13 = function12;
                        Function0<Unit> function03 = new Function0<Unit>() { // from class: com.revenuecat.purchases.PostPendingTransactionsHelper.syncPendingPurchaseQueue.3.1.2.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(0);
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public /* bridge */ /* synthetic */ Object invoke() {
                                m443invoke();
                                return Unit.f139807a;
                            }

                            /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
                            public final void m443invoke() {
                                Function1<SyncPendingPurchaseResult, Unit> function14 = function13;
                                if (function14 != null) {
                                    function14.invoke(SyncPendingPurchaseResult.NoPendingPurchasesToSync.INSTANCE);
                                }
                            }
                        };
                        final Function1<SyncPendingPurchaseResult, Unit> function14 = function12;
                        Function1<PurchasesError, Unit> function15 = new Function1<PurchasesError, Unit>() { // from class: com.revenuecat.purchases.PostPendingTransactionsHelper.syncPendingPurchaseQueue.3.1.2.2
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Object invoke(Object obj4) {
                                invoke((PurchasesError) obj4);
                                return Unit.f139807a;
                            }

                            public final void invoke(PurchasesError it2) {
                                Intrinsics.checkNotNullParameter(it2, "it");
                                Function1<SyncPendingPurchaseResult, Unit> function16 = function14;
                                if (function16 != null) {
                                    function16.invoke(new SyncPendingPurchaseResult.Error(it2));
                                }
                            }
                        };
                        final Function1<SyncPendingPurchaseResult, Unit> function16 = function12;
                        postReceiptHelper.postRemainingCachedTransactionMetadata(str4, z4, set2, function03, function15, new Function1<CustomerInfo, Unit>() { // from class: com.revenuecat.purchases.PostPendingTransactionsHelper.syncPendingPurchaseQueue.3.1.2.3
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Object invoke(Object obj4) {
                                invoke((CustomerInfo) obj4);
                                return Unit.f139807a;
                            }

                            public final void invoke(CustomerInfo it2) {
                                Intrinsics.checkNotNullParameter(it2, "it");
                                Function1<SyncPendingPurchaseResult, Unit> function17 = function16;
                                if (function17 != null) {
                                    function17.invoke(new SyncPendingPurchaseResult.Success(it2));
                                }
                            }
                        });
                    }
                };
                final PostPendingTransactionsHelper postPendingTransactionsHelper3 = this.this$0;
                final String str4 = str;
                final boolean z4 = z2;
                final Function1<SyncPendingPurchaseResult, Unit> function13 = function1;
                Function1<PurchasesError, Unit> function14 = new Function1<PurchasesError, Unit>() { // from class: com.revenuecat.purchases.PostPendingTransactionsHelper$syncPendingPurchaseQueue$3$1.3
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Object invoke(Object obj4) {
                        invoke((PurchasesError) obj4);
                        return Unit.f139807a;
                    }

                    public final void invoke(final PurchasesError error) {
                        Intrinsics.checkNotNullParameter(error, "error");
                        PostReceiptHelper postReceiptHelper = postPendingTransactionsHelper3.postReceiptHelper;
                        String str5 = str4;
                        boolean z5 = z4;
                        Set<String> set2 = set;
                        final Function1<SyncPendingPurchaseResult, Unit> function15 = function13;
                        Function0<Unit> function03 = new Function0<Unit>() { // from class: com.revenuecat.purchases.PostPendingTransactionsHelper.syncPendingPurchaseQueue.3.1.3.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(0);
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public /* bridge */ /* synthetic */ Object invoke() {
                                m444invoke();
                                return Unit.f139807a;
                            }

                            /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
                            public final void m444invoke() {
                                LogHandler currentLogHandler8;
                                String str6;
                                String str7;
                                final LogIntent logIntent2 = LogIntent.DEBUG;
                                Function0<String> function04 = new Function0<String>() { // from class: com.revenuecat.purchases.PostPendingTransactionsHelper$syncPendingPurchaseQueue$3$1$3$1$invoke$$inlined$log$1
                                    {
                                        super(0);
                                    }

                                    @Override // kotlin.jvm.functions.Function0
                                    public final String invoke() {
                                        return CollectionsKt.joinToString$default(logIntent2.getEmojiList(), "", null, null, 0, null, null, 62, null) + ' ' + PurchaseStrings.NO_PENDING_PURCHASES_TO_SYNC;
                                    }
                                };
                                switch (LogWrapperKt.WhenMappings.$EnumSwitchMapping$0[logIntent2.ordinal()]) {
                                    case 1:
                                        LogLevel logLevel11 = LogLevel.DEBUG;
                                        currentLogHandler8 = LogWrapperKt.getCurrentLogHandler();
                                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel11) <= 0) {
                                            str6 = "[Purchases] - " + logLevel11.name();
                                            str7 = (String) function04.invoke();
                                            currentLogHandler8.d(str6, str7);
                                        }
                                        break;
                                    case 2:
                                        LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) function04.invoke(), null);
                                        break;
                                    case 3:
                                        LogLevel logLevel12 = LogLevel.WARN;
                                        LogHandler currentLogHandler9 = LogWrapperKt.getCurrentLogHandler();
                                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel12) <= 0) {
                                            currentLogHandler9.w("[Purchases] - " + logLevel12.name(), (String) function04.invoke());
                                        }
                                        break;
                                    case 4:
                                        LogLevel logLevel13 = LogLevel.INFO;
                                        LogHandler currentLogHandler10 = LogWrapperKt.getCurrentLogHandler();
                                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel13) <= 0) {
                                            currentLogHandler10.i("[Purchases] - " + logLevel13.name(), (String) function04.invoke());
                                        }
                                        break;
                                    case 5:
                                        LogLevel logLevel14 = LogLevel.DEBUG;
                                        currentLogHandler8 = LogWrapperKt.getCurrentLogHandler();
                                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel14) <= 0) {
                                            str6 = "[Purchases] - " + logLevel14.name();
                                            str7 = (String) function04.invoke();
                                            currentLogHandler8.d(str6, str7);
                                        }
                                        break;
                                    case 6:
                                        LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) function04.invoke(), null);
                                        break;
                                    case 7:
                                        LogLevel logLevel15 = LogLevel.INFO;
                                        LogHandler currentLogHandler11 = LogWrapperKt.getCurrentLogHandler();
                                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel15) <= 0) {
                                            currentLogHandler11.i("[Purchases] - " + logLevel15.name(), (String) function04.invoke());
                                        }
                                        break;
                                    case 8:
                                        LogLevel logLevel16 = LogLevel.DEBUG;
                                        currentLogHandler8 = LogWrapperKt.getCurrentLogHandler();
                                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel16) <= 0) {
                                            str6 = "[Purchases] - " + logLevel16.name();
                                            str7 = (String) function04.invoke();
                                            currentLogHandler8.d(str6, str7);
                                        }
                                        break;
                                    case 9:
                                        LogLevel logLevel17 = LogLevel.DEBUG;
                                        currentLogHandler8 = LogWrapperKt.getCurrentLogHandler();
                                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel17) <= 0) {
                                            str6 = "[Purchases] - " + logLevel17.name();
                                            str7 = (String) function04.invoke();
                                            currentLogHandler8.d(str6, str7);
                                        }
                                        break;
                                    case 10:
                                        LogLevel logLevel18 = LogLevel.WARN;
                                        LogHandler currentLogHandler12 = LogWrapperKt.getCurrentLogHandler();
                                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel18) <= 0) {
                                            currentLogHandler12.w("[Purchases] - " + logLevel18.name(), (String) function04.invoke());
                                        }
                                        break;
                                    case 11:
                                        LogLevel logLevel19 = LogLevel.WARN;
                                        LogHandler currentLogHandler13 = LogWrapperKt.getCurrentLogHandler();
                                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel19) <= 0) {
                                            currentLogHandler13.w("[Purchases] - " + logLevel19.name(), (String) function04.invoke());
                                        }
                                        break;
                                    case 12:
                                        LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) function04.invoke(), null);
                                        break;
                                    case 13:
                                        LogLevel logLevel20 = LogLevel.WARN;
                                        LogHandler currentLogHandler14 = LogWrapperKt.getCurrentLogHandler();
                                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel20) <= 0) {
                                            currentLogHandler14.w("[Purchases] - " + logLevel20.name(), (String) function04.invoke());
                                        }
                                        break;
                                    case 14:
                                        LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) function04.invoke(), null);
                                        break;
                                }
                                Function1<SyncPendingPurchaseResult, Unit> function16 = function15;
                                if (function16 != null) {
                                    function16.invoke(new SyncPendingPurchaseResult.Error(error));
                                }
                            }
                        };
                        final Function1<SyncPendingPurchaseResult, Unit> function16 = function13;
                        Function1<PurchasesError, Unit> function17 = new Function1<PurchasesError, Unit>() { // from class: com.revenuecat.purchases.PostPendingTransactionsHelper.syncPendingPurchaseQueue.3.1.3.2
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Object invoke(Object obj4) {
                                invoke((PurchasesError) obj4);
                                return Unit.f139807a;
                            }

                            public final void invoke(PurchasesError it2) {
                                Intrinsics.checkNotNullParameter(it2, "it");
                                Function1<SyncPendingPurchaseResult, Unit> function18 = function16;
                                if (function18 != null) {
                                    function18.invoke(new SyncPendingPurchaseResult.Error(error));
                                }
                            }
                        };
                        final Function1<SyncPendingPurchaseResult, Unit> function18 = function13;
                        postReceiptHelper.postRemainingCachedTransactionMetadata(str5, z5, set2, function03, function17, new Function1<CustomerInfo, Unit>() { // from class: com.revenuecat.purchases.PostPendingTransactionsHelper.syncPendingPurchaseQueue.3.1.3.3
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Object invoke(Object obj4) {
                                invoke((CustomerInfo) obj4);
                                return Unit.f139807a;
                            }

                            public final void invoke(CustomerInfo it2) {
                                Intrinsics.checkNotNullParameter(it2, "it");
                                Function1<SyncPendingPurchaseResult, Unit> function19 = function18;
                                if (function19 != null) {
                                    function19.invoke(new SyncPendingPurchaseResult.Success(it2));
                                }
                            }
                        });
                    }
                };
                final PostPendingTransactionsHelper postPendingTransactionsHelper4 = this.this$0;
                final String str5 = str;
                final boolean z5 = z2;
                final Function1<SyncPendingPurchaseResult, Unit> function15 = function1;
                postPendingTransactionsHelper2.postTransactionsWithCompletion(arrayList2, z3, str3, function02, function14, new Function1<CustomerInfo, Unit>() { // from class: com.revenuecat.purchases.PostPendingTransactionsHelper$syncPendingPurchaseQueue$3$1.4
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Object invoke(Object obj4) {
                        invoke((CustomerInfo) obj4);
                        return Unit.f139807a;
                    }

                    public final void invoke(final CustomerInfo customerInfo) {
                        Intrinsics.checkNotNullParameter(customerInfo, "customerInfo");
                        PostReceiptHelper postReceiptHelper = postPendingTransactionsHelper4.postReceiptHelper;
                        String str6 = str5;
                        boolean z6 = z5;
                        Set<String> set2 = set;
                        final Function1<SyncPendingPurchaseResult, Unit> function16 = function15;
                        Function0<Unit> function03 = new Function0<Unit>() { // from class: com.revenuecat.purchases.PostPendingTransactionsHelper.syncPendingPurchaseQueue.3.1.4.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(0);
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public /* bridge */ /* synthetic */ Object invoke() {
                                m445invoke();
                                return Unit.f139807a;
                            }

                            /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
                            public final void m445invoke() {
                                LogHandler currentLogHandler8;
                                String str7;
                                String str8;
                                final LogIntent logIntent2 = LogIntent.DEBUG;
                                Function0<String> function04 = new Function0<String>() { // from class: com.revenuecat.purchases.PostPendingTransactionsHelper$syncPendingPurchaseQueue$3$1$4$1$invoke$$inlined$log$1
                                    {
                                        super(0);
                                    }

                                    @Override // kotlin.jvm.functions.Function0
                                    public final String invoke() {
                                        return CollectionsKt.joinToString$default(logIntent2.getEmojiList(), "", null, null, 0, null, null, 62, null) + ' ' + PurchaseStrings.NO_PENDING_PURCHASES_TO_SYNC;
                                    }
                                };
                                switch (LogWrapperKt.WhenMappings.$EnumSwitchMapping$0[logIntent2.ordinal()]) {
                                    case 1:
                                        LogLevel logLevel11 = LogLevel.DEBUG;
                                        currentLogHandler8 = LogWrapperKt.getCurrentLogHandler();
                                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel11) <= 0) {
                                            str7 = "[Purchases] - " + logLevel11.name();
                                            str8 = (String) function04.invoke();
                                            currentLogHandler8.d(str7, str8);
                                        }
                                        break;
                                    case 2:
                                        LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) function04.invoke(), null);
                                        break;
                                    case 3:
                                        LogLevel logLevel12 = LogLevel.WARN;
                                        LogHandler currentLogHandler9 = LogWrapperKt.getCurrentLogHandler();
                                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel12) <= 0) {
                                            currentLogHandler9.w("[Purchases] - " + logLevel12.name(), (String) function04.invoke());
                                        }
                                        break;
                                    case 4:
                                        LogLevel logLevel13 = LogLevel.INFO;
                                        LogHandler currentLogHandler10 = LogWrapperKt.getCurrentLogHandler();
                                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel13) <= 0) {
                                            currentLogHandler10.i("[Purchases] - " + logLevel13.name(), (String) function04.invoke());
                                        }
                                        break;
                                    case 5:
                                        LogLevel logLevel14 = LogLevel.DEBUG;
                                        currentLogHandler8 = LogWrapperKt.getCurrentLogHandler();
                                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel14) <= 0) {
                                            str7 = "[Purchases] - " + logLevel14.name();
                                            str8 = (String) function04.invoke();
                                            currentLogHandler8.d(str7, str8);
                                        }
                                        break;
                                    case 6:
                                        LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) function04.invoke(), null);
                                        break;
                                    case 7:
                                        LogLevel logLevel15 = LogLevel.INFO;
                                        LogHandler currentLogHandler11 = LogWrapperKt.getCurrentLogHandler();
                                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel15) <= 0) {
                                            currentLogHandler11.i("[Purchases] - " + logLevel15.name(), (String) function04.invoke());
                                        }
                                        break;
                                    case 8:
                                        LogLevel logLevel16 = LogLevel.DEBUG;
                                        currentLogHandler8 = LogWrapperKt.getCurrentLogHandler();
                                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel16) <= 0) {
                                            str7 = "[Purchases] - " + logLevel16.name();
                                            str8 = (String) function04.invoke();
                                            currentLogHandler8.d(str7, str8);
                                        }
                                        break;
                                    case 9:
                                        LogLevel logLevel17 = LogLevel.DEBUG;
                                        currentLogHandler8 = LogWrapperKt.getCurrentLogHandler();
                                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel17) <= 0) {
                                            str7 = "[Purchases] - " + logLevel17.name();
                                            str8 = (String) function04.invoke();
                                            currentLogHandler8.d(str7, str8);
                                        }
                                        break;
                                    case 10:
                                        LogLevel logLevel18 = LogLevel.WARN;
                                        LogHandler currentLogHandler12 = LogWrapperKt.getCurrentLogHandler();
                                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel18) <= 0) {
                                            currentLogHandler12.w("[Purchases] - " + logLevel18.name(), (String) function04.invoke());
                                        }
                                        break;
                                    case 11:
                                        LogLevel logLevel19 = LogLevel.WARN;
                                        LogHandler currentLogHandler13 = LogWrapperKt.getCurrentLogHandler();
                                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel19) <= 0) {
                                            currentLogHandler13.w("[Purchases] - " + logLevel19.name(), (String) function04.invoke());
                                        }
                                        break;
                                    case 12:
                                        LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) function04.invoke(), null);
                                        break;
                                    case 13:
                                        LogLevel logLevel20 = LogLevel.WARN;
                                        LogHandler currentLogHandler14 = LogWrapperKt.getCurrentLogHandler();
                                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel20) <= 0) {
                                            currentLogHandler14.w("[Purchases] - " + logLevel20.name(), (String) function04.invoke());
                                        }
                                        break;
                                    case 14:
                                        LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) function04.invoke(), null);
                                        break;
                                }
                                Function1<SyncPendingPurchaseResult, Unit> function17 = function16;
                                if (function17 != null) {
                                    function17.invoke(new SyncPendingPurchaseResult.Success(customerInfo));
                                }
                            }
                        };
                        final Function1<SyncPendingPurchaseResult, Unit> function17 = function15;
                        Function1<PurchasesError, Unit> function18 = new Function1<PurchasesError, Unit>() { // from class: com.revenuecat.purchases.PostPendingTransactionsHelper.syncPendingPurchaseQueue.3.1.4.2
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Object invoke(Object obj4) {
                                invoke((PurchasesError) obj4);
                                return Unit.f139807a;
                            }

                            public final void invoke(PurchasesError it2) {
                                Intrinsics.checkNotNullParameter(it2, "it");
                                Function1<SyncPendingPurchaseResult, Unit> function19 = function17;
                                if (function19 != null) {
                                    function19.invoke(new SyncPendingPurchaseResult.Error(it2));
                                }
                            }
                        };
                        final Function1<SyncPendingPurchaseResult, Unit> function19 = function15;
                        postReceiptHelper.postRemainingCachedTransactionMetadata(str6, z6, set2, function03, function18, new Function1<CustomerInfo, Unit>() { // from class: com.revenuecat.purchases.PostPendingTransactionsHelper.syncPendingPurchaseQueue.3.1.4.3
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Object invoke(Object obj4) {
                                invoke((CustomerInfo) obj4);
                                return Unit.f139807a;
                            }

                            public final void invoke(CustomerInfo it2) {
                                Intrinsics.checkNotNullParameter(it2, "it");
                                Function1<SyncPendingPurchaseResult, Unit> function110 = function19;
                                if (function110 != null) {
                                    function110.invoke(new SyncPendingPurchaseResult.Success(it2));
                                }
                            }
                        });
                    }
                });
            }
        }, new Function1<PurchasesError, Unit>() { // from class: com.revenuecat.purchases.PostPendingTransactionsHelper$syncPendingPurchaseQueue$3$2
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

            public final void invoke(final PurchasesError error) {
                LogHandler currentLogHandler;
                String str2;
                String str3;
                Intrinsics.checkNotNullParameter(error, "error");
                final LogIntent logIntent = LogIntent.GOOGLE_ERROR;
                Function0<String> function0 = new Function0<String>() { // from class: com.revenuecat.purchases.PostPendingTransactionsHelper$syncPendingPurchaseQueue$3$2$invoke$$inlined$log$1
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
                Function1<SyncPendingPurchaseResult, Unit> function12 = function1;
                if (function12 != null) {
                    function12.invoke(new SyncPendingPurchaseResult.Error(error));
                }
            }
        });
    }

    public final void syncPendingPurchaseQueue(final boolean z2, final Function1<? super SyncPendingPurchaseResult, Unit> function1) {
        LogHandler currentLogHandler;
        String str;
        String str2;
        if (this.appConfig.getDangerousSettings().getAutoSyncPurchases()) {
            final LogIntent logIntent = LogIntent.DEBUG;
            Function0<String> function0 = new Function0<String>() { // from class: com.revenuecat.purchases.PostPendingTransactionsHelper$syncPendingPurchaseQueue$$inlined$log$2
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return CollectionsKt.joinToString$default(logIntent.getEmojiList(), "", null, null, 0, null, null, 62, null) + ' ' + PurchaseStrings.UPDATING_PENDING_PURCHASE_QUEUE;
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
            final String currentAppUserID = this.identityManager.getCurrentAppUserID();
            Dispatcher.enqueue$default(this.dispatcher, new Runnable() { // from class: com.revenuecat.purchases.f
                @Override // java.lang.Runnable
                public final void run() {
                    PostPendingTransactionsHelper.syncPendingPurchaseQueue$lambda$2(this.f92263a, currentAppUserID, z2, function1);
                }
            }, null, 2, null);
            return;
        }
        final LogIntent logIntent2 = LogIntent.DEBUG;
        Function0<String> function02 = new Function0<String>() { // from class: com.revenuecat.purchases.PostPendingTransactionsHelper$syncPendingPurchaseQueue$$inlined$log$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                return CollectionsKt.joinToString$default(logIntent2.getEmojiList(), "", null, null, 0, null, null, 62, null) + ' ' + PurchaseStrings.SKIPPING_AUTOMATIC_SYNC;
            }
        };
        switch (LogWrapperKt.WhenMappings.$EnumSwitchMapping$0[logIntent2.ordinal()]) {
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
                LogHandler currentLogHandler14 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel15) <= 0) {
                    currentLogHandler14.i("[Purchases] - " + logLevel15.name(), (String) function02.invoke());
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
        if (function1 != null) {
            function1.invoke(SyncPendingPurchaseResult.AutoSyncDisabled.INSTANCE);
        }
    }
}
