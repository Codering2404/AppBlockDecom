package androidx.dynamicanimation.animation;

import androidx.dynamicanimation.animation.DynamicAnimation;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class FlingAnimation extends DynamicAnimation<FlingAnimation> {
    private final DragForce A;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class DragForce implements Force {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private float f36825a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private float f36826b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final DynamicAnimation.MassState f36827c;

        public boolean a(float f3, float f4) {
            return Math.abs(f4) < this.f36826b;
        }

        DynamicAnimation.MassState b(float f3, float f4, long j3) {
            float f5 = j3;
            this.f36827c.f36824b = (float) (((double) f4) * Math.exp((f5 / 1000.0f) * this.f36825a));
            DynamicAnimation.MassState massState = this.f36827c;
            float f6 = this.f36825a;
            massState.f36823a = (float) (((double) (f3 - (f4 / f6))) + (((double) (f4 / f6)) * Math.exp((f6 * f5) / 1000.0f)));
            DynamicAnimation.MassState massState2 = this.f36827c;
            if (a(massState2.f36823a, massState2.f36824b)) {
                this.f36827c.f36824b = 0.0f;
            }
            return this.f36827c;
        }
    }

    @Override // androidx.dynamicanimation.animation.DynamicAnimation
    boolean k(long j3) {
        DynamicAnimation.MassState massStateB = this.A.b(this.f36811b, this.f36810a, j3);
        float f3 = massStateB.f36823a;
        this.f36811b = f3;
        float f4 = massStateB.f36824b;
        this.f36810a = f4;
        float f5 = this.f36817h;
        if (f3 < f5) {
            this.f36811b = f5;
            return true;
        }
        float f6 = this.f36816g;
        if (f3 <= f6) {
            return l(f3, f4);
        }
        this.f36811b = f6;
        return true;
    }

    boolean l(float f3, float f4) {
        return f3 >= this.f36816g || f3 <= this.f36817h || this.A.a(f3, f4);
    }
}
