package androidx.core.view;

import android.util.Log;
import android.view.View;
import android.view.ViewParent;
import androidx.datastore.preferences.core.SfRj.rnFwbPAQmQTnL;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes2.dex */
public final class ViewParentCompat {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    /* JADX INFO: loaded from: classes3.dex */
    static class Api21Impl {
        static boolean a(ViewParent viewParent, View view, float f3, float f4, boolean z2) {
            return viewParent.onNestedFling(view, f3, f4, z2);
        }

        static boolean b(ViewParent viewParent, View view, float f3, float f4) {
            return viewParent.onNestedPreFling(view, f3, f4);
        }

        static void c(ViewParent viewParent, View view, int i3, int i4, int[] iArr) {
            viewParent.onNestedPreScroll(view, i3, i4, iArr);
        }

        static void d(ViewParent viewParent, View view, int i3, int i4, int i5, int i6) {
            viewParent.onNestedScroll(view, i3, i4, i5, i6);
        }

        static void e(ViewParent viewParent, View view, View view2, int i3) {
            viewParent.onNestedScrollAccepted(view, view2, i3);
        }

        static boolean f(ViewParent viewParent, View view, View view2, int i3) {
            return viewParent.onStartNestedScroll(view, view2, i3);
        }

        static void g(ViewParent viewParent, View view) {
            viewParent.onStopNestedScroll(view);
        }
    }

    public static boolean a(ViewParent viewParent, View view, float f3, float f4, boolean z2) {
        try {
            return Api21Impl.a(viewParent, view, f3, f4, z2);
        } catch (AbstractMethodError e3) {
            Log.e("ViewParentCompat", "ViewParent " + viewParent + " does not implement interface method onNestedFling", e3);
            return false;
        }
    }

    public static boolean b(ViewParent viewParent, View view, float f3, float f4) {
        try {
            return Api21Impl.b(viewParent, view, f3, f4);
        } catch (AbstractMethodError e3) {
            Log.e("ViewParentCompat", "ViewParent " + viewParent + " does not implement interface method onNestedPreFling", e3);
            return false;
        }
    }

    public static void c(ViewParent viewParent, View view, int i3, int i4, int[] iArr, int i5) {
        if (viewParent instanceof NestedScrollingParent2) {
            ((NestedScrollingParent2) viewParent).l(view, i3, i4, iArr, i5);
            return;
        }
        if (i5 == 0) {
            try {
                Api21Impl.c(viewParent, view, i3, i4, iArr);
            } catch (AbstractMethodError e3) {
                Log.e("ViewParentCompat", "ViewParent " + viewParent + " does not implement interface method onNestedPreScroll", e3);
            }
        }
    }

    public static void d(ViewParent viewParent, View view, int i3, int i4, int i5, int i6, int i7, int[] iArr) {
        if (viewParent instanceof NestedScrollingParent3) {
            ((NestedScrollingParent3) viewParent).n(view, i3, i4, i5, i6, i7, iArr);
            return;
        }
        iArr[0] = iArr[0] + i5;
        iArr[1] = iArr[1] + i6;
        if (viewParent instanceof NestedScrollingParent2) {
            ((NestedScrollingParent2) viewParent).o(view, i3, i4, i5, i6, i7);
            return;
        }
        if (i7 == 0) {
            try {
                Api21Impl.d(viewParent, view, i3, i4, i5, i6);
            } catch (AbstractMethodError e3) {
                Log.e("ViewParentCompat", "ViewParent " + viewParent + " does not implement interface method onNestedScroll", e3);
            }
        }
    }

    public static void e(ViewParent viewParent, View view, View view2, int i3, int i4) {
        if (viewParent instanceof NestedScrollingParent2) {
            ((NestedScrollingParent2) viewParent).j(view, view2, i3, i4);
            return;
        }
        if (i4 == 0) {
            try {
                Api21Impl.e(viewParent, view, view2, i3);
            } catch (AbstractMethodError e3) {
                Log.e("ViewParentCompat", "ViewParent " + viewParent + " does not implement interface method onNestedScrollAccepted", e3);
            }
        }
    }

    public static void g(ViewParent viewParent, View view, int i3) {
        if (viewParent instanceof NestedScrollingParent2) {
            ((NestedScrollingParent2) viewParent).k(view, i3);
            return;
        }
        if (i3 == 0) {
            try {
                Api21Impl.g(viewParent, view);
            } catch (AbstractMethodError e3) {
                Log.e("ViewParentCompat", "ViewParent " + viewParent + " does not implement interface method onStopNestedScroll", e3);
            }
        }
    }

    public static boolean f(ViewParent viewParent, View view, View view2, int i3, int i4) {
        if (viewParent instanceof NestedScrollingParent2) {
            return ((NestedScrollingParent2) viewParent).p(view, view2, i3, i4);
        }
        if (i4 != 0) {
            return false;
        }
        try {
            return Api21Impl.f(viewParent, view, view2, i3);
        } catch (AbstractMethodError e3) {
            Log.e("ViewParentCompat", "ViewParent " + viewParent + rnFwbPAQmQTnL.eGAVPqCaSfJnRUx, e3);
            return false;
        }
    }
}
