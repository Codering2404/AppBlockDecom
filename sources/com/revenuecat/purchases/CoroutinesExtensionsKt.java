package com.revenuecat.purchases;

import com.revenuecat.purchases.common.CancellableContinuationExtensionsKt;
import com.revenuecat.purchases.customercenter.CustomerCenterConfigData;
import com.revenuecat.purchases.data.LogInResult;
import com.revenuecat.purchases.interfaces.GetCustomerCenterConfigCallback;
import com.revenuecat.purchases.virtualcurrencies.VirtualCurrencies;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuationImpl;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:71)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:37)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:35)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
@Metadata
public final class CoroutinesExtensionsKt {
    public static final /* synthetic */ Object awaitCreateSupportTicket(Purchases purchases, String str, String str2, Continuation continuation) throws PurchasesException {
        final CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.c(continuation), 1);
        cancellableContinuationImpl.C();
        purchases.createSupportTicket(str, str2, new Function1<Boolean, Unit>() { // from class: com.revenuecat.purchases.CoroutinesExtensionsKt$awaitCreateSupportTicket$2$1
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
                CancellableContinuationExtensionsKt.safeResume(cancellableContinuationImpl, new CreateSupportTicketResult(z2));
            }
        }, new Function1<PurchasesError, Unit>() { // from class: com.revenuecat.purchases.CoroutinesExtensionsKt$awaitCreateSupportTicket$2$2
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
                CancellableContinuationExtensionsKt.safeResumeWithException(cancellableContinuationImpl, new PurchasesException(it));
            }
        });
        Object objV = cancellableContinuationImpl.v();
        if (objV == IntrinsicsKt.f()) {
            DebugProbesKt.c(continuation);
        }
        return objV;
    }

    public static final /* synthetic */ Object awaitCustomerCenterConfigData(Purchases purchases, Continuation continuation) throws PurchasesException {
        final CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.c(continuation), 1);
        cancellableContinuationImpl.C();
        purchases.getCustomerCenterConfigData$purchases_defaultsBc8Release(new GetCustomerCenterConfigCallback() { // from class: com.revenuecat.purchases.CoroutinesExtensionsKt$awaitCustomerCenterConfigData$2$1
            @Override // com.revenuecat.purchases.interfaces.GetCustomerCenterConfigCallback
            public void onError(PurchasesError error) {
                Intrinsics.checkNotNullParameter(error, "error");
                CancellableContinuationExtensionsKt.safeResumeWithException(cancellableContinuationImpl, new PurchasesException(error));
            }

            @Override // com.revenuecat.purchases.interfaces.GetCustomerCenterConfigCallback
            public void onSuccess(CustomerCenterConfigData customerCenterConfig) {
                Intrinsics.checkNotNullParameter(customerCenterConfig, "customerCenterConfig");
                CancellableContinuationExtensionsKt.safeResume(cancellableContinuationImpl, customerCenterConfig);
            }
        });
        Object objV = cancellableContinuationImpl.v();
        if (objV == IntrinsicsKt.f()) {
            DebugProbesKt.c(continuation);
        }
        return objV;
    }

    public static final /* synthetic */ Object awaitCustomerInfo(Purchases purchases, CacheFetchPolicy cacheFetchPolicy, Continuation continuation) throws PurchasesException {
        final CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.c(continuation), 1);
        cancellableContinuationImpl.C();
        ListenerConversionsKt.getCustomerInfoWith(purchases, cacheFetchPolicy, new Function1<PurchasesError, Unit>() { // from class: com.revenuecat.purchases.CoroutinesExtensionsKt$awaitCustomerInfo$2$1
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
                CancellableContinuationExtensionsKt.safeResumeWithException(cancellableContinuationImpl, new PurchasesException(it));
            }
        }, new Function1<CustomerInfo, Unit>() { // from class: com.revenuecat.purchases.CoroutinesExtensionsKt$awaitCustomerInfo$2$2
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
                CancellableContinuationExtensionsKt.safeResume(cancellableContinuationImpl, it);
            }
        });
        Object objV = cancellableContinuationImpl.v();
        if (objV == IntrinsicsKt.f()) {
            DebugProbesKt.c(continuation);
        }
        return objV;
    }

    public static /* synthetic */ Object awaitCustomerInfo$default(Purchases purchases, CacheFetchPolicy cacheFetchPolicy, Continuation continuation, int i3, Object obj) throws PurchasesException {
        if ((i3 & 1) != 0) {
            cacheFetchPolicy = CacheFetchPolicy.Companion.m413default();
        }
        return awaitCustomerInfo(purchases, cacheFetchPolicy, continuation);
    }

    public static final /* synthetic */ Object awaitGetVirtualCurrencies(Purchases purchases, Continuation continuation) throws PurchasesException {
        final CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.c(continuation), 1);
        cancellableContinuationImpl.C();
        ListenerConversionsKt.getVirtualCurrenciesWith(purchases, new Function1<PurchasesError, Unit>() { // from class: com.revenuecat.purchases.CoroutinesExtensionsKt$awaitGetVirtualCurrencies$2$1
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
                CancellableContinuationExtensionsKt.safeResumeWithException(cancellableContinuationImpl, new PurchasesException(it));
            }
        }, new Function1<VirtualCurrencies, Unit>() { // from class: com.revenuecat.purchases.CoroutinesExtensionsKt$awaitGetVirtualCurrencies$2$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((VirtualCurrencies) obj);
                return Unit.f139807a;
            }

            public final void invoke(VirtualCurrencies it) {
                Intrinsics.checkNotNullParameter(it, "it");
                CancellableContinuationExtensionsKt.safeResume(cancellableContinuationImpl, it);
            }
        });
        Object objV = cancellableContinuationImpl.v();
        if (objV == IntrinsicsKt.f()) {
            DebugProbesKt.c(continuation);
        }
        return objV;
    }

    public static final /* synthetic */ Object awaitLogIn(Purchases purchases, String str, Continuation continuation) throws PurchasesTransactionException {
        final CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.c(continuation), 1);
        cancellableContinuationImpl.C();
        ListenerConversionsKt.logInWith(purchases, str, new Function1<PurchasesError, Unit>() { // from class: com.revenuecat.purchases.CoroutinesExtensionsKt$awaitLogIn$2$1
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
                CancellableContinuationExtensionsKt.safeResumeWithException(cancellableContinuationImpl, new PurchasesException(it));
            }
        }, new Function2<CustomerInfo, Boolean, Unit>() { // from class: com.revenuecat.purchases.CoroutinesExtensionsKt$awaitLogIn$2$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                invoke((CustomerInfo) obj, ((Boolean) obj2).booleanValue());
                return Unit.f139807a;
            }

            public final void invoke(CustomerInfo customerInfo, boolean z2) {
                Intrinsics.checkNotNullParameter(customerInfo, "customerInfo");
                CancellableContinuationExtensionsKt.safeResume(cancellableContinuationImpl, new LogInResult(customerInfo, z2));
            }
        });
        Object objV = cancellableContinuationImpl.v();
        if (objV == IntrinsicsKt.f()) {
            DebugProbesKt.c(continuation);
        }
        return objV;
    }

    public static final /* synthetic */ Object awaitLogOut(Purchases purchases, Continuation continuation) throws PurchasesTransactionException {
        final CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.c(continuation), 1);
        cancellableContinuationImpl.C();
        ListenerConversionsKt.logOutWith(purchases, new Function1<PurchasesError, Unit>() { // from class: com.revenuecat.purchases.CoroutinesExtensionsKt$awaitLogOut$2$1
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
                CancellableContinuationExtensionsKt.safeResumeWithException(cancellableContinuationImpl, new PurchasesException(it));
            }
        }, new Function1<CustomerInfo, Unit>() { // from class: com.revenuecat.purchases.CoroutinesExtensionsKt$awaitLogOut$2$2
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
                CancellableContinuationExtensionsKt.safeResume(cancellableContinuationImpl, it);
            }
        });
        Object objV = cancellableContinuationImpl.v();
        if (objV == IntrinsicsKt.f()) {
            DebugProbesKt.c(continuation);
        }
        return objV;
    }

    public static final /* synthetic */ Object awaitSetAppstackAttributionParams(Purchases purchases, Map map, Continuation continuation) throws PurchasesException {
        final CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.c(continuation), 1);
        cancellableContinuationImpl.C();
        purchases.setAppstackAttributionParams(map, ListenerConversionsKt.syncAttributesAndOfferingsListener(new Function1<Offerings, Unit>() { // from class: com.revenuecat.purchases.CoroutinesExtensionsKt$awaitSetAppstackAttributionParams$2$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Offerings) obj);
                return Unit.f139807a;
            }

            public final void invoke(Offerings it) {
                Intrinsics.checkNotNullParameter(it, "it");
                CancellableContinuationExtensionsKt.safeResume(cancellableContinuationImpl, it);
            }
        }, new Function1<PurchasesError, Unit>() { // from class: com.revenuecat.purchases.CoroutinesExtensionsKt$awaitSetAppstackAttributionParams$2$2
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
                CancellableContinuationExtensionsKt.safeResumeWithException(cancellableContinuationImpl, new PurchasesException(it));
            }
        }));
        Object objV = cancellableContinuationImpl.v();
        if (objV == IntrinsicsKt.f()) {
            DebugProbesKt.c(continuation);
        }
        return objV;
    }

    public static final Object awaitStorefrontLocale(Purchases purchases, Continuation<? super Locale> continuation) throws PurchasesException {
        final CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.c(continuation), 1);
        cancellableContinuationImpl.C();
        ListenerConversionsKt.getStorefrontLocaleWith(purchases, new Function1<PurchasesError, Unit>() { // from class: com.revenuecat.purchases.CoroutinesExtensionsKt$awaitStorefrontLocale$2$1
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
                CancellableContinuationExtensionsKt.safeResumeWithException(cancellableContinuationImpl, new PurchasesException(it));
            }
        }, new Function1<Locale, Unit>() { // from class: com.revenuecat.purchases.CoroutinesExtensionsKt$awaitStorefrontLocale$2$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Locale) obj);
                return Unit.f139807a;
            }

            public final void invoke(Locale it) {
                Intrinsics.checkNotNullParameter(it, "it");
                CancellableContinuationExtensionsKt.safeResume(cancellableContinuationImpl, it);
            }
        });
        Object objV = cancellableContinuationImpl.v();
        if (objV == IntrinsicsKt.f()) {
            DebugProbesKt.c(continuation);
        }
        return objV;
    }

    public static final /* synthetic */ Object awaitSyncAttributesAndOfferingsIfNeeded(Purchases purchases, Continuation continuation) throws PurchasesException {
        final CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.c(continuation), 1);
        cancellableContinuationImpl.C();
        ListenerConversionsKt.syncAttributesAndOfferingsIfNeededWith(purchases, new Function1<PurchasesError, Unit>() { // from class: com.revenuecat.purchases.CoroutinesExtensionsKt$awaitSyncAttributesAndOfferingsIfNeeded$2$1
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
                CancellableContinuationExtensionsKt.safeResumeWithException(cancellableContinuationImpl, new PurchasesException(it));
            }
        }, new Function1<Offerings, Unit>() { // from class: com.revenuecat.purchases.CoroutinesExtensionsKt$awaitSyncAttributesAndOfferingsIfNeeded$2$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Offerings) obj);
                return Unit.f139807a;
            }

            public final void invoke(Offerings it) {
                Intrinsics.checkNotNullParameter(it, "it");
                CancellableContinuationExtensionsKt.safeResume(cancellableContinuationImpl, it);
            }
        });
        Object objV = cancellableContinuationImpl.v();
        if (objV == IntrinsicsKt.f()) {
            DebugProbesKt.c(continuation);
        }
        return objV;
    }

    public static final /* synthetic */ Object awaitSyncPurchases(Purchases purchases, Continuation continuation) throws PurchasesException {
        final CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.c(continuation), 1);
        cancellableContinuationImpl.C();
        ListenerConversionsKt.syncPurchasesWith(purchases, new Function1<PurchasesError, Unit>() { // from class: com.revenuecat.purchases.CoroutinesExtensionsKt$awaitSyncPurchases$2$1
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
                CancellableContinuationExtensionsKt.safeResumeWithException(cancellableContinuationImpl, new PurchasesException(it));
            }
        }, new Function1<CustomerInfo, Unit>() { // from class: com.revenuecat.purchases.CoroutinesExtensionsKt$awaitSyncPurchases$2$2
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
                CancellableContinuationExtensionsKt.safeResume(cancellableContinuationImpl, it);
            }
        });
        Object objV = cancellableContinuationImpl.v();
        if (objV == IntrinsicsKt.f()) {
            DebugProbesKt.c(continuation);
        }
        return objV;
    }

    public static final /* synthetic */ Object getAmazonLWAConsentStatus(Purchases purchases, Continuation continuation) throws PurchasesException {
        final CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.c(continuation), 1);
        cancellableContinuationImpl.C();
        ListenerConversionsKt.getAmazonLWAConsentStatusWith(purchases, new Function1<PurchasesError, Unit>() { // from class: com.revenuecat.purchases.CoroutinesExtensionsKt$getAmazonLWAConsentStatus$2$1
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
                CancellableContinuationExtensionsKt.safeResumeWithException(cancellableContinuationImpl, new PurchasesException(it));
            }
        }, new Function1<AmazonLWAConsentStatus, Unit>() { // from class: com.revenuecat.purchases.CoroutinesExtensionsKt$getAmazonLWAConsentStatus$2$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((AmazonLWAConsentStatus) obj);
                return Unit.f139807a;
            }

            public final void invoke(AmazonLWAConsentStatus it) {
                Intrinsics.checkNotNullParameter(it, "it");
                CancellableContinuationExtensionsKt.safeResume(cancellableContinuationImpl, it);
            }
        });
        Object objV = cancellableContinuationImpl.v();
        if (objV == IntrinsicsKt.f()) {
            DebugProbesKt.c(continuation);
        }
        return objV;
    }
}
