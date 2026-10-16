package androidx.transition;

import android.graphics.Matrix;
import android.view.View;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
class ViewUtilsApi29 extends ViewUtilsApi23 {
    ViewUtilsApi29() {
    }

    @Override // androidx.transition.ViewUtilsApi19
    public float c(View view) {
        return view.getTransitionAlpha();
    }

    @Override // androidx.transition.ViewUtilsApi21, androidx.transition.ViewUtilsApi19
    public void e(View view, Matrix matrix) {
        view.setAnimationMatrix(matrix);
    }

    @Override // androidx.transition.ViewUtilsApi22, androidx.transition.ViewUtilsApi19
    public void f(View view, int i3, int i4, int i5, int i6) {
        view.setLeftTopRightBottom(i3, i4, i5, i6);
    }

    @Override // androidx.transition.ViewUtilsApi19
    public void g(View view, float f3) {
        view.setTransitionAlpha(f3);
    }

    @Override // androidx.transition.ViewUtilsApi23, androidx.transition.ViewUtilsApi19
    public void h(View view, int i3) {
        view.setTransitionVisibility(i3);
    }

    @Override // androidx.transition.ViewUtilsApi21, androidx.transition.ViewUtilsApi19
    public void i(View view, Matrix matrix) {
        view.transformMatrixToGlobal(matrix);
    }

    @Override // androidx.transition.ViewUtilsApi21, androidx.transition.ViewUtilsApi19
    public void j(View view, Matrix matrix) {
        view.transformMatrixToLocal(matrix);
    }
}
