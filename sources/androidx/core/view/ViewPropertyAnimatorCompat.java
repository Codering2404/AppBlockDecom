package androidx.core.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.animation.Interpolator;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class ViewPropertyAnimatorCompat {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final WeakReference f34478a;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class Api21Impl {
    }

    ViewPropertyAnimatorCompat(View view) {
        this.f34478a = new WeakReference(view);
    }

    private void h(final View view, final ViewPropertyAnimatorListener viewPropertyAnimatorListener) {
        if (viewPropertyAnimatorListener != null) {
            view.animate().setListener(new AnimatorListenerAdapter() { // from class: androidx.core.view.ViewPropertyAnimatorCompat.1
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                    viewPropertyAnimatorListener.a(view);
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    viewPropertyAnimatorListener.b(view);
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    viewPropertyAnimatorListener.c(view);
                }
            });
        } else {
            view.animate().setListener(null);
        }
    }

    public ViewPropertyAnimatorCompat b(float f3) {
        View view = (View) this.f34478a.get();
        if (view != null) {
            view.animate().alpha(f3);
        }
        return this;
    }

    public void c() {
        View view = (View) this.f34478a.get();
        if (view != null) {
            view.animate().cancel();
        }
    }

    public long d() {
        View view = (View) this.f34478a.get();
        if (view != null) {
            return view.animate().getDuration();
        }
        return 0L;
    }

    public ViewPropertyAnimatorCompat e(long j3) {
        View view = (View) this.f34478a.get();
        if (view != null) {
            view.animate().setDuration(j3);
        }
        return this;
    }

    public ViewPropertyAnimatorCompat f(Interpolator interpolator) {
        View view = (View) this.f34478a.get();
        if (view != null) {
            view.animate().setInterpolator(interpolator);
        }
        return this;
    }

    public ViewPropertyAnimatorCompat g(ViewPropertyAnimatorListener viewPropertyAnimatorListener) {
        View view = (View) this.f34478a.get();
        if (view != null) {
            h(view, viewPropertyAnimatorListener);
        }
        return this;
    }

    public ViewPropertyAnimatorCompat i(long j3) {
        View view = (View) this.f34478a.get();
        if (view != null) {
            view.animate().setStartDelay(j3);
        }
        return this;
    }

    public ViewPropertyAnimatorCompat j(final ViewPropertyAnimatorUpdateListener viewPropertyAnimatorUpdateListener) {
        final View view = (View) this.f34478a.get();
        if (view != null) {
            view.animate().setUpdateListener(viewPropertyAnimatorUpdateListener != null ? new ValueAnimator.AnimatorUpdateListener() { // from class: androidx.core.view.x
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    viewPropertyAnimatorUpdateListener.a(view);
                }
            } : null);
        }
        return this;
    }

    public void k() {
        View view = (View) this.f34478a.get();
        if (view != null) {
            view.animate().start();
        }
    }

    public ViewPropertyAnimatorCompat l(float f3) {
        View view = (View) this.f34478a.get();
        if (view != null) {
            view.animate().translationY(f3);
        }
        return this;
    }
}
