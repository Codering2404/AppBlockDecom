package androidx.constraintlayout.core.widgets.analyzer;

import androidx.constraintlayout.core.widgets.Barrier;
import androidx.constraintlayout.core.widgets.ConstraintAnchor;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.core.widgets.ConstraintWidgetContainer;
import androidx.constraintlayout.core.widgets.Guideline;
import androidx.constraintlayout.core.widgets.analyzer.BasicMeasure;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public class Direct {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static BasicMeasure.Measure f32453a = new BasicMeasure.Measure();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static int f32454b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static int f32455c = 0;

    private static boolean a(int i3, ConstraintWidget constraintWidget) {
        ConstraintWidget.DimensionBehaviour dimensionBehaviour;
        ConstraintWidget.DimensionBehaviour dimensionBehaviour2;
        ConstraintWidget.DimensionBehaviour dimensionBehaviourC = constraintWidget.C();
        ConstraintWidget.DimensionBehaviour dimensionBehaviourX = constraintWidget.X();
        ConstraintWidgetContainer constraintWidgetContainer = constraintWidget.N() != null ? (ConstraintWidgetContainer) constraintWidget.N() : null;
        if (constraintWidgetContainer != null) {
            constraintWidgetContainer.C();
            ConstraintWidget.DimensionBehaviour dimensionBehaviour3 = ConstraintWidget.DimensionBehaviour.FIXED;
        }
        if (constraintWidgetContainer != null) {
            constraintWidgetContainer.X();
            ConstraintWidget.DimensionBehaviour dimensionBehaviour4 = ConstraintWidget.DimensionBehaviour.FIXED;
        }
        ConstraintWidget.DimensionBehaviour dimensionBehaviour5 = ConstraintWidget.DimensionBehaviour.FIXED;
        boolean z2 = dimensionBehaviourC == dimensionBehaviour5 || constraintWidget.r0() || dimensionBehaviourC == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT || (dimensionBehaviourC == (dimensionBehaviour2 = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) && constraintWidget.f32315w == 0 && constraintWidget.f32282f0 == 0.0f && constraintWidget.e0(0)) || (dimensionBehaviourC == dimensionBehaviour2 && constraintWidget.f32315w == 1 && constraintWidget.h0(0, constraintWidget.a0()));
        boolean z3 = dimensionBehaviourX == dimensionBehaviour5 || constraintWidget.s0() || dimensionBehaviourX == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT || (dimensionBehaviourX == (dimensionBehaviour = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) && constraintWidget.f32317x == 0 && constraintWidget.f32282f0 == 0.0f && constraintWidget.e0(1)) || (dimensionBehaviourX == dimensionBehaviour && constraintWidget.f32317x == 1 && constraintWidget.h0(1, constraintWidget.z()));
        if (constraintWidget.f32282f0 <= 0.0f || !(z2 || z3)) {
            return z2 && z3;
        }
        return true;
    }

    private static void b(int i3, ConstraintWidget constraintWidget, BasicMeasure.Measurer measurer, boolean z2) {
        ConstraintAnchor constraintAnchor;
        ConstraintAnchor constraintAnchor2;
        boolean z3;
        ConstraintAnchor constraintAnchor3;
        ConstraintAnchor constraintAnchor4;
        if (constraintWidget.k0()) {
            return;
        }
        boolean z4 = true;
        f32454b++;
        if (!(constraintWidget instanceof ConstraintWidgetContainer) && constraintWidget.q0()) {
            int i4 = i3 + 1;
            if (a(i4, constraintWidget)) {
                ConstraintWidgetContainer.b2(i4, constraintWidget, measurer, new BasicMeasure.Measure(), BasicMeasure.Measure.f32407k);
            }
        }
        ConstraintAnchor constraintAnchorQ = constraintWidget.q(ConstraintAnchor.Type.LEFT);
        ConstraintAnchor constraintAnchorQ2 = constraintWidget.q(ConstraintAnchor.Type.RIGHT);
        int iE = constraintAnchorQ.e();
        int iE2 = constraintAnchorQ2.e();
        if (constraintAnchorQ.d() != null && constraintAnchorQ.n()) {
            for (ConstraintAnchor constraintAnchor5 : constraintAnchorQ.d()) {
                ConstraintWidget constraintWidget2 = constraintAnchor5.f32255d;
                int i5 = i3 + 1;
                boolean zA = a(i5, constraintWidget2);
                if (constraintWidget2.q0() && zA) {
                    z3 = z4;
                    ConstraintWidgetContainer.b2(i5, constraintWidget2, measurer, new BasicMeasure.Measure(), BasicMeasure.Measure.f32407k);
                } else {
                    z3 = z4;
                }
                boolean z5 = ((constraintAnchor5 == constraintWidget2.Q && (constraintAnchor4 = constraintWidget2.S.f32257f) != null && constraintAnchor4.n()) || (constraintAnchor5 == constraintWidget2.S && (constraintAnchor3 = constraintWidget2.Q.f32257f) != null && constraintAnchor3.n())) ? z3 : false;
                ConstraintWidget.DimensionBehaviour dimensionBehaviourC = constraintWidget2.C();
                ConstraintWidget.DimensionBehaviour dimensionBehaviour = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
                if (dimensionBehaviourC != dimensionBehaviour || zA) {
                    if (!constraintWidget2.q0()) {
                        ConstraintAnchor constraintAnchor6 = constraintWidget2.Q;
                        if (constraintAnchor5 == constraintAnchor6 && constraintWidget2.S.f32257f == null) {
                            int iF = constraintAnchor6.f() + iE;
                            constraintWidget2.M0(iF, constraintWidget2.a0() + iF);
                            b(i5, constraintWidget2, measurer, z2);
                        } else {
                            ConstraintAnchor constraintAnchor7 = constraintWidget2.S;
                            if (constraintAnchor5 == constraintAnchor7 && constraintAnchor6.f32257f == null) {
                                int iF2 = iE - constraintAnchor7.f();
                                constraintWidget2.M0(iF2 - constraintWidget2.a0(), iF2);
                                b(i5, constraintWidget2, measurer, z2);
                            } else if (z5 && !constraintWidget2.m0()) {
                                d(i5, measurer, constraintWidget2, z2);
                            }
                        }
                    }
                } else if (constraintWidget2.C() == dimensionBehaviour && constraintWidget2.A >= 0 && constraintWidget2.f32321z >= 0 && ((constraintWidget2.Z() == 8 || (constraintWidget2.f32315w == 0 && constraintWidget2.x() == 0.0f)) && !constraintWidget2.m0() && !constraintWidget2.p0() && z5 && !constraintWidget2.m0())) {
                    e(i5, constraintWidget, measurer, constraintWidget2, z2);
                }
                z4 = z3;
            }
        }
        boolean z6 = z4;
        if (constraintWidget instanceof Guideline) {
            return;
        }
        if (constraintAnchorQ2.d() != null && constraintAnchorQ2.n()) {
            for (ConstraintAnchor constraintAnchor8 : constraintAnchorQ2.d()) {
                ConstraintWidget constraintWidget3 = constraintAnchor8.f32255d;
                int i6 = i3 + 1;
                boolean zA2 = a(i6, constraintWidget3);
                if (constraintWidget3.q0() && zA2) {
                    ConstraintWidgetContainer.b2(i6, constraintWidget3, measurer, new BasicMeasure.Measure(), BasicMeasure.Measure.f32407k);
                }
                boolean z7 = ((constraintAnchor8 == constraintWidget3.Q && (constraintAnchor2 = constraintWidget3.S.f32257f) != null && constraintAnchor2.n()) || (constraintAnchor8 == constraintWidget3.S && (constraintAnchor = constraintWidget3.Q.f32257f) != null && constraintAnchor.n())) ? z6 : false;
                ConstraintWidget.DimensionBehaviour dimensionBehaviourC2 = constraintWidget3.C();
                ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
                if (dimensionBehaviourC2 != dimensionBehaviour2 || zA2) {
                    if (!constraintWidget3.q0()) {
                        ConstraintAnchor constraintAnchor9 = constraintWidget3.Q;
                        if (constraintAnchor8 == constraintAnchor9 && constraintWidget3.S.f32257f == null) {
                            int iF3 = constraintAnchor9.f() + iE2;
                            constraintWidget3.M0(iF3, constraintWidget3.a0() + iF3);
                            b(i6, constraintWidget3, measurer, z2);
                        } else {
                            ConstraintAnchor constraintAnchor10 = constraintWidget3.S;
                            if (constraintAnchor8 == constraintAnchor10 && constraintAnchor9.f32257f == null) {
                                int iF4 = iE2 - constraintAnchor10.f();
                                constraintWidget3.M0(iF4 - constraintWidget3.a0(), iF4);
                                b(i6, constraintWidget3, measurer, z2);
                            } else if (z7 && !constraintWidget3.m0()) {
                                d(i6, measurer, constraintWidget3, z2);
                            }
                        }
                    }
                } else if (constraintWidget3.C() == dimensionBehaviour2 && constraintWidget3.A >= 0 && constraintWidget3.f32321z >= 0 && (constraintWidget3.Z() == 8 || (constraintWidget3.f32315w == 0 && constraintWidget3.x() == 0.0f))) {
                    if (!constraintWidget3.m0() && !constraintWidget3.p0() && z7 && !constraintWidget3.m0()) {
                        e(i6, constraintWidget, measurer, constraintWidget3, z2);
                    }
                }
            }
        }
        constraintWidget.u0();
    }

    private static void c(int i3, Barrier barrier, BasicMeasure.Measurer measurer, int i4, boolean z2) {
        if (barrier.A1()) {
            if (i4 == 0) {
                b(i3 + 1, barrier, measurer, z2);
            } else {
                i(i3 + 1, barrier, measurer);
            }
        }
    }

    private static void d(int i3, BasicMeasure.Measurer measurer, ConstraintWidget constraintWidget, boolean z2) {
        float fA = constraintWidget.A();
        int iE = constraintWidget.Q.f32257f.e();
        int iE2 = constraintWidget.S.f32257f.e();
        int iF = constraintWidget.Q.f() + iE;
        int iF2 = iE2 - constraintWidget.S.f();
        if (iE == iE2) {
            fA = 0.5f;
        } else {
            iE = iF;
            iE2 = iF2;
        }
        int iA0 = constraintWidget.a0();
        int i4 = (iE2 - iE) - iA0;
        if (iE > iE2) {
            i4 = (iE - iE2) - iA0;
        }
        int i5 = ((int) (i4 > 0 ? (fA * i4) + 0.5f : fA * i4)) + iE;
        int i6 = i5 + iA0;
        if (iE > iE2) {
            i6 = i5 - iA0;
        }
        constraintWidget.M0(i5, i6);
        b(i3 + 1, constraintWidget, measurer, z2);
    }

    private static void e(int i3, ConstraintWidget constraintWidget, BasicMeasure.Measurer measurer, ConstraintWidget constraintWidget2, boolean z2) {
        float fA = constraintWidget2.A();
        int iE = constraintWidget2.Q.f32257f.e() + constraintWidget2.Q.f();
        int iE2 = constraintWidget2.S.f32257f.e() - constraintWidget2.S.f();
        if (iE2 >= iE) {
            int iA0 = constraintWidget2.a0();
            if (constraintWidget2.Z() != 8) {
                int i4 = constraintWidget2.f32315w;
                if (i4 == 2) {
                    iA0 = (int) (constraintWidget2.A() * 0.5f * (constraintWidget instanceof ConstraintWidgetContainer ? constraintWidget.a0() : constraintWidget.N().a0()));
                } else if (i4 == 0) {
                    iA0 = iE2 - iE;
                }
                iA0 = Math.max(constraintWidget2.f32321z, iA0);
                int i5 = constraintWidget2.A;
                if (i5 > 0) {
                    iA0 = Math.min(i5, iA0);
                }
            }
            int i6 = iE + ((int) ((fA * ((iE2 - iE) - iA0)) + 0.5f));
            constraintWidget2.M0(i6, iA0 + i6);
            b(i3 + 1, constraintWidget2, measurer, z2);
        }
    }

    private static void f(int i3, BasicMeasure.Measurer measurer, ConstraintWidget constraintWidget) {
        float fV = constraintWidget.V();
        int iE = constraintWidget.R.f32257f.e();
        int iE2 = constraintWidget.T.f32257f.e();
        int iF = constraintWidget.R.f() + iE;
        int iF2 = iE2 - constraintWidget.T.f();
        if (iE == iE2) {
            fV = 0.5f;
        } else {
            iE = iF;
            iE2 = iF2;
        }
        int iZ = constraintWidget.z();
        int i4 = (iE2 - iE) - iZ;
        if (iE > iE2) {
            i4 = (iE - iE2) - iZ;
        }
        int i5 = (int) (i4 > 0 ? (fV * i4) + 0.5f : fV * i4);
        int i6 = iE + i5;
        int i7 = i6 + iZ;
        if (iE > iE2) {
            i6 = iE - i5;
            i7 = i6 - iZ;
        }
        constraintWidget.P0(i6, i7);
        i(i3 + 1, constraintWidget, measurer);
    }

    private static void g(int i3, ConstraintWidget constraintWidget, BasicMeasure.Measurer measurer, ConstraintWidget constraintWidget2) {
        float fV = constraintWidget2.V();
        int iE = constraintWidget2.R.f32257f.e() + constraintWidget2.R.f();
        int iE2 = constraintWidget2.T.f32257f.e() - constraintWidget2.T.f();
        if (iE2 >= iE) {
            int iZ = constraintWidget2.z();
            if (constraintWidget2.Z() != 8) {
                int i4 = constraintWidget2.f32317x;
                if (i4 == 2) {
                    iZ = (int) (fV * 0.5f * (constraintWidget instanceof ConstraintWidgetContainer ? constraintWidget.z() : constraintWidget.N().z()));
                } else if (i4 == 0) {
                    iZ = iE2 - iE;
                }
                iZ = Math.max(constraintWidget2.C, iZ);
                int i5 = constraintWidget2.D;
                if (i5 > 0) {
                    iZ = Math.min(i5, iZ);
                }
            }
            int i6 = iE + ((int) ((fV * ((iE2 - iE) - iZ)) + 0.5f));
            constraintWidget2.P0(i6, iZ + i6);
            i(i3 + 1, constraintWidget2, measurer);
        }
    }

    public static void h(ConstraintWidgetContainer constraintWidgetContainer, BasicMeasure.Measurer measurer) {
        ConstraintWidget.DimensionBehaviour dimensionBehaviourC = constraintWidgetContainer.C();
        ConstraintWidget.DimensionBehaviour dimensionBehaviourX = constraintWidgetContainer.X();
        f32454b = 0;
        f32455c = 0;
        constraintWidgetContainer.A0();
        ArrayList arrayListZ1 = constraintWidgetContainer.z1();
        int size = arrayListZ1.size();
        for (int i3 = 0; i3 < size; i3++) {
            ((ConstraintWidget) arrayListZ1.get(i3)).A0();
        }
        boolean zY1 = constraintWidgetContainer.Y1();
        if (dimensionBehaviourC == ConstraintWidget.DimensionBehaviour.FIXED) {
            constraintWidgetContainer.M0(0, constraintWidgetContainer.a0());
        } else {
            constraintWidgetContainer.N0(0);
        }
        boolean z2 = false;
        boolean z3 = false;
        for (int i4 = 0; i4 < size; i4++) {
            ConstraintWidget constraintWidget = (ConstraintWidget) arrayListZ1.get(i4);
            if (constraintWidget instanceof Guideline) {
                Guideline guideline = (Guideline) constraintWidget;
                if (guideline.z1() == 1) {
                    if (guideline.A1() != -1) {
                        guideline.D1(guideline.A1());
                    } else if (guideline.B1() != -1 && constraintWidgetContainer.r0()) {
                        guideline.D1(constraintWidgetContainer.a0() - guideline.B1());
                    } else if (constraintWidgetContainer.r0()) {
                        guideline.D1((int) ((guideline.C1() * constraintWidgetContainer.a0()) + 0.5f));
                    }
                    z2 = true;
                }
            } else if ((constraintWidget instanceof Barrier) && ((Barrier) constraintWidget).E1() == 0) {
                z3 = true;
            }
        }
        if (z2) {
            for (int i5 = 0; i5 < size; i5++) {
                ConstraintWidget constraintWidget2 = (ConstraintWidget) arrayListZ1.get(i5);
                if (constraintWidget2 instanceof Guideline) {
                    Guideline guideline2 = (Guideline) constraintWidget2;
                    if (guideline2.z1() == 1) {
                        b(0, guideline2, measurer, zY1);
                    }
                }
            }
        }
        b(0, constraintWidgetContainer, measurer, zY1);
        if (z3) {
            for (int i6 = 0; i6 < size; i6++) {
                ConstraintWidget constraintWidget3 = (ConstraintWidget) arrayListZ1.get(i6);
                if (constraintWidget3 instanceof Barrier) {
                    Barrier barrier = (Barrier) constraintWidget3;
                    if (barrier.E1() == 0) {
                        c(0, barrier, measurer, 0, zY1);
                    }
                }
            }
        }
        if (dimensionBehaviourX == ConstraintWidget.DimensionBehaviour.FIXED) {
            constraintWidgetContainer.P0(0, constraintWidgetContainer.z());
        } else {
            constraintWidgetContainer.O0(0);
        }
        boolean z4 = false;
        boolean z5 = false;
        for (int i7 = 0; i7 < size; i7++) {
            ConstraintWidget constraintWidget4 = (ConstraintWidget) arrayListZ1.get(i7);
            if (constraintWidget4 instanceof Guideline) {
                Guideline guideline3 = (Guideline) constraintWidget4;
                if (guideline3.z1() == 0) {
                    if (guideline3.A1() != -1) {
                        guideline3.D1(guideline3.A1());
                    } else if (guideline3.B1() != -1 && constraintWidgetContainer.s0()) {
                        guideline3.D1(constraintWidgetContainer.z() - guideline3.B1());
                    } else if (constraintWidgetContainer.s0()) {
                        guideline3.D1((int) ((guideline3.C1() * constraintWidgetContainer.z()) + 0.5f));
                    }
                    z4 = true;
                }
            } else if ((constraintWidget4 instanceof Barrier) && ((Barrier) constraintWidget4).E1() == 1) {
                z5 = true;
            }
        }
        if (z4) {
            for (int i8 = 0; i8 < size; i8++) {
                ConstraintWidget constraintWidget5 = (ConstraintWidget) arrayListZ1.get(i8);
                if (constraintWidget5 instanceof Guideline) {
                    Guideline guideline4 = (Guideline) constraintWidget5;
                    if (guideline4.z1() == 0) {
                        i(1, guideline4, measurer);
                    }
                }
            }
        }
        i(0, constraintWidgetContainer, measurer);
        if (z5) {
            for (int i9 = 0; i9 < size; i9++) {
                ConstraintWidget constraintWidget6 = (ConstraintWidget) arrayListZ1.get(i9);
                if (constraintWidget6 instanceof Barrier) {
                    Barrier barrier2 = (Barrier) constraintWidget6;
                    if (barrier2.E1() == 1) {
                        c(0, barrier2, measurer, 1, zY1);
                    }
                }
            }
        }
        for (int i10 = 0; i10 < size; i10++) {
            ConstraintWidget constraintWidget7 = (ConstraintWidget) arrayListZ1.get(i10);
            if (constraintWidget7.q0() && a(0, constraintWidget7)) {
                ConstraintWidgetContainer.b2(0, constraintWidget7, measurer, f32453a, BasicMeasure.Measure.f32407k);
                if (!(constraintWidget7 instanceof Guideline)) {
                    b(0, constraintWidget7, measurer, zY1);
                    i(0, constraintWidget7, measurer);
                } else if (((Guideline) constraintWidget7).z1() == 0) {
                    i(0, constraintWidget7, measurer);
                } else {
                    b(0, constraintWidget7, measurer, zY1);
                }
            }
        }
    }

    private static void i(int i3, ConstraintWidget constraintWidget, BasicMeasure.Measurer measurer) {
        ConstraintAnchor constraintAnchor;
        ConstraintAnchor constraintAnchor2;
        ConstraintAnchor constraintAnchor3;
        ConstraintAnchor constraintAnchor4;
        if (constraintWidget.t0()) {
            return;
        }
        boolean z2 = true;
        f32455c++;
        if (!(constraintWidget instanceof ConstraintWidgetContainer) && constraintWidget.q0()) {
            int i4 = i3 + 1;
            if (a(i4, constraintWidget)) {
                ConstraintWidgetContainer.b2(i4, constraintWidget, measurer, new BasicMeasure.Measure(), BasicMeasure.Measure.f32407k);
            }
        }
        ConstraintAnchor constraintAnchorQ = constraintWidget.q(ConstraintAnchor.Type.TOP);
        ConstraintAnchor constraintAnchorQ2 = constraintWidget.q(ConstraintAnchor.Type.BOTTOM);
        int iE = constraintAnchorQ.e();
        int iE2 = constraintAnchorQ2.e();
        if (constraintAnchorQ.d() != null && constraintAnchorQ.n()) {
            for (ConstraintAnchor constraintAnchor5 : constraintAnchorQ.d()) {
                ConstraintWidget constraintWidget2 = constraintAnchor5.f32255d;
                int i5 = i3 + 1;
                boolean zA = a(i5, constraintWidget2);
                if (constraintWidget2.q0() && zA) {
                    ConstraintWidgetContainer.b2(i5, constraintWidget2, measurer, new BasicMeasure.Measure(), BasicMeasure.Measure.f32407k);
                }
                boolean z3 = ((constraintAnchor5 == constraintWidget2.R && (constraintAnchor4 = constraintWidget2.T.f32257f) != null && constraintAnchor4.n()) || (constraintAnchor5 == constraintWidget2.T && (constraintAnchor3 = constraintWidget2.R.f32257f) != null && constraintAnchor3.n())) ? z2 : false;
                ConstraintWidget.DimensionBehaviour dimensionBehaviourX = constraintWidget2.X();
                boolean z4 = z2;
                ConstraintWidget.DimensionBehaviour dimensionBehaviour = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
                if (dimensionBehaviourX != dimensionBehaviour || zA) {
                    if (!constraintWidget2.q0()) {
                        ConstraintAnchor constraintAnchor6 = constraintWidget2.R;
                        if (constraintAnchor5 == constraintAnchor6 && constraintWidget2.T.f32257f == null) {
                            int iF = constraintAnchor6.f() + iE;
                            constraintWidget2.P0(iF, constraintWidget2.z() + iF);
                            i(i5, constraintWidget2, measurer);
                        } else {
                            ConstraintAnchor constraintAnchor7 = constraintWidget2.T;
                            if (constraintAnchor5 == constraintAnchor7 && constraintAnchor6.f32257f == null) {
                                int iF2 = iE - constraintAnchor7.f();
                                constraintWidget2.P0(iF2 - constraintWidget2.z(), iF2);
                                i(i5, constraintWidget2, measurer);
                            } else if (z3 && !constraintWidget2.o0()) {
                                f(i5, measurer, constraintWidget2);
                            }
                        }
                    }
                } else if (constraintWidget2.X() == dimensionBehaviour && constraintWidget2.D >= 0 && constraintWidget2.C >= 0 && ((constraintWidget2.Z() == 8 || (constraintWidget2.f32317x == 0 && constraintWidget2.x() == 0.0f)) && !constraintWidget2.o0() && !constraintWidget2.p0() && z3 && !constraintWidget2.o0())) {
                    g(i5, constraintWidget, measurer, constraintWidget2);
                }
                z2 = z4;
            }
        }
        boolean z5 = z2;
        if (constraintWidget instanceof Guideline) {
            return;
        }
        if (constraintAnchorQ2.d() != null && constraintAnchorQ2.n()) {
            for (ConstraintAnchor constraintAnchor8 : constraintAnchorQ2.d()) {
                ConstraintWidget constraintWidget3 = constraintAnchor8.f32255d;
                int i6 = i3 + 1;
                boolean zA2 = a(i6, constraintWidget3);
                if (constraintWidget3.q0() && zA2) {
                    ConstraintWidgetContainer.b2(i6, constraintWidget3, measurer, new BasicMeasure.Measure(), BasicMeasure.Measure.f32407k);
                }
                boolean z6 = ((constraintAnchor8 == constraintWidget3.R && (constraintAnchor2 = constraintWidget3.T.f32257f) != null && constraintAnchor2.n()) || (constraintAnchor8 == constraintWidget3.T && (constraintAnchor = constraintWidget3.R.f32257f) != null && constraintAnchor.n())) ? z5 : false;
                ConstraintWidget.DimensionBehaviour dimensionBehaviourX2 = constraintWidget3.X();
                ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
                if (dimensionBehaviourX2 != dimensionBehaviour2 || zA2) {
                    if (!constraintWidget3.q0()) {
                        ConstraintAnchor constraintAnchor9 = constraintWidget3.R;
                        if (constraintAnchor8 == constraintAnchor9 && constraintWidget3.T.f32257f == null) {
                            int iF3 = constraintAnchor9.f() + iE2;
                            constraintWidget3.P0(iF3, constraintWidget3.z() + iF3);
                            i(i6, constraintWidget3, measurer);
                        } else {
                            ConstraintAnchor constraintAnchor10 = constraintWidget3.T;
                            if (constraintAnchor8 == constraintAnchor10 && constraintAnchor9.f32257f == null) {
                                int iF4 = iE2 - constraintAnchor10.f();
                                constraintWidget3.P0(iF4 - constraintWidget3.z(), iF4);
                                i(i6, constraintWidget3, measurer);
                            } else if (z6 && !constraintWidget3.o0()) {
                                f(i6, measurer, constraintWidget3);
                            }
                        }
                    }
                } else if (constraintWidget3.X() == dimensionBehaviour2 && constraintWidget3.D >= 0 && constraintWidget3.C >= 0 && (constraintWidget3.Z() == 8 || (constraintWidget3.f32317x == 0 && constraintWidget3.x() == 0.0f))) {
                    if (!constraintWidget3.o0() && !constraintWidget3.p0() && z6 && !constraintWidget3.o0()) {
                        g(i6, constraintWidget, measurer, constraintWidget3);
                    }
                }
            }
        }
        ConstraintAnchor constraintAnchorQ3 = constraintWidget.q(ConstraintAnchor.Type.BASELINE);
        if (constraintAnchorQ3.d() != null && constraintAnchorQ3.n()) {
            int iE3 = constraintAnchorQ3.e();
            for (ConstraintAnchor constraintAnchor11 : constraintAnchorQ3.d()) {
                ConstraintWidget constraintWidget4 = constraintAnchor11.f32255d;
                int i7 = i3 + 1;
                boolean zA3 = a(i7, constraintWidget4);
                if (constraintWidget4.q0() && zA3) {
                    ConstraintWidgetContainer.b2(i7, constraintWidget4, measurer, new BasicMeasure.Measure(), BasicMeasure.Measure.f32407k);
                }
                if (constraintWidget4.X() != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT || zA3) {
                    if (!constraintWidget4.q0() && constraintAnchor11 == constraintWidget4.U) {
                        constraintWidget4.L0(constraintAnchor11.f() + iE3);
                        i(i7, constraintWidget4, measurer);
                    }
                }
            }
        }
        constraintWidget.v0();
    }
}
