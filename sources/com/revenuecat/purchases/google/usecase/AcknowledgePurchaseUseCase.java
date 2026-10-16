package com.revenuecat.purchases.google.usecase;

import com.android.billingclient.api.AcknowledgePurchaseParams;
import com.android.billingclient.api.AcknowledgePurchaseResponseListener;
import com.android.billingclient.api.BillingClient;
import com.android.billingclient.api.BillingResult;
import com.revenuecat.purchases.LogHandler;
import com.revenuecat.purchases.LogLevel;
import com.revenuecat.purchases.PostReceiptInitiationSource;
import com.revenuecat.purchases.PurchasesError;
import com.revenuecat.purchases.common.Config;
import com.revenuecat.purchases.common.LogIntent;
import com.revenuecat.purchases.common.LogWrapperKt;
import com.revenuecat.purchases.google.BillingResultExtensionsBillingIndependentKt;
import com.revenuecat.purchases.google.ErrorsKt;
import com.revenuecat.purchases.google.usecase.AcknowledgePurchaseUseCase;
import com.revenuecat.purchases.strings.PurchaseStrings;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

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
public final class AcknowledgePurchaseUseCase extends BillingClientUseCase<String> {
    private final Function1<PurchasesError, Unit> onError;
    private final Function1<String, Unit> onReceive;
    private final AcknowledgePurchaseUseCaseParams useCaseParams;
    private final Function1<Function1<? super BillingClient, Unit>, Unit> withConnectedClient;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[PostReceiptInitiationSource.values().length];
            try {
                iArr[PostReceiptInitiationSource.RESTORE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[PostReceiptInitiationSource.PURCHASE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[PostReceiptInitiationSource.UNSYNCED_ACTIVE_PURCHASES.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: renamed from: com.revenuecat.purchases.google.usecase.AcknowledgePurchaseUseCase$executeAsync$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    static final class AnonymousClass1 extends Lambda implements Function1<BillingClient, Unit> {
        AnonymousClass1() {
            super(1);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void invoke$lambda$0(final AcknowledgePurchaseUseCase acknowledgePurchaseUseCase, BillingResult billingResult) {
            Intrinsics.checkNotNullParameter(billingResult, "billingResult");
            BillingClientUseCase.processResult$default(acknowledgePurchaseUseCase, billingResult, acknowledgePurchaseUseCase.useCaseParams.getPurchaseToken(), null, new Function1<BillingResult, Unit>() { // from class: com.revenuecat.purchases.google.usecase.AcknowledgePurchaseUseCase$executeAsync$1$1$1
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke((BillingResult) obj);
                    return Unit.f139807a;
                }

                public final void invoke(BillingResult errorBillingResult) {
                    final String str;
                    LogHandler currentLogHandler;
                    String str2;
                    String str3;
                    Intrinsics.checkNotNullParameter(errorBillingResult, "errorBillingResult");
                    if (errorBillingResult.c() != 8 || acknowledgePurchaseUseCase.useCaseParams.getInitiationSource() != PostReceiptInitiationSource.RESTORE) {
                        str = acknowledgePurchaseUseCase.getErrorMessage() + " - " + BillingResultExtensionsBillingIndependentKt.toHumanReadableDescription(errorBillingResult);
                        final LogIntent logIntent = LogIntent.GOOGLE_ERROR;
                        Function0<String> function0 = new Function0<String>() { // from class: com.revenuecat.purchases.google.usecase.AcknowledgePurchaseUseCase$executeAsync$1$1$1$invoke$$inlined$log$2
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(0);
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public final String invoke() {
                                return CollectionsKt.joinToString$default(logIntent.getEmojiList(), "", null, null, 0, null, null, 62, null) + ' ' + str;
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
                        final LogIntent logIntent2 = LogIntent.GOOGLE_WARNING;
                        str = PurchaseStrings.ACKNOWLEDGING_PURCHASE_ERROR_RESTORE;
                        Function0<String> function02 = new Function0<String>() { // from class: com.revenuecat.purchases.google.usecase.AcknowledgePurchaseUseCase$executeAsync$1$1$1$invoke$$inlined$log$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(0);
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public final String invoke() {
                                return CollectionsKt.joinToString$default(logIntent2.getEmojiList(), "", null, null, 0, null, null, 62, null) + ' ' + str;
                            }
                        };
                        switch (LogWrapperKt.WhenMappings.$EnumSwitchMapping$0[logIntent2.ordinal()]) {
                            case 1:
                                LogLevel logLevel11 = LogLevel.DEBUG;
                                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                                if (Config.INSTANCE.getLogLevel().compareTo(logLevel11) <= 0) {
                                    str2 = "[Purchases] - " + logLevel11.name();
                                    str3 = (String) function02.invoke();
                                    currentLogHandler.d(str2, str3);
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
                                    str2 = "[Purchases] - " + logLevel14.name();
                                    str3 = (String) function02.invoke();
                                    currentLogHandler.d(str2, str3);
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
                                    str2 = "[Purchases] - " + logLevel16.name();
                                    str3 = (String) function02.invoke();
                                    currentLogHandler.d(str2, str3);
                                }
                                break;
                            case 9:
                                LogLevel logLevel17 = LogLevel.DEBUG;
                                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                                if (Config.INSTANCE.getLogLevel().compareTo(logLevel17) <= 0) {
                                    str2 = "[Purchases] - " + logLevel17.name();
                                    str3 = (String) function02.invoke();
                                    currentLogHandler.d(str2, str3);
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
                    acknowledgePurchaseUseCase.getOnError().invoke(ErrorsKt.billingResponseToPurchasesError(errorBillingResult.c(), str));
                }
            }, 4, null);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((BillingClient) obj);
            return Unit.f139807a;
        }

        public final void invoke(BillingClient invoke) {
            Intrinsics.checkNotNullParameter(invoke, "$this$invoke");
            AcknowledgePurchaseParams acknowledgePurchaseParamsA = AcknowledgePurchaseParams.b().b(AcknowledgePurchaseUseCase.this.useCaseParams.getPurchaseToken()).a();
            Intrinsics.checkNotNullExpressionValue(acknowledgePurchaseParamsA, "newBuilder()\n           …\n                .build()");
            final AcknowledgePurchaseUseCase acknowledgePurchaseUseCase = AcknowledgePurchaseUseCase.this;
            invoke.a(acknowledgePurchaseParamsA, new AcknowledgePurchaseResponseListener() { // from class: com.revenuecat.purchases.google.usecase.a
                @Override // com.android.billingclient.api.AcknowledgePurchaseResponseListener
                public final void b(BillingResult billingResult) {
                    AcknowledgePurchaseUseCase.AnonymousClass1.invoke$lambda$0(acknowledgePurchaseUseCase, billingResult);
                }
            });
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public AcknowledgePurchaseUseCase(AcknowledgePurchaseUseCaseParams useCaseParams, Function1<? super String, Unit> onReceive, Function1<? super PurchasesError, Unit> onError, Function1<? super Function1<? super BillingClient, Unit>, Unit> withConnectedClient, Function2<? super Long, ? super Function1<? super PurchasesError, Unit>, Unit> executeRequestOnUIThread) {
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

    @Override // com.revenuecat.purchases.google.usecase.BillingClientUseCase
    public void executeAsync() {
        this.withConnectedClient.invoke(new AnonymousClass1());
    }

    @Override // com.revenuecat.purchases.google.usecase.BillingClientUseCase
    protected boolean getBackoffForNetworkErrors() {
        int i3 = WhenMappings.$EnumSwitchMapping$0[this.useCaseParams.getInitiationSource().ordinal()];
        if (i3 == 1 || i3 == 2) {
            return false;
        }
        if (i3 == 3) {
            return true;
        }
        throw new NoWhenBranchMatchedException();
    }

    @Override // com.revenuecat.purchases.google.usecase.BillingClientUseCase
    public String getErrorMessage() {
        return "Error acknowledging purchase";
    }

    public final Function1<PurchasesError, Unit> getOnError() {
        return this.onError;
    }

    public final Function1<String, Unit> getOnReceive() {
        return this.onReceive;
    }

    public final Function1<Function1<? super BillingClient, Unit>, Unit> getWithConnectedClient() {
        return this.withConnectedClient;
    }

    @Override // com.revenuecat.purchases.google.usecase.BillingClientUseCase
    public void onOk(String received) {
        Intrinsics.checkNotNullParameter(received, "received");
        this.onReceive.invoke(received);
    }
}
