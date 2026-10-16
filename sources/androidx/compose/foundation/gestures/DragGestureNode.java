package androidx.compose.foundation.gestures;

import androidx.compose.foundation.gestures.DragEvent;
import androidx.compose.foundation.interaction.DragInteraction;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.pointer.PointerEvent;
import androidx.compose.ui.input.pointer.PointerEventPass;
import androidx.compose.ui.input.pointer.PointerInputChange;
import androidx.compose.ui.input.pointer.PointerInputEventHandler;
import androidx.compose.ui.input.pointer.PointerInputScope;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.ui.input.pointer.SuspendingPointerInputModifierNode;
import androidx.compose.ui.input.pointer.util.VelocityTracker;
import androidx.compose.ui.input.pointer.util.VelocityTrackerKt;
import androidx.compose.ui.node.DelegatingNode;
import androidx.compose.ui.node.PointerInputModifierNode;
import androidx.compose.ui.unit.VelocityKt;
import com.google.android.gms.common.api.Api;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelKt;
import kotlinx.coroutines.channels.ChannelResult;

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
public abstract class DragGestureNode extends DelegatingNode implements PointerInputModifierNode {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Orientation f5824c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Function1 f5825d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f5826f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private MutableInteractionSource f5827g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final Function1 f5828h = new Function1<PointerInputChange, Boolean>() { // from class: androidx.compose.foundation.gestures.DragGestureNode$_canDrag$1
        {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public final Boolean invoke(PointerInputChange pointerInputChange) {
            return (Boolean) this.f5833a.C2().invoke(pointerInputChange);
        }
    };

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private Channel f5829i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private DragInteraction.Start f5830j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private boolean f5831k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private SuspendingPointerInputModifierNode f5832l;

    public DragGestureNode(Function1 function1, boolean z2, MutableInteractionSource mutableInteractionSource, Orientation orientation) {
        this.f5824c = orientation;
        this.f5825d = function1;
        this.f5826f = z2;
        this.f5827g = mutableInteractionSource;
    }

    private final SuspendingPointerInputModifierNode E2() {
        return SuspendingPointerInputFilterKt.a(new PointerInputEventHandler() { // from class: androidx.compose.foundation.gestures.DragGestureNode$initializePointerInputNode$1

            /* JADX INFO: renamed from: androidx.compose.foundation.gestures.DragGestureNode$initializePointerInputNode$1$1, reason: invalid class name */
            /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
            @Metadata
            @DebugMetadata(c = "androidx.compose.foundation.gestures.DragGestureNode$initializePointerInputNode$1$1", f = "Draggable.kt", l = {512}, m = "invokeSuspend")
            static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                int f5835a;

                /* JADX INFO: renamed from: b, reason: collision with root package name */
                private /* synthetic */ Object f5836b;

                /* JADX INFO: renamed from: c, reason: collision with root package name */
                final /* synthetic */ DragGestureNode f5837c;

                /* JADX INFO: renamed from: d, reason: collision with root package name */
                final /* synthetic */ PointerInputScope f5838d;

                /* JADX INFO: renamed from: f, reason: collision with root package name */
                final /* synthetic */ Function3 f5839f;

                /* JADX INFO: renamed from: g, reason: collision with root package name */
                final /* synthetic */ Function1 f5840g;

                /* JADX INFO: renamed from: h, reason: collision with root package name */
                final /* synthetic */ Function0 f5841h;

                /* JADX INFO: renamed from: i, reason: collision with root package name */
                final /* synthetic */ Function0 f5842i;

                /* JADX INFO: renamed from: j, reason: collision with root package name */
                final /* synthetic */ Function2 f5843j;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                AnonymousClass1(DragGestureNode dragGestureNode, PointerInputScope pointerInputScope, Function3 function3, Function1 function1, Function0 function0, Function0 function02, Function2 function2, Continuation continuation) {
                    super(2, continuation);
                    this.f5837c = dragGestureNode;
                    this.f5838d = pointerInputScope;
                    this.f5839f = function3;
                    this.f5840g = function1;
                    this.f5841h = function0;
                    this.f5842i = function02;
                    this.f5843j = function2;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation create(Object obj, Continuation continuation) {
                    AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.f5837c, this.f5838d, this.f5839f, this.f5840g, this.f5841h, this.f5842i, this.f5843j, continuation);
                    anonymousClass1.f5836b = obj;
                    return anonymousClass1;
                }

                /* JADX WARN: Removed duplicated region for block: B:24:0x0055  */
                /* JADX WARN: Removed duplicated region for block: B:29:0x0067  */
                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public final java.lang.Object invokeSuspend(java.lang.Object r12) throws java.lang.Throwable {
                    /*
                        r11 = this;
                        java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
                        int r1 = r11.f5835a
                        r2 = 1
                        if (r1 == 0) goto L21
                        if (r1 != r2) goto L19
                        java.lang.Object r0 = r11.f5836b
                        r1 = r0
                        kotlinx.coroutines.CoroutineScope r1 = (kotlinx.coroutines.CoroutineScope) r1
                        kotlin.ResultKt.b(r12)     // Catch: java.util.concurrent.CancellationException -> L15
                        r10 = r11
                        goto L64
                    L15:
                        r0 = move-exception
                        r12 = r0
                        r10 = r11
                        goto L4d
                    L19:
                        java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
                        java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                        r12.<init>(r0)
                        throw r12
                    L21:
                        kotlin.ResultKt.b(r12)
                        java.lang.Object r12 = r11.f5836b
                        r1 = r12
                        kotlinx.coroutines.CoroutineScope r1 = (kotlinx.coroutines.CoroutineScope) r1
                        androidx.compose.foundation.gestures.DragGestureNode r12 = r11.f5837c     // Catch: java.util.concurrent.CancellationException -> L4a
                        androidx.compose.foundation.gestures.Orientation r8 = androidx.compose.foundation.gestures.DragGestureNode.t2(r12)     // Catch: java.util.concurrent.CancellationException -> L4a
                        androidx.compose.ui.input.pointer.PointerInputScope r3 = r11.f5838d     // Catch: java.util.concurrent.CancellationException -> L4a
                        kotlin.jvm.functions.Function3 r4 = r11.f5839f     // Catch: java.util.concurrent.CancellationException -> L4a
                        kotlin.jvm.functions.Function1 r5 = r11.f5840g     // Catch: java.util.concurrent.CancellationException -> L4a
                        kotlin.jvm.functions.Function0 r6 = r11.f5841h     // Catch: java.util.concurrent.CancellationException -> L4a
                        kotlin.jvm.functions.Function0 r7 = r11.f5842i     // Catch: java.util.concurrent.CancellationException -> L4a
                        kotlin.jvm.functions.Function2 r9 = r11.f5843j     // Catch: java.util.concurrent.CancellationException -> L4a
                        r11.f5836b = r1     // Catch: java.util.concurrent.CancellationException -> L4a
                        r11.f5835a = r2     // Catch: java.util.concurrent.CancellationException -> L4a
                        r10 = r11
                        java.lang.Object r12 = androidx.compose.foundation.gestures.DragGestureDetectorKt.n(r3, r4, r5, r6, r7, r8, r9, r10)     // Catch: java.util.concurrent.CancellationException -> L47
                        if (r12 != r0) goto L64
                        return r0
                    L47:
                        r0 = move-exception
                    L48:
                        r12 = r0
                        goto L4d
                    L4a:
                        r0 = move-exception
                        r10 = r11
                        goto L48
                    L4d:
                        androidx.compose.foundation.gestures.DragGestureNode r0 = r10.f5837c
                        kotlinx.coroutines.channels.Channel r0 = androidx.compose.foundation.gestures.DragGestureNode.s2(r0)
                        if (r0 == 0) goto L5e
                        androidx.compose.foundation.gestures.DragEvent$DragCancelled r2 = androidx.compose.foundation.gestures.DragEvent.DragCancelled.f5654a
                        java.lang.Object r0 = r0.h(r2)
                        kotlinx.coroutines.channels.ChannelResult.b(r0)
                    L5e:
                        boolean r0 = kotlinx.coroutines.CoroutineScopeKt.h(r1)
                        if (r0 == 0) goto L67
                    L64:
                        kotlin.Unit r12 = kotlin.Unit.f139807a
                        return r12
                    L67:
                        throw r12
                    */
                    throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.DragGestureNode$initializePointerInputNode$1.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
                }

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
                    return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
                }
            }

            @Override // androidx.compose.ui.input.pointer.PointerInputEventHandler
            public final Object invoke(final PointerInputScope pointerInputScope, Continuation continuation) {
                final VelocityTracker velocityTracker = new VelocityTracker();
                final DragGestureNode dragGestureNode = this.f5834a;
                Function3<PointerInputChange, PointerInputChange, Offset, Unit> function3 = new Function3<PointerInputChange, PointerInputChange, Offset, Unit>() { // from class: androidx.compose.foundation.gestures.DragGestureNode$initializePointerInputNode$1$onDragStart$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(3);
                    }

                    public final void c(PointerInputChange pointerInputChange, PointerInputChange pointerInputChange2, long j3) {
                        if (((Boolean) dragGestureNode.C2().invoke(pointerInputChange)).booleanValue()) {
                            if (!dragGestureNode.f5831k) {
                                if (dragGestureNode.f5829i == null) {
                                    dragGestureNode.f5829i = ChannelKt.b(Api.BaseClientBuilder.API_PRIORITY_OTHER, null, null, 6, null);
                                }
                                dragGestureNode.L2();
                            }
                            VelocityTrackerKt.c(velocityTracker, pointerInputChange);
                            long jP = Offset.p(pointerInputChange2.h(), j3);
                            Channel channel = dragGestureNode.f5829i;
                            if (channel != null) {
                                ChannelResult.b(channel.h(new DragEvent.DragStarted(jP, null)));
                            }
                        }
                    }

                    @Override // kotlin.jvm.functions.Function3
                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                        c((PointerInputChange) obj, (PointerInputChange) obj2, ((Offset) obj3).u());
                        return Unit.f139807a;
                    }
                };
                final DragGestureNode dragGestureNode2 = this.f5834a;
                Function1<PointerInputChange, Unit> function1 = new Function1<PointerInputChange, Unit>() { // from class: androidx.compose.foundation.gestures.DragGestureNode$initializePointerInputNode$1$onDragEnd$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    public final void c(PointerInputChange pointerInputChange) {
                        VelocityTrackerKt.c(velocityTracker, pointerInputChange);
                        float f3 = pointerInputScope.getViewConfiguration().f();
                        long jC = velocityTracker.c(VelocityKt.a(f3, f3));
                        velocityTracker.f();
                        Channel channel = dragGestureNode2.f5829i;
                        if (channel != null) {
                            ChannelResult.b(channel.h(new DragEvent.DragStopped(DraggableKt.l(jC), null)));
                        }
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        c((PointerInputChange) obj);
                        return Unit.f139807a;
                    }
                };
                final DragGestureNode dragGestureNode3 = this.f5834a;
                Function0<Unit> function0 = new Function0<Unit>() { // from class: androidx.compose.foundation.gestures.DragGestureNode$initializePointerInputNode$1$onDragCancel$1
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Object invoke() {
                        m43invoke();
                        return Unit.f139807a;
                    }

                    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
                    public final void m43invoke() {
                        Channel channel = dragGestureNode3.f5829i;
                        if (channel != null) {
                            ChannelResult.b(channel.h(DragEvent.DragCancelled.f5654a));
                        }
                    }
                };
                final DragGestureNode dragGestureNode4 = this.f5834a;
                Function0<Boolean> function02 = new Function0<Boolean>() { // from class: androidx.compose.foundation.gestures.DragGestureNode$initializePointerInputNode$1$shouldAwaitTouchSlop$1
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final Boolean invoke() {
                        return Boolean.valueOf(!dragGestureNode4.K2());
                    }
                };
                final DragGestureNode dragGestureNode5 = this.f5834a;
                Object objF = CoroutineScopeKt.f(new AnonymousClass1(this.f5834a, pointerInputScope, function3, function1, function0, function02, new Function2<PointerInputChange, Offset, Unit>() { // from class: androidx.compose.foundation.gestures.DragGestureNode$initializePointerInputNode$1$onDrag$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                    }

                    public final void c(PointerInputChange pointerInputChange, long j3) {
                        VelocityTrackerKt.c(velocityTracker, pointerInputChange);
                        Channel channel = dragGestureNode5.f5829i;
                        if (channel != null) {
                            ChannelResult.b(channel.h(new DragEvent.DragDelta(j3, null)));
                        }
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                        c((PointerInputChange) obj, ((Offset) obj2).u());
                        return Unit.f139807a;
                    }
                }, null), continuation);
                return objF == IntrinsicsKt.f() ? objF : Unit.f139807a;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object H2(kotlin.coroutines.Continuation r6) throws java.lang.Throwable {
        /*
            r5 = this;
            boolean r0 = r6 instanceof androidx.compose.foundation.gestures.DragGestureNode$processDragCancel$1
            if (r0 == 0) goto L13
            r0 = r6
            androidx.compose.foundation.gestures.DragGestureNode$processDragCancel$1 r0 = (androidx.compose.foundation.gestures.DragGestureNode$processDragCancel$1) r0
            int r1 = r0.f5856d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f5856d = r1
            goto L18
        L13:
            androidx.compose.foundation.gestures.DragGestureNode$processDragCancel$1 r0 = new androidx.compose.foundation.gestures.DragGestureNode$processDragCancel$1
            r0.<init>(r5, r6)
        L18:
            java.lang.Object r6 = r0.f5854b
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.f5856d
            r3 = 1
            if (r2 == 0) goto L35
            if (r2 != r3) goto L2d
            java.lang.Object r0 = r0.f5853a
            androidx.compose.foundation.gestures.DragGestureNode r0 = (androidx.compose.foundation.gestures.DragGestureNode) r0
            kotlin.ResultKt.b(r6)
            goto L51
        L2d:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r0)
            throw r6
        L35:
            kotlin.ResultKt.b(r6)
            androidx.compose.foundation.interaction.DragInteraction$Start r6 = r5.f5830j
            if (r6 == 0) goto L55
            androidx.compose.foundation.interaction.MutableInteractionSource r2 = r5.f5827g
            if (r2 == 0) goto L50
            androidx.compose.foundation.interaction.DragInteraction$Cancel r4 = new androidx.compose.foundation.interaction.DragInteraction$Cancel
            r4.<init>(r6)
            r0.f5853a = r5
            r0.f5856d = r3
            java.lang.Object r6 = r2.a(r4, r0)
            if (r6 != r1) goto L50
            return r1
        L50:
            r0 = r5
        L51:
            r6 = 0
            r0.f5830j = r6
            goto L56
        L55:
            r0 = r5
        L56:
            androidx.compose.ui.unit.Velocity$Companion r6 = androidx.compose.ui.unit.Velocity.f30015b
            long r1 = r6.a()
            r0.G2(r1)
            kotlin.Unit r6 = kotlin.Unit.f139807a
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.DragGestureNode.H2(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0066, code lost:
    
        if (r2.a(r5, r0) == r1) goto L28;
     */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object I2(androidx.compose.foundation.gestures.DragEvent.DragStarted r7, kotlin.coroutines.Continuation r8) throws java.lang.Throwable {
        /*
            r6 = this;
            boolean r0 = r8 instanceof androidx.compose.foundation.gestures.DragGestureNode$processDragStart$1
            if (r0 == 0) goto L13
            r0 = r8
            androidx.compose.foundation.gestures.DragGestureNode$processDragStart$1 r0 = (androidx.compose.foundation.gestures.DragGestureNode$processDragStart$1) r0
            int r1 = r0.f5862g
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f5862g = r1
            goto L18
        L13:
            androidx.compose.foundation.gestures.DragGestureNode$processDragStart$1 r0 = new androidx.compose.foundation.gestures.DragGestureNode$processDragStart$1
            r0.<init>(r6, r8)
        L18:
            java.lang.Object r8 = r0.f5860d
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.f5862g
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L4c
            if (r2 == r4) goto L40
            if (r2 != r3) goto L38
            java.lang.Object r7 = r0.f5859c
            androidx.compose.foundation.interaction.DragInteraction$Start r7 = (androidx.compose.foundation.interaction.DragInteraction.Start) r7
            java.lang.Object r1 = r0.f5858b
            androidx.compose.foundation.gestures.DragEvent$DragStarted r1 = (androidx.compose.foundation.gestures.DragEvent.DragStarted) r1
            java.lang.Object r0 = r0.f5857a
            androidx.compose.foundation.gestures.DragGestureNode r0 = (androidx.compose.foundation.gestures.DragGestureNode) r0
            kotlin.ResultKt.b(r8)
            goto L85
        L38:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L40:
            java.lang.Object r7 = r0.f5858b
            androidx.compose.foundation.gestures.DragEvent$DragStarted r7 = (androidx.compose.foundation.gestures.DragEvent.DragStarted) r7
            java.lang.Object r2 = r0.f5857a
            androidx.compose.foundation.gestures.DragGestureNode r2 = (androidx.compose.foundation.gestures.DragGestureNode) r2
            kotlin.ResultKt.b(r8)
            goto L6a
        L4c:
            kotlin.ResultKt.b(r8)
            androidx.compose.foundation.interaction.DragInteraction$Start r8 = r6.f5830j
            if (r8 == 0) goto L69
            androidx.compose.foundation.interaction.MutableInteractionSource r2 = r6.f5827g
            if (r2 == 0) goto L69
            androidx.compose.foundation.interaction.DragInteraction$Cancel r5 = new androidx.compose.foundation.interaction.DragInteraction$Cancel
            r5.<init>(r8)
            r0.f5857a = r6
            r0.f5858b = r7
            r0.f5862g = r4
            java.lang.Object r8 = r2.a(r5, r0)
            if (r8 != r1) goto L69
            goto L81
        L69:
            r2 = r6
        L6a:
            androidx.compose.foundation.interaction.DragInteraction$Start r8 = new androidx.compose.foundation.interaction.DragInteraction$Start
            r8.<init>()
            androidx.compose.foundation.interaction.MutableInteractionSource r4 = r2.f5827g
            if (r4 == 0) goto L88
            r0.f5857a = r2
            r0.f5858b = r7
            r0.f5859c = r8
            r0.f5862g = r3
            java.lang.Object r0 = r4.a(r8, r0)
            if (r0 != r1) goto L82
        L81:
            return r1
        L82:
            r1 = r7
            r7 = r8
            r0 = r2
        L85:
            r8 = r7
            r2 = r0
            r7 = r1
        L88:
            r2.f5830j = r8
            long r7 = r7.a()
            r2.F2(r7)
            kotlin.Unit r7 = kotlin.Unit.f139807a
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.DragGestureNode.I2(androidx.compose.foundation.gestures.DragEvent$DragStarted, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object J2(androidx.compose.foundation.gestures.DragEvent.DragStopped r6, kotlin.coroutines.Continuation r7) throws java.lang.Throwable {
        /*
            r5 = this;
            boolean r0 = r7 instanceof androidx.compose.foundation.gestures.DragGestureNode$processDragStop$1
            if (r0 == 0) goto L13
            r0 = r7
            androidx.compose.foundation.gestures.DragGestureNode$processDragStop$1 r0 = (androidx.compose.foundation.gestures.DragGestureNode$processDragStop$1) r0
            int r1 = r0.f5867f
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f5867f = r1
            goto L18
        L13:
            androidx.compose.foundation.gestures.DragGestureNode$processDragStop$1 r0 = new androidx.compose.foundation.gestures.DragGestureNode$processDragStop$1
            r0.<init>(r5, r7)
        L18:
            java.lang.Object r7 = r0.f5865c
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.f5867f
            r3 = 1
            if (r2 == 0) goto L39
            if (r2 != r3) goto L31
            java.lang.Object r6 = r0.f5864b
            androidx.compose.foundation.gestures.DragEvent$DragStopped r6 = (androidx.compose.foundation.gestures.DragEvent.DragStopped) r6
            java.lang.Object r0 = r0.f5863a
            androidx.compose.foundation.gestures.DragGestureNode r0 = (androidx.compose.foundation.gestures.DragGestureNode) r0
            kotlin.ResultKt.b(r7)
            goto L57
        L31:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L39:
            kotlin.ResultKt.b(r7)
            androidx.compose.foundation.interaction.DragInteraction$Start r7 = r5.f5830j
            if (r7 == 0) goto L5b
            androidx.compose.foundation.interaction.MutableInteractionSource r2 = r5.f5827g
            if (r2 == 0) goto L56
            androidx.compose.foundation.interaction.DragInteraction$Stop r4 = new androidx.compose.foundation.interaction.DragInteraction$Stop
            r4.<init>(r7)
            r0.f5863a = r5
            r0.f5864b = r6
            r0.f5867f = r3
            java.lang.Object r7 = r2.a(r4, r0)
            if (r7 != r1) goto L56
            return r1
        L56:
            r0 = r5
        L57:
            r7 = 0
            r0.f5830j = r7
            goto L5c
        L5b:
            r0 = r5
        L5c:
            long r6 = r6.a()
            r0.G2(r6)
            kotlin.Unit r6 = kotlin.Unit.f139807a
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.DragGestureNode.J2(androidx.compose.foundation.gestures.DragEvent$DragStopped, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void L2() {
        this.f5831k = true;
        BuildersKt__Builders_commonKt.d(getCoroutineScope(), null, null, new DragGestureNode$startListeningForEvents$1(this, null), 3, null);
    }

    public static /* synthetic */ void N2(DragGestureNode dragGestureNode, Function1 function1, boolean z2, MutableInteractionSource mutableInteractionSource, Orientation orientation, boolean z3, int i3, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: update");
        }
        if ((i3 & 1) != 0) {
            function1 = dragGestureNode.f5825d;
        }
        if ((i3 & 2) != 0) {
            z2 = dragGestureNode.f5826f;
        }
        if ((i3 & 4) != 0) {
            mutableInteractionSource = dragGestureNode.f5827g;
        }
        if ((i3 & 8) != 0) {
            orientation = dragGestureNode.f5824c;
        }
        if ((i3 & 16) != 0) {
            z3 = false;
        }
        boolean z4 = z3;
        MutableInteractionSource mutableInteractionSource2 = mutableInteractionSource;
        Function1 function12 = function1;
        dragGestureNode.M2(function12, z2, mutableInteractionSource2, orientation, z4);
    }

    public final void A2() {
        DragInteraction.Start start = this.f5830j;
        if (start != null) {
            MutableInteractionSource mutableInteractionSource = this.f5827g;
            if (mutableInteractionSource != null) {
                mutableInteractionSource.b(new DragInteraction.Cancel(start));
            }
            this.f5830j = null;
        }
    }

    public abstract Object B2(Function2 function2, Continuation continuation);

    protected final Function1 C2() {
        return this.f5825d;
    }

    protected final boolean D2() {
        return this.f5826f;
    }

    public abstract void F2(long j3);

    public abstract void G2(long j3);

    public abstract boolean K2();

    public final void M2(Function1 function1, boolean z2, MutableInteractionSource mutableInteractionSource, Orientation orientation, boolean z3) {
        SuspendingPointerInputModifierNode suspendingPointerInputModifierNode;
        this.f5825d = function1;
        boolean z4 = true;
        if (this.f5826f != z2) {
            this.f5826f = z2;
            if (!z2) {
                A2();
                SuspendingPointerInputModifierNode suspendingPointerInputModifierNode2 = this.f5832l;
                if (suspendingPointerInputModifierNode2 != null) {
                    p2(suspendingPointerInputModifierNode2);
                }
                this.f5832l = null;
            }
            z3 = true;
        }
        if (!Intrinsics.areEqual(this.f5827g, mutableInteractionSource)) {
            A2();
            this.f5827g = mutableInteractionSource;
        }
        if (this.f5824c != orientation) {
            this.f5824c = orientation;
        } else {
            z4 = z3;
        }
        if (!z4 || (suspendingPointerInputModifierNode = this.f5832l) == null) {
            return;
        }
        suspendingPointerInputModifierNode.O0();
    }

    @Override // androidx.compose.ui.node.PointerInputModifierNode
    public void g0(PointerEvent pointerEvent, PointerEventPass pointerEventPass, long j3) {
        if (this.f5826f && this.f5832l == null) {
            this.f5832l = (SuspendingPointerInputModifierNode) m2(E2());
        }
        SuspendingPointerInputModifierNode suspendingPointerInputModifierNode = this.f5832l;
        if (suspendingPointerInputModifierNode != null) {
            suspendingPointerInputModifierNode.g0(pointerEvent, pointerEventPass, j3);
        }
    }

    @Override // androidx.compose.ui.Modifier.Node
    public void onDetach() {
        this.f5831k = false;
        A2();
    }

    @Override // androidx.compose.ui.node.PointerInputModifierNode
    public void u1() {
        SuspendingPointerInputModifierNode suspendingPointerInputModifierNode = this.f5832l;
        if (suspendingPointerInputModifierNode != null) {
            suspendingPointerInputModifierNode.u1();
        }
    }
}
