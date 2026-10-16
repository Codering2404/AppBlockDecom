package androidx.constraintlayout.core.motion;

import androidx.constraintlayout.core.motion.utils.SplineSet;
import androidx.constraintlayout.core.motion.utils.Utils;
import com.applovin.exoplayer2.common.base.Ascii;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
class MotionConstrainedPoint implements Comparable<MotionConstrainedPoint> {
    static String[] D = {"position", "x", "y", ViewHierarchyConstants.DIMENSION_WIDTH_KEY, ViewHierarchyConstants.DIMENSION_HEIGHT_KEY, "pathRotate"};

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    int f31562c;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private float f31576r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private float f31577s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private float f31578t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private float f31579u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private float f31580v;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private float f31560a = 1.0f;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    int f31561b = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f31563d = false;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private float f31564f = 0.0f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private float f31565g = 0.0f;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private float f31566h = 0.0f;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public float f31567i = 0.0f;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private float f31568j = 1.0f;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private float f31569k = 1.0f;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private float f31570l = Float.NaN;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private float f31571m = Float.NaN;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private float f31572n = 0.0f;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private float f31573o = 0.0f;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private float f31574p = 0.0f;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private int f31575q = 0;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private float f31581w = Float.NaN;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private float f31582x = Float.NaN;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private int f31583y = -1;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    LinkedHashMap f31584z = new LinkedHashMap();
    int A = 0;
    double[] B = new double[18];
    double[] C = new double[18];

    MotionConstrainedPoint() {
    }

    private boolean d(float f3, float f4) {
        return (Float.isNaN(f3) || Float.isNaN(f4)) ? Float.isNaN(f3) != Float.isNaN(f4) : Math.abs(f3 - f4) > 1.0E-6f;
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public void a(HashMap map, int i3) {
        for (String str : map.keySet()) {
            SplineSet splineSet = (SplineSet) map.get(str);
            str.getClass();
            byte b3 = -1;
            switch (str.hashCode()) {
                case -1249320806:
                    if (str.equals("rotationX")) {
                        b3 = 0;
                    }
                    break;
                case -1249320805:
                    if (str.equals("rotationY")) {
                        b3 = 1;
                    }
                    break;
                case -1249320804:
                    if (str.equals("rotationZ")) {
                        b3 = 2;
                    }
                    break;
                case -1225497657:
                    if (str.equals("translationX")) {
                        b3 = 3;
                    }
                    break;
                case -1225497656:
                    if (str.equals("translationY")) {
                        b3 = 4;
                    }
                    break;
                case -1225497655:
                    if (str.equals("translationZ")) {
                        b3 = 5;
                    }
                    break;
                case -1001078227:
                    if (str.equals("progress")) {
                        b3 = 6;
                    }
                    break;
                case -987906986:
                    if (str.equals("pivotX")) {
                        b3 = 7;
                    }
                    break;
                case -987906985:
                    if (str.equals("pivotY")) {
                        b3 = 8;
                    }
                    break;
                case -908189618:
                    if (str.equals("scaleX")) {
                        b3 = 9;
                    }
                    break;
                case -908189617:
                    if (str.equals("scaleY")) {
                        b3 = 10;
                    }
                    break;
                case 92909918:
                    if (str.equals("alpha")) {
                        b3 = Ascii.VT;
                    }
                    break;
                case 803192288:
                    if (str.equals("pathRotate")) {
                        b3 = Ascii.FF;
                    }
                    break;
            }
            switch (b3) {
                case 0:
                    splineSet.e(i3, Float.isNaN(this.f31566h) ? 0.0f : this.f31566h);
                    break;
                case 1:
                    splineSet.e(i3, Float.isNaN(this.f31567i) ? 0.0f : this.f31567i);
                    break;
                case 2:
                    splineSet.e(i3, Float.isNaN(this.f31565g) ? 0.0f : this.f31565g);
                    break;
                case 3:
                    splineSet.e(i3, Float.isNaN(this.f31572n) ? 0.0f : this.f31572n);
                    break;
                case 4:
                    splineSet.e(i3, Float.isNaN(this.f31573o) ? 0.0f : this.f31573o);
                    break;
                case 5:
                    splineSet.e(i3, Float.isNaN(this.f31574p) ? 0.0f : this.f31574p);
                    break;
                case 6:
                    splineSet.e(i3, Float.isNaN(this.f31582x) ? 0.0f : this.f31582x);
                    break;
                case 7:
                    splineSet.e(i3, Float.isNaN(this.f31570l) ? 0.0f : this.f31570l);
                    break;
                case 8:
                    splineSet.e(i3, Float.isNaN(this.f31571m) ? 0.0f : this.f31571m);
                    break;
                case 9:
                    splineSet.e(i3, Float.isNaN(this.f31568j) ? 1.0f : this.f31568j);
                    break;
                case 10:
                    splineSet.e(i3, Float.isNaN(this.f31569k) ? 1.0f : this.f31569k);
                    break;
                case 11:
                    splineSet.e(i3, Float.isNaN(this.f31560a) ? 1.0f : this.f31560a);
                    break;
                case 12:
                    splineSet.e(i3, Float.isNaN(this.f31581w) ? 0.0f : this.f31581w);
                    break;
                default:
                    if (str.startsWith("CUSTOM")) {
                        String str2 = str.split(",")[1];
                        if (this.f31584z.containsKey(str2)) {
                            CustomVariable customVariable = (CustomVariable) this.f31584z.get(str2);
                            if (splineSet instanceof SplineSet.CustomSpline) {
                                ((SplineSet.CustomSpline) splineSet).i(i3, customVariable);
                            } else {
                                Utils.a("MotionPaths", str + " ViewSpline not a CustomSet frame = " + i3 + ", value" + customVariable.j() + splineSet);
                            }
                        }
                    } else {
                        Utils.a("MotionPaths", "UNKNOWN spline " + str);
                    }
                    break;
            }
        }
    }

    public void b(MotionWidget motionWidget) {
        this.f31562c = motionWidget.z();
        this.f31560a = motionWidget.z() != 4 ? 0.0f : motionWidget.g();
        this.f31563d = false;
        this.f31565g = motionWidget.s();
        this.f31566h = motionWidget.q();
        this.f31567i = motionWidget.r();
        this.f31568j = motionWidget.t();
        this.f31569k = motionWidget.u();
        this.f31570l = motionWidget.n();
        this.f31571m = motionWidget.o();
        this.f31572n = motionWidget.w();
        this.f31573o = motionWidget.x();
        this.f31574p = motionWidget.y();
        for (String str : motionWidget.j()) {
            CustomVariable customVariableI = motionWidget.i(str);
            if (customVariableI != null && customVariableI.l()) {
                this.f31584z.put(str, customVariableI);
            }
        }
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public int compareTo(MotionConstrainedPoint motionConstrainedPoint) {
        return Float.compare(this.f31576r, motionConstrainedPoint.f31576r);
    }

    void e(MotionConstrainedPoint motionConstrainedPoint, HashSet hashSet) {
        if (d(this.f31560a, motionConstrainedPoint.f31560a)) {
            hashSet.add("alpha");
        }
        if (d(this.f31564f, motionConstrainedPoint.f31564f)) {
            hashSet.add("translationZ");
        }
        int i3 = this.f31562c;
        int i4 = motionConstrainedPoint.f31562c;
        if (i3 != i4 && this.f31561b == 0 && (i3 == 4 || i4 == 4)) {
            hashSet.add("alpha");
        }
        if (d(this.f31565g, motionConstrainedPoint.f31565g)) {
            hashSet.add("rotationZ");
        }
        if (!Float.isNaN(this.f31581w) || !Float.isNaN(motionConstrainedPoint.f31581w)) {
            hashSet.add("pathRotate");
        }
        if (!Float.isNaN(this.f31582x) || !Float.isNaN(motionConstrainedPoint.f31582x)) {
            hashSet.add("progress");
        }
        if (d(this.f31566h, motionConstrainedPoint.f31566h)) {
            hashSet.add("rotationX");
        }
        if (d(this.f31567i, motionConstrainedPoint.f31567i)) {
            hashSet.add("rotationY");
        }
        if (d(this.f31570l, motionConstrainedPoint.f31570l)) {
            hashSet.add("pivotX");
        }
        if (d(this.f31571m, motionConstrainedPoint.f31571m)) {
            hashSet.add("pivotY");
        }
        if (d(this.f31568j, motionConstrainedPoint.f31568j)) {
            hashSet.add("scaleX");
        }
        if (d(this.f31569k, motionConstrainedPoint.f31569k)) {
            hashSet.add("scaleY");
        }
        if (d(this.f31572n, motionConstrainedPoint.f31572n)) {
            hashSet.add("translationX");
        }
        if (d(this.f31573o, motionConstrainedPoint.f31573o)) {
            hashSet.add("translationY");
        }
        if (d(this.f31574p, motionConstrainedPoint.f31574p)) {
            hashSet.add("translationZ");
        }
        if (d(this.f31564f, motionConstrainedPoint.f31564f)) {
            hashSet.add("elevation");
        }
    }

    void f(float f3, float f4, float f5, float f6) {
        this.f31577s = f3;
        this.f31578t = f4;
        this.f31579u = f5;
        this.f31580v = f6;
    }

    public void g(MotionWidget motionWidget) {
        f(motionWidget.C(), motionWidget.D(), motionWidget.B(), motionWidget.k());
        b(motionWidget);
    }
}
