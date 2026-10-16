package androidx.compose.foundation.gestures;

import androidx.compose.foundation.gestures.TransformEvent;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.pointer.AwaitPointerEventScope;
import androidx.compose.ui.input.pointer.PointerEvent;
import androidx.compose.ui.input.pointer.PointerEventPass;
import androidx.compose.ui.input.pointer.PointerInputChange;
import androidx.compose.ui.input.pointer.PointerInputEventHandler;
import androidx.compose.ui.input.pointer.PointerInputScope;
import androidx.compose.ui.input.pointer.PointerType;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.ui.input.pointer.SuspendingPointerInputModifierNode;
import androidx.compose.ui.node.CompositionLocalConsumerModifierNode;
import androidx.compose.ui.node.DelegatingNode;
import androidx.compose.ui.node.PointerInputModifierNode;
import com.google.android.gms.common.api.Api;
import java.util.List;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelKt;

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
/* JADX INFO: loaded from: classes.dex */
@Metadata
final class TransformableNode extends DelegatingNode implements PointerInputModifierNode, CompositionLocalConsumerModifierNode {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private TransformableState f6335c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Function1 f6336d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f6337f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f6338g;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private ScrollConfig f6341j;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private PointerInputModifierNode f6343l;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final Function1 f6339h = new Function1<Offset, Boolean>() { // from class: androidx.compose.foundation.gestures.TransformableNode$updatedCanPan$1
        {
            super(1);
        }

        public final Boolean c(long j3) {
            return (Boolean) this.f6365a.f6336d.invoke(Offset.d(j3));
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            return c(((Offset) obj).u());
        }
    };

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final Channel f6340i = ChannelKt.b(Api.BaseClientBuilder.API_PRIORITY_OTHER, null, null, 6, null);

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final SuspendingPointerInputModifierNode f6342k = (SuspendingPointerInputModifierNode) m2(SuspendingPointerInputFilterKt.a(new PointerInputEventHandler() { // from class: androidx.compose.foundation.gestures.TransformableNode$pointerInputNode$1

        /* JADX INFO: renamed from: androidx.compose.foundation.gestures.TransformableNode$pointerInputNode$1$1, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        @DebugMetadata(c = "androidx.compose.foundation.gestures.TransformableNode$pointerInputNode$1$1", f = "Transformable.kt", l = {196}, m = "invokeSuspend")
        static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            int f6347a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private /* synthetic */ Object f6348b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ PointerInputScope f6349c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            final /* synthetic */ TransformableNode f6350d;

            /* JADX INFO: renamed from: androidx.compose.foundation.gestures.TransformableNode$pointerInputNode$1$1$1, reason: invalid class name and collision with other inner class name */
            /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
            @Metadata
            @DebugMetadata(c = "androidx.compose.foundation.gestures.TransformableNode$pointerInputNode$1$1$1", f = "Transformable.kt", l = {175, 178}, m = "invokeSuspend")
            static final class C00161 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                Object f6351a;

                /* JADX INFO: renamed from: b, reason: collision with root package name */
                Object f6352b;

                /* JADX INFO: renamed from: c, reason: collision with root package name */
                int f6353c;

                /* JADX INFO: renamed from: d, reason: collision with root package name */
                private /* synthetic */ Object f6354d;

                /* JADX INFO: renamed from: f, reason: collision with root package name */
                final /* synthetic */ TransformableNode f6355f;

                /* JADX INFO: renamed from: androidx.compose.foundation.gestures.TransformableNode$pointerInputNode$1$1$1$1, reason: invalid class name and collision with other inner class name */
                /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
                @Metadata
                @DebugMetadata(c = "androidx.compose.foundation.gestures.TransformableNode$pointerInputNode$1$1$1$1", f = "Transformable.kt", l = {187}, m = "invokeSuspend")
                static final class C00171 extends SuspendLambda implements Function2<TransformScope, Continuation<? super Unit>, Object> {

                    /* JADX INFO: renamed from: a, reason: collision with root package name */
                    Object f6356a;

                    /* JADX INFO: renamed from: b, reason: collision with root package name */
                    int f6357b;

                    /* JADX INFO: renamed from: c, reason: collision with root package name */
                    private /* synthetic */ Object f6358c;

                    /* JADX INFO: renamed from: d, reason: collision with root package name */
                    final /* synthetic */ Ref.ObjectRef f6359d;

                    /* JADX INFO: renamed from: f, reason: collision with root package name */
                    final /* synthetic */ TransformableNode f6360f;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    C00171(Ref.ObjectRef objectRef, TransformableNode transformableNode, Continuation continuation) {
                        super(2, continuation);
                        this.f6359d = objectRef;
                        this.f6360f = transformableNode;
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Continuation create(Object obj, Continuation continuation) {
                        C00171 c00171 = new C00171(this.f6359d, this.f6360f, continuation);
                        c00171.f6358c = obj;
                        return c00171;
                    }

                    @Override // kotlin.jvm.functions.Function2
                    /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
                    public final Object invoke(TransformScope transformScope, Continuation continuation) {
                        return ((C00171) create(transformScope, continuation)).invokeSuspend(Unit.f139807a);
                    }

                    /* JADX WARN: Removed duplicated region for block: B:11:0x002f  */
                    /* JADX WARN: Removed duplicated region for block: B:21:0x0060  */
                    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:18:0x005a -> B:20:0x005d). Please report as a decompilation issue!!! */
                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                        To view partially-correct code enable 'Show inconsistent code' option in preferences
                    */
                    public final java.lang.Object invokeSuspend(java.lang.Object r7) throws java.lang.Throwable {
                        /*
                            r6 = this;
                            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
                            int r1 = r6.f6357b
                            r2 = 1
                            if (r1 == 0) goto L1f
                            if (r1 != r2) goto L17
                            java.lang.Object r1 = r6.f6356a
                            kotlin.jvm.internal.Ref$ObjectRef r1 = (kotlin.jvm.internal.Ref.ObjectRef) r1
                            java.lang.Object r3 = r6.f6358c
                            androidx.compose.foundation.gestures.TransformScope r3 = (androidx.compose.foundation.gestures.TransformScope) r3
                            kotlin.ResultKt.b(r7)
                            goto L5d
                        L17:
                            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
                            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                            r7.<init>(r0)
                            throw r7
                        L1f:
                            kotlin.ResultKt.b(r7)
                            java.lang.Object r7 = r6.f6358c
                            androidx.compose.foundation.gestures.TransformScope r7 = (androidx.compose.foundation.gestures.TransformScope) r7
                            r3 = r7
                        L27:
                            kotlin.jvm.internal.Ref$ObjectRef r7 = r6.f6359d
                            java.lang.Object r7 = r7.f140144a
                            boolean r1 = r7 instanceof androidx.compose.foundation.gestures.TransformEvent.TransformStopped
                            if (r1 != 0) goto L60
                            boolean r1 = r7 instanceof androidx.compose.foundation.gestures.TransformEvent.TransformDelta
                            if (r1 == 0) goto L36
                            androidx.compose.foundation.gestures.TransformEvent$TransformDelta r7 = (androidx.compose.foundation.gestures.TransformEvent.TransformDelta) r7
                            goto L37
                        L36:
                            r7 = 0
                        L37:
                            if (r7 == 0) goto L48
                            float r1 = r7.c()
                            long r4 = r7.a()
                            float r7 = r7.b()
                            r3.a(r1, r4, r7)
                        L48:
                            kotlin.jvm.internal.Ref$ObjectRef r1 = r6.f6359d
                            androidx.compose.foundation.gestures.TransformableNode r7 = r6.f6360f
                            kotlinx.coroutines.channels.Channel r7 = androidx.compose.foundation.gestures.TransformableNode.t2(r7)
                            r6.f6358c = r3
                            r6.f6356a = r1
                            r6.f6357b = r2
                            java.lang.Object r7 = r7.v(r6)
                            if (r7 != r0) goto L5d
                            return r0
                        L5d:
                            r1.f140144a = r7
                            goto L27
                        L60:
                            kotlin.Unit r7 = kotlin.Unit.f139807a
                            return r7
                        */
                        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.TransformableNode$pointerInputNode$1.AnonymousClass1.C00161.C00171.invokeSuspend(java.lang.Object):java.lang.Object");
                    }
                }

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                C00161(TransformableNode transformableNode, Continuation continuation) {
                    super(2, continuation);
                    this.f6355f = transformableNode;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation create(Object obj, Continuation continuation) {
                    C00161 c00161 = new C00161(this.f6355f, continuation);
                    c00161.f6354d = obj;
                    return c00161;
                }

                /* JADX WARN: Code restructure failed: missing block: B:22:0x007d, code lost:
                
                    if (r10.a(r1, r6, r9) == r0) goto L23;
                 */
                /* JADX WARN: Removed duplicated region for block: B:15:0x003c  */
                /* JADX WARN: Removed duplicated region for block: B:25:0x0082  */
                /* JADX WARN: Removed duplicated region for block: B:29:0x0061 A[EXC_TOP_SPLITTER, SYNTHETIC] */
                /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:24:0x0080 -> B:13:0x0036). Please report as a decompilation issue!!! */
                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public final java.lang.Object invokeSuspend(java.lang.Object r10) throws java.lang.Throwable {
                    /*
                        r9 = this;
                        java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
                        int r1 = r9.f6353c
                        r2 = 2
                        r3 = 1
                        if (r1 == 0) goto L2f
                        if (r1 == r3) goto L1f
                        if (r1 != r2) goto L17
                        java.lang.Object r1 = r9.f6354d
                        kotlinx.coroutines.CoroutineScope r1 = (kotlinx.coroutines.CoroutineScope) r1
                        kotlin.ResultKt.b(r10)     // Catch: java.util.concurrent.CancellationException -> L15
                    L15:
                        r10 = r1
                        goto L36
                    L17:
                        java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
                        java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                        r10.<init>(r0)
                        throw r10
                    L1f:
                        java.lang.Object r1 = r9.f6352b
                        kotlin.jvm.internal.Ref$ObjectRef r1 = (kotlin.jvm.internal.Ref.ObjectRef) r1
                        java.lang.Object r4 = r9.f6351a
                        kotlin.jvm.internal.Ref$ObjectRef r4 = (kotlin.jvm.internal.Ref.ObjectRef) r4
                        java.lang.Object r5 = r9.f6354d
                        kotlinx.coroutines.CoroutineScope r5 = (kotlinx.coroutines.CoroutineScope) r5
                        kotlin.ResultKt.b(r10)
                        goto L59
                    L2f:
                        kotlin.ResultKt.b(r10)
                        java.lang.Object r10 = r9.f6354d
                        kotlinx.coroutines.CoroutineScope r10 = (kotlinx.coroutines.CoroutineScope) r10
                    L36:
                        boolean r1 = kotlinx.coroutines.CoroutineScopeKt.h(r10)
                        if (r1 == 0) goto L82
                        kotlin.jvm.internal.Ref$ObjectRef r1 = new kotlin.jvm.internal.Ref$ObjectRef
                        r1.<init>()
                        androidx.compose.foundation.gestures.TransformableNode r4 = r9.f6355f
                        kotlinx.coroutines.channels.Channel r4 = androidx.compose.foundation.gestures.TransformableNode.t2(r4)
                        r9.f6354d = r10
                        r9.f6351a = r1
                        r9.f6352b = r1
                        r9.f6353c = r3
                        java.lang.Object r4 = r4.v(r9)
                        if (r4 != r0) goto L56
                        goto L7f
                    L56:
                        r5 = r10
                        r10 = r4
                        r4 = r1
                    L59:
                        r1.f140144a = r10
                        java.lang.Object r10 = r4.f140144a
                        boolean r10 = r10 instanceof androidx.compose.foundation.gestures.TransformEvent.TransformStarted
                        if (r10 == 0) goto L80
                        androidx.compose.foundation.gestures.TransformableNode r10 = r9.f6355f     // Catch: java.util.concurrent.CancellationException -> L80
                        androidx.compose.foundation.gestures.TransformableState r10 = androidx.compose.foundation.gestures.TransformableNode.w2(r10)     // Catch: java.util.concurrent.CancellationException -> L80
                        androidx.compose.foundation.MutatePriority r1 = androidx.compose.foundation.MutatePriority.f5072b     // Catch: java.util.concurrent.CancellationException -> L80
                        androidx.compose.foundation.gestures.TransformableNode$pointerInputNode$1$1$1$1 r6 = new androidx.compose.foundation.gestures.TransformableNode$pointerInputNode$1$1$1$1     // Catch: java.util.concurrent.CancellationException -> L80
                        androidx.compose.foundation.gestures.TransformableNode r7 = r9.f6355f     // Catch: java.util.concurrent.CancellationException -> L80
                        r8 = 0
                        r6.<init>(r4, r7, r8)     // Catch: java.util.concurrent.CancellationException -> L80
                        r9.f6354d = r5     // Catch: java.util.concurrent.CancellationException -> L80
                        r9.f6351a = r8     // Catch: java.util.concurrent.CancellationException -> L80
                        r9.f6352b = r8     // Catch: java.util.concurrent.CancellationException -> L80
                        r9.f6353c = r2     // Catch: java.util.concurrent.CancellationException -> L80
                        java.lang.Object r10 = r10.a(r1, r6, r9)     // Catch: java.util.concurrent.CancellationException -> L80
                        if (r10 != r0) goto L80
                    L7f:
                        return r0
                    L80:
                        r10 = r5
                        goto L36
                    L82:
                        kotlin.Unit r10 = kotlin.Unit.f139807a
                        return r10
                    */
                    throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.TransformableNode$pointerInputNode$1.AnonymousClass1.C00161.invokeSuspend(java.lang.Object):java.lang.Object");
                }

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
                    return ((C00161) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
                }
            }

            /* JADX INFO: renamed from: androidx.compose.foundation.gestures.TransformableNode$pointerInputNode$1$1$2, reason: invalid class name */
            /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
            @Metadata
            @DebugMetadata(c = "androidx.compose.foundation.gestures.TransformableNode$pointerInputNode$1$1$2", f = "Transformable.kt", l = {198}, m = "invokeSuspend")
            static final class AnonymousClass2 extends RestrictedSuspendLambda implements Function2<AwaitPointerEventScope, Continuation<? super Unit>, Object> {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                int f6361a;

                /* JADX INFO: renamed from: b, reason: collision with root package name */
                private /* synthetic */ Object f6362b;

                /* JADX INFO: renamed from: c, reason: collision with root package name */
                final /* synthetic */ TransformableNode f6363c;

                /* JADX INFO: renamed from: d, reason: collision with root package name */
                final /* synthetic */ CoroutineScope f6364d;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                AnonymousClass2(TransformableNode transformableNode, CoroutineScope coroutineScope, Continuation continuation) {
                    super(2, continuation);
                    this.f6363c = transformableNode;
                    this.f6364d = coroutineScope;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation create(Object obj, Continuation continuation) {
                    AnonymousClass2 anonymousClass2 = new AnonymousClass2(this.f6363c, this.f6364d, continuation);
                    anonymousClass2.f6362b = obj;
                    return anonymousClass2;
                }

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(AwaitPointerEventScope awaitPointerEventScope, Continuation continuation) {
                    return ((AnonymousClass2) create(awaitPointerEventScope, continuation)).invokeSuspend(Unit.f139807a);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object obj) throws Throwable {
                    Object objF = IntrinsicsKt.f();
                    int i3 = this.f6361a;
                    try {
                        try {
                            if (i3 == 0) {
                                ResultKt.b(obj);
                                AwaitPointerEventScope awaitPointerEventScope = (AwaitPointerEventScope) this.f6362b;
                                boolean z2 = this.f6363c.f6337f;
                                Channel channel = this.f6363c.f6340i;
                                Function1 function1 = this.f6363c.f6339h;
                                this.f6361a = 1;
                                if (TransformableKt.g(awaitPointerEventScope, z2, channel, function1, this) == objF) {
                                    return objF;
                                }
                            } else {
                                if (i3 != 1) {
                                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                }
                                ResultKt.b(obj);
                            }
                        } catch (CancellationException e3) {
                            if (!CoroutineScopeKt.h(this.f6364d)) {
                                throw e3;
                            }
                        }
                        return Unit.f139807a;
                    } finally {
                        this.f6363c.f6340i.h(TransformEvent.TransformStopped.f6292a);
                    }
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass1(PointerInputScope pointerInputScope, TransformableNode transformableNode, Continuation continuation) {
                super(2, continuation);
                this.f6349c = pointerInputScope;
                this.f6350d = transformableNode;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation create(Object obj, Continuation continuation) {
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.f6349c, this.f6350d, continuation);
                anonymousClass1.f6348b = obj;
                return anonymousClass1;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) throws Throwable {
                Object objF = IntrinsicsKt.f();
                int i3 = this.f6347a;
                if (i3 == 0) {
                    ResultKt.b(obj);
                    CoroutineScope coroutineScope = (CoroutineScope) this.f6348b;
                    BuildersKt__Builders_commonKt.d(coroutineScope, null, CoroutineStart.f140919d, new C00161(this.f6350d, null), 1, null);
                    PointerInputScope pointerInputScope = this.f6349c;
                    AnonymousClass2 anonymousClass2 = new AnonymousClass2(this.f6350d, coroutineScope, null);
                    this.f6347a = 1;
                    if (ForEachGestureKt.e(pointerInputScope, anonymousClass2, this) == objF) {
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

        @Override // androidx.compose.ui.input.pointer.PointerInputEventHandler
        public final Object invoke(PointerInputScope pointerInputScope, Continuation continuation) {
            if (!this.f6346a.f6338g) {
                return Unit.f139807a;
            }
            Object objF = CoroutineScopeKt.f(new AnonymousClass1(pointerInputScope, this.f6346a, null), continuation);
            return objF == IntrinsicsKt.f() ? objF : Unit.f139807a;
        }
    }));

    public TransformableNode(TransformableState transformableState, Function1 function1, boolean z2, boolean z3) {
        this.f6335c = transformableState;
        this.f6336d = function1;
        this.f6337f = z2;
        this.f6338g = z3;
    }

    @Override // androidx.compose.ui.node.PointerInputModifierNode
    public void g0(PointerEvent pointerEvent, PointerEventPass pointerEventPass, long j3) {
        final ScrollConfig scrollConfig = this.f6341j;
        if (this.f6338g) {
            List listC = pointerEvent.c();
            int size = listC.size();
            int i3 = 0;
            while (true) {
                if (i3 >= size) {
                    break;
                }
                if (!PointerType.h(((PointerInputChange) listC.get(i3)).n(), PointerType.f26922b.b())) {
                    i3++;
                } else if (scrollConfig != null && this.f6343l == null) {
                    this.f6343l = (PointerInputModifierNode) m2(SuspendingPointerInputFilterKt.a(new PointerInputEventHandler() { // from class: androidx.compose.foundation.gestures.TransformableNode$onPointerEvent$2
                        @Override // androidx.compose.ui.input.pointer.PointerInputEventHandler
                        public final Object invoke(PointerInputScope pointerInputScope, Continuation continuation) {
                            Object objH = TransformableKt.h(pointerInputScope, this.f6344a.f6340i, scrollConfig, continuation);
                            return objH == IntrinsicsKt.f() ? objH : Unit.f139807a;
                        }
                    }));
                }
            }
        }
        this.f6342k.g0(pointerEvent, pointerEventPass, j3);
        PointerInputModifierNode pointerInputModifierNode = this.f6343l;
        if (pointerInputModifierNode != null) {
            pointerInputModifierNode.g0(pointerEvent, pointerEventPass, j3);
        }
    }

    @Override // androidx.compose.ui.Modifier.Node
    public void onAttach() {
        super.onAttach();
        this.f6341j = AndroidScrollable_androidKt.a(this);
    }

    @Override // androidx.compose.ui.node.PointerInputModifierNode
    public void u1() {
        this.f6342k.u1();
        PointerInputModifierNode pointerInputModifierNode = this.f6343l;
        if (pointerInputModifierNode != null) {
            pointerInputModifierNode.u1();
        }
    }

    public final void y2(TransformableState transformableState, Function1 function1, boolean z2, boolean z3) {
        this.f6336d = function1;
        if (Intrinsics.areEqual(this.f6335c, transformableState) && this.f6338g == z3 && this.f6337f == z2) {
            return;
        }
        this.f6335c = transformableState;
        this.f6338g = z3;
        this.f6337f = z2;
        this.f6342k.O0();
    }
}
