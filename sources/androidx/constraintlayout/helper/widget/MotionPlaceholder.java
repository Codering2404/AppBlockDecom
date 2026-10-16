package androidx.constraintlayout.helper.widget;

import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.View;
import androidx.constraintlayout.core.widgets.ConstraintWidgetContainer;
import androidx.constraintlayout.core.widgets.Helper;
import androidx.constraintlayout.core.widgets.Placeholder;
import androidx.constraintlayout.widget.VirtualLayout;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public class MotionPlaceholder extends VirtualLayout {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    Placeholder f32551m;

    @Override // androidx.constraintlayout.widget.VirtualLayout, androidx.constraintlayout.widget.ConstraintHelper
    protected void o(AttributeSet attributeSet) {
        super.o(attributeSet);
        this.f33099d = new Placeholder();
        w();
    }

    @Override // androidx.constraintlayout.widget.ConstraintHelper, android.view.View
    protected void onMeasure(int i3, int i4) {
        x(this.f32551m, i3, i4);
    }

    @Override // androidx.constraintlayout.widget.VirtualLayout
    public void x(androidx.constraintlayout.core.widgets.VirtualLayout virtualLayout, int i3, int i4) {
        int mode = View.MeasureSpec.getMode(i3);
        int size = View.MeasureSpec.getSize(i3);
        int mode2 = View.MeasureSpec.getMode(i4);
        int size2 = View.MeasureSpec.getSize(i4);
        if (virtualLayout == null) {
            setMeasuredDimension(0, 0);
        } else {
            virtualLayout.J1(mode, size, mode2, size2);
            setMeasuredDimension(virtualLayout.E1(), virtualLayout.D1());
        }
    }

    @Override // androidx.constraintlayout.widget.ConstraintHelper
    public void u(ConstraintWidgetContainer constraintWidgetContainer, Helper helper, SparseArray sparseArray) {
    }
}
