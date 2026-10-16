package androidx.recyclerview.widget;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
class ScrollbarHelper {
    static int a(RecyclerView.State state, OrientationHelper orientationHelper, View view, View view2, RecyclerView.LayoutManager layoutManager, boolean z2) {
        if (layoutManager.P() == 0 || state.b() == 0 || view == null || view2 == null) {
            return 0;
        }
        if (!z2) {
            return Math.abs(layoutManager.m0(view) - layoutManager.m0(view2)) + 1;
        }
        return Math.min(orientationHelper.o(), orientationHelper.d(view2) - orientationHelper.g(view));
    }

    static int b(RecyclerView.State state, OrientationHelper orientationHelper, View view, View view2, RecyclerView.LayoutManager layoutManager, boolean z2, boolean z3) {
        if (layoutManager.P() == 0 || state.b() == 0 || view == null || view2 == null) {
            return 0;
        }
        int iMax = z3 ? Math.max(0, (state.b() - Math.max(layoutManager.m0(view), layoutManager.m0(view2))) - 1) : Math.max(0, Math.min(layoutManager.m0(view), layoutManager.m0(view2)));
        if (z2) {
            return Math.round((iMax * (Math.abs(orientationHelper.d(view2) - orientationHelper.g(view)) / (Math.abs(layoutManager.m0(view) - layoutManager.m0(view2)) + 1))) + (orientationHelper.n() - orientationHelper.g(view)));
        }
        return iMax;
    }

    static int c(RecyclerView.State state, OrientationHelper orientationHelper, View view, View view2, RecyclerView.LayoutManager layoutManager, boolean z2) {
        if (layoutManager.P() == 0 || state.b() == 0 || view == null || view2 == null) {
            return 0;
        }
        if (!z2) {
            return state.b();
        }
        return (int) (((orientationHelper.d(view2) - orientationHelper.g(view)) / (Math.abs(layoutManager.m0(view) - layoutManager.m0(view2)) + 1)) * state.b());
    }
}
