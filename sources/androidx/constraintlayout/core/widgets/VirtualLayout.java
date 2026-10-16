package androidx.constraintlayout.core.widgets;

import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.core.widgets.analyzer.BasicMeasure;
import java.util.HashSet;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public class VirtualLayout extends HelperWidget {
    private int X0 = 0;
    private int Y0 = 0;
    private int Z0 = 0;

    /* JADX INFO: renamed from: a1, reason: collision with root package name */
    private int f32394a1 = 0;

    /* JADX INFO: renamed from: b1, reason: collision with root package name */
    private int f32395b1 = 0;

    /* JADX INFO: renamed from: c1, reason: collision with root package name */
    private int f32396c1 = 0;

    /* JADX INFO: renamed from: d1, reason: collision with root package name */
    private int f32397d1 = 0;

    /* JADX INFO: renamed from: e1, reason: collision with root package name */
    private int f32398e1 = 0;

    /* JADX INFO: renamed from: f1, reason: collision with root package name */
    private boolean f32399f1 = false;

    /* JADX INFO: renamed from: g1, reason: collision with root package name */
    private int f32400g1 = 0;

    /* JADX INFO: renamed from: h1, reason: collision with root package name */
    private int f32401h1 = 0;

    /* JADX INFO: renamed from: i1, reason: collision with root package name */
    protected BasicMeasure.Measure f32402i1 = new BasicMeasure.Measure();

    /* JADX INFO: renamed from: j1, reason: collision with root package name */
    BasicMeasure.Measurer f32403j1 = null;

    public void A1(boolean z2) {
        int i3 = this.f32395b1;
        if (i3 > 0 || this.f32396c1 > 0) {
            if (z2) {
                this.f32397d1 = this.f32396c1;
                this.f32398e1 = i3;
            } else {
                this.f32397d1 = i3;
                this.f32398e1 = this.f32396c1;
            }
        }
    }

    public void B1() {
        for (int i3 = 0; i3 < this.W0; i3++) {
            ConstraintWidget constraintWidget = this.V0[i3];
            if (constraintWidget != null) {
                constraintWidget.b1(true);
            }
        }
    }

    public boolean C1(HashSet hashSet) {
        for (int i3 = 0; i3 < this.W0; i3++) {
            if (hashSet.contains(this.V0[i3])) {
                return true;
            }
        }
        return false;
    }

    public int D1() {
        return this.f32401h1;
    }

    public int E1() {
        return this.f32400g1;
    }

    public int F1() {
        return this.Y0;
    }

    public int G1() {
        return this.f32397d1;
    }

    public int H1() {
        return this.f32398e1;
    }

    public int I1() {
        return this.X0;
    }

    protected void K1(ConstraintWidget constraintWidget, ConstraintWidget.DimensionBehaviour dimensionBehaviour, int i3, ConstraintWidget.DimensionBehaviour dimensionBehaviour2, int i4) {
        while (this.f32403j1 == null && N() != null) {
            this.f32403j1 = ((ConstraintWidgetContainer) N()).R1();
        }
        BasicMeasure.Measure measure = this.f32402i1;
        measure.f32410a = dimensionBehaviour;
        measure.f32411b = dimensionBehaviour2;
        measure.f32412c = i3;
        measure.f32413d = i4;
        this.f32403j1.b(constraintWidget, measure);
        constraintWidget.r1(this.f32402i1.f32414e);
        constraintWidget.S0(this.f32402i1.f32415f);
        constraintWidget.R0(this.f32402i1.f32417h);
        constraintWidget.H0(this.f32402i1.f32416g);
    }

    protected boolean L1() {
        ConstraintWidget constraintWidget = this.f32276c0;
        BasicMeasure.Measurer measurerR1 = constraintWidget != null ? ((ConstraintWidgetContainer) constraintWidget).R1() : null;
        if (measurerR1 == null) {
            return false;
        }
        for (int i3 = 0; i3 < this.W0; i3++) {
            ConstraintWidget constraintWidget2 = this.V0[i3];
            if (constraintWidget2 != null && !(constraintWidget2 instanceof Guideline)) {
                ConstraintWidget.DimensionBehaviour dimensionBehaviourW = constraintWidget2.w(0);
                ConstraintWidget.DimensionBehaviour dimensionBehaviourW2 = constraintWidget2.w(1);
                ConstraintWidget.DimensionBehaviour dimensionBehaviour = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
                if (dimensionBehaviourW != dimensionBehaviour || constraintWidget2.f32315w == 1 || dimensionBehaviourW2 != dimensionBehaviour || constraintWidget2.f32317x == 1) {
                    if (dimensionBehaviourW == dimensionBehaviour) {
                        dimensionBehaviourW = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
                    }
                    if (dimensionBehaviourW2 == dimensionBehaviour) {
                        dimensionBehaviourW2 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
                    }
                    BasicMeasure.Measure measure = this.f32402i1;
                    measure.f32410a = dimensionBehaviourW;
                    measure.f32411b = dimensionBehaviourW2;
                    measure.f32412c = constraintWidget2.a0();
                    this.f32402i1.f32413d = constraintWidget2.z();
                    measurerR1.b(constraintWidget2, this.f32402i1);
                    constraintWidget2.r1(this.f32402i1.f32414e);
                    constraintWidget2.S0(this.f32402i1.f32415f);
                    constraintWidget2.H0(this.f32402i1.f32416g);
                }
            }
        }
        return true;
    }

    public boolean M1() {
        return this.f32399f1;
    }

    protected void N1(boolean z2) {
        this.f32399f1 = z2;
    }

    public void O1(int i3, int i4) {
        this.f32400g1 = i3;
        this.f32401h1 = i4;
    }

    public void P1(int i3) {
        this.Z0 = i3;
        this.X0 = i3;
        this.f32394a1 = i3;
        this.Y0 = i3;
        this.f32395b1 = i3;
        this.f32396c1 = i3;
    }

    public void Q1(int i3) {
        this.Y0 = i3;
    }

    public void R1(int i3) {
        this.f32396c1 = i3;
    }

    public void S1(int i3) {
        this.Z0 = i3;
        this.f32397d1 = i3;
    }

    public void T1(int i3) {
        this.f32394a1 = i3;
        this.f32398e1 = i3;
    }

    public void U1(int i3) {
        this.f32395b1 = i3;
        this.f32397d1 = i3;
        this.f32398e1 = i3;
    }

    public void V1(int i3) {
        this.X0 = i3;
    }

    @Override // androidx.constraintlayout.core.widgets.HelperWidget, androidx.constraintlayout.core.widgets.Helper
    public void c(ConstraintWidgetContainer constraintWidgetContainer) {
        B1();
    }

    public void J1(int i3, int i4, int i5, int i6) {
    }
}
