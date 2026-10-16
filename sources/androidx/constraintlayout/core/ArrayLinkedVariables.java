package androidx.constraintlayout.core;

import androidx.constraintlayout.core.ArrayRow;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public class ArrayLinkedVariables implements ArrayRow.ArrayRowVariables {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static float f31145l = 0.001f;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ArrayRow f31147b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected final Cache f31148c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f31146a = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f31149d = 8;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private SolverVariable f31150e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int[] f31151f = new int[8];

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int[] f31152g = new int[8];

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private float[] f31153h = new float[8];

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f31154i = -1;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int f31155j = -1;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private boolean f31156k = false;

    ArrayLinkedVariables(ArrayRow arrayRow, Cache cache) {
        this.f31147b = arrayRow;
        this.f31148c = cache;
    }

    @Override // androidx.constraintlayout.core.ArrayRow.ArrayRowVariables
    public final void clear() {
        int i3 = this.f31154i;
        for (int i4 = 0; i3 != -1 && i4 < this.f31146a; i4++) {
            SolverVariable solverVariable = this.f31148c.f31166d[this.f31151f[i3]];
            if (solverVariable != null) {
                solverVariable.d(this.f31147b);
            }
            i3 = this.f31152g[i3];
        }
        this.f31154i = -1;
        this.f31155j = -1;
        this.f31156k = false;
        this.f31146a = 0;
    }

    @Override // androidx.constraintlayout.core.ArrayRow.ArrayRowVariables
    public int d() {
        return this.f31146a;
    }

    @Override // androidx.constraintlayout.core.ArrayRow.ArrayRowVariables
    public boolean e(SolverVariable solverVariable) {
        int i3 = this.f31154i;
        if (i3 == -1) {
            return false;
        }
        for (int i4 = 0; i3 != -1 && i4 < this.f31146a; i4++) {
            if (this.f31151f[i3] == solverVariable.f31234c) {
                return true;
            }
            i3 = this.f31152g[i3];
        }
        return false;
    }

    @Override // androidx.constraintlayout.core.ArrayRow.ArrayRowVariables
    public SolverVariable f(int i3) {
        int i4 = this.f31154i;
        for (int i5 = 0; i4 != -1 && i5 < this.f31146a; i5++) {
            if (i5 == i3) {
                return this.f31148c.f31166d[this.f31151f[i4]];
            }
            i4 = this.f31152g[i4];
        }
        return null;
    }

    @Override // androidx.constraintlayout.core.ArrayRow.ArrayRowVariables
    public void g(SolverVariable solverVariable, float f3, boolean z2) {
        float f4 = f31145l;
        if (f3 <= (-f4) || f3 >= f4) {
            int i3 = this.f31154i;
            if (i3 == -1) {
                this.f31154i = 0;
                this.f31153h[0] = f3;
                this.f31151f[0] = solverVariable.f31234c;
                this.f31152g[0] = -1;
                solverVariable.f31244n++;
                solverVariable.a(this.f31147b);
                this.f31146a++;
                if (this.f31156k) {
                    return;
                }
                int i4 = this.f31155j + 1;
                this.f31155j = i4;
                int[] iArr = this.f31151f;
                if (i4 >= iArr.length) {
                    this.f31156k = true;
                    this.f31155j = iArr.length - 1;
                    return;
                }
                return;
            }
            int i5 = -1;
            for (int i6 = 0; i3 != -1 && i6 < this.f31146a; i6++) {
                int i7 = this.f31151f[i3];
                int i8 = solverVariable.f31234c;
                if (i7 == i8) {
                    float[] fArr = this.f31153h;
                    float f5 = fArr[i3] + f3;
                    float f6 = f31145l;
                    if (f5 > (-f6) && f5 < f6) {
                        f5 = 0.0f;
                    }
                    fArr[i3] = f5;
                    if (f5 == 0.0f) {
                        if (i3 == this.f31154i) {
                            this.f31154i = this.f31152g[i3];
                        } else {
                            int[] iArr2 = this.f31152g;
                            iArr2[i5] = iArr2[i3];
                        }
                        if (z2) {
                            solverVariable.d(this.f31147b);
                        }
                        if (this.f31156k) {
                            this.f31155j = i3;
                        }
                        solverVariable.f31244n--;
                        this.f31146a--;
                        return;
                    }
                    return;
                }
                if (i7 < i8) {
                    i5 = i3;
                }
                i3 = this.f31152g[i3];
            }
            int length = this.f31155j;
            int i9 = length + 1;
            if (this.f31156k) {
                int[] iArr3 = this.f31151f;
                if (iArr3[length] != -1) {
                    length = iArr3.length;
                }
            } else {
                length = i9;
            }
            int[] iArr4 = this.f31151f;
            if (length >= iArr4.length && this.f31146a < iArr4.length) {
                int i10 = 0;
                while (true) {
                    int[] iArr5 = this.f31151f;
                    if (i10 >= iArr5.length) {
                        break;
                    }
                    if (iArr5[i10] == -1) {
                        length = i10;
                        break;
                    }
                    i10++;
                }
            }
            int[] iArr6 = this.f31151f;
            if (length >= iArr6.length) {
                length = iArr6.length;
                int i11 = this.f31149d * 2;
                this.f31149d = i11;
                this.f31156k = false;
                this.f31155j = length - 1;
                this.f31153h = Arrays.copyOf(this.f31153h, i11);
                this.f31151f = Arrays.copyOf(this.f31151f, this.f31149d);
                this.f31152g = Arrays.copyOf(this.f31152g, this.f31149d);
            }
            this.f31151f[length] = solverVariable.f31234c;
            this.f31153h[length] = f3;
            if (i5 != -1) {
                int[] iArr7 = this.f31152g;
                iArr7[length] = iArr7[i5];
                iArr7[i5] = length;
            } else {
                this.f31152g[length] = this.f31154i;
                this.f31154i = length;
            }
            solverVariable.f31244n++;
            solverVariable.a(this.f31147b);
            this.f31146a++;
            if (!this.f31156k) {
                this.f31155j++;
            }
            int i12 = this.f31155j;
            int[] iArr8 = this.f31151f;
            if (i12 >= iArr8.length) {
                this.f31156k = true;
                this.f31155j = iArr8.length - 1;
            }
        }
    }

    @Override // androidx.constraintlayout.core.ArrayRow.ArrayRowVariables
    public void h() {
        int i3 = this.f31154i;
        for (int i4 = 0; i3 != -1 && i4 < this.f31146a; i4++) {
            float[] fArr = this.f31153h;
            fArr[i3] = fArr[i3] * (-1.0f);
            i3 = this.f31152g[i3];
        }
    }

    @Override // androidx.constraintlayout.core.ArrayRow.ArrayRowVariables
    public final float i(SolverVariable solverVariable, boolean z2) {
        if (this.f31150e == solverVariable) {
            this.f31150e = null;
        }
        int i3 = this.f31154i;
        if (i3 == -1) {
            return 0.0f;
        }
        int i4 = 0;
        int i5 = -1;
        while (i3 != -1 && i4 < this.f31146a) {
            if (this.f31151f[i3] == solverVariable.f31234c) {
                if (i3 == this.f31154i) {
                    this.f31154i = this.f31152g[i3];
                } else {
                    int[] iArr = this.f31152g;
                    iArr[i5] = iArr[i3];
                }
                if (z2) {
                    solverVariable.d(this.f31147b);
                }
                solverVariable.f31244n--;
                this.f31146a--;
                this.f31151f[i3] = -1;
                if (this.f31156k) {
                    this.f31155j = i3;
                }
                return this.f31153h[i3];
            }
            i4++;
            i5 = i3;
            i3 = this.f31152g[i3];
        }
        return 0.0f;
    }

    @Override // androidx.constraintlayout.core.ArrayRow.ArrayRowVariables
    public float j(ArrayRow arrayRow, boolean z2) {
        float fM = m(arrayRow.f31157a);
        i(arrayRow.f31157a, z2);
        ArrayRow.ArrayRowVariables arrayRowVariables = arrayRow.f31161e;
        int iD = arrayRowVariables.d();
        for (int i3 = 0; i3 < iD; i3++) {
            SolverVariable solverVariableF = arrayRowVariables.f(i3);
            g(solverVariableF, arrayRowVariables.m(solverVariableF) * fM, z2);
        }
        return fM;
    }

    @Override // androidx.constraintlayout.core.ArrayRow.ArrayRowVariables
    public final void k(SolverVariable solverVariable, float f3) {
        if (f3 == 0.0f) {
            i(solverVariable, true);
            return;
        }
        int i3 = this.f31154i;
        if (i3 == -1) {
            this.f31154i = 0;
            this.f31153h[0] = f3;
            this.f31151f[0] = solverVariable.f31234c;
            this.f31152g[0] = -1;
            solverVariable.f31244n++;
            solverVariable.a(this.f31147b);
            this.f31146a++;
            if (this.f31156k) {
                return;
            }
            int i4 = this.f31155j + 1;
            this.f31155j = i4;
            int[] iArr = this.f31151f;
            if (i4 >= iArr.length) {
                this.f31156k = true;
                this.f31155j = iArr.length - 1;
                return;
            }
            return;
        }
        int i5 = -1;
        for (int i6 = 0; i3 != -1 && i6 < this.f31146a; i6++) {
            int i7 = this.f31151f[i3];
            int i8 = solverVariable.f31234c;
            if (i7 == i8) {
                this.f31153h[i3] = f3;
                return;
            }
            if (i7 < i8) {
                i5 = i3;
            }
            i3 = this.f31152g[i3];
        }
        int length = this.f31155j;
        int i9 = length + 1;
        if (this.f31156k) {
            int[] iArr2 = this.f31151f;
            if (iArr2[length] != -1) {
                length = iArr2.length;
            }
        } else {
            length = i9;
        }
        int[] iArr3 = this.f31151f;
        if (length >= iArr3.length && this.f31146a < iArr3.length) {
            int i10 = 0;
            while (true) {
                int[] iArr4 = this.f31151f;
                if (i10 >= iArr4.length) {
                    break;
                }
                if (iArr4[i10] == -1) {
                    length = i10;
                    break;
                }
                i10++;
            }
        }
        int[] iArr5 = this.f31151f;
        if (length >= iArr5.length) {
            length = iArr5.length;
            int i11 = this.f31149d * 2;
            this.f31149d = i11;
            this.f31156k = false;
            this.f31155j = length - 1;
            this.f31153h = Arrays.copyOf(this.f31153h, i11);
            this.f31151f = Arrays.copyOf(this.f31151f, this.f31149d);
            this.f31152g = Arrays.copyOf(this.f31152g, this.f31149d);
        }
        this.f31151f[length] = solverVariable.f31234c;
        this.f31153h[length] = f3;
        if (i5 != -1) {
            int[] iArr6 = this.f31152g;
            iArr6[length] = iArr6[i5];
            iArr6[i5] = length;
        } else {
            this.f31152g[length] = this.f31154i;
            this.f31154i = length;
        }
        solverVariable.f31244n++;
        solverVariable.a(this.f31147b);
        int i12 = this.f31146a + 1;
        this.f31146a = i12;
        if (!this.f31156k) {
            this.f31155j++;
        }
        int[] iArr7 = this.f31151f;
        if (i12 >= iArr7.length) {
            this.f31156k = true;
        }
        if (this.f31155j >= iArr7.length) {
            this.f31156k = true;
            this.f31155j = iArr7.length - 1;
        }
    }

    @Override // androidx.constraintlayout.core.ArrayRow.ArrayRowVariables
    public float l(int i3) {
        int i4 = this.f31154i;
        for (int i5 = 0; i4 != -1 && i5 < this.f31146a; i5++) {
            if (i5 == i3) {
                return this.f31153h[i4];
            }
            i4 = this.f31152g[i4];
        }
        return 0.0f;
    }

    @Override // androidx.constraintlayout.core.ArrayRow.ArrayRowVariables
    public final float m(SolverVariable solverVariable) {
        int i3 = this.f31154i;
        for (int i4 = 0; i3 != -1 && i4 < this.f31146a; i4++) {
            if (this.f31151f[i3] == solverVariable.f31234c) {
                return this.f31153h[i3];
            }
            i3 = this.f31152g[i3];
        }
        return 0.0f;
    }

    @Override // androidx.constraintlayout.core.ArrayRow.ArrayRowVariables
    public void n(float f3) {
        int i3 = this.f31154i;
        for (int i4 = 0; i3 != -1 && i4 < this.f31146a; i4++) {
            float[] fArr = this.f31153h;
            fArr[i3] = fArr[i3] / f3;
            i3 = this.f31152g[i3];
        }
    }

    public String toString() {
        int i3 = this.f31154i;
        String str = "";
        for (int i4 = 0; i3 != -1 && i4 < this.f31146a; i4++) {
            str = ((str + " -> ") + this.f31153h[i3] + " : ") + this.f31148c.f31166d[this.f31151f[i3]];
            i3 = this.f31152g[i3];
        }
        return str;
    }
}
