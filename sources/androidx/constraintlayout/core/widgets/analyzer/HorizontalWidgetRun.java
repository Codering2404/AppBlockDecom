package androidx.constraintlayout.core.widgets.analyzer;

import androidx.constraintlayout.core.widgets.ConstraintAnchor;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.core.widgets.Helper;
import androidx.constraintlayout.core.widgets.analyzer.DependencyNode;
import androidx.constraintlayout.core.widgets.analyzer.WidgetRun;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public class HorizontalWidgetRun extends WidgetRun {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static int[] f32456k = new int[2];

    /* JADX INFO: renamed from: androidx.constraintlayout.core.widgets.analyzer.HorizontalWidgetRun$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static /* synthetic */ class AnonymousClass1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f32457a;

        static {
            int[] iArr = new int[WidgetRun.RunType.values().length];
            f32457a = iArr;
            try {
                iArr[WidgetRun.RunType.START.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f32457a[WidgetRun.RunType.END.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f32457a[WidgetRun.RunType.CENTER.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public HorizontalWidgetRun(ConstraintWidget constraintWidget) {
        super(constraintWidget);
        this.f32490h.f32435e = DependencyNode.Type.LEFT;
        this.f32491i.f32435e = DependencyNode.Type.RIGHT;
        this.f32488f = 0;
    }

    private void q(int[] iArr, int i3, int i4, int i5, int i6, float f3, int i7) {
        int i8 = i4 - i3;
        int i9 = i6 - i5;
        if (i7 != -1) {
            if (i7 == 0) {
                iArr[0] = (int) ((i9 * f3) + 0.5f);
                iArr[1] = i9;
                return;
            } else {
                if (i7 != 1) {
                    return;
                }
                iArr[0] = i8;
                iArr[1] = (int) ((i8 * f3) + 0.5f);
                return;
            }
        }
        int i10 = (int) ((i9 * f3) + 0.5f);
        int i11 = (int) ((i8 / f3) + 0.5f);
        if (i10 <= i8) {
            iArr[0] = i10;
            iArr[1] = i9;
        } else if (i11 <= i9) {
            iArr[0] = i8;
            iArr[1] = i11;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:122:0x02ca  */
    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun, androidx.constraintlayout.core.widgets.analyzer.Dependency
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void a(androidx.constraintlayout.core.widgets.analyzer.Dependency r14) {
        /*
            Method dump skipped, instruction units count: 1067
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.widgets.analyzer.HorizontalWidgetRun.a(androidx.constraintlayout.core.widgets.analyzer.Dependency):void");
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    void d() {
        ConstraintWidget constraintWidgetN;
        ConstraintWidget constraintWidgetN2;
        ConstraintWidget constraintWidget = this.f32484b;
        if (constraintWidget.f32271a) {
            this.f32487e.d(constraintWidget.a0());
        }
        if (this.f32487e.f32440j) {
            ConstraintWidget.DimensionBehaviour dimensionBehaviour = this.f32486d;
            ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = ConstraintWidget.DimensionBehaviour.MATCH_PARENT;
            if (dimensionBehaviour == dimensionBehaviour2 && (constraintWidgetN = this.f32484b.N()) != null && (constraintWidgetN.C() == ConstraintWidget.DimensionBehaviour.FIXED || constraintWidgetN.C() == dimensionBehaviour2)) {
                b(this.f32490h, constraintWidgetN.f32279e.f32490h, this.f32484b.Q.f());
                b(this.f32491i, constraintWidgetN.f32279e.f32491i, -this.f32484b.S.f());
                return;
            }
        } else {
            ConstraintWidget.DimensionBehaviour dimensionBehaviourC = this.f32484b.C();
            this.f32486d = dimensionBehaviourC;
            if (dimensionBehaviourC != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                ConstraintWidget.DimensionBehaviour dimensionBehaviour3 = ConstraintWidget.DimensionBehaviour.MATCH_PARENT;
                if (dimensionBehaviourC == dimensionBehaviour3 && (constraintWidgetN2 = this.f32484b.N()) != null && (constraintWidgetN2.C() == ConstraintWidget.DimensionBehaviour.FIXED || constraintWidgetN2.C() == dimensionBehaviour3)) {
                    int iA0 = (constraintWidgetN2.a0() - this.f32484b.Q.f()) - this.f32484b.S.f();
                    b(this.f32490h, constraintWidgetN2.f32279e.f32490h, this.f32484b.Q.f());
                    b(this.f32491i, constraintWidgetN2.f32279e.f32491i, -this.f32484b.S.f());
                    this.f32487e.d(iA0);
                    return;
                }
                if (this.f32486d == ConstraintWidget.DimensionBehaviour.FIXED) {
                    this.f32487e.d(this.f32484b.a0());
                }
            }
        }
        DimensionDependency dimensionDependency = this.f32487e;
        if (dimensionDependency.f32440j) {
            ConstraintWidget constraintWidget2 = this.f32484b;
            if (constraintWidget2.f32271a) {
                ConstraintAnchor[] constraintAnchorArr = constraintWidget2.Y;
                ConstraintAnchor constraintAnchor = constraintAnchorArr[0];
                ConstraintAnchor constraintAnchor2 = constraintAnchor.f32257f;
                if (constraintAnchor2 != null && constraintAnchorArr[1].f32257f != null) {
                    if (constraintWidget2.m0()) {
                        this.f32490h.f32436f = this.f32484b.Y[0].f();
                        this.f32491i.f32436f = -this.f32484b.Y[1].f();
                        return;
                    }
                    DependencyNode dependencyNodeH = h(this.f32484b.Y[0]);
                    if (dependencyNodeH != null) {
                        b(this.f32490h, dependencyNodeH, this.f32484b.Y[0].f());
                    }
                    DependencyNode dependencyNodeH2 = h(this.f32484b.Y[1]);
                    if (dependencyNodeH2 != null) {
                        b(this.f32491i, dependencyNodeH2, -this.f32484b.Y[1].f());
                    }
                    this.f32490h.f32432b = true;
                    this.f32491i.f32432b = true;
                    return;
                }
                if (constraintAnchor2 != null) {
                    DependencyNode dependencyNodeH3 = h(constraintAnchor);
                    if (dependencyNodeH3 != null) {
                        b(this.f32490h, dependencyNodeH3, this.f32484b.Y[0].f());
                        b(this.f32491i, this.f32490h, this.f32487e.f32437g);
                        return;
                    }
                    return;
                }
                ConstraintAnchor constraintAnchor3 = constraintAnchorArr[1];
                if (constraintAnchor3.f32257f != null) {
                    DependencyNode dependencyNodeH4 = h(constraintAnchor3);
                    if (dependencyNodeH4 != null) {
                        b(this.f32491i, dependencyNodeH4, -this.f32484b.Y[1].f());
                        b(this.f32490h, this.f32491i, -this.f32487e.f32437g);
                        return;
                    }
                    return;
                }
                if ((constraintWidget2 instanceof Helper) || constraintWidget2.N() == null || this.f32484b.q(ConstraintAnchor.Type.CENTER).f32257f != null) {
                    return;
                }
                b(this.f32490h, this.f32484b.N().f32279e.f32490h, this.f32484b.b0());
                b(this.f32491i, this.f32490h, this.f32487e.f32437g);
                return;
            }
        }
        if (this.f32486d == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
            ConstraintWidget constraintWidget3 = this.f32484b;
            int i3 = constraintWidget3.f32315w;
            if (i3 == 2) {
                ConstraintWidget constraintWidgetN3 = constraintWidget3.N();
                if (constraintWidgetN3 != null) {
                    DimensionDependency dimensionDependency2 = constraintWidgetN3.f32281f.f32487e;
                    this.f32487e.f32442l.add(dimensionDependency2);
                    dimensionDependency2.f32441k.add(this.f32487e);
                    DimensionDependency dimensionDependency3 = this.f32487e;
                    dimensionDependency3.f32432b = true;
                    dimensionDependency3.f32441k.add(this.f32490h);
                    this.f32487e.f32441k.add(this.f32491i);
                }
            } else if (i3 == 3) {
                if (constraintWidget3.f32317x == 3) {
                    this.f32490h.f32431a = this;
                    this.f32491i.f32431a = this;
                    VerticalWidgetRun verticalWidgetRun = constraintWidget3.f32281f;
                    verticalWidgetRun.f32490h.f32431a = this;
                    verticalWidgetRun.f32491i.f32431a = this;
                    dimensionDependency.f32431a = this;
                    if (constraintWidget3.o0()) {
                        this.f32487e.f32442l.add(this.f32484b.f32281f.f32487e);
                        this.f32484b.f32281f.f32487e.f32441k.add(this.f32487e);
                        VerticalWidgetRun verticalWidgetRun2 = this.f32484b.f32281f;
                        verticalWidgetRun2.f32487e.f32431a = this;
                        this.f32487e.f32442l.add(verticalWidgetRun2.f32490h);
                        this.f32487e.f32442l.add(this.f32484b.f32281f.f32491i);
                        this.f32484b.f32281f.f32490h.f32441k.add(this.f32487e);
                        this.f32484b.f32281f.f32491i.f32441k.add(this.f32487e);
                    } else if (this.f32484b.m0()) {
                        this.f32484b.f32281f.f32487e.f32442l.add(this.f32487e);
                        this.f32487e.f32441k.add(this.f32484b.f32281f.f32487e);
                    } else {
                        this.f32484b.f32281f.f32487e.f32442l.add(this.f32487e);
                    }
                } else {
                    DimensionDependency dimensionDependency4 = constraintWidget3.f32281f.f32487e;
                    dimensionDependency.f32442l.add(dimensionDependency4);
                    dimensionDependency4.f32441k.add(this.f32487e);
                    this.f32484b.f32281f.f32490h.f32441k.add(this.f32487e);
                    this.f32484b.f32281f.f32491i.f32441k.add(this.f32487e);
                    DimensionDependency dimensionDependency5 = this.f32487e;
                    dimensionDependency5.f32432b = true;
                    dimensionDependency5.f32441k.add(this.f32490h);
                    this.f32487e.f32441k.add(this.f32491i);
                    this.f32490h.f32442l.add(this.f32487e);
                    this.f32491i.f32442l.add(this.f32487e);
                }
            }
        }
        ConstraintWidget constraintWidget4 = this.f32484b;
        ConstraintAnchor[] constraintAnchorArr2 = constraintWidget4.Y;
        ConstraintAnchor constraintAnchor4 = constraintAnchorArr2[0];
        ConstraintAnchor constraintAnchor5 = constraintAnchor4.f32257f;
        if (constraintAnchor5 != null && constraintAnchorArr2[1].f32257f != null) {
            if (constraintWidget4.m0()) {
                this.f32490h.f32436f = this.f32484b.Y[0].f();
                this.f32491i.f32436f = -this.f32484b.Y[1].f();
                return;
            }
            DependencyNode dependencyNodeH5 = h(this.f32484b.Y[0]);
            DependencyNode dependencyNodeH6 = h(this.f32484b.Y[1]);
            if (dependencyNodeH5 != null) {
                dependencyNodeH5.b(this);
            }
            if (dependencyNodeH6 != null) {
                dependencyNodeH6.b(this);
            }
            this.f32492j = WidgetRun.RunType.CENTER;
            return;
        }
        if (constraintAnchor5 != null) {
            DependencyNode dependencyNodeH7 = h(constraintAnchor4);
            if (dependencyNodeH7 != null) {
                b(this.f32490h, dependencyNodeH7, this.f32484b.Y[0].f());
                c(this.f32491i, this.f32490h, 1, this.f32487e);
                return;
            }
            return;
        }
        ConstraintAnchor constraintAnchor6 = constraintAnchorArr2[1];
        if (constraintAnchor6.f32257f != null) {
            DependencyNode dependencyNodeH8 = h(constraintAnchor6);
            if (dependencyNodeH8 != null) {
                b(this.f32491i, dependencyNodeH8, -this.f32484b.Y[1].f());
                c(this.f32490h, this.f32491i, -1, this.f32487e);
                return;
            }
            return;
        }
        if ((constraintWidget4 instanceof Helper) || constraintWidget4.N() == null) {
            return;
        }
        b(this.f32490h, this.f32484b.N().f32279e.f32490h, this.f32484b.b0());
        c(this.f32491i, this.f32490h, 1, this.f32487e);
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    public void e() {
        DependencyNode dependencyNode = this.f32490h;
        if (dependencyNode.f32440j) {
            this.f32484b.t1(dependencyNode.f32437g);
        }
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    void f() {
        this.f32485c = null;
        this.f32490h.c();
        this.f32491i.c();
        this.f32487e.c();
        this.f32489g = false;
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    boolean m() {
        return this.f32486d != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT || this.f32484b.f32315w == 0;
    }

    void r() {
        this.f32489g = false;
        this.f32490h.c();
        this.f32490h.f32440j = false;
        this.f32491i.c();
        this.f32491i.f32440j = false;
        this.f32487e.f32440j = false;
    }

    public String toString() {
        return "HorizontalRun " + this.f32484b.v();
    }
}
