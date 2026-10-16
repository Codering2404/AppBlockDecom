package androidx.constraintlayout.core.motion;

import androidx.constraintlayout.core.motion.key.MotionKey;
import androidx.constraintlayout.core.motion.key.MotionKeyAttributes;
import androidx.constraintlayout.core.motion.key.MotionKeyCycle;
import androidx.constraintlayout.core.motion.key.MotionKeyPosition;
import androidx.constraintlayout.core.motion.key.MotionKeyTimeCycle;
import androidx.constraintlayout.core.motion.key.MotionKeyTrigger;
import androidx.constraintlayout.core.motion.utils.CurveFit;
import androidx.constraintlayout.core.motion.utils.DifferentialInterpolator;
import androidx.constraintlayout.core.motion.utils.Easing;
import androidx.constraintlayout.core.motion.utils.KeyCache;
import androidx.constraintlayout.core.motion.utils.KeyCycleOscillator;
import androidx.constraintlayout.core.motion.utils.KeyFrameArray;
import androidx.constraintlayout.core.motion.utils.Rect;
import androidx.constraintlayout.core.motion.utils.SplineSet;
import androidx.constraintlayout.core.motion.utils.TimeCycleSplineSet;
import androidx.constraintlayout.core.motion.utils.TypedBundle;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.constraintlayout.core.motion.utils.Utils;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public class Motion implements TypedValues {
    Motion H;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    MotionWidget f31533b;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private CurveFit[] f31539h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private CurveFit f31540i;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private int[] f31544m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private double[] f31545n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private double[] f31546o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private String[] f31547p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private int[] f31548q;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private HashMap f31554w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private HashMap f31555x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private HashMap f31556y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private MotionKeyTrigger[] f31557z;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Rect f31532a = new Rect();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f31534c = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private MotionPaths f31535d = new MotionPaths();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private MotionPaths f31536e = new MotionPaths();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private MotionConstrainedPoint f31537f = new MotionConstrainedPoint();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private MotionConstrainedPoint f31538g = new MotionConstrainedPoint();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    float f31541j = Float.NaN;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    float f31542k = 0.0f;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    float f31543l = 1.0f;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private int f31549r = 4;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private float[] f31550s = new float[4];

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private ArrayList f31551t = new ArrayList();

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private float[] f31552u = new float[1];

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private ArrayList f31553v = new ArrayList();
    private int A = -1;
    private int B = -1;
    private MotionWidget C = null;
    private int D = -1;
    private float E = Float.NaN;
    private DifferentialInterpolator F = null;
    private boolean G = false;

    public Motion(MotionWidget motionWidget) {
        A(motionWidget);
    }

    private void C() {
        Motion motion = this.H;
        if (motion == null) {
            return;
        }
        this.f31535d.r(motion, motion.f31535d);
        MotionPaths motionPaths = this.f31536e;
        Motion motion2 = this.H;
        motionPaths.r(motion2, motion2.f31536e);
    }

    private float i(float f3, float[] fArr) {
        float f4 = 0.0f;
        if (fArr != null) {
            fArr[0] = 1.0f;
        } else {
            float f5 = this.f31543l;
            if (f5 != 1.0d) {
                float f6 = this.f31542k;
                if (f3 < f6) {
                    f3 = 0.0f;
                }
                if (f3 > f6 && f3 < 1.0d) {
                    f3 = Math.min((f3 - f6) * f5, 1.0f);
                }
            }
        }
        Easing easing = this.f31535d.f31586a;
        ArrayList arrayList = this.f31551t;
        int size = arrayList.size();
        float f7 = Float.NaN;
        int i3 = 0;
        while (i3 < size) {
            Object obj = arrayList.get(i3);
            i3++;
            MotionPaths motionPaths = (MotionPaths) obj;
            Easing easing2 = motionPaths.f31586a;
            if (easing2 != null) {
                float f8 = motionPaths.f31588c;
                if (f8 < f3) {
                    easing = easing2;
                    f4 = f8;
                } else if (Float.isNaN(f7)) {
                    f7 = motionPaths.f31588c;
                }
            }
        }
        if (easing != null) {
            float f9 = (Float.isNaN(f7) ? 1.0f : f7) - f4;
            double d3 = (f3 - f4) / f9;
            f3 = (((float) easing.a(d3)) * f9) + f4;
            if (fArr != null) {
                fArr[0] = (float) easing.b(d3);
            }
        }
        return f3;
    }

    private static DifferentialInterpolator o(int i3, String str, int i4) {
        if (i3 != -1) {
            return null;
        }
        final Easing easingC = Easing.c(str);
        return new DifferentialInterpolator() { // from class: androidx.constraintlayout.core.motion.Motion.1

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            float f31558a;

            @Override // androidx.constraintlayout.core.motion.utils.DifferentialInterpolator
            public float getInterpolation(float f3) {
                this.f31558a = f3;
                return (float) easingC.a(f3);
            }
        };
    }

    private float q() {
        float[] fArr = new float[2];
        float f3 = 1.0f / 99;
        double d3 = 0.0d;
        double d4 = 0.0d;
        int i3 = 0;
        float fHypot = 0.0f;
        while (i3 < 100) {
            float f4 = i3 * f3;
            double dA = f4;
            Easing easing = this.f31535d.f31586a;
            ArrayList arrayList = this.f31551t;
            int size = arrayList.size();
            float f5 = Float.NaN;
            int i4 = 0;
            float f6 = 0.0f;
            while (i4 < size) {
                Object obj = arrayList.get(i4);
                i4++;
                MotionPaths motionPaths = (MotionPaths) obj;
                float f7 = f3;
                Easing easing2 = motionPaths.f31586a;
                if (easing2 != null) {
                    float f8 = motionPaths.f31588c;
                    if (f8 < f4) {
                        f6 = f8;
                        easing = easing2;
                    } else if (Float.isNaN(f5)) {
                        f5 = motionPaths.f31588c;
                    }
                }
                f3 = f7;
            }
            float f9 = f3;
            if (easing != null) {
                if (Float.isNaN(f5)) {
                    f5 = 1.0f;
                }
                dA = (((float) easing.a((f4 - f6) / r17)) * (f5 - f6)) + f6;
            }
            double d5 = dA;
            this.f31539h[0].d(d5, this.f31545n);
            int i5 = i3;
            this.f31535d.f(d5, this.f31544m, this.f31545n, fArr, 0);
            if (i5 > 0) {
                fHypot += (float) Math.hypot(d4 - ((double) fArr[1]), d3 - ((double) fArr[0]));
            }
            d3 = fArr[0];
            d4 = fArr[1];
            i3 = i5 + 1;
            f3 = f9;
        }
        return fHypot;
    }

    private void s(MotionPaths motionPaths) {
        ArrayList arrayList = this.f31551t;
        int size = arrayList.size();
        MotionPaths motionPaths2 = null;
        int i3 = 0;
        while (i3 < size) {
            Object obj = arrayList.get(i3);
            i3++;
            MotionPaths motionPaths3 = (MotionPaths) obj;
            if (motionPaths.f31589d == motionPaths3.f31589d) {
                motionPaths2 = motionPaths3;
            }
        }
        if (motionPaths2 != null) {
            this.f31551t.remove(motionPaths2);
        }
        if (Collections.binarySearch(this.f31551t, motionPaths) == 0) {
            Utils.a("MotionController", " KeyPath position \"" + motionPaths.f31589d + "\" outside of range");
        }
        this.f31551t.add((-r0) - 1, motionPaths);
    }

    private void u(MotionPaths motionPaths) {
        motionPaths.o(this.f31533b.C(), this.f31533b.D(), this.f31533b.B(), this.f31533b.k());
    }

    public void A(MotionWidget motionWidget) {
        this.f31533b = motionWidget;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void B(int i3, int i4, float f3, long j3) {
        ArrayList arrayList;
        HashSet<String> hashSet;
        HashSet<String> hashSet2;
        int i5;
        String[] strArr;
        int i6;
        int i7;
        CustomVariable customVariable;
        SplineSet splineSetD;
        CustomVariable customVariable2;
        Integer num;
        HashSet hashSet3;
        HashSet hashSet4;
        int i8;
        SplineSet splineSetD2;
        CustomVariable customVariable3;
        new HashSet();
        HashSet hashSet5 = new HashSet();
        HashSet<String> hashSet6 = new HashSet();
        HashSet hashSet7 = new HashSet();
        HashMap map = new HashMap();
        C();
        int i9 = this.A;
        if (i9 != -1) {
            MotionPaths motionPaths = this.f31535d;
            if (motionPaths.f31596l == -1) {
                motionPaths.f31596l = i9;
            }
        }
        this.f31537f.e(this.f31538g, hashSet6);
        ArrayList arrayList2 = this.f31553v;
        int i10 = 0;
        if (arrayList2 != null) {
            int size = arrayList2.size();
            int i11 = 0;
            arrayList = null;
            while (i11 < size) {
                Object obj = arrayList2.get(i11);
                i11++;
                MotionKey motionKey = (MotionKey) obj;
                if (motionKey instanceof MotionKeyPosition) {
                    MotionKeyPosition motionKeyPosition = (MotionKeyPosition) motionKey;
                    s(new MotionPaths(i3, i4, motionKeyPosition, this.f31535d, this.f31536e));
                    int i12 = motionKeyPosition.f31669g;
                    if (i12 != -1) {
                        this.f31534c = i12;
                    }
                } else if (motionKey instanceof MotionKeyCycle) {
                    motionKey.i(hashSet7);
                } else if (motionKey instanceof MotionKeyTimeCycle) {
                    motionKey.i(hashSet5);
                } else if (motionKey instanceof MotionKeyTrigger) {
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add((MotionKeyTrigger) motionKey);
                } else {
                    motionKey.j(map);
                    motionKey.i(hashSet6);
                }
            }
        } else {
            arrayList = null;
        }
        if (arrayList != null) {
            this.f31557z = (MotionKeyTrigger[]) arrayList.toArray(new MotionKeyTrigger[0]);
        }
        int i13 = 1;
        if (hashSet6.isEmpty()) {
            hashSet = hashSet5;
            hashSet2 = hashSet7;
            i5 = 1;
        } else {
            this.f31555x = new HashMap();
            for (String str : hashSet6) {
                if (str.startsWith("CUSTOM,")) {
                    KeyFrameArray.CustomVar customVar = new KeyFrameArray.CustomVar();
                    String str2 = str.split(",")[i13];
                    i8 = i13;
                    ArrayList arrayList3 = this.f31553v;
                    int size2 = arrayList3.size();
                    while (i10 < size2) {
                        Object obj2 = arrayList3.get(i10);
                        i10++;
                        HashSet hashSet8 = hashSet5;
                        MotionKey motionKey2 = (MotionKey) obj2;
                        HashSet hashSet9 = hashSet7;
                        HashMap map2 = motionKey2.f31632e;
                        if (map2 != null && (customVariable3 = (CustomVariable) map2.get(str2)) != null) {
                            customVar.a(motionKey2.f31628a, customVariable3);
                        }
                        hashSet7 = hashSet9;
                        hashSet5 = hashSet8;
                    }
                    hashSet3 = hashSet5;
                    hashSet4 = hashSet7;
                    splineSetD2 = SplineSet.c(str, customVar);
                } else {
                    hashSet3 = hashSet5;
                    hashSet4 = hashSet7;
                    i8 = i13;
                    splineSetD2 = SplineSet.d(str, j3);
                }
                if (splineSetD2 != null) {
                    splineSetD2.g(str);
                    this.f31555x.put(str, splineSetD2);
                }
                i13 = i8;
                hashSet7 = hashSet4;
                hashSet5 = hashSet3;
                i10 = 0;
            }
            hashSet = hashSet5;
            hashSet2 = hashSet7;
            i5 = i13;
            ArrayList arrayList4 = this.f31553v;
            if (arrayList4 != null) {
                int size3 = arrayList4.size();
                int i14 = 0;
                while (i14 < size3) {
                    Object obj3 = arrayList4.get(i14);
                    i14++;
                    MotionKey motionKey3 = (MotionKey) obj3;
                    if (motionKey3 instanceof MotionKeyAttributes) {
                        motionKey3.f(this.f31555x);
                    }
                }
            }
            this.f31537f.a(this.f31555x, 0);
            this.f31538g.a(this.f31555x, 100);
            for (String str3 : this.f31555x.keySet()) {
                int iIntValue = (!map.containsKey(str3) || (num = (Integer) map.get(str3)) == null) ? 0 : num.intValue();
                SplineSet splineSet = (SplineSet) this.f31555x.get(str3);
                if (splineSet != null) {
                    splineSet.h(iIntValue);
                }
            }
        }
        if (!hashSet.isEmpty()) {
            if (this.f31554w == null) {
                this.f31554w = new HashMap();
            }
            for (String str4 : hashSet) {
                if (!this.f31554w.containsKey(str4)) {
                    if (str4.startsWith("CUSTOM,")) {
                        KeyFrameArray.CustomVar customVar2 = new KeyFrameArray.CustomVar();
                        String str5 = str4.split(",")[i5];
                        ArrayList arrayList5 = this.f31553v;
                        int size4 = arrayList5.size();
                        int i15 = 0;
                        while (i15 < size4) {
                            Object obj4 = arrayList5.get(i15);
                            i15++;
                            MotionKey motionKey4 = (MotionKey) obj4;
                            HashMap map3 = motionKey4.f31632e;
                            if (map3 != null && (customVariable2 = (CustomVariable) map3.get(str5)) != null) {
                                customVar2.a(motionKey4.f31628a, customVariable2);
                            }
                        }
                        splineSetD = SplineSet.c(str4, customVar2);
                    } else {
                        splineSetD = SplineSet.d(str4, j3);
                    }
                    if (splineSetD != null) {
                        splineSetD.g(str4);
                    }
                }
            }
            ArrayList arrayList6 = this.f31553v;
            if (arrayList6 != null) {
                int size5 = arrayList6.size();
                int i16 = 0;
                while (i16 < size5) {
                    Object obj5 = arrayList6.get(i16);
                    i16++;
                    MotionKey motionKey5 = (MotionKey) obj5;
                    if (motionKey5 instanceof MotionKeyTimeCycle) {
                        ((MotionKeyTimeCycle) motionKey5).m(this.f31554w);
                    }
                }
            }
            for (String str6 : this.f31554w.keySet()) {
                ((TimeCycleSplineSet) this.f31554w.get(str6)).e(map.containsKey(str6) ? ((Integer) map.get(str6)).intValue() : 0);
            }
        }
        int size6 = this.f31551t.size();
        int i17 = size6 + 2;
        MotionPaths[] motionPathsArr = new MotionPaths[i17];
        motionPathsArr[0] = this.f31535d;
        motionPathsArr[size6 + 1] = this.f31536e;
        if (this.f31551t.size() > 0 && this.f31534c == MotionKey.f31627f) {
            this.f31534c = 0;
        }
        ArrayList arrayList7 = this.f31551t;
        int size7 = arrayList7.size();
        int i18 = i5;
        int i19 = 0;
        while (i19 < size7) {
            Object obj6 = arrayList7.get(i19);
            i19++;
            motionPathsArr[i18] = (MotionPaths) obj6;
            i18++;
        }
        HashSet hashSet10 = new HashSet();
        for (String str7 : this.f31536e.f31600p.keySet()) {
            if (this.f31535d.f31600p.containsKey(str7)) {
                if (!hashSet6.contains("CUSTOM," + str7)) {
                    hashSet10.add(str7);
                }
            }
        }
        String[] strArr2 = (String[]) hashSet10.toArray(new String[0]);
        this.f31547p = strArr2;
        this.f31548q = new int[strArr2.length];
        int i20 = 0;
        while (true) {
            strArr = this.f31547p;
            if (i20 >= strArr.length) {
                break;
            }
            String str8 = strArr[i20];
            this.f31548q[i20] = 0;
            int i21 = 0;
            while (true) {
                if (i21 >= i17) {
                    break;
                }
                if (motionPathsArr[i21].f31600p.containsKey(str8) && (customVariable = (CustomVariable) motionPathsArr[i21].f31600p.get(str8)) != null) {
                    int[] iArr = this.f31548q;
                    iArr[i20] = iArr[i20] + customVariable.m();
                    break;
                }
                i21++;
            }
            i20++;
        }
        boolean z2 = motionPathsArr[0].f31596l != -1 ? i5 : 0;
        int length = 18 + strArr.length;
        boolean[] zArr = new boolean[length];
        for (int i22 = i5; i22 < i17; i22++) {
            motionPathsArr[i22].d(motionPathsArr[i22 - 1], zArr, this.f31547p, z2);
        }
        int i23 = 0;
        for (int i24 = i5; i24 < length; i24++) {
            if (zArr[i24]) {
                i23++;
            }
        }
        this.f31544m = new int[i23];
        int i25 = 2;
        int iMax = Math.max(2, i23);
        this.f31545n = new double[iMax];
        this.f31546o = new double[iMax];
        int i26 = 0;
        for (int i27 = i5; i27 < length; i27++) {
            if (zArr[i27]) {
                this.f31544m[i26] = i27;
                i26++;
            }
        }
        int[] iArr2 = new int[2];
        iArr2[i5] = this.f31544m.length;
        iArr2[0] = i17;
        Class cls = Double.TYPE;
        double[][] dArr = (double[][]) Array.newInstance((Class<?>) cls, iArr2);
        double[] dArr2 = new double[i17];
        for (int i28 = 0; i28 < i17; i28++) {
            motionPathsArr[i28].e(dArr[i28], this.f31544m);
            dArr2[i28] = motionPathsArr[i28].f31588c;
        }
        int i29 = 0;
        while (true) {
            int[] iArr3 = this.f31544m;
            if (i29 >= iArr3.length) {
                break;
            }
            if (iArr3[i29] < MotionPaths.f31585u.length) {
                String str9 = MotionPaths.f31585u[this.f31544m[i29]] + " [";
                for (int i30 = 0; i30 < i17; i30++) {
                    str9 = str9 + dArr[i30][i29];
                }
            }
            i29++;
        }
        this.f31539h = new CurveFit[this.f31547p.length + 1];
        int i31 = 0;
        while (true) {
            String[] strArr3 = this.f31547p;
            if (i31 >= strArr3.length) {
                break;
            }
            String str10 = strArr3[i31];
            int i32 = 0;
            int i33 = 0;
            double[] dArr3 = null;
            double[][] dArr4 = null;
            while (i32 < i17) {
                if (motionPathsArr[i32].j(str10)) {
                    if (dArr4 == null) {
                        dArr3 = new double[i17];
                        int[] iArr4 = new int[i25];
                        iArr4[i5] = motionPathsArr[i32].i(str10);
                        i7 = 0;
                        iArr4[0] = i17;
                        dArr4 = (double[][]) Array.newInstance((Class<?>) cls, iArr4);
                    } else {
                        i7 = 0;
                    }
                    MotionPaths motionPaths2 = motionPathsArr[i32];
                    i6 = i31;
                    dArr3[i33] = motionPaths2.f31588c;
                    motionPaths2.h(str10, dArr4[i33], i7);
                    i33++;
                } else {
                    i6 = i31;
                }
                i32++;
                i31 = i6;
                i25 = 2;
            }
            int i34 = i31 + 1;
            this.f31539h[i34] = CurveFit.a(this.f31534c, Arrays.copyOf(dArr3, i33), (double[][]) Arrays.copyOf(dArr4, i33));
            i31 = i34;
            i25 = 2;
        }
        int i35 = 0;
        this.f31539h[0] = CurveFit.a(this.f31534c, dArr2, dArr);
        if (motionPathsArr[0].f31596l != -1) {
            int[] iArr5 = new int[i17];
            double[] dArr5 = new double[i17];
            int[] iArr6 = new int[2];
            iArr6[i5] = 2;
            iArr6[0] = i17;
            double[][] dArr6 = (double[][]) Array.newInstance((Class<?>) cls, iArr6);
            for (int i36 = 0; i36 < i17; i36++) {
                iArr5[i36] = motionPathsArr[i36].f31596l;
                dArr5[i36] = r6.f31588c;
                double[] dArr7 = dArr6[i36];
                dArr7[0] = r6.f31590f;
                dArr7[i5] = r6.f31591g;
            }
            i35 = 0;
            this.f31540i = CurveFit.b(iArr5, dArr5, dArr6);
        }
        this.f31556y = new HashMap();
        if (this.f31553v != null) {
            float fQ = Float.NaN;
            for (String str11 : hashSet2) {
                KeyCycleOscillator keyCycleOscillatorC = KeyCycleOscillator.c(str11);
                if (keyCycleOscillatorC != null) {
                    if (keyCycleOscillatorC.j() && Float.isNaN(fQ)) {
                        fQ = q();
                    }
                    keyCycleOscillatorC.h(str11);
                    this.f31556y.put(str11, keyCycleOscillatorC);
                }
            }
            ArrayList arrayList8 = this.f31553v;
            int size8 = arrayList8.size();
            int i37 = i35;
            while (i37 < size8) {
                Object obj7 = arrayList8.get(i37);
                i37++;
                MotionKey motionKey6 = (MotionKey) obj7;
                if (motionKey6 instanceof MotionKeyCycle) {
                    ((MotionKeyCycle) motionKey6).m(this.f31556y);
                }
            }
            Iterator it = this.f31556y.values().iterator();
            while (it.hasNext()) {
                ((KeyCycleOscillator) it.next()).i(fQ);
            }
        }
    }

    public void D(Motion motion) {
        this.H = motion;
    }

    @Override // androidx.constraintlayout.core.motion.utils.TypedValues
    public int a(String str) {
        return 0;
    }

    @Override // androidx.constraintlayout.core.motion.utils.TypedValues
    public boolean b(int i3, int i4) {
        if (i3 == 509) {
            w(i4);
            return true;
        }
        if (i3 != 610) {
            return i3 == 704;
        }
        this.D = i4;
        return true;
    }

    @Override // androidx.constraintlayout.core.motion.utils.TypedValues
    public boolean c(int i3, float f3) {
        if (602 == i3) {
            this.E = f3;
            return true;
        }
        if (600 != i3) {
            return false;
        }
        this.f31541j = f3;
        return true;
    }

    @Override // androidx.constraintlayout.core.motion.utils.TypedValues
    public boolean d(int i3, boolean z2) {
        return false;
    }

    @Override // androidx.constraintlayout.core.motion.utils.TypedValues
    public boolean e(int i3, String str) {
        if (705 == i3 || 611 == i3) {
            this.F = o(-1, str, 0);
            return true;
        }
        if (605 != i3) {
            return false;
        }
        this.f31535d.f31597m = str;
        return true;
    }

    public void f(MotionKey motionKey) {
        this.f31553v.add(motionKey);
    }

    public int g(float[] fArr, int[] iArr, int[] iArr2) {
        if (fArr == null) {
            return 0;
        }
        double[] dArrH = this.f31539h[0].h();
        if (iArr != null) {
            ArrayList arrayList = this.f31551t;
            int size = arrayList.size();
            int i3 = 0;
            int i4 = 0;
            while (i4 < size) {
                Object obj = arrayList.get(i4);
                i4++;
                iArr[i3] = ((MotionPaths) obj).f31601q;
                i3++;
            }
        }
        if (iArr2 != null) {
            ArrayList arrayList2 = this.f31551t;
            int size2 = arrayList2.size();
            int i5 = 0;
            int i6 = 0;
            while (i6 < size2) {
                Object obj2 = arrayList2.get(i6);
                i6++;
                iArr2[i5] = (int) (((MotionPaths) obj2).f31589d * 100.0f);
                i5++;
            }
        }
        int i7 = 0;
        for (int i8 = 0; i8 < dArrH.length; i8++) {
            this.f31539h[0].d(dArrH[i8], this.f31545n);
            this.f31535d.f(dArrH[i8], this.f31544m, this.f31545n, fArr, i7);
            i7 += 2;
        }
        return i7 / 2;
    }

    public void h(float[] fArr, int i3) {
        int i4 = i3;
        float f3 = 1.0f;
        float f4 = 1.0f / (i4 - 1);
        HashMap map = this.f31555x;
        SplineSet splineSet = map == null ? null : (SplineSet) map.get("translationX");
        HashMap map2 = this.f31555x;
        SplineSet splineSet2 = map2 == null ? null : (SplineSet) map2.get("translationY");
        HashMap map3 = this.f31556y;
        KeyCycleOscillator keyCycleOscillator = map3 == null ? null : (KeyCycleOscillator) map3.get("translationX");
        HashMap map4 = this.f31556y;
        KeyCycleOscillator keyCycleOscillator2 = map4 != null ? (KeyCycleOscillator) map4.get("translationY") : null;
        int i5 = 0;
        while (i5 < i4) {
            float fMin = i5 * f4;
            float f5 = this.f31543l;
            float f6 = 0.0f;
            if (f5 != f3) {
                float f7 = this.f31542k;
                if (fMin < f7) {
                    fMin = 0.0f;
                }
                if (fMin > f7 && fMin < 1.0d) {
                    fMin = Math.min((fMin - f7) * f5, f3);
                }
            }
            double dA = fMin;
            Easing easing = this.f31535d.f31586a;
            ArrayList arrayList = this.f31551t;
            int size = arrayList.size();
            float f8 = Float.NaN;
            int i6 = 0;
            while (i6 < size) {
                Object obj = arrayList.get(i6);
                i6++;
                MotionPaths motionPaths = (MotionPaths) obj;
                float f9 = f4;
                Easing easing2 = motionPaths.f31586a;
                if (easing2 != null) {
                    float f10 = motionPaths.f31588c;
                    if (f10 < fMin) {
                        f6 = f10;
                        easing = easing2;
                    } else if (Float.isNaN(f8)) {
                        f8 = motionPaths.f31588c;
                    }
                }
                f4 = f9;
            }
            float f11 = f4;
            if (easing != null) {
                if (Float.isNaN(f8)) {
                    f8 = 1.0f;
                }
                dA = (((float) easing.a((fMin - f6) / r17)) * (f8 - f6)) + f6;
            }
            this.f31539h[0].d(dA, this.f31545n);
            CurveFit curveFit = this.f31540i;
            if (curveFit != null) {
                double[] dArr = this.f31545n;
                if (dArr.length > 0) {
                    curveFit.d(dA, dArr);
                }
            }
            int i7 = i5 * 2;
            this.f31535d.f(dA, this.f31544m, this.f31545n, fArr, i7);
            if (keyCycleOscillator != null) {
                fArr[i7] = fArr[i7] + keyCycleOscillator.a(fMin);
            } else if (splineSet != null) {
                fArr[i7] = fArr[i7] + splineSet.a(fMin);
            }
            if (keyCycleOscillator2 != null) {
                int i8 = i7 + 1;
                fArr[i8] = fArr[i8] + keyCycleOscillator2.a(fMin);
            } else if (splineSet2 != null) {
                int i9 = i7 + 1;
                fArr[i9] = fArr[i9] + splineSet2.a(fMin);
            }
            i5++;
            i4 = i3;
            f4 = f11;
            f3 = 1.0f;
        }
    }

    public String j() {
        return this.f31535d.f31597m;
    }

    public void k(double d3, float[] fArr, float[] fArr2) {
        double[] dArr = new double[4];
        double[] dArr2 = new double[4];
        this.f31539h[0].d(d3, dArr);
        this.f31539h[0].g(d3, dArr2);
        Arrays.fill(fArr2, 0.0f);
        this.f31535d.g(d3, this.f31544m, dArr, fArr, dArr2, fArr2);
    }

    public void l(float f3, float f4, float f5, float[] fArr) {
        double[] dArr;
        float fI = i(f3, this.f31552u);
        CurveFit[] curveFitArr = this.f31539h;
        int i3 = 0;
        if (curveFitArr == null) {
            MotionPaths motionPaths = this.f31536e;
            float f6 = motionPaths.f31590f;
            MotionPaths motionPaths2 = this.f31535d;
            float f7 = f6 - motionPaths2.f31590f;
            float f8 = motionPaths.f31591g - motionPaths2.f31591g;
            float f9 = (motionPaths.f31592h - motionPaths2.f31592h) + f7;
            float f10 = (motionPaths.f31593i - motionPaths2.f31593i) + f8;
            fArr[0] = (f7 * (1.0f - f4)) + (f9 * f4);
            fArr[1] = (f8 * (1.0f - f5)) + (f10 * f5);
            return;
        }
        double d3 = fI;
        curveFitArr[0].g(d3, this.f31546o);
        this.f31539h[0].d(d3, this.f31545n);
        float f11 = this.f31552u[0];
        while (true) {
            dArr = this.f31546o;
            if (i3 >= dArr.length) {
                break;
            }
            dArr[i3] = dArr[i3] * ((double) f11);
            i3++;
        }
        CurveFit curveFit = this.f31540i;
        if (curveFit == null) {
            this.f31535d.p(f4, f5, fArr, this.f31544m, dArr, this.f31545n);
            return;
        }
        double[] dArr2 = this.f31545n;
        if (dArr2.length > 0) {
            curveFit.d(d3, dArr2);
            this.f31540i.g(d3, this.f31546o);
            this.f31535d.p(f4, f5, fArr, this.f31544m, this.f31546o, this.f31545n);
        }
    }

    public float m() {
        return this.f31536e.f31590f;
    }

    public float n() {
        return this.f31536e.f31591g;
    }

    public float p() {
        return this.f31541j;
    }

    public MotionWidget r() {
        return this.f31533b;
    }

    public boolean t(MotionWidget motionWidget, float f3, long j3, KeyCache keyCache) {
        MotionWidget motionWidget2 = motionWidget;
        float fI = i(f3, null);
        int i3 = this.D;
        if (i3 != -1) {
            float f4 = 1.0f / i3;
            float fFloor = ((float) Math.floor(fI / f4)) * f4;
            float f5 = (fI % f4) / f4;
            if (!Float.isNaN(this.E)) {
                f5 = (f5 + this.E) % 1.0f;
            }
            DifferentialInterpolator differentialInterpolator = this.F;
            fI = ((differentialInterpolator != null ? differentialInterpolator.getInterpolation(f5) : ((double) f5) > 0.5d ? 1.0f : 0.0f) * f4) + fFloor;
        }
        float f6 = fI;
        HashMap map = this.f31555x;
        if (map != null) {
            Iterator it = map.values().iterator();
            while (it.hasNext()) {
                ((SplineSet) it.next()).f(motionWidget2, f6);
            }
        }
        CurveFit[] curveFitArr = this.f31539h;
        if (curveFitArr != null) {
            double d3 = f6;
            curveFitArr[0].d(d3, this.f31545n);
            this.f31539h[0].g(d3, this.f31546o);
            CurveFit curveFit = this.f31540i;
            if (curveFit != null) {
                double[] dArr = this.f31545n;
                if (dArr.length > 0) {
                    curveFit.d(d3, dArr);
                    this.f31540i.g(d3, this.f31546o);
                }
            }
            if (!this.G) {
                this.f31535d.q(f6, motionWidget2, this.f31544m, this.f31545n, this.f31546o, null);
                f6 = f6;
                motionWidget2 = motionWidget2;
            }
            if (this.B != -1) {
                if (this.C == null) {
                    this.C = motionWidget2.m().f(this.B);
                }
                if (this.C != null) {
                    float fV = (r1.v() + this.C.h()) / 2.0f;
                    float fL = (this.C.l() + this.C.p()) / 2.0f;
                    if (motionWidget2.p() - motionWidget2.l() > 0 && motionWidget2.h() - motionWidget2.v() > 0) {
                        motionWidget2.J(fL - motionWidget2.l());
                        motionWidget2.K(fV - motionWidget2.v());
                    }
                }
            }
            int i4 = 1;
            while (true) {
                CurveFit[] curveFitArr2 = this.f31539h;
                if (i4 >= curveFitArr2.length) {
                    break;
                }
                curveFitArr2[i4].e(d3, this.f31550s);
                ((CustomVariable) this.f31535d.f31600p.get(this.f31547p[i4 - 1])).q(motionWidget2, this.f31550s);
                i4++;
            }
            MotionConstrainedPoint motionConstrainedPoint = this.f31537f;
            if (motionConstrainedPoint.f31561b == 0) {
                if (f6 <= 0.0f) {
                    motionWidget2.Q(motionConstrainedPoint.f31562c);
                } else if (f6 >= 1.0f) {
                    motionWidget2.Q(this.f31538g.f31562c);
                } else if (this.f31538g.f31562c != motionConstrainedPoint.f31562c) {
                    motionWidget2.Q(4);
                }
            }
            if (this.f31557z != null) {
                int i5 = 0;
                while (true) {
                    MotionKeyTrigger[] motionKeyTriggerArr = this.f31557z;
                    if (i5 >= motionKeyTriggerArr.length) {
                        break;
                    }
                    motionKeyTriggerArr[i5].m(f6, motionWidget2);
                    i5++;
                }
            }
        } else {
            MotionPaths motionPaths = this.f31535d;
            float f7 = motionPaths.f31590f;
            MotionPaths motionPaths2 = this.f31536e;
            float f8 = f7 + ((motionPaths2.f31590f - f7) * f6);
            float f9 = motionPaths.f31591g;
            float f10 = f9 + ((motionPaths2.f31591g - f9) * f6);
            float f11 = motionPaths.f31592h;
            float f12 = f11 + ((motionPaths2.f31592h - f11) * f6);
            float f13 = motionPaths.f31593i;
            float f14 = f8 + 0.5f;
            float f15 = f10 + 0.5f;
            motionWidget2.E((int) f14, (int) f15, (int) (f14 + f12), (int) (f15 + f13 + ((motionPaths2.f31593i - f13) * f6)));
        }
        HashMap map2 = this.f31556y;
        if (map2 != null) {
            for (KeyCycleOscillator keyCycleOscillator : map2.values()) {
                if (keyCycleOscillator instanceof KeyCycleOscillator.PathRotateSet) {
                    double[] dArr2 = this.f31546o;
                    ((KeyCycleOscillator.PathRotateSet) keyCycleOscillator).k(motionWidget2, f6, dArr2[0], dArr2[1]);
                } else {
                    keyCycleOscillator.g(motionWidget2, f6);
                }
            }
        }
        return false;
    }

    public String toString() {
        return " start: x: " + this.f31535d.f31590f + " y: " + this.f31535d.f31591g + " end: x: " + this.f31536e.f31590f + " y: " + this.f31536e.f31591g;
    }

    public void v(MotionWidget motionWidget) {
        MotionPaths motionPaths = this.f31536e;
        motionPaths.f31588c = 1.0f;
        motionPaths.f31589d = 1.0f;
        u(motionPaths);
        this.f31536e.o(motionWidget.l(), motionWidget.v(), motionWidget.B(), motionWidget.k());
        this.f31536e.a(motionWidget);
        this.f31538g.g(motionWidget);
    }

    public void w(int i3) {
        this.A = i3;
    }

    public void x(float f3) {
        this.f31542k = f3;
    }

    public void y(float f3) {
        this.f31543l = f3;
    }

    public void z(MotionWidget motionWidget) {
        MotionPaths motionPaths = this.f31535d;
        motionPaths.f31588c = 0.0f;
        motionPaths.f31589d = 0.0f;
        motionPaths.o(motionWidget.C(), motionWidget.D(), motionWidget.B(), motionWidget.k());
        this.f31535d.a(motionWidget);
        this.f31537f.g(motionWidget);
        TypedBundle typedBundleJ = motionWidget.A().j();
        if (typedBundleJ != null) {
            typedBundleJ.g(this);
        }
    }
}
