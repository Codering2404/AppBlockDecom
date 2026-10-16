package androidx.constraintlayout.motion.widget;

import android.view.View;
import androidx.constraintlayout.core.motion.utils.Easing;
import androidx.constraintlayout.widget.ConstraintAttribute;
import androidx.constraintlayout.widget.ConstraintSet;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import java.util.Arrays;
import java.util.LinkedHashMap;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
class MotionPaths implements Comparable<MotionPaths> {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    static String[] f32843u = {"position", "x", "y", ViewHierarchyConstants.DIMENSION_WIDTH_KEY, ViewHierarchyConstants.DIMENSION_HEIGHT_KEY, "pathRotate"};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Easing f32844a;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    float f32846c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    float f32847d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    float f32848f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    float f32849g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    float f32850h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    float f32851i;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    int f32854l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    int f32855m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    float f32856n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    MotionController f32857o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    LinkedHashMap f32858p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    int f32859q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    int f32860r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    double[] f32861s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    double[] f32862t;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    int f32845b = 0;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    float f32852j = Float.NaN;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    float f32853k = Float.NaN;

    public MotionPaths() {
        int i3 = Key.f32582f;
        this.f32854l = i3;
        this.f32855m = i3;
        this.f32856n = Float.NaN;
        this.f32857o = null;
        this.f32858p = new LinkedHashMap();
        this.f32859q = 0;
        this.f32861s = new double[18];
        this.f32862t = new double[18];
    }

    private boolean c(float f3, float f4) {
        return (Float.isNaN(f3) || Float.isNaN(f4)) ? Float.isNaN(f3) != Float.isNaN(f4) : Math.abs(f3 - f4) > 1.0E-6f;
    }

    public void a(ConstraintSet.Constraint constraint) {
        this.f32844a = Easing.c(constraint.f33194d.f33259d);
        ConstraintSet.Motion motion = constraint.f33194d;
        this.f32854l = motion.f33260e;
        this.f32855m = motion.f33257b;
        this.f32852j = motion.f33264i;
        this.f32845b = motion.f33261f;
        this.f32860r = motion.f33258c;
        this.f32853k = constraint.f33193c.f33274e;
        this.f32856n = constraint.f33195e.D;
        for (String str : constraint.f33197g.keySet()) {
            ConstraintAttribute constraintAttribute = (ConstraintAttribute) constraint.f33197g.get(str);
            if (constraintAttribute != null && constraintAttribute.g()) {
                this.f32858p.put(str, constraintAttribute);
            }
        }
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public int compareTo(MotionPaths motionPaths) {
        return Float.compare(this.f32847d, motionPaths.f32847d);
    }

    void d(MotionPaths motionPaths, boolean[] zArr, String[] strArr, boolean z2) {
        boolean zC = c(this.f32848f, motionPaths.f32848f);
        boolean zC2 = c(this.f32849g, motionPaths.f32849g);
        zArr[0] = zArr[0] | c(this.f32847d, motionPaths.f32847d);
        boolean z3 = zC | zC2 | z2;
        zArr[1] = zArr[1] | z3;
        zArr[2] = z3 | zArr[2];
        zArr[3] = zArr[3] | c(this.f32850h, motionPaths.f32850h);
        zArr[4] = c(this.f32851i, motionPaths.f32851i) | zArr[4];
    }

    void e(double[] dArr, int[] iArr) {
        float[] fArr = {this.f32847d, this.f32848f, this.f32849g, this.f32850h, this.f32851i, this.f32852j};
        int i3 = 0;
        for (int i4 : iArr) {
            if (i4 < 6) {
                dArr[i3] = fArr[r1];
                i3++;
            }
        }
    }

    void f(double d3, int[] iArr, double[] dArr, float[] fArr, int i3) {
        float fSin = this.f32848f;
        float fCos = this.f32849g;
        float f3 = this.f32850h;
        float f4 = this.f32851i;
        for (int i4 = 0; i4 < iArr.length; i4++) {
            float f5 = (float) dArr[i4];
            int i5 = iArr[i4];
            if (i5 == 1) {
                fSin = f5;
            } else if (i5 == 2) {
                fCos = f5;
            } else if (i5 == 3) {
                f3 = f5;
            } else if (i5 == 4) {
                f4 = f5;
            }
        }
        MotionController motionController = this.f32857o;
        if (motionController != null) {
            float[] fArr2 = new float[2];
            motionController.i(d3, fArr2, new float[2]);
            float f6 = fArr2[0];
            float f7 = fArr2[1];
            double d4 = f6;
            double d5 = fSin;
            double d6 = fCos;
            fSin = (float) ((d4 + (Math.sin(d6) * d5)) - ((double) (f3 / 2.0f)));
            fCos = (float) ((((double) f7) - (d5 * Math.cos(d6))) - ((double) (f4 / 2.0f)));
        }
        fArr[i3] = fSin + (f3 / 2.0f) + 0.0f;
        fArr[i3 + 1] = fCos + (f4 / 2.0f) + 0.0f;
    }

    void g(double d3, int[] iArr, double[] dArr, float[] fArr, double[] dArr2, float[] fArr2) {
        float f3;
        float fSin = this.f32848f;
        float fCos = this.f32849g;
        float f4 = this.f32850h;
        float f5 = this.f32851i;
        float f6 = 0.0f;
        float f7 = 0.0f;
        float f8 = 0.0f;
        float f9 = 0.0f;
        for (int i3 = 0; i3 < iArr.length; i3++) {
            float f10 = (float) dArr[i3];
            float f11 = (float) dArr2[i3];
            int i4 = iArr[i3];
            if (i4 == 1) {
                fSin = f10;
                f6 = f11;
            } else if (i4 == 2) {
                fCos = f10;
                f8 = f11;
            } else if (i4 == 3) {
                f4 = f10;
                f7 = f11;
            } else if (i4 == 4) {
                f5 = f10;
                f9 = f11;
            }
        }
        float f12 = (f7 / 2.0f) + f6;
        float fCos2 = (f9 / 2.0f) + f8;
        MotionController motionController = this.f32857o;
        if (motionController != null) {
            float[] fArr3 = new float[2];
            float[] fArr4 = new float[2];
            motionController.i(d3, fArr3, fArr4);
            float f13 = fArr3[0];
            float f14 = fArr3[1];
            float f15 = fArr4[0];
            float f16 = fArr4[1];
            f3 = 2.0f;
            double d4 = fSin;
            double d5 = fCos;
            fSin = (float) ((((double) f13) + (Math.sin(d5) * d4)) - ((double) (f4 / 2.0f)));
            fCos = (float) ((((double) f14) - (Math.cos(d5) * d4)) - ((double) (f5 / 2.0f)));
            double d6 = f6;
            double dSin = ((double) f15) + (Math.sin(d5) * d6);
            double d7 = f8;
            float fCos3 = (float) (dSin + (Math.cos(d5) * d7));
            fCos2 = (float) ((((double) f16) - (d6 * Math.cos(d5))) + (Math.sin(d5) * d7));
            f12 = fCos3;
        } else {
            f3 = 2.0f;
        }
        fArr[0] = fSin + (f4 / f3) + 0.0f;
        fArr[1] = fCos + (f5 / f3) + 0.0f;
        fArr2[0] = f12;
        fArr2[1] = fCos2;
    }

    int h(String str, double[] dArr, int i3) {
        ConstraintAttribute constraintAttribute = (ConstraintAttribute) this.f32858p.get(str);
        int i4 = 0;
        if (constraintAttribute == null) {
            return 0;
        }
        if (constraintAttribute.h() == 1) {
            dArr[i3] = constraintAttribute.e();
            return 1;
        }
        int iH = constraintAttribute.h();
        constraintAttribute.f(new float[iH]);
        while (i4 < iH) {
            dArr[i3] = r2[i4];
            i4++;
            i3++;
        }
        return iH;
    }

    int i(String str) {
        ConstraintAttribute constraintAttribute = (ConstraintAttribute) this.f32858p.get(str);
        if (constraintAttribute == null) {
            return 0;
        }
        return constraintAttribute.h();
    }

    void j(int[] iArr, double[] dArr, float[] fArr, int i3) {
        float f3 = this.f32848f;
        float fCos = this.f32849g;
        float f4 = this.f32850h;
        float f5 = this.f32851i;
        for (int i4 = 0; i4 < iArr.length; i4++) {
            float f6 = (float) dArr[i4];
            int i5 = iArr[i4];
            if (i5 == 1) {
                f3 = f6;
            } else if (i5 == 2) {
                fCos = f6;
            } else if (i5 == 3) {
                f4 = f6;
            } else if (i5 == 4) {
                f5 = f6;
            }
        }
        MotionController motionController = this.f32857o;
        if (motionController != null) {
            float fJ = motionController.j();
            float fK = this.f32857o.k();
            double d3 = f3;
            double d4 = fCos;
            float fSin = (float) ((((double) fJ) + (Math.sin(d4) * d3)) - ((double) (f4 / 2.0f)));
            fCos = (float) ((((double) fK) - (d3 * Math.cos(d4))) - ((double) (f5 / 2.0f)));
            f3 = fSin;
        }
        float f7 = f4 + f3;
        float f8 = f5 + fCos;
        Float.isNaN(Float.NaN);
        Float.isNaN(Float.NaN);
        fArr[i3] = f3 + 0.0f;
        fArr[i3 + 1] = fCos + 0.0f;
        fArr[i3 + 2] = f7 + 0.0f;
        fArr[i3 + 3] = fCos + 0.0f;
        fArr[i3 + 4] = f7 + 0.0f;
        fArr[i3 + 5] = f8 + 0.0f;
        fArr[i3 + 6] = f3 + 0.0f;
        fArr[i3 + 7] = f8 + 0.0f;
    }

    boolean k(String str) {
        return this.f32858p.containsKey(str);
    }

    void l(KeyPosition keyPosition, MotionPaths motionPaths, MotionPaths motionPaths2) {
        float f3 = keyPosition.f32583a / 100.0f;
        this.f32846c = f3;
        this.f32845b = keyPosition.f32631j;
        float f4 = Float.isNaN(keyPosition.f32632k) ? f3 : keyPosition.f32632k;
        float f5 = Float.isNaN(keyPosition.f32633l) ? f3 : keyPosition.f32633l;
        float f6 = motionPaths2.f32850h;
        float f7 = motionPaths.f32850h;
        float f8 = motionPaths2.f32851i;
        float f9 = motionPaths.f32851i;
        this.f32847d = this.f32846c;
        float f10 = motionPaths.f32848f;
        float f11 = motionPaths.f32849g;
        float f12 = f3;
        float f13 = (motionPaths2.f32848f + (f6 / 2.0f)) - ((f7 / 2.0f) + f10);
        float f14 = (motionPaths2.f32849g + (f8 / 2.0f)) - (f11 + (f9 / 2.0f));
        float f15 = ((f6 - f7) * f4) / 2.0f;
        this.f32848f = (int) ((f10 + (f13 * f12)) - f15);
        float f16 = ((f8 - f9) * f5) / 2.0f;
        this.f32849g = (int) ((f11 + (f14 * f12)) - f16);
        this.f32850h = (int) (f7 + r9);
        this.f32851i = (int) (f9 + r12);
        float f17 = Float.isNaN(keyPosition.f32634m) ? f12 : keyPosition.f32634m;
        float f18 = Float.isNaN(keyPosition.f32637p) ? 0.0f : keyPosition.f32637p;
        if (!Float.isNaN(keyPosition.f32635n)) {
            f12 = keyPosition.f32635n;
        }
        float f19 = Float.isNaN(keyPosition.f32636o) ? 0.0f : keyPosition.f32636o;
        this.f32859q = 0;
        this.f32848f = (int) (((motionPaths.f32848f + (f17 * f13)) + (f19 * f14)) - f15);
        this.f32849g = (int) (((motionPaths.f32849g + (f13 * f18)) + (f14 * f12)) - f16);
        this.f32844a = Easing.c(keyPosition.f32629h);
        this.f32854l = keyPosition.f32630i;
    }

    void m(KeyPosition keyPosition, MotionPaths motionPaths, MotionPaths motionPaths2) {
        float f3 = keyPosition.f32583a / 100.0f;
        this.f32846c = f3;
        this.f32845b = keyPosition.f32631j;
        float f4 = Float.isNaN(keyPosition.f32632k) ? f3 : keyPosition.f32632k;
        float f5 = Float.isNaN(keyPosition.f32633l) ? f3 : keyPosition.f32633l;
        float f6 = motionPaths2.f32850h - motionPaths.f32850h;
        float f7 = motionPaths2.f32851i - motionPaths.f32851i;
        this.f32847d = this.f32846c;
        if (!Float.isNaN(keyPosition.f32634m)) {
            f3 = keyPosition.f32634m;
        }
        float f8 = motionPaths.f32848f;
        float f9 = motionPaths.f32850h;
        float f10 = motionPaths.f32849g;
        float f11 = motionPaths.f32851i;
        float f12 = f3;
        float f13 = (motionPaths2.f32848f + (motionPaths2.f32850h / 2.0f)) - ((f9 / 2.0f) + f8);
        float f14 = (motionPaths2.f32849g + (motionPaths2.f32851i / 2.0f)) - ((f11 / 2.0f) + f10);
        float f15 = f13 * f12;
        float f16 = (f6 * f4) / 2.0f;
        this.f32848f = (int) ((f8 + f15) - f16);
        float f17 = f14 * f12;
        float f18 = (f7 * f5) / 2.0f;
        this.f32849g = (int) ((f10 + f17) - f18);
        this.f32850h = (int) (f9 + r7);
        this.f32851i = (int) (f11 + r8);
        float f19 = Float.isNaN(keyPosition.f32635n) ? 0.0f : keyPosition.f32635n;
        this.f32859q = 1;
        float f20 = (int) ((motionPaths.f32848f + f15) - f16);
        float f21 = (int) ((motionPaths.f32849g + f17) - f18);
        this.f32848f = f20 + ((-f14) * f19);
        this.f32849g = f21 + (f13 * f19);
        this.f32855m = this.f32855m;
        this.f32844a = Easing.c(keyPosition.f32629h);
        this.f32854l = keyPosition.f32630i;
    }

    void n(int i3, int i4, KeyPosition keyPosition, MotionPaths motionPaths, MotionPaths motionPaths2) {
        float fMin;
        float f3;
        float f4 = keyPosition.f32583a / 100.0f;
        this.f32846c = f4;
        this.f32845b = keyPosition.f32631j;
        this.f32859q = keyPosition.f32638q;
        float f5 = Float.isNaN(keyPosition.f32632k) ? f4 : keyPosition.f32632k;
        float f6 = Float.isNaN(keyPosition.f32633l) ? f4 : keyPosition.f32633l;
        float f7 = motionPaths2.f32850h;
        float f8 = motionPaths.f32850h;
        float f9 = motionPaths2.f32851i;
        float f10 = motionPaths.f32851i;
        this.f32847d = this.f32846c;
        this.f32850h = (int) (f8 + ((f7 - f8) * f5));
        this.f32851i = (int) (f10 + ((f9 - f10) * f6));
        int i5 = keyPosition.f32638q;
        if (i5 == 1) {
            float f11 = Float.isNaN(keyPosition.f32634m) ? f4 : keyPosition.f32634m;
            float f12 = motionPaths2.f32848f;
            float f13 = motionPaths.f32848f;
            this.f32848f = (f11 * (f12 - f13)) + f13;
            if (!Float.isNaN(keyPosition.f32635n)) {
                f4 = keyPosition.f32635n;
            }
            float f14 = motionPaths2.f32849g;
            float f15 = motionPaths.f32849g;
            this.f32849g = (f4 * (f14 - f15)) + f15;
        } else if (i5 != 2) {
            float f16 = Float.isNaN(keyPosition.f32634m) ? f4 : keyPosition.f32634m;
            float f17 = motionPaths2.f32848f;
            float f18 = motionPaths.f32848f;
            this.f32848f = (f16 * (f17 - f18)) + f18;
            if (!Float.isNaN(keyPosition.f32635n)) {
                f4 = keyPosition.f32635n;
            }
            float f19 = motionPaths2.f32849g;
            float f20 = motionPaths.f32849g;
            this.f32849g = (f4 * (f19 - f20)) + f20;
        } else {
            if (Float.isNaN(keyPosition.f32634m)) {
                float f21 = motionPaths2.f32848f;
                float f22 = motionPaths.f32848f;
                fMin = ((f21 - f22) * f4) + f22;
            } else {
                fMin = Math.min(f6, f5) * keyPosition.f32634m;
            }
            this.f32848f = fMin;
            if (Float.isNaN(keyPosition.f32635n)) {
                float f23 = motionPaths2.f32849g;
                float f24 = motionPaths.f32849g;
                f3 = (f4 * (f23 - f24)) + f24;
            } else {
                f3 = keyPosition.f32635n;
            }
            this.f32849g = f3;
        }
        this.f32855m = motionPaths.f32855m;
        this.f32844a = Easing.c(keyPosition.f32629h);
        this.f32854l = keyPosition.f32630i;
    }

    void o(int i3, int i4, KeyPosition keyPosition, MotionPaths motionPaths, MotionPaths motionPaths2) {
        float f3 = keyPosition.f32583a / 100.0f;
        this.f32846c = f3;
        this.f32845b = keyPosition.f32631j;
        float f4 = Float.isNaN(keyPosition.f32632k) ? f3 : keyPosition.f32632k;
        float f5 = Float.isNaN(keyPosition.f32633l) ? f3 : keyPosition.f32633l;
        float f6 = motionPaths2.f32850h;
        float f7 = motionPaths.f32850h;
        float f8 = motionPaths2.f32851i;
        float f9 = motionPaths.f32851i;
        this.f32847d = this.f32846c;
        float f10 = motionPaths.f32848f;
        float f11 = motionPaths.f32849g;
        float f12 = motionPaths2.f32848f + (f6 / 2.0f);
        float f13 = motionPaths2.f32849g + (f8 / 2.0f);
        float f14 = (f6 - f7) * f4;
        this.f32848f = (int) ((f10 + ((f12 - ((f7 / 2.0f) + f10)) * f3)) - (f14 / 2.0f));
        float f15 = (f8 - f9) * f5;
        this.f32849g = (int) ((f11 + ((f13 - (f11 + (f9 / 2.0f))) * f3)) - (f15 / 2.0f));
        this.f32850h = (int) (f7 + f14);
        this.f32851i = (int) (f9 + f15);
        this.f32859q = 2;
        if (!Float.isNaN(keyPosition.f32634m)) {
            this.f32848f = (int) (keyPosition.f32634m * ((int) (i3 - this.f32850h)));
        }
        if (!Float.isNaN(keyPosition.f32635n)) {
            this.f32849g = (int) (keyPosition.f32635n * ((int) (i4 - this.f32851i)));
        }
        this.f32855m = this.f32855m;
        this.f32844a = Easing.c(keyPosition.f32629h);
        this.f32854l = keyPosition.f32630i;
    }

    void p(float f3, float f4, float f5, float f6) {
        this.f32848f = f3;
        this.f32849g = f4;
        this.f32850h = f5;
        this.f32851i = f6;
    }

    void q(float f3, float f4, float[] fArr, int[] iArr, double[] dArr, double[] dArr2) {
        float f5 = 0.0f;
        float f6 = 0.0f;
        float f7 = 0.0f;
        float f8 = 0.0f;
        for (int i3 = 0; i3 < iArr.length; i3++) {
            float f9 = (float) dArr[i3];
            double d3 = dArr2[i3];
            int i4 = iArr[i3];
            if (i4 == 1) {
                f5 = f9;
            } else if (i4 == 2) {
                f7 = f9;
            } else if (i4 == 3) {
                f6 = f9;
            } else if (i4 == 4) {
                f8 = f9;
            }
        }
        float f10 = f5 - ((0.0f * f6) / 2.0f);
        float f11 = f7 - ((0.0f * f8) / 2.0f);
        fArr[0] = (f10 * (1.0f - f3)) + (((f6 * 1.0f) + f10) * f3) + 0.0f;
        fArr[1] = (f11 * (1.0f - f4)) + (((f8 * 1.0f) + f11) * f4) + 0.0f;
    }

    /* JADX WARN: Multi-variable type inference failed */
    void r(float f3, View view, int[] iArr, double[] dArr, double[] dArr2, double[] dArr3, boolean z2) {
        float f4;
        float f5 = this.f32848f;
        float f6 = this.f32849g;
        float f7 = this.f32850h;
        float f8 = this.f32851i;
        if (iArr.length != 0 && this.f32861s.length <= iArr[iArr.length - 1]) {
            int i3 = iArr[iArr.length - 1] + 1;
            this.f32861s = new double[i3];
            this.f32862t = new double[i3];
        }
        Arrays.fill(this.f32861s, Double.NaN);
        for (int i4 = 0; i4 < iArr.length; i4++) {
            double[] dArr4 = this.f32861s;
            int i5 = iArr[i4];
            dArr4[i5] = dArr[i4];
            this.f32862t[i5] = dArr2[i4];
        }
        float f9 = Float.NaN;
        int i6 = 0;
        float f10 = 0.0f;
        float f11 = 0.0f;
        float f12 = 0.0f;
        float f13 = 0.0f;
        while (true) {
            double[] dArr5 = this.f32861s;
            if (i6 >= dArr5.length) {
                break;
            }
            if (Double.isNaN(dArr5[i6]) && (dArr3 == null || dArr3[i6] == 0.0d)) {
                f4 = f9;
            } else {
                double d3 = dArr3 != null ? dArr3[i6] : 0.0d;
                if (!Double.isNaN(this.f32861s[i6])) {
                    d3 = this.f32861s[i6] + d3;
                }
                f4 = f9;
                float f14 = (float) d3;
                float f15 = (float) this.f32862t[i6];
                if (i6 == 1) {
                    f9 = f4;
                    f5 = f14;
                    f10 = f15;
                } else if (i6 == 2) {
                    f9 = f4;
                    f6 = f14;
                    f11 = f15;
                } else if (i6 == 3) {
                    f9 = f4;
                    f7 = f14;
                    f12 = f15;
                } else if (i6 == 4) {
                    f9 = f4;
                    f8 = f14;
                    f13 = f15;
                } else if (i6 == 5) {
                    f9 = f14;
                }
                i6++;
            }
            f9 = f4;
            i6++;
        }
        float f16 = f9;
        MotionController motionController = this.f32857o;
        if (motionController != null) {
            float[] fArr = new float[2];
            float[] fArr2 = new float[2];
            motionController.i(f3, fArr, fArr2);
            float f17 = fArr[0];
            float f18 = fArr[1];
            float f19 = fArr2[0];
            float f20 = fArr2[1];
            double d4 = f5;
            double d5 = f6;
            float fSin = (float) ((((double) f17) + (Math.sin(d5) * d4)) - ((double) (f7 / 2.0f)));
            float fCos = (float) ((((double) f18) - (Math.cos(d5) * d4)) - ((double) (f8 / 2.0f)));
            double d6 = f10;
            double d7 = f11;
            float fSin2 = (float) (((double) f19) + (Math.sin(d5) * d6) + (Math.cos(d5) * d4 * d7));
            float fCos2 = (float) ((((double) f20) - (d6 * Math.cos(d5))) + (d4 * Math.sin(d5) * d7));
            if (dArr2.length >= 2) {
                dArr2[0] = fSin2;
                dArr2[1] = fCos2;
            }
            if (!Float.isNaN(f16)) {
                view.setRotation((float) (((double) f16) + Math.toDegrees(Math.atan2(fCos2, fSin2))));
            }
            f5 = fSin;
            f6 = fCos;
        } else if (!Float.isNaN(f16)) {
            view.setRotation((float) (((double) 0.0f) + ((double) f16) + Math.toDegrees(Math.atan2(f11 + (f13 / 2.0f), f10 + (f12 / 2.0f)))));
        }
        if (view instanceof FloatLayout) {
            ((FloatLayout) view).a(f5, f6, f7 + f5, f8 + f6);
            return;
        }
        float f21 = f5 + 0.5f;
        int i7 = (int) f21;
        float f22 = f6 + 0.5f;
        int i8 = (int) f22;
        int i9 = (int) (f21 + f7);
        int i10 = (int) (f22 + f8);
        int i11 = i9 - i7;
        int i12 = i10 - i8;
        if (i11 != view.getMeasuredWidth() || i12 != view.getMeasuredHeight() || z2) {
            view.measure(View.MeasureSpec.makeMeasureSpec(i11, 1073741824), View.MeasureSpec.makeMeasureSpec(i12, 1073741824));
        }
        view.layout(i7, i8, i9, i10);
    }

    public void s(MotionController motionController, MotionPaths motionPaths) {
        double d3 = ((this.f32848f + (this.f32850h / 2.0f)) - motionPaths.f32848f) - (motionPaths.f32850h / 2.0f);
        double d4 = ((this.f32849g + (this.f32851i / 2.0f)) - motionPaths.f32849g) - (motionPaths.f32851i / 2.0f);
        this.f32857o = motionController;
        this.f32848f = (float) Math.hypot(d4, d3);
        if (Float.isNaN(this.f32856n)) {
            this.f32849g = (float) (Math.atan2(d4, d3) + 1.5707963267948966d);
        } else {
            this.f32849g = (float) Math.toRadians(this.f32856n);
        }
    }

    public MotionPaths(int i3, int i4, KeyPosition keyPosition, MotionPaths motionPaths, MotionPaths motionPaths2) {
        int i5 = Key.f32582f;
        this.f32854l = i5;
        this.f32855m = i5;
        this.f32856n = Float.NaN;
        this.f32857o = null;
        this.f32858p = new LinkedHashMap();
        this.f32859q = 0;
        this.f32861s = new double[18];
        this.f32862t = new double[18];
        if (motionPaths.f32855m != Key.f32582f) {
            n(i3, i4, keyPosition, motionPaths, motionPaths2);
            return;
        }
        int i6 = keyPosition.f32638q;
        if (i6 == 1) {
            m(keyPosition, motionPaths, motionPaths2);
        } else if (i6 != 2) {
            l(keyPosition, motionPaths, motionPaths2);
        } else {
            o(i3, i4, keyPosition, motionPaths, motionPaths2);
        }
    }
}
