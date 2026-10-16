package com.google.android.material.textfield;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.view.View;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.ShapeAppearanceModel;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
class CutoutDrawable extends MaterialShapeDrawable {
    CutoutDrawableState A;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class ImplApi14 extends CutoutDrawable {
        private Paint B;
        private int C;

        private void A0(Canvas canvas) {
            this.C = canvas.saveLayer(0.0f, 0.0f, canvas.getWidth(), canvas.getHeight(), null);
        }

        private boolean B0(Drawable.Callback callback) {
            return callback instanceof View;
        }

        private Paint x0() {
            if (this.B == null) {
                Paint paint = new Paint(1);
                this.B = paint;
                paint.setStyle(Paint.Style.FILL_AND_STROKE);
                this.B.setColor(-1);
                this.B.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
            }
            return this.B;
        }

        private void y0(Canvas canvas) {
            if (B0(getCallback())) {
                return;
            }
            canvas.restoreToCount(this.C);
        }

        private void z0(Canvas canvas) {
            Drawable.Callback callback = getCallback();
            if (!B0(callback)) {
                A0(canvas);
                return;
            }
            View view = (View) callback;
            if (view.getLayerType() != 2) {
                view.setLayerType(2, null);
            }
        }

        @Override // com.google.android.material.shape.MaterialShapeDrawable, android.graphics.drawable.Drawable
        public void draw(Canvas canvas) {
            z0(canvas);
            super.draw(canvas);
            y0(canvas);
        }

        @Override // com.google.android.material.shape.MaterialShapeDrawable
        protected void r(Canvas canvas) {
            super.r(canvas);
            canvas.drawRect(this.A.f82220w, x0());
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class ImplApi18 extends CutoutDrawable {
        ImplApi18(CutoutDrawableState cutoutDrawableState) {
            super(cutoutDrawableState);
        }

        @Override // com.google.android.material.shape.MaterialShapeDrawable
        protected void r(Canvas canvas) {
            if (this.A.f82220w.isEmpty()) {
                super.r(canvas);
                return;
            }
            canvas.save();
            canvas.clipOutRect(this.A.f82220w);
            super.r(canvas);
            canvas.restore();
        }
    }

    static CutoutDrawable r0(ShapeAppearanceModel shapeAppearanceModel) {
        if (shapeAppearanceModel == null) {
            shapeAppearanceModel = new ShapeAppearanceModel();
        }
        return s0(new CutoutDrawableState(shapeAppearanceModel, new RectF()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static CutoutDrawable s0(CutoutDrawableState cutoutDrawableState) {
        return new ImplApi18(cutoutDrawableState);
    }

    @Override // com.google.android.material.shape.MaterialShapeDrawable, android.graphics.drawable.Drawable
    public Drawable mutate() {
        this.A = new CutoutDrawableState(this.A);
        return this;
    }

    boolean t0() {
        return !this.A.f82220w.isEmpty();
    }

    void u0() {
        v0(0.0f, 0.0f, 0.0f, 0.0f);
    }

    void v0(float f3, float f4, float f5, float f6) {
        if (f3 == this.A.f82220w.left && f4 == this.A.f82220w.top && f5 == this.A.f82220w.right && f6 == this.A.f82220w.bottom) {
            return;
        }
        this.A.f82220w.set(f3, f4, f5, f6);
        invalidateSelf();
    }

    void w0(RectF rectF) {
        v0(rectF.left, rectF.top, rectF.right, rectF.bottom);
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class CutoutDrawableState extends MaterialShapeDrawable.MaterialShapeDrawableState {

        /* JADX INFO: renamed from: w, reason: collision with root package name */
        private final RectF f82220w;

        @Override // com.google.android.material.shape.MaterialShapeDrawable.MaterialShapeDrawableState, android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            CutoutDrawable cutoutDrawableS0 = CutoutDrawable.s0(this);
            cutoutDrawableS0.invalidateSelf();
            return cutoutDrawableS0;
        }

        private CutoutDrawableState(ShapeAppearanceModel shapeAppearanceModel, RectF rectF) {
            super(shapeAppearanceModel, null);
            this.f82220w = rectF;
        }

        private CutoutDrawableState(CutoutDrawableState cutoutDrawableState) {
            super(cutoutDrawableState);
            this.f82220w = cutoutDrawableState.f82220w;
        }
    }

    private CutoutDrawable(CutoutDrawableState cutoutDrawableState) {
        super(cutoutDrawableState);
        this.A = cutoutDrawableState;
    }
}
