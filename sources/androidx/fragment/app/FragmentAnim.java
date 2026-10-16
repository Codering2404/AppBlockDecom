package androidx.fragment.app;

import android.R;
import android.animation.Animator;
import android.content.Context;
import android.content.res.TypedArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.Transformation;
import androidx.core.view.OneShotPreDrawListener;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
class FragmentAnim {
    private static int a(Fragment fragment, boolean z2, boolean z3) {
        return z3 ? z2 ? fragment.getPopEnterAnim() : fragment.getPopExitAnim() : z2 ? fragment.getEnterAnim() : fragment.getExitAnim();
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x006f A[Catch: RuntimeException -> 0x0075, TRY_LEAVE, TryCatch #0 {RuntimeException -> 0x0075, blocks: (B:32:0x0069, B:34:0x006f), top: B:45:0x0069 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    static androidx.fragment.app.FragmentAnim.AnimationOrAnimator b(android.content.Context r4, androidx.fragment.app.Fragment r5, boolean r6, boolean r7) {
        /*
            int r0 = r5.getNextTransition()
            int r7 = a(r5, r6, r7)
            r1 = 0
            r5.setAnimations(r1, r1, r1, r1)
            android.view.ViewGroup r1 = r5.mContainer
            r2 = 0
            if (r1 == 0) goto L1e
            int r3 = androidx.fragment.R.id.f37097c
            java.lang.Object r1 = r1.getTag(r3)
            if (r1 == 0) goto L1e
            android.view.ViewGroup r1 = r5.mContainer
            r1.setTag(r3, r2)
        L1e:
            android.view.ViewGroup r1 = r5.mContainer
            if (r1 == 0) goto L29
            android.animation.LayoutTransition r1 = r1.getLayoutTransition()
            if (r1 == 0) goto L29
            return r2
        L29:
            android.view.animation.Animation r1 = r5.onCreateAnimation(r0, r6, r7)
            if (r1 == 0) goto L35
            androidx.fragment.app.FragmentAnim$AnimationOrAnimator r4 = new androidx.fragment.app.FragmentAnim$AnimationOrAnimator
            r4.<init>(r1)
            return r4
        L35:
            android.animation.Animator r5 = r5.onCreateAnimator(r0, r6, r7)
            if (r5 == 0) goto L41
            androidx.fragment.app.FragmentAnim$AnimationOrAnimator r4 = new androidx.fragment.app.FragmentAnim$AnimationOrAnimator
            r4.<init>(r5)
            return r4
        L41:
            if (r7 != 0) goto L49
            if (r0 == 0) goto L49
            int r7 = d(r4, r0, r6)
        L49:
            if (r7 == 0) goto L85
            android.content.res.Resources r5 = r4.getResources()
            java.lang.String r5 = r5.getResourceTypeName(r7)
            java.lang.String r6 = "anim"
            boolean r5 = r6.equals(r5)
            if (r5 == 0) goto L69
            android.view.animation.Animation r6 = android.view.animation.AnimationUtils.loadAnimation(r4, r7)     // Catch: android.content.res.Resources.NotFoundException -> L67 java.lang.RuntimeException -> L69
            if (r6 == 0) goto L85
            androidx.fragment.app.FragmentAnim$AnimationOrAnimator r0 = new androidx.fragment.app.FragmentAnim$AnimationOrAnimator     // Catch: android.content.res.Resources.NotFoundException -> L67 java.lang.RuntimeException -> L69
            r0.<init>(r6)     // Catch: android.content.res.Resources.NotFoundException -> L67 java.lang.RuntimeException -> L69
            return r0
        L67:
            r4 = move-exception
            throw r4
        L69:
            android.animation.Animator r6 = android.animation.AnimatorInflater.loadAnimator(r4, r7)     // Catch: java.lang.RuntimeException -> L75
            if (r6 == 0) goto L85
            androidx.fragment.app.FragmentAnim$AnimationOrAnimator r0 = new androidx.fragment.app.FragmentAnim$AnimationOrAnimator     // Catch: java.lang.RuntimeException -> L75
            r0.<init>(r6)     // Catch: java.lang.RuntimeException -> L75
            return r0
        L75:
            r6 = move-exception
            if (r5 != 0) goto L84
            android.view.animation.Animation r4 = android.view.animation.AnimationUtils.loadAnimation(r4, r7)
            if (r4 == 0) goto L85
            androidx.fragment.app.FragmentAnim$AnimationOrAnimator r5 = new androidx.fragment.app.FragmentAnim$AnimationOrAnimator
            r5.<init>(r4)
            return r5
        L84:
            throw r6
        L85:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.fragment.app.FragmentAnim.b(android.content.Context, androidx.fragment.app.Fragment, boolean, boolean):androidx.fragment.app.FragmentAnim$AnimationOrAnimator");
    }

    private static int c(Context context, int i3) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(R.style.Animation.Activity, new int[]{i3});
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(0, -1);
        typedArrayObtainStyledAttributes.recycle();
        return resourceId;
    }

    private static int d(Context context, int i3, boolean z2) {
        if (i3 == 4097) {
            return z2 ? androidx.fragment.R.animator.f37093e : androidx.fragment.R.animator.f37094f;
        }
        if (i3 == 8194) {
            return z2 ? androidx.fragment.R.animator.f37089a : androidx.fragment.R.animator.f37090b;
        }
        if (i3 == 8197) {
            return z2 ? c(context, R.attr.activityCloseEnterAnimation) : c(context, R.attr.activityCloseExitAnimation);
        }
        if (i3 == 4099) {
            return z2 ? androidx.fragment.R.animator.f37091c : androidx.fragment.R.animator.f37092d;
        }
        if (i3 != 4100) {
            return -1;
        }
        return z2 ? c(context, R.attr.activityOpenEnterAnimation) : c(context, R.attr.activityOpenExitAnimation);
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class AnimationOrAnimator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Animation f37191a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Animator f37192b;

        AnimationOrAnimator(Animation animation) {
            this.f37191a = animation;
            this.f37192b = null;
            if (animation == null) {
                throw new IllegalStateException("Animation cannot be null");
            }
        }

        AnimationOrAnimator(Animator animator) {
            this.f37191a = null;
            this.f37192b = animator;
            if (animator == null) {
                throw new IllegalStateException("Animator cannot be null");
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class EndViewTransitionAnimation extends AnimationSet implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ViewGroup f37193a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final View f37194b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private boolean f37195c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private boolean f37196d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private boolean f37197f;

        EndViewTransitionAnimation(Animation animation, ViewGroup viewGroup, View view) {
            super(false);
            this.f37197f = true;
            this.f37193a = viewGroup;
            this.f37194b = view;
            addAnimation(animation);
            viewGroup.post(this);
        }

        @Override // android.view.animation.AnimationSet, android.view.animation.Animation
        public boolean getTransformation(long j3, Transformation transformation) {
            this.f37197f = true;
            if (this.f37195c) {
                return !this.f37196d;
            }
            if (!super.getTransformation(j3, transformation)) {
                this.f37195c = true;
                OneShotPreDrawListener.a(this.f37193a, this);
            }
            return true;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f37195c || !this.f37197f) {
                this.f37193a.endViewTransition(this.f37194b);
                this.f37196d = true;
            } else {
                this.f37197f = false;
                this.f37193a.post(this);
            }
        }

        @Override // android.view.animation.Animation
        public boolean getTransformation(long j3, Transformation transformation, float f3) {
            this.f37197f = true;
            if (this.f37195c) {
                return !this.f37196d;
            }
            if (!super.getTransformation(j3, transformation, f3)) {
                this.f37195c = true;
                OneShotPreDrawListener.a(this.f37193a, this);
            }
            return true;
        }
    }
}
