package androidx.compose.ui.layout;

import androidx.collection.MutableScatterMap;
import androidx.collection.ScatterMapKt;
import androidx.compose.runtime.ComposeNodeLifecycleCallback;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionContext;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ReusableComposition;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.snapshots.Snapshot;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.internal.InlineClassHelperKt;
import androidx.compose.ui.layout.SubcomposeLayoutState;
import androidx.compose.ui.layout.SubcomposeSlotReusePolicy;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.LayoutNodeKt;
import androidx.compose.ui.node.LookaheadDelegate;
import androidx.compose.ui.node.LookaheadPassDelegate;
import androidx.compose.ui.node.MeasurePassDelegate;
import androidx.compose.ui.node.NodeChain;
import androidx.compose.ui.node.TraversableNodeKt;
import androidx.compose.ui.platform.SubcompositionKt;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.LayoutDirection;
import java.util.List;
import java.util.Map;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

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
public final class LayoutNodeSubcompositionsState implements ComposeNodeLifecycleCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final LayoutNode f27095a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private CompositionContext f27096b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private SubcomposeSlotReusePolicy f27097c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f27098d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f27099f;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private int f27108o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private int f27109p;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final MutableScatterMap f27100g = ScatterMapKt.c();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final MutableScatterMap f27101h = ScatterMapKt.c();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final Scope f27102i = new Scope();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final ApproachMeasureScopeImpl f27103j = new ApproachMeasureScopeImpl();

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final MutableScatterMap f27104k = ScatterMapKt.c();

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final SubcomposeSlotReusePolicy.SlotIdsSet f27105l = new SubcomposeSlotReusePolicy.SlotIdsSet(null, 1, null);

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final MutableScatterMap f27106m = ScatterMapKt.c();

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final MutableVector f27107n = new MutableVector(new Object[16], 0);

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private final String f27110q = "Asking for intrinsic measurements of SubcomposeLayout layouts is not supported. This includes components that are built on top of SubcomposeLayout, such as lazy lists, BoxWithConstraints, TabRow, etc. To mitigate this:\n- if intrinsic measurements are used to achieve 'match parent' sizing, consider replacing the parent of the component with a custom layout which controls the order in which children are measured, making intrinsic measurement not needed\n- adding a size modifier to the component, in order to fast return the queried intrinsic measurement.";

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    final class ApproachMeasureScopeImpl implements SubcomposeMeasureScope, MeasureScope {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final /* synthetic */ Scope f27111a;

        public ApproachMeasureScopeImpl() {
            this.f27111a = LayoutNodeSubcompositionsState.this.f27102i;
        }

        @Override // androidx.compose.ui.unit.Density
        public float F(int i3) {
            return this.f27111a.F(i3);
        }

        @Override // androidx.compose.ui.unit.Density
        public float G(float f3) {
            return this.f27111a.G(f3);
        }

        @Override // androidx.compose.ui.unit.Density
        public float J0(long j3) {
            return this.f27111a.J0(j3);
        }

        @Override // androidx.compose.ui.unit.FontScaling
        public float K1() {
            return this.f27111a.K1();
        }

        @Override // androidx.compose.ui.unit.Density
        public long M(long j3) {
            return this.f27111a.M(j3);
        }

        @Override // androidx.compose.ui.unit.Density
        public float M1(float f3) {
            return this.f27111a.M1(f3);
        }

        @Override // androidx.compose.ui.unit.Density
        public int T1(long j3) {
            return this.f27111a.T1(j3);
        }

        @Override // androidx.compose.ui.layout.MeasureScope
        public MeasureResult U1(int i3, int i4, Map map, Function1 function1, Function1 function12) {
            return this.f27111a.U1(i3, i4, map, function1, function12);
        }

        @Override // androidx.compose.ui.layout.SubcomposeMeasureScope
        public List V(Object obj, Function2 function2) {
            LayoutNode layoutNode = (LayoutNode) LayoutNodeSubcompositionsState.this.f27101h.e(obj);
            return (layoutNode == null || LayoutNodeSubcompositionsState.this.f27095a.W().indexOf(layoutNode) >= LayoutNodeSubcompositionsState.this.f27098d) ? LayoutNodeSubcompositionsState.this.t(obj, function2) : layoutNode.N();
        }

        @Override // androidx.compose.ui.layout.MeasureScope
        public MeasureResult c1(int i3, int i4, Map map, Function1 function1) {
            return this.f27111a.c1(i3, i4, map, function1);
        }

        @Override // androidx.compose.ui.unit.Density
        public float getDensity() {
            return this.f27111a.getDensity();
        }

        @Override // androidx.compose.ui.layout.IntrinsicMeasureScope
        public LayoutDirection getLayoutDirection() {
            return this.f27111a.getLayoutDirection();
        }

        @Override // androidx.compose.ui.unit.FontScaling
        public long n(float f3) {
            return this.f27111a.n(f3);
        }

        @Override // androidx.compose.ui.unit.Density
        public long o(long j3) {
            return this.f27111a.o(j3);
        }

        @Override // androidx.compose.ui.unit.FontScaling
        public float q(long j3) {
            return this.f27111a.q(j3);
        }

        @Override // androidx.compose.ui.layout.IntrinsicMeasureScope
        public boolean q0() {
            return this.f27111a.q0();
        }

        @Override // androidx.compose.ui.unit.Density
        public long v(float f3) {
            return this.f27111a.v(f3);
        }

        @Override // androidx.compose.ui.unit.Density
        public int z0(float f3) {
            return this.f27111a.z0(f3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    final class Scope implements SubcomposeMeasureScope {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private LayoutDirection f27119a = LayoutDirection.f30002b;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private float f27120b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private float f27121c;

        public Scope() {
        }

        @Override // androidx.compose.ui.unit.FontScaling
        public float K1() {
            return this.f27121c;
        }

        @Override // androidx.compose.ui.layout.MeasureScope
        public MeasureResult U1(final int i3, final int i4, final Map map, final Function1 function1, final Function1 function12) {
            if (!((i3 & (-16777216)) == 0 && ((-16777216) & i4) == 0)) {
                InlineClassHelperKt.c("Size(" + i3 + " x " + i4 + ") is out of range. Each dimension must be between 0 and 16777215.");
            }
            final LayoutNodeSubcompositionsState layoutNodeSubcompositionsState = LayoutNodeSubcompositionsState.this;
            return new MeasureResult() { // from class: androidx.compose.ui.layout.LayoutNodeSubcompositionsState$Scope$layout$1
                @Override // androidx.compose.ui.layout.MeasureResult
                public void A() {
                    LookaheadDelegate lookaheadDelegateS2;
                    if (!this.q0() || (lookaheadDelegateS2 = layoutNodeSubcompositionsState.f27095a.Z().S2()) == null) {
                        function12.invoke(layoutNodeSubcompositionsState.f27095a.Z().B1());
                    } else {
                        function12.invoke(lookaheadDelegateS2.B1());
                    }
                }

                @Override // androidx.compose.ui.layout.MeasureResult
                public Function1 B() {
                    return function1;
                }

                @Override // androidx.compose.ui.layout.MeasureResult
                public int getHeight() {
                    return i4;
                }

                @Override // androidx.compose.ui.layout.MeasureResult
                public int getWidth() {
                    return i3;
                }

                @Override // androidx.compose.ui.layout.MeasureResult
                public Map z() {
                    return map;
                }
            };
        }

        @Override // androidx.compose.ui.layout.SubcomposeMeasureScope
        public List V(Object obj, Function2 function2) {
            return LayoutNodeSubcompositionsState.this.J(obj, function2);
        }

        @Override // androidx.compose.ui.unit.Density
        public float getDensity() {
            return this.f27120b;
        }

        @Override // androidx.compose.ui.layout.IntrinsicMeasureScope
        public LayoutDirection getLayoutDirection() {
            return this.f27119a;
        }

        public void m(float f3) {
            this.f27120b = f3;
        }

        public void p(float f3) {
            this.f27121c = f3;
        }

        @Override // androidx.compose.ui.layout.IntrinsicMeasureScope
        public boolean q0() {
            return LayoutNodeSubcompositionsState.this.f27095a.h0() == LayoutNode.LayoutState.f27387d || LayoutNodeSubcompositionsState.this.f27095a.h0() == LayoutNode.LayoutState.f27385b;
        }

        public void u(LayoutDirection layoutDirection) {
            this.f27119a = layoutDirection;
        }
    }

    public LayoutNodeSubcompositionsState(LayoutNode layoutNode, SubcomposeSlotReusePolicy subcomposeSlotReusePolicy) {
        this.f27095a = layoutNode;
        this.f27097c = subcomposeSlotReusePolicy;
    }

    private final Object A(List list, int i3) {
        Object objE = this.f27100g.e((LayoutNode) list.get(i3));
        Intrinsics.checkNotNull(objE);
        return ((NodeState) objE).f();
    }

    private final void C(boolean z2) {
        this.f27109p = 0;
        this.f27104k.k();
        List listW = this.f27095a.W();
        int size = listW.size();
        if (this.f27108o != size) {
            this.f27108o = size;
            Snapshot.Companion companion = Snapshot.f24914e;
            Snapshot snapshotD = companion.d();
            Function1 function1G = snapshotD != null ? snapshotD.g() : null;
            Snapshot snapshotE = companion.e(snapshotD);
            for (int i3 = 0; i3 < size; i3++) {
                try {
                    LayoutNode layoutNode = (LayoutNode) listW.get(i3);
                    NodeState nodeState = (NodeState) this.f27100g.e(layoutNode);
                    if (nodeState != null && nodeState.a()) {
                        G(layoutNode);
                        if (z2) {
                            ReusableComposition reusableCompositionB = nodeState.b();
                            if (reusableCompositionB != null) {
                                reusableCompositionB.deactivate();
                            }
                            nodeState.h(SnapshotStateKt__SnapshotStateKt.e(Boolean.FALSE, null, 2, null));
                        } else {
                            nodeState.g(false);
                        }
                        nodeState.m(SubcomposeLayoutKt.f27217a);
                    }
                } catch (Throwable th) {
                    companion.m(snapshotD, snapshotE, function1G);
                    throw th;
                }
            }
            Unit unit = Unit.f139807a;
            companion.m(snapshotD, snapshotE, function1G);
            this.f27101h.k();
        }
        B();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void D(int i3, int i4, int i5) {
        LayoutNode layoutNode = this.f27095a;
        layoutNode.f27376t = true;
        this.f27095a.n1(i3, i4, i5);
        layoutNode.f27376t = false;
    }

    static /* synthetic */ void E(LayoutNodeSubcompositionsState layoutNodeSubcompositionsState, int i3, int i4, int i5, int i6, Object obj) {
        if ((i6 & 4) != 0) {
            i5 = 1;
        }
        layoutNodeSubcompositionsState.D(i3, i4, i5);
    }

    private final void G(LayoutNode layoutNode) {
        MeasurePassDelegate measurePassDelegateN0 = layoutNode.n0();
        LayoutNode.UsageByParent usageByParent = LayoutNode.UsageByParent.f27394c;
        measurePassDelegateN0.E2(usageByParent);
        LookaheadPassDelegate lookaheadPassDelegateK0 = layoutNode.k0();
        if (lookaheadPassDelegateK0 != null) {
            lookaheadPassDelegateK0.C2(usageByParent);
        }
    }

    private final void K(LayoutNode layoutNode, final NodeState nodeState) {
        Snapshot.Companion companion = Snapshot.f24914e;
        Snapshot snapshotD = companion.d();
        Function1 function1G = snapshotD != null ? snapshotD.g() : null;
        Snapshot snapshotE = companion.e(snapshotD);
        try {
            LayoutNode layoutNode2 = this.f27095a;
            layoutNode2.f27376t = true;
            final Function2 function2C = nodeState.c();
            ReusableComposition reusableCompositionB = nodeState.b();
            CompositionContext compositionContext = this.f27096b;
            if (compositionContext == null) {
                InlineClassHelperKt.d("parent composition reference not set");
                throw new KotlinNothingValueException();
            }
            nodeState.i(M(reusableCompositionB, layoutNode, nodeState.e(), compositionContext, ComposableLambdaKt.c(-1750409193, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.ui.layout.LayoutNodeSubcompositionsState$subcompose$3$1$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.f139807a;
                }

                public final void invoke(Composer composer, int i3) {
                    if (!composer.r((i3 & 3) != 2, i3 & 1)) {
                        composer.Q();
                        return;
                    }
                    if (ComposerKt.M()) {
                        ComposerKt.U(-1750409193, i3, -1, "androidx.compose.ui.layout.LayoutNodeSubcompositionsState.subcompose.<anonymous>.<anonymous>.<anonymous> (SubcomposeLayout.kt:522)");
                    }
                    boolean zA = nodeState.a();
                    Function2 function2 = function2C;
                    composer.O(207, Boolean.valueOf(zA));
                    boolean zB = composer.b(zA);
                    if (zA) {
                        function2.invoke(composer, 0);
                    } else {
                        composer.j(zB);
                    }
                    composer.E();
                    if (ComposerKt.M()) {
                        ComposerKt.T();
                    }
                }
            })));
            nodeState.l(false);
            layoutNode2.f27376t = false;
            Unit unit = Unit.f139807a;
            companion.m(snapshotD, snapshotE, function1G);
        } catch (Throwable th) {
            companion.m(snapshotD, snapshotE, function1G);
            throw th;
        }
    }

    private final void L(LayoutNode layoutNode, Object obj, Function2 function2) {
        MutableScatterMap mutableScatterMap = this.f27100g;
        Object objE = mutableScatterMap.e(layoutNode);
        if (objE == null) {
            NodeState nodeState = new NodeState(obj, ComposableSingletons$SubcomposeLayoutKt.f27051a.a(), null, 4, null);
            mutableScatterMap.x(layoutNode, nodeState);
            objE = nodeState;
        }
        NodeState nodeState2 = (NodeState) objE;
        ReusableComposition reusableCompositionB = nodeState2.b();
        boolean zS = reusableCompositionB != null ? reusableCompositionB.s() : true;
        if (nodeState2.c() != function2 || zS || nodeState2.d()) {
            nodeState2.j(function2);
            K(layoutNode, nodeState2);
            nodeState2.k(false);
        }
    }

    private final ReusableComposition M(ReusableComposition reusableComposition, LayoutNode layoutNode, boolean z2, CompositionContext compositionContext, Function2 function2) {
        if (reusableComposition == null || reusableComposition.e()) {
            reusableComposition = SubcompositionKt.a(layoutNode, compositionContext);
        }
        if (z2) {
            reusableComposition.q(function2);
            return reusableComposition;
        }
        reusableComposition.f(function2);
        return reusableComposition;
    }

    private final LayoutNode N(Object obj) {
        int i3;
        if (this.f27108o == 0) {
            return null;
        }
        List listW = this.f27095a.W();
        int size = listW.size() - this.f27109p;
        int i4 = size - this.f27108o;
        int i5 = size - 1;
        int i6 = i5;
        while (true) {
            if (i6 < i4) {
                i3 = -1;
                break;
            }
            if (Intrinsics.areEqual(A(listW, i6), obj)) {
                i3 = i6;
                break;
            }
            i6--;
        }
        if (i3 == -1) {
            while (i5 >= i4) {
                Object objE = this.f27100g.e((LayoutNode) listW.get(i5));
                Intrinsics.checkNotNull(objE);
                NodeState nodeState = (NodeState) objE;
                if (nodeState.f() == SubcomposeLayoutKt.f27217a || this.f27097c.b(obj, nodeState.f())) {
                    nodeState.m(obj);
                    i6 = i5;
                    i3 = i6;
                    break;
                }
                i5--;
            }
            i6 = i5;
        }
        if (i3 == -1) {
            return null;
        }
        if (i6 != i4) {
            D(i6, i4, 1);
        }
        this.f27108o--;
        LayoutNode layoutNode = (LayoutNode) listW.get(i4);
        Object objE2 = this.f27100g.e(layoutNode);
        Intrinsics.checkNotNull(objE2);
        NodeState nodeState2 = (NodeState) objE2;
        nodeState2.h(SnapshotStateKt__SnapshotStateKt.e(Boolean.TRUE, null, 2, null));
        nodeState2.l(true);
        nodeState2.k(true);
        return layoutNode;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List t(Object obj, Function2 function2) {
        if (!(this.f27107n.o() >= this.f27099f)) {
            InlineClassHelperKt.a("Error: currentApproachIndex cannot be greater than the size of theapproachComposedSlotIds list.");
        }
        int iO = this.f27107n.o();
        int i3 = this.f27099f;
        if (iO == i3) {
            this.f27107n.b(obj);
        } else {
            this.f27107n.y(i3, obj);
        }
        this.f27099f++;
        if (!this.f27104k.b(obj)) {
            this.f27106m.x(obj, F(obj, function2));
            if (this.f27095a.h0() == LayoutNode.LayoutState.f27386c) {
                this.f27095a.z1(true);
            } else {
                LayoutNode.C1(this.f27095a, true, false, false, 6, null);
            }
        }
        LayoutNode layoutNode = (LayoutNode) this.f27104k.e(obj);
        if (layoutNode != null) {
            List listA1 = layoutNode.n0().A1();
            int size = listA1.size();
            for (int i4 = 0; i4 < size; i4++) {
                ((MeasurePassDelegate) listA1.get(i4)).n2();
            }
            if (listA1 != null) {
                return listA1;
            }
        }
        return CollectionsKt.emptyList();
    }

    private final LayoutNode v(int i3) {
        LayoutNode layoutNode = new LayoutNode(true, 0, 2, null);
        LayoutNode layoutNode2 = this.f27095a;
        layoutNode2.f27376t = true;
        this.f27095a.M0(i3, layoutNode);
        layoutNode2.f27376t = false;
        return layoutNode;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x004e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void w() {
        /*
            r15 = this;
            androidx.compose.ui.node.LayoutNode r0 = r15.f27095a
            r1 = 1
            androidx.compose.ui.node.LayoutNode.s(r0, r1)
            androidx.collection.MutableScatterMap r1 = r15.f27100g
            java.lang.Object[] r2 = r1.f3110c
            long[] r1 = r1.f3108a
            int r3 = r1.length
            int r3 = r3 + (-2)
            r4 = 0
            if (r3 < 0) goto L53
            r5 = r4
        L13:
            r6 = r1[r5]
            long r8 = ~r6
            r10 = 7
            long r8 = r8 << r10
            long r8 = r8 & r6
            r10 = -9187201950435737472(0x8080808080808080, double:-2.937446524422997E-306)
            long r8 = r8 & r10
            int r8 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
            if (r8 == 0) goto L4e
            int r8 = r5 - r3
            int r8 = ~r8
            int r8 = r8 >>> 31
            r9 = 8
            int r8 = 8 - r8
            r10 = r4
        L2d:
            if (r10 >= r8) goto L4c
            r11 = 255(0xff, double:1.26E-321)
            long r11 = r11 & r6
            r13 = 128(0x80, double:6.3E-322)
            int r11 = (r11 > r13 ? 1 : (r11 == r13 ? 0 : -1))
            if (r11 >= 0) goto L48
            int r11 = r5 << 3
            int r11 = r11 + r10
            r11 = r2[r11]
            androidx.compose.ui.layout.LayoutNodeSubcompositionsState$NodeState r11 = (androidx.compose.ui.layout.LayoutNodeSubcompositionsState.NodeState) r11
            androidx.compose.runtime.ReusableComposition r11 = r11.b()
            if (r11 == 0) goto L48
            r11.dispose()
        L48:
            long r6 = r6 >> r9
            int r10 = r10 + 1
            goto L2d
        L4c:
            if (r8 != r9) goto L53
        L4e:
            if (r5 == r3) goto L53
            int r5 = r5 + 1
            goto L13
        L53:
            androidx.compose.ui.node.LayoutNode r1 = r15.f27095a
            r1.v1()
            androidx.compose.ui.node.LayoutNode.s(r0, r4)
            androidx.collection.MutableScatterMap r0 = r15.f27100g
            r0.k()
            androidx.collection.MutableScatterMap r0 = r15.f27101h
            r0.k()
            r15.f27109p = r4
            r15.f27108o = r4
            androidx.collection.MutableScatterMap r0 = r15.f27104k
            r0.k()
            r15.B()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.layout.LayoutNodeSubcompositionsState.w():void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void y() {
        MutableScatterMap mutableScatterMap = this.f27106m;
        long[] jArr = mutableScatterMap.f3108a;
        int length = jArr.length - 2;
        if (length < 0) {
            return;
        }
        int i3 = 0;
        while (true) {
            long j3 = jArr[i3];
            if ((((~j3) << 7) & j3 & (-9187201950435737472L)) != -9187201950435737472L) {
                int i4 = 8 - ((~(i3 - length)) >>> 31);
                for (int i5 = 0; i5 < i4; i5++) {
                    if ((255 & j3) < 128) {
                        int i6 = (i3 << 3) + i5;
                        Object obj = mutableScatterMap.f3109b[i6];
                        SubcomposeLayoutState.PrecomposedSlotHandle precomposedSlotHandle = (SubcomposeLayoutState.PrecomposedSlotHandle) mutableScatterMap.f3110c[i6];
                        int iP = this.f27107n.p(obj);
                        if (iP < 0 || iP >= this.f27099f) {
                            precomposedSlotHandle.dispose();
                            mutableScatterMap.v(i6);
                        }
                    }
                    j3 >>= 8;
                }
                if (i4 != 8) {
                    return;
                }
            }
            if (i3 == length) {
                return;
            } else {
                i3++;
            }
        }
    }

    public final void B() {
        int size = this.f27095a.W().size();
        if (!(this.f27100g.g() == size)) {
            InlineClassHelperKt.a("Inconsistency between the count of nodes tracked by the state (" + this.f27100g.g() + ") and the children count on the SubcomposeLayout (" + size + "). Are you trying to use the state of the disposed SubcomposeLayout?");
        }
        if (!((size - this.f27108o) - this.f27109p >= 0)) {
            InlineClassHelperKt.a("Incorrect state. Total children " + size + ". Reusable children " + this.f27108o + ". Precomposed children " + this.f27109p);
        }
        if (this.f27104k.g() == this.f27109p) {
            return;
        }
        InlineClassHelperKt.a("Incorrect state. Precomposed children " + this.f27109p + ". Map size " + this.f27104k.g());
    }

    public final SubcomposeLayoutState.PrecomposedSlotHandle F(final Object obj, Function2 function2) {
        if (!this.f27095a.m()) {
            return new SubcomposeLayoutState.PrecomposedSlotHandle() { // from class: androidx.compose.ui.layout.LayoutNodeSubcompositionsState$precompose$1
                @Override // androidx.compose.ui.layout.SubcomposeLayoutState.PrecomposedSlotHandle
                public void dispose() {
                }
            };
        }
        B();
        if (!this.f27101h.c(obj)) {
            this.f27106m.u(obj);
            MutableScatterMap mutableScatterMap = this.f27104k;
            Object objE = mutableScatterMap.e(obj);
            if (objE == null) {
                objE = N(obj);
                if (objE != null) {
                    D(this.f27095a.W().indexOf(objE), this.f27095a.W().size(), 1);
                    this.f27109p++;
                } else {
                    objE = v(this.f27095a.W().size());
                    this.f27109p++;
                }
                mutableScatterMap.x(obj, objE);
            }
            L((LayoutNode) objE, obj, function2);
        }
        return new SubcomposeLayoutState.PrecomposedSlotHandle() { // from class: androidx.compose.ui.layout.LayoutNodeSubcompositionsState$precompose$2
            @Override // androidx.compose.ui.layout.SubcomposeLayoutState.PrecomposedSlotHandle
            public void a(Object obj2, Function1 function1) {
                NodeChain nodeChainU0;
                Modifier.Node nodeK;
                LayoutNode layoutNode = (LayoutNode) this.f27142a.f27104k.e(obj);
                if (layoutNode == null || (nodeChainU0 = layoutNode.u0()) == null || (nodeK = nodeChainU0.k()) == null) {
                    return;
                }
                TraversableNodeKt.e(nodeK, obj2, function1);
            }

            @Override // androidx.compose.ui.layout.SubcomposeLayoutState.PrecomposedSlotHandle
            public void b(int i3, long j3) {
                LayoutNode layoutNode = (LayoutNode) this.f27142a.f27104k.e(obj);
                if (layoutNode == null || !layoutNode.m()) {
                    return;
                }
                int size = layoutNode.O().size();
                if (i3 < 0 || i3 >= size) {
                    InlineClassHelperKt.e("Index (" + i3 + ") is out of bound of [0, " + size + ')');
                }
                if (layoutNode.u()) {
                    InlineClassHelperKt.a("Pre-measure called on node that is not placed");
                }
                LayoutNode layoutNode2 = this.f27142a.f27095a;
                layoutNode2.f27376t = true;
                LayoutNodeKt.b(layoutNode).w((LayoutNode) layoutNode.O().get(i3), j3);
                layoutNode2.f27376t = false;
            }

            @Override // androidx.compose.ui.layout.SubcomposeLayoutState.PrecomposedSlotHandle
            public int d() {
                List listO;
                LayoutNode layoutNode = (LayoutNode) this.f27142a.f27104k.e(obj);
                if (layoutNode == null || (listO = layoutNode.O()) == null) {
                    return 0;
                }
                return listO.size();
            }

            @Override // androidx.compose.ui.layout.SubcomposeLayoutState.PrecomposedSlotHandle
            public void dispose() {
                this.f27142a.B();
                LayoutNode layoutNode = (LayoutNode) this.f27142a.f27104k.u(obj);
                if (layoutNode != null) {
                    if (!(this.f27142a.f27109p > 0)) {
                        InlineClassHelperKt.c("No pre-composed items to dispose");
                    }
                    int iIndexOf = this.f27142a.f27095a.W().indexOf(layoutNode);
                    if (!(iIndexOf >= this.f27142a.f27095a.W().size() - this.f27142a.f27109p)) {
                        InlineClassHelperKt.c("Item is not in pre-composed item range");
                    }
                    this.f27142a.f27108o++;
                    LayoutNodeSubcompositionsState layoutNodeSubcompositionsState = this.f27142a;
                    layoutNodeSubcompositionsState.f27109p--;
                    int size = (this.f27142a.f27095a.W().size() - this.f27142a.f27109p) - this.f27142a.f27108o;
                    this.f27142a.D(iIndexOf, size, 1);
                    this.f27142a.x(size);
                }
            }
        };
    }

    public final void H(CompositionContext compositionContext) {
        this.f27096b = compositionContext;
    }

    public final void I(SubcomposeSlotReusePolicy subcomposeSlotReusePolicy) {
        if (this.f27097c != subcomposeSlotReusePolicy) {
            this.f27097c = subcomposeSlotReusePolicy;
            C(false);
            LayoutNode.G1(this.f27095a, false, false, false, 7, null);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x00a2  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.util.List J(java.lang.Object r13, kotlin.jvm.functions.Function2 r14) {
        /*
            r12 = this;
            r12.B()
            androidx.compose.ui.node.LayoutNode r0 = r12.f27095a
            androidx.compose.ui.node.LayoutNode$LayoutState r0 = r0.h0()
            androidx.compose.ui.node.LayoutNode$LayoutState r1 = androidx.compose.ui.node.LayoutNode.LayoutState.f27384a
            r2 = 0
            r3 = 1
            if (r0 == r1) goto L1e
            androidx.compose.ui.node.LayoutNode$LayoutState r4 = androidx.compose.ui.node.LayoutNode.LayoutState.f27386c
            if (r0 == r4) goto L1e
            androidx.compose.ui.node.LayoutNode$LayoutState r4 = androidx.compose.ui.node.LayoutNode.LayoutState.f27385b
            if (r0 == r4) goto L1e
            androidx.compose.ui.node.LayoutNode$LayoutState r4 = androidx.compose.ui.node.LayoutNode.LayoutState.f27387d
            if (r0 != r4) goto L1c
            goto L1e
        L1c:
            r4 = r2
            goto L1f
        L1e:
            r4 = r3
        L1f:
            if (r4 != 0) goto L26
            java.lang.String r4 = "subcompose can only be used inside the measure or layout blocks"
            androidx.compose.ui.internal.InlineClassHelperKt.c(r4)
        L26:
            androidx.collection.MutableScatterMap r4 = r12.f27101h
            java.lang.Object r5 = r4.e(r13)
            if (r5 != 0) goto L5c
            androidx.collection.MutableScatterMap r5 = r12.f27104k
            java.lang.Object r5 = r5.u(r13)
            androidx.compose.ui.node.LayoutNode r5 = (androidx.compose.ui.node.LayoutNode) r5
            if (r5 == 0) goto L4d
            int r6 = r12.f27109p
            if (r6 <= 0) goto L3e
            r6 = r3
            goto L3f
        L3e:
            r6 = r2
        L3f:
            if (r6 != 0) goto L46
            java.lang.String r6 = "Check failed."
            androidx.compose.ui.internal.InlineClassHelperKt.c(r6)
        L46:
            int r6 = r12.f27109p
            int r6 = r6 + (-1)
            r12.f27109p = r6
            goto L59
        L4d:
            androidx.compose.ui.node.LayoutNode r5 = r12.N(r13)
            if (r5 != 0) goto L59
            int r5 = r12.f27098d
            androidx.compose.ui.node.LayoutNode r5 = r12.v(r5)
        L59:
            r4.x(r13, r5)
        L5c:
            androidx.compose.ui.node.LayoutNode r5 = (androidx.compose.ui.node.LayoutNode) r5
            androidx.compose.ui.node.LayoutNode r4 = r12.f27095a
            java.util.List r4 = r4.W()
            int r6 = r12.f27098d
            java.lang.Object r4 = kotlin.collections.CollectionsKt.getOrNull(r4, r6)
            if (r4 == r5) goto La2
            androidx.compose.ui.node.LayoutNode r4 = r12.f27095a
            java.util.List r4 = r4.W()
            int r7 = r4.indexOf(r5)
            int r4 = r12.f27098d
            if (r7 < r4) goto L7b
            r2 = r3
        L7b:
            if (r2 != 0) goto L96
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r4 = "Key \""
            r2.append(r4)
            r2.append(r13)
            java.lang.String r4 = "\" was already used. If you are using LazyColumn/Row please make sure you provide a unique key for each item."
            r2.append(r4)
            java.lang.String r2 = r2.toString()
            androidx.compose.ui.internal.InlineClassHelperKt.a(r2)
        L96:
            int r8 = r12.f27098d
            if (r8 == r7) goto La2
            r10 = 4
            r11 = 0
            r9 = 0
            r6 = r12
            E(r6, r7, r8, r9, r10, r11)
            goto La3
        La2:
            r6 = r12
        La3:
            int r2 = r6.f27098d
            int r2 = r2 + r3
            r6.f27098d = r2
            r12.L(r5, r13, r14)
            if (r0 == r1) goto Lb7
            androidx.compose.ui.node.LayoutNode$LayoutState r13 = androidx.compose.ui.node.LayoutNode.LayoutState.f27386c
            if (r0 != r13) goto Lb2
            goto Lb7
        Lb2:
            java.util.List r13 = r5.M()
            return r13
        Lb7:
            java.util.List r13 = r5.N()
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.layout.LayoutNodeSubcompositionsState.J(java.lang.Object, kotlin.jvm.functions.Function2):java.util.List");
    }

    @Override // androidx.compose.runtime.ComposeNodeLifecycleCallback
    public void b() {
        w();
    }

    @Override // androidx.compose.runtime.ComposeNodeLifecycleCallback
    public void f() {
        C(true);
    }

    @Override // androidx.compose.runtime.ComposeNodeLifecycleCallback
    public void i() {
        C(false);
    }

    public final MeasurePolicy u(final Function2 function2) {
        final String str = this.f27110q;
        return new LayoutNode.NoIntrinsicsMeasurePolicy(str) { // from class: androidx.compose.ui.layout.LayoutNodeSubcompositionsState$createMeasurePolicy$1
            @Override // androidx.compose.ui.layout.MeasurePolicy
            /* JADX INFO: renamed from: measure-3p2s80s */
            public MeasureResult mo10measure3p2s80s(MeasureScope measureScope, List list, long j3) {
                this.f27130b.f27102i.u(measureScope.getLayoutDirection());
                this.f27130b.f27102i.m(measureScope.getDensity());
                this.f27130b.f27102i.p(measureScope.K1());
                if (measureScope.q0() || this.f27130b.f27095a.l0() == null) {
                    this.f27130b.f27098d = 0;
                    final MeasureResult measureResult = (MeasureResult) function2.invoke(this.f27130b.f27102i, Constraints.a(j3));
                    final int i3 = this.f27130b.f27098d;
                    final LayoutNodeSubcompositionsState layoutNodeSubcompositionsState = this.f27130b;
                    return new MeasureResult() { // from class: androidx.compose.ui.layout.LayoutNodeSubcompositionsState$createMeasurePolicy$1$measure-3p2s80s$$inlined$createMeasureResult$2
                        @Override // androidx.compose.ui.layout.MeasureResult
                        public void A() {
                            layoutNodeSubcompositionsState.f27098d = i3;
                            measureResult.A();
                            LayoutNodeSubcompositionsState layoutNodeSubcompositionsState2 = layoutNodeSubcompositionsState;
                            layoutNodeSubcompositionsState2.x(layoutNodeSubcompositionsState2.f27098d);
                        }

                        @Override // androidx.compose.ui.layout.MeasureResult
                        public Function1 B() {
                            return measureResult.B();
                        }

                        @Override // androidx.compose.ui.layout.MeasureResult
                        public int getHeight() {
                            return measureResult.getHeight();
                        }

                        @Override // androidx.compose.ui.layout.MeasureResult
                        public int getWidth() {
                            return measureResult.getWidth();
                        }

                        @Override // androidx.compose.ui.layout.MeasureResult
                        public Map z() {
                            return measureResult.z();
                        }
                    };
                }
                this.f27130b.f27099f = 0;
                final MeasureResult measureResult2 = (MeasureResult) function2.invoke(this.f27130b.f27103j, Constraints.a(j3));
                final int i4 = this.f27130b.f27099f;
                final LayoutNodeSubcompositionsState layoutNodeSubcompositionsState2 = this.f27130b;
                return new MeasureResult() { // from class: androidx.compose.ui.layout.LayoutNodeSubcompositionsState$createMeasurePolicy$1$measure-3p2s80s$$inlined$createMeasureResult$1
                    @Override // androidx.compose.ui.layout.MeasureResult
                    public void A() {
                        layoutNodeSubcompositionsState2.f27099f = i4;
                        measureResult2.A();
                        layoutNodeSubcompositionsState2.y();
                    }

                    @Override // androidx.compose.ui.layout.MeasureResult
                    public Function1 B() {
                        return measureResult2.B();
                    }

                    @Override // androidx.compose.ui.layout.MeasureResult
                    public int getHeight() {
                        return measureResult2.getHeight();
                    }

                    @Override // androidx.compose.ui.layout.MeasureResult
                    public int getWidth() {
                        return measureResult2.getWidth();
                    }

                    @Override // androidx.compose.ui.layout.MeasureResult
                    public Map z() {
                        return measureResult2.z();
                    }
                };
            }
        };
    }

    public final void x(int i3) {
        boolean z2 = false;
        this.f27108o = 0;
        List listW = this.f27095a.W();
        int size = (listW.size() - this.f27109p) - 1;
        if (i3 <= size) {
            this.f27105l.clear();
            if (i3 <= size) {
                int i4 = i3;
                while (true) {
                    this.f27105l.add(A(listW, i4));
                    if (i4 == size) {
                        break;
                    } else {
                        i4++;
                    }
                }
            }
            this.f27097c.a(this.f27105l);
            Snapshot.Companion companion = Snapshot.f24914e;
            Snapshot snapshotD = companion.d();
            Function1 function1G = snapshotD != null ? snapshotD.g() : null;
            Snapshot snapshotE = companion.e(snapshotD);
            boolean z3 = false;
            while (size >= i3) {
                try {
                    LayoutNode layoutNode = (LayoutNode) listW.get(size);
                    Object objE = this.f27100g.e(layoutNode);
                    Intrinsics.checkNotNull(objE);
                    NodeState nodeState = (NodeState) objE;
                    Object objF = nodeState.f();
                    if (this.f27105l.contains(objF)) {
                        this.f27108o++;
                        if (nodeState.a()) {
                            G(layoutNode);
                            nodeState.g(false);
                            z3 = true;
                        }
                    } else {
                        LayoutNode layoutNode2 = this.f27095a;
                        layoutNode2.f27376t = true;
                        this.f27100g.u(layoutNode);
                        ReusableComposition reusableCompositionB = nodeState.b();
                        if (reusableCompositionB != null) {
                            reusableCompositionB.dispose();
                        }
                        this.f27095a.w1(size, 1);
                        layoutNode2.f27376t = false;
                    }
                    this.f27101h.u(objF);
                    size--;
                } catch (Throwable th) {
                    companion.m(snapshotD, snapshotE, function1G);
                    throw th;
                }
            }
            Unit unit = Unit.f139807a;
            companion.m(snapshotD, snapshotE, function1G);
            z2 = z3;
        }
        if (z2) {
            Snapshot.f24914e.n();
        }
        B();
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0051  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void z() {
        /*
            r14 = this;
            androidx.compose.ui.node.LayoutNode r0 = r14.f27095a
            java.util.List r0 = r0.W()
            int r0 = r0.size()
            int r1 = r14.f27108o
            if (r1 == r0) goto L68
            androidx.collection.MutableScatterMap r0 = r14.f27100g
            java.lang.Object[] r1 = r0.f3110c
            long[] r0 = r0.f3108a
            int r2 = r0.length
            int r2 = r2 + (-2)
            if (r2 < 0) goto L56
            r3 = 0
            r4 = r3
        L1b:
            r5 = r0[r4]
            long r7 = ~r5
            r9 = 7
            long r7 = r7 << r9
            long r7 = r7 & r5
            r9 = -9187201950435737472(0x8080808080808080, double:-2.937446524422997E-306)
            long r7 = r7 & r9
            int r7 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r7 == 0) goto L51
            int r7 = r4 - r2
            int r7 = ~r7
            int r7 = r7 >>> 31
            r8 = 8
            int r7 = 8 - r7
            r9 = r3
        L35:
            if (r9 >= r7) goto L4f
            r10 = 255(0xff, double:1.26E-321)
            long r10 = r10 & r5
            r12 = 128(0x80, double:6.3E-322)
            int r10 = (r10 > r12 ? 1 : (r10 == r12 ? 0 : -1))
            if (r10 >= 0) goto L4b
            int r10 = r4 << 3
            int r10 = r10 + r9
            r10 = r1[r10]
            androidx.compose.ui.layout.LayoutNodeSubcompositionsState$NodeState r10 = (androidx.compose.ui.layout.LayoutNodeSubcompositionsState.NodeState) r10
            r11 = 1
            r10.k(r11)
        L4b:
            long r5 = r5 >> r8
            int r9 = r9 + 1
            goto L35
        L4f:
            if (r7 != r8) goto L56
        L51:
            if (r4 == r2) goto L56
            int r4 = r4 + 1
            goto L1b
        L56:
            androidx.compose.ui.node.LayoutNode r0 = r14.f27095a
            boolean r0 = r0.o0()
            if (r0 != 0) goto L68
            androidx.compose.ui.node.LayoutNode r1 = r14.f27095a
            r5 = 7
            r6 = 0
            r2 = 0
            r3 = 0
            r4 = 0
            androidx.compose.ui.node.LayoutNode.G1(r1, r2, r3, r4, r5, r6)
        L68:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.layout.LayoutNodeSubcompositionsState.z():void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    static final class NodeState {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private Object f27113a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private Function2 f27114b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private ReusableComposition f27115c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private boolean f27116d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private boolean f27117e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private MutableState f27118f;

        public NodeState(Object obj, Function2 function2, ReusableComposition reusableComposition) {
            this.f27113a = obj;
            this.f27114b = function2;
            this.f27115c = reusableComposition;
            this.f27118f = SnapshotStateKt__SnapshotStateKt.e(Boolean.TRUE, null, 2, null);
        }

        public final boolean a() {
            return ((Boolean) this.f27118f.getValue()).booleanValue();
        }

        public final ReusableComposition b() {
            return this.f27115c;
        }

        public final Function2 c() {
            return this.f27114b;
        }

        public final boolean d() {
            return this.f27116d;
        }

        public final boolean e() {
            return this.f27117e;
        }

        public final Object f() {
            return this.f27113a;
        }

        public final void g(boolean z2) {
            this.f27118f.setValue(Boolean.valueOf(z2));
        }

        public final void h(MutableState mutableState) {
            this.f27118f = mutableState;
        }

        public final void i(ReusableComposition reusableComposition) {
            this.f27115c = reusableComposition;
        }

        public final void j(Function2 function2) {
            this.f27114b = function2;
        }

        public final void k(boolean z2) {
            this.f27116d = z2;
        }

        public final void l(boolean z2) {
            this.f27117e = z2;
        }

        public final void m(Object obj) {
            this.f27113a = obj;
        }

        public /* synthetic */ NodeState(Object obj, Function2 function2, ReusableComposition reusableComposition, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this(obj, function2, (i3 & 4) != 0 ? null : reusableComposition);
        }
    }
}
