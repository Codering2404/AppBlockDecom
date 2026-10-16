package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.SparseArray;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.core.widgets.ConstraintWidgetContainer;
import androidx.constraintlayout.core.widgets.HelperWidget;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public class Barrier extends ConstraintHelper {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private int f33075k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private int f33076l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private androidx.constraintlayout.core.widgets.Barrier f33077m;

    public Barrier(Context context) {
        super(context);
        super.setVisibility(8);
    }

    private void x(ConstraintWidget constraintWidget, int i3, boolean z2) {
        this.f33076l = i3;
        if (z2) {
            int i4 = this.f33075k;
            if (i4 == 5) {
                this.f33076l = 1;
            } else if (i4 == 6) {
                this.f33076l = 0;
            }
        } else {
            int i5 = this.f33075k;
            if (i5 == 5) {
                this.f33076l = 0;
            } else if (i5 == 6) {
                this.f33076l = 1;
            }
        }
        if (constraintWidget instanceof androidx.constraintlayout.core.widgets.Barrier) {
            ((androidx.constraintlayout.core.widgets.Barrier) constraintWidget).H1(this.f33076l);
        }
    }

    public boolean getAllowsGoneWidget() {
        return this.f33077m.B1();
    }

    public int getMargin() {
        return this.f33077m.D1();
    }

    public int getType() {
        return this.f33075k;
    }

    @Override // androidx.constraintlayout.widget.ConstraintHelper
    protected void o(AttributeSet attributeSet) {
        super.o(attributeSet);
        this.f33077m = new androidx.constraintlayout.core.widgets.Barrier();
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.f33354n1);
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i3 = 0; i3 < indexCount; i3++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i3);
                if (index == R.styleable.D1) {
                    setType(typedArrayObtainStyledAttributes.getInt(index, 0));
                } else if (index == R.styleable.C1) {
                    this.f33077m.G1(typedArrayObtainStyledAttributes.getBoolean(index, true));
                } else if (index == R.styleable.E1) {
                    this.f33077m.I1(typedArrayObtainStyledAttributes.getDimensionPixelSize(index, 0));
                }
            }
            typedArrayObtainStyledAttributes.recycle();
        }
        this.f33099d = this.f33077m;
        w();
    }

    @Override // androidx.constraintlayout.widget.ConstraintHelper
    public void p(ConstraintSet.Constraint constraint, HelperWidget helperWidget, ConstraintLayout.LayoutParams layoutParams, SparseArray sparseArray) {
        super.p(constraint, helperWidget, layoutParams, sparseArray);
        if (helperWidget instanceof androidx.constraintlayout.core.widgets.Barrier) {
            androidx.constraintlayout.core.widgets.Barrier barrier = (androidx.constraintlayout.core.widgets.Barrier) helperWidget;
            x(barrier, constraint.f33195e.f33227h0, ((ConstraintWidgetContainer) helperWidget.N()).Y1());
            barrier.G1(constraint.f33195e.f33243p0);
            barrier.I1(constraint.f33195e.f33229i0);
        }
    }

    @Override // androidx.constraintlayout.widget.ConstraintHelper
    public void q(ConstraintWidget constraintWidget, boolean z2) {
        x(constraintWidget, this.f33075k, z2);
    }

    public void setAllowsGoneWidget(boolean z2) {
        this.f33077m.G1(z2);
    }

    public void setDpMargin(int i3) {
        this.f33077m.I1((int) ((i3 * getResources().getDisplayMetrics().density) + 0.5f));
    }

    public void setMargin(int i3) {
        this.f33077m.I1(i3);
    }

    public void setType(int i3) {
        this.f33075k = i3;
    }

    public Barrier(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        super.setVisibility(8);
    }
}
