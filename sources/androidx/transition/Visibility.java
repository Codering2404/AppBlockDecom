package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewGroup;
import androidx.transition.Transition;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class Visibility extends Transition {
    private static final String[] S = {"android:visibility:visibility", "android:visibility:parent"};
    private int R = 3;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class DisappearListener extends AnimatorListenerAdapter implements Transition.TransitionListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final View f53577a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f53578b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final ViewGroup f53579c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final boolean f53580d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private boolean f53581f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        boolean f53582g = false;

        DisappearListener(View view, int i3, boolean z2) {
            this.f53577a = view;
            this.f53578b = i3;
            this.f53579c = (ViewGroup) view.getParent();
            this.f53580d = z2;
            i(true);
        }

        private void a() {
            if (!this.f53582g) {
                ViewUtils.g(this.f53577a, this.f53578b);
                ViewGroup viewGroup = this.f53579c;
                if (viewGroup != null) {
                    viewGroup.invalidate();
                }
            }
            i(false);
        }

        private void i(boolean z2) {
            ViewGroup viewGroup;
            if (!this.f53580d || this.f53581f == z2 || (viewGroup = this.f53579c) == null) {
                return;
            }
            this.f53581f = z2;
            ViewGroupUtils.c(viewGroup, z2);
        }

        @Override // androidx.transition.Transition.TransitionListener
        public void b(Transition transition) {
            i(true);
            if (this.f53582g) {
                return;
            }
            ViewUtils.g(this.f53577a, 0);
        }

        @Override // androidx.transition.Transition.TransitionListener
        public void d(Transition transition) {
            i(false);
            if (this.f53582g) {
                return;
            }
            ViewUtils.g(this.f53577a, this.f53578b);
        }

        @Override // androidx.transition.Transition.TransitionListener
        public void f(Transition transition) {
            transition.b0(this);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            this.f53582g = true;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            a();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator, boolean z2) {
            if (z2) {
                return;
            }
            a();
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator, boolean z2) {
            if (z2) {
                ViewUtils.g(this.f53577a, 0);
                ViewGroup viewGroup = this.f53579c;
                if (viewGroup != null) {
                    viewGroup.invalidate();
                }
            }
        }

        @Override // androidx.transition.Transition.TransitionListener
        public void c(Transition transition) {
        }

        @Override // androidx.transition.Transition.TransitionListener
        public void g(Transition transition) {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Retention(RetentionPolicy.SOURCE)
    public @interface Mode {
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private class OverlayListener extends AnimatorListenerAdapter implements Transition.TransitionListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ViewGroup f53583a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final View f53584b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final View f53585c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private boolean f53586d = true;

        OverlayListener(ViewGroup viewGroup, View view, View view2) {
            this.f53583a = viewGroup;
            this.f53584b = view;
            this.f53585c = view2;
        }

        private void a() {
            this.f53585c.setTag(R.id.f53457d, null);
            this.f53583a.getOverlay().remove(this.f53584b);
            this.f53586d = false;
        }

        @Override // androidx.transition.Transition.TransitionListener
        public void f(Transition transition) {
            transition.b0(this);
        }

        @Override // androidx.transition.Transition.TransitionListener
        public void g(Transition transition) {
            if (this.f53586d) {
                a();
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            a();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorPauseListener
        public void onAnimationPause(Animator animator) {
            this.f53583a.getOverlay().remove(this.f53584b);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorPauseListener
        public void onAnimationResume(Animator animator) {
            if (this.f53584b.getParent() == null) {
                this.f53583a.getOverlay().add(this.f53584b);
            } else {
                Visibility.this.cancel();
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator, boolean z2) {
            if (z2) {
                this.f53585c.setTag(R.id.f53457d, this.f53584b);
                this.f53583a.getOverlay().add(this.f53584b);
                this.f53586d = true;
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator, boolean z2) {
            if (z2) {
                return;
            }
            a();
        }

        @Override // androidx.transition.Transition.TransitionListener
        public void b(Transition transition) {
        }

        @Override // androidx.transition.Transition.TransitionListener
        public void c(Transition transition) {
        }

        @Override // androidx.transition.Transition.TransitionListener
        public void d(Transition transition) {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class VisibilityInfo {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        boolean f53588a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        boolean f53589b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f53590c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int f53591d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        ViewGroup f53592e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        ViewGroup f53593f;

        VisibilityInfo() {
        }
    }

    private void p0(TransitionValues transitionValues) {
        transitionValues.f53545a.put("android:visibility:visibility", Integer.valueOf(transitionValues.f53546b.getVisibility()));
        transitionValues.f53545a.put("android:visibility:parent", transitionValues.f53546b.getParent());
        int[] iArr = new int[2];
        transitionValues.f53546b.getLocationOnScreen(iArr);
        transitionValues.f53545a.put("android:visibility:screenLocation", iArr);
    }

    private VisibilityInfo q0(TransitionValues transitionValues, TransitionValues transitionValues2) {
        VisibilityInfo visibilityInfo = new VisibilityInfo();
        visibilityInfo.f53588a = false;
        visibilityInfo.f53589b = false;
        if (transitionValues == null || !transitionValues.f53545a.containsKey("android:visibility:visibility")) {
            visibilityInfo.f53590c = -1;
            visibilityInfo.f53592e = null;
        } else {
            visibilityInfo.f53590c = ((Integer) transitionValues.f53545a.get("android:visibility:visibility")).intValue();
            visibilityInfo.f53592e = (ViewGroup) transitionValues.f53545a.get("android:visibility:parent");
        }
        if (transitionValues2 == null || !transitionValues2.f53545a.containsKey("android:visibility:visibility")) {
            visibilityInfo.f53591d = -1;
            visibilityInfo.f53593f = null;
        } else {
            visibilityInfo.f53591d = ((Integer) transitionValues2.f53545a.get("android:visibility:visibility")).intValue();
            visibilityInfo.f53593f = (ViewGroup) transitionValues2.f53545a.get("android:visibility:parent");
        }
        if (transitionValues != null && transitionValues2 != null) {
            int i3 = visibilityInfo.f53590c;
            int i4 = visibilityInfo.f53591d;
            if (i3 != i4 || visibilityInfo.f53592e != visibilityInfo.f53593f) {
                if (i3 != i4) {
                    if (i3 == 0) {
                        visibilityInfo.f53589b = false;
                        visibilityInfo.f53588a = true;
                        return visibilityInfo;
                    }
                    if (i4 == 0) {
                        visibilityInfo.f53589b = true;
                        visibilityInfo.f53588a = true;
                        return visibilityInfo;
                    }
                } else {
                    if (visibilityInfo.f53593f == null) {
                        visibilityInfo.f53589b = false;
                        visibilityInfo.f53588a = true;
                        return visibilityInfo;
                    }
                    if (visibilityInfo.f53592e == null) {
                        visibilityInfo.f53589b = true;
                        visibilityInfo.f53588a = true;
                        return visibilityInfo;
                    }
                }
            }
        } else {
            if (transitionValues == null && visibilityInfo.f53591d == 0) {
                visibilityInfo.f53589b = true;
                visibilityInfo.f53588a = true;
                return visibilityInfo;
            }
            if (transitionValues2 == null && visibilityInfo.f53590c == 0) {
                visibilityInfo.f53589b = false;
                visibilityInfo.f53588a = true;
            }
        }
        return visibilityInfo;
    }

    @Override // androidx.transition.Transition
    public String[] K() {
        return S;
    }

    @Override // androidx.transition.Transition
    public boolean N(TransitionValues transitionValues, TransitionValues transitionValues2) {
        if (transitionValues == null && transitionValues2 == null) {
            return false;
        }
        if (transitionValues != null && transitionValues2 != null && transitionValues2.f53545a.containsKey("android:visibility:visibility") != transitionValues.f53545a.containsKey("android:visibility:visibility")) {
            return false;
        }
        VisibilityInfo visibilityInfoQ0 = q0(transitionValues, transitionValues2);
        return visibilityInfoQ0.f53588a && (visibilityInfoQ0.f53590c == 0 || visibilityInfoQ0.f53591d == 0);
    }

    @Override // androidx.transition.Transition
    public void h(TransitionValues transitionValues) {
        p0(transitionValues);
    }

    @Override // androidx.transition.Transition
    public void k(TransitionValues transitionValues) {
        p0(transitionValues);
    }

    @Override // androidx.transition.Transition
    public Animator q(ViewGroup viewGroup, TransitionValues transitionValues, TransitionValues transitionValues2) {
        VisibilityInfo visibilityInfoQ0 = q0(transitionValues, transitionValues2);
        if (!visibilityInfoQ0.f53588a) {
            return null;
        }
        if (visibilityInfoQ0.f53592e == null && visibilityInfoQ0.f53593f == null) {
            return null;
        }
        return visibilityInfoQ0.f53589b ? s0(viewGroup, transitionValues, visibilityInfoQ0.f53590c, transitionValues2, visibilityInfoQ0.f53591d) : u0(viewGroup, transitionValues, visibilityInfoQ0.f53590c, transitionValues2, visibilityInfoQ0.f53591d);
    }

    public Animator r0(ViewGroup viewGroup, View view, TransitionValues transitionValues, TransitionValues transitionValues2) {
        return null;
    }

    public Animator s0(ViewGroup viewGroup, TransitionValues transitionValues, int i3, TransitionValues transitionValues2, int i4) {
        if ((this.R & 1) != 1 || transitionValues2 == null) {
            return null;
        }
        if (transitionValues == null) {
            View view = (View) transitionValues2.f53546b.getParent();
            if (q0(x(view, false), L(view, false)).f53588a) {
                return null;
            }
        }
        return r0(viewGroup, transitionValues2.f53546b, transitionValues, transitionValues2);
    }

    public Animator t0(ViewGroup viewGroup, View view, TransitionValues transitionValues, TransitionValues transitionValues2) {
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0040  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0069 A[PHI: r2
      0x0069: PHI (r2v3 android.view.View) = 
      (r2v2 android.view.View)
      (r2v2 android.view.View)
      (r2v2 android.view.View)
      (r2v2 android.view.View)
      (r2v2 android.view.View)
      (r2v2 android.view.View)
      (r2v6 android.view.View)
     binds: [B:26:0x003e, B:31:0x004d, B:37:0x0076, B:39:0x0079, B:41:0x007f, B:43:0x0083, B:34:0x0065] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public android.animation.Animator u0(android.view.ViewGroup r11, androidx.transition.TransitionValues r12, int r13, androidx.transition.TransitionValues r14, int r15) {
        /*
            Method dump skipped, instruction units count: 262
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.transition.Visibility.u0(android.view.ViewGroup, androidx.transition.TransitionValues, int, androidx.transition.TransitionValues, int):android.animation.Animator");
    }

    public void v0(int i3) {
        if ((i3 & (-4)) != 0) {
            throw new IllegalArgumentException("Only MODE_IN and MODE_OUT flags are allowed");
        }
        this.R = i3;
    }
}
