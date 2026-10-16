package androidx.core.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowInsets;
import android.view.WindowInsetsAnimation;
import android.view.WindowInsetsAnimation$Callback;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.PathInterpolator;
import androidx.core.R;
import androidx.core.graphics.Insets;
import androidx.core.view.WindowInsetsCompat;
import androidx.interpolator.view.animation.FastOutLinearInInterpolator;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class WindowInsetsAnimationCompat {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Impl f34482a;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class Impl {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f34487a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private float f34488b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final Interpolator f34489c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final long f34490d;

        Impl(int i3, Interpolator interpolator, long j3) {
            this.f34487a = i3;
            this.f34489c = interpolator;
            this.f34490d = j3;
        }

        public long a() {
            return this.f34490d;
        }

        public float b() {
            Interpolator interpolator = this.f34489c;
            return interpolator != null ? interpolator.getInterpolation(this.f34488b) : this.f34488b;
        }

        public int c() {
            return this.f34487a;
        }

        public void d(float f3) {
            this.f34488b = f3;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class Impl21 extends Impl {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private static final Interpolator f34491e = new PathInterpolator(0.0f, 1.1f, 0.0f, 1.0f);

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private static final Interpolator f34492f = new FastOutLinearInInterpolator();

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private static final Interpolator f34493g = new DecelerateInterpolator();

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        private static class Impl21OnApplyWindowInsetsListener implements View.OnApplyWindowInsetsListener {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final Callback f34494a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private WindowInsetsCompat f34495b;

            Impl21OnApplyWindowInsetsListener(View view, Callback callback) {
                this.f34494a = callback;
                WindowInsetsCompat windowInsetsCompatF = ViewCompat.F(view);
                this.f34495b = windowInsetsCompatF != null ? new WindowInsetsCompat.Builder(windowInsetsCompatF).a() : null;
            }

            @Override // android.view.View.OnApplyWindowInsetsListener
            public WindowInsets onApplyWindowInsets(final View view, WindowInsets windowInsets) {
                if (!view.isLaidOut()) {
                    this.f34495b = WindowInsetsCompat.A(windowInsets, view);
                    return Impl21.m(view, windowInsets);
                }
                final WindowInsetsCompat windowInsetsCompatA = WindowInsetsCompat.A(windowInsets, view);
                if (this.f34495b == null) {
                    this.f34495b = ViewCompat.F(view);
                }
                if (this.f34495b == null) {
                    this.f34495b = windowInsetsCompatA;
                    return Impl21.m(view, windowInsets);
                }
                Callback callbackN = Impl21.n(view);
                if (callbackN != null && Objects.equals(callbackN.f34485a, windowInsets)) {
                    return Impl21.m(view, windowInsets);
                }
                final int iE = Impl21.e(windowInsetsCompatA, this.f34495b);
                if (iE == 0) {
                    return Impl21.m(view, windowInsets);
                }
                final WindowInsetsCompat windowInsetsCompat = this.f34495b;
                final WindowInsetsAnimationCompat windowInsetsAnimationCompat = new WindowInsetsAnimationCompat(iE, Impl21.g(iE, windowInsetsCompatA, windowInsetsCompat), 160L);
                windowInsetsAnimationCompat.e(0.0f);
                final ValueAnimator duration = ValueAnimator.ofFloat(0.0f, 1.0f).setDuration(windowInsetsAnimationCompat.a());
                final BoundsCompat boundsCompatF = Impl21.f(windowInsetsCompatA, windowInsetsCompat, iE);
                Impl21.j(view, windowInsetsAnimationCompat, windowInsets, false);
                duration.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: androidx.core.view.WindowInsetsAnimationCompat.Impl21.Impl21OnApplyWindowInsetsListener.1
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        windowInsetsAnimationCompat.e(valueAnimator.getAnimatedFraction());
                        Impl21.k(view, Impl21.o(windowInsetsCompatA, windowInsetsCompat, windowInsetsAnimationCompat.b(), iE), Collections.singletonList(windowInsetsAnimationCompat));
                    }
                });
                duration.addListener(new AnimatorListenerAdapter() { // from class: androidx.core.view.WindowInsetsAnimationCompat.Impl21.Impl21OnApplyWindowInsetsListener.2
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        windowInsetsAnimationCompat.e(1.0f);
                        Impl21.i(view, windowInsetsAnimationCompat);
                    }
                });
                OneShotPreDrawListener.a(view, new Runnable() { // from class: androidx.core.view.WindowInsetsAnimationCompat.Impl21.Impl21OnApplyWindowInsetsListener.3
                    @Override // java.lang.Runnable
                    public void run() {
                        Impl21.l(view, windowInsetsAnimationCompat, boundsCompatF);
                        duration.start();
                    }
                });
                this.f34495b = windowInsetsCompatA;
                return Impl21.m(view, windowInsets);
            }
        }

        Impl21(int i3, Interpolator interpolator, long j3) {
            super(i3, interpolator, j3);
        }

        static int e(WindowInsetsCompat windowInsetsCompat, WindowInsetsCompat windowInsetsCompat2) {
            int i3 = 0;
            for (int i4 = 1; i4 <= 256; i4 <<= 1) {
                if (!windowInsetsCompat.f(i4).equals(windowInsetsCompat2.f(i4))) {
                    i3 |= i4;
                }
            }
            return i3;
        }

        static BoundsCompat f(WindowInsetsCompat windowInsetsCompat, WindowInsetsCompat windowInsetsCompat2, int i3) {
            Insets insetsF = windowInsetsCompat.f(i3);
            Insets insetsF2 = windowInsetsCompat2.f(i3);
            return new BoundsCompat(Insets.b(Math.min(insetsF.f33964a, insetsF2.f33964a), Math.min(insetsF.f33965b, insetsF2.f33965b), Math.min(insetsF.f33966c, insetsF2.f33966c), Math.min(insetsF.f33967d, insetsF2.f33967d)), Insets.b(Math.max(insetsF.f33964a, insetsF2.f33964a), Math.max(insetsF.f33965b, insetsF2.f33965b), Math.max(insetsF.f33966c, insetsF2.f33966c), Math.max(insetsF.f33967d, insetsF2.f33967d)));
        }

        static Interpolator g(int i3, WindowInsetsCompat windowInsetsCompat, WindowInsetsCompat windowInsetsCompat2) {
            return (i3 & 8) != 0 ? windowInsetsCompat.f(WindowInsetsCompat.Type.d()).f33967d > windowInsetsCompat2.f(WindowInsetsCompat.Type.d()).f33967d ? f34491e : f34492f : f34493g;
        }

        private static View.OnApplyWindowInsetsListener h(View view, Callback callback) {
            return new Impl21OnApplyWindowInsetsListener(view, callback);
        }

        static void i(View view, WindowInsetsAnimationCompat windowInsetsAnimationCompat) {
            Callback callbackN = n(view);
            if (callbackN != null) {
                callbackN.c(windowInsetsAnimationCompat);
                if (callbackN.b() == 0) {
                    return;
                }
            }
            if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                for (int i3 = 0; i3 < viewGroup.getChildCount(); i3++) {
                    i(viewGroup.getChildAt(i3), windowInsetsAnimationCompat);
                }
            }
        }

        static void j(View view, WindowInsetsAnimationCompat windowInsetsAnimationCompat, WindowInsets windowInsets, boolean z2) {
            Callback callbackN = n(view);
            if (callbackN != null) {
                callbackN.f34485a = windowInsets;
                if (!z2) {
                    callbackN.d(windowInsetsAnimationCompat);
                    z2 = callbackN.b() == 0;
                }
            }
            if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                for (int i3 = 0; i3 < viewGroup.getChildCount(); i3++) {
                    j(viewGroup.getChildAt(i3), windowInsetsAnimationCompat, windowInsets, z2);
                }
            }
        }

        static void k(View view, WindowInsetsCompat windowInsetsCompat, List list) {
            Callback callbackN = n(view);
            if (callbackN != null) {
                windowInsetsCompat = callbackN.e(windowInsetsCompat, list);
                if (callbackN.b() == 0) {
                    return;
                }
            }
            if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                for (int i3 = 0; i3 < viewGroup.getChildCount(); i3++) {
                    k(viewGroup.getChildAt(i3), windowInsetsCompat, list);
                }
            }
        }

        static void l(View view, WindowInsetsAnimationCompat windowInsetsAnimationCompat, BoundsCompat boundsCompat) {
            Callback callbackN = n(view);
            if (callbackN != null) {
                callbackN.f(windowInsetsAnimationCompat, boundsCompat);
                if (callbackN.b() == 0) {
                    return;
                }
            }
            if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                for (int i3 = 0; i3 < viewGroup.getChildCount(); i3++) {
                    l(viewGroup.getChildAt(i3), windowInsetsAnimationCompat, boundsCompat);
                }
            }
        }

        static WindowInsets m(View view, WindowInsets windowInsets) {
            return view.getTag(R.id.L) != null ? windowInsets : view.onApplyWindowInsets(windowInsets);
        }

        static Callback n(View view) {
            Object tag = view.getTag(R.id.Q);
            if (tag instanceof Impl21OnApplyWindowInsetsListener) {
                return ((Impl21OnApplyWindowInsetsListener) tag).f34494a;
            }
            return null;
        }

        static WindowInsetsCompat o(WindowInsetsCompat windowInsetsCompat, WindowInsetsCompat windowInsetsCompat2, float f3, int i3) {
            WindowInsetsCompat.Builder builder = new WindowInsetsCompat.Builder(windowInsetsCompat);
            for (int i4 = 1; i4 <= 256; i4 <<= 1) {
                if ((i3 & i4) == 0) {
                    builder.b(i4, windowInsetsCompat.f(i4));
                } else {
                    Insets insetsF = windowInsetsCompat.f(i4);
                    Insets insetsF2 = windowInsetsCompat2.f(i4);
                    float f4 = 1.0f - f3;
                    builder.b(i4, WindowInsetsCompat.q(insetsF, (int) (((double) ((insetsF.f33964a - insetsF2.f33964a) * f4)) + 0.5d), (int) (((double) ((insetsF.f33965b - insetsF2.f33965b) * f4)) + 0.5d), (int) (((double) ((insetsF.f33966c - insetsF2.f33966c) * f4)) + 0.5d), (int) (((double) ((insetsF.f33967d - insetsF2.f33967d) * f4)) + 0.5d)));
                }
            }
            return builder.a();
        }

        static void p(View view, Callback callback) {
            Object tag = view.getTag(R.id.L);
            if (callback == null) {
                view.setTag(R.id.Q, null);
                if (tag == null) {
                    view.setOnApplyWindowInsetsListener(null);
                    return;
                }
                return;
            }
            View.OnApplyWindowInsetsListener onApplyWindowInsetsListenerH = h(view, callback);
            view.setTag(R.id.Q, onApplyWindowInsetsListenerH);
            if (tag == null) {
                view.setOnApplyWindowInsetsListener(onApplyWindowInsetsListenerH);
            }
        }
    }

    public WindowInsetsAnimationCompat(int i3, Interpolator interpolator, long j3) {
        if (Build.VERSION.SDK_INT >= 30) {
            this.f34482a = new Impl30(i3, interpolator, j3);
        } else {
            this.f34482a = new Impl21(i3, interpolator, j3);
        }
    }

    static void d(View view, Callback callback) {
        if (Build.VERSION.SDK_INT >= 30) {
            Impl30.h(view, callback);
        } else {
            Impl21.p(view, callback);
        }
    }

    static WindowInsetsAnimationCompat f(WindowInsetsAnimation windowInsetsAnimation) {
        return new WindowInsetsAnimationCompat(windowInsetsAnimation);
    }

    public long a() {
        return this.f34482a.a();
    }

    public float b() {
        return this.f34482a.b();
    }

    public int c() {
        return this.f34482a.c();
    }

    public void e(float f3) {
        this.f34482a.d(f3);
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class Impl30 extends Impl {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final WindowInsetsAnimation f34510e;

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        private static class ProxyCallback extends WindowInsetsAnimation$Callback {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final Callback f34511a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private List f34512b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            private ArrayList f34513c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            private final HashMap f34514d;

            ProxyCallback(Callback callback) {
                super(callback.b());
                this.f34514d = new HashMap();
                this.f34511a = callback;
            }

            private WindowInsetsAnimationCompat a(WindowInsetsAnimation windowInsetsAnimation) {
                WindowInsetsAnimationCompat windowInsetsAnimationCompat = (WindowInsetsAnimationCompat) this.f34514d.get(windowInsetsAnimation);
                if (windowInsetsAnimationCompat != null) {
                    return windowInsetsAnimationCompat;
                }
                WindowInsetsAnimationCompat windowInsetsAnimationCompatF = WindowInsetsAnimationCompat.f(windowInsetsAnimation);
                this.f34514d.put(windowInsetsAnimation, windowInsetsAnimationCompatF);
                return windowInsetsAnimationCompatF;
            }

            public void onEnd(WindowInsetsAnimation windowInsetsAnimation) {
                this.f34511a.c(a(windowInsetsAnimation));
                this.f34514d.remove(windowInsetsAnimation);
            }

            public void onPrepare(WindowInsetsAnimation windowInsetsAnimation) {
                this.f34511a.d(a(windowInsetsAnimation));
            }

            public WindowInsets onProgress(WindowInsets windowInsets, List list) {
                ArrayList arrayList = this.f34513c;
                if (arrayList == null) {
                    ArrayList arrayList2 = new ArrayList(list.size());
                    this.f34513c = arrayList2;
                    this.f34512b = Collections.unmodifiableList(arrayList2);
                } else {
                    arrayList.clear();
                }
                for (int size = list.size() - 1; size >= 0; size--) {
                    WindowInsetsAnimation windowInsetsAnimationA = i0.a(list.get(size));
                    WindowInsetsAnimationCompat windowInsetsAnimationCompatA = a(windowInsetsAnimationA);
                    windowInsetsAnimationCompatA.e(windowInsetsAnimationA.getFraction());
                    this.f34513c.add(windowInsetsAnimationCompatA);
                }
                return this.f34511a.e(WindowInsetsCompat.z(windowInsets), this.f34512b).y();
            }

            public WindowInsetsAnimation.Bounds onStart(WindowInsetsAnimation windowInsetsAnimation, WindowInsetsAnimation.Bounds bounds) {
                return this.f34511a.f(a(windowInsetsAnimation), BoundsCompat.e(bounds)).d();
            }
        }

        Impl30(WindowInsetsAnimation windowInsetsAnimation) {
            super(0, null, 0L);
            this.f34510e = windowInsetsAnimation;
        }

        public static WindowInsetsAnimation.Bounds e(BoundsCompat boundsCompat) {
            h0.a();
            return g0.a(boundsCompat.a().e(), boundsCompat.b().e());
        }

        public static Insets f(WindowInsetsAnimation.Bounds bounds) {
            return Insets.d(bounds.getUpperBound());
        }

        public static Insets g(WindowInsetsAnimation.Bounds bounds) {
            return Insets.d(bounds.getLowerBound());
        }

        public static void h(View view, Callback callback) {
            view.setWindowInsetsAnimationCallback(callback != null ? new ProxyCallback(callback) : null);
        }

        @Override // androidx.core.view.WindowInsetsAnimationCompat.Impl
        public long a() {
            return this.f34510e.getDurationMillis();
        }

        @Override // androidx.core.view.WindowInsetsAnimationCompat.Impl
        public float b() {
            return this.f34510e.getInterpolatedFraction();
        }

        @Override // androidx.core.view.WindowInsetsAnimationCompat.Impl
        public int c() {
            return this.f34510e.getTypeMask();
        }

        @Override // androidx.core.view.WindowInsetsAnimationCompat.Impl
        public void d(float f3) {
            this.f34510e.setFraction(f3);
        }

        Impl30(int i3, Interpolator interpolator, long j3) {
            this(f0.a(i3, interpolator, j3));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class BoundsCompat {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Insets f34483a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Insets f34484b;

        public BoundsCompat(Insets insets, Insets insets2) {
            this.f34483a = insets;
            this.f34484b = insets2;
        }

        public static BoundsCompat e(WindowInsetsAnimation.Bounds bounds) {
            return new BoundsCompat(bounds);
        }

        public Insets a() {
            return this.f34483a;
        }

        public Insets b() {
            return this.f34484b;
        }

        public BoundsCompat c(Insets insets) {
            return new BoundsCompat(WindowInsetsCompat.q(this.f34483a, insets.f33964a, insets.f33965b, insets.f33966c, insets.f33967d), WindowInsetsCompat.q(this.f34484b, insets.f33964a, insets.f33965b, insets.f33966c, insets.f33967d));
        }

        public WindowInsetsAnimation.Bounds d() {
            return Impl30.e(this);
        }

        public String toString() {
            return "Bounds{lower=" + this.f34483a + " upper=" + this.f34484b + "}";
        }

        private BoundsCompat(WindowInsetsAnimation.Bounds bounds) {
            this.f34483a = Impl30.g(bounds);
            this.f34484b = Impl30.f(bounds);
        }
    }

    private WindowInsetsAnimationCompat(WindowInsetsAnimation windowInsetsAnimation) {
        this(0, null, 0L);
        if (Build.VERSION.SDK_INT >= 30) {
            this.f34482a = new Impl30(windowInsetsAnimation);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static abstract class Callback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        WindowInsets f34485a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f34486b;

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Retention(RetentionPolicy.SOURCE)
        public @interface DispatchMode {
        }

        public Callback(int i3) {
            this.f34486b = i3;
        }

        public final int b() {
            return this.f34486b;
        }

        public abstract WindowInsetsCompat e(WindowInsetsCompat windowInsetsCompat, List list);

        public void c(WindowInsetsAnimationCompat windowInsetsAnimationCompat) {
        }

        public void d(WindowInsetsAnimationCompat windowInsetsAnimationCompat) {
        }

        public BoundsCompat f(WindowInsetsAnimationCompat windowInsetsAnimationCompat, BoundsCompat boundsCompat) {
            return boundsCompat;
        }
    }
}
