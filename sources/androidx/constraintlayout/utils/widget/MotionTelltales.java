package androidx.constraintlayout.utils.widget;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.view.ViewParent;
import androidx.constraintlayout.motion.widget.MotionLayout;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public class MotionTelltales extends MockView {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private Paint f33069j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    MotionLayout f33070k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    float[] f33071l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    Matrix f33072m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    int f33073n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    float f33074o;

    @Override // android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    @Override // androidx.constraintlayout.utils.widget.MockView, android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        getMatrix().invert(this.f33072m);
        if (this.f33070k == null) {
            ViewParent parent = getParent();
            if (parent instanceof MotionLayout) {
                this.f33070k = (MotionLayout) parent;
                return;
            }
            return;
        }
        int width = getWidth();
        int height = getHeight();
        float[] fArr = {0.1f, 0.25f, 0.5f, 0.75f, 0.9f};
        for (int i3 = 0; i3 < 5; i3++) {
            float f3 = fArr[i3];
            for (int i4 = 0; i4 < 5; i4++) {
                float f4 = fArr[i4];
                this.f33070k.Z(this, f4, f3, this.f33071l, this.f33073n);
                this.f33072m.mapVectors(this.f33071l);
                float f5 = width * f4;
                float f6 = height * f3;
                float[] fArr2 = this.f33071l;
                float f7 = fArr2[0];
                float f8 = this.f33074o;
                float f9 = f6 - (fArr2[1] * f8);
                this.f33072m.mapVectors(fArr2);
                canvas.drawLine(f5, f6, f5 - (f7 * f8), f9, this.f33069j);
            }
        }
    }

    @Override // android.view.View
    protected void onLayout(boolean z2, int i3, int i4, int i5, int i6) {
        super.onLayout(z2, i3, i4, i5, i6);
        postInvalidate();
    }

    public void setText(CharSequence charSequence) {
        this.f33032g = charSequence.toString();
        requestLayout();
    }
}
