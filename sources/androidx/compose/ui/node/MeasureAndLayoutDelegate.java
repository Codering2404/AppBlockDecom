package androidx.compose.ui.node;

import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.internal.InlineClassHelperKt;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.Owner;
import androidx.compose.ui.unit.Constraints;
import androidx.media3.extractor.jpeg.xWt.jTYhJgqLBN;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function0;
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
/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class MeasureAndLayoutDelegate {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final LayoutNode f27490a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final DepthSortedSetsForDifferentPasses f27491b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f27492c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f27493d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final OnPositionedDispatcher f27494e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final MutableVector f27495f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private long f27496g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final MutableVector f27497h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private Constraints f27498i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final LayoutTreeConsistencyChecker f27499j;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    /* JADX INFO: loaded from: classes.dex */
    @Metadata
    public static final class PostponedRequest {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final LayoutNode f27500a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final boolean f27501b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final boolean f27502c;

        public PostponedRequest(LayoutNode layoutNode, boolean z2, boolean z3) {
            this.f27500a = layoutNode;
            this.f27501b = z2;
            this.f27502c = z3;
        }

        public final LayoutNode a() {
            return this.f27500a;
        }

        public final boolean b() {
            return this.f27502c;
        }

        public final boolean c() {
            return this.f27501b;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    /* JADX INFO: loaded from: classes.dex */
    @Metadata
    public /* synthetic */ class WhenMappings {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f27503a;

        static {
            int[] iArr = new int[LayoutNode.LayoutState.values().length];
            try {
                iArr[LayoutNode.LayoutState.f27385b.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[LayoutNode.LayoutState.f27384a.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[LayoutNode.LayoutState.f27387d.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[LayoutNode.LayoutState.f27386c.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[LayoutNode.LayoutState.f27388f.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            f27503a = iArr;
        }
    }

    public MeasureAndLayoutDelegate(LayoutNode layoutNode) {
        this.f27490a = layoutNode;
        Owner.Companion companion = Owner.g8;
        DepthSortedSetsForDifferentPasses depthSortedSetsForDifferentPasses = new DepthSortedSetsForDifferentPasses(companion.a());
        this.f27491b = depthSortedSetsForDifferentPasses;
        this.f27494e = new OnPositionedDispatcher();
        this.f27495f = new MutableVector(new Owner.OnLayoutCompletedListener[16], 0);
        this.f27496g = 1L;
        MutableVector mutableVector = new MutableVector(new PostponedRequest[16], 0);
        this.f27497h = mutableVector;
        this.f27499j = companion.a() ? new LayoutTreeConsistencyChecker(layoutNode, depthSortedSetsForDifferentPasses, mutableVector.h()) : null;
    }

    private final boolean A(LayoutNode layoutNode, boolean z2, boolean z3) {
        Constraints constraints;
        boolean zE;
        LayoutNode layoutNodeB0;
        if (layoutNode.y()) {
            return false;
        }
        if (!layoutNode.u() && !layoutNode.U0() && !l(layoutNode) && !Intrinsics.areEqual(layoutNode.V0(), Boolean.TRUE) && !k(layoutNode) && !layoutNode.J()) {
            return false;
        }
        if (layoutNode == this.f27490a) {
            constraints = this.f27498i;
            Intrinsics.checkNotNull(constraints);
        } else {
            constraints = null;
        }
        if (z2) {
            zE = layoutNode.j0() ? e(layoutNode, constraints) : false;
            if (z3 && ((zE || layoutNode.i0()) && Intrinsics.areEqual(layoutNode.V0(), Boolean.TRUE))) {
                layoutNode.Z0();
            }
        } else {
            boolean zF = layoutNode.o0() ? f(layoutNode, constraints) : false;
            if (z3 && layoutNode.g0() && (layoutNode == this.f27490a || ((layoutNodeB0 = layoutNode.B0()) != null && layoutNodeB0.u() && layoutNode.U0()))) {
                if (layoutNode == this.f27490a) {
                    layoutNode.r1(0, 0);
                } else {
                    layoutNode.x1();
                }
                this.f27494e.d(layoutNode);
                LayoutNodeKt.b(layoutNode).getRectManager().j(layoutNode);
                LayoutTreeConsistencyChecker layoutTreeConsistencyChecker = this.f27499j;
                if (layoutTreeConsistencyChecker != null) {
                    layoutTreeConsistencyChecker.a();
                }
            }
            zE = zF;
        }
        g();
        return zE;
    }

    static /* synthetic */ boolean B(MeasureAndLayoutDelegate measureAndLayoutDelegate, LayoutNode layoutNode, boolean z2, boolean z3, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z2 = true;
        }
        if ((i3 & 4) != 0) {
            z3 = true;
        }
        return measureAndLayoutDelegate.A(layoutNode, z2, z3);
    }

    private final void C(LayoutNode layoutNode) {
        MutableVector mutableVectorH0 = layoutNode.H0();
        Object[] objArr = mutableVectorH0.f24389a;
        int iO = mutableVectorH0.o();
        for (int i3 = 0; i3 < iO; i3++) {
            LayoutNode layoutNode2 = (LayoutNode) objArr[i3];
            if (p(layoutNode2)) {
                if (LayoutNodeLayoutDelegateKt.a(layoutNode2)) {
                    D(layoutNode2, true);
                } else {
                    C(layoutNode2);
                }
            }
        }
    }

    private final void D(LayoutNode layoutNode, boolean z2) {
        Constraints constraints;
        if (layoutNode.y()) {
            return;
        }
        if (layoutNode == this.f27490a) {
            constraints = this.f27498i;
            Intrinsics.checkNotNull(constraints);
        } else {
            constraints = null;
        }
        if (z2) {
            e(layoutNode, constraints);
        } else {
            f(layoutNode, constraints);
        }
    }

    public static /* synthetic */ boolean J(MeasureAndLayoutDelegate measureAndLayoutDelegate, LayoutNode layoutNode, boolean z2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z2 = false;
        }
        return measureAndLayoutDelegate.I(layoutNode, z2);
    }

    private final void b() {
        MutableVector mutableVector = this.f27495f;
        Object[] objArr = mutableVector.f24389a;
        int iO = mutableVector.o();
        for (int i3 = 0; i3 < iO; i3++) {
            ((Owner.OnLayoutCompletedListener) objArr[i3]).j();
        }
        this.f27495f.i();
    }

    public static /* synthetic */ void d(MeasureAndLayoutDelegate measureAndLayoutDelegate, boolean z2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            z2 = false;
        }
        measureAndLayoutDelegate.c(z2);
    }

    private final boolean e(LayoutNode layoutNode, Constraints constraints) {
        if (layoutNode.l0() == null) {
            return false;
        }
        boolean zX0 = constraints != null ? layoutNode.X0(constraints) : LayoutNode.Y0(layoutNode, null, 1, null);
        LayoutNode layoutNodeB0 = layoutNode.B0();
        if (zX0 && layoutNodeB0 != null) {
            if (layoutNodeB0.l0() == null) {
                LayoutNode.G1(layoutNodeB0, false, false, false, 3, null);
                return zX0;
            }
            if (layoutNode.r0() == LayoutNode.UsageByParent.f27392a) {
                LayoutNode.C1(layoutNodeB0, false, false, false, 3, null);
                return zX0;
            }
            if (layoutNode.r0() == LayoutNode.UsageByParent.f27393b) {
                LayoutNode.A1(layoutNodeB0, false, 1, null);
            }
        }
        return zX0;
    }

    private final boolean f(LayoutNode layoutNode, Constraints constraints) {
        boolean zT1 = constraints != null ? layoutNode.t1(constraints) : LayoutNode.u1(layoutNode, null, 1, null);
        LayoutNode layoutNodeB0 = layoutNode.B0();
        if (zT1 && layoutNodeB0 != null) {
            if (layoutNode.q0() == LayoutNode.UsageByParent.f27392a) {
                LayoutNode.G1(layoutNodeB0, false, false, false, 3, null);
                return zT1;
            }
            if (layoutNode.q0() == LayoutNode.UsageByParent.f27393b) {
                LayoutNode.E1(layoutNodeB0, false, 1, null);
            }
        }
        return zT1;
    }

    private final void g() {
        if (this.f27497h.o() != 0) {
            MutableVector mutableVector = this.f27497h;
            Object[] objArr = mutableVector.f24389a;
            int iO = mutableVector.o();
            for (int i3 = 0; i3 < iO; i3++) {
                PostponedRequest postponedRequest = (PostponedRequest) objArr[i3];
                if (postponedRequest.a().m()) {
                    if (postponedRequest.c()) {
                        LayoutNode.C1(postponedRequest.a(), postponedRequest.b(), false, false, 2, null);
                    } else {
                        LayoutNode.G1(postponedRequest.a(), postponedRequest.b(), false, false, 2, null);
                    }
                }
            }
            this.f27497h.i();
        }
    }

    private final void h(LayoutNode layoutNode) {
        MutableVector mutableVectorH0 = layoutNode.H0();
        Object[] objArr = mutableVectorH0.f24389a;
        int iO = mutableVectorH0.o();
        for (int i3 = 0; i3 < iO; i3++) {
            LayoutNode layoutNode2 = (LayoutNode) objArr[i3];
            if (Intrinsics.areEqual(layoutNode2.V0(), Boolean.TRUE) && !layoutNode2.y()) {
                if (this.f27491b.e(layoutNode2, true)) {
                    layoutNode2.Z0();
                }
                h(layoutNode2);
            }
        }
    }

    private final void j(LayoutNode layoutNode, boolean z2) {
        MutableVector mutableVectorH0 = layoutNode.H0();
        Object[] objArr = mutableVectorH0.f24389a;
        int iO = mutableVectorH0.o();
        for (int i3 = 0; i3 < iO; i3++) {
            LayoutNode layoutNode2 = (LayoutNode) objArr[i3];
            if ((!z2 && p(layoutNode2)) || (z2 && q(layoutNode2))) {
                if (LayoutNodeLayoutDelegateKt.a(layoutNode2) && !z2) {
                    if (layoutNode2.j0() && this.f27491b.e(layoutNode2, true)) {
                        A(layoutNode2, true, false);
                    } else {
                        i(layoutNode2, true);
                    }
                }
                y(layoutNode2, z2);
                if (!w(layoutNode2, z2)) {
                    j(layoutNode2, z2);
                }
            }
        }
        y(layoutNode, z2);
    }

    private final boolean k(LayoutNode layoutNode) {
        return layoutNode.j0() && q(layoutNode);
    }

    private final boolean l(LayoutNode layoutNode) {
        return layoutNode.o0() && r(layoutNode);
    }

    private final boolean p(LayoutNode layoutNode) {
        return layoutNode.q0() == LayoutNode.UsageByParent.f27392a || layoutNode.f0().c().z().k();
    }

    private final boolean q(LayoutNode layoutNode) {
        AlignmentLinesOwner alignmentLinesOwnerP;
        AlignmentLines alignmentLinesZ;
        return layoutNode.r0() == LayoutNode.UsageByParent.f27392a || !((alignmentLinesOwnerP = layoutNode.f0().p()) == null || (alignmentLinesZ = alignmentLinesOwnerP.z()) == null || !alignmentLinesZ.k());
    }

    private final boolean r(LayoutNode layoutNode) {
        do {
            if (!p(layoutNode)) {
                LayoutNode layoutNodeB0 = layoutNode.B0();
                if ((layoutNodeB0 != null ? layoutNodeB0.h0() : null) != LayoutNode.LayoutState.f27384a) {
                    return false;
                }
            }
            layoutNode = layoutNode.B0();
            if (layoutNode == null) {
                return false;
            }
        } while (!layoutNode.u());
        return true;
    }

    private final boolean w(LayoutNode layoutNode, boolean z2) {
        return z2 ? layoutNode.j0() : layoutNode.o0();
    }

    private final void y(LayoutNode layoutNode, boolean z2) {
        if (w(layoutNode, z2)) {
            A(layoutNode, z2, false);
        }
    }

    public final boolean E(LayoutNode layoutNode, boolean z2) {
        int i3 = WhenMappings.f27503a[layoutNode.h0().ordinal()];
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    if (i3 != 4 && i3 != 5) {
                        throw new NoWhenBranchMatchedException();
                    }
                }
            }
            if ((layoutNode.j0() || layoutNode.i0()) && !z2) {
                LayoutTreeConsistencyChecker layoutTreeConsistencyChecker = this.f27499j;
                if (layoutTreeConsistencyChecker != null) {
                    layoutTreeConsistencyChecker.a();
                }
                return false;
            }
            layoutNode.c1();
            layoutNode.b1();
            if (layoutNode.y()) {
                return false;
            }
            LayoutNode layoutNodeB0 = layoutNode.B0();
            if (Intrinsics.areEqual(layoutNode.V0(), Boolean.TRUE) && ((layoutNodeB0 == null || !layoutNodeB0.j0()) && (layoutNodeB0 == null || !layoutNodeB0.i0()))) {
                this.f27491b.c(layoutNode, true);
            } else if (layoutNode.u() && ((layoutNodeB0 == null || !layoutNodeB0.g0()) && (layoutNodeB0 == null || !layoutNodeB0.o0()))) {
                this.f27491b.c(layoutNode, false);
            }
            return !this.f27493d;
        }
        LayoutTreeConsistencyChecker layoutTreeConsistencyChecker2 = this.f27499j;
        if (layoutTreeConsistencyChecker2 != null) {
            layoutTreeConsistencyChecker2.a();
        }
        return false;
    }

    public final boolean F(LayoutNode layoutNode, boolean z2) {
        LayoutNode layoutNodeB0;
        LayoutNode layoutNodeB02;
        if (!(layoutNode.l0() != null)) {
            InlineClassHelperKt.c("Error: requestLookaheadRemeasure cannot be called on a node outside LookaheadScope");
        }
        int i3 = WhenMappings.f27503a[layoutNode.h0().ordinal()];
        if (i3 != 1) {
            if (i3 != 2 && i3 != 3 && i3 != 4) {
                if (i3 != 5) {
                    throw new NoWhenBranchMatchedException();
                }
                if (layoutNode.j0() && !z2) {
                    return false;
                }
                layoutNode.d1();
                layoutNode.e1();
                if (layoutNode.y()) {
                    return false;
                }
                if ((Intrinsics.areEqual(layoutNode.V0(), Boolean.TRUE) || k(layoutNode)) && ((layoutNodeB0 = layoutNode.B0()) == null || !layoutNodeB0.j0())) {
                    this.f27491b.c(layoutNode, true);
                } else if ((layoutNode.u() || l(layoutNode)) && ((layoutNodeB02 = layoutNode.B0()) == null || !layoutNodeB02.o0())) {
                    this.f27491b.c(layoutNode, false);
                }
                return !this.f27493d;
            }
            this.f27497h.b(new PostponedRequest(layoutNode, true, z2));
            LayoutTreeConsistencyChecker layoutTreeConsistencyChecker = this.f27499j;
            if (layoutTreeConsistencyChecker != null) {
                layoutTreeConsistencyChecker.a();
            }
        }
        return false;
    }

    public final void G(LayoutNode layoutNode) {
        this.f27494e.d(layoutNode);
    }

    public final boolean H(LayoutNode layoutNode, boolean z2) {
        int i3 = WhenMappings.f27503a[layoutNode.h0().ordinal()];
        if (i3 == 1 || i3 == 2 || i3 == 3 || i3 == 4) {
            LayoutTreeConsistencyChecker layoutTreeConsistencyChecker = this.f27499j;
            if (layoutTreeConsistencyChecker != null) {
                layoutTreeConsistencyChecker.a();
            }
            return false;
        }
        if (i3 != 5) {
            throw new NoWhenBranchMatchedException();
        }
        LayoutNode layoutNodeB0 = layoutNode.B0();
        boolean z3 = layoutNodeB0 == null || layoutNodeB0.u();
        if (!z2 && (layoutNode.o0() || (layoutNode.g0() && layoutNode.u() == z3 && layoutNode.u() == layoutNode.U0()))) {
            LayoutTreeConsistencyChecker layoutTreeConsistencyChecker2 = this.f27499j;
            if (layoutTreeConsistencyChecker2 != null) {
                layoutTreeConsistencyChecker2.a();
            }
            return false;
        }
        layoutNode.b1();
        if (!layoutNode.y() && layoutNode.U0() && z3) {
            if ((layoutNodeB0 == null || !layoutNodeB0.g0()) && (layoutNodeB0 == null || !layoutNodeB0.o0())) {
                this.f27491b.c(layoutNode, false);
            }
            if (!this.f27493d) {
                return true;
            }
        }
        return false;
    }

    public final boolean I(LayoutNode layoutNode, boolean z2) {
        int i3 = WhenMappings.f27503a[layoutNode.h0().ordinal()];
        if (i3 != 1 && i3 != 2) {
            if (i3 != 3 && i3 != 4) {
                if (i3 != 5) {
                    throw new NoWhenBranchMatchedException();
                }
                if (layoutNode.o0() && !z2) {
                    return false;
                }
                layoutNode.e1();
                if (layoutNode.y()) {
                    return false;
                }
                if (!layoutNode.u() && !l(layoutNode)) {
                    return false;
                }
                LayoutNode layoutNodeB0 = layoutNode.B0();
                if (layoutNodeB0 == null || !layoutNodeB0.o0()) {
                    this.f27491b.c(layoutNode, false);
                }
                return !this.f27493d;
            }
            this.f27497h.b(new PostponedRequest(layoutNode, false, z2));
            LayoutTreeConsistencyChecker layoutTreeConsistencyChecker = this.f27499j;
            if (layoutTreeConsistencyChecker != null) {
                layoutTreeConsistencyChecker.a();
            }
        }
        return false;
    }

    public final void K(long j3) {
        Constraints constraints = this.f27498i;
        if (constraints == null ? false : Constraints.f(constraints.r(), j3)) {
            return;
        }
        if (this.f27492c) {
            InlineClassHelperKt.a("updateRootConstraints called while measuring");
        }
        this.f27498i = Constraints.a(j3);
        if (this.f27490a.l0() != null) {
            this.f27490a.d1();
        }
        this.f27490a.e1();
        DepthSortedSetsForDifferentPasses depthSortedSetsForDifferentPasses = this.f27491b;
        LayoutNode layoutNode = this.f27490a;
        depthSortedSetsForDifferentPasses.c(layoutNode, layoutNode.l0() != null);
    }

    public final void c(boolean z2) {
        if (z2) {
            this.f27494e.e(this.f27490a);
        }
        this.f27494e.a();
    }

    public final void i(LayoutNode layoutNode, boolean z2) {
        if (!this.f27492c) {
            InlineClassHelperKt.c("forceMeasureTheSubtree should be executed during the measureAndLayout pass");
        }
        if (w(layoutNode, z2)) {
            InlineClassHelperKt.a("node not yet measured");
        }
        j(layoutNode, z2);
    }

    public final boolean m() {
        return this.f27492c;
    }

    public final boolean n() {
        return this.f27491b.h();
    }

    public final boolean o() {
        return this.f27494e.c();
    }

    public final boolean t(Function0 function0) throws Throwable {
        MeasureAndLayoutDelegate measureAndLayoutDelegate;
        Throwable th;
        boolean z2;
        LayoutNode layoutNodeD;
        if (!this.f27490a.m()) {
            InlineClassHelperKt.a("performMeasureAndLayout called with unattached root");
        }
        if (!this.f27490a.u()) {
            InlineClassHelperKt.a("performMeasureAndLayout called with unplaced root");
        }
        if (this.f27492c) {
            InlineClassHelperKt.a("performMeasureAndLayout called during measure layout");
        }
        boolean z3 = false;
        if (this.f27498i != null) {
            this.f27492c = true;
            this.f27493d = true;
            try {
                if (this.f27491b.h()) {
                    DepthSortedSetsForDifferentPasses depthSortedSetsForDifferentPasses = this.f27491b;
                    z2 = false;
                    while (depthSortedSetsForDifferentPasses.h()) {
                        boolean zC = depthSortedSetsForDifferentPasses.f27315a.c();
                        boolean z4 = !zC;
                        if (zC) {
                            layoutNodeD = depthSortedSetsForDifferentPasses.f27316b.d();
                        } else {
                            try {
                                layoutNodeD = depthSortedSetsForDifferentPasses.f27315a.d();
                            } catch (Throwable th2) {
                                th = th2;
                                measureAndLayoutDelegate = this;
                                measureAndLayoutDelegate.f27492c = false;
                                measureAndLayoutDelegate.f27493d = false;
                                throw th;
                            }
                        }
                        LayoutNode layoutNode = layoutNodeD;
                        measureAndLayoutDelegate = this;
                        try {
                            boolean zB = B(measureAndLayoutDelegate, layoutNode, z4, false, 4, null);
                            if (layoutNode == this.f27490a && zB) {
                                z2 = true;
                            }
                        } catch (Throwable th3) {
                            th = th3;
                            th = th;
                            measureAndLayoutDelegate.f27492c = false;
                            measureAndLayoutDelegate.f27493d = false;
                            throw th;
                        }
                    }
                    measureAndLayoutDelegate = this;
                    if (function0 != null) {
                        function0.invoke();
                    }
                } else {
                    measureAndLayoutDelegate = this;
                    z2 = false;
                }
                measureAndLayoutDelegate.f27492c = false;
                measureAndLayoutDelegate.f27493d = false;
                LayoutTreeConsistencyChecker layoutTreeConsistencyChecker = measureAndLayoutDelegate.f27499j;
                if (layoutTreeConsistencyChecker != null) {
                    layoutTreeConsistencyChecker.a();
                }
                z3 = z2;
            } catch (Throwable th4) {
                th = th4;
                measureAndLayoutDelegate = this;
            }
        }
        b();
        return z3;
    }

    public final void u(LayoutNode layoutNode, long j3) {
        if (layoutNode.y()) {
            return;
        }
        if (Intrinsics.areEqual(layoutNode, this.f27490a)) {
            InlineClassHelperKt.a("measureAndLayout called on root");
        }
        if (!this.f27490a.m()) {
            InlineClassHelperKt.a("performMeasureAndLayout called with unattached root");
        }
        if (!this.f27490a.u()) {
            InlineClassHelperKt.a("performMeasureAndLayout called with unplaced root");
        }
        if (this.f27492c) {
            InlineClassHelperKt.a("performMeasureAndLayout called during measure layout");
        }
        if (this.f27498i != null) {
            this.f27492c = true;
            this.f27493d = false;
            try {
                this.f27491b.i(layoutNode);
                if (e(layoutNode, Constraints.a(j3)) || layoutNode.i0()) {
                    if (Intrinsics.areEqual(layoutNode.V0(), Boolean.TRUE)) {
                        layoutNode.Z0();
                    }
                }
                h(layoutNode);
                f(layoutNode, Constraints.a(j3));
                if (layoutNode.g0() && layoutNode.u()) {
                    layoutNode.x1();
                    this.f27494e.d(layoutNode);
                }
                g();
                this.f27492c = false;
                this.f27493d = false;
                LayoutTreeConsistencyChecker layoutTreeConsistencyChecker = this.f27499j;
                if (layoutTreeConsistencyChecker != null) {
                    layoutTreeConsistencyChecker.a();
                }
            } catch (Throwable th) {
                this.f27492c = false;
                this.f27493d = false;
                throw th;
            }
        }
        b();
    }

    public final void v() {
        if (this.f27491b.h()) {
            if (!this.f27490a.m()) {
                InlineClassHelperKt.a("performMeasureAndLayout called with unattached root");
            }
            if (!this.f27490a.u()) {
                InlineClassHelperKt.a("performMeasureAndLayout called with unplaced root");
            }
            if (this.f27492c) {
                InlineClassHelperKt.a("performMeasureAndLayout called during measure layout");
            }
            if (this.f27498i != null) {
                this.f27492c = true;
                this.f27493d = false;
                try {
                    if (!this.f27491b.g(true)) {
                        if (this.f27490a.l0() != null) {
                            D(this.f27490a, true);
                        } else {
                            C(this.f27490a);
                        }
                    }
                    D(this.f27490a, false);
                    this.f27492c = false;
                    this.f27493d = false;
                    LayoutTreeConsistencyChecker layoutTreeConsistencyChecker = this.f27499j;
                    if (layoutTreeConsistencyChecker != null) {
                        layoutTreeConsistencyChecker.a();
                    }
                } catch (Throwable th) {
                    this.f27492c = false;
                    this.f27493d = false;
                    throw th;
                }
            }
        }
    }

    public final void x(LayoutNode layoutNode) {
        this.f27491b.i(layoutNode);
        this.f27494e.f(layoutNode);
    }

    public final void z(Owner.OnLayoutCompletedListener onLayoutCompletedListener) {
        this.f27495f.b(onLayoutCompletedListener);
    }

    public final long s() {
        if (!this.f27492c) {
            InlineClassHelperKt.a(jTYhJgqLBN.lasnlXMGI);
        }
        return this.f27496g;
    }
}
