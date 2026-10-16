package com.superwall.sdk.billing;

import android.content.Context;
import com.android.billingclient.api.BillingClient;
import com.android.billingclient.api.BillingClientStateListener;
import com.android.billingclient.api.BillingConfig;
import com.android.billingclient.api.BillingConfigResponseListener;
import com.android.billingclient.api.BillingResult;
import com.android.billingclient.api.GetBillingConfigParams;
import com.android.billingclient.api.PendingPurchasesParams;
import com.android.billingclient.api.Purchase;
import com.android.billingclient.api.PurchasesResponseListener;
import com.android.billingclient.api.PurchasesUpdatedListener;
import com.android.billingclient.api.QueryPurchasesParams;
import com.revenuecat.purchases.google.ErrorsKt;
import com.superwall.sdk.billing.BillingError;
import com.superwall.sdk.delegate.InternalPurchaseResult;
import com.superwall.sdk.dependencies.HasExternalPurchaseControllerFactory;
import com.superwall.sdk.dependencies.HasInternalPurchaseControllerFactory;
import com.superwall.sdk.dependencies.OptionsFactory;
import com.superwall.sdk.logger.LogLevel;
import com.superwall.sdk.logger.LogScope;
import com.superwall.sdk.logger.Logger;
import com.superwall.sdk.misc.AppLifecycleObserver;
import com.superwall.sdk.misc.Either;
import com.superwall.sdk.misc.IOScope;
import com.superwall.sdk.store.abstractions.product.StoreProduct;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.SafeContinuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

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
public final class GoogleBillingWrapper implements PurchasesUpdatedListener, BillingClientStateListener, Billing {
    private static final int QUERY_PURCHASES_MAX_RETRIES = 3;
    private static final long QUERY_PURCHASES_TIMEOUT_MS = 10000;
    private final String IN_APP_BILLING_LESS_THAN_3_ERROR_MESSAGE;
    private final AppLifecycleObserver appLifecycleObserver;
    private volatile BillingClient billingClient;
    private final Context context;
    private final Function1<PurchasesUpdatedListener, BillingClient> createBillingClient;
    private final Factory factory;
    private final IOScope ioScope;
    private final MutableStateFlow<InternalPurchaseResult> purchaseResults;
    private long reconnectMilliseconds;
    private boolean reconnectionAlreadyScheduled;
    private final ConcurrentLinkedQueue<Pair<Function1<BillingError, Unit>, Long>> serviceRequests;
    private final Handler threadHandler;
    public static final Companion Companion = new Companion(null);
    private static final ConcurrentHashMap<String, Either<StoreProduct, Throwable>> productsCache = new ConcurrentHashMap<>();

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void clearProductsCache$superwall_release() {
            GoogleBillingWrapper.productsCache.clear();
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public interface Factory extends HasExternalPurchaseControllerFactory, HasInternalPurchaseControllerFactory, OptionsFactory {
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Handler {
        private final CoroutineScope scope;

        public Handler(CoroutineScope scope) {
            Intrinsics.checkNotNullParameter(scope, "scope");
            this.scope = scope;
        }

        public final CoroutineScope getScope() {
            return this.scope;
        }

        public final void post(Function0<Unit> action) {
            Intrinsics.checkNotNullParameter(action, "action");
            BuildersKt__Builders_commonKt.d(this.scope, null, null, new GoogleBillingWrapper$Handler$post$1(action, null), 3, null);
        }

        public final void postDelayed(Function0<Unit> action, long j3) {
            Intrinsics.checkNotNullParameter(action, "action");
            BuildersKt__Builders_commonKt.d(this.scope, null, null, new GoogleBillingWrapper$Handler$postDelayed$1(j3, action, null), 3, null);
        }
    }

    /* JADX INFO: renamed from: com.superwall.sdk.billing.GoogleBillingWrapper$getLatestTransaction$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "com.superwall.sdk.billing.GoogleBillingWrapper", f = "GoogleBillingWrapper.kt", l = {663, 668}, m = "getLatestTransaction")
    static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return GoogleBillingWrapper.this.getLatestTransaction(null, this);
        }
    }

    /* JADX INFO: renamed from: com.superwall.sdk.billing.GoogleBillingWrapper$getStorefrontCountryCode$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "com.superwall.sdk.billing.GoogleBillingWrapper", f = "GoogleBillingWrapper.kt", l = {496}, m = "getStorefrontCountryCode")
    static final class C27801 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C27801(Continuation<? super C27801> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return GoogleBillingWrapper.this.getStorefrontCountryCode(this);
        }
    }

    /* JADX INFO: renamed from: com.superwall.sdk.billing.GoogleBillingWrapper$onPurchasesUpdated$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "com.superwall.sdk.billing.GoogleBillingWrapper$onPurchasesUpdated$1", f = "GoogleBillingWrapper.kt", l = {625}, m = "invokeSuspend")
    static final class C27811 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Purchase $purchase;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C27811(Purchase purchase, Continuation<? super C27811> continuation) {
            super(2, continuation);
            this.$purchase = purchase;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return GoogleBillingWrapper.this.new C27811(this.$purchase, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objF = IntrinsicsKt.f();
            int i3 = this.label;
            if (i3 == 0) {
                ResultKt.b(obj);
                MutableStateFlow<InternalPurchaseResult> purchaseResults = GoogleBillingWrapper.this.getPurchaseResults();
                InternalPurchaseResult.Purchased purchased = new InternalPurchaseResult.Purchased(this.$purchase);
                this.label = 1;
                if (purchaseResults.emit(purchased, this) == objF) {
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
            return ((C27811) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX INFO: renamed from: com.superwall.sdk.billing.GoogleBillingWrapper$onPurchasesUpdated$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "com.superwall.sdk.billing.GoogleBillingWrapper$onPurchasesUpdated$2", f = "GoogleBillingWrapper.kt", l = {632}, m = "invokeSuspend")
    static final class C27822 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C27822(Continuation<? super C27822> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return GoogleBillingWrapper.this.new C27822(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objF = IntrinsicsKt.f();
            int i3 = this.label;
            if (i3 == 0) {
                ResultKt.b(obj);
                MutableStateFlow<InternalPurchaseResult> purchaseResults = GoogleBillingWrapper.this.getPurchaseResults();
                InternalPurchaseResult.Cancelled cancelled = InternalPurchaseResult.Cancelled.INSTANCE;
                this.label = 1;
                if (purchaseResults.emit(cancelled, this) == objF) {
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
            return ((C27822) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX INFO: renamed from: com.superwall.sdk.billing.GoogleBillingWrapper$onPurchasesUpdated$3, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "com.superwall.sdk.billing.GoogleBillingWrapper$onPurchasesUpdated$3", f = "GoogleBillingWrapper.kt", l = {642}, m = "invokeSuspend")
    static final class AnonymousClass3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ BillingResult $result;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass3(BillingResult billingResult, Continuation<? super AnonymousClass3> continuation) {
            super(2, continuation);
            this.$result = billingResult;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return GoogleBillingWrapper.this.new AnonymousClass3(this.$result, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objF = IntrinsicsKt.f();
            int i3 = this.label;
            if (i3 == 0) {
                ResultKt.b(obj);
                MutableStateFlow<InternalPurchaseResult> purchaseResults = GoogleBillingWrapper.this.getPurchaseResults();
                InternalPurchaseResult.Failed failed = new InternalPurchaseResult.Failed(new Exception(String.valueOf(this.$result.c())));
                this.label = 1;
                if (purchaseResults.emit(failed, this) == objF) {
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

    /* JADX INFO: renamed from: com.superwall.sdk.billing.GoogleBillingWrapper$queryAllPurchases$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "com.superwall.sdk.billing.GoogleBillingWrapper$queryAllPurchases$2", f = "GoogleBillingWrapper.kt", l = {157, 157}, m = "invokeSuspend")
    static final class C27832 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<? extends Purchase>>, Object> {
        private /* synthetic */ Object L$0;
        int label;

        C27832(Continuation<? super C27832> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C27832 c27832 = GoogleBillingWrapper.this.new C27832(continuation);
            c27832.L$0 = obj;
            return c27832;
        }

        /* JADX WARN: Removed duplicated region for block: B:23:0x0073  */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r11) throws java.lang.Throwable {
            /*
                r10 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
                int r1 = r10.label
                r2 = 2
                r3 = 1
                if (r1 == 0) goto L26
                if (r1 == r3) goto L1e
                if (r1 != r2) goto L16
                java.lang.Object r0 = r10.L$0
                java.util.Collection r0 = (java.util.Collection) r0
                kotlin.ResultKt.b(r11)
                goto L6c
            L16:
                java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r11.<init>(r0)
                throw r11
            L1e:
                java.lang.Object r1 = r10.L$0
                kotlinx.coroutines.Deferred r1 = (kotlinx.coroutines.Deferred) r1
                kotlin.ResultKt.b(r11)
                goto L55
            L26:
                kotlin.ResultKt.b(r11)
                java.lang.Object r11 = r10.L$0
                r4 = r11
                kotlinx.coroutines.CoroutineScope r4 = (kotlinx.coroutines.CoroutineScope) r4
                com.superwall.sdk.billing.GoogleBillingWrapper$queryAllPurchases$2$apps$1 r7 = new com.superwall.sdk.billing.GoogleBillingWrapper$queryAllPurchases$2$apps$1
                com.superwall.sdk.billing.GoogleBillingWrapper r11 = com.superwall.sdk.billing.GoogleBillingWrapper.this
                r1 = 0
                r7.<init>(r11, r1)
                r8 = 3
                r9 = 0
                r5 = 0
                r6 = 0
                kotlinx.coroutines.Deferred r11 = kotlinx.coroutines.BuildersKt.b(r4, r5, r6, r7, r8, r9)
                com.superwall.sdk.billing.GoogleBillingWrapper$queryAllPurchases$2$subs$1 r7 = new com.superwall.sdk.billing.GoogleBillingWrapper$queryAllPurchases$2$subs$1
                com.superwall.sdk.billing.GoogleBillingWrapper r5 = com.superwall.sdk.billing.GoogleBillingWrapper.this
                r7.<init>(r5, r1)
                r5 = 0
                kotlinx.coroutines.Deferred r1 = kotlinx.coroutines.BuildersKt.b(r4, r5, r6, r7, r8, r9)
                r10.L$0 = r1
                r10.label = r3
                java.lang.Object r11 = r11.await(r10)
                if (r11 != r0) goto L55
                goto L69
            L55:
                java.util.List r11 = (java.util.List) r11
                if (r11 != 0) goto L5d
                java.util.List r11 = kotlin.collections.CollectionsKt.emptyList()
            L5d:
                java.util.Collection r11 = (java.util.Collection) r11
                r10.L$0 = r11
                r10.label = r2
                java.lang.Object r1 = r1.await(r10)
                if (r1 != r0) goto L6a
            L69:
                return r0
            L6a:
                r0 = r11
                r11 = r1
            L6c:
                java.util.List r11 = (java.util.List) r11
                if (r11 == 0) goto L73
            L70:
                java.lang.Iterable r11 = (java.lang.Iterable) r11
                goto L78
            L73:
                java.util.List r11 = kotlin.collections.CollectionsKt.emptyList()
                goto L70
            L78:
                java.util.List r11 = kotlin.collections.CollectionsKt.plus(r0, r11)
                return r11
            */
            throw new UnsupportedOperationException("Method not decompiled: com.superwall.sdk.billing.GoogleBillingWrapper.C27832.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super List<? extends Purchase>> continuation) {
            return ((C27832) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public GoogleBillingWrapper(Context context, IOScope ioScope, AppLifecycleObserver appLifecycleObserver, Factory factory, Function1<? super PurchasesUpdatedListener, ? extends BillingClient> createBillingClient) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(ioScope, "ioScope");
        Intrinsics.checkNotNullParameter(appLifecycleObserver, "appLifecycleObserver");
        Intrinsics.checkNotNullParameter(factory, "factory");
        Intrinsics.checkNotNullParameter(createBillingClient, "createBillingClient");
        this.context = context;
        this.ioScope = ioScope;
        this.appLifecycleObserver = appLifecycleObserver;
        this.factory = factory;
        this.createBillingClient = createBillingClient;
        this.threadHandler = new Handler(ioScope);
        this.serviceRequests = new ConcurrentLinkedQueue<>();
        this.reconnectMilliseconds = 1000L;
        this.purchaseResults = StateFlowKt.a(null);
        this.IN_APP_BILLING_LESS_THAN_3_ERROR_MESSAGE = ErrorsKt.IN_APP_BILLING_LESS_THAN_3_ERROR_MESSAGE;
        startConnectionOnMainThread$default(this, 0L, 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final BillingClient _init_$lambda$0(Context context, PurchasesUpdatedListener it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return BillingClient.h(context).c(it).b(PendingPurchasesParams.c().b().a()).a();
    }

    private final void dispatch(Function0<Unit> function0) {
        this.threadHandler.post(function0);
    }

    private final void executePendingRequests() {
        Pair<Function1<BillingError, Unit>, Long> pairPoll;
        synchronized (this) {
            while (true) {
                try {
                    BillingClient billingClient = this.billingClient;
                    if (billingClient == null || !billingClient.f() || (pairPoll = this.serviceRequests.poll()) == null) {
                        break;
                    }
                    final Function1 function1 = (Function1) pairPoll.a();
                    Long l3 = (Long) pairPoll.b();
                    if (l3 != null) {
                        this.threadHandler.postDelayed(new Function0() { // from class: com.superwall.sdk.billing.l
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return GoogleBillingWrapper.executePendingRequests$lambda$4$lambda$3$lambda$1(function1);
                            }
                        }, l3.longValue());
                    } else {
                        this.threadHandler.post(new Function0() { // from class: com.superwall.sdk.billing.m
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return GoogleBillingWrapper.executePendingRequests$lambda$4$lambda$3$lambda$2(function1);
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
    public static final Unit executePendingRequests$lambda$4$lambda$3$lambda$1(Function1 function1) {
        function1.invoke(null);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit executePendingRequests$lambda$4$lambda$3$lambda$2(Function1 function1) {
        function1.invoke(null);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final synchronized void executeRequestOnUIThread(Long l3, Function1<? super BillingError, Unit> function1) {
        try {
            this.serviceRequests.add(TuplesKt.a(function1, l3));
            BillingClient billingClient = this.billingClient;
            if (billingClient == null || billingClient.f()) {
                executePendingRequests();
            } else {
                startConnectionOnMainThread$default(this, 0L, 1, null);
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    static /* synthetic */ void executeRequestOnUIThread$default(GoogleBillingWrapper googleBillingWrapper, Long l3, Function1 function1, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            l3 = null;
        }
        googleBillingWrapper.executeRequestOnUIThread(l3, function1);
    }

    private final void getProducts(Set<String> set, final GetStoreProductsCallback getStoreProductsCallback) {
        Set<String> of = SetsKt.setOf((Object[]) new String[]{"subs", "inapp"});
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        Iterator<T> it = set.iterator();
        while (it.hasNext()) {
            DecomposedProductIds decomposedProductIdsFrom = DecomposedProductIds.Companion.from((String) it.next());
            String subscriptionId = decomposedProductIdsFrom.getSubscriptionId();
            linkedHashSet.add(subscriptionId);
            List<DecomposedProductIds> arrayList = linkedHashMap.get(subscriptionId);
            if (arrayList == null) {
                arrayList = new ArrayList<>();
                linkedHashMap.put(subscriptionId, arrayList);
            }
            arrayList.add(decomposedProductIdsFrom);
        }
        getProductsOfTypes(linkedHashSet, of, SetsKt.emptySet(), linkedHashMap, new GetStoreProductsCallback() { // from class: com.superwall.sdk.billing.GoogleBillingWrapper.getProducts.2
            @Override // com.superwall.sdk.billing.GetStoreProductsCallback
            public void onError(BillingError error) {
                Intrinsics.checkNotNullParameter(error, "error");
                getStoreProductsCallback.onError(error);
            }

            @Override // com.superwall.sdk.billing.GetStoreProductsCallback
            public void onReceived(Set<StoreProduct> storeProducts) {
                Intrinsics.checkNotNullParameter(storeProducts, "storeProducts");
                getStoreProductsCallback.onReceived(storeProducts);
            }
        });
    }

    private final void getProductsOfTypes(Set<String> set, Set<String> set2, Set<StoreProduct> set3, Map<String, List<DecomposedProductIds>> map, final GetStoreProductsCallback getStoreProductsCallback) {
        if (set2.isEmpty()) {
            getStoreProductsCallback.onReceived(set3);
            return;
        }
        final Set<StoreProduct> set4 = set3;
        final ConcurrentLinkedQueue concurrentLinkedQueue = new ConcurrentLinkedQueue();
        final AtomicInteger atomicInteger = new AtomicInteger(set2.size());
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        Iterator<T> it = set2.iterator();
        while (it.hasNext()) {
            queryProductDetailsAsync((String) it.next(), set, map, new Function1() { // from class: com.superwall.sdk.billing.g
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return GoogleBillingWrapper.getProductsOfTypes$lambda$19$lambda$16(this.f93464a, concurrentLinkedQueue, atomicInteger, getStoreProductsCallback, set4, (List) obj);
                }
            }, new Function1() { // from class: com.superwall.sdk.billing.h
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return GoogleBillingWrapper.getProductsOfTypes$lambda$19$lambda$18(this.f93469a, atomicBoolean, getStoreProductsCallback, (BillingError) obj);
                }
            });
            set4 = set3;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit getProductsOfTypes$lambda$19$lambda$16(GoogleBillingWrapper googleBillingWrapper, final ConcurrentLinkedQueue concurrentLinkedQueue, final AtomicInteger atomicInteger, final GetStoreProductsCallback getStoreProductsCallback, final Set set, final List storeProducts) {
        Intrinsics.checkNotNullParameter(storeProducts, "storeProducts");
        googleBillingWrapper.dispatch(new Function0() { // from class: com.superwall.sdk.billing.o
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return GoogleBillingWrapper.getProductsOfTypes$lambda$19$lambda$16$lambda$15(concurrentLinkedQueue, storeProducts, atomicInteger, getStoreProductsCallback, set);
            }
        });
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit getProductsOfTypes$lambda$19$lambda$16$lambda$15(ConcurrentLinkedQueue concurrentLinkedQueue, List list, AtomicInteger atomicInteger, GetStoreProductsCallback getStoreProductsCallback, Set set) {
        concurrentLinkedQueue.addAll(list);
        if (atomicInteger.decrementAndGet() == 0) {
            getStoreProductsCallback.onReceived(SetsKt.plus(set, (Iterable) concurrentLinkedQueue));
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit getProductsOfTypes$lambda$19$lambda$18(GoogleBillingWrapper googleBillingWrapper, final AtomicBoolean atomicBoolean, final GetStoreProductsCallback getStoreProductsCallback, final BillingError error) {
        Intrinsics.checkNotNullParameter(error, "error");
        googleBillingWrapper.dispatch(new Function0() { // from class: com.superwall.sdk.billing.e
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return GoogleBillingWrapper.getProductsOfTypes$lambda$19$lambda$18$lambda$17(atomicBoolean, getStoreProductsCallback, error);
            }
        });
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit getProductsOfTypes$lambda$19$lambda$18$lambda$17(AtomicBoolean atomicBoolean, GetStoreProductsCallback getStoreProductsCallback, BillingError billingError) {
        if (atomicBoolean.compareAndSet(false, true)) {
            getStoreProductsCallback.onError(billingError);
        }
        return Unit.f139807a;
    }

    private final boolean getShouldFinishTransactions() {
        return !this.factory.makeSuperwallOptions().getShouldObservePurchases();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit getStorefrontCountryCode$lambda$22(final CompletableDeferred completableDeferred, GoogleBillingWrapper googleBillingWrapper, BillingError billingError) {
        if (billingError != null) {
            completableDeferred.J(null);
            return Unit.f139807a;
        }
        if (googleBillingWrapper.withConnectedClient(new Function1() { // from class: com.superwall.sdk.billing.f
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return GoogleBillingWrapper.getStorefrontCountryCode$lambda$22$lambda$21(completableDeferred, (BillingClient) obj);
            }
        }) == null) {
            completableDeferred.J(null);
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit getStorefrontCountryCode$lambda$22$lambda$21(final CompletableDeferred completableDeferred, BillingClient withConnectedClient) {
        Intrinsics.checkNotNullParameter(withConnectedClient, "$this$withConnectedClient");
        withConnectedClient.d(GetBillingConfigParams.a().a(), new BillingConfigResponseListener() { // from class: com.superwall.sdk.billing.p
            @Override // com.android.billingclient.api.BillingConfigResponseListener
            public final void a(BillingResult billingResult, BillingConfig billingConfig) {
                GoogleBillingWrapper.getStorefrontCountryCode$lambda$22$lambda$21$lambda$20(completableDeferred, billingResult, billingConfig);
            }
        });
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getStorefrontCountryCode$lambda$22$lambda$21$lambda$20(CompletableDeferred completableDeferred, BillingResult billingResult, BillingConfig billingConfig) {
        Intrinsics.checkNotNullParameter(billingResult, "billingResult");
        if (billingResult.c() == 0 && billingConfig != null) {
            completableDeferred.J(billingConfig.a());
            return;
        }
        Logger.debug$default(Logger.INSTANCE, LogLevel.debug, LogScope.productsManager, "Failed to fetch billing config: " + billingResult.a() + " ErrorCode: " + billingResult.c(), (Map) null, (Throwable) null, 24, (Object) null);
        completableDeferred.J(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0104  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final kotlin.Unit onBillingSetupFinished$lambda$23(com.android.billingclient.api.BillingResult r19, com.superwall.sdk.billing.GoogleBillingWrapper r20) {
        /*
            Method dump skipped, instruction units count: 330
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.superwall.sdk.billing.GoogleBillingWrapper.onBillingSetupFinished$lambda$23(com.android.billingclient.api.BillingResult, com.superwall.sdk.billing.GoogleBillingWrapper):kotlin.Unit");
    }

    private final void queryProductDetailsAsync(String str, Set<String> set, Map<String, List<DecomposedProductIds>> map, Function1<? super List<StoreProduct>, Unit> function1, Function1<? super BillingError, Unit> function12) {
        Logger.debug$default(Logger.INSTANCE, LogLevel.debug, LogScope.productsManager, "Requesting products from the store with identifiers: " + CollectionsKt.joinToString$default(set, null, null, null, 0, null, null, 63, null), (Map) null, (Throwable) null, 24, (Object) null);
        BillingClientUseCase.run$default(new QueryProductDetailsUseCase(new QueryProductDetailsUseCaseParams(set, map, str, ((Boolean) this.appLifecycleObserver.isInBackground().getValue()).booleanValue()), function1, function12, new GoogleBillingWrapper$queryProductDetailsAsync$useCase$1(this), new GoogleBillingWrapper$queryProductDetailsAsync$useCase$2(this)), 0L, 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit queryType_gIAlu_s$lambda$33(QueryPurchasesParams queryPurchasesParams, final CompletableDeferred completableDeferred, BillingClient withConnectedClient) {
        Intrinsics.checkNotNullParameter(withConnectedClient, "$this$withConnectedClient");
        withConnectedClient.j(queryPurchasesParams, new PurchasesResponseListener() { // from class: com.superwall.sdk.billing.r
            @Override // com.android.billingclient.api.PurchasesResponseListener
            public final void a(BillingResult billingResult, List list) {
                GoogleBillingWrapper.queryType_gIAlu_s$lambda$33$lambda$32(completableDeferred, billingResult, list);
            }
        });
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void queryType_gIAlu_s$lambda$33$lambda$32(CompletableDeferred completableDeferred, BillingResult billingResult, List purchasesList) {
        Intrinsics.checkNotNullParameter(billingResult, "billingResult");
        Intrinsics.checkNotNullParameter(purchasesList, "purchasesList");
        if (billingResult.c() == 0) {
            completableDeferred.J(Result.a(Result.b(purchasesList)));
            return;
        }
        Logger.debug$default(Logger.INSTANCE, LogLevel.error, LogScope.nativePurchaseController, "Unable to query for purchases.", (Map) null, (Throwable) null, 24, (Object) null);
        Result.Companion companion = Result.f139772b;
        completableDeferred.J(Result.a(Result.b(ResultKt.a(new Throwable("Billing query failed with code " + billingResult.c())))));
    }

    private final void retryBillingServiceConnectionWithExponentialBackoff() {
        if (this.reconnectionAlreadyScheduled) {
            Logger.debug$default(Logger.INSTANCE, LogLevel.error, LogScope.productsManager, "Billing client retry already scheduled.", (Map) null, (Throwable) null, 24, (Object) null);
            return;
        }
        Logger.debug$default(Logger.INSTANCE, LogLevel.error, LogScope.productsManager, "Billing client disconnected, retrying in " + this.reconnectMilliseconds + " milliseconds", (Map) null, (Throwable) null, 24, (Object) null);
        this.reconnectionAlreadyScheduled = true;
        startConnectionOnMainThread(this.reconnectMilliseconds);
        this.reconnectMilliseconds = Math.min(this.reconnectMilliseconds * ((long) 2), GoogleBillingWrapperKt.RECONNECT_TIMER_MAX_TIME_MILLISECONDS);
    }

    private final synchronized void sendErrorsToAllPendingRequests(final BillingError billingError) {
        while (true) {
            Pair<Function1<BillingError, Unit>, Long> pairPoll = this.serviceRequests.poll();
            if (pairPoll != null) {
                final Function1 function1 = (Function1) pairPoll.a();
                this.threadHandler.post(new Function0() { // from class: com.superwall.sdk.billing.k
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return GoogleBillingWrapper.sendErrorsToAllPendingRequests$lambda$29$lambda$28(function1, billingError);
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit sendErrorsToAllPendingRequests$lambda$29$lambda$28(Function1 function1, BillingError billingError) {
        function1.invoke(billingError);
        return Unit.f139807a;
    }

    public static /* synthetic */ void startConnectionOnMainThread$default(GoogleBillingWrapper googleBillingWrapper, long j3, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            j3 = 0;
        }
        googleBillingWrapper.startConnectionOnMainThread(j3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit startConnectionOnMainThread$lambda$6(GoogleBillingWrapper googleBillingWrapper) {
        googleBillingWrapper.startConnection();
        return Unit.f139807a;
    }

    private final void trackProductDetailsNotSupportedIfNeeded() {
        BillingClient billingClient = this.billingClient;
        BillingResult billingResultE = billingClient != null ? billingClient.e("fff") : null;
        if (billingResultE == null || billingResultE.c() != -2) {
            return;
        }
        Logger.debug$default(Logger.INSTANCE, LogLevel.error, LogScope.productsManager, "Product details not supported: " + billingResultE.c() + " " + billingResultE.a(), (Map) null, (Throwable) null, 24, (Object) null);
    }

    @Override // com.superwall.sdk.billing.Billing
    public /* synthetic */ Object awaitGetProducts(Set set, Continuation continuation) throws Throwable {
        StoreProduct storeProduct;
        ArrayList arrayList = new ArrayList();
        Iterator it = set.iterator();
        while (it.hasNext()) {
            Either<StoreProduct, Throwable> either = productsCache.get((String) it.next());
            if (either == null) {
                storeProduct = null;
            } else {
                if (!(either instanceof Either.Success)) {
                    if (either instanceof Either.Failure) {
                        throw ((Either.Failure) either).getError();
                    }
                    throw new NoWhenBranchMatchedException();
                }
                storeProduct = (StoreProduct) ((Either.Success) either).getValue();
            }
            if (storeProduct != null) {
                arrayList.add(storeProduct);
            }
        }
        final Set set2 = CollectionsKt.toSet(arrayList);
        if (set2.size() == set.size()) {
            return set2;
        }
        Set set3 = set2;
        ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(set3, 10));
        Iterator it2 = set3.iterator();
        while (it2.hasNext()) {
            arrayList2.add(((StoreProduct) it2.next()).getFullIdentifier());
        }
        final Set<String> setMinus = SetsKt.minus(set, (Iterable) CollectionsKt.toSet(arrayList2));
        final SafeContinuation safeContinuation = new SafeContinuation(IntrinsicsKt.c(continuation));
        getProducts(setMinus, new GetStoreProductsCallback() { // from class: com.superwall.sdk.billing.GoogleBillingWrapper$awaitGetProducts$2$1
            @Override // com.superwall.sdk.billing.GetStoreProductsCallback
            public void onError(BillingError error) {
                Intrinsics.checkNotNullParameter(error, "error");
                if (error instanceof BillingError.BillingNotAvailable) {
                    Iterator<T> it3 = setMinus.iterator();
                    while (it3.hasNext()) {
                        GoogleBillingWrapper.productsCache.put((String) it3.next(), new Either.Failure(error));
                    }
                }
                Continuation<Set<StoreProduct>> continuation2 = safeContinuation;
                Result.Companion companion = Result.f139772b;
                continuation2.resumeWith(Result.b(ResultKt.a(error)));
            }

            @Override // com.superwall.sdk.billing.GetStoreProductsCallback
            public void onReceived(Set<StoreProduct> storeProducts) {
                Intrinsics.checkNotNullParameter(storeProducts, "storeProducts");
                Set<StoreProduct> set4 = storeProducts;
                ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(set4, 10));
                for (StoreProduct storeProduct2 : set4) {
                    GoogleBillingWrapper.productsCache.put(storeProduct2.getFullIdentifier(), new Either.Success(storeProduct2));
                    arrayList3.add(storeProduct2.getFullIdentifier());
                }
                Set<String> set5 = setMinus;
                ArrayList arrayList4 = new ArrayList();
                for (Object obj : set5) {
                    if (!arrayList3.contains((String) obj)) {
                        arrayList4.add(obj);
                    }
                }
                int size = arrayList4.size();
                int i3 = 0;
                while (i3 < size) {
                    Object obj2 = arrayList4.get(i3);
                    i3++;
                    String str = (String) obj2;
                    GoogleBillingWrapper.productsCache.put(str, new Either.Failure(new Exception("Failed to query product details for " + str)));
                }
                safeContinuation.resumeWith(Result.b(SetsKt.plus((Set) set2, (Iterable) set4)));
            }
        });
        Object objA = safeContinuation.a();
        if (objA == IntrinsicsKt.f()) {
            DebugProbesKt.c(continuation);
        }
        return objA;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // com.superwall.sdk.billing.Billing
    /* JADX INFO: renamed from: consume-gIAlu-s */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object mo1258consumegIAlus(java.lang.String r11, kotlin.coroutines.Continuation<? super kotlin.Result<java.lang.String>> r12) {
        /*
            r10 = this;
            boolean r0 = r12 instanceof com.superwall.sdk.billing.GoogleBillingWrapper$consume$1
            if (r0 == 0) goto L13
            r0 = r12
            com.superwall.sdk.billing.GoogleBillingWrapper$consume$1 r0 = (com.superwall.sdk.billing.GoogleBillingWrapper$consume$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.superwall.sdk.billing.GoogleBillingWrapper$consume$1 r0 = new com.superwall.sdk.billing.GoogleBillingWrapper$consume$1
            r0.<init>(r10, r12)
        L18:
            java.lang.Object r12 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L39
            if (r2 != r3) goto L31
            java.lang.Object r11 = r0.L$1
            java.lang.String r11 = (java.lang.String) r11
            java.lang.Object r11 = r0.L$0
            com.superwall.sdk.billing.GoogleBillingWrapper r11 = (com.superwall.sdk.billing.GoogleBillingWrapper) r11
            kotlin.ResultKt.b(r12)
            goto L8f
        L31:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r12)
            throw r11
        L39:
            kotlin.ResultKt.b(r12)
            r0.L$0 = r10
            r0.L$1 = r11
            r0.label = r3
            kotlin.coroutines.SafeContinuation r12 = new kotlin.coroutines.SafeContinuation
            kotlin.coroutines.Continuation r2 = kotlin.coroutines.intrinsics.IntrinsicsKt.c(r0)
            r12.<init>(r2)
            com.superwall.sdk.billing.ConsumePurchaseUseCase r4 = new com.superwall.sdk.billing.ConsumePurchaseUseCase
            com.superwall.sdk.billing.ConsumePurchaseUseCaseParams r5 = new com.superwall.sdk.billing.ConsumePurchaseUseCaseParams
            com.superwall.sdk.misc.AppLifecycleObserver r2 = r10.appLifecycleObserver
            kotlinx.coroutines.flow.StateFlow r2 = r2.isInBackground()
            java.lang.Object r2 = r2.getValue()
            java.lang.Boolean r2 = (java.lang.Boolean) r2
            boolean r2 = r2.booleanValue()
            r5.<init>(r11, r2)
            com.superwall.sdk.billing.GoogleBillingWrapper$consume$2$useCase$1 r6 = new com.superwall.sdk.billing.GoogleBillingWrapper$consume$2$useCase$1
            r6.<init>()
            com.superwall.sdk.billing.GoogleBillingWrapper$consume$2$useCase$2 r7 = new com.superwall.sdk.billing.GoogleBillingWrapper$consume$2$useCase$2
            r7.<init>()
            com.superwall.sdk.billing.GoogleBillingWrapper$consume$2$useCase$3 r8 = new com.superwall.sdk.billing.GoogleBillingWrapper$consume$2$useCase$3
            r8.<init>(r10)
            com.superwall.sdk.billing.GoogleBillingWrapper$consume$2$useCase$4 r9 = new com.superwall.sdk.billing.GoogleBillingWrapper$consume$2$useCase$4
            r9.<init>(r10)
            r4.<init>(r5, r6, r7, r8, r9)
            r5 = 0
            r11 = 0
            com.superwall.sdk.billing.BillingClientUseCase.run$default(r4, r5, r3, r11)
            java.lang.Object r12 = r12.a()
            java.lang.Object r11 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            if (r12 != r11) goto L8c
            kotlin.coroutines.jvm.internal.DebugProbesKt.c(r0)
        L8c:
            if (r12 != r1) goto L8f
            return r1
        L8f:
            kotlin.Result r12 = (kotlin.Result) r12
            java.lang.Object r11 = r12.j()
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.superwall.sdk.billing.GoogleBillingWrapper.mo1258consumegIAlus(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final AppLifecycleObserver getAppLifecycleObserver() {
        return this.appLifecycleObserver;
    }

    public final synchronized BillingClient getBillingClient() {
        return this.billingClient;
    }

    public final Context getContext() {
        return this.context;
    }

    public final Function1<PurchasesUpdatedListener, BillingClient> getCreateBillingClient() {
        return this.createBillingClient;
    }

    public final Factory getFactory() {
        return this.factory;
    }

    public final String getIN_APP_BILLING_LESS_THAN_3_ERROR_MESSAGE$superwall_release() {
        return this.IN_APP_BILLING_LESS_THAN_3_ERROR_MESSAGE;
    }

    public final IOScope getIoScope() {
        return this.ioScope;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // com.superwall.sdk.billing.Billing
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object getLatestTransaction(com.superwall.sdk.dependencies.StoreTransactionFactory r7, kotlin.coroutines.Continuation<? super com.superwall.sdk.store.abstractions.transactions.StoreTransaction> r8) throws java.lang.Throwable {
        /*
            r6 = this;
            boolean r0 = r8 instanceof com.superwall.sdk.billing.GoogleBillingWrapper.AnonymousClass1
            if (r0 == 0) goto L13
            r0 = r8
            com.superwall.sdk.billing.GoogleBillingWrapper$getLatestTransaction$1 r0 = (com.superwall.sdk.billing.GoogleBillingWrapper.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.superwall.sdk.billing.GoogleBillingWrapper$getLatestTransaction$1 r0 = new com.superwall.sdk.billing.GoogleBillingWrapper$getLatestTransaction$1
            r0.<init>(r8)
        L18:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L40
            if (r2 == r4) goto L34
            if (r2 != r3) goto L2c
            kotlin.ResultKt.b(r8)
            return r8
        L2c:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L34:
            java.lang.Object r7 = r0.L$1
            com.superwall.sdk.dependencies.StoreTransactionFactory r7 = (com.superwall.sdk.dependencies.StoreTransactionFactory) r7
            java.lang.Object r2 = r0.L$0
            com.superwall.sdk.billing.GoogleBillingWrapper r2 = (com.superwall.sdk.billing.GoogleBillingWrapper) r2
            kotlin.ResultKt.b(r8)
            goto L5e
        L40:
            kotlin.ResultKt.b(r8)
            kotlinx.coroutines.flow.MutableStateFlow r8 = r6.getPurchaseResults()
            kotlinx.coroutines.flow.StateFlow r8 = kotlinx.coroutines.flow.FlowKt.c(r8)
            com.superwall.sdk.billing.GoogleBillingWrapper$getLatestTransaction$$inlined$filter$1 r2 = new com.superwall.sdk.billing.GoogleBillingWrapper$getLatestTransaction$$inlined$filter$1
            r2.<init>()
            r0.L$0 = r6
            r0.L$1 = r7
            r0.label = r4
            java.lang.Object r8 = kotlinx.coroutines.flow.FlowKt.D(r2, r0)
            if (r8 != r1) goto L5d
            goto L7d
        L5d:
            r2 = r6
        L5e:
            com.superwall.sdk.delegate.InternalPurchaseResult r8 = (com.superwall.sdk.delegate.InternalPurchaseResult) r8
            boolean r4 = r8 instanceof com.superwall.sdk.delegate.InternalPurchaseResult.Purchased
            r5 = 0
            if (r4 == 0) goto L7f
            boolean r2 = r2.getShouldFinishTransactions()
            if (r2 == 0) goto L7f
            com.superwall.sdk.delegate.InternalPurchaseResult$Purchased r8 = (com.superwall.sdk.delegate.InternalPurchaseResult.Purchased) r8
            com.android.billingclient.api.Purchase r8 = r8.getPurchase()
            r0.L$0 = r5
            r0.L$1 = r5
            r0.label = r3
            java.lang.Object r7 = r7.makeStoreTransaction(r8, r0)
            if (r7 != r1) goto L7e
        L7d:
            return r1
        L7e:
            return r7
        L7f:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.superwall.sdk.billing.GoogleBillingWrapper.getLatestTransaction(com.superwall.sdk.dependencies.StoreTransactionFactory, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // com.superwall.sdk.billing.Billing
    public MutableStateFlow<InternalPurchaseResult> getPurchaseResults() {
        return this.purchaseResults;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // com.superwall.sdk.billing.Billing
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object getStorefrontCountryCode(kotlin.coroutines.Continuation<? super java.lang.String> r7) throws java.lang.Throwable {
        /*
            r6 = this;
            boolean r0 = r7 instanceof com.superwall.sdk.billing.GoogleBillingWrapper.C27801
            if (r0 == 0) goto L13
            r0 = r7
            com.superwall.sdk.billing.GoogleBillingWrapper$getStorefrontCountryCode$1 r0 = (com.superwall.sdk.billing.GoogleBillingWrapper.C27801) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.superwall.sdk.billing.GoogleBillingWrapper$getStorefrontCountryCode$1 r0 = new com.superwall.sdk.billing.GoogleBillingWrapper$getStorefrontCountryCode$1
            r0.<init>(r7)
        L18:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.label
            r3 = 1
            r4 = 0
            if (r2 == 0) goto L38
            if (r2 != r3) goto L30
            java.lang.Object r0 = r0.L$0
            kotlinx.coroutines.CompletableDeferred r0 = (kotlinx.coroutines.CompletableDeferred) r0
            kotlin.ResultKt.b(r7)     // Catch: java.lang.Throwable -> L2e
            goto L61
        L2e:
            r7 = move-exception
            goto L69
        L30:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r0)
            throw r7
        L38:
            kotlin.ResultKt.b(r7)
            kotlin.coroutines.CoroutineContext r7 = r0.getContext()
            kotlinx.coroutines.Job$Key r2 = kotlinx.coroutines.Job.v8
            kotlin.coroutines.CoroutineContext$Element r7 = r7.get(r2)
            kotlinx.coroutines.Job r7 = (kotlinx.coroutines.Job) r7
            kotlinx.coroutines.CompletableDeferred r7 = kotlinx.coroutines.CompletableDeferredKt.a(r7)
            com.superwall.sdk.billing.d r2 = new com.superwall.sdk.billing.d     // Catch: java.lang.Throwable -> L65
            r2.<init>()     // Catch: java.lang.Throwable -> L65
            executeRequestOnUIThread$default(r6, r4, r2, r3, r4)     // Catch: java.lang.Throwable -> L65
            r0.L$0 = r7     // Catch: java.lang.Throwable -> L65
            r0.label = r3     // Catch: java.lang.Throwable -> L65
            java.lang.Object r0 = r7.await(r0)     // Catch: java.lang.Throwable -> L65
            if (r0 != r1) goto L5e
            return r1
        L5e:
            r5 = r0
            r0 = r7
            r7 = r5
        L61:
            kotlinx.coroutines.Job.DefaultImpls.b(r0, r4, r3, r4)
            return r7
        L65:
            r0 = move-exception
            r5 = r0
            r0 = r7
            r7 = r5
        L69:
            kotlinx.coroutines.Job.DefaultImpls.b(r0, r4, r3, r4)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.superwall.sdk.billing.GoogleBillingWrapper.getStorefrontCountryCode(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00c3  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00cc  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00d5  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00e1  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00e6  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0117  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:26:0x00ae -> B:27:0x00af). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object latestPurchase$superwall_release(kotlin.coroutines.Continuation<? super java.util.List<? extends java.util.Map<java.lang.String, ? extends java.lang.Object>>> r12) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 282
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.superwall.sdk.billing.GoogleBillingWrapper.latestPurchase$superwall_release(kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // com.android.billingclient.api.BillingClientStateListener
    public void onBillingServiceDisconnected() {
        Logger.debug$default(Logger.INSTANCE, LogLevel.debug, LogScope.productsManager, "Billing client disconnected", (Map) null, (Throwable) null, 24, (Object) null);
    }

    @Override // com.android.billingclient.api.BillingClientStateListener
    public void onBillingSetupFinished(final BillingResult billingResult) {
        Intrinsics.checkNotNullParameter(billingResult, "billingResult");
        this.threadHandler.post(new Function0() { // from class: com.superwall.sdk.billing.i
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return GoogleBillingWrapper.onBillingSetupFinished$lambda$23(billingResult, this);
            }
        });
    }

    @Override // com.android.billingclient.api.PurchasesUpdatedListener
    public void onPurchasesUpdated(BillingResult result, List<Purchase> list) {
        Intrinsics.checkNotNullParameter(result, "result");
        Logger logger = Logger.INSTANCE;
        LogLevel logLevel = LogLevel.debug;
        LogScope logScope = LogScope.storeKitManager;
        Logger.debug$default(logger, logLevel, logScope, "onPurchasesUpdated: " + result, (Map) null, (Throwable) null, 24, (Object) null);
        if (result.c() != 0 || list == null) {
            if (result.c() == 1) {
                BuildersKt__Builders_commonKt.d(CoroutineScopeKt.a(Dispatchers.b()), null, null, new C27822(null), 3, null);
                Logger.debug$default(logger, logLevel, logScope, "User cancelled purchase", (Map) null, (Throwable) null, 24, (Object) null);
                return;
            } else {
                BuildersKt__Builders_commonKt.d(CoroutineScopeKt.a(Dispatchers.b()), null, null, new AnonymousClass3(result, null), 3, null);
                Logger.debug$default(logger, logLevel, logScope, "Purchase failed", (Map) null, (Throwable) null, 24, (Object) null);
                return;
            }
        }
        for (Purchase purchase : list) {
            Logger.debug$default(Logger.INSTANCE, LogLevel.debug, LogScope.storeKitManager, "Purchase: " + purchase, (Map) null, (Throwable) null, 24, (Object) null);
            BuildersKt__Builders_commonKt.d(CoroutineScopeKt.a(Dispatchers.b()), null, null, new C27811(purchase, null), 3, null);
        }
    }

    @Override // com.superwall.sdk.billing.Billing
    public Object queryAllPurchases(Continuation<? super List<? extends Purchase>> continuation) {
        return CoroutineScopeKt.f(new C27832(null), continuation);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX INFO: renamed from: queryType-gIAlu-s, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object m1260queryTypegIAlus(java.lang.String r6, kotlin.coroutines.Continuation<? super kotlin.Result<? extends java.util.List<? extends com.android.billingclient.api.Purchase>>> r7) {
        /*
            r5 = this;
            boolean r0 = r7 instanceof com.superwall.sdk.billing.GoogleBillingWrapper$queryType$1
            if (r0 == 0) goto L13
            r0 = r7
            com.superwall.sdk.billing.GoogleBillingWrapper$queryType$1 r0 = (com.superwall.sdk.billing.GoogleBillingWrapper$queryType$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.superwall.sdk.billing.GoogleBillingWrapper$queryType$1 r0 = new com.superwall.sdk.billing.GoogleBillingWrapper$queryType$1
            r0.<init>(r5, r7)
        L18:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            kotlin.ResultKt.b(r7)
            goto L81
        L29:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L31:
            kotlin.ResultKt.b(r7)
            r7 = 0
            kotlinx.coroutines.CompletableDeferred r2 = kotlinx.coroutines.CompletableDeferredKt.b(r7, r3, r7)
            com.android.billingclient.api.QueryPurchasesParams$Builder r4 = com.android.billingclient.api.QueryPurchasesParams.b()
            com.android.billingclient.api.QueryPurchasesParams$Builder r6 = r4.b(r6)
            com.android.billingclient.api.QueryPurchasesParams r6 = r6.a()
            java.lang.String r4 = "build(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r6, r4)
            com.superwall.sdk.billing.j r4 = new com.superwall.sdk.billing.j
            r4.<init>()
            kotlin.Unit r6 = r5.withConnectedClient(r4)
            if (r6 != 0) goto L71
            kotlin.Result$Companion r6 = kotlin.Result.f139772b
            java.lang.Throwable r6 = new java.lang.Throwable
            java.lang.String r4 = "Billing client not ready"
            r6.<init>(r4)
            java.lang.Object r6 = kotlin.ResultKt.a(r6)
            java.lang.Object r6 = kotlin.Result.b(r6)
            kotlin.Result r6 = kotlin.Result.a(r6)
            boolean r6 = r2.J(r6)
            kotlin.coroutines.jvm.internal.Boxing.a(r6)
        L71:
            com.superwall.sdk.billing.GoogleBillingWrapper$queryType$3 r6 = new com.superwall.sdk.billing.GoogleBillingWrapper$queryType$3
            r6.<init>(r2, r7)
            r0.label = r3
            r2 = 10000(0x2710, double:4.9407E-320)
            java.lang.Object r7 = kotlinx.coroutines.TimeoutKt.e(r2, r6, r0)
            if (r7 != r1) goto L81
            return r1
        L81:
            kotlin.Result r7 = (kotlin.Result) r7
            if (r7 == 0) goto L8a
            java.lang.Object r6 = r7.j()
            return r6
        L8a:
            kotlin.Result$Companion r6 = kotlin.Result.f139772b
            java.lang.Throwable r6 = new java.lang.Throwable
            java.lang.String r7 = "Query purchases timed out"
            r6.<init>(r7)
            java.lang.Object r6 = kotlin.ResultKt.a(r6)
            java.lang.Object r6 = kotlin.Result.b(r6)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.superwall.sdk.billing.GoogleBillingWrapper.m1260queryTypegIAlus(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final synchronized void setBillingClient(BillingClient billingClient) {
        this.billingClient = billingClient;
    }

    public final void startConnection() {
        synchronized (this) {
            try {
                if (this.billingClient == null) {
                    this.billingClient = (BillingClient) this.createBillingClient.invoke(this);
                }
                this.reconnectionAlreadyScheduled = false;
                BillingClient billingClient = this.billingClient;
                if (billingClient != null) {
                    if (!billingClient.f()) {
                        Logger.debug$default(Logger.INSTANCE, LogLevel.debug, LogScope.productsManager, "Starting billing client", (Map) null, (Throwable) null, 24, (Object) null);
                        try {
                            billingClient.l(this);
                        } catch (IllegalStateException e3) {
                            Logger.debug$default(Logger.INSTANCE, LogLevel.error, LogScope.productsManager, "IllegalStateException when connecting to billing client: " + e3.getMessage(), (Map) null, (Throwable) null, 24, (Object) null);
                            sendErrorsToAllPendingRequests(BillingError.IllegalStateException.INSTANCE);
                        }
                    }
                    Unit unit = Unit.f139807a;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void startConnectionOnMainThread(long j3) {
        this.threadHandler.postDelayed(new Function0() { // from class: com.superwall.sdk.billing.q
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return GoogleBillingWrapper.startConnectionOnMainThread$lambda$6(this.f93487a);
            }
        }, j3);
    }

    public final Unit withConnectedClient(Function1<? super BillingClient, Unit> receivingFunction) {
        Intrinsics.checkNotNullParameter(receivingFunction, "receivingFunction");
        BillingClient billingClient = this.billingClient;
        if (billingClient != null) {
            if (!billingClient.f()) {
                billingClient = null;
            }
            if (billingClient != null) {
                receivingFunction.invoke(billingClient);
                return Unit.f139807a;
            }
        }
        Logger.debug$default(Logger.INSTANCE, LogLevel.error, LogScope.productsManager, "Billing client not ready", (Map) null, (Throwable) null, 24, (Object) null);
        return null;
    }

    public /* synthetic */ GoogleBillingWrapper(final Context context, IOScope iOScope, AppLifecycleObserver appLifecycleObserver, Factory factory, Function1 function1, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, iOScope, appLifecycleObserver, factory, (i3 & 16) != 0 ? new Function1() { // from class: com.superwall.sdk.billing.n
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return GoogleBillingWrapper._init_$lambda$0(context, (PurchasesUpdatedListener) obj);
            }
        } : function1);
    }
}
