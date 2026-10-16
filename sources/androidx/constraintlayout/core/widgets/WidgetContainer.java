package androidx.constraintlayout.core.widgets;

import androidx.constraintlayout.core.Cache;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public class WidgetContainer extends ConstraintWidget {
    public ArrayList V0;

    public WidgetContainer() {
        this.V0 = new ArrayList();
    }

    public void A1() {
        ArrayList arrayList = this.V0;
        if (arrayList == null) {
            return;
        }
        int size = arrayList.size();
        for (int i3 = 0; i3 < size; i3++) {
            ConstraintWidget constraintWidget = (ConstraintWidget) this.V0.get(i3);
            if (constraintWidget instanceof WidgetContainer) {
                ((WidgetContainer) constraintWidget).A1();
            }
        }
    }

    @Override // androidx.constraintlayout.core.widgets.ConstraintWidget
    public void B0(Cache cache) {
        super.B0(cache);
        int size = this.V0.size();
        for (int i3 = 0; i3 < size; i3++) {
            ((ConstraintWidget) this.V0.get(i3)).B0(cache);
        }
    }

    public void B1(ConstraintWidget constraintWidget) {
        this.V0.remove(constraintWidget);
        constraintWidget.x0();
    }

    public void C1() {
        this.V0.clear();
    }

    public void a(ConstraintWidget constraintWidget) {
        this.V0.add(constraintWidget);
        if (constraintWidget.N() != null) {
            ((WidgetContainer) constraintWidget.N()).B1(constraintWidget);
        }
        constraintWidget.j1(this);
    }

    @Override // androidx.constraintlayout.core.widgets.ConstraintWidget
    public void x0() {
        this.V0.clear();
        super.x0();
    }

    public void y1(ConstraintWidget... constraintWidgetArr) {
        for (ConstraintWidget constraintWidget : constraintWidgetArr) {
            a(constraintWidget);
        }
    }

    public ArrayList z1() {
        return this.V0;
    }

    public WidgetContainer(int i3, int i4) {
        super(i3, i4);
        this.V0 = new ArrayList();
    }
}
