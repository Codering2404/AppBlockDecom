package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.TimeInterpolator;
import android.util.Property;
import android.view.View;
import androidx.transition.Transition;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
class TranslationAnimationCreator {
    static Animator a(View view, TransitionValues transitionValues, int i3, int i4, float f3, float f4, float f5, float f6, TimeInterpolator timeInterpolator, Transition transition) {
        float translationX = view.getTranslationX();
        float translationY = view.getTranslationY();
        if (((int[]) transitionValues.f53546b.getTag(R.id.f53462i)) != null) {
            f3 = (r2[0] - i3) + translationX;
            f4 = (r2[1] - i4) + translationY;
        }
        view.setTranslationX(f3);
        view.setTranslationY(f4);
        if (f3 == f5 && f4 == f6) {
            return null;
        }
        ObjectAnimator objectAnimatorOfPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(view, PropertyValuesHolder.ofFloat((Property<?, Float>) View.TRANSLATION_X, f3, f5), PropertyValuesHolder.ofFloat((Property<?, Float>) View.TRANSLATION_Y, f4, f6));
        TransitionPositionListener transitionPositionListener = new TransitionPositionListener(view, transitionValues.f53546b, translationX, translationY);
        transition.a(transitionPositionListener);
        objectAnimatorOfPropertyValuesHolder.addListener(transitionPositionListener);
        objectAnimatorOfPropertyValuesHolder.setInterpolator(timeInterpolator);
        return objectAnimatorOfPropertyValuesHolder;
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class TransitionPositionListener extends AnimatorListenerAdapter implements Transition.TransitionListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final View f53552a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final View f53553b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private int[] f53554c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private float f53555d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private float f53556f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private final float f53557g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private final float f53558h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private boolean f53559i;

        TransitionPositionListener(View view, View view2, float f3, float f4) {
            this.f53553b = view;
            this.f53552a = view2;
            this.f53557g = f3;
            this.f53558h = f4;
            int i3 = R.id.f53462i;
            int[] iArr = (int[]) view2.getTag(i3);
            this.f53554c = iArr;
            if (iArr != null) {
                view2.setTag(i3, null);
            }
        }

        private void a() {
            if (this.f53554c == null) {
                this.f53554c = new int[2];
            }
            this.f53553b.getLocationOnScreen(this.f53554c);
            this.f53552a.setTag(R.id.f53462i, this.f53554c);
        }

        @Override // androidx.transition.Transition.TransitionListener
        public void b(Transition transition) {
            this.f53553b.setTranslationX(this.f53555d);
            this.f53553b.setTranslationY(this.f53556f);
        }

        @Override // androidx.transition.Transition.TransitionListener
        public void d(Transition transition) {
            a();
            this.f53555d = this.f53553b.getTranslationX();
            this.f53556f = this.f53553b.getTranslationY();
            this.f53553b.setTranslationX(this.f53557g);
            this.f53553b.setTranslationY(this.f53558h);
        }

        @Override // androidx.transition.Transition.TransitionListener
        public void e(Transition transition, boolean z2) {
            if (this.f53559i) {
                return;
            }
            this.f53552a.setTag(R.id.f53462i, null);
        }

        @Override // androidx.transition.Transition.TransitionListener
        public void f(Transition transition) {
            e(transition, false);
        }

        @Override // androidx.transition.Transition.TransitionListener
        public void g(Transition transition) {
            this.f53559i = true;
            this.f53553b.setTranslationX(this.f53557g);
            this.f53553b.setTranslationY(this.f53558h);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            this.f53559i = true;
            this.f53553b.setTranslationX(this.f53557g);
            this.f53553b.setTranslationY(this.f53558h);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator, boolean z2) {
            if (z2) {
                return;
            }
            this.f53553b.setTranslationX(this.f53557g);
            this.f53553b.setTranslationY(this.f53558h);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            onAnimationEnd(animator, false);
        }

        @Override // androidx.transition.Transition.TransitionListener
        public void c(Transition transition) {
        }
    }
}
