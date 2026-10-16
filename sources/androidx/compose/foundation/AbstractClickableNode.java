package androidx.compose.foundation;

import android.view.KeyEvent;
import androidx.collection.LongObjectMapKt;
import androidx.collection.MutableLongObjectMap;
import androidx.compose.foundation.gestures.PressGestureScope;
import androidx.compose.foundation.interaction.HoverInteraction;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.interaction.PressInteraction;
import androidx.compose.ui.focus.Focusability;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.key.KeyEvent_androidKt;
import androidx.compose.ui.input.key.KeyInputModifierNode;
import androidx.compose.ui.input.pointer.PointerEvent;
import androidx.compose.ui.input.pointer.PointerEventPass;
import androidx.compose.ui.input.pointer.PointerEventType;
import androidx.compose.ui.input.pointer.PointerInputEventHandler;
import androidx.compose.ui.input.pointer.PointerInputScope;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.ui.input.pointer.SuspendingPointerInputModifierNode;
import androidx.compose.ui.node.DelegatableNode;
import androidx.compose.ui.node.DelegatingNode;
import androidx.compose.ui.node.PointerInputModifierNode;
import androidx.compose.ui.node.SemanticsModifierNode;
import androidx.compose.ui.node.TraversableNode;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntSizeKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
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
public abstract class AbstractClickableNode extends DelegatingNode implements PointerInputModifierNode, KeyInputModifierNode, SemanticsModifierNode, TraversableNode {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final TraverseKey f4498u = new TraverseKey(null);

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final int f4499v = 8;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private MutableInteractionSource f4500c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private IndicationNodeFactory f4501d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private String f4502f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private Role f4503g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f4504h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private Function0 f4505i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final boolean f4506j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final FocusableNode f4507k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private SuspendingPointerInputModifierNode f4508l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private DelegatableNode f4509m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private PressInteraction.Press f4510n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private HoverInteraction.Enter f4511o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private final MutableLongObjectMap f4512p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private long f4513q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private MutableInteractionSource f4514r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private boolean f4515s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private final Object f4516t;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class TraverseKey {
        public /* synthetic */ TraverseKey(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private TraverseKey() {
        }
    }

    public /* synthetic */ AbstractClickableNode(MutableInteractionSource mutableInteractionSource, IndicationNodeFactory indicationNodeFactory, boolean z2, String str, Role role, Function0 function0, DefaultConstructorMarker defaultConstructorMarker) {
        this(mutableInteractionSource, indicationNodeFactory, z2, str, role, function0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean B2() {
        return ClickableKt.k(this) || Clickable_androidKt.b(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void D2() {
        if (this.f4511o == null) {
            HoverInteraction.Enter enter = new HoverInteraction.Enter();
            MutableInteractionSource mutableInteractionSource = this.f4500c;
            if (mutableInteractionSource != null) {
                BuildersKt__Builders_commonKt.d(getCoroutineScope(), null, null, new AbstractClickableNode$emitHoverEnter$1$1(mutableInteractionSource, enter, null), 3, null);
            }
            this.f4511o = enter;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void E2() {
        HoverInteraction.Enter enter = this.f4511o;
        if (enter != null) {
            HoverInteraction.Exit exit = new HoverInteraction.Exit(enter);
            MutableInteractionSource mutableInteractionSource = this.f4500c;
            if (mutableInteractionSource != null) {
                BuildersKt__Builders_commonKt.d(getCoroutineScope(), null, null, new AbstractClickableNode$emitHoverExit$1$1$1(mutableInteractionSource, exit, null), 3, null);
            }
            this.f4511o = null;
        }
    }

    private final void I2() {
        IndicationNodeFactory indicationNodeFactory;
        if (this.f4509m == null && (indicationNodeFactory = this.f4501d) != null) {
            if (this.f4500c == null) {
                this.f4500c = InteractionSourceKt.a();
            }
            this.f4507k.B2(this.f4500c);
            MutableInteractionSource mutableInteractionSource = this.f4500c;
            Intrinsics.checkNotNull(mutableInteractionSource);
            DelegatableNode delegatableNodeB = indicationNodeFactory.b(mutableInteractionSource);
            m2(delegatableNodeB);
            this.f4509m = delegatableNodeB;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:20:0x005d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void M2(boolean r19) {
        /*
            r18 = this;
            r0 = r18
            if (r19 == 0) goto L8
            r0.I2()
            return
        L8:
            androidx.compose.foundation.interaction.MutableInteractionSource r1 = r0.f4500c
            if (r1 == 0) goto L62
            androidx.collection.MutableLongObjectMap r1 = r0.f4512p
            java.lang.Object[] r2 = r1.f2933c
            long[] r1 = r1.f2931a
            int r3 = r1.length
            int r3 = r3 + (-2)
            if (r3 < 0) goto L62
            r4 = 0
            r5 = r4
        L19:
            r6 = r1[r5]
            long r8 = ~r6
            r10 = 7
            long r8 = r8 << r10
            long r8 = r8 & r6
            r10 = -9187201950435737472(0x8080808080808080, double:-2.937446524422997E-306)
            long r8 = r8 & r10
            int r8 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
            if (r8 == 0) goto L5d
            int r8 = r5 - r3
            int r8 = ~r8
            int r8 = r8 >>> 31
            r9 = 8
            int r8 = 8 - r8
            r10 = r4
        L33:
            if (r10 >= r8) goto L5b
            r11 = 255(0xff, double:1.26E-321)
            long r11 = r11 & r6
            r13 = 128(0x80, double:6.3E-322)
            int r11 = (r11 > r13 ? 1 : (r11 == r13 ? 0 : -1))
            if (r11 >= 0) goto L57
            int r11 = r5 << 3
            int r11 = r11 + r10
            r11 = r2[r11]
            androidx.compose.foundation.interaction.PressInteraction$Press r11 = (androidx.compose.foundation.interaction.PressInteraction.Press) r11
            kotlinx.coroutines.CoroutineScope r12 = r0.getCoroutineScope()
            androidx.compose.foundation.AbstractClickableNode$onFocusChange$1$1 r15 = new androidx.compose.foundation.AbstractClickableNode$onFocusChange$1$1
            r13 = 0
            r15.<init>(r0, r11, r13)
            r16 = 3
            r17 = 0
            r14 = 0
            kotlinx.coroutines.BuildersKt.d(r12, r13, r14, r15, r16, r17)
        L57:
            long r6 = r6 >> r9
            int r10 = r10 + 1
            goto L33
        L5b:
            if (r8 != r9) goto L62
        L5d:
            if (r5 == r3) goto L62
            int r5 = r5 + 1
            goto L19
        L62:
            androidx.collection.MutableLongObjectMap r1 = r0.f4512p
            r1.g()
            r0.J2()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.AbstractClickableNode.M2(boolean):void");
    }

    private final boolean O2() {
        return this.f4514r == null && this.f4501d != null;
    }

    public abstract Object A2(PointerInputScope pointerInputScope, Continuation continuation);

    /* JADX WARN: Removed duplicated region for block: B:22:0x0063  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected final void C2() {
        /*
            r15 = this;
            androidx.compose.foundation.interaction.MutableInteractionSource r0 = r15.f4500c
            if (r0 == 0) goto L68
            androidx.compose.foundation.interaction.PressInteraction$Press r1 = r15.f4510n
            if (r1 == 0) goto L10
            androidx.compose.foundation.interaction.PressInteraction$Cancel r2 = new androidx.compose.foundation.interaction.PressInteraction$Cancel
            r2.<init>(r1)
            r0.b(r2)
        L10:
            androidx.compose.foundation.interaction.HoverInteraction$Enter r1 = r15.f4511o
            if (r1 == 0) goto L1c
            androidx.compose.foundation.interaction.HoverInteraction$Exit r2 = new androidx.compose.foundation.interaction.HoverInteraction$Exit
            r2.<init>(r1)
            r0.b(r2)
        L1c:
            androidx.collection.MutableLongObjectMap r1 = r15.f4512p
            java.lang.Object[] r2 = r1.f2933c
            long[] r1 = r1.f2931a
            int r3 = r1.length
            int r3 = r3 + (-2)
            if (r3 < 0) goto L68
            r4 = 0
            r5 = r4
        L29:
            r6 = r1[r5]
            long r8 = ~r6
            r10 = 7
            long r8 = r8 << r10
            long r8 = r8 & r6
            r10 = -9187201950435737472(0x8080808080808080, double:-2.937446524422997E-306)
            long r8 = r8 & r10
            int r8 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
            if (r8 == 0) goto L63
            int r8 = r5 - r3
            int r8 = ~r8
            int r8 = r8 >>> 31
            r9 = 8
            int r8 = 8 - r8
            r10 = r4
        L43:
            if (r10 >= r8) goto L61
            r11 = 255(0xff, double:1.26E-321)
            long r11 = r11 & r6
            r13 = 128(0x80, double:6.3E-322)
            int r11 = (r11 > r13 ? 1 : (r11 == r13 ? 0 : -1))
            if (r11 >= 0) goto L5d
            int r11 = r5 << 3
            int r11 = r11 + r10
            r11 = r2[r11]
            androidx.compose.foundation.interaction.PressInteraction$Press r11 = (androidx.compose.foundation.interaction.PressInteraction.Press) r11
            androidx.compose.foundation.interaction.PressInteraction$Cancel r12 = new androidx.compose.foundation.interaction.PressInteraction$Cancel
            r12.<init>(r11)
            r0.b(r12)
        L5d:
            long r6 = r6 >> r9
            int r10 = r10 + 1
            goto L43
        L61:
            if (r8 != r9) goto L68
        L63:
            if (r5 == r3) goto L68
            int r5 = r5 + 1
            goto L29
        L68:
            r0 = 0
            r15.f4510n = r0
            r15.f4511o = r0
            androidx.collection.MutableLongObjectMap r0 = r15.f4512p
            r0.g()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.AbstractClickableNode.C2():void");
    }

    protected final boolean F2() {
        return this.f4504h;
    }

    protected final Function0 G2() {
        return this.f4505i;
    }

    protected final Object H2(PressGestureScope pressGestureScope, long j3, Continuation continuation) {
        Object objF;
        MutableInteractionSource mutableInteractionSource = this.f4500c;
        return (mutableInteractionSource == null || (objF = CoroutineScopeKt.f(new AbstractClickableNode$handlePressInteraction$2$1(pressGestureScope, j3, mutableInteractionSource, this, null), continuation)) != IntrinsicsKt.f()) ? Unit.f139807a : objF;
    }

    protected abstract boolean K2(KeyEvent keyEvent);

    protected abstract boolean L2(KeyEvent keyEvent);

    @Override // androidx.compose.ui.node.SemanticsModifierNode
    public final void N(SemanticsPropertyReceiver semanticsPropertyReceiver) {
        Role role = this.f4503g;
        if (role != null) {
            Intrinsics.checkNotNull(role);
            SemanticsPropertiesKt.r0(semanticsPropertyReceiver, role.p());
        }
        SemanticsPropertiesKt.A(semanticsPropertyReceiver, this.f4502f, new Function0<Boolean>() { // from class: androidx.compose.foundation.AbstractClickableNode$applySemantics$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Boolean invoke() {
                this.f4517a.G2().invoke();
                return Boolean.TRUE;
            }
        });
        if (this.f4504h) {
            this.f4507k.N(semanticsPropertyReceiver);
        } else {
            SemanticsPropertiesKt.l(semanticsPropertyReceiver);
        }
        z2(semanticsPropertyReceiver);
    }

    protected final Unit N2() {
        SuspendingPointerInputModifierNode suspendingPointerInputModifierNode = this.f4508l;
        if (suspendingPointerInputModifierNode == null) {
            return null;
        }
        suspendingPointerInputModifierNode.O0();
        return Unit.f139807a;
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x0068  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected final void P2(androidx.compose.foundation.interaction.MutableInteractionSource r3, androidx.compose.foundation.IndicationNodeFactory r4, boolean r5, java.lang.String r6, androidx.compose.ui.semantics.Role r7, kotlin.jvm.functions.Function0 r8) {
        /*
            r2 = this;
            androidx.compose.foundation.interaction.MutableInteractionSource r0 = r2.f4514r
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r3)
            r1 = 1
            if (r0 != 0) goto L12
            r2.C2()
            r2.f4514r = r3
            r2.f4500c = r3
            r3 = r1
            goto L13
        L12:
            r3 = 0
        L13:
            androidx.compose.foundation.IndicationNodeFactory r0 = r2.f4501d
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r4)
            if (r0 != 0) goto L1e
            r2.f4501d = r4
            r3 = r1
        L1e:
            boolean r4 = r2.f4504h
            if (r4 == r5) goto L37
            if (r5 == 0) goto L2a
            androidx.compose.foundation.FocusableNode r4 = r2.f4507k
            r2.m2(r4)
            goto L32
        L2a:
            androidx.compose.foundation.FocusableNode r4 = r2.f4507k
            r2.p2(r4)
            r2.C2()
        L32:
            androidx.compose.ui.node.SemanticsModifierNodeKt.b(r2)
            r2.f4504h = r5
        L37:
            java.lang.String r4 = r2.f4502f
            boolean r4 = kotlin.jvm.internal.Intrinsics.areEqual(r4, r6)
            if (r4 != 0) goto L44
            r2.f4502f = r6
            androidx.compose.ui.node.SemanticsModifierNodeKt.b(r2)
        L44:
            androidx.compose.ui.semantics.Role r4 = r2.f4503g
            boolean r4 = kotlin.jvm.internal.Intrinsics.areEqual(r4, r7)
            if (r4 != 0) goto L51
            r2.f4503g = r7
            androidx.compose.ui.node.SemanticsModifierNodeKt.b(r2)
        L51:
            r2.f4505i = r8
            boolean r4 = r2.f4515s
            boolean r5 = r2.O2()
            if (r4 == r5) goto L68
            boolean r4 = r2.O2()
            r2.f4515s = r4
            if (r4 != 0) goto L68
            androidx.compose.ui.node.DelegatableNode r4 = r2.f4509m
            if (r4 != 0) goto L68
            goto L69
        L68:
            r1 = r3
        L69:
            if (r1 == 0) goto L7e
            androidx.compose.ui.node.DelegatableNode r3 = r2.f4509m
            if (r3 != 0) goto L73
            boolean r4 = r2.f4515s
            if (r4 != 0) goto L7e
        L73:
            if (r3 == 0) goto L78
            r2.p2(r3)
        L78:
            r3 = 0
            r2.f4509m = r3
            r2.I2()
        L7e:
            androidx.compose.foundation.FocusableNode r3 = r2.f4507k
            androidx.compose.foundation.interaction.MutableInteractionSource r4 = r2.f4500c
            r3.B2(r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.AbstractClickableNode.P2(androidx.compose.foundation.interaction.MutableInteractionSource, androidx.compose.foundation.IndicationNodeFactory, boolean, java.lang.String, androidx.compose.ui.semantics.Role, kotlin.jvm.functions.Function0):void");
    }

    @Override // androidx.compose.ui.input.key.KeyInputModifierNode
    public final boolean R0(KeyEvent keyEvent) {
        return false;
    }

    @Override // androidx.compose.ui.node.TraversableNode
    public Object U() {
        return this.f4516t;
    }

    @Override // androidx.compose.ui.node.SemanticsModifierNode
    public final boolean d2() {
        return true;
    }

    @Override // androidx.compose.ui.node.PointerInputModifierNode
    public final void g0(PointerEvent pointerEvent, PointerEventPass pointerEventPass, long j3) {
        long jB = IntSizeKt.b(j3);
        this.f4513q = Offset.e((((long) Float.floatToRawIntBits(IntOffset.k(jB))) << 32) | (((long) Float.floatToRawIntBits(IntOffset.l(jB))) & 4294967295L));
        I2();
        if (this.f4504h && pointerEventPass == PointerEventPass.f26831b) {
            int iH = pointerEvent.h();
            PointerEventType.Companion companion = PointerEventType.f26835b;
            if (PointerEventType.j(iH, companion.a())) {
                BuildersKt__Builders_commonKt.d(getCoroutineScope(), null, null, new AbstractClickableNode$onPointerEvent$1(this, null), 3, null);
            } else if (PointerEventType.j(iH, companion.b())) {
                BuildersKt__Builders_commonKt.d(getCoroutineScope(), null, null, new AbstractClickableNode$onPointerEvent$2(this, null), 3, null);
            }
        }
        if (this.f4508l == null) {
            this.f4508l = (SuspendingPointerInputModifierNode) m2(SuspendingPointerInputFilterKt.a(new PointerInputEventHandler() { // from class: androidx.compose.foundation.AbstractClickableNode$onPointerEvent$3
                @Override // androidx.compose.ui.input.pointer.PointerInputEventHandler
                public final Object invoke(PointerInputScope pointerInputScope, Continuation continuation) {
                    Object objA2 = this.f4549a.A2(pointerInputScope, continuation);
                    return objA2 == IntrinsicsKt.f() ? objA2 : Unit.f139807a;
                }
            }));
        }
        SuspendingPointerInputModifierNode suspendingPointerInputModifierNode = this.f4508l;
        if (suspendingPointerInputModifierNode != null) {
            suspendingPointerInputModifierNode.g0(pointerEvent, pointerEventPass, j3);
        }
    }

    @Override // androidx.compose.ui.Modifier.Node
    public final boolean getShouldAutoInvalidate() {
        return this.f4506j;
    }

    @Override // androidx.compose.ui.input.key.KeyInputModifierNode
    public final boolean o1(KeyEvent keyEvent) {
        boolean z2;
        I2();
        long jA = KeyEvent_androidKt.a(keyEvent);
        if (this.f4504h && ClickableKt.n(keyEvent)) {
            if (this.f4512p.a(jA)) {
                z2 = false;
            } else {
                PressInteraction.Press press = new PressInteraction.Press(this.f4513q, null);
                this.f4512p.r(jA, press);
                if (this.f4500c != null) {
                    BuildersKt__Builders_commonKt.d(getCoroutineScope(), null, null, new AbstractClickableNode$onKeyEvent$1(this, press, null), 3, null);
                }
                z2 = true;
            }
            return K2(keyEvent) || z2;
        }
        if (this.f4504h && ClickableKt.l(keyEvent)) {
            PressInteraction.Press press2 = (PressInteraction.Press) this.f4512p.o(jA);
            if (press2 != null) {
                if (this.f4500c != null) {
                    BuildersKt__Builders_commonKt.d(getCoroutineScope(), null, null, new AbstractClickableNode$onKeyEvent$2(this, press2, null), 3, null);
                }
                L2(keyEvent);
            }
            if (press2 != null) {
                return true;
            }
        }
        return false;
    }

    @Override // androidx.compose.ui.Modifier.Node
    public final void onAttach() {
        if (!this.f4515s) {
            I2();
        }
        if (this.f4504h) {
            m2(this.f4507k);
        }
    }

    @Override // androidx.compose.ui.Modifier.Node
    public final void onDetach() {
        C2();
        if (this.f4514r == null) {
            this.f4500c = null;
        }
        DelegatableNode delegatableNode = this.f4509m;
        if (delegatableNode != null) {
            p2(delegatableNode);
        }
        this.f4509m = null;
    }

    @Override // androidx.compose.ui.node.PointerInputModifierNode
    public final void u1() {
        HoverInteraction.Enter enter;
        MutableInteractionSource mutableInteractionSource = this.f4500c;
        if (mutableInteractionSource != null && (enter = this.f4511o) != null) {
            mutableInteractionSource.b(new HoverInteraction.Exit(enter));
        }
        this.f4511o = null;
        SuspendingPointerInputModifierNode suspendingPointerInputModifierNode = this.f4508l;
        if (suspendingPointerInputModifierNode != null) {
            suspendingPointerInputModifierNode.u1();
        }
    }

    private AbstractClickableNode(MutableInteractionSource mutableInteractionSource, IndicationNodeFactory indicationNodeFactory, boolean z2, String str, Role role, Function0 function0) {
        this.f4500c = mutableInteractionSource;
        this.f4501d = indicationNodeFactory;
        this.f4502f = str;
        this.f4503g = role;
        this.f4504h = z2;
        this.f4505i = function0;
        this.f4507k = new FocusableNode(this.f4500c, Focusability.f25566b.c(), new AbstractClickableNode$focusableNode$1(this), null);
        this.f4512p = LongObjectMapKt.c();
        this.f4513q = Offset.f25596b.c();
        this.f4514r = this.f4500c;
        this.f4515s = O2();
        this.f4516t = f4498u;
    }

    protected void J2() {
    }

    public void z2(SemanticsPropertyReceiver semanticsPropertyReceiver) {
    }
}
