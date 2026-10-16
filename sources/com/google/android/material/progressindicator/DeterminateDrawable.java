package com.google.android.material.progressindicator;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import androidx.core.math.MathUtils;
import androidx.dynamicanimation.animation.FloatPropertyCompat;
import androidx.dynamicanimation.animation.SpringAnimation;
import androidx.dynamicanimation.animation.SpringForce;
import androidx.vectordrawable.graphics.drawable.Animatable2Compat;
import com.google.android.material.progressindicator.BaseProgressIndicatorSpec;
import com.google.android.material.progressindicator.DrawingDelegate;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class DeterminateDrawable<S extends BaseProgressIndicatorSpec> extends DrawableWithAnimatedVisibilityChange {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private static final FloatPropertyCompat f81518v = new FloatPropertyCompat<DeterminateDrawable<?>>("indicatorLevel") { // from class: com.google.android.material.progressindicator.DeterminateDrawable.1
        @Override // androidx.dynamicanimation.animation.FloatPropertyCompat
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public float a(DeterminateDrawable determinateDrawable) {
            return determinateDrawable.x() * 10000.0f;
        }

        @Override // androidx.dynamicanimation.animation.FloatPropertyCompat
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public void b(DeterminateDrawable determinateDrawable, float f3) {
            determinateDrawable.z(f3 / 10000.0f);
        }
    };

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private DrawingDelegate f81519q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private final SpringForce f81520r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private final SpringAnimation f81521s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private final DrawingDelegate.ActiveIndicator f81522t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private boolean f81523u;

    DeterminateDrawable(Context context, BaseProgressIndicatorSpec baseProgressIndicatorSpec, DrawingDelegate drawingDelegate) {
        super(context, baseProgressIndicatorSpec);
        this.f81523u = false;
        y(drawingDelegate);
        this.f81522t = new DrawingDelegate.ActiveIndicator();
        SpringForce springForce = new SpringForce();
        this.f81520r = springForce;
        springForce.d(1.0f);
        springForce.f(50.0f);
        SpringAnimation springAnimation = new SpringAnimation(this, f81518v);
        this.f81521s = springAnimation;
        springAnimation.p(springForce);
        n(1.0f);
    }

    static DeterminateDrawable v(Context context, CircularProgressIndicatorSpec circularProgressIndicatorSpec, CircularDrawingDelegate circularDrawingDelegate) {
        return new DeterminateDrawable(context, circularProgressIndicatorSpec, circularDrawingDelegate);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float x() {
        return this.f81522t.f81543b;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z(float f3) {
        this.f81522t.f81543b = f3;
        invalidateSelf();
    }

    void A(float f3) {
        setLevel((int) (f3 * 10000.0f));
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Rect rect = new Rect();
        if (!getBounds().isEmpty() && isVisible() && canvas.getClipBounds(rect)) {
            canvas.save();
            this.f81519q.g(canvas, getBounds(), h(), k(), j());
            this.f81537n.setStyle(Paint.Style.FILL);
            this.f81537n.setAntiAlias(true);
            DrawingDelegate.ActiveIndicator activeIndicator = this.f81522t;
            BaseProgressIndicatorSpec baseProgressIndicatorSpec = this.f81526b;
            activeIndicator.f81544c = baseProgressIndicatorSpec.f81489c[0];
            int iA = baseProgressIndicatorSpec.f81493g;
            if (iA > 0) {
                if (!(this.f81519q instanceof LinearDrawingDelegate)) {
                    iA = (int) ((iA * MathUtils.a(x(), 0.0f, 0.01f)) / 0.01f);
                }
                this.f81519q.d(canvas, this.f81537n, x(), 1.0f, this.f81526b.f81490d, getAlpha(), iA);
            } else {
                this.f81519q.d(canvas, this.f81537n, 0.0f, 1.0f, baseProgressIndicatorSpec.f81490d, getAlpha(), 0);
            }
            this.f81519q.c(canvas, this.f81537n, this.f81522t, getAlpha());
            this.f81519q.b(canvas, this.f81537n, this.f81526b.f81489c[0], getAlpha());
            canvas.restore();
        }
    }

    @Override // com.google.android.material.progressindicator.DrawableWithAnimatedVisibilityChange, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int getAlpha() {
        return super.getAlpha();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.f81519q.e();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.f81519q.f();
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

    @Override // android.graphics.drawable.Drawable
    public void jumpToCurrentState() {
        this.f81521s.q();
        z(getLevel() / 10000.0f);
    }

    @Override // com.google.android.material.progressindicator.DrawableWithAnimatedVisibilityChange
    public /* bridge */ /* synthetic */ boolean k() {
        return super.k();
    }

    @Override // com.google.android.material.progressindicator.DrawableWithAnimatedVisibilityChange
    public /* bridge */ /* synthetic */ void m(Animatable2Compat.AnimationCallback animationCallback) {
        super.m(animationCallback);
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onLevelChange(int i3) {
        if (this.f81523u) {
            this.f81521s.q();
            z(i3 / 10000.0f);
            return true;
        }
        this.f81521s.h(x() * 10000.0f);
        this.f81521s.l(i3);
        return true;
    }

    @Override // com.google.android.material.progressindicator.DrawableWithAnimatedVisibilityChange
    public /* bridge */ /* synthetic */ boolean q(boolean z2, boolean z3, boolean z4) {
        return super.q(z2, z3, z4);
    }

    @Override // com.google.android.material.progressindicator.DrawableWithAnimatedVisibilityChange
    boolean r(boolean z2, boolean z3, boolean z4) {
        boolean zR = super.r(z2, z3, z4);
        float fA = this.f81527c.a(this.f81525a.getContentResolver());
        if (fA == 0.0f) {
            this.f81523u = true;
            return zR;
        }
        this.f81523u = false;
        this.f81520r.f(50.0f / fA);
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

    DrawingDelegate w() {
        return this.f81519q;
    }

    void y(DrawingDelegate drawingDelegate) {
        this.f81519q = drawingDelegate;
    }
}
