package com.revenuecat.purchases.google.usecase;

import com.android.billingclient.api.BillingClient;
import com.android.billingclient.api.BillingResult;
import com.android.billingclient.api.ProductDetails;
import com.android.billingclient.api.ProductDetailsResponseListener;
import com.android.billingclient.api.QueryProductDetailsParams;
import com.android.billingclient.api.QueryProductDetailsResult;
import com.android.billingclient.api.UnfetchedProduct;
import com.revenuecat.purchases.LogHandler;
import com.revenuecat.purchases.LogLevel;
import com.revenuecat.purchases.PurchasesError;
import com.revenuecat.purchases.PurchasesErrorCode;
import com.revenuecat.purchases.common.Config;
import com.revenuecat.purchases.common.DurationExtensionsKt;
import com.revenuecat.purchases.common.LogIntent;
import com.revenuecat.purchases.common.LogWrapperKt;
import com.revenuecat.purchases.common.diagnostics.DiagnosticsTracker;
import com.revenuecat.purchases.google.BillingClientParamBuildersKt;
import com.revenuecat.purchases.google.ProductTypeConversionsKt;
import com.revenuecat.purchases.google.QueryProductDetailsParamsBuilderException;
import com.revenuecat.purchases.google.StoreProductConversionsKt;
import com.revenuecat.purchases.models.StoreProduct;
import com.revenuecat.purchases.strings.OfferingStrings;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
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
public final class QueryProductDetailsUseCase extends BillingClientUseCase<QueryProductDetailsResult> {
    private final Function1<PurchasesError, Unit> onError;
    private final Function1<List<? extends StoreProduct>, Unit> onReceive;
    private final QueryProductDetailsUseCaseParams useCaseParams;
    private final Function1<Function1<? super BillingClient, Unit>, Unit> withConnectedClient;

    /* JADX INFO: renamed from: com.revenuecat.purchases.google.usecase.QueryProductDetailsUseCase$executeAsync$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    static final class AnonymousClass2 extends Lambda implements Function1<BillingClient, Unit> {
        final /* synthetic */ Set<String> $nonEmptyProductIds;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(Set<String> set) {
            super(1);
            this.$nonEmptyProductIds = set;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Object obj) throws Throwable {
            invoke((BillingClient) obj);
            return Unit.f139807a;
        }

        public final void invoke(BillingClient invoke) throws Throwable {
            Intrinsics.checkNotNullParameter(invoke, "$this$invoke");
            String googleProductType = ProductTypeConversionsKt.toGoogleProductType(QueryProductDetailsUseCase.this.useCaseParams.getProductType());
            if (googleProductType == null) {
                googleProductType = "inapp";
            }
            try {
                final QueryProductDetailsUseCase queryProductDetailsUseCase = QueryProductDetailsUseCase.this;
                queryProductDetailsUseCase.queryProductDetailsAsyncEnsuringOneResponse(invoke, googleProductType, this.$nonEmptyProductIds, new ProductDetailsResponseListener() { // from class: com.revenuecat.purchases.google.usecase.e
                    @Override // com.android.billingclient.api.ProductDetailsResponseListener
                    public final void a(BillingResult billingResult, QueryProductDetailsResult queryProductDetailsResult) {
                        BillingClientUseCase.processResult$default(queryProductDetailsUseCase, billingResult, queryProductDetailsResult, null, null, 12, null);
                    }
                });
            } catch (QueryProductDetailsParamsBuilderException e3) {
                Function1<PurchasesError, Unit> onError = QueryProductDetailsUseCase.this.getOnError();
                PurchasesErrorCode purchasesErrorCode = PurchasesErrorCode.StoreProblemError;
                StringBuilder sb = new StringBuilder();
                sb.append(e3.getMessage());
                sb.append(": ");
                Throwable cause = e3.getCause();
                sb.append(cause != null ? cause.getMessage() : null);
                onError.invoke(new PurchasesError(purchasesErrorCode, sb.toString()));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public QueryProductDetailsUseCase(QueryProductDetailsUseCaseParams useCaseParams, Function1<? super List<? extends StoreProduct>, Unit> onReceive, Function1<? super PurchasesError, Unit> onError, Function1<? super Function1<? super BillingClient, Unit>, Unit> withConnectedClient, Function2<? super Long, ? super Function1<? super PurchasesError, Unit>, Unit> executeRequestOnUIThread) {
        super(useCaseParams, onError, executeRequestOnUIThread);
        Intrinsics.checkNotNullParameter(useCaseParams, "useCaseParams");
        Intrinsics.checkNotNullParameter(onReceive, "onReceive");
        Intrinsics.checkNotNullParameter(onError, "onError");
        Intrinsics.checkNotNullParameter(withConnectedClient, "withConnectedClient");
        Intrinsics.checkNotNullParameter(executeRequestOnUIThread, "executeRequestOnUIThread");
        this.useCaseParams = useCaseParams;
        this.onReceive = onReceive;
        this.onError = onError;
        this.withConnectedClient = withConnectedClient;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String convertUnfetchedProductStatusCodeToString(int i3) {
        if (i3 == 0) {
            return "UNKNOWN";
        }
        if (i3 == 2) {
            return "INVALID_PRODUCT_ID_FORMAT";
        }
        if (i3 == 3) {
            return "PRODUCT_NOT_FOUND";
        }
        if (i3 == 4) {
            return "NO_ELIGIBLE_OFFER";
        }
        return "UNKNOWN_STATUS_CODE: " + i3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final synchronized void queryProductDetailsAsyncEnsuringOneResponse(BillingClient billingClient, final String str, final Set<String> set, final ProductDetailsResponseListener productDetailsResponseListener) throws Throwable {
        try {
            try {
                QueryProductDetailsParams queryProductDetailsParamsBuildQueryProductDetailsParams = BillingClientParamBuildersKt.buildQueryProductDetailsParams(str, set);
                final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
                final Date now = this.useCaseParams.getDateProvider().getNow();
                billingClient.i(queryProductDetailsParamsBuildQueryProductDetailsParams, new ProductDetailsResponseListener() { // from class: com.revenuecat.purchases.google.usecase.d
                    @Override // com.android.billingclient.api.ProductDetailsResponseListener
                    public final void a(BillingResult billingResult, QueryProductDetailsResult queryProductDetailsResult) {
                        QueryProductDetailsUseCase.queryProductDetailsAsyncEnsuringOneResponse$lambda$14(atomicBoolean, this, set, str, now, productDetailsResponseListener, billingResult, queryProductDetailsResult);
                    }
                });
            } catch (Throwable th) {
                th = th;
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void queryProductDetailsAsyncEnsuringOneResponse$lambda$14(AtomicBoolean atomicBoolean, QueryProductDetailsUseCase queryProductDetailsUseCase, Set set, String str, Date date, ProductDetailsResponseListener productDetailsResponseListener, final BillingResult billingResult, QueryProductDetailsResult productDetailsList) {
        Intrinsics.checkNotNullParameter(billingResult, "billingResult");
        Intrinsics.checkNotNullParameter(productDetailsList, "productDetailsList");
        if (!atomicBoolean.getAndSet(true)) {
            queryProductDetailsUseCase.trackGoogleQueryProductDetailsRequestIfNeeded(set, str, billingResult, date);
            productDetailsResponseListener.a(billingResult, productDetailsList);
            return;
        }
        final LogIntent logIntent = LogIntent.GOOGLE_ERROR;
        Function0<String> function0 = new Function0<String>() { // from class: com.revenuecat.purchases.google.usecase.QueryProductDetailsUseCase$queryProductDetailsAsyncEnsuringOneResponse$lambda$14$$inlined$log$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                StringBuilder sb = new StringBuilder();
                sb.append(CollectionsKt.joinToString$default(logIntent.getEmojiList(), "", null, null, 0, null, null, 62, null));
                sb.append(' ');
                String str2 = String.format(OfferingStrings.EXTRA_QUERY_PRODUCT_DETAILS_RESPONSE, Arrays.copyOf(new Object[]{Integer.valueOf(billingResult.c())}, 1));
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

    private final void trackGoogleQueryProductDetailsRequestIfNeeded(Set<String> set, String str, BillingResult billingResult, Date date) {
        DiagnosticsTracker diagnosticsTrackerIfEnabled = this.useCaseParams.getDiagnosticsTrackerIfEnabled();
        if (diagnosticsTrackerIfEnabled != null) {
            int iC = billingResult.c();
            String strA = billingResult.a();
            Intrinsics.checkNotNullExpressionValue(strA, "billingResult.debugMessage");
            diagnosticsTrackerIfEnabled.m536trackGoogleQueryProductDetailsRequest9VgGkz4(set, str, iC, strA, DurationExtensionsKt.between(Duration.f140631b, date, this.useCaseParams.getDateProvider().getNow()));
        }
    }

    @Override // com.revenuecat.purchases.google.usecase.BillingClientUseCase
    public void executeAsync() {
        LogHandler currentLogHandler;
        String str;
        String str2;
        Set<String> productIds = this.useCaseParams.getProductIds();
        ArrayList arrayList = new ArrayList();
        for (Object obj : productIds) {
            if (((String) obj).length() > 0) {
                arrayList.add(obj);
            }
        }
        Set set = CollectionsKt.toSet(arrayList);
        if (!set.isEmpty()) {
            this.withConnectedClient.invoke(new AnonymousClass2(set));
            return;
        }
        final LogIntent logIntent = LogIntent.DEBUG;
        Function0<String> function0 = new Function0<String>() { // from class: com.revenuecat.purchases.google.usecase.QueryProductDetailsUseCase$executeAsync$$inlined$log$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                return CollectionsKt.joinToString$default(logIntent.getEmojiList(), "", null, null, 0, null, null, 62, null) + ' ' + OfferingStrings.EMPTY_PRODUCT_ID_LIST;
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
        this.onReceive.invoke(CollectionsKt.emptyList());
    }

    @Override // com.revenuecat.purchases.google.usecase.BillingClientUseCase
    public String getErrorMessage() {
        return "Error when fetching products";
    }

    public final Function1<PurchasesError, Unit> getOnError() {
        return this.onError;
    }

    public final Function1<List<? extends StoreProduct>, Unit> getOnReceive() {
        return this.onReceive;
    }

    public final Function1<Function1<? super BillingClient, Unit>, Unit> getWithConnectedClient() {
        return this.withConnectedClient;
    }

    @Override // com.revenuecat.purchases.google.usecase.BillingClientUseCase
    public void onOk(final QueryProductDetailsResult received) {
        LogHandler currentLogHandler;
        String str;
        Object objInvoke;
        LogHandler currentLogHandler2;
        String str2;
        Object objInvoke2;
        LogHandler currentLogHandler3;
        String str3;
        String str4;
        LogHandler currentLogHandler4;
        String str5;
        String str6;
        Intrinsics.checkNotNullParameter(received, "received");
        final LogIntent logIntent = LogIntent.DEBUG;
        Function0<String> function0 = new Function0<String>() { // from class: com.revenuecat.purchases.google.usecase.QueryProductDetailsUseCase$onOk$$inlined$log$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                StringBuilder sb = new StringBuilder();
                sb.append(CollectionsKt.joinToString$default(logIntent.getEmojiList(), "", null, null, 0, null, null, 62, null));
                sb.append(' ');
                String str7 = String.format(OfferingStrings.FETCHING_PRODUCTS_FINISHED, Arrays.copyOf(new Object[]{CollectionsKt.joinToString$default(this.useCaseParams.getProductIds(), null, null, null, 0, null, null, 63, null)}, 1));
                Intrinsics.checkNotNullExpressionValue(str7, "format(...)");
                sb.append(str7);
                return sb.toString();
            }
        };
        int[] iArr = LogWrapperKt.WhenMappings.$EnumSwitchMapping$0;
        switch (iArr[logIntent.ordinal()]) {
            case 1:
                LogLevel logLevel = LogLevel.DEBUG;
                currentLogHandler4 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                    str5 = "[Purchases] - " + logLevel.name();
                    str6 = (String) function0.invoke();
                    currentLogHandler4.d(str5, str6);
                }
                break;
            case 2:
                LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) function0.invoke(), null);
                break;
            case 3:
                LogLevel logLevel2 = LogLevel.WARN;
                LogHandler currentLogHandler5 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel2) <= 0) {
                    currentLogHandler5.w("[Purchases] - " + logLevel2.name(), (String) function0.invoke());
                }
                break;
            case 4:
                LogLevel logLevel3 = LogLevel.INFO;
                LogHandler currentLogHandler6 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel3) <= 0) {
                    currentLogHandler6.i("[Purchases] - " + logLevel3.name(), (String) function0.invoke());
                }
                break;
            case 5:
                LogLevel logLevel4 = LogLevel.DEBUG;
                currentLogHandler4 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel4) <= 0) {
                    str5 = "[Purchases] - " + logLevel4.name();
                    str6 = (String) function0.invoke();
                    currentLogHandler4.d(str5, str6);
                }
                break;
            case 6:
                LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) function0.invoke(), null);
                break;
            case 7:
                LogLevel logLevel5 = LogLevel.INFO;
                LogHandler currentLogHandler7 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel5) <= 0) {
                    currentLogHandler7.i("[Purchases] - " + logLevel5.name(), (String) function0.invoke());
                }
                break;
            case 8:
                LogLevel logLevel6 = LogLevel.DEBUG;
                currentLogHandler4 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel6) <= 0) {
                    str5 = "[Purchases] - " + logLevel6.name();
                    str6 = (String) function0.invoke();
                    currentLogHandler4.d(str5, str6);
                }
                break;
            case 9:
                LogLevel logLevel7 = LogLevel.DEBUG;
                currentLogHandler4 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel7) <= 0) {
                    str5 = "[Purchases] - " + logLevel7.name();
                    str6 = (String) function0.invoke();
                    currentLogHandler4.d(str5, str6);
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
        final LogIntent logIntent2 = LogIntent.PURCHASE;
        Function0<String> function02 = new Function0<String>() { // from class: com.revenuecat.purchases.google.usecase.QueryProductDetailsUseCase$onOk$$inlined$log$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                StringBuilder sb = new StringBuilder();
                sb.append(CollectionsKt.joinToString$default(logIntent2.getEmojiList(), "", null, null, 0, null, null, 62, null));
                sb.append(' ');
                List listA = received.a();
                Intrinsics.checkNotNullExpressionValue(listA, "received.productDetailsList");
                String str7 = String.format(OfferingStrings.RETRIEVED_PRODUCTS, Arrays.copyOf(new Object[]{CollectionsKt.joinToString$default(listA, null, null, null, 0, null, new Function1<ProductDetails, CharSequence>() { // from class: com.revenuecat.purchases.google.usecase.QueryProductDetailsUseCase$onOk$2$1
                    @Override // kotlin.jvm.functions.Function1
                    public final CharSequence invoke(ProductDetails productDetails) {
                        String string = productDetails.toString();
                        Intrinsics.checkNotNullExpressionValue(string, "it.toString()");
                        return string;
                    }
                }, 31, null)}, 1));
                Intrinsics.checkNotNullExpressionValue(str7, "format(...)");
                sb.append(str7);
                return sb.toString();
            }
        };
        switch (iArr[logIntent2.ordinal()]) {
            case 1:
                LogLevel logLevel11 = LogLevel.DEBUG;
                LogHandler currentLogHandler11 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel11) <= 0) {
                    currentLogHandler11.d("[Purchases] - " + logLevel11.name(), (String) function02.invoke());
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
                LogHandler currentLogHandler14 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel14) <= 0) {
                    currentLogHandler14.d("[Purchases] - " + logLevel14.name(), (String) function02.invoke());
                }
                break;
            case 6:
                LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) function02.invoke(), null);
                break;
            case 7:
                LogLevel logLevel15 = LogLevel.INFO;
                LogHandler currentLogHandler15 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel15) <= 0) {
                    currentLogHandler15.i("[Purchases] - " + logLevel15.name(), (String) function02.invoke());
                }
                break;
            case 8:
                LogLevel logLevel16 = LogLevel.DEBUG;
                LogHandler currentLogHandler16 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel16) <= 0) {
                    currentLogHandler16.d("[Purchases] - " + logLevel16.name(), (String) function02.invoke());
                }
                break;
            case 9:
                LogLevel logLevel17 = LogLevel.DEBUG;
                LogHandler currentLogHandler17 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel17) <= 0) {
                    currentLogHandler17.d("[Purchases] - " + logLevel17.name(), (String) function02.invoke());
                }
                break;
            case 10:
                LogLevel logLevel18 = LogLevel.WARN;
                LogHandler currentLogHandler18 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel18) <= 0) {
                    currentLogHandler18.w("[Purchases] - " + logLevel18.name(), (String) function02.invoke());
                }
                break;
            case 11:
                LogLevel logLevel19 = LogLevel.WARN;
                LogHandler currentLogHandler19 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel19) <= 0) {
                    currentLogHandler19.w("[Purchases] - " + logLevel19.name(), (String) function02.invoke());
                }
                break;
            case 12:
                LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) function02.invoke(), null);
                break;
            case 13:
                LogLevel logLevel20 = LogLevel.WARN;
                LogHandler currentLogHandler20 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel20) <= 0) {
                    currentLogHandler20.w("[Purchases] - " + logLevel20.name(), (String) function02.invoke());
                }
                break;
            case 14:
                LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) function02.invoke(), null);
                break;
        }
        List it = received.b();
        Intrinsics.checkNotNullExpressionValue(it, "it");
        if (it.isEmpty()) {
            it = null;
        }
        if (it != null) {
            final LogIntent logIntent3 = LogIntent.INFO;
            Function0<String> function03 = new Function0<String>() { // from class: com.revenuecat.purchases.google.usecase.QueryProductDetailsUseCase$onOk$lambda$6$$inlined$log$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    StringBuilder sb = new StringBuilder();
                    sb.append(CollectionsKt.joinToString$default(logIntent3.getEmojiList(), "", null, null, 0, null, null, 62, null));
                    sb.append(' ');
                    List listB = received.b();
                    Intrinsics.checkNotNullExpressionValue(listB, "received.unfetchedProductList");
                    String str7 = String.format(OfferingStrings.MISSING_PRODUCT_DETAILS, Arrays.copyOf(new Object[]{CollectionsKt.joinToString$default(listB, null, null, null, 0, null, new Function1<UnfetchedProduct, CharSequence>() { // from class: com.revenuecat.purchases.google.usecase.QueryProductDetailsUseCase$onOk$4$1$1
                        @Override // kotlin.jvm.functions.Function1
                        public final CharSequence invoke(UnfetchedProduct unfetchedProduct) {
                            String string = unfetchedProduct.toString();
                            Intrinsics.checkNotNullExpressionValue(string, "it.toString()");
                            return string;
                        }
                    }, 31, null)}, 1));
                    Intrinsics.checkNotNullExpressionValue(str7, "format(...)");
                    sb.append(str7);
                    return sb.toString();
                }
            };
            switch (iArr[logIntent3.ordinal()]) {
                case 1:
                    LogLevel logLevel21 = LogLevel.DEBUG;
                    currentLogHandler3 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel21) <= 0) {
                        str3 = "[Purchases] - " + logLevel21.name();
                        str4 = (String) function03.invoke();
                        currentLogHandler3.d(str3, str4);
                    }
                    break;
                case 2:
                    LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) function03.invoke(), null);
                    break;
                case 3:
                    LogLevel logLevel22 = LogLevel.WARN;
                    LogHandler currentLogHandler21 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel22) <= 0) {
                        currentLogHandler21.w("[Purchases] - " + logLevel22.name(), (String) function03.invoke());
                    }
                    break;
                case 4:
                    LogLevel logLevel23 = LogLevel.INFO;
                    LogHandler currentLogHandler22 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel23) <= 0) {
                        currentLogHandler22.i("[Purchases] - " + logLevel23.name(), (String) function03.invoke());
                    }
                    break;
                case 5:
                    LogLevel logLevel24 = LogLevel.DEBUG;
                    currentLogHandler3 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel24) <= 0) {
                        str3 = "[Purchases] - " + logLevel24.name();
                        str4 = (String) function03.invoke();
                        currentLogHandler3.d(str3, str4);
                    }
                    break;
                case 6:
                    LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) function03.invoke(), null);
                    break;
                case 7:
                    LogLevel logLevel25 = LogLevel.INFO;
                    LogHandler currentLogHandler23 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel25) <= 0) {
                        currentLogHandler23.i("[Purchases] - " + logLevel25.name(), (String) function03.invoke());
                    }
                    break;
                case 8:
                    LogLevel logLevel26 = LogLevel.DEBUG;
                    currentLogHandler3 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel26) <= 0) {
                        str3 = "[Purchases] - " + logLevel26.name();
                        str4 = (String) function03.invoke();
                        currentLogHandler3.d(str3, str4);
                    }
                    break;
                case 9:
                    LogLevel logLevel27 = LogLevel.DEBUG;
                    currentLogHandler3 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel27) <= 0) {
                        str3 = "[Purchases] - " + logLevel27.name();
                        str4 = (String) function03.invoke();
                        currentLogHandler3.d(str3, str4);
                    }
                    break;
                case 10:
                    LogLevel logLevel28 = LogLevel.WARN;
                    LogHandler currentLogHandler24 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel28) <= 0) {
                        currentLogHandler24.w("[Purchases] - " + logLevel28.name(), (String) function03.invoke());
                    }
                    break;
                case 11:
                    LogLevel logLevel29 = LogLevel.WARN;
                    LogHandler currentLogHandler25 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel29) <= 0) {
                        currentLogHandler25.w("[Purchases] - " + logLevel29.name(), (String) function03.invoke());
                    }
                    break;
                case 12:
                    LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) function03.invoke(), null);
                    break;
                case 13:
                    LogLevel logLevel30 = LogLevel.WARN;
                    LogHandler currentLogHandler26 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel30) <= 0) {
                        currentLogHandler26.w("[Purchases] - " + logLevel30.name(), (String) function03.invoke());
                    }
                    break;
                case 14:
                    LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) function03.invoke(), null);
                    break;
            }
            Unit unit = Unit.f139807a;
        }
        List<ProductDetails> listA = received.a();
        if (listA.isEmpty()) {
            listA = null;
        }
        if (listA != null) {
            for (final ProductDetails productDetails : listA) {
                final LogIntent logIntent4 = LogIntent.PURCHASE;
                Function0<String> function04 = new Function0<String>() { // from class: com.revenuecat.purchases.google.usecase.QueryProductDetailsUseCase$onOk$lambda$9$$inlined$log$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final String invoke() {
                        StringBuilder sb = new StringBuilder();
                        sb.append(CollectionsKt.joinToString$default(logIntent4.getEmojiList(), "", null, null, 0, null, null, 62, null));
                        sb.append(' ');
                        String str7 = String.format(OfferingStrings.LIST_PRODUCTS, Arrays.copyOf(new Object[]{productDetails.e(), productDetails}, 2));
                        Intrinsics.checkNotNullExpressionValue(str7, "format(...)");
                        sb.append(str7);
                        return sb.toString();
                    }
                };
                switch (LogWrapperKt.WhenMappings.$EnumSwitchMapping$0[logIntent4.ordinal()]) {
                    case 1:
                        LogLevel logLevel31 = LogLevel.DEBUG;
                        currentLogHandler2 = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel31) <= 0) {
                            str2 = "[Purchases] - " + logLevel31.name();
                            objInvoke2 = function04.invoke();
                        }
                        break;
                    case 2:
                        LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) function04.invoke(), null);
                        continue;
                    case 3:
                        LogLevel logLevel32 = LogLevel.WARN;
                        LogHandler currentLogHandler27 = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel32) <= 0) {
                            currentLogHandler27.w("[Purchases] - " + logLevel32.name(), (String) function04.invoke());
                        } else {
                            continue;
                        }
                        break;
                    case 4:
                        LogLevel logLevel33 = LogLevel.INFO;
                        LogHandler currentLogHandler28 = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel33) <= 0) {
                            currentLogHandler28.i("[Purchases] - " + logLevel33.name(), (String) function04.invoke());
                        } else {
                            continue;
                        }
                        break;
                    case 5:
                        LogLevel logLevel34 = LogLevel.DEBUG;
                        currentLogHandler2 = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel34) <= 0) {
                            str2 = "[Purchases] - " + logLevel34.name();
                            objInvoke2 = function04.invoke();
                        }
                        break;
                    case 6:
                        LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) function04.invoke(), null);
                        continue;
                    case 7:
                        LogLevel logLevel35 = LogLevel.INFO;
                        LogHandler currentLogHandler29 = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel35) <= 0) {
                            currentLogHandler29.i("[Purchases] - " + logLevel35.name(), (String) function04.invoke());
                        } else {
                            continue;
                        }
                        break;
                    case 8:
                        LogLevel logLevel36 = LogLevel.DEBUG;
                        currentLogHandler2 = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel36) <= 0) {
                            str2 = "[Purchases] - " + logLevel36.name();
                            objInvoke2 = function04.invoke();
                        }
                        break;
                    case 9:
                        LogLevel logLevel37 = LogLevel.DEBUG;
                        currentLogHandler2 = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel37) <= 0) {
                            str2 = "[Purchases] - " + logLevel37.name();
                            objInvoke2 = function04.invoke();
                        }
                        break;
                    case 10:
                        LogLevel logLevel38 = LogLevel.WARN;
                        LogHandler currentLogHandler30 = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel38) <= 0) {
                            currentLogHandler30.w("[Purchases] - " + logLevel38.name(), (String) function04.invoke());
                        } else {
                            continue;
                        }
                        break;
                    case 11:
                        LogLevel logLevel39 = LogLevel.WARN;
                        LogHandler currentLogHandler31 = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel39) <= 0) {
                            currentLogHandler31.w("[Purchases] - " + logLevel39.name(), (String) function04.invoke());
                        } else {
                            continue;
                        }
                        break;
                    case 12:
                        LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) function04.invoke(), null);
                        continue;
                    case 13:
                        LogLevel logLevel40 = LogLevel.WARN;
                        LogHandler currentLogHandler32 = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel40) <= 0) {
                            currentLogHandler32.w("[Purchases] - " + logLevel40.name(), (String) function04.invoke());
                        } else {
                            continue;
                        }
                        break;
                    case 14:
                        LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) function04.invoke(), null);
                        continue;
                }
                currentLogHandler2.d(str2, (String) objInvoke2);
            }
            Unit unit2 = Unit.f139807a;
        }
        List<UnfetchedProduct> listB = received.b();
        if (listB.isEmpty()) {
            listB = null;
        }
        if (listB != null) {
            for (final UnfetchedProduct unfetchedProduct : listB) {
                final LogIntent logIntent5 = LogIntent.INFO;
                Function0<String> function05 = new Function0<String>() { // from class: com.revenuecat.purchases.google.usecase.QueryProductDetailsUseCase$onOk$lambda$12$$inlined$log$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final String invoke() {
                        StringBuilder sb = new StringBuilder();
                        sb.append(CollectionsKt.joinToString$default(logIntent5.getEmojiList(), "", null, null, 0, null, null, 62, null));
                        sb.append(' ');
                        String str7 = String.format(OfferingStrings.LIST_UNFETCHED_PRODUCTS, Arrays.copyOf(new Object[]{unfetchedProduct.a(), unfetchedProduct.b(), this.convertUnfetchedProductStatusCodeToString(unfetchedProduct.d()), unfetchedProduct.c()}, 4));
                        Intrinsics.checkNotNullExpressionValue(str7, "format(...)");
                        sb.append(str7);
                        return sb.toString();
                    }
                };
                switch (LogWrapperKt.WhenMappings.$EnumSwitchMapping$0[logIntent5.ordinal()]) {
                    case 1:
                        LogLevel logLevel41 = LogLevel.DEBUG;
                        currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel41) <= 0) {
                            str = "[Purchases] - " + logLevel41.name();
                            objInvoke = function05.invoke();
                        }
                        break;
                    case 2:
                        LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) function05.invoke(), null);
                        continue;
                    case 3:
                        LogLevel logLevel42 = LogLevel.WARN;
                        LogHandler currentLogHandler33 = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel42) <= 0) {
                            currentLogHandler33.w("[Purchases] - " + logLevel42.name(), (String) function05.invoke());
                        } else {
                            continue;
                        }
                        break;
                    case 4:
                        LogLevel logLevel43 = LogLevel.INFO;
                        LogHandler currentLogHandler34 = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel43) <= 0) {
                            currentLogHandler34.i("[Purchases] - " + logLevel43.name(), (String) function05.invoke());
                        } else {
                            continue;
                        }
                        break;
                    case 5:
                        LogLevel logLevel44 = LogLevel.DEBUG;
                        currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel44) <= 0) {
                            str = "[Purchases] - " + logLevel44.name();
                            objInvoke = function05.invoke();
                        }
                        break;
                    case 6:
                        LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) function05.invoke(), null);
                        continue;
                    case 7:
                        LogLevel logLevel45 = LogLevel.INFO;
                        LogHandler currentLogHandler35 = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel45) <= 0) {
                            currentLogHandler35.i("[Purchases] - " + logLevel45.name(), (String) function05.invoke());
                        } else {
                            continue;
                        }
                        break;
                    case 8:
                        LogLevel logLevel46 = LogLevel.DEBUG;
                        currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel46) <= 0) {
                            str = "[Purchases] - " + logLevel46.name();
                            objInvoke = function05.invoke();
                        }
                        break;
                    case 9:
                        LogLevel logLevel47 = LogLevel.DEBUG;
                        currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel47) <= 0) {
                            str = "[Purchases] - " + logLevel47.name();
                            objInvoke = function05.invoke();
                        }
                        break;
                    case 10:
                        LogLevel logLevel48 = LogLevel.WARN;
                        LogHandler currentLogHandler36 = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel48) <= 0) {
                            currentLogHandler36.w("[Purchases] - " + logLevel48.name(), (String) function05.invoke());
                        } else {
                            continue;
                        }
                        break;
                    case 11:
                        LogLevel logLevel49 = LogLevel.WARN;
                        LogHandler currentLogHandler37 = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel49) <= 0) {
                            currentLogHandler37.w("[Purchases] - " + logLevel49.name(), (String) function05.invoke());
                        } else {
                            continue;
                        }
                        break;
                    case 12:
                        LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) function05.invoke(), null);
                        continue;
                    case 13:
                        LogLevel logLevel50 = LogLevel.WARN;
                        LogHandler currentLogHandler38 = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel50) <= 0) {
                            currentLogHandler38.w("[Purchases] - " + logLevel50.name(), (String) function05.invoke());
                        } else {
                            continue;
                        }
                        break;
                    case 14:
                        LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) function05.invoke(), null);
                        continue;
                }
                currentLogHandler.d(str, (String) objInvoke);
            }
            Unit unit3 = Unit.f139807a;
        }
        List listA2 = received.a();
        Intrinsics.checkNotNullExpressionValue(listA2, "received.productDetailsList");
        this.onReceive.invoke(StoreProductConversionsKt.toStoreProducts(listA2));
    }
}
