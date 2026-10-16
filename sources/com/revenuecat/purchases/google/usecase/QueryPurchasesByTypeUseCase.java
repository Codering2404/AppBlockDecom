package com.revenuecat.purchases.google.usecase;

import com.android.billingclient.api.BillingClient;
import com.android.billingclient.api.BillingResult;
import com.android.billingclient.api.Purchase;
import com.android.billingclient.api.PurchasesResponseListener;
import com.android.billingclient.api.QueryPurchasesParams;
import com.revenuecat.purchases.LogHandler;
import com.revenuecat.purchases.LogLevel;
import com.revenuecat.purchases.PurchasesError;
import com.revenuecat.purchases.common.Config;
import com.revenuecat.purchases.common.DurationExtensionsKt;
import com.revenuecat.purchases.common.LogIntent;
import com.revenuecat.purchases.common.LogWrapperKt;
import com.revenuecat.purchases.common.UtilsKt;
import com.revenuecat.purchases.common.diagnostics.DiagnosticsTracker;
import com.revenuecat.purchases.google.BillingClientParamBuildersKt;
import com.revenuecat.purchases.google.ProductTypeConversionsKt;
import com.revenuecat.purchases.google.StoreTransactionConversionsKt;
import com.revenuecat.purchases.google.usecase.QueryPurchasesByTypeUseCase;
import com.revenuecat.purchases.models.StoreTransaction;
import com.revenuecat.purchases.strings.OfferingStrings;
import com.revenuecat.purchases.strings.PurchaseStrings;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.ranges.RangesKt;
import kotlin.time.Duration;

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
public final class QueryPurchasesByTypeUseCase extends BillingClientUseCase<Map<String, ? extends StoreTransaction>> {
    private final Function1<PurchasesError, Unit> onError;
    private final Function1<Map<String, StoreTransaction>, Unit> onSuccess;
    private final QueryPurchasesByTypeUseCaseParams useCaseParams;
    private final Function1<Function1<? super BillingClient, Unit>, Unit> withConnectedClient;

    /* JADX INFO: renamed from: com.revenuecat.purchases.google.usecase.QueryPurchasesByTypeUseCase$executeAsync$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    static final class AnonymousClass1 extends Lambda implements Function1<BillingClient, Unit> {
        AnonymousClass1() {
            super(1);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void invoke$lambda$1$lambda$0(QueryPurchasesByTypeUseCase queryPurchasesByTypeUseCase, BillingResult result, List purchases) {
            Intrinsics.checkNotNullParameter(result, "result");
            Intrinsics.checkNotNullParameter(purchases, "purchases");
            BillingClientUseCase.processResult$default(queryPurchasesByTypeUseCase, result, queryPurchasesByTypeUseCase.toMapOfGooglePurchaseWrapper(purchases, queryPurchasesByTypeUseCase.useCaseParams.getProductType()), null, null, 12, null);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((BillingClient) obj);
            return Unit.f139807a;
        }

        public final void invoke(BillingClient invoke) {
            Unit unit;
            Intrinsics.checkNotNullParameter(invoke, "$this$invoke");
            QueryPurchasesParams queryPurchasesParamsBuildQueryPurchasesParams = BillingClientParamBuildersKt.buildQueryPurchasesParams(QueryPurchasesByTypeUseCase.this.useCaseParams.getProductType());
            if (queryPurchasesParamsBuildQueryPurchasesParams != null) {
                final QueryPurchasesByTypeUseCase queryPurchasesByTypeUseCase = QueryPurchasesByTypeUseCase.this;
                queryPurchasesByTypeUseCase.queryPurchasesAsyncWithTrackingEnsuringOneResponse(invoke, queryPurchasesByTypeUseCase.useCaseParams.getProductType(), queryPurchasesParamsBuildQueryPurchasesParams, new PurchasesResponseListener() { // from class: com.revenuecat.purchases.google.usecase.h
                    @Override // com.android.billingclient.api.PurchasesResponseListener
                    public final void a(BillingResult billingResult, List list) {
                        QueryPurchasesByTypeUseCase.AnonymousClass1.invoke$lambda$1$lambda$0(queryPurchasesByTypeUseCase, billingResult, list);
                    }
                });
                unit = Unit.f139807a;
            } else {
                unit = null;
            }
            if (unit == null) {
                QueryPurchasesByTypeUseCase queryPurchasesByTypeUseCase2 = QueryPurchasesByTypeUseCase.this;
                LogHandler currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                String str = String.format(PurchaseStrings.INVALID_PRODUCT_TYPE, Arrays.copyOf(new Object[]{"queryPurchasesByType"}, 1));
                Intrinsics.checkNotNullExpressionValue(str, "format(...)");
                currentLogHandler.e("[Purchases] - ERROR", str, null);
                BillingResult billingResultA = BillingResult.d().d(5).a();
                Intrinsics.checkNotNullExpressionValue(billingResultA, "newBuilder()\n           …                 .build()");
                BillingClientUseCase.processResult$default(queryPurchasesByTypeUseCase2, billingResultA, MapsKt.emptyMap(), null, null, 12, null);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public QueryPurchasesByTypeUseCase(QueryPurchasesByTypeUseCaseParams useCaseParams, Function1<? super Map<String, StoreTransaction>, Unit> onSuccess, Function1<? super PurchasesError, Unit> onError, Function1<? super Function1<? super BillingClient, Unit>, Unit> withConnectedClient, Function2<? super Long, ? super Function1<? super PurchasesError, Unit>, Unit> executeRequestOnUIThread) {
        super(useCaseParams, onError, executeRequestOnUIThread);
        Intrinsics.checkNotNullParameter(useCaseParams, "useCaseParams");
        Intrinsics.checkNotNullParameter(onSuccess, "onSuccess");
        Intrinsics.checkNotNullParameter(onError, "onError");
        Intrinsics.checkNotNullParameter(withConnectedClient, "withConnectedClient");
        Intrinsics.checkNotNullParameter(executeRequestOnUIThread, "executeRequestOnUIThread");
        this.useCaseParams = useCaseParams;
        this.onSuccess = onSuccess;
        this.onError = onError;
        this.withConnectedClient = withConnectedClient;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void queryPurchasesAsyncWithTrackingEnsuringOneResponse(BillingClient billingClient, final String str, QueryPurchasesParams queryPurchasesParams, final PurchasesResponseListener purchasesResponseListener) {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final Date now = this.useCaseParams.getDateProvider().getNow();
        billingClient.j(queryPurchasesParams, new PurchasesResponseListener() { // from class: com.revenuecat.purchases.google.usecase.g
            @Override // com.android.billingclient.api.PurchasesResponseListener
            public final void a(BillingResult billingResult, List list) {
                QueryPurchasesByTypeUseCase.queryPurchasesAsyncWithTrackingEnsuringOneResponse$lambda$2(atomicBoolean, this, str, now, purchasesResponseListener, billingResult, list);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void queryPurchasesAsyncWithTrackingEnsuringOneResponse$lambda$2(AtomicBoolean atomicBoolean, QueryPurchasesByTypeUseCase queryPurchasesByTypeUseCase, String str, Date date, PurchasesResponseListener purchasesResponseListener, final BillingResult billingResult, List purchases) {
        Intrinsics.checkNotNullParameter(billingResult, "billingResult");
        Intrinsics.checkNotNullParameter(purchases, "purchases");
        if (!atomicBoolean.getAndSet(true)) {
            ArrayList arrayList = new ArrayList();
            Iterator it = purchases.iterator();
            while (it.hasNext()) {
                List listC = ((Purchase) it.next()).c();
                Intrinsics.checkNotNullExpressionValue(listC, "it.products");
                CollectionsKt.addAll(arrayList, listC);
            }
            queryPurchasesByTypeUseCase.trackGoogleQueryPurchasesRequestIfNeeded(str, arrayList, billingResult, date);
            purchasesResponseListener.a(billingResult, purchases);
            return;
        }
        final LogIntent logIntent = LogIntent.GOOGLE_ERROR;
        Function0<String> function0 = new Function0<String>() { // from class: com.revenuecat.purchases.google.usecase.QueryPurchasesByTypeUseCase$queryPurchasesAsyncWithTrackingEnsuringOneResponse$lambda$2$$inlined$log$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                StringBuilder sb = new StringBuilder();
                sb.append(CollectionsKt.joinToString$default(logIntent.getEmojiList(), "", null, null, 0, null, null, 62, null));
                sb.append(' ');
                String str2 = String.format(OfferingStrings.EXTRA_QUERY_PURCHASES_RESPONSE, Arrays.copyOf(new Object[]{Integer.valueOf(billingResult.c())}, 1));
                Intrinsics.checkNotNullExpressionValue(str2, "format(...)");
                sb.append(str2);
                return sb.toString();
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

    /* JADX INFO: Access modifiers changed from: private */
    public final Map<String, StoreTransaction> toMapOfGooglePurchaseWrapper(List<? extends Purchase> list, String str) {
        List<? extends Purchase> list2 = list;
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.f(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(list2, 10)), 16));
        for (Purchase purchase : list2) {
            String strF = purchase.f();
            Intrinsics.checkNotNullExpressionValue(strF, "purchase.purchaseToken");
            Pair pairA = TuplesKt.a(UtilsKt.sha1(strF), StoreTransactionConversionsKt.toStoreTransaction$default(purchase, ProductTypeConversionsKt.toRevenueCatProductType(str), null, null, null, null, 30, null));
            linkedHashMap.put(pairA.e(), pairA.f());
        }
        return linkedHashMap;
    }

    private final void trackGoogleQueryPurchasesRequestIfNeeded(String str, List<String> list, BillingResult billingResult, Date date) {
        DiagnosticsTracker diagnosticsTrackerIfEnabled = this.useCaseParams.getDiagnosticsTrackerIfEnabled();
        if (diagnosticsTrackerIfEnabled != null) {
            int iC = billingResult.c();
            String strA = billingResult.a();
            Intrinsics.checkNotNullExpressionValue(strA, "billingResult.debugMessage");
            diagnosticsTrackerIfEnabled.m538trackGoogleQueryPurchasesRequestzkXUZaI(str, iC, strA, DurationExtensionsKt.between(Duration.f140631b, date, this.useCaseParams.getDateProvider().getNow()), list);
        }
    }

    @Override // com.revenuecat.purchases.google.usecase.BillingClientUseCase
    public void executeAsync() {
        this.withConnectedClient.invoke(new AnonymousClass1());
    }

    @Override // com.revenuecat.purchases.google.usecase.BillingClientUseCase
    public String getErrorMessage() {
        return "Error when querying purchases of type " + this.useCaseParams.getProductType();
    }

    public final Function1<PurchasesError, Unit> getOnError() {
        return this.onError;
    }

    public final Function1<Map<String, StoreTransaction>, Unit> getOnSuccess() {
        return this.onSuccess;
    }

    public final Function1<Function1<? super BillingClient, Unit>, Unit> getWithConnectedClient() {
        return this.withConnectedClient;
    }

    @Override // com.revenuecat.purchases.google.usecase.BillingClientUseCase
    public /* bridge */ /* synthetic */ void onOk(Map<String, ? extends StoreTransaction> map) {
        onOk2((Map<String, StoreTransaction>) map);
    }

    /* JADX INFO: renamed from: onOk, reason: avoid collision after fix types in other method */
    public void onOk2(Map<String, StoreTransaction> received) {
        Intrinsics.checkNotNullParameter(received, "received");
        this.onSuccess.invoke(received);
    }
}
