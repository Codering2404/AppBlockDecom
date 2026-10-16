package androidx.constraintlayout.core.motion;

import androidx.constraintlayout.core.motion.MotionWidget;
import androidx.constraintlayout.core.motion.key.MotionKeyPosition;
import androidx.constraintlayout.core.motion.utils.Easing;
import androidx.constraintlayout.core.state.WidgetFrame;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import java.util.Arrays;
import java.util.HashMap;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public class MotionPaths implements Comparable<MotionPaths> {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    static String[] f31585u = {"position", "x", "y", ViewHierarchyConstants.DIMENSION_WIDTH_KEY, ViewHierarchyConstants.DIMENSION_HEIGHT_KEY, "pathRotate"};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Easing f31586a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    int f31587b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    float f31588c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    float f31589d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    float f31590f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    float f31591g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    float f31592h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    float f31593i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    float f31594j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    float f31595k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    int f31596l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    String f31597m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    float f31598n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    Motion f31599o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    HashMap f31600p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    int f31601q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    int f31602r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    double[] f31603s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    double[] f31604t;

    public MotionPaths() {
        this.f31587b = 0;
        this.f31594j = Float.NaN;
        this.f31595k = Float.NaN;
        this.f31596l = -1;
        this.f31597m = null;
        this.f31598n = Float.NaN;
        this.f31599o = null;
        this.f31600p = new HashMap();
        this.f31601q = 0;
        this.f31603s = new double[18];
        this.f31604t = new double[18];
    }

    private boolean c(float f3, float f4) {
        return (Float.isNaN(f3) || Float.isNaN(f4)) ? Float.isNaN(f3) != Float.isNaN(f4) : Math.abs(f3 - f4) > 1.0E-6f;
    }

    public void a(MotionWidget motionWidget) {
        ConstraintWidget constraintWidget;
        this.f31586a = Easing.c(motionWidget.f31606b.f31612c);
        MotionWidget.Motion motion = motionWidget.f31606b;
        this.f31596l = motion.f31613d;
        this.f31597m = motion.f31610a;
        this.f31594j = motion.f31617h;
        this.f31587b = motion.f31614e;
        this.f31602r = motion.f31611b;
        this.f31595k = motionWidget.f31607c.f31626d;
        WidgetFrame widgetFrame = motionWidget.f31605a;
        if (widgetFrame != null && (constraintWidget = widgetFrame.f32150a) != null) {
            this.f31598n = constraintWidget.K;
        }
        for (String str : motionWidget.j()) {
            CustomVariable customVariableI = motionWidget.i(str);
            if (customVariableI != null && customVariableI.l()) {
                this.f31600p.put(str, customVariableI);
            }
        }
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public int compareTo(MotionPaths motionPaths) {
        return Float.compare(this.f31589d, motionPaths.f31589d);
    }

    void d(MotionPaths motionPaths, boolean[] zArr, String[] strArr, boolean z2) {
        boolean zC = c(this.f31590f, motionPaths.f31590f);
        boolean zC2 = c(this.f31591g, motionPaths.f31591g);
        zArr[0] = zArr[0] | c(this.f31589d, motionPaths.f31589d);
        zArr[1] = zArr[1] | (zC || zC2 || z2);
        zArr[2] = zArr[2] | (zC || zC2 || z2);
        zArr[3] = zArr[3] | c(this.f31592h, motionPaths.f31592h);
        zArr[4] = c(this.f31593i, motionPaths.f31593i) | zArr[4];
    }

    void e(double[] dArr, int[] iArr) {
        float[] fArr = {this.f31589d, this.f31590f, this.f31591g, this.f31592h, this.f31593i, this.f31594j};
        int i3 = 0;
        for (int i4 : iArr) {
            if (i4 < 6) {
                dArr[i3] = fArr[r1];
                i3++;
            }
        }
    }

    void f(double d3, int[] iArr, double[] dArr, float[] fArr, int i3) {
        float fSin = this.f31590f;
        float fCos = this.f31591g;
        float f3 = this.f31592h;
        float f4 = this.f31593i;
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
        Motion motion = this.f31599o;
        if (motion != null) {
            float[] fArr2 = new float[2];
            motion.k(d3, fArr2, new float[2]);
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
        float fSin = this.f31590f;
        float fCos = this.f31591g;
        float f4 = this.f31592h;
        float f5 = this.f31593i;
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
        Motion motion = this.f31599o;
        if (motion != null) {
            float[] fArr3 = new float[2];
            float[] fArr4 = new float[2];
            motion.k(d3, fArr3, fArr4);
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
        CustomVariable customVariable = (CustomVariable) this.f31600p.get(str);
        int i4 = 0;
        if (customVariable == null) {
            return 0;
        }
        if (customVariable.m() == 1) {
            dArr[i3] = customVariable.j();
            return 1;
        }
        int iM = customVariable.m();
        customVariable.k(new float[iM]);
        while (i4 < iM) {
            dArr[i3] = r2[i4];
            i4++;
            i3++;
        }
        return iM;
    }

    int i(String str) {
        CustomVariable customVariable = (CustomVariable) this.f31600p.get(str);
        if (customVariable == null) {
            return 0;
        }
        return customVariable.m();
    }

    boolean j(String str) {
        return this.f31600p.containsKey(str);
    }

    void k(MotionKeyPosition motionKeyPosition, MotionPaths motionPaths, MotionPaths motionPaths2) {
        float f3 = motionKeyPosition.f31628a / 100.0f;
        this.f31588c = f3;
        this.f31587b = motionKeyPosition.f31672j;
        float f4 = Float.isNaN(motionKeyPosition.f31673k) ? f3 : motionKeyPosition.f31673k;
        float f5 = Float.isNaN(motionKeyPosition.f31674l) ? f3 : motionKeyPosition.f31674l;
        float f6 = motionPaths2.f31592h;
        float f7 = motionPaths.f31592h;
        float f8 = motionPaths2.f31593i;
        float f9 = motionPaths.f31593i;
        this.f31589d = this.f31588c;
        float f10 = motionPaths.f31590f;
        float f11 = motionPaths.f31591g;
        float f12 = f3;
        float f13 = (motionPaths2.f31590f + (f6 / 2.0f)) - ((f7 / 2.0f) + f10);
        float f14 = (motionPaths2.f31591g + (f8 / 2.0f)) - (f11 + (f9 / 2.0f));
        float f15 = ((f6 - f7) * f4) / 2.0f;
        this.f31590f = (int) ((f10 + (f13 * f12)) - f15);
        float f16 = ((f8 - f9) * f5) / 2.0f;
        this.f31591g = (int) ((f11 + (f14 * f12)) - f16);
        this.f31592h = (int) (f7 + r9);
        this.f31593i = (int) (f9 + r12);
        float f17 = Float.isNaN(motionKeyPosition.f31675m) ? f12 : motionKeyPosition.f31675m;
        float f18 = Float.isNaN(motionKeyPosition.f31678p) ? 0.0f : motionKeyPosition.f31678p;
        if (!Float.isNaN(motionKeyPosition.f31676n)) {
            f12 = motionKeyPosition.f31676n;
        }
        float f19 = Float.isNaN(motionKeyPosition.f31677o) ? 0.0f : motionKeyPosition.f31677o;
        this.f31601q = 0;
        this.f31590f = (int) (((motionPaths.f31590f + (f17 * f13)) + (f19 * f14)) - f15);
        this.f31591g = (int) (((motionPaths.f31591g + (f13 * f18)) + (f14 * f12)) - f16);
        this.f31586a = Easing.c(motionKeyPosition.f31670h);
        this.f31596l = motionKeyPosition.f31671i;
    }

    void l(MotionKeyPosition motionKeyPosition, MotionPaths motionPaths, MotionPaths motionPaths2) {
        float f3 = motionKeyPosition.f31628a / 100.0f;
        this.f31588c = f3;
        this.f31587b = motionKeyPosition.f31672j;
        float f4 = Float.isNaN(motionKeyPosition.f31673k) ? f3 : motionKeyPosition.f31673k;
        float f5 = Float.isNaN(motionKeyPosition.f31674l) ? f3 : motionKeyPosition.f31674l;
        float f6 = motionPaths2.f31592h - motionPaths.f31592h;
        float f7 = motionPaths2.f31593i - motionPaths.f31593i;
        this.f31589d = this.f31588c;
        if (!Float.isNaN(motionKeyPosition.f31675m)) {
            f3 = motionKeyPosition.f31675m;
        }
        float f8 = motionPaths.f31590f;
        float f9 = motionPaths.f31592h;
        float f10 = motionPaths.f31591g;
        float f11 = motionPaths.f31593i;
        float f12 = f3;
        float f13 = (motionPaths2.f31590f + (motionPaths2.f31592h / 2.0f)) - ((f9 / 2.0f) + f8);
        float f14 = (motionPaths2.f31591g + (motionPaths2.f31593i / 2.0f)) - ((f11 / 2.0f) + f10);
        float f15 = f13 * f12;
        float f16 = (f6 * f4) / 2.0f;
        this.f31590f = (int) ((f8 + f15) - f16);
        float f17 = f14 * f12;
        float f18 = (f7 * f5) / 2.0f;
        this.f31591g = (int) ((f10 + f17) - f18);
        this.f31592h = (int) (f9 + r7);
        this.f31593i = (int) (f11 + r8);
        float f19 = Float.isNaN(motionKeyPosition.f31676n) ? 0.0f : motionKeyPosition.f31676n;
        this.f31601q = 1;
        float f20 = (int) ((motionPaths.f31590f + f15) - f16);
        float f21 = (int) ((motionPaths.f31591g + f17) - f18);
        this.f31590f = f20 + ((-f14) * f19);
        this.f31591g = f21 + (f13 * f19);
        this.f31597m = this.f31597m;
        this.f31586a = Easing.c(motionKeyPosition.f31670h);
        this.f31596l = motionKeyPosition.f31671i;
    }

    void m(int i3, int i4, MotionKeyPosition motionKeyPosition, MotionPaths motionPaths, MotionPaths motionPaths2) {
        float fMin;
        float f3;
        float f4 = motionKeyPosition.f31628a / 100.0f;
        this.f31588c = f4;
        this.f31587b = motionKeyPosition.f31672j;
        this.f31601q = motionKeyPosition.f31679q;
        float f5 = Float.isNaN(motionKeyPosition.f31673k) ? f4 : motionKeyPosition.f31673k;
        float f6 = Float.isNaN(motionKeyPosition.f31674l) ? f4 : motionKeyPosition.f31674l;
        float f7 = motionPaths2.f31592h;
        float f8 = motionPaths.f31592h;
        float f9 = motionPaths2.f31593i;
        float f10 = motionPaths.f31593i;
        this.f31589d = this.f31588c;
        this.f31592h = (int) (f8 + ((f7 - f8) * f5));
        this.f31593i = (int) (f10 + ((f9 - f10) * f6));
        int i5 = motionKeyPosition.f31679q;
        if (i5 == 1) {
            float f11 = Float.isNaN(motionKeyPosition.f31675m) ? f4 : motionKeyPosition.f31675m;
            float f12 = motionPaths2.f31590f;
            float f13 = motionPaths.f31590f;
            this.f31590f = (f11 * (f12 - f13)) + f13;
            if (!Float.isNaN(motionKeyPosition.f31676n)) {
                f4 = motionKeyPosition.f31676n;
            }
            float f14 = motionPaths2.f31591g;
            float f15 = motionPaths.f31591g;
            this.f31591g = (f4 * (f14 - f15)) + f15;
        } else if (i5 != 2) {
            float f16 = Float.isNaN(motionKeyPosition.f31675m) ? f4 : motionKeyPosition.f31675m;
            float f17 = motionPaths2.f31590f;
            float f18 = motionPaths.f31590f;
            this.f31590f = (f16 * (f17 - f18)) + f18;
            if (!Float.isNaN(motionKeyPosition.f31676n)) {
                f4 = motionKeyPosition.f31676n;
            }
            float f19 = motionPaths2.f31591g;
            float f20 = motionPaths.f31591g;
            this.f31591g = (f4 * (f19 - f20)) + f20;
        } else {
            if (Float.isNaN(motionKeyPosition.f31675m)) {
                float f21 = motionPaths2.f31590f;
                float f22 = motionPaths.f31590f;
                fMin = ((f21 - f22) * f4) + f22;
            } else {
                fMin = Math.min(f6, f5) * motionKeyPosition.f31675m;
            }
            this.f31590f = fMin;
            if (Float.isNaN(motionKeyPosition.f31676n)) {
                float f23 = motionPaths2.f31591g;
                float f24 = motionPaths.f31591g;
                f3 = (f4 * (f23 - f24)) + f24;
            } else {
                f3 = motionKeyPosition.f31676n;
            }
            this.f31591g = f3;
        }
        this.f31597m = motionPaths.f31597m;
        this.f31586a = Easing.c(motionKeyPosition.f31670h);
        this.f31596l = motionKeyPosition.f31671i;
    }

    void n(int i3, int i4, MotionKeyPosition motionKeyPosition, MotionPaths motionPaths, MotionPaths motionPaths2) {
        float f3 = motionKeyPosition.f31628a / 100.0f;
        this.f31588c = f3;
        this.f31587b = motionKeyPosition.f31672j;
        float f4 = Float.isNaN(motionKeyPosition.f31673k) ? f3 : motionKeyPosition.f31673k;
        float f5 = Float.isNaN(motionKeyPosition.f31674l) ? f3 : motionKeyPosition.f31674l;
        float f6 = motionPaths2.f31592h;
        float f7 = motionPaths.f31592h;
        float f8 = motionPaths2.f31593i;
        float f9 = motionPaths.f31593i;
        this.f31589d = this.f31588c;
        float f10 = motionPaths.f31590f;
        float f11 = motionPaths.f31591g;
        float f12 = motionPaths2.f31590f + (f6 / 2.0f);
        float f13 = motionPaths2.f31591g + (f8 / 2.0f);
        float f14 = (f6 - f7) * f4;
        this.f31590f = (int) ((f10 + ((f12 - ((f7 / 2.0f) + f10)) * f3)) - (f14 / 2.0f));
        float f15 = (f8 - f9) * f5;
        this.f31591g = (int) ((f11 + ((f13 - (f11 + (f9 / 2.0f))) * f3)) - (f15 / 2.0f));
        this.f31592h = (int) (f7 + f14);
        this.f31593i = (int) (f9 + f15);
        this.f31601q = 2;
        if (!Float.isNaN(motionKeyPosition.f31675m)) {
            this.f31590f = (int) (motionKeyPosition.f31675m * (i3 - ((int) this.f31592h)));
        }
        if (!Float.isNaN(motionKeyPosition.f31676n)) {
            this.f31591g = (int) (motionKeyPosition.f31676n * (i4 - ((int) this.f31593i)));
        }
        this.f31597m = this.f31597m;
        this.f31586a = Easing.c(motionKeyPosition.f31670h);
        this.f31596l = motionKeyPosition.f31671i;
    }

    void o(float f3, float f4, float f5, float f6) {
        this.f31590f = f3;
        this.f31591g = f4;
        this.f31592h = f5;
        this.f31593i = f6;
    }

    void p(float f3, float f4, float[] fArr, int[] iArr, double[] dArr, double[] dArr2) {
        float f5 = 0.0f;
        float f6 = 0.0f;
        float f7 = 0.0f;
        float f8 = 0.0f;
        for (int i3 = 0; i3 < iArr.length; i3++) {
            float f9 = (float) dArr[i3];
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

    void q(float f3, MotionWidget motionWidget, int[] iArr, double[] dArr, double[] dArr2, double[] dArr3) {
        float f4;
        float f5 = this.f31590f;
        float f6 = this.f31591g;
        float f7 = this.f31592h;
        float f8 = this.f31593i;
        if (iArr.length != 0 && this.f31603s.length <= iArr[iArr.length - 1]) {
            int i3 = iArr[iArr.length - 1] + 1;
            this.f31603s = new double[i3];
            this.f31604t = new double[i3];
        }
        Arrays.fill(this.f31603s, Double.NaN);
        for (int i4 = 0; i4 < iArr.length; i4++) {
            double[] dArr4 = this.f31603s;
            int i5 = iArr[i4];
            dArr4[i5] = dArr[i4];
            this.f31604t[i5] = dArr2[i4];
        }
        float f9 = Float.NaN;
        int i6 = 0;
        float f10 = 0.0f;
        float f11 = 0.0f;
        float f12 = 0.0f;
        float f13 = 0.0f;
        while (true) {
            double[] dArr5 = this.f31603s;
            if (i6 >= dArr5.length) {
                break;
            }
            if (Double.isNaN(dArr5[i6]) && (dArr3 == null || dArr3[i6] == 0.0d)) {
                f4 = f9;
            } else {
                double d3 = dArr3 != null ? dArr3[i6] : 0.0d;
                if (!Double.isNaN(this.f31603s[i6])) {
                    d3 = this.f31603s[i6] + d3;
                }
                f4 = f9;
                float f14 = (float) d3;
                float f15 = (float) this.f31604t[i6];
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
        Motion motion = this.f31599o;
        if (motion != null) {
            float[] fArr = new float[2];
            float[] fArr2 = new float[2];
            motion.k(f3, fArr, fArr2);
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
                motionWidget.L((float) (((double) f16) + Math.toDegrees(Math.atan2(fCos2, fSin2))));
            }
            f5 = fSin;
            f6 = fCos;
        } else if (!Float.isNaN(f16)) {
            motionWidget.L(((float) (((double) f16) + Math.toDegrees(Math.atan2(f11 + (f13 / 2.0f), f10 + (f12 / 2.0f))))) + 0.0f);
        }
        float f21 = f5 + 0.5f;
        float f22 = f6 + 0.5f;
        motionWidget.E((int) f21, (int) f22, (int) (f21 + f7), (int) (f22 + f8));
    }

    public void r(Motion motion, MotionPaths motionPaths) {
        double d3 = ((this.f31590f + (this.f31592h / 2.0f)) - motionPaths.f31590f) - (motionPaths.f31592h / 2.0f);
        double d4 = ((this.f31591g + (this.f31593i / 2.0f)) - motionPaths.f31591g) - (motionPaths.f31593i / 2.0f);
        this.f31599o = motion;
        this.f31590f = (float) Math.hypot(d4, d3);
        if (Float.isNaN(this.f31598n)) {
            this.f31591g = (float) (Math.atan2(d4, d3) + 1.5707963267948966d);
        } else {
            this.f31591g = (float) Math.toRadians(this.f31598n);
        }
    }

    public MotionPaths(int i3, int i4, MotionKeyPosition motionKeyPosition, MotionPaths motionPaths, MotionPaths motionPaths2) {
        this.f31587b = 0;
        this.f31594j = Float.NaN;
        this.f31595k = Float.NaN;
        this.f31596l = -1;
        this.f31597m = null;
        this.f31598n = Float.NaN;
        this.f31599o = null;
        this.f31600p = new HashMap();
        this.f31601q = 0;
        this.f31603s = new double[18];
        this.f31604t = new double[18];
        if (motionPaths.f31597m != null) {
            m(i3, i4, motionKeyPosition, motionPaths, motionPaths2);
            return;
        }
        int i5 = motionKeyPosition.f31679q;
        if (i5 == 1) {
            l(motionKeyPosition, motionPaths, motionPaths2);
        } else if (i5 != 2) {
            k(motionKeyPosition, motionPaths, motionPaths2);
        } else {
            n(i3, i4, motionKeyPosition, motionPaths, motionPaths2);
        }
    }
}
