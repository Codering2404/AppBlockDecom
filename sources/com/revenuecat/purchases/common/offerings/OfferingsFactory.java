package com.revenuecat.purchases.common.offerings;

import com.revenuecat.purchases.LogHandler;
import com.revenuecat.purchases.LogLevel;
import com.revenuecat.purchases.Offerings;
import com.revenuecat.purchases.ProductType;
import com.revenuecat.purchases.PurchasesError;
import com.revenuecat.purchases.PurchasesErrorCode;
import com.revenuecat.purchases.common.AppConfig;
import com.revenuecat.purchases.common.BillingAbstract;
import com.revenuecat.purchases.common.Config;
import com.revenuecat.purchases.common.Dispatcher;
import com.revenuecat.purchases.common.HTTPResponseOriginalSource;
import com.revenuecat.purchases.common.LogIntent;
import com.revenuecat.purchases.common.LogWrapperKt;
import com.revenuecat.purchases.common.OfferingParser;
import com.revenuecat.purchases.common.offerings.OfferingsFactory;
import com.revenuecat.purchases.models.StoreProduct;
import com.revenuecat.purchases.strings.OfferingStrings;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.text.StringsKt;
import kotlinx.serialization.SerializationException;
import org.json.JSONArray;
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
/* JADX INFO: loaded from: classes5.dex */
@Metadata
public final class OfferingsFactory {
    private final AppConfig appConfig;
    private final BillingAbstract billing;
    private final Dispatcher dispatcher;
    private final OfferingParser offeringParser;

    /* JADX INFO: renamed from: com.revenuecat.purchases.common.offerings.OfferingsFactory$getStoreProductsById$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    static final class C23421 extends Lambda implements Function1<List<? extends StoreProduct>, Unit> {
        final /* synthetic */ Function1<Map<String, ? extends List<? extends StoreProduct>>, Unit> $onCompleted;
        final /* synthetic */ Function1<PurchasesError, Unit> $onError;
        final /* synthetic */ Set<String> $productIds;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        C23421(Set<String> set, Function1<? super Map<String, ? extends List<? extends StoreProduct>>, Unit> function1, Function1<? super PurchasesError, Unit> function12) {
            super(1);
            this.$productIds = set;
            this.$onCompleted = function1;
            this.$onError = function12;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void invoke$lambda$1(List list, Set set, OfferingsFactory offeringsFactory, Function1 function1, final Function1 function12) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (Object obj : list) {
                String productId = ((StoreProduct) obj).getPurchasingData().getProductId();
                Object arrayList = linkedHashMap.get(productId);
                if (arrayList == null) {
                    arrayList = new ArrayList();
                    linkedHashMap.put(productId, arrayList);
                }
                ((List) arrayList).add(obj);
            }
            Map mutableMap = MapsKt.toMutableMap(linkedHashMap);
            Set<String> setMinus = SetsKt.minus(set, (Iterable) mutableMap.keySet());
            if (setMinus.isEmpty()) {
                function1.invoke(mutableMap);
            } else {
                offeringsFactory.billing.queryProductDetailsAsync(ProductType.INAPP, setMinus, new OfferingsFactory$getStoreProductsById$1$1$1(offeringsFactory, mutableMap, function1), new Function1<PurchasesError, Unit>() { // from class: com.revenuecat.purchases.common.offerings.OfferingsFactory$getStoreProductsById$1$1$2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Object invoke(Object obj2) {
                        invoke((PurchasesError) obj2);
                        return Unit.f139807a;
                    }

                    public final void invoke(PurchasesError it) {
                        Intrinsics.checkNotNullParameter(it, "it");
                        function12.invoke(it);
                    }
                });
            }
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((List<? extends StoreProduct>) obj);
            return Unit.f139807a;
        }

        public final void invoke(final List<? extends StoreProduct> subscriptionProducts) {
            Intrinsics.checkNotNullParameter(subscriptionProducts, "subscriptionProducts");
            Dispatcher dispatcher = OfferingsFactory.this.dispatcher;
            final Set<String> set = this.$productIds;
            final OfferingsFactory offeringsFactory = OfferingsFactory.this;
            final Function1<Map<String, ? extends List<? extends StoreProduct>>, Unit> function1 = this.$onCompleted;
            final Function1<PurchasesError, Unit> function12 = this.$onError;
            Dispatcher.enqueue$default(dispatcher, new Runnable() { // from class: com.revenuecat.purchases.common.offerings.a
                @Override // java.lang.Runnable
                public final void run() {
                    OfferingsFactory.C23421.invoke$lambda$1(subscriptionProducts, set, offeringsFactory, function1, function12);
                }
            }, null, 2, null);
        }
    }

    public OfferingsFactory(BillingAbstract billing, OfferingParser offeringParser, Dispatcher dispatcher, AppConfig appConfig) {
        Intrinsics.checkNotNullParameter(billing, "billing");
        Intrinsics.checkNotNullParameter(offeringParser, "offeringParser");
        Intrinsics.checkNotNullParameter(dispatcher, "dispatcher");
        Intrinsics.checkNotNullParameter(appConfig, "appConfig");
        this.billing = billing;
        this.offeringParser = offeringParser;
        this.dispatcher = dispatcher;
        this.appConfig = appConfig;
    }

    private final Set<String> extractProductIdentifiers(JSONObject jSONObject) throws JSONException {
        JSONArray jSONArray = jSONObject.getJSONArray("offerings");
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        int length = jSONArray.length();
        for (int i3 = 0; i3 < length; i3++) {
            JSONArray jSONArray2 = jSONArray.getJSONObject(i3).getJSONArray("packages");
            int length2 = jSONArray2.length();
            for (int i4 = 0; i4 < length2; i4++) {
                String it = jSONArray2.getJSONObject(i4).optString("platform_product_identifier");
                Intrinsics.checkNotNullExpressionValue(it, "it");
                if (StringsKt.p0(it)) {
                    it = null;
                }
                if (it != null) {
                    linkedHashSet.add(it);
                }
            }
        }
        return linkedHashSet;
    }

    private final void getStoreProductsById(Set<String> set, Function1<? super Map<String, ? extends List<? extends StoreProduct>>, Unit> function1, final Function1<? super PurchasesError, Unit> function12) {
        this.billing.queryProductDetailsAsync(ProductType.SUBS, set, new C23421(set, function1, function12), new Function1<PurchasesError, Unit>() { // from class: com.revenuecat.purchases.common.offerings.OfferingsFactory.getStoreProductsById.2
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
                function12.invoke(it);
            }
        });
    }

    public final void createOfferings(final JSONObject offeringsJSON, final HTTPResponseOriginalSource originalDataSource, final boolean z2, Function1<? super PurchasesError, Unit> onError, final Function1<? super OfferingsResultData, Unit> onSuccess) {
        final Function1<? super PurchasesError, Unit> function1;
        final JSONException jSONException;
        LogHandler currentLogHandler;
        String str;
        String str2;
        Intrinsics.checkNotNullParameter(offeringsJSON, "offeringsJSON");
        Intrinsics.checkNotNullParameter(originalDataSource, "originalDataSource");
        Intrinsics.checkNotNullParameter(onError, "onError");
        Intrinsics.checkNotNullParameter(onSuccess, "onSuccess");
        try {
            final Set<String> setExtractProductIdentifiers = extractProductIdentifiers(offeringsJSON);
            if (setExtractProductIdentifiers.isEmpty()) {
                try {
                    onError.invoke(new PurchasesError(PurchasesErrorCode.ConfigurationError, OfferingStrings.INSTANCE.getConfigurationErrorNoProductsForOfferings(this.appConfig.getApiKeyValidationResult(), this.appConfig.getStore())));
                    return;
                } catch (JSONException e3) {
                    jSONException = e3;
                    function1 = onError;
                }
            } else {
                function1 = onError;
                try {
                    getStoreProductsById(setExtractProductIdentifiers, new Function1<Map<String, ? extends List<? extends StoreProduct>>, Unit>() { // from class: com.revenuecat.purchases.common.offerings.OfferingsFactory.createOfferings.1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Object invoke(Object obj) throws Exception {
                            invoke((Map<String, ? extends List<? extends StoreProduct>>) obj);
                            return Unit.f139807a;
                        }

                        public final void invoke(Map<String, ? extends List<? extends StoreProduct>> productsById) throws Exception {
                            LogHandler currentLogHandler2;
                            String str3;
                            String str4;
                            Intrinsics.checkNotNullParameter(productsById, "productsById");
                            try {
                                Set<String> set = setExtractProductIdentifiers;
                                ArrayList arrayList = new ArrayList();
                                for (Object obj : set) {
                                    if (!productsById.containsKey((String) obj)) {
                                        arrayList.add(obj);
                                    }
                                }
                                Set set2 = CollectionsKt.toSet(arrayList);
                                final Set set3 = !set2.isEmpty() ? set2 : null;
                                if (set3 != null) {
                                    final LogIntent logIntent = LogIntent.GOOGLE_WARNING;
                                    Function0<String> function0 = new Function0<String>() { // from class: com.revenuecat.purchases.common.offerings.OfferingsFactory$createOfferings$1$invoke$lambda$3$$inlined$log$1
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        {
                                            super(0);
                                        }

                                        @Override // kotlin.jvm.functions.Function0
                                        public final String invoke() {
                                            StringBuilder sb = new StringBuilder();
                                            sb.append(CollectionsKt.joinToString$default(logIntent.getEmojiList(), "", null, null, 0, null, null, 62, null));
                                            sb.append(' ');
                                            String str5 = String.format(OfferingStrings.CANNOT_FIND_PRODUCT_CONFIGURATION_ERROR, Arrays.copyOf(new Object[]{CollectionsKt.joinToString$default(set3, ", ", null, null, 0, null, null, 62, null)}, 1));
                                            Intrinsics.checkNotNullExpressionValue(str5, "format(...)");
                                            sb.append(str5);
                                            return sb.toString();
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
                                }
                                Offerings offeringsCreateOfferings = this.offeringParser.createOfferings(offeringsJSON, productsById, originalDataSource, z2);
                                if (offeringsCreateOfferings.getAll().isEmpty()) {
                                    function1.invoke(new PurchasesError(PurchasesErrorCode.ConfigurationError, OfferingStrings.CONFIGURATION_ERROR_PRODUCTS_NOT_FOUND));
                                    return;
                                }
                                LogLevel logLevel11 = LogLevel.VERBOSE;
                                LogHandler currentLogHandler9 = LogWrapperKt.getCurrentLogHandler();
                                if (Config.INSTANCE.getLogLevel().compareTo(logLevel11) <= 0) {
                                    String str5 = "[Purchases] - " + logLevel11.name();
                                    String str6 = String.format(OfferingStrings.CREATED_OFFERINGS, Arrays.copyOf(new Object[]{Integer.valueOf(offeringsCreateOfferings.getAll().size())}, 1));
                                    Intrinsics.checkNotNullExpressionValue(str6, "format(...)");
                                    currentLogHandler9.v(str5, str6);
                                }
                                onSuccess.invoke(new OfferingsResultData(offeringsCreateOfferings, setExtractProductIdentifiers, set2));
                            } catch (Exception e4) {
                                if (!(e4 instanceof JSONException ? true : e4 instanceof SerializationException)) {
                                    throw e4;
                                }
                                final LogIntent logIntent2 = LogIntent.RC_ERROR;
                                Function0<String> function02 = new Function0<String>() { // from class: com.revenuecat.purchases.common.offerings.OfferingsFactory$createOfferings$1$invoke$$inlined$log$1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(0);
                                    }

                                    @Override // kotlin.jvm.functions.Function0
                                    public final String invoke() {
                                        StringBuilder sb = new StringBuilder();
                                        sb.append(CollectionsKt.joinToString$default(logIntent2.getEmojiList(), "", null, null, 0, null, null, 62, null));
                                        sb.append(' ');
                                        String str7 = String.format(OfferingStrings.JSON_EXCEPTION_ERROR, Arrays.copyOf(new Object[]{e4.getLocalizedMessage()}, 1));
                                        Intrinsics.checkNotNullExpressionValue(str7, "format(...)");
                                        sb.append(str7);
                                        return sb.toString();
                                    }
                                };
                                switch (LogWrapperKt.WhenMappings.$EnumSwitchMapping$0[logIntent2.ordinal()]) {
                                    case 1:
                                        LogLevel logLevel12 = LogLevel.DEBUG;
                                        LogHandler currentLogHandler10 = LogWrapperKt.getCurrentLogHandler();
                                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel12) <= 0) {
                                            currentLogHandler10.d("[Purchases] - " + logLevel12.name(), (String) function02.invoke());
                                        }
                                        break;
                                    case 2:
                                        LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) function02.invoke(), null);
                                        break;
                                    case 3:
                                        LogLevel logLevel13 = LogLevel.WARN;
                                        LogHandler currentLogHandler11 = LogWrapperKt.getCurrentLogHandler();
                                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel13) <= 0) {
                                            currentLogHandler11.w("[Purchases] - " + logLevel13.name(), (String) function02.invoke());
                                        }
                                        break;
                                    case 4:
                                        LogLevel logLevel14 = LogLevel.INFO;
                                        LogHandler currentLogHandler12 = LogWrapperKt.getCurrentLogHandler();
                                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel14) <= 0) {
                                            currentLogHandler12.i("[Purchases] - " + logLevel14.name(), (String) function02.invoke());
                                        }
                                        break;
                                    case 5:
                                        LogLevel logLevel15 = LogLevel.DEBUG;
                                        LogHandler currentLogHandler13 = LogWrapperKt.getCurrentLogHandler();
                                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel15) <= 0) {
                                            currentLogHandler13.d("[Purchases] - " + logLevel15.name(), (String) function02.invoke());
                                        }
                                        break;
                                    case 6:
                                        LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) function02.invoke(), null);
                                        break;
                                    case 7:
                                        LogLevel logLevel16 = LogLevel.INFO;
                                        LogHandler currentLogHandler14 = LogWrapperKt.getCurrentLogHandler();
                                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel16) <= 0) {
                                            currentLogHandler14.i("[Purchases] - " + logLevel16.name(), (String) function02.invoke());
                                        }
                                        break;
                                    case 8:
                                        LogLevel logLevel17 = LogLevel.DEBUG;
                                        LogHandler currentLogHandler15 = LogWrapperKt.getCurrentLogHandler();
                                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel17) <= 0) {
                                            currentLogHandler15.d("[Purchases] - " + logLevel17.name(), (String) function02.invoke());
                                        }
                                        break;
                                    case 9:
                                        LogLevel logLevel18 = LogLevel.DEBUG;
                                        LogHandler currentLogHandler16 = LogWrapperKt.getCurrentLogHandler();
                                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel18) <= 0) {
                                            currentLogHandler16.d("[Purchases] - " + logLevel18.name(), (String) function02.invoke());
                                        }
                                        break;
                                    case 10:
                                        LogLevel logLevel19 = LogLevel.WARN;
                                        LogHandler currentLogHandler17 = LogWrapperKt.getCurrentLogHandler();
                                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel19) <= 0) {
                                            currentLogHandler17.w("[Purchases] - " + logLevel19.name(), (String) function02.invoke());
                                        }
                                        break;
                                    case 11:
                                        LogLevel logLevel20 = LogLevel.WARN;
                                        LogHandler currentLogHandler18 = LogWrapperKt.getCurrentLogHandler();
                                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel20) <= 0) {
                                            currentLogHandler18.w("[Purchases] - " + logLevel20.name(), (String) function02.invoke());
                                        }
                                        break;
                                    case 12:
                                        LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) function02.invoke(), null);
                                        break;
                                    case 13:
                                        LogLevel logLevel21 = LogLevel.WARN;
                                        LogHandler currentLogHandler19 = LogWrapperKt.getCurrentLogHandler();
                                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel21) <= 0) {
                                            currentLogHandler19.w("[Purchases] - " + logLevel21.name(), (String) function02.invoke());
                                        }
                                        break;
                                    case 14:
                                        LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) function02.invoke(), null);
                                        break;
                                }
                                function1.invoke(new PurchasesError(PurchasesErrorCode.UnexpectedBackendResponseError, e4.getLocalizedMessage()));
                            }
                        }
                    }, new Function1<PurchasesError, Unit>() { // from class: com.revenuecat.purchases.common.offerings.OfferingsFactory.createOfferings.2
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
                            function1.invoke(error);
                        }
                    });
                    return;
                } catch (JSONException e4) {
                    e = e4;
                }
            }
        } catch (JSONException e5) {
            e = e5;
            function1 = onError;
        }
        jSONException = e;
        final LogIntent logIntent = LogIntent.RC_ERROR;
        Function0<String> function0 = new Function0<String>() { // from class: com.revenuecat.purchases.common.offerings.OfferingsFactory$createOfferings$$inlined$log$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                StringBuilder sb = new StringBuilder();
                sb.append(CollectionsKt.joinToString$default(logIntent.getEmojiList(), "", null, null, 0, null, null, 62, null));
                sb.append(' ');
                String str3 = String.format(OfferingStrings.JSON_EXCEPTION_ERROR, Arrays.copyOf(new Object[]{jSONException.getLocalizedMessage()}, 1));
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
        function1.invoke(new PurchasesError(PurchasesErrorCode.UnexpectedBackendResponseError, jSONException.getLocalizedMessage()));
    }
}
