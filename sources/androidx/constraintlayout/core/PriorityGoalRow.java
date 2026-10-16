package androidx.constraintlayout.core;

import androidx.constraintlayout.core.ArrayRow;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import cz.mobilesoft.coreblock.storage.room.dao.cI.KrzujOtzIk;
import java.util.Arrays;
import java.util.Comparator;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public class PriorityGoalRow extends ArrayRow {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f31221g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private SolverVariable[] f31222h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private SolverVariable[] f31223i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int f31224j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    GoalVariableAccessor f31225k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    Cache f31226l;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    /* JADX INFO: loaded from: classes2.dex */
    class GoalVariableAccessor {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        SolverVariable f31228a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        PriorityGoalRow f31229b;

        GoalVariableAccessor(PriorityGoalRow priorityGoalRow) {
            this.f31229b = priorityGoalRow;
        }

        public boolean a(SolverVariable solverVariable, float f3) {
            boolean z2 = true;
            if (!this.f31228a.f31232a) {
                for (int i3 = 0; i3 < 9; i3++) {
                    float f4 = solverVariable.f31240j[i3];
                    if (f4 != 0.0f) {
                        float f5 = f4 * f3;
                        if (Math.abs(f5) < 1.0E-4f) {
                            f5 = 0.0f;
                        }
                        this.f31228a.f31240j[i3] = f5;
                    } else {
                        this.f31228a.f31240j[i3] = 0.0f;
                    }
                }
                return true;
            }
            for (int i4 = 0; i4 < 9; i4++) {
                float[] fArr = this.f31228a.f31240j;
                float f6 = fArr[i4] + (solverVariable.f31240j[i4] * f3);
                fArr[i4] = f6;
                if (Math.abs(f6) < 1.0E-4f) {
                    this.f31228a.f31240j[i4] = 0.0f;
                } else {
                    z2 = false;
                }
            }
            if (z2) {
                PriorityGoalRow.this.G(this.f31228a);
            }
            return false;
        }

        public void b(SolverVariable solverVariable) {
            this.f31228a = solverVariable;
        }

        public final boolean c() {
            for (int i3 = 8; i3 >= 0; i3--) {
                float f3 = this.f31228a.f31240j[i3];
                if (f3 > 0.0f) {
                    return false;
                }
                if (f3 < 0.0f) {
                    return true;
                }
            }
            return false;
        }

        public final boolean d(SolverVariable solverVariable) {
            int i3 = 8;
            while (true) {
                if (i3 < 0) {
                    break;
                }
                float f3 = solverVariable.f31240j[i3];
                float f4 = this.f31228a.f31240j[i3];
                if (f4 == f3) {
                    i3--;
                } else if (f4 < f3) {
                    return true;
                }
            }
            return false;
        }

        public void e() {
            Arrays.fill(this.f31228a.f31240j, 0.0f);
        }

        public String toString() {
            SolverVariable solverVariable = this.f31228a;
            String str = KrzujOtzIk.qmrkiu;
            if (solverVariable != null) {
                for (int i3 = 0; i3 < 9; i3++) {
                    str = str + this.f31228a.f31240j[i3] + " ";
                }
            }
            return str + "] " + this.f31228a;
        }
    }

    public PriorityGoalRow(Cache cache) {
        super(cache);
        this.f31221g = ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        this.f31222h = new SolverVariable[ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD];
        this.f31223i = new SolverVariable[ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD];
        this.f31224j = 0;
        this.f31225k = new GoalVariableAccessor(this);
        this.f31226l = cache;
    }

    private void F(SolverVariable solverVariable) {
        int i3;
        int i4 = this.f31224j + 1;
        SolverVariable[] solverVariableArr = this.f31222h;
        if (i4 > solverVariableArr.length) {
            SolverVariable[] solverVariableArr2 = (SolverVariable[]) Arrays.copyOf(solverVariableArr, solverVariableArr.length * 2);
            this.f31222h = solverVariableArr2;
            this.f31223i = (SolverVariable[]) Arrays.copyOf(solverVariableArr2, solverVariableArr2.length * 2);
        }
        SolverVariable[] solverVariableArr3 = this.f31222h;
        int i5 = this.f31224j;
        solverVariableArr3[i5] = solverVariable;
        int i6 = i5 + 1;
        this.f31224j = i6;
        if (i6 > 1 && solverVariableArr3[i5].f31234c > solverVariable.f31234c) {
            int i7 = 0;
            while (true) {
                i3 = this.f31224j;
                if (i7 >= i3) {
                    break;
                }
                this.f31223i[i7] = this.f31222h[i7];
                i7++;
            }
            Arrays.sort(this.f31223i, 0, i3, new Comparator<SolverVariable>() { // from class: androidx.constraintlayout.core.PriorityGoalRow.1
                @Override // java.util.Comparator
                /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                public int compare(SolverVariable solverVariable2, SolverVariable solverVariable3) {
                    return solverVariable2.f31234c - solverVariable3.f31234c;
                }
            });
            for (int i8 = 0; i8 < this.f31224j; i8++) {
                this.f31222h[i8] = this.f31223i[i8];
            }
        }
        solverVariable.f31232a = true;
        solverVariable.a(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void G(SolverVariable solverVariable) {
        int i3 = 0;
        while (i3 < this.f31224j) {
            if (this.f31222h[i3] == solverVariable) {
                while (true) {
                    int i4 = this.f31224j;
                    if (i3 >= i4 - 1) {
                        this.f31224j = i4 - 1;
                        solverVariable.f31232a = false;
                        return;
                    } else {
                        SolverVariable[] solverVariableArr = this.f31222h;
                        int i5 = i3 + 1;
                        solverVariableArr[i3] = solverVariableArr[i5];
                        i3 = i5;
                    }
                }
            } else {
                i3++;
            }
        }
    }

    @Override // androidx.constraintlayout.core.ArrayRow
    public void B(LinearSystem linearSystem, ArrayRow arrayRow, boolean z2) {
        SolverVariable solverVariable = arrayRow.f31157a;
        if (solverVariable == null) {
            return;
        }
        ArrayRow.ArrayRowVariables arrayRowVariables = arrayRow.f31161e;
        int iD = arrayRowVariables.d();
        for (int i3 = 0; i3 < iD; i3++) {
            SolverVariable solverVariableF = arrayRowVariables.f(i3);
            float fL = arrayRowVariables.l(i3);
            this.f31225k.b(solverVariableF);
            if (this.f31225k.a(solverVariable, fL)) {
                F(solverVariableF);
            }
            this.f31158b += arrayRow.f31158b * fL;
        }
        G(solverVariable);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x002e  */
    @Override // androidx.constraintlayout.core.ArrayRow, androidx.constraintlayout.core.LinearSystem.Row
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public androidx.constraintlayout.core.SolverVariable b(androidx.constraintlayout.core.LinearSystem r5, boolean[] r6) {
        /*
            r4 = this;
            r5 = -1
            r0 = 0
            r1 = r5
        L3:
            int r2 = r4.f31224j
            if (r0 >= r2) goto L32
            androidx.constraintlayout.core.SolverVariable[] r2 = r4.f31222h
            r2 = r2[r0]
            int r3 = r2.f31234c
            boolean r3 = r6[r3]
            if (r3 == 0) goto L12
            goto L2f
        L12:
            androidx.constraintlayout.core.PriorityGoalRow$GoalVariableAccessor r3 = r4.f31225k
            r3.b(r2)
            if (r1 != r5) goto L22
            androidx.constraintlayout.core.PriorityGoalRow$GoalVariableAccessor r2 = r4.f31225k
            boolean r2 = r2.c()
            if (r2 == 0) goto L2f
            goto L2e
        L22:
            androidx.constraintlayout.core.PriorityGoalRow$GoalVariableAccessor r2 = r4.f31225k
            androidx.constraintlayout.core.SolverVariable[] r3 = r4.f31222h
            r3 = r3[r1]
            boolean r2 = r2.d(r3)
            if (r2 == 0) goto L2f
        L2e:
            r1 = r0
        L2f:
            int r0 = r0 + 1
            goto L3
        L32:
            if (r1 != r5) goto L36
            r5 = 0
            return r5
        L36:
            androidx.constraintlayout.core.SolverVariable[] r5 = r4.f31222h
            r5 = r5[r1]
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.PriorityGoalRow.b(androidx.constraintlayout.core.LinearSystem, boolean[]):androidx.constraintlayout.core.SolverVariable");
    }

    @Override // androidx.constraintlayout.core.ArrayRow, androidx.constraintlayout.core.LinearSystem.Row
    public void c(SolverVariable solverVariable) {
        this.f31225k.b(solverVariable);
        this.f31225k.e();
        solverVariable.f31240j[solverVariable.f31236f] = 1.0f;
        F(solverVariable);
    }

    @Override // androidx.constraintlayout.core.ArrayRow, androidx.constraintlayout.core.LinearSystem.Row
    public void clear() {
        this.f31224j = 0;
        this.f31158b = 0.0f;
    }

    @Override // androidx.constraintlayout.core.ArrayRow, androidx.constraintlayout.core.LinearSystem.Row
    public boolean isEmpty() {
        return this.f31224j == 0;
    }

    @Override // androidx.constraintlayout.core.ArrayRow
    public String toString() {
        String str = " goal -> (" + this.f31158b + ") : ";
        for (int i3 = 0; i3 < this.f31224j; i3++) {
            this.f31225k.b(this.f31222h[i3]);
            str = str + this.f31225k + " ";
        }
        return str;
    }
}
