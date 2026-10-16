package com.revenuecat.purchases.amazon;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.amazon.device.iap.model.FulfillmentResult;
import com.amazon.device.iap.model.LWAConsentStatus;
import com.amazon.device.iap.model.ProductDataResponse;
import com.amazon.device.iap.model.ProductType;
import com.amazon.device.iap.model.PurchaseResponse;
import com.amazon.device.iap.model.PurchaseUpdatesResponse;
import com.amazon.device.iap.model.Receipt;
import com.amazon.device.iap.model.UserData;
import com.amazon.device.iap.model.UserDataResponse;
import com.facebook.stetho.inspector.helper.qp.sKeKFMqmvNzY;
import com.revenuecat.purchases.AmazonLWAConsentStatus;
import com.revenuecat.purchases.LogHandler;
import com.revenuecat.purchases.LogLevel;
import com.revenuecat.purchases.PostReceiptInitiationSource;
import com.revenuecat.purchases.PresentedOfferingContext;
import com.revenuecat.purchases.PurchasesError;
import com.revenuecat.purchases.PurchasesErrorCode;
import com.revenuecat.purchases.PurchasesStateProvider;
import com.revenuecat.purchases.amazon.AmazonPurchasingData;
import com.revenuecat.purchases.amazon.handler.ProductDataHandler;
import com.revenuecat.purchases.amazon.handler.PurchaseHandler;
import com.revenuecat.purchases.amazon.handler.PurchaseUpdatesHandler;
import com.revenuecat.purchases.amazon.handler.UserDataHandler;
import com.revenuecat.purchases.amazon.listener.ProductDataResponseListener;
import com.revenuecat.purchases.amazon.listener.PurchaseResponseListener;
import com.revenuecat.purchases.amazon.listener.PurchaseUpdatesResponseListener;
import com.revenuecat.purchases.amazon.listener.UserDataResponseListener;
import com.revenuecat.purchases.common.BackendHelper;
import com.revenuecat.purchases.common.BillingAbstract;
import com.revenuecat.purchases.common.Config;
import com.revenuecat.purchases.common.DateProvider;
import com.revenuecat.purchases.common.DefaultDateProvider;
import com.revenuecat.purchases.common.DurationExtensionsKt;
import com.revenuecat.purchases.common.LogIntent;
import com.revenuecat.purchases.common.LogUtilsKt;
import com.revenuecat.purchases.common.LogWrapperKt;
import com.revenuecat.purchases.common.ReplaceProductInfo;
import com.revenuecat.purchases.common.UtilsKt;
import com.revenuecat.purchases.common.caching.DeviceCache;
import com.revenuecat.purchases.common.diagnostics.DiagnosticsTracker;
import com.revenuecat.purchases.models.InAppMessageType;
import com.revenuecat.purchases.models.PurchaseState;
import com.revenuecat.purchases.models.PurchasingData;
import com.revenuecat.purchases.models.StoreProduct;
import com.revenuecat.purchases.models.StoreTransaction;
import com.revenuecat.purchases.strings.BillingStrings;
import com.revenuecat.purchases.strings.PurchaseStrings;
import com.revenuecat.purchases.strings.RestoreStrings;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
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
import kotlin.jvm.internal.Ref;
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
public final class AmazonBilling extends BillingAbstract implements ProductDataResponseListener, PurchaseResponseListener, PurchaseUpdatesResponseListener, UserDataResponseListener {
    private final AmazonBackend amazonBackend;
    private final Context applicationContext;
    private final AmazonCache cache;
    private boolean connected;
    private final DateProvider dateProvider;
    private final DiagnosticsTracker diagnosticsTrackerIfEnabled;
    private final boolean finishTransactions;
    private final Handler mainHandler;
    private final ProductDataResponseListener productDataHandler;
    private final PurchaseResponseListener purchaseHandler;
    private final PurchaseUpdatesResponseListener purchaseUpdatesHandler;
    private final PurchasingServiceProvider purchasingServiceProvider;
    private final ConcurrentLinkedQueue<Function1<PurchasesError, Unit>> serviceRequests;
    private final UserDataResponseListener userDataHandler;

    /* JADX INFO: renamed from: com.revenuecat.purchases.amazon.AmazonBilling$handleReceipt$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    /* synthetic */ class C23262 extends FunctionReferenceImpl implements Function1<PurchasesError, Unit> {
        C23262(Object obj) {
            super(1, obj, AmazonBilling.class, "onPurchaseError", "onPurchaseError(Lcom/revenuecat/purchases/PurchasesError;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((PurchasesError) obj);
            return Unit.f139807a;
        }

        public final void invoke(PurchasesError p02) {
            Intrinsics.checkNotNullParameter(p02, "p0");
            ((AmazonBilling) this.receiver).onPurchaseError(p02);
        }
    }

    public /* synthetic */ AmazonBilling(Context context, AmazonBackend amazonBackend, AmazonCache amazonCache, boolean z2, Handler handler, PurchasesStateProvider purchasesStateProvider, DiagnosticsTracker diagnosticsTracker, PurchasingServiceProvider purchasingServiceProvider, ProductDataResponseListener productDataResponseListener, PurchaseResponseListener purchaseResponseListener, PurchaseUpdatesResponseListener purchaseUpdatesResponseListener, UserDataResponseListener userDataResponseListener, DateProvider dateProvider, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        Handler handler2;
        ProductDataResponseListener productDataHandler;
        PurchasingServiceProvider defaultPurchasingServiceProvider = (i3 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0 ? new DefaultPurchasingServiceProvider() : purchasingServiceProvider;
        if ((i3 & Function.MAX_NARGS) != 0) {
            handler2 = handler;
            productDataHandler = new ProductDataHandler(defaultPurchasingServiceProvider, handler2);
        } else {
            handler2 = handler;
            productDataHandler = productDataResponseListener;
        }
        this(context, amazonBackend, amazonCache, z2, handler, purchasesStateProvider, diagnosticsTracker, defaultPurchasingServiceProvider, productDataHandler, (i3 & 512) != 0 ? new PurchaseHandler(defaultPurchasingServiceProvider, context, diagnosticsTracker, null, 8, null) : purchaseResponseListener, (i3 & 1024) != 0 ? new PurchaseUpdatesHandler(defaultPurchasingServiceProvider) : purchaseUpdatesResponseListener, (i3 & 2048) != 0 ? new UserDataHandler(defaultPurchasingServiceProvider, handler2, null, 4, null) : userDataResponseListener, (i3 & 4096) != 0 ? new DefaultDateProvider() : dateProvider);
    }

    private final void executePendingRequests() {
        synchronized (this) {
            while (isConnected() && !this.serviceRequests.isEmpty()) {
                try {
                    final Function1<PurchasesError, Unit> function1Remove = this.serviceRequests.remove();
                    runOnUIThread(new Runnable() { // from class: com.revenuecat.purchases.amazon.a
                        @Override // java.lang.Runnable
                        public final void run() {
                            function1Remove.invoke(null);
                        }
                    });
                } catch (Throwable th) {
                    throw th;
                }
            }
            Unit unit = Unit.f139807a;
        }
    }

    private final synchronized void executeRequestOnUIThread(Function1<? super PurchasesError, Unit> function1) {
        try {
            if (getPurchasesUpdatedListener() != null) {
                this.serviceRequests.add(function1);
                if (isConnected()) {
                    executePendingRequests();
                } else {
                    BillingAbstract.startConnection$default(this, 0L, 1, null);
                }
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void getMissingSkusForReceipts(String str, List<Receipt> list, Function2<? super Map<String, String>, ? super Map<String, PurchasesError>, Unit> function2) {
        Map<String, String> receiptSkus = this.cache.getReceiptSkus();
        final Map mutableMap = MapsKt.toMutableMap(receiptSkus);
        final LinkedHashMap linkedHashMap = new LinkedHashMap();
        List<Receipt> list2 = list;
        ArrayList arrayList = new ArrayList();
        for (Object obj : list2) {
            if (((Receipt) obj).getProductType() != ProductType.SUBSCRIPTION) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList, 10));
        int size = arrayList.size();
        int i3 = 0;
        while (i3 < size) {
            Object obj2 = arrayList.get(i3);
            i3++;
            Receipt receipt = (Receipt) obj2;
            arrayList2.add(TuplesKt.a(receipt.getReceiptId(), receipt.getSku()));
        }
        MapsKt.putAll(mutableMap, arrayList2);
        ArrayList arrayList3 = new ArrayList();
        for (Object obj3 : list2) {
            if (((Receipt) obj3).getProductType() == ProductType.SUBSCRIPTION) {
                arrayList3.add(obj3);
            }
        }
        ArrayList arrayList4 = new ArrayList();
        int size2 = arrayList3.size();
        int i4 = 0;
        while (i4 < size2) {
            Object obj4 = arrayList3.get(i4);
            i4++;
            if (!receiptSkus.containsKey(((Receipt) obj4).getReceiptId())) {
                arrayList4.add(obj4);
            }
        }
        if (arrayList4.isEmpty()) {
            function2.invoke(mutableMap, linkedHashMap);
            return;
        }
        final Ref.IntRef intRef = new Ref.IntRef();
        intRef.f140142a = arrayList4.size();
        int size3 = arrayList4.size();
        for (int i5 = 0; i5 < size3; i5++) {
            final Receipt receipt2 = (Receipt) arrayList4.get(i5);
            AmazonBackend amazonBackend = this.amazonBackend;
            String receiptId = receipt2.getReceiptId();
            Intrinsics.checkNotNullExpressionValue(receiptId, "receipt.receiptId");
            final Function2<? super Map<String, String>, ? super Map<String, PurchasesError>, Unit> function22 = function2;
            Function1<JSONObject, Unit> function1 = new Function1<JSONObject, Unit>() { // from class: com.revenuecat.purchases.amazon.AmazonBilling$getMissingSkusForReceipts$1$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Object invoke(Object obj5) throws JSONException {
                    invoke((JSONObject) obj5);
                    return Unit.f139807a;
                }

                public final void invoke(final JSONObject response) throws JSONException {
                    LogHandler currentLogHandler;
                    String str2;
                    String str3;
                    Intrinsics.checkNotNullParameter(response, "response");
                    final LogIntent logIntent = LogIntent.DEBUG;
                    Function0<String> function0 = new Function0<String>() { // from class: com.revenuecat.purchases.amazon.AmazonBilling$getMissingSkusForReceipts$1$1$invoke$$inlined$log$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public final String invoke() {
                            StringBuilder sb = new StringBuilder();
                            sb.append(CollectionsKt.joinToString$default(logIntent.getEmojiList(), "", null, null, 0, null, null, 62, null));
                            sb.append(' ');
                            String str4 = String.format(AmazonStrings.RECEIPT_DATA_RECEIVED, Arrays.copyOf(new Object[]{response.toString()}, 1));
                            Intrinsics.checkNotNullExpressionValue(str4, "format(...)");
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
                    Map<String, String> map = mutableMap;
                    String receiptId2 = receipt2.getReceiptId();
                    Intrinsics.checkNotNullExpressionValue(receiptId2, "receipt.receiptId");
                    Object obj5 = response.get("termSku");
                    Intrinsics.checkNotNull(obj5, "null cannot be cast to non-null type kotlin.String");
                    map.put(receiptId2, (String) obj5);
                    Ref.IntRef intRef2 = intRef;
                    int i6 = intRef2.f140142a - 1;
                    intRef2.f140142a = i6;
                    if (i6 == 0) {
                        this.cache.cacheSkusByToken(mutableMap);
                        function22.invoke(mutableMap, linkedHashMap);
                    }
                }
            };
            final Map map = mutableMap;
            mutableMap = map;
            amazonBackend.getAmazonReceiptData(receiptId, str, function1, new Function1<PurchasesError, Unit>() { // from class: com.revenuecat.purchases.amazon.AmazonBilling$getMissingSkusForReceipts$1$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Object invoke(Object obj5) {
                    invoke((PurchasesError) obj5);
                    return Unit.f139807a;
                }

                public final void invoke(final PurchasesError error) {
                    LogHandler currentLogHandler;
                    String str2;
                    String str3;
                    Intrinsics.checkNotNullParameter(error, "error");
                    final LogIntent logIntent = LogIntent.AMAZON_ERROR;
                    Function0<String> function0 = new Function0<String>() { // from class: com.revenuecat.purchases.amazon.AmazonBilling$getMissingSkusForReceipts$1$2$invoke$$inlined$log$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public final String invoke() {
                            StringBuilder sb = new StringBuilder();
                            sb.append(CollectionsKt.joinToString$default(logIntent.getEmojiList(), "", null, null, 0, null, null, 62, null));
                            sb.append(' ');
                            String str4 = String.format(AmazonStrings.ERROR_FETCHING_RECEIPT_INFO, Arrays.copyOf(new Object[]{error}, 1));
                            Intrinsics.checkNotNullExpressionValue(str4, "format(...)");
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
                    Map<String, PurchasesError> map2 = linkedHashMap;
                    String receiptId2 = receipt2.getReceiptId();
                    Intrinsics.checkNotNullExpressionValue(receiptId2, "receipt.receiptId");
                    map2.put(receiptId2, error);
                    Ref.IntRef intRef2 = intRef;
                    int i6 = intRef2.f140142a - 1;
                    intRef2.f140142a = i6;
                    if (i6 == 0) {
                        function22.invoke(map, linkedHashMap);
                    }
                }
            });
            function2 = function22;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String getTermSkuFromJSON(JSONObject jSONObject) {
        try {
            return jSONObject.getString("termSku");
        } catch (JSONException unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void handleReceipt(final Receipt receipt, final UserData userData, StoreProduct storeProduct, final PresentedOfferingContext presentedOfferingContext) {
        if (receipt.getProductType() != ProductType.SUBSCRIPTION) {
            StoreTransaction storeTransaction = StoreTransactionConversionsKt.toStoreTransaction(receipt, storeProduct.getId(), presentedOfferingContext, PurchaseState.PURCHASED, userData);
            BillingAbstract.PurchasesUpdatedListener purchasesUpdatedListener = getPurchasesUpdatedListener();
            if (purchasesUpdatedListener != null) {
                purchasesUpdatedListener.onPurchasesUpdated(CollectionsKt.listOf(storeTransaction));
                return;
            }
            return;
        }
        AmazonBackend amazonBackend = this.amazonBackend;
        String receiptId = receipt.getReceiptId();
        Intrinsics.checkNotNullExpressionValue(receiptId, "receipt.receiptId");
        String userId = userData.getUserId();
        Intrinsics.checkNotNullExpressionValue(userId, "userData.userId");
        amazonBackend.getAmazonReceiptData(receiptId, userId, new Function1<JSONObject, Unit>() { // from class: com.revenuecat.purchases.amazon.AmazonBilling.handleReceipt.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) throws JSONException {
                invoke((JSONObject) obj);
                return Unit.f139807a;
            }

            public final void invoke(JSONObject response) throws JSONException {
                Intrinsics.checkNotNullParameter(response, "response");
                Object obj = response.get("termSku");
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
                StoreTransaction storeTransaction2 = StoreTransactionConversionsKt.toStoreTransaction(receipt, (String) obj, presentedOfferingContext, PurchaseState.PURCHASED, userData);
                BillingAbstract.PurchasesUpdatedListener purchasesUpdatedListener2 = this.getPurchasesUpdatedListener();
                if (purchasesUpdatedListener2 != null) {
                    purchasesUpdatedListener2.onPurchasesUpdated(CollectionsKt.listOf(storeTransaction2));
                }
            }
        }, new C23262(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void logErrorsIfAny(Map<String, PurchasesError> map) {
        if (map.isEmpty()) {
            return;
        }
        final String strJoinToString$default = CollectionsKt.joinToString$default(map.keySet(), "\n", null, null, 0, null, null, 62, null);
        final LogIntent logIntent = LogIntent.AMAZON_ERROR;
        Function0<String> function0 = new Function0<String>() { // from class: com.revenuecat.purchases.amazon.AmazonBilling$logErrorsIfAny$$inlined$log$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                StringBuilder sb = new StringBuilder();
                sb.append(CollectionsKt.joinToString$default(logIntent.getEmojiList(), "", null, null, 0, null, null, 62, null));
                sb.append(' ');
                String str = String.format(AmazonStrings.ERROR_FETCHING_RECEIPTS, Arrays.copyOf(new Object[]{strJoinToString$default}, 1));
                Intrinsics.checkNotNullExpressionValue(str, "format(...)");
                sb.append(str);
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
    public final void onPurchaseError(PurchasesError purchasesError) {
        BillingAbstract.PurchasesUpdatedListener purchasesUpdatedListener = getPurchasesUpdatedListener();
        if (purchasesUpdatedListener != null) {
            purchasesUpdatedListener.onPurchasesFailedToUpdate(purchasesError);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void performStartConnection() {
        if (shouldFinishTransactions()) {
            this.purchasingServiceProvider.registerListener(this.applicationContext, this);
            this.connected = true;
            BillingAbstract.StateListener stateListener = getStateListener();
            if (stateListener != null) {
                stateListener.onConnected();
            }
            executePendingRequests();
        }
    }

    private final void runOnUIThread(Runnable runnable) {
        if (Intrinsics.areEqual(Looper.getMainLooper().getThread(), Thread.currentThread())) {
            runnable.run();
        } else {
            this.mainHandler.post(runnable);
        }
    }

    private final boolean shouldFinishTransactions() {
        LogHandler currentLogHandler;
        String str;
        String str2;
        if (this.finishTransactions) {
            return true;
        }
        final LogIntent logIntent = LogIntent.AMAZON_WARNING;
        Function0<String> function0 = new Function0<String>() { // from class: com.revenuecat.purchases.amazon.AmazonBilling$shouldFinishTransactions$$inlined$log$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                return CollectionsKt.joinToString$default(logIntent.getEmojiList(), "", null, null, 0, null, null, 62, null) + ' ' + AmazonStrings.WARNING_AMAZON_NOT_FINISHING_TRANSACTIONS;
            }
        };
        switch (LogWrapperKt.WhenMappings.$EnumSwitchMapping$0[logIntent.ordinal()]) {
            case 1:
                LogLevel logLevel = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel) > 0) {
                    return false;
                }
                str = "[Purchases] - " + logLevel.name();
                str2 = (String) function0.invoke();
                break;
                break;
            case 2:
                LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) function0.invoke(), null);
                return false;
            case 3:
                LogLevel logLevel2 = LogLevel.WARN;
                LogHandler currentLogHandler2 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel2) > 0) {
                    return false;
                }
                currentLogHandler2.w("[Purchases] - " + logLevel2.name(), (String) function0.invoke());
                return false;
            case 4:
                LogLevel logLevel3 = LogLevel.INFO;
                LogHandler currentLogHandler3 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel3) > 0) {
                    return false;
                }
                currentLogHandler3.i("[Purchases] - " + logLevel3.name(), (String) function0.invoke());
                return false;
            case 5:
                LogLevel logLevel4 = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel4) > 0) {
                    return false;
                }
                str = "[Purchases] - " + logLevel4.name();
                str2 = (String) function0.invoke();
                break;
                break;
            case 6:
                LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) function0.invoke(), null);
                return false;
            case 7:
                LogLevel logLevel5 = LogLevel.INFO;
                LogHandler currentLogHandler4 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel5) > 0) {
                    return false;
                }
                currentLogHandler4.i("[Purchases] - " + logLevel5.name(), (String) function0.invoke());
                return false;
            case 8:
                LogLevel logLevel6 = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel6) > 0) {
                    return false;
                }
                str = "[Purchases] - " + logLevel6.name();
                str2 = (String) function0.invoke();
                break;
                break;
            case 9:
                LogLevel logLevel7 = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel7) > 0) {
                    return false;
                }
                str = "[Purchases] - " + logLevel7.name();
                str2 = (String) function0.invoke();
                break;
                break;
            case 10:
                LogLevel logLevel8 = LogLevel.WARN;
                LogHandler currentLogHandler5 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel8) > 0) {
                    return false;
                }
                currentLogHandler5.w("[Purchases] - " + logLevel8.name(), (String) function0.invoke());
                return false;
            case 11:
                LogLevel logLevel9 = LogLevel.WARN;
                LogHandler currentLogHandler6 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel9) > 0) {
                    return false;
                }
                currentLogHandler6.w("[Purchases] - " + logLevel9.name(), (String) function0.invoke());
                return false;
            case 12:
                LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) function0.invoke(), null);
                return false;
            case 13:
                LogLevel logLevel10 = LogLevel.WARN;
                LogHandler currentLogHandler7 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel10) > 0) {
                    return false;
                }
                currentLogHandler7.w("[Purchases] - " + logLevel10.name(), (String) function0.invoke());
                return false;
            case 14:
                LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) function0.invoke(), null);
                return false;
            default:
                return false;
        }
        currentLogHandler.d(str, str2);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Map<String, StoreTransaction> toMapOfReceiptHashesToRestoredPurchases(List<Receipt> list, Map<String, String> map, UserData userData) {
        LogHandler currentLogHandler;
        String str;
        String str2;
        ArrayList arrayList = new ArrayList();
        for (Receipt receipt : list) {
            String str3 = map.get(receipt.getReceiptId());
            Pair pairA = null;
            if (str3 == null) {
                final LogIntent logIntent = LogIntent.AMAZON_ERROR;
                Function0<String> function0 = new Function0<String>() { // from class: com.revenuecat.purchases.amazon.AmazonBilling$toMapOfReceiptHashesToRestoredPurchases$lambda$5$$inlined$log$1
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final String invoke() {
                        return CollectionsKt.joinToString$default(logIntent.getEmojiList(), "", null, null, 0, null, null, 62, null) + ' ' + AmazonStrings.ERROR_FINDING_RECEIPT_SKU;
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
            } else {
                StoreTransaction storeTransaction = StoreTransactionConversionsKt.toStoreTransaction(receipt, str3, null, PurchaseState.UNSPECIFIED_STATE, userData);
                String receiptId = receipt.getReceiptId();
                Intrinsics.checkNotNullExpressionValue(receiptId, "receipt.receiptId");
                pairA = TuplesKt.a(UtilsKt.sha1(receiptId), storeTransaction);
            }
            if (pairA != null) {
                arrayList.add(pairA);
            }
        }
        return MapsKt.toMap(arrayList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void trackAmazonQueryProductDetailsRequestIfNeeded(boolean z2, Date date, Set<String> set) {
        DiagnosticsTracker diagnosticsTracker = this.diagnosticsTrackerIfEnabled;
        if (diagnosticsTracker != null) {
            diagnosticsTracker.m531trackAmazonQueryProductDetailsRequestKLykuaI(DurationExtensionsKt.between(Duration.f140631b, date, this.dateProvider.getNow()), z2, set);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void trackAmazonQueryPurchasesRequestIfNeeded(boolean z2, Date date, List<Receipt> list) {
        ArrayList arrayList;
        DiagnosticsTracker diagnosticsTracker = this.diagnosticsTrackerIfEnabled;
        if (diagnosticsTracker != null) {
            long jBetween = DurationExtensionsKt.between(Duration.f140631b, date, this.dateProvider.getNow());
            if (list != null) {
                List<Receipt> list2 = list;
                arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
                Iterator<T> it = list2.iterator();
                while (it.hasNext()) {
                    arrayList.add(((Receipt) it.next()).getSku());
                }
            } else {
                arrayList = null;
            }
            diagnosticsTracker.m532trackAmazonQueryPurchasesRequestKLykuaI(jBetween, z2, arrayList);
        }
    }

    @Override // com.revenuecat.purchases.common.BillingAbstract
    public void consumeAndSave(boolean z2, final StoreTransaction purchase, boolean z3, PostReceiptInitiationSource initiationSource) {
        Intrinsics.checkNotNullParameter(purchase, "purchase");
        Intrinsics.checkNotNullParameter(initiationSource, "initiationSource");
        if (!shouldFinishTransactions() || purchase.getType() == com.revenuecat.purchases.ProductType.UNKNOWN || purchase.getPurchaseState() == PurchaseState.PENDING) {
            return;
        }
        if (z2) {
            executeRequestOnUIThread(new Function1<PurchasesError, Unit>() { // from class: com.revenuecat.purchases.amazon.AmazonBilling.consumeAndSave.1
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
                        AmazonBilling.this.purchasingServiceProvider.notifyFulfillment(purchase.getPurchaseToken(), FulfillmentResult.FULFILLED);
                    } else {
                        LogUtilsKt.errorLog(purchasesError);
                    }
                }
            });
        }
        this.cache.addSuccessfullyPostedToken(purchase.getPurchaseToken(), purchase.isAutoRenewing());
    }

    @Override // com.revenuecat.purchases.common.BillingAbstract
    protected void endConnection() {
    }

    @Override // com.revenuecat.purchases.common.BillingAbstract
    public void findPurchaseInPurchaseHistory(String appUserID, final com.revenuecat.purchases.ProductType productType, final String productId, final Function1<? super StoreTransaction, Unit> onCompletion, final Function1<? super PurchasesError, Unit> onError) {
        LogHandler currentLogHandler;
        String str;
        String str2;
        Intrinsics.checkNotNullParameter(appUserID, "appUserID");
        Intrinsics.checkNotNullParameter(productType, "productType");
        Intrinsics.checkNotNullParameter(productId, "productId");
        Intrinsics.checkNotNullParameter(onCompletion, "onCompletion");
        Intrinsics.checkNotNullParameter(onError, "onError");
        final LogIntent logIntent = LogIntent.DEBUG;
        Function0<String> function0 = new Function0<String>() { // from class: com.revenuecat.purchases.amazon.AmazonBilling$findPurchaseInPurchaseHistory$$inlined$log$1
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
        queryAllPurchases(appUserID, new Function1<List<? extends StoreTransaction>, Unit>() { // from class: com.revenuecat.purchases.amazon.AmazonBilling.findPurchaseInPurchaseHistory.2
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

            public final void invoke(List<StoreTransaction> it) {
                Object next;
                Intrinsics.checkNotNullParameter(it, "it");
                String str3 = productId;
                Iterator<T> it2 = it.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        next = null;
                        break;
                    } else {
                        next = it2.next();
                        if (Intrinsics.areEqual(str3, ((StoreTransaction) next).getProductIds().get(0))) {
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
        }, onError);
    }

    @Override // com.revenuecat.purchases.common.BillingAbstract
    public void getAmazonLWAConsentStatus(final Function1<? super AmazonLWAConsentStatus, Unit> onSuccess, final Function1<? super PurchasesError, Unit> onError) {
        Intrinsics.checkNotNullParameter(onSuccess, "onSuccess");
        Intrinsics.checkNotNullParameter(onError, "onError");
        executeRequestOnUIThread(new Function1<PurchasesError, Unit>() { // from class: com.revenuecat.purchases.amazon.AmazonBilling.getAmazonLWAConsentStatus.1
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

            public final void invoke(PurchasesError purchasesError) {
                if (purchasesError != null) {
                    LogHandler currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                    String str = String.format(BillingStrings.BILLING_CONNECTION_ERROR_LWA_CONSENT_STATUS, Arrays.copyOf(new Object[]{purchasesError}, 1));
                    Intrinsics.checkNotNullExpressionValue(str, "format(...)");
                    currentLogHandler.e("[Purchases] - ERROR", str, null);
                    onError.invoke(purchasesError);
                    return;
                }
                UserDataResponseListener userDataResponseListener = AmazonBilling.this.userDataHandler;
                final AmazonBilling amazonBilling = AmazonBilling.this;
                final Function1<AmazonLWAConsentStatus, Unit> function1 = onSuccess;
                final Function1<PurchasesError, Unit> function12 = onError;
                Function1<UserData, Unit> function13 = new Function1<UserData, Unit>() { // from class: com.revenuecat.purchases.amazon.AmazonBilling.getAmazonLWAConsentStatus.1.1

                    /* JADX INFO: renamed from: com.revenuecat.purchases.amazon.AmazonBilling$getAmazonLWAConsentStatus$1$1$WhenMappings */
                    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
                    @Metadata
                    public /* synthetic */ class WhenMappings {
                        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

                        static {
                            int[] iArr = new int[LWAConsentStatus.values().length];
                            try {
                                iArr[LWAConsentStatus.CONSENTED.ordinal()] = 1;
                            } catch (NoSuchFieldError unused) {
                            }
                            try {
                                iArr[LWAConsentStatus.UNAVAILABLE.ordinal()] = 2;
                            } catch (NoSuchFieldError unused2) {
                            }
                            $EnumSwitchMapping$0 = iArr;
                        }
                    }

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        invoke((UserData) obj);
                        return Unit.f139807a;
                    }

                    public final void invoke(UserData userData) {
                        AmazonLWAConsentStatus amazonLWAConsentStatus;
                        Intrinsics.checkNotNullParameter(userData, "userData");
                        LWAConsentStatus lWAConsentStatus = userData.getLWAConsentStatus();
                        if (lWAConsentStatus == null) {
                            function12.invoke(new PurchasesError(PurchasesErrorCode.StoreProblemError, AmazonStrings.ERROR_USER_DATA_LWA_CONSENT_STATUS_NULL_STORE_PROBLEM));
                            return;
                        }
                        Function1<AmazonLWAConsentStatus, Unit> function14 = function1;
                        int i3 = WhenMappings.$EnumSwitchMapping$0[lWAConsentStatus.ordinal()];
                        if (i3 == 1) {
                            amazonLWAConsentStatus = AmazonLWAConsentStatus.CONSENTED;
                        } else {
                            if (i3 != 2) {
                                throw new NoWhenBranchMatchedException();
                            }
                            amazonLWAConsentStatus = AmazonLWAConsentStatus.UNAVAILABLE;
                        }
                        function14.invoke(amazonLWAConsentStatus);
                    }
                };
                final Function1<PurchasesError, Unit> function14 = onError;
                userDataResponseListener.getUserData(function13, new Function1<PurchasesError, Unit>() { // from class: com.revenuecat.purchases.amazon.AmazonBilling.getAmazonLWAConsentStatus.1.2
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
                        LogHandler currentLogHandler2 = LogWrapperKt.getCurrentLogHandler();
                        String str2 = String.format(BillingStrings.BILLING_AMAZON_ERROR_LWA_CONSENT_STATUS, Arrays.copyOf(new Object[]{error}, 1));
                        Intrinsics.checkNotNullExpressionValue(str2, "format(...)");
                        currentLogHandler2.e("[Purchases] - ERROR", str2, null);
                        function14.invoke(error);
                    }
                });
            }
        });
    }

    @Override // com.revenuecat.purchases.amazon.listener.ProductDataResponseListener
    public void getProductData(Set<String> skus, String marketplace, Function1<? super List<? extends StoreProduct>, Unit> onReceive, Function1<? super PurchasesError, Unit> onError) {
        Intrinsics.checkNotNullParameter(skus, "skus");
        Intrinsics.checkNotNullParameter(marketplace, "marketplace");
        Intrinsics.checkNotNullParameter(onReceive, "onReceive");
        Intrinsics.checkNotNullParameter(onError, "onError");
        this.productDataHandler.getProductData(skus, marketplace, onReceive, onError);
    }

    @Override // com.revenuecat.purchases.common.BillingAbstract
    public void getStorefront(final Function1<? super String, Unit> onSuccess, final Function1<? super PurchasesError, Unit> onError) {
        Intrinsics.checkNotNullParameter(onSuccess, "onSuccess");
        Intrinsics.checkNotNullParameter(onError, "onError");
        executeRequestOnUIThread(new Function1<PurchasesError, Unit>() { // from class: com.revenuecat.purchases.amazon.AmazonBilling.getStorefront.1
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

            public final void invoke(PurchasesError purchasesError) {
                if (purchasesError != null) {
                    LogHandler currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                    String str = String.format(BillingStrings.BILLING_CONNECTION_ERROR_STORE_COUNTRY, Arrays.copyOf(new Object[]{purchasesError}, 1));
                    Intrinsics.checkNotNullExpressionValue(str, "format(...)");
                    currentLogHandler.e("[Purchases] - ERROR", str, null);
                    onError.invoke(purchasesError);
                    return;
                }
                UserDataResponseListener userDataResponseListener = AmazonBilling.this.userDataHandler;
                final AmazonBilling amazonBilling = AmazonBilling.this;
                final Function1<String, Unit> function1 = onSuccess;
                final Function1<PurchasesError, Unit> function12 = onError;
                Function1<UserData, Unit> function13 = new Function1<UserData, Unit>() { // from class: com.revenuecat.purchases.amazon.AmazonBilling.getStorefront.1.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        invoke((UserData) obj);
                        return Unit.f139807a;
                    }

                    public final void invoke(UserData userData) {
                        Intrinsics.checkNotNullParameter(userData, "userData");
                        String marketplace = userData.getMarketplace();
                        if (marketplace == null) {
                            function12.invoke(new PurchasesError(PurchasesErrorCode.StoreProblemError, AmazonStrings.ERROR_USER_DATA_MARKETPLACE_NULL_STORE_PROBLEM));
                        } else {
                            function1.invoke(marketplace);
                        }
                    }
                };
                final Function1<PurchasesError, Unit> function14 = onError;
                userDataResponseListener.getUserData(function13, new Function1<PurchasesError, Unit>() { // from class: com.revenuecat.purchases.amazon.AmazonBilling.getStorefront.1.2
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
                        LogHandler currentLogHandler2 = LogWrapperKt.getCurrentLogHandler();
                        String str2 = String.format(BillingStrings.BILLING_AMAZON_ERROR_STOREFRONT, Arrays.copyOf(new Object[]{error}, 1));
                        Intrinsics.checkNotNullExpressionValue(str2, "format(...)");
                        currentLogHandler2.e("[Purchases] - ERROR", str2, null);
                        function14.invoke(error);
                    }
                });
            }
        });
    }

    @Override // com.revenuecat.purchases.amazon.listener.UserDataResponseListener
    public void getUserData(Function1<? super UserData, Unit> onSuccess, Function1<? super PurchasesError, Unit> onError) {
        Intrinsics.checkNotNullParameter(onSuccess, "onSuccess");
        Intrinsics.checkNotNullParameter(onError, "onError");
        this.userDataHandler.getUserData(onSuccess, onError);
    }

    @Override // com.revenuecat.purchases.common.BillingAbstract
    public boolean isConnected() {
        return this.connected;
    }

    @Override // com.revenuecat.purchases.common.BillingAbstract
    public void makePurchaseAsync(final Activity activity, final String appUserID, PurchasingData purchasingData, ReplaceProductInfo replaceProductInfo, final PresentedOfferingContext presentedOfferingContext, Boolean bool) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(appUserID, "appUserID");
        Intrinsics.checkNotNullParameter(purchasingData, "purchasingData");
        AmazonPurchasingData.Product product = purchasingData instanceof AmazonPurchasingData.Product ? (AmazonPurchasingData.Product) purchasingData : null;
        if (product == null) {
            PurchasesErrorCode purchasesErrorCode = PurchasesErrorCode.UnknownError;
            String str = String.format(PurchaseStrings.INVALID_PURCHASE_TYPE, Arrays.copyOf(new Object[]{"Amazon", "AmazonPurchaseInfo"}, 2));
            Intrinsics.checkNotNullExpressionValue(str, "format(...)");
            PurchasesError purchasesError = new PurchasesError(purchasesErrorCode, str);
            LogUtilsKt.errorLog(purchasesError);
            BillingAbstract.PurchasesUpdatedListener purchasesUpdatedListener = getPurchasesUpdatedListener();
            if (purchasesUpdatedListener != null) {
                purchasesUpdatedListener.onPurchasesFailedToUpdate(purchasesError);
            }
            return;
        }
        final AmazonStoreProduct storeProduct = product.getStoreProduct();
        if (shouldFinishTransactions()) {
            if (replaceProductInfo == null) {
                executeRequestOnUIThread(new Function1<PurchasesError, Unit>() { // from class: com.revenuecat.purchases.amazon.AmazonBilling.makePurchaseAsync.2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        invoke((PurchasesError) obj);
                        return Unit.f139807a;
                    }

                    public final void invoke(PurchasesError purchasesError2) {
                        if (purchasesError2 != null) {
                            AmazonBilling.this.onPurchaseError(purchasesError2);
                            return;
                        }
                        PurchaseResponseListener purchaseResponseListener = AmazonBilling.this.purchaseHandler;
                        Handler handler = AmazonBilling.this.mainHandler;
                        Activity activity2 = activity;
                        String str2 = appUserID;
                        final AmazonStoreProduct amazonStoreProduct = storeProduct;
                        final AmazonBilling amazonBilling = AmazonBilling.this;
                        final PresentedOfferingContext presentedOfferingContext2 = presentedOfferingContext;
                        Function2<? super Receipt, ? super UserData, Unit> function2 = new Function2<Receipt, UserData, Unit>() { // from class: com.revenuecat.purchases.amazon.AmazonBilling.makePurchaseAsync.2.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                                invoke((Receipt) obj, (UserData) obj2);
                                return Unit.f139807a;
                            }

                            public final void invoke(Receipt receipt, UserData userData) {
                                Intrinsics.checkNotNullParameter(receipt, "receipt");
                                Intrinsics.checkNotNullParameter(userData, "userData");
                                amazonBilling.handleReceipt(receipt, userData, amazonStoreProduct, presentedOfferingContext2);
                            }
                        };
                        final AmazonBilling amazonBilling2 = AmazonBilling.this;
                        purchaseResponseListener.purchase(handler, activity2, str2, amazonStoreProduct, function2, new Function1<PurchasesError, Unit>() { // from class: com.revenuecat.purchases.amazon.AmazonBilling.makePurchaseAsync.2.2
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
                                amazonBilling2.onPurchaseError(it);
                            }
                        });
                    }
                });
                return;
            }
            final LogIntent logIntent = LogIntent.AMAZON_WARNING;
            Function0<String> function0 = new Function0<String>() { // from class: com.revenuecat.purchases.amazon.AmazonBilling$makePurchaseAsync$$inlined$log$1
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return CollectionsKt.joinToString$default(logIntent.getEmojiList(), "", null, null, 0, null, null, 62, null) + ' ' + AmazonStrings.PRODUCT_CHANGES_NOT_SUPPORTED;
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
    }

    @Override // com.revenuecat.purchases.common.BillingAbstract
    public void normalizePurchaseData(String productID, final String purchaseToken, String storeUserID, final Function1<? super String, Unit> onSuccess, final Function1<? super PurchasesError, Unit> onError) {
        Intrinsics.checkNotNullParameter(productID, "productID");
        Intrinsics.checkNotNullParameter(purchaseToken, "purchaseToken");
        Intrinsics.checkNotNullParameter(storeUserID, "storeUserID");
        Intrinsics.checkNotNullParameter(onSuccess, "onSuccess");
        Intrinsics.checkNotNullParameter(onError, "onError");
        String str = this.cache.getReceiptSkus().get(purchaseToken);
        if (str != null) {
            onSuccess.invoke(str);
        } else {
            this.amazonBackend.getAmazonReceiptData(purchaseToken, storeUserID, new Function1<JSONObject, Unit>() { // from class: com.revenuecat.purchases.amazon.AmazonBilling.normalizePurchaseData.2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke((JSONObject) obj);
                    return Unit.f139807a;
                }

                public final void invoke(final JSONObject response) {
                    LogHandler currentLogHandler;
                    String str2;
                    String str3;
                    Intrinsics.checkNotNullParameter(response, "response");
                    final LogIntent logIntent = LogIntent.DEBUG;
                    Function0<String> function0 = new Function0<String>() { // from class: com.revenuecat.purchases.amazon.AmazonBilling$normalizePurchaseData$2$invoke$$inlined$log$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public final String invoke() {
                            StringBuilder sb = new StringBuilder();
                            sb.append(CollectionsKt.joinToString$default(logIntent.getEmojiList(), "", null, null, 0, null, null, 62, null));
                            sb.append(' ');
                            String str4 = String.format(AmazonStrings.RECEIPT_DATA_RECEIVED, Arrays.copyOf(new Object[]{response.toString()}, 1));
                            Intrinsics.checkNotNullExpressionValue(str4, "format(...)");
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
                    String termSkuFromJSON = AmazonBilling.this.getTermSkuFromJSON(response);
                    if (termSkuFromJSON == null) {
                        onError.invoke(ErrorsKt.missingTermSkuError(response));
                    } else {
                        AmazonBilling.this.cache.cacheSkusByToken(MapsKt.mapOf(TuplesKt.a(purchaseToken, termSkuFromJSON)));
                        onSuccess.invoke(termSkuFromJSON);
                    }
                }
            }, new Function1<PurchasesError, Unit>() { // from class: com.revenuecat.purchases.amazon.AmazonBilling.normalizePurchaseData.3
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
                    onError.invoke(ErrorsKt.errorGettingReceiptInfo(error));
                }
            });
        }
    }

    @Override // com.revenuecat.purchases.amazon.listener.PurchaseResponseListener, com.revenuecat.purchases.amazon.listener.PurchaseUpdatesResponseListener, com.revenuecat.purchases.amazon.listener.UserDataResponseListener
    public void onProductDataResponse(ProductDataResponse response) {
        Intrinsics.checkNotNullParameter(response, "response");
        if (shouldFinishTransactions()) {
            this.productDataHandler.onProductDataResponse(response);
        }
    }

    @Override // com.revenuecat.purchases.amazon.listener.ProductDataResponseListener, com.revenuecat.purchases.amazon.listener.PurchaseUpdatesResponseListener, com.revenuecat.purchases.amazon.listener.UserDataResponseListener
    public void onPurchaseResponse(PurchaseResponse response) {
        Intrinsics.checkNotNullParameter(response, "response");
        if (shouldFinishTransactions()) {
            this.purchaseHandler.onPurchaseResponse(response);
        }
    }

    @Override // com.revenuecat.purchases.amazon.listener.ProductDataResponseListener, com.revenuecat.purchases.amazon.listener.PurchaseResponseListener, com.revenuecat.purchases.amazon.listener.UserDataResponseListener
    public void onPurchaseUpdatesResponse(PurchaseUpdatesResponse response) {
        Intrinsics.checkNotNullParameter(response, "response");
        if (shouldFinishTransactions()) {
            this.purchaseUpdatesHandler.onPurchaseUpdatesResponse(response);
        }
    }

    @Override // com.revenuecat.purchases.amazon.listener.ProductDataResponseListener, com.revenuecat.purchases.amazon.listener.PurchaseResponseListener, com.revenuecat.purchases.amazon.listener.PurchaseUpdatesResponseListener
    public void onUserDataResponse(UserDataResponse response) {
        Intrinsics.checkNotNullParameter(response, "response");
        if (shouldFinishTransactions()) {
            this.userDataHandler.onUserDataResponse(response);
        }
    }

    @Override // com.revenuecat.purchases.amazon.listener.PurchaseResponseListener
    public void purchase(Handler mainHandler, Activity activity, String appUserID, StoreProduct storeProduct, Function2<? super Receipt, ? super UserData, Unit> onSuccess, Function1<? super PurchasesError, Unit> onError) {
        Intrinsics.checkNotNullParameter(mainHandler, "mainHandler");
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(appUserID, "appUserID");
        Intrinsics.checkNotNullParameter(storeProduct, "storeProduct");
        Intrinsics.checkNotNullParameter(onSuccess, "onSuccess");
        Intrinsics.checkNotNullParameter(onError, "onError");
        this.purchaseHandler.purchase(mainHandler, activity, appUserID, storeProduct, onSuccess, onError);
    }

    @Override // com.revenuecat.purchases.common.BillingAbstract
    public void queryAllPurchases(String appUserID, final Function1<? super List<StoreTransaction>, Unit> onReceivePurchaseHistory, Function1<? super PurchasesError, Unit> onReceivePurchaseHistoryError) {
        Intrinsics.checkNotNullParameter(appUserID, "appUserID");
        Intrinsics.checkNotNullParameter(onReceivePurchaseHistory, "onReceivePurchaseHistory");
        Intrinsics.checkNotNullParameter(onReceivePurchaseHistoryError, "onReceivePurchaseHistoryError");
        queryPurchases(false, (Function1<? super Map<String, StoreTransaction>, Unit>) new Function1<Map<String, ? extends StoreTransaction>, Unit>() { // from class: com.revenuecat.purchases.amazon.AmazonBilling.queryAllPurchases.1
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

            public final void invoke(Map<String, StoreTransaction> it) {
                Intrinsics.checkNotNullParameter(it, "it");
                onReceivePurchaseHistory.invoke(CollectionsKt.toList(it.values()));
            }
        }, onReceivePurchaseHistoryError);
    }

    @Override // com.revenuecat.purchases.common.BillingAbstract
    public void queryProductDetailsAsync(com.revenuecat.purchases.ProductType productType, final Set<String> productIds, final Function1<? super List<? extends StoreProduct>, Unit> onReceive, final Function1<? super PurchasesError, Unit> onError) {
        Intrinsics.checkNotNullParameter(productType, "productType");
        Intrinsics.checkNotNullParameter(productIds, "productIds");
        Intrinsics.checkNotNullParameter(onReceive, "onReceive");
        Intrinsics.checkNotNullParameter(onError, "onError");
        if (shouldFinishTransactions()) {
            executeRequestOnUIThread(new Function1<PurchasesError, Unit>() { // from class: com.revenuecat.purchases.amazon.AmazonBilling.queryProductDetailsAsync.1
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

                public final void invoke(PurchasesError purchasesError) {
                    if (purchasesError != null) {
                        onError.invoke(purchasesError);
                        return;
                    }
                    UserDataResponseListener userDataResponseListener = AmazonBilling.this.userDataHandler;
                    final AmazonBilling amazonBilling = AmazonBilling.this;
                    final Set<String> set = productIds;
                    final Function1<List<? extends StoreProduct>, Unit> function1 = onReceive;
                    final Function1<PurchasesError, Unit> function12 = onError;
                    userDataResponseListener.getUserData(new Function1<UserData, Unit>() { // from class: com.revenuecat.purchases.amazon.AmazonBilling.queryProductDetailsAsync.1.1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                            invoke((UserData) obj);
                            return Unit.f139807a;
                        }

                        public final void invoke(UserData userData) {
                            Intrinsics.checkNotNullParameter(userData, "userData");
                            final Date now = amazonBilling.dateProvider.getNow();
                            ProductDataResponseListener productDataResponseListener = amazonBilling.productDataHandler;
                            Set<String> set2 = set;
                            String marketplace = userData.getMarketplace();
                            Intrinsics.checkNotNullExpressionValue(marketplace, "userData.marketplace");
                            final AmazonBilling amazonBilling2 = amazonBilling;
                            final Set<String> set3 = set;
                            final Function1<List<? extends StoreProduct>, Unit> function13 = function1;
                            Function1<List<? extends StoreProduct>, Unit> function14 = new Function1<List<? extends StoreProduct>, Unit>() { // from class: com.revenuecat.purchases.amazon.AmazonBilling.queryProductDetailsAsync.1.1.1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                    invoke((List<? extends StoreProduct>) obj);
                                    return Unit.f139807a;
                                }

                                public final void invoke(List<? extends StoreProduct> it) {
                                    Intrinsics.checkNotNullParameter(it, "it");
                                    amazonBilling2.trackAmazonQueryProductDetailsRequestIfNeeded(true, now, set3);
                                    function13.invoke(it);
                                }
                            };
                            final AmazonBilling amazonBilling3 = amazonBilling;
                            final Set<String> set4 = set;
                            final Function1<PurchasesError, Unit> function15 = function12;
                            productDataResponseListener.getProductData(set2, marketplace, function14, new Function1<PurchasesError, Unit>() { // from class: com.revenuecat.purchases.amazon.AmazonBilling.queryProductDetailsAsync.1.1.2
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
                                    amazonBilling3.trackAmazonQueryProductDetailsRequestIfNeeded(false, now, set4);
                                    function15.invoke(it);
                                }
                            });
                        }
                    }, onError);
                }
            });
        }
    }

    @Override // com.revenuecat.purchases.amazon.listener.PurchaseUpdatesResponseListener
    public void queryPurchases(Function2<? super List<Receipt>, ? super UserData, Unit> onSuccess, Function1<? super PurchasesError, Unit> onError) {
        Intrinsics.checkNotNullParameter(onSuccess, "onSuccess");
        Intrinsics.checkNotNullParameter(onError, "onError");
        this.purchaseUpdatesHandler.queryPurchases(onSuccess, onError);
    }

    @Override // com.revenuecat.purchases.common.BillingAbstract
    public void showInAppMessagesIfNeeded(Activity activity, List<? extends InAppMessageType> inAppMessageTypes, Function0<Unit> subscriptionStatusChange) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(inAppMessageTypes, "inAppMessageTypes");
        Intrinsics.checkNotNullParameter(subscriptionStatusChange, "subscriptionStatusChange");
    }

    @Override // com.revenuecat.purchases.common.BillingAbstract
    public void startConnection(long j3) {
        runOnUIThread(new Runnable() { // from class: com.revenuecat.purchases.amazon.b
            @Override // java.lang.Runnable
            public final void run() {
                this.f92239a.performStartConnection();
            }
        });
    }

    @Override // com.revenuecat.purchases.common.BillingAbstract
    public void queryPurchases(String appUserID, Function1<? super Map<String, StoreTransaction>, Unit> onSuccess, Function1<? super PurchasesError, Unit> onError) {
        Intrinsics.checkNotNullParameter(appUserID, "appUserID");
        Intrinsics.checkNotNullParameter(onSuccess, "onSuccess");
        Intrinsics.checkNotNullParameter(onError, "onError");
        if (shouldFinishTransactions()) {
            queryPurchases(true, onSuccess, onError);
        }
    }

    private final void queryPurchases(final boolean z2, final Function1<? super Map<String, StoreTransaction>, Unit> function1, final Function1<? super PurchasesError, Unit> function12) {
        executeRequestOnUIThread(new Function1<PurchasesError, Unit>() { // from class: com.revenuecat.purchases.amazon.AmazonBilling.queryPurchases.1
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

            public final void invoke(PurchasesError purchasesError) {
                if (purchasesError != null) {
                    function12.invoke(purchasesError);
                    return;
                }
                final Date now = AmazonBilling.this.dateProvider.getNow();
                PurchaseUpdatesResponseListener purchaseUpdatesResponseListener = AmazonBilling.this.purchaseUpdatesHandler;
                final AmazonBilling amazonBilling = AmazonBilling.this;
                final boolean z3 = z2;
                final Function1<Map<String, StoreTransaction>, Unit> function13 = function1;
                final Function1<PurchasesError, Unit> function14 = function12;
                Function2<List<? extends Receipt>, UserData, Unit> function2 = new Function2<List<? extends Receipt>, UserData, Unit>() { // from class: com.revenuecat.purchases.amazon.AmazonBilling.queryPurchases.1.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                        invoke((List<Receipt>) obj, (UserData) obj2);
                        return Unit.f139807a;
                    }

                    public final void invoke(List<Receipt> receipts, final UserData userData) {
                        final List list;
                        Intrinsics.checkNotNullParameter(receipts, "receipts");
                        Intrinsics.checkNotNullParameter(userData, "userData");
                        amazonBilling.trackAmazonQueryPurchasesRequestIfNeeded(true, now, receipts);
                        if (z3) {
                            AmazonBilling amazonBilling2 = amazonBilling;
                            ArrayList arrayList = new ArrayList();
                            for (Object obj : receipts) {
                                Receipt receipt = (Receipt) obj;
                                if (receipt.getCancelDate() == null || receipt.getCancelDate().compareTo(amazonBilling2.dateProvider.getNow()) > 0) {
                                    arrayList.add(obj);
                                }
                            }
                            list = arrayList;
                        } else {
                            list = receipts;
                        }
                        if (list.isEmpty()) {
                            function13.invoke(MapsKt.emptyMap());
                            return;
                        }
                        AmazonBilling amazonBilling3 = amazonBilling;
                        String userId = userData.getUserId();
                        Intrinsics.checkNotNullExpressionValue(userId, "userData.userId");
                        final AmazonBilling amazonBilling4 = amazonBilling;
                        final Function1<PurchasesError, Unit> function15 = function14;
                        final Function1<Map<String, StoreTransaction>, Unit> function16 = function13;
                        amazonBilling3.getMissingSkusForReceipts(userId, list, new Function2<Map<String, ? extends String>, Map<String, ? extends PurchasesError>, Unit>() { // from class: com.revenuecat.purchases.amazon.AmazonBilling.queryPurchases.1.1.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Object invoke(Object obj2, Object obj3) {
                                invoke((Map<String, String>) obj2, (Map<String, PurchasesError>) obj3);
                                return Unit.f139807a;
                            }

                            public final void invoke(Map<String, String> tokensToSkusMap, Map<String, PurchasesError> errors) {
                                Intrinsics.checkNotNullParameter(tokensToSkusMap, "tokensToSkusMap");
                                Intrinsics.checkNotNullParameter(errors, "errors");
                                amazonBilling4.logErrorsIfAny(errors);
                                if (tokensToSkusMap.isEmpty()) {
                                    function15.invoke(new PurchasesError(PurchasesErrorCode.InvalidReceiptError, AmazonStrings.ERROR_FETCHING_PURCHASE_HISTORY_ALL_RECEIPTS_INVALID));
                                } else {
                                    function16.invoke(amazonBilling4.toMapOfReceiptHashesToRestoredPurchases(list, tokensToSkusMap, userData));
                                }
                            }
                        });
                    }
                };
                final AmazonBilling amazonBilling2 = AmazonBilling.this;
                final Function1<PurchasesError, Unit> function15 = function12;
                purchaseUpdatesResponseListener.queryPurchases(function2, new Function1<PurchasesError, Unit>() { // from class: com.revenuecat.purchases.amazon.AmazonBilling.queryPurchases.1.2
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
                        amazonBilling2.trackAmazonQueryPurchasesRequestIfNeeded(false, now, null);
                        function15.invoke(it);
                    }
                });
            }
        });
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AmazonBilling(Context applicationContext, AmazonBackend amazonBackend, AmazonCache cache, boolean z2, Handler mainHandler, PurchasesStateProvider stateProvider, DiagnosticsTracker diagnosticsTracker, PurchasingServiceProvider purchasingServiceProvider, ProductDataResponseListener productDataHandler, PurchaseResponseListener purchaseHandler, PurchaseUpdatesResponseListener purchaseUpdatesHandler, UserDataResponseListener userDataHandler, DateProvider dateProvider) {
        super(stateProvider);
        Intrinsics.checkNotNullParameter(applicationContext, "applicationContext");
        Intrinsics.checkNotNullParameter(amazonBackend, "amazonBackend");
        Intrinsics.checkNotNullParameter(cache, "cache");
        Intrinsics.checkNotNullParameter(mainHandler, "mainHandler");
        Intrinsics.checkNotNullParameter(stateProvider, "stateProvider");
        Intrinsics.checkNotNullParameter(purchasingServiceProvider, sKeKFMqmvNzY.EbaipQTxE);
        Intrinsics.checkNotNullParameter(productDataHandler, "productDataHandler");
        Intrinsics.checkNotNullParameter(purchaseHandler, "purchaseHandler");
        Intrinsics.checkNotNullParameter(purchaseUpdatesHandler, "purchaseUpdatesHandler");
        Intrinsics.checkNotNullParameter(userDataHandler, "userDataHandler");
        Intrinsics.checkNotNullParameter(dateProvider, "dateProvider");
        this.applicationContext = applicationContext;
        this.amazonBackend = amazonBackend;
        this.cache = cache;
        this.finishTransactions = z2;
        this.mainHandler = mainHandler;
        this.diagnosticsTrackerIfEnabled = diagnosticsTracker;
        this.purchasingServiceProvider = purchasingServiceProvider;
        this.productDataHandler = productDataHandler;
        this.purchaseHandler = purchaseHandler;
        this.purchaseUpdatesHandler = purchaseUpdatesHandler;
        this.userDataHandler = userDataHandler;
        this.dateProvider = dateProvider;
        this.serviceRequests = new ConcurrentLinkedQueue<>();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public AmazonBilling(Context applicationContext, DeviceCache cache, boolean z2, Handler mainHandler, BackendHelper backendHelper, PurchasesStateProvider stateProvider, DiagnosticsTracker diagnosticsTracker) {
        this(applicationContext, new AmazonBackend(backendHelper), new AmazonCache(cache), z2, mainHandler, stateProvider, diagnosticsTracker, null, null, null, null, null, null, 8064, null);
        Intrinsics.checkNotNullParameter(applicationContext, "applicationContext");
        Intrinsics.checkNotNullParameter(cache, "cache");
        Intrinsics.checkNotNullParameter(mainHandler, "mainHandler");
        Intrinsics.checkNotNullParameter(backendHelper, "backendHelper");
        Intrinsics.checkNotNullParameter(stateProvider, "stateProvider");
    }
}
