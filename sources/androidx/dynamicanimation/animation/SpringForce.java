package androidx.dynamicanimation.animation;

import androidx.dynamicanimation.animation.DynamicAnimation;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class SpringForce implements Force {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    double f36831a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    double f36832b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f36833c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private double f36834d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private double f36835e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private double f36836f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private double f36837g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private double f36838h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private double f36839i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final DynamicAnimation.MassState f36840j;

    public SpringForce() {
        this.f36831a = Math.sqrt(1500.0d);
        this.f36832b = 0.5d;
        this.f36833c = false;
        this.f36839i = Double.MAX_VALUE;
        this.f36840j = new DynamicAnimation.MassState();
    }

    private void b() {
        if (this.f36833c) {
            return;
        }
        if (this.f36839i == Double.MAX_VALUE) {
            throw new IllegalStateException("Error: Final position of the spring must be set before the animation starts");
        }
        double d3 = this.f36832b;
        if (d3 > 1.0d) {
            double d4 = this.f36831a;
            this.f36836f = ((-d3) * d4) + (d4 * Math.sqrt((d3 * d3) - 1.0d));
            double d5 = this.f36832b;
            double d6 = this.f36831a;
            this.f36837g = ((-d5) * d6) - (d6 * Math.sqrt((d5 * d5) - 1.0d));
        } else if (d3 >= 0.0d && d3 < 1.0d) {
            this.f36838h = this.f36831a * Math.sqrt(1.0d - (d3 * d3));
        }
        this.f36833c = true;
    }

    public float a() {
        return (float) this.f36839i;
    }

    public boolean c(float f3, float f4) {
        return ((double) Math.abs(f4)) < this.f36835e && ((double) Math.abs(f3 - a())) < this.f36834d;
    }

    public SpringForce d(float f3) {
        if (f3 < 0.0f) {
            throw new IllegalArgumentException("Damping ratio must be non-negative");
        }
        this.f36832b = f3;
        this.f36833c = false;
        return this;
    }

    public SpringForce e(float f3) {
        this.f36839i = f3;
        return this;
    }

    public SpringForce f(float f3) {
        if (f3 <= 0.0f) {
            throw new IllegalArgumentException("Spring stiffness constant must be positive.");
        }
        this.f36831a = Math.sqrt(f3);
        this.f36833c = false;
        return this;
    }

    void g(double d3) {
        double dAbs = Math.abs(d3);
        this.f36834d = dAbs;
        this.f36835e = dAbs * 62.5d;
    }

    DynamicAnimation.MassState h(double d3, double d4, long j3) {
        double dPow;
        double dCos;
        b();
        double d5 = j3 / 1000.0d;
        double d6 = d3 - this.f36839i;
        double d7 = this.f36832b;
        if (d7 > 1.0d) {
            double d8 = this.f36837g;
            double d9 = this.f36836f;
            double d10 = d6 - (((d8 * d6) - d4) / (d8 - d9));
            double d11 = ((d6 * d8) - d4) / (d8 - d9);
            dPow = (Math.pow(2.718281828459045d, d8 * d5) * d10) + (Math.pow(2.718281828459045d, this.f36836f * d5) * d11);
            double d12 = this.f36837g;
            double dPow2 = d10 * d12 * Math.pow(2.718281828459045d, d12 * d5);
            double d13 = this.f36836f;
            dCos = dPow2 + (d11 * d13 * Math.pow(2.718281828459045d, d13 * d5));
        } else if (d7 == 1.0d) {
            double d14 = this.f36831a;
            double d15 = d4 + (d14 * d6);
            double d16 = d6 + (d15 * d5);
            dPow = Math.pow(2.718281828459045d, (-d14) * d5) * d16;
            double dPow3 = d16 * Math.pow(2.718281828459045d, (-this.f36831a) * d5);
            double d17 = this.f36831a;
            dCos = (d15 * Math.pow(2.718281828459045d, (-d17) * d5)) + (dPow3 * (-d17));
        } else {
            double d18 = 1.0d / this.f36838h;
            double d19 = this.f36831a;
            double d20 = d18 * ((d7 * d19 * d6) + d4);
            dPow = Math.pow(2.718281828459045d, (-d7) * d19 * d5) * ((Math.cos(this.f36838h * d5) * d6) + (Math.sin(this.f36838h * d5) * d20));
            double d21 = this.f36831a;
            double d22 = this.f36832b;
            double dPow4 = Math.pow(2.718281828459045d, (-d22) * d21 * d5);
            double d23 = this.f36838h;
            double dSin = (-d23) * d6 * Math.sin(d23 * d5);
            double d24 = this.f36838h;
            dCos = ((-d21) * dPow * d22) + (dPow4 * (dSin + (d20 * d24 * Math.cos(d24 * d5))));
        }
        DynamicAnimation.MassState massState = this.f36840j;
        massState.f36823a = (float) (dPow + this.f36839i);
        massState.f36824b = (float) dCos;
        return massState;
    }

    public SpringForce(float f3) {
        this.f36831a = Math.sqrt(1500.0d);
        this.f36832b = 0.5d;
        this.f36833c = false;
        this.f36839i = Double.MAX_VALUE;
        this.f36840j = new DynamicAnimation.MassState();
        this.f36839i = f3;
    }
}
