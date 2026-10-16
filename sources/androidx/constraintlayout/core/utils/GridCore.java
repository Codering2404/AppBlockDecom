package androidx.constraintlayout.core.utils;

import androidx.constraintlayout.core.LinearSystem;
import androidx.constraintlayout.core.utils.GridCore;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.core.widgets.ConstraintWidgetContainer;
import androidx.constraintlayout.core.widgets.VirtualLayout;
import com.revenuecat.purchases.common.Constants;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public class GridCore extends VirtualLayout {
    private int[][] B1;
    private int C1;
    private int[][] D1;

    /* JADX INFO: renamed from: k1, reason: collision with root package name */
    ConstraintWidgetContainer f32213k1;

    /* JADX INFO: renamed from: l1, reason: collision with root package name */
    private ConstraintWidget[] f32214l1;

    /* JADX INFO: renamed from: n1, reason: collision with root package name */
    private int f32216n1;

    /* JADX INFO: renamed from: o1, reason: collision with root package name */
    private int f32217o1;

    /* JADX INFO: renamed from: p1, reason: collision with root package name */
    private int f32218p1;

    /* JADX INFO: renamed from: q1, reason: collision with root package name */
    private int f32219q1;

    /* JADX INFO: renamed from: r1, reason: collision with root package name */
    private float f32220r1;

    /* JADX INFO: renamed from: s1, reason: collision with root package name */
    private float f32221s1;

    /* JADX INFO: renamed from: t1, reason: collision with root package name */
    private String f32222t1;

    /* JADX INFO: renamed from: u1, reason: collision with root package name */
    private String f32223u1;

    /* JADX INFO: renamed from: v1, reason: collision with root package name */
    private String f32224v1;

    /* JADX INFO: renamed from: w1, reason: collision with root package name */
    private String f32225w1;

    /* JADX INFO: renamed from: x1, reason: collision with root package name */
    private int f32226x1;

    /* JADX INFO: renamed from: z1, reason: collision with root package name */
    private boolean[][] f32228z1;

    /* JADX INFO: renamed from: m1, reason: collision with root package name */
    private boolean f32215m1 = false;

    /* JADX INFO: renamed from: y1, reason: collision with root package name */
    private int f32227y1 = 0;
    Set A1 = new HashSet();
    private int E1 = 0;

    public GridCore() {
        E2();
        j2();
    }

    private void D2(boolean z2) {
        int[][] iArrP2;
        if (this.f32216n1 < 1 || this.f32218p1 < 1) {
            return;
        }
        if (z2) {
            for (int i3 = 0; i3 < this.f32228z1.length; i3++) {
                int i4 = 0;
                while (true) {
                    boolean[][] zArr = this.f32228z1;
                    if (i4 < zArr[0].length) {
                        zArr[i3][i4] = true;
                        i4++;
                    }
                }
            }
            this.A1.clear();
        }
        this.f32227y1 = 0;
        String str = this.f32225w1;
        if (str != null && !str.trim().isEmpty() && (iArrP2 = p2(this.f32225w1, false)) != null) {
            h2(iArrP2);
        }
        String str2 = this.f32224v1;
        if (str2 != null && !str2.trim().isEmpty()) {
            this.D1 = p2(this.f32224v1, true);
        }
        c2();
        int[][] iArr = this.D1;
        if (iArr != null) {
            i2(iArr);
        }
    }

    private void E2() {
        int i3;
        int i4 = this.f32217o1;
        if (i4 != 0 && (i3 = this.f32219q1) != 0) {
            this.f32216n1 = i4;
            this.f32218p1 = i3;
            return;
        }
        int i5 = this.f32219q1;
        if (i5 > 0) {
            this.f32218p1 = i5;
            this.f32216n1 = ((this.W0 + i5) - 1) / i5;
        } else if (i4 > 0) {
            this.f32216n1 = i4;
            this.f32218p1 = ((this.W0 + i4) - 1) / i4;
        } else {
            int iSqrt = (int) (Math.sqrt(this.W0) + 1.5d);
            this.f32216n1 = iSqrt;
            this.f32218p1 = ((this.W0 + iSqrt) - 1) / iSqrt;
        }
    }

    public static /* synthetic */ int W1(String str, String str2) {
        return Integer.parseInt(str.split(Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR)[0]) - Integer.parseInt(str2.split(Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR)[0]);
    }

    private void X1() {
        s2();
        r2();
        Y1();
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0066  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void Y1() {
        /*
            r10 = this;
            r0 = 0
            r1 = r0
        L2:
            int r2 = r10.W0
            if (r1 >= r2) goto L73
            java.util.Set r2 = r10.A1
            androidx.constraintlayout.core.widgets.ConstraintWidget[] r3 = r10.V0
            r3 = r3[r1]
            java.lang.String r3 = r3.f32299o
            boolean r2 = r2.contains(r3)
            if (r2 == 0) goto L15
            goto L70
        L15:
            int r2 = r10.f2()
            int r5 = r10.g2(r2)
            int r6 = r10.e2(r2)
            r3 = -1
            if (r2 != r3) goto L25
            goto L73
        L25:
            boolean r3 = r10.m2()
            if (r3 == 0) goto L66
            int[][] r3 = r10.D1
            if (r3 == 0) goto L66
            int r4 = r10.E1
            int r7 = r3.length
            if (r4 >= r7) goto L66
            r3 = r3[r4]
            r4 = r3[r0]
            if (r4 != r2) goto L66
            boolean[][] r2 = r10.f32228z1
            r2 = r2[r5]
            r9 = 1
            r2[r6] = r9
            r2 = r3[r9]
            r4 = 2
            r3 = r3[r4]
            boolean r2 = r10.l2(r5, r6, r2, r3)
            if (r2 != 0) goto L4d
            goto L70
        L4d:
            androidx.constraintlayout.core.widgets.ConstraintWidget[] r2 = r10.V0
            r2 = r2[r1]
            int[][] r3 = r10.D1
            int r7 = r10.E1
            r3 = r3[r7]
            r7 = r3[r9]
            r8 = r3[r4]
            r3 = r10
            r4 = r2
            r3.b2(r4, r5, r6, r7, r8)
            int r2 = r3.E1
            int r2 = r2 + r9
            r3.E1 = r2
            goto L70
        L66:
            r3 = r10
            androidx.constraintlayout.core.widgets.ConstraintWidget[] r2 = r3.V0
            r4 = r2[r1]
            r7 = 1
            r8 = 1
            r3.b2(r4, r5, r6, r7, r8)
        L70:
            int r1 = r1 + 1
            goto L2
        L73:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.utils.GridCore.Y1():void");
    }

    private void Z1(ConstraintWidget constraintWidget) {
        constraintWidget.Y0(-1.0f);
        constraintWidget.Q.q();
        constraintWidget.S.q();
    }

    private void a2(ConstraintWidget constraintWidget) {
        constraintWidget.p1(-1.0f);
        constraintWidget.R.q();
        constraintWidget.T.q();
        constraintWidget.U.q();
    }

    private void b2(ConstraintWidget constraintWidget, int i3, int i4, int i5, int i6) {
        constraintWidget.Q.a(this.f32214l1[i4].Q, 0);
        constraintWidget.R.a(this.f32214l1[i3].R, 0);
        constraintWidget.S.a(this.f32214l1[(i4 + i6) - 1].S, 0);
        constraintWidget.T.a(this.f32214l1[(i3 + i5) - 1].T, 0);
    }

    private void c2() {
        int iMax = Math.max(this.f32216n1, this.f32218p1);
        ConstraintWidget[] constraintWidgetArr = this.f32214l1;
        int i3 = 0;
        if (constraintWidgetArr == null) {
            this.f32214l1 = new ConstraintWidget[iMax];
            while (true) {
                ConstraintWidget[] constraintWidgetArr2 = this.f32214l1;
                if (i3 >= constraintWidgetArr2.length) {
                    return;
                }
                constraintWidgetArr2[i3] = o2();
                i3++;
            }
        } else {
            if (iMax == constraintWidgetArr.length) {
                return;
            }
            ConstraintWidget[] constraintWidgetArr3 = new ConstraintWidget[iMax];
            while (i3 < iMax) {
                ConstraintWidget[] constraintWidgetArr4 = this.f32214l1;
                if (i3 < constraintWidgetArr4.length) {
                    constraintWidgetArr3[i3] = constraintWidgetArr4[i3];
                } else {
                    constraintWidgetArr3[i3] = o2();
                }
                i3++;
            }
            while (true) {
                ConstraintWidget[] constraintWidgetArr5 = this.f32214l1;
                if (iMax >= constraintWidgetArr5.length) {
                    this.f32214l1 = constraintWidgetArr3;
                    return;
                } else {
                    this.f32213k1.B1(constraintWidgetArr5[iMax]);
                    iMax++;
                }
            }
        }
    }

    private void d2(boolean z2) {
        int[][] iArrP2;
        int[][] iArrP22;
        if (z2) {
            for (int i3 = 0; i3 < this.f32228z1.length; i3++) {
                int i4 = 0;
                while (true) {
                    boolean[][] zArr = this.f32228z1;
                    if (i4 < zArr[0].length) {
                        zArr[i3][i4] = true;
                        i4++;
                    }
                }
            }
            for (int i5 = 0; i5 < this.B1.length; i5++) {
                int i6 = 0;
                while (true) {
                    int[][] iArr = this.B1;
                    if (i6 < iArr[0].length) {
                        iArr[i5][i6] = -1;
                        i6++;
                    }
                }
            }
        }
        this.f32227y1 = 0;
        String str = this.f32225w1;
        if (str != null && !str.trim().isEmpty() && (iArrP22 = p2(this.f32225w1, false)) != null) {
            h2(iArrP22);
        }
        String str2 = this.f32224v1;
        if (str2 == null || str2.trim().isEmpty() || (iArrP2 = p2(this.f32224v1, true)) == null) {
            return;
        }
        i2(iArrP2);
    }

    private int e2(int i3) {
        return this.f32226x1 == 1 ? i3 / this.f32216n1 : i3 % this.f32218p1;
    }

    private int f2() {
        boolean z2 = false;
        int i3 = 0;
        while (!z2) {
            i3 = this.f32227y1;
            if (i3 >= this.f32216n1 * this.f32218p1) {
                return -1;
            }
            int iG2 = g2(i3);
            int iE2 = e2(this.f32227y1);
            boolean[] zArr = this.f32228z1[iG2];
            if (zArr[iE2]) {
                zArr[iE2] = false;
                z2 = true;
            }
            this.f32227y1++;
        }
        return i3;
    }

    private int g2(int i3) {
        return this.f32226x1 == 1 ? i3 % this.f32216n1 : i3 / this.f32218p1;
    }

    private void h2(int[][] iArr) {
        for (int[] iArr2 : iArr) {
            if (!l2(g2(iArr2[0]), e2(iArr2[0]), iArr2[1], iArr2[2])) {
                return;
            }
        }
    }

    private void i2(int[][] iArr) {
        if (!m2()) {
            for (int i3 = 0; i3 < iArr.length; i3++) {
                int iG2 = g2(iArr[i3][0]);
                int iE2 = e2(iArr[i3][0]);
                int[] iArr2 = iArr[i3];
                if (!l2(iG2, iE2, iArr2[1], iArr2[2])) {
                    break;
                }
                ConstraintWidget constraintWidget = this.V0[i3];
                int[] iArr3 = iArr[i3];
                b2(constraintWidget, iG2, iE2, iArr3[1], iArr3[2]);
                this.A1.add(this.V0[i3].f32299o);
            }
        }
    }

    private void j2() {
        boolean[][] zArr;
        int[][] iArr = this.B1;
        boolean z2 = false;
        if (iArr != null && iArr.length == this.W0 && (zArr = this.f32228z1) != null && zArr.length == this.f32216n1 && zArr[0].length == this.f32218p1) {
            z2 = true;
        }
        if (!z2) {
            k2();
        }
        d2(z2);
    }

    private void k2() {
        boolean[][] zArr = (boolean[][]) Array.newInstance((Class<?>) Boolean.TYPE, this.f32216n1, this.f32218p1);
        this.f32228z1 = zArr;
        for (boolean[] zArr2 : zArr) {
            Arrays.fill(zArr2, true);
        }
        int i3 = this.W0;
        if (i3 > 0) {
            int[][] iArr = (int[][]) Array.newInstance((Class<?>) Integer.TYPE, i3, 4);
            this.B1 = iArr;
            for (int[] iArr2 : iArr) {
                Arrays.fill(iArr2, -1);
            }
        }
    }

    private boolean l2(int i3, int i4, int i5, int i6) {
        for (int i7 = i3; i7 < i3 + i5; i7++) {
            for (int i8 = i4; i8 < i4 + i6; i8++) {
                boolean[][] zArr = this.f32228z1;
                if (i7 < zArr.length && i8 < zArr[0].length) {
                    boolean[] zArr2 = zArr[i7];
                    if (zArr2[i8]) {
                        zArr2[i8] = false;
                    }
                }
                return false;
            }
        }
        return true;
    }

    private boolean m2() {
        return (this.C1 & 2) > 0;
    }

    private boolean n2() {
        return (this.C1 & 1) > 0;
    }

    private ConstraintWidget o2() {
        ConstraintWidget constraintWidget = new ConstraintWidget();
        ConstraintWidget.DimensionBehaviour[] dimensionBehaviourArr = constraintWidget.f32274b0;
        ConstraintWidget.DimensionBehaviour dimensionBehaviour = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
        dimensionBehaviourArr[0] = dimensionBehaviour;
        dimensionBehaviourArr[1] = dimensionBehaviour;
        constraintWidget.f32299o = String.valueOf(constraintWidget.hashCode());
        return constraintWidget;
    }

    private int[][] p2(String str, boolean z2) {
        try {
            String[] strArrSplit = str.split(",");
            Arrays.sort(strArrSplit, new Comparator() { // from class: c.a
                @Override // java.util.Comparator
                public final int compare(Object obj, Object obj2) {
                    return GridCore.W1((String) obj, (String) obj2);
                }
            });
            int[][] iArr = (int[][]) Array.newInstance((Class<?>) Integer.TYPE, strArrSplit.length, 3);
            if (this.f32216n1 != 1 && this.f32218p1 != 1) {
                for (int i3 = 0; i3 < strArrSplit.length; i3++) {
                    String[] strArrSplit2 = strArrSplit[i3].trim().split(Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR);
                    String[] strArrSplit3 = strArrSplit2[1].split("x");
                    iArr[i3][0] = Integer.parseInt(strArrSplit2[0]);
                    if (n2()) {
                        iArr[i3][1] = Integer.parseInt(strArrSplit3[1]);
                        iArr[i3][2] = Integer.parseInt(strArrSplit3[0]);
                    } else {
                        iArr[i3][1] = Integer.parseInt(strArrSplit3[0]);
                        iArr[i3][2] = Integer.parseInt(strArrSplit3[1]);
                    }
                }
                return iArr;
            }
            int i4 = 0;
            int i5 = 0;
            for (int i6 = 0; i6 < strArrSplit.length; i6++) {
                String[] strArrSplit4 = strArrSplit[i6].trim().split(Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR);
                iArr[i6][0] = Integer.parseInt(strArrSplit4[0]);
                int[] iArr2 = iArr[i6];
                iArr2[1] = 1;
                iArr2[2] = 1;
                if (this.f32218p1 == 1) {
                    iArr2[1] = Integer.parseInt(strArrSplit4[1]);
                    i4 += iArr[i6][1];
                    if (z2) {
                        i4--;
                    }
                }
                if (this.f32216n1 == 1) {
                    iArr[i6][2] = Integer.parseInt(strArrSplit4[1]);
                    i5 += iArr[i6][2];
                    if (z2) {
                        i5--;
                    }
                }
            }
            if (i4 != 0 && !this.f32215m1) {
                z2(this.f32216n1 + i4);
            }
            if (i5 != 0 && !this.f32215m1) {
                u2(this.f32218p1 + i5);
            }
            this.f32215m1 = true;
            return iArr;
        } catch (Exception unused) {
            return null;
        }
    }

    private float[] q2(int i3, String str) {
        if (str == null || str.trim().isEmpty()) {
            return null;
        }
        String[] strArrSplit = str.split(",");
        float[] fArr = new float[i3];
        for (int i4 = 0; i4 < i3; i4++) {
            if (i4 < strArrSplit.length) {
                try {
                    fArr[i4] = Float.parseFloat(strArrSplit[i4]);
                } catch (Exception e3) {
                    System.err.println("Error parsing `" + strArrSplit[i4] + "`: " + e3.getMessage());
                    fArr[i4] = 1.0f;
                }
            } else {
                fArr[i4] = 1.0f;
            }
        }
        return fArr;
    }

    private void r2() {
        int i3;
        int iMax = Math.max(this.f32216n1, this.f32218p1);
        ConstraintWidget constraintWidget = this.f32214l1[0];
        float[] fArrQ2 = q2(this.f32218p1, this.f32223u1);
        if (this.f32218p1 == 1) {
            Z1(constraintWidget);
            constraintWidget.Q.a(this.Q, 0);
            constraintWidget.S.a(this.S, 0);
            return;
        }
        int i4 = 0;
        while (true) {
            i3 = this.f32218p1;
            if (i4 >= i3) {
                break;
            }
            ConstraintWidget constraintWidget2 = this.f32214l1[i4];
            Z1(constraintWidget2);
            if (fArrQ2 != null) {
                constraintWidget2.Y0(fArrQ2[i4]);
            }
            if (i4 > 0) {
                constraintWidget2.Q.a(this.f32214l1[i4 - 1].S, 0);
            } else {
                constraintWidget2.Q.a(this.Q, 0);
            }
            if (i4 < this.f32218p1 - 1) {
                constraintWidget2.S.a(this.f32214l1[i4 + 1].Q, 0);
            } else {
                constraintWidget2.S.a(this.S, 0);
            }
            if (i4 > 0) {
                constraintWidget2.Q.f32258g = (int) this.f32220r1;
            }
            i4++;
        }
        while (i3 < iMax) {
            ConstraintWidget constraintWidget3 = this.f32214l1[i3];
            Z1(constraintWidget3);
            constraintWidget3.Q.a(this.Q, 0);
            constraintWidget3.S.a(this.S, 0);
            i3++;
        }
    }

    private void s2() {
        int i3;
        int iMax = Math.max(this.f32216n1, this.f32218p1);
        ConstraintWidget constraintWidget = this.f32214l1[0];
        float[] fArrQ2 = q2(this.f32216n1, this.f32222t1);
        if (this.f32216n1 == 1) {
            a2(constraintWidget);
            constraintWidget.R.a(this.R, 0);
            constraintWidget.T.a(this.T, 0);
            return;
        }
        int i4 = 0;
        while (true) {
            i3 = this.f32216n1;
            if (i4 >= i3) {
                break;
            }
            ConstraintWidget constraintWidget2 = this.f32214l1[i4];
            a2(constraintWidget2);
            if (fArrQ2 != null) {
                constraintWidget2.p1(fArrQ2[i4]);
            }
            if (i4 > 0) {
                constraintWidget2.R.a(this.f32214l1[i4 - 1].T, 0);
            } else {
                constraintWidget2.R.a(this.R, 0);
            }
            if (i4 < this.f32216n1 - 1) {
                constraintWidget2.T.a(this.f32214l1[i4 + 1].R, 0);
            } else {
                constraintWidget2.T.a(this.T, 0);
            }
            if (i4 > 0) {
                constraintWidget2.R.f32258g = (int) this.f32221s1;
            }
            i4++;
        }
        while (i3 < iMax) {
            ConstraintWidget constraintWidget3 = this.f32214l1[i3];
            a2(constraintWidget3);
            constraintWidget3.R.a(this.R, 0);
            constraintWidget3.T.a(this.T, 0);
            i3++;
        }
    }

    public void A2(String str) {
        String str2 = this.f32225w1;
        if (str2 == null || !str2.equals(str)) {
            this.f32215m1 = false;
            this.f32225w1 = str;
        }
    }

    public void B2(CharSequence charSequence) {
        String str = this.f32224v1;
        if (str == null || !str.equals(charSequence.toString())) {
            this.f32215m1 = false;
            this.f32224v1 = charSequence.toString();
        }
    }

    public void C2(float f3) {
        if (f3 >= 0.0f && this.f32221s1 != f3) {
            this.f32221s1 = f3;
        }
    }

    @Override // androidx.constraintlayout.core.widgets.VirtualLayout
    public void J1(int i3, int i4, int i5, int i6) {
        super.J1(i3, i4, i5, i6);
        this.f32213k1 = (ConstraintWidgetContainer) N();
        D2(false);
        this.f32213k1.y1(this.f32214l1);
    }

    @Override // androidx.constraintlayout.core.widgets.ConstraintWidget
    public void g(LinearSystem linearSystem, boolean z2) {
        super.g(linearSystem, z2);
        X1();
    }

    public void t2(String str) {
        String str2 = this.f32223u1;
        if (str2 == null || !str2.equals(str)) {
            this.f32223u1 = str;
        }
    }

    public void u2(int i3) {
        if (i3 <= 50 && this.f32219q1 != i3) {
            this.f32219q1 = i3;
            E2();
            k2();
        }
    }

    public void v2(int i3) {
        this.C1 = i3;
    }

    public void w2(float f3) {
        if (f3 >= 0.0f && this.f32220r1 != f3) {
            this.f32220r1 = f3;
        }
    }

    public void x2(int i3) {
        if ((i3 == 0 || i3 == 1) && this.f32226x1 != i3) {
            this.f32226x1 = i3;
        }
    }

    public void y2(String str) {
        String str2 = this.f32222t1;
        if (str2 == null || !str2.equals(str)) {
            this.f32222t1 = str;
        }
    }

    public void z2(int i3) {
        if (i3 <= 50 && this.f32217o1 != i3) {
            this.f32217o1 = i3;
            E2();
            k2();
        }
    }
}
