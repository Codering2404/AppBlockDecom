package com.revenuecat.purchases.google;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.view.View;
import android.view.Window;
import com.android.billingclient.api.BillingClient;
import com.android.billingclient.api.BillingClientStateListener;
import com.android.billingclient.api.BillingConfig;
import com.android.billingclient.api.BillingFlowParams;
import com.android.billingclient.api.BillingResult;
import com.android.billingclient.api.InAppMessageParams;
import com.android.billingclient.api.InAppMessageResponseListener;
import com.android.billingclient.api.InAppMessageResult;
import com.android.billingclient.api.PendingPurchasesParams;
import com.android.billingclient.api.Purchase;
import com.android.billingclient.api.PurchasesUpdatedListener;
import com.applovin.impl.privacy.consentFlow.as.KLAQHFCRAUejH;
import com.bumptech.glide.load.data.Bwyd.SbbqvQlxi;
import com.facebook.share.HKJ.pnxuebdT;
import com.revenuecat.purchases.LogHandler;
import com.revenuecat.purchases.LogLevel;
import com.revenuecat.purchases.NoCoreLibraryDesugaringException;
import com.revenuecat.purchases.PostReceiptInitiationSource;
import com.revenuecat.purchases.PresentedOfferingContext;
import com.revenuecat.purchases.ProductType;
import com.revenuecat.purchases.PurchasesError;
import com.revenuecat.purchases.PurchasesErrorCode;
import com.revenuecat.purchases.PurchasesStateProvider;
import com.revenuecat.purchases.ReplacementMode;
import com.revenuecat.purchases.common.BillingAbstract;
import com.revenuecat.purchases.common.Config;
import com.revenuecat.purchases.common.DateProvider;
import com.revenuecat.purchases.common.DefaultDateProvider;
import com.revenuecat.purchases.common.LogIntent;
import com.revenuecat.purchases.common.LogUtilsKt;
import com.revenuecat.purchases.common.LogWrapperKt;
import com.revenuecat.purchases.common.PurchaseExtensionsKt;
import com.revenuecat.purchases.common.ReplaceProductInfo;
import com.revenuecat.purchases.common.UtilsKt;
import com.revenuecat.purchases.common.caching.DeviceCache;
import com.revenuecat.purchases.common.diagnostics.DiagnosticsTracker;
import com.revenuecat.purchases.google.BillingWrapper;
import com.revenuecat.purchases.google.usecase.AcknowledgePurchaseUseCase;
import com.revenuecat.purchases.google.usecase.AcknowledgePurchaseUseCaseParams;
import com.revenuecat.purchases.google.usecase.BillingClientUseCase;
import com.revenuecat.purchases.google.usecase.ConsumePurchaseUseCase;
import com.revenuecat.purchases.google.usecase.ConsumePurchaseUseCaseParams;
import com.revenuecat.purchases.google.usecase.GetBillingConfigUseCase;
import com.revenuecat.purchases.google.usecase.GetBillingConfigUseCaseParams;
import com.revenuecat.purchases.google.usecase.QueryProductDetailsUseCase;
import com.revenuecat.purchases.google.usecase.QueryProductDetailsUseCaseParams;
import com.revenuecat.purchases.google.usecase.QueryPurchaseHistoryUseCase;
import com.revenuecat.purchases.google.usecase.QueryPurchaseHistoryUseCaseParams;
import com.revenuecat.purchases.google.usecase.QueryPurchasesByTypeUseCase;
import com.revenuecat.purchases.google.usecase.QueryPurchasesByTypeUseCaseParams;
import com.revenuecat.purchases.google.usecase.QueryPurchasesUseCase;
import com.revenuecat.purchases.google.usecase.QueryPurchasesUseCaseParams;
import com.revenuecat.purchases.models.GooglePurchasingData;
import com.revenuecat.purchases.models.GoogleReplacementMode;
import com.revenuecat.purchases.models.InAppMessageType;
import com.revenuecat.purchases.models.PurchaseState;
import com.revenuecat.purchases.models.PurchasingData;
import com.revenuecat.purchases.models.StoreProduct;
import com.revenuecat.purchases.models.StoreReplacementMode;
import com.revenuecat.purchases.models.StoreReplacementModeConversionsKt;
import com.revenuecat.purchases.models.StoreTransaction;
import com.revenuecat.purchases.strings.BillingStrings;
import com.revenuecat.purchases.strings.OfferingStrings;
import com.revenuecat.purchases.strings.PurchaseStrings;
import com.revenuecat.purchases.strings.RestoreStrings;
import com.revenuecat.purchases.utils.Result;
import com.superwall.sdk.billing.BillingClientUseCaseKt;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentLinkedQueue;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.sequences.SequencesKt;

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
public final class BillingWrapper extends BillingAbstract implements PurchasesUpdatedListener, BillingClientStateListener {
    private static final Companion Companion = new Companion(null);
    private static final int MAX_PENDING_REQUEST_COUNT_REPORTED = 100;
    private final Handler backgroundHandler;
    private volatile BillingClient billingClient;
    private final ClientFactory clientFactory;
    private final DateProvider dateProvider;
    private final DeviceCache deviceCache;
    private final DiagnosticsTracker diagnosticsTrackerIfEnabled;
    private final Handler mainHandler;
    private final HandlerThread ownedBackgroundThread;
    private final Map<String, PurchaseContext> purchaseContext;
    private long reconnectMilliseconds;
    private boolean reconnectionAlreadyScheduled;
    private final ConcurrentLinkedQueue<Pair<Function1<PurchasesError, Unit>, Long>> serviceRequests;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class ClientFactory {
        private final Context context;
        private final boolean pendingTransactionsForPrepaidPlansEnabled;

        public ClientFactory(Context context, boolean z2) {
            Intrinsics.checkNotNullParameter(context, "context");
            this.context = context;
            this.pendingTransactionsForPrepaidPlansEnabled = z2;
        }

        public final BillingClient buildClient(PurchasesUpdatedListener listener) {
            Intrinsics.checkNotNullParameter(listener, "listener");
            PendingPurchasesParams.Builder builderB = PendingPurchasesParams.c().b();
            if (this.pendingTransactionsForPrepaidPlansEnabled) {
                builderB.c();
            }
            PendingPurchasesParams pendingPurchasesParamsA = builderB.a();
            Intrinsics.checkNotNullExpressionValue(pendingPurchasesParamsA, "newBuilder()\n           …\n                .build()");
            BillingClient billingClientA = BillingClient.h(this.context).b(pendingPurchasesParamsA).c(listener).a();
            Intrinsics.checkNotNullExpressionValue(billingClientA, "newBuilder(context).enab…\n                .build()");
            return billingClientA;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX INFO: renamed from: com.revenuecat.purchases.google.BillingWrapper$getStorefront$3, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    /* synthetic */ class AnonymousClass3 extends FunctionReferenceImpl implements Function1<Function1<? super BillingClient, ? extends Unit>, Unit> {
        AnonymousClass3(Object obj) {
            super(1, obj, BillingWrapper.class, "withConnectedClient", "withConnectedClient(Lkotlin/jvm/functions/Function1;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((Function1<? super BillingClient, Unit>) obj);
            return Unit.f139807a;
        }

        public final void invoke(Function1<? super BillingClient, Unit> p02) {
            Intrinsics.checkNotNullParameter(p02, "p0");
            ((BillingWrapper) this.receiver).withConnectedClient(p02);
        }
    }

    /* JADX INFO: renamed from: com.revenuecat.purchases.google.BillingWrapper$getStorefront$4, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    /* synthetic */ class AnonymousClass4 extends FunctionReferenceImpl implements Function2<Long, Function1<? super PurchasesError, ? extends Unit>, Unit> {
        AnonymousClass4(Object obj) {
            super(2, obj, BillingWrapper.class, "executeRequestOnUIThread", "executeRequestOnUIThread(Ljava/lang/Long;Lkotlin/jvm/functions/Function1;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            invoke((Long) obj, (Function1<? super PurchasesError, Unit>) obj2);
            return Unit.f139807a;
        }

        public final void invoke(Long l3, Function1<? super PurchasesError, Unit> p12) {
            Intrinsics.checkNotNullParameter(p12, "p1");
            ((BillingWrapper) this.receiver).executeRequestOnUIThread(l3, p12);
        }
    }

    /* JADX INFO: renamed from: com.revenuecat.purchases.google.BillingWrapper$queryPurchaseHistoryAsync$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    /* synthetic */ class C23542 extends FunctionReferenceImpl implements Function1<Function1<? super BillingClient, ? extends Unit>, Unit> {
        C23542(Object obj) {
            super(1, obj, BillingWrapper.class, "withConnectedClient", "withConnectedClient(Lkotlin/jvm/functions/Function1;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((Function1<? super BillingClient, Unit>) obj);
            return Unit.f139807a;
        }

        public final void invoke(Function1<? super BillingClient, Unit> p02) {
            Intrinsics.checkNotNullParameter(p02, "p0");
            ((BillingWrapper) this.receiver).withConnectedClient(p02);
        }
    }

    /* JADX INFO: renamed from: com.revenuecat.purchases.google.BillingWrapper$queryPurchaseHistoryAsync$3, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    /* synthetic */ class C23553 extends FunctionReferenceImpl implements Function2<Long, Function1<? super PurchasesError, ? extends Unit>, Unit> {
        C23553(Object obj) {
            super(2, obj, BillingWrapper.class, "executeRequestOnUIThread", "executeRequestOnUIThread(Ljava/lang/Long;Lkotlin/jvm/functions/Function1;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            invoke((Long) obj, (Function1<? super PurchasesError, Unit>) obj2);
            return Unit.f139807a;
        }

        public final void invoke(Long l3, Function1<? super PurchasesError, Unit> p12) {
            Intrinsics.checkNotNullParameter(p12, "p1");
            ((BillingWrapper) this.receiver).executeRequestOnUIThread(l3, p12);
        }
    }

    /* JADX INFO: renamed from: com.revenuecat.purchases.google.BillingWrapper$queryPurchaseType$3, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    /* synthetic */ class C23583 extends FunctionReferenceImpl implements Function1<Function1<? super BillingClient, ? extends Unit>, Unit> {
        C23583(Object obj) {
            super(1, obj, BillingWrapper.class, "withConnectedClient", "withConnectedClient(Lkotlin/jvm/functions/Function1;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((Function1<? super BillingClient, Unit>) obj);
            return Unit.f139807a;
        }

        public final void invoke(Function1<? super BillingClient, Unit> p02) {
            Intrinsics.checkNotNullParameter(p02, "p0");
            ((BillingWrapper) this.receiver).withConnectedClient(p02);
        }
    }

    /* JADX INFO: renamed from: com.revenuecat.purchases.google.BillingWrapper$queryPurchaseType$4, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    /* synthetic */ class C23594 extends FunctionReferenceImpl implements Function2<Long, Function1<? super PurchasesError, ? extends Unit>, Unit> {
        C23594(Object obj) {
            super(2, obj, BillingWrapper.class, "executeRequestOnUIThread", "executeRequestOnUIThread(Ljava/lang/Long;Lkotlin/jvm/functions/Function1;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            invoke((Long) obj, (Function1<? super PurchasesError, Unit>) obj2);
            return Unit.f139807a;
        }

        public final void invoke(Long l3, Function1<? super PurchasesError, Unit> p12) {
            Intrinsics.checkNotNullParameter(p12, "p1");
            ((BillingWrapper) this.receiver).executeRequestOnUIThread(l3, p12);
        }
    }

    /* JADX INFO: renamed from: com.revenuecat.purchases.google.BillingWrapper$queryPurchases$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    /* synthetic */ class C23602 extends FunctionReferenceImpl implements Function1<Function1<? super BillingClient, ? extends Unit>, Unit> {
        C23602(Object obj) {
            super(1, obj, BillingWrapper.class, "withConnectedClient", "withConnectedClient(Lkotlin/jvm/functions/Function1;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((Function1<? super BillingClient, Unit>) obj);
            return Unit.f139807a;
        }

        public final void invoke(Function1<? super BillingClient, Unit> p02) {
            Intrinsics.checkNotNullParameter(p02, "p0");
            ((BillingWrapper) this.receiver).withConnectedClient(p02);
        }
    }

    /* JADX INFO: renamed from: com.revenuecat.purchases.google.BillingWrapper$queryPurchases$3, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    /* synthetic */ class C23613 extends FunctionReferenceImpl implements Function2<Long, Function1<? super PurchasesError, ? extends Unit>, Unit> {
        C23613(Object obj) {
            super(2, obj, BillingWrapper.class, "executeRequestOnUIThread", "executeRequestOnUIThread(Ljava/lang/Long;Lkotlin/jvm/functions/Function1;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            invoke((Long) obj, (Function1<? super PurchasesError, Unit>) obj2);
            return Unit.f139807a;
        }

        public final void invoke(Long l3, Function1<? super PurchasesError, Unit> p12) {
            Intrinsics.checkNotNullParameter(p12, "p1");
            ((BillingWrapper) this.receiver).executeRequestOnUIThread(l3, p12);
        }
    }

    public /* synthetic */ BillingWrapper(ClientFactory clientFactory, Handler handler, Handler handler2, DeviceCache deviceCache, DiagnosticsTracker diagnosticsTracker, PurchasesStateProvider purchasesStateProvider, DateProvider dateProvider, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(clientFactory, handler, (i3 & 4) != 0 ? null : handler2, deviceCache, diagnosticsTracker, purchasesStateProvider, (i3 & 64) != 0 ? new DefaultDateProvider() : dateProvider);
    }

    private final Result<BillingFlowParams, PurchasesError> buildOneTimePurchaseParams(GooglePurchasingData.InAppProduct inAppProduct, String str, Boolean bool) {
        BillingFlowParams.ProductDetailsParams.Builder builderB = BillingFlowParams.ProductDetailsParams.b();
        builderB.c(inAppProduct.getProductDetails());
        BillingFlowParams.ProductDetailsParams productDetailsParamsA = builderB.a();
        Intrinsics.checkNotNullExpressionValue(productDetailsParamsA, "newBuilder().apply {\n   …etails)\n        }.build()");
        try {
            BillingFlowParams.Builder builderC = BillingFlowParams.b().e(CollectionsKt.listOf(productDetailsParamsA)).c(UtilsKt.sha256(str));
            if (bool != null) {
                builderC.b(bool.booleanValue());
            }
            BillingFlowParams billingFlowParamsA = builderC.a();
            Intrinsics.checkNotNullExpressionValue(billingFlowParamsA, "newBuilder()\n           …                 .build()");
            return new Result.Success(billingFlowParamsA);
        } catch (NoClassDefFoundError e3) {
            throw new NoCoreLibraryDesugaringException(e3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Result<BillingFlowParams, PurchasesError> buildPurchaseParams(GooglePurchasingData googlePurchasingData, ReplaceProductInfo replaceProductInfo, String str, Boolean bool) {
        if (googlePurchasingData instanceof GooglePurchasingData.InAppProduct) {
            return buildOneTimePurchaseParams((GooglePurchasingData.InAppProduct) googlePurchasingData, str, bool);
        }
        if (googlePurchasingData instanceof GooglePurchasingData.Subscription) {
            return buildSubscriptionPurchaseParams((GooglePurchasingData.Subscription) googlePurchasingData, replaceProductInfo, str, bool);
        }
        throw new NoWhenBranchMatchedException();
    }

    private final List<BillingFlowParams.ProductDetailsParams> buildSubscriptionProductDetailsParams(GooglePurchasingData.Subscription subscription) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(buildSubscriptionProductDetailsParams$buildProductDetailParams(subscription));
        List addOnProducts = subscription.getAddOnProducts();
        if (addOnProducts != null) {
            ArrayList arrayList2 = new ArrayList();
            for (Object obj : addOnProducts) {
                if (obj instanceof GooglePurchasingData.Subscription) {
                    arrayList2.add(obj);
                }
            }
            ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList2, 10));
            int size = arrayList2.size();
            int i3 = 0;
            while (i3 < size) {
                Object obj2 = arrayList2.get(i3);
                i3++;
                arrayList3.add(buildSubscriptionProductDetailsParams$buildProductDetailParams((GooglePurchasingData.Subscription) obj2));
            }
            arrayList.addAll(arrayList3);
        }
        return arrayList;
    }

    private static final BillingFlowParams.ProductDetailsParams buildSubscriptionProductDetailsParams$buildProductDetailParams(GooglePurchasingData.Subscription subscription) {
        BillingFlowParams.ProductDetailsParams.Builder builderB = BillingFlowParams.ProductDetailsParams.b();
        builderB.b(subscription.getToken());
        builderB.c(subscription.getProductDetails());
        BillingFlowParams.ProductDetailsParams productDetailsParamsA = builderB.a();
        Intrinsics.checkNotNullExpressionValue(productDetailsParamsA, "newBuilder().apply {\n   …ls)\n            }.build()");
        return productDetailsParamsA;
    }

    private final Result<BillingFlowParams, PurchasesError> buildSubscriptionPurchaseParams(GooglePurchasingData.Subscription subscription, ReplaceProductInfo replaceProductInfo, String str, Boolean bool) {
        try {
            BillingFlowParams.Builder builderE = BillingFlowParams.b().e(buildSubscriptionProductDetailsParams(subscription));
            if (replaceProductInfo != null) {
                Intrinsics.checkNotNullExpressionValue(builderE, "buildSubscriptionPurchas…arams$lambda$64$lambda$62");
                BillingFlowParamsExtensionsKt.setUpgradeInfo(builderE, replaceProductInfo);
                Unit unit = Unit.f139807a;
            } else {
                Intrinsics.checkNotNullExpressionValue(builderE.c(UtilsKt.sha256(str)), "setObfuscatedAccountId(appUserID.sha256())");
            }
            if (bool != null) {
                builderE.b(bool.booleanValue());
            }
            BillingFlowParams billingFlowParamsA = builderE.a();
            Intrinsics.checkNotNullExpressionValue(billingFlowParamsA, "newBuilder()\n           …                 .build()");
            return new Result.Success(billingFlowParamsA);
        } catch (NoClassDefFoundError e3) {
            throw new NoCoreLibraryDesugaringException(e3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void endConnection$lambda$16(BillingWrapper billingWrapper) {
        LogHandler currentLogHandler;
        String str;
        String str2;
        synchronized (billingWrapper) {
            try {
                final BillingClient billingClient = billingWrapper.billingClient;
                if (billingClient != null) {
                    final LogIntent logIntent = LogIntent.DEBUG;
                    Function0<String> function0 = new Function0<String>() { // from class: com.revenuecat.purchases.google.BillingWrapper$endConnection$lambda$16$lambda$15$lambda$14$$inlined$log$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public final String invoke() {
                            StringBuilder sb = new StringBuilder();
                            sb.append(CollectionsKt.joinToString$default(logIntent.getEmojiList(), "", null, null, 0, null, null, 62, null));
                            sb.append(' ');
                            String str3 = String.format(BillingStrings.BILLING_CLIENT_ENDING, Arrays.copyOf(new Object[]{billingClient}, 1));
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
                    billingClient.c();
                }
                billingWrapper.billingClient = null;
                Unit unit = Unit.f139807a;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private final void executePendingRequests() {
        Pair<Function1<PurchasesError, Unit>, Long> pairPoll;
        synchronized (this) {
            while (true) {
                try {
                    BillingClient billingClient = this.billingClient;
                    if (billingClient == null || !billingClient.f() || (pairPoll = this.serviceRequests.poll()) == null) {
                        break;
                    }
                    Intrinsics.checkNotNullExpressionValue(pairPoll, "poll()");
                    final Function1 function1 = (Function1) pairPoll.a();
                    Long l3 = (Long) pairPoll.b();
                    if (l3 != null) {
                        this.mainHandler.postDelayed(new Runnable() { // from class: com.revenuecat.purchases.google.d
                            @Override // java.lang.Runnable
                            public final void run() {
                                function1.invoke(null);
                            }
                        }, l3.longValue());
                    } else {
                        this.mainHandler.post(new Runnable() { // from class: com.revenuecat.purchases.google.e
                            @Override // java.lang.Runnable
                            public final void run() {
                                function1.invoke(null);
                            }
                        });
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            Unit unit = Unit.f139807a;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final synchronized void executeRequestOnUIThread(Long l3, Function1<? super PurchasesError, Unit> function1) {
        try {
            if (getPurchasesUpdatedListener() != null) {
                this.serviceRequests.add(TuplesKt.a(function1, l3));
                BillingClient billingClient = this.billingClient;
                if (billingClient == null || billingClient.f()) {
                    executePendingRequests();
                } else {
                    BillingAbstract.startConnection$default(this, 0L, 1, null);
                }
            } else {
                function1.invoke(new PurchasesError(PurchasesErrorCode.UnknownError, "BillingWrapper is not attached to a listener"));
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    static /* synthetic */ void executeRequestOnUIThread$default(BillingWrapper billingWrapper, Long l3, Function1 function1, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            l3 = null;
        }
        billingWrapper.executeRequestOnUIThread(l3, function1);
    }

    public static /* synthetic */ void getOwnedBackgroundThread$purchases_defaultsBc8Release$annotations() {
    }

    public static /* synthetic */ void getPurchaseContext$purchases_defaultsBc8Release$annotations() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String getStackTrace() {
        StringWriter stringWriter = new StringWriter();
        new Throwable().printStackTrace(new PrintWriter(stringWriter));
        String string = stringWriter.toString();
        Intrinsics.checkNotNullExpressionValue(string, "stringWriter.toString()");
        return string;
    }

    private final void getStoreTransaction(final Purchase purchase, final Function1<? super StoreTransaction, Unit> function1) {
        LogHandler currentLogHandler;
        String str;
        String str2;
        final LogIntent logIntent = LogIntent.DEBUG;
        Function0<String> function0 = new Function0<String>() { // from class: com.revenuecat.purchases.google.BillingWrapper$getStoreTransaction$$inlined$log$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                StringBuilder sb = new StringBuilder();
                sb.append(CollectionsKt.joinToString$default(logIntent.getEmojiList(), "", null, null, 0, null, null, 62, null));
                sb.append(' ');
                String str3 = String.format(BillingStrings.BILLING_WRAPPER_PURCHASES_UPDATED, Arrays.copyOf(new Object[]{PurchaseExtensionsKt.toHumanReadableDescription(purchase)}, 1));
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
        synchronized (this) {
            PurchaseContext purchaseContext = this.purchaseContext.get(PurchaseExtensionsKt.getFirstProductId(purchase));
            if (purchaseContext != null && purchaseContext.getProductType() != null) {
                function1.invoke(StoreTransactionConversionsKt.toStoreTransaction(purchase, purchaseContext));
                return;
            }
            String strF = purchase.f();
            Intrinsics.checkNotNullExpressionValue(strF, "purchase.purchaseToken");
            getPurchaseType$purchases_defaultsBc8Release(strF, new Function1<ProductType, Unit>() { // from class: com.revenuecat.purchases.google.BillingWrapper$getStoreTransaction$2$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke((ProductType) obj);
                    return Unit.f139807a;
                }

                public final void invoke(ProductType type) {
                    Intrinsics.checkNotNullParameter(type, "type");
                    function1.invoke(StoreTransactionConversionsKt.toStoreTransaction$default(purchase, type, null, null, null, null, 30, null));
                }
            });
            Unit unit = Unit.f139807a;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void launchBillingFlow(final Activity activity, final BillingFlowParams billingFlowParams) {
        LogHandler currentLogHandler;
        String str;
        String str2;
        if (activity.getIntent() == null) {
            final LogIntent logIntent = LogIntent.WARNING;
            Function0<String> function0 = new Function0<String>() { // from class: com.revenuecat.purchases.google.BillingWrapper$launchBillingFlow$$inlined$log$1
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return CollectionsKt.joinToString$default(logIntent.getEmojiList(), "", null, null, 0, null, null, 62, null) + ' ' + BillingStrings.NULL_ACTIVITY_INTENT;
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
        }
        withConnectedClient(new Function1<BillingClient, Unit>() { // from class: com.revenuecat.purchases.google.BillingWrapper.launchBillingFlow.2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((BillingClient) obj);
                return Unit.f139807a;
            }

            public final void invoke(BillingClient withConnectedClient) {
                Intrinsics.checkNotNullParameter(withConnectedClient, "$this$withConnectedClient");
                final BillingResult billingResultG = withConnectedClient.g(activity, billingFlowParams);
                if (billingResultG.c() == 0) {
                    billingResultG = null;
                }
                if (billingResultG != null) {
                    final LogIntent logIntent2 = LogIntent.GOOGLE_ERROR;
                    Function0<String> function02 = new Function0<String>() { // from class: com.revenuecat.purchases.google.BillingWrapper$launchBillingFlow$2$invoke$lambda$2$$inlined$log$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public final String invoke() {
                            StringBuilder sb = new StringBuilder();
                            sb.append(CollectionsKt.joinToString$default(logIntent2.getEmojiList(), "", null, null, 0, null, null, 62, null));
                            sb.append(' ');
                            BillingResult billingResult = billingResultG;
                            Intrinsics.checkNotNullExpressionValue(billingResult, "billingResult");
                            String str3 = String.format(BillingStrings.BILLING_INTENT_FAILED, Arrays.copyOf(new Object[]{BillingResultExtensionsBillingIndependentKt.toHumanReadableDescription(billingResultG)}, 1));
                            Intrinsics.checkNotNullExpressionValue(str3, "format(...)");
                            sb.append(str3);
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
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onBillingSetupFinished$lambda$42(final BillingResult billingResult, final BillingWrapper billingWrapper) {
        PurchasesError purchasesErrorBillingResponseToPurchasesError;
        LogHandler currentLogHandler;
        String str;
        String str2;
        int iC = billingResult.c();
        if (iC != 6) {
            if (iC != 7 && iC != 8) {
                if (iC != 12) {
                    switch (iC) {
                        case -2:
                        case 3:
                            String humanReadableDescription = BillingResultExtensionsBillingIndependentKt.toHumanReadableDescription(billingResult);
                            if (Intrinsics.areEqual(billingResult.a(), ErrorsKt.IN_APP_BILLING_LESS_THAN_3_ERROR_MESSAGE)) {
                                String str3 = String.format(BillingStrings.BILLING_UNAVAILABLE_LESS_THAN_3, Arrays.copyOf(new Object[]{humanReadableDescription}, 1));
                                Intrinsics.checkNotNullExpressionValue(str3, "format(...)");
                                purchasesErrorBillingResponseToPurchasesError = new PurchasesError(PurchasesErrorCode.StoreProblemError, str3);
                                LogUtilsKt.errorLog(purchasesErrorBillingResponseToPurchasesError);
                            } else {
                                String str4 = String.format(BillingStrings.BILLING_UNAVAILABLE, Arrays.copyOf(new Object[]{humanReadableDescription}, 1));
                                Intrinsics.checkNotNullExpressionValue(str4, "format(...)");
                                purchasesErrorBillingResponseToPurchasesError = ErrorsKt.billingResponseToPurchasesError(billingResult.c(), str4);
                                LogUtilsKt.errorLog(purchasesErrorBillingResponseToPurchasesError);
                            }
                            billingWrapper.sendErrorsToAllPendingRequests(purchasesErrorBillingResponseToPurchasesError);
                            break;
                        case 0:
                            final LogIntent logIntent = LogIntent.DEBUG;
                            Function0<String> function0 = new Function0<String>() { // from class: com.revenuecat.purchases.google.BillingWrapper$onBillingSetupFinished$lambda$42$$inlined$log$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(0);
                                }

                                @Override // kotlin.jvm.functions.Function0
                                public final String invoke() {
                                    StringBuilder sb = new StringBuilder();
                                    sb.append(CollectionsKt.joinToString$default(logIntent.getEmojiList(), "", null, null, 0, null, null, 62, null));
                                    sb.append(' ');
                                    BillingClient billingClient = billingWrapper.getBillingClient();
                                    String str5 = String.format(BillingStrings.BILLING_SERVICE_SETUP_FINISHED, Arrays.copyOf(new Object[]{billingClient != null ? billingClient.toString() : null}, 1));
                                    Intrinsics.checkNotNullExpressionValue(str5, "format(...)");
                                    sb.append(str5);
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
                            BillingAbstract.StateListener stateListener = billingWrapper.getStateListener();
                            if (stateListener != null) {
                                stateListener.onConnected();
                                Unit unit = Unit.f139807a;
                            }
                            billingWrapper.executePendingRequests();
                            billingWrapper.reconnectMilliseconds = 1000L;
                            billingWrapper.trackProductDetailsNotSupportedIfNeeded();
                            break;
                    }
                    return;
                }
            }
            final LogIntent logIntent2 = LogIntent.GOOGLE_WARNING;
            Function0<String> function02 = new Function0<String>() { // from class: com.revenuecat.purchases.google.BillingWrapper$onBillingSetupFinished$lambda$42$$inlined$log$3
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    StringBuilder sb = new StringBuilder();
                    sb.append(CollectionsKt.joinToString$default(logIntent2.getEmojiList(), SbbqvQlxi.QpQfwOuV, null, null, 0, null, null, 62, null));
                    sb.append(' ');
                    String str5 = String.format(BillingStrings.BILLING_CLIENT_ERROR, Arrays.copyOf(new Object[]{BillingResultExtensionsBillingIndependentKt.toHumanReadableDescription(billingResult)}, 1));
                    Intrinsics.checkNotNullExpressionValue(str5, "format(...)");
                    sb.append(str5);
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
            return;
        }
        final LogIntent logIntent3 = LogIntent.GOOGLE_WARNING;
        Function0<String> function03 = new Function0<String>() { // from class: com.revenuecat.purchases.google.BillingWrapper$onBillingSetupFinished$lambda$42$$inlined$log$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                StringBuilder sb = new StringBuilder();
                sb.append(CollectionsKt.joinToString$default(logIntent3.getEmojiList(), "", null, null, 0, null, null, 62, null));
                sb.append(' ');
                String str5 = String.format(BillingStrings.BILLING_CLIENT_ERROR, Arrays.copyOf(new Object[]{BillingResultExtensionsBillingIndependentKt.toHumanReadableDescription(billingResult)}, 1));
                Intrinsics.checkNotNullExpressionValue(str5, "format(...)");
                sb.append(str5);
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
        billingWrapper.retryBillingServiceConnectionWithExponentialBackoff();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0020  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void performStartConnection() {
        /*
            Method dump skipped, instruction units count: 1348
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.revenuecat.purchases.google.BillingWrapper.performStartConnection():void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void performStartConnection$lambda$12(Throwable th) throws Throwable {
        throw th;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void queryPurchaseType(String str, final String str2, final Function1<? super ProductType, Unit> function1, final Function1<? super Boolean, Unit> function12) {
        BillingClientUseCase.run$default(new QueryPurchasesByTypeUseCase(new QueryPurchasesByTypeUseCaseParams(this.dateProvider, this.diagnosticsTrackerIfEnabled, getAppInBackground(), str), new Function1<Map<String, ? extends StoreTransaction>, Unit>() { // from class: com.revenuecat.purchases.google.BillingWrapper.queryPurchaseType.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            public final void invoke(Map<String, StoreTransaction> purchases) {
                Intrinsics.checkNotNullParameter(purchases, "purchases");
                Function1<Boolean, Unit> function13 = function12;
                Collection<StoreTransaction> collectionValues = purchases.values();
                String str3 = str2;
                boolean z2 = false;
                if (!(collectionValues instanceof Collection) || !collectionValues.isEmpty()) {
                    Iterator<T> it = collectionValues.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        } else if (Intrinsics.areEqual(((StoreTransaction) it.next()).getPurchaseToken(), str3)) {
                            z2 = true;
                            break;
                        }
                    }
                }
                function13.invoke(Boolean.valueOf(z2));
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Map<String, StoreTransaction>) obj);
                return Unit.f139807a;
            }
        }, new Function1<PurchasesError, Unit>() { // from class: com.revenuecat.purchases.google.BillingWrapper.queryPurchaseType.2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            public final void invoke(PurchasesError error) {
                Intrinsics.checkNotNullParameter(error, "error");
                LogUtilsKt.errorLog(error);
                function1.invoke(ProductType.UNKNOWN);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((PurchasesError) obj);
                return Unit.f139807a;
            }
        }, new C23583(this), new C23594(this)), 0L, 1, null);
    }

    private final void retryBillingServiceConnectionWithExponentialBackoff() {
        if (this.reconnectionAlreadyScheduled) {
            final LogIntent logIntent = LogIntent.WARNING;
            Function0<String> function0 = new Function0<String>() { // from class: com.revenuecat.purchases.google.BillingWrapper$retryBillingServiceConnectionWithExponentialBackoff$$inlined$log$1
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return CollectionsKt.joinToString$default(logIntent.getEmojiList(), "", null, null, 0, null, null, 62, null) + ' ' + BillingStrings.BILLING_CLIENT_RETRY_ALREADY_SCHEDULED;
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
            return;
        }
        final LogIntent logIntent2 = LogIntent.WARNING;
        Function0<String> function02 = new Function0<String>() { // from class: com.revenuecat.purchases.google.BillingWrapper$retryBillingServiceConnectionWithExponentialBackoff$$inlined$log$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                StringBuilder sb = new StringBuilder();
                sb.append(CollectionsKt.joinToString$default(logIntent2.getEmojiList(), "", null, null, 0, null, null, 62, null));
                sb.append(' ');
                String str = String.format(BillingStrings.BILLING_CLIENT_RETRY, Arrays.copyOf(new Object[]{Long.valueOf(this.reconnectMilliseconds)}, 1));
                Intrinsics.checkNotNullExpressionValue(str, "format(...)");
                sb.append(str);
                return sb.toString();
            }
        };
        switch (LogWrapperKt.WhenMappings.$EnumSwitchMapping$0[logIntent2.ordinal()]) {
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
        this.reconnectionAlreadyScheduled = true;
        startConnection(this.reconnectMilliseconds);
        this.reconnectMilliseconds = Math.min(this.reconnectMilliseconds * ((long) 2), BillingClientUseCaseKt.RETRY_TIMER_MAX_TIME_MILLISECONDS);
    }

    private final synchronized void sendErrorsToAllPendingRequests(final PurchasesError purchasesError) {
        while (true) {
            Pair<Function1<PurchasesError, Unit>, Long> pairPoll = this.serviceRequests.poll();
            if (pairPoll != null) {
                final Function1 function1 = (Function1) pairPoll.a();
                this.mainHandler.post(new Runnable() { // from class: com.revenuecat.purchases.google.g
                    @Override // java.lang.Runnable
                    public final void run() {
                        function1.invoke(purchasesError);
                    }
                });
            }
        }
    }

    private final void trackProductDetailsNotSupportedIfNeeded() {
        if (this.diagnosticsTrackerIfEnabled == null) {
            return;
        }
        BillingClient billingClient = this.billingClient;
        BillingResult billingResultE = billingClient != null ? billingClient.e("fff") : null;
        if (billingResultE == null || billingResultE.c() != -2) {
            return;
        }
        DiagnosticsTracker diagnosticsTracker = this.diagnosticsTrackerIfEnabled;
        int iC = billingResultE.c();
        String strA = billingResultE.a();
        Intrinsics.checkNotNullExpressionValue(strA, "billingResult.debugMessage");
        diagnosticsTracker.trackProductDetailsNotSupported(iC, strA);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0052  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void trackPurchaseStartIfNeeded(com.revenuecat.purchases.models.GooglePurchasingData r10, java.lang.String r11) {
        /*
            Method dump skipped, instruction units count: 201
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.revenuecat.purchases.google.BillingWrapper.trackPurchaseStartIfNeeded(com.revenuecat.purchases.models.GooglePurchasingData, java.lang.String):void");
    }

    private final void trackPurchaseUpdateReceivedIfNeeded(BillingResult billingResult, List<? extends Purchase> list) {
        ArrayList arrayList;
        DiagnosticsTracker diagnosticsTracker = this.diagnosticsTrackerIfEnabled;
        if (diagnosticsTracker == null) {
            return;
        }
        ArrayList arrayList2 = null;
        if (list != null) {
            arrayList = new ArrayList();
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                List listC = ((Purchase) it.next()).c();
                Intrinsics.checkNotNullExpressionValue(listC, "it.products");
                CollectionsKt.addAll(arrayList, listC);
            }
        } else {
            arrayList = null;
        }
        if (list != null) {
            List<? extends Purchase> list2 = list;
            arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
            Iterator<T> it2 = list2.iterator();
            while (it2.hasNext()) {
                arrayList2.add(PurchaseStateConversionsKt.toRevenueCatPurchaseState(((Purchase) it2.next()).d()).name());
            }
        }
        int iC = billingResult.c();
        String strA = billingResult.a();
        Intrinsics.checkNotNullExpressionValue(strA, "billingResult.debugMessage");
        diagnosticsTracker.trackGooglePurchaseUpdateReceived(arrayList, arrayList2, iC, strA);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0015  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void withConnectedClient(kotlin.jvm.functions.Function1<? super com.android.billingclient.api.BillingClient, kotlin.Unit> r5) {
        /*
            Method dump skipped, instruction units count: 606
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.revenuecat.purchases.google.BillingWrapper.withConnectedClient(kotlin.jvm.functions.Function1):void");
    }

    public final void acknowledge$purchases_defaultsBc8Release(final String token, PostReceiptInitiationSource initiationSource, Function1<? super String, Unit> onAcknowledged) {
        LogHandler currentLogHandler;
        String str;
        String str2;
        Intrinsics.checkNotNullParameter(token, "token");
        Intrinsics.checkNotNullParameter(initiationSource, "initiationSource");
        Intrinsics.checkNotNullParameter(onAcknowledged, "onAcknowledged");
        final LogIntent logIntent = LogIntent.PURCHASE;
        Function0<String> function0 = new Function0<String>() { // from class: com.revenuecat.purchases.google.BillingWrapper$acknowledge$$inlined$log$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                StringBuilder sb = new StringBuilder();
                sb.append(CollectionsKt.joinToString$default(logIntent.getEmojiList(), "", null, null, 0, null, null, 62, null));
                sb.append(' ');
                String str3 = String.format(PurchaseStrings.ACKNOWLEDGING_PURCHASE, Arrays.copyOf(new Object[]{token}, 1));
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
        BillingClientUseCase.run$default(new AcknowledgePurchaseUseCase(new AcknowledgePurchaseUseCaseParams(token, initiationSource, getAppInBackground()), onAcknowledged, new Function1<PurchasesError, Unit>() { // from class: com.revenuecat.purchases.google.BillingWrapper$acknowledge$2
            public final void invoke(PurchasesError purchasesError) {
                Intrinsics.checkNotNullParameter(purchasesError, "<anonymous parameter 0>");
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((PurchasesError) obj);
                return Unit.f139807a;
            }
        }, new BillingWrapper$acknowledge$3(this), new BillingWrapper$acknowledge$4(this)), 0L, 1, null);
    }

    @Override // com.revenuecat.purchases.common.BillingAbstract
    public void close() {
        super.close();
        HandlerThread handlerThread = this.ownedBackgroundThread;
        if (handlerThread != null) {
            handlerThread.quitSafely();
        }
    }

    @Override // com.revenuecat.purchases.common.BillingAbstract
    public void consumeAndSave(boolean z2, final StoreTransaction purchase, boolean z3, PostReceiptInitiationSource initiationSource) {
        LogHandler currentLogHandler;
        String str;
        String str2;
        Intrinsics.checkNotNullParameter(purchase, "purchase");
        Intrinsics.checkNotNullParameter(initiationSource, "initiationSource");
        if (purchase.getType() == ProductType.UNKNOWN || purchase.getPurchaseState() == PurchaseState.PENDING) {
            return;
        }
        Purchase originalGooglePurchase = StoreTransactionConversionsKt.getOriginalGooglePurchase(purchase);
        boolean zH = originalGooglePurchase != null ? originalGooglePurchase.h() : false;
        boolean z4 = purchase.getType() == ProductType.INAPP;
        Function1<String, Unit> function1 = new Function1<String, Unit>() { // from class: com.revenuecat.purchases.google.BillingWrapper$consumeAndSave$addToken$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((String) obj);
                return Unit.f139807a;
            }

            public final void invoke(String token) {
                Intrinsics.checkNotNullParameter(token, "token");
                this.this$0.deviceCache.addSuccessfullyPostedToken(token, purchase.isAutoRenewing());
            }
        };
        if (!z4) {
            if (!z2 || zH) {
                function1.invoke(purchase.getPurchaseToken());
                return;
            } else {
                acknowledge$purchases_defaultsBc8Release(purchase.getPurchaseToken(), initiationSource, function1);
                return;
            }
        }
        if (z2 && z3) {
            consumePurchase$purchases_defaultsBc8Release(purchase.getPurchaseToken(), initiationSource, function1);
            return;
        }
        if (!z2 || zH) {
            function1.invoke(purchase.getPurchaseToken());
            return;
        }
        final LogIntent logIntent = LogIntent.PURCHASE;
        Function0<String> function0 = new Function0<String>() { // from class: com.revenuecat.purchases.google.BillingWrapper$consumeAndSave$$inlined$log$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                return CollectionsKt.joinToString$default(logIntent.getEmojiList(), "", null, null, 0, null, null, 62, null) + ' ' + PurchaseStrings.NOT_CONSUMING_IN_APP_PURCHASE_ACCORDING_TO_BACKEND;
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
        acknowledge$purchases_defaultsBc8Release(purchase.getPurchaseToken(), initiationSource, function1);
    }

    public final void consumePurchase$purchases_defaultsBc8Release(final String token, PostReceiptInitiationSource initiationSource, Function1<? super String, Unit> onConsumed) {
        LogHandler currentLogHandler;
        String str;
        String str2;
        Intrinsics.checkNotNullParameter(token, "token");
        Intrinsics.checkNotNullParameter(initiationSource, "initiationSource");
        Intrinsics.checkNotNullParameter(onConsumed, "onConsumed");
        final LogIntent logIntent = LogIntent.PURCHASE;
        Function0<String> function0 = new Function0<String>() { // from class: com.revenuecat.purchases.google.BillingWrapper$consumePurchase$$inlined$log$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                StringBuilder sb = new StringBuilder();
                sb.append(CollectionsKt.joinToString$default(logIntent.getEmojiList(), "", null, null, 0, null, null, 62, null));
                sb.append(' ');
                String str3 = String.format(PurchaseStrings.CONSUMING_PURCHASE, Arrays.copyOf(new Object[]{token}, 1));
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
        BillingClientUseCase.run$default(new ConsumePurchaseUseCase(new ConsumePurchaseUseCaseParams(token, initiationSource, getAppInBackground()), onConsumed, new Function1<PurchasesError, Unit>() { // from class: com.revenuecat.purchases.google.BillingWrapper$consumePurchase$2
            public final void invoke(PurchasesError purchasesError) {
                Intrinsics.checkNotNullParameter(purchasesError, "<anonymous parameter 0>");
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((PurchasesError) obj);
                return Unit.f139807a;
            }
        }, new BillingWrapper$consumePurchase$3(this), new BillingWrapper$consumePurchase$4(this)), 0L, 1, null);
    }

    @Override // com.revenuecat.purchases.common.BillingAbstract
    protected void endConnection() {
        this.backgroundHandler.post(new Runnable() { // from class: com.revenuecat.purchases.google.f
            @Override // java.lang.Runnable
            public final void run() {
                BillingWrapper.endConnection$lambda$16(this.f92277a);
            }
        });
    }

    @Override // com.revenuecat.purchases.common.BillingAbstract
    public void findPurchaseInPurchaseHistory(String appUserID, final ProductType productType, final String productId, final Function1<? super StoreTransaction, Unit> onCompletion, final Function1<? super PurchasesError, Unit> onError) {
        Function1<? super PurchasesError, Unit> function1;
        LogHandler currentLogHandler;
        String str;
        String str2;
        Intrinsics.checkNotNullParameter(appUserID, "appUserID");
        Intrinsics.checkNotNullParameter(productType, "productType");
        Intrinsics.checkNotNullParameter(productId, "productId");
        Intrinsics.checkNotNullParameter(onCompletion, "onCompletion");
        Intrinsics.checkNotNullParameter(onError, "onError");
        final LogIntent logIntent = LogIntent.DEBUG;
        Function0<String> function0 = new Function0<String>() { // from class: com.revenuecat.purchases.google.BillingWrapper$findPurchaseInPurchaseHistory$$inlined$log$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                StringBuilder sb = new StringBuilder();
                sb.append(CollectionsKt.joinToString$default(logIntent.getEmojiList(), "", null, null, 0, null, null, 62, null));
                sb.append(' ');
                String str3 = String.format(RestoreStrings.QUERYING_PURCHASE_WITH_TYPE, Arrays.copyOf(new Object[]{productId, productType.name()}, 2));
                Intrinsics.checkNotNullExpressionValue(str3, "format(...)");
                sb.append(str3);
                return sb.toString();
            }
        };
        Unit unit = null;
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
        String googleProductType = ProductTypeConversionsKt.toGoogleProductType(productType);
        if (googleProductType != null) {
            function1 = onError;
            BillingClientUseCase.run$default(new QueryPurchaseHistoryUseCase(new QueryPurchaseHistoryUseCaseParams(this.dateProvider, this.diagnosticsTrackerIfEnabled, googleProductType, getAppInBackground()), new Function1<List<? extends StoreTransaction>, Unit>() { // from class: com.revenuecat.purchases.google.BillingWrapper$findPurchaseInPurchaseHistory$2$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(1);
                }

                public final void invoke(List<StoreTransaction> purchasesList) {
                    Object next;
                    Intrinsics.checkNotNullParameter(purchasesList, "purchasesList");
                    String str3 = productId;
                    Iterator<T> it = purchasesList.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            next = null;
                            break;
                        } else {
                            next = it.next();
                            if (((StoreTransaction) next).getProductIds().contains(str3)) {
                                break;
                            }
                        }
                    }
                    StoreTransaction storeTransaction = (StoreTransaction) next;
                    if (storeTransaction != null) {
                        onCompletion.invoke(storeTransaction);
                        return;
                    }
                    String str4 = String.format(PurchaseStrings.NO_EXISTING_PURCHASE, Arrays.copyOf(new Object[]{productId}, 1));
                    Intrinsics.checkNotNullExpressionValue(str4, "format(...)");
                    onError.invoke(new PurchasesError(PurchasesErrorCode.PurchaseInvalidError, str4));
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke((List<StoreTransaction>) obj);
                    return Unit.f139807a;
                }
            }, function1, new BillingWrapper$findPurchaseInPurchaseHistory$2$2(this), new BillingWrapper$findPurchaseInPurchaseHistory$2$3(this)), 0L, 1, null);
            unit = Unit.f139807a;
        } else {
            function1 = onError;
        }
        if (unit == null) {
            function1.invoke(new PurchasesError(PurchasesErrorCode.PurchaseInvalidError, PurchaseStrings.NOT_RECOGNIZED_PRODUCT_TYPE));
        }
    }

    public final boolean getAppInBackground() {
        return getPurchasesStateProvider().getPurchasesState().getAppInBackground();
    }

    public final synchronized BillingClient getBillingClient() {
        return this.billingClient;
    }

    public final HandlerThread getOwnedBackgroundThread$purchases_defaultsBc8Release() {
        return this.ownedBackgroundThread;
    }

    public final Map<String, PurchaseContext> getPurchaseContext$purchases_defaultsBc8Release() {
        return this.purchaseContext;
    }

    @Override // com.revenuecat.purchases.common.BillingAbstract
    public void getStorefront(final Function1<? super String, Unit> onSuccess, Function1<? super PurchasesError, Unit> onError) {
        Intrinsics.checkNotNullParameter(onSuccess, "onSuccess");
        Intrinsics.checkNotNullParameter(onError, "onError");
        LogLevel logLevel = LogLevel.VERBOSE;
        LogHandler currentLogHandler = LogWrapperKt.getCurrentLogHandler();
        if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
            currentLogHandler.v("[Purchases] - " + logLevel.name(), BillingStrings.BILLING_INITIATE_GETTING_COUNTRY_CODE);
        }
        BillingClientUseCase.run$default(new GetBillingConfigUseCase(new GetBillingConfigUseCaseParams(getAppInBackground()), this.deviceCache, new Function1<BillingConfig, Unit>() { // from class: com.revenuecat.purchases.google.BillingWrapper.getStorefront.2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            public final void invoke(BillingConfig billingConfig) {
                Intrinsics.checkNotNullParameter(billingConfig, "billingConfig");
                Function1<String, Unit> function1 = onSuccess;
                String strA = billingConfig.a();
                Intrinsics.checkNotNullExpressionValue(strA, "billingConfig.countryCode");
                function1.invoke(strA);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((BillingConfig) obj);
                return Unit.f139807a;
            }
        }, onError, new AnonymousClass3(this), new AnonymousClass4(this)), 0L, 1, null);
    }

    @Override // com.revenuecat.purchases.common.BillingAbstract
    public boolean isConnected() {
        BillingClient billingClient = this.billingClient;
        if (billingClient != null) {
            return billingClient.f();
        }
        return false;
    }

    @Override // com.revenuecat.purchases.common.BillingAbstract
    public void makePurchaseAsync(final Activity activity, final String appUserID, final PurchasingData purchasingData, final ReplaceProductInfo replaceProductInfo, PresentedOfferingContext presentedOfferingContext, final Boolean bool) {
        String optionId;
        ReplacementMode replacementMode;
        String productId;
        List addOnProducts;
        LogHandler currentLogHandler;
        String str;
        String str2;
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(appUserID, "appUserID");
        Intrinsics.checkNotNullParameter(purchasingData, "purchasingData");
        final GooglePurchasingData googlePurchasingData = purchasingData instanceof GooglePurchasingData ? (GooglePurchasingData) purchasingData : null;
        if (googlePurchasingData == null) {
            PurchasesErrorCode purchasesErrorCode = PurchasesErrorCode.UnknownError;
            String str3 = String.format(PurchaseStrings.INVALID_PURCHASE_TYPE, Arrays.copyOf(new Object[]{"Play", "GooglePurchasingData"}, 2));
            Intrinsics.checkNotNullExpressionValue(str3, "format(...)");
            PurchasesError purchasesError = new PurchasesError(purchasesErrorCode, str3);
            LogUtilsKt.errorLog(purchasesError);
            BillingAbstract.PurchasesUpdatedListener purchasesUpdatedListener = getPurchasesUpdatedListener();
            if (purchasesUpdatedListener != null) {
                purchasesUpdatedListener.onPurchasesFailedToUpdate(purchasesError);
                Unit unit = Unit.f139807a;
                return;
            }
            return;
        }
        if (googlePurchasingData instanceof GooglePurchasingData.InAppProduct) {
            optionId = null;
        } else {
            if (!(googlePurchasingData instanceof GooglePurchasingData.Subscription)) {
                throw new NoWhenBranchMatchedException();
            }
            optionId = ((GooglePurchasingData.Subscription) googlePurchasingData).getOptionId();
        }
        if (replaceProductInfo == null) {
            final LogIntent logIntent = LogIntent.PURCHASE;
            Function0<String> function0 = new Function0<String>() { // from class: com.revenuecat.purchases.google.BillingWrapper$makePurchaseAsync$$inlined$log$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    StringBuilder sb = new StringBuilder();
                    sb.append(CollectionsKt.joinToString$default(logIntent.getEmojiList(), "", null, null, 0, null, null, 62, null));
                    sb.append(' ');
                    String str4 = String.format(PurchaseStrings.PURCHASING_PRODUCT, Arrays.copyOf(new Object[]{googlePurchasingData.getProductId()}, 1));
                    Intrinsics.checkNotNullExpressionValue(str4, "format(...)");
                    sb.append(str4);
                    return sb.toString();
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
        } else {
            final LogIntent logIntent2 = LogIntent.PURCHASE;
            Function0<String> function02 = new Function0<String>() { // from class: com.revenuecat.purchases.google.BillingWrapper$makePurchaseAsync$$inlined$log$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    StringBuilder sb = new StringBuilder();
                    sb.append(CollectionsKt.joinToString$default(logIntent2.getEmojiList(), "", null, null, 0, null, null, 62, null));
                    sb.append(' ');
                    String str4 = String.format(PurchaseStrings.UPGRADING_SKU, Arrays.copyOf(new Object[]{replaceProductInfo.getOldPurchase().getProductIds().get(0), googlePurchasingData.getProductId()}, 2));
                    Intrinsics.checkNotNullExpressionValue(str4, "format(...)");
                    sb.append(str4);
                    return sb.toString();
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
        }
        synchronized (this) {
            if (replaceProductInfo != null) {
                try {
                    replacementMode = replaceProductInfo.getReplacementMode();
                } catch (Throwable th) {
                    throw th;
                }
            } else {
                replacementMode = null;
            }
            if (!Intrinsics.areEqual(replacementMode, StoreReplacementMode.DEFERRED)) {
                productId = (replaceProductInfo != null ? replaceProductInfo.getReplacementMode() : null) == GoogleReplacementMode.DEFERRED ? (String) CollectionsKt.first((List) replaceProductInfo.getOldPurchase().getProductIds()) : googlePurchasingData.getProductId();
            }
            Map mapCreateMapBuilder = MapsKt.createMapBuilder();
            if (optionId != null) {
            }
            GooglePurchasingData.Subscription subscription = googlePurchasingData instanceof GooglePurchasingData.Subscription ? (GooglePurchasingData.Subscription) googlePurchasingData : null;
            if (subscription != null && (addOnProducts = subscription.getAddOnProducts()) != null) {
                ArrayList arrayList = new ArrayList();
                for (Object obj : addOnProducts) {
                    if (obj instanceof GooglePurchasingData.Subscription) {
                        arrayList.add(obj);
                    }
                }
                int size = arrayList.size();
                int i3 = 0;
                while (i3 < size) {
                    Object obj2 = arrayList.get(i3);
                    i3++;
                    GooglePurchasingData.Subscription subscription2 = (GooglePurchasingData.Subscription) obj2;
                    mapCreateMapBuilder.put(subscription2.getProductId(), subscription2.getOptionId());
                }
                Unit unit2 = Unit.f139807a;
            }
            this.purchaseContext.put(productId, new PurchaseContext(googlePurchasingData.getProductType(), presentedOfferingContext, optionId, StoreReplacementModeConversionsKt.toStoreReplacementModeOrNull(replaceProductInfo != null ? replaceProductInfo.getReplacementMode() : null), MapsKt.build(mapCreateMapBuilder)));
            Unit unit3 = Unit.f139807a;
        }
        executeRequestOnUIThread$default(this, null, new Function1<PurchasesError, Unit>() { // from class: com.revenuecat.purchases.google.BillingWrapper.makePurchaseAsync.4
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj3) {
                invoke((PurchasesError) obj3);
                return Unit.f139807a;
            }

            public final void invoke(PurchasesError purchasesError2) {
                BillingAbstract.PurchasesUpdatedListener purchasesUpdatedListener2;
                StoreTransaction oldPurchase;
                List<String> productIds;
                Result resultBuildPurchaseParams = BillingWrapper.this.buildPurchaseParams((GooglePurchasingData) purchasingData, replaceProductInfo, appUserID, bool);
                if (!(resultBuildPurchaseParams instanceof Result.Success)) {
                    if (!(resultBuildPurchaseParams instanceof Result.Error) || (purchasesUpdatedListener2 = BillingWrapper.this.getPurchasesUpdatedListener()) == null) {
                        return;
                    }
                    purchasesUpdatedListener2.onPurchasesFailedToUpdate((PurchasesError) ((Result.Error) resultBuildPurchaseParams).getValue());
                    return;
                }
                BillingWrapper billingWrapper = BillingWrapper.this;
                GooglePurchasingData googlePurchasingData2 = googlePurchasingData;
                ReplaceProductInfo replaceProductInfo2 = replaceProductInfo;
                billingWrapper.trackPurchaseStartIfNeeded(googlePurchasingData2, (replaceProductInfo2 == null || (oldPurchase = replaceProductInfo2.getOldPurchase()) == null || (productIds = oldPurchase.getProductIds()) == null) ? null : (String) CollectionsKt.firstOrNull((List) productIds));
                BillingWrapper.this.launchBillingFlow(activity, (BillingFlowParams) ((Result.Success) resultBuildPurchaseParams).getValue());
            }
        }, 1, null);
    }

    @Override // com.android.billingclient.api.BillingClientStateListener
    public void onBillingServiceDisconnected() {
        LogHandler currentLogHandler;
        String str;
        String str2;
        final LogIntent logIntent = LogIntent.WARNING;
        Function0<String> function0 = new Function0<String>() { // from class: com.revenuecat.purchases.google.BillingWrapper$onBillingServiceDisconnected$$inlined$log$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                StringBuilder sb = new StringBuilder();
                sb.append(CollectionsKt.joinToString$default(logIntent.getEmojiList(), "", null, null, 0, null, null, 62, null));
                sb.append(' ');
                BillingClient billingClient = this.getBillingClient();
                String str3 = String.format(BillingStrings.BILLING_SERVICE_DISCONNECTED_INSTANCE, Arrays.copyOf(new Object[]{billingClient != null ? billingClient.toString() : null}, 1));
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
        DiagnosticsTracker diagnosticsTracker = this.diagnosticsTrackerIfEnabled;
        if (diagnosticsTracker != null) {
            diagnosticsTracker.trackGoogleBillingServiceDisconnected();
        }
    }

    @Override // com.android.billingclient.api.BillingClientStateListener
    public void onBillingSetupFinished(final BillingResult billingResult) {
        Intrinsics.checkNotNullParameter(billingResult, "billingResult");
        DiagnosticsTracker diagnosticsTracker = this.diagnosticsTrackerIfEnabled;
        if (diagnosticsTracker != null) {
            int iC = billingResult.c();
            String strA = billingResult.a();
            Intrinsics.checkNotNullExpressionValue(strA, "billingResult.debugMessage");
            diagnosticsTracker.trackGoogleBillingSetupFinished(iC, strA, SequencesKt.s(SequencesKt.P(CollectionsKt.asSequence(this.serviceRequests), 100)));
        }
        this.mainHandler.post(new Runnable() { // from class: com.revenuecat.purchases.google.c
            @Override // java.lang.Runnable
            public final void run() {
                BillingWrapper.onBillingSetupFinished$lambda$42(billingResult, this);
            }
        });
    }

    @Override // com.android.billingclient.api.PurchasesUpdatedListener
    public void onPurchasesUpdated(final BillingResult billingResult, List<? extends Purchase> list) {
        LogHandler currentLogHandler;
        String str;
        String str2;
        Intrinsics.checkNotNullParameter(billingResult, "billingResult");
        trackPurchaseUpdateReceivedIfNeeded(billingResult, list);
        final List<? extends Purchase> listEmptyList = list == null ? CollectionsKt.emptyList() : list;
        if (billingResult.c() == 0 && !listEmptyList.isEmpty()) {
            final ArrayList arrayList = new ArrayList();
            Iterator<T> it = listEmptyList.iterator();
            while (it.hasNext()) {
                getStoreTransaction((Purchase) it.next(), new Function1<StoreTransaction, Unit>() { // from class: com.revenuecat.purchases.google.BillingWrapper$onPurchasesUpdated$1$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        invoke((StoreTransaction) obj);
                        return Unit.f139807a;
                    }

                    public final void invoke(StoreTransaction storeTxn) {
                        BillingAbstract.PurchasesUpdatedListener purchasesUpdatedListener;
                        Intrinsics.checkNotNullParameter(storeTxn, "storeTxn");
                        arrayList.add(storeTxn);
                        if (arrayList.size() != listEmptyList.size() || (purchasesUpdatedListener = this.getPurchasesUpdatedListener()) == null) {
                            return;
                        }
                        purchasesUpdatedListener.onPurchasesUpdated(arrayList);
                    }
                });
            }
            return;
        }
        final LogIntent logIntent = LogIntent.GOOGLE_ERROR;
        Function0<String> function0 = new Function0<String>() { // from class: com.revenuecat.purchases.google.BillingWrapper$onPurchasesUpdated$$inlined$log$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Removed duplicated region for block: B:9:0x0077  */
            @Override // kotlin.jvm.functions.Function0
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public final java.lang.String invoke() {
                /*
                    r14 = this;
                    java.lang.StringBuilder r0 = new java.lang.StringBuilder
                    r0.<init>()
                    com.revenuecat.purchases.common.LogIntent r1 = r1
                    java.util.List r1 = r1.getEmojiList()
                    r2 = r1
                    java.lang.Iterable r2 = (java.lang.Iterable) r2
                    r9 = 62
                    r10 = 0
                    java.lang.String r3 = ""
                    r4 = 0
                    r5 = 0
                    r6 = 0
                    r7 = 0
                    r8 = 0
                    java.lang.String r1 = kotlin.collections.CollectionsKt.joinToString$default(r2, r3, r4, r5, r6, r7, r8, r9, r10)
                    r0.append(r1)
                    r1 = 32
                    r0.append(r1)
                    java.lang.StringBuilder r1 = new java.lang.StringBuilder
                    r1.<init>()
                    com.android.billingclient.api.BillingResult r2 = r2
                    java.lang.String r2 = com.revenuecat.purchases.google.BillingResultExtensionsBillingIndependentKt.toHumanReadableDescription(r2)
                    java.lang.Object[] r2 = new java.lang.Object[]{r2}
                    r3 = 1
                    java.lang.Object[] r2 = java.util.Arrays.copyOf(r2, r3)
                    java.lang.String r3 = "BillingWrapper purchases failed to update: %s"
                    java.lang.String r2 = java.lang.String.format(r3, r2)
                    java.lang.String r3 = "format(...)"
                    kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r3)
                    r1.append(r2)
                    java.util.List r2 = r3
                    boolean r3 = r2.isEmpty()
                    if (r3 != 0) goto L4f
                    goto L50
                L4f:
                    r2 = 0
                L50:
                    if (r2 == 0) goto L77
                    java.lang.StringBuilder r3 = new java.lang.StringBuilder
                    r3.<init>()
                    java.lang.String r4 = " Purchases:"
                    r3.append(r4)
                    r5 = r2
                    java.lang.Iterable r5 = (java.lang.Iterable) r5
                    com.revenuecat.purchases.google.BillingWrapper$onPurchasesUpdated$2$2$1 r11 = new kotlin.jvm.functions.Function1<com.android.billingclient.api.Purchase, java.lang.CharSequence>() { // from class: com.revenuecat.purchases.google.BillingWrapper$onPurchasesUpdated$2$2$1
                        static {
                            /*
                                com.revenuecat.purchases.google.BillingWrapper$onPurchasesUpdated$2$2$1 r0 = new com.revenuecat.purchases.google.BillingWrapper$onPurchasesUpdated$2$2$1
                                r0.<init>()
                                
                                // error: 0x0005: SPUT (r0 I:com.revenuecat.purchases.google.BillingWrapper$onPurchasesUpdated$2$2$1) com.revenuecat.purchases.google.BillingWrapper$onPurchasesUpdated$2$2$1.INSTANCE com.revenuecat.purchases.google.BillingWrapper$onPurchasesUpdated$2$2$1
                                return
                            */
                            throw new UnsupportedOperationException("Method not decompiled: com.revenuecat.purchases.google.BillingWrapper$onPurchasesUpdated$2$2$1.<clinit>():void");
                        }

                        {
                            /*
                                r1 = this;
                                r0 = 1
                                r1.<init>(r0)
                                return
                            */
                            throw new UnsupportedOperationException("Method not decompiled: com.revenuecat.purchases.google.BillingWrapper$onPurchasesUpdated$2$2$1.<init>():void");
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ java.lang.Object invoke(java.lang.Object r1) {
                            /*
                                r0 = this;
                                com.android.billingclient.api.Purchase r1 = (com.android.billingclient.api.Purchase) r1
                                java.lang.CharSequence r1 = r0.invoke(r1)
                                return r1
                            */
                            throw new UnsupportedOperationException("Method not decompiled: com.revenuecat.purchases.google.BillingWrapper$onPurchasesUpdated$2$2$1.invoke(java.lang.Object):java.lang.Object");
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public final java.lang.CharSequence invoke(com.android.billingclient.api.Purchase r2) {
                            /*
                                r1 = this;
                                java.lang.String r0 = "it"
                                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
                                java.lang.String r2 = com.revenuecat.purchases.common.PurchaseExtensionsKt.toHumanReadableDescription(r2)
                                return r2
                            */
                            throw new UnsupportedOperationException("Method not decompiled: com.revenuecat.purchases.google.BillingWrapper$onPurchasesUpdated$2$2$1.invoke(com.android.billingclient.api.Purchase):java.lang.CharSequence");
                        }
                    }
                    r12 = 30
                    r13 = 0
                    java.lang.String r6 = ", "
                    r7 = 0
                    r8 = 0
                    r9 = 0
                    r10 = 0
                    java.lang.String r2 = kotlin.collections.CollectionsKt.joinToString$default(r5, r6, r7, r8, r9, r10, r11, r12, r13)
                    r3.append(r2)
                    java.lang.String r2 = r3.toString()
                    if (r2 != 0) goto L79
                L77:
                    java.lang.String r2 = " No purchases received"
                L79:
                    r1.append(r2)
                    java.lang.String r1 = r1.toString()
                    r0.append(r1)
                    java.lang.String r0 = r0.toString()
                    return r0
                */
                throw new UnsupportedOperationException("Method not decompiled: com.revenuecat.purchases.google.BillingWrapper$onPurchasesUpdated$$inlined$log$1.invoke():java.lang.String");
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
        String str3 = "Error updating purchases. " + BillingResultExtensionsBillingIndependentKt.toHumanReadableDescription(billingResult);
        int iC = billingResult.c();
        if (list == null && billingResult.c() == 0) {
            str3 = "Error: onPurchasesUpdated received an OK BillingResult with a Null purchases list.";
            iC = 6;
        }
        PurchasesError purchasesErrorBillingResponseToPurchasesError = ErrorsKt.billingResponseToPurchasesError(iC, str3);
        LogUtilsKt.errorLog(purchasesErrorBillingResponseToPurchasesError);
        BillingAbstract.PurchasesUpdatedListener purchasesUpdatedListener = getPurchasesUpdatedListener();
        if (purchasesUpdatedListener != null) {
            purchasesUpdatedListener.onPurchasesFailedToUpdate(purchasesErrorBillingResponseToPurchasesError);
        }
    }

    @Override // com.revenuecat.purchases.common.BillingAbstract
    public void queryAllPurchases(String appUserID, final Function1<? super List<StoreTransaction>, Unit> onReceivePurchaseHistory, final Function1<? super PurchasesError, Unit> onReceivePurchaseHistoryError) {
        Intrinsics.checkNotNullParameter(appUserID, "appUserID");
        Intrinsics.checkNotNullParameter(onReceivePurchaseHistory, "onReceivePurchaseHistory");
        Intrinsics.checkNotNullParameter(onReceivePurchaseHistoryError, "onReceivePurchaseHistoryError");
        queryPurchaseHistoryAsync("subs", new Function1<List<? extends StoreTransaction>, Unit>() { // from class: com.revenuecat.purchases.google.BillingWrapper.queryAllPurchases.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((List<StoreTransaction>) obj);
                return Unit.f139807a;
            }

            public final void invoke(final List<StoreTransaction> subsPurchasesList) {
                Intrinsics.checkNotNullParameter(subsPurchasesList, "subsPurchasesList");
                BillingWrapper billingWrapper = BillingWrapper.this;
                final Function1<List<StoreTransaction>, Unit> function1 = onReceivePurchaseHistory;
                billingWrapper.queryPurchaseHistoryAsync("inapp", new Function1<List<? extends StoreTransaction>, Unit>() { // from class: com.revenuecat.purchases.google.BillingWrapper.queryAllPurchases.1.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        invoke((List<StoreTransaction>) obj);
                        return Unit.f139807a;
                    }

                    public final void invoke(List<StoreTransaction> inAppPurchasesList) {
                        Intrinsics.checkNotNullParameter(inAppPurchasesList, "inAppPurchasesList");
                        function1.invoke(CollectionsKt.plus((Collection) subsPurchasesList, (Iterable) inAppPurchasesList));
                    }
                }, onReceivePurchaseHistoryError);
            }
        }, onReceivePurchaseHistoryError);
    }

    @Override // com.revenuecat.purchases.common.BillingAbstract
    public void queryProductDetailsAsync(ProductType productType, final Set<String> productIds, Function1<? super List<? extends StoreProduct>, Unit> onReceive, Function1<? super PurchasesError, Unit> onError) {
        LogHandler currentLogHandler;
        String str;
        String str2;
        Intrinsics.checkNotNullParameter(productType, "productType");
        Intrinsics.checkNotNullParameter(productIds, "productIds");
        Intrinsics.checkNotNullParameter(onReceive, "onReceive");
        Intrinsics.checkNotNullParameter(onError, "onError");
        final LogIntent logIntent = LogIntent.DEBUG;
        Function0<String> function0 = new Function0<String>() { // from class: com.revenuecat.purchases.google.BillingWrapper$queryProductDetailsAsync$$inlined$log$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                StringBuilder sb = new StringBuilder();
                sb.append(CollectionsKt.joinToString$default(logIntent.getEmojiList(), "", null, null, 0, null, null, 62, null));
                sb.append(' ');
                String str3 = String.format(OfferingStrings.FETCHING_PRODUCTS, Arrays.copyOf(new Object[]{CollectionsKt.joinToString$default(productIds, null, null, null, 0, null, null, 63, null)}, 1));
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
        BillingClientUseCase.run$default(new QueryProductDetailsUseCase(new QueryProductDetailsUseCaseParams(this.dateProvider, this.diagnosticsTrackerIfEnabled, productIds, productType, getAppInBackground()), onReceive, onError, new BillingWrapper$queryProductDetailsAsync$useCase$1(this), new BillingWrapper$queryProductDetailsAsync$useCase$2(this)), 0L, 1, null);
    }

    public final void queryPurchaseHistoryAsync(final String productType, Function1<? super List<StoreTransaction>, Unit> onReceivePurchaseHistory, Function1<? super PurchasesError, Unit> onReceivePurchaseHistoryError) {
        LogHandler currentLogHandler;
        String str;
        String str2;
        Intrinsics.checkNotNullParameter(productType, "productType");
        Intrinsics.checkNotNullParameter(onReceivePurchaseHistory, "onReceivePurchaseHistory");
        Intrinsics.checkNotNullParameter(onReceivePurchaseHistoryError, "onReceivePurchaseHistoryError");
        final LogIntent logIntent = LogIntent.DEBUG;
        Function0<String> function0 = new Function0<String>() { // from class: com.revenuecat.purchases.google.BillingWrapper$queryPurchaseHistoryAsync$$inlined$log$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                StringBuilder sb = new StringBuilder();
                sb.append(CollectionsKt.joinToString$default(logIntent.getEmojiList(), "", null, null, 0, null, null, 62, null));
                sb.append(' ');
                String str3 = String.format(RestoreStrings.QUERYING_PURCHASE_HISTORY, Arrays.copyOf(new Object[]{productType}, 1));
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
        BillingClientUseCase.run$default(new QueryPurchaseHistoryUseCase(new QueryPurchaseHistoryUseCaseParams(this.dateProvider, this.diagnosticsTrackerIfEnabled, productType, getAppInBackground()), onReceivePurchaseHistory, onReceivePurchaseHistoryError, new C23542(this), new C23553(this)), 0L, 1, null);
    }

    public final synchronized void setBillingClient(BillingClient billingClient) {
        this.billingClient = billingClient;
    }

    @Override // com.revenuecat.purchases.common.BillingAbstract
    public void showInAppMessagesIfNeeded(Activity activity, List<? extends InAppMessageType> inAppMessageTypes, final Function0<Unit> subscriptionStatusChange) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(inAppMessageTypes, "inAppMessageTypes");
        Intrinsics.checkNotNullParameter(subscriptionStatusChange, "subscriptionStatusChange");
        if (inAppMessageTypes.isEmpty()) {
            LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", BillingStrings.BILLING_UNSPECIFIED_INAPP_MESSAGE_TYPES, null);
            return;
        }
        InAppMessageParams.Builder builderA = InAppMessageParams.a();
        Intrinsics.checkNotNullExpressionValue(builderA, "newBuilder()");
        Iterator<? extends InAppMessageType> it = inAppMessageTypes.iterator();
        while (it.hasNext()) {
            builderA.a(it.next().getInAppMessageCategoryId$purchases_defaultsBc8Release());
        }
        final InAppMessageParams inAppMessageParamsB = builderA.b();
        Intrinsics.checkNotNullExpressionValue(inAppMessageParamsB, "inAppMessageParamsBuilder.build()");
        final WeakReference weakReference = new WeakReference(activity);
        executeRequestOnUIThread$default(this, null, new Function1<PurchasesError, Unit>() { // from class: com.revenuecat.purchases.google.BillingWrapper.showInAppMessagesIfNeeded.2

            /* JADX INFO: renamed from: com.revenuecat.purchases.google.BillingWrapper$showInAppMessagesIfNeeded$2$2, reason: invalid class name and collision with other inner class name */
            /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
            @Metadata
            static final class C01912 extends Lambda implements Function1<BillingClient, Unit> {
                final /* synthetic */ InAppMessageParams $inAppMessageParams;
                final /* synthetic */ Function0<Unit> $subscriptionStatusChange;
                final /* synthetic */ WeakReference<Activity> $weakActivity;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                C01912(WeakReference<Activity> weakReference, InAppMessageParams inAppMessageParams, Function0<Unit> function0) {
                    super(1);
                    this.$weakActivity = weakReference;
                    this.$inAppMessageParams = inAppMessageParams;
                    this.$subscriptionStatusChange = function0;
                }

                /* JADX INFO: Access modifiers changed from: private */
                public static final void invoke$lambda$8(Function0 function0, InAppMessageResult inAppMessageResult) {
                    Intrinsics.checkNotNullParameter(inAppMessageResult, "inAppMessageResult");
                    int iA = inAppMessageResult.a();
                    if (iA == 0) {
                        LogLevel logLevel = LogLevel.VERBOSE;
                        LogHandler currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                            currentLogHandler.v("[Purchases] - " + logLevel.name(), BillingStrings.BILLING_INAPP_MESSAGE_NONE);
                            return;
                        }
                        return;
                    }
                    if (iA != 1) {
                        LogHandler currentLogHandler2 = LogWrapperKt.getCurrentLogHandler();
                        String str = String.format(BillingStrings.BILLING_INAPP_MESSAGE_UNEXPECTED_CODE, Arrays.copyOf(new Object[]{Integer.valueOf(iA)}, 1));
                        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
                        currentLogHandler2.e("[Purchases] - ERROR", str, null);
                        return;
                    }
                    LogLevel logLevel2 = LogLevel.DEBUG;
                    LogHandler currentLogHandler3 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel2) <= 0) {
                        currentLogHandler3.d("[Purchases] - " + logLevel2.name(), BillingStrings.BILLING_INAPP_MESSAGE_UPDATE);
                    }
                    function0.invoke();
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke((BillingClient) obj);
                    return Unit.f139807a;
                }

                public final void invoke(BillingClient withConnectedClient) {
                    View viewPeekDecorView;
                    Intrinsics.checkNotNullParameter(withConnectedClient, "$this$withConnectedClient");
                    Activity activity = this.$weakActivity.get();
                    if (activity == null) {
                        LogLevel logLevel = LogLevel.DEBUG;
                        LogHandler currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                            currentLogHandler.d("[Purchases] - " + logLevel.name(), "Activity is null, not showing Google Play in-app message.");
                            return;
                        }
                        return;
                    }
                    if (activity.isFinishing()) {
                        LogLevel logLevel2 = LogLevel.DEBUG;
                        LogHandler currentLogHandler2 = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel2) <= 0) {
                            currentLogHandler2.d("[Purchases] - " + logLevel2.name(), "Activity is finishing, not showing Google Play in-app message.");
                            return;
                        }
                        return;
                    }
                    if (activity.isDestroyed()) {
                        LogLevel logLevel3 = LogLevel.DEBUG;
                        LogHandler currentLogHandler3 = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel3) <= 0) {
                            currentLogHandler3.d("[Purchases] - " + logLevel3.name(), "Activity is destroyed, not showing Google Play in-app message.");
                            return;
                        }
                        return;
                    }
                    Window window = activity.getWindow();
                    if (((window == null || (viewPeekDecorView = window.peekDecorView()) == null) ? null : viewPeekDecorView.getWindowToken()) == null) {
                        LogLevel logLevel4 = LogLevel.DEBUG;
                        LogHandler currentLogHandler4 = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel4) <= 0) {
                            currentLogHandler4.d("[Purchases] - " + logLevel4.name(), "Activity is not attached to a window, not showing Google Play in-app message.");
                            return;
                        }
                        return;
                    }
                    try {
                        InAppMessageParams inAppMessageParams = this.$inAppMessageParams;
                        final Function0<Unit> function0 = this.$subscriptionStatusChange;
                        withConnectedClient.k(activity, inAppMessageParams, new InAppMessageResponseListener() { // from class: com.revenuecat.purchases.google.h
                            @Override // com.android.billingclient.api.InAppMessageResponseListener
                            public final void a(InAppMessageResult inAppMessageResult) {
                                BillingWrapper.C23622.C01912.invoke$lambda$8(function0, inAppMessageResult);
                            }
                        });
                    } catch (RuntimeException e3) {
                        LogHandler currentLogHandler5 = LogWrapperKt.getCurrentLogHandler();
                        String str = String.format(BillingStrings.BILLING_INAPP_MESSAGE_SHOW_EXCEPTION, Arrays.copyOf(new Object[]{e3}, 1));
                        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
                        currentLogHandler5.e("[Purchases] - ERROR", str, e3);
                    }
                }
            }

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
                if (purchasesError == null) {
                    BillingWrapper.this.withConnectedClient(new C01912(weakReference, inAppMessageParamsB, subscriptionStatusChange));
                    return;
                }
                LogHandler currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                String str = String.format(BillingStrings.BILLING_CONNECTION_ERROR_INAPP_MESSAGES, Arrays.copyOf(new Object[]{purchasesError}, 1));
                Intrinsics.checkNotNullExpressionValue(str, "format(...)");
                currentLogHandler.e("[Purchases] - ERROR", str, null);
            }
        }, 1, null);
    }

    @Override // com.revenuecat.purchases.common.BillingAbstract
    public void startConnection(long j3) {
        this.backgroundHandler.postDelayed(new Runnable() { // from class: com.revenuecat.purchases.google.a
            @Override // java.lang.Runnable
            public final void run() {
                this.f92268a.performStartConnection();
            }
        }, j3);
    }

    public final void getPurchaseType$purchases_defaultsBc8Release(final String purchaseToken, final Function1<? super ProductType, Unit> function1) {
        Intrinsics.checkNotNullParameter(purchaseToken, "purchaseToken");
        Intrinsics.checkNotNullParameter(function1, pnxuebdT.IIsPAxe);
        queryPurchaseType("subs", purchaseToken, function1, new Function1<Boolean, Unit>() { // from class: com.revenuecat.purchases.google.BillingWrapper$getPurchaseType$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke(((Boolean) obj).booleanValue());
                return Unit.f139807a;
            }

            public final void invoke(boolean z2) {
                if (z2) {
                    function1.invoke(ProductType.SUBS);
                    return;
                }
                BillingWrapper billingWrapper = this;
                String str = purchaseToken;
                final Function1<ProductType, Unit> function12 = function1;
                billingWrapper.queryPurchaseType("inapp", str, function12, new Function1<Boolean, Unit>() { // from class: com.revenuecat.purchases.google.BillingWrapper$getPurchaseType$1.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        invoke(((Boolean) obj).booleanValue());
                        return Unit.f139807a;
                    }

                    public final void invoke(boolean z3) {
                        if (z3) {
                            function12.invoke(ProductType.INAPP);
                        } else {
                            function12.invoke(ProductType.UNKNOWN);
                        }
                    }
                });
            }
        });
    }

    @Override // com.revenuecat.purchases.common.BillingAbstract
    public void queryPurchases(String appUserID, Function1<? super Map<String, StoreTransaction>, Unit> onSuccess, Function1<? super PurchasesError, Unit> onError) {
        LogHandler currentLogHandler;
        String str;
        String str2;
        Intrinsics.checkNotNullParameter(appUserID, "appUserID");
        Intrinsics.checkNotNullParameter(onSuccess, "onSuccess");
        Intrinsics.checkNotNullParameter(onError, "onError");
        final LogIntent logIntent = LogIntent.DEBUG;
        Function0<String> function0 = new Function0<String>() { // from class: com.revenuecat.purchases.google.BillingWrapper$queryPurchases$$inlined$log$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                return CollectionsKt.joinToString$default(logIntent.getEmojiList(), "", null, null, 0, null, null, 62, null) + ' ' + RestoreStrings.QUERYING_PURCHASE;
            }
        };
        int i3 = LogWrapperKt.WhenMappings.$EnumSwitchMapping$0[logIntent.ordinal()];
        String str3 = KLAQHFCRAUejH.JggIr;
        switch (i3) {
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
                LogWrapperKt.getCurrentLogHandler().e(str3, (String) function0.invoke(), null);
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
                LogWrapperKt.getCurrentLogHandler().e(str3, (String) function0.invoke(), null);
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
                LogWrapperKt.getCurrentLogHandler().e(str3, (String) function0.invoke(), null);
                break;
            case 13:
                LogLevel logLevel10 = LogLevel.WARN;
                LogHandler currentLogHandler7 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel10) <= 0) {
                    currentLogHandler7.w("[Purchases] - " + logLevel10.name(), (String) function0.invoke());
                }
                break;
            case 14:
                LogWrapperKt.getCurrentLogHandler().e(str3, (String) function0.invoke(), null);
                break;
        }
        BillingClientUseCase.run$default(new QueryPurchasesUseCase(new QueryPurchasesUseCaseParams(this.dateProvider, this.diagnosticsTrackerIfEnabled, getAppInBackground()), onSuccess, onError, new C23602(this), new C23613(this)), 0L, 1, null);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BillingWrapper(ClientFactory clientFactory, Handler mainHandler, Handler handler, DeviceCache deviceCache, DiagnosticsTracker diagnosticsTracker, PurchasesStateProvider purchasesStateProvider, DateProvider dateProvider) {
        HandlerThread handlerThread;
        super(purchasesStateProvider);
        Intrinsics.checkNotNullParameter(clientFactory, "clientFactory");
        Intrinsics.checkNotNullParameter(mainHandler, "mainHandler");
        Intrinsics.checkNotNullParameter(deviceCache, "deviceCache");
        Intrinsics.checkNotNullParameter(purchasesStateProvider, "purchasesStateProvider");
        Intrinsics.checkNotNullParameter(dateProvider, "dateProvider");
        this.clientFactory = clientFactory;
        this.mainHandler = mainHandler;
        this.deviceCache = deviceCache;
        this.diagnosticsTrackerIfEnabled = diagnosticsTracker;
        this.dateProvider = dateProvider;
        if (handler == null) {
            handlerThread = new HandlerThread("revenuecat-billing");
            handlerThread.start();
        } else {
            handlerThread = null;
        }
        this.ownedBackgroundThread = handlerThread;
        if (handler == null) {
            Intrinsics.checkNotNull(handlerThread);
            handler = new Handler(handlerThread.getLooper());
        }
        this.backgroundHandler = handler;
        this.purchaseContext = new LinkedHashMap();
        this.serviceRequests = new ConcurrentLinkedQueue<>();
        this.reconnectMilliseconds = 1000L;
    }
}
