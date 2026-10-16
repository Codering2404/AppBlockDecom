package androidx.constraintlayout.core.widgets.analyzer;

import androidx.constraintlayout.core.widgets.Barrier;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.core.widgets.analyzer.DependencyNode;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
class HelperReferences extends WidgetRun {
    HelperReferences(ConstraintWidget constraintWidget) {
        super(constraintWidget);
    }

    private void q(DependencyNode dependencyNode) {
        this.f32490h.f32441k.add(dependencyNode);
        dependencyNode.f32442l.add(this.f32490h);
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun, androidx.constraintlayout.core.widgets.analyzer.Dependency
    public void a(Dependency dependency) {
        Barrier barrier = (Barrier) this.f32484b;
        int iC1 = barrier.C1();
        Iterator it = this.f32490h.f32442l.iterator();
        int i3 = 0;
        int i4 = -1;
        while (it.hasNext()) {
            int i5 = ((DependencyNode) it.next()).f32437g;
            if (i4 == -1 || i5 < i4) {
                i4 = i5;
            }
            if (i3 < i5) {
                i3 = i5;
            }
        }
        if (iC1 == 0 || iC1 == 2) {
            this.f32490h.d(i4 + barrier.D1());
        } else {
            this.f32490h.d(i3 + barrier.D1());
        }
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    void d() {
        ConstraintWidget constraintWidget = this.f32484b;
        if (constraintWidget instanceof Barrier) {
            this.f32490h.f32432b = true;
            Barrier barrier = (Barrier) constraintWidget;
            int iC1 = barrier.C1();
            boolean zB1 = barrier.B1();
            int i3 = 0;
            if (iC1 == 0) {
                this.f32490h.f32435e = DependencyNode.Type.LEFT;
                while (i3 < barrier.W0) {
                    ConstraintWidget constraintWidget2 = barrier.V0[i3];
                    if (zB1 || constraintWidget2.Z() != 8) {
                        DependencyNode dependencyNode = constraintWidget2.f32279e.f32490h;
                        dependencyNode.f32441k.add(this.f32490h);
                        this.f32490h.f32442l.add(dependencyNode);
                    }
                    i3++;
                }
                q(this.f32484b.f32279e.f32490h);
                q(this.f32484b.f32279e.f32491i);
                return;
            }
            if (iC1 == 1) {
                this.f32490h.f32435e = DependencyNode.Type.RIGHT;
                while (i3 < barrier.W0) {
                    ConstraintWidget constraintWidget3 = barrier.V0[i3];
                    if (zB1 || constraintWidget3.Z() != 8) {
                        DependencyNode dependencyNode2 = constraintWidget3.f32279e.f32491i;
                        dependencyNode2.f32441k.add(this.f32490h);
                        this.f32490h.f32442l.add(dependencyNode2);
                    }
                    i3++;
                }
                q(this.f32484b.f32279e.f32490h);
                q(this.f32484b.f32279e.f32491i);
                return;
            }
            if (iC1 == 2) {
                this.f32490h.f32435e = DependencyNode.Type.TOP;
                while (i3 < barrier.W0) {
                    ConstraintWidget constraintWidget4 = barrier.V0[i3];
                    if (zB1 || constraintWidget4.Z() != 8) {
                        DependencyNode dependencyNode3 = constraintWidget4.f32281f.f32490h;
                        dependencyNode3.f32441k.add(this.f32490h);
                        this.f32490h.f32442l.add(dependencyNode3);
                    }
                    i3++;
                }
                q(this.f32484b.f32281f.f32490h);
                q(this.f32484b.f32281f.f32491i);
                return;
            }
            if (iC1 != 3) {
                return;
            }
            this.f32490h.f32435e = DependencyNode.Type.BOTTOM;
            while (i3 < barrier.W0) {
                ConstraintWidget constraintWidget5 = barrier.V0[i3];
                if (zB1 || constraintWidget5.Z() != 8) {
                    DependencyNode dependencyNode4 = constraintWidget5.f32281f.f32491i;
                    dependencyNode4.f32441k.add(this.f32490h);
                    this.f32490h.f32442l.add(dependencyNode4);
                }
                i3++;
            }
            q(this.f32484b.f32281f.f32490h);
            q(this.f32484b.f32281f.f32491i);
        }
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    public void e() {
        ConstraintWidget constraintWidget = this.f32484b;
        if (constraintWidget instanceof Barrier) {
            int iC1 = ((Barrier) constraintWidget).C1();
            if (iC1 == 0 || iC1 == 1) {
                this.f32484b.t1(this.f32490h.f32437g);
            } else {
                this.f32484b.u1(this.f32490h.f32437g);
            }
        }
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    void f() {
        this.f32485c = null;
        this.f32490h.c();
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    boolean m() {
        return false;
    }
}
