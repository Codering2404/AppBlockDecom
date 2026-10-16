package com.superwall.sdk.paywall.presentation.get_paywall;

import com.superwall.sdk.Superwall;
import com.superwall.sdk.misc.Either;
import com.superwall.sdk.misc.IOScope;
import com.superwall.sdk.paywall.presentation.internal.PresentationRequest;
import com.superwall.sdk.paywall.presentation.internal.state.PaywallState;
import com.superwall.sdk.paywall.view.PaywallView;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowKt;
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
public final class InternalGetPaywallKt {

    /* JADX INFO: renamed from: com.superwall.sdk.paywall.presentation.get_paywall.InternalGetPaywallKt$getPaywall$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "com.superwall.sdk.paywall.presentation.get_paywall.InternalGetPaywallKt", f = "InternalGetPaywall.kt", l = {40, 49}, m = "getPaywall")
    static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return InternalGetPaywallKt.getPaywall(null, null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.superwall.sdk.paywall.presentation.get_paywall.InternalGetPaywallKt$getPaywallSync$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "com.superwall.sdk.paywall.presentation.get_paywall.InternalGetPaywallKt$getPaywallSync$2", f = "InternalGetPaywall.kt", l = {68}, m = "invokeSuspend")
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function1<PaywallState, Unit> $onStateChanged;
        final /* synthetic */ MutableSharedFlow<PaywallState> $publisher;
        int label;

        /* JADX INFO: renamed from: com.superwall.sdk.paywall.presentation.get_paywall.InternalGetPaywallKt$getPaywallSync$2$1, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        @DebugMetadata(c = "com.superwall.sdk.paywall.presentation.get_paywall.InternalGetPaywallKt$getPaywallSync$2$1", f = "InternalGetPaywall.kt", l = {}, m = "invokeSuspend")
        static final class AnonymousClass1 extends SuspendLambda implements Function2<PaywallState, Continuation<? super Unit>, Object> {
            final /* synthetic */ Function1<PaywallState, Unit> $onStateChanged;
            /* synthetic */ Object L$0;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            AnonymousClass1(Function1<? super PaywallState, Unit> function1, Continuation<? super AnonymousClass1> continuation) {
                super(2, continuation);
                this.$onStateChanged = function1;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$onStateChanged, continuation);
                anonymousClass1.L$0 = obj;
                return anonymousClass1;
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(PaywallState paywallState, Continuation<? super Unit> continuation) {
                return ((AnonymousClass1) create(paywallState, continuation)).invokeSuspend(Unit.f139807a);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) throws Throwable {
                IntrinsicsKt.f();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.b(obj);
                this.$onStateChanged.invoke((PaywallState) this.L$0);
                return Unit.f139807a;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass2(MutableSharedFlow<PaywallState> mutableSharedFlow, Function1<? super PaywallState, Unit> function1, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.$publisher = mutableSharedFlow;
            this.$onStateChanged = function1;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass2(this.$publisher, this.$onStateChanged, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objF = IntrinsicsKt.f();
            int i3 = this.label;
            if (i3 == 0) {
                ResultKt.b(obj);
                MutableSharedFlow<PaywallState> mutableSharedFlow = this.$publisher;
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$onStateChanged, null);
                this.label = 1;
                if (FlowKt.l(mutableSharedFlow, anonymousClass1, this) == objF) {
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
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX INFO: renamed from: com.superwall.sdk.paywall.presentation.get_paywall.InternalGetPaywallKt$getPaywallSync$3, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "com.superwall.sdk.paywall.presentation.get_paywall.InternalGetPaywallKt$getPaywallSync$3", f = "InternalGetPaywall.kt", l = {73}, m = "invokeSuspend")
    static final class AnonymousClass3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Either<? extends PaywallView, Throwable>>, Object> {
        final /* synthetic */ MutableSharedFlow<PaywallState> $publisher;
        final /* synthetic */ PresentationRequest $request;
        final /* synthetic */ Superwall $this_getPaywallSync;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass3(Superwall superwall, PresentationRequest presentationRequest, MutableSharedFlow<PaywallState> mutableSharedFlow, Continuation<? super AnonymousClass3> continuation) {
            super(2, continuation);
            this.$this_getPaywallSync = superwall;
            this.$request = presentationRequest;
            this.$publisher = mutableSharedFlow;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass3(this.$this_getPaywallSync, this.$request, this.$publisher, continuation);
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
            Superwall superwall = this.$this_getPaywallSync;
            PresentationRequest presentationRequest = this.$request;
            MutableSharedFlow<PaywallState> mutableSharedFlow = this.$publisher;
            this.label = 1;
            Object paywall = InternalGetPaywallKt.getPaywall(superwall, presentationRequest, mutableSharedFlow, this);
            return paywall == objF ? objF : paywall;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Either<PaywallView, Throwable>> continuation) {
            return ((AnonymousClass3) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Object getPaywall(com.superwall.sdk.Superwall r5, com.superwall.sdk.paywall.presentation.internal.PresentationRequest r6, kotlinx.coroutines.flow.MutableSharedFlow<com.superwall.sdk.paywall.presentation.internal.state.PaywallState> r7, kotlin.coroutines.Continuation<? super com.superwall.sdk.misc.Either<com.superwall.sdk.paywall.view.PaywallView, java.lang.Throwable>> r8) throws java.lang.Throwable {
        /*
            boolean r0 = r8 instanceof com.superwall.sdk.paywall.presentation.get_paywall.InternalGetPaywallKt.AnonymousClass1
            if (r0 == 0) goto L13
            r0 = r8
            com.superwall.sdk.paywall.presentation.get_paywall.InternalGetPaywallKt$getPaywall$1 r0 = (com.superwall.sdk.paywall.presentation.get_paywall.InternalGetPaywallKt.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.superwall.sdk.paywall.presentation.get_paywall.InternalGetPaywallKt$getPaywall$1 r0 = new com.superwall.sdk.paywall.presentation.get_paywall.InternalGetPaywallKt$getPaywall$1
            r0.<init>(r8)
        L18:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L50
            if (r2 == r4) goto L38
            if (r2 != r3) goto L30
            java.lang.Object r5 = r0.L$0
            java.lang.Throwable r5 = (java.lang.Throwable) r5
            kotlin.ResultKt.b(r8)
            goto L98
        L30:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L38:
            java.lang.Object r5 = r0.L$2
            r7 = r5
            kotlinx.coroutines.flow.MutableSharedFlow r7 = (kotlinx.coroutines.flow.MutableSharedFlow) r7
            java.lang.Object r5 = r0.L$1
            r6 = r5
            com.superwall.sdk.paywall.presentation.internal.PresentationRequest r6 = (com.superwall.sdk.paywall.presentation.internal.PresentationRequest) r6
            java.lang.Object r5 = r0.L$0
            com.superwall.sdk.Superwall r5 = (com.superwall.sdk.Superwall) r5
            kotlin.ResultKt.b(r8)
            kotlin.Result r8 = (kotlin.Result) r8
            java.lang.Object r8 = r8.j()
            goto L62
        L50:
            kotlin.ResultKt.b(r8)
            r0.L$0 = r5
            r0.L$1 = r6
            r0.L$2 = r7
            r0.label = r4
            java.lang.Object r8 = com.superwall.sdk.paywall.presentation.internal.GetPaywallComponentsKt.getPaywallComponents(r5, r6, r7, r0)
            if (r8 != r1) goto L62
            goto L96
        L62:
            java.lang.Throwable r2 = kotlin.Result.e(r8)
            if (r2 != 0) goto L87
            com.superwall.sdk.paywall.presentation.get_paywall.PaywallComponents r8 = (com.superwall.sdk.paywall.presentation.get_paywall.PaywallComponents) r8
            com.superwall.sdk.paywall.view.PaywallView r5 = r8.getView()
            com.superwall.sdk.paywall.presentation.rule_logic.RuleEvaluationOutcome r0 = r8.getRulesOutcome()
            com.superwall.sdk.models.triggers.TriggerRuleOccurrence r0 = r0.getUnsavedOccurrence()
            com.superwall.sdk.models.triggers.Experiment r1 = r8.getExperiment()
            r5.set$superwall_release(r6, r7, r0, r1)
            com.superwall.sdk.misc.Either$Success r5 = new com.superwall.sdk.misc.Either$Success
            com.superwall.sdk.paywall.view.PaywallView r6 = r8.getView()
            r5.<init>(r6)
            return r5
        L87:
            r0.L$0 = r2
            r7 = 0
            r0.L$1 = r7
            r0.L$2 = r7
            r0.label = r3
            java.lang.Object r5 = com.superwall.sdk.paywall.presentation.internal.operators.LogErrorsKt.logErrors(r5, r6, r2, r0)
            if (r5 != r1) goto L97
        L96:
            return r1
        L97:
            r5 = r2
        L98:
            com.superwall.sdk.misc.Either$Failure r6 = new com.superwall.sdk.misc.Either$Failure
            r6.<init>(r5)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.superwall.sdk.paywall.presentation.get_paywall.InternalGetPaywallKt.getPaywall(com.superwall.sdk.Superwall, com.superwall.sdk.paywall.presentation.internal.PresentationRequest, kotlinx.coroutines.flow.MutableSharedFlow, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static /* synthetic */ Object getPaywall$default(Superwall superwall, PresentationRequest presentationRequest, MutableSharedFlow mutableSharedFlow, Continuation continuation, int i3, Object obj) throws Throwable {
        if ((i3 & 2) != 0) {
            mutableSharedFlow = SharedFlowKt.b(0, 0, null, 7, null);
        }
        return getPaywall(superwall, presentationRequest, mutableSharedFlow, continuation);
    }

    public static final Either<PaywallView, Throwable> getPaywallSync(Superwall superwall, PresentationRequest request, Function1<? super PaywallState, Unit> onStateChanged) {
        Intrinsics.checkNotNullParameter(superwall, "<this>");
        Intrinsics.checkNotNullParameter(request, "request");
        Intrinsics.checkNotNullParameter(onStateChanged, "onStateChanged");
        IOScope ioScope$superwall_release = Superwall.Companion.getInstance().getIoScope$superwall_release();
        MutableSharedFlow mutableSharedFlowB = SharedFlowKt.b(0, 0, null, 7, null);
        BuildersKt__Builders_commonKt.d(ioScope$superwall_release, null, null, new AnonymousClass2(mutableSharedFlowB, onStateChanged, null), 3, null);
        return (Either) BuildersKt__BuildersKt.b(null, new AnonymousClass3(superwall, request, mutableSharedFlowB, null), 1, null);
    }

    public static /* synthetic */ Either getPaywallSync$default(Superwall superwall, PresentationRequest presentationRequest, Function1 function1, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            function1 = new Function1() { // from class: com.superwall.sdk.paywall.presentation.get_paywall.a
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj2) {
                    return InternalGetPaywallKt.getPaywallSync$lambda$2((PaywallState) obj2);
                }
            };
        }
        return getPaywallSync(superwall, presentationRequest, function1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit getPaywallSync$lambda$2(PaywallState it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.f139807a;
    }
}
