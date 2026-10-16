package androidx.transition;

import android.view.View;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
class ViewUtilsApi22 extends ViewUtilsApi21 {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static boolean f53575j = true;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class Api29Impl {
        static void a(View view, int i3, int i4, int i5, int i6) {
            view.setLeftTopRightBottom(i3, i4, i5, i6);
        }
    }

    ViewUtilsApi22() {
    }

    @Override // androidx.transition.ViewUtilsApi19
    public void f(View view, int i3, int i4, int i5, int i6) {
        if (f53575j) {
            try {
                Api29Impl.a(view, i3, i4, i5, i6);
            } catch (NoSuchMethodError unused) {
                f53575j = false;
            }
        }
    }
}
