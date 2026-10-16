package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.graphics.Rect;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import androidx.transition.Transition;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public class ChangeClipBounds extends Transition {
    private static final String[] R = {"android:clipBounds:clip"};
    static final Rect S = new Rect();

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class Listener extends AnimatorListenerAdapter implements Transition.TransitionListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Rect f53376a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Rect f53377b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final View f53378c;

        Listener(View view, Rect rect, Rect rect2) {
            this.f53378c = view;
            this.f53376a = rect;
            this.f53377b = rect2;
        }

        @Override // androidx.transition.Transition.TransitionListener
        public void b(Transition transition) {
            View view = this.f53378c;
            int i3 = R.id.f53458e;
            this.f53378c.setClipBounds((Rect) view.getTag(i3));
            this.f53378c.setTag(i3, null);
        }

        @Override // androidx.transition.Transition.TransitionListener
        public void d(Transition transition) {
            Rect clipBounds = this.f53378c.getClipBounds();
            if (clipBounds == null) {
                clipBounds = ChangeClipBounds.S;
            }
            this.f53378c.setTag(R.id.f53458e, clipBounds);
            this.f53378c.setClipBounds(this.f53377b);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            onAnimationEnd(animator, false);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator, boolean z2) {
            if (z2) {
                this.f53378c.setClipBounds(this.f53376a);
            } else {
                this.f53378c.setClipBounds(this.f53377b);
            }
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
    }

    private void p0(TransitionValues transitionValues, boolean z2) {
        View view = transitionValues.f53546b;
        if (view.getVisibility() == 8) {
            return;
        }
        Rect clipBounds = z2 ? (Rect) view.getTag(R.id.f53458e) : null;
        if (clipBounds == null) {
            clipBounds = view.getClipBounds();
        }
        Rect rect = clipBounds != S ? clipBounds : null;
        transitionValues.f53545a.put("android:clipBounds:clip", rect);
        if (rect == null) {
            transitionValues.f53545a.put("android:clipBounds:bounds", new Rect(0, 0, view.getWidth(), view.getHeight()));
        }
    }

    @Override // androidx.transition.Transition
    public String[] K() {
        return R;
    }

    @Override // androidx.transition.Transition
    public void h(TransitionValues transitionValues) {
        p0(transitionValues, false);
    }

    @Override // androidx.transition.Transition
    public void k(TransitionValues transitionValues) {
        p0(transitionValues, true);
    }

    @Override // androidx.transition.Transition
    public Animator q(ViewGroup viewGroup, TransitionValues transitionValues, TransitionValues transitionValues2) {
        if (transitionValues == null || transitionValues2 == null || !transitionValues.f53545a.containsKey("android:clipBounds:clip") || !transitionValues2.f53545a.containsKey("android:clipBounds:clip")) {
            return null;
        }
        Rect rect = (Rect) transitionValues.f53545a.get("android:clipBounds:clip");
        Rect rect2 = (Rect) transitionValues2.f53545a.get("android:clipBounds:clip");
        if (rect == null && rect2 == null) {
            return null;
        }
        Rect rect3 = rect == null ? (Rect) transitionValues.f53545a.get("android:clipBounds:bounds") : rect;
        Rect rect4 = rect2 == null ? (Rect) transitionValues2.f53545a.get("android:clipBounds:bounds") : rect2;
        if (rect3.equals(rect4)) {
            return null;
        }
        transitionValues2.f53546b.setClipBounds(rect);
        ObjectAnimator objectAnimatorOfObject = ObjectAnimator.ofObject(transitionValues2.f53546b, (Property<View, V>) ViewUtils.f53565c, new RectEvaluator(new Rect()), rect3, rect4);
        Listener listener = new Listener(transitionValues2.f53546b, rect, rect2);
        objectAnimatorOfObject.addListener(listener);
        a(listener);
        return objectAnimatorOfObject;
    }
}
