package androidx.constraintlayout.core;

import java.util.Arrays;
import java.util.HashSet;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public class SolverVariable implements Comparable<SolverVariable> {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private static int f31231s = 1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f31232a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f31233b;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public float f31237g;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    Type f31241k;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f31234c = -1;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    int f31235d = -1;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f31236f = 0;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f31238h = false;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    float[] f31239i = new float[9];

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    float[] f31240j = new float[9];

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    ArrayRow[] f31242l = new ArrayRow[16];

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    int f31243m = 0;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f31244n = 0;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    boolean f31245o = false;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    int f31246p = -1;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    float f31247q = 0.0f;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    HashSet f31248r = null;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public enum Type {
        UNRESTRICTED,
        CONSTANT,
        SLACK,
        ERROR,
        UNKNOWN
    }

    public SolverVariable(Type type, String str) {
        this.f31241k = type;
    }

    static void c() {
        f31231s++;
    }

    public final void a(ArrayRow arrayRow) {
        int i3 = 0;
        while (true) {
            int i4 = this.f31243m;
            if (i3 >= i4) {
                ArrayRow[] arrayRowArr = this.f31242l;
                if (i4 >= arrayRowArr.length) {
                    this.f31242l = (ArrayRow[]) Arrays.copyOf(arrayRowArr, arrayRowArr.length * 2);
                }
                ArrayRow[] arrayRowArr2 = this.f31242l;
                int i5 = this.f31243m;
                arrayRowArr2[i5] = arrayRow;
                this.f31243m = i5 + 1;
                return;
            }
            if (this.f31242l[i3] == arrayRow) {
                return;
            } else {
                i3++;
            }
        }
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public int compareTo(SolverVariable solverVariable) {
        return this.f31234c - solverVariable.f31234c;
    }

    public final void d(ArrayRow arrayRow) {
        int i3 = this.f31243m;
        int i4 = 0;
        while (i4 < i3) {
            if (this.f31242l[i4] == arrayRow) {
                while (i4 < i3 - 1) {
                    ArrayRow[] arrayRowArr = this.f31242l;
                    int i5 = i4 + 1;
                    arrayRowArr[i4] = arrayRowArr[i5];
                    i4 = i5;
                }
                this.f31243m--;
                return;
            }
            i4++;
        }
    }

    public void e() {
        this.f31233b = null;
        this.f31241k = Type.UNKNOWN;
        this.f31236f = 0;
        this.f31234c = -1;
        this.f31235d = -1;
        this.f31237g = 0.0f;
        this.f31238h = false;
        this.f31245o = false;
        this.f31246p = -1;
        this.f31247q = 0.0f;
        int i3 = this.f31243m;
        for (int i4 = 0; i4 < i3; i4++) {
            this.f31242l[i4] = null;
        }
        this.f31243m = 0;
        this.f31244n = 0;
        this.f31232a = false;
        Arrays.fill(this.f31240j, 0.0f);
    }

    public void f(LinearSystem linearSystem, float f3) {
        this.f31237g = f3;
        this.f31238h = true;
        this.f31245o = false;
        this.f31246p = -1;
        this.f31247q = 0.0f;
        int i3 = this.f31243m;
        this.f31235d = -1;
        for (int i4 = 0; i4 < i3; i4++) {
            this.f31242l[i4].A(linearSystem, this, false);
        }
        this.f31243m = 0;
    }

    public void g(Type type, String str) {
        this.f31241k = type;
    }

    public final void h(LinearSystem linearSystem, ArrayRow arrayRow) {
        int i3 = this.f31243m;
        for (int i4 = 0; i4 < i3; i4++) {
            this.f31242l[i4].B(linearSystem, arrayRow, false);
        }
        this.f31243m = 0;
    }

    public String toString() {
        if (this.f31233b != null) {
            return "" + this.f31233b;
        }
        return "" + this.f31234c;
    }
}
