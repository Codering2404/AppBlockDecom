package com.revenuecat.purchases.amazon.handler;

import android.os.Handler;
import com.amazon.device.iap.model.Product;
import com.amazon.device.iap.model.ProductDataResponse;
import com.amazon.device.iap.model.RequestId;
import com.google.android.gms.ads_identifier.mrU.pMpIcGE;
import com.google.android.material.bottomsheet.lKiE.YznnJpHcAmeoW;
import com.revenuecat.purchases.LogHandler;
import com.revenuecat.purchases.LogLevel;
import com.revenuecat.purchases.PurchasesError;
import com.revenuecat.purchases.PurchasesErrorCode;
import com.revenuecat.purchases.amazon.AmazonStrings;
import com.revenuecat.purchases.amazon.PurchasingServiceProvider;
import com.revenuecat.purchases.amazon.StoreProductConversionsKt;
import com.revenuecat.purchases.amazon.listener.ProductDataResponseListener;
import com.revenuecat.purchases.common.Config;
import com.revenuecat.purchases.common.LogIntent;
import com.revenuecat.purchases.common.LogWrapperKt;
import com.revenuecat.purchases.models.StoreProduct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
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
public final class ProductDataHandler implements ProductDataResponseListener {
    public static final Companion Companion = new Companion(null);
    private static final long GET_PRODUCT_DATA_TIMEOUT_MILLIS = 10000;
    private final Handler mainHandler;
    private final Map<String, Product> productDataCache;
    private final Map<RequestId, Request> productDataRequests;
    private final PurchasingServiceProvider purchasingServiceProvider;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    private static final class Request {
        private final String marketplace;
        private final Function1<PurchasesError, Unit> onError;
        private final Function1<List<? extends StoreProduct>, Unit> onReceive;
        private final List<String> skuList;

        /* JADX WARN: Multi-variable type inference failed */
        public Request(List<String> skuList, String marketplace, Function1<? super List<? extends StoreProduct>, Unit> onReceive, Function1<? super PurchasesError, Unit> onError) {
            Intrinsics.checkNotNullParameter(skuList, "skuList");
            Intrinsics.checkNotNullParameter(marketplace, "marketplace");
            Intrinsics.checkNotNullParameter(onReceive, "onReceive");
            Intrinsics.checkNotNullParameter(onError, "onError");
            this.skuList = skuList;
            this.marketplace = marketplace;
            this.onReceive = onReceive;
            this.onError = onError;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Request copy$default(Request request, List list, String str, Function1 function1, Function1 function12, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                list = request.skuList;
            }
            if ((i3 & 2) != 0) {
                str = request.marketplace;
            }
            if ((i3 & 4) != 0) {
                function1 = request.onReceive;
            }
            if ((i3 & 8) != 0) {
                function12 = request.onError;
            }
            return request.copy(list, str, function1, function12);
        }

        public final List<String> component1() {
            return this.skuList;
        }

        public final String component2() {
            return this.marketplace;
        }

        public final Function1<List<? extends StoreProduct>, Unit> component3() {
            return this.onReceive;
        }

        public final Function1<PurchasesError, Unit> component4() {
            return this.onError;
        }

        public final Request copy(List<String> skuList, String marketplace, Function1<? super List<? extends StoreProduct>, Unit> onReceive, Function1<? super PurchasesError, Unit> onError) {
            Intrinsics.checkNotNullParameter(skuList, "skuList");
            Intrinsics.checkNotNullParameter(marketplace, "marketplace");
            Intrinsics.checkNotNullParameter(onReceive, "onReceive");
            Intrinsics.checkNotNullParameter(onError, "onError");
            return new Request(skuList, marketplace, onReceive, onError);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Request)) {
                return false;
            }
            Request request = (Request) obj;
            return Intrinsics.areEqual(this.skuList, request.skuList) && Intrinsics.areEqual(this.marketplace, request.marketplace) && Intrinsics.areEqual(this.onReceive, request.onReceive) && Intrinsics.areEqual(this.onError, request.onError);
        }

        public final String getMarketplace() {
            return this.marketplace;
        }

        public final Function1<PurchasesError, Unit> getOnError() {
            return this.onError;
        }

        public final Function1<List<? extends StoreProduct>, Unit> getOnReceive() {
            return this.onReceive;
        }

        public final List<String> getSkuList() {
            return this.skuList;
        }

        public int hashCode() {
            return (((((this.skuList.hashCode() * 31) + this.marketplace.hashCode()) * 31) + this.onReceive.hashCode()) * 31) + this.onError.hashCode();
        }

        public String toString() {
            return "Request(skuList=" + this.skuList + ", marketplace=" + this.marketplace + ", onReceive=" + this.onReceive + ", onError=" + this.onError + ')';
        }
    }

    public ProductDataHandler(PurchasingServiceProvider purchasingServiceProvider, Handler mainHandler) {
        Intrinsics.checkNotNullParameter(purchasingServiceProvider, "purchasingServiceProvider");
        Intrinsics.checkNotNullParameter(mainHandler, "mainHandler");
        this.purchasingServiceProvider = purchasingServiceProvider;
        this.mainHandler = mainHandler;
        this.productDataRequests = new LinkedHashMap();
        this.productDataCache = new LinkedHashMap();
    }

    private final void addTimeoutToProductDataRequest(final RequestId requestId) {
        this.mainHandler.postDelayed(new Runnable() { // from class: com.revenuecat.purchases.amazon.handler.a
            @Override // java.lang.Runnable
            public final void run() {
                ProductDataHandler.addTimeoutToProductDataRequest$lambda$12(this.f92240a, requestId);
            }
        }, 10000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void addTimeoutToProductDataRequest$lambda$12(ProductDataHandler productDataHandler, RequestId requestId) {
        Request request = productDataHandler.getRequest(requestId);
        if (request == null) {
            return;
        }
        PurchasesErrorCode purchasesErrorCode = PurchasesErrorCode.UnknownError;
        String str = String.format(AmazonStrings.ERROR_TIMEOUT_GETTING_PRODUCT_DATA, Arrays.copyOf(new Object[]{request.getSkuList().toString()}, 1));
        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        request.getOnError().invoke(new PurchasesError(purchasesErrorCode, str));
    }

    private final synchronized Request getRequest(RequestId requestId) {
        return this.productDataRequests.remove(requestId);
    }

    private final void handleSuccessfulProductDataResponse(final Map<String, Product> map, String str, Function1<? super List<? extends StoreProduct>, Unit> function1) {
        LogHandler currentLogHandler;
        String str2;
        String str3;
        final LogIntent logIntent = LogIntent.DEBUG;
        Function0<String> function0 = new Function0<String>() { // from class: com.revenuecat.purchases.amazon.handler.ProductDataHandler$handleSuccessfulProductDataResponse$$inlined$log$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                StringBuilder sb = new StringBuilder();
                sb.append(CollectionsKt.joinToString$default(logIntent.getEmojiList(), "", null, null, 0, null, null, 62, null));
                sb.append(' ');
                String str4 = String.format(AmazonStrings.RETRIEVED_PRODUCT_DATA, Arrays.copyOf(new Object[]{map}, 1));
                Intrinsics.checkNotNullExpressionValue(str4, "format(...)");
                sb.append(str4);
                return sb.toString();
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
        if (map.isEmpty()) {
            Function0<String> function02 = new Function0<String>() { // from class: com.revenuecat.purchases.amazon.handler.ProductDataHandler$handleSuccessfulProductDataResponse$$inlined$log$2
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return CollectionsKt.joinToString$default(logIntent.getEmojiList(), "", null, null, 0, null, null, 62, null) + ' ' + AmazonStrings.RETRIEVED_PRODUCT_DATA_EMPTY;
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
        }
        Collection<Product> collectionValues = map.values();
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = collectionValues.iterator();
        while (it.hasNext()) {
            StoreProduct storeProduct = StoreProductConversionsKt.toStoreProduct((Product) it.next(), str);
            if (storeProduct != null) {
                arrayList.add(storeProduct);
            }
        }
        function1.invoke(arrayList);
    }

    private final void handleUnsuccessfulProductDataResponse(ProductDataResponse productDataResponse, Function1<? super PurchasesError, Unit> function1) {
        function1.invoke(new PurchasesError(PurchasesErrorCode.StoreProblemError, productDataResponse.getRequestStatus() == ProductDataResponse.RequestStatus.NOT_SUPPORTED ? "Couldn't fetch product data, since it's not supported." : "Error when fetching product data."));
    }

    public final synchronized Map<String, Product> getProductDataCache$purchases_defaultsBc8Release() {
        return this.productDataCache;
    }

    public void onProductDataResponse(final ProductDataResponse response) throws Exception {
        LogHandler currentLogHandler;
        String str;
        String str2;
        Intrinsics.checkNotNullParameter(response, "response");
        try {
            final LogIntent logIntent = LogIntent.DEBUG;
            Function0<String> function0 = new Function0<String>() { // from class: com.revenuecat.purchases.amazon.handler.ProductDataHandler$onProductDataResponse$$inlined$log$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    StringBuilder sb = new StringBuilder();
                    sb.append(CollectionsKt.joinToString$default(logIntent.getEmojiList(), "", null, null, 0, null, null, 62, null));
                    sb.append(' ');
                    String str3 = String.format(AmazonStrings.PRODUCTS_REQUEST_FINISHED, Arrays.copyOf(new Object[]{response.getRequestStatus().name()}, 1));
                    Intrinsics.checkNotNullExpressionValue(str3, "format(...)");
                    sb.append(str3);
                    return sb.toString();
                }
            };
            int[] iArr = LogWrapperKt.WhenMappings.$EnumSwitchMapping$0;
            switch (iArr[logIntent.ordinal()]) {
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
            Set unavailableSkus = response.getUnavailableSkus();
            Intrinsics.checkNotNullExpressionValue(unavailableSkus, "response.unavailableSkus");
            if (!unavailableSkus.isEmpty()) {
                Function0<String> function02 = new Function0<String>() { // from class: com.revenuecat.purchases.amazon.handler.ProductDataHandler$onProductDataResponse$$inlined$log$2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final String invoke() {
                        StringBuilder sb = new StringBuilder();
                        sb.append(CollectionsKt.joinToString$default(logIntent.getEmojiList(), "", null, null, 0, null, null, 62, null));
                        sb.append(' ');
                        String str3 = String.format(AmazonStrings.PRODUCTS_REQUEST_UNAVAILABLE, Arrays.copyOf(new Object[]{response.getUnavailableSkus()}, 1));
                        Intrinsics.checkNotNullExpressionValue(str3, "format(...)");
                        sb.append(str3);
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
            }
            RequestId requestId = response.getRequestId();
            Intrinsics.checkNotNullExpressionValue(requestId, "requestId");
            Request request = getRequest(requestId);
            if (request == null) {
                return;
            }
            if (response.getRequestStatus() != ProductDataResponse.RequestStatus.SUCCESSFUL) {
                handleUnsuccessfulProductDataResponse(response, request.getOnError());
                return;
            }
            synchronized (this) {
                Map<String, Product> map = this.productDataCache;
                Map<? extends String, ? extends Product> productData = response.getProductData();
                Intrinsics.checkNotNullExpressionValue(productData, "response.productData");
                map.putAll(productData);
                Unit unit = Unit.f139807a;
            }
            Map<String, Product> productData2 = response.getProductData();
            Intrinsics.checkNotNullExpressionValue(productData2, "response.productData");
            handleSuccessfulProductDataResponse(productData2, request.getMarketplace(), request.getOnReceive());
        } catch (Exception e3) {
            LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", "Exception in onProductDataResponse", e3);
            throw e3;
        }
    }

    @Override // com.revenuecat.purchases.amazon.listener.ProductDataResponseListener
    public void getProductData(final Set<String> skus, String marketplace, Function1<? super List<? extends StoreProduct>, Unit> onReceive, Function1<? super PurchasesError, Unit> onError) {
        Map map;
        LogHandler currentLogHandler;
        String str;
        String str2;
        Intrinsics.checkNotNullParameter(skus, "skus");
        Intrinsics.checkNotNullParameter(marketplace, "marketplace");
        Intrinsics.checkNotNullParameter(onReceive, "onReceive");
        Intrinsics.checkNotNullParameter(onError, "onError");
        final LogIntent logIntent = LogIntent.DEBUG;
        Function0<String> function0 = new Function0<String>() { // from class: com.revenuecat.purchases.amazon.handler.ProductDataHandler$getProductData$$inlined$log$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                StringBuilder sb = new StringBuilder();
                sb.append(CollectionsKt.joinToString$default(logIntent.getEmojiList(), "", null, null, 0, null, null, 62, null));
                sb.append(' ');
                String str3 = String.format(YznnJpHcAmeoW.UPNyxnaiS, Arrays.copyOf(new Object[]{CollectionsKt.joinToString$default(skus, null, null, null, 0, null, null, 63, null)}, 1));
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
                LogWrapperKt.getCurrentLogHandler().e(pMpIcGE.xHWVR, (String) function0.invoke(), null);
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
                LogWrapperKt.getCurrentLogHandler().e(pMpIcGE.xHWVR, (String) function0.invoke(), null);
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
                LogWrapperKt.getCurrentLogHandler().e(pMpIcGE.xHWVR, (String) function0.invoke(), null);
                break;
            case 13:
                LogLevel logLevel10 = LogLevel.WARN;
                LogHandler currentLogHandler7 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel10) <= 0) {
                    currentLogHandler7.w("[Purchases] - " + logLevel10.name(), (String) function0.invoke());
                }
                break;
            case 14:
                LogWrapperKt.getCurrentLogHandler().e(pMpIcGE.xHWVR, (String) function0.invoke(), null);
                break;
        }
        synchronized (this) {
            map = MapsKt.toMap(this.productDataCache);
        }
        if (!map.keySet().containsAll(skus)) {
            RequestId productData = this.purchasingServiceProvider.getProductData(skus);
            Request request = new Request(CollectionsKt.toList(skus), marketplace, onReceive, onError);
            synchronized (this) {
                this.productDataRequests.put(productData, request);
                addTimeoutToProductDataRequest(productData);
                Unit unit = Unit.f139807a;
            }
            return;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry entry : map.entrySet()) {
            if (skus.contains((String) entry.getKey())) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
        }
        handleSuccessfulProductDataResponse(linkedHashMap, marketplace, onReceive);
    }
}
