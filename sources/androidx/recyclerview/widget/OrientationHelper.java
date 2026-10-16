package androidx.recyclerview.widget;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class OrientationHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected final RecyclerView.LayoutManager f51828a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f51829b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final Rect f51830c;

    public static OrientationHelper a(RecyclerView.LayoutManager layoutManager) {
        return new OrientationHelper(layoutManager) { // from class: androidx.recyclerview.widget.OrientationHelper.1
            @Override // androidx.recyclerview.widget.OrientationHelper
            public int d(View view) {
                return this.f51828a.Z(view) + ((ViewGroup.MarginLayoutParams) ((RecyclerView.LayoutParams) view.getLayoutParams())).rightMargin;
            }

            @Override // androidx.recyclerview.widget.OrientationHelper
            public int e(View view) {
                RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
                return this.f51828a.Y(view) + ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin;
            }

            @Override // androidx.recyclerview.widget.OrientationHelper
            public int f(View view) {
                RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
                return this.f51828a.X(view) + ((ViewGroup.MarginLayoutParams) layoutParams).topMargin + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin;
            }

            @Override // androidx.recyclerview.widget.OrientationHelper
            public int g(View view) {
                return this.f51828a.W(view) - ((ViewGroup.MarginLayoutParams) ((RecyclerView.LayoutParams) view.getLayoutParams())).leftMargin;
            }

            @Override // androidx.recyclerview.widget.OrientationHelper
            public int h() {
                return this.f51828a.t0();
            }

            @Override // androidx.recyclerview.widget.OrientationHelper
            public int i() {
                return this.f51828a.t0() - this.f51828a.k0();
            }

            @Override // androidx.recyclerview.widget.OrientationHelper
            public int j() {
                return this.f51828a.k0();
            }

            @Override // androidx.recyclerview.widget.OrientationHelper
            public int l() {
                return this.f51828a.u0();
            }

            @Override // androidx.recyclerview.widget.OrientationHelper
            public int m() {
                return this.f51828a.d0();
            }

            @Override // androidx.recyclerview.widget.OrientationHelper
            public int n() {
                return this.f51828a.j0();
            }

            @Override // androidx.recyclerview.widget.OrientationHelper
            public int o() {
                return (this.f51828a.t0() - this.f51828a.j0()) - this.f51828a.k0();
            }

            @Override // androidx.recyclerview.widget.OrientationHelper
            public int q(View view) {
                this.f51828a.s0(view, true, this.f51830c);
                return this.f51830c.right;
            }

            @Override // androidx.recyclerview.widget.OrientationHelper
            public int r(View view) {
                this.f51828a.s0(view, true, this.f51830c);
                return this.f51830c.left;
            }

            @Override // androidx.recyclerview.widget.OrientationHelper
            public void s(int i3) {
                this.f51828a.H0(i3);
            }
        };
    }

    public static OrientationHelper b(RecyclerView.LayoutManager layoutManager, int i3) {
        if (i3 == 0) {
            return a(layoutManager);
        }
        if (i3 == 1) {
            return c(layoutManager);
        }
        throw new IllegalArgumentException("invalid orientation");
    }

    public static OrientationHelper c(RecyclerView.LayoutManager layoutManager) {
        return new OrientationHelper(layoutManager) { // from class: androidx.recyclerview.widget.OrientationHelper.2
            @Override // androidx.recyclerview.widget.OrientationHelper
            public int d(View view) {
                return this.f51828a.U(view) + ((ViewGroup.MarginLayoutParams) ((RecyclerView.LayoutParams) view.getLayoutParams())).bottomMargin;
            }

            @Override // androidx.recyclerview.widget.OrientationHelper
            public int e(View view) {
                RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
                return this.f51828a.X(view) + ((ViewGroup.MarginLayoutParams) layoutParams).topMargin + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin;
            }

            @Override // androidx.recyclerview.widget.OrientationHelper
            public int f(View view) {
                RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
                return this.f51828a.Y(view) + ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin;
            }

            @Override // androidx.recyclerview.widget.OrientationHelper
            public int g(View view) {
                return this.f51828a.a0(view) - ((ViewGroup.MarginLayoutParams) ((RecyclerView.LayoutParams) view.getLayoutParams())).topMargin;
            }

            @Override // androidx.recyclerview.widget.OrientationHelper
            public int h() {
                return this.f51828a.c0();
            }

            @Override // androidx.recyclerview.widget.OrientationHelper
            public int i() {
                return this.f51828a.c0() - this.f51828a.i0();
            }

            @Override // androidx.recyclerview.widget.OrientationHelper
            public int j() {
                return this.f51828a.i0();
            }

            @Override // androidx.recyclerview.widget.OrientationHelper
            public int l() {
                return this.f51828a.d0();
            }

            @Override // androidx.recyclerview.widget.OrientationHelper
            public int m() {
                return this.f51828a.u0();
            }

            @Override // androidx.recyclerview.widget.OrientationHelper
            public int n() {
                return this.f51828a.l0();
            }

            @Override // androidx.recyclerview.widget.OrientationHelper
            public int o() {
                return (this.f51828a.c0() - this.f51828a.l0()) - this.f51828a.i0();
            }

            @Override // androidx.recyclerview.widget.OrientationHelper
            public int q(View view) {
                this.f51828a.s0(view, true, this.f51830c);
                return this.f51830c.bottom;
            }

            @Override // androidx.recyclerview.widget.OrientationHelper
            public int r(View view) {
                this.f51828a.s0(view, true, this.f51830c);
                return this.f51830c.top;
            }

            @Override // androidx.recyclerview.widget.OrientationHelper
            public void s(int i3) {
                this.f51828a.I0(i3);
            }
        };
    }

    public abstract int d(View view);

    public abstract int e(View view);

    public abstract int f(View view);

    public abstract int g(View view);

    public abstract int h();

    public abstract int i();

    public abstract int j();

    public RecyclerView.LayoutManager k() {
        return this.f51828a;
    }

    public abstract int l();

    public abstract int m();

    public abstract int n();

    public abstract int o();

    public int p() {
        if (Integer.MIN_VALUE == this.f51829b) {
            return 0;
        }
        return o() - this.f51829b;
    }

    public abstract int q(View view);

    public abstract int r(View view);

    public abstract void s(int i3);

    public void t() {
        this.f51829b = o();
    }

    private OrientationHelper(RecyclerView.LayoutManager layoutManager) {
        this.f51829b = Integer.MIN_VALUE;
        this.f51830c = new Rect();
        this.f51828a = layoutManager;
    }
}
