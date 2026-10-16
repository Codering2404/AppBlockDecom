package androidx.constraintlayout.helper.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.View;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.core.widgets.HelperWidget;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.constraintlayout.widget.R;
import androidx.constraintlayout.widget.VirtualLayout;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public class Flow extends VirtualLayout {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private androidx.constraintlayout.core.widgets.Flow f32526m;

    public Flow(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // androidx.constraintlayout.widget.VirtualLayout, androidx.constraintlayout.widget.ConstraintHelper
    protected void o(AttributeSet attributeSet) {
        super.o(attributeSet);
        this.f32526m = new androidx.constraintlayout.core.widgets.Flow();
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.f33354n1);
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i3 = 0; i3 < indexCount; i3++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i3);
                if (index == R.styleable.f33358o1) {
                    this.f32526m.K2(typedArrayObtainStyledAttributes.getInt(index, 0));
                } else if (index == R.styleable.f33362p1) {
                    this.f32526m.P1(typedArrayObtainStyledAttributes.getDimensionPixelSize(index, 0));
                } else if (index == R.styleable.f33394z1) {
                    this.f32526m.U1(typedArrayObtainStyledAttributes.getDimensionPixelSize(index, 0));
                } else if (index == R.styleable.A1) {
                    this.f32526m.R1(typedArrayObtainStyledAttributes.getDimensionPixelSize(index, 0));
                } else if (index == R.styleable.f33366q1) {
                    this.f32526m.S1(typedArrayObtainStyledAttributes.getDimensionPixelSize(index, 0));
                } else if (index == R.styleable.f33370r1) {
                    this.f32526m.V1(typedArrayObtainStyledAttributes.getDimensionPixelSize(index, 0));
                } else if (index == R.styleable.f33373s1) {
                    this.f32526m.T1(typedArrayObtainStyledAttributes.getDimensionPixelSize(index, 0));
                } else if (index == R.styleable.f33376t1) {
                    this.f32526m.Q1(typedArrayObtainStyledAttributes.getDimensionPixelSize(index, 0));
                } else if (index == R.styleable.f33319e2) {
                    this.f32526m.P2(typedArrayObtainStyledAttributes.getInt(index, 0));
                } else if (index == R.styleable.U1) {
                    this.f32526m.E2(typedArrayObtainStyledAttributes.getInt(index, 0));
                } else if (index == R.styleable.f33315d2) {
                    this.f32526m.O2(typedArrayObtainStyledAttributes.getInt(index, 0));
                } else if (index == R.styleable.O1) {
                    this.f32526m.y2(typedArrayObtainStyledAttributes.getInt(index, 0));
                } else if (index == R.styleable.W1) {
                    this.f32526m.G2(typedArrayObtainStyledAttributes.getInt(index, 0));
                } else if (index == R.styleable.Q1) {
                    this.f32526m.A2(typedArrayObtainStyledAttributes.getInt(index, 0));
                } else if (index == R.styleable.Y1) {
                    this.f32526m.I2(typedArrayObtainStyledAttributes.getInt(index, 0));
                } else if (index == R.styleable.S1) {
                    this.f32526m.C2(typedArrayObtainStyledAttributes.getFloat(index, 0.5f));
                } else if (index == R.styleable.N1) {
                    this.f32526m.x2(typedArrayObtainStyledAttributes.getFloat(index, 0.5f));
                } else if (index == R.styleable.V1) {
                    this.f32526m.F2(typedArrayObtainStyledAttributes.getFloat(index, 0.5f));
                } else if (index == R.styleable.P1) {
                    this.f32526m.z2(typedArrayObtainStyledAttributes.getFloat(index, 0.5f));
                } else if (index == R.styleable.X1) {
                    this.f32526m.H2(typedArrayObtainStyledAttributes.getFloat(index, 0.5f));
                } else if (index == R.styleable.f33307b2) {
                    this.f32526m.M2(typedArrayObtainStyledAttributes.getFloat(index, 0.5f));
                } else if (index == R.styleable.R1) {
                    this.f32526m.B2(typedArrayObtainStyledAttributes.getInt(index, 2));
                } else if (index == R.styleable.f33303a2) {
                    this.f32526m.L2(typedArrayObtainStyledAttributes.getInt(index, 2));
                } else if (index == R.styleable.T1) {
                    this.f32526m.D2(typedArrayObtainStyledAttributes.getDimensionPixelSize(index, 0));
                } else if (index == R.styleable.f33311c2) {
                    this.f32526m.N2(typedArrayObtainStyledAttributes.getDimensionPixelSize(index, 0));
                } else if (index == R.styleable.Z1) {
                    this.f32526m.J2(typedArrayObtainStyledAttributes.getInt(index, -1));
                }
            }
            typedArrayObtainStyledAttributes.recycle();
        }
        this.f33099d = this.f32526m;
        w();
    }

    @Override // androidx.constraintlayout.widget.ConstraintHelper, android.view.View
    protected void onMeasure(int i3, int i4) {
        x(this.f32526m, i3, i4);
    }

    @Override // androidx.constraintlayout.widget.ConstraintHelper
    public void p(ConstraintSet.Constraint constraint, HelperWidget helperWidget, ConstraintLayout.LayoutParams layoutParams, SparseArray sparseArray) {
        super.p(constraint, helperWidget, layoutParams, sparseArray);
        if (helperWidget instanceof androidx.constraintlayout.core.widgets.Flow) {
            androidx.constraintlayout.core.widgets.Flow flow = (androidx.constraintlayout.core.widgets.Flow) helperWidget;
            int i3 = layoutParams.Z;
            if (i3 != -1) {
                flow.K2(i3);
            }
        }
    }

    @Override // androidx.constraintlayout.widget.ConstraintHelper
    public void q(ConstraintWidget constraintWidget, boolean z2) {
        this.f32526m.A1(z2);
    }

    public void setFirstHorizontalBias(float f3) {
        this.f32526m.x2(f3);
        requestLayout();
    }

    public void setFirstHorizontalStyle(int i3) {
        this.f32526m.y2(i3);
        requestLayout();
    }

    public void setFirstVerticalBias(float f3) {
        this.f32526m.z2(f3);
        requestLayout();
    }

    public void setFirstVerticalStyle(int i3) {
        this.f32526m.A2(i3);
        requestLayout();
    }

    public void setHorizontalAlign(int i3) {
        this.f32526m.B2(i3);
        requestLayout();
    }

    public void setHorizontalBias(float f3) {
        this.f32526m.C2(f3);
        requestLayout();
    }

    public void setHorizontalGap(int i3) {
        this.f32526m.D2(i3);
        requestLayout();
    }

    public void setHorizontalStyle(int i3) {
        this.f32526m.E2(i3);
        requestLayout();
    }

    public void setLastHorizontalBias(float f3) {
        this.f32526m.F2(f3);
        requestLayout();
    }

    public void setLastHorizontalStyle(int i3) {
        this.f32526m.G2(i3);
        requestLayout();
    }

    public void setLastVerticalBias(float f3) {
        this.f32526m.H2(f3);
        requestLayout();
    }

    public void setLastVerticalStyle(int i3) {
        this.f32526m.I2(i3);
        requestLayout();
    }

    public void setMaxElementsWrap(int i3) {
        this.f32526m.J2(i3);
        requestLayout();
    }

    public void setOrientation(int i3) {
        this.f32526m.K2(i3);
        requestLayout();
    }

    public void setPadding(int i3) {
        this.f32526m.P1(i3);
        requestLayout();
    }

    public void setPaddingBottom(int i3) {
        this.f32526m.Q1(i3);
        requestLayout();
    }

    public void setPaddingLeft(int i3) {
        this.f32526m.S1(i3);
        requestLayout();
    }

    public void setPaddingRight(int i3) {
        this.f32526m.T1(i3);
        requestLayout();
    }

    public void setPaddingTop(int i3) {
        this.f32526m.V1(i3);
        requestLayout();
    }

    public void setVerticalAlign(int i3) {
        this.f32526m.L2(i3);
        requestLayout();
    }

    public void setVerticalBias(float f3) {
        this.f32526m.M2(f3);
        requestLayout();
    }

    public void setVerticalGap(int i3) {
        this.f32526m.N2(i3);
        requestLayout();
    }

    public void setVerticalStyle(int i3) {
        this.f32526m.O2(i3);
        requestLayout();
    }

    public void setWrapMode(int i3) {
        this.f32526m.P2(i3);
        requestLayout();
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
}
