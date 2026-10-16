package androidx.compose.ui.node;

import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.graphics.AndroidPaint_androidKt;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Paint;
import androidx.compose.ui.graphics.PaintingStyle;
import androidx.compose.ui.graphics.layer.GraphicsLayer;
import androidx.compose.ui.layout.AlignmentLine;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.LayoutNode;
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
public final class InnerNodeCoordinator extends NodeCoordinator {
    public static final Companion Y = new Companion(null);
    private static final Paint Z;
    private final TailModifierNode W;
    private LookaheadDelegate X;

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
    private final class LookaheadDelegateImpl extends LookaheadDelegate {
        public LookaheadDelegateImpl() {
            super(InnerNodeCoordinator.this);
        }

        @Override // androidx.compose.ui.node.LookaheadDelegate, androidx.compose.ui.layout.IntrinsicMeasurable
        public int I(int i3) {
            return X1().h1(i3);
        }

        @Override // androidx.compose.ui.node.LookaheadDelegate, androidx.compose.ui.layout.IntrinsicMeasurable
        public int d0(int i3) {
            return X1().l1(i3);
        }

        @Override // androidx.compose.ui.node.LookaheadDelegate, androidx.compose.ui.layout.IntrinsicMeasurable
        public int k0(int i3) {
            return X1().m1(i3);
        }

        @Override // androidx.compose.ui.node.LookaheadDelegate, androidx.compose.ui.layout.IntrinsicMeasurable
        public int l0(int i3) {
            return X1().i1(i3);
        }

        @Override // androidx.compose.ui.layout.Measurable
        public Placeable n0(long j3) {
            l1(j3);
            MutableVector mutableVectorH0 = X1().H0();
            Object[] objArr = mutableVectorH0.f24389a;
            int iO = mutableVectorH0.o();
            for (int i3 = 0; i3 < iO; i3++) {
                LookaheadPassDelegate lookaheadPassDelegateK0 = ((LayoutNode) objArr[i3]).k0();
                Intrinsics.checkNotNull(lookaheadPassDelegateK0);
                lookaheadPassDelegateK0.C2(LayoutNode.UsageByParent.f27394c);
            }
            A2(X1().p0().mo10measure3p2s80s(this, X1().M(), j3));
            return this;
        }

        @Override // androidx.compose.ui.node.LookaheadCapablePlaceable
        public int o1(AlignmentLine alignmentLine) {
            Integer num = (Integer) o2().N().get(alignmentLine);
            int iIntValue = num != null ? num.intValue() : Integer.MIN_VALUE;
            q2().u(alignmentLine, iIntValue);
            return iIntValue;
        }

        @Override // androidx.compose.ui.node.LookaheadDelegate
        protected void v2() {
            LookaheadPassDelegate lookaheadPassDelegateK0 = X1().k0();
            Intrinsics.checkNotNull(lookaheadPassDelegateK0);
            lookaheadPassDelegateK0.s2();
        }
    }

    static {
        Paint paintA = AndroidPaint_androidKt.a();
        paintA.u(Color.f25715b.i());
        paintA.F(1.0f);
        paintA.E(PaintingStyle.f25822b.b());
        Z = paintA;
    }

    public InnerNodeCoordinator(LayoutNode layoutNode) {
        super(layoutNode);
        this.W = new TailModifierNode();
        W2().updateCoordinator$ui_release(this);
        this.X = layoutNode.l0() != null ? new LookaheadDelegateImpl() : null;
    }

    private final void X3() {
        if (b2()) {
            return;
        }
        X1().n0().w2();
    }

    @Override // androidx.compose.ui.node.NodeCoordinator
    public void H2() {
        if (S2() == null) {
            Y3(new LookaheadDelegateImpl());
        }
    }

    @Override // androidx.compose.ui.layout.IntrinsicMeasurable
    public int I(int i3) {
        return X1().f1(i3);
    }

    @Override // androidx.compose.ui.node.NodeCoordinator
    public LookaheadDelegate S2() {
        return this.X;
    }

    @Override // androidx.compose.ui.node.NodeCoordinator
    /* JADX INFO: renamed from: W3, reason: merged with bridge method [inline-methods] */
    public TailModifierNode W2() {
        return this.W;
    }

    protected void Y3(LookaheadDelegate lookaheadDelegate) {
        this.X = lookaheadDelegate;
    }

    @Override // androidx.compose.ui.layout.IntrinsicMeasurable
    public int d0(int i3) {
        return X1().j1(i3);
    }

    @Override // androidx.compose.ui.node.NodeCoordinator, androidx.compose.ui.layout.Placeable
    protected void g1(long j3, float f3, GraphicsLayer graphicsLayer) {
        super.g1(j3, f3, graphicsLayer);
        X3();
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x003f  */
    /* JADX WARN: Removed duplicated region for block: B:35:? A[RETURN, SYNTHETIC] */
    @Override // androidx.compose.ui.node.NodeCoordinator
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void g3(androidx.compose.ui.node.NodeCoordinator.HitTestSource r11, long r12, androidx.compose.ui.node.HitTestResult r14, int r15, boolean r16) {
        /*
            r10 = this;
            androidx.compose.ui.node.LayoutNode r0 = r10.X1()
            boolean r0 = r11.d(r0)
            r4 = 1
            r5 = 0
            if (r0 == 0) goto L39
            boolean r0 = r10.V3(r12)
            if (r0 == 0) goto L17
            r6 = r15
            r5 = r16
        L15:
            r0 = r4
            goto L3d
        L17:
            androidx.compose.ui.input.pointer.PointerType$Companion r0 = androidx.compose.ui.input.pointer.PointerType.f26922b
            int r0 = r0.d()
            r6 = r15
            boolean r0 = androidx.compose.ui.input.pointer.PointerType.h(r15, r0)
            if (r0 == 0) goto L3a
            long r7 = r10.T2()
            float r0 = r10.D2(r12, r7)
            int r0 = java.lang.Float.floatToRawIntBits(r0)
            r7 = 2147483647(0x7fffffff, float:NaN)
            r0 = r0 & r7
            r7 = 2139095040(0x7f800000, float:Infinity)
            if (r0 >= r7) goto L3a
            goto L15
        L39:
            r6 = r15
        L3a:
            r0 = r5
            r5 = r16
        L3d:
            if (r0 == 0) goto L87
            int r7 = androidx.compose.ui.node.HitTestResult.d(r14)
            androidx.compose.ui.node.LayoutNode r0 = r10.X1()
            androidx.compose.runtime.collection.MutableVector r0 = r0.G0()
            java.lang.Object[] r8 = r0.f24389a
            int r0 = r0.o()
            int r0 = r0 - r4
            r9 = r0
        L53:
            if (r9 < 0) goto L84
            r0 = r8[r9]
            androidx.compose.ui.node.LayoutNode r0 = (androidx.compose.ui.node.LayoutNode) r0
            boolean r4 = r0.u()
            if (r4 == 0) goto L7e
            r1 = r6
            r6 = r5
            r5 = r1
            r2 = r12
            r4 = r14
            r1 = r0
            r0 = r11
            r0.b(r1, r2, r4, r5, r6)
            boolean r0 = r14.p()
            if (r0 != 0) goto L70
            goto L7f
        L70:
            androidx.compose.ui.node.NodeCoordinator r0 = r1.x0()
            boolean r0 = r0.J3()
            if (r0 == 0) goto L84
            r14.a()
            goto L7f
        L7e:
            r6 = r5
        L7f:
            int r9 = r9 + (-1)
            r5 = r6
            r6 = r15
            goto L53
        L84:
            androidx.compose.ui.node.HitTestResult.g(r14, r7)
        L87:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.node.InnerNodeCoordinator.g3(androidx.compose.ui.node.NodeCoordinator$HitTestSource, long, androidx.compose.ui.node.HitTestResult, int, boolean):void");
    }

    @Override // androidx.compose.ui.node.NodeCoordinator, androidx.compose.ui.layout.Placeable
    protected void i1(long j3, float f3, Function1 function1) {
        super.i1(j3, f3, function1);
        X3();
    }

    @Override // androidx.compose.ui.layout.IntrinsicMeasurable
    public int k0(int i3) {
        return X1().k1(i3);
    }

    @Override // androidx.compose.ui.layout.IntrinsicMeasurable
    public int l0(int i3) {
        return X1().g1(i3);
    }

    @Override // androidx.compose.ui.layout.Measurable
    public Placeable n0(long j3) {
        if (O2()) {
            LookaheadDelegate lookaheadDelegateS2 = S2();
            Intrinsics.checkNotNull(lookaheadDelegateS2);
            j3 = lookaheadDelegateS2.r2();
        }
        l1(j3);
        MutableVector mutableVectorH0 = X1().H0();
        Object[] objArr = mutableVectorH0.f24389a;
        int iO = mutableVectorH0.o();
        for (int i3 = 0; i3 < iO; i3++) {
            ((LayoutNode) objArr[i3]).n0().E2(LayoutNode.UsageByParent.f27394c);
        }
        F3(X1().p0().mo10measure3p2s80s(this, X1().N(), j3));
        s3();
        return this;
    }

    @Override // androidx.compose.ui.node.LookaheadCapablePlaceable
    public int o1(AlignmentLine alignmentLine) {
        LookaheadDelegate lookaheadDelegateS2 = S2();
        if (lookaheadDelegateS2 != null) {
            return lookaheadDelegateS2.o1(alignmentLine);
        }
        Integer num = (Integer) M2().N().get(alignmentLine);
        if (num != null) {
            return num.intValue();
        }
        return Integer.MIN_VALUE;
    }

    @Override // androidx.compose.ui.node.NodeCoordinator
    public void x3(Canvas canvas, GraphicsLayer graphicsLayer) {
        Owner ownerB = LayoutNodeKt.b(X1());
        MutableVector mutableVectorG0 = X1().G0();
        Object[] objArr = mutableVectorG0.f24389a;
        int iO = mutableVectorG0.o();
        for (int i3 = 0; i3 < iO; i3++) {
            LayoutNode layoutNode = (LayoutNode) objArr[i3];
            if (layoutNode.u()) {
                layoutNode.H(canvas, graphicsLayer);
            }
        }
        if (ownerB.getShowLayoutBounds()) {
            F2(canvas, Z);
        }
    }
}
