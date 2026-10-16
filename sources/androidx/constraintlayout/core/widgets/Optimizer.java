package androidx.constraintlayout.core.widgets;

import androidx.constraintlayout.core.LinearSystem;
import androidx.constraintlayout.core.widgets.ConstraintWidget;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public class Optimizer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static boolean[] f32393a = new boolean[3];

    static void a(ConstraintWidgetContainer constraintWidgetContainer, LinearSystem linearSystem, ConstraintWidget constraintWidget) {
        constraintWidget.f32309t = -1;
        constraintWidget.f32311u = -1;
        ConstraintWidget.DimensionBehaviour dimensionBehaviour = constraintWidgetContainer.f32274b0[0];
        ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        if (dimensionBehaviour != dimensionBehaviour2 && constraintWidget.f32274b0[0] == ConstraintWidget.DimensionBehaviour.MATCH_PARENT) {
            int i3 = constraintWidget.Q.f32258g;
            int iA0 = constraintWidgetContainer.a0() - constraintWidget.S.f32258g;
            ConstraintAnchor constraintAnchor = constraintWidget.Q;
            constraintAnchor.f32260i = linearSystem.q(constraintAnchor);
            ConstraintAnchor constraintAnchor2 = constraintWidget.S;
            constraintAnchor2.f32260i = linearSystem.q(constraintAnchor2);
            linearSystem.f(constraintWidget.Q.f32260i, i3);
            linearSystem.f(constraintWidget.S.f32260i, iA0);
            constraintWidget.f32309t = 2;
            constraintWidget.V0(i3, iA0);
        }
        if (constraintWidgetContainer.f32274b0[1] == dimensionBehaviour2 || constraintWidget.f32274b0[1] != ConstraintWidget.DimensionBehaviour.MATCH_PARENT) {
            return;
        }
        int i4 = constraintWidget.R.f32258g;
        int iZ = constraintWidgetContainer.z() - constraintWidget.T.f32258g;
        ConstraintAnchor constraintAnchor3 = constraintWidget.R;
        constraintAnchor3.f32260i = linearSystem.q(constraintAnchor3);
        ConstraintAnchor constraintAnchor4 = constraintWidget.T;
        constraintAnchor4.f32260i = linearSystem.q(constraintAnchor4);
        linearSystem.f(constraintWidget.R.f32260i, i4);
        linearSystem.f(constraintWidget.T.f32260i, iZ);
        if (constraintWidget.f32298n0 > 0 || constraintWidget.Z() == 8) {
            ConstraintAnchor constraintAnchor5 = constraintWidget.U;
            constraintAnchor5.f32260i = linearSystem.q(constraintAnchor5);
            linearSystem.f(constraintWidget.U.f32260i, constraintWidget.f32298n0 + i4);
        }
        constraintWidget.f32311u = 2;
        constraintWidget.m1(i4, iZ);
    }

    public static final boolean b(int i3, int i4) {
        return (i3 & i4) == i4;
    }
}
