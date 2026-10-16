package com.revenuecat.purchases;

import com.google.android.material.bottomsheet.lKiE.YznnJpHcAmeoW;
import com.revenuecat.purchases.SyncPurchasesHelper;
import com.revenuecat.purchases.common.BillingAbstract;
import com.revenuecat.purchases.common.Config;
import com.revenuecat.purchases.common.DateProvider;
import com.revenuecat.purchases.common.DefaultDateProvider;
import com.revenuecat.purchases.common.DurationExtensionsKt;
import com.revenuecat.purchases.common.LogIntent;
import com.revenuecat.purchases.common.LogWrapperKt;
import com.revenuecat.purchases.common.ReceiptInfo;
import com.revenuecat.purchases.common.diagnostics.DiagnosticsTracker;
import com.revenuecat.purchases.identity.IdentityManager;
import com.revenuecat.purchases.interfaces.ReceiveCustomerInfoCallback;
import com.revenuecat.purchases.models.StoreTransaction;
import com.revenuecat.purchases.strings.PurchaseStrings;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
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
/* JADX INFO: loaded from: classes4.dex */
@Metadata
public final class SyncPurchasesHelper {
    private final BillingAbstract billing;
    private final CustomerInfoHelper customerInfoHelper;
    private final DateProvider dateProvider;
    private final DiagnosticsTracker diagnosticsTrackerIfEnabled;
    private final IdentityManager identityManager;
    private final PostReceiptHelper postReceiptHelper;

    /* JADX INFO: renamed from: com.revenuecat.purchases.SyncPurchasesHelper$syncPurchases$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    static final class AnonymousClass2 extends Lambda implements Function1<List<? extends StoreTransaction>, Unit> {
        final /* synthetic */ boolean $appInBackground;
        final /* synthetic */ String $appUserID;
        final /* synthetic */ Function1<PurchasesError, Unit> $handleError;
        final /* synthetic */ Function1<CustomerInfo, Unit> $handleSuccess;
        final /* synthetic */ boolean $isRestore;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass2(String str, boolean z2, boolean z3, Function1<? super CustomerInfo, Unit> function1, Function1<? super PurchasesError, Unit> function12) {
            super(1);
            this.$appUserID = str;
            this.$appInBackground = z2;
            this.$isRestore = z3;
            this.$handleSuccess = function1;
            this.$handleError = function12;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void invoke$handleLastPurchase(List<PurchasesError> list, SyncPurchasesHelper syncPurchasesHelper, String str, boolean z2, boolean z3, Function1<? super CustomerInfo, Unit> function1, Function1<? super PurchasesError, Unit> function12, StoreTransaction storeTransaction, StoreTransaction storeTransaction2) {
            if (Intrinsics.areEqual(storeTransaction, storeTransaction2)) {
                if (!list.isEmpty()) {
                    LogHandler currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                    String str2 = String.format(PurchaseStrings.SYNCING_PURCHASES_ERROR, Arrays.copyOf(new Object[]{list}, 1));
                    Intrinsics.checkNotNullExpressionValue(str2, "format(...)");
                    currentLogHandler.e("[Purchases] - ERROR", str2, null);
                    function12.invoke(CollectionsKt.first((List) list));
                    return;
                }
                LogLevel logLevel = LogLevel.DEBUG;
                LogHandler currentLogHandler2 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                    currentLogHandler2.d("[Purchases] - " + logLevel.name(), PurchaseStrings.SYNCED_PURCHASES_SUCCESSFULLY);
                }
                syncPurchasesHelper.retrieveCustomerInfo(str, z2, z3, function1, function12);
            }
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((List<StoreTransaction>) obj);
            return Unit.f139807a;
        }

        public final void invoke(List<StoreTransaction> allPurchases) {
            Intrinsics.checkNotNullParameter(allPurchases, "allPurchases");
            if (allPurchases.isEmpty()) {
                SyncPurchasesHelper.this.retrieveCustomerInfo(this.$appUserID, this.$appInBackground, this.$isRestore, this.$handleSuccess, this.$handleError);
                return;
            }
            final StoreTransaction storeTransaction = (StoreTransaction) CollectionsKt.last((List) allPurchases);
            final ArrayList arrayList = new ArrayList();
            final SyncPurchasesHelper syncPurchasesHelper = SyncPurchasesHelper.this;
            final boolean z2 = this.$isRestore;
            final String str = this.$appUserID;
            final boolean z3 = this.$appInBackground;
            final Function1<CustomerInfo, Unit> function1 = this.$handleSuccess;
            final Function1<PurchasesError, Unit> function12 = this.$handleError;
            for (final StoreTransaction storeTransaction2 : allPurchases) {
                ReceiptInfo receiptInfo = new ReceiptInfo(storeTransaction2.getProductIds(), Long.valueOf(storeTransaction2.getPurchaseTime()), null, null, null, null, null, null, null, null, false, storeTransaction2.getStoreUserID(), storeTransaction2.getMarketplace(), 2044, null);
                PostReceiptHelper postReceiptHelper = syncPurchasesHelper.postReceiptHelper;
                String purchaseToken = storeTransaction2.getPurchaseToken();
                PostReceiptInitiationSource postReceiptInitiationSource = PostReceiptInitiationSource.RESTORE;
                final ArrayList arrayList2 = arrayList;
                Function1<CustomerInfo, Unit> function13 = new Function1<CustomerInfo, Unit>() { // from class: com.revenuecat.purchases.SyncPurchasesHelper$syncPurchases$2$1$1
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
                        LogHandler currentLogHandler;
                        String str2;
                        String str3;
                        Intrinsics.checkNotNullParameter(it, "it");
                        final LogIntent logIntent = LogIntent.PURCHASE;
                        final StoreTransaction storeTransaction3 = storeTransaction2;
                        Function0<String> function0 = new Function0<String>() { // from class: com.revenuecat.purchases.SyncPurchasesHelper$syncPurchases$2$1$1$invoke$$inlined$log$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(0);
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public final String invoke() {
                                StringBuilder sb = new StringBuilder();
                                sb.append(CollectionsKt.joinToString$default(logIntent.getEmojiList(), "", null, null, 0, null, null, 62, null));
                                sb.append(' ');
                                String str4 = String.format(PurchaseStrings.PURCHASE_SYNCED, Arrays.copyOf(new Object[]{storeTransaction3}, 1));
                                Intrinsics.checkNotNullExpressionValue(str4, "format(...)");
                                sb.append(str4);
                                return sb.toString();
                            }
                        };
                        int i3 = LogWrapperKt.WhenMappings.$EnumSwitchMapping$0[logIntent.ordinal()];
                        String str4 = YznnJpHcAmeoW.ykx;
                        switch (i3) {
                            case 1:
                                LogLevel logLevel = LogLevel.DEBUG;
                                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                                if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                                    str2 = str4 + logLevel.name();
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
                                    currentLogHandler2.w(str4 + logLevel2.name(), (String) function0.invoke());
                                }
                                break;
                            case 4:
                                LogLevel logLevel3 = LogLevel.INFO;
                                LogHandler currentLogHandler3 = LogWrapperKt.getCurrentLogHandler();
                                if (Config.INSTANCE.getLogLevel().compareTo(logLevel3) <= 0) {
                                    currentLogHandler3.i(str4 + logLevel3.name(), (String) function0.invoke());
                                }
                                break;
                            case 5:
                                LogLevel logLevel4 = LogLevel.DEBUG;
                                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                                if (Config.INSTANCE.getLogLevel().compareTo(logLevel4) <= 0) {
                                    str2 = str4 + logLevel4.name();
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
                                    currentLogHandler4.i(str4 + logLevel5.name(), (String) function0.invoke());
                                }
                                break;
                            case 8:
                                LogLevel logLevel6 = LogLevel.DEBUG;
                                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                                if (Config.INSTANCE.getLogLevel().compareTo(logLevel6) <= 0) {
                                    str2 = str4 + logLevel6.name();
                                    str3 = (String) function0.invoke();
                                    currentLogHandler.d(str2, str3);
                                }
                                break;
                            case 9:
                                LogLevel logLevel7 = LogLevel.DEBUG;
                                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                                if (Config.INSTANCE.getLogLevel().compareTo(logLevel7) <= 0) {
                                    str2 = str4 + logLevel7.name();
                                    str3 = (String) function0.invoke();
                                    currentLogHandler.d(str2, str3);
                                }
                                break;
                            case 10:
                                LogLevel logLevel8 = LogLevel.WARN;
                                LogHandler currentLogHandler5 = LogWrapperKt.getCurrentLogHandler();
                                if (Config.INSTANCE.getLogLevel().compareTo(logLevel8) <= 0) {
                                    currentLogHandler5.w(str4 + logLevel8.name(), (String) function0.invoke());
                                }
                                break;
                            case 11:
                                LogLevel logLevel9 = LogLevel.WARN;
                                LogHandler currentLogHandler6 = LogWrapperKt.getCurrentLogHandler();
                                if (Config.INSTANCE.getLogLevel().compareTo(logLevel9) <= 0) {
                                    currentLogHandler6.w(str4 + logLevel9.name(), (String) function0.invoke());
                                }
                                break;
                            case 12:
                                LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) function0.invoke(), null);
                                break;
                            case 13:
                                LogLevel logLevel10 = LogLevel.WARN;
                                LogHandler currentLogHandler7 = LogWrapperKt.getCurrentLogHandler();
                                if (Config.INSTANCE.getLogLevel().compareTo(logLevel10) <= 0) {
                                    currentLogHandler7.w(str4 + logLevel10.name(), (String) function0.invoke());
                                }
                                break;
                            case 14:
                                LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) function0.invoke(), null);
                                break;
                        }
                        SyncPurchasesHelper.AnonymousClass2.invoke$handleLastPurchase(arrayList2, syncPurchasesHelper, str, z3, z2, function1, function12, storeTransaction2, storeTransaction);
                    }
                };
                arrayList = arrayList2;
                final StoreTransaction storeTransaction3 = storeTransaction;
                Function1<PurchasesError, Unit> function14 = new Function1<PurchasesError, Unit>() { // from class: com.revenuecat.purchases.SyncPurchasesHelper$syncPurchases$2$1$2
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
                        final LogIntent logIntent = LogIntent.RC_ERROR;
                        final StoreTransaction storeTransaction4 = storeTransaction2;
                        Function0<String> function0 = new Function0<String>() { // from class: com.revenuecat.purchases.SyncPurchasesHelper$syncPurchases$2$1$2$invoke$$inlined$log$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(0);
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public final String invoke() {
                                StringBuilder sb = new StringBuilder();
                                sb.append(CollectionsKt.joinToString$default(logIntent.getEmojiList(), "", null, null, 0, null, null, 62, null));
                                sb.append(' ');
                                String str4 = String.format(PurchaseStrings.SYNCING_PURCHASES_ERROR_DETAILS, Arrays.copyOf(new Object[]{storeTransaction4, error}, 2));
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
                        arrayList.add(error);
                        SyncPurchasesHelper.AnonymousClass2.invoke$handleLastPurchase(arrayList, syncPurchasesHelper, str, z3, z2, function1, function12, storeTransaction2, storeTransaction3);
                    }
                };
                Function1<CustomerInfo, Unit> function15 = function1;
                storeTransaction = storeTransaction3;
                Function1<PurchasesError, Unit> function16 = function12;
                boolean z4 = z2;
                String str2 = str;
                postReceiptHelper.postTokenWithoutConsuming(purchaseToken, receiptInfo, z4, str2, postReceiptInitiationSource, function13, function14, storeTransaction2.isAutoRenewing());
                z3 = z3;
                z2 = z4;
                str = str2;
                function1 = function15;
                function12 = function16;
            }
        }
    }

    public SyncPurchasesHelper(BillingAbstract billing, IdentityManager identityManager, CustomerInfoHelper customerInfoHelper, PostReceiptHelper postReceiptHelper, DiagnosticsTracker diagnosticsTracker, DateProvider dateProvider) {
        Intrinsics.checkNotNullParameter(billing, "billing");
        Intrinsics.checkNotNullParameter(identityManager, "identityManager");
        Intrinsics.checkNotNullParameter(customerInfoHelper, "customerInfoHelper");
        Intrinsics.checkNotNullParameter(postReceiptHelper, "postReceiptHelper");
        Intrinsics.checkNotNullParameter(dateProvider, "dateProvider");
        this.billing = billing;
        this.identityManager = identityManager;
        this.customerInfoHelper = customerInfoHelper;
        this.postReceiptHelper = postReceiptHelper;
        this.diagnosticsTrackerIfEnabled = diagnosticsTracker;
        this.dateProvider = dateProvider;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void retrieveCustomerInfo(String str, boolean z2, boolean z3, final Function1<? super CustomerInfo, Unit> function1, final Function1<? super PurchasesError, Unit> function12) {
        CustomerInfoHelper.retrieveCustomerInfo$default(this.customerInfoHelper, str, CacheFetchPolicy.CACHED_OR_FETCHED, z2, z3, false, new ReceiveCustomerInfoCallback() { // from class: com.revenuecat.purchases.SyncPurchasesHelper.retrieveCustomerInfo.1
            @Override // com.revenuecat.purchases.interfaces.ReceiveCustomerInfoCallback
            public void onError(PurchasesError error) {
                Intrinsics.checkNotNullParameter(error, "error");
                function12.invoke(error);
            }

            @Override // com.revenuecat.purchases.interfaces.ReceiveCustomerInfoCallback
            public void onReceived(CustomerInfo customerInfo) {
                Intrinsics.checkNotNullParameter(customerInfo, "customerInfo");
                function1.invoke(customerInfo);
            }
        }, 16, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void trackSyncPurchasesResultIfNeeded(PurchasesError purchasesError, Date date) {
        PurchasesErrorCode code;
        DiagnosticsTracker diagnosticsTracker = this.diagnosticsTrackerIfEnabled;
        if (diagnosticsTracker != null) {
            diagnosticsTracker.m542trackSyncPurchasesResultSxA4cEA((purchasesError == null || (code = purchasesError.getCode()) == null) ? null : Integer.valueOf(code.getCode()), purchasesError != null ? purchasesError.getMessage() : null, DurationExtensionsKt.between(Duration.f140631b, date, this.dateProvider.getNow()));
        }
    }

    public final void syncPurchases(boolean z2, boolean z3, final Function1<? super CustomerInfo, Unit> onSuccess, final Function1<? super PurchasesError, Unit> onError) {
        LogHandler currentLogHandler;
        String str;
        String str2;
        Intrinsics.checkNotNullParameter(onSuccess, "onSuccess");
        Intrinsics.checkNotNullParameter(onError, "onError");
        final LogIntent logIntent = LogIntent.DEBUG;
        Function0<String> function0 = new Function0<String>() { // from class: com.revenuecat.purchases.SyncPurchasesHelper$syncPurchases$$inlined$log$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                return CollectionsKt.joinToString$default(logIntent.getEmojiList(), "", null, null, 0, null, null, 62, null) + ' ' + PurchaseStrings.SYNCING_PURCHASES;
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
        final Date now = this.dateProvider.getNow();
        DiagnosticsTracker diagnosticsTracker = this.diagnosticsTrackerIfEnabled;
        if (diagnosticsTracker != null) {
            diagnosticsTracker.trackSyncPurchasesStarted();
        }
        String currentAppUserID = this.identityManager.getCurrentAppUserID();
        Function1<CustomerInfo, Unit> function1 = new Function1<CustomerInfo, Unit>() { // from class: com.revenuecat.purchases.SyncPurchasesHelper$syncPurchases$handleSuccess$1
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
                this.this$0.trackSyncPurchasesResultIfNeeded(null, now);
                onSuccess.invoke(it);
            }
        };
        final Function1<PurchasesError, Unit> function12 = new Function1<PurchasesError, Unit>() { // from class: com.revenuecat.purchases.SyncPurchasesHelper$syncPurchases$handleError$1
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
                this.this$0.trackSyncPurchasesResultIfNeeded(it, now);
                onError.invoke(it);
            }
        };
        this.billing.queryAllPurchases(currentAppUserID, new AnonymousClass2(currentAppUserID, z3, z2, function1, function12), new Function1<PurchasesError, Unit>() { // from class: com.revenuecat.purchases.SyncPurchasesHelper.syncPurchases.3
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

            public final void invoke(final PurchasesError it) {
                LogHandler currentLogHandler8;
                String str3;
                String str4;
                Intrinsics.checkNotNullParameter(it, "it");
                final LogIntent logIntent2 = LogIntent.RC_ERROR;
                Function0<String> function02 = new Function0<String>() { // from class: com.revenuecat.purchases.SyncPurchasesHelper$syncPurchases$3$invoke$$inlined$log$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final String invoke() {
                        StringBuilder sb = new StringBuilder();
                        sb.append(CollectionsKt.joinToString$default(logIntent2.getEmojiList(), "", null, null, 0, null, null, 62, null));
                        sb.append(' ');
                        String str5 = String.format(PurchaseStrings.SYNCING_PURCHASES_ERROR, Arrays.copyOf(new Object[]{it}, 1));
                        Intrinsics.checkNotNullExpressionValue(str5, "format(...)");
                        sb.append(str5);
                        return sb.toString();
                    }
                };
                switch (LogWrapperKt.WhenMappings.$EnumSwitchMapping$0[logIntent2.ordinal()]) {
                    case 1:
                        LogLevel logLevel11 = LogLevel.DEBUG;
                        currentLogHandler8 = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel11) <= 0) {
                            str3 = "[Purchases] - " + logLevel11.name();
                            str4 = (String) function02.invoke();
                            currentLogHandler8.d(str3, str4);
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
                            str3 = "[Purchases] - " + logLevel14.name();
                            str4 = (String) function02.invoke();
                            currentLogHandler8.d(str3, str4);
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
                            str3 = "[Purchases] - " + logLevel16.name();
                            str4 = (String) function02.invoke();
                            currentLogHandler8.d(str3, str4);
                        }
                        break;
                    case 9:
                        LogLevel logLevel17 = LogLevel.DEBUG;
                        currentLogHandler8 = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel17) <= 0) {
                            str3 = "[Purchases] - " + logLevel17.name();
                            str4 = (String) function02.invoke();
                            currentLogHandler8.d(str3, str4);
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
                function12.invoke(it);
            }
        });
    }

    public /* synthetic */ SyncPurchasesHelper(BillingAbstract billingAbstract, IdentityManager identityManager, CustomerInfoHelper customerInfoHelper, PostReceiptHelper postReceiptHelper, DiagnosticsTracker diagnosticsTracker, DateProvider dateProvider, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(billingAbstract, identityManager, customerInfoHelper, postReceiptHelper, diagnosticsTracker, (i3 & 32) != 0 ? new DefaultDateProvider() : dateProvider);
    }
}
