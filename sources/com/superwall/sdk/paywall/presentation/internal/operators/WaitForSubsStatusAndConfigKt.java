package com.superwall.sdk.paywall.presentation.internal.operators;

import com.superwall.sdk.analytics.internal.trackable.InternalSuperwallEvent;
import com.superwall.sdk.config.models.ConfigState;
import com.superwall.sdk.dependencies.DependencyContainer;
import com.superwall.sdk.paywall.presentation.internal.PaywallPresentationRequestStatus;
import com.superwall.sdk.paywall.presentation.internal.PaywallPresentationRequestStatusReason;
import com.superwall.sdk.paywall.presentation.internal.PresentationRequest;
import com.superwall.sdk.paywall.presentation.internal.state.PaywallState;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.StateFlow;

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
public final class WaitForSubsStatusAndConfigKt {

    /* JADX INFO: renamed from: com.superwall.sdk.paywall.presentation.internal.operators.WaitForSubsStatusAndConfigKt$configOrThrow$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "com.superwall.sdk.paywall.presentation.internal.operators.WaitForSubsStatusAndConfigKt", f = "WaitForSubsStatusAndConfig.kt", l = {38, 45}, m = "configOrThrow")
    static final class AnonymousClass1 extends ContinuationImpl {
        int I$0;
        Object L$0;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return WaitForSubsStatusAndConfigKt.configOrThrow(null, 0, this);
        }
    }

    /* JADX INFO: renamed from: com.superwall.sdk.paywall.presentation.internal.operators.WaitForSubsStatusAndConfigKt$configOrThrow$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "com.superwall.sdk.paywall.presentation.internal.operators.WaitForSubsStatusAndConfigKt$configOrThrow$2", f = "WaitForSubsStatusAndConfig.kt", l = {39}, m = "invokeSuspend")
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super ConfigState>, Object> {
        final /* synthetic */ StateFlow<ConfigState> $this_configOrThrow;
        int label;

        /* JADX INFO: renamed from: com.superwall.sdk.paywall.presentation.internal.operators.WaitForSubsStatusAndConfigKt$configOrThrow$2$1, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        @DebugMetadata(c = "com.superwall.sdk.paywall.presentation.internal.operators.WaitForSubsStatusAndConfigKt$configOrThrow$2$1", f = "WaitForSubsStatusAndConfig.kt", l = {}, m = "invokeSuspend")
        static final class AnonymousClass1 extends SuspendLambda implements Function2<ConfigState, Continuation<? super Boolean>, Object> {
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
            public final Object invoke(ConfigState configState, Continuation<? super Boolean> continuation) {
                return ((AnonymousClass1) create(configState, continuation)).invokeSuspend(Unit.f139807a);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) throws Throwable {
                IntrinsicsKt.f();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.b(obj);
                ConfigState configState = (ConfigState) this.L$0;
                if (configState instanceof ConfigState.Failed) {
                    throw ((ConfigState.Failed) configState).getThrowable();
                }
                return Boxing.a(configState instanceof ConfigState.Retrieved);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass2(StateFlow<? extends ConfigState> stateFlow, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.$this_configOrThrow = stateFlow;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass2(this.$this_configOrThrow, continuation);
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
            StateFlow<ConfigState> stateFlow = this.$this_configOrThrow;
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(null);
            this.label = 1;
            Object objE = FlowKt.E(stateFlow, anonymousClass1, this);
            return objE == objF ? objF : objE;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super ConfigState> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX INFO: renamed from: com.superwall.sdk.paywall.presentation.internal.operators.WaitForSubsStatusAndConfigKt$waitForEntitlementsAndConfig$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "com.superwall.sdk.paywall.presentation.internal.operators.WaitForSubsStatusAndConfigKt", f = "WaitForSubsStatusAndConfig.kt", l = {71, 183}, m = "waitForEntitlementsAndConfig")
    static final class C28481 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C28481(Continuation<? super C28481> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return WaitForSubsStatusAndConfigKt.waitForEntitlementsAndConfig(null, null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.superwall.sdk.paywall.presentation.internal.operators.WaitForSubsStatusAndConfigKt$waitForEntitlementsAndConfig$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "com.superwall.sdk.paywall.presentation.internal.operators.WaitForSubsStatusAndConfigKt$waitForEntitlementsAndConfig$2", f = "WaitForSubsStatusAndConfig.kt", l = {88, 117, 127, 129, 163}, m = "invokeSuspend")
    static final class C28492 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ StateFlow<ConfigState> $configState;
        final /* synthetic */ DependencyContainer $dependencyContainer;
        final /* synthetic */ MutableSharedFlow<PaywallState> $paywallStatePublisher;
        final /* synthetic */ PresentationRequest $request;
        final /* synthetic */ int $retries;
        private /* synthetic */ Object L$0;
        Object L$1;
        int label;

        /* JADX INFO: renamed from: com.superwall.sdk.paywall.presentation.internal.operators.WaitForSubsStatusAndConfigKt$waitForEntitlementsAndConfig$2$2, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        @DebugMetadata(c = "com.superwall.sdk.paywall.presentation.internal.operators.WaitForSubsStatusAndConfigKt$waitForEntitlementsAndConfig$2$2", f = "WaitForSubsStatusAndConfig.kt", l = {149}, m = "invokeSuspend")
        static final class C02432 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ DependencyContainer $dependencyContainer;
            final /* synthetic */ PresentationRequest $request;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C02432(PresentationRequest presentationRequest, DependencyContainer dependencyContainer, Continuation<? super C02432> continuation) {
                super(2, continuation);
                this.$request = presentationRequest;
                this.$dependencyContainer = dependencyContainer;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new C02432(this.$request, this.$dependencyContainer, continuation);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) throws Throwable {
                Object objF = IntrinsicsKt.f();
                int i3 = this.label;
                if (i3 == 0) {
                    ResultKt.b(obj);
                    InternalSuperwallEvent.PresentationRequest presentationRequest = new InternalSuperwallEvent.PresentationRequest(this.$request.getPresentationInfo().getEventData(), this.$request.getFlags().getType(), PaywallPresentationRequestStatus.Timeout.INSTANCE, new PaywallPresentationRequestStatusReason.NoConfig(), this.$dependencyContainer, null, 32, null);
                    DependencyContainer dependencyContainer = this.$dependencyContainer;
                    this.label = 1;
                    if (dependencyContainer.mo1271trackgIAlus(presentationRequest, this) == objF) {
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

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((C02432) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        C28492(DependencyContainer dependencyContainer, MutableSharedFlow<PaywallState> mutableSharedFlow, PresentationRequest presentationRequest, StateFlow<? extends ConfigState> stateFlow, int i3, Continuation<? super C28492> continuation) {
            super(2, continuation);
            this.$dependencyContainer = dependencyContainer;
            this.$paywallStatePublisher = mutableSharedFlow;
            this.$request = presentationRequest;
            this.$configState = stateFlow;
            this.$retries = i3;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C28492 c28492 = new C28492(this.$dependencyContainer, this.$paywallStatePublisher, this.$request, this.$configState, this.$retries, continuation);
            c28492.L$0 = obj;
            return c28492;
        }

        /* JADX WARN: Code restructure failed: missing block: B:29:0x00e3, code lost:
        
            if (r13.emit(r3, r29) == r2) goto L61;
         */
        /* JADX WARN: Code restructure failed: missing block: B:60:0x019a, code lost:
        
            if (r5.emit(r6, r29) == r2) goto L61;
         */
        /* JADX WARN: Removed duplicated region for block: B:39:0x0108  */
        /* JADX WARN: Removed duplicated region for block: B:48:0x0132  */
        /* JADX WARN: Removed duplicated region for block: B:50:0x0135  */
        /* JADX WARN: Removed duplicated region for block: B:64:0x01a3  */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r30) throws java.lang.Throwable {
            /*
                Method dump skipped, instruction units count: 422
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.superwall.sdk.paywall.presentation.internal.operators.WaitForSubsStatusAndConfigKt.C28492.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C28492) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x0067, code lost:
    
        if (kotlinx.coroutines.TimeoutKt.d(r6, r10, r0) == r1) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0075, code lost:
    
        if (configOrThrow(r8, r9 - 1, r0) == r1) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0077, code lost:
    
        return r1;
     */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Object configOrThrow(kotlinx.coroutines.flow.StateFlow<? extends com.superwall.sdk.config.models.ConfigState> r8, int r9, kotlin.coroutines.Continuation<? super kotlin.Unit> r10) throws java.lang.Throwable {
        /*
            boolean r0 = r10 instanceof com.superwall.sdk.paywall.presentation.internal.operators.WaitForSubsStatusAndConfigKt.AnonymousClass1
            if (r0 == 0) goto L13
            r0 = r10
            com.superwall.sdk.paywall.presentation.internal.operators.WaitForSubsStatusAndConfigKt$configOrThrow$1 r0 = (com.superwall.sdk.paywall.presentation.internal.operators.WaitForSubsStatusAndConfigKt.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.superwall.sdk.paywall.presentation.internal.operators.WaitForSubsStatusAndConfigKt$configOrThrow$1 r0 = new com.superwall.sdk.paywall.presentation.internal.operators.WaitForSubsStatusAndConfigKt$configOrThrow$1
            r0.<init>(r10)
        L18:
            java.lang.Object r10 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.label
            r3 = 0
            r4 = 2
            r5 = 1
            if (r2 == 0) goto L41
            if (r2 == r5) goto L35
            if (r2 != r4) goto L2d
            kotlin.ResultKt.b(r10)
            goto L78
        L2d:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L35:
            int r9 = r0.I$0
            java.lang.Object r8 = r0.L$0
            kotlinx.coroutines.flow.StateFlow r8 = (kotlinx.coroutines.flow.StateFlow) r8
            kotlin.ResultKt.b(r10)     // Catch: kotlinx.coroutines.TimeoutCancellationException -> L3f
            goto L78
        L3f:
            r10 = move-exception
            goto L6a
        L41:
            kotlin.ResultKt.b(r10)
            if (r9 <= 0) goto L4f
            kotlin.time.Duration$Companion r10 = kotlin.time.Duration.f140631b     // Catch: kotlinx.coroutines.TimeoutCancellationException -> L3f
            kotlin.time.DurationUnit r10 = kotlin.time.DurationUnit.f140641f     // Catch: kotlinx.coroutines.TimeoutCancellationException -> L3f
            long r6 = kotlin.time.DurationKt.s(r5, r10)     // Catch: kotlinx.coroutines.TimeoutCancellationException -> L3f
            goto L58
        L4f:
            kotlin.time.Duration$Companion r10 = kotlin.time.Duration.f140631b     // Catch: kotlinx.coroutines.TimeoutCancellationException -> L3f
            kotlin.time.DurationUnit r10 = kotlin.time.DurationUnit.f140641f     // Catch: kotlinx.coroutines.TimeoutCancellationException -> L3f
            r2 = 5
            long r6 = kotlin.time.DurationKt.s(r2, r10)     // Catch: kotlinx.coroutines.TimeoutCancellationException -> L3f
        L58:
            com.superwall.sdk.paywall.presentation.internal.operators.WaitForSubsStatusAndConfigKt$configOrThrow$2 r10 = new com.superwall.sdk.paywall.presentation.internal.operators.WaitForSubsStatusAndConfigKt$configOrThrow$2     // Catch: kotlinx.coroutines.TimeoutCancellationException -> L3f
            r10.<init>(r8, r3)     // Catch: kotlinx.coroutines.TimeoutCancellationException -> L3f
            r0.L$0 = r8     // Catch: kotlinx.coroutines.TimeoutCancellationException -> L3f
            r0.I$0 = r9     // Catch: kotlinx.coroutines.TimeoutCancellationException -> L3f
            r0.label = r5     // Catch: kotlinx.coroutines.TimeoutCancellationException -> L3f
            java.lang.Object r8 = kotlinx.coroutines.TimeoutKt.d(r6, r10, r0)     // Catch: kotlinx.coroutines.TimeoutCancellationException -> L3f
            if (r8 != r1) goto L78
            goto L77
        L6a:
            if (r9 <= 0) goto L7b
            int r9 = r9 - r5
            r0.L$0 = r3
            r0.label = r4
            java.lang.Object r8 = configOrThrow(r8, r9, r0)
            if (r8 != r1) goto L78
        L77:
            return r1
        L78:
            kotlin.Unit r8 = kotlin.Unit.f139807a
            return r8
        L7b:
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.superwall.sdk.paywall.presentation.internal.operators.WaitForSubsStatusAndConfigKt.configOrThrow(kotlinx.coroutines.flow.StateFlow, int, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static /* synthetic */ Object configOrThrow$default(StateFlow stateFlow, int i3, Continuation continuation, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i3 = 1;
        }
        return configOrThrow(stateFlow, i3, continuation);
    }

    /* JADX WARN: Code restructure failed: missing block: B:33:0x009d, code lost:
    
        if (r15 == r1) goto L34;
     */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Object waitForEntitlementsAndConfig(com.superwall.sdk.paywall.presentation.internal.PresentationRequest r12, kotlinx.coroutines.flow.MutableSharedFlow<com.superwall.sdk.paywall.presentation.internal.state.PaywallState> r13, com.superwall.sdk.dependencies.DependencyContainer r14, kotlin.coroutines.Continuation<? super kotlin.Unit> r15) throws java.lang.Throwable {
        /*
            boolean r0 = r15 instanceof com.superwall.sdk.paywall.presentation.internal.operators.WaitForSubsStatusAndConfigKt.C28481
            if (r0 == 0) goto L13
            r0 = r15
            com.superwall.sdk.paywall.presentation.internal.operators.WaitForSubsStatusAndConfigKt$waitForEntitlementsAndConfig$1 r0 = (com.superwall.sdk.paywall.presentation.internal.operators.WaitForSubsStatusAndConfigKt.C28481) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.superwall.sdk.paywall.presentation.internal.operators.WaitForSubsStatusAndConfigKt$waitForEntitlementsAndConfig$1 r0 = new com.superwall.sdk.paywall.presentation.internal.operators.WaitForSubsStatusAndConfigKt$waitForEntitlementsAndConfig$1
            r0.<init>(r15)
        L18:
            java.lang.Object r15 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L3d
            if (r2 == r4) goto L35
            if (r2 != r3) goto L2d
            kotlin.ResultKt.b(r15)
            goto La0
        L2d:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            java.lang.String r13 = "call to 'resume' before 'invoke' with coroutine"
            r12.<init>(r13)
            throw r12
        L35:
            java.lang.Object r12 = r0.L$0
            com.superwall.sdk.dependencies.DependencyContainer r12 = (com.superwall.sdk.dependencies.DependencyContainer) r12
            kotlin.ResultKt.b(r15)
            goto L86
        L3d:
            kotlin.ResultKt.b(r15)
            if (r14 != 0) goto L4c
            com.superwall.sdk.Superwall$Companion r14 = com.superwall.sdk.Superwall.Companion
            com.superwall.sdk.Superwall r14 = r14.getInstance()
            com.superwall.sdk.dependencies.DependencyContainer r14 = r14.getDependencyContainer$superwall_release()
        L4c:
            r6 = r14
            com.superwall.sdk.config.ConfigManager r14 = r6.getConfigManager()
            kotlinx.coroutines.flow.StateFlow r9 = r14.getConfigState$superwall_release()
            java.lang.Object r14 = r9.getValue()
            boolean r14 = r14 instanceof com.superwall.sdk.config.models.ConfigState.Retrieving
            if (r14 != 0) goto L71
            java.lang.Object r14 = r9.getValue()
            boolean r14 = r14 instanceof com.superwall.sdk.config.models.ConfigState.Retrying
            if (r14 != 0) goto L71
            java.lang.Object r14 = r9.getValue()
            boolean r14 = r14 instanceof com.superwall.sdk.config.models.ConfigState.None
            if (r14 == 0) goto L6e
            goto L71
        L6e:
            r14 = 0
            r10 = r14
            goto L72
        L71:
            r10 = r4
        L72:
            com.superwall.sdk.paywall.presentation.internal.operators.WaitForSubsStatusAndConfigKt$waitForEntitlementsAndConfig$2 r5 = new com.superwall.sdk.paywall.presentation.internal.operators.WaitForSubsStatusAndConfigKt$waitForEntitlementsAndConfig$2
            r11 = 0
            r8 = r12
            r7 = r13
            r5.<init>(r6, r7, r8, r9, r10, r11)
            r0.L$0 = r6
            r0.label = r4
            java.lang.Object r12 = kotlinx.coroutines.CoroutineScopeKt.f(r5, r0)
            if (r12 != r1) goto L85
            goto L9f
        L85:
            r12 = r6
        L86:
            kotlin.time.Duration$Companion r13 = kotlin.time.Duration.f140631b
            r13 = 5
            kotlin.time.DurationUnit r14 = kotlin.time.DurationUnit.f140641f
            long r13 = kotlin.time.DurationKt.s(r13, r14)
            com.superwall.sdk.paywall.presentation.internal.operators.WaitForSubsStatusAndConfigKt$waitForEntitlementsAndConfig$identityResolved$1 r15 = new com.superwall.sdk.paywall.presentation.internal.operators.WaitForSubsStatusAndConfigKt$waitForEntitlementsAndConfig$identityResolved$1
            r2 = 0
            r15.<init>(r12, r2)
            r0.L$0 = r2
            r0.label = r3
            java.lang.Object r15 = kotlinx.coroutines.TimeoutKt.f(r13, r15, r0)
            if (r15 != r1) goto La0
        L9f:
            return r1
        La0:
            com.superwall.sdk.identity.IdentityState r15 = (com.superwall.sdk.identity.IdentityState) r15
            if (r15 != 0) goto Lb4
            com.superwall.sdk.logger.Logger r0 = com.superwall.sdk.logger.Logger.INSTANCE
            com.superwall.sdk.logger.LogLevel r1 = com.superwall.sdk.logger.LogLevel.warn
            com.superwall.sdk.logger.LogScope r2 = com.superwall.sdk.logger.LogScope.paywallPresentation
            r6 = 24
            r7 = 0
            java.lang.String r3 = "Timeout: identity did not become ready within 5s. Proceeding with current identity state."
            r4 = 0
            r5 = 0
            com.superwall.sdk.logger.Logger.debug$default(r0, r1, r2, r3, r4, r5, r6, r7)
        Lb4:
            kotlin.Unit r12 = kotlin.Unit.f139807a
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.superwall.sdk.paywall.presentation.internal.operators.WaitForSubsStatusAndConfigKt.waitForEntitlementsAndConfig(com.superwall.sdk.paywall.presentation.internal.PresentationRequest, kotlinx.coroutines.flow.MutableSharedFlow, com.superwall.sdk.dependencies.DependencyContainer, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static /* synthetic */ Object waitForEntitlementsAndConfig$default(PresentationRequest presentationRequest, MutableSharedFlow mutableSharedFlow, DependencyContainer dependencyContainer, Continuation continuation, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            mutableSharedFlow = null;
        }
        if ((i3 & 4) != 0) {
            dependencyContainer = null;
        }
        return waitForEntitlementsAndConfig(presentationRequest, mutableSharedFlow, dependencyContainer, continuation);
    }
}
