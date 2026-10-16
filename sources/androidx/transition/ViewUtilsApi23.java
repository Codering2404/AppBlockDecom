package androidx.transition;

import android.os.Build;
import android.view.View;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
class ViewUtilsApi23 extends ViewUtilsApi22 {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static boolean f53576k = true;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class Api29Impl {
        static void a(View view, int i3) {
            view.setTransitionVisibility(i3);
        }
    }

    ViewUtilsApi23() {
    }

    @Override // androidx.transition.ViewUtilsApi19
    public void h(View view, int i3) {
        if (Build.VERSION.SDK_INT == 28) {
            super.h(view, i3);
        } else if (f53576k) {
            try {
                Api29Impl.a(view, i3);
            } catch (NoSuchMethodError unused) {
                f53576k = false;
            }
        }
    }
}
