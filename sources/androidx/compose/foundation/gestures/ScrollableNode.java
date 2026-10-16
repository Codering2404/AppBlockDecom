package androidx.compose.foundation.gestures;

import android.view.KeyEvent;
import androidx.compose.animation.SplineBasedDecayKt;
import androidx.compose.foundation.FocusedBoundsObserverNode;
import androidx.compose.foundation.MutatePriority;
import androidx.compose.foundation.OverscrollEffect;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.relocation.BringIntoViewResponderNode;
import androidx.compose.ui.focus.FocusTargetModifierNodeKt;
import androidx.compose.ui.focus.Focusability;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.key.Key;
import androidx.compose.ui.input.key.KeyEventType;
import androidx.compose.ui.input.key.KeyEvent_androidKt;
import androidx.compose.ui.input.key.KeyInputModifierNode;
import androidx.compose.ui.input.nestedscroll.NestedScrollDispatcher;
import androidx.compose.ui.input.nestedscroll.NestedScrollNodeKt;
import androidx.compose.ui.input.pointer.PointerEvent;
import androidx.compose.ui.input.pointer.PointerEventPass;
import androidx.compose.ui.input.pointer.PointerEventType;
import androidx.compose.ui.input.pointer.PointerInputChange;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.node.CompositionLocalConsumerModifierNode;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.node.SemanticsModifierNode;
import androidx.compose.ui.node.SemanticsModifierNodeKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
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
/* JADX INFO: loaded from: classes.dex */
@Metadata
public final class ScrollableNode extends DragGestureNode implements KeyInputModifierNode, SemanticsModifierNode, CompositionLocalConsumerModifierNode {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private OverscrollEffect f6105m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private FlingBehavior f6106n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final boolean f6107o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private final NestedScrollDispatcher f6108p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private final ScrollableContainerNode f6109q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private final DefaultFlingBehavior f6110r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private final ScrollingLogic f6111s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private final ScrollableNestedScrollConnection f6112t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private final ContentInViewNode f6113u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private Function2 f6114v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private Function2 f6115w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private MouseWheelScrollingLogic f6116x;

    public ScrollableNode(ScrollableState scrollableState, OverscrollEffect overscrollEffect, FlingBehavior flingBehavior, Orientation orientation, boolean z2, boolean z3, MutableInteractionSource mutableInteractionSource, BringIntoViewSpec bringIntoViewSpec) {
        super(ScrollableKt.f6082a, z2, mutableInteractionSource, orientation);
        this.f6105m = overscrollEffect;
        this.f6106n = flingBehavior;
        NestedScrollDispatcher nestedScrollDispatcher = new NestedScrollDispatcher();
        this.f6108p = nestedScrollDispatcher;
        this.f6109q = (ScrollableContainerNode) m2(new ScrollableContainerNode(z2));
        DefaultFlingBehavior defaultFlingBehavior = new DefaultFlingBehavior(SplineBasedDecayKt.c(ScrollableKt.f6085d), null, 2, null);
        this.f6110r = defaultFlingBehavior;
        OverscrollEffect overscrollEffect2 = this.f6105m;
        FlingBehavior flingBehavior2 = this.f6106n;
        ScrollingLogic scrollingLogic = new ScrollingLogic(scrollableState, overscrollEffect2, flingBehavior2 == null ? defaultFlingBehavior : flingBehavior2, orientation, z3, nestedScrollDispatcher, new Function0<Boolean>() { // from class: androidx.compose.foundation.gestures.ScrollableNode$scrollingLogic$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Boolean invoke() {
                return Boolean.valueOf(this.f6136a.isAttached());
            }
        });
        this.f6111s = scrollingLogic;
        ScrollableNestedScrollConnection scrollableNestedScrollConnection = new ScrollableNestedScrollConnection(scrollingLogic, z2);
        this.f6112t = scrollableNestedScrollConnection;
        ContentInViewNode contentInViewNode = (ContentInViewNode) m2(new ContentInViewNode(orientation, scrollingLogic, z3, bringIntoViewSpec));
        this.f6113u = contentInViewNode;
        m2(NestedScrollNodeKt.c(scrollableNestedScrollConnection, nestedScrollDispatcher));
        m2(FocusTargetModifierNodeKt.b(Focusability.f25566b.b(), null, 2, null));
        m2(new BringIntoViewResponderNode(contentInViewNode));
        m2(new FocusedBoundsObserverNode(new Function1<LayoutCoordinates, Unit>() { // from class: androidx.compose.foundation.gestures.ScrollableNode.1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((LayoutCoordinates) obj);
                return Unit.f139807a;
            }

            public final void invoke(LayoutCoordinates layoutCoordinates) {
                ScrollableNode.this.f6113u.G2(layoutCoordinates);
            }
        }));
    }

    private final void R2() {
        this.f6114v = null;
        this.f6115w = null;
    }

    private final void S2() {
        if (this.f6116x == null) {
            this.f6116x = new MouseWheelScrollingLogic(this.f6111s, AndroidScrollable_androidKt.a(this), new ScrollableNode$ensureMouseWheelScrollNodeInitialized$1(this), DelegatableNodeKt.k(this));
        }
        MouseWheelScrollingLogic mouseWheelScrollingLogic = this.f6116x;
        if (mouseWheelScrollingLogic != null) {
            mouseWheelScrollingLogic.v(getCoroutineScope());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ Object T2(ScrollableNode scrollableNode, long j3, Continuation continuation) {
        scrollableNode.U2(j3);
        return Unit.f139807a;
    }

    private final void U2(long j3) {
        BuildersKt__Builders_commonKt.d(this.f6108p.e(), null, null, new ScrollableNode$onWheelScrollStopped$1(this, j3, null), 3, null);
    }

    private final void V2() {
        this.f6114v = new Function2<Float, Float, Boolean>() { // from class: androidx.compose.foundation.gestures.ScrollableNode$setScrollSemanticsActions$1

            /* JADX INFO: renamed from: androidx.compose.foundation.gestures.ScrollableNode$setScrollSemanticsActions$1$1, reason: invalid class name */
            /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
            @Metadata
            @DebugMetadata(c = "androidx.compose.foundation.gestures.ScrollableNode$setScrollSemanticsActions$1$1", f = "Scrollable.kt", l = {518}, m = "invokeSuspend")
            static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                int f6138a;

                /* JADX INFO: renamed from: b, reason: collision with root package name */
                final /* synthetic */ ScrollableNode f6139b;

                /* JADX INFO: renamed from: c, reason: collision with root package name */
                final /* synthetic */ float f6140c;

                /* JADX INFO: renamed from: d, reason: collision with root package name */
                final /* synthetic */ float f6141d;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                AnonymousClass1(ScrollableNode scrollableNode, float f3, float f4, Continuation continuation) {
                    super(2, continuation);
                    this.f6139b = scrollableNode;
                    this.f6140c = f3;
                    this.f6141d = f4;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation create(Object obj, Continuation continuation) {
                    return new AnonymousClass1(this.f6139b, this.f6140c, this.f6141d, continuation);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object obj) throws Throwable {
                    Object objF = IntrinsicsKt.f();
                    int i3 = this.f6138a;
                    if (i3 == 0) {
                        ResultKt.b(obj);
                        ScrollingLogic scrollingLogic = this.f6139b.f6111s;
                        float f3 = this.f6140c;
                        float f4 = this.f6141d;
                        long jE = Offset.e((((long) Float.floatToRawIntBits(f3)) << 32) | (((long) Float.floatToRawIntBits(f4)) & 4294967295L));
                        this.f6138a = 1;
                        if (ScrollableKt.l(scrollingLogic, jE, this) == objF) {
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

            {
                super(2);
            }

            public final Boolean c(float f3, float f4) {
                BuildersKt__Builders_commonKt.d(this.f6137a.getCoroutineScope(), null, null, new AnonymousClass1(this.f6137a, f3, f4, null), 3, null);
                return Boolean.TRUE;
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                return c(((Number) obj).floatValue(), ((Number) obj2).floatValue());
            }
        };
        this.f6115w = new ScrollableNode$setScrollSemanticsActions$2(this, null);
    }

    private final void X2() {
        if (isAttached()) {
            this.f6110r.g(DelegatableNodeKt.k(this));
        }
    }

    @Override // androidx.compose.foundation.gestures.DragGestureNode
    public Object B2(Function2 function2, Continuation continuation) {
        ScrollingLogic scrollingLogic = this.f6111s;
        Object objZ = scrollingLogic.z(MutatePriority.f5072b, new ScrollableNode$drag$2$1(function2, scrollingLogic, null), continuation);
        return objZ == IntrinsicsKt.f() ? objZ : Unit.f139807a;
    }

    @Override // androidx.compose.foundation.gestures.DragGestureNode
    public void G2(long j3) {
        BuildersKt__Builders_commonKt.d(this.f6108p.e(), null, null, new ScrollableNode$onDragStopped$1(this, j3, null), 3, null);
    }

    @Override // androidx.compose.foundation.gestures.DragGestureNode
    public boolean K2() {
        return this.f6111s.B();
    }

    @Override // androidx.compose.ui.node.SemanticsModifierNode
    public void N(SemanticsPropertyReceiver semanticsPropertyReceiver) {
        if (D2() && (this.f6114v == null || this.f6115w == null)) {
            V2();
        }
        Function2 function2 = this.f6114v;
        if (function2 != null) {
            SemanticsPropertiesKt.V(semanticsPropertyReceiver, null, function2, 1, null);
        }
        Function2 function22 = this.f6115w;
        if (function22 != null) {
            SemanticsPropertiesKt.W(semanticsPropertyReceiver, function22);
        }
    }

    @Override // androidx.compose.ui.input.key.KeyInputModifierNode
    public boolean R0(KeyEvent keyEvent) {
        return false;
    }

    public final void W2(ScrollableState scrollableState, Orientation orientation, OverscrollEffect overscrollEffect, boolean z2, boolean z3, FlingBehavior flingBehavior, MutableInteractionSource mutableInteractionSource, BringIntoViewSpec bringIntoViewSpec) {
        boolean z4;
        if (D2() != z2) {
            this.f6112t.a(z2);
            this.f6109q.n2(z2);
            z4 = true;
        } else {
            z4 = false;
        }
        boolean z5 = z4;
        boolean zI = this.f6111s.I(scrollableState, orientation, overscrollEffect, z3, flingBehavior == null ? this.f6110r : flingBehavior, this.f6108p);
        this.f6113u.J2(orientation, z3, bringIntoViewSpec);
        this.f6105m = overscrollEffect;
        this.f6106n = flingBehavior;
        M2(ScrollableKt.f6082a, z2, mutableInteractionSource, this.f6111s.t() ? Orientation.f6031a : Orientation.f6032b, zI);
        if (z5) {
            R2();
            SemanticsModifierNodeKt.b(this);
        }
    }

    @Override // androidx.compose.foundation.gestures.DragGestureNode, androidx.compose.ui.node.PointerInputModifierNode
    public void g0(PointerEvent pointerEvent, PointerEventPass pointerEventPass, long j3) {
        List listC = pointerEvent.c();
        int size = listC.size();
        int i3 = 0;
        while (true) {
            if (i3 >= size) {
                break;
            }
            if (((Boolean) C2().invoke((PointerInputChange) listC.get(i3))).booleanValue()) {
                super.g0(pointerEvent, pointerEventPass, j3);
                break;
            }
            i3++;
        }
        if (D2()) {
            if (pointerEventPass == PointerEventPass.f26830a && PointerEventType.j(pointerEvent.h(), PointerEventType.f26835b.f())) {
                S2();
            }
            MouseWheelScrollingLogic mouseWheelScrollingLogic = this.f6116x;
            if (mouseWheelScrollingLogic != null) {
                mouseWheelScrollingLogic.u(pointerEvent, pointerEventPass, j3);
            }
        }
    }

    @Override // androidx.compose.ui.Modifier.Node
    public boolean getShouldAutoInvalidate() {
        return this.f6107o;
    }

    @Override // androidx.compose.ui.input.key.KeyInputModifierNode
    public boolean o1(KeyEvent keyEvent) {
        long jE;
        if (!D2()) {
            return false;
        }
        long jA = KeyEvent_androidKt.a(keyEvent);
        Key.Companion companion = Key.f26638b;
        if ((!Key.p(jA, companion.j()) && !Key.p(KeyEvent_androidKt.a(keyEvent), companion.k())) || !KeyEventType.f(KeyEvent_androidKt.b(keyEvent), KeyEventType.f26731b.a()) || KeyEvent_androidKt.e(keyEvent)) {
            return false;
        }
        if (this.f6111s.t()) {
            int iC2 = (int) (this.f6113u.C2() & 4294967295L);
            jE = Offset.e((((long) Float.floatToRawIntBits(0.0f)) << 32) | (((long) Float.floatToRawIntBits(Key.p(KeyEvent_androidKt.a(keyEvent), companion.k()) ? iC2 : -iC2)) & 4294967295L));
        } else {
            int iC22 = (int) (this.f6113u.C2() >> 32);
            jE = Offset.e((((long) Float.floatToRawIntBits(0.0f)) & 4294967295L) | (((long) Float.floatToRawIntBits(Key.p(KeyEvent_androidKt.a(keyEvent), companion.k()) ? iC22 : -iC22)) << 32));
        }
        BuildersKt__Builders_commonKt.d(getCoroutineScope(), null, null, new ScrollableNode$onKeyEvent$1(this, jE, null), 3, null);
        return true;
    }

    @Override // androidx.compose.ui.Modifier.Node
    public void onAttach() {
        X2();
        MouseWheelScrollingLogic mouseWheelScrollingLogic = this.f6116x;
        if (mouseWheelScrollingLogic != null) {
            mouseWheelScrollingLogic.z(DelegatableNodeKt.k(this));
        }
    }

    @Override // androidx.compose.ui.node.DelegatableNode, androidx.compose.ui.node.PointerInputModifierNode
    public void onDensityChange() {
        u1();
        X2();
        MouseWheelScrollingLogic mouseWheelScrollingLogic = this.f6116x;
        if (mouseWheelScrollingLogic != null) {
            mouseWheelScrollingLogic.z(DelegatableNodeKt.k(this));
        }
    }

    @Override // androidx.compose.foundation.gestures.DragGestureNode
    public void F2(long j3) {
    }
}
