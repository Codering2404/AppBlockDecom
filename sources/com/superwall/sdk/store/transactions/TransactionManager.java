package com.superwall.sdk.store.transactions;

import androidx.media3.common.JBEE.bfIdKSjLOVjG;
import com.android.billingclient.api.BillingResult;
import com.android.billingclient.api.ProductDetails;
import com.android.billingclient.api.Purchase;
import com.facebook.internal.FacebookRequestErrorClassification;
import com.facebook.internal.Utility;
import com.google.firebase.crashlytics.internal.breadcrumbs.PKU.tDEtWsFLJfe;
import com.revenuecat.purchases.common.diagnostics.DiagnosticsTracker;
import com.revenuecat.purchases.common.networking.RCHTTPStatusCodes;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.superwall.sdk.Superwall;
import com.superwall.sdk.analytics.internal.TrackingKt;
import com.superwall.sdk.analytics.internal.trackable.InternalSuperwallEvent;
import com.superwall.sdk.analytics.internal.trackable.TrackableSuperwallEvent;
import com.superwall.sdk.billing.GoogleBillingWrapper;
import com.superwall.sdk.delegate.InternalPurchaseResult;
import com.superwall.sdk.delegate.subscription_controller.PurchaseController;
import com.superwall.sdk.dependencies.AttributesFactory;
import com.superwall.sdk.dependencies.CacheFactory;
import com.superwall.sdk.dependencies.DeviceHelperFactory;
import com.superwall.sdk.dependencies.EnrichmentFactory;
import com.superwall.sdk.dependencies.HasExternalPurchaseControllerFactory;
import com.superwall.sdk.dependencies.HasInternalPurchaseControllerFactory;
import com.superwall.sdk.dependencies.OptionsFactory;
import com.superwall.sdk.dependencies.StoreTransactionFactory;
import com.superwall.sdk.dependencies.TransactionVerifierFactory;
import com.superwall.sdk.dependencies.TriggerFactory;
import com.superwall.sdk.dependencies.WebToAppFactory;
import com.superwall.sdk.logger.LogLevel;
import com.superwall.sdk.logger.LogScope;
import com.superwall.sdk.logger.Logger;
import com.superwall.sdk.misc.ActivityProvider;
import com.superwall.sdk.misc.AlertControllerFactory;
import com.superwall.sdk.misc.IOScope;
import com.superwall.sdk.misc.ScopesKt;
import com.superwall.sdk.models.customer.CustomerInfo;
import com.superwall.sdk.models.entitlements.Entitlement;
import com.superwall.sdk.models.entitlements.SubscriptionStatus;
import com.superwall.sdk.paywall.presentation.PaywallInfo;
import com.superwall.sdk.paywall.presentation.internal.state.PaywallResult;
import com.superwall.sdk.paywall.view.PaywallViewState;
import com.superwall.sdk.storage.EventsQueue;
import com.superwall.sdk.storage.PurchasingProductdIds;
import com.superwall.sdk.storage.Storage;
import com.superwall.sdk.store.PurchasingObserverState;
import com.superwall.sdk.store.StoreManager;
import com.superwall.sdk.store.abstractions.product.RawStoreProduct;
import com.superwall.sdk.store.abstractions.product.StoreProduct;
import com.superwall.sdk.store.abstractions.transactions.StoreTransaction;
import com.superwall.sdk.store.testmode.TestMode;
import com.superwall.sdk.store.testmode.TestModeTransactionHandler;
import com.superwall.sdk.store.transactions.TransactionError;
import com.superwall.sdk.web.OpenWebRestoreKt;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.TimeoutKt;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;

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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class TransactionManager {
    private static final Companion Companion = new Companion(null);

    @Deprecated
    public static final long TRANSACTION_LOOKUP_TIMEOUT_MS = 5000;
    private final ActivityProvider activityProvider;
    private final Function0<Map<String, Set<Entitlement>>> allEntitlementsByProductId;
    private final Function0<CustomerInfo> currentCustomerInfo;
    private final Function3<String, PaywallResult, Continuation<? super Unit>, Object> dismiss;
    private final Function1<String, Set<Entitlement>> entitlementsById;
    private final EventsQueue eventsQueue;
    private final Factory factory;
    private final IOScope ioScope;
    private final Function1<Continuation<? super Unit>, Object> notifyBackendOfReceipts;
    private final Function2<String, Continuation<? super Unit>, Object> notifyOfTransactionAbandon;
    private final Function5<String, Long, String, Boolean, Continuation<? super Unit>, Object> notifyOfTransactionComplete;
    private final PurchaseController purchaseController;
    private final Function0<Unit> refreshReceipt;
    private final Function1<SubscriptionStatus, Unit> setSubscriptionStatus;
    private final Function1<AlertControllerFactory.AlertProps, Unit> showAlert;
    private final Function1<Continuation<? super Unit>, Object> showRestoreDialogForWeb;
    private final Storage storage;
    private final StoreManager storeManager;
    private final Function0<SubscriptionStatus> subscriptionStatus;
    private final TestMode testMode;
    private final TestModeTransactionHandler testModeTransactionHandler;
    private final Function2<TrackableSuperwallEvent, Continuation<? super Unit>, Object> track;
    private ConcurrentHashMap<String, ProductDetails> transactionsInProgress;
    private final Function2<String, PaywallViewState.Updates, Unit> updateState;
    private final Function0<Set<Entitlement>> webEntitlements;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX INFO: renamed from: com.superwall.sdk.store.transactions.TransactionManager$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "com.superwall.sdk.store.transactions.TransactionManager$1", f = "TransactionManager.kt", l = {74}, m = "invokeSuspend")
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<TrackableSuperwallEvent, Continuation<? super Unit>, Object> {
        /* synthetic */ Object L$0;
        int label;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(TrackableSuperwallEvent trackableSuperwallEvent, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(trackableSuperwallEvent, continuation)).invokeSuspend(Unit.f139807a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objF = IntrinsicsKt.f();
            int i3 = this.label;
            if (i3 == 0) {
                ResultKt.b(obj);
                TrackableSuperwallEvent trackableSuperwallEvent = (TrackableSuperwallEvent) this.L$0;
                Superwall companion = Superwall.Companion.getInstance();
                this.label = 1;
                if (TrackingKt.track(companion, trackableSuperwallEvent, this) == objF) {
                    return objF;
                }
            } else {
                if (i3 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.b(obj);
                ((Result) obj).j();
            }
            return Unit.f139807a;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX INFO: renamed from: com.superwall.sdk.store.transactions.TransactionManager$5, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "com.superwall.sdk.store.transactions.TransactionManager$5", f = "TransactionManager.kt", l = {}, m = "invokeSuspend")
    public static final class AnonymousClass5 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        int label;

        AnonymousClass5(Continuation<? super AnonymousClass5> continuation) {
            super(1, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return new AnonymousClass5(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            IntrinsicsKt.f();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
            return Unit.f139807a;
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Unit> continuation) {
            return ((AnonymousClass5) create(continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX INFO: renamed from: com.superwall.sdk.store.transactions.TransactionManager$6, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "com.superwall.sdk.store.transactions.TransactionManager$6", f = "TransactionManager.kt", l = {}, m = "invokeSuspend")
    public static final class AnonymousClass6 extends SuspendLambda implements Function2<String, Continuation<? super Unit>, Object> {
        int label;

        AnonymousClass6(Continuation<? super AnonymousClass6> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass6(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            IntrinsicsKt.f();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
            return Unit.f139807a;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(String str, Continuation<? super Unit> continuation) {
            return ((AnonymousClass6) create(str, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX INFO: renamed from: com.superwall.sdk.store.transactions.TransactionManager$7, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "com.superwall.sdk.store.transactions.TransactionManager$7", f = "TransactionManager.kt", l = {145}, m = "invokeSuspend")
    static final class AnonymousClass7 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        /* JADX INFO: renamed from: com.superwall.sdk.store.transactions.TransactionManager$7$1, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        @DebugMetadata(c = "com.superwall.sdk.store.transactions.TransactionManager$7$1", f = "TransactionManager.kt", l = {}, m = "invokeSuspend")
        static final class AnonymousClass1 extends SuspendLambda implements Function2<InternalPurchaseResult, Continuation<? super Boolean>, Object> {
            int label;
            final /* synthetic */ TransactionManager this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass1(TransactionManager transactionManager, Continuation<? super AnonymousClass1> continuation) {
                super(2, continuation);
                this.this$0 = transactionManager;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new AnonymousClass1(this.this$0, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(InternalPurchaseResult internalPurchaseResult, Continuation<? super Boolean> continuation) {
                return ((AnonymousClass1) create(internalPurchaseResult, continuation)).invokeSuspend(Unit.f139807a);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) throws Throwable {
                IntrinsicsKt.f();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.b(obj);
                return Boxing.a(this.this$0.transactionsInProgress.isEmpty());
            }
        }

        /* JADX INFO: renamed from: com.superwall.sdk.store.transactions.TransactionManager$7$2, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        @DebugMetadata(c = "com.superwall.sdk.store.transactions.TransactionManager$7$2", f = "TransactionManager.kt", l = {184}, m = "invokeSuspend")
        static final class AnonymousClass2 extends SuspendLambda implements Function2<InternalPurchaseResult, Continuation<? super Unit>, Object> {
            /* synthetic */ Object L$0;
            int label;
            final /* synthetic */ TransactionManager this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass2(TransactionManager transactionManager, Continuation<? super AnonymousClass2> continuation) {
                super(2, continuation);
                this.this$0 = transactionManager;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                AnonymousClass2 anonymousClass2 = new AnonymousClass2(this.this$0, continuation);
                anonymousClass2.L$0 = obj;
                return anonymousClass2;
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(InternalPurchaseResult internalPurchaseResult, Continuation<? super Unit> continuation) {
                return ((AnonymousClass2) create(internalPurchaseResult, continuation)).invokeSuspend(Unit.f139807a);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) throws Throwable {
                Throwable th;
                PurchasingObserverState purchaseError;
                Object objF = IntrinsicsKt.f();
                int i3 = this.label;
                if (i3 == 0) {
                    ResultKt.b(obj);
                    InternalPurchaseResult internalPurchaseResult = (InternalPurchaseResult) this.L$0;
                    if (internalPurchaseResult instanceof InternalPurchaseResult.Purchased) {
                        InternalPurchaseResult.Purchased purchased = (InternalPurchaseResult.Purchased) internalPurchaseResult;
                        List listC = purchased.getPurchase().c();
                        Intrinsics.checkNotNullExpressionValue(listC, "getProducts(...)");
                        TransactionManager transactionManager = this.this$0;
                        Iterator it = listC.iterator();
                        while (it.hasNext()) {
                            transactionManager.transactionsInProgress.remove((String) it.next());
                        }
                        BillingResult billingResultA = BillingResult.d().d(0).a();
                        Intrinsics.checkNotNullExpressionValue(billingResultA, "build(...)");
                        purchaseError = new PurchasingObserverState.PurchaseResult(billingResultA, CollectionsKt.listOf(purchased.getPurchase()));
                    } else if (internalPurchaseResult instanceof InternalPurchaseResult.Cancelled) {
                        Set setEntrySet = this.this$0.transactionsInProgress.entrySet();
                        Intrinsics.checkNotNullExpressionValue(setEntrySet, "<get-entries>(...)");
                        Object objLast = CollectionsKt.last(setEntrySet);
                        Intrinsics.checkNotNullExpressionValue(objLast, "last(...)");
                        this.this$0.transactionsInProgress.remove(((Map.Entry) objLast).getKey());
                        BillingResult billingResultA2 = BillingResult.d().d(1).a();
                        Intrinsics.checkNotNullExpressionValue(billingResultA2, "build(...)");
                        purchaseError = new PurchasingObserverState.PurchaseResult(billingResultA2, CollectionsKt.emptyList());
                    } else {
                        Set setEntrySet2 = this.this$0.transactionsInProgress.entrySet();
                        Intrinsics.checkNotNullExpressionValue(setEntrySet2, "<get-entries>(...)");
                        Object objLast2 = CollectionsKt.last(setEntrySet2);
                        Intrinsics.checkNotNullExpressionValue(objLast2, "last(...)");
                        Map.Entry entry = (Map.Entry) objLast2;
                        this.this$0.transactionsInProgress.remove(entry.getKey());
                        InternalPurchaseResult.Failed failed = internalPurchaseResult instanceof InternalPurchaseResult.Failed ? (InternalPurchaseResult.Failed) internalPurchaseResult : null;
                        if (failed == null || (th = failed.getError()) == null) {
                            th = new Throwable("Unknown error");
                        }
                        Object value = entry.getValue();
                        Intrinsics.checkNotNullExpressionValue(value, "<get-value>(...)");
                        purchaseError = new PurchasingObserverState.PurchaseError((ProductDetails) value, th);
                    }
                    TransactionManager transactionManager2 = this.this$0;
                    this.label = 1;
                    if (transactionManager2.handle$superwall_release(internalPurchaseResult, purchaseError, this) == objF) {
                        return objF;
                    }
                } else {
                    if (i3 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.b(obj);
                }
                return Unit.f139807a;
            }
        }

        AnonymousClass7(Continuation<? super AnonymousClass7> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return TransactionManager.this.new AnonymousClass7(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objF = IntrinsicsKt.f();
            int i3 = this.label;
            if (i3 == 0) {
                ResultKt.b(obj);
                Flow flowC = FlowKt.C(FlowKt.y(FlowKt.b(TransactionManager.this.storeManager.getBilling().getPurchaseResults()), new AnonymousClass1(TransactionManager.this, null)));
                AnonymousClass2 anonymousClass2 = new AnonymousClass2(TransactionManager.this, null);
                this.label = 1;
                if (FlowKt.l(flowC, anonymousClass2, this) == objF) {
                    return objF;
                }
            } else {
                if (i3 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.b(obj);
            }
            return Unit.f139807a;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass7) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
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

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public interface Factory extends OptionsFactory, TriggerFactory, TransactionVerifierFactory, StoreTransactionFactory, DeviceHelperFactory, CacheFactory, HasExternalPurchaseControllerFactory, HasInternalPurchaseControllerFactory, WebToAppFactory, AttributesFactory, EnrichmentFactory {
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static abstract class PurchaseSource {

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class ExternalPurchase extends PurchaseSource {
            private final StoreProduct product;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public ExternalPurchase(StoreProduct product) {
                super(null);
                Intrinsics.checkNotNullParameter(product, "product");
                this.product = product;
            }

            public static /* synthetic */ ExternalPurchase copy$default(ExternalPurchase externalPurchase, StoreProduct storeProduct, int i3, Object obj) {
                if ((i3 & 1) != 0) {
                    storeProduct = externalPurchase.product;
                }
                return externalPurchase.copy(storeProduct);
            }

            public final StoreProduct component1() {
                return this.product;
            }

            public final ExternalPurchase copy(StoreProduct product) {
                Intrinsics.checkNotNullParameter(product, "product");
                return new ExternalPurchase(product);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof ExternalPurchase) && Intrinsics.areEqual(this.product, ((ExternalPurchase) obj).product);
            }

            public final StoreProduct getProduct() {
                return this.product;
            }

            public int hashCode() {
                return this.product.hashCode();
            }

            public String toString() {
                return "ExternalPurchase(product=" + this.product + ")";
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class Internal extends PurchaseSource {
            private final String productId;
            private final PaywallViewState state;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Internal(String productId, PaywallViewState state) {
                super(null);
                Intrinsics.checkNotNullParameter(productId, "productId");
                Intrinsics.checkNotNullParameter(state, "state");
                this.productId = productId;
                this.state = state;
            }

            public static /* synthetic */ Internal copy$default(Internal internal, String str, PaywallViewState paywallViewState, int i3, Object obj) {
                if ((i3 & 1) != 0) {
                    str = internal.productId;
                }
                if ((i3 & 2) != 0) {
                    paywallViewState = internal.state;
                }
                return internal.copy(str, paywallViewState);
            }

            public final String component1() {
                return this.productId;
            }

            public final PaywallViewState component2() {
                return this.state;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof Internal)) {
                    return false;
                }
                Internal internal = (Internal) obj;
                return Intrinsics.areEqual(this.productId, internal.productId) && Intrinsics.areEqual(this.state, internal.state);
            }

            public final PaywallInfo getPaywallInfo() {
                return this.state.getInfo();
            }

            public final String getProductId() {
                return this.productId;
            }

            public final PaywallViewState getState() {
                return this.state;
            }

            public int hashCode() {
                return (this.productId.hashCode() * 31) + this.state.hashCode();
            }

            public String toString() {
                return "Internal(productId=" + this.productId + ", state=" + this.state + ")";
            }

            public final Internal copy(String productId, PaywallViewState paywallViewState) {
                Intrinsics.checkNotNullParameter(productId, "productId");
                Intrinsics.checkNotNullParameter(paywallViewState, bfIdKSjLOVjG.QSmGTNmmRRAg);
                return new Internal(productId, paywallViewState);
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class ObserverMode extends PurchaseSource {
            private final StoreProduct product;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public ObserverMode(StoreProduct product) {
                super(null);
                Intrinsics.checkNotNullParameter(product, "product");
                this.product = product;
            }

            public static /* synthetic */ ObserverMode copy$default(ObserverMode observerMode, StoreProduct storeProduct, int i3, Object obj) {
                if ((i3 & 1) != 0) {
                    storeProduct = observerMode.product;
                }
                return observerMode.copy(storeProduct);
            }

            public final StoreProduct component1() {
                return this.product;
            }

            public final ObserverMode copy(StoreProduct product) {
                Intrinsics.checkNotNullParameter(product, "product");
                return new ObserverMode(product);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof ObserverMode) && Intrinsics.areEqual(this.product, ((ObserverMode) obj).product);
            }

            public final StoreProduct getProduct() {
                return this.product;
            }

            public int hashCode() {
                return this.product.hashCode();
            }

            public String toString() {
                return "ObserverMode(product=" + this.product + ")";
            }
        }

        public /* synthetic */ PurchaseSource(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private PurchaseSource() {
        }
    }

    /* JADX INFO: renamed from: com.superwall.sdk.store.transactions.TransactionManager$awaitLatestTransaction$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "com.superwall.sdk.store.transactions.TransactionManager$awaitLatestTransaction$2", f = "TransactionManager.kt", l = {1163}, m = "invokeSuspend")
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super StoreTransaction>, Object> {
        final /* synthetic */ GoogleBillingWrapper $transactionVerifier;
        int label;
        final /* synthetic */ TransactionManager this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(GoogleBillingWrapper googleBillingWrapper, TransactionManager transactionManager, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.$transactionVerifier = googleBillingWrapper;
            this.this$0 = transactionManager;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass2(this.$transactionVerifier, this.this$0, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objF = IntrinsicsKt.f();
            int i3 = this.label;
            if (i3 != 0) {
                if (i3 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.b(obj);
                return obj;
            }
            ResultKt.b(obj);
            GoogleBillingWrapper googleBillingWrapper = this.$transactionVerifier;
            Factory factory = this.this$0.factory;
            this.label = 1;
            Object latestTransaction = googleBillingWrapper.getLatestTransaction(factory, this);
            return latestTransaction == objF ? objF : latestTransaction;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super StoreTransaction> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX INFO: renamed from: com.superwall.sdk.store.transactions.TransactionManager$didPurchase$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "com.superwall.sdk.store.transactions.TransactionManager", f = "TransactionManager.kt", l = {822, 824, 828, 831, 851, 853, 858, 862}, m = "didPurchase")
    static final class C29331 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        boolean Z$0;
        boolean Z$1;
        int label;
        /* synthetic */ Object result;

        C29331(Continuation<? super C29331> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return TransactionManager.this.didPurchase(null, null, false, null, false, this);
        }
    }

    /* JADX INFO: renamed from: com.superwall.sdk.store.transactions.TransactionManager$didPurchase$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "com.superwall.sdk.store.transactions.TransactionManager$didPurchase$2", f = "TransactionManager.kt", l = {}, m = "invokeSuspend")
    static final class C29342 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ StoreProduct $product;
        final /* synthetic */ PurchaseSource $purchaseSource;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C29342(StoreProduct storeProduct, PurchaseSource purchaseSource, Continuation<? super C29342> continuation) {
            super(2, continuation);
            this.$product = storeProduct;
            this.$purchaseSource = purchaseSource;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return TransactionManager.this.new C29342(this.$product, this.$purchaseSource, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            IntrinsicsKt.f();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
            TransactionManager.log$default(TransactionManager.this, null, "Transaction Succeeded", MapsKt.mapOf(TuplesKt.a(DiagnosticsTracker.PRODUCT_ID_KEY, this.$product.getFullIdentifier()), TuplesKt.a("paywall_state", ((PurchaseSource.Internal) this.$purchaseSource).getState())), null, 9, null);
            return Unit.f139807a;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C29342) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX INFO: renamed from: com.superwall.sdk.store.transactions.TransactionManager$didPurchase$3, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "com.superwall.sdk.store.transactions.TransactionManager$didPurchase$3", f = "TransactionManager.kt", l = {826}, m = "invokeSuspend")
    static final class AnonymousClass3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        AnonymousClass3(Continuation<? super AnonymousClass3> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return TransactionManager.this.new AnonymousClass3(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objF = IntrinsicsKt.f();
            int i3 = this.label;
            if (i3 == 0) {
                ResultKt.b(obj);
                Function1 function1 = TransactionManager.this.notifyBackendOfReceipts;
                this.label = 1;
                if (function1.invoke(this) == objF) {
                    return objF;
                }
            } else {
                if (i3 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.b(obj);
            }
            return Unit.f139807a;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass3) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX INFO: renamed from: com.superwall.sdk.store.transactions.TransactionManager$didPurchase$4, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "com.superwall.sdk.store.transactions.TransactionManager$didPurchase$4", f = "TransactionManager.kt", l = {860}, m = "invokeSuspend")
    static final class AnonymousClass4 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        AnonymousClass4(Continuation<? super AnonymousClass4> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return TransactionManager.this.new AnonymousClass4(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objF = IntrinsicsKt.f();
            int i3 = this.label;
            if (i3 == 0) {
                ResultKt.b(obj);
                Function1 function1 = TransactionManager.this.notifyBackendOfReceipts;
                this.label = 1;
                if (function1.invoke(this) == objF) {
                    return objF;
                }
            } else {
                if (i3 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.b(obj);
            }
            return Unit.f139807a;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass4) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX INFO: renamed from: com.superwall.sdk.store.transactions.TransactionManager$didRestore$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "com.superwall.sdk.store.transactions.TransactionManager", f = "TransactionManager.kt", l = {614, 636, 640}, m = "didRestore")
    static final class C29351 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        C29351(Continuation<? super C29351> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return TransactionManager.this.didRestore(null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.superwall.sdk.store.transactions.TransactionManager$didRestore$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "com.superwall.sdk.store.transactions.TransactionManager$didRestore$2", f = "TransactionManager.kt", l = {646}, m = "invokeSuspend")
    static final class C29362 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C29362(Continuation<? super C29362> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return TransactionManager.this.new C29362(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objF = IntrinsicsKt.f();
            int i3 = this.label;
            if (i3 == 0) {
                ResultKt.b(obj);
                Function1 function1 = TransactionManager.this.notifyBackendOfReceipts;
                this.label = 1;
                if (function1.invoke(this) == objF) {
                    return objF;
                }
            } else {
                if (i3 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.b(obj);
            }
            return Unit.f139807a;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C29362) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX INFO: renamed from: com.superwall.sdk.store.transactions.TransactionManager$handleCustomProductPurchase$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "com.superwall.sdk.store.transactions.TransactionManager", f = "TransactionManager.kt", l = {475, 477, 502, 512, 530, 542, 547, 555, 561, 566, 582, 586, 597, 601}, m = "handleCustomProductPurchase")
    static final class C29371 extends ContinuationImpl {
        int I$0;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        boolean Z$0;
        boolean Z$1;
        int label;
        /* synthetic */ Object result;

        C29371(Continuation<? super C29371> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return TransactionManager.this.handleCustomProductPurchase(null, null, false, this);
        }
    }

    /* JADX INFO: renamed from: com.superwall.sdk.store.transactions.TransactionManager$handlePendingTransaction$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "com.superwall.sdk.store.transactions.TransactionManager", f = "TransactionManager.kt", l = {961, 989}, m = "handlePendingTransaction")
    static final class C29381 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C29381(Continuation<? super C29381> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return TransactionManager.this.handlePendingTransaction(null, this);
        }
    }

    /* JADX INFO: renamed from: com.superwall.sdk.store.transactions.TransactionManager$handlePendingTransaction$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "com.superwall.sdk.store.transactions.TransactionManager$handlePendingTransaction$2", f = "TransactionManager.kt", l = {}, m = "invokeSuspend")
    static final class C29392 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ PurchaseSource $purchaseSource;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C29392(PurchaseSource purchaseSource, Continuation<? super C29392> continuation) {
            super(2, continuation);
            this.$purchaseSource = purchaseSource;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return TransactionManager.this.new C29392(this.$purchaseSource, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            IntrinsicsKt.f();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
            TransactionManager.log$default(TransactionManager.this, null, "Transaction Pending", MapsKt.mapOf(TuplesKt.a("paywall", ((PurchaseSource.Internal) this.$purchaseSource).getPaywallInfo())), null, 9, null);
            return Unit.f139807a;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C29392) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX INFO: renamed from: com.superwall.sdk.store.transactions.TransactionManager$handlePendingTransaction$3, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "com.superwall.sdk.store.transactions.TransactionManager$handlePendingTransaction$3", f = "TransactionManager.kt", l = {}, m = "invokeSuspend")
    static final class C29403 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C29403(Continuation<? super C29403> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return TransactionManager.this.new C29403(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            IntrinsicsKt.f();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
            TransactionManager.log$default(TransactionManager.this, null, "Transaction Pending", null, null, 13, null);
            return Unit.f139807a;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C29403) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX INFO: renamed from: com.superwall.sdk.store.transactions.TransactionManager$presentAlert$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "com.superwall.sdk.store.transactions.TransactionManager$presentAlert$2", f = "TransactionManager.kt", l = {}, m = "invokeSuspend")
    static final class C29412 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Error $error;
        final /* synthetic */ StoreProduct $product;
        final /* synthetic */ PaywallViewState $state;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C29412(StoreProduct storeProduct, PaywallViewState paywallViewState, Error error, Continuation<? super C29412> continuation) {
            super(2, continuation);
            this.$product = storeProduct;
            this.$state = paywallViewState;
            this.$error = error;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return TransactionManager.this.new C29412(this.$product, this.$state, this.$error, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            IntrinsicsKt.f();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
            TransactionManager.log$default(TransactionManager.this, null, "Transaction Error", MapsKt.mapOf(TuplesKt.a(DiagnosticsTracker.PRODUCT_ID_KEY, this.$product.getFullIdentifier()), TuplesKt.a("paywall_state", this.$state)), this.$error, 1, null);
            return Unit.f139807a;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C29412) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX INFO: renamed from: com.superwall.sdk.store.transactions.TransactionManager$purchase$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "com.superwall.sdk.store.transactions.TransactionManager", f = "TransactionManager.kt", l = {316, 317, 323, 326, 337, FacebookRequestErrorClassification.EC_TOO_MANY_USER_ACTION_CALLS, 355, 358, 367, 381, 383, RCHTTPStatusCodes.UNAUTHORIZED, 408, 418, 440, 444}, m = "purchase")
    static final class C29421 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        boolean Z$0;
        int label;
        /* synthetic */ Object result;

        C29421(Continuation<? super C29421> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return TransactionManager.this.purchase(null, false, this);
        }
    }

    /* JADX INFO: renamed from: com.superwall.sdk.store.transactions.TransactionManager$trackCancelled$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "com.superwall.sdk.store.transactions.TransactionManager", f = "TransactionManager.kt", l = {899, 901, 930}, m = "trackCancelled")
    static final class C29431 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C29431(Continuation<? super C29431> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return TransactionManager.this.trackCancelled(null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.superwall.sdk.store.transactions.TransactionManager$trackCancelled$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "com.superwall.sdk.store.transactions.TransactionManager$trackCancelled$2", f = "TransactionManager.kt", l = {}, m = "invokeSuspend")
    static final class C29442 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ StoreProduct $product;
        final /* synthetic */ PurchaseSource $purchaseSource;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C29442(StoreProduct storeProduct, PurchaseSource purchaseSource, Continuation<? super C29442> continuation) {
            super(2, continuation);
            this.$product = storeProduct;
            this.$purchaseSource = purchaseSource;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return TransactionManager.this.new C29442(this.$product, this.$purchaseSource, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            IntrinsicsKt.f();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
            TransactionManager.log$default(TransactionManager.this, null, "Transaction Abandoned", MapsKt.mapOf(TuplesKt.a(DiagnosticsTracker.PRODUCT_ID_KEY, this.$product.getFullIdentifier()), TuplesKt.a("paywall_state", ((PurchaseSource.Internal) this.$purchaseSource).getState())), null, 9, null);
            return Unit.f139807a;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C29442) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX INFO: renamed from: com.superwall.sdk.store.transactions.TransactionManager$trackCancelled$3, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "com.superwall.sdk.store.transactions.TransactionManager$trackCancelled$3", f = "TransactionManager.kt", l = {}, m = "invokeSuspend")
    static final class C29453 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ StoreProduct $product;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C29453(StoreProduct storeProduct, Continuation<? super C29453> continuation) {
            super(2, continuation);
            this.$product = storeProduct;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return TransactionManager.this.new C29453(this.$product, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            IntrinsicsKt.f();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
            TransactionManager.log$default(TransactionManager.this, null, "Transaction Abandoned", MapsKt.mapOf(TuplesKt.a(DiagnosticsTracker.PRODUCT_ID_KEY, this.$product.getFullIdentifier())), null, 9, null);
            return Unit.f139807a;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C29453) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX INFO: renamed from: com.superwall.sdk.store.transactions.TransactionManager$trackFailure$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "com.superwall.sdk.store.transactions.TransactionManager$trackFailure$1", f = "TransactionManager.kt", l = {686}, m = "invokeSuspend")
    static final class C29461 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $errorMessage;
        final /* synthetic */ StoreProduct $product;
        final /* synthetic */ PurchaseSource $purchaseSource;
        int label;
        final /* synthetic */ TransactionManager this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C29461(PurchaseSource purchaseSource, String str, StoreProduct storeProduct, TransactionManager transactionManager, Continuation<? super C29461> continuation) {
            super(2, continuation);
            this.$purchaseSource = purchaseSource;
            this.$errorMessage = str;
            this.$product = storeProduct;
            this.this$0 = transactionManager;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C29461(this.$purchaseSource, this.$errorMessage, this.$product, this.this$0, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objF = IntrinsicsKt.f();
            int i3 = this.label;
            if (i3 == 0) {
                ResultKt.b(obj);
                PaywallInfo paywallInfo = ((PurchaseSource.Internal) this.$purchaseSource).getPaywallInfo();
                InternalSuperwallEvent.Transaction.State.Fail fail = new InternalSuperwallEvent.Transaction.State.Fail(new TransactionError.Failure(this.$errorMessage, this.$product));
                boolean shouldObservePurchases = this.this$0.factory.makeSuperwallOptions().getShouldObservePurchases();
                InternalSuperwallEvent.Transaction transaction = new InternalSuperwallEvent.Transaction(fail, paywallInfo, this.$product, null, InternalSuperwallEvent.Transaction.TransactionSource.INTERNAL, shouldObservePurchases, this.this$0.factory.demandScore(), this.this$0.factory.demandTier(), null, null, null, 1792, null);
                InternalSuperwallEvent.Transaction.State state = transaction.getState();
                Intrinsics.checkNotNull(state, "null cannot be cast to non-null type com.superwall.sdk.analytics.internal.trackable.InternalSuperwallEvent.Transaction.State.Fail");
                Function2 function2 = this.this$0.track;
                this.label = 1;
                if (function2.invoke(transaction, this) == objF) {
                    return objF;
                }
            } else {
                if (i3 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.b(obj);
            }
            return Unit.f139807a;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C29461) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX INFO: renamed from: com.superwall.sdk.store.transactions.TransactionManager$trackFailure$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "com.superwall.sdk.store.transactions.TransactionManager$trackFailure$2", f = "TransactionManager.kt", l = {714}, m = "invokeSuspend")
    static final class C29472 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $errorMessage;
        final /* synthetic */ StoreProduct $product;
        final /* synthetic */ PurchaseSource $purchaseSource;
        int label;
        final /* synthetic */ TransactionManager this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C29472(String str, StoreProduct storeProduct, PurchaseSource purchaseSource, TransactionManager transactionManager, Continuation<? super C29472> continuation) {
            super(2, continuation);
            this.$errorMessage = str;
            this.$product = storeProduct;
            this.$purchaseSource = purchaseSource;
            this.this$0 = transactionManager;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C29472(this.$errorMessage, this.$product, this.$purchaseSource, this.this$0, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objF = IntrinsicsKt.f();
            int i3 = this.label;
            if (i3 == 0) {
                ResultKt.b(obj);
                InternalSuperwallEvent.Transaction.State.Fail fail = new InternalSuperwallEvent.Transaction.State.Fail(new TransactionError.Failure(this.$errorMessage, this.$product));
                PaywallInfo paywallInfoEmpty = PaywallInfo.Companion.empty();
                boolean z2 = this.$purchaseSource instanceof PurchaseSource.ObserverMode;
                InternalSuperwallEvent.Transaction transaction = new InternalSuperwallEvent.Transaction(fail, paywallInfoEmpty, this.$product, null, InternalSuperwallEvent.Transaction.TransactionSource.EXTERNAL, z2, this.this$0.factory.demandScore(), this.this$0.factory.demandTier(), null, null, null, 1792, null);
                Function2 function2 = this.this$0.track;
                this.label = 1;
                if (function2.invoke(transaction, this) == objF) {
                    return objF;
                }
            } else {
                if (i3 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.b(obj);
            }
            return Unit.f139807a;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C29472) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX INFO: renamed from: com.superwall.sdk.store.transactions.TransactionManager$trackTransactionDidSucceed$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "com.superwall.sdk.store.transactions.TransactionManager", f = "TransactionManager.kt", l = {1199, 1200, 1207, 1209, 1218, 1222, 1241, 1242, 1250, 1255, 1262}, m = "trackTransactionDidSucceed")
    static final class C29481 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        boolean Z$0;
        int label;
        /* synthetic */ Object result;

        C29481(Continuation<? super C29481> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return TransactionManager.this.trackTransactionDidSucceed(null, null, null, false, this);
        }
    }

    /* JADX INFO: renamed from: com.superwall.sdk.store.transactions.TransactionManager$tryToRestorePurchases$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "com.superwall.sdk.store.transactions.TransactionManager", f = "TransactionManager.kt", l = {1005, 1016, 1022, 1029, 1045, 1052, 1078}, m = "tryToRestorePurchases")
    static final class C29491 extends ContinuationImpl {
        int I$0;
        int I$1;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        boolean Z$0;
        int label;
        /* synthetic */ Object result;

        C29491(Continuation<? super C29491> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return TransactionManager.this.tryToRestorePurchases(null, this);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public TransactionManager(StoreManager storeManager, PurchaseController purchaseController, EventsQueue eventsQueue, Storage storage, ActivityProvider activityProvider, Factory factory, IOScope ioScope, Function2<? super TrackableSuperwallEvent, ? super Continuation<? super Unit>, ? extends Object> track, Function3<? super String, ? super PaywallResult, ? super Continuation<? super Unit>, ? extends Object> dismiss, Function1<? super AlertControllerFactory.AlertProps, Unit> function1, Function0<? extends SubscriptionStatus> subscriptionStatus, Function1<? super String, ? extends Set<Entitlement>> entitlementsById, Function0<? extends Map<String, ? extends Set<Entitlement>>> allEntitlementsByProductId, Function0<? extends Set<Entitlement>> webEntitlements, Function0<CustomerInfo> currentCustomerInfo, Function1<? super Continuation<? super Unit>, ? extends Object> showRestoreDialogForWeb, Function1<? super Continuation<? super Unit>, ? extends Object> notifyBackendOfReceipts, Function0<Unit> refreshReceipt, Function2<? super String, ? super PaywallViewState.Updates, Unit> updateState, Function5<? super String, ? super Long, ? super String, ? super Boolean, ? super Continuation<? super Unit>, ? extends Object> notifyOfTransactionComplete, Function2<? super String, ? super Continuation<? super Unit>, ? extends Object> notifyOfTransactionAbandon, TestMode testMode, TestModeTransactionHandler testModeTransactionHandler, Function1<? super SubscriptionStatus, Unit> function12) {
        Intrinsics.checkNotNullParameter(storeManager, "storeManager");
        Intrinsics.checkNotNullParameter(purchaseController, "purchaseController");
        Intrinsics.checkNotNullParameter(eventsQueue, "eventsQueue");
        Intrinsics.checkNotNullParameter(storage, "storage");
        Intrinsics.checkNotNullParameter(activityProvider, "activityProvider");
        Intrinsics.checkNotNullParameter(factory, "factory");
        Intrinsics.checkNotNullParameter(ioScope, "ioScope");
        Intrinsics.checkNotNullParameter(track, "track");
        Intrinsics.checkNotNullParameter(dismiss, "dismiss");
        Intrinsics.checkNotNullParameter(function1, tDEtWsFLJfe.mBUvU);
        Intrinsics.checkNotNullParameter(subscriptionStatus, "subscriptionStatus");
        Intrinsics.checkNotNullParameter(entitlementsById, "entitlementsById");
        Intrinsics.checkNotNullParameter(allEntitlementsByProductId, "allEntitlementsByProductId");
        Intrinsics.checkNotNullParameter(webEntitlements, "webEntitlements");
        Intrinsics.checkNotNullParameter(currentCustomerInfo, "currentCustomerInfo");
        Intrinsics.checkNotNullParameter(showRestoreDialogForWeb, "showRestoreDialogForWeb");
        Intrinsics.checkNotNullParameter(notifyBackendOfReceipts, "notifyBackendOfReceipts");
        Intrinsics.checkNotNullParameter(refreshReceipt, "refreshReceipt");
        Intrinsics.checkNotNullParameter(updateState, "updateState");
        Intrinsics.checkNotNullParameter(notifyOfTransactionComplete, "notifyOfTransactionComplete");
        Intrinsics.checkNotNullParameter(notifyOfTransactionAbandon, "notifyOfTransactionAbandon");
        this.storeManager = storeManager;
        this.purchaseController = purchaseController;
        this.eventsQueue = eventsQueue;
        this.storage = storage;
        this.activityProvider = activityProvider;
        this.factory = factory;
        this.ioScope = ioScope;
        this.track = track;
        this.dismiss = dismiss;
        this.showAlert = function1;
        this.subscriptionStatus = subscriptionStatus;
        this.entitlementsById = entitlementsById;
        this.allEntitlementsByProductId = allEntitlementsByProductId;
        this.webEntitlements = webEntitlements;
        this.currentCustomerInfo = currentCustomerInfo;
        this.showRestoreDialogForWeb = showRestoreDialogForWeb;
        this.notifyBackendOfReceipts = notifyBackendOfReceipts;
        this.refreshReceipt = refreshReceipt;
        this.updateState = updateState;
        this.notifyOfTransactionComplete = notifyOfTransactionComplete;
        this.notifyOfTransactionAbandon = notifyOfTransactionAbandon;
        this.testMode = testMode;
        this.testModeTransactionHandler = testModeTransactionHandler;
        this.setSubscriptionStatus = function12;
        this.transactionsInProgress = new ConcurrentHashMap<>();
        if (getShouldObserveTransactionFinishingAutomatically()) {
            BuildersKt__Builders_commonKt.d(ioScope, null, null, new AnonymousClass7(null), 3, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SubscriptionStatus _init_$lambda$0() {
        return (SubscriptionStatus) Superwall.Companion.getInstance().getEntitlements().getStatus().getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Set _init_$lambda$1() {
        return Superwall.Companion.getInstance().getEntitlements().getWeb();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CustomerInfo _init_$lambda$2() {
        return Superwall.Companion.getInstance().getCustomerInfo();
    }

    private final void askToRestoreFromWeb() {
        boolean zIsEmpty = Superwall.Companion.getInstance().getEntitlements().getActiveDeviceEntitlements$superwall_release().isEmpty();
        this.showAlert.invoke(new AlertControllerFactory.AlertProps(!zIsEmpty ? "Restore via the web?" : "No Subscription Found", !zIsEmpty ? "Your Play Store subscriptions were restored. Would you like to check for more on the web?" : "No Play Store subscription found, would you like to check on the web?", "Yes", "Close", new Function0() { // from class: com.superwall.sdk.store.transactions.a
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return TransactionManager.askToRestoreFromWeb$lambda$17();
            }
        }, null, 32, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit askToRestoreFromWeb$lambda$17() {
        OpenWebRestoreKt.openRestoreOnWeb(Superwall.Companion.getInstance());
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object awaitLatestTransaction(Continuation<? super StoreTransaction> continuation) {
        GoogleBillingWrapper googleBillingWrapperMakeTransactionVerifier = this.factory.makeTransactionVerifier();
        return this.factory.makeHasExternalPurchaseController() ? TimeoutKt.e(5000L, new AnonymousClass2(googleBillingWrapperMakeTransactionVerifier, this, null), continuation) : googleBillingWrapperMakeTransactionVerifier.getLatestTransaction(this.factory, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x018c, code lost:
    
        if (r1.invoke(r2, r3, r13) == r11) goto L70;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x0258, code lost:
    
        if (r7.trackTransactionDidSucceed(r4, r6, r5, r3, r13) != r11) goto L71;
     */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0120  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0158 A[PHI: r3 r4 r5 r6 r13
      0x0158: PHI (r3v11 boolean) = (r3v9 boolean), (r3v14 boolean) binds: [B:31:0x0154, B:17:0x0084] A[DONT_GENERATE, DONT_INLINE]
      0x0158: PHI (r4v11 com.superwall.sdk.store.transactions.TransactionManager$PurchaseSource) = 
      (r4v9 com.superwall.sdk.store.transactions.TransactionManager$PurchaseSource)
      (r4v18 com.superwall.sdk.store.transactions.TransactionManager$PurchaseSource)
     binds: [B:31:0x0154, B:17:0x0084] A[DONT_GENERATE, DONT_INLINE]
      0x0158: PHI (r5v13 com.superwall.sdk.store.abstractions.product.StoreProduct) = 
      (r5v10 com.superwall.sdk.store.abstractions.product.StoreProduct)
      (r5v15 com.superwall.sdk.store.abstractions.product.StoreProduct)
     binds: [B:31:0x0154, B:17:0x0084] A[DONT_GENERATE, DONT_INLINE]
      0x0158: PHI (r6v13 com.superwall.sdk.store.transactions.TransactionManager) = 
      (r6v10 com.superwall.sdk.store.transactions.TransactionManager)
      (r6v15 com.superwall.sdk.store.transactions.TransactionManager)
     binds: [B:31:0x0154, B:17:0x0084] A[DONT_GENERATE, DONT_INLINE]
      0x0158: PHI (r13v3 com.superwall.sdk.store.transactions.TransactionManager$didPurchase$1) = 
      (r13v2 com.superwall.sdk.store.transactions.TransactionManager$didPurchase$1)
      (r13v4 com.superwall.sdk.store.transactions.TransactionManager$didPurchase$1)
     binds: [B:31:0x0154, B:17:0x0084] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:67:0x022d  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x001f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object didPurchase(com.superwall.sdk.store.abstractions.product.StoreProduct r20, com.superwall.sdk.store.transactions.TransactionManager.PurchaseSource r21, boolean r22, com.android.billingclient.api.Purchase r23, boolean r24, kotlin.coroutines.Continuation<? super kotlin.Unit> r25) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 628
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.superwall.sdk.store.transactions.TransactionManager.didPurchase(com.superwall.sdk.store.abstractions.product.StoreProduct, com.superwall.sdk.store.transactions.TransactionManager$PurchaseSource, boolean, com.android.billingclient.api.Purchase, boolean, kotlin.coroutines.Continuation):java.lang.Object");
    }

    static /* synthetic */ Object didPurchase$default(TransactionManager transactionManager, StoreProduct storeProduct, PurchaseSource purchaseSource, boolean z2, Purchase purchase, boolean z3, Continuation continuation, int i3, Object obj) {
        if ((i3 & 8) != 0) {
            purchase = null;
        }
        return transactionManager.didPurchase(storeProduct, purchaseSource, z2, purchase, z3, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x0124, code lost:
    
        if (r5.invoke(r2, r7, r3) != r4) goto L52;
     */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0098  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00bb  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00f4  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0019  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object didRestore(com.superwall.sdk.store.abstractions.product.StoreProduct r27, com.superwall.sdk.store.transactions.TransactionManager.PurchaseSource r28, kotlin.coroutines.Continuation<? super kotlin.Unit> r29) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 314
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.superwall.sdk.store.transactions.TransactionManager.didRestore(com.superwall.sdk.store.abstractions.product.StoreProduct, com.superwall.sdk.store.transactions.TransactionManager$PurchaseSource, kotlin.coroutines.Continuation):java.lang.Object");
    }

    static /* synthetic */ Object didRestore$default(TransactionManager transactionManager, StoreProduct storeProduct, PurchaseSource purchaseSource, Continuation continuation, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            storeProduct = null;
        }
        return transactionManager.didRestore(storeProduct, purchaseSource, continuation);
    }

    private final boolean getShouldObserveTransactionFinishingAutomatically() {
        return this.factory.makeSuperwallOptions().getShouldObservePurchases();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x01c1, code lost:
    
        if (r0.presentAlert(r1, r5, r2, r9) == r10) goto L133;
     */
    /* JADX WARN: Removed duplicated region for block: B:101:0x03b3  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x03b7  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x01c5  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0244  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0247  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x02a1  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x02b0  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x02b8  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x02ed  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x032c  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x001c  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0371  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object handleCustomProductPurchase(com.superwall.sdk.store.abstractions.product.StoreProduct r31, com.superwall.sdk.store.transactions.TransactionManager.PurchaseSource r32, boolean r33, kotlin.coroutines.Continuation<? super com.superwall.sdk.delegate.PurchaseResult> r34) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 1198
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.superwall.sdk.store.transactions.TransactionManager.handleCustomProductPurchase(com.superwall.sdk.store.abstractions.product.StoreProduct, com.superwall.sdk.store.transactions.TransactionManager$PurchaseSource, boolean, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0111, code lost:
    
        if (r1.invoke(r7, r3) == r4) goto L32;
     */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0019  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object handlePendingTransaction(com.superwall.sdk.store.transactions.TransactionManager.PurchaseSource r23, kotlin.coroutines.Continuation<? super kotlin.Unit> r24) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 279
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.superwall.sdk.store.transactions.TransactionManager.handlePendingTransaction(com.superwall.sdk.store.transactions.TransactionManager$PurchaseSource, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final void log(LogLevel logLevel, String str, Map<String, ? extends Object> map, Throwable th) {
        Logger.INSTANCE.debug(logLevel, LogScope.paywallTransactions, str, map, th);
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ void log$default(TransactionManager transactionManager, LogLevel logLevel, String str, Map map, Throwable th, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            logLevel = LogLevel.debug;
        }
        if ((i3 & 4) != 0) {
            map = null;
        }
        if ((i3 & 8) != 0) {
            th = null;
        }
        transactionManager.log(logLevel, str, map, th);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object presentAlert(Error error, StoreProduct storeProduct, PaywallViewState paywallViewState, Continuation<? super Unit> continuation) {
        BuildersKt__Builders_commonKt.d(this.ioScope, null, null, new C29412(storeProduct, paywallViewState, error, null), 3, null);
        Function1<AlertControllerFactory.AlertProps, Unit> function1 = this.showAlert;
        String message = error.getMessage();
        if (message == null) {
            message = "Unknown error";
        }
        function1.invoke(new AlertControllerFactory.AlertProps("An error occurred", message, null, null, null, null, 60, null));
        return Unit.f139807a;
    }

    public static /* synthetic */ Object purchase$default(TransactionManager transactionManager, PurchaseSource purchaseSource, boolean z2, Continuation continuation, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z2 = true;
        }
        return transactionManager.purchase(purchaseSource, z2, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x00d8, code lost:
    
        if (r4.invoke(r5, r15) != r2) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0146, code lost:
    
        if (r1 == r2) goto L38;
     */
    /* JADX WARN: Removed duplicated region for block: B:8:0x001c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object trackCancelled(com.superwall.sdk.store.abstractions.product.StoreProduct r25, com.superwall.sdk.store.transactions.TransactionManager.PurchaseSource r26, kotlin.coroutines.Continuation<? super kotlin.Unit> r27) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 332
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.superwall.sdk.store.transactions.TransactionManager.trackCancelled(com.superwall.sdk.store.abstractions.product.StoreProduct, com.superwall.sdk.store.transactions.TransactionManager$PurchaseSource, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final void trackFailure(String str, StoreProduct storeProduct, PurchaseSource purchaseSource) {
        if (purchaseSource instanceof PurchaseSource.Internal) {
            log$default(this, null, "Transaction Error: " + str, MapsKt.mapOf(TuplesKt.a(DiagnosticsTracker.PRODUCT_ID_KEY, storeProduct.getFullIdentifier()), TuplesKt.a("paywall_state", ((PurchaseSource.Internal) purchaseSource).getState())), null, 9, null);
            ScopesKt.launchWithTracking(this.ioScope, new C29461(purchaseSource, str, storeProduct, this, null));
            return;
        }
        if (!(purchaseSource instanceof PurchaseSource.ExternalPurchase) && !(purchaseSource instanceof PurchaseSource.ObserverMode)) {
            throw new NoWhenBranchMatchedException();
        }
        log$default(this, null, "Transaction Error: " + str, MapsKt.mapOf(TuplesKt.a(DiagnosticsTracker.PRODUCT_ID_KEY, storeProduct.getFullIdentifier())), new Error(str), 1, null);
        BuildersKt__Builders_commonKt.d(this.ioScope, null, null, new C29472(str, storeProduct, purchaseSource, this, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x0198, code lost:
    
        if (r3.invoke(r1, r15) == r2) goto L91;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x01e5, code lost:
    
        if (r3.invoke(r1, r15) == r2) goto L91;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x0200, code lost:
    
        if (r3.invoke(r1, r15) == r2) goto L91;
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x02ab, code lost:
    
        if (r3.invoke(r1, r15) == r2) goto L91;
     */
    /* JADX WARN: Code restructure failed: missing block: B:85:0x02cc, code lost:
    
        if (r3.invoke(r1, r15) == r2) goto L91;
     */
    /* JADX WARN: Code restructure failed: missing block: B:90:0x02eb, code lost:
    
        if (r3.invoke(r1, r15) == r2) goto L91;
     */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0177  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0180  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x019f  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x01d1  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x01ec  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0289  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0292  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x02b1  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x001e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object trackTransactionDidSucceed(com.superwall.sdk.store.abstractions.transactions.StoreTransaction r26, com.superwall.sdk.store.abstractions.product.StoreProduct r27, com.superwall.sdk.store.transactions.TransactionManager.PurchaseSource r28, boolean r29, kotlin.coroutines.Continuation<? super kotlin.Unit> r30) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 782
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.superwall.sdk.store.transactions.TransactionManager.trackTransactionDidSucceed(com.superwall.sdk.store.abstractions.transactions.StoreTransaction, com.superwall.sdk.store.abstractions.product.StoreProduct, com.superwall.sdk.store.transactions.TransactionManager$PurchaseSource, boolean, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:103:0x0361  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0105  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x012a  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0181  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0220  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0256  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x027f  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x001b  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x02c4  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x02f4  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x031d  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:101:0x0354 -> B:102:0x0359). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:31:0x0105 -> B:32:0x0124). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:39:0x0162 -> B:40:0x016a). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:41:0x0172 -> B:42:0x0179). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:71:0x0256 -> B:72:0x0279). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:79:0x02a9 -> B:80:0x02ae). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:81:0x02b7 -> B:82:0x02bc). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:91:0x02f4 -> B:92:0x0317). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:99:0x0346 -> B:100:0x034b). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object handle$superwall_release(com.superwall.sdk.delegate.InternalPurchaseResult r24, com.superwall.sdk.store.PurchasingObserverState r25, kotlin.coroutines.Continuation<? super kotlin.Unit> r26) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 880
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.superwall.sdk.store.transactions.TransactionManager.handle$superwall_release(com.superwall.sdk.delegate.InternalPurchaseResult, com.superwall.sdk.store.PurchasingObserverState, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final Object prepareToPurchase$superwall_release(StoreProduct storeProduct, PurchaseSource purchaseSource, Continuation<? super Unit> continuation) {
        boolean z2 = purchaseSource instanceof PurchaseSource.ObserverMode;
        this.storeManager.getBilling().getPurchaseResults().setValue(null);
        if (purchaseSource instanceof PurchaseSource.Internal) {
            BuildersKt__Builders_commonKt.d(this.ioScope, null, null, new TransactionManager$prepareToPurchase$2(this, purchaseSource, null), 3, null);
            Object objInvoke = this.track.invoke(new InternalSuperwallEvent.Transaction(new InternalSuperwallEvent.Transaction.State.Start(storeProduct), ((PurchaseSource.Internal) purchaseSource).getPaywallInfo(), storeProduct, null, InternalSuperwallEvent.Transaction.TransactionSource.INTERNAL, z2, this.factory.demandScore(), this.factory.demandTier(), null, null, null, 1792, null), continuation);
            return objInvoke == IntrinsicsKt.f() ? objInvoke : Unit.f139807a;
        }
        if (!(purchaseSource instanceof PurchaseSource.ExternalPurchase) && !z2) {
            throw new NoWhenBranchMatchedException();
        }
        if (z2 && storeProduct.getRawStoreProduct() != null) {
            ConcurrentHashMap<String, ProductDetails> concurrentHashMap = this.transactionsInProgress;
            String fullIdentifier = storeProduct.getFullIdentifier();
            RawStoreProduct rawStoreProduct = storeProduct.getRawStoreProduct();
            Intrinsics.checkNotNull(rawStoreProduct);
            concurrentHashMap.put(fullIdentifier, rawStoreProduct.getUnderlyingProductDetails());
        }
        if (!this.storeManager.hasCached(storeProduct.getFullIdentifier())) {
            this.storeManager.cacheProduct(storeProduct.getFullIdentifier(), storeProduct);
        }
        if (this.factory.makeHasExternalPurchaseController() && !this.factory.makeHasInternalPurchaseController()) {
            return Unit.f139807a;
        }
        if (!this.factory.makeSuperwallOptions().getShouldObservePurchases() && this.factory.makeHasExternalPurchaseController()) {
            return Unit.f139807a;
        }
        BuildersKt__Builders_commonKt.d(this.ioScope, null, null, new TransactionManager$prepareToPurchase$3(this, null), 3, null);
        Object objInvoke2 = this.track.invoke(new InternalSuperwallEvent.Transaction(new InternalSuperwallEvent.Transaction.State.Start(storeProduct), PaywallInfo.Companion.empty(), storeProduct, null, InternalSuperwallEvent.Transaction.TransactionSource.EXTERNAL, z2, this.factory.demandScore(), this.factory.demandTier(), null, null, null, 1792, null), continuation);
        return objInvoke2 == IntrinsicsKt.f() ? objInvoke2 : Unit.f139807a;
    }

    /* JADX WARN: Removed duplicated region for block: B:123:0x0357  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x037a  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x037c  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x0381  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x03a8  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x0417  */
    /* JADX WARN: Removed duplicated region for block: B:162:0x0425  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00d3 A[PHI: r1 r2 r3 r4 r5
      0x00d3: PHI (r1v34 java.lang.Object) = (r1v33 java.lang.Object), (r1v1 java.lang.Object) binds: [B:50:0x017d, B:23:0x00c2] A[DONT_GENERATE, DONT_INLINE]
      0x00d3: PHI (r2v19 boolean) = (r2v17 boolean), (r2v33 boolean) binds: [B:50:0x017d, B:23:0x00c2] A[DONT_GENERATE, DONT_INLINE]
      0x00d3: PHI (r3v11 com.superwall.sdk.store.abstractions.product.StoreProduct) = 
      (r3v8 com.superwall.sdk.store.abstractions.product.StoreProduct)
      (r3v16 com.superwall.sdk.store.abstractions.product.StoreProduct)
     binds: [B:50:0x017d, B:23:0x00c2] A[DONT_GENERATE, DONT_INLINE]
      0x00d3: PHI (r4v8 com.superwall.sdk.store.transactions.TransactionManager$PurchaseSource) = 
      (r4v5 com.superwall.sdk.store.transactions.TransactionManager$PurchaseSource)
      (r4v20 com.superwall.sdk.store.transactions.TransactionManager$PurchaseSource)
     binds: [B:50:0x017d, B:23:0x00c2] A[DONT_GENERATE, DONT_INLINE]
      0x00d3: PHI (r5v7 com.superwall.sdk.store.transactions.TransactionManager) = 
      (r5v4 com.superwall.sdk.store.transactions.TransactionManager)
      (r5v12 com.superwall.sdk.store.transactions.TransactionManager)
     binds: [B:50:0x017d, B:23:0x00c2] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0187  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x01f2  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x001c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object purchase(com.superwall.sdk.store.transactions.TransactionManager.PurchaseSource r17, boolean r18, kotlin.coroutines.Continuation<? super com.superwall.sdk.delegate.PurchaseResult> r19) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 1180
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.superwall.sdk.store.transactions.TransactionManager.purchase(com.superwall.sdk.store.transactions.TransactionManager$PurchaseSource, boolean, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:109:0x0241  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x02db  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x02e0  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x02e4  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00d3  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x012c A[PHI: r1 r2 r3
      0x012c: PHI (r1v18 java.lang.Object) = (r1v17 java.lang.Object), (r1v1 java.lang.Object) binds: [B:50:0x0128, B:18:0x0082] A[DONT_GENERATE, DONT_INLINE]
      0x012c: PHI (r2v16 com.superwall.sdk.paywall.view.PaywallView) = (r2v13 com.superwall.sdk.paywall.view.PaywallView), (r2v19 com.superwall.sdk.paywall.view.PaywallView) binds: [B:50:0x0128, B:18:0x0082] A[DONT_GENERATE, DONT_INLINE]
      0x012c: PHI (r3v10 com.superwall.sdk.store.transactions.TransactionManager) = 
      (r3v7 com.superwall.sdk.store.transactions.TransactionManager)
      (r3v13 com.superwall.sdk.store.transactions.TransactionManager)
     binds: [B:50:0x0128, B:18:0x0082] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0172  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x01c0  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x01c8  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x01cb  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x01ce  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x01d4  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x001a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object tryToRestorePurchases(com.superwall.sdk.paywall.view.PaywallView r20, kotlin.coroutines.Continuation<? super com.superwall.sdk.delegate.RestorationResult> r21) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 828
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.superwall.sdk.store.transactions.TransactionManager.tryToRestorePurchases(com.superwall.sdk.paywall.view.PaywallView, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final void updatePaymentQueue(List<String> removedTransactions) {
        Collection collectionEmptyList;
        Intrinsics.checkNotNullParameter(removedTransactions, "removedTransactions");
        Set set = (Set) this.storage.read(PurchasingProductdIds.INSTANCE);
        if (set != null) {
            collectionEmptyList = new ArrayList();
            for (Object obj : set) {
                String str = (String) obj;
                List<String> list = removedTransactions;
                boolean z2 = false;
                if (!(list instanceof Collection) || !list.isEmpty()) {
                    Iterator<T> it = list.iterator();
                    while (true) {
                        if (it.hasNext()) {
                            if (Intrinsics.areEqual((String) it.next(), str)) {
                                z2 = true;
                                break;
                            }
                        } else {
                            break;
                        }
                    }
                }
                if (!z2) {
                    collectionEmptyList.add(obj);
                }
            }
        } else {
            collectionEmptyList = CollectionsKt.emptyList();
        }
        this.storage.write(PurchasingProductdIds.INSTANCE, CollectionsKt.toSet(collectionEmptyList));
    }

    public /* synthetic */ TransactionManager(StoreManager storeManager, PurchaseController purchaseController, EventsQueue eventsQueue, Storage storage, ActivityProvider activityProvider, Factory factory, IOScope iOScope, Function2 function2, Function3 function3, Function1 function1, Function0 function0, Function1 function12, Function0 function02, Function0 function03, Function0 function04, Function1 function13, Function1 function14, Function0 function05, Function2 function22, Function5 function5, Function2 function23, TestMode testMode, TestModeTransactionHandler testModeTransactionHandler, Function1 function15, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(storeManager, purchaseController, eventsQueue, storage, activityProvider, factory, iOScope, (i3 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0 ? new AnonymousClass1(null) : function2, function3, function1, (i3 & 1024) != 0 ? new Function0() { // from class: com.superwall.sdk.store.transactions.b
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return TransactionManager._init_$lambda$0();
            }
        } : function0, function12, function02, (i3 & Utility.DEFAULT_STREAM_BUFFER_SIZE) != 0 ? new Function0() { // from class: com.superwall.sdk.store.transactions.c
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return TransactionManager._init_$lambda$1();
            }
        } : function03, (i3 & 16384) != 0 ? new Function0() { // from class: com.superwall.sdk.store.transactions.d
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return TransactionManager._init_$lambda$2();
            }
        } : function04, function13, (65536 & i3) != 0 ? new AnonymousClass5(null) : function14, function05, function22, function5, (1048576 & i3) != 0 ? new AnonymousClass6(null) : function23, (2097152 & i3) != 0 ? null : testMode, (4194304 & i3) != 0 ? null : testModeTransactionHandler, (i3 & 8388608) != 0 ? null : function15);
    }
}
