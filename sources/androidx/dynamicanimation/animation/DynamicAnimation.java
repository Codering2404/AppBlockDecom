package androidx.dynamicanimation.animation;

import android.os.Looper;
import android.util.AndroidRuntimeException;
import android.view.View;
import androidx.core.view.ViewCompat;
import androidx.dynamicanimation.animation.AnimationHandler;
import androidx.dynamicanimation.animation.DynamicAnimation;
import com.facebook.stetho.inspector.helper.qp.sKeKFMqmvNzY;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes2.dex */
public abstract class DynamicAnimation<T extends DynamicAnimation<T>> implements AnimationHandler.AnimationFrameCallback {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final ViewProperty f36796m = new ViewProperty("translationX") { // from class: androidx.dynamicanimation.animation.DynamicAnimation.1
        @Override // androidx.dynamicanimation.animation.FloatPropertyCompat
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public float a(View view) {
            return view.getTranslationX();
        }

        @Override // androidx.dynamicanimation.animation.FloatPropertyCompat
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public void b(View view, float f3) {
            view.setTranslationX(f3);
        }
    };

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final ViewProperty f36797n = new ViewProperty("translationY") { // from class: androidx.dynamicanimation.animation.DynamicAnimation.2
        @Override // androidx.dynamicanimation.animation.FloatPropertyCompat
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public float a(View view) {
            return view.getTranslationY();
        }

        @Override // androidx.dynamicanimation.animation.FloatPropertyCompat
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public void b(View view, float f3) {
            view.setTranslationY(f3);
        }
    };

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final ViewProperty f36798o = new ViewProperty("translationZ") { // from class: androidx.dynamicanimation.animation.DynamicAnimation.3
        @Override // androidx.dynamicanimation.animation.FloatPropertyCompat
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public float a(View view) {
            return ViewCompat.I(view);
        }

        @Override // androidx.dynamicanimation.animation.FloatPropertyCompat
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public void b(View view, float f3) {
            ViewCompat.J0(view, f3);
        }
    };

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final ViewProperty f36799p = new ViewProperty("scaleX") { // from class: androidx.dynamicanimation.animation.DynamicAnimation.4
        @Override // androidx.dynamicanimation.animation.FloatPropertyCompat
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public float a(View view) {
            return view.getScaleX();
        }

        @Override // androidx.dynamicanimation.animation.FloatPropertyCompat
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public void b(View view, float f3) {
            view.setScaleX(f3);
        }
    };

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final ViewProperty f36800q = new ViewProperty("scaleY") { // from class: androidx.dynamicanimation.animation.DynamicAnimation.5
        @Override // androidx.dynamicanimation.animation.FloatPropertyCompat
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public float a(View view) {
            return view.getScaleY();
        }

        @Override // androidx.dynamicanimation.animation.FloatPropertyCompat
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public void b(View view, float f3) {
            view.setScaleY(f3);
        }
    };

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final ViewProperty f36801r = new ViewProperty("rotation") { // from class: androidx.dynamicanimation.animation.DynamicAnimation.6
        @Override // androidx.dynamicanimation.animation.FloatPropertyCompat
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public float a(View view) {
            return view.getRotation();
        }

        @Override // androidx.dynamicanimation.animation.FloatPropertyCompat
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public void b(View view, float f3) {
            view.setRotation(f3);
        }
    };

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final ViewProperty f36802s = new ViewProperty("rotationX") { // from class: androidx.dynamicanimation.animation.DynamicAnimation.7
        @Override // androidx.dynamicanimation.animation.FloatPropertyCompat
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public float a(View view) {
            return view.getRotationX();
        }

        @Override // androidx.dynamicanimation.animation.FloatPropertyCompat
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public void b(View view, float f3) {
            view.setRotationX(f3);
        }
    };

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final ViewProperty f36803t = new ViewProperty("rotationY") { // from class: androidx.dynamicanimation.animation.DynamicAnimation.8
        @Override // androidx.dynamicanimation.animation.FloatPropertyCompat
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public float a(View view) {
            return view.getRotationY();
        }

        @Override // androidx.dynamicanimation.animation.FloatPropertyCompat
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public void b(View view, float f3) {
            view.setRotationY(f3);
        }
    };

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final ViewProperty f36804u = new ViewProperty("x") { // from class: androidx.dynamicanimation.animation.DynamicAnimation.9
        @Override // androidx.dynamicanimation.animation.FloatPropertyCompat
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public float a(View view) {
            return view.getX();
        }

        @Override // androidx.dynamicanimation.animation.FloatPropertyCompat
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public void b(View view, float f3) {
            view.setX(f3);
        }
    };

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final ViewProperty f36805v = new ViewProperty(sKeKFMqmvNzY.riRltPvRrtLHw) { // from class: androidx.dynamicanimation.animation.DynamicAnimation.10
        @Override // androidx.dynamicanimation.animation.FloatPropertyCompat
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public float a(View view) {
            return view.getY();
        }

        @Override // androidx.dynamicanimation.animation.FloatPropertyCompat
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public void b(View view, float f3) {
            view.setY(f3);
        }
    };

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final ViewProperty f36806w = new ViewProperty("z") { // from class: androidx.dynamicanimation.animation.DynamicAnimation.11
        @Override // androidx.dynamicanimation.animation.FloatPropertyCompat
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public float a(View view) {
            return ViewCompat.L(view);
        }

        @Override // androidx.dynamicanimation.animation.FloatPropertyCompat
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public void b(View view, float f3) {
            ViewCompat.L0(view, f3);
        }
    };

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final ViewProperty f36807x = new ViewProperty("alpha") { // from class: androidx.dynamicanimation.animation.DynamicAnimation.12
        @Override // androidx.dynamicanimation.animation.FloatPropertyCompat
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public float a(View view) {
            return view.getAlpha();
        }

        @Override // androidx.dynamicanimation.animation.FloatPropertyCompat
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public void b(View view, float f3) {
            view.setAlpha(f3);
        }
    };

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final ViewProperty f36808y = new ViewProperty("scrollX") { // from class: androidx.dynamicanimation.animation.DynamicAnimation.13
        @Override // androidx.dynamicanimation.animation.FloatPropertyCompat
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public float a(View view) {
            return view.getScrollX();
        }

        @Override // androidx.dynamicanimation.animation.FloatPropertyCompat
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public void b(View view, float f3) {
            view.setScrollX((int) f3);
        }
    };

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final ViewProperty f36809z = new ViewProperty("scrollY") { // from class: androidx.dynamicanimation.animation.DynamicAnimation.14
        @Override // androidx.dynamicanimation.animation.FloatPropertyCompat
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public float a(View view) {
            return view.getScrollY();
        }

        @Override // androidx.dynamicanimation.animation.FloatPropertyCompat
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public void b(View view, float f3) {
            view.setScrollY((int) f3);
        }
    };

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final Object f36813d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final FloatPropertyCompat f36814e;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private float f36819j;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    float f36810a = 0.0f;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    float f36811b = Float.MAX_VALUE;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    boolean f36812c = false;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    boolean f36815f = false;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    float f36816g = Float.MAX_VALUE;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    float f36817h = -Float.MAX_VALUE;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private long f36818i = 0;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final ArrayList f36820k = new ArrayList();

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final ArrayList f36821l = new ArrayList();

    /* JADX INFO: renamed from: androidx.dynamicanimation.animation.DynamicAnimation$15, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    /* JADX INFO: loaded from: classes3.dex */
    class AnonymousClass15 extends FloatPropertyCompat {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ FloatValueHolder f36822b;

        @Override // androidx.dynamicanimation.animation.FloatPropertyCompat
        public float a(Object obj) {
            return this.f36822b.a();
        }

        @Override // androidx.dynamicanimation.animation.FloatPropertyCompat
        public void b(Object obj, float f3) {
            this.f36822b.b(f3);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    /* JADX INFO: loaded from: classes3.dex */
    static class MassState {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        float f36823a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        float f36824b;

        MassState() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    /* JADX INFO: loaded from: classes3.dex */
    public interface OnAnimationEndListener {
        void a(DynamicAnimation dynamicAnimation, boolean z2, float f3, float f4);
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    /* JADX INFO: loaded from: classes3.dex */
    public interface OnAnimationUpdateListener {
        void a(DynamicAnimation dynamicAnimation, float f3, float f4);
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    /* JADX INFO: loaded from: classes3.dex */
    public static abstract class ViewProperty extends FloatPropertyCompat<View> {
        private ViewProperty(String str) {
            super(str);
        }
    }

    DynamicAnimation(Object obj, FloatPropertyCompat floatPropertyCompat) {
        this.f36813d = obj;
        this.f36814e = floatPropertyCompat;
        if (floatPropertyCompat == f36801r || floatPropertyCompat == f36802s || floatPropertyCompat == f36803t) {
            this.f36819j = 0.1f;
            return;
        }
        if (floatPropertyCompat == f36807x) {
            this.f36819j = 0.00390625f;
        } else if (floatPropertyCompat == f36799p || floatPropertyCompat == f36800q) {
            this.f36819j = 0.00390625f;
        } else {
            this.f36819j = 1.0f;
        }
    }

    private void b(boolean z2) {
        this.f36815f = false;
        AnimationHandler.d().g(this);
        this.f36818i = 0L;
        this.f36812c = false;
        for (int i3 = 0; i3 < this.f36820k.size(); i3++) {
            if (this.f36820k.get(i3) != null) {
                ((OnAnimationEndListener) this.f36820k.get(i3)).a(this, z2, this.f36811b, this.f36810a);
            }
        }
        f(this.f36820k);
    }

    private float c() {
        return this.f36814e.a(this.f36813d);
    }

    private static void f(ArrayList arrayList) {
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            if (arrayList.get(size) == null) {
                arrayList.remove(size);
            }
        }
    }

    private void j() {
        if (this.f36815f) {
            return;
        }
        this.f36815f = true;
        if (!this.f36812c) {
            this.f36811b = c();
        }
        float f3 = this.f36811b;
        if (f3 > this.f36816g || f3 < this.f36817h) {
            throw new IllegalArgumentException("Starting value need to be in between min value and max value");
        }
        AnimationHandler.d().a(this, 0L);
    }

    @Override // androidx.dynamicanimation.animation.AnimationHandler.AnimationFrameCallback
    public boolean a(long j3) {
        long j4 = this.f36818i;
        if (j4 == 0) {
            this.f36818i = j3;
            g(this.f36811b);
            return false;
        }
        this.f36818i = j3;
        boolean zK = k(j3 - j4);
        float fMin = Math.min(this.f36811b, this.f36816g);
        this.f36811b = fMin;
        float fMax = Math.max(fMin, this.f36817h);
        this.f36811b = fMax;
        g(fMax);
        if (zK) {
            b(false);
        }
        return zK;
    }

    float d() {
        return this.f36819j * 0.75f;
    }

    public boolean e() {
        return this.f36815f;
    }

    void g(float f3) {
        this.f36814e.b(this.f36813d, f3);
        for (int i3 = 0; i3 < this.f36821l.size(); i3++) {
            if (this.f36821l.get(i3) != null) {
                ((OnAnimationUpdateListener) this.f36821l.get(i3)).a(this, this.f36811b, this.f36810a);
            }
        }
        f(this.f36821l);
    }

    public DynamicAnimation h(float f3) {
        this.f36811b = f3;
        this.f36812c = true;
        return this;
    }

    public void i() {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            throw new AndroidRuntimeException("Animations may only be started on the main thread");
        }
        if (this.f36815f) {
            return;
        }
        j();
    }

    abstract boolean k(long j3);
}
