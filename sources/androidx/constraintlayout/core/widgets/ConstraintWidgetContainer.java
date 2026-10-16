package androidx.constraintlayout.core.widgets;

import androidx.constraintlayout.core.LinearSystem;
import androidx.constraintlayout.core.Metrics;
import androidx.constraintlayout.core.SolverVariable;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.core.widgets.analyzer.BasicMeasure;
import androidx.constraintlayout.core.widgets.analyzer.DependencyGraph;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public class ConstraintWidgetContainer extends WidgetContainer {
    public BasicMeasure.Measure A1;
    BasicMeasure W0;
    public DependencyGraph X0;
    private int Y0;
    protected BasicMeasure.Measurer Z0;

    /* JADX INFO: renamed from: a1, reason: collision with root package name */
    private boolean f32329a1;

    /* JADX INFO: renamed from: b1, reason: collision with root package name */
    public Metrics f32330b1;

    /* JADX INFO: renamed from: c1, reason: collision with root package name */
    protected LinearSystem f32331c1;

    /* JADX INFO: renamed from: d1, reason: collision with root package name */
    int f32332d1;

    /* JADX INFO: renamed from: e1, reason: collision with root package name */
    int f32333e1;

    /* JADX INFO: renamed from: f1, reason: collision with root package name */
    int f32334f1;

    /* JADX INFO: renamed from: g1, reason: collision with root package name */
    int f32335g1;

    /* JADX INFO: renamed from: h1, reason: collision with root package name */
    public int f32336h1;

    /* JADX INFO: renamed from: i1, reason: collision with root package name */
    public int f32337i1;

    /* JADX INFO: renamed from: j1, reason: collision with root package name */
    ChainHead[] f32338j1;

    /* JADX INFO: renamed from: k1, reason: collision with root package name */
    ChainHead[] f32339k1;

    /* JADX INFO: renamed from: l1, reason: collision with root package name */
    public boolean f32340l1;

    /* JADX INFO: renamed from: m1, reason: collision with root package name */
    public boolean f32341m1;

    /* JADX INFO: renamed from: n1, reason: collision with root package name */
    public boolean f32342n1;

    /* JADX INFO: renamed from: o1, reason: collision with root package name */
    public int f32343o1;

    /* JADX INFO: renamed from: p1, reason: collision with root package name */
    public int f32344p1;

    /* JADX INFO: renamed from: q1, reason: collision with root package name */
    private int f32345q1;

    /* JADX INFO: renamed from: r1, reason: collision with root package name */
    public boolean f32346r1;

    /* JADX INFO: renamed from: s1, reason: collision with root package name */
    private boolean f32347s1;

    /* JADX INFO: renamed from: t1, reason: collision with root package name */
    private boolean f32348t1;

    /* JADX INFO: renamed from: u1, reason: collision with root package name */
    int f32349u1;

    /* JADX INFO: renamed from: v1, reason: collision with root package name */
    private WeakReference f32350v1;

    /* JADX INFO: renamed from: w1, reason: collision with root package name */
    private WeakReference f32351w1;

    /* JADX INFO: renamed from: x1, reason: collision with root package name */
    private WeakReference f32352x1;

    /* JADX INFO: renamed from: y1, reason: collision with root package name */
    private WeakReference f32353y1;

    /* JADX INFO: renamed from: z1, reason: collision with root package name */
    HashSet f32354z1;

    public ConstraintWidgetContainer() {
        this.W0 = new BasicMeasure(this);
        this.X0 = new DependencyGraph(this);
        this.Z0 = null;
        this.f32329a1 = false;
        this.f32331c1 = new LinearSystem();
        this.f32336h1 = 0;
        this.f32337i1 = 0;
        this.f32338j1 = new ChainHead[4];
        this.f32339k1 = new ChainHead[4];
        this.f32340l1 = false;
        this.f32341m1 = false;
        this.f32342n1 = false;
        this.f32343o1 = 0;
        this.f32344p1 = 0;
        this.f32345q1 = 257;
        this.f32346r1 = false;
        this.f32347s1 = false;
        this.f32348t1 = false;
        this.f32349u1 = 0;
        this.f32350v1 = null;
        this.f32351w1 = null;
        this.f32352x1 = null;
        this.f32353y1 = null;
        this.f32354z1 = new HashSet();
        this.A1 = new BasicMeasure.Measure();
    }

    private void F1(ConstraintWidget constraintWidget) {
        int i3 = this.f32336h1 + 1;
        ChainHead[] chainHeadArr = this.f32339k1;
        if (i3 >= chainHeadArr.length) {
            this.f32339k1 = (ChainHead[]) Arrays.copyOf(chainHeadArr, chainHeadArr.length * 2);
        }
        this.f32339k1[this.f32336h1] = new ChainHead(constraintWidget, 0, Y1());
        this.f32336h1++;
    }

    private void I1(ConstraintAnchor constraintAnchor, SolverVariable solverVariable) {
        this.f32331c1.h(solverVariable, this.f32331c1.q(constraintAnchor), 0, 5);
    }

    private void J1(ConstraintAnchor constraintAnchor, SolverVariable solverVariable) {
        this.f32331c1.h(this.f32331c1.q(constraintAnchor), solverVariable, 0, 5);
    }

    private void K1(ConstraintWidget constraintWidget) {
        int i3 = this.f32337i1 + 1;
        ChainHead[] chainHeadArr = this.f32338j1;
        if (i3 >= chainHeadArr.length) {
            this.f32338j1 = (ChainHead[]) Arrays.copyOf(chainHeadArr, chainHeadArr.length * 2);
        }
        this.f32338j1[this.f32337i1] = new ChainHead(constraintWidget, 1, Y1());
        this.f32337i1++;
    }

    public static boolean b2(int i3, ConstraintWidget constraintWidget, BasicMeasure.Measurer measurer, BasicMeasure.Measure measure, int i4) {
        int i5;
        int i6;
        if (measurer == null) {
            return false;
        }
        if (constraintWidget.Z() == 8 || (constraintWidget instanceof Guideline) || (constraintWidget instanceof Barrier)) {
            measure.f32414e = 0;
            measure.f32415f = 0;
            return false;
        }
        measure.f32410a = constraintWidget.C();
        measure.f32411b = constraintWidget.X();
        measure.f32412c = constraintWidget.a0();
        measure.f32413d = constraintWidget.z();
        measure.f32418i = false;
        measure.f32419j = i4;
        ConstraintWidget.DimensionBehaviour dimensionBehaviour = measure.f32410a;
        ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
        boolean z2 = dimensionBehaviour == dimensionBehaviour2;
        boolean z3 = measure.f32411b == dimensionBehaviour2;
        boolean z4 = z2 && constraintWidget.f32282f0 > 0.0f;
        boolean z5 = z3 && constraintWidget.f32282f0 > 0.0f;
        if (z2 && constraintWidget.e0(0) && constraintWidget.f32315w == 0 && !z4) {
            measure.f32410a = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
            if (z3 && constraintWidget.f32317x == 0) {
                measure.f32410a = ConstraintWidget.DimensionBehaviour.FIXED;
            }
            z2 = false;
        }
        if (z3 && constraintWidget.e0(1) && constraintWidget.f32317x == 0 && !z5) {
            measure.f32411b = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
            if (z2 && constraintWidget.f32315w == 0) {
                measure.f32411b = ConstraintWidget.DimensionBehaviour.FIXED;
            }
            z3 = false;
        }
        if (constraintWidget.r0()) {
            measure.f32410a = ConstraintWidget.DimensionBehaviour.FIXED;
            z2 = false;
        }
        if (constraintWidget.s0()) {
            measure.f32411b = ConstraintWidget.DimensionBehaviour.FIXED;
            z3 = false;
        }
        if (z4) {
            if (constraintWidget.f32319y[0] == 4) {
                measure.f32410a = ConstraintWidget.DimensionBehaviour.FIXED;
            } else if (!z3) {
                ConstraintWidget.DimensionBehaviour dimensionBehaviour3 = measure.f32411b;
                ConstraintWidget.DimensionBehaviour dimensionBehaviour4 = ConstraintWidget.DimensionBehaviour.FIXED;
                if (dimensionBehaviour3 == dimensionBehaviour4) {
                    i6 = measure.f32413d;
                } else {
                    measure.f32410a = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
                    measurer.b(constraintWidget, measure);
                    i6 = measure.f32415f;
                }
                measure.f32410a = dimensionBehaviour4;
                measure.f32412c = (int) (constraintWidget.x() * i6);
            }
        }
        if (z5) {
            if (constraintWidget.f32319y[1] == 4) {
                measure.f32411b = ConstraintWidget.DimensionBehaviour.FIXED;
            } else if (!z2) {
                ConstraintWidget.DimensionBehaviour dimensionBehaviour5 = measure.f32410a;
                ConstraintWidget.DimensionBehaviour dimensionBehaviour6 = ConstraintWidget.DimensionBehaviour.FIXED;
                if (dimensionBehaviour5 == dimensionBehaviour6) {
                    i5 = measure.f32412c;
                } else {
                    measure.f32411b = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
                    measurer.b(constraintWidget, measure);
                    i5 = measure.f32414e;
                }
                measure.f32411b = dimensionBehaviour6;
                if (constraintWidget.y() == -1) {
                    measure.f32413d = (int) (i5 / constraintWidget.x());
                } else {
                    measure.f32413d = (int) (constraintWidget.x() * i5);
                }
            }
        }
        measurer.b(constraintWidget, measure);
        constraintWidget.r1(measure.f32414e);
        constraintWidget.S0(measure.f32415f);
        constraintWidget.R0(measure.f32417h);
        constraintWidget.H0(measure.f32416g);
        measure.f32419j = BasicMeasure.Measure.f32407k;
        return measure.f32418i;
    }

    private void d2() {
        this.f32336h1 = 0;
        this.f32337i1 = 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:124:0x021f  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x0228  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x02b4  */
    /* JADX WARN: Removed duplicated region for block: B:149:0x02c6  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x02e3  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x02f2  */
    /* JADX WARN: Removed duplicated region for block: B:167:0x0334 A[PHI: r13 r19
      0x0334: PHI (r13v9 ??) = (r13v8 ??), (r13v11 ??), (r13v11 ??), (r13v11 ??) binds: [B:153:0x02f0, B:162:0x0319, B:163:0x031b, B:165:0x0321] A[DONT_GENERATE, DONT_INLINE]
      0x0334: PHI (r19v4 ??) = (r19v3 ??), (r19v6 ??), (r19v6 ??), (r19v6 ??) binds: [B:153:0x02f0, B:162:0x0319, B:163:0x031b, B:165:0x0321] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:169:0x0338  */
    /* JADX WARN: Removed duplicated region for block: B:170:0x033b  */
    /* JADX WARN: Type inference failed for: r0v14 */
    /* JADX WARN: Type inference failed for: r0v16 */
    /* JADX WARN: Type inference failed for: r0v35 */
    /* JADX WARN: Type inference failed for: r0v45 */
    /* JADX WARN: Type inference failed for: r0v85 */
    /* JADX WARN: Type inference failed for: r0v86 */
    /* JADX WARN: Type inference failed for: r13v10 */
    /* JADX WARN: Type inference failed for: r13v11 */
    /* JADX WARN: Type inference failed for: r13v12 */
    /* JADX WARN: Type inference failed for: r13v14 */
    /* JADX WARN: Type inference failed for: r13v15 */
    /* JADX WARN: Type inference failed for: r13v16 */
    /* JADX WARN: Type inference failed for: r13v17 */
    /* JADX WARN: Type inference failed for: r13v18 */
    /* JADX WARN: Type inference failed for: r13v25 */
    /* JADX WARN: Type inference failed for: r13v26 */
    /* JADX WARN: Type inference failed for: r13v27 */
    /* JADX WARN: Type inference failed for: r13v28 */
    /* JADX WARN: Type inference failed for: r13v29 */
    /* JADX WARN: Type inference failed for: r13v30 */
    /* JADX WARN: Type inference failed for: r13v31 */
    /* JADX WARN: Type inference failed for: r13v32 */
    /* JADX WARN: Type inference failed for: r13v33 */
    /* JADX WARN: Type inference failed for: r13v34 */
    /* JADX WARN: Type inference failed for: r13v35 */
    /* JADX WARN: Type inference failed for: r13v4 */
    /* JADX WARN: Type inference failed for: r13v5 */
    /* JADX WARN: Type inference failed for: r13v6 */
    /* JADX WARN: Type inference failed for: r13v7 */
    /* JADX WARN: Type inference failed for: r13v8 */
    /* JADX WARN: Type inference failed for: r13v9 */
    /* JADX WARN: Type inference failed for: r14v0 */
    /* JADX WARN: Type inference failed for: r14v1 */
    /* JADX WARN: Type inference failed for: r14v10, types: [boolean] */
    /* JADX WARN: Type inference failed for: r14v15 */
    /* JADX WARN: Type inference failed for: r14v16 */
    /* JADX WARN: Type inference failed for: r14v17 */
    /* JADX WARN: Type inference failed for: r14v18 */
    /* JADX WARN: Type inference failed for: r14v2 */
    /* JADX WARN: Type inference failed for: r14v3 */
    /* JADX WARN: Type inference failed for: r14v4 */
    /* JADX WARN: Type inference failed for: r14v5 */
    /* JADX WARN: Type inference failed for: r14v9 */
    /* JADX WARN: Type inference failed for: r18v1 */
    /* JADX WARN: Type inference failed for: r18v10 */
    /* JADX WARN: Type inference failed for: r18v2 */
    /* JADX WARN: Type inference failed for: r18v3 */
    /* JADX WARN: Type inference failed for: r18v4 */
    /* JADX WARN: Type inference failed for: r18v5 */
    /* JADX WARN: Type inference failed for: r18v6 */
    /* JADX WARN: Type inference failed for: r18v7 */
    /* JADX WARN: Type inference failed for: r18v8 */
    /* JADX WARN: Type inference failed for: r18v9 */
    /* JADX WARN: Type inference failed for: r19v0 */
    /* JADX WARN: Type inference failed for: r19v1 */
    /* JADX WARN: Type inference failed for: r19v10 */
    /* JADX WARN: Type inference failed for: r19v11 */
    /* JADX WARN: Type inference failed for: r19v12 */
    /* JADX WARN: Type inference failed for: r19v13 */
    /* JADX WARN: Type inference failed for: r19v14 */
    /* JADX WARN: Type inference failed for: r19v15 */
    /* JADX WARN: Type inference failed for: r19v17 */
    /* JADX WARN: Type inference failed for: r19v18 */
    /* JADX WARN: Type inference failed for: r19v19 */
    /* JADX WARN: Type inference failed for: r19v2 */
    /* JADX WARN: Type inference failed for: r19v20 */
    /* JADX WARN: Type inference failed for: r19v21 */
    /* JADX WARN: Type inference failed for: r19v22 */
    /* JADX WARN: Type inference failed for: r19v3 */
    /* JADX WARN: Type inference failed for: r19v4 */
    /* JADX WARN: Type inference failed for: r19v5 */
    /* JADX WARN: Type inference failed for: r19v6 */
    /* JADX WARN: Type inference failed for: r19v7 */
    /* JADX WARN: Type inference failed for: r19v8 */
    /* JADX WARN: Type inference failed for: r19v9 */
    /* JADX WARN: Type inference failed for: r6v23 */
    /* JADX WARN: Type inference failed for: r6v4 */
    /* JADX WARN: Type inference failed for: r6v5, types: [boolean] */
    /* JADX WARN: Type inference failed for: r6v6, types: [boolean] */
    @Override // androidx.constraintlayout.core.widgets.WidgetContainer
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void A1() {
        /*
            Method dump skipped, instruction units count: 861
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.widgets.ConstraintWidgetContainer.A1():void");
    }

    void D1(ConstraintWidget constraintWidget, int i3) {
        if (i3 == 0) {
            F1(constraintWidget);
        } else if (i3 == 1) {
            K1(constraintWidget);
        }
    }

    public boolean E1(LinearSystem linearSystem) {
        ConstraintWidgetContainer constraintWidgetContainer;
        LinearSystem linearSystem2;
        boolean zC2 = c2(64);
        g(linearSystem, zC2);
        int size = this.V0.size();
        boolean z2 = false;
        for (int i3 = 0; i3 < size; i3++) {
            ConstraintWidget constraintWidget = (ConstraintWidget) this.V0.get(i3);
            constraintWidget.Z0(0, false);
            constraintWidget.Z0(1, false);
            if (constraintWidget instanceof Barrier) {
                z2 = true;
            }
        }
        if (z2) {
            for (int i4 = 0; i4 < size; i4++) {
                ConstraintWidget constraintWidget2 = (ConstraintWidget) this.V0.get(i4);
                if (constraintWidget2 instanceof Barrier) {
                    ((Barrier) constraintWidget2).F1();
                }
            }
        }
        this.f32354z1.clear();
        for (int i5 = 0; i5 < size; i5++) {
            ConstraintWidget constraintWidget3 = (ConstraintWidget) this.V0.get(i5);
            if (constraintWidget3.f()) {
                if (constraintWidget3 instanceof VirtualLayout) {
                    this.f32354z1.add(constraintWidget3);
                } else {
                    constraintWidget3.g(linearSystem, zC2);
                }
            }
        }
        while (this.f32354z1.size() > 0) {
            int size2 = this.f32354z1.size();
            Iterator it = this.f32354z1.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                VirtualLayout virtualLayout = (VirtualLayout) ((ConstraintWidget) it.next());
                if (virtualLayout.C1(this.f32354z1)) {
                    virtualLayout.g(linearSystem, zC2);
                    this.f32354z1.remove(virtualLayout);
                    break;
                }
            }
            if (size2 == this.f32354z1.size()) {
                Iterator it2 = this.f32354z1.iterator();
                while (it2.hasNext()) {
                    ((ConstraintWidget) it2.next()).g(linearSystem, zC2);
                }
                this.f32354z1.clear();
            }
        }
        if (LinearSystem.f31167s) {
            HashSet<ConstraintWidget> hashSet = new HashSet();
            for (int i6 = 0; i6 < size; i6++) {
                ConstraintWidget constraintWidget4 = (ConstraintWidget) this.V0.get(i6);
                if (!constraintWidget4.f()) {
                    hashSet.add(constraintWidget4);
                }
            }
            constraintWidgetContainer = this;
            linearSystem2 = linearSystem;
            constraintWidgetContainer.e(this, linearSystem2, hashSet, C() == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT ? 0 : 1, false);
            for (ConstraintWidget constraintWidget5 : hashSet) {
                Optimizer.a(this, linearSystem2, constraintWidget5);
                constraintWidget5.g(linearSystem2, zC2);
            }
        } else {
            constraintWidgetContainer = this;
            linearSystem2 = linearSystem;
            for (int i7 = 0; i7 < size; i7++) {
                ConstraintWidget constraintWidget6 = (ConstraintWidget) constraintWidgetContainer.V0.get(i7);
                if (constraintWidget6 instanceof ConstraintWidgetContainer) {
                    ConstraintWidget.DimensionBehaviour[] dimensionBehaviourArr = constraintWidget6.f32274b0;
                    ConstraintWidget.DimensionBehaviour dimensionBehaviour = dimensionBehaviourArr[0];
                    ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = dimensionBehaviourArr[1];
                    ConstraintWidget.DimensionBehaviour dimensionBehaviour3 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
                    if (dimensionBehaviour == dimensionBehaviour3) {
                        constraintWidget6.W0(ConstraintWidget.DimensionBehaviour.FIXED);
                    }
                    if (dimensionBehaviour2 == dimensionBehaviour3) {
                        constraintWidget6.n1(ConstraintWidget.DimensionBehaviour.FIXED);
                    }
                    constraintWidget6.g(linearSystem2, zC2);
                    if (dimensionBehaviour == dimensionBehaviour3) {
                        constraintWidget6.W0(dimensionBehaviour);
                    }
                    if (dimensionBehaviour2 == dimensionBehaviour3) {
                        constraintWidget6.n1(dimensionBehaviour2);
                    }
                } else {
                    Optimizer.a(this, linearSystem2, constraintWidget6);
                    if (!constraintWidget6.f()) {
                        constraintWidget6.g(linearSystem2, zC2);
                    }
                }
            }
        }
        if (constraintWidgetContainer.f32336h1 > 0) {
            Chain.b(this, linearSystem2, null, 0);
        }
        if (constraintWidgetContainer.f32337i1 > 0) {
            Chain.b(this, linearSystem2, null, 1);
        }
        return true;
    }

    public void G1(ConstraintAnchor constraintAnchor) {
        WeakReference weakReference = this.f32353y1;
        if (weakReference == null || weakReference.get() == null || constraintAnchor.e() > ((ConstraintAnchor) this.f32353y1.get()).e()) {
            this.f32353y1 = new WeakReference(constraintAnchor);
        }
    }

    public void H1(ConstraintAnchor constraintAnchor) {
        WeakReference weakReference = this.f32351w1;
        if (weakReference == null || weakReference.get() == null || constraintAnchor.e() > ((ConstraintAnchor) this.f32351w1.get()).e()) {
            this.f32351w1 = new WeakReference(constraintAnchor);
        }
    }

    void L1(ConstraintAnchor constraintAnchor) {
        WeakReference weakReference = this.f32352x1;
        if (weakReference == null || weakReference.get() == null || constraintAnchor.e() > ((ConstraintAnchor) this.f32352x1.get()).e()) {
            this.f32352x1 = new WeakReference(constraintAnchor);
        }
    }

    void M1(ConstraintAnchor constraintAnchor) {
        WeakReference weakReference = this.f32350v1;
        if (weakReference == null || weakReference.get() == null || constraintAnchor.e() > ((ConstraintAnchor) this.f32350v1.get()).e()) {
            this.f32350v1 = new WeakReference(constraintAnchor);
        }
    }

    public boolean N1(boolean z2) {
        return this.X0.f(z2);
    }

    public boolean O1(boolean z2) {
        return this.X0.g(z2);
    }

    public boolean P1(boolean z2, int i3) {
        return this.X0.h(z2, i3);
    }

    public void Q1(Metrics metrics) {
        this.f32330b1 = metrics;
        this.f32331c1.v(metrics);
    }

    @Override // androidx.constraintlayout.core.widgets.ConstraintWidget
    public void R(StringBuilder sb) {
        sb.append(this.f32299o + ":{\n");
        sb.append("  actualWidth:" + this.f32278d0);
        sb.append("\n");
        sb.append("  actualHeight:" + this.f32280e0);
        sb.append("\n");
        ArrayList arrayListZ1 = z1();
        int size = arrayListZ1.size();
        int i3 = 0;
        while (i3 < size) {
            Object obj = arrayListZ1.get(i3);
            i3++;
            ((ConstraintWidget) obj).R(sb);
            sb.append(",\n");
        }
        sb.append("}");
    }

    public BasicMeasure.Measurer R1() {
        return this.Z0;
    }

    public int S1() {
        return this.f32345q1;
    }

    public LinearSystem T1() {
        return this.f32331c1;
    }

    public boolean U1() {
        return false;
    }

    public void V1() {
        this.X0.j();
    }

    public void W1() {
        this.X0.k();
    }

    public boolean X1() {
        return this.f32348t1;
    }

    public boolean Y1() {
        return this.f32329a1;
    }

    public boolean Z1() {
        return this.f32347s1;
    }

    public long a2(int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11) {
        this.f32332d1 = i10;
        this.f32333e1 = i11;
        return this.W0.d(this, i3, i10, i11, i4, i5, i6, i7, i8, i9);
    }

    public boolean c2(int i3) {
        return (this.f32345q1 & i3) == i3;
    }

    public void e2(BasicMeasure.Measurer measurer) {
        this.Z0 = measurer;
        this.X0.n(measurer);
    }

    public void f2(int i3) {
        this.f32345q1 = i3;
        LinearSystem.f31167s = c2(512);
    }

    public void g2(int i3) {
        this.Y0 = i3;
    }

    public void h2(boolean z2) {
        this.f32329a1 = z2;
    }

    public boolean i2(LinearSystem linearSystem, boolean[] zArr) {
        zArr[2] = false;
        boolean zC2 = c2(64);
        x1(linearSystem, zC2);
        int size = this.V0.size();
        boolean z2 = false;
        for (int i3 = 0; i3 < size; i3++) {
            ConstraintWidget constraintWidget = (ConstraintWidget) this.V0.get(i3);
            constraintWidget.x1(linearSystem, zC2);
            if (constraintWidget.g0()) {
                z2 = true;
            }
        }
        return z2;
    }

    public void j2() {
        this.W0.e(this);
    }

    @Override // androidx.constraintlayout.core.widgets.ConstraintWidget
    public void w1(boolean z2, boolean z3) {
        super.w1(z2, z3);
        int size = this.V0.size();
        for (int i3 = 0; i3 < size; i3++) {
            ((ConstraintWidget) this.V0.get(i3)).w1(z2, z3);
        }
    }

    @Override // androidx.constraintlayout.core.widgets.WidgetContainer, androidx.constraintlayout.core.widgets.ConstraintWidget
    public void x0() {
        this.f32331c1.G();
        this.f32332d1 = 0;
        this.f32334f1 = 0;
        this.f32333e1 = 0;
        this.f32335g1 = 0;
        this.f32346r1 = false;
        super.x0();
    }

    public ConstraintWidgetContainer(int i3, int i4) {
        super(i3, i4);
        this.W0 = new BasicMeasure(this);
        this.X0 = new DependencyGraph(this);
        this.Z0 = null;
        this.f32329a1 = false;
        this.f32331c1 = new LinearSystem();
        this.f32336h1 = 0;
        this.f32337i1 = 0;
        this.f32338j1 = new ChainHead[4];
        this.f32339k1 = new ChainHead[4];
        this.f32340l1 = false;
        this.f32341m1 = false;
        this.f32342n1 = false;
        this.f32343o1 = 0;
        this.f32344p1 = 0;
        this.f32345q1 = 257;
        this.f32346r1 = false;
        this.f32347s1 = false;
        this.f32348t1 = false;
        this.f32349u1 = 0;
        this.f32350v1 = null;
        this.f32351w1 = null;
        this.f32352x1 = null;
        this.f32353y1 = null;
        this.f32354z1 = new HashSet();
        this.A1 = new BasicMeasure.Measure();
    }
}
