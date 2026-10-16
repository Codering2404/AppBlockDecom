package androidx.compose.ui.node;

import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.graphics.layer.GraphicsLayer;
import androidx.compose.ui.internal.InlineClassHelperKt;
import androidx.compose.ui.layout.AlignmentLine;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntSize;
import com.google.android.gms.common.api.Api;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
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
public final class MeasurePassDelegate extends Placeable implements Measurable, AlignmentLinesOwner, MotionReferencePlacementDelegate {
    private final MutableVector A;
    private boolean B;
    private boolean C;
    private long D;
    private final Function0 E;
    private final Function0 F;
    private float G;
    private boolean H;
    private Function1 I;
    private GraphicsLayer J;
    private long K;
    private float L;
    private final Function0 M;
    private boolean N;
    private boolean O;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final LayoutNodeLayoutDelegate f27504g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f27505h;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private boolean f27508k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private boolean f27509l;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private boolean f27511n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private long f27512o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private Function1 f27513p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private GraphicsLayer f27514q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private float f27515r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private boolean f27516s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private Object f27517t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private boolean f27518u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private boolean f27519v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private boolean f27520w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private boolean f27521x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private boolean f27522y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private final AlignmentLines f27523z;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f27506i = Api.BaseClientBuilder.API_PRIORITY_OTHER;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int f27507j = Api.BaseClientBuilder.API_PRIORITY_OTHER;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private LayoutNode.UsageByParent f27510m = LayoutNode.UsageByParent.f27394c;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public /* synthetic */ class WhenMappings {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f27524a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f27525b;

        static {
            int[] iArr = new int[LayoutNode.LayoutState.values().length];
            try {
                iArr[LayoutNode.LayoutState.f27384a.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[LayoutNode.LayoutState.f27386c.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f27524a = iArr;
            int[] iArr2 = new int[LayoutNode.UsageByParent.values().length];
            try {
                iArr2[LayoutNode.UsageByParent.f27392a.ordinal()] = 1;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr2[LayoutNode.UsageByParent.f27393b.ordinal()] = 2;
            } catch (NoSuchFieldError unused4) {
            }
            f27525b = iArr2;
        }
    }

    public MeasurePassDelegate(LayoutNodeLayoutDelegate layoutNodeLayoutDelegate) {
        this.f27504g = layoutNodeLayoutDelegate;
        IntOffset.Companion companion = IntOffset.f29988b;
        this.f27512o = companion.b();
        this.f27516s = true;
        this.f27523z = new LayoutNodeAlignmentLines(this);
        this.A = new MutableVector(new MeasurePassDelegate[16], 0);
        this.B = true;
        this.D = ConstraintsKt.b(0, 0, 0, 0, 15, null);
        this.E = new Function0<Unit>() { // from class: androidx.compose.ui.node.MeasurePassDelegate$performMeasureBlock$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Object invoke() {
                m237invoke();
                return Unit.f139807a;
            }

            /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
            public final void m237invoke() {
                this.f27529a.c2().n0(this.f27529a.D);
            }
        };
        this.F = new Function0<Unit>() { // from class: androidx.compose.ui.node.MeasurePassDelegate$layoutChildrenBlock$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Object invoke() {
                m236invoke();
                return Unit.f139807a;
            }

            /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
            public final void m236invoke() {
                this.f27526a.x1();
                this.f27526a.w0(new Function1<AlignmentLinesOwner, Unit>() { // from class: androidx.compose.ui.node.MeasurePassDelegate$layoutChildrenBlock$1.1
                    public final void c(AlignmentLinesOwner alignmentLinesOwner) {
                        alignmentLinesOwner.z().t(false);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        c((AlignmentLinesOwner) obj);
                        return Unit.f139807a;
                    }
                });
                this.f27526a.g0().x1().A();
                this.f27526a.w1();
                this.f27526a.w0(new Function1<AlignmentLinesOwner, Unit>() { // from class: androidx.compose.ui.node.MeasurePassDelegate$layoutChildrenBlock$1.2
                    public final void c(AlignmentLinesOwner alignmentLinesOwner) {
                        alignmentLinesOwner.z().q(alignmentLinesOwner.z().l());
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        c((AlignmentLinesOwner) obj);
                        return Unit.f139807a;
                    }
                });
            }
        };
        this.K = companion.b();
        this.M = new Function0<Unit>() { // from class: androidx.compose.ui.node.MeasurePassDelegate$placeOuterCoordinatorBlock$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Object invoke() {
                m238invoke();
                return Unit.f139807a;
            }

            /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
            public final void m238invoke() {
                Placeable.PlacementScope placementScope;
                NodeCoordinator nodeCoordinatorY2 = this.f27530a.c2().Y2();
                if (nodeCoordinatorY2 == null || (placementScope = nodeCoordinatorY2.B1()) == null) {
                    placementScope = LayoutNodeKt.b(this.f27530a.X1()).getPlacementScope();
                }
                Placeable.PlacementScope placementScope2 = placementScope;
                MeasurePassDelegate measurePassDelegate = this.f27530a;
                Function1 function1 = measurePassDelegate.I;
                GraphicsLayer graphicsLayer = measurePassDelegate.J;
                if (graphicsLayer != null) {
                    placementScope2.y(measurePassDelegate.c2(), measurePassDelegate.K, graphicsLayer, measurePassDelegate.L);
                } else if (function1 == null) {
                    placementScope2.j(measurePassDelegate.c2(), measurePassDelegate.K, measurePassDelegate.L);
                } else {
                    placementScope2.x(measurePassDelegate.c2(), measurePassDelegate.K, measurePassDelegate.L, function1);
                }
            }
        };
    }

    private final void H2(LayoutNode layoutNode) {
        LayoutNode.UsageByParent usageByParent;
        LayoutNode layoutNodeB0 = layoutNode.B0();
        if (layoutNodeB0 == null) {
            this.f27510m = LayoutNode.UsageByParent.f27394c;
            return;
        }
        if (!(this.f27510m == LayoutNode.UsageByParent.f27394c || layoutNode.L())) {
            InlineClassHelperKt.c("measure() may not be called multiple times on the same Measurable. If you want to get the content size of the Measurable before calculating the final constraints, please use methods like minIntrinsicWidth()/maxIntrinsicWidth() and minIntrinsicHeight()/maxIntrinsicHeight()");
        }
        int i3 = WhenMappings.f27524a[layoutNodeB0.h0().ordinal()];
        if (i3 == 1) {
            usageByParent = LayoutNode.UsageByParent.f27392a;
        } else {
            if (i3 != 2) {
                throw new IllegalStateException("Measurable could be only measured from the parent's measure or layout block. Parents state is " + layoutNodeB0.h0());
            }
            usageByParent = LayoutNode.UsageByParent.f27393b;
        }
        this.f27510m = usageByParent;
    }

    private final LookaheadPassDelegate R1() {
        return this.f27504g.v();
    }

    private final void q2() {
        boolean zU = u();
        F2(true);
        LayoutNode layoutNodeX1 = X1();
        if (!zU) {
            layoutNodeX1.Z().t3();
            if (layoutNodeX1.o0()) {
                LayoutNode.G1(layoutNodeX1, true, false, false, 6, null);
            } else if (layoutNodeX1.j0()) {
                LayoutNode.C1(layoutNodeX1, true, false, false, 6, null);
            }
        }
        NodeCoordinator nodeCoordinatorX2 = layoutNodeX1.Z().X2();
        for (NodeCoordinator nodeCoordinatorX0 = layoutNodeX1.x0(); !Intrinsics.areEqual(nodeCoordinatorX0, nodeCoordinatorX2) && nodeCoordinatorX0 != null; nodeCoordinatorX0 = nodeCoordinatorX0.X2()) {
            if (nodeCoordinatorX0.P2()) {
                nodeCoordinatorX0.h3();
            }
        }
        MutableVector mutableVectorH0 = layoutNodeX1.H0();
        Object[] objArr = mutableVectorH0.f24389a;
        int iO = mutableVectorH0.o();
        for (int i3 = 0; i3 < iO; i3++) {
            LayoutNode layoutNode = (LayoutNode) objArr[i3];
            if (layoutNode.C0() != Integer.MAX_VALUE) {
                layoutNode.n0().q2();
                layoutNodeX1.H1(layoutNode);
            }
        }
    }

    private final void r2() {
        if (u()) {
            F2(false);
            LayoutNode layoutNodeX1 = X1();
            NodeCoordinator nodeCoordinatorX2 = layoutNodeX1.Z().X2();
            for (NodeCoordinator nodeCoordinatorX0 = layoutNodeX1.x0(); !Intrinsics.areEqual(nodeCoordinatorX0, nodeCoordinatorX2) && nodeCoordinatorX0 != null; nodeCoordinatorX0 = nodeCoordinatorX0.X2()) {
                nodeCoordinatorX0.v3();
                nodeCoordinatorX0.C3();
            }
            MutableVector mutableVectorH0 = X1().H0();
            Object[] objArr = mutableVectorH0.f24389a;
            int iO = mutableVectorH0.o();
            for (int i3 = 0; i3 < iO; i3++) {
                ((LayoutNode) objArr[i3]).n0().r2();
            }
        }
    }

    private final void t2() {
        MutableVector mutableVectorH0 = X1().H0();
        Object[] objArr = mutableVectorH0.f24389a;
        int iO = mutableVectorH0.o();
        for (int i3 = 0; i3 < iO; i3++) {
            LayoutNode layoutNode = (LayoutNode) objArr[i3];
            if (layoutNode.o0() && layoutNode.q0() == LayoutNode.UsageByParent.f27392a && LayoutNode.u1(layoutNode, null, 1, null)) {
                LayoutNode.G1(X1(), false, false, false, 7, null);
            }
        }
    }

    private final void u2() {
        LayoutNode.G1(X1(), false, false, false, 7, null);
        LayoutNode layoutNodeB0 = X1().B0();
        if (layoutNodeB0 == null || X1().d0() != LayoutNode.UsageByParent.f27394c) {
            return;
        }
        LayoutNode layoutNodeX1 = X1();
        int i3 = WhenMappings.f27524a[layoutNodeB0.h0().ordinal()];
        layoutNodeX1.O1(i3 != 1 ? i3 != 2 ? layoutNodeB0.d0() : LayoutNode.UsageByParent.f27393b : LayoutNode.UsageByParent.f27392a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void w1() {
        LayoutNode layoutNodeX1 = X1();
        MutableVector mutableVectorH0 = layoutNodeX1.H0();
        Object[] objArr = mutableVectorH0.f24389a;
        int iO = mutableVectorH0.o();
        for (int i3 = 0; i3 < iO; i3++) {
            LayoutNode layoutNode = (LayoutNode) objArr[i3];
            if (layoutNode.n0().f27506i != layoutNode.C0()) {
                layoutNodeX1.q1();
                layoutNodeX1.N0();
                if (layoutNode.C0() == Integer.MAX_VALUE) {
                    if (layoutNode.f0().i()) {
                        LookaheadPassDelegate lookaheadPassDelegateK0 = layoutNode.k0();
                        Intrinsics.checkNotNull(lookaheadPassDelegateK0);
                        lookaheadPassDelegateK0.l2(false);
                    }
                    layoutNode.n0().r2();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void x1() {
        this.f27504g.Y(0);
        MutableVector mutableVectorH0 = X1().H0();
        Object[] objArr = mutableVectorH0.f24389a;
        int iO = mutableVectorH0.o();
        for (int i3 = 0; i3 < iO; i3++) {
            MeasurePassDelegate measurePassDelegateN0 = ((LayoutNode) objArr[i3]).n0();
            measurePassDelegateN0.f27506i = measurePassDelegateN0.f27507j;
            measurePassDelegateN0.f27507j = Api.BaseClientBuilder.API_PRIORITY_OTHER;
            measurePassDelegateN0.f27519v = false;
            if (measurePassDelegateN0.f27510m == LayoutNode.UsageByParent.f27393b) {
                measurePassDelegateN0.f27510m = LayoutNode.UsageByParent.f27394c;
            }
        }
    }

    private final void y2(long j3, float f3, Function1 function1, GraphicsLayer graphicsLayer) {
        if (X1().y()) {
            InlineClassHelperKt.a("place is called on a deactivated node");
        }
        D2(LayoutNode.LayoutState.f27386c);
        boolean z2 = !this.f27509l;
        this.f27512o = j3;
        this.f27515r = f3;
        this.f27513p = function1;
        this.f27514q = graphicsLayer;
        this.f27509l = true;
        this.H = false;
        Owner ownerB = LayoutNodeKt.b(X1());
        ownerB.getRectManager().l(X1(), j3, z2);
        if (this.f27521x || !u()) {
            z().r(false);
            this.f27504g.N(false);
            this.I = function1;
            this.K = j3;
            this.L = f3;
            this.J = graphicsLayer;
            ownerB.getSnapshotObserver().c(X1(), false, this.M);
        } else {
            c2().z3(j3, f3, function1, graphicsLayer);
            w2();
        }
        D2(LayoutNode.LayoutState.f27388f);
    }

    private final void z2(long j3, float f3, Function1 function1, GraphicsLayer graphicsLayer) {
        Placeable.PlacementScope placementScope;
        this.f27519v = true;
        if (!IntOffset.j(j3, this.f27512o) || this.N) {
            if (this.f27504g.f() || this.f27504g.g() || this.N) {
                this.f27521x = true;
                this.N = false;
            }
            s2();
        }
        LookaheadPassDelegate lookaheadPassDelegateR1 = R1();
        if (lookaheadPassDelegateR1 != null && lookaheadPassDelegateR1.W1()) {
            NodeCoordinator nodeCoordinatorY2 = c2().Y2();
            if (nodeCoordinatorY2 == null || (placementScope = nodeCoordinatorY2.B1()) == null) {
                placementScope = LayoutNodeKt.b(X1()).getPlacementScope();
            }
            Placeable.PlacementScope placementScope2 = placementScope;
            LookaheadPassDelegate lookaheadPassDelegateR12 = R1();
            Intrinsics.checkNotNull(lookaheadPassDelegateR12);
            LayoutNode layoutNodeB0 = X1().B0();
            if (layoutNodeB0 != null) {
                layoutNodeB0.f0().X(0);
            }
            lookaheadPassDelegateR12.D2(Api.BaseClientBuilder.API_PRIORITY_OTHER);
            Placeable.PlacementScope.i(placementScope2, lookaheadPassDelegateR12, IntOffset.k(j3), IntOffset.l(j3), 0.0f, 4, null);
        }
        LookaheadPassDelegate lookaheadPassDelegateR13 = R1();
        if ((lookaheadPassDelegateR13 == null || lookaheadPassDelegateR13.c2()) ? false : true) {
            InlineClassHelperKt.c("Error: Placement happened before lookahead.");
        }
        y2(j3, f3, function1, graphicsLayer);
    }

    public final List A1() {
        X1().b2();
        if (!this.B) {
            return this.A.h();
        }
        LayoutNode layoutNodeX1 = X1();
        MutableVector mutableVector = this.A;
        MutableVector mutableVectorH0 = layoutNodeX1.H0();
        Object[] objArr = mutableVectorH0.f24389a;
        int iO = mutableVectorH0.o();
        for (int i3 = 0; i3 < iO; i3++) {
            LayoutNode layoutNode = (LayoutNode) objArr[i3];
            if (mutableVector.o() <= i3) {
                mutableVector.b(layoutNode.f0().w());
            } else {
                mutableVector.y(i3, layoutNode.f0().w());
            }
        }
        mutableVector.v(layoutNodeX1.O().size(), mutableVector.o());
        this.B = false;
        return this.A.h();
    }

    public final boolean A2(long j3) {
        if (X1().y()) {
            InlineClassHelperKt.a("measure is called on a deactivated node");
        }
        Owner ownerB = LayoutNodeKt.b(X1());
        LayoutNode layoutNodeB0 = X1().B0();
        boolean z2 = true;
        X1().K1(X1().L() || (layoutNodeB0 != null && layoutNodeB0.L()));
        if (!X1().o0() && Constraints.f(V0(), j3)) {
            Owner.o(ownerB, X1(), false, 2, null);
            X1().J1();
            return false;
        }
        z().s(false);
        w0(new Function1<AlignmentLinesOwner, Unit>() { // from class: androidx.compose.ui.node.MeasurePassDelegate$remeasure$2
            public final void c(AlignmentLinesOwner alignmentLinesOwner) {
                alignmentLinesOwner.z().u(false);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                c((AlignmentLinesOwner) obj);
                return Unit.f139807a;
            }
        });
        this.f27508k = true;
        long jA = c2().a();
        l1(j3);
        x2(j3);
        if (IntSize.e(c2().a(), jA) && c2().X0() == X0() && c2().O0() == O0()) {
            z2 = false;
        }
        j1(IntSize.c((((long) c2().O0()) & 4294967295L) | (((long) c2().X0()) << 32)));
        return z2;
    }

    public final Constraints B1() {
        if (this.f27508k) {
            return Constraints.a(V0());
        }
        return null;
    }

    public final void B2() {
        MeasurePassDelegate measurePassDelegate;
        LayoutNode layoutNodeB0;
        try {
            this.f27505h = true;
            if (!this.f27509l) {
                InlineClassHelperKt.c("replace called on unplaced item");
            }
            boolean zU = u();
            measurePassDelegate = this;
            try {
                measurePassDelegate.y2(this.f27512o, this.f27515r, this.f27513p, this.f27514q);
                if (zU && !measurePassDelegate.H && (layoutNodeB0 = X1().B0()) != null) {
                    LayoutNode.E1(layoutNodeB0, false, 1, null);
                }
                measurePassDelegate.f27505h = false;
            } catch (Throwable th) {
                th = th;
                measurePassDelegate.f27505h = false;
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            measurePassDelegate = this;
        }
    }

    public final long C1() {
        return this.f27512o;
    }

    public final void C2(boolean z2) {
        this.B = z2;
    }

    public final void D2(LayoutNode.LayoutState layoutState) {
        this.f27504g.R(layoutState);
    }

    @Override // androidx.compose.ui.node.AlignmentLinesOwner
    public void E0() {
        LayoutNode.G1(X1(), false, false, false, 7, null);
    }

    public final void E2(LayoutNode.UsageByParent usageByParent) {
        this.f27510m = usageByParent;
    }

    public void F2(boolean z2) {
        this.f27518u = z2;
    }

    public void G2(boolean z2) {
        this.O = z2;
    }

    @Override // androidx.compose.ui.layout.IntrinsicMeasurable
    public int I(int i3) {
        if (!LayoutNodeLayoutDelegateKt.a(X1())) {
            u2();
            return c2().I(i3);
        }
        LookaheadPassDelegate lookaheadPassDelegateR1 = R1();
        Intrinsics.checkNotNull(lookaheadPassDelegateR1);
        return lookaheadPassDelegateR1.I(i3);
    }

    public final boolean I2() {
        if ((p() == null && c2().p() == null) || !this.f27516s) {
            return false;
        }
        this.f27516s = false;
        this.f27517t = c2().p();
        return true;
    }

    public final boolean J1() {
        return this.C;
    }

    @Override // androidx.compose.ui.node.AlignmentLinesOwner
    public Map N() {
        if (!this.f27511n) {
            if (P1() == LayoutNode.LayoutState.f27384a) {
                z().s(true);
                if (z().g()) {
                    o2();
                }
            } else {
                z().r(true);
            }
        }
        g0().k2(true);
        a0();
        g0().k2(false);
        return z().h();
    }

    public final boolean N1() {
        return this.f27521x;
    }

    public final LayoutNode.LayoutState P1() {
        return this.f27504g.o();
    }

    @Override // androidx.compose.ui.layout.Placeable
    public int Q0() {
        return c2().Q0();
    }

    @Override // androidx.compose.ui.layout.Placeable
    public int S0() {
        return c2().S0();
    }

    @Override // androidx.compose.ui.node.AlignmentLinesOwner
    public AlignmentLinesOwner U() {
        LayoutNodeLayoutDelegate layoutNodeLayoutDelegateF0;
        LayoutNode layoutNodeB0 = X1().B0();
        if (layoutNodeB0 == null || (layoutNodeLayoutDelegateF0 = layoutNodeB0.f0()) == null) {
            return null;
        }
        return layoutNodeLayoutDelegateF0.c();
    }

    public final boolean W1() {
        return this.f27520w;
    }

    public final LayoutNode X1() {
        return this.f27504g.m();
    }

    @Override // androidx.compose.ui.node.MotionReferencePlacementDelegate
    public void Z(boolean z2) {
        if (z2 != c2().R1()) {
            c2().j2(z2);
            this.N = true;
        }
        G2(z2);
    }

    @Override // androidx.compose.ui.node.AlignmentLinesOwner
    public void a0() {
        this.C = true;
        z().o();
        if (this.f27521x) {
            t2();
        }
        if (this.f27522y || (!this.f27511n && !g0().W1() && this.f27521x)) {
            this.f27521x = false;
            LayoutNode.LayoutState layoutStateP1 = P1();
            D2(LayoutNode.LayoutState.f27386c);
            this.f27504g.O(false);
            LayoutNode layoutNodeX1 = X1();
            LayoutNodeKt.b(layoutNodeX1).getSnapshotObserver().e(layoutNodeX1, false, this.F);
            D2(layoutStateP1);
            if (g0().W1() && this.f27504g.g()) {
                requestLayout();
            }
            this.f27522y = false;
        }
        if (z().l()) {
            z().q(true);
        }
        if (z().g() && z().k()) {
            z().n();
        }
        this.C = false;
    }

    public final LayoutNode.UsageByParent b2() {
        return this.f27510m;
    }

    public final NodeCoordinator c2() {
        return this.f27504g.A();
    }

    @Override // androidx.compose.ui.layout.IntrinsicMeasurable
    public int d0(int i3) {
        if (!LayoutNodeLayoutDelegateKt.a(X1())) {
            u2();
            return c2().d0(i3);
        }
        LookaheadPassDelegate lookaheadPassDelegateR1 = R1();
        Intrinsics.checkNotNull(lookaheadPassDelegateR1);
        return lookaheadPassDelegateR1.d0(i3);
    }

    public final int d2() {
        return this.f27507j;
    }

    @Override // androidx.compose.ui.node.AlignmentLinesOwner
    public NodeCoordinator g0() {
        return X1().Z();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.compose.ui.layout.Placeable
    public void g1(long j3, float f3, GraphicsLayer graphicsLayer) {
        z2(j3, f3, null, graphicsLayer);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.compose.ui.layout.Placeable
    public void i1(long j3, float f3, Function1 function1) {
        z2(j3, f3, function1, null);
    }

    public final float j2() {
        return this.G;
    }

    @Override // androidx.compose.ui.layout.IntrinsicMeasurable
    public int k0(int i3) {
        if (!LayoutNodeLayoutDelegateKt.a(X1())) {
            u2();
            return c2().k0(i3);
        }
        LookaheadPassDelegate lookaheadPassDelegateR1 = R1();
        Intrinsics.checkNotNull(lookaheadPassDelegateR1);
        return lookaheadPassDelegateR1.k0(i3);
    }

    public final void k2(boolean z2) {
        LayoutNode layoutNode;
        LayoutNode layoutNodeB0 = X1().B0();
        LayoutNode.UsageByParent usageByParentD0 = X1().d0();
        if (layoutNodeB0 == null || usageByParentD0 == LayoutNode.UsageByParent.f27394c) {
            return;
        }
        do {
            layoutNode = layoutNodeB0;
            if (layoutNode.d0() != usageByParentD0) {
                break;
            } else {
                layoutNodeB0 = layoutNode.B0();
            }
        } while (layoutNodeB0 != null);
        int i3 = WhenMappings.f27525b[usageByParentD0.ordinal()];
        if (i3 == 1) {
            LayoutNode.G1(layoutNode, z2, false, false, 6, null);
        } else {
            if (i3 != 2) {
                throw new IllegalStateException("Intrinsics isn't used by the parent");
            }
            layoutNode.D1(z2);
        }
    }

    @Override // androidx.compose.ui.layout.IntrinsicMeasurable
    public int l0(int i3) {
        if (!LayoutNodeLayoutDelegateKt.a(X1())) {
            u2();
            return c2().l0(i3);
        }
        LookaheadPassDelegate lookaheadPassDelegateR1 = R1();
        Intrinsics.checkNotNull(lookaheadPassDelegateR1);
        return lookaheadPassDelegateR1.l0(i3);
    }

    public final void l2() {
        this.f27516s = true;
    }

    public final boolean m2() {
        return this.f27519v;
    }

    @Override // androidx.compose.ui.layout.Measurable
    public Placeable n0(long j3) {
        LayoutNode.UsageByParent usageByParentD0 = X1().d0();
        LayoutNode.UsageByParent usageByParent = LayoutNode.UsageByParent.f27394c;
        if (usageByParentD0 == usageByParent) {
            X1().B();
        }
        if (LayoutNodeLayoutDelegateKt.a(X1())) {
            LookaheadPassDelegate lookaheadPassDelegateR1 = R1();
            Intrinsics.checkNotNull(lookaheadPassDelegateR1);
            lookaheadPassDelegateR1.C2(usageByParent);
            lookaheadPassDelegateR1.n0(j3);
        }
        H2(X1());
        A2(j3);
        return this;
    }

    public final void n2() {
        this.f27504g.P(true);
    }

    public final void o2() {
        this.f27521x = true;
        this.f27522y = true;
    }

    @Override // androidx.compose.ui.layout.Measured, androidx.compose.ui.layout.IntrinsicMeasurable
    public Object p() {
        return this.f27517t;
    }

    @Override // androidx.compose.ui.layout.Measured
    public int p0(AlignmentLine alignmentLine) {
        LayoutNode layoutNodeB0 = X1().B0();
        if ((layoutNodeB0 != null ? layoutNodeB0.h0() : null) == LayoutNode.LayoutState.f27384a) {
            z().u(true);
        } else {
            LayoutNode layoutNodeB02 = X1().B0();
            if ((layoutNodeB02 != null ? layoutNodeB02.h0() : null) == LayoutNode.LayoutState.f27386c) {
                z().t(true);
            }
        }
        this.f27511n = true;
        int iP0 = c2().p0(alignmentLine);
        this.f27511n = false;
        return iP0;
    }

    public final void p2() {
        this.f27520w = true;
    }

    @Override // androidx.compose.ui.node.AlignmentLinesOwner
    public void requestLayout() {
        LayoutNode.E1(X1(), false, 1, null);
    }

    public final void s2() {
        if (this.f27504g.d() > 0) {
            MutableVector mutableVectorH0 = X1().H0();
            Object[] objArr = mutableVectorH0.f24389a;
            int iO = mutableVectorH0.o();
            for (int i3 = 0; i3 < iO; i3++) {
                LayoutNode layoutNode = (LayoutNode) objArr[i3];
                LayoutNodeLayoutDelegate layoutNodeLayoutDelegateF0 = layoutNode.f0();
                if ((layoutNodeLayoutDelegateF0.g() || layoutNodeLayoutDelegateF0.f()) && !layoutNodeLayoutDelegateF0.n()) {
                    LayoutNode.E1(layoutNode, false, 1, null);
                }
                layoutNodeLayoutDelegateF0.w().s2();
            }
        }
    }

    @Override // androidx.compose.ui.node.AlignmentLinesOwner
    public boolean u() {
        return this.f27518u;
    }

    public final void v2() {
        this.f27507j = Api.BaseClientBuilder.API_PRIORITY_OTHER;
        this.f27506i = Api.BaseClientBuilder.API_PRIORITY_OTHER;
        F2(false);
    }

    @Override // androidx.compose.ui.node.AlignmentLinesOwner
    public void w0(Function1 function1) {
        MutableVector mutableVectorH0 = X1().H0();
        Object[] objArr = mutableVectorH0.f24389a;
        int iO = mutableVectorH0.o();
        for (int i3 = 0; i3 < iO; i3++) {
            function1.invoke(((LayoutNode) objArr[i3]).f0().c());
        }
    }

    public final void w2() {
        this.H = true;
        LayoutNode layoutNodeB0 = X1().B0();
        float fZ2 = g0().Z2();
        LayoutNode layoutNodeX1 = X1();
        NodeCoordinator nodeCoordinatorZ = layoutNodeX1.Z();
        for (NodeCoordinator nodeCoordinatorX0 = layoutNodeX1.x0(); nodeCoordinatorX0 != nodeCoordinatorZ; nodeCoordinatorX0 = nodeCoordinatorX0.X2()) {
            Intrinsics.checkNotNull(nodeCoordinatorX0, "null cannot be cast to non-null type androidx.compose.ui.node.LayoutModifierNodeCoordinator");
            fZ2 += ((LayoutModifierNodeCoordinator) nodeCoordinatorX0).Z2();
        }
        if (fZ2 != this.G) {
            this.G = fZ2;
            if (layoutNodeB0 != null) {
                layoutNodeB0.q1();
            }
            if (layoutNodeB0 != null) {
                layoutNodeB0.N0();
            }
        }
        if (u()) {
            X1().Z().t3();
        } else {
            if (layoutNodeB0 != null) {
                layoutNodeB0.N0();
            }
            q2();
            if (this.f27505h && layoutNodeB0 != null) {
                LayoutNode.E1(layoutNodeB0, false, 1, null);
            }
        }
        if (layoutNodeB0 == null) {
            this.f27507j = 0;
        } else if (!this.f27505h && layoutNodeB0.h0() == LayoutNode.LayoutState.f27386c) {
            if (!(this.f27507j == Integer.MAX_VALUE)) {
                InlineClassHelperKt.c("Place was called on a node which was placed already");
            }
            this.f27507j = layoutNodeB0.f0().z();
            LayoutNodeLayoutDelegate layoutNodeLayoutDelegateF0 = layoutNodeB0.f0();
            layoutNodeLayoutDelegateF0.Y(layoutNodeLayoutDelegateF0.z() + 1);
        }
        a0();
    }

    public final void x2(long j3) {
        LayoutNode.LayoutState layoutStateP1 = P1();
        LayoutNode.LayoutState layoutState = LayoutNode.LayoutState.f27388f;
        if (!(layoutStateP1 == layoutState)) {
            InlineClassHelperKt.c("layout state is not idle before measure starts");
        }
        this.D = j3;
        LayoutNode.LayoutState layoutState2 = LayoutNode.LayoutState.f27384a;
        D2(layoutState2);
        this.f27520w = false;
        LayoutNodeKt.b(X1()).getSnapshotObserver().g(X1(), false, this.E);
        if (P1() == layoutState2) {
            o2();
            D2(layoutState);
        }
    }

    @Override // androidx.compose.ui.node.AlignmentLinesOwner
    public AlignmentLines z() {
        return this.f27523z;
    }
}
