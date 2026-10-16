package androidx.constraintlayout.core.widgets;

import androidx.constraintlayout.core.widgets.analyzer.Grouping;
import androidx.constraintlayout.core.widgets.analyzer.WidgetGroup;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public class HelperWidget extends ConstraintWidget implements Helper {
    public ConstraintWidget[] V0 = new ConstraintWidget[4];
    public int W0 = 0;

    @Override // androidx.constraintlayout.core.widgets.Helper
    public void a(ConstraintWidget constraintWidget) {
        if (constraintWidget == this || constraintWidget == null) {
            return;
        }
        int i3 = this.W0 + 1;
        ConstraintWidget[] constraintWidgetArr = this.V0;
        if (i3 > constraintWidgetArr.length) {
            this.V0 = (ConstraintWidget[]) Arrays.copyOf(constraintWidgetArr, constraintWidgetArr.length * 2);
        }
        ConstraintWidget[] constraintWidgetArr2 = this.V0;
        int i4 = this.W0;
        constraintWidgetArr2[i4] = constraintWidget;
        this.W0 = i4 + 1;
    }

    @Override // androidx.constraintlayout.core.widgets.Helper
    public void b() {
        this.W0 = 0;
        Arrays.fill(this.V0, (Object) null);
    }

    @Override // androidx.constraintlayout.core.widgets.ConstraintWidget
    public void n(ConstraintWidget constraintWidget, HashMap map) {
        super.n(constraintWidget, map);
        HelperWidget helperWidget = (HelperWidget) constraintWidget;
        this.W0 = 0;
        int i3 = helperWidget.W0;
        for (int i4 = 0; i4 < i3; i4++) {
            a((ConstraintWidget) map.get(helperWidget.V0[i4]));
        }
    }

    public void y1(ArrayList arrayList, int i3, WidgetGroup widgetGroup) {
        for (int i4 = 0; i4 < this.W0; i4++) {
            widgetGroup.a(this.V0[i4]);
        }
        for (int i5 = 0; i5 < this.W0; i5++) {
            Grouping.a(this.V0[i5], i3, arrayList, widgetGroup);
        }
    }

    public int z1(int i3) {
        int i4;
        int i5;
        for (int i6 = 0; i6 < this.W0; i6++) {
            ConstraintWidget constraintWidget = this.V0[i6];
            if (i3 == 0 && (i5 = constraintWidget.S0) != -1) {
                return i5;
            }
            if (i3 == 1 && (i4 = constraintWidget.T0) != -1) {
                return i4;
            }
        }
        return -1;
    }

    @Override // androidx.constraintlayout.core.widgets.Helper
    public void c(ConstraintWidgetContainer constraintWidgetContainer) {
    }
}
