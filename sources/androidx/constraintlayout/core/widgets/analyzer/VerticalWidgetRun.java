package androidx.constraintlayout.core.widgets.analyzer;

import androidx.constraintlayout.core.widgets.ConstraintAnchor;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.core.widgets.Helper;
import androidx.constraintlayout.core.widgets.analyzer.DependencyNode;
import androidx.constraintlayout.core.widgets.analyzer.WidgetRun;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public class VerticalWidgetRun extends WidgetRun {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public DependencyNode f32466k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    DimensionDependency f32467l;

    /* JADX INFO: renamed from: androidx.constraintlayout.core.widgets.analyzer.VerticalWidgetRun$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static /* synthetic */ class AnonymousClass1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f32468a;

        static {
            int[] iArr = new int[WidgetRun.RunType.values().length];
            f32468a = iArr;
            try {
                iArr[WidgetRun.RunType.START.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f32468a[WidgetRun.RunType.END.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f32468a[WidgetRun.RunType.CENTER.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public VerticalWidgetRun(ConstraintWidget constraintWidget) {
        super(constraintWidget);
        DependencyNode dependencyNode = new DependencyNode(this);
        this.f32466k = dependencyNode;
        this.f32467l = null;
        this.f32490h.f32435e = DependencyNode.Type.TOP;
        this.f32491i.f32435e = DependencyNode.Type.BOTTOM;
        dependencyNode.f32435e = DependencyNode.Type.BASELINE;
        this.f32488f = 1;
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun, androidx.constraintlayout.core.widgets.analyzer.Dependency
    public void a(Dependency dependency) {
        float f3;
        float fX;
        float fX2;
        int i3;
        int i4 = AnonymousClass1.f32468a[this.f32492j.ordinal()];
        if (i4 == 1) {
            p(dependency);
        } else if (i4 == 2) {
            o(dependency);
        } else if (i4 == 3) {
            ConstraintWidget constraintWidget = this.f32484b;
            n(dependency, constraintWidget.R, constraintWidget.T, 1);
            return;
        }
        DimensionDependency dimensionDependency = this.f32487e;
        if (dimensionDependency.f32433c && !dimensionDependency.f32440j && this.f32486d == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
            ConstraintWidget constraintWidget2 = this.f32484b;
            int i5 = constraintWidget2.f32317x;
            if (i5 == 2) {
                ConstraintWidget constraintWidgetN = constraintWidget2.N();
                if (constraintWidgetN != null) {
                    if (constraintWidgetN.f32281f.f32487e.f32440j) {
                        this.f32487e.d((int) ((r7.f32437g * this.f32484b.E) + 0.5f));
                    }
                }
            } else if (i5 == 3 && constraintWidget2.f32279e.f32487e.f32440j) {
                int iY = constraintWidget2.y();
                if (iY == -1) {
                    ConstraintWidget constraintWidget3 = this.f32484b;
                    f3 = constraintWidget3.f32279e.f32487e.f32437g;
                    fX = constraintWidget3.x();
                } else if (iY == 0) {
                    fX2 = r7.f32279e.f32487e.f32437g * this.f32484b.x();
                    i3 = (int) (fX2 + 0.5f);
                    this.f32487e.d(i3);
                } else if (iY != 1) {
                    i3 = 0;
                    this.f32487e.d(i3);
                } else {
                    ConstraintWidget constraintWidget4 = this.f32484b;
                    f3 = constraintWidget4.f32279e.f32487e.f32437g;
                    fX = constraintWidget4.x();
                }
                fX2 = f3 / fX;
                i3 = (int) (fX2 + 0.5f);
                this.f32487e.d(i3);
            }
        }
        DependencyNode dependencyNode = this.f32490h;
        if (dependencyNode.f32433c) {
            DependencyNode dependencyNode2 = this.f32491i;
            if (dependencyNode2.f32433c) {
                if (dependencyNode.f32440j && dependencyNode2.f32440j && this.f32487e.f32440j) {
                    return;
                }
                if (!this.f32487e.f32440j && this.f32486d == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                    ConstraintWidget constraintWidget5 = this.f32484b;
                    if (constraintWidget5.f32315w == 0 && !constraintWidget5.o0()) {
                        DependencyNode dependencyNode3 = (DependencyNode) this.f32490h.f32442l.get(0);
                        DependencyNode dependencyNode4 = (DependencyNode) this.f32491i.f32442l.get(0);
                        int i6 = dependencyNode3.f32437g;
                        DependencyNode dependencyNode5 = this.f32490h;
                        int i7 = i6 + dependencyNode5.f32436f;
                        int i8 = dependencyNode4.f32437g + this.f32491i.f32436f;
                        dependencyNode5.d(i7);
                        this.f32491i.d(i8);
                        this.f32487e.d(i8 - i7);
                        return;
                    }
                }
                if (!this.f32487e.f32440j && this.f32486d == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && this.f32483a == 1 && this.f32490h.f32442l.size() > 0 && this.f32491i.f32442l.size() > 0) {
                    DependencyNode dependencyNode6 = (DependencyNode) this.f32490h.f32442l.get(0);
                    int i9 = (((DependencyNode) this.f32491i.f32442l.get(0)).f32437g + this.f32491i.f32436f) - (dependencyNode6.f32437g + this.f32490h.f32436f);
                    DimensionDependency dimensionDependency2 = this.f32487e;
                    int i10 = dimensionDependency2.f32452m;
                    if (i9 < i10) {
                        dimensionDependency2.d(i9);
                    } else {
                        dimensionDependency2.d(i10);
                    }
                }
                if (this.f32487e.f32440j && this.f32490h.f32442l.size() > 0 && this.f32491i.f32442l.size() > 0) {
                    DependencyNode dependencyNode7 = (DependencyNode) this.f32490h.f32442l.get(0);
                    DependencyNode dependencyNode8 = (DependencyNode) this.f32491i.f32442l.get(0);
                    int i11 = dependencyNode7.f32437g + this.f32490h.f32436f;
                    int i12 = dependencyNode8.f32437g + this.f32491i.f32436f;
                    float fV = this.f32484b.V();
                    if (dependencyNode7 == dependencyNode8) {
                        i11 = dependencyNode7.f32437g;
                        i12 = dependencyNode8.f32437g;
                        fV = 0.5f;
                    }
                    this.f32490h.d((int) (i11 + 0.5f + (((i12 - i11) - this.f32487e.f32437g) * fV)));
                    this.f32491i.d(this.f32490h.f32437g + this.f32487e.f32437g);
                }
            }
        }
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    void d() {
        ConstraintWidget constraintWidgetN;
        ConstraintWidget constraintWidgetN2;
        ConstraintWidget constraintWidget = this.f32484b;
        if (constraintWidget.f32271a) {
            this.f32487e.d(constraintWidget.z());
        }
        if (!this.f32487e.f32440j) {
            this.f32486d = this.f32484b.X();
            if (this.f32484b.d0()) {
                this.f32467l = new BaselineDimensionDependency(this);
            }
            ConstraintWidget.DimensionBehaviour dimensionBehaviour = this.f32486d;
            if (dimensionBehaviour != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                if (dimensionBehaviour == ConstraintWidget.DimensionBehaviour.MATCH_PARENT && (constraintWidgetN2 = this.f32484b.N()) != null && constraintWidgetN2.X() == ConstraintWidget.DimensionBehaviour.FIXED) {
                    int iZ = (constraintWidgetN2.z() - this.f32484b.R.f()) - this.f32484b.T.f();
                    b(this.f32490h, constraintWidgetN2.f32281f.f32490h, this.f32484b.R.f());
                    b(this.f32491i, constraintWidgetN2.f32281f.f32491i, -this.f32484b.T.f());
                    this.f32487e.d(iZ);
                    return;
                }
                if (this.f32486d == ConstraintWidget.DimensionBehaviour.FIXED) {
                    this.f32487e.d(this.f32484b.z());
                }
            }
        } else if (this.f32486d == ConstraintWidget.DimensionBehaviour.MATCH_PARENT && (constraintWidgetN = this.f32484b.N()) != null && constraintWidgetN.X() == ConstraintWidget.DimensionBehaviour.FIXED) {
            b(this.f32490h, constraintWidgetN.f32281f.f32490h, this.f32484b.R.f());
            b(this.f32491i, constraintWidgetN.f32281f.f32491i, -this.f32484b.T.f());
            return;
        }
        DimensionDependency dimensionDependency = this.f32487e;
        boolean z2 = dimensionDependency.f32440j;
        if (z2) {
            ConstraintWidget constraintWidget2 = this.f32484b;
            if (constraintWidget2.f32271a) {
                ConstraintAnchor[] constraintAnchorArr = constraintWidget2.Y;
                ConstraintAnchor constraintAnchor = constraintAnchorArr[2];
                ConstraintAnchor constraintAnchor2 = constraintAnchor.f32257f;
                if (constraintAnchor2 != null && constraintAnchorArr[3].f32257f != null) {
                    if (constraintWidget2.o0()) {
                        this.f32490h.f32436f = this.f32484b.Y[2].f();
                        this.f32491i.f32436f = -this.f32484b.Y[3].f();
                    } else {
                        DependencyNode dependencyNodeH = h(this.f32484b.Y[2]);
                        if (dependencyNodeH != null) {
                            b(this.f32490h, dependencyNodeH, this.f32484b.Y[2].f());
                        }
                        DependencyNode dependencyNodeH2 = h(this.f32484b.Y[3]);
                        if (dependencyNodeH2 != null) {
                            b(this.f32491i, dependencyNodeH2, -this.f32484b.Y[3].f());
                        }
                        this.f32490h.f32432b = true;
                        this.f32491i.f32432b = true;
                    }
                    if (this.f32484b.d0()) {
                        b(this.f32466k, this.f32490h, this.f32484b.r());
                        return;
                    }
                    return;
                }
                if (constraintAnchor2 != null) {
                    DependencyNode dependencyNodeH3 = h(constraintAnchor);
                    if (dependencyNodeH3 != null) {
                        b(this.f32490h, dependencyNodeH3, this.f32484b.Y[2].f());
                        b(this.f32491i, this.f32490h, this.f32487e.f32437g);
                        if (this.f32484b.d0()) {
                            b(this.f32466k, this.f32490h, this.f32484b.r());
                            return;
                        }
                        return;
                    }
                    return;
                }
                ConstraintAnchor constraintAnchor3 = constraintAnchorArr[3];
                if (constraintAnchor3.f32257f != null) {
                    DependencyNode dependencyNodeH4 = h(constraintAnchor3);
                    if (dependencyNodeH4 != null) {
                        b(this.f32491i, dependencyNodeH4, -this.f32484b.Y[3].f());
                        b(this.f32490h, this.f32491i, -this.f32487e.f32437g);
                    }
                    if (this.f32484b.d0()) {
                        b(this.f32466k, this.f32490h, this.f32484b.r());
                        return;
                    }
                    return;
                }
                ConstraintAnchor constraintAnchor4 = constraintAnchorArr[4];
                if (constraintAnchor4.f32257f != null) {
                    DependencyNode dependencyNodeH5 = h(constraintAnchor4);
                    if (dependencyNodeH5 != null) {
                        b(this.f32466k, dependencyNodeH5, 0);
                        b(this.f32490h, this.f32466k, -this.f32484b.r());
                        b(this.f32491i, this.f32490h, this.f32487e.f32437g);
                        return;
                    }
                    return;
                }
                if ((constraintWidget2 instanceof Helper) || constraintWidget2.N() == null || this.f32484b.q(ConstraintAnchor.Type.CENTER).f32257f != null) {
                    return;
                }
                b(this.f32490h, this.f32484b.N().f32281f.f32490h, this.f32484b.c0());
                b(this.f32491i, this.f32490h, this.f32487e.f32437g);
                if (this.f32484b.d0()) {
                    b(this.f32466k, this.f32490h, this.f32484b.r());
                    return;
                }
                return;
            }
        }
        if (z2 || this.f32486d != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
            dimensionDependency.b(this);
        } else {
            ConstraintWidget constraintWidget3 = this.f32484b;
            int i3 = constraintWidget3.f32317x;
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
            } else if (i3 == 3 && !constraintWidget3.o0()) {
                ConstraintWidget constraintWidget4 = this.f32484b;
                if (constraintWidget4.f32315w != 3) {
                    DimensionDependency dimensionDependency4 = constraintWidget4.f32279e.f32487e;
                    this.f32487e.f32442l.add(dimensionDependency4);
                    dimensionDependency4.f32441k.add(this.f32487e);
                    DimensionDependency dimensionDependency5 = this.f32487e;
                    dimensionDependency5.f32432b = true;
                    dimensionDependency5.f32441k.add(this.f32490h);
                    this.f32487e.f32441k.add(this.f32491i);
                }
            }
        }
        ConstraintWidget constraintWidget5 = this.f32484b;
        ConstraintAnchor[] constraintAnchorArr2 = constraintWidget5.Y;
        ConstraintAnchor constraintAnchor5 = constraintAnchorArr2[2];
        ConstraintAnchor constraintAnchor6 = constraintAnchor5.f32257f;
        if (constraintAnchor6 != null && constraintAnchorArr2[3].f32257f != null) {
            if (constraintWidget5.o0()) {
                this.f32490h.f32436f = this.f32484b.Y[2].f();
                this.f32491i.f32436f = -this.f32484b.Y[3].f();
            } else {
                DependencyNode dependencyNodeH6 = h(this.f32484b.Y[2]);
                DependencyNode dependencyNodeH7 = h(this.f32484b.Y[3]);
                if (dependencyNodeH6 != null) {
                    dependencyNodeH6.b(this);
                }
                if (dependencyNodeH7 != null) {
                    dependencyNodeH7.b(this);
                }
                this.f32492j = WidgetRun.RunType.CENTER;
            }
            if (this.f32484b.d0()) {
                c(this.f32466k, this.f32490h, 1, this.f32467l);
            }
        } else if (constraintAnchor6 != null) {
            DependencyNode dependencyNodeH8 = h(constraintAnchor5);
            if (dependencyNodeH8 != null) {
                b(this.f32490h, dependencyNodeH8, this.f32484b.Y[2].f());
                c(this.f32491i, this.f32490h, 1, this.f32487e);
                if (this.f32484b.d0()) {
                    c(this.f32466k, this.f32490h, 1, this.f32467l);
                }
                ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = this.f32486d;
                ConstraintWidget.DimensionBehaviour dimensionBehaviour3 = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
                if (dimensionBehaviour2 == dimensionBehaviour3 && this.f32484b.x() > 0.0f) {
                    HorizontalWidgetRun horizontalWidgetRun = this.f32484b.f32279e;
                    if (horizontalWidgetRun.f32486d == dimensionBehaviour3) {
                        horizontalWidgetRun.f32487e.f32441k.add(this.f32487e);
                        this.f32487e.f32442l.add(this.f32484b.f32279e.f32487e);
                        this.f32487e.f32431a = this;
                    }
                }
            }
        } else {
            ConstraintAnchor constraintAnchor7 = constraintAnchorArr2[3];
            if (constraintAnchor7.f32257f != null) {
                DependencyNode dependencyNodeH9 = h(constraintAnchor7);
                if (dependencyNodeH9 != null) {
                    b(this.f32491i, dependencyNodeH9, -this.f32484b.Y[3].f());
                    c(this.f32490h, this.f32491i, -1, this.f32487e);
                    if (this.f32484b.d0()) {
                        c(this.f32466k, this.f32490h, 1, this.f32467l);
                    }
                }
            } else {
                ConstraintAnchor constraintAnchor8 = constraintAnchorArr2[4];
                if (constraintAnchor8.f32257f != null) {
                    DependencyNode dependencyNodeH10 = h(constraintAnchor8);
                    if (dependencyNodeH10 != null) {
                        b(this.f32466k, dependencyNodeH10, 0);
                        c(this.f32490h, this.f32466k, -1, this.f32467l);
                        c(this.f32491i, this.f32490h, 1, this.f32487e);
                    }
                } else if (!(constraintWidget5 instanceof Helper) && constraintWidget5.N() != null) {
                    b(this.f32490h, this.f32484b.N().f32281f.f32490h, this.f32484b.c0());
                    c(this.f32491i, this.f32490h, 1, this.f32487e);
                    if (this.f32484b.d0()) {
                        c(this.f32466k, this.f32490h, 1, this.f32467l);
                    }
                    ConstraintWidget.DimensionBehaviour dimensionBehaviour4 = this.f32486d;
                    ConstraintWidget.DimensionBehaviour dimensionBehaviour5 = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
                    if (dimensionBehaviour4 == dimensionBehaviour5 && this.f32484b.x() > 0.0f) {
                        HorizontalWidgetRun horizontalWidgetRun2 = this.f32484b.f32279e;
                        if (horizontalWidgetRun2.f32486d == dimensionBehaviour5) {
                            horizontalWidgetRun2.f32487e.f32441k.add(this.f32487e);
                            this.f32487e.f32442l.add(this.f32484b.f32279e.f32487e);
                            this.f32487e.f32431a = this;
                        }
                    }
                }
            }
        }
        if (this.f32487e.f32442l.size() == 0) {
            this.f32487e.f32433c = true;
        }
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    public void e() {
        DependencyNode dependencyNode = this.f32490h;
        if (dependencyNode.f32440j) {
            this.f32484b.u1(dependencyNode.f32437g);
        }
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    void f() {
        this.f32485c = null;
        this.f32490h.c();
        this.f32491i.c();
        this.f32466k.c();
        this.f32487e.c();
        this.f32489g = false;
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    boolean m() {
        return this.f32486d != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT || this.f32484b.f32317x == 0;
    }

    void q() {
        this.f32489g = false;
        this.f32490h.c();
        this.f32490h.f32440j = false;
        this.f32491i.c();
        this.f32491i.f32440j = false;
        this.f32466k.c();
        this.f32466k.f32440j = false;
        this.f32487e.f32440j = false;
    }

    public String toString() {
        return "VerticalRun " + this.f32484b.v();
    }
}
