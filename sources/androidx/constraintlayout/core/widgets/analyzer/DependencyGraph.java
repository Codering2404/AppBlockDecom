package androidx.constraintlayout.core.widgets.analyzer;

import androidx.constraintlayout.core.widgets.ConstraintAnchor;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.core.widgets.ConstraintWidgetContainer;
import androidx.constraintlayout.core.widgets.Guideline;
import androidx.constraintlayout.core.widgets.HelperWidget;
import androidx.constraintlayout.core.widgets.analyzer.BasicMeasure;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public class DependencyGraph {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private ConstraintWidgetContainer f32422a;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private ConstraintWidgetContainer f32425d;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f32423b = true;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f32424c = true;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private ArrayList f32426e = new ArrayList();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private ArrayList f32427f = new ArrayList();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private BasicMeasure.Measurer f32428g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private BasicMeasure.Measure f32429h = new BasicMeasure.Measure();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    ArrayList f32430i = new ArrayList();

    public DependencyGraph(ConstraintWidgetContainer constraintWidgetContainer) {
        this.f32422a = constraintWidgetContainer;
        this.f32425d = constraintWidgetContainer;
    }

    private void a(DependencyNode dependencyNode, int i3, int i4, DependencyNode dependencyNode2, ArrayList arrayList, RunGroup runGroup) {
        int i5;
        DependencyNode dependencyNode3;
        ArrayList arrayList2;
        WidgetRun widgetRun = dependencyNode.f32434d;
        if (widgetRun.f32485c == null) {
            ConstraintWidgetContainer constraintWidgetContainer = this.f32422a;
            if (widgetRun == constraintWidgetContainer.f32279e || widgetRun == constraintWidgetContainer.f32281f) {
                return;
            }
            if (runGroup == null) {
                runGroup = new RunGroup(widgetRun, i4);
                arrayList.add(runGroup);
            }
            RunGroup runGroup2 = runGroup;
            widgetRun.f32485c = runGroup2;
            runGroup2.a(widgetRun);
            for (Dependency dependency : widgetRun.f32490h.f32441k) {
                if (dependency instanceof DependencyNode) {
                    i5 = i3;
                    dependencyNode3 = dependencyNode2;
                    arrayList2 = arrayList;
                    a((DependencyNode) dependency, i5, 0, dependencyNode3, arrayList2, runGroup2);
                } else {
                    i5 = i3;
                    dependencyNode3 = dependencyNode2;
                    arrayList2 = arrayList;
                }
                i3 = i5;
                dependencyNode2 = dependencyNode3;
                arrayList = arrayList2;
            }
            int i6 = i3;
            DependencyNode dependencyNode4 = dependencyNode2;
            ArrayList arrayList3 = arrayList;
            for (Dependency dependency2 : widgetRun.f32491i.f32441k) {
                if (dependency2 instanceof DependencyNode) {
                    a((DependencyNode) dependency2, i6, 1, dependencyNode4, arrayList3, runGroup2);
                }
            }
            if (i6 == 1 && (widgetRun instanceof VerticalWidgetRun)) {
                for (Dependency dependency3 : ((VerticalWidgetRun) widgetRun).f32466k.f32441k) {
                    if (dependency3 instanceof DependencyNode) {
                        a((DependencyNode) dependency3, i6, 2, dependencyNode4, arrayList3, runGroup2);
                    }
                }
            }
            for (DependencyNode dependencyNode5 : widgetRun.f32490h.f32442l) {
                if (dependencyNode5 == dependencyNode4) {
                    runGroup2.f32460b = true;
                }
                a(dependencyNode5, i6, 0, dependencyNode4, arrayList3, runGroup2);
            }
            for (DependencyNode dependencyNode6 : widgetRun.f32491i.f32442l) {
                if (dependencyNode6 == dependencyNode4) {
                    runGroup2.f32460b = true;
                }
                a(dependencyNode6, i6, 1, dependencyNode4, arrayList3, runGroup2);
            }
            if (i6 == 1 && (widgetRun instanceof VerticalWidgetRun)) {
                Iterator it = ((VerticalWidgetRun) widgetRun).f32466k.f32442l.iterator();
                while (it.hasNext()) {
                    a((DependencyNode) it.next(), i6, 2, dependencyNode4, arrayList3, runGroup2);
                }
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private boolean b(ConstraintWidgetContainer constraintWidgetContainer) {
        ConstraintWidget.DimensionBehaviour dimensionBehaviour;
        int i3;
        ConstraintWidget.DimensionBehaviour dimensionBehaviour2;
        float f3;
        float f4;
        ConstraintWidget.DimensionBehaviour dimensionBehaviour3;
        ConstraintWidget.DimensionBehaviour dimensionBehaviour4;
        ConstraintWidget.DimensionBehaviour dimensionBehaviour5;
        ArrayList arrayList = constraintWidgetContainer.V0;
        int size = arrayList.size();
        char c3 = 0;
        int i4 = 0;
        while (i4 < size) {
            Object obj = arrayList.get(i4);
            i4++;
            ConstraintWidget constraintWidget = (ConstraintWidget) obj;
            ConstraintWidget.DimensionBehaviour[] dimensionBehaviourArr = constraintWidget.f32274b0;
            ConstraintWidget.DimensionBehaviour dimensionBehaviour6 = dimensionBehaviourArr[c3];
            ConstraintWidget.DimensionBehaviour dimensionBehaviour7 = dimensionBehaviourArr[1];
            if (constraintWidget.Z() == 8) {
                constraintWidget.f32271a = true;
            } else {
                if (constraintWidget.B < 1.0f && dimensionBehaviour6 == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                    constraintWidget.f32315w = 2;
                }
                if (constraintWidget.E < 1.0f && dimensionBehaviour7 == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                    constraintWidget.f32317x = 2;
                }
                if (constraintWidget.x() > 0.0f) {
                    ConstraintWidget.DimensionBehaviour dimensionBehaviour8 = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
                    if (dimensionBehaviour6 == dimensionBehaviour8 && (dimensionBehaviour7 == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT || dimensionBehaviour7 == ConstraintWidget.DimensionBehaviour.FIXED)) {
                        constraintWidget.f32315w = 3;
                    } else if (dimensionBehaviour7 == dimensionBehaviour8 && (dimensionBehaviour6 == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT || dimensionBehaviour6 == ConstraintWidget.DimensionBehaviour.FIXED)) {
                        constraintWidget.f32317x = 3;
                    } else if (dimensionBehaviour6 == dimensionBehaviour8 && dimensionBehaviour7 == dimensionBehaviour8) {
                        if (constraintWidget.f32315w == 0) {
                            constraintWidget.f32315w = 3;
                        }
                        if (constraintWidget.f32317x == 0) {
                            constraintWidget.f32317x = 3;
                        }
                    }
                }
                ConstraintWidget.DimensionBehaviour dimensionBehaviour9 = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
                if (dimensionBehaviour6 == dimensionBehaviour9 && constraintWidget.f32315w == 1 && (constraintWidget.Q.f32257f == null || constraintWidget.S.f32257f == null)) {
                    dimensionBehaviour6 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
                }
                if (dimensionBehaviour7 == dimensionBehaviour9 && constraintWidget.f32317x == 1 && (constraintWidget.R.f32257f == null || constraintWidget.T.f32257f == null)) {
                    dimensionBehaviour7 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
                }
                HorizontalWidgetRun horizontalWidgetRun = constraintWidget.f32279e;
                horizontalWidgetRun.f32486d = dimensionBehaviour6;
                int i5 = constraintWidget.f32315w;
                horizontalWidgetRun.f32483a = i5;
                VerticalWidgetRun verticalWidgetRun = constraintWidget.f32281f;
                verticalWidgetRun.f32486d = dimensionBehaviour7;
                int i6 = constraintWidget.f32317x;
                verticalWidgetRun.f32483a = i6;
                ConstraintWidget.DimensionBehaviour dimensionBehaviour10 = ConstraintWidget.DimensionBehaviour.MATCH_PARENT;
                char c4 = c3;
                if ((dimensionBehaviour6 == dimensionBehaviour10 || dimensionBehaviour6 == ConstraintWidget.DimensionBehaviour.FIXED || dimensionBehaviour6 == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) && (dimensionBehaviour7 == dimensionBehaviour10 || dimensionBehaviour7 == ConstraintWidget.DimensionBehaviour.FIXED || dimensionBehaviour7 == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT)) {
                    ConstraintWidget.DimensionBehaviour dimensionBehaviour11 = dimensionBehaviour7;
                    ConstraintWidget.DimensionBehaviour dimensionBehaviour12 = dimensionBehaviour6;
                    int iA0 = constraintWidget.a0();
                    if (dimensionBehaviour12 == dimensionBehaviour10) {
                        iA0 = (constraintWidgetContainer.a0() - constraintWidget.Q.f32258g) - constraintWidget.S.f32258g;
                        dimensionBehaviour12 = ConstraintWidget.DimensionBehaviour.FIXED;
                    }
                    int i7 = iA0;
                    int iZ = constraintWidget.z();
                    if (dimensionBehaviour11 == dimensionBehaviour10) {
                        iZ = (constraintWidgetContainer.z() - constraintWidget.R.f32258g) - constraintWidget.T.f32258g;
                        dimensionBehaviour11 = ConstraintWidget.DimensionBehaviour.FIXED;
                    }
                    l(constraintWidget, dimensionBehaviour12, i7, dimensionBehaviour11, iZ);
                    constraintWidget.f32279e.f32487e.d(constraintWidget.a0());
                    constraintWidget.f32281f.f32487e.d(constraintWidget.z());
                    constraintWidget.f32271a = true;
                } else {
                    if (dimensionBehaviour6 == dimensionBehaviour9) {
                        dimensionBehaviour2 = dimensionBehaviour9;
                        f4 = 0.5f;
                        ConstraintWidget.DimensionBehaviour dimensionBehaviour13 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
                        f3 = 1.0f;
                        if (dimensionBehaviour7 != dimensionBehaviour13 && dimensionBehaviour7 != ConstraintWidget.DimensionBehaviour.FIXED) {
                            dimensionBehaviour = dimensionBehaviour7;
                            i3 = 3;
                        } else if (i5 == 3) {
                            if (dimensionBehaviour7 == dimensionBehaviour13) {
                                l(constraintWidget, dimensionBehaviour13, 0, dimensionBehaviour13, 0);
                            }
                            int iZ2 = constraintWidget.z();
                            int i8 = (int) ((iZ2 * constraintWidget.f32282f0) + 0.5f);
                            ConstraintWidget.DimensionBehaviour dimensionBehaviour14 = ConstraintWidget.DimensionBehaviour.FIXED;
                            l(constraintWidget, dimensionBehaviour14, i8, dimensionBehaviour14, iZ2);
                            constraintWidget.f32279e.f32487e.d(constraintWidget.a0());
                            constraintWidget.f32281f.f32487e.d(constraintWidget.z());
                            constraintWidget.f32271a = true;
                        } else if (i5 == 1) {
                            l(constraintWidget, dimensionBehaviour13, 0, dimensionBehaviour7, 0);
                            constraintWidget.f32279e.f32487e.f32452m = constraintWidget.a0();
                        } else {
                            dimensionBehaviour = dimensionBehaviour7;
                            i3 = 3;
                            if (i5 == 2) {
                                ConstraintWidget.DimensionBehaviour dimensionBehaviour15 = constraintWidgetContainer.f32274b0[c4];
                                ConstraintWidget.DimensionBehaviour dimensionBehaviour16 = ConstraintWidget.DimensionBehaviour.FIXED;
                                if (dimensionBehaviour15 == dimensionBehaviour16 || dimensionBehaviour15 == dimensionBehaviour10) {
                                    l(constraintWidget, dimensionBehaviour16, (int) ((constraintWidget.B * constraintWidgetContainer.a0()) + 0.5f), dimensionBehaviour, constraintWidget.z());
                                    constraintWidget.f32279e.f32487e.d(constraintWidget.a0());
                                    constraintWidget.f32281f.f32487e.d(constraintWidget.z());
                                    constraintWidget.f32271a = true;
                                }
                            } else {
                                ConstraintAnchor[] constraintAnchorArr = constraintWidget.Y;
                                if (constraintAnchorArr[c4].f32257f == null || constraintAnchorArr[1].f32257f == null) {
                                    l(constraintWidget, dimensionBehaviour13, 0, dimensionBehaviour, 0);
                                    constraintWidget.f32279e.f32487e.d(constraintWidget.a0());
                                    constraintWidget.f32281f.f32487e.d(constraintWidget.z());
                                    constraintWidget.f32271a = true;
                                }
                            }
                        }
                    } else {
                        dimensionBehaviour = dimensionBehaviour7;
                        i3 = 3;
                        dimensionBehaviour2 = dimensionBehaviour9;
                        f3 = 1.0f;
                        f4 = 0.5f;
                    }
                    if (dimensionBehaviour != dimensionBehaviour2 || (dimensionBehaviour6 != (dimensionBehaviour4 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) && dimensionBehaviour6 != ConstraintWidget.DimensionBehaviour.FIXED)) {
                        dimensionBehaviour3 = dimensionBehaviour6;
                    } else if (i6 == i3) {
                        if (dimensionBehaviour6 == dimensionBehaviour4) {
                            l(constraintWidget, dimensionBehaviour4, 0, dimensionBehaviour4, 0);
                        }
                        int iA02 = constraintWidget.a0();
                        float f5 = constraintWidget.f32282f0;
                        if (constraintWidget.y() == -1) {
                            f5 = f3 / f5;
                        }
                        ConstraintWidget.DimensionBehaviour dimensionBehaviour17 = ConstraintWidget.DimensionBehaviour.FIXED;
                        l(constraintWidget, dimensionBehaviour17, iA02, dimensionBehaviour17, (int) ((iA02 * f5) + f4));
                        constraintWidget.f32279e.f32487e.d(constraintWidget.a0());
                        constraintWidget.f32281f.f32487e.d(constraintWidget.z());
                        constraintWidget.f32271a = true;
                    } else if (i6 == 1) {
                        l(constraintWidget, dimensionBehaviour6, 0, dimensionBehaviour4, 0);
                        constraintWidget.f32281f.f32487e.f32452m = constraintWidget.z();
                    } else {
                        dimensionBehaviour3 = dimensionBehaviour6;
                        if (i6 == 2) {
                            ConstraintWidget.DimensionBehaviour dimensionBehaviour18 = constraintWidgetContainer.f32274b0[1];
                            dimensionBehaviour5 = dimensionBehaviour;
                            ConstraintWidget.DimensionBehaviour dimensionBehaviour19 = ConstraintWidget.DimensionBehaviour.FIXED;
                            if (dimensionBehaviour18 == dimensionBehaviour19 || dimensionBehaviour18 == dimensionBehaviour10) {
                                l(constraintWidget, dimensionBehaviour3, constraintWidget.a0(), dimensionBehaviour19, (int) ((constraintWidget.E * constraintWidgetContainer.z()) + f4));
                                constraintWidget.f32279e.f32487e.d(constraintWidget.a0());
                                constraintWidget.f32281f.f32487e.d(constraintWidget.z());
                                constraintWidget.f32271a = true;
                            }
                            dimensionBehaviour = dimensionBehaviour5;
                        } else {
                            dimensionBehaviour5 = dimensionBehaviour;
                            ConstraintAnchor[] constraintAnchorArr2 = constraintWidget.Y;
                            if (constraintAnchorArr2[2].f32257f == null || constraintAnchorArr2[i3].f32257f == null) {
                                l(constraintWidget, dimensionBehaviour4, 0, dimensionBehaviour5, 0);
                                constraintWidget.f32279e.f32487e.d(constraintWidget.a0());
                                constraintWidget.f32281f.f32487e.d(constraintWidget.z());
                                constraintWidget.f32271a = true;
                            }
                            dimensionBehaviour = dimensionBehaviour5;
                        }
                    }
                    if (dimensionBehaviour3 == dimensionBehaviour2 && dimensionBehaviour == dimensionBehaviour2) {
                        if (i5 == 1 || i6 == 1) {
                            ConstraintWidget.DimensionBehaviour dimensionBehaviour20 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
                            l(constraintWidget, dimensionBehaviour20, 0, dimensionBehaviour20, 0);
                            constraintWidget.f32279e.f32487e.f32452m = constraintWidget.a0();
                            constraintWidget.f32281f.f32487e.f32452m = constraintWidget.z();
                        } else if (i6 == 2 && i5 == 2) {
                            ConstraintWidget.DimensionBehaviour[] dimensionBehaviourArr2 = constraintWidgetContainer.f32274b0;
                            ConstraintWidget.DimensionBehaviour dimensionBehaviour21 = dimensionBehaviourArr2[c4];
                            ConstraintWidget.DimensionBehaviour dimensionBehaviour22 = ConstraintWidget.DimensionBehaviour.FIXED;
                            if (dimensionBehaviour21 == dimensionBehaviour22 && dimensionBehaviourArr2[1] == dimensionBehaviour22) {
                                l(constraintWidget, dimensionBehaviour22, (int) ((constraintWidget.B * constraintWidgetContainer.a0()) + f4), dimensionBehaviour22, (int) ((constraintWidget.E * constraintWidgetContainer.z()) + f4));
                                constraintWidget.f32279e.f32487e.d(constraintWidget.a0());
                                constraintWidget.f32281f.f32487e.d(constraintWidget.z());
                                constraintWidget.f32271a = true;
                            }
                        }
                    }
                }
                c3 = c4;
            }
        }
        return c3;
    }

    private int e(ConstraintWidgetContainer constraintWidgetContainer, int i3) {
        int size = this.f32430i.size();
        long jMax = 0;
        for (int i4 = 0; i4 < size; i4++) {
            jMax = Math.max(jMax, ((RunGroup) this.f32430i.get(i4)).b(constraintWidgetContainer, i3));
        }
        return (int) jMax;
    }

    private void i(WidgetRun widgetRun, int i3, ArrayList arrayList) {
        for (Dependency dependency : widgetRun.f32490h.f32441k) {
            if (dependency instanceof DependencyNode) {
                a((DependencyNode) dependency, i3, 0, widgetRun.f32491i, arrayList, null);
            } else if (dependency instanceof WidgetRun) {
                a(((WidgetRun) dependency).f32490h, i3, 0, widgetRun.f32491i, arrayList, null);
            }
        }
        for (Dependency dependency2 : widgetRun.f32491i.f32441k) {
            if (dependency2 instanceof DependencyNode) {
                a((DependencyNode) dependency2, i3, 1, widgetRun.f32490h, arrayList, null);
            } else if (dependency2 instanceof WidgetRun) {
                a(((WidgetRun) dependency2).f32491i, i3, 1, widgetRun.f32490h, arrayList, null);
            }
        }
        int i4 = i3;
        if (i4 == 1) {
            for (Dependency dependency3 : ((VerticalWidgetRun) widgetRun).f32466k.f32441k) {
                if (dependency3 instanceof DependencyNode) {
                    a((DependencyNode) dependency3, i4, 2, null, arrayList, null);
                }
                i4 = i3;
            }
        }
    }

    private void l(ConstraintWidget constraintWidget, ConstraintWidget.DimensionBehaviour dimensionBehaviour, int i3, ConstraintWidget.DimensionBehaviour dimensionBehaviour2, int i4) {
        BasicMeasure.Measure measure = this.f32429h;
        measure.f32410a = dimensionBehaviour;
        measure.f32411b = dimensionBehaviour2;
        measure.f32412c = i3;
        measure.f32413d = i4;
        this.f32428g.b(constraintWidget, measure);
        constraintWidget.r1(this.f32429h.f32414e);
        constraintWidget.S0(this.f32429h.f32415f);
        constraintWidget.R0(this.f32429h.f32417h);
        constraintWidget.H0(this.f32429h.f32416g);
    }

    public void c() {
        d(this.f32426e);
        this.f32430i.clear();
        RunGroup.f32458h = 0;
        i(this.f32422a.f32279e, 0, this.f32430i);
        i(this.f32422a.f32281f, 1, this.f32430i);
        this.f32423b = false;
    }

    public void d(ArrayList arrayList) {
        arrayList.clear();
        this.f32425d.f32279e.f();
        this.f32425d.f32281f.f();
        arrayList.add(this.f32425d.f32279e);
        arrayList.add(this.f32425d.f32281f);
        ArrayList arrayList2 = this.f32425d.V0;
        int size = arrayList2.size();
        HashSet hashSet = null;
        int i3 = 0;
        int i4 = 0;
        while (i4 < size) {
            Object obj = arrayList2.get(i4);
            i4++;
            ConstraintWidget constraintWidget = (ConstraintWidget) obj;
            if (constraintWidget instanceof Guideline) {
                arrayList.add(new GuidelineReference(constraintWidget));
            } else {
                if (constraintWidget.m0()) {
                    if (constraintWidget.f32275c == null) {
                        constraintWidget.f32275c = new ChainRun(constraintWidget, 0);
                    }
                    if (hashSet == null) {
                        hashSet = new HashSet();
                    }
                    hashSet.add(constraintWidget.f32275c);
                } else {
                    arrayList.add(constraintWidget.f32279e);
                }
                if (constraintWidget.o0()) {
                    if (constraintWidget.f32277d == null) {
                        constraintWidget.f32277d = new ChainRun(constraintWidget, 1);
                    }
                    if (hashSet == null) {
                        hashSet = new HashSet();
                    }
                    hashSet.add(constraintWidget.f32277d);
                } else {
                    arrayList.add(constraintWidget.f32281f);
                }
                if (constraintWidget instanceof HelperWidget) {
                    arrayList.add(new HelperReferences(constraintWidget));
                }
            }
        }
        if (hashSet != null) {
            arrayList.addAll(hashSet);
        }
        int size2 = arrayList.size();
        int i5 = 0;
        while (i5 < size2) {
            Object obj2 = arrayList.get(i5);
            i5++;
            ((WidgetRun) obj2).f();
        }
        int size3 = arrayList.size();
        while (i3 < size3) {
            Object obj3 = arrayList.get(i3);
            i3++;
            WidgetRun widgetRun = (WidgetRun) obj3;
            if (widgetRun.f32484b != this.f32425d) {
                widgetRun.d();
            }
        }
    }

    public boolean f(boolean z2) {
        boolean z3;
        boolean z4 = false;
        if (this.f32423b || this.f32424c) {
            ArrayList arrayList = this.f32422a.V0;
            int size = arrayList.size();
            int i3 = 0;
            while (i3 < size) {
                Object obj = arrayList.get(i3);
                i3++;
                ConstraintWidget constraintWidget = (ConstraintWidget) obj;
                constraintWidget.p();
                constraintWidget.f32271a = false;
                constraintWidget.f32279e.r();
                constraintWidget.f32281f.q();
            }
            this.f32422a.p();
            ConstraintWidgetContainer constraintWidgetContainer = this.f32422a;
            constraintWidgetContainer.f32271a = false;
            constraintWidgetContainer.f32279e.r();
            this.f32422a.f32281f.q();
            this.f32424c = false;
        }
        if (b(this.f32425d)) {
            return false;
        }
        this.f32422a.t1(0);
        this.f32422a.u1(0);
        ConstraintWidget.DimensionBehaviour dimensionBehaviourW = this.f32422a.w(0);
        ConstraintWidget.DimensionBehaviour dimensionBehaviourW2 = this.f32422a.w(1);
        if (this.f32423b) {
            c();
        }
        int iB0 = this.f32422a.b0();
        int iC0 = this.f32422a.c0();
        this.f32422a.f32279e.f32490h.d(iB0);
        this.f32422a.f32281f.f32490h.d(iC0);
        m();
        ConstraintWidget.DimensionBehaviour dimensionBehaviour = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        if (dimensionBehaviourW == dimensionBehaviour || dimensionBehaviourW2 == dimensionBehaviour) {
            if (z2) {
                ArrayList arrayList2 = this.f32426e;
                int size2 = arrayList2.size();
                int i4 = 0;
                while (true) {
                    if (i4 >= size2) {
                        break;
                    }
                    Object obj2 = arrayList2.get(i4);
                    i4++;
                    if (!((WidgetRun) obj2).m()) {
                        z2 = false;
                        break;
                    }
                }
            }
            if (z2 && dimensionBehaviourW == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {
                this.f32422a.W0(ConstraintWidget.DimensionBehaviour.FIXED);
                ConstraintWidgetContainer constraintWidgetContainer2 = this.f32422a;
                constraintWidgetContainer2.r1(e(constraintWidgetContainer2, 0));
                ConstraintWidgetContainer constraintWidgetContainer3 = this.f32422a;
                constraintWidgetContainer3.f32279e.f32487e.d(constraintWidgetContainer3.a0());
            }
            if (z2 && dimensionBehaviourW2 == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {
                this.f32422a.n1(ConstraintWidget.DimensionBehaviour.FIXED);
                ConstraintWidgetContainer constraintWidgetContainer4 = this.f32422a;
                constraintWidgetContainer4.S0(e(constraintWidgetContainer4, 1));
                ConstraintWidgetContainer constraintWidgetContainer5 = this.f32422a;
                constraintWidgetContainer5.f32281f.f32487e.d(constraintWidgetContainer5.z());
            }
        }
        ConstraintWidgetContainer constraintWidgetContainer6 = this.f32422a;
        ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = constraintWidgetContainer6.f32274b0[0];
        ConstraintWidget.DimensionBehaviour dimensionBehaviour3 = ConstraintWidget.DimensionBehaviour.FIXED;
        if (dimensionBehaviour2 == dimensionBehaviour3 || dimensionBehaviour2 == ConstraintWidget.DimensionBehaviour.MATCH_PARENT) {
            int iA0 = constraintWidgetContainer6.a0() + iB0;
            this.f32422a.f32279e.f32491i.d(iA0);
            this.f32422a.f32279e.f32487e.d(iA0 - iB0);
            m();
            ConstraintWidgetContainer constraintWidgetContainer7 = this.f32422a;
            ConstraintWidget.DimensionBehaviour dimensionBehaviour4 = constraintWidgetContainer7.f32274b0[1];
            if (dimensionBehaviour4 == dimensionBehaviour3 || dimensionBehaviour4 == ConstraintWidget.DimensionBehaviour.MATCH_PARENT) {
                int iZ = constraintWidgetContainer7.z() + iC0;
                this.f32422a.f32281f.f32491i.d(iZ);
                this.f32422a.f32281f.f32487e.d(iZ - iC0);
            }
            m();
            z3 = true;
        } else {
            z3 = false;
        }
        ArrayList arrayList3 = this.f32426e;
        int size3 = arrayList3.size();
        int i5 = 0;
        while (i5 < size3) {
            Object obj3 = arrayList3.get(i5);
            i5++;
            WidgetRun widgetRun = (WidgetRun) obj3;
            if (widgetRun.f32484b != this.f32422a || widgetRun.f32489g) {
                widgetRun.e();
            }
        }
        ArrayList arrayList4 = this.f32426e;
        int size4 = arrayList4.size();
        int i6 = 0;
        while (true) {
            if (i6 >= size4) {
                z4 = true;
                break;
            }
            Object obj4 = arrayList4.get(i6);
            i6++;
            WidgetRun widgetRun2 = (WidgetRun) obj4;
            if (z3 || widgetRun2.f32484b != this.f32422a) {
                if (!widgetRun2.f32490h.f32440j || ((!widgetRun2.f32491i.f32440j && !(widgetRun2 instanceof GuidelineReference)) || (!widgetRun2.f32487e.f32440j && !(widgetRun2 instanceof ChainRun) && !(widgetRun2 instanceof GuidelineReference)))) {
                    break;
                }
            }
        }
        this.f32422a.W0(dimensionBehaviourW);
        this.f32422a.n1(dimensionBehaviourW2);
        return z4;
    }

    public boolean g(boolean z2) {
        if (this.f32423b) {
            ArrayList arrayList = this.f32422a.V0;
            int size = arrayList.size();
            int i3 = 0;
            while (i3 < size) {
                Object obj = arrayList.get(i3);
                i3++;
                ConstraintWidget constraintWidget = (ConstraintWidget) obj;
                constraintWidget.p();
                constraintWidget.f32271a = false;
                HorizontalWidgetRun horizontalWidgetRun = constraintWidget.f32279e;
                horizontalWidgetRun.f32487e.f32440j = false;
                horizontalWidgetRun.f32489g = false;
                horizontalWidgetRun.r();
                VerticalWidgetRun verticalWidgetRun = constraintWidget.f32281f;
                verticalWidgetRun.f32487e.f32440j = false;
                verticalWidgetRun.f32489g = false;
                verticalWidgetRun.q();
            }
            this.f32422a.p();
            ConstraintWidgetContainer constraintWidgetContainer = this.f32422a;
            constraintWidgetContainer.f32271a = false;
            HorizontalWidgetRun horizontalWidgetRun2 = constraintWidgetContainer.f32279e;
            horizontalWidgetRun2.f32487e.f32440j = false;
            horizontalWidgetRun2.f32489g = false;
            horizontalWidgetRun2.r();
            VerticalWidgetRun verticalWidgetRun2 = this.f32422a.f32281f;
            verticalWidgetRun2.f32487e.f32440j = false;
            verticalWidgetRun2.f32489g = false;
            verticalWidgetRun2.q();
            c();
        }
        if (b(this.f32425d)) {
            return false;
        }
        this.f32422a.t1(0);
        this.f32422a.u1(0);
        this.f32422a.f32279e.f32490h.d(0);
        this.f32422a.f32281f.f32490h.d(0);
        return true;
    }

    public boolean h(boolean z2, int i3) {
        boolean z3;
        ConstraintWidget.DimensionBehaviour dimensionBehaviour;
        boolean z4 = false;
        ConstraintWidget.DimensionBehaviour dimensionBehaviourW = this.f32422a.w(0);
        ConstraintWidget.DimensionBehaviour dimensionBehaviourW2 = this.f32422a.w(1);
        int iB0 = this.f32422a.b0();
        int iC0 = this.f32422a.c0();
        if (z2 && (dimensionBehaviourW == (dimensionBehaviour = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) || dimensionBehaviourW2 == dimensionBehaviour)) {
            ArrayList arrayList = this.f32426e;
            int size = arrayList.size();
            int i4 = 0;
            while (true) {
                if (i4 >= size) {
                    break;
                }
                Object obj = arrayList.get(i4);
                i4++;
                WidgetRun widgetRun = (WidgetRun) obj;
                if (widgetRun.f32488f == i3 && !widgetRun.m()) {
                    z2 = false;
                    break;
                }
            }
            if (i3 == 0) {
                if (z2 && dimensionBehaviourW == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {
                    this.f32422a.W0(ConstraintWidget.DimensionBehaviour.FIXED);
                    ConstraintWidgetContainer constraintWidgetContainer = this.f32422a;
                    constraintWidgetContainer.r1(e(constraintWidgetContainer, 0));
                    ConstraintWidgetContainer constraintWidgetContainer2 = this.f32422a;
                    constraintWidgetContainer2.f32279e.f32487e.d(constraintWidgetContainer2.a0());
                }
            } else if (z2 && dimensionBehaviourW2 == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {
                this.f32422a.n1(ConstraintWidget.DimensionBehaviour.FIXED);
                ConstraintWidgetContainer constraintWidgetContainer3 = this.f32422a;
                constraintWidgetContainer3.S0(e(constraintWidgetContainer3, 1));
                ConstraintWidgetContainer constraintWidgetContainer4 = this.f32422a;
                constraintWidgetContainer4.f32281f.f32487e.d(constraintWidgetContainer4.z());
            }
        }
        if (i3 == 0) {
            ConstraintWidgetContainer constraintWidgetContainer5 = this.f32422a;
            ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = constraintWidgetContainer5.f32274b0[0];
            if (dimensionBehaviour2 == ConstraintWidget.DimensionBehaviour.FIXED || dimensionBehaviour2 == ConstraintWidget.DimensionBehaviour.MATCH_PARENT) {
                int iA0 = constraintWidgetContainer5.a0() + iB0;
                this.f32422a.f32279e.f32491i.d(iA0);
                this.f32422a.f32279e.f32487e.d(iA0 - iB0);
                z3 = true;
            }
            z3 = false;
        } else {
            ConstraintWidgetContainer constraintWidgetContainer6 = this.f32422a;
            ConstraintWidget.DimensionBehaviour dimensionBehaviour3 = constraintWidgetContainer6.f32274b0[1];
            if (dimensionBehaviour3 == ConstraintWidget.DimensionBehaviour.FIXED || dimensionBehaviour3 == ConstraintWidget.DimensionBehaviour.MATCH_PARENT) {
                int iZ = constraintWidgetContainer6.z() + iC0;
                this.f32422a.f32281f.f32491i.d(iZ);
                this.f32422a.f32281f.f32487e.d(iZ - iC0);
                z3 = true;
            }
            z3 = false;
        }
        m();
        ArrayList arrayList2 = this.f32426e;
        int size2 = arrayList2.size();
        int i5 = 0;
        while (i5 < size2) {
            Object obj2 = arrayList2.get(i5);
            i5++;
            WidgetRun widgetRun2 = (WidgetRun) obj2;
            if (widgetRun2.f32488f == i3 && (widgetRun2.f32484b != this.f32422a || widgetRun2.f32489g)) {
                widgetRun2.e();
            }
        }
        ArrayList arrayList3 = this.f32426e;
        int size3 = arrayList3.size();
        int i6 = 0;
        while (true) {
            if (i6 >= size3) {
                z4 = true;
                break;
            }
            Object obj3 = arrayList3.get(i6);
            i6++;
            WidgetRun widgetRun3 = (WidgetRun) obj3;
            if (widgetRun3.f32488f == i3 && (z3 || widgetRun3.f32484b != this.f32422a)) {
                if (!widgetRun3.f32490h.f32440j || !widgetRun3.f32491i.f32440j || (!(widgetRun3 instanceof ChainRun) && !widgetRun3.f32487e.f32440j)) {
                    break;
                }
            }
        }
        this.f32422a.W0(dimensionBehaviourW);
        this.f32422a.n1(dimensionBehaviourW2);
        return z4;
    }

    public void j() {
        this.f32423b = true;
    }

    public void k() {
        this.f32424c = true;
    }

    public void m() {
        DimensionDependency dimensionDependency;
        ArrayList arrayList = this.f32422a.V0;
        int size = arrayList.size();
        int i3 = 0;
        while (i3 < size) {
            Object obj = arrayList.get(i3);
            i3++;
            ConstraintWidget constraintWidget = (ConstraintWidget) obj;
            if (!constraintWidget.f32271a) {
                ConstraintWidget.DimensionBehaviour[] dimensionBehaviourArr = constraintWidget.f32274b0;
                ConstraintWidget.DimensionBehaviour dimensionBehaviour = dimensionBehaviourArr[0];
                ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = dimensionBehaviourArr[1];
                int i4 = constraintWidget.f32315w;
                int i5 = constraintWidget.f32317x;
                ConstraintWidget.DimensionBehaviour dimensionBehaviour3 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
                boolean z2 = dimensionBehaviour == dimensionBehaviour3 || (dimensionBehaviour == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && i4 == 1);
                boolean z3 = dimensionBehaviour2 == dimensionBehaviour3 || (dimensionBehaviour2 == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && i5 == 1);
                DimensionDependency dimensionDependency2 = constraintWidget.f32279e.f32487e;
                boolean z4 = dimensionDependency2.f32440j;
                DimensionDependency dimensionDependency3 = constraintWidget.f32281f.f32487e;
                boolean z5 = dimensionDependency3.f32440j;
                if (z4 && z5) {
                    ConstraintWidget.DimensionBehaviour dimensionBehaviour4 = ConstraintWidget.DimensionBehaviour.FIXED;
                    l(constraintWidget, dimensionBehaviour4, dimensionDependency2.f32437g, dimensionBehaviour4, dimensionDependency3.f32437g);
                    constraintWidget.f32271a = true;
                } else if (z4 && z3) {
                    l(constraintWidget, ConstraintWidget.DimensionBehaviour.FIXED, dimensionDependency2.f32437g, dimensionBehaviour3, dimensionDependency3.f32437g);
                    if (dimensionBehaviour2 == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                        constraintWidget.f32281f.f32487e.f32452m = constraintWidget.z();
                    } else {
                        constraintWidget.f32281f.f32487e.d(constraintWidget.z());
                        constraintWidget.f32271a = true;
                    }
                } else if (z5 && z2) {
                    l(constraintWidget, dimensionBehaviour3, dimensionDependency2.f32437g, ConstraintWidget.DimensionBehaviour.FIXED, dimensionDependency3.f32437g);
                    if (dimensionBehaviour == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                        constraintWidget.f32279e.f32487e.f32452m = constraintWidget.a0();
                    } else {
                        constraintWidget.f32279e.f32487e.d(constraintWidget.a0());
                        constraintWidget.f32271a = true;
                    }
                }
                if (constraintWidget.f32271a && (dimensionDependency = constraintWidget.f32281f.f32467l) != null) {
                    dimensionDependency.d(constraintWidget.r());
                }
            }
        }
    }

    public void n(BasicMeasure.Measurer measurer) {
        this.f32428g = measurer;
    }
}
