package androidx.constraintlayout.core.widgets.analyzer;

import androidx.constraintlayout.core.widgets.ConstraintAnchor;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.core.widgets.ConstraintWidgetContainer;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public class ChainRun extends WidgetRun {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    ArrayList f32420k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private int f32421l;

    public ChainRun(ConstraintWidget constraintWidget, int i3) {
        super(constraintWidget);
        this.f32420k = new ArrayList();
        this.f32488f = i3;
        q();
    }

    private void q() {
        ConstraintWidget constraintWidget;
        ConstraintWidget constraintWidget2 = this.f32484b;
        ConstraintWidget constraintWidgetO = constraintWidget2.O(this.f32488f);
        while (true) {
            ConstraintWidget constraintWidget3 = constraintWidgetO;
            constraintWidget = constraintWidget2;
            constraintWidget2 = constraintWidget3;
            if (constraintWidget2 == null) {
                break;
            } else {
                constraintWidgetO = constraintWidget2.O(this.f32488f);
            }
        }
        this.f32484b = constraintWidget;
        this.f32420k.add(constraintWidget.Q(this.f32488f));
        ConstraintWidget constraintWidgetM = constraintWidget.M(this.f32488f);
        while (constraintWidgetM != null) {
            this.f32420k.add(constraintWidgetM.Q(this.f32488f));
            constraintWidgetM = constraintWidgetM.M(this.f32488f);
        }
        ArrayList arrayList = this.f32420k;
        int size = arrayList.size();
        int i3 = 0;
        while (i3 < size) {
            Object obj = arrayList.get(i3);
            i3++;
            WidgetRun widgetRun = (WidgetRun) obj;
            int i4 = this.f32488f;
            if (i4 == 0) {
                widgetRun.f32484b.f32275c = this;
            } else if (i4 == 1) {
                widgetRun.f32484b.f32277d = this;
            }
        }
        if (this.f32488f == 0 && ((ConstraintWidgetContainer) this.f32484b.N()).Y1() && this.f32420k.size() > 1) {
            ArrayList arrayList2 = this.f32420k;
            this.f32484b = ((WidgetRun) arrayList2.get(arrayList2.size() - 1)).f32484b;
        }
        this.f32421l = this.f32488f == 0 ? this.f32484b.B() : this.f32484b.W();
    }

    private ConstraintWidget r() {
        for (int i3 = 0; i3 < this.f32420k.size(); i3++) {
            WidgetRun widgetRun = (WidgetRun) this.f32420k.get(i3);
            if (widgetRun.f32484b.Z() != 8) {
                return widgetRun.f32484b;
            }
        }
        return null;
    }

    private ConstraintWidget s() {
        for (int size = this.f32420k.size() - 1; size >= 0; size--) {
            WidgetRun widgetRun = (WidgetRun) this.f32420k.get(size);
            if (widgetRun.f32484b.Z() != 8) {
                return widgetRun.f32484b;
            }
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:90:0x0160  */
    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun, androidx.constraintlayout.core.widgets.analyzer.Dependency
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void a(androidx.constraintlayout.core.widgets.analyzer.Dependency r27) {
        /*
            Method dump skipped, instruction units count: 1054
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.widgets.analyzer.ChainRun.a(androidx.constraintlayout.core.widgets.analyzer.Dependency):void");
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    void d() {
        ArrayList arrayList = this.f32420k;
        int size = arrayList.size();
        int i3 = 0;
        while (i3 < size) {
            Object obj = arrayList.get(i3);
            i3++;
            ((WidgetRun) obj).d();
        }
        int size2 = this.f32420k.size();
        if (size2 < 1) {
            return;
        }
        ConstraintWidget constraintWidget = ((WidgetRun) this.f32420k.get(0)).f32484b;
        ConstraintWidget constraintWidget2 = ((WidgetRun) this.f32420k.get(size2 - 1)).f32484b;
        if (this.f32488f == 0) {
            ConstraintAnchor constraintAnchor = constraintWidget.Q;
            ConstraintAnchor constraintAnchor2 = constraintWidget2.S;
            DependencyNode dependencyNodeI = i(constraintAnchor, 0);
            int iF = constraintAnchor.f();
            ConstraintWidget constraintWidgetR = r();
            if (constraintWidgetR != null) {
                iF = constraintWidgetR.Q.f();
            }
            if (dependencyNodeI != null) {
                b(this.f32490h, dependencyNodeI, iF);
            }
            DependencyNode dependencyNodeI2 = i(constraintAnchor2, 0);
            int iF2 = constraintAnchor2.f();
            ConstraintWidget constraintWidgetS = s();
            if (constraintWidgetS != null) {
                iF2 = constraintWidgetS.S.f();
            }
            if (dependencyNodeI2 != null) {
                b(this.f32491i, dependencyNodeI2, -iF2);
            }
        } else {
            ConstraintAnchor constraintAnchor3 = constraintWidget.R;
            ConstraintAnchor constraintAnchor4 = constraintWidget2.T;
            DependencyNode dependencyNodeI3 = i(constraintAnchor3, 1);
            int iF3 = constraintAnchor3.f();
            ConstraintWidget constraintWidgetR2 = r();
            if (constraintWidgetR2 != null) {
                iF3 = constraintWidgetR2.R.f();
            }
            if (dependencyNodeI3 != null) {
                b(this.f32490h, dependencyNodeI3, iF3);
            }
            DependencyNode dependencyNodeI4 = i(constraintAnchor4, 1);
            int iF4 = constraintAnchor4.f();
            ConstraintWidget constraintWidgetS2 = s();
            if (constraintWidgetS2 != null) {
                iF4 = constraintWidgetS2.T.f();
            }
            if (dependencyNodeI4 != null) {
                b(this.f32491i, dependencyNodeI4, -iF4);
            }
        }
        this.f32490h.f32431a = this;
        this.f32491i.f32431a = this;
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    public void e() {
        for (int i3 = 0; i3 < this.f32420k.size(); i3++) {
            ((WidgetRun) this.f32420k.get(i3)).e();
        }
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    void f() {
        this.f32485c = null;
        ArrayList arrayList = this.f32420k;
        int size = arrayList.size();
        int i3 = 0;
        while (i3 < size) {
            Object obj = arrayList.get(i3);
            i3++;
            ((WidgetRun) obj).f();
        }
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    public long j() {
        int size = this.f32420k.size();
        long j3 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            WidgetRun widgetRun = (WidgetRun) this.f32420k.get(i3);
            j3 = j3 + ((long) widgetRun.f32490h.f32436f) + widgetRun.j() + ((long) widgetRun.f32491i.f32436f);
        }
        return j3;
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    boolean m() {
        int size = this.f32420k.size();
        for (int i3 = 0; i3 < size; i3++) {
            if (!((WidgetRun) this.f32420k.get(i3)).m()) {
                return false;
            }
        }
        return true;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("ChainRun ");
        sb.append(this.f32488f == 0 ? "horizontal : " : "vertical : ");
        ArrayList arrayList = this.f32420k;
        int size = arrayList.size();
        int i3 = 0;
        while (i3 < size) {
            Object obj = arrayList.get(i3);
            i3++;
            sb.append("<");
            sb.append((WidgetRun) obj);
            sb.append("> ");
        }
        return sb.toString();
    }
}
