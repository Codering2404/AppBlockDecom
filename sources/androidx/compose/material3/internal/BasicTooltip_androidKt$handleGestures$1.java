package androidx.compose.material3.internal;

import androidx.compose.foundation.gestures.ForEachGestureKt;
import androidx.compose.foundation.gestures.TapGestureDetectorKt;
import androidx.compose.material3.TooltipState;
import androidx.compose.ui.input.pointer.AwaitPointerEventScope;
import androidx.compose.ui.input.pointer.PointerEventPass;
import androidx.compose.ui.input.pointer.PointerInputChange;
import androidx.compose.ui.input.pointer.PointerInputScope;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.flow.MutableStateFlow;

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
/* JADX INFO: loaded from: classes.dex */
@Metadata
@DebugMetadata(c = "androidx.compose.material3.internal.BasicTooltip_androidKt$handleGestures$1", f = "BasicTooltip.android.kt", l = {162}, m = "invokeSuspend")
final class BasicTooltip_androidKt$handleGestures$1 extends SuspendLambda implements Function2<PointerInputScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f21944a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private /* synthetic */ Object f21945b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ TooltipState f21946c;

    /* JADX INFO: renamed from: androidx.compose.material3.internal.BasicTooltip_androidKt$handleGestures$1$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "androidx.compose.material3.internal.BasicTooltip_androidKt$handleGestures$1$1", f = "BasicTooltip.android.kt", l = {163}, m = "invokeSuspend")
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f21947a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private /* synthetic */ Object f21948b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ PointerInputScope f21949c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ TooltipState f21950d;

        /* JADX INFO: renamed from: androidx.compose.material3.internal.BasicTooltip_androidKt$handleGestures$1$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        @DebugMetadata(c = "androidx.compose.material3.internal.BasicTooltip_androidKt$handleGestures$1$1$1", f = "BasicTooltip.android.kt", l = {171, 177, 197}, m = "invokeSuspend")
        static final class C00661 extends RestrictedSuspendLambda implements Function2<AwaitPointerEventScope, Continuation<? super Unit>, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            Object f21951a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            Object f21952b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            long f21953c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            int f21954d;

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            private /* synthetic */ Object f21955f;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            final /* synthetic */ CoroutineScope f21956g;

            /* JADX INFO: renamed from: h, reason: collision with root package name */
            final /* synthetic */ TooltipState f21957h;

            /* JADX INFO: renamed from: androidx.compose.material3.internal.BasicTooltip_androidKt$handleGestures$1$1$1$1, reason: invalid class name and collision with other inner class name */
            /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
            @Metadata
            @DebugMetadata(c = "androidx.compose.material3.internal.BasicTooltip_androidKt$handleGestures$1$1$1$1", f = "BasicTooltip.android.kt", l = {178}, m = "invokeSuspend")
            static final class C00671 extends RestrictedSuspendLambda implements Function2<AwaitPointerEventScope, Continuation<? super PointerInputChange>, Object> {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                int f21958a;

                /* JADX INFO: renamed from: b, reason: collision with root package name */
                private /* synthetic */ Object f21959b;

                /* JADX INFO: renamed from: c, reason: collision with root package name */
                final /* synthetic */ PointerEventPass f21960c;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                C00671(PointerEventPass pointerEventPass, Continuation continuation) {
                    super(2, continuation);
                    this.f21960c = pointerEventPass;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation create(Object obj, Continuation continuation) {
                    C00671 c00671 = new C00671(this.f21960c, continuation);
                    c00671.f21959b = obj;
                    return c00671;
                }

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(AwaitPointerEventScope awaitPointerEventScope, Continuation continuation) {
                    return ((C00671) create(awaitPointerEventScope, continuation)).invokeSuspend(Unit.f139807a);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object obj) throws Throwable {
                    Object objF = IntrinsicsKt.f();
                    int i3 = this.f21958a;
                    if (i3 != 0) {
                        if (i3 != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.b(obj);
                        return obj;
                    }
                    ResultKt.b(obj);
                    AwaitPointerEventScope awaitPointerEventScope = (AwaitPointerEventScope) this.f21959b;
                    PointerEventPass pointerEventPass = this.f21960c;
                    this.f21958a = 1;
                    Object objU = TapGestureDetectorKt.u(awaitPointerEventScope, pointerEventPass, this);
                    return objU == objF ? objF : objU;
                }
            }

            /* JADX INFO: renamed from: androidx.compose.material3.internal.BasicTooltip_androidKt$handleGestures$1$1$1$2, reason: invalid class name */
            /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
            @Metadata
            @DebugMetadata(c = "androidx.compose.material3.internal.BasicTooltip_androidKt$handleGestures$1$1$1$2", f = "BasicTooltip.android.kt", l = {185, 187, 187}, m = "invokeSuspend")
            static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                Object f21961a;

                /* JADX INFO: renamed from: b, reason: collision with root package name */
                int f21962b;

                /* JADX INFO: renamed from: c, reason: collision with root package name */
                final /* synthetic */ MutableStateFlow f21963c;

                /* JADX INFO: renamed from: d, reason: collision with root package name */
                final /* synthetic */ TooltipState f21964d;

                /* JADX INFO: renamed from: androidx.compose.material3.internal.BasicTooltip_androidKt$handleGestures$1$1$1$2$1, reason: invalid class name and collision with other inner class name */
                /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
                @Metadata
                @DebugMetadata(c = "androidx.compose.material3.internal.BasicTooltip_androidKt$handleGestures$1$1$1$2$1", f = "BasicTooltip.android.kt", l = {}, m = "invokeSuspend")
                static final class C00681 extends SuspendLambda implements Function2<Boolean, Continuation<? super Unit>, Object> {

                    /* JADX INFO: renamed from: a, reason: collision with root package name */
                    int f21965a;

                    /* JADX INFO: renamed from: b, reason: collision with root package name */
                    /* synthetic */ boolean f21966b;

                    /* JADX INFO: renamed from: c, reason: collision with root package name */
                    final /* synthetic */ TooltipState f21967c;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    C00681(TooltipState tooltipState, Continuation continuation) {
                        super(2, continuation);
                        this.f21967c = tooltipState;
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Continuation create(Object obj, Continuation continuation) {
                        C00681 c00681 = new C00681(this.f21967c, continuation);
                        c00681.f21966b = ((Boolean) obj).booleanValue();
                        return c00681;
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                        return invoke(((Boolean) obj).booleanValue(), (Continuation) obj2);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) throws Throwable {
                        IntrinsicsKt.f();
                        if (this.f21965a != 0) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.b(obj);
                        if (!this.f21966b) {
                            this.f21967c.dismiss();
                        }
                        return Unit.f139807a;
                    }

                    public final Object invoke(boolean z2, Continuation continuation) {
                        return ((C00681) create(Boolean.valueOf(z2), continuation)).invokeSuspend(Unit.f139807a);
                    }
                }

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                AnonymousClass2(MutableStateFlow mutableStateFlow, TooltipState tooltipState, Continuation continuation) {
                    super(2, continuation);
                    this.f21963c = mutableStateFlow;
                    this.f21964d = tooltipState;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation create(Object obj, Continuation continuation) {
                    return new AnonymousClass2(this.f21963c, this.f21964d, continuation);
                }

                /* JADX WARN: Code restructure failed: missing block: B:20:0x0054, code lost:
                
                    if (kotlinx.coroutines.flow.FlowKt.l(r7, r1, r6) == r0) goto L26;
                 */
                /* JADX WARN: Multi-variable type inference failed */
                /* JADX WARN: Type inference failed for: r3v0 */
                /* JADX WARN: Type inference failed for: r3v2, types: [androidx.compose.material3.TooltipState] */
                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public final java.lang.Object invokeSuspend(java.lang.Object r7) throws java.lang.Throwable {
                    /*
                        r6 = this;
                        java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
                        int r1 = r6.f21962b
                        r2 = 0
                        r3 = 3
                        r4 = 2
                        r5 = 1
                        if (r1 == 0) goto L2c
                        if (r1 == r5) goto L26
                        if (r1 == r4) goto L22
                        if (r1 == r3) goto L1a
                        java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
                        java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                        r7.<init>(r0)
                        throw r7
                    L1a:
                        java.lang.Object r0 = r6.f21961a
                        java.lang.Throwable r0 = (java.lang.Throwable) r0
                        kotlin.ResultKt.b(r7)
                        goto L6f
                    L22:
                        kotlin.ResultKt.b(r7)
                        goto L57
                    L26:
                        kotlin.ResultKt.b(r7)     // Catch: java.lang.Throwable -> L2a
                        goto L45
                    L2a:
                        r7 = move-exception
                        goto L5a
                    L2c:
                        kotlin.ResultKt.b(r7)
                        kotlinx.coroutines.flow.MutableStateFlow r7 = r6.f21963c     // Catch: java.lang.Throwable -> L2a
                        java.lang.Boolean r1 = kotlin.coroutines.jvm.internal.Boxing.a(r5)     // Catch: java.lang.Throwable -> L2a
                        r7.c(r1)     // Catch: java.lang.Throwable -> L2a
                        androidx.compose.material3.TooltipState r7 = r6.f21964d     // Catch: java.lang.Throwable -> L2a
                        androidx.compose.foundation.MutatePriority r1 = androidx.compose.foundation.MutatePriority.f5073c     // Catch: java.lang.Throwable -> L2a
                        r6.f21962b = r5     // Catch: java.lang.Throwable -> L2a
                        java.lang.Object r7 = r7.c(r1, r6)     // Catch: java.lang.Throwable -> L2a
                        if (r7 != r0) goto L45
                        goto L6d
                    L45:
                        kotlinx.coroutines.flow.MutableStateFlow r7 = r6.f21963c
                        androidx.compose.material3.internal.BasicTooltip_androidKt$handleGestures$1$1$1$2$1 r1 = new androidx.compose.material3.internal.BasicTooltip_androidKt$handleGestures$1$1$1$2$1
                        androidx.compose.material3.TooltipState r3 = r6.f21964d
                        r1.<init>(r3, r2)
                        r6.f21962b = r4
                        java.lang.Object r7 = kotlinx.coroutines.flow.FlowKt.l(r7, r1, r6)
                        if (r7 != r0) goto L57
                        goto L6d
                    L57:
                        kotlin.Unit r7 = kotlin.Unit.f139807a
                        return r7
                    L5a:
                        kotlinx.coroutines.flow.MutableStateFlow r1 = r6.f21963c
                        androidx.compose.material3.internal.BasicTooltip_androidKt$handleGestures$1$1$1$2$1 r4 = new androidx.compose.material3.internal.BasicTooltip_androidKt$handleGestures$1$1$1$2$1
                        androidx.compose.material3.TooltipState r5 = r6.f21964d
                        r4.<init>(r5, r2)
                        r6.f21961a = r7
                        r6.f21962b = r3
                        java.lang.Object r1 = kotlinx.coroutines.flow.FlowKt.l(r1, r4, r6)
                        if (r1 != r0) goto L6e
                    L6d:
                        return r0
                    L6e:
                        r0 = r7
                    L6f:
                        throw r0
                    */
                    throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.internal.BasicTooltip_androidKt$handleGestures$1.AnonymousClass1.C00661.AnonymousClass2.invokeSuspend(java.lang.Object):java.lang.Object");
                }

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
                    return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C00661(CoroutineScope coroutineScope, TooltipState tooltipState, Continuation continuation) {
                super(2, continuation);
                this.f21956g = coroutineScope;
                this.f21957h = tooltipState;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation create(Object obj, Continuation continuation) {
                C00661 c00661 = new C00661(this.f21956g, this.f21957h, continuation);
                c00661.f21955f = obj;
                return c00661;
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(AwaitPointerEventScope awaitPointerEventScope, Continuation continuation) {
                return ((C00661) create(awaitPointerEventScope, continuation)).invokeSuspend(Unit.f139807a);
            }

            /* JADX WARN: Code restructure failed: missing block: B:35:0x00e0, code lost:
            
                if (r0 == r6) goto L36;
             */
            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r1v0 */
            /* JADX WARN: Type inference failed for: r1v1, types: [kotlinx.coroutines.flow.MutableSharedFlow] */
            /* JADX WARN: Type inference failed for: r1v7 */
            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public final java.lang.Object invokeSuspend(java.lang.Object r18) throws java.lang.Throwable {
                /*
                    Method dump skipped, instruction units count: 246
                    To view this dump change 'Code comments level' option to 'DEBUG'
                */
                throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.internal.BasicTooltip_androidKt$handleGestures$1.AnonymousClass1.C00661.invokeSuspend(java.lang.Object):java.lang.Object");
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(PointerInputScope pointerInputScope, TooltipState tooltipState, Continuation continuation) {
            super(2, continuation);
            this.f21949c = pointerInputScope;
            this.f21950d = tooltipState;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.f21949c, this.f21950d, continuation);
            anonymousClass1.f21948b = obj;
            return anonymousClass1;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objF = IntrinsicsKt.f();
            int i3 = this.f21947a;
            if (i3 == 0) {
                ResultKt.b(obj);
                CoroutineScope coroutineScope = (CoroutineScope) this.f21948b;
                PointerInputScope pointerInputScope = this.f21949c;
                C00661 c00661 = new C00661(coroutineScope, this.f21950d, null);
                this.f21947a = 1;
                if (ForEachGestureKt.e(pointerInputScope, c00661, this) == objF) {
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
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    BasicTooltip_androidKt$handleGestures$1(TooltipState tooltipState, Continuation continuation) {
        super(2, continuation);
        this.f21946c = tooltipState;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        BasicTooltip_androidKt$handleGestures$1 basicTooltip_androidKt$handleGestures$1 = new BasicTooltip_androidKt$handleGestures$1(this.f21946c, continuation);
        basicTooltip_androidKt$handleGestures$1.f21945b = obj;
        return basicTooltip_androidKt$handleGestures$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(PointerInputScope pointerInputScope, Continuation continuation) {
        return ((BasicTooltip_androidKt$handleGestures$1) create(pointerInputScope, continuation)).invokeSuspend(Unit.f139807a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objF = IntrinsicsKt.f();
        int i3 = this.f21944a;
        if (i3 == 0) {
            ResultKt.b(obj);
            AnonymousClass1 anonymousClass1 = new AnonymousClass1((PointerInputScope) this.f21945b, this.f21946c, null);
            this.f21944a = 1;
            if (CoroutineScopeKt.f(anonymousClass1, this) == objF) {
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
