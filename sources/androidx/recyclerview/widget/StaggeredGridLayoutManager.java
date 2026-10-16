package androidx.recyclerview.widget;

import android.content.Context;
import android.graphics.PointF;
import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.gms.common.api.Api;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public class StaggeredGridLayoutManager extends RecyclerView.LayoutManager implements RecyclerView.SmoothScroller.ScrollVectorProvider {
    private BitSet B;
    private boolean G;
    private boolean H;
    private SavedState I;
    private int J;
    private int[] O;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    Span[] f52018t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    OrientationHelper f52019u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    OrientationHelper f52020v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private int f52021w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private int f52022x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private final LayoutState f52023y;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private int f52017s = -1;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    boolean f52024z = false;
    boolean A = false;
    int C = -1;
    int D = Integer.MIN_VALUE;
    LazySpanLookup E = new LazySpanLookup();
    private int F = 2;
    private final Rect K = new Rect();
    private final AnchorInfo L = new AnchorInfo();
    private boolean M = false;
    private boolean N = true;
    private final Runnable P = new Runnable() { // from class: androidx.recyclerview.widget.StaggeredGridLayoutManager.1
        @Override // java.lang.Runnable
        public void run() {
            StaggeredGridLayoutManager.this.X1();
        }
    };

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class AnchorInfo {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f52026a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f52027b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        boolean f52028c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        boolean f52029d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        boolean f52030e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        int[] f52031f;

        AnchorInfo() {
            c();
        }

        void a() {
            this.f52027b = this.f52028c ? StaggeredGridLayoutManager.this.f52019u.i() : StaggeredGridLayoutManager.this.f52019u.n();
        }

        void b(int i3) {
            if (this.f52028c) {
                this.f52027b = StaggeredGridLayoutManager.this.f52019u.i() - i3;
            } else {
                this.f52027b = StaggeredGridLayoutManager.this.f52019u.n() + i3;
            }
        }

        void c() {
            this.f52026a = -1;
            this.f52027b = Integer.MIN_VALUE;
            this.f52028c = false;
            this.f52029d = false;
            this.f52030e = false;
            int[] iArr = this.f52031f;
            if (iArr != null) {
                Arrays.fill(iArr, -1);
            }
        }

        void d(Span[] spanArr) {
            int length = spanArr.length;
            int[] iArr = this.f52031f;
            if (iArr == null || iArr.length < length) {
                this.f52031f = new int[StaggeredGridLayoutManager.this.f52018t.length];
            }
            for (int i3 = 0; i3 < length; i3++) {
                this.f52031f[i3] = spanArr[i3].p(Integer.MIN_VALUE);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static class LayoutParams extends RecyclerView.LayoutParams {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        Span f52033e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        boolean f52034f;

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public boolean e() {
            return this.f52034f;
        }

        public LayoutParams(int i3, int i4) {
            super(i3, i4);
        }

        public LayoutParams(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static class SavedState implements Parcelable {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() { // from class: androidx.recyclerview.widget.StaggeredGridLayoutManager.SavedState.1
            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public SavedState[] newArray(int i3) {
                return new SavedState[i3];
            }
        };

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f52041a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f52042b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f52043c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int[] f52044d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        int f52045f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        int[] f52046g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        List f52047h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        boolean f52048i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        boolean f52049j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        boolean f52050k;

        public SavedState() {
        }

        void c() {
            this.f52044d = null;
            this.f52043c = 0;
            this.f52041a = -1;
            this.f52042b = -1;
        }

        void d() {
            this.f52044d = null;
            this.f52043c = 0;
            this.f52045f = 0;
            this.f52046g = null;
            this.f52047h = null;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i3) {
            parcel.writeInt(this.f52041a);
            parcel.writeInt(this.f52042b);
            parcel.writeInt(this.f52043c);
            if (this.f52043c > 0) {
                parcel.writeIntArray(this.f52044d);
            }
            parcel.writeInt(this.f52045f);
            if (this.f52045f > 0) {
                parcel.writeIntArray(this.f52046g);
            }
            parcel.writeInt(this.f52048i ? 1 : 0);
            parcel.writeInt(this.f52049j ? 1 : 0);
            parcel.writeInt(this.f52050k ? 1 : 0);
            parcel.writeList(this.f52047h);
        }

        SavedState(Parcel parcel) {
            this.f52041a = parcel.readInt();
            this.f52042b = parcel.readInt();
            int i3 = parcel.readInt();
            this.f52043c = i3;
            if (i3 > 0) {
                int[] iArr = new int[i3];
                this.f52044d = iArr;
                parcel.readIntArray(iArr);
            }
            int i4 = parcel.readInt();
            this.f52045f = i4;
            if (i4 > 0) {
                int[] iArr2 = new int[i4];
                this.f52046g = iArr2;
                parcel.readIntArray(iArr2);
            }
            this.f52048i = parcel.readInt() == 1;
            this.f52049j = parcel.readInt() == 1;
            this.f52050k = parcel.readInt() == 1;
            this.f52047h = parcel.readArrayList(LazySpanLookup.FullSpanItem.class.getClassLoader());
        }

        public SavedState(SavedState savedState) {
            this.f52043c = savedState.f52043c;
            this.f52041a = savedState.f52041a;
            this.f52042b = savedState.f52042b;
            this.f52044d = savedState.f52044d;
            this.f52045f = savedState.f52045f;
            this.f52046g = savedState.f52046g;
            this.f52048i = savedState.f52048i;
            this.f52049j = savedState.f52049j;
            this.f52050k = savedState.f52050k;
            this.f52047h = savedState.f52047h;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class Span {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        ArrayList f52051a = new ArrayList();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f52052b = Integer.MIN_VALUE;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f52053c = Integer.MIN_VALUE;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int f52054d = 0;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final int f52055e;

        Span(int i3) {
            this.f52055e = i3;
        }

        void a(View view) {
            LayoutParams layoutParamsN = n(view);
            layoutParamsN.f52033e = this;
            this.f52051a.add(view);
            this.f52053c = Integer.MIN_VALUE;
            if (this.f52051a.size() == 1) {
                this.f52052b = Integer.MIN_VALUE;
            }
            if (layoutParamsN.c() || layoutParamsN.b()) {
                this.f52054d += StaggeredGridLayoutManager.this.f52019u.e(view);
            }
        }

        void b(boolean z2, int i3) {
            int iL = z2 ? l(Integer.MIN_VALUE) : p(Integer.MIN_VALUE);
            e();
            if (iL == Integer.MIN_VALUE) {
                return;
            }
            if (!z2 || iL >= StaggeredGridLayoutManager.this.f52019u.i()) {
                if (z2 || iL <= StaggeredGridLayoutManager.this.f52019u.n()) {
                    if (i3 != Integer.MIN_VALUE) {
                        iL += i3;
                    }
                    this.f52053c = iL;
                    this.f52052b = iL;
                }
            }
        }

        void c() {
            LazySpanLookup.FullSpanItem fullSpanItemF;
            ArrayList arrayList = this.f52051a;
            View view = (View) arrayList.get(arrayList.size() - 1);
            LayoutParams layoutParamsN = n(view);
            this.f52053c = StaggeredGridLayoutManager.this.f52019u.d(view);
            if (layoutParamsN.f52034f && (fullSpanItemF = StaggeredGridLayoutManager.this.E.f(layoutParamsN.a())) != null && fullSpanItemF.f52038b == 1) {
                this.f52053c += fullSpanItemF.a(this.f52055e);
            }
        }

        void d() {
            LazySpanLookup.FullSpanItem fullSpanItemF;
            View view = (View) this.f52051a.get(0);
            LayoutParams layoutParamsN = n(view);
            this.f52052b = StaggeredGridLayoutManager.this.f52019u.g(view);
            if (layoutParamsN.f52034f && (fullSpanItemF = StaggeredGridLayoutManager.this.E.f(layoutParamsN.a())) != null && fullSpanItemF.f52038b == -1) {
                this.f52052b -= fullSpanItemF.a(this.f52055e);
            }
        }

        void e() {
            this.f52051a.clear();
            q();
            this.f52054d = 0;
        }

        public int f() {
            return StaggeredGridLayoutManager.this.f52024z ? i(this.f52051a.size() - 1, -1, true) : i(0, this.f52051a.size(), true);
        }

        public int g() {
            return StaggeredGridLayoutManager.this.f52024z ? i(0, this.f52051a.size(), true) : i(this.f52051a.size() - 1, -1, true);
        }

        int h(int i3, int i4, boolean z2, boolean z3, boolean z4) {
            int iN = StaggeredGridLayoutManager.this.f52019u.n();
            int i5 = StaggeredGridLayoutManager.this.f52019u.i();
            int i6 = i4 > i3 ? 1 : -1;
            while (i3 != i4) {
                View view = (View) this.f52051a.get(i3);
                int iG = StaggeredGridLayoutManager.this.f52019u.g(view);
                int iD = StaggeredGridLayoutManager.this.f52019u.d(view);
                boolean z5 = false;
                boolean z6 = !z4 ? iG >= i5 : iG > i5;
                if (!z4 ? iD > iN : iD >= iN) {
                    z5 = true;
                }
                if (z6 && z5) {
                    if (z2 && z3) {
                        if (iG >= iN && iD <= i5) {
                            return StaggeredGridLayoutManager.this.m0(view);
                        }
                    } else {
                        if (z3) {
                            return StaggeredGridLayoutManager.this.m0(view);
                        }
                        if (iG < iN || iD > i5) {
                            return StaggeredGridLayoutManager.this.m0(view);
                        }
                    }
                }
                i3 += i6;
            }
            return -1;
        }

        int i(int i3, int i4, boolean z2) {
            return h(i3, i4, false, false, z2);
        }

        public int j() {
            return this.f52054d;
        }

        int k() {
            int i3 = this.f52053c;
            if (i3 != Integer.MIN_VALUE) {
                return i3;
            }
            c();
            return this.f52053c;
        }

        int l(int i3) {
            int i4 = this.f52053c;
            if (i4 != Integer.MIN_VALUE) {
                return i4;
            }
            if (this.f52051a.size() == 0) {
                return i3;
            }
            c();
            return this.f52053c;
        }

        public View m(int i3, int i4) {
            View view = null;
            if (i4 != -1) {
                int size = this.f52051a.size() - 1;
                while (size >= 0) {
                    View view2 = (View) this.f52051a.get(size);
                    StaggeredGridLayoutManager staggeredGridLayoutManager = StaggeredGridLayoutManager.this;
                    if (staggeredGridLayoutManager.f52024z && staggeredGridLayoutManager.m0(view2) >= i3) {
                        break;
                    }
                    StaggeredGridLayoutManager staggeredGridLayoutManager2 = StaggeredGridLayoutManager.this;
                    if ((!staggeredGridLayoutManager2.f52024z && staggeredGridLayoutManager2.m0(view2) <= i3) || !view2.hasFocusable()) {
                        break;
                    }
                    size--;
                    view = view2;
                }
                return view;
            }
            int size2 = this.f52051a.size();
            int i5 = 0;
            while (i5 < size2) {
                View view3 = (View) this.f52051a.get(i5);
                StaggeredGridLayoutManager staggeredGridLayoutManager3 = StaggeredGridLayoutManager.this;
                if (staggeredGridLayoutManager3.f52024z && staggeredGridLayoutManager3.m0(view3) <= i3) {
                    break;
                }
                StaggeredGridLayoutManager staggeredGridLayoutManager4 = StaggeredGridLayoutManager.this;
                if ((!staggeredGridLayoutManager4.f52024z && staggeredGridLayoutManager4.m0(view3) >= i3) || !view3.hasFocusable()) {
                    break;
                }
                i5++;
                view = view3;
            }
            return view;
        }

        LayoutParams n(View view) {
            return (LayoutParams) view.getLayoutParams();
        }

        int o() {
            int i3 = this.f52052b;
            if (i3 != Integer.MIN_VALUE) {
                return i3;
            }
            d();
            return this.f52052b;
        }

        int p(int i3) {
            int i4 = this.f52052b;
            if (i4 != Integer.MIN_VALUE) {
                return i4;
            }
            if (this.f52051a.size() == 0) {
                return i3;
            }
            d();
            return this.f52052b;
        }

        void q() {
            this.f52052b = Integer.MIN_VALUE;
            this.f52053c = Integer.MIN_VALUE;
        }

        void r(int i3) {
            int i4 = this.f52052b;
            if (i4 != Integer.MIN_VALUE) {
                this.f52052b = i4 + i3;
            }
            int i5 = this.f52053c;
            if (i5 != Integer.MIN_VALUE) {
                this.f52053c = i5 + i3;
            }
        }

        void s() {
            int size = this.f52051a.size();
            View view = (View) this.f52051a.remove(size - 1);
            LayoutParams layoutParamsN = n(view);
            layoutParamsN.f52033e = null;
            if (layoutParamsN.c() || layoutParamsN.b()) {
                this.f52054d -= StaggeredGridLayoutManager.this.f52019u.e(view);
            }
            if (size == 1) {
                this.f52052b = Integer.MIN_VALUE;
            }
            this.f52053c = Integer.MIN_VALUE;
        }

        void t() {
            View view = (View) this.f52051a.remove(0);
            LayoutParams layoutParamsN = n(view);
            layoutParamsN.f52033e = null;
            if (this.f52051a.size() == 0) {
                this.f52053c = Integer.MIN_VALUE;
            }
            if (layoutParamsN.c() || layoutParamsN.b()) {
                this.f52054d -= StaggeredGridLayoutManager.this.f52019u.e(view);
            }
            this.f52052b = Integer.MIN_VALUE;
        }

        void u(View view) {
            LayoutParams layoutParamsN = n(view);
            layoutParamsN.f52033e = this;
            this.f52051a.add(0, view);
            this.f52052b = Integer.MIN_VALUE;
            if (this.f52051a.size() == 1) {
                this.f52053c = Integer.MIN_VALUE;
            }
            if (layoutParamsN.c() || layoutParamsN.b()) {
                this.f52054d += StaggeredGridLayoutManager.this.f52019u.e(view);
            }
        }

        void v(int i3) {
            this.f52052b = i3;
            this.f52053c = i3;
        }
    }

    public StaggeredGridLayoutManager(Context context, AttributeSet attributeSet, int i3, int i4) {
        RecyclerView.LayoutManager.Properties propertiesN0 = RecyclerView.LayoutManager.n0(context, attributeSet, i3, i4);
        N2(propertiesN0.f51931a);
        P2(propertiesN0.f51932b);
        O2(propertiesN0.f51933c);
        this.f52023y = new LayoutState();
        f2();
    }

    private void A2(View view, int i3, int i4, boolean z2) {
        p(view, this.K);
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        int i5 = ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin;
        Rect rect = this.K;
        int iX2 = X2(i3, i5 + rect.left, ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin + rect.right);
        int i6 = ((ViewGroup.MarginLayoutParams) layoutParams).topMargin;
        Rect rect2 = this.K;
        int iX22 = X2(i4, i6 + rect2.top, ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin + rect2.bottom);
        if (z2 ? M1(view, iX2, iX22, layoutParams) : K1(view, iX2, iX22, layoutParams)) {
            view.measure(iX2, iX22);
        }
    }

    private void B2(View view, LayoutParams layoutParams, boolean z2) {
        if (layoutParams.f52034f) {
            if (this.f52021w == 1) {
                A2(view, this.J, RecyclerView.LayoutManager.Q(c0(), d0(), l0() + i0(), ((ViewGroup.MarginLayoutParams) layoutParams).height, true), z2);
                return;
            } else {
                A2(view, RecyclerView.LayoutManager.Q(t0(), u0(), j0() + k0(), ((ViewGroup.MarginLayoutParams) layoutParams).width, true), this.J, z2);
                return;
            }
        }
        if (this.f52021w == 1) {
            A2(view, RecyclerView.LayoutManager.Q(this.f52022x, u0(), 0, ((ViewGroup.MarginLayoutParams) layoutParams).width, false), RecyclerView.LayoutManager.Q(c0(), d0(), l0() + i0(), ((ViewGroup.MarginLayoutParams) layoutParams).height, true), z2);
        } else {
            A2(view, RecyclerView.LayoutManager.Q(t0(), u0(), j0() + k0(), ((ViewGroup.MarginLayoutParams) layoutParams).width, true), RecyclerView.LayoutManager.Q(this.f52022x, d0(), 0, ((ViewGroup.MarginLayoutParams) layoutParams).height, false), z2);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:86:0x0155  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void C2(androidx.recyclerview.widget.RecyclerView.Recycler r9, androidx.recyclerview.widget.RecyclerView.State r10, boolean r11) {
        /*
            Method dump skipped, instruction units count: 374
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.StaggeredGridLayoutManager.C2(androidx.recyclerview.widget.RecyclerView$Recycler, androidx.recyclerview.widget.RecyclerView$State, boolean):void");
    }

    private boolean D2(int i3) {
        if (this.f52021w == 0) {
            return (i3 == -1) != this.A;
        }
        return ((i3 == -1) == this.A) == z2();
    }

    private void F2(View view) {
        for (int i3 = this.f52017s - 1; i3 >= 0; i3--) {
            this.f52018t[i3].u(view);
        }
    }

    private void G2(RecyclerView.Recycler recycler, LayoutState layoutState) {
        if (!layoutState.f51742a || layoutState.f51750i) {
            return;
        }
        if (layoutState.f51743b == 0) {
            if (layoutState.f51746e == -1) {
                H2(recycler, layoutState.f51748g);
                return;
            } else {
                I2(recycler, layoutState.f51747f);
                return;
            }
        }
        if (layoutState.f51746e != -1) {
            int iS2 = s2(layoutState.f51748g) - layoutState.f51748g;
            I2(recycler, iS2 < 0 ? layoutState.f51747f : Math.min(iS2, layoutState.f51743b) + layoutState.f51747f);
        } else {
            int i3 = layoutState.f51747f;
            int iR2 = i3 - r2(i3);
            H2(recycler, iR2 < 0 ? layoutState.f51748g : layoutState.f51748g - Math.min(iR2, layoutState.f51743b));
        }
    }

    private void H2(RecyclerView.Recycler recycler, int i3) {
        for (int iP = P() - 1; iP >= 0; iP--) {
            View viewO = O(iP);
            if (this.f52019u.g(viewO) < i3 || this.f52019u.r(viewO) < i3) {
                return;
            }
            LayoutParams layoutParams = (LayoutParams) viewO.getLayoutParams();
            if (layoutParams.f52034f) {
                for (int i4 = 0; i4 < this.f52017s; i4++) {
                    if (this.f52018t[i4].f52051a.size() == 1) {
                        return;
                    }
                }
                for (int i5 = 0; i5 < this.f52017s; i5++) {
                    this.f52018t[i5].s();
                }
            } else if (layoutParams.f52033e.f52051a.size() == 1) {
                return;
            } else {
                layoutParams.f52033e.s();
            }
            r1(viewO, recycler);
        }
    }

    private void I2(RecyclerView.Recycler recycler, int i3) {
        while (P() > 0) {
            View viewO = O(0);
            if (this.f52019u.d(viewO) > i3 || this.f52019u.q(viewO) > i3) {
                return;
            }
            LayoutParams layoutParams = (LayoutParams) viewO.getLayoutParams();
            if (layoutParams.f52034f) {
                for (int i4 = 0; i4 < this.f52017s; i4++) {
                    if (this.f52018t[i4].f52051a.size() == 1) {
                        return;
                    }
                }
                for (int i5 = 0; i5 < this.f52017s; i5++) {
                    this.f52018t[i5].t();
                }
            } else if (layoutParams.f52033e.f52051a.size() == 1) {
                return;
            } else {
                layoutParams.f52033e.t();
            }
            r1(viewO, recycler);
        }
    }

    private void J2() {
        if (this.f52020v.l() == 1073741824) {
            return;
        }
        int iP = P();
        float fMax = 0.0f;
        for (int i3 = 0; i3 < iP; i3++) {
            View viewO = O(i3);
            float fE = this.f52020v.e(viewO);
            if (fE >= fMax) {
                if (((LayoutParams) viewO.getLayoutParams()).e()) {
                    fE = (fE * 1.0f) / this.f52017s;
                }
                fMax = Math.max(fMax, fE);
            }
        }
        int i4 = this.f52022x;
        int iRound = Math.round(fMax * this.f52017s);
        if (this.f52020v.l() == Integer.MIN_VALUE) {
            iRound = Math.min(iRound, this.f52020v.o());
        }
        V2(iRound);
        if (this.f52022x == i4) {
            return;
        }
        for (int i5 = 0; i5 < iP; i5++) {
            View viewO2 = O(i5);
            LayoutParams layoutParams = (LayoutParams) viewO2.getLayoutParams();
            if (!layoutParams.f52034f) {
                if (z2() && this.f52021w == 1) {
                    int i6 = this.f52017s;
                    int i7 = layoutParams.f52033e.f52055e;
                    viewO2.offsetLeftAndRight(((-((i6 - 1) - i7)) * this.f52022x) - ((-((i6 - 1) - i7)) * i4));
                } else {
                    int i8 = layoutParams.f52033e.f52055e;
                    int i9 = this.f52022x * i8;
                    int i10 = i8 * i4;
                    if (this.f52021w == 1) {
                        viewO2.offsetLeftAndRight(i9 - i10);
                    } else {
                        viewO2.offsetTopAndBottom(i9 - i10);
                    }
                }
            }
        }
    }

    private void K2() {
        if (this.f52021w == 1 || !z2()) {
            this.A = this.f52024z;
        } else {
            this.A = !this.f52024z;
        }
    }

    private void M2(int i3) {
        LayoutState layoutState = this.f52023y;
        layoutState.f51746e = i3;
        layoutState.f51745d = this.A != (i3 == -1) ? -1 : 1;
    }

    private void Q2(int i3, int i4) {
        for (int i5 = 0; i5 < this.f52017s; i5++) {
            if (!this.f52018t[i5].f52051a.isEmpty()) {
                W2(this.f52018t[i5], i3, i4);
            }
        }
    }

    private void R1(View view) {
        for (int i3 = this.f52017s - 1; i3 >= 0; i3--) {
            this.f52018t[i3].a(view);
        }
    }

    private boolean R2(RecyclerView.State state, AnchorInfo anchorInfo) {
        anchorInfo.f52026a = this.G ? l2(state.b()) : h2(state.b());
        anchorInfo.f52027b = Integer.MIN_VALUE;
        return true;
    }

    private void S1(AnchorInfo anchorInfo) {
        SavedState savedState = this.I;
        int i3 = savedState.f52043c;
        if (i3 > 0) {
            if (i3 == this.f52017s) {
                for (int i4 = 0; i4 < this.f52017s; i4++) {
                    this.f52018t[i4].e();
                    SavedState savedState2 = this.I;
                    int i5 = savedState2.f52044d[i4];
                    if (i5 != Integer.MIN_VALUE) {
                        i5 += savedState2.f52049j ? this.f52019u.i() : this.f52019u.n();
                    }
                    this.f52018t[i4].v(i5);
                }
            } else {
                savedState.d();
                SavedState savedState3 = this.I;
                savedState3.f52041a = savedState3.f52042b;
            }
        }
        SavedState savedState4 = this.I;
        this.H = savedState4.f52050k;
        O2(savedState4.f52048i);
        K2();
        SavedState savedState5 = this.I;
        int i6 = savedState5.f52041a;
        if (i6 != -1) {
            this.C = i6;
            anchorInfo.f52028c = savedState5.f52049j;
        } else {
            anchorInfo.f52028c = this.A;
        }
        if (savedState5.f52045f > 1) {
            LazySpanLookup lazySpanLookup = this.E;
            lazySpanLookup.f52035a = savedState5.f52046g;
            lazySpanLookup.f52036b = savedState5.f52047h;
        }
    }

    private void U2(int i3, RecyclerView.State state) {
        int iO;
        int iO2;
        int iC;
        LayoutState layoutState = this.f52023y;
        boolean z2 = false;
        layoutState.f51743b = 0;
        layoutState.f51744c = i3;
        if (!C0() || (iC = state.c()) == -1) {
            iO = 0;
            iO2 = 0;
        } else {
            if (this.A == (iC < i3)) {
                iO = this.f52019u.o();
                iO2 = 0;
            } else {
                iO2 = this.f52019u.o();
                iO = 0;
            }
        }
        if (S()) {
            this.f52023y.f51747f = this.f52019u.n() - iO2;
            this.f52023y.f51748g = this.f52019u.i() + iO;
        } else {
            this.f52023y.f51748g = this.f52019u.h() + iO;
            this.f52023y.f51747f = -iO2;
        }
        LayoutState layoutState2 = this.f52023y;
        layoutState2.f51749h = false;
        layoutState2.f51742a = true;
        if (this.f52019u.l() == 0 && this.f52019u.h() == 0) {
            z2 = true;
        }
        layoutState2.f51750i = z2;
    }

    private void V1(View view, LayoutParams layoutParams, LayoutState layoutState) {
        if (layoutState.f51746e == 1) {
            if (layoutParams.f52034f) {
                R1(view);
                return;
            } else {
                layoutParams.f52033e.a(view);
                return;
            }
        }
        if (layoutParams.f52034f) {
            F2(view);
        } else {
            layoutParams.f52033e.u(view);
        }
    }

    private int W1(int i3) {
        if (P() == 0) {
            return this.A ? 1 : -1;
        }
        return (i3 < o2()) != this.A ? -1 : 1;
    }

    private void W2(Span span, int i3, int i4) {
        int iJ = span.j();
        if (i3 == -1) {
            if (span.o() + iJ <= i4) {
                this.B.set(span.f52055e, false);
            }
        } else if (span.k() - iJ >= i4) {
            this.B.set(span.f52055e, false);
        }
    }

    private int X2(int i3, int i4, int i5) {
        int mode;
        return (!(i4 == 0 && i5 == 0) && ((mode = View.MeasureSpec.getMode(i3)) == Integer.MIN_VALUE || mode == 1073741824)) ? View.MeasureSpec.makeMeasureSpec(Math.max(0, (View.MeasureSpec.getSize(i3) - i4) - i5), mode) : i3;
    }

    private boolean Y1(Span span) {
        boolean z2;
        if (!this.A) {
            if (span.o() > this.f52019u.n()) {
                z2 = span.n((View) span.f52051a.get(0)).f52034f;
                return !z2;
            }
            return false;
        }
        if (span.k() < this.f52019u.i()) {
            z2 = span.n((View) span.f52051a.get(r0.size() - 1)).f52034f;
            return !z2;
        }
        return false;
    }

    private int Z1(RecyclerView.State state) {
        if (P() == 0) {
            return 0;
        }
        return ScrollbarHelper.a(state, this.f52019u, j2(!this.N), i2(!this.N), this, this.N);
    }

    private int a2(RecyclerView.State state) {
        if (P() == 0) {
            return 0;
        }
        return ScrollbarHelper.b(state, this.f52019u, j2(!this.N), i2(!this.N), this, this.N, this.A);
    }

    private int b2(RecyclerView.State state) {
        if (P() == 0) {
            return 0;
        }
        return ScrollbarHelper.c(state, this.f52019u, j2(!this.N), i2(!this.N), this, this.N);
    }

    private int c2(int i3) {
        return i3 != 1 ? i3 != 2 ? i3 != 17 ? i3 != 33 ? i3 != 66 ? (i3 == 130 && this.f52021w == 1) ? 1 : Integer.MIN_VALUE : this.f52021w == 0 ? 1 : Integer.MIN_VALUE : this.f52021w == 1 ? -1 : Integer.MIN_VALUE : this.f52021w == 0 ? -1 : Integer.MIN_VALUE : (this.f52021w != 1 && z2()) ? -1 : 1 : (this.f52021w != 1 && z2()) ? 1 : -1;
    }

    private LazySpanLookup.FullSpanItem d2(int i3) {
        LazySpanLookup.FullSpanItem fullSpanItem = new LazySpanLookup.FullSpanItem();
        fullSpanItem.f52039c = new int[this.f52017s];
        for (int i4 = 0; i4 < this.f52017s; i4++) {
            fullSpanItem.f52039c[i4] = i3 - this.f52018t[i4].l(i3);
        }
        return fullSpanItem;
    }

    private LazySpanLookup.FullSpanItem e2(int i3) {
        LazySpanLookup.FullSpanItem fullSpanItem = new LazySpanLookup.FullSpanItem();
        fullSpanItem.f52039c = new int[this.f52017s];
        for (int i4 = 0; i4 < this.f52017s; i4++) {
            fullSpanItem.f52039c[i4] = this.f52018t[i4].p(i3) - i3;
        }
        return fullSpanItem;
    }

    private void f2() {
        this.f52019u = OrientationHelper.b(this, this.f52021w);
        this.f52020v = OrientationHelper.b(this, 1 - this.f52021w);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [androidx.recyclerview.widget.RecyclerView$LayoutManager, androidx.recyclerview.widget.StaggeredGridLayoutManager] */
    /* JADX WARN: Type inference failed for: r0v2, types: [androidx.recyclerview.widget.StaggeredGridLayoutManager] */
    /* JADX WARN: Type inference failed for: r0v3 */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5 */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r5v0 */
    /* JADX WARN: Type inference failed for: r5v1 */
    /* JADX WARN: Type inference failed for: r5v6 */
    /* JADX WARN: Type inference failed for: r8v0 */
    /* JADX WARN: Type inference failed for: r8v1, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r8v5 */
    private int g2(RecyclerView.Recycler recycler, LayoutState layoutState, RecyclerView.State state) {
        Span spanU2;
        int iT2;
        int iE;
        int iN;
        int iE2;
        ?? r02;
        StaggeredGridLayoutManager staggeredGridLayoutManager = this;
        ?? r8 = 0;
        staggeredGridLayoutManager.B.set(0, staggeredGridLayoutManager.f52017s, true);
        int i3 = staggeredGridLayoutManager.f52023y.f51750i ? layoutState.f51746e == 1 ? Api.BaseClientBuilder.API_PRIORITY_OTHER : Integer.MIN_VALUE : layoutState.f51746e == 1 ? layoutState.f51748g + layoutState.f51743b : layoutState.f51747f - layoutState.f51743b;
        staggeredGridLayoutManager.Q2(layoutState.f51746e, i3);
        int i4 = staggeredGridLayoutManager.A ? staggeredGridLayoutManager.f52019u.i() : staggeredGridLayoutManager.f52019u.n();
        boolean z2 = false;
        ?? r03 = staggeredGridLayoutManager;
        while (layoutState.a(state) && (r03.f52023y.f51750i || !r03.B.isEmpty())) {
            View viewB = layoutState.b(recycler);
            LayoutParams layoutParams = (LayoutParams) viewB.getLayoutParams();
            int iA = layoutParams.a();
            int iG = r03.E.g(iA);
            ?? r5 = iG == -1 ? 1 : r8;
            if (r5 != 0) {
                spanU2 = layoutParams.f52034f ? r03.f52018t[r8] : r03.u2(layoutState);
                r03.E.n(iA, spanU2);
            } else {
                spanU2 = r03.f52018t[iG];
            }
            Span span = spanU2;
            layoutParams.f52033e = span;
            if (layoutState.f51746e == 1) {
                r03.j(viewB);
            } else {
                r03.k(viewB, r8);
            }
            r03.B2(viewB, layoutParams, r8);
            if (layoutState.f51746e == 1) {
                iE = layoutParams.f52034f ? r03.q2(i4) : span.l(i4);
                iT2 = r03.f52019u.e(viewB) + iE;
                if (r5 != 0 && layoutParams.f52034f) {
                    LazySpanLookup.FullSpanItem fullSpanItemD2 = r03.d2(iE);
                    fullSpanItemD2.f52038b = -1;
                    fullSpanItemD2.f52037a = iA;
                    r03.E.a(fullSpanItemD2);
                }
            } else {
                iT2 = layoutParams.f52034f ? r03.t2(i4) : span.p(i4);
                iE = iT2 - r03.f52019u.e(viewB);
                if (r5 != 0 && layoutParams.f52034f) {
                    LazySpanLookup.FullSpanItem fullSpanItemE2 = r03.e2(iT2);
                    fullSpanItemE2.f52038b = 1;
                    fullSpanItemE2.f52037a = iA;
                    r03.E.a(fullSpanItemE2);
                }
            }
            if (layoutParams.f52034f && layoutState.f51745d == -1) {
                if (r5 != 0) {
                    r03.M = true;
                } else {
                    if (!(layoutState.f51746e == 1 ? r03.T1() : r03.U1())) {
                        LazySpanLookup.FullSpanItem fullSpanItemF = r03.E.f(iA);
                        if (fullSpanItemF != null) {
                            fullSpanItemF.f52040d = true;
                        }
                        r03.M = true;
                    }
                }
            }
            r03.V1(viewB, layoutParams, layoutState);
            if (r03.z2() && r03.f52021w == 1) {
                iE2 = layoutParams.f52034f ? r03.f52020v.i() : r03.f52020v.i() - (((r03.f52017s - 1) - span.f52055e) * r03.f52022x);
                iN = iE2 - r03.f52020v.e(viewB);
            } else {
                iN = layoutParams.f52034f ? r03.f52020v.n() : (span.f52055e * r03.f52022x) + r03.f52020v.n();
                iE2 = r03.f52020v.e(viewB) + iN;
            }
            int i5 = iE2;
            int i6 = iN;
            if (r03.f52021w == 1) {
                r03.E0(viewB, i6, iE, i5, iT2);
                r02 = this;
            } else {
                r03.E0(viewB, iE, i6, iT2, i5);
                r02 = r03;
            }
            if (layoutParams.f52034f) {
                r02.Q2(r02.f52023y.f51746e, i3);
            } else {
                r02.W2(span, r02.f52023y.f51746e, i3);
            }
            r02.G2(recycler, r02.f52023y);
            if (r02.f52023y.f51749h && viewB.hasFocusable()) {
                if (layoutParams.f52034f) {
                    r02.B.clear();
                } else {
                    r02.B.set(span.f52055e, false);
                }
            }
            z2 = true;
            r8 = 0;
            r03 = r02;
        }
        if (!z2) {
            r03.G2(recycler, r03.f52023y);
        }
        int iN2 = r03.f52023y.f51746e == -1 ? r03.f52019u.n() - r03.t2(r03.f52019u.n()) : r03.q2(r03.f52019u.i()) - r03.f52019u.i();
        if (iN2 > 0) {
            return Math.min(layoutState.f51743b, iN2);
        }
        return 0;
    }

    private int h2(int i3) {
        int iP = P();
        for (int i4 = 0; i4 < iP; i4++) {
            int iM0 = m0(O(i4));
            if (iM0 >= 0 && iM0 < i3) {
                return iM0;
            }
        }
        return 0;
    }

    private int l2(int i3) {
        for (int iP = P() - 1; iP >= 0; iP--) {
            int iM0 = m0(O(iP));
            if (iM0 >= 0 && iM0 < i3) {
                return iM0;
            }
        }
        return 0;
    }

    private void m2(RecyclerView.Recycler recycler, RecyclerView.State state, boolean z2) {
        int i3;
        int iQ2 = q2(Integer.MIN_VALUE);
        if (iQ2 != Integer.MIN_VALUE && (i3 = this.f52019u.i() - iQ2) > 0) {
            int i4 = i3 - (-L2(-i3, recycler, state));
            if (!z2 || i4 <= 0) {
                return;
            }
            this.f52019u.s(i4);
        }
    }

    private void n2(RecyclerView.Recycler recycler, RecyclerView.State state, boolean z2) {
        int iN;
        int iT2 = t2(Api.BaseClientBuilder.API_PRIORITY_OTHER);
        if (iT2 != Integer.MAX_VALUE && (iN = iT2 - this.f52019u.n()) > 0) {
            int iL2 = iN - L2(iN, recycler, state);
            if (!z2 || iL2 <= 0) {
                return;
            }
            this.f52019u.s(-iL2);
        }
    }

    private int q2(int i3) {
        int iL = this.f52018t[0].l(i3);
        for (int i4 = 1; i4 < this.f52017s; i4++) {
            int iL2 = this.f52018t[i4].l(i3);
            if (iL2 > iL) {
                iL = iL2;
            }
        }
        return iL;
    }

    private int r2(int i3) {
        int iP = this.f52018t[0].p(i3);
        for (int i4 = 1; i4 < this.f52017s; i4++) {
            int iP2 = this.f52018t[i4].p(i3);
            if (iP2 > iP) {
                iP = iP2;
            }
        }
        return iP;
    }

    private int s2(int i3) {
        int iL = this.f52018t[0].l(i3);
        for (int i4 = 1; i4 < this.f52017s; i4++) {
            int iL2 = this.f52018t[i4].l(i3);
            if (iL2 < iL) {
                iL = iL2;
            }
        }
        return iL;
    }

    private int t2(int i3) {
        int iP = this.f52018t[0].p(i3);
        for (int i4 = 1; i4 < this.f52017s; i4++) {
            int iP2 = this.f52018t[i4].p(i3);
            if (iP2 < iP) {
                iP = iP2;
            }
        }
        return iP;
    }

    private Span u2(LayoutState layoutState) {
        int i3;
        int i4;
        int i5;
        if (D2(layoutState.f51746e)) {
            i4 = this.f52017s - 1;
            i3 = -1;
            i5 = -1;
        } else {
            i3 = this.f52017s;
            i4 = 0;
            i5 = 1;
        }
        Span span = null;
        if (layoutState.f51746e == 1) {
            int iN = this.f52019u.n();
            int i6 = Api.BaseClientBuilder.API_PRIORITY_OTHER;
            while (i4 != i3) {
                Span span2 = this.f52018t[i4];
                int iL = span2.l(iN);
                if (iL < i6) {
                    span = span2;
                    i6 = iL;
                }
                i4 += i5;
            }
            return span;
        }
        int i7 = this.f52019u.i();
        int i8 = Integer.MIN_VALUE;
        while (i4 != i3) {
            Span span3 = this.f52018t[i4];
            int iP = span3.p(i7);
            if (iP > i8) {
                span = span3;
                i8 = iP;
            }
            i4 += i5;
        }
        return span;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0026  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x003d  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0045  */
    /* JADX WARN: Removed duplicated region for block: B:32:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void w2(int r7, int r8, int r9) {
        /*
            r6 = this;
            boolean r0 = r6.A
            if (r0 == 0) goto L9
            int r0 = r6.p2()
            goto Ld
        L9:
            int r0 = r6.o2()
        Ld:
            r1 = 8
            if (r9 != r1) goto L1b
            if (r7 >= r8) goto L17
            int r2 = r8 + 1
        L15:
            r3 = r7
            goto L1e
        L17:
            int r2 = r7 + 1
            r3 = r8
            goto L1e
        L1b:
            int r2 = r7 + r8
            goto L15
        L1e:
            androidx.recyclerview.widget.StaggeredGridLayoutManager$LazySpanLookup r4 = r6.E
            r4.h(r3)
            r4 = 1
            if (r9 == r4) goto L3d
            r5 = 2
            if (r9 == r5) goto L37
            if (r9 == r1) goto L2c
            goto L42
        L2c:
            androidx.recyclerview.widget.StaggeredGridLayoutManager$LazySpanLookup r9 = r6.E
            r9.k(r7, r4)
            androidx.recyclerview.widget.StaggeredGridLayoutManager$LazySpanLookup r7 = r6.E
            r7.j(r8, r4)
            goto L42
        L37:
            androidx.recyclerview.widget.StaggeredGridLayoutManager$LazySpanLookup r9 = r6.E
            r9.k(r7, r8)
            goto L42
        L3d:
            androidx.recyclerview.widget.StaggeredGridLayoutManager$LazySpanLookup r9 = r6.E
            r9.j(r7, r8)
        L42:
            if (r2 > r0) goto L45
            goto L57
        L45:
            boolean r7 = r6.A
            if (r7 == 0) goto L4e
            int r7 = r6.o2()
            goto L52
        L4e:
            int r7 = r6.p2()
        L52:
            if (r3 > r7) goto L57
            r6.y1()
        L57:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.StaggeredGridLayoutManager.w2(int, int, int):void");
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int A(RecyclerView.State state) {
        return a2(state);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int B(RecyclerView.State state) {
        return b2(state);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int B1(int i3, RecyclerView.Recycler recycler, RecyclerView.State state) {
        return L2(i3, recycler, state);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void C1(int i3) {
        SavedState savedState = this.I;
        if (savedState != null && savedState.f52041a != i3) {
            savedState.c();
        }
        this.C = i3;
        this.D = Integer.MIN_VALUE;
        y1();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int D1(int i3, RecyclerView.Recycler recycler, RecyclerView.State state) {
        return L2(i3, recycler, state);
    }

    void E2(int i3, RecyclerView.State state) {
        int iO2;
        int i4;
        if (i3 > 0) {
            iO2 = p2();
            i4 = 1;
        } else {
            iO2 = o2();
            i4 = -1;
        }
        this.f52023y.f51742a = true;
        U2(iO2, state);
        M2(i4);
        LayoutState layoutState = this.f52023y;
        layoutState.f51744c = iO2 + layoutState.f51745d;
        layoutState.f51743b = Math.abs(i3);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void H0(int i3) {
        super.H0(i3);
        for (int i4 = 0; i4 < this.f52017s; i4++) {
            this.f52018t[i4].r(i3);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void H1(Rect rect, int i3, int i4) {
        int iT;
        int iT2;
        int iJ0 = j0() + k0();
        int iL0 = l0() + i0();
        if (this.f52021w == 1) {
            iT2 = RecyclerView.LayoutManager.t(i4, rect.height() + iL0, g0());
            iT = RecyclerView.LayoutManager.t(i3, (this.f52022x * this.f52017s) + iJ0, h0());
        } else {
            iT = RecyclerView.LayoutManager.t(i3, rect.width() + iJ0, h0());
            iT2 = RecyclerView.LayoutManager.t(i4, (this.f52022x * this.f52017s) + iL0, g0());
        }
        G1(iT, iT2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void I0(int i3) {
        super.I0(i3);
        for (int i4 = 0; i4 < this.f52017s; i4++) {
            this.f52018t[i4].r(i3);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public RecyclerView.LayoutParams J() {
        return this.f52021w == 0 ? new LayoutParams(-2, -1) : new LayoutParams(-1, -2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void J0(RecyclerView.Adapter adapter, RecyclerView.Adapter adapter2) {
        this.E.b();
        for (int i3 = 0; i3 < this.f52017s; i3++) {
            this.f52018t[i3].e();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public RecyclerView.LayoutParams K(Context context, AttributeSet attributeSet) {
        return new LayoutParams(context, attributeSet);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public RecyclerView.LayoutParams L(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof ViewGroup.MarginLayoutParams ? new LayoutParams((ViewGroup.MarginLayoutParams) layoutParams) : new LayoutParams(layoutParams);
    }

    int L2(int i3, RecyclerView.Recycler recycler, RecyclerView.State state) {
        if (P() == 0 || i3 == 0) {
            return 0;
        }
        E2(i3, state);
        int iG2 = g2(recycler, this.f52023y, state);
        if (this.f52023y.f51743b >= iG2) {
            i3 = i3 < 0 ? -iG2 : iG2;
        }
        this.f52019u.s(-i3);
        this.G = this.A;
        LayoutState layoutState = this.f52023y;
        layoutState.f51743b = 0;
        G2(recycler, layoutState);
        return i3;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void N0(RecyclerView recyclerView, RecyclerView.Recycler recycler) {
        super.N0(recyclerView, recycler);
        t1(this.P);
        for (int i3 = 0; i3 < this.f52017s; i3++) {
            this.f52018t[i3].e();
        }
        recyclerView.requestLayout();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void N1(RecyclerView recyclerView, RecyclerView.State state, int i3) {
        LinearSmoothScroller linearSmoothScroller = new LinearSmoothScroller(recyclerView.getContext());
        linearSmoothScroller.p(i3);
        O1(linearSmoothScroller);
    }

    public void N2(int i3) {
        if (i3 != 0 && i3 != 1) {
            throw new IllegalArgumentException("invalid orientation.");
        }
        m(null);
        if (i3 == this.f52021w) {
            return;
        }
        this.f52021w = i3;
        OrientationHelper orientationHelper = this.f52019u;
        this.f52019u = this.f52020v;
        this.f52020v = orientationHelper;
        y1();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public View O0(View view, int i3, RecyclerView.Recycler recycler, RecyclerView.State state) {
        View viewH;
        View viewM;
        if (P() == 0 || (viewH = H(view)) == null) {
            return null;
        }
        K2();
        int iC2 = c2(i3);
        if (iC2 == Integer.MIN_VALUE) {
            return null;
        }
        LayoutParams layoutParams = (LayoutParams) viewH.getLayoutParams();
        boolean z2 = layoutParams.f52034f;
        Span span = layoutParams.f52033e;
        int iP2 = iC2 == 1 ? p2() : o2();
        U2(iP2, state);
        M2(iC2);
        LayoutState layoutState = this.f52023y;
        layoutState.f51744c = layoutState.f51745d + iP2;
        layoutState.f51743b = (int) (this.f52019u.o() * 0.33333334f);
        LayoutState layoutState2 = this.f52023y;
        layoutState2.f51749h = true;
        layoutState2.f51742a = false;
        g2(recycler, layoutState2, state);
        this.G = this.A;
        if (!z2 && (viewM = span.m(iP2, iC2)) != null && viewM != viewH) {
            return viewM;
        }
        if (D2(iC2)) {
            for (int i4 = this.f52017s - 1; i4 >= 0; i4--) {
                View viewM2 = this.f52018t[i4].m(iP2, iC2);
                if (viewM2 != null && viewM2 != viewH) {
                    return viewM2;
                }
            }
        } else {
            for (int i5 = 0; i5 < this.f52017s; i5++) {
                View viewM3 = this.f52018t[i5].m(iP2, iC2);
                if (viewM3 != null && viewM3 != viewH) {
                    return viewM3;
                }
            }
        }
        boolean z3 = (this.f52024z ^ true) == (iC2 == -1);
        if (!z2) {
            View viewI = I(z3 ? span.f() : span.g());
            if (viewI != null && viewI != viewH) {
                return viewI;
            }
        }
        if (D2(iC2)) {
            for (int i6 = this.f52017s - 1; i6 >= 0; i6--) {
                if (i6 != span.f52055e) {
                    View viewI2 = I(z3 ? this.f52018t[i6].f() : this.f52018t[i6].g());
                    if (viewI2 != null && viewI2 != viewH) {
                        return viewI2;
                    }
                }
            }
        } else {
            for (int i7 = 0; i7 < this.f52017s; i7++) {
                View viewI3 = I(z3 ? this.f52018t[i7].f() : this.f52018t[i7].g());
                if (viewI3 != null && viewI3 != viewH) {
                    return viewI3;
                }
            }
        }
        return null;
    }

    public void O2(boolean z2) {
        m(null);
        SavedState savedState = this.I;
        if (savedState != null && savedState.f52048i != z2) {
            savedState.f52048i = z2;
        }
        this.f52024z = z2;
        y1();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void P0(AccessibilityEvent accessibilityEvent) {
        super.P0(accessibilityEvent);
        if (P() > 0) {
            View viewJ2 = j2(false);
            View viewI2 = i2(false);
            if (viewJ2 == null || viewI2 == null) {
                return;
            }
            int iM0 = m0(viewJ2);
            int iM02 = m0(viewI2);
            if (iM0 < iM02) {
                accessibilityEvent.setFromIndex(iM0);
                accessibilityEvent.setToIndex(iM02);
            } else {
                accessibilityEvent.setFromIndex(iM02);
                accessibilityEvent.setToIndex(iM0);
            }
        }
    }

    public void P2(int i3) {
        m(null);
        if (i3 != this.f52017s) {
            y2();
            this.f52017s = i3;
            this.B = new BitSet(this.f52017s);
            this.f52018t = new Span[this.f52017s];
            for (int i4 = 0; i4 < this.f52017s; i4++) {
                this.f52018t[i4] = new Span(i4);
            }
            y1();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public boolean Q1() {
        return this.I == null;
    }

    boolean S2(RecyclerView.State state, AnchorInfo anchorInfo) {
        int i3;
        if (!state.e() && (i3 = this.C) != -1) {
            if (i3 >= 0 && i3 < state.b()) {
                SavedState savedState = this.I;
                if (savedState == null || savedState.f52041a == -1 || savedState.f52043c < 1) {
                    View viewI = I(this.C);
                    if (viewI != null) {
                        anchorInfo.f52026a = this.A ? p2() : o2();
                        if (this.D != Integer.MIN_VALUE) {
                            if (anchorInfo.f52028c) {
                                anchorInfo.f52027b = (this.f52019u.i() - this.D) - this.f52019u.d(viewI);
                            } else {
                                anchorInfo.f52027b = (this.f52019u.n() + this.D) - this.f52019u.g(viewI);
                            }
                            return true;
                        }
                        if (this.f52019u.e(viewI) > this.f52019u.o()) {
                            anchorInfo.f52027b = anchorInfo.f52028c ? this.f52019u.i() : this.f52019u.n();
                            return true;
                        }
                        int iG = this.f52019u.g(viewI) - this.f52019u.n();
                        if (iG < 0) {
                            anchorInfo.f52027b = -iG;
                            return true;
                        }
                        int i4 = this.f52019u.i() - this.f52019u.d(viewI);
                        if (i4 < 0) {
                            anchorInfo.f52027b = i4;
                            return true;
                        }
                        anchorInfo.f52027b = Integer.MIN_VALUE;
                    } else {
                        int i5 = this.C;
                        anchorInfo.f52026a = i5;
                        int i6 = this.D;
                        if (i6 == Integer.MIN_VALUE) {
                            anchorInfo.f52028c = W1(i5) == 1;
                            anchorInfo.a();
                        } else {
                            anchorInfo.b(i6);
                        }
                        anchorInfo.f52029d = true;
                    }
                } else {
                    anchorInfo.f52027b = Integer.MIN_VALUE;
                    anchorInfo.f52026a = this.C;
                }
                return true;
            }
            this.C = -1;
            this.D = Integer.MIN_VALUE;
        }
        return false;
    }

    boolean T1() {
        int iL = this.f52018t[0].l(Integer.MIN_VALUE);
        for (int i3 = 1; i3 < this.f52017s; i3++) {
            if (this.f52018t[i3].l(Integer.MIN_VALUE) != iL) {
                return false;
            }
        }
        return true;
    }

    void T2(RecyclerView.State state, AnchorInfo anchorInfo) {
        if (S2(state, anchorInfo) || R2(state, anchorInfo)) {
            return;
        }
        anchorInfo.a();
        anchorInfo.f52026a = 0;
    }

    boolean U1() {
        int iP = this.f52018t[0].p(Integer.MIN_VALUE);
        for (int i3 = 1; i3 < this.f52017s; i3++) {
            if (this.f52018t[i3].p(Integer.MIN_VALUE) != iP) {
                return false;
            }
        }
        return true;
    }

    void V2(int i3) {
        this.f52022x = i3 / this.f52017s;
        this.J = View.MeasureSpec.makeMeasureSpec(i3, this.f52020v.l());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void W0(RecyclerView recyclerView, int i3, int i4) {
        w2(i3, i4, 1);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void X0(RecyclerView recyclerView) {
        this.E.b();
        y1();
    }

    boolean X1() {
        int iO2;
        int iP2;
        if (P() == 0 || this.F == 0 || !w0()) {
            return false;
        }
        if (this.A) {
            iO2 = p2();
            iP2 = o2();
        } else {
            iO2 = o2();
            iP2 = p2();
        }
        if (iO2 == 0 && x2() != null) {
            this.E.b();
            z1();
            y1();
            return true;
        }
        if (!this.M) {
            return false;
        }
        int i3 = this.A ? -1 : 1;
        int i4 = iP2 + 1;
        LazySpanLookup.FullSpanItem fullSpanItemE = this.E.e(iO2, i4, i3, true);
        if (fullSpanItemE == null) {
            this.M = false;
            this.E.d(i4);
            return false;
        }
        LazySpanLookup.FullSpanItem fullSpanItemE2 = this.E.e(iO2, fullSpanItemE.f52037a, i3 * (-1), true);
        if (fullSpanItemE2 == null) {
            this.E.d(fullSpanItemE.f52037a);
        } else {
            this.E.d(fullSpanItemE2.f52037a + 1);
        }
        z1();
        y1();
        return true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void Y0(RecyclerView recyclerView, int i3, int i4, int i5) {
        w2(i3, i4, 8);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void Z0(RecyclerView recyclerView, int i3, int i4) {
        w2(i3, i4, 2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void b1(RecyclerView recyclerView, int i3, int i4, Object obj) {
        w2(i3, i4, 4);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void c1(RecyclerView.Recycler recycler, RecyclerView.State state) {
        C2(recycler, state, true);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void d1(RecyclerView.State state) {
        super.d1(state);
        this.C = -1;
        this.D = Integer.MIN_VALUE;
        this.I = null;
        this.L.c();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.SmoothScroller.ScrollVectorProvider
    public PointF e(int i3) {
        int iW1 = W1(i3);
        PointF pointF = new PointF();
        if (iW1 == 0) {
            return null;
        }
        if (this.f52021w == 0) {
            pointF.x = iW1;
            pointF.y = 0.0f;
            return pointF;
        }
        pointF.x = 0.0f;
        pointF.y = iW1;
        return pointF;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void h1(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            SavedState savedState = (SavedState) parcelable;
            this.I = savedState;
            if (this.C != -1) {
                savedState.c();
                this.I.d();
            }
            y1();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public Parcelable i1() {
        int iP;
        int iN;
        int[] iArr;
        if (this.I != null) {
            return new SavedState(this.I);
        }
        SavedState savedState = new SavedState();
        savedState.f52048i = this.f52024z;
        savedState.f52049j = this.G;
        savedState.f52050k = this.H;
        LazySpanLookup lazySpanLookup = this.E;
        if (lazySpanLookup == null || (iArr = lazySpanLookup.f52035a) == null) {
            savedState.f52045f = 0;
        } else {
            savedState.f52046g = iArr;
            savedState.f52045f = iArr.length;
            savedState.f52047h = lazySpanLookup.f52036b;
        }
        if (P() <= 0) {
            savedState.f52041a = -1;
            savedState.f52042b = -1;
            savedState.f52043c = 0;
            return savedState;
        }
        savedState.f52041a = this.G ? p2() : o2();
        savedState.f52042b = k2();
        int i3 = this.f52017s;
        savedState.f52043c = i3;
        savedState.f52044d = new int[i3];
        for (int i4 = 0; i4 < this.f52017s; i4++) {
            if (this.G) {
                iP = this.f52018t[i4].l(Integer.MIN_VALUE);
                if (iP != Integer.MIN_VALUE) {
                    iN = this.f52019u.i();
                    iP -= iN;
                }
            } else {
                iP = this.f52018t[i4].p(Integer.MIN_VALUE);
                if (iP != Integer.MIN_VALUE) {
                    iN = this.f52019u.n();
                    iP -= iN;
                }
            }
            savedState.f52044d[i4] = iP;
        }
        return savedState;
    }

    View i2(boolean z2) {
        int iN = this.f52019u.n();
        int i3 = this.f52019u.i();
        View view = null;
        for (int iP = P() - 1; iP >= 0; iP--) {
            View viewO = O(iP);
            int iG = this.f52019u.g(viewO);
            int iD = this.f52019u.d(viewO);
            if (iD > iN && iG < i3) {
                if (iD <= i3 || !z2) {
                    return viewO;
                }
                if (view == null) {
                    view = viewO;
                }
            }
        }
        return view;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void j1(int i3) {
        if (i3 == 0) {
            X1();
        }
    }

    View j2(boolean z2) {
        int iN = this.f52019u.n();
        int i3 = this.f52019u.i();
        int iP = P();
        View view = null;
        for (int i4 = 0; i4 < iP; i4++) {
            View viewO = O(i4);
            int iG = this.f52019u.g(viewO);
            if (this.f52019u.d(viewO) > iN && iG < i3) {
                if (iG >= iN || !z2) {
                    return viewO;
                }
                if (view == null) {
                    view = viewO;
                }
            }
        }
        return view;
    }

    int k2() {
        View viewI2 = this.A ? i2(true) : j2(true);
        if (viewI2 == null) {
            return -1;
        }
        return m0(viewI2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void m(String str) {
        if (this.I == null) {
            super.m(str);
        }
    }

    int o2() {
        if (P() == 0) {
            return 0;
        }
        return m0(O(0));
    }

    int p2() {
        int iP = P();
        if (iP == 0) {
            return 0;
        }
        return m0(O(iP - 1));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public boolean q() {
        return this.f52021w == 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public boolean r() {
        return this.f52021w == 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public boolean s(RecyclerView.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void u(int i3, int i4, RecyclerView.State state, RecyclerView.LayoutManager.LayoutPrefetchRegistry layoutPrefetchRegistry) {
        int iL;
        int iP;
        if (this.f52021w != 0) {
            i3 = i4;
        }
        if (P() == 0 || i3 == 0) {
            return;
        }
        E2(i3, state);
        int[] iArr = this.O;
        if (iArr == null || iArr.length < this.f52017s) {
            this.O = new int[this.f52017s];
        }
        int i5 = 0;
        for (int i6 = 0; i6 < this.f52017s; i6++) {
            LayoutState layoutState = this.f52023y;
            if (layoutState.f51745d == -1) {
                iL = layoutState.f51747f;
                iP = this.f52018t[i6].p(iL);
            } else {
                iL = this.f52018t[i6].l(layoutState.f51748g);
                iP = this.f52023y.f51748g;
            }
            int i7 = iL - iP;
            if (i7 >= 0) {
                this.O[i5] = i7;
                i5++;
            }
        }
        Arrays.sort(this.O, 0, i5);
        for (int i8 = 0; i8 < i5 && this.f52023y.a(state); i8++) {
            layoutPrefetchRegistry.a(this.f52023y.f51744c, this.O[i8]);
            LayoutState layoutState2 = this.f52023y;
            layoutState2.f51744c += layoutState2.f51745d;
        }
    }

    public int v2() {
        return this.f52017s;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int w(RecyclerView.State state) {
        return Z1(state);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int x(RecyclerView.State state) {
        return a2(state);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public boolean x0() {
        return this.F != 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0075  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0086  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    android.view.View x2() {
        /*
            r12 = this;
            int r0 = r12.P()
            int r1 = r0 + (-1)
            java.util.BitSet r2 = new java.util.BitSet
            int r3 = r12.f52017s
            r2.<init>(r3)
            int r3 = r12.f52017s
            r4 = 0
            r5 = 1
            r2.set(r4, r3, r5)
            int r3 = r12.f52021w
            r6 = -1
            if (r3 != r5) goto L21
            boolean r3 = r12.z2()
            if (r3 == 0) goto L21
            r3 = r5
            goto L22
        L21:
            r3 = r6
        L22:
            boolean r7 = r12.A
            if (r7 == 0) goto L28
            r0 = r6
            goto L29
        L28:
            r1 = r4
        L29:
            if (r1 >= r0) goto L2c
            r6 = r5
        L2c:
            if (r1 == r0) goto La4
            android.view.View r7 = r12.O(r1)
            android.view.ViewGroup$LayoutParams r8 = r7.getLayoutParams()
            androidx.recyclerview.widget.StaggeredGridLayoutManager$LayoutParams r8 = (androidx.recyclerview.widget.StaggeredGridLayoutManager.LayoutParams) r8
            androidx.recyclerview.widget.StaggeredGridLayoutManager$Span r9 = r8.f52033e
            int r9 = r9.f52055e
            boolean r9 = r2.get(r9)
            if (r9 == 0) goto L52
            androidx.recyclerview.widget.StaggeredGridLayoutManager$Span r9 = r8.f52033e
            boolean r9 = r12.Y1(r9)
            if (r9 == 0) goto L4b
            goto La1
        L4b:
            androidx.recyclerview.widget.StaggeredGridLayoutManager$Span r9 = r8.f52033e
            int r9 = r9.f52055e
            r2.clear(r9)
        L52:
            boolean r9 = r8.f52034f
            if (r9 == 0) goto L57
            goto La2
        L57:
            int r9 = r1 + r6
            if (r9 == r0) goto La2
            android.view.View r9 = r12.O(r9)
            boolean r10 = r12.A
            if (r10 == 0) goto L75
            androidx.recyclerview.widget.OrientationHelper r10 = r12.f52019u
            int r10 = r10.d(r7)
            androidx.recyclerview.widget.OrientationHelper r11 = r12.f52019u
            int r11 = r11.d(r9)
            if (r10 >= r11) goto L72
            goto La1
        L72:
            if (r10 != r11) goto La2
            goto L86
        L75:
            androidx.recyclerview.widget.OrientationHelper r10 = r12.f52019u
            int r10 = r10.g(r7)
            androidx.recyclerview.widget.OrientationHelper r11 = r12.f52019u
            int r11 = r11.g(r9)
            if (r10 <= r11) goto L84
            goto La1
        L84:
            if (r10 != r11) goto La2
        L86:
            android.view.ViewGroup$LayoutParams r9 = r9.getLayoutParams()
            androidx.recyclerview.widget.StaggeredGridLayoutManager$LayoutParams r9 = (androidx.recyclerview.widget.StaggeredGridLayoutManager.LayoutParams) r9
            androidx.recyclerview.widget.StaggeredGridLayoutManager$Span r8 = r8.f52033e
            int r8 = r8.f52055e
            androidx.recyclerview.widget.StaggeredGridLayoutManager$Span r9 = r9.f52033e
            int r9 = r9.f52055e
            int r8 = r8 - r9
            if (r8 >= 0) goto L99
            r8 = r5
            goto L9a
        L99:
            r8 = r4
        L9a:
            if (r3 >= 0) goto L9e
            r9 = r5
            goto L9f
        L9e:
            r9 = r4
        L9f:
            if (r8 == r9) goto La2
        La1:
            return r7
        La2:
            int r1 = r1 + r6
            goto L2c
        La4:
            r0 = 0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.StaggeredGridLayoutManager.x2():android.view.View");
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int y(RecyclerView.State state) {
        return b2(state);
    }

    public void y2() {
        this.E.b();
        y1();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int z(RecyclerView.State state) {
        return Z1(state);
    }

    boolean z2() {
        return e0() == 1;
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class LazySpanLookup {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int[] f52035a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        List f52036b;

        LazySpanLookup() {
        }

        private int i(int i3) {
            if (this.f52036b == null) {
                return -1;
            }
            FullSpanItem fullSpanItemF = f(i3);
            if (fullSpanItemF != null) {
                this.f52036b.remove(fullSpanItemF);
            }
            int size = this.f52036b.size();
            int i4 = 0;
            while (true) {
                if (i4 >= size) {
                    i4 = -1;
                    break;
                }
                if (((FullSpanItem) this.f52036b.get(i4)).f52037a >= i3) {
                    break;
                }
                i4++;
            }
            if (i4 == -1) {
                return -1;
            }
            FullSpanItem fullSpanItem = (FullSpanItem) this.f52036b.get(i4);
            this.f52036b.remove(i4);
            return fullSpanItem.f52037a;
        }

        private void l(int i3, int i4) {
            List list = this.f52036b;
            if (list == null) {
                return;
            }
            for (int size = list.size() - 1; size >= 0; size--) {
                FullSpanItem fullSpanItem = (FullSpanItem) this.f52036b.get(size);
                int i5 = fullSpanItem.f52037a;
                if (i5 >= i3) {
                    fullSpanItem.f52037a = i5 + i4;
                }
            }
        }

        private void m(int i3, int i4) {
            List list = this.f52036b;
            if (list == null) {
                return;
            }
            int i5 = i3 + i4;
            for (int size = list.size() - 1; size >= 0; size--) {
                FullSpanItem fullSpanItem = (FullSpanItem) this.f52036b.get(size);
                int i6 = fullSpanItem.f52037a;
                if (i6 >= i3) {
                    if (i6 < i5) {
                        this.f52036b.remove(size);
                    } else {
                        fullSpanItem.f52037a = i6 - i4;
                    }
                }
            }
        }

        public void a(FullSpanItem fullSpanItem) {
            if (this.f52036b == null) {
                this.f52036b = new ArrayList();
            }
            int size = this.f52036b.size();
            for (int i3 = 0; i3 < size; i3++) {
                FullSpanItem fullSpanItem2 = (FullSpanItem) this.f52036b.get(i3);
                if (fullSpanItem2.f52037a == fullSpanItem.f52037a) {
                    this.f52036b.remove(i3);
                }
                if (fullSpanItem2.f52037a >= fullSpanItem.f52037a) {
                    this.f52036b.add(i3, fullSpanItem);
                    return;
                }
            }
            this.f52036b.add(fullSpanItem);
        }

        void b() {
            int[] iArr = this.f52035a;
            if (iArr != null) {
                Arrays.fill(iArr, -1);
            }
            this.f52036b = null;
        }

        void c(int i3) {
            int[] iArr = this.f52035a;
            if (iArr == null) {
                int[] iArr2 = new int[Math.max(i3, 10) + 1];
                this.f52035a = iArr2;
                Arrays.fill(iArr2, -1);
            } else if (i3 >= iArr.length) {
                int[] iArr3 = new int[o(i3)];
                this.f52035a = iArr3;
                System.arraycopy(iArr, 0, iArr3, 0, iArr.length);
                int[] iArr4 = this.f52035a;
                Arrays.fill(iArr4, iArr.length, iArr4.length, -1);
            }
        }

        int d(int i3) {
            List list = this.f52036b;
            if (list != null) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    if (((FullSpanItem) this.f52036b.get(size)).f52037a >= i3) {
                        this.f52036b.remove(size);
                    }
                }
            }
            return h(i3);
        }

        public FullSpanItem e(int i3, int i4, int i5, boolean z2) {
            List list = this.f52036b;
            if (list == null) {
                return null;
            }
            int size = list.size();
            for (int i6 = 0; i6 < size; i6++) {
                FullSpanItem fullSpanItem = (FullSpanItem) this.f52036b.get(i6);
                int i7 = fullSpanItem.f52037a;
                if (i7 >= i4) {
                    return null;
                }
                if (i7 >= i3 && (i5 == 0 || fullSpanItem.f52038b == i5 || (z2 && fullSpanItem.f52040d))) {
                    return fullSpanItem;
                }
            }
            return null;
        }

        public FullSpanItem f(int i3) {
            List list = this.f52036b;
            if (list == null) {
                return null;
            }
            for (int size = list.size() - 1; size >= 0; size--) {
                FullSpanItem fullSpanItem = (FullSpanItem) this.f52036b.get(size);
                if (fullSpanItem.f52037a == i3) {
                    return fullSpanItem;
                }
            }
            return null;
        }

        int g(int i3) {
            int[] iArr = this.f52035a;
            if (iArr == null || i3 >= iArr.length) {
                return -1;
            }
            return iArr[i3];
        }

        int h(int i3) {
            int[] iArr = this.f52035a;
            if (iArr == null || i3 >= iArr.length) {
                return -1;
            }
            int i4 = i(i3);
            if (i4 == -1) {
                int[] iArr2 = this.f52035a;
                Arrays.fill(iArr2, i3, iArr2.length, -1);
                return this.f52035a.length;
            }
            int iMin = Math.min(i4 + 1, this.f52035a.length);
            Arrays.fill(this.f52035a, i3, iMin, -1);
            return iMin;
        }

        void j(int i3, int i4) {
            int[] iArr = this.f52035a;
            if (iArr == null || i3 >= iArr.length) {
                return;
            }
            int i5 = i3 + i4;
            c(i5);
            int[] iArr2 = this.f52035a;
            System.arraycopy(iArr2, i3, iArr2, i5, (iArr2.length - i3) - i4);
            Arrays.fill(this.f52035a, i3, i5, -1);
            l(i3, i4);
        }

        void k(int i3, int i4) {
            int[] iArr = this.f52035a;
            if (iArr == null || i3 >= iArr.length) {
                return;
            }
            int i5 = i3 + i4;
            c(i5);
            int[] iArr2 = this.f52035a;
            System.arraycopy(iArr2, i5, iArr2, i3, (iArr2.length - i3) - i4);
            int[] iArr3 = this.f52035a;
            Arrays.fill(iArr3, iArr3.length - i4, iArr3.length, -1);
            m(i3, i4);
        }

        void n(int i3, Span span) {
            c(i3);
            this.f52035a[i3] = span.f52055e;
        }

        int o(int i3) {
            int length = this.f52035a.length;
            while (length <= i3) {
                length *= 2;
            }
            return length;
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        static class FullSpanItem implements Parcelable {
            public static final Parcelable.Creator<FullSpanItem> CREATOR = new Parcelable.Creator<FullSpanItem>() { // from class: androidx.recyclerview.widget.StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem.1
                @Override // android.os.Parcelable.Creator
                /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                public FullSpanItem createFromParcel(Parcel parcel) {
                    return new FullSpanItem(parcel);
                }

                @Override // android.os.Parcelable.Creator
                /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
                public FullSpanItem[] newArray(int i3) {
                    return new FullSpanItem[i3];
                }
            };

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            int f52037a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            int f52038b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            int[] f52039c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            boolean f52040d;

            FullSpanItem(Parcel parcel) {
                this.f52037a = parcel.readInt();
                this.f52038b = parcel.readInt();
                this.f52040d = parcel.readInt() == 1;
                int i3 = parcel.readInt();
                if (i3 > 0) {
                    int[] iArr = new int[i3];
                    this.f52039c = iArr;
                    parcel.readIntArray(iArr);
                }
            }

            int a(int i3) {
                int[] iArr = this.f52039c;
                if (iArr == null) {
                    return 0;
                }
                return iArr[i3];
            }

            @Override // android.os.Parcelable
            public int describeContents() {
                return 0;
            }

            public String toString() {
                return "FullSpanItem{mPosition=" + this.f52037a + ", mGapDir=" + this.f52038b + ", mHasUnwantedGapAfter=" + this.f52040d + ", mGapPerSpan=" + Arrays.toString(this.f52039c) + '}';
            }

            @Override // android.os.Parcelable
            public void writeToParcel(Parcel parcel, int i3) {
                parcel.writeInt(this.f52037a);
                parcel.writeInt(this.f52038b);
                parcel.writeInt(this.f52040d ? 1 : 0);
                int[] iArr = this.f52039c;
                if (iArr == null || iArr.length <= 0) {
                    parcel.writeInt(0);
                } else {
                    parcel.writeInt(iArr.length);
                    parcel.writeIntArray(this.f52039c);
                }
            }

            FullSpanItem() {
            }
        }
    }
}
