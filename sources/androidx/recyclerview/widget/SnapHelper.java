package androidx.recyclerview.widget;

import android.util.DisplayMetrics;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.Scroller;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.gms.common.api.Api;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class SnapHelper extends RecyclerView.OnFlingListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    RecyclerView f52001a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Scroller f52002b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final RecyclerView.OnScrollListener f52003c = new RecyclerView.OnScrollListener() { // from class: androidx.recyclerview.widget.SnapHelper.1

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        boolean f52004a = false;

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void a(RecyclerView recyclerView, int i3) {
            super.a(recyclerView, i3);
            if (i3 == 0 && this.f52004a) {
                this.f52004a = false;
                SnapHelper.this.l();
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void b(RecyclerView recyclerView, int i3, int i4) {
            if (i3 == 0 && i4 == 0) {
                return;
            }
            this.f52004a = true;
        }
    };

    private void g() {
        this.f52001a.l1(this.f52003c);
        this.f52001a.setOnFlingListener(null);
    }

    private void j() {
        if (this.f52001a.getOnFlingListener() != null) {
            throw new IllegalStateException("An instance of OnFlingListener already set.");
        }
        this.f52001a.n(this.f52003c);
        this.f52001a.setOnFlingListener(this);
    }

    private boolean k(RecyclerView.LayoutManager layoutManager, int i3, int i4) {
        RecyclerView.SmoothScroller smoothScrollerE;
        int i5;
        if (!(layoutManager instanceof RecyclerView.SmoothScroller.ScrollVectorProvider) || (smoothScrollerE = e(layoutManager)) == null || (i5 = i(layoutManager, i3, i4)) == -1) {
            return false;
        }
        smoothScrollerE.p(i5);
        layoutManager.O1(smoothScrollerE);
        return true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnFlingListener
    public boolean a(int i3, int i4) {
        RecyclerView.LayoutManager layoutManager = this.f52001a.getLayoutManager();
        if (layoutManager == null || this.f52001a.getAdapter() == null) {
            return false;
        }
        int minFlingVelocity = this.f52001a.getMinFlingVelocity();
        return (Math.abs(i4) > minFlingVelocity || Math.abs(i3) > minFlingVelocity) && k(layoutManager, i3, i4);
    }

    public void b(RecyclerView recyclerView) {
        RecyclerView recyclerView2 = this.f52001a;
        if (recyclerView2 == recyclerView) {
            return;
        }
        if (recyclerView2 != null) {
            g();
        }
        this.f52001a = recyclerView;
        if (recyclerView != null) {
            j();
            this.f52002b = new Scroller(this.f52001a.getContext(), new DecelerateInterpolator());
            l();
        }
    }

    public abstract int[] c(RecyclerView.LayoutManager layoutManager, View view);

    public int[] d(int i3, int i4) {
        this.f52002b.fling(0, 0, i3, i4, Integer.MIN_VALUE, Api.BaseClientBuilder.API_PRIORITY_OTHER, Integer.MIN_VALUE, Api.BaseClientBuilder.API_PRIORITY_OTHER);
        return new int[]{this.f52002b.getFinalX(), this.f52002b.getFinalY()};
    }

    protected RecyclerView.SmoothScroller e(RecyclerView.LayoutManager layoutManager) {
        return f(layoutManager);
    }

    protected LinearSmoothScroller f(RecyclerView.LayoutManager layoutManager) {
        if (layoutManager instanceof RecyclerView.SmoothScroller.ScrollVectorProvider) {
            return new LinearSmoothScroller(this.f52001a.getContext()) { // from class: androidx.recyclerview.widget.SnapHelper.2
                @Override // androidx.recyclerview.widget.LinearSmoothScroller, androidx.recyclerview.widget.RecyclerView.SmoothScroller
                protected void o(View view, RecyclerView.State state, RecyclerView.SmoothScroller.Action action) {
                    SnapHelper snapHelper = SnapHelper.this;
                    RecyclerView recyclerView = snapHelper.f52001a;
                    if (recyclerView == null) {
                        return;
                    }
                    int[] iArrC = snapHelper.c(recyclerView.getLayoutManager(), view);
                    int i3 = iArrC[0];
                    int i4 = iArrC[1];
                    int iW = w(Math.max(Math.abs(i3), Math.abs(i4)));
                    if (iW > 0) {
                        action.d(i3, i4, iW, this.f51785j);
                    }
                }

                @Override // androidx.recyclerview.widget.LinearSmoothScroller
                protected float v(DisplayMetrics displayMetrics) {
                    return 100.0f / displayMetrics.densityDpi;
                }
            };
        }
        return null;
    }

    public abstract View h(RecyclerView.LayoutManager layoutManager);

    public abstract int i(RecyclerView.LayoutManager layoutManager, int i3, int i4);

    void l() {
        RecyclerView.LayoutManager layoutManager;
        View viewH;
        RecyclerView recyclerView = this.f52001a;
        if (recyclerView == null || (layoutManager = recyclerView.getLayoutManager()) == null || (viewH = h(layoutManager)) == null) {
            return;
        }
        int[] iArrC = c(layoutManager, viewH);
        int i3 = iArrC[0];
        if (i3 == 0 && iArrC[1] == 0) {
            return;
        }
        this.f52001a.z1(i3, iArrC[1]);
    }
}
