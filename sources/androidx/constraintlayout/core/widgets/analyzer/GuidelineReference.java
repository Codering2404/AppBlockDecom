package androidx.constraintlayout.core.widgets.analyzer;

import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.core.widgets.Guideline;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
class GuidelineReference extends WidgetRun {
    GuidelineReference(ConstraintWidget constraintWidget) {
        super(constraintWidget);
        constraintWidget.f32279e.f();
        constraintWidget.f32281f.f();
        this.f32488f = ((Guideline) constraintWidget).z1();
    }

    private void q(DependencyNode dependencyNode) {
        this.f32490h.f32441k.add(dependencyNode);
        dependencyNode.f32442l.add(this.f32490h);
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun, androidx.constraintlayout.core.widgets.analyzer.Dependency
    public void a(Dependency dependency) {
        DependencyNode dependencyNode = this.f32490h;
        if (dependencyNode.f32433c && !dependencyNode.f32440j) {
            this.f32490h.d((int) ((((DependencyNode) dependencyNode.f32442l.get(0)).f32437g * ((Guideline) this.f32484b).C1()) + 0.5f));
        }
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    void d() {
        Guideline guideline = (Guideline) this.f32484b;
        int iA1 = guideline.A1();
        int iB1 = guideline.B1();
        guideline.C1();
        if (guideline.z1() == 1) {
            if (iA1 != -1) {
                this.f32490h.f32442l.add(this.f32484b.f32276c0.f32279e.f32490h);
                this.f32484b.f32276c0.f32279e.f32490h.f32441k.add(this.f32490h);
                this.f32490h.f32436f = iA1;
            } else if (iB1 != -1) {
                this.f32490h.f32442l.add(this.f32484b.f32276c0.f32279e.f32491i);
                this.f32484b.f32276c0.f32279e.f32491i.f32441k.add(this.f32490h);
                this.f32490h.f32436f = -iB1;
            } else {
                DependencyNode dependencyNode = this.f32490h;
                dependencyNode.f32432b = true;
                dependencyNode.f32442l.add(this.f32484b.f32276c0.f32279e.f32491i);
                this.f32484b.f32276c0.f32279e.f32491i.f32441k.add(this.f32490h);
            }
            q(this.f32484b.f32279e.f32490h);
            q(this.f32484b.f32279e.f32491i);
            return;
        }
        if (iA1 != -1) {
            this.f32490h.f32442l.add(this.f32484b.f32276c0.f32281f.f32490h);
            this.f32484b.f32276c0.f32281f.f32490h.f32441k.add(this.f32490h);
            this.f32490h.f32436f = iA1;
        } else if (iB1 != -1) {
            this.f32490h.f32442l.add(this.f32484b.f32276c0.f32281f.f32491i);
            this.f32484b.f32276c0.f32281f.f32491i.f32441k.add(this.f32490h);
            this.f32490h.f32436f = -iB1;
        } else {
            DependencyNode dependencyNode2 = this.f32490h;
            dependencyNode2.f32432b = true;
            dependencyNode2.f32442l.add(this.f32484b.f32276c0.f32281f.f32491i);
            this.f32484b.f32276c0.f32281f.f32491i.f32441k.add(this.f32490h);
        }
        q(this.f32484b.f32281f.f32490h);
        q(this.f32484b.f32281f.f32491i);
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    public void e() {
        if (((Guideline) this.f32484b).z1() == 1) {
            this.f32484b.t1(this.f32490h.f32437g);
        } else {
            this.f32484b.u1(this.f32490h.f32437g);
        }
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    void f() {
        this.f32490h.c();
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    boolean m() {
        return false;
    }
}
