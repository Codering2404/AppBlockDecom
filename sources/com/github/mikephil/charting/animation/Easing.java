package com.github.mikephil.charting.animation;

import android.animation.TimeInterpolator;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class Easing {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final EasingFunction f68253a = new EasingFunction() { // from class: com.github.mikephil.charting.animation.Easing.1
        @Override // com.github.mikephil.charting.animation.Easing.EasingFunction, android.animation.TimeInterpolator
        public float getInterpolation(float f3) {
            return f3;
        }
    };

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final EasingFunction f68254b = new EasingFunction() { // from class: com.github.mikephil.charting.animation.Easing.2
        @Override // com.github.mikephil.charting.animation.Easing.EasingFunction, android.animation.TimeInterpolator
        public float getInterpolation(float f3) {
            return f3 * f3;
        }
    };

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final EasingFunction f68255c = new EasingFunction() { // from class: com.github.mikephil.charting.animation.Easing.3
        @Override // com.github.mikephil.charting.animation.Easing.EasingFunction, android.animation.TimeInterpolator
        public float getInterpolation(float f3) {
            return (-f3) * (f3 - 2.0f);
        }
    };

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final EasingFunction f68256d = new EasingFunction() { // from class: com.github.mikephil.charting.animation.Easing.4
        @Override // com.github.mikephil.charting.animation.Easing.EasingFunction, android.animation.TimeInterpolator
        public float getInterpolation(float f3) {
            float f4 = f3 * 2.0f;
            if (f4 < 1.0f) {
                return 0.5f * f4 * f4;
            }
            float f5 = f4 - 1.0f;
            return ((f5 * (f5 - 2.0f)) - 1.0f) * (-0.5f);
        }
    };

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final EasingFunction f68257e = new EasingFunction() { // from class: com.github.mikephil.charting.animation.Easing.5
        @Override // com.github.mikephil.charting.animation.Easing.EasingFunction, android.animation.TimeInterpolator
        public float getInterpolation(float f3) {
            return (float) Math.pow(f3, 3.0d);
        }
    };

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final EasingFunction f68258f = new EasingFunction() { // from class: com.github.mikephil.charting.animation.Easing.6
        @Override // com.github.mikephil.charting.animation.Easing.EasingFunction, android.animation.TimeInterpolator
        public float getInterpolation(float f3) {
            return ((float) Math.pow(f3 - 1.0f, 3.0d)) + 1.0f;
        }
    };

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final EasingFunction f68259g = new EasingFunction() { // from class: com.github.mikephil.charting.animation.Easing.7
        @Override // com.github.mikephil.charting.animation.Easing.EasingFunction, android.animation.TimeInterpolator
        public float getInterpolation(float f3) {
            float f4 = f3 * 2.0f;
            return (f4 < 1.0f ? (float) Math.pow(f4, 3.0d) : ((float) Math.pow(f4 - 2.0f, 3.0d)) + 2.0f) * 0.5f;
        }
    };

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final EasingFunction f68260h = new EasingFunction() { // from class: com.github.mikephil.charting.animation.Easing.8
        @Override // com.github.mikephil.charting.animation.Easing.EasingFunction, android.animation.TimeInterpolator
        public float getInterpolation(float f3) {
            return (float) Math.pow(f3, 4.0d);
        }
    };

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final EasingFunction f68261i = new EasingFunction() { // from class: com.github.mikephil.charting.animation.Easing.9
        @Override // com.github.mikephil.charting.animation.Easing.EasingFunction, android.animation.TimeInterpolator
        public float getInterpolation(float f3) {
            return -(((float) Math.pow(f3 - 1.0f, 4.0d)) - 1.0f);
        }
    };

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final EasingFunction f68262j = new EasingFunction() { // from class: com.github.mikephil.charting.animation.Easing.10
        @Override // com.github.mikephil.charting.animation.Easing.EasingFunction, android.animation.TimeInterpolator
        public float getInterpolation(float f3) {
            float fPow;
            float f4;
            float f5 = f3 * 2.0f;
            if (f5 < 1.0f) {
                fPow = (float) Math.pow(f5, 4.0d);
                f4 = 0.5f;
            } else {
                fPow = ((float) Math.pow(f5 - 2.0f, 4.0d)) - 2.0f;
                f4 = -0.5f;
            }
            return fPow * f4;
        }
    };

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final EasingFunction f68263k = new EasingFunction() { // from class: com.github.mikephil.charting.animation.Easing.11
        @Override // com.github.mikephil.charting.animation.Easing.EasingFunction, android.animation.TimeInterpolator
        public float getInterpolation(float f3) {
            return (-((float) Math.cos(((double) f3) * 1.5707963267948966d))) + 1.0f;
        }
    };

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final EasingFunction f68264l = new EasingFunction() { // from class: com.github.mikephil.charting.animation.Easing.12
        @Override // com.github.mikephil.charting.animation.Easing.EasingFunction, android.animation.TimeInterpolator
        public float getInterpolation(float f3) {
            return (float) Math.sin(((double) f3) * 1.5707963267948966d);
        }
    };

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final EasingFunction f68265m = new EasingFunction() { // from class: com.github.mikephil.charting.animation.Easing.13
        @Override // com.github.mikephil.charting.animation.Easing.EasingFunction, android.animation.TimeInterpolator
        public float getInterpolation(float f3) {
            return (((float) Math.cos(((double) f3) * 3.141592653589793d)) - 1.0f) * (-0.5f);
        }
    };

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final EasingFunction f68266n = new EasingFunction() { // from class: com.github.mikephil.charting.animation.Easing.14
        @Override // com.github.mikephil.charting.animation.Easing.EasingFunction, android.animation.TimeInterpolator
        public float getInterpolation(float f3) {
            if (f3 == 0.0f) {
                return 0.0f;
            }
            return (float) Math.pow(2.0d, (f3 - 1.0f) * 10.0f);
        }
    };

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final EasingFunction f68267o = new EasingFunction() { // from class: com.github.mikephil.charting.animation.Easing.15
        @Override // com.github.mikephil.charting.animation.Easing.EasingFunction, android.animation.TimeInterpolator
        public float getInterpolation(float f3) {
            if (f3 == 1.0f) {
                return 1.0f;
            }
            return -((float) Math.pow(2.0d, (f3 + 1.0f) * (-10.0f)));
        }
    };

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final EasingFunction f68268p = new EasingFunction() { // from class: com.github.mikephil.charting.animation.Easing.16
        @Override // com.github.mikephil.charting.animation.Easing.EasingFunction, android.animation.TimeInterpolator
        public float getInterpolation(float f3) {
            if (f3 == 0.0f) {
                return 0.0f;
            }
            if (f3 == 1.0f) {
                return 1.0f;
            }
            return (f3 * 2.0f < 1.0f ? (float) Math.pow(2.0d, (r9 - 1.0f) * 10.0f) : (-((float) Math.pow(2.0d, (r9 - 1.0f) * (-10.0f)))) + 2.0f) * 0.5f;
        }
    };

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final EasingFunction f68269q = new EasingFunction() { // from class: com.github.mikephil.charting.animation.Easing.17
        @Override // com.github.mikephil.charting.animation.Easing.EasingFunction, android.animation.TimeInterpolator
        public float getInterpolation(float f3) {
            return -(((float) Math.sqrt(1.0f - (f3 * f3))) - 1.0f);
        }
    };

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final EasingFunction f68270r = new EasingFunction() { // from class: com.github.mikephil.charting.animation.Easing.18
        @Override // com.github.mikephil.charting.animation.Easing.EasingFunction, android.animation.TimeInterpolator
        public float getInterpolation(float f3) {
            float f4 = f3 - 1.0f;
            return (float) Math.sqrt(1.0f - (f4 * f4));
        }
    };

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final EasingFunction f68271s = new EasingFunction() { // from class: com.github.mikephil.charting.animation.Easing.19
        @Override // com.github.mikephil.charting.animation.Easing.EasingFunction, android.animation.TimeInterpolator
        public float getInterpolation(float f3) {
            float fSqrt;
            float f4;
            float f5 = f3 * 2.0f;
            if (f5 < 1.0f) {
                fSqrt = ((float) Math.sqrt(1.0f - (f5 * f5))) - 1.0f;
                f4 = -0.5f;
            } else {
                float f6 = f5 - 2.0f;
                fSqrt = ((float) Math.sqrt(1.0f - (f6 * f6))) + 1.0f;
                f4 = 0.5f;
            }
            return fSqrt * f4;
        }
    };

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final EasingFunction f68272t = new EasingFunction() { // from class: com.github.mikephil.charting.animation.Easing.20
        @Override // com.github.mikephil.charting.animation.Easing.EasingFunction, android.animation.TimeInterpolator
        public float getInterpolation(float f3) {
            if (f3 == 0.0f) {
                return 0.0f;
            }
            if (f3 == 1.0f) {
                return 1.0f;
            }
            float f4 = f3 - 1.0f;
            return -(((float) Math.pow(2.0d, 10.0f * f4)) * ((float) Math.sin(((f4 - (0.047746483f * ((float) Math.asin(1.0d)))) * 6.2831855f) / 0.3f)));
        }
    };

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final EasingFunction f68273u = new EasingFunction() { // from class: com.github.mikephil.charting.animation.Easing.21
        @Override // com.github.mikephil.charting.animation.Easing.EasingFunction, android.animation.TimeInterpolator
        public float getInterpolation(float f3) {
            if (f3 == 0.0f) {
                return 0.0f;
            }
            if (f3 == 1.0f) {
                return 1.0f;
            }
            return (((float) Math.pow(2.0d, (-10.0f) * f3)) * ((float) Math.sin(((f3 - (0.047746483f * ((float) Math.asin(1.0d)))) * 6.2831855f) / 0.3f))) + 1.0f;
        }
    };

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final EasingFunction f68274v = new EasingFunction() { // from class: com.github.mikephil.charting.animation.Easing.22
        @Override // com.github.mikephil.charting.animation.Easing.EasingFunction, android.animation.TimeInterpolator
        public float getInterpolation(float f3) {
            if (f3 == 0.0f) {
                return 0.0f;
            }
            float f4 = f3 * 2.0f;
            if (f4 == 2.0f) {
                return 1.0f;
            }
            float fAsin = ((float) Math.asin(1.0d)) * 0.07161972f;
            if (f4 < 1.0f) {
                float f5 = f4 - 1.0f;
                return ((float) Math.pow(2.0d, 10.0f * f5)) * ((float) Math.sin(((f5 * 1.0f) - fAsin) * 6.2831855f * 2.2222223f)) * (-0.5f);
            }
            float f6 = f4 - 1.0f;
            return (((float) Math.pow(2.0d, (-10.0f) * f6)) * 0.5f * ((float) Math.sin(((f6 * 1.0f) - fAsin) * 6.2831855f * 2.2222223f))) + 1.0f;
        }
    };

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final EasingFunction f68275w = new EasingFunction() { // from class: com.github.mikephil.charting.animation.Easing.23
        @Override // com.github.mikephil.charting.animation.Easing.EasingFunction, android.animation.TimeInterpolator
        public float getInterpolation(float f3) {
            return f3 * f3 * ((f3 * 2.70158f) - 1.70158f);
        }
    };

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final EasingFunction f68276x = new EasingFunction() { // from class: com.github.mikephil.charting.animation.Easing.24
        @Override // com.github.mikephil.charting.animation.Easing.EasingFunction, android.animation.TimeInterpolator
        public float getInterpolation(float f3) {
            float f4 = f3 - 1.0f;
            return (f4 * f4 * ((f4 * 2.70158f) + 1.70158f)) + 1.0f;
        }
    };

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final EasingFunction f68277y = new EasingFunction() { // from class: com.github.mikephil.charting.animation.Easing.25
        @Override // com.github.mikephil.charting.animation.Easing.EasingFunction, android.animation.TimeInterpolator
        public float getInterpolation(float f3) {
            float f4 = f3 * 2.0f;
            if (f4 < 1.0f) {
                return f4 * f4 * ((3.5949094f * f4) - 2.5949094f) * 0.5f;
            }
            float f5 = f4 - 2.0f;
            return ((f5 * f5 * ((3.5949094f * f5) + 2.5949094f)) + 2.0f) * 0.5f;
        }
    };

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final EasingFunction f68278z = new EasingFunction() { // from class: com.github.mikephil.charting.animation.Easing.26
        @Override // com.github.mikephil.charting.animation.Easing.EasingFunction, android.animation.TimeInterpolator
        public float getInterpolation(float f3) {
            return 1.0f - Easing.A.getInterpolation(1.0f - f3);
        }
    };
    public static final EasingFunction A = new EasingFunction() { // from class: com.github.mikephil.charting.animation.Easing.27
        @Override // com.github.mikephil.charting.animation.Easing.EasingFunction, android.animation.TimeInterpolator
        public float getInterpolation(float f3) {
            if (f3 < 0.36363637f) {
                return 7.5625f * f3 * f3;
            }
            if (f3 < 0.72727275f) {
                float f4 = f3 - 0.54545456f;
                return (7.5625f * f4 * f4) + 0.75f;
            }
            if (f3 < 0.90909094f) {
                float f5 = f3 - 0.8181818f;
                return (7.5625f * f5 * f5) + 0.9375f;
            }
            float f6 = f3 - 0.95454544f;
            return (7.5625f * f6 * f6) + 0.984375f;
        }
    };
    public static final EasingFunction B = new EasingFunction() { // from class: com.github.mikephil.charting.animation.Easing.28
        @Override // com.github.mikephil.charting.animation.Easing.EasingFunction, android.animation.TimeInterpolator
        public float getInterpolation(float f3) {
            return f3 < 0.5f ? Easing.f68278z.getInterpolation(f3 * 2.0f) * 0.5f : (Easing.A.getInterpolation((f3 * 2.0f) - 1.0f) * 0.5f) + 0.5f;
        }
    };

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface EasingFunction extends TimeInterpolator {
        @Override // android.animation.TimeInterpolator
        float getInterpolation(float f3);
    }
}
