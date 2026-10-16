package androidx.constraintlayout.core.widgets.analyzer;

import androidx.constraintlayout.core.LinearSystem;
import androidx.constraintlayout.core.Metrics;
import androidx.constraintlayout.core.widgets.ConstraintAnchor;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.core.widgets.ConstraintWidgetContainer;
import androidx.constraintlayout.core.widgets.Guideline;
import androidx.constraintlayout.core.widgets.Helper;
import androidx.constraintlayout.core.widgets.Optimizer;
import androidx.constraintlayout.core.widgets.VirtualLayout;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public class BasicMeasure {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ArrayList f32404a = new ArrayList();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Measure f32405b = new Measure();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private ConstraintWidgetContainer f32406c;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static class Measure {

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public static int f32407k = 0;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public static int f32408l = 1;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public static int f32409m = 2;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public ConstraintWidget.DimensionBehaviour f32410a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public ConstraintWidget.DimensionBehaviour f32411b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f32412c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f32413d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f32414e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f32415f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f32416g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public boolean f32417h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public boolean f32418i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public int f32419j;
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface Measurer {
        void a();

        void b(ConstraintWidget constraintWidget, Measure measure);
    }

    public BasicMeasure(ConstraintWidgetContainer constraintWidgetContainer) {
        this.f32406c = constraintWidgetContainer;
    }

    private boolean a(Measurer measurer, ConstraintWidget constraintWidget, int i3) {
        this.f32405b.f32410a = constraintWidget.C();
        this.f32405b.f32411b = constraintWidget.X();
        this.f32405b.f32412c = constraintWidget.a0();
        this.f32405b.f32413d = constraintWidget.z();
        Measure measure = this.f32405b;
        measure.f32418i = false;
        measure.f32419j = i3;
        ConstraintWidget.DimensionBehaviour dimensionBehaviour = measure.f32410a;
        ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
        boolean z2 = dimensionBehaviour == dimensionBehaviour2;
        boolean z3 = measure.f32411b == dimensionBehaviour2;
        boolean z4 = z2 && constraintWidget.f32282f0 > 0.0f;
        boolean z5 = z3 && constraintWidget.f32282f0 > 0.0f;
        if (z4 && constraintWidget.f32319y[0] == 4) {
            measure.f32410a = ConstraintWidget.DimensionBehaviour.FIXED;
        }
        if (z5 && constraintWidget.f32319y[1] == 4) {
            measure.f32411b = ConstraintWidget.DimensionBehaviour.FIXED;
        }
        measurer.b(constraintWidget, measure);
        constraintWidget.r1(this.f32405b.f32414e);
        constraintWidget.S0(this.f32405b.f32415f);
        constraintWidget.R0(this.f32405b.f32417h);
        constraintWidget.H0(this.f32405b.f32416g);
        Measure measure2 = this.f32405b;
        measure2.f32419j = Measure.f32407k;
        return measure2.f32418i;
    }

    /* JADX WARN: Removed duplicated region for block: B:56:0x0098 A[PHI: r10
      0x0098: PHI (r10v2 boolean) = (r10v1 boolean), (r10v1 boolean), (r10v1 boolean), (r10v4 boolean), (r10v4 boolean) binds: [B:32:0x0062, B:34:0x0068, B:36:0x006c, B:54:0x0095, B:52:0x008e] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:59:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x00ac A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void b(androidx.constraintlayout.core.widgets.ConstraintWidgetContainer r13) {
        /*
            r12 = this;
            java.util.ArrayList r0 = r13.V0
            int r0 = r0.size()
            r1 = 64
            boolean r1 = r13.c2(r1)
            androidx.constraintlayout.core.widgets.analyzer.BasicMeasure$Measurer r2 = r13.R1()
            r3 = 0
            r4 = r3
        L12:
            if (r4 >= r0) goto Lb0
            java.util.ArrayList r5 = r13.V0
            java.lang.Object r5 = r5.get(r4)
            androidx.constraintlayout.core.widgets.ConstraintWidget r5 = (androidx.constraintlayout.core.widgets.ConstraintWidget) r5
            boolean r6 = r5 instanceof androidx.constraintlayout.core.widgets.Guideline
            if (r6 == 0) goto L22
            goto Lac
        L22:
            boolean r6 = r5 instanceof androidx.constraintlayout.core.widgets.Barrier
            if (r6 == 0) goto L28
            goto Lac
        L28:
            boolean r6 = r5.p0()
            if (r6 == 0) goto L30
            goto Lac
        L30:
            if (r1 == 0) goto L48
            androidx.constraintlayout.core.widgets.analyzer.HorizontalWidgetRun r6 = r5.f32279e
            if (r6 == 0) goto L48
            androidx.constraintlayout.core.widgets.analyzer.VerticalWidgetRun r7 = r5.f32281f
            if (r7 == 0) goto L48
            androidx.constraintlayout.core.widgets.analyzer.DimensionDependency r6 = r6.f32487e
            boolean r6 = r6.f32440j
            if (r6 == 0) goto L48
            androidx.constraintlayout.core.widgets.analyzer.DimensionDependency r6 = r7.f32487e
            boolean r6 = r6.f32440j
            if (r6 == 0) goto L48
            goto Lac
        L48:
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r6 = r5.w(r3)
            r7 = 1
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r8 = r5.w(r7)
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r9 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
            if (r6 != r9) goto L61
            int r10 = r5.f32315w
            if (r10 == r7) goto L61
            if (r8 != r9) goto L61
            int r10 = r5.f32317x
            if (r10 == r7) goto L61
            r10 = r7
            goto L62
        L61:
            r10 = r3
        L62:
            if (r10 != 0) goto L98
            boolean r11 = r13.c2(r7)
            if (r11 == 0) goto L98
            boolean r11 = r5 instanceof androidx.constraintlayout.core.widgets.VirtualLayout
            if (r11 != 0) goto L98
            if (r6 != r9) goto L7d
            int r11 = r5.f32315w
            if (r11 != 0) goto L7d
            if (r8 == r9) goto L7d
            boolean r11 = r5.m0()
            if (r11 != 0) goto L7d
            r10 = r7
        L7d:
            if (r8 != r9) goto L8c
            int r11 = r5.f32317x
            if (r11 != 0) goto L8c
            if (r6 == r9) goto L8c
            boolean r11 = r5.m0()
            if (r11 != 0) goto L8c
            r10 = r7
        L8c:
            if (r6 == r9) goto L90
            if (r8 != r9) goto L98
        L90:
            float r6 = r5.f32282f0
            r8 = 0
            int r6 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r6 <= 0) goto L98
            goto L99
        L98:
            r7 = r10
        L99:
            if (r7 == 0) goto L9c
            goto Lac
        L9c:
            int r6 = androidx.constraintlayout.core.widgets.analyzer.BasicMeasure.Measure.f32407k
            r12.a(r2, r5, r6)
            androidx.constraintlayout.core.Metrics r5 = r13.f32330b1
            if (r5 == 0) goto Lac
            long r6 = r5.f31194b
            r8 = 1
            long r6 = r6 + r8
            r5.f31194b = r6
        Lac:
            int r4 = r4 + 1
            goto L12
        Lb0:
            r2.a()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.widgets.analyzer.BasicMeasure.b(androidx.constraintlayout.core.widgets.ConstraintWidgetContainer):void");
    }

    private void c(ConstraintWidgetContainer constraintWidgetContainer, String str, int i3, int i4, int i5) {
        long jNanoTime = constraintWidgetContainer.f32330b1 != null ? System.nanoTime() : 0L;
        int iL = constraintWidgetContainer.L();
        int iK = constraintWidgetContainer.K();
        constraintWidgetContainer.h1(0);
        constraintWidgetContainer.g1(0);
        constraintWidgetContainer.r1(i4);
        constraintWidgetContainer.S0(i5);
        constraintWidgetContainer.h1(iL);
        constraintWidgetContainer.g1(iK);
        this.f32406c.g2(i3);
        this.f32406c.A1();
        if (constraintWidgetContainer.f32330b1 != null) {
            long jNanoTime2 = System.nanoTime();
            Metrics metrics = constraintWidgetContainer.f32330b1;
            metrics.G++;
            metrics.f31193a += jNanoTime2 - jNanoTime;
        }
    }

    public long d(ConstraintWidgetContainer constraintWidgetContainer, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11) {
        long j3;
        boolean zP1;
        int i12;
        int i13;
        int i14;
        long j4;
        int i15;
        long j5;
        int i16;
        int i17;
        boolean z2;
        Metrics metrics;
        BasicMeasure basicMeasure = this;
        ConstraintWidgetContainer constraintWidgetContainer2 = constraintWidgetContainer;
        Measurer measurerR1 = constraintWidgetContainer2.R1();
        int size = constraintWidgetContainer2.V0.size();
        int iA0 = constraintWidgetContainer2.a0();
        int iZ = constraintWidgetContainer2.z();
        boolean zB = Optimizer.b(i3, ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD);
        boolean z3 = zB || Optimizer.b(i3, 64);
        if (z3) {
            for (int i18 = 0; i18 < size; i18++) {
                ConstraintWidget constraintWidget = (ConstraintWidget) constraintWidgetContainer2.V0.get(i18);
                ConstraintWidget.DimensionBehaviour dimensionBehaviourC = constraintWidget.C();
                ConstraintWidget.DimensionBehaviour dimensionBehaviour = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
                boolean z4 = (dimensionBehaviourC == dimensionBehaviour) && (constraintWidget.X() == dimensionBehaviour) && constraintWidget.x() > 0.0f;
                if ((constraintWidget.m0() && z4) || ((constraintWidget.o0() && z4) || (constraintWidget instanceof VirtualLayout) || constraintWidget.m0() || constraintWidget.o0())) {
                    z3 = false;
                    break;
                }
            }
        }
        if (z3 && (metrics = LinearSystem.f31172x) != null) {
            metrics.f31196d++;
        }
        boolean z5 = z3 & ((i6 == 1073741824 && i8 == 1073741824) || zB);
        int i19 = 2;
        if (z5) {
            j3 = 1;
            int iMin = Math.min(constraintWidgetContainer2.J(), i7);
            int iMin2 = Math.min(constraintWidgetContainer2.I(), i9);
            if (i6 == 1073741824 && constraintWidgetContainer2.a0() != iMin) {
                constraintWidgetContainer2.r1(iMin);
                constraintWidgetContainer2.V1();
            }
            if (i8 == 1073741824 && constraintWidgetContainer2.z() != iMin2) {
                constraintWidgetContainer2.S0(iMin2);
                constraintWidgetContainer2.V1();
            }
            if (i6 == 1073741824 && i8 == 1073741824) {
                zP1 = constraintWidgetContainer2.N1(zB);
                i12 = 2;
            } else {
                boolean zO1 = constraintWidgetContainer2.O1(zB);
                if (i6 == 1073741824) {
                    zO1 &= constraintWidgetContainer2.P1(zB, 0);
                    i12 = 1;
                } else {
                    i12 = 0;
                }
                if (i8 == 1073741824) {
                    zP1 = constraintWidgetContainer2.P1(zB, 1) & zO1;
                    i12++;
                } else {
                    zP1 = zO1;
                }
            }
            if (zP1) {
                constraintWidgetContainer2.w1(i6 == 1073741824, i8 == 1073741824);
            }
        } else {
            j3 = 1;
            zP1 = false;
            i12 = 0;
        }
        if (!zP1 || i12 != 2) {
            int iS1 = constraintWidgetContainer2.S1();
            if (size > 0) {
                b(constraintWidgetContainer);
            }
            jNanoTime = constraintWidgetContainer2.f32330b1 != null ? System.nanoTime() : 0L;
            e(constraintWidgetContainer);
            int size2 = basicMeasure.f32404a.size();
            if (size > 0) {
                basicMeasure.c(constraintWidgetContainer2, "First pass", 0, iA0, iZ);
                i13 = iA0;
                i14 = iZ;
            } else {
                i13 = iA0;
                i14 = iZ;
            }
            if (size2 > 0) {
                ConstraintWidget.DimensionBehaviour dimensionBehaviourC2 = constraintWidgetContainer2.C();
                ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
                boolean z6 = dimensionBehaviourC2 == dimensionBehaviour2;
                boolean z7 = constraintWidgetContainer2.X() == dimensionBehaviour2;
                int iMax = Math.max(constraintWidgetContainer2.a0(), basicMeasure.f32406c.L());
                int iMax2 = Math.max(constraintWidgetContainer2.z(), basicMeasure.f32406c.K());
                int i20 = 0;
                boolean zM1 = false;
                while (i20 < size2) {
                    ConstraintWidget constraintWidget2 = (ConstraintWidget) basicMeasure.f32404a.get(i20);
                    boolean z8 = z5;
                    if (constraintWidget2 instanceof VirtualLayout) {
                        int iA02 = constraintWidget2.a0();
                        j5 = jNanoTime;
                        int iZ2 = constraintWidget2.z();
                        boolean zA = zM1 | basicMeasure.a(measurerR1, constraintWidget2, Measure.f32408l);
                        Metrics metrics2 = constraintWidgetContainer2.f32330b1;
                        i16 = i13;
                        i17 = i14;
                        if (metrics2 != null) {
                            metrics2.f31195c += j3;
                        }
                        int iA03 = constraintWidget2.a0();
                        int iZ3 = constraintWidget2.z();
                        if (iA03 != iA02) {
                            constraintWidget2.r1(iA03);
                            if (z6 && constraintWidget2.P() > iMax) {
                                iMax = Math.max(iMax, constraintWidget2.P() + constraintWidget2.q(ConstraintAnchor.Type.RIGHT).f());
                            }
                            z2 = true;
                        } else {
                            z2 = zA;
                        }
                        if (iZ3 != iZ2) {
                            constraintWidget2.S0(iZ3);
                            if (z7 && constraintWidget2.t() > iMax2) {
                                iMax2 = Math.max(iMax2, constraintWidget2.t() + constraintWidget2.q(ConstraintAnchor.Type.BOTTOM).f());
                            }
                            z2 = true;
                        }
                        zM1 = z2 | ((VirtualLayout) constraintWidget2).M1();
                    } else {
                        j5 = jNanoTime;
                        i16 = i13;
                        i17 = i14;
                    }
                    i20++;
                    i13 = i16;
                    i14 = i17;
                    z5 = z8;
                    jNanoTime = j5;
                    i19 = 2;
                }
                boolean z9 = z5;
                j4 = jNanoTime;
                int i21 = i13;
                int i22 = i14;
                int i23 = i19;
                int i24 = 0;
                while (true) {
                    if (i24 >= i23) {
                        break;
                    }
                    int i25 = 0;
                    while (i25 < size2) {
                        ConstraintWidget constraintWidget3 = (ConstraintWidget) basicMeasure.f32404a.get(i25);
                        if (((constraintWidget3 instanceof Helper) && !(constraintWidget3 instanceof VirtualLayout)) || (constraintWidget3 instanceof Guideline) || constraintWidget3.Z() == 8 || ((z9 && constraintWidget3.f32279e.f32487e.f32440j && constraintWidget3.f32281f.f32487e.f32440j) || (constraintWidget3 instanceof VirtualLayout))) {
                            i15 = i24;
                        } else {
                            int iA04 = constraintWidget3.a0();
                            int iZ4 = constraintWidget3.z();
                            int iR = constraintWidget3.r();
                            int i26 = Measure.f32408l;
                            if (i24 == 1) {
                                i26 = Measure.f32409m;
                            }
                            boolean zA2 = zM1 | basicMeasure.a(measurerR1, constraintWidget3, i26);
                            Metrics metrics3 = constraintWidgetContainer2.f32330b1;
                            i15 = i24;
                            if (metrics3 != null) {
                                metrics3.f31195c += j3;
                            }
                            int iA05 = constraintWidget3.a0();
                            int iZ5 = constraintWidget3.z();
                            if (iA05 != iA04) {
                                constraintWidget3.r1(iA05);
                                if (z6 && constraintWidget3.P() > iMax) {
                                    iMax = Math.max(iMax, constraintWidget3.P() + constraintWidget3.q(ConstraintAnchor.Type.RIGHT).f());
                                }
                                zA2 = true;
                            }
                            if (iZ5 != iZ4) {
                                constraintWidget3.S0(iZ5);
                                if (z7 && constraintWidget3.t() > iMax2) {
                                    iMax2 = Math.max(iMax2, constraintWidget3.t() + constraintWidget3.q(ConstraintAnchor.Type.BOTTOM).f());
                                }
                                zA2 = true;
                            }
                            zM1 = (!constraintWidget3.d0() || iR == constraintWidget3.r()) ? zA2 : true;
                        }
                        i25++;
                        basicMeasure = this;
                        constraintWidgetContainer2 = constraintWidgetContainer;
                        i24 = i15;
                    }
                    int i27 = i24;
                    if (!zM1) {
                        constraintWidgetContainer2 = constraintWidgetContainer;
                        break;
                    }
                    i24 = i27 + 1;
                    c(constraintWidgetContainer, "intermediate pass", i24, i21, i22);
                    basicMeasure = this;
                    constraintWidgetContainer2 = constraintWidgetContainer;
                    i23 = 2;
                    zM1 = false;
                }
            } else {
                j4 = jNanoTime;
            }
            constraintWidgetContainer2.f2(iS1);
            jNanoTime = j4;
        }
        return constraintWidgetContainer2.f32330b1 != null ? System.nanoTime() - jNanoTime : jNanoTime;
    }

    public void e(ConstraintWidgetContainer constraintWidgetContainer) {
        this.f32404a.clear();
        int size = constraintWidgetContainer.V0.size();
        for (int i3 = 0; i3 < size; i3++) {
            ConstraintWidget constraintWidget = (ConstraintWidget) constraintWidgetContainer.V0.get(i3);
            ConstraintWidget.DimensionBehaviour dimensionBehaviourC = constraintWidget.C();
            ConstraintWidget.DimensionBehaviour dimensionBehaviour = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
            if (dimensionBehaviourC == dimensionBehaviour || constraintWidget.X() == dimensionBehaviour) {
                this.f32404a.add(constraintWidget);
            }
        }
        constraintWidgetContainer.V1();
    }
}
