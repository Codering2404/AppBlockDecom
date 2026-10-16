package androidx.constraintlayout.core.widgets.analyzer;

import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.core.widgets.Guideline;
import androidx.constraintlayout.core.widgets.HelperWidget;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public class Grouping {
    public static WidgetGroup a(ConstraintWidget constraintWidget, int i3, ArrayList arrayList, WidgetGroup widgetGroup) {
        int iZ1;
        int i4 = i3 == 0 ? constraintWidget.S0 : constraintWidget.T0;
        if (i4 != -1 && (widgetGroup == null || i4 != widgetGroup.c())) {
            int i5 = 0;
            while (true) {
                if (i5 >= arrayList.size()) {
                    break;
                }
                WidgetGroup widgetGroup2 = (WidgetGroup) arrayList.get(i5);
                if (widgetGroup2.c() == i4) {
                    if (widgetGroup != null) {
                        widgetGroup.g(i3, widgetGroup2);
                        arrayList.remove(widgetGroup);
                    }
                    widgetGroup = widgetGroup2;
                } else {
                    i5++;
                }
            }
        } else if (i4 != -1) {
            return widgetGroup;
        }
        if (widgetGroup == null) {
            if ((constraintWidget instanceof HelperWidget) && (iZ1 = ((HelperWidget) constraintWidget).z1(i3)) != -1) {
                int i6 = 0;
                while (true) {
                    if (i6 >= arrayList.size()) {
                        break;
                    }
                    WidgetGroup widgetGroup3 = (WidgetGroup) arrayList.get(i6);
                    if (widgetGroup3.c() == iZ1) {
                        widgetGroup = widgetGroup3;
                        break;
                    }
                    i6++;
                }
            }
            if (widgetGroup == null) {
                widgetGroup = new WidgetGroup(i3);
            }
            arrayList.add(widgetGroup);
        }
        if (widgetGroup.a(constraintWidget)) {
            if (constraintWidget instanceof Guideline) {
                Guideline guideline = (Guideline) constraintWidget;
                guideline.y1().c(guideline.z1() == 0 ? 1 : 0, arrayList, widgetGroup);
            }
            if (i3 == 0) {
                constraintWidget.S0 = widgetGroup.c();
                constraintWidget.Q.c(i3, arrayList, widgetGroup);
                constraintWidget.S.c(i3, arrayList, widgetGroup);
            } else {
                constraintWidget.T0 = widgetGroup.c();
                constraintWidget.R.c(i3, arrayList, widgetGroup);
                constraintWidget.U.c(i3, arrayList, widgetGroup);
                constraintWidget.T.c(i3, arrayList, widgetGroup);
            }
            constraintWidget.X.c(i3, arrayList, widgetGroup);
        }
        return widgetGroup;
    }

    private static WidgetGroup b(ArrayList arrayList, int i3) {
        int size = arrayList.size();
        for (int i4 = 0; i4 < size; i4++) {
            WidgetGroup widgetGroup = (WidgetGroup) arrayList.get(i4);
            if (i3 == widgetGroup.c()) {
                return widgetGroup;
            }
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:168:0x034c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean c(androidx.constraintlayout.core.widgets.ConstraintWidgetContainer r17, androidx.constraintlayout.core.widgets.analyzer.BasicMeasure.Measurer r18) {
        /*
            Method dump skipped, instruction units count: 921
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.widgets.analyzer.Grouping.c(androidx.constraintlayout.core.widgets.ConstraintWidgetContainer, androidx.constraintlayout.core.widgets.analyzer.BasicMeasure$Measurer):boolean");
    }

    public static boolean d(ConstraintWidget.DimensionBehaviour dimensionBehaviour, ConstraintWidget.DimensionBehaviour dimensionBehaviour2, ConstraintWidget.DimensionBehaviour dimensionBehaviour3, ConstraintWidget.DimensionBehaviour dimensionBehaviour4) {
        ConstraintWidget.DimensionBehaviour dimensionBehaviour5;
        ConstraintWidget.DimensionBehaviour dimensionBehaviour6;
        ConstraintWidget.DimensionBehaviour dimensionBehaviour7 = ConstraintWidget.DimensionBehaviour.FIXED;
        return (dimensionBehaviour3 == dimensionBehaviour7 || dimensionBehaviour3 == (dimensionBehaviour6 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) || (dimensionBehaviour3 == ConstraintWidget.DimensionBehaviour.MATCH_PARENT && dimensionBehaviour != dimensionBehaviour6)) || (dimensionBehaviour4 == dimensionBehaviour7 || dimensionBehaviour4 == (dimensionBehaviour5 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) || (dimensionBehaviour4 == ConstraintWidget.DimensionBehaviour.MATCH_PARENT && dimensionBehaviour2 != dimensionBehaviour5));
    }
}
