package androidx.dynamicanimation.animation;

import android.os.Looper;
import android.util.AndroidRuntimeException;
import androidx.dynamicanimation.animation.DynamicAnimation;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class SpringAnimation extends DynamicAnimation<SpringAnimation> {
    private SpringForce A;
    private float B;
    private boolean C;

    public SpringAnimation(Object obj, FloatPropertyCompat floatPropertyCompat) {
        super(obj, floatPropertyCompat);
        this.A = null;
        this.B = Float.MAX_VALUE;
        this.C = false;
    }

    private void o() {
        SpringForce springForce = this.A;
        if (springForce == null) {
            throw new UnsupportedOperationException("Incomplete SpringAnimation: Either final position or a spring force needs to be set.");
        }
        double dA = springForce.a();
        if (dA > this.f36816g) {
            throw new UnsupportedOperationException("Final position of the spring cannot be greater than the max value.");
        }
        if (dA < this.f36817h) {
            throw new UnsupportedOperationException("Final position of the spring cannot be less than the min value.");
        }
    }

    @Override // androidx.dynamicanimation.animation.DynamicAnimation
    public void i() {
        o();
        this.A.g(d());
        super.i();
    }

    @Override // androidx.dynamicanimation.animation.DynamicAnimation
    boolean k(long j3) {
        if (this.C) {
            float f3 = this.B;
            if (f3 != Float.MAX_VALUE) {
                this.A.e(f3);
                this.B = Float.MAX_VALUE;
            }
            this.f36811b = this.A.a();
            this.f36810a = 0.0f;
            this.C = false;
            return true;
        }
        if (this.B != Float.MAX_VALUE) {
            this.A.a();
            long j4 = j3 / 2;
            DynamicAnimation.MassState massStateH = this.A.h(this.f36811b, this.f36810a, j4);
            this.A.e(this.B);
            this.B = Float.MAX_VALUE;
            DynamicAnimation.MassState massStateH2 = this.A.h(massStateH.f36823a, massStateH.f36824b, j4);
            this.f36811b = massStateH2.f36823a;
            this.f36810a = massStateH2.f36824b;
        } else {
            DynamicAnimation.MassState massStateH3 = this.A.h(this.f36811b, this.f36810a, j3);
            this.f36811b = massStateH3.f36823a;
            this.f36810a = massStateH3.f36824b;
        }
        float fMax = Math.max(this.f36811b, this.f36817h);
        this.f36811b = fMax;
        float fMin = Math.min(fMax, this.f36816g);
        this.f36811b = fMin;
        if (!n(fMin, this.f36810a)) {
            return false;
        }
        this.f36811b = this.A.a();
        this.f36810a = 0.0f;
        return true;
    }

    public void l(float f3) {
        if (e()) {
            this.B = f3;
            return;
        }
        if (this.A == null) {
            this.A = new SpringForce(f3);
        }
        this.A.e(f3);
        i();
    }

    public boolean m() {
        return this.A.f36832b > 0.0d;
    }

    boolean n(float f3, float f4) {
        return this.A.c(f3, f4);
    }

    public SpringAnimation p(SpringForce springForce) {
        this.A = springForce;
        return this;
    }

    public void q() {
        if (!m()) {
            throw new UnsupportedOperationException("Spring animations can only come to an end when there is damping");
        }
        if (Looper.myLooper() != Looper.getMainLooper()) {
            throw new AndroidRuntimeException("Animations may only be started on the main thread");
        }
        if (this.f36815f) {
            this.C = true;
        }
    }
}
