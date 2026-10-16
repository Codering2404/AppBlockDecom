package androidx.recyclerview.widget;

import android.graphics.PointF;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.gms.common.api.Api;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public class LinearSnapHelper extends SnapHelper {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private OrientationHelper f51792d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private OrientationHelper f51793e;

    private float m(RecyclerView.LayoutManager layoutManager, OrientationHelper orientationHelper) {
        int iP = layoutManager.P();
        if (iP == 0) {
            return 1.0f;
        }
        View view = null;
        int i3 = Integer.MIN_VALUE;
        int i4 = Integer.MAX_VALUE;
        View view2 = null;
        for (int i5 = 0; i5 < iP; i5++) {
            View viewO = layoutManager.O(i5);
            int iM0 = layoutManager.m0(viewO);
            if (iM0 != -1) {
                if (iM0 < i4) {
                    view = viewO;
                    i4 = iM0;
                }
                if (iM0 > i3) {
                    view2 = viewO;
                    i3 = iM0;
                }
            }
        }
        if (view == null || view2 == null) {
            return 1.0f;
        }
        int iMax = Math.max(orientationHelper.d(view), orientationHelper.d(view2)) - Math.min(orientationHelper.g(view), orientationHelper.g(view2));
        if (iMax == 0) {
            return 1.0f;
        }
        return (iMax * 1.0f) / ((i3 - i4) + 1);
    }

    private int n(View view, OrientationHelper orientationHelper) {
        return (orientationHelper.g(view) + (orientationHelper.e(view) / 2)) - (orientationHelper.n() + (orientationHelper.o() / 2));
    }

    private int o(RecyclerView.LayoutManager layoutManager, OrientationHelper orientationHelper, int i3, int i4) {
        int[] iArrD = d(i3, i4);
        float fM = m(layoutManager, orientationHelper);
        if (fM <= 0.0f) {
            return 0;
        }
        return Math.round((Math.abs(iArrD[0]) > Math.abs(iArrD[1]) ? iArrD[0] : iArrD[1]) / fM);
    }

    private View p(RecyclerView.LayoutManager layoutManager, OrientationHelper orientationHelper) {
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

    private OrientationHelper q(RecyclerView.LayoutManager layoutManager) {
        OrientationHelper orientationHelper = this.f51793e;
        if (orientationHelper == null || orientationHelper.f51828a != layoutManager) {
            this.f51793e = OrientationHelper.a(layoutManager);
        }
        return this.f51793e;
    }

    private OrientationHelper r(RecyclerView.LayoutManager layoutManager) {
        OrientationHelper orientationHelper = this.f51792d;
        if (orientationHelper == null || orientationHelper.f51828a != layoutManager) {
            this.f51792d = OrientationHelper.c(layoutManager);
        }
        return this.f51792d;
    }

    @Override // androidx.recyclerview.widget.SnapHelper
    public int[] c(RecyclerView.LayoutManager layoutManager, View view) {
        int[] iArr = new int[2];
        if (layoutManager.q()) {
            iArr[0] = n(view, q(layoutManager));
        } else {
            iArr[0] = 0;
        }
        if (layoutManager.r()) {
            iArr[1] = n(view, r(layoutManager));
            return iArr;
        }
        iArr[1] = 0;
        return iArr;
    }

    @Override // androidx.recyclerview.widget.SnapHelper
    public View h(RecyclerView.LayoutManager layoutManager) {
        if (layoutManager.r()) {
            return p(layoutManager, r(layoutManager));
        }
        if (layoutManager.q()) {
            return p(layoutManager, q(layoutManager));
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.recyclerview.widget.SnapHelper
    public int i(RecyclerView.LayoutManager layoutManager, int i3, int i4) {
        int iA;
        View viewH;
        int iM0;
        int i5;
        PointF pointFE;
        int iO;
        int iO2;
        if (!(layoutManager instanceof RecyclerView.SmoothScroller.ScrollVectorProvider) || (iA = layoutManager.a()) == 0 || (viewH = h(layoutManager)) == null || (iM0 = layoutManager.m0(viewH)) == -1 || (pointFE = ((RecyclerView.SmoothScroller.ScrollVectorProvider) layoutManager).e(iA - 1)) == null) {
            return -1;
        }
        if (layoutManager.q()) {
            iO = o(layoutManager, q(layoutManager), i3, 0);
            if (pointFE.x < 0.0f) {
                iO = -iO;
            }
        } else {
            iO = 0;
        }
        if (layoutManager.r()) {
            iO2 = o(layoutManager, r(layoutManager), 0, i4);
            if (pointFE.y < 0.0f) {
                iO2 = -iO2;
            }
        } else {
            iO2 = 0;
        }
        if (layoutManager.r()) {
            iO = iO2;
        }
        if (iO == 0) {
            return -1;
        }
        int i6 = iM0 + iO;
        int i7 = i6 >= 0 ? i6 : 0;
        return i7 >= iA ? i5 : i7;
    }
}
