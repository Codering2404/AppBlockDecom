package androidx.constraintlayout.core.widgets.analyzer;

import androidx.constraintlayout.core.widgets.ConstraintAnchor;
import androidx.constraintlayout.core.widgets.ConstraintWidget;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class WidgetRun implements Dependency {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f32483a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    ConstraintWidget f32484b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    RunGroup f32485c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected ConstraintWidget.DimensionBehaviour f32486d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    DimensionDependency f32487e = new DimensionDependency(this);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f32488f = 0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    boolean f32489g = false;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public DependencyNode f32490h = new DependencyNode(this);

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public DependencyNode f32491i = new DependencyNode(this);

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    protected RunType f32492j = RunType.NONE;

    /* JADX INFO: renamed from: androidx.constraintlayout.core.widgets.analyzer.WidgetRun$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static /* synthetic */ class AnonymousClass1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f32493a;

        static {
            int[] iArr = new int[ConstraintAnchor.Type.values().length];
            f32493a = iArr;
            try {
                iArr[ConstraintAnchor.Type.LEFT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f32493a[ConstraintAnchor.Type.RIGHT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f32493a[ConstraintAnchor.Type.TOP.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f32493a[ConstraintAnchor.Type.BASELINE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f32493a[ConstraintAnchor.Type.BOTTOM.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    enum RunType {
        NONE,
        START,
        END,
        CENTER
    }

    public WidgetRun(ConstraintWidget constraintWidget) {
        this.f32484b = constraintWidget;
    }

    private void l(int i3, int i4) {
        int i5 = this.f32483a;
        if (i5 == 0) {
            this.f32487e.d(g(i4, i3));
            return;
        }
        if (i5 == 1) {
            this.f32487e.d(Math.min(g(this.f32487e.f32452m, i3), i4));
            return;
        }
        if (i5 == 2) {
            ConstraintWidget constraintWidgetN = this.f32484b.N();
            if (constraintWidgetN != null) {
                if ((i3 == 0 ? constraintWidgetN.f32279e : constraintWidgetN.f32281f).f32487e.f32440j) {
                    this.f32487e.d(g((int) ((r9.f32437g * (i3 == 0 ? this.f32484b.B : this.f32484b.E)) + 0.5f), i3));
                    return;
                }
                return;
            }
            return;
        }
        if (i5 != 3) {
            return;
        }
        ConstraintWidget constraintWidget = this.f32484b;
        WidgetRun widgetRun = constraintWidget.f32279e;
        ConstraintWidget.DimensionBehaviour dimensionBehaviour = widgetRun.f32486d;
        ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
        if (dimensionBehaviour == dimensionBehaviour2 && widgetRun.f32483a == 3) {
            VerticalWidgetRun verticalWidgetRun = constraintWidget.f32281f;
            if (verticalWidgetRun.f32486d == dimensionBehaviour2 && verticalWidgetRun.f32483a == 3) {
                return;
            }
        }
        if (i3 == 0) {
            widgetRun = constraintWidget.f32281f;
        }
        if (widgetRun.f32487e.f32440j) {
            float fX = constraintWidget.x();
            this.f32487e.d(i3 == 1 ? (int) ((widgetRun.f32487e.f32437g / fX) + 0.5f) : (int) ((fX * widgetRun.f32487e.f32437g) + 0.5f));
        }
    }

    protected final void b(DependencyNode dependencyNode, DependencyNode dependencyNode2, int i3) {
        dependencyNode.f32442l.add(dependencyNode2);
        dependencyNode.f32436f = i3;
        dependencyNode2.f32441k.add(dependencyNode);
    }

    protected final void c(DependencyNode dependencyNode, DependencyNode dependencyNode2, int i3, DimensionDependency dimensionDependency) {
        dependencyNode.f32442l.add(dependencyNode2);
        dependencyNode.f32442l.add(this.f32487e);
        dependencyNode.f32438h = i3;
        dependencyNode.f32439i = dimensionDependency;
        dependencyNode2.f32441k.add(dependencyNode);
        dimensionDependency.f32441k.add(dependencyNode);
    }

    abstract void d();

    abstract void e();

    abstract void f();

    protected final int g(int i3, int i4) {
        if (i4 == 0) {
            ConstraintWidget constraintWidget = this.f32484b;
            int i5 = constraintWidget.A;
            int iMax = Math.max(constraintWidget.f32321z, i3);
            if (i5 > 0) {
                iMax = Math.min(i5, i3);
            }
            if (iMax != i3) {
                return iMax;
            }
        } else {
            ConstraintWidget constraintWidget2 = this.f32484b;
            int i6 = constraintWidget2.D;
            int iMax2 = Math.max(constraintWidget2.C, i3);
            if (i6 > 0) {
                iMax2 = Math.min(i6, i3);
            }
            if (iMax2 != i3) {
                return iMax2;
            }
        }
        return i3;
    }

    protected final DependencyNode h(ConstraintAnchor constraintAnchor) {
        ConstraintAnchor constraintAnchor2 = constraintAnchor.f32257f;
        if (constraintAnchor2 == null) {
            return null;
        }
        ConstraintWidget constraintWidget = constraintAnchor2.f32255d;
        int i3 = AnonymousClass1.f32493a[constraintAnchor2.f32256e.ordinal()];
        if (i3 == 1) {
            return constraintWidget.f32279e.f32490h;
        }
        if (i3 == 2) {
            return constraintWidget.f32279e.f32491i;
        }
        if (i3 == 3) {
            return constraintWidget.f32281f.f32490h;
        }
        if (i3 == 4) {
            return constraintWidget.f32281f.f32466k;
        }
        if (i3 != 5) {
            return null;
        }
        return constraintWidget.f32281f.f32491i;
    }

    protected final DependencyNode i(ConstraintAnchor constraintAnchor, int i3) {
        ConstraintAnchor constraintAnchor2 = constraintAnchor.f32257f;
        if (constraintAnchor2 == null) {
            return null;
        }
        ConstraintWidget constraintWidget = constraintAnchor2.f32255d;
        WidgetRun widgetRun = i3 == 0 ? constraintWidget.f32279e : constraintWidget.f32281f;
        int i4 = AnonymousClass1.f32493a[constraintAnchor2.f32256e.ordinal()];
        if (i4 != 1) {
            if (i4 != 2) {
                if (i4 != 3) {
                    if (i4 != 5) {
                        return null;
                    }
                }
            }
            return widgetRun.f32491i;
        }
        return widgetRun.f32490h;
    }

    public long j() {
        if (this.f32487e.f32440j) {
            return r0.f32437g;
        }
        return 0L;
    }

    public boolean k() {
        return this.f32489g;
    }

    abstract boolean m();

    protected void n(Dependency dependency, ConstraintAnchor constraintAnchor, ConstraintAnchor constraintAnchor2, int i3) {
        DependencyNode dependencyNodeH = h(constraintAnchor);
        DependencyNode dependencyNodeH2 = h(constraintAnchor2);
        if (dependencyNodeH.f32440j && dependencyNodeH2.f32440j) {
            int iF = dependencyNodeH.f32437g + constraintAnchor.f();
            int iF2 = dependencyNodeH2.f32437g - constraintAnchor2.f();
            int i4 = iF2 - iF;
            if (!this.f32487e.f32440j && this.f32486d == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                l(i3, i4);
            }
            DimensionDependency dimensionDependency = this.f32487e;
            if (dimensionDependency.f32440j) {
                if (dimensionDependency.f32437g == i4) {
                    this.f32490h.d(iF);
                    this.f32491i.d(iF2);
                    return;
                }
                float fA = i3 == 0 ? this.f32484b.A() : this.f32484b.V();
                if (dependencyNodeH == dependencyNodeH2) {
                    iF = dependencyNodeH.f32437g;
                    iF2 = dependencyNodeH2.f32437g;
                    fA = 0.5f;
                }
                this.f32490h.d((int) (iF + 0.5f + (((iF2 - iF) - this.f32487e.f32437g) * fA)));
                this.f32491i.d(this.f32490h.f32437g + this.f32487e.f32437g);
            }
        }
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.Dependency
    public void a(Dependency dependency) {
    }

    protected void o(Dependency dependency) {
    }

    protected void p(Dependency dependency) {
    }
}
