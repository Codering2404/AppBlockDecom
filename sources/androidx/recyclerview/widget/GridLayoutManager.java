package androidx.recyclerview.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.media3.common.JBEE.bfIdKSjLOVjG;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes2.dex */
public class GridLayoutManager extends LinearLayoutManager {
    boolean I;
    int J;
    int[] K;
    View[] L;
    final SparseIntArray M;
    final SparseIntArray N;
    SpanSizeLookup O;
    final Rect P;
    private boolean Q;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    /* JADX INFO: loaded from: classes3.dex */
    public static final class DefaultSpanSizeLookup extends SpanSizeLookup {
        @Override // androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup
        public int e(int i3, int i4) {
            return i3 % i4;
        }

        @Override // androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup
        public int f(int i3) {
            return 1;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    /* JADX INFO: loaded from: classes3.dex */
    public static abstract class SpanSizeLookup {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final SparseIntArray f51680a = new SparseIntArray();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final SparseIntArray f51681b = new SparseIntArray();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private boolean f51682c = false;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private boolean f51683d = false;

        static int a(SparseIntArray sparseIntArray, int i3) {
            int size = sparseIntArray.size() - 1;
            int i4 = 0;
            while (i4 <= size) {
                int i5 = (i4 + size) >>> 1;
                if (sparseIntArray.keyAt(i5) < i3) {
                    i4 = i5 + 1;
                } else {
                    size = i5 - 1;
                }
            }
            int i6 = i4 - 1;
            if (i6 < 0 || i6 >= sparseIntArray.size()) {
                return -1;
            }
            return sparseIntArray.keyAt(i6);
        }

        int b(int i3, int i4) {
            if (!this.f51683d) {
                return d(i3, i4);
            }
            int i5 = this.f51681b.get(i3, -1);
            if (i5 != -1) {
                return i5;
            }
            int iD = d(i3, i4);
            this.f51681b.put(i3, iD);
            return iD;
        }

        int c(int i3, int i4) {
            if (!this.f51682c) {
                return e(i3, i4);
            }
            int i5 = this.f51680a.get(i3, -1);
            if (i5 != -1) {
                return i5;
            }
            int iE = e(i3, i4);
            this.f51680a.put(i3, iE);
            return iE;
        }

        public int d(int i3, int i4) {
            int i5;
            int i6;
            int iC;
            int iA;
            if (!this.f51683d || (iA = a(this.f51681b, i3)) == -1) {
                i5 = 0;
                i6 = 0;
                iC = 0;
            } else {
                i5 = this.f51681b.get(iA);
                i6 = iA + 1;
                iC = c(iA, i4) + f(iA);
                if (iC == i4) {
                    i5++;
                    iC = 0;
                }
            }
            int iF = f(i3);
            while (i6 < i3) {
                int iF2 = f(i6);
                iC += iF2;
                if (iC == i4) {
                    i5++;
                    iC = 0;
                } else if (iC > i4) {
                    i5++;
                    iC = iF2;
                }
                i6++;
            }
            return iC + iF > i4 ? i5 + 1 : i5;
        }

        /* JADX WARN: Removed duplicated region for block: B:12:0x0024  */
        /* JADX WARN: Removed duplicated region for block: B:18:0x0033  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:14:0x002b -> B:17:0x0030). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:15:0x002d -> B:17:0x0030). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:16:0x002f -> B:17:0x0030). Please report as a decompilation issue!!! */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public int e(int r6, int r7) {
            /*
                r5 = this;
                int r0 = r5.f(r6)
                r1 = 0
                if (r0 != r7) goto L8
                return r1
            L8:
                boolean r2 = r5.f51682c
                if (r2 == 0) goto L20
                android.util.SparseIntArray r2 = r5.f51680a
                int r2 = a(r2, r6)
                if (r2 < 0) goto L20
                android.util.SparseIntArray r3 = r5.f51680a
                int r3 = r3.get(r2)
                int r4 = r5.f(r2)
                int r3 = r3 + r4
                goto L30
            L20:
                r2 = r1
                r3 = r2
            L22:
                if (r2 >= r6) goto L33
                int r4 = r5.f(r2)
                int r3 = r3 + r4
                if (r3 != r7) goto L2d
                r3 = r1
                goto L30
            L2d:
                if (r3 <= r7) goto L30
                r3 = r4
            L30:
                int r2 = r2 + 1
                goto L22
            L33:
                int r0 = r0 + r3
                if (r0 > r7) goto L37
                return r3
            L37:
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup.e(int, int):int");
        }

        public abstract int f(int i3);

        public void g() {
            this.f51681b.clear();
        }

        public void h() {
            this.f51680a.clear();
        }
    }

    public GridLayoutManager(Context context, AttributeSet attributeSet, int i3, int i4) {
        super(context, attributeSet, i3, i4);
        this.I = false;
        this.J = -1;
        this.M = new SparseIntArray();
        this.N = new SparseIntArray();
        this.O = new DefaultSpanSizeLookup();
        this.P = new Rect();
        h3(RecyclerView.LayoutManager.n0(context, attributeSet, i3, i4).f51932b);
    }

    private void P2(RecyclerView.Recycler recycler, RecyclerView.State state, int i3, boolean z2) {
        int i4;
        int i5;
        int i6;
        int i7 = 0;
        if (z2) {
            i6 = 1;
            i5 = i3;
            i4 = 0;
        } else {
            i4 = i3 - 1;
            i5 = -1;
            i6 = -1;
        }
        while (i4 != i5) {
            View view = this.L[i4];
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            int iC3 = c3(recycler, state, m0(view));
            layoutParams.f51679f = iC3;
            layoutParams.f51678e = i7;
            i7 += iC3;
            i4 += i6;
        }
    }

    private void Q2() {
        int iP = P();
        for (int i3 = 0; i3 < iP; i3++) {
            LayoutParams layoutParams = (LayoutParams) O(i3).getLayoutParams();
            int iA = layoutParams.a();
            this.M.put(iA, layoutParams.f());
            this.N.put(iA, layoutParams.e());
        }
    }

    private void R2(int i3) {
        this.K = S2(this.K, this.J, i3);
    }

    static int[] S2(int[] iArr, int i3, int i4) {
        int i5;
        if (iArr == null || iArr.length != i3 + 1 || iArr[iArr.length - 1] != i4) {
            iArr = new int[i3 + 1];
        }
        int i6 = 0;
        iArr[0] = 0;
        int i7 = i4 / i3;
        int i8 = i4 % i3;
        int i9 = 0;
        for (int i10 = 1; i10 <= i3; i10++) {
            i6 += i8;
            if (i6 <= 0 || i3 - i6 >= i8) {
                i5 = i7;
            } else {
                i5 = i7 + 1;
                i6 -= i3;
            }
            i9 += i5;
            iArr[i10] = i9;
        }
        return iArr;
    }

    private void T2() {
        this.M.clear();
        this.N.clear();
    }

    private int U2(RecyclerView.State state) {
        if (P() != 0 && state.b() != 0) {
            Y1();
            boolean zS2 = s2();
            View viewC2 = c2(!zS2, true);
            View viewB2 = b2(!zS2, true);
            if (viewC2 != null && viewB2 != null) {
                int iB = this.O.b(m0(viewC2), this.J);
                int iB2 = this.O.b(m0(viewB2), this.J);
                int iMax = this.f51756x ? Math.max(0, ((this.O.b(state.b() - 1, this.J) + 1) - Math.max(iB, iB2)) - 1) : Math.max(0, Math.min(iB, iB2));
                if (zS2) {
                    return Math.round((iMax * (Math.abs(this.f51753u.d(viewB2) - this.f51753u.g(viewC2)) / ((this.O.b(m0(viewB2), this.J) - this.O.b(m0(viewC2), this.J)) + 1))) + (this.f51753u.n() - this.f51753u.g(viewC2)));
                }
                return iMax;
            }
        }
        return 0;
    }

    private int V2(RecyclerView.State state) {
        if (P() != 0 && state.b() != 0) {
            Y1();
            View viewC2 = c2(!s2(), true);
            View viewB2 = b2(!s2(), true);
            if (viewC2 != null && viewB2 != null) {
                if (!s2()) {
                    return this.O.b(state.b() - 1, this.J) + 1;
                }
                int iD = this.f51753u.d(viewB2) - this.f51753u.g(viewC2);
                int iB = this.O.b(m0(viewC2), this.J);
                return (int) ((iD / ((this.O.b(m0(viewB2), this.J) - iB) + 1)) * (this.O.b(state.b() - 1, this.J) + 1));
            }
        }
        return 0;
    }

    private void W2(RecyclerView.Recycler recycler, RecyclerView.State state, LinearLayoutManager.AnchorInfo anchorInfo, int i3) {
        boolean z2 = i3 == 1;
        int iB3 = b3(recycler, state, anchorInfo.f51760b);
        if (z2) {
            while (iB3 > 0) {
                int i4 = anchorInfo.f51760b;
                if (i4 <= 0) {
                    return;
                }
                int i5 = i4 - 1;
                anchorInfo.f51760b = i5;
                iB3 = b3(recycler, state, i5);
            }
            return;
        }
        int iB = state.b() - 1;
        int i6 = anchorInfo.f51760b;
        while (i6 < iB) {
            int i7 = i6 + 1;
            int iB32 = b3(recycler, state, i7);
            if (iB32 <= iB3) {
                break;
            }
            i6 = i7;
            iB3 = iB32;
        }
        anchorInfo.f51760b = i6;
    }

    private void X2() {
        View[] viewArr = this.L;
        if (viewArr == null || viewArr.length != this.J) {
            this.L = new View[this.J];
        }
    }

    private int a3(RecyclerView.Recycler recycler, RecyclerView.State state, int i3) {
        if (!state.e()) {
            return this.O.b(i3, this.J);
        }
        int iF = recycler.f(i3);
        if (iF != -1) {
            return this.O.b(iF, this.J);
        }
        Log.w("GridLayoutManager", "Cannot find span size for pre layout position. " + i3);
        return 0;
    }

    private int b3(RecyclerView.Recycler recycler, RecyclerView.State state, int i3) {
        if (!state.e()) {
            return this.O.c(i3, this.J);
        }
        int i4 = this.N.get(i3, -1);
        if (i4 != -1) {
            return i4;
        }
        int iF = recycler.f(i3);
        if (iF != -1) {
            return this.O.c(iF, this.J);
        }
        Log.w("GridLayoutManager", "Cannot find span size for pre layout position. It is not cached, not in the adapter. Pos:" + i3);
        return 0;
    }

    private int c3(RecyclerView.Recycler recycler, RecyclerView.State state, int i3) {
        if (!state.e()) {
            return this.O.f(i3);
        }
        int i4 = this.M.get(i3, -1);
        if (i4 != -1) {
            return i4;
        }
        int iF = recycler.f(i3);
        if (iF != -1) {
            return this.O.f(iF);
        }
        Log.w("GridLayoutManager", "Cannot find span size for pre layout position. It is not cached, not in the adapter. Pos:" + i3);
        return 1;
    }

    private void e3(float f3, int i3) {
        R2(Math.max(Math.round(f3 * this.J), i3));
    }

    private void f3(View view, int i3, boolean z2) {
        int iQ;
        int iQ2;
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        Rect rect = layoutParams.f51936b;
        int i4 = rect.top + rect.bottom + ((ViewGroup.MarginLayoutParams) layoutParams).topMargin + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin;
        int i5 = rect.left + rect.right + ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin;
        int iY2 = Y2(layoutParams.f51678e, layoutParams.f51679f);
        if (this.f51751s == 1) {
            iQ2 = RecyclerView.LayoutManager.Q(iY2, i3, i5, ((ViewGroup.MarginLayoutParams) layoutParams).width, false);
            iQ = RecyclerView.LayoutManager.Q(this.f51753u.o(), d0(), i4, ((ViewGroup.MarginLayoutParams) layoutParams).height, true);
        } else {
            int iQ3 = RecyclerView.LayoutManager.Q(iY2, i3, i4, ((ViewGroup.MarginLayoutParams) layoutParams).height, false);
            int iQ4 = RecyclerView.LayoutManager.Q(this.f51753u.o(), u0(), i5, ((ViewGroup.MarginLayoutParams) layoutParams).width, true);
            iQ = iQ3;
            iQ2 = iQ4;
        }
        g3(view, iQ2, iQ, z2);
    }

    private void g3(View view, int i3, int i4, boolean z2) {
        RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
        if (z2 ? M1(view, i3, i4, layoutParams) : K1(view, i3, i4, layoutParams)) {
            view.measure(i3, i4);
        }
    }

    private void j3() {
        int iC0;
        int iL0;
        if (q2() == 1) {
            iC0 = t0() - k0();
            iL0 = j0();
        } else {
            iC0 = c0() - i0();
            iL0 = l0();
        }
        R2(iC0 - iL0);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int A(RecyclerView.State state) {
        return this.Q ? U2(state) : super.A(state);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int B(RecyclerView.State state) {
        return this.Q ? V2(state) : super.B(state);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int B1(int i3, RecyclerView.Recycler recycler, RecyclerView.State state) {
        j3();
        X2();
        return super.B1(i3, recycler, state);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int D1(int i3, RecyclerView.Recycler recycler, RecyclerView.State state) {
        j3();
        X2();
        return super.D1(i3, recycler, state);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    public void G2(boolean z2) {
        if (z2) {
            throw new UnsupportedOperationException("GridLayoutManager does not support stack from end. Consider using reverse layout");
        }
        super.G2(false);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void H1(Rect rect, int i3, int i4) {
        int iT;
        int iT2;
        if (this.K == null) {
            super.H1(rect, i3, i4);
        }
        int iJ0 = j0() + k0();
        int iL0 = l0() + i0();
        if (this.f51751s == 1) {
            iT2 = RecyclerView.LayoutManager.t(i4, rect.height() + iL0, g0());
            int[] iArr = this.K;
            iT = RecyclerView.LayoutManager.t(i3, iArr[iArr.length - 1] + iJ0, h0());
        } else {
            iT = RecyclerView.LayoutManager.t(i3, rect.width() + iJ0, h0());
            int[] iArr2 = this.K;
            iT2 = RecyclerView.LayoutManager.t(i4, iArr2[iArr2.length - 1] + iL0, g0());
        }
        G1(iT, iT2);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public RecyclerView.LayoutParams J() {
        return this.f51751s == 0 ? new LayoutParams(-2, -1) : new LayoutParams(-1, -2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public RecyclerView.LayoutParams K(Context context, AttributeSet attributeSet) {
        return new LayoutParams(context, attributeSet);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public RecyclerView.LayoutParams L(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof ViewGroup.MarginLayoutParams ? new LayoutParams((ViewGroup.MarginLayoutParams) layoutParams) : new LayoutParams(layoutParams);
    }

    /* JADX WARN: Code restructure failed: missing block: B:56:0x00d3, code lost:
    
        if (r13 == (r2 > r15)) goto L47;
     */
    /* JADX WARN: Removed duplicated region for block: B:72:0x00fb  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0111  */
    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public android.view.View O0(android.view.View r24, int r25, androidx.recyclerview.widget.RecyclerView.Recycler r26, androidx.recyclerview.widget.RecyclerView.State r27) {
        /*
            Method dump skipped, instruction units count: 316
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.GridLayoutManager.O0(android.view.View, int, androidx.recyclerview.widget.RecyclerView$Recycler, androidx.recyclerview.widget.RecyclerView$State):android.view.View");
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public boolean Q1() {
        return this.D == null && !this.I;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void S0(RecyclerView.Recycler recycler, RecyclerView.State state, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        super.S0(recycler, state, accessibilityNodeInfoCompat);
        accessibilityNodeInfoCompat.i0(GridView.class.getName());
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    void S1(RecyclerView.State state, LinearLayoutManager.LayoutState layoutState, RecyclerView.LayoutManager.LayoutPrefetchRegistry layoutPrefetchRegistry) {
        int iF = this.J;
        for (int i3 = 0; i3 < this.J && layoutState.c(state) && iF > 0; i3++) {
            int i4 = layoutState.f51771d;
            layoutPrefetchRegistry.a(i4, Math.max(0, layoutState.f51774g));
            iF -= this.O.f(i4);
            layoutState.f51771d += layoutState.f51772e;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int T(RecyclerView.Recycler recycler, RecyclerView.State state) {
        if (this.f51751s == 1) {
            return this.J;
        }
        if (state.b() < 1) {
            return 0;
        }
        return a3(recycler, state, state.b() - 1) + 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void U0(RecyclerView.Recycler recycler, RecyclerView.State state, View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (!(layoutParams instanceof LayoutParams)) {
            super.T0(view, accessibilityNodeInfoCompat);
            return;
        }
        LayoutParams layoutParams2 = (LayoutParams) layoutParams;
        int iA3 = a3(recycler, state, layoutParams2.a());
        if (this.f51751s == 0) {
            accessibilityNodeInfoCompat.l0(AccessibilityNodeInfoCompat.CollectionItemInfoCompat.a(layoutParams2.e(), layoutParams2.f(), iA3, 1, false, false));
        } else {
            accessibilityNodeInfoCompat.l0(AccessibilityNodeInfoCompat.CollectionItemInfoCompat.a(iA3, 1, layoutParams2.e(), layoutParams2.f(), false, false));
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void W0(RecyclerView recyclerView, int i3, int i4) {
        this.O.h();
        this.O.g();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void X0(RecyclerView recyclerView) {
        this.O.h();
        this.O.g();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void Y0(RecyclerView recyclerView, int i3, int i4, int i5) {
        this.O.h();
        this.O.g();
    }

    int Y2(int i3, int i4) {
        if (this.f51751s != 1 || !r2()) {
            int[] iArr = this.K;
            return iArr[i4 + i3] - iArr[i3];
        }
        int[] iArr2 = this.K;
        int i5 = this.J;
        return iArr2[i5 - i3] - iArr2[(i5 - i3) - i4];
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void Z0(RecyclerView recyclerView, int i3, int i4) {
        this.O.h();
        this.O.g();
    }

    public int Z2() {
        return this.J;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void b1(RecyclerView recyclerView, int i3, int i4, Object obj) {
        this.O.h();
        this.O.g();
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void c1(RecyclerView.Recycler recycler, RecyclerView.State state) {
        if (state.e()) {
            Q2();
        }
        super.c1(recycler, state);
        T2();
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void d1(RecyclerView.State state) {
        super.d1(state);
        this.I = false;
    }

    public SpanSizeLookup d3() {
        return this.O;
    }

    public void i3(SpanSizeLookup spanSizeLookup) {
        this.O = spanSizeLookup;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    View k2(RecyclerView.Recycler recycler, RecyclerView.State state, boolean z2, boolean z3) {
        int i3;
        int iP;
        int iP2 = P();
        int i4 = 1;
        if (z3) {
            iP = P() - 1;
            i3 = -1;
            i4 = -1;
        } else {
            i3 = iP2;
            iP = 0;
        }
        int iB = state.b();
        Y1();
        int iN = this.f51753u.n();
        int i5 = this.f51753u.i();
        View view = null;
        View view2 = null;
        while (iP != i3) {
            View viewO = O(iP);
            int iM0 = m0(viewO);
            if (iM0 >= 0 && iM0 < iB && b3(recycler, state, iM0) == 0) {
                if (((RecyclerView.LayoutParams) viewO.getLayoutParams()).c()) {
                    if (view2 == null) {
                        view2 = viewO;
                    }
                } else {
                    if (this.f51753u.g(viewO) < i5 && this.f51753u.d(viewO) >= iN) {
                        return viewO;
                    }
                    if (view == null) {
                        view = viewO;
                    }
                }
            }
            iP += i4;
        }
        return view != null ? view : view2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int p0(RecyclerView.Recycler recycler, RecyclerView.State state) {
        if (this.f51751s == 0) {
            return this.J;
        }
        if (state.b() < 1) {
            return 0;
        }
        return a3(recycler, state, state.b() - 1) + 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public boolean s(RecyclerView.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    void t2(RecyclerView.Recycler recycler, RecyclerView.State state, LinearLayoutManager.LayoutState layoutState, LinearLayoutManager.LayoutChunkResult layoutChunkResult) {
        int i3;
        int i4;
        int iJ0;
        int iL0;
        int iF;
        int iF2;
        int i5;
        int iQ;
        int iQ2;
        View viewD;
        int iM = this.f51753u.m();
        boolean z2 = iM != 1073741824;
        int i6 = P() > 0 ? this.K[this.J] : 0;
        if (z2) {
            j3();
        }
        boolean z3 = layoutState.f51772e == 1;
        int iB3 = this.J;
        if (!z3) {
            iB3 = b3(recycler, state, layoutState.f51771d) + c3(recycler, state, layoutState.f51771d);
        }
        int i7 = 0;
        while (i7 < this.J && layoutState.c(state) && iB3 > 0) {
            int i8 = layoutState.f51771d;
            int iC3 = c3(recycler, state, i8);
            if (iC3 > this.J) {
                throw new IllegalArgumentException("Item at position " + i8 + " requires " + iC3 + " spans but GridLayoutManager has only " + this.J + " spans.");
            }
            iB3 -= iC3;
            if (iB3 < 0 || (viewD = layoutState.d(recycler)) == null) {
                break;
            }
            this.L[i7] = viewD;
            i7++;
        }
        if (i7 == 0) {
            layoutChunkResult.f51765b = true;
            return;
        }
        P2(recycler, state, i7, z3);
        float f3 = 0.0f;
        int i9 = 0;
        for (int i10 = 0; i10 < i7; i10++) {
            View view = this.L[i10];
            if (layoutState.f51779l == null) {
                if (z3) {
                    j(view);
                } else {
                    k(view, 0);
                }
            } else if (z3) {
                h(view);
            } else {
                i(view, 0);
            }
            p(view, this.P);
            f3(view, iM, false);
            int iE = this.f51753u.e(view);
            if (iE > i9) {
                i9 = iE;
            }
            float f4 = (this.f51753u.f(view) * 1.0f) / ((LayoutParams) view.getLayoutParams()).f51679f;
            if (f4 > f3) {
                f3 = f4;
            }
        }
        if (z2) {
            e3(f3, i6);
            i9 = 0;
            for (int i11 = 0; i11 < i7; i11++) {
                View view2 = this.L[i11];
                f3(view2, 1073741824, true);
                int iE2 = this.f51753u.e(view2);
                if (iE2 > i9) {
                    i9 = iE2;
                }
            }
        }
        for (int i12 = 0; i12 < i7; i12++) {
            View view3 = this.L[i12];
            if (this.f51753u.e(view3) != i9) {
                LayoutParams layoutParams = (LayoutParams) view3.getLayoutParams();
                Rect rect = layoutParams.f51936b;
                int i13 = rect.top + rect.bottom + ((ViewGroup.MarginLayoutParams) layoutParams).topMargin + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin;
                int i14 = rect.left + rect.right + ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin;
                int iY2 = Y2(layoutParams.f51678e, layoutParams.f51679f);
                if (this.f51751s == 1) {
                    iQ2 = RecyclerView.LayoutManager.Q(iY2, 1073741824, i14, ((ViewGroup.MarginLayoutParams) layoutParams).width, false);
                    iQ = View.MeasureSpec.makeMeasureSpec(i9 - i13, 1073741824);
                } else {
                    int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i9 - i14, 1073741824);
                    iQ = RecyclerView.LayoutManager.Q(iY2, 1073741824, i13, ((ViewGroup.MarginLayoutParams) layoutParams).height, false);
                    iQ2 = iMakeMeasureSpec;
                }
                g3(view3, iQ2, iQ, true);
            }
        }
        layoutChunkResult.f51764a = i9;
        if (this.f51751s == 1) {
            if (layoutState.f51773f == -1) {
                iF2 = layoutState.f51769b;
                i5 = iF2 - i9;
            } else {
                i5 = layoutState.f51769b;
                iF2 = i5 + i9;
            }
            iL0 = i5;
            iF = 0;
            iJ0 = 0;
        } else {
            if (layoutState.f51773f == -1) {
                i4 = layoutState.f51769b;
                i3 = i4 - i9;
            } else {
                i3 = layoutState.f51769b;
                i4 = i3 + i9;
            }
            iJ0 = i3;
            iL0 = 0;
            iF = i4;
            iF2 = 0;
        }
        for (int i15 = 0; i15 < i7; i15++) {
            View view4 = this.L[i15];
            LayoutParams layoutParams2 = (LayoutParams) view4.getLayoutParams();
            if (this.f51751s != 1) {
                iL0 = this.K[layoutParams2.f51678e] + l0();
                iF2 = this.f51753u.f(view4) + iL0;
            } else if (r2()) {
                iF = j0() + this.K[this.J - layoutParams2.f51678e];
                iJ0 = iF - this.f51753u.f(view4);
            } else {
                iJ0 = this.K[layoutParams2.f51678e] + j0();
                iF = this.f51753u.f(view4) + iJ0;
            }
            int i16 = iF2;
            int i17 = iL0;
            int i18 = iF;
            int i19 = iJ0;
            E0(view4, i19, i17, i18, i16);
            iF2 = i16;
            iJ0 = i19;
            iF = i18;
            iL0 = i17;
            if (layoutParams2.c() || layoutParams2.b()) {
                layoutChunkResult.f51766c = true;
            }
            layoutChunkResult.f51767d = view4.hasFocusable() | layoutChunkResult.f51767d;
        }
        Arrays.fill(this.L, (Object) null);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    void v2(RecyclerView.Recycler recycler, RecyclerView.State state, LinearLayoutManager.AnchorInfo anchorInfo, int i3) {
        super.v2(recycler, state, anchorInfo, i3);
        j3();
        if (state.b() > 0 && !state.e()) {
            W2(recycler, state, anchorInfo, i3);
        }
        X2();
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int x(RecyclerView.State state) {
        return this.Q ? U2(state) : super.x(state);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int y(RecyclerView.State state) {
        return this.Q ? V2(state) : super.y(state);
    }

    public void h3(int i3) {
        if (i3 == this.J) {
            return;
        }
        this.I = true;
        if (i3 >= 1) {
            this.J = i3;
            this.O.h();
            y1();
        } else {
            throw new IllegalArgumentException(bfIdKSjLOVjG.JfIMfgwBbsdrNoD + i3);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    /* JADX INFO: loaded from: classes3.dex */
    public static class LayoutParams extends RecyclerView.LayoutParams {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        int f51678e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        int f51679f;

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f51678e = -1;
            this.f51679f = 0;
        }

        public int e() {
            return this.f51678e;
        }

        public int f() {
            return this.f51679f;
        }

        public LayoutParams(int i3, int i4) {
            super(i3, i4);
            this.f51678e = -1;
            this.f51679f = 0;
        }

        public LayoutParams(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.f51678e = -1;
            this.f51679f = 0;
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f51678e = -1;
            this.f51679f = 0;
        }
    }

    public GridLayoutManager(Context context, int i3) {
        super(context);
        this.I = false;
        this.J = -1;
        this.M = new SparseIntArray();
        this.N = new SparseIntArray();
        this.O = new DefaultSpanSizeLookup();
        this.P = new Rect();
        h3(i3);
    }

    public GridLayoutManager(Context context, int i3, int i4, boolean z2) {
        super(context, i4, z2);
        this.I = false;
        this.J = -1;
        this.M = new SparseIntArray();
        this.N = new SparseIntArray();
        this.O = new DefaultSpanSizeLookup();
        this.P = new Rect();
        h3(i3);
    }
}
