package com.google.android.material.ripple;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import androidx.core.graphics.drawable.TintAwareDrawable;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.shape.Shapeable;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public class RippleDrawableCompat extends Drawable implements Shapeable, TintAwareDrawable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private RippleDrawableCompatState f81613a;

    @Override // android.graphics.drawable.Drawable
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public RippleDrawableCompat mutate() {
        this.f81613a = new RippleDrawableCompatState(this.f81613a);
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        RippleDrawableCompatState rippleDrawableCompatState = this.f81613a;
        if (rippleDrawableCompatState.f81615b) {
            rippleDrawableCompatState.f81614a.draw(canvas);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable.ConstantState getConstantState() {
        return this.f81613a;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return this.f81613a.f81614a.getOpacity();
    }

    @Override // com.google.android.material.shape.Shapeable
    public ShapeAppearanceModel getShapeAppearanceModel() {
        return this.f81613a.f81614a.getShapeAppearanceModel();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        this.f81613a.f81614a.setBounds(rect);
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onStateChange(int[] iArr) {
        boolean zOnStateChange = super.onStateChange(iArr);
        if (this.f81613a.f81614a.setState(iArr)) {
            zOnStateChange = true;
        }
        boolean zE = RippleUtils.e(iArr);
        RippleDrawableCompatState rippleDrawableCompatState = this.f81613a;
        if (rippleDrawableCompatState.f81615b == zE) {
            return zOnStateChange;
        }
        rippleDrawableCompatState.f81615b = zE;
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i3) {
        this.f81613a.f81614a.setAlpha(i3);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f81613a.f81614a.setColorFilter(colorFilter);
    }

    @Override // com.google.android.material.shape.Shapeable
    public void setShapeAppearanceModel(ShapeAppearanceModel shapeAppearanceModel) {
        this.f81613a.f81614a.setShapeAppearanceModel(shapeAppearanceModel);
    }

    @Override // android.graphics.drawable.Drawable
    public void setTint(int i3) {
        this.f81613a.f81614a.setTint(i3);
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintList(ColorStateList colorStateList) {
        this.f81613a.f81614a.setTintList(colorStateList);
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintMode(PorterDuff.Mode mode) {
        this.f81613a.f81614a.setTintMode(mode);
    }

    public RippleDrawableCompat(ShapeAppearanceModel shapeAppearanceModel) {
        this(new RippleDrawableCompatState(new MaterialShapeDrawable(shapeAppearanceModel)));
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class RippleDrawableCompatState extends Drawable.ConstantState {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        MaterialShapeDrawable f81614a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        boolean f81615b;

        public RippleDrawableCompatState(MaterialShapeDrawable materialShapeDrawable) {
            this.f81614a = materialShapeDrawable;
            this.f81615b = false;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public RippleDrawableCompat newDrawable() {
            return new RippleDrawableCompat(new RippleDrawableCompatState(this));
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return 0;
        }

        public RippleDrawableCompatState(RippleDrawableCompatState rippleDrawableCompatState) {
            this.f81614a = (MaterialShapeDrawable) rippleDrawableCompatState.f81614a.getConstantState().newDrawable();
            this.f81615b = rippleDrawableCompatState.f81615b;
        }
    }

    private RippleDrawableCompat(RippleDrawableCompatState rippleDrawableCompatState) {
        this.f81613a = rippleDrawableCompatState;
    }
}
