package androidx.constraintlayout.helper.widget;

import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.widget.ConstraintHelper;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.R;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public class Layer extends ConstraintHelper {
    private boolean A;
    private boolean B;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private float f32527k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private float f32528l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private float f32529m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    ConstraintLayout f32530n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private float f32531o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private float f32532p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    protected float f32533q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    protected float f32534r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    protected float f32535s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    protected float f32536t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    protected float f32537u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    protected float f32538v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    boolean f32539w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    View[] f32540x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private float f32541y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private float f32542z;

    private void y() {
        int i3;
        if (this.f32530n == null || (i3 = this.f33097b) == 0) {
            return;
        }
        View[] viewArr = this.f32540x;
        if (viewArr == null || viewArr.length != i3) {
            this.f32540x = new View[i3];
        }
        for (int i4 = 0; i4 < this.f33097b; i4++) {
            this.f32540x[i4] = this.f32530n.getViewById(this.f33096a[i4]);
        }
    }

    private void z() {
        if (this.f32530n == null) {
            return;
        }
        if (this.f32540x == null) {
            y();
        }
        x();
        double radians = Float.isNaN(this.f32529m) ? 0.0d : Math.toRadians(this.f32529m);
        float fSin = (float) Math.sin(radians);
        float fCos = (float) Math.cos(radians);
        float f3 = this.f32531o;
        float f4 = f3 * fCos;
        float f5 = this.f32532p;
        float f6 = (-f5) * fSin;
        float f7 = f3 * fSin;
        float f8 = f5 * fCos;
        for (int i3 = 0; i3 < this.f33097b; i3++) {
            View view = this.f32540x[i3];
            int left = (view.getLeft() + view.getRight()) / 2;
            int top = (view.getTop() + view.getBottom()) / 2;
            float f9 = left - this.f32533q;
            float f10 = top - this.f32534r;
            float f11 = (((f4 * f9) + (f6 * f10)) - f9) + this.f32541y;
            float f12 = (((f9 * f7) + (f8 * f10)) - f10) + this.f32542z;
            view.setTranslationX(f11);
            view.setTranslationY(f12);
            view.setScaleY(this.f32532p);
            view.setScaleX(this.f32531o);
            if (!Float.isNaN(this.f32529m)) {
                view.setRotation(this.f32529m);
            }
        }
    }

    @Override // androidx.constraintlayout.widget.ConstraintHelper
    protected void j(ConstraintLayout constraintLayout) {
        i(constraintLayout);
    }

    @Override // androidx.constraintlayout.widget.ConstraintHelper
    protected void o(AttributeSet attributeSet) {
        super.o(attributeSet);
        this.f33100f = false;
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.f33354n1);
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i3 = 0; i3 < indexCount; i3++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i3);
                if (index == R.styleable.f33379u1) {
                    this.A = true;
                } else if (index == R.styleable.B1) {
                    this.B = true;
                }
            }
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    @Override // androidx.constraintlayout.widget.ConstraintHelper, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f32530n = (ConstraintLayout) getParent();
        if (this.A || this.B) {
            int visibility = getVisibility();
            float elevation = getElevation();
            for (int i3 = 0; i3 < this.f33097b; i3++) {
                View viewById = this.f32530n.getViewById(this.f33096a[i3]);
                if (viewById != null) {
                    if (this.A) {
                        viewById.setVisibility(visibility);
                    }
                    if (this.B && elevation > 0.0f) {
                        viewById.setTranslationZ(viewById.getTranslationZ() + elevation);
                    }
                }
            }
        }
    }

    @Override // androidx.constraintlayout.widget.ConstraintHelper
    public void r(ConstraintLayout constraintLayout) {
        y();
        this.f32533q = Float.NaN;
        this.f32534r = Float.NaN;
        ConstraintWidget constraintWidgetB = ((ConstraintLayout.LayoutParams) getLayoutParams()).b();
        constraintWidgetB.r1(0);
        constraintWidgetB.S0(0);
        x();
        layout(((int) this.f32537u) - getPaddingLeft(), ((int) this.f32538v) - getPaddingTop(), ((int) this.f32535s) + getPaddingRight(), ((int) this.f32536t) + getPaddingBottom());
        z();
    }

    @Override // android.view.View
    public void setElevation(float f3) {
        super.setElevation(f3);
        h();
    }

    @Override // android.view.View
    public void setPivotX(float f3) {
        this.f32527k = f3;
        z();
    }

    @Override // android.view.View
    public void setPivotY(float f3) {
        this.f32528l = f3;
        z();
    }

    @Override // android.view.View
    public void setRotation(float f3) {
        this.f32529m = f3;
        z();
    }

    @Override // android.view.View
    public void setScaleX(float f3) {
        this.f32531o = f3;
        z();
    }

    @Override // android.view.View
    public void setScaleY(float f3) {
        this.f32532p = f3;
        z();
    }

    @Override // android.view.View
    public void setTranslationX(float f3) {
        this.f32541y = f3;
        z();
    }

    @Override // android.view.View
    public void setTranslationY(float f3) {
        this.f32542z = f3;
        z();
    }

    @Override // android.view.View
    public void setVisibility(int i3) {
        super.setVisibility(i3);
        h();
    }

    @Override // androidx.constraintlayout.widget.ConstraintHelper
    public void t(ConstraintLayout constraintLayout) {
        this.f32530n = constraintLayout;
        float rotation = getRotation();
        if (rotation != 0.0f) {
            this.f32529m = rotation;
        } else {
            if (Float.isNaN(this.f32529m)) {
                return;
            }
            this.f32529m = rotation;
        }
    }

    protected void x() {
        if (this.f32530n == null) {
            return;
        }
        if (this.f32539w || Float.isNaN(this.f32533q) || Float.isNaN(this.f32534r)) {
            if (!Float.isNaN(this.f32527k) && !Float.isNaN(this.f32528l)) {
                this.f32534r = this.f32528l;
                this.f32533q = this.f32527k;
                return;
            }
            View[] viewArrN = n(this.f32530n);
            int left = viewArrN[0].getLeft();
            int top = viewArrN[0].getTop();
            int right = viewArrN[0].getRight();
            int bottom = viewArrN[0].getBottom();
            for (int i3 = 0; i3 < this.f33097b; i3++) {
                View view = viewArrN[i3];
                left = Math.min(left, view.getLeft());
                top = Math.min(top, view.getTop());
                right = Math.max(right, view.getRight());
                bottom = Math.max(bottom, view.getBottom());
            }
            this.f32535s = right;
            this.f32536t = bottom;
            this.f32537u = left;
            this.f32538v = top;
            if (Float.isNaN(this.f32527k)) {
                this.f32533q = (left + right) / 2;
            } else {
                this.f32533q = this.f32527k;
            }
            if (Float.isNaN(this.f32528l)) {
                this.f32534r = (top + bottom) / 2;
            } else {
                this.f32534r = this.f32528l;
            }
        }
    }
}
