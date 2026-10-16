package androidx.constraintlayout.core;

import androidx.constraintlayout.core.ArrayRow;
import com.facebook.appevents.integrity.IntegrityManager;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public class SolverVariableValues implements ArrayRow.ArrayRowVariables {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static float f31255n = 0.001f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f31256a = -1;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f31257b = 16;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f31258c = 16;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    int[] f31259d = new int[16];

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    int[] f31260e = new int[16];

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    int[] f31261f = new int[16];

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    float[] f31262g = new float[16];

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    int[] f31263h = new int[16];

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    int[] f31264i = new int[16];

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    int f31265j = 0;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    int f31266k = -1;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final ArrayRow f31267l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    protected final Cache f31268m;

    SolverVariableValues(ArrayRow arrayRow, Cache cache) {
        this.f31267l = arrayRow;
        this.f31268m = cache;
        clear();
    }

    private void a(SolverVariable solverVariable, int i3) {
        int[] iArr;
        int i4 = solverVariable.f31234c % this.f31258c;
        int[] iArr2 = this.f31259d;
        int i5 = iArr2[i4];
        if (i5 == -1) {
            iArr2[i4] = i3;
        } else {
            while (true) {
                iArr = this.f31260e;
                int i6 = iArr[i5];
                if (i6 == -1) {
                    break;
                } else {
                    i5 = i6;
                }
            }
            iArr[i5] = i3;
        }
        this.f31260e[i3] = -1;
    }

    private void b(int i3, SolverVariable solverVariable, float f3) {
        this.f31261f[i3] = solverVariable.f31234c;
        this.f31262g[i3] = f3;
        this.f31263h[i3] = -1;
        this.f31264i[i3] = -1;
        solverVariable.a(this.f31267l);
        solverVariable.f31244n++;
        this.f31265j++;
    }

    private int c() {
        for (int i3 = 0; i3 < this.f31257b; i3++) {
            if (this.f31261f[i3] == -1) {
                return i3;
            }
        }
        return -1;
    }

    private void o() {
        int i3 = this.f31257b * 2;
        this.f31261f = Arrays.copyOf(this.f31261f, i3);
        this.f31262g = Arrays.copyOf(this.f31262g, i3);
        this.f31263h = Arrays.copyOf(this.f31263h, i3);
        this.f31264i = Arrays.copyOf(this.f31264i, i3);
        this.f31260e = Arrays.copyOf(this.f31260e, i3);
        for (int i4 = this.f31257b; i4 < i3; i4++) {
            this.f31261f[i4] = -1;
            this.f31260e[i4] = -1;
        }
        this.f31257b = i3;
    }

    private void q(int i3, SolverVariable solverVariable, float f3) {
        int iC = c();
        b(iC, solverVariable, f3);
        if (i3 != -1) {
            this.f31263h[iC] = i3;
            int[] iArr = this.f31264i;
            iArr[iC] = iArr[i3];
            iArr[i3] = iC;
        } else {
            this.f31263h[iC] = -1;
            if (this.f31265j > 0) {
                this.f31264i[iC] = this.f31266k;
                this.f31266k = iC;
            } else {
                this.f31264i[iC] = -1;
            }
        }
        int i4 = this.f31264i[iC];
        if (i4 != -1) {
            this.f31263h[i4] = iC;
        }
        a(solverVariable, iC);
    }

    private void r(SolverVariable solverVariable) {
        int[] iArr;
        int i3;
        int i4 = solverVariable.f31234c;
        int i5 = i4 % this.f31258c;
        int[] iArr2 = this.f31259d;
        int i6 = iArr2[i5];
        if (i6 == -1) {
            return;
        }
        if (this.f31261f[i6] == i4) {
            int[] iArr3 = this.f31260e;
            iArr2[i5] = iArr3[i6];
            iArr3[i6] = -1;
            return;
        }
        while (true) {
            iArr = this.f31260e;
            i3 = iArr[i6];
            if (i3 == -1 || this.f31261f[i3] == i4) {
                break;
            } else {
                i6 = i3;
            }
        }
        if (i3 == -1 || this.f31261f[i3] != i4) {
            return;
        }
        iArr[i6] = iArr[i3];
        iArr[i3] = -1;
    }

    @Override // androidx.constraintlayout.core.ArrayRow.ArrayRowVariables
    public void clear() {
        int i3 = this.f31265j;
        for (int i4 = 0; i4 < i3; i4++) {
            SolverVariable solverVariableF = f(i4);
            if (solverVariableF != null) {
                solverVariableF.d(this.f31267l);
            }
        }
        for (int i5 = 0; i5 < this.f31257b; i5++) {
            this.f31261f[i5] = -1;
            this.f31260e[i5] = -1;
        }
        for (int i6 = 0; i6 < this.f31258c; i6++) {
            this.f31259d[i6] = -1;
        }
        this.f31265j = 0;
        this.f31266k = -1;
    }

    @Override // androidx.constraintlayout.core.ArrayRow.ArrayRowVariables
    public int d() {
        return this.f31265j;
    }

    @Override // androidx.constraintlayout.core.ArrayRow.ArrayRowVariables
    public boolean e(SolverVariable solverVariable) {
        return p(solverVariable) != -1;
    }

    @Override // androidx.constraintlayout.core.ArrayRow.ArrayRowVariables
    public SolverVariable f(int i3) {
        int i4 = this.f31265j;
        if (i4 == 0) {
            return null;
        }
        int i5 = this.f31266k;
        for (int i6 = 0; i6 < i4; i6++) {
            if (i6 == i3 && i5 != -1) {
                return this.f31268m.f31166d[this.f31261f[i5]];
            }
            i5 = this.f31264i[i5];
            if (i5 == -1) {
                break;
            }
        }
        return null;
    }

    @Override // androidx.constraintlayout.core.ArrayRow.ArrayRowVariables
    public void g(SolverVariable solverVariable, float f3, boolean z2) {
        float f4 = f31255n;
        if (f3 <= (-f4) || f3 >= f4) {
            int iP = p(solverVariable);
            if (iP == -1) {
                k(solverVariable, f3);
                return;
            }
            float[] fArr = this.f31262g;
            float f5 = fArr[iP] + f3;
            fArr[iP] = f5;
            float f6 = f31255n;
            if (f5 <= (-f6) || f5 >= f6) {
                return;
            }
            fArr[iP] = 0.0f;
            i(solverVariable, z2);
        }
    }

    @Override // androidx.constraintlayout.core.ArrayRow.ArrayRowVariables
    public void h() {
        int i3 = this.f31265j;
        int i4 = this.f31266k;
        for (int i5 = 0; i5 < i3; i5++) {
            float[] fArr = this.f31262g;
            fArr[i4] = fArr[i4] * (-1.0f);
            i4 = this.f31264i[i4];
            if (i4 == -1) {
                return;
            }
        }
    }

    @Override // androidx.constraintlayout.core.ArrayRow.ArrayRowVariables
    public float i(SolverVariable solverVariable, boolean z2) {
        int iP = p(solverVariable);
        if (iP == -1) {
            return 0.0f;
        }
        r(solverVariable);
        float f3 = this.f31262g[iP];
        if (this.f31266k == iP) {
            this.f31266k = this.f31264i[iP];
        }
        this.f31261f[iP] = -1;
        int[] iArr = this.f31263h;
        int i3 = iArr[iP];
        if (i3 != -1) {
            int[] iArr2 = this.f31264i;
            iArr2[i3] = iArr2[iP];
        }
        int i4 = this.f31264i[iP];
        if (i4 != -1) {
            iArr[i4] = iArr[iP];
        }
        this.f31265j--;
        solverVariable.f31244n--;
        if (z2) {
            solverVariable.d(this.f31267l);
        }
        return f3;
    }

    @Override // androidx.constraintlayout.core.ArrayRow.ArrayRowVariables
    public float j(ArrayRow arrayRow, boolean z2) {
        float fM = m(arrayRow.f31157a);
        i(arrayRow.f31157a, z2);
        SolverVariableValues solverVariableValues = (SolverVariableValues) arrayRow.f31161e;
        int iD = solverVariableValues.d();
        int i3 = 0;
        int i4 = 0;
        while (i3 < iD) {
            int i5 = solverVariableValues.f31261f[i4];
            if (i5 != -1) {
                g(this.f31268m.f31166d[i5], solverVariableValues.f31262g[i4] * fM, z2);
                i3++;
            }
            i4++;
        }
        return fM;
    }

    @Override // androidx.constraintlayout.core.ArrayRow.ArrayRowVariables
    public void k(SolverVariable solverVariable, float f3) {
        float f4 = f31255n;
        if (f3 > (-f4) && f3 < f4) {
            i(solverVariable, true);
            return;
        }
        if (this.f31265j == 0) {
            b(0, solverVariable, f3);
            a(solverVariable, 0);
            this.f31266k = 0;
            return;
        }
        int iP = p(solverVariable);
        if (iP != -1) {
            this.f31262g[iP] = f3;
            return;
        }
        if (this.f31265j + 1 >= this.f31257b) {
            o();
        }
        int i3 = this.f31265j;
        int i4 = this.f31266k;
        int i5 = -1;
        for (int i6 = 0; i6 < i3; i6++) {
            int i7 = this.f31261f[i4];
            int i8 = solverVariable.f31234c;
            if (i7 == i8) {
                this.f31262g[i4] = f3;
                return;
            }
            if (i7 < i8) {
                i5 = i4;
            }
            i4 = this.f31264i[i4];
            if (i4 == -1) {
                break;
            }
        }
        q(i5, solverVariable, f3);
    }

    @Override // androidx.constraintlayout.core.ArrayRow.ArrayRowVariables
    public float l(int i3) {
        int i4 = this.f31265j;
        int i5 = this.f31266k;
        for (int i6 = 0; i6 < i4; i6++) {
            if (i6 == i3) {
                return this.f31262g[i5];
            }
            i5 = this.f31264i[i5];
            if (i5 == -1) {
                return 0.0f;
            }
        }
        return 0.0f;
    }

    @Override // androidx.constraintlayout.core.ArrayRow.ArrayRowVariables
    public float m(SolverVariable solverVariable) {
        int iP = p(solverVariable);
        if (iP != -1) {
            return this.f31262g[iP];
        }
        return 0.0f;
    }

    @Override // androidx.constraintlayout.core.ArrayRow.ArrayRowVariables
    public void n(float f3) {
        int i3 = this.f31265j;
        int i4 = this.f31266k;
        for (int i5 = 0; i5 < i3; i5++) {
            float[] fArr = this.f31262g;
            fArr[i4] = fArr[i4] / f3;
            i4 = this.f31264i[i4];
            if (i4 == -1) {
                return;
            }
        }
    }

    public int p(SolverVariable solverVariable) {
        if (this.f31265j != 0 && solverVariable != null) {
            int i3 = solverVariable.f31234c;
            int i4 = this.f31259d[i3 % this.f31258c];
            if (i4 == -1) {
                return -1;
            }
            if (this.f31261f[i4] == i3) {
                return i4;
            }
            do {
                i4 = this.f31260e[i4];
                if (i4 == -1) {
                    break;
                }
            } while (this.f31261f[i4] != i3);
            if (i4 != -1 && this.f31261f[i4] == i3) {
                return i4;
            }
        }
        return -1;
    }

    public String toString() {
        String str = hashCode() + " { ";
        int i3 = this.f31265j;
        for (int i4 = 0; i4 < i3; i4++) {
            SolverVariable solverVariableF = f(i4);
            if (solverVariableF != null) {
                String str2 = str + solverVariableF + " = " + l(i4) + " ";
                int iP = p(solverVariableF);
                String str3 = str2 + "[p: ";
                String str4 = (this.f31263h[iP] != -1 ? str3 + this.f31268m.f31166d[this.f31261f[this.f31263h[iP]]] : str3 + IntegrityManager.INTEGRITY_TYPE_NONE) + ", n: ";
                str = (this.f31264i[iP] != -1 ? str4 + this.f31268m.f31166d[this.f31261f[this.f31264i[iP]]] : str4 + IntegrityManager.INTEGRITY_TYPE_NONE) + "]";
            }
        }
        return str + " }";
    }
}
