package androidx.constraintlayout.core.widgets;

import androidx.constraintlayout.core.LinearSystem;
import androidx.constraintlayout.core.widgets.ConstraintAnchor;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public class Placeholder extends VirtualLayout {
    @Override // androidx.constraintlayout.core.widgets.VirtualLayout
    public void J1(int i3, int i4, int i5, int i6) {
        int iG1 = G1() + H1();
        int iI1 = I1() + F1();
        if (this.W0 > 0) {
            iG1 += this.V0[0].a0();
            iI1 += this.V0[0].z();
        }
        int iMax = Math.max(L(), iG1);
        int iMax2 = Math.max(K(), iI1);
        if (i3 != 1073741824) {
            i4 = i3 == Integer.MIN_VALUE ? Math.min(iMax, i4) : i3 == 0 ? iMax : 0;
        }
        if (i5 != 1073741824) {
            i6 = i5 == Integer.MIN_VALUE ? Math.min(iMax2, i6) : i5 == 0 ? iMax2 : 0;
        }
        O1(i4, i6);
        r1(i4);
        S0(i6);
        N1(this.W0 > 0);
    }

    @Override // androidx.constraintlayout.core.widgets.ConstraintWidget
    public void g(LinearSystem linearSystem, boolean z2) {
        super.g(linearSystem, z2);
        if (this.W0 > 0) {
            ConstraintWidget constraintWidget = this.V0[0];
            constraintWidget.y0();
            ConstraintAnchor.Type type = ConstraintAnchor.Type.LEFT;
            constraintWidget.j(type, this, type);
            ConstraintAnchor.Type type2 = ConstraintAnchor.Type.RIGHT;
            constraintWidget.j(type2, this, type2);
            ConstraintAnchor.Type type3 = ConstraintAnchor.Type.TOP;
            constraintWidget.j(type3, this, type3);
            ConstraintAnchor.Type type4 = ConstraintAnchor.Type.BOTTOM;
            constraintWidget.j(type4, this, type4);
        }
    }
}
