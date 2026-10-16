package androidx.recyclerview.widget;

import android.content.Context;
import android.graphics.PointF;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.gms.common.api.Api;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public class LinearLayoutManager extends RecyclerView.LayoutManager implements ItemTouchHelper.ViewDropHandler, RecyclerView.SmoothScroller.ScrollVectorProvider {
    int A;
    int B;
    private boolean C;
    SavedState D;
    final AnchorInfo E;
    private final LayoutChunkResult F;
    private int G;
    private int[] H;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    int f51751s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private LayoutState f51752t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    OrientationHelper f51753u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private boolean f51754v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private boolean f51755w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    boolean f51756x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private boolean f51757y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private boolean f51758z;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class AnchorInfo {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        OrientationHelper f51759a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f51760b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f51761c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        boolean f51762d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        boolean f51763e;

        AnchorInfo() {
            e();
        }

        void a() {
            this.f51761c = this.f51762d ? this.f51759a.i() : this.f51759a.n();
        }

        public void b(View view, int i3) {
            if (this.f51762d) {
                this.f51761c = this.f51759a.d(view) + this.f51759a.p();
            } else {
                this.f51761c = this.f51759a.g(view);
            }
            this.f51760b = i3;
        }

        public void c(View view, int i3) {
            int iP = this.f51759a.p();
            if (iP >= 0) {
                b(view, i3);
                return;
            }
            this.f51760b = i3;
            if (this.f51762d) {
                int i4 = (this.f51759a.i() - iP) - this.f51759a.d(view);
                this.f51761c = this.f51759a.i() - i4;
                if (i4 > 0) {
                    int iE = this.f51761c - this.f51759a.e(view);
                    int iN = this.f51759a.n();
                    int iMin = iE - (iN + Math.min(this.f51759a.g(view) - iN, 0));
                    if (iMin < 0) {
                        this.f51761c += Math.min(i4, -iMin);
                        return;
                    }
                    return;
                }
                return;
            }
            int iG = this.f51759a.g(view);
            int iN2 = iG - this.f51759a.n();
            this.f51761c = iG;
            if (iN2 > 0) {
                int i5 = (this.f51759a.i() - Math.min(0, (this.f51759a.i() - iP) - this.f51759a.d(view))) - (iG + this.f51759a.e(view));
                if (i5 < 0) {
                    this.f51761c -= Math.min(iN2, -i5);
                }
            }
        }

        boolean d(View view, RecyclerView.State state) {
            RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
            return !layoutParams.c() && layoutParams.a() >= 0 && layoutParams.a() < state.b();
        }

        void e() {
            this.f51760b = -1;
            this.f51761c = Integer.MIN_VALUE;
            this.f51762d = false;
            this.f51763e = false;
        }

        public String toString() {
            return "AnchorInfo{mPosition=" + this.f51760b + ", mCoordinate=" + this.f51761c + ", mLayoutFromEnd=" + this.f51762d + ", mValid=" + this.f51763e + '}';
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    protected static class LayoutChunkResult {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f51764a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f51765b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f51766c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f51767d;

        protected LayoutChunkResult() {
        }

        void a() {
            this.f51764a = 0;
            this.f51765b = false;
            this.f51766c = false;
            this.f51767d = false;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class LayoutState {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f51769b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f51770c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int f51771d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        int f51772e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        int f51773f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        int f51774g;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        int f51778k;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        boolean f51780m;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        boolean f51768a = true;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        int f51775h = 0;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        int f51776i = 0;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        boolean f51777j = false;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        List f51779l = null;

        LayoutState() {
        }

        private View e() {
            int size = this.f51779l.size();
            for (int i3 = 0; i3 < size; i3++) {
                View view = ((RecyclerView.ViewHolder) this.f51779l.get(i3)).itemView;
                RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
                if (!layoutParams.c() && this.f51771d == layoutParams.a()) {
                    b(view);
                    return view;
                }
            }
            return null;
        }

        public void a() {
            b(null);
        }

        public void b(View view) {
            View viewF = f(view);
            if (viewF == null) {
                this.f51771d = -1;
            } else {
                this.f51771d = ((RecyclerView.LayoutParams) viewF.getLayoutParams()).a();
            }
        }

        boolean c(RecyclerView.State state) {
            int i3 = this.f51771d;
            return i3 >= 0 && i3 < state.b();
        }

        View d(RecyclerView.Recycler recycler) {
            if (this.f51779l != null) {
                return e();
            }
            View viewO = recycler.o(this.f51771d);
            this.f51771d += this.f51772e;
            return viewO;
        }

        public View f(View view) {
            int iA;
            int size = this.f51779l.size();
            View view2 = null;
            int i3 = Api.BaseClientBuilder.API_PRIORITY_OTHER;
            for (int i4 = 0; i4 < size; i4++) {
                View view3 = ((RecyclerView.ViewHolder) this.f51779l.get(i4)).itemView;
                RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view3.getLayoutParams();
                if (view3 != view && !layoutParams.c() && (iA = (layoutParams.a() - this.f51771d) * this.f51772e) >= 0 && iA < i3) {
                    if (iA == 0) {
                        return view3;
                    }
                    view2 = view3;
                    i3 = iA;
                }
            }
            return view2;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static class SavedState implements Parcelable {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() { // from class: androidx.recyclerview.widget.LinearLayoutManager.SavedState.1
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
        int f51781a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f51782b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        boolean f51783c;

        public SavedState() {
        }

        boolean c() {
            return this.f51781a >= 0;
        }

        void d() {
            this.f51781a = -1;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i3) {
            parcel.writeInt(this.f51781a);
            parcel.writeInt(this.f51782b);
            parcel.writeInt(this.f51783c ? 1 : 0);
        }

        SavedState(Parcel parcel) {
            this.f51781a = parcel.readInt();
            this.f51782b = parcel.readInt();
            this.f51783c = parcel.readInt() == 1;
        }

        public SavedState(SavedState savedState) {
            this.f51781a = savedState.f51781a;
            this.f51782b = savedState.f51782b;
            this.f51783c = savedState.f51783c;
        }
    }

    public LinearLayoutManager(Context context) {
        this(context, 1, false);
    }

    private void B2() {
        if (this.f51751s == 1 || !r2()) {
            this.f51756x = this.f51755w;
        } else {
            this.f51756x = !this.f51755w;
        }
    }

    private boolean H2(RecyclerView.Recycler recycler, RecyclerView.State state, AnchorInfo anchorInfo) {
        View viewK2;
        boolean z2 = false;
        if (P() == 0) {
            return false;
        }
        View viewB0 = b0();
        if (viewB0 != null && anchorInfo.d(viewB0, state)) {
            anchorInfo.c(viewB0, m0(viewB0));
            return true;
        }
        boolean z3 = this.f51754v;
        boolean z4 = this.f51757y;
        if (z3 != z4 || (viewK2 = k2(recycler, state, anchorInfo.f51762d, z4)) == null) {
            return false;
        }
        anchorInfo.b(viewK2, m0(viewK2));
        if (!state.e() && Q1()) {
            int iG = this.f51753u.g(viewK2);
            int iD = this.f51753u.d(viewK2);
            int iN = this.f51753u.n();
            int i3 = this.f51753u.i();
            boolean z5 = iD <= iN && iG < iN;
            if (iG >= i3 && iD > i3) {
                z2 = true;
            }
            if (z5 || z2) {
                if (anchorInfo.f51762d) {
                    iN = i3;
                }
                anchorInfo.f51761c = iN;
            }
        }
        return true;
    }

    private boolean I2(RecyclerView.State state, AnchorInfo anchorInfo) {
        int i3;
        if (!state.e() && (i3 = this.A) != -1) {
            if (i3 >= 0 && i3 < state.b()) {
                anchorInfo.f51760b = this.A;
                SavedState savedState = this.D;
                if (savedState != null && savedState.c()) {
                    boolean z2 = this.D.f51783c;
                    anchorInfo.f51762d = z2;
                    if (z2) {
                        anchorInfo.f51761c = this.f51753u.i() - this.D.f51782b;
                    } else {
                        anchorInfo.f51761c = this.f51753u.n() + this.D.f51782b;
                    }
                    return true;
                }
                if (this.B != Integer.MIN_VALUE) {
                    boolean z3 = this.f51756x;
                    anchorInfo.f51762d = z3;
                    if (z3) {
                        anchorInfo.f51761c = this.f51753u.i() - this.B;
                    } else {
                        anchorInfo.f51761c = this.f51753u.n() + this.B;
                    }
                    return true;
                }
                View viewI = I(this.A);
                if (viewI == null) {
                    if (P() > 0) {
                        anchorInfo.f51762d = (this.A < m0(O(0))) == this.f51756x;
                    }
                    anchorInfo.a();
                } else {
                    if (this.f51753u.e(viewI) > this.f51753u.o()) {
                        anchorInfo.a();
                        return true;
                    }
                    if (this.f51753u.g(viewI) - this.f51753u.n() < 0) {
                        anchorInfo.f51761c = this.f51753u.n();
                        anchorInfo.f51762d = false;
                        return true;
                    }
                    if (this.f51753u.i() - this.f51753u.d(viewI) < 0) {
                        anchorInfo.f51761c = this.f51753u.i();
                        anchorInfo.f51762d = true;
                        return true;
                    }
                    anchorInfo.f51761c = anchorInfo.f51762d ? this.f51753u.d(viewI) + this.f51753u.p() : this.f51753u.g(viewI);
                }
                return true;
            }
            this.A = -1;
            this.B = Integer.MIN_VALUE;
        }
        return false;
    }

    private void J2(RecyclerView.Recycler recycler, RecyclerView.State state, AnchorInfo anchorInfo) {
        if (I2(state, anchorInfo) || H2(recycler, state, anchorInfo)) {
            return;
        }
        anchorInfo.a();
        anchorInfo.f51760b = this.f51757y ? state.b() - 1 : 0;
    }

    private void K2(int i3, int i4, boolean z2, RecyclerView.State state) {
        int iN;
        this.f51752t.f51780m = A2();
        this.f51752t.f51773f = i3;
        int[] iArr = this.H;
        iArr[0] = 0;
        iArr[1] = 0;
        R1(state, iArr);
        int iMax = Math.max(0, this.H[0]);
        int iMax2 = Math.max(0, this.H[1]);
        boolean z3 = i3 == 1;
        LayoutState layoutState = this.f51752t;
        int i5 = z3 ? iMax2 : iMax;
        layoutState.f51775h = i5;
        if (!z3) {
            iMax = iMax2;
        }
        layoutState.f51776i = iMax;
        if (z3) {
            layoutState.f51775h = i5 + this.f51753u.j();
            View viewN2 = n2();
            LayoutState layoutState2 = this.f51752t;
            layoutState2.f51772e = this.f51756x ? -1 : 1;
            int iM0 = m0(viewN2);
            LayoutState layoutState3 = this.f51752t;
            layoutState2.f51771d = iM0 + layoutState3.f51772e;
            layoutState3.f51769b = this.f51753u.d(viewN2);
            iN = this.f51753u.d(viewN2) - this.f51753u.i();
        } else {
            View viewO2 = o2();
            this.f51752t.f51775h += this.f51753u.n();
            LayoutState layoutState4 = this.f51752t;
            layoutState4.f51772e = this.f51756x ? 1 : -1;
            int iM02 = m0(viewO2);
            LayoutState layoutState5 = this.f51752t;
            layoutState4.f51771d = iM02 + layoutState5.f51772e;
            layoutState5.f51769b = this.f51753u.g(viewO2);
            iN = (-this.f51753u.g(viewO2)) + this.f51753u.n();
        }
        LayoutState layoutState6 = this.f51752t;
        layoutState6.f51770c = i4;
        if (z2) {
            layoutState6.f51770c = i4 - iN;
        }
        layoutState6.f51774g = iN;
    }

    private void L2(int i3, int i4) {
        this.f51752t.f51770c = this.f51753u.i() - i4;
        LayoutState layoutState = this.f51752t;
        layoutState.f51772e = this.f51756x ? -1 : 1;
        layoutState.f51771d = i3;
        layoutState.f51773f = 1;
        layoutState.f51769b = i4;
        layoutState.f51774g = Integer.MIN_VALUE;
    }

    private void M2(AnchorInfo anchorInfo) {
        L2(anchorInfo.f51760b, anchorInfo.f51761c);
    }

    private void N2(int i3, int i4) {
        this.f51752t.f51770c = i4 - this.f51753u.n();
        LayoutState layoutState = this.f51752t;
        layoutState.f51771d = i3;
        layoutState.f51772e = this.f51756x ? 1 : -1;
        layoutState.f51773f = -1;
        layoutState.f51769b = i4;
        layoutState.f51774g = Integer.MIN_VALUE;
    }

    private void O2(AnchorInfo anchorInfo) {
        N2(anchorInfo.f51760b, anchorInfo.f51761c);
    }

    private int T1(RecyclerView.State state) {
        if (P() == 0) {
            return 0;
        }
        Y1();
        return ScrollbarHelper.a(state, this.f51753u, c2(!this.f51758z, true), b2(!this.f51758z, true), this, this.f51758z);
    }

    private int U1(RecyclerView.State state) {
        if (P() == 0) {
            return 0;
        }
        Y1();
        return ScrollbarHelper.b(state, this.f51753u, c2(!this.f51758z, true), b2(!this.f51758z, true), this, this.f51758z, this.f51756x);
    }

    private int V1(RecyclerView.State state) {
        if (P() == 0) {
            return 0;
        }
        Y1();
        return ScrollbarHelper.c(state, this.f51753u, c2(!this.f51758z, true), b2(!this.f51758z, true), this, this.f51758z);
    }

    private View a2() {
        return g2(0, P());
    }

    private View e2() {
        return g2(P() - 1, -1);
    }

    private View i2() {
        return this.f51756x ? a2() : e2();
    }

    private View j2() {
        return this.f51756x ? e2() : a2();
    }

    private int l2(int i3, RecyclerView.Recycler recycler, RecyclerView.State state, boolean z2) {
        int i4;
        int i5 = this.f51753u.i() - i3;
        if (i5 <= 0) {
            return 0;
        }
        int i6 = -C2(-i5, recycler, state);
        int i7 = i3 + i6;
        if (!z2 || (i4 = this.f51753u.i() - i7) <= 0) {
            return i6;
        }
        this.f51753u.s(i4);
        return i4 + i6;
    }

    private int m2(int i3, RecyclerView.Recycler recycler, RecyclerView.State state, boolean z2) {
        int iN;
        int iN2 = i3 - this.f51753u.n();
        if (iN2 <= 0) {
            return 0;
        }
        int i4 = -C2(iN2, recycler, state);
        int i5 = i3 + i4;
        if (!z2 || (iN = i5 - this.f51753u.n()) <= 0) {
            return i4;
        }
        this.f51753u.s(-iN);
        return i4 - iN;
    }

    private View n2() {
        return O(this.f51756x ? 0 : P() - 1);
    }

    private View o2() {
        return O(this.f51756x ? P() - 1 : 0);
    }

    private void u2(RecyclerView.Recycler recycler, RecyclerView.State state, int i3, int i4) {
        if (!state.g() || P() == 0 || state.e() || !Q1()) {
            return;
        }
        List listK = recycler.k();
        int size = listK.size();
        int iM0 = m0(O(0));
        int iE = 0;
        int iE2 = 0;
        for (int i5 = 0; i5 < size; i5++) {
            RecyclerView.ViewHolder viewHolder = (RecyclerView.ViewHolder) listK.get(i5);
            if (!viewHolder.isRemoved()) {
                if ((viewHolder.getLayoutPosition() < iM0) != this.f51756x) {
                    iE += this.f51753u.e(viewHolder.itemView);
                } else {
                    iE2 += this.f51753u.e(viewHolder.itemView);
                }
            }
        }
        this.f51752t.f51779l = listK;
        if (iE > 0) {
            N2(m0(o2()), i3);
            LayoutState layoutState = this.f51752t;
            layoutState.f51775h = iE;
            layoutState.f51770c = 0;
            layoutState.a();
            Z1(recycler, this.f51752t, state, false);
        }
        if (iE2 > 0) {
            L2(m0(n2()), i4);
            LayoutState layoutState2 = this.f51752t;
            layoutState2.f51775h = iE2;
            layoutState2.f51770c = 0;
            layoutState2.a();
            Z1(recycler, this.f51752t, state, false);
        }
        this.f51752t.f51779l = null;
    }

    private void w2(RecyclerView.Recycler recycler, LayoutState layoutState) {
        if (!layoutState.f51768a || layoutState.f51780m) {
            return;
        }
        int i3 = layoutState.f51774g;
        int i4 = layoutState.f51776i;
        if (layoutState.f51773f == -1) {
            y2(recycler, i3, i4);
        } else {
            z2(recycler, i3, i4);
        }
    }

    private void x2(RecyclerView.Recycler recycler, int i3, int i4) {
        if (i3 == i4) {
            return;
        }
        if (i4 <= i3) {
            while (i3 > i4) {
                s1(i3, recycler);
                i3--;
            }
        } else {
            for (int i5 = i4 - 1; i5 >= i3; i5--) {
                s1(i5, recycler);
            }
        }
    }

    private void y2(RecyclerView.Recycler recycler, int i3, int i4) {
        int iP = P();
        if (i3 < 0) {
            return;
        }
        int iH = (this.f51753u.h() - i3) + i4;
        if (this.f51756x) {
            for (int i5 = 0; i5 < iP; i5++) {
                View viewO = O(i5);
                if (this.f51753u.g(viewO) < iH || this.f51753u.r(viewO) < iH) {
                    x2(recycler, 0, i5);
                    return;
                }
            }
            return;
        }
        int i6 = iP - 1;
        for (int i7 = i6; i7 >= 0; i7--) {
            View viewO2 = O(i7);
            if (this.f51753u.g(viewO2) < iH || this.f51753u.r(viewO2) < iH) {
                x2(recycler, i6, i7);
                return;
            }
        }
    }

    private void z2(RecyclerView.Recycler recycler, int i3, int i4) {
        if (i3 < 0) {
            return;
        }
        int i5 = i3 - i4;
        int iP = P();
        if (!this.f51756x) {
            for (int i6 = 0; i6 < iP; i6++) {
                View viewO = O(i6);
                if (this.f51753u.d(viewO) > i5 || this.f51753u.q(viewO) > i5) {
                    x2(recycler, 0, i6);
                    return;
                }
            }
            return;
        }
        int i7 = iP - 1;
        for (int i8 = i7; i8 >= 0; i8--) {
            View viewO2 = O(i8);
            if (this.f51753u.d(viewO2) > i5 || this.f51753u.q(viewO2) > i5) {
                x2(recycler, i7, i8);
                return;
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int A(RecyclerView.State state) {
        return U1(state);
    }

    boolean A2() {
        return this.f51753u.l() == 0 && this.f51753u.h() == 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int B(RecyclerView.State state) {
        return V1(state);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int B1(int i3, RecyclerView.Recycler recycler, RecyclerView.State state) {
        if (this.f51751s == 1) {
            return 0;
        }
        return C2(i3, recycler, state);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void C1(int i3) {
        this.A = i3;
        this.B = Integer.MIN_VALUE;
        SavedState savedState = this.D;
        if (savedState != null) {
            savedState.d();
        }
        y1();
    }

    int C2(int i3, RecyclerView.Recycler recycler, RecyclerView.State state) {
        if (P() == 0 || i3 == 0) {
            return 0;
        }
        Y1();
        this.f51752t.f51768a = true;
        int i4 = i3 > 0 ? 1 : -1;
        int iAbs = Math.abs(i3);
        K2(i4, iAbs, true, state);
        LayoutState layoutState = this.f51752t;
        int iZ1 = layoutState.f51774g + Z1(recycler, layoutState, state, false);
        if (iZ1 < 0) {
            return 0;
        }
        if (iAbs > iZ1) {
            i3 = i4 * iZ1;
        }
        this.f51753u.s(-i3);
        this.f51752t.f51778k = i3;
        return i3;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int D1(int i3, RecyclerView.Recycler recycler, RecyclerView.State state) {
        if (this.f51751s == 0) {
            return 0;
        }
        return C2(i3, recycler, state);
    }

    public void D2(int i3, int i4) {
        this.A = i3;
        this.B = i4;
        SavedState savedState = this.D;
        if (savedState != null) {
            savedState.d();
        }
        y1();
    }

    public void E2(int i3) {
        if (i3 != 0 && i3 != 1) {
            throw new IllegalArgumentException("invalid orientation:" + i3);
        }
        m(null);
        if (i3 != this.f51751s || this.f51753u == null) {
            OrientationHelper orientationHelperB = OrientationHelper.b(this, i3);
            this.f51753u = orientationHelperB;
            this.E.f51759a = orientationHelperB;
            this.f51751s = i3;
            y1();
        }
    }

    public void F2(boolean z2) {
        m(null);
        if (z2 == this.f51755w) {
            return;
        }
        this.f51755w = z2;
        y1();
    }

    public void G2(boolean z2) {
        m(null);
        if (this.f51757y == z2) {
            return;
        }
        this.f51757y = z2;
        y1();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public View I(int i3) {
        int iP = P();
        if (iP == 0) {
            return null;
        }
        int iM0 = i3 - m0(O(0));
        if (iM0 >= 0 && iM0 < iP) {
            View viewO = O(iM0);
            if (m0(viewO) == i3) {
                return viewO;
            }
        }
        return super.I(i3);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public RecyclerView.LayoutParams J() {
        return new RecyclerView.LayoutParams(-2, -2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    boolean L1() {
        return (d0() == 1073741824 || u0() == 1073741824 || !v0()) ? false : true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void N0(RecyclerView recyclerView, RecyclerView.Recycler recycler) {
        super.N0(recyclerView, recycler);
        if (this.C) {
            p1(recycler);
            recycler.c();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void N1(RecyclerView recyclerView, RecyclerView.State state, int i3) {
        LinearSmoothScroller linearSmoothScroller = new LinearSmoothScroller(recyclerView.getContext());
        linearSmoothScroller.p(i3);
        O1(linearSmoothScroller);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public View O0(View view, int i3, RecyclerView.Recycler recycler, RecyclerView.State state) {
        int iW1;
        B2();
        if (P() == 0 || (iW1 = W1(i3)) == Integer.MIN_VALUE) {
            return null;
        }
        Y1();
        K2(iW1, (int) (this.f51753u.o() * 0.33333334f), false, state);
        LayoutState layoutState = this.f51752t;
        layoutState.f51774g = Integer.MIN_VALUE;
        layoutState.f51768a = false;
        Z1(recycler, layoutState, state, true);
        View viewJ2 = iW1 == -1 ? j2() : i2();
        View viewO2 = iW1 == -1 ? o2() : n2();
        if (!viewO2.hasFocusable()) {
            return viewJ2;
        }
        if (viewJ2 == null) {
            return null;
        }
        return viewO2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void P0(AccessibilityEvent accessibilityEvent) {
        super.P0(accessibilityEvent);
        if (P() > 0) {
            accessibilityEvent.setFromIndex(d2());
            accessibilityEvent.setToIndex(f2());
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public boolean Q1() {
        return this.D == null && this.f51754v == this.f51757y;
    }

    protected void R1(RecyclerView.State state, int[] iArr) {
        int i3;
        int iP2 = p2(state);
        if (this.f51752t.f51773f == -1) {
            i3 = 0;
        } else {
            i3 = iP2;
            iP2 = 0;
        }
        iArr[0] = iP2;
        iArr[1] = i3;
    }

    void S1(RecyclerView.State state, LayoutState layoutState, RecyclerView.LayoutManager.LayoutPrefetchRegistry layoutPrefetchRegistry) {
        int i3 = layoutState.f51771d;
        if (i3 < 0 || i3 >= state.b()) {
            return;
        }
        layoutPrefetchRegistry.a(i3, Math.max(0, layoutState.f51774g));
    }

    int W1(int i3) {
        return i3 != 1 ? i3 != 2 ? i3 != 17 ? i3 != 33 ? i3 != 66 ? (i3 == 130 && this.f51751s == 1) ? 1 : Integer.MIN_VALUE : this.f51751s == 0 ? 1 : Integer.MIN_VALUE : this.f51751s == 1 ? -1 : Integer.MIN_VALUE : this.f51751s == 0 ? -1 : Integer.MIN_VALUE : (this.f51751s != 1 && r2()) ? -1 : 1 : (this.f51751s != 1 && r2()) ? 1 : -1;
    }

    LayoutState X1() {
        return new LayoutState();
    }

    void Y1() {
        if (this.f51752t == null) {
            this.f51752t = X1();
        }
    }

    int Z1(RecyclerView.Recycler recycler, LayoutState layoutState, RecyclerView.State state, boolean z2) {
        int i3 = layoutState.f51770c;
        int i4 = layoutState.f51774g;
        if (i4 != Integer.MIN_VALUE) {
            if (i3 < 0) {
                layoutState.f51774g = i4 + i3;
            }
            w2(recycler, layoutState);
        }
        int i5 = layoutState.f51770c + layoutState.f51775h;
        LayoutChunkResult layoutChunkResult = this.F;
        while (true) {
            if ((!layoutState.f51780m && i5 <= 0) || !layoutState.c(state)) {
                break;
            }
            layoutChunkResult.a();
            t2(recycler, state, layoutState, layoutChunkResult);
            if (!layoutChunkResult.f51765b) {
                layoutState.f51769b += layoutChunkResult.f51764a * layoutState.f51773f;
                if (!layoutChunkResult.f51766c || layoutState.f51779l != null || !state.e()) {
                    int i6 = layoutState.f51770c;
                    int i7 = layoutChunkResult.f51764a;
                    layoutState.f51770c = i6 - i7;
                    i5 -= i7;
                }
                int i8 = layoutState.f51774g;
                if (i8 != Integer.MIN_VALUE) {
                    int i9 = i8 + layoutChunkResult.f51764a;
                    layoutState.f51774g = i9;
                    int i10 = layoutState.f51770c;
                    if (i10 < 0) {
                        layoutState.f51774g = i9 + i10;
                    }
                    w2(recycler, layoutState);
                }
                if (z2 && layoutChunkResult.f51767d) {
                    break;
                }
            } else {
                break;
            }
        }
        return i3 - layoutState.f51770c;
    }

    View b2(boolean z2, boolean z3) {
        return this.f51756x ? h2(0, P(), z2, z3) : h2(P() - 1, -1, z2, z3);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void c1(RecyclerView.Recycler recycler, RecyclerView.State state) {
        int i3;
        int i4;
        int i5;
        int i6;
        int iL2;
        int i7;
        View viewI;
        int iG;
        int i8;
        int i9 = -1;
        if (!(this.D == null && this.A == -1) && state.b() == 0) {
            p1(recycler);
            return;
        }
        SavedState savedState = this.D;
        if (savedState != null && savedState.c()) {
            this.A = this.D.f51781a;
        }
        Y1();
        this.f51752t.f51768a = false;
        B2();
        View viewB0 = b0();
        AnchorInfo anchorInfo = this.E;
        if (!anchorInfo.f51763e || this.A != -1 || this.D != null) {
            anchorInfo.e();
            AnchorInfo anchorInfo2 = this.E;
            anchorInfo2.f51762d = this.f51756x ^ this.f51757y;
            J2(recycler, state, anchorInfo2);
            this.E.f51763e = true;
        } else if (viewB0 != null && (this.f51753u.g(viewB0) >= this.f51753u.i() || this.f51753u.d(viewB0) <= this.f51753u.n())) {
            this.E.c(viewB0, m0(viewB0));
        }
        LayoutState layoutState = this.f51752t;
        layoutState.f51773f = layoutState.f51778k >= 0 ? 1 : -1;
        int[] iArr = this.H;
        iArr[0] = 0;
        iArr[1] = 0;
        R1(state, iArr);
        int iMax = Math.max(0, this.H[0]) + this.f51753u.n();
        int iMax2 = Math.max(0, this.H[1]) + this.f51753u.j();
        if (state.e() && (i7 = this.A) != -1 && this.B != Integer.MIN_VALUE && (viewI = I(i7)) != null) {
            if (this.f51756x) {
                i8 = this.f51753u.i() - this.f51753u.d(viewI);
                iG = this.B;
            } else {
                iG = this.f51753u.g(viewI) - this.f51753u.n();
                i8 = this.B;
            }
            int i10 = i8 - iG;
            if (i10 > 0) {
                iMax += i10;
            } else {
                iMax2 -= i10;
            }
        }
        AnchorInfo anchorInfo3 = this.E;
        if (!anchorInfo3.f51762d ? !this.f51756x : this.f51756x) {
            i9 = 1;
        }
        v2(recycler, state, anchorInfo3, i9);
        C(recycler);
        this.f51752t.f51780m = A2();
        this.f51752t.f51777j = state.e();
        this.f51752t.f51776i = 0;
        AnchorInfo anchorInfo4 = this.E;
        if (anchorInfo4.f51762d) {
            O2(anchorInfo4);
            LayoutState layoutState2 = this.f51752t;
            layoutState2.f51775h = iMax;
            Z1(recycler, layoutState2, state, false);
            LayoutState layoutState3 = this.f51752t;
            i4 = layoutState3.f51769b;
            int i11 = layoutState3.f51771d;
            int i12 = layoutState3.f51770c;
            if (i12 > 0) {
                iMax2 += i12;
            }
            M2(this.E);
            LayoutState layoutState4 = this.f51752t;
            layoutState4.f51775h = iMax2;
            layoutState4.f51771d += layoutState4.f51772e;
            Z1(recycler, layoutState4, state, false);
            LayoutState layoutState5 = this.f51752t;
            i3 = layoutState5.f51769b;
            int i13 = layoutState5.f51770c;
            if (i13 > 0) {
                N2(i11, i4);
                LayoutState layoutState6 = this.f51752t;
                layoutState6.f51775h = i13;
                Z1(recycler, layoutState6, state, false);
                i4 = this.f51752t.f51769b;
            }
        } else {
            M2(anchorInfo4);
            LayoutState layoutState7 = this.f51752t;
            layoutState7.f51775h = iMax2;
            Z1(recycler, layoutState7, state, false);
            LayoutState layoutState8 = this.f51752t;
            i3 = layoutState8.f51769b;
            int i14 = layoutState8.f51771d;
            int i15 = layoutState8.f51770c;
            if (i15 > 0) {
                iMax += i15;
            }
            O2(this.E);
            LayoutState layoutState9 = this.f51752t;
            layoutState9.f51775h = iMax;
            layoutState9.f51771d += layoutState9.f51772e;
            Z1(recycler, layoutState9, state, false);
            LayoutState layoutState10 = this.f51752t;
            i4 = layoutState10.f51769b;
            int i16 = layoutState10.f51770c;
            if (i16 > 0) {
                L2(i14, i3);
                LayoutState layoutState11 = this.f51752t;
                layoutState11.f51775h = i16;
                Z1(recycler, layoutState11, state, false);
                i3 = this.f51752t.f51769b;
            }
        }
        if (P() > 0) {
            if (this.f51756x ^ this.f51757y) {
                int iL22 = l2(i3, recycler, state, true);
                i5 = i4 + iL22;
                i6 = i3 + iL22;
                iL2 = m2(i5, recycler, state, false);
            } else {
                int iM2 = m2(i4, recycler, state, true);
                i5 = i4 + iM2;
                i6 = i3 + iM2;
                iL2 = l2(i6, recycler, state, false);
            }
            i4 = i5 + iL2;
            i3 = i6 + iL2;
        }
        u2(recycler, state, i4, i3);
        if (state.e()) {
            this.E.e();
        } else {
            this.f51753u.t();
        }
        this.f51754v = this.f51757y;
    }

    View c2(boolean z2, boolean z3) {
        return this.f51756x ? h2(P() - 1, -1, z2, z3) : h2(0, P(), z2, z3);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void d1(RecyclerView.State state) {
        super.d1(state);
        this.D = null;
        this.A = -1;
        this.B = Integer.MIN_VALUE;
        this.E.e();
    }

    public int d2() {
        View viewH2 = h2(0, P(), false, true);
        if (viewH2 == null) {
            return -1;
        }
        return m0(viewH2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.SmoothScroller.ScrollVectorProvider
    public PointF e(int i3) {
        if (P() == 0) {
            return null;
        }
        int i4 = (i3 < m0(O(0))) != this.f51756x ? -1 : 1;
        return this.f51751s == 0 ? new PointF(i4, 0.0f) : new PointF(0.0f, i4);
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.ViewDropHandler
    public void f(View view, View view2, int i3, int i4) {
        m("Cannot drop a view during a scroll or layout calculation");
        Y1();
        B2();
        int iM0 = m0(view);
        int iM02 = m0(view2);
        byte b3 = iM0 < iM02 ? (byte) 1 : (byte) -1;
        if (this.f51756x) {
            if (b3 == 1) {
                D2(iM02, this.f51753u.i() - (this.f51753u.g(view2) + this.f51753u.e(view)));
                return;
            } else {
                D2(iM02, this.f51753u.i() - this.f51753u.d(view2));
                return;
            }
        }
        if (b3 == -1) {
            D2(iM02, this.f51753u.g(view2));
        } else {
            D2(iM02, this.f51753u.d(view2) - this.f51753u.e(view));
        }
    }

    public int f2() {
        View viewH2 = h2(P() - 1, -1, false, true);
        if (viewH2 == null) {
            return -1;
        }
        return m0(viewH2);
    }

    View g2(int i3, int i4) {
        int i5;
        int i6;
        Y1();
        if (i4 <= i3 && i4 >= i3) {
            return O(i3);
        }
        if (this.f51753u.g(O(i3)) < this.f51753u.n()) {
            i5 = 16644;
            i6 = 16388;
        } else {
            i5 = 4161;
            i6 = 4097;
        }
        return this.f51751s == 0 ? this.f51915e.a(i3, i4, i5, i6) : this.f51916f.a(i3, i4, i5, i6);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void h1(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            SavedState savedState = (SavedState) parcelable;
            this.D = savedState;
            if (this.A != -1) {
                savedState.d();
            }
            y1();
        }
    }

    View h2(int i3, int i4, boolean z2, boolean z3) {
        Y1();
        int i5 = z2 ? 24579 : 320;
        int i6 = z3 ? 320 : 0;
        return this.f51751s == 0 ? this.f51915e.a(i3, i4, i5, i6) : this.f51916f.a(i3, i4, i5, i6);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public Parcelable i1() {
        if (this.D != null) {
            return new SavedState(this.D);
        }
        SavedState savedState = new SavedState();
        if (P() <= 0) {
            savedState.d();
            return savedState;
        }
        Y1();
        boolean z2 = this.f51754v ^ this.f51756x;
        savedState.f51783c = z2;
        if (z2) {
            View viewN2 = n2();
            savedState.f51782b = this.f51753u.i() - this.f51753u.d(viewN2);
            savedState.f51781a = m0(viewN2);
            return savedState;
        }
        View viewO2 = o2();
        savedState.f51781a = m0(viewO2);
        savedState.f51782b = this.f51753u.g(viewO2) - this.f51753u.n();
        return savedState;
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0077  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    android.view.View k2(androidx.recyclerview.widget.RecyclerView.Recycler r17, androidx.recyclerview.widget.RecyclerView.State r18, boolean r19, boolean r20) {
        /*
            r16 = this;
            r0 = r16
            r0.Y1()
            int r1 = r0.P()
            r2 = 0
            r3 = 1
            if (r20 == 0) goto L15
            int r1 = r0.P()
            int r1 = r1 - r3
            r4 = -1
            r5 = r4
            goto L18
        L15:
            r4 = r1
            r1 = r2
            r5 = r3
        L18:
            int r6 = r18.b()
            androidx.recyclerview.widget.OrientationHelper r7 = r0.f51753u
            int r7 = r7.n()
            androidx.recyclerview.widget.OrientationHelper r8 = r0.f51753u
            int r8 = r8.i()
            r9 = 0
            r10 = r9
            r11 = r10
        L2b:
            if (r1 == r4) goto L7a
            android.view.View r12 = r0.O(r1)
            int r13 = r0.m0(r12)
            androidx.recyclerview.widget.OrientationHelper r14 = r0.f51753u
            int r14 = r14.g(r12)
            androidx.recyclerview.widget.OrientationHelper r15 = r0.f51753u
            int r15 = r15.d(r12)
            if (r13 < 0) goto L78
            if (r13 >= r6) goto L78
            android.view.ViewGroup$LayoutParams r13 = r12.getLayoutParams()
            androidx.recyclerview.widget.RecyclerView$LayoutParams r13 = (androidx.recyclerview.widget.RecyclerView.LayoutParams) r13
            boolean r13 = r13.c()
            if (r13 == 0) goto L55
            if (r11 != 0) goto L78
            r11 = r12
            goto L78
        L55:
            if (r15 > r7) goto L5b
            if (r14 >= r7) goto L5b
            r13 = r3
            goto L5c
        L5b:
            r13 = r2
        L5c:
            if (r14 < r8) goto L62
            if (r15 <= r8) goto L62
            r14 = r3
            goto L63
        L62:
            r14 = r2
        L63:
            if (r13 != 0) goto L69
            if (r14 == 0) goto L68
            goto L69
        L68:
            return r12
        L69:
            if (r19 == 0) goto L71
            if (r14 == 0) goto L6e
            goto L73
        L6e:
            if (r9 != 0) goto L78
            goto L77
        L71:
            if (r13 == 0) goto L75
        L73:
            r10 = r12
            goto L78
        L75:
            if (r9 != 0) goto L78
        L77:
            r9 = r12
        L78:
            int r1 = r1 + r5
            goto L2b
        L7a:
            if (r9 == 0) goto L7d
            return r9
        L7d:
            if (r10 == 0) goto L80
            return r10
        L80:
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.LinearLayoutManager.k2(androidx.recyclerview.widget.RecyclerView$Recycler, androidx.recyclerview.widget.RecyclerView$State, boolean, boolean):android.view.View");
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void m(String str) {
        if (this.D == null) {
            super.m(str);
        }
    }

    protected int p2(RecyclerView.State state) {
        if (state.d()) {
            return this.f51753u.o();
        }
        return 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public boolean q() {
        return this.f51751s == 0;
    }

    public int q2() {
        return this.f51751s;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public boolean r() {
        return this.f51751s == 1;
    }

    protected boolean r2() {
        return e0() == 1;
    }

    public boolean s2() {
        return this.f51758z;
    }

    void t2(RecyclerView.Recycler recycler, RecyclerView.State state, LayoutState layoutState, LayoutChunkResult layoutChunkResult) {
        int i3;
        int i4;
        int i5;
        int i6;
        int iJ0;
        int iF;
        int i7;
        int i8;
        View viewD = layoutState.d(recycler);
        if (viewD == null) {
            layoutChunkResult.f51765b = true;
            return;
        }
        RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) viewD.getLayoutParams();
        if (layoutState.f51779l == null) {
            if (this.f51756x == (layoutState.f51773f == -1)) {
                j(viewD);
            } else {
                k(viewD, 0);
            }
        } else {
            if (this.f51756x == (layoutState.f51773f == -1)) {
                h(viewD);
            } else {
                i(viewD, 0);
            }
        }
        F0(viewD, 0, 0);
        layoutChunkResult.f51764a = this.f51753u.e(viewD);
        if (this.f51751s == 1) {
            if (r2()) {
                iF = t0() - k0();
                iJ0 = iF - this.f51753u.f(viewD);
            } else {
                iJ0 = j0();
                iF = this.f51753u.f(viewD) + iJ0;
            }
            if (layoutState.f51773f == -1) {
                i8 = layoutState.f51769b;
                i7 = i8 - layoutChunkResult.f51764a;
            } else {
                i7 = layoutState.f51769b;
                i8 = layoutChunkResult.f51764a + i7;
            }
            int i9 = iJ0;
            i6 = i7;
            i5 = i9;
            i4 = i8;
            i3 = iF;
        } else {
            int iL0 = l0();
            int iF2 = this.f51753u.f(viewD) + iL0;
            if (layoutState.f51773f == -1) {
                int i10 = layoutState.f51769b;
                i5 = i10 - layoutChunkResult.f51764a;
                i3 = i10;
                i4 = iF2;
            } else {
                int i11 = layoutState.f51769b;
                i3 = layoutChunkResult.f51764a + i11;
                i4 = iF2;
                i5 = i11;
            }
            i6 = iL0;
        }
        E0(viewD, i5, i6, i3, i4);
        if (layoutParams.c() || layoutParams.b()) {
            layoutChunkResult.f51766c = true;
        }
        layoutChunkResult.f51767d = viewD.hasFocusable();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void u(int i3, int i4, RecyclerView.State state, RecyclerView.LayoutManager.LayoutPrefetchRegistry layoutPrefetchRegistry) {
        if (this.f51751s != 0) {
            i3 = i4;
        }
        if (P() == 0 || i3 == 0) {
            return;
        }
        Y1();
        K2(i3 > 0 ? 1 : -1, Math.abs(i3), true, state);
        S1(state, this.f51752t, layoutPrefetchRegistry);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void v(int i3, RecyclerView.LayoutManager.LayoutPrefetchRegistry layoutPrefetchRegistry) {
        boolean z2;
        int i4;
        SavedState savedState = this.D;
        if (savedState == null || !savedState.c()) {
            B2();
            z2 = this.f51756x;
            i4 = this.A;
            if (i4 == -1) {
                i4 = z2 ? i3 - 1 : 0;
            }
        } else {
            SavedState savedState2 = this.D;
            z2 = savedState2.f51783c;
            i4 = savedState2.f51781a;
        }
        int i5 = z2 ? -1 : 1;
        for (int i6 = 0; i6 < this.G && i4 >= 0 && i4 < i3; i6++) {
            layoutPrefetchRegistry.a(i4, 0);
            i4 += i5;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int w(RecyclerView.State state) {
        return T1(state);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int x(RecyclerView.State state) {
        return U1(state);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public boolean x0() {
        return true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int y(RecyclerView.State state) {
        return V1(state);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int z(RecyclerView.State state) {
        return T1(state);
    }

    public LinearLayoutManager(Context context, int i3, boolean z2) {
        this.f51751s = 1;
        this.f51755w = false;
        this.f51756x = false;
        this.f51757y = false;
        this.f51758z = true;
        this.A = -1;
        this.B = Integer.MIN_VALUE;
        this.D = null;
        this.E = new AnchorInfo();
        this.F = new LayoutChunkResult();
        this.G = 2;
        this.H = new int[2];
        E2(i3);
        F2(z2);
    }

    public LinearLayoutManager(Context context, AttributeSet attributeSet, int i3, int i4) {
        this.f51751s = 1;
        this.f51755w = false;
        this.f51756x = false;
        this.f51757y = false;
        this.f51758z = true;
        this.A = -1;
        this.B = Integer.MIN_VALUE;
        this.D = null;
        this.E = new AnchorInfo();
        this.F = new LayoutChunkResult();
        this.G = 2;
        this.H = new int[2];
        RecyclerView.LayoutManager.Properties propertiesN0 = RecyclerView.LayoutManager.n0(context, attributeSet, i3, i4);
        E2(propertiesN0.f51931a);
        F2(propertiesN0.f51933c);
        G2(propertiesN0.f51934d);
    }

    void v2(RecyclerView.Recycler recycler, RecyclerView.State state, AnchorInfo anchorInfo, int i3) {
    }
}
