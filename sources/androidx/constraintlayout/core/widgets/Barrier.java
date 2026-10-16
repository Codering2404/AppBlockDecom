package androidx.constraintlayout.core.widgets;

import androidx.constraintlayout.core.LinearSystem;
import androidx.constraintlayout.core.SolverVariable;
import androidx.constraintlayout.core.widgets.ConstraintAnchor;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import java.util.HashMap;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public class Barrier extends HelperWidget {
    private int X0 = 0;
    private boolean Y0 = true;
    private int Z0 = 0;

    /* JADX INFO: renamed from: a1, reason: collision with root package name */
    boolean f32229a1 = false;

    public boolean A1() {
        int i3;
        int i4;
        int i5;
        boolean z2 = true;
        int i6 = 0;
        while (true) {
            i3 = this.W0;
            if (i6 >= i3) {
                break;
            }
            ConstraintWidget constraintWidget = this.V0[i6];
            if ((this.Y0 || constraintWidget.h()) && ((((i4 = this.X0) == 0 || i4 == 1) && !constraintWidget.r0()) || (((i5 = this.X0) == 2 || i5 == 3) && !constraintWidget.s0()))) {
                z2 = false;
            }
            i6++;
        }
        if (!z2 || i3 <= 0) {
            return false;
        }
        int iMax = 0;
        boolean z3 = false;
        for (int i7 = 0; i7 < this.W0; i7++) {
            ConstraintWidget constraintWidget2 = this.V0[i7];
            if (this.Y0 || constraintWidget2.h()) {
                if (!z3) {
                    int i8 = this.X0;
                    if (i8 == 0) {
                        iMax = constraintWidget2.q(ConstraintAnchor.Type.LEFT).e();
                    } else if (i8 == 1) {
                        iMax = constraintWidget2.q(ConstraintAnchor.Type.RIGHT).e();
                    } else if (i8 == 2) {
                        iMax = constraintWidget2.q(ConstraintAnchor.Type.TOP).e();
                    } else if (i8 == 3) {
                        iMax = constraintWidget2.q(ConstraintAnchor.Type.BOTTOM).e();
                    }
                    z3 = true;
                }
                int i9 = this.X0;
                if (i9 == 0) {
                    iMax = Math.min(iMax, constraintWidget2.q(ConstraintAnchor.Type.LEFT).e());
                } else if (i9 == 1) {
                    iMax = Math.max(iMax, constraintWidget2.q(ConstraintAnchor.Type.RIGHT).e());
                } else if (i9 == 2) {
                    iMax = Math.min(iMax, constraintWidget2.q(ConstraintAnchor.Type.TOP).e());
                } else if (i9 == 3) {
                    iMax = Math.max(iMax, constraintWidget2.q(ConstraintAnchor.Type.BOTTOM).e());
                }
            }
        }
        int i10 = iMax + this.Z0;
        int i11 = this.X0;
        if (i11 == 0 || i11 == 1) {
            M0(i10, i10);
        } else {
            P0(i10, i10);
        }
        this.f32229a1 = true;
        return true;
    }

    public boolean B1() {
        return this.Y0;
    }

    public int C1() {
        return this.X0;
    }

    public int D1() {
        return this.Z0;
    }

    public int E1() {
        int i3 = this.X0;
        if (i3 == 0 || i3 == 1) {
            return 0;
        }
        return (i3 == 2 || i3 == 3) ? 1 : -1;
    }

    protected void F1() {
        for (int i3 = 0; i3 < this.W0; i3++) {
            ConstraintWidget constraintWidget = this.V0[i3];
            if (this.Y0 || constraintWidget.h()) {
                int i4 = this.X0;
                if (i4 == 0 || i4 == 1) {
                    constraintWidget.Z0(0, true);
                } else if (i4 == 2 || i4 == 3) {
                    constraintWidget.Z0(1, true);
                }
            }
        }
    }

    public void G1(boolean z2) {
        this.Y0 = z2;
    }

    public void H1(int i3) {
        this.X0 = i3;
    }

    public void I1(int i3) {
        this.Z0 = i3;
    }

    @Override // androidx.constraintlayout.core.widgets.ConstraintWidget
    public void g(LinearSystem linearSystem, boolean z2) {
        ConstraintAnchor[] constraintAnchorArr;
        boolean z3;
        int i3;
        int i4;
        int i5;
        ConstraintAnchor[] constraintAnchorArr2 = this.Y;
        constraintAnchorArr2[0] = this.Q;
        constraintAnchorArr2[2] = this.R;
        constraintAnchorArr2[1] = this.S;
        constraintAnchorArr2[3] = this.T;
        int i6 = 0;
        while (true) {
            constraintAnchorArr = this.Y;
            if (i6 >= constraintAnchorArr.length) {
                break;
            }
            ConstraintAnchor constraintAnchor = constraintAnchorArr[i6];
            constraintAnchor.f32260i = linearSystem.q(constraintAnchor);
            i6++;
        }
        int i7 = this.X0;
        if (i7 < 0 || i7 >= 4) {
            return;
        }
        ConstraintAnchor constraintAnchor2 = constraintAnchorArr[i7];
        if (!this.f32229a1) {
            A1();
        }
        if (this.f32229a1) {
            this.f32229a1 = false;
            int i8 = this.X0;
            if (i8 == 0 || i8 == 1) {
                linearSystem.f(this.Q.f32260i, this.f32286h0);
                linearSystem.f(this.S.f32260i, this.f32286h0);
                return;
            } else {
                if (i8 == 2 || i8 == 3) {
                    linearSystem.f(this.R.f32260i, this.f32288i0);
                    linearSystem.f(this.T.f32260i, this.f32288i0);
                    return;
                }
                return;
            }
        }
        for (int i9 = 0; i9 < this.W0; i9++) {
            ConstraintWidget constraintWidget = this.V0[i9];
            if ((this.Y0 || constraintWidget.h()) && ((((i4 = this.X0) == 0 || i4 == 1) && constraintWidget.C() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && constraintWidget.Q.f32257f != null && constraintWidget.S.f32257f != null) || (((i5 = this.X0) == 2 || i5 == 3) && constraintWidget.X() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && constraintWidget.R.f32257f != null && constraintWidget.T.f32257f != null))) {
                z3 = true;
                break;
            }
        }
        z3 = false;
        boolean z4 = this.Q.l() || this.S.l();
        boolean z5 = this.R.l() || this.T.l();
        int i10 = !(!z3 && (((i3 = this.X0) == 0 && z4) || ((i3 == 2 && z5) || ((i3 == 1 && z4) || (i3 == 3 && z5))))) ? 4 : 5;
        for (int i11 = 0; i11 < this.W0; i11++) {
            ConstraintWidget constraintWidget2 = this.V0[i11];
            if (this.Y0 || constraintWidget2.h()) {
                SolverVariable solverVariableQ = linearSystem.q(constraintWidget2.Y[this.X0]);
                ConstraintAnchor[] constraintAnchorArr3 = constraintWidget2.Y;
                int i12 = this.X0;
                ConstraintAnchor constraintAnchor3 = constraintAnchorArr3[i12];
                constraintAnchor3.f32260i = solverVariableQ;
                ConstraintAnchor constraintAnchor4 = constraintAnchor3.f32257f;
                int i13 = (constraintAnchor4 == null || constraintAnchor4.f32255d != this) ? 0 : constraintAnchor3.f32258g;
                if (i12 == 0 || i12 == 2) {
                    linearSystem.i(constraintAnchor2.f32260i, solverVariableQ, this.Z0 - i13, z3);
                } else {
                    linearSystem.g(constraintAnchor2.f32260i, solverVariableQ, this.Z0 + i13, z3);
                }
                linearSystem.e(constraintAnchor2.f32260i, solverVariableQ, this.Z0 + i13, i10);
            }
        }
        int i14 = this.X0;
        if (i14 == 0) {
            linearSystem.e(this.S.f32260i, this.Q.f32260i, 0, 8);
            linearSystem.e(this.Q.f32260i, this.f32276c0.S.f32260i, 0, 4);
            linearSystem.e(this.Q.f32260i, this.f32276c0.Q.f32260i, 0, 0);
            return;
        }
        if (i14 == 1) {
            linearSystem.e(this.Q.f32260i, this.S.f32260i, 0, 8);
            linearSystem.e(this.Q.f32260i, this.f32276c0.Q.f32260i, 0, 4);
            linearSystem.e(this.Q.f32260i, this.f32276c0.S.f32260i, 0, 0);
        } else if (i14 == 2) {
            linearSystem.e(this.T.f32260i, this.R.f32260i, 0, 8);
            linearSystem.e(this.R.f32260i, this.f32276c0.T.f32260i, 0, 4);
            linearSystem.e(this.R.f32260i, this.f32276c0.R.f32260i, 0, 0);
        } else if (i14 == 3) {
            linearSystem.e(this.R.f32260i, this.T.f32260i, 0, 8);
            linearSystem.e(this.R.f32260i, this.f32276c0.R.f32260i, 0, 4);
            linearSystem.e(this.R.f32260i, this.f32276c0.T.f32260i, 0, 0);
        }
    }

    @Override // androidx.constraintlayout.core.widgets.ConstraintWidget
    public boolean h() {
        return true;
    }

    @Override // androidx.constraintlayout.core.widgets.HelperWidget, androidx.constraintlayout.core.widgets.ConstraintWidget
    public void n(ConstraintWidget constraintWidget, HashMap map) {
        super.n(constraintWidget, map);
        Barrier barrier = (Barrier) constraintWidget;
        this.X0 = barrier.X0;
        this.Y0 = barrier.Y0;
        this.Z0 = barrier.Z0;
    }

    @Override // androidx.constraintlayout.core.widgets.ConstraintWidget
    public boolean r0() {
        return this.f32229a1;
    }

    @Override // androidx.constraintlayout.core.widgets.ConstraintWidget
    public boolean s0() {
        return this.f32229a1;
    }

    @Override // androidx.constraintlayout.core.widgets.ConstraintWidget
    public String toString() {
        String str = "[Barrier] " + v() + " {";
        for (int i3 = 0; i3 < this.W0; i3++) {
            ConstraintWidget constraintWidget = this.V0[i3];
            if (i3 > 0) {
                str = str + ", ";
            }
            str = str + constraintWidget.v();
        }
        return str + "}";
    }
}
