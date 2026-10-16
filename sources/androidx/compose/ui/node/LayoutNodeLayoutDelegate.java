package androidx.compose.ui.node;

import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.unit.Constraints;
import kotlin.Metadata;

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
public final class LayoutNodeLayoutDelegate {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final LayoutNode f27407a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f27408b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f27409c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f27411e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f27412f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f27413g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f27414h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f27415i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private boolean f27416j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private boolean f27417k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private int f27418l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private boolean f27419m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private boolean f27420n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private int f27421o;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private LookaheadPassDelegate f27423q;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private LayoutNode.LayoutState f27410d = LayoutNode.LayoutState.f27388f;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private final MeasurePassDelegate f27422p = new MeasurePassDelegate(this);

    public LayoutNodeLayoutDelegate(LayoutNode layoutNode) {
        this.f27407a = layoutNode;
    }

    public final NodeCoordinator A() {
        return this.f27407a.u0().o();
    }

    public final int B() {
        return this.f27422p.X0();
    }

    public final void C() {
        this.f27422p.l2();
        LookaheadPassDelegate lookaheadPassDelegate = this.f27423q;
        if (lookaheadPassDelegate != null) {
            lookaheadPassDelegate.j2();
        }
    }

    public final void D() {
        this.f27422p.C2(true);
        LookaheadPassDelegate lookaheadPassDelegate = this.f27423q;
        if (lookaheadPassDelegate != null) {
            lookaheadPassDelegate.x2(true);
        }
    }

    public final void E() {
        this.f27422p.o2();
    }

    public final void F() {
        this.f27412f = true;
        this.f27413g = true;
    }

    public final void G() {
        this.f27411e = true;
    }

    public final void H() {
        this.f27422p.p2();
    }

    public final void I() {
        LayoutNode.LayoutState layoutStateH0 = this.f27407a.h0();
        if (layoutStateH0 == LayoutNode.LayoutState.f27386c || layoutStateH0 == LayoutNode.LayoutState.f27387d) {
            if (this.f27422p.J1()) {
                O(true);
            } else {
                N(true);
            }
        }
        if (layoutStateH0 == LayoutNode.LayoutState.f27387d) {
            LookaheadPassDelegate lookaheadPassDelegate = this.f27423q;
            if (lookaheadPassDelegate == null || !lookaheadPassDelegate.B1()) {
                S(true);
            } else {
                T(true);
            }
        }
    }

    public final void J(long j3) {
        LookaheadPassDelegate lookaheadPassDelegate = this.f27423q;
        if (lookaheadPassDelegate != null) {
            lookaheadPassDelegate.t2(j3);
        }
    }

    public final void K() {
        AlignmentLines alignmentLinesZ;
        this.f27422p.z().p();
        LookaheadPassDelegate lookaheadPassDelegate = this.f27423q;
        if (lookaheadPassDelegate == null || (alignmentLinesZ = lookaheadPassDelegate.z()) == null) {
            return;
        }
        alignmentLinesZ.p();
    }

    public final void L(int i3) {
        int i4 = this.f27418l;
        this.f27418l = i3;
        if ((i4 == 0) != (i3 == 0)) {
            LayoutNode layoutNodeB0 = this.f27407a.B0();
            LayoutNodeLayoutDelegate layoutNodeLayoutDelegateF0 = layoutNodeB0 != null ? layoutNodeB0.f0() : null;
            if (layoutNodeLayoutDelegateF0 != null) {
                if (i3 == 0) {
                    layoutNodeLayoutDelegateF0.L(layoutNodeLayoutDelegateF0.f27418l - 1);
                } else {
                    layoutNodeLayoutDelegateF0.L(layoutNodeLayoutDelegateF0.f27418l + 1);
                }
            }
        }
    }

    public final void M(int i3) {
        int i4 = this.f27421o;
        this.f27421o = i3;
        if ((i4 == 0) != (i3 == 0)) {
            LayoutNode layoutNodeB0 = this.f27407a.B0();
            LayoutNodeLayoutDelegate layoutNodeLayoutDelegateF0 = layoutNodeB0 != null ? layoutNodeB0.f0() : null;
            if (layoutNodeLayoutDelegateF0 != null) {
                if (i3 == 0) {
                    layoutNodeLayoutDelegateF0.M(layoutNodeLayoutDelegateF0.f27421o - 1);
                } else {
                    layoutNodeLayoutDelegateF0.M(layoutNodeLayoutDelegateF0.f27421o + 1);
                }
            }
        }
    }

    public final void N(boolean z2) {
        if (this.f27417k != z2) {
            this.f27417k = z2;
            if (z2 && !this.f27416j) {
                L(this.f27418l + 1);
            } else {
                if (z2 || this.f27416j) {
                    return;
                }
                L(this.f27418l - 1);
            }
        }
    }

    public final void O(boolean z2) {
        if (this.f27416j != z2) {
            this.f27416j = z2;
            if (z2 && !this.f27417k) {
                L(this.f27418l + 1);
            } else {
                if (z2 || this.f27417k) {
                    return;
                }
                L(this.f27418l - 1);
            }
        }
    }

    public final void P(boolean z2) {
        this.f27408b = z2;
    }

    public final void Q(boolean z2) {
        this.f27409c = z2;
    }

    public final void R(LayoutNode.LayoutState layoutState) {
        this.f27410d = layoutState;
    }

    public final void S(boolean z2) {
        if (this.f27420n != z2) {
            this.f27420n = z2;
            if (z2 && !this.f27419m) {
                M(this.f27421o + 1);
            } else {
                if (z2 || this.f27419m) {
                    return;
                }
                M(this.f27421o - 1);
            }
        }
    }

    public final void T(boolean z2) {
        if (this.f27419m != z2) {
            this.f27419m = z2;
            if (z2 && !this.f27420n) {
                M(this.f27421o + 1);
            } else {
                if (z2 || this.f27420n) {
                    return;
                }
                M(this.f27421o - 1);
            }
        }
    }

    public final void U(boolean z2) {
        this.f27412f = z2;
    }

    public final void V(boolean z2) {
        this.f27413g = z2;
    }

    public final void W(boolean z2) {
        this.f27411e = z2;
    }

    public final void X(int i3) {
        this.f27414h = i3;
    }

    public final void Y(int i3) {
        this.f27415i = i3;
    }

    public final void Z() {
        LayoutNode layoutNodeB0;
        if (this.f27422p.I2() && (layoutNodeB0 = this.f27407a.B0()) != null) {
            LayoutNode.G1(layoutNodeB0, false, false, false, 7, null);
        }
        LookaheadPassDelegate lookaheadPassDelegate = this.f27423q;
        if (lookaheadPassDelegate == null || !lookaheadPassDelegate.G2()) {
            return;
        }
        if (LayoutNodeLayoutDelegateKt.a(this.f27407a)) {
            LayoutNode layoutNodeB02 = this.f27407a.B0();
            if (layoutNodeB02 != null) {
                LayoutNode.G1(layoutNodeB02, false, false, false, 7, null);
                return;
            }
            return;
        }
        LayoutNode layoutNodeB03 = this.f27407a.B0();
        if (layoutNodeB03 != null) {
            LayoutNode.C1(layoutNodeB03, false, false, false, 7, null);
        }
    }

    public final void a() {
        this.f27423q = null;
    }

    public final void b() {
        if (this.f27423q == null) {
            this.f27423q = new LookaheadPassDelegate(this);
        }
    }

    public final AlignmentLinesOwner c() {
        return this.f27422p;
    }

    public final int d() {
        return this.f27418l;
    }

    public final int e() {
        return this.f27421o;
    }

    public final boolean f() {
        return this.f27417k;
    }

    public final boolean g() {
        return this.f27416j;
    }

    public final boolean h() {
        return this.f27408b;
    }

    public final boolean i() {
        return this.f27409c;
    }

    public final int j() {
        return this.f27422p.O0();
    }

    public final Constraints k() {
        return this.f27422p.B1();
    }

    public final Constraints l() {
        LookaheadPassDelegate lookaheadPassDelegate = this.f27423q;
        if (lookaheadPassDelegate != null) {
            return lookaheadPassDelegate.A1();
        }
        return null;
    }

    public final LayoutNode m() {
        return this.f27407a;
    }

    public final boolean n() {
        return this.f27422p.N1();
    }

    public final LayoutNode.LayoutState o() {
        return this.f27410d;
    }

    public final AlignmentLinesOwner p() {
        return this.f27423q;
    }

    public final boolean q() {
        return this.f27420n;
    }

    public final boolean r() {
        return this.f27419m;
    }

    public final boolean s() {
        return this.f27412f;
    }

    public final boolean t() {
        return this.f27413g;
    }

    public final boolean u() {
        return this.f27411e;
    }

    public final LookaheadPassDelegate v() {
        return this.f27423q;
    }

    public final MeasurePassDelegate w() {
        return this.f27422p;
    }

    public final boolean x() {
        return this.f27422p.W1();
    }

    public final int y() {
        return this.f27414h;
    }

    public final int z() {
        return this.f27415i;
    }
}
