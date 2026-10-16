package com.superwall.sdk.paywall.presentation;

import com.sun.jna.Function;
import com.superwall.sdk.Superwall;
import com.superwall.sdk.dependencies.RequestFactory;
import com.superwall.sdk.misc.Either;
import com.superwall.sdk.models.config.FeatureGatingBehavior;
import com.superwall.sdk.paywall.presentation.PaywallCloseReason;
import com.superwall.sdk.paywall.presentation.internal.InternalPresentationKt;
import com.superwall.sdk.paywall.presentation.internal.InternalPresentationLogic;
import com.superwall.sdk.paywall.presentation.internal.PresentationRequest;
import com.superwall.sdk.paywall.presentation.internal.PresentationRequestType;
import com.superwall.sdk.paywall.presentation.internal.request.PaywallOverrides;
import com.superwall.sdk.paywall.presentation.internal.request.PresentationInfo;
import com.superwall.sdk.paywall.presentation.internal.state.PaywallResult;
import com.superwall.sdk.paywall.presentation.internal.state.PaywallSkippedReason;
import com.superwall.sdk.paywall.presentation.internal.state.PaywallState;
import com.superwall.sdk.paywall.view.PaywallView;
import com.superwall.sdk.utilities.ErrorTrackingKt;
import java.util.Map;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CompletableDeferredKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;

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
public final class PublicPresentationKt {

    /* JADX INFO: renamed from: com.superwall.sdk.paywall.presentation.PublicPresentationKt$dismiss$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "com.superwall.sdk.paywall.presentation.PublicPresentationKt$dismiss$2", f = "PublicPresentation.kt", l = {230}, m = "invokeSuspend")
    static final class AnonymousClass2 extends SuspendLambda implements Function5<PaywallView, PaywallResult, PaywallCloseReason, Function0<? extends Unit>, Continuation<? super Unit>, Object> {
        /* synthetic */ Object L$0;
        /* synthetic */ Object L$1;
        /* synthetic */ Object L$2;
        /* synthetic */ Object L$3;
        int label;

        AnonymousClass2(Continuation<? super AnonymousClass2> continuation) {
            super(5, continuation);
        }

        @Override // kotlin.jvm.functions.Function5
        public final Object invoke(PaywallView paywallView, PaywallResult paywallResult, PaywallCloseReason paywallCloseReason, Function0<Unit> function0, Continuation<? super Unit> continuation) {
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(continuation);
            anonymousClass2.L$0 = paywallView;
            anonymousClass2.L$1 = paywallResult;
            anonymousClass2.L$2 = paywallCloseReason;
            anonymousClass2.L$3 = function0;
            return anonymousClass2.invokeSuspend(Unit.f139807a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objF = IntrinsicsKt.f();
            int i3 = this.label;
            if (i3 == 0) {
                ResultKt.b(obj);
                PaywallView paywallView = (PaywallView) this.L$0;
                PaywallResult paywallResult = (PaywallResult) this.L$1;
                PaywallCloseReason paywallCloseReason = (PaywallCloseReason) this.L$2;
                Function0 function0 = (Function0) this.L$3;
                this.L$0 = null;
                this.L$1 = null;
                this.L$2 = null;
                this.label = 1;
                if (InternalPresentationKt.dismiss(paywallView, paywallResult, paywallCloseReason, function0, this) == objF) {
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

    /* JADX INFO: renamed from: com.superwall.sdk.paywall.presentation.PublicPresentationKt$dismissForNextPaywall$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "com.superwall.sdk.paywall.presentation.PublicPresentationKt$dismissForNextPaywall$2", f = "PublicPresentation.kt", l = {Function.MAX_NARGS}, m = "invokeSuspend")
    static final class C28322 extends SuspendLambda implements Function5<PaywallView, PaywallResult, PaywallCloseReason, Function0<? extends Unit>, Continuation<? super Unit>, Object> {
        /* synthetic */ Object L$0;
        /* synthetic */ Object L$1;
        /* synthetic */ Object L$2;
        /* synthetic */ Object L$3;
        int label;

        C28322(Continuation<? super C28322> continuation) {
            super(5, continuation);
        }

        @Override // kotlin.jvm.functions.Function5
        public final Object invoke(PaywallView paywallView, PaywallResult paywallResult, PaywallCloseReason paywallCloseReason, Function0<Unit> function0, Continuation<? super Unit> continuation) {
            C28322 c28322 = new C28322(continuation);
            c28322.L$0 = paywallView;
            c28322.L$1 = paywallResult;
            c28322.L$2 = paywallCloseReason;
            c28322.L$3 = function0;
            return c28322.invokeSuspend(Unit.f139807a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objF = IntrinsicsKt.f();
            int i3 = this.label;
            if (i3 == 0) {
                ResultKt.b(obj);
                PaywallView paywallView = (PaywallView) this.L$0;
                PaywallResult paywallResult = (PaywallResult) this.L$1;
                PaywallCloseReason paywallCloseReason = (PaywallCloseReason) this.L$2;
                Function0 function0 = (Function0) this.L$3;
                this.L$0 = null;
                this.L$1 = null;
                this.L$2 = null;
                this.label = 1;
                if (InternalPresentationKt.dismiss(paywallView, paywallResult, paywallCloseReason, function0, this) == objF) {
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

    /* JADX INFO: renamed from: com.superwall.sdk.paywall.presentation.PublicPresentationKt$dismissPaywall$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "com.superwall.sdk.paywall.presentation.PublicPresentationKt$dismissPaywall$2", f = "PublicPresentation.kt", l = {49, 59}, m = "invokeSuspend")
    static final class C28332 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ DismissParams $params;
        private /* synthetic */ Object L$0;
        Object L$1;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C28332(DismissParams dismissParams, Continuation<? super C28332> continuation) {
            super(2, continuation);
            this.$params = dismissParams;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit invokeSuspend$lambda$3$lambda$1$lambda$0(CompletableDeferred completableDeferred) {
            Unit unit = Unit.f139807a;
            completableDeferred.J(unit);
            return unit;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit invokeSuspend$lambda$4(Throwable th) {
            th.printStackTrace();
            return Unit.f139807a;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C28332 c28332 = new C28332(this.$params, continuation);
            c28332.L$0 = obj;
            return c28332;
        }

        /* JADX WARN: Code restructure failed: missing block: B:43:0x00ad, code lost:
        
            if (r3.await(r12) != r1) goto L45;
         */
        /* JADX WARN: Removed duplicated region for block: B:38:0x0087  */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r13) throws java.lang.Throwable {
            /*
                r12 = this;
                java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
                int r0 = r12.label
                r2 = 2
                r3 = 1
                r4 = 0
                if (r0 == 0) goto L2f
                if (r0 == r3) goto L1d
                if (r0 != r2) goto L15
                kotlin.ResultKt.b(r13)
                r11 = r12
                goto Lb0
            L15:
                java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r13.<init>(r0)
                throw r13
            L1d:
                java.lang.Object r0 = r12.L$1
                r3 = r0
                kotlinx.coroutines.CompletableDeferred r3 = (kotlinx.coroutines.CompletableDeferred) r3
                java.lang.Object r0 = r12.L$0
                kotlinx.coroutines.CoroutineScope r0 = (kotlinx.coroutines.CoroutineScope) r0
                kotlin.ResultKt.b(r13)     // Catch: java.lang.Throwable -> L2b
                r11 = r12
                goto L62
            L2b:
                r0 = move-exception
                r13 = r0
                r11 = r12
                goto L81
            L2f:
                kotlin.ResultKt.b(r13)
                java.lang.Object r13 = r12.L$0
                kotlinx.coroutines.CoroutineScope r13 = (kotlinx.coroutines.CoroutineScope) r13
                kotlinx.coroutines.CompletableDeferred r5 = kotlinx.coroutines.CompletableDeferredKt.b(r4, r3, r4)
                com.superwall.sdk.paywall.presentation.DismissParams r0 = r12.$params
                com.superwall.sdk.paywall.view.PaywallView r7 = r0.getPaywallView()     // Catch: java.lang.Throwable -> L6c
                if (r7 == 0) goto L6f
                kotlin.jvm.functions.Function5 r6 = r0.getDismissAction()     // Catch: java.lang.Throwable -> L6c
                com.superwall.sdk.paywall.presentation.internal.state.PaywallResult r8 = r0.getResult()     // Catch: java.lang.Throwable -> L6c
                com.superwall.sdk.paywall.presentation.PaywallCloseReason r9 = r0.getCloseReason()     // Catch: java.lang.Throwable -> L6c
                com.superwall.sdk.paywall.presentation.h r10 = new com.superwall.sdk.paywall.presentation.h     // Catch: java.lang.Throwable -> L6c
                r10.<init>()     // Catch: java.lang.Throwable -> L6c
                r12.L$0 = r13     // Catch: java.lang.Throwable -> L6c
                r12.L$1 = r5     // Catch: java.lang.Throwable -> L6c
                r12.label = r3     // Catch: java.lang.Throwable -> L6c
                r11 = r12
                java.lang.Object r13 = r6.invoke(r7, r8, r9, r10, r11)     // Catch: java.lang.Throwable -> L68
                if (r13 != r1) goto L61
                goto Laf
            L61:
                r3 = r5
            L62:
                kotlin.Unit r13 = kotlin.Unit.f139807a     // Catch: java.lang.Throwable -> L65
                goto L7b
            L65:
                r0 = move-exception
                r13 = r0
                goto L81
            L68:
                r0 = move-exception
            L69:
                r13 = r0
                r3 = r5
                goto L81
            L6c:
                r0 = move-exception
                r11 = r12
                goto L69
            L6f:
                r11 = r12
                kotlin.Unit r13 = kotlin.Unit.f139807a     // Catch: java.lang.Throwable -> L68
                boolean r13 = r5.J(r13)     // Catch: java.lang.Throwable -> L68
                java.lang.Boolean r13 = kotlin.coroutines.jvm.internal.Boxing.a(r13)     // Catch: java.lang.Throwable -> L68
                r3 = r5
            L7b:
                com.superwall.sdk.misc.Either$Success r0 = new com.superwall.sdk.misc.Either$Success     // Catch: java.lang.Throwable -> L65
                r0.<init>(r13)     // Catch: java.lang.Throwable -> L65
                goto L9b
            L81:
                boolean r0 = com.superwall.sdk.utilities.ErrorTrackingKt.shouldLog(r13)
                if (r0 == 0) goto L96
                com.superwall.sdk.Superwall$Companion r0 = com.superwall.sdk.Superwall.Companion
                boolean r5 = r0.getInitialized()
                if (r5 == 0) goto L96
                com.superwall.sdk.Superwall r0 = r0.getInstance()
                com.superwall.sdk.utilities.ErrorTrackingKt.trackError(r0, r13)
            L96:
                com.superwall.sdk.misc.Either$Failure r0 = new com.superwall.sdk.misc.Either$Failure
                r0.<init>(r13)
            L9b:
                com.superwall.sdk.paywall.presentation.i r13 = new com.superwall.sdk.paywall.presentation.i
                r13.<init>()
                com.superwall.sdk.misc.EitherKt.onError(r0, r13)
                r11.L$0 = r4
                r11.L$1 = r4
                r11.label = r2
                java.lang.Object r13 = r3.await(r12)
                if (r13 != r1) goto Lb0
            Laf:
                return r1
            Lb0:
                kotlin.Unit r13 = kotlin.Unit.f139807a
                return r13
            */
            throw new UnsupportedOperationException("Method not decompiled: com.superwall.sdk.paywall.presentation.PublicPresentationKt.C28332.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C28332) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX INFO: renamed from: com.superwall.sdk.paywall.presentation.PublicPresentationKt$dismissSync$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "com.superwall.sdk.paywall.presentation.PublicPresentationKt$dismissSync$1", f = "PublicPresentation.kt", l = {241}, m = "invokeSuspend")
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Superwall $this_dismissSync;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(Superwall superwall, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$this_dismissSync = superwall;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$this_dismissSync, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objF = IntrinsicsKt.f();
            int i3 = this.label;
            if (i3 == 0) {
                ResultKt.b(obj);
                Superwall superwall = this.$this_dismissSync;
                this.label = 1;
                if (PublicPresentationKt.dismiss(superwall, this) == objF) {
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
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX INFO: renamed from: com.superwall.sdk.paywall.presentation.PublicPresentationKt$dismissSyncForNextPaywall$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "com.superwall.sdk.paywall.presentation.PublicPresentationKt$dismissSyncForNextPaywall$1", f = "PublicPresentation.kt", l = {267}, m = "invokeSuspend")
    static final class C28341 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Superwall $this_dismissSyncForNextPaywall;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C28341(Superwall superwall, Continuation<? super C28341> continuation) {
            super(2, continuation);
            this.$this_dismissSyncForNextPaywall = superwall;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C28341(this.$this_dismissSyncForNextPaywall, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objF = IntrinsicsKt.f();
            int i3 = this.label;
            if (i3 == 0) {
                ResultKt.b(obj);
                Superwall superwall = this.$this_dismissSyncForNextPaywall;
                this.label = 1;
                if (PublicPresentationKt.dismissForNextPaywall(superwall, this) == objF) {
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
            return ((C28341) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX INFO: renamed from: com.superwall.sdk.paywall.presentation.PublicPresentationKt$performTrackAndPresent$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "com.superwall.sdk.paywall.presentation.PublicPresentationKt", f = "PublicPresentation.kt", l = {97, 110, 112}, m = "performTrackAndPresent")
    static final class C28351 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C28351(Continuation<? super C28351> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return PublicPresentationKt.performTrackAndPresent(null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.superwall.sdk.paywall.presentation.PublicPresentationKt$registerPaywall$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "com.superwall.sdk.paywall.presentation.PublicPresentationKt$registerPaywall$1", f = "PublicPresentation.kt", l = {143}, m = "invokeSuspend")
    static final class C28361 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ CompletableDeferred<Unit> $collectionWillStart;
        final /* synthetic */ RegisterContext $context;
        final /* synthetic */ MutableSharedFlow<PaywallState> $publisher;
        final /* synthetic */ RegisterRequest $request;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C28361(CompletableDeferred<Unit> completableDeferred, MutableSharedFlow<PaywallState> mutableSharedFlow, RegisterRequest registerRequest, RegisterContext registerContext, Continuation<? super C28361> continuation) {
            super(2, continuation);
            this.$collectionWillStart = completableDeferred;
            this.$publisher = mutableSharedFlow;
            this.$request = registerRequest;
            this.$context = registerContext;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C28361(this.$collectionWillStart, this.$publisher, this.$request, this.$context, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objF = IntrinsicsKt.f();
            int i3 = this.label;
            if (i3 == 0) {
                ResultKt.b(obj);
                this.$collectionWillStart.J(Unit.f139807a);
                MutableSharedFlow<PaywallState> mutableSharedFlow = this.$publisher;
                final RegisterRequest registerRequest = this.$request;
                final RegisterContext registerContext = this.$context;
                FlowCollector flowCollector = new FlowCollector() { // from class: com.superwall.sdk.paywall.presentation.PublicPresentationKt.registerPaywall.1.1
                    @Override // kotlinx.coroutines.flow.FlowCollector
                    public /* bridge */ /* synthetic */ Object emit(Object obj2, Continuation continuation) {
                        return emit((PaywallState) obj2, (Continuation<? super Unit>) continuation);
                    }

                    public final Object emit(PaywallState paywallState, Continuation<? super Unit> continuation) {
                        Function1<Throwable, Unit> onErrorHandler$superwall_release;
                        Function1<PaywallSkippedReason, Unit> onSkipHandler$superwall_release;
                        Function1<Throwable, Unit> onErrorHandler$superwall_release2;
                        Function0<Unit> completion;
                        Function2<PaywallInfo, PaywallResult, Unit> onDismissHandler$superwall_release;
                        Function1<PaywallInfo, Unit> onPresentHandler$superwall_release;
                        Function2<CustomCallback, Continuation<? super CustomCallbackResult>, Object> onCustomCallbackHandler$superwall_release;
                        Function2<String, Function2<? super CustomCallback, ? super Continuation<? super CustomCallbackResult>, ? extends Object>, Unit> registerCustomCallback;
                        RegisterRequest registerRequest2 = registerRequest;
                        RegisterContext registerContext2 = registerContext;
                        try {
                            Unit unit = null;
                            if (paywallState instanceof PaywallState.Presented) {
                                PaywallPresentationHandler handler = registerRequest2.getHandler();
                                if (handler != null && (onCustomCallbackHandler$superwall_release = handler.getOnCustomCallbackHandler$superwall_release()) != null && (registerCustomCallback = registerContext2.getRegisterCustomCallback()) != null) {
                                    registerCustomCallback.invoke(((PaywallState.Presented) paywallState).getPaywallInfo().getIdentifier(), onCustomCallbackHandler$superwall_release);
                                }
                                PaywallPresentationHandler handler2 = registerRequest2.getHandler();
                                if (handler2 != null && (onPresentHandler$superwall_release = handler2.getOnPresentHandler$superwall_release()) != null) {
                                    onPresentHandler$superwall_release.invoke(((PaywallState.Presented) paywallState).getPaywallInfo());
                                    unit = Unit.f139807a;
                                }
                            } else if (paywallState instanceof PaywallState.Dismissed) {
                                PaywallInfo paywallInfoComponent1 = ((PaywallState.Dismissed) paywallState).component1();
                                PaywallResult paywallResultComponent2 = ((PaywallState.Dismissed) paywallState).component2();
                                Function1<String, Unit> unregisterCustomCallback = registerContext2.getUnregisterCustomCallback();
                                if (unregisterCustomCallback != null) {
                                    unregisterCustomCallback.invoke(paywallInfoComponent1.getIdentifier());
                                }
                                PaywallPresentationHandler handler3 = registerRequest2.getHandler();
                                if (handler3 != null && (onDismissHandler$superwall_release = handler3.getOnDismissHandler$superwall_release()) != null) {
                                    onDismissHandler$superwall_release.invoke(paywallInfoComponent1, paywallResultComponent2);
                                }
                                if ((paywallResultComponent2 instanceof PaywallResult.Purchased) || (paywallResultComponent2 instanceof PaywallResult.Restored)) {
                                    Function0<Unit> completion2 = registerRequest2.getCompletion();
                                    if (completion2 != null) {
                                        completion2.invoke();
                                        unit = Unit.f139807a;
                                    }
                                } else {
                                    if (!(paywallResultComponent2 instanceof PaywallResult.Declined)) {
                                        throw new NoWhenBranchMatchedException();
                                    }
                                    PaywallCloseReason closeReason = paywallInfoComponent1.getCloseReason();
                                    FeatureGatingBehavior featureGatingBehavior = paywallInfoComponent1.getFeatureGatingBehavior();
                                    if (closeReason.getStateShouldComplete() && Intrinsics.areEqual(featureGatingBehavior, FeatureGatingBehavior.NonGated.INSTANCE) && (completion = registerRequest2.getCompletion()) != null) {
                                        completion.invoke();
                                    }
                                    if (Intrinsics.areEqual(closeReason, PaywallCloseReason.WebViewFailedToLoad.INSTANCE) && Intrinsics.areEqual(featureGatingBehavior, FeatureGatingBehavior.Gated.INSTANCE)) {
                                        Throwable thPresentationError = InternalPresentationLogic.INSTANCE.presentationError("SWKPresentationError", 106, "Webview Failed", "Trying to present gated paywall but the webview could not load.");
                                        PaywallPresentationHandler handler4 = registerRequest2.getHandler();
                                        if (handler4 != null && (onErrorHandler$superwall_release2 = handler4.getOnErrorHandler$superwall_release()) != null) {
                                            onErrorHandler$superwall_release2.invoke(thPresentationError);
                                        }
                                    }
                                    unit = Unit.f139807a;
                                }
                            } else if (paywallState instanceof PaywallState.Skipped) {
                                PaywallSkippedReason paywallSkippedReasonComponent1 = ((PaywallState.Skipped) paywallState).component1();
                                PaywallPresentationHandler handler5 = registerRequest2.getHandler();
                                if (handler5 != null && (onSkipHandler$superwall_release = handler5.getOnSkipHandler$superwall_release()) != null) {
                                    onSkipHandler$superwall_release.invoke(paywallSkippedReasonComponent1);
                                }
                                Function0<Unit> completion3 = registerRequest2.getCompletion();
                                if (completion3 != null) {
                                    completion3.invoke();
                                    unit = Unit.f139807a;
                                }
                            } else {
                                if (!(paywallState instanceof PaywallState.PresentationError)) {
                                    throw new NoWhenBranchMatchedException();
                                }
                                PaywallPresentationHandler handler6 = registerRequest2.getHandler();
                                if (handler6 != null && (onErrorHandler$superwall_release = handler6.getOnErrorHandler$superwall_release()) != null) {
                                    onErrorHandler$superwall_release.invoke(((PaywallState.PresentationError) paywallState).getError());
                                    unit = Unit.f139807a;
                                }
                            }
                            new Either.Success(unit);
                        } catch (Throwable th) {
                            if (ErrorTrackingKt.shouldLog(th)) {
                                Superwall.Companion companion = Superwall.Companion;
                                if (companion.getInitialized()) {
                                    ErrorTrackingKt.trackError(companion.getInstance(), th);
                                }
                            }
                            new Either.Failure(th);
                        }
                        return Unit.f139807a;
                    }
                };
                this.label = 1;
                if (mutableSharedFlow.collect(flowCollector, this) == objF) {
                    return objF;
                }
            } else {
                if (i3 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.b(obj);
            }
            throw new KotlinNothingValueException();
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C28361) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX INFO: renamed from: com.superwall.sdk.paywall.presentation.PublicPresentationKt$registerPaywall$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "com.superwall.sdk.paywall.presentation.PublicPresentationKt$registerPaywall$2", f = "PublicPresentation.kt", l = {203, 204}, m = "invokeSuspend")
    static final class C28372 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        final /* synthetic */ CompletableDeferred<Unit> $collectionWillStart;
        final /* synthetic */ RegisterContext $context;
        final /* synthetic */ MutableSharedFlow<PaywallState> $publisher;
        final /* synthetic */ RegisterRequest $request;
        Object L$0;
        Object L$1;
        Object L$2;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C28372(CompletableDeferred<Unit> completableDeferred, RegisterContext registerContext, RegisterRequest registerRequest, MutableSharedFlow<PaywallState> mutableSharedFlow, Continuation<? super C28372> continuation) {
            super(1, continuation);
            this.$collectionWillStart = completableDeferred;
            this.$context = registerContext;
            this.$request = registerRequest;
            this.$publisher = mutableSharedFlow;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return new C28372(this.$collectionWillStart, this.$context, this.$request, this.$publisher, continuation);
        }

        /* JADX WARN: Code restructure failed: missing block: B:24:0x0074, code lost:
        
            if (com.superwall.sdk.paywall.presentation.PublicPresentationKt.performTrackAndPresent(r13, r6, r12) == r0) goto L25;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r13) throws java.lang.Throwable {
            /*
                r12 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
                int r1 = r12.label
                r2 = 2
                r3 = 1
                if (r1 == 0) goto L2e
                if (r1 == r3) goto L1d
                if (r1 != r2) goto L15
                kotlin.ResultKt.b(r13)     // Catch: java.lang.Throwable -> L12
                goto L77
            L12:
                r0 = move-exception
                r13 = r0
                goto L7f
            L15:
                java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r13.<init>(r0)
                throw r13
            L1d:
                java.lang.Object r1 = r12.L$2
                kotlinx.coroutines.flow.MutableSharedFlow r1 = (kotlinx.coroutines.flow.MutableSharedFlow) r1
                java.lang.Object r4 = r12.L$1
                com.superwall.sdk.paywall.presentation.RegisterRequest r4 = (com.superwall.sdk.paywall.presentation.RegisterRequest) r4
                java.lang.Object r5 = r12.L$0
                com.superwall.sdk.paywall.presentation.RegisterContext r5 = (com.superwall.sdk.paywall.presentation.RegisterContext) r5
                kotlin.ResultKt.b(r13)     // Catch: java.lang.Throwable -> L12
            L2c:
                r11 = r1
                goto L48
            L2e:
                kotlin.ResultKt.b(r13)
                kotlinx.coroutines.CompletableDeferred<kotlin.Unit> r13 = r12.$collectionWillStart
                com.superwall.sdk.paywall.presentation.RegisterContext r5 = r12.$context
                com.superwall.sdk.paywall.presentation.RegisterRequest r4 = r12.$request
                kotlinx.coroutines.flow.MutableSharedFlow<com.superwall.sdk.paywall.presentation.internal.state.PaywallState> r1 = r12.$publisher
                r12.L$0 = r5     // Catch: java.lang.Throwable -> L12
                r12.L$1 = r4     // Catch: java.lang.Throwable -> L12
                r12.L$2 = r1     // Catch: java.lang.Throwable -> L12
                r12.label = r3     // Catch: java.lang.Throwable -> L12
                java.lang.Object r13 = r13.await(r12)     // Catch: java.lang.Throwable -> L12
                if (r13 != r0) goto L2c
                goto L76
            L48:
                com.superwall.sdk.paywall.presentation.TrackAndPresentContext r13 = r5.getTrackAndPresentContext()     // Catch: java.lang.Throwable -> L12
                com.superwall.sdk.paywall.presentation.TrackAndPresentRequest r6 = new com.superwall.sdk.paywall.presentation.TrackAndPresentRequest     // Catch: java.lang.Throwable -> L12
                java.lang.String r7 = r4.getPlacement()     // Catch: java.lang.Throwable -> L12
                java.util.Map r8 = r4.getParams()     // Catch: java.lang.Throwable -> L12
                com.superwall.sdk.paywall.presentation.internal.request.PaywallOverrides r9 = r4.getPaywallOverrides()     // Catch: java.lang.Throwable -> L12
                kotlin.jvm.functions.Function0 r1 = r4.getCompletion()     // Catch: java.lang.Throwable -> L12
                if (r1 == 0) goto L62
            L60:
                r10 = r3
                goto L64
            L62:
                r3 = 0
                goto L60
            L64:
                r6.<init>(r7, r8, r9, r10, r11)     // Catch: java.lang.Throwable -> L12
                r1 = 0
                r12.L$0 = r1     // Catch: java.lang.Throwable -> L12
                r12.L$1 = r1     // Catch: java.lang.Throwable -> L12
                r12.L$2 = r1     // Catch: java.lang.Throwable -> L12
                r12.label = r2     // Catch: java.lang.Throwable -> L12
                java.lang.Object r13 = com.superwall.sdk.paywall.presentation.PublicPresentationKt.performTrackAndPresent(r13, r6, r12)     // Catch: java.lang.Throwable -> L12
                if (r13 != r0) goto L77
            L76:
                return r0
            L77:
                kotlin.Unit r13 = kotlin.Unit.f139807a     // Catch: java.lang.Throwable -> L12
                com.superwall.sdk.misc.Either$Success r0 = new com.superwall.sdk.misc.Either$Success     // Catch: java.lang.Throwable -> L12
                r0.<init>(r13)     // Catch: java.lang.Throwable -> L12
                goto L99
            L7f:
                boolean r0 = com.superwall.sdk.utilities.ErrorTrackingKt.shouldLog(r13)
                if (r0 == 0) goto L94
                com.superwall.sdk.Superwall$Companion r0 = com.superwall.sdk.Superwall.Companion
                boolean r1 = r0.getInitialized()
                if (r1 == 0) goto L94
                com.superwall.sdk.Superwall r0 = r0.getInstance()
                com.superwall.sdk.utilities.ErrorTrackingKt.trackError(r0, r13)
            L94:
                com.superwall.sdk.misc.Either$Failure r0 = new com.superwall.sdk.misc.Either$Failure
                r0.<init>(r13)
            L99:
                kotlin.Unit r13 = kotlin.Unit.f139807a
                return r13
            */
            throw new UnsupportedOperationException("Method not decompiled: com.superwall.sdk.paywall.presentation.PublicPresentationKt.C28372.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Unit> continuation) {
            return ((C28372) create(continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    public static final Object dismiss(Superwall superwall, Continuation<? super Unit> continuation) {
        Object objDismissPaywall = dismissPaywall(new DismissParams(Dispatchers.c(), superwall.getPaywallView(), new PaywallResult.Declined(), PaywallCloseReason.SystemLogic.INSTANCE, new AnonymousClass2(null)), continuation);
        return objDismissPaywall == IntrinsicsKt.f() ? objDismissPaywall : Unit.f139807a;
    }

    public static final Object dismissForNextPaywall(Superwall superwall, Continuation<? super Unit> continuation) {
        Object objDismissPaywall = dismissPaywall(new DismissParams(Dispatchers.c(), superwall.getPaywallView(), new PaywallResult.Declined(), PaywallCloseReason.ForNextPaywall.INSTANCE, new C28322(null)), continuation);
        return objDismissPaywall == IntrinsicsKt.f() ? objDismissPaywall : Unit.f139807a;
    }

    public static final Object dismissPaywall(DismissParams dismissParams, Continuation<? super Unit> continuation) {
        Object objG = BuildersKt.g(dismissParams.getDispatcher(), new C28332(dismissParams, null), continuation);
        return objG == IntrinsicsKt.f() ? objG : Unit.f139807a;
    }

    public static final void dismissSync(Superwall superwall) {
        Intrinsics.checkNotNullParameter(superwall, "<this>");
        BuildersKt__BuildersKt.b(null, new AnonymousClass1(superwall, null), 1, null);
    }

    public static final void dismissSyncForNextPaywall(Superwall superwall) {
        Intrinsics.checkNotNullParameter(superwall, "<this>");
        BuildersKt__BuildersKt.b(null, new C28341(superwall, null), 1, null);
    }

    private static final void internallyRegister(final Superwall superwall, String str, Map<String, ? extends Object> map, PaywallPresentationHandler paywallPresentationHandler, Function0<Unit> function0) {
        registerPaywall(new RegisterContext(Dispatchers.c(), CoroutineScopeKt.a(Dispatchers.c()), superwall.getSerialTaskManager$superwall_release(), new TrackAndPresentContext(new PublicPresentationKt$internallyRegister$registerContext$1(superwall, null), new Function4() { // from class: com.superwall.sdk.paywall.presentation.d
            @Override // kotlin.jvm.functions.Function4
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                return PublicPresentationKt.internallyRegister$lambda$3(superwall, (PresentationInfo) obj, (PaywallOverrides) obj2, ((Boolean) obj3).booleanValue(), (PresentationRequestType) obj4);
            }
        }, new Function0() { // from class: com.superwall.sdk.paywall.presentation.e
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Boolean.valueOf(superwall.isPaywallPresented());
            }
        }, new PublicPresentationKt$internallyRegister$registerContext$4(superwall, null)), new Function2() { // from class: com.superwall.sdk.paywall.presentation.f
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return PublicPresentationKt.internallyRegister$lambda$5(superwall, (String) obj, (Function2) obj2);
            }
        }, new Function1() { // from class: com.superwall.sdk.paywall.presentation.g
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return PublicPresentationKt.internallyRegister$lambda$6(superwall, (String) obj);
            }
        }), new RegisterRequest(str, map, paywallPresentationHandler, function0, null));
    }

    static /* synthetic */ void internallyRegister$default(Superwall superwall, String str, Map map, PaywallPresentationHandler paywallPresentationHandler, Function0 function0, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            map = null;
        }
        if ((i3 & 4) != 0) {
            paywallPresentationHandler = null;
        }
        if ((i3 & 8) != 0) {
            function0 = null;
        }
        internallyRegister(superwall, str, map, paywallPresentationHandler, function0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PresentationRequest internallyRegister$lambda$3(Superwall superwall, PresentationInfo info, PaywallOverrides paywallOverrides, boolean z2, PresentationRequestType type) {
        Intrinsics.checkNotNullParameter(info, "info");
        Intrinsics.checkNotNullParameter(type, "type");
        return RequestFactory.DefaultImpls.makePresentationRequest$default(superwall.getDependencyContainer$superwall_release(), info, paywallOverrides, null, null, null, z2, type, 28, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit internallyRegister$lambda$5(Superwall superwall, String paywallId, Function2 callbackHandler) {
        Intrinsics.checkNotNullParameter(paywallId, "paywallId");
        Intrinsics.checkNotNullParameter(callbackHandler, "callbackHandler");
        superwall.getDependencyContainer$superwall_release().getCustomCallbackRegistry$superwall_release().register(paywallId, callbackHandler);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit internallyRegister$lambda$6(Superwall superwall, String paywallId) {
        Intrinsics.checkNotNullParameter(paywallId, "paywallId");
        superwall.getDependencyContainer$superwall_release().getCustomCallbackRegistry$superwall_release().unregister(paywallId);
        return Unit.f139807a;
    }

    /* JADX WARN: Code restructure failed: missing block: B:56:0x012a, code lost:
    
        if (r11.emit(r12, r0) == r1) goto L57;
     */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0104  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x010d  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Object performTrackAndPresent(com.superwall.sdk.paywall.presentation.TrackAndPresentContext r10, com.superwall.sdk.paywall.presentation.TrackAndPresentRequest r11, kotlin.coroutines.Continuation<? super kotlin.Unit> r12) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 313
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.superwall.sdk.paywall.presentation.PublicPresentationKt.performTrackAndPresent(com.superwall.sdk.paywall.presentation.TrackAndPresentContext, com.superwall.sdk.paywall.presentation.TrackAndPresentRequest, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static final void register(Superwall superwall, String placement) {
        Intrinsics.checkNotNullParameter(superwall, "<this>");
        Intrinsics.checkNotNullParameter(placement, "placement");
        register$default(superwall, placement, null, null, null, 14, null);
    }

    public static /* synthetic */ void register$default(Superwall superwall, String str, Map map, PaywallPresentationHandler paywallPresentationHandler, Function0 function0, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            map = null;
        }
        if ((i3 & 4) != 0) {
            paywallPresentationHandler = null;
        }
        if ((i3 & 8) != 0) {
            function0 = null;
        }
        register(superwall, str, map, paywallPresentationHandler, function0);
    }

    public static final void registerPaywall(RegisterContext context, RegisterRequest request) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(request, "request");
        MutableSharedFlow mutableSharedFlowB = SharedFlowKt.b(0, 0, null, 7, null);
        CompletableDeferred completableDeferredB = CompletableDeferredKt.b(null, 1, null);
        BuildersKt__Builders_commonKt.d(context.getCollectionScope(), null, null, new C28361(completableDeferredB, mutableSharedFlowB, request, context, null), 3, null);
        context.getSerialTaskManager().addTask(new C28372(completableDeferredB, context, request, mutableSharedFlowB, null));
    }

    public static final void register(Superwall superwall, String placement, Map<String, ? extends Object> map) {
        Intrinsics.checkNotNullParameter(superwall, "<this>");
        Intrinsics.checkNotNullParameter(placement, "placement");
        register$default(superwall, placement, map, null, null, 12, null);
    }

    public static final void register(Superwall superwall, String placement, Map<String, ? extends Object> map, PaywallPresentationHandler paywallPresentationHandler) {
        Intrinsics.checkNotNullParameter(superwall, "<this>");
        Intrinsics.checkNotNullParameter(placement, "placement");
        register$default(superwall, placement, map, paywallPresentationHandler, null, 8, null);
    }

    public static final void register(Superwall superwall, String placement, Map<String, ? extends Object> map, PaywallPresentationHandler paywallPresentationHandler, Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(superwall, "<this>");
        Intrinsics.checkNotNullParameter(placement, "placement");
        internallyRegister(superwall, placement, map, paywallPresentationHandler, function0);
    }
}
