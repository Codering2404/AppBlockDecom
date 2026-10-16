package androidx.constraintlayout.motion.widget;

import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintHelper;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.R;
import java.util.HashMap;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public class MotionHelper extends ConstraintHelper implements MotionHelperInterface {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private boolean f32735k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private boolean f32736l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private float f32737m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    protected View[] f32738n;

    public float getProgress() {
        return this.f32737m;
    }

    @Override // androidx.constraintlayout.widget.ConstraintHelper
    protected void o(AttributeSet attributeSet) {
        super.o(attributeSet);
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.K8);
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i3 = 0; i3 < indexCount; i3++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i3);
                if (index == R.styleable.M8) {
                    this.f32735k = typedArrayObtainStyledAttributes.getBoolean(index, this.f32735k);
                } else if (index == R.styleable.L8) {
                    this.f32736l = typedArrayObtainStyledAttributes.getBoolean(index, this.f32736l);
                }
            }
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    public void setProgress(float f3) {
        this.f32737m = f3;
        int i3 = 0;
        if (this.f33097b > 0) {
            this.f32738n = n((ConstraintLayout) getParent());
            while (i3 < this.f33097b) {
                E(this.f32738n[i3], f3);
                i3++;
            }
            return;
        }
        ViewGroup viewGroup = (ViewGroup) getParent();
        int childCount = viewGroup.getChildCount();
        while (i3 < childCount) {
            View childAt = viewGroup.getChildAt(i3);
            if (!(childAt instanceof MotionHelper)) {
                E(childAt, f3);
            }
            i3++;
        }
    }

    public boolean x() {
        return false;
    }

    public boolean y() {
        return this.f32736l;
    }

    public boolean z() {
        return this.f32735k;
    }

    public void A(MotionLayout motionLayout) {
    }

    public void B(Canvas canvas) {
    }

    public void C(Canvas canvas) {
    }

    public void D(MotionLayout motionLayout, HashMap map) {
    }

    public void E(View view, float f3) {
    }

    public void b(MotionLayout motionLayout, int i3) {
    }

    @Override // androidx.constraintlayout.motion.widget.MotionLayout.TransitionListener
    public void c(MotionLayout motionLayout, int i3, int i4) {
    }

    public void a(MotionLayout motionLayout, int i3, int i4, float f3) {
    }

    @Override // androidx.constraintlayout.motion.widget.MotionLayout.TransitionListener
    public void d(MotionLayout motionLayout, int i3, boolean z2, float f3) {
    }
}
