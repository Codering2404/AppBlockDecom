package com.google.android.material.progressindicator;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.vectordrawable.graphics.drawable.Animatable2Compat;
import androidx.vectordrawable.graphics.drawable.VectorDrawableCompat;
import com.google.android.material.R;
import com.google.android.material.progressindicator.BaseProgressIndicatorSpec;
import com.google.android.material.progressindicator.DrawingDelegate;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class IndeterminateDrawable<S extends BaseProgressIndicatorSpec> extends DrawableWithAnimatedVisibilityChange {

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private DrawingDelegate f81548q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private IndeterminateAnimatorDelegate f81549r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private Drawable f81550s;

    IndeterminateDrawable(Context context, BaseProgressIndicatorSpec baseProgressIndicatorSpec, DrawingDelegate drawingDelegate, IndeterminateAnimatorDelegate indeterminateAnimatorDelegate) {
        super(context, baseProgressIndicatorSpec);
        y(drawingDelegate);
        x(indeterminateAnimatorDelegate);
    }

    static IndeterminateDrawable t(Context context, CircularProgressIndicatorSpec circularProgressIndicatorSpec, CircularDrawingDelegate circularDrawingDelegate) {
        IndeterminateDrawable indeterminateDrawable = new IndeterminateDrawable(context, circularProgressIndicatorSpec, circularDrawingDelegate, new CircularIndeterminateAnimatorDelegate(circularProgressIndicatorSpec));
        indeterminateDrawable.z(VectorDrawableCompat.b(context.getResources(), R.drawable.f79609d, null));
        return indeterminateDrawable;
    }

    private boolean w() {
        AnimatorDurationScaleProvider animatorDurationScaleProvider = this.f81527c;
        return animatorDurationScaleProvider != null && animatorDurationScaleProvider.a(this.f81525a.getContentResolver()) == 0.0f;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        int i3;
        Drawable drawable;
        Rect rect = new Rect();
        if (!getBounds().isEmpty() && isVisible() && canvas.getClipBounds(rect)) {
            if (w() && (drawable = this.f81550s) != null) {
                drawable.setBounds(getBounds());
                DrawableCompat.n(this.f81550s, this.f81526b.f81489c[0]);
                this.f81550s.draw(canvas);
                return;
            }
            canvas.save();
            this.f81548q.g(canvas, getBounds(), h(), k(), j());
            int i4 = this.f81526b.f81493g;
            int alpha = getAlpha();
            if (i4 == 0) {
                this.f81548q.d(canvas, this.f81537n, 0.0f, 1.0f, this.f81526b.f81490d, alpha, 0);
                i3 = i4;
            } else {
                DrawingDelegate.ActiveIndicator activeIndicator = (DrawingDelegate.ActiveIndicator) this.f81549r.f81547b.get(0);
                DrawingDelegate.ActiveIndicator activeIndicator2 = (DrawingDelegate.ActiveIndicator) this.f81549r.f81547b.get(r1.size() - 1);
                DrawingDelegate drawingDelegate = this.f81548q;
                if (drawingDelegate instanceof LinearDrawingDelegate) {
                    i3 = i4;
                    drawingDelegate.d(canvas, this.f81537n, 0.0f, activeIndicator.f81542a, this.f81526b.f81490d, alpha, i3);
                    this.f81548q.d(canvas, this.f81537n, activeIndicator2.f81543b, 1.0f, this.f81526b.f81490d, alpha, i3);
                } else {
                    i3 = i4;
                    alpha = 0;
                    drawingDelegate.d(canvas, this.f81537n, activeIndicator2.f81543b, 1.0f + activeIndicator.f81542a, this.f81526b.f81490d, 0, i3);
                }
            }
            for (int i5 = 0; i5 < this.f81549r.f81547b.size(); i5++) {
                DrawingDelegate.ActiveIndicator activeIndicator3 = (DrawingDelegate.ActiveIndicator) this.f81549r.f81547b.get(i5);
                this.f81548q.c(canvas, this.f81537n, activeIndicator3, getAlpha());
                if (i5 > 0 && i3 > 0) {
                    this.f81548q.d(canvas, this.f81537n, ((DrawingDelegate.ActiveIndicator) this.f81549r.f81547b.get(i5 - 1)).f81543b, activeIndicator3.f81542a, this.f81526b.f81490d, alpha, i3);
                }
            }
            canvas.restore();
        }
    }

    @Override // com.google.android.material.progressindicator.DrawableWithAnimatedVisibilityChange, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int getAlpha() {
        return super.getAlpha();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.f81548q.e();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.f81548q.f();
    }

    @Override // com.google.android.material.progressindicator.DrawableWithAnimatedVisibilityChange, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int getOpacity() {
        return super.getOpacity();
    }

    @Override // com.google.android.material.progressindicator.DrawableWithAnimatedVisibilityChange
    public /* bridge */ /* synthetic */ boolean i() {
        return super.i();
    }

    @Override // com.google.android.material.progressindicator.DrawableWithAnimatedVisibilityChange, android.graphics.drawable.Animatable
    public /* bridge */ /* synthetic */ boolean isRunning() {
        return super.isRunning();
    }

    @Override // com.google.android.material.progressindicator.DrawableWithAnimatedVisibilityChange
    public /* bridge */ /* synthetic */ boolean j() {
        return super.j();
    }

    @Override // com.google.android.material.progressindicator.DrawableWithAnimatedVisibilityChange
    public /* bridge */ /* synthetic */ boolean k() {
        return super.k();
    }

    @Override // com.google.android.material.progressindicator.DrawableWithAnimatedVisibilityChange
    public /* bridge */ /* synthetic */ void m(Animatable2Compat.AnimationCallback animationCallback) {
        super.m(animationCallback);
    }

    @Override // com.google.android.material.progressindicator.DrawableWithAnimatedVisibilityChange
    public /* bridge */ /* synthetic */ boolean q(boolean z2, boolean z3, boolean z4) {
        return super.q(z2, z3, z4);
    }

    @Override // com.google.android.material.progressindicator.DrawableWithAnimatedVisibilityChange
    boolean r(boolean z2, boolean z3, boolean z4) {
        Drawable drawable;
        boolean zR = super.r(z2, z3, z4);
        if (w() && (drawable = this.f81550s) != null) {
            return drawable.setVisible(z2, z3);
        }
        if (!isRunning()) {
            this.f81549r.a();
        }
        if (!z2 || !z4) {
            return zR;
        }
        this.f81549r.g();
        return zR;
    }

    @Override // com.google.android.material.progressindicator.DrawableWithAnimatedVisibilityChange
    public /* bridge */ /* synthetic */ boolean s(Animatable2Compat.AnimationCallback animationCallback) {
        return super.s(animationCallback);
    }

    @Override // com.google.android.material.progressindicator.DrawableWithAnimatedVisibilityChange, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setAlpha(int i3) {
        super.setAlpha(i3);
    }

    @Override // com.google.android.material.progressindicator.DrawableWithAnimatedVisibilityChange, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setColorFilter(ColorFilter colorFilter) {
        super.setColorFilter(colorFilter);
    }

    @Override // com.google.android.material.progressindicator.DrawableWithAnimatedVisibilityChange, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ boolean setVisible(boolean z2, boolean z3) {
        return super.setVisible(z2, z3);
    }

    @Override // com.google.android.material.progressindicator.DrawableWithAnimatedVisibilityChange, android.graphics.drawable.Animatable
    public /* bridge */ /* synthetic */ void start() {
        super.start();
    }

    @Override // com.google.android.material.progressindicator.DrawableWithAnimatedVisibilityChange, android.graphics.drawable.Animatable
    public /* bridge */ /* synthetic */ void stop() {
        super.stop();
    }

    IndeterminateAnimatorDelegate u() {
        return this.f81549r;
    }

    DrawingDelegate v() {
        return this.f81548q;
    }

    void x(IndeterminateAnimatorDelegate indeterminateAnimatorDelegate) {
        this.f81549r = indeterminateAnimatorDelegate;
        indeterminateAnimatorDelegate.e(this);
    }

    void y(DrawingDelegate drawingDelegate) {
        this.f81548q = drawingDelegate;
    }

    public void z(Drawable drawable) {
        this.f81550s = drawable;
    }
}
