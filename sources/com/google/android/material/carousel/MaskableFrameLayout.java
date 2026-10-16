package com.google.android.material.carousel;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.RectF;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import androidx.core.math.MathUtils;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.canvas.CanvasCompat;
import com.google.android.material.shape.AbsoluteCornerSize;
import com.google.android.material.shape.ClampedCornerSize;
import com.google.android.material.shape.CornerSize;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.shape.Shapeable;
import com.google.android.material.shape.ShapeableDelegate;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public class MaskableFrameLayout extends FrameLayout implements Maskable, Shapeable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private float f80396a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final RectF f80397b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private OnMaskChangedListener f80398c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private ShapeAppearanceModel f80399d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final ShapeableDelegate f80400f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private Boolean f80401g;

    public static /* synthetic */ CornerSize a(CornerSize cornerSize) {
        return cornerSize instanceof AbsoluteCornerSize ? ClampedCornerSize.b((AbsoluteCornerSize) cornerSize) : cornerSize;
    }

    private void c() {
        this.f80400f.e(this, this.f80397b);
        OnMaskChangedListener onMaskChangedListener = this.f80398c;
        if (onMaskChangedListener != null) {
            onMaskChangedListener.a(this.f80397b);
        }
    }

    private void d() {
        if (this.f80396a != -1.0f) {
            float fB = AnimationUtils.b(0.0f, getWidth() / 2.0f, 0.0f, 1.0f, this.f80396a);
            setMaskRectF(new RectF(fB, 0.0f, getWidth() - fB, getHeight()));
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        this.f80400f.d(canvas, new CanvasCompat.CanvasOperation() { // from class: com.google.android.material.carousel.d
            @Override // com.google.android.material.canvas.CanvasCompat.CanvasOperation
            public final void a(Canvas canvas2) {
                super/*android.view.View*/.dispatchDraw(canvas2);
            }
        });
    }

    @Override // android.view.View
    public void getFocusedRect(Rect rect) {
        RectF rectF = this.f80397b;
        rect.set((int) rectF.left, (int) rectF.top, (int) rectF.right, (int) rectF.bottom);
    }

    public RectF getMaskRectF() {
        return this.f80397b;
    }

    @Deprecated
    public float getMaskXPercentage() {
        return this.f80396a;
    }

    @Override // com.google.android.material.shape.Shapeable
    public ShapeAppearanceModel getShapeAppearanceModel() {
        return this.f80399d;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        Boolean bool = this.f80401g;
        if (bool != null) {
            this.f80400f.g(this, bool.booleanValue());
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        this.f80401g = Boolean.valueOf(this.f80400f.b());
        this.f80400f.g(this, true);
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    protected void onSizeChanged(int i3, int i4, int i5, int i6) {
        super.onSizeChanged(i3, i4, i5, i6);
        if (this.f80396a != -1.0f) {
            d();
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!this.f80397b.isEmpty() && motionEvent.getAction() == 0) {
            if (!this.f80397b.contains(motionEvent.getX(), motionEvent.getY())) {
                return false;
            }
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setForceCompatClipping(boolean z2) {
        this.f80400f.g(this, z2);
    }

    @Override // com.google.android.material.carousel.Maskable
    public void setMaskRectF(RectF rectF) {
        this.f80397b.set(rectF);
        c();
    }

    @Deprecated
    public void setMaskXPercentage(float f3) {
        float fA = MathUtils.a(f3, 0.0f, 1.0f);
        if (this.f80396a != fA) {
            this.f80396a = fA;
            d();
        }
    }

    public void setOnMaskChangedListener(OnMaskChangedListener onMaskChangedListener) {
        this.f80398c = onMaskChangedListener;
    }

    @Override // com.google.android.material.shape.Shapeable
    public void setShapeAppearanceModel(ShapeAppearanceModel shapeAppearanceModel) {
        ShapeAppearanceModel shapeAppearanceModelY = shapeAppearanceModel.y(new ShapeAppearanceModel.CornerSizeUnaryOperator() { // from class: com.google.android.material.carousel.c
            @Override // com.google.android.material.shape.ShapeAppearanceModel.CornerSizeUnaryOperator
            public final CornerSize a(CornerSize cornerSize) {
                return MaskableFrameLayout.a(cornerSize);
            }
        });
        this.f80399d = shapeAppearanceModelY;
        this.f80400f.f(this, shapeAppearanceModelY);
    }
}
