package androidx.compose.material3.internal;

import androidx.compose.foundation.MutatePriority;
import androidx.compose.material3.TooltipState;
import androidx.compose.ui.input.pointer.AwaitPointerEventScope;
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
@DebugMetadata(c = "androidx.compose.material3.internal.BasicTooltip_androidKt$handleGestures$2", f = "BasicTooltip.android.kt", l = {207}, m = "invokeSuspend")
final class BasicTooltip_androidKt$handleGestures$2 extends SuspendLambda implements Function2<PointerInputScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f21968a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private /* synthetic */ Object f21969b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ TooltipState f21970c;

    /* JADX INFO: renamed from: androidx.compose.material3.internal.BasicTooltip_androidKt$handleGestures$2$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "androidx.compose.material3.internal.BasicTooltip_androidKt$handleGestures$2$1", f = "BasicTooltip.android.kt", l = {208}, m = "invokeSuspend")
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f21971a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private /* synthetic */ Object f21972b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ PointerInputScope f21973c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ TooltipState f21974d;

        /* JADX INFO: renamed from: androidx.compose.material3.internal.BasicTooltip_androidKt$handleGestures$2$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        @DebugMetadata(c = "androidx.compose.material3.internal.BasicTooltip_androidKt$handleGestures$2$1$1", f = "BasicTooltip.android.kt", l = {212}, m = "invokeSuspend")
        static final class C00691 extends RestrictedSuspendLambda implements Function2<AwaitPointerEventScope, Continuation<? super Unit>, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            Object f21975a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            int f21976b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            private /* synthetic */ Object f21977c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            final /* synthetic */ CoroutineScope f21978d;

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            final /* synthetic */ TooltipState f21979f;

            /* JADX INFO: renamed from: androidx.compose.material3.internal.BasicTooltip_androidKt$handleGestures$2$1$1$1, reason: invalid class name and collision with other inner class name */
            /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
            @Metadata
            @DebugMetadata(c = "androidx.compose.material3.internal.BasicTooltip_androidKt$handleGestures$2$1$1$1", f = "BasicTooltip.android.kt", l = {217}, m = "invokeSuspend")
            static final class C00701 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                int f21980a;

                /* JADX INFO: renamed from: b, reason: collision with root package name */
                final /* synthetic */ TooltipState f21981b;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                C00701(TooltipState tooltipState, Continuation continuation) {
                    super(2, continuation);
                    this.f21981b = tooltipState;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation create(Object obj, Continuation continuation) {
                    return new C00701(this.f21981b, continuation);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object obj) throws Throwable {
                    Object objF = IntrinsicsKt.f();
                    int i3 = this.f21980a;
                    if (i3 == 0) {
                        ResultKt.b(obj);
                        TooltipState tooltipState = this.f21981b;
                        MutatePriority mutatePriority = MutatePriority.f5072b;
                        this.f21980a = 1;
                        if (tooltipState.c(mutatePriority, this) == objF) {
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
                    return ((C00701) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C00691(CoroutineScope coroutineScope, TooltipState tooltipState, Continuation continuation) {
                super(2, continuation);
                this.f21978d = coroutineScope;
                this.f21979f = tooltipState;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation create(Object obj, Continuation continuation) {
                C00691 c00691 = new C00691(this.f21978d, this.f21979f, continuation);
                c00691.f21977c = obj;
                return c00691;
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(AwaitPointerEventScope awaitPointerEventScope, Continuation continuation) {
                return ((C00691) create(awaitPointerEventScope, continuation)).invokeSuspend(Unit.f139807a);
            }

            /* JADX WARN: Removed duplicated region for block: B:11:0x0035 A[RETURN] */
            /* JADX WARN: Removed duplicated region for block: B:14:0x0053  */
            /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0033 -> B:12:0x0036). Please report as a decompilation issue!!! */
            /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
                jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
                	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
                	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
                	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
                */
            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public final java.lang.Object invokeSuspend(java.lang.Object r13) {
                /*
                    r12 = this;
                    java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
                    int r1 = r12.f21976b
                    r2 = 1
                    if (r1 == 0) goto L1f
                    if (r1 != r2) goto L17
                    java.lang.Object r1 = r12.f21975a
                    androidx.compose.ui.input.pointer.PointerEventPass r1 = (androidx.compose.ui.input.pointer.PointerEventPass) r1
                    java.lang.Object r3 = r12.f21977c
                    androidx.compose.ui.input.pointer.AwaitPointerEventScope r3 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r3
                    kotlin.ResultKt.b(r13)
                    goto L36
                L17:
                    java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
                    java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                    r13.<init>(r0)
                    throw r13
                L1f:
                    kotlin.ResultKt.b(r13)
                    java.lang.Object r13 = r12.f21977c
                    androidx.compose.ui.input.pointer.AwaitPointerEventScope r13 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r13
                    androidx.compose.ui.input.pointer.PointerEventPass r1 = androidx.compose.ui.input.pointer.PointerEventPass.f26831b
                    r3 = r13
                L29:
                    r12.f21977c = r3
                    r12.f21975a = r1
                    r12.f21976b = r2
                    java.lang.Object r13 = r3.T0(r1, r12)
                    if (r13 != r0) goto L36
                    return r0
                L36:
                    androidx.compose.ui.input.pointer.PointerEvent r13 = (androidx.compose.ui.input.pointer.PointerEvent) r13
                    java.util.List r4 = r13.c()
                    r5 = 0
                    java.lang.Object r4 = r4.get(r5)
                    androidx.compose.ui.input.pointer.PointerInputChange r4 = (androidx.compose.ui.input.pointer.PointerInputChange) r4
                    int r4 = r4.n()
                    androidx.compose.ui.input.pointer.PointerType$Companion r5 = androidx.compose.ui.input.pointer.PointerType.f26922b
                    int r5 = r5.b()
                    boolean r4 = androidx.compose.ui.input.pointer.PointerType.h(r4, r5)
                    if (r4 == 0) goto L29
                    int r13 = r13.h()
                    androidx.compose.ui.input.pointer.PointerEventType$Companion r4 = androidx.compose.ui.input.pointer.PointerEventType.f26835b
                    int r5 = r4.a()
                    boolean r5 = androidx.compose.ui.input.pointer.PointerEventType.j(r13, r5)
                    if (r5 == 0) goto L75
                    kotlinx.coroutines.CoroutineScope r6 = r12.f21978d
                    androidx.compose.material3.internal.BasicTooltip_androidKt$handleGestures$2$1$1$1 r9 = new androidx.compose.material3.internal.BasicTooltip_androidKt$handleGestures$2$1$1$1
                    androidx.compose.material3.TooltipState r13 = r12.f21979f
                    r4 = 0
                    r9.<init>(r13, r4)
                    r10 = 3
                    r11 = 0
                    r7 = 0
                    r8 = 0
                    kotlinx.coroutines.BuildersKt.d(r6, r7, r8, r9, r10, r11)
                    goto L29
                L75:
                    int r4 = r4.b()
                    boolean r13 = androidx.compose.ui.input.pointer.PointerEventType.j(r13, r4)
                    if (r13 == 0) goto L29
                    androidx.compose.material3.TooltipState r13 = r12.f21979f
                    r13.dismiss()
                    goto L29
                */
                throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.internal.BasicTooltip_androidKt$handleGestures$2.AnonymousClass1.C00691.invokeSuspend(java.lang.Object):java.lang.Object");
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(PointerInputScope pointerInputScope, TooltipState tooltipState, Continuation continuation) {
            super(2, continuation);
            this.f21973c = pointerInputScope;
            this.f21974d = tooltipState;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.f21973c, this.f21974d, continuation);
            anonymousClass1.f21972b = obj;
            return anonymousClass1;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objF = IntrinsicsKt.f();
            int i3 = this.f21971a;
            if (i3 == 0) {
                ResultKt.b(obj);
                CoroutineScope coroutineScope = (CoroutineScope) this.f21972b;
                PointerInputScope pointerInputScope = this.f21973c;
                C00691 c00691 = new C00691(coroutineScope, this.f21974d, null);
                this.f21971a = 1;
                if (pointerInputScope.c0(c00691, this) == objF) {
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
    BasicTooltip_androidKt$handleGestures$2(TooltipState tooltipState, Continuation continuation) {
        super(2, continuation);
        this.f21970c = tooltipState;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        BasicTooltip_androidKt$handleGestures$2 basicTooltip_androidKt$handleGestures$2 = new BasicTooltip_androidKt$handleGestures$2(this.f21970c, continuation);
        basicTooltip_androidKt$handleGestures$2.f21969b = obj;
        return basicTooltip_androidKt$handleGestures$2;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(PointerInputScope pointerInputScope, Continuation continuation) {
        return ((BasicTooltip_androidKt$handleGestures$2) create(pointerInputScope, continuation)).invokeSuspend(Unit.f139807a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objF = IntrinsicsKt.f();
        int i3 = this.f21968a;
        if (i3 == 0) {
            ResultKt.b(obj);
            AnonymousClass1 anonymousClass1 = new AnonymousClass1((PointerInputScope) this.f21969b, this.f21970c, null);
            this.f21968a = 1;
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
