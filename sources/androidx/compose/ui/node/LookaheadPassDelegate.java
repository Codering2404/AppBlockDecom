package androidx.compose.ui.node;

import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.graphics.layer.GraphicsLayer;
import androidx.compose.ui.internal.InlineClassHelperKt;
import androidx.compose.ui.layout.AlignmentLine;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntSize;
import com.google.android.gms.common.api.Api;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
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
public final class LookaheadPassDelegate extends Placeable implements Measurable, AlignmentLinesOwner, MotionReferencePlacementDelegate {
    private boolean A;
    private boolean B;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final LayoutNodeLayoutDelegate f27453g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f27454h;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private boolean f27458l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private boolean f27459m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private boolean f27460n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private Constraints f27461o;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private float f27463q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private Function1 f27464r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private GraphicsLayer f27465s;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private boolean f27470x;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f27455i = Api.BaseClientBuilder.API_PRIORITY_OTHER;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int f27456j = Api.BaseClientBuilder.API_PRIORITY_OTHER;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private LayoutNode.UsageByParent f27457k = LayoutNode.UsageByParent.f27394c;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private long f27462p = IntOffset.f29988b.b();

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private PlacedState f27466t = PlacedState.f27475c;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private final AlignmentLines f27467u = new LookaheadAlignmentLines(this);

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private final MutableVector f27468v = new MutableVector(new LookaheadPassDelegate[16], 0);

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private boolean f27469w = true;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private boolean f27471y = true;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private Object f27472z = P1().p();

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    private static final class PlacedState {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final PlacedState f27473a = new PlacedState("IsPlacedInLookahead", 0);

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final PlacedState f27474b = new PlacedState("IsPlacedInApproach", 1);

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final PlacedState f27475c = new PlacedState("IsNotPlaced", 2);

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private static final /* synthetic */ PlacedState[] f27476d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private static final /* synthetic */ EnumEntries f27477f;

        static {
            PlacedState[] placedStateArrA = a();
            f27476d = placedStateArrA;
            f27477f = EnumEntriesKt.a(placedStateArrA);
        }

        private PlacedState(String str, int i3) {
        }

        private static final /* synthetic */ PlacedState[] a() {
            return new PlacedState[]{f27473a, f27474b, f27475c};
        }

        public static PlacedState valueOf(String str) {
            return (PlacedState) Enum.valueOf(PlacedState.class, str);
        }

        public static PlacedState[] values() {
            return (PlacedState[]) f27476d.clone();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public /* synthetic */ class WhenMappings {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f27478a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f27479b;

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
                iArr[LayoutNode.LayoutState.f27386c.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[LayoutNode.LayoutState.f27387d.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            f27478a = iArr;
            int[] iArr2 = new int[LayoutNode.UsageByParent.values().length];
            try {
                iArr2[LayoutNode.UsageByParent.f27392a.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr2[LayoutNode.UsageByParent.f27393b.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
            f27479b = iArr2;
        }
    }

    public LookaheadPassDelegate(LayoutNodeLayoutDelegate layoutNodeLayoutDelegate) {
        this.f27453g = layoutNodeLayoutDelegate;
    }

    private final void A2(LayoutNode.LayoutState layoutState) {
        this.f27453g.R(layoutState);
    }

    private final void B2(boolean z2) {
        this.f27453g.W(z2);
    }

    private final boolean C1() {
        return this.f27453g.s();
    }

    private final void F2(LayoutNode layoutNode) {
        LayoutNode.UsageByParent usageByParent;
        LayoutNode layoutNodeB0 = layoutNode.B0();
        if (layoutNodeB0 == null) {
            this.f27457k = LayoutNode.UsageByParent.f27394c;
            return;
        }
        if (!(this.f27457k == LayoutNode.UsageByParent.f27394c || layoutNode.L())) {
            InlineClassHelperKt.c("measure() may not be called multiple times on the same Measurable. If you want to get the content size of the Measurable before calculating the final constraints, please use methods like minIntrinsicWidth()/maxIntrinsicWidth() and minIntrinsicHeight()/maxIntrinsicHeight()");
        }
        int i3 = WhenMappings.f27478a[layoutNodeB0.h0().ordinal()];
        if (i3 == 1 || i3 == 2) {
            usageByParent = LayoutNode.UsageByParent.f27392a;
        } else {
            if (i3 != 3 && i3 != 4) {
                throw new IllegalStateException("Measurable could be only measured from the parent's measure or layout block. Parents state is " + layoutNodeB0.h0());
            }
            usageByParent = LayoutNode.UsageByParent.f27393b;
        }
        this.f27457k = usageByParent;
    }

    private final boolean J1() {
        return this.f27453g.t();
    }

    private final LayoutNode.LayoutState N1() {
        return this.f27453g.o();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final LayoutNode X1() {
        return this.f27453g.m();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final NodeCoordinator b2() {
        return this.f27453g.A();
    }

    private final void m2() {
        PlacedState placedState = this.f27466t;
        if (x1()) {
            this.f27466t = PlacedState.f27474b;
        } else {
            this.f27466t = PlacedState.f27473a;
        }
        if (placedState != PlacedState.f27473a && this.f27453g.u()) {
            LayoutNode.C1(X1(), true, false, false, 6, null);
        }
        MutableVector mutableVectorH0 = X1().H0();
        Object[] objArr = mutableVectorH0.f24389a;
        int iO = mutableVectorH0.o();
        for (int i3 = 0; i3 < iO; i3++) {
            LayoutNode layoutNode = (LayoutNode) objArr[i3];
            LookaheadPassDelegate lookaheadPassDelegateK0 = layoutNode.k0();
            if (lookaheadPassDelegateK0 == null) {
                throw new IllegalArgumentException("Error: Child node's lookahead pass delegate cannot be null when in a lookahead scope.");
            }
            if (lookaheadPassDelegateK0.f27456j != Integer.MAX_VALUE) {
                lookaheadPassDelegateK0.m2();
                layoutNode.H1(layoutNode);
            }
        }
    }

    private final void p2() {
        MutableVector mutableVectorH0 = X1().H0();
        Object[] objArr = mutableVectorH0.f24389a;
        int iO = mutableVectorH0.o();
        for (int i3 = 0; i3 < iO; i3++) {
            LayoutNode layoutNode = (LayoutNode) objArr[i3];
            if (layoutNode.j0() && layoutNode.r0() == LayoutNode.UsageByParent.f27392a) {
                LookaheadPassDelegate lookaheadPassDelegateV = layoutNode.f0().v();
                Intrinsics.checkNotNull(lookaheadPassDelegateV);
                Constraints constraintsL = layoutNode.f0().l();
                Intrinsics.checkNotNull(constraintsL);
                if (lookaheadPassDelegateV.v2(constraintsL.r())) {
                    LayoutNode.C1(X1(), false, false, false, 7, null);
                }
            }
        }
    }

    private final void q2() {
        LayoutNode.C1(X1(), false, false, false, 7, null);
        LayoutNode layoutNodeB0 = X1().B0();
        if (layoutNodeB0 == null || X1().d0() != LayoutNode.UsageByParent.f27394c) {
            return;
        }
        LayoutNode layoutNodeX1 = X1();
        int i3 = WhenMappings.f27478a[layoutNodeB0.h0().ordinal()];
        layoutNodeX1.O1(i3 != 2 ? i3 != 3 ? layoutNodeB0.d0() : LayoutNode.UsageByParent.f27393b : LayoutNode.UsageByParent.f27392a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void t1() {
        MutableVector mutableVectorH0 = X1().H0();
        Object[] objArr = mutableVectorH0.f24389a;
        int iO = mutableVectorH0.o();
        for (int i3 = 0; i3 < iO; i3++) {
            LookaheadPassDelegate lookaheadPassDelegateV = ((LayoutNode) objArr[i3]).f0().v();
            Intrinsics.checkNotNull(lookaheadPassDelegateV);
            int i4 = lookaheadPassDelegateV.f27455i;
            int i5 = lookaheadPassDelegateV.f27456j;
            if (i4 != i5 && i5 == Integer.MAX_VALUE) {
                lookaheadPassDelegateV.l2(true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void u1() {
        this.f27453g.X(0);
        MutableVector mutableVectorH0 = X1().H0();
        Object[] objArr = mutableVectorH0.f24389a;
        int iO = mutableVectorH0.o();
        for (int i3 = 0; i3 < iO; i3++) {
            LookaheadPassDelegate lookaheadPassDelegateV = ((LayoutNode) objArr[i3]).f0().v();
            Intrinsics.checkNotNull(lookaheadPassDelegateV);
            lookaheadPassDelegateV.f27455i = lookaheadPassDelegateV.f27456j;
            lookaheadPassDelegateV.f27456j = Api.BaseClientBuilder.API_PRIORITY_OTHER;
            if (lookaheadPassDelegateV.f27457k == LayoutNode.UsageByParent.f27393b) {
                lookaheadPassDelegateV.f27457k = LayoutNode.UsageByParent.f27394c;
            }
        }
    }

    private final void u2(final long j3, float f3, Function1 function1, GraphicsLayer graphicsLayer) {
        LayoutNode layoutNodeB0 = X1().B0();
        LayoutNode.LayoutState layoutStateH0 = layoutNodeB0 != null ? layoutNodeB0.h0() : null;
        LayoutNode.LayoutState layoutState = LayoutNode.LayoutState.f27387d;
        if (layoutStateH0 == layoutState) {
            this.f27453g.Q(false);
        }
        if (X1().y()) {
            InlineClassHelperKt.a("place is called on a deactivated node");
        }
        A2(layoutState);
        this.f27459m = true;
        this.B = false;
        if (!IntOffset.j(j3, this.f27462p)) {
            if (this.f27453g.q() || this.f27453g.r()) {
                y2(true);
            }
            n2();
        }
        final Owner ownerB = LayoutNodeKt.b(X1());
        if (C1() || !u()) {
            this.f27453g.S(false);
            z().r(false);
            OwnerSnapshotObserver.d(ownerB.getSnapshotObserver(), X1(), false, new Function0<Unit>() { // from class: androidx.compose.ui.node.LookaheadPassDelegate$placeSelf$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Object invoke() {
                    m235invoke();
                    return Unit.f139807a;
                }

                /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
                public final void m235invoke() {
                    LookaheadDelegate lookaheadDelegateS2;
                    Placeable.PlacementScope placementScopeB1 = null;
                    if (LayoutNodeLayoutDelegateKt.a(this.f27486a.X1()) || this.f27486a.f27453g.i()) {
                        NodeCoordinator nodeCoordinatorY2 = this.f27486a.b2().Y2();
                        if (nodeCoordinatorY2 != null) {
                            placementScopeB1 = nodeCoordinatorY2.B1();
                        }
                    } else {
                        NodeCoordinator nodeCoordinatorY22 = this.f27486a.b2().Y2();
                        if (nodeCoordinatorY22 != null && (lookaheadDelegateS2 = nodeCoordinatorY22.S2()) != null) {
                            placementScopeB1 = lookaheadDelegateS2.B1();
                        }
                    }
                    if (placementScopeB1 == null) {
                        placementScopeB1 = ownerB.getPlacementScope();
                    }
                    LookaheadPassDelegate lookaheadPassDelegate = this.f27486a;
                    long j4 = j3;
                    LookaheadDelegate lookaheadDelegateS22 = lookaheadPassDelegate.b2().S2();
                    Intrinsics.checkNotNull(lookaheadDelegateS22);
                    Placeable.PlacementScope.k(placementScopeB1, lookaheadDelegateS22, j4, 0.0f, 2, null);
                }
            }, 2, null);
        } else {
            LookaheadDelegate lookaheadDelegateS2 = b2().S2();
            Intrinsics.checkNotNull(lookaheadDelegateS2);
            lookaheadDelegateS2.x2(j3);
            s2();
        }
        this.f27462p = j3;
        this.f27463q = f3;
        this.f27464r = function1;
        this.f27465s = graphicsLayer;
        A2(LayoutNode.LayoutState.f27388f);
    }

    private final boolean x1() {
        return this.f27453g.i();
    }

    private final void y2(boolean z2) {
        this.f27453g.U(z2);
    }

    private final void z2(boolean z2) {
        this.f27453g.V(z2);
    }

    public final Constraints A1() {
        return this.f27461o;
    }

    public final boolean B1() {
        return this.f27470x;
    }

    public final void C2(LayoutNode.UsageByParent usageByParent) {
        this.f27457k = usageByParent;
    }

    public final void D2(int i3) {
        this.f27456j = i3;
    }

    @Override // androidx.compose.ui.node.AlignmentLinesOwner
    public void E0() {
        LayoutNode.C1(X1(), false, false, false, 7, null);
    }

    public void E2(boolean z2) {
        this.A = z2;
    }

    public final boolean G2() {
        if (p() == null) {
            LookaheadDelegate lookaheadDelegateS2 = b2().S2();
            Intrinsics.checkNotNull(lookaheadDelegateS2);
            if (lookaheadDelegateS2.p() == null) {
                return false;
            }
        }
        if (!this.f27471y) {
            return false;
        }
        this.f27471y = false;
        LookaheadDelegate lookaheadDelegateS22 = b2().S2();
        Intrinsics.checkNotNull(lookaheadDelegateS22);
        this.f27472z = lookaheadDelegateS22.p();
        return true;
    }

    @Override // androidx.compose.ui.layout.IntrinsicMeasurable
    public int I(int i3) {
        q2();
        LookaheadDelegate lookaheadDelegateS2 = b2().S2();
        Intrinsics.checkNotNull(lookaheadDelegateS2);
        return lookaheadDelegateS2.I(i3);
    }

    @Override // androidx.compose.ui.node.AlignmentLinesOwner
    public Map N() {
        if (!this.f27458l) {
            if (N1() == LayoutNode.LayoutState.f27385b) {
                z().s(true);
                if (z().g()) {
                    this.f27453g.F();
                }
            } else {
                z().r(true);
            }
        }
        LookaheadDelegate lookaheadDelegateS2 = g0().S2();
        if (lookaheadDelegateS2 != null) {
            lookaheadDelegateS2.k2(true);
        }
        a0();
        LookaheadDelegate lookaheadDelegateS22 = g0().S2();
        if (lookaheadDelegateS22 != null) {
            lookaheadDelegateS22.k2(false);
        }
        return z().h();
    }

    public final MeasurePassDelegate P1() {
        return this.f27453g.w();
    }

    @Override // androidx.compose.ui.layout.Placeable
    public int Q0() {
        LookaheadDelegate lookaheadDelegateS2 = b2().S2();
        Intrinsics.checkNotNull(lookaheadDelegateS2);
        return lookaheadDelegateS2.Q0();
    }

    public final LayoutNode.UsageByParent R1() {
        return this.f27457k;
    }

    @Override // androidx.compose.ui.layout.Placeable
    public int S0() {
        LookaheadDelegate lookaheadDelegateS2 = b2().S2();
        Intrinsics.checkNotNull(lookaheadDelegateS2);
        return lookaheadDelegateS2.S0();
    }

    @Override // androidx.compose.ui.node.AlignmentLinesOwner
    public AlignmentLinesOwner U() {
        LayoutNodeLayoutDelegate layoutNodeLayoutDelegateF0;
        LayoutNode layoutNodeB0 = X1().B0();
        if (layoutNodeB0 == null || (layoutNodeLayoutDelegateF0 = layoutNodeB0.f0()) == null) {
            return null;
        }
        return layoutNodeLayoutDelegateF0.p();
    }

    public final boolean W1() {
        if (LayoutNodeLayoutDelegateKt.a(X1())) {
            return true;
        }
        if (this.f27466t == PlacedState.f27475c && !this.f27453g.h()) {
            this.f27453g.Q(true);
        }
        return x1();
    }

    @Override // androidx.compose.ui.node.MotionReferencePlacementDelegate
    public void Z(boolean z2) {
        LookaheadDelegate lookaheadDelegateS2;
        LookaheadDelegate lookaheadDelegateS22 = b2().S2();
        if (!Intrinsics.areEqual(Boolean.valueOf(z2), lookaheadDelegateS22 != null ? Boolean.valueOf(lookaheadDelegateS22.R1()) : null) && (lookaheadDelegateS2 = b2().S2()) != null) {
            lookaheadDelegateS2.j2(z2);
        }
        E2(z2);
    }

    @Override // androidx.compose.ui.node.AlignmentLinesOwner
    public void a0() {
        this.f27470x = true;
        z().o();
        if (C1()) {
            p2();
        }
        final LookaheadDelegate lookaheadDelegateS2 = g0().S2();
        Intrinsics.checkNotNull(lookaheadDelegateS2);
        if (J1() || (!this.f27458l && !lookaheadDelegateS2.W1() && C1())) {
            y2(false);
            LayoutNode.LayoutState layoutStateN1 = N1();
            A2(LayoutNode.LayoutState.f27387d);
            Owner ownerB = LayoutNodeKt.b(X1());
            this.f27453g.T(false);
            OwnerSnapshotObserver.f(ownerB.getSnapshotObserver(), X1(), false, new Function0<Unit>() { // from class: androidx.compose.ui.node.LookaheadPassDelegate$layoutChildren$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Object invoke() {
                    m233invoke();
                    return Unit.f139807a;
                }

                /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
                public final void m233invoke() {
                    this.f27480a.u1();
                    this.f27480a.w0(new Function1<AlignmentLinesOwner, Unit>() { // from class: androidx.compose.ui.node.LookaheadPassDelegate$layoutChildren$1.1
                        public final void c(AlignmentLinesOwner alignmentLinesOwner) {
                            alignmentLinesOwner.z().t(false);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                            c((AlignmentLinesOwner) obj);
                            return Unit.f139807a;
                        }
                    });
                    LookaheadDelegate lookaheadDelegateS22 = this.f27480a.g0().S2();
                    if (lookaheadDelegateS22 != null) {
                        boolean zW1 = lookaheadDelegateS22.W1();
                        List listO = this.f27480a.X1().O();
                        int size = listO.size();
                        for (int i3 = 0; i3 < size; i3++) {
                            LookaheadDelegate lookaheadDelegateS23 = ((LayoutNode) listO.get(i3)).x0().S2();
                            if (lookaheadDelegateS23 != null) {
                                lookaheadDelegateS23.k2(zW1);
                            }
                        }
                    }
                    lookaheadDelegateS2.x1().A();
                    LookaheadDelegate lookaheadDelegateS24 = this.f27480a.g0().S2();
                    if (lookaheadDelegateS24 != null) {
                        lookaheadDelegateS24.W1();
                        List listO2 = this.f27480a.X1().O();
                        int size2 = listO2.size();
                        for (int i4 = 0; i4 < size2; i4++) {
                            LookaheadDelegate lookaheadDelegateS25 = ((LayoutNode) listO2.get(i4)).x0().S2();
                            if (lookaheadDelegateS25 != null) {
                                lookaheadDelegateS25.k2(false);
                            }
                        }
                    }
                    this.f27480a.t1();
                    this.f27480a.w0(new Function1<AlignmentLinesOwner, Unit>() { // from class: androidx.compose.ui.node.LookaheadPassDelegate$layoutChildren$1.4
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
            }, 2, null);
            A2(layoutStateN1);
            if (this.f27453g.r() && lookaheadDelegateS2.W1()) {
                requestLayout();
            }
            z2(false);
        }
        if (z().l()) {
            z().q(true);
        }
        if (z().g() && z().k()) {
            z().n();
        }
        this.f27470x = false;
    }

    public final boolean c2() {
        return this.f27459m;
    }

    @Override // androidx.compose.ui.layout.IntrinsicMeasurable
    public int d0(int i3) {
        q2();
        LookaheadDelegate lookaheadDelegateS2 = b2().S2();
        Intrinsics.checkNotNull(lookaheadDelegateS2);
        return lookaheadDelegateS2.d0(i3);
    }

    public final void d2(boolean z2) {
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
        int i3 = WhenMappings.f27479b[usageByParentD0.ordinal()];
        if (i3 == 1) {
            if (layoutNode.l0() != null) {
                LayoutNode.C1(layoutNode, z2, false, false, 6, null);
                return;
            } else {
                LayoutNode.G1(layoutNode, z2, false, false, 6, null);
                return;
            }
        }
        if (i3 != 2) {
            throw new IllegalStateException("Intrinsics isn't used by the parent");
        }
        if (layoutNode.l0() != null) {
            layoutNode.z1(z2);
        } else {
            layoutNode.D1(z2);
        }
    }

    @Override // androidx.compose.ui.node.AlignmentLinesOwner
    public NodeCoordinator g0() {
        return X1().Z();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.compose.ui.layout.Placeable
    public void g1(long j3, float f3, GraphicsLayer graphicsLayer) {
        u2(j3, f3, null, graphicsLayer);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.compose.ui.layout.Placeable
    public void i1(long j3, float f3, Function1 function1) {
        u2(j3, f3, function1, null);
    }

    public final void j2() {
        this.f27471y = true;
    }

    @Override // androidx.compose.ui.layout.IntrinsicMeasurable
    public int k0(int i3) {
        q2();
        LookaheadDelegate lookaheadDelegateS2 = b2().S2();
        Intrinsics.checkNotNull(lookaheadDelegateS2);
        return lookaheadDelegateS2.k0(i3);
    }

    public final void k2() {
        y2(true);
        z2(true);
    }

    @Override // androidx.compose.ui.layout.IntrinsicMeasurable
    public int l0(int i3) {
        q2();
        LookaheadDelegate lookaheadDelegateS2 = b2().S2();
        Intrinsics.checkNotNull(lookaheadDelegateS2);
        return lookaheadDelegateS2.l0(i3);
    }

    public final void l2(boolean z2) {
        if (z2 && x1()) {
            return;
        }
        if (z2 || x1()) {
            this.f27466t = PlacedState.f27475c;
            MutableVector mutableVectorH0 = X1().H0();
            Object[] objArr = mutableVectorH0.f24389a;
            int iO = mutableVectorH0.o();
            for (int i3 = 0; i3 < iO; i3++) {
                LookaheadPassDelegate lookaheadPassDelegateV = ((LayoutNode) objArr[i3]).f0().v();
                Intrinsics.checkNotNull(lookaheadPassDelegateV);
                lookaheadPassDelegateV.l2(true);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0027  */
    @Override // androidx.compose.ui.layout.Measurable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public androidx.compose.ui.layout.Placeable n0(long r4) {
        /*
            r3 = this;
            androidx.compose.ui.node.LayoutNode r0 = r3.X1()
            androidx.compose.ui.node.LayoutNode r0 = r0.B0()
            r1 = 0
            if (r0 == 0) goto L10
            androidx.compose.ui.node.LayoutNode$LayoutState r0 = r0.h0()
            goto L11
        L10:
            r0 = r1
        L11:
            androidx.compose.ui.node.LayoutNode$LayoutState r2 = androidx.compose.ui.node.LayoutNode.LayoutState.f27385b
            if (r0 == r2) goto L27
            androidx.compose.ui.node.LayoutNode r0 = r3.X1()
            androidx.compose.ui.node.LayoutNode r0 = r0.B0()
            if (r0 == 0) goto L23
            androidx.compose.ui.node.LayoutNode$LayoutState r1 = r0.h0()
        L23:
            androidx.compose.ui.node.LayoutNode$LayoutState r0 = androidx.compose.ui.node.LayoutNode.LayoutState.f27387d
            if (r1 != r0) goto L2d
        L27:
            androidx.compose.ui.node.LayoutNodeLayoutDelegate r0 = r3.f27453g
            r1 = 0
            r0.P(r1)
        L2d:
            androidx.compose.ui.node.LayoutNode r0 = r3.X1()
            r3.F2(r0)
            androidx.compose.ui.node.LayoutNode r0 = r3.X1()
            androidx.compose.ui.node.LayoutNode$UsageByParent r0 = r0.d0()
            androidx.compose.ui.node.LayoutNode$UsageByParent r1 = androidx.compose.ui.node.LayoutNode.UsageByParent.f27394c
            if (r0 != r1) goto L47
            androidx.compose.ui.node.LayoutNode r0 = r3.X1()
            r0.B()
        L47:
            r3.v2(r4)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.node.LookaheadPassDelegate.n0(long):androidx.compose.ui.layout.Placeable");
    }

    public final void n2() {
        if (this.f27453g.e() > 0) {
            MutableVector mutableVectorH0 = X1().H0();
            Object[] objArr = mutableVectorH0.f24389a;
            int iO = mutableVectorH0.o();
            for (int i3 = 0; i3 < iO; i3++) {
                LayoutNode layoutNode = (LayoutNode) objArr[i3];
                LayoutNodeLayoutDelegate layoutNodeLayoutDelegateF0 = layoutNode.f0();
                if ((layoutNodeLayoutDelegateF0.r() || layoutNodeLayoutDelegateF0.q()) && !layoutNodeLayoutDelegateF0.s()) {
                    LayoutNode.A1(layoutNode, false, 1, null);
                }
                LookaheadPassDelegate lookaheadPassDelegateV = layoutNodeLayoutDelegateF0.v();
                if (lookaheadPassDelegateV != null) {
                    lookaheadPassDelegateV.n2();
                }
            }
        }
    }

    public final void o2() {
        this.f27466t = PlacedState.f27473a;
    }

    @Override // androidx.compose.ui.layout.Measured, androidx.compose.ui.layout.IntrinsicMeasurable
    public Object p() {
        return this.f27472z;
    }

    @Override // androidx.compose.ui.layout.Measured
    public int p0(AlignmentLine alignmentLine) {
        LayoutNode layoutNodeB0 = X1().B0();
        if ((layoutNodeB0 != null ? layoutNodeB0.h0() : null) == LayoutNode.LayoutState.f27385b) {
            z().u(true);
        } else {
            LayoutNode layoutNodeB02 = X1().B0();
            if ((layoutNodeB02 != null ? layoutNodeB02.h0() : null) == LayoutNode.LayoutState.f27387d) {
                z().t(true);
            }
        }
        this.f27458l = true;
        LookaheadDelegate lookaheadDelegateS2 = b2().S2();
        Intrinsics.checkNotNull(lookaheadDelegateS2);
        int iP0 = lookaheadDelegateS2.p0(alignmentLine);
        this.f27458l = false;
        return iP0;
    }

    public final void r2() {
        this.f27456j = Api.BaseClientBuilder.API_PRIORITY_OTHER;
        this.f27455i = Api.BaseClientBuilder.API_PRIORITY_OTHER;
        this.f27466t = PlacedState.f27475c;
    }

    @Override // androidx.compose.ui.node.AlignmentLinesOwner
    public void requestLayout() {
        LayoutNode.A1(X1(), false, 1, null);
    }

    public final void s2() {
        this.B = true;
        LayoutNode layoutNodeB0 = X1().B0();
        if ((this.f27466t != PlacedState.f27473a && !x1()) || (this.f27466t != PlacedState.f27474b && x1())) {
            m2();
            if (this.f27454h && layoutNodeB0 != null) {
                LayoutNode.A1(layoutNodeB0, false, 1, null);
            }
        }
        if (layoutNodeB0 == null) {
            this.f27456j = 0;
        } else if (!this.f27454h && (layoutNodeB0.h0() == LayoutNode.LayoutState.f27386c || layoutNodeB0.h0() == LayoutNode.LayoutState.f27387d)) {
            if (!(this.f27456j == Integer.MAX_VALUE)) {
                InlineClassHelperKt.c("Place was called on a node which was placed already");
            }
            this.f27456j = layoutNodeB0.f0().y();
            LayoutNodeLayoutDelegate layoutNodeLayoutDelegateF0 = layoutNodeB0.f0();
            layoutNodeLayoutDelegateF0.X(layoutNodeLayoutDelegateF0.y() + 1);
        }
        a0();
    }

    public final void t2(final long j3) {
        A2(LayoutNode.LayoutState.f27385b);
        B2(false);
        OwnerSnapshotObserver.h(LayoutNodeKt.b(X1()).getSnapshotObserver(), X1(), false, new Function0<Unit>() { // from class: androidx.compose.ui.node.LookaheadPassDelegate$performMeasure$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Object invoke() {
                m234invoke();
                return Unit.f139807a;
            }

            /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
            public final void m234invoke() {
                LookaheadDelegate lookaheadDelegateS2 = this.f27484a.b2().S2();
                Intrinsics.checkNotNull(lookaheadDelegateS2);
                lookaheadDelegateS2.n0(j3);
            }
        }, 2, null);
        k2();
        if (LayoutNodeLayoutDelegateKt.a(X1())) {
            P1().o2();
        } else {
            P1().p2();
        }
        A2(LayoutNode.LayoutState.f27388f);
    }

    @Override // androidx.compose.ui.node.AlignmentLinesOwner
    public boolean u() {
        return this.f27466t != PlacedState.f27475c;
    }

    public final boolean v2(long j3) {
        long jC;
        if (X1().y()) {
            InlineClassHelperKt.a("measure is called on a deactivated node");
        }
        LayoutNode layoutNodeB0 = X1().B0();
        X1().K1(X1().L() || (layoutNodeB0 != null && layoutNodeB0.L()));
        if (!X1().j0()) {
            Constraints constraints = this.f27461o;
            if (constraints == null ? false : Constraints.f(constraints.r(), j3)) {
                Owner ownerA0 = X1().A0();
                if (ownerA0 != null) {
                    ownerA0.m(X1(), true);
                }
                X1().J1();
                return false;
            }
        }
        this.f27461o = Constraints.a(j3);
        l1(j3);
        z().s(false);
        w0(new Function1<AlignmentLinesOwner, Unit>() { // from class: androidx.compose.ui.node.LookaheadPassDelegate$remeasure$2
            public final void c(AlignmentLinesOwner alignmentLinesOwner) {
                alignmentLinesOwner.z().u(false);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                c((AlignmentLinesOwner) obj);
                return Unit.f139807a;
            }
        });
        if (this.f27460n) {
            jC = R0();
        } else {
            long j4 = Integer.MIN_VALUE;
            jC = IntSize.c((j4 & 4294967295L) | (j4 << 32));
        }
        this.f27460n = true;
        LookaheadDelegate lookaheadDelegateS2 = b2().S2();
        if (!(lookaheadDelegateS2 != null)) {
            InlineClassHelperKt.c("Lookahead result from lookaheadRemeasure cannot be null");
        }
        this.f27453g.J(j3);
        j1(IntSize.c((((long) lookaheadDelegateS2.O0()) & 4294967295L) | (((long) lookaheadDelegateS2.X0()) << 32)));
        return (((int) (jC >> 32)) == lookaheadDelegateS2.X0() && ((int) (jC & 4294967295L)) == lookaheadDelegateS2.O0()) ? false : true;
    }

    @Override // androidx.compose.ui.node.AlignmentLinesOwner
    public void w0(Function1 function1) {
        MutableVector mutableVectorH0 = X1().H0();
        Object[] objArr = mutableVectorH0.f24389a;
        int iO = mutableVectorH0.o();
        for (int i3 = 0; i3 < iO; i3++) {
            AlignmentLinesOwner alignmentLinesOwnerP = ((LayoutNode) objArr[i3]).f0().p();
            Intrinsics.checkNotNull(alignmentLinesOwnerP);
            function1.invoke(alignmentLinesOwnerP);
        }
    }

    public final List w1() {
        X1().O();
        if (!this.f27469w) {
            return this.f27468v.h();
        }
        LayoutNode layoutNodeX1 = X1();
        MutableVector mutableVector = this.f27468v;
        MutableVector mutableVectorH0 = layoutNodeX1.H0();
        Object[] objArr = mutableVectorH0.f24389a;
        int iO = mutableVectorH0.o();
        for (int i3 = 0; i3 < iO; i3++) {
            LayoutNode layoutNode = (LayoutNode) objArr[i3];
            if (mutableVector.o() <= i3) {
                LookaheadPassDelegate lookaheadPassDelegateV = layoutNode.f0().v();
                Intrinsics.checkNotNull(lookaheadPassDelegateV);
                mutableVector.b(lookaheadPassDelegateV);
            } else {
                LookaheadPassDelegate lookaheadPassDelegateV2 = layoutNode.f0().v();
                Intrinsics.checkNotNull(lookaheadPassDelegateV2);
                mutableVector.y(i3, lookaheadPassDelegateV2);
            }
        }
        mutableVector.v(layoutNodeX1.O().size(), mutableVector.o());
        this.f27469w = false;
        return this.f27468v.h();
    }

    public final void w2() {
        LookaheadPassDelegate lookaheadPassDelegate;
        LayoutNode layoutNodeB0;
        try {
            this.f27454h = true;
            if (!this.f27459m) {
                InlineClassHelperKt.c("replace() called on item that was not placed");
            }
            this.B = false;
            boolean zU = u();
            lookaheadPassDelegate = this;
            try {
                lookaheadPassDelegate.u2(this.f27462p, 0.0f, this.f27464r, this.f27465s);
                if (zU && !lookaheadPassDelegate.B && (layoutNodeB0 = X1().B0()) != null) {
                    LayoutNode.A1(layoutNodeB0, false, 1, null);
                }
                lookaheadPassDelegate.f27454h = false;
            } catch (Throwable th) {
                th = th;
                lookaheadPassDelegate.f27454h = false;
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            lookaheadPassDelegate = this;
        }
    }

    public final void x2(boolean z2) {
        this.f27469w = z2;
    }

    @Override // androidx.compose.ui.node.AlignmentLinesOwner
    public AlignmentLines z() {
        return this.f27467u;
    }
}
