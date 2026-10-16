package androidx.constraintlayout.core.widgets;

import androidx.constraintlayout.core.LinearSystem;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import java.util.ArrayList;
import java.util.HashMap;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public class Flow extends VirtualLayout {
    private ConstraintWidget[] H1;

    /* JADX INFO: renamed from: k1, reason: collision with root package name */
    private int f32355k1 = -1;

    /* JADX INFO: renamed from: l1, reason: collision with root package name */
    private int f32356l1 = -1;

    /* JADX INFO: renamed from: m1, reason: collision with root package name */
    private int f32357m1 = -1;

    /* JADX INFO: renamed from: n1, reason: collision with root package name */
    private int f32358n1 = -1;

    /* JADX INFO: renamed from: o1, reason: collision with root package name */
    private int f32359o1 = -1;

    /* JADX INFO: renamed from: p1, reason: collision with root package name */
    private int f32360p1 = -1;

    /* JADX INFO: renamed from: q1, reason: collision with root package name */
    private float f32361q1 = 0.5f;

    /* JADX INFO: renamed from: r1, reason: collision with root package name */
    private float f32362r1 = 0.5f;

    /* JADX INFO: renamed from: s1, reason: collision with root package name */
    private float f32363s1 = 0.5f;

    /* JADX INFO: renamed from: t1, reason: collision with root package name */
    private float f32364t1 = 0.5f;

    /* JADX INFO: renamed from: u1, reason: collision with root package name */
    private float f32365u1 = 0.5f;

    /* JADX INFO: renamed from: v1, reason: collision with root package name */
    private float f32366v1 = 0.5f;

    /* JADX INFO: renamed from: w1, reason: collision with root package name */
    private int f32367w1 = 0;

    /* JADX INFO: renamed from: x1, reason: collision with root package name */
    private int f32368x1 = 0;

    /* JADX INFO: renamed from: y1, reason: collision with root package name */
    private int f32369y1 = 2;

    /* JADX INFO: renamed from: z1, reason: collision with root package name */
    private int f32370z1 = 2;
    private int A1 = 0;
    private int B1 = -1;
    private int C1 = 0;
    private ArrayList D1 = new ArrayList();
    private ConstraintWidget[] E1 = null;
    private ConstraintWidget[] F1 = null;
    private int[] G1 = null;
    private int I1 = 0;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private class WidgetsList {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f32371a;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private ConstraintAnchor f32374d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private ConstraintAnchor f32375e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private ConstraintAnchor f32376f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private ConstraintAnchor f32377g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private int f32378h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private int f32379i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private int f32380j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private int f32381k;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        private int f32387q;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private ConstraintWidget f32372b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f32373c = 0;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        private int f32382l = 0;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        private int f32383m = 0;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        private int f32384n = 0;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        private int f32385o = 0;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        private int f32386p = 0;

        WidgetsList(int i3, ConstraintAnchor constraintAnchor, ConstraintAnchor constraintAnchor2, ConstraintAnchor constraintAnchor3, ConstraintAnchor constraintAnchor4, int i4) {
            this.f32378h = 0;
            this.f32379i = 0;
            this.f32380j = 0;
            this.f32381k = 0;
            this.f32387q = 0;
            this.f32371a = i3;
            this.f32374d = constraintAnchor;
            this.f32375e = constraintAnchor2;
            this.f32376f = constraintAnchor3;
            this.f32377g = constraintAnchor4;
            this.f32378h = Flow.this.G1();
            this.f32379i = Flow.this.I1();
            this.f32380j = Flow.this.H1();
            this.f32381k = Flow.this.F1();
            this.f32387q = i4;
        }

        private void h() {
            this.f32382l = 0;
            this.f32383m = 0;
            this.f32372b = null;
            this.f32373c = 0;
            int i3 = this.f32385o;
            for (int i4 = 0; i4 < i3 && this.f32384n + i4 < Flow.this.I1; i4++) {
                ConstraintWidget constraintWidget = Flow.this.H1[this.f32384n + i4];
                if (this.f32371a == 0) {
                    int iA0 = constraintWidget.a0();
                    int i5 = Flow.this.f32367w1;
                    if (constraintWidget.Z() == 8) {
                        i5 = 0;
                    }
                    this.f32382l += iA0 + i5;
                    int iR2 = Flow.this.r2(constraintWidget, this.f32387q);
                    if (this.f32372b == null || this.f32373c < iR2) {
                        this.f32372b = constraintWidget;
                        this.f32373c = iR2;
                        this.f32383m = iR2;
                    }
                } else {
                    int iS2 = Flow.this.s2(constraintWidget, this.f32387q);
                    int iR22 = Flow.this.r2(constraintWidget, this.f32387q);
                    int i6 = Flow.this.f32368x1;
                    if (constraintWidget.Z() == 8) {
                        i6 = 0;
                    }
                    this.f32383m += iR22 + i6;
                    if (this.f32372b == null || this.f32373c < iS2) {
                        this.f32372b = constraintWidget;
                        this.f32373c = iS2;
                        this.f32382l = iS2;
                    }
                }
            }
        }

        public void b(ConstraintWidget constraintWidget) {
            if (this.f32371a == 0) {
                int iS2 = Flow.this.s2(constraintWidget, this.f32387q);
                if (constraintWidget.C() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                    this.f32386p++;
                    iS2 = 0;
                }
                this.f32382l += iS2 + (constraintWidget.Z() != 8 ? Flow.this.f32367w1 : 0);
                int iR2 = Flow.this.r2(constraintWidget, this.f32387q);
                if (this.f32372b == null || this.f32373c < iR2) {
                    this.f32372b = constraintWidget;
                    this.f32373c = iR2;
                    this.f32383m = iR2;
                }
            } else {
                int iS22 = Flow.this.s2(constraintWidget, this.f32387q);
                int iR22 = Flow.this.r2(constraintWidget, this.f32387q);
                if (constraintWidget.X() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                    this.f32386p++;
                    iR22 = 0;
                }
                this.f32383m += iR22 + (constraintWidget.Z() != 8 ? Flow.this.f32368x1 : 0);
                if (this.f32372b == null || this.f32373c < iS22) {
                    this.f32372b = constraintWidget;
                    this.f32373c = iS22;
                    this.f32382l = iS22;
                }
            }
            this.f32385o++;
        }

        public void c() {
            this.f32373c = 0;
            this.f32372b = null;
            this.f32382l = 0;
            this.f32383m = 0;
            this.f32384n = 0;
            this.f32385o = 0;
            this.f32386p = 0;
        }

        public void d(boolean z2, int i3, boolean z3) {
            ConstraintWidget constraintWidget;
            int i4;
            char c3;
            float f3;
            float f4;
            int i5 = this.f32385o;
            for (int i6 = 0; i6 < i5 && this.f32384n + i6 < Flow.this.I1; i6++) {
                ConstraintWidget constraintWidget2 = Flow.this.H1[this.f32384n + i6];
                if (constraintWidget2 != null) {
                    constraintWidget2.z0();
                }
            }
            if (i5 == 0 || this.f32372b == null) {
                return;
            }
            boolean z4 = z3 && i3 == 0;
            int i7 = -1;
            int i8 = -1;
            for (int i9 = 0; i9 < i5; i9++) {
                int i10 = z2 ? (i5 - 1) - i9 : i9;
                if (this.f32384n + i10 >= Flow.this.I1) {
                    break;
                }
                ConstraintWidget constraintWidget3 = Flow.this.H1[this.f32384n + i10];
                if (constraintWidget3 != null && constraintWidget3.Z() == 0) {
                    if (i7 == -1) {
                        i7 = i9;
                    }
                    i8 = i9;
                }
            }
            ConstraintWidget constraintWidget4 = null;
            if (this.f32371a != 0) {
                ConstraintWidget constraintWidget5 = this.f32372b;
                constraintWidget5.U0(Flow.this.f32355k1);
                int i11 = this.f32378h;
                if (i3 > 0) {
                    i11 += Flow.this.f32367w1;
                }
                if (z2) {
                    constraintWidget5.S.a(this.f32376f, i11);
                    if (z3) {
                        constraintWidget5.Q.a(this.f32374d, this.f32380j);
                    }
                    if (i3 > 0) {
                        this.f32376f.f32255d.Q.a(constraintWidget5.S, 0);
                    }
                } else {
                    constraintWidget5.Q.a(this.f32374d, i11);
                    if (z3) {
                        constraintWidget5.S.a(this.f32376f, this.f32380j);
                    }
                    if (i3 > 0) {
                        this.f32374d.f32255d.S.a(constraintWidget5.Q, 0);
                    }
                }
                for (int i12 = 0; i12 < i5 && this.f32384n + i12 < Flow.this.I1; i12++) {
                    ConstraintWidget constraintWidget6 = Flow.this.H1[this.f32384n + i12];
                    if (constraintWidget6 != null) {
                        if (i12 == 0) {
                            constraintWidget6.l(constraintWidget6.R, this.f32375e, this.f32379i);
                            int i13 = Flow.this.f32356l1;
                            float f5 = Flow.this.f32362r1;
                            if (this.f32384n == 0 && Flow.this.f32358n1 != -1) {
                                i13 = Flow.this.f32358n1;
                                f5 = Flow.this.f32364t1;
                            } else if (z3 && Flow.this.f32360p1 != -1) {
                                i13 = Flow.this.f32360p1;
                                f5 = Flow.this.f32366v1;
                            }
                            constraintWidget6.l1(i13);
                            constraintWidget6.k1(f5);
                        }
                        if (i12 == i5 - 1) {
                            constraintWidget6.l(constraintWidget6.T, this.f32377g, this.f32381k);
                        }
                        if (constraintWidget4 != null) {
                            constraintWidget6.R.a(constraintWidget4.T, Flow.this.f32368x1);
                            if (i12 == i7) {
                                constraintWidget6.R.u(this.f32379i);
                            }
                            constraintWidget4.T.a(constraintWidget6.R, 0);
                            if (i12 == i8 + 1) {
                                constraintWidget4.T.u(this.f32381k);
                            }
                        }
                        if (constraintWidget6 == constraintWidget5) {
                            constraintWidget4 = constraintWidget6;
                        } else if (z2) {
                            int i14 = Flow.this.f32369y1;
                            if (i14 == 0) {
                                constraintWidget6.S.a(constraintWidget5.S, 0);
                            } else if (i14 == 1) {
                                constraintWidget6.Q.a(constraintWidget5.Q, 0);
                            } else if (i14 == 2) {
                                constraintWidget6.Q.a(constraintWidget5.Q, 0);
                                constraintWidget6.S.a(constraintWidget5.S, 0);
                            }
                            constraintWidget4 = constraintWidget6;
                        } else {
                            int i15 = Flow.this.f32369y1;
                            if (i15 == 0) {
                                constraintWidget6.Q.a(constraintWidget5.Q, 0);
                            } else if (i15 == 1) {
                                constraintWidget6.S.a(constraintWidget5.S, 0);
                            } else if (i15 == 2) {
                                if (z4) {
                                    constraintWidget6.Q.a(this.f32374d, this.f32378h);
                                    constraintWidget6.S.a(this.f32376f, this.f32380j);
                                } else {
                                    constraintWidget6.Q.a(constraintWidget5.Q, 0);
                                    constraintWidget6.S.a(constraintWidget5.S, 0);
                                }
                            }
                            constraintWidget4 = constraintWidget6;
                        }
                    }
                }
                return;
            }
            ConstraintWidget constraintWidget7 = this.f32372b;
            constraintWidget7.l1(Flow.this.f32356l1);
            int i16 = this.f32379i;
            if (i3 > 0) {
                i16 += Flow.this.f32368x1;
            }
            constraintWidget7.R.a(this.f32375e, i16);
            if (z3) {
                constraintWidget7.T.a(this.f32377g, this.f32381k);
            }
            if (i3 > 0) {
                this.f32375e.f32255d.T.a(constraintWidget7.R, 0);
            }
            char c4 = 3;
            if (Flow.this.f32370z1 != 3 || constraintWidget7.d0()) {
                constraintWidget = constraintWidget7;
            } else {
                for (int i17 = 0; i17 < i5; i17++) {
                    int i18 = z2 ? (i5 - 1) - i17 : i17;
                    if (this.f32384n + i18 >= Flow.this.I1) {
                        break;
                    }
                    constraintWidget = Flow.this.H1[this.f32384n + i18];
                    if (constraintWidget.d0()) {
                        break;
                    }
                }
                constraintWidget = constraintWidget7;
            }
            int i19 = 0;
            while (i19 < i5) {
                int i20 = z2 ? (i5 - 1) - i19 : i19;
                if (this.f32384n + i20 >= Flow.this.I1) {
                    return;
                }
                ConstraintWidget constraintWidget8 = Flow.this.H1[this.f32384n + i20];
                if (constraintWidget8 == null) {
                    constraintWidget8 = constraintWidget4;
                    c3 = c4;
                } else {
                    if (i19 == 0) {
                        i4 = 1;
                        constraintWidget8.l(constraintWidget8.Q, this.f32374d, this.f32378h);
                    } else {
                        i4 = 1;
                    }
                    if (i20 == 0) {
                        int i21 = Flow.this.f32355k1;
                        float f6 = Flow.this.f32361q1;
                        if (z2) {
                            f6 = 1.0f - f6;
                        }
                        if (this.f32384n != 0 || Flow.this.f32357m1 == -1) {
                            if (z3 && Flow.this.f32359o1 != -1) {
                                i21 = Flow.this.f32359o1;
                                if (z2) {
                                    f4 = Flow.this.f32365u1;
                                    f3 = 1.0f - f4;
                                    f6 = f3;
                                } else {
                                    f3 = Flow.this.f32365u1;
                                    f6 = f3;
                                }
                            }
                            constraintWidget8.U0(i21);
                            constraintWidget8.T0(f6);
                        } else {
                            i21 = Flow.this.f32357m1;
                            if (z2) {
                                f4 = Flow.this.f32363s1;
                                f3 = 1.0f - f4;
                                f6 = f3;
                                constraintWidget8.U0(i21);
                                constraintWidget8.T0(f6);
                            } else {
                                f3 = Flow.this.f32363s1;
                                f6 = f3;
                                constraintWidget8.U0(i21);
                                constraintWidget8.T0(f6);
                            }
                        }
                    }
                    if (i19 == i5 - 1) {
                        constraintWidget8.l(constraintWidget8.S, this.f32376f, this.f32380j);
                    }
                    if (constraintWidget4 != null) {
                        constraintWidget8.Q.a(constraintWidget4.S, Flow.this.f32367w1);
                        if (i19 == i7) {
                            constraintWidget8.Q.u(this.f32378h);
                        }
                        constraintWidget4.S.a(constraintWidget8.Q, 0);
                        if (i19 == i8 + 1) {
                            constraintWidget4.S.u(this.f32380j);
                        }
                    }
                    if (constraintWidget8 != constraintWidget7) {
                        c3 = 3;
                        if (Flow.this.f32370z1 == 3 && constraintWidget.d0() && constraintWidget8 != constraintWidget && constraintWidget8.d0()) {
                            constraintWidget8.U.a(constraintWidget.U, 0);
                        } else {
                            int i22 = Flow.this.f32370z1;
                            if (i22 == 0) {
                                constraintWidget8.R.a(constraintWidget7.R, 0);
                            } else if (i22 == i4) {
                                constraintWidget8.T.a(constraintWidget7.T, 0);
                            } else if (z4) {
                                constraintWidget8.R.a(this.f32375e, this.f32379i);
                                constraintWidget8.T.a(this.f32377g, this.f32381k);
                            } else {
                                constraintWidget8.R.a(constraintWidget7.R, 0);
                                constraintWidget8.T.a(constraintWidget7.T, 0);
                            }
                        }
                    } else {
                        c3 = 3;
                    }
                }
                i19++;
                c4 = c3;
                constraintWidget4 = constraintWidget8;
            }
        }

        public int e() {
            return this.f32371a == 1 ? this.f32383m - Flow.this.f32368x1 : this.f32383m;
        }

        public int f() {
            return this.f32371a == 0 ? this.f32382l - Flow.this.f32367w1 : this.f32382l;
        }

        public void g(int i3) {
            int i4 = this.f32386p;
            if (i4 == 0) {
                return;
            }
            int i5 = this.f32385o;
            int i6 = i3 / i4;
            for (int i7 = 0; i7 < i5 && this.f32384n + i7 < Flow.this.I1; i7++) {
                ConstraintWidget constraintWidget = Flow.this.H1[this.f32384n + i7];
                if (this.f32371a == 0) {
                    if (constraintWidget != null && constraintWidget.C() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && constraintWidget.f32315w == 0) {
                        Flow.this.K1(constraintWidget, ConstraintWidget.DimensionBehaviour.FIXED, i6, constraintWidget.X(), constraintWidget.z());
                    }
                } else if (constraintWidget != null && constraintWidget.X() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && constraintWidget.f32317x == 0) {
                    int i8 = i6;
                    Flow.this.K1(constraintWidget, constraintWidget.C(), constraintWidget.a0(), ConstraintWidget.DimensionBehaviour.FIXED, i8);
                    i6 = i8;
                }
            }
            h();
        }

        public void i(int i3) {
            this.f32384n = i3;
        }

        public void j(int i3, ConstraintAnchor constraintAnchor, ConstraintAnchor constraintAnchor2, ConstraintAnchor constraintAnchor3, ConstraintAnchor constraintAnchor4, int i4, int i5, int i6, int i7, int i8) {
            this.f32371a = i3;
            this.f32374d = constraintAnchor;
            this.f32375e = constraintAnchor2;
            this.f32376f = constraintAnchor3;
            this.f32377g = constraintAnchor4;
            this.f32378h = i4;
            this.f32379i = i5;
            this.f32380j = i6;
            this.f32381k = i7;
            this.f32387q = i8;
        }
    }

    private void q2(boolean z2) {
        ConstraintWidget constraintWidget;
        float f3;
        int i3;
        if (this.G1 == null || this.F1 == null || this.E1 == null) {
            return;
        }
        for (int i4 = 0; i4 < this.I1; i4++) {
            this.H1[i4].z0();
        }
        int[] iArr = this.G1;
        int i5 = iArr[0];
        int i6 = iArr[1];
        float f4 = this.f32361q1;
        ConstraintWidget constraintWidget2 = null;
        int i7 = 0;
        while (i7 < i5) {
            if (z2) {
                i3 = (i5 - i7) - 1;
                f3 = 1.0f - this.f32361q1;
            } else {
                f3 = f4;
                i3 = i7;
            }
            ConstraintWidget constraintWidget3 = this.F1[i3];
            if (constraintWidget3 != null && constraintWidget3.Z() != 8) {
                if (i7 == 0) {
                    constraintWidget3.l(constraintWidget3.Q, this.Q, G1());
                    constraintWidget3.U0(this.f32355k1);
                    constraintWidget3.T0(f3);
                }
                if (i7 == i5 - 1) {
                    constraintWidget3.l(constraintWidget3.S, this.S, H1());
                }
                if (i7 > 0 && constraintWidget2 != null) {
                    constraintWidget3.l(constraintWidget3.Q, constraintWidget2.S, this.f32367w1);
                    constraintWidget2.l(constraintWidget2.S, constraintWidget3.Q, 0);
                }
                constraintWidget2 = constraintWidget3;
            }
            i7++;
            f4 = f3;
        }
        for (int i8 = 0; i8 < i6; i8++) {
            ConstraintWidget constraintWidget4 = this.E1[i8];
            if (constraintWidget4 != null && constraintWidget4.Z() != 8) {
                if (i8 == 0) {
                    constraintWidget4.l(constraintWidget4.R, this.R, I1());
                    constraintWidget4.l1(this.f32356l1);
                    constraintWidget4.k1(this.f32362r1);
                }
                if (i8 == i6 - 1) {
                    constraintWidget4.l(constraintWidget4.T, this.T, F1());
                }
                if (i8 > 0 && constraintWidget2 != null) {
                    constraintWidget4.l(constraintWidget4.R, constraintWidget2.T, this.f32368x1);
                    constraintWidget2.l(constraintWidget2.T, constraintWidget4.R, 0);
                }
                constraintWidget2 = constraintWidget4;
            }
        }
        for (int i9 = 0; i9 < i5; i9++) {
            for (int i10 = 0; i10 < i6; i10++) {
                int i11 = (i10 * i5) + i9;
                if (this.C1 == 1) {
                    i11 = (i9 * i6) + i10;
                }
                ConstraintWidget[] constraintWidgetArr = this.H1;
                if (i11 < constraintWidgetArr.length && (constraintWidget = constraintWidgetArr[i11]) != null && constraintWidget.Z() != 8) {
                    ConstraintWidget constraintWidget5 = this.F1[i9];
                    ConstraintWidget constraintWidget6 = this.E1[i10];
                    if (constraintWidget != constraintWidget5) {
                        constraintWidget.l(constraintWidget.Q, constraintWidget5.Q, 0);
                        constraintWidget.l(constraintWidget.S, constraintWidget5.S, 0);
                    }
                    if (constraintWidget != constraintWidget6) {
                        constraintWidget.l(constraintWidget.R, constraintWidget6.R, 0);
                        constraintWidget.l(constraintWidget.T, constraintWidget6.T, 0);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int r2(ConstraintWidget constraintWidget, int i3) {
        ConstraintWidget constraintWidget2;
        if (constraintWidget == null) {
            return 0;
        }
        if (constraintWidget.X() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
            int i4 = constraintWidget.f32317x;
            if (i4 == 0) {
                return 0;
            }
            if (i4 == 2) {
                int i5 = (int) (constraintWidget.E * i3);
                if (i5 != constraintWidget.z()) {
                    constraintWidget.f1(true);
                    K1(constraintWidget, constraintWidget.C(), constraintWidget.a0(), ConstraintWidget.DimensionBehaviour.FIXED, i5);
                }
                return i5;
            }
            constraintWidget2 = constraintWidget;
            if (i4 == 1) {
                return constraintWidget2.z();
            }
            if (i4 == 3) {
                return (int) ((constraintWidget2.a0() * constraintWidget2.f32282f0) + 0.5f);
            }
        } else {
            constraintWidget2 = constraintWidget;
        }
        return constraintWidget2.z();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int s2(ConstraintWidget constraintWidget, int i3) {
        ConstraintWidget constraintWidget2;
        if (constraintWidget == null) {
            return 0;
        }
        if (constraintWidget.C() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
            int i4 = constraintWidget.f32315w;
            if (i4 == 0) {
                return 0;
            }
            if (i4 == 2) {
                int i5 = (int) (constraintWidget.B * i3);
                if (i5 != constraintWidget.a0()) {
                    constraintWidget.f1(true);
                    K1(constraintWidget, ConstraintWidget.DimensionBehaviour.FIXED, i5, constraintWidget.X(), constraintWidget.z());
                }
                return i5;
            }
            constraintWidget2 = constraintWidget;
            if (i4 == 1) {
                return constraintWidget2.a0();
            }
            if (i4 == 3) {
                return (int) ((constraintWidget2.z() * constraintWidget2.f32282f0) + 0.5f);
            }
        } else {
            constraintWidget2 = constraintWidget;
        }
        return constraintWidget2.a0();
    }

    /* JADX WARN: Removed duplicated region for block: B:45:0x005e  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:105:0x010d -> B:42:0x0059). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:106:0x010f -> B:42:0x0059). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:108:0x0115 -> B:42:0x0059). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:109:0x0117 -> B:42:0x0059). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void t2(androidx.constraintlayout.core.widgets.ConstraintWidget[] r11, int r12, int r13, int r14, int[] r15) {
        /*
            Method dump skipped, instruction units count: 292
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.widgets.Flow.t2(androidx.constraintlayout.core.widgets.ConstraintWidget[], int, int, int, int[]):void");
    }

    private void u2(ConstraintWidget[] constraintWidgetArr, int i3, int i4, int i5, int[] iArr) {
        int i6;
        Flow flow;
        int i7;
        ConstraintAnchor constraintAnchor;
        int i8;
        Flow flow2 = this;
        if (i3 == 0) {
            return;
        }
        flow2.D1.clear();
        int i9 = i5;
        WidgetsList widgetsList = flow2.new WidgetsList(i4, flow2.Q, flow2.R, flow2.S, flow2.T, i9);
        flow2.D1.add(widgetsList);
        if (i4 == 0) {
            i6 = 0;
            int i10 = 0;
            int i11 = 0;
            while (i11 < i3) {
                ConstraintWidget constraintWidget = constraintWidgetArr[i11];
                int iS2 = flow2.s2(constraintWidget, i9);
                if (constraintWidget.C() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                    i6++;
                }
                int i12 = i6;
                boolean z2 = (i10 == i9 || (flow2.f32367w1 + i10) + iS2 > i9) && widgetsList.f32372b != null;
                if (!z2 && i11 > 0 && (i8 = flow2.B1) > 0 && i11 % i8 == 0) {
                    z2 = true;
                }
                if (z2) {
                    widgetsList = flow2.new WidgetsList(i4, flow2.Q, flow2.R, flow2.S, flow2.T, i9);
                    widgetsList.i(i11);
                    flow2.D1.add(widgetsList);
                } else {
                    if (i11 > 0) {
                        i10 += flow2.f32367w1 + iS2;
                    }
                    widgetsList.b(constraintWidget);
                    i11++;
                    i6 = i12;
                }
                i10 = iS2;
                widgetsList.b(constraintWidget);
                i11++;
                i6 = i12;
            }
        } else {
            i6 = 0;
            int i13 = 0;
            int i14 = 0;
            while (i14 < i3) {
                ConstraintWidget constraintWidget2 = constraintWidgetArr[i14];
                int iR2 = flow2.r2(constraintWidget2, i9);
                if (constraintWidget2.X() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                    i6++;
                }
                int i15 = i6;
                boolean z3 = (i13 == i9 || (flow2.f32368x1 + i13) + iR2 > i9) && widgetsList.f32372b != null;
                if (!z3 && i14 > 0 && (i7 = flow2.B1) > 0 && i14 % i7 == 0) {
                    z3 = true;
                }
                if (z3) {
                    widgetsList = flow2.new WidgetsList(i4, flow2.Q, flow2.R, flow2.S, flow2.T, i9);
                    flow = flow2;
                    widgetsList.i(i14);
                    flow.D1.add(widgetsList);
                } else {
                    flow = flow2;
                    if (i14 > 0) {
                        i13 += flow.f32368x1 + iR2;
                    }
                    widgetsList.b(constraintWidget2);
                    i14++;
                    i9 = i5;
                    i6 = i15;
                    flow2 = flow;
                }
                i13 = iR2;
                widgetsList.b(constraintWidget2);
                i14++;
                i9 = i5;
                i6 = i15;
                flow2 = flow;
            }
        }
        Flow flow3 = flow2;
        int size = flow3.D1.size();
        ConstraintAnchor constraintAnchor2 = flow3.Q;
        ConstraintAnchor constraintAnchor3 = flow3.R;
        ConstraintAnchor constraintAnchor4 = flow3.S;
        ConstraintAnchor constraintAnchor5 = flow3.T;
        int iG1 = flow3.G1();
        int iI1 = flow3.I1();
        int iH1 = flow3.H1();
        int iF1 = flow3.F1();
        ConstraintWidget.DimensionBehaviour dimensionBehaviourC = flow3.C();
        ConstraintWidget.DimensionBehaviour dimensionBehaviour = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        boolean z4 = dimensionBehaviourC == dimensionBehaviour || flow3.X() == dimensionBehaviour;
        if (i6 > 0 && z4) {
            for (int i16 = 0; i16 < size; i16++) {
                WidgetsList widgetsList2 = (WidgetsList) flow3.D1.get(i16);
                if (i4 == 0) {
                    widgetsList2.g(i5 - widgetsList2.f());
                } else {
                    widgetsList2.g(i5 - widgetsList2.e());
                }
            }
        }
        ConstraintAnchor constraintAnchor6 = constraintAnchor2;
        int iF12 = iF1;
        int i17 = 0;
        int iH12 = iH1;
        int i18 = iI1;
        int i19 = iG1;
        ConstraintAnchor constraintAnchor7 = constraintAnchor5;
        ConstraintAnchor constraintAnchor8 = constraintAnchor4;
        ConstraintAnchor constraintAnchor9 = constraintAnchor3;
        int i20 = 0;
        for (int i21 = 0; i21 < size; i21++) {
            WidgetsList widgetsList3 = (WidgetsList) flow3.D1.get(i21);
            if (i4 == 0) {
                if (i21 < size - 1) {
                    constraintAnchor7 = ((WidgetsList) flow3.D1.get(i21 + 1)).f32372b.R;
                    iF12 = 0;
                } else {
                    constraintAnchor7 = flow3.T;
                    iF12 = flow3.F1();
                }
                ConstraintAnchor constraintAnchor10 = widgetsList3.f32372b.T;
                int i22 = i20;
                widgetsList3.j(i4, constraintAnchor6, constraintAnchor9, constraintAnchor8, constraintAnchor7, i19, i18, iH12, iF12, i5);
                int iMax = Math.max(i17, widgetsList3.f());
                int iE = widgetsList3.e() + i22;
                if (i21 > 0) {
                    iE += flow3.f32368x1;
                }
                i20 = iE;
                i17 = iMax;
                constraintAnchor9 = constraintAnchor10;
                i18 = 0;
            } else {
                int i23 = i17;
                int i24 = i20;
                if (i21 < size - 1) {
                    constraintAnchor = ((WidgetsList) flow3.D1.get(i21 + 1)).f32372b.Q;
                    iH12 = 0;
                } else {
                    constraintAnchor = flow3.S;
                    iH12 = flow3.H1();
                }
                constraintAnchor8 = constraintAnchor;
                ConstraintAnchor constraintAnchor11 = widgetsList3.f32372b.S;
                widgetsList3.j(i4, constraintAnchor6, constraintAnchor9, constraintAnchor8, constraintAnchor7, i19, i18, iH12, iF12, i5);
                int iF = widgetsList3.f() + i23;
                int iMax2 = Math.max(i24, widgetsList3.e());
                if (i21 > 0) {
                    iF += flow3.f32367w1;
                }
                int i25 = iF;
                i20 = iMax2;
                i17 = i25;
                i19 = 0;
                constraintAnchor6 = constraintAnchor11;
            }
        }
        iArr[0] = i17;
        iArr[1] = i20;
    }

    private void v2(ConstraintWidget[] constraintWidgetArr, int i3, int i4, int i5, int[] iArr) {
        int i6;
        Flow flow;
        int i7;
        boolean z2;
        ConstraintAnchor constraintAnchor;
        int i8;
        Flow flow2 = this;
        if (i3 == 0) {
            return;
        }
        flow2.D1.clear();
        int i9 = i5;
        WidgetsList widgetsList = flow2.new WidgetsList(i4, flow2.Q, flow2.R, flow2.S, flow2.T, i9);
        flow2.D1.add(widgetsList);
        boolean z3 = true;
        if (i4 == 0) {
            int i10 = 0;
            i6 = 0;
            int i11 = 0;
            int i12 = 0;
            while (i12 < i3) {
                i10++;
                ConstraintWidget constraintWidget = constraintWidgetArr[i12];
                int iS2 = flow2.s2(constraintWidget, i9);
                if (constraintWidget.C() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                    i6++;
                }
                int i13 = i6;
                boolean z4 = (i11 == i9 || (flow2.f32367w1 + i11) + iS2 > i9) && widgetsList.f32372b != null;
                if (!z4 && i12 > 0 && (i8 = flow2.B1) > 0 && i10 > i8) {
                    z4 = true;
                }
                if (z4) {
                    widgetsList = flow2.new WidgetsList(i4, flow2.Q, flow2.R, flow2.S, flow2.T, i9);
                    widgetsList.i(i12);
                    flow2.D1.add(widgetsList);
                    i10 = 1;
                } else {
                    if (i12 > 0) {
                        i11 += flow2.f32367w1 + iS2;
                    }
                    widgetsList.b(constraintWidget);
                    i12++;
                    i6 = i13;
                }
                i11 = iS2;
                widgetsList.b(constraintWidget);
                i12++;
                i6 = i13;
            }
        } else {
            int i14 = 0;
            i6 = 0;
            int i15 = 0;
            int i16 = 0;
            while (i16 < i3) {
                i14++;
                ConstraintWidget constraintWidget2 = constraintWidgetArr[i16];
                int iR2 = flow2.r2(constraintWidget2, i9);
                if (constraintWidget2.X() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                    i6++;
                }
                int i17 = i6;
                boolean z5 = (i15 == i9 || (flow2.f32368x1 + i15) + iR2 > i9) && widgetsList.f32372b != null;
                if (!z5 && i16 > 0 && (i7 = flow2.B1) > 0 && i14 > i7) {
                    z5 = true;
                }
                if (z5) {
                    widgetsList = flow2.new WidgetsList(i4, flow2.Q, flow2.R, flow2.S, flow2.T, i9);
                    flow = flow2;
                    widgetsList.i(i16);
                    flow.D1.add(widgetsList);
                    i14 = 1;
                } else {
                    flow = flow2;
                    if (i16 > 0) {
                        i15 += flow.f32368x1 + iR2;
                    }
                    widgetsList.b(constraintWidget2);
                    i16++;
                    i9 = i5;
                    i6 = i17;
                    flow2 = flow;
                }
                i15 = iR2;
                widgetsList.b(constraintWidget2);
                i16++;
                i9 = i5;
                i6 = i17;
                flow2 = flow;
            }
        }
        Flow flow3 = flow2;
        int size = flow3.D1.size();
        ConstraintAnchor constraintAnchor2 = flow3.Q;
        ConstraintAnchor constraintAnchor3 = flow3.R;
        ConstraintAnchor constraintAnchor4 = flow3.S;
        ConstraintAnchor constraintAnchor5 = flow3.T;
        int iG1 = flow3.G1();
        int iI1 = flow3.I1();
        int iH1 = flow3.H1();
        int iF1 = flow3.F1();
        ConstraintWidget.DimensionBehaviour dimensionBehaviourC = flow3.C();
        ConstraintWidget.DimensionBehaviour dimensionBehaviour = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        boolean z6 = dimensionBehaviourC == dimensionBehaviour || flow3.X() == dimensionBehaviour;
        if (i6 > 0 && z6) {
            for (int i18 = 0; i18 < size; i18++) {
                WidgetsList widgetsList2 = (WidgetsList) flow3.D1.get(i18);
                if (i4 == 0) {
                    widgetsList2.g(i5 - widgetsList2.f());
                } else {
                    widgetsList2.g(i5 - widgetsList2.e());
                }
            }
        }
        ConstraintAnchor constraintAnchor6 = constraintAnchor3;
        int iF12 = iF1;
        int i19 = 0;
        int i20 = 0;
        int iH12 = iH1;
        int i21 = iI1;
        int i22 = iG1;
        ConstraintAnchor constraintAnchor7 = constraintAnchor5;
        ConstraintAnchor constraintAnchor8 = constraintAnchor4;
        ConstraintAnchor constraintAnchor9 = constraintAnchor2;
        int i23 = 0;
        while (i20 < size) {
            WidgetsList widgetsList3 = (WidgetsList) flow3.D1.get(i20);
            if (i4 == 0) {
                if (i20 < size - 1) {
                    constraintAnchor7 = ((WidgetsList) flow3.D1.get(i20 + 1)).f32372b.R;
                    iF12 = 0;
                } else {
                    constraintAnchor7 = flow3.T;
                    iF12 = flow3.F1();
                }
                ConstraintAnchor constraintAnchor10 = widgetsList3.f32372b.T;
                z2 = z3;
                int i24 = i19;
                widgetsList3.j(i4, constraintAnchor9, constraintAnchor6, constraintAnchor8, constraintAnchor7, i22, i21, iH12, iF12, i5);
                int iMax = Math.max(i23, widgetsList3.f());
                int iE = widgetsList3.e() + i24;
                if (i20 > 0) {
                    iE += flow3.f32368x1;
                }
                i19 = iE;
                i23 = iMax;
                constraintAnchor6 = constraintAnchor10;
                i21 = 0;
            } else {
                int i25 = i19;
                z2 = z3;
                int i26 = i23;
                if (i20 < size - 1) {
                    constraintAnchor = ((WidgetsList) flow3.D1.get(i20 + 1)).f32372b.Q;
                    iH12 = 0;
                } else {
                    constraintAnchor = flow3.S;
                    iH12 = flow3.H1();
                }
                constraintAnchor8 = constraintAnchor;
                ConstraintAnchor constraintAnchor11 = widgetsList3.f32372b.S;
                widgetsList3.j(i4, constraintAnchor9, constraintAnchor6, constraintAnchor8, constraintAnchor7, i22, i21, iH12, iF12, i5);
                int iF = widgetsList3.f() + i26;
                int iMax2 = Math.max(i25, widgetsList3.e());
                if (i20 > 0) {
                    iF += flow3.f32367w1;
                }
                int i27 = iF;
                i19 = iMax2;
                i23 = i27;
                i22 = 0;
                constraintAnchor9 = constraintAnchor11;
            }
            i20++;
            z3 = z2;
        }
        iArr[0] = i23;
        iArr[z3 ? 1 : 0] = i19;
    }

    private void w2(ConstraintWidget[] constraintWidgetArr, int i3, int i4, int i5, int[] iArr) {
        WidgetsList widgetsList;
        if (i3 == 0) {
            return;
        }
        if (this.D1.size() == 0) {
            widgetsList = new WidgetsList(i4, this.Q, this.R, this.S, this.T, i5);
            this.D1.add(widgetsList);
        } else {
            WidgetsList widgetsList2 = (WidgetsList) this.D1.get(0);
            widgetsList2.c();
            widgetsList2.j(i4, this.Q, this.R, this.S, this.T, G1(), I1(), H1(), F1(), i5);
            widgetsList = widgetsList2;
        }
        for (int i6 = 0; i6 < i3; i6++) {
            widgetsList.b(constraintWidgetArr[i6]);
        }
        iArr[0] = widgetsList.f();
        iArr[1] = widgetsList.e();
    }

    public void A2(int i3) {
        this.f32358n1 = i3;
    }

    public void B2(int i3) {
        this.f32369y1 = i3;
    }

    public void C2(float f3) {
        this.f32361q1 = f3;
    }

    public void D2(int i3) {
        this.f32367w1 = i3;
    }

    public void E2(int i3) {
        this.f32355k1 = i3;
    }

    public void F2(float f3) {
        this.f32365u1 = f3;
    }

    public void G2(int i3) {
        this.f32359o1 = i3;
    }

    public void H2(float f3) {
        this.f32366v1 = f3;
    }

    public void I2(int i3) {
        this.f32360p1 = i3;
    }

    @Override // androidx.constraintlayout.core.widgets.VirtualLayout
    public void J1(int i3, int i4, int i5, int i6) {
        int i7;
        ConstraintWidget[] constraintWidgetArr;
        if (this.W0 > 0 && !L1()) {
            O1(0, 0);
            N1(false);
            return;
        }
        int iG1 = G1();
        int iH1 = H1();
        int iI1 = I1();
        int iF1 = F1();
        int[] iArr = new int[2];
        int i8 = (i4 - iG1) - iH1;
        int i9 = this.C1;
        if (i9 == 1) {
            i8 = (i6 - iI1) - iF1;
        }
        int i10 = i8;
        if (i9 == 0) {
            if (this.f32355k1 == -1) {
                this.f32355k1 = 0;
            }
            if (this.f32356l1 == -1) {
                this.f32356l1 = 0;
            }
        } else {
            if (this.f32355k1 == -1) {
                this.f32355k1 = 0;
            }
            if (this.f32356l1 == -1) {
                this.f32356l1 = 0;
            }
        }
        ConstraintWidget[] constraintWidgetArr2 = this.V0;
        int i11 = 0;
        int i12 = 0;
        while (true) {
            i7 = this.W0;
            if (i11 >= i7) {
                break;
            }
            if (this.V0[i11].Z() == 8) {
                i12++;
            }
            i11++;
        }
        if (i12 > 0) {
            ConstraintWidget[] constraintWidgetArr3 = new ConstraintWidget[i7 - i12];
            int i13 = 0;
            i7 = 0;
            while (i13 < this.W0) {
                ConstraintWidget constraintWidget = this.V0[i13];
                ConstraintWidget[] constraintWidgetArr4 = constraintWidgetArr3;
                if (constraintWidget.Z() != 8) {
                    constraintWidgetArr4[i7] = constraintWidget;
                    i7++;
                }
                i13++;
                constraintWidgetArr3 = constraintWidgetArr4;
            }
            constraintWidgetArr = constraintWidgetArr3;
        } else {
            constraintWidgetArr = constraintWidgetArr2;
        }
        int i14 = i7;
        this.H1 = constraintWidgetArr;
        this.I1 = i14;
        int i15 = this.A1;
        if (i15 == 0) {
            w2(constraintWidgetArr, i14, this.C1, i10, iArr);
        } else if (i15 == 1) {
            u2(constraintWidgetArr, i14, this.C1, i10, iArr);
        } else if (i15 == 2) {
            t2(constraintWidgetArr, i14, this.C1, i10, iArr);
        } else if (i15 == 3) {
            v2(constraintWidgetArr, i14, this.C1, i10, iArr);
        }
        int iMin = iArr[0] + iG1 + iH1;
        int iMin2 = iArr[1] + iI1 + iF1;
        if (i3 == 1073741824) {
            iMin = i4;
        } else if (i3 == Integer.MIN_VALUE) {
            iMin = Math.min(iMin, i4);
        } else if (i3 != 0) {
            iMin = 0;
        }
        if (i5 == 1073741824) {
            iMin2 = i6;
        } else if (i5 == Integer.MIN_VALUE) {
            iMin2 = Math.min(iMin2, i6);
        } else if (i5 != 0) {
            iMin2 = 0;
        }
        O1(iMin, iMin2);
        r1(iMin);
        S0(iMin2);
        N1(this.W0 > 0);
    }

    public void J2(int i3) {
        this.B1 = i3;
    }

    public void K2(int i3) {
        this.C1 = i3;
    }

    public void L2(int i3) {
        this.f32370z1 = i3;
    }

    public void M2(float f3) {
        this.f32362r1 = f3;
    }

    public void N2(int i3) {
        this.f32368x1 = i3;
    }

    public void O2(int i3) {
        this.f32356l1 = i3;
    }

    public void P2(int i3) {
        this.A1 = i3;
    }

    @Override // androidx.constraintlayout.core.widgets.ConstraintWidget
    public void g(LinearSystem linearSystem, boolean z2) {
        super.g(linearSystem, z2);
        boolean z3 = N() != null && ((ConstraintWidgetContainer) N()).Y1();
        int i3 = this.A1;
        if (i3 != 0) {
            if (i3 == 1) {
                int size = this.D1.size();
                int i4 = 0;
                while (i4 < size) {
                    ((WidgetsList) this.D1.get(i4)).d(z3, i4, i4 == size + (-1));
                    i4++;
                }
            } else if (i3 == 2) {
                q2(z3);
            } else if (i3 == 3) {
                int size2 = this.D1.size();
                int i5 = 0;
                while (i5 < size2) {
                    ((WidgetsList) this.D1.get(i5)).d(z3, i5, i5 == size2 + (-1));
                    i5++;
                }
            }
        } else if (this.D1.size() > 0) {
            ((WidgetsList) this.D1.get(0)).d(z3, 0, true);
        }
        N1(false);
    }

    @Override // androidx.constraintlayout.core.widgets.HelperWidget, androidx.constraintlayout.core.widgets.ConstraintWidget
    public void n(ConstraintWidget constraintWidget, HashMap map) {
        super.n(constraintWidget, map);
        Flow flow = (Flow) constraintWidget;
        this.f32355k1 = flow.f32355k1;
        this.f32356l1 = flow.f32356l1;
        this.f32357m1 = flow.f32357m1;
        this.f32358n1 = flow.f32358n1;
        this.f32359o1 = flow.f32359o1;
        this.f32360p1 = flow.f32360p1;
        this.f32361q1 = flow.f32361q1;
        this.f32362r1 = flow.f32362r1;
        this.f32363s1 = flow.f32363s1;
        this.f32364t1 = flow.f32364t1;
        this.f32365u1 = flow.f32365u1;
        this.f32366v1 = flow.f32366v1;
        this.f32367w1 = flow.f32367w1;
        this.f32368x1 = flow.f32368x1;
        this.f32369y1 = flow.f32369y1;
        this.f32370z1 = flow.f32370z1;
        this.A1 = flow.A1;
        this.B1 = flow.B1;
        this.C1 = flow.C1;
    }

    public void x2(float f3) {
        this.f32363s1 = f3;
    }

    public void y2(int i3) {
        this.f32357m1 = i3;
    }

    public void z2(float f3) {
        this.f32364t1 = f3;
    }
}
