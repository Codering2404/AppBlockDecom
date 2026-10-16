package com.google.android.material.floatingactionbutton;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.StateListAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.util.Property;
import android.view.View;
import androidx.core.content.ContextCompat;
import androidx.core.util.Preconditions;
import com.google.android.material.R;
import com.google.android.material.ripple.RippleUtils;
import com.google.android.material.shadow.ShadowViewDelegate;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.ShapeAppearanceModel;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
class FloatingActionButtonImplLollipop extends FloatingActionButtonImpl {
    private StateListAnimator O;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class AlwaysStatefulMaterialShapeDrawable extends MaterialShapeDrawable {
        AlwaysStatefulMaterialShapeDrawable(ShapeAppearanceModel shapeAppearanceModel) {
            super(shapeAppearanceModel);
        }

        @Override // com.google.android.material.shape.MaterialShapeDrawable, android.graphics.drawable.Drawable
        public boolean isStateful() {
            return true;
        }
    }

    FloatingActionButtonImplLollipop(FloatingActionButton floatingActionButton, ShadowViewDelegate shadowViewDelegate) {
        super(floatingActionButton, shadowViewDelegate);
    }

    private StateListAnimator k0(float f3, float f4, float f5) {
        StateListAnimator stateListAnimator = new StateListAnimator();
        stateListAnimator.addState(FloatingActionButtonImpl.I, l0(f3, f5));
        stateListAnimator.addState(FloatingActionButtonImpl.J, l0(f3, f4));
        stateListAnimator.addState(FloatingActionButtonImpl.K, l0(f3, f4));
        stateListAnimator.addState(FloatingActionButtonImpl.L, l0(f3, f4));
        AnimatorSet animatorSet = new AnimatorSet();
        ArrayList arrayList = new ArrayList();
        arrayList.add(ObjectAnimator.ofFloat(this.f81069w, "elevation", f3).setDuration(0L));
        arrayList.add(ObjectAnimator.ofFloat(this.f81069w, (Property<FloatingActionButton, Float>) View.TRANSLATION_Z, 0.0f).setDuration(100L));
        animatorSet.playSequentially((Animator[]) arrayList.toArray(new Animator[0]));
        animatorSet.setInterpolator(FloatingActionButtonImpl.D);
        stateListAnimator.addState(FloatingActionButtonImpl.M, animatorSet);
        stateListAnimator.addState(FloatingActionButtonImpl.N, l0(0.0f, 0.0f));
        return stateListAnimator;
    }

    private Animator l0(float f3, float f4) {
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(ObjectAnimator.ofFloat(this.f81069w, "elevation", f3).setDuration(0L)).with(ObjectAnimator.ofFloat(this.f81069w, (Property<FloatingActionButton, Float>) View.TRANSLATION_Z, f4).setDuration(100L));
        animatorSet.setInterpolator(FloatingActionButtonImpl.D);
        return animatorSet;
    }

    @Override // com.google.android.material.floatingactionbutton.FloatingActionButtonImpl
    void D() {
        g0();
    }

    @Override // com.google.android.material.floatingactionbutton.FloatingActionButtonImpl
    void G(float f3, float f4, float f5) {
        if (this.f81069w.getStateListAnimator() == this.O) {
            StateListAnimator stateListAnimatorK0 = k0(f3, f4, f5);
            this.O = stateListAnimatorK0;
            this.f81069w.setStateListAnimator(stateListAnimatorK0);
        }
        if (a0()) {
            g0();
        }
    }

    @Override // com.google.android.material.floatingactionbutton.FloatingActionButtonImpl
    boolean L() {
        return false;
    }

    @Override // com.google.android.material.floatingactionbutton.FloatingActionButtonImpl
    void W(ColorStateList colorStateList) {
        Drawable drawable = this.f81049c;
        if (drawable instanceof RippleDrawable) {
            ((RippleDrawable) drawable).setColor(RippleUtils.d(colorStateList));
        } else {
            super.W(colorStateList);
        }
    }

    @Override // com.google.android.material.floatingactionbutton.FloatingActionButtonImpl
    boolean a0() {
        return this.f81070x.c() || !c0();
    }

    BorderDrawable j0(int i3, ColorStateList colorStateList) {
        Context context = this.f81069w.getContext();
        BorderDrawable borderDrawable = new BorderDrawable((ShapeAppearanceModel) Preconditions.h(this.f81047a));
        borderDrawable.e(ContextCompat.getColor(context, R.color.f79532e), ContextCompat.getColor(context, R.color.f79531d), ContextCompat.getColor(context, R.color.f79529b), ContextCompat.getColor(context, R.color.f79530c));
        borderDrawable.d(i3);
        borderDrawable.c(colorStateList);
        return borderDrawable;
    }

    @Override // com.google.android.material.floatingactionbutton.FloatingActionButtonImpl
    MaterialShapeDrawable l() {
        return new AlwaysStatefulMaterialShapeDrawable((ShapeAppearanceModel) Preconditions.h(this.f81047a));
    }

    @Override // com.google.android.material.floatingactionbutton.FloatingActionButtonImpl
    public float n() {
        return this.f81069w.getElevation();
    }

    @Override // com.google.android.material.floatingactionbutton.FloatingActionButtonImpl
    void s(Rect rect) {
        if (this.f81070x.c()) {
            super.s(rect);
        } else if (c0()) {
            rect.set(0, 0, 0, 0);
        } else {
            int sizeDimension = (this.f81057k - this.f81069w.getSizeDimension()) / 2;
            rect.set(sizeDimension, sizeDimension, sizeDimension, sizeDimension);
        }
    }

    @Override // com.google.android.material.floatingactionbutton.FloatingActionButtonImpl
    void y(ColorStateList colorStateList, PorterDuff.Mode mode, ColorStateList colorStateList2, int i3) {
        Drawable layerDrawable;
        MaterialShapeDrawable materialShapeDrawableL = l();
        this.f81048b = materialShapeDrawableL;
        materialShapeDrawableL.setTintList(colorStateList);
        if (mode != null) {
            this.f81048b.setTintMode(mode);
        }
        this.f81048b.P(this.f81069w.getContext());
        if (i3 > 0) {
            this.f81050d = j0(i3, colorStateList);
            layerDrawable = new LayerDrawable(new Drawable[]{(Drawable) Preconditions.h(this.f81050d), (Drawable) Preconditions.h(this.f81048b)});
        } else {
            this.f81050d = null;
            layerDrawable = this.f81048b;
        }
        RippleDrawable rippleDrawable = new RippleDrawable(RippleUtils.d(colorStateList2), layerDrawable, null);
        this.f81049c = rippleDrawable;
        this.f81051e = rippleDrawable;
    }

    @Override // com.google.android.material.floatingactionbutton.FloatingActionButtonImpl
    void B() {
    }

    @Override // com.google.android.material.floatingactionbutton.FloatingActionButtonImpl
    void e0() {
    }

    @Override // com.google.android.material.floatingactionbutton.FloatingActionButtonImpl
    void F(int[] iArr) {
    }
}
