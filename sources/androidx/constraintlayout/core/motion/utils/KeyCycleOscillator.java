package androidx.constraintlayout.core.motion.utils;

import androidx.constraintlayout.core.motion.MotionWidget;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import java.lang.reflect.Array;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class KeyCycleOscillator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private CurveFit f31753a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private CycleOscillator f31754b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f31755c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f31756d = 0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f31757e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f31758f = 0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    ArrayList f31759g = new ArrayList();

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class CoreSpline extends KeyCycleOscillator {

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        String f31761h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        int f31762i;

        CoreSpline(String str) {
            this.f31761h = str;
            this.f31762i = TypedValues.CycleType.a(str);
        }

        @Override // androidx.constraintlayout.core.motion.utils.KeyCycleOscillator
        public void g(MotionWidget motionWidget, float f3) {
            motionWidget.c(this.f31762i, a(f3));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class CycleOscillator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f31763a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Oscillator f31764b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final int f31765c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final int f31766d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final int f31767e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        float[] f31768f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        double[] f31769g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        float[] f31770h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        float[] f31771i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        float[] f31772j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        float[] f31773k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        int f31774l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        CurveFit f31775m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        double[] f31776n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        double[] f31777o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        float f31778p;

        CycleOscillator(int i3, String str, int i4, int i5) {
            Oscillator oscillator = new Oscillator();
            this.f31764b = oscillator;
            this.f31765c = 0;
            this.f31766d = 1;
            this.f31767e = 2;
            this.f31774l = i3;
            this.f31763a = i4;
            oscillator.g(i3, str);
            this.f31768f = new float[i5];
            this.f31769g = new double[i5];
            this.f31770h = new float[i5];
            this.f31771i = new float[i5];
            this.f31772j = new float[i5];
            this.f31773k = new float[i5];
        }

        public double a(float f3) {
            CurveFit curveFit = this.f31775m;
            if (curveFit != null) {
                double d3 = f3;
                curveFit.g(d3, this.f31777o);
                this.f31775m.d(d3, this.f31776n);
            } else {
                double[] dArr = this.f31777o;
                dArr[0] = 0.0d;
                dArr[1] = 0.0d;
                dArr[2] = 0.0d;
            }
            double d4 = f3;
            double dE = this.f31764b.e(d4, this.f31776n[1]);
            double d5 = this.f31764b.d(d4, this.f31776n[1], this.f31777o[1]);
            double[] dArr2 = this.f31777o;
            return dArr2[0] + (dE * dArr2[2]) + (d5 * this.f31776n[2]);
        }

        public double b(float f3) {
            CurveFit curveFit = this.f31775m;
            if (curveFit != null) {
                curveFit.d(f3, this.f31776n);
            } else {
                double[] dArr = this.f31776n;
                dArr[0] = this.f31771i[0];
                dArr[1] = this.f31772j[0];
                dArr[2] = this.f31768f[0];
            }
            double[] dArr2 = this.f31776n;
            return dArr2[0] + (this.f31764b.e(f3, dArr2[1]) * this.f31776n[2]);
        }

        public void c(int i3, int i4, float f3, float f4, float f5, float f6) {
            this.f31769g[i3] = ((double) i4) / 100.0d;
            this.f31770h[i3] = f3;
            this.f31771i[i3] = f4;
            this.f31772j[i3] = f5;
            this.f31768f[i3] = f6;
        }

        public void d(float f3) {
            this.f31778p = f3;
            double[][] dArr = (double[][]) Array.newInstance((Class<?>) Double.TYPE, this.f31769g.length, 3);
            float[] fArr = this.f31768f;
            this.f31776n = new double[fArr.length + 2];
            this.f31777o = new double[fArr.length + 2];
            if (this.f31769g[0] > 0.0d) {
                this.f31764b.a(0.0d, this.f31770h[0]);
            }
            double[] dArr2 = this.f31769g;
            int length = dArr2.length - 1;
            if (dArr2[length] < 1.0d) {
                this.f31764b.a(1.0d, this.f31770h[length]);
            }
            for (int i3 = 0; i3 < dArr.length; i3++) {
                double[] dArr3 = dArr[i3];
                dArr3[0] = this.f31771i[i3];
                dArr3[1] = this.f31772j[i3];
                dArr3[2] = this.f31768f[i3];
                this.f31764b.a(this.f31769g[i3], this.f31770h[i3]);
            }
            this.f31764b.f();
            double[] dArr4 = this.f31769g;
            if (dArr4.length > 1) {
                this.f31775m = CurveFit.a(0, dArr4, dArr);
            } else {
                this.f31775m = null;
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static class PathRotateSet extends KeyCycleOscillator {

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        String f31779h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        int f31780i;

        public PathRotateSet(String str) {
            this.f31779h = str;
            this.f31780i = TypedValues.CycleType.a(str);
        }

        @Override // androidx.constraintlayout.core.motion.utils.KeyCycleOscillator
        public void g(MotionWidget motionWidget, float f3) {
            motionWidget.c(this.f31780i, a(f3));
        }

        public void k(MotionWidget motionWidget, float f3, double d3, double d4) {
            motionWidget.L(a(f3) + ((float) Math.toDegrees(Math.atan2(d4, d3))));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class WavePoint {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f31781a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        float f31782b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        float f31783c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        float f31784d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        float f31785e;

        WavePoint(int i3, float f3, float f4, float f5, float f6) {
            this.f31781a = i3;
            this.f31782b = f6;
            this.f31783c = f4;
            this.f31784d = f3;
            this.f31785e = f5;
        }
    }

    public static KeyCycleOscillator c(String str) {
        return str.equals("pathRotate") ? new PathRotateSet(str) : new CoreSpline(str);
    }

    public float a(float f3) {
        return (float) this.f31754b.b(f3);
    }

    public float b(float f3) {
        return (float) this.f31754b.a(f3);
    }

    public void e(int i3, int i4, String str, int i5, float f3, float f4, float f5, float f6) {
        this.f31759g.add(new WavePoint(i3, f3, f4, f5, f6));
        if (i5 != -1) {
            this.f31758f = i5;
        }
        this.f31756d = i4;
        this.f31757e = str;
    }

    public void f(int i3, int i4, String str, int i5, float f3, float f4, float f5, float f6, Object obj) {
        this.f31759g.add(new WavePoint(i3, f3, f4, f5, f6));
        if (i5 != -1) {
            this.f31758f = i5;
        }
        this.f31756d = i4;
        d(obj);
        this.f31757e = str;
    }

    public void h(String str) {
        this.f31755c = str;
    }

    public void i(float f3) {
        int size = this.f31759g.size();
        if (size == 0) {
            return;
        }
        Collections.sort(this.f31759g, new Comparator<WavePoint>() { // from class: androidx.constraintlayout.core.motion.utils.KeyCycleOscillator.1
            @Override // java.util.Comparator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public int compare(WavePoint wavePoint, WavePoint wavePoint2) {
                return Integer.compare(wavePoint.f31781a, wavePoint2.f31781a);
            }
        });
        double[] dArr = new double[size];
        char c3 = 2;
        double[][] dArr2 = (double[][]) Array.newInstance((Class<?>) Double.TYPE, size, 3);
        this.f31754b = new CycleOscillator(this.f31756d, this.f31757e, this.f31758f, size);
        ArrayList arrayList = this.f31759g;
        int size2 = arrayList.size();
        int i3 = 0;
        int i4 = 0;
        while (i3 < size2) {
            int i5 = i3 + 1;
            WavePoint wavePoint = (WavePoint) arrayList.get(i3);
            float f4 = wavePoint.f31784d;
            dArr[i4] = ((double) f4) * 0.01d;
            double[] dArr3 = dArr2[i4];
            float f5 = wavePoint.f31782b;
            dArr3[0] = f5;
            float f6 = wavePoint.f31783c;
            char c4 = c3;
            dArr3[1] = f6;
            float f7 = wavePoint.f31785e;
            dArr3[c4] = f7;
            this.f31754b.c(i4, wavePoint.f31781a, f4, f6, f7, f5);
            i4++;
            i3 = i5;
            c3 = c4;
            dArr2 = dArr2;
        }
        this.f31754b.d(f3);
        this.f31753a = CurveFit.a(0, dArr, dArr2);
    }

    public boolean j() {
        return this.f31758f == 1;
    }

    public String toString() {
        String str = this.f31755c;
        DecimalFormat decimalFormat = new DecimalFormat("##.##");
        ArrayList arrayList = this.f31759g;
        int size = arrayList.size();
        int i3 = 0;
        while (i3 < size) {
            Object obj = arrayList.get(i3);
            i3++;
            str = str + "[" + ((WavePoint) obj).f31781a + " , " + decimalFormat.format(r5.f31782b) + "] ";
        }
        return str;
    }

    protected void d(Object obj) {
    }

    public void g(MotionWidget motionWidget, float f3) {
    }
}
