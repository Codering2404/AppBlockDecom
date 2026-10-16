package androidx.recyclerview.widget;

import android.content.Context;
import android.graphics.PointF;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import androidx.recyclerview.widget.RecyclerView;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public class LinearSmoothScroller extends RecyclerView.SmoothScroller {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    protected PointF f51786k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final DisplayMetrics f51787l;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private float f51789n;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    protected final LinearInterpolator f51784i = new LinearInterpolator();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    protected final DecelerateInterpolator f51785j = new DecelerateInterpolator();

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private boolean f51788m = false;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    protected int f51790o = 0;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    protected int f51791p = 0;

    public LinearSmoothScroller(Context context) {
        this.f51787l = context.getResources().getDisplayMetrics();
    }

    private float A() {
        if (!this.f51788m) {
            this.f51789n = v(this.f51787l);
            this.f51788m = true;
        }
        return this.f51789n;
    }

    private int y(int i3, int i4) {
        int i5 = i3 - i4;
        if (i3 * i5 <= 0) {
            return 0;
        }
        return i5;
    }

    protected int B() {
        PointF pointF = this.f51786k;
        if (pointF == null) {
            return 0;
        }
        float f3 = pointF.y;
        if (f3 == 0.0f) {
            return 0;
        }
        return f3 > 0.0f ? 1 : -1;
    }

    protected void C(RecyclerView.SmoothScroller.Action action) {
        PointF pointFA = a(f());
        if (pointFA == null || (pointFA.x == 0.0f && pointFA.y == 0.0f)) {
            action.b(f());
            r();
            return;
        }
        i(pointFA);
        this.f51786k = pointFA;
        this.f51790o = (int) (pointFA.x * 10000.0f);
        this.f51791p = (int) (pointFA.y * 10000.0f);
        action.d((int) (this.f51790o * 1.2f), (int) (this.f51791p * 1.2f), (int) (x(ColorExtractionConstants.MAX_PIXEL_SAMPLES) * 1.2f), this.f51784i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.SmoothScroller
    protected void l(int i3, int i4, RecyclerView.State state, RecyclerView.SmoothScroller.Action action) {
        if (c() == 0) {
            r();
            return;
        }
        this.f51790o = y(this.f51790o, i3);
        int iY = y(this.f51791p, i4);
        this.f51791p = iY;
        if (this.f51790o == 0 && iY == 0) {
            C(action);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.SmoothScroller
    protected void n() {
        this.f51791p = 0;
        this.f51790o = 0;
        this.f51786k = null;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.SmoothScroller
    protected void o(View view, RecyclerView.State state, RecyclerView.SmoothScroller.Action action) {
        int iT = t(view, z());
        int iU = u(view, B());
        int iW = w((int) Math.sqrt((iT * iT) + (iU * iU)));
        if (iW > 0) {
            action.d(-iT, -iU, iW, this.f51785j);
        }
    }

    public int s(int i3, int i4, int i5, int i6, int i7) {
        if (i7 == -1) {
            return i5 - i3;
        }
        if (i7 != 0) {
            if (i7 == 1) {
                return i6 - i4;
            }
            throw new IllegalArgumentException("snap preference should be one of the constants defined in SmoothScroller, starting with SNAP_");
        }
        int i8 = i5 - i3;
        if (i8 > 0) {
            return i8;
        }
        int i9 = i6 - i4;
        if (i9 < 0) {
            return i9;
        }
        return 0;
    }

    public int t(View view, int i3) {
        RecyclerView.LayoutManager layoutManagerE = e();
        if (layoutManagerE == null || !layoutManagerE.q()) {
            return 0;
        }
        RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
        return s(layoutManagerE.W(view) - ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin, layoutManagerE.Z(view) + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin, layoutManagerE.j0(), layoutManagerE.t0() - layoutManagerE.k0(), i3);
    }

    public int u(View view, int i3) {
        RecyclerView.LayoutManager layoutManagerE = e();
        if (layoutManagerE == null || !layoutManagerE.r()) {
            return 0;
        }
        RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
        return s(layoutManagerE.a0(view) - ((ViewGroup.MarginLayoutParams) layoutParams).topMargin, layoutManagerE.U(view) + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin, layoutManagerE.l0(), layoutManagerE.c0() - layoutManagerE.i0(), i3);
    }

    protected float v(DisplayMetrics displayMetrics) {
        return 25.0f / displayMetrics.densityDpi;
    }

    protected int w(int i3) {
        return (int) Math.ceil(((double) x(i3)) / 0.3356d);
    }

    protected int x(int i3) {
        return (int) Math.ceil(Math.abs(i3) * A());
    }

    protected int z() {
        PointF pointF = this.f51786k;
        if (pointF == null) {
            return 0;
        }
        float f3 = pointF.x;
        if (f3 == 0.0f) {
            return 0;
        }
        return f3 > 0.0f ? 1 : -1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.SmoothScroller
    protected void m() {
    }
}
