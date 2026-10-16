package com.google.android.material.transformation;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Pair;
import android.util.Property;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.ViewCompat;
import com.google.android.material.R;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.animation.AnimatorSetCompat;
import com.google.android.material.animation.ArgbEvaluatorCompat;
import com.google.android.material.animation.ChildrenAlphaProperty;
import com.google.android.material.animation.DrawableAlphaProperty;
import com.google.android.material.animation.MotionSpec;
import com.google.android.material.animation.MotionTiming;
import com.google.android.material.animation.Positioning;
import com.google.android.material.circularreveal.CircularRevealCompat;
import com.google.android.material.circularreveal.CircularRevealHelper;
import com.google.android.material.circularreveal.CircularRevealWidget;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.math.MathUtils;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
@Deprecated
public abstract class FabTransformationBehavior extends ExpandableTransformationBehavior {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Rect f82544c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final RectF f82545d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final RectF f82546f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final int[] f82547g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private float f82548h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private float f82549i;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    protected static class FabTransformationSpec {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public MotionSpec f82561a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Positioning f82562b;

        protected FabTransformationSpec() {
        }
    }

    public FabTransformationBehavior() {
        this.f82544c = new Rect();
        this.f82545d = new RectF();
        this.f82546f = new RectF();
        this.f82547g = new int[2];
    }

    private ViewGroup Q(View view) {
        View viewFindViewById = view.findViewById(R.id.R);
        return viewFindViewById != null ? l0(viewFindViewById) : ((view instanceof TransformationChildLayout) || (view instanceof TransformationChildCard)) ? l0(((ViewGroup) view).getChildAt(0)) : l0(view);
    }

    private void R(View view, FabTransformationSpec fabTransformationSpec, MotionTiming motionTiming, MotionTiming motionTiming2, float f3, float f4, float f5, float f6, RectF rectF) {
        float fY = Y(fabTransformationSpec, motionTiming, f3, f5);
        float fY2 = Y(fabTransformationSpec, motionTiming2, f4, f6);
        Rect rect = this.f82544c;
        view.getWindowVisibleDisplayFrame(rect);
        RectF rectF2 = this.f82545d;
        rectF2.set(rect);
        RectF rectF3 = this.f82546f;
        Z(view, rectF3);
        rectF3.offset(fY, fY2);
        rectF3.intersect(rectF2);
        rectF.set(rectF3);
    }

    private void S(View view, RectF rectF) {
        Z(view, rectF);
        rectF.offset(this.f82548h, this.f82549i);
    }

    private Pair T(float f3, float f4, boolean z2, FabTransformationSpec fabTransformationSpec) {
        MotionTiming motionTimingH;
        MotionTiming motionTimingH2;
        if (f3 == 0.0f || f4 == 0.0f) {
            motionTimingH = fabTransformationSpec.f82561a.h("translationXLinear");
            motionTimingH2 = fabTransformationSpec.f82561a.h("translationYLinear");
        } else if ((!z2 || f4 >= 0.0f) && (z2 || f4 <= 0.0f)) {
            motionTimingH = fabTransformationSpec.f82561a.h("translationXCurveDownwards");
            motionTimingH2 = fabTransformationSpec.f82561a.h("translationYCurveDownwards");
        } else {
            motionTimingH = fabTransformationSpec.f82561a.h("translationXCurveUpwards");
            motionTimingH2 = fabTransformationSpec.f82561a.h("translationYCurveUpwards");
        }
        return new Pair(motionTimingH, motionTimingH2);
    }

    private float U(View view, View view2, Positioning positioning) {
        RectF rectF = this.f82545d;
        RectF rectF2 = this.f82546f;
        S(view, rectF);
        Z(view2, rectF2);
        rectF2.offset(-W(view, view2, positioning), 0.0f);
        return rectF.centerX() - rectF2.left;
    }

    private float V(View view, View view2, Positioning positioning) {
        RectF rectF = this.f82545d;
        RectF rectF2 = this.f82546f;
        S(view, rectF);
        Z(view2, rectF2);
        rectF2.offset(0.0f, -X(view, view2, positioning));
        return rectF.centerY() - rectF2.top;
    }

    private float W(View view, View view2, Positioning positioning) {
        float fCenterX;
        float fCenterX2;
        float f3;
        RectF rectF = this.f82545d;
        RectF rectF2 = this.f82546f;
        S(view, rectF);
        Z(view2, rectF2);
        int i3 = positioning.f79869a & 7;
        if (i3 == 1) {
            fCenterX = rectF2.centerX();
            fCenterX2 = rectF.centerX();
        } else if (i3 == 3) {
            fCenterX = rectF2.left;
            fCenterX2 = rectF.left;
        } else {
            if (i3 != 5) {
                f3 = 0.0f;
                return f3 + positioning.f79870b;
            }
            fCenterX = rectF2.right;
            fCenterX2 = rectF.right;
        }
        f3 = fCenterX - fCenterX2;
        return f3 + positioning.f79870b;
    }

    private float X(View view, View view2, Positioning positioning) {
        float fCenterY;
        float fCenterY2;
        float f3;
        RectF rectF = this.f82545d;
        RectF rectF2 = this.f82546f;
        S(view, rectF);
        Z(view2, rectF2);
        int i3 = positioning.f79869a & 112;
        if (i3 == 16) {
            fCenterY = rectF2.centerY();
            fCenterY2 = rectF.centerY();
        } else if (i3 == 48) {
            fCenterY = rectF2.top;
            fCenterY2 = rectF.top;
        } else {
            if (i3 != 80) {
                f3 = 0.0f;
                return f3 + positioning.f79871c;
            }
            fCenterY = rectF2.bottom;
            fCenterY2 = rectF.bottom;
        }
        f3 = fCenterY - fCenterY2;
        return f3 + positioning.f79871c;
    }

    private float Y(FabTransformationSpec fabTransformationSpec, MotionTiming motionTiming, float f3, float f4) {
        long jC = motionTiming.c();
        long jD = motionTiming.d();
        MotionTiming motionTimingH = fabTransformationSpec.f82561a.h("expansion");
        return AnimationUtils.a(f3, f4, motionTiming.e().getInterpolation((((motionTimingH.c() + motionTimingH.d()) + 17) - jC) / jD));
    }

    private void Z(View view, RectF rectF) {
        rectF.set(0.0f, 0.0f, view.getWidth(), view.getHeight());
        view.getLocationInWindow(this.f82547g);
        rectF.offsetTo(r0[0], r0[1]);
        rectF.offset((int) (-view.getTranslationX()), (int) (-view.getTranslationY()));
    }

    private void a0(View view, View view2, boolean z2, boolean z3, FabTransformationSpec fabTransformationSpec, List list, List list2) {
        ViewGroup viewGroupQ;
        ObjectAnimator objectAnimatorOfFloat;
        if (view2 instanceof ViewGroup) {
            if (((view2 instanceof CircularRevealWidget) && CircularRevealHelper.f80497j == 0) || (viewGroupQ = Q(view2)) == null) {
                return;
            }
            if (z2) {
                if (!z3) {
                    ChildrenAlphaProperty.f79855a.set(viewGroupQ, Float.valueOf(0.0f));
                }
                objectAnimatorOfFloat = ObjectAnimator.ofFloat(viewGroupQ, (Property<ViewGroup, Float>) ChildrenAlphaProperty.f79855a, 1.0f);
            } else {
                objectAnimatorOfFloat = ObjectAnimator.ofFloat(viewGroupQ, (Property<ViewGroup, Float>) ChildrenAlphaProperty.f79855a, 0.0f);
            }
            fabTransformationSpec.f82561a.h("contentFade").a(objectAnimatorOfFloat);
            list.add(objectAnimatorOfFloat);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void b0(View view, View view2, boolean z2, boolean z3, FabTransformationSpec fabTransformationSpec, List list, List list2) {
        ObjectAnimator objectAnimatorOfInt;
        if (view2 instanceof CircularRevealWidget) {
            CircularRevealWidget circularRevealWidget = (CircularRevealWidget) view2;
            int iJ0 = j0(view);
            int i3 = 16777215 & iJ0;
            if (z2) {
                if (!z3) {
                    circularRevealWidget.setCircularRevealScrimColor(iJ0);
                }
                objectAnimatorOfInt = ObjectAnimator.ofInt(circularRevealWidget, (Property<CircularRevealWidget, Integer>) CircularRevealWidget.CircularRevealScrimColorProperty.f80512a, i3);
            } else {
                objectAnimatorOfInt = ObjectAnimator.ofInt(circularRevealWidget, (Property<CircularRevealWidget, Integer>) CircularRevealWidget.CircularRevealScrimColorProperty.f80512a, iJ0);
            }
            objectAnimatorOfInt.setEvaluator(ArgbEvaluatorCompat.b());
            fabTransformationSpec.f82561a.h("color").a(objectAnimatorOfInt);
            list.add(objectAnimatorOfInt);
        }
    }

    private void c0(View view, View view2, boolean z2, FabTransformationSpec fabTransformationSpec, List list) {
        float fW = W(view, view2, fabTransformationSpec.f82562b);
        float fX = X(view, view2, fabTransformationSpec.f82562b);
        Pair pairT = T(fW, fX, z2, fabTransformationSpec);
        MotionTiming motionTiming = (MotionTiming) pairT.first;
        MotionTiming motionTiming2 = (MotionTiming) pairT.second;
        Property property = View.TRANSLATION_X;
        if (!z2) {
            fW = this.f82548h;
        }
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(view, (Property<View, Float>) property, fW);
        Property property2 = View.TRANSLATION_Y;
        if (!z2) {
            fX = this.f82549i;
        }
        ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(view, (Property<View, Float>) property2, fX);
        motionTiming.a(objectAnimatorOfFloat);
        motionTiming2.a(objectAnimatorOfFloat2);
        list.add(objectAnimatorOfFloat);
        list.add(objectAnimatorOfFloat2);
    }

    private void d0(View view, View view2, boolean z2, boolean z3, FabTransformationSpec fabTransformationSpec, List list, List list2) {
        ObjectAnimator objectAnimatorOfFloat;
        float fT = ViewCompat.t(view2) - ViewCompat.t(view);
        if (z2) {
            if (!z3) {
                view2.setTranslationZ(-fT);
            }
            objectAnimatorOfFloat = ObjectAnimator.ofFloat(view2, (Property<View, Float>) View.TRANSLATION_Z, 0.0f);
        } else {
            objectAnimatorOfFloat = ObjectAnimator.ofFloat(view2, (Property<View, Float>) View.TRANSLATION_Z, -fT);
        }
        fabTransformationSpec.f82561a.h("elevation").a(objectAnimatorOfFloat);
        list.add(objectAnimatorOfFloat);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void e0(View view, View view2, boolean z2, boolean z3, FabTransformationSpec fabTransformationSpec, float f3, float f4, List list, List list2) {
        Animator animatorA;
        if (view2 instanceof CircularRevealWidget) {
            final CircularRevealWidget circularRevealWidget = (CircularRevealWidget) view2;
            float fU = U(view, view2, fabTransformationSpec.f82562b);
            float fV = V(view, view2, fabTransformationSpec.f82562b);
            ((FloatingActionButton) view).i(this.f82544c);
            float fWidth = this.f82544c.width() / 2.0f;
            MotionTiming motionTimingH = fabTransformationSpec.f82561a.h("expansion");
            if (z2) {
                if (!z3) {
                    circularRevealWidget.setRevealInfo(new CircularRevealWidget.RevealInfo(fU, fV, fWidth));
                }
                if (z3) {
                    fWidth = circularRevealWidget.getRevealInfo().f80515c;
                }
                animatorA = CircularRevealCompat.a(circularRevealWidget, fU, fV, MathUtils.b(fU, fV, 0.0f, 0.0f, f3, f4));
                animatorA.addListener(new AnimatorListenerAdapter() { // from class: com.google.android.material.transformation.FabTransformationBehavior.4
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        CircularRevealWidget.RevealInfo revealInfo = circularRevealWidget.getRevealInfo();
                        revealInfo.f80515c = Float.MAX_VALUE;
                        circularRevealWidget.setRevealInfo(revealInfo);
                    }
                });
                h0(view2, motionTimingH.c(), (int) fU, (int) fV, fWidth, list);
            } else {
                float f5 = circularRevealWidget.getRevealInfo().f80515c;
                Animator animatorA2 = CircularRevealCompat.a(circularRevealWidget, fU, fV, fWidth);
                int i3 = (int) fU;
                int i4 = (int) fV;
                h0(view2, motionTimingH.c(), i3, i4, f5, list);
                g0(view2, motionTimingH.c(), motionTimingH.d(), fabTransformationSpec.f82561a.i(), i3, i4, fWidth, list);
                animatorA = animatorA2;
            }
            motionTimingH.a(animatorA);
            list.add(animatorA);
            list2.add(CircularRevealCompat.b(circularRevealWidget));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void f0(View view, final View view2, boolean z2, boolean z3, FabTransformationSpec fabTransformationSpec, List list, List list2) {
        ObjectAnimator objectAnimatorOfInt;
        if ((view2 instanceof CircularRevealWidget) && (view instanceof ImageView)) {
            final CircularRevealWidget circularRevealWidget = (CircularRevealWidget) view2;
            final Drawable drawable = ((ImageView) view).getDrawable();
            if (drawable == null) {
                return;
            }
            drawable.mutate();
            if (z2) {
                if (!z3) {
                    drawable.setAlpha(255);
                }
                objectAnimatorOfInt = ObjectAnimator.ofInt(drawable, (Property<Drawable, Integer>) DrawableAlphaProperty.f79856b, 0);
            } else {
                objectAnimatorOfInt = ObjectAnimator.ofInt(drawable, (Property<Drawable, Integer>) DrawableAlphaProperty.f79856b, 255);
            }
            objectAnimatorOfInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.google.android.material.transformation.FabTransformationBehavior.2
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    view2.invalidate();
                }
            });
            fabTransformationSpec.f82561a.h("iconFade").a(objectAnimatorOfInt);
            list.add(objectAnimatorOfInt);
            list2.add(new AnimatorListenerAdapter() { // from class: com.google.android.material.transformation.FabTransformationBehavior.3
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    circularRevealWidget.setCircularRevealOverlayDrawable(null);
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    circularRevealWidget.setCircularRevealOverlayDrawable(drawable);
                }
            });
        }
    }

    private void g0(View view, long j3, long j4, long j5, int i3, int i4, float f3, List list) {
        long j6 = j3 + j4;
        if (j6 < j5) {
            Animator animatorCreateCircularReveal = ViewAnimationUtils.createCircularReveal(view, i3, i4, f3, f3);
            animatorCreateCircularReveal.setStartDelay(j6);
            animatorCreateCircularReveal.setDuration(j5 - j6);
            list.add(animatorCreateCircularReveal);
        }
    }

    private void h0(View view, long j3, int i3, int i4, float f3, List list) {
        if (j3 > 0) {
            Animator animatorCreateCircularReveal = ViewAnimationUtils.createCircularReveal(view, i3, i4, f3, f3);
            animatorCreateCircularReveal.setStartDelay(0L);
            animatorCreateCircularReveal.setDuration(j3);
            list.add(animatorCreateCircularReveal);
        }
    }

    private void i0(View view, View view2, boolean z2, boolean z3, FabTransformationSpec fabTransformationSpec, List list, List list2, RectF rectF) {
        MotionTiming motionTiming;
        MotionTiming motionTiming2;
        ObjectAnimator objectAnimatorOfFloat;
        ObjectAnimator objectAnimatorOfFloat2;
        float fW = W(view, view2, fabTransformationSpec.f82562b);
        float fX = X(view, view2, fabTransformationSpec.f82562b);
        Pair pairT = T(fW, fX, z2, fabTransformationSpec);
        MotionTiming motionTiming3 = (MotionTiming) pairT.first;
        MotionTiming motionTiming4 = (MotionTiming) pairT.second;
        if (z2) {
            if (!z3) {
                view2.setTranslationX(-fW);
                view2.setTranslationY(-fX);
            }
            objectAnimatorOfFloat = ObjectAnimator.ofFloat(view2, (Property<View, Float>) View.TRANSLATION_X, 0.0f);
            objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(view2, (Property<View, Float>) View.TRANSLATION_Y, 0.0f);
            motionTiming = motionTiming4;
            motionTiming2 = motionTiming3;
            R(view2, fabTransformationSpec, motionTiming2, motionTiming, -fW, -fX, 0.0f, 0.0f, rectF);
        } else {
            motionTiming = motionTiming4;
            motionTiming2 = motionTiming3;
            objectAnimatorOfFloat = ObjectAnimator.ofFloat(view2, (Property<View, Float>) View.TRANSLATION_X, -fW);
            objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(view2, (Property<View, Float>) View.TRANSLATION_Y, -fX);
        }
        motionTiming2.a(objectAnimatorOfFloat);
        motionTiming.a(objectAnimatorOfFloat2);
        list.add(objectAnimatorOfFloat);
        list.add(objectAnimatorOfFloat2);
    }

    private int j0(View view) {
        ColorStateList colorStateListQ = ViewCompat.q(view);
        if (colorStateListQ != null) {
            return colorStateListQ.getColorForState(view.getDrawableState(), colorStateListQ.getDefaultColor());
        }
        return 0;
    }

    private ViewGroup l0(View view) {
        if (view instanceof ViewGroup) {
            return (ViewGroup) view;
        }
        return null;
    }

    @Override // com.google.android.material.transformation.ExpandableTransformationBehavior
    protected AnimatorSet P(final View view, final View view2, final boolean z2, boolean z3) {
        FabTransformationSpec fabTransformationSpecK0 = k0(view2.getContext(), z2);
        if (z2) {
            this.f82548h = view.getTranslationX();
            this.f82549i = view.getTranslationY();
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        d0(view, view2, z2, z3, fabTransformationSpecK0, arrayList, arrayList2);
        RectF rectF = this.f82545d;
        i0(view, view2, z2, z3, fabTransformationSpecK0, arrayList, arrayList2, rectF);
        float fWidth = rectF.width();
        float fHeight = rectF.height();
        c0(view, view2, z2, fabTransformationSpecK0, arrayList);
        f0(view, view2, z2, z3, fabTransformationSpecK0, arrayList, arrayList2);
        e0(view, view2, z2, z3, fabTransformationSpecK0, fWidth, fHeight, arrayList, arrayList2);
        b0(view, view2, z2, z3, fabTransformationSpecK0, arrayList, arrayList2);
        a0(view, view2, z2, z3, fabTransformationSpecK0, arrayList, arrayList2);
        AnimatorSet animatorSet = new AnimatorSet();
        AnimatorSetCompat.a(animatorSet, arrayList);
        animatorSet.addListener(new AnimatorListenerAdapter() { // from class: com.google.android.material.transformation.FabTransformationBehavior.1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (z2) {
                    return;
                }
                view2.setVisibility(4);
                view.setAlpha(1.0f);
                view.setVisibility(0);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                if (z2) {
                    view2.setVisibility(0);
                    view.setAlpha(0.0f);
                    view.setVisibility(4);
                }
            }
        });
        int size = arrayList2.size();
        for (int i3 = 0; i3 < size; i3++) {
            animatorSet.addListener((Animator.AnimatorListener) arrayList2.get(i3));
        }
        return animatorSet;
    }

    @Override // com.google.android.material.transformation.ExpandableBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean k(CoordinatorLayout coordinatorLayout, View view, View view2) {
        if (view.getVisibility() == 8) {
            throw new IllegalStateException("This behavior cannot be attached to a GONE view. Set the view to INVISIBLE instead.");
        }
        if (!(view2 instanceof FloatingActionButton)) {
            return false;
        }
        int expandedComponentIdHint = ((FloatingActionButton) view2).getExpandedComponentIdHint();
        return expandedComponentIdHint == 0 || expandedComponentIdHint == view.getId();
    }

    protected abstract FabTransformationSpec k0(Context context, boolean z2);

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public void m(CoordinatorLayout.LayoutParams layoutParams) {
        if (layoutParams.f33470h == 0) {
            layoutParams.f33470h = 80;
        }
    }

    public FabTransformationBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f82544c = new Rect();
        this.f82545d = new RectF();
        this.f82546f = new RectF();
        this.f82547g = new int[2];
    }
}
