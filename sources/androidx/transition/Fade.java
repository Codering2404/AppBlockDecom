package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import androidx.transition.Transition;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public class Fade extends Visibility {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class FadeAnimatorListener extends AnimatorListenerAdapter implements Transition.TransitionListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final View f53408a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private boolean f53409b = false;

        FadeAnimatorListener(View view) {
            this.f53408a = view;
        }

        @Override // androidx.transition.Transition.TransitionListener
        public void b(Transition transition) {
            this.f53408a.setTag(R.id.f53461h, null);
        }

        @Override // androidx.transition.Transition.TransitionListener
        public void d(Transition transition) {
            this.f53408a.setTag(R.id.f53461h, Float.valueOf(this.f53408a.getVisibility() == 0 ? ViewUtils.b(this.f53408a) : 0.0f));
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            ViewUtils.f(this.f53408a, 1.0f);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            onAnimationEnd(animator, false);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            if (this.f53408a.hasOverlappingRendering() && this.f53408a.getLayerType() == 0) {
                this.f53409b = true;
                this.f53408a.setLayerType(2, null);
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator, boolean z2) {
            if (this.f53409b) {
                this.f53408a.setLayerType(0, null);
            }
            if (z2) {
                return;
            }
            ViewUtils.f(this.f53408a, 1.0f);
            ViewUtils.a(this.f53408a);
        }

        @Override // androidx.transition.Transition.TransitionListener
        public void c(Transition transition) {
        }

        @Override // androidx.transition.Transition.TransitionListener
        public void f(Transition transition) {
        }

        @Override // androidx.transition.Transition.TransitionListener
        public void g(Transition transition) {
        }

        @Override // androidx.transition.Transition.TransitionListener
        public void h(Transition transition, boolean z2) {
        }
    }

    public Fade(int i3) {
        v0(i3);
    }

    private Animator w0(View view, float f3, float f4) {
        if (f3 == f4) {
            return null;
        }
        ViewUtils.f(view, f3);
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(view, (Property<View, Float>) ViewUtils.f53564b, f4);
        FadeAnimatorListener fadeAnimatorListener = new FadeAnimatorListener(view);
        objectAnimatorOfFloat.addListener(fadeAnimatorListener);
        B().a(fadeAnimatorListener);
        return objectAnimatorOfFloat;
    }

    private static float x0(TransitionValues transitionValues, float f3) {
        Float f4;
        return (transitionValues == null || (f4 = (Float) transitionValues.f53545a.get("android:fade:transitionAlpha")) == null) ? f3 : f4.floatValue();
    }

    @Override // androidx.transition.Visibility, androidx.transition.Transition
    public void k(TransitionValues transitionValues) {
        super.k(transitionValues);
        Float fValueOf = (Float) transitionValues.f53546b.getTag(R.id.f53461h);
        if (fValueOf == null) {
            fValueOf = transitionValues.f53546b.getVisibility() == 0 ? Float.valueOf(ViewUtils.b(transitionValues.f53546b)) : Float.valueOf(0.0f);
        }
        transitionValues.f53545a.put("android:fade:transitionAlpha", fValueOf);
    }

    @Override // androidx.transition.Visibility
    public Animator r0(ViewGroup viewGroup, View view, TransitionValues transitionValues, TransitionValues transitionValues2) {
        ViewUtils.c(view);
        return w0(view, x0(transitionValues, 0.0f), 1.0f);
    }

    @Override // androidx.transition.Visibility
    public Animator t0(ViewGroup viewGroup, View view, TransitionValues transitionValues, TransitionValues transitionValues2) {
        ViewUtils.c(view);
        Animator animatorW0 = w0(view, x0(transitionValues, 1.0f), 0.0f);
        if (animatorW0 == null) {
            ViewUtils.f(view, x0(transitionValues2, 1.0f));
        }
        return animatorW0;
    }

    public Fade() {
    }
}
