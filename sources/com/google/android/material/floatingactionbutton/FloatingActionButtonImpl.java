package com.google.android.material.floatingactionbutton;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.FloatEvaluator;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.content.res.ColorStateList;
import android.graphics.Matrix;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.LayerDrawable;
import android.util.Property;
import android.view.View;
import android.view.ViewTreeObserver;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.util.Preconditions;
import androidx.core.view.ViewCompat;
import com.google.android.material.R;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.animation.AnimatorSetCompat;
import com.google.android.material.animation.ImageMatrixProperty;
import com.google.android.material.animation.MatrixEvaluator;
import com.google.android.material.animation.MotionSpec;
import com.google.android.material.internal.StateListAnimator;
import com.google.android.material.motion.MotionUtils;
import com.google.android.material.ripple.RippleDrawableCompat;
import com.google.android.material.ripple.RippleUtils;
import com.google.android.material.shadow.ShadowViewDelegate;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.MaterialShapeUtils;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.shape.Shapeable;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
class FloatingActionButtonImpl {
    static final TimeInterpolator D = AnimationUtils.f79851c;
    private static final int E = R.attr.V;
    private static final int F = R.attr.f79487f0;
    private static final int G = R.attr.W;
    private static final int H = R.attr.f79483d0;
    static final int[] I = {android.R.attr.state_pressed, android.R.attr.state_enabled};
    static final int[] J = {android.R.attr.state_hovered, android.R.attr.state_focused, android.R.attr.state_enabled};
    static final int[] K = {android.R.attr.state_focused, android.R.attr.state_enabled};
    static final int[] L = {android.R.attr.state_hovered, android.R.attr.state_enabled};
    static final int[] M = {android.R.attr.state_enabled};
    static final int[] N = new int[0];
    private ViewTreeObserver.OnPreDrawListener C;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    ShapeAppearanceModel f81047a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    MaterialShapeDrawable f81048b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    Drawable f81049c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    BorderDrawable f81050d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    Drawable f81051e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    boolean f81052f;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    float f81054h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    float f81055i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    float f81056j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    int f81057k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final StateListAnimator f81058l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private Animator f81059m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private MotionSpec f81060n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private MotionSpec f81061o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private float f81062p;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private int f81064r;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private ArrayList f81066t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private ArrayList f81067u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private ArrayList f81068v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    final FloatingActionButton f81069w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    final ShadowViewDelegate f81070x;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    boolean f81053g = true;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private float f81063q = 1.0f;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private int f81065s = 0;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private final Rect f81071y = new Rect();

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private final RectF f81072z = new RectF();
    private final RectF A = new RectF();
    private final Matrix B = new Matrix();

    /* JADX INFO: renamed from: com.google.android.material.floatingactionbutton.FloatingActionButtonImpl$5, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class AnonymousClass5 implements TypeEvaluator<Float> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        FloatEvaluator f81090a;

        @Override // android.animation.TypeEvaluator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Float evaluate(float f3, Float f4, Float f5) {
            float fFloatValue = this.f81090a.evaluate(f3, (Number) f4, (Number) f5).floatValue();
            if (fFloatValue < 0.1f) {
                fFloatValue = 0.0f;
            }
            return Float.valueOf(fFloatValue);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private class DisabledElevationAnimation extends ShadowAnimatorImpl {
        DisabledElevationAnimation() {
            super();
        }

        @Override // com.google.android.material.floatingactionbutton.FloatingActionButtonImpl.ShadowAnimatorImpl
        protected float a() {
            return 0.0f;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private class ElevateToHoveredFocusedTranslationZAnimation extends ShadowAnimatorImpl {
        ElevateToHoveredFocusedTranslationZAnimation() {
            super();
        }

        @Override // com.google.android.material.floatingactionbutton.FloatingActionButtonImpl.ShadowAnimatorImpl
        protected float a() {
            FloatingActionButtonImpl floatingActionButtonImpl = FloatingActionButtonImpl.this;
            return floatingActionButtonImpl.f81054h + floatingActionButtonImpl.f81055i;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private class ElevateToPressedTranslationZAnimation extends ShadowAnimatorImpl {
        ElevateToPressedTranslationZAnimation() {
            super();
        }

        @Override // com.google.android.material.floatingactionbutton.FloatingActionButtonImpl.ShadowAnimatorImpl
        protected float a() {
            FloatingActionButtonImpl floatingActionButtonImpl = FloatingActionButtonImpl.this;
            return floatingActionButtonImpl.f81054h + floatingActionButtonImpl.f81056j;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    interface InternalTransformationCallback {
        void a();

        void b();
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    interface InternalVisibilityChangedListener {
        void a();

        void b();
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private class ResetElevationAnimation extends ShadowAnimatorImpl {
        ResetElevationAnimation() {
            super();
        }

        @Override // com.google.android.material.floatingactionbutton.FloatingActionButtonImpl.ShadowAnimatorImpl
        protected float a() {
            return FloatingActionButtonImpl.this.f81054h;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private abstract class ShadowAnimatorImpl extends AnimatorListenerAdapter implements ValueAnimator.AnimatorUpdateListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private boolean f81096a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private float f81097b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private float f81098c;

        private ShadowAnimatorImpl() {
        }

        protected abstract float a();

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            FloatingActionButtonImpl.this.h0((int) this.f81098c);
            this.f81096a = false;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            if (!this.f81096a) {
                MaterialShapeDrawable materialShapeDrawable = FloatingActionButtonImpl.this.f81048b;
                this.f81097b = materialShapeDrawable == null ? 0.0f : materialShapeDrawable.w();
                this.f81098c = a();
                this.f81096a = true;
            }
            FloatingActionButtonImpl floatingActionButtonImpl = FloatingActionButtonImpl.this;
            float f3 = this.f81097b;
            floatingActionButtonImpl.h0((int) (f3 + ((this.f81098c - f3) * valueAnimator.getAnimatedFraction())));
        }
    }

    FloatingActionButtonImpl(FloatingActionButton floatingActionButton, ShadowViewDelegate shadowViewDelegate) {
        this.f81069w = floatingActionButton;
        this.f81070x = shadowViewDelegate;
        StateListAnimator stateListAnimator = new StateListAnimator();
        this.f81058l = stateListAnimator;
        stateListAnimator.a(I, k(new ElevateToPressedTranslationZAnimation()));
        stateListAnimator.a(J, k(new ElevateToHoveredFocusedTranslationZAnimation()));
        stateListAnimator.a(K, k(new ElevateToHoveredFocusedTranslationZAnimation()));
        stateListAnimator.a(L, k(new ElevateToHoveredFocusedTranslationZAnimation()));
        stateListAnimator.a(M, k(new ResetElevationAnimation()));
        stateListAnimator.a(N, k(new DisabledElevationAnimation()));
        this.f81062p = floatingActionButton.getRotation();
    }

    private boolean b0() {
        return ViewCompat.R(this.f81069w) && !this.f81069w.isInEditMode();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(float f3, Matrix matrix) {
        matrix.reset();
        if (this.f81069w.getDrawable() == null || this.f81064r == 0) {
            return;
        }
        RectF rectF = this.f81072z;
        RectF rectF2 = this.A;
        rectF.set(0.0f, 0.0f, r0.getIntrinsicWidth(), r0.getIntrinsicHeight());
        int i3 = this.f81064r;
        rectF2.set(0.0f, 0.0f, i3, i3);
        matrix.setRectToRect(rectF, rectF2, Matrix.ScaleToFit.CENTER);
        int i4 = this.f81064r;
        matrix.postScale(f3, f3, i4 / 2.0f, i4 / 2.0f);
    }

    private AnimatorSet i(MotionSpec motionSpec, float f3, float f4, float f5) {
        ArrayList arrayList = new ArrayList();
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.f81069w, (Property<FloatingActionButton, Float>) View.ALPHA, f3);
        motionSpec.h("opacity").a(objectAnimatorOfFloat);
        arrayList.add(objectAnimatorOfFloat);
        ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(this.f81069w, (Property<FloatingActionButton, Float>) View.SCALE_X, f4);
        motionSpec.h("scale").a(objectAnimatorOfFloat2);
        i0(objectAnimatorOfFloat2);
        arrayList.add(objectAnimatorOfFloat2);
        ObjectAnimator objectAnimatorOfFloat3 = ObjectAnimator.ofFloat(this.f81069w, (Property<FloatingActionButton, Float>) View.SCALE_Y, f4);
        motionSpec.h("scale").a(objectAnimatorOfFloat3);
        i0(objectAnimatorOfFloat3);
        arrayList.add(objectAnimatorOfFloat3);
        h(f5, this.B);
        ObjectAnimator objectAnimatorOfObject = ObjectAnimator.ofObject(this.f81069w, new ImageMatrixProperty(), new MatrixEvaluator() { // from class: com.google.android.material.floatingactionbutton.FloatingActionButtonImpl.3
            @Override // com.google.android.material.animation.MatrixEvaluator, android.animation.TypeEvaluator
            /* JADX INFO: renamed from: a */
            public Matrix evaluate(float f6, Matrix matrix, Matrix matrix2) {
                FloatingActionButtonImpl.this.f81063q = f6;
                return super.evaluate(f6, matrix, matrix2);
            }
        }, new Matrix(this.B));
        motionSpec.h("iconScale").a(objectAnimatorOfObject);
        arrayList.add(objectAnimatorOfObject);
        AnimatorSet animatorSet = new AnimatorSet();
        AnimatorSetCompat.a(animatorSet, arrayList);
        return animatorSet;
    }

    private AnimatorSet j(final float f3, final float f4, final float f5, int i3, int i4) {
        AnimatorSet animatorSet = new AnimatorSet();
        ArrayList arrayList = new ArrayList();
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        final float alpha = this.f81069w.getAlpha();
        final float scaleX = this.f81069w.getScaleX();
        final float scaleY = this.f81069w.getScaleY();
        final float f6 = this.f81063q;
        final Matrix matrix = new Matrix(this.B);
        valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.google.android.material.floatingactionbutton.FloatingActionButtonImpl.4
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                FloatingActionButtonImpl.this.f81069w.setAlpha(AnimationUtils.b(alpha, f3, 0.0f, 0.2f, fFloatValue));
                FloatingActionButtonImpl.this.f81069w.setScaleX(AnimationUtils.a(scaleX, f4, fFloatValue));
                FloatingActionButtonImpl.this.f81069w.setScaleY(AnimationUtils.a(scaleY, f4, fFloatValue));
                FloatingActionButtonImpl.this.f81063q = AnimationUtils.a(f6, f5, fFloatValue);
                FloatingActionButtonImpl.this.h(AnimationUtils.a(f6, f5, fFloatValue), matrix);
                FloatingActionButtonImpl.this.f81069w.setImageMatrix(matrix);
            }
        });
        arrayList.add(valueAnimatorOfFloat);
        AnimatorSetCompat.a(animatorSet, arrayList);
        animatorSet.setDuration(MotionUtils.f(this.f81069w.getContext(), i3, this.f81069w.getContext().getResources().getInteger(R.integer.f79668b)));
        animatorSet.setInterpolator(MotionUtils.g(this.f81069w.getContext(), i4, AnimationUtils.f79850b));
        return animatorSet;
    }

    private ValueAnimator k(ShadowAnimatorImpl shadowAnimatorImpl) {
        ValueAnimator valueAnimator = new ValueAnimator();
        valueAnimator.setInterpolator(D);
        valueAnimator.setDuration(100L);
        valueAnimator.addListener(shadowAnimatorImpl);
        valueAnimator.addUpdateListener(shadowAnimatorImpl);
        valueAnimator.setFloatValues(0.0f, 1.0f);
        return valueAnimator;
    }

    private ViewTreeObserver.OnPreDrawListener r() {
        if (this.C == null) {
            this.C = new ViewTreeObserver.OnPreDrawListener() { // from class: com.google.android.material.floatingactionbutton.FloatingActionButtonImpl.6
                @Override // android.view.ViewTreeObserver.OnPreDrawListener
                public boolean onPreDraw() {
                    FloatingActionButtonImpl.this.I();
                    return true;
                }
            };
        }
        return this.C;
    }

    boolean A() {
        return this.f81069w.getVisibility() != 0 ? this.f81065s == 2 : this.f81065s != 1;
    }

    void B() {
        this.f81058l.c();
    }

    void C() {
        MaterialShapeDrawable materialShapeDrawable = this.f81048b;
        if (materialShapeDrawable != null) {
            MaterialShapeUtils.f(this.f81069w, materialShapeDrawable);
        }
        if (L()) {
            this.f81069w.getViewTreeObserver().addOnPreDrawListener(r());
        }
    }

    void E() {
        ViewTreeObserver viewTreeObserver = this.f81069w.getViewTreeObserver();
        ViewTreeObserver.OnPreDrawListener onPreDrawListener = this.C;
        if (onPreDrawListener != null) {
            viewTreeObserver.removeOnPreDrawListener(onPreDrawListener);
            this.C = null;
        }
    }

    void F(int[] iArr) {
        this.f81058l.d(iArr);
    }

    void G(float f3, float f4, float f5) {
        B();
        g0();
        h0(f3);
    }

    void H(Rect rect) {
        Preconditions.i(this.f81051e, "Didn't initialize content background");
        if (!a0()) {
            this.f81070x.a(this.f81051e);
        } else {
            this.f81070x.a(new InsetDrawable(this.f81051e, rect.left, rect.top, rect.right, rect.bottom));
        }
    }

    void I() {
        float rotation = this.f81069w.getRotation();
        if (this.f81062p != rotation) {
            this.f81062p = rotation;
            e0();
        }
    }

    void J() {
        ArrayList arrayList = this.f81068v;
        if (arrayList != null) {
            int size = arrayList.size();
            int i3 = 0;
            while (i3 < size) {
                Object obj = arrayList.get(i3);
                i3++;
                ((InternalTransformationCallback) obj).b();
            }
        }
    }

    void K() {
        ArrayList arrayList = this.f81068v;
        if (arrayList != null) {
            int size = arrayList.size();
            int i3 = 0;
            while (i3 < size) {
                Object obj = arrayList.get(i3);
                i3++;
                ((InternalTransformationCallback) obj).a();
            }
        }
    }

    boolean L() {
        return true;
    }

    void M(ColorStateList colorStateList) {
        MaterialShapeDrawable materialShapeDrawable = this.f81048b;
        if (materialShapeDrawable != null) {
            materialShapeDrawable.setTintList(colorStateList);
        }
        BorderDrawable borderDrawable = this.f81050d;
        if (borderDrawable != null) {
            borderDrawable.c(colorStateList);
        }
    }

    void N(PorterDuff.Mode mode) {
        MaterialShapeDrawable materialShapeDrawable = this.f81048b;
        if (materialShapeDrawable != null) {
            materialShapeDrawable.setTintMode(mode);
        }
    }

    final void O(float f3) {
        if (this.f81054h != f3) {
            this.f81054h = f3;
            G(f3, this.f81055i, this.f81056j);
        }
    }

    void P(boolean z2) {
        this.f81052f = z2;
    }

    final void Q(MotionSpec motionSpec) {
        this.f81061o = motionSpec;
    }

    final void R(float f3) {
        if (this.f81055i != f3) {
            this.f81055i = f3;
            G(this.f81054h, f3, this.f81056j);
        }
    }

    final void S(float f3) {
        this.f81063q = f3;
        Matrix matrix = this.B;
        h(f3, matrix);
        this.f81069w.setImageMatrix(matrix);
    }

    final void T(int i3) {
        if (this.f81064r != i3) {
            this.f81064r = i3;
            f0();
        }
    }

    void U(int i3) {
        this.f81057k = i3;
    }

    final void V(float f3) {
        if (this.f81056j != f3) {
            this.f81056j = f3;
            G(this.f81054h, this.f81055i, f3);
        }
    }

    void W(ColorStateList colorStateList) {
        Drawable drawable = this.f81049c;
        if (drawable != null) {
            DrawableCompat.o(drawable, RippleUtils.d(colorStateList));
        }
    }

    void X(boolean z2) {
        this.f81053g = z2;
        g0();
    }

    final void Y(ShapeAppearanceModel shapeAppearanceModel) {
        this.f81047a = shapeAppearanceModel;
        MaterialShapeDrawable materialShapeDrawable = this.f81048b;
        if (materialShapeDrawable != null) {
            materialShapeDrawable.setShapeAppearanceModel(shapeAppearanceModel);
        }
        Object obj = this.f81049c;
        if (obj instanceof Shapeable) {
            ((Shapeable) obj).setShapeAppearanceModel(shapeAppearanceModel);
        }
        BorderDrawable borderDrawable = this.f81050d;
        if (borderDrawable != null) {
            borderDrawable.f(shapeAppearanceModel);
        }
    }

    final void Z(MotionSpec motionSpec) {
        this.f81060n = motionSpec;
    }

    boolean a0() {
        return true;
    }

    final boolean c0() {
        return !this.f81052f || this.f81069w.getSizeDimension() >= this.f81057k;
    }

    void d0(final InternalVisibilityChangedListener internalVisibilityChangedListener, final boolean z2) {
        FloatingActionButtonImpl floatingActionButtonImpl;
        AnimatorSet animatorSetJ;
        if (A()) {
            return;
        }
        Animator animator = this.f81059m;
        if (animator != null) {
            animator.cancel();
        }
        int i3 = 0;
        boolean z3 = this.f81060n == null;
        if (!b0()) {
            this.f81069w.b(0, z2);
            this.f81069w.setAlpha(1.0f);
            this.f81069w.setScaleY(1.0f);
            this.f81069w.setScaleX(1.0f);
            S(1.0f);
            if (internalVisibilityChangedListener != null) {
                internalVisibilityChangedListener.a();
                return;
            }
            return;
        }
        if (this.f81069w.getVisibility() != 0) {
            this.f81069w.setAlpha(0.0f);
            this.f81069w.setScaleY(z3 ? 0.4f : 0.0f);
            this.f81069w.setScaleX(z3 ? 0.4f : 0.0f);
            S(z3 ? 0.4f : 0.0f);
        }
        MotionSpec motionSpec = this.f81060n;
        if (motionSpec != null) {
            animatorSetJ = i(motionSpec, 1.0f, 1.0f, 1.0f);
            floatingActionButtonImpl = this;
        } else {
            floatingActionButtonImpl = this;
            animatorSetJ = floatingActionButtonImpl.j(1.0f, 1.0f, 1.0f, E, F);
        }
        animatorSetJ.addListener(new AnimatorListenerAdapter() { // from class: com.google.android.material.floatingactionbutton.FloatingActionButtonImpl.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator2) {
                FloatingActionButtonImpl.this.f81065s = 0;
                FloatingActionButtonImpl.this.f81059m = null;
                InternalVisibilityChangedListener internalVisibilityChangedListener2 = internalVisibilityChangedListener;
                if (internalVisibilityChangedListener2 != null) {
                    internalVisibilityChangedListener2.a();
                }
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator2) {
                FloatingActionButtonImpl.this.f81069w.b(0, z2);
                FloatingActionButtonImpl.this.f81065s = 2;
                FloatingActionButtonImpl.this.f81059m = animator2;
            }
        });
        ArrayList arrayList = floatingActionButtonImpl.f81066t;
        if (arrayList != null) {
            int size = arrayList.size();
            while (i3 < size) {
                Object obj = arrayList.get(i3);
                i3++;
                animatorSetJ.addListener((Animator.AnimatorListener) obj);
            }
        }
        animatorSetJ.start();
    }

    public void e(Animator.AnimatorListener animatorListener) {
        if (this.f81067u == null) {
            this.f81067u = new ArrayList();
        }
        this.f81067u.add(animatorListener);
    }

    void e0() {
        MaterialShapeDrawable materialShapeDrawable = this.f81048b;
        if (materialShapeDrawable != null) {
            materialShapeDrawable.g0((int) this.f81062p);
        }
    }

    void f(Animator.AnimatorListener animatorListener) {
        if (this.f81066t == null) {
            this.f81066t = new ArrayList();
        }
        this.f81066t.add(animatorListener);
    }

    final void f0() {
        S(this.f81063q);
    }

    void g(InternalTransformationCallback internalTransformationCallback) {
        if (this.f81068v == null) {
            this.f81068v = new ArrayList();
        }
        this.f81068v.add(internalTransformationCallback);
    }

    final void g0() {
        Rect rect = this.f81071y;
        s(rect);
        H(rect);
        this.f81070x.b(rect.left, rect.top, rect.right, rect.bottom);
    }

    void h0(float f3) {
        MaterialShapeDrawable materialShapeDrawable = this.f81048b;
        if (materialShapeDrawable != null) {
            materialShapeDrawable.Z(f3);
        }
    }

    MaterialShapeDrawable l() {
        return new MaterialShapeDrawable((ShapeAppearanceModel) Preconditions.h(this.f81047a));
    }

    final Drawable m() {
        return this.f81051e;
    }

    float n() {
        return this.f81054h;
    }

    boolean o() {
        return this.f81052f;
    }

    final MotionSpec p() {
        return this.f81061o;
    }

    float q() {
        return this.f81055i;
    }

    void s(Rect rect) {
        int iW = w();
        int iMax = Math.max(iW, (int) Math.ceil(this.f81053g ? n() + this.f81056j : 0.0f));
        int iMax2 = Math.max(iW, (int) Math.ceil(r1 * 1.5f));
        rect.set(iMax, iMax2, iMax, iMax2);
    }

    float t() {
        return this.f81056j;
    }

    final ShapeAppearanceModel u() {
        return this.f81047a;
    }

    final MotionSpec v() {
        return this.f81060n;
    }

    int w() {
        if (this.f81052f) {
            return Math.max((this.f81057k - this.f81069w.getSizeDimension()) / 2, 0);
        }
        return 0;
    }

    void x(final InternalVisibilityChangedListener internalVisibilityChangedListener, final boolean z2) {
        FloatingActionButtonImpl floatingActionButtonImpl;
        AnimatorSet animatorSetJ;
        if (z()) {
            return;
        }
        Animator animator = this.f81059m;
        if (animator != null) {
            animator.cancel();
        }
        if (!b0()) {
            this.f81069w.b(z2 ? 8 : 4, z2);
            if (internalVisibilityChangedListener != null) {
                internalVisibilityChangedListener.b();
                return;
            }
            return;
        }
        MotionSpec motionSpec = this.f81061o;
        if (motionSpec != null) {
            animatorSetJ = i(motionSpec, 0.0f, 0.0f, 0.0f);
            floatingActionButtonImpl = this;
        } else {
            floatingActionButtonImpl = this;
            animatorSetJ = floatingActionButtonImpl.j(0.0f, 0.4f, 0.4f, G, H);
        }
        animatorSetJ.addListener(new AnimatorListenerAdapter() { // from class: com.google.android.material.floatingactionbutton.FloatingActionButtonImpl.1

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private boolean f81073a;

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator2) {
                this.f81073a = true;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator2) {
                FloatingActionButtonImpl.this.f81065s = 0;
                FloatingActionButtonImpl.this.f81059m = null;
                if (this.f81073a) {
                    return;
                }
                FloatingActionButton floatingActionButton = FloatingActionButtonImpl.this.f81069w;
                boolean z3 = z2;
                floatingActionButton.b(z3 ? 8 : 4, z3);
                InternalVisibilityChangedListener internalVisibilityChangedListener2 = internalVisibilityChangedListener;
                if (internalVisibilityChangedListener2 != null) {
                    internalVisibilityChangedListener2.b();
                }
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator2) {
                FloatingActionButtonImpl.this.f81069w.b(0, z2);
                FloatingActionButtonImpl.this.f81065s = 1;
                FloatingActionButtonImpl.this.f81059m = animator2;
                this.f81073a = false;
            }
        });
        ArrayList arrayList = floatingActionButtonImpl.f81067u;
        if (arrayList != null) {
            int size = arrayList.size();
            int i3 = 0;
            while (i3 < size) {
                Object obj = arrayList.get(i3);
                i3++;
                animatorSetJ.addListener((Animator.AnimatorListener) obj);
            }
        }
        animatorSetJ.start();
    }

    void y(ColorStateList colorStateList, PorterDuff.Mode mode, ColorStateList colorStateList2, int i3) {
        MaterialShapeDrawable materialShapeDrawableL = l();
        this.f81048b = materialShapeDrawableL;
        materialShapeDrawableL.setTintList(colorStateList);
        if (mode != null) {
            this.f81048b.setTintMode(mode);
        }
        this.f81048b.f0(-12303292);
        this.f81048b.P(this.f81069w.getContext());
        RippleDrawableCompat rippleDrawableCompat = new RippleDrawableCompat(this.f81048b.getShapeAppearanceModel());
        rippleDrawableCompat.setTintList(RippleUtils.d(colorStateList2));
        this.f81049c = rippleDrawableCompat;
        this.f81051e = new LayerDrawable(new Drawable[]{(Drawable) Preconditions.h(this.f81048b), rippleDrawableCompat});
    }

    boolean z() {
        return this.f81069w.getVisibility() == 0 ? this.f81065s == 1 : this.f81065s != 2;
    }

    void D() {
    }

    private void i0(ObjectAnimator objectAnimator) {
    }
}
