package androidx.constraintlayout.core.widgets;

import androidx.constraintlayout.core.LinearSystem;
import androidx.constraintlayout.core.SolverVariable;
import androidx.constraintlayout.core.widgets.ConstraintAnchor;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import java.util.HashMap;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public class Guideline extends ConstraintWidget {
    protected float V0 = -1.0f;
    protected int W0 = -1;
    protected int X0 = -1;
    protected boolean Y0 = true;
    private ConstraintAnchor Z0 = this.R;

    /* JADX INFO: renamed from: a1, reason: collision with root package name */
    private int f32389a1 = 0;

    /* JADX INFO: renamed from: b1, reason: collision with root package name */
    private int f32390b1 = 0;

    /* JADX INFO: renamed from: c1, reason: collision with root package name */
    private boolean f32391c1;

    /* JADX INFO: renamed from: androidx.constraintlayout.core.widgets.Guideline$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static /* synthetic */ class AnonymousClass1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f32392a;

        static {
            int[] iArr = new int[ConstraintAnchor.Type.values().length];
            f32392a = iArr;
            try {
                iArr[ConstraintAnchor.Type.LEFT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f32392a[ConstraintAnchor.Type.RIGHT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f32392a[ConstraintAnchor.Type.TOP.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f32392a[ConstraintAnchor.Type.BOTTOM.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f32392a[ConstraintAnchor.Type.BASELINE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f32392a[ConstraintAnchor.Type.CENTER.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f32392a[ConstraintAnchor.Type.CENTER_X.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f32392a[ConstraintAnchor.Type.CENTER_Y.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f32392a[ConstraintAnchor.Type.NONE.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
        }
    }

    public Guideline() {
        this.Z.clear();
        this.Z.add(this.Z0);
        int length = this.Y.length;
        for (int i3 = 0; i3 < length; i3++) {
            this.Y[i3] = this.Z0;
        }
    }

    public int A1() {
        return this.W0;
    }

    public int B1() {
        return this.X0;
    }

    public float C1() {
        return this.V0;
    }

    public void D1(int i3) {
        this.Z0.t(i3);
        this.f32391c1 = true;
    }

    public void E1(int i3) {
        if (i3 > -1) {
            this.V0 = -1.0f;
            this.W0 = i3;
            this.X0 = -1;
        }
    }

    public void F1(int i3) {
        if (i3 > -1) {
            this.V0 = -1.0f;
            this.W0 = -1;
            this.X0 = i3;
        }
    }

    public void G1(float f3) {
        if (f3 > -1.0f) {
            this.V0 = f3;
            this.W0 = -1;
            this.X0 = -1;
        }
    }

    public void H1(int i3) {
        if (this.f32389a1 == i3) {
            return;
        }
        this.f32389a1 = i3;
        this.Z.clear();
        if (this.f32389a1 == 1) {
            this.Z0 = this.Q;
        } else {
            this.Z0 = this.R;
        }
        this.Z.add(this.Z0);
        int length = this.Y.length;
        for (int i4 = 0; i4 < length; i4++) {
            this.Y[i4] = this.Z0;
        }
    }

    @Override // androidx.constraintlayout.core.widgets.ConstraintWidget
    public void g(LinearSystem linearSystem, boolean z2) {
        ConstraintWidgetContainer constraintWidgetContainer = (ConstraintWidgetContainer) N();
        if (constraintWidgetContainer == null) {
            return;
        }
        ConstraintAnchor constraintAnchorQ = constraintWidgetContainer.q(ConstraintAnchor.Type.LEFT);
        ConstraintAnchor constraintAnchorQ2 = constraintWidgetContainer.q(ConstraintAnchor.Type.RIGHT);
        ConstraintWidget constraintWidget = this.f32276c0;
        boolean z3 = constraintWidget != null && constraintWidget.f32274b0[0] == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        if (this.f32389a1 == 0) {
            constraintAnchorQ = constraintWidgetContainer.q(ConstraintAnchor.Type.TOP);
            constraintAnchorQ2 = constraintWidgetContainer.q(ConstraintAnchor.Type.BOTTOM);
            ConstraintWidget constraintWidget2 = this.f32276c0;
            z3 = constraintWidget2 != null && constraintWidget2.f32274b0[1] == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        }
        if (this.f32391c1 && this.Z0.n()) {
            SolverVariable solverVariableQ = linearSystem.q(this.Z0);
            linearSystem.f(solverVariableQ, this.Z0.e());
            if (this.W0 != -1) {
                if (z3) {
                    linearSystem.h(linearSystem.q(constraintAnchorQ2), solverVariableQ, 0, 5);
                }
            } else if (this.X0 != -1 && z3) {
                SolverVariable solverVariableQ2 = linearSystem.q(constraintAnchorQ2);
                linearSystem.h(solverVariableQ, linearSystem.q(constraintAnchorQ), 0, 5);
                linearSystem.h(solverVariableQ2, solverVariableQ, 0, 5);
            }
            this.f32391c1 = false;
            return;
        }
        if (this.W0 != -1) {
            SolverVariable solverVariableQ3 = linearSystem.q(this.Z0);
            linearSystem.e(solverVariableQ3, linearSystem.q(constraintAnchorQ), this.W0, 8);
            if (z3) {
                linearSystem.h(linearSystem.q(constraintAnchorQ2), solverVariableQ3, 0, 5);
                return;
            }
            return;
        }
        if (this.X0 == -1) {
            if (this.V0 != -1.0f) {
                linearSystem.d(LinearSystem.s(linearSystem, linearSystem.q(this.Z0), linearSystem.q(constraintAnchorQ2), this.V0));
                return;
            }
            return;
        }
        SolverVariable solverVariableQ4 = linearSystem.q(this.Z0);
        SolverVariable solverVariableQ5 = linearSystem.q(constraintAnchorQ2);
        linearSystem.e(solverVariableQ4, solverVariableQ5, -this.X0, 8);
        if (z3) {
            linearSystem.h(solverVariableQ4, linearSystem.q(constraintAnchorQ), 0, 5);
            linearSystem.h(solverVariableQ5, solverVariableQ4, 0, 5);
        }
    }

    @Override // androidx.constraintlayout.core.widgets.ConstraintWidget
    public boolean h() {
        return true;
    }

    @Override // androidx.constraintlayout.core.widgets.ConstraintWidget
    public void n(ConstraintWidget constraintWidget, HashMap map) {
        super.n(constraintWidget, map);
        Guideline guideline = (Guideline) constraintWidget;
        this.V0 = guideline.V0;
        this.W0 = guideline.W0;
        this.X0 = guideline.X0;
        this.Y0 = guideline.Y0;
        H1(guideline.f32389a1);
    }

    @Override // androidx.constraintlayout.core.widgets.ConstraintWidget
    public ConstraintAnchor q(ConstraintAnchor.Type type) {
        int i3 = AnonymousClass1.f32392a[type.ordinal()];
        if (i3 == 1 || i3 == 2) {
            if (this.f32389a1 == 1) {
                return this.Z0;
            }
            return null;
        }
        if ((i3 == 3 || i3 == 4) && this.f32389a1 == 0) {
            return this.Z0;
        }
        return null;
    }

    @Override // androidx.constraintlayout.core.widgets.ConstraintWidget
    public boolean r0() {
        return this.f32391c1;
    }

    @Override // androidx.constraintlayout.core.widgets.ConstraintWidget
    public boolean s0() {
        return this.f32391c1;
    }

    @Override // androidx.constraintlayout.core.widgets.ConstraintWidget
    public void x1(LinearSystem linearSystem, boolean z2) {
        if (N() == null) {
            return;
        }
        int iA = linearSystem.A(this.Z0);
        if (this.f32389a1 == 1) {
            t1(iA);
            u1(0);
            S0(N().z());
            r1(0);
            return;
        }
        t1(0);
        u1(iA);
        r1(N().a0());
        S0(0);
    }

    public ConstraintAnchor y1() {
        return this.Z0;
    }

    public int z1() {
        return this.f32389a1;
    }
}
