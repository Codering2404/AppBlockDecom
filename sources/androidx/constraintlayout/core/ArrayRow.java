package androidx.constraintlayout.core;

import androidx.constraintlayout.core.LinearSystem;
import androidx.constraintlayout.core.SolverVariable;
import com.facebook.appevents.UserDataStore;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes2.dex */
public class ArrayRow implements LinearSystem.Row {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ArrayRowVariables f31161e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    SolverVariable f31157a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    float f31158b = 0.0f;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    boolean f31159c = false;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    ArrayList f31160d = new ArrayList();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    boolean f31162f = false;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    /* JADX INFO: loaded from: classes3.dex */
    public interface ArrayRowVariables {
        void clear();

        int d();

        boolean e(SolverVariable solverVariable);

        SolverVariable f(int i3);

        void g(SolverVariable solverVariable, float f3, boolean z2);

        void h();

        float i(SolverVariable solverVariable, boolean z2);

        float j(ArrayRow arrayRow, boolean z2);

        void k(SolverVariable solverVariable, float f3);

        float l(int i3);

        float m(SolverVariable solverVariable);

        void n(float f3);
    }

    public ArrayRow() {
    }

    private boolean u(SolverVariable solverVariable, LinearSystem linearSystem) {
        return solverVariable.f31244n <= 1;
    }

    private SolverVariable w(boolean[] zArr, SolverVariable solverVariable) {
        SolverVariable.Type type;
        int iD = this.f31161e.d();
        SolverVariable solverVariable2 = null;
        float f3 = 0.0f;
        for (int i3 = 0; i3 < iD; i3++) {
            float fL = this.f31161e.l(i3);
            if (fL < 0.0f) {
                SolverVariable solverVariableF = this.f31161e.f(i3);
                if ((zArr == null || !zArr[solverVariableF.f31234c]) && solverVariableF != solverVariable && (((type = solverVariableF.f31241k) == SolverVariable.Type.SLACK || type == SolverVariable.Type.ERROR) && fL < f3)) {
                    f3 = fL;
                    solverVariable2 = solverVariableF;
                }
            }
        }
        return solverVariable2;
    }

    public void A(LinearSystem linearSystem, SolverVariable solverVariable, boolean z2) {
        if (solverVariable == null || !solverVariable.f31238h) {
            return;
        }
        this.f31158b += solverVariable.f31237g * this.f31161e.m(solverVariable);
        this.f31161e.i(solverVariable, z2);
        if (z2) {
            solverVariable.d(this);
        }
        if (LinearSystem.f31169u && this.f31161e.d() == 0) {
            this.f31162f = true;
            linearSystem.f31176b = true;
        }
    }

    public void B(LinearSystem linearSystem, ArrayRow arrayRow, boolean z2) {
        this.f31158b += arrayRow.f31158b * this.f31161e.j(arrayRow, z2);
        if (z2) {
            arrayRow.f31157a.d(this);
        }
        if (LinearSystem.f31169u && this.f31157a != null && this.f31161e.d() == 0) {
            this.f31162f = true;
            linearSystem.f31176b = true;
        }
    }

    public void C(LinearSystem linearSystem, SolverVariable solverVariable, boolean z2) {
        if (solverVariable == null || !solverVariable.f31245o) {
            return;
        }
        float fM = this.f31161e.m(solverVariable);
        this.f31158b += solverVariable.f31247q * fM;
        this.f31161e.i(solverVariable, z2);
        if (z2) {
            solverVariable.d(this);
        }
        this.f31161e.g(linearSystem.f31189o.f31166d[solverVariable.f31246p], fM, z2);
        if (LinearSystem.f31169u && this.f31161e.d() == 0) {
            this.f31162f = true;
            linearSystem.f31176b = true;
        }
    }

    public void D(LinearSystem linearSystem) {
        if (linearSystem.f31182h.length == 0) {
            return;
        }
        boolean z2 = false;
        while (!z2) {
            int iD = this.f31161e.d();
            for (int i3 = 0; i3 < iD; i3++) {
                SolverVariable solverVariableF = this.f31161e.f(i3);
                if (solverVariableF.f31235d != -1 || solverVariableF.f31238h || solverVariableF.f31245o) {
                    this.f31160d.add(solverVariableF);
                }
            }
            int size = this.f31160d.size();
            if (size > 0) {
                for (int i4 = 0; i4 < size; i4++) {
                    SolverVariable solverVariable = (SolverVariable) this.f31160d.get(i4);
                    if (solverVariable.f31238h) {
                        A(linearSystem, solverVariable, true);
                    } else if (solverVariable.f31245o) {
                        C(linearSystem, solverVariable, true);
                    } else {
                        B(linearSystem, linearSystem.f31182h[solverVariable.f31235d], true);
                    }
                }
                this.f31160d.clear();
            } else {
                z2 = true;
            }
        }
        if (LinearSystem.f31169u && this.f31157a != null && this.f31161e.d() == 0) {
            this.f31162f = true;
            linearSystem.f31176b = true;
        }
    }

    @Override // androidx.constraintlayout.core.LinearSystem.Row
    public void a(LinearSystem.Row row) {
        if (row instanceof ArrayRow) {
            ArrayRow arrayRow = (ArrayRow) row;
            this.f31157a = null;
            this.f31161e.clear();
            for (int i3 = 0; i3 < arrayRow.f31161e.d(); i3++) {
                this.f31161e.g(arrayRow.f31161e.f(i3), arrayRow.f31161e.l(i3), true);
            }
        }
    }

    @Override // androidx.constraintlayout.core.LinearSystem.Row
    public SolverVariable b(LinearSystem linearSystem, boolean[] zArr) {
        return w(zArr, null);
    }

    @Override // androidx.constraintlayout.core.LinearSystem.Row
    public void c(SolverVariable solverVariable) {
        int i3 = solverVariable.f31236f;
        float f3 = 1.0f;
        if (i3 != 1) {
            if (i3 == 2) {
                f3 = 1000.0f;
            } else if (i3 == 3) {
                f3 = 1000000.0f;
            } else if (i3 == 4) {
                f3 = 1.0E9f;
            } else if (i3 == 5) {
                f3 = 1.0E12f;
            }
        }
        this.f31161e.k(solverVariable, f3);
    }

    @Override // androidx.constraintlayout.core.LinearSystem.Row
    public void clear() {
        this.f31161e.clear();
        this.f31157a = null;
        this.f31158b = 0.0f;
    }

    public ArrayRow d(LinearSystem linearSystem, int i3) {
        this.f31161e.k(linearSystem.o(i3, "ep"), 1.0f);
        this.f31161e.k(linearSystem.o(i3, UserDataStore.EMAIL), -1.0f);
        return this;
    }

    ArrayRow e(SolverVariable solverVariable, int i3) {
        this.f31161e.k(solverVariable, i3);
        return this;
    }

    boolean f(LinearSystem linearSystem) {
        boolean z2;
        SolverVariable solverVariableG = g(linearSystem);
        if (solverVariableG == null) {
            z2 = true;
        } else {
            x(solverVariableG);
            z2 = false;
        }
        if (this.f31161e.d() == 0) {
            this.f31162f = true;
        }
        return z2;
    }

    SolverVariable g(LinearSystem linearSystem) {
        int iD = this.f31161e.d();
        SolverVariable solverVariable = null;
        float f3 = 0.0f;
        float f4 = 0.0f;
        boolean z2 = false;
        boolean z3 = false;
        SolverVariable solverVariable2 = null;
        for (int i3 = 0; i3 < iD; i3++) {
            float fL = this.f31161e.l(i3);
            SolverVariable solverVariableF = this.f31161e.f(i3);
            if (solverVariableF.f31241k == SolverVariable.Type.UNRESTRICTED) {
                if (solverVariable == null || f3 > fL) {
                    boolean zU = u(solverVariableF, linearSystem);
                    z2 = zU;
                    f3 = fL;
                    solverVariable = solverVariableF;
                } else if (!z2 && u(solverVariableF, linearSystem)) {
                    f3 = fL;
                    solverVariable = solverVariableF;
                    z2 = true;
                }
            } else if (solverVariable == null && fL < 0.0f) {
                if (solverVariable2 == null || f4 > fL) {
                    boolean zU2 = u(solverVariableF, linearSystem);
                    z3 = zU2;
                    f4 = fL;
                    solverVariable2 = solverVariableF;
                } else if (!z3 && u(solverVariableF, linearSystem)) {
                    f4 = fL;
                    solverVariable2 = solverVariableF;
                    z3 = true;
                }
            }
        }
        return solverVariable != null ? solverVariable : solverVariable2;
    }

    @Override // androidx.constraintlayout.core.LinearSystem.Row
    public SolverVariable getKey() {
        return this.f31157a;
    }

    ArrayRow h(SolverVariable solverVariable, SolverVariable solverVariable2, int i3, float f3, SolverVariable solverVariable3, SolverVariable solverVariable4, int i4) {
        if (solverVariable2 == solverVariable3) {
            this.f31161e.k(solverVariable, 1.0f);
            this.f31161e.k(solverVariable4, 1.0f);
            this.f31161e.k(solverVariable2, -2.0f);
            return this;
        }
        if (f3 == 0.5f) {
            this.f31161e.k(solverVariable, 1.0f);
            this.f31161e.k(solverVariable2, -1.0f);
            this.f31161e.k(solverVariable3, -1.0f);
            this.f31161e.k(solverVariable4, 1.0f);
            if (i3 > 0 || i4 > 0) {
                this.f31158b = (-i3) + i4;
                return this;
            }
        } else {
            if (f3 <= 0.0f) {
                this.f31161e.k(solverVariable, -1.0f);
                this.f31161e.k(solverVariable2, 1.0f);
                this.f31158b = i3;
                return this;
            }
            if (f3 >= 1.0f) {
                this.f31161e.k(solverVariable4, -1.0f);
                this.f31161e.k(solverVariable3, 1.0f);
                this.f31158b = -i4;
                return this;
            }
            float f4 = 1.0f - f3;
            this.f31161e.k(solverVariable, f4 * 1.0f);
            this.f31161e.k(solverVariable2, f4 * (-1.0f));
            this.f31161e.k(solverVariable3, (-1.0f) * f3);
            this.f31161e.k(solverVariable4, 1.0f * f3);
            if (i3 > 0 || i4 > 0) {
                this.f31158b = ((-i3) * f4) + (i4 * f3);
                return this;
            }
        }
        return this;
    }

    ArrayRow i(SolverVariable solverVariable, int i3) {
        this.f31157a = solverVariable;
        float f3 = i3;
        solverVariable.f31237g = f3;
        this.f31158b = f3;
        this.f31162f = true;
        return this;
    }

    @Override // androidx.constraintlayout.core.LinearSystem.Row
    public boolean isEmpty() {
        return this.f31157a == null && this.f31158b == 0.0f && this.f31161e.d() == 0;
    }

    ArrayRow j(SolverVariable solverVariable, SolverVariable solverVariable2, float f3) {
        this.f31161e.k(solverVariable, -1.0f);
        this.f31161e.k(solverVariable2, f3);
        return this;
    }

    public ArrayRow k(SolverVariable solverVariable, SolverVariable solverVariable2, SolverVariable solverVariable3, SolverVariable solverVariable4, float f3) {
        this.f31161e.k(solverVariable, -1.0f);
        this.f31161e.k(solverVariable2, 1.0f);
        this.f31161e.k(solverVariable3, f3);
        this.f31161e.k(solverVariable4, -f3);
        return this;
    }

    public ArrayRow l(float f3, float f4, float f5, SolverVariable solverVariable, SolverVariable solverVariable2, SolverVariable solverVariable3, SolverVariable solverVariable4) {
        this.f31158b = 0.0f;
        if (f4 == 0.0f || f3 == f5) {
            this.f31161e.k(solverVariable, 1.0f);
            this.f31161e.k(solverVariable2, -1.0f);
            this.f31161e.k(solverVariable4, 1.0f);
            this.f31161e.k(solverVariable3, -1.0f);
            return this;
        }
        if (f3 == 0.0f) {
            this.f31161e.k(solverVariable, 1.0f);
            this.f31161e.k(solverVariable2, -1.0f);
            return this;
        }
        if (f5 == 0.0f) {
            this.f31161e.k(solverVariable3, 1.0f);
            this.f31161e.k(solverVariable4, -1.0f);
            return this;
        }
        float f6 = (f3 / f4) / (f5 / f4);
        this.f31161e.k(solverVariable, 1.0f);
        this.f31161e.k(solverVariable2, -1.0f);
        this.f31161e.k(solverVariable4, f6);
        this.f31161e.k(solverVariable3, -f6);
        return this;
    }

    public ArrayRow m(SolverVariable solverVariable, int i3) {
        if (i3 < 0) {
            this.f31158b = i3 * (-1);
            this.f31161e.k(solverVariable, 1.0f);
            return this;
        }
        this.f31158b = i3;
        this.f31161e.k(solverVariable, -1.0f);
        return this;
    }

    public ArrayRow n(SolverVariable solverVariable, SolverVariable solverVariable2, int i3) {
        boolean z2 = false;
        if (i3 != 0) {
            if (i3 < 0) {
                i3 *= -1;
                z2 = true;
            }
            this.f31158b = i3;
        }
        if (z2) {
            this.f31161e.k(solverVariable, 1.0f);
            this.f31161e.k(solverVariable2, -1.0f);
            return this;
        }
        this.f31161e.k(solverVariable, -1.0f);
        this.f31161e.k(solverVariable2, 1.0f);
        return this;
    }

    public ArrayRow o(SolverVariable solverVariable, SolverVariable solverVariable2, SolverVariable solverVariable3, int i3) {
        boolean z2 = false;
        if (i3 != 0) {
            if (i3 < 0) {
                i3 *= -1;
                z2 = true;
            }
            this.f31158b = i3;
        }
        if (z2) {
            this.f31161e.k(solverVariable, 1.0f);
            this.f31161e.k(solverVariable2, -1.0f);
            this.f31161e.k(solverVariable3, -1.0f);
            return this;
        }
        this.f31161e.k(solverVariable, -1.0f);
        this.f31161e.k(solverVariable2, 1.0f);
        this.f31161e.k(solverVariable3, 1.0f);
        return this;
    }

    public ArrayRow p(SolverVariable solverVariable, SolverVariable solverVariable2, SolverVariable solverVariable3, int i3) {
        boolean z2 = false;
        if (i3 != 0) {
            if (i3 < 0) {
                i3 *= -1;
                z2 = true;
            }
            this.f31158b = i3;
        }
        if (z2) {
            this.f31161e.k(solverVariable, 1.0f);
            this.f31161e.k(solverVariable2, -1.0f);
            this.f31161e.k(solverVariable3, 1.0f);
            return this;
        }
        this.f31161e.k(solverVariable, -1.0f);
        this.f31161e.k(solverVariable2, 1.0f);
        this.f31161e.k(solverVariable3, -1.0f);
        return this;
    }

    public ArrayRow q(SolverVariable solverVariable, SolverVariable solverVariable2, SolverVariable solverVariable3, SolverVariable solverVariable4, float f3) {
        this.f31161e.k(solverVariable3, 0.5f);
        this.f31161e.k(solverVariable4, 0.5f);
        this.f31161e.k(solverVariable, -0.5f);
        this.f31161e.k(solverVariable2, -0.5f);
        this.f31158b = -f3;
        return this;
    }

    void r() {
        float f3 = this.f31158b;
        if (f3 < 0.0f) {
            this.f31158b = f3 * (-1.0f);
            this.f31161e.h();
        }
    }

    boolean s() {
        SolverVariable solverVariable = this.f31157a;
        if (solverVariable != null) {
            return solverVariable.f31241k == SolverVariable.Type.UNRESTRICTED || this.f31158b >= 0.0f;
        }
        return false;
    }

    boolean t(SolverVariable solverVariable) {
        return this.f31161e.e(solverVariable);
    }

    public String toString() {
        return z();
    }

    public SolverVariable v(SolverVariable solverVariable) {
        return w(null, solverVariable);
    }

    void x(SolverVariable solverVariable) {
        SolverVariable solverVariable2 = this.f31157a;
        if (solverVariable2 != null) {
            this.f31161e.k(solverVariable2, -1.0f);
            this.f31157a.f31235d = -1;
            this.f31157a = null;
        }
        float fI = this.f31161e.i(solverVariable, true) * (-1.0f);
        this.f31157a = solverVariable;
        if (fI == 1.0f) {
            return;
        }
        this.f31158b /= fI;
        this.f31161e.n(fI);
    }

    public void y() {
        this.f31157a = null;
        this.f31161e.clear();
        this.f31158b = 0.0f;
        this.f31162f = false;
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00d1  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    java.lang.String z() {
        /*
            Method dump skipped, instruction units count: 257
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.ArrayRow.z():java.lang.String");
    }

    public ArrayRow(Cache cache) {
        this.f31161e = new ArrayLinkedVariables(this, cache);
    }
}
