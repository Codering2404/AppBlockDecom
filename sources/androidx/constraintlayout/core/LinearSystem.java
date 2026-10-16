package androidx.constraintlayout.core;

import androidx.constraintlayout.core.SolverVariable;
import androidx.constraintlayout.core.widgets.ConstraintAnchor;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import java.util.Arrays;
import java.util.HashMap;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public class LinearSystem {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static boolean f31167s = false;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static boolean f31168t = true;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static boolean f31169u = true;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static boolean f31170v = true;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static boolean f31171w = false;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static Metrics f31172x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static long f31173y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static long f31174z;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Row f31179e;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    final Cache f31189o;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private Row f31192r;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f31175a = 1000;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f31176b = false;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    int f31177c = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private HashMap f31178d = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f31180f = 32;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f31181g = 32;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f31183i = false;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f31184j = false;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private boolean[] f31185k = new boolean[32];

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    int f31186l = 1;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    int f31187m = 0;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private int f31188n = 32;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private SolverVariable[] f31190p = new SolverVariable[1000];

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private int f31191q = 0;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    ArrayRow[] f31182h = new ArrayRow[32];

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    interface Row {
        void a(Row row);

        SolverVariable b(LinearSystem linearSystem, boolean[] zArr);

        void c(SolverVariable solverVariable);

        void clear();

        SolverVariable getKey();

        boolean isEmpty();
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class ValuesRow extends ArrayRow {
        ValuesRow(Cache cache) {
            this.f31161e = new SolverVariableValues(this, cache);
        }
    }

    public LinearSystem() {
        F();
        Cache cache = new Cache();
        this.f31189o = cache;
        this.f31179e = new PriorityGoalRow(cache);
        if (f31171w) {
            this.f31192r = new ValuesRow(cache);
        } else {
            this.f31192r = new ArrayRow(cache);
        }
    }

    private void B() {
        int i3 = this.f31180f * 2;
        this.f31180f = i3;
        this.f31182h = (ArrayRow[]) Arrays.copyOf(this.f31182h, i3);
        Cache cache = this.f31189o;
        cache.f31166d = (SolverVariable[]) Arrays.copyOf(cache.f31166d, this.f31180f);
        int i4 = this.f31180f;
        this.f31185k = new boolean[i4];
        this.f31181g = i4;
        this.f31188n = i4;
        Metrics metrics = f31172x;
        if (metrics != null) {
            metrics.f31197e++;
            metrics.f31208p = Math.max(metrics.f31208p, i4);
            Metrics metrics2 = f31172x;
            metrics2.f31217y = metrics2.f31208p;
        }
    }

    private int E(Row row, boolean z2) {
        Metrics metrics = f31172x;
        if (metrics != null) {
            metrics.f31201i++;
        }
        for (int i3 = 0; i3 < this.f31186l; i3++) {
            this.f31185k[i3] = false;
        }
        boolean z3 = false;
        int i4 = 0;
        while (!z3) {
            Metrics metrics2 = f31172x;
            if (metrics2 != null) {
                metrics2.f31202j++;
            }
            i4++;
            if (i4 < this.f31186l * 2) {
                if (row.getKey() != null) {
                    this.f31185k[row.getKey().f31234c] = true;
                }
                SolverVariable solverVariableB = row.b(this, this.f31185k);
                if (solverVariableB != null) {
                    boolean[] zArr = this.f31185k;
                    int i5 = solverVariableB.f31234c;
                    if (!zArr[i5]) {
                        zArr[i5] = true;
                    }
                }
                if (solverVariableB != null) {
                    float f3 = Float.MAX_VALUE;
                    int i6 = -1;
                    for (int i7 = 0; i7 < this.f31187m; i7++) {
                        ArrayRow arrayRow = this.f31182h[i7];
                        if (arrayRow.f31157a.f31241k != SolverVariable.Type.UNRESTRICTED && !arrayRow.f31162f && arrayRow.t(solverVariableB)) {
                            float fM = arrayRow.f31161e.m(solverVariableB);
                            if (fM < 0.0f) {
                                float f4 = (-arrayRow.f31158b) / fM;
                                if (f4 < f3) {
                                    i6 = i7;
                                    f3 = f4;
                                }
                            }
                        }
                    }
                    if (i6 > -1) {
                        ArrayRow arrayRow2 = this.f31182h[i6];
                        arrayRow2.f31157a.f31235d = -1;
                        Metrics metrics3 = f31172x;
                        if (metrics3 != null) {
                            metrics3.f31203k++;
                        }
                        arrayRow2.x(solverVariableB);
                        SolverVariable solverVariable = arrayRow2.f31157a;
                        solverVariable.f31235d = i6;
                        solverVariable.h(this, arrayRow2);
                    }
                } else {
                    z3 = true;
                }
            }
            return i4;
        }
        return i4;
    }

    private void F() {
        int i3 = 0;
        if (f31171w) {
            while (i3 < this.f31187m) {
                ArrayRow arrayRow = this.f31182h[i3];
                if (arrayRow != null) {
                    this.f31189o.f31163a.b(arrayRow);
                }
                this.f31182h[i3] = null;
                i3++;
            }
            return;
        }
        while (i3 < this.f31187m) {
            ArrayRow arrayRow2 = this.f31182h[i3];
            if (arrayRow2 != null) {
                this.f31189o.f31164b.b(arrayRow2);
            }
            this.f31182h[i3] = null;
            i3++;
        }
    }

    private SolverVariable a(SolverVariable.Type type, String str) {
        SolverVariable solverVariable = (SolverVariable) this.f31189o.f31165c.a();
        if (solverVariable == null) {
            solverVariable = new SolverVariable(type, str);
            solverVariable.g(type, str);
        } else {
            solverVariable.e();
            solverVariable.g(type, str);
        }
        int i3 = this.f31191q;
        int i4 = this.f31175a;
        if (i3 >= i4) {
            int i5 = i4 * 2;
            this.f31175a = i5;
            this.f31190p = (SolverVariable[]) Arrays.copyOf(this.f31190p, i5);
        }
        SolverVariable[] solverVariableArr = this.f31190p;
        int i6 = this.f31191q;
        this.f31191q = i6 + 1;
        solverVariableArr[i6] = solverVariable;
        return solverVariable;
    }

    private void l(ArrayRow arrayRow) {
        int i3;
        if (f31169u && arrayRow.f31162f) {
            arrayRow.f31157a.f(this, arrayRow.f31158b);
        } else {
            ArrayRow[] arrayRowArr = this.f31182h;
            int i4 = this.f31187m;
            arrayRowArr[i4] = arrayRow;
            SolverVariable solverVariable = arrayRow.f31157a;
            solverVariable.f31235d = i4;
            this.f31187m = i4 + 1;
            solverVariable.h(this, arrayRow);
        }
        if (f31169u && this.f31176b) {
            int i5 = 0;
            while (i5 < this.f31187m) {
                if (this.f31182h[i5] == null) {
                    System.out.println("WTF");
                }
                ArrayRow arrayRow2 = this.f31182h[i5];
                if (arrayRow2 != null && arrayRow2.f31162f) {
                    arrayRow2.f31157a.f(this, arrayRow2.f31158b);
                    if (f31171w) {
                        this.f31189o.f31163a.b(arrayRow2);
                    } else {
                        this.f31189o.f31164b.b(arrayRow2);
                    }
                    this.f31182h[i5] = null;
                    int i6 = i5 + 1;
                    int i7 = i6;
                    while (true) {
                        i3 = this.f31187m;
                        if (i6 >= i3) {
                            break;
                        }
                        ArrayRow[] arrayRowArr2 = this.f31182h;
                        int i8 = i6 - 1;
                        ArrayRow arrayRow3 = arrayRowArr2[i6];
                        arrayRowArr2[i8] = arrayRow3;
                        SolverVariable solverVariable2 = arrayRow3.f31157a;
                        if (solverVariable2.f31235d == i6) {
                            solverVariable2.f31235d = i8;
                        }
                        i7 = i6;
                        i6++;
                    }
                    if (i7 < i3) {
                        this.f31182h[i7] = null;
                    }
                    this.f31187m = i3 - 1;
                    i5--;
                }
                i5++;
            }
            this.f31176b = false;
        }
    }

    private void n() {
        for (int i3 = 0; i3 < this.f31187m; i3++) {
            ArrayRow arrayRow = this.f31182h[i3];
            arrayRow.f31157a.f31237g = arrayRow.f31158b;
        }
    }

    public static ArrayRow s(LinearSystem linearSystem, SolverVariable solverVariable, SolverVariable solverVariable2, float f3) {
        return linearSystem.r().j(solverVariable, solverVariable2, f3);
    }

    private int u(Row row) {
        float f3;
        long j3;
        for (int i3 = 0; i3 < this.f31187m; i3++) {
            ArrayRow arrayRow = this.f31182h[i3];
            if (arrayRow.f31157a.f31241k != SolverVariable.Type.UNRESTRICTED) {
                float f4 = 0.0f;
                if (arrayRow.f31158b < 0.0f) {
                    boolean z2 = false;
                    int i4 = 0;
                    while (!z2) {
                        Metrics metrics = f31172x;
                        long j4 = 1;
                        if (metrics != null) {
                            metrics.f31204l++;
                        }
                        i4++;
                        float f5 = Float.MAX_VALUE;
                        int i5 = 0;
                        int i6 = -1;
                        int i7 = -1;
                        int i8 = 0;
                        while (true) {
                            if (i5 >= this.f31187m) {
                                break;
                            }
                            ArrayRow arrayRow2 = this.f31182h[i5];
                            if (arrayRow2.f31157a.f31241k == SolverVariable.Type.UNRESTRICTED || arrayRow2.f31162f || arrayRow2.f31158b >= f4) {
                                f3 = f4;
                                j3 = j4;
                            } else if (f31170v) {
                                int iD = arrayRow2.f31161e.d();
                                int i9 = 0;
                                while (i9 < iD) {
                                    float f6 = f4;
                                    SolverVariable solverVariableF = arrayRow2.f31161e.f(i9);
                                    long j5 = j4;
                                    float fM = arrayRow2.f31161e.m(solverVariableF);
                                    if (fM > f6) {
                                        for (int i10 = 0; i10 < 9; i10++) {
                                            float f7 = solverVariableF.f31239i[i10] / fM;
                                            if ((f7 < f5 && i10 == i8) || i10 > i8) {
                                                i8 = i10;
                                                i7 = solverVariableF.f31234c;
                                                i6 = i5;
                                                f5 = f7;
                                            }
                                        }
                                    }
                                    i9++;
                                    f4 = f6;
                                    j4 = j5;
                                }
                                f3 = f4;
                                j3 = j4;
                            } else {
                                f3 = f4;
                                j3 = j4;
                                for (int i11 = 1; i11 < this.f31186l; i11++) {
                                    SolverVariable solverVariable = this.f31189o.f31166d[i11];
                                    float fM2 = arrayRow2.f31161e.m(solverVariable);
                                    if (fM2 > f3) {
                                        for (int i12 = 0; i12 < 9; i12++) {
                                            float f8 = solverVariable.f31239i[i12] / fM2;
                                            if ((f8 < f5 && i12 == i8) || i12 > i8) {
                                                i8 = i12;
                                                f5 = f8;
                                                i6 = i5;
                                                i7 = i11;
                                            }
                                        }
                                    }
                                }
                            }
                            i5++;
                            f4 = f3;
                            j4 = j3;
                        }
                        float f9 = f4;
                        long j6 = j4;
                        if (i6 != -1) {
                            ArrayRow arrayRow3 = this.f31182h[i6];
                            arrayRow3.f31157a.f31235d = -1;
                            Metrics metrics2 = f31172x;
                            if (metrics2 != null) {
                                metrics2.f31203k += j6;
                            }
                            arrayRow3.x(this.f31189o.f31166d[i7]);
                            SolverVariable solverVariable2 = arrayRow3.f31157a;
                            solverVariable2.f31235d = i6;
                            solverVariable2.h(this, arrayRow3);
                        } else {
                            z2 = true;
                        }
                        if (i4 > this.f31186l / 2) {
                            z2 = true;
                        }
                        f4 = f9;
                    }
                    return i4;
                }
            }
        }
        return 0;
    }

    public static Metrics x() {
        return f31172x;
    }

    public int A(Object obj) {
        SolverVariable solverVariableI = ((ConstraintAnchor) obj).i();
        if (solverVariableI != null) {
            return (int) (solverVariableI.f31237g + 0.5f);
        }
        return 0;
    }

    public void C() {
        Metrics metrics = f31172x;
        if (metrics != null) {
            metrics.f31198f++;
        }
        if (this.f31179e.isEmpty()) {
            n();
            return;
        }
        if (!this.f31183i && !this.f31184j) {
            D(this.f31179e);
            return;
        }
        Metrics metrics2 = f31172x;
        if (metrics2 != null) {
            metrics2.f31210r++;
        }
        for (int i3 = 0; i3 < this.f31187m; i3++) {
            if (!this.f31182h[i3].f31162f) {
                D(this.f31179e);
                return;
            }
        }
        Metrics metrics3 = f31172x;
        if (metrics3 != null) {
            metrics3.f31209q++;
        }
        n();
    }

    void D(Row row) {
        Metrics metrics = f31172x;
        if (metrics != null) {
            metrics.f31213u++;
            metrics.f31214v = Math.max(metrics.f31214v, this.f31186l);
            Metrics metrics2 = f31172x;
            metrics2.f31215w = Math.max(metrics2.f31215w, this.f31187m);
        }
        u(row);
        E(row, false);
        n();
    }

    public void G() {
        Cache cache;
        int i3 = 0;
        while (true) {
            cache = this.f31189o;
            SolverVariable[] solverVariableArr = cache.f31166d;
            if (i3 >= solverVariableArr.length) {
                break;
            }
            SolverVariable solverVariable = solverVariableArr[i3];
            if (solverVariable != null) {
                solverVariable.e();
            }
            i3++;
        }
        cache.f31165c.c(this.f31190p, this.f31191q);
        this.f31191q = 0;
        Arrays.fill(this.f31189o.f31166d, (Object) null);
        HashMap map = this.f31178d;
        if (map != null) {
            map.clear();
        }
        this.f31177c = 0;
        this.f31179e.clear();
        this.f31186l = 1;
        for (int i4 = 0; i4 < this.f31187m; i4++) {
            ArrayRow arrayRow = this.f31182h[i4];
            if (arrayRow != null) {
                arrayRow.f31159c = false;
            }
        }
        F();
        this.f31187m = 0;
        if (f31171w) {
            this.f31192r = new ValuesRow(this.f31189o);
        } else {
            this.f31192r = new ArrayRow(this.f31189o);
        }
    }

    public void b(ConstraintWidget constraintWidget, ConstraintWidget constraintWidget2, float f3, int i3) {
        ConstraintAnchor.Type type = ConstraintAnchor.Type.LEFT;
        SolverVariable solverVariableQ = q(constraintWidget.q(type));
        ConstraintAnchor.Type type2 = ConstraintAnchor.Type.TOP;
        SolverVariable solverVariableQ2 = q(constraintWidget.q(type2));
        ConstraintAnchor.Type type3 = ConstraintAnchor.Type.RIGHT;
        SolverVariable solverVariableQ3 = q(constraintWidget.q(type3));
        ConstraintAnchor.Type type4 = ConstraintAnchor.Type.BOTTOM;
        SolverVariable solverVariableQ4 = q(constraintWidget.q(type4));
        SolverVariable solverVariableQ5 = q(constraintWidget2.q(type));
        SolverVariable solverVariableQ6 = q(constraintWidget2.q(type2));
        SolverVariable solverVariableQ7 = q(constraintWidget2.q(type3));
        SolverVariable solverVariableQ8 = q(constraintWidget2.q(type4));
        ArrayRow arrayRowR = r();
        double d3 = f3;
        double d4 = i3;
        arrayRowR.q(solverVariableQ2, solverVariableQ4, solverVariableQ6, solverVariableQ8, (float) (Math.sin(d3) * d4));
        d(arrayRowR);
        ArrayRow arrayRowR2 = r();
        arrayRowR2.q(solverVariableQ, solverVariableQ3, solverVariableQ5, solverVariableQ7, (float) (Math.cos(d3) * d4));
        d(arrayRowR2);
    }

    public void c(SolverVariable solverVariable, SolverVariable solverVariable2, int i3, float f3, SolverVariable solverVariable3, SolverVariable solverVariable4, int i4, int i5) {
        ArrayRow arrayRowR = r();
        arrayRowR.h(solverVariable, solverVariable2, i3, f3, solverVariable3, solverVariable4, i4);
        if (i5 != 8) {
            arrayRowR.d(this, i5);
        }
        d(arrayRowR);
    }

    /* JADX WARN: Removed duplicated region for block: B:41:0x009a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void d(androidx.constraintlayout.core.ArrayRow r8) {
        /*
            r7 = this;
            if (r8 != 0) goto L4
            goto La8
        L4:
            androidx.constraintlayout.core.Metrics r0 = androidx.constraintlayout.core.LinearSystem.f31172x
            r1 = 1
            if (r0 == 0) goto L18
            long r3 = r0.f31199g
            long r3 = r3 + r1
            r0.f31199g = r3
            boolean r3 = r8.f31162f
            if (r3 == 0) goto L18
            long r3 = r0.f31200h
            long r3 = r3 + r1
            r0.f31200h = r3
        L18:
            int r0 = r7.f31187m
            r3 = 1
            int r0 = r0 + r3
            int r4 = r7.f31188n
            if (r0 >= r4) goto L27
            int r0 = r7.f31186l
            int r0 = r0 + r3
            int r4 = r7.f31181g
            if (r0 < r4) goto L2a
        L27:
            r7.B()
        L2a:
            boolean r0 = r8.f31162f
            r4 = 0
            if (r0 != 0) goto La3
            r8.D(r7)
            boolean r0 = r8.isEmpty()
            if (r0 == 0) goto L3a
            goto La8
        L3a:
            r8.r()
            boolean r0 = r8.f(r7)
            if (r0 == 0) goto L9a
            androidx.constraintlayout.core.SolverVariable r0 = r7.p()
            r8.f31157a = r0
            int r5 = r7.f31187m
            r7.l(r8)
            int r6 = r7.f31187m
            int r5 = r5 + r3
            if (r6 != r5) goto L9a
            androidx.constraintlayout.core.LinearSystem$Row r4 = r7.f31192r
            r4.a(r8)
            androidx.constraintlayout.core.LinearSystem$Row r4 = r7.f31192r
            r7.E(r4, r3)
            int r4 = r0.f31235d
            r5 = -1
            if (r4 != r5) goto L9b
            androidx.constraintlayout.core.SolverVariable r4 = r8.f31157a
            if (r4 != r0) goto L78
            androidx.constraintlayout.core.SolverVariable r0 = r8.v(r0)
            if (r0 == 0) goto L78
            androidx.constraintlayout.core.Metrics r4 = androidx.constraintlayout.core.LinearSystem.f31172x
            if (r4 == 0) goto L75
            long r5 = r4.f31203k
            long r5 = r5 + r1
            r4.f31203k = r5
        L75:
            r8.x(r0)
        L78:
            boolean r0 = r8.f31162f
            if (r0 != 0) goto L81
            androidx.constraintlayout.core.SolverVariable r0 = r8.f31157a
            r0.h(r7, r8)
        L81:
            boolean r0 = androidx.constraintlayout.core.LinearSystem.f31171w
            if (r0 == 0) goto L8d
            androidx.constraintlayout.core.Cache r0 = r7.f31189o
            androidx.constraintlayout.core.Pools$Pool r0 = r0.f31163a
            r0.b(r8)
            goto L94
        L8d:
            androidx.constraintlayout.core.Cache r0 = r7.f31189o
            androidx.constraintlayout.core.Pools$Pool r0 = r0.f31164b
            r0.b(r8)
        L94:
            int r0 = r7.f31187m
            int r0 = r0 - r3
            r7.f31187m = r0
            goto L9b
        L9a:
            r3 = r4
        L9b:
            boolean r0 = r8.s()
            if (r0 != 0) goto La2
            goto La8
        La2:
            r4 = r3
        La3:
            if (r4 != 0) goto La8
            r7.l(r8)
        La8:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.LinearSystem.d(androidx.constraintlayout.core.ArrayRow):void");
    }

    public ArrayRow e(SolverVariable solverVariable, SolverVariable solverVariable2, int i3, int i4) {
        Metrics metrics = f31172x;
        if (metrics != null) {
            metrics.J++;
        }
        if (f31168t && i4 == 8 && solverVariable2.f31238h && solverVariable.f31235d == -1) {
            solverVariable.f(this, solverVariable2.f31237g + i3);
            return null;
        }
        ArrayRow arrayRowR = r();
        arrayRowR.n(solverVariable, solverVariable2, i3);
        if (i4 != 8) {
            arrayRowR.d(this, i4);
        }
        d(arrayRowR);
        return arrayRowR;
    }

    public void f(SolverVariable solverVariable, int i3) {
        Metrics metrics = f31172x;
        if (metrics != null) {
            metrics.J++;
        }
        if (f31168t && solverVariable.f31235d == -1) {
            float f3 = i3;
            solverVariable.f(this, f3);
            for (int i4 = 0; i4 < this.f31177c + 1; i4++) {
                SolverVariable solverVariable2 = this.f31189o.f31166d[i4];
                if (solverVariable2 != null && solverVariable2.f31245o && solverVariable2.f31246p == solverVariable.f31234c) {
                    solverVariable2.f(this, solverVariable2.f31247q + f3);
                }
            }
            return;
        }
        int i5 = solverVariable.f31235d;
        if (i5 == -1) {
            ArrayRow arrayRowR = r();
            arrayRowR.i(solverVariable, i3);
            d(arrayRowR);
            return;
        }
        ArrayRow arrayRow = this.f31182h[i5];
        if (arrayRow.f31162f) {
            arrayRow.f31158b = i3;
            return;
        }
        if (arrayRow.f31161e.d() == 0) {
            arrayRow.f31162f = true;
            arrayRow.f31158b = i3;
        } else {
            ArrayRow arrayRowR2 = r();
            arrayRowR2.m(solverVariable, i3);
            d(arrayRowR2);
        }
    }

    public void g(SolverVariable solverVariable, SolverVariable solverVariable2, int i3, boolean z2) {
        ArrayRow arrayRowR = r();
        SolverVariable solverVariableT = t();
        solverVariableT.f31236f = 0;
        arrayRowR.o(solverVariable, solverVariable2, solverVariableT, i3);
        d(arrayRowR);
    }

    public void h(SolverVariable solverVariable, SolverVariable solverVariable2, int i3, int i4) {
        ArrayRow arrayRowR = r();
        SolverVariable solverVariableT = t();
        solverVariableT.f31236f = 0;
        arrayRowR.o(solverVariable, solverVariable2, solverVariableT, i3);
        if (i4 != 8) {
            m(arrayRowR, (int) (arrayRowR.f31161e.m(solverVariableT) * (-1.0f)), i4);
        }
        d(arrayRowR);
    }

    public void i(SolverVariable solverVariable, SolverVariable solverVariable2, int i3, boolean z2) {
        ArrayRow arrayRowR = r();
        SolverVariable solverVariableT = t();
        solverVariableT.f31236f = 0;
        arrayRowR.p(solverVariable, solverVariable2, solverVariableT, i3);
        d(arrayRowR);
    }

    public void j(SolverVariable solverVariable, SolverVariable solverVariable2, int i3, int i4) {
        ArrayRow arrayRowR = r();
        SolverVariable solverVariableT = t();
        solverVariableT.f31236f = 0;
        arrayRowR.p(solverVariable, solverVariable2, solverVariableT, i3);
        if (i4 != 8) {
            m(arrayRowR, (int) (arrayRowR.f31161e.m(solverVariableT) * (-1.0f)), i4);
        }
        d(arrayRowR);
    }

    public void k(SolverVariable solverVariable, SolverVariable solverVariable2, SolverVariable solverVariable3, SolverVariable solverVariable4, float f3, int i3) {
        ArrayRow arrayRowR = r();
        arrayRowR.k(solverVariable, solverVariable2, solverVariable3, solverVariable4, f3);
        if (i3 != 8) {
            arrayRowR.d(this, i3);
        }
        d(arrayRowR);
    }

    void m(ArrayRow arrayRow, int i3, int i4) {
        arrayRow.e(o(i4, null), i3);
    }

    public SolverVariable o(int i3, String str) {
        Metrics metrics = f31172x;
        if (metrics != null) {
            metrics.f31205m++;
        }
        if (this.f31186l + 1 >= this.f31181g) {
            B();
        }
        SolverVariable solverVariableA = a(SolverVariable.Type.ERROR, str);
        int i4 = this.f31177c + 1;
        this.f31177c = i4;
        this.f31186l++;
        solverVariableA.f31234c = i4;
        solverVariableA.f31236f = i3;
        this.f31189o.f31166d[i4] = solverVariableA;
        this.f31179e.c(solverVariableA);
        return solverVariableA;
    }

    public SolverVariable p() {
        Metrics metrics = f31172x;
        if (metrics != null) {
            metrics.f31207o++;
        }
        if (this.f31186l + 1 >= this.f31181g) {
            B();
        }
        SolverVariable solverVariableA = a(SolverVariable.Type.SLACK, null);
        int i3 = this.f31177c + 1;
        this.f31177c = i3;
        this.f31186l++;
        solverVariableA.f31234c = i3;
        this.f31189o.f31166d[i3] = solverVariableA;
        return solverVariableA;
    }

    public SolverVariable q(Object obj) {
        SolverVariable solverVariableI = null;
        if (obj == null) {
            return null;
        }
        if (this.f31186l + 1 >= this.f31181g) {
            B();
        }
        if (obj instanceof ConstraintAnchor) {
            ConstraintAnchor constraintAnchor = (ConstraintAnchor) obj;
            solverVariableI = constraintAnchor.i();
            if (solverVariableI == null) {
                constraintAnchor.s(this.f31189o);
                solverVariableI = constraintAnchor.i();
            }
            int i3 = solverVariableI.f31234c;
            if (i3 != -1 && i3 <= this.f31177c && this.f31189o.f31166d[i3] != null) {
                return solverVariableI;
            }
            if (i3 != -1) {
                solverVariableI.e();
            }
            int i4 = this.f31177c + 1;
            this.f31177c = i4;
            this.f31186l++;
            solverVariableI.f31234c = i4;
            solverVariableI.f31241k = SolverVariable.Type.UNRESTRICTED;
            this.f31189o.f31166d[i4] = solverVariableI;
        }
        return solverVariableI;
    }

    public ArrayRow r() {
        ArrayRow arrayRow;
        if (f31171w) {
            arrayRow = (ArrayRow) this.f31189o.f31163a.a();
            if (arrayRow == null) {
                arrayRow = new ValuesRow(this.f31189o);
                f31174z++;
            } else {
                arrayRow.y();
            }
        } else {
            arrayRow = (ArrayRow) this.f31189o.f31164b.a();
            if (arrayRow == null) {
                arrayRow = new ArrayRow(this.f31189o);
                f31173y++;
            } else {
                arrayRow.y();
            }
        }
        SolverVariable.c();
        return arrayRow;
    }

    public SolverVariable t() {
        Metrics metrics = f31172x;
        if (metrics != null) {
            metrics.f31206n++;
        }
        if (this.f31186l + 1 >= this.f31181g) {
            B();
        }
        SolverVariable solverVariableA = a(SolverVariable.Type.SLACK, null);
        int i3 = this.f31177c + 1;
        this.f31177c = i3;
        this.f31186l++;
        solverVariableA.f31234c = i3;
        this.f31189o.f31166d[i3] = solverVariableA;
        return solverVariableA;
    }

    public void v(Metrics metrics) {
        f31172x = metrics;
    }

    public Cache w() {
        return this.f31189o;
    }

    public int y() {
        return this.f31187m;
    }

    public int z() {
        return this.f31177c;
    }
}
