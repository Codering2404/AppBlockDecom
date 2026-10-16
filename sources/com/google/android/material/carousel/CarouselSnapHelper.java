package com.google.android.material.carousel;

import android.graphics.PointF;
import android.util.DisplayMetrics;
import android.view.View;
import androidx.recyclerview.widget.LinearSmoothScroller;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SnapHelper;
import com.google.android.gms.common.api.Api;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public class CarouselSnapHelper extends SnapHelper {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final boolean f80359d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private RecyclerView f80360e;

    /* JADX INFO: Access modifiers changed from: private */
    public int[] o(RecyclerView.LayoutManager layoutManager, View view, boolean z2) {
        if (!(layoutManager instanceof CarouselLayoutManager)) {
            return new int[]{0, 0};
        }
        int iP = p(view, (CarouselLayoutManager) layoutManager, z2);
        return layoutManager.q() ? new int[]{iP, 0} : layoutManager.r() ? new int[]{0, iP} : new int[]{0, 0};
    }

    private int p(View view, CarouselLayoutManager carouselLayoutManager, boolean z2) {
        return carouselLayoutManager.v2(carouselLayoutManager.m0(view), z2);
    }

    private View q(RecyclerView.LayoutManager layoutManager) {
        int iP = layoutManager.P();
        View view = null;
        if (iP != 0 && (layoutManager instanceof CarouselLayoutManager)) {
            CarouselLayoutManager carouselLayoutManager = (CarouselLayoutManager) layoutManager;
            int i3 = Api.BaseClientBuilder.API_PRIORITY_OTHER;
            for (int i4 = 0; i4 < iP; i4++) {
                View viewO = layoutManager.O(i4);
                int iAbs = Math.abs(carouselLayoutManager.v2(layoutManager.m0(viewO), false));
                if (iAbs < i3) {
                    view = viewO;
                    i3 = iAbs;
                }
            }
        }
        return view;
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
        return o(layoutManager, view, false);
    }

    @Override // androidx.recyclerview.widget.SnapHelper
    protected RecyclerView.SmoothScroller e(final RecyclerView.LayoutManager layoutManager) {
        if (layoutManager instanceof RecyclerView.SmoothScroller.ScrollVectorProvider) {
            return new LinearSmoothScroller(this.f80360e.getContext()) { // from class: com.google.android.material.carousel.CarouselSnapHelper.1
                @Override // androidx.recyclerview.widget.LinearSmoothScroller, androidx.recyclerview.widget.RecyclerView.SmoothScroller
                protected void o(View view, RecyclerView.State state, RecyclerView.SmoothScroller.Action action) {
                    if (CarouselSnapHelper.this.f80360e != null) {
                        CarouselSnapHelper carouselSnapHelper = CarouselSnapHelper.this;
                        int[] iArrO = carouselSnapHelper.o(carouselSnapHelper.f80360e.getLayoutManager(), view, true);
                        int i3 = iArrO[0];
                        int i4 = iArrO[1];
                        int iW = w(Math.max(Math.abs(i3), Math.abs(i4)));
                        if (iW > 0) {
                            action.d(i3, i4, iW, this.f51785j);
                        }
                    }
                }

                @Override // androidx.recyclerview.widget.LinearSmoothScroller
                protected float v(DisplayMetrics displayMetrics) {
                    float f3;
                    float f4;
                    if (layoutManager.r()) {
                        f3 = displayMetrics.densityDpi;
                        f4 = 50.0f;
                    } else {
                        f3 = displayMetrics.densityDpi;
                        f4 = 100.0f;
                    }
                    return f4 / f3;
                }
            };
        }
        return null;
    }

    @Override // androidx.recyclerview.widget.SnapHelper
    public View h(RecyclerView.LayoutManager layoutManager) {
        return q(layoutManager);
    }

    @Override // androidx.recyclerview.widget.SnapHelper
    public int i(RecyclerView.LayoutManager layoutManager, int i3, int i4) {
        int iA;
        if (!this.f80359d || (iA = layoutManager.a()) == 0) {
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
                int iP2 = p(viewO, (CarouselLayoutManager) layoutManager, false);
                if (iP2 <= 0 && iP2 > i6) {
                    view2 = viewO;
                    i6 = iP2;
                }
                if (iP2 >= 0 && iP2 < i5) {
                    view = viewO;
                    i5 = iP2;
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
