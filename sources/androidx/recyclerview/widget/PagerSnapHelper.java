package androidx.recyclerview.widget;

import android.graphics.PointF;
import android.util.DisplayMetrics;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.gms.common.api.Api;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public class PagerSnapHelper extends SnapHelper {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private OrientationHelper f51831d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private OrientationHelper f51832e;

    private int m(View view, OrientationHelper orientationHelper) {
        return (orientationHelper.g(view) + (orientationHelper.e(view) / 2)) - (orientationHelper.n() + (orientationHelper.o() / 2));
    }

    private View n(RecyclerView.LayoutManager layoutManager, OrientationHelper orientationHelper) {
        int iP = layoutManager.P();
        View view = null;
        if (iP == 0) {
            return null;
        }
        int iN = orientationHelper.n() + (orientationHelper.o() / 2);
        int i3 = Api.BaseClientBuilder.API_PRIORITY_OTHER;
        for (int i4 = 0; i4 < iP; i4++) {
            View viewO = layoutManager.O(i4);
            int iAbs = Math.abs((orientationHelper.g(viewO) + (orientationHelper.e(viewO) / 2)) - iN);
            if (iAbs < i3) {
                view = viewO;
                i3 = iAbs;
            }
        }
        return view;
    }

    private OrientationHelper o(RecyclerView.LayoutManager layoutManager) {
        OrientationHelper orientationHelper = this.f51832e;
        if (orientationHelper == null || orientationHelper.f51828a != layoutManager) {
            this.f51832e = OrientationHelper.a(layoutManager);
        }
        return this.f51832e;
    }

    private OrientationHelper p(RecyclerView.LayoutManager layoutManager) {
        if (layoutManager.r()) {
            return q(layoutManager);
        }
        if (layoutManager.q()) {
            return o(layoutManager);
        }
        return null;
    }

    private OrientationHelper q(RecyclerView.LayoutManager layoutManager) {
        OrientationHelper orientationHelper = this.f51831d;
        if (orientationHelper == null || orientationHelper.f51828a != layoutManager) {
            this.f51831d = OrientationHelper.c(layoutManager);
        }
        return this.f51831d;
    }

    private boolean r(RecyclerView.LayoutManager layoutManager, int i3, int i4) {
        return layoutManager.q() ? i3 > 0 : i4 > 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private boolean s(RecyclerView.LayoutManager layoutManager) {
        PointF pointFE;
        int iA = layoutManager.a();
        if (!(layoutManager instanceof RecyclerView.SmoothScroller.ScrollVectorProvider) || (pointFE = ((RecyclerView.SmoothScroller.ScrollVectorProvider) layoutManager).e(iA - 1)) == null) {
            return false;
        }
        return pointFE.x < 0.0f || pointFE.y < 0.0f;
    }

    @Override // androidx.recyclerview.widget.SnapHelper
    public int[] c(RecyclerView.LayoutManager layoutManager, View view) {
        int[] iArr = new int[2];
        if (layoutManager.q()) {
            iArr[0] = m(view, o(layoutManager));
        } else {
            iArr[0] = 0;
        }
        if (layoutManager.r()) {
            iArr[1] = m(view, q(layoutManager));
            return iArr;
        }
        iArr[1] = 0;
        return iArr;
    }

    @Override // androidx.recyclerview.widget.SnapHelper
    protected RecyclerView.SmoothScroller e(RecyclerView.LayoutManager layoutManager) {
        if (layoutManager instanceof RecyclerView.SmoothScroller.ScrollVectorProvider) {
            return new LinearSmoothScroller(this.f52001a.getContext()) { // from class: androidx.recyclerview.widget.PagerSnapHelper.1
                @Override // androidx.recyclerview.widget.LinearSmoothScroller, androidx.recyclerview.widget.RecyclerView.SmoothScroller
                protected void o(View view, RecyclerView.State state, RecyclerView.SmoothScroller.Action action) {
                    PagerSnapHelper pagerSnapHelper = PagerSnapHelper.this;
                    int[] iArrC = pagerSnapHelper.c(pagerSnapHelper.f52001a.getLayoutManager(), view);
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

                @Override // androidx.recyclerview.widget.LinearSmoothScroller
                protected int x(int i3) {
                    return Math.min(100, super.x(i3));
                }
            };
        }
        return null;
    }

    @Override // androidx.recyclerview.widget.SnapHelper
    public View h(RecyclerView.LayoutManager layoutManager) {
        if (layoutManager.r()) {
            return n(layoutManager, q(layoutManager));
        }
        if (layoutManager.q()) {
            return n(layoutManager, o(layoutManager));
        }
        return null;
    }

    @Override // androidx.recyclerview.widget.SnapHelper
    public int i(RecyclerView.LayoutManager layoutManager, int i3, int i4) {
        OrientationHelper orientationHelperP;
        int iA = layoutManager.a();
        if (iA == 0 || (orientationHelperP = p(layoutManager)) == null) {
            return -1;
        }
        int iP = layoutManager.P();
        View view = null;
        int i5 = Integer.MAX_VALUE;
        int i6 = Integer.MIN_VALUE;
        View view2 = null;
        for (int i7 = 0; i7 < iP; i7++) {
            View viewO = layoutManager.O(i7);
            if (viewO != null) {
                int iM = m(viewO, orientationHelperP);
                if (iM <= 0 && iM > i6) {
                    view2 = viewO;
                    i6 = iM;
                }
                if (iM >= 0 && iM < i5) {
                    view = viewO;
                    i5 = iM;
                }
            }
        }
        boolean zR = r(layoutManager, i3, i4);
        if (zR && view != null) {
            return layoutManager.m0(view);
        }
        if (!zR && view2 != null) {
            return layoutManager.m0(view2);
        }
        if (zR) {
            view = view2;
        }
        if (view == null) {
            return -1;
        }
        int iM0 = layoutManager.m0(view) + (s(layoutManager) == zR ? -1 : 1);
        if (iM0 < 0 || iM0 >= iA) {
            return -1;
        }
        return iM0;
    }
}
