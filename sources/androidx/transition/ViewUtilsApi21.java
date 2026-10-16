package androidx.transition;

import android.graphics.Matrix;
import android.view.View;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
class ViewUtilsApi21 extends ViewUtilsApi19 {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static boolean f53572g = true;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static boolean f53573h = true;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static boolean f53574i = true;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class Api29Impl {
        static void a(View view, Matrix matrix) {
            view.setAnimationMatrix(matrix);
        }

        static void b(View view, Matrix matrix) {
            view.transformMatrixToGlobal(matrix);
        }

        static void c(View view, Matrix matrix) {
            view.transformMatrixToLocal(matrix);
        }
    }

    ViewUtilsApi21() {
    }

    @Override // androidx.transition.ViewUtilsApi19
    public void e(View view, Matrix matrix) {
        if (f53572g) {
            try {
                Api29Impl.a(view, matrix);
            } catch (NoSuchMethodError unused) {
                f53572g = false;
            }
        }
    }

    @Override // androidx.transition.ViewUtilsApi19
    public void i(View view, Matrix matrix) {
        if (f53573h) {
            try {
                Api29Impl.b(view, matrix);
            } catch (NoSuchMethodError unused) {
                f53573h = false;
            }
        }
    }

    @Override // androidx.transition.ViewUtilsApi19
    public void j(View view, Matrix matrix) {
        if (f53574i) {
            try {
                Api29Impl.c(view, matrix);
            } catch (NoSuchMethodError unused) {
                f53574i = false;
            }
        }
    }
}
