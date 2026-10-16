package androidx.compose.ui.node;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.AndroidPaint_androidKt;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Paint;
import androidx.compose.ui.graphics.PaintingStyle;
import androidx.compose.ui.graphics.layer.GraphicsLayer;
import androidx.compose.ui.layout.AlignmentLine;
import androidx.compose.ui.layout.ApproachLayoutModifierNode;
import androidx.compose.ui.layout.ApproachMeasureScopeImpl;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Constraints;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
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
public final class LayoutModifierNodeCoordinator extends NodeCoordinator {

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    public static final Companion f27352a0 = new Companion(null);

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    private static final Paint f27353b0;
    private LayoutModifierNode W;
    private Constraints X;
    private LookaheadDelegate Y;
    private ApproachMeasureScopeImpl Z;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    private final class LookaheadDelegateForLayoutModifierNode extends LookaheadDelegate {
        public LookaheadDelegateForLayoutModifierNode() {
            super(LayoutModifierNodeCoordinator.this);
        }

        @Override // androidx.compose.ui.node.LookaheadDelegate, androidx.compose.ui.layout.IntrinsicMeasurable
        public int I(int i3) {
            LayoutModifierNode layoutModifierNodeX3 = LayoutModifierNodeCoordinator.this.X3();
            LookaheadDelegate lookaheadDelegateS2 = LayoutModifierNodeCoordinator.this.Z3().S2();
            Intrinsics.checkNotNull(lookaheadDelegateS2);
            return layoutModifierNodeX3.maxIntrinsicHeight(this, lookaheadDelegateS2, i3);
        }

        @Override // androidx.compose.ui.node.LookaheadDelegate, androidx.compose.ui.layout.IntrinsicMeasurable
        public int d0(int i3) {
            LayoutModifierNode layoutModifierNodeX3 = LayoutModifierNodeCoordinator.this.X3();
            LookaheadDelegate lookaheadDelegateS2 = LayoutModifierNodeCoordinator.this.Z3().S2();
            Intrinsics.checkNotNull(lookaheadDelegateS2);
            return layoutModifierNodeX3.minIntrinsicHeight(this, lookaheadDelegateS2, i3);
        }

        @Override // androidx.compose.ui.node.LookaheadDelegate, androidx.compose.ui.layout.IntrinsicMeasurable
        public int k0(int i3) {
            LayoutModifierNode layoutModifierNodeX3 = LayoutModifierNodeCoordinator.this.X3();
            LookaheadDelegate lookaheadDelegateS2 = LayoutModifierNodeCoordinator.this.Z3().S2();
            Intrinsics.checkNotNull(lookaheadDelegateS2);
            return layoutModifierNodeX3.minIntrinsicWidth(this, lookaheadDelegateS2, i3);
        }

        @Override // androidx.compose.ui.node.LookaheadDelegate, androidx.compose.ui.layout.IntrinsicMeasurable
        public int l0(int i3) {
            LayoutModifierNode layoutModifierNodeX3 = LayoutModifierNodeCoordinator.this.X3();
            LookaheadDelegate lookaheadDelegateS2 = LayoutModifierNodeCoordinator.this.Z3().S2();
            Intrinsics.checkNotNull(lookaheadDelegateS2);
            return layoutModifierNodeX3.maxIntrinsicWidth(this, lookaheadDelegateS2, i3);
        }

        @Override // androidx.compose.ui.layout.Measurable
        public Placeable n0(long j3) {
            LayoutModifierNodeCoordinator layoutModifierNodeCoordinator = LayoutModifierNodeCoordinator.this;
            l1(j3);
            layoutModifierNodeCoordinator.c4(Constraints.a(j3));
            LayoutModifierNode layoutModifierNodeX3 = layoutModifierNodeCoordinator.X3();
            LookaheadDelegate lookaheadDelegateS2 = layoutModifierNodeCoordinator.Z3().S2();
            Intrinsics.checkNotNull(lookaheadDelegateS2);
            A2(layoutModifierNodeX3.mo11measure3p2s80s(this, lookaheadDelegateS2, j3));
            return this;
        }

        @Override // androidx.compose.ui.node.LookaheadCapablePlaceable
        public int o1(AlignmentLine alignmentLine) {
            int iB = LayoutModifierNodeCoordinatorKt.b(this, alignmentLine);
            q2().u(alignmentLine, iB);
            return iB;
        }
    }

    static {
        Paint paintA = AndroidPaint_androidKt.a();
        paintA.u(Color.f25715b.b());
        paintA.F(1.0f);
        paintA.E(PaintingStyle.f25822b.b());
        f27353b0 = paintA;
    }

    public LayoutModifierNodeCoordinator(LayoutNode layoutNode, LayoutModifierNode layoutModifierNode) {
        super(layoutNode);
        this.W = layoutModifierNode;
        ApproachMeasureScopeImpl approachMeasureScopeImpl = null;
        this.Y = layoutNode.l0() != null ? new LookaheadDelegateForLayoutModifierNode() : null;
        if ((layoutModifierNode.getNode().getKindSet$ui_release() & NodeKind.a(512)) != 0) {
            Intrinsics.checkNotNull(layoutModifierNode, "null cannot be cast to non-null type androidx.compose.ui.layout.ApproachLayoutModifierNode");
            approachMeasureScopeImpl = new ApproachMeasureScopeImpl(this, (ApproachLayoutModifierNode) layoutModifierNode);
        }
        this.Z = approachMeasureScopeImpl;
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x006b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void a4() {
        /*
            r7 = this;
            boolean r0 = r7.b2()
            if (r0 == 0) goto L7
            return
        L7:
            r7.t3()
            androidx.compose.ui.layout.ApproachMeasureScopeImpl r0 = r7.Z
            r1 = 0
            if (r0 == 0) goto L73
            androidx.compose.ui.layout.ApproachLayoutModifierNode r2 = r0.I()
            androidx.compose.ui.layout.Placeable$PlacementScope r3 = r7.B1()
            androidx.compose.ui.node.LookaheadDelegate r4 = r7.S2()
            kotlin.jvm.internal.Intrinsics.checkNotNull(r4)
            androidx.compose.ui.layout.LookaheadLayoutCoordinates r4 = r4.t2()
            boolean r2 = r2.k2(r3, r4)
            if (r2 != 0) goto L6b
            boolean r0 = r0.H()
            if (r0 != 0) goto L6b
            long r2 = r7.a()
            androidx.compose.ui.node.LookaheadDelegate r0 = r7.S2()
            r4 = 0
            if (r0 == 0) goto L42
            long r5 = r0.u2()
            androidx.compose.ui.unit.IntSize r0 = androidx.compose.ui.unit.IntSize.b(r5)
            goto L43
        L42:
            r0 = r4
        L43:
            boolean r0 = androidx.compose.ui.unit.IntSize.d(r2, r0)
            if (r0 == 0) goto L6b
            androidx.compose.ui.node.NodeCoordinator r0 = r7.Z3()
            long r2 = r0.a()
            androidx.compose.ui.node.NodeCoordinator r0 = r7.Z3()
            androidx.compose.ui.node.LookaheadDelegate r0 = r0.S2()
            if (r0 == 0) goto L63
            long r4 = r0.u2()
            androidx.compose.ui.unit.IntSize r4 = androidx.compose.ui.unit.IntSize.b(r4)
        L63:
            boolean r0 = androidx.compose.ui.unit.IntSize.d(r2, r4)
            if (r0 == 0) goto L6b
            r0 = 1
            goto L6c
        L6b:
            r0 = r1
        L6c:
            androidx.compose.ui.node.NodeCoordinator r2 = r7.Z3()
            r2.E3(r0)
        L73:
            androidx.compose.ui.layout.MeasureResult r0 = r7.x1()
            r0.A()
            androidx.compose.ui.node.NodeCoordinator r0 = r7.Z3()
            r0.E3(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.node.LayoutModifierNodeCoordinator.a4():void");
    }

    @Override // androidx.compose.ui.node.NodeCoordinator
    public void H2() {
        if (S2() == null) {
            d4(new LookaheadDelegateForLayoutModifierNode());
        }
    }

    @Override // androidx.compose.ui.layout.IntrinsicMeasurable
    public int I(int i3) {
        ApproachMeasureScopeImpl approachMeasureScopeImpl = this.Z;
        return approachMeasureScopeImpl != null ? approachMeasureScopeImpl.I().n1(approachMeasureScopeImpl, Z3(), i3) : this.W.maxIntrinsicHeight(this, Z3(), i3);
    }

    @Override // androidx.compose.ui.node.NodeCoordinator
    public LookaheadDelegate S2() {
        return this.Y;
    }

    @Override // androidx.compose.ui.node.NodeCoordinator
    public Modifier.Node W2() {
        return this.W.getNode();
    }

    public final LayoutModifierNode X3() {
        return this.W;
    }

    public final Constraints Y3() {
        return this.X;
    }

    public final NodeCoordinator Z3() {
        NodeCoordinator nodeCoordinatorX2 = X2();
        Intrinsics.checkNotNull(nodeCoordinatorX2);
        return nodeCoordinatorX2;
    }

    public final void b4(LayoutModifierNode layoutModifierNode) {
        if (!Intrinsics.areEqual(layoutModifierNode, this.W)) {
            Modifier.Node node = layoutModifierNode.getNode();
            if ((node.getKindSet$ui_release() & NodeKind.a(512)) != 0) {
                Intrinsics.checkNotNull(layoutModifierNode, "null cannot be cast to non-null type androidx.compose.ui.layout.ApproachLayoutModifierNode");
                ApproachLayoutModifierNode approachLayoutModifierNode = (ApproachLayoutModifierNode) layoutModifierNode;
                ApproachMeasureScopeImpl approachMeasureScopeImpl = this.Z;
                if (approachMeasureScopeImpl != null) {
                    approachMeasureScopeImpl.Q(approachLayoutModifierNode);
                } else {
                    approachMeasureScopeImpl = new ApproachMeasureScopeImpl(this, approachLayoutModifierNode);
                }
                this.Z = approachMeasureScopeImpl;
            } else {
                this.Z = null;
            }
        }
        this.W = layoutModifierNode;
    }

    public final void c4(Constraints constraints) {
        this.X = constraints;
    }

    @Override // androidx.compose.ui.layout.IntrinsicMeasurable
    public int d0(int i3) {
        ApproachMeasureScopeImpl approachMeasureScopeImpl = this.Z;
        return approachMeasureScopeImpl != null ? approachMeasureScopeImpl.I().B1(approachMeasureScopeImpl, Z3(), i3) : this.W.minIntrinsicHeight(this, Z3(), i3);
    }

    protected void d4(LookaheadDelegate lookaheadDelegate) {
        this.Y = lookaheadDelegate;
    }

    @Override // androidx.compose.ui.node.NodeCoordinator, androidx.compose.ui.layout.Placeable
    protected void g1(long j3, float f3, GraphicsLayer graphicsLayer) {
        super.g1(j3, f3, graphicsLayer);
        a4();
    }

    @Override // androidx.compose.ui.node.NodeCoordinator, androidx.compose.ui.layout.Placeable
    protected void i1(long j3, float f3, Function1 function1) {
        super.i1(j3, f3, function1);
        a4();
    }

    @Override // androidx.compose.ui.layout.IntrinsicMeasurable
    public int k0(int i3) {
        ApproachMeasureScopeImpl approachMeasureScopeImpl = this.Z;
        return approachMeasureScopeImpl != null ? approachMeasureScopeImpl.I().I0(approachMeasureScopeImpl, Z3(), i3) : this.W.minIntrinsicWidth(this, Z3(), i3);
    }

    @Override // androidx.compose.ui.layout.IntrinsicMeasurable
    public int l0(int i3) {
        ApproachMeasureScopeImpl approachMeasureScopeImpl = this.Z;
        return approachMeasureScopeImpl != null ? approachMeasureScopeImpl.I().j1(approachMeasureScopeImpl, Z3(), i3) : this.W.maxIntrinsicWidth(this, Z3(), i3);
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0080  */
    @Override // androidx.compose.ui.layout.Measurable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public androidx.compose.ui.layout.Placeable n0(long r7) {
        /*
            r6 = this;
            boolean r0 = r6.O2()
            if (r0 == 0) goto L17
            androidx.compose.ui.unit.Constraints r7 = r6.X
            if (r7 == 0) goto Lf
            long r7 = r7.r()
            goto L17
        Lf:
            java.lang.IllegalArgumentException r7 = new java.lang.IllegalArgumentException
            java.lang.String r8 = "Lookahead constraints cannot be null in approach pass."
            r7.<init>(r8)
            throw r7
        L17:
            androidx.compose.ui.node.NodeCoordinator.z2(r6, r7)
            androidx.compose.ui.layout.ApproachMeasureScopeImpl r0 = W3(r6)
            if (r0 == 0) goto Lb2
            androidx.compose.ui.layout.ApproachLayoutModifierNode r1 = r0.I()
            long r2 = r0.P0()
            boolean r2 = r1.S0(r2)
            r3 = 1
            r4 = 0
            if (r2 != 0) goto L3d
            androidx.compose.ui.unit.Constraints r2 = r6.Y3()
            boolean r2 = androidx.compose.ui.unit.Constraints.e(r7, r2)
            if (r2 != 0) goto L3b
            goto L3d
        L3b:
            r2 = r4
            goto L3e
        L3d:
            r2 = r3
        L3e:
            r0.O(r2)
            boolean r2 = r0.H()
            if (r2 != 0) goto L4e
            androidx.compose.ui.node.NodeCoordinator r2 = r6.Z3()
            r2.D3(r3)
        L4e:
            androidx.compose.ui.node.NodeCoordinator r2 = r6.Z3()
            androidx.compose.ui.layout.MeasureResult r7 = r1.N0(r0, r2, r7)
            androidx.compose.ui.node.NodeCoordinator r8 = r6.Z3()
            r8.D3(r4)
            int r8 = r7.getWidth()
            androidx.compose.ui.node.LookaheadDelegate r1 = r6.S2()
            kotlin.jvm.internal.Intrinsics.checkNotNull(r1)
            int r1 = r1.X0()
            if (r8 != r1) goto L80
            int r8 = r7.getHeight()
            androidx.compose.ui.node.LookaheadDelegate r1 = r6.S2()
            kotlin.jvm.internal.Intrinsics.checkNotNull(r1)
            int r1 = r1.O0()
            if (r8 != r1) goto L80
            goto L81
        L80:
            r3 = r4
        L81:
            boolean r8 = r0.H()
            if (r8 != 0) goto Lbe
            androidx.compose.ui.node.NodeCoordinator r8 = r6.Z3()
            long r0 = r8.a()
            androidx.compose.ui.node.NodeCoordinator r8 = r6.Z3()
            androidx.compose.ui.node.LookaheadDelegate r8 = r8.S2()
            if (r8 == 0) goto La2
            long r4 = r8.u2()
            androidx.compose.ui.unit.IntSize r8 = androidx.compose.ui.unit.IntSize.b(r4)
            goto La3
        La2:
            r8 = 0
        La3:
            boolean r8 = androidx.compose.ui.unit.IntSize.d(r0, r8)
            if (r8 == 0) goto Lbe
            if (r3 != 0) goto Lbe
            androidx.compose.ui.node.LayoutModifierNodeCoordinator$measure$1$1$1$1 r8 = new androidx.compose.ui.node.LayoutModifierNodeCoordinator$measure$1$1$1$1
            r8.<init>(r6)
            r7 = r8
            goto Lbe
        Lb2:
            androidx.compose.ui.node.LayoutModifierNode r0 = r6.X3()
            androidx.compose.ui.node.NodeCoordinator r1 = r6.Z3()
            androidx.compose.ui.layout.MeasureResult r7 = r0.mo11measure3p2s80s(r6, r1, r7)
        Lbe:
            r6.F3(r7)
            r6.s3()
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.node.LayoutModifierNodeCoordinator.n0(long):androidx.compose.ui.layout.Placeable");
    }

    @Override // androidx.compose.ui.node.LookaheadCapablePlaceable
    public int o1(AlignmentLine alignmentLine) {
        LookaheadDelegate lookaheadDelegateS2 = S2();
        return lookaheadDelegateS2 != null ? lookaheadDelegateS2.p2(alignmentLine) : LayoutModifierNodeCoordinatorKt.b(this, alignmentLine);
    }

    @Override // androidx.compose.ui.node.NodeCoordinator
    public void x3(Canvas canvas, GraphicsLayer graphicsLayer) {
        Z3().E2(canvas, graphicsLayer);
        if (LayoutNodeKt.b(X1()).getShowLayoutBounds()) {
            F2(canvas, f27353b0);
        }
    }
}
