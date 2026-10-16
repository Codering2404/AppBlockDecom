package androidx.compose.ui.node;

import androidx.collection.MutableObjectIntMap;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.runtime.snapshots.Snapshot;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.MutableRect;
import androidx.compose.ui.geometry.MutableRectKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.Matrix;
import androidx.compose.ui.graphics.Paint;
import androidx.compose.ui.graphics.ReusableGraphicsLayerScope;
import androidx.compose.ui.graphics.layer.GraphicsLayer;
import androidx.compose.ui.input.pointer.MatrixPositionCalculator;
import androidx.compose.ui.input.pointer.PointerType;
import androidx.compose.ui.internal.InlineClassHelperKt;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.LayoutCoordinatesKt;
import androidx.compose.ui.layout.LookaheadLayoutCoordinates;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.semantics.SemanticsConfiguration;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntOffsetKt;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.IntSizeKt;
import androidx.compose.ui.unit.LayoutDirection;
import com.google.android.gms.common.api.Api;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

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
public abstract class NodeCoordinator extends LookaheadCapablePlaceable implements Measurable, LayoutCoordinates, OwnerScope {
    public static final Companion O = new Companion(null);
    private static final Function1 P = new Function1<NodeCoordinator, Unit>() { // from class: androidx.compose.ui.node.NodeCoordinator$Companion$onCommitAffectingLayerParams$1
        public final void c(NodeCoordinator nodeCoordinator) {
            if (nodeCoordinator.a1() && NodeCoordinator.U3(nodeCoordinator, false, 1, null)) {
                LayoutNode layoutNodeX1 = nodeCoordinator.X1();
                LayoutNodeLayoutDelegate layoutNodeLayoutDelegateF0 = layoutNodeX1.f0();
                if (layoutNodeLayoutDelegateF0.d() > 0) {
                    if (layoutNodeLayoutDelegateF0.f() || layoutNodeLayoutDelegateF0.g()) {
                        LayoutNode.E1(layoutNodeX1, false, 1, null);
                    }
                    layoutNodeLayoutDelegateF0.w().s2();
                }
                Owner ownerB = LayoutNodeKt.b(layoutNodeX1);
                ownerB.getRectManager().k(layoutNodeX1);
                ownerB.g(layoutNodeX1);
            }
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            c((NodeCoordinator) obj);
            return Unit.f139807a;
        }
    };
    private static final Function1 Q = new Function1<NodeCoordinator, Unit>() { // from class: androidx.compose.ui.node.NodeCoordinator$Companion$onCommitAffectingLayer$1
        public final void c(NodeCoordinator nodeCoordinator) {
            OwnedLayer ownedLayerR2 = nodeCoordinator.R2();
            if (ownedLayerR2 != null) {
                ownedLayerR2.invalidate();
            }
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            c((NodeCoordinator) obj);
            return Unit.f139807a;
        }
    };
    private static final ReusableGraphicsLayerScope R = new ReusableGraphicsLayerScope();
    private static final LayerPositionalProperties S = new LayerPositionalProperties();
    private static final float[] T = Matrix.c(null, 1, null);
    private static final HitTestSource U = new HitTestSource() { // from class: androidx.compose.ui.node.NodeCoordinator$Companion$PointerInputSource$1
        @Override // androidx.compose.ui.node.NodeCoordinator.HitTestSource
        public int a() {
            return NodeKind.a(16);
        }

        @Override // androidx.compose.ui.node.NodeCoordinator.HitTestSource
        public void b(LayoutNode layoutNode, long j3, HitTestResult hitTestResult, int i3, boolean z2) {
            layoutNode.I0(j3, hitTestResult, i3, z2);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r10v0, types: [androidx.compose.ui.Modifier$Node] */
        /* JADX WARN: Type inference failed for: r10v1, types: [androidx.compose.ui.Modifier$Node] */
        /* JADX WARN: Type inference failed for: r10v10 */
        /* JADX WARN: Type inference failed for: r10v11 */
        /* JADX WARN: Type inference failed for: r10v12 */
        /* JADX WARN: Type inference failed for: r10v4 */
        /* JADX WARN: Type inference failed for: r10v5, types: [androidx.compose.ui.Modifier$Node] */
        /* JADX WARN: Type inference failed for: r10v6, types: [java.lang.Object] */
        /* JADX WARN: Type inference failed for: r10v7 */
        /* JADX WARN: Type inference failed for: r10v8 */
        /* JADX WARN: Type inference failed for: r10v9 */
        /* JADX WARN: Type inference failed for: r3v0 */
        /* JADX WARN: Type inference failed for: r3v1 */
        /* JADX WARN: Type inference failed for: r3v10 */
        /* JADX WARN: Type inference failed for: r3v11 */
        /* JADX WARN: Type inference failed for: r3v2 */
        /* JADX WARN: Type inference failed for: r3v3, types: [androidx.compose.runtime.collection.MutableVector] */
        /* JADX WARN: Type inference failed for: r3v4 */
        /* JADX WARN: Type inference failed for: r3v5 */
        /* JADX WARN: Type inference failed for: r3v6, types: [androidx.compose.runtime.collection.MutableVector] */
        /* JADX WARN: Type inference failed for: r3v8 */
        /* JADX WARN: Type inference failed for: r3v9 */
        /* JADX WARN: Type inference failed for: r5v4 */
        @Override // androidx.compose.ui.node.NodeCoordinator.HitTestSource
        public boolean c(Modifier.Node node) {
            int iA = NodeKind.a(16);
            ?? mutableVector = 0;
            while (node != 0) {
                if (node instanceof PointerInputModifierNode) {
                    if (((PointerInputModifierNode) node).l0()) {
                        return true;
                    }
                } else if ((node.getKindSet$ui_release() & iA) != 0 && (node instanceof DelegatingNode)) {
                    Modifier.Node nodeN2 = ((DelegatingNode) node).n2();
                    int i3 = 0;
                    mutableVector = mutableVector;
                    node = node;
                    while (nodeN2 != null) {
                        if ((nodeN2.getKindSet$ui_release() & iA) != 0) {
                            i3++;
                            mutableVector = mutableVector;
                            if (i3 == 1) {
                                node = nodeN2;
                            } else {
                                if (mutableVector == 0) {
                                    mutableVector = new MutableVector(new Modifier.Node[16], 0);
                                }
                                if (node != 0) {
                                    mutableVector.b(node);
                                    node = 0;
                                }
                                mutableVector.b(nodeN2);
                            }
                        }
                        nodeN2 = nodeN2.getChild$ui_release();
                        mutableVector = mutableVector;
                        node = node;
                    }
                    if (i3 == 1) {
                    }
                }
                node = DelegatableNodeKt.h(mutableVector);
            }
            return false;
        }

        @Override // androidx.compose.ui.node.NodeCoordinator.HitTestSource
        public boolean d(LayoutNode layoutNode) {
            return true;
        }
    };
    private static final HitTestSource V = new HitTestSource() { // from class: androidx.compose.ui.node.NodeCoordinator$Companion$SemanticsSource$1
        @Override // androidx.compose.ui.node.NodeCoordinator.HitTestSource
        public int a() {
            return NodeKind.a(8);
        }

        @Override // androidx.compose.ui.node.NodeCoordinator.HitTestSource
        public void b(LayoutNode layoutNode, long j3, HitTestResult hitTestResult, int i3, boolean z2) {
            layoutNode.K0(j3, hitTestResult, i3, z2);
        }

        @Override // androidx.compose.ui.node.NodeCoordinator.HitTestSource
        public boolean c(Modifier.Node node) {
            return false;
        }

        @Override // androidx.compose.ui.node.NodeCoordinator.HitTestSource
        public boolean d(LayoutNode layoutNode) {
            SemanticsConfiguration semanticsConfigurationQ = layoutNode.Q();
            boolean z2 = false;
            if (semanticsConfigurationQ != null && semanticsConfigurationQ.o()) {
                z2 = true;
            }
            return !z2;
        }
    };
    private MeasureResult B;
    private MutableObjectIntMap C;
    private float E;
    private MutableRect F;
    private LayerPositionalProperties G;
    private GraphicsLayer H;
    private Canvas I;
    private Function2 J;
    private boolean L;
    private OwnedLayer M;
    private GraphicsLayer N;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private final LayoutNode f27553q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private boolean f27554r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private boolean f27555s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private NodeCoordinator f27556t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private NodeCoordinator f27557u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private boolean f27558v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private boolean f27559w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private Function1 f27560x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private Density f27561y = X1().U();

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private LayoutDirection f27562z = X1().getLayoutDirection();
    private float A = 0.8f;
    private long D = IntOffset.f29988b.b();
    private final Function0 K = new Function0<Unit>() { // from class: androidx.compose.ui.node.NodeCoordinator$invalidateParentLayer$1
        {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Object invoke() {
            m240invoke();
            return Unit.f139807a;
        }

        /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
        public final void m240invoke() {
            NodeCoordinator nodeCoordinatorY2 = this.f27568a.Y2();
            if (nodeCoordinatorY2 != null) {
                nodeCoordinatorY2.h3();
            }
        }
    };

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final HitTestSource a() {
            return NodeCoordinator.U;
        }

        public final HitTestSource b() {
            return NodeCoordinator.V;
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public interface HitTestSource {
        int a();

        void b(LayoutNode layoutNode, long j3, HitTestResult hitTestResult, int i3, boolean z2);

        boolean c(Modifier.Node node);

        boolean d(LayoutNode layoutNode);
    }

    public NodeCoordinator(LayoutNode layoutNode) {
        this.f27553q = layoutNode;
    }

    private final void A2(NodeCoordinator nodeCoordinator, MutableRect mutableRect, boolean z2) {
        if (nodeCoordinator == this) {
            return;
        }
        NodeCoordinator nodeCoordinator2 = this.f27557u;
        if (nodeCoordinator2 != null) {
            nodeCoordinator2.A2(nodeCoordinator, mutableRect, z2);
        }
        L2(mutableRect, z2);
    }

    private final long B2(NodeCoordinator nodeCoordinator, long j3, boolean z2) {
        if (nodeCoordinator == this) {
            return j3;
        }
        NodeCoordinator nodeCoordinator2 = this.f27557u;
        return (nodeCoordinator2 == null || Intrinsics.areEqual(nodeCoordinator, nodeCoordinator2)) ? J2(j3, z2) : J2(nodeCoordinator2.B2(nodeCoordinator, j3, z2), z2);
    }

    public static /* synthetic */ void B3(NodeCoordinator nodeCoordinator, MutableRect mutableRect, boolean z2, boolean z3, int i3, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: rectInParent");
        }
        if ((i3 & 4) != 0) {
            z3 = false;
        }
        nodeCoordinator.A3(mutableRect, z2, z3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void G2(Canvas canvas, GraphicsLayer graphicsLayer) {
        Modifier.Node nodeB3 = b3(NodeKind.a(4));
        if (nodeB3 == null) {
            x3(canvas, graphicsLayer);
        } else {
            X1().m0().u(canvas, IntSizeKt.e(a()), this, nodeB3, graphicsLayer);
        }
    }

    public static /* synthetic */ long K2(NodeCoordinator nodeCoordinator, long j3, boolean z2, int i3, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: fromParentPosition-8S9VItk");
        }
        if ((i3 & 2) != 0) {
            z2 = true;
        }
        return nodeCoordinator.J2(j3, z2);
    }

    private final void K3(final Modifier.Node node, final HitTestSource hitTestSource, final long j3, final HitTestResult hitTestResult, final int i3, final boolean z2, final float f3) {
        if (node == null) {
            g3(hitTestSource, j3, hitTestResult, i3, z2);
        } else if (hitTestSource.c(node)) {
            hitTestResult.x(node, f3, z2, new Function0<Unit>() { // from class: androidx.compose.ui.node.NodeCoordinator$speculativeHit$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Object invoke() {
                    m242invoke();
                    return Unit.f139807a;
                }

                /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
                public final void m242invoke() {
                    this.f27578a.w3(NodeCoordinatorKt.d(node, hitTestSource.a(), NodeKind.a(2)), hitTestSource, j3, hitTestResult, i3, z2, f3, false);
                }
            });
        } else {
            w3(NodeCoordinatorKt.d(node, hitTestSource.a(), NodeKind.a(2)), hitTestSource, j3, hitTestResult, i3, z2, f3, false);
        }
    }

    private final void L2(MutableRect mutableRect, boolean z2) {
        float fK = IntOffset.k(C1());
        mutableRect.i(mutableRect.b() - fK);
        mutableRect.j(mutableRect.c() - fK);
        float fL = IntOffset.l(C1());
        mutableRect.k(mutableRect.d() - fL);
        mutableRect.h(mutableRect.a() - fL);
        OwnedLayer ownedLayer = this.M;
        if (ownedLayer != null) {
            ownedLayer.f(mutableRect, true);
            if (this.f27559w && z2) {
                mutableRect.e(0.0f, 0.0f, (int) (a() >> 32), (int) (a() & 4294967295L));
                mutableRect.f();
            }
        }
    }

    private final NodeCoordinator L3(LayoutCoordinates layoutCoordinates) {
        NodeCoordinator nodeCoordinatorB;
        LookaheadLayoutCoordinates lookaheadLayoutCoordinates = layoutCoordinates instanceof LookaheadLayoutCoordinates ? (LookaheadLayoutCoordinates) layoutCoordinates : null;
        if (lookaheadLayoutCoordinates != null && (nodeCoordinatorB = lookaheadLayoutCoordinates.b()) != null) {
            return nodeCoordinatorB;
        }
        Intrinsics.checkNotNull(layoutCoordinates, "null cannot be cast to non-null type androidx.compose.ui.node.NodeCoordinator");
        return (NodeCoordinator) layoutCoordinates;
    }

    private final Function2 N2() {
        Function2 function2 = this.J;
        if (function2 != null) {
            return function2;
        }
        final Function0<Unit> function0 = new Function0<Unit>() { // from class: androidx.compose.ui.node.NodeCoordinator$drawBlock$drawBlockCallToDrawModifiers$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Object invoke() {
                m239invoke();
                return Unit.f139807a;
            }

            /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
            public final void m239invoke() {
                NodeCoordinator nodeCoordinator = this.f27567a;
                Canvas canvas = nodeCoordinator.I;
                Intrinsics.checkNotNull(canvas);
                nodeCoordinator.G2(canvas, this.f27567a.H);
            }
        };
        Function2<Canvas, GraphicsLayer, Unit> function22 = new Function2<Canvas, GraphicsLayer, Unit>() { // from class: androidx.compose.ui.node.NodeCoordinator$drawBlock$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            public final void c(Canvas canvas, GraphicsLayer graphicsLayer) {
                if (!this.f27565a.X1().u()) {
                    this.f27565a.L = true;
                    return;
                }
                this.f27565a.I = canvas;
                this.f27565a.H = graphicsLayer;
                this.f27565a.V2().i(this.f27565a, NodeCoordinator.Q, function0);
                this.f27565a.L = false;
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                c((Canvas) obj, (GraphicsLayer) obj2);
                return Unit.f139807a;
            }
        };
        this.J = function22;
        return function22;
    }

    public static /* synthetic */ long N3(NodeCoordinator nodeCoordinator, long j3, boolean z2, int i3, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: toParentPosition-8S9VItk");
        }
        if ((i3 & 2) != 0) {
            z2 = true;
        }
        return nodeCoordinator.M3(j3, z2);
    }

    private final void P3(NodeCoordinator nodeCoordinator, float[] fArr) {
        if (Intrinsics.areEqual(nodeCoordinator, this)) {
            return;
        }
        NodeCoordinator nodeCoordinator2 = this.f27557u;
        Intrinsics.checkNotNull(nodeCoordinator2);
        nodeCoordinator2.P3(nodeCoordinator, fArr);
        if (!IntOffset.j(C1(), IntOffset.f29988b.b())) {
            float[] fArr2 = T;
            Matrix.h(fArr2);
            Matrix.o(fArr2, -IntOffset.k(C1()), -IntOffset.l(C1()), 0.0f, 4, null);
            Matrix.l(fArr, fArr2);
        }
        OwnedLayer ownedLayer = this.M;
        if (ownedLayer != null) {
            ownedLayer.i(fArr);
        }
    }

    private final void Q3(NodeCoordinator nodeCoordinator, float[] fArr) {
        NodeCoordinator nodeCoordinator2 = this;
        while (!Intrinsics.areEqual(nodeCoordinator2, nodeCoordinator)) {
            OwnedLayer ownedLayer = nodeCoordinator2.M;
            if (ownedLayer != null) {
                ownedLayer.a(fArr);
            }
            if (!IntOffset.j(nodeCoordinator2.C1(), IntOffset.f29988b.b())) {
                float[] fArr2 = T;
                Matrix.h(fArr2);
                Matrix.o(fArr2, IntOffset.k(r1), IntOffset.l(r1), 0.0f, 4, null);
                Matrix.l(fArr, fArr2);
            }
            nodeCoordinator2 = nodeCoordinator2.f27557u;
            Intrinsics.checkNotNull(nodeCoordinator2);
        }
    }

    public static /* synthetic */ void S3(NodeCoordinator nodeCoordinator, Function1 function1, boolean z2, int i3, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: updateLayerBlock");
        }
        if ((i3 & 2) != 0) {
            z2 = false;
        }
        nodeCoordinator.R3(function1, z2);
    }

    private final boolean T3(boolean z2) {
        Owner ownerA0;
        if (this.N != null) {
            return false;
        }
        OwnedLayer ownedLayer = this.M;
        if (ownedLayer == null) {
            if (!(this.f27560x == null)) {
                InlineClassHelperKt.c("null layer with a non-null layerBlock");
            }
            return false;
        }
        final Function1 function1 = this.f27560x;
        if (function1 == null) {
            InlineClassHelperKt.d("updateLayerParameters requires a non-null layerBlock");
            throw new KotlinNothingValueException();
        }
        ReusableGraphicsLayerScope reusableGraphicsLayerScope = R;
        reusableGraphicsLayerScope.T();
        reusableGraphicsLayerScope.U(X1().U());
        reusableGraphicsLayerScope.X(X1().getLayoutDirection());
        reusableGraphicsLayerScope.Y(IntSizeKt.e(a()));
        V2().i(this, P, new Function0<Unit>() { // from class: androidx.compose.ui.node.NodeCoordinator$updateLayerParameters$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Object invoke() {
                m243invoke();
                return Unit.f139807a;
            }

            /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
            public final void m243invoke() {
                function1.invoke(NodeCoordinator.R);
                NodeCoordinator.R.Z();
            }
        });
        LayerPositionalProperties layerPositionalProperties = this.G;
        if (layerPositionalProperties == null) {
            layerPositionalProperties = new LayerPositionalProperties();
            this.G = layerPositionalProperties;
        }
        LayerPositionalProperties layerPositionalProperties2 = S;
        layerPositionalProperties2.b(layerPositionalProperties);
        layerPositionalProperties.a(reusableGraphicsLayerScope);
        ownedLayer.h(reusableGraphicsLayerScope);
        boolean z3 = this.f27559w;
        this.f27559w = reusableGraphicsLayerScope.u();
        this.A = reusableGraphicsLayerScope.m();
        boolean zC = layerPositionalProperties2.c(layerPositionalProperties);
        boolean z4 = !zC;
        if (z2 && ((!zC || z3 != this.f27559w) && (ownerA0 = X1().A0()) != null)) {
            ownerA0.k(X1());
        }
        return z4;
    }

    static /* synthetic */ boolean U3(NodeCoordinator nodeCoordinator, boolean z2, int i3, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: updateLayerParameters");
        }
        if ((i3 & 1) != 0) {
            z2 = true;
        }
        return nodeCoordinator.T3(z2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final OwnerSnapshotObserver V2() {
        return LayoutNodeKt.b(X1()).getSnapshotObserver();
    }

    private final boolean a3(int i3) {
        Modifier.Node nodeC3 = c3(NodeKindKt.i(i3));
        return nodeC3 != null && DelegatableNodeKt.f(nodeC3, i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Modifier.Node c3(boolean z2) {
        Modifier.Node nodeW2;
        if (X1().x0() == this) {
            return X1().u0().k();
        }
        if (!z2) {
            NodeCoordinator nodeCoordinator = this.f27557u;
            if (nodeCoordinator != null) {
                return nodeCoordinator.W2();
            }
            return null;
        }
        NodeCoordinator nodeCoordinator2 = this.f27557u;
        if (nodeCoordinator2 == null || (nodeW2 = nodeCoordinator2.W2()) == null) {
            return null;
        }
        return nodeW2.getChild$ui_release();
    }

    private final void d3(Modifier.Node node, HitTestSource hitTestSource, long j3, HitTestResult hitTestResult, int i3, boolean z2) {
        if (node == null) {
            g3(hitTestSource, j3, hitTestResult, i3, z2);
            return;
        }
        int i4 = hitTestResult.f27326c;
        hitTestResult.w(hitTestResult.f27326c + 1, hitTestResult.size());
        hitTestResult.f27326c++;
        hitTestResult.f27324a.n(node);
        hitTestResult.f27325b.d(HitTestResultKt.a(-1.0f, z2, false));
        d3(NodeCoordinatorKt.d(node, hitTestSource.a(), NodeKind.a(2)), hitTestSource, j3, hitTestResult, i3, z2);
        hitTestResult.f27326c = i4;
    }

    private final void e3(Modifier.Node node, HitTestSource hitTestSource, long j3, HitTestResult hitTestResult, int i3, boolean z2, float f3) {
        if (node == null) {
            g3(hitTestSource, j3, hitTestResult, i3, z2);
            return;
        }
        int i4 = hitTestResult.f27326c;
        hitTestResult.w(hitTestResult.f27326c + 1, hitTestResult.size());
        hitTestResult.f27326c++;
        hitTestResult.f27324a.n(node);
        hitTestResult.f27325b.d(HitTestResultKt.a(f3, z2, false));
        w3(NodeCoordinatorKt.d(node, hitTestSource.a(), NodeKind.a(2)), hitTestSource, j3, hitTestResult, i3, z2, f3, true);
        hitTestResult.f27326c = i4;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1 */
    /* JADX WARN: Type inference failed for: r3v10 */
    /* JADX WARN: Type inference failed for: r3v11, types: [androidx.compose.runtime.collection.MutableVector] */
    /* JADX WARN: Type inference failed for: r3v12 */
    /* JADX WARN: Type inference failed for: r3v13 */
    /* JADX WARN: Type inference failed for: r3v14, types: [androidx.compose.runtime.collection.MutableVector] */
    /* JADX WARN: Type inference failed for: r3v16 */
    /* JADX WARN: Type inference failed for: r3v17 */
    /* JADX WARN: Type inference failed for: r3v18 */
    /* JADX WARN: Type inference failed for: r3v19 */
    /* JADX WARN: Type inference failed for: r4v4 */
    /* JADX WARN: Type inference failed for: r9v0, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r9v1, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r9v11 */
    /* JADX WARN: Type inference failed for: r9v12, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r9v13, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r9v14 */
    /* JADX WARN: Type inference failed for: r9v15 */
    /* JADX WARN: Type inference failed for: r9v16 */
    /* JADX WARN: Type inference failed for: r9v17 */
    /* JADX WARN: Type inference failed for: r9v18 */
    /* JADX WARN: Type inference failed for: r9v19 */
    private final boolean i3(Modifier.Node node, long j3, int i3) {
        if (node == 0) {
            return false;
        }
        PointerType.Companion companion = PointerType.f26922b;
        if (!PointerType.h(i3, companion.c()) && !PointerType.h(i3, companion.a())) {
            return false;
        }
        int iA = NodeKind.a(16);
        ?? mutableVector = 0;
        while (node != 0) {
            if (node instanceof PointerInputModifierNode) {
                long jV0 = ((PointerInputModifierNode) node).V0();
                int i4 = (int) (j3 >> 32);
                if (Float.intBitsToFloat(i4) >= (-TouchBoundsExpansion.b(jV0, getLayoutDirection())) && Float.intBitsToFloat(i4) < S0() + TouchBoundsExpansion.c(jV0, getLayoutDirection())) {
                    int i5 = (int) (j3 & 4294967295L);
                    if (Float.intBitsToFloat(i5) >= (-TouchBoundsExpansion.i(jV0)) && Float.intBitsToFloat(i5) < Q0() + TouchBoundsExpansion.f(jV0)) {
                        return true;
                    }
                }
                return false;
            }
            if ((node.getKindSet$ui_release() & iA) != 0 && (node instanceof DelegatingNode)) {
                Modifier.Node nodeN2 = ((DelegatingNode) node).n2();
                int i6 = 0;
                mutableVector = mutableVector;
                node = node;
                while (nodeN2 != null) {
                    if ((nodeN2.getKindSet$ui_release() & iA) != 0) {
                        i6++;
                        mutableVector = mutableVector;
                        if (i6 == 1) {
                            node = nodeN2;
                        } else {
                            if (mutableVector == 0) {
                                mutableVector = new MutableVector(new Modifier.Node[16], 0);
                            }
                            if (node != 0) {
                                mutableVector.b(node);
                                node = 0;
                            }
                            mutableVector.b(nodeN2);
                        }
                    }
                    nodeN2 = nodeN2.getChild$ui_release();
                    mutableVector = mutableVector;
                    node = node;
                }
                if (i6 == 1) {
                }
            }
            node = DelegatableNodeKt.h(mutableVector);
        }
        return false;
    }

    private final long l3(long j3) {
        float fIntBitsToFloat = Float.intBitsToFloat((int) (j3 >> 32));
        float fMax = Math.max(0.0f, fIntBitsToFloat < 0.0f ? -fIntBitsToFloat : fIntBitsToFloat - S0());
        float fIntBitsToFloat2 = Float.intBitsToFloat((int) (j3 & 4294967295L));
        return Offset.e((((long) Float.floatToRawIntBits(Math.max(0.0f, fIntBitsToFloat2 < 0.0f ? -fIntBitsToFloat2 : fIntBitsToFloat2 - Q0()))) & 4294967295L) | (((long) Float.floatToRawIntBits(fMax)) << 32));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void w3(final Modifier.Node node, final HitTestSource hitTestSource, final long j3, final HitTestResult hitTestResult, final int i3, final boolean z2, final float f3, final boolean z3) {
        if (node == null) {
            g3(hitTestSource, j3, hitTestResult, i3, z2);
            return;
        }
        if (i3(node, j3, i3)) {
            hitTestResult.q(node, z2, new Function0<Unit>() { // from class: androidx.compose.ui.node.NodeCoordinator$outOfBoundsHit$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Object invoke() {
                    m241invoke();
                    return Unit.f139807a;
                }

                /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
                public final void m241invoke() {
                    this.f27569a.w3(NodeCoordinatorKt.d(node, hitTestSource.a(), NodeKind.a(2)), hitTestSource, j3, hitTestResult, i3, z2, f3, z3);
                }
            });
        } else if (z3) {
            e3(node, hitTestSource, j3, hitTestResult, i3, z2, f3);
        } else {
            K3(node, hitTestSource, j3, hitTestResult, i3, z2, f3);
        }
    }

    private final void y3(long j3, float f3, Function1 function1, GraphicsLayer graphicsLayer) {
        if (graphicsLayer != null) {
            if (!(function1 == null)) {
                InlineClassHelperKt.a("both ways to create layers shouldn't be used together");
            }
            if (this.N != graphicsLayer) {
                this.N = null;
                S3(this, null, false, 2, null);
                this.N = graphicsLayer;
            }
            if (this.M == null) {
                OwnedLayer ownedLayerN = Owner.n(LayoutNodeKt.b(X1()), N2(), this.K, graphicsLayer, false, 8, null);
                ownedLayerN.d(R0());
                ownedLayerN.j(j3);
                this.M = ownedLayerN;
                X1().M1(true);
                this.K.invoke();
            }
        } else {
            if (this.N != null) {
                this.N = null;
                S3(this, null, false, 2, null);
            }
            S3(this, function1, false, 2, null);
        }
        if (!IntOffset.j(C1(), j3)) {
            G3(j3);
            X1().f0().w().s2();
            OwnedLayer ownedLayer = this.M;
            if (ownedLayer != null) {
                ownedLayer.j(j3);
            } else {
                NodeCoordinator nodeCoordinator = this.f27557u;
                if (nodeCoordinator != null) {
                    nodeCoordinator.h3();
                }
            }
            N1(this);
            Owner ownerA0 = X1().A0();
            if (ownerA0 != null) {
                ownerA0.k(X1());
            }
        }
        this.E = f3;
        if (W1()) {
            return;
        }
        r1(x1());
    }

    @Override // androidx.compose.ui.node.LookaheadCapablePlaceable
    public LookaheadCapablePlaceable A1() {
        return this.f27557u;
    }

    public final void A3(MutableRect mutableRect, boolean z2, boolean z3) {
        OwnedLayer ownedLayer = this.M;
        if (ownedLayer != null) {
            if (this.f27559w) {
                if (z3) {
                    long jT2 = T2();
                    float fIntBitsToFloat = Float.intBitsToFloat((int) (jT2 >> 32)) / 2.0f;
                    float fIntBitsToFloat2 = Float.intBitsToFloat((int) (jT2 & 4294967295L)) / 2.0f;
                    mutableRect.e(-fIntBitsToFloat, -fIntBitsToFloat2, ((int) (a() >> 32)) + fIntBitsToFloat, ((int) (4294967295L & a())) + fIntBitsToFloat2);
                } else if (z2) {
                    mutableRect.e(0.0f, 0.0f, (int) (a() >> 32), (int) (4294967295L & a()));
                }
                if (mutableRect.f()) {
                    return;
                }
            }
            ownedLayer.f(mutableRect, false);
        }
        float fK = IntOffset.k(C1());
        mutableRect.i(mutableRect.b() + fK);
        mutableRect.j(mutableRect.c() + fK);
        float fL = IntOffset.l(C1());
        mutableRect.k(mutableRect.d() + fL);
        mutableRect.h(mutableRect.a() + fL);
    }

    @Override // androidx.compose.ui.node.LookaheadCapablePlaceable
    public long C1() {
        return this.D;
    }

    protected final long C2(long j3) {
        float fIntBitsToFloat = Float.intBitsToFloat((int) (j3 >> 32)) - S0();
        float fIntBitsToFloat2 = Float.intBitsToFloat((int) (j3 & 4294967295L)) - Q0();
        float fMax = Math.max(0.0f, fIntBitsToFloat / 2.0f);
        return Size.d((((long) Float.floatToRawIntBits(Math.max(0.0f, fIntBitsToFloat2 / 2.0f))) & 4294967295L) | (Float.floatToRawIntBits(fMax) << 32));
    }

    public final void C3() {
        if (this.M != null) {
            if (this.N != null) {
                this.N = null;
            }
            S3(this, null, false, 2, null);
            LayoutNode.E1(X1(), false, 1, null);
        }
    }

    protected final float D2(long j3, long j4) {
        if (S0() >= Float.intBitsToFloat((int) (j4 >> 32)) && Q0() >= Float.intBitsToFloat((int) (j4 & 4294967295L))) {
            return Float.POSITIVE_INFINITY;
        }
        long jC2 = C2(j4);
        float fIntBitsToFloat = Float.intBitsToFloat((int) (jC2 >> 32));
        float fIntBitsToFloat2 = Float.intBitsToFloat((int) (jC2 & 4294967295L));
        long jL3 = l3(j3);
        if ((fIntBitsToFloat > 0.0f || fIntBitsToFloat2 > 0.0f) && Float.intBitsToFloat((int) (jL3 >> 32)) <= fIntBitsToFloat && Float.intBitsToFloat((int) (jL3 & 4294967295L)) <= fIntBitsToFloat2) {
            return Offset.l(jL3);
        }
        return Float.POSITIVE_INFINITY;
    }

    public final void D3(boolean z2) {
        this.f27555s = z2;
    }

    public final void E2(Canvas canvas, GraphicsLayer graphicsLayer) {
        OwnedLayer ownedLayer = this.M;
        if (ownedLayer != null) {
            ownedLayer.e(canvas, graphicsLayer);
            return;
        }
        float fK = IntOffset.k(C1());
        float fL = IntOffset.l(C1());
        canvas.e(fK, fL);
        G2(canvas, graphicsLayer);
        canvas.e(-fK, -fL);
    }

    public final void E3(boolean z2) {
        this.f27554r = z2;
    }

    protected final void F2(Canvas canvas, Paint paint) {
        canvas.g(0.5f, 0.5f, ((int) (R0() >> 32)) - 0.5f, ((int) (R0() & 4294967295L)) - 0.5f, paint);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0034  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void F3(androidx.compose.ui.layout.MeasureResult r4) {
        /*
            r3 = this;
            androidx.compose.ui.layout.MeasureResult r0 = r3.B
            if (r4 == r0) goto L8c
            r3.B = r4
            if (r0 == 0) goto L1c
            int r1 = r4.getWidth()
            int r2 = r0.getWidth()
            if (r1 != r2) goto L1c
            int r1 = r4.getHeight()
            int r0 = r0.getHeight()
            if (r1 == r0) goto L27
        L1c:
            int r0 = r4.getWidth()
            int r1 = r4.getHeight()
            r3.r3(r0, r1)
        L27:
            androidx.collection.MutableObjectIntMap r0 = r3.C
            if (r0 == 0) goto L34
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0)
            boolean r0 = r0.h()
            if (r0 != 0) goto L3e
        L34:
            java.util.Map r0 = r4.z()
            boolean r0 = r0.isEmpty()
            if (r0 != 0) goto L8c
        L3e:
            androidx.collection.MutableObjectIntMap r0 = r3.C
            java.util.Map r1 = r4.z()
            boolean r0 = androidx.compose.ui.node.NodeCoordinatorKt.a(r0, r1)
            if (r0 != 0) goto L8c
            androidx.compose.ui.node.AlignmentLinesOwner r0 = r3.M2()
            androidx.compose.ui.node.AlignmentLines r0 = r0.z()
            r0.m()
            androidx.collection.MutableObjectIntMap r0 = r3.C
            if (r0 != 0) goto L5f
            androidx.collection.MutableObjectIntMap r0 = androidx.collection.ObjectIntMapKt.b()
            r3.C = r0
        L5f:
            r0.j()
            java.util.Map r4 = r4.z()
            java.util.Set r4 = r4.entrySet()
            java.util.Iterator r4 = r4.iterator()
        L6e:
            boolean r1 = r4.hasNext()
            if (r1 == 0) goto L8c
            java.lang.Object r1 = r4.next()
            java.util.Map$Entry r1 = (java.util.Map.Entry) r1
            java.lang.Object r2 = r1.getKey()
            java.lang.Object r1 = r1.getValue()
            java.lang.Number r1 = (java.lang.Number) r1
            int r1 = r1.intValue()
            r0.u(r2, r1)
            goto L6e
        L8c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.node.NodeCoordinator.F3(androidx.compose.ui.layout.MeasureResult):void");
    }

    protected void G3(long j3) {
        this.D = j3;
    }

    @Override // androidx.compose.ui.layout.LayoutCoordinates
    public long H(long j3) {
        if (!m()) {
            InlineClassHelperKt.c("LayoutCoordinate operations are only valid when isAttached is true");
        }
        return LayoutNodeKt.b(X1()).H(x0(j3));
    }

    public abstract void H2();

    public final void H3(NodeCoordinator nodeCoordinator) {
        this.f27556t = nodeCoordinator;
    }

    public final NodeCoordinator I2(NodeCoordinator nodeCoordinator) {
        LayoutNode layoutNodeX1 = nodeCoordinator.X1();
        LayoutNode layoutNodeX12 = X1();
        if (layoutNodeX1 == layoutNodeX12) {
            Modifier.Node nodeW2 = nodeCoordinator.W2();
            Modifier.Node nodeW22 = W2();
            int iA = NodeKind.a(2);
            if (!nodeW22.getNode().isAttached()) {
                InlineClassHelperKt.c("visitLocalAncestors called on an unattached node");
            }
            for (Modifier.Node parent$ui_release = nodeW22.getNode().getParent$ui_release(); parent$ui_release != null; parent$ui_release = parent$ui_release.getParent$ui_release()) {
                if ((parent$ui_release.getKindSet$ui_release() & iA) != 0 && parent$ui_release == nodeW2) {
                    return nodeCoordinator;
                }
            }
            return this;
        }
        while (layoutNodeX1.V() > layoutNodeX12.V()) {
            layoutNodeX1 = layoutNodeX1.B0();
            Intrinsics.checkNotNull(layoutNodeX1);
        }
        while (layoutNodeX12.V() > layoutNodeX1.V()) {
            layoutNodeX12 = layoutNodeX12.B0();
            Intrinsics.checkNotNull(layoutNodeX12);
        }
        while (layoutNodeX1 != layoutNodeX12) {
            layoutNodeX1 = layoutNodeX1.B0();
            layoutNodeX12 = layoutNodeX12.B0();
            if (layoutNodeX1 == null || layoutNodeX12 == null) {
                throw new IllegalArgumentException("layouts are not part of the same hierarchy");
            }
        }
        if (layoutNodeX12 != X1()) {
            if (layoutNodeX1 != nodeCoordinator.X1()) {
                return layoutNodeX1.Z();
            }
            return nodeCoordinator;
        }
        return this;
    }

    public final void I3(NodeCoordinator nodeCoordinator) {
        this.f27557u = nodeCoordinator;
    }

    public long J2(long j3, boolean z2) {
        if (z2 || !R1()) {
            j3 = IntOffsetKt.b(j3, C1());
        }
        OwnedLayer ownedLayer = this.M;
        return ownedLayer != null ? ownedLayer.b(j3, true) : j3;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v0 */
    /* JADX WARN: Type inference failed for: r5v1, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r5v10 */
    /* JADX WARN: Type inference failed for: r5v11 */
    /* JADX WARN: Type inference failed for: r5v12 */
    /* JADX WARN: Type inference failed for: r5v4 */
    /* JADX WARN: Type inference failed for: r5v5, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r5v6, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r5v7 */
    /* JADX WARN: Type inference failed for: r5v8 */
    /* JADX WARN: Type inference failed for: r5v9 */
    /* JADX WARN: Type inference failed for: r6v0 */
    /* JADX WARN: Type inference failed for: r6v1 */
    /* JADX WARN: Type inference failed for: r6v10 */
    /* JADX WARN: Type inference failed for: r6v11 */
    /* JADX WARN: Type inference failed for: r6v2 */
    /* JADX WARN: Type inference failed for: r6v3, types: [androidx.compose.runtime.collection.MutableVector] */
    /* JADX WARN: Type inference failed for: r6v4 */
    /* JADX WARN: Type inference failed for: r6v5 */
    /* JADX WARN: Type inference failed for: r6v6, types: [androidx.compose.runtime.collection.MutableVector] */
    /* JADX WARN: Type inference failed for: r6v8 */
    /* JADX WARN: Type inference failed for: r6v9 */
    /* JADX WARN: Type inference failed for: r7v4 */
    public final boolean J3() {
        Modifier.Node nodeC3 = c3(NodeKindKt.i(NodeKind.a(16)));
        if (nodeC3 != null && nodeC3.isAttached()) {
            int iA = NodeKind.a(16);
            if (!nodeC3.getNode().isAttached()) {
                InlineClassHelperKt.c("visitLocalDescendants called on an unattached node");
            }
            Modifier.Node node = nodeC3.getNode();
            if ((node.getAggregateChildKindSet$ui_release() & iA) != 0) {
                while (node != null) {
                    if ((node.getKindSet$ui_release() & iA) != 0) {
                        ?? H = node;
                        ?? mutableVector = 0;
                        while (H != 0) {
                            if (H instanceof PointerInputModifierNode) {
                                if (((PointerInputModifierNode) H).W1()) {
                                    return true;
                                }
                            } else if ((H.getKindSet$ui_release() & iA) != 0 && (H instanceof DelegatingNode)) {
                                Modifier.Node nodeN2 = ((DelegatingNode) H).n2();
                                int i3 = 0;
                                H = H;
                                mutableVector = mutableVector;
                                while (nodeN2 != null) {
                                    if ((nodeN2.getKindSet$ui_release() & iA) != 0) {
                                        i3++;
                                        mutableVector = mutableVector;
                                        if (i3 == 1) {
                                            H = nodeN2;
                                        } else {
                                            if (mutableVector == 0) {
                                                mutableVector = new MutableVector(new Modifier.Node[16], 0);
                                            }
                                            if (H != 0) {
                                                mutableVector.b(H);
                                                H = 0;
                                            }
                                            mutableVector.b(nodeN2);
                                        }
                                    }
                                    nodeN2 = nodeN2.getChild$ui_release();
                                    H = H;
                                    mutableVector = mutableVector;
                                }
                                if (i3 == 1) {
                                }
                            }
                            H = DelegatableNodeKt.h(mutableVector);
                        }
                    }
                    node = node.getChild$ui_release();
                }
            }
        }
        return false;
    }

    @Override // androidx.compose.ui.unit.FontScaling
    public float K1() {
        return X1().U().K1();
    }

    public AlignmentLinesOwner M2() {
        return X1().f0().c();
    }

    public long M3(long j3, boolean z2) {
        OwnedLayer ownedLayer = this.M;
        if (ownedLayer != null) {
            j3 = ownedLayer.b(j3, false);
        }
        return (z2 || !R1()) ? IntOffsetKt.c(j3, C1()) : j3;
    }

    @Override // androidx.compose.ui.layout.LayoutCoordinates
    public boolean O() {
        return R1();
    }

    public final boolean O2() {
        return this.f27555s;
    }

    public final Rect O3() {
        if (!m()) {
            return Rect.f25601e.a();
        }
        LayoutCoordinates layoutCoordinatesD = LayoutCoordinatesKt.d(this);
        MutableRect mutableRectU2 = U2();
        long jC2 = C2(T2());
        int i3 = (int) (jC2 >> 32);
        mutableRectU2.i(-Float.intBitsToFloat(i3));
        int i4 = (int) (jC2 & 4294967295L);
        mutableRectU2.k(-Float.intBitsToFloat(i4));
        mutableRectU2.j(S0() + Float.intBitsToFloat(i3));
        mutableRectU2.h(Q0() + Float.intBitsToFloat(i4));
        NodeCoordinator nodeCoordinator = this;
        while (nodeCoordinator != layoutCoordinatesD) {
            nodeCoordinator.A3(mutableRectU2, false, true);
            if (mutableRectU2.f()) {
                return Rect.f25601e.a();
            }
            nodeCoordinator = nodeCoordinator.f27557u;
            Intrinsics.checkNotNull(nodeCoordinator);
        }
        return MutableRectKt.a(mutableRectU2);
    }

    public final boolean P2() {
        return this.L;
    }

    @Override // androidx.compose.ui.layout.LayoutCoordinates
    public long Q(LayoutCoordinates layoutCoordinates, long j3, boolean z2) {
        if (layoutCoordinates instanceof LookaheadLayoutCoordinates) {
            ((LookaheadLayoutCoordinates) layoutCoordinates).b().n3();
            return Offset.e(layoutCoordinates.Q(this, Offset.e(j3 ^ (-9223372034707292160L)), z2) ^ (-9223372034707292160L));
        }
        NodeCoordinator nodeCoordinatorL3 = L3(layoutCoordinates);
        nodeCoordinatorL3.n3();
        NodeCoordinator nodeCoordinatorI2 = I2(nodeCoordinatorL3);
        while (nodeCoordinatorL3 != nodeCoordinatorI2) {
            j3 = nodeCoordinatorL3.M3(j3, z2);
            nodeCoordinatorL3 = nodeCoordinatorL3.f27557u;
            Intrinsics.checkNotNull(nodeCoordinatorL3);
        }
        return B2(nodeCoordinatorI2, j3, z2);
    }

    public final long Q2() {
        return V0();
    }

    public final OwnedLayer R2() {
        return this.M;
    }

    public final void R3(Function1 function1, boolean z2) {
        Owner ownerA0;
        if (!(function1 == null || this.N == null)) {
            InlineClassHelperKt.a("layerBlock can't be provided when explicitLayer is provided");
        }
        LayoutNode layoutNodeX1 = X1();
        boolean z3 = (!z2 && this.f27560x == function1 && Intrinsics.areEqual(this.f27561y, layoutNodeX1.U()) && this.f27562z == layoutNodeX1.getLayoutDirection()) ? false : true;
        this.f27561y = layoutNodeX1.U();
        this.f27562z = layoutNodeX1.getLayoutDirection();
        if (!layoutNodeX1.m() || function1 == null) {
            this.f27560x = null;
            OwnedLayer ownedLayer = this.M;
            if (ownedLayer != null) {
                ownedLayer.destroy();
                layoutNodeX1.M1(true);
                this.K.invoke();
                if (m() && layoutNodeX1.u() && (ownerA0 = layoutNodeX1.A0()) != null) {
                    ownerA0.k(layoutNodeX1);
                }
            }
            this.M = null;
            this.L = false;
            return;
        }
        this.f27560x = function1;
        if (this.M != null) {
            if (z3 && U3(this, false, 1, null)) {
                LayoutNodeKt.b(layoutNodeX1).getRectManager().k(layoutNodeX1);
                return;
            }
            return;
        }
        OwnedLayer ownedLayerN = Owner.n(LayoutNodeKt.b(layoutNodeX1), N2(), this.K, null, layoutNodeX1.X(), 4, null);
        ownedLayerN.d(R0());
        ownedLayerN.j(C1());
        this.M = ownedLayerN;
        U3(this, false, 1, null);
        layoutNodeX1.M1(true);
        this.K.invoke();
    }

    @Override // androidx.compose.ui.layout.LayoutCoordinates
    public long S(LayoutCoordinates layoutCoordinates, long j3) {
        return Q(layoutCoordinates, j3, true);
    }

    public abstract LookaheadDelegate S2();

    @Override // androidx.compose.ui.layout.LayoutCoordinates
    public final LayoutCoordinates T() {
        if (!m()) {
            InlineClassHelperKt.c("LayoutCoordinate operations are only valid when isAttached is true");
        }
        n3();
        return this.f27557u;
    }

    public final long T2() {
        return this.f27561y.M(X1().E0().e());
    }

    protected final MutableRect U2() {
        MutableRect mutableRect = this.F;
        if (mutableRect != null) {
            return mutableRect;
        }
        MutableRect mutableRect2 = new MutableRect(0.0f, 0.0f, 0.0f, 0.0f);
        this.F = mutableRect2;
        return mutableRect2;
    }

    protected final boolean V3(long j3) {
        if ((((9187343241974906880L ^ (j3 & 9187343241974906880L)) - 4294967297L) & (-9223372034707292160L)) != 0) {
            return false;
        }
        OwnedLayer ownedLayer = this.M;
        return ownedLayer == null || !this.f27559w || ownedLayer.g(j3);
    }

    public abstract Modifier.Node W2();

    @Override // androidx.compose.ui.layout.LayoutCoordinates
    public long X(long j3) {
        if (!m()) {
            InlineClassHelperKt.c("LayoutCoordinate operations are only valid when isAttached is true");
        }
        LayoutCoordinates layoutCoordinatesD = LayoutCoordinatesKt.d(this);
        return S(layoutCoordinatesD, Offset.p(LayoutNodeKt.b(X1()).y(j3), LayoutCoordinatesKt.f(layoutCoordinatesD)));
    }

    @Override // androidx.compose.ui.node.LookaheadCapablePlaceable, androidx.compose.ui.node.MeasureScopeWithLayoutNode
    public LayoutNode X1() {
        return this.f27553q;
    }

    public final NodeCoordinator X2() {
        return this.f27556t;
    }

    @Override // androidx.compose.ui.layout.LayoutCoordinates
    public void Y(LayoutCoordinates layoutCoordinates, float[] fArr) {
        NodeCoordinator nodeCoordinatorL3 = L3(layoutCoordinates);
        nodeCoordinatorL3.n3();
        NodeCoordinator nodeCoordinatorI2 = I2(nodeCoordinatorL3);
        Matrix.h(fArr);
        nodeCoordinatorL3.Q3(nodeCoordinatorI2, fArr);
        P3(nodeCoordinatorI2, fArr);
    }

    public final NodeCoordinator Y2() {
        return this.f27557u;
    }

    public final float Z2() {
        return this.E;
    }

    @Override // androidx.compose.ui.layout.LayoutCoordinates
    public final long a() {
        return R0();
    }

    @Override // androidx.compose.ui.node.OwnerScope
    public boolean a1() {
        return (this.M == null || this.f27558v || !X1().m()) ? false : true;
    }

    public final Modifier.Node b3(int i3) {
        boolean zI = NodeKindKt.i(i3);
        Modifier.Node nodeW2 = W2();
        if (!zI && (nodeW2 = nodeW2.getParent$ui_release()) == null) {
            return null;
        }
        for (Modifier.Node nodeC3 = c3(zI); nodeC3 != null && (nodeC3.getAggregateChildKindSet$ui_release() & i3) != 0; nodeC3 = nodeC3.getChild$ui_release()) {
            if ((nodeC3.getKindSet$ui_release() & i3) != 0) {
                return nodeC3;
            }
            if (nodeC3 == nodeW2) {
                return null;
            }
        }
        return null;
    }

    @Override // androidx.compose.ui.node.LookaheadCapablePlaceable
    public void d2() {
        GraphicsLayer graphicsLayer = this.N;
        if (graphicsLayer != null) {
            g1(C1(), this.E, graphicsLayer);
        } else {
            i1(C1(), this.E, this.f27560x);
        }
    }

    @Override // androidx.compose.ui.layout.LayoutCoordinates
    public long f0(long j3) {
        return LayoutNodeKt.b(X1()).f(x0(j3));
    }

    public final void f3(HitTestSource hitTestSource, long j3, HitTestResult hitTestResult, int i3, boolean z2) {
        boolean z3;
        Modifier.Node nodeB3 = b3(hitTestSource.a());
        boolean z4 = false;
        if (!V3(j3)) {
            if (PointerType.h(i3, PointerType.f26922b.d())) {
                float fD2 = D2(j3, T2());
                if ((Float.floatToRawIntBits(fD2) & Api.BaseClientBuilder.API_PRIORITY_OTHER) >= 2139095040 || !hitTestResult.t(fD2, false)) {
                    return;
                }
                e3(nodeB3, hitTestSource, j3, hitTestResult, i3, false, fD2);
                return;
            }
            return;
        }
        if (nodeB3 == null) {
            g3(hitTestSource, j3, hitTestResult, i3, z2);
            return;
        }
        if (j3(j3)) {
            d3(nodeB3, hitTestSource, j3, hitTestResult, i3, z2);
            return;
        }
        float fD22 = !PointerType.h(i3, PointerType.f26922b.d()) ? Float.POSITIVE_INFINITY : D2(j3, T2());
        if ((Float.floatToRawIntBits(fD22) & Api.BaseClientBuilder.API_PRIORITY_OTHER) < 2139095040) {
            z3 = z2;
            if (hitTestResult.t(fD22, z3)) {
                z4 = true;
            }
        } else {
            z3 = z2;
        }
        w3(nodeB3, hitTestSource, j3, hitTestResult, i3, z3, fD22, z4);
    }

    @Override // androidx.compose.ui.layout.Placeable
    protected void g1(long j3, float f3, GraphicsLayer graphicsLayer) {
        if (!this.f27554r) {
            y3(j3, f3, null, graphicsLayer);
            return;
        }
        LookaheadDelegate lookaheadDelegateS2 = S2();
        Intrinsics.checkNotNull(lookaheadDelegateS2);
        y3(lookaheadDelegateS2.C1(), f3, null, graphicsLayer);
    }

    public void g3(HitTestSource hitTestSource, long j3, HitTestResult hitTestResult, int i3, boolean z2) {
        NodeCoordinator nodeCoordinator = this.f27556t;
        if (nodeCoordinator != null) {
            nodeCoordinator.f3(hitTestSource, K2(nodeCoordinator, j3, false, 2, null), hitTestResult, i3, z2);
        }
    }

    @Override // androidx.compose.ui.unit.Density
    public float getDensity() {
        return X1().U().getDensity();
    }

    @Override // androidx.compose.ui.layout.IntrinsicMeasureScope
    public LayoutDirection getLayoutDirection() {
        return X1().getLayoutDirection();
    }

    public void h3() {
        OwnedLayer ownedLayer = this.M;
        if (ownedLayer != null) {
            ownedLayer.invalidate();
            return;
        }
        NodeCoordinator nodeCoordinator = this.f27557u;
        if (nodeCoordinator != null) {
            nodeCoordinator.h3();
        }
    }

    @Override // androidx.compose.ui.layout.LayoutCoordinates
    public void i0(float[] fArr) {
        Owner ownerB = LayoutNodeKt.b(X1());
        NodeCoordinator nodeCoordinatorL3 = L3(LayoutCoordinatesKt.d(this));
        Q3(nodeCoordinatorL3, fArr);
        if (ownerB instanceof MatrixPositionCalculator) {
            ((MatrixPositionCalculator) ownerB).q(fArr);
            return;
        }
        long jH = LayoutCoordinatesKt.h(nodeCoordinatorL3);
        if ((9223372034707292159L & jH) != 9205357640488583168L) {
            Matrix.n(fArr, Float.intBitsToFloat((int) (jH >> 32)), Float.intBitsToFloat((int) (jH & 4294967295L)), 0.0f);
        }
    }

    @Override // androidx.compose.ui.layout.Placeable
    protected void i1(long j3, float f3, Function1 function1) {
        if (!this.f27554r) {
            y3(j3, f3, function1, null);
            return;
        }
        LookaheadDelegate lookaheadDelegateS2 = S2();
        Intrinsics.checkNotNull(lookaheadDelegateS2);
        y3(lookaheadDelegateS2.C1(), f3, function1, null);
    }

    @Override // androidx.compose.ui.layout.LayoutCoordinates
    public Rect j0(LayoutCoordinates layoutCoordinates, boolean z2) {
        if (!m()) {
            InlineClassHelperKt.c("LayoutCoordinate operations are only valid when isAttached is true");
        }
        if (!layoutCoordinates.m()) {
            InlineClassHelperKt.c("LayoutCoordinates " + layoutCoordinates + " is not attached!");
        }
        NodeCoordinator nodeCoordinatorL3 = L3(layoutCoordinates);
        nodeCoordinatorL3.n3();
        NodeCoordinator nodeCoordinatorI2 = I2(nodeCoordinatorL3);
        MutableRect mutableRectU2 = U2();
        mutableRectU2.i(0.0f);
        mutableRectU2.k(0.0f);
        mutableRectU2.j((int) (layoutCoordinates.a() >> 32));
        mutableRectU2.h((int) (layoutCoordinates.a() & 4294967295L));
        NodeCoordinator nodeCoordinator = nodeCoordinatorL3;
        while (nodeCoordinator != nodeCoordinatorI2) {
            boolean z3 = z2;
            B3(nodeCoordinator, mutableRectU2, z3, false, 4, null);
            if (mutableRectU2.f()) {
                return Rect.f25601e.a();
            }
            nodeCoordinator = nodeCoordinator.f27557u;
            Intrinsics.checkNotNull(nodeCoordinator);
            z2 = z3;
        }
        A2(nodeCoordinatorI2, mutableRectU2, z2);
        return MutableRectKt.a(mutableRectU2);
    }

    protected final boolean j3(long j3) {
        float fIntBitsToFloat = Float.intBitsToFloat((int) (j3 >> 32));
        float fIntBitsToFloat2 = Float.intBitsToFloat((int) (j3 & 4294967295L));
        return fIntBitsToFloat >= 0.0f && fIntBitsToFloat2 >= 0.0f && fIntBitsToFloat < ((float) S0()) && fIntBitsToFloat2 < ((float) Q0());
    }

    public final boolean k3() {
        if (this.M != null && this.A <= 0.0f) {
            return true;
        }
        NodeCoordinator nodeCoordinator = this.f27557u;
        if (nodeCoordinator != null) {
            return nodeCoordinator.k3();
        }
        return false;
    }

    @Override // androidx.compose.ui.layout.LayoutCoordinates
    public boolean m() {
        return W2().isAttached();
    }

    public final void m3() {
        if (this.M != null || this.f27560x == null) {
            return;
        }
        OwnedLayer ownedLayerN = Owner.n(LayoutNodeKt.b(X1()), N2(), this.K, this.N, false, 8, null);
        ownedLayerN.d(R0());
        ownedLayerN.j(C1());
        ownedLayerN.invalidate();
        this.M = ownedLayerN;
    }

    public final void n3() {
        X1().f0().I();
    }

    public final void o3() {
        OwnedLayer ownedLayer = this.M;
        if (ownedLayer != null) {
            ownedLayer.destroy();
        }
        this.M = null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v1 */
    /* JADX WARN: Type inference failed for: r5v10 */
    /* JADX WARN: Type inference failed for: r5v11 */
    /* JADX WARN: Type inference failed for: r5v12 */
    /* JADX WARN: Type inference failed for: r5v13 */
    /* JADX WARN: Type inference failed for: r5v2, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r5v5 */
    /* JADX WARN: Type inference failed for: r5v6, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r5v7, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r5v8 */
    /* JADX WARN: Type inference failed for: r5v9 */
    /* JADX WARN: Type inference failed for: r6v0 */
    /* JADX WARN: Type inference failed for: r6v1 */
    /* JADX WARN: Type inference failed for: r6v10 */
    /* JADX WARN: Type inference failed for: r6v11 */
    /* JADX WARN: Type inference failed for: r6v2 */
    /* JADX WARN: Type inference failed for: r6v3, types: [androidx.compose.runtime.collection.MutableVector] */
    /* JADX WARN: Type inference failed for: r6v4 */
    /* JADX WARN: Type inference failed for: r6v5 */
    /* JADX WARN: Type inference failed for: r6v6, types: [androidx.compose.runtime.collection.MutableVector] */
    /* JADX WARN: Type inference failed for: r6v8 */
    /* JADX WARN: Type inference failed for: r6v9 */
    /* JADX WARN: Type inference failed for: r7v6 */
    @Override // androidx.compose.ui.layout.Measured, androidx.compose.ui.layout.IntrinsicMeasurable
    public Object p() {
        if (!X1().u0().q(NodeKind.a(64))) {
            return null;
        }
        W2();
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        for (Modifier.Node nodeP = X1().u0().p(); nodeP != null; nodeP = nodeP.getParent$ui_release()) {
            if ((NodeKind.a(64) & nodeP.getKindSet$ui_release()) != 0) {
                int iA = NodeKind.a(64);
                ?? mutableVector = 0;
                ?? H = nodeP;
                while (H != 0) {
                    if (H instanceof ParentDataModifierNode) {
                        objectRef.f140144a = ((ParentDataModifierNode) H).H(X1().U(), objectRef.f140144a);
                    } else if ((H.getKindSet$ui_release() & iA) != 0 && (H instanceof DelegatingNode)) {
                        Modifier.Node nodeN2 = ((DelegatingNode) H).n2();
                        int i3 = 0;
                        H = H;
                        mutableVector = mutableVector;
                        while (nodeN2 != null) {
                            if ((nodeN2.getKindSet$ui_release() & iA) != 0) {
                                i3++;
                                mutableVector = mutableVector;
                                if (i3 == 1) {
                                    H = nodeN2;
                                } else {
                                    if (mutableVector == 0) {
                                        mutableVector = new MutableVector(new Modifier.Node[16], 0);
                                    }
                                    if (H != 0) {
                                        mutableVector.b(H);
                                        H = 0;
                                    }
                                    mutableVector.b(nodeN2);
                                }
                            }
                            nodeN2 = nodeN2.getChild$ui_release();
                            H = H;
                            mutableVector = mutableVector;
                        }
                        if (i3 == 1) {
                        }
                    }
                    H = DelegatableNodeKt.h(mutableVector);
                }
            }
        }
        return objectRef.f140144a;
    }

    public void p3() {
        OwnedLayer ownedLayer = this.M;
        if (ownedLayer != null) {
            ownedLayer.invalidate();
        }
    }

    public final void q3() {
        R3(this.f27560x, true);
        OwnedLayer ownedLayer = this.M;
        if (ownedLayer != null) {
            ownedLayer.invalidate();
        }
    }

    @Override // androidx.compose.ui.layout.LayoutCoordinates
    public final LayoutCoordinates r0() {
        if (!m()) {
            InlineClassHelperKt.c("LayoutCoordinate operations are only valid when isAttached is true");
        }
        n3();
        return X1().x0().f27557u;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v10 */
    /* JADX WARN: Type inference failed for: r3v11 */
    /* JADX WARN: Type inference failed for: r3v12 */
    /* JADX WARN: Type inference failed for: r3v13 */
    /* JADX WARN: Type inference failed for: r3v2 */
    /* JADX WARN: Type inference failed for: r3v3, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r3v5 */
    /* JADX WARN: Type inference failed for: r3v6, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r3v7, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r3v8 */
    /* JADX WARN: Type inference failed for: r3v9 */
    /* JADX WARN: Type inference failed for: r4v1 */
    /* JADX WARN: Type inference failed for: r4v13 */
    /* JADX WARN: Type inference failed for: r4v14 */
    /* JADX WARN: Type inference failed for: r4v15 */
    /* JADX WARN: Type inference failed for: r4v16 */
    /* JADX WARN: Type inference failed for: r4v2 */
    /* JADX WARN: Type inference failed for: r4v3 */
    /* JADX WARN: Type inference failed for: r4v4, types: [androidx.compose.runtime.collection.MutableVector] */
    /* JADX WARN: Type inference failed for: r4v5 */
    /* JADX WARN: Type inference failed for: r4v6 */
    /* JADX WARN: Type inference failed for: r4v7, types: [androidx.compose.runtime.collection.MutableVector] */
    /* JADX WARN: Type inference failed for: r5v4 */
    protected void r3(int i3, int i4) {
        NodeCoordinator nodeCoordinator;
        OwnedLayer ownedLayer = this.M;
        if (ownedLayer != null) {
            ownedLayer.d(IntSize.c((((long) i3) << 32) | (((long) i4) & 4294967295L)));
        } else if (X1().u() && (nodeCoordinator = this.f27557u) != null) {
            nodeCoordinator.h3();
        }
        j1(IntSize.c((((long) i4) & 4294967295L) | (((long) i3) << 32)));
        if (this.f27560x != null) {
            T3(false);
        }
        int iA = NodeKind.a(4);
        boolean zI = NodeKindKt.i(iA);
        Modifier.Node nodeW2 = W2();
        if (zI || (nodeW2 = nodeW2.getParent$ui_release()) != null) {
            for (Modifier.Node nodeC3 = c3(zI); nodeC3 != null && (nodeC3.getAggregateChildKindSet$ui_release() & iA) != 0; nodeC3 = nodeC3.getChild$ui_release()) {
                if ((nodeC3.getKindSet$ui_release() & iA) != 0) {
                    ?? H = nodeC3;
                    ?? mutableVector = 0;
                    while (H != 0) {
                        if (H instanceof DrawModifierNode) {
                            ((DrawModifierNode) H).onMeasureResultChanged();
                        } else if ((H.getKindSet$ui_release() & iA) != 0 && (H instanceof DelegatingNode)) {
                            Modifier.Node nodeN2 = ((DelegatingNode) H).n2();
                            int i5 = 0;
                            H = H;
                            mutableVector = mutableVector;
                            while (nodeN2 != null) {
                                if ((nodeN2.getKindSet$ui_release() & iA) != 0) {
                                    i5++;
                                    mutableVector = mutableVector;
                                    if (i5 == 1) {
                                        H = nodeN2;
                                    } else {
                                        if (mutableVector == 0) {
                                            mutableVector = new MutableVector(new Modifier.Node[16], 0);
                                        }
                                        if (H != 0) {
                                            mutableVector.b(H);
                                            H = 0;
                                        }
                                        mutableVector.b(nodeN2);
                                    }
                                }
                                nodeN2 = nodeN2.getChild$ui_release();
                                H = H;
                                mutableVector = mutableVector;
                            }
                            if (i5 == 1) {
                            }
                        }
                        H = DelegatableNodeKt.h(mutableVector);
                    }
                }
                if (nodeC3 == nodeW2) {
                    break;
                }
            }
        }
        Owner ownerA0 = X1().A0();
        if (ownerA0 != null) {
            ownerA0.k(X1());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v5 */
    /* JADX WARN: Type inference failed for: r8v10 */
    /* JADX WARN: Type inference failed for: r8v11 */
    /* JADX WARN: Type inference failed for: r8v12 */
    /* JADX WARN: Type inference failed for: r8v13 */
    /* JADX WARN: Type inference failed for: r8v14 */
    /* JADX WARN: Type inference failed for: r8v15 */
    /* JADX WARN: Type inference failed for: r8v4 */
    /* JADX WARN: Type inference failed for: r8v5, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r8v7, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r8v8 */
    /* JADX WARN: Type inference failed for: r8v9, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r9v0 */
    /* JADX WARN: Type inference failed for: r9v1 */
    /* JADX WARN: Type inference failed for: r9v10 */
    /* JADX WARN: Type inference failed for: r9v11 */
    /* JADX WARN: Type inference failed for: r9v2, types: [androidx.compose.runtime.collection.MutableVector] */
    /* JADX WARN: Type inference failed for: r9v3 */
    /* JADX WARN: Type inference failed for: r9v4 */
    /* JADX WARN: Type inference failed for: r9v5 */
    /* JADX WARN: Type inference failed for: r9v6, types: [androidx.compose.runtime.collection.MutableVector] */
    /* JADX WARN: Type inference failed for: r9v8 */
    /* JADX WARN: Type inference failed for: r9v9 */
    public final void s3() {
        Modifier.Node parent$ui_release;
        if (a3(NodeKind.a(ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD))) {
            Snapshot.Companion companion = Snapshot.f24914e;
            Snapshot snapshotD = companion.d();
            Function1 function1G = snapshotD != null ? snapshotD.g() : null;
            Snapshot snapshotE = companion.e(snapshotD);
            try {
                int iA = NodeKind.a(ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD);
                boolean zI = NodeKindKt.i(iA);
                if (!zI) {
                    parent$ui_release = W2().getParent$ui_release();
                    if (parent$ui_release == null) {
                    }
                    Unit unit = Unit.f139807a;
                    companion.m(snapshotD, snapshotE, function1G);
                }
                parent$ui_release = W2();
                for (Modifier.Node nodeC3 = c3(zI); nodeC3 != null && (nodeC3.getAggregateChildKindSet$ui_release() & iA) != 0; nodeC3 = nodeC3.getChild$ui_release()) {
                    if ((nodeC3.getKindSet$ui_release() & iA) != 0) {
                        ?? mutableVector = 0;
                        ?? H = nodeC3;
                        while (H != 0) {
                            if (H instanceof LayoutAwareModifierNode) {
                                ((LayoutAwareModifierNode) H).m(R0());
                            } else if ((H.getKindSet$ui_release() & iA) != 0 && (H instanceof DelegatingNode)) {
                                Modifier.Node nodeN2 = ((DelegatingNode) H).n2();
                                int i3 = 0;
                                H = H;
                                mutableVector = mutableVector;
                                while (nodeN2 != null) {
                                    if ((nodeN2.getKindSet$ui_release() & iA) != 0) {
                                        i3++;
                                        mutableVector = mutableVector;
                                        if (i3 == 1) {
                                            H = nodeN2;
                                        } else {
                                            if (mutableVector == 0) {
                                                mutableVector = new MutableVector(new Modifier.Node[16], 0);
                                            }
                                            if (H != 0) {
                                                mutableVector.b(H);
                                                H = 0;
                                            }
                                            mutableVector.b(nodeN2);
                                        }
                                    }
                                    nodeN2 = nodeN2.getChild$ui_release();
                                    H = H;
                                    mutableVector = mutableVector;
                                }
                                if (i3 == 1) {
                                }
                            }
                            H = DelegatableNodeKt.h(mutableVector);
                        }
                    }
                    if (nodeC3 == parent$ui_release) {
                        break;
                    }
                }
                Unit unit2 = Unit.f139807a;
                companion.m(snapshotD, snapshotE, function1G);
            } catch (Throwable th) {
                companion.m(snapshotD, snapshotE, function1G);
                throw th;
            }
        }
    }

    @Override // androidx.compose.ui.node.LookaheadCapablePlaceable
    public LookaheadCapablePlaceable t1() {
        return this.f27556t;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v0 */
    /* JADX WARN: Type inference failed for: r4v1, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r4v10 */
    /* JADX WARN: Type inference failed for: r4v11 */
    /* JADX WARN: Type inference failed for: r4v3 */
    /* JADX WARN: Type inference failed for: r4v4, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r4v5, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r4v6 */
    /* JADX WARN: Type inference failed for: r4v7 */
    /* JADX WARN: Type inference failed for: r4v8 */
    /* JADX WARN: Type inference failed for: r4v9 */
    /* JADX WARN: Type inference failed for: r5v0 */
    /* JADX WARN: Type inference failed for: r5v1 */
    /* JADX WARN: Type inference failed for: r5v10 */
    /* JADX WARN: Type inference failed for: r5v11 */
    /* JADX WARN: Type inference failed for: r5v2 */
    /* JADX WARN: Type inference failed for: r5v3, types: [androidx.compose.runtime.collection.MutableVector] */
    /* JADX WARN: Type inference failed for: r5v4 */
    /* JADX WARN: Type inference failed for: r5v5 */
    /* JADX WARN: Type inference failed for: r5v6, types: [androidx.compose.runtime.collection.MutableVector] */
    /* JADX WARN: Type inference failed for: r5v8 */
    /* JADX WARN: Type inference failed for: r5v9 */
    /* JADX WARN: Type inference failed for: r6v4 */
    public final void t3() {
        int iA = NodeKind.a(ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD);
        boolean zI = NodeKindKt.i(iA);
        Modifier.Node nodeW2 = W2();
        if (!zI && (nodeW2 = nodeW2.getParent$ui_release()) == null) {
            return;
        }
        for (Modifier.Node nodeC3 = c3(zI); nodeC3 != null && (nodeC3.getAggregateChildKindSet$ui_release() & iA) != 0; nodeC3 = nodeC3.getChild$ui_release()) {
            if ((nodeC3.getKindSet$ui_release() & iA) != 0) {
                ?? H = nodeC3;
                ?? mutableVector = 0;
                while (H != 0) {
                    if (H instanceof LayoutAwareModifierNode) {
                        ((LayoutAwareModifierNode) H).p(this);
                    } else if ((H.getKindSet$ui_release() & iA) != 0 && (H instanceof DelegatingNode)) {
                        Modifier.Node nodeN2 = ((DelegatingNode) H).n2();
                        int i3 = 0;
                        H = H;
                        mutableVector = mutableVector;
                        while (nodeN2 != null) {
                            if ((nodeN2.getKindSet$ui_release() & iA) != 0) {
                                i3++;
                                mutableVector = mutableVector;
                                if (i3 == 1) {
                                    H = nodeN2;
                                } else {
                                    if (mutableVector == 0) {
                                        mutableVector = new MutableVector(new Modifier.Node[16], 0);
                                    }
                                    if (H != 0) {
                                        mutableVector.b(H);
                                        H = 0;
                                    }
                                    mutableVector.b(nodeN2);
                                }
                            }
                            nodeN2 = nodeN2.getChild$ui_release();
                            H = H;
                            mutableVector = mutableVector;
                        }
                        if (i3 == 1) {
                        }
                    }
                    H = DelegatableNodeKt.h(mutableVector);
                }
            }
            if (nodeC3 == nodeW2) {
                return;
            }
        }
    }

    public final void u3() {
        this.f27558v = true;
        this.K.invoke();
        C3();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v0 */
    /* JADX WARN: Type inference failed for: r4v1, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r4v10 */
    /* JADX WARN: Type inference failed for: r4v11 */
    /* JADX WARN: Type inference failed for: r4v3 */
    /* JADX WARN: Type inference failed for: r4v4, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r4v5, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r4v6 */
    /* JADX WARN: Type inference failed for: r4v7 */
    /* JADX WARN: Type inference failed for: r4v8 */
    /* JADX WARN: Type inference failed for: r4v9 */
    /* JADX WARN: Type inference failed for: r5v0 */
    /* JADX WARN: Type inference failed for: r5v1 */
    /* JADX WARN: Type inference failed for: r5v10 */
    /* JADX WARN: Type inference failed for: r5v11 */
    /* JADX WARN: Type inference failed for: r5v2 */
    /* JADX WARN: Type inference failed for: r5v3, types: [androidx.compose.runtime.collection.MutableVector] */
    /* JADX WARN: Type inference failed for: r5v4 */
    /* JADX WARN: Type inference failed for: r5v5 */
    /* JADX WARN: Type inference failed for: r5v6, types: [androidx.compose.runtime.collection.MutableVector] */
    /* JADX WARN: Type inference failed for: r5v8 */
    /* JADX WARN: Type inference failed for: r5v9 */
    /* JADX WARN: Type inference failed for: r6v4 */
    public final void v3() {
        if (a3(NodeKind.a(1048576))) {
            int iA = NodeKind.a(1048576);
            boolean zI = NodeKindKt.i(iA);
            Modifier.Node nodeW2 = W2();
            if (!zI && (nodeW2 = nodeW2.getParent$ui_release()) == null) {
                return;
            }
            for (Modifier.Node nodeC3 = c3(zI); nodeC3 != null && (nodeC3.getAggregateChildKindSet$ui_release() & iA) != 0; nodeC3 = nodeC3.getChild$ui_release()) {
                if ((nodeC3.getKindSet$ui_release() & iA) != 0) {
                    ?? H = nodeC3;
                    ?? mutableVector = 0;
                    while (H != 0) {
                        if (H instanceof OnUnplacedModifierNode) {
                            ((OnUnplacedModifierNode) H).l2();
                        } else if ((H.getKindSet$ui_release() & iA) != 0 && (H instanceof DelegatingNode)) {
                            Modifier.Node nodeN2 = ((DelegatingNode) H).n2();
                            int i3 = 0;
                            H = H;
                            mutableVector = mutableVector;
                            while (nodeN2 != null) {
                                if ((nodeN2.getKindSet$ui_release() & iA) != 0) {
                                    i3++;
                                    mutableVector = mutableVector;
                                    if (i3 == 1) {
                                        H = nodeN2;
                                    } else {
                                        if (mutableVector == 0) {
                                            mutableVector = new MutableVector(new Modifier.Node[16], 0);
                                        }
                                        if (H != 0) {
                                            mutableVector.b(H);
                                            H = 0;
                                        }
                                        mutableVector.b(nodeN2);
                                    }
                                }
                                nodeN2 = nodeN2.getChild$ui_release();
                                H = H;
                                mutableVector = mutableVector;
                            }
                            if (i3 == 1) {
                            }
                        }
                        H = DelegatableNodeKt.h(mutableVector);
                    }
                }
                if (nodeC3 == nodeW2) {
                    return;
                }
            }
        }
    }

    @Override // androidx.compose.ui.node.LookaheadCapablePlaceable
    public boolean w1() {
        return this.B != null;
    }

    @Override // androidx.compose.ui.layout.LayoutCoordinates
    public long x(long j3) {
        if (!m()) {
            InlineClassHelperKt.c("LayoutCoordinate operations are only valid when isAttached is true");
        }
        return S(LayoutCoordinatesKt.d(this), LayoutNodeKt.b(X1()).x(j3));
    }

    @Override // androidx.compose.ui.layout.LayoutCoordinates
    public long x0(long j3) {
        if (!m()) {
            InlineClassHelperKt.c("LayoutCoordinate operations are only valid when isAttached is true");
        }
        n3();
        long jN3 = j3;
        for (NodeCoordinator nodeCoordinator = this; nodeCoordinator != null; nodeCoordinator = nodeCoordinator.f27557u) {
            jN3 = N3(nodeCoordinator, jN3, false, 2, null);
        }
        return jN3;
    }

    @Override // androidx.compose.ui.node.LookaheadCapablePlaceable
    public MeasureResult x1() {
        MeasureResult measureResult = this.B;
        if (measureResult != null) {
            return measureResult;
        }
        throw new IllegalStateException("Asking for measurement result of unmeasured layout modifier");
    }

    public void x3(Canvas canvas, GraphicsLayer graphicsLayer) {
        NodeCoordinator nodeCoordinator = this.f27556t;
        if (nodeCoordinator != null) {
            nodeCoordinator.E2(canvas, graphicsLayer);
        }
    }

    public final void z3(long j3, float f3, Function1 function1, GraphicsLayer graphicsLayer) {
        y3(IntOffset.o(j3, N0()), f3, function1, graphicsLayer);
    }

    @Override // androidx.compose.ui.node.LookaheadCapablePlaceable
    public LayoutCoordinates u1() {
        return this;
    }
}
