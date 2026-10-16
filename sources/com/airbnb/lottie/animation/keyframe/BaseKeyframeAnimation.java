package com.airbnb.lottie.animation.keyframe;

import android.view.animation.Interpolator;
import com.airbnb.lottie.L;
import com.airbnb.lottie.value.Keyframe;
import com.airbnb.lottie.value.LottieValueCallback;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class BaseKeyframeAnimation<K, A> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final KeyframesWrapper f56582c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    protected LottieValueCallback f56584e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final List f56580a = new ArrayList(1);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f56581b = false;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected float f56583d = 0.0f;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Object f56585f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private float f56586g = -1.0f;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private float f56587h = -1.0f;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface AnimationListener {
        void a();
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class EmptyKeyframeWrapper<T> implements KeyframesWrapper<T> {
        private EmptyKeyframeWrapper() {
        }

        @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.KeyframesWrapper
        public boolean a(float f3) {
            throw new IllegalStateException("not implemented");
        }

        @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.KeyframesWrapper
        public Keyframe b() {
            throw new IllegalStateException("not implemented");
        }

        @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.KeyframesWrapper
        public boolean c(float f3) {
            return false;
        }

        @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.KeyframesWrapper
        public float d() {
            return 0.0f;
        }

        @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.KeyframesWrapper
        public float e() {
            return 1.0f;
        }

        @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.KeyframesWrapper
        public boolean isEmpty() {
            return true;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private interface KeyframesWrapper<T> {
        boolean a(float f3);

        Keyframe b();

        boolean c(float f3);

        float d();

        float e();

        boolean isEmpty();
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class KeyframesWrapperImpl<T> implements KeyframesWrapper<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final List f56588a;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private Keyframe f56590c = null;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private float f56591d = -1.0f;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private Keyframe f56589b = f(0.0f);

        KeyframesWrapperImpl(List list) {
            this.f56588a = list;
        }

        private Keyframe f(float f3) {
            List list = this.f56588a;
            Keyframe keyframe = (Keyframe) list.get(list.size() - 1);
            if (f3 >= keyframe.f()) {
                return keyframe;
            }
            for (int size = this.f56588a.size() - 2; size >= 1; size--) {
                Keyframe keyframe2 = (Keyframe) this.f56588a.get(size);
                if (this.f56589b != keyframe2 && keyframe2.a(f3)) {
                    return keyframe2;
                }
            }
            return (Keyframe) this.f56588a.get(0);
        }

        @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.KeyframesWrapper
        public boolean a(float f3) {
            Keyframe keyframe = this.f56590c;
            Keyframe keyframe2 = this.f56589b;
            if (keyframe == keyframe2 && this.f56591d == f3) {
                return true;
            }
            this.f56590c = keyframe2;
            this.f56591d = f3;
            return false;
        }

        @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.KeyframesWrapper
        public Keyframe b() {
            return this.f56589b;
        }

        @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.KeyframesWrapper
        public boolean c(float f3) {
            if (this.f56589b.a(f3)) {
                return !this.f56589b.i();
            }
            this.f56589b = f(f3);
            return true;
        }

        @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.KeyframesWrapper
        public float d() {
            return ((Keyframe) this.f56588a.get(0)).f();
        }

        @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.KeyframesWrapper
        public float e() {
            return ((Keyframe) this.f56588a.get(r0.size() - 1)).c();
        }

        @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.KeyframesWrapper
        public boolean isEmpty() {
            return false;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class SingleKeyframeWrapper<T> implements KeyframesWrapper<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Keyframe f56592a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private float f56593b = -1.0f;

        SingleKeyframeWrapper(List list) {
            this.f56592a = (Keyframe) list.get(0);
        }

        @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.KeyframesWrapper
        public boolean a(float f3) {
            if (this.f56593b == f3) {
                return true;
            }
            this.f56593b = f3;
            return false;
        }

        @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.KeyframesWrapper
        public Keyframe b() {
            return this.f56592a;
        }

        @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.KeyframesWrapper
        public boolean c(float f3) {
            return !this.f56592a.i();
        }

        @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.KeyframesWrapper
        public float d() {
            return this.f56592a.f();
        }

        @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.KeyframesWrapper
        public float e() {
            return this.f56592a.c();
        }

        @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.KeyframesWrapper
        public boolean isEmpty() {
            return false;
        }
    }

    BaseKeyframeAnimation(List list) {
        this.f56582c = o(list);
    }

    private float g() {
        if (this.f56586g == -1.0f) {
            this.f56586g = this.f56582c.d();
        }
        return this.f56586g;
    }

    private static KeyframesWrapper o(List list) {
        return list.isEmpty() ? new EmptyKeyframeWrapper() : list.size() == 1 ? new SingleKeyframeWrapper(list) : new KeyframesWrapperImpl(list);
    }

    public void a(AnimationListener animationListener) {
        this.f56580a.add(animationListener);
    }

    protected Keyframe b() {
        L.a("BaseKeyframeAnimation#getCurrentKeyframe");
        Keyframe keyframeB = this.f56582c.b();
        L.b("BaseKeyframeAnimation#getCurrentKeyframe");
        return keyframeB;
    }

    float c() {
        if (this.f56587h == -1.0f) {
            this.f56587h = this.f56582c.e();
        }
        return this.f56587h;
    }

    protected float d() {
        Keyframe keyframeB = b();
        if (keyframeB == null || keyframeB.i()) {
            return 0.0f;
        }
        return keyframeB.f57113d.getInterpolation(e());
    }

    float e() {
        if (this.f56581b) {
            return 0.0f;
        }
        Keyframe keyframeB = b();
        if (keyframeB.i()) {
            return 0.0f;
        }
        return (this.f56583d - keyframeB.f()) / (keyframeB.c() - keyframeB.f());
    }

    public float f() {
        return this.f56583d;
    }

    public Object h() {
        float fE = e();
        if (this.f56584e == null && this.f56582c.a(fE)) {
            return this.f56585f;
        }
        Keyframe keyframeB = b();
        Interpolator interpolator = keyframeB.f57114e;
        Object objI = (interpolator == null || keyframeB.f57115f == null) ? i(keyframeB, d()) : j(keyframeB, fE, interpolator.getInterpolation(fE), keyframeB.f57115f.getInterpolation(fE));
        this.f56585f = objI;
        return objI;
    }

    abstract Object i(Keyframe keyframe, float f3);

    protected Object j(Keyframe keyframe, float f3, float f4, float f5) {
        throw new UnsupportedOperationException("This animation does not support split dimensions!");
    }

    public void k() {
        for (int i3 = 0; i3 < this.f56580a.size(); i3++) {
            ((AnimationListener) this.f56580a.get(i3)).a();
        }
    }

    public void l() {
        this.f56581b = true;
    }

    public void m(float f3) {
        if (this.f56582c.isEmpty()) {
            return;
        }
        if (f3 < g()) {
            f3 = g();
        } else if (f3 > c()) {
            f3 = c();
        }
        if (f3 == this.f56583d) {
            return;
        }
        this.f56583d = f3;
        if (this.f56582c.c(f3)) {
            k();
        }
    }

    public void n(LottieValueCallback lottieValueCallback) {
        LottieValueCallback lottieValueCallback2 = this.f56584e;
        if (lottieValueCallback2 != null) {
            lottieValueCallback2.c(null);
        }
        this.f56584e = lottieValueCallback;
        if (lottieValueCallback != null) {
            lottieValueCallback.c(this);
        }
    }
}
