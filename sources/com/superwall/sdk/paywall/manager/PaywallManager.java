package com.superwall.sdk.paywall.manager;

import com.superwall.sdk.dependencies.CacheFactory;
import com.superwall.sdk.dependencies.DeviceHelperFactory;
import com.superwall.sdk.dependencies.SuperwallScopeFactory;
import com.superwall.sdk.dependencies.ViewFactory;
import com.superwall.sdk.misc.ScopesKt;
import com.superwall.sdk.models.paywall.Paywall;
import com.superwall.sdk.paywall.request.PaywallRequest;
import com.superwall.sdk.paywall.request.PaywallRequestManager;
import com.superwall.sdk.paywall.view.PaywallView;
import com.superwall.sdk.paywall.view.PaywallViewState;
import com.superwall.sdk.paywall.view.delegate.PaywallLoadingState;
import com.superwall.sdk.paywall.view.delegate.PaywallViewDelegateAdapter;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

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
public final class PaywallManager {
    private PaywallViewCache _cache;
    private PaywallView currentView;
    private final Factory factory;
    private final PaywallRequestManager paywallRequestManager;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public interface Factory extends ViewFactory, CacheFactory, DeviceHelperFactory, SuperwallScopeFactory {
    }

    /* JADX INFO: renamed from: com.superwall.sdk.paywall.manager.PaywallManager$getPaywallView$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "com.superwall.sdk.paywall.manager.PaywallManager", f = "PaywallManager.kt", l = {69, 70}, m = "getPaywallView")
    static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        boolean Z$0;
        boolean Z$1;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return PaywallManager.this.getPaywallView(null, false, false, null, this);
        }
    }

    /* JADX INFO: renamed from: com.superwall.sdk.paywall.manager.PaywallManager$getPaywallView$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "com.superwall.sdk.paywall.manager.PaywallManager$getPaywallView$2", f = "PaywallManager.kt", l = {105}, m = "invokeSuspend")
    static final class AnonymousClass2 extends SuspendLambda implements Function2<Paywall, Continuation<? super PaywallView>, Object> {
        final /* synthetic */ PaywallViewDelegateAdapter $delegate;
        final /* synthetic */ boolean $isForPresentation;
        final /* synthetic */ boolean $isPreloading;
        final /* synthetic */ PaywallRequest $request;
        /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(PaywallRequest paywallRequest, PaywallViewDelegateAdapter paywallViewDelegateAdapter, boolean z2, boolean z3, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.$request = paywallRequest;
            this.$delegate = paywallViewDelegateAdapter;
            this.$isForPresentation = z2;
            this.$isPreloading = z3;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass2 anonymousClass2 = PaywallManager.this.new AnonymousClass2(this.$request, this.$delegate, this.$isForPresentation, this.$isPreloading, continuation);
            anonymousClass2.L$0 = obj;
            return anonymousClass2;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Paywall paywall, Continuation<? super PaywallView> continuation) {
            return ((AnonymousClass2) create(paywall, continuation)).invokeSuspend(Unit.f139807a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Paywall paywall;
            PaywallView paywallView;
            Object objF = IntrinsicsKt.f();
            int i3 = this.label;
            if (i3 == 0) {
                ResultKt.b(obj);
                Paywall paywall2 = (Paywall) this.L$0;
                String strKey = PaywallCacheLogic.INSTANCE.key(paywall2.getIdentifier(), PaywallManager.this.factory.makeDeviceInfo().getLocale());
                if (!this.$request.isDebuggerLaunched() && (paywallView = PaywallManager.this.getCache().getPaywallView(strKey)) != null) {
                    boolean z2 = this.$isPreloading;
                    PaywallViewDelegateAdapter paywallViewDelegateAdapter = this.$delegate;
                    boolean z3 = this.$isForPresentation;
                    if (!z2) {
                        paywallView.setCallback(paywallViewDelegateAdapter);
                        paywallView.updateState(new PaywallViewState.Updates.MergePaywall(paywall2));
                        if (z3) {
                            paywallView.resetTransientPresentationState$superwall_release();
                        }
                    }
                    return paywallView;
                }
                Factory factory = PaywallManager.this.factory;
                PaywallViewCache cache = PaywallManager.this.getCache();
                PaywallViewDelegateAdapter paywallViewDelegateAdapter2 = this.$delegate;
                this.L$0 = paywall2;
                this.label = 1;
                Object objMakePaywallView = factory.makePaywallView(paywall2, cache, paywallViewDelegateAdapter2, this);
                if (objMakePaywallView == objF) {
                    return objF;
                }
                paywall = paywall2;
                obj = objMakePaywallView;
            } else {
                if (i3 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                paywall = (Paywall) this.L$0;
                ResultKt.b(obj);
            }
            PaywallView paywallView2 = (PaywallView) obj;
            PaywallManager.this.getCache().save(paywallView2, paywall.getIdentifier());
            if (this.$isForPresentation && (paywallView2.getLoadingState() instanceof PaywallLoadingState.Unknown)) {
                paywallView2.loadWebView();
            }
            return paywallView2;
        }
    }

    /* JADX INFO: renamed from: com.superwall.sdk.paywall.manager.PaywallManager$resetCache$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "com.superwall.sdk.paywall.manager.PaywallManager$resetCache$1", f = "PaywallManager.kt", l = {}, m = "invokeSuspend")
    static final class C28311 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C28311(Continuation<? super C28311> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return PaywallManager.this.new C28311(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            IntrinsicsKt.f();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
            String activePaywallVcKey = PaywallManager.this.getCache().getActivePaywallVcKey();
            List<PaywallView> allPaywallViews = PaywallManager.this.getCache().getAllPaywallViews();
            ArrayList arrayList = new ArrayList();
            for (Object obj2 : allPaywallViews) {
                if (!Intrinsics.areEqual(((PaywallView) obj2).getState().getCacheKey$superwall_release(), activePaywallVcKey)) {
                    arrayList.add(obj2);
                }
            }
            int size = arrayList.size();
            int i3 = 0;
            while (i3 < size) {
                Object obj3 = arrayList.get(i3);
                i3++;
                ((PaywallView) obj3).destroyWebview$superwall_release();
            }
            PaywallManager.this.getCache().removeAll();
            return Unit.f139807a;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C28311) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    public PaywallManager(Factory factory, PaywallRequestManager paywallRequestManager) {
        Intrinsics.checkNotNullParameter(factory, "factory");
        Intrinsics.checkNotNullParameter(paywallRequestManager, "paywallRequestManager");
        this.factory = factory;
        this.paywallRequestManager = paywallRequestManager;
    }

    private final PaywallViewCache createCache() {
        PaywallViewCache paywallViewCacheMakeCache = this.factory.makeCache();
        this._cache = paywallViewCacheMakeCache;
        return paywallViewCacheMakeCache;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final PaywallViewCache getCache() {
        if (this._cache == null) {
            this._cache = createCache();
        }
        PaywallViewCache paywallViewCache = this._cache;
        Intrinsics.checkNotNull(paywallViewCache);
        return paywallViewCache;
    }

    public final PaywallView getCurrentView() {
        return getCache().getActivePaywallView();
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object getPaywallView(com.superwall.sdk.paywall.request.PaywallRequest r14, boolean r15, boolean r16, com.superwall.sdk.paywall.view.delegate.PaywallViewDelegateAdapter r17, kotlin.coroutines.Continuation<? super com.superwall.sdk.misc.Either<com.superwall.sdk.paywall.view.PaywallView, java.lang.Throwable>> r18) throws java.lang.Throwable {
        /*
            r13 = this;
            r0 = r16
            r1 = r18
            boolean r2 = r1 instanceof com.superwall.sdk.paywall.manager.PaywallManager.AnonymousClass1
            if (r2 == 0) goto L17
            r2 = r1
            com.superwall.sdk.paywall.manager.PaywallManager$getPaywallView$1 r2 = (com.superwall.sdk.paywall.manager.PaywallManager.AnonymousClass1) r2
            int r3 = r2.label
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r5 = r3 & r4
            if (r5 == 0) goto L17
            int r3 = r3 - r4
            r2.label = r3
            goto L1c
        L17:
            com.superwall.sdk.paywall.manager.PaywallManager$getPaywallView$1 r2 = new com.superwall.sdk.paywall.manager.PaywallManager$getPaywallView$1
            r2.<init>(r1)
        L1c:
            java.lang.Object r1 = r2.result
            java.lang.Object r3 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r4 = r2.label
            r5 = 2
            r6 = 1
            if (r4 == 0) goto L50
            if (r4 == r6) goto L38
            if (r4 != r5) goto L30
            kotlin.ResultKt.b(r1)
            return r1
        L30:
            java.lang.IllegalStateException r14 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r14.<init>(r0)
            throw r14
        L38:
            boolean r14 = r2.Z$1
            boolean r0 = r2.Z$0
            java.lang.Object r4 = r2.L$2
            com.superwall.sdk.paywall.view.delegate.PaywallViewDelegateAdapter r4 = (com.superwall.sdk.paywall.view.delegate.PaywallViewDelegateAdapter) r4
            java.lang.Object r6 = r2.L$1
            com.superwall.sdk.paywall.request.PaywallRequest r6 = (com.superwall.sdk.paywall.request.PaywallRequest) r6
            java.lang.Object r7 = r2.L$0
            com.superwall.sdk.paywall.manager.PaywallManager r7 = (com.superwall.sdk.paywall.manager.PaywallManager) r7
            kotlin.ResultKt.b(r1)
            r11 = r14
            r10 = r0
            r8 = r6
        L4e:
            r9 = r4
            goto L6f
        L50:
            kotlin.ResultKt.b(r1)
            com.superwall.sdk.paywall.request.PaywallRequestManager r1 = r13.paywallRequestManager
            r2.L$0 = r13
            r2.L$1 = r14
            r4 = r17
            r2.L$2 = r4
            r2.Z$0 = r15
            r2.Z$1 = r0
            r2.label = r6
            java.lang.Object r1 = r1.getPaywall(r14, r0, r2)
            if (r1 != r3) goto L6a
            goto L86
        L6a:
            r7 = r13
            r8 = r14
            r10 = r15
            r11 = r0
            goto L4e
        L6f:
            com.superwall.sdk.misc.Either r1 = (com.superwall.sdk.misc.Either) r1
            com.superwall.sdk.paywall.manager.PaywallManager$getPaywallView$2 r6 = new com.superwall.sdk.paywall.manager.PaywallManager$getPaywallView$2
            r12 = 0
            r6.<init>(r8, r9, r10, r11, r12)
            r14 = 0
            r2.L$0 = r14
            r2.L$1 = r14
            r2.L$2 = r14
            r2.label = r5
            java.lang.Object r14 = com.superwall.sdk.misc.EitherKt.mapAsync(r1, r6, r2)
            if (r14 != r3) goto L87
        L86:
            return r3
        L87:
            return r14
        */
        throw new UnsupportedOperationException("Method not decompiled: com.superwall.sdk.paywall.manager.PaywallManager.getPaywallView(com.superwall.sdk.paywall.request.PaywallRequest, boolean, boolean, com.superwall.sdk.paywall.view.delegate.PaywallViewDelegateAdapter, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final void removePaywallView(String identifier) {
        Intrinsics.checkNotNullParameter(identifier, "identifier");
        getCache().removePaywallView(identifier);
    }

    public final void resetCache() {
        ScopesKt.launchWithTracking(this.factory.mainScope(), new C28311(null));
    }

    public final void resetPaywallRequestCache$superwall_release() {
        this.paywallRequestManager.resetCache$superwall_release();
    }

    public final void setCurrentView(PaywallView paywallView) {
        this.currentView = paywallView;
    }

    public final void resetPaywallRequestCache$superwall_release(Set<String> identifiers) {
        Intrinsics.checkNotNullParameter(identifiers, "identifiers");
        this.paywallRequestManager.removeCachedPaywalls(identifiers);
    }
}
